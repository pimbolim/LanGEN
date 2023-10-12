package com.stripe.android.stripe3ds2.security;

import java.security.KeyPair;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bà\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;", "", "generate", "Ljava/security/KeyPair;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EphemeralKeyPairGenerator.kt */
public interface EphemeralKeyPairGenerator {
    KeyPair generate();
}
