package com.stripe.android;

import android.content.Context;
import com.stripe.android.core.Logger;
import com.stripe.android.core.networking.ConnectionFactory;
import com.stripe.android.core.networking.DefaultStripeNetworkClient;
import com.stripe.android.core.networking.RetryDelaySupplier;
import com.stripe.android.core.networking.StripeNetworkClient;
import com.stripe.android.networking.DefaultFraudDetectionDataRequestFactory;
import com.stripe.android.networking.FraudDetectionData;
import com.stripe.android.networking.FraudDetectionDataRequestFactory;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B%\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/DefaultFraudDetectionDataRepository;", "Lcom/stripe/android/FraudDetectionDataRepository;", "context", "Landroid/content/Context;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "localStore", "Lcom/stripe/android/FraudDetectionDataStore;", "fraudDetectionDataRequestFactory", "Lcom/stripe/android/networking/FraudDetectionDataRequestFactory;", "stripeNetworkClient", "Lcom/stripe/android/core/networking/StripeNetworkClient;", "(Lcom/stripe/android/FraudDetectionDataStore;Lcom/stripe/android/networking/FraudDetectionDataRequestFactory;Lcom/stripe/android/core/networking/StripeNetworkClient;Lkotlin/coroutines/CoroutineContext;)V", "cachedFraudDetectionData", "Lcom/stripe/android/networking/FraudDetectionData;", "getCached", "getLatest", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "", "save", "fraudDetectionData", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FraudDetectionDataRepository.kt */
public final class DefaultFraudDetectionDataRepository implements FraudDetectionDataRepository {
    /* access modifiers changed from: private */
    public FraudDetectionData cachedFraudDetectionData;
    /* access modifiers changed from: private */
    public final FraudDetectionDataRequestFactory fraudDetectionDataRequestFactory;
    /* access modifiers changed from: private */
    public final FraudDetectionDataStore localStore;
    /* access modifiers changed from: private */
    public final StripeNetworkClient stripeNetworkClient;
    private final CoroutineContext workContext;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultFraudDetectionDataRepository(Context context) {
        this(context, (CoroutineContext) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public DefaultFraudDetectionDataRepository(FraudDetectionDataStore fraudDetectionDataStore, FraudDetectionDataRequestFactory fraudDetectionDataRequestFactory2, StripeNetworkClient stripeNetworkClient2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(fraudDetectionDataStore, "localStore");
        Intrinsics.checkNotNullParameter(fraudDetectionDataRequestFactory2, "fraudDetectionDataRequestFactory");
        Intrinsics.checkNotNullParameter(stripeNetworkClient2, "stripeNetworkClient");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.localStore = fraudDetectionDataStore;
        this.fraudDetectionDataRequestFactory = fraudDetectionDataRequestFactory2;
        this.stripeNetworkClient = stripeNetworkClient2;
        this.workContext = coroutineContext;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultFraudDetectionDataRepository(Context context, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? Dispatchers.getIO() : coroutineContext);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultFraudDetectionDataRepository(Context context, CoroutineContext coroutineContext) {
        this((FraudDetectionDataStore) new DefaultFraudDetectionDataStore(context, coroutineContext), (FraudDetectionDataRequestFactory) new DefaultFraudDetectionDataRequestFactory(context), (StripeNetworkClient) new DefaultStripeNetworkClient(coroutineContext, (ConnectionFactory) null, (RetryDelaySupplier) null, 0, (Logger) null, 30, (DefaultConstructorMarker) null), coroutineContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
    }

    public void refresh() {
        if (Stripe.Companion.getAdvancedFraudSignalsEnabled()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new DefaultFraudDetectionDataRepository$refresh$1(this, (Continuation<? super DefaultFraudDetectionDataRepository$refresh$1>) null), 3, (Object) null);
        }
    }

    public Object getLatest(Continuation<? super FraudDetectionData> continuation) {
        return BuildersKt.withContext(this.workContext, new DefaultFraudDetectionDataRepository$getLatest$2(this, (Continuation<? super DefaultFraudDetectionDataRepository$getLatest$2>) null), continuation);
    }

    public FraudDetectionData getCached() {
        FraudDetectionData fraudDetectionData = this.cachedFraudDetectionData;
        if (Stripe.Companion.getAdvancedFraudSignalsEnabled()) {
            return fraudDetectionData;
        }
        return null;
    }

    public void save(FraudDetectionData fraudDetectionData) {
        Intrinsics.checkNotNullParameter(fraudDetectionData, "fraudDetectionData");
        this.cachedFraudDetectionData = fraudDetectionData;
        this.localStore.save(fraudDetectionData);
    }
}
