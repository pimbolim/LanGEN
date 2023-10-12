package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aä\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u001323\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0001¢\u0006\u0002\u0010\"\u001a\u001d\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010'\u001a\u0015\u0010(\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010)\u001a[\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000\u001a \u00103\u001a\u00020\u00012\u0006\u0010-\u001a\u00020.2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0013H\u0002\u001a\u001c\u00107\u001a\u00020\u0007*\u00020\u00072\u0006\u0010-\u001a\u00020.2\u0006\u0010$\u001a\u00020%H\u0002\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SelectionToolbarAndHandles", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyTextInputServiceOnFocusChange", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "previewKeyEventToDeselectOnBack", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
public final class CoreTextFieldKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r44v1, resolved type: androidx.compose.runtime.saveable.Saver<androidx.compose.foundation.text.TextFieldScrollerPosition, java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v41, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v42, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v43, resolved type: kotlin.jvm.functions.Function3<kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v46, resolved type: kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x087d  */
    /* JADX WARNING: Removed duplicated region for block: B:289:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CoreTextField(androidx.compose.ui.text.input.TextFieldValue r41, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r42, androidx.compose.ui.Modifier r43, androidx.compose.ui.text.TextStyle r44, androidx.compose.ui.text.input.VisualTransformation r45, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.ui.graphics.Brush r48, boolean r49, int r50, androidx.compose.ui.text.input.ImeOptions r51, androidx.compose.foundation.text.KeyboardActions r52, boolean r53, boolean r54, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.runtime.Composer r56, int r57, int r58, int r59) {
        /*
            r15 = r41
            r14 = r42
            r13 = r57
            r12 = r58
            r11 = r59
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -55015061(0xfffffffffcb8896b, float:-7.665358E36)
            r1 = r56
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(CoreTextField)P(13,9,7,12,14,8,4!1,11,6,3,5,2,10)182@10171L21,188@10478L7,189@10527L7,190@10595L7,191@10660L7,199@10969L42,196@10876L135,202@11052L254,212@11421L280,250@12533L26,253@12619L51,259@12923L7,260@12974L7,261@13031L7,459@20094L86,463@20186L517,508@21787L3261:CoreTextField.kt#423gt5"
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
            r8 = r43
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
            r8 = r43
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
            r1 = r44
            boolean r18 = r10.changed((java.lang.Object) r1)
            if (r18 == 0) goto L_0x0087
            r18 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r0 = r0 | r18
            goto L_0x008e
        L_0x008c:
            r1 = r44
        L_0x008e:
            r18 = r11 & 16
            r19 = 16384(0x4000, float:2.2959E-41)
            r20 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x009b
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r4 = r45
            goto L_0x00b1
        L_0x009b:
            r21 = 57344(0xe000, float:8.0356E-41)
            r21 = r13 & r21
            r4 = r45
            if (r21 != 0) goto L_0x00b1
            boolean r22 = r10.changed((java.lang.Object) r4)
            if (r22 == 0) goto L_0x00ad
            r22 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00af
        L_0x00ad:
            r22 = 8192(0x2000, float:1.14794E-41)
        L_0x00af:
            r0 = r0 | r22
        L_0x00b1:
            r22 = r11 & 32
            if (r22 == 0) goto L_0x00bc
            r23 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r23
            r5 = r46
            goto L_0x00d1
        L_0x00bc:
            r23 = 458752(0x70000, float:6.42848E-40)
            r23 = r13 & r23
            r5 = r46
            if (r23 != 0) goto L_0x00d1
            boolean r24 = r10.changed((java.lang.Object) r5)
            if (r24 == 0) goto L_0x00cd
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cf
        L_0x00cd:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x00cf:
            r0 = r0 | r24
        L_0x00d1:
            r24 = r11 & 64
            if (r24 == 0) goto L_0x00dc
            r25 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r25
            r6 = r47
            goto L_0x00f1
        L_0x00dc:
            r25 = 3670016(0x380000, float:5.142788E-39)
            r25 = r13 & r25
            r6 = r47
            if (r25 != 0) goto L_0x00f1
            boolean r26 = r10.changed((java.lang.Object) r6)
            if (r26 == 0) goto L_0x00ed
            r26 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ef
        L_0x00ed:
            r26 = 524288(0x80000, float:7.34684E-40)
        L_0x00ef:
            r0 = r0 | r26
        L_0x00f1:
            r26 = 29360128(0x1c00000, float:7.052966E-38)
            r26 = r13 & r26
            if (r26 != 0) goto L_0x010d
            r7 = r11 & 128(0x80, float:1.794E-43)
            if (r7 != 0) goto L_0x0106
            r7 = r48
            boolean r27 = r10.changed((java.lang.Object) r7)
            if (r27 == 0) goto L_0x0108
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010a
        L_0x0106:
            r7 = r48
        L_0x0108:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x010a:
            r0 = r0 | r27
            goto L_0x010f
        L_0x010d:
            r7 = r48
        L_0x010f:
            r2 = r11 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x011a
            r28 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r28
            r1 = r49
            goto L_0x012f
        L_0x011a:
            r28 = 234881024(0xe000000, float:1.5777218E-30)
            r28 = r13 & r28
            r1 = r49
            if (r28 != 0) goto L_0x012f
            boolean r28 = r10.changed((boolean) r1)
            if (r28 == 0) goto L_0x012b
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012d
        L_0x012b:
            r28 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012d:
            r0 = r0 | r28
        L_0x012f:
            r1 = r11 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x013a
            r28 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r28
            r4 = r50
            goto L_0x014f
        L_0x013a:
            r28 = 1879048192(0x70000000, float:1.58456325E29)
            r28 = r13 & r28
            r4 = r50
            if (r28 != 0) goto L_0x014f
            boolean r28 = r10.changed((int) r4)
            if (r28 == 0) goto L_0x014b
            r28 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014d
        L_0x014b:
            r28 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014d:
            r0 = r0 | r28
        L_0x014f:
            r28 = r12 & 14
            if (r28 != 0) goto L_0x0169
            r4 = r11 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L_0x0162
            r4 = r51
            boolean r28 = r10.changed((java.lang.Object) r4)
            if (r28 == 0) goto L_0x0164
            r28 = 4
            goto L_0x0166
        L_0x0162:
            r4 = r51
        L_0x0164:
            r28 = 2
        L_0x0166:
            r28 = r12 | r28
            goto L_0x016d
        L_0x0169:
            r4 = r51
            r28 = r12
        L_0x016d:
            r4 = r11 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0174
            r28 = r28 | 48
            goto L_0x0187
        L_0x0174:
            r29 = r12 & 112(0x70, float:1.57E-43)
            r5 = r52
            if (r29 != 0) goto L_0x0187
            boolean r29 = r10.changed((java.lang.Object) r5)
            if (r29 == 0) goto L_0x0183
            r21 = 32
            goto L_0x0185
        L_0x0183:
            r21 = 16
        L_0x0185:
            r28 = r28 | r21
        L_0x0187:
            r5 = r28
            r6 = r11 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x0190
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x01a4
        L_0x0190:
            r7 = r12 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x01a4
            r7 = r53
            boolean r21 = r10.changed((boolean) r7)
            if (r21 == 0) goto L_0x019f
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x01a1
        L_0x019f:
            r25 = 128(0x80, float:1.794E-43)
        L_0x01a1:
            r5 = r5 | r25
            goto L_0x01a6
        L_0x01a4:
            r7 = r53
        L_0x01a6:
            r7 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x01ad
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x01bf
        L_0x01ad:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x01bf
            r8 = r54
            boolean r21 = r10.changed((boolean) r8)
            if (r21 == 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01ba:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x01bc:
            r5 = r5 | r16
            goto L_0x01c1
        L_0x01bf:
            r8 = r54
        L_0x01c1:
            r8 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x01ca
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r12 = r55
            goto L_0x01de
        L_0x01ca:
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r12 & r16
            r12 = r55
            if (r16 != 0) goto L_0x01de
            boolean r16 = r10.changed((java.lang.Object) r12)
            if (r16 == 0) goto L_0x01da
            goto L_0x01dc
        L_0x01da:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x01dc:
            r5 = r5 | r19
        L_0x01de:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r0 & r16
            r16 = 306783378(0x12492492, float:6.3469493E-28)
            r0 = r0 ^ r16
            if (r0 != 0) goto L_0x0218
            r0 = 46811(0xb6db, float:6.5596E-41)
            r0 = r0 & r5
            r0 = r0 ^ 9362(0x2492, float:1.3119E-41)
            if (r0 != 0) goto L_0x0218
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x01f9
            goto L_0x0218
        L_0x01f9:
            r10.skipToGroupEnd()
            r3 = r43
            r4 = r44
            r5 = r45
            r6 = r46
            r7 = r47
            r8 = r48
            r9 = r49
            r11 = r51
            r13 = r53
            r14 = r54
            r0 = r10
            r15 = r12
            r10 = r50
            r12 = r52
            goto L_0x0876
        L_0x0218:
            r10.startDefaults()
            r0 = r13 & 1
            if (r0 == 0) goto L_0x024f
            boolean r0 = r10.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0226
            goto L_0x024f
        L_0x0226:
            r10.skipToGroupEnd()
            r0 = r11 & 128(0x80, float:1.794E-43)
            r0 = r11 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0231
            r5 = r5 & -15
        L_0x0231:
            r14 = r43
            r17 = r44
            r13 = r45
            r18 = r46
            r12 = r47
            r20 = r48
            r21 = r49
            r9 = r50
            r8 = r51
            r22 = r52
            r7 = r53
            r23 = r54
            r6 = r55
            r24 = r5
            goto L_0x0302
        L_0x024f:
            if (r3 == 0) goto L_0x0256
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0258
        L_0x0256:
            r0 = r43
        L_0x0258:
            if (r9 == 0) goto L_0x0261
            androidx.compose.ui.text.TextStyle$Companion r3 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r3 = r3.getDefault()
            goto L_0x0263
        L_0x0261:
            r3 = r44
        L_0x0263:
            if (r18 == 0) goto L_0x026c
            androidx.compose.ui.text.input.VisualTransformation$Companion r9 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r9 = r9.getNone()
            goto L_0x026e
        L_0x026c:
            r9 = r45
        L_0x026e:
            if (r22 == 0) goto L_0x0275
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1 r17 = androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1.INSTANCE
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            goto L_0x0277
        L_0x0275:
            r17 = r46
        L_0x0277:
            if (r24 == 0) goto L_0x027c
            r18 = 0
            goto L_0x027e
        L_0x027c:
            r18 = r47
        L_0x027e:
            r12 = r11 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0294
            androidx.compose.ui.graphics.SolidColor r12 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r20 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r20.m1632getUnspecified0d7_KjU()
            r43 = r0
            r0 = 0
            r12.<init>(r13, r0)
            r0 = r12
            androidx.compose.ui.graphics.Brush r0 = (androidx.compose.ui.graphics.Brush) r0
            goto L_0x0298
        L_0x0294:
            r43 = r0
            r0 = r48
        L_0x0298:
            if (r2 == 0) goto L_0x029c
            r2 = 1
            goto L_0x029e
        L_0x029c:
            r2 = r49
        L_0x029e:
            if (r1 == 0) goto L_0x02a4
            r1 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x02a6
        L_0x02a4:
            r1 = r50
        L_0x02a6:
            r12 = r11 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x02b3
            androidx.compose.ui.text.input.ImeOptions$Companion r12 = androidx.compose.ui.text.input.ImeOptions.Companion
            androidx.compose.ui.text.input.ImeOptions r12 = r12.getDefault()
            r5 = r5 & -15
            goto L_0x02b5
        L_0x02b3:
            r12 = r51
        L_0x02b5:
            if (r4 == 0) goto L_0x02be
            androidx.compose.foundation.text.KeyboardActions$Companion r4 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r4 = r4.getDefault()
            goto L_0x02c0
        L_0x02be:
            r4 = r52
        L_0x02c0:
            if (r6 == 0) goto L_0x02c4
            r6 = 1
            goto L_0x02c6
        L_0x02c4:
            r6 = r53
        L_0x02c6:
            if (r7 == 0) goto L_0x02ca
            r7 = 0
            goto L_0x02cc
        L_0x02ca:
            r7 = r54
        L_0x02cc:
            if (r8 == 0) goto L_0x02ea
            androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt r8 = androidx.compose.foundation.text.ComposableSingletons$CoreTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r8 = r8.m634getLambda1$foundation_release()
            r14 = r43
            r20 = r0
            r21 = r2
            r22 = r4
            r24 = r5
            r23 = r7
            r13 = r9
            r9 = r1
            r7 = r6
            r6 = r8
            r8 = r12
            r12 = r18
            r18 = r17
            goto L_0x0300
        L_0x02ea:
            r14 = r43
            r20 = r0
            r21 = r2
            r22 = r4
            r24 = r5
            r23 = r7
            r13 = r9
            r8 = r12
            r12 = r18
            r9 = r1
            r7 = r6
            r18 = r17
            r6 = r55
        L_0x0300:
            r17 = r3
        L_0x0302:
            r10.endDefaults()
            r0 = 0
            androidx.compose.runtime.RecomposeScope r1 = androidx.compose.runtime.ComposablesKt.getCurrentRecomposeScope(r10, r0)
            androidx.compose.ui.focus.FocusRequester r0 = new androidx.compose.ui.focus.FocusRequester
            r0.<init>()
            r2 = -55013850(0xfffffffffcb88e26, float:-7.666126E36)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "187@10439L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            r3 = 103361330(0x6292b32, float:3.1817102E-35)
            if (r7 == 0) goto L_0x0337
            if (r23 == 0) goto L_0x0324
            goto L_0x0337
        L_0x0324:
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextInputService()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r2)
            java.lang.Object r4 = r10.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.text.input.TextInputService r4 = (androidx.compose.ui.text.input.TextInputService) r4
            goto L_0x0338
        L_0x0337:
            r4 = 0
        L_0x0338:
            r10.endReplaceableGroup()
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r2)
            java.lang.Object r5 = r10.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r25 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFontLoader()
            r55 = r6
            r6 = r25
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r2)
            java.lang.Object r6 = r10.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.text.font.Font$ResourceLoader r6 = (androidx.compose.ui.text.font.Font.ResourceLoader) r6
            androidx.compose.runtime.ProvidableCompositionLocal r25 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            r11 = r25
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r2)
            java.lang.Object r11 = r10.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.foundation.text.selection.TextSelectionColors r11 = (androidx.compose.foundation.text.selection.TextSelectionColors) r11
            long r25 = r11.m821getBackgroundColor0d7_KjU()
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r2)
            java.lang.Object r11 = r10.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.focus.FocusManager r11 = (androidx.compose.ui.focus.FocusManager) r11
            r3 = 1
            if (r9 != r3) goto L_0x039a
            if (r21 != 0) goto L_0x039a
            boolean r3 = r8.getSingleLine()
            if (r3 == 0) goto L_0x039a
            r3 = 1
            goto L_0x039b
        L_0x039a:
            r3 = 0
        L_0x039b:
            if (r3 == 0) goto L_0x03a0
            androidx.compose.foundation.gestures.Orientation r3 = androidx.compose.foundation.gestures.Orientation.Horizontal
            goto L_0x03a2
        L_0x03a0:
            androidx.compose.foundation.gestures.Orientation r3 = androidx.compose.foundation.gestures.Orientation.Vertical
        L_0x03a2:
            r30 = r9
            r29 = r14
            r14 = 1
            java.lang.Object[] r9 = new java.lang.Object[r14]
            r14 = 0
            r9[r14] = r3
            androidx.compose.foundation.text.TextFieldScrollerPosition$Companion r14 = androidx.compose.foundation.text.TextFieldScrollerPosition.Companion
            androidx.compose.runtime.saveable.Saver r14 = r14.getSaver()
            r31 = 0
            r32 = r7
            r7 = -3686930(0xffffffffffc7bdee, float:NaN)
            r10.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r7)
            boolean r7 = r10.changed((java.lang.Object) r3)
            r33 = r12
            java.lang.Object r12 = r10.rememberedValue()
            if (r7 != 0) goto L_0x03d5
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r12 != r7) goto L_0x03e0
        L_0x03d5:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1 r7 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
            r7.<init>(r3)
            r12 = r7
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r10.updateRememberedValue(r12)
        L_0x03e0:
            r10.endReplaceableGroup()
            r3 = r12
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r7 = 72
            r12 = 4
            r43 = r9
            r44 = r14
            r45 = r31
            r46 = r3
            r47 = r10
            r48 = r7
            r49 = r12
            java.lang.Object r3 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r43, r44, (java.lang.String) r45, r46, (androidx.compose.runtime.Composer) r47, (int) r48, (int) r49)
            androidx.compose.foundation.text.TextFieldScrollerPosition r3 = (androidx.compose.foundation.text.TextFieldScrollerPosition) r3
            r7 = -3686552(0xffffffffffc7bf68, float:NaN)
            r10.startReplaceableGroup(r7)
            java.lang.String r7 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r7)
            boolean r7 = r10.changed((java.lang.Object) r15)
            boolean r9 = r10.changed((java.lang.Object) r13)
            r7 = r7 | r9
            java.lang.Object r9 = r10.rememberedValue()
            if (r7 != 0) goto L_0x0422
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r9 != r7) goto L_0x0420
            goto L_0x0422
        L_0x0420:
            r12 = r8
            goto L_0x0444
        L_0x0422:
            androidx.compose.ui.text.AnnotatedString r7 = r41.getAnnotatedString()
            androidx.compose.ui.text.input.TransformedText r7 = r13.filter(r7)
            androidx.compose.ui.text.TextRange r9 = r41.m3687getCompositionMzsxiRA()
            r12 = r8
            if (r9 != 0) goto L_0x0432
            goto L_0x043e
        L_0x0432:
            long r8 = r9.m3575unboximpl()
            androidx.compose.foundation.text.TextFieldDelegate$Companion r14 = androidx.compose.foundation.text.TextFieldDelegate.Companion
            androidx.compose.ui.text.input.TransformedText r8 = r14.m701applyCompositionDecoration72CqOWE(r8, r7)
            if (r8 != 0) goto L_0x0440
        L_0x043e:
            r9 = r7
            goto L_0x0441
        L_0x0440:
            r9 = r8
        L_0x0441:
            r10.updateRememberedValue(r9)
        L_0x0444:
            r10.endReplaceableGroup()
            r7 = r9
            androidx.compose.ui.text.input.TransformedText r7 = (androidx.compose.ui.text.input.TransformedText) r7
            androidx.compose.ui.text.AnnotatedString r8 = r7.getText()
            androidx.compose.ui.text.input.OffsetMapping r9 = r7.getOffsetMapping()
            r14 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r14)
            java.lang.String r14 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            r31 = r3
            java.lang.Object r3 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r34 = androidx.compose.runtime.Composer.Companion
            r35 = r7
            java.lang.Object r7 = r34.getEmpty()
            if (r3 != r7) goto L_0x049a
            androidx.compose.foundation.text.TextFieldState r3 = new androidx.compose.foundation.text.TextFieldState
            androidx.compose.foundation.text.TextDelegate r7 = new androidx.compose.foundation.text.TextDelegate
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 148(0x94, float:2.07E-43)
            r39 = 0
            r43 = r7
            r44 = r8
            r45 = r17
            r46 = r34
            r47 = r21
            r48 = r36
            r49 = r5
            r50 = r6
            r51 = r37
            r52 = r38
            r53 = r39
            r43.<init>(r44, r45, r46, r47, r48, r49, r50, r51, r52, r53)
            r3.<init>(r7)
            r10.updateRememberedValue(r3)
        L_0x049a:
            r10.endReplaceableGroup()
            r7 = r3
            androidx.compose.foundation.text.TextFieldState r7 = (androidx.compose.foundation.text.TextFieldState) r7
            r43 = r7
            r44 = r8
            r45 = r17
            r46 = r21
            r47 = r5
            r48 = r6
            r49 = r42
            r50 = r22
            r51 = r11
            r52 = r25
            r43.m725updateaKPrnQ(r44, r45, r46, r47, r48, r49, r50, r51, r52)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onValueChangeWrapper$1 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onValueChangeWrapper$1
            r3.<init>(r7, r1)
            r1 = r3
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onImeActionPerformedWrapper$1 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onImeActionPerformedWrapper$1
            r3.<init>(r7)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.text.input.EditProcessor r5 = r7.getProcessor()
            androidx.compose.ui.text.input.TextInputSession r6 = r7.getInputSession()
            r5.reset(r15, r6)
            r5 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            java.lang.Object r5 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r5 != r6) goto L_0x04f1
            androidx.compose.foundation.text.UndoManager r5 = new androidx.compose.foundation.text.UndoManager
            r6 = 0
            r8 = 0
            r11 = 1
            r5.<init>(r8, r11, r6)
            r10.updateRememberedValue(r5)
        L_0x04f1:
            r10.endReplaceableGroup()
            androidx.compose.foundation.text.UndoManager r5 = (androidx.compose.foundation.text.UndoManager) r5
            r25 = 0
            r6 = 2
            r8 = 0
            r43 = r5
            r44 = r41
            r45 = r25
            r47 = r6
            r48 = r8
            androidx.compose.foundation.text.UndoManager.snapshotIfNeeded$default(r43, r44, r45, r47, r48)
            r6 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            java.lang.Object r6 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x0524
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r6 = new androidx.compose.foundation.text.selection.TextFieldSelectionManager
            r6.<init>(r5)
            r10.updateRememberedValue(r6)
        L_0x0524:
            r10.endReplaceableGroup()
            r11 = r6
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r11 = (androidx.compose.foundation.text.selection.TextFieldSelectionManager) r11
            r11.setOffsetMapping$foundation_release(r9)
            r11.setVisualTransformation$foundation_release(r13)
            r11.setOnValueChange$foundation_release(r1)
            r11.setState$foundation_release(r7)
            r11.setValue$foundation_release(r15)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalClipboardManager()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r8 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r8, r2)
            java.lang.Object r6 = r10.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.ClipboardManager r6 = (androidx.compose.ui.platform.ClipboardManager) r6
            r11.setClipboardManager$foundation_release(r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalTextToolbar()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r8, r2)
            java.lang.Object r6 = r10.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.TextToolbar r6 = (androidx.compose.ui.platform.TextToolbar) r6
            r11.setTextToolbar(r6)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalHapticFeedback()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r8, r2)
            java.lang.Object r6 = r10.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.hapticfeedback.HapticFeedback r6 = (androidx.compose.ui.hapticfeedback.HapticFeedback) r6
            r11.setHapticFeedBack(r6)
            r11.setFocusRequester(r0)
            r6 = r23 ^ 1
            r11.setEditable(r6)
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1 r8 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1
            r43 = r8
            r44 = r7
            r45 = r4
            r46 = r41
            r47 = r12
            r48 = r1
            r49 = r3
            r50 = r9
            r51 = r11
            r43.<init>(r44, r45, r46, r47, r48, r49, r50, r51)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r25 = r2
            r14 = r32
            r2 = r33
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.textFieldFocusModifier(r6, r14, r0, r2, r8)
            boolean r8 = androidx.compose.foundation.text.TouchMode_androidKt.isInTouchMode()
            if (r8 == 0) goto L_0x05e8
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            r26 = r6
            androidx.compose.foundation.text.TextDragObserver r6 = r11.getTouchSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.longPressDragGestureFilter(r8, r6, r14)
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r8 = (androidx.compose.ui.Modifier) r8
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1 r27 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1
            r43 = r27
            r44 = r7
            r45 = r0
            r46 = r23
            r47 = r11
            r48 = r9
            r49 = r1
            r43.<init>(r44, r45, r46, r47, r48, r49)
            r32 = r5
            r5 = r27
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.text.TextFieldPressGestureFilterKt.tapPressTextFieldModifier(r8, r2, r14, r5)
            androidx.compose.ui.Modifier r5 = r5.then(r6)
            r33 = r2
            r56 = r3
            goto L_0x0607
        L_0x05e8:
            r32 = r5
            r26 = r6
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            androidx.compose.foundation.text.selection.MouseSelectionObserver r6 = r11.getMouseSelectionObserver$foundation_release()
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.text.TextFieldGestureModifiersKt.mouseDragGestureDetector(r5, r6, r14)
            androidx.compose.ui.input.pointer.PointerIcon r6 = androidx.compose.foundation.text.TextPointerIcon_androidKt.getTextPointerIcon()
            r33 = r2
            r56 = r3
            r2 = 0
            r3 = 0
            r8 = 2
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.input.pointer.PointerIconKt.pointerHoverIcon$default(r5, r6, r3, r8, r2)
        L_0x0607:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1
            r3.<init>(r7, r15, r9)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.draw.DrawModifierKt.drawBehind(r2, r3)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1 r3 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1
            r43 = r3
            r44 = r4
            r45 = r7
            r46 = r11
            r47 = r41
            r48 = r9
            r43.<init>(r44, r45, r46, r47, r48)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r27 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r2, r3)
            boolean r2 = r13 instanceof androidx.compose.ui.text.input.PasswordVisualTransformation
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1
            r43 = r6
            r44 = r12
            r45 = r35
            r46 = r41
            r47 = r14
            r48 = r2
            r49 = r23
            r50 = r7
            r51 = r1
            r52 = r9
            r53 = r11
            r54 = r0
            r43.<init>(r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r3, r0, r6)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            if (r14 == 0) goto L_0x0665
            if (r23 != 0) goto L_0x0665
            r3 = 1
            goto L_0x0666
        L_0x0665:
            r3 = 0
        L_0x0666:
            r43 = r0
            r44 = r7
            r45 = r41
            r46 = r9
            r47 = r20
            r48 = r3
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.text.TextFieldCursorKt.cursor(r43, r44, r45, r46, r47, r48)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$2
            r0.<init>(r11)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r3 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r10, (int) r3)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3
            r43 = r0
            r44 = r4
            r45 = r7
            r46 = r41
            r47 = r12
            r48 = r1
            r49 = r56
            r43.<init>(r44, r45, r46, r47, r48, r49)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = r24 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r12, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r0, (androidx.compose.runtime.Composer) r10, (int) r1)
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r1 = r23 ^ 1
            r4 = r30
            r3 = 1
            if (r4 != r3) goto L_0x06a9
            r3 = 1
            goto L_0x06aa
        L_0x06a9:
            r3 = 0
        L_0x06aa:
            r43 = r0
            r44 = r7
            r45 = r11
            r46 = r41
            r47 = r1
            r48 = r3
            r49 = r9
            r50 = r32
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.text.TextFieldKeyInputKt.textFieldKeyInput(r43, r44, r45, r46, r47, r48, r49, r50)
            r1 = r29
            r3 = r31
            r9 = r33
            r29 = r12
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.text.TextFieldScrollKt.textFieldScrollable(r1, r3, r9, r14)
            androidx.compose.ui.Modifier r5 = r12.then(r5)
            androidx.compose.ui.Modifier r2 = r5.then(r2)
            r5 = r26
            androidx.compose.ui.Modifier r2 = r2.then(r5)
            androidx.compose.ui.Modifier r2 = previewKeyEventToDeselectOnBack(r2, r7, r11)
            androidx.compose.ui.Modifier r0 = r2.then(r0)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1 r2 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
            r2.<init>(r7)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r0, r2)
            if (r14 == 0) goto L_0x06fb
            boolean r2 = r7.getHasFocus()
            if (r2 == 0) goto L_0x06fb
            boolean r2 = androidx.compose.foundation.text.TouchMode_androidKt.isInTouchMode()
            if (r2 == 0) goto L_0x06fb
            r12 = 1
            goto L_0x06fc
        L_0x06fb:
            r12 = 0
        L_0x06fc:
            if (r12 == 0) goto L_0x0707
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.text.TextFieldMagnifier_androidKt.textFieldMagnifier(r2, r11)
            goto L_0x070b
        L_0x0707:
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
        L_0x070b:
            r26 = r2
            r2 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            r5 = 48
            r32 = r14
            r14 = 1
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r14, r10, r5)
            r5 = 1376089394(0x52057532, float:1.43299215E11)
            r10.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r14 = r25
            r25 = r1
            r1 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r14)
            java.lang.Object r5 = r10.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r28 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r43 = r7
            r7 = r28
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r14)
            java.lang.Object r7 = r10.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r28 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r33 = r9
            r9 = r28
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r14)
            java.lang.Object r1 = r10.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.platform.ViewConfiguration r1 = (androidx.compose.ui.platform.ViewConfiguration) r1
            androidx.compose.ui.node.ComposeUiNode$Companion r9 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r9.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r14 = r10.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x078c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x078c:
            r10.startReusableNode()
            boolean r14 = r10.getInserting()
            if (r14 == 0) goto L_0x0799
            r10.createNode(r9)
            goto L_0x079c
        L_0x0799:
            r10.useNode()
        L_0x079c:
            r10.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1234constructorimpl(r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r2, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r5, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r7, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r1, r2)
            r10.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r10)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r1)
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.invoke(r1, r10, r2)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r10.startReplaceableGroup(r0)
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r0 = -1618010203(0xffffffff9f8f1fa5, float:-6.061521E-20)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C509@21867L3175:CoreTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r14 = -819907593(0xffffffffcf2133f7, float:-2.70453734E9)
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1 r9 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
            r0 = r9
            r16 = r25
            r1 = r4
            r25 = r33
            r2 = r17
            r28 = r4
            r4 = r41
            r5 = r13
            r7 = r55
            r31 = r43
            r15 = r7
            r30 = r32
            r7 = r8
            r8 = r27
            r55 = r15
            r27 = r28
            r15 = r9
            r9 = r26
            r26 = r15
            r15 = r10
            r10 = r31
            r19 = r25
            r25 = r15
            r15 = 1
            r28 = r13
            r13 = r23
            r15 = -819907593(0xffffffffcf2133f7, float:-2.70453734E9)
            r14 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r25
            r1 = r26
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r15, r2, r1)
            int r2 = r24 >> 9
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8 = r55
            r8.invoke(r1, r0, r2)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r15 = r8
            r3 = r16
            r4 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r12 = r22
            r14 = r23
            r10 = r27
            r5 = r28
            r11 = r29
            r13 = r30
        L_0x0876:
            androidx.compose.runtime.ScopeUpdateScope r2 = r0.endRestartGroup()
            if (r2 != 0) goto L_0x087d
            goto L_0x0899
        L_0x087d:
            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5 r19 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
            r0 = r19
            r1 = r41
            r40 = r2
            r2 = r42
            r16 = r57
            r17 = r58
            r18 = r59
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r40
            r1.updateScope(r0)
        L_0x0899:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, boolean, int, androidx.compose.ui.text.input.ImeOptions, androidx.compose.foundation.text.KeyboardActions, boolean, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new CoreTextFieldKt$previewKeyEventToDeselectOnBack$1(textFieldState, textFieldSelectionManager));
    }

    /* access modifiers changed from: private */
    public static final void tapToFocus(TextFieldState textFieldState, FocusRequester focusRequester, boolean z) {
        TextInputSession inputSession;
        if (!textFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else if (z && (inputSession = textFieldState.getInputSession()) != null) {
            inputSession.showSoftwareKeyboard();
        }
    }

    /* access modifiers changed from: private */
    public static final void notifyTextInputServiceOnFocusChange(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, Function1<? super TextFieldValue, Unit> function1, Function1<? super ImeAction, Unit> function12, OffsetMapping offsetMapping) {
        TextLayoutResultProxy layoutResult;
        TextFieldState textFieldState2 = textFieldState;
        if (textFieldState.getHasFocus()) {
            TextInputSession onFocus$foundation_release = TextFieldDelegate.Companion.onFocus$foundation_release(textInputService, textFieldValue, textFieldState.getProcessor(), imeOptions, function1, function12);
            LayoutCoordinates layoutCoordinates = textFieldState.getLayoutCoordinates();
            if (!(layoutCoordinates == null || (layoutResult = textFieldState.getLayoutResult()) == null)) {
                TextFieldDelegate.Companion.notifyFocusedRect$foundation_release(textFieldValue, textFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, onFocus$foundation_release, textFieldState.getHasFocus(), offsetMapping);
            }
            textFieldState.setInputSession(onFocus$foundation_release);
            return;
        }
        TextInputSession inputSession = textFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.Companion.onBlur$foundation_release(inputSession, textFieldState.getProcessor(), function1);
        }
        textFieldState.setInputSession((TextInputSession) null);
    }

    /* access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(TextFieldSelectionManager textFieldSelectionManager, boolean z, Composer composer, int i) {
        TextLayoutResultProxy layoutResult;
        Composer startRestartGroup = composer.startRestartGroup(-498401361);
        ComposerKt.sourceInformation(startRestartGroup, "C(SelectionToolbarAndHandles)825@34235L202:CoreTextField.kt#423gt5");
        if (z) {
            TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
            TextLayoutResult textLayoutResult = null;
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null)) {
                textLayoutResult = layoutResult.getValue();
            }
            if (textLayoutResult != null) {
                if (!TextRange.m3565getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().m3688getSelectiond9O1mEE())) {
                    int originalToTransformed = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m3571getStartimpl(textFieldSelectionManager.getValue$foundation_release().m3688getSelectiond9O1mEE()));
                    int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m3566getEndimpl(textFieldSelectionManager.getValue$foundation_release().m3688getSelectiond9O1mEE()));
                    ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                    boolean z2 = true;
                    ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                    startRestartGroup.startReplaceableGroup(-498400769);
                    ComposerKt.sourceInformation(startRestartGroup, "818@33912L203");
                    TextFieldState state$foundation_release2 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release2 != null && state$foundation_release2.getShowSelectionHandleStart()) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, 518);
                    }
                    startRestartGroup.endReplaceableGroup();
                    TextFieldState state$foundation_release3 = textFieldSelectionManager.getState$foundation_release();
                    if (state$foundation_release3 == null || !state$foundation_release3.getShowSelectionHandleEnd()) {
                        z2 = false;
                    }
                    if (z2) {
                        TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, 518);
                    }
                }
                TextFieldState state$foundation_release4 = textFieldSelectionManager.getState$foundation_release();
                if (state$foundation_release4 != null) {
                    if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                        state$foundation_release4.setShowFloatingToolbar(false);
                    }
                    if (state$foundation_release4.getHasFocus()) {
                        if (state$foundation_release4.getShowFloatingToolbar()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                        }
                    }
                }
            }
        } else {
            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CoreTextFieldKt$SelectionToolbarAndHandles$2(textFieldSelectionManager, z, i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0057, code lost:
        r1 = r1.getLayoutResult();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextFieldCursorHandle(androidx.compose.foundation.text.selection.TextFieldSelectionManager r7, androidx.compose.runtime.Composer r8, int r9) {
        /*
            java.lang.String r0 = "manager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -1260650262(0xffffffffb4dc00ea, float:-4.0978858E-7)
            androidx.compose.runtime.Composer r8 = r8.startRestartGroup(r0)
            java.lang.String r0 = "C(TextFieldCursorHandle)851@35325L50,*856@35568L7,859@35661L238:CoreTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            androidx.compose.ui.text.input.OffsetMapping r0 = r7.getOffsetMapping$foundation_release()
            androidx.compose.ui.text.input.TextFieldValue r1 = r7.getValue$foundation_release()
            long r1 = r1.m3688getSelectiond9O1mEE()
            int r1 = androidx.compose.ui.text.TextRange.m3571getStartimpl(r1)
            int r0 = r0.originalToTransformed(r1)
            r1 = -3686930(0xffffffffffc7bdee, float:NaN)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            boolean r1 = r8.changed((java.lang.Object) r7)
            java.lang.Object r2 = r8.rememberedValue()
            if (r1 != 0) goto L_0x0042
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0049
        L_0x0042:
            androidx.compose.foundation.text.TextDragObserver r2 = r7.cursorDragObserver$foundation_release()
            r8.updateRememberedValue(r2)
        L_0x0049:
            r8.endReplaceableGroup()
            androidx.compose.foundation.text.TextDragObserver r2 = (androidx.compose.foundation.text.TextDragObserver) r2
            androidx.compose.foundation.text.TextFieldState r1 = r7.getState$foundation_release()
            r3 = 0
            if (r1 != 0) goto L_0x0057
        L_0x0055:
            r1 = r3
            goto L_0x0062
        L_0x0057:
            androidx.compose.foundation.text.TextLayoutResultProxy r1 = r1.getLayoutResult()
            if (r1 != 0) goto L_0x005e
            goto L_0x0055
        L_0x005e:
            androidx.compose.ui.text.TextLayoutResult r1 = r1.getValue()
        L_0x0062:
            if (r1 != 0) goto L_0x0065
            goto L_0x00c0
        L_0x0065:
            r4 = 0
            androidx.compose.ui.text.TextLayoutInput r5 = r1.getLayoutInput()
            androidx.compose.ui.text.AnnotatedString r5 = r5.getText()
            int r5 = r5.length()
            int r0 = kotlin.ranges.RangesKt.coerceIn((int) r0, (int) r4, (int) r5)
            androidx.compose.ui.geometry.Rect r0 = r1.getCursorRect(r0)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r4 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r4, r5)
            java.lang.Object r1 = r8.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            float r4 = r0.getLeft()
            float r5 = androidx.compose.foundation.text.TextFieldCursorKt.getDefaultCursorThickness()
            float r1 = r1.m3828toPx0680j_4(r5)
            r5 = 2
            float r5 = (float) r5
            float r1 = r1 / r5
            float r4 = r4 + r1
            float r0 = r0.getBottom()
            long r0 = androidx.compose.ui.geometry.OffsetKt.Offset(r4, r0)
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1 r5 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
            r5.<init>(r2, r3)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt.pointerInput((androidx.compose.ui.Modifier) r4, (java.lang.Object) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r5)
            r4 = 0
            r6 = 384(0x180, float:5.38E-43)
            r1 = r0
            r5 = r8
            androidx.compose.foundation.text.AndroidCursorHandle_androidKt.m623CursorHandleULxng0E(r1, r3, r4, r5, r6)
        L_0x00c0:
            androidx.compose.runtime.ScopeUpdateScope r8 = r8.endRestartGroup()
            if (r8 != 0) goto L_0x00c7
            goto L_0x00d1
        L_0x00c7:
            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2
            r0.<init>(r7, r9)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r8.updateScope(r0)
        L_0x00d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt.TextFieldCursorHandle(androidx.compose.foundation.text.selection.TextFieldSelectionManager, androidx.compose.runtime.Composer, int):void");
    }
}
