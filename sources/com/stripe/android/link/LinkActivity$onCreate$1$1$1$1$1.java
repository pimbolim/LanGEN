package com.stripe.android.link;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkActivity.kt */
final class LinkActivity$onCreate$1$1$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LinkActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkActivity$onCreate$1$1$1$1$1(LinkActivity linkActivity) {
        super(0);
        this.this$0 = linkActivity;
    }

    public final void invoke() {
        LinkActivity.dismiss$default(this.this$0, (LinkActivityResult) null, 1, (Object) null);
    }
}
