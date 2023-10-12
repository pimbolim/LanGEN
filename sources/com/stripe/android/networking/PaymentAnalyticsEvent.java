package com.stripe.android.networking;

import com.stripe.android.core.networking.AnalyticsEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\bA\b\u0001\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001DB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bC¨\u0006E"}, d2 = {"Lcom/stripe/android/networking/PaymentAnalyticsEvent;", "", "Lcom/stripe/android/core/networking/AnalyticsEvent;", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "eventName", "getEventName", "toString", "TokenCreate", "PaymentMethodCreate", "CustomerRetrieve", "CustomerRetrievePaymentMethods", "CustomerAttachPaymentMethod", "CustomerDetachPaymentMethod", "CustomerDeleteSource", "CustomerSetShippingInfo", "CustomerAddSource", "CustomerSetDefaultSource", "IssuingRetrievePin", "IssuingUpdatePin", "SourceCreate", "SourceRetrieve", "PaymentIntentConfirm", "PaymentIntentRetrieve", "PaymentIntentCancelSource", "PaymentIntentRefresh", "SetupIntentConfirm", "SetupIntentRetrieve", "SetupIntentCancelSource", "FileCreate", "Auth3ds1Sdk", "Auth3ds1ChallengeStart", "Auth3ds1ChallengeError", "Auth3ds1ChallengeComplete", "AuthWithWebView", "AuthWithCustomTabs", "AuthWithDefaultBrowser", "ConfirmReturnUrlNull", "ConfirmReturnUrlDefault", "ConfirmReturnUrlCustom", "FpxBankStatusesRetrieve", "StripeUrlRetrieve", "Auth3ds2RequestParamsFailed", "Auth3ds2Fingerprint", "Auth3ds2Start", "Auth3ds2Frictionless", "Auth3ds2ChallengePresented", "Auth3ds2ChallengeCanceled", "Auth3ds2ChallengeCompleted", "Auth3ds2ChallengeErrored", "Auth3ds2ChallengeTimedOut", "Auth3ds2Fallback", "AuthRedirect", "AuthError", "AuthSourceStart", "AuthSourceRedirect", "AuthSourceResult", "RadarSessionCreate", "GooglePayLauncherInit", "GooglePayPaymentMethodLauncherInit", "CardMetadataPublishableKeyAvailable", "CardMetadataPublishableKeyUnavailable", "CardMetadataLoadedTooSlow", "CardMetadataLoadFailure", "CardMetadataMissingRange", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAnalyticsEvent.kt */
public enum PaymentAnalyticsEvent implements AnalyticsEvent {
    TokenCreate("token_creation"),
    PaymentMethodCreate("payment_method_creation"),
    CustomerRetrieve("retrieve_customer"),
    CustomerRetrievePaymentMethods("retrieve_payment_methods"),
    CustomerAttachPaymentMethod("attach_payment_method"),
    CustomerDetachPaymentMethod("detach_payment_method"),
    CustomerDeleteSource("delete_source"),
    CustomerSetShippingInfo("set_shipping_info"),
    CustomerAddSource("add_source"),
    CustomerSetDefaultSource("default_source"),
    IssuingRetrievePin("issuing_retrieve_pin"),
    IssuingUpdatePin("issuing_update_pin"),
    SourceCreate("source_creation"),
    SourceRetrieve("retrieve_source"),
    PaymentIntentConfirm("payment_intent_confirmation"),
    PaymentIntentRetrieve("payment_intent_retrieval"),
    PaymentIntentCancelSource("payment_intent_cancel_source"),
    PaymentIntentRefresh("payment_intent_refresh"),
    SetupIntentConfirm("setup_intent_confirmation"),
    SetupIntentRetrieve("setup_intent_retrieval"),
    SetupIntentCancelSource("setup_intent_cancel_source"),
    FileCreate("create_file"),
    Auth3ds1Sdk("3ds1_sdk"),
    Auth3ds1ChallengeStart("3ds1_challenge_start"),
    Auth3ds1ChallengeError("3ds1_challenge_error"),
    Auth3ds1ChallengeComplete("3ds1_challenge_complete"),
    AuthWithWebView("auth_with_webview"),
    AuthWithCustomTabs("auth_with_customtabs"),
    AuthWithDefaultBrowser("auth_with_defaultbrowser"),
    ConfirmReturnUrlNull("confirm_returnurl_null"),
    ConfirmReturnUrlDefault("confirm_returnurl_default"),
    ConfirmReturnUrlCustom("confirm_returnurl_custom"),
    FpxBankStatusesRetrieve("retrieve_fpx_bank_statuses"),
    StripeUrlRetrieve("retrieve_stripe_url"),
    Auth3ds2RequestParamsFailed("3ds2_authentication_request_params_failed"),
    Auth3ds2Fingerprint("3ds2_fingerprint"),
    Auth3ds2Start("3ds2_authenticate"),
    Auth3ds2Frictionless("3ds2_frictionless_flow"),
    Auth3ds2ChallengePresented("3ds2_challenge_flow_presented"),
    Auth3ds2ChallengeCanceled("3ds2_challenge_flow_canceled"),
    Auth3ds2ChallengeCompleted("3ds2_challenge_flow_completed"),
    Auth3ds2ChallengeErrored("3ds2_challenge_flow_errored"),
    Auth3ds2ChallengeTimedOut("3ds2_challenge_flow_timed_out"),
    Auth3ds2Fallback("3ds2_fallback"),
    AuthRedirect("url_redirect_next_action"),
    AuthError("auth_error"),
    AuthSourceStart("auth_source_start"),
    AuthSourceRedirect("auth_source_redirect"),
    AuthSourceResult("auth_source_result"),
    RadarSessionCreate("radar_session_create"),
    GooglePayLauncherInit("googlepaylauncher_init"),
    GooglePayPaymentMethodLauncherInit("googlepaypaymentmethodlauncher_init"),
    CardMetadataPublishableKeyAvailable("card_metadata_pk_available"),
    CardMetadataPublishableKeyUnavailable("card_metadata_pk_unavailable"),
    CardMetadataLoadedTooSlow("card_metadata_loaded_too_slow"),
    CardMetadataLoadFailure("card_metadata_load_failure"),
    CardMetadataMissingRange("card_metadata_missing_range");
    
    private static final Companion Companion = null;
    @Deprecated
    private static final String PREFIX = "stripe_android";
    private final String code;

    private PaymentAnalyticsEvent(String str) {
        this.code = str;
    }

    public final String getCode() {
        return this.code;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public String toString() {
        return Intrinsics.stringPlus("stripe_android.", this.code);
    }

    public String getEventName() {
        return toString();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/networking/PaymentAnalyticsEvent$Companion;", "", "()V", "PREFIX", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAnalyticsEvent.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
