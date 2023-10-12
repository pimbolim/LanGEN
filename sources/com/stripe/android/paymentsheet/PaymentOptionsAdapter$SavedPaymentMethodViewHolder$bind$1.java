package com.stripe.android.paymentsheet;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import com.stripe.android.paymentsheet.PaymentOptionsAdapter;
import com.stripe.android.paymentsheet.ui.PaymentMethodsUiExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
final class PaymentOptionsAdapter$SavedPaymentMethodViewHolder$bind$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $isEditing;
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ PaymentOptionsAdapter.Item $item;
    final /* synthetic */ String $labelText;
    final /* synthetic */ int $position;
    final /* synthetic */ String $removeTitle;
    final /* synthetic */ PaymentOptionsAdapter.Item.SavedPaymentMethod $savedPaymentMethod;
    final /* synthetic */ PaymentOptionsAdapter.SavedPaymentMethodViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsAdapter$SavedPaymentMethodViewHolder$bind$1(PaymentOptionsAdapter.SavedPaymentMethodViewHolder savedPaymentMethodViewHolder, PaymentOptionsAdapter.Item.SavedPaymentMethod savedPaymentMethod, PaymentOptionsAdapter.Item item, boolean z, boolean z2, boolean z3, String str, String str2, int i) {
        super(2);
        this.this$0 = savedPaymentMethodViewHolder;
        this.$savedPaymentMethod = savedPaymentMethod;
        this.$item = item;
        this.$isSelected = z;
        this.$isEditing = z2;
        this.$isEnabled = z3;
        this.$labelText = str;
        this.$removeTitle = str2;
        this.$position = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            float access$getWidth$p = this.this$0.width;
            Integer savedPaymentMethodIcon = PaymentMethodsUiExtensionKt.getSavedPaymentMethodIcon(this.$savedPaymentMethod.getPaymentMethod());
            int intValue = savedPaymentMethodIcon == null ? 0 : savedPaymentMethodIcon.intValue();
            Resources resources = this.this$0.itemView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "itemView.resources");
            String description = ((PaymentOptionsAdapter.Item.SavedPaymentMethod) this.$item).getDescription(resources);
            PaymentOptionsAdapter.Item.SavedPaymentMethod savedPaymentMethod = this.$savedPaymentMethod;
            Resources resources2 = this.this$0.itemView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "itemView.resources");
            String removeDescription = savedPaymentMethod.getRemoveDescription(resources2);
            boolean z = this.$isSelected;
            boolean z2 = this.$isEditing;
            boolean z3 = this.$isEnabled;
            String str = this.$labelText;
            String str2 = this.$removeTitle;
            final PaymentOptionsAdapter.SavedPaymentMethodViewHolder savedPaymentMethodViewHolder = this.this$0;
            final int i2 = this.$position;
            final PaymentOptionsAdapter.SavedPaymentMethodViewHolder savedPaymentMethodViewHolder2 = this.this$0;
            final int i3 = this.$position;
            PaymentOptionsAdapterKt.m4405PaymentOptionUijFuDa88(access$getWidth$p, z, z2, z3, intValue, str, str2, description, new Function0<Unit>() {
                public final void invoke() {
                    savedPaymentMethodViewHolder.onRemoveListener.invoke(Integer.valueOf(i2));
                }
            }, removeDescription, new Function0<Unit>() {
                public final void invoke() {
                    savedPaymentMethodViewHolder2.onItemSelectedListener.invoke(Integer.valueOf(i3), true);
                }
            }, composer, 0, 0, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
