package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SaveForFutureUseElementUI.kt */
final class SaveForFutureUseElementUIKt$SaveForFutureUseElementUI$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ State<Boolean> $checked$delegate;
    final /* synthetic */ SaveForFutureUseController $controller;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveForFutureUseElementUIKt$SaveForFutureUseElementUI$2(SaveForFutureUseController saveForFutureUseController, State<Boolean> state) {
        super(1);
        this.$controller = saveForFutureUseController;
        this.$checked$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        this.$controller.onValueChange(!SaveForFutureUseElementUIKt.m4589SaveForFutureUseElementUI$lambda0(this.$checked$delegate));
    }
}
