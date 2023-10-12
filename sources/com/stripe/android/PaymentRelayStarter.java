package com.stripe.android;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.model.Source;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.view.AuthActivityStarter;
import com.stripe.android.view.AuthActivityStarterHost;
import com.stripe.android.view.PaymentRelayActivity;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parceler;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/PaymentRelayStarter;", "Lcom/stripe/android/view/AuthActivityStarter;", "Lcom/stripe/android/PaymentRelayStarter$Args;", "Args", "Legacy", "Modern", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentRelayStarter.kt */
public interface PaymentRelayStarter extends AuthActivityStarter<Args> {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/PaymentRelayStarter$Legacy;", "Lcom/stripe/android/PaymentRelayStarter;", "host", "Lcom/stripe/android/view/AuthActivityStarterHost;", "(Lcom/stripe/android/view/AuthActivityStarterHost;)V", "start", "", "args", "Lcom/stripe/android/PaymentRelayStarter$Args;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentRelayStarter.kt */
    public static final class Legacy implements PaymentRelayStarter {
        public static final int $stable = 0;
        private final AuthActivityStarterHost host;

        public Legacy(AuthActivityStarterHost authActivityStarterHost) {
            Intrinsics.checkNotNullParameter(authActivityStarterHost, "host");
            this.host = authActivityStarterHost;
        }

        public void start(Args args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.host.startActivityForResult(PaymentRelayActivity.class, args.toResult().toBundle(), args.getRequestCode());
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/PaymentRelayStarter$Modern;", "Lcom/stripe/android/PaymentRelayStarter;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/PaymentRelayStarter$Args;", "(Landroidx/activity/result/ActivityResultLauncher;)V", "start", "", "args", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentRelayStarter.kt */
    public static final class Modern implements PaymentRelayStarter {
        public static final int $stable = 8;
        private final ActivityResultLauncher<Args> launcher;

        public Modern(ActivityResultLauncher<Args> activityResultLauncher) {
            Intrinsics.checkNotNullParameter(activityResultLauncher, "launcher");
            this.launcher = activityResultLauncher;
        }

        public void start(Args args) {
            Intrinsics.checkNotNullParameter(args, "args");
            this.launcher.launch(args);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \t2\u00020\u0001:\u0005\t\n\u000b\f\rB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/PaymentRelayStarter$Args;", "Landroid/os/Parcelable;", "()V", "requestCode", "", "getRequestCode", "()I", "toResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "Companion", "ErrorArgs", "PaymentIntentArgs", "SetupIntentArgs", "SourceArgs", "Lcom/stripe/android/PaymentRelayStarter$Args$PaymentIntentArgs;", "Lcom/stripe/android/PaymentRelayStarter$Args$SetupIntentArgs;", "Lcom/stripe/android/PaymentRelayStarter$Args$SourceArgs;", "Lcom/stripe/android/PaymentRelayStarter$Args$ErrorArgs;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentRelayStarter.kt */
    public static abstract class Args implements Parcelable {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        public /* synthetic */ Args(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int getRequestCode();

        public abstract PaymentFlowResult.Unvalidated toResult();

        private Args() {
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b\u0012J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\nHÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\nHÖ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/stripe/android/PaymentRelayStarter$Args$PaymentIntentArgs;", "Lcom/stripe/android/PaymentRelayStarter$Args;", "paymentIntent", "Lcom/stripe/android/model/PaymentIntent;", "stripeAccountId", "", "(Lcom/stripe/android/model/PaymentIntent;Ljava/lang/String;)V", "getPaymentIntent$payments_core_release", "()Lcom/stripe/android/model/PaymentIntent;", "requestCode", "", "getRequestCode", "()I", "getStripeAccountId$payments_core_release", "()Ljava/lang/String;", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentRelayStarter.kt */
        public static final class PaymentIntentArgs extends Args {
            public static final int $stable = 8;
            public static final Parcelable.Creator<PaymentIntentArgs> CREATOR = new Creator();
            private final PaymentIntent paymentIntent;
            private final String stripeAccountId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentRelayStarter.kt */
            public static final class Creator implements Parcelable.Creator<PaymentIntentArgs> {
                public final PaymentIntentArgs createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new PaymentIntentArgs(PaymentIntent.CREATOR.createFromParcel(parcel), parcel.readString());
                }

                public final PaymentIntentArgs[] newArray(int i) {
                    return new PaymentIntentArgs[i];
                }
            }

            public static /* synthetic */ PaymentIntentArgs copy$default(PaymentIntentArgs paymentIntentArgs, PaymentIntent paymentIntent2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    paymentIntent2 = paymentIntentArgs.paymentIntent;
                }
                if ((i & 2) != 0) {
                    str = paymentIntentArgs.stripeAccountId;
                }
                return paymentIntentArgs.copy(paymentIntent2, str);
            }

            public final PaymentIntent component1$payments_core_release() {
                return this.paymentIntent;
            }

            public final String component2$payments_core_release() {
                return this.stripeAccountId;
            }

            public final PaymentIntentArgs copy(PaymentIntent paymentIntent2, String str) {
                Intrinsics.checkNotNullParameter(paymentIntent2, "paymentIntent");
                return new PaymentIntentArgs(paymentIntent2, str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PaymentIntentArgs)) {
                    return false;
                }
                PaymentIntentArgs paymentIntentArgs = (PaymentIntentArgs) obj;
                return Intrinsics.areEqual((Object) this.paymentIntent, (Object) paymentIntentArgs.paymentIntent) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) paymentIntentArgs.stripeAccountId);
            }

            public int getRequestCode() {
                return StripePaymentController.PAYMENT_REQUEST_CODE;
            }

            public int hashCode() {
                int hashCode = this.paymentIntent.hashCode() * 31;
                String str = this.stripeAccountId;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "PaymentIntentArgs(paymentIntent=" + this.paymentIntent + ", stripeAccountId=" + this.stripeAccountId + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                this.paymentIntent.writeToParcel(parcel, i);
                parcel.writeString(this.stripeAccountId);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ PaymentIntentArgs(PaymentIntent paymentIntent2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(paymentIntent2, (i & 2) != 0 ? null : str);
            }

            public final PaymentIntent getPaymentIntent$payments_core_release() {
                return this.paymentIntent;
            }

            public final String getStripeAccountId$payments_core_release() {
                return this.stripeAccountId;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public PaymentIntentArgs(PaymentIntent paymentIntent2, String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(paymentIntent2, "paymentIntent");
                this.paymentIntent = paymentIntent2;
                this.stripeAccountId = str;
            }

            public PaymentFlowResult.Unvalidated toResult() {
                return new PaymentFlowResult.Unvalidated(this.paymentIntent.getClientSecret(), 0, (StripeException) null, false, (String) null, (Source) null, this.stripeAccountId, 62, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b\u0012J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/stripe/android/PaymentRelayStarter$Args$SetupIntentArgs;", "Lcom/stripe/android/PaymentRelayStarter$Args;", "setupIntent", "Lcom/stripe/android/model/SetupIntent;", "stripeAccountId", "", "(Lcom/stripe/android/model/SetupIntent;Ljava/lang/String;)V", "requestCode", "", "getRequestCode", "()I", "getSetupIntent$payments_core_release", "()Lcom/stripe/android/model/SetupIntent;", "getStripeAccountId$payments_core_release", "()Ljava/lang/String;", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentRelayStarter.kt */
        public static final class SetupIntentArgs extends Args {
            public static final int $stable = 8;
            public static final Parcelable.Creator<SetupIntentArgs> CREATOR = new Creator();
            private final SetupIntent setupIntent;
            private final String stripeAccountId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentRelayStarter.kt */
            public static final class Creator implements Parcelable.Creator<SetupIntentArgs> {
                public final SetupIntentArgs createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new SetupIntentArgs(SetupIntent.CREATOR.createFromParcel(parcel), parcel.readString());
                }

                public final SetupIntentArgs[] newArray(int i) {
                    return new SetupIntentArgs[i];
                }
            }

            public static /* synthetic */ SetupIntentArgs copy$default(SetupIntentArgs setupIntentArgs, SetupIntent setupIntent2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    setupIntent2 = setupIntentArgs.setupIntent;
                }
                if ((i & 2) != 0) {
                    str = setupIntentArgs.stripeAccountId;
                }
                return setupIntentArgs.copy(setupIntent2, str);
            }

            public final SetupIntent component1$payments_core_release() {
                return this.setupIntent;
            }

            public final String component2$payments_core_release() {
                return this.stripeAccountId;
            }

            public final SetupIntentArgs copy(SetupIntent setupIntent2, String str) {
                Intrinsics.checkNotNullParameter(setupIntent2, "setupIntent");
                return new SetupIntentArgs(setupIntent2, str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SetupIntentArgs)) {
                    return false;
                }
                SetupIntentArgs setupIntentArgs = (SetupIntentArgs) obj;
                return Intrinsics.areEqual((Object) this.setupIntent, (Object) setupIntentArgs.setupIntent) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) setupIntentArgs.stripeAccountId);
            }

            public int getRequestCode() {
                return StripePaymentController.SETUP_REQUEST_CODE;
            }

            public int hashCode() {
                int hashCode = this.setupIntent.hashCode() * 31;
                String str = this.stripeAccountId;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "SetupIntentArgs(setupIntent=" + this.setupIntent + ", stripeAccountId=" + this.stripeAccountId + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                this.setupIntent.writeToParcel(parcel, i);
                parcel.writeString(this.stripeAccountId);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ SetupIntentArgs(SetupIntent setupIntent2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(setupIntent2, (i & 2) != 0 ? null : str);
            }

            public final SetupIntent getSetupIntent$payments_core_release() {
                return this.setupIntent;
            }

            public final String getStripeAccountId$payments_core_release() {
                return this.stripeAccountId;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SetupIntentArgs(SetupIntent setupIntent2, String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(setupIntent2, "setupIntent");
                this.setupIntent = setupIntent2;
                this.stripeAccountId = str;
            }

            public PaymentFlowResult.Unvalidated toResult() {
                return new PaymentFlowResult.Unvalidated(this.setupIntent.getClientSecret(), 0, (StripeException) null, false, (String) null, (Source) null, this.stripeAccountId, 62, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b\u0012J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/stripe/android/PaymentRelayStarter$Args$SourceArgs;", "Lcom/stripe/android/PaymentRelayStarter$Args;", "source", "Lcom/stripe/android/model/Source;", "stripeAccountId", "", "(Lcom/stripe/android/model/Source;Ljava/lang/String;)V", "requestCode", "", "getRequestCode", "()I", "getSource$payments_core_release", "()Lcom/stripe/android/model/Source;", "getStripeAccountId$payments_core_release", "()Ljava/lang/String;", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentRelayStarter.kt */
        public static final class SourceArgs extends Args {
            public static final int $stable = 8;
            public static final Parcelable.Creator<SourceArgs> CREATOR = new Creator();
            private final Source source;
            private final String stripeAccountId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentRelayStarter.kt */
            public static final class Creator implements Parcelable.Creator<SourceArgs> {
                public final SourceArgs createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new SourceArgs(Source.CREATOR.createFromParcel(parcel), parcel.readString());
                }

                public final SourceArgs[] newArray(int i) {
                    return new SourceArgs[i];
                }
            }

            public static /* synthetic */ SourceArgs copy$default(SourceArgs sourceArgs, Source source2, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    source2 = sourceArgs.source;
                }
                if ((i & 2) != 0) {
                    str = sourceArgs.stripeAccountId;
                }
                return sourceArgs.copy(source2, str);
            }

            public final Source component1$payments_core_release() {
                return this.source;
            }

            public final String component2$payments_core_release() {
                return this.stripeAccountId;
            }

            public final SourceArgs copy(Source source2, String str) {
                Intrinsics.checkNotNullParameter(source2, "source");
                return new SourceArgs(source2, str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SourceArgs)) {
                    return false;
                }
                SourceArgs sourceArgs = (SourceArgs) obj;
                return Intrinsics.areEqual((Object) this.source, (Object) sourceArgs.source) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) sourceArgs.stripeAccountId);
            }

            public int getRequestCode() {
                return StripePaymentController.SOURCE_REQUEST_CODE;
            }

            public int hashCode() {
                int hashCode = this.source.hashCode() * 31;
                String str = this.stripeAccountId;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "SourceArgs(source=" + this.source + ", stripeAccountId=" + this.stripeAccountId + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                this.source.writeToParcel(parcel, i);
                parcel.writeString(this.stripeAccountId);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ SourceArgs(Source source2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(source2, (i & 2) != 0 ? null : str);
            }

            public final Source getSource$payments_core_release() {
                return this.source;
            }

            public final String getStripeAccountId$payments_core_release() {
                return this.stripeAccountId;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SourceArgs(Source source2, String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(source2, "source");
                this.source = source2;
                this.stripeAccountId = str;
            }

            public PaymentFlowResult.Unvalidated toResult() {
                return new PaymentFlowResult.Unvalidated((String) null, 0, (StripeException) null, false, (String) null, this.source, this.stripeAccountId, 31, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\fJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/PaymentRelayStarter$Args$ErrorArgs;", "Lcom/stripe/android/PaymentRelayStarter$Args;", "exception", "Lcom/stripe/android/core/exception/StripeException;", "requestCode", "", "(Lcom/stripe/android/core/exception/StripeException;I)V", "getException$payments_core_release", "()Lcom/stripe/android/core/exception/StripeException;", "getRequestCode", "()I", "component1", "component1$payments_core_release", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentRelayStarter.kt */
        public static final class ErrorArgs extends Args {
            public static final int $stable = StripeException.$stable;
            public static final Parcelable.Creator<ErrorArgs> CREATOR = new Creator();
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private final StripeException exception;
            private final int requestCode;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentRelayStarter.kt */
            public static final class Creator implements Parcelable.Creator<ErrorArgs> {
                public final ErrorArgs createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return ErrorArgs.Companion.create(parcel);
                }

                public final ErrorArgs[] newArray(int i) {
                    return new ErrorArgs[i];
                }
            }

            public static /* synthetic */ ErrorArgs copy$default(ErrorArgs errorArgs, StripeException stripeException, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    stripeException = errorArgs.exception;
                }
                if ((i2 & 2) != 0) {
                    i = errorArgs.getRequestCode();
                }
                return errorArgs.copy(stripeException, i);
            }

            public final StripeException component1$payments_core_release() {
                return this.exception;
            }

            public final int component2() {
                return getRequestCode();
            }

            public final ErrorArgs copy(StripeException stripeException, int i) {
                Intrinsics.checkNotNullParameter(stripeException, "exception");
                return new ErrorArgs(stripeException, i);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ErrorArgs)) {
                    return false;
                }
                ErrorArgs errorArgs = (ErrorArgs) obj;
                return Intrinsics.areEqual((Object) this.exception, (Object) errorArgs.exception) && getRequestCode() == errorArgs.getRequestCode();
            }

            public int hashCode() {
                return (this.exception.hashCode() * 31) + getRequestCode();
            }

            public String toString() {
                return "ErrorArgs(exception=" + this.exception + ", requestCode=" + getRequestCode() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                Companion.write(this, parcel, i);
            }

            public final StripeException getException$payments_core_release() {
                return this.exception;
            }

            public int getRequestCode() {
                return this.requestCode;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ErrorArgs(StripeException stripeException, int i) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(stripeException, "exception");
                this.exception = stripeException;
                this.requestCode = i;
            }

            public PaymentFlowResult.Unvalidated toResult() {
                return new PaymentFlowResult.Unvalidated((String) null, 0, this.exception, false, (String) null, (Source) null, (String) null, 123, (DefaultConstructorMarker) null);
            }

            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/PaymentRelayStarter$Args$ErrorArgs$Companion;", "Lkotlinx/parcelize/Parceler;", "Lcom/stripe/android/PaymentRelayStarter$Args$ErrorArgs;", "()V", "create", "parcel", "Landroid/os/Parcel;", "write", "", "flags", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentRelayStarter.kt */
            public static final class Companion implements Parceler<ErrorArgs> {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public ErrorArgs[] newArray(int i) {
                    return (ErrorArgs[]) Parceler.DefaultImpls.newArray(this, i);
                }

                public ErrorArgs create(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    Serializable readSerializable = parcel.readSerializable();
                    Objects.requireNonNull(readSerializable, "null cannot be cast to non-null type com.stripe.android.core.exception.StripeException");
                    return new ErrorArgs((StripeException) readSerializable, parcel.readInt());
                }

                public void write(ErrorArgs errorArgs, Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(errorArgs, "<this>");
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeSerializable(errorArgs.getException$payments_core_release());
                    parcel.writeInt(errorArgs.getRequestCode());
                }
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/PaymentRelayStarter$Args$Companion;", "", "()V", "create", "Lcom/stripe/android/PaymentRelayStarter$Args;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "stripeAccountId", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentRelayStarter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static /* synthetic */ Args create$default(Companion companion, StripeIntent stripeIntent, String str, int i, Object obj) {
                if ((i & 2) != 0) {
                    str = null;
                }
                return companion.create(stripeIntent, str);
            }

            public final Args create(StripeIntent stripeIntent, String str) {
                Intrinsics.checkNotNullParameter(stripeIntent, "stripeIntent");
                if (stripeIntent instanceof PaymentIntent) {
                    return new PaymentIntentArgs((PaymentIntent) stripeIntent, str);
                }
                if (stripeIntent instanceof SetupIntent) {
                    return new SetupIntentArgs((SetupIntent) stripeIntent, str);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }
}
