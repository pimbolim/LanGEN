package androidx.compose.foundation.lazy.list;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0018\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J%\u0010\u001b\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R)\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u001e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/foundation/lazy/list/LazyListScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "Landroidx/compose/foundation/lazy/list/DataIndex;", "index", "getIndex-AUyieIw", "()I", "I", "indexState", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "observableIndex", "getObservableIndex", "observableScrollOffset", "getObservableScrollOffset", "scrollOffset", "getScrollOffset", "scrollOffsetState", "requestPosition", "", "requestPosition-NTjDD6g", "update", "update-NTjDD6g", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/list/LazyListMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemsProvider", "Landroidx/compose/foundation/lazy/list/LazyListItemsProvider;", "Companion", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListScrollPosition.kt */
public final class LazyListScrollPosition {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean hadFirstNotEmptyLayout;
    private int index;
    private final MutableState<Integer> indexState;
    private Object lastKnownFirstItemKey;
    private int scrollOffset;
    private final MutableState<Integer> scrollOffsetState;

    public LazyListScrollPosition() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyListScrollPosition(int i, int i2) {
        this.index = DataIndex.m535constructorimpl(i);
        this.scrollOffset = i2;
        this.indexState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(m567getIndexAUyieIw()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scrollOffsetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(this.scrollOffset), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyListScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    /* renamed from: getIndex-AUyieIw  reason: not valid java name */
    public final int m567getIndexAUyieIw() {
        return this.index;
    }

    public final int getScrollOffset() {
        return this.scrollOffset;
    }

    public final int getObservableIndex() {
        return this.indexState.getValue().intValue();
    }

    public final int getObservableScrollOffset() {
        return this.scrollOffsetState.getValue().intValue();
    }

    public final void updateFromMeasureResult(LazyListMeasureResult lazyListMeasureResult) {
        Intrinsics.checkNotNullParameter(lazyListMeasureResult, "measureResult");
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        this.lastKnownFirstItemKey = firstVisibleItem == null ? null : firstVisibleItem.getKey();
        if (this.hadFirstNotEmptyLayout || lazyListMeasureResult.getTotalItemsCount() > 0) {
            boolean z = true;
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleItemScrollOffset = lazyListMeasureResult.getFirstVisibleItemScrollOffset();
            int i = 0;
            if (((float) firstVisibleItemScrollOffset) < 0.0f) {
                z = false;
            }
            if (z) {
                LazyMeasuredItem firstVisibleItem2 = lazyListMeasureResult.getFirstVisibleItem();
                if (firstVisibleItem2 != null) {
                    i = firstVisibleItem2.getIndex();
                }
                m566updateNTjDD6g(DataIndex.m535constructorimpl(i), firstVisibleItemScrollOffset);
                return;
            }
            throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisibleItemScrollOffset + ')').toString());
        }
    }

    /* renamed from: requestPosition-NTjDD6g  reason: not valid java name */
    public final void m568requestPositionNTjDD6g(int i, int i2) {
        m566updateNTjDD6g(i, i2);
        this.lastKnownFirstItemKey = null;
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved(LazyListItemsProvider lazyListItemsProvider) {
        Intrinsics.checkNotNullParameter(lazyListItemsProvider, "itemsProvider");
        m566updateNTjDD6g(Companion.m570findLazyListIndexByKeyM1M1bNc(this.lastKnownFirstItemKey, m567getIndexAUyieIw(), lazyListItemsProvider), this.scrollOffset);
    }

    /* renamed from: update-NTjDD6g  reason: not valid java name */
    private final void m566updateNTjDD6g(int i, int i2) {
        if (((float) i) >= 0.0f) {
            if (!DataIndex.m538equalsimpl0(i, m567getIndexAUyieIw())) {
                this.index = i;
                this.indexState.setValue(Integer.valueOf(i));
            }
            if (i2 != this.scrollOffset) {
                this.scrollOffset = i2;
                this.scrollOffsetState.setValue(Integer.valueOf(i2));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Index should be non-negative (" + i + ')').toString());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/lazy/list/LazyListScrollPosition$Companion;", "", "()V", "findLazyListIndexByKey", "Landroidx/compose/foundation/lazy/list/DataIndex;", "key", "lastKnownIndex", "itemsProvider", "Landroidx/compose/foundation/lazy/list/LazyListItemsProvider;", "findLazyListIndexByKey-M1M1bNc", "(Ljava/lang/Object;ILandroidx/compose/foundation/lazy/list/LazyListItemsProvider;)I", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LazyListScrollPosition.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
            r2 = r4.getKeyToIndexMap().get(r2);
         */
        /* renamed from: findLazyListIndexByKey-M1M1bNc  reason: not valid java name */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int m570findLazyListIndexByKeyM1M1bNc(java.lang.Object r2, int r3, androidx.compose.foundation.lazy.list.LazyListItemsProvider r4) {
            /*
                r1 = this;
                if (r2 != 0) goto L_0x0003
                return r3
            L_0x0003:
                int r0 = r4.getItemsCount()
                if (r3 >= r0) goto L_0x0014
                java.lang.Object r0 = r4.getKey(r3)
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)
                if (r0 == 0) goto L_0x0014
                return r3
            L_0x0014:
                java.util.Map r4 = r4.getKeyToIndexMap()
                java.lang.Object r2 = r4.get(r2)
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0029
                int r2 = r2.intValue()
                int r2 = androidx.compose.foundation.lazy.list.DataIndex.m535constructorimpl(r2)
                return r2
            L_0x0029:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.list.LazyListScrollPosition.Companion.m570findLazyListIndexByKeyM1M1bNc(java.lang.Object, int, androidx.compose.foundation.lazy.list.LazyListItemsProvider):int");
        }
    }
}
