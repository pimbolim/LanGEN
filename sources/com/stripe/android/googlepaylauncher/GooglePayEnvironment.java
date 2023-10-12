package com.stripe.android.googlepaylauncher;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayEnvironment;", "", "value", "", "(Ljava/lang/String;II)V", "getValue$payments_core_release", "()I", "Production", "Test", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayEnvironment.kt */
public enum GooglePayEnvironment {
    Production(1),
    Test(3);
    
    private final int value;

    private GooglePayEnvironment(int i) {
        this.value = i;
    }

    public final int getValue$payments_core_release() {
        return this.value;
    }
}
