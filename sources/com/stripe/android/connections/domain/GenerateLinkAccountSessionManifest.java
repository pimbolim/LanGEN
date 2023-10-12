package com.stripe.android.connections.domain;

import com.stripe.android.connections.model.LinkAccountSessionManifest;
import com.stripe.android.connections.repository.ConnectionsRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/connections/domain/GenerateLinkAccountSessionManifest;", "", "connectionsRepository", "Lcom/stripe/android/connections/repository/ConnectionsRepository;", "(Lcom/stripe/android/connections/repository/ConnectionsRepository;)V", "invoke", "Lcom/stripe/android/connections/model/LinkAccountSessionManifest;", "clientSecret", "", "applicationId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GenerateLinkAccountSessionManifest.kt */
public final class GenerateLinkAccountSessionManifest {
    private final ConnectionsRepository connectionsRepository;

    @Inject
    public GenerateLinkAccountSessionManifest(ConnectionsRepository connectionsRepository2) {
        Intrinsics.checkNotNullParameter(connectionsRepository2, "connectionsRepository");
        this.connectionsRepository = connectionsRepository2;
    }

    public final Object invoke(String str, String str2, Continuation<? super LinkAccountSessionManifest> continuation) {
        return this.connectionsRepository.generateLinkAccountSessionManifest(str, str2, continuation);
    }
}
