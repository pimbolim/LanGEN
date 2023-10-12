package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.node.Ref;
import com.braintreepayments.api.models.PostalAddressParser;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000\u001aB\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"ExtraItemsNearTheSlidingWindow", "", "VisibleItemsSlidingWindowSize", "calculateNearestItemsRange", "Lkotlin/ranges/IntRange;", "firstVisibleItem", "generateKeyToIndexMap", "", "", "range", "list", "Landroidx/compose/foundation/lazy/list/IntervalList;", "Landroidx/compose/foundation/lazy/list/LazyListIntervalContent;", "rememberStateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/lazy/list/LazyListItemsProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "", "Lkotlin/ExtensionFunctionType;", "itemScope", "Landroidx/compose/ui/node/Ref;", "Landroidx/compose/foundation/lazy/list/LazyItemScopeImpl;", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/node/Ref;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListItemsProviderImpl.kt */
public final class LazyListItemsProviderImplKt {
    private static final int ExtraItemsNearTheSlidingWindow = 100;
    private static final int VisibleItemsSlidingWindowSize = 30;

    public static final State<LazyListItemsProvider> rememberStateOfItemsProvider(LazyListState lazyListState, Function1<? super LazyListScope, Unit> function1, Ref<LazyItemScopeImpl> ref, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(lazyListState, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(function1, "content");
        Intrinsics.checkNotNullParameter(ref, "itemScope");
        composer.startReplaceableGroup(112461157);
        ComposerKt.sourceInformation(composer, "C(rememberStateOfItemsProvider)P(2)38@1486L29,39@1549L144,44@1698L344,50@2054L376:LazyListItemsProviderImpl.kt#77c2e6");
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 3) & 14);
        composer.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) lazyListState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(calculateNearestItemsRange(lazyListState.m526getFirstVisibleItemIndexNonObservableAUyieIw$foundation_release()), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        EffectsKt.LaunchedEffect((Object) mutableState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new LazyListItemsProviderImplKt$rememberStateOfItemsProvider$1(lazyListState, mutableState, (Continuation<? super LazyListItemsProviderImplKt$rememberStateOfItemsProvider$1>) null), composer, 0);
        composer.startReplaceableGroup(-3686930);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean changed2 = composer.changed((Object) mutableState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt.derivedStateOf(new LazyListItemsProviderImplKt$rememberStateOfItemsProvider$2$1(rememberUpdatedState, ref, mutableState));
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        State<LazyListItemsProvider> state = (State) rememberedValue2;
        composer.endReplaceableGroup();
        return state;
    }

    public static final Map<Object, Integer> generateKeyToIndexMap(IntRange intRange, IntervalList<LazyListIntervalContent> intervalList) {
        Intrinsics.checkNotNullParameter(intRange, "range");
        Intrinsics.checkNotNullParameter(intervalList, "list");
        int first = intRange.getFirst();
        if (first >= 0) {
            int min = Math.min(intRange.getLast(), intervalList.getTotalSize() - 1);
            if (min < first) {
                return MapsKt.emptyMap();
            }
            HashMap hashMap = new HashMap();
            int intervalIndexForItemIndex = IntervalListKt.intervalIndexForItemIndex(intervalList, first);
            while (first <= min) {
                IntervalHolder intervalHolder = intervalList.getIntervals().get(intervalIndexForItemIndex);
                Function1<Integer, Object> key = ((LazyListIntervalContent) intervalHolder.getContent()).getKey();
                if (key != null) {
                    int startIndex = first - intervalHolder.getStartIndex();
                    if (startIndex == intervalHolder.getSize()) {
                        intervalIndexForItemIndex++;
                    } else {
                        hashMap.put(key.invoke(Integer.valueOf(startIndex)), Integer.valueOf(first));
                        first++;
                    }
                } else {
                    intervalIndexForItemIndex++;
                    first = intervalHolder.getStartIndex() + intervalHolder.getSize();
                }
            }
            return hashMap;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* access modifiers changed from: private */
    public static final IntRange calculateNearestItemsRange(int i) {
        int i2 = VisibleItemsSlidingWindowSize;
        int i3 = (i / i2) * i2;
        int i4 = ExtraItemsNearTheSlidingWindow;
        return RangesKt.until(Math.max(i3 - i4, 0), i3 + i2 + i4);
    }
}
