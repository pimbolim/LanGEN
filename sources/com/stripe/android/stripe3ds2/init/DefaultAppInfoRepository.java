package com.stripe.android.stripe3ds2.init;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u001f\b\u0001\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u000eH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/DefaultAppInfoRepository;", "Lcom/stripe/android/stripe3ds2/init/AppInfoRepository;", "context", "Landroid/content/Context;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "appVersion", "", "(Landroid/content/Context;ILkotlin/coroutines/CoroutineContext;)V", "store", "Lcom/stripe/android/stripe3ds2/init/DefaultAppInfoRepository$Store;", "(Lcom/stripe/android/stripe3ds2/init/DefaultAppInfoRepository$Store;ILkotlin/coroutines/CoroutineContext;)V", "get", "Lcom/stripe/android/stripe3ds2/init/AppInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initAppInfo", "Companion", "Store", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultAppInfoRepository.kt */
public final class DefaultAppInfoRepository implements AppInfoRepository {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int INVALID_VERSION_CODE = -1;
    /* access modifiers changed from: private */
    public final int appVersion;
    /* access modifiers changed from: private */
    public final Store store;

    public DefaultAppInfoRepository(Store store2, int i, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(store2, "store");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.store = store2;
        this.appVersion = i;
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(coroutineContext), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultAppInfoRepository(Context context, CoroutineContext coroutineContext) {
        this(context, Companion.getAppVersion(context), coroutineContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultAppInfoRepository(Context context, int i, CoroutineContext coroutineContext) {
        this((Store) new Store.Default(context, i, coroutineContext), i, coroutineContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository$1", f = "DefaultAppInfoRepository.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository$1  reason: invalid class name */
    /* compiled from: DefaultAppInfoRepository.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int label;
        final /* synthetic */ DefaultAppInfoRepository this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            boolean z = true;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                int access$getAppVersion$p = this.this$0.appVersion;
                this.I$0 = access$getAppVersion$p;
                this.label = 1;
                Object obj2 = this.this$0.store.get(this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = access$getAppVersion$p;
                obj = obj2;
            } else if (i2 == 1) {
                i = this.I$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AppInfo appInfo = (AppInfo) obj;
            if (appInfo == null || i != appInfo.getVersion()) {
                z = false;
            }
            if (!z) {
                AppInfo unused = this.this$0.initAppInfo();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object get(kotlin.coroutines.Continuation<? super com.stripe.android.stripe3ds2.init.AppInfo> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository$get$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository$get$1 r0 = (com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository$get$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository$get$1 r0 = new com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository$get$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository r0 = (com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository$Store r5 = r4.store
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.get(r0)
            if (r5 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r0 = r4
        L_0x0047:
            com.stripe.android.stripe3ds2.init.AppInfo r5 = (com.stripe.android.stripe3ds2.init.AppInfo) r5
            if (r5 != 0) goto L_0x004f
            com.stripe.android.stripe3ds2.init.AppInfo r5 = r0.initAppInfo()
        L_0x004f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository.get(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final AppInfo initAppInfo() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        AppInfo appInfo = new AppInfo(uuid, this.appVersion);
        this.store.save(appInfo);
        return appInfo;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H&\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/DefaultAppInfoRepository$Store;", "", "get", "Lcom/stripe/android/stripe3ds2/init/AppInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", "appInfo", "Default", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultAppInfoRepository.kt */
    public interface Store {
        Object get(Continuation<? super AppInfo> continuation);

        void save(AppInfo appInfo);

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/DefaultAppInfoRepository$Store$Default;", "Lcom/stripe/android/stripe3ds2/init/DefaultAppInfoRepository$Store;", "context", "Landroid/content/Context;", "appVersion", "", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;ILkotlin/coroutines/CoroutineContext;)V", "sharedPrefs", "Landroid/content/SharedPreferences;", "getSharedPrefs", "()Landroid/content/SharedPreferences;", "sharedPrefs$delegate", "Lkotlin/Lazy;", "get", "Lcom/stripe/android/stripe3ds2/init/AppInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "", "appInfo", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DefaultAppInfoRepository.kt */
        public static final class Default implements Store {
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String KEY_APP_VERSION = "app_version";
            @Deprecated
            private static final String KEY_SDK_APP_ID = "sdk_app_id";
            @Deprecated
            private static final String PREFS_NAME = "app_info";
            private final int appVersion;
            private final Lazy sharedPrefs$delegate;
            private final CoroutineContext workContext;

            public Default(Context context, int i, CoroutineContext coroutineContext) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
                this.appVersion = i;
                this.workContext = coroutineContext;
                this.sharedPrefs$delegate = LazyKt.lazy(new DefaultAppInfoRepository$Store$Default$sharedPrefs$2(context));
            }

            /* access modifiers changed from: private */
            public final SharedPreferences getSharedPrefs() {
                Object value = this.sharedPrefs$delegate.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "<get-sharedPrefs>(...)");
                return (SharedPreferences) value;
            }

            public Object get(Continuation<? super AppInfo> continuation) {
                return BuildersKt.withContext(this.workContext, new DefaultAppInfoRepository$Store$Default$get$2(this, (Continuation<? super DefaultAppInfoRepository$Store$Default$get$2>) null), continuation);
            }

            public void save(AppInfo appInfo) {
                Intrinsics.checkNotNullParameter(appInfo, "appInfo");
                getSharedPrefs().edit().putInt("app_version", this.appVersion).putString(KEY_SDK_APP_ID, appInfo.getSdkAppId()).apply();
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/DefaultAppInfoRepository$Store$Default$Companion;", "", "()V", "KEY_APP_VERSION", "", "KEY_SDK_APP_ID", "PREFS_NAME", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: DefaultAppInfoRepository.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/DefaultAppInfoRepository$Companion;", "", "()V", "INVALID_VERSION_CODE", "", "getAppVersion", "context", "Landroid/content/Context;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultAppInfoRepository.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final int getAppVersion(Context context) {
            Integer num;
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                num = Result.m4709constructorimpl(Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                num = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m4715isFailureimpl(num)) {
                num = -1;
            }
            return ((Number) num).intValue();
        }
    }
}
