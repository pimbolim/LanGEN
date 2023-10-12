package com.stripe.android.stripe3ds2.views;

import android.graphics.Bitmap;
import androidx.lifecycle.LiveDataScope;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Landroid/graphics/Bitmap;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.views.ChallengeActivityViewModel$getImage$1", f = "ChallengeActivityViewModel.kt", i = {}, l = {70, 69}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChallengeActivityViewModel.kt */
final class ChallengeActivityViewModel$getImage$1 extends SuspendLambda implements Function2<LiveDataScope<Bitmap>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $densityDpi;
    final /* synthetic */ ChallengeResponseData.Image $imageData;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChallengeActivityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeActivityViewModel$getImage$1(ChallengeActivityViewModel challengeActivityViewModel, ChallengeResponseData.Image image, int i, Continuation<? super ChallengeActivityViewModel$getImage$1> continuation) {
        super(2, continuation);
        this.this$0 = challengeActivityViewModel;
        this.$imageData = image;
        this.$densityDpi = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChallengeActivityViewModel$getImage$1 challengeActivityViewModel$getImage$1 = new ChallengeActivityViewModel$getImage$1(this.this$0, this.$imageData, this.$densityDpi, continuation);
        challengeActivityViewModel$getImage$1.L$0 = obj;
        return challengeActivityViewModel$getImage$1;
    }

    public final Object invoke(LiveDataScope<Bitmap> liveDataScope, Continuation<? super Unit> continuation) {
        return ((ChallengeActivityViewModel$getImage$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.lifecycle.LiveDataScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0059
        L_0x0013:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001b:
            java.lang.Object r1 = r7.L$0
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004b
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            com.stripe.android.stripe3ds2.views.ChallengeActivityViewModel r8 = r7.this$0
            com.stripe.android.stripe3ds2.views.ImageRepository r8 = r8.imageRepository
            com.stripe.android.stripe3ds2.transactions.ChallengeResponseData$Image r5 = r7.$imageData
            if (r5 != 0) goto L_0x0037
            r5 = r2
            goto L_0x003d
        L_0x0037:
            int r6 = r7.$densityDpi
            java.lang.String r5 = r5.getUrlForDensity(r6)
        L_0x003d:
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = r8.getImage$3ds2sdk_release(r5, r6)
            if (r8 != r0) goto L_0x004b
            return r0
        L_0x004b:
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r7.L$0 = r2
            r7.label = r3
            java.lang.Object r8 = r1.emit(r8, r4)
            if (r8 != r0) goto L_0x0059
            return r0
        L_0x0059:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.views.ChallengeActivityViewModel$getImage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
