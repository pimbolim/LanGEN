package androidx.compose.runtime.livedata;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveDataAdapter.kt */
final class LiveDataAdapterKt$observeAsState$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ MutableState<R> $state;
    final /* synthetic */ LiveData<T> $this_observeAsState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveDataAdapterKt$observeAsState$1(LiveData<T> liveData, LifecycleOwner lifecycleOwner, MutableState<R> mutableState) {
        super(1);
        this.$this_observeAsState = liveData;
        this.$lifecycleOwner = lifecycleOwner;
        this.$state = mutableState;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m1250invoke$lambda0(MutableState mutableState, Object obj) {
        Intrinsics.checkNotNullParameter(mutableState, "$state");
        mutableState.setValue(obj);
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        $$Lambda$LiveDataAdapterKt$observeAsState$1$2IOkfJBTr0ZEVSpH1d8esdaebMs r0 = new Observer() {
            public final void onChanged(Object obj) {
                LiveDataAdapterKt$observeAsState$1.m1250invoke$lambda0(MutableState.this, obj);
            }
        };
        this.$this_observeAsState.observe(this.$lifecycleOwner, r0);
        return new LiveDataAdapterKt$observeAsState$1$invoke$$inlined$onDispose$1(this.$this_observeAsState, r0);
    }
}
