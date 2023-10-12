package com.stripe.android;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.ShippingMethod;
import com.stripe.android.view.BillingAddressFields;
import com.stripe.android.view.ShippingInfoWidget;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u0000 X2\u00020\u0001:\u0005WXYZ[BÅ\u0001\b\u0000\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0003\u0010\u000b\u001a\u00020\f\u0012\b\b\u0003\u0010\r\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001dJ\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012HÆ\u0003J\t\u00108\u001a\u00020\u0015HÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\u000e\u0010:\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b;J\u000e\u0010<\u001a\u00020\u0019HÀ\u0003¢\u0006\u0002\b=J\u0010\u0010>\u001a\u0004\u0018\u00010\u001bHÀ\u0003¢\u0006\u0002\b?J\u0012\u0010@\u001a\u0004\u0018\u00010\fHÀ\u0003¢\u0006\u0004\bA\u00104J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\t\u0010E\u001a\u00020\tHÆ\u0003J\t\u0010F\u001a\u00020\fHÆ\u0003J\t\u0010G\u001a\u00020\fHÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0003J\t\u0010I\u001a\u00020\tHÆ\u0003JÌ\u0001\u0010J\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0002\u0010\u0010\u001a\u00020\t2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010KJ\t\u0010L\u001a\u00020\fHÖ\u0001J\u0013\u0010M\u001a\u00020\t2\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\fHÖ\u0001J\t\u0010Q\u001a\u00020\u0013HÖ\u0001J\u0019\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\fHÖ\u0001R\u0013\u0010\r\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010%R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010%R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0013\u0010\u000b\u001a\u00020\f8\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0014\u0010\u0017\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104¨\u0006\\"}, d2 = {"Lcom/stripe/android/PaymentSessionConfig;", "Landroid/os/Parcelable;", "hiddenShippingInfoFields", "", "Lcom/stripe/android/view/ShippingInfoWidget$CustomizableShippingField;", "optionalShippingInfoFields", "prepopulatedShippingInfo", "Lcom/stripe/android/model/ShippingInformation;", "isShippingInfoRequired", "", "isShippingMethodRequired", "paymentMethodsFooterLayoutId", "", "addPaymentMethodFooterLayoutId", "paymentMethodTypes", "Lcom/stripe/android/model/PaymentMethod$Type;", "shouldShowGooglePay", "allowedShippingCountryCodes", "", "", "billingAddressFields", "Lcom/stripe/android/view/BillingAddressFields;", "canDeletePaymentMethods", "shouldPrefetchCustomer", "shippingInformationValidator", "Lcom/stripe/android/PaymentSessionConfig$ShippingInformationValidator;", "shippingMethodsFactory", "Lcom/stripe/android/PaymentSessionConfig$ShippingMethodsFactory;", "windowFlags", "(Ljava/util/List;Ljava/util/List;Lcom/stripe/android/model/ShippingInformation;ZZIILjava/util/List;ZLjava/util/Set;Lcom/stripe/android/view/BillingAddressFields;ZZLcom/stripe/android/PaymentSessionConfig$ShippingInformationValidator;Lcom/stripe/android/PaymentSessionConfig$ShippingMethodsFactory;Ljava/lang/Integer;)V", "getAddPaymentMethodFooterLayoutId", "()I", "getAllowedShippingCountryCodes", "()Ljava/util/Set;", "getBillingAddressFields", "()Lcom/stripe/android/view/BillingAddressFields;", "getCanDeletePaymentMethods", "()Z", "getHiddenShippingInfoFields", "()Ljava/util/List;", "getOptionalShippingInfoFields", "getPaymentMethodTypes", "getPaymentMethodsFooterLayoutId", "getPrepopulatedShippingInfo", "()Lcom/stripe/android/model/ShippingInformation;", "getShippingInformationValidator$payments_core_release", "()Lcom/stripe/android/PaymentSessionConfig$ShippingInformationValidator;", "getShippingMethodsFactory$payments_core_release", "()Lcom/stripe/android/PaymentSessionConfig$ShippingMethodsFactory;", "getShouldPrefetchCustomer$payments_core_release", "getShouldShowGooglePay", "getWindowFlags$payments_core_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component12", "component13", "component13$payments_core_release", "component14", "component14$payments_core_release", "component15", "component15$payments_core_release", "component16", "component16$payments_core_release", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/util/List;Lcom/stripe/android/model/ShippingInformation;ZZIILjava/util/List;ZLjava/util/Set;Lcom/stripe/android/view/BillingAddressFields;ZZLcom/stripe/android/PaymentSessionConfig$ShippingInformationValidator;Lcom/stripe/android/PaymentSessionConfig$ShippingMethodsFactory;Ljava/lang/Integer;)Lcom/stripe/android/PaymentSessionConfig;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "DefaultShippingInfoValidator", "ShippingInformationValidator", "ShippingMethodsFactory", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSessionConfig.kt */
public final class PaymentSessionConfig implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaymentSessionConfig> CREATOR = new Creator();
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final BillingAddressFields DEFAULT_BILLING_ADDRESS_FIELDS = BillingAddressFields.PostalCode;
    private final int addPaymentMethodFooterLayoutId;
    private final Set<String> allowedShippingCountryCodes;
    private final BillingAddressFields billingAddressFields;
    private final boolean canDeletePaymentMethods;
    private final List<ShippingInfoWidget.CustomizableShippingField> hiddenShippingInfoFields;
    private final boolean isShippingInfoRequired;
    private final boolean isShippingMethodRequired;
    private final List<ShippingInfoWidget.CustomizableShippingField> optionalShippingInfoFields;
    private final List<PaymentMethod.Type> paymentMethodTypes;
    private final int paymentMethodsFooterLayoutId;
    private final ShippingInformation prepopulatedShippingInfo;
    private final ShippingInformationValidator shippingInformationValidator;
    private final ShippingMethodsFactory shippingMethodsFactory;
    private final boolean shouldPrefetchCustomer;
    private final boolean shouldShowGooglePay;
    private final Integer windowFlags;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionConfig.kt */
    public static final class Creator implements Parcelable.Creator<PaymentSessionConfig> {
        public final PaymentSessionConfig createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(ShippingInfoWidget.CustomizableShippingField.valueOf(parcel.readString()));
            }
            List list = arrayList;
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                arrayList2.add(ShippingInfoWidget.CustomizableShippingField.valueOf(parcel.readString()));
            }
            List list2 = arrayList2;
            ShippingInformation createFromParcel = parcel.readInt() == 0 ? null : ShippingInformation.CREATOR.createFromParcel(parcel2);
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            int readInt5 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(readInt5);
            for (int i3 = 0; i3 != readInt5; i3++) {
                arrayList3.add(PaymentMethod.Type.CREATOR.createFromParcel(parcel2));
            }
            List list3 = arrayList3;
            boolean z3 = parcel.readInt() != 0;
            int readInt6 = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(readInt6);
            for (int i4 = 0; i4 != readInt6; i4++) {
                linkedHashSet.add(parcel.readString());
            }
            return new PaymentSessionConfig(list, list2, createFromParcel, z, z2, readInt3, readInt4, list3, z3, linkedHashSet, BillingAddressFields.valueOf(parcel.readString()), parcel.readInt() != 0, parcel.readInt() != 0, (ShippingInformationValidator) parcel.readSerializable(), (ShippingMethodsFactory) parcel.readSerializable(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        public final PaymentSessionConfig[] newArray(int i) {
            return new PaymentSessionConfig[i];
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/stripe/android/PaymentSessionConfig$DefaultShippingInfoValidator;", "Lcom/stripe/android/PaymentSessionConfig$ShippingInformationValidator;", "()V", "getErrorMessage", "", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "isValid", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionConfig.kt */
    private static final class DefaultShippingInfoValidator implements ShippingInformationValidator {
        public String getErrorMessage(ShippingInformation shippingInformation) {
            Intrinsics.checkNotNullParameter(shippingInformation, "shippingInformation");
            return "";
        }

        public boolean isValid(ShippingInformation shippingInformation) {
            Intrinsics.checkNotNullParameter(shippingInformation, "shippingInformation");
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\b"}, d2 = {"Lcom/stripe/android/PaymentSessionConfig$ShippingInformationValidator;", "Ljava/io/Serializable;", "getErrorMessage", "", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "isValid", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionConfig.kt */
    public interface ShippingInformationValidator extends Serializable {
        String getErrorMessage(ShippingInformation shippingInformation);

        boolean isValid(ShippingInformation shippingInformation);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/PaymentSessionConfig$ShippingMethodsFactory;", "Ljava/io/Serializable;", "create", "", "Lcom/stripe/android/model/ShippingMethod;", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionConfig.kt */
    public interface ShippingMethodsFactory extends Serializable {
        List<ShippingMethod> create(ShippingInformation shippingInformation);
    }

    public PaymentSessionConfig() {
        this((List) null, (List) null, (ShippingInformation) null, false, false, 0, 0, (List) null, false, (Set) null, (BillingAddressFields) null, false, false, (ShippingInformationValidator) null, (ShippingMethodsFactory) null, (Integer) null, 65535, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaymentSessionConfig copy$default(PaymentSessionConfig paymentSessionConfig, List list, List list2, ShippingInformation shippingInformation, boolean z, boolean z2, int i, int i2, List list3, boolean z3, Set set, BillingAddressFields billingAddressFields2, boolean z4, boolean z5, ShippingInformationValidator shippingInformationValidator2, ShippingMethodsFactory shippingMethodsFactory2, Integer num, int i3, Object obj) {
        PaymentSessionConfig paymentSessionConfig2 = paymentSessionConfig;
        int i4 = i3;
        return paymentSessionConfig.copy((i4 & 1) != 0 ? paymentSessionConfig2.hiddenShippingInfoFields : list, (i4 & 2) != 0 ? paymentSessionConfig2.optionalShippingInfoFields : list2, (i4 & 4) != 0 ? paymentSessionConfig2.prepopulatedShippingInfo : shippingInformation, (i4 & 8) != 0 ? paymentSessionConfig2.isShippingInfoRequired : z, (i4 & 16) != 0 ? paymentSessionConfig2.isShippingMethodRequired : z2, (i4 & 32) != 0 ? paymentSessionConfig2.paymentMethodsFooterLayoutId : i, (i4 & 64) != 0 ? paymentSessionConfig2.addPaymentMethodFooterLayoutId : i2, (i4 & 128) != 0 ? paymentSessionConfig2.paymentMethodTypes : list3, (i4 & 256) != 0 ? paymentSessionConfig2.shouldShowGooglePay : z3, (i4 & 512) != 0 ? paymentSessionConfig2.allowedShippingCountryCodes : set, (i4 & 1024) != 0 ? paymentSessionConfig2.billingAddressFields : billingAddressFields2, (i4 & 2048) != 0 ? paymentSessionConfig2.canDeletePaymentMethods : z4, (i4 & 4096) != 0 ? paymentSessionConfig2.shouldPrefetchCustomer : z5, (i4 & 8192) != 0 ? paymentSessionConfig2.shippingInformationValidator : shippingInformationValidator2, (i4 & 16384) != 0 ? paymentSessionConfig2.shippingMethodsFactory : shippingMethodsFactory2, (i4 & 32768) != 0 ? paymentSessionConfig2.windowFlags : num);
    }

    public final List<ShippingInfoWidget.CustomizableShippingField> component1() {
        return this.hiddenShippingInfoFields;
    }

    public final Set<String> component10() {
        return this.allowedShippingCountryCodes;
    }

    public final BillingAddressFields component11() {
        return this.billingAddressFields;
    }

    public final boolean component12() {
        return this.canDeletePaymentMethods;
    }

    public final boolean component13$payments_core_release() {
        return this.shouldPrefetchCustomer;
    }

    public final ShippingInformationValidator component14$payments_core_release() {
        return this.shippingInformationValidator;
    }

    public final ShippingMethodsFactory component15$payments_core_release() {
        return this.shippingMethodsFactory;
    }

    public final Integer component16$payments_core_release() {
        return this.windowFlags;
    }

    public final List<ShippingInfoWidget.CustomizableShippingField> component2() {
        return this.optionalShippingInfoFields;
    }

    public final ShippingInformation component3() {
        return this.prepopulatedShippingInfo;
    }

    public final boolean component4() {
        return this.isShippingInfoRequired;
    }

    public final boolean component5() {
        return this.isShippingMethodRequired;
    }

    public final int component6() {
        return this.paymentMethodsFooterLayoutId;
    }

    public final int component7() {
        return this.addPaymentMethodFooterLayoutId;
    }

    public final List<PaymentMethod.Type> component8() {
        return this.paymentMethodTypes;
    }

    public final boolean component9() {
        return this.shouldShowGooglePay;
    }

    public final PaymentSessionConfig copy(List<? extends ShippingInfoWidget.CustomizableShippingField> list, List<? extends ShippingInfoWidget.CustomizableShippingField> list2, ShippingInformation shippingInformation, boolean z, boolean z2, int i, int i2, List<? extends PaymentMethod.Type> list3, boolean z3, Set<String> set, BillingAddressFields billingAddressFields2, boolean z4, boolean z5, ShippingInformationValidator shippingInformationValidator2, ShippingMethodsFactory shippingMethodsFactory2, Integer num) {
        List<? extends ShippingInfoWidget.CustomizableShippingField> list4 = list;
        Intrinsics.checkNotNullParameter(list4, "hiddenShippingInfoFields");
        Intrinsics.checkNotNullParameter(list2, "optionalShippingInfoFields");
        Intrinsics.checkNotNullParameter(list3, "paymentMethodTypes");
        Intrinsics.checkNotNullParameter(set, "allowedShippingCountryCodes");
        Intrinsics.checkNotNullParameter(billingAddressFields2, "billingAddressFields");
        Intrinsics.checkNotNullParameter(shippingInformationValidator2, "shippingInformationValidator");
        return new PaymentSessionConfig(list4, list2, shippingInformation, z, z2, i, i2, list3, z3, set, billingAddressFields2, z4, z5, shippingInformationValidator2, shippingMethodsFactory2, num);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentSessionConfig)) {
            return false;
        }
        PaymentSessionConfig paymentSessionConfig = (PaymentSessionConfig) obj;
        return Intrinsics.areEqual((Object) this.hiddenShippingInfoFields, (Object) paymentSessionConfig.hiddenShippingInfoFields) && Intrinsics.areEqual((Object) this.optionalShippingInfoFields, (Object) paymentSessionConfig.optionalShippingInfoFields) && Intrinsics.areEqual((Object) this.prepopulatedShippingInfo, (Object) paymentSessionConfig.prepopulatedShippingInfo) && this.isShippingInfoRequired == paymentSessionConfig.isShippingInfoRequired && this.isShippingMethodRequired == paymentSessionConfig.isShippingMethodRequired && this.paymentMethodsFooterLayoutId == paymentSessionConfig.paymentMethodsFooterLayoutId && this.addPaymentMethodFooterLayoutId == paymentSessionConfig.addPaymentMethodFooterLayoutId && Intrinsics.areEqual((Object) this.paymentMethodTypes, (Object) paymentSessionConfig.paymentMethodTypes) && this.shouldShowGooglePay == paymentSessionConfig.shouldShowGooglePay && Intrinsics.areEqual((Object) this.allowedShippingCountryCodes, (Object) paymentSessionConfig.allowedShippingCountryCodes) && this.billingAddressFields == paymentSessionConfig.billingAddressFields && this.canDeletePaymentMethods == paymentSessionConfig.canDeletePaymentMethods && this.shouldPrefetchCustomer == paymentSessionConfig.shouldPrefetchCustomer && Intrinsics.areEqual((Object) this.shippingInformationValidator, (Object) paymentSessionConfig.shippingInformationValidator) && Intrinsics.areEqual((Object) this.shippingMethodsFactory, (Object) paymentSessionConfig.shippingMethodsFactory) && Intrinsics.areEqual((Object) this.windowFlags, (Object) paymentSessionConfig.windowFlags);
    }

    public int hashCode() {
        int hashCode = ((this.hiddenShippingInfoFields.hashCode() * 31) + this.optionalShippingInfoFields.hashCode()) * 31;
        ShippingInformation shippingInformation = this.prepopulatedShippingInfo;
        int i = 0;
        int hashCode2 = (hashCode + (shippingInformation == null ? 0 : shippingInformation.hashCode())) * 31;
        boolean z = this.isShippingInfoRequired;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.isShippingMethodRequired;
        if (z3) {
            z3 = true;
        }
        int hashCode3 = (((((((i2 + (z3 ? 1 : 0)) * 31) + this.paymentMethodsFooterLayoutId) * 31) + this.addPaymentMethodFooterLayoutId) * 31) + this.paymentMethodTypes.hashCode()) * 31;
        boolean z4 = this.shouldShowGooglePay;
        if (z4) {
            z4 = true;
        }
        int hashCode4 = (((((hashCode3 + (z4 ? 1 : 0)) * 31) + this.allowedShippingCountryCodes.hashCode()) * 31) + this.billingAddressFields.hashCode()) * 31;
        boolean z5 = this.canDeletePaymentMethods;
        if (z5) {
            z5 = true;
        }
        int i3 = (hashCode4 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.shouldPrefetchCustomer;
        if (!z6) {
            z2 = z6;
        }
        int hashCode5 = (((i3 + (z2 ? 1 : 0)) * 31) + this.shippingInformationValidator.hashCode()) * 31;
        ShippingMethodsFactory shippingMethodsFactory2 = this.shippingMethodsFactory;
        int hashCode6 = (hashCode5 + (shippingMethodsFactory2 == null ? 0 : shippingMethodsFactory2.hashCode())) * 31;
        Integer num = this.windowFlags;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "PaymentSessionConfig(hiddenShippingInfoFields=" + this.hiddenShippingInfoFields + ", optionalShippingInfoFields=" + this.optionalShippingInfoFields + ", prepopulatedShippingInfo=" + this.prepopulatedShippingInfo + ", isShippingInfoRequired=" + this.isShippingInfoRequired + ", isShippingMethodRequired=" + this.isShippingMethodRequired + ", paymentMethodsFooterLayoutId=" + this.paymentMethodsFooterLayoutId + ", addPaymentMethodFooterLayoutId=" + this.addPaymentMethodFooterLayoutId + ", paymentMethodTypes=" + this.paymentMethodTypes + ", shouldShowGooglePay=" + this.shouldShowGooglePay + ", allowedShippingCountryCodes=" + this.allowedShippingCountryCodes + ", billingAddressFields=" + this.billingAddressFields + ", canDeletePaymentMethods=" + this.canDeletePaymentMethods + ", shouldPrefetchCustomer=" + this.shouldPrefetchCustomer + ", shippingInformationValidator=" + this.shippingInformationValidator + ", shippingMethodsFactory=" + this.shippingMethodsFactory + ", windowFlags=" + this.windowFlags + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<ShippingInfoWidget.CustomizableShippingField> list = this.hiddenShippingInfoFields;
        parcel.writeInt(list.size());
        for (ShippingInfoWidget.CustomizableShippingField name : list) {
            parcel.writeString(name.name());
        }
        List<ShippingInfoWidget.CustomizableShippingField> list2 = this.optionalShippingInfoFields;
        parcel.writeInt(list2.size());
        for (ShippingInfoWidget.CustomizableShippingField name2 : list2) {
            parcel.writeString(name2.name());
        }
        ShippingInformation shippingInformation = this.prepopulatedShippingInfo;
        if (shippingInformation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            shippingInformation.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.isShippingInfoRequired ? 1 : 0);
        parcel.writeInt(this.isShippingMethodRequired ? 1 : 0);
        parcel.writeInt(this.paymentMethodsFooterLayoutId);
        parcel.writeInt(this.addPaymentMethodFooterLayoutId);
        List<PaymentMethod.Type> list3 = this.paymentMethodTypes;
        parcel.writeInt(list3.size());
        for (PaymentMethod.Type writeToParcel : list3) {
            writeToParcel.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.shouldShowGooglePay ? 1 : 0);
        Set<String> set = this.allowedShippingCountryCodes;
        parcel.writeInt(set.size());
        for (String writeString : set) {
            parcel.writeString(writeString);
        }
        parcel.writeString(this.billingAddressFields.name());
        parcel.writeInt(this.canDeletePaymentMethods ? 1 : 0);
        parcel.writeInt(this.shouldPrefetchCustomer ? 1 : 0);
        parcel.writeSerializable(this.shippingInformationValidator);
        parcel.writeSerializable(this.shippingMethodsFactory);
        Integer num = this.windowFlags;
        if (num == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num.intValue());
    }

    public PaymentSessionConfig(List<? extends ShippingInfoWidget.CustomizableShippingField> list, List<? extends ShippingInfoWidget.CustomizableShippingField> list2, ShippingInformation shippingInformation, boolean z, boolean z2, int i, int i2, List<? extends PaymentMethod.Type> list3, boolean z3, Set<String> set, BillingAddressFields billingAddressFields2, boolean z4, boolean z5, ShippingInformationValidator shippingInformationValidator2, ShippingMethodsFactory shippingMethodsFactory2, Integer num) {
        List<? extends PaymentMethod.Type> list4 = list3;
        Set<String> set2 = set;
        BillingAddressFields billingAddressFields3 = billingAddressFields2;
        ShippingInformationValidator shippingInformationValidator3 = shippingInformationValidator2;
        Intrinsics.checkNotNullParameter(list, "hiddenShippingInfoFields");
        Intrinsics.checkNotNullParameter(list2, "optionalShippingInfoFields");
        Intrinsics.checkNotNullParameter(list4, "paymentMethodTypes");
        Intrinsics.checkNotNullParameter(set2, "allowedShippingCountryCodes");
        Intrinsics.checkNotNullParameter(billingAddressFields3, "billingAddressFields");
        Intrinsics.checkNotNullParameter(shippingInformationValidator3, "shippingInformationValidator");
        this.hiddenShippingInfoFields = list;
        this.optionalShippingInfoFields = list2;
        this.prepopulatedShippingInfo = shippingInformation;
        this.isShippingInfoRequired = z;
        this.isShippingMethodRequired = z2;
        this.paymentMethodsFooterLayoutId = i;
        this.addPaymentMethodFooterLayoutId = i2;
        this.paymentMethodTypes = list4;
        this.shouldShowGooglePay = z3;
        this.allowedShippingCountryCodes = set2;
        this.billingAddressFields = billingAddressFields3;
        this.canDeletePaymentMethods = z4;
        this.shouldPrefetchCustomer = z5;
        this.shippingInformationValidator = shippingInformationValidator3;
        this.shippingMethodsFactory = shippingMethodsFactory2;
        this.windowFlags = num;
        String[] iSOCountries = Locale.getISOCountries();
        for (String str : set2) {
            Intrinsics.checkNotNullExpressionValue(iSOCountries, "countryCodes");
            int length = iSOCountries.length;
            boolean z6 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                String str2 = iSOCountries[i3];
                i3++;
                if (StringsKt.equals(str, str2, true)) {
                    z6 = true;
                    continue;
                    break;
                }
            }
            if (!z6) {
                throw new IllegalArgumentException(('\'' + str + "' is not a valid country code").toString());
            }
        }
        if (this.isShippingMethodRequired && this.shippingMethodsFactory == null) {
            throw new IllegalArgumentException("If isShippingMethodRequired is true a ShippingMethodsFactory must also be provided.".toString());
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentSessionConfig(java.util.List r18, java.util.List r19, com.stripe.android.model.ShippingInformation r20, boolean r21, boolean r22, int r23, int r24, java.util.List r25, boolean r26, java.util.Set r27, com.stripe.android.view.BillingAddressFields r28, boolean r29, boolean r30, com.stripe.android.PaymentSessionConfig.ShippingInformationValidator r31, com.stripe.android.PaymentSessionConfig.ShippingMethodsFactory r32, java.lang.Integer r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000b
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x000d
        L_0x000b:
            r1 = r18
        L_0x000d:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0016
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0018
        L_0x0016:
            r2 = r19
        L_0x0018:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x001e
            r3 = 0
            goto L_0x0020
        L_0x001e:
            r3 = r20
        L_0x0020:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0027
            r5 = 0
            goto L_0x0029
        L_0x0027:
            r5 = r21
        L_0x0029:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002f
            r7 = 0
            goto L_0x0031
        L_0x002f:
            r7 = r22
        L_0x0031:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0037
            r8 = 0
            goto L_0x0039
        L_0x0037:
            r8 = r23
        L_0x0039:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003f
            r9 = 0
            goto L_0x0041
        L_0x003f:
            r9 = r24
        L_0x0041:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x004c
            com.stripe.android.model.PaymentMethod$Type r10 = com.stripe.android.model.PaymentMethod.Type.Card
            java.util.List r10 = kotlin.collections.CollectionsKt.listOf(r10)
            goto L_0x004e
        L_0x004c:
            r10 = r25
        L_0x004e:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r6 = r26
        L_0x0055:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x005e
            java.util.Set r11 = kotlin.collections.SetsKt.emptySet()
            goto L_0x0060
        L_0x005e:
            r11 = r27
        L_0x0060:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0067
            com.stripe.android.view.BillingAddressFields r12 = DEFAULT_BILLING_ADDRESS_FIELDS
            goto L_0x0069
        L_0x0067:
            r12 = r28
        L_0x0069:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            r14 = 1
            if (r13 == 0) goto L_0x0070
            r13 = 1
            goto L_0x0072
        L_0x0070:
            r13 = r29
        L_0x0072:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r14 = r30
        L_0x0079:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0085
            com.stripe.android.PaymentSessionConfig$DefaultShippingInfoValidator r15 = new com.stripe.android.PaymentSessionConfig$DefaultShippingInfoValidator
            r15.<init>()
            com.stripe.android.PaymentSessionConfig$ShippingInformationValidator r15 = (com.stripe.android.PaymentSessionConfig.ShippingInformationValidator) r15
            goto L_0x0087
        L_0x0085:
            r15 = r31
        L_0x0087:
            r4 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r4 == 0) goto L_0x008d
            r4 = 0
            goto L_0x008f
        L_0x008d:
            r4 = r32
        L_0x008f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x0098
            r0 = 0
            goto L_0x009a
        L_0x0098:
            r0 = r33
        L_0x009a:
            r18 = r17
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r5
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r6
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r4
            r34 = r0
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.PaymentSessionConfig.<init>(java.util.List, java.util.List, com.stripe.android.model.ShippingInformation, boolean, boolean, int, int, java.util.List, boolean, java.util.Set, com.stripe.android.view.BillingAddressFields, boolean, boolean, com.stripe.android.PaymentSessionConfig$ShippingInformationValidator, com.stripe.android.PaymentSessionConfig$ShippingMethodsFactory, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<ShippingInfoWidget.CustomizableShippingField> getHiddenShippingInfoFields() {
        return this.hiddenShippingInfoFields;
    }

    public final List<ShippingInfoWidget.CustomizableShippingField> getOptionalShippingInfoFields() {
        return this.optionalShippingInfoFields;
    }

    public final ShippingInformation getPrepopulatedShippingInfo() {
        return this.prepopulatedShippingInfo;
    }

    public final boolean isShippingInfoRequired() {
        return this.isShippingInfoRequired;
    }

    public final boolean isShippingMethodRequired() {
        return this.isShippingMethodRequired;
    }

    public final int getPaymentMethodsFooterLayoutId() {
        return this.paymentMethodsFooterLayoutId;
    }

    public final int getAddPaymentMethodFooterLayoutId() {
        return this.addPaymentMethodFooterLayoutId;
    }

    public final List<PaymentMethod.Type> getPaymentMethodTypes() {
        return this.paymentMethodTypes;
    }

    public final boolean getShouldShowGooglePay() {
        return this.shouldShowGooglePay;
    }

    public final Set<String> getAllowedShippingCountryCodes() {
        return this.allowedShippingCountryCodes;
    }

    public final BillingAddressFields getBillingAddressFields() {
        return this.billingAddressFields;
    }

    public final boolean getCanDeletePaymentMethods() {
        return this.canDeletePaymentMethods;
    }

    public final boolean getShouldPrefetchCustomer$payments_core_release() {
        return this.shouldPrefetchCustomer;
    }

    public final ShippingInformationValidator getShippingInformationValidator$payments_core_release() {
        return this.shippingInformationValidator;
    }

    public final ShippingMethodsFactory getShippingMethodsFactory$payments_core_release() {
        return this.shippingMethodsFactory;
    }

    public final Integer getWindowFlags$payments_core_release() {
        return this.windowFlags;
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u000f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0005J\u0014\u0010\"\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u001f\u0010%\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0&\"\u00020\u000f¢\u0006\u0002\u0010'J\u001f\u0010(\u001a\u00020\u00002\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0&\"\u00020\u000f¢\u0006\u0002\u0010'J\u0014\u0010)\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eJ\u0010\u0010*\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u0005J\u0010\u0010+\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\u0016J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\fJ\u0010\u0010.\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010/\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fJ\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\fJ\u000e\u00102\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\fJ\u0015\u00103\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00104R\u0012\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u001f¨\u00065"}, d2 = {"Lcom/stripe/android/PaymentSessionConfig$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/PaymentSessionConfig;", "()V", "addPaymentMethodFooterLayoutId", "", "allowedShippingCountryCodes", "", "", "billingAddressFields", "Lcom/stripe/android/view/BillingAddressFields;", "canDeletePaymentMethods", "", "hiddenShippingInfoFields", "", "Lcom/stripe/android/view/ShippingInfoWidget$CustomizableShippingField;", "optionalShippingInfoFields", "paymentMethodTypes", "Lcom/stripe/android/model/PaymentMethod$Type;", "paymentMethodsFooterLayoutId", "shippingInfoRequired", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "shippingInformationValidator", "Lcom/stripe/android/PaymentSessionConfig$ShippingInformationValidator;", "shippingMethodsFactory", "Lcom/stripe/android/PaymentSessionConfig$ShippingMethodsFactory;", "shippingMethodsRequired", "shouldPrefetchCustomer", "shouldShowGooglePay", "windowFlags", "Ljava/lang/Integer;", "build", "setAddPaymentMethodFooter", "setAllowedShippingCountryCodes", "setBillingAddressFields", "setCanDeletePaymentMethods", "setHiddenShippingInfoFields", "", "([Lcom/stripe/android/view/ShippingInfoWidget$CustomizableShippingField;)Lcom/stripe/android/PaymentSessionConfig$Builder;", "setOptionalShippingInfoFields", "setPaymentMethodTypes", "setPaymentMethodsFooter", "setPrepopulatedShippingInfo", "shippingInfo", "setShippingInfoRequired", "setShippingInformationValidator", "setShippingMethodsFactory", "setShippingMethodsRequired", "setShouldPrefetchCustomer", "setShouldShowGooglePay", "setWindowFlags", "(Ljava/lang/Integer;)Lcom/stripe/android/PaymentSessionConfig$Builder;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionConfig.kt */
    public static final class Builder implements ObjectBuilder<PaymentSessionConfig> {
        public static final int $stable = 8;
        private int addPaymentMethodFooterLayoutId;
        private Set<String> allowedShippingCountryCodes = SetsKt.emptySet();
        private BillingAddressFields billingAddressFields = PaymentSessionConfig.DEFAULT_BILLING_ADDRESS_FIELDS;
        private boolean canDeletePaymentMethods = true;
        private List<? extends ShippingInfoWidget.CustomizableShippingField> hiddenShippingInfoFields;
        private List<? extends ShippingInfoWidget.CustomizableShippingField> optionalShippingInfoFields;
        private List<? extends PaymentMethod.Type> paymentMethodTypes = CollectionsKt.listOf(PaymentMethod.Type.Card);
        private int paymentMethodsFooterLayoutId;
        private boolean shippingInfoRequired = true;
        private ShippingInformation shippingInformation;
        private ShippingInformationValidator shippingInformationValidator;
        private ShippingMethodsFactory shippingMethodsFactory;
        private boolean shippingMethodsRequired = true;
        private boolean shouldPrefetchCustomer = true;
        private boolean shouldShowGooglePay;
        private Integer windowFlags;

        public final Builder setBillingAddressFields(BillingAddressFields billingAddressFields2) {
            Intrinsics.checkNotNullParameter(billingAddressFields2, "billingAddressFields");
            Builder builder = this;
            builder.billingAddressFields = billingAddressFields2;
            return builder;
        }

        public final Builder setHiddenShippingInfoFields(ShippingInfoWidget.CustomizableShippingField... customizableShippingFieldArr) {
            Intrinsics.checkNotNullParameter(customizableShippingFieldArr, "hiddenShippingInfoFields");
            Builder builder = this;
            builder.hiddenShippingInfoFields = CollectionsKt.listOf(Arrays.copyOf(customizableShippingFieldArr, customizableShippingFieldArr.length));
            return builder;
        }

        public final Builder setOptionalShippingInfoFields(ShippingInfoWidget.CustomizableShippingField... customizableShippingFieldArr) {
            Intrinsics.checkNotNullParameter(customizableShippingFieldArr, "optionalShippingInfoFields");
            Builder builder = this;
            builder.optionalShippingInfoFields = CollectionsKt.listOf(Arrays.copyOf(customizableShippingFieldArr, customizableShippingFieldArr.length));
            return builder;
        }

        public final Builder setPrepopulatedShippingInfo(ShippingInformation shippingInformation2) {
            Builder builder = this;
            builder.shippingInformation = shippingInformation2;
            return builder;
        }

        public final Builder setShippingInfoRequired(boolean z) {
            Builder builder = this;
            builder.shippingInfoRequired = z;
            return builder;
        }

        public final Builder setShippingMethodsRequired(boolean z) {
            Builder builder = this;
            builder.shippingMethodsRequired = z;
            return builder;
        }

        public final Builder setPaymentMethodsFooter(int i) {
            Builder builder = this;
            builder.paymentMethodsFooterLayoutId = i;
            return builder;
        }

        public final Builder setAddPaymentMethodFooter(int i) {
            Builder builder = this;
            builder.addPaymentMethodFooterLayoutId = i;
            return builder;
        }

        public final Builder setPaymentMethodTypes(List<? extends PaymentMethod.Type> list) {
            Intrinsics.checkNotNullParameter(list, "paymentMethodTypes");
            Builder builder = this;
            builder.paymentMethodTypes = list;
            return builder;
        }

        public final Builder setShouldShowGooglePay(boolean z) {
            Builder builder = this;
            builder.shouldShowGooglePay = z;
            return builder;
        }

        public final Builder setCanDeletePaymentMethods(boolean z) {
            Builder builder = this;
            builder.canDeletePaymentMethods = z;
            return builder;
        }

        public final Builder setAllowedShippingCountryCodes(Set<String> set) {
            Intrinsics.checkNotNullParameter(set, "allowedShippingCountryCodes");
            Builder builder = this;
            builder.allowedShippingCountryCodes = set;
            return builder;
        }

        public final Builder setWindowFlags(Integer num) {
            Builder builder = this;
            builder.windowFlags = num;
            return builder;
        }

        public final Builder setShippingInformationValidator(ShippingInformationValidator shippingInformationValidator2) {
            Builder builder = this;
            builder.shippingInformationValidator = shippingInformationValidator2;
            return builder;
        }

        public final Builder setShippingMethodsFactory(ShippingMethodsFactory shippingMethodsFactory2) {
            Builder builder = this;
            builder.shippingMethodsFactory = shippingMethodsFactory2;
            return builder;
        }

        public final Builder setShouldPrefetchCustomer(boolean z) {
            Builder builder = this;
            builder.shouldPrefetchCustomer = z;
            return builder;
        }

        public PaymentSessionConfig build() {
            List<? extends ShippingInfoWidget.CustomizableShippingField> list = this.hiddenShippingInfoFields;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            List<? extends ShippingInfoWidget.CustomizableShippingField> list2 = list;
            List<? extends ShippingInfoWidget.CustomizableShippingField> list3 = this.optionalShippingInfoFields;
            if (list3 == null) {
                list3 = CollectionsKt.emptyList();
            }
            List<? extends ShippingInfoWidget.CustomizableShippingField> list4 = list3;
            ShippingInformation shippingInformation2 = this.shippingInformation;
            boolean z = this.shippingInfoRequired;
            boolean z2 = this.shippingMethodsRequired;
            int i = this.paymentMethodsFooterLayoutId;
            int i2 = this.addPaymentMethodFooterLayoutId;
            List<? extends PaymentMethod.Type> list5 = this.paymentMethodTypes;
            boolean z3 = this.shouldShowGooglePay;
            Set<String> set = this.allowedShippingCountryCodes;
            ShippingInformationValidator shippingInformationValidator2 = this.shippingInformationValidator;
            if (shippingInformationValidator2 == null) {
                shippingInformationValidator2 = new DefaultShippingInfoValidator();
            }
            BillingAddressFields billingAddressFields2 = this.billingAddressFields;
            boolean z4 = this.shouldPrefetchCustomer;
            return new PaymentSessionConfig(list2, list4, shippingInformation2, z, z2, i, i2, list5, z3, set, billingAddressFields2, this.canDeletePaymentMethods, z4, shippingInformationValidator2, this.shippingMethodsFactory, this.windowFlags);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/PaymentSessionConfig$Companion;", "", "()V", "DEFAULT_BILLING_ADDRESS_FIELDS", "Lcom/stripe/android/view/BillingAddressFields;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionConfig.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
