package com.cardio;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;

public class RNCardIOModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final int CARD_IO_SCAN = 1;
    private Promise promise;

    public String getName() {
        return "RCTCardIOModule";
    }

    public void onNewIntent(Intent intent) {
    }

    public RNCardIOModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void scanCard(ReadableMap readableMap, Promise promise2) {
        this.promise = promise2;
        Activity currentActivity = getCurrentActivity();
        Intent intent = new Intent(currentActivity, CardIOActivity.class);
        intent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true);
        intent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, true);
        parseConfig(readableMap, intent);
        if (currentActivity != null) {
            currentActivity.startActivityForResult(intent, 1);
        }
    }

    public void parseConfig(ReadableMap readableMap, Intent intent) {
        if (readableMap.hasKey("languageOrLocale")) {
            intent.putExtra(CardIOActivity.EXTRA_LANGUAGE_OR_LOCALE, readableMap.getString("languageOrLocale"));
        }
        if (readableMap.hasKey("guideColor")) {
            intent.putExtra(CardIOActivity.EXTRA_GUIDE_COLOR, Color.parseColor(readableMap.getString("guideColor")));
        }
        if (readableMap.hasKey("useCardIOLogo")) {
            intent.putExtra(CardIOActivity.EXTRA_USE_CARDIO_LOGO, readableMap.getBoolean("useCardIOLogo"));
        }
        if (readableMap.hasKey("hideCardIOLogo")) {
            intent.putExtra(CardIOActivity.EXTRA_HIDE_CARDIO_LOGO, readableMap.getBoolean("hideCardIOLogo"));
        }
        if (readableMap.hasKey("scanInstructions")) {
            intent.putExtra(CardIOActivity.EXTRA_SCAN_INSTRUCTIONS, readableMap.getString("scanInstructions"));
        }
        if (readableMap.hasKey("suppressManualEntry")) {
            intent.putExtra(CardIOActivity.EXTRA_SUPPRESS_MANUAL_ENTRY, readableMap.getBoolean("suppressManualEntry"));
        }
        if (readableMap.hasKey("suppressConfirmation")) {
            intent.putExtra(CardIOActivity.EXTRA_SUPPRESS_CONFIRMATION, readableMap.getBoolean("suppressConfirmation"));
        }
        if (readableMap.hasKey("requireExpiry")) {
            intent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, readableMap.getBoolean("requireExpiry"));
        }
        if (readableMap.hasKey("scanExpiry")) {
            intent.putExtra(CardIOActivity.EXTRA_SCAN_EXPIRY, readableMap.getBoolean("scanExpiry"));
        }
        if (readableMap.hasKey("requireCVV")) {
            intent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, readableMap.getBoolean("requireCVV"));
        }
        if (readableMap.hasKey("requirePostalCode")) {
            intent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, readableMap.getBoolean("requirePostalCode"));
        }
        if (readableMap.hasKey("restrictPostalCodeToNumericOnly")) {
            intent.putExtra(CardIOActivity.EXTRA_RESTRICT_POSTAL_CODE_TO_NUMERIC_ONLY, readableMap.getBoolean("restrictPostalCodeToNumericOnly"));
        }
        if (readableMap.hasKey("requireCardholderName")) {
            intent.putExtra(CardIOActivity.EXTRA_REQUIRE_CARDHOLDER_NAME, readableMap.getBoolean("requireCardholderName"));
        }
        if (readableMap.hasKey("noCamera")) {
            intent.putExtra(CardIOActivity.EXTRA_NO_CAMERA, readableMap.getBoolean("noCamera"));
        }
        if (readableMap.hasKey("unblurDigits")) {
            intent.putExtra(CardIOActivity.EXTRA_UNBLUR_DIGITS, readableMap.getInt("unblurDigits"));
        }
        if (readableMap.hasKey("usePaypalActionbarIcon")) {
            intent.putExtra(CardIOActivity.EXTRA_USE_PAYPAL_ACTIONBAR_ICON, readableMap.getBoolean("usePaypalActionbarIcon"));
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (this.promise != null && i == 1) {
            if (intent == null || !intent.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
                this.promise.reject("user_cancelled", "The user cancelled");
                return;
            }
            CreditCard creditCard = (CreditCard) intent.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("cardType", creditCard.getCardType().getDisplayName(intent.getStringExtra(CardIOActivity.EXTRA_LANGUAGE_OR_LOCALE)));
            createMap.putString("cardNumber", creditCard.cardNumber);
            createMap.putString("redactedCardNumber", creditCard.getRedactedCardNumber());
            createMap.putInt("expiryMonth", creditCard.expiryMonth);
            createMap.putInt("expiryYear", creditCard.expiryYear);
            createMap.putString("cvv", creditCard.cvv);
            createMap.putString("postalCode", creditCard.postalCode);
            createMap.putString("cardholderName", creditCard.cardholderName);
            this.promise.resolve(createMap);
        }
    }
}
