package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.forms.FormFieldEntry;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0012\u0010\u0011\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0001\u0003\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/ui/core/elements/InputController;", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "fieldValue", "Lkotlinx/coroutines/flow/Flow;", "", "getFieldValue", "()Lkotlinx/coroutines/flow/Flow;", "formFieldValue", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getFormFieldValue", "isComplete", "", "label", "", "getLabel", "rawFieldValue", "getRawFieldValue", "showOptionalLabel", "getShowOptionalLabel", "()Z", "onRawValueChange", "", "rawValue", "Lcom/stripe/android/ui/core/elements/DropdownFieldController;", "Lcom/stripe/android/ui/core/elements/SaveForFutureUseController;", "Lcom/stripe/android/ui/core/elements/TextFieldController;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InputController.kt */
public interface InputController extends SectionFieldErrorController {
    Flow<String> getFieldValue();

    Flow<FormFieldEntry> getFormFieldValue();

    Flow<Integer> getLabel();

    Flow<String> getRawFieldValue();

    boolean getShowOptionalLabel();

    Flow<Boolean> isComplete();

    void onRawValueChange(String str);
}
