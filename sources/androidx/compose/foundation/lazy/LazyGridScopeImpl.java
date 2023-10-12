package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.list.IntervalHolder;
import androidx.compose.foundation.lazy.list.IntervalListKt;
import androidx.compose.foundation.lazy.list.MutableIntervalList;
import androidx.compose.runtime.Composer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@ExperimentalFoundationApi
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0002@AB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d2\u0006\u0010#\u001a\u00020\u0003H\u0002J3\u0010$\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)\u0012\u0004\u0012\u00020\u00030&0%2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,J=\u0010-\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)\u0012\u0004\u0012\u00020\u00030&0%2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H\u0002J(\u0010.\u001a\r\u0012\u0004\u0012\u00020(0'¢\u0006\u0002\b)2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0002\u0010/JI\u00100\u001a\u00020(2\u0019\u00101\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u000102¢\u0006\u0002\b\t2\u001c\u00103\u001a\u0018\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020(02¢\u0006\u0002\b)¢\u0006\u0002\b\tH\u0016ø\u0001\u0000¢\u0006\u0002\u00104Jl\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u00032\u001f\u00101\u001a\u001b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\b\t21\u00107\u001a-\u0012\u0004\u0012\u00020,\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020(0\u0006¢\u0006\u0002\b)¢\u0006\u0002\b\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010;J(\u0010<\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0003H\u0002R(\u0010\u0005\u001a\u0019\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000ej\b\u0012\u0004\u0012\u00020\u0003`\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Landroidx/compose/foundation/lazy/LazyGridScopeImpl;", "Landroidx/compose/foundation/lazy/LazyGridScope;", "nColumns", "", "(I)V", "DefaultSpan", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "bucketSize", "getBucketSize", "()I", "bucketStartItemIndex", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "cachedBucket", "", "cachedBucketIndex", "hasCustomSpans", "", "getHasCustomSpans$foundation_release", "()Z", "setHasCustomSpans$foundation_release", "(Z)V", "intervals", "Landroidx/compose/foundation/lazy/list/MutableIntervalList;", "Landroidx/compose/foundation/lazy/LazyGridScopeImpl$IntervalData;", "lastInterval", "Landroidx/compose/foundation/lazy/list/IntervalHolder;", "lastLineIndex", "lastLineStartItemIndex", "totalSize", "getTotalSize", "cachedIntervalForIndex", "itemIndex", "contentFor", "", "Lkotlin/Pair;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "lineIndex", "scope", "Landroidx/compose/foundation/lazy/LazyItemScope;", "contentForLineStartingWith", "contentOf", "(ILandroidx/compose/foundation/lazy/LazyItemScope;)Lkotlin/jvm/functions/Function2;", "item", "span", "Lkotlin/Function1;", "content", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "items", "count", "itemContent", "Lkotlin/ParameterName;", "name", "index", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;)V", "spanOf", "row", "column", "maxSpan", "IntervalData", "LazyGridItemSpanScopeImpl", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
public final class LazyGridScopeImpl implements LazyGridScope {
    private final Function2<LazyGridItemSpanScope, Integer, GridItemSpan> DefaultSpan;
    private final ArrayList<Integer> bucketStartItemIndex;
    private final List<Integer> cachedBucket;
    private int cachedBucketIndex;
    private boolean hasCustomSpans;
    private final MutableIntervalList<IntervalData> intervals = new MutableIntervalList<>();
    private IntervalHolder<IntervalData> lastInterval;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private final int nColumns;

    public LazyGridScopeImpl(int i) {
        this.nColumns = i;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        this.bucketStartItemIndex = arrayList;
        this.cachedBucketIndex = -1;
        this.cachedBucket = new ArrayList();
        this.DefaultSpan = LazyGridScopeImpl$DefaultSpan$1.INSTANCE;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001BQ\u0012(\u0010\u0002\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b0\u0003¢\u0006\u0002\b\t\u0012\u001d\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\rR3\u0010\u0002\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b0\u0003¢\u0006\u0002\b\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR+\u0010\n\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/lazy/LazyGridScopeImpl$IntervalData;", "", "content", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "span", "Landroidx/compose/foundation/lazy/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/GridItemSpan;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "getSpan", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LazyGrid.kt */
    private static final class IntervalData {
        private final Function2<LazyItemScope, Integer, Function2<Composer, Integer, Unit>> content;
        private final Function2<LazyGridItemSpanScope, Integer, GridItemSpan> span;

        public IntervalData(Function2<? super LazyItemScope, ? super Integer, ? extends Function2<? super Composer, ? super Integer, Unit>> function2, Function2<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> function22) {
            Intrinsics.checkNotNullParameter(function2, "content");
            Intrinsics.checkNotNullParameter(function22, "span");
            this.content = function2;
            this.span = function22;
        }

        public final Function2<LazyItemScope, Integer, Function2<Composer, Integer, Unit>> getContent() {
            return this.content;
        }

        public final Function2<LazyGridItemSpanScope, Integer, GridItemSpan> getSpan() {
            return this.span;
        }
    }

    public final boolean getHasCustomSpans$foundation_release() {
        return this.hasCustomSpans;
    }

    public final void setHasCustomSpans$foundation_release(boolean z) {
        this.hasCustomSpans = z;
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((((double) getTotalSize()) * 1.0d) / ((double) this.nColumns))) + 1;
    }

    public final int getTotalSize() {
        return this.intervals.getTotalSize();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009c A[LOOP:0: B:33:0x009c->B:58:0x009c, LOOP_START, PHI: r1 r3 
      PHI: (r1v6 int) = (r1v5 int), (r1v7 int) binds: [B:32:0x009a, B:58:0x009c] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v6 int) = (r3v5 int), (r3v7 int) binds: [B:32:0x009a, B:58:0x009c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<kotlin.Pair<kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit>, java.lang.Integer>> contentFor(int r10, androidx.compose.foundation.lazy.LazyItemScope r11) {
        /*
            r9 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            boolean r0 = r9.hasCustomSpans
            if (r0 != 0) goto L_0x0012
            int r0 = r9.nColumns
            int r0 = r0 * r10
            java.util.List r10 = r9.contentForLineStartingWith(r0, r10, r11)
            return r10
        L_0x0012:
            int r0 = r9.getBucketSize()
            int r0 = r10 / r0
            java.util.ArrayList<java.lang.Integer> r1 = r9.bucketStartItemIndex
            int r1 = r1.size()
            r2 = 1
            int r1 = r1 - r2
            int r1 = java.lang.Math.min(r0, r1)
            int r3 = r9.getBucketSize()
            int r1 = r1 * r3
            java.util.ArrayList<java.lang.Integer> r3 = r9.bucketStartItemIndex
            int r4 = r3.size()
            int r4 = r4 - r2
            int r4 = java.lang.Math.min(r0, r4)
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r4 = "bucketStartItemIndex[min…StartItemIndex.size - 1)]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            int r4 = r9.lastLineIndex
            r5 = 0
            if (r1 > r4) goto L_0x004d
            if (r4 > r10) goto L_0x004d
            r6 = 1
            goto L_0x004e
        L_0x004d:
            r6 = 0
        L_0x004e:
            if (r6 == 0) goto L_0x0054
            int r3 = r9.lastLineStartItemIndex
            r1 = r4
            goto L_0x006f
        L_0x0054:
            int r4 = r9.cachedBucketIndex
            if (r0 != r4) goto L_0x006f
            int r4 = r10 - r1
            java.util.List<java.lang.Integer> r6 = r9.cachedBucket
            int r6 = r6.size()
            if (r4 >= r6) goto L_0x006f
            java.util.List<java.lang.Integer> r1 = r9.cachedBucket
            java.lang.Object r1 = r1.get(r4)
            java.lang.Number r1 = (java.lang.Number) r1
            int r3 = r1.intValue()
            r1 = r10
        L_0x006f:
            int r4 = r9.getBucketSize()
            int r4 = r1 % r4
            if (r4 != 0) goto L_0x0089
            int r4 = r9.getBucketSize()
            int r6 = r10 - r1
            r7 = 2
            if (r7 > r6) goto L_0x0084
            if (r6 >= r4) goto L_0x0084
            r4 = 1
            goto L_0x0085
        L_0x0084:
            r4 = 0
        L_0x0085:
            if (r4 == 0) goto L_0x0089
            r4 = 1
            goto L_0x008a
        L_0x0089:
            r4 = 0
        L_0x008a:
            if (r4 == 0) goto L_0x0093
            r9.cachedBucketIndex = r0
            java.util.List<java.lang.Integer> r0 = r9.cachedBucket
            r0.clear()
        L_0x0093:
            if (r1 > r10) goto L_0x0097
            r0 = 1
            goto L_0x0098
        L_0x0097:
            r0 = 0
        L_0x0098:
            java.lang.String r6 = "Check failed."
            if (r0 == 0) goto L_0x0100
        L_0x009c:
            if (r1 >= r10) goto L_0x00f7
            int r0 = r9.getTotalSize()
            if (r3 >= r0) goto L_0x00f7
            if (r4 == 0) goto L_0x00af
            java.util.List<java.lang.Integer> r0 = r9.cachedBucket
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            r0.add(r7)
        L_0x00af:
            r0 = 0
        L_0x00b0:
            int r7 = r9.nColumns
            if (r0 >= r7) goto L_0x00c6
            int r7 = r9.getTotalSize()
            if (r3 >= r7) goto L_0x00c6
            int r7 = r3 + 1
            int r8 = r9.nColumns
            int r8 = r8 - r0
            int r3 = r9.spanOf(r3, r1, r0, r8)
            int r0 = r0 + r3
            r3 = r7
            goto L_0x00b0
        L_0x00c6:
            int r1 = r1 + 1
            int r0 = r9.getBucketSize()
            int r0 = r1 % r0
            if (r0 != 0) goto L_0x009c
            int r0 = r9.getBucketSize()
            int r0 = r1 / r0
            java.util.ArrayList<java.lang.Integer> r7 = r9.bucketStartItemIndex
            int r7 = r7.size()
            if (r7 != r0) goto L_0x00e0
            r0 = 1
            goto L_0x00e1
        L_0x00e0:
            r0 = 0
        L_0x00e1:
            if (r0 == 0) goto L_0x00ed
            java.util.ArrayList<java.lang.Integer> r0 = r9.bucketStartItemIndex
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            r0.add(r7)
            goto L_0x009c
        L_0x00ed:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = r6.toString()
            r10.<init>(r11)
            throw r10
        L_0x00f7:
            r9.lastLineIndex = r10
            r9.lastLineStartItemIndex = r3
            java.util.List r10 = r9.contentForLineStartingWith(r3, r10, r11)
            return r10
        L_0x0100:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = r6.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyGridScopeImpl.contentFor(int, androidx.compose.foundation.lazy.LazyItemScope):java.util.List");
    }

    private final List<Pair<Function2<Composer, Integer, Unit>, Integer>> contentForLineStartingWith(int i, int i2, LazyItemScope lazyItemScope) {
        ArrayList arrayList = new ArrayList(this.nColumns);
        int i3 = 0;
        while (i3 < this.nColumns && i < getTotalSize()) {
            int spanOf = spanOf(i, i2, i3, this.nColumns - i3);
            arrayList.add(TuplesKt.to(contentOf(i, lazyItemScope), Integer.valueOf(spanOf)));
            i++;
            i3 += spanOf;
        }
        return arrayList;
    }

    private final Function2<Composer, Integer, Unit> contentOf(int i, LazyItemScope lazyItemScope) {
        IntervalHolder<IntervalData> cachedIntervalForIndex = cachedIntervalForIndex(i);
        return cachedIntervalForIndex.getContent().getContent().invoke(lazyItemScope, Integer.valueOf(i - cachedIntervalForIndex.getStartIndex()));
    }

    private final int spanOf(int i, int i2, int i3, int i4) {
        IntervalHolder<IntervalData> cachedIntervalForIndex = cachedIntervalForIndex(i);
        LazyGridItemSpanScopeImpl lazyGridItemSpanScopeImpl = LazyGridItemSpanScopeImpl.INSTANCE;
        lazyGridItemSpanScopeImpl.setItemRow(i2);
        lazyGridItemSpanScopeImpl.setItemColumn(i3);
        lazyGridItemSpanScopeImpl.setMaxCurrentLineSpan(i4);
        return RangesKt.coerceIn(GridItemSpan.m515getCurrentLineSpanimpl(cachedIntervalForIndex.getContent().getSpan().invoke(lazyGridItemSpanScopeImpl, Integer.valueOf(i - cachedIntervalForIndex.getStartIndex())).m518unboximpl()), 1, i4);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/lazy/LazyGridScopeImpl$LazyGridItemSpanScopeImpl;", "Landroidx/compose/foundation/lazy/LazyGridItemSpanScope;", "()V", "itemColumn", "", "getItemColumn", "()I", "setItemColumn", "(I)V", "itemRow", "getItemRow", "setItemRow", "maxCurrentLineSpan", "getMaxCurrentLineSpan", "setMaxCurrentLineSpan", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LazyGrid.kt */
    private static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {
        public static final LazyGridItemSpanScopeImpl INSTANCE = new LazyGridItemSpanScopeImpl();
        private static int itemColumn;
        private static int itemRow;
        private static int maxCurrentLineSpan;

        private LazyGridItemSpanScopeImpl() {
        }

        public int getItemRow() {
            return itemRow;
        }

        public void setItemRow(int i) {
            itemRow = i;
        }

        public int getItemColumn() {
            return itemColumn;
        }

        public void setItemColumn(int i) {
            itemColumn = i;
        }

        public int getMaxCurrentLineSpan() {
            return maxCurrentLineSpan;
        }

        public void setMaxCurrentLineSpan(int i) {
            maxCurrentLineSpan = i;
        }
    }

    private final IntervalHolder<IntervalData> cachedIntervalForIndex(int i) {
        IntervalHolder<IntervalData> intervalHolder = this.lastInterval;
        if (intervalHolder != null) {
            int startIndex = intervalHolder.getStartIndex();
            boolean z = false;
            if (i < intervalHolder.getStartIndex() + intervalHolder.getSize() && startIndex <= i) {
                z = true;
            }
            if (z) {
                return intervalHolder;
            }
        }
        IntervalHolder<IntervalData> intervalForIndex = IntervalListKt.intervalForIndex(this.intervals, i);
        this.lastInterval = intervalForIndex;
        return intervalForIndex;
    }

    public void item(Function1<? super LazyGridItemSpanScope, GridItemSpan> function1, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "content");
        MutableIntervalList<IntervalData> mutableIntervalList = this.intervals;
        Function2 lazyGridScopeImpl$item$1 = new LazyGridScopeImpl$item$1(function3);
        Function2<LazyGridItemSpanScope, Integer, GridItemSpan> lazyGridScopeImpl$item$2$1 = function1 == null ? null : new LazyGridScopeImpl$item$2$1(function1);
        if (lazyGridScopeImpl$item$2$1 == null) {
            lazyGridScopeImpl$item$2$1 = this.DefaultSpan;
        }
        mutableIntervalList.add(1, new IntervalData(lazyGridScopeImpl$item$1, lazyGridScopeImpl$item$2$1));
        if (function1 != null) {
            this.hasCustomSpans = true;
        }
    }

    public void items(int i, Function2<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> function2, Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        this.intervals.add(i, new IntervalData(new LazyGridScopeImpl$items$1(function4), function2 == null ? this.DefaultSpan : function2));
        if (function2 != null) {
            this.hasCustomSpans = true;
        }
    }
}
