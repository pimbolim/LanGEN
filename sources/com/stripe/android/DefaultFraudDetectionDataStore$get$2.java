package com.stripe.android;

import com.stripe.android.model.parsers.FraudDetectionDataJsonParser;
import com.stripe.android.networking.FraudDetectionData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/networking/FraudDetectionData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.DefaultFraudDetectionDataStore$get$2", f = "FraudDetectionDataStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FraudDetectionDataStore.kt */
final class DefaultFraudDetectionDataStore$get$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FraudDetectionData>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultFraudDetectionDataStore this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFraudDetectionDataStore$get$2(DefaultFraudDetectionDataStore defaultFraudDetectionDataStore, Continuation<? super DefaultFraudDetectionDataStore$get$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultFraudDetectionDataStore;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultFraudDetectionDataStore$get$2 defaultFraudDetectionDataStore$get$2 = new DefaultFraudDetectionDataStore$get$2(this.this$0, continuation);
        defaultFraudDetectionDataStore$get$2.L$0 = obj;
        return defaultFraudDetectionDataStore$get$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FraudDetectionData> continuation) {
        return ((DefaultFraudDetectionDataStore$get$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            DefaultFraudDetectionDataStore defaultFraudDetectionDataStore = this.this$0;
            try {
                Result.Companion companion = Result.Companion;
                String string = defaultFraudDetectionDataStore.getPrefs().getString("key_fraud_detection_data", (String) null);
                if (string == null) {
                    string = "";
                }
                JSONObject jSONObject = new JSONObject(string);
                obj2 = Result.m4709constructorimpl(new FraudDetectionDataJsonParser(new DefaultFraudDetectionDataStore$get$2$1$timestampSupplier$1(jSONObject)).parse(jSONObject));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m4715isFailureimpl(obj2)) {
                return null;
            }
            return obj2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
