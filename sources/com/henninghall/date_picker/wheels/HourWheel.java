package com.henninghall.date_picker.wheels;

import android.graphics.Paint;
import com.henninghall.date_picker.State;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.pickers.Picker;
import java.util.ArrayList;
import java.util.Calendar;

public class HourWheel extends Wheel {
    public boolean wrapSelectorWheel() {
        return true;
    }

    public HourWheel(Picker picker, State state) {
        super(picker, state);
    }

    public ArrayList<String> getValues() {
        Calendar instance = Calendar.getInstance();
        instance.set(2000, 0, 0, 0, 0, 0);
        ArrayList<String> arrayList = new ArrayList<>();
        int i = this.state.derived.usesAmPm() ? 12 : 24;
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(this.format.format(instance.getTime()));
            instance.add(11, 1);
        }
        return arrayList;
    }

    public boolean visible() {
        return this.state.getMode() != Mode.date;
    }

    public String getFormatPattern() {
        return this.state.derived.usesAmPm() ? "h" : "HH";
    }

    public Paint.Align getTextAlign() {
        return Paint.Align.RIGHT;
    }
}
