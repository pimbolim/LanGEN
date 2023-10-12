package com.stripe.android.networking;

import com.stripe.android.core.model.StripeModel;
import com.stripe.android.core.model.parsers.ModelJsonParser;
import com.stripe.android.core.networking.ApiRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.networking.StripeApiRepository", f = "StripeApiRepository.kt", i = {}, l = {1622}, m = "fetchStripeModel", n = {}, s = {})
/* compiled from: StripeApiRepository.kt */
final class StripeApiRepository$fetchStripeModel$1<ModelType extends StripeModel> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StripeApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeApiRepository$fetchStripeModel$1(StripeApiRepository stripeApiRepository, Continuation<? super StripeApiRepository$fetchStripeModel$1> continuation) {
        super(continuation);
        this.this$0 = stripeApiRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchStripeModel((ApiRequest) null, (ModelJsonParser) null, (Function0<Unit>) null, this);
    }
}
