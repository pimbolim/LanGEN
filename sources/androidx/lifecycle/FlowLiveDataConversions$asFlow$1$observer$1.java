package androidx.lifecycle;

import kotlin.Metadata;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "it", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: FlowLiveData.kt */
final class FlowLiveDataConversions$asFlow$1$observer$1<T> implements Observer {
    final /* synthetic */ Channel<T> $channel;

    FlowLiveDataConversions$asFlow$1$observer$1(Channel<T> channel) {
        this.$channel = channel;
    }

    public final void onChanged(T t) {
        this.$channel.m6176trySendJP2dKIU(t);
    }
}
