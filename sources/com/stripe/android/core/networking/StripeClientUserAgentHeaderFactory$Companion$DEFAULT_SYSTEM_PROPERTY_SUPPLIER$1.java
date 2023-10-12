package com.stripe.android.core.networking;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "name", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeClientUserAgentHeaderFactory.kt */
final class StripeClientUserAgentHeaderFactory$Companion$DEFAULT_SYSTEM_PROPERTY_SUPPLIER$1 extends Lambda implements Function1<String, String> {
    public static final StripeClientUserAgentHeaderFactory$Companion$DEFAULT_SYSTEM_PROPERTY_SUPPLIER$1 INSTANCE = new StripeClientUserAgentHeaderFactory$Companion$DEFAULT_SYSTEM_PROPERTY_SUPPLIER$1();

    StripeClientUserAgentHeaderFactory$Companion$DEFAULT_SYSTEM_PROPERTY_SUPPLIER$1() {
        super(1);
    }

    public final String invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        String property = System.getProperty(str);
        return property == null ? "" : property;
    }
}
