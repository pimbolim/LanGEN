package com.reactnativecommunity.slider;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactSliderManager extends SimpleViewManager<ReactSlider> {
    private static final SeekBar.OnSeekBarChangeListener ON_CHANGE_LISTENER = new SeekBar.OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            ((UIManagerModule) ((ReactContext) seekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSliderEvent(seekBar.getId(), ((ReactSlider) seekBar).toRealProgress(i), z));
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ((UIManagerModule) ((ReactContext) seekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSlidingStartEvent(seekBar.getId(), ((ReactSlider) seekBar).toRealProgress(seekBar.getProgress())));
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ((UIManagerModule) ((ReactContext) seekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSlidingCompleteEvent(seekBar.getId(), ((ReactSlider) seekBar).toRealProgress(seekBar.getProgress())));
        }
    };
    public static final String REACT_CLASS = "RNCSlider";
    private static final int STYLE = 16842875;

    public String getName() {
        return REACT_CLASS;
    }

    static class ReactSliderShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        private int mHeight;
        private boolean mMeasured;
        private int mWidth;

        private ReactSliderShadowNode() {
            initMeasureFunction();
        }

        private void initMeasureFunction() {
            setMeasureFunction(this);
        }

        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            if (!this.mMeasured) {
                ReactSlider reactSlider = new ReactSlider(getThemedContext(), (AttributeSet) null, ReactSliderManager.STYLE);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                reactSlider.measure(makeMeasureSpec, makeMeasureSpec);
                this.mWidth = reactSlider.getMeasuredWidth();
                this.mHeight = reactSlider.getMeasuredHeight();
                this.mMeasured = true;
            }
            return YogaMeasureOutput.make(this.mWidth, this.mHeight);
        }
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSliderShadowNode();
    }

    public Class getShadowNodeClass() {
        return ReactSliderShadowNode.class;
    }

    /* access modifiers changed from: protected */
    public ReactSlider createViewInstance(ThemedReactContext themedReactContext) {
        ReactSlider reactSlider = new ReactSlider(themedReactContext, (AttributeSet) null, STYLE);
        if (Build.VERSION.SDK_INT >= 21) {
            reactSlider.setSplitTrack(false);
        }
        return reactSlider;
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSlider reactSlider, boolean z) {
        reactSlider.setEnabled(z);
    }

    @ReactProp(defaultDouble = 0.0d, name = "value")
    public void setValue(ReactSlider reactSlider, double d) {
        reactSlider.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
        reactSlider.setValue(d);
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
        if (reactSlider.isAccessibilityFocused() && Build.VERSION.SDK_INT > 29) {
            reactSlider.setupAccessibility((int) d);
        }
    }

    @ReactProp(defaultDouble = 0.0d, name = "minimumValue")
    public void setMinimumValue(ReactSlider reactSlider, double d) {
        reactSlider.setMinValue(d);
    }

    @ReactProp(defaultDouble = 1.0d, name = "maximumValue")
    public void setMaximumValue(ReactSlider reactSlider, double d) {
        reactSlider.setMaxValue(d);
    }

    @ReactProp(defaultDouble = 0.0d, name = "step")
    public void setStep(ReactSlider reactSlider, double d) {
        reactSlider.setStep(d);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSlider reactSlider, Integer num) {
        if (reactSlider.getThumb() == null) {
            return;
        }
        if (num == null) {
            reactSlider.getThumb().clearColorFilter();
        } else {
            reactSlider.getThumb().setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(customType = "Color", name = "minimumTrackTintColor")
    public void setMinimumTrackTintColor(ReactSlider reactSlider, Integer num) {
        Drawable findDrawableByLayerId = ((LayerDrawable) reactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908301);
        if (num == null) {
            findDrawableByLayerId.clearColorFilter();
        } else if (Build.VERSION.SDK_INT > 28) {
            findDrawableByLayerId.setColorFilter(new PorterDuffColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN));
        } else {
            findDrawableByLayerId.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(name = "thumbImage")
    public void setThumbImage(ReactSlider reactSlider, @Nullable ReadableMap readableMap) {
        reactSlider.setThumbImage(readableMap != null ? readableMap.getString("uri") : null);
    }

    @ReactProp(customType = "Color", name = "maximumTrackTintColor")
    public void setMaximumTrackTintColor(ReactSlider reactSlider, Integer num) {
        Drawable findDrawableByLayerId = ((LayerDrawable) reactSlider.getProgressDrawable().getCurrent()).findDrawableByLayerId(16908288);
        if (num == null) {
            findDrawableByLayerId.clearColorFilter();
        } else if (Build.VERSION.SDK_INT > 28) {
            findDrawableByLayerId.setColorFilter(new PorterDuffColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN));
        } else {
            findDrawableByLayerId.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(defaultBoolean = false, name = "inverted")
    public void setInverted(ReactSlider reactSlider, boolean z) {
        if (z) {
            reactSlider.setScaleX(-1.0f);
        } else {
            reactSlider.setScaleX(1.0f);
        }
    }

    @ReactProp(name = "accessibilityUnits")
    public void setAccessibilityUnits(ReactSlider reactSlider, String str) {
        reactSlider.setAccessibilityUnits(str);
    }

    @ReactProp(name = "accessibilityIncrements")
    public void setAccessibilityIncrements(ReactSlider reactSlider, ReadableArray readableArray) {
        ArrayList<Object> arrayList = readableArray.toArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Object> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) it.next());
        }
        reactSlider.setAccessibilityIncrements(arrayList2);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSlider reactSlider) {
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("topSlidingComplete", MapBuilder.of("registrationName", "onRNCSliderSlidingComplete"), ReactSlidingStartEvent.EVENT_NAME, MapBuilder.of("registrationName", "onRNCSliderSlidingStart"));
    }
}
