package com.stripe.android.payments.paymentlauncher;

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
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "Lcom/stripe/android/payments/paymentlauncher/PaymentResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentLauncherContract.kt */
public final class PaymentLauncherContract extends ActivityResultContract<Args, PaymentResult> {
    public static final int $stable = 0;

    public Intent createIntent(Context context, Args args) {
        Window window;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, GraphQLConstants.Keys.INPUT);
        Integer num = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (!(activity == null || (window = activity.getWindow()) == null)) {
            num = Integer.valueOf(window.getStatusBarColor());
        }
        args.setStatusBarColor(num);
        Intent putExtras = new Intent(context, PaymentLauncherConfirmationActivity.class).putExtras(args.toBundle());
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent(\n            cont…tExtras(input.toBundle())");
        return putExtras;
    }

    public PaymentResult parseResult(int i, Intent intent) {
        return PaymentResult.Companion.fromIntent(intent);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001c2\u00020\u0001:\u0004\u001c\u001d\u001e\u001fBE\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u001a\u001a\u00020\u001bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010\u0001\u0003 !\"¨\u0006#"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "Landroid/os/Parcelable;", "injectorKey", "", "publishableKey", "stripeAccountId", "enableLogging", "", "productUsage", "", "statusBarColor", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Set;Ljava/lang/Integer;)V", "getEnableLogging", "()Z", "getInjectorKey", "()Ljava/lang/String;", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "getStatusBarColor", "()Ljava/lang/Integer;", "setStatusBarColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStripeAccountId", "toBundle", "Landroid/os/Bundle;", "Companion", "IntentConfirmationArgs", "PaymentIntentNextActionArgs", "SetupIntentNextActionArgs", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args$IntentConfirmationArgs;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args$PaymentIntentNextActionArgs;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args$SetupIntentNextActionArgs;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentLauncherContract.kt */
    public static abstract class Args implements Parcelable {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String EXTRA_ARGS = "extra_args";
        private final boolean enableLogging;
        private final String injectorKey;
        private final Set<String> productUsage;
        private final String publishableKey;
        private Integer statusBarColor;
        private final String stripeAccountId;

        public /* synthetic */ Args(String str, String str2, String str3, boolean z, Set set, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, set, num);
        }

        private Args(@InjectorKey String str, String str2, String str3, boolean z, Set<String> set, Integer num) {
            this.injectorKey = str;
            this.publishableKey = str2;
            this.stripeAccountId = str3;
            this.enableLogging = z;
            this.productUsage = set;
            this.statusBarColor = num;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Args(String str, String str2, String str3, boolean z, Set set, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, set, (i & 32) != 0 ? null : num, (DefaultConstructorMarker) null);
        }

        public String getInjectorKey() {
            return this.injectorKey;
        }

        public String getPublishableKey() {
            return this.publishableKey;
        }

        public String getStripeAccountId() {
            return this.stripeAccountId;
        }

        public boolean getEnableLogging() {
            return this.enableLogging;
        }

        public Set<String> getProductUsage() {
            return this.productUsage;
        }

        public Integer getStatusBarColor() {
            return this.statusBarColor;
        }

        public void setStatusBarColor(Integer num) {
            this.statusBarColor = num;
        }

        public final Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to(EXTRA_ARGS, this));
        }

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0019J^\u0010%\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010&J\t\u0010'\u001a\u00020\rHÖ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\rHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rHÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u00062"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args$IntentConfirmationArgs;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "injectorKey", "", "publishableKey", "stripeAccountId", "enableLogging", "", "productUsage", "", "confirmStripeIntentParams", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "statusBarColor", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Set;Lcom/stripe/android/model/ConfirmStripeIntentParams;Ljava/lang/Integer;)V", "getConfirmStripeIntentParams", "()Lcom/stripe/android/model/ConfirmStripeIntentParams;", "getEnableLogging", "()Z", "getInjectorKey", "()Ljava/lang/String;", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "getStatusBarColor", "()Ljava/lang/Integer;", "setStatusBarColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStripeAccountId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Set;Lcom/stripe/android/model/ConfirmStripeIntentParams;Ljava/lang/Integer;)Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args$IntentConfirmationArgs;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentLauncherContract.kt */
        public static final class IntentConfirmationArgs extends Args {
            public static final int $stable = 8;
            public static final Parcelable.Creator<IntentConfirmationArgs> CREATOR = new Creator();
            private final ConfirmStripeIntentParams confirmStripeIntentParams;
            private final boolean enableLogging;
            private final String injectorKey;
            private final Set<String> productUsage;
            private final String publishableKey;
            private Integer statusBarColor;
            private final String stripeAccountId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentLauncherContract.kt */
            public static final class Creator implements Parcelable.Creator<IntentConfirmationArgs> {
                public final IntentConfirmationArgs createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    boolean z = parcel.readInt() != 0;
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new IntentConfirmationArgs(readString, readString2, readString3, z, linkedHashSet, (ConfirmStripeIntentParams) parcel.readParcelable(IntentConfirmationArgs.class.getClassLoader()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                public final IntentConfirmationArgs[] newArray(int i) {
                    return new IntentConfirmationArgs[i];
                }
            }

            public static /* synthetic */ IntentConfirmationArgs copy$default(IntentConfirmationArgs intentConfirmationArgs, String str, String str2, String str3, boolean z, Set<String> set, ConfirmStripeIntentParams confirmStripeIntentParams2, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = intentConfirmationArgs.getInjectorKey();
                }
                if ((i & 2) != 0) {
                    str2 = intentConfirmationArgs.getPublishableKey();
                }
                String str4 = str2;
                if ((i & 4) != 0) {
                    str3 = intentConfirmationArgs.getStripeAccountId();
                }
                String str5 = str3;
                if ((i & 8) != 0) {
                    z = intentConfirmationArgs.getEnableLogging();
                }
                boolean z2 = z;
                if ((i & 16) != 0) {
                    set = intentConfirmationArgs.getProductUsage();
                }
                Set<String> set2 = set;
                if ((i & 32) != 0) {
                    confirmStripeIntentParams2 = intentConfirmationArgs.confirmStripeIntentParams;
                }
                ConfirmStripeIntentParams confirmStripeIntentParams3 = confirmStripeIntentParams2;
                if ((i & 64) != 0) {
                    num = intentConfirmationArgs.getStatusBarColor();
                }
                return intentConfirmationArgs.copy(str, str4, str5, z2, set2, confirmStripeIntentParams3, num);
            }

            public final String component1() {
                return getInjectorKey();
            }

            public final String component2() {
                return getPublishableKey();
            }

            public final String component3() {
                return getStripeAccountId();
            }

            public final boolean component4() {
                return getEnableLogging();
            }

            public final Set<String> component5() {
                return getProductUsage();
            }

            public final ConfirmStripeIntentParams component6() {
                return this.confirmStripeIntentParams;
            }

            public final Integer component7() {
                return getStatusBarColor();
            }

            public final IntentConfirmationArgs copy(@InjectorKey String str, String str2, String str3, boolean z, Set<String> set, ConfirmStripeIntentParams confirmStripeIntentParams2, Integer num) {
                Intrinsics.checkNotNullParameter(str, "injectorKey");
                Intrinsics.checkNotNullParameter(str2, "publishableKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                Intrinsics.checkNotNullParameter(confirmStripeIntentParams2, "confirmStripeIntentParams");
                return new IntentConfirmationArgs(str, str2, str3, z, set, confirmStripeIntentParams2, num);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof IntentConfirmationArgs)) {
                    return false;
                }
                IntentConfirmationArgs intentConfirmationArgs = (IntentConfirmationArgs) obj;
                return Intrinsics.areEqual((Object) getInjectorKey(), (Object) intentConfirmationArgs.getInjectorKey()) && Intrinsics.areEqual((Object) getPublishableKey(), (Object) intentConfirmationArgs.getPublishableKey()) && Intrinsics.areEqual((Object) getStripeAccountId(), (Object) intentConfirmationArgs.getStripeAccountId()) && getEnableLogging() == intentConfirmationArgs.getEnableLogging() && Intrinsics.areEqual((Object) getProductUsage(), (Object) intentConfirmationArgs.getProductUsage()) && Intrinsics.areEqual((Object) this.confirmStripeIntentParams, (Object) intentConfirmationArgs.confirmStripeIntentParams) && Intrinsics.areEqual((Object) getStatusBarColor(), (Object) intentConfirmationArgs.getStatusBarColor());
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((getInjectorKey().hashCode() * 31) + getPublishableKey().hashCode()) * 31) + (getStripeAccountId() == null ? 0 : getStripeAccountId().hashCode())) * 31;
                boolean enableLogging2 = getEnableLogging();
                if (enableLogging2) {
                    enableLogging2 = true;
                }
                int hashCode2 = (((((hashCode + (enableLogging2 ? 1 : 0)) * 31) + getProductUsage().hashCode()) * 31) + this.confirmStripeIntentParams.hashCode()) * 31;
                if (getStatusBarColor() != null) {
                    i = getStatusBarColor().hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "IntentConfirmationArgs(injectorKey=" + getInjectorKey() + ", publishableKey=" + getPublishableKey() + ", stripeAccountId=" + getStripeAccountId() + ", enableLogging=" + getEnableLogging() + ", productUsage=" + getProductUsage() + ", confirmStripeIntentParams=" + this.confirmStripeIntentParams + ", statusBarColor=" + getStatusBarColor() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                int i2;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.injectorKey);
                parcel.writeString(this.publishableKey);
                parcel.writeString(this.stripeAccountId);
                parcel.writeInt(this.enableLogging ? 1 : 0);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
                parcel.writeParcelable(this.confirmStripeIntentParams, i);
                Integer num = this.statusBarColor;
                if (num == null) {
                    i2 = 0;
                } else {
                    parcel.writeInt(1);
                    i2 = num.intValue();
                }
                parcel.writeInt(i2);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ IntentConfirmationArgs(String str, String str2, String str3, boolean z, Set set, ConfirmStripeIntentParams confirmStripeIntentParams2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, z, set, confirmStripeIntentParams2, (i & 64) != 0 ? null : num);
            }

            public String getInjectorKey() {
                return this.injectorKey;
            }

            public String getPublishableKey() {
                return this.publishableKey;
            }

            public String getStripeAccountId() {
                return this.stripeAccountId;
            }

            public boolean getEnableLogging() {
                return this.enableLogging;
            }

            public Set<String> getProductUsage() {
                return this.productUsage;
            }

            public final ConfirmStripeIntentParams getConfirmStripeIntentParams() {
                return this.confirmStripeIntentParams;
            }

            public Integer getStatusBarColor() {
                return this.statusBarColor;
            }

            public void setStatusBarColor(Integer num) {
                this.statusBarColor = num;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public IntentConfirmationArgs(@InjectorKey String str, String str2, String str3, boolean z, Set<String> set, ConfirmStripeIntentParams confirmStripeIntentParams2, Integer num) {
                super(str, str2, str3, z, set, num, (DefaultConstructorMarker) null);
                Set<String> set2 = set;
                ConfirmStripeIntentParams confirmStripeIntentParams3 = confirmStripeIntentParams2;
                Intrinsics.checkNotNullParameter(str, "injectorKey");
                Intrinsics.checkNotNullParameter(str2, "publishableKey");
                Intrinsics.checkNotNullParameter(set2, NamedConstantsKt.PRODUCT_USAGE);
                Intrinsics.checkNotNullParameter(confirmStripeIntentParams3, "confirmStripeIntentParams");
                this.injectorKey = str;
                this.publishableKey = str2;
                this.stripeAccountId = str3;
                this.enableLogging = z;
                this.productUsage = set2;
                this.confirmStripeIntentParams = confirmStripeIntentParams3;
                this.statusBarColor = num;
            }
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J^\u0010#\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\fHÖ\u0001J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\fHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\fHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u00060"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args$PaymentIntentNextActionArgs;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "injectorKey", "", "publishableKey", "stripeAccountId", "enableLogging", "", "productUsage", "", "paymentIntentClientSecret", "statusBarColor", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Set;Ljava/lang/String;Ljava/lang/Integer;)V", "getEnableLogging", "()Z", "getInjectorKey", "()Ljava/lang/String;", "getPaymentIntentClientSecret", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "getStatusBarColor", "()Ljava/lang/Integer;", "setStatusBarColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStripeAccountId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Set;Ljava/lang/String;Ljava/lang/Integer;)Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args$PaymentIntentNextActionArgs;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentLauncherContract.kt */
        public static final class PaymentIntentNextActionArgs extends Args {
            public static final int $stable = 8;
            public static final Parcelable.Creator<PaymentIntentNextActionArgs> CREATOR = new Creator();
            private final boolean enableLogging;
            private final String injectorKey;
            private final String paymentIntentClientSecret;
            private final Set<String> productUsage;
            private final String publishableKey;
            private Integer statusBarColor;
            private final String stripeAccountId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentLauncherContract.kt */
            public static final class Creator implements Parcelable.Creator<PaymentIntentNextActionArgs> {
                public final PaymentIntentNextActionArgs createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    boolean z = parcel.readInt() != 0;
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new PaymentIntentNextActionArgs(readString, readString2, readString3, z, linkedHashSet, parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                public final PaymentIntentNextActionArgs[] newArray(int i) {
                    return new PaymentIntentNextActionArgs[i];
                }
            }

            public static /* synthetic */ PaymentIntentNextActionArgs copy$default(PaymentIntentNextActionArgs paymentIntentNextActionArgs, String str, String str2, String str3, boolean z, Set<String> set, String str4, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = paymentIntentNextActionArgs.getInjectorKey();
                }
                if ((i & 2) != 0) {
                    str2 = paymentIntentNextActionArgs.getPublishableKey();
                }
                String str5 = str2;
                if ((i & 4) != 0) {
                    str3 = paymentIntentNextActionArgs.getStripeAccountId();
                }
                String str6 = str3;
                if ((i & 8) != 0) {
                    z = paymentIntentNextActionArgs.getEnableLogging();
                }
                boolean z2 = z;
                if ((i & 16) != 0) {
                    set = paymentIntentNextActionArgs.getProductUsage();
                }
                Set<String> set2 = set;
                if ((i & 32) != 0) {
                    str4 = paymentIntentNextActionArgs.paymentIntentClientSecret;
                }
                String str7 = str4;
                if ((i & 64) != 0) {
                    num = paymentIntentNextActionArgs.getStatusBarColor();
                }
                return paymentIntentNextActionArgs.copy(str, str5, str6, z2, set2, str7, num);
            }

            public final String component1() {
                return getInjectorKey();
            }

            public final String component2() {
                return getPublishableKey();
            }

            public final String component3() {
                return getStripeAccountId();
            }

            public final boolean component4() {
                return getEnableLogging();
            }

            public final Set<String> component5() {
                return getProductUsage();
            }

            public final String component6() {
                return this.paymentIntentClientSecret;
            }

            public final Integer component7() {
                return getStatusBarColor();
            }

            public final PaymentIntentNextActionArgs copy(@InjectorKey String str, String str2, String str3, boolean z, Set<String> set, String str4, Integer num) {
                Intrinsics.checkNotNullParameter(str, "injectorKey");
                Intrinsics.checkNotNullParameter(str2, "publishableKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                Intrinsics.checkNotNullParameter(str4, "paymentIntentClientSecret");
                return new PaymentIntentNextActionArgs(str, str2, str3, z, set, str4, num);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PaymentIntentNextActionArgs)) {
                    return false;
                }
                PaymentIntentNextActionArgs paymentIntentNextActionArgs = (PaymentIntentNextActionArgs) obj;
                return Intrinsics.areEqual((Object) getInjectorKey(), (Object) paymentIntentNextActionArgs.getInjectorKey()) && Intrinsics.areEqual((Object) getPublishableKey(), (Object) paymentIntentNextActionArgs.getPublishableKey()) && Intrinsics.areEqual((Object) getStripeAccountId(), (Object) paymentIntentNextActionArgs.getStripeAccountId()) && getEnableLogging() == paymentIntentNextActionArgs.getEnableLogging() && Intrinsics.areEqual((Object) getProductUsage(), (Object) paymentIntentNextActionArgs.getProductUsage()) && Intrinsics.areEqual((Object) this.paymentIntentClientSecret, (Object) paymentIntentNextActionArgs.paymentIntentClientSecret) && Intrinsics.areEqual((Object) getStatusBarColor(), (Object) paymentIntentNextActionArgs.getStatusBarColor());
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((getInjectorKey().hashCode() * 31) + getPublishableKey().hashCode()) * 31) + (getStripeAccountId() == null ? 0 : getStripeAccountId().hashCode())) * 31;
                boolean enableLogging2 = getEnableLogging();
                if (enableLogging2) {
                    enableLogging2 = true;
                }
                int hashCode2 = (((((hashCode + (enableLogging2 ? 1 : 0)) * 31) + getProductUsage().hashCode()) * 31) + this.paymentIntentClientSecret.hashCode()) * 31;
                if (getStatusBarColor() != null) {
                    i = getStatusBarColor().hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "PaymentIntentNextActionArgs(injectorKey=" + getInjectorKey() + ", publishableKey=" + getPublishableKey() + ", stripeAccountId=" + getStripeAccountId() + ", enableLogging=" + getEnableLogging() + ", productUsage=" + getProductUsage() + ", paymentIntentClientSecret=" + this.paymentIntentClientSecret + ", statusBarColor=" + getStatusBarColor() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                int i2;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.injectorKey);
                parcel.writeString(this.publishableKey);
                parcel.writeString(this.stripeAccountId);
                parcel.writeInt(this.enableLogging ? 1 : 0);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
                parcel.writeString(this.paymentIntentClientSecret);
                Integer num = this.statusBarColor;
                if (num == null) {
                    i2 = 0;
                } else {
                    parcel.writeInt(1);
                    i2 = num.intValue();
                }
                parcel.writeInt(i2);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ PaymentIntentNextActionArgs(String str, String str2, String str3, boolean z, Set set, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, z, set, str4, (i & 64) != 0 ? null : num);
            }

            public String getInjectorKey() {
                return this.injectorKey;
            }

            public String getPublishableKey() {
                return this.publishableKey;
            }

            public String getStripeAccountId() {
                return this.stripeAccountId;
            }

            public boolean getEnableLogging() {
                return this.enableLogging;
            }

            public Set<String> getProductUsage() {
                return this.productUsage;
            }

            public final String getPaymentIntentClientSecret() {
                return this.paymentIntentClientSecret;
            }

            public Integer getStatusBarColor() {
                return this.statusBarColor;
            }

            public void setStatusBarColor(Integer num) {
                this.statusBarColor = num;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public PaymentIntentNextActionArgs(@InjectorKey String str, String str2, String str3, boolean z, Set<String> set, String str4, Integer num) {
                super(str, str2, str3, z, set, num, (DefaultConstructorMarker) null);
                Set<String> set2 = set;
                String str5 = str4;
                Intrinsics.checkNotNullParameter(str, "injectorKey");
                Intrinsics.checkNotNullParameter(str2, "publishableKey");
                Intrinsics.checkNotNullParameter(set2, NamedConstantsKt.PRODUCT_USAGE);
                Intrinsics.checkNotNullParameter(str5, "paymentIntentClientSecret");
                this.injectorKey = str;
                this.publishableKey = str2;
                this.stripeAccountId = str3;
                this.enableLogging = z;
                this.productUsage = set2;
                this.paymentIntentClientSecret = str5;
                this.statusBarColor = num;
            }
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\b\u0000\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J^\u0010#\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\fHÖ\u0001J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\fHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\fHÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u00060"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args$SetupIntentNextActionArgs;", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "injectorKey", "", "publishableKey", "stripeAccountId", "enableLogging", "", "productUsage", "", "setupIntentClientSecret", "statusBarColor", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Set;Ljava/lang/String;Ljava/lang/Integer;)V", "getEnableLogging", "()Z", "getInjectorKey", "()Ljava/lang/String;", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "getSetupIntentClientSecret", "getStatusBarColor", "()Ljava/lang/Integer;", "setStatusBarColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getStripeAccountId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Set;Ljava/lang/String;Ljava/lang/Integer;)Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args$SetupIntentNextActionArgs;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentLauncherContract.kt */
        public static final class SetupIntentNextActionArgs extends Args {
            public static final int $stable = 8;
            public static final Parcelable.Creator<SetupIntentNextActionArgs> CREATOR = new Creator();
            private final boolean enableLogging;
            private final String injectorKey;
            private final Set<String> productUsage;
            private final String publishableKey;
            private final String setupIntentClientSecret;
            private Integer statusBarColor;
            private final String stripeAccountId;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentLauncherContract.kt */
            public static final class Creator implements Parcelable.Creator<SetupIntentNextActionArgs> {
                public final SetupIntentNextActionArgs createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    boolean z = parcel.readInt() != 0;
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    return new SetupIntentNextActionArgs(readString, readString2, readString3, z, linkedHashSet, parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
                }

                public final SetupIntentNextActionArgs[] newArray(int i) {
                    return new SetupIntentNextActionArgs[i];
                }
            }

            public static /* synthetic */ SetupIntentNextActionArgs copy$default(SetupIntentNextActionArgs setupIntentNextActionArgs, String str, String str2, String str3, boolean z, Set<String> set, String str4, Integer num, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = setupIntentNextActionArgs.getInjectorKey();
                }
                if ((i & 2) != 0) {
                    str2 = setupIntentNextActionArgs.getPublishableKey();
                }
                String str5 = str2;
                if ((i & 4) != 0) {
                    str3 = setupIntentNextActionArgs.getStripeAccountId();
                }
                String str6 = str3;
                if ((i & 8) != 0) {
                    z = setupIntentNextActionArgs.getEnableLogging();
                }
                boolean z2 = z;
                if ((i & 16) != 0) {
                    set = setupIntentNextActionArgs.getProductUsage();
                }
                Set<String> set2 = set;
                if ((i & 32) != 0) {
                    str4 = setupIntentNextActionArgs.setupIntentClientSecret;
                }
                String str7 = str4;
                if ((i & 64) != 0) {
                    num = setupIntentNextActionArgs.getStatusBarColor();
                }
                return setupIntentNextActionArgs.copy(str, str5, str6, z2, set2, str7, num);
            }

            public final String component1() {
                return getInjectorKey();
            }

            public final String component2() {
                return getPublishableKey();
            }

            public final String component3() {
                return getStripeAccountId();
            }

            public final boolean component4() {
                return getEnableLogging();
            }

            public final Set<String> component5() {
                return getProductUsage();
            }

            public final String component6() {
                return this.setupIntentClientSecret;
            }

            public final Integer component7() {
                return getStatusBarColor();
            }

            public final SetupIntentNextActionArgs copy(@InjectorKey String str, String str2, String str3, boolean z, Set<String> set, String str4, Integer num) {
                Intrinsics.checkNotNullParameter(str, "injectorKey");
                Intrinsics.checkNotNullParameter(str2, "publishableKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                Intrinsics.checkNotNullParameter(str4, "setupIntentClientSecret");
                return new SetupIntentNextActionArgs(str, str2, str3, z, set, str4, num);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SetupIntentNextActionArgs)) {
                    return false;
                }
                SetupIntentNextActionArgs setupIntentNextActionArgs = (SetupIntentNextActionArgs) obj;
                return Intrinsics.areEqual((Object) getInjectorKey(), (Object) setupIntentNextActionArgs.getInjectorKey()) && Intrinsics.areEqual((Object) getPublishableKey(), (Object) setupIntentNextActionArgs.getPublishableKey()) && Intrinsics.areEqual((Object) getStripeAccountId(), (Object) setupIntentNextActionArgs.getStripeAccountId()) && getEnableLogging() == setupIntentNextActionArgs.getEnableLogging() && Intrinsics.areEqual((Object) getProductUsage(), (Object) setupIntentNextActionArgs.getProductUsage()) && Intrinsics.areEqual((Object) this.setupIntentClientSecret, (Object) setupIntentNextActionArgs.setupIntentClientSecret) && Intrinsics.areEqual((Object) getStatusBarColor(), (Object) setupIntentNextActionArgs.getStatusBarColor());
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((getInjectorKey().hashCode() * 31) + getPublishableKey().hashCode()) * 31) + (getStripeAccountId() == null ? 0 : getStripeAccountId().hashCode())) * 31;
                boolean enableLogging2 = getEnableLogging();
                if (enableLogging2) {
                    enableLogging2 = true;
                }
                int hashCode2 = (((((hashCode + (enableLogging2 ? 1 : 0)) * 31) + getProductUsage().hashCode()) * 31) + this.setupIntentClientSecret.hashCode()) * 31;
                if (getStatusBarColor() != null) {
                    i = getStatusBarColor().hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "SetupIntentNextActionArgs(injectorKey=" + getInjectorKey() + ", publishableKey=" + getPublishableKey() + ", stripeAccountId=" + getStripeAccountId() + ", enableLogging=" + getEnableLogging() + ", productUsage=" + getProductUsage() + ", setupIntentClientSecret=" + this.setupIntentClientSecret + ", statusBarColor=" + getStatusBarColor() + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                int i2;
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.injectorKey);
                parcel.writeString(this.publishableKey);
                parcel.writeString(this.stripeAccountId);
                parcel.writeInt(this.enableLogging ? 1 : 0);
                Set<String> set = this.productUsage;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
                parcel.writeString(this.setupIntentClientSecret);
                Integer num = this.statusBarColor;
                if (num == null) {
                    i2 = 0;
                } else {
                    parcel.writeInt(1);
                    i2 = num.intValue();
                }
                parcel.writeInt(i2);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ SetupIntentNextActionArgs(String str, String str2, String str3, boolean z, Set set, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, z, set, str4, (i & 64) != 0 ? null : num);
            }

            public String getInjectorKey() {
                return this.injectorKey;
            }

            public String getPublishableKey() {
                return this.publishableKey;
            }

            public String getStripeAccountId() {
                return this.stripeAccountId;
            }

            public boolean getEnableLogging() {
                return this.enableLogging;
            }

            public Set<String> getProductUsage() {
                return this.productUsage;
            }

            public final String getSetupIntentClientSecret() {
                return this.setupIntentClientSecret;
            }

            public Integer getStatusBarColor() {
                return this.statusBarColor;
            }

            public void setStatusBarColor(Integer num) {
                this.statusBarColor = num;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SetupIntentNextActionArgs(@InjectorKey String str, String str2, String str3, boolean z, Set<String> set, String str4, Integer num) {
                super(str, str2, str3, z, set, num, (DefaultConstructorMarker) null);
                Set<String> set2 = set;
                String str5 = str4;
                Intrinsics.checkNotNullParameter(str, "injectorKey");
                Intrinsics.checkNotNullParameter(str2, "publishableKey");
                Intrinsics.checkNotNullParameter(set2, NamedConstantsKt.PRODUCT_USAGE);
                Intrinsics.checkNotNullParameter(str5, "setupIntentClientSecret");
                this.injectorKey = str;
                this.publishableKey = str2;
                this.stripeAccountId = str3;
                this.enableLogging = z;
                this.productUsage = set2;
                this.setupIntentClientSecret = str5;
                this.statusBarColor = num;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args$Companion;", "", "()V", "EXTRA_ARGS", "", "fromIntent", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncherContract$Args;", "intent", "Landroid/content/Intent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentLauncherContract.kt */
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
