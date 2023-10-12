package com.stripe.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stripe.android.databinding.ShippingMethodWidgetBinding;
import com.stripe.android.model.ShippingMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\u001a\u0010\u0012\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u0014J\u0014\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/view/SelectShippingMethodWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedShippingMethod", "Lcom/stripe/android/model/ShippingMethod;", "getSelectedShippingMethod", "()Lcom/stripe/android/model/ShippingMethod;", "shippingMethodAdapter", "Lcom/stripe/android/view/ShippingMethodAdapter;", "setSelectedShippingMethod", "", "shippingMethod", "setShippingMethodSelectedCallback", "callback", "Lkotlin/Function1;", "setShippingMethods", "shippingMethods", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectShippingMethodWidget.kt */
public final class SelectShippingMethodWidget extends FrameLayout {
    private final ShippingMethodAdapter shippingMethodAdapter;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SelectShippingMethodWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SelectShippingMethodWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectShippingMethodWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectShippingMethodWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        ShippingMethodAdapter shippingMethodAdapter2 = new ShippingMethodAdapter();
        this.shippingMethodAdapter = shippingMethodAdapter2;
        ShippingMethodWidgetBinding inflate = ShippingMethodWidgetBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           this\n        )");
        RecyclerView recyclerView = inflate.shippingMethods;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(shippingMethodAdapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public final ShippingMethod getSelectedShippingMethod() {
        return this.shippingMethodAdapter.getSelectedShippingMethod();
    }

    public final void setShippingMethodSelectedCallback(Function1<? super ShippingMethod, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.shippingMethodAdapter.setOnShippingMethodSelectedCallback$payments_core_release(function1);
    }

    public final void setShippingMethods(List<ShippingMethod> list) {
        Intrinsics.checkNotNullParameter(list, "shippingMethods");
        this.shippingMethodAdapter.setShippingMethods$payments_core_release(list);
    }

    public final void setSelectedShippingMethod(ShippingMethod shippingMethod) {
        Intrinsics.checkNotNullParameter(shippingMethod, "shippingMethod");
        this.shippingMethodAdapter.setSelected$payments_core_release(shippingMethod);
    }
}
