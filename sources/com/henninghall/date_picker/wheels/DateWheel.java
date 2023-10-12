package com.henninghall.date_picker.wheels;

import android.graphics.Paint;
import com.henninghall.date_picker.LocaleUtils;
import com.henninghall.date_picker.State;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.pickers.Picker;
import java.util.ArrayList;
import java.util.Calendar;

public class DateWheel extends Wheel {
    public boolean wrapSelectorWheel() {
        return true;
    }

    public DateWheel(Picker picker, State state) {
        super(picker, state);
    }

    public ArrayList<String> getValues() {
        Calendar instance = Calendar.getInstance();
        ArrayList<String> arrayList = new ArrayList<>();
        instance.set(2, 0);
        instance.set(5, 1);
        for (int i = 1; i <= 31; i++) {
            arrayList.add(getLocaleString(instance));
            instance.add(5, 1);
        }
        return arrayList;
    }

    public boolean visible() {
        return this.state.getMode() == Mode.date;
    }

    public String getFormatPattern() {
        return LocaleUtils.getDate(this.state.getLocaleLanguageTag());
    }

    public Paint.Align getTextAlign() {
        return Paint.Align.RIGHT;
    }
}
