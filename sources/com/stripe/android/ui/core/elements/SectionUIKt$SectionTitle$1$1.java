package com.stripe.android.ui.core.elements;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionUI.kt */
final class SectionUIKt$SectionTitle$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final SectionUIKt$SectionTitle$1$1 INSTANCE = new SectionUIKt$SectionTitle$1$1();

    SectionUIKt$SectionTitle$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
    }
}
