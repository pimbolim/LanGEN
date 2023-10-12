package com.stripe.android.link.ui.signup;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SignUpScreen.kt */
final class SignUpScreenKt$PhoneCollectionSection$1$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    final /* synthetic */ Function1<String, Unit> $onSignUpClick;
    final /* synthetic */ MutableState<String> $phone$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpScreenKt$PhoneCollectionSection$1$2$1(Function1<? super String, Unit> function1, SoftwareKeyboardController softwareKeyboardController, MutableState<String> mutableState) {
        super(0);
        this.$onSignUpClick = function1;
        this.$keyboardController = softwareKeyboardController;
        this.$phone$delegate = mutableState;
    }

    public final void invoke() {
        this.$onSignUpClick.invoke(SignUpScreenKt.m4340PhoneCollectionSection$lambda4(this.$phone$delegate));
        SoftwareKeyboardController softwareKeyboardController = this.$keyboardController;
        if (softwareKeyboardController != null) {
            softwareKeyboardController.hide();
        }
    }
}
