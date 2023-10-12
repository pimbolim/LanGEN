package com.stripe.android.link;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.navigation.NavHostController;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.LinkActivityResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0014R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/link/LinkActivity;", "Landroidx/activity/ComponentActivity;", "()V", "navController", "Landroidx/navigation/NavHostController;", "getNavController$annotations", "getNavController", "()Landroidx/navigation/NavHostController;", "setNavController", "(Landroidx/navigation/NavHostController;)V", "starterArgs", "Lcom/stripe/android/link/LinkActivityContract$Args;", "getStarterArgs", "()Lcom/stripe/android/link/LinkActivityContract$Args;", "starterArgs$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/stripe/android/link/LinkActivityViewModel;", "getViewModel", "()Lcom/stripe/android/link/LinkActivityViewModel;", "viewModel$delegate", "dismiss", "", "result", "Lcom/stripe/android/link/LinkActivityResult;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkActivity.kt */
public final class LinkActivity extends ComponentActivity {
    public NavHostController navController;
    private final Lazy starterArgs$delegate = LazyKt.lazy(new LinkActivity$starterArgs$2(this));
    private final Lazy viewModel$delegate;

    public static /* synthetic */ void getNavController$annotations() {
    }

    public LinkActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(LinkActivityViewModel.class), new LinkActivity$special$$inlined$viewModels$default$2(componentActivity), new LinkActivity$viewModel$2(this), new LinkActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: private */
    public final LinkActivityViewModel getViewModel() {
        return (LinkActivityViewModel) this.viewModel$delegate.getValue();
    }

    public final NavHostController getNavController() {
        NavHostController navHostController = this.navController;
        if (navHostController != null) {
            return navHostController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navController");
        return null;
    }

    public final void setNavController(NavHostController navHostController) {
        Intrinsics.checkNotNullParameter(navHostController, "<set-?>");
        this.navController = navHostController;
    }

    /* access modifiers changed from: private */
    public final LinkActivityContract.Args getStarterArgs() {
        return (LinkActivityContract.Args) this.starterArgs$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-985532880, true, new LinkActivity$onCreate$1(this)), 1, (Object) null);
        getViewModel().getNavigator().setOnDismiss(new LinkActivity$onCreate$2(this));
        getViewModel().setupPaymentLauncher(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getViewModel().unregisterFromActivity();
    }

    static /* synthetic */ void dismiss$default(LinkActivity linkActivity, LinkActivityResult linkActivityResult, int i, Object obj) {
        if ((i & 1) != 0) {
            linkActivityResult = LinkActivityResult.Canceled.INSTANCE;
        }
        linkActivity.dismiss(linkActivityResult);
    }

    /* access modifiers changed from: private */
    public final void dismiss(LinkActivityResult linkActivityResult) {
        setResult(linkActivityResult.getResultCode(), new Intent().putExtras(new LinkActivityContract.Result(linkActivityResult).toBundle()));
        finish();
    }
}
