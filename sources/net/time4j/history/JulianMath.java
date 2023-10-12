package net.time4j.history;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import net.time4j.base.MathUtils;

class JulianMath {
    public static final int MAX_YEAR = 999999999;
    public static final int MIN_YEAR = -999999999;
    private static final int OFFSET = 678883;

    public static int readDayOfMonth(long j) {
        return (int) (j & 255);
    }

    public static int readMonth(long j) {
        return (int) ((j >> 16) & 255);
    }

    public static int readYear(long j) {
        return (int) (j >> 32);
    }

    private JulianMath() {
    }

    public static boolean isLeapYear(int i) {
        return MathUtils.floorModulo(i, 4) == 0;
    }

    public static int getLengthOfMonth(int i, int i2) {
        switch (i2) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return isLeapYear(i) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                throw new IllegalArgumentException("Invalid month: " + i2);
        }
    }

    public static boolean isValid(int i, int i2, int i3) {
        return i >= -999999999 && i <= 999999999 && i2 >= 1 && i2 <= 12 && i3 >= 1 && i3 <= getLengthOfMonth(i, i2);
    }

    public static void checkDate(int i, int i2, int i3) {
        if (i < -999999999 || i > 999999999) {
            throw new IllegalArgumentException("YEAR out of range: " + i);
        } else if (i2 < 1 || i2 > 12) {
            throw new IllegalArgumentException("MONTH out of range: " + i2);
        } else if (i3 < 1 || i3 > 31) {
            throw new IllegalArgumentException("DAY_OF_MONTH out of range: " + i3);
        } else if (i3 > getLengthOfMonth(i, i2)) {
            throw new IllegalArgumentException("DAY_OF_MONTH exceeds month length in given year: " + toString(i, i2, i3));
        }
    }

    public static long toPackedDate(long j) {
        int i;
        long j2;
        long safeAdd = MathUtils.safeAdd(j, 678883);
        long floorDivide = MathUtils.floorDivide(safeAdd, 1461);
        int floorModulo = MathUtils.floorModulo(safeAdd, 1461);
        int i2 = 2;
        if (floorModulo == 1460) {
            j2 = (floorDivide + 1) * 4;
            i = 29;
        } else {
            int i3 = floorModulo / 365;
            int i4 = floorModulo % 365;
            j2 = (floorDivide * 4) + ((long) i3);
            i2 = 2 + (((i4 + 31) * 5) / 153);
            i = (i4 - (((i2 + 1) * 153) / 5)) + 123;
            if (i2 > 12) {
                j2++;
                i2 -= 12;
            }
        }
        if (j2 < -999999999 || j2 > 999999999) {
            throw new IllegalArgumentException("Year out of range: " + j2);
        }
        return ((long) i) | (j2 << 32) | ((long) (i2 << 16));
    }

    public static long toMJD(int i, int i2, int i3) {
        checkDate(i, i2, i3);
        long j = (long) i;
        if (i2 < 3) {
            j--;
            i2 += 12;
        }
        return (((((365 * j) + MathUtils.floorDivide(j, 4)) + ((long) (((i2 + 1) * 153) / 5))) - 123) + ((long) i3)) - 678883;
    }

    private static String toString(int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(SignatureVisitor.SUPER);
        if (i2 < 10) {
            sb.append('0');
        }
        sb.append(i2);
        sb.append(SignatureVisitor.SUPER);
        if (i3 < 10) {
            sb.append('0');
        }
        sb.append(i3);
        return sb.toString();
    }
}
