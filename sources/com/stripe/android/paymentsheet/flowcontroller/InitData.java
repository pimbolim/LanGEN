package com.stripe.android.paymentsheet.flowcontroller;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.model.ClientSecret;
import com.stripe.android.paymentsheet.model.SavedSelection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J\t\u0010 \u001a\u00020\u000eHÆ\u0003JM\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0013\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020#HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0014R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/InitData;", "Landroid/os/Parcelable;", "config", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "paymentMethods", "", "Lcom/stripe/android/model/PaymentMethod;", "savedSelection", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "isGooglePayReady", "", "(Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;Lcom/stripe/android/paymentsheet/model/ClientSecret;Lcom/stripe/android/model/StripeIntent;Ljava/util/List;Lcom/stripe/android/paymentsheet/model/SavedSelection;Z)V", "getClientSecret", "()Lcom/stripe/android/paymentsheet/model/ClientSecret;", "getConfig", "()Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "()Z", "getPaymentMethods", "()Ljava/util/List;", "getSavedSelection", "()Lcom/stripe/android/paymentsheet/model/SavedSelection;", "getStripeIntent", "()Lcom/stripe/android/model/StripeIntent;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InitData.kt */
public final class InitData implements Parcelable {
    public static final Parcelable.Creator<InitData> CREATOR = new Creator();
    private final ClientSecret clientSecret;
    private final PaymentSheet.Configuration config;
    private final boolean isGooglePayReady;
    private final List<PaymentMethod> paymentMethods;
    private final SavedSelection savedSelection;
    private final StripeIntent stripeIntent;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InitData.kt */
    public static final class Creator implements Parcelable.Creator<InitData> {
        public final InitData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            PaymentSheet.Configuration createFromParcel = parcel.readInt() == 0 ? null : PaymentSheet.Configuration.CREATOR.createFromParcel(parcel);
            ClientSecret clientSecret = (ClientSecret) parcel.readParcelable(InitData.class.getClassLoader());
            StripeIntent stripeIntent = (StripeIntent) parcel.readParcelable(InitData.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(parcel.readParcelable(InitData.class.getClassLoader()));
            }
            return new InitData(createFromParcel, clientSecret, stripeIntent, arrayList, (SavedSelection) parcel.readParcelable(InitData.class.getClassLoader()), parcel.readInt() != 0);
        }

        public final InitData[] newArray(int i) {
            return new InitData[i];
        }
    }

    public static /* synthetic */ InitData copy$default(InitData initData, PaymentSheet.Configuration configuration, ClientSecret clientSecret2, StripeIntent stripeIntent2, List<PaymentMethod> list, SavedSelection savedSelection2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            configuration = initData.config;
        }
        if ((i & 2) != 0) {
            clientSecret2 = initData.clientSecret;
        }
        ClientSecret clientSecret3 = clientSecret2;
        if ((i & 4) != 0) {
            stripeIntent2 = initData.stripeIntent;
        }
        StripeIntent stripeIntent3 = stripeIntent2;
        if ((i & 8) != 0) {
            list = initData.paymentMethods;
        }
        List<PaymentMethod> list2 = list;
        if ((i & 16) != 0) {
            savedSelection2 = initData.savedSelection;
        }
        SavedSelection savedSelection3 = savedSelection2;
        if ((i & 32) != 0) {
            z = initData.isGooglePayReady;
        }
        return initData.copy(configuration, clientSecret3, stripeIntent3, list2, savedSelection3, z);
    }

    public final PaymentSheet.Configuration component1() {
        return this.config;
    }

    public final ClientSecret component2() {
        return this.clientSecret;
    }

    public final StripeIntent component3() {
        return this.stripeIntent;
    }

    public final List<PaymentMethod> component4() {
        return this.paymentMethods;
    }

    public final SavedSelection component5() {
        return this.savedSelection;
    }

    public final boolean component6() {
        return this.isGooglePayReady;
    }

    public final InitData copy(PaymentSheet.Configuration configuration, ClientSecret clientSecret2, StripeIntent stripeIntent2, List<PaymentMethod> list, SavedSelection savedSelection2, boolean z) {
        Intrinsics.checkNotNullParameter(clientSecret2, "clientSecret");
        Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
        Intrinsics.checkNotNullParameter(list, "paymentMethods");
        Intrinsics.checkNotNullParameter(savedSelection2, "savedSelection");
        return new InitData(configuration, clientSecret2, stripeIntent2, list, savedSelection2, z);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitData)) {
            return false;
        }
        InitData initData = (InitData) obj;
        return Intrinsics.areEqual((Object) this.config, (Object) initData.config) && Intrinsics.areEqual((Object) this.clientSecret, (Object) initData.clientSecret) && Intrinsics.areEqual((Object) this.stripeIntent, (Object) initData.stripeIntent) && Intrinsics.areEqual((Object) this.paymentMethods, (Object) initData.paymentMethods) && Intrinsics.areEqual((Object) this.savedSelection, (Object) initData.savedSelection) && this.isGooglePayReady == initData.isGooglePayReady;
    }

    public int hashCode() {
        PaymentSheet.Configuration configuration = this.config;
        int hashCode = (((((((((configuration == null ? 0 : configuration.hashCode()) * 31) + this.clientSecret.hashCode()) * 31) + this.stripeIntent.hashCode()) * 31) + this.paymentMethods.hashCode()) * 31) + this.savedSelection.hashCode()) * 31;
        boolean z = this.isGooglePayReady;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "InitData(config=" + this.config + ", clientSecret=" + this.clientSecret + ", stripeIntent=" + this.stripeIntent + ", paymentMethods=" + this.paymentMethods + ", savedSelection=" + this.savedSelection + ", isGooglePayReady=" + this.isGooglePayReady + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        PaymentSheet.Configuration configuration = this.config;
        if (configuration == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            configuration.writeToParcel(parcel, i);
        }
        parcel.writeParcelable(this.clientSecret, i);
        parcel.writeParcelable(this.stripeIntent, i);
        List<PaymentMethod> list = this.paymentMethods;
        parcel.writeInt(list.size());
        for (PaymentMethod writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i);
        }
        parcel.writeParcelable(this.savedSelection, i);
        parcel.writeInt(this.isGooglePayReady ? 1 : 0);
    }

    public InitData(PaymentSheet.Configuration configuration, ClientSecret clientSecret2, StripeIntent stripeIntent2, List<PaymentMethod> list, SavedSelection savedSelection2, boolean z) {
        Intrinsics.checkNotNullParameter(clientSecret2, "clientSecret");
        Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
        Intrinsics.checkNotNullParameter(list, "paymentMethods");
        Intrinsics.checkNotNullParameter(savedSelection2, "savedSelection");
        this.config = configuration;
        this.clientSecret = clientSecret2;
        this.stripeIntent = stripeIntent2;
        this.paymentMethods = list;
        this.savedSelection = savedSelection2;
        this.isGooglePayReady = z;
    }

    public final PaymentSheet.Configuration getConfig() {
        return this.config;
    }

    public final ClientSecret getClientSecret() {
        return this.clientSecret;
    }

    public final StripeIntent getStripeIntent() {
        return this.stripeIntent;
    }

    public final List<PaymentMethod> getPaymentMethods() {
        return this.paymentMethods;
    }

    public final SavedSelection getSavedSelection() {
        return this.savedSelection;
    }

    public final boolean isGooglePayReady() {
        return this.isGooglePayReady;
    }
}
