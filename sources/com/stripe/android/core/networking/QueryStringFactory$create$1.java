package com.stripe.android.core.networking;

import com.stripe.android.core.networking.QueryStringFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/stripe/android/core/networking/QueryStringFactory$Parameter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: QueryStringFactory.kt */
final class QueryStringFactory$create$1 extends Lambda implements Function1<QueryStringFactory.Parameter, CharSequence> {
    public static final QueryStringFactory$create$1 INSTANCE = new QueryStringFactory$create$1();

    QueryStringFactory$create$1() {
        super(1);
    }

    public final CharSequence invoke(QueryStringFactory.Parameter parameter) {
        Intrinsics.checkNotNullParameter(parameter, "it");
        return parameter.toString();
    }
}
