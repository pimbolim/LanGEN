package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionUI.kt */
final class SectionUIKt$Section$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $contentInCard;
    final /* synthetic */ Function2<Composer, Integer, Unit> $contentOutsideCard;
    final /* synthetic */ String $error;
    final /* synthetic */ Integer $title;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SectionUIKt$Section$2(Integer num, String str, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, int i2) {
        super(2);
        this.$title = num;
        this.$error = str;
        this.$contentOutsideCard = function2;
        this.$contentInCard = function22;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SectionUIKt.Section(this.$title, this.$error, this.$contentOutsideCard, this.$contentInCard, composer, this.$$changed | 1, this.$$default);
    }
}
