package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R \u0010\u000b\u001a\u00020\f8fX¦\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u0007R\u0018\u0010\u001d\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007R\u0018\u0010 \u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0005\"\u0004\b\"\u0010\u0007R\u0018\u0010#\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010\u0007R\u0018\u0010&\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0005\"\u0004\b(\u0010\u0007R\u0018\u0010)\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0005\"\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u00020-X¦\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R!\u00102\u001a\u000203X¦\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0018\u00108\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0005\"\u0004\b:\u0010\u0007R\u0018\u0010;\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0005\"\u0004\b=\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Landroidx/compose/ui/unit/Density;", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip$annotations", "()V", "getClip", "()Z", "setClip", "(Z)V", "<anonymous parameter 0>", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "getTransformOrigin-SzJe1aQ", "()J", "setTransformOrigin-__ExYCQ", "(J)V", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicsLayerScope.kt */
public interface GraphicsLayerScope extends Density {
    float getAlpha();

    float getCameraDistance();

    boolean getClip();

    RenderEffect getRenderEffect();

    float getRotationX();

    float getRotationY();

    float getRotationZ();

    float getScaleX();

    float getScaleY();

    float getShadowElevation();

    Shape getShape();

    /* renamed from: getTransformOrigin-SzJe1aQ  reason: not valid java name */
    long m1734getTransformOriginSzJe1aQ();

    float getTranslationX();

    float getTranslationY();

    void setAlpha(float f);

    void setCameraDistance(float f);

    void setClip(boolean z);

    void setRenderEffect(RenderEffect renderEffect);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    void setShape(Shape shape);

    /* renamed from: setTransformOrigin-__ExYCQ  reason: not valid java name */
    void m1735setTransformOrigin__ExYCQ(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GraphicsLayerScope.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getClip$annotations() {
        }

        public static RenderEffect getRenderEffect(GraphicsLayerScope graphicsLayerScope) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return null;
        }

        public static void setRenderEffect(GraphicsLayerScope graphicsLayerScope, RenderEffect renderEffect) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
        }

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m1736roundToPxR2X_6o(GraphicsLayerScope graphicsLayerScope, long j) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3833roundToPxR2X_6o(graphicsLayerScope, j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m1737roundToPx0680j_4(GraphicsLayerScope graphicsLayerScope, float f) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3834roundToPx0680j_4(graphicsLayerScope, f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m1738toDpGaN1DYA(GraphicsLayerScope graphicsLayerScope, long j) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3835toDpGaN1DYA(graphicsLayerScope, j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m1739toDpu2uoSUM(GraphicsLayerScope graphicsLayerScope, float f) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3836toDpu2uoSUM((Density) graphicsLayerScope, f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m1740toDpu2uoSUM(GraphicsLayerScope graphicsLayerScope, int i) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3837toDpu2uoSUM((Density) graphicsLayerScope, i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m1741toDpSizekrfVVM(GraphicsLayerScope graphicsLayerScope, long j) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3838toDpSizekrfVVM(graphicsLayerScope, j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m1742toPxR2X_6o(GraphicsLayerScope graphicsLayerScope, long j) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3839toPxR2X_6o(graphicsLayerScope, j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m1743toPx0680j_4(GraphicsLayerScope graphicsLayerScope, float f) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3840toPx0680j_4(graphicsLayerScope, f);
        }

        public static Rect toRect(GraphicsLayerScope graphicsLayerScope, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            Intrinsics.checkNotNullParameter(dpRect, "receiver");
            return Density.DefaultImpls.toRect(graphicsLayerScope, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m1744toSizeXkaWNTQ(GraphicsLayerScope graphicsLayerScope, long j) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3841toSizeXkaWNTQ(graphicsLayerScope, j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m1745toSp0xMU5do(GraphicsLayerScope graphicsLayerScope, float f) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3842toSp0xMU5do(graphicsLayerScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m1746toSpkPz2Gy4(GraphicsLayerScope graphicsLayerScope, float f) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3843toSpkPz2Gy4((Density) graphicsLayerScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m1747toSpkPz2Gy4(GraphicsLayerScope graphicsLayerScope, int i) {
            Intrinsics.checkNotNullParameter(graphicsLayerScope, "this");
            return Density.DefaultImpls.m3844toSpkPz2Gy4((Density) graphicsLayerScope, i);
        }
    }
}
