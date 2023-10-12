package com.stripe.android.link;

import android.content.Intent;
import com.stripe.android.link.LinkActivityContract;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/link/LinkActivityContract$Args;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkActivity.kt */
final class LinkActivity$starterArgs$2 extends Lambda implements Function0<LinkActivityContract.Args> {
    final /* synthetic */ LinkActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkActivity$starterArgs$2(LinkActivity linkActivity) {
        super(0);
        this.this$0 = linkActivity;
    }

    public final LinkActivityContract.Args invoke() {
        LinkActivityContract.Args.Companion companion = LinkActivityContract.Args.Companion;
        Intent intent = this.this$0.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return companion.fromIntent$link_release(intent);
    }
}
