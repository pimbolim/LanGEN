package com.henninghall.date_picker;

import android.util.Log;
import com.henninghall.date_picker.models.Is24HourSource;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.models.Variant;
import com.henninghall.date_picker.models.WheelType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;

public class DerivedData {
    private final State state;

    DerivedData(State state2) {
        this.state = state2;
    }

    public ArrayList<WheelType> getVisibleWheels() {
        ArrayList<WheelType> arrayList = new ArrayList<>();
        Mode mode = this.state.getMode();
        int i = AnonymousClass1.$SwitchMap$com$henninghall$date_picker$models$Mode[mode.ordinal()];
        if (i == 1) {
            arrayList.add(WheelType.DAY);
            arrayList.add(WheelType.HOUR);
            arrayList.add(WheelType.MINUTE);
        } else if (i == 2) {
            arrayList.add(WheelType.HOUR);
            arrayList.add(WheelType.MINUTE);
        } else if (i == 3) {
            arrayList.add(WheelType.YEAR);
            arrayList.add(WheelType.MONTH);
            arrayList.add(WheelType.DATE);
        }
        if ((mode == Mode.time || mode == Mode.datetime) && this.state.derived.usesAmPm()) {
            arrayList.add(WheelType.AM_PM);
        }
        return arrayList;
    }

    public ArrayList<WheelType> getOrderedVisibleWheels() {
        ArrayList<WheelType> orderedWheels = getOrderedWheels();
        ArrayList<WheelType> visibleWheels = getVisibleWheels();
        ArrayList<WheelType> arrayList = new ArrayList<>();
        Iterator<WheelType> it = orderedWheels.iterator();
        while (it.hasNext()) {
            WheelType next = it.next();
            if (visibleWheels.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private ArrayList<WheelType> getOrderedWheels() {
        String replaceAll = LocaleUtils.getDateTimePattern(this.state.getLocale()).replaceAll("\\('(.+?)'\\)", "\\${$1}").replaceAll("'.+?'", "").replaceAll("\\$\\{(.+?)\\}", "('$1')");
        ArrayList arrayList = new ArrayList(Arrays.asList(WheelType.values()));
        ArrayList<WheelType> arrayList2 = new ArrayList<>();
        arrayList.remove(WheelType.DAY);
        arrayList2.add(WheelType.DAY);
        for (char patternCharToWheelType : replaceAll.toCharArray()) {
            try {
                WheelType patternCharToWheelType2 = Utils.patternCharToWheelType(patternCharToWheelType);
                if (arrayList.contains(patternCharToWheelType2)) {
                    arrayList.remove(patternCharToWheelType2);
                    arrayList2.add(patternCharToWheelType2);
                }
            } catch (Exception unused) {
            }
        }
        if (arrayList.contains(WheelType.AM_PM)) {
            arrayList.remove(WheelType.AM_PM);
            arrayList2.add(WheelType.AM_PM);
        }
        if (!arrayList.isEmpty()) {
            Log.e("RNDatePicker", arrayList.size() + " wheel types cannot be ordered. Wheel type 0: " + arrayList.get(0));
        }
        return arrayList2;
    }

    public int getShownCount() {
        int intValue = this.state.getHeight().intValue() / 35;
        return intValue % 2 == 0 ? intValue + 1 : intValue;
    }

    public boolean hasNativeStyle() {
        return this.state.getVariant() == Variant.nativeAndroid;
    }

    /* renamed from: com.henninghall.date_picker.DerivedData$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$henninghall$date_picker$models$Mode;
        static final /* synthetic */ int[] $SwitchMap$com$henninghall$date_picker$models$Variant;

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        static {
            /*
                com.henninghall.date_picker.models.Variant[] r0 = com.henninghall.date_picker.models.Variant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$henninghall$date_picker$models$Variant = r0
                r1 = 1
                com.henninghall.date_picker.models.Variant r2 = com.henninghall.date_picker.models.Variant.nativeAndroid     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$henninghall$date_picker$models$Variant     // Catch:{ NoSuchFieldError -> 0x001d }
                com.henninghall.date_picker.models.Variant r3 = com.henninghall.date_picker.models.Variant.iosClone     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.henninghall.date_picker.models.Mode[] r2 = com.henninghall.date_picker.models.Mode.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$henninghall$date_picker$models$Mode = r2
                com.henninghall.date_picker.models.Mode r3 = com.henninghall.date_picker.models.Mode.datetime     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$com$henninghall$date_picker$models$Mode     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.henninghall.date_picker.models.Mode r2 = com.henninghall.date_picker.models.Mode.time     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$com$henninghall$date_picker$models$Mode     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.henninghall.date_picker.models.Mode r1 = com.henninghall.date_picker.models.Mode.date     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.henninghall.date_picker.DerivedData.AnonymousClass1.<clinit>():void");
        }
    }

    public int getRootLayout() {
        int i = AnonymousClass1.$SwitchMap$com$henninghall$date_picker$models$Variant[this.state.getVariant().ordinal()];
        if (i == 1) {
            return R.layout.native_picker;
        }
        if (i != 2) {
            return R.layout.ios_clone;
        }
        return R.layout.ios_clone;
    }

    public boolean usesAmPm() {
        if (this.state.getIs24HourSource() == Is24HourSource.locale) {
            return LocaleUtils.localeUsesAmPm(this.state.getLocale());
        }
        return Utils.deviceUsesAmPm();
    }

    public boolean hasOnly2Wheels() {
        return this.state.getMode() == Mode.time && !usesAmPm();
    }

    public String getLastDate() {
        Calendar lastSelectedDate = this.state.getLastSelectedDate();
        return lastSelectedDate != null ? Utils.dateToIso(lastSelectedDate) : this.state.getIsoDate();
    }
}
