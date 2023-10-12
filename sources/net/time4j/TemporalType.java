package net.time4j;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import net.time4j.base.MathUtils;
import net.time4j.engine.Converter;
import net.time4j.scale.TimeScale;
import net.time4j.tz.Timezone;

public abstract class TemporalType<S, T> implements Converter<S, T> {
    public static final TemporalType<Calendar, ZonalDateTime> JAVA_UTIL_CALENDAR = new CalendarRule();
    public static final TemporalType<Date, Moment> JAVA_UTIL_DATE = new JavaUtilDateRule();
    public static final TemporalType<TimeZone, Timezone> JAVA_UTIL_TIMEZONE = new ZoneRule();
    private static final String JUT_PROVIDER = "java.util.TimeZone~";
    public static final TemporalType<Long, Moment> MILLIS_SINCE_UNIX = new MillisSinceUnixRule();
    private static final int MIO = 1000000;

    public abstract S from(T t);

    public abstract T translate(S s);

    protected TemporalType() {
    }

    private static class JavaUtilDateRule extends TemporalType<Date, Moment> {
        private JavaUtilDateRule() {
        }

        public Moment translate(Date date) {
            long time = date.getTime();
            return Moment.of(MathUtils.floorDivide(time, 1000), MathUtils.floorModulo(time, 1000) * 1000000, TimeScale.POSIX);
        }

        public Date from(Moment moment) {
            return new Date(MathUtils.safeAdd(MathUtils.safeMultiply(moment.getPosixTime(), 1000), (long) (moment.getNanosecond() / 1000000)));
        }

        public Class<Date> getSourceType() {
            return Date.class;
        }
    }

    private static class MillisSinceUnixRule extends TemporalType<Long, Moment> {
        private MillisSinceUnixRule() {
        }

        public Moment translate(Long l) {
            long longValue = l.longValue();
            return Moment.of(MathUtils.floorDivide(longValue, 1000), MathUtils.floorModulo(longValue, 1000) * 1000000, TimeScale.POSIX);
        }

        public Long from(Moment moment) {
            return Long.valueOf(MathUtils.safeAdd(MathUtils.safeMultiply(moment.getPosixTime(), 1000), (long) (moment.getNanosecond() / 1000000)));
        }

        public Class<Long> getSourceType() {
            return Long.class;
        }
    }

    private static class CalendarRule extends TemporalType<Calendar, ZonalDateTime> {
        private CalendarRule() {
        }

        public ZonalDateTime translate(Calendar calendar) {
            return ZonalDateTime.of(TemporalType.JAVA_UTIL_DATE.translate(calendar.getTime()), TemporalType.JAVA_UTIL_TIMEZONE.translate(calendar.getTimeZone()));
        }

        public Calendar from(ZonalDateTime zonalDateTime) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
            gregorianCalendar.setFirstDayOfWeek(2);
            gregorianCalendar.setMinimalDaysInFirstWeek(4);
            gregorianCalendar.setTimeZone(TemporalType.JAVA_UTIL_TIMEZONE.from(zonalDateTime.getTimezone0()));
            gregorianCalendar.setTime(TemporalType.JAVA_UTIL_DATE.from(zonalDateTime.toMoment()));
            return gregorianCalendar;
        }

        public Class<Calendar> getSourceType() {
            return Calendar.class;
        }
    }

    private static class ZoneRule extends TemporalType<TimeZone, Timezone> {
        private ZoneRule() {
        }

        public Timezone translate(TimeZone timeZone) {
            if (timeZone instanceof OldApiTimezone) {
                return ((OldApiTimezone) timeZone).getDelegate();
            }
            return Timezone.of(TemporalType.JUT_PROVIDER + timeZone.getID());
        }

        public TimeZone from(Timezone timezone) {
            if (timezone.getHistory() != null) {
                return new OldApiTimezone(timezone);
            }
            String canonical = timezone.getID().canonical();
            if (canonical.startsWith(TemporalType.JUT_PROVIDER)) {
                canonical = canonical.substring(19);
            }
            return TimeZone.getTimeZone(canonical);
        }

        public Class<TimeZone> getSourceType() {
            return TimeZone.class;
        }
    }
}
