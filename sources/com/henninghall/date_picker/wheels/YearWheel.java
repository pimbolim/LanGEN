package com.henninghall.date_picker.wheels;

import android.graphics.Paint;
import com.henninghall.date_picker.LocaleUtils;
import com.henninghall.date_picker.State;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.pickers.Picker;
import java.util.ArrayList;
import java.util.Calendar;

public class YearWheel extends Wheel {
    private int defaultEndYear = 2100;
    private int defaultStartYear = 1900;

    public boolean wrapSelectorWheel() {
        return false;
    }

    public YearWheel(Picker picker, State state) {
        super(picker, state);
    }

    public ArrayList<String> getValues() {
        ArrayList<String> arrayList = new ArrayList<>();
        Calendar instance = Calendar.getInstance();
        int startYear = getStartYear();
        int endYear = getEndYear() - startYear;
        instance.set(1, startYear);
        for (int i = 0; i <= endYear; i++) {
            arrayList.add(getLocaleString(instance));
            instance.add(1, 1);
        }
        return arrayList;
    }

    private int getEndYear() {
        if (this.state.getMaximumDate() == null) {
            return this.defaultEndYear;
        }
        return this.state.getMaximumDate().get(1);
    }

    private int getStartYear() {
        if (this.state.getMinimumDate() == null) {
            return this.defaultStartYear;
        }
        return this.state.getMinimumDate().get(1);
    }

    public boolean visible() {
        return this.state.getMode() == Mode.date;
    }

    public Paint.Align getTextAlign() {
        return Paint.Align.RIGHT;
    }

    public String getFormatPattern() {
        return LocaleUtils.getYear(this.state.getLocaleLanguageTag());
    }
}
