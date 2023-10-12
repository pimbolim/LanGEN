package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DropdownFieldUI.kt */
final class DropdownFieldUIKt$DropDown$1$4$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<Boolean> $expanded$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DropdownFieldUIKt$DropDown$1$4$1(MutableState<Boolean> mutableState) {
        super(0);
        this.$expanded$delegate = mutableState;
    }

    public final void invoke() {
        DropdownFieldUIKt.m4575DropDown$lambda4(this.$expanded$delegate, false);
    }
}
