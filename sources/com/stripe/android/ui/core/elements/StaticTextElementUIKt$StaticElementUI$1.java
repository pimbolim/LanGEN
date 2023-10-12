package com.stripe.android.ui.core.elements;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StaticTextElementUI.kt */
final class StaticTextElementUIKt$StaticElementUI$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final StaticTextElementUIKt$StaticElementUI$1 INSTANCE = new StaticTextElementUIKt$StaticElementUI$1();

    StaticTextElementUIKt$StaticElementUI$1() {
        super(1);
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }
}
