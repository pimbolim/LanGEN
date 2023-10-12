package com.stripe.android.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import com.stripe.android.R;
import com.stripe.android.databinding.MaskedCardViewBinding;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.PaymentMethod;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020\u001bH\u0002R\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u00108G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/stripe/android/view/MaskedCardView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/stripe/android/model/CardBrand;", "cardBrand", "getCardBrand", "()Lcom/stripe/android/model/CardBrand;", "cardDisplayFactory", "Lcom/stripe/android/view/CardDisplayTextFactory;", "", "last4", "getLast4", "()Ljava/lang/String;", "themeConfig", "Lcom/stripe/android/view/ThemeConfig;", "viewBinding", "Lcom/stripe/android/databinding/MaskedCardViewBinding;", "getViewBinding$payments_core_release", "()Lcom/stripe/android/databinding/MaskedCardViewBinding;", "applyTint", "", "imageView", "Landroid/widget/ImageView;", "setPaymentMethod", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "setSelected", "selected", "", "updateBrandIcon", "updateCheckMark", "updateUi", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaskedCardView.kt */
public final class MaskedCardView extends LinearLayout {
    private CardBrand cardBrand;
    private final CardDisplayTextFactory cardDisplayFactory;
    private String last4;
    private final ThemeConfig themeConfig;
    private final MaskedCardViewBinding viewBinding;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MaskedCardView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardBrand.values().length];
            iArr[CardBrand.AmericanExpress.ordinal()] = 1;
            iArr[CardBrand.Discover.ordinal()] = 2;
            iArr[CardBrand.JCB.ordinal()] = 3;
            iArr[CardBrand.DinersClub.ordinal()] = 4;
            iArr[CardBrand.Visa.ordinal()] = 5;
            iArr[CardBrand.MasterCard.ordinal()] = 6;
            iArr[CardBrand.UnionPay.ordinal()] = 7;
            iArr[CardBrand.Unknown.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedCardView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MaskedCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MaskedCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaskedCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cardBrand = CardBrand.Unknown;
        MaskedCardViewBinding inflate = MaskedCardViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI…text),\n        this\n    )");
        this.viewBinding = inflate;
        ThemeConfig themeConfig2 = new ThemeConfig(context);
        this.themeConfig = themeConfig2;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.cardDisplayFactory = new CardDisplayTextFactory(resources, themeConfig2);
        AppCompatImageView appCompatImageView = inflate.brandIcon;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "viewBinding.brandIcon");
        applyTint(appCompatImageView);
        AppCompatImageView appCompatImageView2 = inflate.checkIcon;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "viewBinding.checkIcon");
        applyTint(appCompatImageView2);
    }

    public final CardBrand getCardBrand() {
        return this.cardBrand;
    }

    public final String getLast4() {
        return this.last4;
    }

    public final MaskedCardViewBinding getViewBinding$payments_core_release() {
        return this.viewBinding;
    }

    private final void applyTint(ImageView imageView) {
        ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(this.themeConfig.getTintColor$payments_core_release(true)));
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        updateCheckMark();
        updateUi();
    }

    public final void setPaymentMethod(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        PaymentMethod.Card card = paymentMethod.card;
        String str = null;
        CardBrand cardBrand2 = card == null ? null : card.brand;
        if (cardBrand2 == null) {
            cardBrand2 = CardBrand.Unknown;
        }
        this.cardBrand = cardBrand2;
        PaymentMethod.Card card2 = paymentMethod.card;
        if (card2 != null) {
            str = card2.last4;
        }
        this.last4 = str;
        updateUi();
    }

    private final void updateUi() {
        updateBrandIcon();
        this.viewBinding.details.setText(this.cardDisplayFactory.createStyled$payments_core_release(this.cardBrand, this.last4, isSelected()));
    }

    private final void updateBrandIcon() {
        int i;
        AppCompatImageView appCompatImageView = this.viewBinding.brandIcon;
        Context context = getContext();
        switch (WhenMappings.$EnumSwitchMapping$0[this.cardBrand.ordinal()]) {
            case 1:
                i = R.drawable.stripe_ic_amex_template_32;
                break;
            case 2:
                i = R.drawable.stripe_ic_discover_template_32;
                break;
            case 3:
                i = R.drawable.stripe_ic_jcb_template_32;
                break;
            case 4:
                i = R.drawable.stripe_ic_diners_template_32;
                break;
            case 5:
                i = R.drawable.stripe_ic_visa_template_32;
                break;
            case 6:
                i = R.drawable.stripe_ic_mastercard_template_32;
                break;
            case 7:
                i = R.drawable.stripe_ic_unionpay_template_32;
                break;
            case 8:
                i = R.drawable.stripe_ic_unknown;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context, i));
    }

    private final void updateCheckMark() {
        this.viewBinding.checkIcon.setVisibility(isSelected() ? 0 : 4);
    }
}
