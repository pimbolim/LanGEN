package com.stripe.android.view;

import com.stripe.android.core.model.CountryUtils;
import com.stripe.android.view.ShippingInfoWidget;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/PostalCodeValidator;", "", "()V", "isValid", "", "postalCode", "", "countryCode", "optionalShippingInfoFields", "", "Lcom/stripe/android/view/ShippingInfoWidget$CustomizableShippingField;", "hiddenShippingInfoFields", "isValid$payments_core_release", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PostalCodeValidator.kt */
public final class PostalCodeValidator {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final Map<String, Pattern> POSTAL_CODE_PATTERNS = MapsKt.mapOf(TuplesKt.to(Locale.US.getCountry(), Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$")));

    public final boolean isValid(String str, String str2) {
        Matcher matcher;
        Intrinsics.checkNotNullParameter(str, "postalCode");
        Intrinsics.checkNotNullParameter(str2, "countryCode");
        Pattern pattern = POSTAL_CODE_PATTERNS.get(str2);
        Boolean bool = null;
        if (!(pattern == null || (matcher = pattern.matcher(str)) == null)) {
            bool = Boolean.valueOf(matcher.matches());
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!CountryUtils.INSTANCE.doesCountryUsePostalCode(str2) || (!StringsKt.isBlank(str))) {
            return true;
        }
        return false;
    }

    public final boolean isValid$payments_core_release(String str, String str2, List<? extends ShippingInfoWidget.CustomizableShippingField> list, List<? extends ShippingInfoWidget.CustomizableShippingField> list2) {
        Matcher matcher;
        Intrinsics.checkNotNullParameter(str, "postalCode");
        Intrinsics.checkNotNullParameter(list, "optionalShippingInfoFields");
        Intrinsics.checkNotNullParameter(list2, "hiddenShippingInfoFields");
        if (str2 == null) {
            return false;
        }
        CharSequence charSequence = str;
        if (!(charSequence.length() == 0) || !Companion.isPostalCodeNotRequired(list, list2)) {
            Pattern pattern = POSTAL_CODE_PATTERNS.get(str2);
            Boolean bool = null;
            if (!(pattern == null || (matcher = pattern.matcher(charSequence)) == null)) {
                bool = Boolean.valueOf(matcher.matches());
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            if (!CountryUtils.INSTANCE.doesCountryUsePostalCode(str2) || (!StringsKt.isBlank(charSequence))) {
                return true;
            }
            return false;
        }
        return true;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002R*\u0010\u0003\u001a\u001e\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00070\u00070\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/PostalCodeValidator$Companion;", "", "()V", "POSTAL_CODE_PATTERNS", "", "", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "isPostalCodeNotRequired", "", "optionalShippingInfoFields", "", "Lcom/stripe/android/view/ShippingInfoWidget$CustomizableShippingField;", "hiddenShippingInfoFields", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PostalCodeValidator.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean isPostalCodeNotRequired(List<? extends ShippingInfoWidget.CustomizableShippingField> list, List<? extends ShippingInfoWidget.CustomizableShippingField> list2) {
            return list.contains(ShippingInfoWidget.CustomizableShippingField.PostalCode) || list2.contains(ShippingInfoWidget.CustomizableShippingField.PostalCode);
        }
    }
}
