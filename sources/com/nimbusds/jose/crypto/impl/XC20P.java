package com.nimbusds.jose.crypto.impl;

import com.google.crypto.tink.subtle.XChaCha20Poly1305;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.Container;
import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class XC20P {
    public static final int AUTH_TAG_BIT_LENGTH = 128;
    public static final int IV_BIT_LENGTH = 192;

    public static AuthenticatedCipherText encryptAuthenticated(SecretKey secretKey, Container<byte[]> container, byte[] bArr, byte[] bArr2) throws JOSEException {
        try {
            try {
                byte[] encrypt = new XChaCha20Poly1305(secretKey.getEncoded()).encrypt(bArr, bArr2);
                int length = encrypt.length - ByteUtils.byteLength(128);
                int byteLength = ByteUtils.byteLength(192);
                byte[] subArray = ByteUtils.subArray(encrypt, 0, byteLength);
                byte[] subArray2 = ByteUtils.subArray(encrypt, byteLength, length - byteLength);
                byte[] subArray3 = ByteUtils.subArray(encrypt, length, ByteUtils.byteLength(128));
                container.set(subArray);
                return new AuthenticatedCipherText(subArray2, subArray3);
            } catch (GeneralSecurityException e) {
                throw new JOSEException("Couldn't encrypt with XChaCha20Poly1305: " + e.getMessage(), e);
            }
        } catch (GeneralSecurityException e2) {
            throw new JOSEException("Invalid XChaCha20Poly1305 key: " + e2.getMessage(), e2);
        }
    }

    public static byte[] decryptAuthenticated(SecretKey secretKey, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws JOSEException {
        try {
            try {
                return new XChaCha20Poly1305(secretKey.getEncoded()).decrypt(ByteUtils.concat(bArr, bArr2, bArr4), bArr3);
            } catch (GeneralSecurityException e) {
                throw new JOSEException("XChaCha20Poly1305 decryption failed: " + e.getMessage(), e);
            }
        } catch (GeneralSecurityException e2) {
            throw new JOSEException("Invalid XChaCha20Poly1305 key: " + e2.getMessage(), e2);
        }
    }
}
