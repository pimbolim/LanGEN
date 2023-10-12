package io.card.payment;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import org.apache.commons.lang3.StringUtils;

class CardNumberValidator implements Validator {
    static final int[] AMEX_SPACER = {4, 11};
    static final int[] NORMAL_SPACER = {4, 9, 14};
    private String numberString;
    private int spacerToDelete;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public CardNumberValidator() {
    }

    public CardNumberValidator(String str) {
        this.numberString = str;
    }

    public void afterTextChanged(Editable editable) {
        String digitsOnlyString = StringHelper.getDigitsOnlyString(editable.toString());
        this.numberString = digitsOnlyString;
        CardType fromCardNumber = CardType.fromCardNumber(digitsOnlyString);
        int i = this.spacerToDelete;
        int i2 = 0;
        if (i > 1) {
            int i3 = i - 1;
            this.spacerToDelete = 0;
            if (i > i3) {
                editable.delete(i3, i);
            }
        }
        while (i2 < editable.length()) {
            char charAt = editable.charAt(i2);
            if ((fromCardNumber.numberLength() == 15 && (i2 == 4 || i2 == 11)) || ((fromCardNumber.numberLength() == 16 || fromCardNumber.numberLength() == 14) && (i2 == 4 || i2 == 9 || i2 == 14))) {
                if (charAt != ' ') {
                    editable.insert(i2, StringUtils.SPACE);
                }
            } else if (charAt == ' ') {
                editable.delete(i2, i2 + 1);
                i2--;
            }
            i2++;
        }
    }

    public boolean hasFullLength() {
        if (TextUtils.isEmpty(this.numberString)) {
            return false;
        }
        if (this.numberString.length() == CardType.fromCardNumber(this.numberString).numberLength()) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (hasFullLength() && CreditCardNumber.passesLuhnChecksum(this.numberString)) {
            return true;
        }
        return false;
    }

    public String getValue() {
        return this.numberString;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int[] iArr;
        int i5;
        String digitsOnlyString = StringHelper.getDigitsOnlyString(new SpannableStringBuilder(spanned).replace(i3, i4, charSequence, i, i2).toString());
        int numberLength = CardType.fromCardNumber(digitsOnlyString).numberLength();
        if (digitsOnlyString.length() > numberLength) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (numberLength == 15) {
            iArr = AMEX_SPACER;
        } else {
            iArr = NORMAL_SPACER;
        }
        int i6 = i4 - i3;
        for (int i7 = 0; i7 < iArr.length; i7++) {
            if (charSequence.length() == 0 && i3 == iArr[i7] && spanned.charAt(i3) == ' ') {
                this.spacerToDelete = iArr[i7];
            }
            if (i3 - i6 <= iArr[i7] && (i3 + i2) - i6 >= iArr[i7] && ((i5 = iArr[i7] - i3) == i2 || (i5 >= 0 && i5 < i2 && spannableStringBuilder.charAt(i5) != ' '))) {
                spannableStringBuilder.insert(i5, StringUtils.SPACE);
                i2++;
            }
        }
        return spannableStringBuilder;
    }
}
