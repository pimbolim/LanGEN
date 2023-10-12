package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J|\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0002\b\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0002\b\u00162\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\b\u00162\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001bR\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\t\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\r\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/material/ThreeLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconThreeLineVerticalPadding", "MinHeight", "ThreeLineBaselineFirstOffset", "ThreeLineBaselineSecondOffset", "ThreeLineBaselineThirdOffset", "ThreeLineTrailingTopPadding", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ThreeLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    public static final ThreeLine INSTANCE = new ThreeLine();
    private static final float IconLeftPadding;
    private static final float IconMinPaddedWidth = Dp.m3859constructorimpl((float) 40);
    private static final float IconThreeLineVerticalPadding;
    private static final float MinHeight = Dp.m3859constructorimpl((float) 88);
    private static final float ThreeLineBaselineFirstOffset = Dp.m3859constructorimpl((float) 28);
    private static final float ThreeLineBaselineSecondOffset;
    private static final float ThreeLineBaselineThirdOffset;
    private static final float ThreeLineTrailingTopPadding;
    private static final float TrailingRightPadding;

    private ThreeLine() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ListItem(androidx.compose.ui.Modifier r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r33 = this;
            r3 = r35
            r4 = r36
            r5 = r37
            r6 = r38
            r13 = r39
            r14 = r41
            java.lang.String r0 = "text"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "secondaryText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = -678938123(0xffffffffd78839f5, float:-2.9956501E14)
            r1 = r40
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ListItem)P(1!1,4,3)302@11212L1431:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r42 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0030
            r7 = r14 | 6
            r8 = r7
            r7 = r34
            goto L_0x0044
        L_0x0030:
            r7 = r14 & 14
            if (r7 != 0) goto L_0x0041
            r7 = r34
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x003e
            r8 = 4
            goto L_0x003f
        L_0x003e:
            r8 = 2
        L_0x003f:
            r8 = r8 | r14
            goto L_0x0044
        L_0x0041:
            r7 = r34
            r8 = r14
        L_0x0044:
            r9 = r42 & 2
            if (r9 == 0) goto L_0x004b
            r8 = r8 | 48
            goto L_0x005b
        L_0x004b:
            r9 = r14 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x005b
            boolean r9 = r0.changed((java.lang.Object) r3)
            if (r9 == 0) goto L_0x0058
            r9 = 32
            goto L_0x005a
        L_0x0058:
            r9 = 16
        L_0x005a:
            r8 = r8 | r9
        L_0x005b:
            r9 = r42 & 4
            if (r9 == 0) goto L_0x0062
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x0072
        L_0x0062:
            r9 = r14 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0072
            boolean r9 = r0.changed((java.lang.Object) r4)
            if (r9 == 0) goto L_0x006f
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0071
        L_0x006f:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0071:
            r8 = r8 | r9
        L_0x0072:
            r9 = r42 & 8
            if (r9 == 0) goto L_0x0079
            r8 = r8 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0079:
            r9 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0089
            boolean r9 = r0.changed((java.lang.Object) r5)
            if (r9 == 0) goto L_0x0086
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r8 = r8 | r9
        L_0x0089:
            r9 = r42 & 16
            if (r9 == 0) goto L_0x0090
            r8 = r8 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a2
        L_0x0090:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00a2
            boolean r9 = r0.changed((java.lang.Object) r6)
            if (r9 == 0) goto L_0x009f
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r8 = r8 | r9
        L_0x00a2:
            r9 = r42 & 32
            if (r9 == 0) goto L_0x00aa
            r9 = 196608(0x30000, float:2.75506E-40)
        L_0x00a8:
            r8 = r8 | r9
            goto L_0x00bb
        L_0x00aa:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00bb
            boolean r9 = r0.changed((java.lang.Object) r13)
            if (r9 == 0) goto L_0x00b8
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a8
        L_0x00b8:
            r9 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a8
        L_0x00bb:
            r9 = r42 & 64
            if (r9 == 0) goto L_0x00c5
            r9 = 1572864(0x180000, float:2.204052E-39)
            r8 = r8 | r9
            r15 = r33
            goto L_0x00d8
        L_0x00c5:
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r14
            r15 = r33
            if (r9 != 0) goto L_0x00d8
            boolean r9 = r0.changed((java.lang.Object) r15)
            if (r9 == 0) goto L_0x00d5
            r9 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r9 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r8 = r8 | r9
        L_0x00d8:
            r12 = r8
            r8 = 2995931(0x2db6db, float:4.198194E-39)
            r8 = r8 & r12
            r9 = 599186(0x92492, float:8.39638E-40)
            r8 = r8 ^ r9
            if (r8 != 0) goto L_0x00f0
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x00ea
            goto L_0x00f0
        L_0x00ea:
            r0.skipToGroupEnd()
            r2 = r7
            goto L_0x03ba
        L_0x00f0:
            if (r1 == 0) goto L_0x00f7
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00f8
        L_0x00f7:
            r1 = r7
        L_0x00f8:
            float r7 = MinHeight
            r8 = 0
            r9 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m480heightInVpY3zN4$default(r1, r7, r8, r2, r9)
            r8 = -1989997165(0xffffffff89630d93, float:-2.7330514E-33)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Row)P(2,1,3)77@3834L58,78@3897L130:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r8 = r8.getStart()
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r9 = r9.getTop()
            r10 = 0
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r8, r9, r0, r10)
            r9 = 1376089394(0x52057532, float:1.43299215E11)
            r0.startReplaceableGroup(r9)
            java.lang.String r11 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r2 = r16
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r9 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r10 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            r18 = r1
            r1 = r17
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r1 = r0.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            r14 = r17
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r14 = (androidx.compose.ui.platform.ViewConfiguration) r14
            androidx.compose.ui.node.ComposeUiNode$Companion r17 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r17.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            androidx.compose.runtime.Applier r15 = r0.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x017f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x017f:
            r0.startReusableNode()
            boolean r15 = r0.getInserting()
            if (r15 == 0) goto L_0x018c
            r0.createNode(r9)
            goto L_0x018f
        L_0x018c:
            r0.useNode()
        L_0x018f:
            r0.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m1234constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r15 = r15.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r8, r15)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r1, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r9, r14, r1)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r1)
            r2 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)
            r7.invoke(r1, r0, r8)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r2 = -326682362(0xffffffffec873906, float:-1.3077942E27)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C79@3942L9:Row.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            androidx.compose.foundation.layout.RowScopeInstance r2 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r20 = r2
            androidx.compose.foundation.layout.RowScope r20 = (androidx.compose.foundation.layout.RowScope) r20
            r2 = -280382992(0xffffffffef49b1f0, float:-6.24216E28)
            r0.startReplaceableGroup(r2)
            java.lang.String r7 = "C316@11836L477,330@12366L253:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "305@11369L440"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            if (r3 == 0) goto L_0x031b
            float r22 = IconLeftPadding
            float r2 = IconMinPaddedWidth
            float r2 = r22 + r2
            float r25 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r23 = r2
            androidx.compose.ui.Modifier r23 = (androidx.compose.ui.Modifier) r23
            r26 = 0
            r27 = 0
            r28 = 12
            r29 = 0
            r24 = r25
            androidx.compose.ui.Modifier r21 = androidx.compose.foundation.layout.SizeKt.m496sizeInqDBjuR0$default(r23, r24, r25, r26, r27, r28, r29)
            float r25 = IconThreeLineVerticalPadding
            r24 = 0
            r26 = 4
            r27 = 0
            r23 = r25
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m435paddingqDBjuR0$default(r21, r22, r23, r24, r25, r26, r27)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getCenterStart()
            r8 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            r8 = 6
            r9 = 0
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r9, r0, r8)
            r8 = 1376089394(0x52057532, float:1.43299215E11)
            r0.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 103361330(0x6292b32, float:3.1817102E-35)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.unit.LayoutDirection r11 = (androidx.compose.ui.unit.LayoutDirection) r11
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r9, r10)
            java.lang.Object r9 = r0.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r2 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0293
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0293:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x02a0
            r0.createNode(r10)
            goto L_0x02a3
        L_0x02a0:
            r0.useNode()
        L_0x02a3:
            r0.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m1234constructorimpl(r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r7, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r8, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r11, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m1241setimpl((androidx.compose.runtime.Composer) r10, r9, r7)
            r0.enableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.SkippableUpdater.m1226constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r7 = androidx.compose.runtime.SkippableUpdater.m1225boximpl(r7)
            r8 = 0
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r2.invoke(r7, r0, r9)
            r0.startReplaceableGroup(r1)
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r1 = -755941080(0xffffffffd2f14128, float:-5.18090129E11)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C314@11801L6:ListItem.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            int r1 = r12 >> 3
            r1 = r1 & 14
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.invoke(r0, r1)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x031b:
            r0.endReplaceableGroup()
            r1 = 3
            androidx.compose.ui.unit.Dp[] r1 = new androidx.compose.ui.unit.Dp[r1]
            float r2 = ThreeLineBaselineFirstOffset
            androidx.compose.ui.unit.Dp r7 = androidx.compose.ui.unit.Dp.m3857boximpl(r2)
            r8 = 0
            r1[r8] = r7
            float r7 = ThreeLineBaselineSecondOffset
            androidx.compose.ui.unit.Dp r7 = androidx.compose.ui.unit.Dp.m3857boximpl(r7)
            r8 = 1
            r1[r8] = r7
            float r7 = ThreeLineBaselineThirdOffset
            androidx.compose.ui.unit.Dp r7 = androidx.compose.ui.unit.Dp.m3857boximpl(r7)
            r9 = 2
            r1[r9] = r7
            java.util.List r7 = kotlin.collections.CollectionsKt.listOf(r1)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r21 = r1
            androidx.compose.ui.Modifier r21 = (androidx.compose.ui.Modifier) r21
            r22 = 1065353216(0x3f800000, float:1.0)
            r23 = 0
            r24 = 2
            r25 = 0
            androidx.compose.ui.Modifier r26 = androidx.compose.foundation.layout.RowScope.DefaultImpls.weight$default(r20, r21, r22, r23, r24, r25)
            float r27 = ContentLeftPadding
            r28 = 0
            float r29 = ContentRightPadding
            r30 = 0
            r31 = 10
            r32 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m435paddingqDBjuR0$default(r26, r27, r28, r29, r30, r31, r32)
            r9 = -819902188(0xffffffffcf214914, float:-2.70592102E9)
            androidx.compose.material.ThreeLine$ListItem$1$2 r10 = new androidx.compose.material.ThreeLine$ListItem$1$2
            r10.<init>(r6, r12, r4, r5)
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r9, r8, r10)
            r9 = r8
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r11 = 384(0x180, float:5.38E-43)
            r14 = 0
            r8 = r1
            r10 = r0
            r1 = r12
            r12 = r14
            androidx.compose.material.ListItemKt.BaselinesOffsetColumn(r7, r8, r9, r10, r11, r12)
            if (r13 == 0) goto L_0x03a6
            float r21 = ThreeLineTrailingTopPadding
            float r2 = r2 - r21
            float r7 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r2)
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            r19 = r2
            androidx.compose.ui.Modifier r19 = (androidx.compose.ui.Modifier) r19
            r20 = 0
            float r22 = TrailingRightPadding
            r23 = 0
            r24 = 9
            r25 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.PaddingKt.m435paddingqDBjuR0$default(r19, r20, r21, r22, r23, r24, r25)
            int r1 = r1 >> 9
            r1 = r1 & 896(0x380, float:1.256E-42)
            r11 = r1 | 54
            r12 = 0
            r9 = r39
            r10 = r0
            androidx.compose.material.ListItemKt.m1016OffsetToBaselineOrCenterKz89ssw(r7, r8, r9, r10, r11, r12)
        L_0x03a6:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r2 = r18
        L_0x03ba:
            androidx.compose.runtime.ScopeUpdateScope r10 = r0.endRestartGroup()
            if (r10 != 0) goto L_0x03c1
            goto L_0x03dc
        L_0x03c1:
            androidx.compose.material.ThreeLine$ListItem$2 r11 = new androidx.compose.material.ThreeLine$ListItem$2
            r0 = r11
            r1 = r33
            r3 = r35
            r4 = r36
            r5 = r37
            r6 = r38
            r7 = r39
            r8 = r41
            r9 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r10.updateScope(r11)
        L_0x03dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ThreeLine.ListItem(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    static {
        float f = (float) 16;
        IconLeftPadding = Dp.m3859constructorimpl(f);
        IconThreeLineVerticalPadding = Dp.m3859constructorimpl(f);
        ContentLeftPadding = Dp.m3859constructorimpl(f);
        ContentRightPadding = Dp.m3859constructorimpl(f);
        float f2 = (float) 20;
        ThreeLineBaselineSecondOffset = Dp.m3859constructorimpl(f2);
        ThreeLineBaselineThirdOffset = Dp.m3859constructorimpl(f2);
        ThreeLineTrailingTopPadding = Dp.m3859constructorimpl(f);
        TrailingRightPadding = Dp.m3859constructorimpl(f);
    }
}
