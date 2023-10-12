package com.stripe.android.connections.domain;

import com.stripe.android.connections.repository.ConnectionsRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/stripe/android/connections/domain/FetchLinkAccountSession;", "", "connectionsRepository", "Lcom/stripe/android/connections/repository/ConnectionsRepository;", "(Lcom/stripe/android/connections/repository/ConnectionsRepository;)V", "invoke", "Lcom/stripe/android/connections/model/LinkAccountSession;", "clientSecret", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FetchLinkAccountSession.kt */
public final class FetchLinkAccountSession {
    private final ConnectionsRepository connectionsRepository;

    @Inject
    public FetchLinkAccountSession(ConnectionsRepository connectionsRepository2) {
        Intrinsics.checkNotNullParameter(connectionsRepository2, "connectionsRepository");
        this.connectionsRepository = connectionsRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x014d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.String r23, kotlin.coroutines.Continuation<? super com.stripe.android.connections.model.LinkAccountSession> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            boolean r3 = r2 instanceof com.stripe.android.connections.domain.FetchLinkAccountSession$invoke$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.stripe.android.connections.domain.FetchLinkAccountSession$invoke$1 r3 = (com.stripe.android.connections.domain.FetchLinkAccountSession$invoke$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.stripe.android.connections.domain.FetchLinkAccountSession$invoke$1 r3 = new com.stripe.android.connections.domain.FetchLinkAccountSession$invoke$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L_0x0071
            if (r5 == r8) goto L_0x0064
            if (r5 == r7) goto L_0x0050
            if (r5 != r6) goto L_0x0048
            java.lang.Object r1 = r3.L$3
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r3.L$2
            com.stripe.android.connections.model.LinkAccountSession r5 = (com.stripe.android.connections.model.LinkAccountSession) r5
            java.lang.Object r7 = r3.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r3.L$0
            com.stripe.android.connections.domain.FetchLinkAccountSession r8 = (com.stripe.android.connections.domain.FetchLinkAccountSession) r8
            kotlin.ResultKt.throwOnFailure(r2)
            r11 = r1
            goto L_0x0109
        L_0x0048:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0050:
            java.lang.Object r1 = r3.L$3
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r3.L$2
            com.stripe.android.connections.model.LinkAccountSession r5 = (com.stripe.android.connections.model.LinkAccountSession) r5
            java.lang.Object r7 = r3.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r3.L$0
            com.stripe.android.connections.domain.FetchLinkAccountSession r8 = (com.stripe.android.connections.domain.FetchLinkAccountSession) r8
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00cd
        L_0x0064:
            java.lang.Object r1 = r3.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$0
            com.stripe.android.connections.domain.FetchLinkAccountSession r5 = (com.stripe.android.connections.domain.FetchLinkAccountSession) r5
            kotlin.ResultKt.throwOnFailure(r2)
            r8 = r5
            goto L_0x0084
        L_0x0071:
            kotlin.ResultKt.throwOnFailure(r2)
            com.stripe.android.connections.repository.ConnectionsRepository r2 = r0.connectionsRepository
            r3.L$0 = r0
            r3.L$1 = r1
            r3.label = r8
            java.lang.Object r2 = r2.getLinkAccountSession(r1, r3)
            if (r2 != r4) goto L_0x0083
            return r4
        L_0x0083:
            r8 = r0
        L_0x0084:
            r5 = r2
            com.stripe.android.connections.model.LinkAccountSession r5 = (com.stripe.android.connections.model.LinkAccountSession) r5
            com.stripe.android.connections.model.LinkedAccountList r2 = r5.getLinkedAccounts()
            boolean r2 = r2.getHasMore()
            if (r2 == 0) goto L_0x014d
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            com.stripe.android.connections.model.LinkedAccountList r9 = r5.getLinkedAccounts()
            java.util.List r9 = r9.getLinkedAccounts()
            java.util.Collection r9 = (java.util.Collection) r9
            r2.addAll(r9)
            com.stripe.android.connections.repository.ConnectionsRepository r9 = r8.connectionsRepository
            com.stripe.android.connections.model.ListLinkedAccountParams r10 = new com.stripe.android.connections.model.ListLinkedAccountParams
            java.lang.Object r11 = kotlin.collections.CollectionsKt.last(r2)
            com.stripe.android.connections.model.LinkedAccount r11 = (com.stripe.android.connections.model.LinkedAccount) r11
            java.lang.String r11 = r11.getId()
            r10.<init>(r1, r11)
            r3.L$0 = r8
            r3.L$1 = r1
            r3.L$2 = r5
            r3.L$3 = r2
            r3.label = r7
            java.lang.Object r7 = r9.getLinkedAccounts(r10, r3)
            if (r7 != r4) goto L_0x00c7
            return r4
        L_0x00c7:
            r21 = r7
            r7 = r1
            r1 = r2
            r2 = r21
        L_0x00cd:
            com.stripe.android.connections.model.LinkedAccountList r2 = (com.stripe.android.connections.model.LinkedAccountList) r2
            java.util.List r9 = r2.getLinkedAccounts()
            java.util.Collection r9 = (java.util.Collection) r9
            r1.addAll(r9)
            r11 = r1
        L_0x00d9:
            boolean r1 = r2.getHasMore()
            if (r1 == 0) goto L_0x0115
            int r1 = r11.size()
            r9 = 100
            if (r1 >= r9) goto L_0x0115
            com.stripe.android.connections.repository.ConnectionsRepository r1 = r8.connectionsRepository
            com.stripe.android.connections.model.ListLinkedAccountParams r2 = new com.stripe.android.connections.model.ListLinkedAccountParams
            java.lang.Object r9 = kotlin.collections.CollectionsKt.last(r11)
            com.stripe.android.connections.model.LinkedAccount r9 = (com.stripe.android.connections.model.LinkedAccount) r9
            java.lang.String r9 = r9.getId()
            r2.<init>(r7, r9)
            r3.L$0 = r8
            r3.L$1 = r7
            r3.L$2 = r5
            r3.L$3 = r11
            r3.label = r6
            java.lang.Object r2 = r1.getLinkedAccounts(r2, r3)
            if (r2 != r4) goto L_0x0109
            return r4
        L_0x0109:
            com.stripe.android.connections.model.LinkedAccountList r2 = (com.stripe.android.connections.model.LinkedAccountList) r2
            java.util.List r1 = r2.getLinkedAccounts()
            java.util.Collection r1 = (java.util.Collection) r1
            r11.addAll(r1)
            goto L_0x00d9
        L_0x0115:
            java.lang.String r1 = r5.getId()
            java.lang.String r3 = r5.getClientSecret()
            com.stripe.android.connections.model.LinkedAccountList r4 = new com.stripe.android.connections.model.LinkedAccountList
            boolean r12 = r2.getHasMore()
            java.lang.String r13 = r2.getUrl()
            int r6 = r11.size()
            java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            java.lang.Integer r15 = r2.getTotalCount()
            r10 = r4
            r10.<init>(r11, r12, r13, r14, r15)
            boolean r16 = r5.getLivemode()
            com.stripe.android.connections.model.LinkAccountSession r2 = new com.stripe.android.connections.model.LinkAccountSession
            r17 = 0
            r18 = 0
            r19 = 48
            r20 = 0
            r12 = r2
            r13 = r3
            r14 = r1
            r15 = r4
            r12.<init>((java.lang.String) r13, (java.lang.String) r14, (com.stripe.android.connections.model.LinkedAccountList) r15, (boolean) r16, (com.stripe.android.connections.model.PaymentAccount) r17, (java.lang.String) r18, (int) r19, (kotlin.jvm.internal.DefaultConstructorMarker) r20)
            return r2
        L_0x014d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.domain.FetchLinkAccountSession.invoke(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
