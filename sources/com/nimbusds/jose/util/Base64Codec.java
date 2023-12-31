package com.nimbusds.jose.util;

import java.util.Arrays;
import kotlin.UByte;

final class Base64Codec {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    static int tpEq(int i, int i2) {
        int i3 = i ^ i2;
        return ((~i3) & (i3 - 1)) >>> 63;
    }

    static int tpGT(int i, int i2) {
        return (int) ((((long) i2) - ((long) i)) >>> 63);
    }

    static int tpLT(int i, int i2) {
        return (int) ((((long) i) - ((long) i2)) >>> 63);
    }

    static int tpSelect(int i, int i2, int i3) {
        return ((i - 1) & (i3 ^ i2)) ^ i2;
    }

    Base64Codec() {
    }

    static int computeEncodedLength(int i, boolean z) {
        if (i == 0) {
            return 0;
        }
        if (!z) {
            return (((i - 1) / 3) + 1) << 2;
        }
        int i2 = (i / 3) << 2;
        int i3 = i % 3;
        return i3 == 0 ? i2 : i2 + i3 + 1;
    }

    static byte encodeDigitBase64(int i) {
        int tpLT = tpLT(i, 26);
        int tpGT = tpGT(i, 25) & tpLT(i, 52);
        int tpGT2 = tpGT(i, 51) & tpLT(i, 62);
        int tpEq = tpEq(i, 62);
        int tpEq2 = tpEq(i, 63);
        return (byte) (tpSelect(tpGT2, (i - 52) + 48, 0) | tpSelect(tpLT, i + 0 + 65, 0) | tpSelect(tpGT, (i - 26) + 97, 0) | tpSelect(tpEq, 43, 0) | tpSelect(tpEq2, 47, 0));
    }

    static byte encodeDigitBase64URL(int i) {
        int tpLT = tpLT(i, 26);
        int tpGT = tpGT(i, 25) & tpLT(i, 52);
        int tpGT2 = tpGT(i, 51) & tpLT(i, 62);
        int tpEq = tpEq(i, 62);
        int tpEq2 = tpEq(i, 63);
        return (byte) (tpSelect(tpGT2, (i - 52) + 48, 0) | tpSelect(tpLT, i + 0 + 65, 0) | tpSelect(tpGT, (i - 26) + 97, 0) | tpSelect(tpEq, 45, 0) | tpSelect(tpEq2, 95, 0));
    }

    static int decodeDigit(byte b) {
        int tpGT = tpGT(b, 64) & tpLT(b, 91);
        int tpGT2 = tpGT(b, 96) & tpLT(b, 123);
        int tpGT3 = tpGT(b, 47) & tpLT(b, 58);
        int tpEq = tpEq(b, 45) | tpEq(b, 43);
        int tpEq2 = tpEq(b, 47) | tpEq(b, 95);
        return tpSelect(tpGT3, (b - 48) + 52, 0) | tpSelect(tpGT, (b - 65) + 0, 0) | tpSelect(tpGT2, (b - 97) + 26, 0) | tpSelect(tpEq, 62, 0) | tpSelect(tpEq2, 63, 0) | tpSelect(tpGT | tpGT2 | tpGT3 | tpEq | tpEq2, 0, -1);
    }

    public static String encodeToString(byte[] bArr, boolean z) {
        int i = 0;
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return "";
        }
        int i2 = (length / 3) * 3;
        int computeEncodedLength = computeEncodedLength(length, z);
        byte[] bArr2 = new byte[computeEncodedLength];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            byte b = ((bArr[i3] & UByte.MAX_VALUE) << Tnaf.POW_2_WIDTH) | ((bArr[i5] & UByte.MAX_VALUE) << 8);
            int i7 = i6 + 1;
            byte b2 = b | (bArr[i6] & UByte.MAX_VALUE);
            if (z) {
                int i8 = i4 + 1;
                bArr2[i4] = encodeDigitBase64URL((b2 >>> 18) & 63);
                int i9 = i8 + 1;
                bArr2[i8] = encodeDigitBase64URL((b2 >>> 12) & 63);
                int i10 = i9 + 1;
                bArr2[i9] = encodeDigitBase64URL((b2 >>> 6) & 63);
                i4 = i10 + 1;
                bArr2[i10] = encodeDigitBase64URL(b2 & 63);
            } else {
                int i11 = i4 + 1;
                bArr2[i4] = encodeDigitBase64((b2 >>> 18) & 63);
                int i12 = i11 + 1;
                bArr2[i11] = encodeDigitBase64((b2 >>> 12) & 63);
                int i13 = i12 + 1;
                bArr2[i12] = encodeDigitBase64((b2 >>> 6) & 63);
                i4 = i13 + 1;
                bArr2[i13] = encodeDigitBase64(b2 & 63);
            }
            i3 = i7;
        }
        int i14 = length - i2;
        if (i14 > 0) {
            int i15 = (bArr[i2] & UByte.MAX_VALUE) << 10;
            if (i14 == 2) {
                i = (bArr[length - 1] & UByte.MAX_VALUE) << 2;
            }
            int i16 = i15 | i;
            if (!z) {
                bArr2[computeEncodedLength - 4] = encodeDigitBase64(i16 >> 12);
                bArr2[computeEncodedLength - 3] = encodeDigitBase64((i16 >>> 6) & 63);
                bArr2[computeEncodedLength - 2] = i14 == 2 ? encodeDigitBase64(i16 & 63) : 61;
                bArr2[computeEncodedLength - 1] = 61;
            } else if (i14 == 2) {
                bArr2[computeEncodedLength - 3] = encodeDigitBase64URL(i16 >> 12);
                bArr2[computeEncodedLength - 2] = encodeDigitBase64URL((i16 >>> 6) & 63);
                bArr2[computeEncodedLength - 1] = encodeDigitBase64URL(i16 & 63);
            } else {
                bArr2[computeEncodedLength - 2] = encodeDigitBase64URL(i16 >> 12);
                bArr2[computeEncodedLength - 1] = encodeDigitBase64URL((i16 >>> 6) & 63);
            }
        }
        return new String(bArr2, StandardCharset.UTF_8);
    }

    public static byte[] decode(String str) {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        byte[] bytes = str.getBytes(StandardCharset.UTF_8);
        int length = bytes.length;
        byte[] bArr = new byte[checkedCast((((long) length) * 6) >> 3)];
        int i = 0;
        int i2 = 0;
        while (i < bytes.length) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < 4 && i < length) {
                int i5 = i + 1;
                int decodeDigit = decodeDigit(bytes[i]);
                if (decodeDigit >= 0) {
                    i4 |= decodeDigit << (18 - (i3 * 6));
                    i3++;
                }
                i = i5;
            }
            if (i3 >= 2) {
                int i6 = i2 + 1;
                bArr[i2] = (byte) (i4 >> 16);
                if (i3 >= 3) {
                    i2 = i6 + 1;
                    bArr[i6] = (byte) (i4 >> 8);
                    if (i3 >= 4) {
                        bArr[i2] = (byte) i4;
                        i2++;
                    }
                } else {
                    i2 = i6;
                }
            }
        }
        return Arrays.copyOf(bArr, i2);
    }

    private static int checkedCast(long j) {
        int i = (int) j;
        if (((long) i) == j) {
            return i;
        }
        throw new IllegalArgumentException(j + " cannot be cast to int without changing its value.");
    }
}
