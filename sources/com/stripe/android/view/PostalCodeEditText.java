package com.stripe.android.view;

import android.content.Context;
import android.os.Build;
import android.text.InputFilter;
import android.text.method.DigitsKeyListener;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002!\"B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\u0017H\u0014J\u0012\u0010\u001f\u001a\u00020\u00172\b\b\u0001\u0010 \u001a\u00020\u0007H\u0002R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8@@@X\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138@X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/stripe/android/view/PostalCodeEditText;", "Lcom/stripe/android/view/StripeEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/stripe/android/view/PostalCodeEditText$Config;", "config", "getConfig$payments_core_release", "()Lcom/stripe/android/view/PostalCodeEditText$Config;", "setConfig$payments_core_release", "(Lcom/stripe/android/view/PostalCodeEditText$Config;)V", "config$delegate", "Lkotlin/properties/ReadWriteProperty;", "postalCode", "", "getPostalCode$payments_core_release", "()Ljava/lang/String;", "configureForGlobal", "", "configureForUs", "getTextInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "hasValidPostal", "", "hasValidPostal$payments_core_release", "onFinishInflate", "updateHint", "hintRes", "Companion", "Config", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PostalCodeEditText.kt */
public final class PostalCodeEditText extends StripeEditText {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(PostalCodeEditText.class, "config", "getConfig$payments_core_release()Lcom/stripe/android/view/PostalCodeEditText$Config;", 0))};
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int MAX_LENGTH_US = 5;
    @Deprecated
    private static final Pattern ZIP_CODE_PATTERN = Pattern.compile("^[0-9]{5}$");
    private final ReadWriteProperty config$delegate;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/view/PostalCodeEditText$Config;", "", "(Ljava/lang/String;I)V", "Global", "US", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PostalCodeEditText.kt */
    public enum Config {
        Global,
        US
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PostalCodeEditText.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Config.values().length];
            iArr[Config.Global.ordinal()] = 1;
            iArr[Config.US.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PostalCodeEditText(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PostalCodeEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PostalCodeEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostalCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Delegates delegates = Delegates.INSTANCE;
        this.config$delegate = new PostalCodeEditText$special$$inlined$observable$1(Config.Global, this);
        setErrorMessage(getResources().getString(com.stripe.android.R.string.invalid_zip));
        setMaxLines(1);
        addTextChangedListener(new PostalCodeEditText$special$$inlined$doAfterTextChanged$1(this));
        if (Build.VERSION.SDK_INT >= 26) {
            setAutofillHints(new String[]{"postalCode"});
        }
    }

    public final Config getConfig$payments_core_release() {
        return (Config) this.config$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setConfig$payments_core_release(Config config) {
        Intrinsics.checkNotNullParameter(config, "<set-?>");
        this.config$delegate.setValue(this, $$delegatedProperties[0], config);
    }

    public final String getPostalCode$payments_core_release() {
        if (getConfig$payments_core_release() != Config.US) {
            return getFieldText$payments_core_release();
        }
        String fieldText$payments_core_release = getFieldText$payments_core_release();
        if (ZIP_CODE_PATTERN.matcher(getFieldText$payments_core_release()).matches()) {
            return fieldText$payments_core_release;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        configureForGlobal();
    }

    /* access modifiers changed from: private */
    public final void configureForUs() {
        updateHint(com.stripe.android.R.string.address_label_zip_code);
        setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(5)});
        setKeyListener(DigitsKeyListener.getInstance(false, true));
        setNumberOnlyInputType();
    }

    /* access modifiers changed from: private */
    public final void configureForGlobal() {
        updateHint(com.stripe.android.R.string.address_label_postal_code);
        setKeyListener(TextKeyListener.getInstance());
        setInputType(112);
        setFilters(new InputFilter[0]);
    }

    private final void updateHint(int i) {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            if (textInputLayout.isHintEnabled()) {
                textInputLayout.setHint((CharSequence) getResources().getString(i));
            } else {
                setHint(i);
            }
        }
    }

    private final TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean hasValidPostal$payments_core_release() {
        if (getConfig$payments_core_release() == Config.US && ZIP_CODE_PATTERN.matcher(getFieldText$payments_core_release()).matches()) {
            return true;
        }
        if (getConfig$payments_core_release() == Config.Global) {
            if (getFieldText$payments_core_release().length() > 0) {
                return true;
            }
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/PostalCodeEditText$Companion;", "", "()V", "MAX_LENGTH_US", "", "ZIP_CODE_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PostalCodeEditText.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
