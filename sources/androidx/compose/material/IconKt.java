package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u000f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Icon.kt */
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = SizeKt.m492size3ABfNKs(Modifier.Companion, Dp.m3859constructorimpl((float) 24));

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1014Iconww6aTOc(androidx.compose.ui.graphics.vector.ImageVector r17, java.lang.String r18, androidx.compose.ui.Modifier r19, long r20, androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r1 = r17
            r6 = r23
            java.lang.String r0 = "imageVector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 1547382739(0x5c3b2fd3, float:2.10753616E17)
            r2 = r22
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Icon)P(1!,3:c#ui.graphics.Color)58@2530L7,58@2569L7,61@2610L34,60@2586L163:Icon.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r24 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r6 | 6
            goto L_0x002e
        L_0x001e:
            r2 = r6 & 14
            if (r2 != 0) goto L_0x002d
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r6
            goto L_0x002e
        L_0x002d:
            r2 = r6
        L_0x002e:
            r3 = r24 & 2
            if (r3 == 0) goto L_0x0035
            r2 = r2 | 48
            goto L_0x0048
        L_0x0035:
            r3 = r6 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0048
            r3 = r18
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
            r3 = r18
        L_0x004a:
            r4 = r24 & 4
            if (r4 == 0) goto L_0x0051
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r5 = r6 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0064
            r5 = r19
            boolean r7 = r0.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x0060
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r2 = r2 | r7
            goto L_0x0066
        L_0x0064:
            r5 = r19
        L_0x0066:
            r7 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007f
            r7 = r24 & 8
            if (r7 != 0) goto L_0x0079
            r7 = r20
            boolean r9 = r0.changed((long) r7)
            if (r9 == 0) goto L_0x007b
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x0079:
            r7 = r20
        L_0x007b:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r2 = r2 | r9
            goto L_0x0081
        L_0x007f:
            r7 = r20
        L_0x0081:
            r9 = r2 & 5851(0x16db, float:8.199E-42)
            r9 = r9 ^ 1170(0x492, float:1.64E-42)
            if (r9 != 0) goto L_0x0095
            boolean r9 = r0.getSkipping()
            if (r9 != 0) goto L_0x008e
            goto L_0x0095
        L_0x008e:
            r0.skipToGroupEnd()
            r4 = r5
            r15 = r7
            goto L_0x011a
        L_0x0095:
            r0.startDefaults()
            r9 = r6 & 1
            if (r9 == 0) goto L_0x00ae
            boolean r9 = r0.getDefaultsInvalid()
            if (r9 == 0) goto L_0x00a3
            goto L_0x00ae
        L_0x00a3:
            r0.skipToGroupEnd()
            r4 = r24 & 8
            if (r4 == 0) goto L_0x00ac
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00ac:
            r4 = r5
            goto L_0x00f8
        L_0x00ae:
            if (r4 == 0) goto L_0x00b5
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00b6
        L_0x00b5:
            r4 = r5
        L_0x00b6:
            r5 = r24 & 8
            if (r5 == 0) goto L_0x00f8
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r7 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r7, r8)
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.graphics.Color r5 = (androidx.compose.ui.graphics.Color) r5
            long r9 = r5.m1606unboximpl()
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r7, r8)
            java.lang.Object r5 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            java.lang.Number r5 = (java.lang.Number) r5
            float r11 = r5.floatValue()
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            long r7 = androidx.compose.ui.graphics.Color.m1595copywmQWz5c$default(r9, r11, r12, r13, r14, r15, r16)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00f8:
            r15 = r7
            r0.endDefaults()
            r5 = r2 & 14
            androidx.compose.ui.graphics.vector.VectorPainter r5 = androidx.compose.ui.graphics.vector.VectorPainterKt.rememberVectorPainter(r1, r0, r5)
            r7 = r5
            androidx.compose.ui.graphics.painter.Painter r7 = (androidx.compose.ui.graphics.painter.Painter) r7
            int r5 = androidx.compose.ui.graphics.vector.VectorPainter.$stable
            r8 = r2 & 112(0x70, float:1.57E-43)
            r5 = r5 | r8
            r8 = r2 & 896(0x380, float:1.256E-42)
            r5 = r5 | r8
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r13 = r5 | r2
            r14 = 0
            r8 = r18
            r9 = r4
            r10 = r15
            r12 = r0
            m1013Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r7, (java.lang.String) r8, (androidx.compose.ui.Modifier) r9, (long) r10, (androidx.compose.runtime.Composer) r12, (int) r13, (int) r14)
        L_0x011a:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x0121
            goto L_0x0136
        L_0x0121:
            androidx.compose.material.IconKt$Icon$1 r9 = new androidx.compose.material.IconKt$Icon$1
            r0 = r9
            r1 = r17
            r2 = r18
            r3 = r4
            r4 = r15
            r6 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0136:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.IconKt.m1014Iconww6aTOc(androidx.compose.ui.graphics.vector.ImageVector, java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1012Iconww6aTOc(ImageBitmap imageBitmap, String str, Modifier modifier, long j, Composer composer, int i, int i2) {
        long j2;
        int i3;
        ImageBitmap imageBitmap2 = imageBitmap;
        Intrinsics.checkNotNullParameter(imageBitmap2, "bitmap");
        Composer startRestartGroup = composer.startRestartGroup(1547383838);
        ComposerKt.sourceInformation(startRestartGroup, "C(Icon)P(!,3:c#ui.graphics.Color)86@3624L7,86@3663L7,88@3694L42,89@3741L136:Icon.kt#jmzs0o");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i2 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long r18 = ((Color) consume).m1606unboximpl();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            j2 = Color.m1595copywmQWz5c$default(r18, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            i3 = i & -7169;
        } else {
            j2 = j;
            i3 = i;
        }
        startRestartGroup.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed((Object) imageBitmap2);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, 0, 0, 6, (DefaultConstructorMarker) null);
            startRestartGroup.updateRememberedValue(bitmapPainter);
            rememberedValue = bitmapPainter;
        }
        startRestartGroup.endReplaceableGroup();
        m1013Iconww6aTOc((Painter) (BitmapPainter) rememberedValue, str, modifier2, j2, startRestartGroup, (i3 & 112) | 8 | (i3 & 896) | (i3 & 7168), 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IconKt$Icon$2(imageBitmap, str, modifier2, j2, i, i2));
        }
    }

    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1013Iconww6aTOc(Painter painter, String str, Modifier modifier, long j, Composer composer, int i, int i2) {
        long j2;
        Modifier modifier2;
        Painter painter2 = painter;
        String str2 = str;
        Intrinsics.checkNotNullParameter(painter2, "painter");
        Composer startRestartGroup = composer.startRestartGroup(1547384967);
        ComposerKt.sourceInformation(startRestartGroup, "C(Icon)P(2!,3:c#ui.graphics.Color)115@4750L7,115@4789L7,127@5172L253:Icon.kt#jmzs0o");
        Modifier modifier3 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i2 & 8) != 0) {
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long r13 = ((Color) consume).m1606unboximpl();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            j2 = Color.m1595copywmQWz5c$default(r13, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j2 = j;
        }
        ColorFilter r6 = Color.m1597equalsimpl0(j2, Color.Companion.m1632getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m1637tintxETnrds$default(ColorFilter.Companion, j2, 0, 2, (Object) null);
        startRestartGroup.startReplaceableGroup(1547385320);
        ComposerKt.sourceInformation(startRestartGroup, "120@5028L103");
        if (str2 != null) {
            Modifier modifier4 = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(-3686930);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) str2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new IconKt$Icon$semantics$1$1(str2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            modifier2 = SemanticsModifierKt.semantics$default(modifier4, false, (Function1) rememberedValue, 1, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        startRestartGroup.endReplaceableGroup();
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier3), painter2), painter, false, (Alignment) null, ContentScale.Companion.getFit(), 0.0f, r6, 22, (Object) null).then(modifier2), startRestartGroup, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IconKt$Icon$3(painter, str, modifier3, j2, i, i2));
        }
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        Modifier modifier2;
        if (Size.m1418equalsimpl0(painter.m2184getIntrinsicSizeNHjbRc(), Size.Companion.m1430getUnspecifiedNHjbRc()) || m1015isInfiniteuvyYCjk(painter.m2184getIntrinsicSizeNHjbRc())) {
            modifier2 = DefaultIconSizeModifier;
        } else {
            modifier2 = Modifier.Companion;
        }
        return modifier.then(modifier2);
    }

    /* renamed from: isInfinite-uvyYCjk  reason: not valid java name */
    private static final boolean m1015isInfiniteuvyYCjk(long j) {
        return Float.isInfinite(Size.m1422getWidthimpl(j)) && Float.isInfinite(Size.m1419getHeightimpl(j));
    }
}
