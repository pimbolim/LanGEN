package com.henninghall.date_picker.ui;

import android.view.View;
import com.henninghall.date_picker.State;
import com.henninghall.date_picker.wheelFunctions.AddOnChangeListener;
import com.henninghall.date_picker.wheelFunctions.AnimateToDate;
import com.henninghall.date_picker.wheelFunctions.HorizontalPadding;
import com.henninghall.date_picker.wheelFunctions.Refresh;
import com.henninghall.date_picker.wheelFunctions.SetDate;
import com.henninghall.date_picker.wheelFunctions.TextColor;
import com.henninghall.date_picker.wheelFunctions.UpdateVisibility;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UIManager {
    private FadingOverlay fadingOverlay;
    private final View rootView;
    private final State state;
    private WheelScroller wheelScroller = new WheelScroller();
    private Wheels wheels;

    public UIManager(State state2, View view) {
        this.state = state2;
        this.rootView = view;
        this.wheels = new Wheels(state2, view);
        addOnChangeListener();
    }

    public void updateWheelVisibility() {
        this.wheels.applyOnAll(new UpdateVisibility());
    }

    public void updateTextColor() {
        this.wheels.applyOnAll(new TextColor(this.state.getTextColor()));
    }

    public void updateFadeToColor() {
        if (!this.state.derived.hasNativeStyle()) {
            FadingOverlay fadingOverlay2 = new FadingOverlay(this.state, this.rootView);
            this.fadingOverlay = fadingOverlay2;
            fadingOverlay2.updateColor();
        }
    }

    public void updateHeight() {
        this.wheels.updateHeight();
    }

    public void updateWheelOrder() {
        this.wheels.updateWheelOrder();
    }

    public void updateDisplayValues() {
        this.wheels.applyOnAll(new Refresh());
    }

    public void setWheelsToDate() {
        this.wheels.applyOnAll(new SetDate(this.state.getDate()));
    }

    public void scroll(int i, int i2) {
        this.wheelScroller.scroll(this.wheels.getWheel(this.state.derived.getOrderedVisibleWheels().get(i)), i2);
    }

    /* access modifiers changed from: package-private */
    public SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat(this.wheels.getFormatPattern(), this.state.getLocale());
    }

    /* access modifiers changed from: package-private */
    public String getDisplayValueString() {
        return this.wheels.getDisplayValue();
    }

    /* access modifiers changed from: package-private */
    public void animateToDate(Calendar calendar) {
        this.wheels.applyOnInVisible(new SetDate(calendar));
        this.wheels.applyOnVisible(new AnimateToDate(calendar));
    }

    private void addOnChangeListener() {
        this.wheels.applyOnAll(new AddOnChangeListener(new WheelChangeListenerImpl(this.wheels, this.state, this, this.rootView)));
    }

    public void updateDividerHeight() {
        this.wheels.updateDividerHeight();
    }

    public void updateWheelPadding() {
        this.wheels.applyOnVisible(new HorizontalPadding());
    }

    public void updateLastSelectedDate(Calendar calendar) {
        this.state.setLastSelectedDate(calendar);
    }
}
