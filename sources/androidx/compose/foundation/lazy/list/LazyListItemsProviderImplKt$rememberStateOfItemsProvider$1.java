package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.list.LazyListItemsProviderImplKt$rememberStateOfItemsProvider$1", f = "LazyListItemsProviderImpl.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LazyListItemsProviderImpl.kt */
final class LazyListItemsProviderImplKt$rememberStateOfItemsProvider$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<IntRange> $nearestItemsRangeState;
    final /* synthetic */ LazyListState $state;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListItemsProviderImplKt$rememberStateOfItemsProvider$1(LazyListState lazyListState, MutableState<IntRange> mutableState, Continuation<? super LazyListItemsProviderImplKt$rememberStateOfItemsProvider$1> continuation) {
        super(2, continuation);
        this.$state = lazyListState;
        this.$nearestItemsRangeState = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyListItemsProviderImplKt$rememberStateOfItemsProvider$1(this.$state, this.$nearestItemsRangeState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyListItemsProviderImplKt$rememberStateOfItemsProvider$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final LazyListState lazyListState = this.$state;
            this.label = 1;
            if (SnapshotStateKt.snapshotFlow(new Function0<IntRange>() {
                public final IntRange invoke() {
                    return LazyListItemsProviderImplKt.calculateNearestItemsRange(lazyListState.getFirstVisibleItemIndex());
                }
            }).collect(new LazyListItemsProviderImplKt$rememberStateOfItemsProvider$1$invokeSuspend$$inlined$collect$1(this.$nearestItemsRangeState), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
