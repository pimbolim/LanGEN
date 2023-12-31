package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.jca.JWEJCAContext;
import com.nimbusds.jose.util.ByteUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.SecretKey;

public abstract class AESCryptoProvider extends BaseJWEProvider {
    public static final Map<Integer, Set<JWEAlgorithm>> COMPATIBLE_ALGORITHMS;
    public static final Set<JWEAlgorithm> SUPPORTED_ALGORITHMS;
    public static final Set<EncryptionMethod> SUPPORTED_ENCRYPTION_METHODS = ContentCryptoProvider.SUPPORTED_ENCRYPTION_METHODS;
    private final SecretKey kek;

    public /* bridge */ /* synthetic */ JWEJCAContext getJCAContext() {
        return super.getJCAContext();
    }

    public /* bridge */ /* synthetic */ Set supportedEncryptionMethods() {
        return super.supportedEncryptionMethods();
    }

    public /* bridge */ /* synthetic */ Set supportedJWEAlgorithms() {
        return super.supportedJWEAlgorithms();
    }

    static {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(JWEAlgorithm.A128KW);
        linkedHashSet.add(JWEAlgorithm.A192KW);
        linkedHashSet.add(JWEAlgorithm.A256KW);
        linkedHashSet.add(JWEAlgorithm.A128GCMKW);
        linkedHashSet.add(JWEAlgorithm.A192GCMKW);
        linkedHashSet.add(JWEAlgorithm.A256GCMKW);
        SUPPORTED_ALGORITHMS = Collections.unmodifiableSet(linkedHashSet);
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(JWEAlgorithm.A128GCMKW);
        hashSet.add(JWEAlgorithm.A128KW);
        hashSet2.add(JWEAlgorithm.A192GCMKW);
        hashSet2.add(JWEAlgorithm.A192KW);
        hashSet3.add(JWEAlgorithm.A256GCMKW);
        hashSet3.add(JWEAlgorithm.A256KW);
        hashMap.put(128, Collections.unmodifiableSet(hashSet));
        hashMap.put(192, Collections.unmodifiableSet(hashSet2));
        hashMap.put(256, Collections.unmodifiableSet(hashSet3));
        COMPATIBLE_ALGORITHMS = Collections.unmodifiableMap(hashMap);
    }

    private static Set<JWEAlgorithm> getCompatibleJWEAlgorithms(int i) throws KeyLengthException {
        Set<JWEAlgorithm> set = COMPATIBLE_ALGORITHMS.get(Integer.valueOf(i));
        if (set != null) {
            return set;
        }
        throw new KeyLengthException("The Key Encryption Key length must be 128 bits (16 bytes), 192 bits (24 bytes) or 256 bits (32 bytes)");
    }

    protected AESCryptoProvider(SecretKey secretKey) throws KeyLengthException {
        super(getCompatibleJWEAlgorithms(ByteUtils.bitLength(secretKey.getEncoded())), ContentCryptoProvider.SUPPORTED_ENCRYPTION_METHODS);
        this.kek = secretKey;
    }

    public SecretKey getKey() {
        return this.kek;
    }
}
