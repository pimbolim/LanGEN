package com.stripe.android.ui.core.elements;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SaveForFutureUseElementUI.kt */
final class SaveForFutureUseElementUIKt$SaveForFutureUseElementUI$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $description;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveForFutureUseElementUIKt$SaveForFutureUseElementUI$1$1(String str) {
        super(1);
        this.$description = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, this.$description);
    }
}
