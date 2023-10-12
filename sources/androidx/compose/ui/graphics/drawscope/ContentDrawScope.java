package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContentDrawScope.kt */
public interface ContentDrawScope extends DrawScope {
    void drawContent();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContentDrawScope.kt */
    public static final class DefaultImpls {
        /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
        public static void m2055drawImageAZ2fEMs(ContentDrawScope contentDrawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2) {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            Intrinsics.checkNotNullParameter(contentDrawScope2, "this");
            ImageBitmap imageBitmap2 = imageBitmap;
            Intrinsics.checkNotNullParameter(imageBitmap2, "image");
            DrawStyle drawStyle2 = drawStyle;
            Intrinsics.checkNotNullParameter(drawStyle2, "style");
            DrawScope.DefaultImpls.m2100drawImageAZ2fEMs(contentDrawScope2, imageBitmap2, j, j2, j3, j4, f, drawStyle2, colorFilter, i, i2);
        }

        /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
        public static long m2056getCenterF1C5BW0(ContentDrawScope contentDrawScope) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2115getCenterF1C5BW0(contentDrawScope);
        }

        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public static long m2057getSizeNHjbRc(ContentDrawScope contentDrawScope) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2116getSizeNHjbRc(contentDrawScope);
        }

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m2058roundToPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2118roundToPxR2X_6o(contentDrawScope, j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m2059roundToPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2119roundToPx0680j_4(contentDrawScope, f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m2060toDpGaN1DYA(ContentDrawScope contentDrawScope, long j) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2120toDpGaN1DYA(contentDrawScope, j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m2061toDpu2uoSUM(ContentDrawScope contentDrawScope, float f) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2121toDpu2uoSUM((DrawScope) contentDrawScope, f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m2062toDpu2uoSUM(ContentDrawScope contentDrawScope, int i) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2122toDpu2uoSUM((DrawScope) contentDrawScope, i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m2063toDpSizekrfVVM(ContentDrawScope contentDrawScope, long j) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2123toDpSizekrfVVM(contentDrawScope, j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m2064toPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2124toPxR2X_6o(contentDrawScope, j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m2065toPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2125toPx0680j_4(contentDrawScope, f);
        }

        public static Rect toRect(ContentDrawScope contentDrawScope, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            Intrinsics.checkNotNullParameter(dpRect, "receiver");
            return DrawScope.DefaultImpls.toRect(contentDrawScope, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m2066toSizeXkaWNTQ(ContentDrawScope contentDrawScope, long j) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2126toSizeXkaWNTQ(contentDrawScope, j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m2067toSp0xMU5do(ContentDrawScope contentDrawScope, float f) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2127toSp0xMU5do(contentDrawScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m2068toSpkPz2Gy4(ContentDrawScope contentDrawScope, float f) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2128toSpkPz2Gy4((DrawScope) contentDrawScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m2069toSpkPz2Gy4(ContentDrawScope contentDrawScope, int i) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "this");
            return DrawScope.DefaultImpls.m2129toSpkPz2Gy4((DrawScope) contentDrawScope, i);
        }
    }
}
