package com.stripe.android.stripe3ds2.views;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.stripe.android.stripe3ds2.databinding.StripeChallengeActivityBinding;
import com.stripe.android.stripe3ds2.databinding.StripeChallengeFragmentBinding;
import com.stripe.android.stripe3ds2.init.ui.UiCustomization;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.transaction.ChallengeAction;
import com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import com.stripe.android.stripe3ds2.transaction.ErrorRequestExecutor;
import com.stripe.android.stripe3ds2.transaction.TransactionTimer;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseData;
import com.stripe.android.stripe3ds2.transactions.UiType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 N2\u00020\u0001:\u0001NB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020>H\u0002J\b\u0010@\u001a\u00020>H\u0002J\u0012\u0010A\u001a\u00020>2\b\u0010B\u001a\u0004\u0018\u00010CH\u0014J\b\u0010D\u001a\u00020>H\u0014J\b\u0010E\u001a\u00020>H\u0016J\b\u0010F\u001a\u00020>H\u0014J\b\u0010G\u001a\u00020>H\u0014J\u0010\u0010H\u001a\u00020>2\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020MH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148@X\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198@X\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\b\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\b\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u0010\b\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u0002048@X\u0002¢\u0006\f\n\u0004\b7\u0010\b\u001a\u0004\b5\u00106R\u001b\u00108\u001a\u0002098@X\u0002¢\u0006\f\n\u0004\b<\u0010\b\u001a\u0004\b:\u0010;¨\u0006O"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "challengeActionHandler", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler;", "getChallengeActionHandler", "()Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler;", "challengeActionHandler$delegate", "Lkotlin/Lazy;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "getErrorReporter", "()Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "errorReporter$delegate", "errorRequestExecutor", "Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;", "getErrorRequestExecutor", "()Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;", "errorRequestExecutor$delegate", "fragment", "Lcom/stripe/android/stripe3ds2/views/ChallengeFragment;", "getFragment$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ChallengeFragment;", "fragment$delegate", "fragmentViewBinding", "Lcom/stripe/android/stripe3ds2/databinding/StripeChallengeFragmentBinding;", "getFragmentViewBinding$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/databinding/StripeChallengeFragmentBinding;", "fragmentViewBinding$delegate", "keyboardController", "Lcom/stripe/android/stripe3ds2/views/KeyboardController;", "getKeyboardController", "()Lcom/stripe/android/stripe3ds2/views/KeyboardController;", "keyboardController$delegate", "progressDialog", "Landroid/app/Dialog;", "progressDialogFactory", "Lcom/stripe/android/stripe3ds2/views/ChallengeSubmitDialogFactory;", "getProgressDialogFactory", "()Lcom/stripe/android/stripe3ds2/views/ChallengeSubmitDialogFactory;", "progressDialogFactory$delegate", "transactionTimer", "Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;", "getTransactionTimer", "()Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;", "transactionTimer$delegate", "viewArgs", "Lcom/stripe/android/stripe3ds2/views/ChallengeViewArgs;", "getViewArgs", "()Lcom/stripe/android/stripe3ds2/views/ChallengeViewArgs;", "viewArgs$delegate", "viewBinding", "Lcom/stripe/android/stripe3ds2/databinding/StripeChallengeActivityBinding;", "getViewBinding$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/databinding/StripeChallengeActivityBinding;", "viewBinding$delegate", "viewModel", "Lcom/stripe/android/stripe3ds2/views/ChallengeActivityViewModel;", "getViewModel$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ChallengeActivityViewModel;", "viewModel$delegate", "configureHeaderZone", "", "dismissDialog", "dismissKeyboard", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLowMemory", "onPause", "onResume", "onTrimMemory", "level", "", "startFragment", "cres", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData;", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeActivity.kt */
public final class ChallengeActivity extends AppCompatActivity {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final CoroutineDispatcher WORK_CONTEXT = Dispatchers.getIO();
    private final Lazy challengeActionHandler$delegate = LazyKt.lazy(new ChallengeActivity$challengeActionHandler$2(this));
    private final Lazy errorReporter$delegate = LazyKt.lazy(new ChallengeActivity$errorReporter$2(this));
    private final Lazy errorRequestExecutor$delegate = LazyKt.lazy(new ChallengeActivity$errorRequestExecutor$2(this));
    private final Lazy fragment$delegate = LazyKt.lazy(new ChallengeActivity$fragment$2(this));
    private final Lazy fragmentViewBinding$delegate = LazyKt.lazy(new ChallengeActivity$fragmentViewBinding$2(this));
    private final Lazy keyboardController$delegate = LazyKt.lazy(new ChallengeActivity$keyboardController$2(this));
    private Dialog progressDialog;
    private final Lazy progressDialogFactory$delegate = LazyKt.lazy(new ChallengeActivity$progressDialogFactory$2(this));
    private final Lazy transactionTimer$delegate = LazyKt.lazy(new ChallengeActivity$transactionTimer$2(this));
    private final Lazy viewArgs$delegate = LazyKt.lazy(new ChallengeActivity$viewArgs$2(this));
    private final Lazy viewBinding$delegate = LazyKt.lazy(new ChallengeActivity$viewBinding$2(this));
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ChallengeActivityViewModel.class), new ChallengeActivity$special$$inlined$viewModels$2(this), new ChallengeActivity$viewModel$2(this));

    /* access modifiers changed from: private */
    public final TransactionTimer getTransactionTimer() {
        return (TransactionTimer) this.transactionTimer$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ErrorReporter getErrorReporter() {
        return (ErrorReporter) this.errorReporter$delegate.getValue();
    }

    public final ChallengeFragment getFragment$3ds2sdk_release() {
        return (ChallengeFragment) this.fragment$delegate.getValue();
    }

    public final StripeChallengeFragmentBinding getFragmentViewBinding$3ds2sdk_release() {
        return (StripeChallengeFragmentBinding) this.fragmentViewBinding$delegate.getValue();
    }

    public final StripeChallengeActivityBinding getViewBinding$3ds2sdk_release() {
        return (StripeChallengeActivityBinding) this.viewBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChallengeActionHandler getChallengeActionHandler() {
        return (ChallengeActionHandler) this.challengeActionHandler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ErrorRequestExecutor getErrorRequestExecutor() {
        return (ErrorRequestExecutor) this.errorRequestExecutor$delegate.getValue();
    }

    public final ChallengeActivityViewModel getViewModel$3ds2sdk_release() {
        return (ChallengeActivityViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChallengeViewArgs getViewArgs() {
        return (ChallengeViewArgs) this.viewArgs$delegate.getValue();
    }

    private final KeyboardController getKeyboardController() {
        return (KeyboardController) this.keyboardController$delegate.getValue();
    }

    private final ChallengeSubmitDialogFactory getProgressDialogFactory() {
        return (ChallengeSubmitDialogFactory) this.progressDialogFactory$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getSupportFragmentManager().setFragmentFactory(new ChallengeFragmentFactory(getViewArgs().getUiCustomization$3ds2sdk_release(), getTransactionTimer(), getErrorRequestExecutor(), getErrorReporter(), getChallengeActionHandler(), getViewArgs().getCresData$3ds2sdk_release().getUiType(), getViewArgs().getIntentData$3ds2sdk_release(), WORK_CONTEXT));
        super.onCreate(bundle);
        getOnBackPressedDispatcher().addCallback(new ChallengeActivity$onCreate$1(this));
        getWindow().setFlags(8192, 8192);
        setContentView((View) getViewBinding$3ds2sdk_release().getRoot());
        LifecycleOwner lifecycleOwner = this;
        getViewModel$3ds2sdk_release().getSubmitClicked().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                ChallengeActivity.m4448onCreate$lambda1(ChallengeActivity.this, (ChallengeAction) obj);
            }
        });
        getViewModel$3ds2sdk_release().getShouldFinish().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                ChallengeActivity.m4449onCreate$lambda2(ChallengeActivity.this, (ChallengeResult) obj);
            }
        });
        configureHeaderZone();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        getViewModel$3ds2sdk_release().getNextScreen().observe(lifecycleOwner, new Observer(objectRef) {
            public final /* synthetic */ Ref.ObjectRef f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                ChallengeActivity.m4450onCreate$lambda3(ChallengeActivity.this, this.f$1, (ChallengeResponseData) obj);
            }
        });
        if (bundle == null) {
            getViewModel$3ds2sdk_release().onNextScreen(getViewArgs().getCresData$3ds2sdk_release());
        }
        getViewModel$3ds2sdk_release().getTimeout().observe(lifecycleOwner, new Observer(objectRef) {
            public final /* synthetic */ Ref.ObjectRef f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                ChallengeActivity.m4451onCreate$lambda4(ChallengeActivity.this, this.f$1, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m4448onCreate$lambda1(ChallengeActivity challengeActivity, ChallengeAction challengeAction) {
        Intrinsics.checkNotNullParameter(challengeActivity, "this$0");
        if (!challengeActivity.isFinishing()) {
            challengeActivity.dismissKeyboard();
            Dialog create = challengeActivity.getProgressDialogFactory().create();
            create.show();
            challengeActivity.progressDialog = create;
            ChallengeActivityViewModel viewModel$3ds2sdk_release = challengeActivity.getViewModel$3ds2sdk_release();
            Intrinsics.checkNotNullExpressionValue(challengeAction, "challengeAction");
            viewModel$3ds2sdk_release.submit(challengeAction);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m4449onCreate$lambda2(ChallengeActivity challengeActivity, ChallengeResult challengeResult) {
        Intrinsics.checkNotNullParameter(challengeActivity, "this$0");
        challengeActivity.setResult(-1, new Intent().putExtras(challengeResult.toBundle$3ds2sdk_release()));
        if (!challengeActivity.isFinishing()) {
            challengeActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m4450onCreate$lambda3(ChallengeActivity challengeActivity, Ref.ObjectRef objectRef, ChallengeResponseData challengeResponseData) {
        Intrinsics.checkNotNullParameter(challengeActivity, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$uiTypeCode");
        challengeActivity.dismissDialog();
        if (challengeResponseData != null) {
            challengeActivity.startFragment(challengeResponseData);
            UiType uiType = challengeResponseData.getUiType();
            T code = uiType == null ? null : uiType.getCode();
            if (code == null) {
                code = "";
            }
            objectRef.element = code;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    public static final void m4451onCreate$lambda4(ChallengeActivity challengeActivity, Ref.ObjectRef objectRef, Boolean bool) {
        Intrinsics.checkNotNullParameter(challengeActivity, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$uiTypeCode");
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            challengeActivity.getViewModel$3ds2sdk_release().onFinish(new ChallengeResult.Timeout((String) objectRef.element, challengeActivity.getViewArgs().getCresData$3ds2sdk_release().getUiType(), challengeActivity.getViewArgs().getIntentData$3ds2sdk_release()));
        }
    }

    private final void startFragment(ChallengeResponseData challengeResponseData) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        beginTransaction.setCustomAnimations(AnimationConstants.INSTANCE.getSLIDE_IN(), AnimationConstants.INSTANCE.getSLIDE_OUT(), AnimationConstants.INSTANCE.getSLIDE_IN(), AnimationConstants.INSTANCE.getSLIDE_OUT());
        beginTransaction.replace(getViewBinding$3ds2sdk_release().fragmentContainer.getId(), (Class<? extends Fragment>) ChallengeFragment.class, BundleKt.bundleOf(TuplesKt.to(ChallengeFragment.ARG_CRES, challengeResponseData)));
        beginTransaction.commit();
    }

    public void onLowMemory() {
        super.onLowMemory();
        getViewModel$3ds2sdk_release().onMemoryEvent();
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        getViewModel$3ds2sdk_release().onMemoryEvent();
    }

    private final void dismissKeyboard() {
        getKeyboardController().hide();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        getViewModel$3ds2sdk_release().setShouldRefreshUi(true);
        dismissKeyboard();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (getViewModel$3ds2sdk_release().getShouldRefreshUi()) {
            getViewModel$3ds2sdk_release().onRefreshUi();
        }
    }

    private final void configureHeaderZone() {
        ThreeDS2Button customize = new HeaderZoneCustomizer(this).customize(getViewArgs().getUiCustomization$3ds2sdk_release().getToolbarCustomization(), getViewArgs().getUiCustomization$3ds2sdk_release().getButtonCustomization(UiCustomization.ButtonType.CANCEL));
        if (customize != null) {
            customize.setOnClickListener(new View.OnClickListener(this) {
                public final /* synthetic */ ChallengeActivity f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ChallengeActivity.m4446configureHeaderZone$lambda6(ThreeDS2Button.this, this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: configureHeaderZone$lambda-6  reason: not valid java name */
    public static final void m4446configureHeaderZone$lambda6(ThreeDS2Button threeDS2Button, ChallengeActivity challengeActivity, View view) {
        Intrinsics.checkNotNullParameter(challengeActivity, "this$0");
        threeDS2Button.setClickable(false);
        challengeActivity.getViewModel$3ds2sdk_release().submit(ChallengeAction.Cancel.INSTANCE);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        dismissDialog();
    }

    private final void dismissDialog() {
        Dialog dialog = this.progressDialog;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        this.progressDialog = null;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeActivity$Companion;", "", "()V", "WORK_CONTEXT", "Lkotlinx/coroutines/CoroutineDispatcher;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeActivity.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
