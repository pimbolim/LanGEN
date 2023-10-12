package com.stripe.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.ConfigurationCompat;
import com.braintreepayments.api.models.PostalAddressParser;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.R;
import com.stripe.android.core.model.Country;
import com.stripe.android.core.model.CountryCode;
import com.stripe.android.core.model.CountryUtils;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002JKB%\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010,\u001a\u00020\u0015H\u0002J\b\u0010-\u001a\u00020.H\u0002J\n\u0010/\u001a\u0004\u0018\u00010\u001cH\u0007J\b\u00100\u001a\u00020\rH\u0002J\u0012\u00101\u001a\u00020\u00152\b\u00102\u001a\u0004\u0018\u000103H\u0014J\n\u00104\u001a\u0004\u0018\u000103H\u0016J\u0015\u00105\u001a\u00020\u00152\u0006\u00102\u001a\u000206H\u0001¢\u0006\u0002\b7J\u001b\u00108\u001a\u00020\u00152\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0000¢\u0006\u0002\b<J\u0015\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u001cH\u0001¢\u0006\u0002\b?J\u0015\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020;H\u0001¢\u0006\u0002\b?J\u0010\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020BH\u0016J\u0012\u0010C\u001a\u00020\u00152\b\u0010>\u001a\u0004\u0018\u00010\u001cH\u0007J\b\u0010D\u001a\u00020\u0015H\u0002J\u0010\u0010E\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u001cH\u0007J\u0015\u0010F\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u001cH\u0000¢\u0006\u0002\bGJ\r\u0010H\u001a\u00020\u0015H\u0000¢\u0006\u0002\bIR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u00020\r8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R0\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00138\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00150\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u0012\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u0004\u0018\u00010\u00148@X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R5\u0010$\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u001c8@@@X\u0002¢\u0006\u0018\n\u0004\b*\u0010+\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006L"}, d2 = {"Lcom/stripe/android/view/CountryTextInputLayout;", "Lcom/google/android/material/textfield/TextInputLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "countryAdapter", "Lcom/stripe/android/view/CountryAdapter;", "countryAutoCompleteStyleRes", "countryAutocomplete", "Landroid/widget/AutoCompleteTextView;", "getCountryAutocomplete$annotations", "()V", "getCountryAutocomplete", "()Landroid/widget/AutoCompleteTextView;", "countryChangeCallback", "Lkotlin/Function1;", "Lcom/stripe/android/core/model/Country;", "", "getCountryChangeCallback$payments_core_release$annotations", "getCountryChangeCallback$payments_core_release", "()Lkotlin/jvm/functions/Function1;", "setCountryChangeCallback$payments_core_release", "(Lkotlin/jvm/functions/Function1;)V", "countryCodeChangeCallback", "Lcom/stripe/android/core/model/CountryCode;", "getCountryCodeChangeCallback", "setCountryCodeChangeCallback", "itemLayoutRes", "selectedCountry", "getSelectedCountry$payments_core_release", "()Lcom/stripe/android/core/model/Country;", "<set-?>", "selectedCountryCode", "getSelectedCountryCode$payments_core_release$annotations", "getSelectedCountryCode$payments_core_release", "()Lcom/stripe/android/core/model/CountryCode;", "setSelectedCountryCode$payments_core_release", "(Lcom/stripe/android/core/model/CountryCode;)V", "selectedCountryCode$delegate", "Lkotlin/properties/ReadWriteProperty;", "clearError", "getLocale", "Ljava/util/Locale;", "getSelectedCountryCode", "initializeCountryAutoCompleteWithStyle", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "restoreSelectedCountry", "Lcom/stripe/android/view/CountryTextInputLayout$SelectedCountryState;", "restoreSelectedCountry$payments_core_release", "setAllowedCountryCodes", "allowedCountryCodes", "", "", "setAllowedCountryCodes$payments_core_release", "setCountrySelected", "countryCode", "setCountrySelected$payments_core_release", "setEnabled", "enabled", "", "setSelectedCountryCode", "updateInitialCountry", "updateUiForCountryEntered", "updatedSelectedCountryCode", "updatedSelectedCountryCode$payments_core_release", "validateCountry", "validateCountry$payments_core_release", "Companion", "SelectedCountryState", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CountryTextInputLayout.kt */
public final class CountryTextInputLayout extends TextInputLayout {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CountryTextInputLayout.class, "selectedCountryCode", "getSelectedCountryCode$payments_core_release()Lcom/stripe/android/core/model/CountryCode;", 0))};
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final int DEFAULT_ITEM_LAYOUT = R.layout.country_text_view;
    @Deprecated
    public static final int INVALID_COUNTRY_AUTO_COMPLETE_STYLE = 0;
    private CountryAdapter countryAdapter;
    private int countryAutoCompleteStyleRes;
    private final AutoCompleteTextView countryAutocomplete;
    private /* synthetic */ Function1<? super Country, Unit> countryChangeCallback;
    private /* synthetic */ Function1<? super CountryCode, Unit> countryCodeChangeCallback;
    /* access modifiers changed from: private */
    public int itemLayoutRes;
    private final ReadWriteProperty selectedCountryCode$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CountryTextInputLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CountryTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getCountryAutocomplete$annotations() {
    }

    @Deprecated(message = "Will be removed in a future version", replaceWith = @ReplaceWith(expression = "countryCodeChangeCallback", imports = {}))
    public static /* synthetic */ void getCountryChangeCallback$payments_core_release$annotations() {
    }

    public static /* synthetic */ void getSelectedCountryCode$payments_core_release$annotations() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CountryTextInputLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? com.google.android.material.R.attr.textInputStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryTextInputLayout(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        int i2 = DEFAULT_ITEM_LAYOUT;
        this.itemLayoutRes = i2;
        Delegates delegates = Delegates.INSTANCE;
        this.selectedCountryCode$delegate = new CountryTextInputLayout$special$$inlined$observable$1((Object) null, this);
        this.countryChangeCallback = CountryTextInputLayout$countryChangeCallback$1.INSTANCE;
        this.countryCodeChangeCallback = CountryTextInputLayout$countryCodeChangeCallback$1.INSTANCE;
        int[] iArr = R.styleable.StripeCountryAutoCompleteTextInputLayout;
        Intrinsics.checkNotNullExpressionValue(iArr, "StripeCountryAutoCompleteTextInputLayout");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.countryAutoCompleteStyleRes = obtainStyledAttributes.getResourceId(R.styleable.StripeCountryAutoCompleteTextInputLayout_countryAutoCompleteStyle, 0);
        this.itemLayoutRes = obtainStyledAttributes.getResourceId(R.styleable.StripeCountryAutoCompleteTextInputLayout_countryItemLayout, i2);
        obtainStyledAttributes.recycle();
        AutoCompleteTextView initializeCountryAutoCompleteWithStyle = initializeCountryAutoCompleteWithStyle();
        this.countryAutocomplete = initializeCountryAutoCompleteWithStyle;
        addView(initializeCountryAutoCompleteWithStyle, new LinearLayout.LayoutParams(-1, -2));
        this.countryAdapter = new CountryAdapter(context, CountryUtils.INSTANCE.getOrderedCountries(getLocale()), this.itemLayoutRes, new Function1<ViewGroup, TextView>() {
            public final TextView invoke(ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "it");
                View inflate = LayoutInflater.from(context).inflate(this.itemLayoutRes, viewGroup, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                return (TextView) inflate;
            }
        });
        initializeCountryAutoCompleteWithStyle.setThreshold(0);
        initializeCountryAutoCompleteWithStyle.setAdapter(this.countryAdapter);
        initializeCountryAutoCompleteWithStyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                CountryTextInputLayout.m4655_init_$lambda5(CountryTextInputLayout.this, adapterView, view, i, j);
            }
        });
        initializeCountryAutoCompleteWithStyle.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CountryTextInputLayout.m4656_init_$lambda8(CountryTextInputLayout.this, view, z);
            }
        });
        setSelectedCountryCode$payments_core_release(this.countryAdapter.getFirstItem$payments_core_release().getCode());
        updateInitialCountry();
        final String string = getResources().getString(R.string.address_country_invalid);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….address_country_invalid)");
        initializeCountryAutoCompleteWithStyle.setValidator(new CountryAutoCompleteTextViewValidator(this.countryAdapter, new Function1<Country, Unit>(this) {
            final /* synthetic */ CountryTextInputLayout this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Country) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Country country) {
                this.this$0.setSelectedCountryCode$payments_core_release(country == null ? null : country.getCode());
                if (country != null) {
                    this.this$0.clearError();
                    return;
                }
                this.this$0.setError(string);
                this.this$0.setErrorEnabled(true);
            }
        }));
    }

    public final AutoCompleteTextView getCountryAutocomplete() {
        return this.countryAutocomplete;
    }

    public final CountryCode getSelectedCountryCode$payments_core_release() {
        return (CountryCode) this.selectedCountryCode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setSelectedCountryCode$payments_core_release(CountryCode countryCode) {
        this.selectedCountryCode$delegate.setValue(this, $$delegatedProperties[0], countryCode);
    }

    public final CountryCode getSelectedCountryCode() {
        return getSelectedCountryCode$payments_core_release();
    }

    public final void setSelectedCountryCode(CountryCode countryCode) {
        setSelectedCountryCode$payments_core_release(countryCode);
    }

    public final Country getSelectedCountry$payments_core_release() {
        CountryCode selectedCountryCode$payments_core_release = getSelectedCountryCode$payments_core_release();
        if (selectedCountryCode$payments_core_release == null) {
            return null;
        }
        return CountryUtils.INSTANCE.getCountryByCode(selectedCountryCode$payments_core_release, getLocale());
    }

    public final Function1<Country, Unit> getCountryChangeCallback$payments_core_release() {
        return this.countryChangeCallback;
    }

    public final void setCountryChangeCallback$payments_core_release(Function1<? super Country, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.countryChangeCallback = function1;
    }

    public final Function1<CountryCode, Unit> getCountryCodeChangeCallback() {
        return this.countryCodeChangeCallback;
    }

    public final void setCountryCodeChangeCallback(Function1<? super CountryCode, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.countryCodeChangeCallback = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-5  reason: not valid java name */
    public static final void m4655_init_$lambda5(CountryTextInputLayout countryTextInputLayout, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(countryTextInputLayout, "this$0");
        countryTextInputLayout.updatedSelectedCountryCode$payments_core_release(countryTextInputLayout.countryAdapter.getItem(i).getCode());
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-8  reason: not valid java name */
    public static final void m4656_init_$lambda8(CountryTextInputLayout countryTextInputLayout, View view, boolean z) {
        Unit unit;
        Intrinsics.checkNotNullParameter(countryTextInputLayout, "this$0");
        if (z) {
            countryTextInputLayout.countryAutocomplete.showDropDown();
            return;
        }
        String obj = countryTextInputLayout.countryAutocomplete.getText().toString();
        CountryCode countryCodeByName = CountryUtils.INSTANCE.getCountryCodeByName(obj, countryTextInputLayout.getLocale());
        if (countryCodeByName == null) {
            unit = null;
        } else {
            countryTextInputLayout.updateUiForCountryEntered(countryCodeByName);
            unit = Unit.INSTANCE;
        }
        if (unit == null && CountryUtils.INSTANCE.getCountryByCode(CountryCode.Companion.create(obj), countryTextInputLayout.getLocale()) != null) {
            countryTextInputLayout.updateUiForCountryEntered(CountryCode.Companion.create(obj));
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        addOnLayoutChangeListener(new CountryTextInputLayout$setEnabled$$inlined$doOnNextLayout$1(this, z));
    }

    public Parcelable onSaveInstanceState() {
        Country selectedCountry$payments_core_release = getSelectedCountry$payments_core_release();
        if (selectedCountry$payments_core_release != null) {
            return new SelectedCountryState(selectedCountry$payments_core_release.getCode(), super.onSaveInstanceState());
        }
        CountryTextInputLayout countryTextInputLayout = this;
        return super.onSaveInstanceState();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SelectedCountryState) {
            restoreSelectedCountry$payments_core_release((SelectedCountryState) parcelable);
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }

    public final void restoreSelectedCountry$payments_core_release(SelectedCountryState selectedCountryState) {
        Intrinsics.checkNotNullParameter(selectedCountryState, PostalAddressParser.REGION_KEY);
        super.onRestoreInstanceState(selectedCountryState.getSuperState());
        CountryCode countryCode = selectedCountryState.getCountryCode();
        updatedSelectedCountryCode$payments_core_release(countryCode);
        updateUiForCountryEntered(countryCode);
        requestLayout();
    }

    private final AutoCompleteTextView initializeCountryAutoCompleteWithStyle() {
        if (this.countryAutoCompleteStyleRes == 0) {
            return new AutoCompleteTextView(getContext(), (AttributeSet) null, R.attr.autoCompleteTextViewStyle);
        }
        return new AutoCompleteTextView(getContext(), (AttributeSet) null, 0, this.countryAutoCompleteStyleRes);
    }

    private final void updateInitialCountry() {
        Country firstItem$payments_core_release = this.countryAdapter.getFirstItem$payments_core_release();
        this.countryAutocomplete.setText(firstItem$payments_core_release.getName());
        setSelectedCountryCode$payments_core_release(firstItem$payments_core_release.getCode());
    }

    public final void setAllowedCountryCodes$payments_core_release(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "allowedCountryCodes");
        if (this.countryAdapter.updateUnfilteredCountries$payments_core_release(set)) {
            updateInitialCountry();
        }
    }

    public final void setCountrySelected$payments_core_release(CountryCode countryCode) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        updateUiForCountryEntered(countryCode);
    }

    @Deprecated(message = "This will be removed in a future version", replaceWith = @ReplaceWith(expression = "setCountrySelected(CountryCode.create(countryCode))", imports = {"com.stripe.android.model.CountryCode"}))
    public final void setCountrySelected$payments_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        updateUiForCountryEntered(CountryCode.Companion.create(str));
    }

    public final void updateUiForCountryEntered(CountryCode countryCode) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Country countryByCode = CountryUtils.INSTANCE.getCountryByCode(countryCode, getLocale());
        String str = null;
        if (countryByCode == null) {
            countryByCode = null;
        } else {
            updatedSelectedCountryCode$payments_core_release(countryCode);
        }
        if (countryByCode == null) {
            countryByCode = CountryUtils.INSTANCE.getCountryByCode(getSelectedCountryCode$payments_core_release(), getLocale());
        }
        AutoCompleteTextView autoCompleteTextView = this.countryAutocomplete;
        if (countryByCode != null) {
            str = countryByCode.getName();
        }
        autoCompleteTextView.setText(str);
    }

    public final void updatedSelectedCountryCode$payments_core_release(CountryCode countryCode) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        clearError();
        if (!Intrinsics.areEqual((Object) getSelectedCountryCode$payments_core_release(), (Object) countryCode)) {
            setSelectedCountryCode$payments_core_release(countryCode);
        }
    }

    public final void validateCountry$payments_core_release() {
        this.countryAutocomplete.performValidation();
    }

    /* access modifiers changed from: private */
    public final void clearError() {
        setError((CharSequence) null);
        setErrorEnabled(false);
    }

    /* access modifiers changed from: private */
    public final Locale getLocale() {
        Locale locale = ConfigurationCompat.getLocales(getContext().getResources().getConfiguration()).get(0);
        Intrinsics.checkNotNullExpressionValue(locale, "ConfigurationCompat.getL…sources.configuration)[0]");
        return locale;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/CountryTextInputLayout$Companion;", "", "()V", "DEFAULT_ITEM_LAYOUT", "", "getDEFAULT_ITEM_LAYOUT", "()I", "INVALID_COUNTRY_AUTO_COMPLETE_STYLE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CountryTextInputLayout.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getDEFAULT_ITEM_LAYOUT() {
            return CountryTextInputLayout.DEFAULT_ITEM_LAYOUT;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/view/CountryTextInputLayout$SelectedCountryState;", "Landroid/os/Parcelable;", "countryCode", "Lcom/stripe/android/core/model/CountryCode;", "superState", "(Lcom/stripe/android/core/model/CountryCode;Landroid/os/Parcelable;)V", "getCountryCode", "()Lcom/stripe/android/core/model/CountryCode;", "getSuperState", "()Landroid/os/Parcelable;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CountryTextInputLayout.kt */
    public static final class SelectedCountryState implements Parcelable {
        public static final Parcelable.Creator<SelectedCountryState> CREATOR = new Creator();
        private final CountryCode countryCode;
        private final Parcelable superState;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CountryTextInputLayout.kt */
        public static final class Creator implements Parcelable.Creator<SelectedCountryState> {
            public final SelectedCountryState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SelectedCountryState((CountryCode) parcel.readParcelable(SelectedCountryState.class.getClassLoader()), parcel.readParcelable(SelectedCountryState.class.getClassLoader()));
            }

            public final SelectedCountryState[] newArray(int i) {
                return new SelectedCountryState[i];
            }
        }

        public static /* synthetic */ SelectedCountryState copy$default(SelectedCountryState selectedCountryState, CountryCode countryCode2, Parcelable parcelable, int i, Object obj) {
            if ((i & 1) != 0) {
                countryCode2 = selectedCountryState.countryCode;
            }
            if ((i & 2) != 0) {
                parcelable = selectedCountryState.superState;
            }
            return selectedCountryState.copy(countryCode2, parcelable);
        }

        public final CountryCode component1() {
            return this.countryCode;
        }

        public final Parcelable component2() {
            return this.superState;
        }

        public final SelectedCountryState copy(CountryCode countryCode2, Parcelable parcelable) {
            Intrinsics.checkNotNullParameter(countryCode2, "countryCode");
            return new SelectedCountryState(countryCode2, parcelable);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SelectedCountryState)) {
                return false;
            }
            SelectedCountryState selectedCountryState = (SelectedCountryState) obj;
            return Intrinsics.areEqual((Object) this.countryCode, (Object) selectedCountryState.countryCode) && Intrinsics.areEqual((Object) this.superState, (Object) selectedCountryState.superState);
        }

        public int hashCode() {
            int hashCode = this.countryCode.hashCode() * 31;
            Parcelable parcelable = this.superState;
            return hashCode + (parcelable == null ? 0 : parcelable.hashCode());
        }

        public String toString() {
            return "SelectedCountryState(countryCode=" + this.countryCode + ", superState=" + this.superState + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.countryCode, i);
            parcel.writeParcelable(this.superState, i);
        }

        public SelectedCountryState(CountryCode countryCode2, Parcelable parcelable) {
            Intrinsics.checkNotNullParameter(countryCode2, "countryCode");
            this.countryCode = countryCode2;
            this.superState = parcelable;
        }

        public final CountryCode getCountryCode() {
            return this.countryCode;
        }

        public final Parcelable getSuperState() {
            return this.superState;
        }
    }
}
