package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0003J\u0019\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0016J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Lcom/stripe/android/ui/core/elements/SaveForFutureUseSpec;", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "Lcom/stripe/android/ui/core/elements/RequiredItemSpec;", "identifierRequiredForFutureUse", "", "(Ljava/util/List;)V", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec$SaveForFutureUse;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec$SaveForFutureUse;", "getIdentifierRequiredForFutureUse", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "transform", "Lcom/stripe/android/ui/core/elements/FormElement;", "initialValue", "merchantName", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SaveForFutureUseSpec.kt */
public final class SaveForFutureUseSpec extends FormItemSpec implements RequiredItemSpec {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SaveForFutureUseSpec> CREATOR = new Creator();
    private final IdentifierSpec.SaveForFutureUse identifier = IdentifierSpec.SaveForFutureUse.INSTANCE;
    private final List<RequiredItemSpec> identifierRequiredForFutureUse;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SaveForFutureUseSpec.kt */
    public static final class Creator implements Parcelable.Creator<SaveForFutureUseSpec> {
        public final SaveForFutureUseSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(parcel.readParcelable(SaveForFutureUseSpec.class.getClassLoader()));
            }
            return new SaveForFutureUseSpec(arrayList);
        }

        public final SaveForFutureUseSpec[] newArray(int i) {
            return new SaveForFutureUseSpec[i];
        }
    }

    public static /* synthetic */ SaveForFutureUseSpec copy$default(SaveForFutureUseSpec saveForFutureUseSpec, List<RequiredItemSpec> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = saveForFutureUseSpec.identifierRequiredForFutureUse;
        }
        return saveForFutureUseSpec.copy(list);
    }

    public final List<RequiredItemSpec> component1() {
        return this.identifierRequiredForFutureUse;
    }

    public final SaveForFutureUseSpec copy(List<? extends RequiredItemSpec> list) {
        Intrinsics.checkNotNullParameter(list, "identifierRequiredForFutureUse");
        return new SaveForFutureUseSpec(list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SaveForFutureUseSpec) && Intrinsics.areEqual((Object) this.identifierRequiredForFutureUse, (Object) ((SaveForFutureUseSpec) obj).identifierRequiredForFutureUse);
    }

    public int hashCode() {
        return this.identifierRequiredForFutureUse.hashCode();
    }

    public String toString() {
        return "SaveForFutureUseSpec(identifierRequiredForFutureUse=" + this.identifierRequiredForFutureUse + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<RequiredItemSpec> list = this.identifierRequiredForFutureUse;
        parcel.writeInt(list.size());
        for (RequiredItemSpec writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i);
        }
    }

    public final List<RequiredItemSpec> getIdentifierRequiredForFutureUse() {
        return this.identifierRequiredForFutureUse;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SaveForFutureUseSpec(List<? extends RequiredItemSpec> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "identifierRequiredForFutureUse");
        this.identifierRequiredForFutureUse = list;
    }

    public IdentifierSpec.SaveForFutureUse getIdentifier() {
        return this.identifier;
    }

    public final FormElement transform(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "merchantName");
        IdentifierSpec identifier2 = getIdentifier();
        Iterable<RequiredItemSpec> iterable = this.identifierRequiredForFutureUse;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (RequiredItemSpec identifier3 : iterable) {
            arrayList.add(identifier3.getIdentifier());
        }
        return new SaveForFutureUseElement(identifier2, new SaveForFutureUseController((List) arrayList, z), str);
    }
}
