package com.stripe.android.stripe3ds2.transaction;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.stripe3ds2.transaction.ChallengeRequestExecutor;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseData;
import com.stripe.android.stripe3ds2.transactions.ErrorData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "Landroid/os/Parcelable;", "()V", "Failure", "ProtocolError", "RuntimeError", "Success", "Timeout", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$Success;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$Failure;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeRequestResult.kt */
public abstract class ChallengeRequestResult implements Parcelable {
    public /* synthetic */ ChallengeRequestResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ChallengeRequestResult() {
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000e\u0010\u0011\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0012J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$Success;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "creqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "cresData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData;", "creqExecutorConfig", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config;", "(Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData;Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config;)V", "getCreqData", "()Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "getCreqExecutorConfig$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestExecutor$Config;", "getCresData", "()Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData;", "component1", "component2", "component3", "component3$3ds2sdk_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeRequestResult.kt */
    public static final class Success extends ChallengeRequestResult {
        public static final Parcelable.Creator<Success> CREATOR = new Creator();
        private final ChallengeRequestData creqData;
        private final ChallengeRequestExecutor.Config creqExecutorConfig;
        private final ChallengeResponseData cresData;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeRequestResult.kt */
        public static final class Creator implements Parcelable.Creator<Success> {
            public final Success createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Success(ChallengeRequestData.CREATOR.createFromParcel(parcel), ChallengeResponseData.CREATOR.createFromParcel(parcel), ChallengeRequestExecutor.Config.CREATOR.createFromParcel(parcel));
            }

            public final Success[] newArray(int i) {
                return new Success[i];
            }
        }

        public static /* synthetic */ Success copy$default(Success success, ChallengeRequestData challengeRequestData, ChallengeResponseData challengeResponseData, ChallengeRequestExecutor.Config config, int i, Object obj) {
            if ((i & 1) != 0) {
                challengeRequestData = success.creqData;
            }
            if ((i & 2) != 0) {
                challengeResponseData = success.cresData;
            }
            if ((i & 4) != 0) {
                config = success.creqExecutorConfig;
            }
            return success.copy(challengeRequestData, challengeResponseData, config);
        }

        public final ChallengeRequestData component1() {
            return this.creqData;
        }

        public final ChallengeResponseData component2() {
            return this.cresData;
        }

        public final ChallengeRequestExecutor.Config component3$3ds2sdk_release() {
            return this.creqExecutorConfig;
        }

        public final Success copy(ChallengeRequestData challengeRequestData, ChallengeResponseData challengeResponseData, ChallengeRequestExecutor.Config config) {
            Intrinsics.checkNotNullParameter(challengeRequestData, "creqData");
            Intrinsics.checkNotNullParameter(challengeResponseData, "cresData");
            Intrinsics.checkNotNullParameter(config, "creqExecutorConfig");
            return new Success(challengeRequestData, challengeResponseData, config);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            return Intrinsics.areEqual((Object) this.creqData, (Object) success.creqData) && Intrinsics.areEqual((Object) this.cresData, (Object) success.cresData) && Intrinsics.areEqual((Object) this.creqExecutorConfig, (Object) success.creqExecutorConfig);
        }

        public int hashCode() {
            return (((this.creqData.hashCode() * 31) + this.cresData.hashCode()) * 31) + this.creqExecutorConfig.hashCode();
        }

        public String toString() {
            return "Success(creqData=" + this.creqData + ", cresData=" + this.cresData + ", creqExecutorConfig=" + this.creqExecutorConfig + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.creqData.writeToParcel(parcel, i);
            this.cresData.writeToParcel(parcel, i);
            this.creqExecutorConfig.writeToParcel(parcel, i);
        }

        public final ChallengeRequestData getCreqData() {
            return this.creqData;
        }

        public final ChallengeResponseData getCresData() {
            return this.cresData;
        }

        public final ChallengeRequestExecutor.Config getCreqExecutorConfig$3ds2sdk_release() {
            return this.creqExecutorConfig;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(ChallengeRequestData challengeRequestData, ChallengeResponseData challengeResponseData, ChallengeRequestExecutor.Config config) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(challengeRequestData, "creqData");
            Intrinsics.checkNotNullParameter(challengeResponseData, "cresData");
            Intrinsics.checkNotNullParameter(config, "creqExecutorConfig");
            this.creqData = challengeRequestData;
            this.cresData = challengeResponseData;
            this.creqExecutorConfig = config;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$Failure;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "()V", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$ProtocolError;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$RuntimeError;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$Timeout;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeRequestResult.kt */
    public static abstract class Failure extends ChallengeRequestResult {
        public /* synthetic */ Failure(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Failure() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$ProtocolError;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$Failure;", "data", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "(Lcom/stripe/android/stripe3ds2/transactions/ErrorData;)V", "getData", "()Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeRequestResult.kt */
    public static final class ProtocolError extends Failure {
        public static final Parcelable.Creator<ProtocolError> CREATOR = new Creator();
        private final ErrorData data;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeRequestResult.kt */
        public static final class Creator implements Parcelable.Creator<ProtocolError> {
            public final ProtocolError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ProtocolError(ErrorData.CREATOR.createFromParcel(parcel));
            }

            public final ProtocolError[] newArray(int i) {
                return new ProtocolError[i];
            }
        }

        public static /* synthetic */ ProtocolError copy$default(ProtocolError protocolError, ErrorData errorData, int i, Object obj) {
            if ((i & 1) != 0) {
                errorData = protocolError.data;
            }
            return protocolError.copy(errorData);
        }

        public final ErrorData component1() {
            return this.data;
        }

        public final ProtocolError copy(ErrorData errorData) {
            Intrinsics.checkNotNullParameter(errorData, "data");
            return new ProtocolError(errorData);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ProtocolError) && Intrinsics.areEqual((Object) this.data, (Object) ((ProtocolError) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "ProtocolError(data=" + this.data + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.data.writeToParcel(parcel, i);
        }

        public final ErrorData getData() {
            return this.data;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProtocolError(ErrorData errorData) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(errorData, "data");
            this.data = errorData;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$RuntimeError;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$Failure;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeRequestResult.kt */
    public static final class RuntimeError extends Failure {
        public static final Parcelable.Creator<RuntimeError> CREATOR = new Creator();
        private final Throwable throwable;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeRequestResult.kt */
        public static final class Creator implements Parcelable.Creator<RuntimeError> {
            public final RuntimeError createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new RuntimeError((Throwable) parcel.readSerializable());
            }

            public final RuntimeError[] newArray(int i) {
                return new RuntimeError[i];
            }
        }

        public static /* synthetic */ RuntimeError copy$default(RuntimeError runtimeError, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = runtimeError.throwable;
            }
            return runtimeError.copy(th);
        }

        public final Throwable component1() {
            return this.throwable;
        }

        public final RuntimeError copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            return new RuntimeError(th);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RuntimeError) && Intrinsics.areEqual((Object) this.throwable, (Object) ((RuntimeError) obj).throwable);
        }

        public int hashCode() {
            return this.throwable.hashCode();
        }

        public String toString() {
            return "RuntimeError(throwable=" + this.throwable + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeSerializable(this.throwable);
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RuntimeError(Throwable th) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, "throwable");
            this.throwable = th;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$Timeout;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult$Failure;", "data", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "(Lcom/stripe/android/stripe3ds2/transactions/ErrorData;)V", "getData", "()Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeRequestResult.kt */
    public static final class Timeout extends Failure {
        public static final Parcelable.Creator<Timeout> CREATOR = new Creator();
        private final ErrorData data;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeRequestResult.kt */
        public static final class Creator implements Parcelable.Creator<Timeout> {
            public final Timeout createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Timeout(ErrorData.CREATOR.createFromParcel(parcel));
            }

            public final Timeout[] newArray(int i) {
                return new Timeout[i];
            }
        }

        public static /* synthetic */ Timeout copy$default(Timeout timeout, ErrorData errorData, int i, Object obj) {
            if ((i & 1) != 0) {
                errorData = timeout.data;
            }
            return timeout.copy(errorData);
        }

        public final ErrorData component1() {
            return this.data;
        }

        public final Timeout copy(ErrorData errorData) {
            Intrinsics.checkNotNullParameter(errorData, "data");
            return new Timeout(errorData);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Timeout) && Intrinsics.areEqual((Object) this.data, (Object) ((Timeout) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "Timeout(data=" + this.data + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.data.writeToParcel(parcel, i);
        }

        public final ErrorData getData() {
            return this.data;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Timeout(ErrorData errorData) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(errorData, "data");
            this.data = errorData;
        }
    }
}
