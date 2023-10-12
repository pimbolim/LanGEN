package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.VisualTransformation;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.TextFieldStateConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0016R\u001f\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00108\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Lcom/stripe/android/ui/core/elements/NameConfig;", "Lcom/stripe/android/ui/core/elements/TextFieldConfig;", "()V", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "getCapitalization-IUNYP9k", "()I", "I", "debugLabel", "", "getDebugLabel", "()Ljava/lang/String;", "keyboard", "Landroidx/compose/ui/text/input/KeyboardType;", "getKeyboard-PjHm6EE", "label", "", "getLabel", "loading", "Lkotlinx/coroutines/flow/StateFlow;", "", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "trailingIcon", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "getTrailingIcon", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "convertFromRaw", "rawValue", "convertToRaw", "displayName", "determineState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "input", "filter", "userTyped", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NameConfig.kt */
public final class NameConfig implements TextFieldConfig {
    public static final int $stable = 8;
    private final int capitalization = KeyboardCapitalization.Companion.m3667getWordsIUNYP9k();
    private final String debugLabel = "name";
    private final int keyboard = KeyboardType.Companion.m3681getTextPjHm6EE();
    private final int label = R.string.address_label_name;
    private final StateFlow<Boolean> loading = StateFlowKt.MutableStateFlow(false);
    private final MutableStateFlow<TextFieldIcon> trailingIcon = StateFlowKt.MutableStateFlow(null);
    private final VisualTransformation visualTransformation;

    public String convertFromRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        return str;
    }

    public String convertToRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        return str;
    }

    public int getLabel() {
        return this.label;
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public int m4587getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    public String getDebugLabel() {
        return this.debugLabel;
    }

    /* renamed from: getKeyboard-PjHm6EE  reason: not valid java name */
    public int m4588getKeyboardPjHm6EE() {
        return this.keyboard;
    }

    public VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public MutableStateFlow<TextFieldIcon> getTrailingIcon() {
        return this.trailingIcon;
    }

    public StateFlow<Boolean> getLoading() {
        return this.loading;
    }

    public TextFieldState determineState(String str) {
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.INPUT);
        if (str.length() == 0) {
            return TextFieldStateConstants.Error.Blank.INSTANCE;
        }
        return TextFieldStateConstants.Valid.Limitless.INSTANCE;
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
            if (Character.isLetter(charAt) || charAt == ' ') {
                sb.append(charAt);
            }
            i = i2;
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }
}
