package com.stripe.android.ui.core.elements;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DropdownFieldUI.kt */
final class DropdownFieldUIKt$DropDown$1$5 extends Lambda implements Function1<LazyListScope, Unit> {
    final /* synthetic */ DropdownFieldController $controller;
    final /* synthetic */ long $currentTextColor;
    final /* synthetic */ MutableState<Boolean> $expanded$delegate;
    final /* synthetic */ List<String> $items;
    final /* synthetic */ State<Integer> $selectedIndex$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DropdownFieldUIKt$DropDown$1$5(List<String> list, long j, State<Integer> state, DropdownFieldController dropdownFieldController, MutableState<Boolean> mutableState) {
        super(1);
        this.$items = list;
        this.$currentTextColor = j;
        this.$selectedIndex$delegate = state;
        this.$controller = dropdownFieldController;
        this.$expanded$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$DropdownMenu");
        List<String> list = this.$items;
        lazyListScope.items(list.size(), (Function1<? super Integer, ? extends Object>) null, ComposableLambdaKt.composableLambdaInstance(-985537359, true, new DropdownFieldUIKt$DropDown$1$5$invoke$$inlined$itemsIndexed$default$2(list, this.$currentTextColor, this.$selectedIndex$delegate, this.$controller, this.$expanded$delegate)));
    }
}
