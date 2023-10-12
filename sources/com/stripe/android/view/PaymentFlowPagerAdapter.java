package com.stripe.android.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.stripe.android.PaymentSessionConfig;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.ShippingMethod;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001@B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\u0010\rJ \u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000202H\u0016J\u0010\u00106\u001a\u0002022\u0006\u00107\u001a\u000204H\u0016J\u0017\u00108\u001a\u0004\u0018\u00010\u00172\u0006\u00101\u001a\u000202H\u0000¢\u0006\u0002\b9J\u0012\u0010:\u001a\u0004\u0018\u00010;2\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010<\u001a\u0002042\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0018\u0010=\u001a\u00020\u000f2\u0006\u00103\u001a\u00020>2\u0006\u0010?\u001a\u000204H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R/\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b8@@@X\u0002¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\"@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R7\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00168@@@X\u0002¢\u0006\u0012\n\u0004\b,\u0010!\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010+R\u000e\u0010-\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/stripe/android/view/PaymentFlowPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "paymentSessionConfig", "Lcom/stripe/android/PaymentSessionConfig;", "allowedShippingCountryCodes", "", "", "onShippingMethodSelectedCallback", "Lkotlin/Function1;", "Lcom/stripe/android/model/ShippingMethod;", "", "(Landroid/content/Context;Lcom/stripe/android/PaymentSessionConfig;Ljava/util/Set;Lkotlin/jvm/functions/Function1;)V", "value", "", "isShippingInfoSubmitted", "isShippingInfoSubmitted$payments_core_release", "()Z", "setShippingInfoSubmitted$payments_core_release", "(Z)V", "pages", "", "Lcom/stripe/android/view/PaymentFlowPage;", "getPages", "()Ljava/util/List;", "<set-?>", "selectedShippingMethod", "getSelectedShippingMethod$payments_core_release", "()Lcom/stripe/android/model/ShippingMethod;", "setSelectedShippingMethod$payments_core_release", "(Lcom/stripe/android/model/ShippingMethod;)V", "selectedShippingMethod$delegate", "Lkotlin/properties/ReadWriteProperty;", "Lcom/stripe/android/model/ShippingInformation;", "shippingInformation", "getShippingInformation$payments_core_release", "()Lcom/stripe/android/model/ShippingInformation;", "setShippingInformation$payments_core_release", "(Lcom/stripe/android/model/ShippingInformation;)V", "shippingMethods", "getShippingMethods$payments_core_release", "setShippingMethods$payments_core_release", "(Ljava/util/List;)V", "shippingMethods$delegate", "shouldRecreateShippingMethodsScreen", "destroyItem", "collection", "Landroid/view/ViewGroup;", "position", "", "view", "", "getCount", "getItemPosition", "obj", "getPageAt", "getPageAt$payments_core_release", "getPageTitle", "", "instantiateItem", "isViewFromObject", "Landroid/view/View;", "o", "PaymentFlowViewHolder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowPagerAdapter.kt */
public final class PaymentFlowPagerAdapter extends PagerAdapter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final Set<String> allowedShippingCountryCodes;
    private final Context context;
    private boolean isShippingInfoSubmitted;
    private final Function1<ShippingMethod, Unit> onShippingMethodSelectedCallback;
    private final PaymentSessionConfig paymentSessionConfig;
    private final ReadWriteProperty selectedShippingMethod$delegate;
    private ShippingInformation shippingInformation;
    private final ReadWriteProperty shippingMethods$delegate;
    /* access modifiers changed from: private */
    public boolean shouldRecreateShippingMethodsScreen;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentFlowPagerAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentFlowPage.values().length];
            iArr[PaymentFlowPage.ShippingInfo.ordinal()] = 1;
            iArr[PaymentFlowPage.ShippingMethod.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "o");
        return view == obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentFlowPagerAdapter(Context context2, PaymentSessionConfig paymentSessionConfig2, Set set, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, paymentSessionConfig2, (i & 4) != 0 ? SetsKt.emptySet() : set, (i & 8) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    public PaymentFlowPagerAdapter(Context context2, PaymentSessionConfig paymentSessionConfig2, Set<String> set, Function1<? super ShippingMethod, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(paymentSessionConfig2, "paymentSessionConfig");
        Intrinsics.checkNotNullParameter(set, "allowedShippingCountryCodes");
        Intrinsics.checkNotNullParameter(function1, "onShippingMethodSelectedCallback");
        this.context = context2;
        this.paymentSessionConfig = paymentSessionConfig2;
        this.allowedShippingCountryCodes = set;
        this.onShippingMethodSelectedCallback = function1;
        Delegates delegates = Delegates.INSTANCE;
        this.shippingMethods$delegate = new PaymentFlowPagerAdapter$special$$inlined$observable$1(CollectionsKt.emptyList(), this);
        Delegates delegates2 = Delegates.INSTANCE;
        this.selectedShippingMethod$delegate = new PaymentFlowPagerAdapter$special$$inlined$observable$2((Object) null, this);
    }

    private final List<PaymentFlowPage> getPages() {
        PaymentFlowPage[] paymentFlowPageArr = new PaymentFlowPage[2];
        PaymentFlowPage paymentFlowPage = PaymentFlowPage.ShippingInfo;
        PaymentFlowPage paymentFlowPage2 = null;
        if (!this.paymentSessionConfig.isShippingInfoRequired()) {
            paymentFlowPage = null;
        }
        boolean z = false;
        paymentFlowPageArr[0] = paymentFlowPage;
        PaymentFlowPage paymentFlowPage3 = PaymentFlowPage.ShippingMethod;
        if (this.paymentSessionConfig.isShippingMethodRequired() && (!this.paymentSessionConfig.isShippingInfoRequired() || isShippingInfoSubmitted$payments_core_release())) {
            z = true;
        }
        if (z) {
            paymentFlowPage2 = paymentFlowPage3;
        }
        paymentFlowPageArr[1] = paymentFlowPage2;
        return CollectionsKt.listOfNotNull((T[]) paymentFlowPageArr);
    }

    public final ShippingInformation getShippingInformation$payments_core_release() {
        return this.shippingInformation;
    }

    public final void setShippingInformation$payments_core_release(ShippingInformation shippingInformation2) {
        this.shippingInformation = shippingInformation2;
        notifyDataSetChanged();
    }

    public final boolean isShippingInfoSubmitted$payments_core_release() {
        return this.isShippingInfoSubmitted;
    }

    public final void setShippingInfoSubmitted$payments_core_release(boolean z) {
        this.isShippingInfoSubmitted = z;
        notifyDataSetChanged();
    }

    static {
        Class<PaymentFlowPagerAdapter> cls = PaymentFlowPagerAdapter.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "shippingMethods", "getShippingMethods$payments_core_release()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "selectedShippingMethod", "getSelectedShippingMethod$payments_core_release()Lcom/stripe/android/model/ShippingMethod;", 0))};
    }

    public final List<ShippingMethod> getShippingMethods$payments_core_release() {
        return (List) this.shippingMethods$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setShippingMethods$payments_core_release(List<ShippingMethod> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.shippingMethods$delegate.setValue(this, $$delegatedProperties[0], list);
    }

    public final ShippingMethod getSelectedShippingMethod$payments_core_release() {
        return (ShippingMethod) this.selectedShippingMethod$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setSelectedShippingMethod$payments_core_release(ShippingMethod shippingMethod) {
        this.selectedShippingMethod$delegate.setValue(this, $$delegatedProperties[1], shippingMethod);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        PaymentFlowViewHolder paymentFlowViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "collection");
        PaymentFlowPage paymentFlowPage = getPages().get(i);
        int i2 = WhenMappings.$EnumSwitchMapping$0[paymentFlowPage.ordinal()];
        if (i2 == 1) {
            paymentFlowViewHolder = new PaymentFlowViewHolder.ShippingInformationViewHolder(viewGroup);
        } else if (i2 == 2) {
            paymentFlowViewHolder = new PaymentFlowViewHolder.ShippingMethodViewHolder(viewGroup);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (paymentFlowViewHolder instanceof PaymentFlowViewHolder.ShippingInformationViewHolder) {
            ((PaymentFlowViewHolder.ShippingInformationViewHolder) paymentFlowViewHolder).bind(this.paymentSessionConfig, this.shippingInformation, this.allowedShippingCountryCodes);
        } else if (paymentFlowViewHolder instanceof PaymentFlowViewHolder.ShippingMethodViewHolder) {
            ((PaymentFlowViewHolder.ShippingMethodViewHolder) paymentFlowViewHolder).bind(getShippingMethods$payments_core_release(), getSelectedShippingMethod$payments_core_release(), this.onShippingMethodSelectedCallback);
        }
        viewGroup.addView(paymentFlowViewHolder.itemView);
        paymentFlowViewHolder.itemView.setTag(paymentFlowPage);
        View view = paymentFlowViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        return view;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "collection");
        Intrinsics.checkNotNullParameter(obj, "view");
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return getPages().size();
    }

    public final PaymentFlowPage getPageAt$payments_core_release(int i) {
        return (PaymentFlowPage) CollectionsKt.getOrNull(getPages(), i);
    }

    public CharSequence getPageTitle(int i) {
        return this.context.getString(getPages().get(i).getTitleResId());
    }

    public int getItemPosition(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (!(obj instanceof View) || ((View) obj).getTag() != PaymentFlowPage.ShippingMethod || !this.shouldRecreateShippingMethodsScreen) {
            return super.getItemPosition(obj);
        }
        this.shouldRecreateShippingMethodsScreen = false;
        return -2;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/PaymentFlowPagerAdapter$PaymentFlowViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ShippingInformationViewHolder", "ShippingMethodViewHolder", "Lcom/stripe/android/view/PaymentFlowPagerAdapter$PaymentFlowViewHolder$ShippingInformationViewHolder;", "Lcom/stripe/android/view/PaymentFlowPagerAdapter$PaymentFlowViewHolder$ShippingMethodViewHolder;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentFlowPagerAdapter.kt */
    public static abstract class PaymentFlowViewHolder extends RecyclerView.ViewHolder {
        public /* synthetic */ PaymentFlowViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
            this(view);
        }

        private PaymentFlowViewHolder(View view) {
            super(view);
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/view/PaymentFlowPagerAdapter$PaymentFlowViewHolder$ShippingInformationViewHolder;", "Lcom/stripe/android/view/PaymentFlowPagerAdapter$PaymentFlowViewHolder;", "root", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "viewBinding", "Lcom/stripe/android/databinding/ShippingInfoPageBinding;", "(Lcom/stripe/android/databinding/ShippingInfoPageBinding;)V", "shippingInfoWidget", "Lcom/stripe/android/view/ShippingInfoWidget;", "bind", "", "paymentSessionConfig", "Lcom/stripe/android/PaymentSessionConfig;", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "allowedShippingCountryCodes", "", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentFlowPagerAdapter.kt */
        public static final class ShippingInformationViewHolder extends PaymentFlowViewHolder {
            public static final int $stable = 8;
            private final ShippingInfoWidget shippingInfoWidget;

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public ShippingInformationViewHolder(com.stripe.android.databinding.ShippingInfoPageBinding r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = "viewBinding"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    android.widget.ScrollView r0 = r3.getRoot()
                    java.lang.String r1 = "viewBinding.root"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                    android.view.View r0 = (android.view.View) r0
                    r1 = 0
                    r2.<init>(r0, r1)
                    com.stripe.android.view.ShippingInfoWidget r3 = r3.shippingInfoWidget
                    java.lang.String r0 = "viewBinding.shippingInfoWidget"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                    r2.shippingInfoWidget = r3
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentFlowPagerAdapter.PaymentFlowViewHolder.ShippingInformationViewHolder.<init>(com.stripe.android.databinding.ShippingInfoPageBinding):void");
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public ShippingInformationViewHolder(android.view.ViewGroup r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = "root"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    android.content.Context r0 = r3.getContext()
                    android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
                    r1 = 0
                    com.stripe.android.databinding.ShippingInfoPageBinding r3 = com.stripe.android.databinding.ShippingInfoPageBinding.inflate(r0, r3, r1)
                    java.lang.String r0 = "inflate(\n               …  false\n                )"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                    r2.<init>((com.stripe.android.databinding.ShippingInfoPageBinding) r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentFlowPagerAdapter.PaymentFlowViewHolder.ShippingInformationViewHolder.<init>(android.view.ViewGroup):void");
            }

            public final void bind(PaymentSessionConfig paymentSessionConfig, ShippingInformation shippingInformation, Set<String> set) {
                Intrinsics.checkNotNullParameter(paymentSessionConfig, "paymentSessionConfig");
                Intrinsics.checkNotNullParameter(set, "allowedShippingCountryCodes");
                this.shippingInfoWidget.setHiddenFields(paymentSessionConfig.getHiddenShippingInfoFields());
                this.shippingInfoWidget.setOptionalFields(paymentSessionConfig.getOptionalShippingInfoFields());
                this.shippingInfoWidget.setAllowedCountryCodes(set);
                this.shippingInfoWidget.populateShippingInfo(shippingInformation);
            }
        }

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J2\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\u0011R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/view/PaymentFlowPagerAdapter$PaymentFlowViewHolder$ShippingMethodViewHolder;", "Lcom/stripe/android/view/PaymentFlowPagerAdapter$PaymentFlowViewHolder;", "root", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "viewBinding", "Lcom/stripe/android/databinding/ShippingMethodPageBinding;", "(Lcom/stripe/android/databinding/ShippingMethodPageBinding;)V", "shippingMethodWidget", "Lcom/stripe/android/view/SelectShippingMethodWidget;", "bind", "", "shippingMethods", "", "Lcom/stripe/android/model/ShippingMethod;", "selectedShippingMethod", "onShippingMethodSelectedCallback", "Lkotlin/Function1;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentFlowPagerAdapter.kt */
        public static final class ShippingMethodViewHolder extends PaymentFlowViewHolder {
            public static final int $stable = 8;
            private final SelectShippingMethodWidget shippingMethodWidget;

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public ShippingMethodViewHolder(com.stripe.android.databinding.ShippingMethodPageBinding r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = "viewBinding"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    android.widget.FrameLayout r0 = r3.getRoot()
                    java.lang.String r1 = "viewBinding.root"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                    android.view.View r0 = (android.view.View) r0
                    r1 = 0
                    r2.<init>(r0, r1)
                    com.stripe.android.view.SelectShippingMethodWidget r3 = r3.selectShippingMethodWidget
                    java.lang.String r0 = "viewBinding.selectShippingMethodWidget"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                    r2.shippingMethodWidget = r3
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentFlowPagerAdapter.PaymentFlowViewHolder.ShippingMethodViewHolder.<init>(com.stripe.android.databinding.ShippingMethodPageBinding):void");
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public ShippingMethodViewHolder(android.view.ViewGroup r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = "root"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    android.content.Context r0 = r3.getContext()
                    android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
                    r1 = 0
                    com.stripe.android.databinding.ShippingMethodPageBinding r3 = com.stripe.android.databinding.ShippingMethodPageBinding.inflate(r0, r3, r1)
                    java.lang.String r0 = "inflate(\n               …  false\n                )"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                    r2.<init>((com.stripe.android.databinding.ShippingMethodPageBinding) r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentFlowPagerAdapter.PaymentFlowViewHolder.ShippingMethodViewHolder.<init>(android.view.ViewGroup):void");
            }

            public final void bind(List<ShippingMethod> list, ShippingMethod shippingMethod, Function1<? super ShippingMethod, Unit> function1) {
                Intrinsics.checkNotNullParameter(list, "shippingMethods");
                Intrinsics.checkNotNullParameter(function1, "onShippingMethodSelectedCallback");
                this.shippingMethodWidget.setShippingMethods(list);
                this.shippingMethodWidget.setShippingMethodSelectedCallback(function1);
                if (shippingMethod != null) {
                    this.shippingMethodWidget.setSelectedShippingMethod(shippingMethod);
                }
            }
        }
    }
}
