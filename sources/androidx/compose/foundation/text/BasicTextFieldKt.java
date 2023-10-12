package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020#2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
public final class BasicTextFieldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v1, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v3, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v4, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v5, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v6, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01b7, code lost:
        if (r0.changed((java.lang.Object) r50) != false) goto L_0x01be;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0425  */
    /* JADX WARNING: Removed duplicated region for block: B:231:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(java.lang.String r37, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, boolean r40, boolean r41, androidx.compose.ui.text.TextStyle r42, androidx.compose.foundation.text.KeyboardOptions r43, androidx.compose.foundation.text.KeyboardActions r44, boolean r45, int r46, androidx.compose.ui.text.input.VisualTransformation r47, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, androidx.compose.ui.graphics.Brush r50, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, int r53, int r54, int r55) {
        /*
            r1 = r37
            r2 = r38
            r15 = r53
            r14 = r54
            r13 = r55
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = 1483891357(0x5872629d, float:1.06602142E15)
            r3 = r52
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)133@7729L39,138@7996L57,143@8194L137,141@8123L744:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x002a
            r3 = r15 | 6
            goto L_0x003a
        L_0x002a:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0039
            boolean r3 = r0.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0036
            r3 = 4
            goto L_0x0037
        L_0x0036:
            r3 = 2
        L_0x0037:
            r3 = r3 | r15
            goto L_0x003a
        L_0x0039:
            r3 = r15
        L_0x003a:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0041
            r3 = r3 | 48
            goto L_0x0051
        L_0x0041:
            r6 = r15 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0051
            boolean r6 = r0.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x004e
            r6 = 32
            goto L_0x0050
        L_0x004e:
            r6 = 16
        L_0x0050:
            r3 = r3 | r6
        L_0x0051:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0058
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0058:
            r11 = r15 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x006b
            r11 = r39
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0067
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r3 = r3 | r12
            goto L_0x006d
        L_0x006b:
            r11 = r39
        L_0x006d:
            r12 = r13 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0078
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x0078:
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x008c
            r4 = r40
            boolean r18 = r0.changed((boolean) r4)
            if (r18 == 0) goto L_0x0087
            r18 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r3 = r3 | r18
            goto L_0x008e
        L_0x008c:
            r4 = r40
        L_0x008e:
            r18 = r13 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r20 = 57344(0xe000, float:8.0356E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x009e
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r7 = r41
            goto L_0x00b1
        L_0x009e:
            r22 = r15 & r20
            r7 = r41
            if (r22 != 0) goto L_0x00b1
            boolean r23 = r0.changed((boolean) r7)
            if (r23 == 0) goto L_0x00ad
            r23 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00af
        L_0x00ad:
            r23 = 8192(0x2000, float:1.14794E-41)
        L_0x00af:
            r3 = r3 | r23
        L_0x00b1:
            r23 = r13 & 32
            r24 = 458752(0x70000, float:6.42848E-40)
            if (r23 == 0) goto L_0x00be
            r25 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r25
            r8 = r42
            goto L_0x00d1
        L_0x00be:
            r25 = r15 & r24
            r8 = r42
            if (r25 != 0) goto L_0x00d1
            boolean r26 = r0.changed((java.lang.Object) r8)
            if (r26 == 0) goto L_0x00cd
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cf
        L_0x00cd:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00cf:
            r3 = r3 | r26
        L_0x00d1:
            r26 = r13 & 64
            if (r26 == 0) goto L_0x00dc
            r27 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r27
            r9 = r43
            goto L_0x00f1
        L_0x00dc:
            r27 = 3670016(0x380000, float:5.142788E-39)
            r27 = r15 & r27
            r9 = r43
            if (r27 != 0) goto L_0x00f1
            boolean r28 = r0.changed((java.lang.Object) r9)
            if (r28 == 0) goto L_0x00ed
            r28 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ef
        L_0x00ed:
            r28 = 524288(0x80000, float:7.34684E-40)
        L_0x00ef:
            r3 = r3 | r28
        L_0x00f1:
            r10 = r13 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x00fc
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r29
            r5 = r44
            goto L_0x0111
        L_0x00fc:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r15 & r29
            r5 = r44
            if (r29 != 0) goto L_0x0111
            boolean r30 = r0.changed((java.lang.Object) r5)
            if (r30 == 0) goto L_0x010d
            r30 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010f
        L_0x010d:
            r30 = 4194304(0x400000, float:5.877472E-39)
        L_0x010f:
            r3 = r3 | r30
        L_0x0111:
            r4 = r13 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x011c
            r30 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r30
            r5 = r45
            goto L_0x0131
        L_0x011c:
            r30 = 234881024(0xe000000, float:1.5777218E-30)
            r30 = r15 & r30
            r5 = r45
            if (r30 != 0) goto L_0x0131
            boolean r30 = r0.changed((boolean) r5)
            if (r30 == 0) goto L_0x012d
            r30 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012f
        L_0x012d:
            r30 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012f:
            r3 = r3 | r30
        L_0x0131:
            r5 = r13 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x013c
            r30 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r30
            r7 = r46
            goto L_0x0151
        L_0x013c:
            r30 = 1879048192(0x70000000, float:1.58456325E29)
            r30 = r15 & r30
            r7 = r46
            if (r30 != 0) goto L_0x0151
            boolean r30 = r0.changed((int) r7)
            if (r30 == 0) goto L_0x014d
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014f
        L_0x014d:
            r30 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014f:
            r3 = r3 | r30
        L_0x0151:
            r7 = r13 & 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L_0x015a
            r30 = r14 | 6
            r8 = r47
            goto L_0x0170
        L_0x015a:
            r30 = r14 & 14
            r8 = r47
            if (r30 != 0) goto L_0x016e
            boolean r30 = r0.changed((java.lang.Object) r8)
            if (r30 == 0) goto L_0x0169
            r30 = 4
            goto L_0x016b
        L_0x0169:
            r30 = 2
        L_0x016b:
            r30 = r14 | r30
            goto L_0x0170
        L_0x016e:
            r30 = r14
        L_0x0170:
            r8 = r13 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0177
            r30 = r30 | 48
            goto L_0x018a
        L_0x0177:
            r31 = r14 & 112(0x70, float:1.57E-43)
            r9 = r48
            if (r31 != 0) goto L_0x018a
            boolean r31 = r0.changed((java.lang.Object) r9)
            if (r31 == 0) goto L_0x0186
            r22 = 32
            goto L_0x0188
        L_0x0186:
            r22 = 16
        L_0x0188:
            r30 = r30 | r22
        L_0x018a:
            r9 = r30
            r11 = r13 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x0193
            r9 = r9 | 384(0x180, float:5.38E-43)
            goto L_0x01a7
        L_0x0193:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x01a7
            r2 = r49
            boolean r22 = r0.changed((java.lang.Object) r2)
            if (r22 == 0) goto L_0x01a2
            r27 = 256(0x100, float:3.59E-43)
            goto L_0x01a4
        L_0x01a2:
            r27 = 128(0x80, float:1.794E-43)
        L_0x01a4:
            r9 = r9 | r27
            goto L_0x01a9
        L_0x01a7:
            r2 = r49
        L_0x01a9:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x01c1
            r2 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r2 != 0) goto L_0x01ba
            r2 = r50
            boolean r22 = r0.changed((java.lang.Object) r2)
            if (r22 == 0) goto L_0x01bc
            goto L_0x01be
        L_0x01ba:
            r2 = r50
        L_0x01bc:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x01be:
            r9 = r9 | r16
            goto L_0x01c3
        L_0x01c1:
            r2 = r50
        L_0x01c3:
            r2 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x01cc
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            r14 = r51
            goto L_0x01dd
        L_0x01cc:
            r16 = r14 & r20
            r14 = r51
            if (r16 != 0) goto L_0x01dd
            boolean r16 = r0.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x01d9
            goto L_0x01db
        L_0x01d9:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x01db:
            r9 = r9 | r19
        L_0x01dd:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r16 = r3 & r16
            r17 = 306783378(0x12492492, float:6.3469493E-28)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x021a
            r16 = 46811(0xb6db, float:6.5596E-41)
            r14 = r9 & r16
            r14 = r14 ^ 9362(0x2492, float:1.3119E-41)
            if (r14 != 0) goto L_0x021a
            boolean r14 = r0.getSkipping()
            if (r14 != 0) goto L_0x01f9
            goto L_0x021a
        L_0x01f9:
            r0.skipToGroupEnd()
            r6 = r38
            r3 = r39
            r4 = r40
            r5 = r41
            r7 = r42
            r8 = r43
            r10 = r44
            r9 = r45
            r11 = r46
            r12 = r47
            r13 = r48
            r14 = r49
            r15 = r50
            r35 = r51
            goto L_0x041e
        L_0x021a:
            r0.startDefaults()
            r14 = r15 & 1
            r16 = 1
            if (r14 == 0) goto L_0x0251
            boolean r14 = r0.getDefaultsInvalid()
            if (r14 == 0) goto L_0x022a
            goto L_0x0251
        L_0x022a:
            r0.skipToGroupEnd()
            r2 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0233
            r9 = r9 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0233:
            r2 = r39
            r12 = r40
            r14 = r41
            r4 = r42
            r5 = r43
            r10 = r44
            r6 = r45
            r7 = r46
            r8 = r47
            r11 = r49
            r15 = r50
            r35 = r51
            r18 = r9
            r9 = r48
            goto L_0x0314
        L_0x0251:
            if (r6 == 0) goto L_0x0258
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x025a
        L_0x0258:
            r6 = r39
        L_0x025a:
            if (r12 == 0) goto L_0x025e
            r12 = 1
            goto L_0x0260
        L_0x025e:
            r12 = r40
        L_0x0260:
            if (r18 == 0) goto L_0x0264
            r14 = 0
            goto L_0x0266
        L_0x0264:
            r14 = r41
        L_0x0266:
            if (r23 == 0) goto L_0x026f
            androidx.compose.ui.text.TextStyle$Companion r17 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r17 = r17.getDefault()
            goto L_0x0271
        L_0x026f:
            r17 = r42
        L_0x0271:
            if (r26 == 0) goto L_0x027a
            androidx.compose.foundation.text.KeyboardOptions$Companion r18 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r18 = r18.getDefault()
            goto L_0x027c
        L_0x027a:
            r18 = r43
        L_0x027c:
            if (r10 == 0) goto L_0x0285
            androidx.compose.foundation.text.KeyboardActions$Companion r10 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r10 = r10.getDefault()
            goto L_0x0287
        L_0x0285:
            r10 = r44
        L_0x0287:
            if (r4 == 0) goto L_0x028b
            r4 = 0
            goto L_0x028d
        L_0x028b:
            r4 = r45
        L_0x028d:
            if (r5 == 0) goto L_0x0293
            r5 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0295
        L_0x0293:
            r5 = r46
        L_0x0295:
            if (r7 == 0) goto L_0x029e
            androidx.compose.ui.text.input.VisualTransformation$Companion r7 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r7 = r7.getNone()
            goto L_0x02a0
        L_0x029e:
            r7 = r47
        L_0x02a0:
            if (r8 == 0) goto L_0x02a7
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1 r8 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1.INSTANCE
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            goto L_0x02a9
        L_0x02a7:
            r8 = r48
        L_0x02a9:
            if (r11 == 0) goto L_0x02cf
            r11 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            java.lang.Object r11 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r19.getEmpty()
            if (r11 != r15) goto L_0x02c9
            androidx.compose.foundation.interaction.MutableInteractionSource r11 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r11)
        L_0x02c9:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r11 = (androidx.compose.foundation.interaction.MutableInteractionSource) r11
            goto L_0x02d1
        L_0x02cf:
            r11 = r49
        L_0x02d1:
            r15 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x02ee
            androidx.compose.ui.graphics.SolidColor r15 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r19 = androidx.compose.ui.graphics.Color.Companion
            r39 = r4
            r40 = r5
            long r4 = r19.m1622getBlack0d7_KjU()
            r19 = r6
            r6 = 0
            r15.<init>(r4, r6)
            r4 = r15
            androidx.compose.ui.graphics.Brush r4 = (androidx.compose.ui.graphics.Brush) r4
            r5 = r9 & -7169(0xffffffffffffe3ff, float:NaN)
            r9 = r5
            goto L_0x02f6
        L_0x02ee:
            r39 = r4
            r40 = r5
            r19 = r6
            r4 = r50
        L_0x02f6:
            if (r2 == 0) goto L_0x0303
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r2 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r2 = r2.m631getLambda1$foundation_release()
            r6 = r39
            r35 = r2
            goto L_0x0307
        L_0x0303:
            r6 = r39
            r35 = r51
        L_0x0307:
            r15 = r4
            r4 = r17
            r5 = r18
            r2 = r19
            r18 = r9
            r9 = r8
            r8 = r7
            r7 = r40
        L_0x0314:
            r0.endDefaults()
            r46 = r7
            r7 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            java.lang.Object r7 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r17.getEmpty()
            if (r7 != r13) goto L_0x0354
            androidx.compose.ui.text.input.TextFieldValue r7 = new androidx.compose.ui.text.input.TextFieldValue
            r21 = 0
            r13 = 0
            r17 = 6
            r19 = 0
            r39 = r7
            r40 = r37
            r41 = r21
            r43 = r13
            r44 = r17
            r45 = r19
            r39.<init>((java.lang.String) r40, (long) r41, (androidx.compose.ui.text.TextRange) r43, (int) r44, (kotlin.jvm.internal.DefaultConstructorMarker) r45)
            r47 = r14
            r13 = 0
            r14 = 2
            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r7, r13, r14, r13)
            r0.updateRememberedValue(r7)
            goto L_0x0356
        L_0x0354:
            r47 = r14
        L_0x0356:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            androidx.compose.ui.text.input.TextFieldValue r13 = m624BasicTextField$lambda2(r7)
            r21 = 0
            r14 = 0
            r17 = 6
            r19 = 0
            r39 = r13
            r40 = r37
            r41 = r21
            r43 = r14
            r44 = r17
            r45 = r19
            androidx.compose.ui.text.input.TextFieldValue r13 = androidx.compose.ui.text.input.TextFieldValue.m3684copy3r_uNRQ$default((androidx.compose.ui.text.input.TextFieldValue) r39, (java.lang.String) r40, (long) r41, (androidx.compose.ui.text.TextRange) r43, (int) r44, (java.lang.Object) r45)
            androidx.compose.ui.text.input.ImeOptions r26 = r5.toImeOptions$foundation_release(r6)
            r14 = r6 ^ 1
            if (r6 == 0) goto L_0x0383
            r39 = r5
            r25 = 1
            goto L_0x0387
        L_0x0383:
            r25 = r46
            r39 = r5
        L_0x0387:
            r5 = -3686095(0xffffffffffc7c131, float:NaN)
            r0.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            boolean r5 = r0.changed((java.lang.Object) r7)
            boolean r16 = r0.changed((java.lang.Object) r1)
            r5 = r5 | r16
            r40 = r6
            r6 = r38
            boolean r16 = r0.changed((java.lang.Object) r6)
            r5 = r5 | r16
            r41 = r12
            java.lang.Object r12 = r0.rememberedValue()
            if (r5 != 0) goto L_0x03b6
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r12 != r5) goto L_0x03c1
        L_0x03b6:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1 r5 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
            r5.<init>(r1, r6, r7)
            r12 = r5
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            r0.updateRememberedValue(r12)
        L_0x03c1:
            r0.endReplaceableGroup()
            r17 = r12
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r5 = r3 & 896(0x380, float:1.256E-42)
            int r7 = r3 >> 6
            r7 = r7 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r7
            int r7 = r18 << 12
            r12 = r7 & r20
            r5 = r5 | r12
            r12 = r7 & r24
            r5 = r5 | r12
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r7
            r5 = r5 | r12
            r12 = 29360128(0x1c00000, float:7.052966E-38)
            r7 = r7 & r12
            r32 = r5 | r7
            int r5 = r3 >> 18
            r5 = r5 & 112(0x70, float:1.57E-43)
            int r3 = r3 >> 3
            r7 = r3 & 896(0x380, float:1.256E-42)
            r5 = r5 | r7
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | r5
            r5 = r18 & r20
            r33 = r3 | r5
            r34 = 0
            r16 = r13
            r18 = r2
            r19 = r4
            r20 = r8
            r21 = r9
            r22 = r11
            r23 = r15
            r24 = r14
            r27 = r10
            r28 = r41
            r29 = r47
            r30 = r35
            r31 = r0
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            r5 = r47
            r3 = r2
            r7 = r4
            r12 = r8
            r13 = r9
            r14 = r11
            r8 = r39
            r9 = r40
            r4 = r41
            r11 = r46
        L_0x041e:
            androidx.compose.runtime.ScopeUpdateScope r2 = r0.endRestartGroup()
            if (r2 != 0) goto L_0x0425
            goto L_0x044b
        L_0x0425:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4 r19 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4
            r0 = r19
            r1 = r37
            r36 = r2
            r2 = r38
            r6 = r7
            r7 = r8
            r8 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r35
            r16 = r53
            r17 = r54
            r18 = r55
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r36
            r1.updateScope(r0)
        L_0x044b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: BasicTextField$lambda-2  reason: not valid java name */
    private static final TextFieldValue m624BasicTextField$lambda2(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v0, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v1, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v3, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v4, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01b7, code lost:
        if (r10.changed((java.lang.Object) r48) != false) goto L_0x01be;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(androidx.compose.ui.text.input.TextFieldValue r35, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r36, androidx.compose.ui.Modifier r37, boolean r38, boolean r39, androidx.compose.ui.text.TextStyle r40, androidx.compose.foundation.text.KeyboardOptions r41, androidx.compose.foundation.text.KeyboardActions r42, boolean r43, int r44, androidx.compose.ui.text.input.VisualTransformation r45, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.ui.graphics.Brush r48, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.runtime.Composer r50, int r51, int r52, int r53) {
        /*
            r15 = r35
            r14 = r36
            r13 = r51
            r12 = r52
            r11 = r53
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1483898366(0x58727dfe, float:1.06649178E15)
            r1 = r50
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)256@14754L39,263@15056L90,261@14994L688:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x002a
            r0 = r13 | 6
            goto L_0x003a
        L_0x002a:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0039
            boolean r0 = r10.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0036
            r0 = 4
            goto L_0x0037
        L_0x0036:
            r0 = 2
        L_0x0037:
            r0 = r0 | r13
            goto L_0x003a
        L_0x0039:
            r0 = r13
        L_0x003a:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0041
            r0 = r0 | 48
            goto L_0x0051
        L_0x0041:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0051
            boolean r3 = r10.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x004e
            r3 = 32
            goto L_0x0050
        L_0x004e:
            r3 = 16
        L_0x0050:
            r0 = r0 | r3
        L_0x0051:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x0058
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0058:
            r8 = r13 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x006b
            r8 = r37
            boolean r9 = r10.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0067
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r0 = r0 | r9
            goto L_0x006d
        L_0x006b:
            r8 = r37
        L_0x006d:
            r9 = r11 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0078
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x0078:
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x008c
            r1 = r38
            boolean r18 = r10.changed((boolean) r1)
            if (r18 == 0) goto L_0x0087
            r18 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r0 = r0 | r18
            goto L_0x008e
        L_0x008c:
            r1 = r38
        L_0x008e:
            r18 = r11 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r20 = 57344(0xe000, float:8.0356E-41)
            r21 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x009e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r39
            goto L_0x00b1
        L_0x009e:
            r22 = r13 & r20
            r2 = r39
            if (r22 != 0) goto L_0x00b1
            boolean r23 = r10.changed((boolean) r2)
            if (r23 == 0) goto L_0x00ad
            r23 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00af
        L_0x00ad:
            r23 = 8192(0x2000, float:1.14794E-41)
        L_0x00af:
            r0 = r0 | r23
        L_0x00b1:
            r23 = r11 & 32
            r24 = 458752(0x70000, float:6.42848E-40)
            if (r23 == 0) goto L_0x00be
            r25 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r25
            r4 = r40
            goto L_0x00d1
        L_0x00be:
            r25 = r13 & r24
            r4 = r40
            if (r25 != 0) goto L_0x00d1
            boolean r26 = r10.changed((java.lang.Object) r4)
            if (r26 == 0) goto L_0x00cd
            r26 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cf
        L_0x00cd:
            r26 = 65536(0x10000, float:9.18355E-41)
        L_0x00cf:
            r0 = r0 | r26
        L_0x00d1:
            r26 = r11 & 64
            r27 = 3670016(0x380000, float:5.142788E-39)
            if (r26 == 0) goto L_0x00de
            r28 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r28
            r5 = r41
            goto L_0x00f1
        L_0x00de:
            r28 = r13 & r27
            r5 = r41
            if (r28 != 0) goto L_0x00f1
            boolean r29 = r10.changed((java.lang.Object) r5)
            if (r29 == 0) goto L_0x00ed
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ef
        L_0x00ed:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x00ef:
            r0 = r0 | r29
        L_0x00f1:
            r6 = r11 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00fc
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r30
            r7 = r42
            goto L_0x0111
        L_0x00fc:
            r30 = 29360128(0x1c00000, float:7.052966E-38)
            r30 = r13 & r30
            r7 = r42
            if (r30 != 0) goto L_0x0111
            boolean r31 = r10.changed((java.lang.Object) r7)
            if (r31 == 0) goto L_0x010d
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010f
        L_0x010d:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x010f:
            r0 = r0 | r31
        L_0x0111:
            r1 = r11 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x011c
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r31
            r2 = r43
            goto L_0x0131
        L_0x011c:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r13 & r31
            r2 = r43
            if (r31 != 0) goto L_0x0131
            boolean r31 = r10.changed((boolean) r2)
            if (r31 == 0) goto L_0x012d
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012f
        L_0x012d:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012f:
            r0 = r0 | r31
        L_0x0131:
            r2 = r11 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x013c
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r31
            r4 = r44
            goto L_0x0151
        L_0x013c:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r13 & r31
            r4 = r44
            if (r31 != 0) goto L_0x0151
            boolean r31 = r10.changed((int) r4)
            if (r31 == 0) goto L_0x014d
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014f
        L_0x014d:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014f:
            r0 = r0 | r31
        L_0x0151:
            r4 = r11 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x015a
            r22 = r12 | 6
            r5 = r45
            goto L_0x0170
        L_0x015a:
            r31 = r12 & 14
            r5 = r45
            if (r31 != 0) goto L_0x016e
            boolean r31 = r10.changed((java.lang.Object) r5)
            if (r31 == 0) goto L_0x0169
            r22 = 4
            goto L_0x016b
        L_0x0169:
            r22 = 2
        L_0x016b:
            r22 = r12 | r22
            goto L_0x0170
        L_0x016e:
            r22 = r12
        L_0x0170:
            r5 = r11 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0177
            r22 = r22 | 48
            goto L_0x018a
        L_0x0177:
            r31 = r12 & 112(0x70, float:1.57E-43)
            r7 = r46
            if (r31 != 0) goto L_0x018a
            boolean r31 = r10.changed((java.lang.Object) r7)
            if (r31 == 0) goto L_0x0186
            r25 = 32
            goto L_0x0188
        L_0x0186:
            r25 = 16
        L_0x0188:
            r22 = r22 | r25
        L_0x018a:
            r7 = r22
            r8 = r11 & 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x0193
            r7 = r7 | 384(0x180, float:5.38E-43)
            goto L_0x01a7
        L_0x0193:
            r14 = r12 & 896(0x380, float:1.256E-42)
            if (r14 != 0) goto L_0x01a7
            r14 = r47
            boolean r22 = r10.changed((java.lang.Object) r14)
            if (r22 == 0) goto L_0x01a2
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01a4
        L_0x01a2:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01a4:
            r7 = r7 | r29
            goto L_0x01a9
        L_0x01a7:
            r14 = r47
        L_0x01a9:
            r14 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x01c1
            r14 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r14 != 0) goto L_0x01ba
            r14 = r48
            boolean r22 = r10.changed((java.lang.Object) r14)
            if (r22 == 0) goto L_0x01bc
            goto L_0x01be
        L_0x01ba:
            r14 = r48
        L_0x01bc:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x01be:
            r7 = r7 | r16
            goto L_0x01c3
        L_0x01c1:
            r14 = r48
        L_0x01c3:
            r14 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x01cc
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            r12 = r49
            goto L_0x01dd
        L_0x01cc:
            r16 = r12 & r20
            r12 = r49
            if (r16 != 0) goto L_0x01dd
            boolean r16 = r10.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x01d9
            goto L_0x01db
        L_0x01d9:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x01db:
            r7 = r7 | r19
        L_0x01dd:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r16 = r0 & r16
            r17 = 306783378(0x12492492, float:6.3469493E-28)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x021a
            r16 = 46811(0xb6db, float:6.5596E-41)
            r12 = r7 & r16
            r12 = r12 ^ 9362(0x2492, float:1.3119E-41)
            if (r12 != 0) goto L_0x021a
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x01f9
            goto L_0x021a
        L_0x01f9:
            r10.skipToGroupEnd()
            r3 = r37
            r4 = r38
            r5 = r39
            r6 = r40
            r7 = r41
            r8 = r42
            r9 = r43
            r11 = r45
            r12 = r46
            r13 = r47
            r14 = r48
            r15 = r49
            r20 = r10
            r10 = r44
            goto L_0x03d3
        L_0x021a:
            r10.startDefaults()
            r12 = r13 & 1
            r16 = 1
            if (r12 == 0) goto L_0x024f
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x022a
            goto L_0x024f
        L_0x022a:
            r10.skipToGroupEnd()
            r1 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0233
            r7 = r7 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0233:
            r19 = r37
            r21 = r38
            r22 = r39
            r23 = r40
            r14 = r41
            r25 = r42
            r12 = r43
            r26 = r44
            r28 = r45
            r29 = r46
            r30 = r47
            r31 = r48
            r32 = r49
            goto L_0x0326
        L_0x024f:
            if (r3 == 0) goto L_0x0256
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0258
        L_0x0256:
            r3 = r37
        L_0x0258:
            if (r9 == 0) goto L_0x025c
            r9 = 1
            goto L_0x025e
        L_0x025c:
            r9 = r38
        L_0x025e:
            if (r18 == 0) goto L_0x0262
            r12 = 0
            goto L_0x0264
        L_0x0262:
            r12 = r39
        L_0x0264:
            if (r23 == 0) goto L_0x026d
            androidx.compose.ui.text.TextStyle$Companion r17 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r17 = r17.getDefault()
            goto L_0x026f
        L_0x026d:
            r17 = r40
        L_0x026f:
            if (r26 == 0) goto L_0x0278
            androidx.compose.foundation.text.KeyboardOptions$Companion r18 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r18 = r18.getDefault()
            goto L_0x027a
        L_0x0278:
            r18 = r41
        L_0x027a:
            if (r6 == 0) goto L_0x0283
            androidx.compose.foundation.text.KeyboardActions$Companion r6 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r6 = r6.getDefault()
            goto L_0x0285
        L_0x0283:
            r6 = r42
        L_0x0285:
            if (r1 == 0) goto L_0x0289
            r1 = 0
            goto L_0x028b
        L_0x0289:
            r1 = r43
        L_0x028b:
            if (r2 == 0) goto L_0x0291
            r2 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0293
        L_0x0291:
            r2 = r44
        L_0x0293:
            if (r4 == 0) goto L_0x029c
            androidx.compose.ui.text.input.VisualTransformation$Companion r4 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r4 = r4.getNone()
            goto L_0x029e
        L_0x029c:
            r4 = r45
        L_0x029e:
            if (r5 == 0) goto L_0x02a5
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5 r5 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5.INSTANCE
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            goto L_0x02a7
        L_0x02a5:
            r5 = r46
        L_0x02a7:
            if (r8 == 0) goto L_0x02d0
            r8 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r8)
            java.lang.Object r8 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r37 = r1
            java.lang.Object r1 = r19.getEmpty()
            if (r8 != r1) goto L_0x02c9
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r8)
        L_0x02c9:
            r10.endReplaceableGroup()
            r1 = r8
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            goto L_0x02d4
        L_0x02d0:
            r37 = r1
            r1 = r47
        L_0x02d4:
            r8 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x02f1
            androidx.compose.ui.graphics.SolidColor r8 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r19 = androidx.compose.ui.graphics.Color.Companion
            r39 = r1
            r38 = r2
            long r1 = r19.m1622getBlack0d7_KjU()
            r50 = r3
            r3 = 0
            r8.<init>(r1, r3)
            r1 = r8
            androidx.compose.ui.graphics.Brush r1 = (androidx.compose.ui.graphics.Brush) r1
            r2 = r7 & -7169(0xffffffffffffe3ff, float:NaN)
            r7 = r2
            goto L_0x02f9
        L_0x02f1:
            r39 = r1
            r38 = r2
            r50 = r3
            r1 = r48
        L_0x02f9:
            if (r14 == 0) goto L_0x030c
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r2 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r2 = r2.m632getLambda2$foundation_release()
            r26 = r38
            r30 = r39
            r19 = r50
            r31 = r1
            r32 = r2
            goto L_0x0316
        L_0x030c:
            r26 = r38
            r30 = r39
            r32 = r49
            r19 = r50
            r31 = r1
        L_0x0316:
            r28 = r4
            r29 = r5
            r25 = r6
            r21 = r9
            r22 = r12
            r23 = r17
            r14 = r18
            r12 = r37
        L_0x0326:
            r10.endDefaults()
            androidx.compose.ui.text.input.ImeOptions r33 = r14.toImeOptions$foundation_release(r12)
            r8 = r12 ^ 1
            if (r12 == 0) goto L_0x0333
            r9 = 1
            goto L_0x0335
        L_0x0333:
            r9 = r26
        L_0x0335:
            r2 = r0 & 14
            r1 = -3686552(0xffffffffffc7bf68, float:NaN)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            boolean r1 = r10.changed((java.lang.Object) r15)
            r6 = r36
            boolean r3 = r10.changed((java.lang.Object) r6)
            r1 = r1 | r3
            java.lang.Object r3 = r10.rememberedValue()
            if (r1 != 0) goto L_0x035b
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x0366
        L_0x035b:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1 r1 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
            r1.<init>(r15, r6)
            r3 = r1
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r10.updateRememberedValue(r3)
        L_0x0366:
            r10.endReplaceableGroup()
            r1 = r3
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3 = r0 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            int r3 = r0 >> 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r7 << 12
            r4 = r3 & r20
            r2 = r2 | r4
            r4 = r3 & r24
            r2 = r2 | r4
            r4 = r3 & r27
            r2 = r2 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r4
            r16 = r2 | r3
            int r2 = r0 >> 18
            r2 = r2 & 112(0x70, float:1.57E-43)
            int r0 = r0 >> 3
            r3 = r0 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            r2 = r7 & r20
            r17 = r0 | r2
            r18 = 0
            r0 = r35
            r2 = r19
            r3 = r23
            r4 = r28
            r5 = r29
            r6 = r30
            r7 = r31
            r20 = r10
            r10 = r33
            r11 = r25
            r24 = r12
            r12 = r21
            r13 = r22
            r27 = r14
            r14 = r32
            r15 = r20
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r3 = r19
            r4 = r21
            r5 = r22
            r6 = r23
            r9 = r24
            r8 = r25
            r10 = r26
            r7 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r14 = r31
            r15 = r32
        L_0x03d3:
            androidx.compose.runtime.ScopeUpdateScope r2 = r20.endRestartGroup()
            if (r2 != 0) goto L_0x03da
            goto L_0x03f6
        L_0x03da:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8 r19 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8
            r0 = r19
            r1 = r35
            r34 = r2
            r2 = r36
            r16 = r51
            r17 = r52
            r18 = r53
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r34
            r1.updateScope(r0)
        L_0x03f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: BasicTextField$lambda-3  reason: not valid java name */
    public static final void m625BasicTextField$lambda3(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }
}
