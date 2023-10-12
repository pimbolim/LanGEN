package androidx.compose.foundation.lazy.list;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JM\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J;\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J<\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00052\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020*J\u0018\u00104\u001a\u00020*2\u0006\u00105\u001a\u0002002\u0006\u00106\u001a\u00020\fH\u0002J\u001c\u00107\u001a\u00020\u0014*\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b8\u00109R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\t*\u00020\u00148BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Landroidx/compose/foundation/lazy/list/LazyListItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/list/ItemInfo;", "positionedKeys", "", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", "index", "sizeWithSpacings", "averageItemsSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", "fallback", "calculateExpectedOffset-tGxSNXI", "(IIIJZII)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "Landroidx/compose/foundation/lazy/list/LazyListPositionedItem;", "itemProvider", "Landroidx/compose/foundation/lazy/list/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "item", "itemInfo", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListItemPlacementAnimator.kt */
public final class LazyListItemPlacementAnimator {
    private final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap = MapsKt.emptyMap();
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final Set<Object> positionedKeys = new LinkedHashSet();
    private final CoroutineScope scope;
    private int viewportEndItemIndex = -1;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex = -1;
    private int viewportStartItemNotVisiblePartSize;

    public LazyListItemPlacementAnimator(CoroutineScope coroutineScope, boolean z) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.scope = coroutineScope;
        this.isVertical = z;
    }

    /* renamed from: getAnimatedOffset-YT5a7pE  reason: not valid java name */
    public final long m555getAnimatedOffsetYT5a7pE(Object obj, int i, int i2, int i3, long j) {
        Intrinsics.checkNotNullParameter(obj, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null) {
            return j;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i);
        long r11 = placeableInfo.getAnimatedOffset().getValue().m3986unboximpl();
        long r0 = itemInfo.m546getNotAnimatableDeltanOccac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(r11) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(r11) + IntOffset.m3978getYimpl(r0));
        long r02 = placeableInfo.m574getTargetOffsetnOccac();
        long r2 = itemInfo.m546getNotAnimatableDeltanOccac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(r02) + IntOffset.m3977getXimpl(r2), IntOffset.m3978getYimpl(r02) + IntOffset.m3978getYimpl(r2));
        if (placeableInfo.getInProgress() && ((m553getMainAxisgyyYBs(IntOffset2) < i2 && m553getMainAxisgyyYBs(IntOffset) < i2) || (m553getMainAxisgyyYBs(IntOffset2) > i3 && m553getMainAxisgyyYBs(IntOffset) > i3))) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, (Continuation<? super LazyListItemPlacementAnimator$getAnimatedOffset$1>) null), 3, (Object) null);
        }
        return IntOffset;
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.viewportStartItemIndex = -1;
        this.viewportStartItemNotVisiblePartSize = 0;
        this.viewportEndItemIndex = -1;
        this.viewportEndItemNotVisiblePartSize = 0;
    }

    /* renamed from: calculateExpectedOffset-tGxSNXI  reason: not valid java name */
    private final int m552calculateExpectedOffsettGxSNXI(int i, int i2, int i3, long j, boolean z, int i4, int i5) {
        boolean z2 = false;
        int i6 = this.viewportEndItemIndex;
        boolean z3 = z ? i6 > i : i6 < i;
        int i7 = this.viewportStartItemIndex;
        if (z ? i7 < i : i7 > i) {
            z2 = true;
        }
        int i8 = -1;
        if (z3) {
            int i9 = i - this.viewportEndItemIndex;
            if (!z) {
                i8 = 1;
            }
            return i4 + this.viewportEndItemNotVisiblePartSize + (i3 * ((i9 * i8) - 1)) + m553getMainAxisgyyYBs(j);
        } else if (!z2) {
            return i5;
        } else {
            int i10 = this.viewportStartItemIndex - i;
            if (!z) {
                i8 = 1;
            }
            return ((this.viewportStartItemNotVisiblePartSize - i2) - (i3 * ((i10 * i8) - 1))) + m553getMainAxisgyyYBs(j);
        }
    }

    private final void startAnimationsIfNeeded(LazyListPositionedItem lazyListPositionedItem, ItemInfo itemInfo) {
        while (itemInfo.getPlaceables().size() > lazyListPositionedItem.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < lazyListPositionedItem.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long r3 = lazyListPositionedItem.m565getOffsetBjo55l4(size);
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long r6 = itemInfo.m546getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(r3) - IntOffset.m3977getXimpl(r6), IntOffset.m3978getYimpl(r3) - IntOffset.m3978getYimpl(r6)), lazyListPositionedItem.getMainAxisSize(size), (DefaultConstructorMarker) null));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int i = 0;
        int size2 = placeables2.size();
        while (i < size2) {
            int i2 = i + 1;
            PlaceableInfo placeableInfo = placeables2.get(i);
            long r62 = placeableInfo.m574getTargetOffsetnOccac();
            long r8 = itemInfo.m546getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(r62) + IntOffset.m3977getXimpl(r8), IntOffset.m3978getYimpl(r62) + IntOffset.m3978getYimpl(r8));
            long r82 = lazyListPositionedItem.m565getOffsetBjo55l4(i);
            placeableInfo.setSize(lazyListPositionedItem.getMainAxisSize(i));
            FiniteAnimationSpec<IntOffset> animationSpec = lazyListPositionedItem.getAnimationSpec(i);
            if (!IntOffset.m3976equalsimpl0(IntOffset, r82)) {
                long r63 = itemInfo.m546getNotAnimatableDeltanOccac();
                placeableInfo.m575setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(r82) - IntOffset.m3977getXimpl(r63), IntOffset.m3978getYimpl(r82) - IntOffset.m3978getYimpl(r63)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, (Continuation<? super LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1>) null), 3, (Object) null);
                }
            }
            i = i2;
        }
    }

    /* renamed from: toOffset-Bjo55l4  reason: not valid java name */
    private final long m554toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m553getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m3978getYimpl(j) : IntOffset.m3977getXimpl(j);
    }

    public final void onMeasured(int i, int i2, int i3, boolean z, List<LazyListPositionedItem> list, LazyMeasuredItemProvider lazyMeasuredItemProvider) {
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        ItemInfo itemInfo;
        LazyListPositionedItem lazyListPositionedItem;
        long j;
        int i5;
        long j2;
        int i6;
        List<LazyListPositionedItem> list2 = list;
        LazyMeasuredItemProvider lazyMeasuredItemProvider2 = lazyMeasuredItemProvider;
        Intrinsics.checkNotNullParameter(list2, "positionedItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider2, "itemProvider");
        int size = list.size();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                z2 = false;
                break;
            }
            int i9 = i8 + 1;
            if (list2.get(i8).getHasAnimations()) {
                z2 = true;
                break;
            }
            i8 = i9;
        }
        if (!z2) {
            reset();
            return;
        }
        int i10 = this.isVertical ? i3 : i2;
        int i11 = i;
        if (z) {
            i11 = -i11;
        }
        long r15 = m554toOffsetBjo55l4(i11);
        LazyListPositionedItem lazyListPositionedItem2 = (LazyListPositionedItem) CollectionsKt.first(list);
        LazyListPositionedItem lazyListPositionedItem3 = (LazyListPositionedItem) CollectionsKt.last(list);
        int size2 = list.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size2) {
            int i14 = i12 + 1;
            LazyListPositionedItem lazyListPositionedItem4 = list2.get(i12);
            ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyListPositionedItem4.getKey());
            if (itemInfo2 != null) {
                itemInfo2.setIndex(lazyListPositionedItem4.getIndex());
            }
            i13 += lazyListPositionedItem4.getSizeWithSpacings();
            i12 = i14;
        }
        int size3 = i13 / list.size();
        this.positionedKeys.clear();
        int size4 = list.size();
        int i15 = 0;
        while (i15 < size4) {
            int i16 = i15 + 1;
            LazyListPositionedItem lazyListPositionedItem5 = list2.get(i15);
            this.positionedKeys.add(lazyListPositionedItem5.getKey());
            ItemInfo itemInfo3 = this.keyToItemInfoMap.get(lazyListPositionedItem5.getKey());
            if (itemInfo3 != null) {
                LazyListPositionedItem lazyListPositionedItem6 = lazyListPositionedItem5;
                i4 = size4;
                if (lazyListPositionedItem6.getHasAnimations()) {
                    long r1 = itemInfo3.m546getNotAnimatableDeltanOccac();
                    itemInfo3.m547setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(r1) + IntOffset.m3977getXimpl(r15), IntOffset.m3978getYimpl(r1) + IntOffset.m3978getYimpl(r15)));
                    startAnimationsIfNeeded(lazyListPositionedItem6, itemInfo3);
                } else {
                    this.keyToItemInfoMap.remove(lazyListPositionedItem6.getKey());
                }
            } else if (lazyListPositionedItem5.getHasAnimations()) {
                ItemInfo itemInfo4 = new ItemInfo(lazyListPositionedItem5.getIndex());
                Integer num = this.keyToIndexMap.get(lazyListPositionedItem5.getKey());
                long r4 = lazyListPositionedItem5.m565getOffsetBjo55l4(i7);
                int mainAxisSize = lazyListPositionedItem5.getMainAxisSize(i7);
                if (num == null) {
                    i5 = m553getMainAxisgyyYBs(r4);
                    j = r4;
                    itemInfo = itemInfo4;
                    lazyListPositionedItem = lazyListPositionedItem5;
                    i4 = size4;
                } else {
                    if (!z) {
                        i6 = m553getMainAxisgyyYBs(r4);
                    } else {
                        i6 = (m553getMainAxisgyyYBs(r4) - lazyListPositionedItem5.getSizeWithSpacings()) + mainAxisSize;
                    }
                    j = r4;
                    itemInfo = itemInfo4;
                    lazyListPositionedItem = lazyListPositionedItem5;
                    i4 = size4;
                    i5 = m552calculateExpectedOffsettGxSNXI(num.intValue(), lazyListPositionedItem5.getSizeWithSpacings(), size3, r15, z, i10, i6) + (z ? lazyListPositionedItem.getSize() - mainAxisSize : 0);
                }
                if (this.isVertical) {
                    j2 = IntOffset.m3973copyiSbpLlY$default(j, 0, i5, 1, (Object) null);
                } else {
                    j2 = IntOffset.m3973copyiSbpLlY$default(j, i5, 0, 2, (Object) null);
                }
                int placeablesCount = lazyListPositionedItem.getPlaceablesCount();
                int i17 = 0;
                while (i17 < placeablesCount) {
                    int i18 = i17 + 1;
                    LazyListPositionedItem lazyListPositionedItem7 = lazyListPositionedItem;
                    long r6 = lazyListPositionedItem7.m565getOffsetBjo55l4(i17);
                    long IntOffset = IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(r6) - IntOffset.m3977getXimpl(j), IntOffset.m3978getYimpl(r6) - IntOffset.m3978getYimpl(j));
                    itemInfo.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(j2) + IntOffset.m3977getXimpl(IntOffset), IntOffset.m3978getYimpl(j2) + IntOffset.m3978getYimpl(IntOffset)), lazyListPositionedItem7.getMainAxisSize(i17), (DefaultConstructorMarker) null));
                    Unit unit = Unit.INSTANCE;
                    i17 = i18;
                }
                LazyListPositionedItem lazyListPositionedItem8 = lazyListPositionedItem;
                ItemInfo itemInfo5 = itemInfo;
                this.keyToItemInfoMap.put(lazyListPositionedItem8.getKey(), itemInfo5);
                startAnimationsIfNeeded(lazyListPositionedItem8, itemInfo5);
            } else {
                i4 = size4;
            }
            i15 = i16;
            size4 = i4;
            i7 = 0;
        }
        if (!z) {
            this.viewportStartItemIndex = lazyListPositionedItem2.getIndex();
            this.viewportStartItemNotVisiblePartSize = lazyListPositionedItem2.getOffset();
            this.viewportEndItemIndex = lazyListPositionedItem3.getIndex();
            this.viewportEndItemNotVisiblePartSize = (lazyListPositionedItem3.getOffset() + lazyListPositionedItem3.getSizeWithSpacings()) - i10;
        } else {
            this.viewportStartItemIndex = lazyListPositionedItem3.getIndex();
            this.viewportStartItemNotVisiblePartSize = (i10 - lazyListPositionedItem3.getOffset()) - lazyListPositionedItem3.getSize();
            this.viewportEndItemIndex = lazyListPositionedItem2.getIndex();
            this.viewportEndItemNotVisiblePartSize = (-lazyListPositionedItem2.getOffset()) + (lazyListPositionedItem2.getSizeWithSpacings() - lazyListPositionedItem2.getSize());
        }
        Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!this.positionedKeys.contains(next.getKey())) {
                ItemInfo itemInfo6 = (ItemInfo) next.getValue();
                long r12 = itemInfo6.m546getNotAnimatableDeltanOccac();
                itemInfo6.m547setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(r12) + IntOffset.m3977getXimpl(r15), IntOffset.m3978getYimpl(r12) + IntOffset.m3978getYimpl(r15)));
                Integer num2 = lazyMeasuredItemProvider.getKeyToIndexMap().get(next.getKey());
                List<PlaceableInfo> placeables = itemInfo6.getPlaceables();
                int size5 = placeables.size();
                int i19 = 0;
                while (true) {
                    if (i19 >= size5) {
                        z3 = false;
                        break;
                    }
                    int i20 = i19 + 1;
                    PlaceableInfo placeableInfo = placeables.get(i19);
                    long r5 = placeableInfo.m574getTargetOffsetnOccac();
                    long r7 = itemInfo6.m546getNotAnimatableDeltanOccac();
                    List<PlaceableInfo> list3 = placeables;
                    long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(r5) + IntOffset.m3977getXimpl(r7), IntOffset.m3978getYimpl(r5) + IntOffset.m3978getYimpl(r7));
                    if (m553getMainAxisgyyYBs(IntOffset2) + placeableInfo.getSize() > 0 && m553getMainAxisgyyYBs(IntOffset2) < i10) {
                        z3 = true;
                        break;
                    } else {
                        placeables = list3;
                        i19 = i20;
                    }
                }
                List<PlaceableInfo> placeables2 = itemInfo6.getPlaceables();
                int size6 = placeables2.size();
                int i21 = 0;
                while (true) {
                    if (i21 >= size6) {
                        z4 = false;
                        break;
                    }
                    int i22 = i21 + 1;
                    if (placeables2.get(i21).getInProgress()) {
                        z4 = true;
                        break;
                    }
                    i21 = i22;
                }
                boolean z5 = !z4;
                if ((z3 || !z5) && num2 != null && !itemInfo6.getPlaceables().isEmpty()) {
                    LazyMeasuredItem r8 = lazyMeasuredItemProvider2.m571getAndMeasureoA9DU0(DataIndex.m535constructorimpl(num2.intValue()));
                    LazyMeasuredItem lazyMeasuredItem = r8;
                    int r0 = m552calculateExpectedOffsettGxSNXI(num2.intValue(), r8.getSizeWithSpacings(), size3, r15, z, i10, i10);
                    if (z) {
                        r0 = (i10 - r0) - lazyMeasuredItem.getSize();
                    }
                    LazyListPositionedItem position = lazyMeasuredItem.position(r0, i2, i3);
                    list2.add(position);
                    startAnimationsIfNeeded(position, itemInfo6);
                } else {
                    int i23 = i2;
                    int i24 = i3;
                    it.remove();
                }
            } else {
                int i25 = i2;
                int i26 = i3;
            }
        }
        this.keyToIndexMap = lazyMeasuredItemProvider.getKeyToIndexMap();
    }
}
