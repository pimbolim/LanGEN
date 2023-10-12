package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\u0002\b\u00132\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0016R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\t\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/material/OneLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconVerticalPadding", "MinHeight", "MinHeightWithIcon", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class OneLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    public static final OneLine INSTANCE = new OneLine();
    private static final float IconLeftPadding;
    private static final float IconMinPaddedWidth = Dp.m3859constructorimpl((float) 40);
    private static final float IconVerticalPadding = Dp.m3859constructorimpl((float) 8);
    private static final float MinHeight = Dp.m3859constructorimpl((float) 48);
    private static final float MinHeightWithIcon = Dp.m3859constructorimpl((float) 56);
    private static final float TrailingRightPadding;

    private OneLine() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0540  */
    /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ListItem(androidx.compose.ui.Modifier r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r31 = this;
            r3 = r33
            r4 = r34
            r5 = r35
            r6 = r37
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -2068382548(0xffffffff84b6fcac, float:-4.3020037E-36)
            r1 = r36
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ListItem)P(1)142@5412L1102:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r38 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0027
            r7 = r6 | 6
            r8 = r7
            r7 = r32
            goto L_0x003b
        L_0x0027:
            r7 = r6 & 14
            if (r7 != 0) goto L_0x0038
            r7 = r32
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0035
            r8 = 4
            goto L_0x0036
        L_0x0035:
            r8 = 2
        L_0x0036:
            r8 = r8 | r6
            goto L_0x003b
        L_0x0038:
            r7 = r32
            r8 = r6
        L_0x003b:
            r9 = r38 & 2
            if (r9 == 0) goto L_0x0042
            r8 = r8 | 48
            goto L_0x0052
        L_0x0042:
            r9 = r6 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x0052
            boolean r9 = r0.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x004f
            r9 = 32
            goto L_0x0051
        L_0x004f:
            r9 = 16
        L_0x0051:
            r8 = r8 | r9
        L_0x0052:
            r9 = r38 & 4
            if (r9 == 0) goto L_0x0059
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0059:
            r9 = r6 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0069
            boolean r9 = r0.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x0066
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r8 = r8 | r9
        L_0x0069:
            r9 = r38 & 8
            if (r9 == 0) goto L_0x0070
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x0070:
            r9 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0080
            boolean r9 = r0.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x007d
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r8 = r8 | r9
        L_0x0080:
            r9 = r38 & 16
            if (r9 == 0) goto L_0x0087
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x0087:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r6
            if (r9 != 0) goto L_0x009c
            r9 = r31
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0098
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r8 = r8 | r10
            goto L_0x009e
        L_0x009c:
            r9 = r31
        L_0x009e:
            r10 = 46811(0xb6db, float:6.5596E-41)
            r10 = r10 & r8
            r10 = r10 ^ 9362(0x2492, float:1.3119E-41)
            if (r10 != 0) goto L_0x00b3
            boolean r10 = r0.getSkipping()
            if (r10 != 0) goto L_0x00ad
            goto L_0x00b3
        L_0x00ad:
            r0.skipToGroupEnd()
            r2 = r7
            goto L_0x0539
        L_0x00b3:
            if (r1 == 0) goto L_0x00ba
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00bb
        L_0x00ba:
            r1 = r7
        L_0x00bb:
            if (r3 != 0) goto L_0x00c0
            float r7 = MinHeight
            goto L_0x00c2
        L_0x00c0:
            float r7 = MinHeightWithIcon
        L_0x00c2:
            r10 = 0
            r11 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m480heightInVpY3zN4$default(r1, r7, r10, r2, r11)
            r12 = -1989997165(0xffffffff89630d93, float:-2.7330514E-33)
            r0.startReplaceableGroup(r12)
            java.lang.String r12 = "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.foundation.layout.Arrangement r12 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r12 = r12.getStart()
            androidx.compose.ui.Alignment$Companion r13 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r13 = r13.getTop()
            r14 = 0
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r12, r13, r0, r14)
            r13 = 1376089394(0x52057532, float:1.43299215E11)
            r0.startReplaceableGroup(r13)
            java.lang.String r15 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r13 = r16
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r2 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r10)
            java.lang.Object r13 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r11 = r17
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r10)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r14 = r17
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r2, r10)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r14 = (androidx.compose.ui.platform.ViewConfiguration) r14
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r2 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            r17 = r1
            androidx.compose.runtime.Applier r1 = r0.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x0147
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0147:
            r0.startReusableNode()
            boolean r1 = r0.getInserting()
            if (r1 == 0) goto L_0x0154
            r0.createNode(r2)
            goto L_0x0157
        L_0x0154:
            r0.useNode()
        L_0x0157:
            r0.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m1234constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r1, r12, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r1, r13, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r1, r11, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r1, r14, r2)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r1)
            r2 = 0
            java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
            r7.invoke(r1, r0, r11)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r2 = -326682362(0xffffffffec873906, float:-1.3077942E27)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C79@3942L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.RowScopeInstance r2 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            androidx.compose.foundation.layout.RowScope r2 = (androidx.compose.foundation.layout.RowScope) r2
            r7 = 1825884304(0x6cd4c890, float:2.0579152E27)
            r0.startReplaceableGroup(r7)
            java.lang.String r11 = "C155@5989L262,162@6304L186:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "144@5502L460"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            java.lang.String r7 = "C72@3384L9:Box.kt#2w3rfo"
            java.lang.String r12 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            if (r3 == 0) goto L_0x02e9
            androidx.compose.ui.Modifier$Companion r18 = androidx.compose.ui.Modifier.Companion
            r11 = r18
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            androidx.compose.ui.Alignment$Companion r18 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r1 = r18.getCenterVertically()
            androidx.compose.ui.Modifier r1 = r2.align(r11, r1)
            float r25 = IconLeftPadding
            float r11 = IconMinPaddedWidth
            float r11 = r25 + r11
            float r11 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r11)
            r6 = 2
            r13 = 0
            r14 = 0
            androidx.compose.ui.Modifier r24 = androidx.compose.foundation.layout.SizeKt.m499widthInVpY3zN4$default(r1, r11, r13, r6, r14)
            float r28 = IconVerticalPadding
            r27 = 0
            r29 = 4
            r30 = 0
            r26 = r28
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m435paddingqDBjuR0$default(r24, r25, r26, r27, r28, r29, r30)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getCenterStart()
            r11 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            r11 = 6
            r13 = 0
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r13, r0, r11)
            r11 = 1376089394(0x52057532, float:1.43299215E11)
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r13 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r10)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r10)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r9 = r16
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r10)
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r5 = r0.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x0260
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0260:
            r0.startReusableNode()
            boolean r5 = r0.getInserting()
            if (r5 == 0) goto L_0x026d
            r0.createNode(r13)
            goto L_0x0270
        L_0x026d:
            r0.useNode()
        L_0x0270:
            r0.disableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.Updater.m1234constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r6, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r11, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r14, r6)
            androidx.compose.ui.node.ComposeUiNode$Companion r6 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r6 = r6.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r5, r9, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r5)
            r6 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r1.invoke(r5, r0, r9)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r0.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = 1962584985(0x74faab99, float:1.5888118E32)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C153@5954L6:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            int r1 = r8 >> 3
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.invoke(r0, r1)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x02e9:
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r19 = r1
            androidx.compose.ui.Modifier r19 = (androidx.compose.ui.Modifier) r19
            r20 = 1065353216(0x3f800000, float:1.0)
            r21 = 0
            r22 = 2
            r23 = 0
            r18 = r2
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.RowScope.DefaultImpls.weight$default(r18, r19, r20, r21, r22, r23)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r5 = r5.getCenterVertically()
            androidx.compose.ui.Modifier r24 = r2.align(r1, r5)
            float r25 = ContentLeftPadding
            r26 = 0
            float r27 = ContentRightPadding
            r28 = 0
            r29 = 10
            r30 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m435paddingqDBjuR0$default(r24, r25, r26, r27, r28, r29, r30)
            androidx.compose.ui.Alignment$Companion r5 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r5 = r5.getCenterStart()
            r6 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r0.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            r6 = 6
            r9 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r9, r0, r6)
            r6 = 1376089394(0x52057532, float:1.43299215E11)
            r0.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r9 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r9 = r0.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0386
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0386:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x0393
            r0.createNode(r13)
            goto L_0x0396
        L_0x0393:
            r0.useNode()
        L_0x0396:
            r0.disableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m1234constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r13, r5, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r13, r6, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r13, r11, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r13, r9, r5)
            r0.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r5)
            r6 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r1.invoke(r5, r0, r9)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r0.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = 1962585274(0x74faacba, float:1.5888398E32)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C160@6243L6:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            int r1 = r8 >> 6
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.invoke(r0, r1)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r5 = r35
            if (r5 == 0) goto L_0x0525
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r6 = r6.getCenterVertically()
            androidx.compose.ui.Modifier r24 = r2.align(r1, r6)
            r25 = 0
            r26 = 0
            float r27 = TrailingRightPadding
            r28 = 0
            r29 = 11
            r30 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m435paddingqDBjuR0$default(r24, r25, r26, r27, r28, r29, r30)
            r2 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r0.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r12)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            r6 = 0
            androidx.compose.ui.layout.MeasurePolicy r2 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r6, r0, r6)
            r6 = 1376089394(0x52057532, float:1.43299215E11)
            r0.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r9 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r9 = r0.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r1 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            androidx.compose.runtime.Applier r12 = r0.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x049c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x049c:
            r0.startReusableNode()
            boolean r12 = r0.getInserting()
            if (r12 == 0) goto L_0x04a9
            r0.createNode(r10)
            goto L_0x04ac
        L_0x04a9:
            r0.useNode()
        L_0x04ac:
            r0.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m1234constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r12 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r2, r12)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r11, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r9, r2)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r2)
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r1.invoke(r2, r0, r6)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r0.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = 1962585509(0x74faada5, float:1.5888625E32)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C166@6478L10:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            int r1 = r8 >> 9
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r5.invoke(r0, r1)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x0525:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r2 = r17
        L_0x0539:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x0540
            goto L_0x0557
        L_0x0540:
            androidx.compose.material.OneLine$ListItem$2 r9 = new androidx.compose.material.OneLine$ListItem$2
            r0 = r9
            r1 = r31
            r3 = r33
            r4 = r34
            r5 = r35
            r6 = r37
            r7 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0557:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OneLine.ListItem(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = (float) 16;
        IconLeftPadding = Dp.m3859constructorimpl(f);
        ContentLeftPadding = Dp.m3859constructorimpl(f);
        ContentRightPadding = Dp.m3859constructorimpl(f);
        TrailingRightPadding = Dp.m3859constructorimpl(f);
    }
}
