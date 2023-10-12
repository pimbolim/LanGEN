package com.henninghall.date_picker.wheelFunctions;

import com.henninghall.date_picker.wheels.Wheel;
import java.util.Calendar;

public class SetDate implements WheelFunction {
    private Calendar date;

    public SetDate(Calendar calendar) {
        this.date = calendar;
    }

    public void apply(Wheel wheel) {
        wheel.setValue(this.date);
    }
}
