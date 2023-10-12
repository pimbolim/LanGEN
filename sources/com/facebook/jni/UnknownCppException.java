package com.facebook.jni;

import com.braintreepayments.api.models.BinData;

public class UnknownCppException extends CppException {
    public UnknownCppException() {
        super(BinData.UNKNOWN);
    }

    public UnknownCppException(String str) {
        super(str);
    }
}
