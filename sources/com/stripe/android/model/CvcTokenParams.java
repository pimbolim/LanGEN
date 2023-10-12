package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.Token;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\u0011\u001a\u00020\rHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/CvcTokenParams;", "Lcom/stripe/android/model/TokenParams;", "cvc", "", "(Ljava/lang/String;)V", "typeDataParams", "", "", "getTypeDataParams", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CvcTokenParams.kt */
public final class CvcTokenParams extends TokenParams {
    public static final int $stable = 8;
    public static final Parcelable.Creator<CvcTokenParams> CREATOR = new Creator();
    private final String cvc;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CvcTokenParams.kt */
    public static final class Creator implements Parcelable.Creator<CvcTokenParams> {
        public final CvcTokenParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CvcTokenParams(parcel.readString());
        }

        public final CvcTokenParams[] newArray(int i) {
            return new CvcTokenParams[i];
        }
    }

    private final String component1() {
        return this.cvc;
    }

    public static /* synthetic */ CvcTokenParams copy$default(CvcTokenParams cvcTokenParams, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cvcTokenParams.cvc;
        }
        return cvcTokenParams.copy(str);
    }

    public final CvcTokenParams copy(String str) {
        Intrinsics.checkNotNullParameter(str, "cvc");
        return new CvcTokenParams(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CvcTokenParams) && Intrinsics.areEqual((Object) this.cvc, (Object) ((CvcTokenParams) obj).cvc);
    }

    public int hashCode() {
        return this.cvc.hashCode();
    }

    public String toString() {
        return "CvcTokenParams(cvc=" + this.cvc + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.cvc);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CvcTokenParams(String str) {
        super(Token.Type.CvcUpdate, (Set) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "cvc");
        this.cvc = str;
    }

    public Map<String, Object> getTypeDataParams() {
        return MapsKt.mapOf(TuplesKt.to("cvc", this.cvc));
    }
}
