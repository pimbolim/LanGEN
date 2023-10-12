package com.stripe.android.paymentsheet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.paymentsheet.forms.Delayed;
import com.stripe.android.paymentsheet.forms.PaymentMethodRequirements;
import com.stripe.android.paymentsheet.forms.PaymentMethodRequirementsKt;
import com.stripe.android.paymentsheet.forms.SIRequirement;
import com.stripe.android.ui.core.elements.LayoutFormDescriptor;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.forms.AffirmSpecKt;
import com.stripe.android.ui.core.forms.AfterpayClearpaySpecKt;
import com.stripe.android.ui.core.forms.AuBecsDebitSpecKt;
import com.stripe.android.ui.core.forms.BancontactSpecKt;
import com.stripe.android.ui.core.forms.CardSpecKt;
import com.stripe.android.ui.core.forms.EpsSpecKt;
import com.stripe.android.ui.core.forms.GiropaySpecKt;
import com.stripe.android.ui.core.forms.IdealSpecKt;
import com.stripe.android.ui.core.forms.KlarnaSpecKt;
import com.stripe.android.ui.core.forms.P24SpecKt;
import com.stripe.android.ui.core.forms.PaypalSpecKt;
import com.stripe.android.ui.core.forms.SepaDebitSpecKt;
import com.stripe.android.ui.core.forms.SofortSpecKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 52\u00020\u0001:\u000e0123456789:;<=BI\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ*\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\"\u0010\"\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010 \u001a\u0004\u0018\u00010!J!\u0010(\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010 \u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0002\b)J\u0006\u0010*\u001a\u00020\u001aJ\u001a\u0010+\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u001a\u0010,\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u001a\u0010-\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010.\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010/\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u0001\r>?@ABCDEFGHIJ¨\u0006K"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "Landroid/os/Parcelable;", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "displayNameResource", "", "iconResource", "requirement", "Lcom/stripe/android/paymentsheet/forms/PaymentMethodRequirements;", "paramKey", "", "", "", "formSpec", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "(Lcom/stripe/android/model/PaymentMethod$Type;IILcom/stripe/android/paymentsheet/forms/PaymentMethodRequirements;Ljava/util/Map;Lcom/stripe/android/ui/core/elements/LayoutSpec;)V", "getDisplayNameResource", "()I", "getFormSpec", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getIconResource", "getParamKey", "()Ljava/util/Map;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "checkPaymentIntentRequirements", "", "requirements", "", "Lcom/stripe/android/paymentsheet/forms/PIRequirement;", "paymentIntent", "Lcom/stripe/android/model/PaymentIntent;", "config", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "checkSetupIntentRequirements", "Lcom/stripe/android/paymentsheet/forms/SIRequirement;", "getPMAddForm", "Lcom/stripe/android/ui/core/elements/LayoutFormDescriptor;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "getSpecWithFullfilledRequirements", "getSpecWithFullfilledRequirements$paymentsheet_release", "supportsCustomerSavedPM", "supportsPaymentIntentSfuNotSettable", "supportsPaymentIntentSfuSet", "supportsPaymentIntentSfuSettable", "supportsSetupIntent", "toString", "Affirm", "AfterpayClearpay", "AuBecsDebit", "Bancontact", "Card", "Companion", "Eps", "Giropay", "Ideal", "Klarna", "P24", "PayPal", "SepaDebit", "Sofort", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Card;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Bancontact;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Sofort;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Ideal;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$SepaDebit;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Eps;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$P24;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Giropay;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$AfterpayClearpay;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Klarna;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$PayPal;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Affirm;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$AuBecsDebit;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SupportedPaymentMethod.kt */
public abstract class SupportedPaymentMethod implements Parcelable {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<List<SupportedPaymentMethod>> exposedPaymentMethods$delegate = LazyKt.lazy(SupportedPaymentMethod$Companion$exposedPaymentMethods$2.INSTANCE);
    private final int displayNameResource;
    private final LayoutSpec formSpec;
    private final int iconResource;
    private final Map<String, Object> paramKey;
    private final PaymentMethodRequirements requirement;
    private final PaymentMethod.Type type;

    public /* synthetic */ SupportedPaymentMethod(PaymentMethod.Type type2, int i, int i2, PaymentMethodRequirements paymentMethodRequirements, Map map, LayoutSpec layoutSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(type2, i, i2, paymentMethodRequirements, map, layoutSpec);
    }

    private SupportedPaymentMethod(PaymentMethod.Type type2, int i, int i2, PaymentMethodRequirements paymentMethodRequirements, Map<String, Object> map, LayoutSpec layoutSpec) {
        this.type = type2;
        this.displayNameResource = i;
        this.iconResource = i2;
        this.requirement = paymentMethodRequirements;
        this.paramKey = map;
        this.formSpec = layoutSpec;
    }

    public final PaymentMethod.Type getType() {
        return this.type;
    }

    public final int getDisplayNameResource() {
        return this.displayNameResource;
    }

    public final int getIconResource() {
        return this.iconResource;
    }

    public final Map<String, Object> getParamKey() {
        return this.paramKey;
    }

    public final LayoutSpec getFormSpec() {
        return this.formSpec;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Card;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class Card extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Card> CREATOR = new Creator();
        public static final Card INSTANCE = new Card();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Card> {
            public final Card createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Card.INSTANCE;
            }

            public final Card[] newArray(int i) {
                return new Card[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Card() {
            super(PaymentMethod.Type.Card, R.string.stripe_paymentsheet_payment_method_card, R.drawable.stripe_ic_paymentsheet_pm_card, PaymentMethodRequirementsKt.getCardRequirement(), CardSpecKt.getCardParamKey(), CardSpecKt.getCardForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Bancontact;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class Bancontact extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Bancontact> CREATOR = new Creator();
        public static final Bancontact INSTANCE = new Bancontact();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Bancontact> {
            public final Bancontact createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Bancontact.INSTANCE;
            }

            public final Bancontact[] newArray(int i) {
                return new Bancontact[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Bancontact() {
            super(PaymentMethod.Type.Bancontact, R.string.stripe_paymentsheet_payment_method_bancontact, R.drawable.stripe_ic_paymentsheet_pm_bancontact, PaymentMethodRequirementsKt.getBancontactRequirement(), BancontactSpecKt.getBancontactParamKey(), BancontactSpecKt.getBancontactForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Sofort;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class Sofort extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Sofort> CREATOR = new Creator();
        public static final Sofort INSTANCE = new Sofort();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Sofort> {
            public final Sofort createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Sofort.INSTANCE;
            }

            public final Sofort[] newArray(int i) {
                return new Sofort[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Sofort() {
            super(PaymentMethod.Type.Sofort, R.string.stripe_paymentsheet_payment_method_sofort, R.drawable.stripe_ic_paymentsheet_pm_klarna, PaymentMethodRequirementsKt.getSofortRequirement(), SofortSpecKt.getSofortParamKey(), SofortSpecKt.getSofortForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Ideal;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class Ideal extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Ideal> CREATOR = new Creator();
        public static final Ideal INSTANCE = new Ideal();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Ideal> {
            public final Ideal createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Ideal.INSTANCE;
            }

            public final Ideal[] newArray(int i) {
                return new Ideal[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Ideal() {
            super(PaymentMethod.Type.Ideal, R.string.stripe_paymentsheet_payment_method_ideal, R.drawable.stripe_ic_paymentsheet_pm_ideal, PaymentMethodRequirementsKt.getIdealRequirement(), IdealSpecKt.getIdealParamKey(), IdealSpecKt.getIdealForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$SepaDebit;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class SepaDebit extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<SepaDebit> CREATOR = new Creator();
        public static final SepaDebit INSTANCE = new SepaDebit();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<SepaDebit> {
            public final SepaDebit createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return SepaDebit.INSTANCE;
            }

            public final SepaDebit[] newArray(int i) {
                return new SepaDebit[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private SepaDebit() {
            super(PaymentMethod.Type.SepaDebit, R.string.stripe_paymentsheet_payment_method_sepa_debit, R.drawable.stripe_ic_paymentsheet_pm_sepa_debit, PaymentMethodRequirementsKt.getSepaDebitRequirement(), SepaDebitSpecKt.getSepaDebitParamKey(), SepaDebitSpecKt.getSepaDebitForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Eps;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class Eps extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Eps> CREATOR = new Creator();
        public static final Eps INSTANCE = new Eps();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Eps> {
            public final Eps createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Eps.INSTANCE;
            }

            public final Eps[] newArray(int i) {
                return new Eps[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Eps() {
            super(PaymentMethod.Type.Eps, R.string.stripe_paymentsheet_payment_method_eps, R.drawable.stripe_ic_paymentsheet_pm_eps, PaymentMethodRequirementsKt.getEpsRequirement(), EpsSpecKt.getEpsParamKey(), EpsSpecKt.getEpsForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$P24;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class P24 extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<P24> CREATOR = new Creator();
        public static final P24 INSTANCE = new P24();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<P24> {
            public final P24 createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return P24.INSTANCE;
            }

            public final P24[] newArray(int i) {
                return new P24[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private P24() {
            super(PaymentMethod.Type.P24, R.string.stripe_paymentsheet_payment_method_p24, R.drawable.stripe_ic_paymentsheet_pm_p24, PaymentMethodRequirementsKt.getP24Requirement(), P24SpecKt.getP24ParamKey(), P24SpecKt.getP24Form(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Giropay;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class Giropay extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Giropay> CREATOR = new Creator();
        public static final Giropay INSTANCE = new Giropay();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Giropay> {
            public final Giropay createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Giropay.INSTANCE;
            }

            public final Giropay[] newArray(int i) {
                return new Giropay[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Giropay() {
            super(PaymentMethod.Type.Giropay, R.string.stripe_paymentsheet_payment_method_giropay, R.drawable.stripe_ic_paymentsheet_pm_giropay, PaymentMethodRequirementsKt.getGiropayRequirement(), GiropaySpecKt.getGiropayParamKey(), GiropaySpecKt.getGiropayForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$AfterpayClearpay;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class AfterpayClearpay extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<AfterpayClearpay> CREATOR = new Creator();
        public static final AfterpayClearpay INSTANCE = new AfterpayClearpay();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<AfterpayClearpay> {
            public final AfterpayClearpay createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return AfterpayClearpay.INSTANCE;
            }

            public final AfterpayClearpay[] newArray(int i) {
                return new AfterpayClearpay[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private AfterpayClearpay() {
            super(PaymentMethod.Type.AfterpayClearpay, R.string.stripe_paymentsheet_payment_method_afterpay_clearpay, R.drawable.stripe_ic_paymentsheet_pm_afterpay_clearpay, PaymentMethodRequirementsKt.getAfterpayClearpayRequirement(), AfterpayClearpaySpecKt.getAfterpayClearpayParamKey(), AfterpayClearpaySpecKt.getAfterpayClearpayForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Klarna;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class Klarna extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Klarna> CREATOR = new Creator();
        public static final Klarna INSTANCE = new Klarna();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Klarna> {
            public final Klarna createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Klarna.INSTANCE;
            }

            public final Klarna[] newArray(int i) {
                return new Klarna[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Klarna() {
            super(PaymentMethod.Type.Klarna, R.string.stripe_paymentsheet_payment_method_klarna, R.drawable.stripe_ic_paymentsheet_pm_klarna, PaymentMethodRequirementsKt.getKlarnaRequirement(), KlarnaSpecKt.getKlarnaParamKey(), KlarnaSpecKt.getKlarnaForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$PayPal;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class PayPal extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<PayPal> CREATOR = new Creator();
        public static final PayPal INSTANCE = new PayPal();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<PayPal> {
            public final PayPal createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return PayPal.INSTANCE;
            }

            public final PayPal[] newArray(int i) {
                return new PayPal[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private PayPal() {
            super(PaymentMethod.Type.PayPal, R.string.stripe_paymentsheet_payment_method_paypal, R.drawable.stripe_ic_paymentsheet_pm_paypal, PaymentMethodRequirementsKt.getPaypalRequirement(), PaypalSpecKt.getPaypalParamKey(), PaypalSpecKt.getPaypalForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Affirm;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class Affirm extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Affirm> CREATOR = new Creator();
        public static final Affirm INSTANCE = new Affirm();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Affirm> {
            public final Affirm createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Affirm.INSTANCE;
            }

            public final Affirm[] newArray(int i) {
                return new Affirm[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Affirm() {
            super(PaymentMethod.Type.Affirm, R.string.stripe_paymentsheet_payment_method_affirm, R.drawable.stripe_ic_paymentsheet_pm_affirm, PaymentMethodRequirementsKt.getAffirmRequirement(), AffirmSpecKt.getAffirmParamKey(), AffirmSpecKt.getAffirmForm(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$AuBecsDebit;", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class AuBecsDebit extends SupportedPaymentMethod {
        public static final int $stable = 8;
        public static final Parcelable.Creator<AuBecsDebit> CREATOR = new Creator();
        public static final AuBecsDebit INSTANCE = new AuBecsDebit();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: SupportedPaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<AuBecsDebit> {
            public final AuBecsDebit createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return AuBecsDebit.INSTANCE;
            }

            public final AuBecsDebit[] newArray(int i) {
                return new AuBecsDebit[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private AuBecsDebit() {
            super(PaymentMethod.Type.AuBecsDebit, R.string.stripe_paymentsheet_payment_method_au_becs_debit, R.drawable.stripe_ic_paymentsheet_pm_bank, PaymentMethodRequirementsKt.getAuBecsDebitRequirement(), AuBecsDebitSpecKt.getAuBecsDebitParamKey(), AuBecsDebitSpecKt.getAuBecsDebitForm(), (DefaultConstructorMarker) null);
        }
    }

    public final LayoutFormDescriptor getPMAddForm(StripeIntent stripeIntent, PaymentSheet.Configuration configuration) {
        Intrinsics.checkNotNullParameter(stripeIntent, "stripeIntent");
        LayoutFormDescriptor specWithFullfilledRequirements$paymentsheet_release = getSpecWithFullfilledRequirements$paymentsheet_release(stripeIntent, configuration);
        if (specWithFullfilledRequirements$paymentsheet_release != null) {
            return specWithFullfilledRequirements$paymentsheet_release;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        if (supportsSetupIntent(r7) != false) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.stripe.android.ui.core.elements.LayoutFormDescriptor getSpecWithFullfilledRequirements$paymentsheet_release(com.stripe.android.model.StripeIntent r6, com.stripe.android.paymentsheet.PaymentSheet.Configuration r7) {
        /*
            r5 = this;
            java.lang.String r0 = "stripeIntent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.stripe.android.ui.core.elements.LayoutSpec r0 = r5.formSpec
            com.stripe.android.ui.core.elements.LayoutFormDescriptor r1 = new com.stripe.android.ui.core.elements.LayoutFormDescriptor
            r2 = 0
            r1.<init>(r0, r2, r2)
            com.stripe.android.ui.core.elements.LayoutFormDescriptor r3 = new com.stripe.android.ui.core.elements.LayoutFormDescriptor
            r4 = 1
            r3.<init>(r0, r2, r4)
            com.stripe.android.ui.core.elements.LayoutFormDescriptor r2 = new com.stripe.android.ui.core.elements.LayoutFormDescriptor
            r2.<init>(r0, r4, r4)
            java.util.List r0 = r6.getPaymentMethodTypes()
            com.stripe.android.model.PaymentMethod$Type r4 = r5.type
            java.lang.String r4 = r4.code
            boolean r0 = r0.contains(r4)
            r4 = 0
            if (r0 != 0) goto L_0x0028
            return r4
        L_0x0028:
            boolean r0 = r6 instanceof com.stripe.android.model.PaymentIntent
            if (r0 == 0) goto L_0x004e
            com.stripe.android.model.PaymentIntent r6 = (com.stripe.android.model.PaymentIntent) r6
            boolean r0 = r6.isSetupFutureUsageSet()
            if (r0 == 0) goto L_0x003f
            boolean r6 = r5.supportsPaymentIntentSfuSet(r6, r7)
            if (r6 == 0) goto L_0x003b
            goto L_0x0058
        L_0x003b:
            r1 = r4
            com.stripe.android.ui.core.elements.LayoutFormDescriptor r1 = (com.stripe.android.ui.core.elements.LayoutFormDescriptor) r1
            goto L_0x005b
        L_0x003f:
            boolean r0 = r5.supportsPaymentIntentSfuSettable(r6, r7)
            if (r0 == 0) goto L_0x0047
            r1 = r2
            goto L_0x005b
        L_0x0047:
            boolean r6 = r5.supportsPaymentIntentSfuNotSettable(r6, r7)
            if (r6 == 0) goto L_0x005a
            goto L_0x005b
        L_0x004e:
            boolean r6 = r6 instanceof com.stripe.android.model.SetupIntent
            if (r6 == 0) goto L_0x005c
            boolean r6 = r5.supportsSetupIntent(r7)
            if (r6 == 0) goto L_0x005a
        L_0x0058:
            r1 = r3
            goto L_0x005b
        L_0x005a:
            r1 = r4
        L_0x005b:
            return r1
        L_0x005c:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.model.SupportedPaymentMethod.getSpecWithFullfilledRequirements$paymentsheet_release(com.stripe.android.model.StripeIntent, com.stripe.android.paymentsheet.PaymentSheet$Configuration):com.stripe.android.ui.core.elements.LayoutFormDescriptor");
    }

    public final boolean supportsCustomerSavedPM() {
        return Intrinsics.areEqual((Object) this.requirement.getConfirmPMFromCustomer(), (Object) true);
    }

    private final boolean supportsSetupIntent(PaymentSheet.Configuration configuration) {
        if (!Intrinsics.areEqual((Object) this.requirement.getConfirmPMFromCustomer(), (Object) true) || !checkSetupIntentRequirements(this.requirement.getSiRequirements(), configuration)) {
            return false;
        }
        return true;
    }

    private final boolean supportsPaymentIntentSfuSet(PaymentIntent paymentIntent, PaymentSheet.Configuration configuration) {
        if (!Intrinsics.areEqual((Object) this.requirement.getConfirmPMFromCustomer(), (Object) true) || !checkSetupIntentRequirements(this.requirement.getSiRequirements(), configuration) || !checkPaymentIntentRequirements(this.requirement.getPiRequirements(), paymentIntent, configuration)) {
            return false;
        }
        return true;
    }

    private final boolean supportsPaymentIntentSfuNotSettable(PaymentIntent paymentIntent, PaymentSheet.Configuration configuration) {
        return checkPaymentIntentRequirements(this.requirement.getPiRequirements(), paymentIntent, configuration);
    }

    private final boolean supportsPaymentIntentSfuSettable(PaymentIntent paymentIntent, PaymentSheet.Configuration configuration) {
        if ((configuration == null ? null : configuration.getCustomer()) == null || !Intrinsics.areEqual((Object) this.requirement.getConfirmPMFromCustomer(), (Object) true) || !checkPaymentIntentRequirements(this.requirement.getPiRequirements(), paymentIntent, configuration) || !checkSetupIntentRequirements(this.requirement.getSiRequirements(), configuration)) {
            return false;
        }
        return true;
    }

    private final boolean checkSetupIntentRequirements(Set<? extends SIRequirement> set, PaymentSheet.Configuration configuration) {
        if (set != null) {
            Iterable<SIRequirement> iterable = set;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (SIRequirement areEqual : iterable) {
                if (Intrinsics.areEqual((Object) areEqual, (Object) Delayed.INSTANCE)) {
                    arrayList.add(Boolean.valueOf(configuration != null && configuration.getAllowsDelayedPaymentMethods()));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            if (!((List) arrayList).contains(false)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r8.getAllowsDelayedPaymentMethods() != true) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008e, code lost:
        if (r4 != null) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean checkPaymentIntentRequirements(java.util.Set<? extends com.stripe.android.paymentsheet.forms.PIRequirement> r6, com.stripe.android.model.PaymentIntent r7, com.stripe.android.paymentsheet.PaymentSheet.Configuration r8) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r6 != 0) goto L_0x0007
        L_0x0004:
            r0 = 0
            goto L_0x00ab
        L_0x0007:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r3)
            r2.<init>(r3)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r6 = r6.iterator()
        L_0x001a:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L_0x009f
            java.lang.Object r3 = r6.next()
            com.stripe.android.paymentsheet.forms.PIRequirement r3 = (com.stripe.android.paymentsheet.forms.PIRequirement) r3
            com.stripe.android.paymentsheet.forms.Delayed r4 = com.stripe.android.paymentsheet.forms.Delayed.INSTANCE
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x003b
            if (r8 != 0) goto L_0x0033
        L_0x0030:
            r3 = 0
            goto L_0x0091
        L_0x0033:
            boolean r3 = r8.getAllowsDelayedPaymentMethods()
            if (r3 != r0) goto L_0x0030
        L_0x0039:
            r3 = 1
            goto L_0x0091
        L_0x003b:
            com.stripe.android.paymentsheet.forms.ShippingAddress r4 = com.stripe.android.paymentsheet.forms.ShippingAddress.INSTANCE
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0099
            com.stripe.android.model.PaymentIntent$Shipping r3 = r7.getShipping()
            r4 = 0
            if (r3 != 0) goto L_0x004c
            r3 = r4
            goto L_0x0050
        L_0x004c:
            java.lang.String r3 = r3.getName()
        L_0x0050:
            if (r3 == 0) goto L_0x0030
            com.stripe.android.model.PaymentIntent$Shipping r3 = r7.getShipping()
            if (r3 != 0) goto L_0x005a
        L_0x0058:
            r3 = r4
            goto L_0x0065
        L_0x005a:
            com.stripe.android.model.Address r3 = r3.getAddress()
            if (r3 != 0) goto L_0x0061
            goto L_0x0058
        L_0x0061:
            java.lang.String r3 = r3.getLine1()
        L_0x0065:
            if (r3 == 0) goto L_0x0030
            com.stripe.android.model.PaymentIntent$Shipping r3 = r7.getShipping()
            if (r3 != 0) goto L_0x006f
        L_0x006d:
            r3 = r4
            goto L_0x007a
        L_0x006f:
            com.stripe.android.model.Address r3 = r3.getAddress()
            if (r3 != 0) goto L_0x0076
            goto L_0x006d
        L_0x0076:
            java.lang.String r3 = r3.getCountry()
        L_0x007a:
            if (r3 == 0) goto L_0x0030
            com.stripe.android.model.PaymentIntent$Shipping r3 = r7.getShipping()
            if (r3 != 0) goto L_0x0083
            goto L_0x008e
        L_0x0083:
            com.stripe.android.model.Address r3 = r3.getAddress()
            if (r3 != 0) goto L_0x008a
            goto L_0x008e
        L_0x008a:
            java.lang.String r4 = r3.getPostalCode()
        L_0x008e:
            if (r4 == 0) goto L_0x0030
            goto L_0x0039
        L_0x0091:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r2.add(r3)
            goto L_0x001a
        L_0x0099:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x009f:
            java.util.List r2 = (java.util.List) r2
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)
            boolean r6 = r2.contains(r6)
            if (r6 != 0) goto L_0x0004
        L_0x00ab:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.model.SupportedPaymentMethod.checkPaymentIntentRequirements(java.util.Set, com.stripe.android.model.PaymentIntent, com.stripe.android.paymentsheet.PaymentSheet$Configuration):boolean");
    }

    public String toString() {
        return this.type.code;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rJ'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J'\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0011\u0010\u0017\u001a\u00020\u0018*\u00020\u0005H\u0000¢\u0006\u0002\b\u0019R'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048@X\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod$Companion;", "", "()V", "exposedPaymentMethods", "", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "getExposedPaymentMethods$paymentsheet_release$annotations", "getExposedPaymentMethods$paymentsheet_release", "()Ljava/util/List;", "exposedPaymentMethods$delegate", "Lkotlin/Lazy;", "fromCode", "code", "", "getPMsToAdd", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "config", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "getPMsToAdd$paymentsheet_release", "getSupportedSavedCustomerPMs", "getSupportedSavedCustomerPMs$paymentsheet_release", "values", "shouldTintOnSelection", "", "shouldTintOnSelection$paymentsheet_release", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SupportedPaymentMethod.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getExposedPaymentMethods$paymentsheet_release$annotations() {
        }

        private Companion() {
        }

        public final List<SupportedPaymentMethod> values() {
            return getExposedPaymentMethods$paymentsheet_release();
        }

        public final List<SupportedPaymentMethod> getExposedPaymentMethods$paymentsheet_release() {
            return (List) SupportedPaymentMethod.exposedPaymentMethods$delegate.getValue();
        }

        public final boolean shouldTintOnSelection$paymentsheet_release(SupportedPaymentMethod supportedPaymentMethod) {
            Intrinsics.checkNotNullParameter(supportedPaymentMethod, "<this>");
            return SetsKt.setOf(Card.INSTANCE, AuBecsDebit.INSTANCE).contains(supportedPaymentMethod);
        }

        public final SupportedPaymentMethod fromCode(String str) {
            Object obj;
            Iterator it = getExposedPaymentMethods$paymentsheet_release().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((SupportedPaymentMethod) obj).getType().code, (Object) str)) {
                    break;
                }
            }
            return (SupportedPaymentMethod) obj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.util.Collection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.util.List<com.stripe.android.paymentsheet.model.SupportedPaymentMethod>} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<com.stripe.android.paymentsheet.model.SupportedPaymentMethod> getSupportedSavedCustomerPMs$paymentsheet_release(com.stripe.android.model.StripeIntent r6, com.stripe.android.paymentsheet.PaymentSheet.Configuration r7) {
            /*
                r5 = this;
                r0 = 0
                if (r6 != 0) goto L_0x0004
                goto L_0x0065
            L_0x0004:
                java.util.List r1 = r6.getPaymentMethodTypes()
                if (r1 != 0) goto L_0x000b
                goto L_0x0065
            L_0x000b:
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Collection r0 = (java.util.Collection) r0
                java.util.Iterator r1 = r1.iterator()
            L_0x0018:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0031
                java.lang.Object r2 = r1.next()
                java.lang.String r2 = (java.lang.String) r2
                com.stripe.android.paymentsheet.model.SupportedPaymentMethod$Companion r3 = com.stripe.android.paymentsheet.model.SupportedPaymentMethod.Companion
                com.stripe.android.paymentsheet.model.SupportedPaymentMethod r2 = r3.fromCode(r2)
                if (r2 != 0) goto L_0x002d
                goto L_0x0018
            L_0x002d:
                r0.add(r2)
                goto L_0x0018
            L_0x0031:
                java.util.List r0 = (java.util.List) r0
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r0 = r0.iterator()
            L_0x0040:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0062
                java.lang.Object r2 = r0.next()
                r3 = r2
                com.stripe.android.paymentsheet.model.SupportedPaymentMethod r3 = (com.stripe.android.paymentsheet.model.SupportedPaymentMethod) r3
                boolean r4 = r3.supportsCustomerSavedPM()
                if (r4 == 0) goto L_0x005b
                com.stripe.android.ui.core.elements.LayoutFormDescriptor r3 = r3.getSpecWithFullfilledRequirements$paymentsheet_release(r6, r7)
                if (r3 == 0) goto L_0x005b
                r3 = 1
                goto L_0x005c
            L_0x005b:
                r3 = 0
            L_0x005c:
                if (r3 == 0) goto L_0x0040
                r1.add(r2)
                goto L_0x0040
            L_0x0062:
                r0 = r1
                java.util.List r0 = (java.util.List) r0
            L_0x0065:
                if (r0 != 0) goto L_0x006b
                java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            L_0x006b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.model.SupportedPaymentMethod.Companion.getSupportedSavedCustomerPMs$paymentsheet_release(com.stripe.android.model.StripeIntent, com.stripe.android.paymentsheet.PaymentSheet$Configuration):java.util.List");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.util.Collection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.util.List<com.stripe.android.paymentsheet.model.SupportedPaymentMethod>} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<com.stripe.android.paymentsheet.model.SupportedPaymentMethod> getPMsToAdd$paymentsheet_release(com.stripe.android.model.StripeIntent r7, com.stripe.android.paymentsheet.PaymentSheet.Configuration r8) {
            /*
                r6 = this;
                r0 = 0
                if (r7 != 0) goto L_0x0005
                goto L_0x009d
            L_0x0005:
                java.util.List r1 = r7.getPaymentMethodTypes()
                if (r1 != 0) goto L_0x000d
                goto L_0x009d
            L_0x000d:
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Collection r0 = (java.util.Collection) r0
                java.util.Iterator r1 = r1.iterator()
            L_0x001a:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0033
                java.lang.Object r2 = r1.next()
                java.lang.String r2 = (java.lang.String) r2
                com.stripe.android.paymentsheet.model.SupportedPaymentMethod$Companion r3 = com.stripe.android.paymentsheet.model.SupportedPaymentMethod.Companion
                com.stripe.android.paymentsheet.model.SupportedPaymentMethod r2 = r3.fromCode(r2)
                if (r2 != 0) goto L_0x002f
                goto L_0x001a
            L_0x002f:
                r0.add(r2)
                goto L_0x001a
            L_0x0033:
                java.util.List r0 = (java.util.List) r0
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r0 = r0.iterator()
            L_0x0042:
                boolean r2 = r0.hasNext()
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x005f
                java.lang.Object r2 = r0.next()
                r5 = r2
                com.stripe.android.paymentsheet.model.SupportedPaymentMethod r5 = (com.stripe.android.paymentsheet.model.SupportedPaymentMethod) r5
                com.stripe.android.ui.core.elements.LayoutFormDescriptor r5 = r5.getSpecWithFullfilledRequirements$paymentsheet_release(r7, r8)
                if (r5 == 0) goto L_0x0058
                goto L_0x0059
            L_0x0058:
                r3 = 0
            L_0x0059:
                if (r3 == 0) goto L_0x0042
                r1.add(r2)
                goto L_0x0042
            L_0x005f:
                java.util.List r1 = (java.util.List) r1
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.Collection r8 = (java.util.Collection) r8
                java.util.Iterator r0 = r1.iterator()
            L_0x006e:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x009a
                java.lang.Object r1 = r0.next()
                r2 = r1
                com.stripe.android.paymentsheet.model.SupportedPaymentMethod r2 = (com.stripe.android.paymentsheet.model.SupportedPaymentMethod) r2
                boolean r5 = r7.isLiveMode()
                if (r5 == 0) goto L_0x0093
                java.util.List r5 = r7.getUnactivatedPaymentMethods()
                com.stripe.android.model.PaymentMethod$Type r2 = r2.getType()
                java.lang.String r2 = r2.code
                boolean r2 = r5.contains(r2)
                if (r2 == 0) goto L_0x0093
                r2 = 1
                goto L_0x0094
            L_0x0093:
                r2 = 0
            L_0x0094:
                if (r2 != 0) goto L_0x006e
                r8.add(r1)
                goto L_0x006e
            L_0x009a:
                r0 = r8
                java.util.List r0 = (java.util.List) r0
            L_0x009d:
                if (r0 != 0) goto L_0x00a3
                java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            L_0x00a3:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.model.SupportedPaymentMethod.Companion.getPMsToAdd$paymentsheet_release(com.stripe.android.model.StripeIntent, com.stripe.android.paymentsheet.PaymentSheet$Configuration):java.util.List");
        }
    }
}
