package com.stripe.android.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.R;
import com.stripe.android.cards.CardNumber;
import com.stripe.android.core.model.CountryCode;
import com.stripe.android.databinding.StripeCardFormViewBinding;
import com.stripe.android.databinding.StripeHorizontalDividerBinding;
import com.stripe.android.databinding.StripeVerticalDividerBinding;
import com.stripe.android.model.Address;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.ExpirationDate;
import com.stripe.android.view.CardValidCallback;
import com.stripe.android.view.PostalCodeEditText;
import com.stripe.android.view.StripeEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0019\b\u0007\u0018\u0000 M2\u00020\u0001:\u0002MNB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000207H\u0002J\b\u00109\u001a\u00020:H\u0002J\u001a\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010>\u001a\u0002072\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\b\u0010A\u001a\u00020@H\u0014J\u0010\u0010B\u001a\u0002072\b\u0010C\u001a\u0004\u0018\u00010\u0017J\u0010\u0010D\u001a\u0002072\u0006\u0010E\u001a\u00020:H\u0016J\b\u0010F\u001a\u000207H\u0002J\b\u0010G\u001a\u000207H\u0002J\b\u0010H\u001a\u000207H\u0002J\u0012\u0010I\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u00010$H\u0002J\u0012\u0010J\u001a\u0002072\b\u0010K\u001a\u0004\u0018\u00010LH\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010$0\"X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0&8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\n +*\u0004\u0018\u00010*0*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/stripe/android/view/CardFormView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allEditTextFields", "", "Lcom/stripe/android/view/StripeEditText;", "getAllEditTextFields", "()Ljava/util/Collection;", "cardContainer", "Lcom/google/android/material/card/MaterialCardView;", "cardMultilineWidget", "Lcom/stripe/android/view/CardMultilineWidget;", "cardParams", "Lcom/stripe/android/model/CardParams;", "getCardParams", "()Lcom/stripe/android/model/CardParams;", "cardValidCallback", "Lcom/stripe/android/view/CardValidCallback;", "cardValidTextWatcher", "com/stripe/android/view/CardFormView$cardValidTextWatcher$1", "Lcom/stripe/android/view/CardFormView$cardValidTextWatcher$1;", "countryLayout", "Lcom/stripe/android/view/CountryTextInputLayout;", "countryPostalDivider", "Landroid/view/View;", "errors", "Landroid/widget/TextView;", "errorsMap", "", "Lcom/stripe/android/view/CardValidCallback$Fields;", "", "invalidFields", "", "getInvalidFields", "()Ljava/util/Set;", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "postalCodeContainer", "Lcom/google/android/material/textfield/TextInputLayout;", "postalCodeValidator", "Lcom/stripe/android/view/PostalCodeValidator;", "postalCodeView", "Lcom/stripe/android/view/PostalCodeEditText;", "style", "Lcom/stripe/android/view/CardFormView$Style;", "viewBinding", "Lcom/stripe/android/databinding/StripeCardFormViewBinding;", "applyBorderlessStyle", "", "applyStandardStyle", "isPostalValid", "", "onFieldError", "field", "errorMessage", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "setCardValidCallback", "callback", "setEnabled", "enabled", "setupCardWidget", "setupCountryAndPostal", "showPostalError", "updateErrorsView", "updatePostalCodeViewLocale", "countryCode", "Lcom/stripe/android/core/model/CountryCode;", "Companion", "Style", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardFormView.kt */
public final class CardFormView extends LinearLayout {
    public static final int $stable = 8;
    public static final String CARD_FORM_VIEW = "CardFormView";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String STATE_ENABLED = "state_enabled";
    private static final String STATE_SUPER_STATE = "state_super_state";
    private final MaterialCardView cardContainer;
    /* access modifiers changed from: private */
    public final CardMultilineWidget cardMultilineWidget;
    /* access modifiers changed from: private */
    public CardValidCallback cardValidCallback;
    private final CardFormView$cardValidTextWatcher$1 cardValidTextWatcher;
    private final CountryTextInputLayout countryLayout;
    private final View countryPostalDivider;
    private final TextView errors;
    private final Map<CardValidCallback.Fields, String> errorsMap;
    private final LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public final TextInputLayout postalCodeContainer;
    private final PostalCodeValidator postalCodeValidator;
    /* access modifiers changed from: private */
    public final PostalCodeEditText postalCodeView;
    private Style style;
    private final StripeCardFormViewBinding viewBinding;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardFormView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Style.values().length];
            iArr[Style.Standard.ordinal()] = 1;
            iArr[Style.Borderless.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardFormView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardFormView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardFormView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater from = LayoutInflater.from(context);
        this.layoutInflater = from;
        StripeCardFormViewBinding inflate = StripeCardFormViewBinding.inflate(from, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, this)");
        this.viewBinding = inflate;
        MaterialCardView materialCardView = inflate.cardMultilineWidgetContainer;
        Intrinsics.checkNotNullExpressionValue(materialCardView, "viewBinding.cardMultilineWidgetContainer");
        this.cardContainer = materialCardView;
        CardMultilineWidget cardMultilineWidget2 = inflate.cardMultilineWidget;
        Intrinsics.checkNotNullExpressionValue(cardMultilineWidget2, "viewBinding.cardMultilineWidget");
        this.cardMultilineWidget = cardMultilineWidget2;
        View view = inflate.countryPostalDivider;
        Intrinsics.checkNotNullExpressionValue(view, "viewBinding.countryPostalDivider");
        this.countryPostalDivider = view;
        TextInputLayout textInputLayout = inflate.postalCodeContainer;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "viewBinding.postalCodeContainer");
        this.postalCodeContainer = textInputLayout;
        TextView textView = inflate.errors;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.errors");
        this.errors = textView;
        PostalCodeEditText postalCodeEditText = inflate.postalCode;
        Intrinsics.checkNotNullExpressionValue(postalCodeEditText, "viewBinding.postalCode");
        this.postalCodeView = postalCodeEditText;
        CountryTextInputLayout countryTextInputLayout = inflate.countryLayout;
        Intrinsics.checkNotNullExpressionValue(countryTextInputLayout, "viewBinding.countryLayout");
        this.countryLayout = countryTextInputLayout;
        this.postalCodeValidator = new PostalCodeValidator();
        this.style = Style.Standard;
        this.errorsMap = new LinkedHashMap();
        this.cardValidTextWatcher = new CardFormView$cardValidTextWatcher$1(this);
        setOrientation(1);
        setupCountryAndPostal();
        setupCardWidget();
        int[] iArr = R.styleable.StripeCardFormView;
        Intrinsics.checkNotNullExpressionValue(iArr, "StripeCardFormView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.StripeCardFormView_backgroundColorStateList);
        this.style = Style.values()[obtainStyledAttributes.getInt(R.styleable.StripeCardFormView_cardFormStyle, 0)];
        obtainStyledAttributes.recycle();
        if (colorStateList != null) {
            materialCardView.setCardBackgroundColor(colorStateList);
            cardMultilineWidget2.setBackgroundColor(0);
            countryTextInputLayout.setBackgroundColor(0);
            textInputLayout.setBackgroundColor(0);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.style.ordinal()];
        if (i2 == 1) {
            applyStandardStyle();
        } else if (i2 == 2) {
            applyBorderlessStyle();
        }
    }

    private final Collection<StripeEditText> getAllEditTextFields() {
        return CollectionsKt.listOf(this.cardMultilineWidget.getCardNumberEditText(), this.cardMultilineWidget.getExpiryDateEditText(), this.cardMultilineWidget.getCvcEditText(), this.postalCodeView);
    }

    /* access modifiers changed from: private */
    public final Set<CardValidCallback.Fields> getInvalidFields() {
        Collection list = CollectionsKt.toList(this.cardMultilineWidget.getInvalidFields$payments_core_release());
        CardValidCallback.Fields fields = CardValidCallback.Fields.Postal;
        if (!(!isPostalValid())) {
            fields = null;
        }
        return CollectionsKt.toSet(CollectionsKt.plus(list, CollectionsKt.listOfNotNull(fields)));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/CardFormView$Style;", "", "attrValue", "", "(Ljava/lang/String;II)V", "getAttrValue$payments_core_release", "()I", "Standard", "Borderless", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardFormView.kt */
    private enum Style {
        Standard(0),
        Borderless(1);
        
        private final int attrValue;

        private Style(int i) {
            this.attrValue = i;
        }

        public final int getAttrValue$payments_core_release() {
            return this.attrValue;
        }
    }

    public final CardParams getCardParams() {
        String str = null;
        if (!this.cardMultilineWidget.validateAllFields()) {
            this.cardMultilineWidget.setShouldShowErrorIcon$payments_core_release(true);
            return null;
        }
        this.cardMultilineWidget.setShouldShowErrorIcon$payments_core_release(false);
        if (!isPostalValid()) {
            showPostalError();
            return null;
        }
        updateErrorsView((String) null);
        ExpirationDate.Validated validatedDate = this.cardMultilineWidget.getExpiryDateEditText().getValidatedDate();
        if (validatedDate != null) {
            CardBrand brand$payments_core_release = this.cardMultilineWidget.getBrand$payments_core_release();
            Set of = SetsKt.setOf(CARD_FORM_VIEW);
            CardNumber.Validated validatedCardNumber$payments_core_release = this.cardMultilineWidget.getValidatedCardNumber$payments_core_release();
            String value = validatedCardNumber$payments_core_release == null ? null : validatedCardNumber$payments_core_release.getValue();
            if (value == null) {
                value = "";
            }
            String str2 = value;
            int month = validatedDate.getMonth();
            int year = validatedDate.getYear();
            Editable text = this.cardMultilineWidget.getCvcEditText().getText();
            String obj = text == null ? null : text.toString();
            Address.Builder countryCode = new Address.Builder().setCountryCode(this.countryLayout.getSelectedCountryCode$payments_core_release());
            Editable text2 = this.postalCodeView.getText();
            if (text2 != null) {
                str = text2.toString();
            }
            return new CardParams(brand$payments_core_release, of, str2, month, year, obj, (String) null, countryCode.setPostalCode(str).build(), (String) null, (Map) null, LeicaMakernoteDirectory.TAG_IMAGE_ID_NUMBER, (DefaultConstructorMarker) null);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setCardValidCallback(CardValidCallback cardValidCallback2) {
        this.cardValidCallback = cardValidCallback2;
        for (StripeEditText removeTextChangedListener : getAllEditTextFields()) {
            removeTextChangedListener.removeTextChangedListener(this.cardValidTextWatcher);
        }
        if (cardValidCallback2 != null) {
            for (StripeEditText addTextChangedListener : getAllEditTextFields()) {
                addTextChangedListener.addTextChangedListener(this.cardValidTextWatcher);
            }
        }
        CardValidCallback cardValidCallback3 = this.cardValidCallback;
        if (cardValidCallback3 != null) {
            cardValidCallback3.onInputChanged(getInvalidFields().isEmpty(), getInvalidFields());
        }
    }

    private final void setupCountryAndPostal() {
        updatePostalCodeViewLocale(this.countryLayout.getSelectedCountryCode$payments_core_release());
        this.postalCodeView.setErrorColor(ContextCompat.getColor(getContext(), R.color.stripe_card_form_view_form_error));
        this.postalCodeView.getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CardFormView.m4641setupCountryAndPostal$lambda5(CardFormView.this, view, z);
            }
        });
        this.postalCodeView.addTextChangedListener(new CardFormView$setupCountryAndPostal$$inlined$doAfterTextChanged$1(this));
        this.postalCodeView.setErrorMessageListener(new CardFormView$setupCountryAndPostal$3(this));
        this.countryLayout.setCountryCodeChangeCallback(new CardFormView$setupCountryAndPostal$4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupCountryAndPostal$lambda-5  reason: not valid java name */
    public static final void m4641setupCountryAndPostal$lambda5(CardFormView cardFormView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cardFormView, "this$0");
        if (!z) {
            PostalCodeEditText postalCodeEditText = cardFormView.postalCodeView;
            boolean z2 = true;
            if (!(!StringsKt.isBlank(postalCodeEditText.getFieldText$payments_core_release())) || cardFormView.isPostalValid()) {
                z2 = false;
            }
            postalCodeEditText.setShouldShowError(z2);
            if (cardFormView.postalCodeView.getShouldShowError()) {
                cardFormView.showPostalError();
            } else {
                cardFormView.onFieldError(CardValidCallback.Fields.Postal, (String) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updatePostalCodeViewLocale(CountryCode countryCode) {
        if (CountryCode.Companion.isUS(countryCode)) {
            this.postalCodeView.setConfig$payments_core_release(PostalCodeEditText.Config.US);
            this.postalCodeView.setErrorMessage(getResources().getString(R.string.address_zip_invalid));
            return;
        }
        this.postalCodeView.setConfig$payments_core_release(PostalCodeEditText.Config.Global);
        this.postalCodeView.setErrorMessage(getResources().getString(R.string.address_postal_code_invalid));
    }

    private final boolean isPostalValid() {
        CountryCode selectedCountryCode$payments_core_release = this.countryLayout.getSelectedCountryCode$payments_core_release();
        if (selectedCountryCode$payments_core_release == null) {
            return false;
        }
        PostalCodeValidator postalCodeValidator2 = this.postalCodeValidator;
        String postalCode$payments_core_release = this.postalCodeView.getPostalCode$payments_core_release();
        if (postalCode$payments_core_release == null) {
            postalCode$payments_core_release = "";
        }
        return postalCodeValidator2.isValid(postalCode$payments_core_release, selectedCountryCode$payments_core_release.getValue());
    }

    private final void showPostalError() {
        onFieldError(CardValidCallback.Fields.Postal, this.postalCodeView.getErrorMessage$payments_core_release());
    }

    private final void setupCardWidget() {
        for (StripeEditText stripeEditText : SetsKt.setOf(this.cardMultilineWidget.getCardNumberEditText(), this.cardMultilineWidget.getExpiryDateEditText(), this.cardMultilineWidget.getCvcEditText())) {
            stripeEditText.setTextSize(0, getResources().getDimension(R.dimen.stripe_card_form_view_textsize));
            stripeEditText.setTextColor(ContextCompat.getColorStateList(getContext(), R.color.stripe_card_form_view_text_color));
            stripeEditText.setBackgroundResource(17170445);
            stripeEditText.setErrorColor(ContextCompat.getColor(getContext(), R.color.stripe_card_form_view_form_error));
        }
        this.cardMultilineWidget.getExpiryDateEditText().setIncludeSeparatorGaps$payments_core_release(true);
        this.cardMultilineWidget.setExpirationDatePlaceholderRes$payments_core_release((Integer) null);
        this.cardMultilineWidget.getExpiryTextInputLayout().setHint((CharSequence) getContext().getString(R.string.stripe_paymentsheet_expiration_date_hint));
        this.cardMultilineWidget.getCardNumberTextInputLayout().setPlaceholderText((CharSequence) null);
        this.cardMultilineWidget.setCvcPlaceholderText("");
        this.cardMultilineWidget.getCvcEditText().setImeOptions(5);
        this.cardMultilineWidget.setBackgroundResource(R.drawable.stripe_card_form_view_text_input_layout_background);
        this.cardMultilineWidget.getCvcEditText().addTextChangedListener(new CardFormView$setupCardWidget$$inlined$doAfterTextChanged$1(this));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stripe_card_form_view_text_margin_horizontal);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.stripe_card_form_view_text_margin_vertical);
        for (TextInputLayout textInputLayout : SetsKt.setOf(this.cardMultilineWidget.getCardNumberTextInputLayout(), this.cardMultilineWidget.getExpiryTextInputLayout(), this.cardMultilineWidget.getCvcInputLayout())) {
            View view = textInputLayout;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
            layoutParams3.setMarginStart(dimensionPixelSize);
            layoutParams3.setMarginEnd(dimensionPixelSize);
            layoutParams3.topMargin = dimensionPixelSize2;
            layoutParams3.bottomMargin = dimensionPixelSize2;
            view.setLayoutParams(layoutParams2);
            textInputLayout.setErrorEnabled(false);
            textInputLayout.setError((CharSequence) null);
        }
        this.cardMultilineWidget.setCvcIcon(Integer.valueOf(R.drawable.stripe_ic_paymentsheet_cvc));
        this.cardMultilineWidget.setCardNumberErrorListener$payments_core_release(new CardFormView$setupCardWidget$4(this));
        this.cardMultilineWidget.setExpirationDateErrorListener$payments_core_release(new CardFormView$setupCardWidget$5(this));
        this.cardMultilineWidget.setCvcErrorListener$payments_core_release(new CardFormView$setupCardWidget$6(this));
        this.cardMultilineWidget.setPostalCodeErrorListener$payments_core_release((StripeEditText.ErrorMessageListener) null);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.cardContainer.setEnabled(z);
        this.cardMultilineWidget.setEnabled(z);
        this.countryLayout.setEnabled(z);
        this.postalCodeContainer.setEnabled(z);
        this.errors.setEnabled(z);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return BundleKt.bundleOf(TuplesKt.to(STATE_SUPER_STATE, super.onSaveInstanceState()), TuplesKt.to(STATE_ENABLED, Boolean.valueOf(isEnabled())));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER_STATE));
            setEnabled(bundle.getBoolean(STATE_ENABLED));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private final void applyStandardStyle() {
        CardMultilineWidget cardMultilineWidget2 = this.cardMultilineWidget;
        cardMultilineWidget2.addView(StripeHorizontalDividerBinding.inflate(this.layoutInflater, cardMultilineWidget2, false).getRoot(), 1);
        this.cardMultilineWidget.getSecondRowLayout().addView(StripeVerticalDividerBinding.inflate(this.layoutInflater, this.cardMultilineWidget.getSecondRowLayout(), false).getRoot(), 1);
        CardMultilineWidget cardMultilineWidget3 = this.cardMultilineWidget;
        cardMultilineWidget3.addView(StripeHorizontalDividerBinding.inflate(this.layoutInflater, cardMultilineWidget3, false).getRoot(), this.cardMultilineWidget.getChildCount());
        this.cardContainer.setCardElevation(getResources().getDimension(R.dimen.stripe_card_form_view_card_elevation));
    }

    private final void applyBorderlessStyle() {
        this.cardMultilineWidget.getCardNumberTextInputLayout().addView(StripeHorizontalDividerBinding.inflate(this.layoutInflater, this.cardMultilineWidget, false).getRoot(), 1);
        this.cardMultilineWidget.getExpiryTextInputLayout().addView(StripeHorizontalDividerBinding.inflate(this.layoutInflater, this.cardMultilineWidget, false).getRoot(), 1);
        this.cardMultilineWidget.getCvcInputLayout().addView(StripeHorizontalDividerBinding.inflate(this.layoutInflater, this.cardMultilineWidget, false).getRoot(), 1);
        CountryTextInputLayout countryTextInputLayout = this.countryLayout;
        countryTextInputLayout.addView(StripeHorizontalDividerBinding.inflate(this.layoutInflater, countryTextInputLayout, false).getRoot());
        this.countryPostalDivider.setVisibility(8);
        this.cardContainer.setCardElevation(0.0f);
    }

    /* access modifiers changed from: private */
    public final void onFieldError(CardValidCallback.Fields fields, String str) {
        Object obj;
        this.errorsMap.put(fields, str);
        CardValidCallback.Fields[] values = CardValidCallback.Fields.values();
        Collection arrayList = new ArrayList(values.length);
        int length = values.length;
        int i = 0;
        while (i < length) {
            CardValidCallback.Fields fields2 = values[i];
            i++;
            arrayList.add(this.errorsMap.get(fields2));
        }
        Iterator it = ((List) arrayList).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            CharSequence charSequence = (String) obj;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                break;
            }
        }
        updateErrorsView((String) obj);
    }

    private final void updateErrorsView(String str) {
        this.errors.setText(str);
        View view = this.errors;
        int i = 0;
        if (!(str != null)) {
            i = 8;
        }
        view.setVisibility(i);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/CardFormView$Companion;", "", "()V", "CARD_FORM_VIEW", "", "STATE_ENABLED", "STATE_SUPER_STATE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardFormView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
