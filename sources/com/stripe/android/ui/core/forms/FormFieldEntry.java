package com.stripe.android.ui.core.forms;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "", "value", "", "isComplete", "", "(Ljava/lang/String;Z)V", "()Z", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormFieldEntry.kt */
public final class FormFieldEntry {
    public static final int $stable = 0;
    private final boolean isComplete;
    private final String value;

    public static /* synthetic */ FormFieldEntry copy$default(FormFieldEntry formFieldEntry, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = formFieldEntry.value;
        }
        if ((i & 2) != 0) {
            z = formFieldEntry.isComplete;
        }
        return formFieldEntry.copy(str, z);
    }

    public final String component1() {
        return this.value;
    }

    public final boolean component2() {
        return this.isComplete;
    }

    public final FormFieldEntry copy(String str, boolean z) {
        return new FormFieldEntry(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormFieldEntry)) {
            return false;
        }
        FormFieldEntry formFieldEntry = (FormFieldEntry) obj;
        return Intrinsics.areEqual((Object) this.value, (Object) formFieldEntry.value) && this.isComplete == formFieldEntry.isComplete;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isComplete;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "FormFieldEntry(value=" + this.value + ", isComplete=" + this.isComplete + ')';
    }

    public FormFieldEntry(String str, boolean z) {
        this.value = str;
        this.isComplete = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FormFieldEntry(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    public final String getValue() {
        return this.value;
    }

    public final boolean isComplete() {
        return this.isComplete;
    }
}
