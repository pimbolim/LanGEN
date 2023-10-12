package com.henninghall.date_picker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.facebook.react.bridge.Dynamic;
import com.henninghall.date_picker.props.DateProp;
import com.henninghall.date_picker.props.DividerHeightProp;
import com.henninghall.date_picker.props.FadeToColorProp;
import com.henninghall.date_picker.props.Is24hourSourceProp;
import com.henninghall.date_picker.props.LocaleProp;
import com.henninghall.date_picker.props.MaximumDateProp;
import com.henninghall.date_picker.props.MinimumDateProp;
import com.henninghall.date_picker.props.MinuteIntervalProp;
import com.henninghall.date_picker.props.ModeProp;
import com.henninghall.date_picker.props.TextColorProp;
import com.henninghall.date_picker.props.UtcProp;
import com.henninghall.date_picker.props.VariantProp;
import com.henninghall.date_picker.ui.Accessibility;
import com.henninghall.date_picker.ui.UIManager;
import java.util.ArrayList;

public class PickerView extends RelativeLayout {
    private final ViewGroup.LayoutParams layoutParams;
    private final Runnable measureAndLayout = new Runnable() {
        public void run() {
            PickerView pickerView = PickerView.this;
            pickerView.measure(View.MeasureSpec.makeMeasureSpec(pickerView.getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(PickerView.this.getHeight(), BasicMeasure.EXACTLY));
            PickerView pickerView2 = PickerView.this;
            pickerView2.layout(pickerView2.getLeft(), PickerView.this.getTop(), PickerView.this.getRight(), PickerView.this.getBottom());
        }
    };
    private State state = new State();
    private UIManager uiManager;
    private ArrayList<String> updatedProps = new ArrayList<>();

    public PickerView(ViewGroup.LayoutParams layoutParams2) {
        super(DatePickerPackage.context);
        this.layoutParams = layoutParams2;
    }

    public void update() {
        if (didUpdate(VariantProp.name)) {
            removeAllViewsInLayout();
            LinearLayout linearLayout = new LinearLayout(getContext());
            LayoutInflater.from(getContext()).inflate(this.state.derived.getRootLayout(), linearLayout);
            addView(linearLayout, this.layoutParams);
            this.uiManager = new UIManager(this.state, this);
        }
        if (didUpdate(FadeToColorProp.name)) {
            this.uiManager.updateFadeToColor();
        }
        if (didUpdate(TextColorProp.name)) {
            this.uiManager.updateTextColor();
        }
        if (didUpdate(ModeProp.name, VariantProp.name, Is24hourSourceProp.name)) {
            this.uiManager.updateWheelVisibility();
        }
        if (didUpdate("height")) {
            this.uiManager.updateHeight();
        }
        if (didUpdate(DividerHeightProp.name)) {
            this.uiManager.updateDividerHeight();
        }
        if (didUpdate(ModeProp.name, LocaleProp.name, VariantProp.name, Is24hourSourceProp.name)) {
            this.uiManager.updateWheelOrder();
        }
        if (didUpdate(ModeProp.name)) {
            this.uiManager.updateWheelPadding();
        }
        if (didUpdate(DateProp.name, "height", LocaleProp.name, MaximumDateProp.name, MinimumDateProp.name, MinuteIntervalProp.name, ModeProp.name, UtcProp.name, VariantProp.name)) {
            this.uiManager.updateDisplayValues();
        }
        if (didUpdate(LocaleProp.name)) {
            Accessibility.setLocale(this.state.getLocale());
        }
        this.uiManager.setWheelsToDate();
        this.updatedProps = new ArrayList<>();
    }

    private boolean didUpdate(String... strArr) {
        for (String contains : strArr) {
            if (this.updatedProps.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public void updateProp(String str, Dynamic dynamic) {
        this.state.setProp(str, dynamic);
        this.updatedProps.add(str);
    }

    public void scroll(int i, int i2) {
        this.uiManager.scroll(i, i2);
    }

    public String getDate() {
        return this.state.derived.getLastDate();
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }
}
