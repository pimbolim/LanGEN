package com.nimbusds.jose.jwk;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.Base64;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.IntegerOverflowException;
import com.nimbusds.jose.util.JSONArrayUtils;
import com.nimbusds.jose.util.JSONObjectUtils;
import java.io.Serializable;
import java.net.URI;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAOtherPrimeInfo;
import java.security.spec.RSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.jcip.annotations.Immutable;

@Immutable
public final class RSAKey extends JWK implements AsymmetricJWK {
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final Base64URL d;
    /* access modifiers changed from: private */
    public final Base64URL dp;
    /* access modifiers changed from: private */
    public final Base64URL dq;
    /* access modifiers changed from: private */
    public final Base64URL e;
    /* access modifiers changed from: private */
    public final Base64URL n;
    /* access modifiers changed from: private */
    public final List<OtherPrimesInfo> oth;
    /* access modifiers changed from: private */
    public final Base64URL p;
    /* access modifiers changed from: private */
    public final PrivateKey privateKey;
    /* access modifiers changed from: private */
    public final Base64URL q;
    /* access modifiers changed from: private */
    public final Base64URL qi;

    @Immutable
    public static class OtherPrimesInfo implements Serializable {
        private static final long serialVersionUID = 1;
        /* access modifiers changed from: private */
        public final Base64URL d;
        /* access modifiers changed from: private */
        public final Base64URL r;
        /* access modifiers changed from: private */
        public final Base64URL t;

        public OtherPrimesInfo(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3) {
            if (base64URL != null) {
                this.r = base64URL;
                if (base64URL2 != null) {
                    this.d = base64URL2;
                    if (base64URL3 != null) {
                        this.t = base64URL3;
                        return;
                    }
                    throw new IllegalArgumentException("The factor CRT coefficient must not be null");
                }
                throw new IllegalArgumentException("The factor CRT exponent must not be null");
            }
            throw new IllegalArgumentException("The prime factor must not be null");
        }

        public OtherPrimesInfo(RSAOtherPrimeInfo rSAOtherPrimeInfo) {
            this.r = Base64URL.encode(rSAOtherPrimeInfo.getPrime());
            this.d = Base64URL.encode(rSAOtherPrimeInfo.getExponent());
            this.t = Base64URL.encode(rSAOtherPrimeInfo.getCrtCoefficient());
        }

        public Base64URL getPrimeFactor() {
            return this.r;
        }

        public Base64URL getFactorCRTExponent() {
            return this.d;
        }

        public Base64URL getFactorCRTCoefficient() {
            return this.t;
        }

        public static List<OtherPrimesInfo> toList(RSAOtherPrimeInfo[] rSAOtherPrimeInfoArr) {
            ArrayList arrayList = new ArrayList();
            if (rSAOtherPrimeInfoArr == null) {
                return arrayList;
            }
            for (RSAOtherPrimeInfo otherPrimesInfo : rSAOtherPrimeInfoArr) {
                arrayList.add(new OtherPrimesInfo(otherPrimesInfo));
            }
            return arrayList;
        }
    }

    public static class Builder {
        private Algorithm alg;
        private Base64URL d;
        private Base64URL dp;
        private Base64URL dq;
        private final Base64URL e;
        private String kid;
        private KeyStore ks;
        private final Base64URL n;
        private Set<KeyOperation> ops;
        private List<OtherPrimesInfo> oth;
        private Base64URL p;
        private PrivateKey priv;
        private Base64URL q;
        private Base64URL qi;
        private KeyUse use;
        private List<Base64> x5c;
        @Deprecated
        private Base64URL x5t;
        private Base64URL x5t256;
        private URI x5u;

        public Builder(Base64URL base64URL, Base64URL base64URL2) {
            if (base64URL != null) {
                this.n = base64URL;
                if (base64URL2 != null) {
                    this.e = base64URL2;
                    return;
                }
                throw new IllegalArgumentException("The public exponent value must not be null");
            }
            throw new IllegalArgumentException("The modulus value must not be null");
        }

        public Builder(RSAPublicKey rSAPublicKey) {
            this.n = Base64URL.encode(rSAPublicKey.getModulus());
            this.e = Base64URL.encode(rSAPublicKey.getPublicExponent());
        }

        public Builder(RSAKey rSAKey) {
            this.n = rSAKey.n;
            this.e = rSAKey.e;
            this.d = rSAKey.d;
            this.p = rSAKey.p;
            this.q = rSAKey.q;
            this.dp = rSAKey.dp;
            this.dq = rSAKey.dq;
            this.qi = rSAKey.qi;
            this.oth = rSAKey.oth;
            this.priv = rSAKey.privateKey;
            this.use = rSAKey.getKeyUse();
            this.ops = rSAKey.getKeyOperations();
            this.alg = rSAKey.getAlgorithm();
            this.kid = rSAKey.getKeyID();
            this.x5u = rSAKey.getX509CertURL();
            this.x5t = rSAKey.getX509CertThumbprint();
            this.x5t256 = rSAKey.getX509CertSHA256Thumbprint();
            this.x5c = rSAKey.getX509CertChain();
            this.ks = rSAKey.getKeyStore();
        }

        public Builder privateExponent(Base64URL base64URL) {
            this.d = base64URL;
            return this;
        }

        public Builder privateKey(RSAPrivateKey rSAPrivateKey) {
            if (rSAPrivateKey instanceof RSAPrivateCrtKey) {
                return privateKey((RSAPrivateCrtKey) rSAPrivateKey);
            }
            if (rSAPrivateKey instanceof RSAMultiPrimePrivateCrtKey) {
                return privateKey((RSAMultiPrimePrivateCrtKey) rSAPrivateKey);
            }
            this.d = Base64URL.encode(rSAPrivateKey.getPrivateExponent());
            return this;
        }

        public Builder privateKey(PrivateKey privateKey) {
            if (privateKey instanceof RSAPrivateKey) {
                return privateKey((RSAPrivateKey) privateKey);
            }
            if ("RSA".equalsIgnoreCase(privateKey.getAlgorithm())) {
                this.priv = privateKey;
                return this;
            }
            throw new IllegalArgumentException("The private key algorithm must be RSA");
        }

        public Builder firstPrimeFactor(Base64URL base64URL) {
            this.p = base64URL;
            return this;
        }

        public Builder secondPrimeFactor(Base64URL base64URL) {
            this.q = base64URL;
            return this;
        }

        public Builder firstFactorCRTExponent(Base64URL base64URL) {
            this.dp = base64URL;
            return this;
        }

        public Builder secondFactorCRTExponent(Base64URL base64URL) {
            this.dq = base64URL;
            return this;
        }

        public Builder firstCRTCoefficient(Base64URL base64URL) {
            this.qi = base64URL;
            return this;
        }

        public Builder otherPrimes(List<OtherPrimesInfo> list) {
            this.oth = list;
            return this;
        }

        public Builder privateKey(RSAPrivateCrtKey rSAPrivateCrtKey) {
            this.d = Base64URL.encode(rSAPrivateCrtKey.getPrivateExponent());
            this.p = Base64URL.encode(rSAPrivateCrtKey.getPrimeP());
            this.q = Base64URL.encode(rSAPrivateCrtKey.getPrimeQ());
            this.dp = Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentP());
            this.dq = Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentQ());
            this.qi = Base64URL.encode(rSAPrivateCrtKey.getCrtCoefficient());
            return this;
        }

        public Builder privateKey(RSAMultiPrimePrivateCrtKey rSAMultiPrimePrivateCrtKey) {
            this.d = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrivateExponent());
            this.p = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeP());
            this.q = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeQ());
            this.dp = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentP());
            this.dq = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentQ());
            this.qi = Base64URL.encode(rSAMultiPrimePrivateCrtKey.getCrtCoefficient());
            this.oth = OtherPrimesInfo.toList(rSAMultiPrimePrivateCrtKey.getOtherPrimeInfo());
            return this;
        }

        public Builder keyUse(KeyUse keyUse) {
            this.use = keyUse;
            return this;
        }

        public Builder keyOperations(Set<KeyOperation> set) {
            this.ops = set;
            return this;
        }

        public Builder algorithm(Algorithm algorithm) {
            this.alg = algorithm;
            return this;
        }

        public Builder keyID(String str) {
            this.kid = str;
            return this;
        }

        public Builder keyIDFromThumbprint() throws JOSEException {
            return keyIDFromThumbprint("SHA-256");
        }

        public Builder keyIDFromThumbprint(String str) throws JOSEException {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(JWKParameterNames.RSA_EXPONENT, this.e.toString());
            linkedHashMap.put(JWKParameterNames.KEY_TYPE, KeyType.RSA.getValue());
            linkedHashMap.put(JWKParameterNames.RSA_MODULUS, this.n.toString());
            this.kid = ThumbprintUtils.compute(str, (LinkedHashMap<String, ?>) linkedHashMap).toString();
            return this;
        }

        public Builder x509CertURL(URI uri) {
            this.x5u = uri;
            return this;
        }

        @Deprecated
        public Builder x509CertThumbprint(Base64URL base64URL) {
            this.x5t = base64URL;
            return this;
        }

        public Builder x509CertSHA256Thumbprint(Base64URL base64URL) {
            this.x5t256 = base64URL;
            return this;
        }

        public Builder x509CertChain(List<Base64> list) {
            this.x5c = list;
            return this;
        }

        public Builder keyStore(KeyStore keyStore) {
            this.ks = keyStore;
            return this;
        }

        public RSAKey build() {
            try {
                Base64URL base64URL = this.n;
                Base64URL base64URL2 = this.e;
                Base64URL base64URL3 = this.d;
                Base64URL base64URL4 = this.p;
                Base64URL base64URL5 = this.q;
                Base64URL base64URL6 = this.dp;
                Base64URL base64URL7 = this.dq;
                Base64URL base64URL8 = this.qi;
                List<OtherPrimesInfo> list = this.oth;
                PrivateKey privateKey = this.priv;
                KeyUse keyUse = this.use;
                Set<KeyOperation> set = this.ops;
                Algorithm algorithm = this.alg;
                return new RSAKey(base64URL, base64URL2, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, base64URL8, list, privateKey, keyUse, set, algorithm, this.kid, this.x5u, this.x5t, this.x5t256, this.x5c, this.ks);
            } catch (IllegalArgumentException e2) {
                throw new IllegalStateException(e2.getMessage(), e2);
            }
        }
    }

    public RSAKey(Base64URL base64URL, Base64URL base64URL2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL3, Base64URL base64URL4, List<Base64> list, KeyStore keyStore) {
        this(base64URL, base64URL2, (Base64URL) null, (Base64URL) null, (Base64URL) null, (Base64URL) null, (Base64URL) null, (Base64URL) null, (List<OtherPrimesInfo>) null, (PrivateKey) null, keyUse, set, algorithm, str, uri, base64URL3, base64URL4, list, keyStore);
    }

    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL4, Base64URL base64URL5, List<Base64> list, KeyStore keyStore) {
        this(base64URL, base64URL2, base64URL3, (Base64URL) null, (Base64URL) null, (Base64URL) null, (Base64URL) null, (Base64URL) null, (List<OtherPrimesInfo>) null, (PrivateKey) null, keyUse, set, algorithm, str, uri, base64URL4, base64URL5, list, keyStore);
        if (base64URL3 == null) {
            throw new IllegalArgumentException("The private exponent must not be null");
        }
    }

    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, List<OtherPrimesInfo> list, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL8, Base64URL base64URL9, List<Base64> list2, KeyStore keyStore) {
        this(base64URL, base64URL2, (Base64URL) null, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, list, (PrivateKey) null, keyUse, set, algorithm, str, uri, base64URL8, base64URL9, list2, keyStore);
        if (base64URL3 == null) {
            throw new IllegalArgumentException("The first prime factor must not be null");
        } else if (base64URL4 == null) {
            throw new IllegalArgumentException("The second prime factor must not be null");
        } else if (base64URL5 == null) {
            throw new IllegalArgumentException("The first factor CRT exponent must not be null");
        } else if (base64URL6 == null) {
            throw new IllegalArgumentException("The second factor CRT exponent must not be null");
        } else if (base64URL7 == null) {
            throw new IllegalArgumentException("The first CRT coefficient must not be null");
        }
    }

    @Deprecated
    public RSAKey(Base64URL base64URL, Base64URL base64URL2, Base64URL base64URL3, Base64URL base64URL4, Base64URL base64URL5, Base64URL base64URL6, Base64URL base64URL7, Base64URL base64URL8, List<OtherPrimesInfo> list, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL9, Base64URL base64URL10, List<Base64> list2) {
        this(base64URL, base64URL2, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, base64URL8, list, (PrivateKey) null, keyUse, set, algorithm, str, uri, base64URL9, base64URL10, list2, (KeyStore) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RSAKey(com.nimbusds.jose.util.Base64URL r17, com.nimbusds.jose.util.Base64URL r18, com.nimbusds.jose.util.Base64URL r19, com.nimbusds.jose.util.Base64URL r20, com.nimbusds.jose.util.Base64URL r21, com.nimbusds.jose.util.Base64URL r22, com.nimbusds.jose.util.Base64URL r23, com.nimbusds.jose.util.Base64URL r24, java.util.List<com.nimbusds.jose.jwk.RSAKey.OtherPrimesInfo> r25, java.security.PrivateKey r26, com.nimbusds.jose.jwk.KeyUse r27, java.util.Set<com.nimbusds.jose.jwk.KeyOperation> r28, com.nimbusds.jose.Algorithm r29, java.lang.String r30, java.net.URI r31, com.nimbusds.jose.util.Base64URL r32, com.nimbusds.jose.util.Base64URL r33, java.util.List<com.nimbusds.jose.util.Base64> r34, java.security.KeyStore r35) {
        /*
            r16 = this;
            r11 = r16
            r12 = r17
            r13 = r18
            r14 = r20
            r15 = r21
            r10 = r22
            r9 = r23
            r8 = r24
            com.nimbusds.jose.jwk.KeyType r1 = com.nimbusds.jose.jwk.KeyType.RSA
            r0 = r16
            r2 = r27
            r3 = r28
            r4 = r29
            r5 = r30
            r6 = r31
            r7 = r32
            r8 = r33
            r9 = r34
            r10 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r12 == 0) goto L_0x00fc
            r11.n = r12
            if (r13 == 0) goto L_0x00f4
            r11.e = r13
            java.util.List r0 = r16.getParsedX509CertChain()
            if (r0 == 0) goto L_0x0051
            java.util.List r0 = r16.getParsedX509CertChain()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            boolean r0 = r11.matches(r0)
            if (r0 == 0) goto L_0x0049
            goto L_0x0051
        L_0x0049:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The public subject key info of the first X.509 certificate in the chain must match the JWK type and public parameters"
            r0.<init>(r1)
            throw r0
        L_0x0051:
            r0 = r19
            r11.d = r0
            if (r14 == 0) goto L_0x0081
            if (r15 == 0) goto L_0x0081
            r0 = r22
            r1 = r23
            if (r0 == 0) goto L_0x0085
            r2 = r24
            if (r1 == 0) goto L_0x0087
            if (r2 == 0) goto L_0x0087
            r11.p = r14
            r11.q = r15
            r11.dp = r0
            r11.dq = r1
            r11.qi = r2
            if (r25 == 0) goto L_0x0078
            java.util.List r0 = java.util.Collections.unmodifiableList(r25)
            r11.oth = r0
            goto L_0x007e
        L_0x0078:
            java.util.List r0 = java.util.Collections.emptyList()
            r11.oth = r0
        L_0x007e:
            r0 = r26
            goto L_0x00c1
        L_0x0081:
            r0 = r22
            r1 = r23
        L_0x0085:
            r2 = r24
        L_0x0087:
            r3 = 0
            if (r14 != 0) goto L_0x00a5
            if (r15 != 0) goto L_0x00a5
            if (r0 != 0) goto L_0x00a5
            if (r1 != 0) goto L_0x00a5
            if (r2 != 0) goto L_0x00a5
            if (r25 != 0) goto L_0x00a5
            r11.p = r3
            r11.q = r3
            r11.dp = r3
            r11.dq = r3
            r11.qi = r3
            java.util.List r0 = java.util.Collections.emptyList()
            r11.oth = r0
            goto L_0x007e
        L_0x00a5:
            if (r14 != 0) goto L_0x00c4
            if (r15 != 0) goto L_0x00c4
            if (r0 != 0) goto L_0x00c4
            if (r1 != 0) goto L_0x00c4
            if (r2 == 0) goto L_0x00b0
            goto L_0x00c4
        L_0x00b0:
            r11.p = r3
            r11.q = r3
            r11.dp = r3
            r11.dq = r3
            r11.qi = r3
            java.util.List r0 = java.util.Collections.emptyList()
            r11.oth = r0
            goto L_0x007e
        L_0x00c1:
            r11.privateKey = r0
            return
        L_0x00c4:
            if (r14 == 0) goto L_0x00ec
            if (r15 == 0) goto L_0x00e4
            if (r0 == 0) goto L_0x00dc
            if (r1 != 0) goto L_0x00d4
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The second factor CRT exponent must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00d4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first CRT coefficient must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00dc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first factor CRT exponent must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00e4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The second prime factor must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00ec:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Incomplete second private (CRT) representation: The first prime factor must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00f4:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The public exponent value must not be null"
            r0.<init>(r1)
            throw r0
        L_0x00fc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The modulus value must not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.jwk.RSAKey.<init>(com.nimbusds.jose.util.Base64URL, com.nimbusds.jose.util.Base64URL, com.nimbusds.jose.util.Base64URL, com.nimbusds.jose.util.Base64URL, com.nimbusds.jose.util.Base64URL, com.nimbusds.jose.util.Base64URL, com.nimbusds.jose.util.Base64URL, com.nimbusds.jose.util.Base64URL, java.util.List, java.security.PrivateKey, com.nimbusds.jose.jwk.KeyUse, java.util.Set, com.nimbusds.jose.Algorithm, java.lang.String, java.net.URI, com.nimbusds.jose.util.Base64URL, com.nimbusds.jose.util.Base64URL, java.util.List, java.security.KeyStore):void");
    }

    public RSAKey(RSAPublicKey rSAPublicKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, RSAPrivateKey rSAPrivateKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), Base64URL.encode(rSAPrivateKey.getPrivateExponent()), keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, RSAPrivateCrtKey rSAPrivateCrtKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), Base64URL.encode(rSAPrivateCrtKey.getPrivateExponent()), Base64URL.encode(rSAPrivateCrtKey.getPrimeP()), Base64URL.encode(rSAPrivateCrtKey.getPrimeQ()), Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentP()), Base64URL.encode(rSAPrivateCrtKey.getPrimeExponentQ()), Base64URL.encode(rSAPrivateCrtKey.getCrtCoefficient()), (List<OtherPrimesInfo>) null, (PrivateKey) null, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, RSAMultiPrimePrivateCrtKey rSAMultiPrimePrivateCrtKey, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrivateExponent()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeP()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeQ()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentP()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getPrimeExponentQ()), Base64URL.encode(rSAMultiPrimePrivateCrtKey.getCrtCoefficient()), OtherPrimesInfo.toList(rSAMultiPrimePrivateCrtKey.getOtherPrimeInfo()), (PrivateKey) null, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, keyStore);
    }

    public RSAKey(RSAPublicKey rSAPublicKey, PrivateKey privateKey2, KeyUse keyUse, Set<KeyOperation> set, Algorithm algorithm, String str, URI uri, Base64URL base64URL, Base64URL base64URL2, List<Base64> list, KeyStore keyStore) {
        this(Base64URL.encode(rSAPublicKey.getModulus()), Base64URL.encode(rSAPublicKey.getPublicExponent()), (Base64URL) null, (Base64URL) null, (Base64URL) null, (Base64URL) null, (Base64URL) null, (Base64URL) null, (List<OtherPrimesInfo>) null, privateKey2, keyUse, set, algorithm, str, uri, base64URL, base64URL2, list, keyStore);
    }

    public Base64URL getModulus() {
        return this.n;
    }

    public Base64URL getPublicExponent() {
        return this.e;
    }

    public Base64URL getPrivateExponent() {
        return this.d;
    }

    public Base64URL getFirstPrimeFactor() {
        return this.p;
    }

    public Base64URL getSecondPrimeFactor() {
        return this.q;
    }

    public Base64URL getFirstFactorCRTExponent() {
        return this.dp;
    }

    public Base64URL getSecondFactorCRTExponent() {
        return this.dq;
    }

    public Base64URL getFirstCRTCoefficient() {
        return this.qi;
    }

    public List<OtherPrimesInfo> getOtherPrimes() {
        return this.oth;
    }

    public RSAPublicKey toRSAPublicKey() throws JOSEException {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(this.n.decodeToBigInteger(), this.e.decodeToBigInteger()));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [java.security.spec.KeySpec] */
    /* JADX WARNING: type inference failed for: r1v12, types: [java.security.spec.RSAPrivateCrtKeySpec] */
    /* JADX WARNING: type inference failed for: r1v13, types: [java.security.spec.RSAMultiPrimePrivateCrtKeySpec] */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.interfaces.RSAPrivateKey toRSAPrivateKey() throws com.nimbusds.jose.JOSEException {
        /*
            r14 = this;
            com.nimbusds.jose.util.Base64URL r0 = r14.d
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            com.nimbusds.jose.util.Base64URL r0 = r14.n
            java.math.BigInteger r2 = r0.decodeToBigInteger()
            com.nimbusds.jose.util.Base64URL r0 = r14.d
            java.math.BigInteger r4 = r0.decodeToBigInteger()
            com.nimbusds.jose.util.Base64URL r0 = r14.p
            if (r0 != 0) goto L_0x001d
            java.security.spec.RSAPrivateKeySpec r0 = new java.security.spec.RSAPrivateKeySpec
            r0.<init>(r2, r4)
            goto L_0x0093
        L_0x001d:
            com.nimbusds.jose.util.Base64URL r0 = r14.e
            java.math.BigInteger r3 = r0.decodeToBigInteger()
            com.nimbusds.jose.util.Base64URL r0 = r14.p
            java.math.BigInteger r5 = r0.decodeToBigInteger()
            com.nimbusds.jose.util.Base64URL r0 = r14.q
            java.math.BigInteger r6 = r0.decodeToBigInteger()
            com.nimbusds.jose.util.Base64URL r0 = r14.dp
            java.math.BigInteger r7 = r0.decodeToBigInteger()
            com.nimbusds.jose.util.Base64URL r0 = r14.dq
            java.math.BigInteger r8 = r0.decodeToBigInteger()
            com.nimbusds.jose.util.Base64URL r0 = r14.qi
            java.math.BigInteger r9 = r0.decodeToBigInteger()
            java.util.List<com.nimbusds.jose.jwk.RSAKey$OtherPrimesInfo> r0 = r14.oth
            if (r0 == 0) goto L_0x008d
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x008d
            java.util.List<com.nimbusds.jose.jwk.RSAKey$OtherPrimesInfo> r0 = r14.oth
            int r0 = r0.size()
            java.security.spec.RSAOtherPrimeInfo[] r10 = new java.security.spec.RSAOtherPrimeInfo[r0]
            r0 = 0
        L_0x0054:
            java.util.List<com.nimbusds.jose.jwk.RSAKey$OtherPrimesInfo> r1 = r14.oth
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x0086
            java.util.List<com.nimbusds.jose.jwk.RSAKey$OtherPrimesInfo> r1 = r14.oth
            java.lang.Object r1 = r1.get(r0)
            com.nimbusds.jose.jwk.RSAKey$OtherPrimesInfo r1 = (com.nimbusds.jose.jwk.RSAKey.OtherPrimesInfo) r1
            com.nimbusds.jose.util.Base64URL r11 = r1.getPrimeFactor()
            java.math.BigInteger r11 = r11.decodeToBigInteger()
            com.nimbusds.jose.util.Base64URL r12 = r1.getFactorCRTExponent()
            java.math.BigInteger r12 = r12.decodeToBigInteger()
            com.nimbusds.jose.util.Base64URL r1 = r1.getFactorCRTCoefficient()
            java.math.BigInteger r1 = r1.decodeToBigInteger()
            java.security.spec.RSAOtherPrimeInfo r13 = new java.security.spec.RSAOtherPrimeInfo
            r13.<init>(r11, r12, r1)
            r10[r0] = r13
            int r0 = r0 + 1
            goto L_0x0054
        L_0x0086:
            java.security.spec.RSAMultiPrimePrivateCrtKeySpec r0 = new java.security.spec.RSAMultiPrimePrivateCrtKeySpec
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0093
        L_0x008d:
            java.security.spec.RSAPrivateCrtKeySpec r0 = new java.security.spec.RSAPrivateCrtKeySpec
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0093:
            java.lang.String r1 = "RSA"
            java.security.KeyFactory r1 = java.security.KeyFactory.getInstance(r1)     // Catch:{ InvalidKeySpecException -> 0x00a2, NoSuchAlgorithmException -> 0x00a0 }
            java.security.PrivateKey r0 = r1.generatePrivate(r0)     // Catch:{ InvalidKeySpecException -> 0x00a2, NoSuchAlgorithmException -> 0x00a0 }
            java.security.interfaces.RSAPrivateKey r0 = (java.security.interfaces.RSAPrivateKey) r0     // Catch:{ InvalidKeySpecException -> 0x00a2, NoSuchAlgorithmException -> 0x00a0 }
            return r0
        L_0x00a0:
            r0 = move-exception
            goto L_0x00a3
        L_0x00a2:
            r0 = move-exception
        L_0x00a3:
            com.nimbusds.jose.JOSEException r1 = new com.nimbusds.jose.JOSEException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.jwk.RSAKey.toRSAPrivateKey():java.security.interfaces.RSAPrivateKey");
    }

    public PublicKey toPublicKey() throws JOSEException {
        return toRSAPublicKey();
    }

    public PrivateKey toPrivateKey() throws JOSEException {
        RSAPrivateKey rSAPrivateKey = toRSAPrivateKey();
        if (rSAPrivateKey != null) {
            return rSAPrivateKey;
        }
        return this.privateKey;
    }

    public KeyPair toKeyPair() throws JOSEException {
        return new KeyPair(toRSAPublicKey(), toPrivateKey());
    }

    public boolean matches(X509Certificate x509Certificate) {
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) getParsedX509CertChain().get(0).getPublicKey();
            if (!this.e.decodeToBigInteger().equals(rSAPublicKey.getPublicExponent())) {
                return false;
            }
            return this.n.decodeToBigInteger().equals(rSAPublicKey.getModulus());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public LinkedHashMap<String, ?> getRequiredParams() {
        LinkedHashMap<String, ?> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(JWKParameterNames.RSA_EXPONENT, this.e.toString());
        linkedHashMap.put(JWKParameterNames.KEY_TYPE, getKeyType().getValue());
        linkedHashMap.put(JWKParameterNames.RSA_MODULUS, this.n.toString());
        return linkedHashMap;
    }

    public boolean isPrivate() {
        return (this.d == null && this.p == null && this.privateKey == null) ? false : true;
    }

    public int size() {
        try {
            return ByteUtils.safeBitLength(this.n.decode());
        } catch (IntegerOverflowException e2) {
            throw new ArithmeticException(e2.getMessage());
        }
    }

    public RSAKey toPublicJWK() {
        return new RSAKey(getModulus(), getPublicExponent(), getKeyUse(), getKeyOperations(), getAlgorithm(), getKeyID(), getX509CertURL(), getX509CertThumbprint(), getX509CertSHA256Thumbprint(), getX509CertChain(), getKeyStore());
    }

    public Map<String, Object> toJSONObject() {
        Map<String, Object> jSONObject = super.toJSONObject();
        jSONObject.put(JWKParameterNames.RSA_MODULUS, this.n.toString());
        jSONObject.put(JWKParameterNames.RSA_EXPONENT, this.e.toString());
        Base64URL base64URL = this.d;
        if (base64URL != null) {
            jSONObject.put("d", base64URL.toString());
        }
        Base64URL base64URL2 = this.p;
        if (base64URL2 != null) {
            jSONObject.put(JWKParameterNames.RSA_FIRST_PRIME_FACTOR, base64URL2.toString());
        }
        Base64URL base64URL3 = this.q;
        if (base64URL3 != null) {
            jSONObject.put(JWKParameterNames.RSA_SECOND_PRIME_FACTOR, base64URL3.toString());
        }
        Base64URL base64URL4 = this.dp;
        if (base64URL4 != null) {
            jSONObject.put(JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, base64URL4.toString());
        }
        Base64URL base64URL5 = this.dq;
        if (base64URL5 != null) {
            jSONObject.put(JWKParameterNames.RSA_SECOND_FACTOR_CRT_EXPONENT, base64URL5.toString());
        }
        Base64URL base64URL6 = this.qi;
        if (base64URL6 != null) {
            jSONObject.put(JWKParameterNames.RSA_FIRST_CRT_COEFFICIENT, base64URL6.toString());
        }
        List<OtherPrimesInfo> list = this.oth;
        if (list != null && !list.isEmpty()) {
            List<Object> newJSONArray = JSONArrayUtils.newJSONArray();
            for (OtherPrimesInfo next : this.oth) {
                Map<String, Object> newJSONObject = JSONObjectUtils.newJSONObject();
                newJSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, next.r.toString());
                newJSONObject.put("d", next.d.toString());
                newJSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, next.t.toString());
                newJSONArray.add(newJSONObject);
            }
            jSONObject.put(JWKParameterNames.RSA_OTHER_PRIMES, newJSONArray);
        }
        return jSONObject;
    }

    public static RSAKey parse(String str) throws ParseException {
        return parse(JSONObjectUtils.parse(str));
    }

    public static RSAKey parse(Map<String, Object> map) throws ParseException {
        List<Object> jSONArray;
        Map<String, Object> map2 = map;
        if (KeyType.RSA.equals(JWKMetadata.parseKeyType(map))) {
            Base64URL base64URL = JSONObjectUtils.getBase64URL(map2, JWKParameterNames.RSA_MODULUS);
            Base64URL base64URL2 = JSONObjectUtils.getBase64URL(map2, JWKParameterNames.RSA_EXPONENT);
            Base64URL base64URL3 = JSONObjectUtils.getBase64URL(map2, "d");
            Base64URL base64URL4 = JSONObjectUtils.getBase64URL(map2, JWKParameterNames.RSA_FIRST_PRIME_FACTOR);
            Base64URL base64URL5 = JSONObjectUtils.getBase64URL(map2, JWKParameterNames.RSA_SECOND_PRIME_FACTOR);
            Base64URL base64URL6 = JSONObjectUtils.getBase64URL(map2, JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT);
            Base64URL base64URL7 = JSONObjectUtils.getBase64URL(map2, JWKParameterNames.RSA_SECOND_FACTOR_CRT_EXPONENT);
            Base64URL base64URL8 = JSONObjectUtils.getBase64URL(map2, JWKParameterNames.RSA_FIRST_CRT_COEFFICIENT);
            ArrayList arrayList = null;
            if (map2.containsKey(JWKParameterNames.RSA_OTHER_PRIMES) && (jSONArray = JSONObjectUtils.getJSONArray(map2, JWKParameterNames.RSA_OTHER_PRIMES)) != null) {
                arrayList = new ArrayList(jSONArray.size());
                for (Object next : jSONArray) {
                    if (next instanceof Map) {
                        Map map3 = (Map) next;
                        try {
                            arrayList.add(new OtherPrimesInfo(JSONObjectUtils.getBase64URL(map3, JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR), JSONObjectUtils.getBase64URL(map3, JWKParameterNames.RSA_SECOND_FACTOR_CRT_EXPONENT), JSONObjectUtils.getBase64URL(map3, JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT)));
                        } catch (IllegalArgumentException e2) {
                            throw new ParseException(e2.getMessage(), 0);
                        }
                    }
                }
            }
            try {
                return new RSAKey(base64URL, base64URL2, base64URL3, base64URL4, base64URL5, base64URL6, base64URL7, base64URL8, arrayList, (PrivateKey) null, JWKMetadata.parseKeyUse(map), JWKMetadata.parseKeyOperations(map), JWKMetadata.parseAlgorithm(map), JWKMetadata.parseKeyID(map), JWKMetadata.parseX509CertURL(map), JWKMetadata.parseX509CertThumbprint(map), JWKMetadata.parseX509CertSHA256Thumbprint(map), JWKMetadata.parseX509CertChain(map), (KeyStore) null);
            } catch (IllegalArgumentException e3) {
                throw new ParseException(e3.getMessage(), 0);
            }
        } else {
            throw new ParseException("The key type \"kty\" must be RSA", 0);
        }
    }

    public static RSAKey parse(X509Certificate x509Certificate) throws JOSEException {
        if (x509Certificate.getPublicKey() instanceof RSAPublicKey) {
            try {
                return new Builder((RSAPublicKey) x509Certificate.getPublicKey()).keyUse(KeyUse.from(x509Certificate)).keyID(x509Certificate.getSerialNumber().toString(10)).x509CertChain(Collections.singletonList(Base64.encode(x509Certificate.getEncoded()))).x509CertSHA256Thumbprint(Base64URL.encode(MessageDigest.getInstance("SHA-256").digest(x509Certificate.getEncoded()))).build();
            } catch (NoSuchAlgorithmException e2) {
                throw new JOSEException("Couldn't encode x5t parameter: " + e2.getMessage(), e2);
            } catch (CertificateEncodingException e3) {
                throw new JOSEException("Couldn't encode x5c parameter: " + e3.getMessage(), e3);
            }
        } else {
            throw new JOSEException("The public key of the X.509 certificate is not RSA");
        }
    }

    public static RSAKey load(KeyStore keyStore, String str, char[] cArr) throws KeyStoreException, JOSEException {
        Certificate certificate = keyStore.getCertificate(str);
        if (!(certificate instanceof X509Certificate)) {
            return null;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (x509Certificate.getPublicKey() instanceof RSAPublicKey) {
            RSAKey build = new Builder(parse(x509Certificate)).keyID(str).keyStore(keyStore).build();
            try {
                Key key = keyStore.getKey(str, cArr);
                if (key instanceof RSAPrivateKey) {
                    return new Builder(build).privateKey((RSAPrivateKey) key).build();
                }
                if (!(key instanceof PrivateKey) || !"RSA".equalsIgnoreCase(key.getAlgorithm())) {
                    return build;
                }
                return new Builder(build).privateKey((PrivateKey) key).build();
            } catch (NoSuchAlgorithmException | UnrecoverableKeyException e2) {
                throw new JOSEException("Couldn't retrieve private RSA key (bad pin?): " + e2.getMessage(), e2);
            }
        } else {
            throw new JOSEException("Couldn't load RSA JWK: The key algorithm is not RSA");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RSAKey) || !super.equals(obj)) {
            return false;
        }
        RSAKey rSAKey = (RSAKey) obj;
        if (!Objects.equals(this.n, rSAKey.n) || !Objects.equals(this.e, rSAKey.e) || !Objects.equals(this.d, rSAKey.d) || !Objects.equals(this.p, rSAKey.p) || !Objects.equals(this.q, rSAKey.q) || !Objects.equals(this.dp, rSAKey.dp) || !Objects.equals(this.dq, rSAKey.dq) || !Objects.equals(this.qi, rSAKey.qi) || !Objects.equals(this.oth, rSAKey.oth) || !Objects.equals(this.privateKey, rSAKey.privateKey)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(super.hashCode()), this.n, this.e, this.d, this.p, this.q, this.dp, this.dq, this.qi, this.oth, this.privateKey});
    }
}
