package net.time4j.calendar;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.Meridiem;
import net.time4j.PlainTime;
import net.time4j.ProportionalElement;
import net.time4j.WallTimeElement;
import net.time4j.ZonalElement;
import net.time4j.base.MathUtils;
import net.time4j.base.TimeSource;
import net.time4j.calendar.service.EthiopianExtension;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoMerger;
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
import net.time4j.format.Attributes;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayElement;
import net.time4j.format.LocalizedPatternSupport;

@CalendarType("ethiopic")
public final class EthiopianTime extends TimePoint<Unit, EthiopianTime> implements Temporal<EthiopianTime>, LocalizedPatternSupport {
    @FormattableElement(format = "a")
    public static final ChronoElement<Meridiem> AM_PM_OF_DAY;
    private static final int DIGITAL_HOUR_INDEX = 1;
    @FormattableElement(format = "H")
    public static final ChronoElement<Integer> DIGITAL_HOUR_OF_DAY;
    private static final TimeAxis<Unit, EthiopianTime> ENGINE;
    @FormattableElement(format = "h")
    public static final ChronoElement<Integer> ETHIOPIAN_HOUR;
    private static final int ETHIOPIAN_HOUR_INDEX = 0;
    public static final ChronoElement<PlainTime> ISO_TIME;
    private static final EthiopianTime MAX;
    private static final EthiopianTime MIN;
    private static final int MINUTE_INDEX = 2;
    @FormattableElement(format = "m")
    public static final ChronoElement<Integer> MINUTE_OF_HOUR;
    private static final int SECOND_INDEX = 3;
    @FormattableElement(format = "s")
    public static final ChronoElement<Integer> SECOND_OF_MINUTE;
    private static final long serialVersionUID = 3576122091324773241L;
    /* access modifiers changed from: private */
    public final transient int hour24;
    /* access modifiers changed from: private */
    public final transient int minute;
    /* access modifiers changed from: private */
    public final transient int second;

    /* access modifiers changed from: protected */
    public EthiopianTime getContext() {
        return this;
    }

    /* synthetic */ EthiopianTime(int i, int i2, int i3, AnonymousClass1 r4) {
        this(i, i2, i3);
    }

    static {
        WallTimeElement wallTimeElement = PlainTime.COMPONENT;
        ISO_TIME = wallTimeElement;
        ZonalElement<Meridiem> zonalElement = PlainTime.AM_PM_OF_DAY;
        AM_PM_OF_DAY = zonalElement;
        EthiopianHour ethiopianHour = EthiopianHour.ELEMENT;
        ETHIOPIAN_HOUR = ethiopianHour;
        ProportionalElement<Integer, PlainTime> proportionalElement = PlainTime.DIGITAL_HOUR_OF_DAY;
        DIGITAL_HOUR_OF_DAY = proportionalElement;
        ProportionalElement<Integer, PlainTime> proportionalElement2 = PlainTime.MINUTE_OF_HOUR;
        MINUTE_OF_HOUR = proportionalElement2;
        ProportionalElement<Integer, PlainTime> proportionalElement3 = PlainTime.SECOND_OF_MINUTE;
        SECOND_OF_MINUTE = proportionalElement3;
        EthiopianTime ethiopianTime = new EthiopianTime(6, 0, 0);
        MIN = ethiopianTime;
        EthiopianTime ethiopianTime2 = new EthiopianTime(5, 59, 59);
        MAX = ethiopianTime2;
        TimeAxis.Builder<U, PlainTime> appendElement = TimeAxis.Builder.setUp(Unit.class, EthiopianTime.class, new Merger((AnonymousClass1) null), ethiopianTime, ethiopianTime2).appendElement((ChronoElement) zonalElement, (ElementRule) new MeridiemRule((AnonymousClass1) null)).appendElement((ChronoElement) wallTimeElement, (ElementRule) new TimeRule((AnonymousClass1) null)).appendElement(ethiopianHour, new IntegerElementRule(0), Unit.HOURS).appendElement(proportionalElement, new IntegerElementRule(1), Unit.HOURS).appendElement(proportionalElement2, new IntegerElementRule(2), Unit.MINUTES).appendElement(proportionalElement3, new IntegerElementRule(3), Unit.SECONDS);
        registerUnits(appendElement);
        registerExtensions(appendElement);
        ENGINE = appendElement.build();
    }

    private EthiopianTime(int i, int i2, int i3) {
        if (i < 0 || i > 23) {
            throw new IllegalArgumentException("HOUR_OF_DAY out of range: " + i);
        } else if (i2 < 0 || i2 > 59) {
            throw new IllegalArgumentException("MINUTE_OF_HOUR out of range: " + i2);
        } else if (i3 < 0 || i3 > 59) {
            throw new IllegalArgumentException("SECOND_OF_MINUTE out of range: " + i3);
        } else {
            this.hour24 = i;
            this.minute = i2;
            this.second = i3;
        }
    }

    public static EthiopianTime ofDay(int i, int i2) {
        return of(false, i, i2, 0);
    }

    public static EthiopianTime ofDay(int i, int i2, int i3) {
        return of(false, i, i2, i3);
    }

    public static EthiopianTime ofNight(int i, int i2) {
        return of(true, i, i2, 0);
    }

    public static EthiopianTime ofNight(int i, int i2, int i3) {
        return of(true, i, i2, i3);
    }

    public static EthiopianTime nowInSystemTime() {
        return from(PlainTime.nowInSystemTime());
    }

    public boolean isDay() {
        int i = this.hour24;
        return i >= 6 && i < 18;
    }

    public boolean isNight() {
        return !isDay();
    }

    public int getHour() {
        int i = this.hour24 - 6;
        if (i < 0) {
            i += 12;
        } else if (i >= 12) {
            i -= 12;
        }
        if (i == 0) {
            return 12;
        }
        return i;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public boolean isAfter(EthiopianTime ethiopianTime) {
        return getTimeOfDay() > ethiopianTime.getTimeOfDay();
    }

    public boolean isBefore(EthiopianTime ethiopianTime) {
        return getTimeOfDay() < ethiopianTime.getTimeOfDay();
    }

    public boolean isSimultaneous(EthiopianTime ethiopianTime) {
        return getTimeOfDay() == ethiopianTime.getTimeOfDay();
    }

    public int compareTo(EthiopianTime ethiopianTime) {
        return getTimeOfDay() - ethiopianTime.getTimeOfDay();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EthiopianTime) || getTimeOfDay() != ((EthiopianTime) obj).getTimeOfDay()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return getTimeOfDay();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ethiopic-");
        sb.append(isDay() ? "day-" : "night-");
        sb.append(getHour());
        sb.append(AbstractJsonLexerKt.COLON);
        if (this.minute < 10) {
            sb.append('0');
        }
        sb.append(this.minute);
        sb.append(AbstractJsonLexerKt.COLON);
        if (this.second < 10) {
            sb.append('0');
        }
        sb.append(this.second);
        return sb.toString();
    }

    public PlainTime toISO() {
        return PlainTime.of(this.hour24, this.minute, this.second);
    }

    public static EthiopianTime from(PlainTime plainTime) {
        int hour = plainTime.getHour();
        if (hour == 24) {
            hour = 0;
        }
        return new EthiopianTime(hour, plainTime.getMinute(), plainTime.getSecond());
    }

    public static TimeAxis<Unit, EthiopianTime> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<Unit, EthiopianTime> getChronology() {
        return ENGINE;
    }

    private static EthiopianTime of(boolean z, int i, int i2, int i3) {
        if (i < 1 || i > 12) {
            throw new IllegalArgumentException("Hour out of range 1-12: " + i);
        }
        if (i == 12) {
            i = 0;
        }
        int i4 = i + 6;
        if (z && (i4 = i4 + 12) >= 24) {
            i4 -= 24;
        }
        return new EthiopianTime(i4, i2, i3);
    }

    /* access modifiers changed from: private */
    public int getTimeOfDay() {
        int i = this.second + (this.minute * 60);
        int i2 = this.hour24;
        if (i2 < 6) {
            i2 += 24;
        }
        return i + (i2 * NikonType2MakernoteDirectory.TAG_NIKON_SCAN);
    }

    private static void registerUnits(TimeAxis.Builder<Unit, EthiopianTime> builder) {
        EnumSet<E> allOf = EnumSet.allOf(Unit.class);
        for (Unit unit : Unit.values()) {
            builder.appendUnit(unit, new ClockUnitRule(unit, (AnonymousClass1) null), unit.getLength(), allOf);
        }
    }

    private static void registerExtensions(TimeAxis.Builder<Unit, EthiopianTime> builder) {
        builder.appendExtension((ChronoExtension) new EthiopianExtension());
        for (ChronoExtension next : PlainTime.axis().getExtensions()) {
            Set<ChronoElement<?>> elements = next.getElements(Locale.ROOT, Attributes.empty());
            if (elements.size() == 2) {
                for (ChronoElement<?> name : elements) {
                    if (name.name().endsWith("_DAY_PERIOD")) {
                        builder.appendExtension(next);
                        return;
                    }
                }
                continue;
            }
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
        MINUTES(60.0d),
        SECONDS(1.0d);
        
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

        public int between(EthiopianTime ethiopianTime, EthiopianTime ethiopianTime2) {
            return (int) ethiopianTime.until(ethiopianTime2, this);
        }
    }

    private static class ClockUnitRule implements UnitRule<EthiopianTime> {
        private final Unit unit;

        /* synthetic */ ClockUnitRule(Unit unit2, AnonymousClass1 r2) {
            this(unit2);
        }

        private ClockUnitRule(Unit unit2) {
            this.unit = unit2;
        }

        public EthiopianTime addTo(EthiopianTime ethiopianTime, long j) {
            long j2;
            if (j == 0) {
                return ethiopianTime;
            }
            int access$400 = ethiopianTime.minute;
            int access$500 = ethiopianTime.second;
            int i = AnonymousClass1.$SwitchMap$net$time4j$calendar$EthiopianTime$Unit[this.unit.ordinal()];
            if (i == 1) {
                j2 = MathUtils.safeAdd((long) ethiopianTime.hour24, j);
            } else if (i == 2) {
                long safeAdd = MathUtils.safeAdd((long) ethiopianTime.minute, j);
                j2 = MathUtils.safeAdd((long) ethiopianTime.hour24, MathUtils.floorDivide(safeAdd, 60));
                access$400 = MathUtils.floorModulo(safeAdd, 60);
            } else if (i == 3) {
                long safeAdd2 = MathUtils.safeAdd((long) ethiopianTime.second, j);
                long safeAdd3 = MathUtils.safeAdd((long) ethiopianTime.minute, MathUtils.floorDivide(safeAdd2, 60));
                j2 = MathUtils.safeAdd((long) ethiopianTime.hour24, MathUtils.floorDivide(safeAdd3, 60));
                access$400 = MathUtils.floorModulo(safeAdd3, 60);
                access$500 = MathUtils.floorModulo(safeAdd2, 60);
            } else {
                throw new UnsupportedOperationException(this.unit.name());
            }
            return new EthiopianTime(MathUtils.floorModulo(j2, 24), access$400, access$500, (AnonymousClass1) null);
        }

        public long between(EthiopianTime ethiopianTime, EthiopianTime ethiopianTime2) {
            long j;
            long access$800 = (long) (ethiopianTime2.getTimeOfDay() - ethiopianTime.getTimeOfDay());
            int i = AnonymousClass1.$SwitchMap$net$time4j$calendar$EthiopianTime$Unit[this.unit.ordinal()];
            if (i == 1) {
                j = 3600;
            } else if (i == 2) {
                j = 60;
            } else if (i == 3) {
                j = 1;
            } else {
                throw new UnsupportedOperationException(this.unit.name());
            }
            return access$800 / j;
        }
    }

    /* renamed from: net.time4j.calendar.EthiopianTime$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$EthiopianTime$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                net.time4j.calendar.EthiopianTime$Unit[] r0 = net.time4j.calendar.EthiopianTime.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$EthiopianTime$Unit = r0
                net.time4j.calendar.EthiopianTime$Unit r1 = net.time4j.calendar.EthiopianTime.Unit.HOURS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$EthiopianTime$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.EthiopianTime$Unit r1 = net.time4j.calendar.EthiopianTime.Unit.MINUTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$calendar$EthiopianTime$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.EthiopianTime$Unit r1 = net.time4j.calendar.EthiopianTime.Unit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.EthiopianTime.AnonymousClass1.<clinit>():void");
        }
    }

    private static class EthiopianHour extends DisplayElement<Integer> {
        static final EthiopianHour ELEMENT = new EthiopianHour();
        private static final long serialVersionUID = -2095959121446847268L;

        public char getSymbol() {
            return 'h';
        }

        public boolean isDateElement() {
            return false;
        }

        /* access modifiers changed from: protected */
        public boolean isSingleton() {
            return true;
        }

        public boolean isTimeElement() {
            return true;
        }

        private EthiopianHour() {
            super("ETHIOPIAN_HOUR");
        }

        public Class<Integer> getType() {
            return Integer.class;
        }

        public Integer getDefaultMinimum() {
            return 1;
        }

        public Integer getDefaultMaximum() {
            return 12;
        }

        /* access modifiers changed from: protected */
        public ChronoElement<?> getParent() {
            return PlainTime.CLOCK_HOUR_OF_AMPM;
        }

        /* access modifiers changed from: protected */
        public <T extends ChronoEntity<T>> ElementRule<T, Integer> derive(Chronology<T> chronology) {
            if (PlainTime.axis().equals(chronology)) {
                return new GeneralHourRule((AnonymousClass1) null);
            }
            return null;
        }

        private Object readResolve() {
            return ELEMENT;
        }
    }

    private static class TimeRule implements ElementRule<EthiopianTime, PlainTime> {
        public ChronoElement<?> getChildAtCeiling(EthiopianTime ethiopianTime) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(EthiopianTime ethiopianTime) {
            return null;
        }

        public boolean isValid(EthiopianTime ethiopianTime, PlainTime plainTime) {
            return plainTime != null;
        }

        private TimeRule() {
        }

        /* synthetic */ TimeRule(AnonymousClass1 r1) {
            this();
        }

        public PlainTime getValue(EthiopianTime ethiopianTime) {
            return ethiopianTime.toISO();
        }

        public PlainTime getMinimum(EthiopianTime ethiopianTime) {
            return PlainTime.midnightAtStartOfDay();
        }

        public PlainTime getMaximum(EthiopianTime ethiopianTime) {
            return PlainTime.of(23, 59, 59);
        }

        public EthiopianTime withValue(EthiopianTime ethiopianTime, PlainTime plainTime, boolean z) {
            if (plainTime != null) {
                return EthiopianTime.from(plainTime);
            }
            throw new IllegalArgumentException("Missing time value.");
        }
    }

    private static class MeridiemRule implements ElementRule<EthiopianTime, Meridiem> {
        public ChronoElement<?> getChildAtCeiling(EthiopianTime ethiopianTime) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(EthiopianTime ethiopianTime) {
            return null;
        }

        public boolean isValid(EthiopianTime ethiopianTime, Meridiem meridiem) {
            return meridiem != null;
        }

        private MeridiemRule() {
        }

        /* synthetic */ MeridiemRule(AnonymousClass1 r1) {
            this();
        }

        public Meridiem getValue(EthiopianTime ethiopianTime) {
            return ethiopianTime.hour24 < 12 ? Meridiem.AM : Meridiem.PM;
        }

        public EthiopianTime withValue(EthiopianTime ethiopianTime, Meridiem meridiem, boolean z) {
            int access$600 = ethiopianTime.hour24;
            if (meridiem != null) {
                if (meridiem == Meridiem.AM) {
                    if (access$600 >= 12) {
                        access$600 -= 12;
                    }
                } else if (meridiem == Meridiem.PM && access$600 < 12) {
                    access$600 += 12;
                }
                return new EthiopianTime(access$600, ethiopianTime.minute, ethiopianTime.second, (AnonymousClass1) null);
            }
            throw new IllegalArgumentException("Missing am/pm-value.");
        }

        public Meridiem getMinimum(EthiopianTime ethiopianTime) {
            return Meridiem.AM;
        }

        public Meridiem getMaximum(EthiopianTime ethiopianTime) {
            return Meridiem.PM;
        }
    }

    private static class GeneralHourRule<T extends ChronoEntity<T>> implements ElementRule<T, Integer> {
        public ChronoElement<?> getChildAtCeiling(T t) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(T t) {
            return null;
        }

        private GeneralHourRule() {
        }

        /* synthetic */ GeneralHourRule(AnonymousClass1 r1) {
            this();
        }

        public Integer getValue(T t) {
            return Integer.valueOf(EthiopianTime.from((PlainTime) t.get(PlainTime.COMPONENT)).getHour());
        }

        public Integer getMinimum(T t) {
            return 1;
        }

        public Integer getMaximum(T t) {
            return 12;
        }

        public boolean isValid(T t, Integer num) {
            return EthiopianTime.from((PlainTime) t.get(PlainTime.COMPONENT)).isValid(EthiopianTime.ETHIOPIAN_HOUR, num);
        }

        public T withValue(T t, Integer num, boolean z) {
            return t.with(PlainTime.COMPONENT, ((EthiopianTime) EthiopianTime.from((PlainTime) t.get(PlainTime.COMPONENT)).with(EthiopianTime.ETHIOPIAN_HOUR, num)).toISO());
        }
    }

    private static class IntegerElementRule implements ElementRule<EthiopianTime, Integer> {
        private final int index;

        public ChronoElement<?> getChildAtCeiling(EthiopianTime ethiopianTime) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(EthiopianTime ethiopianTime) {
            return null;
        }

        IntegerElementRule(int i) {
            this.index = i;
        }

        public Integer getValue(EthiopianTime ethiopianTime) {
            int i = this.index;
            if (i == 0) {
                return Integer.valueOf(ethiopianTime.getHour());
            }
            if (i == 1) {
                return Integer.valueOf(ethiopianTime.hour24);
            }
            if (i == 2) {
                return Integer.valueOf(ethiopianTime.minute);
            }
            if (i == 3) {
                return Integer.valueOf(ethiopianTime.second);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMinimum(EthiopianTime ethiopianTime) {
            int i = this.index;
            if (i == 0) {
                return 1;
            }
            if (i == 1 || i == 2 || i == 3) {
                return 0;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMaximum(EthiopianTime ethiopianTime) {
            int i = this.index;
            if (i == 0) {
                return 12;
            }
            if (i == 1) {
                return 23;
            }
            if (i == 2 || i == 3) {
                return 59;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(EthiopianTime ethiopianTime, Integer num) {
            if (num != null && getMinimum(ethiopianTime).compareTo(num) <= 0 && getMaximum(ethiopianTime).compareTo(num) >= 0) {
                return true;
            }
            return false;
        }

        public EthiopianTime withValue(EthiopianTime ethiopianTime, Integer num, boolean z) {
            if (num != null) {
                int intValue = num.intValue();
                int i = this.index;
                if (i != 0) {
                    if (i == 1) {
                        return new EthiopianTime(intValue, ethiopianTime.minute, ethiopianTime.second, (AnonymousClass1) null);
                    }
                    if (i == 2) {
                        return new EthiopianTime(ethiopianTime.hour24, intValue, ethiopianTime.second, (AnonymousClass1) null);
                    }
                    if (i == 3) {
                        return new EthiopianTime(ethiopianTime.hour24, ethiopianTime.minute, intValue, (AnonymousClass1) null);
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                } else if (ethiopianTime.isDay()) {
                    return EthiopianTime.ofDay(intValue, ethiopianTime.minute, ethiopianTime.second);
                } else {
                    return EthiopianTime.ofNight(intValue, ethiopianTime.minute, ethiopianTime.second);
                }
            } else {
                throw new IllegalArgumentException("Missing element value.");
            }
        }
    }

    private static class Merger implements ChronoMerger<EthiopianTime> {
        public int getDefaultPivotYear() {
            return 100;
        }

        public ChronoDisplay preformat(EthiopianTime ethiopianTime, AttributeQuery attributeQuery) {
            return ethiopianTime;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        /* synthetic */ Merger(AnonymousClass1 r1) {
            this();
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return displayStyle.getStyleValue() == 3 ? "h:mm a" : "h:mm:ss a";
        }

        public EthiopianTime createFrom(TimeSource<?> timeSource, AttributeQuery attributeQuery) {
            return EthiopianTime.from(PlainTime.axis().createFrom(timeSource, attributeQuery));
        }

        public EthiopianTime createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            PlainTime plainTime = (PlainTime) PlainTime.axis().createFrom((ChronoEntity) chronoEntity, attributeQuery, z, false);
            if (plainTime != null) {
                return EthiopianTime.from(plainTime);
            }
            return null;
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MORNING;
        }
    }

    private static class SPX implements Externalizable {
        private static final int ETHIOPIAN_TIME = 5;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(5);
            writeEthiopianTime(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 5) {
                this.obj = readEthiopianTime(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeEthiopianTime(ObjectOutput objectOutput) throws IOException {
            EthiopianTime ethiopianTime = (EthiopianTime) this.obj;
            objectOutput.writeInt((((Integer) ethiopianTime.get(EthiopianTime.DIGITAL_HOUR_OF_DAY)).intValue() * NikonType2MakernoteDirectory.TAG_NIKON_SCAN) + (ethiopianTime.getMinute() * 60) + ethiopianTime.getSecond());
        }

        private EthiopianTime readEthiopianTime(ObjectInput objectInput) throws IOException {
            int readInt = objectInput.readInt();
            int i = readInt % 60;
            int i2 = readInt / 60;
            return EthiopianTime.from(PlainTime.of(i2 / 60, i2 % 60, i));
        }
    }
}
