package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a=\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"DropDown", "", "controller", "Lcom/stripe/android/ui/core/elements/DropdownFieldController;", "enabled", "", "(Lcom/stripe/android/ui/core/elements/DropdownFieldController;ZLandroidx/compose/runtime/Composer;I)V", "DropdownMenuItem", "displayValue", "", "isSelected", "currentTextColor", "Landroidx/compose/ui/graphics/Color;", "onClick", "Lkotlin/Function0;", "DropdownMenuItem-cf5BqRc", "(Ljava/lang/String;ZJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DropdownFieldUI.kt */
public final class DropdownFieldUIKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropDown(com.stripe.android.ui.core.elements.DropdownFieldController r61, boolean r62, androidx.compose.runtime.Composer r63, int r64) {
        /*
            r7 = r61
            r8 = r62
            r9 = r64
            java.lang.String r0 = "controller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -85734243(0xfffffffffae3cc9d, float:-5.914007E35)
            r1 = r63
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            kotlinx.coroutines.flow.Flow r1 = r61.getLabel()
            r2 = 0
            r3 = 0
            r5 = 56
            r6 = 2
            r4 = r0
            androidx.compose.runtime.State r58 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r1, r2, r3, r4, r5, r6)
            kotlinx.coroutines.flow.Flow r1 = r61.getSelectedIndex()
            r15 = 0
            java.lang.Integer r13 = java.lang.Integer.valueOf(r15)
            r2 = r13
            androidx.compose.runtime.State r59 = androidx.compose.runtime.SnapshotStateKt.collectAsState(r1, r2, r3, r4, r5, r6)
            java.util.List r6 = r61.getDisplayItems()
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r1)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            java.lang.Object r3 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            r5 = 2
            r14 = 0
            if (r3 != r4) goto L_0x0058
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r14, r5, r14)
            r0.updateRememberedValue(r3)
        L_0x0058:
            r0.endReplaceableGroup()
            r4 = r3
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            r0.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            java.lang.Object r1 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0077
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r1)
        L_0x0077:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r3 = 8
            if (r8 == 0) goto L_0x00a0
            r1 = -85733822(0xfffffffffae3ce42, float:-5.914174E35)
            r0.startReplaceableGroup(r1)
            com.stripe.android.ui.core.PaymentsTheme r1 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r1 = r1.getColors(r0, r3)
            long r1 = r1.m4505getOnComponent0d7_KjU()
            r0.endReplaceableGroup()
            r34 = r1
            r12 = r4
            r63 = r6
            r6 = r13
            r10 = r14
            r11 = 2
            r15 = 8
            r14 = r0
            goto L_0x0111
        L_0x00a0:
            r2 = -85733768(0xfffffffffae3ce78, float:-5.9141954E35)
            r0.startReplaceableGroup(r2)
            androidx.compose.material.TextFieldDefaults r10 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r11 = 0
            r16 = 0
            r63 = r6
            r6 = r13
            r2 = r14
            r13 = r16
            r15 = r16
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r54 = 0
            r55 = 0
            r56 = 64
            r57 = 2097151(0x1fffff, float:2.938734E-39)
            r53 = r0
            androidx.compose.material.TextFieldColors r10 = r10.m1166textFieldColorsdx8h9Zs(r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r54, r55, r56, r57)
            r11 = 0
            r12 = r1
            androidx.compose.foundation.interaction.InteractionSource r12 = (androidx.compose.foundation.interaction.InteractionSource) r12
            int r1 = r9 >> 3
            r1 = r1 & 14
            r13 = r1 | 432(0x1b0, float:6.05E-43)
            r14 = r0
            r0 = r10
            r1 = r62
            r10 = r2
            r2 = r11
            r15 = 8
            r3 = r12
            r12 = r4
            r4 = r14
            r11 = 2
            r5 = r13
            androidx.compose.runtime.State r0 = r0.indicatorColor(r1, r2, r3, r4, r5)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r0 = r0.m1606unboximpl()
            r14.endReplaceableGroup()
            r34 = r0
        L_0x0111:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalInputModeManager()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r13 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r13, r5)
            java.lang.Object r0 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.input.InputModeManager r0 = (androidx.compose.ui.input.InputModeManager) r0
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            r4 = 0
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r1, r2, r4, r11, r10)
            com.stripe.android.ui.core.PaymentsTheme r1 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r1 = r1.getColors(r14, r15)
            long r17 = r1.m4504getComponent0d7_KjU()
            r19 = 0
            r20 = 2
            r21 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BackgroundKt.m162backgroundbw27NRU$default(r16, r17, r19, r20, r21)
            r3 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r14.startReplaceableGroup(r3)
            java.lang.String r2 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            androidx.compose.ui.Alignment$Companion r16 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r16.getTopStart()
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r4, r14, r4)
            r11 = 1376089394(0x52057532, float:1.43299215E11)
            r14.startReplaceableGroup(r11)
            java.lang.String r10 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r15 = r19
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r13, r5)
            java.lang.Object r15 = r14.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r11 = r19
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r13, r5)
            java.lang.Object r11 = r14.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r19 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r4 = r19
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r13, r5)
            java.lang.Object r4 = r14.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r19.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            r19 = r2
            androidx.compose.runtime.Applier r2 = r14.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x01be
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01be:
            r14.startReusableNode()
            boolean r2 = r14.getInserting()
            if (r2 == 0) goto L_0x01cb
            r14.createNode(r13)
            goto L_0x01ce
        L_0x01cb:
            r14.useNode()
        L_0x01ce:
            r14.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m1234constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r2, r3, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r2, r15, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r2, r11, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r2, r4, r3)
            r14.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r2)
            r1.invoke(r2, r14, r6)
            r11 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r11)
            r13 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r14.startReplaceableGroup(r13)
            java.lang.String r15 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropDown$1$1 r2 = new com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropDown$1$1
            r2.<init>(r0)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.focus.FocusPropertiesKt.focusProperties(r1, r2)
            int r1 = com.stripe.android.ui.core.R.string.change
            r4 = 0
            java.lang.String r2 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r1, r14, r4)
            r3 = 0
            r1 = -3686930(0xffffffffffc7bdee, float:NaN)
            r14.startReplaceableGroup(r1)
            java.lang.String r13 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r13)
            boolean r24 = r14.changed((java.lang.Object) r12)
            java.lang.Object r1 = r14.rememberedValue()
            if (r24 != 0) goto L_0x0250
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r24.getEmpty()
            if (r1 != r4) goto L_0x025a
        L_0x0250:
            com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropDown$1$2$1 r1 = new com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropDown$1$2$1
            r1.<init>(r12)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r14.updateRememberedValue(r1)
        L_0x025a:
            r14.endReplaceableGroup()
            r4 = r1
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r24 = 4
            r26 = 0
            r1 = r62
            r11 = r19
            r60 = r5
            r5 = r24
            r7 = r63
            r30 = r12
            r12 = r6
            r6 = r26
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClickableKt.m180clickableXHw0xAI$default(r0, r1, r2, r3, r4, r5, r6)
            r1 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r14.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r11)
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getTopStart()
            r2 = 0
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r2, r14, r2)
            r3 = 1376089394(0x52057532, float:1.43299215E11)
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = r60
            r5 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r4)
            java.lang.Object r3 = r14.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r4)
            java.lang.Object r6 = r14.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r4)
            java.lang.Object r5 = r14.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r0 = androidx.compose.ui.layout.LayoutKt.materializerOf(r0)
            androidx.compose.runtime.Applier r2 = r14.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x02e4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x02e4:
            r14.startReusableNode()
            boolean r2 = r14.getInserting()
            if (r2 == 0) goto L_0x02f1
            r14.createNode(r11)
            goto L_0x02f4
        L_0x02f1:
            r14.useNode()
        L_0x02f4:
            r14.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m1234constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r2, r1, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r2, r3, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r2, r6, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r2, r5, r1)
            r14.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r1)
            r0.invoke(r1, r14, r12)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r0)
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r14.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r15)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r36 = r0
            androidx.compose.ui.Modifier r36 = (androidx.compose.ui.Modifier) r36
            r0 = 16
            float r0 = (float) r0
            float r37 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r0)
            r0 = 4
            float r0 = (float) r0
            float r38 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r0)
            r39 = 0
            r0 = 8
            float r1 = (float) r0
            float r40 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r1)
            r41 = 4
            r42 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m435paddingqDBjuR0$default(r36, r37, r38, r39, r40, r41, r42)
            r2 = -1113030915(0xffffffffbda87efd, float:-0.08227346)
            r14.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r2 = r2.getTop()
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r3 = r3.getStart()
            r5 = 0
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r2, r3, r14, r5)
            r3 = 1376089394(0x52057532, float:1.43299215E11)
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r4)
            java.lang.Object r3 = r14.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r4)
            java.lang.Object r6 = r14.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r4)
            java.lang.Object r5 = r14.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r15 = r14.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x03d7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03d7:
            r14.startReusableNode()
            boolean r15 = r14.getInserting()
            if (r15 == 0) goto L_0x03e4
            r14.createNode(r11)
            goto L_0x03e7
        L_0x03e4:
            r14.useNode()
        L_0x03e7:
            r14.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m1234constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r11, r2, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r11, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r11, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r11, r5, r2)
            r14.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r2)
            r1.invoke(r2, r14, r12)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r1)
            r1 = 276693625(0x107e0279, float:5.0094572E-29)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "C78@3948L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            java.lang.Integer r1 = m4572DropDown$lambda0(r58)
            r2 = -777147266(0xffffffffd1adac7e, float:-9.324041E10)
            r14.startReplaceableGroup(r2)
            if (r1 != 0) goto L_0x0442
            goto L_0x0456
        L_0x0442:
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r2 = 0
            java.lang.String r1 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r1, r14, r2)
            r3 = r9 & 112(0x70, float:1.57E-43)
            com.stripe.android.ui.core.elements.FormLabelKt.FormLabel(r1, r8, r14, r3, r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0456:
            r14.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 0
            r3 = 1
            r5 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r2, r3, r5)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r2 = r2.getBottom()
            r5 = -1989997165(0xffffffff89630d93, float:-2.7330514E-33)
            r14.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r5)
            androidx.compose.foundation.layout.Arrangement r5 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r5 = r5.getStart()
            r6 = 48
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r5, r2, r14, r6)
            r5 = 1376089394(0x52057532, float:1.43299215E11)
            r14.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r10)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r6 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r6, r4)
            java.lang.Object r5 = r14.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r6, r4)
            java.lang.Object r10 = r14.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r6, r4)
            java.lang.Object r4 = r14.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r11 = r14.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x04d8
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x04d8:
            r14.startReusableNode()
            boolean r11 = r14.getInserting()
            if (r11 == 0) goto L_0x04e5
            r14.createNode(r6)
            goto L_0x04e8
        L_0x04e5:
            r14.useNode()
        L_0x04e8:
            r14.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1234constructorimpl(r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r2, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r5, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r10, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r4, r2)
            r14.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r14)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r2)
            r1.invoke(r2, r14, r12)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r14.startReplaceableGroup(r1)
            r1 = -326682362(0xffffffffec873906, float:-1.3077942E27)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "C79@3942L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            int r1 = m4573DropDown$lambda1(r59)
            java.lang.Object r1 = r7.get(r1)
            r10 = r1
            java.lang.String r10 = (java.lang.String) r10
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 1063675494(0x3f666666, float:0.9)
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth(r1, r2)
            r1 = 2
            r4 = 0
            r6 = r14
            r14 = r4
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 48
            r32 = 0
            r33 = 65528(0xfff8, float:9.1824E-41)
            r2 = r13
            r5 = r30
            r12 = r34
            r30 = r6
            androidx.compose.material.TextKt.m1189TextfLXpl1I(r10, r11, r12, r14, r16, r17, r18, r19, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            androidx.compose.material.icons.Icons$Filled r4 = androidx.compose.material.icons.Icons.Filled.INSTANCE
            androidx.compose.ui.graphics.vector.ImageVector r10 = androidx.compose.material.icons.filled.ArrowDropDownKt.getArrowDropDown(r4)
            r11 = 0
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            r12 = 24
            float r12 = (float) r12
            float r12 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r12)
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.SizeKt.m478height3ABfNKs(r4, r12)
            r16 = 432(0x1b0, float:6.05E-43)
            r17 = 0
            r13 = r34
            r15 = r6
            androidx.compose.material.IconKt.m1014Iconww6aTOc((androidx.compose.ui.graphics.vector.ImageVector) r10, (java.lang.String) r11, (androidx.compose.ui.Modifier) r12, (long) r13, (androidx.compose.runtime.Composer) r15, (int) r16, (int) r17)
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            r6.endNode()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            r6.endNode()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            r6.endNode()
            r6.endReplaceableGroup()
            r6.endReplaceableGroup()
            boolean r10 = m4574DropDown$lambda3(r5)
            int r4 = m4573DropDown$lambda1(r59)
            if (r4 < r3) goto L_0x05e9
            int r4 = m4573DropDown$lambda1(r59)
            int r4 = r4 - r1
            r1 = 0
            int r4 = java.lang.Math.max(r4, r1)
            int r11 = m4573DropDown$lambda1(r59)
            int r11 = r11 - r3
            int r1 = java.lang.Math.max(r11, r1)
            int r1 = java.lang.Math.min(r4, r1)
            goto L_0x05ed
        L_0x05e9:
            int r1 = m4573DropDown$lambda1(r59)
        L_0x05ed:
            r11 = r1
            r1 = -3686930(0xffffffffffc7bdee, float:NaN)
            r6.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r2)
            boolean r1 = r6.changed((java.lang.Object) r5)
            java.lang.Object r2 = r6.rememberedValue()
            if (r1 != 0) goto L_0x0609
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0614
        L_0x0609:
            com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropDown$1$4$1 r1 = new com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropDown$1$4$1
            r1.<init>(r5)
            r2 = r1
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r6.updateRememberedValue(r2)
        L_0x0614:
            r6.endReplaceableGroup()
            r12 = r2
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r13 = r1
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            com.stripe.android.ui.core.PaymentsTheme r1 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r0 = r1.getColors(r6, r0)
            long r14 = r0.m4504getComponent0d7_KjU()
            r16 = 0
            r17 = 2
            r18 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.BackgroundKt.m162backgroundbw27NRU$default(r13, r14, r16, r17, r18)
            float r1 = com.stripe.android.ui.core.elements.menu.MenuKt.getDropdownMenuItemDefaultMaxWidth()
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.SizeKt.m497width3ABfNKs(r0, r1)
            r14 = 0
            r15 = 0
            r16 = 0
            float r0 = com.stripe.android.ui.core.elements.menu.MenuKt.getDropdownMenuItemDefaultMinHeight()
            r1 = 1091462758(0x410e6666, float:8.9)
            float r0 = r0 * r1
            float r17 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r0)
            r18 = 7
            r19 = 0
            androidx.compose.ui.Modifier r13 = androidx.compose.foundation.layout.SizeKt.m488requiredSizeInqDBjuR0$default(r13, r14, r15, r16, r17, r18, r19)
            r14 = 0
            r16 = 0
            com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropDown$1$5 r17 = new com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropDown$1$5
            r0 = r17
            r1 = r7
            r2 = r34
            r4 = r59
            r7 = r5
            r5 = r61
            r21 = r6
            r6 = r7
            r0.<init>(r1, r2, r4, r5, r6)
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r19 = 0
            r20 = 48
            r18 = r21
            defpackage.AndroidMenuKt.m0DropdownMenux0xb5LI(r10, r11, r12, r13, r14, r16, r17, r18, r19, r20)
            r21.endReplaceableGroup()
            r21.endReplaceableGroup()
            r21.endNode()
            r21.endReplaceableGroup()
            r21.endReplaceableGroup()
            androidx.compose.runtime.ScopeUpdateScope r0 = r21.endRestartGroup()
            if (r0 != 0) goto L_0x068b
            goto L_0x0697
        L_0x068b:
            com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropDown$2 r1 = new com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropDown$2
            r2 = r61
            r1.<init>(r2, r8, r9)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x0697:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.DropdownFieldUIKt.DropDown(com.stripe.android.ui.core.elements.DropdownFieldController, boolean, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: DropDown$lambda-3  reason: not valid java name */
    private static final boolean m4574DropDown$lambda3(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DropDown$lambda-4  reason: not valid java name */
    public static final void m4575DropDown$lambda4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* renamed from: DropdownMenuItem-cf5BqRc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m4576DropdownMenuItemcf5BqRc(java.lang.String r31, boolean r32, long r33, kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r7 = r31
            r6 = r32
            r4 = r37
            java.lang.String r0 = "displayValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -343978186(0xffffffffeb7f4f36, float:-3.0865015E26)
            r1 = r36
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            r0 = r38 & 1
            if (r0 == 0) goto L_0x001b
            r0 = r4 | 6
            goto L_0x002b
        L_0x001b:
            r0 = r4 & 14
            if (r0 != 0) goto L_0x002a
            boolean r0 = r5.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x0027
            r0 = 4
            goto L_0x0028
        L_0x0027:
            r0 = 2
        L_0x0028:
            r0 = r0 | r4
            goto L_0x002b
        L_0x002a:
            r0 = r4
        L_0x002b:
            r2 = r38 & 2
            if (r2 == 0) goto L_0x0032
            r0 = r0 | 48
            goto L_0x0042
        L_0x0032:
            r2 = r4 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0042
            boolean r2 = r5.changed((boolean) r6)
            if (r2 == 0) goto L_0x003f
            r2 = 32
            goto L_0x0041
        L_0x003f:
            r2 = 16
        L_0x0041:
            r0 = r0 | r2
        L_0x0042:
            r2 = r38 & 4
            if (r2 == 0) goto L_0x0049
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005c
        L_0x0049:
            r2 = r4 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x005c
            r2 = r33
            boolean r8 = r5.changed((long) r2)
            if (r8 == 0) goto L_0x0058
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r0 = r0 | r8
            goto L_0x005e
        L_0x005c:
            r2 = r33
        L_0x005e:
            r8 = r38 & 8
            if (r8 == 0) goto L_0x0065
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0078
        L_0x0065:
            r9 = r4 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0078
            r9 = r35
            boolean r10 = r5.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0074
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0076
        L_0x0074:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0076:
            r0 = r0 | r10
            goto L_0x007a
        L_0x0078:
            r9 = r35
        L_0x007a:
            r10 = r0 & 5851(0x16db, float:8.199E-42)
            r10 = r10 ^ 1170(0x492, float:1.64E-42)
            if (r10 != 0) goto L_0x0091
            boolean r10 = r5.getSkipping()
            if (r10 != 0) goto L_0x0087
            goto L_0x0091
        L_0x0087:
            r5.skipToGroupEnd()
            r30 = r9
            r9 = r5
            r5 = r30
            goto L_0x029c
        L_0x0091:
            if (r8 == 0) goto L_0x0099
            com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropdownMenuItem$1 r8 = com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropdownMenuItem$1.INSTANCE
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r15 = r8
            goto L_0x009a
        L_0x0099:
            r15 = r9
        L_0x009a:
            androidx.compose.ui.Alignment$Companion r8 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r8 = r8.getCenterVertically()
            androidx.compose.foundation.layout.Arrangement r9 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r9 = r9.getStart()
            androidx.compose.ui.Modifier$Companion r10 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r10 = (androidx.compose.ui.Modifier) r10
            r11 = 0
            r12 = 1
            r13 = 0
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r10, r11, r12, r13)
            float r17 = com.stripe.android.ui.core.elements.menu.MenuKt.getDropdownMenuItemDefaultMinWidth()
            float r18 = com.stripe.android.ui.core.elements.menu.MenuKt.getDropdownMenuItemDefaultMinHeight()
            r19 = 0
            r20 = 0
            r21 = 12
            r22 = 0
            androidx.compose.ui.Modifier r23 = androidx.compose.foundation.layout.SizeKt.m488requiredSizeInqDBjuR0$default(r16, r17, r18, r19, r20, r21, r22)
            r24 = 0
            r25 = 0
            r26 = 0
            r10 = -3686930(0xffffffffffc7bdee, float:NaN)
            r5.startReplaceableGroup(r10)
            java.lang.String r10 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r10)
            boolean r10 = r5.changed((java.lang.Object) r15)
            java.lang.Object r12 = r5.rememberedValue()
            if (r10 != 0) goto L_0x00e8
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r12 != r10) goto L_0x00f3
        L_0x00e8:
            com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropdownMenuItem$2$1 r10 = new com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropdownMenuItem$2$1
            r10.<init>(r15)
            r12 = r10
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            r5.updateRememberedValue(r12)
        L_0x00f3:
            r5.endReplaceableGroup()
            r27 = r12
            kotlin.jvm.functions.Function0 r27 = (kotlin.jvm.functions.Function0) r27
            r28 = 7
            r29 = 0
            androidx.compose.ui.Modifier r10 = androidx.compose.foundation.ClickableKt.m180clickableXHw0xAI$default(r23, r24, r25, r26, r27, r28, r29)
            r12 = -1989997165(0xffffffff89630d93, float:-2.7330514E-33)
            r5.startReplaceableGroup(r12)
            java.lang.String r12 = "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r12)
            r12 = 54
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r9, r8, r5, r12)
            r9 = 1376089394(0x52057532, float:1.43299215E11)
            r5.startReplaceableGroup(r9)
            java.lang.String r9 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r12 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r14 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r12, r14)
            java.lang.Object r9 = r5.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r1 = r16
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r12, r14)
            java.lang.Object r1 = r5.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r11 = r16
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r12, r14)
            java.lang.Object r11 = r5.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.ViewConfiguration r11 = (androidx.compose.ui.platform.ViewConfiguration) r11
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r10 = androidx.compose.ui.layout.LayoutKt.materializerOf(r10)
            androidx.compose.runtime.Applier r14 = r5.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0172
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0172:
            r5.startReusableNode()
            boolean r14 = r5.getInserting()
            if (r14 == 0) goto L_0x017f
            r5.createNode(r12)
            goto L_0x0182
        L_0x017f:
            r5.useNode()
        L_0x0182:
            r5.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m1234constructorimpl(r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r12, r8, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r12, r9, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r12, r1, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r12, r11, r1)
            r5.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r1)
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r10.invoke(r1, r5, r9)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r1)
            r1 = -326682362(0xffffffffec873906, float:-1.3077942E27)
            r5.startReplaceableGroup(r1)
            java.lang.String r1 = "C79@3942L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r1 = (androidx.compose.foundation.layout.RowScope) r1
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            if (r6 == 0) goto L_0x01e3
            r8 = 13
            float r8 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r8)
            goto L_0x01e8
        L_0x01e3:
            float r8 = (float) r8
            float r8 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r8)
        L_0x01e8:
            r9 = 0
            r10 = 2
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m433paddingVpY3zN4$default(r1, r8, r9, r10, r13)
            r8 = 1061997773(0x3f4ccccd, float:0.8)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth(r1, r8)
            r8 = 311210002(0x128cb012, float:8.878647E-28)
            r5.startReplaceableGroup(r8)
            r13 = 8
            if (r6 == 0) goto L_0x0210
            com.stripe.android.ui.core.PaymentsTheme r8 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r8 = r8.getColors(r5, r13)
            androidx.compose.material.Colors r8 = r8.getMaterial()
            long r8 = r8.m914getPrimary0d7_KjU()
            r24 = r8
            goto L_0x0212
        L_0x0210:
            r24 = r2
        L_0x0212:
            r5.endReplaceableGroup()
            r26 = 0
            r20 = 0
            if (r6 == 0) goto L_0x0222
            androidx.compose.ui.text.font.FontWeight$Companion r8 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r8 = r8.getBold()
            goto L_0x0228
        L_0x0222:
            androidx.compose.ui.text.font.FontWeight$Companion r8 = androidx.compose.ui.text.font.FontWeight.Companion
            androidx.compose.ui.text.font.FontWeight r8 = r8.getNormal()
        L_0x0228:
            r28 = r8
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r13 = r16
            r16 = 0
            r29 = r15
            r15 = r16
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = r0 & 14
            r22 = 0
            r23 = 65496(0xffd8, float:9.178E-41)
            r0 = r31
            r2 = r24
            r35 = r5
            r4 = r26
            r6 = r20
            r7 = r28
            r20 = r35
            androidx.compose.material.TextKt.m1189TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            if (r32 == 0) goto L_0x0289
            androidx.compose.material.icons.Icons$Filled r0 = androidx.compose.material.icons.Icons.Filled.INSTANCE
            androidx.compose.ui.graphics.vector.ImageVector r1 = androidx.compose.material.icons.filled.CheckKt.getCheck(r0)
            r2 = 0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r3 = 24
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m478height3ABfNKs(r0, r3)
            com.stripe.android.ui.core.PaymentsTheme r0 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            r9 = r35
            r4 = 8
            com.stripe.android.ui.core.PaymentsComposeColors r0 = r0.getColors(r9, r4)
            androidx.compose.material.Colors r0 = r0.getMaterial()
            long r4 = r0.m914getPrimary0d7_KjU()
            r7 = 432(0x1b0, float:6.05E-43)
            r8 = 0
            r6 = r9
            androidx.compose.material.IconKt.m1014Iconww6aTOc((androidx.compose.ui.graphics.vector.ImageVector) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (long) r4, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            goto L_0x028b
        L_0x0289:
            r9 = r35
        L_0x028b:
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            r5 = r29
        L_0x029c:
            androidx.compose.runtime.ScopeUpdateScope r8 = r9.endRestartGroup()
            if (r8 != 0) goto L_0x02a3
            goto L_0x02b8
        L_0x02a3:
            com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropdownMenuItem$4 r9 = new com.stripe.android.ui.core.elements.DropdownFieldUIKt$DropdownMenuItem$4
            r0 = r9
            r1 = r31
            r2 = r32
            r3 = r33
            r6 = r37
            r7 = r38
            r0.<init>(r1, r2, r3, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x02b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.DropdownFieldUIKt.m4576DropdownMenuItemcf5BqRc(java.lang.String, boolean, long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: DropDown$lambda-0  reason: not valid java name */
    private static final Integer m4572DropDown$lambda0(State<Integer> state) {
        return state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DropDown$lambda-1  reason: not valid java name */
    public static final int m4573DropDown$lambda1(State<Integer> state) {
        return state.getValue().intValue();
    }
}
