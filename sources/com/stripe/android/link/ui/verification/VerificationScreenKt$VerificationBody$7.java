package com.stripe.android.link.ui.verification;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VerificationScreen.kt */
final class VerificationScreenKt$VerificationBody$7 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ String $email;
    final /* synthetic */ Function0<Unit> $onBack;
    final /* synthetic */ Function0<Unit> $onChangeEmailClick;
    final /* synthetic */ Function1<String, Unit> $onCodeEntered;
    final /* synthetic */ Function0<Unit> $onResendCodeClick;
    final /* synthetic */ String $redactedPhoneNumber;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerificationScreenKt$VerificationBody$7(String str, String str2, Function1<? super String, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, int i) {
        super(2);
        this.$redactedPhoneNumber = str;
        this.$email = str2;
        this.$onCodeEntered = function1;
        this.$onBack = function0;
        this.$onChangeEmailClick = function02;
        this.$onResendCodeClick = function03;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        VerificationScreenKt.VerificationBody(this.$redactedPhoneNumber, this.$email, this.$onCodeEntered, this.$onBack, this.$onChangeEmailClick, this.$onResendCodeClick, composer, this.$$changed | 1);
    }
}
