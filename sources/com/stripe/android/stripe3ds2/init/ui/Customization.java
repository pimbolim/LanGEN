package com.stripe.android.stripe3ds2.init.ui;

import com.stripe.android.stripe3ds2.exceptions.InvalidInputException;

public interface Customization {
    String getTextColor();

    String getTextFontName();

    int getTextFontSize();

    void setTextColor(String str) throws InvalidInputException;

    void setTextFontName(String str) throws InvalidInputException;

    void setTextFontSize(int i) throws InvalidInputException;
}
