package com.stripe.android.stripe3ds2.transaction;

import androidx.exifinterface.media.ExifInterface;
import com.stripe.android.model.Stripe3ds2AuthResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/TransactionStatus;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "VerificationSuccessful", "VerificationDenied", "VerificationNotPerformed", "VerificationAttempted", "ChallengeAdditionalAuth", "ChallengeDecoupledAuth", "VerificationRejected", "InformationOnly", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransactionStatus.kt */
public enum TransactionStatus {
    VerificationSuccessful("Y"),
    VerificationDenied("N"),
    VerificationNotPerformed("U"),
    VerificationAttempted(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS),
    ChallengeAdditionalAuth(Stripe3ds2AuthResult.Ares.VALUE_CHALLENGE),
    ChallengeDecoupledAuth("D"),
    VerificationRejected("R"),
    InformationOnly("I");
    
    public static final Companion Companion = null;
    private final String code;

    private TransactionStatus(String str) {
        this.code = str;
    }

    public final String getCode() {
        return this.code;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/TransactionStatus$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/stripe3ds2/transaction/TransactionStatus;", "code", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TransactionStatus.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TransactionStatus fromCode(String str) {
            if (str == null) {
                return null;
            }
            TransactionStatus[] values = TransactionStatus.values();
            int i = 0;
            int length = values.length;
            while (i < length) {
                TransactionStatus transactionStatus = values[i];
                i++;
                if (Intrinsics.areEqual((Object) transactionStatus.getCode(), (Object) str)) {
                    return transactionStatus;
                }
            }
            return null;
        }
    }
}
