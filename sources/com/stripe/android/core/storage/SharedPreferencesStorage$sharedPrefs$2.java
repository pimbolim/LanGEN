package com.stripe.android.core.storage;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Storage.kt */
final class SharedPreferencesStorage$sharedPrefs$2 extends Lambda implements Function0<SharedPreferences> {
    final /* synthetic */ SharedPreferencesStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedPreferencesStorage$sharedPrefs$2(SharedPreferencesStorage sharedPreferencesStorage) {
        super(0);
        this.this$0 = sharedPreferencesStorage;
    }

    public final SharedPreferences invoke() {
        return this.this$0.context.getSharedPreferences("stripe_shared_prefs", 0);
    }
}
