package com.smarkets.paypal;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.braintreepayments.api.BraintreeFragment;
import com.braintreepayments.api.DataCollector;
import com.braintreepayments.api.PayPal;
import com.braintreepayments.api.exceptions.ErrorWithResponse;
import com.braintreepayments.api.exceptions.InvalidArgumentException;
import com.braintreepayments.api.interfaces.BraintreeCancelListener;
import com.braintreepayments.api.interfaces.BraintreeErrorListener;
import com.braintreepayments.api.interfaces.BraintreeResponseListener;
import com.braintreepayments.api.interfaces.PaymentMethodNonceCreatedListener;
import com.braintreepayments.api.models.PayPalAccountNonce;
import com.braintreepayments.api.models.PayPalRequest;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;

public class RNPaypalModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final String TAG = "RNPaypal";
    /* access modifiers changed from: private */
    public Promise promise;

    public String getName() {
        return TAG;
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    public void onNewIntent(Intent intent) {
    }

    public RNPaypalModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void requestOneTimePayment(String str, ReadableMap readableMap, Promise promise2) {
        this.promise = promise2;
        try {
            BraintreeFragment initializeBraintreeFragment = initializeBraintreeFragment(str);
            PayPalRequest intent = new PayPalRequest(readableMap.getString(BaseSheetViewModel.SAVE_AMOUNT)).intent(PayPalRequest.INTENT_AUTHORIZE);
            if (readableMap.hasKey(FirebaseAnalytics.Param.CURRENCY)) {
                intent.currencyCode(readableMap.getString(FirebaseAnalytics.Param.CURRENCY));
            }
            if (readableMap.hasKey("displayName")) {
                intent.displayName(readableMap.getString("displayName"));
            }
            if (readableMap.hasKey("localeCode")) {
                intent.localeCode(readableMap.getString("localeCode"));
            }
            if (readableMap.hasKey("shippingAddressRequired")) {
                intent.shippingAddressRequired(readableMap.getBoolean("shippingAddressRequired"));
            }
            if (readableMap.hasKey("userAction") && PayPalRequest.USER_ACTION_COMMIT.equals(readableMap.getString("userAction"))) {
                intent.userAction(PayPalRequest.USER_ACTION_COMMIT);
            }
            if (readableMap.hasKey("intent")) {
                String string = readableMap.getString("intent");
                string.hashCode();
                if (string.equals(PayPalRequest.INTENT_SALE)) {
                    intent.intent(PayPalRequest.INTENT_SALE);
                } else if (string.equals(PayPalRequest.INTENT_ORDER)) {
                    intent.intent(PayPalRequest.INTENT_ORDER);
                }
            }
            PayPal.requestOneTimePayment(initializeBraintreeFragment, intent);
        } catch (Exception e) {
            promise2.reject("braintree_sdk_setup_failed", (Throwable) e);
        }
    }

    /* access modifiers changed from: protected */
    public BraintreeFragment initializeBraintreeFragment(String str) throws InvalidArgumentException {
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity == null) {
            this.promise.reject("creation_error", "Something went wrong");
            return null;
        }
        BraintreeFragment newInstance = BraintreeFragment.newInstance(fragmentActivity, str);
        newInstance.addListener(new BraintreeCancelListener() {
            public void onCancel(int i) {
                RNPaypalModule.this.promise.reject("user_cancellation", "User cancelled one time payment");
            }
        });
        newInstance.addListener(new PaymentMethodNonceCreatedListener() {
            public void onPaymentMethodNonceCreated(PaymentMethodNonce paymentMethodNonce) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("nonce", paymentMethodNonce.getNonce());
                if (paymentMethodNonce instanceof PayPalAccountNonce) {
                    PayPalAccountNonce payPalAccountNonce = (PayPalAccountNonce) paymentMethodNonce;
                    createMap.putString("payerId", payPalAccountNonce.getPayerId());
                    createMap.putString("email", payPalAccountNonce.getEmail());
                    createMap.putString("firstName", payPalAccountNonce.getFirstName());
                    createMap.putString("lastName", payPalAccountNonce.getLastName());
                    createMap.putString("phone", payPalAccountNonce.getPhone());
                }
                RNPaypalModule.this.promise.resolve(createMap);
            }
        });
        newInstance.addListener(new BraintreeErrorListener() {
            public void onError(Exception exc) {
                if (exc instanceof ErrorWithResponse) {
                    RNPaypalModule.this.promise.reject("request_one_time_payment_error", ((ErrorWithResponse) exc).getErrorResponse());
                }
            }
        });
        return newInstance;
    }

    @ReactMethod
    public void requestBillingAgreement(String str, ReadableMap readableMap, Promise promise2) {
        this.promise = promise2;
        try {
            if (readableMap.hasKey("billingAgreementDescription")) {
                BraintreeFragment initializeBraintreeFragment = initializeBraintreeFragment(str);
                PayPalRequest billingAgreementDescription = new PayPalRequest().billingAgreementDescription(readableMap.getString("billingAgreementDescription"));
                if (readableMap.hasKey(FirebaseAnalytics.Param.CURRENCY)) {
                    billingAgreementDescription.currencyCode(readableMap.getString(FirebaseAnalytics.Param.CURRENCY));
                }
                if (readableMap.hasKey("localeCode")) {
                    billingAgreementDescription.localeCode(readableMap.getString("localeCode"));
                }
                PayPal.requestBillingAgreement(initializeBraintreeFragment, billingAgreementDescription);
                return;
            }
            throw new Exception("billingAgreementDescription prop is required");
        } catch (Exception e) {
            promise2.reject("braintree_sdk_setup_failed", (Throwable) e);
        }
    }

    @ReactMethod
    public void requestDeviceData(String str, final Promise promise2) {
        this.promise = promise2;
        try {
            DataCollector.collectDeviceData(initializeBraintreeFragment(str), new BraintreeResponseListener<String>() {
                public void onResponse(String str) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("deviceData", str);
                    promise2.resolve(createMap);
                }
            });
        } catch (Exception e) {
            promise2.reject("braintree_sdk_setup_failed", (Throwable) e);
        }
    }
}
