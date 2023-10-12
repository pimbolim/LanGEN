package com.henninghall.date_picker.wheels;

import android.graphics.Paint;
import com.henninghall.date_picker.State;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.pickers.Picker;
import java.util.ArrayList;
import java.util.Calendar;

public class AmPmWheel extends Wheel {
    public boolean wrapSelectorWheel() {
        return false;
    }

    public AmPmWheel(Picker picker, State state) {
        super(picker, state);
    }

    public ArrayList<String> getValues() {
        Calendar instance = Calendar.getInstance();
        instance.set(2000, 0, 0, 0, 0, 0);
        ArrayList<String> arrayList = new ArrayList<>();
        instance.set(11, 0);
        arrayList.add(this.format.format(instance.getTime()));
        instance.add(11, 12);
        arrayList.add(this.format.format(instance.getTime()));
        return arrayList;
    }

    public boolean visible() {
        return this.state.derived.usesAmPm() && this.state.getMode() != Mode.date;
    }

    public String getFormatPattern() {
        return this.state.derived.usesAmPm() ? " a " : "";
    }

    public Paint.Align getTextAlign() {
        return Paint.Align.RIGHT;
    }
}
