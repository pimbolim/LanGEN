package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a8\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"TextBaselineDistanceFromTitle", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTop", "TextPadding", "Landroidx/compose/ui/Modifier;", "TitleBaselineDistanceFromTop", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
public final class AlertDialogKt {
    /* access modifiers changed from: private */
    public static final long TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
    /* access modifiers changed from: private */
    public static final long TextBaselineDistanceFromTop = TextUnitKt.getSp(38);
    private static final Modifier TextPadding;
    /* access modifiers changed from: private */
    public static final long TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
    private static final Modifier TitlePadding;

    /* JADX WARNING: Code restructure failed: missing block: B:93:0x011c, code lost:
        if ((r38 & 64) != 0) goto L_0x011e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f4  */
    /* renamed from: AlertDialogContent-WMdw5o4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m823AlertDialogContentWMdw5o4(kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.ui.graphics.Shape r31, long r32, long r34, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r1 = r27
            r10 = r37
            java.lang.String r0 = "buttons"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = 1208798579(0x480ccd73, float:144181.8)
            r2 = r36
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(AlertDialogContent)P(1,3,6,5,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color)48@1896L6,49@1954L6,50@1996L32,52@2038L1047:AlertDialog.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r38 & 1
            if (r2 == 0) goto L_0x001e
            r2 = r10 | 6
            goto L_0x002e
        L_0x001e:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x002d
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r10
            goto L_0x002e
        L_0x002d:
            r2 = r10
        L_0x002e:
            r3 = r38 & 2
            if (r3 == 0) goto L_0x0035
            r2 = r2 | 48
            goto L_0x0048
        L_0x0035:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0048
            r4 = r28
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0044
            r5 = 32
            goto L_0x0046
        L_0x0044:
            r5 = 16
        L_0x0046:
            r2 = r2 | r5
            goto L_0x004a
        L_0x0048:
            r4 = r28
        L_0x004a:
            r5 = r38 & 4
            if (r5 == 0) goto L_0x0051
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0064
        L_0x0051:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0064
            r6 = r29
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0060
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0062
        L_0x0060:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0062:
            r2 = r2 | r7
            goto L_0x0066
        L_0x0064:
            r6 = r29
        L_0x0066:
            r7 = r38 & 8
            if (r7 == 0) goto L_0x006d
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0080
        L_0x006d:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0080
            r8 = r30
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007c
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007c:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r2 = r2 | r9
            goto L_0x0082
        L_0x0080:
            r8 = r30
        L_0x0082:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r10
            if (r9 != 0) goto L_0x009d
            r9 = r38 & 16
            if (r9 != 0) goto L_0x0097
            r9 = r31
            boolean r11 = r0.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x0099
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0097:
            r9 = r31
        L_0x0099:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r2 = r2 | r11
            goto L_0x009f
        L_0x009d:
            r9 = r31
        L_0x009f:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r10
            if (r11 != 0) goto L_0x00b9
            r11 = r38 & 32
            if (r11 != 0) goto L_0x00b3
            r11 = r32
            boolean r13 = r0.changed((long) r11)
            if (r13 == 0) goto L_0x00b5
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b3:
            r11 = r32
        L_0x00b5:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r2 = r2 | r13
            goto L_0x00bb
        L_0x00b9:
            r11 = r32
        L_0x00bb:
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00d5
            r13 = r38 & 64
            if (r13 != 0) goto L_0x00cf
            r13 = r34
            boolean r15 = r0.changed((long) r13)
            if (r15 == 0) goto L_0x00d1
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00cf:
            r13 = r34
        L_0x00d1:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d3:
            r2 = r2 | r15
            goto L_0x00d7
        L_0x00d5:
            r13 = r34
        L_0x00d7:
            r15 = 2995931(0x2db6db, float:4.198194E-39)
            r15 = r15 & r2
            r16 = 599186(0x92492, float:8.39638E-40)
            r15 = r15 ^ r16
            if (r15 != 0) goto L_0x00f4
            boolean r15 = r0.getSkipping()
            if (r15 != 0) goto L_0x00e9
            goto L_0x00f4
        L_0x00e9:
            r0.skipToGroupEnd()
            r2 = r4
            r3 = r6
            r4 = r8
            r5 = r9
            r6 = r11
            r8 = r13
            goto L_0x01a5
        L_0x00f4:
            r0.startDefaults()
            r15 = r10 & 1
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r15 == 0) goto L_0x0125
            boolean r15 = r0.getDefaultsInvalid()
            if (r15 == 0) goto L_0x010b
            goto L_0x0125
        L_0x010b:
            r0.skipToGroupEnd()
            r3 = r38 & 16
            if (r3 == 0) goto L_0x0114
            r2 = r2 & r18
        L_0x0114:
            r3 = r38 & 32
            if (r3 == 0) goto L_0x011a
            r2 = r2 & r17
        L_0x011a:
            r3 = r38 & 64
            if (r3 == 0) goto L_0x0120
        L_0x011e:
            r2 = r2 & r16
        L_0x0120:
            r5 = r2
            r2 = r11
            r23 = r13
            goto L_0x0164
        L_0x0125:
            if (r3 == 0) goto L_0x012c
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            r4 = r3
        L_0x012c:
            r3 = 0
            if (r5 == 0) goto L_0x0130
            r6 = r3
        L_0x0130:
            if (r7 == 0) goto L_0x0133
            r8 = r3
        L_0x0133:
            r3 = r38 & 16
            r5 = 6
            if (r3 == 0) goto L_0x0147
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r3 = r3.getShapes(r0, r5)
            androidx.compose.foundation.shape.CornerBasedShape r3 = r3.getMedium()
            androidx.compose.ui.graphics.Shape r3 = (androidx.compose.ui.graphics.Shape) r3
            r2 = r2 & r18
            r9 = r3
        L_0x0147:
            r3 = r38 & 32
            if (r3 == 0) goto L_0x0157
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r3 = r3.getColors(r0, r5)
            long r11 = r3.m918getSurface0d7_KjU()
            r2 = r2 & r17
        L_0x0157:
            r3 = r38 & 64
            if (r3 == 0) goto L_0x0120
            int r3 = r2 >> 15
            r3 = r3 & 14
            long r13 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r11, r0, r3)
            goto L_0x011e
        L_0x0164:
            r0.endDefaults()
            r17 = 0
            r18 = 0
            r7 = -819892496(0xffffffffcf216ef0, float:-2.70840218E9)
            androidx.compose.material.AlertDialogKt$AlertDialogContent$1 r11 = new androidx.compose.material.AlertDialogKt$AlertDialogContent$1
            r11.<init>(r6, r8, r1, r5)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r7, r12, r11)
            r19 = r7
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            r7 = 1572864(0x180000, float:2.204052E-39)
            int r11 = r5 >> 3
            r11 = r11 & 14
            r7 = r7 | r11
            int r5 = r5 >> 9
            r11 = r5 & 112(0x70, float:1.57E-43)
            r7 = r7 | r11
            r11 = r5 & 896(0x380, float:1.256E-42)
            r7 = r7 | r11
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r21 = r7 | r5
            r22 = 48
            r11 = r4
            r12 = r9
            r13 = r2
            r15 = r23
            r20 = r0
            androidx.compose.material.SurfaceKt.m1125SurfaceFjzlyU((androidx.compose.ui.Modifier) r11, (androidx.compose.ui.graphics.Shape) r12, (long) r13, (long) r15, (androidx.compose.foundation.BorderStroke) r17, (float) r18, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22)
            r5 = r9
            r25 = r2
            r2 = r4
            r3 = r6
            r4 = r8
            r8 = r23
            r6 = r25
        L_0x01a5:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x01ac
            goto L_0x01bd
        L_0x01ac:
            androidx.compose.material.AlertDialogKt$AlertDialogContent$2 r13 = new androidx.compose.material.AlertDialogKt$AlertDialogContent$2
            r0 = r13
            r1 = r27
            r10 = r37
            r11 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x01bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt.m823AlertDialogContentWMdw5o4(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void AlertDialogBaselineLayout(ColumnScope columnScope, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, int i) {
        int i2;
        ColumnScope columnScope2 = columnScope;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i3 = i;
        Intrinsics.checkNotNullParameter(columnScope2, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(-1735756929);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogBaselineLayout)P(1)96@3561L3479:AlertDialog.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) columnScope2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function23) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function24) ? 256 : 128;
        }
        if (((i2 & 731) ^ 146) != 0 || !startRestartGroup.getSkipping()) {
            Modifier weight = columnScope2.weight(Modifier.Companion, 1.0f, false);
            MeasurePolicy measurePolicy = AlertDialogKt$AlertDialogBaselineLayout$2.INSTANCE;
            startRestartGroup.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(weight);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r11 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r11, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r11, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r11, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r11, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1160646213);
            ComposerKt.sourceInformation(startRestartGroup, "C*104@3798L103:AlertDialog.kt#jmzs0o");
            startRestartGroup.startReplaceableGroup(-1160646206);
            ComposerKt.sourceInformation(startRestartGroup, "*99@3629L106");
            if (function23 != null) {
                Modifier align = columnScope2.align(LayoutIdKt.layoutId(TitlePadding, MessageBundle.TITLE_ENTRY), Alignment.Companion.getStart());
                startRestartGroup.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1376089394);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density2 = (Density) consume4;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(align);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r7 = Updater.m1234constructorimpl(startRestartGroup);
                Updater.m1241setimpl(r7, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1241setimpl(r7, density2, ComposeUiNode.Companion.getSetDensity());
                Updater.m1241setimpl(r7, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1241setimpl(r7, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-630329100);
                ComposerKt.sourceInformation(startRestartGroup, "C*100@3710L7:AlertDialog.kt#jmzs0o");
                function23.invoke(startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            }
            startRestartGroup.endReplaceableGroup();
            if (function24 != null) {
                Modifier align2 = columnScope2.align(LayoutIdKt.layoutId(TextPadding, "text"), Alignment.Companion.getStart());
                startRestartGroup.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1376089394);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density3 = (Density) consume7;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(align2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r112 = Updater.m1234constructorimpl(startRestartGroup);
                Updater.m1241setimpl(r112, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1241setimpl(r112, density3, ComposeUiNode.Companion.getSetDensity());
                Updater.m1241setimpl(r112, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1241setimpl(r112, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-630328933);
                ComposerKt.sourceInformation(startRestartGroup, "C*105@3877L6:AlertDialog.kt#jmzs0o");
                function24.invoke(startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AlertDialogKt$AlertDialogBaselineLayout$3(columnScope2, function23, function24, i3));
        }
    }

    /* renamed from: AlertDialogFlowRow-ixp7dh8  reason: not valid java name */
    public static final void m824AlertDialogFlowRowixp7dh8(float f, float f2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-489408515);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)192@7298L3452:AlertDialog.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function2) ? 256 : 128;
        }
        if (((i2 & 731) ^ 146) != 0 || !startRestartGroup.getSkipping()) {
            MeasurePolicy alertDialogKt$AlertDialogFlowRow$1 = new AlertDialogKt$AlertDialogFlowRow$1(f, f2);
            startRestartGroup.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            int i3 = ((((i2 >> 6) & 14) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r5 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r5, alertDialogKt$AlertDialogFlowRow$1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r5, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r5, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r5, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i3 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AlertDialogKt$AlertDialogFlowRow$2(f, f2, function2, i));
        }
    }

    static {
        float f = (float) 24;
        TitlePadding = PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, Dp.m3859constructorimpl(f), 0.0f, Dp.m3859constructorimpl(f), 0.0f, 10, (Object) null);
        TextPadding = PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, Dp.m3859constructorimpl(f), 0.0f, Dp.m3859constructorimpl(f), Dp.m3859constructorimpl((float) 28), 2, (Object) null);
    }
}
