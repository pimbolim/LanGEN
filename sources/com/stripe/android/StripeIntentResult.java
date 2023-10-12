package com.stripe.android;

import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.StripeIntent;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b'\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003:\u0001\u0019B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00058F¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/StripeIntentResult;", "T", "Lcom/stripe/android/model/StripeIntent;", "Lcom/stripe/android/core/model/StripeModel;", "outcomeFromFlow", "", "(I)V", "failureMessage", "", "getFailureMessage", "()Ljava/lang/String;", "intent", "getIntent", "()Lcom/stripe/android/model/StripeIntent;", "outcome", "getOutcome$annotations", "()V", "getOutcome", "()I", "determineOutcome", "stripeIntentStatus", "Lcom/stripe/android/model/StripeIntent$Status;", "isNextActionSuccessState", "", "nextAction", "Outcome", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeIntentResult.kt */
public abstract class StripeIntentResult<T extends StripeIntent> implements StripeModel {
    public static final int $stable = 0;
    private final int outcomeFromFlow;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeIntentResult.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[StripeIntent.Status.values().length];
            iArr[StripeIntent.Status.RequiresAction.ordinal()] = 1;
            iArr[StripeIntent.Status.Canceled.ordinal()] = 2;
            iArr[StripeIntent.Status.RequiresPaymentMethod.ordinal()] = 3;
            iArr[StripeIntent.Status.Succeeded.ordinal()] = 4;
            iArr[StripeIntent.Status.RequiresCapture.ordinal()] = 5;
            iArr[StripeIntent.Status.RequiresConfirmation.ordinal()] = 6;
            iArr[StripeIntent.Status.Processing.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[StripeIntent.NextActionType.values().length];
            iArr2[StripeIntent.NextActionType.RedirectToUrl.ordinal()] = 1;
            iArr2[StripeIntent.NextActionType.UseStripeSdk.ordinal()] = 2;
            iArr2[StripeIntent.NextActionType.AlipayRedirect.ordinal()] = 3;
            iArr2[StripeIntent.NextActionType.BlikAuthorize.ordinal()] = 4;
            iArr2[StripeIntent.NextActionType.WeChatPayRedirect.ordinal()] = 5;
            iArr2[StripeIntent.NextActionType.DisplayOxxoDetails.ordinal()] = 6;
            iArr2[StripeIntent.NextActionType.VerifyWithMicrodeposits.ordinal()] = 7;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static /* synthetic */ void getOutcome$annotations() {
    }

    public abstract String getFailureMessage();

    public abstract T getIntent();

    public StripeIntentResult(int i) {
        this.outcomeFromFlow = i;
    }

    public final int getOutcome() {
        return determineOutcome(getIntent().getStatus(), this.outcomeFromFlow);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        r3 = r3.type;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        return 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int determineOutcome(com.stripe.android.model.StripeIntent.Status r3, int r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L_0x0003
            return r4
        L_0x0003:
            if (r3 != 0) goto L_0x0007
            r3 = -1
            goto L_0x000f
        L_0x0007:
            int[] r4 = com.stripe.android.StripeIntentResult.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r4[r3]
        L_0x000f:
            r4 = 3
            r0 = 0
            r1 = 1
            switch(r3) {
                case 1: goto L_0x0035;
                case 2: goto L_0x0040;
                case 3: goto L_0x0033;
                case 4: goto L_0x0031;
                case 5: goto L_0x0031;
                case 6: goto L_0x0031;
                case 7: goto L_0x0017;
                default: goto L_0x0015;
            }
        L_0x0015:
            r4 = 0
            goto L_0x0040
        L_0x0017:
            com.stripe.android.model.StripeIntent r3 = r2.getIntent()
            com.stripe.android.model.PaymentMethod r3 = r3.getPaymentMethod()
            if (r3 != 0) goto L_0x0023
        L_0x0021:
            r3 = 0
            goto L_0x002f
        L_0x0023:
            com.stripe.android.model.PaymentMethod$Type r3 = r3.type
            if (r3 != 0) goto L_0x0028
            goto L_0x0021
        L_0x0028:
            boolean r3 = r3.hasDelayedSettlement()
            if (r3 != r1) goto L_0x0021
            r3 = 1
        L_0x002f:
            if (r3 == 0) goto L_0x0015
        L_0x0031:
            r4 = 1
            goto L_0x0040
        L_0x0033:
            r4 = 2
            goto L_0x0040
        L_0x0035:
            com.stripe.android.model.StripeIntent r3 = r2.getIntent()
            boolean r3 = r2.isNextActionSuccessState(r3)
            if (r3 == 0) goto L_0x0040
            goto L_0x0031
        L_0x0040:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.StripeIntentResult.determineOutcome(com.stripe.android.model.StripeIntent$Status, int):int");
    }

    private final boolean isNextActionSuccessState(StripeIntent stripeIntent) {
        StripeIntent.NextActionType nextActionType = stripeIntent.getNextActionType();
        switch (nextActionType == null ? -1 : WhenMappings.$EnumSwitchMapping$1[nextActionType.ordinal()]) {
            case -1:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return false;
            case 6:
            case 7:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/StripeIntentResult$Outcome;", "", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: StripeIntentResult.kt */
    public @interface Outcome {
        public static final int CANCELED = 3;
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int FAILED = 2;
        public static final int SUCCEEDED = 1;
        public static final int TIMEDOUT = 4;
        public static final int UNKNOWN = 0;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/StripeIntentResult$Outcome$Companion;", "", "()V", "CANCELED", "", "FAILED", "SUCCEEDED", "TIMEDOUT", "UNKNOWN", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeIntentResult.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int CANCELED = 3;
            public static final int FAILED = 2;
            public static final int SUCCEEDED = 1;
            public static final int TIMEDOUT = 4;
            public static final int UNKNOWN = 0;

            private Companion() {
            }
        }
    }
}
