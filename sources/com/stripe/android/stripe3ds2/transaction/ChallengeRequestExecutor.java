package com.stripe.android.stripe3ds2.transaction;

import android.os.Parcel;
import android.os.Parcelable;
import com.drew.metadata.mov.QuickTimeAtomTypes;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.security.MessageTransformer;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import com.stripe.android.stripe3ds2.utils.ObjectUtils;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0007\bJ\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor;", "", "execute", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "creqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "(Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Config", "Factory", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeRequestExecutor.kt */
public interface ChallengeRequestExecutor {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Factory;", "Ljava/io/Serializable;", "create", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeRequestExecutor.kt */
    public interface Factory extends Serializable {
        ChallengeRequestExecutor create(ErrorReporter errorReporter, CoroutineContext coroutineContext);
    }

    Object execute(ChallengeRequestData challengeRequestData, Continuation<? super ChallengeRequestResult> continuation);

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001.B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0016\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u0017J\u000e\u0010\u0018\u001a\u00020\u0006HÀ\u0003¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b\u001bJ\u000e\u0010\u001c\u001a\u00020\u0006HÀ\u0003¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u000bHÀ\u0003¢\u0006\u0002\b\u001fJ;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\"HÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\"HÖ\u0001R\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006/"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "messageTransformer", "Lcom/stripe/android/stripe3ds2/security/MessageTransformer;", "sdkReferenceId", "", "creqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "acsUrl", "keys", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config$Keys;", "(Lcom/stripe/android/stripe3ds2/security/MessageTransformer;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config$Keys;)V", "getAcsUrl$3ds2sdk_release", "()Ljava/lang/String;", "getCreqData$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "getKeys$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config$Keys;", "getMessageTransformer$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/security/MessageTransformer;", "getSdkReferenceId$3ds2sdk_release", "component1", "component1$3ds2sdk_release", "component2", "component2$3ds2sdk_release", "component3", "component3$3ds2sdk_release", "component4", "component4$3ds2sdk_release", "component5", "component5$3ds2sdk_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Keys", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeRequestExecutor.kt */
    public static final class Config implements Serializable, Parcelable {
        public static final Parcelable.Creator<Config> CREATOR = new Creator();
        private final String acsUrl;
        private final ChallengeRequestData creqData;
        private final Keys keys;
        private final MessageTransformer messageTransformer;
        private final String sdkReferenceId;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeRequestExecutor.kt */
        public static final class Creator implements Parcelable.Creator<Config> {
            public final Config createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Config((MessageTransformer) parcel.readSerializable(), parcel.readString(), ChallengeRequestData.CREATOR.createFromParcel(parcel), parcel.readString(), Keys.CREATOR.createFromParcel(parcel));
            }

            public final Config[] newArray(int i) {
                return new Config[i];
            }
        }

        public static /* synthetic */ Config copy$default(Config config, MessageTransformer messageTransformer2, String str, ChallengeRequestData challengeRequestData, String str2, Keys keys2, int i, Object obj) {
            if ((i & 1) != 0) {
                messageTransformer2 = config.messageTransformer;
            }
            if ((i & 2) != 0) {
                str = config.sdkReferenceId;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                challengeRequestData = config.creqData;
            }
            ChallengeRequestData challengeRequestData2 = challengeRequestData;
            if ((i & 8) != 0) {
                str2 = config.acsUrl;
            }
            String str4 = str2;
            if ((i & 16) != 0) {
                keys2 = config.keys;
            }
            return config.copy(messageTransformer2, str3, challengeRequestData2, str4, keys2);
        }

        public final MessageTransformer component1$3ds2sdk_release() {
            return this.messageTransformer;
        }

        public final String component2$3ds2sdk_release() {
            return this.sdkReferenceId;
        }

        public final ChallengeRequestData component3$3ds2sdk_release() {
            return this.creqData;
        }

        public final String component4$3ds2sdk_release() {
            return this.acsUrl;
        }

        public final Keys component5$3ds2sdk_release() {
            return this.keys;
        }

        public final Config copy(MessageTransformer messageTransformer2, String str, ChallengeRequestData challengeRequestData, String str2, Keys keys2) {
            Intrinsics.checkNotNullParameter(messageTransformer2, "messageTransformer");
            Intrinsics.checkNotNullParameter(str, "sdkReferenceId");
            Intrinsics.checkNotNullParameter(challengeRequestData, "creqData");
            Intrinsics.checkNotNullParameter(str2, "acsUrl");
            Intrinsics.checkNotNullParameter(keys2, QuickTimeAtomTypes.ATOM_KEYS);
            return new Config(messageTransformer2, str, challengeRequestData, str2, keys2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.areEqual((Object) this.messageTransformer, (Object) config.messageTransformer) && Intrinsics.areEqual((Object) this.sdkReferenceId, (Object) config.sdkReferenceId) && Intrinsics.areEqual((Object) this.creqData, (Object) config.creqData) && Intrinsics.areEqual((Object) this.acsUrl, (Object) config.acsUrl) && Intrinsics.areEqual((Object) this.keys, (Object) config.keys);
        }

        public int hashCode() {
            return (((((((this.messageTransformer.hashCode() * 31) + this.sdkReferenceId.hashCode()) * 31) + this.creqData.hashCode()) * 31) + this.acsUrl.hashCode()) * 31) + this.keys.hashCode();
        }

        public String toString() {
            return "Config(messageTransformer=" + this.messageTransformer + ", sdkReferenceId=" + this.sdkReferenceId + ", creqData=" + this.creqData + ", acsUrl=" + this.acsUrl + ", keys=" + this.keys + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeSerializable(this.messageTransformer);
            parcel.writeString(this.sdkReferenceId);
            this.creqData.writeToParcel(parcel, i);
            parcel.writeString(this.acsUrl);
            this.keys.writeToParcel(parcel, i);
        }

        public Config(MessageTransformer messageTransformer2, String str, ChallengeRequestData challengeRequestData, String str2, Keys keys2) {
            Intrinsics.checkNotNullParameter(messageTransformer2, "messageTransformer");
            Intrinsics.checkNotNullParameter(str, "sdkReferenceId");
            Intrinsics.checkNotNullParameter(challengeRequestData, "creqData");
            Intrinsics.checkNotNullParameter(str2, "acsUrl");
            Intrinsics.checkNotNullParameter(keys2, QuickTimeAtomTypes.ATOM_KEYS);
            this.messageTransformer = messageTransformer2;
            this.sdkReferenceId = str;
            this.creqData = challengeRequestData;
            this.acsUrl = str2;
            this.keys = keys2;
        }

        public final MessageTransformer getMessageTransformer$3ds2sdk_release() {
            return this.messageTransformer;
        }

        public final String getSdkReferenceId$3ds2sdk_release() {
            return this.sdkReferenceId;
        }

        public final ChallengeRequestData getCreqData$3ds2sdk_release() {
            return this.creqData;
        }

        public final String getAcsUrl$3ds2sdk_release() {
            return this.acsUrl;
        }

        public final Keys getKeys$3ds2sdk_release() {
            return this.keys;
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u000bJ\u000e\u0010\f\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\rJ\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0000H\u0002J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config$Keys;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "sdkPrivateKeyEncoded", "", "acsPublicKeyEncoded", "([B[B)V", "getAcsPublicKeyEncoded$3ds2sdk_release", "()[B", "getSdkPrivateKeyEncoded$3ds2sdk_release", "component1", "component1$3ds2sdk_release", "component2", "component2$3ds2sdk_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "typedEquals", "keys", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeRequestExecutor.kt */
        public static final class Keys implements Serializable, Parcelable {
            public static final Parcelable.Creator<Keys> CREATOR = new Creator();
            private final byte[] acsPublicKeyEncoded;
            private final byte[] sdkPrivateKeyEncoded;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ChallengeRequestExecutor.kt */
            public static final class Creator implements Parcelable.Creator<Keys> {
                public final Keys createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Keys(parcel.createByteArray(), parcel.createByteArray());
                }

                public final Keys[] newArray(int i) {
                    return new Keys[i];
                }
            }

            public static /* synthetic */ Keys copy$default(Keys keys, byte[] bArr, byte[] bArr2, int i, Object obj) {
                if ((i & 1) != 0) {
                    bArr = keys.sdkPrivateKeyEncoded;
                }
                if ((i & 2) != 0) {
                    bArr2 = keys.acsPublicKeyEncoded;
                }
                return keys.copy(bArr, bArr2);
            }

            public final byte[] component1$3ds2sdk_release() {
                return this.sdkPrivateKeyEncoded;
            }

            public final byte[] component2$3ds2sdk_release() {
                return this.acsPublicKeyEncoded;
            }

            public final Keys copy(byte[] bArr, byte[] bArr2) {
                Intrinsics.checkNotNullParameter(bArr, "sdkPrivateKeyEncoded");
                Intrinsics.checkNotNullParameter(bArr2, "acsPublicKeyEncoded");
                return new Keys(bArr, bArr2);
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "Keys(sdkPrivateKeyEncoded=" + Arrays.toString(this.sdkPrivateKeyEncoded) + ", acsPublicKeyEncoded=" + Arrays.toString(this.acsPublicKeyEncoded) + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeByteArray(this.sdkPrivateKeyEncoded);
                parcel.writeByteArray(this.acsPublicKeyEncoded);
            }

            public Keys(byte[] bArr, byte[] bArr2) {
                Intrinsics.checkNotNullParameter(bArr, "sdkPrivateKeyEncoded");
                Intrinsics.checkNotNullParameter(bArr2, "acsPublicKeyEncoded");
                this.sdkPrivateKeyEncoded = bArr;
                this.acsPublicKeyEncoded = bArr2;
            }

            public final byte[] getSdkPrivateKeyEncoded$3ds2sdk_release() {
                return this.sdkPrivateKeyEncoded;
            }

            public final byte[] getAcsPublicKeyEncoded$3ds2sdk_release() {
                return this.acsPublicKeyEncoded;
            }

            public int hashCode() {
                return ObjectUtils.hash(this.sdkPrivateKeyEncoded, this.acsPublicKeyEncoded);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Keys) {
                    return typedEquals((Keys) obj);
                }
                return false;
            }

            private final boolean typedEquals(Keys keys) {
                return Arrays.equals(this.sdkPrivateKeyEncoded, keys.sdkPrivateKeyEncoded) && Arrays.equals(this.acsPublicKeyEncoded, keys.acsPublicKeyEncoded);
            }
        }
    }
}
