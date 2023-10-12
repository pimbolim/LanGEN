package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J.\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "", "idRes", "", "contentDescription", "isIcon", "", "(ILjava/lang/Integer;Z)V", "getContentDescription", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIdRes", "()I", "()Z", "component1", "component2", "component3", "copy", "(ILjava/lang/Integer;Z)Lcom/stripe/android/ui/core/elements/TextFieldIcon;", "equals", "other", "hashCode", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldController.kt */
public final class TextFieldIcon {
    public static final int $stable = 0;
    private final Integer contentDescription;
    private final int idRes;
    private final boolean isIcon;

    public static /* synthetic */ TextFieldIcon copy$default(TextFieldIcon textFieldIcon, int i, Integer num, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = textFieldIcon.idRes;
        }
        if ((i2 & 2) != 0) {
            num = textFieldIcon.contentDescription;
        }
        if ((i2 & 4) != 0) {
            z = textFieldIcon.isIcon;
        }
        return textFieldIcon.copy(i, num, z);
    }

    public final int component1() {
        return this.idRes;
    }

    public final Integer component2() {
        return this.contentDescription;
    }

    public final boolean component3() {
        return this.isIcon;
    }

    public final TextFieldIcon copy(int i, Integer num, boolean z) {
        return new TextFieldIcon(i, num, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldIcon)) {
            return false;
        }
        TextFieldIcon textFieldIcon = (TextFieldIcon) obj;
        return this.idRes == textFieldIcon.idRes && Intrinsics.areEqual((Object) this.contentDescription, (Object) textFieldIcon.contentDescription) && this.isIcon == textFieldIcon.isIcon;
    }

    public int hashCode() {
        int i = this.idRes * 31;
        Integer num = this.contentDescription;
        int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        boolean z = this.isIcon;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "TextFieldIcon(idRes=" + this.idRes + ", contentDescription=" + this.contentDescription + ", isIcon=" + this.isIcon + ')';
    }

    public TextFieldIcon(int i, Integer num, boolean z) {
        this.idRes = i;
        this.contentDescription = num;
        this.isIcon = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldIcon(int i, Integer num, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num, z);
    }

    public final int getIdRes() {
        return this.idRes;
    }

    public final Integer getContentDescription() {
        return this.contentDescription;
    }

    public final boolean isIcon() {
        return this.isIcon;
    }
}
