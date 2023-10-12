package com.stripe.android.cards;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/cards/Bin;", "Lcom/stripe/android/core/model/StripeModel;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Bin.kt */
public final class Bin implements StripeModel {
    private static final int BIN_LENGTH = 6;
    public static final Parcelable.Creator<Bin> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Bin.kt */
    public static final class Creator implements Parcelable.Creator<Bin> {
        public final Bin createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Bin(parcel.readString());
        }

        public final Bin[] newArray(int i) {
            return new Bin[i];
        }
    }

    public static /* synthetic */ Bin copy$default(Bin bin, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bin.value;
        }
        return bin.copy(str);
    }

    public final String component1() {
        return this.value;
    }

    public final Bin copy(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new Bin(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Bin) && Intrinsics.areEqual((Object) this.value, (Object) ((Bin) obj).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.value);
    }

    public Bin(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/cards/Bin$Companion;", "", "()V", "BIN_LENGTH", "", "create", "Lcom/stripe/android/cards/Bin;", "cardNumber", "", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Bin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Bin create(String str) {
            Intrinsics.checkNotNullParameter(str, "cardNumber");
            String take = StringsKt.take(str, 6);
            if (!(take.length() == 6)) {
                take = null;
            }
            if (take == null) {
                return null;
            }
            return new Bin(take);
        }
    }
}
