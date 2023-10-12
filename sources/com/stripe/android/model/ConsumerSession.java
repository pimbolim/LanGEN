package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.braintreepayments.api.models.PostalAddressParser;
import com.stripe.android.core.model.StripeModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001%B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/stripe/android/model/ConsumerSession;", "Lcom/stripe/android/core/model/StripeModel;", "clientSecret", "", "emailAddress", "redactedPhoneNumber", "verificationSessions", "", "Lcom/stripe/android/model/ConsumerSession$VerificationSession;", "authSessionClientSecret", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getAuthSessionClientSecret", "()Ljava/lang/String;", "getClientSecret", "getEmailAddress", "getRedactedPhoneNumber", "getVerificationSessions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "VerificationSession", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConsumerSession.kt */
public final class ConsumerSession implements StripeModel {
    public static final int $stable = 8;
    public static final Parcelable.Creator<ConsumerSession> CREATOR = new Creator();
    private final String authSessionClientSecret;
    private final String clientSecret;
    private final String emailAddress;
    private final String redactedPhoneNumber;
    private final List<VerificationSession> verificationSessions;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConsumerSession.kt */
    public static final class Creator implements Parcelable.Creator<ConsumerSession> {
        public final ConsumerSession createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(VerificationSession.CREATOR.createFromParcel(parcel));
            }
            return new ConsumerSession(readString, readString2, readString3, arrayList, parcel.readString());
        }

        public final ConsumerSession[] newArray(int i) {
            return new ConsumerSession[i];
        }
    }

    public static /* synthetic */ ConsumerSession copy$default(ConsumerSession consumerSession, String str, String str2, String str3, List<VerificationSession> list, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = consumerSession.clientSecret;
        }
        if ((i & 2) != 0) {
            str2 = consumerSession.emailAddress;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = consumerSession.redactedPhoneNumber;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            list = consumerSession.verificationSessions;
        }
        List<VerificationSession> list2 = list;
        if ((i & 16) != 0) {
            str4 = consumerSession.authSessionClientSecret;
        }
        return consumerSession.copy(str, str5, str6, list2, str4);
    }

    public final String component1() {
        return this.clientSecret;
    }

    public final String component2() {
        return this.emailAddress;
    }

    public final String component3() {
        return this.redactedPhoneNumber;
    }

    public final List<VerificationSession> component4() {
        return this.verificationSessions;
    }

    public final String component5() {
        return this.authSessionClientSecret;
    }

    public final ConsumerSession copy(String str, String str2, String str3, List<VerificationSession> list, String str4) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(str2, HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS);
        Intrinsics.checkNotNullParameter(str3, "redactedPhoneNumber");
        Intrinsics.checkNotNullParameter(list, "verificationSessions");
        return new ConsumerSession(str, str2, str3, list, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsumerSession)) {
            return false;
        }
        ConsumerSession consumerSession = (ConsumerSession) obj;
        return Intrinsics.areEqual((Object) this.clientSecret, (Object) consumerSession.clientSecret) && Intrinsics.areEqual((Object) this.emailAddress, (Object) consumerSession.emailAddress) && Intrinsics.areEqual((Object) this.redactedPhoneNumber, (Object) consumerSession.redactedPhoneNumber) && Intrinsics.areEqual((Object) this.verificationSessions, (Object) consumerSession.verificationSessions) && Intrinsics.areEqual((Object) this.authSessionClientSecret, (Object) consumerSession.authSessionClientSecret);
    }

    public int hashCode() {
        int hashCode = ((((((this.clientSecret.hashCode() * 31) + this.emailAddress.hashCode()) * 31) + this.redactedPhoneNumber.hashCode()) * 31) + this.verificationSessions.hashCode()) * 31;
        String str = this.authSessionClientSecret;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ConsumerSession(clientSecret=" + this.clientSecret + ", emailAddress=" + this.emailAddress + ", redactedPhoneNumber=" + this.redactedPhoneNumber + ", verificationSessions=" + this.verificationSessions + ", authSessionClientSecret=" + this.authSessionClientSecret + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.clientSecret);
        parcel.writeString(this.emailAddress);
        parcel.writeString(this.redactedPhoneNumber);
        List<VerificationSession> list = this.verificationSessions;
        parcel.writeInt(list.size());
        for (VerificationSession writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i);
        }
        parcel.writeString(this.authSessionClientSecret);
    }

    public ConsumerSession(String str, String str2, String str3, List<VerificationSession> list, String str4) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(str2, HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS);
        Intrinsics.checkNotNullParameter(str3, "redactedPhoneNumber");
        Intrinsics.checkNotNullParameter(list, "verificationSessions");
        this.clientSecret = str;
        this.emailAddress = str2;
        this.redactedPhoneNumber = str3;
        this.verificationSessions = list;
        this.authSessionClientSecret = str4;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final String getEmailAddress() {
        return this.emailAddress;
    }

    public final String getRedactedPhoneNumber() {
        return this.redactedPhoneNumber;
    }

    public final List<VerificationSession> getVerificationSessions() {
        return this.verificationSessions;
    }

    public final String getAuthSessionClientSecret() {
        return this.authSessionClientSecret;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/model/ConsumerSession$VerificationSession;", "Lcom/stripe/android/core/model/StripeModel;", "type", "Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionType;", "state", "Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionState;", "(Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionType;Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionState;)V", "getState", "()Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionState;", "getType", "()Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionType;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SessionState", "SessionType", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConsumerSession.kt */
    public static final class VerificationSession implements StripeModel {
        public static final int $stable = 8;
        public static final Parcelable.Creator<VerificationSession> CREATOR = new Creator();
        private final SessionState state;
        private final SessionType type;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConsumerSession.kt */
        public static final class Creator implements Parcelable.Creator<VerificationSession> {
            public final VerificationSession createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new VerificationSession(SessionType.CREATOR.createFromParcel(parcel), SessionState.CREATOR.createFromParcel(parcel));
            }

            public final VerificationSession[] newArray(int i) {
                return new VerificationSession[i];
            }
        }

        public static /* synthetic */ VerificationSession copy$default(VerificationSession verificationSession, SessionType sessionType, SessionState sessionState, int i, Object obj) {
            if ((i & 1) != 0) {
                sessionType = verificationSession.type;
            }
            if ((i & 2) != 0) {
                sessionState = verificationSession.state;
            }
            return verificationSession.copy(sessionType, sessionState);
        }

        public final SessionType component1() {
            return this.type;
        }

        public final SessionState component2() {
            return this.state;
        }

        public final VerificationSession copy(SessionType sessionType, SessionState sessionState) {
            Intrinsics.checkNotNullParameter(sessionType, "type");
            Intrinsics.checkNotNullParameter(sessionState, PostalAddressParser.REGION_KEY);
            return new VerificationSession(sessionType, sessionState);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VerificationSession)) {
                return false;
            }
            VerificationSession verificationSession = (VerificationSession) obj;
            return this.type == verificationSession.type && this.state == verificationSession.state;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.state.hashCode();
        }

        public String toString() {
            return "VerificationSession(type=" + this.type + ", state=" + this.state + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.type.writeToParcel(parcel, i);
            this.state.writeToParcel(parcel, i);
        }

        public VerificationSession(SessionType sessionType, SessionState sessionState) {
            Intrinsics.checkNotNullParameter(sessionType, "type");
            Intrinsics.checkNotNullParameter(sessionState, PostalAddressParser.REGION_KEY);
            this.type = sessionType;
            this.state = sessionState;
        }

        public final SessionType getType() {
            return this.type;
        }

        public final SessionState getState() {
            return this.state;
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionType;", "", "Landroid/os/Parcelable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Unknown", "SignUp", "Email", "Sms", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConsumerSession.kt */
        public enum SessionType implements Parcelable {
            Unknown(""),
            SignUp("signup"),
            Email("email"),
            Sms("sms");
            
            public static final Parcelable.Creator<SessionType> CREATOR = null;
            public static final Companion Companion = null;
            private final String value;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ConsumerSession.kt */
            public static final class Creator implements Parcelable.Creator<SessionType> {
                public final SessionType createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return SessionType.valueOf(parcel.readString());
                }

                public final SessionType[] newArray(int i) {
                    return new SessionType[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(name());
            }

            private SessionType(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
                CREATOR = new Creator();
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionType$Companion;", "", "()V", "fromValue", "Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionType;", "value", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ConsumerSession.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final SessionType fromValue(String str) {
                    SessionType sessionType;
                    Intrinsics.checkNotNullParameter(str, "value");
                    SessionType[] values = SessionType.values();
                    int length = values.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            sessionType = null;
                            break;
                        }
                        sessionType = values[i];
                        i++;
                        if (StringsKt.equals(sessionType.getValue(), str, true)) {
                            break;
                        }
                    }
                    return sessionType == null ? SessionType.Unknown : sessionType;
                }
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0015B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionState;", "", "Landroid/os/Parcelable;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Unknown", "Started", "Failed", "Verified", "Canceled", "Expired", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConsumerSession.kt */
        public enum SessionState implements Parcelable {
            Unknown(""),
            Started("started"),
            Failed("failed"),
            Verified("verified"),
            Canceled("canceled"),
            Expired("expired");
            
            public static final Parcelable.Creator<SessionState> CREATOR = null;
            public static final Companion Companion = null;
            private final String value;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ConsumerSession.kt */
            public static final class Creator implements Parcelable.Creator<SessionState> {
                public final SessionState createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return SessionState.valueOf(parcel.readString());
                }

                public final SessionState[] newArray(int i) {
                    return new SessionState[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(name());
            }

            private SessionState(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }

            static {
                Companion = new Companion((DefaultConstructorMarker) null);
                CREATOR = new Creator();
            }

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionState$Companion;", "", "()V", "fromValue", "Lcom/stripe/android/model/ConsumerSession$VerificationSession$SessionState;", "value", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ConsumerSession.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final SessionState fromValue(String str) {
                    SessionState sessionState;
                    Intrinsics.checkNotNullParameter(str, "value");
                    SessionState[] values = SessionState.values();
                    int length = values.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            sessionState = null;
                            break;
                        }
                        sessionState = values[i];
                        i++;
                        if (StringsKt.equals(sessionState.getValue(), str, true)) {
                            break;
                        }
                    }
                    return sessionState == null ? SessionState.Unknown : sessionState;
                }
            }
        }
    }
}
