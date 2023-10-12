package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ax\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001aØ\u0001\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\f\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2/\u0010)\u001a+\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+¢\u0006\u0002\b.\u0012\u0004\u0012\u00020/0*H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/list/LazyListPositionedItem;", "items", "", "Landroidx/compose/foundation/lazy/list/LazyMeasuredItem;", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "measureLazyList", "Landroidx/compose/foundation/lazy/list/LazyListMeasureResult;", "itemsCount", "itemProvider", "Landroidx/compose/foundation/lazy/list/LazyMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "firstVisibleItemIndex", "Landroidx/compose/foundation/lazy/list/DataIndex;", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "placementAnimator", "Landroidx/compose/foundation/lazy/list/LazyListItemPlacementAnimator;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-wroFCeY", "(ILandroidx/compose/foundation/lazy/list/LazyMeasuredItemProvider;IIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/lazy/list/LazyListItemPlacementAnimator;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/list/LazyListMeasureResult;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListMeasure.kt */
public final class LazyListMeasureKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: androidx.compose.foundation.lazy.list.LazyMeasuredItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measureLazyList-wroFCeY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.list.LazyListMeasureResult m562measureLazyListwroFCeY(int r23, androidx.compose.foundation.lazy.list.LazyMeasuredItemProvider r24, int r25, int r26, int r27, int r28, int r29, float r30, long r31, boolean r33, java.util.List<java.lang.Integer> r34, androidx.compose.foundation.layout.Arrangement.Vertical r35, androidx.compose.foundation.layout.Arrangement.Horizontal r36, boolean r37, androidx.compose.ui.unit.Density r38, androidx.compose.ui.unit.LayoutDirection r39, androidx.compose.foundation.lazy.list.LazyListItemPlacementAnimator r40, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r41) {
        /*
            r0 = r23
            r1 = r24
            r14 = r25
            r15 = r26
            r2 = r31
            r13 = r34
            r12 = r41
            java.lang.String r4 = "itemProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "headerIndexes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r4)
            java.lang.String r4 = "density"
            r11 = r38
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r4)
            java.lang.String r4 = "layoutDirection"
            r10 = r39
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r4)
            java.lang.String r4 = "placementAnimator"
            r9 = r40
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r4)
            java.lang.String r4 = "layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r4)
            r16 = 1
            r8 = 0
            if (r15 < 0) goto L_0x0039
            r4 = 1
            goto L_0x003a
        L_0x0039:
            r4 = 0
        L_0x003a:
            java.lang.String r5 = "Failed requirement."
            if (r4 == 0) goto L_0x02b6
            if (r27 < 0) goto L_0x0042
            r4 = 1
            goto L_0x0043
        L_0x0042:
            r4 = 0
        L_0x0043:
            if (r4 == 0) goto L_0x02ac
            if (r0 > 0) goto L_0x0083
            androidx.compose.foundation.lazy.list.LazyListMeasureResult r0 = new androidx.compose.foundation.lazy.list.LazyListMeasureResult
            r1 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            int r7 = androidx.compose.ui.unit.Constraints.m3805getMinWidthimpl(r31)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            int r2 = androidx.compose.ui.unit.Constraints.m3804getMinHeightimpl(r31)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            androidx.compose.foundation.lazy.list.LazyListMeasureKt$measureLazyList$1 r3 = androidx.compose.foundation.lazy.list.LazyListMeasureKt$measureLazyList$1.INSTANCE
            java.lang.Object r2 = r12.invoke(r7, r2, r3)
            androidx.compose.ui.layout.MeasureResult r2 = (androidx.compose.ui.layout.MeasureResult) r2
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            int r7 = -r15
            r8 = 0
            r28 = r0
            r29 = r1
            r30 = r4
            r31 = r5
            r32 = r6
            r33 = r2
            r34 = r3
            r35 = r7
            r36 = r27
            r37 = r8
            r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37)
            return r0
        L_0x0083:
            r4 = r28
            if (r4 < r0) goto L_0x008f
            int r4 = r0 + -1
            int r4 = androidx.compose.foundation.lazy.list.DataIndex.m535constructorimpl(r4)
            r5 = 0
            goto L_0x0091
        L_0x008f:
            r5 = r29
        L_0x0091:
            int r6 = kotlin.math.MathKt.roundToInt((float) r30)
            int r5 = r5 - r6
            int r7 = androidx.compose.foundation.lazy.list.DataIndex.m535constructorimpl(r8)
            boolean r7 = androidx.compose.foundation.lazy.list.DataIndex.m538equalsimpl0(r4, r7)
            if (r7 == 0) goto L_0x00a4
            if (r5 >= 0) goto L_0x00a4
            int r6 = r6 + r5
            r5 = 0
        L_0x00a4:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            int r5 = r5 - r15
            int r8 = -r15
            r9 = 0
        L_0x00ae:
            if (r5 >= 0) goto L_0x00dc
            r28 = 0
            int r17 = androidx.compose.foundation.lazy.list.DataIndex.m535constructorimpl(r28)
            int r17 = r4 - r17
            if (r17 <= 0) goto L_0x00dc
            int r4 = r4 + -1
            int r4 = androidx.compose.foundation.lazy.list.DataIndex.m535constructorimpl(r4)
            androidx.compose.foundation.lazy.list.LazyMeasuredItem r10 = r1.m571getAndMeasureoA9DU0(r4)
            r29 = r4
            r4 = 0
            r7.add(r4, r10)
            int r4 = r10.getCrossAxisSize()
            int r9 = java.lang.Math.max(r9, r4)
            int r4 = r10.getSizeWithSpacings()
            int r5 = r5 + r4
            r4 = r29
            r10 = r39
            goto L_0x00ae
        L_0x00dc:
            if (r5 >= r8) goto L_0x00e0
            int r6 = r6 + r5
            r5 = r8
        L_0x00e0:
            int r5 = r5 + r15
            int r10 = r14 + r27
            r28 = r4
            r4 = 0
            int r10 = kotlin.ranges.RangesKt.coerceAtLeast((int) r10, (int) r4)
            int r4 = -r5
            r29 = r4
            int r4 = r7.size()
            r20 = r28
            r19 = r29
            r18 = r5
            r5 = 0
        L_0x00f8:
            if (r5 >= r4) goto L_0x0111
            int r21 = r5 + 1
            java.lang.Object r5 = r7.get(r5)
            androidx.compose.foundation.lazy.list.LazyMeasuredItem r5 = (androidx.compose.foundation.lazy.list.LazyMeasuredItem) r5
            int r20 = r20 + 1
            int r20 = androidx.compose.foundation.lazy.list.DataIndex.m535constructorimpl(r20)
            int r5 = r5.getSizeWithSpacings()
            int r19 = r19 + r5
            r5 = r21
            goto L_0x00f8
        L_0x0111:
            r5 = r19
            r4 = r20
        L_0x0115:
            if (r5 <= r10) goto L_0x011d
            boolean r19 = r7.isEmpty()
            if (r19 == 0) goto L_0x015d
        L_0x011d:
            if (r4 >= r0) goto L_0x015d
            r29 = r10
            androidx.compose.foundation.lazy.list.LazyMeasuredItem r10 = r1.m571getAndMeasureoA9DU0(r4)
            int r19 = r10.getSizeWithSpacings()
            int r5 = r5 + r19
            if (r5 > r8) goto L_0x0140
            r19 = r5
            int r5 = r0 + -1
            if (r4 == r5) goto L_0x0142
            int r5 = r4 + 1
            int r5 = androidx.compose.foundation.lazy.list.DataIndex.m535constructorimpl(r5)
            int r10 = r10.getSizeWithSpacings()
            int r18 = r18 - r10
            goto L_0x0150
        L_0x0140:
            r19 = r5
        L_0x0142:
            int r5 = r10.getCrossAxisSize()
            int r5 = java.lang.Math.max(r9, r5)
            r7.add(r10)
            r9 = r5
            r5 = r28
        L_0x0150:
            int r4 = r4 + 1
            int r4 = androidx.compose.foundation.lazy.list.DataIndex.m535constructorimpl(r4)
            r10 = r29
            r28 = r5
            r5 = r19
            goto L_0x0115
        L_0x015d:
            if (r5 >= r14) goto L_0x01a5
            int r4 = r14 - r5
            int r18 = r18 - r4
            int r5 = r5 + r4
            r10 = r28
            r0 = r9
            r9 = r18
        L_0x0169:
            if (r9 >= r15) goto L_0x0197
            r28 = 0
            int r17 = androidx.compose.foundation.lazy.list.DataIndex.m535constructorimpl(r28)
            int r17 = r10 - r17
            if (r17 <= 0) goto L_0x0197
            int r10 = r10 + -1
            int r10 = androidx.compose.foundation.lazy.list.DataIndex.m535constructorimpl(r10)
            r17 = r8
            androidx.compose.foundation.lazy.list.LazyMeasuredItem r8 = r1.m571getAndMeasureoA9DU0(r10)
            r1 = 0
            r7.add(r1, r8)
            int r1 = r8.getCrossAxisSize()
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r8.getSizeWithSpacings()
            int r9 = r9 + r1
            r1 = r24
            r8 = r17
            goto L_0x0169
        L_0x0197:
            r17 = r8
            int r6 = r6 + r4
            if (r9 >= 0) goto L_0x01a2
            int r6 = r6 + r9
            int r5 = r5 + r9
            r1 = r0
            r0 = r5
            r9 = 0
            goto L_0x01ab
        L_0x01a2:
            r1 = r0
            r0 = r5
            goto L_0x01ab
        L_0x01a5:
            r17 = r8
            r0 = r5
            r1 = r9
            r9 = r18
        L_0x01ab:
            int r4 = kotlin.math.MathKt.roundToInt((float) r30)
            int r4 = kotlin.math.MathKt.getSign((int) r4)
            int r5 = kotlin.math.MathKt.getSign((int) r6)
            if (r4 != r5) goto L_0x01ca
            int r4 = kotlin.math.MathKt.roundToInt((float) r30)
            int r4 = java.lang.Math.abs(r4)
            int r5 = java.lang.Math.abs(r6)
            if (r4 < r5) goto L_0x01ca
            float r4 = (float) r6
            r10 = r4
            goto L_0x01cc
        L_0x01ca:
            r10 = r30
        L_0x01cc:
            int r8 = -r9
            java.lang.Object r4 = kotlin.collections.CollectionsKt.first(r7)
            androidx.compose.foundation.lazy.list.LazyMeasuredItem r4 = (androidx.compose.foundation.lazy.list.LazyMeasuredItem) r4
            if (r15 <= 0) goto L_0x020a
            int r5 = r7.size()
            r6 = r4
            r4 = 0
        L_0x01db:
            if (r4 >= r5) goto L_0x0205
            r29 = r1
            int r1 = r4 + 1
            java.lang.Object r18 = r7.get(r4)
            androidx.compose.foundation.lazy.list.LazyMeasuredItem r18 = (androidx.compose.foundation.lazy.list.LazyMeasuredItem) r18
            r30 = r5
            int r5 = r18.getSizeWithSpacings()
            r18 = r6
            if (r5 > r9) goto L_0x020e
            int r6 = kotlin.collections.CollectionsKt.getLastIndex(r7)
            if (r4 == r6) goto L_0x020e
            int r9 = r9 - r5
            java.lang.Object r4 = r7.get(r1)
            r6 = r4
            androidx.compose.foundation.lazy.list.LazyMeasuredItem r6 = (androidx.compose.foundation.lazy.list.LazyMeasuredItem) r6
            r5 = r30
            r4 = r1
            r1 = r29
            goto L_0x01db
        L_0x0205:
            r29 = r1
            r18 = r6
            goto L_0x020e
        L_0x020a:
            r29 = r1
            r18 = r4
        L_0x020e:
            r1 = r9
            if (r33 == 0) goto L_0x0214
            r4 = r29
            goto L_0x0215
        L_0x0214:
            r4 = r0
        L_0x0215:
            int r19 = androidx.compose.ui.unit.ConstraintsKt.m3817constrainWidthK40F9xA(r2, r4)
            if (r33 == 0) goto L_0x021d
            r4 = r0
            goto L_0x021f
        L_0x021d:
            r4 = r29
        L_0x021f:
            int r20 = androidx.compose.ui.unit.ConstraintsKt.m3816constrainHeightK40F9xA(r2, r4)
            r2 = r7
            r3 = r19
            r4 = r20
            r5 = r0
            r6 = r25
            r7 = r8
            r21 = 0
            r8 = r33
            r9 = r35
            r15 = r10
            r10 = r36
            r11 = r37
            r22 = r1
            r1 = r12
            r12 = r38
            r13 = r39
            java.util.List r2 = calculateItemsOffsets(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r3 = r34
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x025f
            r28 = r2
            r29 = r24
            r30 = r34
            r31 = r26
            r32 = r19
            r33 = r20
            androidx.compose.foundation.lazy.list.LazyListPositionedItem r3 = androidx.compose.foundation.lazy.list.LazyListHeadersKt.findOrComposeLazyListHeader(r28, r29, r30, r31, r32, r33)
            goto L_0x0262
        L_0x025f:
            r3 = 0
            androidx.compose.foundation.lazy.list.LazyListPositionedItem r3 = (androidx.compose.foundation.lazy.list.LazyListPositionedItem) r3
        L_0x0262:
            int r4 = (int) r15
            r28 = r40
            r29 = r4
            r30 = r19
            r31 = r20
            r32 = r37
            r33 = r2
            r34 = r24
            r28.onMeasured(r29, r30, r31, r32, r33, r34)
            int r4 = java.lang.Math.min(r0, r14)
            int r4 = r4 + r27
            if (r0 <= r14) goto L_0x027d
            goto L_0x027f
        L_0x027d:
            r16 = 0
        L_0x027f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r20)
            androidx.compose.foundation.lazy.list.LazyListMeasureKt$measureLazyList$3 r6 = new androidx.compose.foundation.lazy.list.LazyListMeasureKt$measureLazyList$3
            r6.<init>(r2, r3)
            java.lang.Object r0 = r1.invoke(r0, r5, r6)
            androidx.compose.ui.layout.MeasureResult r0 = (androidx.compose.ui.layout.MeasureResult) r0
            androidx.compose.foundation.lazy.list.LazyListMeasureResult r1 = new androidx.compose.foundation.lazy.list.LazyListMeasureResult
            r24 = r1
            r25 = r18
            r26 = r22
            r27 = r16
            r28 = r15
            r29 = r0
            r30 = r2
            r31 = r17
            r32 = r4
            r33 = r23
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32, r33)
            return r1
        L_0x02ac:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r5.toString()
            r0.<init>(r1)
            throw r0
        L_0x02b6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r5.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.list.LazyListMeasureKt.m562measureLazyListwroFCeY(int, androidx.compose.foundation.lazy.list.LazyMeasuredItemProvider, int, int, int, int, int, float, long, boolean, java.util.List, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.ui.unit.LayoutDirection, androidx.compose.foundation.lazy.list.LazyListItemPlacementAnimator, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.list.LazyListMeasureResult");
    }

    private static final List<LazyListPositionedItem> calculateItemsOffsets(List<LazyMeasuredItem> list, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LayoutDirection layoutDirection) {
        int i6;
        List<LazyMeasuredItem> list2 = list;
        int i7 = i2;
        Arrangement.Vertical vertical2 = vertical;
        int i8 = i4;
        int i9 = z ? i7 : i;
        boolean z3 = i3 < Math.min(i9, i8);
        if (z3) {
            if (!(i5 == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ArrayList arrayList = new ArrayList(list.size());
        if (z3) {
            int size = list.size();
            int[] iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = list.get(!z2 ? i10 : (size - i10) - 1).getSize();
            }
            int[] iArr2 = new int[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr2[i11] = 0;
            }
            if (!z) {
                Density density2 = density;
                if (horizontal != null) {
                    horizontal.arrange(density, i9, iArr, layoutDirection, iArr2);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else if (vertical2 != null) {
                vertical2.arrange(density, i9, iArr, iArr2);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            int i12 = 0;
            int i13 = 0;
            while (i12 < size) {
                int i14 = iArr2[i12];
                i12++;
                int i15 = i13 + 1;
                if (z2) {
                    i13 = (size - i13) - 1;
                }
                LazyMeasuredItem lazyMeasuredItem = list.get(i13);
                if (z2) {
                    i14 = (i9 - i14) - lazyMeasuredItem.getSize();
                }
                if (z2) {
                    i6 = 0;
                } else {
                    i6 = arrayList.size();
                }
                arrayList.add(i6, lazyMeasuredItem.position(i14, i, i7));
                i13 = i15;
            }
        } else {
            int size2 = list.size();
            int i16 = i5;
            for (int i17 = 0; i17 < size2; i17++) {
                LazyMeasuredItem lazyMeasuredItem2 = list.get(i17);
                arrayList.add(lazyMeasuredItem2.position(i16, i, i7));
                i16 += lazyMeasuredItem2.getSizeWithSpacings();
            }
        }
        return arrayList;
    }
}
