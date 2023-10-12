package com.stripe.android.core.injection;

import com.stripe.android.core.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"injectWithFallback", "", "FallbackInitializeParam", "Lcom/stripe/android/core/injection/Injectable;", "injectorKey", "", "fallbackInitializeParam", "(Lcom/stripe/android/core/injection/Injectable;Ljava/lang/String;Ljava/lang/Object;)V", "stripe-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: InjectableKtx.kt */
public final class InjectableKtxKt {
    public static final <FallbackInitializeParam> void injectWithFallback(Injectable<FallbackInitializeParam> injectable, @InjectorKey String str, FallbackInitializeParam fallbackinitializeparam) {
        Injector retrieve;
        Intrinsics.checkNotNullParameter(injectable, "<this>");
        Logger instance = Logger.Companion.getInstance(false);
        Unit unit = null;
        if (!(str == null || (retrieve = WeakMapInjectorRegistry.INSTANCE.retrieve(str)) == null)) {
            instance.info(Intrinsics.stringPlus("Injector available, injecting dependencies into ", injectable.getClass().getCanonicalName()));
            retrieve.inject(injectable);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            instance.info(Intrinsics.stringPlus("Injector unavailable, initializing dependencies of ", injectable.getClass().getCanonicalName()));
            injectable.fallbackInitialize(fallbackinitializeparam);
        }
    }
}
