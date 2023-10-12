package net.time4j.calendar.frenchrev;

import com.facebook.common.statfs.StatFsHelper;
import net.time4j.CalendarUnit;
import net.time4j.PlainDate;
import net.time4j.PlainTimestamp;
import net.time4j.base.MathUtils;
import net.time4j.calendar.astro.AstronomicalSeason;
import net.time4j.calendar.astro.SolarTime;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.EpochDays;
import net.time4j.format.Attributes;
import net.time4j.tz.OffsetSign;
import net.time4j.tz.ZonalOffset;

public enum FrenchRepublicanAlgorithm {
    EQUINOX {
        public boolean isLeapYear(int i) {
            if (i < 1 || i > 1202) {
                throw new IllegalArgumentException("Out of range: " + i);
            }
            if (autumnalEquinox(i + 1).getDaysSinceEpochUTC() - autumnalEquinox(i).getDaysSinceEpochUTC() == 366) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public FrenchRepublicanCalendar transform(long j) {
            FrenchRepublicanAlgorithm.check(j);
            PlainDate of = PlainDate.of(j, EpochDays.UTC);
            int year = of.getYear() - 1791;
            if (of.getMonth() < 9) {
                year--;
            }
            long between = CalendarUnit.DAYS.between(autumnalEquinox(year), of);
            while (between < 0) {
                year--;
                between = CalendarUnit.DAYS.between(autumnalEquinox(year), of);
            }
            return new FrenchRepublicanCalendar(year, (int) (between + 1));
        }

        /* access modifiers changed from: package-private */
        public long transform(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return (autumnalEquinox(frenchRepublicanCalendar.getYear()).getDaysSinceEpochUTC() + ((long) frenchRepublicanCalendar.getDayOfYear())) - 1;
        }

        private PlainDate autumnalEquinox(int i) {
            return ((PlainTimestamp) AstronomicalSeason.AUTUMNAL_EQUINOX.inYear(i + 1791).get(SolarTime.apparentAt(FrenchRepublicanAlgorithm.PARIS_OBSERVATORY))).getCalendarDate();
        }
    },
    ROMME {
        public boolean isLeapYear(int i) {
            if (i < 1 || i > 1202) {
                throw new IllegalArgumentException("Out of range: " + i);
            } else if (i == 3 || i == 7 || i == 11) {
                return true;
            } else {
                return i >= 15 && (i & 3) == 0 && (i % 100 != 0 || i % StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB == 0);
            }
        }

        /* access modifiers changed from: package-private */
        public FrenchRepublicanCalendar transform(long j) {
            if (j < FrenchRepublicanAlgorithm.ABOLITION) {
                return EQUINOX.transform(j);
            }
            FrenchRepublicanAlgorithm.check(j);
            int floorDivide = (int) (MathUtils.floorDivide(((j - FrenchRepublicanAlgorithm.EPOCH) + 2) * 4000, 1460969) + 1);
            long transform = transform(new FrenchRepublicanCalendar(floorDivide, 1));
            if (transform > j) {
                transform = transform(new FrenchRepublicanCalendar(floorDivide - 1, 1));
                floorDivide--;
            }
            return new FrenchRepublicanCalendar(floorDivide, (int) ((j - transform) + 1));
        }

        /* access modifiers changed from: package-private */
        public long transform(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            if (frenchRepublicanCalendar.getYear() < 15) {
                return EQUINOX.transform(frenchRepublicanCalendar);
            }
            int year = frenchRepublicanCalendar.getYear() - 1;
            return ((((FrenchRepublicanAlgorithm.EPOCH - 1) + ((long) (year * 365))) + ((long) MathUtils.floorDivide(year, 4))) - ((long) MathUtils.floorDivide(year, 100))) + ((long) MathUtils.floorDivide(year, (int) StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB)) + ((long) frenchRepublicanCalendar.getDayOfYear());
        }
    };
    
    /* access modifiers changed from: private */
    public static final long ABOLITION = 0;
    private static final AttributeKey<FrenchRepublicanAlgorithm> ATTRIBUTE = null;
    /* access modifiers changed from: private */
    public static final long EPOCH = 0;
    /* access modifiers changed from: private */
    public static final ZonalOffset PARIS_OBSERVATORY = null;

    /* access modifiers changed from: package-private */
    public abstract long transform(FrenchRepublicanCalendar frenchRepublicanCalendar);

    /* access modifiers changed from: package-private */
    public abstract FrenchRepublicanCalendar transform(long j);

    static {
        PARIS_OBSERVATORY = ZonalOffset.atLongitude(OffsetSign.AHEAD_OF_UTC, 2, 20, 14.025d);
        ABOLITION = ((Long) PlainDate.of(1806, 1, 1).get(EpochDays.UTC)).longValue();
        EPOCH = ((Long) PlainDate.of(1792, 9, 22).get(EpochDays.UTC)).longValue();
        ATTRIBUTE = Attributes.createKey("FRENCH_REPUBLICAN_ALGORITHM", FrenchRepublicanAlgorithm.class);
    }

    public static AttributeKey<FrenchRepublicanAlgorithm> attribute() {
        return ATTRIBUTE;
    }

    public boolean isLeapYear(int i) {
        throw new AbstractMethodError();
    }

    /* access modifiers changed from: private */
    public static void check(long j) {
        if (j < -65478 || j > 373542) {
            throw new IllegalArgumentException("Out of range: " + j);
        }
    }
}
