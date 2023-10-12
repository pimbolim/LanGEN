package com.stripe.android.paymentsheet.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.os.ConfigurationCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.stripe.android.core.model.Country;
import com.stripe.android.core.model.CountryCode;
import com.stripe.android.core.model.CountryUtils;
import com.stripe.android.model.Address;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.paymentsheet.databinding.StripeBillingAddressLayoutBinding;
import com.stripe.android.view.CountryTextInputLayout;
import com.stripe.android.view.PostalCodeValidator;
import com.stripe.android.view.StripeEditText;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
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

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0004~\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010p\u001a\u00020CH\u0002J\n\u0010q\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010s\u001a\u00020B2\b\u0010t\u001a\u0004\u0018\u00010mH\u0002J\u0006\u0010u\u001a\u00020CJ\b\u0010v\u001a\u00020wH\u0002J\u0017\u0010x\u001a\u00020C2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\byJ\u0010\u0010z\u001a\u00020C2\u0006\u0010{\u001a\u000204H\u0016J\u0012\u0010|\u001a\u00020C2\b\u0010s\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010}\u001a\u00020C2\b\u0010s\u001a\u0004\u0018\u00010BH\u0002R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00118\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00118\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u00020\u001d8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u00020\"8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020\u00118\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015R\u001c\u0010)\u001a\u00020*8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0013\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u00020/8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0013\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u0002048BX\u0004¢\u0006\u0006\u001a\u0004\b3\u00105R1\u00108\u001a\u0002072\u0006\u00106\u001a\u0002078@@@X\u0002¢\u0006\u0018\n\u0004\b>\u0010?\u0012\u0004\b9\u0010\u0013\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010@\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020C0AX\u0004¢\u0006\u0002\n\u0000R \u0010D\u001a\b\u0012\u0004\u0012\u00020C0EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR+\u0010K\u001a\u00020J2\u0006\u00106\u001a\u00020J8B@BX\u0002¢\u0006\u0012\n\u0004\bP\u0010?\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010Q\u001a\u00020\u001d8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u0010\u0013\u001a\u0004\bS\u0010 R\u000e\u0010T\u001a\u00020UX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010V\u001a\u00020W8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u0010\u0013\u001a\u0004\bY\u0010ZR&\u0010[\u001a\u0004\u0018\u00010\\8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b]\u0010\u0013\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0014\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\u001aX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010d\u001a\u00020\u001d8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u0010\u0013\u001a\u0004\bf\u0010 R\u001c\u0010g\u001a\u00020\u00118\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010\u0013\u001a\u0004\bi\u0010\u0015R\u000e\u0010j\u001a\u00020kX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u0004\u0018\u00010m*\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\bn\u0010o¨\u0006\u0001"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/BillingAddressView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_address", "Landroidx/lifecycle/MutableLiveData;", "Lcom/stripe/android/model/Address;", "address", "Landroidx/lifecycle/LiveData;", "getAddress$paymentsheet_release", "()Landroidx/lifecycle/LiveData;", "address1View", "Lcom/google/android/material/textfield/TextInputEditText;", "getAddress1View$paymentsheet_release$annotations", "()V", "getAddress1View$paymentsheet_release", "()Lcom/google/android/material/textfield/TextInputEditText;", "address2View", "getAddress2View$paymentsheet_release$annotations", "getAddress2View$paymentsheet_release", "allFields", "", "Landroid/widget/EditText;", "cityLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "getCityLayout$paymentsheet_release$annotations", "getCityLayout$paymentsheet_release", "()Lcom/google/android/material/textfield/TextInputLayout;", "cityPostalContainer", "Landroid/widget/LinearLayout;", "getCityPostalContainer$paymentsheet_release$annotations", "getCityPostalContainer$paymentsheet_release", "()Landroid/widget/LinearLayout;", "cityView", "getCityView$paymentsheet_release$annotations", "getCityView$paymentsheet_release", "countryLayout", "Lcom/stripe/android/view/CountryTextInputLayout;", "getCountryLayout$paymentsheet_release$annotations", "getCountryLayout$paymentsheet_release", "()Lcom/stripe/android/view/CountryTextInputLayout;", "countryView", "Landroid/widget/AutoCompleteTextView;", "getCountryView$paymentsheet_release$annotations", "getCountryView$paymentsheet_release", "()Landroid/widget/AutoCompleteTextView;", "isUnitedStates", "", "()Z", "<set-?>", "Lcom/stripe/android/paymentsheet/ui/BillingAddressView$BillingAddressCollectionLevel;", "level", "getLevel$paymentsheet_release$annotations", "getLevel$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/ui/BillingAddressView$BillingAddressCollectionLevel;", "setLevel$paymentsheet_release", "(Lcom/stripe/android/paymentsheet/ui/BillingAddressView$BillingAddressCollectionLevel;)V", "level$delegate", "Lkotlin/properties/ReadWriteProperty;", "newCountryCodeCallback", "Lkotlin/Function1;", "Lcom/stripe/android/core/model/CountryCode;", "", "onFocus", "Lkotlin/Function0;", "getOnFocus$paymentsheet_release", "()Lkotlin/jvm/functions/Function0;", "setOnFocus$paymentsheet_release", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig;", "postalCodeConfig", "getPostalCodeConfig", "()Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig;", "setPostalCodeConfig", "(Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig;)V", "postalCodeConfig$delegate", "postalCodeLayout", "getPostalCodeLayout$paymentsheet_release$annotations", "getPostalCodeLayout$paymentsheet_release", "postalCodeValidator", "Lcom/stripe/android/view/PostalCodeValidator;", "postalCodeView", "Lcom/stripe/android/view/StripeEditText;", "getPostalCodeView$paymentsheet_release$annotations", "getPostalCodeView$paymentsheet_release", "()Lcom/stripe/android/view/StripeEditText;", "postalCodeViewListener", "Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeViewListener;", "getPostalCodeViewListener$paymentsheet_release$annotations", "getPostalCodeViewListener$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeViewListener;", "setPostalCodeViewListener$paymentsheet_release", "(Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeViewListener;)V", "requiredViews", "Landroid/view/View;", "stateLayout", "getStateLayout$paymentsheet_release$annotations", "getStateLayout$paymentsheet_release", "stateView", "getStateView$paymentsheet_release$annotations", "getStateView$paymentsheet_release", "viewBinding", "Lcom/stripe/android/paymentsheet/databinding/StripeBillingAddressLayoutBinding;", "value", "", "getValue", "(Landroid/widget/EditText;)Ljava/lang/String;", "configureForLevel", "createAddress", "createRequiredAddress", "countryCode", "postalCode", "focusFirstField", "getLocale", "Ljava/util/Locale;", "populate", "populate$paymentsheet_release", "setEnabled", "enabled", "updatePostalCodeView", "updateStateView", "BillingAddressCollectionLevel", "PostalCodeConfig", "PostalCodeViewListener", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BillingAddressView.kt */
public final class BillingAddressView extends FrameLayout {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    /* access modifiers changed from: private */
    public final MutableLiveData<Address> _address;
    private final LiveData<Address> address;
    private final TextInputEditText address1View;
    private final TextInputEditText address2View;
    private final Set<EditText> allFields;
    private final TextInputLayout cityLayout;
    private final LinearLayout cityPostalContainer;
    private final TextInputEditText cityView;
    private final CountryTextInputLayout countryLayout;
    private final AutoCompleteTextView countryView;
    private final ReadWriteProperty level$delegate;
    private final Function1<CountryCode, Unit> newCountryCodeCallback;
    private Function0<Unit> onFocus;
    private final ReadWriteProperty postalCodeConfig$delegate;
    private final TextInputLayout postalCodeLayout;
    /* access modifiers changed from: private */
    public final PostalCodeValidator postalCodeValidator;
    private final StripeEditText postalCodeView;
    private PostalCodeViewListener postalCodeViewListener;
    private final Set<View> requiredViews;
    private final TextInputLayout stateLayout;
    private final TextInputEditText stateView;
    private final StripeBillingAddressLayoutBinding viewBinding;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/BillingAddressView$BillingAddressCollectionLevel;", "", "(Ljava/lang/String;I)V", "Automatic", "Required", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BillingAddressView.kt */
    public enum BillingAddressCollectionLevel {
        Automatic,
        Required
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeViewListener;", "", "onCountryChanged", "", "country", "Lcom/stripe/android/core/model/Country;", "isPostalValid", "", "onGainingFocus", "onLosingFocus", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BillingAddressView.kt */
    public interface PostalCodeViewListener {
        void onCountryChanged(Country country, boolean z);

        void onGainingFocus(Country country, boolean z);

        void onLosingFocus(Country country, boolean z);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BillingAddressView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BillingAddressCollectionLevel.values().length];
            iArr[BillingAddressCollectionLevel.Automatic.ordinal()] = 1;
            iArr[BillingAddressCollectionLevel.Required.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillingAddressView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillingAddressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getAddress1View$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getAddress2View$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getCityLayout$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getCityPostalContainer$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getCityView$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getCountryLayout$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getCountryView$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getLevel$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getPostalCodeLayout$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getPostalCodeView$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getPostalCodeViewListener$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getStateLayout$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getStateView$paymentsheet_release$annotations() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillingAddressView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillingAddressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Delegates delegates = Delegates.INSTANCE;
        this.level$delegate = new BillingAddressView$special$$inlined$observable$1(BillingAddressCollectionLevel.Automatic, this);
        this.onFocus = BillingAddressView$onFocus$1.INSTANCE;
        StripeBillingAddressLayoutBinding inflate = StripeBillingAddressLayoutBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI…text),\n        this\n    )");
        this.viewBinding = inflate;
        this.postalCodeValidator = new PostalCodeValidator();
        MutableLiveData<Address> mutableLiveData = new MutableLiveData<>(null);
        this._address = mutableLiveData;
        this.address = mutableLiveData;
        CountryTextInputLayout countryTextInputLayout = inflate.countryLayout;
        Intrinsics.checkNotNullExpressionValue(countryTextInputLayout, "viewBinding.countryLayout");
        this.countryLayout = countryTextInputLayout;
        AutoCompleteTextView countryAutocomplete = countryTextInputLayout.getCountryAutocomplete();
        this.countryView = countryAutocomplete;
        LinearLayout linearLayout = inflate.cityPostalContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.cityPostalContainer");
        this.cityPostalContainer = linearLayout;
        StripeEditText stripeEditText = inflate.postalCode;
        Intrinsics.checkNotNullExpressionValue(stripeEditText, "viewBinding.postalCode");
        this.postalCodeView = stripeEditText;
        TextInputLayout textInputLayout = inflate.postalCodeLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "viewBinding.postalCodeLayout");
        this.postalCodeLayout = textInputLayout;
        TextInputEditText textInputEditText = inflate.address1;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "viewBinding.address1");
        this.address1View = textInputEditText;
        TextInputEditText textInputEditText2 = inflate.address2;
        Intrinsics.checkNotNullExpressionValue(textInputEditText2, "viewBinding.address2");
        this.address2View = textInputEditText2;
        TextInputLayout textInputLayout2 = inflate.cityLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout2, "viewBinding.cityLayout");
        this.cityLayout = textInputLayout2;
        TextInputEditText textInputEditText3 = inflate.city;
        Intrinsics.checkNotNullExpressionValue(textInputEditText3, "viewBinding.city");
        this.cityView = textInputEditText3;
        TextInputEditText textInputEditText4 = inflate.state;
        Intrinsics.checkNotNullExpressionValue(textInputEditText4, "viewBinding.state");
        this.stateView = textInputEditText4;
        TextInputLayout textInputLayout3 = inflate.stateLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout3, "viewBinding.stateLayout");
        this.stateLayout = textInputLayout3;
        Delegates delegates2 = Delegates.INSTANCE;
        this.postalCodeConfig$delegate = new BillingAddressView$special$$inlined$observable$2(PostalCodeConfig.Global.INSTANCE, this);
        Function1<CountryCode, Unit> billingAddressView$newCountryCodeCallback$1 = new BillingAddressView$newCountryCodeCallback$1(this);
        this.newCountryCodeCallback = billingAddressView$newCountryCodeCallback$1;
        this.requiredViews = SetsKt.setOf(inflate.address1Divider, inflate.address1Layout, textInputEditText, inflate.address2Divider, inflate.address2Layout, textInputEditText2, inflate.cityLayout, textInputEditText3, inflate.stateDivider, textInputLayout3, textInputEditText4);
        Set<EditText> of = SetsKt.setOf(textInputEditText, textInputEditText2, textInputEditText3, textInputEditText4, stripeEditText, countryAutocomplete);
        this.allFields = of;
        countryTextInputLayout.setCountryCodeChangeCallback(billingAddressView$newCountryCodeCallback$1);
        CountryCode selectedCountryCode = countryTextInputLayout.getSelectedCountryCode();
        if (selectedCountryCode != null) {
            billingAddressView$newCountryCodeCallback$1.invoke(selectedCountryCode);
        }
        configureForLevel();
        for (EditText editText : of) {
            editText.addTextChangedListener(new BillingAddressView$_init_$lambda5$$inlined$doAfterTextChanged$1(this));
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    BillingAddressView.m4443lambda5$lambda4(BillingAddressView.this, view, z);
                }
            });
        }
        this.postalCodeView.getInternalFocusChangeListeners().add(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                BillingAddressView.m4441_init_$lambda9(BillingAddressView.this, view, z);
            }
        });
    }

    static {
        Class<BillingAddressView> cls = BillingAddressView.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, FirebaseAnalytics.Param.LEVEL, "getLevel$paymentsheet_release()Lcom/stripe/android/paymentsheet/ui/BillingAddressView$BillingAddressCollectionLevel;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "postalCodeConfig", "getPostalCodeConfig()Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig;", 0))};
    }

    public final BillingAddressCollectionLevel getLevel$paymentsheet_release() {
        return (BillingAddressCollectionLevel) this.level$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setLevel$paymentsheet_release(BillingAddressCollectionLevel billingAddressCollectionLevel) {
        Intrinsics.checkNotNullParameter(billingAddressCollectionLevel, "<set-?>");
        this.level$delegate.setValue(this, $$delegatedProperties[0], billingAddressCollectionLevel);
    }

    public final Function0<Unit> getOnFocus$paymentsheet_release() {
        return this.onFocus;
    }

    public final void setOnFocus$paymentsheet_release(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onFocus = function0;
    }

    public final LiveData<Address> getAddress$paymentsheet_release() {
        return this.address;
    }

    public final CountryTextInputLayout getCountryLayout$paymentsheet_release() {
        return this.countryLayout;
    }

    public final AutoCompleteTextView getCountryView$paymentsheet_release() {
        return this.countryView;
    }

    public final LinearLayout getCityPostalContainer$paymentsheet_release() {
        return this.cityPostalContainer;
    }

    public final StripeEditText getPostalCodeView$paymentsheet_release() {
        return this.postalCodeView;
    }

    public final TextInputLayout getPostalCodeLayout$paymentsheet_release() {
        return this.postalCodeLayout;
    }

    public final TextInputEditText getAddress1View$paymentsheet_release() {
        return this.address1View;
    }

    public final TextInputEditText getAddress2View$paymentsheet_release() {
        return this.address2View;
    }

    public final TextInputLayout getCityLayout$paymentsheet_release() {
        return this.cityLayout;
    }

    public final TextInputEditText getCityView$paymentsheet_release() {
        return this.cityView;
    }

    public final TextInputEditText getStateView$paymentsheet_release() {
        return this.stateView;
    }

    public final TextInputLayout getStateLayout$paymentsheet_release() {
        return this.stateLayout;
    }

    public final PostalCodeViewListener getPostalCodeViewListener$paymentsheet_release() {
        return this.postalCodeViewListener;
    }

    public final void setPostalCodeViewListener$paymentsheet_release(PostalCodeViewListener postalCodeViewListener2) {
        this.postalCodeViewListener = postalCodeViewListener2;
    }

    private final boolean isUnitedStates() {
        return CountryCode.Companion.isUS(this.countryLayout.getSelectedCountryCode());
    }

    private final PostalCodeConfig getPostalCodeConfig() {
        return (PostalCodeConfig) this.postalCodeConfig$delegate.getValue(this, $$delegatedProperties[1]);
    }

    private final void setPostalCodeConfig(PostalCodeConfig postalCodeConfig) {
        this.postalCodeConfig$delegate.setValue(this, $$delegatedProperties[1], postalCodeConfig);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-5$lambda-4  reason: not valid java name */
    public static final void m4443lambda5$lambda4(BillingAddressView billingAddressView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(billingAddressView, "this$0");
        if (z) {
            billingAddressView.onFocus.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* renamed from: _init_$lambda-9  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m4441_init_$lambda9(com.stripe.android.paymentsheet.ui.BillingAddressView r5, android.view.View r6, boolean r7) {
        /*
            java.lang.String r6 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            com.stripe.android.view.CountryTextInputLayout r6 = r5.countryLayout
            com.stripe.android.core.model.CountryCode r6 = r6.getSelectedCountryCode()
            r0 = 0
            if (r6 != 0) goto L_0x0010
            r6 = 0
            goto L_0x0028
        L_0x0010:
            com.stripe.android.view.PostalCodeValidator r1 = r5.postalCodeValidator
            com.stripe.android.view.StripeEditText r2 = r5.getPostalCodeView$paymentsheet_release()
            android.widget.EditText r2 = (android.widget.EditText) r2
            java.lang.String r2 = r5.getValue(r2)
            if (r2 != 0) goto L_0x0020
            java.lang.String r2 = ""
        L_0x0020:
            java.lang.String r6 = r6.getValue()
            boolean r6 = r1.isValid(r2, r6)
        L_0x0028:
            com.stripe.android.view.StripeEditText r1 = r5.postalCodeView
            r2 = 1
            if (r7 != 0) goto L_0x0048
            r3 = r1
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r3 = r5.getValue(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0041
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r3 = 0
            goto L_0x0042
        L_0x0041:
            r3 = 1
        L_0x0042:
            if (r3 != 0) goto L_0x0048
            if (r6 != 0) goto L_0x0048
            r3 = 1
            goto L_0x0049
        L_0x0048:
            r3 = 0
        L_0x0049:
            r1.setShouldShowError(r3)
            r1 = 0
            if (r7 == 0) goto L_0x006b
            com.stripe.android.paymentsheet.ui.BillingAddressView$PostalCodeViewListener r7 = r5.postalCodeViewListener
            if (r7 != 0) goto L_0x0054
            goto L_0x00a5
        L_0x0054:
            com.stripe.android.view.CountryTextInputLayout r0 = r5.countryLayout
            com.stripe.android.core.model.CountryCode r0 = r0.getSelectedCountryCode()
            if (r0 != 0) goto L_0x005d
            goto L_0x0067
        L_0x005d:
            com.stripe.android.core.model.CountryUtils r1 = com.stripe.android.core.model.CountryUtils.INSTANCE
            java.util.Locale r5 = r5.getLocale()
            com.stripe.android.core.model.Country r1 = r1.getCountryByCode(r0, r5)
        L_0x0067:
            r7.onGainingFocus(r1, r6)
            goto L_0x00a5
        L_0x006b:
            com.stripe.android.paymentsheet.ui.BillingAddressView$PostalCodeViewListener r7 = r5.postalCodeViewListener
            if (r7 != 0) goto L_0x0070
            goto L_0x0086
        L_0x0070:
            com.stripe.android.view.CountryTextInputLayout r3 = r5.countryLayout
            com.stripe.android.core.model.CountryCode r3 = r3.getSelectedCountryCode()
            if (r3 != 0) goto L_0x0079
            goto L_0x0083
        L_0x0079:
            com.stripe.android.core.model.CountryUtils r1 = com.stripe.android.core.model.CountryUtils.INSTANCE
            java.util.Locale r4 = r5.getLocale()
            com.stripe.android.core.model.Country r1 = r1.getCountryByCode(r3, r4)
        L_0x0083:
            r7.onLosingFocus(r1, r6)
        L_0x0086:
            com.stripe.android.view.StripeEditText r7 = r5.postalCodeView
            r1 = r7
            android.widget.EditText r1 = (android.widget.EditText) r1
            java.lang.String r5 = r5.getValue(r1)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x009c
            boolean r5 = kotlin.text.StringsKt.isBlank(r5)
            if (r5 == 0) goto L_0x009a
            goto L_0x009c
        L_0x009a:
            r5 = 0
            goto L_0x009d
        L_0x009c:
            r5 = 1
        L_0x009d:
            if (r5 != 0) goto L_0x00a2
            if (r6 != 0) goto L_0x00a2
            r0 = 1
        L_0x00a2:
            r7.setShouldShowError(r0)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.ui.BillingAddressView.m4441_init_$lambda9(com.stripe.android.paymentsheet.ui.BillingAddressView, android.view.View, boolean):void");
    }

    /* access modifiers changed from: private */
    public final Address createAddress() {
        Address address2;
        CountryCode selectedCountryCode = this.countryLayout.getSelectedCountryCode();
        if (selectedCountryCode == null) {
            return null;
        }
        String value = getValue(getPostalCodeView$paymentsheet_release());
        if (!this.postalCodeValidator.isValid(value == null ? "" : value, selectedCountryCode.getValue())) {
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[getLevel$paymentsheet_release().ordinal()];
        if (i == 1) {
            address2 = new Address.Builder().setCountryCode(selectedCountryCode).setPostalCode(value).build();
        } else if (i == 2) {
            address2 = createRequiredAddress(selectedCountryCode, value);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return address2;
    }

    private final Address createRequiredAddress(CountryCode countryCode, String str) {
        String value = getValue(this.address1View);
        String value2 = getValue(this.address2View);
        String value3 = getValue(this.cityView);
        String value4 = getValue(this.stateView);
        if (value == null || value3 == null) {
            return null;
        }
        if (!isUnitedStates()) {
            return new Address.Builder().setCountryCode(countryCode).setPostalCode(str).setLine1(value).setLine2(value2).setCity(value3).build();
        }
        if (value4 != null) {
            return new Address.Builder().setCountryCode(countryCode).setPostalCode(str).setLine1(value).setLine2(value2).setCity(value3).setState(value4).build();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void updateStateView(CountryCode countryCode) {
        int i;
        if (CountryCode.Companion.isUS(countryCode)) {
            i = R.string.address_label_state;
        } else if (CountryCode.Companion.isCA(countryCode)) {
            i = R.string.address_label_province;
        } else if (CountryCode.Companion.isGB(countryCode)) {
            i = R.string.address_label_county;
        } else {
            i = R.string.address_label_region_generic;
        }
        getStateLayout$paymentsheet_release().setHint((CharSequence) getResources().getString(i));
    }

    /* access modifiers changed from: private */
    public final void updatePostalCodeView(CountryCode countryCode) {
        PostalCodeConfig postalCodeConfig;
        int i;
        boolean z = true;
        int i2 = 0;
        boolean z2 = countryCode == null || CountryUtils.INSTANCE.doesCountryUsePostalCode(countryCode);
        this.postalCodeLayout.setVisibility(z2 ? 0 : 8);
        if (getLevel$paymentsheet_release() != BillingAddressCollectionLevel.Required && !z2) {
            z = false;
        }
        View view = this.viewBinding.cityPostalDivider;
        Intrinsics.checkNotNullExpressionValue(view, "viewBinding.cityPostalDivider");
        view.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = this.viewBinding.cityPostalContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.cityPostalContainer");
        View view2 = linearLayout;
        if (!z) {
            i2 = 8;
        }
        view2.setVisibility(i2);
        if (CountryCode.Companion.isUS(countryCode)) {
            postalCodeConfig = PostalCodeConfig.UnitedStates.INSTANCE;
        } else {
            postalCodeConfig = PostalCodeConfig.Global.INSTANCE;
        }
        setPostalCodeConfig(postalCodeConfig);
        TextInputLayout textInputLayout = this.viewBinding.postalCodeLayout;
        Resources resources = getResources();
        if (CountryCode.Companion.isUS(countryCode)) {
            i = R.string.acc_label_zip_short;
        } else {
            i = R.string.address_label_postal_code;
        }
        textInputLayout.setHint((CharSequence) resources.getString(i));
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (TextInputLayout enabled : SetsKt.setOf(this.countryLayout, this.viewBinding.address1Layout, this.viewBinding.address2Layout, this.viewBinding.cityLayout, this.postalCodeLayout, this.stateLayout)) {
            enabled.setEnabled(z);
        }
    }

    /* access modifiers changed from: private */
    public final void configureForLevel() {
        int i = WhenMappings.$EnumSwitchMapping$0[getLevel$paymentsheet_release().ordinal()];
        if (i == 1) {
            for (View view : this.requiredViews) {
                Intrinsics.checkNotNullExpressionValue(view, "it");
                view.setVisibility(8);
            }
        } else if (i == 2) {
            for (View view2 : this.requiredViews) {
                Intrinsics.checkNotNullExpressionValue(view2, "it");
                view2.setVisibility(0);
            }
        }
        this._address.setValue(createAddress());
    }

    public final void focusFirstField() {
        int i = WhenMappings.$EnumSwitchMapping$0[getLevel$paymentsheet_release().ordinal()];
        if (i == 1) {
            this.postalCodeLayout.requestFocus();
        } else if (i == 2) {
            this.viewBinding.address1Layout.requestFocus();
        }
    }

    public final void populate$paymentsheet_release(Address address2) {
        if (address2 != null) {
            getPostalCodeView$paymentsheet_release().setText(address2.getPostalCode());
            CountryCode countryCode = address2.getCountryCode();
            if (countryCode != null) {
                getCountryLayout$paymentsheet_release().setSelectedCountryCode(countryCode);
                getCountryView$paymentsheet_release().setText(CountryUtils.INSTANCE.getDisplayCountry(countryCode, getLocale()));
            }
            getAddress1View$paymentsheet_release().setText(address2.getLine1());
            getAddress2View$paymentsheet_release().setText(address2.getLine2());
            getCityView$paymentsheet_release().setText(address2.getCity());
            getStateView$paymentsheet_release().setText(address2.getState());
        }
    }

    /* access modifiers changed from: private */
    public final String getValue(EditText editText) {
        Editable text;
        boolean z = true;
        if (!(editText.getVisibility() == 0)) {
            editText = null;
        }
        String obj = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        CharSequence charSequence = obj;
        if (charSequence != null && !StringsKt.isBlank(charSequence)) {
            z = false;
        }
        if (!z) {
            return obj;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final Locale getLocale() {
        Locale locale = ConfigurationCompat.getLocales(getContext().getResources().getConfiguration()).get(0);
        Intrinsics.checkNotNull(locale);
        Intrinsics.checkNotNullExpressionValue(locale, "ConfigurationCompat.getL…urces.configuration)[0]!!");
        return locale;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig;", "", "()V", "inputType", "", "getInputType", "()I", "maxLength", "getMaxLength", "getKeyListener", "Landroid/text/method/KeyListener;", "Global", "UnitedStates", "Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig$UnitedStates;", "Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig$Global;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BillingAddressView.kt */
    public static abstract class PostalCodeConfig {
        public /* synthetic */ PostalCodeConfig(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int getInputType();

        public abstract KeyListener getKeyListener();

        public abstract int getMaxLength();

        private PostalCodeConfig() {
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig$UnitedStates;", "Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig;", "()V", "inputType", "", "getInputType", "()I", "maxLength", "getMaxLength", "getKeyListener", "Landroid/text/method/KeyListener;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: BillingAddressView.kt */
        public static final class UnitedStates extends PostalCodeConfig {
            public static final int $stable = 0;
            public static final UnitedStates INSTANCE = new UnitedStates();
            private static final int inputType = 18;
            private static final int maxLength = 5;

            private UnitedStates() {
                super((DefaultConstructorMarker) null);
            }

            public int getMaxLength() {
                return maxLength;
            }

            public int getInputType() {
                return inputType;
            }

            public KeyListener getKeyListener() {
                DigitsKeyListener instance = DigitsKeyListener.getInstance(false, true);
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance(false, true)");
                return instance;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig$Global;", "Lcom/stripe/android/paymentsheet/ui/BillingAddressView$PostalCodeConfig;", "()V", "inputType", "", "getInputType", "()I", "maxLength", "getMaxLength", "getKeyListener", "Landroid/text/method/KeyListener;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: BillingAddressView.kt */
        public static final class Global extends PostalCodeConfig {
            public static final int $stable = 0;
            public static final Global INSTANCE = new Global();
            private static final int inputType = 112;
            private static final int maxLength = 13;

            private Global() {
                super((DefaultConstructorMarker) null);
            }

            public int getMaxLength() {
                return maxLength;
            }

            public int getInputType() {
                return inputType;
            }

            public KeyListener getKeyListener() {
                TextKeyListener instance = TextKeyListener.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
                return instance;
            }
        }
    }
}
