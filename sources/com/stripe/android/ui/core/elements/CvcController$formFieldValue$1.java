package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.forms.FormFieldEntry;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "complete", "", "value", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.ui.core.elements.CvcController$formFieldValue$1", f = "CvcController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CvcController.kt */
final class CvcController$formFieldValue$1 extends SuspendLambda implements Function3<Boolean, String, Continuation<? super FormFieldEntry>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    CvcController$formFieldValue$1(Continuation<? super CvcController$formFieldValue$1> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), (String) obj2, (Continuation<? super FormFieldEntry>) (Continuation) obj3);
    }

    public final Object invoke(boolean z, String str, Continuation<? super FormFieldEntry> continuation) {
        CvcController$formFieldValue$1 cvcController$formFieldValue$1 = new CvcController$formFieldValue$1(continuation);
        cvcController$formFieldValue$1.Z$0 = z;
        cvcController$formFieldValue$1.L$0 = str;
        return cvcController$formFieldValue$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new FormFieldEntry((String) this.L$0, this.Z$0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
