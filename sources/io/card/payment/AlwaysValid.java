package io.card.payment;

import android.text.Editable;
import android.text.Spanned;

class AlwaysValid implements Validator {
    private String placeholder;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return null;
    }

    public boolean hasFullLength() {
        return true;
    }

    public boolean isValid() {
        return true;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public String getValue() {
        return this.placeholder;
    }
}
