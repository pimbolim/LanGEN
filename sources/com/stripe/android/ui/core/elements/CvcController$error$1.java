package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/ui/core/elements/FieldError;", "visibleError", "", "fieldState", "Lcom/stripe/android/ui/core/elements/TextFieldState;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.ui.core.elements.CvcController$error$1", f = "CvcController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CvcController.kt */
final class CvcController$error$1 extends SuspendLambda implements Function3<Boolean, TextFieldState, Continuation<? super FieldError>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    CvcController$error$1(Continuation<? super CvcController$error$1> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), (TextFieldState) obj2, (Continuation<? super FieldError>) (Continuation) obj3);
    }

    public final Object invoke(boolean z, TextFieldState textFieldState, Continuation<? super FieldError> continuation) {
        CvcController$error$1 cvcController$error$1 = new CvcController$error$1(continuation);
        cvcController$error$1.Z$0 = z;
        cvcController$error$1.L$0 = textFieldState;
        return cvcController$error$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z = this.Z$0;
            FieldError error = ((TextFieldState) this.L$0).getError();
            if (error != null && z) {
                return error;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
