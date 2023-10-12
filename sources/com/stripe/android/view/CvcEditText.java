package com.stripe.android.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.autofill.HintConstants;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.cards.Cvc;
import com.stripe.android.model.CardBrand;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010!J9\u0010\"\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\b'R\u0014\u0010\t\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178@X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/stripe/android/view/CvcEditText;", "Lcom/stripe/android/view/StripeEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accessibilityText", "", "getAccessibilityText", "()Ljava/lang/String;", "cardBrand", "Lcom/stripe/android/model/CardBrand;", "completionCallback", "Lkotlin/Function0;", "", "getCompletionCallback$payments_core_release", "()Lkotlin/jvm/functions/Function0;", "setCompletionCallback$payments_core_release", "(Lkotlin/jvm/functions/Function0;)V", "cvc", "Lcom/stripe/android/cards/Cvc$Validated;", "getCvc$payments_core_release", "()Lcom/stripe/android/cards/Cvc$Validated;", "unvalidatedCvc", "Lcom/stripe/android/cards/Cvc$Unvalidated;", "getUnvalidatedCvc", "()Lcom/stripe/android/cards/Cvc$Unvalidated;", "createFilters", "", "Landroid/text/InputFilter;", "(Lcom/stripe/android/model/CardBrand;)[Landroid/text/InputFilter;", "updateBrand", "customHintText", "customPlaceholderText", "textInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "updateBrand$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CvcEditText.kt */
public final class CvcEditText extends StripeEditText {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public CardBrand cardBrand;
    private /* synthetic */ Function0<Unit> completionCallback;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CvcEditText.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardBrand.values().length];
            iArr[CardBrand.AmericanExpress.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CvcEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CvcEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CvcEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CvcEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cardBrand = CardBrand.Unknown;
        this.completionCallback = CvcEditText$completionCallback$1.INSTANCE;
        setErrorMessage(getResources().getString(com.stripe.android.R.string.invalid_cvc));
        setHint(com.stripe.android.R.string.cvc_number_hint);
        setMaxLines(1);
        setFilters(createFilters(CardBrand.Unknown));
        setNumberOnlyInputType();
        if (Build.VERSION.SDK_INT >= 26) {
            setAutofillHints(new String[]{HintConstants.AUTOFILL_HINT_CREDIT_CARD_SECURITY_CODE});
        }
        addTextChangedListener(new CvcEditText$special$$inlined$doAfterTextChanged$1(this));
        getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CvcEditText.m4658_init_$lambda1(CvcEditText.this, view, z);
            }
        });
        setLayoutDirection(0);
    }

    /* access modifiers changed from: private */
    public final Cvc.Unvalidated getUnvalidatedCvc() {
        return new Cvc.Unvalidated(getFieldText$payments_core_release());
    }

    public final Cvc.Validated getCvc$payments_core_release() {
        return getUnvalidatedCvc().validate(this.cardBrand.getMaxCvcLength());
    }

    public final Function0<Unit> getCompletionCallback$payments_core_release() {
        return this.completionCallback;
    }

    public final void setCompletionCallback$payments_core_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.completionCallback = function0;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m4658_init_$lambda1(CvcEditText cvcEditText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cvcEditText, "this$0");
        if (!z && cvcEditText.getUnvalidatedCvc().isPartialEntry(cvcEditText.cardBrand.getMaxCvcLength())) {
            cvcEditText.setShouldShowError(true);
        }
    }

    /* access modifiers changed from: protected */
    public String getAccessibilityText() {
        String string = getResources().getString(com.stripe.android.R.string.acc_label_cvc_node, new Object[]{getText()});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…acc_label_cvc_node, text)");
        return string;
    }

    public static /* synthetic */ void updateBrand$payments_core_release$default(CvcEditText cvcEditText, CardBrand cardBrand2, String str, String str2, TextInputLayout textInputLayout, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            textInputLayout = null;
        }
        cvcEditText.updateBrand$payments_core_release(cardBrand2, str, str2, textInputLayout);
    }

    public final /* synthetic */ void updateBrand$payments_core_release(CardBrand cardBrand2, String str, String str2, TextInputLayout textInputLayout) {
        CharSequence charSequence;
        int i;
        Intrinsics.checkNotNullParameter(cardBrand2, "cardBrand");
        this.cardBrand = cardBrand2;
        setFilters(createFilters(cardBrand2));
        if (str == null) {
            if (cardBrand2 == CardBrand.AmericanExpress) {
                str = getResources().getString(com.stripe.android.R.string.cvc_amex_hint);
            } else {
                str = getResources().getString(com.stripe.android.R.string.cvc_number_hint);
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (cardBrand == CardBra…umber_hint)\n            }");
        }
        boolean z = false;
        if (getUnvalidatedCvc().getNormalized$payments_core_release().length() > 0) {
            if (getUnvalidatedCvc().validate(cardBrand2.getMaxCvcLength()) == null) {
                z = true;
            }
            setShouldShowError(z);
        }
        if (textInputLayout != null) {
            textInputLayout.setHint((CharSequence) str);
            if (str2 == null) {
                Resources resources = getResources();
                if (WhenMappings.$EnumSwitchMapping$0[cardBrand2.ordinal()] == 1) {
                    i = com.stripe.android.R.string.cvc_multiline_helper_amex;
                } else {
                    i = com.stripe.android.R.string.cvc_multiline_helper;
                }
                charSequence = resources.getString(i);
            } else {
                charSequence = str2;
            }
            textInputLayout.setPlaceholderText(charSequence);
            return;
        }
        setHint(str);
    }

    private final InputFilter[] createFilters(CardBrand cardBrand2) {
        return new InputFilter[]{new InputFilter.LengthFilter(cardBrand2.getMaxCvcLength())};
    }
}
