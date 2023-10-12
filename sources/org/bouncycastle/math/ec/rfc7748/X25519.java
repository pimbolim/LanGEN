package org.bouncycastle.math.ec.rfc7748;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.drew.metadata.exif.ExifDirectoryBase;
import java.security.SecureRandom;
import kotlin.UByte;
import org.bouncycastle.math.ec.rfc8032.Ed25519;
import org.bouncycastle.util.Arrays;

public abstract class X25519 {
    private static final int C_A = 486662;
    private static final int C_A24 = 121666;
    public static final int POINT_SIZE = 32;
    public static final int SCALAR_SIZE = 32;

    private static class F extends X25519Field {
        private F() {
        }
    }

    public static class Friend {
        /* access modifiers changed from: private */
        public static final Friend INSTANCE = new Friend();

        private Friend() {
        }
    }

    public static boolean calculateAgreement(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        scalarMult(bArr, i, bArr2, i2, bArr3, i3);
        return !Arrays.areAllZeroes(bArr3, i3, 32);
    }

    private static int decode32(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 8) | ((bArr[i3] & UByte.MAX_VALUE) << Tnaf.POW_2_WIDTH);
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = decode32(bArr, (i2 * 4) + i);
        }
        iArr[0] = iArr[0] & -8;
        iArr[7] = iArr[7] & Integer.MAX_VALUE;
        iArr[7] = iArr[7] | BasicMeasure.EXACTLY;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & 248);
        bArr[31] = (byte) (bArr[31] & Byte.MAX_VALUE);
        bArr[31] = (byte) (bArr[31] | 64);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        scalarMultBase(bArr, i, bArr2, i2);
    }

    private static void pointDouble(int[] iArr, int[] iArr2) {
        int[] create = F.create();
        int[] create2 = F.create();
        F.apm(iArr, iArr2, create, create2);
        F.sqr(create, create);
        F.sqr(create2, create2);
        F.mul(create, create2, iArr);
        F.sub(create, create2, create);
        F.mul(create, (int) C_A24, iArr2);
        F.add(iArr2, create2, iArr2);
        F.mul(iArr2, create, iArr2);
    }

    public static void precompute() {
        Ed25519.precompute();
    }

    public static void scalarMult(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3) {
        int[] iArr = new int[8];
        decodeScalar(bArr, i, iArr);
        int[] create = F.create();
        F.decode(bArr2, i2, create);
        int[] create2 = F.create();
        F.copy(create, 0, create2, 0);
        int[] create3 = F.create();
        create3[0] = 1;
        int[] create4 = F.create();
        create4[0] = 1;
        int[] create5 = F.create();
        int[] create6 = F.create();
        int[] create7 = F.create();
        int i4 = ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE;
        int i5 = 1;
        while (true) {
            F.apm(create4, create5, create6, create4);
            F.apm(create2, create3, create5, create2);
            F.mul(create6, create2, create6);
            F.mul(create4, create5, create4);
            F.sqr(create5, create5);
            F.sqr(create2, create2);
            F.sub(create5, create2, create7);
            F.mul(create7, (int) C_A24, create3);
            F.add(create3, create2, create3);
            F.mul(create3, create7, create3);
            F.mul(create2, create5, create2);
            F.apm(create6, create4, create4, create5);
            F.sqr(create4, create4);
            F.sqr(create5, create5);
            F.mul(create5, create, create5);
            i4--;
            int i6 = (iArr[i4 >>> 5] >>> (i4 & 31)) & 1;
            int i7 = i5 ^ i6;
            F.cswap(i7, create2, create4);
            F.cswap(i7, create3, create5);
            if (i4 < 3) {
                break;
            }
            i5 = i6;
        }
        for (int i8 = 0; i8 < 3; i8++) {
            pointDouble(create2, create3);
        }
        F.inv(create3, create3);
        F.mul(create2, create3, create2);
        F.normalize(create2);
        F.encode(create2, bArr3, i3);
    }

    public static void scalarMultBase(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] create = F.create();
        int[] create2 = F.create();
        Ed25519.scalarMultBaseYZ(Friend.INSTANCE, bArr, i, create, create2);
        F.apm(create2, create, create, create2);
        F.inv(create2, create2);
        F.mul(create, create2, create);
        F.normalize(create);
        F.encode(create, bArr2, i2);
    }
}
