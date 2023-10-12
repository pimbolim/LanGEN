package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020YH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\u0010\u0010\\\u001a\u00020V2\u0006\u0010]\u001a\u00020^H\u0016J\u0010\u0010_\u001a\u00020V2\u0006\u0010]\u001a\u00020^H\u0016J\u0010\u0010`\u001a\u00020V2\u0006\u0010a\u001a\u00020\rH\u0016J\u0010\u0010b\u001a\u00020V2\u0006\u0010a\u001a\u00020\rH\u0016J.\u0010c\u001a\u00020V2\u0006\u0010d\u001a\u00020e2\b\u0010f\u001a\u0004\u0018\u00010g2\u0012\u0010h\u001a\u000e\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00020V0iH\u0016J\u0010\u0010k\u001a\u00020\u00132\u0006\u0010l\u001a\u00020\u0013H\u0016J\u0012\u0010m\u001a\u00020V2\b\u0010n\u001a\u0004\u0018\u00010oH\u0016J(\u0010p\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\r2\u0006\u0010G\u001a\u00020\r2\u0006\u00106\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00138V@VX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00138V@VX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR\u0014\u0010\u001f\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0016R\u0014\u0010!\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000fR\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R$\u0010)\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010\u000bR$\u0010,\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b-\u0010\t\"\u0004\b.\u0010\u000bR(\u0010/\u001a\u0004\u0018\u00010$2\b\u0010\u0005\u001a\u0004\u0018\u00010$8V@VX\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u000fR$\u00108\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b9\u0010\t\"\u0004\b:\u0010\u000bR$\u0010;\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b<\u0010\t\"\u0004\b=\u0010\u000bR$\u0010>\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR$\u0010A\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bB\u0010\t\"\u0004\bC\u0010\u000bR$\u0010D\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000bR\u0014\u0010G\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u000fR$\u0010I\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bJ\u0010\t\"\u0004\bK\u0010\u000bR$\u0010L\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bM\u0010\t\"\u0004\bN\u0010\u000bR\u0014\u0010O\u001a\u00020P8VX\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u000f¨\u0006q"}, d2 = {"Landroidx/compose/ui/platform/RenderNodeApi29;", "Landroidx/compose/ui/platform/DeviceRenderNode;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "bottom", "", "getBottom", "()I", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clipToBounds", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "clipToOutline", "getClipToOutline", "setClipToOutline", "elevation", "getElevation", "setElevation", "hasDisplayList", "getHasDisplayList", "height", "getHeight", "internalRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "left", "getLeft", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/graphics/RenderNode;", "right", "getRight", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "top", "getTop", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "uniqueId", "", "getUniqueId", "()J", "width", "getWidth", "discardDisplayList", "", "drawInto", "canvas", "Landroid/graphics/Canvas;", "dumpRenderNodeData", "Landroidx/compose/ui/platform/DeviceRenderNodeData;", "getInverseMatrix", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "offsetLeftAndRight", "offset", "offsetTopAndBottom", "record", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipPath", "Landroidx/compose/ui/graphics/Path;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "setHasOverlappingRendering", "hasOverlappingRendering", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderNodeApi29.android.kt */
public final class RenderNodeApi29 implements DeviceRenderNode {
    private RenderEffect internalRenderEffect;
    private final AndroidComposeView ownerView;
    private final RenderNode renderNode = new RenderNode("Compose");

    public RenderNodeApi29(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "ownerView");
        this.ownerView = androidComposeView;
    }

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public long getUniqueId() {
        return this.renderNode.getUniqueId();
    }

    public int getLeft() {
        return this.renderNode.getLeft();
    }

    public int getTop() {
        return this.renderNode.getTop();
    }

    public int getRight() {
        return this.renderNode.getRight();
    }

    public int getBottom() {
        return this.renderNode.getBottom();
    }

    public int getWidth() {
        return this.renderNode.getWidth();
    }

    public int getHeight() {
        return this.renderNode.getHeight();
    }

    public float getScaleX() {
        return this.renderNode.getScaleX();
    }

    public void setScaleX(float f) {
        this.renderNode.setScaleX(f);
    }

    public float getScaleY() {
        return this.renderNode.getScaleY();
    }

    public void setScaleY(float f) {
        this.renderNode.setScaleY(f);
    }

    public float getTranslationX() {
        return this.renderNode.getTranslationX();
    }

    public void setTranslationX(float f) {
        this.renderNode.setTranslationX(f);
    }

    public float getTranslationY() {
        return this.renderNode.getTranslationY();
    }

    public void setTranslationY(float f) {
        this.renderNode.setTranslationY(f);
    }

    public float getElevation() {
        return this.renderNode.getElevation();
    }

    public void setElevation(float f) {
        this.renderNode.setElevation(f);
    }

    public float getRotationZ() {
        return this.renderNode.getRotationZ();
    }

    public void setRotationZ(float f) {
        this.renderNode.setRotationZ(f);
    }

    public float getRotationX() {
        return this.renderNode.getRotationX();
    }

    public void setRotationX(float f) {
        this.renderNode.setRotationX(f);
    }

    public float getRotationY() {
        return this.renderNode.getRotationY();
    }

    public void setRotationY(float f) {
        this.renderNode.setRotationY(f);
    }

    public float getCameraDistance() {
        return this.renderNode.getCameraDistance();
    }

    public void setCameraDistance(float f) {
        this.renderNode.setCameraDistance(f);
    }

    public float getPivotX() {
        return this.renderNode.getPivotX();
    }

    public void setPivotX(float f) {
        this.renderNode.setPivotX(f);
    }

    public float getPivotY() {
        return this.renderNode.getPivotY();
    }

    public void setPivotY(float f) {
        this.renderNode.setPivotY(f);
    }

    public boolean getClipToOutline() {
        return this.renderNode.getClipToOutline();
    }

    public void setClipToOutline(boolean z) {
        this.renderNode.setClipToOutline(z);
    }

    public boolean getClipToBounds() {
        return this.renderNode.getClipToBounds();
    }

    public void setClipToBounds(boolean z) {
        this.renderNode.setClipToBounds(z);
    }

    public float getAlpha() {
        return this.renderNode.getAlpha();
    }

    public void setAlpha(float f) {
        this.renderNode.setAlpha(f);
    }

    public RenderEffect getRenderEffect() {
        return this.internalRenderEffect;
    }

    public void setRenderEffect(RenderEffect renderEffect) {
        this.internalRenderEffect = renderEffect;
        if (Build.VERSION.SDK_INT >= 31) {
            RenderNodeApi29VerificationHelper.INSTANCE.setRenderEffect(this.renderNode, renderEffect);
        }
    }

    public boolean getHasDisplayList() {
        return this.renderNode.hasDisplayList();
    }

    public void setOutline(Outline outline) {
        this.renderNode.setOutline(outline);
    }

    public boolean setPosition(int i, int i2, int i3, int i4) {
        return this.renderNode.setPosition(i, i2, i3, i4);
    }

    public void offsetLeftAndRight(int i) {
        this.renderNode.offsetLeftAndRight(i);
    }

    public void offsetTopAndBottom(int i) {
        this.renderNode.offsetTopAndBottom(i);
    }

    public void record(CanvasHolder canvasHolder, Path path, Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(canvasHolder, "canvasHolder");
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        RecordingCanvas beginRecording = this.renderNode.beginRecording();
        Intrinsics.checkNotNullExpressionValue(beginRecording, "renderNode.beginRecording()");
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(beginRecording);
        Canvas androidCanvas = canvasHolder.getAndroidCanvas();
        if (path != null) {
            androidCanvas.save();
            Canvas.DefaultImpls.m1572clipPathmtrdDE$default(androidCanvas, path, 0, 2, (Object) null);
        }
        function1.invoke(androidCanvas);
        if (path != null) {
            androidCanvas.restore();
        }
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        this.renderNode.endRecording();
    }

    public void getMatrix(Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.renderNode.getMatrix(matrix);
    }

    public void getInverseMatrix(Matrix matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        this.renderNode.getInverseMatrix(matrix);
    }

    public void drawInto(android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawRenderNode(this.renderNode);
    }

    public boolean setHasOverlappingRendering(boolean z) {
        return this.renderNode.setHasOverlappingRendering(z);
    }

    public DeviceRenderNodeData dumpRenderNodeData() {
        return new DeviceRenderNodeData(this.renderNode.getUniqueId(), this.renderNode.getLeft(), this.renderNode.getTop(), this.renderNode.getRight(), this.renderNode.getBottom(), this.renderNode.getWidth(), this.renderNode.getHeight(), this.renderNode.getScaleX(), this.renderNode.getScaleY(), this.renderNode.getTranslationX(), this.renderNode.getTranslationY(), this.renderNode.getElevation(), this.renderNode.getRotationZ(), this.renderNode.getRotationX(), this.renderNode.getRotationY(), this.renderNode.getCameraDistance(), this.renderNode.getPivotX(), this.renderNode.getPivotY(), this.renderNode.getClipToOutline(), this.renderNode.getClipToBounds(), this.renderNode.getAlpha(), this.internalRenderEffect);
    }

    public void discardDisplayList() {
        this.renderNode.discardDisplayList();
    }
}
