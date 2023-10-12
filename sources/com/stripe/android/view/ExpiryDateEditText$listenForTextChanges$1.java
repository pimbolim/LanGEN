package com.stripe.android.view;

import android.content.res.Resources;
import android.text.Editable;
import com.stripe.android.R;
import com.stripe.android.model.ExpirationDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J*\u0010\u0014\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0016"}, d2 = {"com/stripe/android/view/ExpiryDateEditText$listenForTextChanges$1", "Lcom/stripe/android/view/StripeTextWatcher;", "expirationDate", "Lcom/stripe/android/model/ExpirationDate$Unvalidated;", "formattedDate", "", "latestChangeStart", "", "latestInsertionSize", "newCursorPosition", "Ljava/lang/Integer;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExpiryDateEditText.kt */
public final class ExpiryDateEditText$listenForTextChanges$1 extends StripeTextWatcher {
    private ExpirationDate.Unvalidated expirationDate = ExpirationDate.Unvalidated.Companion.getEMPTY();
    private String formattedDate;
    private int latestChangeStart;
    private int latestInsertionSize;
    private Integer newCursorPosition;
    final /* synthetic */ ExpiryDateEditText this$0;

    ExpiryDateEditText$listenForTextChanges$1(ExpiryDateEditText expiryDateEditText) {
        this.this$0 = expiryDateEditText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.latestChangeStart = i;
        this.latestInsertionSize = i3;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String obj = charSequence == null ? null : charSequence.toString();
        if (obj == null) {
            obj = "";
        }
        CharSequence charSequence2 = obj;
        Appendable sb = new StringBuilder();
        int length = charSequence2.length();
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            char charAt = charSequence2.charAt(i4);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
            i4 = i5;
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        if (sb2.length() == 1 && this.latestChangeStart == 0 && this.latestInsertionSize == 1) {
            char charAt2 = sb2.charAt(0);
            if (!(charAt2 == '0' || charAt2 == '1')) {
                sb2 = Intrinsics.stringPlus("0", sb2);
                this.latestInsertionSize++;
            }
        } else if (sb2.length() == 2 && this.latestChangeStart == 2 && this.latestInsertionSize == 0) {
            sb2 = sb2.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(sb2, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        ExpirationDate.Unvalidated create = ExpirationDate.Unvalidated.Companion.create(sb2);
        this.expirationDate = create;
        boolean z = !create.isMonthValid();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(create.getMonth());
        if ((create.getMonth().length() == 2 && this.latestInsertionSize > 0 && !z) || sb2.length() > 2) {
            sb3.append(this.this$0.separator);
        }
        sb3.append(create.getYear());
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "formattedDateBuilder.toString()");
        this.newCursorPosition = Integer.valueOf(this.this$0.updateSelectionIndex$payments_core_release(sb4.length(), this.latestChangeStart, this.latestInsertionSize, this.this$0.dateDigitsLength + this.this$0.separator.length()));
        this.formattedDate = sb4;
    }

    public void afterTextChanged(Editable editable) {
        int i;
        String str;
        boolean z = false;
        if (!this.this$0.isLastKeyDelete() && (str = this.formattedDate) != null) {
            this.this$0.setTextSilent$payments_core_release(str);
            Integer num = this.newCursorPosition;
            if (num != null) {
                ExpiryDateEditText expiryDateEditText = this.this$0;
                expiryDateEditText.setSelection(RangesKt.coerceIn(num.intValue(), 0, expiryDateEditText.getFieldText$payments_core_release().length()));
            }
        }
        String month = this.expirationDate.getMonth();
        String year = this.expirationDate.getYear();
        boolean z2 = month.length() == 2 && !this.expirationDate.isMonthValid();
        if (month.length() == 2 && year.length() == 2) {
            boolean isDateValid = this.this$0.isDateValid();
            ExpiryDateEditText expiryDateEditText2 = this.this$0;
            expiryDateEditText2.isDateValid = expiryDateEditText2.isDateValid(month, year);
            boolean z3 = !this.this$0.isDateValid();
            if (!isDateValid && this.this$0.isDateValid()) {
                this.this$0.getCompletionCallback$payments_core_release().invoke();
            }
            z2 = z3;
        } else {
            this.this$0.isDateValid = false;
        }
        ExpiryDateEditText expiryDateEditText3 = this.this$0;
        Resources resources = expiryDateEditText3.getResources();
        if (this.expirationDate.isPartialEntry$payments_core_release()) {
            i = R.string.incomplete_expiry_date;
        } else if (!this.expirationDate.isMonthValid()) {
            i = R.string.invalid_expiry_month;
        } else {
            i = R.string.invalid_expiry_year;
        }
        expiryDateEditText3.setErrorMessage(resources.getString(i));
        ExpiryDateEditText expiryDateEditText4 = this.this$0;
        if (z2 && (this.expirationDate.isPartialEntry$payments_core_release() || this.expirationDate.isComplete$payments_core_release())) {
            z = true;
        }
        expiryDateEditText4.setShouldShowError(z);
        this.formattedDate = null;
        this.newCursorPosition = null;
    }
}
