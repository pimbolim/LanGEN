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
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayPaymentMethodLauncherContract.kt */
public final class GooglePayPaymentMethodLauncherContract extends ActivityResultContract<Args, GooglePayPaymentMethodLauncher.Result> {
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
        Intent putExtras = new Intent(context, GooglePayPaymentMethodLauncherActivity.class).putExtras(bundle$payments_core_release);
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent(context, GooglePa…       .putExtras(extras)");
        return putExtras;
    }

    public GooglePayPaymentMethodLauncher.Result parseResult(int i, Intent intent) {
        GooglePayPaymentMethodLauncher.Result result = intent == null ? null : (GooglePayPaymentMethodLauncher.Result) intent.getParcelableExtra("extra_result");
        return result == null ? new GooglePayPaymentMethodLauncher.Result.Failed(new IllegalArgumentException("Could not parse a valid result."), 1) : result;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 02\u00020\u0001:\u000201B+\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tB7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0016\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0017J\u000e\u0010\u0018\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÀ\u0003¢\u0006\u0002\b\u001fJ?\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0007HÖ\u0001J\r\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u00062"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;", "Landroid/os/Parcelable;", "config", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "currencyCode", "", "amount", "", "transactionId", "(Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;Ljava/lang/String;ILjava/lang/String;)V", "injectionParams", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args$InjectionParams;", "(Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;Ljava/lang/String;ILjava/lang/String;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args$InjectionParams;)V", "getAmount$payments_core_release", "()I", "getConfig$payments_core_release", "()Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "getCurrencyCode$payments_core_release", "()Ljava/lang/String;", "getInjectionParams$payments_core_release", "()Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args$InjectionParams;", "getTransactionId$payments_core_release", "component1", "component1$payments_core_release", "component2", "component2$payments_core_release", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toBundle$payments_core_release", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "InjectionParams", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncherContract.kt */
    public static final class Args implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String EXTRA_ARGS = "extra_args";
        private final int amount;
        private final GooglePayPaymentMethodLauncher.Config config;
        private final String currencyCode;
        private final InjectionParams injectionParams;
        private final String transactionId;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayPaymentMethodLauncherContract.kt */
        public static final class Creator implements Parcelable.Creator<Args> {
            public final Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Args(GooglePayPaymentMethodLauncher.Config.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() == 0 ? null : InjectionParams.CREATOR.createFromParcel(parcel));
            }

            public final Args[] newArray(int i) {
                return new Args[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Args(GooglePayPaymentMethodLauncher.Config config2, String str, int i) {
            this(config2, str, i, (String) null, 8, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(str, "currencyCode");
        }

        public static /* synthetic */ Args copy$default(Args args, GooglePayPaymentMethodLauncher.Config config2, String str, int i, String str2, InjectionParams injectionParams2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                config2 = args.config;
            }
            if ((i2 & 2) != 0) {
                str = args.currencyCode;
            }
            String str3 = str;
            if ((i2 & 4) != 0) {
                i = args.amount;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                str2 = args.transactionId;
            }
            String str4 = str2;
            if ((i2 & 16) != 0) {
                injectionParams2 = args.injectionParams;
            }
            return args.copy(config2, str3, i3, str4, injectionParams2);
        }

        public final GooglePayPaymentMethodLauncher.Config component1$payments_core_release() {
            return this.config;
        }

        public final String component2$payments_core_release() {
            return this.currencyCode;
        }

        public final int component3$payments_core_release() {
            return this.amount;
        }

        public final String component4$payments_core_release() {
            return this.transactionId;
        }

        public final InjectionParams component5$payments_core_release() {
            return this.injectionParams;
        }

        public final Args copy(GooglePayPaymentMethodLauncher.Config config2, String str, int i, String str2, InjectionParams injectionParams2) {
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(str, "currencyCode");
            return new Args(config2, str, i, str2, injectionParams2);
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
            return Intrinsics.areEqual((Object) this.config, (Object) args.config) && Intrinsics.areEqual((Object) this.currencyCode, (Object) args.currencyCode) && this.amount == args.amount && Intrinsics.areEqual((Object) this.transactionId, (Object) args.transactionId) && Intrinsics.areEqual((Object) this.injectionParams, (Object) args.injectionParams);
        }

        public int hashCode() {
            int hashCode = ((((this.config.hashCode() * 31) + this.currencyCode.hashCode()) * 31) + this.amount) * 31;
            String str = this.transactionId;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            InjectionParams injectionParams2 = this.injectionParams;
            if (injectionParams2 != null) {
                i = injectionParams2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Args(config=" + this.config + ", currencyCode=" + this.currencyCode + ", amount=" + this.amount + ", transactionId=" + this.transactionId + ", injectionParams=" + this.injectionParams + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.config.writeToParcel(parcel, i);
            parcel.writeString(this.currencyCode);
            parcel.writeInt(this.amount);
            parcel.writeString(this.transactionId);
            InjectionParams injectionParams2 = this.injectionParams;
            if (injectionParams2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            injectionParams2.writeToParcel(parcel, i);
        }

        public Args(GooglePayPaymentMethodLauncher.Config config2, String str, int i, String str2, InjectionParams injectionParams2) {
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(str, "currencyCode");
            this.config = config2;
            this.currencyCode = str;
            this.amount = i;
            this.transactionId = str2;
            this.injectionParams = injectionParams2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Args(GooglePayPaymentMethodLauncher.Config config2, String str, int i, String str2, InjectionParams injectionParams2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(config2, str, i, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : injectionParams2);
        }

        public final GooglePayPaymentMethodLauncher.Config getConfig$payments_core_release() {
            return this.config;
        }

        public final String getCurrencyCode$payments_core_release() {
            return this.currencyCode;
        }

        public final int getAmount$payments_core_release() {
            return this.amount;
        }

        public final String getTransactionId$payments_core_release() {
            return this.transactionId;
        }

        public final InjectionParams getInjectionParams$payments_core_release() {
            return this.injectionParams;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Args(GooglePayPaymentMethodLauncher.Config config2, String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(config2, str, i, (i2 & 8) != 0 ? null : str2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Args(GooglePayPaymentMethodLauncher.Config config2, String str, int i, String str2) {
            this(config2, str, i, str2, (InjectionParams) null);
            Intrinsics.checkNotNullParameter(config2, "config");
            Intrinsics.checkNotNullParameter(str, "currencyCode");
        }

        public final Bundle toBundle$payments_core_release() {
            return BundleKt.bundleOf(TuplesKt.to(EXTRA_ARGS, this));
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args$Companion;", "", "()V", "EXTRA_ARGS", "", "fromIntent", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;", "intent", "Landroid/content/Intent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayPaymentMethodLauncherContract.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Args fromIntent(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                return (Args) intent.getParcelableExtra(Args.EXTRA_ARGS);
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006%"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args$InjectionParams;", "Landroid/os/Parcelable;", "injectorKey", "", "productUsage", "", "enableLogging", "", "publishableKey", "stripeAccountId", "(Ljava/lang/String;Ljava/util/Set;ZLjava/lang/String;Ljava/lang/String;)V", "getEnableLogging", "()Z", "getInjectorKey", "()Ljava/lang/String;", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "getStripeAccountId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayPaymentMethodLauncherContract.kt */
        public static final class InjectionParams implements Parcelable {
            public static final Parcelable.Creator<InjectionParams> CREATOR = new Creator();
            private final boolean enableLogging;
            private final String injectorKey;
            private final Set<String> productUsage;
            private final String publishableKey;
            private final String stripeAccountId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: GooglePayPaymentMethodLauncherContract.kt */
            public static final class Creator implements Parcelable.Creator<InjectionParams> {
                public final InjectionParams createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new InjectionParams(readString, linkedHashSet, parcel.readInt() != 0, parcel.readString(), parcel.readString());
                }

                public final InjectionParams[] newArray(int i) {
                    return new InjectionParams[i];
                }
            }

            public static /* synthetic */ InjectionParams copy$default(InjectionParams injectionParams, String str, Set<String> set, boolean z, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = injectionParams.injectorKey;
                }
                if ((i & 2) != 0) {
                    set = injectionParams.productUsage;
                }
                Set<String> set2 = set;
                if ((i & 4) != 0) {
                    z = injectionParams.enableLogging;
                }
                boolean z2 = z;
                if ((i & 8) != 0) {
                    str2 = injectionParams.publishableKey;
                }
                String str4 = str2;
                if ((i & 16) != 0) {
                    str3 = injectionParams.stripeAccountId;
                }
                return injectionParams.copy(str, set2, z2, str4, str3);
            }

            public final String component1() {
                return this.injectorKey;
            }

            public final Set<String> component2() {
                return this.productUsage;
            }

            public final boolean component3() {
                return this.enableLogging;
            }

            public final String component4() {
                return this.publishableKey;
            }

            public final String component5() {
                return this.stripeAccountId;
            }

            public final InjectionParams copy(@InjectorKey String str, Set<String> set, boolean z, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "injectorKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                Intrinsics.checkNotNullParameter(str2, "publishableKey");
                return new InjectionParams(str, set, z, str2, str3);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InjectionParams)) {
                    return false;
                }
                InjectionParams injectionParams = (InjectionParams) obj;
                return Intrinsics.areEqual((Object) this.injectorKey, (Object) injectionParams.injectorKey) && Intrinsics.areEqual((Object) this.productUsage, (Object) injectionParams.productUsage) && this.enableLogging == injectionParams.enableLogging && Intrinsics.areEqual((Object) this.publishableKey, (Object) injectionParams.publishableKey) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) injectionParams.stripeAccountId);
            }

            public int hashCode() {
                int hashCode = ((this.injectorKey.hashCode() * 31) + this.productUsage.hashCode()) * 31;
                boolean z = this.enableLogging;
                if (z) {
                    z = true;
                }
                int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.publishableKey.hashCode()) * 31;
                String str = this.stripeAccountId;
                return hashCode2 + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "InjectionParams(injectorKey=" + this.injectorKey + ", productUsage=" + this.productUsage + ", enableLogging=" + this.enableLogging + ", publishableKey=" + this.publishableKey + ", stripeAccountId=" + this.stripeAccountId + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.injectorKey);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
                parcel.writeInt(this.enableLogging ? 1 : 0);
                parcel.writeString(this.publishableKey);
                parcel.writeString(this.stripeAccountId);
            }

            public InjectionParams(@InjectorKey String str, Set<String> set, boolean z, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "injectorKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                Intrinsics.checkNotNullParameter(str2, "publishableKey");
                this.injectorKey = str;
                this.productUsage = set;
                this.enableLogging = z;
                this.publishableKey = str2;
                this.stripeAccountId = str3;
            }

            public final String getInjectorKey() {
                return this.injectorKey;
            }

            public final Set<String> getProductUsage() {
                return this.productUsage;
            }

            public final boolean getEnableLogging() {
                return this.enableLogging;
            }

            public final String getPublishableKey() {
                return this.publishableKey;
            }

            public final String getStripeAccountId() {
                return this.stripeAccountId;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Companion;", "", "()V", "EXTRA_RESULT", "", "EXTRA_STATUS_BAR_COLOR", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncherContract.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
