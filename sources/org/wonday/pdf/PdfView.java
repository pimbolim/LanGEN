package org.wonday.pdf;

import android.graphics.Canvas;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.link.LinkHandler;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageScrollListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.github.barteksc.pdfviewer.model.LinkTapEvent;
import com.github.barteksc.pdfviewer.util.Constants;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.google.gson.Gson;
import com.shockwave.pdfium.util.SizeF;
import java.io.File;
import java.io.FileNotFoundException;

public class PdfView extends PDFView implements OnPageChangeListener, OnLoadCompleteListener, OnErrorListener, OnTapListener, OnDrawListener, OnPageScrollListener, LinkHandler {
    private static PdfView instance;
    private String asset;
    private boolean autoSpacing = false;
    private ThemedReactContext context;
    private boolean enableAnnotationRendering = true;
    private boolean enableAntialiasing = true;
    private boolean enablePaging = false;
    private FitPolicy fitPolicy = FitPolicy.WIDTH;
    private boolean horizontal = false;
    private float lastPageHeight = 0.0f;
    private float lastPageWidth = 0.0f;
    private float maxScale = 3.0f;
    private float minScale = 1.0f;
    private float originalWidth = 0.0f;
    private int page = 1;
    private boolean pageFling = false;
    private boolean pageSnap = false;
    private String password = "";
    private String path;
    private float scale = 1.0f;
    private boolean singlePage = false;
    private int spacing = 10;

    public PdfView(ThemedReactContext themedReactContext, AttributeSet attributeSet) {
        super(themedReactContext, attributeSet);
        this.context = themedReactContext;
        instance = this;
    }

    public void onPageChanged(int i, int i2) {
        int i3 = i + 1;
        this.page = i3;
        showLog(String.format("%s %s / %s", new Object[]{this.path, Integer.valueOf(i3), Integer.valueOf(i2)}));
        WritableMap createMap = Arguments.createMap();
        createMap.putString(GraphQLConstants.Keys.MESSAGE, "pageChanged|" + i3 + "|" + i2);
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
    }

    public void loadComplete(int i) {
        SizeF pageSize = getPageSize(0);
        float width = pageSize.getWidth();
        float height = pageSize.getHeight();
        zoomTo(this.scale);
        WritableMap createMap = Arguments.createMap();
        Gson gson = new Gson();
        createMap.putString(GraphQLConstants.Keys.MESSAGE, "loadComplete|" + i + "|" + width + "|" + height + "|" + gson.toJson((Object) getTableOfContents()));
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
    }

    public void onError(Throwable th) {
        WritableMap createMap = Arguments.createMap();
        if (th.getMessage().contains("Password required or incorrect password")) {
            createMap.putString(GraphQLConstants.Keys.MESSAGE, "error|Password required or incorrect password.");
        } else {
            createMap.putString(GraphQLConstants.Keys.MESSAGE, "error|" + th.getMessage());
        }
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
    }

    public void onPageScrolled(int i, float f) {
        Constants.Pinch.MINIMUM_ZOOM = this.minScale;
        Constants.Pinch.MAXIMUM_ZOOM = this.maxScale;
    }

    public boolean onTap(MotionEvent motionEvent) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(GraphQLConstants.Keys.MESSAGE, "pageSingleTap|" + this.page + "|" + motionEvent.getX() + "|" + motionEvent.getY());
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
        return true;
    }

    public void onLayerDrawn(Canvas canvas, float f, float f2, int i) {
        if (this.originalWidth == 0.0f) {
            this.originalWidth = f;
        }
        float f3 = this.lastPageWidth;
        if (f3 > 0.0f) {
            float f4 = this.lastPageHeight;
            if (f4 > 0.0f && !(f == f3 && f2 == f4)) {
                Constants.Pinch.MINIMUM_ZOOM = this.minScale;
                Constants.Pinch.MAXIMUM_ZOOM = this.maxScale;
                WritableMap createMap = Arguments.createMap();
                createMap.putString(GraphQLConstants.Keys.MESSAGE, "scaleChanged|" + (f / this.originalWidth));
                ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
            }
        }
        this.lastPageWidth = f;
        this.lastPageHeight = f2;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isRecycled()) {
            drawPdf();
        }
    }

    public void drawPdf() {
        PDFView.Configurator configurator;
        showLog(String.format("drawPdf path:%s %s", new Object[]{this.path, Integer.valueOf(this.page)}));
        if (this.path != null) {
            setMinZoom(this.minScale);
            setMaxZoom(this.maxScale);
            setMidZoom((this.maxScale + this.minScale) / 2.0f);
            Constants.Pinch.MINIMUM_ZOOM = this.minScale;
            Constants.Pinch.MAXIMUM_ZOOM = this.maxScale;
            if (this.path.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT)) {
                try {
                    configurator = fromStream(getContext().getContentResolver().openInputStream(Uri.parse(this.path)));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e.getMessage());
                }
            } else {
                configurator = fromUri(getURI(this.path));
            }
            configurator.defaultPage(this.page - 1).swipeHorizontal(this.horizontal).onPageChange(this).onLoad(this).onError(this).onDraw(this).onPageScroll(this).spacing(this.spacing).password(this.password).enableAntialiasing(this.enableAntialiasing).pageFitPolicy(this.fitPolicy).pageSnap(this.pageSnap).autoSpacing(this.autoSpacing).pageFling(this.pageFling).enableSwipe(!this.singlePage).enableDoubletap(!this.singlePage).enableAnnotationRendering(this.enableAnnotationRendering).linkHandler(this);
            if (this.singlePage) {
                configurator.pages(this.page - 1);
                setTouchesEnabled(false);
            } else {
                configurator.onTap(this);
            }
            configurator.load();
        }
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPage(int i) {
        if (i <= 1) {
            i = 1;
        }
        this.page = i;
    }

    public void setScale(float f) {
        this.scale = f;
    }

    public void setMinScale(float f) {
        this.minScale = f;
    }

    public void setMaxScale(float f) {
        this.maxScale = f;
    }

    public void setHorizontal(boolean z) {
        this.horizontal = z;
    }

    public void setSpacing(int i) {
        this.spacing = i;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setEnableAntialiasing(boolean z) {
        this.enableAntialiasing = z;
    }

    public void setEnableAnnotationRendering(boolean z) {
        this.enableAnnotationRendering = z;
    }

    public void setEnablePaging(boolean z) {
        this.enablePaging = z;
        if (z) {
            this.autoSpacing = true;
            this.pageFling = true;
            this.pageSnap = true;
            return;
        }
        this.autoSpacing = false;
        this.pageFling = false;
        this.pageSnap = false;
    }

    public void setFitPolicy(int i) {
        if (i == 0) {
            this.fitPolicy = FitPolicy.WIDTH;
        } else if (i != 1) {
            this.fitPolicy = FitPolicy.BOTH;
        } else {
            this.fitPolicy = FitPolicy.HEIGHT;
        }
    }

    public void setSinglePage(boolean z) {
        this.singlePage = z;
    }

    public void handleLinkEvent(LinkTapEvent linkTapEvent) {
        String uri = linkTapEvent.getLink().getUri();
        Integer destPageIdx = linkTapEvent.getLink().getDestPageIdx();
        if (uri != null && !uri.isEmpty()) {
            handleUri(uri);
        } else if (destPageIdx != null) {
            handlePage(destPageIdx.intValue());
        }
    }

    private void handleUri(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(GraphQLConstants.Keys.MESSAGE, "linkPressed|" + str);
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
    }

    private void handlePage(int i) {
        jumpTo(i);
    }

    private void showLog(String str) {
        Log.d("PdfView", str);
    }

    private Uri getURI(String str) {
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null || parse.getScheme().isEmpty()) {
            return Uri.fromFile(new File(str));
        }
        return parse;
    }

    private void setTouchesEnabled(boolean z) {
        setTouchesEnabled(this, z);
    }

    private static void setTouchesEnabled(View view, boolean z) {
        if (z) {
            view.setOnTouchListener((View.OnTouchListener) null);
        } else {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                setTouchesEnabled(viewGroup.getChildAt(i), z);
            }
        }
    }
}
