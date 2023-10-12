package com.stripe.android.stripe3ds2.security;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/Algorithm;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "EC", "RSA", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Algorithm.kt */
public enum Algorithm {
    EC("EC"),
    RSA("RSA");
    
    private final String key;

    private Algorithm(String str) {
        this.key = str;
    }

    public String toString() {
        return this.key;
    }
}
