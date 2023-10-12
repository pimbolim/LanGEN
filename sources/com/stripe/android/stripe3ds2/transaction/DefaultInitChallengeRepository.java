package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.security.MessageTransformer;
import com.stripe.android.stripe3ds2.transaction.ErrorRequestExecutor;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BW\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/DefaultInitChallengeRepository;", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeRepository;", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "messageVersionRegistry", "Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;", "jwsValidator", "Lcom/stripe/android/stripe3ds2/transaction/JwsValidator;", "messageTransformer", "Lcom/stripe/android/stripe3ds2/security/MessageTransformer;", "acsDataParser", "Lcom/stripe/android/stripe3ds2/transaction/AcsDataParser;", "challengeRequestResultRepository", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResultRepository;", "errorRequestExecutorFactory", "Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor$Factory;", "uiCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "logger", "Lcom/stripe/android/stripe3ds2/transaction/Logger;", "(Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;Lcom/stripe/android/stripe3ds2/transaction/JwsValidator;Lcom/stripe/android/stripe3ds2/security/MessageTransformer;Lcom/stripe/android/stripe3ds2/transaction/AcsDataParser;Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResultRepository;Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor$Factory;Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lcom/stripe/android/stripe3ds2/transaction/Logger;)V", "createCreqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "challengeParameters", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeParameters;", "startChallenge", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult;", "args", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeArgs;", "(Lcom/stripe/android/stripe3ds2/transaction/InitChallengeArgs;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InitChallengeRepository.kt */
public final class DefaultInitChallengeRepository implements InitChallengeRepository {
    private final AcsDataParser acsDataParser;
    private final ChallengeRequestResultRepository challengeRequestResultRepository;
    private final ErrorReporter errorReporter;
    private final ErrorRequestExecutor.Factory errorRequestExecutorFactory;
    private final JwsValidator jwsValidator;
    private final Logger logger;
    private final MessageTransformer messageTransformer;
    private final MessageVersionRegistry messageVersionRegistry;
    private final SdkTransactionId sdkTransactionId;
    private final StripeUiCustomization uiCustomization;

    public DefaultInitChallengeRepository(SdkTransactionId sdkTransactionId2, MessageVersionRegistry messageVersionRegistry2, JwsValidator jwsValidator2, MessageTransformer messageTransformer2, AcsDataParser acsDataParser2, ChallengeRequestResultRepository challengeRequestResultRepository2, ErrorRequestExecutor.Factory factory, StripeUiCustomization stripeUiCustomization, ErrorReporter errorReporter2, Logger logger2) {
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
        Intrinsics.checkNotNullParameter(messageVersionRegistry2, "messageVersionRegistry");
        Intrinsics.checkNotNullParameter(jwsValidator2, "jwsValidator");
        Intrinsics.checkNotNullParameter(messageTransformer2, "messageTransformer");
        Intrinsics.checkNotNullParameter(acsDataParser2, "acsDataParser");
        Intrinsics.checkNotNullParameter(challengeRequestResultRepository2, "challengeRequestResultRepository");
        Intrinsics.checkNotNullParameter(factory, "errorRequestExecutorFactory");
        Intrinsics.checkNotNullParameter(stripeUiCustomization, "uiCustomization");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.sdkTransactionId = sdkTransactionId2;
        this.messageVersionRegistry = messageVersionRegistry2;
        this.jwsValidator = jwsValidator2;
        this.messageTransformer = messageTransformer2;
        this.acsDataParser = acsDataParser2;
        this.challengeRequestResultRepository = challengeRequestResultRepository2;
        this.errorRequestExecutorFactory = factory;
        this.uiCustomization = stripeUiCustomization;
        this.errorReporter = errorReporter2;
        this.logger = logger2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00dd A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010a A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object startChallenge(com.stripe.android.stripe3ds2.transaction.InitChallengeArgs r17, kotlin.coroutines.Continuation<? super com.stripe.android.stripe3ds2.transaction.InitChallengeResult> r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            boolean r2 = r0 instanceof com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository$startChallenge$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository$startChallenge$1 r2 = (com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository$startChallenge$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository$startChallenge$1 r2 = new com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository$startChallenge$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0050
            if (r4 != r5) goto L_0x0048
            java.lang.Object r3 = r2.L$4
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor$Config r3 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor.Config) r3
            java.lang.Object r4 = r2.L$3
            com.stripe.android.stripe3ds2.transaction.ErrorRequestExecutor r4 = (com.stripe.android.stripe3ds2.transaction.ErrorRequestExecutor) r4
            java.lang.Object r5 = r2.L$2
            com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository r5 = (com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository) r5
            java.lang.Object r7 = r2.L$1
            com.stripe.android.stripe3ds2.transaction.InitChallengeArgs r7 = (com.stripe.android.stripe3ds2.transaction.InitChallengeArgs) r7
            java.lang.Object r2 = r2.L$0
            com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository r2 = (com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0045 }
            r12 = r3
            goto L_0x00d7
        L_0x0045:
            r0 = move-exception
            goto L_0x018d
        L_0x0048:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r0)
            com.stripe.android.stripe3ds2.transaction.Logger r0 = r1.logger
            java.lang.String r4 = "Make initial challenge request."
            r0.info(r4)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0189 }
            r0 = r1
            com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository r0 = (com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository) r0     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.AcsDataParser r4 = r0.acsDataParser     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.JwsValidator r7 = r0.jwsValidator     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.ChallengeParameters r8 = r17.getChallengeParameters$3ds2sdk_release()     // Catch:{ all -> 0x0189 }
            java.lang.String r8 = r8.getAcsSignedContent()     // Catch:{ all -> 0x0189 }
            if (r8 == 0) goto L_0x0179
            org.json.JSONObject r7 = r7.getPayload(r8)     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.AcsData r4 = r4.parse(r7)     // Catch:{ all -> 0x0189 }
            java.lang.String r11 = r4.component1()     // Catch:{ all -> 0x0189 }
            java.security.interfaces.ECPublicKey r4 = r4.component2()     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.SdkTransactionId r7 = r0.sdkTransactionId     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.ChallengeParameters r8 = r17.getChallengeParameters$3ds2sdk_release()     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transactions.ChallengeRequestData r13 = r0.createCreqData(r7, r8)     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.ErrorRequestExecutor$Factory r7 = r0.errorRequestExecutorFactory     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.observability.ErrorReporter r8 = r0.errorReporter     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.ErrorRequestExecutor r14 = r7.create(r11, r8)     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor$Config r15 = new com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor$Config     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.security.MessageTransformer r8 = r0.messageTransformer     // Catch:{ all -> 0x0189 }
            java.lang.String r9 = r17.getSdkReferenceNumber$3ds2sdk_release()     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor$Config$Keys r12 = new com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor$Config$Keys     // Catch:{ all -> 0x0189 }
            java.security.KeyPair r7 = r17.getSdkKeyPair$3ds2sdk_release()     // Catch:{ all -> 0x0189 }
            java.security.PrivateKey r7 = r7.getPrivate()     // Catch:{ all -> 0x0189 }
            byte[] r7 = r7.getEncoded()     // Catch:{ all -> 0x0189 }
            java.lang.String r10 = "args.sdkKeyPair.private.encoded"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r10)     // Catch:{ all -> 0x0189 }
            byte[] r4 = r4.getEncoded()     // Catch:{ all -> 0x0189 }
            java.lang.String r10 = "acsEphemPubKey.encoded"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)     // Catch:{ all -> 0x0189 }
            r12.<init>(r7, r4)     // Catch:{ all -> 0x0189 }
            r7 = r15
            r10 = r13
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0189 }
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResultRepository r4 = r0.challengeRequestResultRepository     // Catch:{ all -> 0x0189 }
            r2.L$0 = r1     // Catch:{ all -> 0x0189 }
            r7 = r17
            r2.L$1 = r7     // Catch:{ all -> 0x0187 }
            r2.L$2 = r0     // Catch:{ all -> 0x0187 }
            r2.L$3 = r14     // Catch:{ all -> 0x0187 }
            r2.L$4 = r15     // Catch:{ all -> 0x0187 }
            r2.label = r5     // Catch:{ all -> 0x0187 }
            java.lang.Object r2 = r4.get(r15, r13, r2)     // Catch:{ all -> 0x0187 }
            if (r2 != r3) goto L_0x00d2
            return r3
        L_0x00d2:
            r5 = r0
            r0 = r2
            r4 = r14
            r12 = r15
            r2 = r1
        L_0x00d7:
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult r0 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult) r0     // Catch:{ all -> 0x0045 }
            boolean r3 = r0 instanceof com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult.Success     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x010a
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult$Start r3 = new com.stripe.android.stripe3ds2.transaction.InitChallengeResult$Start     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.views.ChallengeViewArgs r4 = new com.stripe.android.stripe3ds2.views.ChallengeViewArgs     // Catch:{ all -> 0x0045 }
            r8 = r0
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult$Success r8 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult.Success) r8     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transactions.ChallengeResponseData r9 = r8.getCresData()     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult$Success r0 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult.Success) r0     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transactions.ChallengeRequestData r10 = r0.getCreqData()     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization r11 = r5.uiCustomization     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$Factory r0 = new com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$Factory     // Catch:{ all -> 0x0045 }
            r0.<init>(r12)     // Catch:{ all -> 0x0045 }
            r13 = r0
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor$Factory r13 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor.Factory) r13     // Catch:{ all -> 0x0045 }
            int r14 = r7.getTimeoutMins$3ds2sdk_release()     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.IntentData r15 = r7.getIntentData$3ds2sdk_release()     // Catch:{ all -> 0x0045 }
            r8 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0045 }
            r3.<init>(r4)     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult r3 = (com.stripe.android.stripe3ds2.transaction.InitChallengeResult) r3     // Catch:{ all -> 0x0045 }
            goto L_0x016e
        L_0x010a:
            boolean r3 = r0 instanceof com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult.ProtocolError     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0131
            r3 = r0
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult$ProtocolError r3 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult.ProtocolError) r3     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transactions.ErrorData r3 = r3.getData()     // Catch:{ all -> 0x0045 }
            r4.executeAsync(r3)     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult$End r3 = new com.stripe.android.stripe3ds2.transaction.InitChallengeResult$End     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.ChallengeResult$ProtocolError r4 = new com.stripe.android.stripe3ds2.transaction.ChallengeResult$ProtocolError     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult$ProtocolError r0 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult.ProtocolError) r0     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transactions.ErrorData r0 = r0.getData()     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.IntentData r5 = r7.getIntentData$3ds2sdk_release()     // Catch:{ all -> 0x0045 }
            r4.<init>(r0, r6, r5)     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.ChallengeResult r4 = (com.stripe.android.stripe3ds2.transaction.ChallengeResult) r4     // Catch:{ all -> 0x0045 }
            r3.<init>(r4)     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult r3 = (com.stripe.android.stripe3ds2.transaction.InitChallengeResult) r3     // Catch:{ all -> 0x0045 }
            goto L_0x016e
        L_0x0131:
            boolean r3 = r0 instanceof com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult.Timeout     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0152
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult$Timeout r0 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult.Timeout) r0     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transactions.ErrorData r0 = r0.getData()     // Catch:{ all -> 0x0045 }
            r4.executeAsync(r0)     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult$End r0 = new com.stripe.android.stripe3ds2.transaction.InitChallengeResult$End     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.ChallengeResult$Timeout r3 = new com.stripe.android.stripe3ds2.transaction.ChallengeResult$Timeout     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.IntentData r4 = r7.getIntentData$3ds2sdk_release()     // Catch:{ all -> 0x0045 }
            r3.<init>(r6, r6, r4)     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.ChallengeResult r3 = (com.stripe.android.stripe3ds2.transaction.ChallengeResult) r3     // Catch:{ all -> 0x0045 }
            r0.<init>(r3)     // Catch:{ all -> 0x0045 }
            r3 = r0
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult r3 = (com.stripe.android.stripe3ds2.transaction.InitChallengeResult) r3     // Catch:{ all -> 0x0045 }
            goto L_0x016e
        L_0x0152:
            boolean r3 = r0 instanceof com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult.RuntimeError     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0173
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult$End r3 = new com.stripe.android.stripe3ds2.transaction.InitChallengeResult$End     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.ChallengeResult$RuntimeError r4 = new com.stripe.android.stripe3ds2.transaction.ChallengeResult$RuntimeError     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult$RuntimeError r0 = (com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult.RuntimeError) r0     // Catch:{ all -> 0x0045 }
            java.lang.Throwable r0 = r0.getThrowable()     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.IntentData r5 = r7.getIntentData$3ds2sdk_release()     // Catch:{ all -> 0x0045 }
            r4.<init>(r0, r6, r5)     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.ChallengeResult r4 = (com.stripe.android.stripe3ds2.transaction.ChallengeResult) r4     // Catch:{ all -> 0x0045 }
            r3.<init>(r4)     // Catch:{ all -> 0x0045 }
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult r3 = (com.stripe.android.stripe3ds2.transaction.InitChallengeResult) r3     // Catch:{ all -> 0x0045 }
        L_0x016e:
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r3)     // Catch:{ all -> 0x0045 }
            goto L_0x0197
        L_0x0173:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0045 }
            r0.<init>()     // Catch:{ all -> 0x0045 }
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x0179:
            r7 = r17
            java.lang.String r0 = "Required value was null."
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0187 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0187 }
            r2.<init>(r0)     // Catch:{ all -> 0x0187 }
            throw r2     // Catch:{ all -> 0x0187 }
        L_0x0187:
            r0 = move-exception
            goto L_0x018c
        L_0x0189:
            r0 = move-exception
            r7 = r17
        L_0x018c:
            r2 = r1
        L_0x018d:
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0197:
            java.lang.Throwable r3 = kotlin.Result.m4712exceptionOrNullimpl(r0)
            if (r3 != 0) goto L_0x019e
            goto L_0x01bc
        L_0x019e:
            com.stripe.android.stripe3ds2.observability.ErrorReporter r0 = r2.errorReporter
            r0.reportError(r3)
            com.stripe.android.stripe3ds2.transaction.Logger r0 = r2.logger
            java.lang.String r2 = "Exception during initial challenge request."
            r0.error(r2, r3)
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult$End r0 = new com.stripe.android.stripe3ds2.transaction.InitChallengeResult$End
            com.stripe.android.stripe3ds2.transaction.ChallengeResult$RuntimeError r2 = new com.stripe.android.stripe3ds2.transaction.ChallengeResult$RuntimeError
            com.stripe.android.stripe3ds2.transaction.IntentData r4 = r7.getIntentData$3ds2sdk_release()
            r2.<init>(r3, r6, r4)
            com.stripe.android.stripe3ds2.transaction.ChallengeResult r2 = (com.stripe.android.stripe3ds2.transaction.ChallengeResult) r2
            r0.<init>(r2)
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult r0 = (com.stripe.android.stripe3ds2.transaction.InitChallengeResult) r0
        L_0x01bc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transaction.DefaultInitChallengeRepository.startChallenge(com.stripe.android.stripe3ds2.transaction.InitChallengeArgs, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ChallengeRequestData createCreqData(SdkTransactionId sdkTransactionId2, ChallengeParameters challengeParameters) {
        String acsTransactionId = challengeParameters.getAcsTransactionId();
        if (acsTransactionId != null) {
            String threeDsServerTransactionId = challengeParameters.getThreeDsServerTransactionId();
            if (threeDsServerTransactionId != null) {
                return new ChallengeRequestData(this.messageVersionRegistry.getCurrent(), threeDsServerTransactionId, acsTransactionId, sdkTransactionId2, (String) null, (ChallengeRequestData.CancelReason) null, (String) null, (List) null, (Boolean) null, (Boolean) null, 1008, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
