package com.henninghall.date_picker;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.List;

public class DatePickerPackage implements ReactPackage {
    public static ReactApplicationContext context;

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        context = reactApplicationContext;
        return Arrays.asList(new NativeModule[]{new DatePickerModule(reactApplicationContext)});
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        context = reactApplicationContext;
        return Arrays.asList(new ViewManager[]{new DatePickerManager()});
    }
}
