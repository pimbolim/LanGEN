package com.stripe.android.stripe3ds2.security;

import com.nimbusds.jose.jwk.Curve;
import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.ECGenParameterSpec;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/StripeEphemeralKeyPairGenerator;", "Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "(Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;)V", "generate", "Ljava/security/KeyPair;", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeEphemeralKeyPairGenerator.kt */
public final class StripeEphemeralKeyPairGenerator implements EphemeralKeyPairGenerator {
    @Deprecated
    private static final String ALGORITHM = Algorithm.EC.toString();
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ErrorReporter errorReporter;

    public StripeEphemeralKeyPairGenerator(ErrorReporter errorReporter2) {
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        this.errorReporter = errorReporter2;
    }

    public KeyPair generate() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            StripeEphemeralKeyPairGenerator stripeEphemeralKeyPairGenerator = this;
            KeyPairGenerator instance = KeyPairGenerator.getInstance(ALGORITHM);
            instance.initialize(new ECGenParameterSpec(Curve.P_256.getStdName()));
            obj = Result.m4709constructorimpl(instance.generateKeyPair());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
        if (r1 != null) {
            this.errorReporter.reportError(r1);
        }
        Throwable r12 = Result.m4712exceptionOrNullimpl(obj);
        if (r12 == null) {
            Intrinsics.checkNotNullExpressionValue(obj, "runCatching {\n          …meException(it)\n        }");
            return (KeyPair) obj;
        }
        throw new SDKRuntimeException(r12);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/StripeEphemeralKeyPairGenerator$Companion;", "", "()V", "ALGORITHM", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeEphemeralKeyPairGenerator.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
