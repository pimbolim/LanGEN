package com.stripe.android.link;

import android.app.Application;
import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.LinkActivityViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkActivity.kt */
final class LinkActivity$viewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ LinkActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkActivity$viewModel$2(LinkActivity linkActivity) {
        super(0);
        this.this$0 = linkActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        Application application = this.this$0.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        final LinkActivity linkActivity = this.this$0;
        return new LinkActivityViewModel.Factory(application, new Function0<LinkActivityContract.Args>() {
            public final LinkActivityContract.Args invoke() {
                LinkActivityContract.Args access$getStarterArgs = linkActivity.getStarterArgs();
                if (access$getStarterArgs != null) {
                    return access$getStarterArgs;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
    }
}
