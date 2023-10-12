package com.stripe.android.stripe3ds2.transaction;

import com.nimbusds.jose.JOSEException;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.security.MessageTransformer;
import com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor;
import com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseData;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseParseException;
import com.stripe.android.stripe3ds2.transactions.ErrorData;
import com.stripe.android.stripe3ds2.transactions.ProtocolError;
import java.text.ParseException;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001:\u0001\tJ!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeResponseProcessor;", "", "process", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "creqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "response", "Lcom/stripe/android/stripe3ds2/transaction/HttpResponse;", "(Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;Lcom/stripe/android/stripe3ds2/transaction/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Default", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeResponseProcessor.kt */
public interface ChallengeResponseProcessor {
    Object process(ChallengeRequestData challengeRequestData, HttpResponse httpResponse, Continuation<? super ChallengeRequestResult> continuation);

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0015H\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeResponseProcessor$Default;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResponseProcessor;", "messageTransformer", "Lcom/stripe/android/stripe3ds2/security/MessageTransformer;", "secretKey", "Ljavax/crypto/SecretKey;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "creqExecutorConfig", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config;", "(Lcom/stripe/android/stripe3ds2/security/MessageTransformer;Ljavax/crypto/SecretKey;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config;)V", "createErrorData", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "creqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "code", "", "description", "", "detail", "getResponsePayload", "Lorg/json/JSONObject;", "responseBody", "isMessageVersionCorrect", "", "cresData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData;", "isValidChallengeResponse", "process", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "response", "Lcom/stripe/android/stripe3ds2/transaction/HttpResponse;", "(Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;Lcom/stripe/android/stripe3ds2/transaction/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processPayload", "payload", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResponseProcessor.kt */
    public static final class Default implements ChallengeResponseProcessor {
        private final ChallengeRequestExecutor.Config creqExecutorConfig;
        private final ErrorReporter errorReporter;
        private final MessageTransformer messageTransformer;
        private final SecretKey secretKey;

        public Default(MessageTransformer messageTransformer2, SecretKey secretKey2, ErrorReporter errorReporter2, ChallengeRequestExecutor.Config config) {
            Intrinsics.checkNotNullParameter(messageTransformer2, "messageTransformer");
            Intrinsics.checkNotNullParameter(secretKey2, "secretKey");
            Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
            Intrinsics.checkNotNullParameter(config, "creqExecutorConfig");
            this.messageTransformer = messageTransformer2;
            this.secretKey = secretKey2;
            this.errorReporter = errorReporter2;
            this.creqExecutorConfig = config;
        }

        public Object process(ChallengeRequestData challengeRequestData, HttpResponse httpResponse, Continuation<? super ChallengeRequestResult> continuation) {
            Object obj;
            ChallengeRequestResult.Failure failure;
            if (httpResponse.isJsonContentType()) {
                JSONObject jSONObject = new JSONObject(httpResponse.getContent());
                if (ErrorData.Companion.isErrorMessage$3ds2sdk_release(jSONObject)) {
                    failure = new ChallengeRequestResult.ProtocolError(ErrorData.Companion.fromJson$3ds2sdk_release(jSONObject));
                } else {
                    failure = new ChallengeRequestResult.RuntimeError(new IllegalArgumentException("Received a JSON response that was not an Error message."));
                }
                return failure;
            }
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m4709constructorimpl(getResponsePayload(httpResponse.getContent()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            Throwable r7 = Result.m4712exceptionOrNullimpl(obj);
            if (r7 != null) {
                ErrorReporter errorReporter2 = this.errorReporter;
                errorReporter2.reportError(new RuntimeException(StringsKt.trimIndent("\n                            Failed to process challenge response.\n\n                            CReq = " + challengeRequestData.sanitize$3ds2sdk_release() + "\n                            "), r7));
            }
            Throwable r72 = Result.m4712exceptionOrNullimpl(obj);
            if (r72 == null) {
                return processPayload(challengeRequestData, (JSONObject) obj);
            }
            ProtocolError protocolError = ProtocolError.DataDecryptionFailure;
            int code = protocolError.getCode();
            String description = protocolError.getDescription();
            String message = r72.getMessage();
            if (message == null) {
                message = "";
            }
            return new ChallengeRequestResult.ProtocolError(createErrorData(challengeRequestData, code, description, message));
        }

        public final ChallengeRequestResult processPayload(ChallengeRequestData challengeRequestData, JSONObject jSONObject) {
            Object obj;
            ChallengeRequestResult.Failure failure;
            ChallengeRequestResult success;
            Intrinsics.checkNotNullParameter(challengeRequestData, "creqData");
            Intrinsics.checkNotNullParameter(jSONObject, "payload");
            if (ErrorData.Companion.isErrorMessage$3ds2sdk_release(jSONObject)) {
                return new ChallengeRequestResult.ProtocolError(ErrorData.Companion.fromJson$3ds2sdk_release(jSONObject));
            }
            try {
                Result.Companion companion = Result.Companion;
                Default defaultR = this;
                obj = Result.m4709constructorimpl(ChallengeResponseData.Companion.fromJson$3ds2sdk_release(jSONObject));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            Throwable r0 = Result.m4712exceptionOrNullimpl(obj);
            if (r0 == null) {
                ChallengeResponseData challengeResponseData = (ChallengeResponseData) obj;
                if (!isValidChallengeResponse(challengeRequestData, challengeResponseData)) {
                    ProtocolError protocolError = ProtocolError.InvalidTransactionId;
                    success = new ChallengeRequestResult.ProtocolError(createErrorData(challengeRequestData, protocolError.getCode(), protocolError.getDescription(), "The Transaction ID received was invalid."));
                } else if (!isMessageVersionCorrect(challengeRequestData, challengeResponseData)) {
                    return new ChallengeRequestResult.ProtocolError(createErrorData(challengeRequestData, ProtocolError.UnsupportedMessageVersion.getCode(), ProtocolError.UnsupportedMessageVersion.getDescription(), challengeRequestData.getMessageVersion()));
                } else {
                    success = new ChallengeRequestResult.Success(challengeRequestData, challengeResponseData, this.creqExecutorConfig);
                }
                return success;
            }
            if (r0 instanceof ChallengeResponseParseException) {
                ChallengeResponseParseException challengeResponseParseException = (ChallengeResponseParseException) r0;
                failure = new ChallengeRequestResult.ProtocolError(createErrorData(challengeRequestData, challengeResponseParseException.getCode(), challengeResponseParseException.getDescription(), challengeResponseParseException.getDetail()));
            } else {
                failure = new ChallengeRequestResult.RuntimeError(r0);
            }
            return failure;
        }

        private final boolean isValidChallengeResponse(ChallengeRequestData challengeRequestData, ChallengeResponseData challengeResponseData) {
            return Intrinsics.areEqual((Object) challengeRequestData.getSdkTransId(), (Object) challengeResponseData.getSdkTransId()) && Intrinsics.areEqual((Object) challengeRequestData.getThreeDsServerTransId(), (Object) challengeResponseData.getServerTransId()) && Intrinsics.areEqual((Object) challengeRequestData.getAcsTransId(), (Object) challengeResponseData.getAcsTransId());
        }

        private final boolean isMessageVersionCorrect(ChallengeRequestData challengeRequestData, ChallengeResponseData challengeResponseData) {
            return Intrinsics.areEqual((Object) challengeRequestData.getMessageVersion(), (Object) challengeResponseData.getMessageVersion());
        }

        private final JSONObject getResponsePayload(String str) throws ParseException, JOSEException, JSONException, ChallengeResponseParseException {
            return this.messageTransformer.decrypt(str, this.secretKey);
        }

        private final ErrorData createErrorData(ChallengeRequestData challengeRequestData, int i, String str, String str2) {
            String valueOf = String.valueOf(i);
            ErrorData.ErrorComponent errorComponent = ErrorData.ErrorComponent.ThreeDsSdk;
            return new ErrorData(challengeRequestData.getThreeDsServerTransId(), challengeRequestData.getAcsTransId(), (String) null, valueOf, errorComponent, str, str2, ChallengeResponseData.MESSAGE_TYPE, challengeRequestData.getMessageVersion(), challengeRequestData.getSdkTransId(), 4, (DefaultConstructorMarker) null);
        }
    }
}
