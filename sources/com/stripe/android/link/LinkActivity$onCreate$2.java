package com.stripe.android.link;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkActivity.kt */
/* synthetic */ class LinkActivity$onCreate$2 extends FunctionReferenceImpl implements Function1<LinkActivityResult, Unit> {
    LinkActivity$onCreate$2(Object obj) {
        super(1, obj, LinkActivity.class, "dismiss", "dismiss(Lcom/stripe/android/link/LinkActivityResult;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LinkActivityResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LinkActivityResult linkActivityResult) {
        Intrinsics.checkNotNullParameter(linkActivityResult, "p0");
        ((LinkActivity) this.receiver).dismiss(linkActivityResult);
    }
}
