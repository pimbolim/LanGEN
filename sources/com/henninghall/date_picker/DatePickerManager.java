package com.henninghall.date_picker;

import android.widget.LinearLayout;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import java.lang.reflect.Method;
import java.util.Map;

public class DatePickerManager extends SimpleViewManager<PickerView> {
    private static final String REACT_CLASS = "DatePickerManager";
    private static final int SCROLL = 1;

    public String getName() {
        return REACT_CLASS;
    }

    public PickerView createViewInstance(ThemedReactContext themedReactContext) {
        return new PickerView(new LinearLayout.LayoutParams(-1, -1));
    }

    @ReactPropGroup(names = {"date", "mode", "locale", "maximumDate", "minimumDate", "fadeToColor", "textColor", "utc", "minuteInterval", "androidVariant", "dividerHeight", "is24hourSource"})
    public void setProps(PickerView pickerView, int i, Dynamic dynamic) {
        updateProp("setProps", pickerView, i, dynamic);
    }

    @ReactPropGroup(customType = "Style", names = {"height"})
    public void setStyle(PickerView pickerView, int i, Dynamic dynamic) {
        updateProp("setStyle", pickerView, i, dynamic);
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of(ViewProps.SCROLL, 1);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(PickerView pickerView) {
        super.onAfterUpdateTransaction(pickerView);
        try {
            pickerView.update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receiveCommand(PickerView pickerView, int i, ReadableArray readableArray) {
        if (i == 1) {
            pickerView.scroll(readableArray.getInt(0), readableArray.getInt(1));
        }
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("dateChange", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onChange"))).build();
    }

    private void updateProp(String str, PickerView pickerView, int i, Dynamic dynamic) {
        pickerView.updateProp(getMethodAnnotation(str).names()[i], dynamic);
    }

    private ReactPropGroup getMethodAnnotation(String str) {
        Method method = null;
        for (Method method2 : getClass().getMethods()) {
            if (method2.getName().equals(str)) {
                method = method2;
            }
        }
        return (ReactPropGroup) method.getAnnotation(ReactPropGroup.class);
    }
}
