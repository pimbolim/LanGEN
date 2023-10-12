package com.stripe.android.link;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.stripe.android.link.LinkActivity$onCreate$1;
import com.stripe.android.link.LinkScreen;
import com.stripe.android.link.model.LinkAccount;
import com.stripe.android.link.ui.signup.SignUpScreenKt;
import com.stripe.android.link.ui.verification.VerificationScreenKt;
import com.stripe.android.link.ui.wallet.WalletScreenKt;
import com.stripe.android.model.ConsumerSession;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkActivity.kt */
final class LinkActivity$onCreate$1$1$1$1$2 extends Lambda implements Function1<NavGraphBuilder, Unit> {
    final /* synthetic */ State<LinkAccount> $linkAccount$delegate;
    final /* synthetic */ LinkActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkActivity$onCreate$1$1$1$1$2(LinkActivity linkActivity, State<LinkAccount> state) {
        super(1);
        this.this$0 = linkActivity;
        this.$linkAccount$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavGraphBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NavGraphBuilder navGraphBuilder) {
        Intrinsics.checkNotNullParameter(navGraphBuilder, "$this$NavHost");
        NavGraphBuilderKt.composable$default(navGraphBuilder, LinkScreen.Loading.INSTANCE.getRoute(), (List) null, (List) null, ComposableSingletons$LinkActivityKt.INSTANCE.m4303getLambda1$link_release(), 6, (Object) null);
        List listOf = CollectionsKt.listOf(NamedNavArgumentKt.navArgument("email", AnonymousClass1.INSTANCE));
        final LinkActivity linkActivity = this.this$0;
        NavGraphBuilderKt.composable$default(navGraphBuilder, LinkScreen.SignUp.route, listOf, (List) null, ComposableLambdaKt.composableLambdaInstance(-985530549, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((NavBackStackEntry) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(NavBackStackEntry navBackStackEntry, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(navBackStackEntry, "backStackEntry");
                Bundle arguments = navBackStackEntry.getArguments();
                SignUpScreenKt.SignUpBody(linkActivity.getViewModel().getInjector(), arguments == null ? null : arguments.getString("email"), composer, 0);
            }
        }), 4, (Object) null);
        String route = LinkScreen.Verification.INSTANCE.getRoute();
        final State<LinkAccount> state = this.$linkAccount$delegate;
        final LinkActivity linkActivity2 = this.this$0;
        NavGraphBuilderKt.composable$default(navGraphBuilder, route, (List) null, (List) null, ComposableLambdaKt.composableLambdaInstance(-985530859, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((NavBackStackEntry) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(NavBackStackEntry navBackStackEntry, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
                LinkAccount r2 = LinkActivity$onCreate$1.AnonymousClass1.AnonymousClass1.m4306invoke$lambda1$lambda0(state);
                if (r2 != null) {
                    VerificationScreenKt.VerificationBody(r2, linkActivity2.getViewModel().getInjector(), composer, ConsumerSession.$stable);
                }
            }
        }), 6, (Object) null);
        String route2 = LinkScreen.Wallet.INSTANCE.getRoute();
        final State<LinkAccount> state2 = this.$linkAccount$delegate;
        final LinkActivity linkActivity3 = this.this$0;
        NavGraphBuilder navGraphBuilder2 = navGraphBuilder;
        NavGraphBuilderKt.composable$default(navGraphBuilder2, route2, (List) null, (List) null, ComposableLambdaKt.composableLambdaInstance(-985538147, true, new Function3<NavBackStackEntry, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((NavBackStackEntry) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(NavBackStackEntry navBackStackEntry, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(navBackStackEntry, "it");
                LinkAccount r2 = LinkActivity$onCreate$1.AnonymousClass1.AnonymousClass1.m4306invoke$lambda1$lambda0(state2);
                if (r2 != null) {
                    WalletScreenKt.WalletBody(r2, linkActivity3.getViewModel().getInjector(), composer, ConsumerSession.$stable);
                }
            }
        }), 6, (Object) null);
        NavGraphBuilderKt.composable$default(navGraphBuilder2, LinkScreen.PaymentMethod.INSTANCE.getRoute(), (List) null, (List) null, ComposableSingletons$LinkActivityKt.INSTANCE.m4304getLambda2$link_release(), 6, (Object) null);
    }
}
