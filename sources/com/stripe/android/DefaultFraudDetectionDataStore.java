package com.stripe.android;

import android.content.Context;
import android.content.SharedPreferences;
import com.stripe.android.networking.FraudDetectionData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/DefaultFraudDetectionDataStore;", "Lcom/stripe/android/FraudDetectionDataStore;", "context", "Landroid/content/Context;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "get", "Lcom/stripe/android/networking/FraudDetectionData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", "fraudDetectionData", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FraudDetectionDataStore.kt */
public final class DefaultFraudDetectionDataStore implements FraudDetectionDataStore {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String KEY_DATA = "key_fraud_detection_data";
    @Deprecated
    private static final String PREF_FILE = "FraudDetectionDataStore";
    private final Lazy prefs$delegate;
    private final CoroutineContext workContext;

    public DefaultFraudDetectionDataStore(Context context, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.workContext = coroutineContext;
        this.prefs$delegate = LazyKt.lazy(new DefaultFraudDetectionDataStore$prefs$2(context));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultFraudDetectionDataStore(Context context, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? Dispatchers.getIO() : coroutineContext);
    }

    /* access modifiers changed from: private */
    public final SharedPreferences getPrefs() {
        return (SharedPreferences) this.prefs$delegate.getValue();
    }

    public Object get(Continuation<? super FraudDetectionData> continuation) {
        return BuildersKt.withContext(this.workContext, new DefaultFraudDetectionDataStore$get$2(this, (Continuation<? super DefaultFraudDetectionDataStore$get$2>) null), continuation);
    }

    public void save(FraudDetectionData fraudDetectionData) {
        Intrinsics.checkNotNullParameter(fraudDetectionData, "fraudDetectionData");
        SharedPreferences prefs = getPrefs();
        Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
        SharedPreferences.Editor edit = prefs.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putString(KEY_DATA, fraudDetectionData.toJson().toString());
        edit.apply();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/DefaultFraudDetectionDataStore$Companion;", "", "()V", "KEY_DATA", "", "PREF_FILE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FraudDetectionDataStore.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
