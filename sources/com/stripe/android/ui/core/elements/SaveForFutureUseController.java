package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0016J\u000e\u0010%\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0006R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000eR\u0014\u0010\u001f\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/stripe/android/ui/core/elements/SaveForFutureUseController;", "Lcom/stripe/android/ui/core/elements/InputController;", "identifiersRequiredForFutureUse", "", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "saveForFutureUseInitialValue", "", "(Ljava/util/List;Z)V", "_saveForFutureUse", "Lkotlinx/coroutines/flow/MutableStateFlow;", "error", "Lkotlinx/coroutines/flow/Flow;", "Lcom/stripe/android/ui/core/elements/FieldError;", "getError", "()Lkotlinx/coroutines/flow/Flow;", "fieldValue", "", "getFieldValue", "formFieldValue", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getFormFieldValue", "hiddenIdentifiers", "getHiddenIdentifiers", "isComplete", "label", "", "getLabel", "rawFieldValue", "getRawFieldValue", "saveForFutureUse", "getSaveForFutureUse", "showOptionalLabel", "getShowOptionalLabel", "()Z", "onRawValueChange", "", "rawValue", "onValueChange", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SaveForFutureUseController.kt */
public final class SaveForFutureUseController implements InputController {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _saveForFutureUse;
    private final Flow<FieldError> error;
    private final Flow<String> fieldValue;
    private final Flow<FormFieldEntry> formFieldValue;
    private final Flow<List<IdentifierSpec>> hiddenIdentifiers;
    private final Flow<Boolean> isComplete;
    private final Flow<Integer> label;
    private final Flow<String> rawFieldValue;
    private final Flow<Boolean> saveForFutureUse;
    private final boolean showOptionalLabel;

    public SaveForFutureUseController(List<? extends IdentifierSpec> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "identifiersRequiredForFutureUse");
        this.label = StateFlowKt.MutableStateFlow(Integer.valueOf(R.string.save_for_future_payments_with_merchant_name));
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.valueOf(z));
        this._saveForFutureUse = MutableStateFlow;
        Flow<Boolean> flow = MutableStateFlow;
        this.saveForFutureUse = flow;
        this.fieldValue = new SaveForFutureUseController$special$$inlined$map$1(flow);
        this.rawFieldValue = getFieldValue();
        this.error = StateFlowKt.MutableStateFlow(null);
        this.isComplete = StateFlowKt.MutableStateFlow(true);
        this.formFieldValue = FlowKt.combine(isComplete(), getRawFieldValue(), new SaveForFutureUseController$formFieldValue$1((Continuation<? super SaveForFutureUseController$formFieldValue$1>) null));
        this.hiddenIdentifiers = new SaveForFutureUseController$special$$inlined$map$2(flow, list);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaveForFutureUseController(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, z);
    }

    public Flow<Integer> getLabel() {
        return this.label;
    }

    public final Flow<Boolean> getSaveForFutureUse() {
        return this.saveForFutureUse;
    }

    public Flow<String> getFieldValue() {
        return this.fieldValue;
    }

    public Flow<String> getRawFieldValue() {
        return this.rawFieldValue;
    }

    public Flow<FieldError> getError() {
        return this.error;
    }

    public boolean getShowOptionalLabel() {
        return this.showOptionalLabel;
    }

    public Flow<Boolean> isComplete() {
        return this.isComplete;
    }

    public Flow<FormFieldEntry> getFormFieldValue() {
        return this.formFieldValue;
    }

    public final Flow<List<IdentifierSpec>> getHiddenIdentifiers() {
        return this.hiddenIdentifiers;
    }

    public final void onValueChange(boolean z) {
        this._saveForFutureUse.setValue(Boolean.valueOf(z));
    }

    public void onRawValueChange(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(str);
        onValueChange(booleanStrictOrNull == null ? true : booleanStrictOrNull.booleanValue());
    }
}
