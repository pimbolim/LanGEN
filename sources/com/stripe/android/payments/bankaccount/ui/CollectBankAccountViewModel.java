package com.stripe.android.payments.bankaccount.ui;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.SavedStateRegistryOwner;
import com.stripe.android.connections.ConnectionsSheetResult;
import com.stripe.android.core.Logger;
import com.stripe.android.payments.bankaccount.di.DaggerCollectBankAccountComponent;
import com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession;
import com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult;
import com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewEffect;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001!B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0011\u0010\u0007\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020 R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewModel;", "Landroidx/lifecycle/ViewModel;", "args", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "_viewEffect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect;", "createLinkAccountSession", "Lcom/stripe/android/payments/bankaccount/domain/CreateLinkAccountSession;", "attachLinkAccountSession", "Lcom/stripe/android/payments/bankaccount/domain/AttachLinkAccountSession;", "logger", "Lcom/stripe/android/core/Logger;", "(Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;Lkotlinx/coroutines/flow/MutableSharedFlow;Lcom/stripe/android/payments/bankaccount/domain/CreateLinkAccountSession;Lcom/stripe/android/payments/bankaccount/domain/AttachLinkAccountSession;Lcom/stripe/android/core/Logger;)V", "viewEffect", "Lkotlinx/coroutines/flow/SharedFlow;", "getViewEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "attachLinkAccountSessionToIntent", "", "linkedAccountSessionId", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finishWithError", "throwable", "", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finishWithResult", "result", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;", "(Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onConnectionsResult", "Lcom/stripe/android/connections/ConnectionsSheetResult;", "Factory", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountViewModel.kt */
public final class CollectBankAccountViewModel extends ViewModel {
    private final MutableSharedFlow<CollectBankAccountViewEffect> _viewEffect;
    /* access modifiers changed from: private */
    public final CollectBankAccountContract.Args args;
    /* access modifiers changed from: private */
    public final AttachLinkAccountSession attachLinkAccountSession;
    private final CreateLinkAccountSession createLinkAccountSession;
    /* access modifiers changed from: private */
    public final Logger logger;
    private final SharedFlow<CollectBankAccountViewEffect> viewEffect;

    @Inject
    public CollectBankAccountViewModel(CollectBankAccountContract.Args args2, MutableSharedFlow<CollectBankAccountViewEffect> mutableSharedFlow, CreateLinkAccountSession createLinkAccountSession2, AttachLinkAccountSession attachLinkAccountSession2, Logger logger2) {
        Intrinsics.checkNotNullParameter(args2, "args");
        Intrinsics.checkNotNullParameter(mutableSharedFlow, "_viewEffect");
        Intrinsics.checkNotNullParameter(createLinkAccountSession2, "createLinkAccountSession");
        Intrinsics.checkNotNullParameter(attachLinkAccountSession2, "attachLinkAccountSession");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.args = args2;
        this._viewEffect = mutableSharedFlow;
        this.createLinkAccountSession = createLinkAccountSession2;
        this.attachLinkAccountSession = attachLinkAccountSession2;
        this.logger = logger2;
        this.viewEffect = mutableSharedFlow;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final SharedFlow<CollectBankAccountViewEffect> getViewEffect() {
        return this.viewEffect;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel$1", f = "CollectBankAccountViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel$1  reason: invalid class name */
    /* compiled from: CollectBankAccountViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CollectBankAccountViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.createLinkAccountSession(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c5 A[SYNTHETIC, Splitter:B:33:0x00c5] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createLinkAccountSession(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel$createLinkAccountSession$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel$createLinkAccountSession$1 r0 = (com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel$createLinkAccountSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel$createLinkAccountSession$1 r0 = new com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel$createLinkAccountSession$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 4
            r9 = 3
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0057
            if (r1 == r3) goto L_0x0049
            if (r1 == r2) goto L_0x0049
            if (r1 == r9) goto L_0x003e
            if (r1 != r8) goto L_0x0036
            java.lang.Object r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0145
        L_0x0036:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x003e:
            java.lang.Object r1 = r0.L$1
            java.lang.Object r2 = r0.L$0
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r2 = (com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x012a
        L_0x0049:
            java.lang.Object r1 = r0.L$0
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel r1 = (com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel) r1
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result r11 = (kotlin.Result) r11
            java.lang.Object r11 = r11.m4718unboximpl()
            goto L_0x0092
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r11)
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract$Args r11 = r10.args
            com.stripe.android.payments.bankaccount.CollectBankAccountConfiguration r11 = r11.getConfiguration()
            boolean r1 = r11 instanceof com.stripe.android.payments.bankaccount.CollectBankAccountConfiguration.USBankAccount
            if (r1 == 0) goto L_0x0145
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract$Args r1 = r10.args
            boolean r4 = r1 instanceof com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract.Args.ForPaymentIntent
            if (r4 == 0) goto L_0x0094
            com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession r2 = r10.createLinkAccountSession
            java.lang.String r4 = r1.getPublishableKey()
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract$Args r1 = r10.args
            java.lang.String r5 = r1.getClientSecret()
            com.stripe.android.payments.bankaccount.CollectBankAccountConfiguration$USBankAccount r11 = (com.stripe.android.payments.bankaccount.CollectBankAccountConfiguration.USBankAccount) r11
            java.lang.String r6 = r11.getName()
            java.lang.String r11 = r11.getEmail()
            r0.L$0 = r10
            r0.label = r3
            r1 = r2
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r11
            r6 = r0
            java.lang.Object r11 = r1.m4373forPaymentIntentyxL6bBk(r2, r3, r4, r5, r6)
            if (r11 != r7) goto L_0x0091
            return r7
        L_0x0091:
            r1 = r10
        L_0x0092:
            r2 = r1
            goto L_0x00bf
        L_0x0094:
            boolean r3 = r1 instanceof com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract.Args.ForSetupIntent
            if (r3 == 0) goto L_0x013f
            com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession r3 = r10.createLinkAccountSession
            java.lang.String r4 = r1.getPublishableKey()
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract$Args r1 = r10.args
            java.lang.String r5 = r1.getClientSecret()
            com.stripe.android.payments.bankaccount.CollectBankAccountConfiguration$USBankAccount r11 = (com.stripe.android.payments.bankaccount.CollectBankAccountConfiguration.USBankAccount) r11
            java.lang.String r6 = r11.getName()
            java.lang.String r11 = r11.getEmail()
            r0.L$0 = r10
            r0.label = r2
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r11
            r6 = r0
            java.lang.Object r11 = r1.m4374forSetupIntentyxL6bBk(r2, r3, r4, r5, r6)
            if (r11 != r7) goto L_0x0091
            return r7
        L_0x00bf:
            boolean r1 = kotlin.Result.m4716isSuccessimpl(r11)
            if (r1 == 0) goto L_0x00e7
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x00e0 }
            com.stripe.android.model.BankConnectionsLinkedAccountSession r11 = (com.stripe.android.model.BankConnectionsLinkedAccountSession) r11     // Catch:{ all -> 0x00e0 }
            java.lang.String r11 = r11.getClientSecret()     // Catch:{ all -> 0x00e0 }
            if (r11 == 0) goto L_0x00d4
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)     // Catch:{ all -> 0x00e0 }
            goto L_0x00eb
        L_0x00d4:
            java.lang.String r11 = "Required value was null."
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00e0 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00e0 }
            r1.<init>(r11)     // Catch:{ all -> 0x00e0 }
            throw r1     // Catch:{ all -> 0x00e0 }
        L_0x00e0:
            r11 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
        L_0x00e7:
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)
        L_0x00eb:
            r1 = r11
            boolean r11 = kotlin.Result.m4716isSuccessimpl(r1)
            if (r11 == 0) goto L_0x012a
            r11 = r1
            java.lang.String r11 = (java.lang.String) r11
            com.stripe.android.core.Logger r3 = r2.logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Bank account session created! "
            r4.append(r5)
            r4.append(r11)
            r5 = 46
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.debug(r4)
            kotlinx.coroutines.flow.MutableSharedFlow<com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewEffect> r3 = r2._viewEffect
            com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract$Args r4 = r2.args
            java.lang.String r4 = r4.getPublishableKey()
            com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewEffect$OpenConnectionsFlow r5 = new com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewEffect$OpenConnectionsFlow
            r5.<init>(r4, r11)
            r0.L$0 = r2
            r0.L$1 = r1
            r0.label = r9
            java.lang.Object r11 = r3.emit(r5, r0)
            if (r11 != r7) goto L_0x012a
            return r7
        L_0x012a:
            java.lang.Throwable r11 = kotlin.Result.m4712exceptionOrNullimpl(r1)
            if (r11 != 0) goto L_0x0131
            goto L_0x0145
        L_0x0131:
            r0.L$0 = r1
            r1 = 0
            r0.L$1 = r1
            r0.label = r8
            java.lang.Object r11 = r2.finishWithError(r11, r0)
            if (r11 != r7) goto L_0x0145
            return r7
        L_0x013f:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L_0x0145:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel.createLinkAccountSession(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onConnectionsResult(ConnectionsSheetResult connectionsSheetResult) {
        Intrinsics.checkNotNullParameter(connectionsSheetResult, "result");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CollectBankAccountViewModel$onConnectionsResult$1(connectionsSheetResult, this, (Continuation<? super CollectBankAccountViewModel$onConnectionsResult$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object finishWithResult(CollectBankAccountResult collectBankAccountResult, Continuation<? super Unit> continuation) {
        Object emit = this._viewEffect.emit(new CollectBankAccountViewEffect.FinishWithResult(collectBankAccountResult), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void attachLinkAccountSessionToIntent(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CollectBankAccountViewModel$attachLinkAccountSessionToIntent$1(this, str, (Continuation<? super CollectBankAccountViewModel$attachLinkAccountSessionToIntent$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object finishWithError(Throwable th, Continuation<? super Unit> continuation) {
        this.logger.error("Error", new Exception(th));
        Object finishWithResult = finishWithResult(new CollectBankAccountResult.Failed(th), continuation);
        return finishWithResult == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? finishWithResult : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\r0\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewModel$Factory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "applicationSupplier", "Lkotlin/Function0;", "Landroid/app/Application;", "argsSupplier", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectBankAccountViewModel.kt */
    public static final class Factory extends AbstractSavedStateViewModelFactory {
        public static final int $stable = 0;
        private final Function0<Application> applicationSupplier;
        private final Function0<CollectBankAccountContract.Args> argsSupplier;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(Function0 function0, Function0 function02, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, function02, savedStateRegistryOwner, (i & 8) != 0 ? null : bundle);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Factory(Function0<? extends Application> function0, Function0<? extends CollectBankAccountContract.Args> function02, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            super(savedStateRegistryOwner, bundle);
            Intrinsics.checkNotNullParameter(function0, "applicationSupplier");
            Intrinsics.checkNotNullParameter(function02, "argsSupplier");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
            this.applicationSupplier = function0;
            this.argsSupplier = function02;
        }

        /* access modifiers changed from: protected */
        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            return DaggerCollectBankAccountComponent.builder().application(this.applicationSupplier.invoke()).viewEffect(SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null)).configuration(this.argsSupplier.invoke()).build().getViewModel();
        }
    }
}
