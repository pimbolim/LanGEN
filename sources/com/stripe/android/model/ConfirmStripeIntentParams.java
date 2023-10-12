package com.stripe.android.model;

import android.os.Parcelable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0001\u000eJ\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\n\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/model/ConfirmStripeIntentParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "clientSecret", "", "getClientSecret", "()Ljava/lang/String;", "returnUrl", "getReturnUrl", "setReturnUrl", "(Ljava/lang/String;)V", "shouldUseStripeSdk", "", "withShouldUseStripeSdk", "Companion", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfirmStripeIntentParams.kt */
public interface ConfirmStripeIntentParams extends StripeParamsModel, Parcelable {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String PARAM_CLIENT_SECRET = "client_secret";
    public static final String PARAM_MANDATE_DATA = "mandate_data";
    public static final String PARAM_MANDATE_ID = "mandate";
    public static final String PARAM_PAYMENT_METHOD_DATA = "payment_method_data";
    public static final String PARAM_PAYMENT_METHOD_ID = "payment_method";
    public static final String PARAM_RETURN_URL = "return_url";
    public static final String PARAM_USE_STRIPE_SDK = "use_stripe_sdk";

    String getClientSecret();

    String getReturnUrl();

    void setReturnUrl(String str);

    boolean shouldUseStripeSdk();

    ConfirmStripeIntentParams withShouldUseStripeSdk(boolean z);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/ConfirmStripeIntentParams$Companion;", "", "()V", "PARAM_CLIENT_SECRET", "", "PARAM_MANDATE_DATA", "PARAM_MANDATE_ID", "PARAM_PAYMENT_METHOD_DATA", "PARAM_PAYMENT_METHOD_ID", "PARAM_RETURN_URL", "PARAM_USE_STRIPE_SDK", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfirmStripeIntentParams.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String PARAM_CLIENT_SECRET = "client_secret";
        public static final String PARAM_MANDATE_DATA = "mandate_data";
        public static final String PARAM_MANDATE_ID = "mandate";
        public static final String PARAM_PAYMENT_METHOD_DATA = "payment_method_data";
        public static final String PARAM_PAYMENT_METHOD_ID = "payment_method";
        public static final String PARAM_RETURN_URL = "return_url";
        public static final String PARAM_USE_STRIPE_SDK = "use_stripe_sdk";

        private Companion() {
        }
    }
}
