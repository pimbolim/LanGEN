package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0002\u0010\u0011\u001a\u001a\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002\u001a-\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00142\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00190\nH\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"SwipeToDismiss", "", "state", "Landroidx/compose/material/DismissState;", "modifier", "Landroidx/compose/ui/Modifier;", "directions", "", "Landroidx/compose/material/DismissDirection;", "dismissThresholds", "Lkotlin/Function1;", "Landroidx/compose/material/ThresholdConfig;", "background", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dismissContent", "(Landroidx/compose/material/DismissState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "getDismissDirection", "from", "Landroidx/compose/material/DismissValue;", "to", "rememberDismissState", "initialValue", "confirmStateChange", "", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DismissState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwipeToDismiss.kt */
public final class SwipeToDismissKt {
    @ExperimentalMaterialApi
    public static final DismissState rememberDismissState(DismissValue dismissValue, Function1<? super DismissValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1491560617);
        ComposerKt.sourceInformation(composer, "C(rememberDismissState)P(1)151@5327L127:SwipeToDismiss.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            dismissValue = DismissValue.Default;
        }
        Function1 function12 = function1;
        if ((i2 & 2) != 0) {
            function12 = SwipeToDismissKt$rememberDismissState$1.INSTANCE;
        }
        DismissState dismissState = (DismissState) RememberSaveableKt.rememberSaveable(new Object[0], DismissState.Companion.Saver(function12), (String) null, new SwipeToDismissKt$rememberDismissState$2(dismissValue, function12), composer, 72, 4);
        composer.endReplaceableGroup();
        return dismissState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    @androidx.compose.material.ExperimentalMaterialApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SwipeToDismiss(androidx.compose.material.DismissState r22, androidx.compose.ui.Modifier r23, java.util.Set<? extends androidx.compose.material.DismissDirection> r24, kotlin.jvm.functions.Function1<? super androidx.compose.material.DismissDirection, ? extends androidx.compose.material.ThresholdConfig> r25, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r7 = r22
            r8 = r26
            r9 = r27
            r10 = r29
            r11 = r30
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "background"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "dismissContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1831183526(0x6d25a4a6, float:3.2040046E27)
            r1 = r28
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(SwipeToDismiss)P(5,4,1,3)178@6527L1407:SwipeToDismiss.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            r0 = r11 & 1
            r1 = 4
            r2 = 2
            if (r0 == 0) goto L_0x0031
            r0 = r10 | 6
            goto L_0x0041
        L_0x0031:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0040
            boolean r0 = r15.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x003d
            r0 = 4
            goto L_0x003e
        L_0x003d:
            r0 = 2
        L_0x003e:
            r0 = r0 | r10
            goto L_0x0041
        L_0x0040:
            r0 = r10
        L_0x0041:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0048
            r0 = r0 | 48
            goto L_0x005b
        L_0x0048:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x005b
            r4 = r23
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0057
            r5 = 32
            goto L_0x0059
        L_0x0057:
            r5 = 16
        L_0x0059:
            r0 = r0 | r5
            goto L_0x005d
        L_0x005b:
            r4 = r23
        L_0x005d:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0063
            r0 = r0 | 128(0x80, float:1.794E-43)
        L_0x0063:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x006a
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007d
        L_0x006a:
            r12 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r12 != 0) goto L_0x007d
            r12 = r25
            boolean r13 = r15.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0079
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007b
        L_0x0079:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007b:
            r0 = r0 | r13
            goto L_0x007f
        L_0x007d:
            r12 = r25
        L_0x007f:
            r13 = r11 & 16
            if (r13 == 0) goto L_0x0086
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0098
        L_0x0086:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x0098
            boolean r13 = r15.changed((java.lang.Object) r8)
            if (r13 == 0) goto L_0x0095
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r0 = r0 | r13
        L_0x0098:
            r13 = r11 & 32
            if (r13 == 0) goto L_0x00a0
            r13 = 196608(0x30000, float:2.75506E-40)
        L_0x009e:
            r0 = r0 | r13
            goto L_0x00b1
        L_0x00a0:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00b1
            boolean r13 = r15.changed((java.lang.Object) r9)
            if (r13 == 0) goto L_0x00ae
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x009e
        L_0x00ae:
            r13 = 65536(0x10000, float:9.18355E-41)
            goto L_0x009e
        L_0x00b1:
            int r13 = ~r11
            r1 = r1 & r13
            if (r1 != 0) goto L_0x00d1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r0
            r13 = 74898(0x12492, float:1.04954E-40)
            r1 = r1 ^ r13
            if (r1 != 0) goto L_0x00d1
            boolean r1 = r15.getSkipping()
            if (r1 != 0) goto L_0x00c6
            goto L_0x00d1
        L_0x00c6:
            r15.skipToGroupEnd()
            r3 = r24
            r19 = r4
            r4 = r12
            r2 = r15
            goto L_0x015f
        L_0x00d1:
            r15.startDefaults()
            r1 = r10 & 1
            r13 = 1
            if (r1 == 0) goto L_0x00ef
            boolean r1 = r15.getDefaultsInvalid()
            if (r1 == 0) goto L_0x00e0
            goto L_0x00ef
        L_0x00e0:
            r15.skipToGroupEnd()
            if (r5 == 0) goto L_0x00e7
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00e7:
            r20 = r24
            r19 = r4
        L_0x00eb:
            r21 = r12
            r12 = r0
            goto L_0x0120
        L_0x00ef:
            if (r3 == 0) goto L_0x00f6
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00f7
        L_0x00f6:
            r1 = r4
        L_0x00f7:
            if (r5 == 0) goto L_0x010b
            androidx.compose.material.DismissDirection[] r2 = new androidx.compose.material.DismissDirection[r2]
            r3 = 0
            androidx.compose.material.DismissDirection r4 = androidx.compose.material.DismissDirection.EndToStart
            r2[r3] = r4
            androidx.compose.material.DismissDirection r3 = androidx.compose.material.DismissDirection.StartToEnd
            r2[r13] = r3
            java.util.Set r2 = kotlin.collections.SetsKt.setOf(r2)
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x010d
        L_0x010b:
            r2 = r24
        L_0x010d:
            if (r6 == 0) goto L_0x011b
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$1 r3 = androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$1.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r12 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            goto L_0x0120
        L_0x011b:
            r19 = r1
            r20 = r2
            goto L_0x00eb
        L_0x0120:
            r15.endDefaults()
            r16 = 0
            r6 = -819888366(0xffffffffcf217f12, float:-2.70945946E9)
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2 r5 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2
            r0 = r5
            r1 = r20
            r2 = r21
            r3 = r12
            r4 = r22
            r14 = r5
            r5 = r26
            r13 = -819888366(0xffffffffcf217f12, float:-2.70945946E9)
            r6 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r13, r0, r14)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            int r1 = r12 >> 3
            r1 = r1 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r18 = 6
            r12 = r19
            r2 = 0
            r13 = r2
            r14 = r16
            r2 = r15
            r15 = r0
            r16 = r2
            r17 = r1
            androidx.compose.foundation.layout.BoxWithConstraintsKt.BoxWithConstraints(r12, r13, r14, r15, r16, r17, r18)
            r3 = r20
            r4 = r21
        L_0x015f:
            androidx.compose.runtime.ScopeUpdateScope r12 = r2.endRestartGroup()
            if (r12 != 0) goto L_0x0166
            goto L_0x017d
        L_0x0166:
            androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$3 r13 = new androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$3
            r0 = r13
            r1 = r22
            r2 = r19
            r5 = r26
            r6 = r27
            r7 = r29
            r8 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x017d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeToDismissKt.SwipeToDismiss(androidx.compose.material.DismissState, androidx.compose.ui.Modifier, java.util.Set, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final DismissDirection getDismissDirection(DismissValue dismissValue, DismissValue dismissValue2) {
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.Default) {
            return null;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.Default && dismissValue2 == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.Default && dismissValue2 == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.DismissedToEnd && dismissValue2 == DismissValue.Default) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.DismissedToStart && dismissValue2 == DismissValue.Default) {
            return DismissDirection.EndToStart;
        }
        return null;
    }
}
