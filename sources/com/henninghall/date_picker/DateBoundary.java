package com.henninghall.date_picker;

import java.util.Calendar;
import java.util.TimeZone;

public class DateBoundary {
    private Calendar date;

    DateBoundary(TimeZone timeZone, String str) {
        if (str != null) {
            this.date = Utils.getTruncatedCalendarOrNull(Utils.isoToCalendar(str, timeZone));
        }
    }

    /* access modifiers changed from: protected */
    public Calendar get() {
        return this.date;
    }
}
