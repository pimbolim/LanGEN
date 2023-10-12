package com.henninghall.date_picker.wheelFunctions;

import com.henninghall.date_picker.wheels.Wheel;

public class Hide implements WheelFunction {
    public void apply(Wheel wheel) {
        wheel.picker.setVisibility(8);
    }
}
