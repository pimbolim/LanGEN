package com.stripe.android.paymentsheet.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import com.stripe.android.ui.core.PaymentsTheme;
import com.stripe.android.ui.core.PaymentsThemeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"GooglePayDividerLine", "", "(Landroidx/compose/runtime/Composer;I)V", "GooglePayDividerUi", "text", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayDivider.kt */
public final class GooglePayDividerKt {
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        if ((r1 & 1) != 0) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void GooglePayDividerUi(java.lang.String r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r0 = r30
            r1 = r31
            r2 = -1391112340(0xffffffffad154f6c, float:-8.487305E-12)
            r3 = r29
            androidx.compose.runtime.Composer r2 = r3.startRestartGroup(r2)
            r3 = r0 & 14
            r4 = 2
            if (r3 != 0) goto L_0x0025
            r3 = r1 & 1
            if (r3 != 0) goto L_0x0020
            r3 = r28
            boolean r5 = r2.changed((java.lang.Object) r3)
            if (r5 == 0) goto L_0x0022
            r5 = 4
            goto L_0x0023
        L_0x0020:
            r3 = r28
        L_0x0022:
            r5 = 2
        L_0x0023:
            r5 = r5 | r0
            goto L_0x0028
        L_0x0025:
            r3 = r28
            r5 = r0
        L_0x0028:
            r6 = r5 & 11
            r6 = r6 ^ r4
            if (r6 != 0) goto L_0x0039
            boolean r6 = r2.getSkipping()
            if (r6 != 0) goto L_0x0034
            goto L_0x0039
        L_0x0034:
            r2.skipToGroupEnd()
            goto L_0x01bf
        L_0x0039:
            r2.startDefaults()
            r6 = r0 & 1
            r7 = 0
            if (r6 == 0) goto L_0x0050
            boolean r6 = r2.getDefaultsInvalid()
            if (r6 == 0) goto L_0x0048
            goto L_0x0050
        L_0x0048:
            r2.skipToGroupEnd()
            r6 = r1 & 1
            if (r6 == 0) goto L_0x005c
            goto L_0x005a
        L_0x0050:
            r6 = r1 & 1
            if (r6 == 0) goto L_0x005c
            int r3 = com.stripe.android.paymentsheet.R.string.stripe_paymentsheet_or_pay_with_card
            java.lang.String r3 = androidx.compose.ui.res.StringResources_androidKt.stringResource(r3, r2, r7)
        L_0x005a:
            r5 = r5 & -15
        L_0x005c:
            r27 = r3
            r3 = r5
            r2.endDefaults()
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenter()
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            r8 = 0
            r9 = 1
            r10 = 0
            androidx.compose.ui.Modifier r11 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r6, r8, r9, r10)
            r12 = 0
            r6 = 16
            float r6 = (float) r6
            float r13 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r6)
            r14 = 0
            r15 = 0
            r16 = 13
            r17 = 0
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.PaddingKt.m435paddingqDBjuR0$default(r11, r12, r13, r14, r15, r16, r17)
            r9 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            r9 = 6
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r7, r2, r9)
            r9 = 1376089394(0x52057532, float:1.43299215E11)
            r2.startReplaceableGroup(r9)
            java.lang.String r9 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r9)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r11 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r12 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r11, r12)
            java.lang.Object r9 = r2.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r11, r12)
            java.lang.Object r13 = r2.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r13 = (androidx.compose.ui.unit.LayoutDirection) r13
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r11, r12)
            java.lang.Object r11 = r2.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.platform.ViewConfiguration r11 = (androidx.compose.ui.platform.ViewConfiguration) r11
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            androidx.compose.runtime.Applier r14 = r2.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x00f0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00f0:
            r2.startReusableNode()
            boolean r14 = r2.getInserting()
            if (r14 == 0) goto L_0x00fd
            r2.createNode(r12)
            goto L_0x0100
        L_0x00fd:
            r2.useNode()
        L_0x0100:
            r2.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m1234constructorimpl(r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r12, r5, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r12, r9, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r12, r13, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r12, r11, r5)
            r2.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r5)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            r6.invoke(r5, r2, r9)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r5)
            r5 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r2.startReplaceableGroup(r5)
            java.lang.String r5 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r5)
            androidx.compose.foundation.layout.BoxScopeInstance r5 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r5 = (androidx.compose.foundation.layout.BoxScope) r5
            GooglePayDividerLine(r2, r7)
            com.stripe.android.ui.core.PaymentsTheme r5 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            r7 = 8
            androidx.compose.material.Typography r5 = r5.getTypography(r2, r7)
            androidx.compose.ui.text.TextStyle r22 = r5.getBody1()
            com.stripe.android.ui.core.PaymentsTheme r5 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r5 = r5.getColors(r2, r7)
            long r5 = r5.m4507getSubtitle0d7_KjU()
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            r11 = r9
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            com.stripe.android.ui.core.PaymentsTheme r9 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeColors r9 = r9.getColors(r2, r7)
            androidx.compose.material.Colors r9 = r9.getMaterial()
            long r12 = r9.m918getSurface0d7_KjU()
            r14 = 0
            r15 = 2
            r16 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.BackgroundKt.m162backgroundbw27NRU$default(r11, r12, r14, r15, r16)
            float r7 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r7)
            androidx.compose.ui.Modifier r4 = androidx.compose.foundation.layout.PaddingKt.m433paddingVpY3zN4$default(r9, r7, r8, r4, r10)
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r15 = 0
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r24 = r3 & 14
            r25 = 0
            r26 = 32760(0x7ff8, float:4.5907E-41)
            r3 = r27
            r23 = r2
            androidx.compose.material.TextKt.m1189TextfLXpl1I(r3, r4, r5, r7, r9, r10, r11, r12, r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r2.endNode()
            r2.endReplaceableGroup()
            r2.endReplaceableGroup()
            r3 = r27
        L_0x01bf:
            androidx.compose.runtime.ScopeUpdateScope r2 = r2.endRestartGroup()
            if (r2 != 0) goto L_0x01c6
            goto L_0x01d0
        L_0x01c6:
            com.stripe.android.paymentsheet.ui.GooglePayDividerKt$GooglePayDividerUi$2 r4 = new com.stripe.android.paymentsheet.ui.GooglePayDividerKt$GooglePayDividerUi$2
            r4.<init>(r3, r0, r1)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.updateScope(r4)
        L_0x01d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.ui.GooglePayDividerKt.GooglePayDividerUi(java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void GooglePayDividerLine(Composer composer, int i) {
        long j;
        Composer startRestartGroup = composer.startRestartGroup(-1133040395);
        if (i != 0 || !startRestartGroup.getSkipping()) {
            if (PaymentsThemeKt.m4516shouldUseDarkDynamicColor8_81llA(PaymentsTheme.INSTANCE.getColors(startRestartGroup, 8).getMaterial().m918getSurface0d7_KjU())) {
                j = Color.m1595copywmQWz5c$default(Color.Companion.m1622getBlack0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            } else {
                j = Color.m1595copywmQWz5c$default(Color.Companion.m1633getWhite0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            BoxKt.Box(SizeKt.fillMaxWidth$default(SizeKt.m478height3ABfNKs(BackgroundKt.m162backgroundbw27NRU$default(Modifier.Companion, j, (Shape) null, 2, (Object) null), PaymentsTheme.INSTANCE.getShapes(startRestartGroup, 8).m4512getBorderStrokeWidthD9Ej5fM()), 0.0f, 1, (Object) null), startRestartGroup, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new GooglePayDividerKt$GooglePayDividerLine$1(i));
        }
    }
}
