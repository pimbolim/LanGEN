package net.time4j.format.platform;

import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import net.time4j.Meridiem;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.PlainTimestamp;
import net.time4j.TemporalType;
import net.time4j.ZonalDateTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.Chronology;
import net.time4j.format.Attributes;
import net.time4j.format.DisplayMode;
import net.time4j.format.Leniency;
import net.time4j.format.RawValues;
import net.time4j.format.TemporalFormatter;
import net.time4j.format.internal.FormatUtils;
import net.time4j.tz.NameStyle;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;
import org.apache.commons.lang3.time.TimeZones;

public final class SimpleFormatter<T> implements TemporalFormatter<T> {
    /* access modifiers changed from: private */
    public static final Date PROLEPTIC_GREGORIAN = new Date(Long.MIN_VALUE);
    public static final SimpleFormatter<Moment> RFC_1123 = new SimpleFormatter(Moment.class, RFC_1123_PATTERN, Locale.ENGLISH, Leniency.SMART, TimeZones.GMT_ID);
    private static final String RFC_1123_PATTERN = "<RFC-1123>";
    private static final String RFC_1123_SHORT = "d MMM yyyy HH:mm:ss Z";
    private static final String RFC_1123_WIDE = "EEE, d MMM yyyy HH:mm:ss Z";
    private static final Map<Class<?>, Chronology<?>> SUPPORTED_TYPES;
    private static final PlainDate UNIX_EPOCH_DATE = PlainDate.of(1970, 1, 1);
    private final Leniency leniency;
    private final Locale locale;
    private final String pattern;
    private final Class<T> type;
    private final String tzid;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(PlainDate.class, PlainDate.axis());
        hashMap.put(PlainTime.class, PlainTime.axis());
        hashMap.put(PlainTimestamp.class, PlainTimestamp.axis());
        hashMap.put(Moment.class, Moment.axis());
        SUPPORTED_TYPES = Collections.unmodifiableMap(hashMap);
    }

    private SimpleFormatter(Class<T> cls, String str, Locale locale2, Leniency leniency2, String str2) {
        Objects.requireNonNull(cls, "Missing chronological type");
        if (!str.isEmpty()) {
            Objects.requireNonNull(locale2, "Locale is not specified.");
            Objects.requireNonNull(leniency2, "Missing leniency.");
            this.type = cls;
            this.pattern = str;
            this.locale = locale2;
            this.leniency = leniency2;
            this.tzid = str2;
            return;
        }
        throw new IllegalArgumentException("Format pattern is empty.");
    }

    public static SimpleFormatter<PlainDate> ofDatePattern(String str, Locale locale2) {
        return new SimpleFormatter(PlainDate.class, str, locale2, Leniency.SMART, (String) null);
    }

    public static SimpleFormatter<PlainDate> ofDateStyle(DisplayMode displayMode, Locale locale2) {
        return ofDatePattern(getFormatPattern(DateFormat.getDateInstance(displayMode.getStyleValue(), locale2)), locale2);
    }

    public static SimpleFormatter<PlainTime> ofTimePattern(String str, Locale locale2) {
        return new SimpleFormatter(PlainTime.class, str, locale2, Leniency.SMART, (String) null);
    }

    public static SimpleFormatter<PlainTime> ofTimeStyle(DisplayMode displayMode, Locale locale2) {
        return ofTimePattern(FormatUtils.removeZones(getFormatPattern(DateFormat.getTimeInstance(displayMode.getStyleValue(), locale2))), locale2);
    }

    public static SimpleFormatter<PlainTimestamp> ofTimestampPattern(String str, Locale locale2) {
        return new SimpleFormatter(PlainTimestamp.class, str, locale2, Leniency.SMART, (String) null);
    }

    public static SimpleFormatter<PlainTimestamp> ofTimestampStyle(DisplayMode displayMode, DisplayMode displayMode2, Locale locale2) {
        return ofTimestampPattern(FormatUtils.removeZones(getFormatPattern(DateFormat.getDateTimeInstance(displayMode.getStyleValue(), displayMode2.getStyleValue(), locale2))), locale2);
    }

    public static SimpleFormatter<Moment> ofMomentPattern(String str, Locale locale2, TZID tzid2) {
        return new SimpleFormatter(Moment.class, str, locale2, Leniency.SMART, tzid2.canonical());
    }

    public static SimpleFormatter<Moment> ofMomentStyle(DisplayMode displayMode, DisplayMode displayMode2, Locale locale2, TZID tzid2) {
        return ofMomentPattern(getFormatPattern(DateFormat.getDateTimeInstance(displayMode.getStyleValue(), displayMode2.getStyleValue(), locale2)), locale2, tzid2);
    }

    public String format(T t) {
        return print(t);
    }

    public String print(T t) {
        StringBuilder sb = new StringBuilder();
        try {
            print(t, sb);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public T parse(CharSequence charSequence) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        try {
            T parseInternal = parseInternal(charSequence, parsePosition, (RawValues) null);
            if (parseInternal != null && parsePosition.getErrorIndex() <= -1) {
                return parseInternal;
            }
            throw new ParseException("Cannot parse: " + charSequence, parsePosition.getErrorIndex());
        } catch (RuntimeException e) {
            ParseException parseException = new ParseException(e.getMessage(), parsePosition.getErrorIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    public T parse(CharSequence charSequence, RawValues rawValues) throws ParseException {
        Objects.requireNonNull(rawValues, "Missing raw values.");
        ParsePosition parsePosition = new ParsePosition(0);
        try {
            T parseInternal = parseInternal(charSequence, parsePosition, rawValues);
            if (parseInternal != null && parsePosition.getErrorIndex() <= -1) {
                return parseInternal;
            }
            throw new ParseException("Cannot parse: " + charSequence, parsePosition.getErrorIndex());
        } catch (RuntimeException e) {
            ParseException parseException = new ParseException(e.getMessage(), parsePosition.getErrorIndex());
            parseException.initCause(e);
            throw parseException;
        }
    }

    public TemporalFormatter<T> withTimezone(TZID tzid2) {
        return withTimezone(tzid2.canonical());
    }

    public TemporalFormatter<T> withTimezone(String str) {
        return new SimpleFormatter(this.type, this.pattern, this.locale, this.leniency, str);
    }

    public TemporalFormatter<T> with(Locale locale2) {
        return new SimpleFormatter(this.type, this.pattern, locale2, this.leniency, this.tzid);
    }

    public TemporalFormatter<T> with(Leniency leniency2) {
        return new SimpleFormatter(this.type, this.pattern, this.locale, leniency2, this.tzid);
    }

    public AttributeQuery getAttributes() {
        Chronology chronology = SUPPORTED_TYPES.get(this.type);
        Attributes.Builder builder = chronology == null ? new Attributes.Builder() : new Attributes.Builder(chronology);
        builder.setLanguage(this.locale);
        builder.set(Attributes.LENIENCY, this.leniency);
        String str = this.tzid;
        if (str != null) {
            builder.setTimezone(str);
        }
        return builder.build();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleFormatter)) {
            return false;
        }
        SimpleFormatter simpleFormatter = (SimpleFormatter) obj;
        if (this.type.equals(simpleFormatter.type) && this.pattern.equals(simpleFormatter.pattern) && this.locale.equals(simpleFormatter.locale) && this.leniency == simpleFormatter.leniency) {
            String str = this.tzid;
            String str2 = simpleFormatter.tzid;
            if (str == null) {
                if (str2 == null) {
                    return true;
                }
            } else if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.pattern.hashCode() * 17) + (this.locale.hashCode() * 31) + (this.tzid.hashCode() * 37);
    }

    private void print(T t, Appendable appendable) throws IOException {
        String str;
        if (this.type.equals(PlainDate.class)) {
            str = setUpLocal().format(TemporalType.JAVA_UTIL_DATE.from(PlainDate.class.cast(t).atStartOfDay().atUTC()));
        } else if (this.type.equals(PlainTime.class)) {
            str = setUpLocal().format(TemporalType.JAVA_UTIL_DATE.from(UNIX_EPOCH_DATE.at(PlainTime.class.cast(t)).atUTC()));
        } else if (this.type.equals(PlainTimestamp.class)) {
            str = setUpLocal().format(TemporalType.JAVA_UTIL_DATE.from(PlainTimestamp.class.cast(t).atUTC()));
        } else if (this.type.equals(Moment.class)) {
            Moment cast = Moment.class.cast(t);
            if (this.tzid != null) {
                String str2 = this.pattern;
                if (str2.equals(RFC_1123_PATTERN)) {
                    str2 = RFC_1123_WIDE;
                }
                str = new SimpleFormatter(ZonalDateTime.class, str2, this.locale, this.leniency, this.tzid).print(cast.inZonalView(this.tzid));
            } else {
                throw new IllegalArgumentException("Cannot print moment without timezone.");
            }
        } else if (this.type.equals(ZonalDateTime.class)) {
            ZonalDateTime cast2 = ZonalDateTime.class.cast(t);
            Moment moment = cast2.toMoment();
            Date from = TemporalType.JAVA_UTIL_DATE.from(moment);
            String str3 = this.tzid;
            if (str3 == null) {
                str3 = cast2.getTimezone().canonical();
            }
            Timezone of = Timezone.of(str3);
            SimpleDateFormat up = setUp(this.pattern, this.locale, new XCalendar(TimeZone.getTimeZone(TimeZones.GMT_ID + of.getOffset(moment).toString()), this.locale), !this.leniency.isStrict());
            FieldPosition fieldPosition = new FieldPosition(17);
            String stringBuffer = up.format(from, new StringBuffer(), fieldPosition).toString();
            int beginIndex = fieldPosition.getBeginIndex();
            int endIndex = fieldPosition.getEndIndex();
            if (endIndex <= beginIndex || beginIndex <= 0 || (of.getID() instanceof ZonalOffset) || !hasTimezoneField()) {
                str = stringBuffer;
            } else {
                boolean isDaylightSaving = of.isDaylightSaving(moment);
                str = stringBuffer.substring(0, beginIndex) + of.getDisplayName(this.pattern.contains("zzzz") ^ true ? isDaylightSaving ? NameStyle.SHORT_DAYLIGHT_TIME : NameStyle.SHORT_STANDARD_TIME : isDaylightSaving ? NameStyle.LONG_DAYLIGHT_TIME : NameStyle.LONG_STANDARD_TIME, this.locale) + stringBuffer.substring(endIndex);
            }
        } else {
            throw new IllegalArgumentException("Not formattable: " + t);
        }
        appendable.append(str);
    }

    private boolean hasTimezoneField() {
        boolean z = false;
        for (int length = this.pattern.length() - 1; length >= 0; length--) {
            char charAt = this.pattern.charAt(length);
            if (charAt == '\'') {
                z = !z;
            } else if (!z && charAt == 'z') {
                return true;
            }
        }
        return false;
    }

    private static void updateRawValues(RawValues rawValues, SimpleDateFormat simpleDateFormat) {
        if (rawValues != null) {
            rawValues.accept(new Parsed(XCalendar.class.cast(simpleDateFormat.getCalendar())));
        }
    }

    private SimpleDateFormat setUpLocal() {
        return setUp(this.pattern, this.locale, new XCalendar(TimeZone.getTimeZone(TimeZones.GMT_ID), this.locale), !this.leniency.isStrict());
    }

    private static SimpleDateFormat setUp(String str, Locale locale2, XCalendar xCalendar, boolean z) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale2);
        simpleDateFormat.setCalendar(xCalendar);
        simpleDateFormat.setLenient(z);
        return simpleDateFormat;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T parseInternal(java.lang.CharSequence r10, java.text.ParsePosition r11, net.time4j.format.RawValues r12) {
        /*
            r9 = this;
            java.lang.String r0 = r10.toString()
            java.lang.Class<T> r1 = r9.type
            java.lang.Class<net.time4j.PlainDate> r2 = net.time4j.PlainDate.class
            boolean r1 = r1.equals(r2)
            r2 = 0
            if (r1 == 0) goto L_0x002e
            java.text.SimpleDateFormat r10 = r9.setUpLocal()
            java.util.Date r11 = r10.parse(r0, r11)
            net.time4j.TemporalType<java.util.Date, net.time4j.Moment> r0 = net.time4j.TemporalType.JAVA_UTIL_DATE
            java.lang.Object r11 = r0.translate(r11)
            net.time4j.Moment r11 = (net.time4j.Moment) r11
            net.time4j.tz.ZonalOffset r0 = net.time4j.tz.ZonalOffset.UTC
            net.time4j.PlainTimestamp r11 = r11.toZonalTimestamp((net.time4j.tz.TZID) r0)
            net.time4j.PlainDate r2 = r11.getCalendarDate()
            updateRawValues(r12, r10)
            goto L_0x01ce
        L_0x002e:
            java.lang.Class<T> r1 = r9.type
            java.lang.Class<net.time4j.PlainTime> r3 = net.time4j.PlainTime.class
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0057
            java.text.SimpleDateFormat r10 = r9.setUpLocal()
            java.util.Date r11 = r10.parse(r0, r11)
            net.time4j.TemporalType<java.util.Date, net.time4j.Moment> r0 = net.time4j.TemporalType.JAVA_UTIL_DATE
            java.lang.Object r11 = r0.translate(r11)
            net.time4j.Moment r11 = (net.time4j.Moment) r11
            net.time4j.tz.ZonalOffset r0 = net.time4j.tz.ZonalOffset.UTC
            net.time4j.PlainTimestamp r11 = r11.toZonalTimestamp((net.time4j.tz.TZID) r0)
            net.time4j.PlainTime r2 = r11.getWallTime()
            updateRawValues(r12, r10)
            goto L_0x01ce
        L_0x0057:
            java.lang.Class<T> r1 = r9.type
            java.lang.Class<net.time4j.PlainTimestamp> r3 = net.time4j.PlainTimestamp.class
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x007c
            java.text.SimpleDateFormat r10 = r9.setUpLocal()
            java.util.Date r11 = r10.parse(r0, r11)
            net.time4j.TemporalType<java.util.Date, net.time4j.Moment> r0 = net.time4j.TemporalType.JAVA_UTIL_DATE
            java.lang.Object r11 = r0.translate(r11)
            net.time4j.Moment r11 = (net.time4j.Moment) r11
            net.time4j.tz.ZonalOffset r0 = net.time4j.tz.ZonalOffset.UTC
            net.time4j.PlainTimestamp r2 = r11.toZonalTimestamp((net.time4j.tz.TZID) r0)
            updateRawValues(r12, r10)
            goto L_0x01ce
        L_0x007c:
            java.lang.Class<T> r1 = r9.type
            java.lang.Class<net.time4j.Moment> r3 = net.time4j.Moment.class
            boolean r1 = r1.equals(r3)
            r3 = 0
            if (r1 == 0) goto L_0x00f0
            java.lang.String r1 = r9.pattern
            java.lang.String r4 = "<RFC-1123>"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00d0
            int r1 = r11.getIndex()
            java.lang.String r0 = r0.substring(r1)
            int r1 = r0.length()
            r4 = 4
            if (r1 < r4) goto L_0x00ac
            r1 = 3
            char r1 = r0.charAt(r1)
            r4 = 44
            if (r1 != r4) goto L_0x00ac
            java.lang.String r1 = "EEE, d MMM yyyy HH:mm:ss Z"
            goto L_0x00ae
        L_0x00ac:
            java.lang.String r1 = "d MMM yyyy HH:mm:ss Z"
        L_0x00ae:
            int r4 = r0.length()
            int r4 = r4 + -1
        L_0x00b4:
            r5 = 2
            if (r4 < 0) goto L_0x00c6
            if (r3 >= r5) goto L_0x00c6
            char r5 = r0.charAt(r4)
            r6 = 58
            if (r5 != r6) goto L_0x00c3
            int r3 = r3 + 1
        L_0x00c3:
            int r4 = r4 + -1
            goto L_0x00b4
        L_0x00c6:
            if (r3 < r5) goto L_0x00d0
            java.lang.String r0 = ":ss"
            java.lang.String r3 = ""
            java.lang.String r1 = r1.replace(r0, r3)
        L_0x00d0:
            r5 = r1
            net.time4j.format.platform.SimpleFormatter r0 = new net.time4j.format.platform.SimpleFormatter
            java.lang.Class<net.time4j.ZonalDateTime> r4 = net.time4j.ZonalDateTime.class
            java.util.Locale r6 = r9.locale
            net.time4j.format.Leniency r7 = r9.leniency
            java.lang.String r8 = r9.tzid
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r10 = r0.parseInternal(r10, r11, r12)
            net.time4j.ZonalDateTime r10 = (net.time4j.ZonalDateTime) r10
            if (r10 != 0) goto L_0x00e9
            goto L_0x01ce
        L_0x00e9:
            net.time4j.Moment r10 = r10.toMoment()
            r2 = r10
            goto L_0x01ce
        L_0x00f0:
            java.lang.Class<T> r10 = r9.type
            java.lang.Class<net.time4j.ZonalDateTime> r1 = net.time4j.ZonalDateTime.class
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x01ce
            java.lang.String r10 = r9.tzid
            if (r10 != 0) goto L_0x0101
            java.lang.String r10 = "GMT-18:00"
            goto L_0x0109
        L_0x0101:
            java.lang.String r1 = "UTC"
            java.lang.String r4 = "GMT"
            java.lang.String r10 = r10.replace(r1, r4)
        L_0x0109:
            net.time4j.format.platform.SimpleFormatter$XCalendar r1 = new net.time4j.format.platform.SimpleFormatter$XCalendar
            java.util.TimeZone r4 = java.util.TimeZone.getTimeZone(r10)
            java.util.Locale r5 = r9.locale
            r1.<init>(r4, r5)
            java.lang.String r4 = r9.pattern
            java.util.Locale r5 = r9.locale
            net.time4j.format.Leniency r6 = r9.leniency
            boolean r6 = r6.isStrict()
            r6 = r6 ^ 1
            java.text.SimpleDateFormat r4 = setUp(r4, r5, r1, r6)
            java.util.Date r4 = r4.parse(r0, r11)
            if (r4 == 0) goto L_0x01cd
            int r5 = r11.getErrorIndex()
            if (r5 < 0) goto L_0x0132
            goto L_0x01cd
        L_0x0132:
            net.time4j.format.platform.SimpleFormatter$Parsed r5 = new net.time4j.format.platform.SimpleFormatter$Parsed
            r5.<init>(r1)
            r6 = 15
            int r6 = r1.get(r6)
            r7 = 16
            int r7 = r1.get(r7)
            int r6 = r6 + r7
            r7 = -1080(0xfffffffffffffbc8, float:NaN)
            if (r6 == r7) goto L_0x01af
            java.util.TimeZone r11 = r1.getTimeZone()
            java.lang.String r11 = r11.getID()
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x015f
            java.util.TimeZone r10 = r1.getTimeZone()
            java.lang.String r10 = r10.getID()
            goto L_0x017e
        L_0x015f:
            int r10 = r6 / 1000
            net.time4j.tz.ZonalOffset r10 = net.time4j.tz.ZonalOffset.ofTotalSeconds(r10)
            java.lang.String r11 = r9.tzid
            if (r11 == 0) goto L_0x017a
            java.util.TimeZone r11 = r1.getTimeZone()
            long r0 = r4.getTime()
            int r11 = r11.getOffset(r0)
            if (r11 != r6) goto L_0x017a
            java.lang.String r10 = r9.tzid
            goto L_0x017e
        L_0x017a:
            java.lang.String r10 = r10.canonical()
        L_0x017e:
            net.time4j.tz.Timezone r10 = net.time4j.tz.Timezone.of((java.lang.String) r10)
            net.time4j.tz.TZID r10 = r10.getID()
            r5.setTimezone(r10)
            net.time4j.engine.TimeAxis r11 = net.time4j.PlainTimestamp.axis()
            net.time4j.engine.AttributeQuery r0 = r9.getAttributes()
            net.time4j.format.Leniency r1 = r9.leniency
            boolean r1 = r1.isLax()
            net.time4j.engine.TimePoint r11 = r11.createFrom((net.time4j.engine.ChronoEntity) r5, (net.time4j.engine.AttributeQuery) r0, (boolean) r1, (boolean) r3)
            net.time4j.PlainTimestamp r11 = (net.time4j.PlainTimestamp) r11
            if (r11 != 0) goto L_0x01a0
            goto L_0x01a9
        L_0x01a0:
            net.time4j.Moment r11 = r11.inTimezone(r10)
            net.time4j.ZonalDateTime r10 = r11.inZonalView((net.time4j.tz.TZID) r10)
            r2 = r10
        L_0x01a9:
            if (r12 == 0) goto L_0x01ce
            r12.accept(r5)
            goto L_0x01ce
        L_0x01af:
            int r10 = r11.getIndex()
            r11.setErrorIndex(r10)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Cannot parse text without timezone: "
            r11.append(r12)
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x01cd:
            return r2
        L_0x01ce:
            java.lang.Class<T> r10 = r9.type
            java.lang.Object r10 = r10.cast(r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.platform.SimpleFormatter.parseInternal(java.lang.CharSequence, java.text.ParsePosition, net.time4j.format.RawValues):java.lang.Object");
    }

    private static String getFormatPattern(DateFormat dateFormat) {
        if (dateFormat instanceof SimpleDateFormat) {
            return SimpleDateFormat.class.cast(dateFormat).toPattern();
        }
        throw new IllegalStateException("Cannot retrieve format pattern: " + dateFormat);
    }

    private static class Parsed extends ChronoEntity<Parsed> {
        private TZID tzid = null;
        private final Map<ChronoElement<?>, Object> values;

        public <V> boolean isValid(ChronoElement<V> chronoElement, V v) {
            return chronoElement != null;
        }

        Parsed(XCalendar xCalendar) {
            HashMap hashMap = new HashMap();
            if (xCalendar.isSet(1)) {
                hashMap.put(PlainDate.YEAR, Integer.valueOf(xCalendar.getRawValue(1)));
            }
            if (xCalendar.isSet(2)) {
                hashMap.put(PlainDate.MONTH_AS_NUMBER, Integer.valueOf(xCalendar.getRawValue(2) + 1));
            }
            if (xCalendar.isSet(6)) {
                hashMap.put(PlainDate.DAY_OF_YEAR, Integer.valueOf(xCalendar.getRawValue(6)));
            }
            if (xCalendar.isSet(5)) {
                hashMap.put(PlainDate.DAY_OF_MONTH, Integer.valueOf(xCalendar.getRawValue(5)));
            }
            if (xCalendar.isSet(9)) {
                hashMap.put(PlainTime.AM_PM_OF_DAY, Meridiem.values()[xCalendar.getRawValue(9)]);
            }
            if (xCalendar.isSet(10)) {
                hashMap.put(PlainTime.DIGITAL_HOUR_OF_AMPM, Integer.valueOf(xCalendar.getRawValue(10)));
            }
            if (xCalendar.isSet(11)) {
                hashMap.put(PlainTime.DIGITAL_HOUR_OF_DAY, Integer.valueOf(xCalendar.getRawValue(11)));
            }
            if (xCalendar.isSet(12)) {
                hashMap.put(PlainTime.MINUTE_OF_HOUR, Integer.valueOf(xCalendar.getRawValue(12)));
            }
            if (xCalendar.isSet(13)) {
                hashMap.put(PlainTime.SECOND_OF_MINUTE, Integer.valueOf(xCalendar.getRawValue(13)));
            }
            if (xCalendar.isSet(14)) {
                hashMap.put(PlainTime.MILLI_OF_SECOND, Integer.valueOf(xCalendar.getRawValue(14)));
            }
            this.values = Collections.unmodifiableMap(hashMap);
        }

        public boolean contains(ChronoElement<?> chronoElement) {
            return this.values.containsKey(chronoElement);
        }

        public <V> V get(ChronoElement<V> chronoElement) {
            check(chronoElement);
            return chronoElement.getType().cast(this.values.get(chronoElement));
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [net.time4j.engine.ChronoElement<java.lang.Integer>, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getInt(net.time4j.engine.ChronoElement<java.lang.Integer> r3) {
            /*
                r2 = this;
                java.util.Map<net.time4j.engine.ChronoElement<?>, java.lang.Object> r0 = r2.values
                boolean r0 = r0.containsKey(r3)
                if (r0 == 0) goto L_0x001b
                java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
                java.util.Map<net.time4j.engine.ChronoElement<?>, java.lang.Object> r1 = r2.values
                java.lang.Object r3 = r1.get(r3)
                java.lang.Object r3 = r0.cast(r3)
                java.lang.Integer r3 = (java.lang.Integer) r3
                int r3 = r3.intValue()
                return r3
            L_0x001b:
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.platform.SimpleFormatter.Parsed.getInt(net.time4j.engine.ChronoElement):int");
        }

        public <V> V getMinimum(ChronoElement<V> chronoElement) {
            check(chronoElement);
            return chronoElement.getDefaultMinimum();
        }

        public <V> V getMaximum(ChronoElement<V> chronoElement) {
            check(chronoElement);
            return chronoElement.getDefaultMaximum();
        }

        public <V> Parsed with(ChronoElement<V> chronoElement, V v) {
            Objects.requireNonNull(chronoElement);
            if (v == null) {
                this.values.remove(chronoElement);
            } else {
                this.values.put(chronoElement, v);
            }
            return this;
        }

        public boolean hasTimezone() {
            return this.tzid != null;
        }

        public TZID getTimezone() {
            TZID tzid2 = this.tzid;
            if (tzid2 != null) {
                return tzid2;
            }
            throw new ChronoException("Timezone was not parsed.");
        }

        public Set<ChronoElement<?>> getRegisteredElements() {
            return Collections.unmodifiableSet(this.values.keySet());
        }

        /* access modifiers changed from: package-private */
        public void setTimezone(TZID tzid2) {
            this.tzid = tzid2;
        }

        /* access modifiers changed from: protected */
        public Chronology<Parsed> getChronology() {
            throw new UnsupportedOperationException("Parsed values do not have any chronology.");
        }

        private void check(ChronoElement<?> chronoElement) {
            if (!this.values.containsKey(chronoElement)) {
                throw new ChronoException("Element not supported: " + chronoElement.name());
            }
        }
    }

    private static class XCalendar extends GregorianCalendar {
        XCalendar(TimeZone timeZone, Locale locale) {
            super(timeZone, locale);
            setGregorianChange(SimpleFormatter.PROLEPTIC_GREGORIAN);
        }

        /* access modifiers changed from: package-private */
        public int getRawValue(int i) {
            return super.internalGet(i);
        }
    }
}
