package com.stripe.android.core.injection;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H'J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0003H&J\u0014\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/stripe/android/core/injection/InjectorRegistry;", "", "nextKey", "", "prefix", "register", "", "injector", "Lcom/stripe/android/core/injection/Injector;", "key", "retrieve", "injectorKey", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InjectorRegistry.kt */
public interface InjectorRegistry {
    @InjectorKey
    String nextKey(String str);

    void register(Injector injector, @InjectorKey String str);

    Injector retrieve(@InjectorKey String str);
}
