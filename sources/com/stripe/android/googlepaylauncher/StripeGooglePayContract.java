package com.stripe.android.googlepaylauncher;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.view.ActivityStarter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract$Args;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeGooglePayContract.kt */
public final class StripeGooglePayContract extends ActivityResultContract<Args, GooglePayLauncherResult> {
    public Intent createIntent(Context context, Args args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, GraphQLConstants.Keys.INPUT);
        Intent putExtra = new Intent(context, StripeGooglePayActivity.class).putExtra("extra_activity_args", args);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, StripeGo…tarter.Args.EXTRA, input)");
        return putExtra;
    }

    public GooglePayLauncherResult parseResult(int i, Intent intent) {
        return GooglePayLauncherResult.Companion.fromIntent(intent);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract$Args;", "Lcom/stripe/android/view/ActivityStarter$Args;", "config", "Lcom/stripe/android/googlepaylauncher/GooglePayConfig;", "statusBarColor", "", "(Lcom/stripe/android/googlepaylauncher/GooglePayConfig;Ljava/lang/Integer;)V", "getConfig", "()Lcom/stripe/android/googlepaylauncher/GooglePayConfig;", "setConfig", "(Lcom/stripe/android/googlepaylauncher/GooglePayConfig;)V", "getStatusBarColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Lcom/stripe/android/googlepaylauncher/GooglePayConfig;Ljava/lang/Integer;)Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract$Args;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeGooglePayContract.kt */
    public static final class Args implements ActivityStarter.Args {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private GooglePayConfig config;
        private final Integer statusBarColor;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeGooglePayContract.kt */
        public static final class Creator implements Parcelable.Creator<Args> {
            public final Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Args(GooglePayConfig.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            public final Args[] newArray(int i) {
                return new Args[i];
            }
        }

        public static /* synthetic */ Args copy$default(Args args, GooglePayConfig googlePayConfig, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                googlePayConfig = args.config;
            }
            if ((i & 2) != 0) {
                num = args.statusBarColor;
            }
            return args.copy(googlePayConfig, num);
        }

        public final GooglePayConfig component1() {
            return this.config;
        }

        public final Integer component2() {
            return this.statusBarColor;
        }

        public final Args copy(GooglePayConfig googlePayConfig, Integer num) {
            Intrinsics.checkNotNullParameter(googlePayConfig, "config");
            return new Args(googlePayConfig, num);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Args)) {
                return false;
            }
            Args args = (Args) obj;
            return Intrinsics.areEqual((Object) this.config, (Object) args.config) && Intrinsics.areEqual((Object) this.statusBarColor, (Object) args.statusBarColor);
        }

        public int hashCode() {
            int hashCode = this.config.hashCode() * 31;
            Integer num = this.statusBarColor;
            return hashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Args(config=" + this.config + ", statusBarColor=" + this.statusBarColor + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.config.writeToParcel(parcel, i);
            Integer num = this.statusBarColor;
            if (num == null) {
                i2 = 0;
            } else {
                parcel.writeInt(1);
                i2 = num.intValue();
            }
            parcel.writeInt(i2);
        }

        public Args(GooglePayConfig googlePayConfig, Integer num) {
            Intrinsics.checkNotNullParameter(googlePayConfig, "config");
            this.config = googlePayConfig;
            this.statusBarColor = num;
        }

        public final GooglePayConfig getConfig() {
            return this.config;
        }

        public final void setConfig(GooglePayConfig googlePayConfig) {
            Intrinsics.checkNotNullParameter(googlePayConfig, "<set-?>");
            this.config = googlePayConfig;
        }

        public final Integer getStatusBarColor() {
            return this.statusBarColor;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract$Args$Companion;", "", "()V", "create", "Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract$Args;", "intent", "Landroid/content/Intent;", "create$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: StripeGooglePayContract.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Args create$payments_core_release(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                return (Args) intent.getParcelableExtra("extra_activity_args");
            }
        }
    }
}
