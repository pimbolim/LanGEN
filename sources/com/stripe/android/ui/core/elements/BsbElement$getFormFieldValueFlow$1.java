package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "complete", "", "fieldValue", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.ui.core.elements.BsbElement$getFormFieldValueFlow$1", f = "BsbElement.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BsbElement.kt */
final class BsbElement$getFormFieldValueFlow$1 extends SuspendLambda implements Function3<Boolean, String, Continuation<? super List<? extends Pair<? extends IdentifierSpec, ? extends FormFieldEntry>>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ BsbElement this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BsbElement$getFormFieldValueFlow$1(BsbElement bsbElement, Continuation<? super BsbElement$getFormFieldValueFlow$1> continuation) {
        super(3, continuation);
        this.this$0 = bsbElement;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), (String) obj2, (Continuation<? super List<? extends Pair<? extends IdentifierSpec, FormFieldEntry>>>) (Continuation) obj3);
    }

    public final Object invoke(boolean z, String str, Continuation<? super List<? extends Pair<? extends IdentifierSpec, FormFieldEntry>>> continuation) {
        BsbElement$getFormFieldValueFlow$1 bsbElement$getFormFieldValueFlow$1 = new BsbElement$getFormFieldValueFlow$1(this.this$0, continuation);
        bsbElement$getFormFieldValueFlow$1.Z$0 = z;
        bsbElement$getFormFieldValueFlow$1.L$0 = str;
        return bsbElement$getFormFieldValueFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return CollectionsKt.listOf(TuplesKt.to(this.this$0.getIdentifier(), new FormFieldEntry((String) this.L$0, this.Z$0)));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
