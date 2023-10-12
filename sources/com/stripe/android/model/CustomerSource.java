package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.SourceTypeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/model/CustomerSource;", "Lcom/stripe/android/model/CustomerPaymentSource;", "source", "Lcom/stripe/android/model/Source;", "(Lcom/stripe/android/model/Source;)V", "id", "", "getId", "()Ljava/lang/String;", "getSource", "()Lcom/stripe/android/model/Source;", "tokenizationMethod", "Lcom/stripe/android/model/TokenizationMethod;", "getTokenizationMethod", "()Lcom/stripe/android/model/TokenizationMethod;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerSource.kt */
public final class CustomerSource extends CustomerPaymentSource {
    public static final int $stable = 8;
    public static final Parcelable.Creator<CustomerSource> CREATOR = new Creator();
    private final Source source;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerSource.kt */
    public static final class Creator implements Parcelable.Creator<CustomerSource> {
        public final CustomerSource createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CustomerSource(Source.CREATOR.createFromParcel(parcel));
        }

        public final CustomerSource[] newArray(int i) {
            return new CustomerSource[i];
        }
    }

    public static /* synthetic */ CustomerSource copy$default(CustomerSource customerSource, Source source2, int i, Object obj) {
        if ((i & 1) != 0) {
            source2 = customerSource.source;
        }
        return customerSource.copy(source2);
    }

    public final Source component1() {
        return this.source;
    }

    public final CustomerSource copy(Source source2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        return new CustomerSource(source2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomerSource) && Intrinsics.areEqual((Object) this.source, (Object) ((CustomerSource) obj).source);
    }

    public int hashCode() {
        return this.source.hashCode();
    }

    public String toString() {
        return "CustomerSource(source=" + this.source + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.source.writeToParcel(parcel, i);
    }

    public final Source getSource() {
        return this.source;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerSource(Source source2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(source2, "source");
        this.source = source2;
    }

    public String getId() {
        return this.source.getId();
    }

    public TokenizationMethod getTokenizationMethod() {
        if (this.source.getSourceTypeModel() instanceof SourceTypeModel.Card) {
            return ((SourceTypeModel.Card) this.source.getSourceTypeModel()).getTokenizationMethod();
        }
        return null;
    }
}
