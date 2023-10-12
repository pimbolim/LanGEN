package com.stripe.android.networking;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.facebook.react.uimanager.ViewProps;
import com.stripe.android.core.networking.AnalyticsEvent;
import com.stripe.android.core.networking.AnalyticsRequest;
import com.stripe.android.core.networking.AnalyticsRequestFactory;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.Token;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 =2\u00020\u0001:\u0002=>B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0002\u0010\u000bB/\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u0012\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\rBA\b\u0001\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\u0013JH\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u00172\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001f\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b$J%\u0010%\u001a\u00020 2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u001a\u001a\u00020\u0005H\u0000¢\u0006\u0002\b&J\u001b\u0010'\u001a\u00020 2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0000¢\u0006\u0002\b(J\u001b\u0010)\u001a\u00020 2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0000¢\u0006\u0002\b*J\u001b\u0010+\u001a\u00020 2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0000¢\u0006\u0002\b,J\u0019\u0010-\u001a\u00020 2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b/J%\u00100\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u0001012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0000¢\u0006\u0002\b2JI\u00103\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\b4J\u0016\u00103\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005J\u0017\u00106\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b7J%\u00108\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00052\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0000¢\u0006\u0002\b9J#\u0010:\u001a\u00020 2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b;J,\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006?"}, d2 = {"Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "Lcom/stripe/android/core/networking/AnalyticsRequestFactory;", "context", "Landroid/content/Context;", "publishableKey", "", "defaultProductUsageTokens", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Set;)V", "publishableKeyProvider", "Ljavax/inject/Provider;", "(Landroid/content/Context;Ljavax/inject/Provider;)V", "Lkotlin/Function0;", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Ljava/util/Set;)V", "packageManager", "Landroid/content/pm/PackageManager;", "packageInfo", "Landroid/content/pm/PackageInfo;", "packageName", "(Landroid/content/pm/PackageManager;Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljavax/inject/Provider;Ljava/util/Set;)V", "getDefaultProductUsageTokens$payments_core_release", "()Ljava/util/Set;", "additionalParams", "", "", "productUsageTokens", "sourceType", "tokenType", "Lcom/stripe/android/model/Token$Type;", "threeDS2UiType", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory$ThreeDS2UiType;", "create3ds2Challenge", "Lcom/stripe/android/core/networking/AnalyticsRequest;", "event", "Lcom/stripe/android/networking/PaymentAnalyticsEvent;", "uiTypeCode", "create3ds2Challenge$payments_core_release", "createAddSource", "createAddSource$payments_core_release", "createAttachPaymentMethod", "createAttachPaymentMethod$payments_core_release", "createDeleteSource", "createDeleteSource$payments_core_release", "createDetachPaymentMethod", "createDetachPaymentMethod$payments_core_release", "createPaymentIntentConfirmation", "paymentMethodType", "createPaymentIntentConfirmation$payments_core_release", "createPaymentMethodCreation", "Lcom/stripe/android/model/PaymentMethod$Type;", "createPaymentMethodCreation$payments_core_release", "createRequest", "createRequest$payments_core_release", "deviceId", "createSetupIntentConfirmation", "createSetupIntentConfirmation$payments_core_release", "createSourceCreation", "createSourceCreation$payments_core_release", "createTokenCreation", "createTokenCreation$payments_core_release", "createTokenTypeParam", "Companion", "ThreeDS2UiType", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAnalyticsRequestFactory.kt */
public final class PaymentAnalyticsRequestFactory extends AnalyticsRequestFactory {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FIELD_3DS2_UI_TYPE = "3ds2_ui_type";
    public static final String FIELD_DEVICE_ID = "device_id";
    public static final String FIELD_PRODUCT_USAGE = "product_usage";
    public static final String FIELD_SOURCE_TYPE = "source_type";
    public static final String FIELD_TOKEN_TYPE = "token_type";
    private final Set<String> defaultProductUsageTokens;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentAnalyticsRequestFactory(PackageManager packageManager, PackageInfo packageInfo, String str, Provider provider, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(packageManager, packageInfo, str, (Provider<String>) provider, (Set<String>) (i & 16) != 0 ? SetsKt.emptySet() : set);
    }

    public final Set<String> getDefaultProductUsageTokens$payments_core_release() {
        return this.defaultProductUsageTokens;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentAnalyticsRequestFactory(PackageManager packageManager, PackageInfo packageInfo, String str, Provider<String> provider, Set<String> set) {
        super(packageManager, packageInfo, str, provider, (Set) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "packageName");
        Intrinsics.checkNotNullParameter(provider, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(set, "defaultProductUsageTokens");
        this.defaultProductUsageTokens = set;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentAnalyticsRequestFactory(Context context, String str, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (Set<String>) (i & 4) != 0 ? SetsKt.emptySet() : set);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PaymentAnalyticsRequestFactory(Context context, final String str, Set<String> set) {
        this(context, (Function0<String>) new Function0<String>() {
            public final String invoke() {
                return str;
            }
        }, set);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        Intrinsics.checkNotNullParameter(set, "defaultProductUsageTokens");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentAnalyticsRequestFactory(android.content.Context r8, javax.inject.Provider<java.lang.String> r9) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "publishableKeyProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            android.content.Context r0 = r8.getApplicationContext()
            android.content.pm.PackageManager r2 = r0.getPackageManager()
            com.stripe.android.utils.ContextUtils r0 = com.stripe.android.utils.ContextUtils.INSTANCE
            android.content.Context r1 = r8.getApplicationContext()
            java.lang.String r3 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            android.content.pm.PackageInfo r3 = r0.getPackageInfo$payments_core_release(r1)
            android.content.Context r8 = r8.getApplicationContext()
            java.lang.String r8 = r8.getPackageName()
            if (r8 != 0) goto L_0x002d
            java.lang.String r8 = ""
        L_0x002d:
            r4 = r8
            java.util.Set r6 = kotlin.collections.SetsKt.emptySet()
            r1 = r7
            r5 = r9
            r1.<init>((android.content.pm.PackageManager) r2, (android.content.pm.PackageInfo) r3, (java.lang.String) r4, (javax.inject.Provider<java.lang.String>) r5, (java.util.Set<java.lang.String>) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.PaymentAnalyticsRequestFactory.<init>(android.content.Context, javax.inject.Provider):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentAnalyticsRequestFactory(android.content.Context r8, @javax.inject.Named("publishableKey") kotlin.jvm.functions.Function0<java.lang.String> r9, @javax.inject.Named("productUsage") java.util.Set<java.lang.String> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "publishableKeyProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "defaultProductUsageTokens"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.content.Context r0 = r8.getApplicationContext()
            android.content.pm.PackageManager r2 = r0.getPackageManager()
            com.stripe.android.utils.ContextUtils r0 = com.stripe.android.utils.ContextUtils.INSTANCE
            android.content.Context r1 = r8.getApplicationContext()
            java.lang.String r3 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            android.content.pm.PackageInfo r3 = r0.getPackageInfo$payments_core_release(r1)
            android.content.Context r8 = r8.getApplicationContext()
            java.lang.String r8 = r8.getPackageName()
            if (r8 != 0) goto L_0x0032
            java.lang.String r8 = ""
        L_0x0032:
            r4 = r8
            com.stripe.android.networking.-$$Lambda$PaymentAnalyticsRequestFactory$YZrCRPS9po1_GGRr0b4Nkp3_TMA r5 = new com.stripe.android.networking.-$$Lambda$PaymentAnalyticsRequestFactory$YZrCRPS9po1_GGRr0b4Nkp3_TMA
            r5.<init>(r9)
            r1 = r7
            r6 = r10
            r1.<init>((android.content.pm.PackageManager) r2, (android.content.pm.PackageInfo) r3, (java.lang.String) r4, (javax.inject.Provider<java.lang.String>) r5, (java.util.Set<java.lang.String>) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.PaymentAnalyticsRequestFactory.<init>(android.content.Context, kotlin.jvm.functions.Function0, java.util.Set):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final String m4364_init_$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        return (String) function0.invoke();
    }

    public final /* synthetic */ AnalyticsRequest create3ds2Challenge$payments_core_release(PaymentAnalyticsEvent paymentAnalyticsEvent, String str) {
        Intrinsics.checkNotNullParameter(paymentAnalyticsEvent, "event");
        return createRequest$payments_core_release$default(this, paymentAnalyticsEvent, (Set) null, (String) null, (Token.Type) null, ThreeDS2UiType.Companion.fromUiTypeCode(str), 14, (Object) null);
    }

    public final /* synthetic */ AnalyticsRequest createTokenCreation$payments_core_release(Set set, Token.Type type) {
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        Intrinsics.checkNotNullParameter(type, "tokenType");
        return createRequest$payments_core_release$default(this, PaymentAnalyticsEvent.TokenCreate, set, (String) null, type, (ThreeDS2UiType) null, 20, (Object) null);
    }

    public final /* synthetic */ AnalyticsRequest createPaymentMethodCreation$payments_core_release(PaymentMethod.Type type, Set set) {
        String str;
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        PaymentAnalyticsEvent paymentAnalyticsEvent = PaymentAnalyticsEvent.PaymentMethodCreate;
        if (type == null) {
            str = null;
        } else {
            str = type.code;
        }
        return createRequest$payments_core_release$default(this, paymentAnalyticsEvent, set, str, (Token.Type) null, (ThreeDS2UiType) null, 24, (Object) null);
    }

    public static /* synthetic */ AnalyticsRequest createSourceCreation$payments_core_release$default(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, String str, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        return paymentAnalyticsRequestFactory.createSourceCreation$payments_core_release(str, set);
    }

    public final /* synthetic */ AnalyticsRequest createSourceCreation$payments_core_release(String str, Set set) {
        Intrinsics.checkNotNullParameter(str, "sourceType");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        return createRequest$payments_core_release$default(this, PaymentAnalyticsEvent.SourceCreate, set, str, (Token.Type) null, (ThreeDS2UiType) null, 24, (Object) null);
    }

    public static /* synthetic */ AnalyticsRequest createAddSource$payments_core_release$default(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, Set set, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            set = SetsKt.emptySet();
        }
        return paymentAnalyticsRequestFactory.createAddSource$payments_core_release(set, str);
    }

    public final /* synthetic */ AnalyticsRequest createAddSource$payments_core_release(Set set, String str) {
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        Intrinsics.checkNotNullParameter(str, "sourceType");
        return createRequest$payments_core_release$default(this, PaymentAnalyticsEvent.CustomerAddSource, set, str, (Token.Type) null, (ThreeDS2UiType) null, 24, (Object) null);
    }

    public final /* synthetic */ AnalyticsRequest createDeleteSource$payments_core_release(Set set) {
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        return createRequest$payments_core_release$default(this, PaymentAnalyticsEvent.CustomerDeleteSource, set, (String) null, (Token.Type) null, (ThreeDS2UiType) null, 28, (Object) null);
    }

    public final /* synthetic */ AnalyticsRequest createAttachPaymentMethod$payments_core_release(Set set) {
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        return createRequest$payments_core_release$default(this, PaymentAnalyticsEvent.CustomerAttachPaymentMethod, set, (String) null, (Token.Type) null, (ThreeDS2UiType) null, 28, (Object) null);
    }

    public final /* synthetic */ AnalyticsRequest createDetachPaymentMethod$payments_core_release(Set set) {
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        return createRequest$payments_core_release$default(this, PaymentAnalyticsEvent.CustomerDetachPaymentMethod, set, (String) null, (Token.Type) null, (ThreeDS2UiType) null, 28, (Object) null);
    }

    public static /* synthetic */ AnalyticsRequest createPaymentIntentConfirmation$payments_core_release$default(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return paymentAnalyticsRequestFactory.createPaymentIntentConfirmation$payments_core_release(str);
    }

    public final /* synthetic */ AnalyticsRequest createPaymentIntentConfirmation$payments_core_release(String str) {
        return createRequest$payments_core_release$default(this, PaymentAnalyticsEvent.PaymentIntentConfirm, (Set) null, str, (Token.Type) null, (ThreeDS2UiType) null, 26, (Object) null);
    }

    public final /* synthetic */ AnalyticsRequest createSetupIntentConfirmation$payments_core_release(String str) {
        return createRequest$payments_core_release$default(this, PaymentAnalyticsEvent.SetupIntentConfirm, (Set) null, str, (Token.Type) null, (ThreeDS2UiType) null, 26, (Object) null);
    }

    public final /* synthetic */ AnalyticsRequest createRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(str2, "deviceId");
        return createRequest(str, (Map<String, ? extends Object>) MapsKt.mapOf(TuplesKt.to(FIELD_DEVICE_ID, str2)));
    }

    public static /* synthetic */ AnalyticsRequest createRequest$payments_core_release$default(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, PaymentAnalyticsEvent paymentAnalyticsEvent, Set set, String str, Token.Type type, ThreeDS2UiType threeDS2UiType, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        return paymentAnalyticsRequestFactory.createRequest$payments_core_release(paymentAnalyticsEvent, set, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : type, (i & 16) != 0 ? null : threeDS2UiType);
    }

    public final /* synthetic */ AnalyticsRequest createRequest$payments_core_release(PaymentAnalyticsEvent paymentAnalyticsEvent, Set set, String str, Token.Type type, ThreeDS2UiType threeDS2UiType) {
        Intrinsics.checkNotNullParameter(paymentAnalyticsEvent, "event");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        return createRequest((AnalyticsEvent) paymentAnalyticsEvent, (Map<String, ? extends Object>) additionalParams(set, str, type, threeDS2UiType));
    }

    static /* synthetic */ Map additionalParams$default(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, Set set, String str, Token.Type type, ThreeDS2UiType threeDS2UiType, int i, Object obj) {
        if ((i & 1) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            type = null;
        }
        if ((i & 8) != 0) {
            threeDS2UiType = null;
        }
        return paymentAnalyticsRequestFactory.additionalParams(set, str, type, threeDS2UiType);
    }

    private final Map<String, Object> additionalParams(Set<String> set, String str, Token.Type type, ThreeDS2UiType threeDS2UiType) {
        Map map;
        Set<T> plus = SetsKt.plus(this.defaultProductUsageTokens, set);
        Map map2 = null;
        if (plus.isEmpty()) {
            plus = null;
        }
        Map mapOf = plus == null ? null : MapsKt.mapOf(TuplesKt.to(FIELD_PRODUCT_USAGE, CollectionsKt.toList(plus)));
        if (mapOf == null) {
            mapOf = MapsKt.emptyMap();
        }
        if (str == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to(FIELD_SOURCE_TYPE, str));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        Map<String, String> plus2 = MapsKt.plus(MapsKt.plus(mapOf, map), (Map) createTokenTypeParam(str, type));
        if (threeDS2UiType != null) {
            map2 = MapsKt.mapOf(TuplesKt.to(FIELD_3DS2_UI_TYPE, threeDS2UiType.toString()));
        }
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        return MapsKt.plus(plus2, (Map<String, String>) map2);
    }

    static /* synthetic */ Map createTokenTypeParam$default(PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory, String str, Token.Type type, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            type = null;
        }
        return paymentAnalyticsRequestFactory.createTokenTypeParam(str, type);
    }

    private final Map<String, String> createTokenTypeParam(String str, Token.Type type) {
        Map<String, String> map = null;
        String code = type != null ? type.getCode() : str == null ? "unknown" : null;
        if (code != null) {
            map = MapsKt.mapOf(TuplesKt.to(FIELD_TOKEN_TYPE, code));
        }
        return map == null ? MapsKt.emptyMap() : map;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory$ThreeDS2UiType;", "", "code", "", "typeName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "toString", "None", "Text", "SingleSelect", "MultiSelect", "Oob", "Html", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAnalyticsRequestFactory.kt */
    public enum ThreeDS2UiType {
        None((String) null, ViewProps.NONE),
        Text("01", "text"),
        SingleSelect("02", "single_select"),
        MultiSelect("03", "multi_select"),
        Oob("04", "oob"),
        Html("05", "html");
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public final String code;
        private final String typeName;

        private ThreeDS2UiType(String str, String str2) {
            this.code = str;
            this.typeName = str2;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            return this.typeName;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory$ThreeDS2UiType$Companion;", "", "()V", "fromUiTypeCode", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory$ThreeDS2UiType;", "uiTypeCode", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentAnalyticsRequestFactory.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ThreeDS2UiType fromUiTypeCode(String str) {
                ThreeDS2UiType threeDS2UiType;
                ThreeDS2UiType[] values = ThreeDS2UiType.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        threeDS2UiType = null;
                        break;
                    }
                    threeDS2UiType = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) threeDS2UiType.code, (Object) str)) {
                        break;
                    }
                }
                return threeDS2UiType == null ? ThreeDS2UiType.None : threeDS2UiType;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory$Companion;", "", "()V", "FIELD_3DS2_UI_TYPE", "", "FIELD_DEVICE_ID", "FIELD_PRODUCT_USAGE", "FIELD_SOURCE_TYPE", "FIELD_TOKEN_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAnalyticsRequestFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
