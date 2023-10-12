package com.stripe.android.payments.core.authentication.threeds2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.os.BundleKt;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.PaymentAuthConfig;
import com.stripe.android.core.injection.InjectorKey;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.Stripe3ds2Fingerprint;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import com.stripe.android.stripe3ds2.transaction.SdkTransactionId;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2TransactionContract.kt */
public final class Stripe3ds2TransactionContract extends ActivityResultContract<Args, PaymentFlowResult.Unvalidated> {
    public Intent createIntent(Context context, Args args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, GraphQLConstants.Keys.INPUT);
        Intent putExtras = new Intent(context, Stripe3ds2TransactionActivity.class).putExtras(args.toBundle());
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent(context, Stripe3d…tExtras(input.toBundle())");
        return putExtras;
    }

    public PaymentFlowResult.Unvalidated parseResult(int i, Intent intent) {
        return PaymentFlowResult.Unvalidated.Companion.fromIntent(intent);
    }

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 G2\u00020\u0001:\u0001GB_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\u0002\u0010\u0015J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\t\u00104\u001a\u00020\rHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010*J\t\u00106\u001a\u00020\u0011HÆ\u0003J\t\u00107\u001a\u00020\u0011HÆ\u0003Jz\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014HÆ\u0001¢\u0006\u0002\u00109J\t\u0010:\u001a\u00020\u000fHÖ\u0001J\u0013\u0010;\u001a\u00020\r2\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\t\u0010>\u001a\u00020\u000fHÖ\u0001J\u0006\u0010?\u001a\u00020@J\t\u0010A\u001a\u00020\u0011HÖ\u0001J\u0019\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006H"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "Landroid/os/Parcelable;", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "config", "Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "nextActionData", "Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2;", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "enableLogging", "", "statusBarColor", "", "injectorKey", "", "publishableKey", "productUsage", "", "(Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config;Lcom/stripe/android/model/StripeIntent;Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2;Lcom/stripe/android/core/networking/ApiRequest$Options;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getConfig", "()Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config;", "getEnableLogging", "()Z", "fingerprint", "Lcom/stripe/android/model/Stripe3ds2Fingerprint;", "getFingerprint", "()Lcom/stripe/android/model/Stripe3ds2Fingerprint;", "getInjectorKey", "()Ljava/lang/String;", "getNextActionData", "()Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2;", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "getRequestOptions", "()Lcom/stripe/android/core/networking/ApiRequest$Options;", "getSdkTransactionId", "()Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "getStatusBarColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStripeIntent", "()Lcom/stripe/android/model/StripeIntent;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Lcom/stripe/android/PaymentAuthConfig$Stripe3ds2Config;Lcom/stripe/android/model/StripeIntent;Lcom/stripe/android/model/StripeIntent$NextActionData$SdkData$Use3DS2;Lcom/stripe/android/core/networking/ApiRequest$Options;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "describeContents", "equals", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2TransactionContract.kt */
    public static final class Args implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String EXTRA_ARGS = "extra_args";
        private final PaymentAuthConfig.Stripe3ds2Config config;
        private final boolean enableLogging;
        private final String injectorKey;
        private final StripeIntent.NextActionData.SdkData.Use3DS2 nextActionData;
        private final Set<String> productUsage;
        private final String publishableKey;
        private final ApiRequest.Options requestOptions;
        private final SdkTransactionId sdkTransactionId;
        private final Integer statusBarColor;
        private final StripeIntent stripeIntent;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Stripe3ds2TransactionContract.kt */
        public static final class Creator implements Parcelable.Creator<Args> {
            public final Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                SdkTransactionId sdkTransactionId = (SdkTransactionId) parcel.readParcelable(Args.class.getClassLoader());
                PaymentAuthConfig.Stripe3ds2Config createFromParcel = PaymentAuthConfig.Stripe3ds2Config.CREATOR.createFromParcel(parcel);
                StripeIntent stripeIntent = (StripeIntent) parcel.readParcelable(Args.class.getClassLoader());
                StripeIntent.NextActionData.SdkData.Use3DS2 createFromParcel2 = StripeIntent.NextActionData.SdkData.Use3DS2.CREATOR.createFromParcel(parcel);
                ApiRequest.Options options = (ApiRequest.Options) parcel.readParcelable(Args.class.getClassLoader());
                boolean z = parcel.readInt() != 0;
                Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                int readInt = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashSet.add(parcel.readString());
                }
                return new Args(sdkTransactionId, createFromParcel, stripeIntent, createFromParcel2, options, z, valueOf, readString, readString2, linkedHashSet);
            }

            public final Args[] newArray(int i) {
                return new Args[i];
            }
        }

        public static /* synthetic */ Args copy$default(Args args, SdkTransactionId sdkTransactionId2, PaymentAuthConfig.Stripe3ds2Config stripe3ds2Config, StripeIntent stripeIntent2, StripeIntent.NextActionData.SdkData.Use3DS2 use3DS2, ApiRequest.Options options, boolean z, Integer num, String str, String str2, Set set, int i, Object obj) {
            Args args2 = args;
            int i2 = i;
            return args.copy((i2 & 1) != 0 ? args2.sdkTransactionId : sdkTransactionId2, (i2 & 2) != 0 ? args2.config : stripe3ds2Config, (i2 & 4) != 0 ? args2.stripeIntent : stripeIntent2, (i2 & 8) != 0 ? args2.nextActionData : use3DS2, (i2 & 16) != 0 ? args2.requestOptions : options, (i2 & 32) != 0 ? args2.enableLogging : z, (i2 & 64) != 0 ? args2.statusBarColor : num, (i2 & 128) != 0 ? args2.injectorKey : str, (i2 & 256) != 0 ? args2.publishableKey : str2, (i2 & 512) != 0 ? args2.productUsage : set);
        }

        public final SdkTransactionId component1() {
            return this.sdkTransactionId;
        }

        public final Set<String> component10() {
            return this.productUsage;
        }

        public final PaymentAuthConfig.Stripe3ds2Config component2() {
            return this.config;
        }

        public final StripeIntent component3() {
            return this.stripeIntent;
        }

        public final StripeIntent.NextActionData.SdkData.Use3DS2 component4() {
            return this.nextActionData;
        }

        public final ApiRequest.Options component5() {
            return this.requestOptions;
        }

        public final boolean component6() {
            return this.enableLogging;
        }

        public final Integer component7() {
            return this.statusBarColor;
        }

        public final String component8() {
            return this.injectorKey;
        }

        public final String component9() {
            return this.publishableKey;
        }

        public final Args copy(SdkTransactionId sdkTransactionId2, PaymentAuthConfig.Stripe3ds2Config stripe3ds2Config, StripeIntent stripeIntent2, StripeIntent.NextActionData.SdkData.Use3DS2 use3DS2, ApiRequest.Options options, boolean z, Integer num, @InjectorKey String str, String str2, Set<String> set) {
            Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
            Intrinsics.checkNotNullParameter(stripe3ds2Config, "config");
            Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
            StripeIntent.NextActionData.SdkData.Use3DS2 use3DS22 = use3DS2;
            Intrinsics.checkNotNullParameter(use3DS22, "nextActionData");
            ApiRequest.Options options2 = options;
            Intrinsics.checkNotNullParameter(options2, "requestOptions");
            String str3 = str;
            Intrinsics.checkNotNullParameter(str3, "injectorKey");
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str4, "publishableKey");
            Set<String> set2 = set;
            Intrinsics.checkNotNullParameter(set2, NamedConstantsKt.PRODUCT_USAGE);
            return new Args(sdkTransactionId2, stripe3ds2Config, stripeIntent2, use3DS22, options2, z, num, str3, str4, set2);
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
            return Intrinsics.areEqual((Object) this.sdkTransactionId, (Object) args.sdkTransactionId) && Intrinsics.areEqual((Object) this.config, (Object) args.config) && Intrinsics.areEqual((Object) this.stripeIntent, (Object) args.stripeIntent) && Intrinsics.areEqual((Object) this.nextActionData, (Object) args.nextActionData) && Intrinsics.areEqual((Object) this.requestOptions, (Object) args.requestOptions) && this.enableLogging == args.enableLogging && Intrinsics.areEqual((Object) this.statusBarColor, (Object) args.statusBarColor) && Intrinsics.areEqual((Object) this.injectorKey, (Object) args.injectorKey) && Intrinsics.areEqual((Object) this.publishableKey, (Object) args.publishableKey) && Intrinsics.areEqual((Object) this.productUsage, (Object) args.productUsage);
        }

        public int hashCode() {
            int hashCode = ((((((((this.sdkTransactionId.hashCode() * 31) + this.config.hashCode()) * 31) + this.stripeIntent.hashCode()) * 31) + this.nextActionData.hashCode()) * 31) + this.requestOptions.hashCode()) * 31;
            boolean z = this.enableLogging;
            if (z) {
                z = true;
            }
            int i = (hashCode + (z ? 1 : 0)) * 31;
            Integer num = this.statusBarColor;
            return ((((((i + (num == null ? 0 : num.hashCode())) * 31) + this.injectorKey.hashCode()) * 31) + this.publishableKey.hashCode()) * 31) + this.productUsage.hashCode();
        }

        public String toString() {
            return "Args(sdkTransactionId=" + this.sdkTransactionId + ", config=" + this.config + ", stripeIntent=" + this.stripeIntent + ", nextActionData=" + this.nextActionData + ", requestOptions=" + this.requestOptions + ", enableLogging=" + this.enableLogging + ", statusBarColor=" + this.statusBarColor + ", injectorKey=" + this.injectorKey + ", publishableKey=" + this.publishableKey + ", productUsage=" + this.productUsage + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.sdkTransactionId, i);
            this.config.writeToParcel(parcel, i);
            parcel.writeParcelable(this.stripeIntent, i);
            this.nextActionData.writeToParcel(parcel, i);
            parcel.writeParcelable(this.requestOptions, i);
            parcel.writeInt(this.enableLogging ? 1 : 0);
            Integer num = this.statusBarColor;
            if (num == null) {
                i2 = 0;
            } else {
                parcel.writeInt(1);
                i2 = num.intValue();
            }
            parcel.writeInt(i2);
            parcel.writeString(this.injectorKey);
            parcel.writeString(this.publishableKey);
            Set<String> set = this.productUsage;
            parcel.writeInt(set.size());
            for (String writeString : set) {
                parcel.writeString(writeString);
            }
        }

        public Args(SdkTransactionId sdkTransactionId2, PaymentAuthConfig.Stripe3ds2Config stripe3ds2Config, StripeIntent stripeIntent2, StripeIntent.NextActionData.SdkData.Use3DS2 use3DS2, ApiRequest.Options options, boolean z, Integer num, @InjectorKey String str, String str2, Set<String> set) {
            Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
            Intrinsics.checkNotNullParameter(stripe3ds2Config, "config");
            Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
            Intrinsics.checkNotNullParameter(use3DS2, "nextActionData");
            Intrinsics.checkNotNullParameter(options, "requestOptions");
            Intrinsics.checkNotNullParameter(str, "injectorKey");
            Intrinsics.checkNotNullParameter(str2, "publishableKey");
            Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
            this.sdkTransactionId = sdkTransactionId2;
            this.config = stripe3ds2Config;
            this.stripeIntent = stripeIntent2;
            this.nextActionData = use3DS2;
            this.requestOptions = options;
            this.enableLogging = z;
            this.statusBarColor = num;
            this.injectorKey = str;
            this.publishableKey = str2;
            this.productUsage = set;
        }

        public final SdkTransactionId getSdkTransactionId() {
            return this.sdkTransactionId;
        }

        public final PaymentAuthConfig.Stripe3ds2Config getConfig() {
            return this.config;
        }

        public final StripeIntent getStripeIntent() {
            return this.stripeIntent;
        }

        public final StripeIntent.NextActionData.SdkData.Use3DS2 getNextActionData() {
            return this.nextActionData;
        }

        public final ApiRequest.Options getRequestOptions() {
            return this.requestOptions;
        }

        public final boolean getEnableLogging() {
            return this.enableLogging;
        }

        public final Integer getStatusBarColor() {
            return this.statusBarColor;
        }

        public final String getInjectorKey() {
            return this.injectorKey;
        }

        public final String getPublishableKey() {
            return this.publishableKey;
        }

        public final Set<String> getProductUsage() {
            return this.productUsage;
        }

        public final Stripe3ds2Fingerprint getFingerprint() {
            return new Stripe3ds2Fingerprint(this.nextActionData);
        }

        public final Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to(EXTRA_ARGS, this));
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args$Companion;", "", "()V", "EXTRA_ARGS", "", "fromIntent", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "intent", "Landroid/content/Intent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Stripe3ds2TransactionContract.kt */
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
    }
}
