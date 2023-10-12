package com.stripe.android.stripe3ds2.init.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.stripe3ds2.exceptions.InvalidInputException;
import com.stripe.android.stripe3ds2.utils.CustomizeUtils;
import com.stripe.android.stripe3ds2.utils.ObjectUtils;

public final class StripeTextBoxCustomization extends BaseCustomization implements TextBoxCustomization, Parcelable {
    public static final Parcelable.Creator<StripeTextBoxCustomization> CREATOR = new Parcelable.Creator<StripeTextBoxCustomization>() {
        public StripeTextBoxCustomization createFromParcel(Parcel parcel) {
            return new StripeTextBoxCustomization(parcel);
        }

        public StripeTextBoxCustomization[] newArray(int i) {
            return new StripeTextBoxCustomization[i];
        }
    };
    private String mBorderColor;
    private int mBorderWidth;
    private int mCornerRadius;
    private String mHintTextColor;

    public int describeContents() {
        return 0;
    }

    public StripeTextBoxCustomization() {
    }

    private StripeTextBoxCustomization(Parcel parcel) {
        super(parcel);
        this.mBorderWidth = parcel.readInt();
        this.mBorderColor = parcel.readString();
        this.mCornerRadius = parcel.readInt();
        this.mHintTextColor = parcel.readString();
    }

    public void setBorderWidth(int i) throws InvalidInputException {
        this.mBorderWidth = CustomizeUtils.requireValidDimension(i);
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderColor(String str) throws InvalidInputException {
        this.mBorderColor = CustomizeUtils.requireValidColor(str);
    }

    public String getBorderColor() {
        return this.mBorderColor;
    }

    public void setCornerRadius(int i) throws InvalidInputException {
        this.mCornerRadius = CustomizeUtils.requireValidDimension(i);
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    public void setHintTextColor(String str) throws InvalidInputException {
        this.mHintTextColor = CustomizeUtils.requireValidColor(str);
    }

    public String getHintTextColor() {
        return this.mHintTextColor;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof StripeTextBoxCustomization) && typedEquals((StripeTextBoxCustomization) obj));
    }

    private boolean typedEquals(StripeTextBoxCustomization stripeTextBoxCustomization) {
        return this.mBorderWidth == stripeTextBoxCustomization.mBorderWidth && ObjectUtils.equals(this.mBorderColor, stripeTextBoxCustomization.mBorderColor) && this.mCornerRadius == stripeTextBoxCustomization.mCornerRadius && ObjectUtils.equals(this.mHintTextColor, stripeTextBoxCustomization.mHintTextColor);
    }

    public int hashCode() {
        return ObjectUtils.hash(Integer.valueOf(this.mBorderWidth), this.mBorderColor, Integer.valueOf(this.mCornerRadius), this.mHintTextColor);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mBorderWidth);
        parcel.writeString(this.mBorderColor);
        parcel.writeInt(this.mCornerRadius);
        parcel.writeString(this.mHintTextColor);
    }
}
