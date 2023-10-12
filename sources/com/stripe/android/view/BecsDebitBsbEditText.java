package com.stripe.android.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import androidx.appcompat.R;
import com.stripe.android.view.BecsDebitBanks;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0014H\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R(\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/stripe/android/view/BecsDebitBsbEditText;", "Lcom/stripe/android/view/StripeEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bank", "Lcom/stripe/android/view/BecsDebitBanks$Bank;", "getBank", "()Lcom/stripe/android/view/BecsDebitBanks$Bank;", "banks", "Lcom/stripe/android/view/BecsDebitBanks;", "bsb", "", "getBsb$payments_core_release", "()Ljava/lang/String;", "isComplete", "", "()Z", "onBankChangedCallback", "Lkotlin/Function1;", "", "getOnBankChangedCallback", "()Lkotlin/jvm/functions/Function1;", "setOnBankChangedCallback", "(Lkotlin/jvm/functions/Function1;)V", "onCompletedCallback", "Lkotlin/Function0;", "getOnCompletedCallback", "()Lkotlin/jvm/functions/Function0;", "setOnCompletedCallback", "(Lkotlin/jvm/functions/Function0;)V", "formatBsb", "updateIcon", "isError", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BecsDebitBsbEditText.kt */
public final class BecsDebitBsbEditText extends StripeEditText {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int MAX_LENGTH = 7;
    @Deprecated
    private static final int MIN_VALIDATION_THRESHOLD = 2;
    @Deprecated
    private static final String SEPARATOR = "-";
    private final BecsDebitBanks banks;
    private Function1<? super BecsDebitBanks.Bank, Unit> onBankChangedCallback;
    private Function0<Unit> onCompletedCallback;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BecsDebitBsbEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BecsDebitBsbEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BecsDebitBsbEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BecsDebitBsbEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.banks = new BecsDebitBanks(context, false, 2, (DefaultConstructorMarker) null);
        this.onBankChangedCallback = BecsDebitBsbEditText$onBankChangedCallback$1.INSTANCE;
        this.onCompletedCallback = BecsDebitBsbEditText$onCompletedCallback$1.INSTANCE;
        setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(7)});
        setInputType(2);
        addTextChangedListener(new StripeTextWatcher(this) {
            private String formattedBsb;
            private boolean ignoreChanges;
            private Integer newCursorPosition;
            final /* synthetic */ BecsDebitBsbEditText this$0;

            {
                this.this$0 = r1;
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String str;
                if (!this.ignoreChanges && i <= 4) {
                    Integer num = null;
                    if (charSequence == null) {
                        str = null;
                    } else {
                        str = charSequence.toString();
                    }
                    if (str == null) {
                        str = "";
                    }
                    CharSequence charSequence2 = str;
                    Appendable sb = new StringBuilder();
                    int i4 = 0;
                    int length = charSequence2.length();
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
                    String access$formatBsb = this.this$0.formatBsb(sb2);
                    this.formattedBsb = access$formatBsb;
                    if (access$formatBsb != null) {
                        num = Integer.valueOf(access$formatBsb.length());
                    }
                    this.newCursorPosition = num;
                }
            }

            public void afterTextChanged(Editable editable) {
                String str;
                String str2;
                if (!this.ignoreChanges) {
                    boolean z = true;
                    this.ignoreChanges = true;
                    if (!this.this$0.isLastKeyDelete() && (str2 = this.formattedBsb) != null) {
                        this.this$0.setText(str2);
                        Integer num = this.newCursorPosition;
                        if (num != null) {
                            BecsDebitBsbEditText becsDebitBsbEditText = this.this$0;
                            becsDebitBsbEditText.setSelection(RangesKt.coerceIn(num.intValue(), 0, becsDebitBsbEditText.getFieldText$payments_core_release().length()));
                        }
                    }
                    this.formattedBsb = null;
                    this.newCursorPosition = null;
                    this.ignoreChanges = false;
                    boolean z2 = this.this$0.getBank() == null && this.this$0.getFieldText$payments_core_release().length() >= 2;
                    BecsDebitBsbEditText becsDebitBsbEditText2 = this.this$0;
                    if (z2) {
                        str = becsDebitBsbEditText2.getResources().getString(com.stripe.android.R.string.becs_widget_bsb_invalid);
                    } else {
                        str = null;
                    }
                    becsDebitBsbEditText2.setErrorMessage$payments_core_release(str);
                    BecsDebitBsbEditText becsDebitBsbEditText3 = this.this$0;
                    if (becsDebitBsbEditText3.getErrorMessage$payments_core_release() == null) {
                        z = false;
                    }
                    becsDebitBsbEditText3.setShouldShowError(z);
                    this.this$0.getOnBankChangedCallback().invoke(this.this$0.getBank());
                    this.this$0.updateIcon(z2);
                    if (this.this$0.isComplete()) {
                        this.this$0.getOnCompletedCallback().invoke();
                    }
                }
            }
        });
    }

    public final Function1<BecsDebitBanks.Bank, Unit> getOnBankChangedCallback() {
        return this.onBankChangedCallback;
    }

    public final void setOnBankChangedCallback(Function1<? super BecsDebitBanks.Bank, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onBankChangedCallback = function1;
    }

    public final Function0<Unit> getOnCompletedCallback() {
        return this.onCompletedCallback;
    }

    public final void setOnCompletedCallback(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onCompletedCallback = function0;
    }

    public final String getBsb$payments_core_release() {
        String str;
        if (getFieldText$payments_core_release().length() < 2) {
            str = getResources().getString(com.stripe.android.R.string.becs_widget_bsb_incomplete);
        } else if (getBank() == null) {
            str = getResources().getString(com.stripe.android.R.string.becs_widget_bsb_invalid);
        } else if (getFieldText$payments_core_release().length() < 7) {
            str = getResources().getString(com.stripe.android.R.string.becs_widget_bsb_incomplete);
        } else {
            str = null;
        }
        setErrorMessage$payments_core_release(str);
        CharSequence fieldText$payments_core_release = getFieldText$payments_core_release();
        Appendable sb = new StringBuilder();
        int i = 0;
        int length = fieldText$payments_core_release.length();
        while (i < length) {
            int i2 = i + 1;
            char charAt = fieldText$payments_core_release.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
            i = i2;
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        if (isComplete()) {
            return sb2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final boolean isComplete() {
        return getBank() != null && getFieldText$payments_core_release().length() == 7;
    }

    /* access modifiers changed from: private */
    public final BecsDebitBanks.Bank getBank() {
        return this.banks.byPrefix(getFieldText$payments_core_release());
    }

    /* access modifiers changed from: private */
    public final void updateIcon(boolean z) {
        int i;
        if (z) {
            i = com.stripe.android.R.drawable.stripe_ic_bank_error;
        } else {
            i = com.stripe.android.R.drawable.stripe_ic_bank;
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(i, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    public final String formatBsb(String str) {
        if (str.length() < 3) {
            return str;
        }
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(StringsKt.take(str, 3), StringsKt.takeLast(str, str.length() - 3)), SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/BecsDebitBsbEditText$Companion;", "", "()V", "MAX_LENGTH", "", "MIN_VALIDATION_THRESHOLD", "SEPARATOR", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BecsDebitBsbEditText.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
