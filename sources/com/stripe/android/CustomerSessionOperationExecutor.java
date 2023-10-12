package com.stripe.android;

import com.stripe.android.CustomerSession;
import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.Customer;
import com.stripe.android.networking.StripeRepository;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\n\b\u0000\u0010\u0017*\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0019J&\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001cH\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020!H\u0002J)\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050%H@ø\u0001\u0000¢\u0006\u0002\u0010&R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/stripe/android/CustomerSessionOperationExecutor;", "", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "publishableKey", "", "stripeAccountId", "listeners", "", "Lcom/stripe/android/CustomerSession$RetrievalListener;", "onCustomerUpdated", "Lkotlin/Function1;", "Lcom/stripe/android/model/Customer;", "", "(Lcom/stripe/android/networking/StripeRepository;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "execute", "ephemeralKey", "Lcom/stripe/android/EphemeralKey;", "operation", "Lcom/stripe/android/EphemeralOperation;", "execute$payments_core_release", "(Lcom/stripe/android/EphemeralKey;Lcom/stripe/android/EphemeralOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getListener", "L", "operationId", "(Ljava/lang/String;)Lcom/stripe/android/CustomerSession$RetrievalListener;", "onCustomerRetrieved", "result", "Lkotlin/Result;", "(Lcom/stripe/android/EphemeralOperation;Ljava/lang/Object;)V", "onError", "listener", "error", "", "retrieveCustomerWithKey", "key", "productUsage", "", "(Lcom/stripe/android/EphemeralKey;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerSessionOperationExecutor.kt */
public final class CustomerSessionOperationExecutor {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String REQUIRED_ERROR = "API request returned an invalid response.";
    private final Map<String, CustomerSession.RetrievalListener> listeners;
    private final Function1<Customer, Unit> onCustomerUpdated;
    private final String publishableKey;
    private final String stripeAccountId;
    private final StripeRepository stripeRepository;

    public CustomerSessionOperationExecutor(StripeRepository stripeRepository2, String str, String str2, Map<String, CustomerSession.RetrievalListener> map, Function1<? super Customer, Unit> function1) {
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        Intrinsics.checkNotNullParameter(map, "listeners");
        Intrinsics.checkNotNullParameter(function1, "onCustomerUpdated");
        this.stripeRepository = stripeRepository2;
        this.publishableKey = str;
        this.stripeAccountId = str2;
        this.listeners = map;
        this.onCustomerUpdated = function1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0219, code lost:
        throw new java.lang.IllegalArgumentException("API request returned an invalid response.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0287, code lost:
        if (r0 == null) goto L_0x0290;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        r0 = kotlin.Result.m4709constructorimpl((com.stripe.android.model.PaymentMethod) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0299, code lost:
        throw new java.lang.IllegalArgumentException("API request returned an invalid response.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0304, code lost:
        if (r0 == null) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r0 = kotlin.Result.m4709constructorimpl((com.stripe.android.model.PaymentMethod) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0316, code lost:
        throw new java.lang.IllegalArgumentException("API request returned an invalid response.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:?, code lost:
        r0 = kotlin.Result.m4709constructorimpl((java.util.List) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x041b, code lost:
        if (r0 == null) goto L_0x0424;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:?, code lost:
        r0 = kotlin.Result.m4709constructorimpl((com.stripe.android.model.Customer) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x042d, code lost:
        throw new java.lang.IllegalArgumentException("API request returned an invalid response.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x049f, code lost:
        if (r0 == null) goto L_0x04a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:?, code lost:
        r0 = kotlin.Result.m4709constructorimpl((com.stripe.android.model.Customer) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04b1, code lost:
        throw new java.lang.IllegalArgumentException("API request returned an invalid response.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fb, code lost:
        if (r0 == null) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r0 = kotlin.Result.m4709constructorimpl((com.stripe.android.model.Customer) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010d, code lost:
        throw new java.lang.IllegalArgumentException("API request returned an invalid response.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0187, code lost:
        if (r0 == null) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r0 = kotlin.Result.m4709constructorimpl((com.stripe.android.model.Source) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0199, code lost:
        throw new java.lang.IllegalArgumentException("API request returned an invalid response.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0207, code lost:
        if (r0 == null) goto L_0x0210;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        r0 = kotlin.Result.m4709constructorimpl((com.stripe.android.model.Source) r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object execute$payments_core_release(com.stripe.android.EphemeralKey r22, com.stripe.android.EphemeralOperation r23, kotlin.coroutines.Continuation r24) {
        /*
            r21 = this;
            r1 = r21
            r2 = r23
            r0 = r24
            boolean r3 = r0 instanceof com.stripe.android.CustomerSessionOperationExecutor$execute$1
            if (r3 == 0) goto L_0x001a
            r3 = r0
            com.stripe.android.CustomerSessionOperationExecutor$execute$1 r3 = (com.stripe.android.CustomerSessionOperationExecutor$execute$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L_0x001f
        L_0x001a:
            com.stripe.android.CustomerSessionOperationExecutor$execute$1 r3 = new com.stripe.android.CustomerSessionOperationExecutor$execute$1
            r3.<init>(r1, r0)
        L_0x001f:
            java.lang.Object r0 = r3.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r3.label
            java.lang.String r13 = "API request returned an invalid response."
            r14 = 0
            switch(r4) {
                case 0: goto L_0x00da;
                case 1: goto L_0x00cc;
                case 2: goto L_0x00c8;
                case 3: goto L_0x00b8;
                case 4: goto L_0x00b3;
                case 5: goto L_0x00a3;
                case 6: goto L_0x009e;
                case 7: goto L_0x008e;
                case 8: goto L_0x0089;
                case 9: goto L_0x0079;
                case 10: goto L_0x0074;
                case 11: goto L_0x0064;
                case 12: goto L_0x005f;
                case 13: goto L_0x004f;
                case 14: goto L_0x004a;
                case 15: goto L_0x003a;
                case 16: goto L_0x0035;
                default: goto L_0x002d;
            }
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x04da
        L_0x003a:
            java.lang.Object r2 = r3.L$1
            com.stripe.android.EphemeralOperation r2 = (com.stripe.android.EphemeralOperation) r2
            java.lang.Object r4 = r3.L$0
            com.stripe.android.CustomerSessionOperationExecutor r4 = (com.stripe.android.CustomerSessionOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0047 }
            goto L_0x049f
        L_0x0047:
            r0 = move-exception
            goto L_0x04b4
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0456
        L_0x004f:
            java.lang.Object r2 = r3.L$1
            com.stripe.android.EphemeralOperation r2 = (com.stripe.android.EphemeralOperation) r2
            java.lang.Object r4 = r3.L$0
            com.stripe.android.CustomerSessionOperationExecutor r4 = (com.stripe.android.CustomerSessionOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x005c }
            goto L_0x041b
        L_0x005c:
            r0 = move-exception
            goto L_0x0430
        L_0x005f:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x03cc
        L_0x0064:
            java.lang.Object r2 = r3.L$1
            com.stripe.android.EphemeralOperation r2 = (com.stripe.android.EphemeralOperation) r2
            java.lang.Object r4 = r3.L$0
            com.stripe.android.CustomerSessionOperationExecutor r4 = (com.stripe.android.CustomerSessionOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0071 }
            goto L_0x039d
        L_0x0071:
            r0 = move-exception
            goto L_0x03a6
        L_0x0074:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x033f
        L_0x0079:
            java.lang.Object r2 = r3.L$1
            com.stripe.android.EphemeralOperation r2 = (com.stripe.android.EphemeralOperation) r2
            java.lang.Object r4 = r3.L$0
            com.stripe.android.CustomerSessionOperationExecutor r4 = (com.stripe.android.CustomerSessionOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0086 }
            goto L_0x0304
        L_0x0086:
            r0 = move-exception
            goto L_0x0319
        L_0x0089:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x02c2
        L_0x008e:
            java.lang.Object r2 = r3.L$1
            com.stripe.android.EphemeralOperation r2 = (com.stripe.android.EphemeralOperation) r2
            java.lang.Object r4 = r3.L$0
            com.stripe.android.CustomerSessionOperationExecutor r4 = (com.stripe.android.CustomerSessionOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x009b }
            goto L_0x0287
        L_0x009b:
            r0 = move-exception
            goto L_0x029c
        L_0x009e:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0241
        L_0x00a3:
            java.lang.Object r2 = r3.L$1
            com.stripe.android.EphemeralOperation r2 = (com.stripe.android.EphemeralOperation) r2
            java.lang.Object r4 = r3.L$0
            com.stripe.android.CustomerSessionOperationExecutor r4 = (com.stripe.android.CustomerSessionOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00b0 }
            goto L_0x0207
        L_0x00b0:
            r0 = move-exception
            goto L_0x021c
        L_0x00b3:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x01c1
        L_0x00b8:
            java.lang.Object r2 = r3.L$1
            com.stripe.android.EphemeralOperation r2 = (com.stripe.android.EphemeralOperation) r2
            java.lang.Object r4 = r3.L$0
            com.stripe.android.CustomerSessionOperationExecutor r4 = (com.stripe.android.CustomerSessionOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00c5 }
            goto L_0x0187
        L_0x00c5:
            r0 = move-exception
            goto L_0x019c
        L_0x00c8:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0135
        L_0x00cc:
            java.lang.Object r2 = r3.L$1
            com.stripe.android.EphemeralOperation r2 = (com.stripe.android.EphemeralOperation) r2
            java.lang.Object r4 = r3.L$0
            com.stripe.android.CustomerSessionOperationExecutor r4 = (com.stripe.android.CustomerSessionOperationExecutor) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00d8 }
            goto L_0x00fb
        L_0x00d8:
            r0 = move-exception
            goto L_0x0110
        L_0x00da:
            kotlin.ResultKt.throwOnFailure(r0)
            boolean r0 = r2 instanceof com.stripe.android.EphemeralOperation.RetrieveKey
            if (r0 == 0) goto L_0x0138
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x010e }
            r0 = r1
            com.stripe.android.CustomerSessionOperationExecutor r0 = (com.stripe.android.CustomerSessionOperationExecutor) r0     // Catch:{ all -> 0x010e }
            java.util.Set r4 = r23.getProductUsage$payments_core_release()     // Catch:{ all -> 0x010e }
            r3.L$0 = r1     // Catch:{ all -> 0x010e }
            r3.L$1 = r2     // Catch:{ all -> 0x010e }
            r5 = 1
            r3.label = r5     // Catch:{ all -> 0x010e }
            r5 = r22
            java.lang.Object r0 = r0.retrieveCustomerWithKey(r5, r4, r3)     // Catch:{ all -> 0x010e }
            if (r0 != r12) goto L_0x00fa
            return r12
        L_0x00fa:
            r4 = r1
        L_0x00fb:
            if (r0 == 0) goto L_0x0104
            com.stripe.android.model.Customer r0 = (com.stripe.android.model.Customer) r0     // Catch:{ all -> 0x00d8 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x00d8 }
            goto L_0x011a
        L_0x0104:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00d8 }
            java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x00d8 }
            r0.<init>(r5)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x010e:
            r0 = move-exception
            r4 = r1
        L_0x0110:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x011a:
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            com.stripe.android.CustomerSessionOperationExecutor$execute$2 r6 = new com.stripe.android.CustomerSessionOperationExecutor$execute$2
            r6.<init>(r4, r2, r0, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r3.L$0 = r14
            r3.L$1 = r14
            r0 = 2
            r3.label = r0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r3)
            if (r0 != r12) goto L_0x0135
            return r12
        L_0x0135:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0138:
            r5 = r22
            boolean r0 = r2 instanceof com.stripe.android.EphemeralOperation.Customer.AddSource
            if (r0 == 0) goto L_0x01c2
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x019a }
            r0 = r1
            com.stripe.android.CustomerSessionOperationExecutor r0 = (com.stripe.android.CustomerSessionOperationExecutor) r0     // Catch:{ all -> 0x019a }
            com.stripe.android.networking.StripeRepository r4 = r0.stripeRepository     // Catch:{ all -> 0x019a }
            java.lang.String r6 = r22.getObjectId$payments_core_release()     // Catch:{ all -> 0x019a }
            java.lang.String r7 = r0.publishableKey     // Catch:{ all -> 0x019a }
            java.util.Set r8 = r23.getProductUsage$payments_core_release()     // Catch:{ all -> 0x019a }
            r9 = r2
            com.stripe.android.EphemeralOperation$Customer$AddSource r9 = (com.stripe.android.EphemeralOperation.Customer.AddSource) r9     // Catch:{ all -> 0x019a }
            java.lang.String r9 = r9.getSourceId()     // Catch:{ all -> 0x019a }
            r10 = r2
            com.stripe.android.EphemeralOperation$Customer$AddSource r10 = (com.stripe.android.EphemeralOperation.Customer.AddSource) r10     // Catch:{ all -> 0x019a }
            java.lang.String r10 = r10.getSourceType()     // Catch:{ all -> 0x019a }
            com.stripe.android.core.networking.ApiRequest$Options r11 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x019a }
            java.lang.String r16 = r22.getSecret()     // Catch:{ all -> 0x019a }
            java.lang.String r0 = r0.stripeAccountId     // Catch:{ all -> 0x019a }
            r18 = 0
            r19 = 4
            r20 = 0
            r15 = r11
            r17 = r0
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ all -> 0x019a }
            r3.L$0 = r1     // Catch:{ all -> 0x019a }
            r3.L$1 = r2     // Catch:{ all -> 0x019a }
            r0 = 3
            r3.label = r0     // Catch:{ all -> 0x019a }
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r3
            java.lang.Object r0 = r4.addCustomerSource$payments_core_release(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x019a }
            if (r0 != r12) goto L_0x0186
            return r12
        L_0x0186:
            r4 = r1
        L_0x0187:
            if (r0 == 0) goto L_0x0190
            com.stripe.android.model.Source r0 = (com.stripe.android.model.Source) r0     // Catch:{ all -> 0x00c5 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x00c5 }
            goto L_0x01a6
        L_0x0190:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x00c5 }
            r0.<init>(r5)     // Catch:{ all -> 0x00c5 }
            throw r0     // Catch:{ all -> 0x00c5 }
        L_0x019a:
            r0 = move-exception
            r4 = r1
        L_0x019c:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x01a6:
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            com.stripe.android.CustomerSessionOperationExecutor$execute$3 r6 = new com.stripe.android.CustomerSessionOperationExecutor$execute$3
            r6.<init>(r4, r2, r0, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r3.L$0 = r14
            r3.L$1 = r14
            r0 = 4
            r3.label = r0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r3)
            if (r0 != r12) goto L_0x01c1
            return r12
        L_0x01c1:
            return r0
        L_0x01c2:
            boolean r0 = r2 instanceof com.stripe.android.EphemeralOperation.Customer.DeleteSource
            if (r0 == 0) goto L_0x0242
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x021a }
            r0 = r1
            com.stripe.android.CustomerSessionOperationExecutor r0 = (com.stripe.android.CustomerSessionOperationExecutor) r0     // Catch:{ all -> 0x021a }
            com.stripe.android.networking.StripeRepository r4 = r0.stripeRepository     // Catch:{ all -> 0x021a }
            java.lang.String r6 = r22.getObjectId$payments_core_release()     // Catch:{ all -> 0x021a }
            java.lang.String r7 = r0.publishableKey     // Catch:{ all -> 0x021a }
            java.util.Set r8 = r23.getProductUsage$payments_core_release()     // Catch:{ all -> 0x021a }
            r9 = r2
            com.stripe.android.EphemeralOperation$Customer$DeleteSource r9 = (com.stripe.android.EphemeralOperation.Customer.DeleteSource) r9     // Catch:{ all -> 0x021a }
            java.lang.String r9 = r9.getSourceId()     // Catch:{ all -> 0x021a }
            com.stripe.android.core.networking.ApiRequest$Options r10 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x021a }
            java.lang.String r16 = r22.getSecret()     // Catch:{ all -> 0x021a }
            java.lang.String r0 = r0.stripeAccountId     // Catch:{ all -> 0x021a }
            r18 = 0
            r19 = 4
            r20 = 0
            r15 = r10
            r17 = r0
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ all -> 0x021a }
            r3.L$0 = r1     // Catch:{ all -> 0x021a }
            r3.L$1 = r2     // Catch:{ all -> 0x021a }
            r0 = 5
            r3.label = r0     // Catch:{ all -> 0x021a }
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r3
            java.lang.Object r0 = r4.deleteCustomerSource$payments_core_release(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x021a }
            if (r0 != r12) goto L_0x0206
            return r12
        L_0x0206:
            r4 = r1
        L_0x0207:
            if (r0 == 0) goto L_0x0210
            com.stripe.android.model.Source r0 = (com.stripe.android.model.Source) r0     // Catch:{ all -> 0x00b0 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x00b0 }
            goto L_0x0226
        L_0x0210:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00b0 }
            java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x00b0 }
            r0.<init>(r5)     // Catch:{ all -> 0x00b0 }
            throw r0     // Catch:{ all -> 0x00b0 }
        L_0x021a:
            r0 = move-exception
            r4 = r1
        L_0x021c:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0226:
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            com.stripe.android.CustomerSessionOperationExecutor$execute$4 r6 = new com.stripe.android.CustomerSessionOperationExecutor$execute$4
            r6.<init>(r4, r2, r0, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r3.L$0 = r14
            r3.L$1 = r14
            r0 = 6
            r3.label = r0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r3)
            if (r0 != r12) goto L_0x0241
            return r12
        L_0x0241:
            return r0
        L_0x0242:
            boolean r0 = r2 instanceof com.stripe.android.EphemeralOperation.Customer.AttachPaymentMethod
            if (r0 == 0) goto L_0x02c3
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x029a }
            r0 = r1
            com.stripe.android.CustomerSessionOperationExecutor r0 = (com.stripe.android.CustomerSessionOperationExecutor) r0     // Catch:{ all -> 0x029a }
            com.stripe.android.networking.StripeRepository r4 = r0.stripeRepository     // Catch:{ all -> 0x029a }
            java.lang.String r6 = r22.getObjectId$payments_core_release()     // Catch:{ all -> 0x029a }
            java.lang.String r7 = r0.publishableKey     // Catch:{ all -> 0x029a }
            java.util.Set r8 = r23.getProductUsage$payments_core_release()     // Catch:{ all -> 0x029a }
            r9 = r2
            com.stripe.android.EphemeralOperation$Customer$AttachPaymentMethod r9 = (com.stripe.android.EphemeralOperation.Customer.AttachPaymentMethod) r9     // Catch:{ all -> 0x029a }
            java.lang.String r9 = r9.getPaymentMethodId()     // Catch:{ all -> 0x029a }
            com.stripe.android.core.networking.ApiRequest$Options r10 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x029a }
            java.lang.String r16 = r22.getSecret()     // Catch:{ all -> 0x029a }
            java.lang.String r0 = r0.stripeAccountId     // Catch:{ all -> 0x029a }
            r18 = 0
            r19 = 4
            r20 = 0
            r15 = r10
            r17 = r0
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ all -> 0x029a }
            r3.L$0 = r1     // Catch:{ all -> 0x029a }
            r3.L$1 = r2     // Catch:{ all -> 0x029a }
            r0 = 7
            r3.label = r0     // Catch:{ all -> 0x029a }
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r3
            java.lang.Object r0 = r4.attachPaymentMethod(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x029a }
            if (r0 != r12) goto L_0x0286
            return r12
        L_0x0286:
            r4 = r1
        L_0x0287:
            if (r0 == 0) goto L_0x0290
            com.stripe.android.model.PaymentMethod r0 = (com.stripe.android.model.PaymentMethod) r0     // Catch:{ all -> 0x009b }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x009b }
            goto L_0x02a6
        L_0x0290:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x009b }
            java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x009b }
            r0.<init>(r5)     // Catch:{ all -> 0x009b }
            throw r0     // Catch:{ all -> 0x009b }
        L_0x029a:
            r0 = move-exception
            r4 = r1
        L_0x029c:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x02a6:
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            com.stripe.android.CustomerSessionOperationExecutor$execute$5 r6 = new com.stripe.android.CustomerSessionOperationExecutor$execute$5
            r6.<init>(r4, r2, r0, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r3.L$0 = r14
            r3.L$1 = r14
            r0 = 8
            r3.label = r0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r3)
            if (r0 != r12) goto L_0x02c2
            return r12
        L_0x02c2:
            return r0
        L_0x02c3:
            boolean r0 = r2 instanceof com.stripe.android.EphemeralOperation.Customer.DetachPaymentMethod
            if (r0 == 0) goto L_0x0340
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0317 }
            r0 = r1
            com.stripe.android.CustomerSessionOperationExecutor r0 = (com.stripe.android.CustomerSessionOperationExecutor) r0     // Catch:{ all -> 0x0317 }
            com.stripe.android.networking.StripeRepository r4 = r0.stripeRepository     // Catch:{ all -> 0x0317 }
            java.lang.String r6 = r0.publishableKey     // Catch:{ all -> 0x0317 }
            java.util.Set r7 = r23.getProductUsage$payments_core_release()     // Catch:{ all -> 0x0317 }
            r8 = r2
            com.stripe.android.EphemeralOperation$Customer$DetachPaymentMethod r8 = (com.stripe.android.EphemeralOperation.Customer.DetachPaymentMethod) r8     // Catch:{ all -> 0x0317 }
            java.lang.String r8 = r8.getPaymentMethodId()     // Catch:{ all -> 0x0317 }
            com.stripe.android.core.networking.ApiRequest$Options r9 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x0317 }
            java.lang.String r16 = r22.getSecret()     // Catch:{ all -> 0x0317 }
            java.lang.String r0 = r0.stripeAccountId     // Catch:{ all -> 0x0317 }
            r18 = 0
            r19 = 4
            r20 = 0
            r15 = r9
            r17 = r0
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0317 }
            r3.L$0 = r1     // Catch:{ all -> 0x0317 }
            r3.L$1 = r2     // Catch:{ all -> 0x0317 }
            r0 = 9
            r3.label = r0     // Catch:{ all -> 0x0317 }
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r3
            java.lang.Object r0 = r4.detachPaymentMethod(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0317 }
            if (r0 != r12) goto L_0x0303
            return r12
        L_0x0303:
            r4 = r1
        L_0x0304:
            if (r0 == 0) goto L_0x030d
            com.stripe.android.model.PaymentMethod r0 = (com.stripe.android.model.PaymentMethod) r0     // Catch:{ all -> 0x0086 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0086 }
            goto L_0x0323
        L_0x030d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0086 }
            java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x0086 }
            r0.<init>(r5)     // Catch:{ all -> 0x0086 }
            throw r0     // Catch:{ all -> 0x0086 }
        L_0x0317:
            r0 = move-exception
            r4 = r1
        L_0x0319:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x0323:
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            com.stripe.android.CustomerSessionOperationExecutor$execute$6 r6 = new com.stripe.android.CustomerSessionOperationExecutor$execute$6
            r6.<init>(r4, r2, r0, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r3.L$0 = r14
            r3.L$1 = r14
            r0 = 10
            r3.label = r0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r3)
            if (r0 != r12) goto L_0x033f
            return r12
        L_0x033f:
            return r0
        L_0x0340:
            boolean r0 = r2 instanceof com.stripe.android.EphemeralOperation.Customer.GetPaymentMethods
            if (r0 == 0) goto L_0x03cd
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x03a4 }
            r0 = r1
            com.stripe.android.CustomerSessionOperationExecutor r0 = (com.stripe.android.CustomerSessionOperationExecutor) r0     // Catch:{ all -> 0x03a4 }
            com.stripe.android.networking.StripeRepository r4 = r0.stripeRepository     // Catch:{ all -> 0x03a4 }
            com.stripe.android.model.ListPaymentMethodsParams r13 = new com.stripe.android.model.ListPaymentMethodsParams     // Catch:{ all -> 0x03a4 }
            java.lang.String r7 = r22.getObjectId$payments_core_release()     // Catch:{ all -> 0x03a4 }
            r6 = r2
            com.stripe.android.EphemeralOperation$Customer$GetPaymentMethods r6 = (com.stripe.android.EphemeralOperation.Customer.GetPaymentMethods) r6     // Catch:{ all -> 0x03a4 }
            com.stripe.android.model.PaymentMethod$Type r8 = r6.getType$payments_core_release()     // Catch:{ all -> 0x03a4 }
            r6 = r2
            com.stripe.android.EphemeralOperation$Customer$GetPaymentMethods r6 = (com.stripe.android.EphemeralOperation.Customer.GetPaymentMethods) r6     // Catch:{ all -> 0x03a4 }
            java.lang.Integer r9 = r6.getLimit$payments_core_release()     // Catch:{ all -> 0x03a4 }
            r6 = r2
            com.stripe.android.EphemeralOperation$Customer$GetPaymentMethods r6 = (com.stripe.android.EphemeralOperation.Customer.GetPaymentMethods) r6     // Catch:{ all -> 0x03a4 }
            java.lang.String r10 = r6.getEndingBefore$payments_core_release()     // Catch:{ all -> 0x03a4 }
            r6 = r2
            com.stripe.android.EphemeralOperation$Customer$GetPaymentMethods r6 = (com.stripe.android.EphemeralOperation.Customer.GetPaymentMethods) r6     // Catch:{ all -> 0x03a4 }
            java.lang.String r11 = r6.getStartingAfter$payments_core_release()     // Catch:{ all -> 0x03a4 }
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x03a4 }
            java.lang.String r6 = r0.publishableKey     // Catch:{ all -> 0x03a4 }
            java.util.Set r7 = r23.getProductUsage$payments_core_release()     // Catch:{ all -> 0x03a4 }
            com.stripe.android.core.networking.ApiRequest$Options r8 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x03a4 }
            java.lang.String r16 = r22.getSecret()     // Catch:{ all -> 0x03a4 }
            java.lang.String r0 = r0.stripeAccountId     // Catch:{ all -> 0x03a4 }
            r18 = 0
            r19 = 4
            r20 = 0
            r15 = r8
            r17 = r0
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ all -> 0x03a4 }
            r3.L$0 = r1     // Catch:{ all -> 0x03a4 }
            r3.L$1 = r2     // Catch:{ all -> 0x03a4 }
            r0 = 11
            r3.label = r0     // Catch:{ all -> 0x03a4 }
            r5 = r13
            r9 = r3
            java.lang.Object r0 = r4.getPaymentMethods(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x03a4 }
            if (r0 != r12) goto L_0x039c
            return r12
        L_0x039c:
            r4 = r1
        L_0x039d:
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0071 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0071 }
            goto L_0x03b0
        L_0x03a4:
            r0 = move-exception
            r4 = r1
        L_0x03a6:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x03b0:
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            com.stripe.android.CustomerSessionOperationExecutor$execute$7 r6 = new com.stripe.android.CustomerSessionOperationExecutor$execute$7
            r6.<init>(r4, r2, r0, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r3.L$0 = r14
            r3.L$1 = r14
            r0 = 12
            r3.label = r0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r3)
            if (r0 != r12) goto L_0x03cc
            return r12
        L_0x03cc:
            return r0
        L_0x03cd:
            boolean r0 = r2 instanceof com.stripe.android.EphemeralOperation.Customer.UpdateDefaultSource
            if (r0 == 0) goto L_0x0459
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x042e }
            r0 = r1
            com.stripe.android.CustomerSessionOperationExecutor r0 = (com.stripe.android.CustomerSessionOperationExecutor) r0     // Catch:{ all -> 0x042e }
            com.stripe.android.networking.StripeRepository r4 = r0.stripeRepository     // Catch:{ all -> 0x042e }
            java.lang.String r6 = r22.getObjectId$payments_core_release()     // Catch:{ all -> 0x042e }
            java.lang.String r7 = r0.publishableKey     // Catch:{ all -> 0x042e }
            java.util.Set r8 = r23.getProductUsage$payments_core_release()     // Catch:{ all -> 0x042e }
            r9 = r2
            com.stripe.android.EphemeralOperation$Customer$UpdateDefaultSource r9 = (com.stripe.android.EphemeralOperation.Customer.UpdateDefaultSource) r9     // Catch:{ all -> 0x042e }
            java.lang.String r9 = r9.getSourceId()     // Catch:{ all -> 0x042e }
            r10 = r2
            com.stripe.android.EphemeralOperation$Customer$UpdateDefaultSource r10 = (com.stripe.android.EphemeralOperation.Customer.UpdateDefaultSource) r10     // Catch:{ all -> 0x042e }
            java.lang.String r10 = r10.getSourceType()     // Catch:{ all -> 0x042e }
            com.stripe.android.core.networking.ApiRequest$Options r11 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x042e }
            java.lang.String r16 = r22.getSecret()     // Catch:{ all -> 0x042e }
            java.lang.String r0 = r0.stripeAccountId     // Catch:{ all -> 0x042e }
            r18 = 0
            r19 = 4
            r20 = 0
            r15 = r11
            r17 = r0
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ all -> 0x042e }
            r3.L$0 = r1     // Catch:{ all -> 0x042e }
            r3.L$1 = r2     // Catch:{ all -> 0x042e }
            r0 = 13
            r3.label = r0     // Catch:{ all -> 0x042e }
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r3
            java.lang.Object r0 = r4.setDefaultCustomerSource$payments_core_release(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x042e }
            if (r0 != r12) goto L_0x041a
            return r12
        L_0x041a:
            r4 = r1
        L_0x041b:
            if (r0 == 0) goto L_0x0424
            com.stripe.android.model.Customer r0 = (com.stripe.android.model.Customer) r0     // Catch:{ all -> 0x005c }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x005c }
            goto L_0x043a
        L_0x0424:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x005c }
            java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x005c }
            r0.<init>(r5)     // Catch:{ all -> 0x005c }
            throw r0     // Catch:{ all -> 0x005c }
        L_0x042e:
            r0 = move-exception
            r4 = r1
        L_0x0430:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x043a:
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            com.stripe.android.CustomerSessionOperationExecutor$execute$8 r6 = new com.stripe.android.CustomerSessionOperationExecutor$execute$8
            r6.<init>(r4, r2, r0, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r3.L$0 = r14
            r3.L$1 = r14
            r0 = 14
            r3.label = r0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r3)
            if (r0 != r12) goto L_0x0456
            return r12
        L_0x0456:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0459:
            boolean r0 = r2 instanceof com.stripe.android.EphemeralOperation.Customer.UpdateShipping
            if (r0 == 0) goto L_0x04dd
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x04b2 }
            r0 = r1
            com.stripe.android.CustomerSessionOperationExecutor r0 = (com.stripe.android.CustomerSessionOperationExecutor) r0     // Catch:{ all -> 0x04b2 }
            com.stripe.android.networking.StripeRepository r4 = r0.stripeRepository     // Catch:{ all -> 0x04b2 }
            java.lang.String r6 = r22.getObjectId$payments_core_release()     // Catch:{ all -> 0x04b2 }
            java.lang.String r7 = r0.publishableKey     // Catch:{ all -> 0x04b2 }
            java.util.Set r8 = r23.getProductUsage$payments_core_release()     // Catch:{ all -> 0x04b2 }
            r9 = r2
            com.stripe.android.EphemeralOperation$Customer$UpdateShipping r9 = (com.stripe.android.EphemeralOperation.Customer.UpdateShipping) r9     // Catch:{ all -> 0x04b2 }
            com.stripe.android.model.ShippingInformation r9 = r9.getShippingInformation()     // Catch:{ all -> 0x04b2 }
            com.stripe.android.core.networking.ApiRequest$Options r10 = new com.stripe.android.core.networking.ApiRequest$Options     // Catch:{ all -> 0x04b2 }
            java.lang.String r16 = r22.getSecret()     // Catch:{ all -> 0x04b2 }
            java.lang.String r0 = r0.stripeAccountId     // Catch:{ all -> 0x04b2 }
            r18 = 0
            r19 = 4
            r20 = 0
            r15 = r10
            r17 = r0
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ all -> 0x04b2 }
            r3.L$0 = r1     // Catch:{ all -> 0x04b2 }
            r3.L$1 = r2     // Catch:{ all -> 0x04b2 }
            r0 = 15
            r3.label = r0     // Catch:{ all -> 0x04b2 }
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r3
            java.lang.Object r0 = r4.setCustomerShippingInfo$payments_core_release(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x04b2 }
            if (r0 != r12) goto L_0x049e
            return r12
        L_0x049e:
            r4 = r1
        L_0x049f:
            if (r0 == 0) goto L_0x04a8
            com.stripe.android.model.Customer r0 = (com.stripe.android.model.Customer) r0     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)     // Catch:{ all -> 0x0047 }
            goto L_0x04be
        L_0x04a8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = r13.toString()     // Catch:{ all -> 0x0047 }
            r0.<init>(r5)     // Catch:{ all -> 0x0047 }
            throw r0     // Catch:{ all -> 0x0047 }
        L_0x04b2:
            r0 = move-exception
            r4 = r1
        L_0x04b4:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m4709constructorimpl(r0)
        L_0x04be:
            kotlinx.coroutines.MainCoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            com.stripe.android.CustomerSessionOperationExecutor$execute$9 r6 = new com.stripe.android.CustomerSessionOperationExecutor$execute$9
            r6.<init>(r4, r2, r0, r14)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r3.L$0 = r14
            r3.L$1 = r14
            r0 = 16
            r3.label = r0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r3)
            if (r0 != r12) goto L_0x04da
            return r12
        L_0x04da:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x04dd:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.CustomerSessionOperationExecutor.execute$payments_core_release(com.stripe.android.EphemeralKey, com.stripe.android.EphemeralOperation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void onCustomerRetrieved(EphemeralOperation ephemeralOperation, Object obj) {
        CustomerSession.CustomerRetrievalListener customerRetrievalListener = (CustomerSession.CustomerRetrievalListener) getListener(ephemeralOperation.getId$payments_core_release());
        Throwable r0 = Result.m4712exceptionOrNullimpl(obj);
        if (r0 == null) {
            Customer customer = (Customer) obj;
            this.onCustomerUpdated.invoke(customer);
            if (customerRetrievalListener != null) {
                customerRetrievalListener.onCustomerRetrieved(customer);
                return;
            }
            return;
        }
        onError(customerRetrievalListener, r0);
    }

    /* access modifiers changed from: private */
    public final void onError(CustomerSession.RetrievalListener retrievalListener, Throwable th) {
        String str = "";
        if (th instanceof StripeException) {
            if (retrievalListener != null) {
                StripeException stripeException = (StripeException) th;
                int statusCode = stripeException.getStatusCode();
                String message = th.getMessage();
                if (message != null) {
                    str = message;
                }
                retrievalListener.onError(statusCode, str, stripeException.getStripeError());
            }
        } else if (retrievalListener != null) {
            String message2 = th.getMessage();
            if (message2 != null) {
                str = message2;
            }
            retrievalListener.onError(0, str, (StripeError) null);
        }
    }

    /* access modifiers changed from: private */
    public final <L extends CustomerSession.RetrievalListener> L getListener(String str) {
        return (CustomerSession.RetrievalListener) this.listeners.remove(str);
    }

    /* access modifiers changed from: private */
    public final Object retrieveCustomerWithKey(EphemeralKey ephemeralKey, Set<String> set, Continuation<? super Customer> continuation) throws StripeException {
        return this.stripeRepository.retrieveCustomer$payments_core_release(ephemeralKey.getObjectId$payments_core_release(), set, new ApiRequest.Options(ephemeralKey.getSecret(), this.stripeAccountId, (String) null, 4, (DefaultConstructorMarker) null), continuation);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/CustomerSessionOperationExecutor$Companion;", "", "()V", "REQUIRED_ERROR", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerSessionOperationExecutor.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
