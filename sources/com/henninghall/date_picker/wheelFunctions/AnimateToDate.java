package com.henninghall.date_picker.wheelFunctions;

import com.henninghall.date_picker.wheels.Wheel;
import java.util.Calendar;

public class AnimateToDate implements WheelFunction {
    private Calendar date;

    public AnimateToDate(Calendar calendar) {
        this.date = calendar;
    }

    public void apply(Wheel wheel) {
        wheel.animateToDate(this.date);
    }
}
