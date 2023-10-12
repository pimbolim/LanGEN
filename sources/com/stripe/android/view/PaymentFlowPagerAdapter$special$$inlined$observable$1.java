package com.stripe.android.view;

import com.stripe.android.model.ShippingMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Delegates.kt */
public final class PaymentFlowPagerAdapter$special$$inlined$observable$1 extends ObservableProperty<List<? extends ShippingMethod>> {
    final /* synthetic */ Object $initialValue;
    final /* synthetic */ PaymentFlowPagerAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentFlowPagerAdapter$special$$inlined$observable$1(Object obj, PaymentFlowPagerAdapter paymentFlowPagerAdapter) {
        super(obj);
        this.$initialValue = obj;
        this.this$0 = paymentFlowPagerAdapter;
    }

    /* access modifiers changed from: protected */
    public void afterChange(KProperty<?> kProperty, List<? extends ShippingMethod> list, List<? extends ShippingMethod> list2) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        this.this$0.shouldRecreateShippingMethodsScreen = !Intrinsics.areEqual((Object) list2, (Object) list);
    }
}
