package com.stripe.android.stripe3ds2.security;

import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/EcKeyFactory;", "", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "(Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;)V", "keyFactory", "Ljava/security/KeyFactory;", "createPrivate", "Ljava/security/interfaces/ECPrivateKey;", "privateKeyEncoded", "", "createPublic", "Ljava/security/interfaces/ECPublicKey;", "publicKeyEncoded", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EcKeyFactory.kt */
public final class EcKeyFactory {
    private final ErrorReporter errorReporter;
    private final KeyFactory keyFactory;

    public EcKeyFactory(ErrorReporter errorReporter2) {
        Object obj;
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        this.errorReporter = errorReporter2;
        try {
            Result.Companion companion = Result.Companion;
            EcKeyFactory ecKeyFactory = this;
            obj = Result.m4709constructorimpl(KeyFactory.getInstance("EC"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r0 = Result.m4712exceptionOrNullimpl(obj);
        if (r0 != null) {
            this.errorReporter.reportError(r0);
        }
        Throwable r02 = Result.m4712exceptionOrNullimpl(obj);
        if (r02 == null) {
            Intrinsics.checkNotNullExpressionValue(obj, "runCatching {\n          …xception(error)\n        }");
            this.keyFactory = (KeyFactory) obj;
            return;
        }
        throw new SDKRuntimeException(r02);
    }

    public final ECPublicKey createPublic(byte[] bArr) {
        Object obj;
        Intrinsics.checkNotNullParameter(bArr, "publicKeyEncoded");
        try {
            Result.Companion companion = Result.Companion;
            PublicKey generatePublic = this.keyFactory.generatePublic(new X509EncodedKeySpec(bArr));
            if (generatePublic != null) {
                obj = Result.m4709constructorimpl((ECPublicKey) generatePublic);
                Throwable r0 = Result.m4712exceptionOrNullimpl(obj);
                if (r0 != null) {
                    this.errorReporter.reportError(r0);
                }
                Throwable r02 = Result.m4712exceptionOrNullimpl(obj);
                if (r02 == null) {
                    return (ECPublicKey) obj;
                }
                throw new SDKRuntimeException(r02);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final ECPrivateKey createPrivate(byte[] bArr) {
        Object obj;
        Intrinsics.checkNotNullParameter(bArr, "privateKeyEncoded");
        try {
            Result.Companion companion = Result.Companion;
            PrivateKey generatePrivate = this.keyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArr));
            if (generatePrivate != null) {
                obj = Result.m4709constructorimpl((ECPrivateKey) generatePrivate);
                Throwable r0 = Result.m4712exceptionOrNullimpl(obj);
                if (r0 == null) {
                    return (ECPrivateKey) obj;
                }
                throw new SDKRuntimeException(r0);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.interfaces.ECPrivateKey");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
    }
}
