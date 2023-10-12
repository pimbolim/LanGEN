package com.stripe.android.stripe3ds2.security;

import java.security.PublicKey;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0001\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&¨\u0006\t"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/JweEncrypter;", "", "encrypt", "", "payload", "acsPublicKey", "Ljava/security/PublicKey;", "directoryServerId", "keyId", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JweEncrypter.kt */
public interface JweEncrypter {
    String encrypt(String str, PublicKey publicKey, String str2, String str3);
}
