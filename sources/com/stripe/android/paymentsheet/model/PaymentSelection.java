package com.stripe.android.paymentsheet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "Landroid/os/Parcelable;", "()V", "CustomerRequestedSave", "GooglePay", "New", "Saved", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$GooglePay;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$Saved;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSelection.kt */
public abstract class PaymentSelection implements Parcelable {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "", "(Ljava/lang/String;I)V", "RequestReuse", "RequestNoReuse", "NoRequest", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSelection.kt */
    public enum CustomerRequestedSave {
        RequestReuse,
        RequestNoReuse,
        NoRequest
    }

    public /* synthetic */ PaymentSelection(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaymentSelection() {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSelection$GooglePay;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSelection.kt */
    public static final class GooglePay extends PaymentSelection {
        public static final int $stable = 8;
        public static final Parcelable.Creator<GooglePay> CREATOR = new Creator();
        public static final GooglePay INSTANCE = new GooglePay();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSelection.kt */
        public static final class Creator implements Parcelable.Creator<GooglePay> {
            public final GooglePay createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return GooglePay.INSTANCE;
            }

            public final GooglePay[] newArray(int i) {
                return new GooglePay[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private GooglePay() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSelection$Saved;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "(Lcom/stripe/android/model/PaymentMethod;)V", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSelection.kt */
    public static final class Saved extends PaymentSelection {
        public static final int $stable = PaymentMethod.$stable;
        public static final Parcelable.Creator<Saved> CREATOR = new Creator();
        private final PaymentMethod paymentMethod;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSelection.kt */
        public static final class Creator implements Parcelable.Creator<Saved> {
            public final Saved createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Saved((PaymentMethod) parcel.readParcelable(Saved.class.getClassLoader()));
            }

            public final Saved[] newArray(int i) {
                return new Saved[i];
            }
        }

        public static /* synthetic */ Saved copy$default(Saved saved, PaymentMethod paymentMethod2, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentMethod2 = saved.paymentMethod;
            }
            return saved.copy(paymentMethod2);
        }

        public final PaymentMethod component1() {
            return this.paymentMethod;
        }

        public final Saved copy(PaymentMethod paymentMethod2) {
            Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
            return new Saved(paymentMethod2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Saved) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) ((Saved) obj).paymentMethod);
        }

        public int hashCode() {
            return this.paymentMethod.hashCode();
        }

        public String toString() {
            return "Saved(paymentMethod=" + this.paymentMethod + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.paymentMethod, i);
        }

        public final PaymentMethod getPaymentMethod() {
            return this.paymentMethod;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Saved(PaymentMethod paymentMethod2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
            this.paymentMethod = paymentMethod2;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSelection$New;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "()V", "customerRequestedSave", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "getCustomerRequestedSave", "()Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "getPaymentMethodCreateParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "Card", "GenericPaymentMethod", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$GenericPaymentMethod;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSelection.kt */
    public static abstract class New extends PaymentSelection {
        public static final int $stable = 0;

        public /* synthetic */ New(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract CustomerRequestedSave getCustomerRequestedSave();

        public abstract PaymentMethodCreateParams getPaymentMethodCreateParams();

        private New() {
            super((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New;", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "brand", "Lcom/stripe/android/model/CardBrand;", "customerRequestedSave", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "(Lcom/stripe/android/model/PaymentMethodCreateParams;Lcom/stripe/android/model/CardBrand;Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;)V", "getBrand", "()Lcom/stripe/android/model/CardBrand;", "getCustomerRequestedSave", "()Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "last4", "", "getLast4", "()Ljava/lang/String;", "getPaymentMethodCreateParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSelection.kt */
        public static final class Card extends New {
            public static final int $stable = PaymentMethodCreateParams.$stable;
            public static final Parcelable.Creator<Card> CREATOR = new Creator();
            private final CardBrand brand;
            private final CustomerRequestedSave customerRequestedSave;
            private final String last4;
            private final PaymentMethodCreateParams paymentMethodCreateParams;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentSelection.kt */
            public static final class Creator implements Parcelable.Creator<Card> {
                public final Card createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Card((PaymentMethodCreateParams) parcel.readParcelable(Card.class.getClassLoader()), CardBrand.valueOf(parcel.readString()), CustomerRequestedSave.valueOf(parcel.readString()));
                }

                public final Card[] newArray(int i) {
                    return new Card[i];
                }
            }

            public static /* synthetic */ Card copy$default(Card card, PaymentMethodCreateParams paymentMethodCreateParams2, CardBrand cardBrand, CustomerRequestedSave customerRequestedSave2, int i, Object obj) {
                if ((i & 1) != 0) {
                    paymentMethodCreateParams2 = card.getPaymentMethodCreateParams();
                }
                if ((i & 2) != 0) {
                    cardBrand = card.brand;
                }
                if ((i & 4) != 0) {
                    customerRequestedSave2 = card.getCustomerRequestedSave();
                }
                return card.copy(paymentMethodCreateParams2, cardBrand, customerRequestedSave2);
            }

            public final PaymentMethodCreateParams component1() {
                return getPaymentMethodCreateParams();
            }

            public final CardBrand component2() {
                return this.brand;
            }

            public final CustomerRequestedSave component3() {
                return getCustomerRequestedSave();
            }

            public final Card copy(PaymentMethodCreateParams paymentMethodCreateParams2, CardBrand cardBrand, CustomerRequestedSave customerRequestedSave2) {
                Intrinsics.checkNotNullParameter(paymentMethodCreateParams2, "paymentMethodCreateParams");
                Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
                Intrinsics.checkNotNullParameter(customerRequestedSave2, "customerRequestedSave");
                return new Card(paymentMethodCreateParams2, cardBrand, customerRequestedSave2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Card)) {
                    return false;
                }
                Card card = (Card) obj;
                return Intrinsics.areEqual((Object) getPaymentMethodCreateParams(), (Object) card.getPaymentMethodCreateParams()) && this.brand == card.brand && getCustomerRequestedSave() == card.getCustomerRequestedSave();
            }

            public int hashCode() {
                return (((getPaymentMethodCreateParams().hashCode() * 31) + this.brand.hashCode()) * 31) + getCustomerRequestedSave().hashCode();
            }

            public String toString() {
                return "Card(paymentMethodCreateParams=" + getPaymentMethodCreateParams() + ", brand=" + this.brand + ", customerRequestedSave=" + getCustomerRequestedSave() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeParcelable(this.paymentMethodCreateParams, i);
                parcel.writeString(this.brand.name());
                parcel.writeString(this.customerRequestedSave.name());
            }

            public PaymentMethodCreateParams getPaymentMethodCreateParams() {
                return this.paymentMethodCreateParams;
            }

            public final CardBrand getBrand() {
                return this.brand;
            }

            public CustomerRequestedSave getCustomerRequestedSave() {
                return this.customerRequestedSave;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.util.Map} */
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Card(com.stripe.android.model.PaymentMethodCreateParams r2, com.stripe.android.model.CardBrand r3, com.stripe.android.paymentsheet.model.PaymentSelection.CustomerRequestedSave r4) {
                /*
                    r1 = this;
                    java.lang.String r0 = "paymentMethodCreateParams"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                    java.lang.String r0 = "brand"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    java.lang.String r0 = "customerRequestedSave"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                    r0 = 0
                    r1.<init>(r0)
                    r1.paymentMethodCreateParams = r2
                    r1.brand = r3
                    r1.customerRequestedSave = r4
                    com.stripe.android.model.PaymentMethodCreateParams r2 = r1.getPaymentMethodCreateParams()
                    java.util.Map r2 = r2.toParamMap()
                    java.lang.String r3 = "card"
                    java.lang.Object r2 = r2.get(r3)
                    boolean r3 = r2 instanceof java.util.Map
                    if (r3 == 0) goto L_0x002e
                    r0 = r2
                    java.util.Map r0 = (java.util.Map) r0
                L_0x002e:
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    java.lang.String r2 = "number"
                    java.lang.Object r2 = r0.get(r2)
                    java.lang.String r3 = "null cannot be cast to non-null type kotlin.String"
                    java.util.Objects.requireNonNull(r2, r3)
                    java.lang.String r2 = (java.lang.String) r2
                    r3 = 4
                    java.lang.String r2 = kotlin.text.StringsKt.takeLast((java.lang.String) r2, (int) r3)
                    r1.last4 = r2
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.model.PaymentSelection.New.Card.<init>(com.stripe.android.model.PaymentMethodCreateParams, com.stripe.android.model.CardBrand, com.stripe.android.paymentsheet.model.PaymentSelection$CustomerRequestedSave):void");
            }

            public final String getLast4() {
                return this.last4;
            }
        }

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$GenericPaymentMethod;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New;", "labelResource", "", "iconResource", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "customerRequestedSave", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "(IILcom/stripe/android/model/PaymentMethodCreateParams;Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;)V", "getCustomerRequestedSave", "()Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "getIconResource", "()I", "getLabelResource", "getPaymentMethodCreateParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSelection.kt */
        public static final class GenericPaymentMethod extends New {
            public static final int $stable = PaymentMethodCreateParams.$stable;
            public static final Parcelable.Creator<GenericPaymentMethod> CREATOR = new Creator();
            private final CustomerRequestedSave customerRequestedSave;
            private final int iconResource;
            private final int labelResource;
            private final PaymentMethodCreateParams paymentMethodCreateParams;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentSelection.kt */
            public static final class Creator implements Parcelable.Creator<GenericPaymentMethod> {
                public final GenericPaymentMethod createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new GenericPaymentMethod(parcel.readInt(), parcel.readInt(), (PaymentMethodCreateParams) parcel.readParcelable(GenericPaymentMethod.class.getClassLoader()), CustomerRequestedSave.valueOf(parcel.readString()));
                }

                public final GenericPaymentMethod[] newArray(int i) {
                    return new GenericPaymentMethod[i];
                }
            }

            public static /* synthetic */ GenericPaymentMethod copy$default(GenericPaymentMethod genericPaymentMethod, int i, int i2, PaymentMethodCreateParams paymentMethodCreateParams2, CustomerRequestedSave customerRequestedSave2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = genericPaymentMethod.labelResource;
                }
                if ((i3 & 2) != 0) {
                    i2 = genericPaymentMethod.iconResource;
                }
                if ((i3 & 4) != 0) {
                    paymentMethodCreateParams2 = genericPaymentMethod.getPaymentMethodCreateParams();
                }
                if ((i3 & 8) != 0) {
                    customerRequestedSave2 = genericPaymentMethod.getCustomerRequestedSave();
                }
                return genericPaymentMethod.copy(i, i2, paymentMethodCreateParams2, customerRequestedSave2);
            }

            public final int component1() {
                return this.labelResource;
            }

            public final int component2() {
                return this.iconResource;
            }

            public final PaymentMethodCreateParams component3() {
                return getPaymentMethodCreateParams();
            }

            public final CustomerRequestedSave component4() {
                return getCustomerRequestedSave();
            }

            public final GenericPaymentMethod copy(int i, int i2, PaymentMethodCreateParams paymentMethodCreateParams2, CustomerRequestedSave customerRequestedSave2) {
                Intrinsics.checkNotNullParameter(paymentMethodCreateParams2, "paymentMethodCreateParams");
                Intrinsics.checkNotNullParameter(customerRequestedSave2, "customerRequestedSave");
                return new GenericPaymentMethod(i, i2, paymentMethodCreateParams2, customerRequestedSave2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof GenericPaymentMethod)) {
                    return false;
                }
                GenericPaymentMethod genericPaymentMethod = (GenericPaymentMethod) obj;
                return this.labelResource == genericPaymentMethod.labelResource && this.iconResource == genericPaymentMethod.iconResource && Intrinsics.areEqual((Object) getPaymentMethodCreateParams(), (Object) genericPaymentMethod.getPaymentMethodCreateParams()) && getCustomerRequestedSave() == genericPaymentMethod.getCustomerRequestedSave();
            }

            public int hashCode() {
                return (((((this.labelResource * 31) + this.iconResource) * 31) + getPaymentMethodCreateParams().hashCode()) * 31) + getCustomerRequestedSave().hashCode();
            }

            public String toString() {
                return "GenericPaymentMethod(labelResource=" + this.labelResource + ", iconResource=" + this.iconResource + ", paymentMethodCreateParams=" + getPaymentMethodCreateParams() + ", customerRequestedSave=" + getCustomerRequestedSave() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.labelResource);
                parcel.writeInt(this.iconResource);
                parcel.writeParcelable(this.paymentMethodCreateParams, i);
                parcel.writeString(this.customerRequestedSave.name());
            }

            public final int getLabelResource() {
                return this.labelResource;
            }

            public final int getIconResource() {
                return this.iconResource;
            }

            public PaymentMethodCreateParams getPaymentMethodCreateParams() {
                return this.paymentMethodCreateParams;
            }

            public CustomerRequestedSave getCustomerRequestedSave() {
                return this.customerRequestedSave;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GenericPaymentMethod(int i, int i2, PaymentMethodCreateParams paymentMethodCreateParams2, CustomerRequestedSave customerRequestedSave2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(paymentMethodCreateParams2, "paymentMethodCreateParams");
                Intrinsics.checkNotNullParameter(customerRequestedSave2, "customerRequestedSave");
                this.labelResource = i;
                this.iconResource = i2;
                this.paymentMethodCreateParams = paymentMethodCreateParams2;
                this.customerRequestedSave = customerRequestedSave2;
            }
        }
    }
}
