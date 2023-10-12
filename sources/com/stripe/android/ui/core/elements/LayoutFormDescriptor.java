package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/ui/core/elements/LayoutFormDescriptor;", "", "layoutSpec", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "showCheckbox", "", "showCheckboxControlledFields", "(Lcom/stripe/android/ui/core/elements/LayoutSpec;ZZ)V", "getLayoutSpec", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getShowCheckbox", "()Z", "getShowCheckboxControlledFields", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutFormDescriptor.kt */
public final class LayoutFormDescriptor {
    public static final int $stable = 8;
    private final LayoutSpec layoutSpec;
    private final boolean showCheckbox;
    private final boolean showCheckboxControlledFields;

    public static /* synthetic */ LayoutFormDescriptor copy$default(LayoutFormDescriptor layoutFormDescriptor, LayoutSpec layoutSpec2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutSpec2 = layoutFormDescriptor.layoutSpec;
        }
        if ((i & 2) != 0) {
            z = layoutFormDescriptor.showCheckbox;
        }
        if ((i & 4) != 0) {
            z2 = layoutFormDescriptor.showCheckboxControlledFields;
        }
        return layoutFormDescriptor.copy(layoutSpec2, z, z2);
    }

    public final LayoutSpec component1() {
        return this.layoutSpec;
    }

    public final boolean component2() {
        return this.showCheckbox;
    }

    public final boolean component3() {
        return this.showCheckboxControlledFields;
    }

    public final LayoutFormDescriptor copy(LayoutSpec layoutSpec2, boolean z, boolean z2) {
        return new LayoutFormDescriptor(layoutSpec2, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LayoutFormDescriptor)) {
            return false;
        }
        LayoutFormDescriptor layoutFormDescriptor = (LayoutFormDescriptor) obj;
        return Intrinsics.areEqual((Object) this.layoutSpec, (Object) layoutFormDescriptor.layoutSpec) && this.showCheckbox == layoutFormDescriptor.showCheckbox && this.showCheckboxControlledFields == layoutFormDescriptor.showCheckboxControlledFields;
    }

    public int hashCode() {
        LayoutSpec layoutSpec2 = this.layoutSpec;
        int hashCode = (layoutSpec2 == null ? 0 : layoutSpec2.hashCode()) * 31;
        boolean z = this.showCheckbox;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.showCheckboxControlledFields;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "LayoutFormDescriptor(layoutSpec=" + this.layoutSpec + ", showCheckbox=" + this.showCheckbox + ", showCheckboxControlledFields=" + this.showCheckboxControlledFields + ')';
    }

    public LayoutFormDescriptor(LayoutSpec layoutSpec2, boolean z, boolean z2) {
        this.layoutSpec = layoutSpec2;
        this.showCheckbox = z;
        this.showCheckboxControlledFields = z2;
    }

    public final LayoutSpec getLayoutSpec() {
        return this.layoutSpec;
    }

    public final boolean getShowCheckbox() {
        return this.showCheckbox;
    }

    public final boolean getShowCheckboxControlledFields() {
        return this.showCheckboxControlledFields;
    }
}
