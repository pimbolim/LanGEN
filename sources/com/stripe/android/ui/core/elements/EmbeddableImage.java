package com.stripe.android.ui.core.elements;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/ui/core/elements/EmbeddableImage;", "", "id", "", "contentDescription", "(II)V", "getContentDescription", "()I", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Html.kt */
public final class EmbeddableImage {
    private final int contentDescription;
    private final int id;

    public static /* synthetic */ EmbeddableImage copy$default(EmbeddableImage embeddableImage, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = embeddableImage.id;
        }
        if ((i3 & 2) != 0) {
            i2 = embeddableImage.contentDescription;
        }
        return embeddableImage.copy(i, i2);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.contentDescription;
    }

    public final EmbeddableImage copy(int i, int i2) {
        return new EmbeddableImage(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EmbeddableImage)) {
            return false;
        }
        EmbeddableImage embeddableImage = (EmbeddableImage) obj;
        return this.id == embeddableImage.id && this.contentDescription == embeddableImage.contentDescription;
    }

    public int hashCode() {
        return (this.id * 31) + this.contentDescription;
    }

    public String toString() {
        return "EmbeddableImage(id=" + this.id + ", contentDescription=" + this.contentDescription + ')';
    }

    public EmbeddableImage(int i, int i2) {
        this.id = i;
        this.contentDescription = i2;
    }

    public final int getId() {
        return this.id;
    }

    public final int getContentDescription() {
        return this.contentDescription;
    }
}
