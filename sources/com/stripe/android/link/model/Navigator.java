package com.stripe.android.link.model;

import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import com.stripe.android.link.LinkActivityResult;
import com.stripe.android.link.LinkScreen;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0012\u001a\u00020\u000b¢\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0002\u0010\u0019J\r\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/link/model/Navigator;", "", "()V", "navigationController", "Landroidx/navigation/NavHostController;", "getNavigationController", "()Landroidx/navigation/NavHostController;", "setNavigationController", "(Landroidx/navigation/NavHostController;)V", "onDismiss", "Lkotlin/Function1;", "Lcom/stripe/android/link/LinkActivityResult;", "", "getOnDismiss", "()Lkotlin/jvm/functions/Function1;", "setOnDismiss", "(Lkotlin/jvm/functions/Function1;)V", "dismiss", "result", "(Lcom/stripe/android/link/LinkActivityResult;)Lkotlin/Unit;", "navigateTo", "target", "Lcom/stripe/android/link/LinkScreen;", "clearBackStack", "", "(Lcom/stripe/android/link/LinkScreen;Z)Lkotlin/Unit;", "onBack", "()Lkotlin/Unit;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Navigator.kt */
public final class Navigator {
    private NavHostController navigationController;
    private Function1<? super LinkActivityResult, Unit> onDismiss;

    public final NavHostController getNavigationController() {
        return this.navigationController;
    }

    public final void setNavigationController(NavHostController navHostController) {
        this.navigationController = navHostController;
    }

    public final Function1<LinkActivityResult, Unit> getOnDismiss() {
        return this.onDismiss;
    }

    public final void setOnDismiss(Function1<? super LinkActivityResult, Unit> function1) {
        this.onDismiss = function1;
    }

    public static /* synthetic */ Unit navigateTo$default(Navigator navigator, LinkScreen linkScreen, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return navigator.navigateTo(linkScreen, z);
    }

    public final Unit navigateTo(LinkScreen linkScreen, boolean z) {
        Intrinsics.checkNotNullParameter(linkScreen, "target");
        NavHostController navHostController = this.navigationController;
        if (navHostController == null) {
            return null;
        }
        navHostController.navigate(linkScreen.getRoute(), (Function1<? super NavOptionsBuilder, Unit>) new Navigator$navigateTo$1$1(z, navHostController));
        return Unit.INSTANCE;
    }

    public final Unit onBack() {
        NavHostController navHostController = this.navigationController;
        if (navHostController == null) {
            return null;
        }
        if (!navHostController.popBackStack()) {
            dismiss$default(this, (LinkActivityResult) null, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit dismiss$default(Navigator navigator, LinkActivityResult linkActivityResult, int i, Object obj) {
        if ((i & 1) != 0) {
            linkActivityResult = LinkActivityResult.Canceled.INSTANCE;
        }
        return navigator.dismiss(linkActivityResult);
    }

    public final Unit dismiss(LinkActivityResult linkActivityResult) {
        Intrinsics.checkNotNullParameter(linkActivityResult, "result");
        Function1<? super LinkActivityResult, Unit> function1 = this.onDismiss;
        if (function1 == null) {
            return null;
        }
        function1.invoke(linkActivityResult);
        return Unit.INSTANCE;
    }
}
