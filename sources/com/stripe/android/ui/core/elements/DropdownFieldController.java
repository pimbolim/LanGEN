package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0016J\u000e\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\nR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0014\u0010!\u001a\u00020\u001aXD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/stripe/android/ui/core/elements/DropdownFieldController;", "Lcom/stripe/android/ui/core/elements/InputController;", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "config", "Lcom/stripe/android/ui/core/elements/DropdownConfig;", "initialValue", "", "(Lcom/stripe/android/ui/core/elements/DropdownConfig;Ljava/lang/String;)V", "_selectedIndex", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "displayItems", "", "getDisplayItems", "()Ljava/util/List;", "error", "Lkotlinx/coroutines/flow/Flow;", "Lcom/stripe/android/ui/core/elements/FieldError;", "getError", "()Lkotlinx/coroutines/flow/Flow;", "fieldValue", "getFieldValue", "formFieldValue", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getFormFieldValue", "isComplete", "", "label", "getLabel", "rawFieldValue", "getRawFieldValue", "selectedIndex", "getSelectedIndex", "showOptionalLabel", "getShowOptionalLabel", "()Z", "onRawValueChange", "", "rawValue", "onValueChange", "index", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DropdownFieldController.kt */
public final class DropdownFieldController implements InputController, SectionFieldErrorController {
    public static final int $stable = 8;
    private final MutableStateFlow<Integer> _selectedIndex;
    /* access modifiers changed from: private */
    public final DropdownConfig config;
    private final List<String> displayItems;
    private final Flow<FieldError> error;
    private final Flow<String> fieldValue;
    private final Flow<FormFieldEntry> formFieldValue;
    private final Flow<Boolean> isComplete;
    private final Flow<Integer> label;
    private final Flow<String> rawFieldValue;
    private final Flow<Integer> selectedIndex;
    private final boolean showOptionalLabel;

    public DropdownFieldController(DropdownConfig dropdownConfig, String str) {
        Intrinsics.checkNotNullParameter(dropdownConfig, "config");
        this.config = dropdownConfig;
        this.displayItems = dropdownConfig.getDisplayItems();
        MutableStateFlow<Integer> MutableStateFlow = StateFlowKt.MutableStateFlow(0);
        this._selectedIndex = MutableStateFlow;
        Flow<Integer> flow = MutableStateFlow;
        this.selectedIndex = flow;
        this.label = StateFlowKt.MutableStateFlow(Integer.valueOf(dropdownConfig.getLabel()));
        this.fieldValue = new DropdownFieldController$special$$inlined$map$1(flow, this);
        this.rawFieldValue = new DropdownFieldController$special$$inlined$map$2(getFieldValue(), this);
        this.error = StateFlowKt.MutableStateFlow(null);
        this.isComplete = StateFlowKt.MutableStateFlow(true);
        this.formFieldValue = FlowKt.combine(isComplete(), getRawFieldValue(), new DropdownFieldController$formFieldValue$1((Continuation<? super DropdownFieldController$formFieldValue$1>) null));
        if (str != null) {
            onRawValueChange(str);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DropdownFieldController(DropdownConfig dropdownConfig, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dropdownConfig, (i & 2) != 0 ? null : str);
    }

    public final List<String> getDisplayItems() {
        return this.displayItems;
    }

    public final Flow<Integer> getSelectedIndex() {
        return this.selectedIndex;
    }

    public Flow<Integer> getLabel() {
        return this.label;
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

    public final void onValueChange(int i) {
        this._selectedIndex.setValue(Integer.valueOf(i));
    }

    public void onRawValueChange(String str) {
        Intrinsics.checkNotNullParameter(str, "rawValue");
        MutableStateFlow<Integer> mutableStateFlow = this._selectedIndex;
        Integer valueOf = Integer.valueOf(this.displayItems.indexOf(this.config.convertFromRaw(str)));
        int i = 0;
        if (valueOf.intValue() == -1) {
            valueOf = null;
        }
        if (valueOf != null) {
            i = valueOf.intValue();
        }
        mutableStateFlow.setValue(Integer.valueOf(i));
    }
}
