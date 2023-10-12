package com.stripe.android.stripe3ds2.security;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.text.ParseException;
import java.util.Objects;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/JweEcEncrypter;", "", "ephemeralKeyPairGenerator", "Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "(Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;)V", "dhKeyGenerator", "Lcom/stripe/android/stripe3ds2/security/DiffieHellmanKeyGenerator;", "(Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;Lcom/stripe/android/stripe3ds2/security/DiffieHellmanKeyGenerator;)V", "encrypt", "", "payload", "acsPublicKey", "Ljava/security/interfaces/ECPublicKey;", "directoryServerId", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JweEcEncrypter.kt */
public final class JweEcEncrypter {
    private final DiffieHellmanKeyGenerator dhKeyGenerator;
    private final EphemeralKeyPairGenerator ephemeralKeyPairGenerator;

    private JweEcEncrypter(EphemeralKeyPairGenerator ephemeralKeyPairGenerator2, DiffieHellmanKeyGenerator diffieHellmanKeyGenerator) {
        this.ephemeralKeyPairGenerator = ephemeralKeyPairGenerator2;
        this.dhKeyGenerator = diffieHellmanKeyGenerator;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public JweEcEncrypter(EphemeralKeyPairGenerator ephemeralKeyPairGenerator2, ErrorReporter errorReporter) {
        this(ephemeralKeyPairGenerator2, (DiffieHellmanKeyGenerator) new StripeDiffieHellmanKeyGenerator(errorReporter));
        Intrinsics.checkNotNullParameter(ephemeralKeyPairGenerator2, "ephemeralKeyPairGenerator");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
    }

    public final String encrypt(String str, ECPublicKey eCPublicKey, String str2) throws ParseException, JOSEException {
        Intrinsics.checkNotNullParameter(str, "payload");
        Intrinsics.checkNotNullParameter(eCPublicKey, "acsPublicKey");
        Intrinsics.checkNotNullParameter(str2, "directoryServerId");
        JWTClaimsSet.parse(str);
        KeyPair generate = this.ephemeralKeyPairGenerator.generate();
        DiffieHellmanKeyGenerator diffieHellmanKeyGenerator = this.dhKeyGenerator;
        PrivateKey privateKey = generate.getPrivate();
        Objects.requireNonNull(privateKey, "null cannot be cast to non-null type java.security.interfaces.ECPrivateKey");
        SecretKey generate2 = diffieHellmanKeyGenerator.generate(eCPublicKey, (ECPrivateKey) privateKey, str2);
        Curve curve = Curve.P_256;
        PublicKey publicKey = generate.getPublic();
        Objects.requireNonNull(publicKey, "null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        JWEObject jWEObject = new JWEObject(new JWEHeader.Builder(JWEAlgorithm.DIR, EncryptionMethod.A128CBC_HS256).ephemeralPublicKey(ECKey.parse(new ECKey.Builder(curve, (ECPublicKey) publicKey).build().toJSONString())).build(), new Payload(str));
        jWEObject.encrypt(new DirectEncrypter(generate2));
        String serialize = jWEObject.serialize();
        Intrinsics.checkNotNullExpressionValue(serialize, "jweObject.serialize()");
        return serialize;
    }
}
