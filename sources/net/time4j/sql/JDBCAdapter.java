package net.time4j.sql;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import net.time4j.ClockUnit;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.PlainTimestamp;
import net.time4j.TemporalType;
import net.time4j.base.MathUtils;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoException;
import net.time4j.engine.EpochDays;
import net.time4j.scale.TimeScale;
import net.time4j.tz.Timezone;
import org.apache.commons.lang3.time.DateUtils;

public abstract class JDBCAdapter<S, T> extends TemporalType<S, T> {
    public static final JDBCAdapter<Date, PlainDate> SQL_DATE = new SqlDateRule();
    public static final JDBCAdapter<Time, PlainTime> SQL_TIME = new SqlTimeRule();
    public static final JDBCAdapter<Timestamp, PlainTimestamp> SQL_TIMESTAMP = new SqlTimestampRule();
    public static final JDBCAdapter<Timestamp, Moment> SQL_TIMESTAMP_WITH_ZONE = new SqlMomentRule();
    /* access modifiers changed from: private */
    public static final PlainDate UNIX_DATE = PlainDate.of(0, EpochDays.UNIX);
    /* access modifiers changed from: private */
    public static final boolean WITH_SQL_UTC_CONVERSION = Boolean.getBoolean("net.time4j.sql.utc.conversion");

    private JDBCAdapter() {
    }

    private static class SqlDateRule extends JDBCAdapter<Date, PlainDate> {
        private SqlDateRule() {
            super();
        }

        public PlainDate translate(Date date) {
            long time = date.getTime();
            if (!JDBCAdapter.WITH_SQL_UTC_CONVERSION) {
                time += (long) (Timezone.ofSystem().getOffset(Moment.of(MathUtils.floorDivide(time, 1000), TimeScale.POSIX)).getIntegralAmount() * 1000);
            }
            return PlainDate.axis().getCalendarSystem().transform(MathUtils.floorDivide(time, 86400000) - 730);
        }

        public Date from(PlainDate plainDate) {
            int year = plainDate.getYear();
            if (year < 1900 || year > 9999) {
                throw new ChronoException("SQL-Date is only defined in year range of 1900-9999.");
            }
            long safeMultiply = MathUtils.safeMultiply(((Long) plainDate.get(EpochDays.UNIX)).longValue(), (long) DateUtils.MILLIS_PER_DAY);
            if (!JDBCAdapter.WITH_SQL_UTC_CONVERSION) {
                safeMultiply -= (long) (Timezone.ofSystem().getOffset(plainDate, PlainTime.of(0)).getIntegralAmount() * 1000);
            }
            return new Date(safeMultiply);
        }

        public Class<Date> getSourceType() {
            return Date.class;
        }
    }

    private static class SqlTimeRule extends JDBCAdapter<Time, PlainTime> {
        private SqlTimeRule() {
            super();
        }

        public PlainTime translate(Time time) {
            long time2 = time.getTime();
            if (!JDBCAdapter.WITH_SQL_UTC_CONVERSION) {
                time2 += (long) (Timezone.ofSystem().getOffset(Moment.of(MathUtils.floorDivide(time2, 1000), TimeScale.POSIX)).getIntegralAmount() * 1000);
            }
            return (PlainTime) PlainTime.midnightAtStartOfDay().with((ChronoElement<Integer>) PlainTime.MILLI_OF_DAY, MathUtils.floorModulo(time2, 86400000));
        }

        public Time from(PlainTime plainTime) {
            long j = (long) plainTime.getInt(PlainTime.MILLI_OF_DAY);
            if (!JDBCAdapter.WITH_SQL_UTC_CONVERSION) {
                j -= (long) (Timezone.ofSystem().getOffset(JDBCAdapter.UNIX_DATE, plainTime).getIntegralAmount() * 1000);
            }
            return new Time(j);
        }

        public Class<Time> getSourceType() {
            return Time.class;
        }
    }

    private static class SqlTimestampRule extends JDBCAdapter<Timestamp, PlainTimestamp> {
        private SqlTimestampRule() {
            super();
        }

        public PlainTimestamp translate(Timestamp timestamp) {
            long time = timestamp.getTime();
            if (!JDBCAdapter.WITH_SQL_UTC_CONVERSION) {
                time += (long) (Timezone.ofSystem().getOffset(Moment.of(MathUtils.floorDivide(time, 1000), TimeScale.POSIX)).getIntegralAmount() * 1000);
            }
            return (PlainTimestamp) PlainTimestamp.of(PlainDate.of(MathUtils.floorDivide(time, 86400000), EpochDays.UNIX), (PlainTime) PlainTime.of(0).plus((long) MathUtils.floorModulo(time, 86400000), ClockUnit.MILLIS)).with((ChronoElement<Integer>) PlainTime.NANO_OF_SECOND, timestamp.getNanos());
        }

        public Timestamp from(PlainTimestamp plainTimestamp) {
            long safeMultiply = MathUtils.safeMultiply(((Long) plainTimestamp.getCalendarDate().get(EpochDays.UNIX)).longValue(), (long) DateUtils.MILLIS_PER_DAY);
            long j = (long) plainTimestamp.getInt(PlainTime.MILLI_OF_DAY);
            if (!JDBCAdapter.WITH_SQL_UTC_CONVERSION) {
                j -= (long) (Timezone.ofSystem().getOffset(plainTimestamp, plainTimestamp).getIntegralAmount() * 1000);
            }
            Timestamp timestamp = new Timestamp(MathUtils.safeAdd(safeMultiply, j));
            timestamp.setNanos(plainTimestamp.getInt(PlainTime.NANO_OF_SECOND));
            return timestamp;
        }

        public Class<Timestamp> getSourceType() {
            return Timestamp.class;
        }
    }

    private static class SqlMomentRule extends JDBCAdapter<Timestamp, Moment> {
        private SqlMomentRule() {
            super();
        }

        public Moment translate(Timestamp timestamp) {
            try {
                return Moment.of(MathUtils.floorDivide(timestamp.getTime(), 1000), timestamp.getNanos(), TimeScale.POSIX);
            } catch (IllegalArgumentException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        public Timestamp from(Moment moment) {
            Timestamp timestamp = new Timestamp(MathUtils.safeMultiply(moment.getPosixTime(), 1000));
            timestamp.setNanos(moment.getNanosecond());
            return timestamp;
        }

        public Class<Timestamp> getSourceType() {
            return Timestamp.class;
        }
    }
}
