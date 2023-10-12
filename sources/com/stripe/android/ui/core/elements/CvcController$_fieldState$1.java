package com.stripe.android.ui.core.elements;

import com.stripe.android.model.CardBrand;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/ui/core/elements/TextFieldState;", "brand", "Lcom/stripe/android/model/CardBrand;", "fieldValue", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.ui.core.elements.CvcController$_fieldState$1", f = "CvcController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CvcController.kt */
final class CvcController$_fieldState$1 extends SuspendLambda implements Function3<CardBrand, String, Continuation<? super TextFieldState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ CvcController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CvcController$_fieldState$1(CvcController cvcController, Continuation<? super CvcController$_fieldState$1> continuation) {
        super(3, continuation);
        this.this$0 = cvcController;
    }

    public final Object invoke(CardBrand cardBrand, String str, Continuation<? super TextFieldState> continuation) {
        CvcController$_fieldState$1 cvcController$_fieldState$1 = new CvcController$_fieldState$1(this.this$0, continuation);
        cvcController$_fieldState$1.L$0 = cardBrand;
        cvcController$_fieldState$1.L$1 = str;
        return cvcController$_fieldState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CardBrand cardBrand = (CardBrand) this.L$0;
            return this.this$0.cvcTextFieldConfig.determineState(cardBrand, (String) this.L$1, cardBrand.getMaxCvcLength());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
