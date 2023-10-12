package com.stripe.android.stripe3ds2.init.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TypedValue;
import androidx.appcompat.R;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import com.stripe.android.stripe3ds2.exceptions.InvalidInputException;
import com.stripe.android.stripe3ds2.init.ui.UiCustomization;
import com.stripe.android.stripe3ds2.utils.CustomizeUtils;
import com.stripe.android.stripe3ds2.utils.ObjectUtils;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class StripeUiCustomization implements UiCustomization, Parcelable {
    public static final Parcelable.Creator<StripeUiCustomization> CREATOR = new Parcelable.Creator<StripeUiCustomization>() {
        public StripeUiCustomization createFromParcel(Parcel parcel) {
            return new StripeUiCustomization(parcel);
        }

        public StripeUiCustomization[] newArray(int i) {
            return new StripeUiCustomization[i];
        }
    };
    private String mAccentColor;
    private final Map<String, ButtonCustomization> mCustomButtonTypeCustomization;
    private final Map<UiCustomization.ButtonType, ButtonCustomization> mDefaultButtonTypeCustomizations;
    private LabelCustomization mLabelCustomization;
    private TextBoxCustomization mTextBoxCustomization;
    private ToolbarCustomization mToolbarCustomization;

    public int describeContents() {
        return 0;
    }

    public StripeUiCustomization() {
        this.mDefaultButtonTypeCustomizations = new EnumMap(UiCustomization.ButtonType.class);
        this.mCustomButtonTypeCustomization = new HashMap();
    }

    public static StripeUiCustomization createWithAppTheme(Activity activity) {
        return new StripeUiCustomization(activity);
    }

    private StripeUiCustomization(Activity activity) {
        this();
        Context themeContext = getThemeContext(activity, R.attr.actionBarTheme);
        String themeColor = getThemeColor(activity, 16843827);
        String themeColor2 = getThemeColor(activity, 16843828);
        String themeColor3 = getThemeColor(themeContext, 16842806);
        String themeColor4 = getThemeColor(activity, 16842904);
        String themeColor5 = getThemeColor(activity, 16843829);
        String themeColor6 = getThemeColor(activity, 16842906);
        this.mToolbarCustomization = new StripeToolbarCustomization();
        this.mLabelCustomization = new StripeLabelCustomization();
        StripeTextBoxCustomization stripeTextBoxCustomization = new StripeTextBoxCustomization();
        this.mTextBoxCustomization = stripeTextBoxCustomization;
        if (themeColor6 != null) {
            stripeTextBoxCustomization.setHintTextColor(themeColor6);
        }
        StripeButtonCustomization stripeButtonCustomization = new StripeButtonCustomization();
        StripeButtonCustomization stripeButtonCustomization2 = new StripeButtonCustomization();
        if (themeColor3 != null) {
            this.mToolbarCustomization.setTextColor(themeColor3);
            stripeButtonCustomization.setTextColor(themeColor3);
        }
        if (themeColor != null) {
            this.mToolbarCustomization.setBackgroundColor(themeColor);
        }
        if (themeColor2 != null) {
            this.mToolbarCustomization.setStatusBarColor(themeColor2);
        }
        if (themeColor4 != null) {
            this.mLabelCustomization.setTextColor(themeColor4);
            this.mLabelCustomization.setHeadingTextColor(themeColor4);
            stripeButtonCustomization2.setTextColor(themeColor4);
            this.mTextBoxCustomization.setTextColor(themeColor4);
        }
        if (themeColor5 != null) {
            setAccentColor(themeColor5);
            StripeButtonCustomization stripeButtonCustomization3 = new StripeButtonCustomization();
            stripeButtonCustomization3.setTextColor(themeColor5);
            setButtonCustomization((ButtonCustomization) stripeButtonCustomization3, UiCustomization.ButtonType.RESEND);
            stripeButtonCustomization2.setBackgroundColor(themeColor5);
        }
        setButtonCustomization((ButtonCustomization) stripeButtonCustomization, UiCustomization.ButtonType.CANCEL);
        setButtonCustomization((ButtonCustomization) stripeButtonCustomization2, UiCustomization.ButtonType.NEXT);
        setButtonCustomization((ButtonCustomization) stripeButtonCustomization2, UiCustomization.ButtonType.CONTINUE);
        setButtonCustomization((ButtonCustomization) stripeButtonCustomization2, UiCustomization.ButtonType.SUBMIT);
        setButtonCustomization((ButtonCustomization) stripeButtonCustomization2, UiCustomization.ButtonType.SELECT);
    }

    private String getThemeColor(Context context, int i) {
        int i2;
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        if (typedValue.resourceId != 0) {
            i2 = ContextCompat.getColor(context, typedValue.resourceId);
        } else {
            i2 = typedValue.data;
        }
        return CustomizeUtils.colorIntToHex(i2);
    }

    private Context getThemeContext(Activity activity, int i) {
        TypedValue typedValue = new TypedValue();
        return activity.getTheme().resolveAttribute(i, typedValue, true) ? new ContextThemeWrapper((Context) activity, typedValue.resourceId) : activity;
    }

    private StripeUiCustomization(Parcel parcel) {
        this.mAccentColor = parcel.readString();
        this.mToolbarCustomization = (ToolbarCustomization) parcel.readParcelable(StripeToolbarCustomization.class.getClassLoader());
        this.mLabelCustomization = (LabelCustomization) parcel.readParcelable(StripeLabelCustomization.class.getClassLoader());
        this.mTextBoxCustomization = (TextBoxCustomization) parcel.readParcelable(StripeTextBoxCustomization.class.getClassLoader());
        this.mDefaultButtonTypeCustomizations = new HashMap();
        Bundle readBundle = parcel.readBundle(getClass().getClassLoader());
        if (readBundle != null) {
            for (String str : readBundle.keySet()) {
                ButtonCustomization buttonCustomization = (ButtonCustomization) readBundle.getParcelable(str);
                if (buttonCustomization != null) {
                    this.mDefaultButtonTypeCustomizations.put(UiCustomization.ButtonType.valueOf(str), buttonCustomization);
                }
            }
        }
        this.mCustomButtonTypeCustomization = new HashMap();
        Bundle readBundle2 = parcel.readBundle(getClass().getClassLoader());
        if (readBundle2 != null) {
            for (String str2 : readBundle2.keySet()) {
                ButtonCustomization buttonCustomization2 = (ButtonCustomization) readBundle2.getParcelable(str2);
                if (buttonCustomization2 != null) {
                    this.mCustomButtonTypeCustomization.put(str2, buttonCustomization2);
                }
            }
        }
    }

    public void setButtonCustomization(ButtonCustomization buttonCustomization, UiCustomization.ButtonType buttonType) throws InvalidInputException {
        this.mDefaultButtonTypeCustomizations.put(buttonType, buttonCustomization);
    }

    public void setButtonCustomization(ButtonCustomization buttonCustomization, String str) throws InvalidInputException {
        this.mCustomButtonTypeCustomization.put(str, buttonCustomization);
    }

    public void setToolbarCustomization(ToolbarCustomization toolbarCustomization) throws InvalidInputException {
        this.mToolbarCustomization = toolbarCustomization;
    }

    public void setLabelCustomization(LabelCustomization labelCustomization) throws InvalidInputException {
        this.mLabelCustomization = labelCustomization;
    }

    public void setTextBoxCustomization(TextBoxCustomization textBoxCustomization) throws InvalidInputException {
        this.mTextBoxCustomization = textBoxCustomization;
    }

    public void setAccentColor(String str) {
        this.mAccentColor = CustomizeUtils.requireValidColor(str);
    }

    public ButtonCustomization getButtonCustomization(UiCustomization.ButtonType buttonType) throws InvalidInputException {
        return this.mDefaultButtonTypeCustomizations.get(buttonType);
    }

    public ButtonCustomization getButtonCustomization(String str) throws InvalidInputException {
        return this.mCustomButtonTypeCustomization.get(str);
    }

    public ToolbarCustomization getToolbarCustomization() {
        return this.mToolbarCustomization;
    }

    public LabelCustomization getLabelCustomization() {
        return this.mLabelCustomization;
    }

    public TextBoxCustomization getTextBoxCustomization() {
        return this.mTextBoxCustomization;
    }

    public String getAccentColor() {
        return this.mAccentColor;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof StripeUiCustomization) && typedEquals((StripeUiCustomization) obj));
    }

    private boolean typedEquals(StripeUiCustomization stripeUiCustomization) {
        return ObjectUtils.equals(this.mToolbarCustomization, stripeUiCustomization.mToolbarCustomization) && ObjectUtils.equals(this.mAccentColor, stripeUiCustomization.mAccentColor) && ObjectUtils.equals(this.mLabelCustomization, stripeUiCustomization.mLabelCustomization) && ObjectUtils.equals(this.mTextBoxCustomization, stripeUiCustomization.mTextBoxCustomization) && ObjectUtils.equals(this.mDefaultButtonTypeCustomizations, stripeUiCustomization.mDefaultButtonTypeCustomizations) && ObjectUtils.equals(this.mCustomButtonTypeCustomization, stripeUiCustomization.mCustomButtonTypeCustomization);
    }

    public int hashCode() {
        return ObjectUtils.hash(this.mToolbarCustomization, this.mAccentColor, this.mLabelCustomization, this.mTextBoxCustomization, this.mDefaultButtonTypeCustomizations, this.mCustomButtonTypeCustomization);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAccentColor);
        parcel.writeParcelable((StripeToolbarCustomization) this.mToolbarCustomization, 0);
        parcel.writeParcelable((StripeLabelCustomization) this.mLabelCustomization, 0);
        parcel.writeParcelable((StripeTextBoxCustomization) this.mTextBoxCustomization, 0);
        Bundle bundle = new Bundle();
        for (Map.Entry next : this.mDefaultButtonTypeCustomizations.entrySet()) {
            bundle.putParcelable(((UiCustomization.ButtonType) next.getKey()).name(), (StripeButtonCustomization) next.getValue());
        }
        parcel.writeBundle(bundle);
        Bundle bundle2 = new Bundle();
        for (Map.Entry next2 : this.mCustomButtonTypeCustomization.entrySet()) {
            bundle2.putParcelable((String) next2.getKey(), (StripeButtonCustomization) next2.getValue());
        }
        parcel.writeBundle(bundle2);
    }
}
