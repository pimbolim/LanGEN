package com.stripe.android.stripe3ds2.views;

import android.graphics.Bitmap;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.transaction.ChallengeAction;
import com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler;
import com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import com.stripe.android.stripe3ds2.transaction.TransactionTimer;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseData;
import com.stripe.android.stripe3ds2.utils.ImageCache;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001:\u0002IJB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ \u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u001c2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u001cJ\u000e\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u0018J\u0006\u0010>\u001a\u00020\u0016J\u000e\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u0014J\u0006\u0010A\u001a\u00020\u0016J\u000e\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u001aJ\u0006\u0010D\u001a\u00020\u0016J\u000e\u0010E\u001a\u00020\u00162\u0006\u0010F\u001a\u00020\u001aJ\u000e\u0010G\u001a\u00020\u00162\u0006\u0010H\u001a\u00020\u0012R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u001c¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u001a\u0010)\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u000202X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006K"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "challengeActionHandler", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler;", "transactionTimer", "Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "imageCache", "Lcom/stripe/android/stripe3ds2/utils/ImageCache;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler;Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lcom/stripe/android/stripe3ds2/utils/ImageCache;Lkotlin/coroutines/CoroutineContext;)V", "_challengeRequestResult", "Lcom/stripe/android/stripe3ds2/views/ChallengeActivityViewModel$OnInactiveAwareMutableLiveData;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "_challengeText", "Landroidx/lifecycle/MutableLiveData;", "", "_nextScreen", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData;", "_refreshUi", "", "_shouldFinish", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "_submitClicked", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "challengeRequestResult", "Landroidx/lifecycle/LiveData;", "getChallengeRequestResult", "()Landroidx/lifecycle/LiveData;", "challengeText", "getChallengeText", "imageRepository", "Lcom/stripe/android/stripe3ds2/views/ImageRepository;", "nextScreen", "getNextScreen", "refreshUi", "getRefreshUi", "shouldFinish", "getShouldFinish", "shouldRefreshUi", "", "getShouldRefreshUi", "()Z", "setShouldRefreshUi", "(Z)V", "submitClicked", "getSubmitClicked", "transactionTimerJob", "Lkotlinx/coroutines/Job;", "getTransactionTimerJob$3ds2sdk_release", "()Lkotlinx/coroutines/Job;", "getImage", "Landroid/graphics/Bitmap;", "imageData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData$Image;", "densityDpi", "", "getTimeout", "onFinish", "challengeResult", "onMemoryEvent", "onNextScreen", "cres", "onRefreshUi", "onSubmitClicked", "challengeAction", "stopTimer", "submit", "action", "updateChallengeText", "text", "Factory", "OnInactiveAwareMutableLiveData", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeActivityViewModel.kt */
public final class ChallengeActivityViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final OnInactiveAwareMutableLiveData<ChallengeRequestResult> _challengeRequestResult;
    private final MutableLiveData<String> _challengeText;
    private final OnInactiveAwareMutableLiveData<ChallengeResponseData> _nextScreen;
    private final MutableLiveData<Unit> _refreshUi;
    private final MutableLiveData<ChallengeResult> _shouldFinish;
    private final MutableLiveData<ChallengeAction> _submitClicked;
    /* access modifiers changed from: private */
    public final ChallengeActionHandler challengeActionHandler;
    private final LiveData<ChallengeRequestResult> challengeRequestResult;
    private final LiveData<String> challengeText;
    private final ImageCache imageCache;
    /* access modifiers changed from: private */
    public final ImageRepository imageRepository;
    private final LiveData<ChallengeResponseData> nextScreen;
    private final LiveData<Unit> refreshUi;
    private final LiveData<ChallengeResult> shouldFinish;
    private boolean shouldRefreshUi;
    private final LiveData<ChallengeAction> submitClicked;
    /* access modifiers changed from: private */
    public final TransactionTimer transactionTimer;
    private final Job transactionTimerJob;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChallengeActivityViewModel(ChallengeActionHandler challengeActionHandler2, TransactionTimer transactionTimer2, ErrorReporter errorReporter, ImageCache imageCache2, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(challengeActionHandler2, transactionTimer2, errorReporter, (i & 8) != 0 ? ImageCache.Default.INSTANCE : imageCache2, coroutineContext);
    }

    public ChallengeActivityViewModel(ChallengeActionHandler challengeActionHandler2, TransactionTimer transactionTimer2, ErrorReporter errorReporter, ImageCache imageCache2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(challengeActionHandler2, "challengeActionHandler");
        Intrinsics.checkNotNullParameter(transactionTimer2, "transactionTimer");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics.checkNotNullParameter(imageCache2, "imageCache");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.challengeActionHandler = challengeActionHandler2;
        this.transactionTimer = transactionTimer2;
        this.imageCache = imageCache2;
        this.imageRepository = new ImageRepository(errorReporter, coroutineContext);
        MutableLiveData<Unit> mutableLiveData = new MutableLiveData<>();
        this._refreshUi = mutableLiveData;
        this.refreshUi = mutableLiveData;
        MutableLiveData<ChallengeAction> mutableLiveData2 = new MutableLiveData<>();
        this._submitClicked = mutableLiveData2;
        this.submitClicked = mutableLiveData2;
        MutableLiveData<ChallengeResult> mutableLiveData3 = new MutableLiveData<>();
        this._shouldFinish = mutableLiveData3;
        this.shouldFinish = mutableLiveData3;
        MutableLiveData<String> mutableLiveData4 = new MutableLiveData<>();
        this._challengeText = mutableLiveData4;
        this.challengeText = mutableLiveData4;
        OnInactiveAwareMutableLiveData<ChallengeRequestResult> onInactiveAwareMutableLiveData = new OnInactiveAwareMutableLiveData<>();
        this._challengeRequestResult = onInactiveAwareMutableLiveData;
        this.challengeRequestResult = onInactiveAwareMutableLiveData;
        OnInactiveAwareMutableLiveData<ChallengeResponseData> onInactiveAwareMutableLiveData2 = new OnInactiveAwareMutableLiveData<>();
        this._nextScreen = onInactiveAwareMutableLiveData2;
        this.nextScreen = onInactiveAwareMutableLiveData2;
        this.transactionTimerJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final LiveData<Unit> getRefreshUi() {
        return this.refreshUi;
    }

    public final LiveData<ChallengeAction> getSubmitClicked() {
        return this.submitClicked;
    }

    public final LiveData<ChallengeResult> getShouldFinish() {
        return this.shouldFinish;
    }

    public final LiveData<String> getChallengeText() {
        return this.challengeText;
    }

    public final LiveData<ChallengeRequestResult> getChallengeRequestResult() {
        return this.challengeRequestResult;
    }

    public final LiveData<ChallengeResponseData> getNextScreen() {
        return this.nextScreen;
    }

    public final boolean getShouldRefreshUi() {
        return this.shouldRefreshUi;
    }

    public final void setShouldRefreshUi(boolean z) {
        this.shouldRefreshUi = z;
    }

    public final Job getTransactionTimerJob$3ds2sdk_release() {
        return this.transactionTimerJob;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.stripe3ds2.views.ChallengeActivityViewModel$1", f = "ChallengeActivityViewModel.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.stripe3ds2.views.ChallengeActivityViewModel$1  reason: invalid class name */
    /* compiled from: ChallengeActivityViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChallengeActivityViewModel this$0;

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
                if (this.this$0.transactionTimer.start(this) == coroutine_suspended) {
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

    public final LiveData<Boolean> getTimeout() {
        return CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0, (Function2) new ChallengeActivityViewModel$getTimeout$1(this, (Continuation<? super ChallengeActivityViewModel$getTimeout$1>) null), 3, (Object) null);
    }

    public final LiveData<Bitmap> getImage(ChallengeResponseData.Image image, int i) {
        return CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0, (Function2) new ChallengeActivityViewModel$getImage$1(this, image, i, (Continuation<? super ChallengeActivityViewModel$getImage$1>) null), 3, (Object) null);
    }

    public final void submit(ChallengeAction challengeAction) {
        Intrinsics.checkNotNullParameter(challengeAction, "action");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChallengeActivityViewModel$submit$1(this, challengeAction, (Continuation<? super ChallengeActivityViewModel$submit$1>) null), 3, (Object) null);
    }

    public final void stopTimer() {
        Job.DefaultImpls.cancel$default(this.transactionTimerJob, (CancellationException) null, 1, (Object) null);
    }

    public final void onMemoryEvent() {
        this.imageCache.clear();
    }

    public final void onRefreshUi() {
        this._refreshUi.setValue(Unit.INSTANCE);
    }

    public final void onSubmitClicked(ChallengeAction challengeAction) {
        Intrinsics.checkNotNullParameter(challengeAction, "challengeAction");
        this._submitClicked.postValue(challengeAction);
    }

    public final void onFinish(ChallengeResult challengeResult) {
        Intrinsics.checkNotNullParameter(challengeResult, "challengeResult");
        this._shouldFinish.postValue(challengeResult);
    }

    public final void updateChallengeText(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this._challengeText.setValue(str);
    }

    public final void onNextScreen(ChallengeResponseData challengeResponseData) {
        Intrinsics.checkNotNullParameter(challengeResponseData, "cres");
        this._nextScreen.setValue(challengeResponseData);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeActivityViewModel$OnInactiveAwareMutableLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "()V", "onInactive", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeActivityViewModel.kt */
    private static final class OnInactiveAwareMutableLiveData<T> extends MutableLiveData<T> {
        /* access modifiers changed from: protected */
        public void onInactive() {
            super.onInactive();
            setValue(null);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeActivityViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "challengeActionHandler", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler;", "transactionTimer", "Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler;Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lkotlin/coroutines/CoroutineContext;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeActivityViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory {
        private final ChallengeActionHandler challengeActionHandler;
        private final ErrorReporter errorReporter;
        private final TransactionTimer transactionTimer;
        private final CoroutineContext workContext;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(ChallengeActionHandler challengeActionHandler2, TransactionTimer transactionTimer2, ErrorReporter errorReporter2, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(challengeActionHandler2, "challengeActionHandler");
            Intrinsics.checkNotNullParameter(transactionTimer2, "transactionTimer");
            Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
            Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
            this.challengeActionHandler = challengeActionHandler2;
            this.transactionTimer = transactionTimer2;
            this.errorReporter = errorReporter2;
            this.workContext = coroutineContext;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            return (ViewModel) new ChallengeActivityViewModel(this.challengeActionHandler, this.transactionTimer, this.errorReporter, (ImageCache) null, this.workContext, 8, (DefaultConstructorMarker) null);
        }
    }
}
