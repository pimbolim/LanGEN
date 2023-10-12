package com.stripe.android.link;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"urlEncode", "", "link_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkScreen.kt */
public final class LinkScreenKt {
    /* access modifiers changed from: private */
    public static final String urlEncode(String str) {
        String encode = URLEncoder.encode(str, StandardCharsets.UTF_8.toString());
        Intrinsics.checkNotNullExpressionValue(encode, "encode(this, StandardCharsets.UTF_8.toString())");
        return encode;
    }
}
