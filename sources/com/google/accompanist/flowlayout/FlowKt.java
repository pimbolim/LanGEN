package com.google.accompanist.flowlayout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001ap\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001av\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\b\u0002\u0010\b\u001a\u00060\tj\u0002`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\f\b\u0002\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001av\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\b\u0002\u0010\b\u001a\u00060\tj\u0002`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\f\b\u0002\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0018*\n\u0010\u001b\"\u00020\t2\u00020\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Flow", "", "modifier", "Landroidx/compose/ui/Modifier;", "orientation", "Lcom/google/accompanist/flowlayout/LayoutOrientation;", "mainAxisSize", "Lcom/google/accompanist/flowlayout/SizeMode;", "mainAxisAlignment", "Lcom/google/accompanist/flowlayout/MainAxisAlignment;", "Lcom/google/accompanist/flowlayout/FlowMainAxisAlignment;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Lcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;", "crossAxisSpacing", "lastLineMainAxisAlignment", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Flow-F4y8cZ0", "(Landroidx/compose/ui/Modifier;Lcom/google/accompanist/flowlayout/LayoutOrientation;Lcom/google/accompanist/flowlayout/SizeMode;Lcom/google/accompanist/flowlayout/MainAxisAlignment;FLcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;FLcom/google/accompanist/flowlayout/MainAxisAlignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "FlowColumn", "FlowColumn-07r0xoM", "(Landroidx/compose/ui/Modifier;Lcom/google/accompanist/flowlayout/SizeMode;Lcom/google/accompanist/flowlayout/MainAxisAlignment;FLcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;FLcom/google/accompanist/flowlayout/MainAxisAlignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "FlowRow-07r0xoM", "FlowMainAxisAlignment", "flowlayout_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Flow.kt */
public final class FlowKt {
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0121  */
    /* renamed from: FlowRow-07r0xoM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m4243FlowRow07r0xoM(androidx.compose.ui.Modifier r25, com.google.accompanist.flowlayout.SizeMode r26, com.google.accompanist.flowlayout.MainAxisAlignment r27, float r28, com.google.accompanist.flowlayout.FlowCrossAxisAlignment r29, float r30, com.google.accompanist.flowlayout.MainAxisAlignment r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r11 = r32
            r12 = r34
            r13 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -426773229(0xffffffffe68ff513, float:-3.399096E23)
            r1 = r33
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(FlowRow)P(7,5,4,6:c#ui.unit.Dp,1,2:c#ui.unit.Dp,3)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r0 = r13 & 1
            if (r0 == 0) goto L_0x0023
            r1 = r12 | 6
            r2 = r1
            r1 = r25
            goto L_0x0037
        L_0x0023:
            r1 = r12 & 14
            if (r1 != 0) goto L_0x0034
            r1 = r25
            boolean r2 = r14.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0031
            r2 = 4
            goto L_0x0032
        L_0x0031:
            r2 = 2
        L_0x0032:
            r2 = r2 | r12
            goto L_0x0037
        L_0x0034:
            r1 = r25
            r2 = r12
        L_0x0037:
            r3 = r13 & 2
            if (r3 == 0) goto L_0x003e
            r2 = r2 | 48
            goto L_0x0051
        L_0x003e:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0051
            r4 = r26
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004d
            r5 = 32
            goto L_0x004f
        L_0x004d:
            r5 = 16
        L_0x004f:
            r2 = r2 | r5
            goto L_0x0053
        L_0x0051:
            r4 = r26
        L_0x0053:
            r5 = r13 & 4
            if (r5 == 0) goto L_0x005a
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006d
            r6 = r27
            boolean r7 = r14.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0069
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r7 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r2 = r2 | r7
            goto L_0x006f
        L_0x006d:
            r6 = r27
        L_0x006f:
            r7 = r13 & 8
            if (r7 == 0) goto L_0x0076
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0089
            r8 = r28
            boolean r9 = r14.changed((float) r8)
            if (r9 == 0) goto L_0x0085
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r2 = r2 | r9
            goto L_0x008b
        L_0x0089:
            r8 = r28
        L_0x008b:
            r9 = r13 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0095
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0095:
            r15 = r12 & r10
            if (r15 != 0) goto L_0x00a9
            r15 = r29
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00a4
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a4:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r2 = r2 | r16
            goto L_0x00ab
        L_0x00a9:
            r15 = r29
        L_0x00ab:
            r16 = r13 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b8
            r18 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r18
            r10 = r30
            goto L_0x00cb
        L_0x00b8:
            r18 = r12 & r17
            r10 = r30
            if (r18 != 0) goto L_0x00cb
            boolean r18 = r14.changed((float) r10)
            if (r18 == 0) goto L_0x00c7
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r2 = r2 | r18
        L_0x00cb:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r19 = r12 & r18
            if (r19 != 0) goto L_0x00e5
            r19 = r13 & 64
            r1 = r31
            if (r19 != 0) goto L_0x00e0
            boolean r19 = r14.changed((java.lang.Object) r1)
            if (r19 == 0) goto L_0x00e0
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e2
        L_0x00e0:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00e2:
            r2 = r2 | r19
            goto L_0x00e7
        L_0x00e5:
            r1 = r31
        L_0x00e7:
            r1 = r13 & 128(0x80, float:1.794E-43)
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            if (r1 == 0) goto L_0x00f1
            r1 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00ef:
            r2 = r2 | r1
            goto L_0x0101
        L_0x00f1:
            r1 = r12 & r19
            if (r1 != 0) goto L_0x0101
            boolean r1 = r14.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x00fe
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00fe:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00ef
        L_0x0101:
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r2
            r20 = 4793490(0x492492, float:6.71711E-39)
            r1 = r1 ^ r20
            if (r1 != 0) goto L_0x0121
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x0113
            goto L_0x0121
        L_0x0113:
            r14.skipToGroupEnd()
            r1 = r25
            r7 = r31
            r2 = r4
            r3 = r6
            r4 = r8
            r6 = r10
            r5 = r15
            goto L_0x01c6
        L_0x0121:
            r14.startDefaults()
            r1 = r12 & 1
            r20 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r1 == 0) goto L_0x014a
            boolean r1 = r14.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0132
            goto L_0x014a
        L_0x0132:
            r14.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x013b
            r2 = r2 & r20
        L_0x013b:
            r24 = r31
            r16 = r4
            r20 = r6
            r21 = r8
            r23 = r10
            r22 = r15
            r15 = r25
            goto L_0x018e
        L_0x014a:
            if (r0 == 0) goto L_0x0151
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0153
        L_0x0151:
            r0 = r25
        L_0x0153:
            if (r3 == 0) goto L_0x0158
            com.google.accompanist.flowlayout.SizeMode r1 = com.google.accompanist.flowlayout.SizeMode.Wrap
            goto L_0x0159
        L_0x0158:
            r1 = r4
        L_0x0159:
            if (r5 == 0) goto L_0x015e
            com.google.accompanist.flowlayout.MainAxisAlignment r3 = com.google.accompanist.flowlayout.MainAxisAlignment.Start
            r6 = r3
        L_0x015e:
            r3 = 0
            if (r7 == 0) goto L_0x0167
            float r4 = (float) r3
            float r4 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r4)
            r8 = r4
        L_0x0167:
            if (r9 == 0) goto L_0x016c
            com.google.accompanist.flowlayout.FlowCrossAxisAlignment r4 = com.google.accompanist.flowlayout.FlowCrossAxisAlignment.Start
            r15 = r4
        L_0x016c:
            if (r16 == 0) goto L_0x0174
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r3)
            r10 = r3
        L_0x0174:
            r3 = r13 & 64
            if (r3 == 0) goto L_0x0181
            r2 = r2 & r20
            r16 = r1
            r20 = r6
            r24 = r20
            goto L_0x0187
        L_0x0181:
            r24 = r31
            r16 = r1
            r20 = r6
        L_0x0187:
            r21 = r8
            r23 = r10
            r22 = r15
            r15 = r0
        L_0x018e:
            r14.endDefaults()
            com.google.accompanist.flowlayout.LayoutOrientation r1 = com.google.accompanist.flowlayout.LayoutOrientation.Horizontal
            r0 = r2 & 14
            r0 = r0 | 48
            int r2 = r2 << 3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = r2 & r17
            r0 = r0 | r3
            r3 = r2 & r18
            r0 = r0 | r3
            r3 = r2 & r19
            r0 = r0 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r3
            r10 = r0 | r2
            r0 = r15
            r2 = r16
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r32
            r9 = r14
            m4241FlowF4y8cZ0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = r15
        L_0x01c6:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x01cd
            goto L_0x01de
        L_0x01cd:
            com.google.accompanist.flowlayout.FlowKt$FlowRow$1 r15 = new com.google.accompanist.flowlayout.FlowKt$FlowRow$1
            r0 = r15
            r8 = r32
            r9 = r34
            r10 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x01de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.flowlayout.FlowKt.m4243FlowRow07r0xoM(androidx.compose.ui.Modifier, com.google.accompanist.flowlayout.SizeMode, com.google.accompanist.flowlayout.MainAxisAlignment, float, com.google.accompanist.flowlayout.FlowCrossAxisAlignment, float, com.google.accompanist.flowlayout.MainAxisAlignment, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0121  */
    /* renamed from: FlowColumn-07r0xoM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m4242FlowColumn07r0xoM(androidx.compose.ui.Modifier r25, com.google.accompanist.flowlayout.SizeMode r26, com.google.accompanist.flowlayout.MainAxisAlignment r27, float r28, com.google.accompanist.flowlayout.FlowCrossAxisAlignment r29, float r30, com.google.accompanist.flowlayout.MainAxisAlignment r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r11 = r32
            r12 = r34
            r13 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -1391954975(0xffffffffad0873e1, float:-7.756435E-12)
            r1 = r33
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(FlowColumn)P(7,5,4,6:c#ui.unit.Dp,1,2:c#ui.unit.Dp,3)"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r0 = r13 & 1
            if (r0 == 0) goto L_0x0023
            r1 = r12 | 6
            r2 = r1
            r1 = r25
            goto L_0x0037
        L_0x0023:
            r1 = r12 & 14
            if (r1 != 0) goto L_0x0034
            r1 = r25
            boolean r2 = r14.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0031
            r2 = 4
            goto L_0x0032
        L_0x0031:
            r2 = 2
        L_0x0032:
            r2 = r2 | r12
            goto L_0x0037
        L_0x0034:
            r1 = r25
            r2 = r12
        L_0x0037:
            r3 = r13 & 2
            if (r3 == 0) goto L_0x003e
            r2 = r2 | 48
            goto L_0x0051
        L_0x003e:
            r4 = r12 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0051
            r4 = r26
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004d
            r5 = 32
            goto L_0x004f
        L_0x004d:
            r5 = 16
        L_0x004f:
            r2 = r2 | r5
            goto L_0x0053
        L_0x0051:
            r4 = r26
        L_0x0053:
            r5 = r13 & 4
            if (r5 == 0) goto L_0x005a
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x006d
        L_0x005a:
            r6 = r12 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x006d
            r6 = r27
            boolean r7 = r14.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0069
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x006b
        L_0x0069:
            r7 = 128(0x80, float:1.794E-43)
        L_0x006b:
            r2 = r2 | r7
            goto L_0x006f
        L_0x006d:
            r6 = r27
        L_0x006f:
            r7 = r13 & 8
            if (r7 == 0) goto L_0x0076
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0089
        L_0x0076:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0089
            r8 = r28
            boolean r9 = r14.changed((float) r8)
            if (r9 == 0) goto L_0x0085
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r2 = r2 | r9
            goto L_0x008b
        L_0x0089:
            r8 = r28
        L_0x008b:
            r9 = r13 & 16
            r10 = 57344(0xe000, float:8.0356E-41)
            if (r9 == 0) goto L_0x0095
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a9
        L_0x0095:
            r15 = r12 & r10
            if (r15 != 0) goto L_0x00a9
            r15 = r29
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00a4
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a6
        L_0x00a4:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            r2 = r2 | r16
            goto L_0x00ab
        L_0x00a9:
            r15 = r29
        L_0x00ab:
            r16 = r13 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b8
            r18 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r18
            r10 = r30
            goto L_0x00cb
        L_0x00b8:
            r18 = r12 & r17
            r10 = r30
            if (r18 != 0) goto L_0x00cb
            boolean r18 = r14.changed((float) r10)
            if (r18 == 0) goto L_0x00c7
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c7:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r2 = r2 | r18
        L_0x00cb:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r19 = r12 & r18
            if (r19 != 0) goto L_0x00e5
            r19 = r13 & 64
            r1 = r31
            if (r19 != 0) goto L_0x00e0
            boolean r19 = r14.changed((java.lang.Object) r1)
            if (r19 == 0) goto L_0x00e0
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e2
        L_0x00e0:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00e2:
            r2 = r2 | r19
            goto L_0x00e7
        L_0x00e5:
            r1 = r31
        L_0x00e7:
            r1 = r13 & 128(0x80, float:1.794E-43)
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            if (r1 == 0) goto L_0x00f1
            r1 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00ef:
            r2 = r2 | r1
            goto L_0x0101
        L_0x00f1:
            r1 = r12 & r19
            if (r1 != 0) goto L_0x0101
            boolean r1 = r14.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x00fe
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ef
        L_0x00fe:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00ef
        L_0x0101:
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r2
            r20 = 4793490(0x492492, float:6.71711E-39)
            r1 = r1 ^ r20
            if (r1 != 0) goto L_0x0121
            boolean r1 = r14.getSkipping()
            if (r1 != 0) goto L_0x0113
            goto L_0x0121
        L_0x0113:
            r14.skipToGroupEnd()
            r1 = r25
            r7 = r31
            r2 = r4
            r3 = r6
            r4 = r8
            r6 = r10
            r5 = r15
            goto L_0x01c6
        L_0x0121:
            r14.startDefaults()
            r1 = r12 & 1
            r20 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r1 == 0) goto L_0x014a
            boolean r1 = r14.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0132
            goto L_0x014a
        L_0x0132:
            r14.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x013b
            r2 = r2 & r20
        L_0x013b:
            r24 = r31
            r16 = r4
            r20 = r6
            r21 = r8
            r23 = r10
            r22 = r15
            r15 = r25
            goto L_0x018e
        L_0x014a:
            if (r0 == 0) goto L_0x0151
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0153
        L_0x0151:
            r0 = r25
        L_0x0153:
            if (r3 == 0) goto L_0x0158
            com.google.accompanist.flowlayout.SizeMode r1 = com.google.accompanist.flowlayout.SizeMode.Wrap
            goto L_0x0159
        L_0x0158:
            r1 = r4
        L_0x0159:
            if (r5 == 0) goto L_0x015e
            com.google.accompanist.flowlayout.MainAxisAlignment r3 = com.google.accompanist.flowlayout.MainAxisAlignment.Start
            r6 = r3
        L_0x015e:
            r3 = 0
            if (r7 == 0) goto L_0x0167
            float r4 = (float) r3
            float r4 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r4)
            r8 = r4
        L_0x0167:
            if (r9 == 0) goto L_0x016c
            com.google.accompanist.flowlayout.FlowCrossAxisAlignment r4 = com.google.accompanist.flowlayout.FlowCrossAxisAlignment.Start
            r15 = r4
        L_0x016c:
            if (r16 == 0) goto L_0x0174
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r3)
            r10 = r3
        L_0x0174:
            r3 = r13 & 64
            if (r3 == 0) goto L_0x0181
            r2 = r2 & r20
            r16 = r1
            r20 = r6
            r24 = r20
            goto L_0x0187
        L_0x0181:
            r24 = r31
            r16 = r1
            r20 = r6
        L_0x0187:
            r21 = r8
            r23 = r10
            r22 = r15
            r15 = r0
        L_0x018e:
            r14.endDefaults()
            com.google.accompanist.flowlayout.LayoutOrientation r1 = com.google.accompanist.flowlayout.LayoutOrientation.Vertical
            r0 = r2 & 14
            r0 = r0 | 48
            int r2 = r2 << 3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = r2 & r17
            r0 = r0 | r3
            r3 = r2 & r18
            r0 = r0 | r3
            r3 = r2 & r19
            r0 = r0 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r3
            r10 = r0 | r2
            r0 = r15
            r2 = r16
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r32
            r9 = r14
            m4241FlowF4y8cZ0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = r15
        L_0x01c6:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x01cd
            goto L_0x01de
        L_0x01cd:
            com.google.accompanist.flowlayout.FlowKt$FlowColumn$1 r15 = new com.google.accompanist.flowlayout.FlowKt$FlowColumn$1
            r0 = r15
            r8 = r32
            r9 = r34
            r10 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x01de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.flowlayout.FlowKt.m4242FlowColumn07r0xoM(androidx.compose.ui.Modifier, com.google.accompanist.flowlayout.SizeMode, com.google.accompanist.flowlayout.MainAxisAlignment, float, com.google.accompanist.flowlayout.FlowCrossAxisAlignment, float, com.google.accompanist.flowlayout.MainAxisAlignment, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Flow-F4y8cZ0  reason: not valid java name */
    public static final void m4241FlowF4y8cZ0(Modifier modifier, LayoutOrientation layoutOrientation, SizeMode sizeMode, MainAxisAlignment mainAxisAlignment, float f, FlowCrossAxisAlignment flowCrossAxisAlignment, float f2, MainAxisAlignment mainAxisAlignment2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i3 = i;
        Composer startRestartGroup = composer.startRestartGroup(1107216104);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i3;
        } else {
            Modifier modifier2 = modifier;
            i2 = i3;
        }
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) layoutOrientation) ? 32 : 16;
        } else {
            LayoutOrientation layoutOrientation2 = layoutOrientation;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) sizeMode) ? 256 : 128;
        } else {
            SizeMode sizeMode2 = sizeMode;
        }
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) mainAxisAlignment) ? 2048 : 1024;
        } else {
            MainAxisAlignment mainAxisAlignment3 = mainAxisAlignment;
        }
        if ((57344 & i3) == 0) {
            i2 |= startRestartGroup.changed(f) ? 16384 : 8192;
        } else {
            float f3 = f;
        }
        if ((458752 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) flowCrossAxisAlignment) ? 131072 : 65536;
        } else {
            FlowCrossAxisAlignment flowCrossAxisAlignment2 = flowCrossAxisAlignment;
        }
        if ((3670016 & i3) == 0) {
            i2 |= startRestartGroup.changed(f2) ? 1048576 : 524288;
        } else {
            float f4 = f2;
        }
        MainAxisAlignment mainAxisAlignment4 = mainAxisAlignment2;
        if ((29360128 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) mainAxisAlignment4) ? 8388608 : 4194304;
        }
        if ((234881024 & i3) == 0) {
            i2 |= startRestartGroup.changed((Object) function22) ? 67108864 : 33554432;
        }
        if (((191739611 & i2) ^ 38347922) != 0 || !startRestartGroup.getSkipping()) {
            MeasurePolicy flowKt$Flow$1 = new FlowKt$Flow$1(layoutOrientation, f, sizeMode, f2, mainAxisAlignment, mainAxisAlignment2, flowCrossAxisAlignment);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i4 = (((((i2 << 3) & 112) | ((i2 >> 24) & 14)) << 9) & 7168) | 6;
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
            Composer r3 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r3, flowKt$Flow$1, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r3, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r3, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r3, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i4 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            function22.invoke(startRestartGroup, Integer.valueOf((i4 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FlowKt$Flow$2(modifier, layoutOrientation, sizeMode, mainAxisAlignment, f, flowCrossAxisAlignment, f2, mainAxisAlignment2, function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final int Flow_F4y8cZ0$mainAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    /* access modifiers changed from: private */
    public static final int Flow_F4y8cZ0$crossAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }
}
