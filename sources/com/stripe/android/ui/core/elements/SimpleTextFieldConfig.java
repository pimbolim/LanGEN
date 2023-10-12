package com.stripe.android.ui.core.elements;

import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.VisualTransformation;
import com.braintreepayments.api.internal.GraphQLConstants;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B&\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\rH\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0016R\u001f\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Lcom/stripe/android/ui/core/elements/SimpleTextFieldConfig;", "Lcom/stripe/android/ui/core/elements/TextFieldConfig;", "label", "", "capitalization", "Landroidx/compose/ui/text/input/KeyboardCapitalization;", "keyboard", "Landroidx/compose/ui/text/input/KeyboardType;", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCapitalization-IUNYP9k", "()I", "I", "debugLabel", "", "getDebugLabel", "()Ljava/lang/String;", "getKeyboard-PjHm6EE", "getLabel", "loading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getLoading", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "trailingIcon", "Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "getTrailingIcon", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "convertFromRaw", "rawValue", "convertToRaw", "displayName", "determineState", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "input", "filter", "userTyped", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleTextFieldConfig.kt */
public final class SimpleTextFieldConfig implements TextFieldConfig {
    public static final int $stable = 8;
    private final int capitalization;
    private final String debugLabel;
    private final int keyboard;
    private final int label;
    private final MutableStateFlow<Boolean> loading;
    private final MutableStateFlow<TextFieldIcon> trailingIcon;
    private final VisualTransformation visualTransformation;

    public /* synthetic */ SimpleTextFieldConfig(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    public String convertFromRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        return str;
    }

    public String convertToRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        return str;
    }

    private SimpleTextFieldConfig(int i, int i2, int i3) {
        this.label = i;
        this.capitalization = i2;
        this.keyboard = i3;
        this.debugLabel = "generic_text";
        this.trailingIcon = StateFlowKt.MutableStateFlow(null);
        this.loading = StateFlowKt.MutableStateFlow(false);
    }

    public int getLabel() {
        return this.label;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleTextFieldConfig(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i4 & 2) != 0 ? KeyboardCapitalization.Companion.m3667getWordsIUNYP9k() : i2, (i4 & 4) != 0 ? KeyboardType.Companion.m3681getTextPjHm6EE() : i3, (DefaultConstructorMarker) null);
    }

    /* renamed from: getCapitalization-IUNYP9k  reason: not valid java name */
    public int m4593getCapitalizationIUNYP9k() {
        return this.capitalization;
    }

    /* renamed from: getKeyboard-PjHm6EE  reason: not valid java name */
    public int m4594getKeyboardPjHm6EE() {
        return this.keyboard;
    }

    public String getDebugLabel() {
        return this.debugLabel;
    }

    public VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public MutableStateFlow<TextFieldIcon> getTrailingIcon() {
        return this.trailingIcon;
    }

    public MutableStateFlow<Boolean> getLoading() {
        return this.loading;
    }

    public TextFieldState determineState(String str) {
        Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.INPUT);
        return new SimpleTextFieldConfig$determineState$1(str);
    }

    public String filter(String str) {
        Intrinsics.checkNotNullParameter(str, "userTyped");
        int i = 0;
        if (!SetsKt.setOf(KeyboardType.m3668boximpl(KeyboardType.Companion.m3677getNumberPjHm6EE()), KeyboardType.m3668boximpl(KeyboardType.Companion.m3678getNumberPasswordPjHm6EE())).contains(KeyboardType.m3668boximpl(m4594getKeyboardPjHm6EE()))) {
            return str;
        }
        CharSequence charSequence = str;
        Appendable sb = new StringBuilder();
        int length = charSequence.length();
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
