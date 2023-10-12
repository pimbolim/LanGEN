package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.ImageKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextFieldColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.BV.LinearGradient.LinearGradientManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\u0012\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"TextField", "", "textFieldController", "Lcom/stripe/android/ui/core/elements/TextFieldController;", "modifier", "Landroidx/compose/ui/Modifier;", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "enabled", "", "TextField-6fMdlN4", "(Lcom/stripe/android/ui/core/elements/TextFieldController;Landroidx/compose/ui/Modifier;IZLandroidx/compose/runtime/Composer;II)V", "TrailingIcon", "trailingIcon", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "colors", "Landroidx/compose/material/TextFieldColors;", "loading", "(Lcom/stripe/android/ui/core/elements/TextFieldIcon;Landroidx/compose/material/TextFieldColors;ZLandroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
public final class TextFieldUIKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* renamed from: TextField-6fMdlN4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m4607TextField6fMdlN4(com.stripe.android.ui.core.elements.TextFieldController r61, androidx.compose.ui.Modifier r62, int r63, boolean r64, androidx.compose.runtime.Composer r65, int r66, int r67) {
        /*
            r1 = r61
            r5 = r66
            java.lang.String r0 = "textFieldController"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = -1673360818(0xffffffff9c428a4e, float:-6.436797E-22)
            r2 = r65
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r67 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r5 | 6
            goto L_0x0029
        L_0x0019:
            r2 = r5 & 14
            if (r2 != 0) goto L_0x0028
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            r2 = r2 | r5
            goto L_0x0029
        L_0x0028:
            r2 = r5
        L_0x0029:
            r3 = r67 & 2
            if (r3 == 0) goto L_0x0030
            r2 = r2 | 48
            goto L_0x0043
        L_0x0030:
            r4 = r5 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0043
            r4 = r62
            boolean r6 = r0.changed((java.lang.Object) r4)
            if (r6 == 0) goto L_0x003f
            r6 = 32
            goto L_0x0041
        L_0x003f:
            r6 = 16
        L_0x0041:
            r2 = r2 | r6
            goto L_0x0045
        L_0x0043:
            r4 = r62
        L_0x0045:
            r6 = r67 & 4
            if (r6 == 0) goto L_0x004e
            r2 = r2 | 384(0x180, float:5.38E-43)
            r15 = r63
            goto L_0x0060
        L_0x004e:
            r6 = r5 & 896(0x380, float:1.256E-42)
            r15 = r63
            if (r6 != 0) goto L_0x0060
            boolean r6 = r0.changed((int) r15)
            if (r6 == 0) goto L_0x005d
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005f
        L_0x005d:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005f:
            r2 = r2 | r6
        L_0x0060:
            r6 = r67 & 8
            if (r6 == 0) goto L_0x0069
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r13 = r64
            goto L_0x007b
        L_0x0069:
            r6 = r5 & 7168(0x1c00, float:1.0045E-41)
            r13 = r64
            if (r6 != 0) goto L_0x007b
            boolean r6 = r0.changed((boolean) r13)
            if (r6 == 0) goto L_0x0078
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r2 = r2 | r6
        L_0x007b:
            r6 = r2 & 5851(0x16db, float:8.199E-42)
            r6 = r6 ^ 1170(0x492, float:1.64E-42)
            if (r6 != 0) goto L_0x008e
            boolean r6 = r0.getSkipping()
            if (r6 != 0) goto L_0x0088
            goto L_0x008e
        L_0x0088:
            r0.skipToGroupEnd()
            r2 = r4
            goto L_0x030c
        L_0x008e:
            if (r3 == 0) goto L_0x0095
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0096
        L_0x0095:
            r3 = r4
        L_0x0096:
            java.lang.String r4 = r61.getDebugLabel()
            java.lang.String r6 = "SimpleTextFieldElement "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r4)
            java.lang.String r6 = "Construct"
            android.util.Log.d(r6, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalFocusManager()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r6 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r7 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r7)
            java.lang.Object r4 = r0.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.focus.FocusManager r4 = (androidx.compose.ui.focus.FocusManager) r4
            kotlinx.coroutines.flow.Flow r6 = r61.getFieldValue()
            r8 = 0
            r10 = 56
            r11 = 2
            java.lang.String r7 = ""
            r9 = r0
            androidx.compose.runtime.State r14 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.flow.Flow r6 = r61.getTrailingIcon()
            r7 = 0
            androidx.compose.runtime.State r54 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.flow.Flow r6 = r61.getVisibleError()
            r12 = 0
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r12)
            androidx.compose.runtime.State r55 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.flow.Flow r6 = r61.getLoading()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r12)
            androidx.compose.runtime.State r11 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.flow.Flow r6 = r61.getContentDescription()
            r16 = 2
            java.lang.String r7 = ""
            r56 = r11
            r11 = r16
            androidx.compose.runtime.State r11 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r7, r8, r9, r10, r11)
            java.lang.Object[] r6 = new java.lang.Object[r12]
            r7 = 0
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$hasFocus$2 r9 = com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$hasFocus$2.INSTANCE
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r16 = 3080(0xc08, float:4.316E-42)
            r17 = 6
            r10 = r0
            r57 = r11
            r11 = r16
            r12 = r17
            java.lang.Object r6 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r6, r7, (java.lang.String) r8, r9, (androidx.compose.runtime.Composer) r10, (int) r11, (int) r12)
            r7 = r6
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            androidx.compose.material.TextFieldDefaults r6 = androidx.compose.material.TextFieldDefaults.INSTANCE
            boolean r8 = m4611TextField_6fMdlN4$lambda2(r55)
            r9 = 8
            if (r8 == 0) goto L_0x0138
            r8 = -1673359997(0xffffffff9c428d83, float:-6.4372115E-22)
            r0.startReplaceableGroup(r8)
            com.stripe.android.ui.core.PaymentsTheme r8 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r8 = r8.getColors(r0, r9)
            androidx.compose.material.Colors r8 = r8.getMaterial()
            long r10 = r8.m908getError0d7_KjU()
            r0.endReplaceableGroup()
            goto L_0x014b
        L_0x0138:
            r8 = -1673359932(0xffffffff9c428dc4, float:-6.4372443E-22)
            r0.startReplaceableGroup(r8)
            com.stripe.android.ui.core.PaymentsTheme r8 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r8 = r8.getColors(r0, r9)
            long r10 = r8.m4505getOnComponent0d7_KjU()
            r0.endReplaceableGroup()
        L_0x014b:
            r58 = r10
            com.stripe.android.ui.core.PaymentsTheme r8 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r8 = r8.getColors(r0, r9)
            long r39 = r8.m4506getPlaceholderText0d7_KjU()
            com.stripe.android.ui.core.PaymentsTheme r8 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r8 = r8.getColors(r0, r9)
            long r37 = r8.m4506getPlaceholderText0d7_KjU()
            com.stripe.android.ui.core.PaymentsTheme r8 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r8 = r8.getColors(r0, r9)
            long r45 = r8.m4506getPlaceholderText0d7_KjU()
            com.stripe.android.ui.core.PaymentsTheme r8 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r8 = r8.getColors(r0, r9)
            long r11 = r8.m4504getComponent0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r8.m1631getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r21 = r8.m1631getTransparent0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r19 = r8.m1631getTransparent0d7_KjU()
            com.stripe.android.ui.core.PaymentsTheme r8 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r8 = r8.getColors(r0, r9)
            long r8 = r8.m4503getColorTextCursor0d7_KjU()
            r10 = r14
            r13 = r8
            r8 = 0
            r62 = r10
            r9 = r8
            r23 = 0
            r15 = r23
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r41 = 0
            r43 = 0
            r47 = 0
            r50 = 14352384(0xdb0000, float:2.0111974E-38)
            r51 = 0
            r52 = 64
            r53 = 1474322(0x167f12, float:2.065965E-39)
            r60 = r7
            r7 = r58
            r49 = r0
            androidx.compose.material.TextFieldColors r15 = r6.m1166textFieldColorsdx8h9Zs(r7, r9, r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r50, r51, r52, r53)
            kotlinx.coroutines.flow.Flow r6 = r61.getFieldState()
            com.stripe.android.ui.core.elements.TextFieldStateConstants$Error$Blank r7 = com.stripe.android.ui.core.elements.TextFieldStateConstants.Error.Blank.INSTANCE
            r8 = 0
            r10 = 56
            r11 = 2
            r9 = r0
            androidx.compose.runtime.State r13 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.flow.Flow r6 = r61.getLabel()
            r7 = 0
            androidx.compose.runtime.State r14 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r6, r7, r8, r9, r10, r11)
            r12 = 0
            java.lang.Object[] r6 = new java.lang.Object[r12]
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$processedIsFull$2 r9 = com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$processedIsFull$2.INSTANCE
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r11 = 3080(0xc08, float:4.316E-42)
            r16 = 6
            r10 = r0
            r5 = 0
            r12 = r16
            java.lang.Object r6 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r6, r7, (java.lang.String) r8, r9, (androidx.compose.runtime.Composer) r10, (int) r11, (int) r12)
            androidx.compose.runtime.MutableState r6 = (androidx.compose.runtime.MutableState) r6
            com.stripe.android.ui.core.elements.TextFieldState r7 = m4616TextField_6fMdlN4$lambda7(r13)
            com.stripe.android.ui.core.elements.TextFieldStateConstants$Valid$Full r8 = com.stripe.android.ui.core.elements.TextFieldStateConstants.Valid.Full.INSTANCE
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            r13 = 1
            if (r7 == 0) goto L_0x020c
            boolean r7 = m4618TextField_6fMdlN4$lambda9(r6)
            if (r7 != 0) goto L_0x020a
            androidx.compose.ui.focus.FocusDirection$Companion r7 = androidx.compose.ui.focus.FocusDirection.Companion
            int r7 = r7.m1304getNextdhqQ8s()
            r4.m1309moveFocus3ESFkO8(r7)
        L_0x020a:
            r12 = 1
            goto L_0x020d
        L_0x020c:
            r12 = 0
        L_0x020d:
            m4610TextField_6fMdlN4$lambda10(r6, r12)
            java.lang.String r6 = m4608TextField_6fMdlN4$lambda0(r62)
            boolean r16 = m4611TextField_6fMdlN4$lambda2(r55)
            r7 = 0
            r12 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r3, r7, r13, r12)
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$1 r8 = new com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$1
            r9 = r62
            r8.<init>(r4, r9)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.input.key.KeyInputModifierKt.onPreviewKeyEvent(r7, r8)
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$2 r8 = new com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$2
            r9 = r60
            r8.<init>(r1, r9)
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.focus.FocusChangedModifierKt.onFocusChanged(r7, r8)
            r8 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            r8 = r57
            boolean r9 = r0.changed((java.lang.Object) r8)
            java.lang.Object r10 = r0.rememberedValue()
            if (r9 != 0) goto L_0x0257
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r10 != r9) goto L_0x0262
        L_0x0257:
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$3$1 r9 = new com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$3$1
            r9.<init>(r8)
            r10 = r9
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r0.updateRememberedValue(r10)
        L_0x0262:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r7, r5, r10, r13, r12)
            androidx.compose.foundation.text.KeyboardActions r29 = new androidx.compose.foundation.text.KeyboardActions
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$4 r7 = new com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$4
            r7.<init>(r4)
            r18 = r7
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            r19 = 0
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$5 r7 = new com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$5
            r7.<init>(r4)
            r20 = r7
            kotlin.jvm.functions.Function1 r20 = (kotlin.jvm.functions.Function1) r20
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 58
            r25 = 0
            r17 = r29
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25)
            androidx.compose.ui.text.input.VisualTransformation r17 = r61.getVisualTransformation()
            int r10 = r61.m4606getKeyboardTypePjHm6EE()
            int r8 = r61.m4605getCapitalizationIUNYP9k()
            androidx.compose.foundation.text.KeyboardOptions r18 = new androidx.compose.foundation.text.KeyboardOptions
            r9 = 0
            r4 = 2
            r7 = r18
            r11 = r63
            r20 = r12
            r12 = r4
            r4 = 1
            r13 = r19
            r7.<init>(r8, r9, r10, r11, r12, r13)
            com.stripe.android.ui.core.elements.TextFieldIcon r7 = m4609TextField_6fMdlN4$lambda1(r54)
            if (r7 != 0) goto L_0x02b6
            r19 = r20
            goto L_0x02c8
        L_0x02b6:
            r8 = -985536794(0xffffffffc541e6e6, float:-3102.4312)
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$6$1 r9 = new com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$6$1
            r10 = r56
            r9.<init>(r7, r15, r10)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r8, r4, r9)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r19 = r7
        L_0x02c8:
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$7 r7 = new com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$7
            r7.<init>(r1)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r10 = 0
            r11 = 0
            r8 = -819890523(0xffffffffcf2176a5, float:-2.70890726E9)
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$8 r9 = new com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$8
            r9.<init>(r1, r14)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r8, r4, r9)
            r12 = r4
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13 = 0
            r14 = 0
            r20 = 1
            r21 = 1
            r22 = 0
            r23 = 0
            r4 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r26 = r2 | r4
            r2 = 221184(0x36000, float:3.09945E-40)
            int r4 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r4 = r4 << 9
            r27 = r4 | r2
            r28 = 197040(0x301b0, float:2.76112E-40)
            r8 = r5
            r9 = r64
            r2 = r15
            r15 = r19
            r19 = r29
            r24 = r2
            r25 = r0
            androidx.compose.material.TextFieldKt.TextField((java.lang.String) r6, (kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>) r7, (androidx.compose.ui.Modifier) r8, (boolean) r9, (boolean) r10, (androidx.compose.ui.text.TextStyle) r11, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r12, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r13, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r14, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r15, (boolean) r16, (androidx.compose.ui.text.input.VisualTransformation) r17, (androidx.compose.foundation.text.KeyboardOptions) r18, (androidx.compose.foundation.text.KeyboardActions) r19, (boolean) r20, (int) r21, (androidx.compose.foundation.interaction.MutableInteractionSource) r22, (androidx.compose.ui.graphics.Shape) r23, (androidx.compose.material.TextFieldColors) r24, (androidx.compose.runtime.Composer) r25, (int) r26, (int) r27, (int) r28)
            r2 = r3
        L_0x030c:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x0313
            goto L_0x0328
        L_0x0313:
            com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$9 r8 = new com.stripe.android.ui.core.elements.TextFieldUIKt$TextField$9
            r0 = r8
            r1 = r61
            r3 = r63
            r4 = r64
            r5 = r66
            r6 = r67
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x0328:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.TextFieldUIKt.m4607TextField6fMdlN4(com.stripe.android.ui.core.elements.TextFieldController, androidx.compose.ui.Modifier, int, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: TextField_6fMdlN4$lambda-5  reason: not valid java name */
    public static final boolean m4614TextField_6fMdlN4$lambda5(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: TextField_6fMdlN4$lambda-6  reason: not valid java name */
    public static final void m4615TextField_6fMdlN4$lambda6(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* renamed from: TextField_6fMdlN4$lambda-10  reason: not valid java name */
    private static final void m4610TextField_6fMdlN4$lambda10(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* renamed from: TextField_6fMdlN4$lambda-9  reason: not valid java name */
    private static final boolean m4618TextField_6fMdlN4$lambda9(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    public static final void TrailingIcon(TextFieldIcon textFieldIcon, TextFieldColors textFieldColors, boolean z, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(textFieldIcon, "trailingIcon");
        Intrinsics.checkNotNullParameter(textFieldColors, LinearGradientManager.PROP_COLORS);
        Composer startRestartGroup = composer.startRestartGroup(2026348623);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) textFieldIcon) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if (((i2 & 651) ^ 130) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (z) {
            startRestartGroup.startReplaceableGroup(2026348771);
            ProgressIndicatorKt.m1067CircularProgressIndicatoraMcp0Q((Modifier) null, 0, 0.0f, startRestartGroup, 0, 7);
            startRestartGroup.endReplaceableGroup();
        } else {
            String str = null;
            if (textFieldIcon.isIcon()) {
                startRestartGroup.startReplaceableGroup(2026348845);
                Painter painterResource = PainterResources_androidKt.painterResource(textFieldIcon.getIdRes(), startRestartGroup, 0);
                Integer contentDescription = textFieldIcon.getContentDescription();
                if (contentDescription != null) {
                    contentDescription.intValue();
                    str = StringResources_androidKt.stringResource(textFieldIcon.getContentDescription().intValue(), startRestartGroup, 0);
                }
                IconKt.m1013Iconww6aTOc(painterResource, str, (Modifier) null, 0, startRestartGroup, 8, 12);
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(2026349096);
                Painter painterResource2 = PainterResources_androidKt.painterResource(textFieldIcon.getIdRes(), startRestartGroup, 0);
                Integer contentDescription2 = textFieldIcon.getContentDescription();
                if (contentDescription2 != null) {
                    contentDescription2.intValue();
                    str = StringResources_androidKt.stringResource(textFieldIcon.getContentDescription().intValue(), startRestartGroup, 0);
                }
                ImageKt.Image(painterResource2, str, (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, startRestartGroup, 8, 124);
                startRestartGroup.endReplaceableGroup();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldUIKt$TrailingIcon$3(textFieldIcon, textFieldColors, z, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: TextField_6fMdlN4$lambda-0  reason: not valid java name */
    public static final String m4608TextField_6fMdlN4$lambda0(State<String> state) {
        return state.getValue();
    }

    /* renamed from: TextField_6fMdlN4$lambda-1  reason: not valid java name */
    private static final TextFieldIcon m4609TextField_6fMdlN4$lambda1(State<TextFieldIcon> state) {
        return state.getValue();
    }

    /* renamed from: TextField_6fMdlN4$lambda-2  reason: not valid java name */
    private static final boolean m4611TextField_6fMdlN4$lambda2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: TextField_6fMdlN4$lambda-3  reason: not valid java name */
    public static final boolean m4612TextField_6fMdlN4$lambda3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: TextField_6fMdlN4$lambda-4  reason: not valid java name */
    public static final String m4613TextField_6fMdlN4$lambda4(State<String> state) {
        return state.getValue();
    }

    /* renamed from: TextField_6fMdlN4$lambda-7  reason: not valid java name */
    private static final TextFieldState m4616TextField_6fMdlN4$lambda7(State<? extends TextFieldState> state) {
        return (TextFieldState) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: TextField_6fMdlN4$lambda-8  reason: not valid java name */
    public static final Integer m4617TextField_6fMdlN4$lambda8(State<Integer> state) {
        return state.getValue();
    }
}
