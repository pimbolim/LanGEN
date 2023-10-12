package com.nimbusds.jose.jca;

import com.nimbusds.jose.Algorithm;
import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWSAlgorithm;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public final class JCASupport {
    public static boolean isUnlimitedStrength() {
        try {
            return Cipher.getMaxAllowedKeyLength("AES") >= 256;
        } catch (NoSuchAlgorithmException unused) {
            return false;
        }
    }

    public static boolean isSupported(Algorithm algorithm) {
        if (algorithm instanceof JWSAlgorithm) {
            return isSupported((JWSAlgorithm) algorithm);
        }
        if (algorithm instanceof JWEAlgorithm) {
            return isSupported((JWEAlgorithm) algorithm);
        }
        if (algorithm instanceof EncryptionMethod) {
            return isSupported((EncryptionMethod) algorithm);
        }
        throw new IllegalArgumentException("Unexpected algorithm class: " + algorithm.getClass().getCanonicalName());
    }

    public static boolean isSupported(Algorithm algorithm, Provider provider) {
        if (algorithm instanceof JWSAlgorithm) {
            return isSupported((JWSAlgorithm) algorithm, provider);
        }
        if (algorithm instanceof JWEAlgorithm) {
            return isSupported((JWEAlgorithm) algorithm, provider);
        }
        if (algorithm instanceof EncryptionMethod) {
            return isSupported((EncryptionMethod) algorithm, provider);
        }
        throw new IllegalArgumentException("Unexpected algorithm class: " + algorithm.getClass().getCanonicalName());
    }

    public static boolean isSupported(JWSAlgorithm jWSAlgorithm) {
        if (jWSAlgorithm.getName().equals(Algorithm.NONE.getName())) {
            return true;
        }
        for (Provider isSupported : Security.getProviders()) {
            if (isSupported(jWSAlgorithm, isSupported)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupported(JWSAlgorithm jWSAlgorithm, Provider provider) {
        String str;
        String str2;
        if (JWSAlgorithm.Family.HMAC_SHA.contains(jWSAlgorithm)) {
            if (jWSAlgorithm.equals(JWSAlgorithm.HS256)) {
                str2 = "HMACSHA256";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.HS384)) {
                str2 = "HMACSHA384";
            } else if (!jWSAlgorithm.equals(JWSAlgorithm.HS512)) {
                return false;
            } else {
                str2 = "HMACSHA512";
            }
            if (provider.getService("KeyGenerator", str2) != null) {
                return true;
            }
            return false;
        } else if (JWSAlgorithm.Family.RSA.contains(jWSAlgorithm)) {
            String str3 = null;
            String str4 = "RSASSA-PSS";
            if (jWSAlgorithm.equals(JWSAlgorithm.RS256)) {
                str4 = "SHA256withRSA";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.RS384)) {
                str4 = "SHA384withRSA";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.RS512)) {
                str4 = "SHA512withRSA";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.PS256)) {
                str3 = "SHA256withRSAandMGF1";
            } else if (jWSAlgorithm.equals(JWSAlgorithm.PS384)) {
                str3 = "SHA384withRSAandMGF1";
            } else if (!jWSAlgorithm.equals(JWSAlgorithm.PS512)) {
                return false;
            } else {
                str3 = "SHA512withRSAandMGF1";
            }
            if (provider.getService("Signature", str4) != null) {
                return true;
            }
            if (str3 == null || provider.getService("Signature", str3) == null) {
                return false;
            }
            return true;
        } else {
            if (JWSAlgorithm.Family.EC.contains(jWSAlgorithm)) {
                if (jWSAlgorithm.equals(JWSAlgorithm.ES256)) {
                    str = "SHA256withECDSA";
                } else if (jWSAlgorithm.equals(JWSAlgorithm.ES384)) {
                    str = "SHA384withECDSA";
                } else if (jWSAlgorithm.equals(JWSAlgorithm.ES512)) {
                    str = "SHA512withECDSA";
                }
                if (provider.getService("Signature", str) != null) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public static boolean isSupported(JWEAlgorithm jWEAlgorithm) {
        for (Provider isSupported : Security.getProviders()) {
            if (isSupported(jWEAlgorithm, isSupported)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupported(JWEAlgorithm jWEAlgorithm, Provider provider) {
        String str;
        String str2;
        if (JWEAlgorithm.Family.RSA.contains(jWEAlgorithm)) {
            if (jWEAlgorithm.equals(JWEAlgorithm.RSA1_5)) {
                str2 = "RSA/ECB/PKCS1Padding";
            } else if (jWEAlgorithm.equals(JWEAlgorithm.RSA_OAEP)) {
                str2 = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
            } else if (jWEAlgorithm.equals(JWEAlgorithm.RSA_OAEP_256)) {
                str2 = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
            } else {
                if (jWEAlgorithm.equals(JWEAlgorithm.RSA_OAEP_512)) {
                    str2 = "RSA/ECB/OAEPWithSHA-512AndMGF1Padding";
                }
                return false;
            }
            try {
                Cipher.getInstance(str2, provider);
                return true;
            } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            }
        } else if (JWEAlgorithm.Family.AES_KW.contains(jWEAlgorithm)) {
            if (provider.getService("Cipher", "AESWrap") != null) {
                return true;
            }
            return false;
        } else if (JWEAlgorithm.Family.ECDH_ES.contains(jWEAlgorithm)) {
            if (provider.getService("KeyAgreement", "ECDH") != null) {
                return true;
            }
            return false;
        } else if (JWEAlgorithm.Family.AES_GCM_KW.contains(jWEAlgorithm)) {
            try {
                Cipher.getInstance("AES/GCM/NoPadding", provider);
                return true;
            } catch (NoSuchAlgorithmException | NoSuchPaddingException unused2) {
                return false;
            }
        } else if (!JWEAlgorithm.Family.PBES2.contains(jWEAlgorithm)) {
            return JWEAlgorithm.DIR.equals(jWEAlgorithm);
        } else {
            if (jWEAlgorithm.equals(JWEAlgorithm.PBES2_HS256_A128KW)) {
                str = "HmacSHA256";
            } else {
                str = jWEAlgorithm.equals(JWEAlgorithm.PBES2_HS384_A192KW) ? "HmacSHA384" : "HmacSHA512";
            }
            if (provider.getService("KeyGenerator", str) != null) {
                return true;
            }
            return false;
        }
    }

    public static boolean isSupported(EncryptionMethod encryptionMethod) {
        for (Provider isSupported : Security.getProviders()) {
            if (isSupported(encryptionMethod, isSupported)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupported(EncryptionMethod encryptionMethod, Provider provider) {
        String str;
        if (EncryptionMethod.Family.AES_CBC_HMAC_SHA.contains(encryptionMethod)) {
            try {
                Cipher.getInstance("AES/CBC/PKCS5Padding", provider);
                if (encryptionMethod.equals(EncryptionMethod.A128CBC_HS256)) {
                    str = "HmacSHA256";
                } else {
                    str = encryptionMethod.equals(EncryptionMethod.A192CBC_HS384) ? "HmacSHA384" : "HmacSHA512";
                }
                if (provider.getService("KeyGenerator", str) != null) {
                    return true;
                }
                return false;
            } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
                return false;
            }
        } else {
            if (EncryptionMethod.Family.AES_GCM.contains(encryptionMethod)) {
                try {
                    Cipher.getInstance("AES/GCM/NoPadding", provider);
                    return true;
                } catch (NoSuchAlgorithmException | NoSuchPaddingException unused2) {
                }
            }
            return false;
        }
    }

    private JCASupport() {
    }
}
