package com.stripe.android.stripe3ds2.transaction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/Transaction;", "", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "getSdkTransactionId", "()Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "createAuthenticationRequestParameters", "Lcom/stripe/android/stripe3ds2/transaction/AuthenticationRequestParameters;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInitChallengeArgs", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeArgs;", "challengeParameters", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeParameters;", "timeoutMins", "", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Transaction.kt */
public interface Transaction {
    Object createAuthenticationRequestParameters(Continuation<? super AuthenticationRequestParameters> continuation);

    InitChallengeArgs createInitChallengeArgs(ChallengeParameters challengeParameters, int i, IntentData intentData);

    SdkTransactionId getSdkTransactionId();
}
