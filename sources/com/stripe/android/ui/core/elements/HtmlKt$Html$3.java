package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Html.kt */
final class HtmlKt$Html$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ String $html;
    final /* synthetic */ Map<String, EmbeddableImage> $imageGetter;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ TextStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HtmlKt$Html$3(String str, Map<String, EmbeddableImage> map, Modifier modifier, long j, TextStyle textStyle, int i, int i2) {
        super(2);
        this.$html = str;
        this.$imageGetter = map;
        this.$modifier = modifier;
        this.$color = j;
        this.$style = textStyle;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        HtmlKt.m4582HtmluDo3WH8(this.$html, this.$imageGetter, this.$modifier, this.$color, this.$style, composer, this.$$changed | 1, this.$$default);
    }
}
