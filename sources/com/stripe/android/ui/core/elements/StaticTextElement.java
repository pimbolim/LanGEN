package com.stripe.android.ui.core.elements;

import com.brentvatne.react.ReactVideoView;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J \u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a0\u00190\u0018H\u0016J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/ui/core/elements/StaticTextElement;", "Lcom/stripe/android/ui/core/elements/FormElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "stringResId", "", "controller", "Lcom/stripe/android/ui/core/elements/InputController;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;ILcom/stripe/android/ui/core/elements/InputController;)V", "getController", "()Lcom/stripe/android/ui/core/elements/InputController;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getStringResId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "hashCode", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StaticTextElement.kt */
public final class StaticTextElement extends FormElement {
    public static final int $stable = 8;
    private final InputController controller;
    private final IdentifierSpec identifier;
    private final int stringResId;

    public static /* synthetic */ StaticTextElement copy$default(StaticTextElement staticTextElement, IdentifierSpec identifierSpec, int i, InputController inputController, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            identifierSpec = staticTextElement.getIdentifier();
        }
        if ((i2 & 2) != 0) {
            i = staticTextElement.stringResId;
        }
        if ((i2 & 4) != 0) {
            inputController = staticTextElement.getController();
        }
        return staticTextElement.copy(identifierSpec, i, inputController);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final int component2() {
        return this.stringResId;
    }

    public final InputController component3() {
        return getController();
    }

    public final StaticTextElement copy(IdentifierSpec identifierSpec, int i, InputController inputController) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new StaticTextElement(identifierSpec, i, inputController);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StaticTextElement)) {
            return false;
        }
        StaticTextElement staticTextElement = (StaticTextElement) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) staticTextElement.getIdentifier()) && this.stringResId == staticTextElement.stringResId && Intrinsics.areEqual((Object) getController(), (Object) staticTextElement.getController());
    }

    public int hashCode() {
        return (((getIdentifier().hashCode() * 31) + this.stringResId) * 31) + (getController() == null ? 0 : getController().hashCode());
    }

    public String toString() {
        return "StaticTextElement(identifier=" + getIdentifier() + ", stringResId=" + this.stringResId + ", controller=" + getController() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StaticTextElement(IdentifierSpec identifierSpec, int i, InputController inputController, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec, i, (i2 & 4) != 0 ? null : inputController);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public final int getStringResId() {
        return this.stringResId;
    }

    public InputController getController() {
        return this.controller;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StaticTextElement(IdentifierSpec identifierSpec, int i, InputController inputController) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        this.identifier = identifierSpec;
        this.stringResId = i;
        this.controller = inputController;
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        return StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    }
}
