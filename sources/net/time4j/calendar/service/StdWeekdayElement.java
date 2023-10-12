package net.time4j.calendar.service;

import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoEntity;

public class StdWeekdayElement<T extends ChronoEntity<T>> extends StdEnumDateElement<Weekday, T> {
    private static final long serialVersionUID = -84764920511581480L;
    private final transient Weekmodel model;

    public StdWeekdayElement(Class<T> cls, Weekmodel weekmodel) {
        super("DAY_OF_WEEK", cls, Weekday.class, 'E');
        this.model = weekmodel;
    }

    public Weekday getDefaultMinimum() {
        return this.model.getFirstDayOfWeek();
    }

    public Weekday getDefaultMaximum() {
        return this.model.getFirstDayOfWeek().roll(6);
    }

    public int numerical(Weekday weekday) {
        return weekday.getValue(this.model);
    }

    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        int value = ((Weekday) chronoDisplay.get(this)).getValue(this.model);
        int value2 = ((Weekday) chronoDisplay2.get(this)).getValue(this.model);
        if (value < value2) {
            return -1;
        }
        return value == value2 ? 0 : 1;
    }
}
