package io.card.payment;

import android.text.Editable;
import android.text.Spanned;

class FixedLengthValidator implements Validator {
    public int requiredLength;
    private String value;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public FixedLengthValidator(int i) {
        this.requiredLength = i;
    }

    public void afterTextChanged(Editable editable) {
        this.value = editable.toString();
    }

    public String getValue() {
        return this.value;
    }

    public boolean hasFullLength() {
        return isValid();
    }

    public boolean isValid() {
        String str = this.value;
        return str != null && str.length() == this.requiredLength;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (i2 <= 0 || ((spanned.length() + i4) - i3) + i2 <= this.requiredLength) {
            return null;
        }
        return "";
    }
}
