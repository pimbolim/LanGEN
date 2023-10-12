package com.stripe.android.paymentsheet;

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
import com.stripe.android.core.injection.InjectorKt;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResult;
import com.stripe.android.paymentsheet.model.ClientSecret;
import com.stripe.android.paymentsheet.model.PaymentIntentClientSecret;
import com.stripe.android.paymentsheet.model.SetupIntentClientSecret;
import com.stripe.android.view.ActivityStarter;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "Companion", "Result", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetContract.kt */
public final class PaymentSheetContract extends ActivityResultContract<Args, PaymentSheetResult> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_ARGS = "com.stripe.android.paymentsheet.PaymentSheetContract.extra_args";
    private static final String EXTRA_RESULT = "com.stripe.android.paymentsheet.PaymentSheetContract.extra_result";

    public Intent createIntent(Context context, Args args) {
        Window window;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, GraphQLConstants.Keys.INPUT);
        Integer num = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (!(activity == null || (window = activity.getWindow()) == null)) {
            num = Integer.valueOf(window.getStatusBarColor());
        }
        Intent putExtra = new Intent(context, PaymentSheetActivity.class).putExtra(EXTRA_ARGS, Args.copy$default(args, (ClientSecret) null, (PaymentSheet.Configuration) null, num, (String) null, 11, (Object) null));
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, PaymentS…rColor = statusBarColor))");
        return putExtra;
    }

    public PaymentSheetResult parseResult(int i, Intent intent) {
        Result result;
        PaymentSheetResult paymentSheetResult = null;
        if (!(intent == null || (result = (Result) intent.getParcelableExtra(EXTRA_RESULT)) == null)) {
            paymentSheetResult = result.getPaymentSheetResult();
        }
        return paymentSheetResult == null ? new PaymentSheetResult.Failed(new IllegalArgumentException("Failed to retrieve a PaymentSheetResult.")) : paymentSheetResult;
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B/\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0018\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0004\b\u001d\u0010\u0016J\u000e\u0010\u001e\u001a\u00020\tHÀ\u0003¢\u0006\u0002\b\u001fJ:\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010!J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\t\u0010(\u001a\u00020\tHÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "Lcom/stripe/android/view/ActivityStarter$Args;", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "config", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "statusBarColor", "", "injectorKey", "", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;Ljava/lang/Integer;Ljava/lang/String;)V", "getClientSecret$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/model/ClientSecret;", "getConfig$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "googlePayConfig", "Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "getGooglePayConfig", "()Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "getInjectorKey$paymentsheet_release", "()Ljava/lang/String;", "getStatusBarColor$paymentsheet_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component1$paymentsheet_release", "component2", "component2$paymentsheet_release", "component3", "component3$paymentsheet_release", "component4", "component4$paymentsheet_release", "copy", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;Ljava/lang/Integer;Ljava/lang/String;)Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetContract.kt */
    public static final class Args implements ActivityStarter.Args {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ClientSecret clientSecret;
        private final PaymentSheet.Configuration config;
        private final String injectorKey;
        private final Integer statusBarColor;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetContract.kt */
        public static final class Creator implements Parcelable.Creator<Args> {
            public final Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                ClientSecret clientSecret = (ClientSecret) parcel.readParcelable(Args.class.getClassLoader());
                Integer num = null;
                PaymentSheet.Configuration createFromParcel = parcel.readInt() == 0 ? null : PaymentSheet.Configuration.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    num = Integer.valueOf(parcel.readInt());
                }
                return new Args(clientSecret, createFromParcel, num, parcel.readString());
            }

            public final Args[] newArray(int i) {
                return new Args[i];
            }
        }

        public static /* synthetic */ Args copy$default(Args args, ClientSecret clientSecret2, PaymentSheet.Configuration configuration, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                clientSecret2 = args.clientSecret;
            }
            if ((i & 2) != 0) {
                configuration = args.config;
            }
            if ((i & 4) != 0) {
                num = args.statusBarColor;
            }
            if ((i & 8) != 0) {
                str = args.injectorKey;
            }
            return args.copy(clientSecret2, configuration, num, str);
        }

        public final ClientSecret component1$paymentsheet_release() {
            return this.clientSecret;
        }

        public final PaymentSheet.Configuration component2$paymentsheet_release() {
            return this.config;
        }

        public final Integer component3$paymentsheet_release() {
            return this.statusBarColor;
        }

        public final String component4$paymentsheet_release() {
            return this.injectorKey;
        }

        public final Args copy(ClientSecret clientSecret2, PaymentSheet.Configuration configuration, Integer num, @InjectorKey String str) {
            Intrinsics.checkNotNullParameter(clientSecret2, "clientSecret");
            Intrinsics.checkNotNullParameter(str, "injectorKey");
            return new Args(clientSecret2, configuration, num, str);
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
            return Intrinsics.areEqual((Object) this.clientSecret, (Object) args.clientSecret) && Intrinsics.areEqual((Object) this.config, (Object) args.config) && Intrinsics.areEqual((Object) this.statusBarColor, (Object) args.statusBarColor) && Intrinsics.areEqual((Object) this.injectorKey, (Object) args.injectorKey);
        }

        public int hashCode() {
            int hashCode = this.clientSecret.hashCode() * 31;
            PaymentSheet.Configuration configuration = this.config;
            int i = 0;
            int hashCode2 = (hashCode + (configuration == null ? 0 : configuration.hashCode())) * 31;
            Integer num = this.statusBarColor;
            if (num != null) {
                i = num.hashCode();
            }
            return ((hashCode2 + i) * 31) + this.injectorKey.hashCode();
        }

        public String toString() {
            return "Args(clientSecret=" + this.clientSecret + ", config=" + this.config + ", statusBarColor=" + this.statusBarColor + ", injectorKey=" + this.injectorKey + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.clientSecret, i);
            PaymentSheet.Configuration configuration = this.config;
            if (configuration == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                configuration.writeToParcel(parcel, i);
            }
            Integer num = this.statusBarColor;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            parcel.writeString(this.injectorKey);
        }

        public Args(ClientSecret clientSecret2, PaymentSheet.Configuration configuration, Integer num, @InjectorKey String str) {
            Intrinsics.checkNotNullParameter(clientSecret2, "clientSecret");
            Intrinsics.checkNotNullParameter(str, "injectorKey");
            this.clientSecret = clientSecret2;
            this.config = configuration;
            this.statusBarColor = num;
            this.injectorKey = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Args(ClientSecret clientSecret2, PaymentSheet.Configuration configuration, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(clientSecret2, configuration, (i & 4) != 0 ? null : num, (i & 8) != 0 ? InjectorKt.DUMMY_INJECTOR_KEY : str);
        }

        public final ClientSecret getClientSecret$paymentsheet_release() {
            return this.clientSecret;
        }

        public final PaymentSheet.Configuration getConfig$paymentsheet_release() {
            return this.config;
        }

        public final Integer getStatusBarColor$paymentsheet_release() {
            return this.statusBarColor;
        }

        public final String getInjectorKey$paymentsheet_release() {
            return this.injectorKey;
        }

        public final PaymentSheet.GooglePayConfiguration getGooglePayConfig() {
            PaymentSheet.Configuration configuration = this.config;
            if (configuration == null) {
                return null;
            }
            return configuration.getGooglePay();
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ+\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000bJ\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ+\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args$Companion;", "", "()V", "createPaymentIntentArgs", "Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "clientSecret", "", "config", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "createPaymentIntentArgsWithInjectorKey", "injectorKey", "createPaymentIntentArgsWithInjectorKey$paymentsheet_release", "createSetupIntentArgs", "createSetupIntentArgsWithInjectorKey", "createSetupIntentArgsWithInjectorKey$paymentsheet_release", "fromIntent", "intent", "Landroid/content/Intent;", "fromIntent$paymentsheet_release", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetContract.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Args fromIntent$paymentsheet_release(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                return (Args) intent.getParcelableExtra(PaymentSheetContract.EXTRA_ARGS);
            }

            public static /* synthetic */ Args createPaymentIntentArgs$default(Companion companion, String str, PaymentSheet.Configuration configuration, int i, Object obj) {
                if ((i & 2) != 0) {
                    configuration = null;
                }
                return companion.createPaymentIntentArgs(str, configuration);
            }

            public final Args createPaymentIntentArgs(String str, PaymentSheet.Configuration configuration) {
                Intrinsics.checkNotNullParameter(str, "clientSecret");
                return new Args(new PaymentIntentClientSecret(str), configuration, (Integer) null, (String) null, 12, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Args createSetupIntentArgs$default(Companion companion, String str, PaymentSheet.Configuration configuration, int i, Object obj) {
                if ((i & 2) != 0) {
                    configuration = null;
                }
                return companion.createSetupIntentArgs(str, configuration);
            }

            public final Args createSetupIntentArgs(String str, PaymentSheet.Configuration configuration) {
                Intrinsics.checkNotNullParameter(str, "clientSecret");
                return new Args(new SetupIntentClientSecret(str), configuration, (Integer) null, (String) null, 12, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Args createPaymentIntentArgsWithInjectorKey$paymentsheet_release$default(Companion companion, String str, PaymentSheet.Configuration configuration, String str2, int i, Object obj) {
                if ((i & 2) != 0) {
                    configuration = null;
                }
                return companion.createPaymentIntentArgsWithInjectorKey$paymentsheet_release(str, configuration, str2);
            }

            public final Args createPaymentIntentArgsWithInjectorKey$paymentsheet_release(String str, PaymentSheet.Configuration configuration, @InjectorKey String str2) {
                Intrinsics.checkNotNullParameter(str, "clientSecret");
                Intrinsics.checkNotNullParameter(str2, "injectorKey");
                return new Args(new PaymentIntentClientSecret(str), configuration, (Integer) null, str2, 4, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Args createSetupIntentArgsWithInjectorKey$paymentsheet_release$default(Companion companion, String str, PaymentSheet.Configuration configuration, String str2, int i, Object obj) {
                if ((i & 2) != 0) {
                    configuration = null;
                }
                return companion.createSetupIntentArgsWithInjectorKey$paymentsheet_release(str, configuration, str2);
            }

            public final Args createSetupIntentArgsWithInjectorKey$paymentsheet_release(String str, PaymentSheet.Configuration configuration, @InjectorKey String str2) {
                Intrinsics.checkNotNullParameter(str, "clientSecret");
                Intrinsics.checkNotNullParameter(str2, "injectorKey");
                return new Args(new SetupIntentClientSecret(str), configuration, (Integer) null, str2, 4, (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetContract$Result;", "Lcom/stripe/android/view/ActivityStarter$Result;", "paymentSheetResult", "Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "(Lcom/stripe/android/paymentsheet/PaymentSheetResult;)V", "getPaymentSheetResult", "()Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetContract.kt */
    public static final class Result implements ActivityStarter.Result {
        public static final Parcelable.Creator<Result> CREATOR = new Creator();
        private final PaymentSheetResult paymentSheetResult;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetContract.kt */
        public static final class Creator implements Parcelable.Creator<Result> {
            public final Result createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Result((PaymentSheetResult) parcel.readParcelable(Result.class.getClassLoader()));
            }

            public final Result[] newArray(int i) {
                return new Result[i];
            }
        }

        public static /* synthetic */ Result copy$default(Result result, PaymentSheetResult paymentSheetResult2, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentSheetResult2 = result.paymentSheetResult;
            }
            return result.copy(paymentSheetResult2);
        }

        public final PaymentSheetResult component1() {
            return this.paymentSheetResult;
        }

        public final Result copy(PaymentSheetResult paymentSheetResult2) {
            Intrinsics.checkNotNullParameter(paymentSheetResult2, "paymentSheetResult");
            return new Result(paymentSheetResult2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Result) && Intrinsics.areEqual((Object) this.paymentSheetResult, (Object) ((Result) obj).paymentSheetResult);
        }

        public int hashCode() {
            return this.paymentSheetResult.hashCode();
        }

        public String toString() {
            return "Result(paymentSheetResult=" + this.paymentSheetResult + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.paymentSheetResult, i);
        }

        public Result(PaymentSheetResult paymentSheetResult2) {
            Intrinsics.checkNotNullParameter(paymentSheetResult2, "paymentSheetResult");
            this.paymentSheetResult = paymentSheetResult2;
        }

        public final PaymentSheetResult getPaymentSheetResult() {
            return this.paymentSheetResult;
        }

        public Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to(PaymentSheetContract.EXTRA_RESULT, this));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetContract$Companion;", "", "()V", "EXTRA_ARGS", "", "getEXTRA_ARGS$annotations", "EXTRA_RESULT", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetContract.kt */
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
