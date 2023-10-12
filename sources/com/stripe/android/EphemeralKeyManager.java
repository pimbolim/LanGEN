package com.stripe.android;

import com.braintreepayments.api.internal.GraphQLConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.stripe.android.EphemeralOperation;
import com.stripe.android.core.ApiVersion;
import com.stripe.android.model.parsers.EphemeralKeyJsonParser;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 '2\u00020\u0001:\u0004&'()BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u0017\u0010\u001d\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\b\u001eJ\u001a\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u0011H\u0002J \u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0011H\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/stripe/android/EphemeralKeyManager;", "", "ephemeralKeyProvider", "Lcom/stripe/android/EphemeralKeyProvider;", "listener", "Lcom/stripe/android/EphemeralKeyManager$KeyManagerListener;", "operationIdFactory", "Lcom/stripe/android/OperationIdFactory;", "shouldPrefetchEphemeralKey", "", "timeSupplier", "Lkotlin/Function0;", "", "Lcom/stripe/android/TimeSupplier;", "timeBufferInSeconds", "(Lcom/stripe/android/EphemeralKeyProvider;Lcom/stripe/android/EphemeralKeyManager$KeyManagerListener;Lcom/stripe/android/OperationIdFactory;ZLkotlin/jvm/functions/Function0;J)V", "apiVersion", "", "ephemeralKey", "Lcom/stripe/android/EphemeralKey;", "getEphemeralKey$payments_core_release", "()Lcom/stripe/android/EphemeralKey;", "setEphemeralKey$payments_core_release", "(Lcom/stripe/android/EphemeralKey;)V", "retrieveEphemeralKey", "", "operation", "Lcom/stripe/android/EphemeralOperation;", "retrieveEphemeralKey$payments_core_release", "shouldRefreshKey", "shouldRefreshKey$payments_core_release", "updateKey", "key", "updateKeyError", "operationId", "errorCode", "", "errorMessage", "ClientKeyUpdateListener", "Companion", "Factory", "KeyManagerListener", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EphemeralKeyManager.kt */
public final class EphemeralKeyManager {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final long REFRESH_BUFFER_IN_SECONDS = 30;
    private final String apiVersion;
    private /* synthetic */ EphemeralKey ephemeralKey;
    private final EphemeralKeyProvider ephemeralKeyProvider;
    private final KeyManagerListener listener;
    private final long timeBufferInSeconds;
    private final Function0<Long> timeSupplier;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/EphemeralKeyManager$KeyManagerListener;", "", "onKeyError", "", "operationId", "", "errorCode", "", "errorMessage", "onKeyUpdate", "ephemeralKey", "Lcom/stripe/android/EphemeralKey;", "operation", "Lcom/stripe/android/EphemeralOperation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EphemeralKeyManager.kt */
    public interface KeyManagerListener {
        void onKeyError(String str, int i, String str2);

        void onKeyUpdate(EphemeralKey ephemeralKey, EphemeralOperation ephemeralOperation);
    }

    public EphemeralKeyManager(EphemeralKeyProvider ephemeralKeyProvider2, KeyManagerListener keyManagerListener, OperationIdFactory operationIdFactory, boolean z, Function0<Long> function0, long j) {
        Intrinsics.checkNotNullParameter(ephemeralKeyProvider2, "ephemeralKeyProvider");
        Intrinsics.checkNotNullParameter(keyManagerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(operationIdFactory, "operationIdFactory");
        Intrinsics.checkNotNullParameter(function0, "timeSupplier");
        this.ephemeralKeyProvider = ephemeralKeyProvider2;
        this.listener = keyManagerListener;
        this.timeSupplier = function0;
        this.timeBufferInSeconds = j;
        this.apiVersion = ApiVersion.Companion.get().getCode();
        if (z) {
            retrieveEphemeralKey$payments_core_release(new EphemeralOperation.RetrieveKey(operationIdFactory.create(), SetsKt.emptySet()));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EphemeralKeyManager(com.stripe.android.EphemeralKeyProvider r10, com.stripe.android.EphemeralKeyManager.KeyManagerListener r11, com.stripe.android.OperationIdFactory r12, boolean r13, kotlin.jvm.functions.Function0 r14, long r15, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 4
            if (r0 == 0) goto L_0x000d
            com.stripe.android.StripeOperationIdFactory r0 = new com.stripe.android.StripeOperationIdFactory
            r0.<init>()
            com.stripe.android.OperationIdFactory r0 = (com.stripe.android.OperationIdFactory) r0
            r4 = r0
            goto L_0x000e
        L_0x000d:
            r4 = r12
        L_0x000e:
            r0 = r17 & 8
            if (r0 == 0) goto L_0x0015
            r0 = 1
            r5 = 1
            goto L_0x0016
        L_0x0015:
            r5 = r13
        L_0x0016:
            r0 = r17 & 16
            if (r0 == 0) goto L_0x0020
            com.stripe.android.EphemeralKeyManager$1 r0 = com.stripe.android.EphemeralKeyManager.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r6 = r0
            goto L_0x0021
        L_0x0020:
            r6 = r14
        L_0x0021:
            r0 = r17 & 32
            if (r0 == 0) goto L_0x0029
            r0 = 30
            r7 = r0
            goto L_0x002a
        L_0x0029:
            r7 = r15
        L_0x002a:
            r1 = r9
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.EphemeralKeyManager.<init>(com.stripe.android.EphemeralKeyProvider, com.stripe.android.EphemeralKeyManager$KeyManagerListener, com.stripe.android.OperationIdFactory, boolean, kotlin.jvm.functions.Function0, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final EphemeralKey getEphemeralKey$payments_core_release() {
        return this.ephemeralKey;
    }

    public final void setEphemeralKey$payments_core_release(EphemeralKey ephemeralKey2) {
        this.ephemeralKey = ephemeralKey2;
    }

    public final /* synthetic */ void retrieveEphemeralKey$payments_core_release(EphemeralOperation ephemeralOperation) {
        Intrinsics.checkNotNullParameter(ephemeralOperation, "operation");
        EphemeralKey ephemeralKey2 = this.ephemeralKey;
        Unit unit = null;
        if (ephemeralKey2 == null || shouldRefreshKey$payments_core_release(ephemeralKey2)) {
            ephemeralKey2 = null;
        }
        if (ephemeralKey2 != null) {
            this.listener.onKeyUpdate(ephemeralKey2, ephemeralOperation);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.ephemeralKeyProvider.createEphemeralKey(this.apiVersion, new ClientKeyUpdateListener(this, ephemeralOperation));
        }
    }

    /* access modifiers changed from: private */
    public final void updateKey(EphemeralOperation ephemeralOperation, String str) {
        Object obj;
        String str2;
        if (str == null) {
            this.listener.onKeyError(ephemeralOperation.getId$payments_core_release(), 500, "EphemeralKeyUpdateListener.onKeyUpdate was called with a null value");
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            EphemeralKey parse = new EphemeralKeyJsonParser().parse(new JSONObject(str));
            setEphemeralKey$payments_core_release(parse);
            obj = Result.m4709constructorimpl(parse);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
        if (r1 == null) {
            this.listener.onKeyUpdate((EphemeralKey) obj, ephemeralOperation);
            return;
        }
        if (r1 instanceof JSONException) {
            str2 = StringsKt.trimIndent("\n                        Received an ephemeral key that could not be parsed. See https://stripe.com/docs/mobile/android/basic for more details.\n                        \n                        " + r1.getMessage() + "\n                        ");
        } else {
            str2 = StringsKt.trimIndent("\n                        Received an invalid ephemeral key. See https://stripe.com/docs/mobile/android/basic for more details.\n                        \n                        " + r1.getMessage() + "\n                        ");
        }
        this.listener.onKeyError(ephemeralOperation.getId$payments_core_release(), 500, str2);
    }

    /* access modifiers changed from: private */
    public final void updateKeyError(String str, int i, String str2) {
        this.ephemeralKey = null;
        this.listener.onKeyError(str, i, str2);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/EphemeralKeyManager$ClientKeyUpdateListener;", "Lcom/stripe/android/EphemeralKeyUpdateListener;", "ephemeralKeyManager", "Lcom/stripe/android/EphemeralKeyManager;", "operation", "Lcom/stripe/android/EphemeralOperation;", "(Lcom/stripe/android/EphemeralKeyManager;Lcom/stripe/android/EphemeralOperation;)V", "onKeyUpdate", "", "stripeResponseJson", "", "onKeyUpdateFailure", "responseCode", "", "message", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EphemeralKeyManager.kt */
    private static final class ClientKeyUpdateListener implements EphemeralKeyUpdateListener {
        private final EphemeralKeyManager ephemeralKeyManager;
        private final EphemeralOperation operation;

        public ClientKeyUpdateListener(EphemeralKeyManager ephemeralKeyManager2, EphemeralOperation ephemeralOperation) {
            Intrinsics.checkNotNullParameter(ephemeralKeyManager2, "ephemeralKeyManager");
            Intrinsics.checkNotNullParameter(ephemeralOperation, "operation");
            this.ephemeralKeyManager = ephemeralKeyManager2;
            this.operation = ephemeralOperation;
        }

        public void onKeyUpdate(String str) {
            Intrinsics.checkNotNullParameter(str, "stripeResponseJson");
            this.ephemeralKeyManager.updateKey(this.operation, str);
        }

        public void onKeyUpdateFailure(int i, String str) {
            Intrinsics.checkNotNullParameter(str, GraphQLConstants.Keys.MESSAGE);
            this.ephemeralKeyManager.updateKeyError(this.operation.getId$payments_core_release(), i, str);
        }
    }

    public final boolean shouldRefreshKey$payments_core_release(EphemeralKey ephemeralKey2) {
        if (ephemeralKey2 == null) {
            return true;
        }
        if (ephemeralKey2.getExpires$payments_core_release() < TimeUnit.MILLISECONDS.toSeconds(this.timeSupplier.invoke().longValue()) + this.timeBufferInSeconds) {
            return true;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0001\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/EphemeralKeyManager$Factory;", "", "create", "Lcom/stripe/android/EphemeralKeyManager;", "arg", "Lcom/stripe/android/EphemeralKeyManager$KeyManagerListener;", "Default", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EphemeralKeyManager.kt */
    public interface Factory {
        EphemeralKeyManager create(KeyManagerListener keyManagerListener);

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/EphemeralKeyManager$Factory$Default;", "Lcom/stripe/android/EphemeralKeyManager$Factory;", "keyProvider", "Lcom/stripe/android/EphemeralKeyProvider;", "shouldPrefetchEphemeralKey", "", "operationIdFactory", "Lcom/stripe/android/OperationIdFactory;", "timeSupplier", "Lkotlin/Function0;", "", "Lcom/stripe/android/TimeSupplier;", "(Lcom/stripe/android/EphemeralKeyProvider;ZLcom/stripe/android/OperationIdFactory;Lkotlin/jvm/functions/Function0;)V", "create", "Lcom/stripe/android/EphemeralKeyManager;", "arg", "Lcom/stripe/android/EphemeralKeyManager$KeyManagerListener;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: EphemeralKeyManager.kt */
        public static final class Default implements Factory {
            public static final int $stable = 0;
            private final EphemeralKeyProvider keyProvider;
            private final OperationIdFactory operationIdFactory;
            private final boolean shouldPrefetchEphemeralKey;
            private final Function0<Long> timeSupplier;

            public Default(EphemeralKeyProvider ephemeralKeyProvider, boolean z, OperationIdFactory operationIdFactory2, Function0<Long> function0) {
                Intrinsics.checkNotNullParameter(ephemeralKeyProvider, "keyProvider");
                Intrinsics.checkNotNullParameter(operationIdFactory2, "operationIdFactory");
                Intrinsics.checkNotNullParameter(function0, "timeSupplier");
                this.keyProvider = ephemeralKeyProvider;
                this.shouldPrefetchEphemeralKey = z;
                this.operationIdFactory = operationIdFactory2;
                this.timeSupplier = function0;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Default(EphemeralKeyProvider ephemeralKeyProvider, boolean z, OperationIdFactory operationIdFactory2, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(ephemeralKeyProvider, z, (i & 4) != 0 ? new StripeOperationIdFactory() : operationIdFactory2, (i & 8) != 0 ? AnonymousClass1.INSTANCE : function0);
            }

            public /* synthetic */ EphemeralKeyManager create(KeyManagerListener keyManagerListener) {
                Intrinsics.checkNotNullParameter(keyManagerListener, "arg");
                return new EphemeralKeyManager(this.keyProvider, keyManagerListener, this.operationIdFactory, this.shouldPrefetchEphemeralKey, this.timeSupplier, 0, 32, (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/EphemeralKeyManager$Companion;", "", "()V", "REFRESH_BUFFER_IN_SECONDS", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: EphemeralKeyManager.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
