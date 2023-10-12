package com.henninghall.date_picker.ui;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.henninghall.date_picker.DatePickerPackage;
import com.henninghall.date_picker.Utils;
import com.henninghall.date_picker.pickers.Picker;
import java.util.List;
import java.util.Locale;

public class Accessibility {
    private static Locale mLocale = Locale.getDefault();
    private static final AccessibilityManager systemManager = ((AccessibilityManager) DatePickerPackage.context.getApplicationContext().getSystemService("accessibility"));

    public static void setLocale(Locale locale) {
        mLocale = locale;
    }

    public static Locale getLocale() {
        return mLocale;
    }

    public static boolean shouldAllowScroll(View view) {
        if (!systemManager.isTouchExplorationEnabled()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return view.isAccessibilityFocused();
        }
        return false;
    }

    public static void startAccessibilityDelegate(final Picker picker) {
        picker.getView().setAccessibilityDelegate(new View.AccessibilityDelegate() {
            public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                int value = Picker.this.getValue();
                if (i != 4096) {
                    if (i == 8192 && !Picker.this.isSpinning()) {
                        Picker.this.smoothScrollToValue(value + 1);
                    }
                } else if (!Picker.this.isSpinning()) {
                    Picker.this.smoothScrollToValue(value - 1);
                }
                return super.performAccessibilityAction(view, i, bundle);
            }
        });
    }

    public static boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = systemManager;
        if (accessibilityManager == null) {
            return false;
        }
        return accessibilityManager.isEnabled();
    }

    public static boolean isSpokenFeedbackEnabled() {
        return hasAccessibilityFeatureTypeEnabled(1);
    }

    private static boolean hasAccessibilityFeatureTypeEnabled(int i) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = systemManager.getEnabledAccessibilityServiceList(i);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.size() > 0;
    }

    public static void announce(String str, View view) {
        if (isAccessibilityEnabled() && isSpokenFeedbackEnabled()) {
            view.announceForAccessibility(str);
        }
    }

    private static String pickerValueToDisplayedValue(Picker picker, int i) {
        String str = picker.getDisplayedValues()[i];
        if (str != null) {
            return str;
        }
        return String.valueOf(i);
    }

    public static void sendValueChangedEvent(Picker picker, int i) {
        AccessibilityEvent buildEvent = buildEvent(picker.getView(), 32);
        buildEvent.getText().add(pickerValueToDisplayedValue(picker, i));
        sendEvent(buildEvent);
    }

    private static String getContentDescriptionLabel(String str) {
        Locale locale = getLocale();
        return Utils.getLocalisedStringFromResources(locale, str + "_description");
    }

    public static String getContentDescription(Picker picker) {
        String obj = picker.getView().getTag().toString();
        String pickerValueToDisplayedValue = pickerValueToDisplayedValue(picker, picker.getValue());
        String contentDescriptionLabel = getContentDescriptionLabel(obj);
        return pickerValueToDisplayedValue + ", " + contentDescriptionLabel;
    }

    public static AccessibilityEvent buildEvent(View view, int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        obtain.setClassName(view.getClass().getName());
        obtain.setPackageName(view.getContext().getPackageName());
        return obtain;
    }

    public static void sendEvent(AccessibilityEvent accessibilityEvent) {
        AccessibilityManager accessibilityManager = systemManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            accessibilityManager.sendAccessibilityEvent(accessibilityEvent);
        }
    }

    public static void setRoleToSlider(Picker picker, AccessibilityNodeInfo accessibilityNodeInfo) {
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setScrollable(true);
        accessibilityNodeInfo.setContentDescription(getContentDescription(picker));
        if (Build.VERSION.SDK_INT >= 21) {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction = new AccessibilityNodeInfo.AccessibilityAction(4096, "Increase value");
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2 = new AccessibilityNodeInfo.AccessibilityAction(8192, "Decrease value");
            accessibilityNodeInfo.addAction(accessibilityAction);
            accessibilityNodeInfo.addAction(accessibilityAction2);
            return;
        }
        accessibilityNodeInfo.addAction(4096);
        accessibilityNodeInfo.addAction(8192);
    }
}
