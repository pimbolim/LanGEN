package com.stripe.android.stripe3ds2.transaction;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import com.stripe.android.stripe3ds2.transactions.UiType;
import com.stripe.android.stripe3ds2.views.ChallengeViewArgs;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00052\u00020\u0001:\u0003\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult;", "Landroid/os/Parcelable;", "()V", "toBundle", "Landroid/os/Bundle;", "Companion", "End", "Start", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult$Start;", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult$End;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InitChallengeResult.kt */
public abstract class InitChallengeResult implements Parcelable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_RESULT = "key_init_challenge_result";

    public /* synthetic */ InitChallengeResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private InitChallengeResult() {
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult$Start;", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult;", "challengeViewArgs", "Lcom/stripe/android/stripe3ds2/views/ChallengeViewArgs;", "(Lcom/stripe/android/stripe3ds2/views/ChallengeViewArgs;)V", "getChallengeViewArgs", "()Lcom/stripe/android/stripe3ds2/views/ChallengeViewArgs;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InitChallengeResult.kt */
    public static final class Start extends InitChallengeResult {
        public static final Parcelable.Creator<Start> CREATOR = new Creator();
        private final ChallengeViewArgs challengeViewArgs;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: InitChallengeResult.kt */
        public static final class Creator implements Parcelable.Creator<Start> {
            public final Start createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Start(ChallengeViewArgs.CREATOR.createFromParcel(parcel));
            }

            public final Start[] newArray(int i) {
                return new Start[i];
            }
        }

        public static /* synthetic */ Start copy$default(Start start, ChallengeViewArgs challengeViewArgs2, int i, Object obj) {
            if ((i & 1) != 0) {
                challengeViewArgs2 = start.challengeViewArgs;
            }
            return start.copy(challengeViewArgs2);
        }

        public final ChallengeViewArgs component1() {
            return this.challengeViewArgs;
        }

        public final Start copy(ChallengeViewArgs challengeViewArgs2) {
            Intrinsics.checkNotNullParameter(challengeViewArgs2, "challengeViewArgs");
            return new Start(challengeViewArgs2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Start) && Intrinsics.areEqual((Object) this.challengeViewArgs, (Object) ((Start) obj).challengeViewArgs);
        }

        public int hashCode() {
            return this.challengeViewArgs.hashCode();
        }

        public String toString() {
            return "Start(challengeViewArgs=" + this.challengeViewArgs + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.challengeViewArgs.writeToParcel(parcel, i);
        }

        public final ChallengeViewArgs getChallengeViewArgs() {
            return this.challengeViewArgs;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Start(ChallengeViewArgs challengeViewArgs2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(challengeViewArgs2, "challengeViewArgs");
            this.challengeViewArgs = challengeViewArgs2;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult$End;", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult;", "challengeResult", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "(Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;)V", "getChallengeResult", "()Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InitChallengeResult.kt */
    public static final class End extends InitChallengeResult {
        public static final Parcelable.Creator<End> CREATOR = new Creator();
        private final ChallengeResult challengeResult;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: InitChallengeResult.kt */
        public static final class Creator implements Parcelable.Creator<End> {
            public final End createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new End((ChallengeResult) parcel.readParcelable(End.class.getClassLoader()));
            }

            public final End[] newArray(int i) {
                return new End[i];
            }
        }

        public static /* synthetic */ End copy$default(End end, ChallengeResult challengeResult2, int i, Object obj) {
            if ((i & 1) != 0) {
                challengeResult2 = end.challengeResult;
            }
            return end.copy(challengeResult2);
        }

        public final ChallengeResult component1() {
            return this.challengeResult;
        }

        public final End copy(ChallengeResult challengeResult2) {
            Intrinsics.checkNotNullParameter(challengeResult2, "challengeResult");
            return new End(challengeResult2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof End) && Intrinsics.areEqual((Object) this.challengeResult, (Object) ((End) obj).challengeResult);
        }

        public int hashCode() {
            return this.challengeResult.hashCode();
        }

        public String toString() {
            return "End(challengeResult=" + this.challengeResult + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.challengeResult, i);
        }

        public final ChallengeResult getChallengeResult() {
            return this.challengeResult;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public End(ChallengeResult challengeResult2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(challengeResult2, "challengeResult");
            this.challengeResult = challengeResult2;
        }
    }

    public final Bundle toBundle() {
        return BundleKt.bundleOf(TuplesKt.to(KEY_RESULT, this));
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult$Companion;", "", "()V", "KEY_RESULT", "", "fromBundle", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeResult;", "bundle", "Landroid/os/Bundle;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InitChallengeResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final InitChallengeResult fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            InitChallengeResult initChallengeResult = (InitChallengeResult) bundle.getParcelable(InitChallengeResult.KEY_RESULT);
            return initChallengeResult == null ? new End(new ChallengeResult.RuntimeError(new IllegalArgumentException("Could not retrieve result."), (UiType) null, IntentData.Companion.getEMPTY())) : initChallengeResult;
        }
    }
}
