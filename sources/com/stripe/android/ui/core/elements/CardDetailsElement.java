package com.stripe.android.ui.core.elements;

import android.content.Context;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\fH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/ui/core/elements/CardDetailsElement;", "Lcom/stripe/android/ui/core/elements/SectionMultiFieldElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "context", "Landroid/content/Context;", "controller", "Lcom/stripe/android/ui/core/elements/CardDetailsController;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Landroid/content/Context;Lcom/stripe/android/ui/core/elements/CardDetailsController;)V", "getController", "()Lcom/stripe/android/ui/core/elements/CardDetailsController;", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getTextFieldIdentifiers", "sectionFieldErrorController", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "setRawValue", "", "rawValuesMap", "", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardDetailsElement.kt */
public final class CardDetailsElement extends SectionMultiFieldElement {
    private final CardDetailsController controller;

    public void setRawValue(Map<IdentifierSpec, String> map) {
        Intrinsics.checkNotNullParameter(map, "rawValuesMap");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardDetailsElement(IdentifierSpec identifierSpec, Context context, CardDetailsController cardDetailsController, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec, context, (i & 4) != 0 ? new CardDetailsController(context) : cardDetailsController);
    }

    public final CardDetailsController getController() {
        return this.controller;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardDetailsElement(IdentifierSpec identifierSpec, Context context, CardDetailsController cardDetailsController) {
        super(identifierSpec, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardDetailsController, "controller");
        this.controller = cardDetailsController;
    }

    public SectionFieldErrorController sectionFieldErrorController() {
        return this.controller;
    }

    public Flow<List<IdentifierSpec>> getTextFieldIdentifiers() {
        return StateFlowKt.MutableStateFlow(CollectionsKt.listOf(this.controller.getNumberElement().getIdentifier(), this.controller.getExpirationDateElement().getIdentifier(), this.controller.getCvcElement().getIdentifier()));
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        return FlowKt.combine(this.controller.getNumberElement().getController().getFormFieldValue(), this.controller.getCvcElement().getController().getFormFieldValue(), this.controller.getExpirationDateElement().getController().getFormFieldValue(), this.controller.getNumberElement().getController().getCardBrandFlow$payments_ui_core_release(), new CardDetailsElement$getFormFieldValueFlow$1(this, (Continuation<? super CardDetailsElement$getFormFieldValueFlow$1>) null));
    }
}
