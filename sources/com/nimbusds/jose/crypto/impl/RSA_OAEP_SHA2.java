package com.nimbusds.jose.crypto.impl;

import com.nimbusds.jose.JOSEException;
import java.security.AlgorithmParameters;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class RSA_OAEP_SHA2 {
    private static final String RSA_OEAP_256_JCA_ALG = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final String RSA_OEAP_384_JCA_ALG = "RSA/ECB/OAEPWithSHA-384AndMGF1Padding";
    private static final String RSA_OEAP_512_JCA_ALG = "RSA/ECB/OAEPWithSHA-512AndMGF1Padding";
    private static final String SHA_256_JCA_ALG = "SHA-256";
    private static final String SHA_384_JCA_ALG = "SHA-384";
    private static final String SHA_512_JCA_ALG = "SHA-512";

    public static byte[] encryptCEK(RSAPublicKey rSAPublicKey, SecretKey secretKey, int i, Provider provider) throws JOSEException {
        MGF1ParameterSpec mGF1ParameterSpec;
        String str;
        String str2;
        if (256 == i) {
            mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
            str2 = RSA_OEAP_256_JCA_ALG;
            str = "SHA-256";
        } else if (384 == i) {
            mGF1ParameterSpec = MGF1ParameterSpec.SHA384;
            str2 = RSA_OEAP_384_JCA_ALG;
            str = "SHA-384";
        } else if (512 == i) {
            mGF1ParameterSpec = MGF1ParameterSpec.SHA512;
            str2 = RSA_OEAP_512_JCA_ALG;
            str = "SHA-512";
        } else {
            throw new JOSEException("Unsupported SHA-2 bit size: " + i);
        }
        try {
            AlgorithmParameters instance = AlgorithmParametersHelper.getInstance("OAEP", provider);
            instance.init(new OAEPParameterSpec(str, "MGF1", mGF1ParameterSpec, PSource.PSpecified.DEFAULT));
            Cipher instance2 = CipherHelper.getInstance(str2, provider);
            instance2.init(1, rSAPublicKey, instance);
            return instance2.doFinal(secretKey.getEncoded());
        } catch (IllegalBlockSizeException e) {
            throw new JOSEException("RSA block size exception: The RSA key is too short, use a longer one", e);
        } catch (Exception e2) {
            throw new JOSEException(e2.getMessage(), e2);
        }
    }

    public static SecretKey decryptCEK(PrivateKey privateKey, byte[] bArr, int i, Provider provider) throws JOSEException {
        MGF1ParameterSpec mGF1ParameterSpec;
        String str;
        String str2;
        if (256 == i) {
            mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
            str2 = RSA_OEAP_256_JCA_ALG;
            str = "SHA-256";
        } else if (384 == i) {
            mGF1ParameterSpec = MGF1ParameterSpec.SHA384;
            str2 = RSA_OEAP_384_JCA_ALG;
            str = "SHA-384";
        } else if (512 == i) {
            mGF1ParameterSpec = MGF1ParameterSpec.SHA512;
            str2 = RSA_OEAP_512_JCA_ALG;
            str = "SHA-512";
        } else {
            throw new JOSEException("Unsupported SHA-2 bit size: " + i);
        }
        try {
            AlgorithmParameters instance = AlgorithmParametersHelper.getInstance("OAEP", provider);
            instance.init(new OAEPParameterSpec(str, "MGF1", mGF1ParameterSpec, PSource.PSpecified.DEFAULT));
            Cipher instance2 = CipherHelper.getInstance(str2, provider);
            instance2.init(2, privateKey, instance);
            return new SecretKeySpec(instance2.doFinal(bArr), "AES");
        } catch (Exception e) {
            throw new JOSEException(e.getMessage(), e);
        }
    }

    private RSA_OAEP_SHA2() {
    }
}
