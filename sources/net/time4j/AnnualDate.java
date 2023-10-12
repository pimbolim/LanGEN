package net.time4j;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Locale;
import java.util.Map;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.IntElementRule;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.Temporal;
import net.time4j.engine.ValidationElement;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.LocalizedPatternSupport;

@CalendarType("iso8601")
public final class AnnualDate extends ChronoEntity<AnnualDate> implements Comparable<AnnualDate>, Temporal<AnnualDate>, LocalizedPatternSupport, Serializable {
    @FormattableElement(format = "d")
    public static final ChronoElement<Integer> DAY_OF_MONTH;
    private static final Chronology<AnnualDate> ENGINE;
    public static final ChronoElement<Integer> MONTH_AS_NUMBER;
    @FormattableElement(alt = "L", format = "M")
    public static final ChronoElement<Month> MONTH_OF_YEAR;
    private static final long serialVersionUID = 7510648008819092983L;
    /* access modifiers changed from: private */
    public final int dayOfMonth;
    /* access modifiers changed from: private */
    public final int month;

    /* access modifiers changed from: private */
    public static int getMaxDay(int i) {
        if (i != 2) {
            return (i == 4 || i == 6 || i == 9 || i == 11) ? 30 : 31;
        }
        return 29;
    }

    /* access modifiers changed from: protected */
    public AnnualDate getContext() {
        return this;
    }

    static {
        NavigableElement<Month> navigableElement = PlainDate.MONTH_OF_YEAR;
        MONTH_OF_YEAR = navigableElement;
        ChronoElement chronoElement = PlainDate.MONTH_AS_NUMBER;
        MONTH_AS_NUMBER = chronoElement;
        ProportionalElement<Integer, PlainDate> proportionalElement = PlainDate.DAY_OF_MONTH;
        DAY_OF_MONTH = proportionalElement;
        ENGINE = Chronology.Builder.setUp(AnnualDate.class, new Merger()).appendElement(proportionalElement, new IntegerElementRule(true)).appendElement(navigableElement, new MonthElementRule()).appendElement(chronoElement, new IntegerElementRule(false)).build();
    }

    private AnnualDate(int i, int i2) {
        this.month = i;
        this.dayOfMonth = i2;
    }

    public static AnnualDate of(Month month2, int i) {
        return of(month2.getValue(), i);
    }

    public static AnnualDate of(int i, int i2) {
        check(i, i2);
        return new AnnualDate(i, i2);
    }

    public static AnnualDate from(GregorianDate gregorianDate) {
        PlainDate from = PlainDate.from(gregorianDate);
        return new AnnualDate(from.getMonth(), from.getDayOfMonth());
    }

    public static AnnualDate nowInSystemTime() {
        return (AnnualDate) SystemClock.inLocalView().now(ENGINE);
    }

    public Month getMonth() {
        return Month.valueOf(this.month);
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public boolean isAfter(AnnualDate annualDate) {
        return compareTo(annualDate) > 0;
    }

    public boolean isBefore(AnnualDate annualDate) {
        return compareTo(annualDate) < 0;
    }

    public boolean isSimultaneous(AnnualDate annualDate) {
        return compareTo(annualDate) == 0;
    }

    public int compareTo(AnnualDate annualDate) {
        int i = this.month;
        int i2 = annualDate.month;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = this.dayOfMonth;
        int i4 = annualDate.dayOfMonth;
        if (i3 < i4) {
            return -1;
        }
        if (i3 > i4) {
            return 1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnualDate)) {
            return false;
        }
        AnnualDate annualDate = (AnnualDate) obj;
        if (this.month == annualDate.month && this.dayOfMonth == annualDate.dayOfMonth) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.month << 16) + this.dayOfMonth;
    }

    public String toString() {
        return toString(this.month, this.dayOfMonth);
    }

    public static AnnualDate parseXML(String str) throws ParseException {
        if (str.length() == 7 && str.charAt(0) == '-' && str.charAt(1) == '-' && str.charAt(4) == '-') {
            int digit = toDigit(str, 2);
            return new AnnualDate((digit * 10) + toDigit(str, 3), (toDigit(str, 5) * 10) + toDigit(str, 6));
        }
        throw new ParseException("Not compatible to standard XML-format: " + str, str.length());
    }

    public PlainDate atYear(int i) {
        return PlainDate.of(i, this.month, this.dayOfMonth);
    }

    public boolean isValidDate(int i) {
        return i >= -999999999 && i <= 999999999 && !(this.month == 2 && this.dayOfMonth == 29 && !GregorianMath.isLeapYear(i));
    }

    public ChronoOperator<PlainDate> asNextExactEvent() {
        return new ChronoOperator<PlainDate>() {
            public PlainDate apply(PlainDate plainDate) {
                int year = plainDate.getYear();
                int value = AnnualDate.this.getMonth().getValue();
                int dayOfMonth = AnnualDate.this.getDayOfMonth();
                if (value < plainDate.getMonth() || (value == plainDate.getMonth() && dayOfMonth <= plainDate.getDayOfMonth())) {
                    year++;
                }
                if (value == 2 && dayOfMonth == 29) {
                    while (!GregorianMath.isLeapYear(year)) {
                        year++;
                    }
                }
                return PlainDate.of(year, value, dayOfMonth);
            }
        };
    }

    public ChronoOperator<PlainDate> asNextRoundedEvent() {
        return new ChronoOperator<PlainDate>() {
            public PlainDate apply(PlainDate plainDate) {
                int year = plainDate.getYear();
                int value = AnnualDate.this.getMonth().getValue();
                int dayOfMonth = AnnualDate.this.getDayOfMonth();
                if (value < plainDate.getMonth() || (value == plainDate.getMonth() && dayOfMonth <= plainDate.getDayOfMonth())) {
                    year++;
                }
                if (value == 2 && dayOfMonth == 29 && !GregorianMath.isLeapYear(year)) {
                    value = 3;
                    dayOfMonth = 1;
                }
                return PlainDate.of(year, value, dayOfMonth);
            }
        };
    }

    public static Chronology<AnnualDate> chronology() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public Chronology<AnnualDate> getChronology() {
        return ENGINE;
    }

    private static void check(int i, int i2) {
        if (i < 1 || i > 12) {
            throw new IllegalArgumentException("Month not in range 1-12: " + i);
        } else if (i2 < 1 || i2 > getMaxDay(i)) {
            throw new IllegalArgumentException("Out of bounds: " + toString(i, i2));
        }
    }

    private static int toDigit(String str, int i) throws ParseException {
        char charAt = str.charAt(i);
        if (charAt >= '0' && charAt <= '9') {
            return charAt - '0';
        }
        throw new ParseException("Digit expected: " + str, i);
    }

    private static String toString(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
        sb.append(SignatureVisitor.SUPER);
        if (i2 < 10) {
            sb.append('0');
        }
        sb.append(i2);
        return sb.toString();
    }

    private Object readResolve() throws InvalidObjectException {
        try {
            check(this.month, this.dayOfMonth);
            return this;
        } catch (IllegalArgumentException e) {
            throw new InvalidObjectException(e.getMessage());
        }
    }

    private static class Merger implements ChronoMerger<AnnualDate> {
        public ChronoDisplay preformat(AnnualDate annualDate, AttributeQuery attributeQuery) {
            return annualDate;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.AnnualDate createFrom(net.time4j.base.TimeSource<?> r3, net.time4j.engine.AttributeQuery r4) {
            /*
                r2 = this;
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r0 = r4.contains(r0)
                if (r0 == 0) goto L_0x0015
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r4 = r4.get(r0)
                net.time4j.tz.TZID r4 = (net.time4j.tz.TZID) r4
                net.time4j.tz.Timezone r4 = net.time4j.tz.Timezone.of((net.time4j.tz.TZID) r4)
                goto L_0x0029
            L_0x0015:
                net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r0 = net.time4j.format.Attributes.LENIENCY
                net.time4j.format.Leniency r1 = net.time4j.format.Leniency.SMART
                java.lang.Object r4 = r4.get(r0, r1)
                net.time4j.format.Leniency r4 = (net.time4j.format.Leniency) r4
                boolean r4 = r4.isLax()
                if (r4 == 0) goto L_0x004a
                net.time4j.tz.Timezone r4 = net.time4j.tz.Timezone.ofSystem()
            L_0x0029:
                net.time4j.base.UnixTime r3 = r3.currentTime()
                net.time4j.Moment r3 = net.time4j.Moment.from(r3)
                net.time4j.tz.TZID r4 = r4.getID()
                net.time4j.PlainTimestamp r3 = r3.toZonalTimestamp((net.time4j.tz.TZID) r4)
                net.time4j.PlainDate r3 = r3.toDate()
                int r4 = r3.getMonth()
                int r3 = r3.getDayOfMonth()
                net.time4j.AnnualDate r3 = net.time4j.AnnualDate.of((int) r4, (int) r3)
                return r3
            L_0x004a:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.AnnualDate.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.AnnualDate");
        }

        public AnnualDate createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            int i = chronoEntity.getInt(AnnualDate.DAY_OF_MONTH);
            if (i != Integer.MIN_VALUE) {
                int i2 = chronoEntity.getInt(PlainDate.MONTH_AS_NUMBER);
                if (i2 == Integer.MIN_VALUE && chronoEntity.contains(AnnualDate.MONTH_OF_YEAR)) {
                    i2 = ((Month) chronoEntity.get((ChronoElement<V>) AnnualDate.MONTH_OF_YEAR)).getValue();
                }
                if (i2 != Integer.MIN_VALUE) {
                    if (i < 1 || i > AnnualDate.getMaxDay(i2)) {
                        ValidationElement validationElement = ValidationElement.ERROR_MESSAGE;
                        chronoEntity.with((ChronoElement<V>) validationElement, "Day-of-month out of bounds: " + i);
                    } else if (i2 >= 1 && i2 <= 12) {
                        return new AnnualDate(i2, i);
                    } else {
                        ValidationElement validationElement2 = ValidationElement.ERROR_MESSAGE;
                        chronoEntity.with((ChronoElement<V>) validationElement2, "Month out of bounds: " + i2);
                    }
                }
            }
            return null;
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            Map<String, String> textForms = CalendarText.getIsoInstance(locale).getTextForms();
            int styleValue = displayStyle.getStyleValue();
            String formatPattern = getFormatPattern(textForms, styleValue != 0 ? styleValue != 1 ? styleValue != 2 ? styleValue != 3 ? null : "F_Md" : "F_MMd" : "F_MMMd" : "F_MMMMd");
            return formatPattern == null ? "MM-dd" : formatPattern;
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear();
        }

        private static String getFormatPattern(Map<String, String> map, String str) {
            if (map.containsKey(str)) {
                return map.get(str);
            }
            if ("F_MMMMd".equals(str)) {
                return getFormatPattern(map, "F_MMMd");
            }
            if ("F_MMMd".equals(str)) {
                return getFormatPattern(map, "F_MMd");
            }
            if ("F_MMd".equals(str)) {
                return getFormatPattern(map, "F_Md");
            }
            return null;
        }
    }

    private static class MonthElementRule implements ElementRule<AnnualDate, Month> {
        public boolean isValid(AnnualDate annualDate, Month month) {
            return month != null;
        }

        private MonthElementRule() {
        }

        public Month getValue(AnnualDate annualDate) {
            return annualDate.getMonth();
        }

        public Month getMinimum(AnnualDate annualDate) {
            return Month.JANUARY;
        }

        public Month getMaximum(AnnualDate annualDate) {
            return Month.DECEMBER;
        }

        public AnnualDate withValue(AnnualDate annualDate, Month month, boolean z) {
            if (month != null) {
                int value = month.getValue();
                return new AnnualDate(value, Math.min(annualDate.dayOfMonth, AnnualDate.getMaxDay(value)));
            }
            throw new IllegalArgumentException("Missing new value.");
        }

        public ChronoElement<?> getChildAtFloor(AnnualDate annualDate) {
            return AnnualDate.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(AnnualDate annualDate) {
            return AnnualDate.DAY_OF_MONTH;
        }
    }

    private static class IntegerElementRule implements IntElementRule<AnnualDate> {
        private final boolean daywise;

        IntegerElementRule(boolean z) {
            this.daywise = z;
        }

        public int getInt(AnnualDate annualDate) {
            return this.daywise ? annualDate.dayOfMonth : annualDate.month;
        }

        public boolean isValid(AnnualDate annualDate, int i) {
            if (i < 1) {
                return false;
            }
            if (this.daywise) {
                if (i <= AnnualDate.getMaxDay(annualDate.month)) {
                    return true;
                }
                return false;
            } else if (i <= 12) {
                return true;
            } else {
                return false;
            }
        }

        public AnnualDate withValue(AnnualDate annualDate, int i, boolean z) {
            if (this.daywise) {
                return AnnualDate.of(annualDate.month, i);
            }
            return AnnualDate.of(i, Math.min(annualDate.dayOfMonth, AnnualDate.getMaxDay(i)));
        }

        public Integer getValue(AnnualDate annualDate) {
            return Integer.valueOf(getInt(annualDate));
        }

        public Integer getMinimum(AnnualDate annualDate) {
            return 1;
        }

        public Integer getMaximum(AnnualDate annualDate) {
            if (this.daywise) {
                return Integer.valueOf(AnnualDate.getMaxDay(annualDate.month));
            }
            return 12;
        }

        public boolean isValid(AnnualDate annualDate, Integer num) {
            if (num == null) {
                return false;
            }
            return isValid(annualDate, num.intValue());
        }

        public AnnualDate withValue(AnnualDate annualDate, Integer num, boolean z) {
            if (num != null) {
                return withValue(annualDate, num.intValue(), z);
            }
            throw new IllegalArgumentException("Missing new value.");
        }

        public ChronoElement<?> getChildAtFloor(AnnualDate annualDate) {
            if (this.daywise) {
                return null;
            }
            return AnnualDate.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(AnnualDate annualDate) {
            if (this.daywise) {
                return null;
            }
            return AnnualDate.DAY_OF_MONTH;
        }
    }
}
