package androidx.compose.runtime.livedata;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Effects.kt */
public final class LiveDataAdapterKt$observeAsState$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ Observer $observer$inlined;
    final /* synthetic */ LiveData $this_observeAsState$inlined;

    public LiveDataAdapterKt$observeAsState$1$invoke$$inlined$onDispose$1(LiveData liveData, Observer observer) {
        this.$this_observeAsState$inlined = liveData;
        this.$observer$inlined = observer;
    }

    public void dispose() {
        this.$this_observeAsState$inlined.removeObserver(this.$observer$inlined);
    }
}
