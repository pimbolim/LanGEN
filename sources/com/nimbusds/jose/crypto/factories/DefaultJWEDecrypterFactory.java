package com.nimbusds.jose.crypto.factories;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.crypto.AESDecrypter;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.ECDHDecrypter;
import com.nimbusds.jose.crypto.PasswordBasedDecrypter;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.jca.JWEJCAContext;
import com.nimbusds.jose.proc.JWEDecrypterFactory;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class DefaultJWEDecrypterFactory implements JWEDecrypterFactory {
    public static final Set<JWEAlgorithm> SUPPORTED_ALGORITHMS;
    public static final Set<EncryptionMethod> SUPPORTED_ENCRYPTION_METHODS;
    private final JWEJCAContext jcaContext = new JWEJCAContext();

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(RSADecrypter.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(ECDHDecrypter.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(DirectDecrypter.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(AESDecrypter.SUPPORTED_ALGORITHMS);
        linkedHashSet.addAll(PasswordBasedDecrypter.SUPPORTED_ALGORITHMS);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        linkedHashSet2.addAll(RSADecrypter.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(ECDHDecrypter.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(DirectDecrypter.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(AESDecrypter.SUPPORTED_ENCRYPTION_METHODS);
        linkedHashSet2.addAll(PasswordBasedDecrypter.SUPPORTED_ENCRYPTION_METHODS);
        SUPPORTED_ENCRYPTION_METHODS = Collections.unmodifiableSet(linkedHashSet2);
    }

    public Set<JWEAlgorithm> supportedJWEAlgorithms() {
        return SUPPORTED_ALGORITHMS;
    }

    public Set<EncryptionMethod> supportedEncryptionMethods() {
        return SUPPORTED_ENCRYPTION_METHODS;
    }

    public JWEJCAContext getJCAContext() {
        return this.jcaContext;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: com.nimbusds.jose.crypto.AESDecrypter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: com.nimbusds.jose.crypto.AESDecrypter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: com.nimbusds.jose.crypto.AESDecrypter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: com.nimbusds.jose.crypto.ECDHDecrypter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.nimbusds.jose.JWEDecrypter createJWEDecrypter(com.nimbusds.jose.JWEHeader r5, java.security.Key r6) throws com.nimbusds.jose.JOSEException {
        /*
            r4 = this;
            java.util.Set r0 = com.nimbusds.jose.crypto.RSADecrypter.SUPPORTED_ALGORITHMS
            com.nimbusds.jose.JWEAlgorithm r1 = r5.getAlgorithm()
            boolean r0 = r0.contains(r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0039
            java.util.Set r0 = com.nimbusds.jose.crypto.RSADecrypter.SUPPORTED_ENCRYPTION_METHODS
            com.nimbusds.jose.EncryptionMethod r3 = r5.getEncryptionMethod()
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x0039
            boolean r5 = r6 instanceof java.security.PrivateKey
            if (r5 == 0) goto L_0x002b
            boolean r5 = r6 instanceof java.security.interfaces.RSAKey
            if (r5 == 0) goto L_0x002b
            java.security.PrivateKey r6 = (java.security.PrivateKey) r6
            com.nimbusds.jose.crypto.RSADecrypter r5 = new com.nimbusds.jose.crypto.RSADecrypter
            r5.<init>((java.security.PrivateKey) r6)
            goto L_0x0133
        L_0x002b:
            com.nimbusds.jose.KeyTypeException r5 = new com.nimbusds.jose.KeyTypeException
            java.lang.Class<java.security.PrivateKey> r6 = java.security.PrivateKey.class
            java.lang.Class[] r0 = new java.lang.Class[r2]
            java.lang.Class<java.security.interfaces.RSAKey> r2 = java.security.interfaces.RSAKey.class
            r0[r1] = r2
            r5.<init>(r6, r0)
            throw r5
        L_0x0039:
            java.util.Set r0 = com.nimbusds.jose.crypto.ECDHDecrypter.SUPPORTED_ALGORITHMS
            com.nimbusds.jose.JWEAlgorithm r3 = r5.getAlgorithm()
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x007d
            java.util.Set r0 = com.nimbusds.jose.crypto.ECDHDecrypter.SUPPORTED_ENCRYPTION_METHODS
            com.nimbusds.jose.EncryptionMethod r3 = r5.getEncryptionMethod()
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x007d
            boolean r5 = r6 instanceof java.security.PrivateKey
            if (r5 == 0) goto L_0x006f
            boolean r5 = r6 instanceof java.security.interfaces.ECKey
            if (r5 == 0) goto L_0x006f
            r5 = r6
            java.security.PrivateKey r5 = (java.security.PrivateKey) r5
            java.security.interfaces.ECKey r6 = (java.security.interfaces.ECKey) r6
            java.security.spec.ECParameterSpec r6 = r6.getParams()
            com.nimbusds.jose.jwk.Curve r6 = com.nimbusds.jose.jwk.Curve.forECParameterSpec(r6)
            com.nimbusds.jose.crypto.ECDHDecrypter r0 = new com.nimbusds.jose.crypto.ECDHDecrypter
            r1 = 0
            r0.<init>(r5, r1, r6)
        L_0x006c:
            r5 = r0
            goto L_0x0133
        L_0x006f:
            com.nimbusds.jose.KeyTypeException r5 = new com.nimbusds.jose.KeyTypeException
            java.lang.Class<java.security.PrivateKey> r6 = java.security.PrivateKey.class
            java.lang.Class[] r0 = new java.lang.Class[r2]
            java.lang.Class<java.security.interfaces.ECKey> r2 = java.security.interfaces.ECKey.class
            r0[r1] = r2
            r5.<init>(r6, r0)
            throw r5
        L_0x007d:
            java.util.Set r0 = com.nimbusds.jose.crypto.DirectDecrypter.SUPPORTED_ALGORITHMS
            com.nimbusds.jose.JWEAlgorithm r1 = r5.getAlgorithm()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x00c9
            java.util.Set r0 = com.nimbusds.jose.crypto.DirectDecrypter.SUPPORTED_ENCRYPTION_METHODS
            com.nimbusds.jose.EncryptionMethod r1 = r5.getEncryptionMethod()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x00c9
            boolean r0 = r6 instanceof javax.crypto.SecretKey
            if (r0 == 0) goto L_0x00c1
            javax.crypto.SecretKey r6 = (javax.crypto.SecretKey) r6
            com.nimbusds.jose.crypto.DirectDecrypter r0 = new com.nimbusds.jose.crypto.DirectDecrypter
            r0.<init>((javax.crypto.SecretKey) r6)
            java.util.Set r6 = r0.supportedEncryptionMethods()
            com.nimbusds.jose.EncryptionMethod r1 = r5.getEncryptionMethod()
            boolean r6 = r6.contains(r1)
            if (r6 == 0) goto L_0x00af
        L_0x00ae:
            goto L_0x006c
        L_0x00af:
            com.nimbusds.jose.KeyLengthException r6 = new com.nimbusds.jose.KeyLengthException
            com.nimbusds.jose.EncryptionMethod r0 = r5.getEncryptionMethod()
            int r0 = r0.cekBitLength()
            com.nimbusds.jose.EncryptionMethod r5 = r5.getEncryptionMethod()
            r6.<init>(r0, r5)
            throw r6
        L_0x00c1:
            com.nimbusds.jose.KeyTypeException r5 = new com.nimbusds.jose.KeyTypeException
            java.lang.Class<javax.crypto.SecretKey> r6 = javax.crypto.SecretKey.class
            r5.<init>(r6)
            throw r5
        L_0x00c9:
            java.util.Set r0 = com.nimbusds.jose.crypto.AESDecrypter.SUPPORTED_ALGORITHMS
            com.nimbusds.jose.JWEAlgorithm r1 = r5.getAlgorithm()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x010d
            java.util.Set r0 = com.nimbusds.jose.crypto.AESDecrypter.SUPPORTED_ENCRYPTION_METHODS
            com.nimbusds.jose.EncryptionMethod r1 = r5.getEncryptionMethod()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x010d
            boolean r0 = r6 instanceof javax.crypto.SecretKey
            if (r0 == 0) goto L_0x0105
            javax.crypto.SecretKey r6 = (javax.crypto.SecretKey) r6
            com.nimbusds.jose.crypto.AESDecrypter r0 = new com.nimbusds.jose.crypto.AESDecrypter
            r0.<init>((javax.crypto.SecretKey) r6)
            java.util.Set r6 = r0.supportedJWEAlgorithms()
            com.nimbusds.jose.JWEAlgorithm r1 = r5.getAlgorithm()
            boolean r6 = r6.contains(r1)
            if (r6 == 0) goto L_0x00fb
            goto L_0x00ae
        L_0x00fb:
            com.nimbusds.jose.KeyLengthException r6 = new com.nimbusds.jose.KeyLengthException
            com.nimbusds.jose.JWEAlgorithm r5 = r5.getAlgorithm()
            r6.<init>((com.nimbusds.jose.Algorithm) r5)
            throw r6
        L_0x0105:
            com.nimbusds.jose.KeyTypeException r5 = new com.nimbusds.jose.KeyTypeException
            java.lang.Class<javax.crypto.SecretKey> r6 = javax.crypto.SecretKey.class
            r5.<init>(r6)
            throw r5
        L_0x010d:
            java.util.Set r0 = com.nimbusds.jose.crypto.PasswordBasedDecrypter.SUPPORTED_ALGORITHMS
            com.nimbusds.jose.JWEAlgorithm r1 = r5.getAlgorithm()
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0187
            java.util.Set r0 = com.nimbusds.jose.crypto.PasswordBasedDecrypter.SUPPORTED_ENCRYPTION_METHODS
            com.nimbusds.jose.EncryptionMethod r5 = r5.getEncryptionMethod()
            boolean r5 = r0.contains(r5)
            if (r5 == 0) goto L_0x0187
            boolean r5 = r6 instanceof javax.crypto.SecretKey
            if (r5 == 0) goto L_0x017f
            byte[] r5 = r6.getEncoded()
            com.nimbusds.jose.crypto.PasswordBasedDecrypter r6 = new com.nimbusds.jose.crypto.PasswordBasedDecrypter
            r6.<init>((byte[]) r5)
            r5 = r6
        L_0x0133:
            com.nimbusds.jose.jca.JCAContext r6 = r5.getJCAContext()
            com.nimbusds.jose.jca.JWEJCAContext r6 = (com.nimbusds.jose.jca.JWEJCAContext) r6
            com.nimbusds.jose.jca.JWEJCAContext r0 = r4.jcaContext
            java.security.SecureRandom r0 = r0.getSecureRandom()
            r6.setSecureRandom(r0)
            com.nimbusds.jose.jca.JCAContext r6 = r5.getJCAContext()
            com.nimbusds.jose.jca.JWEJCAContext r6 = (com.nimbusds.jose.jca.JWEJCAContext) r6
            com.nimbusds.jose.jca.JWEJCAContext r0 = r4.jcaContext
            java.security.Provider r0 = r0.getProvider()
            r6.setProvider(r0)
            com.nimbusds.jose.jca.JCAContext r6 = r5.getJCAContext()
            com.nimbusds.jose.jca.JWEJCAContext r6 = (com.nimbusds.jose.jca.JWEJCAContext) r6
            com.nimbusds.jose.jca.JWEJCAContext r0 = r4.jcaContext
            java.security.Provider r0 = r0.getKeyEncryptionProvider()
            r6.setKeyEncryptionProvider(r0)
            com.nimbusds.jose.jca.JCAContext r6 = r5.getJCAContext()
            com.nimbusds.jose.jca.JWEJCAContext r6 = (com.nimbusds.jose.jca.JWEJCAContext) r6
            com.nimbusds.jose.jca.JWEJCAContext r0 = r4.jcaContext
            java.security.Provider r0 = r0.getMACProvider()
            r6.setMACProvider(r0)
            com.nimbusds.jose.jca.JCAContext r6 = r5.getJCAContext()
            com.nimbusds.jose.jca.JWEJCAContext r6 = (com.nimbusds.jose.jca.JWEJCAContext) r6
            com.nimbusds.jose.jca.JWEJCAContext r0 = r4.jcaContext
            java.security.Provider r0 = r0.getContentEncryptionProvider()
            r6.setContentEncryptionProvider(r0)
            return r5
        L_0x017f:
            com.nimbusds.jose.KeyTypeException r5 = new com.nimbusds.jose.KeyTypeException
            java.lang.Class<javax.crypto.SecretKey> r6 = javax.crypto.SecretKey.class
            r5.<init>(r6)
            throw r5
        L_0x0187:
            com.nimbusds.jose.JOSEException r5 = new com.nimbusds.jose.JOSEException
            java.lang.String r6 = "Unsupported JWE algorithm or encryption method"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.crypto.factories.DefaultJWEDecrypterFactory.createJWEDecrypter(com.nimbusds.jose.JWEHeader, java.security.Key):com.nimbusds.jose.JWEDecrypter");
    }
}
