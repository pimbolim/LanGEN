package com.henninghall.date_picker.ui;

import android.view.View;
import com.henninghall.date_picker.Emitter;
import com.henninghall.date_picker.State;
import com.henninghall.date_picker.wheels.Wheel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class WheelChangeListenerImpl implements WheelChangeListener {
    private final View rootView;
    private final State state;
    private final UIManager uiManager;
    private final Wheels wheels;

    WheelChangeListenerImpl(Wheels wheels2, State state2, UIManager uIManager, View view) {
        this.wheels = wheels2;
        this.uiManager = uIManager;
        this.state = state2;
        this.rootView = view;
    }

    private SimpleDateFormat getDateFormat() {
        TimeZone timeZone = this.state.getTimeZone();
        SimpleDateFormat dateFormat = this.uiManager.getDateFormat();
        dateFormat.setTimeZone(timeZone);
        return dateFormat;
    }

    public void onChange(Wheel wheel) {
        if (!this.wheels.hasSpinningWheel()) {
            if (!dateExists()) {
                Calendar closestExistingDateInPast = getClosestExistingDateInPast();
                if (closestExistingDateInPast != null) {
                    this.uiManager.animateToDate(closestExistingDateInPast);
                    return;
                }
                return;
            }
            Calendar selectedDate = getSelectedDate();
            if (selectedDate != null) {
                Calendar minimumDate = this.state.getMinimumDate();
                if (minimumDate == null || !selectedDate.before(minimumDate)) {
                    Calendar maximumDate = this.state.getMaximumDate();
                    if (maximumDate == null || !selectedDate.after(maximumDate)) {
                        String displayValueString = this.uiManager.getDisplayValueString();
                        this.uiManager.updateLastSelectedDate(selectedDate);
                        Emitter.onDateChange(selectedDate, displayValueString, this.rootView);
                        return;
                    }
                    this.uiManager.animateToDate(maximumDate);
                    return;
                }
                this.uiManager.animateToDate(minimumDate);
            }
        }
    }

    private boolean dateExists() {
        SimpleDateFormat dateFormat = getDateFormat();
        String dateTimeString = this.wheels.getDateTimeString();
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(dateTimeString);
            return true;
        } catch (ParseException unused) {
            return false;
        }
    }

    private Calendar getSelectedDate() {
        SimpleDateFormat dateFormat = getDateFormat();
        String dateTimeString = this.wheels.getDateTimeString();
        Calendar instance = Calendar.getInstance(this.state.getTimeZone());
        try {
            dateFormat.setLenient(true);
            instance.setTime(dateFormat.parse(dateTimeString));
            return instance;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Calendar getClosestExistingDateInPast() {
        SimpleDateFormat dateFormat = getDateFormat();
        int i = 0;
        dateFormat.setLenient(false);
        while (i < 10) {
            try {
                String dateTimeString = this.wheels.getDateTimeString(i);
                Calendar instance = Calendar.getInstance(this.state.getTimeZone());
                instance.setTime(dateFormat.parse(dateTimeString));
                return instance;
            } catch (ParseException unused) {
                i++;
            }
        }
        return null;
    }
}
