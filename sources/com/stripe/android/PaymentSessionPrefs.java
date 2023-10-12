package com.stripe.android;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u0000 \b2\u00020\u0001:\u0002\b\tJ\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&¨\u0006\n"}, d2 = {"Lcom/stripe/android/PaymentSessionPrefs;", "", "getPaymentMethodId", "", "customerId", "savePaymentMethodId", "", "paymentMethodId", "Companion", "Default", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSessionPrefs.kt */
public interface PaymentSessionPrefs {
    public static final Companion Companion = Companion.$$INSTANCE;

    String getPaymentMethodId(String str);

    void savePaymentMethodId(String str, String str2);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/PaymentSessionPrefs$Default;", "Lcom/stripe/android/PaymentSessionPrefs;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "getPaymentMethodId", "", "customerId", "savePaymentMethodId", "", "paymentMethodId", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionPrefs.kt */
    public static final class Default implements PaymentSessionPrefs {
        public static final int $stable = 8;
        private final Lazy prefs$delegate;

        public Default(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.prefs$delegate = LazyKt.lazy(new PaymentSessionPrefs$Default$prefs$2(context));
        }

        public final SharedPreferences getPrefs() {
            Object value = this.prefs$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-prefs>(...)");
            return (SharedPreferences) value;
        }

        public String getPaymentMethodId(String str) {
            if (str == null) {
                return null;
            }
            return getPrefs().getString(PaymentSessionPrefs.Companion.getPaymentMethodKey(str), (String) null);
        }

        public void savePaymentMethodId(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "customerId");
            getPrefs().edit().putString(PaymentSessionPrefs.Companion.getPaymentMethodKey(str), str2).apply();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/PaymentSessionPrefs$Companion;", "", "()V", "PREF_FILE", "", "getPaymentMethodKey", "customerId", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionPrefs.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String PREF_FILE = "PaymentSessionPrefs";

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final String getPaymentMethodKey(String str) {
            return "customer[" + str + "].payment_method";
        }
    }
}
