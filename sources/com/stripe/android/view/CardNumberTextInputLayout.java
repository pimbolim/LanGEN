package com.stripe.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewGroupKt;
import com.google.android.material.textfield.TextInputLayout;
import com.stripe.android.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B%\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0002R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8@@@X\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/view/CardNumberTextInputLayout;", "Lcom/google/android/material/textfield/TextInputLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "isLoading", "isLoading$payments_core_release", "()Z", "setLoading$payments_core_release", "(Z)V", "isLoading$delegate", "Lkotlin/properties/ReadWriteProperty;", "progressView", "Lcom/stripe/android/view/CardWidgetProgressView;", "attachProgressView", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardNumberTextInputLayout.kt */
public final class CardNumberTextInputLayout extends TextInputLayout {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CardNumberTextInputLayout.class, "isLoading", "isLoading$payments_core_release()Z", 0))};
    public static final int $stable = 8;
    private final ReadWriteProperty isLoading$delegate;
    /* access modifiers changed from: private */
    public final CardWidgetProgressView progressView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardNumberTextInputLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardNumberTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardNumberTextInputLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.textInputStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardNumberTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.progressView = new CardWidgetProgressView(context, attributeSet, i);
        Delegates delegates = Delegates.INSTANCE;
        this.isLoading$delegate = new CardNumberTextInputLayout$special$$inlined$observable$1(false, this);
        addOnLayoutChangeListener(new CardNumberTextInputLayout$special$$inlined$doOnNextLayout$1(this));
        setPlaceholderText(getResources().getString(R.string.card_number_hint));
    }

    public final boolean isLoading$payments_core_release() {
        return ((Boolean) this.isLoading$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setLoading$payments_core_release(boolean z) {
        this.isLoading$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public final void attachProgressView() {
        ViewParent parent = this.progressView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.progressView);
        }
        FrameLayout frameLayout = (FrameLayout) SequencesKt.first(ViewGroupKt.getChildren(this));
        frameLayout.addView(this.progressView);
        View view = this.progressView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ViewGroup.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        layoutParams3.setMarginStart(frameLayout.getWidth() - getResources().getDimensionPixelSize(R.dimen.stripe_card_number_text_input_layout_progress_end_margin));
        layoutParams3.topMargin = getResources().getDimensionPixelSize(R.dimen.stripe_card_number_text_input_layout_progress_top_margin);
        view.setLayoutParams(layoutParams2);
    }
}
