package com.henninghall.date_picker.wheels;

import android.graphics.Paint;
import com.henninghall.date_picker.State;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.pickers.Picker;
import java.util.ArrayList;
import java.util.Calendar;

public class MinutesWheel extends Wheel {
    public String getFormatPattern() {
        return "mm";
    }

    public boolean wrapSelectorWheel() {
        return true;
    }

    public MinutesWheel(Picker picker, State state) {
        super(picker, state);
    }

    public ArrayList<String> getValues() {
        Calendar instance = Calendar.getInstance();
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        instance.set(12, 0);
        while (i < 60) {
            arrayList.add(this.format.format(instance.getTime()));
            instance.add(12, this.state.getMinuteInterval());
            i += this.state.getMinuteInterval();
        }
        return arrayList;
    }

    public boolean visible() {
        return this.state.getMode() != Mode.date;
    }

    public Paint.Align getTextAlign() {
        return this.state.derived.hasOnly2Wheels() ? Paint.Align.LEFT : Paint.Align.RIGHT;
    }
}
