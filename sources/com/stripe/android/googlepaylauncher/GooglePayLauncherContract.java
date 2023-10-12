package com.stripe.android.googlepaylauncher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Window;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.os.BundleKt;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.googlepaylauncher.GooglePayLauncher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u000e\u000f\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "Companion", "PaymentIntentArgs", "SetupIntentArgs", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayLauncherContract.kt */
public final class GooglePayLauncherContract extends ActivityResultContract<Args, GooglePayLauncher.Result> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_RESULT = "extra_result";
    public static final String EXTRA_STATUS_BAR_COLOR = "extra_status_bar_color";

    public Intent createIntent(Context context, Args args) {
        Window window;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, GraphQLConstants.Keys.INPUT);
        Integer num = null;
        if ((context instanceof Activity) && (window = ((Activity) context).getWindow()) != null) {
            num = Integer.valueOf(window.getStatusBarColor());
        }
        Bundle bundle$payments_core_release = args.toBundle$payments_core_release();
        if (num != null) {
            bundle$payments_core_release.putInt("extra_status_bar_color", num.intValue());
        }
        Intent putExtras = new Intent(context, GooglePayLauncherActivity.class).putExtras(bundle$payments_core_release);
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent(context, GooglePa…       .putExtras(extras)");
        return putExtras;
    }

    public GooglePayLauncher.Result parseResult(int i, Intent intent) {
        GooglePayLauncher.Result result = intent == null ? null : (GooglePayLauncher.Result) intent.getParcelableExtra("extra_result");
        return result == null ? new GooglePayLauncher.Result.Failed(new IllegalStateException("Error while processing result from Google Pay.")) : result;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\fJ\u000e\u0010\r\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u000eJ\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$PaymentIntentArgs;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;", "clientSecret", "", "config", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;", "(Ljava/lang/String;Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;)V", "getClientSecret$payments_core_release", "()Ljava/lang/String;", "getConfig$payments_core_release", "()Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherContract.kt */
    public static final class PaymentIntentArgs extends Args {
        public static final int $stable = 8;
        public static final Parcelable.Creator<PaymentIntentArgs> CREATOR = new Creator();
        private final String clientSecret;
        private final GooglePayLauncher.Config config;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncherContract.kt */
        public static final class Creator implements Parcelable.Creator<PaymentIntentArgs> {
            public final PaymentIntentArgs createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PaymentIntentArgs(parcel.readString(), GooglePayLauncher.Config.CREATOR.createFromParcel(parcel));
            }

            public final PaymentIntentArgs[] newArray(int i) {
                return new PaymentIntentArgs[i];
            }
        }

        public static /* synthetic */ PaymentIntentArgs copy$default(PaymentIntentArgs paymentIntentArgs, String str, GooglePayLauncher.Config config2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = paymentIntentArgs.getClientSecret$payments_core_release();
            }
            if ((i & 2) != 0) {
                config2 = paymentIntentArgs.getConfig$payments_core_release();
            }
            return paymentIntentArgs.copy(str, config2);
        }

        public final String component1$payments_core_release() {
            return getClientSecret$payments_core_release();
        }

        public final GooglePayLauncher.Config component2$payments_core_release() {
            return getConfig$payments_core_release();
        }

        public final PaymentIntentArgs copy(String str, GooglePayLauncher.Config config2) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            Intrinsics.checkNotNullParameter(config2, "config");
            return new PaymentIntentArgs(str, config2);
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
            return Intrinsics.areEqual((Object) getClientSecret$payments_core_release(), (Object) paymentIntentArgs.getClientSecret$payments_core_release()) && Intrinsics.areEqual((Object) getConfig$payments_core_release(), (Object) paymentIntentArgs.getConfig$payments_core_release());
        }

        public int hashCode() {
            return (getClientSecret$payments_core_release().hashCode() * 31) + getConfig$payments_core_release().hashCode();
        }

        public String toString() {
            return "PaymentIntentArgs(clientSecret=" + getClientSecret$payments_core_release() + ", config=" + getConfig$payments_core_release() + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.clientSecret);
            this.config.writeToParcel(parcel, i);
        }

        public String getClientSecret$payments_core_release() {
            return this.clientSecret;
        }

        public GooglePayLauncher.Config getConfig$payments_core_release() {
            return this.config;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaymentIntentArgs(String str, GooglePayLauncher.Config config2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            Intrinsics.checkNotNullParameter(config2, "config");
            this.clientSecret = str;
            this.config = config2;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u000eJ\u000e\u0010\u000f\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006!"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$SetupIntentArgs;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;", "clientSecret", "", "config", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;", "currencyCode", "(Ljava/lang/String;Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;Ljava/lang/String;)V", "getClientSecret$payments_core_release", "()Ljava/lang/String;", "getConfig$payments_core_release", "()Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;", "getCurrencyCode$payments_core_release", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherContract.kt */
    public static final class SetupIntentArgs extends Args {
        public static final int $stable = 8;
        public static final Parcelable.Creator<SetupIntentArgs> CREATOR = new Creator();
        private final String clientSecret;
        private final GooglePayLauncher.Config config;
        private final String currencyCode;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncherContract.kt */
        public static final class Creator implements Parcelable.Creator<SetupIntentArgs> {
            public final SetupIntentArgs createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SetupIntentArgs(parcel.readString(), GooglePayLauncher.Config.CREATOR.createFromParcel(parcel), parcel.readString());
            }

            public final SetupIntentArgs[] newArray(int i) {
                return new SetupIntentArgs[i];
            }
        }

        public static /* synthetic */ SetupIntentArgs copy$default(SetupIntentArgs setupIntentArgs, String str, GooglePayLauncher.Config config2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = setupIntentArgs.getClientSecret$payments_core_release();
            }
            if ((i & 2) != 0) {
                config2 = setupIntentArgs.getConfig$payments_core_release();
            }
            if ((i & 4) != 0) {
                str2 = setupIntentArgs.currencyCode;
            }
            return setupIntentArgs.copy(str, config2, str2);
        }

        public final String component1$payments_core_release() {
            return getClientSecret$payments_core_release();
        }

        public final GooglePayLauncher.Config component2$payments_core_release() {
            return getConfig$payments_core_release();
        }

        public final String component3$payments_core_release() {
            return this.currencyCode;
        }

        public final SetupIntentArgs copy(String str, GooglePayLauncher.Config config2, String str2) {
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(str2, "currencyCode");
            return new SetupIntentArgs(str, config2, str2);
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
            return Intrinsics.areEqual((Object) getClientSecret$payments_core_release(), (Object) setupIntentArgs.getClientSecret$payments_core_release()) && Intrinsics.areEqual((Object) getConfig$payments_core_release(), (Object) setupIntentArgs.getConfig$payments_core_release()) && Intrinsics.areEqual((Object) this.currencyCode, (Object) setupIntentArgs.currencyCode);
        }

        public int hashCode() {
            return (((getClientSecret$payments_core_release().hashCode() * 31) + getConfig$payments_core_release().hashCode()) * 31) + this.currencyCode.hashCode();
        }

        public String toString() {
            return "SetupIntentArgs(clientSecret=" + getClientSecret$payments_core_release() + ", config=" + getConfig$payments_core_release() + ", currencyCode=" + this.currencyCode + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.clientSecret);
            this.config.writeToParcel(parcel, i);
            parcel.writeString(this.currencyCode);
        }

        public String getClientSecret$payments_core_release() {
            return this.clientSecret;
        }

        public GooglePayLauncher.Config getConfig$payments_core_release() {
            return this.config;
        }

        public final String getCurrencyCode$payments_core_release() {
            return this.currencyCode;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SetupIntentArgs(String str, GooglePayLauncher.Config config2, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "clientSecret");
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(str2, "currencyCode");
            this.clientSecret = str;
            this.config = config2;
            this.currencyCode = str2;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\r\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rR\u0012\u0010\u0003\u001a\u00020\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;", "Landroid/os/Parcelable;", "()V", "clientSecret", "", "getClientSecret$payments_core_release", "()Ljava/lang/String;", "config", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;", "getConfig$payments_core_release", "()Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Config;", "toBundle", "Landroid/os/Bundle;", "toBundle$payments_core_release", "Companion", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$PaymentIntentArgs;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$SetupIntentArgs;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherContract.kt */
    public static abstract class Args implements Parcelable {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String EXTRA_ARGS = "extra_args";

        public /* synthetic */ Args(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract String getClientSecret$payments_core_release();

        public abstract GooglePayLauncher.Config getConfig$payments_core_release();

        private Args() {
        }

        public final Bundle toBundle$payments_core_release() {
            return BundleKt.bundleOf(TuplesKt.to(EXTRA_ARGS, this));
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args$Companion;", "", "()V", "EXTRA_ARGS", "", "fromIntent", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;", "intent", "Landroid/content/Intent;", "fromIntent$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayLauncherContract.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Args fromIntent$payments_core_release(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                return (Args) intent.getParcelableExtra(Args.EXTRA_ARGS);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Companion;", "", "()V", "EXTRA_RESULT", "", "EXTRA_STATUS_BAR_COLOR", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherContract.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
