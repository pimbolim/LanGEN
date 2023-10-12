package net.time4j.calendar;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumSet;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.base.MathUtils;
import net.time4j.calendar.astro.SolarTime;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.Temporal;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimePoint;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.CalendarType;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;

@CalendarType("hebrew")
public final class HebrewTime extends TimePoint<Unit, HebrewTime> implements Temporal<HebrewTime> {
    public static final ChronoElement<ClockCycle> CLOCK_CYCLE;
    @FormattableElement(format = "h")
    public static final StdCalendarElement<Integer, HebrewTime> CLOCK_HOUR;
    @FormattableElement(format = "H")
    public static final StdCalendarElement<Integer, HebrewTime> DIGITAL_HOUR;
    private static final TimeAxis<Unit, HebrewTime> ENGINE;
    private static final int HOUR12_INDEX = 0;
    private static final int HOUR23_INDEX = 1;
    private static final HebrewTime MAX;
    private static final HebrewTime MIN;
    private static final int PARTS_IN_HOUR = 1080;
    private static final int PART_INDEX = 2;
    @FormattableElement(dynamic = true, format = "P")
    public static final StdCalendarElement<Integer, HebrewTime> PART_OF_HOUR;
    private static final long serialVersionUID = -6206874394178665128L;
    /* access modifiers changed from: private */
    public final transient int hour23;
    /* access modifiers changed from: private */
    public final transient int part;

    public enum ClockCycle {
        NIGHT,
        DAY
    }

    /* access modifiers changed from: protected */
    public HebrewTime getContext() {
        return this;
    }

    static {
        Class<HebrewTime> cls = HebrewTime.class;
        StdEnumDateElement stdEnumDateElement = new StdEnumDateElement("CLOCK_CYCLE", cls, ClockCycle.class, 0);
        CLOCK_CYCLE = stdEnumDateElement;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("CLOCK_HOUR", HebrewTime.class, 1, 12, 'h', new UnitOperator(Unit.HOURS, true), new UnitOperator(Unit.HOURS, false));
        CLOCK_HOUR = stdIntegerDateElement;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DIGITAL_HOUR", HebrewTime.class, 0, 23, 'H', new UnitOperator(Unit.HOURS, true), new UnitOperator(Unit.HOURS, false));
        DIGITAL_HOUR = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("PART_OF_HOUR", HebrewTime.class, 0, 1079, 'P', new UnitOperator(Unit.HALAKIM, true), new UnitOperator(Unit.HALAKIM, false));
        PART_OF_HOUR = stdIntegerDateElement3;
        HebrewTime hebrewTime = new HebrewTime(0, 0);
        MIN = hebrewTime;
        HebrewTime hebrewTime2 = new HebrewTime(23, 1079);
        MAX = hebrewTime2;
        TimeAxis.Builder appendElement = TimeAxis.Builder.setUp(Unit.class, cls, new Merger(), hebrewTime, hebrewTime2).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) new CycleRule()).appendElement(stdIntegerDateElement, new IntegerElementRule(0), Unit.HOURS).appendElement(stdIntegerDateElement2, new IntegerElementRule(1), Unit.HOURS).appendElement(stdIntegerDateElement3, new IntegerElementRule(2), Unit.HALAKIM);
        registerUnits(appendElement);
        ENGINE = appendElement.build();
    }

    private HebrewTime(ClockCycle clockCycle, int i, int i2) {
        if (i < 1 || i > 12) {
            throw new IllegalArgumentException("CLOCK_HOUR out of range: " + i);
        } else if (i2 < 0 || i2 >= 1080) {
            throw new IllegalArgumentException("PART_OF_HOUR out of range: " + i2);
        } else {
            i = i == 12 ? 0 : i;
            this.hour23 = !clockCycle.equals(ClockCycle.NIGHT) ? i + 12 : i;
            this.part = i2;
        }
    }

    private HebrewTime(int i, int i2) {
        this.hour23 = i;
        this.part = i2;
    }

    public static HebrewTime ofDigital(int i, int i2) {
        if (i < 0 || i > 23) {
            throw new IllegalArgumentException("DIGITAL_HOUR out of range: " + i);
        } else if (i2 >= 0 && i2 < 1080) {
            return new HebrewTime(i, i2);
        } else {
            throw new IllegalArgumentException("PART_OF_HOUR out of range: " + i2);
        }
    }

    public static HebrewTime ofNight(int i, int i2) {
        return new HebrewTime(ClockCycle.NIGHT, i, i2);
    }

    public static HebrewTime ofDay(int i, int i2) {
        return new HebrewTime(ClockCycle.DAY, i, i2);
    }

    public static HebrewTime now(SolarTime solarTime) {
        return at(solarTime).apply(SystemClock.currentMoment());
    }

    public static HebrewTime nowInSystemTime() {
        return (HebrewTime) SystemClock.inLocalView().now(axis());
    }

    public static ChronoFunction<Moment, HebrewTime> at(final SolarTime solarTime) {
        return new ChronoFunction<Moment, HebrewTime>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: net.time4j.Moment} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x00e1  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.time4j.calendar.HebrewTime apply(net.time4j.Moment r12) {
                /*
                    r11 = this;
                    java.math.BigDecimal r0 = new java.math.BigDecimal
                    net.time4j.calendar.astro.SolarTime r1 = r1
                    double r1 = r1.getLongitude()
                    r0.<init>(r1)
                    net.time4j.tz.ZonalOffset r0 = net.time4j.tz.ZonalOffset.atLongitude(r0)
                    net.time4j.PlainTimestamp r0 = r12.toZonalTimestamp((net.time4j.tz.TZID) r0)
                    net.time4j.PlainDate r1 = r0.toDate()
                    net.time4j.calendar.astro.SolarTime r2 = r1
                    net.time4j.engine.ChronoFunction r2 = r2.sunset()
                    java.lang.Object r1 = r1.get(r2)
                    net.time4j.Moment r1 = (net.time4j.Moment) r1
                    r2 = 0
                    if (r1 == 0) goto L_0x00e7
                    boolean r3 = r12.isBefore((net.time4j.scale.UniversalTime) r1)
                    r4 = 1
                    if (r3 == 0) goto L_0x006a
                    net.time4j.PlainDate r3 = r0.toDate()
                    net.time4j.calendar.astro.SolarTime r6 = r1
                    net.time4j.engine.ChronoFunction r6 = r6.sunrise()
                    java.lang.Object r3 = r3.get(r6)
                    net.time4j.Moment r3 = (net.time4j.Moment) r3
                    if (r3 == 0) goto L_0x008a
                    boolean r6 = r12.isBefore((net.time4j.scale.UniversalTime) r3)
                    if (r6 == 0) goto L_0x0064
                    net.time4j.PlainDate r0 = r0.toDate()
                    net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.DAYS
                    net.time4j.engine.TimePoint r0 = r0.minus(r4, r1)
                    net.time4j.PlainDate r0 = (net.time4j.PlainDate) r0
                    net.time4j.calendar.astro.SolarTime r1 = r1
                    net.time4j.engine.ChronoFunction r1 = r1.sunset()
                    java.lang.Object r0 = r0.get(r1)
                    r1 = r0
                    net.time4j.Moment r1 = (net.time4j.Moment) r1
                    if (r1 == 0) goto L_0x008a
                    net.time4j.calendar.HebrewTime$ClockCycle r0 = net.time4j.calendar.HebrewTime.ClockCycle.NIGHT
                    goto L_0x008d
                L_0x0064:
                    net.time4j.calendar.HebrewTime$ClockCycle r0 = net.time4j.calendar.HebrewTime.ClockCycle.DAY
                    r10 = r3
                    r3 = r1
                    r1 = r10
                    goto L_0x008d
                L_0x006a:
                    net.time4j.PlainDate r0 = r0.toDate()
                    net.time4j.CalendarUnit r3 = net.time4j.CalendarUnit.DAYS
                    net.time4j.engine.TimePoint r0 = r0.plus(r4, r3)
                    net.time4j.PlainDate r0 = (net.time4j.PlainDate) r0
                    net.time4j.calendar.astro.SolarTime r3 = r1
                    net.time4j.engine.ChronoFunction r3 = r3.sunrise()
                    java.lang.Object r0 = r0.get(r3)
                    net.time4j.Moment r0 = (net.time4j.Moment) r0
                    if (r0 == 0) goto L_0x008a
                    net.time4j.calendar.HebrewTime$ClockCycle r3 = net.time4j.calendar.HebrewTime.ClockCycle.NIGHT
                    r10 = r3
                    r3 = r0
                    r0 = r10
                    goto L_0x008d
                L_0x008a:
                    r0 = r2
                    r1 = r0
                    r3 = r1
                L_0x008d:
                    if (r0 == 0) goto L_0x00e7
                    if (r1 == 0) goto L_0x00e7
                    if (r3 == 0) goto L_0x00e7
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.SECONDS
                    long r4 = r1.until(r3, r4)
                    r6 = 1000000000(0x3b9aca00, double:4.94065646E-315)
                    long r4 = r4 * r6
                    int r3 = r3.getNanosecond()
                    long r8 = (long) r3
                    long r4 = r4 + r8
                    int r3 = r1.getNanosecond()
                    long r8 = (long) r3
                    long r4 = r4 - r8
                    java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
                    long r8 = r1.until(r12, r3)
                    long r8 = r8 * r6
                    int r12 = r12.getNanosecond()
                    long r6 = (long) r12
                    long r8 = r8 + r6
                    int r12 = r1.getNanosecond()
                    long r6 = (long) r12
                    long r8 = r8 - r6
                    r6 = 4668350449676451840(0x40c9500000000000, double:12960.0)
                    double r8 = (double) r8
                    double r8 = r8 * r6
                    double r3 = (double) r4
                    double r8 = r8 / r3
                    r3 = 4652464705678344192(0x4090e00000000000, double:1080.0)
                    double r3 = r8 / r3
                    double r3 = java.lang.Math.floor(r3)
                    int r12 = (int) r3
                    int r1 = r12 * 1080
                    double r3 = (double) r1
                    double r8 = r8 - r3
                    double r3 = java.lang.Math.floor(r8)
                    int r1 = (int) r3
                    net.time4j.calendar.HebrewTime r3 = new net.time4j.calendar.HebrewTime
                    if (r12 != 0) goto L_0x00e3
                    r12 = 12
                L_0x00e3:
                    r3.<init>(r0, r12, r1)
                    return r3
                L_0x00e7:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.HebrewTime.AnonymousClass1.apply(net.time4j.Moment):net.time4j.calendar.HebrewTime");
            }
        };
    }

    public static ChronoFunction<Moment, HebrewTime> at(final TZID tzid) {
        return new ChronoFunction<Moment, HebrewTime>() {
            public HebrewTime apply(Moment moment) {
                PlainTime wallTime = moment.toZonalTimestamp(tzid).getWallTime();
                return new HebrewTime((wallTime.getHour() + 6) % 24, ((BigDecimal) wallTime.get(PlainTime.DECIMAL_HOUR)).subtract(new BigDecimal(wallTime.getHour())).multiply(new BigDecimal(1080)).intValue());
            }
        };
    }

    public boolean isNight() {
        return this.hour23 < 12;
    }

    public boolean isDay() {
        return this.hour23 >= 12;
    }

    public int getClockHour() {
        int i = this.hour23;
        if (isDay()) {
            i -= 12;
        }
        if (i == 0) {
            return 12;
        }
        return i;
    }

    public int getDigitalHour() {
        return this.hour23;
    }

    public int getPart() {
        return this.part;
    }

    public boolean isAfter(HebrewTime hebrewTime) {
        return getTimeOfDay() > hebrewTime.getTimeOfDay();
    }

    public boolean isBefore(HebrewTime hebrewTime) {
        return getTimeOfDay() < hebrewTime.getTimeOfDay();
    }

    public boolean isSimultaneous(HebrewTime hebrewTime) {
        return getTimeOfDay() == hebrewTime.getTimeOfDay();
    }

    public int compareTo(HebrewTime hebrewTime) {
        return getTimeOfDay() - hebrewTime.getTimeOfDay();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HebrewTime) || getTimeOfDay() != ((HebrewTime) obj).getTimeOfDay()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return getTimeOfDay();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hour23);
        sb.append('H');
        sb.append(this.part);
        sb.append('P');
        return sb.toString();
    }

    public Moment on(HebrewCalendar hebrewCalendar, SolarTime solarTime) {
        HebrewTime hebrewTime;
        Moment moment;
        Moment moment2;
        PlainDate plainDate = (PlainDate) hebrewCalendar.transform(PlainDate.class);
        if (isNight()) {
            moment2 = solarTime.sunset().apply(plainDate.minus(CalendarDays.ONE));
            moment = solarTime.sunrise().apply(plainDate);
            hebrewTime = this;
        } else {
            moment = solarTime.sunset().apply(plainDate);
            hebrewTime = (HebrewTime) minus(12, Unit.HOURS);
            moment2 = solarTime.sunrise().apply(plainDate);
        }
        if (moment2 == null || moment == null) {
            return null;
        }
        int until = (int) moment2.until(moment, TimeUnit.SECONDS);
        if (moment2.getNanosecond() > moment.getNanosecond()) {
            until--;
        }
        return (Moment) moment2.plus((long) Math.floor(((double) (hebrewTime.getTimeOfDay() * until)) / 12960.0d), TimeUnit.SECONDS);
    }

    public Moment on(HebrewCalendar hebrewCalendar, Timezone timezone) {
        return hebrewCalendar.at((PlainTime) PlainTime.of(18).with(PlainTime.DECIMAL_HOUR, new BigDecimal(this.part).setScale(15, RoundingMode.UNNECESSARY).divide(new BigDecimal(1080), RoundingMode.FLOOR).add(new BigDecimal((this.hour23 + 18) % 24)))).in(timezone, StartOfDay.EVENING);
    }

    public static TimeAxis<Unit, HebrewTime> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<Unit, HebrewTime> getChronology() {
        return ENGINE;
    }

    /* access modifiers changed from: private */
    public int getTimeOfDay() {
        return this.part + (this.hour23 * 1080);
    }

    private static void registerUnits(TimeAxis.Builder<Unit, HebrewTime> builder) {
        EnumSet<E> allOf = EnumSet.allOf(Unit.class);
        for (Unit unit : Unit.values()) {
            builder.appendUnit(unit, new ClockUnitRule(unit), unit.getLength(), allOf);
        }
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        HOURS(3600.0d),
        HALAKIM(3.3333333333333335d);
        
        private final transient double length;

        public boolean isCalendrical() {
            return false;
        }

        private Unit(double d) {
            this.length = d;
        }

        public double getLength() {
            return this.length;
        }

        public int between(HebrewTime hebrewTime, HebrewTime hebrewTime2) {
            return (int) hebrewTime.until(hebrewTime2, this);
        }
    }

    private static class ClockUnitRule implements UnitRule<HebrewTime> {
        private final Unit unit;

        private ClockUnitRule(Unit unit2) {
            this.unit = unit2;
        }

        public HebrewTime addTo(HebrewTime hebrewTime, long j) {
            int i;
            int i2;
            if (j == 0) {
                return hebrewTime;
            }
            int i3 = AnonymousClass3.$SwitchMap$net$time4j$calendar$HebrewTime$Unit[this.unit.ordinal()];
            if (i3 == 1) {
                int floorModulo = MathUtils.floorModulo(MathUtils.safeAdd((long) hebrewTime.hour23, j), 24);
                i2 = hebrewTime.part;
                i = floorModulo;
            } else if (i3 == 2) {
                long safeAdd = MathUtils.safeAdd((long) hebrewTime.part, j);
                i2 = MathUtils.floorModulo(safeAdd, 1080);
                i = MathUtils.floorModulo(MathUtils.safeAdd((long) hebrewTime.hour23, MathUtils.floorDivide(safeAdd, 1080)), 24);
            } else {
                throw new UnsupportedOperationException(this.unit.name());
            }
            return new HebrewTime(i, i2);
        }

        public long between(HebrewTime hebrewTime, HebrewTime hebrewTime2) {
            long access$800 = (long) (hebrewTime2.getTimeOfDay() - hebrewTime.getTimeOfDay());
            int i = AnonymousClass3.$SwitchMap$net$time4j$calendar$HebrewTime$Unit[this.unit.ordinal()];
            if (i == 1) {
                return access$800 / 1080;
            }
            if (i == 2) {
                return access$800;
            }
            throw new UnsupportedOperationException(this.unit.name());
        }
    }

    /* renamed from: net.time4j.calendar.HebrewTime$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$HebrewTime$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                net.time4j.calendar.HebrewTime$Unit[] r0 = net.time4j.calendar.HebrewTime.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$HebrewTime$Unit = r0
                net.time4j.calendar.HebrewTime$Unit r1 = net.time4j.calendar.HebrewTime.Unit.HOURS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$HebrewTime$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.HebrewTime$Unit r1 = net.time4j.calendar.HebrewTime.Unit.HALAKIM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.HebrewTime.AnonymousClass3.<clinit>():void");
        }
    }

    private static class UnitOperator implements ChronoOperator<HebrewTime> {
        private final boolean decrementing;
        private final Unit unit;

        private UnitOperator(Unit unit2, boolean z) {
            this.unit = unit2;
            this.decrementing = z;
        }

        public HebrewTime apply(HebrewTime hebrewTime) {
            return (HebrewTime) hebrewTime.plus(this.decrementing ? -1 : 1, this.unit);
        }
    }

    private static class CycleRule implements ElementRule<HebrewTime, ClockCycle> {
        public boolean isValid(HebrewTime hebrewTime, ClockCycle clockCycle) {
            return clockCycle != null;
        }

        private CycleRule() {
        }

        public ClockCycle getValue(HebrewTime hebrewTime) {
            return hebrewTime.hour23 < 12 ? ClockCycle.NIGHT : ClockCycle.DAY;
        }

        public HebrewTime withValue(HebrewTime hebrewTime, ClockCycle clockCycle, boolean z) {
            if (clockCycle != null) {
                return new HebrewTime(clockCycle, hebrewTime.getClockHour(), hebrewTime.getPart());
            }
            throw new IllegalArgumentException("Missing Hebrew cycle.");
        }

        public ClockCycle getMinimum(HebrewTime hebrewTime) {
            return ClockCycle.NIGHT;
        }

        public ClockCycle getMaximum(HebrewTime hebrewTime) {
            return ClockCycle.DAY;
        }

        public ChronoElement<?> getChildAtFloor(HebrewTime hebrewTime) {
            return HebrewTime.CLOCK_HOUR;
        }

        public ChronoElement<?> getChildAtCeiling(HebrewTime hebrewTime) {
            return HebrewTime.CLOCK_HOUR;
        }
    }

    private static class IntegerElementRule implements ElementRule<HebrewTime, Integer> {
        private final int index;

        IntegerElementRule(int i) {
            this.index = i;
        }

        public Integer getValue(HebrewTime hebrewTime) {
            int i = this.index;
            if (i == 0) {
                return Integer.valueOf(hebrewTime.getClockHour());
            }
            if (i == 1) {
                return Integer.valueOf(hebrewTime.hour23);
            }
            if (i == 2) {
                return Integer.valueOf(hebrewTime.part);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMinimum(HebrewTime hebrewTime) {
            int i = this.index;
            if (i == 0) {
                return 1;
            }
            if (i == 1 || i == 2) {
                return 0;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMaximum(HebrewTime hebrewTime) {
            int i = this.index;
            if (i == 0) {
                return 12;
            }
            if (i == 1) {
                return 23;
            }
            if (i == 2) {
                return 1079;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(HebrewTime hebrewTime, Integer num) {
            if (num != null && getMinimum(hebrewTime).compareTo(num) <= 0 && getMaximum(hebrewTime).compareTo(num) >= 0) {
                return true;
            }
            return false;
        }

        public HebrewTime withValue(HebrewTime hebrewTime, Integer num, boolean z) {
            if (num != null) {
                int intValue = num.intValue();
                int i = this.index;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            throw new UnsupportedOperationException("Unknown element index: " + this.index);
                        } else if (z) {
                            return (HebrewTime) hebrewTime.plus((long) MathUtils.safeSubtract(intValue, hebrewTime.part), Unit.HALAKIM);
                        } else {
                            return HebrewTime.ofDigital(hebrewTime.hour23, intValue);
                        }
                    } else if (z) {
                        return (HebrewTime) hebrewTime.plus((long) MathUtils.safeSubtract(intValue, hebrewTime.hour23), Unit.HOURS);
                    } else {
                        return HebrewTime.ofDigital(intValue, hebrewTime.part);
                    }
                } else if (z) {
                    return (HebrewTime) hebrewTime.plus((long) MathUtils.safeSubtract(intValue, hebrewTime.getClockHour()), Unit.HOURS);
                } else {
                    if (hebrewTime.isDay()) {
                        return HebrewTime.ofDay(intValue, hebrewTime.part);
                    }
                    return HebrewTime.ofNight(intValue, hebrewTime.part);
                }
            } else {
                throw new IllegalArgumentException("Missing element value.");
            }
        }

        public ChronoElement<?> getChildAtFloor(HebrewTime hebrewTime) {
            int i = this.index;
            if (i == 0 || i == 1) {
                return HebrewTime.PART_OF_HOUR;
            }
            return null;
        }

        public ChronoElement<?> getChildAtCeiling(HebrewTime hebrewTime) {
            return getChildAtFloor(hebrewTime);
        }
    }

    private static class Merger implements ChronoMerger<HebrewTime> {
        public int getDefaultPivotYear() {
            return 100;
        }

        public ChronoDisplay preformat(HebrewTime hebrewTime, AttributeQuery attributeQuery) {
            return hebrewTime;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.HebrewTime createFrom(net.time4j.base.TimeSource<?> r3, net.time4j.engine.AttributeQuery r4) {
            /*
                r2 = this;
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r0 = r4.contains(r0)
                if (r0 == 0) goto L_0x0011
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r4 = r4.get(r0)
                net.time4j.tz.TZID r4 = (net.time4j.tz.TZID) r4
                goto L_0x0029
            L_0x0011:
                net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r0 = net.time4j.format.Attributes.LENIENCY
                net.time4j.format.Leniency r1 = net.time4j.format.Leniency.SMART
                java.lang.Object r4 = r4.get(r0, r1)
                net.time4j.format.Leniency r4 = (net.time4j.format.Leniency) r4
                boolean r4 = r4.isLax()
                if (r4 == 0) goto L_0x003c
                net.time4j.tz.Timezone r4 = net.time4j.tz.Timezone.ofSystem()
                net.time4j.tz.TZID r4 = r4.getID()
            L_0x0029:
                net.time4j.engine.ChronoFunction r4 = net.time4j.calendar.HebrewTime.at((net.time4j.tz.TZID) r4)
                net.time4j.base.UnixTime r3 = r3.currentTime()
                net.time4j.Moment r3 = net.time4j.Moment.from(r3)
                java.lang.Object r3 = r4.apply(r3)
                net.time4j.calendar.HebrewTime r3 = (net.time4j.calendar.HebrewTime) r3
                return r3
            L_0x003c:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.HebrewTime.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.HebrewTime");
        }

        public HebrewTime createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            int i;
            if (chronoEntity.contains(HebrewTime.PART_OF_HOUR)) {
                i = chronoEntity.getInt(HebrewTime.PART_OF_HOUR);
                if (i < 0 || i >= 1080) {
                    ValidationElement validationElement = ValidationElement.ERROR_MESSAGE;
                    chronoEntity.with((ChronoElement<V>) validationElement, "PART_OF_HOUR out of range: " + i);
                    return null;
                }
            } else {
                i = 0;
            }
            if (chronoEntity.contains(HebrewTime.CLOCK_CYCLE) && chronoEntity.contains(HebrewTime.CLOCK_HOUR)) {
                ClockCycle clockCycle = (ClockCycle) chronoEntity.get((ChronoElement<V>) HebrewTime.CLOCK_CYCLE);
                int i2 = chronoEntity.getInt(HebrewTime.CLOCK_HOUR);
                if (i2 >= 1 && i2 <= 12) {
                    return new HebrewTime(clockCycle, i2, i);
                }
                ValidationElement validationElement2 = ValidationElement.ERROR_MESSAGE;
                chronoEntity.with((ChronoElement<V>) validationElement2, "CLOCK_HOUR out of range: " + i2);
                return null;
            } else if (chronoEntity.contains(HebrewTime.DIGITAL_HOUR)) {
                int i3 = chronoEntity.getInt(HebrewTime.DIGITAL_HOUR);
                if (i3 >= 0 && i3 <= 23) {
                    return new HebrewTime(i3, i);
                }
                ValidationElement validationElement3 = ValidationElement.ERROR_MESSAGE;
                chronoEntity.with((ChronoElement<V>) validationElement3, "DIGITAL_HOUR out of range: " + i3);
                return null;
            } else {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing cycle or hour of cycle.");
                return null;
            }
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            throw new UnsupportedOperationException("Localized format patterns are not available.");
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.EVENING;
        }
    }

    private static class SPX implements Externalizable {
        private static final int HEBREW_TIME = 13;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(13);
            writeHebrewTime(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 13) {
                this.obj = readHebrewTime(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeHebrewTime(ObjectOutput objectOutput) throws IOException {
            HebrewTime hebrewTime = (HebrewTime) this.obj;
            objectOutput.writeByte(hebrewTime.getDigitalHour());
            objectOutput.writeShort(hebrewTime.getPart());
        }

        private HebrewTime readHebrewTime(ObjectInput objectInput) throws IOException {
            return HebrewTime.ofDigital(objectInput.readByte(), objectInput.readShort());
        }
    }
}
