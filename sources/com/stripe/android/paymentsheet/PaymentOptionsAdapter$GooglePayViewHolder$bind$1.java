package com.stripe.android.paymentsheet;

import androidx.compose.runtime.Composer;
import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.stripe.android.paymentsheet.PaymentOptionsAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
final class PaymentOptionsAdapter$GooglePayViewHolder$bind$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ int $position;
    final /* synthetic */ PaymentOptionsAdapter.GooglePayViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsAdapter$GooglePayViewHolder$bind$1(PaymentOptionsAdapter.GooglePayViewHolder googlePayViewHolder, boolean z, boolean z2, int i) {
        super(2);
        this.this$0 = googlePayViewHolder;
        this.$isSelected = z;
        this.$isEnabled = z2;
        this.$position = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            float access$getWidth$p = this.this$0.width;
            int i2 = R.drawable.stripe_google_pay_mark;
            String string = this.this$0.itemView.getResources().getString(R.string.google_pay);
            String string2 = this.this$0.itemView.getResources().getString(R.string.google_pay);
            boolean z = this.$isSelected;
            boolean z2 = this.$isEnabled;
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.google_pay)");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.google_pay)");
            final PaymentOptionsAdapter.GooglePayViewHolder googlePayViewHolder = this.this$0;
            final int i3 = this.$position;
            PaymentOptionsAdapterKt.m4405PaymentOptionUijFuDa88(access$getWidth$p, z, false, z2, i2, string, (String) null, string2, (Function0<Unit>) null, (String) null, new Function0<Unit>() {
                public final void invoke() {
                    googlePayViewHolder.onItemSelectedListener.invoke(Integer.valueOf(i3), true);
                }
            }, composer, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 0, LeicaMakernoteDirectory.TAG_IMAGE_ID_NUMBER);
            return;
        }
        composer.skipToGroupEnd();
    }
}
