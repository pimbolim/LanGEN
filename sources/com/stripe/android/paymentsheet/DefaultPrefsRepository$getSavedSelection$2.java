package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.model.SavedSelection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.DefaultPrefsRepository$getSavedSelection$2", f = "DefaultPrefsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultPrefsRepository.kt */
final class DefaultPrefsRepository$getSavedSelection$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SavedSelection>, Object> {
    final /* synthetic */ boolean $isGooglePayAvailable;
    int label;
    final /* synthetic */ DefaultPrefsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultPrefsRepository$getSavedSelection$2(DefaultPrefsRepository defaultPrefsRepository, boolean z, Continuation<? super DefaultPrefsRepository$getSavedSelection$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultPrefsRepository;
        this.$isGooglePayAvailable = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultPrefsRepository$getSavedSelection$2(this.this$0, this.$isGooglePayAvailable, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SavedSelection> continuation) {
        return ((DefaultPrefsRepository$getSavedSelection$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = null;
            String string = this.this$0.getPrefs().getString(this.this$0.getKey(), (String) null);
            if (string == null) {
                string = "";
            }
            List split$default = StringsKt.split$default((CharSequence) string, new String[]{":"}, false, 0, 6, (Object) null);
            String str = (String) CollectionsKt.firstOrNull(split$default);
            if (Intrinsics.areEqual((Object) str, (Object) "google_pay")) {
                SavedSelection.GooglePay googlePay = SavedSelection.GooglePay.INSTANCE;
                if (this.$isGooglePayAvailable) {
                    obj2 = googlePay;
                }
                obj2 = (SavedSelection) obj2;
            } else if (Intrinsics.areEqual((Object) str, (Object) "payment_method")) {
                String str2 = (String) CollectionsKt.getOrNull(split$default, 1);
                if (str2 != null) {
                    obj2 = new SavedSelection.PaymentMethod(str2);
                }
                obj2 = (SavedSelection) obj2;
            }
            if (obj2 == null) {
                return SavedSelection.None.INSTANCE;
            }
            return obj2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
