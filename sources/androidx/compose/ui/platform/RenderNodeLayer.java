package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0002\\]B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\bH\u0016J\u001d\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u0018\u00102\u001a\u00020\b2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u000fH\u0016J%\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020/2\u0006\u00105\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109J\u001d\u0010:\u001a\u00020\b2\u0006\u0010.\u001a\u00020;H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=J\u001d\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020@H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u0010=J*\u0010B\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\b\u0010C\u001a\u00020\bH\u0002J\b\u0010D\u001a\u00020\bH\u0016J\u0001\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020G2\u0006\u0010J\u001a\u00020G2\u0006\u0010K\u001a\u00020G2\u0006\u0010L\u001a\u00020G2\u0006\u0010M\u001a\u00020G2\u0006\u0010N\u001a\u00020G2\u0006\u0010O\u001a\u00020G2\u0006\u0010P\u001a\u00020G2\u0006\u0010%\u001a\u00020&2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u000f2\b\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bZ\u0010[R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u000e\u0010\"\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010%\u001a\u00020&X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010'\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006^"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "drawnWithZ", "", "isDestroyed", "value", "isDirty", "setDirty", "(Z)V", "layerId", "", "getLayerId", "()J", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "renderNode", "softwareLayerPaint", "Landroidx/compose/ui/graphics/Paint;", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "clipRenderNode", "canvas", "destroy", "drawLayer", "invalidate", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "triggerRepaint", "updateDisplayList", "updateLayerProperties", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "updateLayerProperties-YPkPJjM", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)V", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderNodeLayer.android.kt */
public final class RenderNodeLayer implements OwnedLayer, GraphicLayerInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Function2<DeviceRenderNode, Matrix, Unit> getMatrix = RenderNodeLayer$Companion$getMatrix$1.INSTANCE;
    private final CanvasHolder canvasHolder = new CanvasHolder();
    private Function1<? super Canvas, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isDestroyed;
    private boolean isDirty;
    private final LayerMatrixCache<DeviceRenderNode> matrixCache = new LayerMatrixCache<>(getMatrix);
    private final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;
    private final DeviceRenderNode renderNode;
    private Paint softwareLayerPaint;
    private long transformOrigin = TransformOrigin.Companion.m1955getCenterSzJe1aQ();

    public RenderNodeLayer(AndroidComposeView androidComposeView, Function1<? super Canvas, Unit> function1, Function0<Unit> function0) {
        DeviceRenderNode deviceRenderNode;
        Intrinsics.checkNotNullParameter(androidComposeView, "ownerView");
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        this.ownerView = androidComposeView;
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
        this.outlineResolver = new OutlineResolver(androidComposeView.getDensity());
        if (Build.VERSION.SDK_INT >= 29) {
            deviceRenderNode = new RenderNodeApi29(androidComposeView);
        } else {
            deviceRenderNode = new RenderNodeApi23(androidComposeView);
        }
        deviceRenderNode.setHasOverlappingRendering(true);
        this.renderNode = deviceRenderNode;
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui_release(this, z);
        }
    }

    public long getLayerId() {
        return this.renderNode.getUniqueId();
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.Companion.getUniqueDrawingId(this.ownerView);
        }
        return -1;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$UniqueDrawingIdApi29;", "", "()V", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RenderNodeLayer.android.kt */
    private static final class UniqueDrawingIdApi29 {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            return Companion.getUniqueDrawingId(view);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$UniqueDrawingIdApi29$Companion;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: RenderNodeLayer.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final long getUniqueDrawingId(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                return view.getUniqueDrawingId();
            }
        }
    }

    /* renamed from: updateLayerProperties-YPkPJjM  reason: not valid java name */
    public void m3449updateLayerPropertiesYPkPJjM(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, LayoutDirection layoutDirection, Density density) {
        Function0<Unit> function0;
        Shape shape2 = shape;
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        this.transformOrigin = j;
        boolean z2 = true;
        boolean z3 = this.renderNode.getClipToOutline() && !this.outlineResolver.getOutlineClipSupported();
        float f11 = f;
        this.renderNode.setScaleX(f);
        float f12 = f2;
        this.renderNode.setScaleY(f2);
        float f13 = f3;
        this.renderNode.setAlpha(f3);
        this.renderNode.setTranslationX(f4);
        this.renderNode.setTranslationY(f5);
        this.renderNode.setElevation(f6);
        this.renderNode.setRotationZ(f9);
        this.renderNode.setRotationX(f7);
        this.renderNode.setRotationY(f8);
        this.renderNode.setCameraDistance(f10);
        this.renderNode.setPivotX(TransformOrigin.m1950getPivotFractionXimpl(j) * ((float) this.renderNode.getWidth()));
        this.renderNode.setPivotY(TransformOrigin.m1951getPivotFractionYimpl(j) * ((float) this.renderNode.getHeight()));
        this.renderNode.setClipToOutline(z && shape2 != RectangleShapeKt.getRectangleShape());
        this.renderNode.setClipToBounds(z && shape2 == RectangleShapeKt.getRectangleShape());
        this.renderNode.setRenderEffect(renderEffect);
        boolean update = this.outlineResolver.update(shape, this.renderNode.getAlpha(), this.renderNode.getClipToOutline(), this.renderNode.getElevation(), layoutDirection, density);
        this.renderNode.setOutline(this.outlineResolver.getOutline());
        if (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            z2 = false;
        }
        if (z3 != z2 || (z2 && update)) {
            invalidate();
        } else {
            triggerRepaint();
        }
        if (!this.drawnWithZ && this.renderNode.getElevation() > 0.0f && (function0 = this.invalidateParentLayer) != null) {
            function0.invoke();
        }
        this.matrixCache.invalidate();
    }

    /* renamed from: isInLayer-k-4lQ0M  reason: not valid java name */
    public boolean m3445isInLayerk4lQ0M(long j) {
        float r0 = Offset.m1353getXimpl(j);
        float r1 = Offset.m1354getYimpl(j);
        if (this.renderNode.getClipToBounds()) {
            if (0.0f > r0 || r0 >= ((float) this.renderNode.getWidth()) || 0.0f > r1 || r1 >= ((float) this.renderNode.getHeight())) {
                return false;
            }
            return true;
        } else if (this.renderNode.getClipToOutline()) {
            return this.outlineResolver.m3443isInOutlinek4lQ0M(j);
        } else {
            return true;
        }
    }

    /* renamed from: resize-ozmzZPI  reason: not valid java name */
    public void m3448resizeozmzZPI(long j) {
        int r0 = IntSize.m4019getWidthimpl(j);
        int r7 = IntSize.m4018getHeightimpl(j);
        float f = (float) r0;
        this.renderNode.setPivotX(TransformOrigin.m1950getPivotFractionXimpl(this.transformOrigin) * f);
        float f2 = (float) r7;
        this.renderNode.setPivotY(TransformOrigin.m1951getPivotFractionYimpl(this.transformOrigin) * f2);
        DeviceRenderNode deviceRenderNode = this.renderNode;
        if (deviceRenderNode.setPosition(deviceRenderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getLeft() + r0, this.renderNode.getTop() + r7)) {
            this.outlineResolver.m3444updateuvyYCjk(SizeKt.Size(f, f2));
            this.renderNode.setOutline(this.outlineResolver.getOutline());
            invalidate();
            this.matrixCache.invalidate();
        }
    }

    /* renamed from: move--gyyYBs  reason: not valid java name */
    public void m3447movegyyYBs(long j) {
        int left = this.renderNode.getLeft();
        int top = this.renderNode.getTop();
        int r2 = IntOffset.m3977getXimpl(j);
        int r4 = IntOffset.m3978getYimpl(j);
        if (left != r2 || top != r4) {
            this.renderNode.offsetLeftAndRight(r2 - left);
            this.renderNode.offsetTopAndBottom(r4 - top);
            triggerRepaint();
            this.matrixCache.invalidate();
        }
    }

    public void invalidate() {
        if (!this.isDirty && !this.isDestroyed) {
            this.ownerView.invalidate();
            setDirty(true);
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    public void drawLayer(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        boolean z = false;
        if (nativeCanvas.isHardwareAccelerated()) {
            updateDisplayList();
            if (this.renderNode.getElevation() > 0.0f) {
                z = true;
            }
            this.drawnWithZ = z;
            if (z) {
                canvas.enableZ();
            }
            this.renderNode.drawInto(nativeCanvas);
            if (this.drawnWithZ) {
                canvas.disableZ();
                return;
            }
            return;
        }
        float left = (float) this.renderNode.getLeft();
        float top = (float) this.renderNode.getTop();
        float right = (float) this.renderNode.getRight();
        float bottom = (float) this.renderNode.getBottom();
        if (this.renderNode.getAlpha() < 1.0f) {
            Paint paint = this.softwareLayerPaint;
            if (paint == null) {
                paint = AndroidPaint_androidKt.Paint();
                this.softwareLayerPaint = paint;
            }
            paint.setAlpha(this.renderNode.getAlpha());
            nativeCanvas.saveLayer(left, top, right, bottom, paint.asFrameworkPaint());
        } else {
            canvas.save();
        }
        canvas.translate(left, top);
        canvas.m1564concat58bKbWc(this.matrixCache.m3427calculateMatrixGrdbGEg(this.renderNode));
        clipRenderNode(canvas);
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke(canvas);
        }
        canvas.restore();
        setDirty(false);
    }

    private final void clipRenderNode(Canvas canvas) {
        if (this.renderNode.getClipToOutline() || this.renderNode.getClipToBounds()) {
            this.outlineResolver.clipToOutline(canvas);
        }
    }

    public void updateDisplayList() {
        Path path;
        if (this.isDirty || !this.renderNode.getHasDisplayList()) {
            setDirty(false);
            if (!this.renderNode.getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
                path = null;
            } else {
                path = this.outlineResolver.getClipPath();
            }
            Function1<? super Canvas, Unit> function1 = this.drawBlock;
            if (function1 != null) {
                this.renderNode.record(this.canvasHolder, path, function1);
            }
        }
    }

    public void destroy() {
        if (this.renderNode.getHasDisplayList()) {
            this.renderNode.discardDisplayList();
        }
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        this.ownerView.requestClearInvalidObservations();
        this.ownerView.recycle$ui_release(this);
    }

    /* renamed from: mapOffset-8S9VItk  reason: not valid java name */
    public long m3446mapOffset8S9VItk(long j, boolean z) {
        if (!z) {
            return androidx.compose.ui.graphics.Matrix.m1773mapMKHz9U(this.matrixCache.m3427calculateMatrixGrdbGEg(this.renderNode), j);
        }
        float[] r4 = this.matrixCache.m3426calculateInverseMatrixbWbORWo(this.renderNode);
        Offset r2 = r4 == null ? null : Offset.m1342boximpl(androidx.compose.ui.graphics.Matrix.m1773mapMKHz9U(r4, j));
        return r2 == null ? Offset.Companion.m1367getInfiniteF1C5BW0() : r2.m1363unboximpl();
    }

    public void mapBounds(MutableRect mutableRect, boolean z) {
        Intrinsics.checkNotNullParameter(mutableRect, "rect");
        if (z) {
            float[] r3 = this.matrixCache.m3426calculateInverseMatrixbWbORWo(this.renderNode);
            if (r3 == null) {
                mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            } else {
                androidx.compose.ui.graphics.Matrix.m1775mapimpl(r3, mutableRect);
            }
        } else {
            androidx.compose.ui.graphics.Matrix.m1775mapimpl(this.matrixCache.m3427calculateMatrixGrdbGEg(this.renderNode), mutableRect);
        }
    }

    public void reuseLayer(Function1<? super Canvas, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        setDirty(false);
        this.isDestroyed = false;
        this.drawnWithZ = false;
        this.transformOrigin = TransformOrigin.Companion.m1955getCenterSzJe1aQ();
        this.drawBlock = function1;
        this.invalidateParentLayer = function0;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeLayer$Companion;", "", "()V", "getMatrix", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "Landroid/graphics/Matrix;", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RenderNodeLayer.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
