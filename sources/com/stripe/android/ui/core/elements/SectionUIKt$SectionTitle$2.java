package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionUI.kt */
final class SectionUIKt$SectionTitle$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Integer $titleText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SectionUIKt$SectionTitle$2(Integer num, int i) {
        super(2);
        this.$titleText = num;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SectionUIKt.SectionTitle(this.$titleText, composer, this.$$changed | 1);
    }
}
