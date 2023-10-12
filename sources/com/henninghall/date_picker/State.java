package com.henninghall.date_picker;

import com.facebook.react.bridge.Dynamic;
import com.henninghall.date_picker.models.Is24HourSource;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.models.Variant;
import com.henninghall.date_picker.props.DateProp;
import com.henninghall.date_picker.props.DividerHeightProp;
import com.henninghall.date_picker.props.FadeToColorProp;
import com.henninghall.date_picker.props.HeightProp;
import com.henninghall.date_picker.props.Is24hourSourceProp;
import com.henninghall.date_picker.props.LocaleProp;
import com.henninghall.date_picker.props.MaximumDateProp;
import com.henninghall.date_picker.props.MinimumDateProp;
import com.henninghall.date_picker.props.MinuteIntervalProp;
import com.henninghall.date_picker.props.ModeProp;
import com.henninghall.date_picker.props.Prop;
import com.henninghall.date_picker.props.TextColorProp;
import com.henninghall.date_picker.props.UtcProp;
import com.henninghall.date_picker.props.VariantProp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

public class State {
    /* access modifiers changed from: private */
    public final DateProp dateProp = new DateProp();
    public DerivedData derived = new DerivedData(this);
    /* access modifiers changed from: private */
    public final DividerHeightProp dividerHeightProp = new DividerHeightProp();
    /* access modifiers changed from: private */
    public final FadeToColorProp fadeToColorProp = new FadeToColorProp();
    /* access modifiers changed from: private */
    public final HeightProp heightProp = new HeightProp();
    /* access modifiers changed from: private */
    public final Is24hourSourceProp is24hourSourceProp = new Is24hourSourceProp();
    private Calendar lastSelectedDate = null;
    /* access modifiers changed from: private */
    public final LocaleProp localeProp = new LocaleProp();
    /* access modifiers changed from: private */
    public final MaximumDateProp maximumDateProp = new MaximumDateProp();
    /* access modifiers changed from: private */
    public final MinimumDateProp minimumDateProp = new MinimumDateProp();
    /* access modifiers changed from: private */
    public final MinuteIntervalProp minuteIntervalProp = new MinuteIntervalProp();
    /* access modifiers changed from: private */
    public final ModeProp modeProp = new ModeProp();
    private final HashMap props = new HashMap<String, Prop>() {
        {
            put(DateProp.name, State.this.dateProp);
            put(ModeProp.name, State.this.modeProp);
            put(LocaleProp.name, State.this.localeProp);
            put(FadeToColorProp.name, State.this.fadeToColorProp);
            put(TextColorProp.name, State.this.textColorProp);
            put(MinuteIntervalProp.name, State.this.minuteIntervalProp);
            put(MinimumDateProp.name, State.this.minimumDateProp);
            put(MaximumDateProp.name, State.this.maximumDateProp);
            put(UtcProp.name, State.this.utcProp);
            put("height", State.this.heightProp);
            put(VariantProp.name, State.this.variantProp);
            put(DividerHeightProp.name, State.this.dividerHeightProp);
            put(Is24hourSourceProp.name, State.this.is24hourSourceProp);
        }
    };
    /* access modifiers changed from: private */
    public final TextColorProp textColorProp = new TextColorProp();
    /* access modifiers changed from: private */
    public final UtcProp utcProp = new UtcProp();
    /* access modifiers changed from: private */
    public final VariantProp variantProp = new VariantProp();

    private Prop getProp(String str) {
        return (Prop) this.props.get(str);
    }

    /* access modifiers changed from: package-private */
    public void setProp(String str, Dynamic dynamic) {
        getProp(str).setValue(dynamic);
    }

    public Mode getMode() {
        return (Mode) this.modeProp.getValue();
    }

    public String getFadeToColor() {
        return (String) this.fadeToColorProp.getValue();
    }

    public String getTextColor() {
        return (String) this.textColorProp.getValue();
    }

    public int getMinuteInterval() {
        return ((Integer) this.minuteIntervalProp.getValue()).intValue();
    }

    public Locale getLocale() {
        return (Locale) this.localeProp.getValue();
    }

    public Calendar getMinimumDate() {
        return new DateBoundary(getTimeZone(), (String) this.minimumDateProp.getValue()).get();
    }

    public Calendar getMaximumDate() {
        return new DateBoundary(getTimeZone(), (String) this.maximumDateProp.getValue()).get();
    }

    public TimeZone getTimeZone() {
        return ((Boolean) this.utcProp.getValue()).booleanValue() ? TimeZone.getTimeZone("UTC") : TimeZone.getDefault();
    }

    public String getIsoDate() {
        return (String) this.dateProp.getValue();
    }

    public Calendar getDate() {
        return Utils.isoToCalendar(getIsoDate(), getTimeZone());
    }

    public Integer getHeight() {
        return (Integer) this.heightProp.getValue();
    }

    public String getLocaleLanguageTag() {
        return this.localeProp.getLanguageTag();
    }

    public Variant getVariant() {
        return (Variant) this.variantProp.getValue();
    }

    public int getDividerHeight() {
        return ((Integer) this.dividerHeightProp.getValue()).intValue();
    }

    public Is24HourSource getIs24HourSource() {
        return (Is24HourSource) this.is24hourSourceProp.getValue();
    }

    public Calendar getLastSelectedDate() {
        return this.lastSelectedDate;
    }

    public void setLastSelectedDate(Calendar calendar) {
        this.lastSelectedDate = calendar;
    }
}
