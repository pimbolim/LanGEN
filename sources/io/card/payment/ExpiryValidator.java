package io.card.payment;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.Date;

class ExpiryValidator implements Validator {
    private static final String TAG = "ExpiryValidator";
    private boolean fullLength;
    public int month;
    public int year;

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public ExpiryValidator() {
    }

    public ExpiryValidator(int i, int i2) {
        this.month = i;
        this.year = i2;
        this.fullLength = i > 0 && i2 > 0;
        if (i2 < 2000) {
            this.year = i2 + 2000;
        }
    }

    public void afterTextChanged(Editable editable) {
        Date dateForString;
        this.fullLength = editable.length() >= 5;
        String obj = editable.toString();
        if (obj != null && (dateForString = CreditCardNumber.getDateForString(obj)) != null) {
            this.month = dateForString.getMonth() + 1;
            int year2 = dateForString.getYear();
            this.year = year2;
            if (year2 < 1900) {
                this.year = year2 + 1900;
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.month = 0;
        this.year = 0;
        this.fullLength = false;
    }

    public String getValue() {
        return String.format("%02d/%02d", new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year % 100)});
    }

    public boolean hasFullLength() {
        return this.fullLength;
    }

    public boolean isValid() {
        int i = this.month;
        if (i < 1 || 12 < i) {
            return false;
        }
        Date date = new Date();
        if (this.year > date.getYear() + 1900 + 15) {
            return false;
        }
        if (this.year > date.getYear() + 1900 || (this.year == date.getYear() + 1900 && this.month >= date.getMonth() + 1)) {
            return true;
        }
        return false;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (i3 == 0 && spannableStringBuilder.length() > 0 && '1' < spannableStringBuilder.charAt(0) && spannableStringBuilder.charAt(0) <= '9') {
            spannableStringBuilder.insert(0, "0");
            i2++;
        }
        int i6 = i4 - i3;
        if (i3 - i6 <= 2 && (i3 + i2) - i6 >= 2 && ((i5 = 2 - i3) == i2 || (i5 >= 0 && i5 < i2 && spannableStringBuilder.charAt(i5) != '/'))) {
            spannableStringBuilder.insert(i5, "/");
            i2++;
        }
        String spannableStringBuilder2 = new SpannableStringBuilder(spanned).replace(i3, i4, spannableStringBuilder, i, i2).toString();
        if (spannableStringBuilder2.length() >= 1 && (spannableStringBuilder2.charAt(0) < '0' || '1' < spannableStringBuilder2.charAt(0))) {
            return "";
        }
        if (spannableStringBuilder2.length() >= 2) {
            if (spannableStringBuilder2.charAt(0) != '0' && spannableStringBuilder2.charAt(1) > '2') {
                return "";
            }
            if (spannableStringBuilder2.charAt(0) == '0' && spannableStringBuilder2.charAt(1) == '0') {
                return "";
            }
        }
        if (spannableStringBuilder2.length() > 5) {
            return "";
        }
        return spannableStringBuilder;
    }
}
