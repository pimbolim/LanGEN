package com.stripe.android.view;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.stripe.android.R;
import com.stripe.android.databinding.BankItemBinding;
import com.stripe.android.model.BankStatuses;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\b\u0010\u001f\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\nH\u0016J\u000e\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\nJ\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nH\u0016J\u0015\u0010*\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0002\b+R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "themeConfig", "Lcom/stripe/android/view/ThemeConfig;", "items", "", "Lcom/stripe/android/view/Bank;", "itemSelectedCallback", "Lkotlin/Function1;", "", "", "(Lcom/stripe/android/view/ThemeConfig;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "bankStatuses", "Lcom/stripe/android/model/BankStatuses;", "getBankStatuses$payments_core_release", "()Lcom/stripe/android/model/BankStatuses;", "setBankStatuses$payments_core_release", "(Lcom/stripe/android/model/BankStatuses;)V", "getItemSelectedCallback", "()Lkotlin/jvm/functions/Function1;", "getItems", "()Ljava/util/List;", "value", "selectedPosition", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "getThemeConfig", "()Lcom/stripe/android/view/ThemeConfig;", "getItemCount", "getItemId", "", "position", "notifyAdapterItemChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateSelected", "updateSelected$payments_core_release", "BankViewHolder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodListAdapter.kt */
public final class AddPaymentMethodListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private BankStatuses bankStatuses;
    private final Function1<Integer, Unit> itemSelectedCallback;
    private final List<Bank> items;
    private int selectedPosition = -1;
    private final ThemeConfig themeConfig;

    public long getItemId(int i) {
        return (long) i;
    }

    public final ThemeConfig getThemeConfig() {
        return this.themeConfig;
    }

    public final List<Bank> getItems() {
        return this.items;
    }

    public final Function1<Integer, Unit> getItemSelectedCallback() {
        return this.itemSelectedCallback;
    }

    public AddPaymentMethodListAdapter(ThemeConfig themeConfig2, List<? extends Bank> list, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(themeConfig2, "themeConfig");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function1, "itemSelectedCallback");
        this.themeConfig = themeConfig2;
        this.items = list;
        this.itemSelectedCallback = function1;
        setHasStableIds(true);
    }

    public final BankStatuses getBankStatuses$payments_core_release() {
        return this.bankStatuses;
    }

    public final void setBankStatuses$payments_core_release(BankStatuses bankStatuses2) {
        this.bankStatuses = bankStatuses2;
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i) {
        int i2 = this.selectedPosition;
        if (i != i2) {
            if (i2 != -1) {
                notifyItemChanged(i2);
            }
            notifyItemChanged(i);
            this.itemSelectedCallback.invoke(Integer.valueOf(i));
        }
        this.selectedPosition = i;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        BankItemBinding inflate = BankItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n               …      false\n            )");
        return new BankViewHolder(inflate, this.themeConfig);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Bank bank = this.items.get(i);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(viewHolder) {
            public final /* synthetic */ RecyclerView.ViewHolder f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                AddPaymentMethodListAdapter.m4639onBindViewHolder$lambda0(AddPaymentMethodListAdapter.this, this.f$1, view);
            }
        });
        BankViewHolder bankViewHolder = (BankViewHolder) viewHolder;
        boolean z = true;
        bankViewHolder.setSelected$payments_core_release(i == this.selectedPosition);
        BankStatuses bankStatuses2 = this.bankStatuses;
        if (bankStatuses2 != null) {
            z = bankStatuses2.isOnline$payments_core_release(bank);
        }
        bankViewHolder.update(bank, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m4639onBindViewHolder$lambda0(AddPaymentMethodListAdapter addPaymentMethodListAdapter, RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(addPaymentMethodListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        addPaymentMethodListAdapter.setSelectedPosition(viewHolder.getBindingAdapterPosition());
    }

    public final void updateSelected$payments_core_release(int i) {
        setSelectedPosition(i);
        notifyItemChanged(i);
    }

    public final void notifyAdapterItemChanged(int i) {
        notifyItemChanged(i);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodListAdapter$BankViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/stripe/android/databinding/BankItemBinding;", "themeConfig", "Lcom/stripe/android/view/ThemeConfig;", "(Lcom/stripe/android/databinding/BankItemBinding;Lcom/stripe/android/view/ThemeConfig;)V", "resources", "Landroid/content/res/Resources;", "setSelected", "", "isSelected", "", "setSelected$payments_core_release", "update", "bank", "Lcom/stripe/android/view/Bank;", "isOnline", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddPaymentMethodListAdapter.kt */
    public static final class BankViewHolder extends RecyclerView.ViewHolder {
        private final Resources resources;
        private final ThemeConfig themeConfig;
        private final BankItemBinding viewBinding;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BankViewHolder(BankItemBinding bankItemBinding, ThemeConfig themeConfig2) {
            super(bankItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(bankItemBinding, "viewBinding");
            Intrinsics.checkNotNullParameter(themeConfig2, "themeConfig");
            this.viewBinding = bankItemBinding;
            this.themeConfig = themeConfig2;
            Resources resources2 = this.itemView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "itemView.resources");
            this.resources = resources2;
        }

        public final void update(Bank bank, boolean z) {
            CharSequence charSequence;
            Intrinsics.checkNotNullParameter(bank, "bank");
            AppCompatTextView appCompatTextView = this.viewBinding.name;
            if (z) {
                charSequence = bank.getDisplayName();
            } else {
                charSequence = this.resources.getString(R.string.fpx_bank_offline, new Object[]{bank.getDisplayName()});
            }
            appCompatTextView.setText(charSequence);
            Integer brandIconResId = bank.getBrandIconResId();
            if (brandIconResId != null) {
                this.viewBinding.icon.setImageResource(brandIconResId.intValue());
            }
        }

        public final void setSelected$payments_core_release(boolean z) {
            this.viewBinding.name.setTextColor(this.themeConfig.getTextColor$payments_core_release(z));
            ImageViewCompat.setImageTintList(this.viewBinding.checkIcon, ColorStateList.valueOf(this.themeConfig.getTintColor$payments_core_release(z)));
            AppCompatImageView appCompatImageView = this.viewBinding.checkIcon;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "viewBinding.checkIcon");
            appCompatImageView.setVisibility(z ? 0 : 8);
        }
    }
}
