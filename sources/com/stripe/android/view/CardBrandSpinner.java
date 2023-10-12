package com.stripe.android.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.stripe.android.databinding.CardBrandSpinnerDropdownBinding;
import com.stripe.android.databinding.CardBrandSpinnerMainBinding;
import com.stripe.android.model.CardBrand;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0018B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0014\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015J\u0010\u0010\u0016\u001a\u00020\u00122\b\b\u0001\u0010\u0017\u001a\u00020\u0007R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/view/CardBrandSpinner;", "Landroidx/appcompat/widget/AppCompatSpinner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cardBrand", "Lcom/stripe/android/model/CardBrand;", "getCardBrand", "()Lcom/stripe/android/model/CardBrand;", "cardBrandsAdapter", "Lcom/stripe/android/view/CardBrandSpinner$Adapter;", "defaultBackground", "Landroid/graphics/drawable/Drawable;", "onFinishInflate", "", "setCardBrands", "cardBrands", "", "setTintColor", "tintColor", "Adapter", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardBrandSpinner.kt */
public final class CardBrandSpinner extends AppCompatSpinner {
    private final Adapter cardBrandsAdapter;
    private Drawable defaultBackground;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardBrandSpinner(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardBrandSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardBrandSpinner(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.spinnerStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardBrandSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 1);
        Intrinsics.checkNotNullParameter(context, "context");
        Adapter adapter = new Adapter(context);
        this.cardBrandsAdapter = adapter;
        setAdapter((SpinnerAdapter) adapter);
        setDropDownWidth(getResources().getDimensionPixelSize(com.stripe.android.R.dimen.card_brand_spinner_dropdown_width));
    }

    public final CardBrand getCardBrand() {
        return (CardBrand) getSelectedItem();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.defaultBackground = getBackground();
        setCardBrands(CollectionsKt.listOf(CardBrand.Unknown));
    }

    public final void setTintColor(int i) {
        this.cardBrandsAdapter.setTintColor$payments_core_release(i);
    }

    public final /* synthetic */ void setCardBrands(List list) {
        Intrinsics.checkNotNullParameter(list, "cardBrands");
        this.cardBrandsAdapter.clear();
        this.cardBrandsAdapter.addAll(list);
        this.cardBrandsAdapter.notifyDataSetChanged();
        setSelection(0);
        if (list.size() > 1) {
            setClickable(true);
            setEnabled(true);
            setBackground(this.defaultBackground);
            return;
        }
        setClickable(false);
        setEnabled(false);
        setBackgroundColor(ContextCompat.getColor(getContext(), 17170445));
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/view/CardBrandSpinner$Adapter;", "Landroid/widget/ArrayAdapter;", "Lcom/stripe/android/model/CardBrand;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "tintColor", "", "getTintColor$payments_core_release", "()I", "setTintColor$payments_core_release", "(I)V", "createCardBrandDrawable", "Landroid/graphics/drawable/Drawable;", "cardBrand", "getDropDownView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "getView", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardBrandSpinner.kt */
    public static final class Adapter extends ArrayAdapter<CardBrand> {
        private final LayoutInflater layoutInflater;
        private int tintColor;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Adapter(Context context) {
            super(context, 0);
            Intrinsics.checkNotNullParameter(context, "context");
            this.layoutInflater = LayoutInflater.from(context);
        }

        public final int getTintColor$payments_core_release() {
            return this.tintColor;
        }

        public final void setTintColor$payments_core_release(int i) {
            this.tintColor = i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            CardBrandSpinnerMainBinding bind = view == null ? null : CardBrandSpinnerMainBinding.bind(view);
            if (bind == null) {
                bind = CardBrandSpinnerMainBinding.inflate(this.layoutInflater, viewGroup, false);
            }
            Intrinsics.checkNotNullExpressionValue(bind, "convertView?.let {\n     …tInflater, parent, false)");
            Object item = getItem(i);
            if (item != null) {
                CardBrand cardBrand = (CardBrand) item;
                AppCompatImageView appCompatImageView = bind.image;
                appCompatImageView.setImageDrawable(createCardBrandDrawable(cardBrand));
                appCompatImageView.setContentDescription(cardBrand.getDisplayName());
                AppCompatImageView root = bind.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
                return root;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            CardBrandSpinnerDropdownBinding bind = view == null ? null : CardBrandSpinnerDropdownBinding.bind(view);
            if (bind == null) {
                bind = CardBrandSpinnerDropdownBinding.inflate(this.layoutInflater, viewGroup, false);
            }
            Intrinsics.checkNotNullExpressionValue(bind, "convertView?.let {\n     …tInflater, parent, false)");
            Object item = getItem(i);
            if (item != null) {
                CardBrand cardBrand = (CardBrand) item;
                AppCompatTextView appCompatTextView = bind.textView;
                appCompatTextView.setText(cardBrand.getDisplayName());
                appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(createCardBrandDrawable(cardBrand), (Drawable) null, (Drawable) null, (Drawable) null);
                AppCompatTextView root = bind.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
                return root;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        private final Drawable createCardBrandDrawable(CardBrand cardBrand) {
            Drawable drawable = ContextCompat.getDrawable(getContext(), cardBrand.getIcon());
            if (drawable == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            } else if (cardBrand != CardBrand.Unknown) {
                return drawable;
            } else {
                Drawable wrap = DrawableCompat.wrap(drawable);
                DrawableCompat.setTint(wrap.mutate(), this.tintColor);
                Drawable unwrap = DrawableCompat.unwrap(wrap);
                Intrinsics.checkNotNullExpressionValue(unwrap, "{\n                val co…compatIcon)\n            }");
                return unwrap;
            }
        }
    }
}
