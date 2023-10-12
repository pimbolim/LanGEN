package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\b\u0007\b\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "Lcom/stripe/android/ui/core/elements/Controller;", "error", "Lkotlinx/coroutines/flow/Flow;", "Lcom/stripe/android/ui/core/elements/FieldError;", "getError", "()Lkotlinx/coroutines/flow/Flow;", "Lcom/stripe/android/ui/core/elements/AddressController;", "Lcom/stripe/android/ui/core/elements/CardDetailsController;", "Lcom/stripe/android/ui/core/elements/CardNumberController;", "Lcom/stripe/android/ui/core/elements/CvcController;", "Lcom/stripe/android/ui/core/elements/DropdownFieldController;", "Lcom/stripe/android/ui/core/elements/InputController;", "Lcom/stripe/android/ui/core/elements/RowController;", "Lcom/stripe/android/ui/core/elements/SimpleTextFieldController;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionFieldErrorController.kt */
public interface SectionFieldErrorController extends Controller {
    Flow<FieldError> getError();
}
