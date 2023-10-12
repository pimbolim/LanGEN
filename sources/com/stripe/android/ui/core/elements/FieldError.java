package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/stripe/android/ui/core/elements/FieldError;", "", "errorMessage", "", "formatArgs", "", "(I[Ljava/lang/Object;)V", "getErrorMessage", "()I", "getFormatArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionFieldErrorController.kt */
public final class FieldError {
    public static final int $stable = 8;
    private final int errorMessage;
    private final Object[] formatArgs;

    public FieldError(int i, Object[] objArr) {
        this.errorMessage = i;
        this.formatArgs = objArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FieldError(int i, Object[] objArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : objArr);
    }

    public final int getErrorMessage() {
        return this.errorMessage;
    }

    public final Object[] getFormatArgs() {
        return this.formatArgs;
    }
}
