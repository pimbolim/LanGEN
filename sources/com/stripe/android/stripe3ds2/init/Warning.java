package com.stripe.android.stripe3ds2.init;

import android.os.Parcel;
import android.os.Parcelable;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/Warning;", "Landroid/os/Parcelable;", "id", "", "message", "severity", "Lcom/stripe/android/stripe3ds2/init/Warning$Severity;", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/init/Warning$Severity;)V", "getId", "()Ljava/lang/String;", "getMessage", "getSeverity", "()Lcom/stripe/android/stripe3ds2/init/Warning$Severity;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Severity", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Warning.kt */
public final class Warning implements Parcelable {
    public static final Parcelable.Creator<Warning> CREATOR = new Creator();
    private final String id;
    private final String message;
    private final Severity severity;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Warning.kt */
    public static final class Creator implements Parcelable.Creator<Warning> {
        public final Warning createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Warning(parcel.readString(), parcel.readString(), Severity.valueOf(parcel.readString()));
        }

        public final Warning[] newArray(int i) {
            return new Warning[i];
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/Warning$Severity;", "", "(Ljava/lang/String;I)V", "LOW", "MEDIUM", "HIGH", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Warning.kt */
    public enum Severity {
        LOW,
        MEDIUM,
        HIGH
    }

    public static /* synthetic */ Warning copy$default(Warning warning, String str, String str2, Severity severity2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = warning.id;
        }
        if ((i & 2) != 0) {
            str2 = warning.message;
        }
        if ((i & 4) != 0) {
            severity2 = warning.severity;
        }
        return warning.copy(str, str2, severity2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.message;
    }

    public final Severity component3() {
        return this.severity;
    }

    public final Warning copy(String str, String str2, Severity severity2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, GraphQLConstants.Keys.MESSAGE);
        Intrinsics.checkNotNullParameter(severity2, "severity");
        return new Warning(str, str2, severity2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Warning)) {
            return false;
        }
        Warning warning = (Warning) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) warning.id) && Intrinsics.areEqual((Object) this.message, (Object) warning.message) && this.severity == warning.severity;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.message.hashCode()) * 31) + this.severity.hashCode();
    }

    public String toString() {
        return "Warning(id=" + this.id + ", message=" + this.message + ", severity=" + this.severity + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.message);
        parcel.writeString(this.severity.name());
    }

    public Warning(String str, String str2, Severity severity2) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, GraphQLConstants.Keys.MESSAGE);
        Intrinsics.checkNotNullParameter(severity2, "severity");
        this.id = str;
        this.message = str2;
        this.severity = severity2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Severity getSeverity() {
        return this.severity;
    }
}
