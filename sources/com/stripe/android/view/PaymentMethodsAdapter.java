package com.stripe.android.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.widget.ImageViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.stripe.android.R;
import com.stripe.android.databinding.AddPaymentMethodRowBinding;
import com.stripe.android.databinding.GooglePayRowBinding;
import com.stripe.android.databinding.MaskedCardRowBinding;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.view.AddPaymentMethodActivityStarter;
import com.stripe.android.view.PaymentMethodsActivityStarter;
import com.stripe.android.view.PaymentMethodsAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0019\b\u0000\u0018\u0000 W2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004WXYZBG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u0002052\u0006\u00102\u001a\u000203H\u0002J\u0010\u00106\u001a\u0002072\u0006\u00102\u001a\u000203H\u0002J\u0010\u00108\u001a\u0002092\u0006\u00102\u001a\u000203H\u0002J\u0015\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020%H\u0000¢\u0006\u0002\b=J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u001cH\u0002J\b\u0010@\u001a\u00020\u001cH\u0016J\u0010\u0010A\u001a\u00020B2\u0006\u0010?\u001a\u00020\u001cH\u0016J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u001cH\u0016J\u0015\u0010D\u001a\u00020%2\u0006\u0010?\u001a\u00020\u001cH\u0000¢\u0006\u0002\bEJ\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u001cH\u0002J\u0019\u0010G\u001a\u0004\u0018\u00010\u001c2\u0006\u0010<\u001a\u00020%H\u0000¢\u0006\u0004\bH\u0010IJ\u0010\u0010J\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u001cH\u0002J\u0010\u0010K\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u001cH\u0002J\u0018\u0010L\u001a\u00020;2\u0006\u0010M\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u001cH\u0016J\u0018\u0010N\u001a\u00020\u00022\u0006\u00102\u001a\u0002032\u0006\u0010O\u001a\u00020\u001cH\u0016J\u0015\u0010P\u001a\u00020;2\u0006\u0010?\u001a\u00020\u001cH\u0000¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020;2\u0006\u0010<\u001a\u00020%H\u0000¢\u0006\u0002\bSJ\u001b\u0010T\u001a\u00020;2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0\u0006H\u0000¢\u0006\u0002\bUJ\u0010\u0010V\u001a\u00020;2\u0006\u0010?\u001a\u00020\u001cH\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\u0004\u0018\u00010%8@X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/stripe/android/view/PaymentMethodsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "intentArgs", "Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args;", "addableTypes", "", "Lcom/stripe/android/model/PaymentMethod$Type;", "initiallySelectedPaymentMethodId", "", "shouldShowGooglePay", "", "useGooglePay", "canDeletePaymentMethods", "(Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args;Ljava/util/List;Ljava/lang/String;ZZZ)V", "_addPaymentMethodArgs", "Landroidx/lifecycle/MutableLiveData;", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "addCardArgs", "getAddCardArgs$payments_core_release", "()Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "addFpxArgs", "getAddFpxArgs$payments_core_release", "addPaymentMethodArgs", "Landroidx/lifecycle/LiveData;", "getAddPaymentMethodArgs", "()Landroidx/lifecycle/LiveData;", "googlePayCount", "", "listener", "Lcom/stripe/android/view/PaymentMethodsAdapter$Listener;", "getListener$payments_core_release", "()Lcom/stripe/android/view/PaymentMethodsAdapter$Listener;", "setListener$payments_core_release", "(Lcom/stripe/android/view/PaymentMethodsAdapter$Listener;)V", "paymentMethods", "", "Lcom/stripe/android/model/PaymentMethod;", "getPaymentMethods$payments_core_release", "()Ljava/util/List;", "selectedPaymentMethod", "getSelectedPaymentMethod$payments_core_release", "()Lcom/stripe/android/model/PaymentMethod;", "selectedPaymentMethodId", "getSelectedPaymentMethodId$payments_core_release", "()Ljava/lang/String;", "setSelectedPaymentMethodId$payments_core_release", "(Ljava/lang/String;)V", "createAddCardPaymentMethodViewHolder", "Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder$AddCardPaymentMethodViewHolder;", "parent", "Landroid/view/ViewGroup;", "createAddFpxPaymentMethodViewHolder", "Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder$AddFpxPaymentMethodViewHolder;", "createGooglePayViewHolder", "Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder$GooglePayViewHolder;", "createPaymentMethodViewHolder", "Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder$PaymentMethodViewHolder;", "deletePaymentMethod", "", "paymentMethod", "deletePaymentMethod$payments_core_release", "getAddableTypesPosition", "position", "getItemCount", "getItemId", "", "getItemViewType", "getPaymentMethodAtPosition", "getPaymentMethodAtPosition$payments_core_release", "getPaymentMethodIndex", "getPosition", "getPosition$payments_core_release", "(Lcom/stripe/android/model/PaymentMethod;)Ljava/lang/Integer;", "isGooglePayPosition", "isPaymentMethodsPosition", "onBindViewHolder", "holder", "onCreateViewHolder", "viewType", "onPositionClicked", "onPositionClicked$payments_core_release", "resetPaymentMethod", "resetPaymentMethod$payments_core_release", "setPaymentMethods", "setPaymentMethods$payments_core_release", "updateSelectedPaymentMethod", "Companion", "Listener", "ViewHolder", "ViewType", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsAdapter.kt */
public final class PaymentMethodsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long GOOGLE_PAY_ITEM_ID = ((long) -2057760476);
    private final MutableLiveData<AddPaymentMethodActivityStarter.Args> _addPaymentMethodArgs;
    private final AddPaymentMethodActivityStarter.Args addCardArgs;
    private final AddPaymentMethodActivityStarter.Args addFpxArgs;
    private final LiveData<AddPaymentMethodActivityStarter.Args> addPaymentMethodArgs;
    private final List<PaymentMethod.Type> addableTypes;
    private final boolean canDeletePaymentMethods;
    private final int googlePayCount;
    private Listener listener;
    private final List<PaymentMethod> paymentMethods;
    private String selectedPaymentMethodId;
    private final boolean shouldShowGooglePay;
    private final boolean useGooglePay;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsAdapter$Listener;", "", "onDeletePaymentMethodAction", "", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "onGooglePayClick", "onPaymentMethodClick", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsAdapter.kt */
    public interface Listener {
        void onDeletePaymentMethodAction(PaymentMethod paymentMethod);

        void onGooglePayClick();

        void onPaymentMethodClick(PaymentMethod paymentMethod);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsAdapter$ViewType;", "", "(Ljava/lang/String;I)V", "Card", "AddCard", "AddFpx", "GooglePay", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsAdapter.kt */
    public enum ViewType {
        Card,
        AddCard,
        AddFpx,
        GooglePay
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaymentMethod.Type.values().length];
            iArr[PaymentMethod.Type.Card.ordinal()] = 1;
            iArr[PaymentMethod.Type.Fpx.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ViewType.values().length];
            iArr2[ViewType.Card.ordinal()] = 1;
            iArr2[ViewType.AddCard.ordinal()] = 2;
            iArr2[ViewType.AddFpx.ordinal()] = 3;
            iArr2[ViewType.GooglePay.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentMethodsAdapter(PaymentMethodsActivityStarter.Args args, List list, String str, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(args, (i & 2) != 0 ? CollectionsKt.listOf(PaymentMethod.Type.Card) : list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? true : z3);
    }

    public PaymentMethodsAdapter(PaymentMethodsActivityStarter.Args args, List<? extends PaymentMethod.Type> list, String str, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(args, "intentArgs");
        Intrinsics.checkNotNullParameter(list, "addableTypes");
        this.addableTypes = list;
        this.shouldShowGooglePay = z;
        this.useGooglePay = z2;
        this.canDeletePaymentMethods = z3;
        this.paymentMethods = new ArrayList();
        this.selectedPaymentMethodId = str;
        Integer num = 1;
        num.intValue();
        num = !z ? null : num;
        this.googlePayCount = num == null ? 0 : num.intValue();
        MutableLiveData<AddPaymentMethodActivityStarter.Args> mutableLiveData = new MutableLiveData<>();
        this._addPaymentMethodArgs = mutableLiveData;
        this.addPaymentMethodArgs = mutableLiveData;
        this.addCardArgs = new AddPaymentMethodActivityStarter.Args.Builder().setBillingAddressFields(args.getBillingAddressFields$payments_core_release()).setShouldAttachToCustomer(true).setIsPaymentSessionActive$payments_core_release(args.isPaymentSessionActive$payments_core_release()).setPaymentMethodType(PaymentMethod.Type.Card).setAddPaymentMethodFooter(args.getAddPaymentMethodFooterLayoutId()).setPaymentConfiguration(args.getPaymentConfiguration$payments_core_release()).setWindowFlags(args.getWindowFlags$payments_core_release()).build();
        this.addFpxArgs = new AddPaymentMethodActivityStarter.Args.Builder().setIsPaymentSessionActive$payments_core_release(args.isPaymentSessionActive$payments_core_release()).setPaymentMethodType(PaymentMethod.Type.Fpx).setPaymentConfiguration(args.getPaymentConfiguration$payments_core_release()).build();
        setHasStableIds(true);
    }

    public final List<PaymentMethod> getPaymentMethods$payments_core_release() {
        return this.paymentMethods;
    }

    public final String getSelectedPaymentMethodId$payments_core_release() {
        return this.selectedPaymentMethodId;
    }

    public final void setSelectedPaymentMethodId$payments_core_release(String str) {
        this.selectedPaymentMethodId = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.stripe.android.model.PaymentMethod} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.stripe.android.model.PaymentMethod} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.stripe.android.model.PaymentMethod} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.stripe.android.model.PaymentMethod} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.stripe.android.model.PaymentMethod getSelectedPaymentMethod$payments_core_release() {
        /*
            r5 = this;
            java.lang.String r0 = r5.selectedPaymentMethodId
            r1 = 0
            if (r0 != 0) goto L_0x0006
            goto L_0x0028
        L_0x0006:
            java.util.List r2 = r5.getPaymentMethods$payments_core_release()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0010:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0026
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.stripe.android.model.PaymentMethod r4 = (com.stripe.android.model.PaymentMethod) r4
            java.lang.String r4 = r4.id
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            if (r4 == 0) goto L_0x0010
            r1 = r3
        L_0x0026:
            com.stripe.android.model.PaymentMethod r1 = (com.stripe.android.model.PaymentMethod) r1
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentMethodsAdapter.getSelectedPaymentMethod$payments_core_release():com.stripe.android.model.PaymentMethod");
    }

    public final Listener getListener$payments_core_release() {
        return this.listener;
    }

    public final void setListener$payments_core_release(Listener listener2) {
        this.listener = listener2;
    }

    public final LiveData<AddPaymentMethodActivityStarter.Args> getAddPaymentMethodArgs() {
        return this.addPaymentMethodArgs;
    }

    public final AddPaymentMethodActivityStarter.Args getAddCardArgs$payments_core_release() {
        return this.addCardArgs;
    }

    public final AddPaymentMethodActivityStarter.Args getAddFpxArgs$payments_core_release() {
        return this.addFpxArgs;
    }

    public final /* synthetic */ void setPaymentMethods$payments_core_release(List list) {
        Intrinsics.checkNotNullParameter(list, "paymentMethods");
        this.paymentMethods.clear();
        this.paymentMethods.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.paymentMethods.size() + this.addableTypes.size() + this.googlePayCount;
    }

    public int getItemViewType(int i) {
        if (isGooglePayPosition(i)) {
            return ViewType.GooglePay.ordinal();
        }
        if (isPaymentMethodsPosition(i)) {
            if (PaymentMethod.Type.Card == getPaymentMethodAtPosition$payments_core_release(i).type) {
                return ViewType.Card.ordinal();
            }
            return super.getItemViewType(i);
        }
        PaymentMethod.Type type = this.addableTypes.get(getAddableTypesPosition(i));
        int i2 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i2 == 1) {
            return ViewType.AddCard.ordinal();
        }
        if (i2 == 2) {
            return ViewType.AddFpx.ordinal();
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported PaymentMethod type: ", type.code));
    }

    private final boolean isGooglePayPosition(int i) {
        return this.shouldShowGooglePay && i == 0;
    }

    private final boolean isPaymentMethodsPosition(int i) {
        IntRange intRange;
        if (this.shouldShowGooglePay) {
            intRange = new IntRange(1, this.paymentMethods.size());
        } else {
            intRange = RangesKt.until(0, this.paymentMethods.size());
        }
        int first = intRange.getFirst();
        if (i > intRange.getLast() || first > i) {
            return false;
        }
        return true;
    }

    public long getItemId(int i) {
        int i2;
        if (isGooglePayPosition(i)) {
            return GOOGLE_PAY_ITEM_ID;
        }
        if (isPaymentMethodsPosition(i)) {
            i2 = getPaymentMethodAtPosition$payments_core_release(i).hashCode();
        } else {
            i2 = this.addableTypes.get(getAddableTypesPosition(i)).code.hashCode();
        }
        return (long) i2;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof ViewHolder.PaymentMethodViewHolder) {
            PaymentMethod paymentMethodAtPosition$payments_core_release = getPaymentMethodAtPosition$payments_core_release(i);
            ViewHolder.PaymentMethodViewHolder paymentMethodViewHolder = (ViewHolder.PaymentMethodViewHolder) viewHolder;
            paymentMethodViewHolder.setPaymentMethod(paymentMethodAtPosition$payments_core_release);
            paymentMethodViewHolder.setSelected(Intrinsics.areEqual((Object) paymentMethodAtPosition$payments_core_release.id, (Object) this.selectedPaymentMethodId));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(viewHolder) {
                public final /* synthetic */ RecyclerView.ViewHolder f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PaymentMethodsAdapter.m4683onBindViewHolder$lambda3(PaymentMethodsAdapter.this, this.f$1, view);
                }
            });
        } else if (viewHolder instanceof ViewHolder.GooglePayViewHolder) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PaymentMethodsAdapter.m4684onBindViewHolder$lambda4(PaymentMethodsAdapter.this, view);
                }
            });
            ((ViewHolder.GooglePayViewHolder) viewHolder).bind(this.useGooglePay);
        } else if (viewHolder instanceof ViewHolder.AddCardPaymentMethodViewHolder) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PaymentMethodsAdapter.m4685onBindViewHolder$lambda5(PaymentMethodsAdapter.this, view);
                }
            });
        } else if (viewHolder instanceof ViewHolder.AddFpxPaymentMethodViewHolder) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PaymentMethodsAdapter.m4686onBindViewHolder$lambda6(PaymentMethodsAdapter.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-3  reason: not valid java name */
    public static final void m4683onBindViewHolder$lambda3(PaymentMethodsAdapter paymentMethodsAdapter, RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(paymentMethodsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(viewHolder, "$holder");
        paymentMethodsAdapter.onPositionClicked$payments_core_release(((ViewHolder.PaymentMethodViewHolder) viewHolder).getBindingAdapterPosition());
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-4  reason: not valid java name */
    public static final void m4684onBindViewHolder$lambda4(PaymentMethodsAdapter paymentMethodsAdapter, View view) {
        Intrinsics.checkNotNullParameter(paymentMethodsAdapter, "this$0");
        paymentMethodsAdapter.selectedPaymentMethodId = null;
        Listener listener2 = paymentMethodsAdapter.listener;
        if (listener2 != null) {
            listener2.onGooglePayClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-5  reason: not valid java name */
    public static final void m4685onBindViewHolder$lambda5(PaymentMethodsAdapter paymentMethodsAdapter, View view) {
        Intrinsics.checkNotNullParameter(paymentMethodsAdapter, "this$0");
        paymentMethodsAdapter._addPaymentMethodArgs.setValue(paymentMethodsAdapter.addCardArgs);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-6  reason: not valid java name */
    public static final void m4686onBindViewHolder$lambda6(PaymentMethodsAdapter paymentMethodsAdapter, View view) {
        Intrinsics.checkNotNullParameter(paymentMethodsAdapter, "this$0");
        paymentMethodsAdapter._addPaymentMethodArgs.setValue(paymentMethodsAdapter.addFpxArgs);
    }

    public final /* synthetic */ void onPositionClicked$payments_core_release(int i) {
        updateSelectedPaymentMethod(i);
        Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onPaymentMethodClick(getPaymentMethodAtPosition$payments_core_release(i));
        }
    }

    private final void updateSelectedPaymentMethod(int i) {
        Iterator<PaymentMethod> it = this.paymentMethods.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (Intrinsics.areEqual((Object) it.next().id, (Object) getSelectedPaymentMethodId$payments_core_release())) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != i) {
            notifyItemChanged(i2);
            PaymentMethod paymentMethod = (PaymentMethod) CollectionsKt.getOrNull(this.paymentMethods, i);
            this.selectedPaymentMethodId = paymentMethod == null ? null : paymentMethod.id;
        }
        notifyItemChanged(i);
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        int i2 = WhenMappings.$EnumSwitchMapping$1[ViewType.values()[i].ordinal()];
        if (i2 == 1) {
            return createPaymentMethodViewHolder(viewGroup);
        }
        if (i2 == 2) {
            return createAddCardPaymentMethodViewHolder(viewGroup);
        }
        if (i2 == 3) {
            return createAddFpxPaymentMethodViewHolder(viewGroup);
        }
        if (i2 == 4) {
            return createGooglePayViewHolder(viewGroup);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ViewHolder.AddCardPaymentMethodViewHolder createAddCardPaymentMethodViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder.AddCardPaymentMethodViewHolder(context, viewGroup);
    }

    private final ViewHolder.AddFpxPaymentMethodViewHolder createAddFpxPaymentMethodViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder.AddFpxPaymentMethodViewHolder(context, viewGroup);
    }

    private final ViewHolder.PaymentMethodViewHolder createPaymentMethodViewHolder(ViewGroup viewGroup) {
        ViewHolder.PaymentMethodViewHolder paymentMethodViewHolder = new ViewHolder.PaymentMethodViewHolder(viewGroup);
        if (this.canDeletePaymentMethods) {
            ViewCompat.addAccessibilityAction(paymentMethodViewHolder.itemView, viewGroup.getContext().getString(R.string.delete_payment_method), new AccessibilityViewCommand(paymentMethodViewHolder) {
                public final /* synthetic */ PaymentMethodsAdapter.ViewHolder.PaymentMethodViewHolder f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                    return PaymentMethodsAdapter.m4679createPaymentMethodViewHolder$lambda8(PaymentMethodsAdapter.this, this.f$1, view, commandArguments);
                }
            });
        }
        return paymentMethodViewHolder;
    }

    /* access modifiers changed from: private */
    /* renamed from: createPaymentMethodViewHolder$lambda-8  reason: not valid java name */
    public static final boolean m4679createPaymentMethodViewHolder$lambda8(PaymentMethodsAdapter paymentMethodsAdapter, ViewHolder.PaymentMethodViewHolder paymentMethodViewHolder, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        Intrinsics.checkNotNullParameter(paymentMethodsAdapter, "this$0");
        Intrinsics.checkNotNullParameter(paymentMethodViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(view, "$noName_0");
        Listener listener2 = paymentMethodsAdapter.listener;
        if (listener2 == null) {
            return true;
        }
        listener2.onDeletePaymentMethodAction(paymentMethodsAdapter.getPaymentMethodAtPosition$payments_core_release(paymentMethodViewHolder.getBindingAdapterPosition()));
        return true;
    }

    private final ViewHolder.GooglePayViewHolder createGooglePayViewHolder(ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder.GooglePayViewHolder(context, viewGroup);
    }

    public final /* synthetic */ void deletePaymentMethod$payments_core_release(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        Integer position$payments_core_release = getPosition$payments_core_release(paymentMethod);
        if (position$payments_core_release != null) {
            int intValue = position$payments_core_release.intValue();
            getPaymentMethods$payments_core_release().remove(paymentMethod);
            notifyItemRemoved(intValue);
        }
    }

    public final /* synthetic */ void resetPaymentMethod$payments_core_release(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        Integer position$payments_core_release = getPosition$payments_core_release(paymentMethod);
        if (position$payments_core_release != null) {
            notifyItemChanged(position$payments_core_release.intValue());
        }
    }

    public final /* synthetic */ PaymentMethod getPaymentMethodAtPosition$payments_core_release(int i) {
        return this.paymentMethods.get(getPaymentMethodIndex(i));
    }

    private final int getPaymentMethodIndex(int i) {
        return i - this.googlePayCount;
    }

    public final Integer getPosition$payments_core_release(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        Integer valueOf = Integer.valueOf(this.paymentMethods.indexOf(paymentMethod));
        if (!(valueOf.intValue() >= 0)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        return Integer.valueOf(valueOf.intValue() + this.googlePayCount);
    }

    private final int getAddableTypesPosition(int i) {
        return (i - this.paymentMethods.size()) - this.googlePayCount;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004\u0001\u0001\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "AddCardPaymentMethodViewHolder", "AddFpxPaymentMethodViewHolder", "GooglePayViewHolder", "PaymentMethodViewHolder", "Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder$PaymentMethodViewHolder;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsAdapter.kt */
    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public /* synthetic */ ViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
            this(view);
        }

        private ViewHolder(View view) {
            super(view);
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder$AddCardPaymentMethodViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "viewBinding", "Lcom/stripe/android/databinding/AddPaymentMethodRowBinding;", "(Lcom/stripe/android/databinding/AddPaymentMethodRowBinding;)V", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodsAdapter.kt */
        public static final class AddCardPaymentMethodViewHolder extends RecyclerView.ViewHolder {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AddCardPaymentMethodViewHolder(AddPaymentMethodRowBinding addPaymentMethodRowBinding) {
                super(addPaymentMethodRowBinding.getRoot());
                Intrinsics.checkNotNullParameter(addPaymentMethodRowBinding, "viewBinding");
                this.itemView.setId(R.id.stripe_payment_methods_add_card);
                this.itemView.setContentDescription(this.itemView.getResources().getString(R.string.payment_method_add_new_card));
                addPaymentMethodRowBinding.label.setText(this.itemView.getResources().getString(R.string.payment_method_add_new_card));
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public AddCardPaymentMethodViewHolder(android.content.Context r2, android.view.ViewGroup r3) {
                /*
                    r1 = this;
                    java.lang.String r0 = "context"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                    java.lang.String r0 = "parent"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
                    r0 = 0
                    com.stripe.android.databinding.AddPaymentMethodRowBinding r2 = com.stripe.android.databinding.AddPaymentMethodRowBinding.inflate(r2, r3, r0)
                    java.lang.String r3 = "inflate(\n               …  false\n                )"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                    r1.<init>(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentMethodsAdapter.ViewHolder.AddCardPaymentMethodViewHolder.<init>(android.content.Context, android.view.ViewGroup):void");
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder$AddFpxPaymentMethodViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "viewBinding", "Lcom/stripe/android/databinding/AddPaymentMethodRowBinding;", "(Lcom/stripe/android/databinding/AddPaymentMethodRowBinding;)V", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodsAdapter.kt */
        public static final class AddFpxPaymentMethodViewHolder extends RecyclerView.ViewHolder {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AddFpxPaymentMethodViewHolder(AddPaymentMethodRowBinding addPaymentMethodRowBinding) {
                super(addPaymentMethodRowBinding.getRoot());
                Intrinsics.checkNotNullParameter(addPaymentMethodRowBinding, "viewBinding");
                this.itemView.setId(R.id.stripe_payment_methods_add_fpx);
                this.itemView.setContentDescription(this.itemView.getResources().getString(R.string.payment_method_add_new_fpx));
                addPaymentMethodRowBinding.label.setText(this.itemView.getResources().getString(R.string.payment_method_add_new_fpx));
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public AddFpxPaymentMethodViewHolder(android.content.Context r2, android.view.ViewGroup r3) {
                /*
                    r1 = this;
                    java.lang.String r0 = "context"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                    java.lang.String r0 = "parent"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
                    r0 = 0
                    com.stripe.android.databinding.AddPaymentMethodRowBinding r2 = com.stripe.android.databinding.AddPaymentMethodRowBinding.inflate(r2, r3, r0)
                    java.lang.String r3 = "inflate(\n               …  false\n                )"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                    r1.<init>(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentMethodsAdapter.ViewHolder.AddFpxPaymentMethodViewHolder.<init>(android.content.Context, android.view.ViewGroup):void");
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder$GooglePayViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "viewBinding", "Lcom/stripe/android/databinding/GooglePayRowBinding;", "(Lcom/stripe/android/databinding/GooglePayRowBinding;)V", "themeConfig", "Lcom/stripe/android/view/ThemeConfig;", "bind", "", "isSelected", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodsAdapter.kt */
        public static final class GooglePayViewHolder extends RecyclerView.ViewHolder {
            private final ThemeConfig themeConfig;
            private final GooglePayRowBinding viewBinding;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public GooglePayViewHolder(GooglePayRowBinding googlePayRowBinding) {
                super(googlePayRowBinding.getRoot());
                Intrinsics.checkNotNullParameter(googlePayRowBinding, "viewBinding");
                this.viewBinding = googlePayRowBinding;
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                ThemeConfig themeConfig2 = new ThemeConfig(context);
                this.themeConfig = themeConfig2;
                ImageViewCompat.setImageTintList(googlePayRowBinding.checkIcon, ColorStateList.valueOf(themeConfig2.getTintColor$payments_core_release(true)));
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public GooglePayViewHolder(android.content.Context r2, android.view.ViewGroup r3) {
                /*
                    r1 = this;
                    java.lang.String r0 = "context"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                    java.lang.String r0 = "parent"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
                    r0 = 0
                    com.stripe.android.databinding.GooglePayRowBinding r2 = com.stripe.android.databinding.GooglePayRowBinding.inflate(r2, r3, r0)
                    java.lang.String r3 = "inflate(\n               …  false\n                )"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                    r1.<init>(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentMethodsAdapter.ViewHolder.GooglePayViewHolder.<init>(android.content.Context, android.view.ViewGroup):void");
            }

            public final void bind(boolean z) {
                this.viewBinding.label.setTextColor(ColorStateList.valueOf(this.themeConfig.getTextColor$payments_core_release(z)));
                this.viewBinding.checkIcon.setVisibility(z ? 0 : 4);
                this.itemView.setSelected(z);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder$PaymentMethodViewHolder;", "Lcom/stripe/android/view/PaymentMethodsAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "viewBinding", "Lcom/stripe/android/databinding/MaskedCardRowBinding;", "(Lcom/stripe/android/databinding/MaskedCardRowBinding;)V", "setPaymentMethod", "", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "setSelected", "selected", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodsAdapter.kt */
        public static final class PaymentMethodViewHolder extends ViewHolder {
            private final MaskedCardRowBinding viewBinding;

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public PaymentMethodViewHolder(com.stripe.android.databinding.MaskedCardRowBinding r3) {
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
                    r2.viewBinding = r3
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentMethodsAdapter.ViewHolder.PaymentMethodViewHolder.<init>(com.stripe.android.databinding.MaskedCardRowBinding):void");
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public PaymentMethodViewHolder(android.view.ViewGroup r3) {
                /*
                    r2 = this;
                    java.lang.String r0 = "parent"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                    android.content.Context r0 = r3.getContext()
                    android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
                    r1 = 0
                    com.stripe.android.databinding.MaskedCardRowBinding r3 = com.stripe.android.databinding.MaskedCardRowBinding.inflate(r0, r3, r1)
                    java.lang.String r0 = "inflate(\n               …  false\n                )"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                    r2.<init>((com.stripe.android.databinding.MaskedCardRowBinding) r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentMethodsAdapter.ViewHolder.PaymentMethodViewHolder.<init>(android.view.ViewGroup):void");
            }

            public final void setPaymentMethod(PaymentMethod paymentMethod) {
                Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
                this.viewBinding.maskedCardItem.setPaymentMethod(paymentMethod);
            }

            public final void setSelected(boolean z) {
                this.viewBinding.maskedCardItem.setSelected(z);
                this.itemView.setSelected(z);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsAdapter$Companion;", "", "()V", "GOOGLE_PAY_ITEM_ID", "", "getGOOGLE_PAY_ITEM_ID$payments_core_release", "()J", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getGOOGLE_PAY_ITEM_ID$payments_core_release() {
            return PaymentMethodsAdapter.GOOGLE_PAY_ITEM_ID;
        }
    }
}
