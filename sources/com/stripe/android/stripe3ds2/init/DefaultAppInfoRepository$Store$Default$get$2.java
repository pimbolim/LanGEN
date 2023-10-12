package com.stripe.android.stripe3ds2.init;

import com.stripe.android.core.networking.AnalyticsFields;
import com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/stripe3ds2/init/AppInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.init.DefaultAppInfoRepository$Store$Default$get$2", f = "DefaultAppInfoRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultAppInfoRepository.kt */
final class DefaultAppInfoRepository$Store$Default$get$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppInfo>, Object> {
    int label;
    final /* synthetic */ DefaultAppInfoRepository.Store.Default this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultAppInfoRepository$Store$Default$get$2(DefaultAppInfoRepository.Store.Default defaultR, Continuation<? super DefaultAppInfoRepository$Store$Default$get$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultR;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultAppInfoRepository$Store$Default$get$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AppInfo> continuation) {
        return ((DefaultAppInfoRepository$Store$Default$get$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i = this.this$0.getSharedPrefs().getInt(AnalyticsFields.APP_VERSION, 0);
            String string = this.this$0.getSharedPrefs().getString("sdk_app_id", (String) null);
            if (string == null) {
                return null;
            }
            return new AppInfo(string, i);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
