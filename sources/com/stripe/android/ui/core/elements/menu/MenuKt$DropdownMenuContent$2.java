package com.stripe.android.ui.core.elements.menu;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Menu.kt */
final class MenuKt$DropdownMenuContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function1<LazyListScope, Unit> $content;
    final /* synthetic */ int $initialFirstVisibleItemIndex;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MenuKt$DropdownMenuContent$2(int i, int i2, Modifier modifier, Function1<? super LazyListScope, Unit> function1) {
        super(2);
        this.$initialFirstVisibleItemIndex = i;
        this.$$dirty = i2;
        this.$modifier = modifier;
        this.$content = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Composer composer2 = composer;
            LazyDslKt.LazyColumn(PaddingKt.m433paddingVpY3zN4$default(this.$modifier, 0.0f, MenuKt.getDropdownMenuVerticalPadding(), 1, (Object) null), LazyListStateKt.rememberLazyListState(this.$initialFirstVisibleItemIndex, 0, composer2, (this.$$dirty >> 6) & 14, 2), (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, this.$content, composer2, (this.$$dirty << 9) & 29360128, 124);
            return;
        }
        composer.skipToGroupEnd();
    }
}
