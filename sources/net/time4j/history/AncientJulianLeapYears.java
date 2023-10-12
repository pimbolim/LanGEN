package net.time4j.history;

import java.util.Arrays;

public final class AncientJulianLeapYears {
    /* access modifiers changed from: private */
    public static final HistoricDate AD8 = HistoricDate.of(HistoricEra.AD, 8, 1, 1);
    /* access modifiers changed from: private */
    public static final HistoricDate BC45 = HistoricDate.of(HistoricEra.BC, 45, 1, 1);
    private static final long MJD_OF_AD8 = -676021;
    public static final AncientJulianLeapYears SCALIGER;
    private static final int[] SEQUENCE_SCALIGER;
    private final Calculus calculus;
    /* access modifiers changed from: private */
    public final int[] leaps;

    static {
        int[] iArr = {42, 39, 36, 33, 30, 27, 24, 21, 18, 15, 12, 9};
        SEQUENCE_SCALIGER = iArr;
        SCALIGER = new AncientJulianLeapYears(iArr);
    }

    private AncientJulianLeapYears(int... iArr) {
        int i;
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        while (true) {
            i = 1;
            if (i2 >= iArr.length) {
                break;
            }
            iArr2[i2] = 1 - iArr[i2];
            i2++;
        }
        Arrays.sort(iArr2);
        this.leaps = iArr2;
        if (iArr2.length == 0) {
            throw new IllegalArgumentException("Missing leap years.");
        } else if (iArr2[0] < -44 || iArr2[iArr2.length - 1] >= 8) {
            throw new IllegalArgumentException("Out of range: " + Arrays.toString(iArr));
        } else {
            int i3 = iArr2[0];
            while (i < iArr.length) {
                if (iArr2[i] != i3) {
                    i3 = iArr2[i];
                    i++;
                } else {
                    throw new IllegalArgumentException("Contains duplicates: " + Arrays.toString(iArr));
                }
            }
            this.calculus = new Calculus() {
                public long toMJD(HistoricDate historicDate) {
                    if (historicDate.compareTo(AncientJulianLeapYears.AD8) >= 0) {
                        return CalendarAlgorithm.JULIAN.toMJD(historicDate);
                    }
                    if (historicDate.compareTo(AncientJulianLeapYears.BC45) >= 0) {
                        long j = AncientJulianLeapYears.MJD_OF_AD8;
                        int prolepticYear = getProlepticYear(historicDate);
                        for (int i = 7; i >= prolepticYear; i--) {
                            j -= isLeapYear(i) ? 366 : 365;
                        }
                        for (int i2 = 1; i2 < historicDate.getMonth(); i2++) {
                            j += (long) getMaximumDayOfMonth(prolepticYear, i2);
                        }
                        return (j + ((long) historicDate.getDayOfMonth())) - 1;
                    }
                    throw new IllegalArgumentException("Not valid before 45 BC: " + historicDate);
                }

                public HistoricDate fromMJD(long j) {
                    long j2 = AncientJulianLeapYears.MJD_OF_AD8;
                    if (j >= AncientJulianLeapYears.MJD_OF_AD8) {
                        return CalendarAlgorithm.JULIAN.fromMJD(j);
                    }
                    int i = 7;
                    while (i >= -44) {
                        j2 -= isLeapYear(i) ? 366 : 365;
                        if (j2 <= j) {
                            int i2 = 1;
                            while (i2 <= 12) {
                                long maximumDayOfMonth = ((long) getMaximumDayOfMonth(i, i2)) + j2;
                                if (maximumDayOfMonth > j) {
                                    HistoricEra historicEra = i <= 0 ? HistoricEra.BC : HistoricEra.AD;
                                    if (i <= 0) {
                                        i = 1 - i;
                                    }
                                    return HistoricDate.of(historicEra, i, i2, (int) ((j - j2) + 1));
                                }
                                i2++;
                                j2 = maximumDayOfMonth;
                            }
                            continue;
                        }
                        i--;
                    }
                    throw new IllegalArgumentException("Not valid before 45 BC: " + j);
                }

                public boolean isValid(HistoricDate historicDate) {
                    int prolepticYear;
                    if (historicDate == null || (prolepticYear = getProlepticYear(historicDate)) < -44) {
                        return false;
                    }
                    if (prolepticYear >= 8) {
                        return CalendarAlgorithm.JULIAN.isValid(historicDate);
                    }
                    if (historicDate.getDayOfMonth() <= getMaximumDayOfMonth(prolepticYear, historicDate.getMonth())) {
                        return true;
                    }
                    return false;
                }

                public int getMaximumDayOfMonth(HistoricDate historicDate) {
                    if (historicDate.compareTo(AncientJulianLeapYears.AD8) >= 0) {
                        return CalendarAlgorithm.JULIAN.getMaximumDayOfMonth(historicDate);
                    }
                    if (historicDate.compareTo(AncientJulianLeapYears.BC45) >= 0) {
                        return getMaximumDayOfMonth(getProlepticYear(historicDate), historicDate.getMonth());
                    }
                    throw new IllegalArgumentException("Not valid before 45 BC: " + historicDate);
                }

                private int getMaximumDayOfMonth(int i, int i2) {
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

                private int getProlepticYear(HistoricDate historicDate) {
                    return historicDate.getEra().annoDomini(historicDate.getYearOfEra());
                }

                private boolean isLeapYear(int i) {
                    return Arrays.binarySearch(AncientJulianLeapYears.this.leaps, i) >= 0;
                }
            };
        }
    }

    public static AncientJulianLeapYears of(int... iArr) {
        if (Arrays.equals(iArr, SEQUENCE_SCALIGER)) {
            return SCALIGER;
        }
        return new AncientJulianLeapYears(iArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AncientJulianLeapYears) || this.leaps != ((AncientJulianLeapYears) obj).leaps) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.leaps);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.leaps.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = 1 - this.leaps[i];
            if (i2 > 0) {
                sb.append("BC ");
                sb.append(i2);
            } else {
                sb.append("AD ");
                sb.append(this.leaps[i]);
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int[] getPattern() {
        return this.leaps;
    }

    /* access modifiers changed from: package-private */
    public Calculus getCalculus() {
        return this.calculus;
    }
}
