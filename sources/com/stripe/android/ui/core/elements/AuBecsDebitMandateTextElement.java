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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J \u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a0\u00190\u0018H\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/ui/core/elements/AuBecsDebitMandateTextElement;", "Lcom/stripe/android/ui/core/elements/FormElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "merchantName", "", "controller", "Lcom/stripe/android/ui/core/elements/InputController;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Ljava/lang/String;Lcom/stripe/android/ui/core/elements/InputController;)V", "getController", "()Lcom/stripe/android/ui/core/elements/InputController;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getMerchantName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "hashCode", "", "toString", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuBecsDebitMandateTextElement.kt */
public final class AuBecsDebitMandateTextElement extends FormElement {
    public static final int $stable = 8;
    private final InputController controller;
    private final IdentifierSpec identifier;
    private final String merchantName;

    public static /* synthetic */ AuBecsDebitMandateTextElement copy$default(AuBecsDebitMandateTextElement auBecsDebitMandateTextElement, IdentifierSpec identifierSpec, String str, InputController inputController, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = auBecsDebitMandateTextElement.getIdentifier();
        }
        if ((i & 2) != 0) {
            str = auBecsDebitMandateTextElement.merchantName;
        }
        if ((i & 4) != 0) {
            inputController = auBecsDebitMandateTextElement.getController();
        }
        return auBecsDebitMandateTextElement.copy(identifierSpec, str, inputController);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final String component2() {
        return this.merchantName;
    }

    public final InputController component3() {
        return getController();
    }

    public final AuBecsDebitMandateTextElement copy(IdentifierSpec identifierSpec, String str, InputController inputController) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new AuBecsDebitMandateTextElement(identifierSpec, str, inputController);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuBecsDebitMandateTextElement)) {
            return false;
        }
        AuBecsDebitMandateTextElement auBecsDebitMandateTextElement = (AuBecsDebitMandateTextElement) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) auBecsDebitMandateTextElement.getIdentifier()) && Intrinsics.areEqual((Object) this.merchantName, (Object) auBecsDebitMandateTextElement.merchantName) && Intrinsics.areEqual((Object) getController(), (Object) auBecsDebitMandateTextElement.getController());
    }

    public int hashCode() {
        int hashCode = getIdentifier().hashCode() * 31;
        String str = this.merchantName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        if (getController() != null) {
            i = getController().hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "AuBecsDebitMandateTextElement(identifier=" + getIdentifier() + ", merchantName=" + this.merchantName + ", controller=" + getController() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuBecsDebitMandateTextElement(IdentifierSpec identifierSpec, String str, InputController inputController, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec, str, (i & 4) != 0 ? null : inputController);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public InputController getController() {
        return this.controller;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuBecsDebitMandateTextElement(IdentifierSpec identifierSpec, String str, InputController inputController) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        this.identifier = identifierSpec;
        this.merchantName = str;
        this.controller = inputController;
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        return StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    }
}
