package com.stripe.android.paymentsheet.forms;

import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.SaveForFutureUseElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@"}, d2 = {"<anonymous>", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "showFutureUse", "", "saveFutureUseIdentifiers", "cardBillingIdentifiers"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.forms.FormViewModel$hiddenIdentifiers$3", f = "FormViewModel.kt", i = {0, 0, 0}, l = {157}, m = "invokeSuspend", n = {"hiddenIdentifiers", "identifiers", "showFutureUse"}, s = {"L$0", "L$1", "Z$0"})
/* compiled from: FormViewModel.kt */
final class FormViewModel$hiddenIdentifiers$3 extends SuspendLambda implements Function4<Boolean, List<? extends IdentifierSpec>, List<? extends IdentifierSpec>, Continuation<? super List<? extends IdentifierSpec>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ FormViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FormViewModel$hiddenIdentifiers$3(FormViewModel formViewModel, Continuation<? super FormViewModel$hiddenIdentifiers$3> continuation) {
        super(4, continuation);
        this.this$0 = formViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke(((Boolean) obj).booleanValue(), (List<? extends IdentifierSpec>) (List) obj2, (List<? extends IdentifierSpec>) (List) obj3, (Continuation<? super List<? extends IdentifierSpec>>) (Continuation) obj4);
    }

    public final Object invoke(boolean z, List<? extends IdentifierSpec> list, List<? extends IdentifierSpec> list2, Continuation<? super List<? extends IdentifierSpec>> continuation) {
        FormViewModel$hiddenIdentifiers$3 formViewModel$hiddenIdentifiers$3 = new FormViewModel$hiddenIdentifiers$3(this.this$0, continuation);
        formViewModel$hiddenIdentifiers$3.Z$0 = z;
        formViewModel$hiddenIdentifiers$3.L$0 = list;
        formViewModel$hiddenIdentifiers$3.L$1 = list2;
        return formViewModel$hiddenIdentifiers$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list;
        List list2;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z2 = this.Z$0;
            List plus = CollectionsKt.plus((List) this.L$0, (List) this.L$1);
            Map access$getSectionToFieldIdentifierMap$p = this.this$0.sectionToFieldIdentifierMap;
            Map linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : access$getSectionToFieldIdentifierMap$p.entrySet()) {
                if (plus.contains(entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Collection arrayList = new ArrayList();
            for (Map.Entry value : linkedHashMap.entrySet()) {
                CollectionsKt.addAll(arrayList, (List) value.getValue());
            }
            List list3 = (List) arrayList;
            this.L$0 = plus;
            this.L$1 = list3;
            this.Z$0 = z2;
            this.label = 1;
            Object firstOrNull = FlowKt.firstOrNull(this.this$0.saveForFutureUseElement, this);
            if (firstOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            z = z2;
            obj = firstOrNull;
            list = plus;
            list2 = list3;
        } else if (i == 1) {
            z = this.Z$0;
            list2 = (List) this.L$1;
            list = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SaveForFutureUseElement saveForFutureUseElement = (SaveForFutureUseElement) obj;
        if (z || saveForFutureUseElement == null) {
            return CollectionsKt.plus(list, list2);
        }
        return CollectionsKt.plus(CollectionsKt.plus(list, list2), saveForFutureUseElement.getIdentifier());
    }
}
