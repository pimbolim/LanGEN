package com.stripe.android.link.ui.verification;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VerificationScreen.kt */
final class VerificationScreenKt$VerificationCodeInput$1$1$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ MutableState<String> $code$delegate;
    final /* synthetic */ Function1<String, Unit> $onCodeEntered;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerificationScreenKt$VerificationCodeInput$1$1$1$1(Function1<? super String, Unit> function1, MutableState<String> mutableState) {
        super(1);
        this.$onCodeEntered = function1;
        this.$code$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        VerificationScreenKt.m4349VerificationCodeInput$lambda4(this.$code$delegate, str);
        if (VerificationScreenKt.m4348VerificationCodeInput$lambda3(this.$code$delegate).length() == 6) {
            this.$onCodeEntered.invoke(VerificationScreenKt.m4348VerificationCodeInput$lambda3(this.$code$delegate));
        }
    }
}
