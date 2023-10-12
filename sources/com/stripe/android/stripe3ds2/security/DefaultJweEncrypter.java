package com.stripe.android.stripe3ds2.security;

import com.nimbusds.jose.JOSEException;
import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ*\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/DefaultJweEncrypter;", "Lcom/stripe/android/stripe3ds2/security/JweEncrypter;", "ephemeralKeyPairGenerator", "Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "(Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;)V", "jweRsaEncrypter", "Lcom/stripe/android/stripe3ds2/security/JweRsaEncrypter;", "jweEcEncrypter", "Lcom/stripe/android/stripe3ds2/security/JweEcEncrypter;", "(Lcom/stripe/android/stripe3ds2/security/JweRsaEncrypter;Lcom/stripe/android/stripe3ds2/security/JweEcEncrypter;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;)V", "encrypt", "", "payload", "acsPublicKey", "Ljava/security/PublicKey;", "directoryServerId", "keyId", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JweEncrypter.kt */
public final class DefaultJweEncrypter implements JweEncrypter {
    private final ErrorReporter errorReporter;
    private final JweEcEncrypter jweEcEncrypter;
    private final JweRsaEncrypter jweRsaEncrypter;

    private DefaultJweEncrypter(JweRsaEncrypter jweRsaEncrypter2, JweEcEncrypter jweEcEncrypter2, ErrorReporter errorReporter2) {
        this.jweRsaEncrypter = jweRsaEncrypter2;
        this.jweEcEncrypter = jweEcEncrypter2;
        this.errorReporter = errorReporter2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultJweEncrypter(EphemeralKeyPairGenerator ephemeralKeyPairGenerator, ErrorReporter errorReporter2) {
        this(new JweRsaEncrypter(), new JweEcEncrypter(ephemeralKeyPairGenerator, errorReporter2), errorReporter2);
        Intrinsics.checkNotNullParameter(ephemeralKeyPairGenerator, "ephemeralKeyPairGenerator");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
    }

    public String encrypt(String str, PublicKey publicKey, String str2, String str3) throws JOSEException, ParseException {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "payload");
        Intrinsics.checkNotNullParameter(publicKey, "acsPublicKey");
        Intrinsics.checkNotNullParameter(str2, "directoryServerId");
        if (publicKey instanceof RSAPublicKey) {
            Result.Companion companion = Result.Companion;
            obj = Result.m4709constructorimpl(this.jweRsaEncrypter.encrypt(str, (RSAPublicKey) publicKey, str3));
        } else if (publicKey instanceof ECPublicKey) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(this.jweEcEncrypter.encrypt(str, (ECPublicKey) publicKey, str2));
        } else {
            Result.Companion companion3 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(new SDKRuntimeException(Intrinsics.stringPlus("Unsupported public key algorithm: ", publicKey.getAlgorithm()), (Throwable) null, 2, (DefaultConstructorMarker) null)));
        }
        Throwable r3 = Result.m4712exceptionOrNullimpl(obj);
        if (r3 != null) {
            this.errorReporter.reportError(r3);
        }
        ResultKt.throwOnFailure(obj);
        return (String) obj;
    }
}
