package com.stripe.android.paymentsheet;

import android.content.res.Resources;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.paymentsheet.model.FragmentConfig;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.model.SavedSelection;
import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import com.stripe.android.paymentsheet.ui.PaymentMethodsUiExtensionKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0007NOPQRSTBv\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u000e\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0002\u0010\u0013J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u0002002\u0006\u0010\n\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u000200H\u0016J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000200H\u0016J\u0010\u00109\u001a\u0002002\u0006\u00108\u001a\u000200H\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u00022\u0006\u00108\u001a\u000200H\u0016J\u0018\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u000200H\u0016J\u001d\u0010@\u001a\u00020\f2\u0006\u00108\u001a\u0002002\u0006\u0010\u000b\u001a\u00020\u0004H\u0001¢\u0006\u0002\bAJ\u0010\u0010B\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u0002H\u0016J\u000e\u0010C\u001a\u00020\f2\u0006\u0010D\u001a\u00020!J\u000e\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\u0004J0\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020I2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0 2\u0006\u0010L\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007J$\u0010M\u001a\b\u0012\u0004\u0012\u00020K0 2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020K0 2\u0006\u00102\u001a\u000203H\u0002R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048@@@X\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R,\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)RA\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010!8@X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$PaymentOptionViewHolder;", "canClickSelectedItem", "", "paymentOptionSelectedListener", "Lkotlin/Function2;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "Lkotlin/ParameterName;", "name", "paymentSelection", "isClick", "", "paymentMethodDeleteListener", "Lkotlin/Function1;", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item$SavedPaymentMethod;", "paymentMethod", "addCardClickListener", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getAddCardClickListener", "()Lkotlin/jvm/functions/Function0;", "isEditing", "<set-?>", "isEnabled", "isEnabled$paymentsheet_release", "()Z", "setEnabled$paymentsheet_release", "(Z)V", "isEnabled$delegate", "Lkotlin/properties/ReadWriteProperty;", "items", "", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item;", "getItems$paymentsheet_release$annotations", "()V", "getItems$paymentsheet_release", "()Ljava/util/List;", "setItems$paymentsheet_release", "(Ljava/util/List;)V", "getPaymentMethodDeleteListener", "()Lkotlin/jvm/functions/Function1;", "getPaymentOptionSelectedListener", "()Lkotlin/jvm/functions/Function2;", "selectedItem", "getSelectedItem$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item;", "selectedItemPosition", "", "findInitialSelectedPosition", "savedSelection", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "findSelectedPosition", "getItemCount", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onItemSelected", "onItemSelected$paymentsheet_release", "onViewRecycled", "removeItem", "item", "setEditing", "editing", "setItems", "config", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "paymentMethods", "Lcom/stripe/android/model/PaymentMethod;", "showGooglePay", "sortedPaymentMethods", "AddNewPaymentMethodViewHolder", "Companion", "GooglePayViewHolder", "Item", "PaymentOptionViewHolder", "SavedPaymentMethodViewHolder", "ViewType", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
public final class PaymentOptionsAdapter extends RecyclerView.Adapter<PaymentOptionViewHolder> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(PaymentOptionsAdapter.class, "isEnabled", "isEnabled$paymentsheet_release()Z", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float PM_OPTIONS_DEFAULT_PADDING = 6.0f;
    private final Function0<Unit> addCardClickListener;
    private final boolean canClickSelectedItem;
    private boolean isEditing;
    private final ReadWriteProperty isEnabled$delegate;
    private List<? extends Item> items = CollectionsKt.emptyList();
    private final Function1<Item.SavedPaymentMethod, Unit> paymentMethodDeleteListener;
    private final Function2<PaymentSelection, Boolean, Unit> paymentOptionSelectedListener;
    private int selectedItemPosition = -1;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$ViewType;", "", "(Ljava/lang/String;I)V", "SavedPaymentMethod", "AddCard", "GooglePay", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsAdapter.kt */
    public enum ViewType {
        SavedPaymentMethod,
        AddCard,
        GooglePay
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ViewType.values().length];
            iArr[ViewType.AddCard.ordinal()] = 1;
            iArr[ViewType.GooglePay.ordinal()] = 2;
            iArr[ViewType.SavedPaymentMethod.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getItems$paymentsheet_release$annotations() {
    }

    public final Function2<PaymentSelection, Boolean, Unit> getPaymentOptionSelectedListener() {
        return this.paymentOptionSelectedListener;
    }

    public final Function1<Item.SavedPaymentMethod, Unit> getPaymentMethodDeleteListener() {
        return this.paymentMethodDeleteListener;
    }

    public final Function0<Unit> getAddCardClickListener() {
        return this.addCardClickListener;
    }

    public PaymentOptionsAdapter(boolean z, Function2<? super PaymentSelection, ? super Boolean, Unit> function2, Function1<? super Item.SavedPaymentMethod, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function2, "paymentOptionSelectedListener");
        Intrinsics.checkNotNullParameter(function1, "paymentMethodDeleteListener");
        Intrinsics.checkNotNullParameter(function0, "addCardClickListener");
        this.canClickSelectedItem = z;
        this.paymentOptionSelectedListener = function2;
        this.paymentMethodDeleteListener = function1;
        this.addCardClickListener = function0;
        Delegates delegates = Delegates.INSTANCE;
        this.isEnabled$delegate = new PaymentOptionsAdapter$special$$inlined$observable$1(true, this);
        setHasStableIds(true);
    }

    public final List<Item> getItems$paymentsheet_release() {
        return this.items;
    }

    public final void setItems$paymentsheet_release(List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    public final Item getSelectedItem$paymentsheet_release() {
        return (Item) CollectionsKt.getOrNull(this.items, this.selectedItemPosition);
    }

    public final boolean isEnabled$paymentsheet_release() {
        return ((Boolean) this.isEnabled$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setEnabled$paymentsheet_release(boolean z) {
        this.isEnabled$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final void setEditing(boolean z) {
        if (z != this.isEditing) {
            this.isEditing = z;
            notifyDataSetChanged();
        }
    }

    public static /* synthetic */ void setItems$default(PaymentOptionsAdapter paymentOptionsAdapter, FragmentConfig fragmentConfig, List list, boolean z, PaymentSelection paymentSelection, int i, Object obj) {
        if ((i & 8) != 0) {
            paymentSelection = null;
        }
        paymentOptionsAdapter.setItems(fragmentConfig, list, z, paymentSelection);
    }

    public final void setItems(FragmentConfig fragmentConfig, List<PaymentMethod> list, boolean z, PaymentSelection paymentSelection) {
        Integer num;
        int i;
        Intrinsics.checkNotNullParameter(fragmentConfig, "config");
        Intrinsics.checkNotNullParameter(list, "paymentMethods");
        Item[] itemArr = new Item[2];
        itemArr[0] = Item.AddCard.INSTANCE;
        Item.GooglePay googlePay = Item.GooglePay.INSTANCE;
        boolean z2 = true;
        Integer num2 = null;
        if (!(fragmentConfig.isGooglePayReady() && z)) {
            googlePay = null;
        }
        itemArr[1] = googlePay;
        Collection listOfNotNull = CollectionsKt.listOfNotNull((T[]) itemArr);
        Iterable<PaymentMethod> sortedPaymentMethods = sortedPaymentMethods(list, fragmentConfig.getSavedSelection());
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedPaymentMethods, 10));
        for (PaymentMethod savedPaymentMethod : sortedPaymentMethods) {
            arrayList.add(new Item.SavedPaymentMethod(savedPaymentMethod));
        }
        this.items = CollectionsKt.plus(listOfNotNull, (List) arrayList);
        if (paymentSelection == null) {
            num = null;
        } else {
            num = Integer.valueOf(findSelectedPosition(paymentSelection));
        }
        if (num != null && num.intValue() == -1) {
            z2 = false;
        }
        if (z2) {
            num2 = num;
        }
        if (num2 == null) {
            i = findInitialSelectedPosition(fragmentConfig.getSavedSelection());
        } else {
            i = num2.intValue();
        }
        onItemSelected$paymentsheet_release(i, false);
        notifyDataSetChanged();
    }

    public final void removeItem(Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int indexOf = this.items.indexOf(item);
        List<? extends Item> mutableList = CollectionsKt.toMutableList(this.items);
        mutableList.remove(indexOf);
        this.items = mutableList;
        notifyItemRemoved(indexOf);
    }

    private final int findInitialSelectedPosition(SavedSelection savedSelection) {
        boolean z;
        Integer[] numArr = new Integer[3];
        Iterator<? extends Item> it = this.items.iterator();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Item item = (Item) it.next();
            if (Intrinsics.areEqual((Object) savedSelection, (Object) SavedSelection.GooglePay.INSTANCE)) {
                z = item instanceof Item.GooglePay;
            } else {
                if (savedSelection instanceof SavedSelection.PaymentMethod) {
                    if (item instanceof Item.SavedPaymentMethod) {
                        z = Intrinsics.areEqual((Object) ((SavedSelection.PaymentMethod) savedSelection).getId(), (Object) ((Item.SavedPaymentMethod) item).getPaymentMethod().id);
                    }
                } else if (!Intrinsics.areEqual((Object) savedSelection, (Object) SavedSelection.None.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                z = false;
            }
            if (z) {
                break;
            }
            i++;
        }
        Integer valueOf = Integer.valueOf(i);
        Integer num = null;
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        numArr[0] = valueOf;
        Iterator<? extends Item> it2 = this.items.iterator();
        int i2 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i2 = -1;
                break;
            } else if (((Item) it2.next()) instanceof Item.GooglePay) {
                break;
            } else {
                i2++;
            }
        }
        Integer valueOf2 = Integer.valueOf(i2);
        if (!(valueOf2.intValue() != -1)) {
            valueOf2 = null;
        }
        numArr[1] = valueOf2;
        Iterator<? extends Item> it3 = this.items.iterator();
        int i3 = 0;
        while (true) {
            if (!it3.hasNext()) {
                i3 = -1;
                break;
            } else if (((Item) it3.next()) instanceof Item.SavedPaymentMethod) {
                break;
            } else {
                i3++;
            }
        }
        Integer valueOf3 = Integer.valueOf(i3);
        if (valueOf3.intValue() != -1) {
            z2 = true;
        }
        if (z2) {
            num = valueOf3;
        }
        numArr[2] = num;
        Integer num2 = (Integer) CollectionsKt.firstOrNull(CollectionsKt.listOfNotNull((T[]) numArr));
        if (num2 == null) {
            return -1;
        }
        return num2.intValue();
    }

    private final int findSelectedPosition(PaymentSelection paymentSelection) {
        boolean z;
        int i = 0;
        for (Item item : this.items) {
            if (Intrinsics.areEqual((Object) paymentSelection, (Object) PaymentSelection.GooglePay.INSTANCE)) {
                z = item instanceof Item.GooglePay;
            } else {
                z = (!(paymentSelection instanceof PaymentSelection.Saved) || !(item instanceof Item.SavedPaymentMethod)) ? false : Intrinsics.areEqual((Object) ((PaymentSelection.Saved) paymentSelection).getPaymentMethod().id, (Object) ((Item.SavedPaymentMethod) item).getPaymentMethod().id);
            }
            if (z) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private final List<PaymentMethod> sortedPaymentMethods(List<PaymentMethod> list, SavedSelection savedSelection) {
        int i;
        if (savedSelection instanceof SavedSelection.PaymentMethod) {
            Iterator<PaymentMethod> it = list.iterator();
            i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual((Object) it.next().id, (Object) ((SavedSelection.PaymentMethod) savedSelection).getId())) {
                    break;
                } else {
                    i++;
                }
            }
        }
        i = -1;
        if (i == -1) {
            return list;
        }
        List<PaymentMethod> mutableList = CollectionsKt.toMutableList(list);
        mutableList.add(0, mutableList.remove(i));
        return mutableList;
    }

    public final void onItemSelected$paymentsheet_release(int i, boolean z) {
        PaymentSelection paymentSelection;
        if (i == -1) {
            return;
        }
        if ((this.canClickSelectedItem || i != this.selectedItemPosition) && !this.isEditing) {
            int i2 = this.selectedItemPosition;
            this.selectedItemPosition = i;
            notifyItemChanged(i2);
            notifyItemChanged(i);
            Item item = (Item) this.items.get(i);
            if (Intrinsics.areEqual((Object) item, (Object) Item.AddCard.INSTANCE)) {
                paymentSelection = null;
            } else if (Intrinsics.areEqual((Object) item, (Object) Item.GooglePay.INSTANCE)) {
                paymentSelection = PaymentSelection.GooglePay.INSTANCE;
            } else if (item instanceof Item.SavedPaymentMethod) {
                paymentSelection = new PaymentSelection.Saved(((Item.SavedPaymentMethod) item).getPaymentMethod());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (paymentSelection != null) {
                getPaymentOptionSelectedListener().invoke(paymentSelection, Boolean.valueOf(z));
            }
        }
    }

    public long getItemId(int i) {
        return (long) ((Item) this.items.get(i)).hashCode();
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int i) {
        return ((Item) this.items.get(i)).getViewType().ordinal();
    }

    public PaymentOptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        float r3 = Companion.m4404calculateViewWidthu2uoSUM(viewGroup);
        int i2 = WhenMappings.$EnumSwitchMapping$0[ViewType.values()[i].ordinal()];
        if (i2 == 1) {
            return new AddNewPaymentMethodViewHolder(viewGroup, r3, (Function0) this.addCardClickListener, (DefaultConstructorMarker) null);
        }
        if (i2 == 2) {
            return new GooglePayViewHolder(viewGroup, r3, (Function2) new PaymentOptionsAdapter$onCreateViewHolder$1(this), (DefaultConstructorMarker) null);
        }
        if (i2 == 3) {
            return new SavedPaymentMethodViewHolder(viewGroup, r3, (Function2) new PaymentOptionsAdapter$onCreateViewHolder$2(this), (Function1) new PaymentOptionsAdapter$onCreateViewHolder$3(this), (DefaultConstructorMarker) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public void onBindViewHolder(PaymentOptionViewHolder paymentOptionViewHolder, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(paymentOptionViewHolder, "holder");
        if (paymentOptionViewHolder instanceof SavedPaymentMethodViewHolder) {
            z = isEnabled$paymentsheet_release();
        } else {
            z = isEnabled$paymentsheet_release() && !this.isEditing;
        }
        paymentOptionViewHolder.bind(i == this.selectedItemPosition && !this.isEditing, z, this.isEditing, (Item) this.items.get(i), i);
    }

    public void onViewRecycled(PaymentOptionViewHolder paymentOptionViewHolder) {
        Intrinsics.checkNotNullParameter(paymentOptionViewHolder, "holder");
        paymentOptionViewHolder.onViewRecycled();
        super.onViewRecycled(paymentOptionViewHolder);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BH\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\fø\u0001\u0000¢\u0006\u0002\u0010\rBF\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\f\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010J0\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$SavedPaymentMethodViewHolder;", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$PaymentOptionViewHolder;", "parent", "Landroid/view/ViewGroup;", "width", "Landroidx/compose/ui/unit/Dp;", "onItemSelectedListener", "Lkotlin/Function2;", "", "", "", "onRemoveListener", "Lkotlin/Function1;", "(Landroid/view/ViewGroup;FLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "(Landroidx/compose/ui/platform/ComposeView;FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "bind", "isSelected", "isEnabled", "isEditing", "item", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item;", "position", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsAdapter.kt */
    public static final class SavedPaymentMethodViewHolder extends PaymentOptionViewHolder {
        private final ComposeView composeView;
        /* access modifiers changed from: private */
        public final Function2<Integer, Boolean, Unit> onItemSelectedListener;
        /* access modifiers changed from: private */
        public final Function1<Integer, Unit> onRemoveListener;
        /* access modifiers changed from: private */
        public final float width;

        public /* synthetic */ SavedPaymentMethodViewHolder(ViewGroup viewGroup, float f, Function2 function2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewGroup, f, (Function2<? super Integer, ? super Boolean, Unit>) function2, (Function1<? super Integer, Unit>) function1);
        }

        public /* synthetic */ SavedPaymentMethodViewHolder(ComposeView composeView2, float f, Function1 function1, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(composeView2, f, (Function1<? super Integer, Unit>) function1, (Function2<? super Integer, ? super Boolean, Unit>) function2);
        }

        private SavedPaymentMethodViewHolder(ComposeView composeView2, float f, Function1<? super Integer, Unit> function1, Function2<? super Integer, ? super Boolean, Unit> function2) {
            super(composeView2);
            this.composeView = composeView2;
            this.width = f;
            this.onRemoveListener = function1;
            this.onItemSelectedListener = function2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private SavedPaymentMethodViewHolder(android.view.ViewGroup r8, float r9, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Boolean, kotlin.Unit> r10, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r11) {
            /*
                r7 = this;
                androidx.compose.ui.platform.ComposeView r6 = new androidx.compose.ui.platform.ComposeView
                android.content.Context r1 = r8.getContext()
                java.lang.String r8 = "parent.context"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
                r2 = 0
                r3 = 0
                r4 = 6
                r5 = 0
                r0 = r6
                r0.<init>(r1, r2, r3, r4, r5)
                r0 = r7
                r1 = r6
                r2 = r9
                r3 = r11
                r4 = r10
                r0.<init>((androidx.compose.ui.platform.ComposeView) r1, (float) r2, (kotlin.jvm.functions.Function1) r3, (kotlin.jvm.functions.Function2) r4, (kotlin.jvm.internal.DefaultConstructorMarker) r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentOptionsAdapter.SavedPaymentMethodViewHolder.<init>(android.view.ViewGroup, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1):void");
        }

        public void bind(boolean z, boolean z2, boolean z3, Item item, int i) {
            Item item2 = item;
            Intrinsics.checkNotNullParameter(item2, "item");
            Item.SavedPaymentMethod savedPaymentMethod = (Item.SavedPaymentMethod) item2;
            PaymentMethod paymentMethod = savedPaymentMethod.getPaymentMethod();
            Resources resources = this.itemView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "itemView.resources");
            String label = PaymentMethodsUiExtensionKt.getLabel(paymentMethod, resources);
            if (label != null) {
                Resources resources2 = this.itemView.getResources();
                int i2 = R.string.stripe_paymentsheet_remove_pm;
                Object[] objArr = new Object[1];
                SupportedPaymentMethod.Companion companion = SupportedPaymentMethod.Companion;
                PaymentMethod.Type type = savedPaymentMethod.getPaymentMethod().type;
                String str = null;
                SupportedPaymentMethod fromCode = companion.fromCode(type == null ? null : type.code);
                if (fromCode != null) {
                    str = this.itemView.getResources().getString(fromCode.getDisplayNameResource());
                }
                objArr[0] = str;
                String string = resources2.getString(i2, objArr);
                Intrinsics.checkNotNullExpressionValue(string, "itemView.resources.getSt…          }\n            )");
                this.composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-985538716, true, new PaymentOptionsAdapter$SavedPaymentMethodViewHolder$bind$1(this, savedPaymentMethod, item, z, z3, z2, label, string, i)));
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B(\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\tB&\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\fJ0\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$AddNewPaymentMethodViewHolder;", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$PaymentOptionViewHolder;", "parent", "Landroid/view/ViewGroup;", "width", "Landroidx/compose/ui/unit/Dp;", "onItemSelectedListener", "Lkotlin/Function0;", "", "(Landroid/view/ViewGroup;FLkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "(Landroidx/compose/ui/platform/ComposeView;FLkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "bind", "isSelected", "", "isEnabled", "isEditing", "item", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item;", "position", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsAdapter.kt */
    public static final class AddNewPaymentMethodViewHolder extends PaymentOptionViewHolder {
        private final ComposeView composeView;
        /* access modifiers changed from: private */
        public final Function0<Unit> onItemSelectedListener;
        /* access modifiers changed from: private */
        public final float width;

        public /* synthetic */ AddNewPaymentMethodViewHolder(ViewGroup viewGroup, float f, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewGroup, f, (Function0<Unit>) function0);
        }

        public /* synthetic */ AddNewPaymentMethodViewHolder(ComposeView composeView2, float f, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
            this(composeView2, f, (Function0<Unit>) function0);
        }

        private AddNewPaymentMethodViewHolder(ComposeView composeView2, float f, Function0<Unit> function0) {
            super(composeView2);
            this.composeView = composeView2;
            this.width = f;
            this.onItemSelectedListener = function0;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private AddNewPaymentMethodViewHolder(android.view.ViewGroup r8, float r9, kotlin.jvm.functions.Function0<kotlin.Unit> r10) {
            /*
                r7 = this;
                androidx.compose.ui.platform.ComposeView r6 = new androidx.compose.ui.platform.ComposeView
                android.content.Context r1 = r8.getContext()
                java.lang.String r8 = "parent.context"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
                r2 = 0
                r3 = 0
                r4 = 6
                r5 = 0
                r0 = r6
                r0.<init>(r1, r2, r3, r4, r5)
                r8 = 0
                r7.<init>((androidx.compose.ui.platform.ComposeView) r6, (float) r9, (kotlin.jvm.functions.Function0) r10, (kotlin.jvm.internal.DefaultConstructorMarker) r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentOptionsAdapter.AddNewPaymentMethodViewHolder.<init>(android.view.ViewGroup, float, kotlin.jvm.functions.Function0):void");
        }

        public void bind(boolean z, boolean z2, boolean z3, Item item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-985545350, true, new PaymentOptionsAdapter$AddNewPaymentMethodViewHolder$bind$1(this, z2)));
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B4\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000bB2\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ0\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$GooglePayViewHolder;", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$PaymentOptionViewHolder;", "parent", "Landroid/view/ViewGroup;", "width", "Landroidx/compose/ui/unit/Dp;", "onItemSelectedListener", "Lkotlin/Function2;", "", "", "", "(Landroid/view/ViewGroup;FLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "(Landroidx/compose/ui/platform/ComposeView;FLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "bind", "isSelected", "isEnabled", "isEditing", "item", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item;", "position", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsAdapter.kt */
    public static final class GooglePayViewHolder extends PaymentOptionViewHolder {
        private final ComposeView composeView;
        /* access modifiers changed from: private */
        public final Function2<Integer, Boolean, Unit> onItemSelectedListener;
        /* access modifiers changed from: private */
        public final float width;

        public /* synthetic */ GooglePayViewHolder(ViewGroup viewGroup, float f, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(viewGroup, f, (Function2<? super Integer, ? super Boolean, Unit>) function2);
        }

        public /* synthetic */ GooglePayViewHolder(ComposeView composeView2, float f, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(composeView2, f, (Function2<? super Integer, ? super Boolean, Unit>) function2);
        }

        private GooglePayViewHolder(ComposeView composeView2, float f, Function2<? super Integer, ? super Boolean, Unit> function2) {
            super(composeView2);
            this.composeView = composeView2;
            this.width = f;
            this.onItemSelectedListener = function2;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private GooglePayViewHolder(android.view.ViewGroup r8, float r9, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Boolean, kotlin.Unit> r10) {
            /*
                r7 = this;
                androidx.compose.ui.platform.ComposeView r6 = new androidx.compose.ui.platform.ComposeView
                android.content.Context r1 = r8.getContext()
                java.lang.String r8 = "parent.context"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r8)
                r2 = 0
                r3 = 0
                r4 = 6
                r5 = 0
                r0 = r6
                r0.<init>(r1, r2, r3, r4, r5)
                r8 = 0
                r7.<init>((androidx.compose.ui.platform.ComposeView) r6, (float) r9, (kotlin.jvm.functions.Function2) r10, (kotlin.jvm.internal.DefaultConstructorMarker) r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentOptionsAdapter.GooglePayViewHolder.<init>(android.view.ViewGroup, float, kotlin.jvm.functions.Function2):void");
        }

        public void bind(boolean z, boolean z2, boolean z3, Item item, int i) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-985543752, true, new PaymentOptionsAdapter$GooglePayViewHolder$bind$1(this, z, z2, i)));
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$PaymentOptionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "(Landroidx/compose/ui/platform/ComposeView;)V", "bind", "", "isSelected", "", "isEnabled", "isEditing", "item", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item;", "position", "", "onViewRecycled", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsAdapter.kt */
    public static abstract class PaymentOptionViewHolder extends RecyclerView.ViewHolder {
        private final ComposeView composeView;

        public abstract void bind(boolean z, boolean z2, boolean z3, Item item, int i);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaymentOptionViewHolder(ComposeView composeView2) {
            super(composeView2);
            Intrinsics.checkNotNullParameter(composeView2, "composeView");
            this.composeView = composeView2;
            composeView2.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        }

        public final void onViewRecycled() {
            this.composeView.disposeComposition();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item;", "", "()V", "viewType", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$ViewType;", "getViewType", "()Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$ViewType;", "AddCard", "GooglePay", "SavedPaymentMethod", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item$AddCard;", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item$GooglePay;", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item$SavedPaymentMethod;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsAdapter.kt */
    public static abstract class Item {
        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract ViewType getViewType();

        private Item() {
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item$AddCard;", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item;", "()V", "viewType", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$ViewType;", "getViewType", "()Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$ViewType;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionsAdapter.kt */
        public static final class AddCard extends Item {
            public static final int $stable = 0;
            public static final AddCard INSTANCE = new AddCard();
            private static final ViewType viewType = ViewType.AddCard;

            private AddCard() {
                super((DefaultConstructorMarker) null);
            }

            public ViewType getViewType() {
                return viewType;
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item$GooglePay;", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item;", "()V", "viewType", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$ViewType;", "getViewType", "()Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$ViewType;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionsAdapter.kt */
        public static final class GooglePay extends Item {
            public static final int $stable = 0;
            public static final GooglePay INSTANCE = new GooglePay();
            private static final ViewType viewType = ViewType.GooglePay;

            private GooglePay() {
                super((DefaultConstructorMarker) null);
            }

            public ViewType getViewType() {
                return viewType;
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item$SavedPaymentMethod;", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Item;", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "(Lcom/stripe/android/model/PaymentMethod;)V", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "viewType", "Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$ViewType;", "getViewType", "()Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$ViewType;", "component1", "copy", "equals", "", "other", "", "getDescription", "", "resources", "Landroid/content/res/Resources;", "getRemoveDescription", "hashCode", "", "toString", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentOptionsAdapter.kt */
        public static final class SavedPaymentMethod extends Item {
            public static final int $stable = PaymentMethod.$stable;
            private final PaymentMethod paymentMethod;
            private final ViewType viewType = ViewType.SavedPaymentMethod;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentOptionsAdapter.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[PaymentMethod.Type.values().length];
                    iArr[PaymentMethod.Type.Card.ordinal()] = 1;
                    iArr[PaymentMethod.Type.SepaDebit.ordinal()] = 2;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public static /* synthetic */ SavedPaymentMethod copy$default(SavedPaymentMethod savedPaymentMethod, PaymentMethod paymentMethod2, int i, Object obj) {
                if ((i & 1) != 0) {
                    paymentMethod2 = savedPaymentMethod.paymentMethod;
                }
                return savedPaymentMethod.copy(paymentMethod2);
            }

            public final PaymentMethod component1() {
                return this.paymentMethod;
            }

            public final SavedPaymentMethod copy(PaymentMethod paymentMethod2) {
                Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
                return new SavedPaymentMethod(paymentMethod2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SavedPaymentMethod) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) ((SavedPaymentMethod) obj).paymentMethod);
            }

            public int hashCode() {
                return this.paymentMethod.hashCode();
            }

            public String toString() {
                return "SavedPaymentMethod(paymentMethod=" + this.paymentMethod + ')';
            }

            public final PaymentMethod getPaymentMethod() {
                return this.paymentMethod;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SavedPaymentMethod(PaymentMethod paymentMethod2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(paymentMethod2, "paymentMethod");
                this.paymentMethod = paymentMethod2;
            }

            public ViewType getViewType() {
                return this.viewType;
            }

            public final String getDescription(Resources resources) {
                String str;
                Intrinsics.checkNotNullParameter(resources, "resources");
                PaymentMethod.Type type = this.paymentMethod.type;
                int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                String str2 = null;
                if (i == 1) {
                    int i2 = R.string.card_ending_in;
                    Object[] objArr = new Object[2];
                    PaymentMethod.Card card = this.paymentMethod.card;
                    objArr[0] = card == null ? null : card.brand;
                    PaymentMethod.Card card2 = this.paymentMethod.card;
                    if (card2 != null) {
                        str2 = card2.last4;
                    }
                    objArr[1] = str2;
                    str = resources.getString(i2, objArr);
                } else if (i != 2) {
                    str = "";
                } else {
                    int i3 = R.string.bank_account_ending_in;
                    Object[] objArr2 = new Object[1];
                    PaymentMethod.SepaDebit sepaDebit = this.paymentMethod.sepaDebit;
                    if (sepaDebit != null) {
                        str2 = sepaDebit.last4;
                    }
                    objArr2[0] = str2;
                    str = resources.getString(i3, objArr2);
                }
                Intrinsics.checkNotNullExpressionValue(str, "when (paymentMethod.type… else -> \"\"\n            }");
                return str;
            }

            public final String getRemoveDescription(Resources resources) {
                Intrinsics.checkNotNullParameter(resources, "resources");
                String string = resources.getString(R.string.stripe_paymentsheet_remove_pm, new Object[]{getDescription(resources)});
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …(resources)\n            )");
                return string;
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsAdapter$Companion;", "", "()V", "PM_OPTIONS_DEFAULT_PADDING", "", "calculateViewWidth", "Landroidx/compose/ui/unit/Dp;", "parent", "Landroid/view/ViewGroup;", "calculateViewWidth-u2uoSUM", "(Landroid/view/ViewGroup;)F", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* renamed from: calculateViewWidth-u2uoSUM  reason: not valid java name */
        public final float m4404calculateViewWidthu2uoSUM(ViewGroup viewGroup) {
            int measuredWidth = (viewGroup.getMeasuredWidth() - viewGroup.getPaddingStart()) - viewGroup.getPaddingEnd();
            float f = viewGroup.getContext().getResources().getDisplayMetrics().density;
            float f2 = (float) (measuredWidth * 2);
            return Dp.m3859constructorimpl((((float) measuredWidth) / (((float) ((int) (f2 / ((((float) 100) * f) + 12.0f)))) / 2.0f)) / f);
        }
    }
}
