package com.stripe.android.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.stripe.android.databinding.CardBrandViewBinding;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020,H\u0002R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R+\u0010\u001c\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R+\u0010 \u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0011\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001e\u0010$\u001a\u00020\u00078\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/stripe/android/view/CardBrandView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "Lcom/stripe/android/model/CardBrand;", "brand", "getBrand", "()Lcom/stripe/android/model/CardBrand;", "setBrand", "(Lcom/stripe/android/model/CardBrand;)V", "brand$delegate", "Lkotlin/properties/ReadWriteProperty;", "iconView", "Landroid/widget/ImageView;", "", "isLoading", "()Z", "setLoading", "(Z)V", "isLoading$delegate", "progressView", "Lcom/stripe/android/view/CardWidgetProgressView;", "shouldShowCvc", "getShouldShowCvc", "setShouldShowCvc", "shouldShowCvc$delegate", "shouldShowErrorIcon", "getShouldShowErrorIcon", "setShouldShowErrorIcon", "shouldShowErrorIcon$delegate", "tintColorInt", "getTintColorInt$payments_core_release", "()I", "setTintColorInt$payments_core_release", "(I)V", "viewBinding", "Lcom/stripe/android/databinding/CardBrandViewBinding;", "applyTint", "", "renderBrandIcon", "updateIcon", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardBrandView.kt */
public final class CardBrandView extends FrameLayout {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final ReadWriteProperty brand$delegate;
    private final ImageView iconView;
    private final ReadWriteProperty isLoading$delegate;
    /* access modifiers changed from: private */
    public final CardWidgetProgressView progressView;
    private final ReadWriteProperty shouldShowCvc$delegate;
    private final ReadWriteProperty shouldShowErrorIcon$delegate;
    private int tintColorInt;
    private final CardBrandViewBinding viewBinding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardBrandView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardBrandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardBrandView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardBrandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        CardBrandViewBinding inflate = CardBrandViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI…text),\n        this\n    )");
        this.viewBinding = inflate;
        ImageView imageView = inflate.icon;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.icon");
        this.iconView = imageView;
        CardWidgetProgressView cardWidgetProgressView = inflate.progress;
        Intrinsics.checkNotNullExpressionValue(cardWidgetProgressView, "viewBinding.progress");
        this.progressView = cardWidgetProgressView;
        Delegates delegates = Delegates.INSTANCE;
        this.isLoading$delegate = new CardBrandView$special$$inlined$observable$1(false, this);
        Delegates delegates2 = Delegates.INSTANCE;
        this.brand$delegate = new CardBrandView$special$$inlined$observable$2(CardBrand.Unknown, this);
        Delegates delegates3 = Delegates.INSTANCE;
        this.shouldShowCvc$delegate = new CardBrandView$special$$inlined$observable$3(false, this);
        Delegates delegates4 = Delegates.INSTANCE;
        this.shouldShowErrorIcon$delegate = new CardBrandView$special$$inlined$observable$4(false, this);
        setClickable(false);
        setFocusable(false);
        addOnLayoutChangeListener(new CardBrandView$special$$inlined$doOnNextLayout$1(this));
    }

    public final int getTintColorInt$payments_core_release() {
        return this.tintColorInt;
    }

    public final void setTintColorInt$payments_core_release(int i) {
        this.tintColorInt = i;
    }

    static {
        Class<CardBrandView> cls = CardBrandView.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "isLoading", "isLoading()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, AccountRangeJsonParser.FIELD_BRAND, "getBrand()Lcom/stripe/android/model/CardBrand;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "shouldShowCvc", "getShouldShowCvc()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "shouldShowErrorIcon", "getShouldShowErrorIcon()Z", 0))};
    }

    public final boolean isLoading() {
        return ((Boolean) this.isLoading$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setLoading(boolean z) {
        this.isLoading$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final CardBrand getBrand() {
        return (CardBrand) this.brand$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setBrand(CardBrand cardBrand) {
        Intrinsics.checkNotNullParameter(cardBrand, "<set-?>");
        this.brand$delegate.setValue(this, $$delegatedProperties[1], cardBrand);
    }

    public final boolean getShouldShowCvc() {
        return ((Boolean) this.shouldShowCvc$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final void setShouldShowCvc(boolean z) {
        this.shouldShowCvc$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z));
    }

    public final boolean getShouldShowErrorIcon() {
        return ((Boolean) this.shouldShowErrorIcon$delegate.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public final void setShouldShowErrorIcon(boolean z) {
        this.shouldShowErrorIcon$delegate.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final void updateIcon() {
        if (isLoading()) {
            renderBrandIcon();
        } else if (getShouldShowErrorIcon()) {
            this.iconView.setImageResource(getBrand().getErrorIcon());
        } else if (getShouldShowCvc()) {
            this.iconView.setImageResource(getBrand().getCvcIcon());
            applyTint();
        } else {
            renderBrandIcon();
        }
    }

    private final void renderBrandIcon() {
        this.iconView.setImageResource(getBrand().getIcon());
        if (getBrand() == CardBrand.Unknown) {
            applyTint();
        }
    }

    private final void applyTint() {
        ImageView imageView = this.iconView;
        Drawable wrap = DrawableCompat.wrap(imageView.getDrawable());
        DrawableCompat.setTint(wrap.mutate(), getTintColorInt$payments_core_release());
        imageView.setImageDrawable(DrawableCompat.unwrap(wrap));
    }
}
