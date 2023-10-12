package com.stripe.android.stripe3ds2.init.ui;

import com.stripe.android.stripe3ds2.exceptions.InvalidInputException;

public interface LabelCustomization extends Customization {
    String getHeadingTextColor();

    String getHeadingTextFontName();

    int getHeadingTextFontSize();

    void setHeadingTextColor(String str) throws InvalidInputException;

    void setHeadingTextFontName(String str) throws InvalidInputException;

    void setHeadingTextFontSize(int i) throws InvalidInputException;
}
