package com.stripe.android.stripe3ds2.views;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.stripe.android.stripe3ds2.transaction.SdkTransactionId;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeProgressArgs;", "Landroid/os/Parcelable;", "directoryServerName", "", "accentColor", "", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;)V", "getAccentColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDirectoryServerName", "()Ljava/lang/String;", "getSdkTransactionId", "()Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;)Lcom/stripe/android/stripe3ds2/views/ChallengeProgressArgs;", "describeContents", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeProgressArgs.kt */
public final class ChallengeProgressArgs implements Parcelable {
    public static final Parcelable.Creator<ChallengeProgressArgs> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_ARGS = "com.stripe.android.stripe3ds2.views.ChallengeProgressArgs";
    private final Integer accentColor;
    private final String directoryServerName;
    private final SdkTransactionId sdkTransactionId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeProgressArgs.kt */
    public static final class Creator implements Parcelable.Creator<ChallengeProgressArgs> {
        public final ChallengeProgressArgs createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChallengeProgressArgs(parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), SdkTransactionId.CREATOR.createFromParcel(parcel));
        }

        public final ChallengeProgressArgs[] newArray(int i) {
            return new ChallengeProgressArgs[i];
        }
    }

    public static /* synthetic */ ChallengeProgressArgs copy$default(ChallengeProgressArgs challengeProgressArgs, String str, Integer num, SdkTransactionId sdkTransactionId2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = challengeProgressArgs.directoryServerName;
        }
        if ((i & 2) != 0) {
            num = challengeProgressArgs.accentColor;
        }
        if ((i & 4) != 0) {
            sdkTransactionId2 = challengeProgressArgs.sdkTransactionId;
        }
        return challengeProgressArgs.copy(str, num, sdkTransactionId2);
    }

    public final String component1() {
        return this.directoryServerName;
    }

    public final Integer component2() {
        return this.accentColor;
    }

    public final SdkTransactionId component3() {
        return this.sdkTransactionId;
    }

    public final ChallengeProgressArgs copy(String str, Integer num, SdkTransactionId sdkTransactionId2) {
        Intrinsics.checkNotNullParameter(str, "directoryServerName");
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
        return new ChallengeProgressArgs(str, num, sdkTransactionId2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChallengeProgressArgs)) {
            return false;
        }
        ChallengeProgressArgs challengeProgressArgs = (ChallengeProgressArgs) obj;
        return Intrinsics.areEqual((Object) this.directoryServerName, (Object) challengeProgressArgs.directoryServerName) && Intrinsics.areEqual((Object) this.accentColor, (Object) challengeProgressArgs.accentColor) && Intrinsics.areEqual((Object) this.sdkTransactionId, (Object) challengeProgressArgs.sdkTransactionId);
    }

    public int hashCode() {
        int hashCode = this.directoryServerName.hashCode() * 31;
        Integer num = this.accentColor;
        return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.sdkTransactionId.hashCode();
    }

    public String toString() {
        return "ChallengeProgressArgs(directoryServerName=" + this.directoryServerName + ", accentColor=" + this.accentColor + ", sdkTransactionId=" + this.sdkTransactionId + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.directoryServerName);
        Integer num = this.accentColor;
        if (num == null) {
            i2 = 0;
        } else {
            parcel.writeInt(1);
            i2 = num.intValue();
        }
        parcel.writeInt(i2);
        this.sdkTransactionId.writeToParcel(parcel, i);
    }

    public ChallengeProgressArgs(String str, Integer num, SdkTransactionId sdkTransactionId2) {
        Intrinsics.checkNotNullParameter(str, "directoryServerName");
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
        this.directoryServerName = str;
        this.accentColor = num;
        this.sdkTransactionId = sdkTransactionId2;
    }

    public final String getDirectoryServerName() {
        return this.directoryServerName;
    }

    public final Integer getAccentColor() {
        return this.accentColor;
    }

    public final SdkTransactionId getSdkTransactionId() {
        return this.sdkTransactionId;
    }

    public final Bundle toBundle() {
        return BundleKt.bundleOf(TuplesKt.to(EXTRA_ARGS, this));
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeProgressArgs$Companion;", "", "()V", "EXTRA_ARGS", "", "fromBundle", "Lcom/stripe/android/stripe3ds2/views/ChallengeProgressArgs;", "bundle", "Landroid/os/Bundle;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeProgressArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChallengeProgressArgs fromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            return (ChallengeProgressArgs) bundle.getParcelable(ChallengeProgressArgs.EXTRA_ARGS);
        }
    }
}
