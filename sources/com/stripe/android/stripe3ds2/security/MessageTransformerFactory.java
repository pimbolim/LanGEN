package com.stripe.android.stripe3ds2.security;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/MessageTransformerFactory;", "", "isLiveMode", "", "(Z)V", "create", "Lcom/stripe/android/stripe3ds2/security/MessageTransformer;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageTransformerFactory.kt */
public final class MessageTransformerFactory {
    private final boolean isLiveMode;

    public MessageTransformerFactory(boolean z) {
        this.isLiveMode = z;
    }

    public final MessageTransformer create() {
        return new DefaultMessageTransformer(this.isLiveMode);
    }
}
