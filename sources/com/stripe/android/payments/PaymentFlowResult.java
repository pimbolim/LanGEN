package com.stripe.android.payments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.model.Source;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.parcelize.Parceler;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/payments/PaymentFlowResult;", "", "()V", "Unvalidated", "Validated", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowResult.kt */
public abstract class PaymentFlowResult {
    public static final int $stable = 0;

    public /* synthetic */ PaymentFlowResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PaymentFlowResult() {
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 72\u00020\u0001:\u00017BU\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000e\u0010\u001e\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b!J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÀ\u0003¢\u0006\u0002\b#J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b%JY\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0013\u0010(\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\u0006\u0010,\u001a\u00020-J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\r\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b1J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u00068"}, d2 = {"Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "Landroid/os/Parcelable;", "clientSecret", "", "flowOutcome", "", "exception", "Lcom/stripe/android/core/exception/StripeException;", "canCancelSource", "", "sourceId", "source", "Lcom/stripe/android/model/Source;", "stripeAccountId", "(Ljava/lang/String;ILcom/stripe/android/core/exception/StripeException;ZLjava/lang/String;Lcom/stripe/android/model/Source;Ljava/lang/String;)V", "getCanCancelSource$payments_core_release", "()Z", "getClientSecret", "()Ljava/lang/String;", "getException", "()Lcom/stripe/android/core/exception/StripeException;", "getFlowOutcome", "()I", "getSource$payments_core_release", "()Lcom/stripe/android/model/Source;", "getSourceId$payments_core_release", "getStripeAccountId$payments_core_release", "component1", "component2", "component3", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "component6", "component6$payments_core_release", "component7", "component7$payments_core_release", "copy", "describeContents", "equals", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "validate", "Lcom/stripe/android/payments/PaymentFlowResult$Validated;", "validate$payments_core_release", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentFlowResult.kt */
    public static final class Unvalidated implements Parcelable {
        public static final int $stable = 8;
        private static final String CLIENT_SECRET_INTENT_ERROR = "Invalid client_secret value in result Intent.";
        public static final Parcelable.Creator<Unvalidated> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String EXTRA = "extra_args";
        private final boolean canCancelSource;
        private final String clientSecret;
        private final StripeException exception;
        private final int flowOutcome;
        private final Source source;
        private final String sourceId;
        private final String stripeAccountId;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentFlowResult.kt */
        public static final class Creator implements Parcelable.Creator<Unvalidated> {
            public final Unvalidated createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return Unvalidated.Companion.create(parcel);
            }

            public final Unvalidated[] newArray(int i) {
                return new Unvalidated[i];
            }
        }

        public Unvalidated() {
            this((String) null, 0, (StripeException) null, false, (String) null, (Source) null, (String) null, 127, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Unvalidated copy$default(Unvalidated unvalidated, String str, int i, StripeException stripeException, boolean z, String str2, Source source2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = unvalidated.clientSecret;
            }
            if ((i2 & 2) != 0) {
                i = unvalidated.flowOutcome;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                stripeException = unvalidated.exception;
            }
            StripeException stripeException2 = stripeException;
            if ((i2 & 8) != 0) {
                z = unvalidated.canCancelSource;
            }
            boolean z2 = z;
            if ((i2 & 16) != 0) {
                str2 = unvalidated.sourceId;
            }
            String str4 = str2;
            if ((i2 & 32) != 0) {
                source2 = unvalidated.source;
            }
            Source source3 = source2;
            if ((i2 & 64) != 0) {
                str3 = unvalidated.stripeAccountId;
            }
            return unvalidated.copy(str, i3, stripeException2, z2, str4, source3, str3);
        }

        public final String component1() {
            return this.clientSecret;
        }

        public final int component2() {
            return this.flowOutcome;
        }

        public final StripeException component3() {
            return this.exception;
        }

        public final boolean component4$payments_core_release() {
            return this.canCancelSource;
        }

        public final String component5$payments_core_release() {
            return this.sourceId;
        }

        public final Source component6$payments_core_release() {
            return this.source;
        }

        public final String component7$payments_core_release() {
            return this.stripeAccountId;
        }

        public final Unvalidated copy(String str, int i, StripeException stripeException, boolean z, String str2, Source source2, String str3) {
            return new Unvalidated(str, i, stripeException, z, str2, source2, str3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Unvalidated)) {
                return false;
            }
            Unvalidated unvalidated = (Unvalidated) obj;
            return Intrinsics.areEqual((Object) this.clientSecret, (Object) unvalidated.clientSecret) && this.flowOutcome == unvalidated.flowOutcome && Intrinsics.areEqual((Object) this.exception, (Object) unvalidated.exception) && this.canCancelSource == unvalidated.canCancelSource && Intrinsics.areEqual((Object) this.sourceId, (Object) unvalidated.sourceId) && Intrinsics.areEqual((Object) this.source, (Object) unvalidated.source) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) unvalidated.stripeAccountId);
        }

        public int hashCode() {
            String str = this.clientSecret;
            int i = 0;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.flowOutcome) * 31;
            StripeException stripeException = this.exception;
            int hashCode2 = (hashCode + (stripeException == null ? 0 : stripeException.hashCode())) * 31;
            boolean z = this.canCancelSource;
            if (z) {
                z = true;
            }
            int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
            String str2 = this.sourceId;
            int hashCode3 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Source source2 = this.source;
            int hashCode4 = (hashCode3 + (source2 == null ? 0 : source2.hashCode())) * 31;
            String str3 = this.stripeAccountId;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            return "Unvalidated(clientSecret=" + this.clientSecret + ", flowOutcome=" + this.flowOutcome + ", exception=" + this.exception + ", canCancelSource=" + this.canCancelSource + ", sourceId=" + this.sourceId + ", source=" + this.source + ", stripeAccountId=" + this.stripeAccountId + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Companion.write(this, parcel, i);
        }

        public Unvalidated(String str, int i, StripeException stripeException, boolean z, String str2, Source source2, String str3) {
            this.clientSecret = str;
            this.flowOutcome = i;
            this.exception = stripeException;
            this.canCancelSource = z;
            this.sourceId = str2;
            this.source = source2;
            this.stripeAccountId = str3;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Unvalidated(java.lang.String r7, int r8, com.stripe.android.core.exception.StripeException r9, boolean r10, java.lang.String r11, com.stripe.android.model.Source r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
            /*
                r6 = this;
                r15 = r14 & 1
                r0 = 0
                if (r15 == 0) goto L_0x0007
                r15 = r0
                goto L_0x0008
            L_0x0007:
                r15 = r7
            L_0x0008:
                r7 = r14 & 2
                r1 = 0
                if (r7 == 0) goto L_0x000f
                r2 = 0
                goto L_0x0010
            L_0x000f:
                r2 = r8
            L_0x0010:
                r7 = r14 & 4
                if (r7 == 0) goto L_0x0016
                r3 = r0
                goto L_0x0017
            L_0x0016:
                r3 = r9
            L_0x0017:
                r7 = r14 & 8
                if (r7 == 0) goto L_0x001c
                goto L_0x001d
            L_0x001c:
                r1 = r10
            L_0x001d:
                r7 = r14 & 16
                if (r7 == 0) goto L_0x0023
                r4 = r0
                goto L_0x0024
            L_0x0023:
                r4 = r11
            L_0x0024:
                r7 = r14 & 32
                if (r7 == 0) goto L_0x002a
                r5 = r0
                goto L_0x002b
            L_0x002a:
                r5 = r12
            L_0x002b:
                r7 = r14 & 64
                if (r7 == 0) goto L_0x0031
                r14 = r0
                goto L_0x0032
            L_0x0031:
                r14 = r13
            L_0x0032:
                r7 = r6
                r8 = r15
                r9 = r2
                r10 = r3
                r11 = r1
                r12 = r4
                r13 = r5
                r7.<init>(r8, r9, r10, r11, r12, r13, r14)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.PaymentFlowResult.Unvalidated.<init>(java.lang.String, int, com.stripe.android.core.exception.StripeException, boolean, java.lang.String, com.stripe.android.model.Source, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getClientSecret() {
            return this.clientSecret;
        }

        public final int getFlowOutcome() {
            return this.flowOutcome;
        }

        public final StripeException getException() {
            return this.exception;
        }

        public final boolean getCanCancelSource$payments_core_release() {
            return this.canCancelSource;
        }

        public final String getSourceId$payments_core_release() {
            return this.sourceId;
        }

        public final Source getSource$payments_core_release() {
            return this.source;
        }

        public final String getStripeAccountId$payments_core_release() {
            return this.stripeAccountId;
        }

        public final /* synthetic */ Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to(EXTRA, this));
        }

        public final Validated validate$payments_core_release() {
            StripeException stripeException = this.exception;
            if (!(stripeException instanceof Throwable)) {
                CharSequence charSequence = this.clientSecret;
                if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                    return new Validated(this.clientSecret, this.flowOutcome, this.canCancelSource, this.sourceId, this.source, this.stripeAccountId);
                }
                throw new IllegalArgumentException(CLIENT_SECRET_INTENT_ERROR.toString());
            }
            throw stripeException;
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001c\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated$Companion;", "Lkotlinx/parcelize/Parceler;", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "()V", "CLIENT_SECRET_INTENT_ERROR", "", "EXTRA", "create", "parcel", "Landroid/os/Parcel;", "fromIntent", "intent", "Landroid/content/Intent;", "write", "", "flags", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentFlowResult.kt */
        public static final class Companion implements Parceler<Unvalidated> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public Unvalidated[] newArray(int i) {
                return (Unvalidated[]) Parceler.DefaultImpls.newArray(this, i);
            }

            public Unvalidated create(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                Serializable readSerializable = parcel.readSerializable();
                StripeException stripeException = readSerializable instanceof StripeException ? (StripeException) readSerializable : null;
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                return new Unvalidated(readString, readInt, stripeException, z, parcel.readString(), (Source) parcel.readParcelable(Source.class.getClassLoader()), parcel.readString());
            }

            public void write(Unvalidated unvalidated, Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(unvalidated, "<this>");
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(unvalidated.getClientSecret());
                parcel.writeInt(unvalidated.getFlowOutcome());
                parcel.writeSerializable(unvalidated.getException());
                Integer num = 1;
                num.intValue();
                if (!unvalidated.getCanCancelSource$payments_core_release()) {
                    num = null;
                }
                parcel.writeInt(num == null ? 0 : num.intValue());
                parcel.writeString(unvalidated.getSourceId$payments_core_release());
                parcel.writeParcelable(unvalidated.getSource$payments_core_release(), i);
                parcel.writeString(unvalidated.getStripeAccountId$payments_core_release());
            }

            public final /* synthetic */ Unvalidated fromIntent(Intent intent) {
                Unvalidated unvalidated = intent == null ? null : (Unvalidated) intent.getParcelableExtra(Unvalidated.EXTRA);
                return unvalidated == null ? new Unvalidated((String) null, 0, (StripeException) null, false, (String) null, (Source) null, (String) null, 127, (DefaultConstructorMarker) null) : unvalidated;
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001BE\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0018\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÀ\u0003¢\u0006\u0002\b\u001fJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b!JK\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006'"}, d2 = {"Lcom/stripe/android/payments/PaymentFlowResult$Validated;", "", "clientSecret", "", "flowOutcome", "", "canCancelSource", "", "sourceId", "source", "Lcom/stripe/android/model/Source;", "stripeAccountId", "(Ljava/lang/String;IZLjava/lang/String;Lcom/stripe/android/model/Source;Ljava/lang/String;)V", "getCanCancelSource$payments_core_release", "()Z", "getClientSecret", "()Ljava/lang/String;", "getFlowOutcome$payments_core_release", "()I", "getSource$payments_core_release", "()Lcom/stripe/android/model/Source;", "getSourceId$payments_core_release", "getStripeAccountId$payments_core_release", "component1", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "component6", "component6$payments_core_release", "copy", "equals", "other", "hashCode", "toString", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentFlowResult.kt */
    public static final class Validated {
        private final boolean canCancelSource;
        private final String clientSecret;
        private final int flowOutcome;
        private final Source source;
        private final String sourceId;
        private final String stripeAccountId;

        public static /* synthetic */ Validated copy$default(Validated validated, String str, int i, boolean z, String str2, Source source2, String str3, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = validated.clientSecret;
            }
            if ((i2 & 2) != 0) {
                i = validated.flowOutcome;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                z = validated.canCancelSource;
            }
            boolean z2 = z;
            if ((i2 & 8) != 0) {
                str2 = validated.sourceId;
            }
            String str4 = str2;
            if ((i2 & 16) != 0) {
                source2 = validated.source;
            }
            Source source3 = source2;
            if ((i2 & 32) != 0) {
                str3 = validated.stripeAccountId;
            }
            return validated.copy(str, i3, z2, str4, source3, str3);
        }

        public final String component1() {
            return this.clientSecret;
        }

        public final int component2$payments_core_release() {
            return this.flowOutcome;
        }

        public final boolean component3$payments_core_release() {
            return this.canCancelSource;
        }

        public final String component4$payments_core_release() {
            return this.sourceId;
        }

        public final Source component5$payments_core_release() {
            return this.source;
        }

        public final String component6$payments_core_release() {
            return this.stripeAccountId;
        }

        public final Validated copy(String str, int i, boolean z, String str2, Source source2, String str3) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            return new Validated(str, i, z, str2, source2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Validated)) {
                return false;
            }
            Validated validated = (Validated) obj;
            return Intrinsics.areEqual((Object) this.clientSecret, (Object) validated.clientSecret) && this.flowOutcome == validated.flowOutcome && this.canCancelSource == validated.canCancelSource && Intrinsics.areEqual((Object) this.sourceId, (Object) validated.sourceId) && Intrinsics.areEqual((Object) this.source, (Object) validated.source) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) validated.stripeAccountId);
        }

        public int hashCode() {
            int hashCode = ((this.clientSecret.hashCode() * 31) + this.flowOutcome) * 31;
            boolean z = this.canCancelSource;
            if (z) {
                z = true;
            }
            int i = (hashCode + (z ? 1 : 0)) * 31;
            String str = this.sourceId;
            int i2 = 0;
            int hashCode2 = (i + (str == null ? 0 : str.hashCode())) * 31;
            Source source2 = this.source;
            int hashCode3 = (hashCode2 + (source2 == null ? 0 : source2.hashCode())) * 31;
            String str2 = this.stripeAccountId;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return hashCode3 + i2;
        }

        public String toString() {
            return "Validated(clientSecret=" + this.clientSecret + ", flowOutcome=" + this.flowOutcome + ", canCancelSource=" + this.canCancelSource + ", sourceId=" + this.sourceId + ", source=" + this.source + ", stripeAccountId=" + this.stripeAccountId + ')';
        }

        public Validated(String str, int i, boolean z, String str2, Source source2, String str3) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            this.clientSecret = str;
            this.flowOutcome = i;
            this.canCancelSource = z;
            this.sourceId = str2;
            this.source = source2;
            this.stripeAccountId = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Validated(String str, int i, boolean z, String str2, Source source2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : source2, (i2 & 32) != 0 ? null : str3);
        }

        public final String getClientSecret() {
            return this.clientSecret;
        }

        public final int getFlowOutcome$payments_core_release() {
            return this.flowOutcome;
        }

        public final boolean getCanCancelSource$payments_core_release() {
            return this.canCancelSource;
        }

        public final String getSourceId$payments_core_release() {
            return this.sourceId;
        }

        public final Source getSource$payments_core_release() {
            return this.source;
        }

        public final String getStripeAccountId$payments_core_release() {
            return this.stripeAccountId;
        }
    }
}
