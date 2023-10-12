package com.stripe.android.stripe3ds2.service;

import android.content.Context;
import com.stripe.android.stripe3ds2.exceptions.InvalidInputException;
import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import com.stripe.android.stripe3ds2.init.DefaultSecurityChecker;
import com.stripe.android.stripe3ds2.init.HardwareIdSupplier;
import com.stripe.android.stripe3ds2.init.Warning;
import com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.security.PublicKeyFactory;
import com.stripe.android.stripe3ds2.security.StripeEphemeralKeyPairGenerator;
import com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry;
import com.stripe.android.stripe3ds2.transaction.SdkTransactionId;
import com.stripe.android.stripe3ds2.transaction.Transaction;
import com.stripe.android.stripe3ds2.transaction.TransactionFactory;
import com.stripe.android.stripe3ds2.utils.ImageCache;
import com.stripe.android.stripe3ds2.views.Brand;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 82\u00020\u0001:\u00018B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bB/\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eB/\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011BO\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001aB=\b\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\u0010\"J\b\u0010%\u001a\u00020&H\u0016JZ\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\n2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000 2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\n2\u0006\u00104\u001a\u000205H\u0016JR\u0010'\u001a\u00020(2\u0006\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\n2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000 2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\n2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\nH\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00069"}, d2 = {"Lcom/stripe/android/stripe3ds2/service/StripeThreeDs2ServiceImpl;", "Lcom/stripe/android/stripe3ds2/service/StripeThreeDs2Service;", "context", "Landroid/content/Context;", "enableLogging", "", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;ZLkotlin/coroutines/CoroutineContext;)V", "sdkReferenceNumber", "", "(Landroid/content/Context;Ljava/lang/String;ZLkotlin/coroutines/CoroutineContext;)V", "imageCache", "Lcom/stripe/android/stripe3ds2/utils/ImageCache;", "(Landroid/content/Context;Lcom/stripe/android/stripe3ds2/utils/ImageCache;Ljava/lang/String;ZLkotlin/coroutines/CoroutineContext;)V", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "(Landroid/content/Context;Lcom/stripe/android/stripe3ds2/utils/ImageCache;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lkotlin/coroutines/CoroutineContext;)V", "ephemeralKeyPairGenerator", "Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;", "hardwareIdSupplier", "Lcom/stripe/android/stripe3ds2/init/HardwareIdSupplier;", "securityChecker", "Lcom/stripe/android/stripe3ds2/init/SecurityChecker;", "messageVersionRegistry", "Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;", "(Landroid/content/Context;Lcom/stripe/android/stripe3ds2/utils/ImageCache;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;Lcom/stripe/android/stripe3ds2/init/HardwareIdSupplier;Lcom/stripe/android/stripe3ds2/init/SecurityChecker;Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;Lkotlin/coroutines/CoroutineContext;)V", "transactionFactory", "Lcom/stripe/android/stripe3ds2/transaction/TransactionFactory;", "publicKeyFactory", "Lcom/stripe/android/stripe3ds2/security/PublicKeyFactory;", "warnings", "", "Lcom/stripe/android/stripe3ds2/init/Warning;", "(Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;Lcom/stripe/android/stripe3ds2/utils/ImageCache;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lcom/stripe/android/stripe3ds2/transaction/TransactionFactory;Lcom/stripe/android/stripe3ds2/security/PublicKeyFactory;Ljava/util/List;)V", "getWarnings", "()Ljava/util/List;", "cleanup", "", "createTransaction", "Lcom/stripe/android/stripe3ds2/transaction/Transaction;", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "directoryServerID", "messageVersion", "isLiveMode", "directoryServerName", "rootCerts", "Ljava/security/cert/X509Certificate;", "dsPublicKey", "Ljava/security/PublicKey;", "keyId", "uiCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;", "getPublicKey", "directoryServerId", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeThreeDs2ServiceImpl.kt */
public final class StripeThreeDs2ServiceImpl implements StripeThreeDs2Service {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String STRIPE_SDK_REFERENCE_NUMBER = "3DS_LOA_SDK_STIN_020100_00142";
    private final ErrorReporter errorReporter;
    private final ImageCache imageCache;
    private final MessageVersionRegistry messageVersionRegistry;
    private final PublicKeyFactory publicKeyFactory;
    private final TransactionFactory transactionFactory;
    private final List<Warning> warnings;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeThreeDs2ServiceImpl(Context context, CoroutineContext coroutineContext) {
        this(context, false, coroutineContext, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
    }

    public StripeThreeDs2ServiceImpl(MessageVersionRegistry messageVersionRegistry2, ImageCache imageCache2, ErrorReporter errorReporter2, TransactionFactory transactionFactory2, PublicKeyFactory publicKeyFactory2, List<Warning> list) {
        Intrinsics.checkNotNullParameter(messageVersionRegistry2, "messageVersionRegistry");
        Intrinsics.checkNotNullParameter(imageCache2, "imageCache");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(transactionFactory2, "transactionFactory");
        Intrinsics.checkNotNullParameter(publicKeyFactory2, "publicKeyFactory");
        Intrinsics.checkNotNullParameter(list, "warnings");
        this.messageVersionRegistry = messageVersionRegistry2;
        this.imageCache = imageCache2;
        this.errorReporter = errorReporter2;
        this.transactionFactory = transactionFactory2;
        this.publicKeyFactory = publicKeyFactory2;
        this.warnings = list;
    }

    public List<Warning> getWarnings() {
        return this.warnings;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StripeThreeDs2ServiceImpl(Context context, boolean z, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z, coroutineContext);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeThreeDs2ServiceImpl(Context context, boolean z, CoroutineContext coroutineContext) {
        this(context, STRIPE_SDK_REFERENCE_NUMBER, z, coroutineContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StripeThreeDs2ServiceImpl(Context context, String str, boolean z, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? false : z, coroutineContext);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StripeThreeDs2ServiceImpl(Context context, String str, boolean z, CoroutineContext coroutineContext) {
        this(context, (ImageCache) ImageCache.Default.INSTANCE, str, z, coroutineContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "sdkReferenceNumber");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private StripeThreeDs2ServiceImpl(android.content.Context r19, com.stripe.android.stripe3ds2.utils.ImageCache r20, java.lang.String r21, boolean r22, kotlin.coroutines.CoroutineContext r23) {
        /*
            r18 = this;
            com.stripe.android.stripe3ds2.observability.DefaultErrorReporter r11 = new com.stripe.android.stripe3ds2.observability.DefaultErrorReporter
            android.content.Context r1 = r19.getApplicationContext()
            java.lang.String r0 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            com.stripe.android.stripe3ds2.transaction.Logger$Companion r0 = com.stripe.android.stripe3ds2.transaction.Logger.Companion
            r2 = r22
            com.stripe.android.stripe3ds2.transaction.Logger r4 = r0.get(r2)
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 246(0xf6, float:3.45E-43)
            r10 = 0
            r0 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r16 = r11
            com.stripe.android.stripe3ds2.observability.ErrorReporter r16 = (com.stripe.android.stripe3ds2.observability.ErrorReporter) r16
            r12 = r18
            r13 = r19
            r14 = r20
            r15 = r21
            r17 = r23
            r12.<init>((android.content.Context) r13, (com.stripe.android.stripe3ds2.utils.ImageCache) r14, (java.lang.String) r15, (com.stripe.android.stripe3ds2.observability.ErrorReporter) r16, (kotlin.coroutines.CoroutineContext) r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.service.StripeThreeDs2ServiceImpl.<init>(android.content.Context, com.stripe.android.stripe3ds2.utils.ImageCache, java.lang.String, boolean, kotlin.coroutines.CoroutineContext):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private StripeThreeDs2ServiceImpl(Context context, ImageCache imageCache2, String str, ErrorReporter errorReporter2, CoroutineContext coroutineContext) {
        this(context, imageCache2, str, errorReporter2, new StripeEphemeralKeyPairGenerator(errorReporter2), new HardwareIdSupplier(context), new DefaultSecurityChecker((List) null, 1, (DefaultConstructorMarker) null), new MessageVersionRegistry(), coroutineContext);
        Context context2 = context;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private StripeThreeDs2ServiceImpl(android.content.Context r14, com.stripe.android.stripe3ds2.utils.ImageCache r15, java.lang.String r16, com.stripe.android.stripe3ds2.observability.ErrorReporter r17, com.stripe.android.stripe3ds2.security.EphemeralKeyPairGenerator r18, com.stripe.android.stripe3ds2.init.HardwareIdSupplier r19, com.stripe.android.stripe3ds2.init.SecurityChecker r20, com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry r21, kotlin.coroutines.CoroutineContext r22) {
        /*
            r13 = this;
            r0 = r14
            com.stripe.android.stripe3ds2.transaction.DefaultTransactionFactory r1 = new com.stripe.android.stripe3ds2.transaction.DefaultTransactionFactory
            com.stripe.android.stripe3ds2.transaction.DefaultAuthenticationRequestParametersFactory r12 = new com.stripe.android.stripe3ds2.transaction.DefaultAuthenticationRequestParametersFactory
            com.stripe.android.stripe3ds2.init.DeviceDataFactoryImpl r2 = new com.stripe.android.stripe3ds2.init.DeviceDataFactoryImpl
            android.content.Context r3 = r14.getApplicationContext()
            java.lang.String r4 = "context.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r4 = r19
            com.stripe.android.stripe3ds2.utils.Supplier r4 = (com.stripe.android.stripe3ds2.utils.Supplier) r4
            r2.<init>(r3, r4)
            r3 = r2
            com.stripe.android.stripe3ds2.init.DeviceDataFactory r3 = (com.stripe.android.stripe3ds2.init.DeviceDataFactory) r3
            com.stripe.android.stripe3ds2.init.DeviceParamNotAvailableFactoryImpl r2 = new com.stripe.android.stripe3ds2.init.DeviceParamNotAvailableFactoryImpl
            r2.<init>(r4)
            r4 = r2
            com.stripe.android.stripe3ds2.init.DeviceParamNotAvailableFactory r4 = (com.stripe.android.stripe3ds2.init.DeviceParamNotAvailableFactory) r4
            com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository r2 = new com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository
            r11 = r22
            r2.<init>(r14, r11)
            r7 = r2
            com.stripe.android.stripe3ds2.init.AppInfoRepository r7 = (com.stripe.android.stripe3ds2.init.AppInfoRepository) r7
            r2 = r12
            r5 = r20
            r6 = r18
            r8 = r21
            r9 = r16
            r10 = r17
            r2.<init>((com.stripe.android.stripe3ds2.init.DeviceDataFactory) r3, (com.stripe.android.stripe3ds2.init.DeviceParamNotAvailableFactory) r4, (com.stripe.android.stripe3ds2.init.SecurityChecker) r5, (com.stripe.android.stripe3ds2.security.EphemeralKeyPairGenerator) r6, (com.stripe.android.stripe3ds2.init.AppInfoRepository) r7, (com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry) r8, (java.lang.String) r9, (com.stripe.android.stripe3ds2.observability.ErrorReporter) r10, (kotlin.coroutines.CoroutineContext) r11)
            com.stripe.android.stripe3ds2.transaction.AuthenticationRequestParametersFactory r12 = (com.stripe.android.stripe3ds2.transaction.AuthenticationRequestParametersFactory) r12
            r2 = r16
            r3 = r18
            r1.<init>(r12, r3, r2)
            java.util.List r8 = r20.getWarnings()
            com.stripe.android.stripe3ds2.security.PublicKeyFactory r7 = new com.stripe.android.stripe3ds2.security.PublicKeyFactory
            r5 = r17
            r7.<init>(r14, r5)
            r6 = r1
            com.stripe.android.stripe3ds2.transaction.TransactionFactory r6 = (com.stripe.android.stripe3ds2.transaction.TransactionFactory) r6
            r2 = r13
            r3 = r21
            r4 = r15
            r2.<init>((com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry) r3, (com.stripe.android.stripe3ds2.utils.ImageCache) r4, (com.stripe.android.stripe3ds2.observability.ErrorReporter) r5, (com.stripe.android.stripe3ds2.transaction.TransactionFactory) r6, (com.stripe.android.stripe3ds2.security.PublicKeyFactory) r7, (java.util.List<com.stripe.android.stripe3ds2.init.Warning>) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.service.StripeThreeDs2ServiceImpl.<init>(android.content.Context, com.stripe.android.stripe3ds2.utils.ImageCache, java.lang.String, com.stripe.android.stripe3ds2.observability.ErrorReporter, com.stripe.android.stripe3ds2.security.EphemeralKeyPairGenerator, com.stripe.android.stripe3ds2.init.HardwareIdSupplier, com.stripe.android.stripe3ds2.init.SecurityChecker, com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry, kotlin.coroutines.CoroutineContext):void");
    }

    public Transaction createTransaction(SdkTransactionId sdkTransactionId, String str, String str2, boolean z, String str3, List<? extends X509Certificate> list, PublicKey publicKey, String str4, StripeUiCustomization stripeUiCustomization) throws InvalidInputException, SDKRuntimeException {
        Intrinsics.checkNotNullParameter(sdkTransactionId, "sdkTransactionId");
        String str5 = str;
        Intrinsics.checkNotNullParameter(str, "directoryServerID");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str3, "directoryServerName");
        List<? extends X509Certificate> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "rootCerts");
        PublicKey publicKey2 = publicKey;
        Intrinsics.checkNotNullParameter(publicKey2, "dsPublicKey");
        Intrinsics.checkNotNullParameter(stripeUiCustomization, "uiCustomization");
        return createTransaction(str5, str2, z, str6, list2, publicKey2, str4, sdkTransactionId);
    }

    private final Transaction createTransaction(String str, String str2, boolean z, String str3, List<? extends X509Certificate> list, PublicKey publicKey, String str4, SdkTransactionId sdkTransactionId) {
        String str5 = str2;
        if (!this.messageVersionRegistry.isSupported(str2)) {
            if (str5 == null) {
                str5 = "";
            }
            throw new InvalidInputException(Intrinsics.stringPlus("Message version is unsupported: ", str5), (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
        return this.transactionFactory.create(str, list, publicKey, str4, sdkTransactionId, z, Brand.Companion.lookup$3ds2sdk_release(str3, this.errorReporter));
    }

    public void cleanup() {
        this.imageCache.clear();
    }

    public PublicKey getPublicKey(String str) {
        Intrinsics.checkNotNullParameter(str, "directoryServerId");
        return this.publicKeyFactory.create(str);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/service/StripeThreeDs2ServiceImpl$Companion;", "", "()V", "STRIPE_SDK_REFERENCE_NUMBER", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeThreeDs2ServiceImpl.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
