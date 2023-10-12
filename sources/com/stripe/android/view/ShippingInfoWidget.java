package com.stripe.android.view;

import android.content.Context;
import android.os.Build;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.autofill.HintConstants;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.R;
import com.stripe.android.core.model.Country;
import com.stripe.android.core.model.CountryCode;
import com.stripe.android.core.model.CountryUtils;
import com.stripe.android.databinding.AddressWidgetBinding;
import com.stripe.android.model.Address;
import com.stripe.android.model.ShippingInformation;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001OB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0015H\u0002J\u0010\u0010:\u001a\u0002082\u0006\u00109\u001a\u00020\u0015H\u0002J\u0010\u0010;\u001a\u0002082\u0006\u00109\u001a\u00020\u0015H\u0002J\u0010\u0010<\u001a\u0002052\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u0002052\b\u0010*\u001a\u0004\u0018\u00010'J\b\u0010@\u001a\u000205H\u0002J\b\u0010A\u001a\u000205H\u0002J\b\u0010B\u001a\u000205H\u0002J\b\u0010C\u001a\u000205H\u0002J\b\u0010D\u001a\u000205H\u0002J\u0014\u0010E\u001a\u0002052\f\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GJ\b\u0010I\u001a\u000205H\u0002J\u0010\u0010J\u001a\u0002052\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u0002052\u0006\u0010K\u001a\u00020LH\u0002J\u0006\u0010N\u001a\u000208R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R0\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u000e\u0010 \u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0013\u0010*\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\b+\u0010)R\u000e\u0010,\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101¨\u0006P"}, d2 = {"Lcom/stripe/android/view/ShippingInfoWidget;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addressEditText", "Lcom/stripe/android/view/StripeEditText;", "addressEditText2", "addressLine1TextInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "addressLine2TextInputLayout", "cityEditText", "cityTextInputLayout", "countryAutoCompleteTextView", "Lcom/stripe/android/view/CountryTextInputLayout;", "value", "", "Lcom/stripe/android/view/ShippingInfoWidget$CustomizableShippingField;", "hiddenFields", "getHiddenFields", "()Ljava/util/List;", "setHiddenFields", "(Ljava/util/List;)V", "nameEditText", "nameTextInputLayout", "optionalFields", "getOptionalFields", "setOptionalFields", "phoneNumberEditText", "phoneNumberTextInputLayout", "postalCodeEditText", "postalCodeTextInputLayout", "postalCodeValidator", "Lcom/stripe/android/view/PostalCodeValidator;", "rawShippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "getRawShippingInformation", "()Lcom/stripe/android/model/ShippingInformation;", "shippingInformation", "getShippingInformation", "stateEditText", "stateTextInputLayout", "viewBinding", "Lcom/stripe/android/databinding/AddressWidgetBinding;", "getViewBinding", "()Lcom/stripe/android/databinding/AddressWidgetBinding;", "viewBinding$delegate", "Lkotlin/Lazy;", "hideHiddenFields", "", "initView", "isFieldHidden", "", "field", "isFieldOptional", "isFieldRequired", "populateAddressFields", "address", "Lcom/stripe/android/model/Address;", "populateShippingInfo", "renderCanadianForm", "renderGreatBritainForm", "renderInternationalForm", "renderLabels", "renderUSForm", "setAllowedCountryCodes", "allowedCountryCodes", "", "", "setupErrorHandling", "updateConfigForCountry", "country", "Lcom/stripe/android/core/model/Country;", "updatePostalCodeInputFilter", "validateAllFields", "CustomizableShippingField", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShippingInfoWidget.kt */
public final class ShippingInfoWidget extends LinearLayout {
    public static final int $stable = 8;
    private final StripeEditText addressEditText;
    private final StripeEditText addressEditText2;
    private final TextInputLayout addressLine1TextInputLayout;
    private final TextInputLayout addressLine2TextInputLayout;
    private final StripeEditText cityEditText;
    private final TextInputLayout cityTextInputLayout;
    private final CountryTextInputLayout countryAutoCompleteTextView;
    private List<? extends CustomizableShippingField> hiddenFields;
    private final StripeEditText nameEditText;
    private final TextInputLayout nameTextInputLayout;
    private List<? extends CustomizableShippingField> optionalFields;
    private final StripeEditText phoneNumberEditText;
    private final TextInputLayout phoneNumberTextInputLayout;
    private final StripeEditText postalCodeEditText;
    private final TextInputLayout postalCodeTextInputLayout;
    private final PostalCodeValidator postalCodeValidator;
    private final StripeEditText stateEditText;
    private final TextInputLayout stateTextInputLayout;
    private final Lazy viewBinding$delegate;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/ShippingInfoWidget$CustomizableShippingField;", "", "(Ljava/lang/String;I)V", "Line1", "Line2", "City", "PostalCode", "State", "Phone", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShippingInfoWidget.kt */
    public enum CustomizableShippingField {
        Line1,
        Line2,
        City,
        PostalCode,
        State,
        Phone
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShippingInfoWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShippingInfoWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShippingInfoWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShippingInfoWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewBinding$delegate = LazyKt.lazy(new ShippingInfoWidget$viewBinding$2(context, this));
        this.postalCodeValidator = new PostalCodeValidator();
        this.optionalFields = CollectionsKt.emptyList();
        this.hiddenFields = CollectionsKt.emptyList();
        CountryTextInputLayout countryTextInputLayout = getViewBinding().countryAutocompleteAaw;
        Intrinsics.checkNotNullExpressionValue(countryTextInputLayout, "viewBinding.countryAutocompleteAaw");
        this.countryAutoCompleteTextView = countryTextInputLayout;
        TextInputLayout textInputLayout = getViewBinding().tlAddressLine1Aaw;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "viewBinding.tlAddressLine1Aaw");
        this.addressLine1TextInputLayout = textInputLayout;
        TextInputLayout textInputLayout2 = getViewBinding().tlAddressLine2Aaw;
        Intrinsics.checkNotNullExpressionValue(textInputLayout2, "viewBinding.tlAddressLine2Aaw");
        this.addressLine2TextInputLayout = textInputLayout2;
        TextInputLayout textInputLayout3 = getViewBinding().tlCityAaw;
        Intrinsics.checkNotNullExpressionValue(textInputLayout3, "viewBinding.tlCityAaw");
        this.cityTextInputLayout = textInputLayout3;
        TextInputLayout textInputLayout4 = getViewBinding().tlNameAaw;
        Intrinsics.checkNotNullExpressionValue(textInputLayout4, "viewBinding.tlNameAaw");
        this.nameTextInputLayout = textInputLayout4;
        TextInputLayout textInputLayout5 = getViewBinding().tlPostalCodeAaw;
        Intrinsics.checkNotNullExpressionValue(textInputLayout5, "viewBinding.tlPostalCodeAaw");
        this.postalCodeTextInputLayout = textInputLayout5;
        TextInputLayout textInputLayout6 = getViewBinding().tlStateAaw;
        Intrinsics.checkNotNullExpressionValue(textInputLayout6, "viewBinding.tlStateAaw");
        this.stateTextInputLayout = textInputLayout6;
        TextInputLayout textInputLayout7 = getViewBinding().tlPhoneNumberAaw;
        Intrinsics.checkNotNullExpressionValue(textInputLayout7, "viewBinding.tlPhoneNumberAaw");
        this.phoneNumberTextInputLayout = textInputLayout7;
        StripeEditText stripeEditText = getViewBinding().etAddressLineOneAaw;
        Intrinsics.checkNotNullExpressionValue(stripeEditText, "viewBinding.etAddressLineOneAaw");
        this.addressEditText = stripeEditText;
        StripeEditText stripeEditText2 = getViewBinding().etAddressLineTwoAaw;
        Intrinsics.checkNotNullExpressionValue(stripeEditText2, "viewBinding.etAddressLineTwoAaw");
        this.addressEditText2 = stripeEditText2;
        StripeEditText stripeEditText3 = getViewBinding().etCityAaw;
        Intrinsics.checkNotNullExpressionValue(stripeEditText3, "viewBinding.etCityAaw");
        this.cityEditText = stripeEditText3;
        StripeEditText stripeEditText4 = getViewBinding().etNameAaw;
        Intrinsics.checkNotNullExpressionValue(stripeEditText4, "viewBinding.etNameAaw");
        this.nameEditText = stripeEditText4;
        StripeEditText stripeEditText5 = getViewBinding().etPostalCodeAaw;
        Intrinsics.checkNotNullExpressionValue(stripeEditText5, "viewBinding.etPostalCodeAaw");
        this.postalCodeEditText = stripeEditText5;
        StripeEditText stripeEditText6 = getViewBinding().etStateAaw;
        Intrinsics.checkNotNullExpressionValue(stripeEditText6, "viewBinding.etStateAaw");
        this.stateEditText = stripeEditText6;
        StripeEditText stripeEditText7 = getViewBinding().etPhoneNumberAaw;
        Intrinsics.checkNotNullExpressionValue(stripeEditText7, "viewBinding.etPhoneNumberAaw");
        this.phoneNumberEditText = stripeEditText7;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 26) {
            stripeEditText4.setAutofillHints(new String[]{"name"});
            textInputLayout.setAutofillHints(new String[]{HintConstants.AUTOFILL_HINT_POSTAL_ADDRESS});
            stripeEditText5.setAutofillHints(new String[]{"postalCode"});
            stripeEditText7.setAutofillHints(new String[]{"phone"});
        }
        initView();
    }

    private final AddressWidgetBinding getViewBinding() {
        return (AddressWidgetBinding) this.viewBinding$delegate.getValue();
    }

    public final List<CustomizableShippingField> getOptionalFields() {
        return this.optionalFields;
    }

    public final void setOptionalFields(List<? extends CustomizableShippingField> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.optionalFields = list;
        renderLabels();
        Country selectedCountry$payments_core_release = this.countryAutoCompleteTextView.getSelectedCountry$payments_core_release();
        if (selectedCountry$payments_core_release != null) {
            updateConfigForCountry(selectedCountry$payments_core_release);
        }
    }

    public final List<CustomizableShippingField> getHiddenFields() {
        return this.hiddenFields;
    }

    public final void setHiddenFields(List<? extends CustomizableShippingField> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.hiddenFields = list;
        renderLabels();
        Country selectedCountry$payments_core_release = this.countryAutoCompleteTextView.getSelectedCountry$payments_core_release();
        if (selectedCountry$payments_core_release != null) {
            updateConfigForCountry(selectedCountry$payments_core_release);
        }
    }

    public final ShippingInformation getShippingInformation() {
        if (!validateAllFields()) {
            return null;
        }
        return getRawShippingInformation();
    }

    private final ShippingInformation getRawShippingInformation() {
        Address.Builder city = new Address.Builder().setCity(this.cityEditText.getFieldText$payments_core_release());
        Country selectedCountry$payments_core_release = this.countryAutoCompleteTextView.getSelectedCountry$payments_core_release();
        return new ShippingInformation(city.setCountryCode(selectedCountry$payments_core_release == null ? null : selectedCountry$payments_core_release.getCode()).setLine1(this.addressEditText.getFieldText$payments_core_release()).setLine2(this.addressEditText2.getFieldText$payments_core_release()).setPostalCode(this.postalCodeEditText.getFieldText$payments_core_release()).setState(this.stateEditText.getFieldText$payments_core_release()).build(), this.nameEditText.getFieldText$payments_core_release(), this.phoneNumberEditText.getFieldText$payments_core_release());
    }

    public final void populateShippingInfo(ShippingInformation shippingInformation) {
        if (shippingInformation != null) {
            Address address = shippingInformation.getAddress();
            if (address != null) {
                populateAddressFields(address);
            }
            this.nameEditText.setText(shippingInformation.getName());
            this.phoneNumberEditText.setText(shippingInformation.getPhone());
        }
    }

    private final void populateAddressFields(Address address) {
        this.cityEditText.setText(address.getCity());
        String country = address.getCountry();
        if (country != null) {
            if (country.length() > 0) {
                this.countryAutoCompleteTextView.setCountrySelected$payments_core_release(country);
            }
        }
        this.addressEditText.setText(address.getLine1());
        this.addressEditText2.setText(address.getLine2());
        this.postalCodeEditText.setText(address.getPostalCode());
        this.stateEditText.setText(address.getState());
    }

    public final void setAllowedCountryCodes(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "allowedCountryCodes");
        this.countryAutoCompleteTextView.setAllowedCountryCodes$payments_core_release(set);
    }

    public final boolean validateAllFields() {
        CountryCode code;
        Editable text = this.addressEditText.getText();
        String str = null;
        String obj = text == null ? null : text.toString();
        if (obj == null) {
            return false;
        }
        Editable text2 = this.nameEditText.getText();
        String obj2 = text2 == null ? null : text2.toString();
        if (obj2 == null) {
            return false;
        }
        Editable text3 = this.cityEditText.getText();
        String obj3 = text3 == null ? null : text3.toString();
        if (obj3 == null) {
            return false;
        }
        Editable text4 = this.stateEditText.getText();
        String obj4 = text4 == null ? null : text4.toString();
        if (obj4 == null) {
            return false;
        }
        Editable text5 = this.postalCodeEditText.getText();
        String obj5 = text5 == null ? null : text5.toString();
        if (obj5 == null) {
            return false;
        }
        Editable text6 = this.phoneNumberEditText.getText();
        String obj6 = text6 == null ? null : text6.toString();
        if (obj6 == null) {
            return false;
        }
        this.countryAutoCompleteTextView.validateCountry$payments_core_release();
        Country selectedCountry$payments_core_release = this.countryAutoCompleteTextView.getSelectedCountry$payments_core_release();
        PostalCodeValidator postalCodeValidator2 = this.postalCodeValidator;
        if (!(selectedCountry$payments_core_release == null || (code = selectedCountry$payments_core_release.getCode()) == null)) {
            str = code.getValue();
        }
        boolean isValid$payments_core_release = postalCodeValidator2.isValid$payments_core_release(obj5, str, this.optionalFields, this.hiddenFields);
        this.postalCodeEditText.setShouldShowError(!isValid$payments_core_release);
        boolean z = (obj.length() == 0) && isFieldRequired(CustomizableShippingField.Line1);
        this.addressEditText.setShouldShowError(z);
        boolean z2 = (obj3.length() == 0) && isFieldRequired(CustomizableShippingField.City);
        this.cityEditText.setShouldShowError(z2);
        boolean z3 = obj2.length() == 0;
        this.nameEditText.setShouldShowError(z3);
        boolean z4 = (obj4.length() == 0) && isFieldRequired(CustomizableShippingField.State);
        this.stateEditText.setShouldShowError(z4);
        boolean z5 = (obj6.length() == 0) && isFieldRequired(CustomizableShippingField.Phone);
        this.phoneNumberEditText.setShouldShowError(z5);
        if (!isValid$payments_core_release || z || z2 || z4 || z3 || z5 || selectedCountry$payments_core_release == null) {
            return false;
        }
        return true;
    }

    private final boolean isFieldRequired(CustomizableShippingField customizableShippingField) {
        return !isFieldOptional(customizableShippingField) && !isFieldHidden(customizableShippingField);
    }

    private final boolean isFieldOptional(CustomizableShippingField customizableShippingField) {
        return this.optionalFields.contains(customizableShippingField);
    }

    private final boolean isFieldHidden(CustomizableShippingField customizableShippingField) {
        return this.hiddenFields.contains(customizableShippingField);
    }

    private final void initView() {
        this.countryAutoCompleteTextView.setCountryChangeCallback$payments_core_release(new ShippingInfoWidget$initView$1(this));
        this.phoneNumberEditText.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        setupErrorHandling();
        renderLabels();
        Country selectedCountry$payments_core_release = this.countryAutoCompleteTextView.getSelectedCountry$payments_core_release();
        if (selectedCountry$payments_core_release != null) {
            updateConfigForCountry(selectedCountry$payments_core_release);
        }
    }

    private final void setupErrorHandling() {
        this.addressEditText.setErrorMessageListener(new ErrorListener(this.addressLine1TextInputLayout));
        this.cityEditText.setErrorMessageListener(new ErrorListener(this.cityTextInputLayout));
        this.nameEditText.setErrorMessageListener(new ErrorListener(this.nameTextInputLayout));
        this.postalCodeEditText.setErrorMessageListener(new ErrorListener(this.postalCodeTextInputLayout));
        this.stateEditText.setErrorMessageListener(new ErrorListener(this.stateTextInputLayout));
        this.phoneNumberEditText.setErrorMessageListener(new ErrorListener(this.phoneNumberTextInputLayout));
        this.addressEditText.setErrorMessage(getResources().getString(R.string.address_required));
        this.cityEditText.setErrorMessage(getResources().getString(R.string.address_city_required));
        this.nameEditText.setErrorMessage(getResources().getString(R.string.address_name_required));
        this.phoneNumberEditText.setErrorMessage(getResources().getString(R.string.address_phone_number_required));
    }

    private final void renderLabels() {
        CharSequence charSequence;
        CharSequence charSequence2;
        this.nameTextInputLayout.setHint((CharSequence) getResources().getString(R.string.address_label_name));
        TextInputLayout textInputLayout = this.cityTextInputLayout;
        if (isFieldOptional(CustomizableShippingField.City)) {
            charSequence = getResources().getString(R.string.address_label_city_optional);
        } else {
            charSequence = getResources().getString(R.string.address_label_city);
        }
        textInputLayout.setHint(charSequence);
        TextInputLayout textInputLayout2 = this.phoneNumberTextInputLayout;
        if (isFieldOptional(CustomizableShippingField.Phone)) {
            charSequence2 = getResources().getString(R.string.address_label_phone_number_optional);
        } else {
            charSequence2 = getResources().getString(R.string.address_label_phone_number);
        }
        textInputLayout2.setHint(charSequence2);
        hideHiddenFields();
    }

    private final void hideHiddenFields() {
        if (isFieldHidden(CustomizableShippingField.Line1)) {
            this.addressLine1TextInputLayout.setVisibility(8);
        }
        if (isFieldHidden(CustomizableShippingField.Line2)) {
            this.addressLine2TextInputLayout.setVisibility(8);
        }
        if (isFieldHidden(CustomizableShippingField.State)) {
            this.stateTextInputLayout.setVisibility(8);
        }
        if (isFieldHidden(CustomizableShippingField.City)) {
            this.cityTextInputLayout.setVisibility(8);
        }
        if (isFieldHidden(CustomizableShippingField.PostalCode)) {
            this.postalCodeTextInputLayout.setVisibility(8);
        }
        if (isFieldHidden(CustomizableShippingField.Phone)) {
            this.phoneNumberTextInputLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void updateConfigForCountry(Country country) {
        String value = country.getCode().getValue();
        if (Intrinsics.areEqual((Object) value, (Object) Locale.US.getCountry())) {
            renderUSForm();
        } else if (Intrinsics.areEqual((Object) value, (Object) Locale.UK.getCountry())) {
            renderGreatBritainForm();
        } else if (Intrinsics.areEqual((Object) value, (Object) Locale.CANADA.getCountry())) {
            renderCanadianForm();
        } else {
            renderInternationalForm();
        }
        updatePostalCodeInputFilter(country);
        this.postalCodeTextInputLayout.setVisibility((!CountryUtils.INSTANCE.doesCountryUsePostalCode(country.getCode()) || isFieldHidden(CustomizableShippingField.PostalCode)) ? 8 : 0);
    }

    private final void updatePostalCodeInputFilter(Country country) {
        this.postalCodeEditText.setFilters(Intrinsics.areEqual((Object) country.getCode().getValue(), (Object) Locale.CANADA.getCountry()) ? new InputFilter[]{new InputFilter.AllCaps()} : new InputFilter[0]);
    }

    private final void renderUSForm() {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        TextInputLayout textInputLayout = this.addressLine1TextInputLayout;
        if (isFieldOptional(CustomizableShippingField.Line1)) {
            charSequence = getResources().getString(R.string.address_label_address_optional);
        } else {
            charSequence = getResources().getString(R.string.address_label_address);
        }
        textInputLayout.setHint(charSequence);
        this.addressLine2TextInputLayout.setHint((CharSequence) getResources().getString(R.string.address_label_apt_optional));
        TextInputLayout textInputLayout2 = this.postalCodeTextInputLayout;
        if (isFieldOptional(CustomizableShippingField.PostalCode)) {
            charSequence2 = getResources().getString(R.string.address_label_zip_code_optional);
        } else {
            charSequence2 = getResources().getString(R.string.address_label_zip_code);
        }
        textInputLayout2.setHint(charSequence2);
        TextInputLayout textInputLayout3 = this.stateTextInputLayout;
        if (isFieldOptional(CustomizableShippingField.State)) {
            charSequence3 = getResources().getString(R.string.address_label_state_optional);
        } else {
            charSequence3 = getResources().getString(R.string.address_label_state);
        }
        textInputLayout3.setHint(charSequence3);
        this.postalCodeEditText.setErrorMessage(getResources().getString(R.string.address_zip_invalid));
        this.stateEditText.setErrorMessage(getResources().getString(R.string.address_state_required));
    }

    private final void renderGreatBritainForm() {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        TextInputLayout textInputLayout = this.addressLine1TextInputLayout;
        if (isFieldOptional(CustomizableShippingField.Line1)) {
            charSequence = getResources().getString(R.string.address_label_address_line1_optional);
        } else {
            charSequence = getResources().getString(R.string.address_label_address_line1);
        }
        textInputLayout.setHint(charSequence);
        this.addressLine2TextInputLayout.setHint((CharSequence) getResources().getString(R.string.address_label_address_line2_optional));
        TextInputLayout textInputLayout2 = this.postalCodeTextInputLayout;
        if (isFieldOptional(CustomizableShippingField.PostalCode)) {
            charSequence2 = getResources().getString(R.string.address_label_postcode_optional);
        } else {
            charSequence2 = getResources().getString(R.string.address_label_postcode);
        }
        textInputLayout2.setHint(charSequence2);
        TextInputLayout textInputLayout3 = this.stateTextInputLayout;
        if (isFieldOptional(CustomizableShippingField.State)) {
            charSequence3 = getResources().getString(R.string.address_label_county_optional);
        } else {
            charSequence3 = getResources().getString(R.string.address_label_county);
        }
        textInputLayout3.setHint(charSequence3);
        this.postalCodeEditText.setErrorMessage(getResources().getString(R.string.address_postcode_invalid));
        this.stateEditText.setErrorMessage(getResources().getString(R.string.address_county_required));
    }

    private final void renderCanadianForm() {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        TextInputLayout textInputLayout = this.addressLine1TextInputLayout;
        if (isFieldOptional(CustomizableShippingField.Line1)) {
            charSequence = getResources().getString(R.string.address_label_address_optional);
        } else {
            charSequence = getResources().getString(R.string.address_label_address);
        }
        textInputLayout.setHint(charSequence);
        this.addressLine2TextInputLayout.setHint((CharSequence) getResources().getString(R.string.address_label_apt_optional));
        TextInputLayout textInputLayout2 = this.postalCodeTextInputLayout;
        if (isFieldOptional(CustomizableShippingField.PostalCode)) {
            charSequence2 = getResources().getString(R.string.address_label_postal_code_optional);
        } else {
            charSequence2 = getResources().getString(R.string.address_label_postal_code);
        }
        textInputLayout2.setHint(charSequence2);
        TextInputLayout textInputLayout3 = this.stateTextInputLayout;
        if (isFieldOptional(CustomizableShippingField.State)) {
            charSequence3 = getResources().getString(R.string.address_label_province_optional);
        } else {
            charSequence3 = getResources().getString(R.string.address_label_province);
        }
        textInputLayout3.setHint(charSequence3);
        this.postalCodeEditText.setErrorMessage(getResources().getString(R.string.address_postal_code_invalid));
        this.stateEditText.setErrorMessage(getResources().getString(R.string.address_province_required));
    }

    private final void renderInternationalForm() {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        TextInputLayout textInputLayout = this.addressLine1TextInputLayout;
        if (isFieldOptional(CustomizableShippingField.Line1)) {
            charSequence = getResources().getString(R.string.address_label_address_line1_optional);
        } else {
            charSequence = getResources().getString(R.string.address_label_address_line1);
        }
        textInputLayout.setHint(charSequence);
        this.addressLine2TextInputLayout.setHint((CharSequence) getResources().getString(R.string.address_label_address_line2_optional));
        TextInputLayout textInputLayout2 = this.postalCodeTextInputLayout;
        if (isFieldOptional(CustomizableShippingField.PostalCode)) {
            charSequence2 = getResources().getString(R.string.address_label_zip_postal_code_optional);
        } else {
            charSequence2 = getResources().getString(R.string.address_label_zip_postal_code);
        }
        textInputLayout2.setHint(charSequence2);
        TextInputLayout textInputLayout3 = this.stateTextInputLayout;
        if (isFieldOptional(CustomizableShippingField.State)) {
            charSequence3 = getResources().getString(R.string.address_label_region_generic_optional);
        } else {
            charSequence3 = getResources().getString(R.string.address_label_region_generic);
        }
        textInputLayout3.setHint(charSequence3);
        this.postalCodeEditText.setErrorMessage(getResources().getString(R.string.address_zip_postal_invalid));
        this.stateEditText.setErrorMessage(getResources().getString(R.string.address_region_generic_required));
    }
}
