package com.stripe.android.stripe3ds2.init.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.stripe3ds2.exceptions.InvalidInputException;
import com.stripe.android.stripe3ds2.utils.CustomizeUtils;
import com.stripe.android.stripe3ds2.utils.ObjectUtils;

public final class StripeButtonCustomization extends BaseCustomization implements ButtonCustomization, Parcelable {
    public static final Parcelable.Creator<StripeButtonCustomization> CREATOR = new Parcelable.Creator<StripeButtonCustomization>() {
        public StripeButtonCustomization createFromParcel(Parcel parcel) {
            return new StripeButtonCustomization(parcel);
        }

        public StripeButtonCustomization[] newArray(int i) {
            return new StripeButtonCustomization[i];
        }
    };
    private String mBackgroundColor;
    private int mCornerRadius;

    public int describeContents() {
        return 0;
    }

    public StripeButtonCustomization() {
    }

    private StripeButtonCustomization(Parcel parcel) {
        super(parcel);
        this.mBackgroundColor = parcel.readString();
        this.mCornerRadius = parcel.readInt();
    }

    public void setBackgroundColor(String str) throws InvalidInputException {
        this.mBackgroundColor = CustomizeUtils.requireValidColor(str);
    }

    public void setCornerRadius(int i) throws InvalidInputException {
        this.mCornerRadius = CustomizeUtils.requireValidDimension(i);
    }

    public String getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof StripeButtonCustomization) && typedEquals((StripeButtonCustomization) obj));
    }

    private boolean typedEquals(StripeButtonCustomization stripeButtonCustomization) {
        return ObjectUtils.equals(this.mBackgroundColor, stripeButtonCustomization.mBackgroundColor) && this.mCornerRadius == stripeButtonCustomization.mCornerRadius;
    }

    public int hashCode() {
        return ObjectUtils.hash(this.mBackgroundColor, Integer.valueOf(this.mCornerRadius));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mBackgroundColor);
        parcel.writeInt(this.mCornerRadius);
    }
}
