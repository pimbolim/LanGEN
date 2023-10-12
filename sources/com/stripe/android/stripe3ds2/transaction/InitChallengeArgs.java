package com.stripe.android.stripe3ds2.transaction;

import android.os.Parcel;
import android.os.Parcelable;
import java.security.KeyPair;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0017\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0018J\u000e\u0010\u0019\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u001aJ\u000e\u0010\u001b\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u001cJ\u000e\u0010\u001d\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\u000bHÀ\u0003¢\u0006\u0002\b J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\t\u0010\"\u001a\u00020\tHÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\tHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006."}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/InitChallengeArgs;", "Landroid/os/Parcelable;", "sdkReferenceNumber", "", "sdkKeyPair", "Ljava/security/KeyPair;", "challengeParameters", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeParameters;", "timeoutMins", "", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "(Ljava/lang/String;Ljava/security/KeyPair;Lcom/stripe/android/stripe3ds2/transaction/ChallengeParameters;ILcom/stripe/android/stripe3ds2/transaction/IntentData;)V", "getChallengeParameters$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/transaction/ChallengeParameters;", "getIntentData$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "getSdkKeyPair$3ds2sdk_release", "()Ljava/security/KeyPair;", "getSdkReferenceNumber$3ds2sdk_release", "()Ljava/lang/String;", "getTimeoutMins$3ds2sdk_release", "()I", "component1", "component1$3ds2sdk_release", "component2", "component2$3ds2sdk_release", "component3", "component3$3ds2sdk_release", "component4", "component4$3ds2sdk_release", "component5", "component5$3ds2sdk_release", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InitChallengeArgs.kt */
public final class InitChallengeArgs implements Parcelable {
    public static final Parcelable.Creator<InitChallengeArgs> CREATOR = new Creator();
    private final ChallengeParameters challengeParameters;
    private final IntentData intentData;
    private final KeyPair sdkKeyPair;
    private final String sdkReferenceNumber;
    private final int timeoutMins;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InitChallengeArgs.kt */
    public static final class Creator implements Parcelable.Creator<InitChallengeArgs> {
        public final InitChallengeArgs createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new InitChallengeArgs(parcel.readString(), (KeyPair) parcel.readSerializable(), ChallengeParameters.CREATOR.createFromParcel(parcel), parcel.readInt(), IntentData.CREATOR.createFromParcel(parcel));
        }

        public final InitChallengeArgs[] newArray(int i) {
            return new InitChallengeArgs[i];
        }
    }

    public static /* synthetic */ InitChallengeArgs copy$default(InitChallengeArgs initChallengeArgs, String str, KeyPair keyPair, ChallengeParameters challengeParameters2, int i, IntentData intentData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = initChallengeArgs.sdkReferenceNumber;
        }
        if ((i2 & 2) != 0) {
            keyPair = initChallengeArgs.sdkKeyPair;
        }
        KeyPair keyPair2 = keyPair;
        if ((i2 & 4) != 0) {
            challengeParameters2 = initChallengeArgs.challengeParameters;
        }
        ChallengeParameters challengeParameters3 = challengeParameters2;
        if ((i2 & 8) != 0) {
            i = initChallengeArgs.timeoutMins;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            intentData2 = initChallengeArgs.intentData;
        }
        return initChallengeArgs.copy(str, keyPair2, challengeParameters3, i3, intentData2);
    }

    public final String component1$3ds2sdk_release() {
        return this.sdkReferenceNumber;
    }

    public final KeyPair component2$3ds2sdk_release() {
        return this.sdkKeyPair;
    }

    public final ChallengeParameters component3$3ds2sdk_release() {
        return this.challengeParameters;
    }

    public final int component4$3ds2sdk_release() {
        return this.timeoutMins;
    }

    public final IntentData component5$3ds2sdk_release() {
        return this.intentData;
    }

    public final InitChallengeArgs copy(String str, KeyPair keyPair, ChallengeParameters challengeParameters2, int i, IntentData intentData2) {
        Intrinsics.checkNotNullParameter(str, "sdkReferenceNumber");
        Intrinsics.checkNotNullParameter(keyPair, "sdkKeyPair");
        Intrinsics.checkNotNullParameter(challengeParameters2, "challengeParameters");
        Intrinsics.checkNotNullParameter(intentData2, "intentData");
        return new InitChallengeArgs(str, keyPair, challengeParameters2, i, intentData2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitChallengeArgs)) {
            return false;
        }
        InitChallengeArgs initChallengeArgs = (InitChallengeArgs) obj;
        return Intrinsics.areEqual((Object) this.sdkReferenceNumber, (Object) initChallengeArgs.sdkReferenceNumber) && Intrinsics.areEqual((Object) this.sdkKeyPair, (Object) initChallengeArgs.sdkKeyPair) && Intrinsics.areEqual((Object) this.challengeParameters, (Object) initChallengeArgs.challengeParameters) && this.timeoutMins == initChallengeArgs.timeoutMins && Intrinsics.areEqual((Object) this.intentData, (Object) initChallengeArgs.intentData);
    }

    public int hashCode() {
        return (((((((this.sdkReferenceNumber.hashCode() * 31) + this.sdkKeyPair.hashCode()) * 31) + this.challengeParameters.hashCode()) * 31) + this.timeoutMins) * 31) + this.intentData.hashCode();
    }

    public String toString() {
        return "InitChallengeArgs(sdkReferenceNumber=" + this.sdkReferenceNumber + ", sdkKeyPair=" + this.sdkKeyPair + ", challengeParameters=" + this.challengeParameters + ", timeoutMins=" + this.timeoutMins + ", intentData=" + this.intentData + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.sdkReferenceNumber);
        parcel.writeSerializable(this.sdkKeyPair);
        this.challengeParameters.writeToParcel(parcel, i);
        parcel.writeInt(this.timeoutMins);
        this.intentData.writeToParcel(parcel, i);
    }

    public InitChallengeArgs(String str, KeyPair keyPair, ChallengeParameters challengeParameters2, int i, IntentData intentData2) {
        Intrinsics.checkNotNullParameter(str, "sdkReferenceNumber");
        Intrinsics.checkNotNullParameter(keyPair, "sdkKeyPair");
        Intrinsics.checkNotNullParameter(challengeParameters2, "challengeParameters");
        Intrinsics.checkNotNullParameter(intentData2, "intentData");
        this.sdkReferenceNumber = str;
        this.sdkKeyPair = keyPair;
        this.challengeParameters = challengeParameters2;
        this.timeoutMins = i;
        this.intentData = intentData2;
    }

    public final String getSdkReferenceNumber$3ds2sdk_release() {
        return this.sdkReferenceNumber;
    }

    public final KeyPair getSdkKeyPair$3ds2sdk_release() {
        return this.sdkKeyPair;
    }

    public final ChallengeParameters getChallengeParameters$3ds2sdk_release() {
        return this.challengeParameters;
    }

    public final int getTimeoutMins$3ds2sdk_release() {
        return this.timeoutMins;
    }

    public final IntentData getIntentData$3ds2sdk_release() {
        return this.intentData;
    }
}
