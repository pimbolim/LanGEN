package com.stripe.android.paymentsheet;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0006"}, d2 = {"disableScrolling", "", "Landroidx/compose/foundation/lazy/LazyListState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "reenableScrolling", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListEnabable.kt */
public final class LazyListEnabableKt {
    public static final void disableScrolling(LazyListState lazyListState, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(lazyListState, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LazyListEnabableKt$disableScrolling$1(lazyListState, (Continuation<? super LazyListEnabableKt$disableScrolling$1>) null), 3, (Object) null);
    }

    public static final void reenableScrolling(LazyListState lazyListState, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(lazyListState, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LazyListEnabableKt$reenableScrolling$1(lazyListState, (Continuation<? super LazyListEnabableKt$reenableScrolling$1>) null), 3, (Object) null);
    }
}
