package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00012.\b\u0002\u0010\u0010\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0002\b\u00172\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0001\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2.\b\u0002\u0010\u0010\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u00172\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0002\b\u00172\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u0019¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabRow.kt */
public final class TabRowKt {
    /* access modifiers changed from: private */
    public static final float ScrollableTabRowMinimumTabWidth = Dp.m3859constructorimpl((float) 90);
    /* access modifiers changed from: private */
    public static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:111:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f5  */
    /* renamed from: TabRow-pAZo6Ak  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1160TabRowpAZo6Ak(int r25, androidx.compose.ui.Modifier r26, long r27, long r29, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r1 = r25
            r9 = r33
            r10 = r35
            java.lang.String r0 = "tabs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 2076459359(0x7bc4415f, float:2.0380321E36)
            r2 = r34
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)133@6623L6,134@6672L32,145@7063L1518:TabRow.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0021
            r2 = r10 | 6
            goto L_0x0031
        L_0x0021:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x0030
            boolean r2 = r0.changed((int) r1)
            if (r2 == 0) goto L_0x002d
            r2 = 4
            goto L_0x002e
        L_0x002d:
            r2 = 2
        L_0x002e:
            r2 = r2 | r10
            goto L_0x0031
        L_0x0030:
            r2 = r10
        L_0x0031:
            r3 = r36 & 2
            if (r3 == 0) goto L_0x0038
            r2 = r2 | 48
            goto L_0x004b
        L_0x0038:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004b
            r4 = r26
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0047
            r5 = 32
            goto L_0x0049
        L_0x0047:
            r5 = 16
        L_0x0049:
            r2 = r2 | r5
            goto L_0x004d
        L_0x004b:
            r4 = r26
        L_0x004d:
            r5 = r10 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0066
            r5 = r36 & 4
            if (r5 != 0) goto L_0x0060
            r5 = r27
            boolean r7 = r0.changed((long) r5)
            if (r7 == 0) goto L_0x0062
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0064
        L_0x0060:
            r5 = r27
        L_0x0062:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0064:
            r2 = r2 | r7
            goto L_0x0068
        L_0x0066:
            r5 = r27
        L_0x0068:
            r7 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0081
            r7 = r36 & 8
            if (r7 != 0) goto L_0x007b
            r7 = r29
            boolean r11 = r0.changed((long) r7)
            if (r11 == 0) goto L_0x007d
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007b:
            r7 = r29
        L_0x007d:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r2 = r2 | r11
            goto L_0x0083
        L_0x0081:
            r7 = r29
        L_0x0083:
            r11 = r36 & 16
            if (r11 == 0) goto L_0x008a
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008a:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r10
            if (r12 != 0) goto L_0x009f
            r12 = r31
            boolean r13 = r0.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x009b
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r2 = r2 | r13
            goto L_0x00a1
        L_0x009f:
            r12 = r31
        L_0x00a1:
            r13 = r36 & 32
            if (r13 == 0) goto L_0x00a9
            r14 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r14
            goto L_0x00bd
        L_0x00a9:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r10
            if (r14 != 0) goto L_0x00bd
            r14 = r32
            boolean r15 = r0.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b9
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bb
        L_0x00b9:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00bb:
            r2 = r2 | r15
            goto L_0x00bf
        L_0x00bd:
            r14 = r32
        L_0x00bf:
            r15 = r36 & 64
            r16 = 1572864(0x180000, float:2.204052E-39)
            if (r15 == 0) goto L_0x00c8
            r2 = r2 | r16
            goto L_0x00d9
        L_0x00c8:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00d9
            boolean r15 = r0.changed((java.lang.Object) r9)
            if (r15 == 0) goto L_0x00d6
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r2 = r2 | r15
        L_0x00d9:
            r15 = 2995931(0x2db6db, float:4.198194E-39)
            r15 = r15 & r2
            r17 = 599186(0x92492, float:8.39638E-40)
            r15 = r15 ^ r17
            if (r15 != 0) goto L_0x00f5
            boolean r15 = r0.getSkipping()
            if (r15 != 0) goto L_0x00eb
            goto L_0x00f5
        L_0x00eb:
            r0.skipToGroupEnd()
            r2 = r4
            r3 = r5
            r5 = r7
            r7 = r12
            r8 = r14
            goto L_0x019b
        L_0x00f5:
            r0.startDefaults()
            r15 = r10 & 1
            r4 = 1
            if (r15 == 0) goto L_0x0119
            boolean r15 = r0.getDefaultsInvalid()
            if (r15 == 0) goto L_0x0104
            goto L_0x0119
        L_0x0104:
            r0.skipToGroupEnd()
            r3 = r36 & 4
            if (r3 == 0) goto L_0x010d
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x010d:
            r3 = r36 & 8
            if (r3 == 0) goto L_0x0113
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0113:
            r3 = r26
            r11 = r2
            r2 = r12
            r15 = r14
            goto L_0x0163
        L_0x0119:
            if (r3 == 0) goto L_0x0120
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0122
        L_0x0120:
            r3 = r26
        L_0x0122:
            r15 = r36 & 4
            if (r15 == 0) goto L_0x0133
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            r6 = 6
            androidx.compose.material.Colors r5 = r5.getColors(r0, r6)
            long r5 = androidx.compose.material.ColorsKt.getPrimarySurface(r5)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0133:
            r15 = r36 & 8
            if (r15 == 0) goto L_0x0141
            int r7 = r2 >> 6
            r7 = r7 & 14
            long r7 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r5, r0, r7)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0141:
            if (r11 == 0) goto L_0x0152
            r11 = -819889141(0xffffffffcf217c0b, float:-2.70926106E9)
            androidx.compose.material.TabRowKt$TabRow$1 r12 = new androidx.compose.material.TabRowKt$TabRow$1
            r12.<init>(r1)
            androidx.compose.runtime.internal.ComposableLambda r11 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r11, r4, r12)
            kotlin.jvm.functions.Function3 r11 = (kotlin.jvm.functions.Function3) r11
            goto L_0x0153
        L_0x0152:
            r11 = r12
        L_0x0153:
            if (r13 == 0) goto L_0x015d
            androidx.compose.material.ComposableSingletons$TabRowKt r12 = androidx.compose.material.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r12 = r12.m945getLambda1$material_release()
            r15 = r12
            goto L_0x015e
        L_0x015d:
            r15 = r14
        L_0x015e:
            r23 = r11
            r11 = r2
            r2 = r23
        L_0x0163:
            r0.endDefaults()
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r3)
            r17 = 0
            r18 = 0
            r14 = -819889516(0xffffffffcf217a94, float:-2.70916506E9)
            androidx.compose.material.TabRowKt$TabRow$2 r13 = new androidx.compose.material.TabRowKt$TabRow$2
            r13.<init>(r9, r15, r2, r11)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r14, r4, r13)
            r19 = r4
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            r4 = r11 & 896(0x380, float:1.256E-42)
            r4 = r4 | r16
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r21 = r4 | r11
            r22 = 50
            r11 = r12
            r4 = 0
            r12 = r4
            r13 = r5
            r4 = r15
            r15 = r7
            r20 = r0
            androidx.compose.material.SurfaceKt.m1125SurfaceFjzlyU((androidx.compose.ui.Modifier) r11, (androidx.compose.ui.graphics.Shape) r12, (long) r13, (long) r15, (androidx.compose.foundation.BorderStroke) r17, (float) r18, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r19, (androidx.compose.runtime.Composer) r20, (int) r21, (int) r22)
            r23 = r7
            r7 = r2
            r2 = r3
            r8 = r4
            r3 = r5
            r5 = r23
        L_0x019b:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x01a2
            goto L_0x01b5
        L_0x01a2:
            androidx.compose.material.TabRowKt$TabRow$3 r13 = new androidx.compose.material.TabRowKt$TabRow$3
            r0 = r13
            r1 = r25
            r9 = r33
            r10 = r35
            r11 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x01b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabRowKt.m1160TabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011a  */
    /* renamed from: ScrollableTabRow-sKfQg0A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1159ScrollableTabRowsKfQg0A(int r28, androidx.compose.ui.Modifier r29, long r30, long r32, float r34, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r1 = r28
            r10 = r37
            r11 = r39
            r12 = r40
            java.lang.String r0 = "tabs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -249832714(0xfffffffff11bdaf6, float:-7.7175814E29)
            r2 = r38
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)224@11175L6,225@11224L32,237@11677L3026:TabRow.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0023
            r2 = r11 | 6
            goto L_0x0033
        L_0x0023:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0032
            boolean r2 = r0.changed((int) r1)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r2 = r2 | r11
            goto L_0x0033
        L_0x0032:
            r2 = r11
        L_0x0033:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x003a
            r2 = r2 | 48
            goto L_0x004d
        L_0x003a:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x004d
            r4 = r29
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0049
            r5 = 32
            goto L_0x004b
        L_0x0049:
            r5 = 16
        L_0x004b:
            r2 = r2 | r5
            goto L_0x004f
        L_0x004d:
            r4 = r29
        L_0x004f:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0068
            r5 = r12 & 4
            if (r5 != 0) goto L_0x0062
            r5 = r30
            boolean r7 = r0.changed((long) r5)
            if (r7 == 0) goto L_0x0064
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0062:
            r5 = r30
        L_0x0064:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r2 = r2 | r7
            goto L_0x006a
        L_0x0068:
            r5 = r30
        L_0x006a:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0083
            r7 = r12 & 8
            if (r7 != 0) goto L_0x007d
            r7 = r32
            boolean r9 = r0.changed((long) r7)
            if (r9 == 0) goto L_0x007f
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007d:
            r7 = r32
        L_0x007f:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r2 = r2 | r9
            goto L_0x0085
        L_0x0083:
            r7 = r32
        L_0x0085:
            r9 = r12 & 16
            if (r9 == 0) goto L_0x008c
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008c:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00a1
            r13 = r34
            boolean r14 = r0.changed((float) r13)
            if (r14 == 0) goto L_0x009d
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r2 = r2 | r14
            goto L_0x00a3
        L_0x00a1:
            r13 = r34
        L_0x00a3:
            r14 = r12 & 32
            if (r14 == 0) goto L_0x00ab
            r15 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r15
            goto L_0x00c0
        L_0x00ab:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r11
            if (r15 != 0) goto L_0x00c0
            r15 = r35
            boolean r16 = r0.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00bb
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r2 = r2 | r16
            goto L_0x00c2
        L_0x00c0:
            r15 = r35
        L_0x00c2:
            r16 = r12 & 64
            r17 = 1572864(0x180000, float:2.204052E-39)
            if (r16 == 0) goto L_0x00cd
            r2 = r2 | r17
            r4 = r36
            goto L_0x00e2
        L_0x00cd:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r11 & r18
            r4 = r36
            if (r18 != 0) goto L_0x00e2
            boolean r18 = r0.changed((java.lang.Object) r4)
            if (r18 == 0) goto L_0x00de
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00de:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r2 = r2 | r18
        L_0x00e2:
            r4 = r12 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00ea
            r4 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00e8:
            r2 = r2 | r4
            goto L_0x00fb
        L_0x00ea:
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r4 = r4 & r11
            if (r4 != 0) goto L_0x00fb
            boolean r4 = r0.changed((java.lang.Object) r10)
            if (r4 == 0) goto L_0x00f8
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e8
        L_0x00f8:
            r4 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00e8
        L_0x00fb:
            r4 = 23967451(0x16db6db, float:4.3661218E-38)
            r4 = r4 & r2
            r18 = 4793490(0x492492, float:6.71711E-39)
            r4 = r4 ^ r18
            if (r4 != 0) goto L_0x011a
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x010d
            goto L_0x011a
        L_0x010d:
            r0.skipToGroupEnd()
            r2 = r29
            r9 = r36
            r3 = r5
            r5 = r7
            r7 = r13
            r8 = r15
            goto L_0x01e4
        L_0x011a:
            r0.startDefaults()
            r4 = r11 & 1
            if (r4 == 0) goto L_0x0141
            boolean r4 = r0.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0128
            goto L_0x0141
        L_0x0128:
            r0.skipToGroupEnd()
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0131
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0131:
            r3 = r12 & 8
            if (r3 == 0) goto L_0x0137
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0137:
            r3 = r29
            r5 = r30
            r4 = r13
            r9 = r15
        L_0x013d:
            r13 = r2
            r2 = r36
            goto L_0x0198
        L_0x0141:
            if (r3 == 0) goto L_0x0148
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x014a
        L_0x0148:
            r3 = r29
        L_0x014a:
            r4 = r12 & 4
            if (r4 == 0) goto L_0x015e
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            r6 = 6
            androidx.compose.material.Colors r4 = r4.getColors(r0, r6)
            long r18 = androidx.compose.material.ColorsKt.getPrimarySurface(r4)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r5 = r18
            goto L_0x0160
        L_0x015e:
            r5 = r30
        L_0x0160:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x016e
            int r4 = r2 >> 6
            r4 = r4 & 14
            long r7 = androidx.compose.material.ColorsKt.m932contentColorForek8zF_U(r5, r0, r4)
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x016e:
            if (r9 == 0) goto L_0x0177
            androidx.compose.material.TabRowDefaults r4 = androidx.compose.material.TabRowDefaults.INSTANCE
            float r4 = r4.m1156getScrollableTabRowPaddingD9Ej5fM()
            goto L_0x0178
        L_0x0177:
            r4 = r13
        L_0x0178:
            if (r14 == 0) goto L_0x018a
            r9 = -819901947(0xffffffffcf214a05, float:-2.70598272E9)
            androidx.compose.material.TabRowKt$ScrollableTabRow$1 r13 = new androidx.compose.material.TabRowKt$ScrollableTabRow$1
            r13.<init>(r1)
            r14 = 1
            androidx.compose.runtime.internal.ComposableLambda r9 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r9, r14, r13)
            kotlin.jvm.functions.Function3 r9 = (kotlin.jvm.functions.Function3) r9
            goto L_0x018b
        L_0x018a:
            r9 = r15
        L_0x018b:
            if (r16 == 0) goto L_0x013d
            androidx.compose.material.ComposableSingletons$TabRowKt r13 = androidx.compose.material.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r13 = r13.m946getLambda2$material_release()
            r25 = r13
            r13 = r2
            r2 = r25
        L_0x0198:
            r0.endDefaults()
            r19 = 0
            r20 = 0
            r15 = -819902336(0xffffffffcf214880, float:-2.70588314E9)
            androidx.compose.material.TabRowKt$ScrollableTabRow$2 r14 = new androidx.compose.material.TabRowKt$ScrollableTabRow$2
            r29 = r14
            r30 = r4
            r31 = r37
            r32 = r2
            r33 = r28
            r34 = r9
            r35 = r13
            r29.<init>(r30, r31, r32, r33, r34, r35)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r15, r1, r14)
            r21 = r1
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
            int r1 = r13 >> 3
            r1 = r1 & 14
            r1 = r1 | r17
            r14 = r13 & 896(0x380, float:1.256E-42)
            r1 = r1 | r14
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r23 = r1 | r13
            r24 = 50
            r13 = r3
            r1 = 0
            r14 = r1
            r15 = r5
            r17 = r7
            r22 = r0
            androidx.compose.material.SurfaceKt.m1125SurfaceFjzlyU((androidx.compose.ui.Modifier) r13, (androidx.compose.ui.graphics.Shape) r14, (long) r15, (long) r17, (androidx.compose.foundation.BorderStroke) r19, (float) r20, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r21, (androidx.compose.runtime.Composer) r22, (int) r23, (int) r24)
            r25 = r9
            r9 = r2
            r2 = r3
            r26 = r7
            r7 = r4
            r3 = r5
            r5 = r26
            r8 = r25
        L_0x01e4:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 != 0) goto L_0x01eb
            goto L_0x01fe
        L_0x01eb:
            androidx.compose.material.TabRowKt$ScrollableTabRow$3 r14 = new androidx.compose.material.TabRowKt$ScrollableTabRow$3
            r0 = r14
            r1 = r28
            r10 = r37
            r11 = r39
            r12 = r40
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x01fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabRowKt.m1159ScrollableTabRowsKfQg0A(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
