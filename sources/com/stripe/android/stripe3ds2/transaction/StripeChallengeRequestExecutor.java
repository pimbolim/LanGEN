package com.stripe.android.stripe3ds2.transaction;

import com.drew.metadata.exif.makernotes.OlympusCameraSettingsMakernoteDirectory;
import com.nimbusds.jose.JOSEException;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.security.DiffieHellmanKeyGenerator;
import com.stripe.android.stripe3ds2.security.EcKeyFactory;
import com.stripe.android.stripe3ds2.security.MessageTransformer;
import com.stripe.android.stripe3ds2.security.StripeDiffieHellmanKeyGenerator;
import com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor;
import com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import com.stripe.android.stripe3ds2.transactions.ErrorData;
import com.stripe.android.stripe3ds2.transactions.ProtocolError;
import java.security.PrivateKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.concurrent.TimeUnit;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 %2\u00020\u0001:\u0002%&Bc\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u001bH\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeChallengeRequestExecutor;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor;", "messageTransformer", "Lcom/stripe/android/stripe3ds2/security/MessageTransformer;", "sdkReferenceId", "", "sdkPrivateKey", "Ljava/security/PrivateKey;", "acsPublicKey", "Ljava/security/interfaces/ECPublicKey;", "acsUrl", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "dhKeyGenerator", "Lcom/stripe/android/stripe3ds2/security/DiffieHellmanKeyGenerator;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "httpClient", "Lcom/stripe/android/stripe3ds2/transaction/HttpClient;", "creqExecutorConfig", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config;", "responseProcessorFactory", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResponseProcessorFactory;", "(Lcom/stripe/android/stripe3ds2/security/MessageTransformer;Ljava/lang/String;Ljava/security/PrivateKey;Ljava/security/interfaces/ECPublicKey;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lcom/stripe/android/stripe3ds2/security/DiffieHellmanKeyGenerator;Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/stripe3ds2/transaction/HttpClient;Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config;Lcom/stripe/android/stripe3ds2/transaction/ChallengeResponseProcessorFactory;)V", "responseProcessor", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResponseProcessor;", "secretKey", "Ljavax/crypto/SecretKey;", "execute", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "creqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "(Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateSecretKey", "getRequestBody", "payload", "Lorg/json/JSONObject;", "Companion", "Factory", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeChallengeRequestExecutor.kt */
public final class StripeChallengeRequestExecutor implements ChallengeRequestExecutor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long TIMEOUT = TimeUnit.SECONDS.toMillis(10);
    private final ECPublicKey acsPublicKey;
    private final ChallengeRequestExecutor.Config creqExecutorConfig;
    private final DiffieHellmanKeyGenerator dhKeyGenerator;
    /* access modifiers changed from: private */
    public final ErrorReporter errorReporter;
    /* access modifiers changed from: private */
    public final HttpClient httpClient;
    private final MessageTransformer messageTransformer;
    /* access modifiers changed from: private */
    public final ChallengeResponseProcessor responseProcessor;
    private final PrivateKey sdkPrivateKey;
    private final String sdkReferenceId;
    private final SecretKey secretKey;
    private final CoroutineContext workContext;

    public StripeChallengeRequestExecutor(MessageTransformer messageTransformer2, String str, PrivateKey privateKey, ECPublicKey eCPublicKey, String str2, ErrorReporter errorReporter2, DiffieHellmanKeyGenerator diffieHellmanKeyGenerator, CoroutineContext coroutineContext, HttpClient httpClient2, ChallengeRequestExecutor.Config config, ChallengeResponseProcessorFactory challengeResponseProcessorFactory) {
        Intrinsics.checkNotNullParameter(messageTransformer2, "messageTransformer");
        Intrinsics.checkNotNullParameter(str, "sdkReferenceId");
        Intrinsics.checkNotNullParameter(privateKey, "sdkPrivateKey");
        Intrinsics.checkNotNullParameter(eCPublicKey, "acsPublicKey");
        Intrinsics.checkNotNullParameter(str2, "acsUrl");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(diffieHellmanKeyGenerator, "dhKeyGenerator");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(httpClient2, "httpClient");
        Intrinsics.checkNotNullParameter(config, "creqExecutorConfig");
        Intrinsics.checkNotNullParameter(challengeResponseProcessorFactory, "responseProcessorFactory");
        this.messageTransformer = messageTransformer2;
        this.sdkReferenceId = str;
        this.sdkPrivateKey = privateKey;
        this.acsPublicKey = eCPublicKey;
        this.errorReporter = errorReporter2;
        this.dhKeyGenerator = diffieHellmanKeyGenerator;
        this.workContext = coroutineContext;
        this.httpClient = httpClient2;
        this.creqExecutorConfig = config;
        SecretKey generateSecretKey = generateSecretKey();
        this.secretKey = generateSecretKey;
        this.responseProcessor = challengeResponseProcessorFactory.create(generateSecretKey);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ StripeChallengeRequestExecutor(com.stripe.android.stripe3ds2.security.MessageTransformer r15, java.lang.String r16, java.security.PrivateKey r17, java.security.interfaces.ECPublicKey r18, java.lang.String r19, com.stripe.android.stripe3ds2.observability.ErrorReporter r20, com.stripe.android.stripe3ds2.security.DiffieHellmanKeyGenerator r21, kotlin.coroutines.CoroutineContext r22, com.stripe.android.stripe3ds2.transaction.HttpClient r23, com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor.Config r24, com.stripe.android.stripe3ds2.transaction.ChallengeResponseProcessorFactory r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0019
            com.stripe.android.stripe3ds2.transaction.StripeHttpClient r1 = new com.stripe.android.stripe3ds2.transaction.StripeHttpClient
            r4 = 0
            r7 = 2
            r8 = 0
            r2 = r1
            r3 = r19
            r5 = r20
            r6 = r22
            r2.<init>(r3, r4, r5, r6, r7, r8)
            com.stripe.android.stripe3ds2.transaction.HttpClient r1 = (com.stripe.android.stripe3ds2.transaction.HttpClient) r1
            r11 = r1
            goto L_0x001b
        L_0x0019:
            r11 = r23
        L_0x001b:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x002d
            com.stripe.android.stripe3ds2.transaction.ChallengeResponseProcessorFactory$Default r0 = new com.stripe.android.stripe3ds2.transaction.ChallengeResponseProcessorFactory$Default
            r1 = r15
            r8 = r20
            r12 = r24
            r0.<init>(r15, r8, r12)
            com.stripe.android.stripe3ds2.transaction.ChallengeResponseProcessorFactory r0 = (com.stripe.android.stripe3ds2.transaction.ChallengeResponseProcessorFactory) r0
            r13 = r0
            goto L_0x0034
        L_0x002d:
            r1 = r15
            r8 = r20
            r12 = r24
            r13 = r25
        L_0x0034:
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r12 = r24
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor.<init>(com.stripe.android.stripe3ds2.security.MessageTransformer, java.lang.String, java.security.PrivateKey, java.security.interfaces.ECPublicKey, java.lang.String, com.stripe.android.stripe3ds2.observability.ErrorReporter, com.stripe.android.stripe3ds2.security.DiffieHellmanKeyGenerator, kotlin.coroutines.CoroutineContext, com.stripe.android.stripe3ds2.transaction.HttpClient, com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor$Config, com.stripe.android.stripe3ds2.transaction.ChallengeResponseProcessorFactory, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object execute(com.stripe.android.stripe3ds2.transactions.ChallengeRequestData r7, kotlin.coroutines.Continuation<? super com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$execute$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$execute$1 r0 = (com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$execute$1 r0 = new com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$execute$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            com.stripe.android.stripe3ds2.transactions.ChallengeRequestData r7 = (com.stripe.android.stripe3ds2.transactions.ChallengeRequestData) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004e
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            long r4 = TIMEOUT
            com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$execute$2 r8 = new com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$execute$2
            r2 = 0
            r8.<init>(r6, r7, r2)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r4, r8, r0)
            if (r8 != r1) goto L_0x004e
            return r1
        L_0x004e:
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult r8 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult) r8
            if (r8 != 0) goto L_0x005b
            com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$Companion r8 = Companion
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult$Timeout r7 = r8.createTimeoutResult(r7)
            r8 = r7
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult r8 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult) r8
        L_0x005b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor.execute(com.stripe.android.stripe3ds2.transactions.ChallengeRequestData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final String getRequestBody(JSONObject jSONObject) throws JSONException, JOSEException {
        return this.messageTransformer.encrypt(jSONObject, this.secretKey);
    }

    private final SecretKey generateSecretKey() {
        return this.dhKeyGenerator.generate(this.acsPublicKey, (ECPrivateKey) this.sdkPrivateKey, this.sdkReferenceId);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeChallengeRequestExecutor$Factory;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Factory;", "config", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config;", "(Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config;)V", "create", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeChallengeRequestExecutor.kt */
    public static final class Factory implements ChallengeRequestExecutor.Factory {
        private final ChallengeRequestExecutor.Config config;

        public Factory(ChallengeRequestExecutor.Config config2) {
            Intrinsics.checkNotNullParameter(config2, "config");
            this.config = config2;
        }

        public ChallengeRequestExecutor create(ErrorReporter errorReporter, CoroutineContext coroutineContext) {
            ErrorReporter errorReporter2 = errorReporter;
            Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
            CoroutineContext coroutineContext2 = coroutineContext;
            Intrinsics.checkNotNullParameter(coroutineContext2, "workContext");
            EcKeyFactory ecKeyFactory = new EcKeyFactory(errorReporter2);
            return new StripeChallengeRequestExecutor(this.config.getMessageTransformer$3ds2sdk_release(), this.config.getSdkReferenceId$3ds2sdk_release(), ecKeyFactory.createPrivate(this.config.getKeys$3ds2sdk_release().getSdkPrivateKeyEncoded$3ds2sdk_release()), ecKeyFactory.createPublic(this.config.getKeys$3ds2sdk_release().getAcsPublicKeyEncoded$3ds2sdk_release()), this.config.getAcsUrl$3ds2sdk_release(), errorReporter2, new StripeDiffieHellmanKeyGenerator(errorReporter2), coroutineContext2, (HttpClient) null, this.config, (ChallengeResponseProcessorFactory) null, OlympusCameraSettingsMakernoteDirectory.TagWhiteBalance2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeChallengeRequestExecutor$Companion;", "", "()V", "TIMEOUT", "", "getTIMEOUT", "()J", "createTimeoutResult", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$Timeout;", "creqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeChallengeRequestExecutor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getTIMEOUT() {
            return StripeChallengeRequestExecutor.TIMEOUT;
        }

        /* access modifiers changed from: private */
        public final ChallengeRequestResult.Timeout createTimeoutResult(ChallengeRequestData challengeRequestData) {
            SdkTransactionId sdkTransId = challengeRequestData.getSdkTransId();
            String messageVersion = challengeRequestData.getMessageVersion();
            String acsTransId = challengeRequestData.getAcsTransId();
            return new ChallengeRequestResult.Timeout(new ErrorData(challengeRequestData.getThreeDsServerTransId(), acsTransId, (String) null, String.valueOf(ProtocolError.TransactionTimedout.getCode()), ErrorData.ErrorComponent.ThreeDsSdk, ProtocolError.TransactionTimedout.getDescription(), "Challenge request timed-out", ChallengeRequestData.MESSAGE_TYPE, messageVersion, sdkTransId, 4, (DefaultConstructorMarker) null));
        }
    }
}
