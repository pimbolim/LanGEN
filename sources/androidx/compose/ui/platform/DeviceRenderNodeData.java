package androidx.compose.ui.platform;

import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bI\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\fHÆ\u0003J\t\u0010M\u001a\u00020\fHÆ\u0003J\t\u0010N\u001a\u00020\fHÆ\u0003J\t\u0010O\u001a\u00020\fHÆ\u0003J\t\u0010P\u001a\u00020\fHÆ\u0003J\t\u0010Q\u001a\u00020\fHÆ\u0003J\t\u0010R\u001a\u00020\fHÆ\u0003J\t\u0010S\u001a\u00020\fHÆ\u0003J\t\u0010T\u001a\u00020\fHÆ\u0003J\t\u0010U\u001a\u00020\u0018HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0018HÆ\u0003J\t\u0010X\u001a\u00020\fHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\t\u0010_\u001a\u00020\fHÆ\u0003J\t\u0010`\u001a\u00020\fHÆ\u0003Jç\u0001\u0010a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÆ\u0001J\u0013\u0010b\u001a\u00020\u00182\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010d\u001a\u00020\u0005HÖ\u0001J\t\u0010e\u001a\u00020fHÖ\u0001R\u001a\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001a\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u001a\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u001a\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010#R\u001a\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001f\"\u0004\b:\u0010!R\u001a\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010!R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001f\"\u0004\b@\u0010!R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001f\"\u0004\bB\u0010!R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010#R\u001a\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001f\"\u0004\bE\u0010!R\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u001f\"\u0004\bG\u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010#¨\u0006g"}, d2 = {"Landroidx/compose/ui/platform/DeviceRenderNodeData;", "", "uniqueId", "", "left", "", "top", "right", "bottom", "width", "height", "scaleX", "", "scaleY", "translationX", "translationY", "elevation", "rotationZ", "rotationX", "rotationY", "cameraDistance", "pivotX", "pivotY", "clipToOutline", "", "clipToBounds", "alpha", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "(JIIIIIIFFFFFFFFFFFZZFLandroidx/compose/ui/graphics/RenderEffect;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getBottom", "()I", "getCameraDistance", "setCameraDistance", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "getClipToOutline", "setClipToOutline", "getElevation", "setElevation", "getHeight", "getLeft", "getPivotX", "setPivotX", "getPivotY", "setPivotY", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "getRight", "getRotationX", "setRotationX", "getRotationY", "setRotationY", "getRotationZ", "setRotationZ", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getTop", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "getUniqueId", "()J", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceRenderNode.android.kt */
public final class DeviceRenderNodeData {
    private float alpha;
    private final int bottom;
    private float cameraDistance;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private float elevation;
    private final int height;
    private final int left;
    private float pivotX;
    private float pivotY;
    private RenderEffect renderEffect;
    private final int right;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private final int top;
    private float translationX;
    private float translationY;
    private final long uniqueId;
    private final int width;

    public static /* synthetic */ DeviceRenderNodeData copy$default(DeviceRenderNodeData deviceRenderNodeData, long j, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean z, boolean z2, float f12, RenderEffect renderEffect2, int i7, Object obj) {
        DeviceRenderNodeData deviceRenderNodeData2 = deviceRenderNodeData;
        int i8 = i7;
        return deviceRenderNodeData.copy((i8 & 1) != 0 ? deviceRenderNodeData2.uniqueId : j, (i8 & 2) != 0 ? deviceRenderNodeData2.left : i, (i8 & 4) != 0 ? deviceRenderNodeData2.top : i2, (i8 & 8) != 0 ? deviceRenderNodeData2.right : i3, (i8 & 16) != 0 ? deviceRenderNodeData2.bottom : i4, (i8 & 32) != 0 ? deviceRenderNodeData2.width : i5, (i8 & 64) != 0 ? deviceRenderNodeData2.height : i6, (i8 & 128) != 0 ? deviceRenderNodeData2.scaleX : f, (i8 & 256) != 0 ? deviceRenderNodeData2.scaleY : f2, (i8 & 512) != 0 ? deviceRenderNodeData2.translationX : f3, (i8 & 1024) != 0 ? deviceRenderNodeData2.translationY : f4, (i8 & 2048) != 0 ? deviceRenderNodeData2.elevation : f5, (i8 & 4096) != 0 ? deviceRenderNodeData2.rotationZ : f6, (i8 & 8192) != 0 ? deviceRenderNodeData2.rotationX : f7, (i8 & 16384) != 0 ? deviceRenderNodeData2.rotationY : f8, (i8 & 32768) != 0 ? deviceRenderNodeData2.cameraDistance : f9, (i8 & 65536) != 0 ? deviceRenderNodeData2.pivotX : f10, (i8 & 131072) != 0 ? deviceRenderNodeData2.pivotY : f11, (i8 & 262144) != 0 ? deviceRenderNodeData2.clipToOutline : z, (i8 & 524288) != 0 ? deviceRenderNodeData2.clipToBounds : z2, (i8 & 1048576) != 0 ? deviceRenderNodeData2.alpha : f12, (i8 & 2097152) != 0 ? deviceRenderNodeData2.renderEffect : renderEffect2);
    }

    public final long component1() {
        return this.uniqueId;
    }

    public final float component10() {
        return this.translationX;
    }

    public final float component11() {
        return this.translationY;
    }

    public final float component12() {
        return this.elevation;
    }

    public final float component13() {
        return this.rotationZ;
    }

    public final float component14() {
        return this.rotationX;
    }

    public final float component15() {
        return this.rotationY;
    }

    public final float component16() {
        return this.cameraDistance;
    }

    public final float component17() {
        return this.pivotX;
    }

    public final float component18() {
        return this.pivotY;
    }

    public final boolean component19() {
        return this.clipToOutline;
    }

    public final int component2() {
        return this.left;
    }

    public final boolean component20() {
        return this.clipToBounds;
    }

    public final float component21() {
        return this.alpha;
    }

    public final RenderEffect component22() {
        return this.renderEffect;
    }

    public final int component3() {
        return this.top;
    }

    public final int component4() {
        return this.right;
    }

    public final int component5() {
        return this.bottom;
    }

    public final int component6() {
        return this.width;
    }

    public final int component7() {
        return this.height;
    }

    public final float component8() {
        return this.scaleX;
    }

    public final float component9() {
        return this.scaleY;
    }

    public final DeviceRenderNodeData copy(long j, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean z, boolean z2, float f12, RenderEffect renderEffect2) {
        return new DeviceRenderNodeData(j, i, i2, i3, i4, i5, i6, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, z, z2, f12, renderEffect2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceRenderNodeData)) {
            return false;
        }
        DeviceRenderNodeData deviceRenderNodeData = (DeviceRenderNodeData) obj;
        return this.uniqueId == deviceRenderNodeData.uniqueId && this.left == deviceRenderNodeData.left && this.top == deviceRenderNodeData.top && this.right == deviceRenderNodeData.right && this.bottom == deviceRenderNodeData.bottom && this.width == deviceRenderNodeData.width && this.height == deviceRenderNodeData.height && Intrinsics.areEqual((Object) Float.valueOf(this.scaleX), (Object) Float.valueOf(deviceRenderNodeData.scaleX)) && Intrinsics.areEqual((Object) Float.valueOf(this.scaleY), (Object) Float.valueOf(deviceRenderNodeData.scaleY)) && Intrinsics.areEqual((Object) Float.valueOf(this.translationX), (Object) Float.valueOf(deviceRenderNodeData.translationX)) && Intrinsics.areEqual((Object) Float.valueOf(this.translationY), (Object) Float.valueOf(deviceRenderNodeData.translationY)) && Intrinsics.areEqual((Object) Float.valueOf(this.elevation), (Object) Float.valueOf(deviceRenderNodeData.elevation)) && Intrinsics.areEqual((Object) Float.valueOf(this.rotationZ), (Object) Float.valueOf(deviceRenderNodeData.rotationZ)) && Intrinsics.areEqual((Object) Float.valueOf(this.rotationX), (Object) Float.valueOf(deviceRenderNodeData.rotationX)) && Intrinsics.areEqual((Object) Float.valueOf(this.rotationY), (Object) Float.valueOf(deviceRenderNodeData.rotationY)) && Intrinsics.areEqual((Object) Float.valueOf(this.cameraDistance), (Object) Float.valueOf(deviceRenderNodeData.cameraDistance)) && Intrinsics.areEqual((Object) Float.valueOf(this.pivotX), (Object) Float.valueOf(deviceRenderNodeData.pivotX)) && Intrinsics.areEqual((Object) Float.valueOf(this.pivotY), (Object) Float.valueOf(deviceRenderNodeData.pivotY)) && this.clipToOutline == deviceRenderNodeData.clipToOutline && this.clipToBounds == deviceRenderNodeData.clipToBounds && Intrinsics.areEqual((Object) Float.valueOf(this.alpha), (Object) Float.valueOf(deviceRenderNodeData.alpha)) && Intrinsics.areEqual((Object) this.renderEffect, (Object) deviceRenderNodeData.renderEffect);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.uniqueId) * 31) + this.left) * 31) + this.top) * 31) + this.right) * 31) + this.bottom) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.scaleX)) * 31) + Float.floatToIntBits(this.scaleY)) * 31) + Float.floatToIntBits(this.translationX)) * 31) + Float.floatToIntBits(this.translationY)) * 31) + Float.floatToIntBits(this.elevation)) * 31) + Float.floatToIntBits(this.rotationZ)) * 31) + Float.floatToIntBits(this.rotationX)) * 31) + Float.floatToIntBits(this.rotationY)) * 31) + Float.floatToIntBits(this.cameraDistance)) * 31) + Float.floatToIntBits(this.pivotX)) * 31) + Float.floatToIntBits(this.pivotY)) * 31;
        boolean z = this.clipToOutline;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.clipToBounds;
        if (!z3) {
            z2 = z3;
        }
        int floatToIntBits = (((i + (z2 ? 1 : 0)) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        RenderEffect renderEffect2 = this.renderEffect;
        return floatToIntBits + (renderEffect2 == null ? 0 : renderEffect2.hashCode());
    }

    public String toString() {
        return "DeviceRenderNodeData(uniqueId=" + this.uniqueId + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", width=" + this.width + ", height=" + this.height + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", elevation=" + this.elevation + ", rotationZ=" + this.rotationZ + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", cameraDistance=" + this.cameraDistance + ", pivotX=" + this.pivotX + ", pivotY=" + this.pivotY + ", clipToOutline=" + this.clipToOutline + ", clipToBounds=" + this.clipToBounds + ", alpha=" + this.alpha + ", renderEffect=" + this.renderEffect + ')';
    }

    public DeviceRenderNodeData(long j, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, boolean z, boolean z2, float f12, RenderEffect renderEffect2) {
        this.uniqueId = j;
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
        this.width = i5;
        this.height = i6;
        this.scaleX = f;
        this.scaleY = f2;
        this.translationX = f3;
        this.translationY = f4;
        this.elevation = f5;
        this.rotationZ = f6;
        this.rotationX = f7;
        this.rotationY = f8;
        this.cameraDistance = f9;
        this.pivotX = f10;
        this.pivotY = f11;
        this.clipToOutline = z;
        this.clipToBounds = z2;
        this.alpha = f12;
        this.renderEffect = renderEffect2;
    }

    public final long getUniqueId() {
        return this.uniqueId;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final float getScaleX() {
        return this.scaleX;
    }

    public final void setScaleX(float f) {
        this.scaleX = f;
    }

    public final float getScaleY() {
        return this.scaleY;
    }

    public final void setScaleY(float f) {
        this.scaleY = f;
    }

    public final float getTranslationX() {
        return this.translationX;
    }

    public final void setTranslationX(float f) {
        this.translationX = f;
    }

    public final float getTranslationY() {
        return this.translationY;
    }

    public final void setTranslationY(float f) {
        this.translationY = f;
    }

    public final float getElevation() {
        return this.elevation;
    }

    public final void setElevation(float f) {
        this.elevation = f;
    }

    public final float getRotationZ() {
        return this.rotationZ;
    }

    public final void setRotationZ(float f) {
        this.rotationZ = f;
    }

    public final float getRotationX() {
        return this.rotationX;
    }

    public final void setRotationX(float f) {
        this.rotationX = f;
    }

    public final float getRotationY() {
        return this.rotationY;
    }

    public final void setRotationY(float f) {
        this.rotationY = f;
    }

    public final float getCameraDistance() {
        return this.cameraDistance;
    }

    public final void setCameraDistance(float f) {
        this.cameraDistance = f;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final void setPivotX(float f) {
        this.pivotX = f;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final void setPivotY(float f) {
        this.pivotY = f;
    }

    public final boolean getClipToOutline() {
        return this.clipToOutline;
    }

    public final void setClipToOutline(boolean z) {
        this.clipToOutline = z;
    }

    public final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    public final void setClipToBounds(boolean z) {
        this.clipToBounds = z;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    public final void setRenderEffect(RenderEffect renderEffect2) {
        this.renderEffect = renderEffect2;
    }
}
