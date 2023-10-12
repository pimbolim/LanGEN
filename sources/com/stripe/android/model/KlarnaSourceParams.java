package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.braintreepayments.api.models.PayPalRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0004@ABCB\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\t\u00101\u001a\u000202HÖ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000202HÖ\u0001J\u0014\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020609H\u0016J\t\u0010:\u001a\u00020\u0004HÖ\u0001J\u0019\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u000202HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001b¨\u0006D"}, d2 = {"Lcom/stripe/android/model/KlarnaSourceParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "purchaseCountry", "", "lineItems", "", "Lcom/stripe/android/model/KlarnaSourceParams$LineItem;", "customPaymentMethods", "", "Lcom/stripe/android/model/KlarnaSourceParams$CustomPaymentMethods;", "billingEmail", "billingPhone", "billingAddress", "Lcom/stripe/android/model/Address;", "billingFirstName", "billingLastName", "billingDob", "Lcom/stripe/android/model/DateOfBirth;", "pageOptions", "Lcom/stripe/android/model/KlarnaSourceParams$PaymentPageOptions;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Set;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/DateOfBirth;Lcom/stripe/android/model/KlarnaSourceParams$PaymentPageOptions;)V", "getBillingAddress", "()Lcom/stripe/android/model/Address;", "getBillingDob", "()Lcom/stripe/android/model/DateOfBirth;", "getBillingEmail", "()Ljava/lang/String;", "getBillingFirstName", "getBillingLastName", "getBillingPhone", "getCustomPaymentMethods", "()Ljava/util/Set;", "getLineItems", "()Ljava/util/List;", "getPageOptions", "()Lcom/stripe/android/model/KlarnaSourceParams$PaymentPageOptions;", "getPurchaseCountry", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "CustomPaymentMethods", "LineItem", "PaymentPageOptions", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KlarnaSourceParams.kt */
public final class KlarnaSourceParams implements StripeParamsModel, Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<KlarnaSourceParams> CREATOR = new Creator();
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PARAM_CUSTOM_PAYMENT_METHODS = "custom_payment_methods";
    @Deprecated
    private static final String PARAM_DOB_DAY = "owner_dob_day";
    @Deprecated
    private static final String PARAM_DOB_MONTH = "owner_dob_month";
    @Deprecated
    private static final String PARAM_DOB_YEAR = "owner_dob_year";
    @Deprecated
    private static final String PARAM_FIRST_NAME = "first_name";
    @Deprecated
    private static final String PARAM_LAST_NAME = "last_name";
    @Deprecated
    private static final String PARAM_PRODUCT = "product";
    @Deprecated
    private static final String PARAM_PURCHASE_COUNTRY = "purchase_country";
    private final Address billingAddress;
    private final DateOfBirth billingDob;
    private final String billingEmail;
    private final String billingFirstName;
    private final String billingLastName;
    private final String billingPhone;
    private final Set<CustomPaymentMethods> customPaymentMethods;
    private final List<LineItem> lineItems;
    private final PaymentPageOptions pageOptions;
    private final String purchaseCountry;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KlarnaSourceParams.kt */
    public static final class Creator implements Parcelable.Creator<KlarnaSourceParams> {
        public final KlarnaSourceParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(LineItem.CREATOR.createFromParcel(parcel));
            }
            List list = arrayList;
            int readInt2 = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                linkedHashSet.add(CustomPaymentMethods.valueOf(parcel.readString()));
            }
            Set set = linkedHashSet;
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            PaymentPageOptions paymentPageOptions = null;
            Address createFromParcel = parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel);
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            DateOfBirth createFromParcel2 = parcel.readInt() == 0 ? null : DateOfBirth.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                paymentPageOptions = PaymentPageOptions.CREATOR.createFromParcel(parcel);
            }
            return new KlarnaSourceParams(readString, list, set, readString2, readString3, createFromParcel, readString4, readString5, createFromParcel2, paymentPageOptions);
        }

        public final KlarnaSourceParams[] newArray(int i) {
            return new KlarnaSourceParams[i];
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KlarnaSourceParams(java.lang.String r15, java.util.List<com.stripe.android.model.KlarnaSourceParams.LineItem> r16) {
        /*
            r14 = this;
            java.lang.String r0 = "purchaseCountry"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "lineItems"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 1020(0x3fc, float:1.43E-42)
            r13 = 0
            r1 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.KlarnaSourceParams.<init>(java.lang.String, java.util.List):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KlarnaSourceParams(java.lang.String r15, java.util.List<com.stripe.android.model.KlarnaSourceParams.LineItem> r16, java.util.Set<? extends com.stripe.android.model.KlarnaSourceParams.CustomPaymentMethods> r17) {
        /*
            r14 = this;
            java.lang.String r0 = "purchaseCountry"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "lineItems"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "customPaymentMethods"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 1016(0x3f8, float:1.424E-42)
            r13 = 0
            r1 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.KlarnaSourceParams.<init>(java.lang.String, java.util.List, java.util.Set):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KlarnaSourceParams(java.lang.String r15, java.util.List<com.stripe.android.model.KlarnaSourceParams.LineItem> r16, java.util.Set<? extends com.stripe.android.model.KlarnaSourceParams.CustomPaymentMethods> r17, java.lang.String r18) {
        /*
            r14 = this;
            java.lang.String r0 = "purchaseCountry"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "lineItems"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "customPaymentMethods"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 1008(0x3f0, float:1.413E-42)
            r13 = 0
            r1 = r14
            r5 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.KlarnaSourceParams.<init>(java.lang.String, java.util.List, java.util.Set, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KlarnaSourceParams(java.lang.String r15, java.util.List<com.stripe.android.model.KlarnaSourceParams.LineItem> r16, java.util.Set<? extends com.stripe.android.model.KlarnaSourceParams.CustomPaymentMethods> r17, java.lang.String r18, java.lang.String r19) {
        /*
            r14 = this;
            java.lang.String r0 = "purchaseCountry"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "lineItems"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "customPaymentMethods"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 992(0x3e0, float:1.39E-42)
            r13 = 0
            r1 = r14
            r5 = r18
            r6 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.KlarnaSourceParams.<init>(java.lang.String, java.util.List, java.util.Set, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KlarnaSourceParams(java.lang.String r15, java.util.List<com.stripe.android.model.KlarnaSourceParams.LineItem> r16, java.util.Set<? extends com.stripe.android.model.KlarnaSourceParams.CustomPaymentMethods> r17, java.lang.String r18, java.lang.String r19, com.stripe.android.model.Address r20) {
        /*
            r14 = this;
            java.lang.String r0 = "purchaseCountry"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "lineItems"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "customPaymentMethods"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 960(0x3c0, float:1.345E-42)
            r13 = 0
            r1 = r14
            r5 = r18
            r6 = r19
            r7 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.KlarnaSourceParams.<init>(java.lang.String, java.util.List, java.util.Set, java.lang.String, java.lang.String, com.stripe.android.model.Address):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KlarnaSourceParams(java.lang.String r15, java.util.List<com.stripe.android.model.KlarnaSourceParams.LineItem> r16, java.util.Set<? extends com.stripe.android.model.KlarnaSourceParams.CustomPaymentMethods> r17, java.lang.String r18, java.lang.String r19, com.stripe.android.model.Address r20, java.lang.String r21) {
        /*
            r14 = this;
            java.lang.String r0 = "purchaseCountry"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "lineItems"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "customPaymentMethods"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 896(0x380, float:1.256E-42)
            r13 = 0
            r1 = r14
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.KlarnaSourceParams.<init>(java.lang.String, java.util.List, java.util.Set, java.lang.String, java.lang.String, com.stripe.android.model.Address, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KlarnaSourceParams(java.lang.String r15, java.util.List<com.stripe.android.model.KlarnaSourceParams.LineItem> r16, java.util.Set<? extends com.stripe.android.model.KlarnaSourceParams.CustomPaymentMethods> r17, java.lang.String r18, java.lang.String r19, com.stripe.android.model.Address r20, java.lang.String r21, java.lang.String r22) {
        /*
            r14 = this;
            java.lang.String r0 = "purchaseCountry"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "lineItems"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "customPaymentMethods"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r10 = 0
            r11 = 0
            r12 = 768(0x300, float:1.076E-42)
            r13 = 0
            r1 = r14
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.KlarnaSourceParams.<init>(java.lang.String, java.util.List, java.util.Set, java.lang.String, java.lang.String, com.stripe.android.model.Address, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KlarnaSourceParams(java.lang.String r15, java.util.List<com.stripe.android.model.KlarnaSourceParams.LineItem> r16, java.util.Set<? extends com.stripe.android.model.KlarnaSourceParams.CustomPaymentMethods> r17, java.lang.String r18, java.lang.String r19, com.stripe.android.model.Address r20, java.lang.String r21, java.lang.String r22, com.stripe.android.model.DateOfBirth r23) {
        /*
            r14 = this;
            java.lang.String r0 = "purchaseCountry"
            r2 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "lineItems"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "customPaymentMethods"
            r4 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r11 = 0
            r12 = 512(0x200, float:7.175E-43)
            r13 = 0
            r1 = r14
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.KlarnaSourceParams.<init>(java.lang.String, java.util.List, java.util.Set, java.lang.String, java.lang.String, com.stripe.android.model.Address, java.lang.String, java.lang.String, com.stripe.android.model.DateOfBirth):void");
    }

    public static /* synthetic */ KlarnaSourceParams copy$default(KlarnaSourceParams klarnaSourceParams, String str, List list, Set set, String str2, String str3, Address address, String str4, String str5, DateOfBirth dateOfBirth, PaymentPageOptions paymentPageOptions, int i, Object obj) {
        KlarnaSourceParams klarnaSourceParams2 = klarnaSourceParams;
        int i2 = i;
        return klarnaSourceParams.copy((i2 & 1) != 0 ? klarnaSourceParams2.purchaseCountry : str, (i2 & 2) != 0 ? klarnaSourceParams2.lineItems : list, (i2 & 4) != 0 ? klarnaSourceParams2.customPaymentMethods : set, (i2 & 8) != 0 ? klarnaSourceParams2.billingEmail : str2, (i2 & 16) != 0 ? klarnaSourceParams2.billingPhone : str3, (i2 & 32) != 0 ? klarnaSourceParams2.billingAddress : address, (i2 & 64) != 0 ? klarnaSourceParams2.billingFirstName : str4, (i2 & 128) != 0 ? klarnaSourceParams2.billingLastName : str5, (i2 & 256) != 0 ? klarnaSourceParams2.billingDob : dateOfBirth, (i2 & 512) != 0 ? klarnaSourceParams2.pageOptions : paymentPageOptions);
    }

    public final String component1() {
        return this.purchaseCountry;
    }

    public final PaymentPageOptions component10() {
        return this.pageOptions;
    }

    public final List<LineItem> component2() {
        return this.lineItems;
    }

    public final Set<CustomPaymentMethods> component3() {
        return this.customPaymentMethods;
    }

    public final String component4() {
        return this.billingEmail;
    }

    public final String component5() {
        return this.billingPhone;
    }

    public final Address component6() {
        return this.billingAddress;
    }

    public final String component7() {
        return this.billingFirstName;
    }

    public final String component8() {
        return this.billingLastName;
    }

    public final DateOfBirth component9() {
        return this.billingDob;
    }

    public final KlarnaSourceParams copy(String str, List<LineItem> list, Set<? extends CustomPaymentMethods> set, String str2, String str3, Address address, String str4, String str5, DateOfBirth dateOfBirth, PaymentPageOptions paymentPageOptions) {
        Intrinsics.checkNotNullParameter(str, "purchaseCountry");
        Intrinsics.checkNotNullParameter(list, "lineItems");
        Intrinsics.checkNotNullParameter(set, "customPaymentMethods");
        return new KlarnaSourceParams(str, list, set, str2, str3, address, str4, str5, dateOfBirth, paymentPageOptions);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KlarnaSourceParams)) {
            return false;
        }
        KlarnaSourceParams klarnaSourceParams = (KlarnaSourceParams) obj;
        return Intrinsics.areEqual((Object) this.purchaseCountry, (Object) klarnaSourceParams.purchaseCountry) && Intrinsics.areEqual((Object) this.lineItems, (Object) klarnaSourceParams.lineItems) && Intrinsics.areEqual((Object) this.customPaymentMethods, (Object) klarnaSourceParams.customPaymentMethods) && Intrinsics.areEqual((Object) this.billingEmail, (Object) klarnaSourceParams.billingEmail) && Intrinsics.areEqual((Object) this.billingPhone, (Object) klarnaSourceParams.billingPhone) && Intrinsics.areEqual((Object) this.billingAddress, (Object) klarnaSourceParams.billingAddress) && Intrinsics.areEqual((Object) this.billingFirstName, (Object) klarnaSourceParams.billingFirstName) && Intrinsics.areEqual((Object) this.billingLastName, (Object) klarnaSourceParams.billingLastName) && Intrinsics.areEqual((Object) this.billingDob, (Object) klarnaSourceParams.billingDob) && Intrinsics.areEqual((Object) this.pageOptions, (Object) klarnaSourceParams.pageOptions);
    }

    public int hashCode() {
        int hashCode = ((((this.purchaseCountry.hashCode() * 31) + this.lineItems.hashCode()) * 31) + this.customPaymentMethods.hashCode()) * 31;
        String str = this.billingEmail;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.billingPhone;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Address address = this.billingAddress;
        int hashCode4 = (hashCode3 + (address == null ? 0 : address.hashCode())) * 31;
        String str3 = this.billingFirstName;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.billingLastName;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        DateOfBirth dateOfBirth = this.billingDob;
        int hashCode7 = (hashCode6 + (dateOfBirth == null ? 0 : dateOfBirth.hashCode())) * 31;
        PaymentPageOptions paymentPageOptions = this.pageOptions;
        if (paymentPageOptions != null) {
            i = paymentPageOptions.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "KlarnaSourceParams(purchaseCountry=" + this.purchaseCountry + ", lineItems=" + this.lineItems + ", customPaymentMethods=" + this.customPaymentMethods + ", billingEmail=" + this.billingEmail + ", billingPhone=" + this.billingPhone + ", billingAddress=" + this.billingAddress + ", billingFirstName=" + this.billingFirstName + ", billingLastName=" + this.billingLastName + ", billingDob=" + this.billingDob + ", pageOptions=" + this.pageOptions + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.purchaseCountry);
        List<LineItem> list = this.lineItems;
        parcel.writeInt(list.size());
        for (LineItem writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i);
        }
        Set<CustomPaymentMethods> set = this.customPaymentMethods;
        parcel.writeInt(set.size());
        for (CustomPaymentMethods name : set) {
            parcel.writeString(name.name());
        }
        parcel.writeString(this.billingEmail);
        parcel.writeString(this.billingPhone);
        Address address = this.billingAddress;
        if (address == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            address.writeToParcel(parcel, i);
        }
        parcel.writeString(this.billingFirstName);
        parcel.writeString(this.billingLastName);
        DateOfBirth dateOfBirth = this.billingDob;
        if (dateOfBirth == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dateOfBirth.writeToParcel(parcel, i);
        }
        PaymentPageOptions paymentPageOptions = this.pageOptions;
        if (paymentPageOptions == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        paymentPageOptions.writeToParcel(parcel, i);
    }

    public KlarnaSourceParams(String str, List<LineItem> list, Set<? extends CustomPaymentMethods> set, String str2, String str3, Address address, String str4, String str5, DateOfBirth dateOfBirth, PaymentPageOptions paymentPageOptions) {
        Intrinsics.checkNotNullParameter(str, "purchaseCountry");
        Intrinsics.checkNotNullParameter(list, "lineItems");
        Intrinsics.checkNotNullParameter(set, "customPaymentMethods");
        this.purchaseCountry = str;
        this.lineItems = list;
        this.customPaymentMethods = set;
        this.billingEmail = str2;
        this.billingPhone = str3;
        this.billingAddress = address;
        this.billingFirstName = str4;
        this.billingLastName = str5;
        this.billingDob = dateOfBirth;
        this.pageOptions = paymentPageOptions;
    }

    public final String getPurchaseCountry() {
        return this.purchaseCountry;
    }

    public final List<LineItem> getLineItems() {
        return this.lineItems;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ KlarnaSourceParams(java.lang.String r14, java.util.List r15, java.util.Set r16, java.lang.String r17, java.lang.String r18, com.stripe.android.model.Address r19, java.lang.String r20, java.lang.String r21, com.stripe.android.model.DateOfBirth r22, com.stripe.android.model.KlarnaSourceParams.PaymentPageOptions r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000c
            java.util.Set r1 = kotlin.collections.SetsKt.emptySet()
            r5 = r1
            goto L_0x000e
        L_0x000c:
            r5 = r16
        L_0x000e:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0015
            r6 = r2
            goto L_0x0017
        L_0x0015:
            r6 = r17
        L_0x0017:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x001d
            r7 = r2
            goto L_0x001f
        L_0x001d:
            r7 = r18
        L_0x001f:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0025
            r8 = r2
            goto L_0x0027
        L_0x0025:
            r8 = r19
        L_0x0027:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002d
            r9 = r2
            goto L_0x002f
        L_0x002d:
            r9 = r20
        L_0x002f:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0035
            r10 = r2
            goto L_0x0037
        L_0x0035:
            r10 = r21
        L_0x0037:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003d
            r11 = r2
            goto L_0x003f
        L_0x003d:
            r11 = r22
        L_0x003f:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0045
            r12 = r2
            goto L_0x0047
        L_0x0045:
            r12 = r23
        L_0x0047:
            r2 = r13
            r3 = r14
            r4 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.KlarnaSourceParams.<init>(java.lang.String, java.util.List, java.util.Set, java.lang.String, java.lang.String, com.stripe.android.model.Address, java.lang.String, java.lang.String, com.stripe.android.model.DateOfBirth, com.stripe.android.model.KlarnaSourceParams$PaymentPageOptions, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Set<CustomPaymentMethods> getCustomPaymentMethods() {
        return this.customPaymentMethods;
    }

    public final String getBillingEmail() {
        return this.billingEmail;
    }

    public final String getBillingPhone() {
        return this.billingPhone;
    }

    public final Address getBillingAddress() {
        return this.billingAddress;
    }

    public final String getBillingFirstName() {
        return this.billingFirstName;
    }

    public final String getBillingLastName() {
        return this.billingLastName;
    }

    public final DateOfBirth getBillingDob() {
        return this.billingDob;
    }

    public final PaymentPageOptions getPageOptions() {
        return this.pageOptions;
    }

    public Map<String, Object> toParamMap() {
        Map map;
        Map map2;
        Map map3;
        Map mapOf = MapsKt.mapOf(TuplesKt.to(PARAM_PRODUCT, "payment"), TuplesKt.to(PARAM_PURCHASE_COUNTRY, this.purchaseCountry));
        Set<CustomPaymentMethods> set = this.customPaymentMethods;
        Map map4 = null;
        if (!(!set.isEmpty())) {
            set = null;
        }
        if (set == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to(PARAM_CUSTOM_PAYMENT_METHODS, CollectionsKt.joinToString$default(CollectionsKt.sortedWith(CollectionsKt.toList(set), new KlarnaSourceParams$toParamMap$lambda2$$inlined$sortedBy$1()), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, KlarnaSourceParams$toParamMap$2$2.INSTANCE, 30, (Object) null)));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        Map plus = MapsKt.plus(mapOf, map);
        String str = this.billingFirstName;
        if (str == null) {
            map2 = null;
        } else {
            map2 = MapsKt.mapOf(TuplesKt.to(PARAM_FIRST_NAME, str));
        }
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        Map plus2 = MapsKt.plus(plus, map2);
        String str2 = this.billingLastName;
        if (str2 == null) {
            map3 = null;
        } else {
            map3 = MapsKt.mapOf(TuplesKt.to(PARAM_LAST_NAME, str2));
        }
        if (map3 == null) {
            map3 = MapsKt.emptyMap();
        }
        Map plus3 = MapsKt.plus(plus2, map3);
        DateOfBirth dateOfBirth = this.billingDob;
        if (dateOfBirth != null) {
            map4 = MapsKt.mapOf(TuplesKt.to(PARAM_DOB_DAY, StringsKt.padStart(String.valueOf(dateOfBirth.getDay()), 2, '0')), TuplesKt.to(PARAM_DOB_MONTH, StringsKt.padStart(String.valueOf(dateOfBirth.getMonth()), 2, '0')), TuplesKt.to(PARAM_DOB_YEAR, String.valueOf(dateOfBirth.getYear())));
        }
        if (map4 == null) {
            map4 = MapsKt.emptyMap();
        }
        return MapsKt.plus(plus3, map4);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001%B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/stripe/android/model/KlarnaSourceParams$LineItem;", "Landroid/os/Parcelable;", "itemType", "Lcom/stripe/android/model/KlarnaSourceParams$LineItem$Type;", "itemDescription", "", "totalAmount", "", "quantity", "(Lcom/stripe/android/model/KlarnaSourceParams$LineItem$Type;Ljava/lang/String;ILjava/lang/Integer;)V", "getItemDescription", "()Ljava/lang/String;", "getItemType", "()Lcom/stripe/android/model/KlarnaSourceParams$LineItem$Type;", "getQuantity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalAmount", "()I", "component1", "component2", "component3", "component4", "copy", "(Lcom/stripe/android/model/KlarnaSourceParams$LineItem$Type;Ljava/lang/String;ILjava/lang/Integer;)Lcom/stripe/android/model/KlarnaSourceParams$LineItem;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Type", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KlarnaSourceParams.kt */
    public static final class LineItem implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<LineItem> CREATOR = new Creator();
        private final String itemDescription;
        private final Type itemType;
        private final Integer quantity;
        private final int totalAmount;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: KlarnaSourceParams.kt */
        public static final class Creator implements Parcelable.Creator<LineItem> {
            public final LineItem createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new LineItem(Type.valueOf(parcel.readString()), parcel.readString(), parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            public final LineItem[] newArray(int i) {
                return new LineItem[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public LineItem(Type type, String str, int i) {
            this(type, str, i, (Integer) null, 8, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(type, "itemType");
            Intrinsics.checkNotNullParameter(str, "itemDescription");
        }

        public static /* synthetic */ LineItem copy$default(LineItem lineItem, Type type, String str, int i, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                type = lineItem.itemType;
            }
            if ((i2 & 2) != 0) {
                str = lineItem.itemDescription;
            }
            if ((i2 & 4) != 0) {
                i = lineItem.totalAmount;
            }
            if ((i2 & 8) != 0) {
                num = lineItem.quantity;
            }
            return lineItem.copy(type, str, i, num);
        }

        public final Type component1() {
            return this.itemType;
        }

        public final String component2() {
            return this.itemDescription;
        }

        public final int component3() {
            return this.totalAmount;
        }

        public final Integer component4() {
            return this.quantity;
        }

        public final LineItem copy(Type type, String str, int i, Integer num) {
            Intrinsics.checkNotNullParameter(type, "itemType");
            Intrinsics.checkNotNullParameter(str, "itemDescription");
            return new LineItem(type, str, i, num);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LineItem)) {
                return false;
            }
            LineItem lineItem = (LineItem) obj;
            return this.itemType == lineItem.itemType && Intrinsics.areEqual((Object) this.itemDescription, (Object) lineItem.itemDescription) && this.totalAmount == lineItem.totalAmount && Intrinsics.areEqual((Object) this.quantity, (Object) lineItem.quantity);
        }

        public int hashCode() {
            int hashCode = ((((this.itemType.hashCode() * 31) + this.itemDescription.hashCode()) * 31) + this.totalAmount) * 31;
            Integer num = this.quantity;
            return hashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "LineItem(itemType=" + this.itemType + ", itemDescription=" + this.itemDescription + ", totalAmount=" + this.totalAmount + ", quantity=" + this.quantity + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.itemType.name());
            parcel.writeString(this.itemDescription);
            parcel.writeInt(this.totalAmount);
            Integer num = this.quantity;
            if (num == null) {
                i2 = 0;
            } else {
                parcel.writeInt(1);
                i2 = num.intValue();
            }
            parcel.writeInt(i2);
        }

        public LineItem(Type type, String str, int i, Integer num) {
            Intrinsics.checkNotNullParameter(type, "itemType");
            Intrinsics.checkNotNullParameter(str, "itemDescription");
            this.itemType = type;
            this.itemDescription = str;
            this.totalAmount = i;
            this.quantity = num;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ LineItem(Type type, String str, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(type, str, i, (i2 & 8) != 0 ? null : num);
        }

        public final Type getItemType() {
            return this.itemType;
        }

        public final String getItemDescription() {
            return this.itemDescription;
        }

        public final int getTotalAmount() {
            return this.totalAmount;
        }

        public final Integer getQuantity() {
            return this.quantity;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/KlarnaSourceParams$LineItem$Type;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "Sku", "Tax", "Shipping", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: KlarnaSourceParams.kt */
        public enum Type {
            Sku("sku"),
            Tax(FirebaseAnalytics.Param.TAX),
            Shipping(FirebaseAnalytics.Param.SHIPPING);
            
            private final String code;

            private Type(String str) {
                this.code = str;
            }

            public final String getCode$payments_core_release() {
                return this.code;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/KlarnaSourceParams$CustomPaymentMethods;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "PayIn4", "Installments", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KlarnaSourceParams.kt */
    public enum CustomPaymentMethods {
        PayIn4("payin4"),
        Installments("installments");
        
        private final String code;

        private CustomPaymentMethods(String str) {
            this.code = str;
        }

        public final String getCode$payments_core_release() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0002$%B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u001dH\u0016J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Lcom/stripe/android/model/KlarnaSourceParams$PaymentPageOptions;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "logoUrl", "", "backgroundImageUrl", "pageTitle", "purchaseType", "Lcom/stripe/android/model/KlarnaSourceParams$PaymentPageOptions$PurchaseType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/KlarnaSourceParams$PaymentPageOptions$PurchaseType;)V", "getBackgroundImageUrl", "()Ljava/lang/String;", "getLogoUrl", "getPageTitle", "getPurchaseType", "()Lcom/stripe/android/model/KlarnaSourceParams$PaymentPageOptions$PurchaseType;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "PurchaseType", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KlarnaSourceParams.kt */
    public static final class PaymentPageOptions implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<PaymentPageOptions> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_BACKGROUND_IMAGE_URL = "background_image_url";
        @Deprecated
        private static final String PARAM_LOGO_URL = "logo_url";
        @Deprecated
        private static final String PARAM_PAGE_TITLE = "page_title";
        @Deprecated
        private static final String PARAM_PURCHASE_TYPE = "purchase_type";
        private final String backgroundImageUrl;
        private final String logoUrl;
        private final String pageTitle;
        private final PurchaseType purchaseType;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: KlarnaSourceParams.kt */
        public static final class Creator implements Parcelable.Creator<PaymentPageOptions> {
            public final PaymentPageOptions createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PaymentPageOptions(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : PurchaseType.valueOf(parcel.readString()));
            }

            public final PaymentPageOptions[] newArray(int i) {
                return new PaymentPageOptions[i];
            }
        }

        public PaymentPageOptions() {
            this((String) null, (String) null, (String) null, (PurchaseType) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PaymentPageOptions copy$default(PaymentPageOptions paymentPageOptions, String str, String str2, String str3, PurchaseType purchaseType2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = paymentPageOptions.logoUrl;
            }
            if ((i & 2) != 0) {
                str2 = paymentPageOptions.backgroundImageUrl;
            }
            if ((i & 4) != 0) {
                str3 = paymentPageOptions.pageTitle;
            }
            if ((i & 8) != 0) {
                purchaseType2 = paymentPageOptions.purchaseType;
            }
            return paymentPageOptions.copy(str, str2, str3, purchaseType2);
        }

        public final String component1() {
            return this.logoUrl;
        }

        public final String component2() {
            return this.backgroundImageUrl;
        }

        public final String component3() {
            return this.pageTitle;
        }

        public final PurchaseType component4() {
            return this.purchaseType;
        }

        public final PaymentPageOptions copy(String str, String str2, String str3, PurchaseType purchaseType2) {
            return new PaymentPageOptions(str, str2, str3, purchaseType2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaymentPageOptions)) {
                return false;
            }
            PaymentPageOptions paymentPageOptions = (PaymentPageOptions) obj;
            return Intrinsics.areEqual((Object) this.logoUrl, (Object) paymentPageOptions.logoUrl) && Intrinsics.areEqual((Object) this.backgroundImageUrl, (Object) paymentPageOptions.backgroundImageUrl) && Intrinsics.areEqual((Object) this.pageTitle, (Object) paymentPageOptions.pageTitle) && this.purchaseType == paymentPageOptions.purchaseType;
        }

        public int hashCode() {
            String str = this.logoUrl;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.backgroundImageUrl;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.pageTitle;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            PurchaseType purchaseType2 = this.purchaseType;
            if (purchaseType2 != null) {
                i = purchaseType2.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "PaymentPageOptions(logoUrl=" + this.logoUrl + ", backgroundImageUrl=" + this.backgroundImageUrl + ", pageTitle=" + this.pageTitle + ", purchaseType=" + this.purchaseType + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.logoUrl);
            parcel.writeString(this.backgroundImageUrl);
            parcel.writeString(this.pageTitle);
            PurchaseType purchaseType2 = this.purchaseType;
            if (purchaseType2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(purchaseType2.name());
        }

        public PaymentPageOptions(String str, String str2, String str3, PurchaseType purchaseType2) {
            this.logoUrl = str;
            this.backgroundImageUrl = str2;
            this.pageTitle = str3;
            this.purchaseType = purchaseType2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PaymentPageOptions(String str, String str2, String str3, PurchaseType purchaseType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : purchaseType2);
        }

        public final String getLogoUrl() {
            return this.logoUrl;
        }

        public final String getBackgroundImageUrl() {
            return this.backgroundImageUrl;
        }

        public final String getPageTitle() {
            return this.pageTitle;
        }

        public final PurchaseType getPurchaseType() {
            return this.purchaseType;
        }

        public Map<String, Object> toParamMap() {
            Map map;
            Map map2;
            Map map3;
            Map emptyMap = MapsKt.emptyMap();
            String str = this.logoUrl;
            Map map4 = null;
            if (str == null) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to(PARAM_LOGO_URL, str));
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            Map plus = MapsKt.plus(emptyMap, map);
            String str2 = this.backgroundImageUrl;
            if (str2 == null) {
                map2 = null;
            } else {
                map2 = MapsKt.mapOf(TuplesKt.to(PARAM_BACKGROUND_IMAGE_URL, str2));
            }
            if (map2 == null) {
                map2 = MapsKt.emptyMap();
            }
            Map plus2 = MapsKt.plus(plus, map2);
            String str3 = this.pageTitle;
            if (str3 == null) {
                map3 = null;
            } else {
                map3 = MapsKt.mapOf(TuplesKt.to(PARAM_PAGE_TITLE, str3));
            }
            if (map3 == null) {
                map3 = MapsKt.emptyMap();
            }
            Map plus3 = MapsKt.plus(plus2, map3);
            PurchaseType purchaseType2 = this.purchaseType;
            if (purchaseType2 != null) {
                map4 = MapsKt.mapOf(TuplesKt.to(PARAM_PURCHASE_TYPE, purchaseType2.getCode()));
            }
            if (map4 == null) {
                map4 = MapsKt.emptyMap();
            }
            return MapsKt.plus(plus3, map4);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/model/KlarnaSourceParams$PaymentPageOptions$PurchaseType;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "Buy", "Rent", "Book", "Subscribe", "Download", "Order", "Continue", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: KlarnaSourceParams.kt */
        public enum PurchaseType {
            Buy("buy"),
            Rent("rent"),
            Book("book"),
            Subscribe("subscribe"),
            Download("download"),
            Order(PayPalRequest.INTENT_ORDER),
            Continue("continue");
            
            private final String code;

            private PurchaseType(String str) {
                this.code = str;
            }

            public final String getCode() {
                return this.code;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/KlarnaSourceParams$PaymentPageOptions$Companion;", "", "()V", "PARAM_BACKGROUND_IMAGE_URL", "", "PARAM_LOGO_URL", "PARAM_PAGE_TITLE", "PARAM_PURCHASE_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: KlarnaSourceParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/KlarnaSourceParams$Companion;", "", "()V", "PARAM_CUSTOM_PAYMENT_METHODS", "", "PARAM_DOB_DAY", "PARAM_DOB_MONTH", "PARAM_DOB_YEAR", "PARAM_FIRST_NAME", "PARAM_LAST_NAME", "PARAM_PRODUCT", "PARAM_PURCHASE_COUNTRY", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: KlarnaSourceParams.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
