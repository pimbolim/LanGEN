package com.stripe.android.ui.core.elements;

import android.os.Parcel;
import android.os.Parcelable;
import com.brentvatne.react.ReactVideoView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\fHÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J4\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tHÖ\u0001R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lcom/stripe/android/ui/core/elements/SectionSpec;", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "Lcom/stripe/android/ui/core/elements/RequiredItemSpec;", "Landroid/os/Parcelable;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "field", "Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "title", "", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Lcom/stripe/android/ui/core/elements/SectionFieldSpec;Ljava/lang/Integer;)V", "fields", "", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Ljava/util/List;Ljava/lang/Integer;)V", "getFields", "()Ljava/util/List;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getTitle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Ljava/util/List;Ljava/lang/Integer;)Lcom/stripe/android/ui/core/elements/SectionSpec;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionSpec.kt */
public final class SectionSpec extends FormItemSpec implements RequiredItemSpec, Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<SectionSpec> CREATOR = new Creator();
    private final List<SectionFieldSpec> fields;
    private final IdentifierSpec identifier;
    private final Integer title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SectionSpec.kt */
    public static final class Creator implements Parcelable.Creator<SectionSpec> {
        public final SectionSpec createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            IdentifierSpec identifierSpec = (IdentifierSpec) parcel.readParcelable(SectionSpec.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(parcel.readParcelable(SectionSpec.class.getClassLoader()));
            }
            return new SectionSpec(identifierSpec, (List<? extends SectionFieldSpec>) arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        public final SectionSpec[] newArray(int i) {
            return new SectionSpec[i];
        }
    }

    public static /* synthetic */ SectionSpec copy$default(SectionSpec sectionSpec, IdentifierSpec identifierSpec, List<SectionFieldSpec> list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = sectionSpec.getIdentifier();
        }
        if ((i & 2) != 0) {
            list = sectionSpec.fields;
        }
        if ((i & 4) != 0) {
            num = sectionSpec.title;
        }
        return sectionSpec.copy(identifierSpec, list, num);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final List<SectionFieldSpec> component2() {
        return this.fields;
    }

    public final Integer component3() {
        return this.title;
    }

    public final SectionSpec copy(IdentifierSpec identifierSpec, List<? extends SectionFieldSpec> list, Integer num) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(list, "fields");
        return new SectionSpec(identifierSpec, list, num);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SectionSpec)) {
            return false;
        }
        SectionSpec sectionSpec = (SectionSpec) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) sectionSpec.getIdentifier()) && Intrinsics.areEqual((Object) this.fields, (Object) sectionSpec.fields) && Intrinsics.areEqual((Object) this.title, (Object) sectionSpec.title);
    }

    public int hashCode() {
        int hashCode = ((getIdentifier().hashCode() * 31) + this.fields.hashCode()) * 31;
        Integer num = this.title;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "SectionSpec(identifier=" + getIdentifier() + ", fields=" + this.fields + ", title=" + this.title + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.identifier, i);
        List<SectionFieldSpec> list = this.fields;
        parcel.writeInt(list.size());
        for (SectionFieldSpec writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i);
        }
        Integer num = this.title;
        if (num == null) {
            i2 = 0;
        } else {
            parcel.writeInt(1);
            i2 = num.intValue();
        }
        parcel.writeInt(i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SectionSpec(IdentifierSpec identifierSpec, List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec, (List<? extends SectionFieldSpec>) list, (i & 4) != 0 ? null : num);
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public final List<SectionFieldSpec> getFields() {
        return this.fields;
    }

    public final Integer getTitle() {
        return this.title;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SectionSpec(IdentifierSpec identifierSpec, List<? extends SectionFieldSpec> list, Integer num) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(list, "fields");
        this.identifier = identifierSpec;
        this.fields = list;
        this.title = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SectionSpec(IdentifierSpec identifierSpec, SectionFieldSpec sectionFieldSpec, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec, sectionFieldSpec, (i & 4) != 0 ? null : num);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SectionSpec(IdentifierSpec identifierSpec, SectionFieldSpec sectionFieldSpec, Integer num) {
        this(identifierSpec, (List<? extends SectionFieldSpec>) CollectionsKt.listOf(sectionFieldSpec), num);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(sectionFieldSpec, "field");
    }
}
