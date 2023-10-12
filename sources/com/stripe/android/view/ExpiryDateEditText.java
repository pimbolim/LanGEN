package com.stripe.android.view;

import android.content.Context;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.autofill.HintConstants;
import com.stripe.android.model.ExpirationDate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u0000 52\u00020\u0001:\u00015B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001e\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\u000fH\u0002J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0016H\u0007J#\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0004\b,\u0010-J-\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0001¢\u0006\u0002\b3J\u0012\u00104\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002R\u0014\u0010\t\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@@X\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010 \u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u00066"}, d2 = {"Lcom/stripe/android/view/ExpiryDateEditText;", "Lcom/stripe/android/view/StripeEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accessibilityText", "", "getAccessibilityText", "()Ljava/lang/String;", "completionCallback", "Lkotlin/Function0;", "", "getCompletionCallback$payments_core_release", "()Lkotlin/jvm/functions/Function0;", "setCompletionCallback$payments_core_release", "(Lkotlin/jvm/functions/Function0;)V", "dateDigitsLength", "<set-?>", "", "includeSeparatorGaps", "getIncludeSeparatorGaps$payments_core_release", "()Z", "setIncludeSeparatorGaps$payments_core_release", "(Z)V", "includeSeparatorGaps$delegate", "Lkotlin/properties/ReadWriteProperty;", "isDateValid", "separator", "validatedDate", "Lcom/stripe/android/model/ExpirationDate$Validated;", "getValidatedDate", "()Lcom/stripe/android/model/ExpirationDate$Validated;", "month", "year", "listenForTextChanges", "setIncludeSeparatorGaps", "include", "setText", "expiryMonth", "expiryYear", "setText$payments_core_release", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "updateSelectionIndex", "newLength", "editActionStart", "editActionAddition", "maxInputLength", "updateSelectionIndex$payments_core_release", "updateSeparatorUi", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExpiryDateEditText.kt */
public final class ExpiryDateEditText extends StripeEditText {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ExpiryDateEditText.class, "includeSeparatorGaps", "getIncludeSeparatorGaps$payments_core_release()Z", 0))};
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final boolean INCLUDE_SEPARATOR_GAPS_DEFAULT = false;
    @Deprecated
    private static final int INVALID_INPUT = -1;
    @Deprecated
    private static final String SEPARATOR_WITHOUT_GAPS = "/";
    @Deprecated
    private static final String SEPARATOR_WITH_GAPS = " / ";
    private /* synthetic */ Function0<Unit> completionCallback;
    /* access modifiers changed from: private */
    public final int dateDigitsLength;
    private final ReadWriteProperty includeSeparatorGaps$delegate;
    /* access modifiers changed from: private */
    public boolean isDateValid;
    /* access modifiers changed from: private */
    public String separator;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExpiryDateEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExpiryDateEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpiryDateEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpiryDateEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.completionCallback = ExpiryDateEditText$completionCallback$1.INSTANCE;
        Delegates delegates = Delegates.INSTANCE;
        this.includeSeparatorGaps$delegate = new ExpiryDateEditText$special$$inlined$observable$1(false, this);
        this.dateDigitsLength = context.getResources().getInteger(com.stripe.android.R.integer.stripe_date_digits_length);
        this.separator = SEPARATOR_WITHOUT_GAPS;
        setNumberOnlyInputType();
        updateSeparatorUi$default(this, false, 1, (Object) null);
        listenForTextChanges();
        if (Build.VERSION.SDK_INT >= 26) {
            setAutofillHints(new String[]{HintConstants.AUTOFILL_HINT_CREDIT_CARD_EXPIRATION_DATE});
        }
        getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                ExpiryDateEditText.m4664_init_$lambda1(ExpiryDateEditText.this, view, z);
            }
        });
        setLayoutDirection(0);
    }

    public final Function0<Unit> getCompletionCallback$payments_core_release() {
        return this.completionCallback;
    }

    public final void setCompletionCallback$payments_core_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.completionCallback = function0;
    }

    public final boolean isDateValid() {
        return this.isDateValid;
    }

    public final ExpirationDate.Validated getValidatedDate() {
        boolean z = this.isDateValid;
        if (z) {
            return ExpirationDate.Unvalidated.Companion.create(getFieldText$payments_core_release()).validate();
        }
        if (!z) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: protected */
    public String getAccessibilityText() {
        String string = getResources().getString(com.stripe.android.R.string.acc_label_expiry_date_node, new Object[]{getText()});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…l_expiry_date_node, text)");
        return string;
    }

    public final boolean getIncludeSeparatorGaps$payments_core_release() {
        return ((Boolean) this.includeSeparatorGaps$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setIncludeSeparatorGaps$payments_core_release(boolean z) {
        this.includeSeparatorGaps$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final void setIncludeSeparatorGaps(boolean z) {
        setIncludeSeparatorGaps$payments_core_release(z);
    }

    public final void setText$payments_core_release(Integer num, Integer num2) {
        if (num != null && num2 != null) {
            setText(CollectionsKt.joinToString$default(CollectionsKt.listOf(StringsKt.padStart(num.toString(), 2, '0'), StringsKt.padStart(StringsKt.takeLast(num2.toString(), 2), 2, '0')), this.separator, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
    }

    static /* synthetic */ void updateSeparatorUi$default(ExpiryDateEditText expiryDateEditText, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        expiryDateEditText.updateSeparatorUi(z);
    }

    /* access modifiers changed from: private */
    public final void updateSeparatorUi(boolean z) {
        this.separator = z ? SEPARATOR_WITH_GAPS : SEPARATOR_WITHOUT_GAPS;
        Object[] array = CollectionsKt.listOf(new InputFilter.LengthFilter(this.dateDigitsLength + this.separator.length())).toArray(new InputFilter.LengthFilter[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        setFilters((InputFilter[]) array);
    }

    private final void listenForTextChanges() {
        addTextChangedListener(new ExpiryDateEditText$listenForTextChanges$1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m4664_init_$lambda1(ExpiryDateEditText expiryDateEditText, View view, boolean z) {
        Intrinsics.checkNotNullParameter(expiryDateEditText, "this$0");
        if (!z) {
            CharSequence text = expiryDateEditText.getText();
            if (!(text == null || text.length() == 0) && !expiryDateEditText.isDateValid) {
                expiryDateEditText.setShouldShowError(true);
            }
        }
    }

    public final int updateSelectionIndex$payments_core_release(int i, int i2, int i3, int i4) {
        int i5 = 0;
        int length = (i2 > 2 || i2 + i3 < 2) ? 0 : this.separator.length();
        boolean z = true;
        if (!(i3 == 0) || i2 != this.separator.length() + 2) {
            z = false;
        }
        int i6 = i2 + i3 + length;
        if (z && i6 > 0) {
            i5 = this.separator.length();
        }
        return Math.min(i4, Math.min(i6 - i5, i));
    }

    /* access modifiers changed from: private */
    public final boolean isDateValid(String str, String str2) {
        int i;
        Object obj;
        Object obj2;
        int i2 = -1;
        int i3 = -1;
        if (str.length() != 2) {
            i = -1;
        } else {
            try {
                Result.Companion companion = Result.Companion;
                ExpiryDateEditText expiryDateEditText = this;
                obj2 = Result.m4709constructorimpl(Integer.valueOf(Integer.parseInt(str)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m4715isFailureimpl(obj2)) {
                obj2 = -1;
            }
            i = ((Number) obj2).intValue();
        }
        if (str2.length() == 2) {
            try {
                Result.Companion companion3 = Result.Companion;
                ExpiryDateEditText expiryDateEditText2 = this;
                obj = Result.m4709constructorimpl(Integer.valueOf(DateUtils.INSTANCE.convertTwoDigitYearToFour(Integer.parseInt(str2))));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj = Result.m4709constructorimpl(ResultKt.createFailure(th2));
            }
            if (!Result.m4715isFailureimpl(obj)) {
                i3 = obj;
            }
            i2 = ((Number) i3).intValue();
        }
        return DateUtils.isExpiryDataValid(i, i2);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/view/ExpiryDateEditText$Companion;", "", "()V", "INCLUDE_SEPARATOR_GAPS_DEFAULT", "", "INVALID_INPUT", "", "SEPARATOR_WITHOUT_GAPS", "", "SEPARATOR_WITH_GAPS", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ExpiryDateEditText.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
