package net.time4j.calendar;

import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ElementRule;

class WeekdayRule<D extends CalendarDate> implements ElementRule<D, Weekday> {
    private final ChronoFunction<D, CalendarSystem<D>> calsysFunc;
    private final Weekmodel stdWeekmodel;

    public ChronoElement<?> getChildAtCeiling(D d) {
        return null;
    }

    public ChronoElement<?> getChildAtFloor(D d) {
        return null;
    }

    WeekdayRule(Weekmodel weekmodel, ChronoFunction<D, CalendarSystem<D>> chronoFunction) {
        this.stdWeekmodel = weekmodel;
        this.calsysFunc = chronoFunction;
    }

    public Weekday getValue(D d) {
        return getWeekday(d.getDaysSinceEpochUTC());
    }

    public Weekday getMinimum(D d) {
        CalendarSystem apply = this.calsysFunc.apply(d);
        if ((d.getDaysSinceEpochUTC() + 1) - ((long) getValue(d).getValue(this.stdWeekmodel)) < apply.getMinimumSinceUTC()) {
            return getWeekday(apply.getMinimumSinceUTC());
        }
        return this.stdWeekmodel.getFirstDayOfWeek();
    }

    public Weekday getMaximum(D d) {
        CalendarSystem apply = this.calsysFunc.apply(d);
        if ((d.getDaysSinceEpochUTC() + 7) - ((long) getValue(d).getValue(this.stdWeekmodel)) > apply.getMaximumSinceUTC()) {
            return getWeekday(apply.getMaximumSinceUTC());
        }
        return this.stdWeekmodel.getFirstDayOfWeek().roll(6);
    }

    public boolean isValid(D d, Weekday weekday) {
        if (weekday == null) {
            return false;
        }
        int value = getValue(d).getValue(this.stdWeekmodel);
        long daysSinceEpochUTC = (d.getDaysSinceEpochUTC() + ((long) weekday.getValue(this.stdWeekmodel))) - ((long) value);
        CalendarSystem apply = this.calsysFunc.apply(d);
        if (daysSinceEpochUTC < apply.getMinimumSinceUTC() || daysSinceEpochUTC > apply.getMaximumSinceUTC()) {
            return false;
        }
        return true;
    }

    public D withValue(D d, Weekday weekday, boolean z) {
        if (weekday != null) {
            int value = getValue(d).getValue(this.stdWeekmodel);
            long daysSinceEpochUTC = (d.getDaysSinceEpochUTC() + ((long) weekday.getValue(this.stdWeekmodel))) - ((long) value);
            CalendarSystem apply = this.calsysFunc.apply(d);
            if (daysSinceEpochUTC >= apply.getMinimumSinceUTC() && daysSinceEpochUTC <= apply.getMaximumSinceUTC()) {
                return (CalendarDate) apply.transform(daysSinceEpochUTC);
            }
            throw new IllegalArgumentException("New day out of supported range.");
        }
        throw new IllegalArgumentException("Missing weekday.");
    }

    private static Weekday getWeekday(long j) {
        return Weekday.valueOf(MathUtils.floorModulo(j + 5, 7) + 1);
    }
}
