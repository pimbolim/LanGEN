package com.henninghall.date_picker.wheelFunctions;

import com.henninghall.date_picker.wheels.Wheel;

public class TextColor implements WheelFunction {
    private final String color;

    public TextColor(String str) {
        this.color = str;
    }

    public void apply(Wheel wheel) {
        wheel.picker.setTextColor(this.color);
    }
}
