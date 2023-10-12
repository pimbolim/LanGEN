package com.stripe.android;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.PaymentIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÂ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/PaymentIntentResult;", "Lcom/stripe/android/StripeIntentResult;", "Lcom/stripe/android/model/PaymentIntent;", "intent", "outcomeFromFlow", "", "failureMessage", "", "(Lcom/stripe/android/model/PaymentIntent;ILjava/lang/String;)V", "getFailureMessage", "()Ljava/lang/String;", "getIntent", "()Lcom/stripe/android/model/PaymentIntent;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentIntentResult.kt */
public final class PaymentIntentResult extends StripeIntentResult<PaymentIntent> {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaymentIntentResult> CREATOR = new Creator();
    private final String failureMessage;
    private final PaymentIntent intent;
    private final int outcomeFromFlow;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentIntentResult.kt */
    public static final class Creator implements Parcelable.Creator<PaymentIntentResult> {
        public final PaymentIntentResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PaymentIntentResult(PaymentIntent.CREATOR.createFromParcel(parcel), parcel.readInt(), parcel.readString());
        }

        public final PaymentIntentResult[] newArray(int i) {
            return new PaymentIntentResult[i];
        }
    }

    private final int component2() {
        return this.outcomeFromFlow;
    }

    public static /* synthetic */ PaymentIntentResult copy$default(PaymentIntentResult paymentIntentResult, PaymentIntent paymentIntent, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            paymentIntent = paymentIntentResult.getIntent();
        }
        if ((i2 & 2) != 0) {
            i = paymentIntentResult.outcomeFromFlow;
        }
        if ((i2 & 4) != 0) {
            str = paymentIntentResult.getFailureMessage();
        }
        return paymentIntentResult.copy(paymentIntent, i, str);
    }

    public final PaymentIntent component1() {
        return getIntent();
    }

    public final String component3() {
        return getFailureMessage();
    }

    public final PaymentIntentResult copy(PaymentIntent paymentIntent, int i, String str) {
        Intrinsics.checkNotNullParameter(paymentIntent, "intent");
        return new PaymentIntentResult(paymentIntent, i, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentIntentResult)) {
            return false;
        }
        PaymentIntentResult paymentIntentResult = (PaymentIntentResult) obj;
        return Intrinsics.areEqual((Object) getIntent(), (Object) paymentIntentResult.getIntent()) && this.outcomeFromFlow == paymentIntentResult.outcomeFromFlow && Intrinsics.areEqual((Object) getFailureMessage(), (Object) paymentIntentResult.getFailureMessage());
    }

    public int hashCode() {
        return (((getIntent().hashCode() * 31) + this.outcomeFromFlow) * 31) + (getFailureMessage() == null ? 0 : getFailureMessage().hashCode());
    }

    public String toString() {
        return "PaymentIntentResult(intent=" + getIntent() + ", outcomeFromFlow=" + this.outcomeFromFlow + ", failureMessage=" + getFailureMessage() + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.intent.writeToParcel(parcel, i);
        parcel.writeInt(this.outcomeFromFlow);
        parcel.writeString(this.failureMessage);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentIntentResult(PaymentIntent paymentIntent, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(paymentIntent, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : str);
    }

    public PaymentIntent getIntent() {
        return this.intent;
    }

    public String getFailureMessage() {
        return this.failureMessage;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentIntentResult(PaymentIntent paymentIntent, int i, String str) {
        super(i);
        Intrinsics.checkNotNullParameter(paymentIntent, "intent");
        this.intent = paymentIntent;
        this.outcomeFromFlow = i;
        this.failureMessage = str;
    }
}
