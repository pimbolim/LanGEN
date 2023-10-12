package com.stripe.android.paymentsheet;

import androidx.compose.runtime.Composer;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi-jFuDa88$$inlined$ConstraintLayout$2  reason: invalid class name */
/* compiled from: ConstraintLayout.kt */
public final class PaymentOptionsAdapterKt$PaymentOptionUijFuDa88$$inlined$ConstraintLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$dirty$inlined;
    final /* synthetic */ String $description$inlined;
    final /* synthetic */ int $iconRes$inlined;
    final /* synthetic */ boolean $isEditing$inlined;
    final /* synthetic */ boolean $isEnabled$inlined;
    final /* synthetic */ boolean $isSelected$inlined;
    final /* synthetic */ String $labelText$inlined;
    final /* synthetic */ Function0 $onHelpersChanged;
    final /* synthetic */ String $onRemoveAccessibilityDescription$inlined;
    final /* synthetic */ Function0 $onRemoveListener$inlined;
    final /* synthetic */ String $removePmDialogTitle$inlined;
    final /* synthetic */ ConstraintLayoutScope $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentOptionsAdapterKt$PaymentOptionUijFuDa88$$inlined$ConstraintLayout$2(ConstraintLayoutScope constraintLayoutScope, int i, Function0 function0, boolean z, int i2, boolean z2, Function0 function02, String str, String str2, String str3, String str4, boolean z3, int i3) {
        super(2);
        this.$scope = constraintLayoutScope;
        this.$onHelpersChanged = function0;
        this.$isSelected$inlined = z;
        this.$$dirty$inlined = i2;
        this.$isEditing$inlined = z2;
        this.$onRemoveListener$inlined = function02;
        this.$removePmDialogTitle$inlined = str;
        this.$description$inlined = str2;
        this.$onRemoveAccessibilityDescription$inlined = str3;
        this.$labelText$inlined = str4;
        this.$isEnabled$inlined = z3;
        this.$iconRes$inlined = i3;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r34v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.runtime.Composer r39, int r40) {
        /*
            r38 = this;
            r0 = r38
            r11 = r39
            r1 = r40 & 11
            r9 = 2
            r1 = r1 ^ r9
            if (r1 != 0) goto L_0x0016
            boolean r1 = r39.getSkipping()
            if (r1 != 0) goto L_0x0011
            goto L_0x0016
        L_0x0011:
            r39.skipToGroupEnd()
            goto L_0x0469
        L_0x0016:
            androidx.constraintlayout.compose.ConstraintLayoutScope r1 = r0.$scope
            int r12 = r1.getHelpersHashCode()
            androidx.constraintlayout.compose.ConstraintLayoutScope r1 = r0.$scope
            r1.reset()
            androidx.constraintlayout.compose.ConstraintLayoutScope r13 = r0.$scope
            int r1 = r0.$$changed
            int r1 = r1 >> 3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r14 = 8
            r1 = r1 | r14
            r2 = r1 & 14
            if (r2 != 0) goto L_0x003a
            boolean r2 = r11.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0038
            r2 = 4
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r1 = r1 | r2
        L_0x003a:
            r1 = r1 & 91
            r1 = r1 ^ 18
            if (r1 != 0) goto L_0x004e
            boolean r1 = r39.getSkipping()
            if (r1 != 0) goto L_0x0047
            goto L_0x004e
        L_0x0047:
            r39.skipToGroupEnd()
            r17 = r12
            goto L_0x045a
        L_0x004e:
            androidx.constraintlayout.compose.ConstraintLayoutScope$ConstrainedLayoutReferences r1 = r13.createRefs()
            androidx.constraintlayout.compose.ConstrainedLayoutReference r7 = r1.component1()
            androidx.constraintlayout.compose.ConstrainedLayoutReference r10 = r1.component2()
            androidx.constraintlayout.compose.ConstrainedLayoutReference r8 = r1.component3()
            androidx.constraintlayout.compose.ConstrainedLayoutReference r6 = r1.component4()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 64
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r2)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m478height3ABfNKs(r1, r2)
            r16 = 1086324736(0x40c00000, float:6.0)
            float r2 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r16)
            r3 = 0
            r5 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m433paddingVpY3zN4$default(r1, r2, r3, r9, r5)
            r4 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r3, r4, r5)
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$1 r2 = com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$1.INSTANCE
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.ui.Modifier r1 = r13.constrainAs(r1, r6, r2)
            boolean r2 = r0.$isSelected$inlined
            r3 = -819910463(0xffffffffcf2128c1, float:-2.70380262E9)
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$2 r5 = new com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$2
            int r15 = r0.$iconRes$inlined
            int r9 = r0.$$dirty$inlined
            r5.<init>(r15, r9)
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r3, r4, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            int r5 = r0.$$dirty$inlined
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | 384(0x180, float:5.38E-43)
            r9 = 0
            r15 = 1
            r4 = r39
            r15 = 0
            r40 = r10
            r10 = r6
            r6 = r9
            com.stripe.android.ui.core.elements.SectionUIKt.SectionCard(r1, r2, r3, r4, r5, r6)
            r1 = 1719994174(0x6685073e, float:3.1410417E23)
            r11.startReplaceableGroup(r1)
            boolean r1 = r0.$isSelected$inlined
            r9 = 6
            r6 = 24
            java.lang.String r4 = "C(remember)P(1):Composables.kt#9igjgp"
            r5 = -3686930(0xffffffffffc7bdee, float:NaN)
            r3 = 0
            if (r1 == 0) goto L_0x0252
            com.stripe.android.ui.core.PaymentsTheme r1 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r1 = r1.getColors(r11, r14)
            androidx.compose.material.Colors r1 = r1.getMaterial()
            long r1 = r1.m914getPrimary0d7_KjU()
            boolean r1 = com.stripe.android.ui.core.PaymentsThemeKt.m4516shouldUseDarkDynamicColor8_81llA(r1)
            if (r1 == 0) goto L_0x00de
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m1622getBlack0d7_KjU()
            goto L_0x00e4
        L_0x00de:
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m1633getWhite0d7_KjU()
        L_0x00e4:
            r18 = r1
            androidx.compose.ui.Alignment$Companion r1 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r1 = r1.getCenter()
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.foundation.shape.RoundedCornerShape r20 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
            r15 = r20
            androidx.compose.ui.graphics.Shape r15 = (androidx.compose.ui.graphics.Shape) r15
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.ClipKt.clip(r2, r15)
            float r15 = (float) r6
            float r15 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r15)
            androidx.compose.ui.Modifier r21 = androidx.compose.foundation.layout.SizeKt.m492size3ABfNKs(r2, r15)
            com.stripe.android.ui.core.PaymentsTheme r2 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r2 = r2.getColors(r11, r14)
            androidx.compose.material.Colors r2 = r2.getMaterial()
            long r22 = r2.m914getPrimary0d7_KjU()
            r24 = 0
            r25 = 2
            r26 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m162backgroundbw27NRU$default(r21, r22, r24, r25, r26)
            r11.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            boolean r15 = r11.changed((java.lang.Object) r10)
            java.lang.Object r5 = r39.rememberedValue()
            if (r15 != 0) goto L_0x0135
            androidx.compose.runtime.Composer$Companion r15 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r15.getEmpty()
            if (r5 != r15) goto L_0x013f
        L_0x0135:
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$3$1 r5 = new com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$3$1
            r5.<init>(r10)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r11.updateRememberedValue(r5)
        L_0x013f:
            r39.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            androidx.compose.ui.Modifier r2 = r13.constrainAs(r2, r7, r5)
            r5 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r11.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            androidx.compose.ui.layout.MeasurePolicy r1 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r1, r3, r11, r9)
            r5 = 1376089394(0x52057532, float:1.43299215E11)
            r11.startReplaceableGroup(r5)
            java.lang.String r5 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r7 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r15 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r7, r15)
            java.lang.Object r5 = r11.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r39)
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r21 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r6 = r21
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r7, r15)
            java.lang.Object r6 = r11.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r39)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r21 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r14 = r21
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r7, r15)
            java.lang.Object r7 = r11.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r39)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r15 = r39.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x01b6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01b6:
            r39.startReusableNode()
            boolean r15 = r39.getInserting()
            if (r15 == 0) goto L_0x01c3
            r11.createNode(r14)
            goto L_0x01c6
        L_0x01c3:
            r39.useNode()
        L_0x01c6:
            r39.disableReusing()
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m1234constructorimpl(r39)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r14, r1, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r14, r5, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r14, r6, r1)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r14, r7, r1)
            r39.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r39)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r1)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r2.invoke(r1, r11, r5)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r1)
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            androidx.compose.material.icons.Icons$Filled r1 = androidx.compose.material.icons.Icons.Filled.INSTANCE
            androidx.compose.ui.graphics.vector.ImageVector r1 = androidx.compose.material.icons.filled.CheckKt.getCheck(r1)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r5 = 12
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r5)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m492size3ABfNKs(r2, r5)
            r2 = 0
            r7 = 432(0x1b0, float:6.05E-43)
            r14 = 0
            r15 = 0
            r3 = r5
            r6 = r4
            r4 = r18
            r28 = r6
            r18 = 24
            r6 = r39
            r29 = r8
            r8 = r14
            androidx.compose.material.IconKt.m1014Iconww6aTOc((androidx.compose.ui.graphics.vector.ImageVector) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (long) r4, (androidx.compose.runtime.Composer) r6, (int) r7, (int) r8)
            r39.endReplaceableGroup()
            r39.endReplaceableGroup()
            r39.endNode()
            r39.endReplaceableGroup()
            r39.endReplaceableGroup()
            goto L_0x0259
        L_0x0252:
            r28 = r4
            r29 = r8
            r15 = 0
            r18 = 24
        L_0x0259:
            r39.endReplaceableGroup()
            r1 = 1719995160(0x66850b18, float:3.141397E23)
            r11.startReplaceableGroup(r1)
            boolean r1 = r0.$isEditing$inlined
            if (r1 == 0) goto L_0x03ae
            kotlin.jvm.functions.Function0 r1 = r0.$onRemoveListener$inlined
            if (r1 == 0) goto L_0x03ae
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            java.lang.Object r1 = r39.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x028e
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r15)
            r2 = 2
            r3 = 0
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r3, r2, r3)
            r11.updateRememberedValue(r1)
        L_0x028e:
            r39.endReplaceableGroup()
            r14 = r1
            androidx.compose.runtime.MutableState r14 = (androidx.compose.runtime.MutableState) r14
            java.lang.String r2 = r0.$removePmDialogTitle$inlined
            java.lang.String r3 = r0.$description$inlined
            int r1 = com.stripe.android.paymentsheet.R.string.remove
            java.lang.String r4 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r1, r11, r15)
            int r1 = com.stripe.android.paymentsheet.R.string.cancel
            java.lang.String r5 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r1, r11, r15)
            kotlin.jvm.functions.Function0 r6 = r0.$onRemoveListener$inlined
            r7 = 0
            int r1 = r0.$$dirty$inlined
            int r8 = r1 >> 15
            r8 = r8 & 112(0x70, float:1.57E-43)
            r8 = r8 | r9
            int r9 = r1 >> 15
            r9 = r9 & 896(0x380, float:1.256E-42)
            r8 = r8 | r9
            r9 = 458752(0x70000, float:6.42848E-40)
            int r1 = r1 >> 9
            r1 = r1 & r9
            r9 = r8 | r1
            r17 = 64
            r1 = r14
            r8 = r39
            r30 = r40
            r31 = r10
            r10 = r17
            com.stripe.android.ui.core.elements.SimpleDialogElementUIKt.SimpleDialogElementUI(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.stripe.android.ui.core.PaymentsTheme r1 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            r2 = 8
            com.stripe.android.ui.core.PaymentsComposeColors r1 = r1.getColors(r11, r2)
            androidx.compose.material.Colors r1 = r1.getMaterial()
            long r3 = r1.m908getError0d7_KjU()
            boolean r1 = com.stripe.android.ui.core.PaymentsThemeKt.m4516shouldUseDarkDynamicColor8_81llA(r3)
            if (r1 == 0) goto L_0x02e5
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m1622getBlack0d7_KjU()
            goto L_0x02eb
        L_0x02e5:
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m1633getWhite0d7_KjU()
        L_0x02eb:
            r6 = r1
            int r1 = com.stripe.android.paymentsheet.R.drawable.stripe_ic_delete_symbol
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r11, r15)
            androidx.compose.ui.graphics.ColorFilter$Companion r5 = androidx.compose.ui.graphics.ColorFilter.Companion
            r8 = 0
            r9 = 2
            r10 = 0
            androidx.compose.ui.graphics.ColorFilter r8 = androidx.compose.ui.graphics.ColorFilter.Companion.m1637tintxETnrds$default(r5, r6, r8, r9, r10)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r10 = -3686930(0xffffffffffc7bdee, float:NaN)
            r11.startReplaceableGroup(r10)
            r9 = r28
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            r7 = r31
            boolean r5 = r11.changed((java.lang.Object) r7)
            java.lang.Object r6 = r39.rememberedValue()
            if (r5 != 0) goto L_0x031e
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x0329
        L_0x031e:
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$5$1 r5 = new com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$5$1
            r5.<init>(r7)
            r6 = r5
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r11.updateRememberedValue(r6)
        L_0x0329:
            r39.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r5 = r30
            androidx.compose.ui.Modifier r2 = r13.constrainAs(r2, r5, r6)
            r5 = 20
            float r5 = (float) r5
            float r5 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r5)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m492size3ABfNKs(r2, r5)
            androidx.compose.foundation.shape.RoundedCornerShape r5 = androidx.compose.foundation.shape.RoundedCornerShapeKt.getCircleShape()
            androidx.compose.ui.graphics.Shape r5 = (androidx.compose.ui.graphics.Shape) r5
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.ClipKt.clip(r2, r5)
            r5 = 0
            r6 = 2
            r17 = 0
            r15 = r7
            r7 = r17
            androidx.compose.ui.Modifier r30 = androidx.compose.foundation.BackgroundKt.m162backgroundbw27NRU$default(r2, r3, r5, r6, r7)
            r31 = 0
            r32 = 0
            r33 = 0
            r11.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            boolean r2 = r11.changed((java.lang.Object) r14)
            java.lang.Object r3 = r39.rememberedValue()
            if (r2 != 0) goto L_0x0372
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L_0x037d
        L_0x0372:
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$6$1 r2 = new com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$6$1
            r2.<init>(r14)
            r3 = r2
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r11.updateRememberedValue(r3)
        L_0x037d:
            r39.endReplaceableGroup()
            r34 = r3
            kotlin.jvm.functions.Function0 r34 = (kotlin.jvm.functions.Function0) r34
            r35 = 7
            r36 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.ClickableKt.m180clickableXHw0xAI$default(r30, r31, r32, r33, r34, r35, r36)
            java.lang.String r2 = r0.$onRemoveAccessibilityDescription$inlined
            r4 = 0
            r5 = 0
            r6 = 0
            int r7 = r0.$$dirty$inlined
            int r7 = r7 >> 24
            r7 = r7 & 112(0x70, float:1.57E-43)
            r14 = 8
            r17 = r7 | 8
            r14 = 56
            r7 = r8
            r8 = r39
            r37 = r9
            r9 = r17
            r17 = r12
            r12 = -3686930(0xffffffffffc7bdee, float:NaN)
            r10 = r14
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r1, (java.lang.String) r2, (androidx.compose.ui.Modifier) r3, (androidx.compose.ui.Alignment) r4, (androidx.compose.ui.layout.ContentScale) r5, (float) r6, (androidx.compose.ui.graphics.ColorFilter) r7, (androidx.compose.runtime.Composer) r8, (int) r9, (int) r10)
            goto L_0x03b6
        L_0x03ae:
            r15 = r10
            r17 = r12
            r37 = r28
            r12 = -3686930(0xffffffffffc7bdee, float:NaN)
        L_0x03b6:
            r39.endReplaceableGroup()
            com.stripe.android.ui.core.PaymentsTheme r1 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            r2 = 8
            com.stripe.android.ui.core.PaymentsComposeColors r1 = r1.getColors(r11, r2)
            androidx.compose.material.Colors r1 = r1.getMaterial()
            long r2 = r1.m913getOnSurface0d7_KjU()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r11.startReplaceableGroup(r12)
            r4 = r37
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            boolean r5 = r11.changed((java.lang.Object) r15)
            java.lang.Object r6 = r39.rememberedValue()
            if (r5 != 0) goto L_0x03e7
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r6 != r5) goto L_0x03f2
        L_0x03e7:
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$7$1 r5 = new com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$7$1
            r5.<init>(r15)
            r6 = r5
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r11.updateRememberedValue(r6)
        L_0x03f2:
            r39.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r5 = r29
            androidx.compose.ui.Modifier r21 = r13.constrainAs(r1, r5, r6)
            r1 = 4
            float r1 = (float) r1
            float r23 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r1)
            float r22 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r16)
            float r24 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r16)
            r25 = 0
            r26 = 8
            r27 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m435paddingqDBjuR0$default(r21, r22, r23, r24, r25, r26, r27)
            r11.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r4)
            java.lang.String r4 = r0.$description$inlined
            boolean r4 = r11.changed((java.lang.Object) r4)
            java.lang.Object r5 = r39.rememberedValue()
            if (r4 != 0) goto L_0x042f
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x043c
        L_0x042f:
            com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$8$1 r4 = new com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUi$2$8$1
            java.lang.String r5 = r0.$description$inlined
            r4.<init>(r5)
            r5 = r4
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r11.updateRememberedValue(r5)
        L_0x043c:
            r39.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r4 = 1
            r6 = 0
            r7 = 0
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r7, r5, r4, r6)
            java.lang.String r1 = r0.$labelText$inlined
            boolean r5 = r0.$isEnabled$inlined
            int r6 = r0.$$dirty$inlined
            int r7 = r6 >> 15
            r7 = r7 & 14
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r7 = r7 | r6
            r6 = r39
            com.stripe.android.paymentsheet.ui.LpmSelectorTextKt.m4444LpmSelectorText3IgeMak(r1, r2, r4, r5, r6, r7)
        L_0x045a:
            androidx.constraintlayout.compose.ConstraintLayoutScope r1 = r0.$scope
            int r1 = r1.getHelpersHashCode()
            r2 = r17
            if (r1 == r2) goto L_0x0469
            kotlin.jvm.functions.Function0 r1 = r0.$onHelpersChanged
            r1.invoke()
        L_0x0469:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentOptionsAdapterKt$PaymentOptionUijFuDa88$$inlined$ConstraintLayout$2.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
