package com.stripe.android.stripe3ds2.transaction;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.bc.BouncyCastleProviderSingleton;
import com.nimbusds.jose.crypto.factories.DefaultJWSVerifierFactory;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.X509CertChainUtils;
import com.nimbusds.jose.util.X509CertUtils;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J&\u0010\u0014\u001a\u00020\u00032\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007J\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/DefaultJwsValidator;", "Lcom/stripe/android/stripe3ds2/transaction/JwsValidator;", "isLiveMode", "", "rootCerts", "", "Ljava/security/cert/X509Certificate;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "(ZLjava/util/List;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;)V", "getPayload", "Lorg/json/JSONObject;", "jws", "", "getPublicKeyFromHeader", "Ljava/security/PublicKey;", "jwsHeader", "Lcom/nimbusds/jose/JWSHeader;", "getVerifier", "Lcom/nimbusds/jose/JWSVerifier;", "isCertificateChainValid", "encodedChainCerts", "Lcom/nimbusds/jose/util/Base64;", "isValid", "jwsObject", "Lcom/nimbusds/jose/JWSObject;", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JwsValidator.kt */
public final class DefaultJwsValidator implements JwsValidator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ErrorReporter errorReporter;
    private final boolean isLiveMode;
    private final List<X509Certificate> rootCerts;

    public DefaultJwsValidator(boolean z, List<? extends X509Certificate> list, ErrorReporter errorReporter2) {
        Intrinsics.checkNotNullParameter(list, "rootCerts");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        this.isLiveMode = z;
        this.rootCerts = list;
        this.errorReporter = errorReporter2;
    }

    public JSONObject getPayload(String str) throws JSONException, ParseException, JOSEException, CertificateException {
        Intrinsics.checkNotNullParameter(str, "jws");
        JWSObject parse = JWSObject.parse(str);
        if (this.isLiveMode) {
            Intrinsics.checkNotNullExpressionValue(parse, "jwsObject");
            if (!isValid(parse, this.rootCerts)) {
                throw new IllegalStateException("Could not validate JWS");
            }
        }
        return new JSONObject(parse.getPayload().toString());
    }

    private final boolean isValid(JWSObject jWSObject, List<? extends X509Certificate> list) throws JOSEException, CertificateException {
        if (jWSObject.getHeader().getJWK() != null) {
            this.errorReporter.reportError(new IllegalArgumentException(Intrinsics.stringPlus("Encountered a JWK in ", jWSObject.getHeader())));
        }
        Companion companion = Companion;
        JWSHeader header = jWSObject.getHeader();
        Intrinsics.checkNotNullExpressionValue(header, "jwsObject.header");
        JWSHeader sanitizedJwsHeader$3ds2sdk_release = companion.sanitizedJwsHeader$3ds2sdk_release(header);
        if (!isCertificateChainValid(sanitizedJwsHeader$3ds2sdk_release.getX509CertChain(), list)) {
            return false;
        }
        return jWSObject.verify(getVerifier(sanitizedJwsHeader$3ds2sdk_release));
    }

    private final JWSVerifier getVerifier(JWSHeader jWSHeader) throws JOSEException, CertificateException {
        DefaultJWSVerifierFactory defaultJWSVerifierFactory = new DefaultJWSVerifierFactory();
        defaultJWSVerifierFactory.getJCAContext().setProvider(BouncyCastleProviderSingleton.getInstance());
        JWSVerifier createJWSVerifier = defaultJWSVerifierFactory.createJWSVerifier(jWSHeader, getPublicKeyFromHeader(jWSHeader));
        Intrinsics.checkNotNullExpressionValue(createJWSVerifier, "verifierFactory.createJW…KeyFromHeader(jwsHeader))");
        return createJWSVerifier;
    }

    private final PublicKey getPublicKeyFromHeader(JWSHeader jWSHeader) throws CertificateException {
        List x509CertChain = jWSHeader.getX509CertChain();
        Intrinsics.checkNotNullExpressionValue(x509CertChain, "jwsHeader.x509CertChain");
        PublicKey publicKey = X509CertUtils.parseWithException(((Base64) CollectionsKt.first(x509CertChain)).decode()).getPublicKey();
        Intrinsics.checkNotNullExpressionValue(publicKey, "parseWithException(\n    …ode()\n        ).publicKey");
        return publicKey;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001d A[Catch:{ all -> 0x004b }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f A[Catch:{ all -> 0x004b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isCertificateChainValid(java.util.List<? extends com.nimbusds.jose.util.Base64> r3, java.util.List<? extends java.security.cert.X509Certificate> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "rootCerts"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x004b }
            r0 = r2
            com.stripe.android.stripe3ds2.transaction.DefaultJwsValidator r0 = (com.stripe.android.stripe3ds2.transaction.DefaultJwsValidator) r0     // Catch:{ all -> 0x004b }
            r0 = r3
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x004b }
            r1 = 1
            if (r0 == 0) goto L_0x0019
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x003f
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x004b }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x004b }
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0033
            com.stripe.android.stripe3ds2.transaction.DefaultJwsValidator$Companion r0 = Companion     // Catch:{ all -> 0x004b }
            r0.validateChain(r3, r4)     // Catch:{ all -> 0x004b }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004b }
            java.lang.Object r3 = kotlin.Result.m4709constructorimpl(r3)     // Catch:{ all -> 0x004b }
            goto L_0x0056
        L_0x0033:
            java.lang.String r3 = "Root certificates are empty"
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x004b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004b }
            r4.<init>(r3)     // Catch:{ all -> 0x004b }
            throw r4     // Catch:{ all -> 0x004b }
        L_0x003f:
            java.lang.String r3 = "JWSHeader's X.509 certificate chain is null or empty"
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x004b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004b }
            r4.<init>(r3)     // Catch:{ all -> 0x004b }
            throw r4     // Catch:{ all -> 0x004b }
        L_0x004b:
            r3 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            java.lang.Object r3 = kotlin.Result.m4709constructorimpl(r3)
        L_0x0056:
            java.lang.Throwable r4 = kotlin.Result.m4712exceptionOrNullimpl(r3)
            if (r4 != 0) goto L_0x005d
            goto L_0x0062
        L_0x005d:
            com.stripe.android.stripe3ds2.observability.ErrorReporter r0 = r2.errorReporter
            r0.reportError(r4)
        L_0x0062:
            boolean r3 = kotlin.Result.m4716isSuccessimpl(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transaction.DefaultJwsValidator.isCertificateChainValid(java.util.List, java.util.List):boolean");
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000bJ$\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/DefaultJwsValidator$Companion;", "", "()V", "createKeyStore", "Ljava/security/KeyStore;", "rootCerts", "", "Ljava/security/cert/X509Certificate;", "sanitizedJwsHeader", "Lcom/nimbusds/jose/JWSHeader;", "jwsHeader", "sanitizedJwsHeader$3ds2sdk_release", "validateChain", "", "encodedChainCerts", "Lcom/nimbusds/jose/util/Base64;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: JwsValidator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void validateChain(List<? extends Base64> list, List<? extends X509Certificate> list2) throws GeneralSecurityException, IOException, ParseException {
            List<X509Certificate> parse = X509CertChainUtils.parse((List<Base64>) list);
            KeyStore createKeyStore = createKeyStore(list2);
            X509CertSelector x509CertSelector = new X509CertSelector();
            x509CertSelector.setCertificate(parse.get(0));
            PKIXBuilderParameters pKIXBuilderParameters = new PKIXBuilderParameters(createKeyStore, x509CertSelector);
            pKIXBuilderParameters.setRevocationEnabled(false);
            pKIXBuilderParameters.addCertStore(CertStore.getInstance("Collection", new CollectionCertStoreParameters(parse)));
            CertPathBuilder.getInstance("PKIX").build(pKIXBuilderParameters);
        }

        public final KeyStore createKeyStore(List<? extends X509Certificate> list) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
            Intrinsics.checkNotNullParameter(list, "rootCerts");
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load((InputStream) null, (char[]) null);
            int i = 0;
            for (Object next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                X509Certificate x509Certificate = (X509Certificate) next;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ROOT, "ca_%d", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
                instance.setCertificateEntry(format, (Certificate) list.get(i));
                i = i2;
            }
            Intrinsics.checkNotNullExpressionValue(instance, "keyStore");
            return instance;
        }

        public final JWSHeader sanitizedJwsHeader$3ds2sdk_release(JWSHeader jWSHeader) {
            Intrinsics.checkNotNullParameter(jWSHeader, "jwsHeader");
            JWSHeader build = new JWSHeader.Builder(jWSHeader).jwk((JWK) null).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder(jwsHeader)\n     …\n                .build()");
            return build;
        }
    }
}
