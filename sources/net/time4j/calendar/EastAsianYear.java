package net.time4j.calendar;

import net.time4j.base.MathUtils;

public abstract class EastAsianYear {
    public abstract int getElapsedCyclicYears();

    public static EastAsianYear forGregorian(final int i) {
        return new EastAsianYear() {
            public int getElapsedCyclicYears() {
                return MathUtils.safeAdd(i, 2636);
            }
        };
    }

    public static EastAsianYear forMinguo(int i) {
        if (i >= 1) {
            return forGregorian(MathUtils.safeAdd(i, 1911));
        }
        throw new IllegalArgumentException("Minguo year must not be smaller than 1: " + i);
    }

    public static EastAsianYear forDangi(int i) {
        if (i >= 1) {
            return forGregorian(MathUtils.safeAdd(i, -2333));
        }
        throw new IllegalArgumentException("Dangi year must not be smaller than 1: " + i);
    }

    public static EastAsianYear forJuche(int i) {
        if (i >= 1) {
            return forGregorian(MathUtils.safeAdd(i, 1911));
        }
        throw new IllegalArgumentException("Juche year must not be smaller than 1: " + i);
    }

    public final int getCycle() {
        return MathUtils.floorDivide((getElapsedCyclicYears() + 1) - 1, 60) + 1;
    }

    public final CyclicYear getYearOfCycle() {
        int i = 60;
        int floorModulo = MathUtils.floorModulo(getElapsedCyclicYears() + 1, 60);
        if (floorModulo != 0) {
            i = floorModulo;
        }
        return CyclicYear.of(i);
    }
}
