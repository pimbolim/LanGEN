package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/model/AlipayAuthResult;", "Lcom/stripe/android/core/model/StripeModel;", "outcome", "", "(I)V", "getOutcome", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlipayAuthResult.kt */
public final class AlipayAuthResult implements StripeModel {
    public static final Parcelable.Creator<AlipayAuthResult> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String RESULT_CODE_CANCELLED = "6001";
    public static final String RESULT_CODE_FAILED = "4000";
    public static final String RESULT_CODE_SUCCESS = "9000";
    private final int outcome;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AlipayAuthResult.kt */
    public static final class Creator implements Parcelable.Creator<AlipayAuthResult> {
        public final AlipayAuthResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AlipayAuthResult(parcel.readInt());
        }

        public final AlipayAuthResult[] newArray(int i) {
            return new AlipayAuthResult[i];
        }
    }

    public static /* synthetic */ AlipayAuthResult copy$default(AlipayAuthResult alipayAuthResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = alipayAuthResult.outcome;
        }
        return alipayAuthResult.copy(i);
    }

    public final int component1() {
        return this.outcome;
    }

    public final AlipayAuthResult copy(int i) {
        return new AlipayAuthResult(i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AlipayAuthResult) && this.outcome == ((AlipayAuthResult) obj).outcome;
    }

    public int hashCode() {
        return this.outcome;
    }

    public String toString() {
        return "AlipayAuthResult(outcome=" + this.outcome + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.outcome);
    }

    public AlipayAuthResult(int i) {
        this.outcome = i;
    }

    public final int getOutcome() {
        return this.outcome;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/AlipayAuthResult$Companion;", "", "()V", "RESULT_CODE_CANCELLED", "", "RESULT_CODE_FAILED", "RESULT_CODE_SUCCESS", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AlipayAuthResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
