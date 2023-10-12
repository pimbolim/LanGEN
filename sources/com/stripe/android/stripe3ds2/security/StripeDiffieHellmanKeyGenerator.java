package com.stripe.android.stripe3ds2.security;

import com.nimbusds.jose.crypto.impl.ConcatKDF;
import com.nimbusds.jose.crypto.impl.ECDH;
import com.nimbusds.jose.util.Base64URL;
import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.security.Provider;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/StripeDiffieHellmanKeyGenerator;", "Lcom/stripe/android/stripe3ds2/security/DiffieHellmanKeyGenerator;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "(Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;)V", "generate", "Ljavax/crypto/SecretKey;", "acsPublicKey", "Ljava/security/interfaces/ECPublicKey;", "sdkPrivateKey", "Ljava/security/interfaces/ECPrivateKey;", "agreementInfo", "", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeDiffieHellmanKeyGenerator.kt */
public final class StripeDiffieHellmanKeyGenerator implements DiffieHellmanKeyGenerator {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String HASH_ALGO = "SHA-256";
    @Deprecated
    private static final int KEY_LENGTH = 256;
    private final ErrorReporter errorReporter;

    public StripeDiffieHellmanKeyGenerator(ErrorReporter errorReporter2) {
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        this.errorReporter = errorReporter2;
    }

    public SecretKey generate(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(eCPublicKey, "acsPublicKey");
        Intrinsics.checkNotNullParameter(eCPrivateKey, "sdkPrivateKey");
        Intrinsics.checkNotNullParameter(str, "agreementInfo");
        try {
            Result.Companion companion = Result.Companion;
            StripeDiffieHellmanKeyGenerator stripeDiffieHellmanKeyGenerator = this;
            obj = Result.m4709constructorimpl(new ConcatKDF("SHA-256").deriveKey(ECDH.deriveSharedSecret(eCPublicKey, eCPrivateKey, (Provider) null), 256, ConcatKDF.encodeStringData((String) null), ConcatKDF.encodeDataWithLength((Base64URL) null), ConcatKDF.encodeDataWithLength(Base64URL.encode(str)), ConcatKDF.encodeIntData(256), ConcatKDF.encodeNoData()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r11 = Result.m4712exceptionOrNullimpl(obj);
        if (r11 != null) {
            this.errorReporter.reportError(r11);
        }
        Throwable r112 = Result.m4712exceptionOrNullimpl(obj);
        if (r112 == null) {
            Intrinsics.checkNotNullExpressionValue(obj, "runCatching {\n          …meException(it)\n        }");
            return (SecretKey) obj;
        }
        throw new SDKRuntimeException(r112);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/StripeDiffieHellmanKeyGenerator$Companion;", "", "()V", "HASH_ALGO", "", "KEY_LENGTH", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeDiffieHellmanKeyGenerator.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
