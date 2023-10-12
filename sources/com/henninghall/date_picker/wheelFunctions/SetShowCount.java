package com.henninghall.date_picker.wheelFunctions;

import com.henninghall.date_picker.wheels.Wheel;

public class SetShowCount implements WheelFunction {
    private final int count;

    public SetShowCount(int i) {
        this.count = i;
    }

    public void apply(Wheel wheel) {
        wheel.picker.setShownCount(this.count);
    }
}
