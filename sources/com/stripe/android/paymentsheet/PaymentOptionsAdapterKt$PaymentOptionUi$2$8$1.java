package com.stripe.android.paymentsheet;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
final class PaymentOptionsAdapterKt$PaymentOptionUi$2$8$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $description;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsAdapterKt$PaymentOptionUi$2$8$1(String str) {
        super(1);
        this.$description = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, new Regex("\\d").replace((CharSequence) this.$description, "$0 "));
    }
}
