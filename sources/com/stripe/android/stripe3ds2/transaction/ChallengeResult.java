package com.stripe.android.stripe3ds2.transaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.stripe.android.stripe3ds2.transactions.ErrorData;
import com.stripe.android.stripe3ds2.transactions.UiType;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000f2\u00020\u0001:\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\r\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0006\u0015\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "Landroid/os/Parcelable;", "()V", "initialUiType", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "getInitialUiType", "()Lcom/stripe/android/stripe3ds2/transactions/UiType;", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "getIntentData", "()Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "toBundle", "Landroid/os/Bundle;", "toBundle$3ds2sdk_release", "Canceled", "Companion", "Failed", "ProtocolError", "RuntimeError", "Succeeded", "Timeout", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$Succeeded;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$Failed;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$Canceled;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$ProtocolError;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$RuntimeError;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$Timeout;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeResult.kt */
public abstract class ChallengeResult implements Parcelable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_RESULT = "extra_result";

    public /* synthetic */ ChallengeResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract UiType getInitialUiType();

    public abstract IntentData getIntentData();

    private ChallengeResult() {
    }

    public final Bundle toBundle$3ds2sdk_release() {
        return BundleKt.bundleOf(TuplesKt.to("extra_result", this));
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$Succeeded;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "uiTypeCode", "", "initialUiType", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "(Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/UiType;Lcom/stripe/android/stripe3ds2/transaction/IntentData;)V", "getInitialUiType", "()Lcom/stripe/android/stripe3ds2/transactions/UiType;", "getIntentData", "()Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "getUiTypeCode", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResult.kt */
    public static final class Succeeded extends ChallengeResult {
        public static final Parcelable.Creator<Succeeded> CREATOR = new Creator();
        private final UiType initialUiType;
        private final IntentData intentData;
        private final String uiTypeCode;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeResult.kt */
        public static final class Creator implements Parcelable.Creator<Succeeded> {
            public final Succeeded createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Succeeded(parcel.readString(), parcel.readInt() == 0 ? null : UiType.valueOf(parcel.readString()), IntentData.CREATOR.createFromParcel(parcel));
            }

            public final Succeeded[] newArray(int i) {
                return new Succeeded[i];
            }
        }

        public static /* synthetic */ Succeeded copy$default(Succeeded succeeded, String str, UiType uiType, IntentData intentData2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = succeeded.uiTypeCode;
            }
            if ((i & 2) != 0) {
                uiType = succeeded.getInitialUiType();
            }
            if ((i & 4) != 0) {
                intentData2 = succeeded.getIntentData();
            }
            return succeeded.copy(str, uiType, intentData2);
        }

        public final String component1() {
            return this.uiTypeCode;
        }

        public final UiType component2() {
            return getInitialUiType();
        }

        public final IntentData component3() {
            return getIntentData();
        }

        public final Succeeded copy(String str, UiType uiType, IntentData intentData2) {
            Intrinsics.checkNotNullParameter(str, "uiTypeCode");
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            return new Succeeded(str, uiType, intentData2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Succeeded)) {
                return false;
            }
            Succeeded succeeded = (Succeeded) obj;
            return Intrinsics.areEqual((Object) this.uiTypeCode, (Object) succeeded.uiTypeCode) && getInitialUiType() == succeeded.getInitialUiType() && Intrinsics.areEqual((Object) getIntentData(), (Object) succeeded.getIntentData());
        }

        public int hashCode() {
            return (((this.uiTypeCode.hashCode() * 31) + (getInitialUiType() == null ? 0 : getInitialUiType().hashCode())) * 31) + getIntentData().hashCode();
        }

        public String toString() {
            return "Succeeded(uiTypeCode=" + this.uiTypeCode + ", initialUiType=" + getInitialUiType() + ", intentData=" + getIntentData() + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.uiTypeCode);
            UiType uiType = this.initialUiType;
            if (uiType == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(uiType.name());
            }
            this.intentData.writeToParcel(parcel, i);
        }

        public final String getUiTypeCode() {
            return this.uiTypeCode;
        }

        public UiType getInitialUiType() {
            return this.initialUiType;
        }

        public IntentData getIntentData() {
            return this.intentData;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Succeeded(String str, UiType uiType, IntentData intentData2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "uiTypeCode");
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            this.uiTypeCode = str;
            this.initialUiType = uiType;
            this.intentData = intentData2;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$Failed;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "uiTypeCode", "", "initialUiType", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "(Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/UiType;Lcom/stripe/android/stripe3ds2/transaction/IntentData;)V", "getInitialUiType", "()Lcom/stripe/android/stripe3ds2/transactions/UiType;", "getIntentData", "()Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "getUiTypeCode", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResult.kt */
    public static final class Failed extends ChallengeResult {
        public static final Parcelable.Creator<Failed> CREATOR = new Creator();
        private final UiType initialUiType;
        private final IntentData intentData;
        private final String uiTypeCode;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeResult.kt */
        public static final class Creator implements Parcelable.Creator<Failed> {
            public final Failed createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Failed(parcel.readString(), parcel.readInt() == 0 ? null : UiType.valueOf(parcel.readString()), IntentData.CREATOR.createFromParcel(parcel));
            }

            public final Failed[] newArray(int i) {
                return new Failed[i];
            }
        }

        public static /* synthetic */ Failed copy$default(Failed failed, String str, UiType uiType, IntentData intentData2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failed.uiTypeCode;
            }
            if ((i & 2) != 0) {
                uiType = failed.getInitialUiType();
            }
            if ((i & 4) != 0) {
                intentData2 = failed.getIntentData();
            }
            return failed.copy(str, uiType, intentData2);
        }

        public final String component1() {
            return this.uiTypeCode;
        }

        public final UiType component2() {
            return getInitialUiType();
        }

        public final IntentData component3() {
            return getIntentData();
        }

        public final Failed copy(String str, UiType uiType, IntentData intentData2) {
            Intrinsics.checkNotNullParameter(str, "uiTypeCode");
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            return new Failed(str, uiType, intentData2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Failed)) {
                return false;
            }
            Failed failed = (Failed) obj;
            return Intrinsics.areEqual((Object) this.uiTypeCode, (Object) failed.uiTypeCode) && getInitialUiType() == failed.getInitialUiType() && Intrinsics.areEqual((Object) getIntentData(), (Object) failed.getIntentData());
        }

        public int hashCode() {
            return (((this.uiTypeCode.hashCode() * 31) + (getInitialUiType() == null ? 0 : getInitialUiType().hashCode())) * 31) + getIntentData().hashCode();
        }

        public String toString() {
            return "Failed(uiTypeCode=" + this.uiTypeCode + ", initialUiType=" + getInitialUiType() + ", intentData=" + getIntentData() + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.uiTypeCode);
            UiType uiType = this.initialUiType;
            if (uiType == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(uiType.name());
            }
            this.intentData.writeToParcel(parcel, i);
        }

        public final String getUiTypeCode() {
            return this.uiTypeCode;
        }

        public UiType getInitialUiType() {
            return this.initialUiType;
        }

        public IntentData getIntentData() {
            return this.intentData;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failed(String str, UiType uiType, IntentData intentData2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "uiTypeCode");
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            this.uiTypeCode = str;
            this.initialUiType = uiType;
            this.intentData = intentData2;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$Canceled;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "uiTypeCode", "", "initialUiType", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "(Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/UiType;Lcom/stripe/android/stripe3ds2/transaction/IntentData;)V", "getInitialUiType", "()Lcom/stripe/android/stripe3ds2/transactions/UiType;", "getIntentData", "()Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "getUiTypeCode", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResult.kt */
    public static final class Canceled extends ChallengeResult {
        public static final Parcelable.Creator<Canceled> CREATOR = new Creator();
        private final UiType initialUiType;
        private final IntentData intentData;
        private final String uiTypeCode;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeResult.kt */
        public static final class Creator implements Parcelable.Creator<Canceled> {
            public final Canceled createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Canceled(parcel.readString(), parcel.readInt() == 0 ? null : UiType.valueOf(parcel.readString()), IntentData.CREATOR.createFromParcel(parcel));
            }

            public final Canceled[] newArray(int i) {
                return new Canceled[i];
            }
        }

        public static /* synthetic */ Canceled copy$default(Canceled canceled, String str, UiType uiType, IntentData intentData2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = canceled.uiTypeCode;
            }
            if ((i & 2) != 0) {
                uiType = canceled.getInitialUiType();
            }
            if ((i & 4) != 0) {
                intentData2 = canceled.getIntentData();
            }
            return canceled.copy(str, uiType, intentData2);
        }

        public final String component1() {
            return this.uiTypeCode;
        }

        public final UiType component2() {
            return getInitialUiType();
        }

        public final IntentData component3() {
            return getIntentData();
        }

        public final Canceled copy(String str, UiType uiType, IntentData intentData2) {
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            return new Canceled(str, uiType, intentData2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Canceled)) {
                return false;
            }
            Canceled canceled = (Canceled) obj;
            return Intrinsics.areEqual((Object) this.uiTypeCode, (Object) canceled.uiTypeCode) && getInitialUiType() == canceled.getInitialUiType() && Intrinsics.areEqual((Object) getIntentData(), (Object) canceled.getIntentData());
        }

        public int hashCode() {
            String str = this.uiTypeCode;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            if (getInitialUiType() != null) {
                i = getInitialUiType().hashCode();
            }
            return ((hashCode + i) * 31) + getIntentData().hashCode();
        }

        public String toString() {
            return "Canceled(uiTypeCode=" + this.uiTypeCode + ", initialUiType=" + getInitialUiType() + ", intentData=" + getIntentData() + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.uiTypeCode);
            UiType uiType = this.initialUiType;
            if (uiType == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(uiType.name());
            }
            this.intentData.writeToParcel(parcel, i);
        }

        public final String getUiTypeCode() {
            return this.uiTypeCode;
        }

        public UiType getInitialUiType() {
            return this.initialUiType;
        }

        public IntentData getIntentData() {
            return this.intentData;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Canceled(String str, UiType uiType, IntentData intentData2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            this.uiTypeCode = str;
            this.initialUiType = uiType;
            this.intentData = intentData2;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$ProtocolError;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "data", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "initialUiType", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "(Lcom/stripe/android/stripe3ds2/transactions/ErrorData;Lcom/stripe/android/stripe3ds2/transactions/UiType;Lcom/stripe/android/stripe3ds2/transaction/IntentData;)V", "getData", "()Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "getInitialUiType", "()Lcom/stripe/android/stripe3ds2/transactions/UiType;", "getIntentData", "()Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResult.kt */
    public static final class ProtocolError extends ChallengeResult {
        public static final Parcelable.Creator<ProtocolError> CREATOR = new Creator();
        private final ErrorData data;
        private final UiType initialUiType;
        private final IntentData intentData;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeResult.kt */
        public static final class Creator implements Parcelable.Creator<ProtocolError> {
            public final ProtocolError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ProtocolError(ErrorData.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : UiType.valueOf(parcel.readString()), IntentData.CREATOR.createFromParcel(parcel));
            }

            public final ProtocolError[] newArray(int i) {
                return new ProtocolError[i];
            }
        }

        public static /* synthetic */ ProtocolError copy$default(ProtocolError protocolError, ErrorData errorData, UiType uiType, IntentData intentData2, int i, Object obj) {
            if ((i & 1) != 0) {
                errorData = protocolError.data;
            }
            if ((i & 2) != 0) {
                uiType = protocolError.getInitialUiType();
            }
            if ((i & 4) != 0) {
                intentData2 = protocolError.getIntentData();
            }
            return protocolError.copy(errorData, uiType, intentData2);
        }

        public final ErrorData component1() {
            return this.data;
        }

        public final UiType component2() {
            return getInitialUiType();
        }

        public final IntentData component3() {
            return getIntentData();
        }

        public final ProtocolError copy(ErrorData errorData, UiType uiType, IntentData intentData2) {
            Intrinsics.checkNotNullParameter(errorData, "data");
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            return new ProtocolError(errorData, uiType, intentData2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProtocolError)) {
                return false;
            }
            ProtocolError protocolError = (ProtocolError) obj;
            return Intrinsics.areEqual((Object) this.data, (Object) protocolError.data) && getInitialUiType() == protocolError.getInitialUiType() && Intrinsics.areEqual((Object) getIntentData(), (Object) protocolError.getIntentData());
        }

        public int hashCode() {
            return (((this.data.hashCode() * 31) + (getInitialUiType() == null ? 0 : getInitialUiType().hashCode())) * 31) + getIntentData().hashCode();
        }

        public String toString() {
            return "ProtocolError(data=" + this.data + ", initialUiType=" + getInitialUiType() + ", intentData=" + getIntentData() + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.data.writeToParcel(parcel, i);
            UiType uiType = this.initialUiType;
            if (uiType == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(uiType.name());
            }
            this.intentData.writeToParcel(parcel, i);
        }

        public final ErrorData getData() {
            return this.data;
        }

        public UiType getInitialUiType() {
            return this.initialUiType;
        }

        public IntentData getIntentData() {
            return this.intentData;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProtocolError(ErrorData errorData, UiType uiType, IntentData intentData2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(errorData, "data");
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            this.data = errorData;
            this.initialUiType = uiType;
            this.intentData = intentData2;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006!"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$RuntimeError;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "throwable", "", "initialUiType", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "(Ljava/lang/Throwable;Lcom/stripe/android/stripe3ds2/transactions/UiType;Lcom/stripe/android/stripe3ds2/transaction/IntentData;)V", "getInitialUiType", "()Lcom/stripe/android/stripe3ds2/transactions/UiType;", "getIntentData", "()Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResult.kt */
    public static final class RuntimeError extends ChallengeResult {
        public static final Parcelable.Creator<RuntimeError> CREATOR = new Creator();
        private final UiType initialUiType;
        private final IntentData intentData;
        private final Throwable throwable;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeResult.kt */
        public static final class Creator implements Parcelable.Creator<RuntimeError> {
            public final RuntimeError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new RuntimeError((Throwable) parcel.readSerializable(), parcel.readInt() == 0 ? null : UiType.valueOf(parcel.readString()), IntentData.CREATOR.createFromParcel(parcel));
            }

            public final RuntimeError[] newArray(int i) {
                return new RuntimeError[i];
            }
        }

        public static /* synthetic */ RuntimeError copy$default(RuntimeError runtimeError, Throwable th, UiType uiType, IntentData intentData2, int i, Object obj) {
            if ((i & 1) != 0) {
                th = runtimeError.throwable;
            }
            if ((i & 2) != 0) {
                uiType = runtimeError.getInitialUiType();
            }
            if ((i & 4) != 0) {
                intentData2 = runtimeError.getIntentData();
            }
            return runtimeError.copy(th, uiType, intentData2);
        }

        public final Throwable component1() {
            return this.throwable;
        }

        public final UiType component2() {
            return getInitialUiType();
        }

        public final IntentData component3() {
            return getIntentData();
        }

        public final RuntimeError copy(Throwable th, UiType uiType, IntentData intentData2) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            return new RuntimeError(th, uiType, intentData2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RuntimeError)) {
                return false;
            }
            RuntimeError runtimeError = (RuntimeError) obj;
            return Intrinsics.areEqual((Object) this.throwable, (Object) runtimeError.throwable) && getInitialUiType() == runtimeError.getInitialUiType() && Intrinsics.areEqual((Object) getIntentData(), (Object) runtimeError.getIntentData());
        }

        public int hashCode() {
            return (((this.throwable.hashCode() * 31) + (getInitialUiType() == null ? 0 : getInitialUiType().hashCode())) * 31) + getIntentData().hashCode();
        }

        public String toString() {
            return "RuntimeError(throwable=" + this.throwable + ", initialUiType=" + getInitialUiType() + ", intentData=" + getIntentData() + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeSerializable(this.throwable);
            UiType uiType = this.initialUiType;
            if (uiType == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(uiType.name());
            }
            this.intentData.writeToParcel(parcel, i);
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public UiType getInitialUiType() {
            return this.initialUiType;
        }

        public IntentData getIntentData() {
            return this.intentData;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RuntimeError(Throwable th, UiType uiType, IntentData intentData2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, "throwable");
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            this.throwable = th;
            this.initialUiType = uiType;
            this.intentData = intentData2;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$Timeout;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "uiTypeCode", "", "initialUiType", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "(Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/UiType;Lcom/stripe/android/stripe3ds2/transaction/IntentData;)V", "getInitialUiType", "()Lcom/stripe/android/stripe3ds2/transactions/UiType;", "getIntentData", "()Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "getUiTypeCode", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResult.kt */
    public static final class Timeout extends ChallengeResult {
        public static final Parcelable.Creator<Timeout> CREATOR = new Creator();
        private final UiType initialUiType;
        private final IntentData intentData;
        private final String uiTypeCode;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeResult.kt */
        public static final class Creator implements Parcelable.Creator<Timeout> {
            public final Timeout createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Timeout(parcel.readString(), parcel.readInt() == 0 ? null : UiType.valueOf(parcel.readString()), IntentData.CREATOR.createFromParcel(parcel));
            }

            public final Timeout[] newArray(int i) {
                return new Timeout[i];
            }
        }

        public static /* synthetic */ Timeout copy$default(Timeout timeout, String str, UiType uiType, IntentData intentData2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = timeout.uiTypeCode;
            }
            if ((i & 2) != 0) {
                uiType = timeout.getInitialUiType();
            }
            if ((i & 4) != 0) {
                intentData2 = timeout.getIntentData();
            }
            return timeout.copy(str, uiType, intentData2);
        }

        public final String component1() {
            return this.uiTypeCode;
        }

        public final UiType component2() {
            return getInitialUiType();
        }

        public final IntentData component3() {
            return getIntentData();
        }

        public final Timeout copy(String str, UiType uiType, IntentData intentData2) {
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            return new Timeout(str, uiType, intentData2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Timeout)) {
                return false;
            }
            Timeout timeout = (Timeout) obj;
            return Intrinsics.areEqual((Object) this.uiTypeCode, (Object) timeout.uiTypeCode) && getInitialUiType() == timeout.getInitialUiType() && Intrinsics.areEqual((Object) getIntentData(), (Object) timeout.getIntentData());
        }

        public int hashCode() {
            String str = this.uiTypeCode;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            if (getInitialUiType() != null) {
                i = getInitialUiType().hashCode();
            }
            return ((hashCode + i) * 31) + getIntentData().hashCode();
        }

        public String toString() {
            return "Timeout(uiTypeCode=" + this.uiTypeCode + ", initialUiType=" + getInitialUiType() + ", intentData=" + getIntentData() + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.uiTypeCode);
            UiType uiType = this.initialUiType;
            if (uiType == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(uiType.name());
            }
            this.intentData.writeToParcel(parcel, i);
        }

        public final String getUiTypeCode() {
            return this.uiTypeCode;
        }

        public UiType getInitialUiType() {
            return this.initialUiType;
        }

        public IntentData getIntentData() {
            return this.intentData;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Timeout(String str, UiType uiType, IntentData intentData2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(intentData2, "intentData");
            this.uiTypeCode = str;
            this.initialUiType = uiType;
            this.intentData = intentData2;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult$Companion;", "", "()V", "EXTRA_RESULT", "", "fromIntent", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "intent", "Landroid/content/Intent;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChallengeResult fromIntent(Intent intent) {
            ChallengeResult challengeResult = intent == null ? null : (ChallengeResult) intent.getParcelableExtra("extra_result");
            return challengeResult == null ? new RuntimeError(new IllegalStateException("Intent extras did not contain a valid ChallengeResult."), (UiType) null, IntentData.Companion.getEMPTY()) : challengeResult;
        }
    }
}
