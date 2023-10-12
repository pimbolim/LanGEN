package com.stripe.android.link.model;

import com.stripe.android.model.ConsumerSession;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\f\u0010\u0011\u001a\u00020\f*\u00020\u0003H\u0002J\f\u0010\u0012\u001a\u00020\f*\u00020\u0003H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/link/model/LinkAccount;", "", "consumerSession", "Lcom/stripe/android/model/ConsumerSession;", "(Lcom/stripe/android/model/ConsumerSession;)V", "clientSecret", "", "getClientSecret", "()Ljava/lang/String;", "email", "getEmail", "isVerified", "", "()Z", "redactedPhoneNumber", "getRedactedPhoneNumber", "getAuthSessionCookie", "containsVerifiedSMSSession", "isVerifiedForSignup", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkAccount.kt */
public final class LinkAccount {
    private final String clientSecret;
    private final ConsumerSession consumerSession;
    private final String email;
    private final boolean isVerified;
    private final String redactedPhoneNumber;

    public LinkAccount(ConsumerSession consumerSession2) {
        Intrinsics.checkNotNullParameter(consumerSession2, "consumerSession");
        this.consumerSession = consumerSession2;
        this.redactedPhoneNumber = consumerSession2.getRedactedPhoneNumber();
        this.clientSecret = consumerSession2.getClientSecret();
        this.email = consumerSession2.getEmailAddress();
        this.isVerified = containsVerifiedSMSSession(consumerSession2) || isVerifiedForSignup(consumerSession2);
    }

    public final String getRedactedPhoneNumber() {
        return this.redactedPhoneNumber;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean isVerified() {
        return this.isVerified;
    }

    public final String getAuthSessionCookie() {
        return this.consumerSession.getAuthSessionClientSecret();
    }

    private final boolean containsVerifiedSMSSession(ConsumerSession consumerSession2) {
        Object obj;
        boolean z;
        Iterator it = consumerSession2.getVerificationSessions().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ConsumerSession.VerificationSession verificationSession = (ConsumerSession.VerificationSession) obj;
            if (verificationSession.getType() == ConsumerSession.VerificationSession.SessionType.Sms && verificationSession.getState() == ConsumerSession.VerificationSession.SessionState.Verified) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    private final boolean isVerifiedForSignup(ConsumerSession consumerSession2) {
        Object obj;
        boolean z;
        Iterator it = consumerSession2.getVerificationSessions().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ConsumerSession.VerificationSession verificationSession = (ConsumerSession.VerificationSession) obj;
            if (verificationSession.getType() == ConsumerSession.VerificationSession.SessionType.SignUp && verificationSession.getState() == ConsumerSession.VerificationSession.SessionState.Started) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }
}
