package com.stripe.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.autofill.HintConstants;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.R;
import com.stripe.android.databinding.BecsDebitWidgetBinding;
import com.stripe.android.model.Address;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.view.BecsDebitBanks;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001!B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010 \u001a\u00020\u001fH\u0002R\u0014\u0010\u000b\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198@X\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/stripe/android/view/BecsDebitWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "companyName", "", "(Landroid/content/Context;Landroid/util/AttributeSet;ILjava/lang/String;)V", "isInputValid", "", "()Z", "params", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "getParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "validParamsCallback", "Lcom/stripe/android/view/BecsDebitWidget$ValidParamsCallback;", "getValidParamsCallback", "()Lcom/stripe/android/view/BecsDebitWidget$ValidParamsCallback;", "setValidParamsCallback", "(Lcom/stripe/android/view/BecsDebitWidget$ValidParamsCallback;)V", "viewBinding", "Lcom/stripe/android/databinding/BecsDebitWidgetBinding;", "getViewBinding$payments_core_release", "()Lcom/stripe/android/databinding/BecsDebitWidgetBinding;", "viewBinding$delegate", "Lkotlin/Lazy;", "applyAttributes", "", "verifyCompanyName", "ValidParamsCallback", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BecsDebitWidget.kt */
public final class BecsDebitWidget extends FrameLayout {
    public static final int $stable = 8;
    private ValidParamsCallback validParamsCallback;
    private final Lazy viewBinding$delegate;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/view/BecsDebitWidget$ValidParamsCallback;", "", "onInputChanged", "", "isValid", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BecsDebitWidget.kt */
    public interface ValidParamsCallback {
        void onInputChanged(boolean z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BecsDebitWidget(Context context) {
        this(context, (AttributeSet) null, 0, (String) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BecsDebitWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, (String) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BecsDebitWidget(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (String) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BecsDebitWidget(Context context, AttributeSet attributeSet, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BecsDebitWidget(Context context, AttributeSet attributeSet, int i, String str) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "companyName");
        this.viewBinding$delegate = LazyKt.lazy(new BecsDebitWidget$viewBinding$2(context, this));
        this.validParamsCallback = new BecsDebitWidget$validParamsCallback$1();
        if (Build.VERSION.SDK_INT >= 26) {
            getViewBinding$payments_core_release().nameEditText.setAutofillHints(new String[]{"name"});
            getViewBinding$payments_core_release().emailEditText.setAutofillHints(new String[]{HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS});
        }
        for (StripeEditText stripeEditText : SetsKt.setOf(getViewBinding$payments_core_release().nameEditText, getViewBinding$payments_core_release().emailEditText, getViewBinding$payments_core_release().bsbEditText, getViewBinding$payments_core_release().accountNumberEditText)) {
            Intrinsics.checkNotNullExpressionValue(stripeEditText, "field");
            stripeEditText.addTextChangedListener(new BecsDebitWidget$_init_$lambda1$$inlined$doAfterTextChanged$1(this));
        }
        getViewBinding$payments_core_release().bsbEditText.setOnBankChangedCallback(new Function1<BecsDebitBanks.Bank, Unit>(this) {
            final /* synthetic */ BecsDebitWidget this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BecsDebitBanks.Bank) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
                if (r0.equals("73") == false) goto L_0x00b9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
                if (r0.equals("08") == false) goto L_0x00b9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a3, code lost:
                if (r0.equals("03") == false) goto L_0x00b9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ae, code lost:
                if (r0.equals("01") == false) goto L_0x00b9;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b7, code lost:
                if (r0.equals("00") == false) goto L_0x00b9;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(com.stripe.android.view.BecsDebitBanks.Bank r5) {
                /*
                    r4 = this;
                    r0 = 0
                    if (r5 == 0) goto L_0x0021
                    com.stripe.android.view.BecsDebitWidget r1 = r4.this$0
                    com.stripe.android.databinding.BecsDebitWidgetBinding r1 = r1.getViewBinding$payments_core_release()
                    com.google.android.material.textfield.TextInputLayout r1 = r1.bsbTextInputLayout
                    java.lang.String r2 = r5.getName()
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    r1.setHelperText(r2)
                    com.stripe.android.view.BecsDebitWidget r1 = r4.this$0
                    com.stripe.android.databinding.BecsDebitWidgetBinding r1 = r1.getViewBinding$payments_core_release()
                    com.google.android.material.textfield.TextInputLayout r1 = r1.bsbTextInputLayout
                    r2 = 1
                    r1.setHelperTextEnabled(r2)
                    goto L_0x0038
                L_0x0021:
                    com.stripe.android.view.BecsDebitWidget r1 = r4.this$0
                    com.stripe.android.databinding.BecsDebitWidgetBinding r1 = r1.getViewBinding$payments_core_release()
                    com.google.android.material.textfield.TextInputLayout r1 = r1.bsbTextInputLayout
                    r1.setHelperText(r0)
                    com.stripe.android.view.BecsDebitWidget r1 = r4.this$0
                    com.stripe.android.databinding.BecsDebitWidgetBinding r1 = r1.getViewBinding$payments_core_release()
                    com.google.android.material.textfield.TextInputLayout r1 = r1.bsbTextInputLayout
                    r2 = 0
                    r1.setHelperTextEnabled(r2)
                L_0x0038:
                    com.stripe.android.view.BecsDebitWidget r1 = r4.this$0
                    com.stripe.android.databinding.BecsDebitWidgetBinding r1 = r1.getViewBinding$payments_core_release()
                    com.stripe.android.view.BecsDebitAccountNumberEditText r1 = r1.accountNumberEditText
                    if (r5 != 0) goto L_0x0043
                    goto L_0x004f
                L_0x0043:
                    java.lang.String r5 = r5.getPrefix()
                    if (r5 != 0) goto L_0x004a
                    goto L_0x004f
                L_0x004a:
                    r0 = 2
                    java.lang.String r0 = kotlin.text.StringsKt.take((java.lang.String) r5, (int) r0)
                L_0x004f:
                    r5 = 9
                    if (r0 == 0) goto L_0x00b9
                    int r2 = r0.hashCode()
                    r3 = 1536(0x600, float:2.152E-42)
                    if (r2 == r3) goto L_0x00b1
                    r3 = 1537(0x601, float:2.154E-42)
                    if (r2 == r3) goto L_0x00a8
                    r3 = 1539(0x603, float:2.157E-42)
                    if (r2 == r3) goto L_0x009d
                    r3 = 1542(0x606, float:2.161E-42)
                    if (r2 == r3) goto L_0x0091
                    r3 = 1544(0x608, float:2.164E-42)
                    if (r2 == r3) goto L_0x0088
                    r5 = 1756(0x6dc, float:2.46E-42)
                    if (r2 == r5) goto L_0x007f
                    r5 = 1784(0x6f8, float:2.5E-42)
                    if (r2 == r5) goto L_0x0074
                    goto L_0x00b9
                L_0x0074:
                    java.lang.String r5 = "80"
                    boolean r5 = r0.equals(r5)
                    if (r5 != 0) goto L_0x007d
                    goto L_0x00b9
                L_0x007d:
                    r5 = 4
                    goto L_0x00ba
                L_0x007f:
                    java.lang.String r5 = "73"
                    boolean r5 = r0.equals(r5)
                    if (r5 != 0) goto L_0x00a6
                    goto L_0x00b9
                L_0x0088:
                    java.lang.String r2 = "08"
                    boolean r0 = r0.equals(r2)
                    if (r0 != 0) goto L_0x00ba
                    goto L_0x00b9
                L_0x0091:
                    java.lang.String r5 = "06"
                    boolean r5 = r0.equals(r5)
                    if (r5 != 0) goto L_0x009a
                    goto L_0x00b9
                L_0x009a:
                    r5 = 8
                    goto L_0x00ba
                L_0x009d:
                    java.lang.String r5 = "03"
                    boolean r5 = r0.equals(r5)
                    if (r5 != 0) goto L_0x00a6
                    goto L_0x00b9
                L_0x00a6:
                    r5 = 6
                    goto L_0x00ba
                L_0x00a8:
                    java.lang.String r2 = "01"
                    boolean r0 = r0.equals(r2)
                    if (r0 != 0) goto L_0x00ba
                    goto L_0x00b9
                L_0x00b1:
                    java.lang.String r2 = "00"
                    boolean r0 = r0.equals(r2)
                    if (r0 != 0) goto L_0x00ba
                L_0x00b9:
                    r5 = 5
                L_0x00ba:
                    r1.setMinLength(r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.BecsDebitWidget.AnonymousClass2.invoke(com.stripe.android.view.BecsDebitBanks$Bank):void");
            }
        });
        getViewBinding$payments_core_release().bsbEditText.setOnCompletedCallback(new Function0<Unit>(this) {
            final /* synthetic */ BecsDebitWidget this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.getViewBinding$payments_core_release().accountNumberTextInputLayout.requestFocus();
            }
        });
        EmailEditText emailEditText = getViewBinding$payments_core_release().emailEditText;
        StripeEditText stripeEditText2 = getViewBinding$payments_core_release().nameEditText;
        Intrinsics.checkNotNullExpressionValue(stripeEditText2, "viewBinding.nameEditText");
        emailEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(stripeEditText2));
        BecsDebitBsbEditText becsDebitBsbEditText = getViewBinding$payments_core_release().bsbEditText;
        EmailEditText emailEditText2 = getViewBinding$payments_core_release().emailEditText;
        Intrinsics.checkNotNullExpressionValue(emailEditText2, "viewBinding.emailEditText");
        becsDebitBsbEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(emailEditText2));
        BecsDebitAccountNumberEditText becsDebitAccountNumberEditText = getViewBinding$payments_core_release().accountNumberEditText;
        BecsDebitBsbEditText becsDebitBsbEditText2 = getViewBinding$payments_core_release().bsbEditText;
        Intrinsics.checkNotNullExpressionValue(becsDebitBsbEditText2, "viewBinding.bsbEditText");
        becsDebitAccountNumberEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(becsDebitBsbEditText2));
        getViewBinding$payments_core_release().nameEditText.setErrorMessage$payments_core_release(getResources().getString(R.string.becs_widget_name_required));
        StripeEditText stripeEditText3 = getViewBinding$payments_core_release().nameEditText;
        TextInputLayout textInputLayout = getViewBinding$payments_core_release().nameTextInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "viewBinding.nameTextInputLayout");
        stripeEditText3.setErrorMessageListener(new ErrorListener(textInputLayout));
        EmailEditText emailEditText3 = getViewBinding$payments_core_release().emailEditText;
        TextInputLayout textInputLayout2 = getViewBinding$payments_core_release().emailTextInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout2, "viewBinding.emailTextInputLayout");
        emailEditText3.setErrorMessageListener(new ErrorListener(textInputLayout2));
        BecsDebitBsbEditText becsDebitBsbEditText3 = getViewBinding$payments_core_release().bsbEditText;
        TextInputLayout textInputLayout3 = getViewBinding$payments_core_release().bsbTextInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout3, "viewBinding.bsbTextInputLayout");
        becsDebitBsbEditText3.setErrorMessageListener(new ErrorListener(textInputLayout3));
        BecsDebitAccountNumberEditText becsDebitAccountNumberEditText2 = getViewBinding$payments_core_release().accountNumberEditText;
        TextInputLayout textInputLayout4 = getViewBinding$payments_core_release().accountNumberTextInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout4, "viewBinding.accountNumberTextInputLayout");
        becsDebitAccountNumberEditText2.setErrorMessageListener(new ErrorListener(textInputLayout4));
        for (StripeEditText stripeEditText4 : SetsKt.setOf(getViewBinding$payments_core_release().nameEditText, getViewBinding$payments_core_release().emailEditText)) {
            Intrinsics.checkNotNullExpressionValue(stripeEditText4, "field");
            stripeEditText4.addTextChangedListener(new BecsDebitWidget$_init_$lambda3$$inlined$doAfterTextChanged$1(stripeEditText4));
        }
        str = !(StringsKt.isBlank(str) ^ true) ? null : str;
        if (str != null) {
            getViewBinding$payments_core_release().mandateAcceptanceTextView.setCompanyName(str);
        }
        applyAttributes(attributeSet);
        verifyCompanyName();
    }

    public final BecsDebitWidgetBinding getViewBinding$payments_core_release() {
        return (BecsDebitWidgetBinding) this.viewBinding$delegate.getValue();
    }

    public final ValidParamsCallback getValidParamsCallback() {
        return this.validParamsCallback;
    }

    public final void setValidParamsCallback(ValidParamsCallback validParamsCallback2) {
        Intrinsics.checkNotNullParameter(validParamsCallback2, "<set-?>");
        this.validParamsCallback = validParamsCallback2;
    }

    /* access modifiers changed from: private */
    public final boolean isInputValid() {
        String fieldText$payments_core_release = getViewBinding$payments_core_release().nameEditText.getFieldText$payments_core_release();
        String email = getViewBinding$payments_core_release().emailEditText.getEmail();
        String bsb$payments_core_release = getViewBinding$payments_core_release().bsbEditText.getBsb$payments_core_release();
        String accountNumber = getViewBinding$payments_core_release().accountNumberEditText.getAccountNumber();
        if (!StringsKt.isBlank(fieldText$payments_core_release)) {
            CharSequence charSequence = email;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                CharSequence charSequence2 = bsb$payments_core_release;
                if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
                    CharSequence charSequence3 = accountNumber;
                    if (!(charSequence3 == null || StringsKt.isBlank(charSequence3))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final void verifyCompanyName() {
        if (!getViewBinding$payments_core_release().mandateAcceptanceTextView.isValid$payments_core_release()) {
            throw new IllegalArgumentException("A company name is required to render a BecsDebitWidget.".toString());
        }
    }

    private final void applyAttributes(AttributeSet attributeSet) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int[] iArr = R.styleable.BecsDebitWidget;
        Intrinsics.checkNotNullExpressionValue(iArr, "BecsDebitWidget");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        String string = obtainStyledAttributes.getString(R.styleable.BecsDebitWidget_companyName);
        if (string != null) {
            getViewBinding$payments_core_release().mandateAcceptanceTextView.setCompanyName(string);
        }
        obtainStyledAttributes.recycle();
    }

    public final PaymentMethodCreateParams getParams() {
        String fieldText$payments_core_release = getViewBinding$payments_core_release().nameEditText.getFieldText$payments_core_release();
        String email = getViewBinding$payments_core_release().emailEditText.getEmail();
        String bsb$payments_core_release = getViewBinding$payments_core_release().bsbEditText.getBsb$payments_core_release();
        String accountNumber = getViewBinding$payments_core_release().accountNumberEditText.getAccountNumber();
        CharSequence charSequence = fieldText$payments_core_release;
        getViewBinding$payments_core_release().nameEditText.setShouldShowError(StringsKt.isBlank(charSequence));
        CharSequence charSequence2 = email;
        boolean z = false;
        getViewBinding$payments_core_release().emailEditText.setShouldShowError(charSequence2 == null || StringsKt.isBlank(charSequence2));
        CharSequence charSequence3 = bsb$payments_core_release;
        getViewBinding$payments_core_release().bsbEditText.setShouldShowError(charSequence3 == null || StringsKt.isBlank(charSequence3));
        CharSequence charSequence4 = accountNumber;
        getViewBinding$payments_core_release().accountNumberEditText.setShouldShowError(charSequence4 == null || StringsKt.isBlank(charSequence4));
        if (StringsKt.isBlank(charSequence)) {
            return null;
        }
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            return null;
        }
        if (charSequence3 == null || StringsKt.isBlank(charSequence3)) {
            return null;
        }
        if (charSequence4 == null || StringsKt.isBlank(charSequence4)) {
            z = true;
        }
        if (z) {
            return null;
        }
        return PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.AuBecsDebit(bsb$payments_core_release, accountNumber), new PaymentMethod.BillingDetails((Address) null, email, fieldText$payments_core_release, (String) null, 9, (DefaultConstructorMarker) null), (Map) null, 4, (Object) null);
    }
}
