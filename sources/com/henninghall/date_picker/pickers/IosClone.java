package com.henninghall.date_picker.pickers;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import cn.carbswang.android.numberpickerview.library.NumberPickerView;
import com.henninghall.date_picker.pickers.Picker;
import com.henninghall.date_picker.ui.Accessibility;

public class IosClone extends NumberPickerView implements Picker {
    /* access modifiers changed from: private */
    public Picker.OnValueChangeListenerInScrolling mOnValueChangeListenerInScrolling;

    public View getView() {
        return this;
    }

    public IosClone(Context context) {
        super(context);
        init();
    }

    public IosClone(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public IosClone(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        initAccessibility();
        initSetOnValueChangeListenerInScrolling();
    }

    private void initAccessibility() {
        Accessibility.startAccessibilityDelegate(this);
    }

    private void initSetOnValueChangeListenerInScrolling() {
        super.setOnValueChangeListenerInScrolling(new NumberPickerView.OnValueChangeListenerInScrolling() {
            public void onValueChangeInScrolling(NumberPickerView numberPickerView, int i, int i2) {
                Accessibility.sendValueChangedEvent(this, i2);
                if (IosClone.this.mOnValueChangeListenerInScrolling != null) {
                    IosClone.this.mOnValueChangeListenerInScrolling.onValueChangeInScrolling(this, i, i2);
                }
            }
        });
    }

    public void setTextColor(String str) {
        int parseColor = Color.parseColor(str);
        setNormalTextColor(Color.parseColor("#70" + str.substring(1)));
        setSelectedTextColor(parseColor);
    }

    public void setOnValueChangeListenerInScrolling(Picker.OnValueChangeListenerInScrolling onValueChangeListenerInScrolling) {
        this.mOnValueChangeListenerInScrolling = onValueChangeListenerInScrolling;
    }

    public void setOnValueChangedListener(final Picker.OnValueChangeListener onValueChangeListener) {
        super.setOnValueChangedListener(new NumberPickerView.OnValueChangeListener() {
            public void onValueChange(NumberPickerView numberPickerView, int i, int i2) {
                onValueChangeListener.onValueChange();
            }
        });
    }

    public boolean isSpinning() {
        return super.isScrolling();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (Accessibility.shouldAllowScroll(this)) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        Accessibility.setRoleToSlider(this, accessibilityNodeInfo);
    }
}
