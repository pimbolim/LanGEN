package com.stripe.android.ui.core.elements;

import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/ui/core/elements/SimpleTextElement;", "Lcom/stripe/android/ui/core/elements/SectionSingleFieldElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "controller", "Lcom/stripe/android/ui/core/elements/TextFieldController;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Lcom/stripe/android/ui/core/elements/TextFieldController;)V", "getController", "()Lcom/stripe/android/ui/core/elements/TextFieldController;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleTextElement.kt */
public final class SimpleTextElement extends SectionSingleFieldElement {
    private final TextFieldController controller;
    private final IdentifierSpec identifier;

    public static /* synthetic */ SimpleTextElement copy$default(SimpleTextElement simpleTextElement, IdentifierSpec identifierSpec, TextFieldController textFieldController, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = simpleTextElement.getIdentifier();
        }
        if ((i & 2) != 0) {
            textFieldController = simpleTextElement.getController();
        }
        return simpleTextElement.copy(identifierSpec, textFieldController);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final TextFieldController component2() {
        return getController();
    }

    public final SimpleTextElement copy(IdentifierSpec identifierSpec, TextFieldController textFieldController) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(textFieldController, "controller");
        return new SimpleTextElement(identifierSpec, textFieldController);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleTextElement)) {
            return false;
        }
        SimpleTextElement simpleTextElement = (SimpleTextElement) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) simpleTextElement.getIdentifier()) && Intrinsics.areEqual((Object) getController(), (Object) simpleTextElement.getController());
    }

    public int hashCode() {
        return (getIdentifier().hashCode() * 31) + getController().hashCode();
    }

    public String toString() {
        return "SimpleTextElement(identifier=" + getIdentifier() + ", controller=" + getController() + ')';
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public TextFieldController getController() {
        return this.controller;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleTextElement(IdentifierSpec identifierSpec, TextFieldController textFieldController) {
        super(identifierSpec, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(textFieldController, "controller");
        this.identifier = identifierSpec;
        this.controller = textFieldController;
    }
}
