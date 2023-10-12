package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"MaxItemsToRetainForReuse", "", "LazyLayout", "", "itemsProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutState;", "prefetchPolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchPolicy;", "measurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyMeasurePolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutState;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchPolicy;Landroidx/compose/foundation/lazy/layout/LazyMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
public final class LazyLayoutKt {
    private static final int MaxItemsToRetainForReuse = 2;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyLayout(kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemsProvider> r15, androidx.compose.ui.Modifier r16, androidx.compose.foundation.lazy.layout.LazyLayoutState r17, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchPolicy r18, androidx.compose.foundation.lazy.layout.LazyMeasurePolicy r19, androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r1 = r15
            r5 = r19
            r6 = r21
            java.lang.String r0 = "itemsProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "measurePolicy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 617315508(0x24cb7cb4, float:8.824847E-17)
            r2 = r20
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(LazyLayout)P(!1,2,4,3)32@1176L25,37@1367L33,38@1433L60,43@1626L667:LazyLayout.kt#wow0x6"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            r2 = r22 & 1
            r3 = 2
            if (r2 == 0) goto L_0x0025
            r2 = r6 | 6
            goto L_0x0035
        L_0x0025:
            r2 = r6 & 14
            if (r2 != 0) goto L_0x0034
            boolean r2 = r0.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x0031
            r2 = 4
            goto L_0x0032
        L_0x0031:
            r2 = 2
        L_0x0032:
            r2 = r2 | r6
            goto L_0x0035
        L_0x0034:
            r2 = r6
        L_0x0035:
            r4 = r22 & 2
            if (r4 == 0) goto L_0x003c
            r2 = r2 | 48
            goto L_0x004f
        L_0x003c:
            r7 = r6 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x004f
            r7 = r16
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x004b
            r8 = 32
            goto L_0x004d
        L_0x004b:
            r8 = 16
        L_0x004d:
            r2 = r2 | r8
            goto L_0x0051
        L_0x004f:
            r7 = r16
        L_0x0051:
            r8 = r6 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x006a
            r8 = r22 & 4
            if (r8 != 0) goto L_0x0064
            r8 = r17
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0066
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0064:
            r8 = r17
        L_0x0066:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r2 = r2 | r9
            goto L_0x006c
        L_0x006a:
            r8 = r17
        L_0x006c:
            r9 = r22 & 8
            if (r9 == 0) goto L_0x0073
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0073:
            r10 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0086
            r10 = r18
            boolean r11 = r0.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0082
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r2 = r2 | r11
            goto L_0x0088
        L_0x0086:
            r10 = r18
        L_0x0088:
            r11 = r22 & 16
            if (r11 == 0) goto L_0x008f
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008f:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r6
            if (r11 != 0) goto L_0x00a1
            boolean r11 = r0.changed((java.lang.Object) r5)
            if (r11 == 0) goto L_0x009e
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r2 = r2 | r11
        L_0x00a1:
            r11 = 46811(0xb6db, float:6.5596E-41)
            r11 = r11 & r2
            r11 = r11 ^ 9362(0x2492, float:1.3119E-41)
            if (r11 != 0) goto L_0x00b8
            boolean r11 = r0.getSkipping()
            if (r11 != 0) goto L_0x00b0
            goto L_0x00b8
        L_0x00b0:
            r0.skipToGroupEnd()
            r2 = r7
            r3 = r8
            r4 = r10
            goto L_0x016a
        L_0x00b8:
            r0.startDefaults()
            r11 = r6 & 1
            if (r11 == 0) goto L_0x00d4
            boolean r11 = r0.getDefaultsInvalid()
            if (r11 == 0) goto L_0x00c6
            goto L_0x00d4
        L_0x00c6:
            r0.skipToGroupEnd()
            r4 = r22 & 4
            if (r4 == 0) goto L_0x00cf
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00cf:
            r4 = r7
            r13 = r10
        L_0x00d1:
            r7 = r2
            r2 = r8
            goto L_0x00f0
        L_0x00d4:
            if (r4 == 0) goto L_0x00db
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r4 = (androidx.compose.ui.Modifier) r4
            goto L_0x00dc
        L_0x00db:
            r4 = r7
        L_0x00dc:
            r7 = r22 & 4
            if (r7 == 0) goto L_0x00e8
            r7 = 0
            androidx.compose.foundation.lazy.layout.LazyLayoutState r7 = androidx.compose.foundation.lazy.layout.LazyLayoutStateKt.rememberLazyLayoutState(r0, r7)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r8 = r7
        L_0x00e8:
            if (r9 == 0) goto L_0x00ed
            r7 = 0
            r13 = r7
            goto L_0x00d1
        L_0x00ed:
            r7 = r2
            r2 = r8
            r13 = r10
        L_0x00f0:
            r0.endDefaults()
            r2.setItemsProvider$foundation_release(r15)
            int r8 = r7 >> 6
            r8 = r8 & 14
            androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory r14 = androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactoryKt.rememberItemContentFactory(r2, r0, r8)
            r8 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            java.lang.Object r8 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r8 != r9) goto L_0x011d
            androidx.compose.ui.layout.SubcomposeLayoutState r8 = new androidx.compose.ui.layout.SubcomposeLayoutState
            r8.<init>(r3)
            r0.updateRememberedValue(r8)
        L_0x011d:
            r0.endReplaceableGroup()
            r3 = r8
            androidx.compose.ui.layout.SubcomposeLayoutState r3 = (androidx.compose.ui.layout.SubcomposeLayoutState) r3
            r8 = 617315976(0x24cb7e88, float:8.825157E-17)
            r0.startReplaceableGroup(r8)
            java.lang.String r8 = "*40@1528L86"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r8)
            if (r13 != 0) goto L_0x0131
            goto L_0x014a
        L_0x0131:
            int r8 = r7 >> 9
            r8 = r8 & 14
            r8 = r8 | 512(0x200, float:7.175E-43)
            int r7 = r7 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r7 = r7 | r8
            int r8 = androidx.compose.ui.layout.SubcomposeLayoutState.$stable
            int r8 = r8 << 9
            r12 = r7 | r8
            r7 = r13
            r8 = r2
            r9 = r14
            r10 = r3
            r11 = r0
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(r7, r8, r9, r10, r11, r12)
        L_0x014a:
            r0.endReplaceableGroup()
            androidx.compose.ui.layout.RemeasurementModifier r7 = r2.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r7 = (androidx.compose.ui.Modifier) r7
            androidx.compose.ui.Modifier r8 = r4.then(r7)
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2 r7 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2
            r7.<init>(r14, r2, r5)
            r9 = r7
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            int r11 = androidx.compose.ui.layout.SubcomposeLayoutState.$stable
            r12 = 0
            r7 = r3
            r10 = r0
            androidx.compose.ui.layout.SubcomposeLayoutKt.SubcomposeLayout(r7, r8, r9, r10, r11, r12)
            r3 = r2
            r2 = r4
            r4 = r13
        L_0x016a:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x0171
            goto L_0x0183
        L_0x0171:
            androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3 r9 = new androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3
            r0 = r9
            r1 = r15
            r5 = r19
            r6 = r21
            r7 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.layout.LazyLayoutState, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchPolicy, androidx.compose.foundation.lazy.layout.LazyMeasurePolicy, androidx.compose.runtime.Composer, int, int):void");
    }
}
