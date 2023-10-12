package com.stripe.android.paymentsheet.forms;

import com.stripe.android.ui.core.elements.FormElement;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.MandateTextElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H@"}, d2 = {"<anonymous>", "", "hiddenIdentifiers", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "formElements", "Lcom/stripe/android/ui/core/elements/FormElement;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.forms.FormViewModel$showingMandate$2", f = "FormViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FormViewModel.kt */
final class FormViewModel$showingMandate$2 extends SuspendLambda implements Function3<List<? extends IdentifierSpec>, List<? extends FormElement>, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    FormViewModel$showingMandate$2(Continuation<? super FormViewModel$showingMandate$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(List<? extends IdentifierSpec> list, List<? extends FormElement> list2, Continuation<? super Boolean> continuation) {
        FormViewModel$showingMandate$2 formViewModel$showingMandate$2 = new FormViewModel$showingMandate$2(continuation);
        formViewModel$showingMandate$2.L$0 = list;
        formViewModel$showingMandate$2.L$1 = list2;
        return formViewModel$showingMandate$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            Collection arrayList = new ArrayList();
            for (Object next : (List) this.L$1) {
                if (next instanceof MandateTextElement) {
                    arrayList.add(next);
                }
            }
            MandateTextElement mandateTextElement = (MandateTextElement) CollectionsKt.firstOrNull((List) arrayList);
            if (mandateTextElement == null) {
                z = false;
            } else {
                z = !list.contains(mandateTextElement.getIdentifier());
            }
            return Boxing.boxBoolean(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
