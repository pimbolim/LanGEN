package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SaveForFutureUseElementUI.kt */
final class SaveForFutureUseElementUIKt$SaveForFutureUseElementUI$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ SaveForFutureUseElement $element;
    final /* synthetic */ boolean $enabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveForFutureUseElementUIKt$SaveForFutureUseElementUI$4(boolean z, SaveForFutureUseElement saveForFutureUseElement, int i) {
        super(2);
        this.$enabled = z;
        this.$element = saveForFutureUseElement;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SaveForFutureUseElementUIKt.SaveForFutureUseElementUI(this.$enabled, this.$element, composer, this.$$changed | 1);
    }
}
