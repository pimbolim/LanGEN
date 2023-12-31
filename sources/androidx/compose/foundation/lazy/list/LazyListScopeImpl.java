package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J5\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0016¢\u0006\u0002\u0010\u001aJm\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00052#\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001621\u0010 \u001a-\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00120!¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0016¢\u0006\u0002\u0010\"J5\u0010#\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u0019H\u0017¢\u0006\u0002\u0010\u001aR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Landroidx/compose/foundation/lazy/list/LazyListScopeImpl;", "Landroidx/compose/foundation/lazy/LazyListScope;", "()V", "_headerIndexes", "", "", "_intervals", "Landroidx/compose/foundation/lazy/list/MutableIntervalList;", "Landroidx/compose/foundation/lazy/list/LazyListIntervalContent;", "headerIndexes", "", "getHeaderIndexes", "()Ljava/util/List;", "intervals", "Landroidx/compose/foundation/lazy/list/IntervalList;", "getIntervals", "()Landroidx/compose/foundation/lazy/list/IntervalList;", "item", "", "key", "", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "items", "count", "Lkotlin/ParameterName;", "name", "index", "itemContent", "Lkotlin/Function2;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListScopeImpl.kt */
public final class LazyListScopeImpl implements LazyListScope {
    private List<Integer> _headerIndexes;
    private final MutableIntervalList<LazyListIntervalContent> _intervals;
    private final IntervalList<LazyListIntervalContent> intervals;

    public LazyListScopeImpl() {
        MutableIntervalList<LazyListIntervalContent> mutableIntervalList = new MutableIntervalList<>();
        this._intervals = mutableIntervalList;
        this.intervals = mutableIntervalList;
    }

    public final IntervalList<LazyListIntervalContent> getIntervals() {
        return this.intervals;
    }

    public final List<Integer> getHeaderIndexes() {
        List<Integer> list = this._headerIndexes;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public void items(int i, Function1<? super Integer, ? extends Object> function1, Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        this._intervals.add(i, new LazyListIntervalContent(function1, new LazyListScopeImpl$items$1(function4)));
    }

    public void item(Object obj, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "content");
        this._intervals.add(1, new LazyListIntervalContent(obj != null ? new LazyListScopeImpl$item$1(obj) : null, new LazyListScopeImpl$item$2(function3)));
    }

    @ExperimentalFoundationApi
    public void stickyHeader(Object obj, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "content");
        List<Integer> list = this._headerIndexes;
        if (list == null) {
            list = new ArrayList<>();
            this._headerIndexes = list;
        }
        list.add(Integer.valueOf(this._intervals.getTotalSize()));
        item(obj, function3);
    }
}
