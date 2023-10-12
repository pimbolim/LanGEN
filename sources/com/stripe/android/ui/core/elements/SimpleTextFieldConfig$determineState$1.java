package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/stripe/android/ui/core/elements/SimpleTextFieldConfig$determineState$1", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "getError", "Lcom/stripe/android/ui/core/elements/FieldError;", "isBlank", "", "isFull", "isValid", "shouldShowError", "hasFocus", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleTextFieldConfig.kt */
public final class SimpleTextFieldConfig$determineState$1 implements TextFieldState {
    final /* synthetic */ String $input;

    public FieldError getError() {
        return null;
    }

    public boolean isFull() {
        return false;
    }

    public boolean shouldShowError(boolean z) {
        return false;
    }

    SimpleTextFieldConfig$determineState$1(String str) {
        this.$input = str;
    }

    public boolean isValid() {
        return !StringsKt.isBlank(this.$input);
    }

    public boolean isBlank() {
        return StringsKt.isBlank(this.$input);
    }
}
