package com.stripe.android.link.account;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "eachByte", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CookieStore.kt */
final class CookieStore$sha256$1 extends Lambda implements Function1<Byte, CharSequence> {
    public static final CookieStore$sha256$1 INSTANCE = new CookieStore$sha256$1();

    CookieStore$sha256$1() {
        super(1);
    }

    public final CharSequence invoke(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).byteValue());
    }
}
