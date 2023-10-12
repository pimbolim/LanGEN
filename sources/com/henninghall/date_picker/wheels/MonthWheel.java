package com.henninghall.date_picker.wheels;

import android.graphics.Paint;
import com.henninghall.date_picker.State;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.pickers.Picker;
import java.util.ArrayList;
import java.util.Calendar;

public class MonthWheel extends Wheel {
    public String getFormatPattern() {
        return "LLLL";
    }

    public int getHorizontalPadding() {
        return 1;
    }

    public boolean wrapSelectorWheel() {
        return true;
    }

    public MonthWheel(Picker picker, State state) {
        super(picker, state);
    }

    public ArrayList<String> getValues() {
        ArrayList<String> arrayList = new ArrayList<>();
        Calendar instance = Calendar.getInstance();
        instance.set(2, 0);
        for (int i = 0; i <= 11; i++) {
            arrayList.add(getLocaleString(instance));
            instance.add(2, 1);
        }
        return arrayList;
    }

    public boolean visible() {
        return this.state.getMode() == Mode.date;
    }

    public Paint.Align getTextAlign() {
        return Paint.Align.LEFT;
    }
}
