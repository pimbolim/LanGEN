package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.ui.core.PaymentsTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u001aK\u0010\u0000\u001a\u00020\u00012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0013\b\u0002\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\b2\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\n\u001a4\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\u0011\u001a\u0015\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0013\u001a\u0019\u0010\u0014\u001a\u00020\u00012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Section", "", "title", "", "error", "", "contentOutsideCard", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "contentInCard", "(Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SectionCard", "modifier", "Landroidx/compose/ui/Modifier;", "isSelected", "", "content", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SectionError", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "SectionTitle", "titleText", "(Ljava/lang/Integer;Landroidx/compose/runtime/Composer;I)V", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionUI.kt */
public final class SectionUIKt {
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Section(java.lang.Integer r9, java.lang.String r10, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r11, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            java.lang.String r0 = "contentInCard"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1669854812(0xffffffff9c7809a4, float:-8.2068777E-22)
            androidx.compose.runtime.Composer r13 = r13.startRestartGroup(r0)
            r0 = r15 & 1
            if (r0 == 0) goto L_0x0013
            r0 = r14 | 6
            goto L_0x0023
        L_0x0013:
            r0 = r14 & 14
            if (r0 != 0) goto L_0x0022
            boolean r0 = r13.changed((java.lang.Object) r9)
            if (r0 == 0) goto L_0x001f
            r0 = 4
            goto L_0x0020
        L_0x001f:
            r0 = 2
        L_0x0020:
            r0 = r0 | r14
            goto L_0x0023
        L_0x0022:
            r0 = r14
        L_0x0023:
            r1 = r15 & 2
            if (r1 == 0) goto L_0x002a
            r0 = r0 | 48
            goto L_0x003a
        L_0x002a:
            r1 = r14 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x003a
            boolean r1 = r13.changed((java.lang.Object) r10)
            if (r1 == 0) goto L_0x0037
            r1 = 32
            goto L_0x0039
        L_0x0037:
            r1 = 16
        L_0x0039:
            r0 = r0 | r1
        L_0x003a:
            r1 = r15 & 4
            if (r1 == 0) goto L_0x0041
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0051
        L_0x0041:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0051
            boolean r2 = r13.changed((java.lang.Object) r11)
            if (r2 == 0) goto L_0x004e
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0050
        L_0x004e:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0050:
            r0 = r0 | r2
        L_0x0051:
            r2 = r15 & 8
            if (r2 == 0) goto L_0x0058
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0068
        L_0x0058:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0068
            boolean r2 = r13.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0065
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0067
        L_0x0065:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0067:
            r0 = r0 | r2
        L_0x0068:
            r2 = r0 & 5851(0x16db, float:8.199E-42)
            r2 = r2 ^ 1170(0x492, float:1.64E-42)
            if (r2 != 0) goto L_0x007b
            boolean r2 = r13.getSkipping()
            if (r2 != 0) goto L_0x0075
            goto L_0x007b
        L_0x0075:
            r13.skipToGroupEnd()
        L_0x0078:
            r4 = r11
            goto L_0x01ab
        L_0x007b:
            if (r1 == 0) goto L_0x0083
            com.stripe.android.ui.core.elements.ComposableSingletons$SectionUIKt r11 = com.stripe.android.ui.core.elements.ComposableSingletons$SectionUIKt.INSTANCE
            kotlin.jvm.functions.Function2 r11 = r11.m4565getLambda1$payments_ui_core_release()
        L_0x0083:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r2 = 0
            r3 = 8
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r3)
            r4 = 0
            r5 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m433paddingVpY3zN4$default(r1, r2, r3, r5, r4)
            r2 = -1113030915(0xffffffffbda87efd, float:-0.08227346)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "C(Column)P(2,3,1)76@3834L61,77@3900L133:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            androidx.compose.foundation.layout.Arrangement r2 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Vertical r2 = r2.getTop()
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Horizontal r3 = r3.getStart()
            r4 = 0
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.ColumnKt.columnMeasurePolicy(r2, r3, r13, r4)
            r3 = 1376089394(0x52057532, float:1.43299215E11)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r5 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            java.lang.Object r3 = r13.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            java.lang.Object r7 = r13.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r5, r6)
            java.lang.Object r5 = r13.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r6 = r6.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r8 = r13.getApplier()
            boolean r8 = r8 instanceof androidx.compose.runtime.Applier
            if (r8 != 0) goto L_0x010c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x010c:
            r13.startReusableNode()
            boolean r8 = r13.getInserting()
            if (r8 == 0) goto L_0x0119
            r13.createNode(r6)
            goto L_0x011c
        L_0x0119:
            r13.useNode()
        L_0x011c:
            r13.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m1234constructorimpl(r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r3, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r7, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r6, r5, r2)
            r13.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r13)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r2)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r1.invoke(r2, r13, r3)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r13.startReplaceableGroup(r1)
            r1 = 276693625(0x107e0279, float:5.0094572E-29)
            r13.startReplaceableGroup(r1)
            java.lang.String r1 = "C78@3948L9:Column.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            androidx.compose.foundation.layout.ColumnScopeInstance r1 = androidx.compose.foundation.layout.ColumnScopeInstance.INSTANCE
            androidx.compose.foundation.layout.ColumnScope r1 = (androidx.compose.foundation.layout.ColumnScope) r1
            r1 = r0 & 14
            SectionTitle(r9, r13, r1)
            r1 = 0
            r2 = 0
            int r7 = r0 >> 3
            r5 = r7 & 896(0x380, float:1.256E-42)
            r6 = 3
            r3 = r12
            r4 = r13
            SectionCard(r1, r2, r3, r4, r5, r6)
            r1 = -694657551(0xffffffffd6985df1, float:-8.3764621E13)
            r13.startReplaceableGroup(r1)
            if (r10 == 0) goto L_0x018c
            r1 = r7 & 14
            SectionError(r10, r13, r1)
        L_0x018c:
            r13.endReplaceableGroup()
            int r0 = r0 >> 6
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11.invoke(r13, r0)
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            r13.endNode()
            r13.endReplaceableGroup()
            r13.endReplaceableGroup()
            goto L_0x0078
        L_0x01ab:
            androidx.compose.runtime.ScopeUpdateScope r11 = r13.endRestartGroup()
            if (r11 != 0) goto L_0x01b2
            goto L_0x01c2
        L_0x01b2:
            com.stripe.android.ui.core.elements.SectionUIKt$Section$2 r13 = new com.stripe.android.ui.core.elements.SectionUIKt$Section$2
            r1 = r13
            r2 = r9
            r3 = r10
            r5 = r12
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r11.updateScope(r13)
        L_0x01c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.SectionUIKt.Section(java.lang.Integer, java.lang.String, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void SectionTitle(Integer num, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1661513010);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) num) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((2 ^ (i2 & 11)) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (num != null) {
            num.intValue();
            H6TextKt.H6Text(StringResources_androidKt.stringResource(num.intValue(), startRestartGroup, i2 & 14), SemanticsModifierKt.semantics(PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.m3859constructorimpl((float) 4), 7, (Object) null), true, SectionUIKt$SectionTitle$1$1.INSTANCE), startRestartGroup, 0, 0);
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SectionUIKt$SectionTitle$2(num, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SectionCard(androidx.compose.ui.Modifier r18, boolean r19, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r3 = r20
            r4 = r22
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 37658416(0x23e9f30, float:1.400468E-37)
            r1 = r21
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SectionCard)P(2,1)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r23 & 1
            if (r1 == 0) goto L_0x0021
            r2 = r4 | 6
            r5 = r2
            r2 = r18
            goto L_0x0035
        L_0x0021:
            r2 = r4 & 14
            if (r2 != 0) goto L_0x0032
            r2 = r18
            boolean r5 = r0.changed((java.lang.Object) r2)
            if (r5 == 0) goto L_0x002f
            r5 = 4
            goto L_0x0030
        L_0x002f:
            r5 = 2
        L_0x0030:
            r5 = r5 | r4
            goto L_0x0035
        L_0x0032:
            r2 = r18
            r5 = r4
        L_0x0035:
            r6 = r23 & 2
            if (r6 == 0) goto L_0x003c
            r5 = r5 | 48
            goto L_0x004f
        L_0x003c:
            r7 = r4 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x004f
            r7 = r19
            boolean r8 = r0.changed((boolean) r7)
            if (r8 == 0) goto L_0x004b
            r8 = 32
            goto L_0x004d
        L_0x004b:
            r8 = 16
        L_0x004d:
            r5 = r5 | r8
            goto L_0x0051
        L_0x004f:
            r7 = r19
        L_0x0051:
            r8 = r23 & 4
            if (r8 == 0) goto L_0x0058
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0058:
            r8 = r4 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0068
            boolean r8 = r0.changed((java.lang.Object) r3)
            if (r8 == 0) goto L_0x0065
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r5 = r5 | r8
        L_0x0068:
            r8 = r5 & 731(0x2db, float:1.024E-42)
            r8 = r8 ^ 146(0x92, float:2.05E-43)
            if (r8 != 0) goto L_0x007c
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x0075
            goto L_0x007c
        L_0x0075:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r7
            goto L_0x00e6
        L_0x007c:
            if (r1 == 0) goto L_0x0083
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x0084
        L_0x0083:
            r1 = r2
        L_0x0084:
            r2 = 0
            if (r6 == 0) goto L_0x0089
            r15 = 0
            goto L_0x008a
        L_0x0089:
            r15 = r7
        L_0x008a:
            com.stripe.android.ui.core.PaymentsTheme r6 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            int r7 = r5 >> 3
            r7 = r7 & 14
            r7 = r7 | 64
            androidx.compose.foundation.BorderStroke r11 = r6.getBorderStroke(r15, r0, r7)
            if (r15 == 0) goto L_0x00a0
            r6 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            float r2 = (float) r6
            float r2 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r2)
            goto L_0x00a5
        L_0x00a0:
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r2)
        L_0x00a5:
            r12 = r2
            com.stripe.android.ui.core.PaymentsTheme r2 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            r6 = 8
            com.stripe.android.ui.core.PaymentsComposeColors r2 = r2.getColors(r0, r6)
            long r7 = r2.m4504getComponent0d7_KjU()
            com.stripe.android.ui.core.PaymentsTheme r2 = com.stripe.android.ui.core.PaymentsTheme.INSTANCE
            com.stripe.android.ui.core.PaymentsComposeShapes r2 = r2.getShapes(r0, r6)
            androidx.compose.material.Shapes r2 = r2.getMaterial()
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getMedium()
            r6 = r2
            androidx.compose.ui.graphics.Shape r6 = (androidx.compose.ui.graphics.Shape) r6
            r9 = 0
            r2 = -819892709(0xffffffffcf216e1b, float:-2.70834765E9)
            com.stripe.android.ui.core.elements.SectionUIKt$SectionCard$1 r13 = new com.stripe.android.ui.core.elements.SectionUIKt$SectionCard$1
            r13.<init>(r3, r5)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r2, r14, r13)
            r13 = r2
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r2 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 & 14
            r2 = r2 | r5
            r16 = 8
            r5 = r1
            r14 = r0
            r17 = r15
            r15 = r2
            androidx.compose.material.CardKt.m889CardFjzlyU(r5, r6, r7, r9, r11, r12, r13, r14, r15, r16)
            r2 = r17
        L_0x00e6:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x00ed
            goto L_0x00fe
        L_0x00ed:
            com.stripe.android.ui.core.elements.SectionUIKt$SectionCard$2 r7 = new com.stripe.android.ui.core.elements.SectionUIKt$SectionCard$2
            r0 = r7
            r3 = r20
            r4 = r22
            r5 = r23
            r0.<init>(r1, r2, r3, r4, r5)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.SectionUIKt.SectionCard(androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void SectionError(String str, Composer composer, int i) {
        int i2;
        Composer composer2;
        String str2 = str;
        int i3 = i;
        Intrinsics.checkNotNullParameter(str2, ReactVideoView.EVENT_PROP_ERROR);
        Composer startRestartGroup = composer.startRestartGroup(1240332247);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) str2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if (((i2 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            composer2 = startRestartGroup;
            TextKt.m1189TextfLXpl1I(str, SemanticsModifierKt.semantics(Modifier.Companion, true, SectionUIKt$SectionError$1.INSTANCE), PaymentsTheme.INSTANCE.getColors(startRestartGroup, 8).getMaterial().m908getError0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, PaymentsTheme.INSTANCE.getTypography(startRestartGroup, 8).getH6(), composer2, i2 & 14, 0, 32760);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SectionUIKt$SectionError$2(str, i));
        }
    }
}
