package com.stripe.android.utils;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/utils/StripeUrlUtils;", "", "()V", "isStripeUrl", "", "url", "", "isStripeUrl$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeUrlUtils.kt */
public final class StripeUrlUtils {
    public static final StripeUrlUtils INSTANCE = new StripeUrlUtils();

    private StripeUrlUtils() {
    }

    public final boolean isStripeUrl$payments_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Uri parse = Uri.parse(str);
        if (!Intrinsics.areEqual((Object) parse.getScheme(), (Object) "https")) {
            return false;
        }
        String host = parse.getHost();
        if (!Intrinsics.areEqual((Object) host, (Object) "stripe.com")) {
            if (host == null ? false : StringsKt.endsWith$default(host, ".stripe.com", false, 2, (Object) null)) {
                return true;
            }
            return false;
        }
        return true;
    }
}
