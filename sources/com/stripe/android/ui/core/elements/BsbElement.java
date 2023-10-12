package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import com.stripe.android.view.BecsDebitBanks;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\u0018\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a0\u00190\u00050\tH\u0016R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/ui/core/elements/BsbElement;", "Lcom/stripe/android/ui/core/elements/FormElement;", "identifierSpec", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "banks", "", "Lcom/stripe/android/view/BecsDebitBanks$Bank;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Ljava/util/List;)V", "bankName", "Lkotlinx/coroutines/flow/Flow;", "", "getBankName", "()Lkotlinx/coroutines/flow/Flow;", "controller", "Lcom/stripe/android/ui/core/elements/Controller;", "getController", "()Lcom/stripe/android/ui/core/elements/Controller;", "identifier", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "textElement", "Lcom/stripe/android/ui/core/elements/SimpleTextElement;", "getTextElement$payments_ui_core_release", "()Lcom/stripe/android/ui/core/elements/SimpleTextElement;", "getFormFieldValueFlow", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BsbElement.kt */
public final class BsbElement extends FormElement {
    public static final int $stable = 8;
    private final Flow<String> bankName;
    /* access modifiers changed from: private */
    public final List<BecsDebitBanks.Bank> banks;
    private final IdentifierSpec identifierSpec;
    private final SimpleTextElement textElement;

    public Controller getController() {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BsbElement(IdentifierSpec identifierSpec2, List<BecsDebitBanks.Bank> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec2, "identifierSpec");
        Intrinsics.checkNotNullParameter(list, "banks");
        this.identifierSpec = identifierSpec2;
        this.banks = list;
        SimpleTextElement simpleTextElement = new SimpleTextElement(new IdentifierSpec.Generic("bsb_number"), new SimpleTextFieldController(new BsbConfig(list), false, (String) null, 6, (DefaultConstructorMarker) null));
        this.textElement = simpleTextElement;
        this.bankName = new BsbElement$special$$inlined$map$1(simpleTextElement.getController().getFieldValue(), this);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifierSpec;
    }

    public final SimpleTextElement getTextElement$payments_ui_core_release() {
        return this.textElement;
    }

    public final Flow<String> getBankName() {
        return this.bankName;
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        return FlowKt.combine(this.textElement.getController().isComplete(), this.textElement.getController().getFieldValue(), new BsbElement$getFormFieldValueFlow$1(this, (Continuation<? super BsbElement$getFormFieldValueFlow$1>) null));
    }
}
