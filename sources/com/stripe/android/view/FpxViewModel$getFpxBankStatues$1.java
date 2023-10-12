package com.stripe.android.view;

import androidx.lifecycle.LiveDataScope;
import com.stripe.android.model.BankStatuses;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Lcom/stripe/android/model/BankStatuses;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.view.FpxViewModel$getFpxBankStatues$1", f = "FpxViewModel.kt", i = {}, l = {25, 23}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FpxViewModel.kt */
final class FpxViewModel$getFpxBankStatues$1 extends SuspendLambda implements Function2<LiveDataScope<BankStatuses>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FpxViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FpxViewModel$getFpxBankStatues$1(FpxViewModel fpxViewModel, Continuation<? super FpxViewModel$getFpxBankStatues$1> continuation) {
        super(2, continuation);
        this.this$0 = fpxViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FpxViewModel$getFpxBankStatues$1 fpxViewModel$getFpxBankStatues$1 = new FpxViewModel$getFpxBankStatues$1(this.this$0, continuation);
        fpxViewModel$getFpxBankStatues$1.L$0 = obj;
        return fpxViewModel$getFpxBankStatues$1;
    }

    public final Object invoke(LiveDataScope<BankStatuses> liveDataScope, Continuation<? super Unit> continuation) {
        return ((FpxViewModel$getFpxBankStatues$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: com.stripe.android.model.BankStatuses} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.lifecycle.LiveDataScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0078
        L_0x0012:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001a:
            java.lang.Object r1 = r12.L$0
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ all -> 0x0052 }
            goto L_0x004b
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r1 = r13
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            com.stripe.android.view.FpxViewModel r13 = r12.this$0
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0052 }
            com.stripe.android.networking.StripeRepository r4 = r13.stripeRepository     // Catch:{ all -> 0x0052 }
            com.stripe.android.core.networking.ApiRequest$Options r11 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0052 }
            java.lang.String r6 = r13.publishableKey     // Catch:{ all -> 0x0052 }
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r11
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0052 }
            r12.L$0 = r1     // Catch:{ all -> 0x0052 }
            r12.label = r3     // Catch:{ all -> 0x0052 }
            java.lang.Object r13 = r4.getFpxBankStatus$payments_core_release(r11, r12)     // Catch:{ all -> 0x0052 }
            if (r13 != r0) goto L_0x004b
            return r0
        L_0x004b:
            com.stripe.android.model.BankStatuses r13 = (com.stripe.android.model.BankStatuses) r13     // Catch:{ all -> 0x0052 }
            java.lang.Object r13 = kotlin.Result.m4709constructorimpl(r13)     // Catch:{ all -> 0x0052 }
            goto L_0x005d
        L_0x0052:
            r13 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.ResultKt.createFailure(r13)
            java.lang.Object r13 = kotlin.Result.m4709constructorimpl(r13)
        L_0x005d:
            com.stripe.android.model.BankStatuses r4 = new com.stripe.android.model.BankStatuses
            r5 = 0
            r4.<init>(r5, r3, r5)
            boolean r3 = kotlin.Result.m4715isFailureimpl(r13)
            if (r3 == 0) goto L_0x006a
            r13 = r4
        L_0x006a:
            r3 = r12
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r12.L$0 = r5
            r12.label = r2
            java.lang.Object r13 = r1.emit(r13, r3)
            if (r13 != r0) goto L_0x0078
            return r0
        L_0x0078:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.FpxViewModel$getFpxBankStatues$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
