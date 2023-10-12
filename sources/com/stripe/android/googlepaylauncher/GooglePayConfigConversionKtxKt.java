package com.stripe.android.googlepaylauncher;

import com.stripe.android.GooglePayJsonFactory;
import com.stripe.android.googlepaylauncher.GooglePayLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"convert", "Lcom/stripe/android/GooglePayJsonFactory$BillingAddressParameters;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig;", "payments-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayConfigConversionKtx.kt */
public final class GooglePayConfigConversionKtxKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayConfigConversionKtx.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[GooglePayLauncher.BillingAddressConfig.Format.values().length];
            iArr[GooglePayLauncher.BillingAddressConfig.Format.Min.ordinal()] = 1;
            iArr[GooglePayLauncher.BillingAddressConfig.Format.Full.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[GooglePayPaymentMethodLauncher.BillingAddressConfig.Format.values().length];
            iArr2[GooglePayPaymentMethodLauncher.BillingAddressConfig.Format.Min.ordinal()] = 1;
            iArr2[GooglePayPaymentMethodLauncher.BillingAddressConfig.Format.Full.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final GooglePayJsonFactory.BillingAddressParameters convert(GooglePayLauncher.BillingAddressConfig billingAddressConfig) {
        GooglePayJsonFactory.BillingAddressParameters.Format format;
        Intrinsics.checkNotNullParameter(billingAddressConfig, "<this>");
        boolean isRequired$payments_core_release = billingAddressConfig.isRequired$payments_core_release();
        int i = WhenMappings.$EnumSwitchMapping$0[billingAddressConfig.getFormat$payments_core_release().ordinal()];
        if (i == 1) {
            format = GooglePayJsonFactory.BillingAddressParameters.Format.Min;
        } else if (i == 2) {
            format = GooglePayJsonFactory.BillingAddressParameters.Format.Full;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new GooglePayJsonFactory.BillingAddressParameters(isRequired$payments_core_release, format, billingAddressConfig.isPhoneNumberRequired$payments_core_release());
    }

    public static final GooglePayJsonFactory.BillingAddressParameters convert(GooglePayPaymentMethodLauncher.BillingAddressConfig billingAddressConfig) {
        GooglePayJsonFactory.BillingAddressParameters.Format format;
        Intrinsics.checkNotNullParameter(billingAddressConfig, "<this>");
        boolean isRequired = billingAddressConfig.isRequired();
        int i = WhenMappings.$EnumSwitchMapping$1[billingAddressConfig.getFormat().ordinal()];
        if (i == 1) {
            format = GooglePayJsonFactory.BillingAddressParameters.Format.Min;
        } else if (i == 2) {
            format = GooglePayJsonFactory.BillingAddressParameters.Format.Full;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new GooglePayJsonFactory.BillingAddressParameters(isRequired, format, billingAddressConfig.isPhoneNumberRequired());
    }
}
