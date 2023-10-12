package com.stripe.android.core.networking;

import android.os.Build;
import com.stripe.android.core.AppInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ\u0014\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/core/networking/StripeClientUserAgentHeaderFactory;", "", "systemPropertySupplier", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "create", "", "appInfo", "Lcom/stripe/android/core/AppInfo;", "createHeaderValue", "Lorg/json/JSONObject;", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeClientUserAgentHeaderFactory.kt */
public final class StripeClientUserAgentHeaderFactory {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Function1<String, String> DEFAULT_SYSTEM_PROPERTY_SUPPLIER = StripeClientUserAgentHeaderFactory$Companion$DEFAULT_SYSTEM_PROPERTY_SUPPLIER$1.INSTANCE;
    public static final String HEADER_STRIPE_CLIENT_USER_AGENT = "X-Stripe-Client-User-Agent";
    private static final String PROP_USER_AGENT = "http.agent";
    private final Function1<String, String> systemPropertySupplier;

    public StripeClientUserAgentHeaderFactory() {
        this((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    public StripeClientUserAgentHeaderFactory(Function1<? super String, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "systemPropertySupplier");
        this.systemPropertySupplier = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StripeClientUserAgentHeaderFactory(Function1<String, String> function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DEFAULT_SYSTEM_PROPERTY_SUPPLIER : function1);
    }

    public static /* synthetic */ Map create$default(StripeClientUserAgentHeaderFactory stripeClientUserAgentHeaderFactory, AppInfo appInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            appInfo = null;
        }
        return stripeClientUserAgentHeaderFactory.create(appInfo);
    }

    public final Map<String, String> create(AppInfo appInfo) {
        return MapsKt.mapOf(TuplesKt.to(HEADER_STRIPE_CLIENT_USER_AGENT, createHeaderValue(appInfo).toString()));
    }

    public static /* synthetic */ JSONObject createHeaderValue$default(StripeClientUserAgentHeaderFactory stripeClientUserAgentHeaderFactory, AppInfo appInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            appInfo = null;
        }
        return stripeClientUserAgentHeaderFactory.createHeaderValue(appInfo);
    }

    public final JSONObject createHeaderValue(AppInfo appInfo) {
        Map<String, Map<String, String>> map;
        Map mapOf = MapsKt.mapOf(TuplesKt.to("os.name", "android"), TuplesKt.to("os.version", String.valueOf(Build.VERSION.SDK_INT)), TuplesKt.to("bindings.version", "20.1.0"), TuplesKt.to("lang", "Java"), TuplesKt.to("publisher", "Stripe"), TuplesKt.to(PROP_USER_AGENT, this.systemPropertySupplier.invoke(PROP_USER_AGENT)));
        if (appInfo == null) {
            map = null;
        } else {
            map = appInfo.createClientHeaders$stripe_core_release();
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return new JSONObject(MapsKt.plus(mapOf, (Map) map));
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/core/networking/StripeClientUserAgentHeaderFactory$Companion;", "", "()V", "DEFAULT_SYSTEM_PROPERTY_SUPPLIER", "Lkotlin/Function1;", "", "HEADER_STRIPE_CLIENT_USER_AGENT", "PROP_USER_AGENT", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeClientUserAgentHeaderFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
