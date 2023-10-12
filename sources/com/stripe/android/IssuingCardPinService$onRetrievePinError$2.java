package com.stripe.android;

import com.stripe.android.IssuingCardPinService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.IssuingCardPinService$onRetrievePinError$2", f = "IssuingCardPinService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IssuingCardPinService.kt */
final class IssuingCardPinService$onRetrievePinError$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IssuingCardPinService.IssuingCardPinRetrievalListener $listener;
    final /* synthetic */ Throwable $throwable;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IssuingCardPinService$onRetrievePinError$2(Throwable th, IssuingCardPinService.IssuingCardPinRetrievalListener issuingCardPinRetrievalListener, Continuation<? super IssuingCardPinService$onRetrievePinError$2> continuation) {
        super(2, continuation);
        this.$throwable = th;
        this.$listener = issuingCardPinRetrievalListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IssuingCardPinService$onRetrievePinError$2(this.$throwable, this.$listener, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IssuingCardPinService$onRetrievePinError$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r3.label
            if (r0 != 0) goto L_0x008f
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.Throwable r4 = r3.$throwable
            boolean r0 = r4 instanceof com.stripe.android.core.exception.InvalidRequestException
            if (r0 == 0) goto L_0x0081
            com.stripe.android.core.exception.InvalidRequestException r4 = (com.stripe.android.core.exception.InvalidRequestException) r4
            com.stripe.android.core.StripeError r4 = r4.getStripeError()
            r0 = 0
            if (r4 != 0) goto L_0x001b
            r4 = r0
            goto L_0x001f
        L_0x001b:
            java.lang.String r4 = r4.getCode()
        L_0x001f:
            if (r4 == 0) goto L_0x0075
            int r1 = r4.hashCode()
            switch(r1) {
                case -1309235419: goto L_0x0062;
                case -1266028985: goto L_0x004f;
                case 830217595: goto L_0x003c;
                case 1888170818: goto L_0x0029;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x0075
        L_0x0029:
            java.lang.String r1 = "already_redeemed"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0032
            goto L_0x0075
        L_0x0032:
            com.stripe.android.IssuingCardPinService$IssuingCardPinRetrievalListener r4 = r3.$listener
            com.stripe.android.IssuingCardPinService$CardPinActionError r1 = com.stripe.android.IssuingCardPinService.CardPinActionError.ONE_TIME_CODE_ALREADY_REDEEMED
            java.lang.String r2 = "The verification challenge was already redeemed."
            r4.onError(r1, r2, r0)
            goto L_0x008c
        L_0x003c:
            java.lang.String r1 = "too_many_attempts"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0045
            goto L_0x0075
        L_0x0045:
            com.stripe.android.IssuingCardPinService$IssuingCardPinRetrievalListener r4 = r3.$listener
            com.stripe.android.IssuingCardPinService$CardPinActionError r1 = com.stripe.android.IssuingCardPinService.CardPinActionError.ONE_TIME_CODE_TOO_MANY_ATTEMPTS
            java.lang.String r2 = "The verification challenge was attempted too many times."
            r4.onError(r1, r2, r0)
            goto L_0x008c
        L_0x004f:
            java.lang.String r1 = "incorrect_code"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0058
            goto L_0x0075
        L_0x0058:
            com.stripe.android.IssuingCardPinService$IssuingCardPinRetrievalListener r4 = r3.$listener
            com.stripe.android.IssuingCardPinService$CardPinActionError r1 = com.stripe.android.IssuingCardPinService.CardPinActionError.ONE_TIME_CODE_INCORRECT
            java.lang.String r2 = "The one-time code was incorrect."
            r4.onError(r1, r2, r0)
            goto L_0x008c
        L_0x0062:
            java.lang.String r1 = "expired"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x006b
            goto L_0x0075
        L_0x006b:
            com.stripe.android.IssuingCardPinService$IssuingCardPinRetrievalListener r4 = r3.$listener
            com.stripe.android.IssuingCardPinService$CardPinActionError r1 = com.stripe.android.IssuingCardPinService.CardPinActionError.ONE_TIME_CODE_EXPIRED
            java.lang.String r2 = "The one-time code has expired"
            r4.onError(r1, r2, r0)
            goto L_0x008c
        L_0x0075:
            com.stripe.android.IssuingCardPinService$IssuingCardPinRetrievalListener r4 = r3.$listener
            com.stripe.android.IssuingCardPinService$CardPinActionError r0 = com.stripe.android.IssuingCardPinService.CardPinActionError.UNKNOWN_ERROR
            java.lang.Throwable r1 = r3.$throwable
            java.lang.String r2 = "The call to retrieve the PIN failed, possibly an error with the verification."
            r4.onError(r0, r2, r1)
            goto L_0x008c
        L_0x0081:
            com.stripe.android.IssuingCardPinService$IssuingCardPinRetrievalListener r4 = r3.$listener
            com.stripe.android.IssuingCardPinService$CardPinActionError r0 = com.stripe.android.IssuingCardPinService.CardPinActionError.UNKNOWN_ERROR
            java.lang.Throwable r1 = r3.$throwable
            java.lang.String r2 = "An error occurred while retrieving the PIN."
            r4.onError(r0, r2, r1)
        L_0x008c:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x008f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.IssuingCardPinService$onRetrievePinError$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
