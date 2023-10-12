package com.stripe.android.stripe3ds2.security;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.RSAEncrypter;
import java.security.interfaces.RSAPublicKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/JweRsaEncrypter;", "", "()V", "createJweObject", "Lcom/nimbusds/jose/JWEObject;", "payload", "", "keyId", "encrypt", "publicKey", "Ljava/security/interfaces/RSAPublicKey;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JweRsaEncrypter.kt */
public final class JweRsaEncrypter {
    public final String encrypt(String str, RSAPublicKey rSAPublicKey, String str2) throws JOSEException {
        Intrinsics.checkNotNullParameter(str, "payload");
        Intrinsics.checkNotNullParameter(rSAPublicKey, "publicKey");
        JWEObject createJweObject = createJweObject(str, str2);
        createJweObject.encrypt(new RSAEncrypter(rSAPublicKey));
        String serialize = createJweObject.serialize();
        Intrinsics.checkNotNullExpressionValue(serialize, "jwe.serialize()");
        return serialize;
    }

    public final JWEObject createJweObject(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "payload");
        return new JWEObject(new JWEHeader.Builder(JWEAlgorithm.RSA_OAEP_256, EncryptionMethod.A128CBC_HS256).keyID(str2).build(), new Payload(str));
    }
}
