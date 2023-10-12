package com.stripe.android.link.ui.verification;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VerificationScreen.kt */
/* synthetic */ class VerificationScreenKt$VerificationBody$4 extends FunctionReferenceImpl implements Function0<Unit> {
    VerificationScreenKt$VerificationBody$4(Object obj) {
        super(0, obj, VerificationViewModel.class, "onResendCodeClicked", "onResendCodeClicked()V", 0);
    }

    public final void invoke() {
        ((VerificationViewModel) this.receiver).onResendCodeClicked();
    }
}
