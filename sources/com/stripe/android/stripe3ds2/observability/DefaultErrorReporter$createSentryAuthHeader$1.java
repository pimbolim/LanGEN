package com.stripe.android.stripe3ds2.observability;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultErrorReporter.kt */
final class DefaultErrorReporter$createSentryAuthHeader$1 extends Lambda implements Function1<Pair<? extends String, ? extends String>, CharSequence> {
    public static final DefaultErrorReporter$createSentryAuthHeader$1 INSTANCE = new DefaultErrorReporter$createSentryAuthHeader$1();

    DefaultErrorReporter$createSentryAuthHeader$1() {
        super(1);
    }

    public final CharSequence invoke(Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "$dstr$key$value");
        return pair.component1() + SignatureVisitor.INSTANCEOF + pair.component2();
    }
}
