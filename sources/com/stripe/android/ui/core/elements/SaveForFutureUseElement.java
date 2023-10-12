package com.stripe.android.ui.core.elements;

import com.brentvatne.react.ReactVideoView;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J \u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a0\u00190\u0018H\u0016J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/ui/core/elements/SaveForFutureUseElement;", "Lcom/stripe/android/ui/core/elements/FormElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "controller", "Lcom/stripe/android/ui/core/elements/SaveForFutureUseController;", "merchantName", "", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Lcom/stripe/android/ui/core/elements/SaveForFutureUseController;Ljava/lang/String;)V", "getController", "()Lcom/stripe/android/ui/core/elements/SaveForFutureUseController;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getMerchantName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "hashCode", "", "toString", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SaveForFutureUseElement.kt */
public final class SaveForFutureUseElement extends FormElement {
    public static final int $stable = 8;
    private final SaveForFutureUseController controller;
    private final IdentifierSpec identifier;
    private final String merchantName;

    public static /* synthetic */ SaveForFutureUseElement copy$default(SaveForFutureUseElement saveForFutureUseElement, IdentifierSpec identifierSpec, SaveForFutureUseController saveForFutureUseController, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = saveForFutureUseElement.getIdentifier();
        }
        if ((i & 2) != 0) {
            saveForFutureUseController = saveForFutureUseElement.getController();
        }
        if ((i & 4) != 0) {
            str = saveForFutureUseElement.merchantName;
        }
        return saveForFutureUseElement.copy(identifierSpec, saveForFutureUseController, str);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final SaveForFutureUseController component2() {
        return getController();
    }

    public final String component3() {
        return this.merchantName;
    }

    public final SaveForFutureUseElement copy(IdentifierSpec identifierSpec, SaveForFutureUseController saveForFutureUseController, String str) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(saveForFutureUseController, "controller");
        return new SaveForFutureUseElement(identifierSpec, saveForFutureUseController, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SaveForFutureUseElement)) {
            return false;
        }
        SaveForFutureUseElement saveForFutureUseElement = (SaveForFutureUseElement) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) saveForFutureUseElement.getIdentifier()) && Intrinsics.areEqual((Object) getController(), (Object) saveForFutureUseElement.getController()) && Intrinsics.areEqual((Object) this.merchantName, (Object) saveForFutureUseElement.merchantName);
    }

    public int hashCode() {
        int hashCode = ((getIdentifier().hashCode() * 31) + getController().hashCode()) * 31;
        String str = this.merchantName;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SaveForFutureUseElement(identifier=" + getIdentifier() + ", controller=" + getController() + ", merchantName=" + this.merchantName + ')';
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public SaveForFutureUseController getController() {
        return this.controller;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaveForFutureUseElement(IdentifierSpec identifierSpec, SaveForFutureUseController saveForFutureUseController, String str) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(saveForFutureUseController, "controller");
        this.identifier = identifierSpec;
        this.controller = saveForFutureUseController;
        this.merchantName = str;
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        return new SaveForFutureUseElement$getFormFieldValueFlow$$inlined$map$1(getController().getFormFieldValue(), this);
    }
}
