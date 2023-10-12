package com.stripe.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.ApiKeyValidator;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/PaymentConfiguration;", "Landroid/os/Parcelable;", "publishableKey", "", "stripeAccountId", "(Ljava/lang/String;Ljava/lang/String;)V", "getPublishableKey", "()Ljava/lang/String;", "getStripeAccountId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Store", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentConfiguration.kt */
public final class PaymentConfiguration implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaymentConfiguration> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static PaymentConfiguration instance;
    private final String publishableKey;
    private final String stripeAccountId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentConfiguration.kt */
    public static final class Creator implements Parcelable.Creator<PaymentConfiguration> {
        public final PaymentConfiguration createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PaymentConfiguration(parcel.readString(), parcel.readString());
        }

        public final PaymentConfiguration[] newArray(int i) {
            return new PaymentConfiguration[i];
        }
    }

    public static /* synthetic */ PaymentConfiguration copy$default(PaymentConfiguration paymentConfiguration, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentConfiguration.publishableKey;
        }
        if ((i & 2) != 0) {
            str2 = paymentConfiguration.stripeAccountId;
        }
        return paymentConfiguration.copy(str, str2);
    }

    @JvmStatic
    public static final PaymentConfiguration getInstance(Context context) {
        return Companion.getInstance(context);
    }

    @JvmStatic
    public static final void init(Context context, String str) {
        Companion.init(context, str);
    }

    @JvmStatic
    public static final void init(Context context, String str, String str2) {
        Companion.init(context, str, str2);
    }

    public final String component1() {
        return this.publishableKey;
    }

    public final String component2() {
        return this.stripeAccountId;
    }

    public final PaymentConfiguration copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        return new PaymentConfiguration(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentConfiguration)) {
            return false;
        }
        PaymentConfiguration paymentConfiguration = (PaymentConfiguration) obj;
        return Intrinsics.areEqual((Object) this.publishableKey, (Object) paymentConfiguration.publishableKey) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) paymentConfiguration.stripeAccountId);
    }

    public int hashCode() {
        int hashCode = this.publishableKey.hashCode() * 31;
        String str = this.stripeAccountId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PaymentConfiguration(publishableKey=" + this.publishableKey + ", stripeAccountId=" + this.stripeAccountId + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.publishableKey);
        parcel.writeString(this.stripeAccountId);
    }

    public PaymentConfiguration(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        this.publishableKey = str;
        this.stripeAccountId = str2;
        ApiKeyValidator.Companion.get().requireValid(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentConfiguration(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getPublishableKey() {
        return this.publishableKey;
    }

    public final String getStripeAccountId() {
        return this.stripeAccountId;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/PaymentConfiguration$Store;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "load", "Lcom/stripe/android/PaymentConfiguration;", "load$payments_core_release", "save", "", "publishableKey", "", "stripeAccountId", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentConfiguration.kt */
    private static final class Store {
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String KEY_ACCOUNT_ID = "key_account_id";
        @Deprecated
        private static final String KEY_PUBLISHABLE_KEY = "key_publishable_key";
        @Deprecated
        private static final String NAME = PaymentConfiguration.class.getCanonicalName();
        private final SharedPreferences prefs;

        public Store(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(NAME, 0);
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.applicationConte…haredPreferences(NAME, 0)");
            this.prefs = sharedPreferences;
        }

        public final /* synthetic */ void save(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            this.prefs.edit().putString(KEY_PUBLISHABLE_KEY, str).putString(KEY_ACCOUNT_ID, str2).apply();
        }

        public final /* synthetic */ PaymentConfiguration load$payments_core_release() {
            String string = this.prefs.getString(KEY_PUBLISHABLE_KEY, (String) null);
            if (string == null) {
                return null;
            }
            return new PaymentConfiguration(string, this.prefs.getString(KEY_ACCOUNT_ID, (String) null));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/PaymentConfiguration$Store$Companion;", "", "()V", "KEY_ACCOUNT_ID", "", "KEY_PUBLISHABLE_KEY", "NAME", "kotlin.jvm.PlatformType", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentConfiguration.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J$\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/PaymentConfiguration$Companion;", "", "()V", "instance", "Lcom/stripe/android/PaymentConfiguration;", "clearInstance", "", "getInstance", "context", "Landroid/content/Context;", "init", "publishableKey", "", "stripeAccountId", "loadInstance", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentConfiguration.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void init(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            init$default(this, context, str, (String) null, 4, (Object) null);
        }

        private Companion() {
        }

        @JvmStatic
        public final PaymentConfiguration getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            PaymentConfiguration access$getInstance$cp = PaymentConfiguration.instance;
            return access$getInstance$cp == null ? loadInstance(context) : access$getInstance$cp;
        }

        private final PaymentConfiguration loadInstance(Context context) {
            PaymentConfiguration load$payments_core_release = new Store(context).load$payments_core_release();
            if (load$payments_core_release == null) {
                load$payments_core_release = null;
            } else {
                Companion companion = PaymentConfiguration.Companion;
                PaymentConfiguration.instance = load$payments_core_release;
            }
            if (load$payments_core_release != null) {
                return load$payments_core_release;
            }
            throw new IllegalStateException("PaymentConfiguration was not initialized. Call PaymentConfiguration.init().");
        }

        public static /* synthetic */ void init$default(Companion companion, Context context, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            companion.init(context, str, str2);
        }

        @JvmStatic
        public final void init(Context context, String str, String str2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            PaymentConfiguration.instance = new PaymentConfiguration(str, str2);
            new Store(context).save(str, str2);
            new DefaultFraudDetectionDataRepository(context, (CoroutineContext) null, 2, (DefaultConstructorMarker) null).refresh();
        }

        public final /* synthetic */ void clearInstance() {
            PaymentConfiguration.instance = null;
        }
    }
}
