package com.henninghall.date_picker.wheels;

import android.graphics.Paint;
import com.henninghall.date_picker.State;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.pickers.Picker;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

public abstract class Wheel {
    public SimpleDateFormat format;
    public Picker picker;
    protected final State state;
    private Calendar userSetValue;
    private ArrayList<String> values = new ArrayList<>();

    public abstract String getFormatPattern();

    public abstract Paint.Align getTextAlign();

    public abstract ArrayList<String> getValues();

    public String toDisplayValue(String str) {
        return str;
    }

    public abstract boolean visible();

    public abstract boolean wrapSelectorWheel();

    public Wheel(Picker picker2, State state2) {
        this.state = state2;
        this.picker = picker2;
        this.format = new SimpleDateFormat(getFormatPattern(), state2.getLocale());
        picker2.setTextAlign(getTextAlign());
        picker2.setWrapSelectorWheel(wrapSelectorWheel());
    }

    private int getIndexOfDate(Calendar calendar) {
        this.format.setTimeZone(this.state.getTimeZone());
        return this.values.indexOf(this.format.format(calendar.getTime()));
    }

    public void animateToDate(Calendar calendar) {
        this.picker.smoothScrollToValue(getIndexOfDate(calendar));
    }

    public String getValue() {
        if (!visible()) {
            return this.format.format(this.userSetValue.getTime());
        }
        return getValueAtIndex(getIndex());
    }

    public String getPastValue(int i) {
        if (!visible()) {
            return this.format.format(this.userSetValue.getTime());
        }
        int size = this.values.size();
        return getValueAtIndex(((getIndex() + size) - i) % size);
    }

    private int getIndex() {
        return this.picker.getValue();
    }

    public String getValueAtIndex(int i) {
        return this.values.get(i);
    }

    public void setValue(Calendar calendar) {
        this.format.setTimeZone(this.state.getTimeZone());
        this.userSetValue = calendar;
        int indexOfDate = getIndexOfDate(calendar);
        if (indexOfDate <= -1) {
            return;
        }
        if (this.picker.getValue() == 0) {
            this.picker.setValue(indexOfDate);
        } else {
            this.picker.smoothScrollToValue(indexOfDate);
        }
    }

    public void refresh() {
        this.format = new SimpleDateFormat(getFormatPattern(), this.state.getLocale());
        if (visible()) {
            init();
        }
    }

    public String getDisplayValue() {
        return toDisplayValue(getValueAtIndex(getIndex()));
    }

    private String[] getDisplayValues(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(toDisplayValue(it.next()));
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }

    private void init() {
        this.picker.setMinValue(0);
        this.picker.setMaxValue(0);
        ArrayList<String> values2 = getValues();
        this.values = values2;
        this.picker.setDisplayedValues(getDisplayValues(values2));
        this.picker.setMaxValue(this.values.size() - 1);
    }

    public void updateVisibility() {
        this.picker.setVisibility(visible() ? 0 : 8);
    }

    private SimpleDateFormat getFormat(Locale locale) {
        return new SimpleDateFormat(getFormatPattern(), locale);
    }

    /* access modifiers changed from: package-private */
    public String getLocaleString(Calendar calendar) {
        return getString(calendar, this.state.getLocale());
    }

    private String getString(Calendar calendar, Locale locale) {
        return getFormat(locale).format(calendar.getTime());
    }

    public void setHorizontalPadding() {
        this.picker.setItemPaddingHorizontal(getHorizontalPadding());
    }

    public int getHorizontalPadding() {
        Mode mode = this.state.getMode();
        if (this.state.derived.hasOnly2Wheels()) {
            return 10;
        }
        return AnonymousClass1.$SwitchMap$com$henninghall$date_picker$models$Mode[mode.ordinal()] != 1 ? 5 : 15;
    }

    /* renamed from: com.henninghall.date_picker.wheels.Wheel$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$henninghall$date_picker$models$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.henninghall.date_picker.models.Mode[] r0 = com.henninghall.date_picker.models.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$henninghall$date_picker$models$Mode = r0
                com.henninghall.date_picker.models.Mode r1 = com.henninghall.date_picker.models.Mode.date     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$henninghall$date_picker$models$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.henninghall.date_picker.models.Mode r1 = com.henninghall.date_picker.models.Mode.time     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$henninghall$date_picker$models$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.henninghall.date_picker.models.Mode r1 = com.henninghall.date_picker.models.Mode.datetime     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.henninghall.date_picker.wheels.Wheel.AnonymousClass1.<clinit>():void");
        }
    }
}
