package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.VisualTransformation;
import com.stripe.android.CardUtils;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.TextFieldStateConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0016J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0016R\u001f\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Lcom/stripe/android/ui/core/elements/CardNumberConfig;", "Lcom/stripe/android/ui/core/elements/CardDetailsTextFieldConfig;", "()V", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCapitalization-IUNYP9k", "()I", "I", "debugLabel", "", "getDebugLabel", "()Ljava/lang/String;", "keyboard", "Landroidx/compose/ui/text/input/KeyboardType;", "getKeyboard-PjHm6EE", "label", "", "getLabel", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "convertFromRaw", "rawValue", "convertToRaw", "displayName", "determineState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "brand", "Lcom/stripe/android/model/CardBrand;", "number", "numberAllowedDigits", "filter", "userTyped", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardNumberConfig.kt */
public final class CardNumberConfig implements CardDetailsTextFieldConfig {
    private final int capitalization = KeyboardCapitalization.Companion.m3665getNoneIUNYP9k();
    private final String debugLabel = "Card number";
    private final int keyboard = KeyboardType.Companion.m3678getNumberPasswordPjHm6EE();
    private final int label = R.string.acc_label_card_number;
    private final VisualTransformation visualTransformation = new CardNumberVisualTransformation(' ');

    public String convertFromRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        return str;
    }

    public String convertToRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        return str;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public int m4560getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public String getDebugLabel() {
        return this.debugLabel;
    }

    public int getLabel() {
        return this.label;
    }

    /* renamed from: getKeyboard-PjHm6EE  reason: not valid java name */
    public int m4561getKeyboardPjHm6EE() {
        return this.keyboard;
    }

    public VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public TextFieldState determineState(CardBrand cardBrand, String str, int i) {
        Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
        Intrinsics.checkNotNullParameter(str, "number");
        boolean isValidLuhnNumber = CardUtils.INSTANCE.isValidLuhnNumber(str);
        boolean z = cardBrand.getMaxLengthForCardNumber(str) != -1;
        if (StringsKt.isBlank(str)) {
            return TextFieldStateConstants.Error.Blank.INSTANCE;
        }
        if (cardBrand == CardBrand.Unknown) {
            return new TextFieldStateConstants.Error.Invalid(R.string.invalid_card_number, (Object[]) null, 2, (DefaultConstructorMarker) null);
        }
        if (z && str.length() < i) {
            return new TextFieldStateConstants.Error.Incomplete(R.string.invalid_card_number);
        }
        if (!isValidLuhnNumber) {
            return new TextFieldStateConstants.Error.Invalid(R.string.invalid_card_number, (Object[]) null, 2, (DefaultConstructorMarker) null);
        }
        if (!z || str.length() != i) {
            return new TextFieldStateConstants.Error.Invalid(R.string.invalid_card_number, (Object[]) null, 2, (DefaultConstructorMarker) null);
        }
        return TextFieldStateConstants.Valid.Full.INSTANCE;
    }

    public String filter(String str) {
        Intrinsics.checkNotNullParameter(str, "userTyped");
        CharSequence charSequence = str;
        Appendable sb = new StringBuilder();
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = charSequence.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
            i = i2;
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }
}
