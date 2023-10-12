package com.stripe.android.payments.bankaccount.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.StripeIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResponse;", "Lcom/stripe/android/core/model/StripeModel;", "intent", "Lcom/stripe/android/model/StripeIntent;", "(Lcom/stripe/android/model/StripeIntent;)V", "getIntent", "()Lcom/stripe/android/model/StripeIntent;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountResult.kt */
public final class CollectBankAccountResponse implements StripeModel {
    public static final int $stable = 0;
    public static final Parcelable.Creator<CollectBankAccountResponse> CREATOR = new Creator();
    private final StripeIntent intent;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectBankAccountResult.kt */
    public static final class Creator implements Parcelable.Creator<CollectBankAccountResponse> {
        public final CollectBankAccountResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CollectBankAccountResponse((StripeIntent) parcel.readParcelable(CollectBankAccountResponse.class.getClassLoader()));
        }

        public final CollectBankAccountResponse[] newArray(int i) {
            return new CollectBankAccountResponse[i];
        }
    }

    public static /* synthetic */ CollectBankAccountResponse copy$default(CollectBankAccountResponse collectBankAccountResponse, StripeIntent stripeIntent, int i, Object obj) {
        if ((i & 1) != 0) {
            stripeIntent = collectBankAccountResponse.intent;
        }
        return collectBankAccountResponse.copy(stripeIntent);
    }

    public final StripeIntent component1() {
        return this.intent;
    }

    public final CollectBankAccountResponse copy(StripeIntent stripeIntent) {
        Intrinsics.checkNotNullParameter(stripeIntent, "intent");
        return new CollectBankAccountResponse(stripeIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CollectBankAccountResponse) && Intrinsics.areEqual((Object) this.intent, (Object) ((CollectBankAccountResponse) obj).intent);
    }

    public int hashCode() {
        return this.intent.hashCode();
    }

    public String toString() {
        return "CollectBankAccountResponse(intent=" + this.intent + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.intent, i);
    }

    public CollectBankAccountResponse(StripeIntent stripeIntent) {
        Intrinsics.checkNotNullParameter(stripeIntent, "intent");
        this.intent = stripeIntent;
    }

    public final StripeIntent getIntent() {
        return this.intent;
    }
}
