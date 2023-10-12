package com.henninghall.date_picker.pickers;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.henninghall.date_picker.Utils;
import com.henninghall.date_picker.pickers.Picker;
import java.lang.reflect.Field;

public class AndroidNative extends NumberPicker implements Picker {
    private final Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean isAnimating;
    /* access modifiers changed from: private */
    public Picker.OnValueChangeListenerInScrolling listenerInScrolling;
    /* access modifiers changed from: private */
    public Picker.OnValueChangeListener onValueChangedListener;
    /* access modifiers changed from: private */
    public int state = 0;

    public View getView() {
        return this;
    }

    public void setDividerHeight(int i) {
    }

    public void setItemPaddingHorizontal(int i) {
    }

    public void setShownCount(int i) {
    }

    public void setTextAlign(Paint.Align align) {
    }

    public AndroidNative(Context context) {
        super(context);
    }

    public AndroidNative(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AndroidNative(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void smoothScrollToValue(int i, boolean z) {
        smoothScrollToValue(i);
    }

    public void setTextColor(String str) {
        int parseColor = Color.parseColor(str);
        if (Build.VERSION.SDK_INT >= 29) {
            super.setTextColor(parseColor);
            return;
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mSelectorWheelPaint");
            declaredField.setAccessible(true);
            ((Paint) declaredField.get(this)).setColor(parseColor);
        } catch (NoSuchFieldException e) {
            Log.w("setSelectedTextColor", e);
        } catch (IllegalAccessException e2) {
            Log.w("setSelectedTextColor", e2);
        } catch (IllegalArgumentException e3) {
            Log.w("setSelectedTextColor", e3);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof EditText) {
                ((EditText) childAt).setTextColor(parseColor);
            }
        }
        invalidate();
    }

    public boolean isSpinning() {
        return this.state == 2 || this.isAnimating;
    }

    public void smoothScrollToValue(int i) {
        int value = getValue();
        if (i != value) {
            int shortestScrollOption = Utils.getShortestScrollOption(value, i, getMaxValue(), getWrapSelectorWheel());
            int abs = Math.abs(shortestScrollOption);
            this.isAnimating = true;
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    boolean unused = AndroidNative.this.isAnimating = false;
                }
            }, (long) (abs * 100));
            int i2 = 0;
            while (i2 < abs) {
                changeValueByOne(shortestScrollOption > 0, i2 * 100, i2 == abs + -1);
                i2++;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        if (r9 == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0046, code lost:
        if (r9 == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        if (r9 == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        setValue((r8 + r1) % getMaxValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (r9 == false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void changeValueByOne(android.widget.NumberPicker r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r0 = "changeValueByOne"
            r1 = -1
            r2 = 1
            java.lang.Class r3 = r7.getClass()     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            r6 = 0
            r4[r6] = r5     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r0, r4)     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            r3.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r9)     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            r4[r6] = r5     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            r3.invoke(r8, r4)     // Catch:{ NoSuchMethodException -> 0x0049, IllegalArgumentException -> 0x003e, IllegalAccessException -> 0x0033, InvocationTargetException -> 0x0028 }
            goto L_0x005d
        L_0x0026:
            r8 = move-exception
            goto L_0x005e
        L_0x0028:
            r8 = move-exception
            android.util.Log.w(r0, r8)     // Catch:{ all -> 0x0026 }
            int r8 = r7.getValue()
            if (r9 == 0) goto L_0x0054
            goto L_0x0053
        L_0x0033:
            r8 = move-exception
            android.util.Log.w(r0, r8)     // Catch:{ all -> 0x0026 }
            int r8 = r7.getValue()
            if (r9 == 0) goto L_0x0054
            goto L_0x0053
        L_0x003e:
            r8 = move-exception
            android.util.Log.w(r0, r8)     // Catch:{ all -> 0x0026 }
            int r8 = r7.getValue()
            if (r9 == 0) goto L_0x0054
            goto L_0x0053
        L_0x0049:
            r8 = move-exception
            android.util.Log.w(r0, r8)     // Catch:{ all -> 0x0026 }
            int r8 = r7.getValue()
            if (r9 == 0) goto L_0x0054
        L_0x0053:
            r1 = 1
        L_0x0054:
            int r8 = r8 + r1
            int r9 = r7.getMaxValue()
            int r8 = r8 % r9
            r7.setValue(r8)
        L_0x005d:
            return
        L_0x005e:
            int r0 = r7.getValue()
            if (r9 == 0) goto L_0x0065
            r1 = 1
        L_0x0065:
            int r0 = r0 + r1
            int r9 = r7.getMaxValue()
            int r0 = r0 % r9
            r7.setValue(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.henninghall.date_picker.pickers.AndroidNative.changeValueByOne(android.widget.NumberPicker, boolean):void");
    }

    private void changeValueByOne(final boolean z, int i, final boolean z2) {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                AndroidNative.this.changeValueByOne(this, z);
                if (z2) {
                    AndroidNative.this.sendEventIn500ms();
                }
            }
        }, (long) i);
    }

    public void setOnValueChangeListenerInScrolling(Picker.OnValueChangeListenerInScrolling onValueChangeListenerInScrolling) {
        this.listenerInScrolling = onValueChangeListenerInScrolling;
    }

    public void setOnValueChangedListener(Picker.OnValueChangeListener onValueChangeListener) {
        this.onValueChangedListener = onValueChangeListener;
        super.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            public void onValueChange(NumberPicker numberPicker, int i, int i2) {
                if (AndroidNative.this.listenerInScrolling != null) {
                    AndroidNative.this.listenerInScrolling.onValueChangeInScrolling(this, i, i2);
                }
                if (AndroidNative.this.state == 0) {
                    AndroidNative.this.sendEventIn500ms();
                }
            }
        });
        super.setOnScrollListener(new NumberPicker.OnScrollListener() {
            public void onScrollStateChange(NumberPicker numberPicker, int i) {
                AndroidNative.this.sendEventIfStopped(i);
                int unused = AndroidNative.this.state = i;
            }
        });
    }

    /* access modifiers changed from: private */
    public void sendEventIfStopped(int i) {
        if (this.state != 0 && i == 0) {
            sendEventIn500ms();
        }
    }

    /* access modifiers changed from: private */
    public void sendEventIn500ms() {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                AndroidNative.this.onValueChangedListener.onValueChange();
            }
        }, 500);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.handler.removeCallbacksAndMessages((Object) null);
    }
}
