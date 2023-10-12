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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J \u0010\u001c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 0\u001f0\u001e0\u001dH\u0016J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/stripe/android/ui/core/elements/MandateTextElement;", "Lcom/stripe/android/ui/core/elements/FormElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "stringResId", "", "merchantName", "", "controller", "Lcom/stripe/android/ui/core/elements/InputController;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;ILjava/lang/String;Lcom/stripe/android/ui/core/elements/InputController;)V", "getController", "()Lcom/stripe/android/ui/core/elements/InputController;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getMerchantName", "()Ljava/lang/String;", "getStringResId", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "hashCode", "toString", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MandateTextElement.kt */
public final class MandateTextElement extends FormElement {
    public static final int $stable = 8;
    private final InputController controller;
    private final IdentifierSpec identifier;
    private final String merchantName;
    private final int stringResId;

    public static /* synthetic */ MandateTextElement copy$default(MandateTextElement mandateTextElement, IdentifierSpec identifierSpec, int i, String str, InputController inputController, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            identifierSpec = mandateTextElement.getIdentifier();
        }
        if ((i2 & 2) != 0) {
            i = mandateTextElement.stringResId;
        }
        if ((i2 & 4) != 0) {
            str = mandateTextElement.merchantName;
        }
        if ((i2 & 8) != 0) {
            inputController = mandateTextElement.getController();
        }
        return mandateTextElement.copy(identifierSpec, i, str, inputController);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final int component2() {
        return this.stringResId;
    }

    public final String component3() {
        return this.merchantName;
    }

    public final InputController component4() {
        return getController();
    }

    public final MandateTextElement copy(IdentifierSpec identifierSpec, int i, String str, InputController inputController) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        return new MandateTextElement(identifierSpec, i, str, inputController);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MandateTextElement)) {
            return false;
        }
        MandateTextElement mandateTextElement = (MandateTextElement) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) mandateTextElement.getIdentifier()) && this.stringResId == mandateTextElement.stringResId && Intrinsics.areEqual((Object) this.merchantName, (Object) mandateTextElement.merchantName) && Intrinsics.areEqual((Object) getController(), (Object) mandateTextElement.getController());
    }

    public int hashCode() {
        int hashCode = ((getIdentifier().hashCode() * 31) + this.stringResId) * 31;
        String str = this.merchantName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        if (getController() != null) {
            i = getController().hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "MandateTextElement(identifier=" + getIdentifier() + ", stringResId=" + this.stringResId + ", merchantName=" + this.merchantName + ", controller=" + getController() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MandateTextElement(IdentifierSpec identifierSpec, int i, String str, InputController inputController, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec, i, str, (i2 & 8) != 0 ? null : inputController);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public final int getStringResId() {
        return this.stringResId;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public InputController getController() {
        return this.controller;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MandateTextElement(IdentifierSpec identifierSpec, int i, String str, InputController inputController) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        this.identifier = identifierSpec;
        this.stringResId = i;
        this.merchantName = str;
        this.controller = inputController;
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        return StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    }
}
