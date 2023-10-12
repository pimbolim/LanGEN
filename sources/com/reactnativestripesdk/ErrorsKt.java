package com.reactnativestripesdk;

import com.braintreepayments.api.internal.GraphQLConstants;
import com.brentvatne.react.ReactVideoView;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.APIException;
import com.stripe.android.core.exception.AuthenticationException;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.exception.CardException;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethodOptionsParams;
import com.stripe.android.model.SetupIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006H\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0007j\u0002`\bH\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH\u0000\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0000\u001aB\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0011"}, d2 = {"createError", "Lcom/facebook/react/bridge/WritableMap;", "code", "", "error", "Lcom/stripe/android/model/PaymentIntent$Error;", "Lcom/stripe/android/model/SetupIntent$Error;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "createMissingActivityError", "mapError", "localizedMessage", "declineCode", "type", "stripeErrorCode", "stripe_stripe-react-native_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Errors.kt */
public final class ErrorsKt {
    public static final WritableMap mapError(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, PaymentMethodOptionsParams.Blik.PARAM_CODE);
        WritableMap writableNativeMap = new WritableNativeMap();
        WritableMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putString(PaymentMethodOptionsParams.Blik.PARAM_CODE, str);
        writableNativeMap2.putString(GraphQLConstants.Keys.MESSAGE, str2);
        writableNativeMap2.putString("localizedMessage", str3);
        writableNativeMap2.putString("declineCode", str4);
        writableNativeMap2.putString("type", str5);
        writableNativeMap2.putString("stripeErrorCode", str6);
        writableNativeMap.putMap(ReactVideoView.EVENT_PROP_ERROR, writableNativeMap2);
        return writableNativeMap;
    }

    public static final WritableMap createError(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, PaymentMethodOptionsParams.Blik.PARAM_CODE);
        return mapError(str, str2, str2, (String) null, (String) null, (String) null);
    }

    public static final WritableMap createMissingActivityError() {
        return mapError("Failed", "Activity doesn't exist yet. You can safely retry this method.", (String) null, (String) null, (String) null, (String) null);
    }

    public static final WritableMap createError(String str, PaymentIntent.Error error) {
        PaymentIntent.Error.Type type;
        Intrinsics.checkNotNullParameter(str, PaymentMethodOptionsParams.Blik.PARAM_CODE);
        String str2 = null;
        String message = error == null ? null : error.getMessage();
        String message2 = error == null ? null : error.getMessage();
        String declineCode = error == null ? null : error.getDeclineCode();
        String code = (error == null || (type = error.getType()) == null) ? null : type.getCode();
        if (error != null) {
            str2 = error.getCode();
        }
        return mapError(str, message, message2, declineCode, code, str2);
    }

    public static final WritableMap createError(String str, SetupIntent.Error error) {
        SetupIntent.Error.Type type;
        Intrinsics.checkNotNullParameter(str, PaymentMethodOptionsParams.Blik.PARAM_CODE);
        String str2 = null;
        String message = error == null ? null : error.getMessage();
        String message2 = error == null ? null : error.getMessage();
        String declineCode = error == null ? null : error.getDeclineCode();
        String code = (error == null || (type = error.getType()) == null) ? null : type.getCode();
        if (error != null) {
            str2 = error.getCode();
        }
        return mapError(str, message, message2, declineCode, code, str2);
    }

    public static final WritableMap createError(String str, Exception exc) {
        Intrinsics.checkNotNullParameter(str, PaymentMethodOptionsParams.Blik.PARAM_CODE);
        Intrinsics.checkNotNullParameter(exc, ReactVideoView.EVENT_PROP_ERROR);
        String str2 = null;
        if (exc instanceof CardException) {
            String message = exc.getMessage();
            CardException cardException = (CardException) exc;
            String localizedMessage = cardException.getLocalizedMessage();
            String declineCode = cardException.getDeclineCode();
            StripeError stripeError = cardException.getStripeError();
            String type = stripeError == null ? null : stripeError.getType();
            StripeError stripeError2 = cardException.getStripeError();
            if (stripeError2 != null) {
                str2 = stripeError2.getCode();
            }
            return mapError(str, message, localizedMessage, declineCode, type, str2);
        } else if (exc instanceof InvalidRequestException) {
            String message2 = exc.getMessage();
            InvalidRequestException invalidRequestException = (InvalidRequestException) exc;
            String localizedMessage2 = invalidRequestException.getLocalizedMessage();
            StripeError stripeError3 = invalidRequestException.getStripeError();
            String declineCode2 = stripeError3 == null ? null : stripeError3.getDeclineCode();
            StripeError stripeError4 = invalidRequestException.getStripeError();
            String type2 = stripeError4 == null ? null : stripeError4.getType();
            StripeError stripeError5 = invalidRequestException.getStripeError();
            if (stripeError5 != null) {
                str2 = stripeError5.getCode();
            }
            return mapError(str, message2, localizedMessage2, declineCode2, type2, str2);
        } else if (exc instanceof AuthenticationException) {
            String message3 = exc.getMessage();
            AuthenticationException authenticationException = (AuthenticationException) exc;
            String localizedMessage3 = authenticationException.getLocalizedMessage();
            StripeError stripeError6 = authenticationException.getStripeError();
            String declineCode3 = stripeError6 == null ? null : stripeError6.getDeclineCode();
            StripeError stripeError7 = authenticationException.getStripeError();
            String type3 = stripeError7 == null ? null : stripeError7.getType();
            StripeError stripeError8 = authenticationException.getStripeError();
            if (stripeError8 != null) {
                str2 = stripeError8.getCode();
            }
            return mapError(str, message3, localizedMessage3, declineCode3, type3, str2);
        } else if (exc instanceof APIException) {
            String message4 = exc.getMessage();
            APIException aPIException = (APIException) exc;
            String localizedMessage4 = aPIException.getLocalizedMessage();
            StripeError stripeError9 = aPIException.getStripeError();
            String declineCode4 = stripeError9 == null ? null : stripeError9.getDeclineCode();
            StripeError stripeError10 = aPIException.getStripeError();
            String type4 = stripeError10 == null ? null : stripeError10.getType();
            StripeError stripeError11 = aPIException.getStripeError();
            if (stripeError11 != null) {
                str2 = stripeError11.getCode();
            }
            return mapError(str, message4, localizedMessage4, declineCode4, type4, str2);
        } else {
            String message5 = exc.getMessage();
            String localizedMessage5 = exc.getLocalizedMessage();
            if (localizedMessage5 == null) {
                localizedMessage5 = "";
            }
            return mapError(str, message5, localizedMessage5, (String) null, (String) null, (String) null);
        }
    }

    public static final WritableMap createError(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, PaymentMethodOptionsParams.Blik.PARAM_CODE);
        Intrinsics.checkNotNullParameter(th, ReactVideoView.EVENT_PROP_ERROR);
        return mapError(str, th.getMessage(), th.getLocalizedMessage(), (String) null, (String) null, (String) null);
    }
}
