package com.reactnativecommunity.geolocation;

import com.braintreepayments.api.internal.GraphQLConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.iid.InstanceID;
import com.stripe.android.model.PaymentMethodOptionsParams;

public class PositionError {
    public static int PERMISSION_DENIED = 1;
    public static int POSITION_UNAVAILABLE = 2;
    public static int TIMEOUT = 3;

    public static WritableMap buildError(int i, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(PaymentMethodOptionsParams.Blik.PARAM_CODE, i);
        if (str != null) {
            createMap.putString(GraphQLConstants.Keys.MESSAGE, str);
        }
        createMap.putInt("PERMISSION_DENIED", PERMISSION_DENIED);
        createMap.putInt("POSITION_UNAVAILABLE", POSITION_UNAVAILABLE);
        createMap.putInt(InstanceID.ERROR_TIMEOUT, TIMEOUT);
        return createMap;
    }
}
