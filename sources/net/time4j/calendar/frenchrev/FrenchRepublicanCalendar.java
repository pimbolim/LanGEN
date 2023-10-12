package net.time4j.calendar.frenchrev;

import androidx.exifinterface.media.ExifInterface;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.GeneralTimestamp;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.MathUtils;
import net.time4j.calendar.StdCalendarElement;
import net.time4j.calendar.service.DualYearOfEraElement;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.IntElementRule;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.NumberSystem;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.tz.TZID;

@CalendarType("frenchrev")
public final class FrenchRepublicanCalendar extends Calendrical<Unit, FrenchRepublicanCalendar> {
    /* access modifiers changed from: private */
    public static final CalendarSystem<FrenchRepublicanCalendar> CALSYS;
    @FormattableElement(alt = "c", dynamic = true, format = "C")
    public static final ChronoElement<DayOfDecade> DAY_OF_DECADE;
    private static final DayOfDecadeAccess DAY_OF_DECADE_ACCESS;
    @FormattableElement(alt = "d", dynamic = true, format = "D")
    public static final StdCalendarElement<Integer, FrenchRepublicanCalendar> DAY_OF_MONTH;
    private static final int DAY_OF_MONTH_INDEX = 2;
    @FormattableElement(dynamic = true, format = "E")
    public static final StdCalendarElement<Weekday, FrenchRepublicanCalendar> DAY_OF_WEEK;
    public static final StdCalendarElement<Integer, FrenchRepublicanCalendar> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 3;
    private static final int DECADE_INDEX = 1;
    public static final StdCalendarElement<Integer, FrenchRepublicanCalendar> DECADE_OF_MONTH;
    /* access modifiers changed from: private */
    public static final FrenchRepublicanAlgorithm DEFAULT_ALGORITHM = FrenchRepublicanAlgorithm.EQUINOX;
    /* access modifiers changed from: private */
    public static final TimeAxis<Unit, FrenchRepublicanCalendar> ENGINE;
    @FormattableElement(dynamic = true, format = "G")
    public static final ChronoElement<FrenchRepublicanEra> ERA;
    static final int MAX_YEAR = 1202;
    @FormattableElement(alt = "m", dynamic = true, format = "M")
    public static final StdCalendarElement<FrenchRepublicanMonth, FrenchRepublicanCalendar> MONTH_OF_YEAR;
    @FormattableElement(alt = "s", dynamic = true, format = "S")
    public static final ChronoElement<Sansculottides> SANSCULOTTIDES;
    private static final SansculottidesAccess SANSCULOTTIDES_ACCESS;
    private static final int YEAR_INDEX = 0;
    @FormattableElement(alt = "y", dynamic = true, format = "Y")
    public static final StdCalendarElement<Integer, FrenchRepublicanCalendar> YEAR_OF_ERA;
    private static final long serialVersionUID = -6054794927532842783L;
    /* access modifiers changed from: private */
    public final transient int fdoy;
    /* access modifiers changed from: private */
    public final transient int fyear;

    public static boolean isValid(int i, int i2, int i3) {
        return i >= 1 && i <= MAX_YEAR && i2 >= 1 && i2 <= 12 && i3 >= 1 && i3 <= 30;
    }

    /* access modifiers changed from: protected */
    public FrenchRepublicanCalendar getContext() {
        return this;
    }

    static {
        Class<FrenchRepublicanCalendar> cls = FrenchRepublicanCalendar.class;
        StdEnumDateElement stdEnumDateElement = new StdEnumDateElement("ERA", cls, FrenchRepublicanEra.class, 'G');
        ERA = stdEnumDateElement;
        YearOfEraElement yearOfEraElement = new YearOfEraElement((AnonymousClass1) null);
        YEAR_OF_ERA = yearOfEraElement;
        SansculottidesAccess sansculottidesAccess = new SansculottidesAccess();
        SANSCULOTTIDES_ACCESS = sansculottidesAccess;
        DayOfDecadeAccess dayOfDecadeAccess = new DayOfDecadeAccess();
        DAY_OF_DECADE_ACCESS = dayOfDecadeAccess;
        SANSCULOTTIDES = sansculottidesAccess;
        StdEnumDateElement stdEnumDateElement2 = new StdEnumDateElement("MONTH_OF_YEAR", cls, FrenchRepublicanMonth.class, 'M');
        MONTH_OF_YEAR = stdEnumDateElement2;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("DECADE_OF_MONTH", FrenchRepublicanCalendar.class, 1, 3, 0, (ChronoOperator) null, (ChronoOperator) null);
        DECADE_OF_MONTH = stdIntegerDateElement;
        DAY_OF_DECADE = dayOfDecadeAccess;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DAY_OF_MONTH", FrenchRepublicanCalendar.class, 1, 30, 'D');
        DAY_OF_MONTH = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_YEAR", FrenchRepublicanCalendar.class, 1, 365, 0);
        DAY_OF_YEAR = stdIntegerDateElement3;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        Transformer transformer = new Transformer((AnonymousClass1) null);
        CALSYS = transformer;
        ENGINE = TimeAxis.Builder.setUp(Unit.class, cls, new Merger((AnonymousClass1) null), transformer).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) new EraRule((AnonymousClass1) null)).appendElement(yearOfEraElement, new IntegerRule(0), Unit.YEARS).appendElement((ChronoElement) sansculottidesAccess, (ElementRule) sansculottidesAccess).appendElement(stdEnumDateElement2, new MonthRule((AnonymousClass1) null), Unit.MONTHS).appendElement(stdIntegerDateElement, new IntegerRule(1), Unit.DECADES).appendElement(stdIntegerDateElement2, new IntegerRule(2), Unit.DAYS).appendElement(stdIntegerDateElement3, new IntegerRule(3), Unit.DAYS).appendElement(stdWeekdayElement, new WeekdayRule((AnonymousClass1) null), Unit.DAYS).appendElement((ChronoElement) dayOfDecadeAccess, (ElementRule) dayOfDecadeAccess).appendUnit(Unit.YEARS, new FUnitRule(Unit.YEARS), Unit.YEARS.getLength()).appendUnit(Unit.MONTHS, new FUnitRule(Unit.MONTHS), Unit.MONTHS.getLength()).appendUnit(Unit.DECADES, new FUnitRule(Unit.DECADES), Unit.DECADES.getLength()).appendUnit(Unit.WEEKS, new FUnitRule(Unit.WEEKS), Unit.WEEKS.getLength(), Collections.singleton(Unit.DAYS)).appendUnit(Unit.DAYS, new FUnitRule(Unit.DAYS), Unit.DAYS.getLength(), Collections.singleton(Unit.WEEKS)).build();
    }

    FrenchRepublicanCalendar(int i, int i2) {
        this.fyear = i;
        this.fdoy = i2;
    }

    public static FrenchRepublicanCalendar of(int i, FrenchRepublicanMonth frenchRepublicanMonth, int i2) {
        return of(i, frenchRepublicanMonth.getValue(), i2);
    }

    public static FrenchRepublicanCalendar of(int i, int i2, int i3) {
        if (i >= 1 && i <= MAX_YEAR && i2 >= 1 && i2 <= 12 && i3 >= 1 && i3 <= 30) {
            return new FrenchRepublicanCalendar(i, ((i2 - 1) * 30) + i3);
        }
        throw new IllegalArgumentException("Invalid French republican date: year=" + i + ", month=" + i2 + ", day=" + i3);
    }

    public static FrenchRepublicanCalendar of(int i, Sansculottides sansculottides) {
        if (i < 1 || i > MAX_YEAR) {
            throw new IllegalArgumentException("Year out of range: " + i);
        } else if (sansculottides != Sansculottides.LEAP_DAY || isLeapYear(i)) {
            return new FrenchRepublicanCalendar(i, sansculottides.getValue() + 360);
        } else {
            throw new IllegalArgumentException("Day of Revolution only exists in leap years: " + i);
        }
    }

    public static FrenchRepublicanCalendar nowInSystemTime() {
        return (FrenchRepublicanCalendar) SystemClock.inLocalView().now(axis());
    }

    public FrenchRepublicanEra getEra() {
        return FrenchRepublicanEra.REPUBLICAN;
    }

    public int getYear() {
        return this.fyear;
    }

    public FrenchRepublicanMonth getMonth() {
        int i = this.fdoy;
        if (i <= 360) {
            return FrenchRepublicanMonth.valueOf(((i - 1) / 30) + 1);
        }
        throw new ChronoException("Complementary days (sansculottides) do not represent any month: " + toString());
    }

    public int getDecade() {
        int i = this.fdoy;
        if (i <= 360) {
            return (((i - 1) % 30) / 10) + 1;
        }
        throw new ChronoException("Complementary days (sansculottides) do not represent any decade: " + toString());
    }

    public int getDayOfMonth() {
        int i = this.fdoy;
        if (i <= 360) {
            return ((i - 1) % 30) + 1;
        }
        throw new ChronoException("Complementary days (sansculottides) are not part of any month: " + toString());
    }

    public DayOfDecade getDayOfDecade() {
        if (!hasSansculottides()) {
            return DayOfDecade.valueOf(((this.fdoy - 1) % 10) + 1);
        }
        throw new ChronoException("Day of decade does not exist on sansculottides: " + toString());
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(CALSYS.transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return this.fdoy;
    }

    public Sansculottides getSansculottides() {
        int i = this.fdoy;
        if (i > 360) {
            return Sansculottides.valueOf(i - 360);
        }
        throw new ChronoException("Not a sansculottides day: " + toString());
    }

    public boolean hasSansculottides() {
        return this.fdoy > 360;
    }

    public boolean hasMonth() {
        return this.fdoy <= 360;
    }

    public boolean isLeapYear() {
        return isLeapYear(this.fyear);
    }

    public static boolean isLeapYear(int i) {
        return DEFAULT_ALGORITHM.isLeapYear(i);
    }

    public Date getDate(FrenchRepublicanAlgorithm frenchRepublicanAlgorithm) {
        FrenchRepublicanAlgorithm frenchRepublicanAlgorithm2 = DEFAULT_ALGORITHM;
        if (frenchRepublicanAlgorithm == frenchRepublicanAlgorithm2) {
            return new Date(this, frenchRepublicanAlgorithm2, (AnonymousClass1) null);
        }
        return new Date(frenchRepublicanAlgorithm.transform(frenchRepublicanAlgorithm2.transform(this)), frenchRepublicanAlgorithm, (AnonymousClass1) null);
    }

    public GeneralTimestamp<FrenchRepublicanCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<FrenchRepublicanCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public FrenchRepublicanCalendar withEndOfFranciade() {
        int i = this.fyear;
        while (!isLeapYear(i)) {
            i++;
        }
        return new FrenchRepublicanCalendar(i, 366);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrenchRepublicanCalendar)) {
            return false;
        }
        FrenchRepublicanCalendar frenchRepublicanCalendar = (FrenchRepublicanCalendar) obj;
        if (this.fyear == frenchRepublicanCalendar.fyear && this.fdoy == frenchRepublicanCalendar.fdoy) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.fdoy * 17) + (this.fyear * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("French-Republic-");
        sb.append(NumberSystem.ROMAN.toNumeral(this.fyear));
        sb.append(SignatureVisitor.SUPER);
        if (this.fdoy > 360) {
            sb.append("Sansculottides-");
            sb.append(String.valueOf(this.fdoy - 360));
        } else {
            int value = getMonth().getValue();
            if (value < 10) {
                sb.append('0');
            }
            sb.append(value);
            sb.append(SignatureVisitor.SUPER);
            int dayOfMonth = getDayOfMonth();
            if (dayOfMonth < 10) {
                sb.append('0');
            }
            sb.append(dayOfMonth);
        }
        return sb.toString();
    }

    public boolean contains(ChronoElement<?> chronoElement) {
        if (chronoElement == MONTH_OF_YEAR || chronoElement == DECADE_OF_MONTH || chronoElement == DAY_OF_DECADE || chronoElement == DAY_OF_MONTH) {
            return hasMonth();
        }
        if (chronoElement == SANSCULOTTIDES) {
            return hasSansculottides();
        }
        if (getRegisteredElements().contains(chronoElement)) {
            return true;
        }
        return isAccessible(this, chronoElement);
    }

    public <V> boolean isValid(ChronoElement<V> chronoElement, V v) {
        if (chronoElement == MONTH_OF_YEAR) {
            return v != null;
        }
        if (chronoElement == SANSCULOTTIDES) {
            return SANSCULOTTIDES_ACCESS.isValid(this, Sansculottides.class.cast(v));
        }
        return super.isValid(chronoElement, v);
    }

    public static TimeAxis<Unit, FrenchRepublicanCalendar> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<Unit, FrenchRepublicanCalendar> getChronology() {
        return ENGINE;
    }

    /* access modifiers changed from: private */
    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Weekday.SUNDAY, 1, Weekday.SUNDAY, Weekday.SUNDAY);
    }

    private static <V> boolean isAccessible(FrenchRepublicanCalendar frenchRepublicanCalendar, ChronoElement<V> chronoElement) {
        try {
            return frenchRepublicanCalendar.isValid(chronoElement, frenchRepublicanCalendar.get(chronoElement));
        } catch (ChronoException unused) {
            return false;
        }
    }

    private Object writeReplace() {
        return new SPX(this, 18);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        YEARS(3.1556941113599997E7d),
        MONTHS(2592000.0d),
        DECADES(864000.0d),
        WEEKS(604800.0d),
        DAYS(86400.0d);
        
        private final transient double length;

        public boolean isCalendrical() {
            return true;
        }

        private Unit(double d) {
            this.length = d;
        }

        public double getLength() {
            return this.length;
        }

        public long between(FrenchRepublicanCalendar frenchRepublicanCalendar, FrenchRepublicanCalendar frenchRepublicanCalendar2) {
            return frenchRepublicanCalendar.until(frenchRepublicanCalendar2, this);
        }
    }

    public static final class Date implements ChronoDisplay {
        private final FrenchRepublicanAlgorithm algorithm;
        private final FrenchRepublicanCalendar delegate;

        public boolean hasTimezone() {
            return false;
        }

        /* synthetic */ Date(FrenchRepublicanCalendar frenchRepublicanCalendar, FrenchRepublicanAlgorithm frenchRepublicanAlgorithm, AnonymousClass1 r3) {
            this(frenchRepublicanCalendar, frenchRepublicanAlgorithm);
        }

        private Date(FrenchRepublicanCalendar frenchRepublicanCalendar, FrenchRepublicanAlgorithm frenchRepublicanAlgorithm) {
            this.delegate = frenchRepublicanCalendar;
            this.algorithm = frenchRepublicanAlgorithm;
        }

        public boolean contains(ChronoElement<?> chronoElement) {
            return FrenchRepublicanCalendar.ENGINE.isRegistered(chronoElement);
        }

        public <V> V get(ChronoElement<V> chronoElement) {
            if (chronoElement == FrenchRepublicanCalendar.DAY_OF_WEEK) {
                return chronoElement.getType().cast(Weekday.valueOf(MathUtils.floorModulo(this.algorithm.transform(this.delegate) + 5, 7) + 1));
            } else if (chronoElement instanceof EpochDays) {
                return chronoElement.getType().cast(Long.valueOf(EpochDays.class.cast(chronoElement).transform(this.algorithm.transform(this.delegate), EpochDays.UTC)));
            } else if (FrenchRepublicanCalendar.ENGINE.isRegistered(chronoElement)) {
                return this.delegate.get(chronoElement);
            } else {
                throw new ChronoException("French republican dates only support registered elements.");
            }
        }

        public int getInt(ChronoElement<Integer> chronoElement) {
            if (FrenchRepublicanCalendar.ENGINE.isRegistered(chronoElement)) {
                return this.delegate.getInt(chronoElement);
            }
            return Integer.MIN_VALUE;
        }

        public <V> V getMinimum(ChronoElement<V> chronoElement) {
            if (FrenchRepublicanCalendar.ENGINE.isRegistered(chronoElement)) {
                return this.delegate.getMinimum(chronoElement);
            }
            throw new ChronoException("French republican dates only support registered elements.");
        }

        public <V> V getMaximum(ChronoElement<V> chronoElement) {
            if (FrenchRepublicanCalendar.ENGINE.isRegistered(chronoElement)) {
                return this.delegate.getMaximum(chronoElement);
            }
            throw new ChronoException("French republican dates only support registered elements.");
        }

        public TZID getTimezone() {
            throw new ChronoException("Timezone not available.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Date)) {
                return false;
            }
            Date date = (Date) obj;
            if (this.algorithm != date.algorithm) {
                return false;
            }
            return this.delegate.equals(date.delegate);
        }

        public int hashCode() {
            return (this.delegate.hashCode() * 7) + (this.algorithm.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.delegate);
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            sb.append(this.algorithm);
            sb.append(AbstractJsonLexerKt.END_LIST);
            return sb.toString();
        }
    }

    private static class Transformer implements CalendarSystem<FrenchRepublicanCalendar> {
        private Transformer() {
        }

        /* synthetic */ Transformer(AnonymousClass1 r1) {
            this();
        }

        public FrenchRepublicanCalendar transform(long j) {
            return FrenchRepublicanCalendar.DEFAULT_ALGORITHM.transform(j);
        }

        public long transform(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return FrenchRepublicanCalendar.DEFAULT_ALGORITHM.transform(frenchRepublicanCalendar);
        }

        public long getMinimumSinceUTC() {
            return transform(new FrenchRepublicanCalendar(1, 1));
        }

        public long getMaximumSinceUTC() {
            return transform(new FrenchRepublicanCalendar(FrenchRepublicanCalendar.MAX_YEAR, 366));
        }

        public List<CalendarEra> getEras() {
            return Collections.singletonList(FrenchRepublicanEra.REPUBLICAN);
        }
    }

    private static class YearOfEraElement extends DualYearOfEraElement<FrenchRepublicanCalendar> {
        private static final long serialVersionUID = 7337125729623271040L;

        /* synthetic */ YearOfEraElement(AnonymousClass1 r1) {
            this();
        }

        private YearOfEraElement() {
            super(FrenchRepublicanCalendar.class, 1, FrenchRepublicanCalendar.MAX_YEAR, 'Y');
        }

        /* access modifiers changed from: protected */
        public NumberSystem getNumberSystem(AttributeQuery attributeQuery) {
            if (!((String) attributeQuery.get(Attributes.FORMAT_PATTERN, "")).contains("Y") || !((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)).getLanguage().equals("fr")) {
                return (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ROMAN);
            }
            return NumberSystem.ROMAN;
        }
    }

    private static class IntegerRule implements IntElementRule<FrenchRepublicanCalendar> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public int getInt(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            int i = this.index;
            if (i == 0) {
                return frenchRepublicanCalendar.fyear;
            }
            if (i == 1) {
                return frenchRepublicanCalendar.getDecade();
            }
            if (i == 2) {
                return frenchRepublicanCalendar.getDayOfMonth();
            }
            if (i == 3) {
                return frenchRepublicanCalendar.fdoy;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(FrenchRepublicanCalendar frenchRepublicanCalendar, int i) {
            int i2 = this.index;
            if ((i2 == 2 || i2 == 1) && frenchRepublicanCalendar.hasSansculottides()) {
                return false;
            }
            int min = getMin(frenchRepublicanCalendar);
            int max = getMax(frenchRepublicanCalendar);
            if (min > i || max < i) {
                return false;
            }
            return true;
        }

        public FrenchRepublicanCalendar withValue(FrenchRepublicanCalendar frenchRepublicanCalendar, int i, boolean z) {
            if (this.index == 2 && frenchRepublicanCalendar.hasSansculottides()) {
                throw new IllegalArgumentException("Day of month not defined on sansculottides: " + i);
            } else if (this.index == 1 && frenchRepublicanCalendar.hasSansculottides()) {
                throw new IllegalArgumentException("Decade of month not defined on sansculottides: " + i);
            } else if (isValid(frenchRepublicanCalendar, i)) {
                int i2 = this.index;
                if (i2 == 0) {
                    return new FrenchRepublicanCalendar(i, Math.min(frenchRepublicanCalendar.fdoy, FrenchRepublicanCalendar.DEFAULT_ALGORITHM.isLeapYear(i) ? 366 : 365));
                } else if (i2 == 1) {
                    return FrenchRepublicanCalendar.of(frenchRepublicanCalendar.fyear, frenchRepublicanCalendar.getMonth(), ((i - 1) * 10) + ((frenchRepublicanCalendar.getDayOfMonth() - 1) % 10) + 1);
                } else if (i2 == 2) {
                    return FrenchRepublicanCalendar.of(frenchRepublicanCalendar.fyear, frenchRepublicanCalendar.getMonth(), i);
                } else {
                    if (i2 == 3) {
                        return new FrenchRepublicanCalendar(frenchRepublicanCalendar.fyear, i);
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            } else {
                throw new IllegalArgumentException("Out of range: " + i);
            }
        }

        public Integer getValue(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return Integer.valueOf(getInt(frenchRepublicanCalendar));
        }

        public Integer getMinimum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return Integer.valueOf(getMin(frenchRepublicanCalendar));
        }

        public Integer getMaximum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return Integer.valueOf(getMax(frenchRepublicanCalendar));
        }

        public boolean isValid(FrenchRepublicanCalendar frenchRepublicanCalendar, Integer num) {
            return num != null && isValid(frenchRepublicanCalendar, num.intValue());
        }

        public FrenchRepublicanCalendar withValue(FrenchRepublicanCalendar frenchRepublicanCalendar, Integer num, boolean z) {
            if (num != null) {
                return withValue(frenchRepublicanCalendar, num.intValue(), z);
            }
            throw new IllegalArgumentException("Missing new value.");
        }

        public ChronoElement<?> getChildAtFloor(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            int i = this.index;
            if (i == 0) {
                return FrenchRepublicanCalendar.MONTH_OF_YEAR;
            }
            if (i == 1) {
                return FrenchRepublicanCalendar.DAY_OF_DECADE;
            }
            return null;
        }

        public ChronoElement<?> getChildAtCeiling(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            int i = this.index;
            if (i == 0) {
                return FrenchRepublicanCalendar.SANSCULOTTIDES;
            }
            if (i == 1) {
                return FrenchRepublicanCalendar.DAY_OF_DECADE;
            }
            return null;
        }

        private int getMin(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            int i = this.index;
            if (i != 0) {
                if (i == 1 || i == 2) {
                    if (!frenchRepublicanCalendar.hasSansculottides()) {
                        return 1;
                    }
                    throw new ChronoException("Complementary days (sansculottides) are not part of any month or decade: " + frenchRepublicanCalendar);
                } else if (i != 3) {
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            }
            return 1;
        }

        private int getMax(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            int i = this.index;
            if (i == 0) {
                return FrenchRepublicanCalendar.MAX_YEAR;
            }
            if (i == 1 || i == 2) {
                if (frenchRepublicanCalendar.hasSansculottides()) {
                    throw new ChronoException("Complementary days (sansculottides) are not part of any month: " + frenchRepublicanCalendar);
                } else if (this.index == 2) {
                    return 30;
                } else {
                    return 3;
                }
            } else if (i == 3) {
                return FrenchRepublicanCalendar.DEFAULT_ALGORITHM.isLeapYear(frenchRepublicanCalendar.fyear) ? 366 : 365;
            } else {
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
        }
    }

    private static class MonthRule implements ElementRule<FrenchRepublicanCalendar, FrenchRepublicanMonth> {
        public boolean isValid(FrenchRepublicanCalendar frenchRepublicanCalendar, FrenchRepublicanMonth frenchRepublicanMonth) {
            return frenchRepublicanMonth != null;
        }

        private MonthRule() {
        }

        /* synthetic */ MonthRule(AnonymousClass1 r1) {
            this();
        }

        public FrenchRepublicanMonth getValue(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return frenchRepublicanCalendar.getMonth();
        }

        public FrenchRepublicanMonth getMinimum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return FrenchRepublicanMonth.VENDEMIAIRE;
        }

        public FrenchRepublicanMonth getMaximum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return FrenchRepublicanMonth.FRUCTIDOR;
        }

        public FrenchRepublicanCalendar withValue(FrenchRepublicanCalendar frenchRepublicanCalendar, FrenchRepublicanMonth frenchRepublicanMonth, boolean z) {
            if (frenchRepublicanMonth == null) {
                throw new IllegalArgumentException("Missing republican month.");
            } else if (frenchRepublicanCalendar.hasSansculottides()) {
                return FrenchRepublicanCalendar.of(frenchRepublicanCalendar.fyear, frenchRepublicanMonth, 30);
            } else {
                return FrenchRepublicanCalendar.of(frenchRepublicanCalendar.fyear, frenchRepublicanMonth, frenchRepublicanCalendar.getDayOfMonth());
            }
        }

        public ChronoElement<?> getChildAtFloor(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return FrenchRepublicanCalendar.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return FrenchRepublicanCalendar.DAY_OF_MONTH;
        }
    }

    private static class EraRule implements ElementRule<FrenchRepublicanCalendar, FrenchRepublicanEra> {
        public boolean isValid(FrenchRepublicanCalendar frenchRepublicanCalendar, FrenchRepublicanEra frenchRepublicanEra) {
            return frenchRepublicanEra != null;
        }

        private EraRule() {
        }

        /* synthetic */ EraRule(AnonymousClass1 r1) {
            this();
        }

        public FrenchRepublicanEra getValue(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return FrenchRepublicanEra.REPUBLICAN;
        }

        public FrenchRepublicanEra getMinimum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return FrenchRepublicanEra.REPUBLICAN;
        }

        public FrenchRepublicanEra getMaximum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return FrenchRepublicanEra.REPUBLICAN;
        }

        public FrenchRepublicanCalendar withValue(FrenchRepublicanCalendar frenchRepublicanCalendar, FrenchRepublicanEra frenchRepublicanEra, boolean z) {
            if (frenchRepublicanEra != null) {
                return frenchRepublicanCalendar;
            }
            throw new IllegalArgumentException("Missing era value.");
        }

        public ChronoElement<?> getChildAtFloor(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return FrenchRepublicanCalendar.YEAR_OF_ERA;
        }

        public ChronoElement<?> getChildAtCeiling(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return FrenchRepublicanCalendar.YEAR_OF_ERA;
        }
    }

    private static class DayOfDecadeAccess extends BasicElement<DayOfDecade> implements TextElement<DayOfDecade>, ElementRule<FrenchRepublicanCalendar, DayOfDecade> {
        private static final long serialVersionUID = -8211850819064695450L;

        public ChronoElement<?> getChildAtCeiling(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return null;
        }

        public char getSymbol() {
            return 'C';
        }

        public boolean isDateElement() {
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean isSingleton() {
            return true;
        }

        public boolean isTimeElement() {
            return false;
        }

        DayOfDecadeAccess() {
            super("DAY_OF_DECADE");
        }

        public DayOfDecade getValue(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return frenchRepublicanCalendar.getDayOfDecade();
        }

        public DayOfDecade getMinimum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            if (!frenchRepublicanCalendar.hasSansculottides()) {
                return DayOfDecade.PRIMIDI;
            }
            throw new ChronoException("Cannot get minimum for day of decade on sansculottides: " + frenchRepublicanCalendar);
        }

        public DayOfDecade getMaximum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            if (!frenchRepublicanCalendar.hasSansculottides()) {
                return DayOfDecade.DECADI;
            }
            throw new ChronoException("Cannot get maximum for day of decade on sansculottides: " + frenchRepublicanCalendar);
        }

        public boolean isValid(FrenchRepublicanCalendar frenchRepublicanCalendar, DayOfDecade dayOfDecade) {
            return dayOfDecade != null && !frenchRepublicanCalendar.hasSansculottides();
        }

        public FrenchRepublicanCalendar withValue(FrenchRepublicanCalendar frenchRepublicanCalendar, DayOfDecade dayOfDecade, boolean z) {
            if (dayOfDecade == null) {
                throw new IllegalArgumentException("Missing day of decade.");
            } else if (!frenchRepublicanCalendar.hasSansculottides()) {
                int value = dayOfDecade.getValue() - (((frenchRepublicanCalendar.fdoy - 1) % 10) + 1);
                if (value == 0) {
                    return frenchRepublicanCalendar;
                }
                return new FrenchRepublicanCalendar(frenchRepublicanCalendar.fyear, frenchRepublicanCalendar.fdoy + value);
            } else {
                throw new IllegalArgumentException("Cannot set day of decade on sansculottides.");
            }
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            appendable.append(accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), attributeQuery).print((DayOfDecade) chronoDisplay.get(this)));
        }

        public DayOfDecade parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            return (DayOfDecade) accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), attributeQuery).parse(charSequence, parsePosition, getType(), attributeQuery);
        }

        public Class<DayOfDecade> getType() {
            return DayOfDecade.class;
        }

        public DayOfDecade getDefaultMinimum() {
            return DayOfDecade.PRIMIDI;
        }

        public DayOfDecade getDefaultMaximum() {
            return DayOfDecade.DECADI;
        }

        public String getDisplayName(Locale locale) {
            String str = CalendarText.getInstance("frenchrev", locale).getTextForms().get("L_dayofdecade");
            return str == null ? name() : str;
        }

        private TextAccessor accessor(Locale locale, AttributeQuery attributeQuery) {
            return CalendarText.getInstance("frenchrev", locale).getTextForms(name(), getType(), ((TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE)) == TextWidth.NARROW ? "N" : ((OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT)) == OutputContext.FORMAT ? "w" : ExifInterface.LONGITUDE_WEST);
        }
    }

    private static class SansculottidesAccess extends BasicElement<Sansculottides> implements TextElement<Sansculottides>, ElementRule<FrenchRepublicanCalendar, Sansculottides> {
        private static final long serialVersionUID = -6615947737325572130L;

        public ChronoElement<?> getChildAtCeiling(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return null;
        }

        public char getSymbol() {
            return 'S';
        }

        public boolean isDateElement() {
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean isSingleton() {
            return true;
        }

        public boolean isTimeElement() {
            return false;
        }

        SansculottidesAccess() {
            super("SANSCULOTTIDES");
        }

        public Sansculottides getValue(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return frenchRepublicanCalendar.getSansculottides();
        }

        public Sansculottides getMinimum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return Sansculottides.COMPLEMENTARY_DAY_1;
        }

        public Sansculottides getMaximum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return frenchRepublicanCalendar.isLeapYear() ? Sansculottides.LEAP_DAY : Sansculottides.COMPLEMENTARY_DAY_5;
        }

        public boolean isValid(FrenchRepublicanCalendar frenchRepublicanCalendar, Sansculottides sansculottides) {
            if (sansculottides != null) {
                return frenchRepublicanCalendar.isLeapYear() || sansculottides != Sansculottides.LEAP_DAY;
            }
            return false;
        }

        public FrenchRepublicanCalendar withValue(FrenchRepublicanCalendar frenchRepublicanCalendar, Sansculottides sansculottides, boolean z) {
            if (sansculottides != null) {
                return FrenchRepublicanCalendar.of(frenchRepublicanCalendar.fyear, sansculottides);
            }
            throw new IllegalArgumentException("Missing sansculottides value.");
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            appendable.append(accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT)).print((Sansculottides) chronoDisplay.get(this)));
        }

        public Sansculottides parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            int index = parsePosition.getIndex();
            Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
            OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
            Sansculottides sansculottides = (Sansculottides) accessor(locale, outputContext).parse(charSequence, parsePosition, getType(), attributeQuery);
            if (sansculottides != null || !((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue()) {
                return sansculottides;
            }
            parsePosition.setErrorIndex(-1);
            parsePosition.setIndex(index);
            return (Sansculottides) accessor(locale, outputContext == OutputContext.FORMAT ? OutputContext.STANDALONE : OutputContext.FORMAT).parse(charSequence, parsePosition, getType(), attributeQuery);
        }

        public Class<Sansculottides> getType() {
            return Sansculottides.class;
        }

        public Sansculottides getDefaultMinimum() {
            return Sansculottides.COMPLEMENTARY_DAY_1;
        }

        public Sansculottides getDefaultMaximum() {
            return Sansculottides.COMPLEMENTARY_DAY_5;
        }

        public String getDisplayName(Locale locale) {
            String str = CalendarText.getInstance("frenchrev", locale).getTextForms().get("L_sansculottides");
            return str == null ? name() : str;
        }

        private TextAccessor accessor(Locale locale, OutputContext outputContext) {
            return CalendarText.getInstance("frenchrev", locale).getTextForms(name(), getType(), outputContext == OutputContext.FORMAT ? "w" : ExifInterface.LONGITUDE_WEST);
        }
    }

    private static class WeekdayRule implements ElementRule<FrenchRepublicanCalendar, Weekday> {
        public ChronoElement<?> getChildAtCeiling(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return null;
        }

        private WeekdayRule() {
        }

        /* synthetic */ WeekdayRule(AnonymousClass1 r1) {
            this();
        }

        public Weekday getValue(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return frenchRepublicanCalendar.getDayOfWeek();
        }

        public Weekday getMinimum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return (frenchRepublicanCalendar.fyear == 1 && frenchRepublicanCalendar.fdoy == 1) ? Weekday.SATURDAY : Weekday.SUNDAY;
        }

        public Weekday getMaximum(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return (frenchRepublicanCalendar.fyear == FrenchRepublicanCalendar.MAX_YEAR && frenchRepublicanCalendar.fdoy == 366) ? Weekday.SUNDAY : Weekday.SATURDAY;
        }

        public boolean isValid(FrenchRepublicanCalendar frenchRepublicanCalendar, Weekday weekday) {
            if (weekday == null) {
                return false;
            }
            int value = weekday.getValue(FrenchRepublicanCalendar.getDefaultWeekmodel());
            int value2 = getMinimum(frenchRepublicanCalendar).getValue(FrenchRepublicanCalendar.getDefaultWeekmodel());
            int value3 = getMaximum(frenchRepublicanCalendar).getValue(FrenchRepublicanCalendar.getDefaultWeekmodel());
            if (value2 > value || value > value3) {
                return false;
            }
            return true;
        }

        public FrenchRepublicanCalendar withValue(FrenchRepublicanCalendar frenchRepublicanCalendar, Weekday weekday, boolean z) {
            if (weekday != null) {
                Weekmodel access$1100 = FrenchRepublicanCalendar.getDefaultWeekmodel();
                return (FrenchRepublicanCalendar) frenchRepublicanCalendar.plus(CalendarDays.of((long) (weekday.getValue(access$1100) - frenchRepublicanCalendar.getDayOfWeek().getValue(access$1100))));
            }
            throw new IllegalArgumentException("Missing weekday.");
        }
    }

    private static class Merger implements ChronoMerger<FrenchRepublicanCalendar> {
        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        /* synthetic */ Merger(AnonymousClass1 r1) {
            this();
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.frenchrev.FrenchRepublicanCalendar createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
            /*
                r3 = this;
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r0 = r5.contains(r0)
                if (r0 == 0) goto L_0x0011
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r0 = r5.get(r0)
                net.time4j.tz.TZID r0 = (net.time4j.tz.TZID) r0
                goto L_0x0029
            L_0x0011:
                net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r0 = net.time4j.format.Attributes.LENIENCY
                net.time4j.format.Leniency r1 = net.time4j.format.Leniency.SMART
                java.lang.Object r0 = r5.get(r0, r1)
                net.time4j.format.Leniency r0 = (net.time4j.format.Leniency) r0
                boolean r0 = r0.isLax()
                if (r0 == 0) goto L_0x004c
                net.time4j.tz.Timezone r0 = net.time4j.tz.Timezone.ofSystem()
                net.time4j.tz.TZID r0 = r0.getID()
            L_0x0029:
                net.time4j.engine.AttributeKey<net.time4j.engine.StartOfDay> r1 = net.time4j.format.Attributes.START_OF_DAY
                net.time4j.engine.StartOfDay r2 = r3.getDefaultStartOfDay()
                java.lang.Object r5 = r5.get(r1, r2)
                net.time4j.engine.StartOfDay r5 = (net.time4j.engine.StartOfDay) r5
                net.time4j.base.UnixTime r4 = r4.currentTime()
                net.time4j.Moment r4 = net.time4j.Moment.from(r4)
                net.time4j.engine.TimeAxis r1 = net.time4j.calendar.frenchrev.FrenchRepublicanCalendar.ENGINE
                net.time4j.GeneralTimestamp r4 = r4.toGeneralTimestamp(r1, r0, r5)
                java.lang.Object r4 = r4.toDate()
                net.time4j.calendar.frenchrev.FrenchRepublicanCalendar r4 = (net.time4j.calendar.frenchrev.FrenchRepublicanCalendar) r4
                return r4
            L_0x004c:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.frenchrev.FrenchRepublicanCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.frenchrev.FrenchRepublicanCalendar");
        }

        public FrenchRepublicanCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            int i;
            FrenchRepublicanAlgorithm frenchRepublicanAlgorithm = (FrenchRepublicanAlgorithm) attributeQuery.get(FrenchRepublicanAlgorithm.attribute(), FrenchRepublicanCalendar.DEFAULT_ALGORITHM);
            int i2 = chronoEntity.getInt(FrenchRepublicanCalendar.YEAR_OF_ERA);
            FrenchRepublicanCalendar frenchRepublicanCalendar = null;
            if (i2 == Integer.MIN_VALUE) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing republican year.");
                return null;
            } else if (i2 < 1 || i2 > FrenchRepublicanCalendar.MAX_YEAR) {
                ValidationElement validationElement = ValidationElement.ERROR_MESSAGE;
                chronoEntity.with((ChronoElement<V>) validationElement, "Republican year out of range: " + i2);
                return null;
            } else {
                if (chronoEntity.contains(FrenchRepublicanCalendar.MONTH_OF_YEAR)) {
                    int value = ((FrenchRepublicanMonth) chronoEntity.get((ChronoElement<V>) FrenchRepublicanCalendar.MONTH_OF_YEAR)).getValue();
                    int i3 = chronoEntity.getInt(FrenchRepublicanCalendar.DAY_OF_MONTH);
                    if (i3 == Integer.MIN_VALUE && chronoEntity.contains(FrenchRepublicanCalendar.DAY_OF_DECADE) && (i = chronoEntity.getInt(FrenchRepublicanCalendar.DECADE_OF_MONTH)) != Integer.MIN_VALUE) {
                        i3 = ((DayOfDecade) chronoEntity.get((ChronoElement<V>) FrenchRepublicanCalendar.DAY_OF_DECADE)).getValue() + ((i - 1) * 10);
                    }
                    if (i3 != Integer.MIN_VALUE) {
                        if (i3 < 1 || i3 > 30) {
                            chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid republican date.");
                        } else {
                            frenchRepublicanCalendar = FrenchRepublicanCalendar.of(i2, value, i3);
                        }
                    }
                } else if (chronoEntity.contains(FrenchRepublicanCalendar.SANSCULOTTIDES)) {
                    int value2 = ((Sansculottides) chronoEntity.get((ChronoElement<V>) FrenchRepublicanCalendar.SANSCULOTTIDES)).getValue() + 360;
                    if (value2 != 6 || frenchRepublicanAlgorithm.isLeapYear(i2)) {
                        frenchRepublicanCalendar = new FrenchRepublicanCalendar(i2, value2);
                    } else {
                        chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Republican date is no leap year.");
                    }
                } else {
                    int i4 = chronoEntity.getInt(FrenchRepublicanCalendar.DAY_OF_YEAR);
                    if (i4 != Integer.MIN_VALUE) {
                        if (i4 >= 1) {
                            if (i4 <= (frenchRepublicanAlgorithm.isLeapYear(i2) ? 366 : 365)) {
                                frenchRepublicanCalendar = new FrenchRepublicanCalendar(i2, i4);
                            }
                        }
                        chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid republican date.");
                    }
                }
                return (frenchRepublicanCalendar == null || frenchRepublicanAlgorithm == FrenchRepublicanCalendar.DEFAULT_ALGORITHM) ? frenchRepublicanCalendar : FrenchRepublicanCalendar.DEFAULT_ALGORITHM.transform(frenchRepublicanAlgorithm.transform(frenchRepublicanCalendar));
            }
        }

        public ChronoDisplay preformat(FrenchRepublicanCalendar frenchRepublicanCalendar, AttributeQuery attributeQuery) {
            FrenchRepublicanAlgorithm frenchRepublicanAlgorithm = (FrenchRepublicanAlgorithm) attributeQuery.get(FrenchRepublicanAlgorithm.attribute(), FrenchRepublicanCalendar.DEFAULT_ALGORITHM);
            if (frenchRepublicanAlgorithm == FrenchRepublicanCalendar.DEFAULT_ALGORITHM) {
                return frenchRepublicanCalendar;
            }
            return frenchRepublicanCalendar.getDate(frenchRepublicanAlgorithm);
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            throw new UnsupportedOperationException("Localized format patterns are not available.");
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear() - 1792;
        }
    }

    private static class FUnitRule implements UnitRule<FrenchRepublicanCalendar> {
        private final Unit unit;

        FUnitRule(Unit unit2) {
            this.unit = unit2;
        }

        public FrenchRepublicanCalendar addTo(FrenchRepublicanCalendar frenchRepublicanCalendar, long j) {
            int i = AnonymousClass1.$SwitchMap$net$time4j$calendar$frenchrev$FrenchRepublicanCalendar$Unit[this.unit.ordinal()];
            if (i != 1) {
                int i2 = 30;
                if (i == 2) {
                    long safeAdd = MathUtils.safeAdd((long) ymValue(frenchRepublicanCalendar), j);
                    int safeCast = MathUtils.safeCast(MathUtils.floorDivide(safeAdd, 12));
                    int floorModulo = MathUtils.floorModulo(safeAdd, 12) + 1;
                    if (!frenchRepublicanCalendar.hasSansculottides()) {
                        i2 = frenchRepublicanCalendar.getDayOfMonth();
                    }
                    return FrenchRepublicanCalendar.of(safeCast, floorModulo, i2);
                } else if (i != 3) {
                    if (i == 4) {
                        j = MathUtils.safeMultiply(j, 7);
                    } else if (i != 5) {
                        throw new UnsupportedOperationException(this.unit.name());
                    }
                    return (FrenchRepublicanCalendar) FrenchRepublicanCalendar.CALSYS.transform(MathUtils.safeAdd(FrenchRepublicanCalendar.CALSYS.transform(frenchRepublicanCalendar), j));
                } else {
                    long safeAdd2 = MathUtils.safeAdd((long) decValue(frenchRepublicanCalendar), j);
                    int safeCast2 = MathUtils.safeCast(MathUtils.floorDivide(safeAdd2, 36));
                    int floorModulo2 = MathUtils.floorModulo(safeAdd2, 36);
                    int floorDivide = MathUtils.floorDivide(floorModulo2, 3) + 1;
                    int floorModulo3 = MathUtils.floorModulo(floorModulo2, 3);
                    if (!frenchRepublicanCalendar.hasSansculottides()) {
                        i2 = frenchRepublicanCalendar.getDayOfMonth();
                    }
                    return FrenchRepublicanCalendar.of(safeCast2, floorDivide, (floorModulo3 * 10) + ((i2 - 1) % 10) + 1);
                }
            } else {
                int safeCast3 = MathUtils.safeCast(MathUtils.safeAdd((long) frenchRepublicanCalendar.fyear, j));
                if (safeCast3 < 1 || safeCast3 > FrenchRepublicanCalendar.MAX_YEAR) {
                    throw new IllegalArgumentException("Resulting year out of bounds: " + safeCast3);
                }
                return new FrenchRepublicanCalendar(safeCast3, Math.min(frenchRepublicanCalendar.fdoy, FrenchRepublicanCalendar.isLeapYear(safeCast3) ? 366 : 365));
            }
        }

        public long between(FrenchRepublicanCalendar frenchRepublicanCalendar, FrenchRepublicanCalendar frenchRepublicanCalendar2) {
            int i = AnonymousClass1.$SwitchMap$net$time4j$calendar$frenchrev$FrenchRepublicanCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                int access$900 = frenchRepublicanCalendar2.fyear - frenchRepublicanCalendar.fyear;
                if (access$900 > 0 && frenchRepublicanCalendar2.fdoy < frenchRepublicanCalendar.fdoy) {
                    access$900--;
                } else if (access$900 < 0 && frenchRepublicanCalendar2.fdoy > frenchRepublicanCalendar.fdoy) {
                    access$900++;
                }
                return (long) access$900;
            } else if (i == 2) {
                long ymValue = (long) (ymValue(frenchRepublicanCalendar2) - ymValue(frenchRepublicanCalendar));
                int access$1000 = frenchRepublicanCalendar.hasSansculottides() ? frenchRepublicanCalendar.fdoy - 330 : frenchRepublicanCalendar.getDayOfMonth();
                int access$10002 = frenchRepublicanCalendar2.hasSansculottides() ? frenchRepublicanCalendar2.fdoy - 330 : frenchRepublicanCalendar2.getDayOfMonth();
                int i2 = (ymValue > 0 ? 1 : (ymValue == 0 ? 0 : -1));
                if (i2 <= 0 || access$10002 >= access$1000) {
                    return (i2 >= 0 || access$10002 <= access$1000) ? ymValue : ymValue + 1;
                }
                return ymValue - 1;
            } else if (i == 3) {
                long decValue = (long) (decValue(frenchRepublicanCalendar2) - decValue(frenchRepublicanCalendar));
                int access$10003 = frenchRepublicanCalendar.hasSansculottides() ? frenchRepublicanCalendar.fdoy - 350 : frenchRepublicanCalendar.getDayOfDecade().getValue();
                int access$10004 = frenchRepublicanCalendar2.hasSansculottides() ? frenchRepublicanCalendar2.fdoy - 350 : frenchRepublicanCalendar2.getDayOfDecade().getValue();
                int i3 = (decValue > 0 ? 1 : (decValue == 0 ? 0 : -1));
                if (i3 <= 0 || access$10004 >= access$10003) {
                    return (i3 >= 0 || access$10004 <= access$10003) ? decValue : decValue + 1;
                }
                return decValue - 1;
            } else if (i == 4) {
                return Unit.DAYS.between(frenchRepublicanCalendar, frenchRepublicanCalendar2) / 7;
            } else {
                if (i == 5) {
                    return FrenchRepublicanCalendar.CALSYS.transform(frenchRepublicanCalendar2) - FrenchRepublicanCalendar.CALSYS.transform(frenchRepublicanCalendar);
                }
                throw new UnsupportedOperationException(this.unit.name());
            }
        }

        private static int ymValue(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return ((frenchRepublicanCalendar.fyear * 12) + (frenchRepublicanCalendar.hasSansculottides() ? 12 : frenchRepublicanCalendar.getMonth().getValue())) - 1;
        }

        private static int decValue(FrenchRepublicanCalendar frenchRepublicanCalendar) {
            return ((ymValue(frenchRepublicanCalendar) * 3) + (frenchRepublicanCalendar.hasSansculottides() ? 3 : frenchRepublicanCalendar.getDecade())) - 1;
        }
    }

    /* renamed from: net.time4j.calendar.frenchrev.FrenchRepublicanCalendar$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$frenchrev$FrenchRepublicanCalendar$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                net.time4j.calendar.frenchrev.FrenchRepublicanCalendar$Unit[] r0 = net.time4j.calendar.frenchrev.FrenchRepublicanCalendar.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$frenchrev$FrenchRepublicanCalendar$Unit = r0
                net.time4j.calendar.frenchrev.FrenchRepublicanCalendar$Unit r1 = net.time4j.calendar.frenchrev.FrenchRepublicanCalendar.Unit.YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$frenchrev$FrenchRepublicanCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.frenchrev.FrenchRepublicanCalendar$Unit r1 = net.time4j.calendar.frenchrev.FrenchRepublicanCalendar.Unit.MONTHS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$calendar$frenchrev$FrenchRepublicanCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.frenchrev.FrenchRepublicanCalendar$Unit r1 = net.time4j.calendar.frenchrev.FrenchRepublicanCalendar.Unit.DECADES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$calendar$frenchrev$FrenchRepublicanCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.frenchrev.FrenchRepublicanCalendar$Unit r1 = net.time4j.calendar.frenchrev.FrenchRepublicanCalendar.Unit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$net$time4j$calendar$frenchrev$FrenchRepublicanCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.calendar.frenchrev.FrenchRepublicanCalendar$Unit r1 = net.time4j.calendar.frenchrev.FrenchRepublicanCalendar.Unit.DAYS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.frenchrev.FrenchRepublicanCalendar.AnonymousClass1.<clinit>():void");
        }
    }
}
