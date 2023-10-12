package com.stripe.android.stripe3ds2.security;

import android.content.Context;
import android.util.Base64;
import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/PublicKeyFactory;", "", "context", "Landroid/content/Context;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "(Landroid/content/Context;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;)V", "create", "Ljava/security/PublicKey;", "directoryServerId", "", "generateCertificate", "Ljava/security/cert/Certificate;", "fileName", "generatePublicKey", "algorithm", "Lcom/stripe/android/stripe3ds2/security/Algorithm;", "readFile", "Ljava/io/InputStream;", "readPublicKeyBytes", "", "keyFile", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublicKeyFactory.kt */
public final class PublicKeyFactory {
    private final Context context;
    private final ErrorReporter errorReporter;

    public PublicKeyFactory(Context context2, ErrorReporter errorReporter2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        this.errorReporter = errorReporter2;
        Context applicationContext = context2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.context = applicationContext;
    }

    public final PublicKey create(String str) {
        Intrinsics.checkNotNullParameter(str, "directoryServerId");
        DirectoryServer lookup = DirectoryServer.Companion.lookup(str);
        if (!lookup.isCertificate()) {
            return generatePublicKey(lookup.getFileName(), lookup.getAlgorithm());
        }
        PublicKey publicKey = generateCertificate(lookup.getFileName()).getPublicKey();
        Intrinsics.checkNotNullExpressionValue(publicKey, "{\n            generateCe…Name).publicKey\n        }");
        return publicKey;
    }

    private final Certificate generateCertificate(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m4709constructorimpl(CertificateFactory.getInstance("X.509").generateCertificate(readFile(str)));
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
            Intrinsics.checkNotNullExpressionValue(obj, "runCatching {\n          …meException(it)\n        }");
            return (Certificate) obj;
        }
        throw new SDKRuntimeException(r02);
    }

    private final PublicKey generatePublicKey(String str, Algorithm algorithm) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m4709constructorimpl(KeyFactory.getInstance(algorithm.toString()).generatePublic(new X509EncodedKeySpec(readPublicKeyBytes(str))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r4 = Result.m4712exceptionOrNullimpl(obj);
        if (r4 != null) {
            this.errorReporter.reportError(r4);
        }
        Throwable r42 = Result.m4712exceptionOrNullimpl(obj);
        if (r42 == null) {
            Intrinsics.checkNotNullExpressionValue(obj, "runCatching {\n          …meException(it)\n        }");
            return (PublicKey) obj;
        }
        throw new SDKRuntimeException(r42);
    }

    private final byte[] readPublicKeyBytes(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            String next = new Scanner(readFile(str)).useDelimiter("\\A").next();
            Intrinsics.checkNotNullExpressionValue(next, "publicKey");
            byte[] bytes = next.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            obj = Result.m4709constructorimpl(Base64.decode(bytes, 0));
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
            Intrinsics.checkNotNullExpressionValue(obj, "runCatching {\n          …meException(it)\n        }");
            return (byte[]) obj;
        }
        throw new SDKRuntimeException(r02);
    }

    private final InputStream readFile(String str) throws IOException {
        InputStream open = this.context.getAssets().open(str);
        Intrinsics.checkNotNullExpressionValue(open, "context.assets.open(fileName)");
        return open;
    }
}
