package com.stripe.android.stripe3ds2.security;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWECryptoParts;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jose.crypto.impl.AAD;
import com.nimbusds.jose.crypto.impl.AESCBC;
import com.nimbusds.jose.crypto.impl.AESGCM;
import com.nimbusds.jose.crypto.impl.AlgorithmSupportMessage;
import com.nimbusds.jose.crypto.impl.AuthenticatedCipherText;
import com.nimbusds.jose.crypto.impl.DeflateHelper;
import com.nimbusds.jose.crypto.impl.DirectCryptoProvider;
import com.nimbusds.jose.util.Base64URL;
import com.nimbusds.jose.util.ByteUtils;
import com.nimbusds.jose.util.Container;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/TransactionEncrypter;", "Lcom/nimbusds/jose/crypto/DirectEncrypter;", "key", "", "counter", "", "([BB)V", "encrypt", "Lcom/nimbusds/jose/JWECryptoParts;", "header", "Lcom/nimbusds/jose/JWEHeader;", "clearText", "Crypto", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransactionEncrypter.kt */
public final class TransactionEncrypter extends DirectEncrypter {
    private final byte counter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransactionEncrypter(byte[] bArr, byte b) throws KeyLengthException {
        super((SecretKey) new SecretKeySpec(bArr, "AES"));
        Intrinsics.checkNotNullParameter(bArr, "key");
        this.counter = b;
    }

    public JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        byte[] bArr2;
        AuthenticatedCipherText authenticatedCipherText;
        Intrinsics.checkNotNullParameter(jWEHeader, "header");
        Intrinsics.checkNotNullParameter(bArr, "clearText");
        JWEAlgorithm algorithm = jWEHeader.getAlgorithm();
        if (Intrinsics.areEqual((Object) algorithm, (Object) JWEAlgorithm.DIR)) {
            EncryptionMethod encryptionMethod = jWEHeader.getEncryptionMethod();
            if (encryptionMethod.cekBitLength() != ByteUtils.bitLength(getKey().getEncoded())) {
                throw new KeyLengthException(encryptionMethod.cekBitLength(), encryptionMethod);
            } else if (encryptionMethod.cekBitLength() == ByteUtils.bitLength(getKey().getEncoded())) {
                byte[] applyCompression = DeflateHelper.applyCompression(jWEHeader, bArr);
                byte[] compute = AAD.compute(jWEHeader);
                if (Intrinsics.areEqual((Object) jWEHeader.getEncryptionMethod(), (Object) EncryptionMethod.A128CBC_HS256)) {
                    bArr2 = Crypto.INSTANCE.getGcmIvStoA(128, this.counter);
                    authenticatedCipherText = AESCBC.encryptAuthenticated(getKey(), bArr2, applyCompression, compute, getJCAContext().getContentEncryptionProvider(), getJCAContext().getMACProvider());
                    Intrinsics.checkNotNullExpressionValue(authenticatedCipherText, "encryptAuthenticated(\n  …rovider\n                )");
                } else if (Intrinsics.areEqual((Object) jWEHeader.getEncryptionMethod(), (Object) EncryptionMethod.A128GCM)) {
                    bArr2 = Crypto.INSTANCE.getGcmIvStoA(96, this.counter);
                    authenticatedCipherText = AESGCM.encrypt(getKey(), new Container(bArr2), applyCompression, compute, (Provider) null);
                    Intrinsics.checkNotNullExpressionValue(authenticatedCipherText, "encrypt(key, Container(iv), plainText, aad, null)");
                } else {
                    throw new JOSEException(AlgorithmSupportMessage.unsupportedEncryptionMethod(jWEHeader.getEncryptionMethod(), DirectCryptoProvider.SUPPORTED_ENCRYPTION_METHODS));
                }
                return new JWECryptoParts(jWEHeader, (Base64URL) null, Base64URL.encode(bArr2), Base64URL.encode(authenticatedCipherText.getCipherText()), Base64URL.encode(authenticatedCipherText.getAuthenticationTag()));
            } else {
                throw new KeyLengthException("The Content Encryption Key length for " + encryptionMethod + " must be " + encryptionMethod.cekBitLength() + " bits");
            }
        } else {
            throw new JOSEException(Intrinsics.stringPlus("Invalid algorithm ", algorithm));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH\u0002J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/TransactionEncrypter$Crypto;", "", "()V", "BITS_IN_BYTE", "", "getGcmId", "", "length", "pad", "", "counter", "getGcmIvAtoS", "sdkCounterAtoS", "getGcmIvStoA", "sdkCounterStoA", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TransactionEncrypter.kt */
    public static final class Crypto {
        private static final int BITS_IN_BYTE = 8;
        public static final Crypto INSTANCE = new Crypto();

        private Crypto() {
        }

        public final byte[] getGcmIvStoA(int i, byte b) {
            return getGcmId(i, (byte) 0, b);
        }

        private final byte[] getGcmIvAtoS(int i, byte b) {
            return getGcmId(i, (byte) -1, b);
        }

        private final byte[] getGcmId(int i, byte b, byte b2) {
            int i2 = i / 8;
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, b);
            bArr[i2 - 1] = b2;
            return bArr;
        }
    }
}
