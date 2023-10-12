package com.stripe.android.ui.core.elements;

import com.brentvatne.react.ReactVideoView;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J \u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u00150\u00140\u0013H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/ui/core/elements/EmptyFormElement;", "Lcom/stripe/android/ui/core/elements/FormElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "controller", "Lcom/stripe/android/ui/core/elements/Controller;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Lcom/stripe/android/ui/core/elements/Controller;)V", "getController", "()Lcom/stripe/android/ui/core/elements/Controller;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "component1", "component2", "copy", "equals", "", "other", "", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "hashCode", "", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmptyFormElement.kt */
public final class EmptyFormElement extends FormElement {
    public static final int $stable = 8;
    private final Controller controller;
    private final IdentifierSpec identifier;

    public EmptyFormElement() {
        this((IdentifierSpec) null, (Controller) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ EmptyFormElement copy$default(EmptyFormElement emptyFormElement, IdentifierSpec identifierSpec, Controller controller2, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = emptyFormElement.getIdentifier();
        }
        if ((i & 2) != 0) {
            controller2 = emptyFormElement.getController();
        }
        return emptyFormElement.copy(identifierSpec, controller2);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final Controller component2() {
        return getController();
    }

    public final EmptyFormElement copy(IdentifierSpec identifierSpec, Controller controller2) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new EmptyFormElement(identifierSpec, controller2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmptyFormElement)) {
            return false;
        }
        EmptyFormElement emptyFormElement = (EmptyFormElement) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) emptyFormElement.getIdentifier()) && Intrinsics.areEqual((Object) getController(), (Object) emptyFormElement.getController());
    }

    public int hashCode() {
        return (getIdentifier().hashCode() * 31) + (getController() == null ? 0 : getController().hashCode());
    }

    public String toString() {
        return "EmptyFormElement(identifier=" + getIdentifier() + ", controller=" + getController() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmptyFormElement(IdentifierSpec identifierSpec, Controller controller2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new IdentifierSpec.Generic("empty_form") : identifierSpec, (i & 2) != 0 ? null : controller2);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public Controller getController() {
        return this.controller;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmptyFormElement(IdentifierSpec identifierSpec, Controller controller2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        this.identifier = identifierSpec;
        this.controller = controller2;
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        return StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    }
}
