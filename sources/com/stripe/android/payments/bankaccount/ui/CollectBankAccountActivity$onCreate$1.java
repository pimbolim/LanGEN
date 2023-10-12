package com.stripe.android.payments.bankaccount.ui;

import com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewEffect;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.bankaccount.ui.CollectBankAccountActivity$onCreate$1", f = "CollectBankAccountActivity.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CollectBankAccountActivity.kt */
final class CollectBankAccountActivity$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CollectBankAccountActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectBankAccountActivity$onCreate$1(CollectBankAccountActivity collectBankAccountActivity, Continuation<? super CollectBankAccountActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = collectBankAccountActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectBankAccountActivity$onCreate$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectBankAccountActivity$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<CollectBankAccountViewEffect> viewEffect = this.this$0.getViewModel().getViewEffect();
            final CollectBankAccountActivity collectBankAccountActivity = this.this$0;
            this.label = 1;
            if (viewEffect.collect(new FlowCollector<CollectBankAccountViewEffect>() {
                public final Object emit(CollectBankAccountViewEffect collectBankAccountViewEffect, Continuation<? super Unit> continuation) {
                    if (collectBankAccountViewEffect instanceof CollectBankAccountViewEffect.OpenConnectionsFlow) {
                        collectBankAccountActivity.launch((CollectBankAccountViewEffect.OpenConnectionsFlow) collectBankAccountViewEffect);
                    } else if (collectBankAccountViewEffect instanceof CollectBankAccountViewEffect.FinishWithResult) {
                        collectBankAccountActivity.launch((CollectBankAccountViewEffect.FinishWithResult) collectBankAccountViewEffect);
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
