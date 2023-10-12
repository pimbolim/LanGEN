package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/ui/core/elements/LayoutSpec;", "Landroid/os/Parcelable;", "items", "", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutSpec.kt */
public final class LayoutSpec implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<LayoutSpec> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<FormItemSpec> items;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LayoutSpec.kt */
    public static final class Creator implements Parcelable.Creator<LayoutSpec> {
        public final LayoutSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(parcel.readParcelable(LayoutSpec.class.getClassLoader()));
            }
            return new LayoutSpec(arrayList, (DefaultConstructorMarker) null);
        }

        public final LayoutSpec[] newArray(int i) {
            return new LayoutSpec[i];
        }
    }

    public /* synthetic */ LayoutSpec(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    public static /* synthetic */ LayoutSpec copy$default(LayoutSpec layoutSpec, List<FormItemSpec> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = layoutSpec.items;
        }
        return layoutSpec.copy(list);
    }

    public final List<FormItemSpec> component1() {
        return this.items;
    }

    public final LayoutSpec copy(List<? extends FormItemSpec> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new LayoutSpec(list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LayoutSpec) && Intrinsics.areEqual((Object) this.items, (Object) ((LayoutSpec) obj).items);
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public String toString() {
        return "LayoutSpec(items=" + this.items + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<FormItemSpec> list = this.items;
        parcel.writeInt(list.size());
        for (FormItemSpec writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i);
        }
    }

    private LayoutSpec(List<? extends FormItemSpec> list) {
        this.items = list;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u001f\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/ui/core/elements/LayoutSpec$Companion;", "", "()V", "create", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "item", "", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "([Lcom/stripe/android/ui/core/elements/FormItemSpec;)Lcom/stripe/android/ui/core/elements/LayoutSpec;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LayoutSpec.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LayoutSpec create(FormItemSpec... formItemSpecArr) {
            Intrinsics.checkNotNullParameter(formItemSpecArr, "item");
            return new LayoutSpec(ArraysKt.toList((T[]) formItemSpecArr), (DefaultConstructorMarker) null);
        }

        public final LayoutSpec create() {
            return new LayoutSpec(CollectionsKt.listOf(EmptyFormSpec.INSTANCE), (DefaultConstructorMarker) null);
        }
    }

    public final List<FormItemSpec> getItems() {
        return this.items;
    }
}
