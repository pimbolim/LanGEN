package com.stripe.android.stripe3ds2.transaction;

import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.KeyUse;
import com.stripe.android.stripe3ds2.init.AppInfoRepository;
import com.stripe.android.stripe3ds2.init.DeviceDataFactory;
import com.stripe.android.stripe3ds2.init.DeviceParamNotAvailableFactory;
import com.stripe.android.stripe3ds2.init.SecurityChecker;
import com.stripe.android.stripe3ds2.init.Warning;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.security.DirectoryServer;
import com.stripe.android.stripe3ds2.security.JweEncrypter;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(BO\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014BO\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0017J;\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u000f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0017\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u001d\u001a\u00020\u000fH\u0001¢\u0006\u0002\b'R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u000f8AX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/DefaultAuthenticationRequestParametersFactory;", "Lcom/stripe/android/stripe3ds2/transaction/AuthenticationRequestParametersFactory;", "deviceDataFactory", "Lcom/stripe/android/stripe3ds2/init/DeviceDataFactory;", "deviceParamNotAvailableFactory", "Lcom/stripe/android/stripe3ds2/init/DeviceParamNotAvailableFactory;", "securityChecker", "Lcom/stripe/android/stripe3ds2/init/SecurityChecker;", "ephemeralKeyPairGenerator", "Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;", "appInfoRepository", "Lcom/stripe/android/stripe3ds2/init/AppInfoRepository;", "messageVersionRegistry", "Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;", "sdkReferenceNumber", "", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/stripe3ds2/init/DeviceDataFactory;Lcom/stripe/android/stripe3ds2/init/DeviceParamNotAvailableFactory;Lcom/stripe/android/stripe3ds2/init/SecurityChecker;Lcom/stripe/android/stripe3ds2/security/EphemeralKeyPairGenerator;Lcom/stripe/android/stripe3ds2/init/AppInfoRepository;Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lkotlin/coroutines/CoroutineContext;)V", "jweEncrypter", "Lcom/stripe/android/stripe3ds2/security/JweEncrypter;", "(Lcom/stripe/android/stripe3ds2/init/DeviceDataFactory;Lcom/stripe/android/stripe3ds2/init/DeviceParamNotAvailableFactory;Lcom/stripe/android/stripe3ds2/init/SecurityChecker;Lcom/stripe/android/stripe3ds2/init/AppInfoRepository;Lcom/stripe/android/stripe3ds2/security/JweEncrypter;Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lkotlin/coroutines/CoroutineContext;)V", "deviceDataJson", "getDeviceDataJson$3ds2sdk_release", "()Ljava/lang/String;", "create", "Lcom/stripe/android/stripe3ds2/transaction/AuthenticationRequestParameters;", "directoryServerId", "directoryServerPublicKey", "Ljava/security/PublicKey;", "keyId", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "sdkPublicKey", "(Ljava/lang/String;Ljava/security/PublicKey;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Ljava/security/PublicKey;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getKeyUse", "Lcom/nimbusds/jose/jwk/KeyUse;", "getKeyUse$3ds2sdk_release", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultAuthenticationRequestParametersFactory.kt */
public final class DefaultAuthenticationRequestParametersFactory implements AuthenticationRequestParametersFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DATA_VERSION = "1.1";
    public static final String KEY_DATA_VERSION = "DV";
    public static final String KEY_DEVICE_DATA = "DD";
    public static final String KEY_DEVICE_PARAM_NOT_AVAILABLE = "DPNA";
    public static final String KEY_SECURITY_WARNINGS = "SW";
    /* access modifiers changed from: private */
    public final AppInfoRepository appInfoRepository;
    private final DeviceDataFactory deviceDataFactory;
    private final DeviceParamNotAvailableFactory deviceParamNotAvailableFactory;
    /* access modifiers changed from: private */
    public final ErrorReporter errorReporter;
    /* access modifiers changed from: private */
    public final JweEncrypter jweEncrypter;
    /* access modifiers changed from: private */
    public final MessageVersionRegistry messageVersionRegistry;
    /* access modifiers changed from: private */
    public final String sdkReferenceNumber;
    private final SecurityChecker securityChecker;
    private final CoroutineContext workContext;

    public DefaultAuthenticationRequestParametersFactory(DeviceDataFactory deviceDataFactory2, DeviceParamNotAvailableFactory deviceParamNotAvailableFactory2, SecurityChecker securityChecker2, AppInfoRepository appInfoRepository2, JweEncrypter jweEncrypter2, MessageVersionRegistry messageVersionRegistry2, String str, ErrorReporter errorReporter2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(deviceDataFactory2, "deviceDataFactory");
        Intrinsics.checkNotNullParameter(deviceParamNotAvailableFactory2, "deviceParamNotAvailableFactory");
        Intrinsics.checkNotNullParameter(securityChecker2, "securityChecker");
        Intrinsics.checkNotNullParameter(appInfoRepository2, "appInfoRepository");
        Intrinsics.checkNotNullParameter(jweEncrypter2, "jweEncrypter");
        Intrinsics.checkNotNullParameter(messageVersionRegistry2, "messageVersionRegistry");
        Intrinsics.checkNotNullParameter(str, "sdkReferenceNumber");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.deviceDataFactory = deviceDataFactory2;
        this.deviceParamNotAvailableFactory = deviceParamNotAvailableFactory2;
        this.securityChecker = securityChecker2;
        this.appInfoRepository = appInfoRepository2;
        this.jweEncrypter = jweEncrypter2;
        this.messageVersionRegistry = messageVersionRegistry2;
        this.sdkReferenceNumber = str;
        this.errorReporter = errorReporter2;
        this.workContext = coroutineContext;
    }

    public final String getDeviceDataJson$3ds2sdk_release() throws JSONException {
        JSONObject put = new JSONObject().put(KEY_DATA_VERSION, DATA_VERSION).put(KEY_DEVICE_DATA, new JSONObject(this.deviceDataFactory.create())).put(KEY_DEVICE_PARAM_NOT_AVAILABLE, new JSONObject(this.deviceParamNotAvailableFactory.create()));
        Iterable<Warning> warnings = this.securityChecker.getWarnings();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(warnings, 10));
        for (Warning id : warnings) {
            arrayList.add(id.getId());
        }
        String jSONObject = put.put(KEY_SECURITY_WARNINGS, new JSONArray((List) arrayList)).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n           …              .toString()");
        return jSONObject;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultAuthenticationRequestParametersFactory(com.stripe.android.stripe3ds2.init.DeviceDataFactory r12, com.stripe.android.stripe3ds2.init.DeviceParamNotAvailableFactory r13, com.stripe.android.stripe3ds2.init.SecurityChecker r14, com.stripe.android.stripe3ds2.security.EphemeralKeyPairGenerator r15, com.stripe.android.stripe3ds2.init.AppInfoRepository r16, com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry r17, java.lang.String r18, com.stripe.android.stripe3ds2.observability.ErrorReporter r19, kotlin.coroutines.CoroutineContext r20) {
        /*
            r11 = this;
            r0 = r15
            r8 = r19
            java.lang.String r1 = "deviceDataFactory"
            r2 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "deviceParamNotAvailableFactory"
            r3 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "securityChecker"
            r4 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "ephemeralKeyPairGenerator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "appInfoRepository"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            java.lang.String r1 = "messageVersionRegistry"
            r6 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "sdkReferenceNumber"
            r7 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "errorReporter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "workContext"
            r9 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            com.stripe.android.stripe3ds2.security.DefaultJweEncrypter r1 = new com.stripe.android.stripe3ds2.security.DefaultJweEncrypter
            r1.<init>(r15, r8)
            r10 = r1
            com.stripe.android.stripe3ds2.security.JweEncrypter r10 = (com.stripe.android.stripe3ds2.security.JweEncrypter) r10
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r16
            r5 = r10
            r0.<init>((com.stripe.android.stripe3ds2.init.DeviceDataFactory) r1, (com.stripe.android.stripe3ds2.init.DeviceParamNotAvailableFactory) r2, (com.stripe.android.stripe3ds2.init.SecurityChecker) r3, (com.stripe.android.stripe3ds2.init.AppInfoRepository) r4, (com.stripe.android.stripe3ds2.security.JweEncrypter) r5, (com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry) r6, (java.lang.String) r7, (com.stripe.android.stripe3ds2.observability.ErrorReporter) r8, (kotlin.coroutines.CoroutineContext) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transaction.DefaultAuthenticationRequestParametersFactory.<init>(com.stripe.android.stripe3ds2.init.DeviceDataFactory, com.stripe.android.stripe3ds2.init.DeviceParamNotAvailableFactory, com.stripe.android.stripe3ds2.init.SecurityChecker, com.stripe.android.stripe3ds2.security.EphemeralKeyPairGenerator, com.stripe.android.stripe3ds2.init.AppInfoRepository, com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry, java.lang.String, com.stripe.android.stripe3ds2.observability.ErrorReporter, kotlin.coroutines.CoroutineContext):void");
    }

    public Object create(String str, PublicKey publicKey, String str2, SdkTransactionId sdkTransactionId, PublicKey publicKey2, Continuation<? super AuthenticationRequestParameters> continuation) {
        return BuildersKt.withContext(this.workContext, new DefaultAuthenticationRequestParametersFactory$create$2(sdkTransactionId, this, publicKey2, str2, str, publicKey, (Continuation<? super DefaultAuthenticationRequestParametersFactory$create$2>) null), continuation);
    }

    public final KeyUse getKeyUse$3ds2sdk_release(String str) {
        DirectoryServer directoryServer;
        Intrinsics.checkNotNullParameter(str, "directoryServerId");
        DirectoryServer[] values = DirectoryServer.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                directoryServer = null;
                break;
            }
            directoryServer = values[i];
            i++;
            if (directoryServer.getIds().contains(str)) {
                break;
            }
        }
        if (directoryServer != null) {
            return directoryServer.getKeyUse();
        }
        return KeyUse.SIGNATURE;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/DefaultAuthenticationRequestParametersFactory$Companion;", "", "()V", "DATA_VERSION", "", "KEY_DATA_VERSION", "KEY_DEVICE_DATA", "KEY_DEVICE_PARAM_NOT_AVAILABLE", "KEY_SECURITY_WARNINGS", "createPublicJwk", "Lcom/nimbusds/jose/jwk/JWK;", "publicKey", "Ljava/security/PublicKey;", "keyId", "keyUse", "Lcom/nimbusds/jose/jwk/KeyUse;", "createPublicJwk$3ds2sdk_release", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultAuthenticationRequestParametersFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JWK createPublicJwk$3ds2sdk_release(PublicKey publicKey, String str, KeyUse keyUse) {
            Intrinsics.checkNotNullParameter(publicKey, "publicKey");
            ECKey.Builder keyUse2 = new ECKey.Builder(Curve.P_256, (ECPublicKey) publicKey).keyUse(keyUse);
            CharSequence charSequence = str;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                str = null;
            }
            ECKey publicJWK = keyUse2.keyID(str).build().toPublicJWK();
            Intrinsics.checkNotNullExpressionValue(publicJWK, "Builder(Curve.P_256, pub…           .toPublicJWK()");
            return publicJWK;
        }
    }
}
