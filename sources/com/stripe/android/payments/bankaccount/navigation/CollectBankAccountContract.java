package com.stripe.android.payments.bankaccount.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.os.BundleKt;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.payments.bankaccount.CollectBankAccountConfiguration;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult;
import com.stripe.android.payments.bankaccount.ui.CollectBankAccountActivity;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "Companion", "Result", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountContract.kt */
public final class CollectBankAccountContract extends ActivityResultContract<Args, CollectBankAccountResult> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_ARGS = "com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract.extra_args";
    private static final String EXTRA_RESULT = "com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract.extra_result";

    public Intent createIntent(Context context, Args args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, GraphQLConstants.Keys.INPUT);
        Intent putExtra = new Intent(context, CollectBankAccountActivity.class).putExtra(EXTRA_ARGS, args);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, CollectB…tExtra(EXTRA_ARGS, input)");
        return putExtra;
    }

    public CollectBankAccountResult parseResult(int i, Intent intent) {
        Result result;
        CollectBankAccountResult collectBankAccountResult = null;
        if (!(intent == null || (result = (Result) intent.getParcelableExtra(EXTRA_RESULT)) == null)) {
            collectBankAccountResult = result.getCollectBankAccountResult();
        }
        return collectBankAccountResult == null ? new CollectBankAccountResult.Failed(new IllegalArgumentException("Failed to retrieve a CollectBankAccountResult.")) : collectBankAccountResult;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000f2\u00020\u0001:\u0003\u000f\u0010\u0011B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u0001\u0002\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "Landroid/os/Parcelable;", "publishableKey", "", "clientSecret", "configuration", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;)V", "getClientSecret", "()Ljava/lang/String;", "getConfiguration", "()Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;", "getPublishableKey", "toBundle", "Landroid/os/Bundle;", "Companion", "ForPaymentIntent", "ForSetupIntent", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args$ForPaymentIntent;", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args$ForSetupIntent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectBankAccountContract.kt */
    public static abstract class Args implements Parcelable {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final String clientSecret;
        private final CollectBankAccountConfiguration configuration;
        private final String publishableKey;

        public /* synthetic */ Args(String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, collectBankAccountConfiguration);
        }

        private Args(String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration) {
            this.publishableKey = str;
            this.clientSecret = str2;
            this.configuration = collectBankAccountConfiguration;
        }

        public String getPublishableKey() {
            return this.publishableKey;
        }

        public String getClientSecret() {
            return this.clientSecret;
        }

        public CollectBankAccountConfiguration getConfiguration() {
            return this.configuration;
        }

        public final Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to(CollectBankAccountContract.EXTRA_ARGS, this));
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args$ForPaymentIntent;", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "publishableKey", "", "clientSecret", "configuration", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;)V", "getClientSecret", "()Ljava/lang/String;", "getConfiguration", "()Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;", "getPublishableKey", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CollectBankAccountContract.kt */
        public static final class ForPaymentIntent extends Args {
            public static final int $stable = 8;
            public static final Parcelable.Creator<ForPaymentIntent> CREATOR = new Creator();
            private final String clientSecret;
            private final CollectBankAccountConfiguration configuration;
            private final String publishableKey;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: CollectBankAccountContract.kt */
            public static final class Creator implements Parcelable.Creator<ForPaymentIntent> {
                public final ForPaymentIntent createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ForPaymentIntent(parcel.readString(), parcel.readString(), (CollectBankAccountConfiguration) parcel.readParcelable(ForPaymentIntent.class.getClassLoader()));
                }

                public final ForPaymentIntent[] newArray(int i) {
                    return new ForPaymentIntent[i];
                }
            }

            public static /* synthetic */ ForPaymentIntent copy$default(ForPaymentIntent forPaymentIntent, String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = forPaymentIntent.getPublishableKey();
                }
                if ((i & 2) != 0) {
                    str2 = forPaymentIntent.getClientSecret();
                }
                if ((i & 4) != 0) {
                    collectBankAccountConfiguration = forPaymentIntent.getConfiguration();
                }
                return forPaymentIntent.copy(str, str2, collectBankAccountConfiguration);
            }

            public final String component1() {
                return getPublishableKey();
            }

            public final String component2() {
                return getClientSecret();
            }

            public final CollectBankAccountConfiguration component3() {
                return getConfiguration();
            }

            public final ForPaymentIntent copy(String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration) {
                Intrinsics.checkNotNullParameter(str, "publishableKey");
                Intrinsics.checkNotNullParameter(str2, "clientSecret");
                Intrinsics.checkNotNullParameter(collectBankAccountConfiguration, "configuration");
                return new ForPaymentIntent(str, str2, collectBankAccountConfiguration);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ForPaymentIntent)) {
                    return false;
                }
                ForPaymentIntent forPaymentIntent = (ForPaymentIntent) obj;
                return Intrinsics.areEqual((Object) getPublishableKey(), (Object) forPaymentIntent.getPublishableKey()) && Intrinsics.areEqual((Object) getClientSecret(), (Object) forPaymentIntent.getClientSecret()) && Intrinsics.areEqual((Object) getConfiguration(), (Object) forPaymentIntent.getConfiguration());
            }

            public int hashCode() {
                return (((getPublishableKey().hashCode() * 31) + getClientSecret().hashCode()) * 31) + getConfiguration().hashCode();
            }

            public String toString() {
                return "ForPaymentIntent(publishableKey=" + getPublishableKey() + ", clientSecret=" + getClientSecret() + ", configuration=" + getConfiguration() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.publishableKey);
                parcel.writeString(this.clientSecret);
                parcel.writeParcelable(this.configuration, i);
            }

            public String getPublishableKey() {
                return this.publishableKey;
            }

            public String getClientSecret() {
                return this.clientSecret;
            }

            public CollectBankAccountConfiguration getConfiguration() {
                return this.configuration;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ForPaymentIntent(String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration) {
                super(str, str2, collectBankAccountConfiguration, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "publishableKey");
                Intrinsics.checkNotNullParameter(str2, "clientSecret");
                Intrinsics.checkNotNullParameter(collectBankAccountConfiguration, "configuration");
                this.publishableKey = str;
                this.clientSecret = str2;
                this.configuration = collectBankAccountConfiguration;
            }
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args$ForSetupIntent;", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "publishableKey", "", "clientSecret", "configuration", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;)V", "getClientSecret", "()Ljava/lang/String;", "getConfiguration", "()Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration;", "getPublishableKey", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CollectBankAccountContract.kt */
        public static final class ForSetupIntent extends Args {
            public static final int $stable = 8;
            public static final Parcelable.Creator<ForSetupIntent> CREATOR = new Creator();
            private final String clientSecret;
            private final CollectBankAccountConfiguration configuration;
            private final String publishableKey;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: CollectBankAccountContract.kt */
            public static final class Creator implements Parcelable.Creator<ForSetupIntent> {
                public final ForSetupIntent createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ForSetupIntent(parcel.readString(), parcel.readString(), (CollectBankAccountConfiguration) parcel.readParcelable(ForSetupIntent.class.getClassLoader()));
                }

                public final ForSetupIntent[] newArray(int i) {
                    return new ForSetupIntent[i];
                }
            }

            public static /* synthetic */ ForSetupIntent copy$default(ForSetupIntent forSetupIntent, String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = forSetupIntent.getPublishableKey();
                }
                if ((i & 2) != 0) {
                    str2 = forSetupIntent.getClientSecret();
                }
                if ((i & 4) != 0) {
                    collectBankAccountConfiguration = forSetupIntent.getConfiguration();
                }
                return forSetupIntent.copy(str, str2, collectBankAccountConfiguration);
            }

            public final String component1() {
                return getPublishableKey();
            }

            public final String component2() {
                return getClientSecret();
            }

            public final CollectBankAccountConfiguration component3() {
                return getConfiguration();
            }

            public final ForSetupIntent copy(String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration) {
                Intrinsics.checkNotNullParameter(str, "publishableKey");
                Intrinsics.checkNotNullParameter(str2, "clientSecret");
                Intrinsics.checkNotNullParameter(collectBankAccountConfiguration, "configuration");
                return new ForSetupIntent(str, str2, collectBankAccountConfiguration);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ForSetupIntent)) {
                    return false;
                }
                ForSetupIntent forSetupIntent = (ForSetupIntent) obj;
                return Intrinsics.areEqual((Object) getPublishableKey(), (Object) forSetupIntent.getPublishableKey()) && Intrinsics.areEqual((Object) getClientSecret(), (Object) forSetupIntent.getClientSecret()) && Intrinsics.areEqual((Object) getConfiguration(), (Object) forSetupIntent.getConfiguration());
            }

            public int hashCode() {
                return (((getPublishableKey().hashCode() * 31) + getClientSecret().hashCode()) * 31) + getConfiguration().hashCode();
            }

            public String toString() {
                return "ForSetupIntent(publishableKey=" + getPublishableKey() + ", clientSecret=" + getClientSecret() + ", configuration=" + getConfiguration() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.publishableKey);
                parcel.writeString(this.clientSecret);
                parcel.writeParcelable(this.configuration, i);
            }

            public String getPublishableKey() {
                return this.publishableKey;
            }

            public String getClientSecret() {
                return this.clientSecret;
            }

            public CollectBankAccountConfiguration getConfiguration() {
                return this.configuration;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ForSetupIntent(String str, String str2, CollectBankAccountConfiguration collectBankAccountConfiguration) {
                super(str, str2, collectBankAccountConfiguration, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "publishableKey");
                Intrinsics.checkNotNullParameter(str2, "clientSecret");
                Intrinsics.checkNotNullParameter(collectBankAccountConfiguration, "configuration");
                this.publishableKey = str;
                this.clientSecret = str2;
                this.configuration = collectBankAccountConfiguration;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args$Companion;", "", "()V", "fromIntent", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "intent", "Landroid/content/Intent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CollectBankAccountContract.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Args fromIntent(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                return (Args) intent.getParcelableExtra(CollectBankAccountContract.EXTRA_ARGS);
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Result;", "Landroid/os/Parcelable;", "collectBankAccountResult", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;", "(Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;)V", "getCollectBankAccountResult", "()Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectBankAccountContract.kt */
    public static final class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new Creator();
        private final CollectBankAccountResult collectBankAccountResult;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CollectBankAccountContract.kt */
        public static final class Creator implements Parcelable.Creator<Result> {
            public final Result createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Result((CollectBankAccountResult) parcel.readParcelable(Result.class.getClassLoader()));
            }

            public final Result[] newArray(int i) {
                return new Result[i];
            }
        }

        public static /* synthetic */ Result copy$default(Result result, CollectBankAccountResult collectBankAccountResult2, int i, Object obj) {
            if ((i & 1) != 0) {
                collectBankAccountResult2 = result.collectBankAccountResult;
            }
            return result.copy(collectBankAccountResult2);
        }

        public final CollectBankAccountResult component1() {
            return this.collectBankAccountResult;
        }

        public final Result copy(CollectBankAccountResult collectBankAccountResult2) {
            Intrinsics.checkNotNullParameter(collectBankAccountResult2, "collectBankAccountResult");
            return new Result(collectBankAccountResult2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Result) && Intrinsics.areEqual((Object) this.collectBankAccountResult, (Object) ((Result) obj).collectBankAccountResult);
        }

        public int hashCode() {
            return this.collectBankAccountResult.hashCode();
        }

        public String toString() {
            return "Result(collectBankAccountResult=" + this.collectBankAccountResult + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.collectBankAccountResult, i);
        }

        public Result(CollectBankAccountResult collectBankAccountResult2) {
            Intrinsics.checkNotNullParameter(collectBankAccountResult2, "collectBankAccountResult");
            this.collectBankAccountResult = collectBankAccountResult2;
        }

        public final CollectBankAccountResult getCollectBankAccountResult() {
            return this.collectBankAccountResult;
        }

        public final Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to(CollectBankAccountContract.EXTRA_RESULT, this));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Companion;", "", "()V", "EXTRA_ARGS", "", "getEXTRA_ARGS$annotations", "EXTRA_RESULT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectBankAccountContract.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getEXTRA_ARGS$annotations() {
        }

        private Companion() {
        }
    }
}
