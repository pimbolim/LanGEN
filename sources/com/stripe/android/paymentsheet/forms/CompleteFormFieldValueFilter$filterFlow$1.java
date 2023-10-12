package com.stripe.android.paymentsheet.forms;

import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH@"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/forms/FormFieldValues;", "idFieldSnapshotMap", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "hiddenIdentifiers", "", "showingMandate", "", "userRequestedReuse", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.forms.CompleteFormFieldValueFilter$filterFlow$1", f = "CompleteFormFieldValueFilter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CompleteFormFieldValueFilter.kt */
final class CompleteFormFieldValueFilter$filterFlow$1 extends SuspendLambda implements Function5<Map<IdentifierSpec, ? extends FormFieldEntry>, List<? extends IdentifierSpec>, Boolean, PaymentSelection.CustomerRequestedSave, Continuation<? super FormFieldValues>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ CompleteFormFieldValueFilter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CompleteFormFieldValueFilter$filterFlow$1(CompleteFormFieldValueFilter completeFormFieldValueFilter, Continuation<? super CompleteFormFieldValueFilter$filterFlow$1> continuation) {
        super(5, continuation);
        this.this$0 = completeFormFieldValueFilter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke((Map<IdentifierSpec, FormFieldEntry>) (Map) obj, (List<? extends IdentifierSpec>) (List) obj2, ((Boolean) obj3).booleanValue(), (PaymentSelection.CustomerRequestedSave) obj4, (Continuation<? super FormFieldValues>) (Continuation) obj5);
    }

    public final Object invoke(Map<IdentifierSpec, FormFieldEntry> map, List<? extends IdentifierSpec> list, boolean z, PaymentSelection.CustomerRequestedSave customerRequestedSave, Continuation<? super FormFieldValues> continuation) {
        CompleteFormFieldValueFilter$filterFlow$1 completeFormFieldValueFilter$filterFlow$1 = new CompleteFormFieldValueFilter$filterFlow$1(this.this$0, continuation);
        completeFormFieldValueFilter$filterFlow$1.L$0 = map;
        completeFormFieldValueFilter$filterFlow$1.L$1 = list;
        completeFormFieldValueFilter$filterFlow$1.Z$0 = z;
        completeFormFieldValueFilter$filterFlow$1.L$2 = customerRequestedSave;
        return completeFormFieldValueFilter$filterFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.filterFlow((Map) this.L$0, (List) this.L$1, this.Z$0, (PaymentSelection.CustomerRequestedSave) this.L$2);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
