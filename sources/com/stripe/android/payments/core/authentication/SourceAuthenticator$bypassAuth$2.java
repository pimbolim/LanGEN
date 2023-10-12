package com.stripe.android.payments.core.authentication;

import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.model.Source;
import com.stripe.android.view.AuthActivityStarterHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.core.authentication.SourceAuthenticator$bypassAuth$2", f = "SourceAuthenticator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SourceAuthenticator.kt */
final class SourceAuthenticator$bypassAuth$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthActivityStarterHost $host;
    final /* synthetic */ Source $source;
    final /* synthetic */ String $stripeAccountId;
    int label;
    final /* synthetic */ SourceAuthenticator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SourceAuthenticator$bypassAuth$2(SourceAuthenticator sourceAuthenticator, AuthActivityStarterHost authActivityStarterHost, Source source, String str, Continuation<SourceAuthenticator$bypassAuth$2> continuation) {
        super(2, continuation);
        this.this$0 = sourceAuthenticator;
        this.$host = authActivityStarterHost;
        this.$source = source;
        this.$stripeAccountId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SourceAuthenticator$bypassAuth$2(this.this$0, this.$host, this.$source, this.$stripeAccountId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Unit> continuation) {
        return ((SourceAuthenticator$bypassAuth$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ((PaymentRelayStarter) this.this$0.paymentRelayStarterFactory.invoke(this.$host)).start(new PaymentRelayStarter.Args.SourceArgs(this.$source, this.$stripeAccountId));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
