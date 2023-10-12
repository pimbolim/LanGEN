package net.time4j.scale;

import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;

public enum TimeScale {
    POSIX,
    UTC,
    TAI,
    GPS,
    TT,
    UT;

    public static double deltaT(int i, int i2) {
        if (i2 >= 1 && i2 <= 12) {
            return deltaT(i, ((double) i) + ((((double) i2) - 0.5d) / 12.0d));
        }
        throw new IllegalArgumentException("Month out of range: " + i2);
    }

    public static double deltaT(GregorianDate gregorianDate) {
        int year = gregorianDate.getYear();
        int i = GregorianMath.isLeapYear(year) ? 366 : 365;
        int i2 = 0;
        int month = gregorianDate.getMonth();
        int i3 = 1;
        for (int i4 = 1; i4 < month; i4++) {
            i2 += GregorianMath.getLengthOfMonth(year, i4);
        }
        int dayOfMonth = i2 + gregorianDate.getDayOfMonth();
        if (dayOfMonth <= i) {
            if (year == -2001 && dayOfMonth == 365) {
                year = -2000;
            } else {
                i3 = dayOfMonth;
            }
            return deltaT(year, ((double) year) + ((((double) i3) - 1.0d) / ((double) i)));
        }
        throw new IllegalArgumentException(gregorianDate.toString());
    }

    private static double deltaT(int i, double d) {
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19;
        double d20;
        double d21;
        double d22;
        double d23;
        double d24;
        double d25;
        double d26;
        double d27;
        double d28;
        double d29;
        double d30;
        double d31;
        double d32;
        int i2 = i;
        if (i2 < -2000 || i2 > 3000) {
            throw new IllegalArgumentException("Year out of range: " + i2);
        }
        if (i2 <= 2050) {
            if (i2 >= 2018) {
                d28 = d - 2000.0d;
                d29 = 64.16d;
                d30 = 0.0533d;
                d31 = 0.012125d * d28;
            } else {
                if (i2 >= 2005) {
                    d15 = d - 2000.0d;
                    d16 = 63.5934d;
                    d17 = 0.171417d;
                    d18 = 0.014201d;
                    d19 = -0.00112745d;
                    d20 = 4.2060317E-5d * d15;
                } else {
                    if (i2 >= 1986) {
                        d21 = d - 2000.0d;
                        d22 = 63.86d;
                        d23 = 0.3345d;
                        d24 = -0.060374d;
                        d25 = 0.0017275d;
                        d26 = 6.51814E-4d;
                        d27 = 2.373599E-5d * d21;
                    } else if (i2 >= 1961) {
                        d15 = d - 1975.0d;
                        d16 = 45.45d;
                        d17 = 1.067d;
                        d32 = 0.0d - (d15 / 718.0d);
                        return (((d32 * d15) + d17) * d15) + d16;
                    } else if (i2 >= 1941) {
                        d28 = d - 1950.0d;
                        d29 = 29.07d;
                        d30 = 0.407d;
                        d31 = ((d28 / 2547.0d) + 0.0d) * d28;
                    } else {
                        if (i2 >= 1920) {
                            d10 = d - 1920.0d;
                            d11 = 21.2d;
                            d12 = 0.84493d;
                            d13 = -0.0761d;
                            d14 = 0.0020936d * d10;
                        } else if (i2 >= 1900) {
                            d10 = d - 1900.0d;
                            d11 = -2.79d;
                            d12 = 1.494119d;
                            d13 = -0.0598939d;
                            d14 = (0.0061966d - (1.97E-4d * d10)) * d10;
                        } else if (i2 >= 1860) {
                            d21 = d - 1860.0d;
                            d22 = 7.62d;
                            d23 = 0.5737d;
                            d24 = -0.251754d;
                            d25 = 0.01680668d;
                            d26 = -4.473624E-4d;
                            d27 = d21 / 233174.0d;
                        } else if (i2 >= 1800) {
                            double d33 = d - 1800.0d;
                            return (((((((((((((8.75E-10d * d33) - 2.6420348728429772E7d) * d33) + 1.21272E-5d) * d33) - 12014.56283648d) * d33) + 0.0041116d) * d33) + 0.0068612d) * d33) - 13.361696d) * d33) + 13.72d;
                        } else if (i2 >= 1700) {
                            d15 = d - 1700.0d;
                            d16 = 8.83d;
                            d17 = 0.1603d;
                            d18 = -0.0059285d;
                            d19 = 1.3336E-4d;
                            d20 = d15 / 1174000.0d;
                        } else if (i2 >= 1600) {
                            d10 = d - 1600.0d;
                            d11 = 120.0d;
                            d12 = -0.9808d;
                            d13 = -0.01532d;
                            d14 = d10 / 7129.0d;
                        } else {
                            if (i2 >= 500) {
                                d2 = (d - 1000.0d) / 100.0d;
                                d3 = 1574.2d;
                                d4 = -556.01d;
                                d5 = 71.23472d;
                                d6 = 0.319781d;
                                d7 = -0.8503463d;
                                d8 = -0.005050998d;
                                d9 = 0.0083572073d;
                            } else if (i2 >= -500) {
                                d2 = d / 100.0d;
                                d3 = 10583.6d;
                                d4 = -1014.41d;
                                d5 = 33.78311d;
                                d6 = -5.952053d;
                                d7 = -0.1798452d;
                                d8 = 0.022174192d;
                                d9 = 0.0090316521d;
                            }
                            return (((((((((((d9 * d2) + d8) * d2) + d7) * d2) + d6) * d2) + d5) * d2) + d4) * d2) + d3;
                        }
                        return ((((d14 + d13) * d10) + d12) * d10) + d11;
                    }
                    return ((((((((d27 + d26) * d21) + d25) * d21) + d24) * d21) + d23) * d21) + d22;
                }
                d32 = ((d20 + d19) * d15) + d18;
                return (((d32 * d15) + d17) * d15) + d16;
            }
            return ((d31 + d30) * d28) + d29;
        }
        double d34 = (d - 1820.0d) / 100.0d;
        return ((32.0d * d34) * d34) - 0.21875d;
    }
}
