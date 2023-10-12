package com.stripe.android.link.injection;

import com.stripe.android.core.injection.Injectable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\b`\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/link/injection/NonFallbackInjectable;", "Lcom/stripe/android/core/injection/Injectable;", "", "fallbackInitialize", "", "arg", "(Lkotlin/Unit;)Ljava/lang/Void;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NonFallbackInjectable.kt */
public interface NonFallbackInjectable extends Injectable<Unit> {
    Void fallbackInitialize(Unit unit);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NonFallbackInjectable.kt */
    public static final class DefaultImpls {
        public static Void fallbackInitialize(NonFallbackInjectable nonFallbackInjectable, Unit unit) {
            Intrinsics.checkNotNullParameter(nonFallbackInjectable, "this");
            Intrinsics.checkNotNullParameter(unit, "arg");
            throw new IllegalStateException(Intrinsics.stringPlus(nonFallbackInjectable.getClass().getCanonicalName(), " does not support injection fallback"));
        }
    }
}
