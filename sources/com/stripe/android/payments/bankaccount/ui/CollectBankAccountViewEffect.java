package com.stripe.android.payments.bankaccount.ui;

import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect;", "", "()V", "FinishWithResult", "OpenConnectionsFlow", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect$OpenConnectionsFlow;", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect$FinishWithResult;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountViewEffect.kt */
public abstract class CollectBankAccountViewEffect {
    public /* synthetic */ CollectBankAccountViewEffect(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CollectBankAccountViewEffect() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect$OpenConnectionsFlow;", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect;", "publishableKey", "", "linkedAccountSessionClientSecret", "(Ljava/lang/String;Ljava/lang/String;)V", "getLinkedAccountSessionClientSecret", "()Ljava/lang/String;", "getPublishableKey", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectBankAccountViewEffect.kt */
    public static final class OpenConnectionsFlow extends CollectBankAccountViewEffect {
        public static final int $stable = 0;
        private final String linkedAccountSessionClientSecret;
        private final String publishableKey;

        public static /* synthetic */ OpenConnectionsFlow copy$default(OpenConnectionsFlow openConnectionsFlow, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = openConnectionsFlow.publishableKey;
            }
            if ((i & 2) != 0) {
                str2 = openConnectionsFlow.linkedAccountSessionClientSecret;
            }
            return openConnectionsFlow.copy(str, str2);
        }

        public final String component1() {
            return this.publishableKey;
        }

        public final String component2() {
            return this.linkedAccountSessionClientSecret;
        }

        public final OpenConnectionsFlow copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            Intrinsics.checkNotNullParameter(str2, "linkedAccountSessionClientSecret");
            return new OpenConnectionsFlow(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OpenConnectionsFlow)) {
                return false;
            }
            OpenConnectionsFlow openConnectionsFlow = (OpenConnectionsFlow) obj;
            return Intrinsics.areEqual((Object) this.publishableKey, (Object) openConnectionsFlow.publishableKey) && Intrinsics.areEqual((Object) this.linkedAccountSessionClientSecret, (Object) openConnectionsFlow.linkedAccountSessionClientSecret);
        }

        public int hashCode() {
            return (this.publishableKey.hashCode() * 31) + this.linkedAccountSessionClientSecret.hashCode();
        }

        public String toString() {
            return "OpenConnectionsFlow(publishableKey=" + this.publishableKey + ", linkedAccountSessionClientSecret=" + this.linkedAccountSessionClientSecret + ')';
        }

        public final String getPublishableKey() {
            return this.publishableKey;
        }

        public final String getLinkedAccountSessionClientSecret() {
            return this.linkedAccountSessionClientSecret;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenConnectionsFlow(String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            Intrinsics.checkNotNullParameter(str2, "linkedAccountSessionClientSecret");
            this.publishableKey = str;
            this.linkedAccountSessionClientSecret = str2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect$FinishWithResult;", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect;", "result", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;", "(Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;)V", "getResult", "()Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectBankAccountViewEffect.kt */
    public static final class FinishWithResult extends CollectBankAccountViewEffect {
        public static final int $stable = 0;
        private final CollectBankAccountResult result;

        public static /* synthetic */ FinishWithResult copy$default(FinishWithResult finishWithResult, CollectBankAccountResult collectBankAccountResult, int i, Object obj) {
            if ((i & 1) != 0) {
                collectBankAccountResult = finishWithResult.result;
            }
            return finishWithResult.copy(collectBankAccountResult);
        }

        public final CollectBankAccountResult component1() {
            return this.result;
        }

        public final FinishWithResult copy(CollectBankAccountResult collectBankAccountResult) {
            Intrinsics.checkNotNullParameter(collectBankAccountResult, "result");
            return new FinishWithResult(collectBankAccountResult);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FinishWithResult) && Intrinsics.areEqual((Object) this.result, (Object) ((FinishWithResult) obj).result);
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        public String toString() {
            return "FinishWithResult(result=" + this.result + ')';
        }

        public final CollectBankAccountResult getResult() {
            return this.result;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FinishWithResult(CollectBankAccountResult collectBankAccountResult) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(collectBankAccountResult, "result");
            this.result = collectBankAccountResult;
        }
    }
}
