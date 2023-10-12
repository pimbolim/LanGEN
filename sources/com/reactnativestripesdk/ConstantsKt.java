package com.reactnativestripesdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\"\u001a\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0006\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0003\"\u0004\b\b\u0010\u0005\"\u001a\u0010\t\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0003\"\u0004\b\u000b\u0010\u0005\"\u001a\u0010\f\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0003\"\u0004\b\u000e\u0010\u0005\"\u001a\u0010\u000f\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0003\"\u0004\b\u0011\u0010\u0005\"\u001a\u0010\u0012\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0003\"\u0004\b\u0014\u0010\u0005\"\u001a\u0010\u0015\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0003\"\u0004\b\u0017\u0010\u0005¨\u0006\u0018"}, d2 = {"ON_CONFIGURE_FLOW_CONTROLLER", "", "getON_CONFIGURE_FLOW_CONTROLLER", "()Ljava/lang/String;", "setON_CONFIGURE_FLOW_CONTROLLER", "(Ljava/lang/String;)V", "ON_GOOGLE_PAYMENT_METHOD_RESULT", "getON_GOOGLE_PAYMENT_METHOD_RESULT", "setON_GOOGLE_PAYMENT_METHOD_RESULT", "ON_GOOGLE_PAY_RESULT", "getON_GOOGLE_PAY_RESULT", "setON_GOOGLE_PAY_RESULT", "ON_INIT_GOOGLE_PAY", "getON_INIT_GOOGLE_PAY", "setON_INIT_GOOGLE_PAY", "ON_INIT_PAYMENT_SHEET", "getON_INIT_PAYMENT_SHEET", "setON_INIT_PAYMENT_SHEET", "ON_PAYMENT_OPTION_ACTION", "getON_PAYMENT_OPTION_ACTION", "setON_PAYMENT_OPTION_ACTION", "ON_PAYMENT_RESULT_ACTION", "getON_PAYMENT_RESULT_ACTION", "setON_PAYMENT_RESULT_ACTION", "stripe_stripe-react-native_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Constants.kt */
public final class ConstantsKt {
    private static String ON_CONFIGURE_FLOW_CONTROLLER = "com.reactnativestripesdk.CONFIGURE_FLOW_CONTROLLER_ACTION";
    private static String ON_GOOGLE_PAYMENT_METHOD_RESULT = "com.reactnativestripesdk.ON_GOOGLE_PAYMENT_METHOD_RESULT";
    private static String ON_GOOGLE_PAY_RESULT = "com.reactnativestripesdk.ON_GOOGLE_PAY_RESULT";
    private static String ON_INIT_GOOGLE_PAY = "com.reactnativestripesdk.ON_INIT_GOOGLE_PAY";
    private static String ON_INIT_PAYMENT_SHEET = "com.reactnativestripesdk.INIT_PAYMENT_SHEET";
    private static String ON_PAYMENT_OPTION_ACTION = "com.reactnativestripesdk.PAYMENT_OPTION_ACTION";
    private static String ON_PAYMENT_RESULT_ACTION = "com.reactnativestripesdk.PAYMENT_RESULT_ACTION";

    public static final String getON_PAYMENT_RESULT_ACTION() {
        return ON_PAYMENT_RESULT_ACTION;
    }

    public static final void setON_PAYMENT_RESULT_ACTION(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        ON_PAYMENT_RESULT_ACTION = str;
    }

    public static final String getON_PAYMENT_OPTION_ACTION() {
        return ON_PAYMENT_OPTION_ACTION;
    }

    public static final void setON_PAYMENT_OPTION_ACTION(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        ON_PAYMENT_OPTION_ACTION = str;
    }

    public static final String getON_CONFIGURE_FLOW_CONTROLLER() {
        return ON_CONFIGURE_FLOW_CONTROLLER;
    }

    public static final void setON_CONFIGURE_FLOW_CONTROLLER(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        ON_CONFIGURE_FLOW_CONTROLLER = str;
    }

    public static final String getON_INIT_PAYMENT_SHEET() {
        return ON_INIT_PAYMENT_SHEET;
    }

    public static final void setON_INIT_PAYMENT_SHEET(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        ON_INIT_PAYMENT_SHEET = str;
    }

    public static final String getON_INIT_GOOGLE_PAY() {
        return ON_INIT_GOOGLE_PAY;
    }

    public static final void setON_INIT_GOOGLE_PAY(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        ON_INIT_GOOGLE_PAY = str;
    }

    public static final String getON_GOOGLE_PAY_RESULT() {
        return ON_GOOGLE_PAY_RESULT;
    }

    public static final void setON_GOOGLE_PAY_RESULT(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        ON_GOOGLE_PAY_RESULT = str;
    }

    public static final String getON_GOOGLE_PAYMENT_METHOD_RESULT() {
        return ON_GOOGLE_PAYMENT_METHOD_RESULT;
    }

    public static final void setON_GOOGLE_PAYMENT_METHOD_RESULT(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        ON_GOOGLE_PAYMENT_METHOD_RESULT = str;
    }
}
