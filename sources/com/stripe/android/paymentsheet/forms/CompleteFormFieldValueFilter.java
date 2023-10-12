package com.stripe.android.paymentsheet.forms;

import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BO\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0002\u0010\rJ\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0003J<\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R \u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/paymentsheet/forms/CompleteFormFieldValueFilter;", "", "currentFieldValueMap", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "hiddenIdentifiers", "", "showingMandate", "", "userRequestedReuse", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$CustomerRequestedSave;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)V", "getShowingMandate", "()Lkotlinx/coroutines/flow/Flow;", "filterFlow", "Lcom/stripe/android/paymentsheet/forms/FormFieldValues;", "idFieldSnapshotMap", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CompleteFormFieldValueFilter.kt */
public final class CompleteFormFieldValueFilter {
    private final Flow<Map<IdentifierSpec, FormFieldEntry>> currentFieldValueMap;
    private final Flow<List<IdentifierSpec>> hiddenIdentifiers;
    private final Flow<Boolean> showingMandate;
    private final Flow<PaymentSelection.CustomerRequestedSave> userRequestedReuse;

    public CompleteFormFieldValueFilter(Flow<? extends Map<IdentifierSpec, FormFieldEntry>> flow, Flow<? extends List<? extends IdentifierSpec>> flow2, Flow<Boolean> flow3, Flow<? extends PaymentSelection.CustomerRequestedSave> flow4) {
        Intrinsics.checkNotNullParameter(flow, "currentFieldValueMap");
        Intrinsics.checkNotNullParameter(flow2, "hiddenIdentifiers");
        Intrinsics.checkNotNullParameter(flow3, "showingMandate");
        Intrinsics.checkNotNullParameter(flow4, "userRequestedReuse");
        this.currentFieldValueMap = flow;
        this.hiddenIdentifiers = flow2;
        this.showingMandate = flow3;
        this.userRequestedReuse = flow4;
    }

    public final Flow<Boolean> getShowingMandate() {
        return this.showingMandate;
    }

    public final Flow<FormFieldValues> filterFlow() {
        return FlowKt.combine(this.currentFieldValueMap, this.hiddenIdentifiers, this.showingMandate, this.userRequestedReuse, new CompleteFormFieldValueFilter$filterFlow$1(this, (Continuation<? super CompleteFormFieldValueFilter$filterFlow$1>) null));
    }

    /* access modifiers changed from: private */
    public final FormFieldValues filterFlow(Map<IdentifierSpec, FormFieldEntry> map, List<? extends IdentifierSpec> list, boolean z, PaymentSelection.CustomerRequestedSave customerRequestedSave) {
        boolean z2;
        Map linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<IdentifierSpec, FormFieldEntry>> it = map.entrySet().iterator();
        while (true) {
            z2 = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            if (true ^ list.contains(next.getKey())) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        FormFieldValues formFieldValues = new FormFieldValues(linkedHashMap, z, customerRequestedSave);
        Iterable<FormFieldEntry> values = linkedHashMap.values();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        for (FormFieldEntry isComplete : values) {
            arrayList.add(Boolean.valueOf(isComplete.isComplete()));
        }
        Iterable iterable = (List) arrayList;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it2 = iterable.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!((Boolean) it2.next()).booleanValue()) {
                        z2 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z2) {
            return formFieldValues;
        }
        return null;
    }
}
