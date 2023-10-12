package com.henninghall.date_picker.wheelFunctions;

import com.henninghall.date_picker.pickers.Picker;
import com.henninghall.date_picker.ui.WheelChangeListener;
import com.henninghall.date_picker.wheels.Wheel;

public class AddOnChangeListener implements WheelFunction {
    /* access modifiers changed from: private */
    public final WheelChangeListener onChangeListener;

    public AddOnChangeListener(WheelChangeListener wheelChangeListener) {
        this.onChangeListener = wheelChangeListener;
    }

    public void apply(final Wheel wheel) {
        wheel.picker.setOnValueChangedListener(new Picker.OnValueChangeListener() {
            public void onValueChange() {
                AddOnChangeListener.this.onChangeListener.onChange(wheel);
            }
        });
    }
}
