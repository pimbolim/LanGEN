package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

public class SecT163Field {
    private static final long M35 = 34359738367L;
    private static final long M55 = 36028797018963967L;
    private static final long[] ROOT_Z = {-5270498306774157648L, 5270498306774195053L, 19634136210L};

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    public static void addExt(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr2[5] ^ jArr[5];
    }

    public static void addOne(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    private static void addTo(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
    }

    public static long[] fromBigInteger(BigInteger bigInteger) {
        return Nat.fromBigInteger64(163, bigInteger);
    }

    public static void halfTrace(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat192.createExt64();
        Nat192.copy64(jArr, jArr2);
        for (int i = 1; i < 163; i += 2) {
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
            implSquare(jArr2, createExt64);
            reduce(createExt64, jArr2);
            addTo(jArr, jArr2);
        }
    }

    protected static void implCompactExt(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        jArr[0] = j ^ (j2 << 55);
        jArr[1] = (j2 >>> 9) ^ (j3 << 46);
        jArr[2] = (j3 >>> 18) ^ (j4 << 37);
        jArr[3] = (j4 >>> 27) ^ (j5 << 28);
        jArr[4] = (j5 >>> 36) ^ (j6 << 19);
        jArr[5] = j6 >>> 45;
    }

    protected static void implMultiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = (j2 >>> 46) ^ (jArr[2] << 18);
        long j4 = ((j2 << 9) ^ (j >>> 55)) & M55;
        long j5 = j & M55;
        long j6 = jArr2[0];
        long j7 = jArr2[1];
        long j8 = (j7 >>> 46) ^ (jArr2[2] << 18);
        long j9 = ((j7 << 9) ^ (j6 >>> 55)) & M55;
        long j10 = j6 & M55;
        long[] jArr4 = new long[10];
        long[] jArr5 = jArr3;
        long[] jArr6 = jArr4;
        implMulw(jArr5, j5, j10, jArr6, 0);
        implMulw(jArr5, j3, j8, jArr6, 2);
        long j11 = (j5 ^ j4) ^ j3;
        long j12 = (j10 ^ j9) ^ j8;
        implMulw(jArr3, j11, j12, jArr6, 4);
        long j13 = (j4 << 1) ^ (j3 << 2);
        long j14 = (j9 << 1) ^ (j8 << 2);
        long[] jArr7 = jArr3;
        implMulw(jArr7, j5 ^ j13, j10 ^ j14, jArr6, 6);
        implMulw(jArr7, j11 ^ j13, j12 ^ j14, jArr6, 8);
        long j15 = jArr4[6] ^ jArr4[8];
        long j16 = jArr4[7] ^ jArr4[9];
        long j17 = (j15 << 1) ^ jArr4[6];
        long j18 = (j15 ^ (j16 << 1)) ^ jArr4[7];
        long j19 = jArr4[0];
        long j20 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j21 = jArr4[1] ^ jArr4[5];
        long j22 = ((j19 ^ j17) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        long j23 = (((j20 ^ j18) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j22 >>> 55);
        long j24 = j22 & M55;
        long j25 = (j21 ^ j16) ^ (j23 >>> 55);
        long j26 = j23 & M55;
        long j27 = (j24 >>> 1) ^ ((j26 & 1) << 54);
        long j28 = j27 ^ (j27 << 1);
        long j29 = j28 ^ (j28 << 2);
        long j30 = j29 ^ (j29 << 4);
        long j31 = j30 ^ (j30 << 8);
        long j32 = j31 ^ (j31 << 16);
        long j33 = (j32 ^ (j32 << 32)) & M55;
        long j34 = ((j26 >>> 1) ^ ((j25 & 1) << 54)) ^ (j33 >>> 54);
        long j35 = j34 ^ (j34 << 1);
        long j36 = j35 ^ (j35 << 2);
        long j37 = j36 ^ (j36 << 4);
        long j38 = j37 ^ (j37 << 8);
        long j39 = j38 ^ (j38 << 16);
        long j40 = (j39 ^ (j39 << 32)) & M55;
        long j41 = (j25 >>> 1) ^ (j40 >>> 54);
        long j42 = j41 ^ (j41 << 1);
        long j43 = j42 ^ (j42 << 2);
        long j44 = j43 ^ (j43 << 4);
        long j45 = j44 ^ (j44 << 8);
        long j46 = j45 ^ (j45 << 16);
        long j47 = j46 ^ (j46 << 32);
        jArr3[0] = j19;
        jArr3[1] = (j20 ^ j33) ^ jArr4[2];
        jArr3[2] = ((j21 ^ j40) ^ j33) ^ jArr4[3];
        jArr3[3] = j40 ^ j47;
        jArr3[4] = jArr4[2] ^ j47;
        jArr3[5] = jArr4[3];
        implCompactExt(jArr3);
    }

    protected static void implMulw(long[] jArr, long j, long j2, long[] jArr2, int i) {
        long j3 = j;
        jArr[1] = j2;
        jArr[2] = jArr[1] << 1;
        jArr[3] = jArr[2] ^ j2;
        jArr[4] = jArr[2] << 1;
        jArr[5] = jArr[4] ^ j2;
        jArr[6] = jArr[3] << 1;
        jArr[7] = jArr[6] ^ j2;
        long j4 = jArr[((int) j3) & 3];
        long j5 = 0;
        int i2 = 47;
        do {
            int i3 = (int) (j3 >>> i2);
            long j6 = (jArr[(i3 >>> 6) & 7] << 6) ^ (jArr[i3 & 7] ^ (jArr[(i3 >>> 3) & 7] << 3));
            j4 ^= j6 << i2;
            j5 ^= j6 >>> (-i2);
            i2 -= 9;
        } while (i2 > 0);
        jArr2[i] = M55 & j4;
        jArr2[i + 1] = (j4 >>> 55) ^ (j5 << 9);
    }

    protected static void implSquare(long[] jArr, long[] jArr2) {
        Interleave.expand64To128(jArr, 0, 3, jArr2, 0);
    }

    public static void invert(long[] jArr, long[] jArr2) {
        if (!Nat192.isZero64(jArr)) {
            long[] create64 = Nat192.create64();
            long[] create642 = Nat192.create64();
            square(jArr, create64);
            squareN(create64, 1, create642);
            multiply(create64, create642, create64);
            squareN(create642, 1, create642);
            multiply(create64, create642, create64);
            squareN(create64, 3, create642);
            multiply(create64, create642, create64);
            squareN(create642, 3, create642);
            multiply(create64, create642, create64);
            squareN(create64, 9, create642);
            multiply(create64, create642, create64);
            squareN(create642, 9, create642);
            multiply(create64, create642, create64);
            squareN(create64, 27, create642);
            multiply(create64, create642, create64);
            squareN(create642, 27, create642);
            multiply(create64, create642, create64);
            squareN(create64, 81, create642);
            multiply(create64, create642, jArr2);
            return;
        }
        throw new IllegalStateException();
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        implMultiply(jArr, jArr2, jArr4);
        reduce(jArr4, jArr3);
    }

    public static void multiplyAddToExt(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[8];
        implMultiply(jArr, jArr2, jArr4);
        addExt(jArr3, jArr4, jArr3);
    }

    public static void reduce(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = j4 ^ ((((j6 >>> 35) ^ (j6 >>> 32)) ^ (j6 >>> 29)) ^ (j6 >>> 28));
        long j8 = j2 ^ ((((j5 << 29) ^ (j5 << 32)) ^ (j5 << 35)) ^ (j5 << 36));
        long j9 = (j3 ^ ((((j6 << 29) ^ (j6 << 32)) ^ (j6 << 35)) ^ (j6 << 36))) ^ ((j5 >>> 28) ^ (((j5 >>> 35) ^ (j5 >>> 32)) ^ (j5 >>> 29)));
        long j10 = j ^ ((((j7 << 29) ^ (j7 << 32)) ^ (j7 << 35)) ^ (j7 << 36));
        long j11 = j8 ^ ((j7 >>> 28) ^ (((j7 >>> 35) ^ (j7 >>> 32)) ^ (j7 >>> 29)));
        long j12 = j9 >>> 35;
        jArr2[0] = (((j10 ^ j12) ^ (j12 << 3)) ^ (j12 << 6)) ^ (j12 << 7);
        jArr2[1] = j11;
        jArr2[2] = M35 & j9;
    }

    public static void reduce29(long[] jArr, int i) {
        int i2 = i + 2;
        long j = jArr[i2];
        long j2 = j >>> 35;
        jArr[i] = ((j2 << 7) ^ (((j2 << 3) ^ j2) ^ (j2 << 6))) ^ jArr[i];
        jArr[i2] = j & M35;
    }

    public static void sqrt(long[] jArr, long[] jArr2) {
        long[] create64 = Nat192.create64();
        long unshuffle = Interleave.unshuffle(jArr[0]);
        long unshuffle2 = Interleave.unshuffle(jArr[1]);
        create64[0] = (unshuffle >>> 32) | (unshuffle2 & -4294967296L);
        long unshuffle3 = Interleave.unshuffle(jArr[2]);
        long j = unshuffle3 & 4294967295L;
        create64[1] = unshuffle3 >>> 32;
        multiply(create64, ROOT_Z, jArr2);
        jArr2[0] = jArr2[0] ^ ((unshuffle & 4294967295L) | (unshuffle2 << 32));
        jArr2[1] = jArr2[1] ^ j;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat192.createExt64();
        implSquare(jArr, createExt64);
        reduce(createExt64, jArr2);
    }

    public static void squareAddToExt(long[] jArr, long[] jArr2) {
        long[] createExt64 = Nat192.createExt64();
        implSquare(jArr, createExt64);
        addExt(jArr2, createExt64, jArr2);
    }

    public static void squareN(long[] jArr, int i, long[] jArr2) {
        long[] createExt64 = Nat192.createExt64();
        implSquare(jArr, createExt64);
        while (true) {
            reduce(createExt64, jArr2);
            i--;
            if (i > 0) {
                implSquare(jArr2, createExt64);
            } else {
                return;
            }
        }
    }

    public static int trace(long[] jArr) {
        return ((int) (jArr[0] ^ (jArr[2] >>> 29))) & 1;
    }
}
