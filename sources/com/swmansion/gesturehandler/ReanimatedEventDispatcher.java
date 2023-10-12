package com.swmansion.gesturehandler;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u0004\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00062\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/gesturehandler/ReanimatedEventDispatcher;", "", "()V", "sendEvent", "", "T", "Lcom/facebook/react/uimanager/events/Event;", "event", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/uimanager/events/Event;Lcom/facebook/react/bridge/ReactContext;)V", "react-native-gesture-handler_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ReanimatedEventDispatcher.kt */
public final class ReanimatedEventDispatcher {
    public static final ReanimatedEventDispatcher INSTANCE = new ReanimatedEventDispatcher();

    public final <T extends Event<T>> void sendEvent(T t, ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(t, "event");
        Intrinsics.checkNotNullParameter(reactContext, "reactApplicationContext");
    }

    private ReanimatedEventDispatcher() {
    }
}
