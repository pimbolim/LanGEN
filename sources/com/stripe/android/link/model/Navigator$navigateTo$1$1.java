package com.stripe.android.link.model;

import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/navigation/NavOptionsBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Navigator.kt */
final class Navigator$navigateTo$1$1 extends Lambda implements Function1<NavOptionsBuilder, Unit> {
    final /* synthetic */ boolean $clearBackStack;
    final /* synthetic */ NavHostController $navController;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Navigator$navigateTo$1$1(boolean z, NavHostController navHostController) {
        super(1);
        this.$clearBackStack = z;
        this.$navController = navHostController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavOptionsBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NavOptionsBuilder navOptionsBuilder) {
        Intrinsics.checkNotNullParameter(navOptionsBuilder, "$this$navigate");
        if (this.$clearBackStack) {
            NavOptionsBuilder.popUpTo$default(navOptionsBuilder, this.$navController.getBackQueue().first().getDestination().getId(), (Function1) null, 2, (Object) null);
        }
    }
}
