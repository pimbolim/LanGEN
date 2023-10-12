package androidx.compose.foundation;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Image.kt */
public final class ImageKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    public static final /* synthetic */ void Image(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        int i3 = i;
        Intrinsics.checkNotNullParameter(imageBitmap, "bitmap");
        Composer startRestartGroup = composer.startRestartGroup(-816801505);
        ComposerKt.sourceInformation(startRestartGroup, "C(Image)P(2,4,6!1,5)94@4502L177:Image.kt#71ulvw");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        m202Image5hnEew(imageBitmap, str, modifier2, center, fit, f2, colorFilter2, FilterQuality.Companion.m1682getLowfv9h1I(), startRestartGroup, (i3 & 112) | 8 | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3), 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ImageKt$Image$1(imageBitmap, str, modifier2, center, fit, f2, colorFilter2, i, i2));
        }
    }

    /* renamed from: Image-5h-nEew  reason: not valid java name */
    public static final void m202Image5hnEew(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Composer composer, int i2, int i3) {
        int i4;
        int i5;
        ImageBitmap imageBitmap2 = imageBitmap;
        int i6 = i3;
        Intrinsics.checkNotNullParameter(imageBitmap2, "bitmap");
        Composer startRestartGroup = composer.startRestartGroup(-816798969);
        ComposerKt.sourceInformation(startRestartGroup, "C(Image)P(2,4,7!1,5!,6:c#ui.graphics.FilterQuality)150@7115L73,151@7193L248:Image.kt#71ulvw");
        Modifier modifier2 = (i6 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i6 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i6 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i6 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i6 & 64) != 0 ? null : colorFilter;
        if ((i6 & 128) != 0) {
            i4 = DrawScope.Companion.m2094getDefaultFilterQualityfv9h1I();
            i5 = i2 & -29360129;
        } else {
            i4 = i;
            i5 = i2;
        }
        startRestartGroup.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed((Object) imageBitmap2);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = BitmapPainterKt.m2178BitmapPainterQZhYCtY$default(imageBitmap, 0, 0, i4, 6, (Object) null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        Image((BitmapPainter) rememberedValue, str, modifier2, center, fit, f2, colorFilter2, startRestartGroup, (i5 & 112) | 8 | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5), 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ImageKt$Image$2(imageBitmap, str, modifier2, center, fit, f2, colorFilter2, i4, i2, i3));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0158  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Image(androidx.compose.ui.graphics.vector.ImageVector r20, java.lang.String r21, androidx.compose.ui.Modifier r22, androidx.compose.ui.Alignment r23, androidx.compose.ui.layout.ContentScale r24, float r25, androidx.compose.ui.graphics.ColorFilter r26, androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            r1 = r20
            r8 = r28
            java.lang.String r0 = "imageVector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = -816796834(0xffffffffcf50ab5e, float:-3.50089165E9)
            r2 = r27
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Image)P(5,3,6!1,4)194@9195L34,193@9174L237:Image.kt#71ulvw"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r29 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r8 | 6
            goto L_0x002e
        L_0x001e:
            r2 = r8 & 14
            if (r2 != 0) goto L_0x002d
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r8
            goto L_0x002e
        L_0x002d:
            r2 = r8
        L_0x002e:
            r3 = r29 & 2
            if (r3 == 0) goto L_0x0035
            r2 = r2 | 48
            goto L_0x0048
        L_0x0035:
            r3 = r8 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0048
            r3 = r21
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0044
            r4 = 32
            goto L_0x0046
        L_0x0044:
            r4 = 16
        L_0x0046:
            r2 = r2 | r4
            goto L_0x004a
        L_0x0048:
            r3 = r21
        L_0x004a:
            r4 = r29 & 4
            if (r4 == 0) goto L_0x0051
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r5 = r8 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0064
            r5 = r22
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0060
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r2 = r2 | r6
            goto L_0x0066
        L_0x0064:
            r5 = r22
        L_0x0066:
            r6 = r29 & 8
            if (r6 == 0) goto L_0x006d
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r7 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0080
            r7 = r23
            boolean r9 = r0.changed((java.lang.Object) r7)
            if (r9 == 0) goto L_0x007c
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r9
            goto L_0x0082
        L_0x0080:
            r7 = r23
        L_0x0082:
            r9 = r29 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x008c
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008c:
            r11 = r8 & r10
            if (r11 != 0) goto L_0x009f
            r11 = r24
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x009b
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r2 = r2 | r12
            goto L_0x00a1
        L_0x009f:
            r11 = r24
        L_0x00a1:
            r12 = r29 & 32
            r13 = 458752(0x70000, float:6.42848E-40)
            if (r12 == 0) goto L_0x00ab
            r14 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r14
            goto L_0x00be
        L_0x00ab:
            r14 = r8 & r13
            if (r14 != 0) goto L_0x00be
            r14 = r25
            boolean r15 = r0.changed((float) r14)
            if (r15 == 0) goto L_0x00ba
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00ba:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r2 = r2 | r15
            goto L_0x00c0
        L_0x00be:
            r14 = r25
        L_0x00c0:
            r15 = r29 & 64
            r16 = 3670016(0x380000, float:5.142788E-39)
            if (r15 == 0) goto L_0x00cd
            r17 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r17
            r13 = r26
            goto L_0x00e0
        L_0x00cd:
            r17 = r8 & r16
            r13 = r26
            if (r17 != 0) goto L_0x00e0
            boolean r17 = r0.changed((java.lang.Object) r13)
            if (r17 == 0) goto L_0x00dc
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r2 = r2 | r17
        L_0x00e0:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r17 = r2 & r17
            r18 = 599186(0x92492, float:8.39638E-40)
            r17 = r17 ^ r18
            if (r17 != 0) goto L_0x00fa
            boolean r17 = r0.getSkipping()
            if (r17 != 0) goto L_0x00f3
            goto L_0x00fa
        L_0x00f3:
            r0.skipToGroupEnd()
            r4 = r5
            r5 = r11
            r6 = r14
            goto L_0x0151
        L_0x00fa:
            if (r4 == 0) goto L_0x0101
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x0102
        L_0x0101:
            r4 = r5
        L_0x0102:
            if (r6 == 0) goto L_0x010b
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenter()
            r7 = r5
        L_0x010b:
            if (r9 == 0) goto L_0x0114
            androidx.compose.ui.layout.ContentScale$Companion r5 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r5 = r5.getFit()
            goto L_0x0115
        L_0x0114:
            r5 = r11
        L_0x0115:
            if (r12 == 0) goto L_0x011a
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x011b
        L_0x011a:
            r6 = r14
        L_0x011b:
            if (r15 == 0) goto L_0x0121
            r9 = 0
            r19 = r9
            goto L_0x0123
        L_0x0121:
            r19 = r13
        L_0x0123:
            r9 = r2 & 14
            androidx.compose.ui.graphics.vector.VectorPainter r9 = androidx.compose.ui.graphics.vector.VectorPainterKt.rememberVectorPainter(r1, r0, r9)
            androidx.compose.ui.graphics.painter.Painter r9 = (androidx.compose.ui.graphics.painter.Painter) r9
            int r11 = androidx.compose.ui.graphics.vector.VectorPainter.$stable
            r12 = r2 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            r12 = r2 & 896(0x380, float:1.256E-42)
            r11 = r11 | r12
            r12 = r2 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | r12
            r10 = r10 & r2
            r10 = r10 | r11
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r2
            r10 = r10 | r11
            r2 = r2 & r16
            r17 = r10 | r2
            r18 = 0
            r10 = r21
            r11 = r4
            r12 = r7
            r13 = r5
            r14 = r6
            r15 = r19
            r16 = r0
            Image((androidx.compose.ui.graphics.painter.Painter) r9, (java.lang.String) r10, (androidx.compose.ui.Modifier) r11, (androidx.compose.ui.Alignment) r12, (androidx.compose.ui.layout.ContentScale) r13, (float) r14, (androidx.compose.ui.graphics.ColorFilter) r15, (androidx.compose.runtime.Composer) r16, (int) r17, (int) r18)
            r13 = r19
        L_0x0151:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x0158
            goto L_0x016e
        L_0x0158:
            androidx.compose.foundation.ImageKt$Image$3 r11 = new androidx.compose.foundation.ImageKt$Image$3
            r0 = r11
            r1 = r20
            r2 = r21
            r3 = r4
            r4 = r7
            r7 = r13
            r8 = r28
            r9 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x016e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ImageKt.Image(androidx.compose.ui.graphics.vector.ImageVector, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void Image(Painter painter, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Composer composer, int i, int i2) {
        Modifier modifier2;
        String str2 = str;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer startRestartGroup = composer.startRestartGroup(-816794549);
        ComposerKt.sourceInformation(startRestartGroup, "C(Image)P(6,3,5!1,4)251@11796L341:Image.kt#71ulvw");
        Modifier modifier3 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i2 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i2 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f2 = (i2 & 32) != 0 ? 1.0f : f;
        ColorFilter colorFilter2 = (i2 & 64) != 0 ? null : colorFilter;
        startRestartGroup.startReplaceableGroup(-816794258);
        ComposerKt.sourceInformation(startRestartGroup, "241@11532L103");
        if (str2 != null) {
            Modifier modifier4 = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(-3686930);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) str2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ImageKt$Image$semantics$1$1(str2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            modifier2 = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) rememberedValue, 1, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        startRestartGroup.endReplaceableGroup();
        Modifier paint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(modifier3.then(modifier2)), painter, false, center, fit, f2, colorFilter2, 2, (Object) null);
        MeasurePolicy measurePolicy = ImageKt$Image$5.INSTANCE;
        startRestartGroup.startReplaceableGroup(1376089394);
        ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(paint$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r7 = Updater.m1234constructorimpl(startRestartGroup);
        Updater.m1241setimpl(r7, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m1241setimpl(r7, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m1241setimpl(r7, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m1241setimpl(r7, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-820198811);
        ComposerKt.sourceInformation(startRestartGroup, "C:Image.kt#71ulvw");
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ImageKt$Image$6(painter, str, modifier3, center, fit, f2, colorFilter2, i, i2));
        }
    }
}
