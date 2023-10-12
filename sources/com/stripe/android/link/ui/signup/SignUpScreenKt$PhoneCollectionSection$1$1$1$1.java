package com.stripe.android.link.ui.signup;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SignUpScreen.kt */
final class SignUpScreenKt$PhoneCollectionSection$1$1$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ MutableState<String> $phone$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpScreenKt$PhoneCollectionSection$1$1$1$1(MutableState<String> mutableState) {
        super(1);
        this.$phone$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        SignUpScreenKt.m4341PhoneCollectionSection$lambda5(this.$phone$delegate, str);
    }
}
