package com.stripe.android.paymentsheet.forms;

import com.stripe.android.ui.core.elements.IdentifierSpec;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "hiddenIds", "", "textFieldControllerIds"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.forms.FormViewModel$lastTextFieldIdentifier$1", f = "FormViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FormViewModel.kt */
final class FormViewModel$lastTextFieldIdentifier$1 extends SuspendLambda implements Function3<List<? extends IdentifierSpec>, List<? extends IdentifierSpec>, Continuation<? super IdentifierSpec>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    FormViewModel$lastTextFieldIdentifier$1(Continuation<? super FormViewModel$lastTextFieldIdentifier$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(List<? extends IdentifierSpec> list, List<? extends IdentifierSpec> list2, Continuation<? super IdentifierSpec> continuation) {
        FormViewModel$lastTextFieldIdentifier$1 formViewModel$lastTextFieldIdentifier$1 = new FormViewModel$lastTextFieldIdentifier$1(continuation);
        formViewModel$lastTextFieldIdentifier$1.L$0 = list;
        formViewModel$lastTextFieldIdentifier$1.L$1 = list2;
        return formViewModel$lastTextFieldIdentifier$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            List list2 = (List) this.L$1;
            ListIterator listIterator = list2.listIterator(list2.size());
            while (listIterator.hasPrevious()) {
                Object previous = listIterator.previous();
                if (!list.contains((IdentifierSpec) previous)) {
                    return previous;
                }
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
