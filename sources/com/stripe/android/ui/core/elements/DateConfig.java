package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.henninghall.date_picker.props.DateProp;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.TextFieldStateConstants;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0016R\u001f\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00108\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/stripe/android/ui/core/elements/DateConfig;", "Lcom/stripe/android/ui/core/elements/TextFieldConfig;", "()V", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCapitalization-IUNYP9k", "()I", "I", "debugLabel", "", "getDebugLabel", "()Ljava/lang/String;", "keyboard", "Landroidx/compose/ui/text/input/KeyboardType;", "getKeyboard-PjHm6EE", "label", "", "getLabel", "loading", "Lkotlinx/coroutines/flow/StateFlow;", "", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "trailingIcon", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "getTrailingIcon", "visualTransformation", "Lcom/stripe/android/ui/core/elements/ExpiryDateVisualTransformation;", "getVisualTransformation", "()Lcom/stripe/android/ui/core/elements/ExpiryDateVisualTransformation;", "convertFromRaw", "rawValue", "convertToRaw", "displayName", "determineState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "input", "filter", "userTyped", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DateConfig.kt */
public final class DateConfig implements TextFieldConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int capitalization = KeyboardCapitalization.Companion.m3665getNoneIUNYP9k();
    private final String debugLabel = DateProp.name;
    private final int keyboard = KeyboardType.Companion.m3678getNumberPasswordPjHm6EE();
    private final int label = R.string.stripe_paymentsheet_expiration_date_hint;
    private final StateFlow<Boolean> loading = StateFlowKt.MutableStateFlow(false);
    private final StateFlow<TextFieldIcon> trailingIcon = StateFlowKt.MutableStateFlow(null);
    private final ExpiryDateVisualTransformation visualTransformation = new ExpiryDateVisualTransformation();

    public String convertFromRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        return str;
    }

    public String convertToRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        return str;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public int m4570getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public String getDebugLabel() {
        return this.debugLabel;
    }

    public int getLabel() {
        return this.label;
    }

    /* renamed from: getKeyboard-PjHm6EE  reason: not valid java name */
    public int m4571getKeyboardPjHm6EE() {
        return this.keyboard;
    }

    public ExpiryDateVisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public StateFlow<TextFieldIcon> getTrailingIcon() {
        return this.trailingIcon;
    }

    public StateFlow<Boolean> getLoading() {
        return this.loading;
    }

    public TextFieldState determineState(String str) {
        TextFieldStateConstants.Error error;
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.INPUT);
        if (StringsKt.isBlank(str)) {
            return TextFieldStateConstants.Error.Blank.INSTANCE;
        }
        String convertTo4DigitDate = DateUtilsKt.convertTo4DigitDate(str);
        if (convertTo4DigitDate.length() < 4) {
            error = new TextFieldStateConstants.Error.Incomplete(R.string.incomplete_expiry_date);
        } else if (convertTo4DigitDate.length() > 4) {
            error = new TextFieldStateConstants.Error.Invalid(R.string.incomplete_expiry_date, (Object[]) null, 2, (DefaultConstructorMarker) null);
        } else {
            Companion companion = Companion;
            Integer intOrNull = StringsKt.toIntOrNull(StringsKt.take(convertTo4DigitDate, 2));
            if (intOrNull != null) {
                int intValue = intOrNull.intValue();
                Integer intOrNull2 = StringsKt.toIntOrNull(StringsKt.takeLast(convertTo4DigitDate, 2));
                if (intOrNull2 != null) {
                    return companion.determineTextFieldState(intValue, intOrNull2.intValue(), Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(1));
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return error;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/DateConfig$Companion;", "", "()V", "determineTextFieldState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "month1Based", "", "twoDigitYear", "current1BasedMonth", "currentYear", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DateConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TextFieldState determineTextFieldState(int i, int i2, int i3, int i4) {
            int i5 = i2 - (i4 % 100);
            if (i5 < 0) {
                return new TextFieldStateConstants.Error.Invalid(R.string.invalid_expiry_year, (Object[]) null, 2, (DefaultConstructorMarker) null);
            }
            if (i5 > 50) {
                return new TextFieldStateConstants.Error.Invalid(R.string.invalid_expiry_year, (Object[]) null, 2, (DefaultConstructorMarker) null);
            }
            if (i5 == 0 && i3 > i) {
                return new TextFieldStateConstants.Error.Invalid(R.string.invalid_expiry_month, (Object[]) null, 2, (DefaultConstructorMarker) null);
            }
            boolean z = false;
            if (1 <= i && i < 13) {
                z = true;
            }
            if (!z) {
                return new TextFieldStateConstants.Error.Incomplete(R.string.invalid_expiry_month);
            }
            return TextFieldStateConstants.Valid.Full.INSTANCE;
        }
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
