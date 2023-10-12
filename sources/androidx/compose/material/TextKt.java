package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aß\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001aÉ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020)2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00060,2\b\b\u0002\u0010.\u001a\u00020\u0002H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Text.kt */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), TextKt$LocalTextStyle$1.INSTANCE);

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x021d  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:243:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0138  */
    /* renamed from: Text-fLXpl1I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1189TextfLXpl1I(java.lang.String r61, androidx.compose.ui.Modifier r62, long r63, long r65, androidx.compose.ui.text.font.FontStyle r67, androidx.compose.ui.text.font.FontWeight r68, androidx.compose.ui.text.font.FontFamily r69, long r70, androidx.compose.ui.text.style.TextDecoration r72, androidx.compose.ui.text.style.TextAlign r73, long r74, int r76, boolean r77, int r78, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r79, androidx.compose.ui.text.TextStyle r80, androidx.compose.runtime.Composer r81, int r82, int r83, int r84) {
        /*
            r1 = r61
            r14 = r82
            r15 = r83
            r13 = r84
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 1557612414(0x5cd7477e, float:4.84765812E17)
            r2 = r81
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Text)P(13,8,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,5:c#ui.unit.TextUnit,15,14:c#ui.text.style.TextAlign,6:c#ui.unit.TextUnit,10:c#ui.text.style.TextOverflow,11)106@5548L7,129@6306L145:Text.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x0023
            r2 = r14 | 6
            goto L_0x0033
        L_0x0023:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0032
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r2 = r2 | r14
            goto L_0x0033
        L_0x0032:
            r2 = r14
        L_0x0033:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x003a
            r2 = r2 | 48
            goto L_0x004d
        L_0x003a:
            r8 = r14 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x004d
            r8 = r62
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0049
            r9 = 32
            goto L_0x004b
        L_0x0049:
            r9 = 16
        L_0x004b:
            r2 = r2 | r9
            goto L_0x004f
        L_0x004d:
            r8 = r62
        L_0x004f:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x0058
            r2 = r2 | 384(0x180, float:5.38E-43)
            r3 = r63
            goto L_0x006b
        L_0x0058:
            r12 = r14 & 896(0x380, float:1.256E-42)
            r3 = r63
            if (r12 != 0) goto L_0x006b
            boolean r16 = r0.changed((long) r3)
            if (r16 == 0) goto L_0x0067
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r2 = r2 | r16
        L_0x006b:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0078
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r7 = r65
            goto L_0x008b
        L_0x0078:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            r7 = r65
            if (r6 != 0) goto L_0x008b
            boolean r20 = r0.changed((long) r7)
            if (r20 == 0) goto L_0x0087
            r20 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r20 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r2 = r2 | r20
        L_0x008b:
            r20 = r13 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            r23 = 57344(0xe000, float:8.0356E-41)
            if (r20 == 0) goto L_0x009b
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r6 = r67
            goto L_0x00ae
        L_0x009b:
            r24 = r14 & r23
            r6 = r67
            if (r24 != 0) goto L_0x00ae
            boolean r25 = r0.changed((java.lang.Object) r6)
            if (r25 == 0) goto L_0x00aa
            r25 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r25 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r2 = r2 | r25
        L_0x00ae:
            r25 = r13 & 32
            r26 = 458752(0x70000, float:6.42848E-40)
            if (r25 == 0) goto L_0x00bb
            r27 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r27
            r10 = r68
            goto L_0x00ce
        L_0x00bb:
            r27 = r14 & r26
            r10 = r68
            if (r27 != 0) goto L_0x00ce
            boolean r28 = r0.changed((java.lang.Object) r10)
            if (r28 == 0) goto L_0x00ca
            r28 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cc
        L_0x00ca:
            r28 = 65536(0x10000, float:9.18355E-41)
        L_0x00cc:
            r2 = r2 | r28
        L_0x00ce:
            r28 = r13 & 64
            if (r28 == 0) goto L_0x00d9
            r29 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r29
            r11 = r69
            goto L_0x00ee
        L_0x00d9:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r14 & r29
            r11 = r69
            if (r29 != 0) goto L_0x00ee
            boolean r30 = r0.changed((java.lang.Object) r11)
            if (r30 == 0) goto L_0x00ea
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ec
        L_0x00ea:
            r30 = 524288(0x80000, float:7.34684E-40)
        L_0x00ec:
            r2 = r2 | r30
        L_0x00ee:
            r12 = r13 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x00f9
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r31
            r3 = r70
            goto L_0x010e
        L_0x00f9:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r14 & r31
            r3 = r70
            if (r31 != 0) goto L_0x010e
            boolean r31 = r0.changed((long) r3)
            if (r31 == 0) goto L_0x010a
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010c
        L_0x010a:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x010c:
            r2 = r2 | r31
        L_0x010e:
            r1 = r13 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0119
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 | r31
            r3 = r72
            goto L_0x012d
        L_0x0119:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r14 & r31
            r3 = r72
            if (r31 != 0) goto L_0x012d
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x012a
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012c
        L_0x012a:
            r4 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012c:
            r2 = r2 | r4
        L_0x012d:
            r4 = r13 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0138
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r31
            r3 = r73
            goto L_0x014d
        L_0x0138:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r14 & r31
            r3 = r73
            if (r31 != 0) goto L_0x014d
            boolean r31 = r0.changed((java.lang.Object) r3)
            if (r31 == 0) goto L_0x0149
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014b
        L_0x0149:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014b:
            r2 = r2 | r31
        L_0x014d:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0156
            r30 = r15 | 6
            r6 = r74
            goto L_0x016c
        L_0x0156:
            r31 = r15 & 14
            r6 = r74
            if (r31 != 0) goto L_0x016a
            boolean r8 = r0.changed((long) r6)
            if (r8 == 0) goto L_0x0165
            r30 = 4
            goto L_0x0167
        L_0x0165:
            r30 = 2
        L_0x0167:
            r30 = r15 | r30
            goto L_0x016c
        L_0x016a:
            r30 = r15
        L_0x016c:
            r8 = r13 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0175
            r30 = r30 | 48
            r6 = r76
            goto L_0x0188
        L_0x0175:
            r31 = r15 & 112(0x70, float:1.57E-43)
            r6 = r76
            if (r31 != 0) goto L_0x0188
            boolean r7 = r0.changed((int) r6)
            if (r7 == 0) goto L_0x0184
            r24 = 32
            goto L_0x0186
        L_0x0184:
            r24 = 16
        L_0x0186:
            r30 = r30 | r24
        L_0x0188:
            r7 = r30
            r6 = r13 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0191
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x01a5
        L_0x0191:
            r10 = r15 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x01a5
            r10 = r77
            boolean r19 = r0.changed((boolean) r10)
            if (r19 == 0) goto L_0x01a0
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01a2
        L_0x01a0:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01a2:
            r7 = r7 | r27
            goto L_0x01a7
        L_0x01a5:
            r10 = r77
        L_0x01a7:
            r10 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r10 == 0) goto L_0x01ae
            r7 = r7 | 3072(0xc00, float:4.305E-42)
            goto L_0x01c0
        L_0x01ae:
            r11 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01c0
            r11 = r78
            boolean r19 = r0.changed((int) r11)
            if (r19 == 0) goto L_0x01bb
            goto L_0x01bd
        L_0x01bb:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x01bd:
            r7 = r7 | r17
            goto L_0x01c2
        L_0x01c0:
            r11 = r78
        L_0x01c2:
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c9
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            goto L_0x01dd
        L_0x01c9:
            r17 = r15 & r23
            if (r17 != 0) goto L_0x01dd
            r17 = r11
            r11 = r79
            boolean r18 = r0.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x01d8
            goto L_0x01da
        L_0x01d8:
            r21 = 8192(0x2000, float:1.14794E-41)
        L_0x01da:
            r7 = r7 | r21
            goto L_0x01e1
        L_0x01dd:
            r17 = r11
            r11 = r79
        L_0x01e1:
            r18 = r15 & r26
            r19 = 32768(0x8000, float:4.5918E-41)
            if (r18 != 0) goto L_0x01fc
            r18 = r13 & r19
            r11 = r80
            if (r18 != 0) goto L_0x01f7
            boolean r18 = r0.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x01f7
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f9
        L_0x01f7:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x01f9:
            r7 = r7 | r18
            goto L_0x01fe
        L_0x01fc:
            r11 = r80
        L_0x01fe:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r18 = r2 & r18
            r21 = 306783378(0x12492492, float:6.3469493E-28)
            r18 = r18 ^ r21
            if (r18 != 0) goto L_0x0240
            r18 = 374491(0x5b6db, float:5.24774E-40)
            r18 = r7 & r18
            r21 = 74898(0x12492, float:1.04954E-40)
            r18 = r18 ^ r21
            if (r18 != 0) goto L_0x0240
            boolean r18 = r0.getSkipping()
            if (r18 != 0) goto L_0x021d
            goto L_0x0240
        L_0x021d:
            r0.skipToGroupEnd()
            r2 = r62
            r3 = r63
            r5 = r65
            r7 = r67
            r8 = r68
            r9 = r69
            r12 = r72
            r13 = r73
            r16 = r74
            r18 = r76
            r19 = r77
            r20 = r78
            r21 = r79
            r22 = r11
            r10 = r70
            goto L_0x0432
        L_0x0240:
            r0.startDefaults()
            r18 = r14 & 1
            java.lang.String r11 = "C:CompositionLocal.kt#9igjgp"
            r14 = 103361330(0x6292b32, float:3.1817102E-35)
            r21 = 1
            if (r18 == 0) goto L_0x0282
            boolean r18 = r0.getDefaultsInvalid()
            if (r18 == 0) goto L_0x0255
            goto L_0x0282
        L_0x0255:
            r0.skipToGroupEnd()
            r1 = r13 & r19
            if (r1 == 0) goto L_0x0260
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r7 = r7 & r1
        L_0x0260:
            r5 = r62
            r29 = r63
            r3 = r65
            r16 = r67
            r18 = r68
            r20 = r69
            r24 = r70
            r1 = r72
            r9 = r73
            r8 = r76
            r10 = r77
            r12 = r78
            r17 = r79
            r72 = r80
            r19 = r7
            r6 = r74
            goto L_0x032d
        L_0x0282:
            if (r5 == 0) goto L_0x0289
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x028b
        L_0x0289:
            r5 = r62
        L_0x028b:
            if (r9 == 0) goto L_0x0294
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r29 = r9.m1632getUnspecified0d7_KjU()
            goto L_0x0296
        L_0x0294:
            r29 = r63
        L_0x0296:
            if (r16 == 0) goto L_0x029f
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r31 = r9.m4051getUnspecifiedXSAIIZE()
            goto L_0x02a1
        L_0x029f:
            r31 = r65
        L_0x02a1:
            r9 = 0
            if (r20 == 0) goto L_0x02a7
            r16 = r9
            goto L_0x02a9
        L_0x02a7:
            r16 = r67
        L_0x02a9:
            if (r25 == 0) goto L_0x02ae
            r18 = r9
            goto L_0x02b0
        L_0x02ae:
            r18 = r68
        L_0x02b0:
            if (r28 == 0) goto L_0x02b5
            r20 = r9
            goto L_0x02b7
        L_0x02b5:
            r20 = r69
        L_0x02b7:
            if (r12 == 0) goto L_0x02c0
            androidx.compose.ui.unit.TextUnit$Companion r12 = androidx.compose.ui.unit.TextUnit.Companion
            long r24 = r12.m4051getUnspecifiedXSAIIZE()
            goto L_0x02c2
        L_0x02c0:
            r24 = r70
        L_0x02c2:
            if (r1 == 0) goto L_0x02c6
            r1 = r9
            goto L_0x02c8
        L_0x02c6:
            r1 = r72
        L_0x02c8:
            if (r4 == 0) goto L_0x02cb
            goto L_0x02cd
        L_0x02cb:
            r9 = r73
        L_0x02cd:
            if (r3 == 0) goto L_0x02d6
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m4051getUnspecifiedXSAIIZE()
            goto L_0x02d8
        L_0x02d6:
            r3 = r74
        L_0x02d8:
            if (r8 == 0) goto L_0x02e1
            androidx.compose.ui.text.style.TextOverflow$Companion r8 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r8 = r8.m3788getClipgIe3tQ8()
            goto L_0x02e3
        L_0x02e1:
            r8 = r76
        L_0x02e3:
            if (r6 == 0) goto L_0x02e7
            r6 = 1
            goto L_0x02e9
        L_0x02e7:
            r6 = r77
        L_0x02e9:
            if (r10 == 0) goto L_0x02ef
            r10 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02f1
        L_0x02ef:
            r10 = r78
        L_0x02f1:
            if (r17 == 0) goto L_0x02f8
            androidx.compose.material.TextKt$Text$1 r12 = androidx.compose.material.TextKt$Text$1.INSTANCE
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            goto L_0x02fa
        L_0x02f8:
            r12 = r79
        L_0x02fa:
            r17 = r13 & r19
            if (r17 == 0) goto L_0x0320
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r17 = LocalTextStyle
            r62 = r1
            r1 = r17
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r11)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.text.TextStyle r1 = (androidx.compose.ui.text.TextStyle) r1
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r7 = r7 & r17
            r72 = r1
            r19 = r7
            r17 = r12
            r1 = r62
            goto L_0x0328
        L_0x0320:
            r62 = r1
            r72 = r80
            r19 = r7
            r17 = r12
        L_0x0328:
            r12 = r10
            r10 = r6
            r6 = r3
            r3 = r31
        L_0x032d:
            r0.endDefaults()
            r14 = 1557613088(0x5cd74a20, float:4.8478897E17)
            r0.startReplaceableGroup(r14)
            java.lang.String r14 = "*111@5663L7,111@5702L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r27 = r14.m1632getUnspecified0d7_KjU()
            int r14 = (r29 > r27 ? 1 : (r29 == r27 ? 0 : -1))
            if (r14 == 0) goto L_0x0347
            r14 = 1
            goto L_0x0348
        L_0x0347:
            r14 = 0
        L_0x0348:
            if (r14 == 0) goto L_0x034d
            r32 = r29
            goto L_0x03ac
        L_0x034d:
            long r27 = r72.m3583getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r31 = r14.m1632getUnspecified0d7_KjU()
            int r14 = (r27 > r31 ? 1 : (r27 == r31 ? 0 : -1))
            if (r14 == 0) goto L_0x035c
            goto L_0x035e
        L_0x035c:
            r21 = 0
        L_0x035e:
            if (r21 == 0) goto L_0x0361
            goto L_0x03aa
        L_0x0361:
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r13 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r11)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.graphics.Color r14 = (androidx.compose.ui.graphics.Color) r14
            long r21 = r14.m1606unboximpl()
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r11)
            java.lang.Object r11 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            r13 = 0
            r14 = 0
            r27 = 0
            r28 = 14
            r31 = 0
            r62 = r21
            r64 = r11
            r65 = r13
            r66 = r14
            r67 = r27
            r68 = r28
            r69 = r31
            long r27 = androidx.compose.ui.graphics.Color.m1595copywmQWz5c$default(r62, r64, r65, r66, r67, r68, r69)
        L_0x03aa:
            r32 = r27
        L_0x03ac:
            r0.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r11 = new androidx.compose.ui.text.TextStyle
            r31 = r11
            r38 = 0
            r40 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r49 = 0
            r51 = 0
            r54 = 0
            r55 = 175952(0x2af50, float:2.46561E-40)
            r56 = 0
            r34 = r3
            r36 = r18
            r37 = r16
            r39 = r20
            r41 = r24
            r48 = r1
            r50 = r9
            r52 = r6
            r31.<init>(r32, r34, r36, r37, r38, r39, r40, r41, r43, r44, r45, r46, r48, r49, r50, r51, r52, r54, r55, r56)
            r13 = r72
            androidx.compose.ui.text.TextStyle r11 = r13.merge((androidx.compose.ui.text.TextStyle) r11)
            r14 = r2 & 14
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r14
            int r14 = r19 >> 3
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r14
            int r14 = r19 << 9
            r19 = r14 & r23
            r2 = r2 | r19
            r19 = r14 & r26
            r2 = r2 | r19
            r19 = 3670016(0x380000, float:5.142788E-39)
            r14 = r14 & r19
            r2 = r2 | r14
            r14 = 0
            r62 = r61
            r63 = r5
            r64 = r11
            r65 = r17
            r66 = r8
            r67 = r10
            r68 = r12
            r69 = r0
            r70 = r2
            r71 = r14
            androidx.compose.foundation.text.BasicTextKt.m628BasicTextBpD7jsM(r62, r63, r64, r65, r66, r67, r68, r69, r70, r71)
            r2 = r5
            r19 = r10
            r22 = r13
            r21 = r17
            r10 = r24
            r13 = r9
            r9 = r20
            r20 = r12
            r12 = r1
            r58 = r18
            r18 = r8
            r8 = r58
            r59 = r6
            r7 = r16
            r5 = r3
            r16 = r59
            r3 = r29
        L_0x0432:
            androidx.compose.runtime.ScopeUpdateScope r14 = r0.endRestartGroup()
            if (r14 != 0) goto L_0x0439
            goto L_0x045f
        L_0x0439:
            androidx.compose.material.TextKt$Text$2 r24 = new androidx.compose.material.TextKt$Text$2
            r0 = r24
            r1 = r61
            r57 = r14
            r14 = r16
            r16 = r18
            r17 = r19
            r18 = r20
            r19 = r21
            r20 = r22
            r21 = r82
            r22 = r83
            r23 = r84
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r24
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r57
            r1.updateScope(r0)
        L_0x045f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1189TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0464  */
    /* JADX WARNING: Removed duplicated region for block: B:256:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0136  */
    /* renamed from: Text--4IGK_g  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1188Text4IGK_g(androidx.compose.ui.text.AnnotatedString r59, androidx.compose.ui.Modifier r60, long r61, long r63, androidx.compose.ui.text.font.FontStyle r65, androidx.compose.ui.text.font.FontWeight r66, androidx.compose.ui.text.font.FontFamily r67, long r68, androidx.compose.ui.text.style.TextDecoration r70, androidx.compose.ui.text.style.TextAlign r71, long r72, int r74, boolean r75, int r76, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r77, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r78, androidx.compose.ui.text.TextStyle r79, androidx.compose.runtime.Composer r80, int r81, int r82, int r83) {
        /*
            r1 = r59
            r14 = r81
            r15 = r82
            r13 = r83
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 1557617449(0x5cd75b29, float:4.84938813E17)
            r2 = r80
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(Text)P(14,9,0:c#ui.graphics.Color,2:c#ui.unit.TextUnit,3:c#ui.text.font.FontStyle,4!1,6:c#ui.unit.TextUnit,16,15:c#ui.text.style.TextAlign,7:c#ui.unit.TextUnit,11:c#ui.text.style.TextOverflow,12,8)210@10653L7,232@11410L167:Text.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r13 & 1
            if (r2 == 0) goto L_0x0023
            r2 = r14 | 6
            goto L_0x0033
        L_0x0023:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0032
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r2 = r2 | r14
            goto L_0x0033
        L_0x0032:
            r2 = r14
        L_0x0033:
            r5 = r13 & 2
            if (r5 == 0) goto L_0x003a
            r2 = r2 | 48
            goto L_0x004d
        L_0x003a:
            r8 = r14 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x004d
            r8 = r60
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0049
            r9 = 32
            goto L_0x004b
        L_0x0049:
            r9 = 16
        L_0x004b:
            r2 = r2 | r9
            goto L_0x004f
        L_0x004d:
            r8 = r60
        L_0x004f:
            r9 = r13 & 4
            if (r9 == 0) goto L_0x0058
            r2 = r2 | 384(0x180, float:5.38E-43)
            r3 = r61
            goto L_0x006b
        L_0x0058:
            r12 = r14 & 896(0x380, float:1.256E-42)
            r3 = r61
            if (r12 != 0) goto L_0x006b
            boolean r16 = r0.changed((long) r3)
            if (r16 == 0) goto L_0x0067
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r2 = r2 | r16
        L_0x006b:
            r16 = r13 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0078
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r7 = r63
            goto L_0x008b
        L_0x0078:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            r7 = r63
            if (r6 != 0) goto L_0x008b
            boolean r20 = r0.changed((long) r7)
            if (r20 == 0) goto L_0x0087
            r20 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r20 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r2 = r2 | r20
        L_0x008b:
            r20 = r13 & 16
            if (r20 == 0) goto L_0x0094
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r10 = r65
            goto L_0x00aa
        L_0x0094:
            r22 = 57344(0xe000, float:8.0356E-41)
            r22 = r14 & r22
            r10 = r65
            if (r22 != 0) goto L_0x00aa
            boolean r23 = r0.changed((java.lang.Object) r10)
            if (r23 == 0) goto L_0x00a6
            r23 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a8
        L_0x00a6:
            r23 = 8192(0x2000, float:1.14794E-41)
        L_0x00a8:
            r2 = r2 | r23
        L_0x00aa:
            r23 = r13 & 32
            r24 = 458752(0x70000, float:6.42848E-40)
            r25 = 65536(0x10000, float:9.18355E-41)
            if (r23 == 0) goto L_0x00b9
            r26 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r26
            r11 = r66
            goto L_0x00cc
        L_0x00b9:
            r26 = r14 & r24
            r11 = r66
            if (r26 != 0) goto L_0x00cc
            boolean r27 = r0.changed((java.lang.Object) r11)
            if (r27 == 0) goto L_0x00c8
            r27 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ca
        L_0x00c8:
            r27 = 65536(0x10000, float:9.18355E-41)
        L_0x00ca:
            r2 = r2 | r27
        L_0x00cc:
            r27 = r13 & 64
            r28 = 3670016(0x380000, float:5.142788E-39)
            if (r27 == 0) goto L_0x00d9
            r29 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r29
            r12 = r67
            goto L_0x00ec
        L_0x00d9:
            r29 = r14 & r28
            r12 = r67
            if (r29 != 0) goto L_0x00ec
            boolean r30 = r0.changed((java.lang.Object) r12)
            if (r30 == 0) goto L_0x00e8
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ea
        L_0x00e8:
            r30 = 524288(0x80000, float:7.34684E-40)
        L_0x00ea:
            r2 = r2 | r30
        L_0x00ec:
            r6 = r13 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00f7
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r31
            r3 = r68
            goto L_0x010c
        L_0x00f7:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r14 & r31
            r3 = r68
            if (r31 != 0) goto L_0x010c
            boolean r31 = r0.changed((long) r3)
            if (r31 == 0) goto L_0x0108
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010a
        L_0x0108:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x010a:
            r2 = r2 | r31
        L_0x010c:
            r1 = r13 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0117
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r2 = r2 | r31
            r3 = r70
            goto L_0x012b
        L_0x0117:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r14 & r31
            r3 = r70
            if (r31 != 0) goto L_0x012b
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0128
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012a
        L_0x0128:
            r4 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012a:
            r2 = r2 | r4
        L_0x012b:
            r4 = r13 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0136
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r2 = r2 | r31
            r3 = r71
            goto L_0x014b
        L_0x0136:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r14 & r31
            r3 = r71
            if (r31 != 0) goto L_0x014b
            boolean r31 = r0.changed((java.lang.Object) r3)
            if (r31 == 0) goto L_0x0147
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0149
        L_0x0147:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0149:
            r2 = r2 | r31
        L_0x014b:
            r3 = r13 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x0154
            r29 = r15 | 6
            r7 = r72
            goto L_0x016a
        L_0x0154:
            r31 = r15 & 14
            r7 = r72
            if (r31 != 0) goto L_0x0168
            boolean r31 = r0.changed((long) r7)
            if (r31 == 0) goto L_0x0163
            r29 = 4
            goto L_0x0165
        L_0x0163:
            r29 = 2
        L_0x0165:
            r29 = r15 | r29
            goto L_0x016a
        L_0x0168:
            r29 = r15
        L_0x016a:
            r7 = r13 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x0171
            r29 = r29 | 48
            goto L_0x0187
        L_0x0171:
            r8 = r15 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0185
            r8 = r74
            boolean r31 = r0.changed((int) r8)
            if (r31 == 0) goto L_0x0180
            r19 = 32
            goto L_0x0182
        L_0x0180:
            r19 = 16
        L_0x0182:
            r29 = r29 | r19
            goto L_0x0187
        L_0x0185:
            r8 = r74
        L_0x0187:
            r8 = r29
            r10 = r13 & 4096(0x1000, float:5.74E-42)
            if (r10 == 0) goto L_0x0190
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x01a4
        L_0x0190:
            r11 = r15 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x01a4
            r11 = r75
            boolean r19 = r0.changed((boolean) r11)
            if (r19 == 0) goto L_0x019f
            r26 = 256(0x100, float:3.59E-43)
            goto L_0x01a1
        L_0x019f:
            r26 = 128(0x80, float:1.794E-43)
        L_0x01a1:
            r8 = r8 | r26
            goto L_0x01a6
        L_0x01a4:
            r11 = r75
        L_0x01a6:
            r11 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x01ad
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x01bf
        L_0x01ad:
            r12 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x01bf
            r12 = r76
            boolean r19 = r0.changed((int) r12)
            if (r19 == 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01ba:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x01bc:
            r8 = r8 | r17
            goto L_0x01c1
        L_0x01bf:
            r12 = r76
        L_0x01c1:
            r12 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x01c7
            r8 = r8 | 8192(0x2000, float:1.14794E-41)
        L_0x01c7:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r13 & r17
            if (r17 == 0) goto L_0x01d3
            r18 = 196608(0x30000, float:2.75506E-40)
            r8 = r8 | r18
            goto L_0x01e9
        L_0x01d3:
            r18 = r15 & r24
            if (r18 != 0) goto L_0x01e9
            r18 = r11
            r11 = r78
            boolean r19 = r0.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x01e4
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01e6
        L_0x01e4:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x01e6:
            r8 = r8 | r19
            goto L_0x01ed
        L_0x01e9:
            r18 = r11
            r11 = r78
        L_0x01ed:
            r19 = r15 & r28
            if (r19 != 0) goto L_0x0205
            r19 = r13 & r25
            r11 = r79
            if (r19 != 0) goto L_0x0200
            boolean r19 = r0.changed((java.lang.Object) r11)
            if (r19 == 0) goto L_0x0200
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0202
        L_0x0200:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x0202:
            r8 = r8 | r19
            goto L_0x0207
        L_0x0205:
            r11 = r79
        L_0x0207:
            int r11 = ~r13
            r15 = 16384(0x4000, float:2.2959E-41)
            r11 = r11 & r15
            if (r11 != 0) goto L_0x024d
            r11 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r11 = r11 & r2
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            r11 = r11 ^ r15
            if (r11 != 0) goto L_0x024d
            r11 = 2995931(0x2db6db, float:4.198194E-39)
            r11 = r11 & r8
            r15 = 599186(0x92492, float:8.39638E-40)
            r11 = r11 ^ r15
            if (r11 != 0) goto L_0x024d
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x0228
            goto L_0x024d
        L_0x0228:
            r0.skipToGroupEnd()
            r2 = r60
            r3 = r61
            r5 = r63
            r7 = r65
            r8 = r66
            r9 = r67
            r10 = r68
            r12 = r70
            r13 = r71
            r14 = r72
            r16 = r74
            r17 = r75
            r18 = r76
            r19 = r77
            r20 = r78
            r21 = r79
            goto L_0x045d
        L_0x024d:
            r0.startDefaults()
            r11 = r14 & 1
            java.lang.String r15 = "C:CompositionLocal.kt#9igjgp"
            r14 = 103361330(0x6292b32, float:3.1817102E-35)
            r19 = 1
            if (r11 == 0) goto L_0x0297
            boolean r11 = r0.getDefaultsInvalid()
            if (r11 == 0) goto L_0x0262
            goto L_0x0297
        L_0x0262:
            r0.skipToGroupEnd()
            if (r12 == 0) goto L_0x026b
            r1 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r8 & r1
        L_0x026b:
            r1 = r13 & r25
            if (r1 == 0) goto L_0x0273
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r1
        L_0x0273:
            r5 = r60
            r21 = r61
            r3 = r63
            r11 = r65
            r16 = r66
            r20 = r67
            r26 = r68
            r1 = r70
            r9 = r71
            r6 = r72
            r10 = r75
            r12 = r76
            r17 = r77
            r18 = r78
            r71 = r79
            r23 = r8
            r8 = r74
            goto L_0x0352
        L_0x0297:
            if (r5 == 0) goto L_0x029e
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            goto L_0x02a0
        L_0x029e:
            r5 = r60
        L_0x02a0:
            if (r9 == 0) goto L_0x02a9
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r21 = r9.m1632getUnspecified0d7_KjU()
            goto L_0x02ab
        L_0x02a9:
            r21 = r61
        L_0x02ab:
            if (r16 == 0) goto L_0x02b4
            androidx.compose.ui.unit.TextUnit$Companion r9 = androidx.compose.ui.unit.TextUnit.Companion
            long r29 = r9.m4051getUnspecifiedXSAIIZE()
            goto L_0x02b6
        L_0x02b4:
            r29 = r63
        L_0x02b6:
            r9 = 0
            if (r20 == 0) goto L_0x02bb
            r11 = r9
            goto L_0x02bd
        L_0x02bb:
            r11 = r65
        L_0x02bd:
            if (r23 == 0) goto L_0x02c2
            r16 = r9
            goto L_0x02c4
        L_0x02c2:
            r16 = r66
        L_0x02c4:
            if (r27 == 0) goto L_0x02c9
            r20 = r9
            goto L_0x02cb
        L_0x02c9:
            r20 = r67
        L_0x02cb:
            if (r6 == 0) goto L_0x02d4
            androidx.compose.ui.unit.TextUnit$Companion r6 = androidx.compose.ui.unit.TextUnit.Companion
            long r26 = r6.m4051getUnspecifiedXSAIIZE()
            goto L_0x02d6
        L_0x02d4:
            r26 = r68
        L_0x02d6:
            if (r1 == 0) goto L_0x02da
            r1 = r9
            goto L_0x02dc
        L_0x02da:
            r1 = r70
        L_0x02dc:
            if (r4 == 0) goto L_0x02df
            goto L_0x02e1
        L_0x02df:
            r9 = r71
        L_0x02e1:
            if (r3 == 0) goto L_0x02ea
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m4051getUnspecifiedXSAIIZE()
            goto L_0x02ec
        L_0x02ea:
            r3 = r72
        L_0x02ec:
            if (r7 == 0) goto L_0x02f5
            androidx.compose.ui.text.style.TextOverflow$Companion r6 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r6 = r6.m3788getClipgIe3tQ8()
            goto L_0x02f7
        L_0x02f5:
            r6 = r74
        L_0x02f7:
            if (r10 == 0) goto L_0x02fb
            r7 = 1
            goto L_0x02fd
        L_0x02fb:
            r7 = r75
        L_0x02fd:
            if (r18 == 0) goto L_0x0303
            r10 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0305
        L_0x0303:
            r10 = r76
        L_0x0305:
            if (r12 == 0) goto L_0x0311
            java.util.Map r12 = kotlin.collections.MapsKt.emptyMap()
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            r8 = r8 & r18
            goto L_0x0313
        L_0x0311:
            r12 = r77
        L_0x0313:
            if (r17 == 0) goto L_0x031a
            androidx.compose.material.TextKt$Text$3 r17 = androidx.compose.material.TextKt$Text$3.INSTANCE
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            goto L_0x031c
        L_0x031a:
            r17 = r78
        L_0x031c:
            r18 = r13 & r25
            if (r18 == 0) goto L_0x0342
            androidx.compose.runtime.ProvidableCompositionLocal<androidx.compose.ui.text.TextStyle> r18 = LocalTextStyle
            r60 = r1
            r1 = r18
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r14, r15)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.text.TextStyle r1 = (androidx.compose.ui.text.TextStyle) r1
            r18 = -3670017(0xffffffffffc7ffff, float:NaN)
            r8 = r8 & r18
            r71 = r1
            r23 = r8
            r18 = r17
            r1 = r60
            goto L_0x034a
        L_0x0342:
            r60 = r1
            r71 = r79
            r23 = r8
            r18 = r17
        L_0x034a:
            r8 = r6
            r17 = r12
            r12 = r10
            r10 = r7
            r6 = r3
            r3 = r29
        L_0x0352:
            r0.endDefaults()
            r14 = 1557618192(0x5cd75e10, float:4.84964342E17)
            r0.startReplaceableGroup(r14)
            java.lang.String r14 = "*214@10767L7,214@10806L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r14)
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r29 = r14.m1632getUnspecified0d7_KjU()
            int r14 = (r21 > r29 ? 1 : (r21 == r29 ? 0 : -1))
            if (r14 == 0) goto L_0x036c
            r14 = 1
            goto L_0x036d
        L_0x036c:
            r14 = 0
        L_0x036d:
            if (r14 == 0) goto L_0x0372
            r30 = r21
            goto L_0x03d1
        L_0x0372:
            long r29 = r71.m3583getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r14 = androidx.compose.ui.graphics.Color.Companion
            long r31 = r14.m1632getUnspecified0d7_KjU()
            int r14 = (r29 > r31 ? 1 : (r29 == r31 ? 0 : -1))
            if (r14 == 0) goto L_0x0381
            goto L_0x0383
        L_0x0381:
            r19 = 0
        L_0x0383:
            if (r19 == 0) goto L_0x0386
            goto L_0x03cf
        L_0x0386:
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r13 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r15)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.graphics.Color r14 = (androidx.compose.ui.graphics.Color) r14
            long r29 = r14.m1606unboximpl()
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.material.ContentAlphaKt.getLocalContentAlpha()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r15)
            java.lang.Object r13 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            r14 = 0
            r15 = 0
            r19 = 0
            r25 = 14
            r31 = 0
            r60 = r29
            r62 = r13
            r63 = r14
            r64 = r15
            r65 = r19
            r66 = r25
            r67 = r31
            long r29 = androidx.compose.ui.graphics.Color.m1595copywmQWz5c$default(r60, r62, r63, r64, r65, r66, r67)
        L_0x03cf:
            r30 = r29
        L_0x03d1:
            r0.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r13 = new androidx.compose.ui.text.TextStyle
            r29 = r13
            r36 = 0
            r38 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r47 = 0
            r49 = 0
            r52 = 0
            r53 = 175952(0x2af50, float:2.46561E-40)
            r54 = 0
            r32 = r3
            r34 = r16
            r35 = r11
            r37 = r20
            r39 = r26
            r46 = r1
            r48 = r9
            r50 = r6
            r29.<init>(r30, r32, r34, r35, r36, r37, r38, r39, r41, r42, r43, r44, r46, r47, r48, r49, r50, r52, r53, r54)
            r14 = r71
            androidx.compose.ui.text.TextStyle r13 = r14.merge((androidx.compose.ui.text.TextStyle) r13)
            r15 = 16777216(0x1000000, float:2.3509887E-38)
            r19 = r2 & 14
            r15 = r19 | r15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | r15
            int r15 = r23 >> 6
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r15
            r15 = 57344(0xe000, float:8.0356E-41)
            int r19 = r23 << 9
            r15 = r19 & r15
            r2 = r2 | r15
            r15 = r19 & r24
            r2 = r2 | r15
            r15 = r19 & r28
            r2 = r2 | r15
            r15 = 0
            r60 = r59
            r61 = r5
            r62 = r13
            r63 = r18
            r64 = r8
            r65 = r10
            r66 = r12
            r67 = r17
            r68 = r0
            r69 = r2
            r70 = r15
            androidx.compose.foundation.text.BasicTextKt.m627BasicText4YKlhWE(r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70)
            r2 = r5
            r13 = r9
            r19 = r17
            r9 = r20
            r17 = r10
            r20 = r18
            r18 = r12
            r12 = r1
            r56 = r16
            r16 = r8
            r8 = r56
            r57 = r6
            r7 = r11
            r5 = r3
            r3 = r21
            r10 = r26
            r21 = r14
            r14 = r57
        L_0x045d:
            androidx.compose.runtime.ScopeUpdateScope r1 = r0.endRestartGroup()
            if (r1 != 0) goto L_0x0464
            goto L_0x047e
        L_0x0464:
            androidx.compose.material.TextKt$Text$4 r25 = new androidx.compose.material.TextKt$Text$4
            r0 = r25
            r55 = r1
            r1 = r59
            r22 = r81
            r23 = r82
            r24 = r83
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r55
            r1.updateScope(r0)
        L_0x047e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m1188Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(textStyle, "value");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(1919620829);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyle)P(1)263@12533L7,264@12558L80:Text.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function2) ? 32 : 16;
        }
        if (((i2 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providableCompositionLocal.provides(((TextStyle) consume).merge(textStyle))}, function2, startRestartGroup, (i2 & 112) | 8);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextKt$ProvideTextStyle$1(textStyle, function2, i));
        }
    }
}
