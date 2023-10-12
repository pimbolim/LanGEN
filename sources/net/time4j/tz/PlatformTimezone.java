package net.time4j.tz;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.time.DurationKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import org.apache.commons.lang3.time.TimeZones;

final class PlatformTimezone extends Timezone {
    private static final long serialVersionUID = -8432968264242113551L;
    private final transient ZonalOffset fixedOffset;
    private final TZID id;
    private final boolean strict;
    private final TimeZone tz;

    PlatformTimezone() {
        this.id = null;
        this.tz = null;
        this.strict = false;
        this.fixedOffset = null;
    }

    PlatformTimezone(TZID tzid) {
        this(tzid, TimeZone.getDefault(), false);
    }

    PlatformTimezone(TZID tzid, String str) {
        this(tzid, findZone(str), false);
    }

    private PlatformTimezone(TZID tzid, TimeZone timeZone, boolean z) {
        this.id = tzid;
        TimeZone timeZone2 = (TimeZone) timeZone.clone();
        this.tz = timeZone2;
        this.strict = z;
        if (timeZone2.useDaylightTime()) {
            this.fixedOffset = null;
            return;
        }
        String id2 = timeZone2.getID();
        if (id2.startsWith(TimeZones.GMT_ID) || id2.startsWith("Etc/") || id2.equals("Greenwich") || id2.equals("UCT") || id2.equals("UTC") || id2.equals("Universal") || id2.equals("Zulu")) {
            this.fixedOffset = fromOffsetMillis(timeZone2.getOffset(System.currentTimeMillis()));
        } else {
            this.fixedOffset = null;
        }
    }

    public TZID getID() {
        TZID tzid = this.id;
        return tzid == null ? new NamedID(TimeZone.getDefault().getID()) : tzid;
    }

    public ZonalOffset getOffset(UnixTime unixTime) {
        TimeZone timeZone;
        if (this.id == null) {
            timeZone = TimeZone.getDefault();
        } else {
            ZonalOffset zonalOffset = this.fixedOffset;
            if (zonalOffset != null) {
                return zonalOffset;
            }
            timeZone = this.tz;
        }
        return fromOffsetMillis(timeZone.getOffset(unixTime.getPosixTime() * 1000));
    }

    public ZonalOffset getStandardOffset(UnixTime unixTime) {
        TimeZone timeZone;
        if (this.id == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = this.tz;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
        gregorianCalendar.setTimeInMillis(unixTime.getPosixTime() * 1000);
        return fromOffsetMillis(gregorianCalendar.get(15));
    }

    public ZonalOffset getDaylightSavingOffset(UnixTime unixTime) {
        TimeZone timeZone;
        if (this.id == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = this.tz;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
        gregorianCalendar.setTimeInMillis(unixTime.getPosixTime() * 1000);
        return fromOffsetMillis(gregorianCalendar.get(16));
    }

    public ZonalOffset getOffset(GregorianDate gregorianDate, WallTime wallTime) {
        int i;
        int i2;
        int i3;
        int i4;
        TimeZone timeZone;
        ZonalOffset zonalOffset = this.fixedOffset;
        if (zonalOffset != null) {
            return zonalOffset;
        }
        int year = gregorianDate.getYear();
        int month = gregorianDate.getMonth();
        int dayOfMonth = gregorianDate.getDayOfMonth();
        if (wallTime.getHour() == 24) {
            long packedDate = GregorianMath.toPackedDate(MathUtils.safeAdd(GregorianMath.toMJD(gregorianDate), 1));
            int readYear = GregorianMath.readYear(packedDate);
            int readMonth = GregorianMath.readMonth(packedDate);
            i = GregorianMath.readDayOfMonth(packedDate);
            month = readMonth;
            year = readYear;
        } else {
            i = dayOfMonth;
        }
        if (year > 0) {
            i2 = year;
            i3 = 1;
        } else {
            i2 = 1 - year;
            i3 = 0;
        }
        int dayOfWeek = GregorianMath.getDayOfWeek(year, month, i) + 1;
        int i5 = dayOfWeek == 8 ? 1 : dayOfWeek;
        if (wallTime.getHour() == 24) {
            i4 = 0;
        } else {
            i4 = (((wallTime.getHour() * NikonType2MakernoteDirectory.TAG_NIKON_SCAN) + (wallTime.getMinute() * 60) + wallTime.getSecond()) * 1000) + (wallTime.getNanosecond() / DurationKt.NANOS_IN_MILLIS);
        }
        if (this.id == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = this.tz;
        }
        return fromOffsetMillis(timeZone.getOffset(i3, i2, month - 1, i, i5, i4));
    }

    public boolean isInvalid(GregorianDate gregorianDate, WallTime wallTime) {
        TimeZone timeZone;
        if (this.fixedOffset != null) {
            return false;
        }
        int year = gregorianDate.getYear();
        int month = gregorianDate.getMonth();
        int dayOfMonth = gregorianDate.getDayOfMonth();
        int hour = wallTime.getHour();
        int minute = wallTime.getMinute();
        int second = wallTime.getSecond();
        int nanosecond = wallTime.getNanosecond() / DurationKt.NANOS_IN_MILLIS;
        if (this.id == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = this.tz;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
        gregorianCalendar.set(14, nanosecond);
        GregorianCalendar gregorianCalendar2 = gregorianCalendar;
        gregorianCalendar.set(year, month - 1, dayOfMonth, hour, minute, second);
        return (gregorianCalendar2.get(1) == year && gregorianCalendar2.get(2) + 1 == month && gregorianCalendar2.get(5) == dayOfMonth && gregorianCalendar2.get(11) == hour && gregorianCalendar2.get(12) == minute && gregorianCalendar2.get(13) == second && gregorianCalendar2.get(14) == nanosecond) ? false : true;
    }

    public boolean isDaylightSaving(UnixTime unixTime) {
        TimeZone timeZone;
        if (this.fixedOffset != null) {
            return false;
        }
        if (this.id == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = this.tz;
        }
        return timeZone.inDaylightTime(new Date(unixTime.getPosixTime() * 1000));
    }

    public boolean isFixed() {
        return this.fixedOffset != null;
    }

    public TransitionHistory getHistory() {
        ZonalOffset zonalOffset = this.fixedOffset;
        if (zonalOffset == null) {
            return null;
        }
        return zonalOffset.getModel();
    }

    public boolean equals(Object obj) {
        if (obj instanceof PlatformTimezone) {
            PlatformTimezone platformTimezone = (PlatformTimezone) obj;
            if (this.id == null) {
                if (platformTimezone.id == null) {
                    return true;
                }
                return false;
            } else if (this.tz.equals(platformTimezone.tz) && this.strict == platformTimezone.strict) {
                ZonalOffset zonalOffset = this.fixedOffset;
                if (zonalOffset != null) {
                    return zonalOffset.equals(platformTimezone.fixedOffset);
                }
                if (platformTimezone.fixedOffset == null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.id == null) {
            return 0;
        }
        return this.tz.hashCode();
    }

    public String toString() {
        TimeZone timeZone;
        if (this.id == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = this.tz;
        }
        StringBuilder sb = new StringBuilder(256);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(getClass().getName());
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(timeZone);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public String getDisplayName(NameStyle nameStyle, Locale locale) {
        TimeZone timeZone;
        if (this.id == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = this.tz;
        }
        return timeZone.getDisplayName(nameStyle.isDaylightSaving(), nameStyle.isAbbreviation() ^ true ? 1 : 0, locale);
    }

    public TransitionStrategy getStrategy() {
        return this.strict ? STRICT_MODE : DEFAULT_CONFLICT_STRATEGY;
    }

    public Timezone with(TransitionStrategy transitionStrategy) {
        if (this.id == null || getStrategy() == transitionStrategy) {
            return this;
        }
        if (transitionStrategy == DEFAULT_CONFLICT_STRATEGY) {
            return new PlatformTimezone(this.id, this.tz, false);
        }
        if (transitionStrategy == STRICT_MODE) {
            return new PlatformTimezone(this.id, this.tz, true);
        }
        throw new UnsupportedOperationException(transitionStrategy.toString());
    }

    static TimeZone findZone(String str) {
        if (str.equals("Z")) {
            return TimeZone.getTimeZone("GMT+00:00");
        }
        if (str.startsWith("UTC")) {
            return TimeZone.getTimeZone(TimeZones.GMT_ID + str.substring(3));
        } else if (!str.startsWith("UT")) {
            return TimeZone.getTimeZone(str);
        } else {
            return TimeZone.getTimeZone(TimeZones.GMT_ID + str.substring(2));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isGMT() {
        TimeZone timeZone;
        if (this.id == null) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = this.tz;
        }
        return timeZone.getID().equals(TimeZones.GMT_ID);
    }

    private static ZonalOffset fromOffsetMillis(int i) {
        return ZonalOffset.ofTotalSeconds(MathUtils.floorDivide(i, 1000));
    }

    private Object readResolve() {
        if (this.id == null) {
            return new PlatformTimezone();
        }
        return new PlatformTimezone(this.id, this.tz, this.strict);
    }
}
