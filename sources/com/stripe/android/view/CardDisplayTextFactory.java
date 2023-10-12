package com.stripe.android.view;

import android.content.res.Resources;
import android.text.ParcelableSpan;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import com.stripe.android.R;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/view/CardDisplayTextFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "resources", "Landroid/content/res/Resources;", "themeConfig", "Lcom/stripe/android/view/ThemeConfig;", "(Landroid/content/res/Resources;Lcom/stripe/android/view/ThemeConfig;)V", "createStyled", "Landroid/text/SpannableString;", "brand", "Lcom/stripe/android/model/CardBrand;", "last4", "", "isSelected", "", "createStyled$payments_core_release", "createUnstyled", "card", "Lcom/stripe/android/model/PaymentMethod$Card;", "createUnstyled$payments_core_release", "setSpan", "", "displayString", "span", "Landroid/text/ParcelableSpan;", "start", "", "end", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardDisplayTextFactory.kt */
public final class CardDisplayTextFactory {
    private final Resources resources;
    private final ThemeConfig themeConfig;

    public CardDisplayTextFactory(Resources resources2, ThemeConfig themeConfig2) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        Intrinsics.checkNotNullParameter(themeConfig2, "themeConfig");
        this.resources = resources2;
        this.themeConfig = themeConfig2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CardDisplayTextFactory(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.res.Resources r0 = r3.getResources()
            java.lang.String r1 = "context.resources"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.stripe.android.view.ThemeConfig r1 = new com.stripe.android.view.ThemeConfig
            r1.<init>(r3)
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.CardDisplayTextFactory.<init>(android.content.Context):void");
    }

    public final /* synthetic */ SpannableString createStyled$payments_core_release(CardBrand cardBrand, String str, boolean z) {
        Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
        String displayName = cardBrand.getDisplayName();
        int length = displayName.length();
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            SpannableString spannableString = new SpannableString(displayName);
            setSpan(spannableString, new TypefaceSpan("sans-serif-medium"), 0, length);
            return spannableString;
        }
        String string = this.resources.getString(R.string.card_ending_in, new Object[]{displayName, str});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ing_in, brandText, last4)");
        int length2 = string.length();
        CharSequence charSequence2 = string;
        CharSequence charSequence3 = charSequence2;
        int indexOf$default = StringsKt.indexOf$default(charSequence3, str, 0, false, 6, (Object) null);
        int length3 = str.length() + indexOf$default;
        int indexOf$default2 = StringsKt.indexOf$default(charSequence3, displayName, 0, false, 6, (Object) null);
        int length4 = displayName.length() + indexOf$default2;
        int textColor$payments_core_release = this.themeConfig.getTextColor$payments_core_release(z);
        int textAlphaColor$payments_core_release = this.themeConfig.getTextAlphaColor$payments_core_release(z);
        SpannableString spannableString2 = new SpannableString(charSequence2);
        setSpan(spannableString2, new ForegroundColorSpan(textAlphaColor$payments_core_release), 0, length2);
        setSpan(spannableString2, new TypefaceSpan("sans-serif-medium"), indexOf$default2, length4);
        setSpan(spannableString2, new ForegroundColorSpan(textColor$payments_core_release), indexOf$default2, length4);
        setSpan(spannableString2, new TypefaceSpan("sans-serif-medium"), indexOf$default, length3);
        setSpan(spannableString2, new ForegroundColorSpan(textColor$payments_core_release), indexOf$default, length3);
        return spannableString2;
    }

    public final /* synthetic */ String createUnstyled$payments_core_release(PaymentMethod.Card card) {
        Intrinsics.checkNotNullParameter(card, "card");
        String string = this.resources.getString(R.string.card_ending_in, new Object[]{card.brand.getDisplayName(), card.last4});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …     card.last4\n        )");
        return string;
    }

    private final void setSpan(SpannableString spannableString, ParcelableSpan parcelableSpan, int i, int i2) {
        spannableString.setSpan(parcelableSpan, i, i2, 33);
    }
}
