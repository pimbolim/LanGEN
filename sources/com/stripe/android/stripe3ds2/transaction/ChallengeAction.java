package com.stripe.android.stripe3ds2.transaction;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "Landroid/os/Parcelable;", "()V", "Cancel", "HtmlForm", "NativeForm", "Oob", "Resend", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction$NativeForm;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction$HtmlForm;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction$Oob;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction$Resend;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction$Cancel;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeAction.kt */
public abstract class ChallengeAction implements Parcelable {
    public /* synthetic */ ChallengeAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ChallengeAction() {
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction$NativeForm;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "userEntry", "", "(Ljava/lang/String;)V", "getUserEntry$3ds2sdk_release", "()Ljava/lang/String;", "component1", "component1$3ds2sdk_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeAction.kt */
    public static final class NativeForm extends ChallengeAction {
        public static final Parcelable.Creator<NativeForm> CREATOR = new Creator();
        private final String userEntry;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeAction.kt */
        public static final class Creator implements Parcelable.Creator<NativeForm> {
            public final NativeForm createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NativeForm(parcel.readString());
            }

            public final NativeForm[] newArray(int i) {
                return new NativeForm[i];
            }
        }

        public static /* synthetic */ NativeForm copy$default(NativeForm nativeForm, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nativeForm.userEntry;
            }
            return nativeForm.copy(str);
        }

        public final String component1$3ds2sdk_release() {
            return this.userEntry;
        }

        public final NativeForm copy(String str) {
            Intrinsics.checkNotNullParameter(str, "userEntry");
            return new NativeForm(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NativeForm) && Intrinsics.areEqual((Object) this.userEntry, (Object) ((NativeForm) obj).userEntry);
        }

        public int hashCode() {
            return this.userEntry.hashCode();
        }

        public String toString() {
            return "NativeForm(userEntry=" + this.userEntry + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.userEntry);
        }

        public final String getUserEntry$3ds2sdk_release() {
            return this.userEntry;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NativeForm(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "userEntry");
            this.userEntry = str;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\bJ\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction$HtmlForm;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "userEntry", "", "(Ljava/lang/String;)V", "getUserEntry$3ds2sdk_release", "()Ljava/lang/String;", "component1", "component1$3ds2sdk_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeAction.kt */
    public static final class HtmlForm extends ChallengeAction {
        public static final Parcelable.Creator<HtmlForm> CREATOR = new Creator();
        private final String userEntry;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeAction.kt */
        public static final class Creator implements Parcelable.Creator<HtmlForm> {
            public final HtmlForm createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new HtmlForm(parcel.readString());
            }

            public final HtmlForm[] newArray(int i) {
                return new HtmlForm[i];
            }
        }

        public static /* synthetic */ HtmlForm copy$default(HtmlForm htmlForm, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = htmlForm.userEntry;
            }
            return htmlForm.copy(str);
        }

        public final String component1$3ds2sdk_release() {
            return this.userEntry;
        }

        public final HtmlForm copy(String str) {
            Intrinsics.checkNotNullParameter(str, "userEntry");
            return new HtmlForm(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HtmlForm) && Intrinsics.areEqual((Object) this.userEntry, (Object) ((HtmlForm) obj).userEntry);
        }

        public int hashCode() {
            return this.userEntry.hashCode();
        }

        public String toString() {
            return "HtmlForm(userEntry=" + this.userEntry + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.userEntry);
        }

        public final String getUserEntry$3ds2sdk_release() {
            return this.userEntry;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HtmlForm(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "userEntry");
            this.userEntry = str;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction$Oob;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeAction.kt */
    public static final class Oob extends ChallengeAction {
        public static final Parcelable.Creator<Oob> CREATOR = new Creator();
        public static final Oob INSTANCE = new Oob();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeAction.kt */
        public static final class Creator implements Parcelable.Creator<Oob> {
            public final Oob createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Oob.INSTANCE;
            }

            public final Oob[] newArray(int i) {
                return new Oob[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Oob() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction$Resend;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeAction.kt */
    public static final class Resend extends ChallengeAction {
        public static final Parcelable.Creator<Resend> CREATOR = new Creator();
        public static final Resend INSTANCE = new Resend();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeAction.kt */
        public static final class Creator implements Parcelable.Creator<Resend> {
            public final Resend createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Resend.INSTANCE;
            }

            public final Resend[] newArray(int i) {
                return new Resend[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Resend() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004HÖ\u0001¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction$Cancel;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeAction.kt */
    public static final class Cancel extends ChallengeAction {
        public static final Parcelable.Creator<Cancel> CREATOR = new Creator();
        public static final Cancel INSTANCE = new Cancel();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ChallengeAction.kt */
        public static final class Creator implements Parcelable.Creator<Cancel> {
            public final Cancel createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.readInt();
                return Cancel.INSTANCE;
            }

            public final Cancel[] newArray(int i) {
                return new Cancel[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(1);
        }

        private Cancel() {
            super((DefaultConstructorMarker) null);
        }
    }
}
