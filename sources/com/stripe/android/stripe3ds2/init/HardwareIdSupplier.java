package com.stripe.android.stripe3ds2.init;

import android.content.Context;
import android.provider.Settings;
import com.stripe.android.stripe3ds2.utils.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lib.android.paypal.com.magnessdk.a.b;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/HardwareIdSupplier;", "Lcom/stripe/android/stripe3ds2/utils/Supplier;", "Lcom/stripe/android/stripe3ds2/init/HardwareId;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "get", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HardwareIdSupplier.kt */
public final class HardwareIdSupplier implements Supplier<HardwareId> {
    private final Context context;

    public HardwareIdSupplier(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Context applicationContext = context2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.context = applicationContext;
    }

    public HardwareId get() {
        String string = Settings.Secure.getString(this.context.getContentResolver(), b.f);
        if (string == null) {
            string = "";
        }
        return new HardwareId(string);
    }
}
