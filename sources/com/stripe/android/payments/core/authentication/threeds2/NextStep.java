package com.stripe.android.payments.core.authentication.threeds2;

import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.stripe3ds2.transaction.InitChallengeArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/NextStep;", "", "()V", "Complete", "StartChallenge", "StartFallback", "Lcom/stripe/android/payments/core/authentication/threeds2/NextStep$StartChallenge;", "Lcom/stripe/android/payments/core/authentication/threeds2/NextStep$StartFallback;", "Lcom/stripe/android/payments/core/authentication/threeds2/NextStep$Complete;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2TransactionViewModel.kt */
public abstract class NextStep {
    public /* synthetic */ NextStep(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NextStep() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/NextStep$StartChallenge;", "Lcom/stripe/android/payments/core/authentication/threeds2/NextStep;", "args", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeArgs;", "(Lcom/stripe/android/stripe3ds2/transaction/InitChallengeArgs;)V", "getArgs", "()Lcom/stripe/android/stripe3ds2/transaction/InitChallengeArgs;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2TransactionViewModel.kt */
    public static final class StartChallenge extends NextStep {
        public static final int $stable = 8;
        private final InitChallengeArgs args;

        public static /* synthetic */ StartChallenge copy$default(StartChallenge startChallenge, InitChallengeArgs initChallengeArgs, int i, Object obj) {
            if ((i & 1) != 0) {
                initChallengeArgs = startChallenge.args;
            }
            return startChallenge.copy(initChallengeArgs);
        }

        public final InitChallengeArgs component1() {
            return this.args;
        }

        public final StartChallenge copy(InitChallengeArgs initChallengeArgs) {
            Intrinsics.checkNotNullParameter(initChallengeArgs, "args");
            return new StartChallenge(initChallengeArgs);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StartChallenge) && Intrinsics.areEqual((Object) this.args, (Object) ((StartChallenge) obj).args);
        }

        public int hashCode() {
            return this.args.hashCode();
        }

        public String toString() {
            return "StartChallenge(args=" + this.args + ')';
        }

        public final InitChallengeArgs getArgs() {
            return this.args;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StartChallenge(InitChallengeArgs initChallengeArgs) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(initChallengeArgs, "args");
            this.args = initChallengeArgs;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/NextStep$StartFallback;", "Lcom/stripe/android/payments/core/authentication/threeds2/NextStep;", "args", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "(Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;)V", "getArgs", "()Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2TransactionViewModel.kt */
    public static final class StartFallback extends NextStep {
        public static final int $stable = 8;
        private final PaymentBrowserAuthContract.Args args;

        public static /* synthetic */ StartFallback copy$default(StartFallback startFallback, PaymentBrowserAuthContract.Args args2, int i, Object obj) {
            if ((i & 1) != 0) {
                args2 = startFallback.args;
            }
            return startFallback.copy(args2);
        }

        public final PaymentBrowserAuthContract.Args component1() {
            return this.args;
        }

        public final StartFallback copy(PaymentBrowserAuthContract.Args args2) {
            Intrinsics.checkNotNullParameter(args2, "args");
            return new StartFallback(args2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StartFallback) && Intrinsics.areEqual((Object) this.args, (Object) ((StartFallback) obj).args);
        }

        public int hashCode() {
            return this.args.hashCode();
        }

        public String toString() {
            return "StartFallback(args=" + this.args + ')';
        }

        public final PaymentBrowserAuthContract.Args getArgs() {
            return this.args;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StartFallback(PaymentBrowserAuthContract.Args args2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(args2, "args");
            this.args = args2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/NextStep$Complete;", "Lcom/stripe/android/payments/core/authentication/threeds2/NextStep;", "result", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "(Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;)V", "getResult", "()Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2TransactionViewModel.kt */
    public static final class Complete extends NextStep {
        public static final int $stable = 8;
        private final PaymentFlowResult.Unvalidated result;

        public static /* synthetic */ Complete copy$default(Complete complete, PaymentFlowResult.Unvalidated unvalidated, int i, Object obj) {
            if ((i & 1) != 0) {
                unvalidated = complete.result;
            }
            return complete.copy(unvalidated);
        }

        public final PaymentFlowResult.Unvalidated component1() {
            return this.result;
        }

        public final Complete copy(PaymentFlowResult.Unvalidated unvalidated) {
            Intrinsics.checkNotNullParameter(unvalidated, "result");
            return new Complete(unvalidated);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Complete) && Intrinsics.areEqual((Object) this.result, (Object) ((Complete) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "Complete(result=" + this.result + ')';
        }

        public final PaymentFlowResult.Unvalidated getResult() {
            return this.result;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Complete(PaymentFlowResult.Unvalidated unvalidated) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(unvalidated, "result");
            this.result = unvalidated;
        }
    }
}
