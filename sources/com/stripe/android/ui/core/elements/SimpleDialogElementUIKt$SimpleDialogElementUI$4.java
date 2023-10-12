package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleDialogElementUI.kt */
final class SimpleDialogElementUIKt$SimpleDialogElementUI$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ String $confirmText;
    final /* synthetic */ String $dismissText;
    final /* synthetic */ String $messageText;
    final /* synthetic */ Function0<Unit> $onConfirmListener;
    final /* synthetic */ Function0<Unit> $onDismissListener;
    final /* synthetic */ MutableState<Boolean> $openDialog;
    final /* synthetic */ String $titleText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SimpleDialogElementUIKt$SimpleDialogElementUI$4(MutableState<Boolean> mutableState, String str, String str2, String str3, String str4, Function0<Unit> function0, Function0<Unit> function02, int i, int i2) {
        super(2);
        this.$openDialog = mutableState;
        this.$titleText = str;
        this.$messageText = str2;
        this.$confirmText = str3;
        this.$dismissText = str4;
        this.$onConfirmListener = function0;
        this.$onDismissListener = function02;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SimpleDialogElementUIKt.SimpleDialogElementUI(this.$openDialog, this.$titleText, this.$messageText, this.$confirmText, this.$dismissText, this.$onConfirmListener, this.$onDismissListener, composer, this.$$changed | 1, this.$$default);
    }
}
