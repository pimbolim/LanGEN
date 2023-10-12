package net.time4j.tz.model;

import java.io.Serializable;
import net.time4j.CalendarUnit;
import net.time4j.Month;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.Weekday;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;

@CalendarType("iso8601")
public class GregorianTimezoneRule extends DaylightSavingRule implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient byte month;

    /* access modifiers changed from: protected */
    public String getCalendarType() {
        return CalendarText.ISO_CALENDAR_TYPE;
    }

    protected GregorianTimezoneRule(Month month2, int i, OffsetIndicator offsetIndicator, int i2) {
        super(i, offsetIndicator, i2);
        this.month = (byte) month2.getValue();
    }

    public static GregorianTimezoneRule ofFixedDay(Month month2, int i, PlainTime plainTime, OffsetIndicator offsetIndicator, int i2) {
        return ofFixedDay(month2, i, plainTime.getInt(PlainTime.SECOND_OF_DAY), offsetIndicator, i2);
    }

    public static GregorianTimezoneRule ofFixedDay(Month month2, int i, int i2, OffsetIndicator offsetIndicator, int i3) {
        return new FixedDayPattern(month2, i, i2, offsetIndicator, i3);
    }

    public static GregorianTimezoneRule ofLastWeekday(Month month2, Weekday weekday, PlainTime plainTime, OffsetIndicator offsetIndicator, int i) {
        return ofLastWeekday(month2, weekday, plainTime.getInt(PlainTime.SECOND_OF_DAY), offsetIndicator, i);
    }

    public static GregorianTimezoneRule ofLastWeekday(Month month2, Weekday weekday, int i, OffsetIndicator offsetIndicator, int i2) {
        return new LastWeekdayPattern(month2, weekday, i, offsetIndicator, i2);
    }

    public static GregorianTimezoneRule ofWeekdayAfterDate(Month month2, int i, Weekday weekday, PlainTime plainTime, OffsetIndicator offsetIndicator, int i2) {
        return ofWeekdayAfterDate(month2, i, weekday, plainTime.getInt(PlainTime.SECOND_OF_DAY), offsetIndicator, i2);
    }

    public static GregorianTimezoneRule ofWeekdayAfterDate(Month month2, int i, Weekday weekday, int i2, OffsetIndicator offsetIndicator, int i3) {
        return new DayOfWeekInMonthPattern(month2, i, weekday, i2, offsetIndicator, i3, true);
    }

    public static GregorianTimezoneRule ofWeekdayBeforeDate(Month month2, int i, Weekday weekday, PlainTime plainTime, OffsetIndicator offsetIndicator, int i2) {
        return ofWeekdayBeforeDate(month2, i, weekday, plainTime.getInt(PlainTime.SECOND_OF_DAY), offsetIndicator, i2);
    }

    public static GregorianTimezoneRule ofWeekdayBeforeDate(Month month2, int i, Weekday weekday, int i2, OffsetIndicator offsetIndicator, int i3) {
        return new DayOfWeekInMonthPattern(month2, i, weekday, i2, offsetIndicator, i3, false);
    }

    public final PlainDate getDate(int i) {
        return (PlainDate) getDate0(i).plus(getDayOverflow(), CalendarUnit.DAYS);
    }

    public Month getMonth() {
        return Month.valueOf((int) this.month);
    }

    /* access modifiers changed from: protected */
    public PlainDate getDate0(int i) {
        throw new AbstractMethodError("Implemented by subclasses.");
    }

    /* access modifiers changed from: protected */
    public int toCalendarYear(long j) {
        return GregorianMath.readYear(GregorianMath.toPackedDate(j));
    }

    /* access modifiers changed from: protected */
    public int toCalendarYear(GregorianDate gregorianDate) {
        return gregorianDate.getYear();
    }

    /* access modifiers changed from: protected */
    public boolean isEqual(GregorianTimezoneRule gregorianTimezoneRule) {
        return getTimeOfDay().equals(gregorianTimezoneRule.getTimeOfDay()) && getDayOverflow() == gregorianTimezoneRule.getDayOverflow() && getIndicator() == gregorianTimezoneRule.getIndicator() && getSavings() == gregorianTimezoneRule.getSavings() && this.month == gregorianTimezoneRule.month;
    }

    /* access modifiers changed from: package-private */
    public byte getMonthValue() {
        return this.month;
    }
}
