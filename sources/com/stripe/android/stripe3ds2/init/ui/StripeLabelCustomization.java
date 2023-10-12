package com.stripe.android.stripe3ds2.init.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.stripe3ds2.exceptions.InvalidInputException;
import com.stripe.android.stripe3ds2.utils.CustomizeUtils;
import com.stripe.android.stripe3ds2.utils.ObjectUtils;

public final class StripeLabelCustomization extends BaseCustomization implements LabelCustomization, Parcelable {
    public static final Parcelable.Creator<StripeLabelCustomization> CREATOR = new Parcelable.Creator<StripeLabelCustomization>() {
        public StripeLabelCustomization createFromParcel(Parcel parcel) {
            return new StripeLabelCustomization(parcel);
        }

        public StripeLabelCustomization[] newArray(int i) {
            return new StripeLabelCustomization[i];
        }
    };
    private String mHeadingTextColor;
    private String mHeadingTextFontName;
    private int mHeadingTextFontSize;

    public int describeContents() {
        return 0;
    }

    public StripeLabelCustomization() {
    }

    private StripeLabelCustomization(Parcel parcel) {
        super(parcel);
        this.mHeadingTextColor = parcel.readString();
        this.mHeadingTextFontName = parcel.readString();
        this.mHeadingTextFontSize = parcel.readInt();
    }

    public void setHeadingTextColor(String str) throws InvalidInputException {
        this.mHeadingTextColor = CustomizeUtils.requireValidColor(str);
    }

    public void setHeadingTextFontName(String str) throws InvalidInputException {
        this.mHeadingTextFontName = CustomizeUtils.requireValidString(str);
    }

    public void setHeadingTextFontSize(int i) throws InvalidInputException {
        this.mHeadingTextFontSize = CustomizeUtils.requireValidFontSize(i);
    }

    public String getHeadingTextColor() {
        return this.mHeadingTextColor;
    }

    public String getHeadingTextFontName() {
        return this.mHeadingTextFontName;
    }

    public int getHeadingTextFontSize() {
        return this.mHeadingTextFontSize;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof StripeLabelCustomization) && typedEquals((StripeLabelCustomization) obj));
    }

    private boolean typedEquals(StripeLabelCustomization stripeLabelCustomization) {
        return ObjectUtils.equals(this.mHeadingTextColor, stripeLabelCustomization.mHeadingTextColor) && ObjectUtils.equals(this.mHeadingTextFontName, stripeLabelCustomization.mHeadingTextFontName) && this.mHeadingTextFontSize == stripeLabelCustomization.mHeadingTextFontSize;
    }

    public int hashCode() {
        return ObjectUtils.hash(this.mHeadingTextColor, this.mHeadingTextFontName, Integer.valueOf(this.mHeadingTextFontSize));
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mHeadingTextColor);
        parcel.writeString(this.mHeadingTextFontName);
        parcel.writeInt(this.mHeadingTextFontSize);
    }
}
