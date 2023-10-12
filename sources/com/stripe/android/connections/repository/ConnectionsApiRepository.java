package com.stripe.android.connections.repository;

import com.stripe.android.connections.model.LinkAccountSession;
import com.stripe.android.connections.model.LinkAccountSessionManifest;
import com.stripe.android.connections.model.LinkedAccountList;
import com.stripe.android.connections.model.ListLinkedAccountParams;
import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.core.exception.AuthenticationException;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.exception.PermissionException;
import com.stripe.android.core.exception.RateLimitException;
import com.stripe.android.core.model.parsers.StripeErrorJsonParser;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.RequestId;
import com.stripe.android.core.networking.StripeNetworkClient;
import com.stripe.android.core.networking.StripeResponse;
import com.stripe.android.core.networking.StripeResponseKtxKt;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ-\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u00060&j\u0002`'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030)H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/stripe/android/connections/repository/ConnectionsApiRepository;", "Lcom/stripe/android/connections/repository/ConnectionsRepository;", "publishableKey", "", "stripeNetworkClient", "Lcom/stripe/android/core/networking/StripeNetworkClient;", "apiRequestFactory", "Lcom/stripe/android/core/networking/ApiRequest$Factory;", "(Ljava/lang/String;Lcom/stripe/android/core/networking/StripeNetworkClient;Lcom/stripe/android/core/networking/ApiRequest$Factory;)V", "json", "Lkotlinx/serialization/json/Json;", "getJson$connections_release$annotations", "()V", "getJson$connections_release", "()Lkotlinx/serialization/json/Json;", "options", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "executeRequest", "Response", "request", "Lcom/stripe/android/core/networking/StripeRequest;", "responseSerializer", "Lkotlinx/serialization/KSerializer;", "(Lcom/stripe/android/core/networking/StripeRequest;Lkotlinx/serialization/KSerializer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateLinkAccountSessionManifest", "Lcom/stripe/android/connections/model/LinkAccountSessionManifest;", "clientSecret", "applicationId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLinkAccountSession", "Lcom/stripe/android/connections/model/LinkAccountSession;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLinkedAccounts", "Lcom/stripe/android/connections/model/LinkedAccountList;", "listLinkedAccountParams", "Lcom/stripe/android/connections/model/ListLinkedAccountParams;", "(Lcom/stripe/android/connections/model/ListLinkedAccountParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleApiError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "response", "Lcom/stripe/android/core/networking/StripeResponse;", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsApiRepository.kt */
public final class ConnectionsApiRepository implements ConnectionsRepository {
    private static final String API_HOST = "https://api.stripe.com";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAMS_APPLICATION_ID = "application_id";
    public static final String PARAMS_CLIENT_SECRET = "client_secret";
    private final ApiRequest.Factory apiRequestFactory;
    private final Json json = JsonKt.Json$default((Json) null, ConnectionsApiRepository$json$1.INSTANCE, 1, (Object) null);
    private final ApiRequest.Options options;
    private final StripeNetworkClient stripeNetworkClient;

    public static /* synthetic */ void getJson$connections_release$annotations() {
    }

    @Inject
    public ConnectionsApiRepository(@Named("publishableKey") String str, StripeNetworkClient stripeNetworkClient2, ApiRequest.Factory factory) {
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
        Intrinsics.checkNotNullParameter(factory, "apiRequestFactory");
        this.stripeNetworkClient = stripeNetworkClient2;
        this.apiRequestFactory = factory;
        this.options = new ApiRequest.Options(str, (String) null, (String) null, 6, (DefaultConstructorMarker) null);
    }

    public final Json getJson$connections_release() {
        return this.json;
    }

    public Object getLinkedAccounts(ListLinkedAccountParams listLinkedAccountParams, Continuation<? super LinkedAccountList> continuation) {
        return executeRequest(this.apiRequestFactory.createGet(Companion.getListAccountsUrl$connections_release(), this.options, listLinkedAccountParams.toParamMap()), LinkedAccountList.Companion.serializer(), continuation);
    }

    public Object getLinkAccountSession(String str, Continuation<? super LinkAccountSession> continuation) {
        return executeRequest(this.apiRequestFactory.createGet(Companion.getSessionReceiptUrl$connections_release(), this.options, MapsKt.mapOf(TuplesKt.to("client_secret", str))), LinkAccountSession.Companion.serializer(), continuation);
    }

    public Object generateLinkAccountSessionManifest(String str, String str2, Continuation<? super LinkAccountSessionManifest> continuation) {
        return executeRequest(this.apiRequestFactory.createPost(Companion.getGenerateHostedUrl$connections_release(), this.options, MapsKt.mapOf(TuplesKt.to("client_secret", str), TuplesKt.to(PARAMS_APPLICATION_ID, str2))), LinkAccountSessionManifest.Companion.serializer(), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: kotlinx.serialization.KSerializer<Response>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <Response> java.lang.Object executeRequest(com.stripe.android.core.networking.StripeRequest r5, kotlinx.serialization.KSerializer<Response> r6, kotlin.coroutines.Continuation<? super Response> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stripe.android.connections.repository.ConnectionsApiRepository$executeRequest$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.connections.repository.ConnectionsApiRepository$executeRequest$1 r0 = (com.stripe.android.connections.repository.ConnectionsApiRepository$executeRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.connections.repository.ConnectionsApiRepository$executeRequest$1 r0 = new com.stripe.android.connections.repository.ConnectionsApiRepository$executeRequest$1
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r5 = r0.L$2
            r6 = r5
            kotlinx.serialization.KSerializer r6 = (kotlinx.serialization.KSerializer) r6
            java.lang.Object r5 = r0.L$1
            com.stripe.android.core.networking.StripeRequest r5 = (com.stripe.android.core.networking.StripeRequest) r5
            java.lang.Object r0 = r0.L$0
            com.stripe.android.connections.repository.ConnectionsApiRepository r0 = (com.stripe.android.connections.repository.ConnectionsApiRepository) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0037 }
            goto L_0x005b
        L_0x0037:
            r7 = move-exception
            goto L_0x0064
        L_0x0039:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x0062 }
            r7 = r4
            com.stripe.android.connections.repository.ConnectionsApiRepository r7 = (com.stripe.android.connections.repository.ConnectionsApiRepository) r7     // Catch:{ all -> 0x0062 }
            com.stripe.android.core.networking.StripeNetworkClient r7 = r7.stripeNetworkClient     // Catch:{ all -> 0x0062 }
            r0.L$0 = r4     // Catch:{ all -> 0x0062 }
            r0.L$1 = r5     // Catch:{ all -> 0x0062 }
            r0.L$2 = r6     // Catch:{ all -> 0x0062 }
            r0.label = r3     // Catch:{ all -> 0x0062 }
            java.lang.Object r7 = r7.executeRequest(r5, r0)     // Catch:{ all -> 0x0062 }
            if (r7 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r0 = r4
        L_0x005b:
            com.stripe.android.core.networking.StripeResponse r7 = (com.stripe.android.core.networking.StripeResponse) r7     // Catch:{ all -> 0x0037 }
            java.lang.Object r7 = kotlin.Result.m4709constructorimpl(r7)     // Catch:{ all -> 0x0037 }
            goto L_0x006e
        L_0x0062:
            r7 = move-exception
            r0 = r4
        L_0x0064:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m4709constructorimpl(r7)
        L_0x006e:
            java.lang.Throwable r1 = kotlin.Result.m4712exceptionOrNullimpl(r7)
            if (r1 != 0) goto L_0x00a0
            com.stripe.android.core.networking.StripeResponse r7 = (com.stripe.android.core.networking.StripeResponse) r7
            boolean r5 = r7.isError()
            if (r5 != 0) goto L_0x009b
            kotlinx.serialization.json.Json r5 = r0.getJson$connections_release()
            kotlinx.serialization.DeserializationStrategy r6 = (kotlinx.serialization.DeserializationStrategy) r6
            java.lang.Object r7 = r7.getBody()
            if (r7 == 0) goto L_0x008f
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r5 = r5.decodeFromString(r6, r7)
            return r5
        L_0x008f:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Required value was null."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x009b:
            java.lang.Exception r5 = r0.handleApiError(r7)
            throw r5
        L_0x00a0:
            com.stripe.android.core.exception.APIConnectionException r6 = new com.stripe.android.core.exception.APIConnectionException
            java.lang.String r7 = "Failed to execute "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r5)
            r6.<init>(r5, r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.repository.ConnectionsApiRepository.executeRequest(com.stripe.android.core.networking.StripeRequest, kotlinx.serialization.KSerializer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Exception handleApiError(StripeResponse<String> stripeResponse) throws InvalidRequestException, AuthenticationException, APIException {
        Throwable th;
        RequestId requestId = stripeResponse.getRequestId();
        String value = requestId == null ? null : requestId.getValue();
        int code = stripeResponse.getCode();
        StripeError parse = new StripeErrorJsonParser().parse(StripeResponseKtxKt.responseJson(stripeResponse));
        if (code != 400) {
            if (code == 401) {
                th = new AuthenticationException(parse, value);
            } else if (code == 403) {
                th = new PermissionException(parse, value);
            } else if (code != 404) {
                th = code != 429 ? new APIException(parse, value, code, (String) null, (Throwable) null, 24, (DefaultConstructorMarker) null) : new RateLimitException(parse, value, (String) null, (Throwable) null, 12, (DefaultConstructorMarker) null);
            }
            throw th;
        }
        th = new InvalidRequestException(parse, value, code, (String) null, (Throwable) null, 24, (DefaultConstructorMarker) null);
        throw th;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/connections/repository/ConnectionsApiRepository$Companion;", "", "()V", "API_HOST", "", "PARAMS_APPLICATION_ID", "PARAMS_CLIENT_SECRET", "generateHostedUrl", "getGenerateHostedUrl$connections_release", "()Ljava/lang/String;", "listAccountsUrl", "getListAccountsUrl$connections_release", "sessionReceiptUrl", "getSessionReceiptUrl$connections_release", "getApiUrl", "path", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsApiRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ String getListAccountsUrl$connections_release() {
            return getApiUrl("list_accounts");
        }

        public final /* synthetic */ String getGenerateHostedUrl$connections_release() {
            return getApiUrl("generate_hosted_url");
        }

        public final /* synthetic */ String getSessionReceiptUrl$connections_release() {
            return getApiUrl("session_receipt");
        }

        private final String getApiUrl(String str) {
            return Intrinsics.stringPlus("https://api.stripe.com/v1/link_account_sessions/", str);
        }
    }
}
