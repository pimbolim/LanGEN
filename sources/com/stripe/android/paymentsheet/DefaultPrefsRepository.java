package com.stripe.android.paymentsheet;

import android.content.Context;
import android.content.SharedPreferences;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.model.SavedSelection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/paymentsheet/DefaultPrefsRepository;", "Lcom/stripe/android/paymentsheet/PrefsRepository;", "context", "Landroid/content/Context;", "customerId", "", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/CoroutineContext;)V", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "getKey", "getSavedSelection", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "isGooglePayAvailable", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePaymentSelection", "", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "write", "value", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultPrefsRepository.kt */
public final class DefaultPrefsRepository implements PrefsRepository {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PREF_FILE = "DefaultPrefsRepository";
    /* access modifiers changed from: private */
    public final Context context;
    private final String customerId;
    private final Lazy prefs$delegate = LazyKt.lazy(new DefaultPrefsRepository$prefs$2(this));
    private final CoroutineContext workContext;

    public DefaultPrefsRepository(Context context2, String str, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "customerId");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.context = context2;
        this.customerId = str;
        this.workContext = coroutineContext;
    }

    /* access modifiers changed from: private */
    public final SharedPreferences getPrefs() {
        Object value = this.prefs$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-prefs>(...)");
        return (SharedPreferences) value;
    }

    public Object getSavedSelection(boolean z, Continuation<? super SavedSelection> continuation) {
        return BuildersKt.withContext(this.workContext, new DefaultPrefsRepository$getSavedSelection$2(this, z, (Continuation<? super DefaultPrefsRepository$getSavedSelection$2>) null), continuation);
    }

    public void savePaymentSelection(PaymentSelection paymentSelection) {
        String str;
        if (Intrinsics.areEqual((Object) paymentSelection, (Object) PaymentSelection.GooglePay.INSTANCE)) {
            str = "google_pay";
        } else if (paymentSelection instanceof PaymentSelection.Saved) {
            String str2 = ((PaymentSelection.Saved) paymentSelection).getPaymentMethod().id;
            if (str2 == null) {
                str2 = "";
            }
            str = Intrinsics.stringPlus("payment_method:", str2);
        } else {
            str = null;
        }
        if (str != null) {
            write(str);
        }
    }

    private final void write(String str) {
        getPrefs().edit().putString(getKey(), str).apply();
    }

    /* access modifiers changed from: private */
    public final String getKey() {
        return "customer[" + this.customerId + AbstractJsonLexerKt.END_LIST;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/DefaultPrefsRepository$Companion;", "", "()V", "PREF_FILE", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultPrefsRepository.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
