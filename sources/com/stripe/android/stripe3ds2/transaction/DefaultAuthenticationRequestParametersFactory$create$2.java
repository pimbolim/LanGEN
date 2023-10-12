package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import com.stripe.android.stripe3ds2.init.AppInfo;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.security.PublicKey;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/stripe3ds2/transaction/AuthenticationRequestParameters;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.transaction.DefaultAuthenticationRequestParametersFactory$create$2", f = "DefaultAuthenticationRequestParametersFactory.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultAuthenticationRequestParametersFactory.kt */
final class DefaultAuthenticationRequestParametersFactory$create$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AuthenticationRequestParameters>, Object> {
    final /* synthetic */ String $directoryServerId;
    final /* synthetic */ PublicKey $directoryServerPublicKey;
    final /* synthetic */ String $keyId;
    final /* synthetic */ PublicKey $sdkPublicKey;
    final /* synthetic */ SdkTransactionId $sdkTransactionId;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DefaultAuthenticationRequestParametersFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultAuthenticationRequestParametersFactory$create$2(SdkTransactionId sdkTransactionId, DefaultAuthenticationRequestParametersFactory defaultAuthenticationRequestParametersFactory, PublicKey publicKey, String str, String str2, PublicKey publicKey2, Continuation<? super DefaultAuthenticationRequestParametersFactory$create$2> continuation) {
        super(2, continuation);
        this.$sdkTransactionId = sdkTransactionId;
        this.this$0 = defaultAuthenticationRequestParametersFactory;
        this.$sdkPublicKey = publicKey;
        this.$keyId = str;
        this.$directoryServerId = str2;
        this.$directoryServerPublicKey = publicKey2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultAuthenticationRequestParametersFactory$create$2 defaultAuthenticationRequestParametersFactory$create$2 = new DefaultAuthenticationRequestParametersFactory$create$2(this.$sdkTransactionId, this.this$0, this.$sdkPublicKey, this.$keyId, this.$directoryServerId, this.$directoryServerPublicKey, continuation);
        defaultAuthenticationRequestParametersFactory$create$2.L$0 = obj;
        return defaultAuthenticationRequestParametersFactory$create$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AuthenticationRequestParameters> continuation) {
        return ((DefaultAuthenticationRequestParametersFactory$create$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SdkTransactionId sdkTransactionId;
        String str;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            DefaultAuthenticationRequestParametersFactory defaultAuthenticationRequestParametersFactory = this.this$0;
            PublicKey publicKey = this.$directoryServerPublicKey;
            String str2 = this.$directoryServerId;
            String str3 = this.$keyId;
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.m4709constructorimpl(defaultAuthenticationRequestParametersFactory.jweEncrypter.encrypt(defaultAuthenticationRequestParametersFactory.getDeviceDataJson$3ds2sdk_release(), publicKey, str2, str3));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            DefaultAuthenticationRequestParametersFactory defaultAuthenticationRequestParametersFactory2 = this.this$0;
            String str4 = this.$directoryServerId;
            String str5 = this.$keyId;
            SdkTransactionId sdkTransactionId2 = this.$sdkTransactionId;
            Throwable r6 = Result.m4712exceptionOrNullimpl(obj2);
            if (r6 != null) {
                ErrorReporter access$getErrorReporter$p = defaultAuthenticationRequestParametersFactory2.errorReporter;
                access$getErrorReporter$p.reportError(new RuntimeException(StringsKt.trimIndent("\n                    Failed to encrypt AReq parameters.\n                        \n                    directoryServerId=" + str4 + "\n                    keyId=" + str5 + "\n                    sdkTransactionId=" + sdkTransactionId2 + "\n                    "), r6));
            }
            Throwable r1 = Result.m4712exceptionOrNullimpl(obj2);
            if (r1 == null) {
                str = (String) obj2;
                SdkTransactionId sdkTransactionId3 = this.$sdkTransactionId;
                this.L$0 = str;
                this.L$1 = sdkTransactionId3;
                this.label = 1;
                Object obj3 = this.this$0.appInfoRepository.get(this);
                if (obj3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Object obj4 = obj3;
                sdkTransactionId = sdkTransactionId3;
                obj = obj4;
            } else {
                throw new SDKRuntimeException(r1);
            }
        } else if (i == 1) {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            sdkTransactionId = (SdkTransactionId) this.L$1;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String sdkAppId = ((AppInfo) obj).getSdkAppId();
        String access$getSdkReferenceNumber$p = this.this$0.sdkReferenceNumber;
        String jSONString = DefaultAuthenticationRequestParametersFactory.Companion.createPublicJwk$3ds2sdk_release(this.$sdkPublicKey, this.$keyId, this.this$0.getKeyUse$3ds2sdk_release(this.$directoryServerId)).toJSONString();
        Intrinsics.checkNotNullExpressionValue(jSONString, "createPublicJwk(\n       …         ).toJSONString()");
        return new AuthenticationRequestParameters(str, sdkTransactionId, sdkAppId, access$getSdkReferenceNumber$p, jSONString, this.this$0.messageVersionRegistry.getCurrent());
    }
}
