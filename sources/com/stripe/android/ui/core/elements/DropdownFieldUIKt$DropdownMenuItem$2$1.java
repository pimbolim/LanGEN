package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DropdownFieldUI.kt */
final class DropdownFieldUIKt$DropdownMenuItem$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DropdownFieldUIKt$DropdownMenuItem$2$1(Function0<Unit> function0) {
        super(0);
        this.$onClick = function0;
    }

    public final void invoke() {
        this.$onClick.invoke();
    }
}
