package com.stripe.android.stripe3ds2.transaction;

import java.security.KeyPair;
import java.security.PublicKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeTransaction;", "Lcom/stripe/android/stripe3ds2/transaction/Transaction;", "areqParamsFactory", "Lcom/stripe/android/stripe3ds2/transaction/AuthenticationRequestParametersFactory;", "directoryServerId", "", "directoryServerPublicKey", "Ljava/security/PublicKey;", "directoryServerKeyId", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "sdkKeyPair", "Ljava/security/KeyPair;", "sdkReferenceNumber", "(Lcom/stripe/android/stripe3ds2/transaction/AuthenticationRequestParametersFactory;Ljava/lang/String;Ljava/security/PublicKey;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Ljava/security/KeyPair;Ljava/lang/String;)V", "getSdkTransactionId", "()Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "createAuthenticationRequestParameters", "Lcom/stripe/android/stripe3ds2/transaction/AuthenticationRequestParameters;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInitChallengeArgs", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeArgs;", "challengeParameters", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeParameters;", "timeoutMins", "", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeTransaction.kt */
public final class StripeTransaction implements Transaction {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MIN_TIMEOUT = 5;
    private final AuthenticationRequestParametersFactory areqParamsFactory;
    private final String directoryServerId;
    private final String directoryServerKeyId;
    private final PublicKey directoryServerPublicKey;
    private final KeyPair sdkKeyPair;
    private final String sdkReferenceNumber;
    private final SdkTransactionId sdkTransactionId;

    public StripeTransaction(AuthenticationRequestParametersFactory authenticationRequestParametersFactory, String str, PublicKey publicKey, String str2, SdkTransactionId sdkTransactionId2, KeyPair keyPair, String str3) {
        Intrinsics.checkNotNullParameter(authenticationRequestParametersFactory, "areqParamsFactory");
        Intrinsics.checkNotNullParameter(str, "directoryServerId");
        Intrinsics.checkNotNullParameter(publicKey, "directoryServerPublicKey");
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
        Intrinsics.checkNotNullParameter(keyPair, "sdkKeyPair");
        Intrinsics.checkNotNullParameter(str3, "sdkReferenceNumber");
        this.areqParamsFactory = authenticationRequestParametersFactory;
        this.directoryServerId = str;
        this.directoryServerPublicKey = publicKey;
        this.directoryServerKeyId = str2;
        this.sdkTransactionId = sdkTransactionId2;
        this.sdkKeyPair = keyPair;
        this.sdkReferenceNumber = str3;
    }

    public SdkTransactionId getSdkTransactionId() {
        return this.sdkTransactionId;
    }

    public Object createAuthenticationRequestParameters(Continuation<? super AuthenticationRequestParameters> continuation) {
        AuthenticationRequestParametersFactory authenticationRequestParametersFactory = this.areqParamsFactory;
        String str = this.directoryServerId;
        PublicKey publicKey = this.directoryServerPublicKey;
        String str2 = this.directoryServerKeyId;
        SdkTransactionId sdkTransactionId2 = getSdkTransactionId();
        PublicKey publicKey2 = this.sdkKeyPair.getPublic();
        Intrinsics.checkNotNullExpressionValue(publicKey2, "sdkKeyPair.public");
        return authenticationRequestParametersFactory.create(str, publicKey, str2, sdkTransactionId2, publicKey2, continuation);
    }

    public InitChallengeArgs createInitChallengeArgs(ChallengeParameters challengeParameters, int i, IntentData intentData) {
        Intrinsics.checkNotNullParameter(challengeParameters, "challengeParameters");
        Intrinsics.checkNotNullParameter(intentData, "intentData");
        return new InitChallengeArgs(this.sdkReferenceNumber, this.sdkKeyPair, challengeParameters, RangesKt.coerceAtLeast(i, 5), intentData);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeTransaction$Companion;", "", "()V", "MIN_TIMEOUT", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeTransaction.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
