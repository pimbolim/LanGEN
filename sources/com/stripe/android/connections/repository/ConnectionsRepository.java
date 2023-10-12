package com.stripe.android.connections.repository;

import com.stripe.android.connections.model.LinkAccountSession;
import com.stripe.android.connections.model.LinkAccountSessionManifest;
import com.stripe.android.connections.model.LinkedAccountList;
import com.stripe.android.connections.model.ListLinkedAccountParams;
import com.stripe.android.core.exception.APIConnectionException;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.core.exception.AuthenticationException;
import com.stripe.android.core.exception.InvalidRequestException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/connections/repository/ConnectionsRepository;", "", "generateLinkAccountSessionManifest", "Lcom/stripe/android/connections/model/LinkAccountSessionManifest;", "clientSecret", "", "applicationId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLinkAccountSession", "Lcom/stripe/android/connections/model/LinkAccountSession;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLinkedAccounts", "Lcom/stripe/android/connections/model/LinkedAccountList;", "listLinkedAccountParams", "Lcom/stripe/android/connections/model/ListLinkedAccountParams;", "(Lcom/stripe/android/connections/model/ListLinkedAccountParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsRepository.kt */
public interface ConnectionsRepository {
    Object generateLinkAccountSessionManifest(String str, String str2, Continuation<? super LinkAccountSessionManifest> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    Object getLinkAccountSession(String str, Continuation<? super LinkAccountSession> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

    Object getLinkedAccounts(ListLinkedAccountParams listLinkedAccountParams, Continuation<? super LinkedAccountList> continuation) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;
}
