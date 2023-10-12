package com.stripe.android.stripe3ds2.init.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.stripe3ds2.exceptions.InvalidInputException;
import com.stripe.android.stripe3ds2.utils.CustomizeUtils;
import com.stripe.android.stripe3ds2.utils.ObjectUtils;

public final class StripeToolbarCustomization extends BaseCustomization implements ToolbarCustomization, Parcelable {
    public static final Parcelable.Creator<StripeToolbarCustomization> CREATOR = new Parcelable.Creator<StripeToolbarCustomization>() {
        public StripeToolbarCustomization createFromParcel(Parcel parcel) {
            return new StripeToolbarCustomization(parcel);
        }

        public StripeToolbarCustomization[] newArray(int i) {
            return new StripeToolbarCustomization[i];
        }
    };
    private String mBackgroundColor;
    private String mButtonText;
    private String mHeaderText;
    private String mStatusBarColor;

    public int describeContents() {
        return 0;
    }

    public StripeToolbarCustomization() {
    }

    private StripeToolbarCustomization(Parcel parcel) {
        super(parcel);
        this.mBackgroundColor = parcel.readString();
        this.mStatusBarColor = parcel.readString();
        this.mHeaderText = parcel.readString();
        this.mButtonText = parcel.readString();
    }

    public void setBackgroundColor(String str) throws InvalidInputException {
        this.mBackgroundColor = CustomizeUtils.requireValidColor(str);
    }

    public void setStatusBarColor(String str) throws InvalidInputException {
        this.mStatusBarColor = CustomizeUtils.requireValidColor(str);
    }

    public void setHeaderText(String str) throws InvalidInputException {
        this.mHeaderText = CustomizeUtils.requireValidString(str);
    }

    public void setButtonText(String str) throws InvalidInputException {
        this.mButtonText = CustomizeUtils.requireValidString(str);
    }

    public String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public String getHeaderText() {
        return this.mHeaderText;
    }

    public String getButtonText() {
        return this.mButtonText;
    }

    public String getStatusBarColor() {
        return this.mStatusBarColor;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof StripeToolbarCustomization) && typedEquals((StripeToolbarCustomization) obj));
    }

    private boolean typedEquals(StripeToolbarCustomization stripeToolbarCustomization) {
        return ObjectUtils.equals(this.mBackgroundColor, stripeToolbarCustomization.mBackgroundColor) && ObjectUtils.equals(this.mStatusBarColor, stripeToolbarCustomization.mStatusBarColor) && ObjectUtils.equals(this.mHeaderText, stripeToolbarCustomization.mHeaderText) && ObjectUtils.equals(this.mButtonText, stripeToolbarCustomization.mButtonText);
    }

    public int hashCode() {
        return ObjectUtils.hash(this.mBackgroundColor, this.mStatusBarColor, this.mHeaderText, this.mButtonText);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mBackgroundColor);
        parcel.writeString(this.mStatusBarColor);
        parcel.writeString(this.mHeaderText);
        parcel.writeString(this.mButtonText);
    }
}
