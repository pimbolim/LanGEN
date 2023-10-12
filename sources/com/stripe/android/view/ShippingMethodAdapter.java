package com.stripe.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stripe.android.model.ShippingMethod;
import com.stripe.android.view.ShippingMethodAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\rH\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\rH\u0016J\u0015\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0006H\u0000¢\u0006\u0002\b(R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R0\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0016@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/stripe/android/view/ShippingMethodAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stripe/android/view/ShippingMethodAdapter$ShippingMethodViewHolder;", "()V", "onShippingMethodSelectedCallback", "Lkotlin/Function1;", "Lcom/stripe/android/model/ShippingMethod;", "", "getOnShippingMethodSelectedCallback$payments_core_release", "()Lkotlin/jvm/functions/Function1;", "setOnShippingMethodSelectedCallback$payments_core_release", "(Lkotlin/jvm/functions/Function1;)V", "value", "", "selectedIndex", "getSelectedIndex$payments_core_release", "()I", "setSelectedIndex$payments_core_release", "(I)V", "selectedShippingMethod", "getSelectedShippingMethod", "()Lcom/stripe/android/model/ShippingMethod;", "", "shippingMethods", "getShippingMethods$payments_core_release", "()Ljava/util/List;", "setShippingMethods$payments_core_release", "(Ljava/util/List;)V", "getItemCount", "getItemId", "", "position", "onBindViewHolder", "holder", "i", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "setSelected", "shippingMethod", "setSelected$payments_core_release", "ShippingMethodViewHolder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShippingMethodAdapter.kt */
public final class ShippingMethodAdapter extends RecyclerView.Adapter<ShippingMethodViewHolder> {
    private Function1<? super ShippingMethod, Unit> onShippingMethodSelectedCallback = ShippingMethodAdapter$onShippingMethodSelectedCallback$1.INSTANCE;
    private /* synthetic */ int selectedIndex;
    private List<ShippingMethod> shippingMethods = CollectionsKt.emptyList();

    public ShippingMethodAdapter() {
        setHasStableIds(true);
    }

    public final Function1<ShippingMethod, Unit> getOnShippingMethodSelectedCallback$payments_core_release() {
        return this.onShippingMethodSelectedCallback;
    }

    public final void setOnShippingMethodSelectedCallback$payments_core_release(Function1<? super ShippingMethod, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onShippingMethodSelectedCallback = function1;
    }

    public final List<ShippingMethod> getShippingMethods$payments_core_release() {
        return this.shippingMethods;
    }

    public final void setShippingMethods$payments_core_release(List<ShippingMethod> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        setSelectedIndex$payments_core_release(0);
        this.shippingMethods = list;
        notifyDataSetChanged();
    }

    public final int getSelectedIndex$payments_core_release() {
        return this.selectedIndex;
    }

    public final void setSelectedIndex$payments_core_release(int i) {
        int i2 = this.selectedIndex;
        if (i2 != i) {
            notifyItemChanged(i2);
            notifyItemChanged(i);
            this.selectedIndex = i;
            this.onShippingMethodSelectedCallback.invoke(this.shippingMethods.get(i));
        }
    }

    public final ShippingMethod getSelectedShippingMethod() {
        return (ShippingMethod) CollectionsKt.getOrNull(this.shippingMethods, this.selectedIndex);
    }

    public int getItemCount() {
        return this.shippingMethods.size();
    }

    public long getItemId(int i) {
        return (long) this.shippingMethods.get(i).hashCode();
    }

    public ShippingMethodViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewGroup.context");
        return new ShippingMethodViewHolder(new ShippingMethodView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null));
    }

    public void onBindViewHolder(ShippingMethodViewHolder shippingMethodViewHolder, int i) {
        Intrinsics.checkNotNullParameter(shippingMethodViewHolder, "holder");
        shippingMethodViewHolder.setShippingMethod(this.shippingMethods.get(i));
        shippingMethodViewHolder.setSelected(i == this.selectedIndex);
        shippingMethodViewHolder.getShippingMethodView$payments_core_release().setOnClickListener(new View.OnClickListener(shippingMethodViewHolder) {
            public final /* synthetic */ ShippingMethodAdapter.ShippingMethodViewHolder f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                ShippingMethodAdapter.m4687onBindViewHolder$lambda0(ShippingMethodAdapter.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m4687onBindViewHolder$lambda0(ShippingMethodAdapter shippingMethodAdapter, ShippingMethodViewHolder shippingMethodViewHolder, View view) {
        Intrinsics.checkNotNullParameter(shippingMethodAdapter, "this$0");
        Intrinsics.checkNotNullParameter(shippingMethodViewHolder, "$holder");
        shippingMethodAdapter.setSelectedIndex$payments_core_release(shippingMethodViewHolder.getBindingAdapterPosition());
    }

    public final void setSelected$payments_core_release(ShippingMethod shippingMethod) {
        Intrinsics.checkNotNullParameter(shippingMethod, "shippingMethod");
        setSelectedIndex$payments_core_release(this.shippingMethods.indexOf(shippingMethod));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/ShippingMethodAdapter$ShippingMethodViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "shippingMethodView", "Lcom/stripe/android/view/ShippingMethodView;", "(Lcom/stripe/android/view/ShippingMethodView;)V", "getShippingMethodView$payments_core_release", "()Lcom/stripe/android/view/ShippingMethodView;", "setSelected", "", "selected", "", "setShippingMethod", "shippingMethod", "Lcom/stripe/android/model/ShippingMethod;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShippingMethodAdapter.kt */
    public static final class ShippingMethodViewHolder extends RecyclerView.ViewHolder {
        private final ShippingMethodView shippingMethodView;

        public final ShippingMethodView getShippingMethodView$payments_core_release() {
            return this.shippingMethodView;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShippingMethodViewHolder(ShippingMethodView shippingMethodView2) {
            super(shippingMethodView2);
            Intrinsics.checkNotNullParameter(shippingMethodView2, "shippingMethodView");
            this.shippingMethodView = shippingMethodView2;
        }

        public final void setShippingMethod(ShippingMethod shippingMethod) {
            Intrinsics.checkNotNullParameter(shippingMethod, "shippingMethod");
            this.shippingMethodView.setShippingMethod(shippingMethod);
        }

        public final void setSelected(boolean z) {
            this.shippingMethodView.setSelected(z);
        }
    }
}
