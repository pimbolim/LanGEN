package com.stripe.android.paymentsheet.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import com.stripe.android.core.injection.IOContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0019\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0011\u0010\u0011\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/DefaultDeviceIdRepository;", "Lcom/stripe/android/paymentsheet/analytics/DeviceIdRepository;", "context", "Landroid/content/Context;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "prefs$delegate", "Lkotlin/Lazy;", "createDeviceId", "Lcom/stripe/android/paymentsheet/analytics/DeviceId;", "get", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultDeviceIdRepository.kt */
public final class DefaultDeviceIdRepository implements DeviceIdRepository {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String KEY_DEVICE_ID = "device_id";
    @Deprecated
    private static final String PREF_FILE = "DefaultDeviceIdRepository";
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    private final Lazy prefs$delegate = LazyKt.lazy(new DefaultDeviceIdRepository$prefs$2(this));
    private final CoroutineContext workContext;

    @Inject
    public DefaultDeviceIdRepository(Context context2, @IOContext CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.context = context2;
        this.workContext = coroutineContext;
    }

    /* access modifiers changed from: private */
    public final SharedPreferences getPrefs() {
        Object value = this.prefs$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-prefs>(...)");
        return (SharedPreferences) value;
    }

    public Object get(Continuation<? super DeviceId> continuation) {
        return BuildersKt.withContext(this.workContext, new DefaultDeviceIdRepository$get$2(this, (Continuation<? super DefaultDeviceIdRepository$get$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final DeviceId createDeviceId() {
        DeviceId deviceId = new DeviceId();
        SharedPreferences.Editor edit = getPrefs().edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putString("device_id", deviceId.getValue());
        edit.commit();
        return deviceId;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/paymentsheet/analytics/DefaultDeviceIdRepository$Companion;", "", "()V", "KEY_DEVICE_ID", "", "PREF_FILE", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultDeviceIdRepository.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
