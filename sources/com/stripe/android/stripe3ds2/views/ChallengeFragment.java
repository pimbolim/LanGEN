package com.stripe.android.stripe3ds2.views;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.stripe.android.stripe3ds2.R;
import com.stripe.android.stripe3ds2.databinding.StripeChallengeFragmentBinding;
import com.stripe.android.stripe3ds2.init.ui.ButtonCustomization;
import com.stripe.android.stripe3ds2.init.ui.LabelCustomization;
import com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization;
import com.stripe.android.stripe3ds2.init.ui.UiCustomization;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.transaction.ChallengeAction;
import com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler;
import com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import com.stripe.android.stripe3ds2.transaction.ErrorRequestExecutor;
import com.stripe.android.stripe3ds2.transaction.IntentData;
import com.stripe.android.stripe3ds2.transaction.TransactionTimer;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseData;
import com.stripe.android.stripe3ds2.transactions.ErrorData;
import com.stripe.android.stripe3ds2.transactions.UiType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 b2\u00020\u0001:\u0001bBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0006\u0010I\u001a\u00020JJ&\u0010K\u001a\u00020J2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u0010L\u001a\u00020JH\u0002J\b\u0010M\u001a\u00020JH\u0002J\u0010\u0010N\u001a\u00020J2\u0006\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u00020JH\u0016J\u0010\u0010R\u001a\u00020J2\u0006\u0010S\u001a\u00020TH\u0002J\u0010\u0010R\u001a\u00020J2\u0006\u0010U\u001a\u00020VH\u0002J\u0018\u0010W\u001a\u00020J2\u0006\u0010X\u001a\u00020Y2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010Z\u001a\u00020J2\u0006\u0010S\u001a\u00020TH\u0002J\u001a\u0010[\u001a\u00020J2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0006\u0010`\u001a\u00020JJ\b\u0010a\u001a\u00020JH\u0002R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8@X\u0002¢\u0006\f\n\u0004\b(\u0010\u001a\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8@X\u0002¢\u0006\f\n\u0004\b-\u0010\u001a\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u0010\u001a\u001a\u0004\b0\u00101R\u001d\u00103\u001a\u0004\u0018\u0001048@X\u0002¢\u0006\f\n\u0004\b7\u0010\u001a\u001a\u0004\b5\u00106R\u000e\u00108\u001a\u000209X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0002¢\u0006\f\n\u0004\b>\u0010\u001a\u001a\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020;8AX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010=R\u0014\u0010A\u001a\u00020\u00148@X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001b\u0010D\u001a\u00020E8@X\u0002¢\u0006\f\n\u0004\bH\u0010\u001a\u001a\u0004\bF\u0010GR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeFragment;", "Landroidx/fragment/app/Fragment;", "uiCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;", "transactionTimer", "Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;", "errorRequestExecutor", "Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "challengeActionHandler", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler;", "initialUiType", "Lcom/stripe/android/stripe3ds2/transactions/UiType;", "intentData", "Lcom/stripe/android/stripe3ds2/transaction/IntentData;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;Lcom/stripe/android/stripe3ds2/transaction/TransactionTimer;Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lcom/stripe/android/stripe3ds2/transaction/ChallengeActionHandler;Lcom/stripe/android/stripe3ds2/transactions/UiType;Lcom/stripe/android/stripe3ds2/transaction/IntentData;Lkotlin/coroutines/CoroutineContext;)V", "_viewBinding", "Lcom/stripe/android/stripe3ds2/databinding/StripeChallengeFragmentBinding;", "brandZoneView", "Lcom/stripe/android/stripe3ds2/views/BrandZoneView;", "getBrandZoneView", "()Lcom/stripe/android/stripe3ds2/views/BrandZoneView;", "brandZoneView$delegate", "Lkotlin/Lazy;", "challengeAction", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "getChallengeAction", "()Lcom/stripe/android/stripe3ds2/transaction/ChallengeAction;", "challengeEntryViewFactory", "Lcom/stripe/android/stripe3ds2/views/ChallengeEntryViewFactory;", "getChallengeEntryViewFactory", "()Lcom/stripe/android/stripe3ds2/views/ChallengeEntryViewFactory;", "challengeEntryViewFactory$delegate", "challengeZoneSelectView", "Lcom/stripe/android/stripe3ds2/views/ChallengeZoneSelectView;", "getChallengeZoneSelectView$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ChallengeZoneSelectView;", "challengeZoneSelectView$delegate", "challengeZoneTextView", "Lcom/stripe/android/stripe3ds2/views/ChallengeZoneTextView;", "getChallengeZoneTextView$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ChallengeZoneTextView;", "challengeZoneTextView$delegate", "challengeZoneView", "Lcom/stripe/android/stripe3ds2/views/ChallengeZoneView;", "getChallengeZoneView", "()Lcom/stripe/android/stripe3ds2/views/ChallengeZoneView;", "challengeZoneView$delegate", "challengeZoneWebView", "Lcom/stripe/android/stripe3ds2/views/ChallengeZoneWebView;", "getChallengeZoneWebView$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ChallengeZoneWebView;", "challengeZoneWebView$delegate", "cresData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeResponseData;", "uiTypeCode", "", "getUiTypeCode", "()Ljava/lang/String;", "uiTypeCode$delegate", "userEntry", "getUserEntry$3ds2sdk_release", "viewBinding", "getViewBinding$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/databinding/StripeChallengeFragmentBinding;", "viewModel", "Lcom/stripe/android/stripe3ds2/views/ChallengeActivityViewModel;", "getViewModel$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ChallengeActivityViewModel;", "viewModel$delegate", "clickSubmitButton", "", "configure", "configureChallengeZoneView", "configureInformationZoneView", "onChallengeRequestResult", "result", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "onDestroyView", "onError", "data", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "throwable", "", "onSuccess", "creqData", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "onTimeout", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "refreshUi", "updateBrandZoneImages", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeFragment.kt */
public final class ChallengeFragment extends Fragment {
    public static final String ARG_CRES = "arg_cres";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private StripeChallengeFragmentBinding _viewBinding;
    private final Lazy brandZoneView$delegate;
    /* access modifiers changed from: private */
    public final ChallengeActionHandler challengeActionHandler;
    private final Lazy challengeEntryViewFactory$delegate;
    private final Lazy challengeZoneSelectView$delegate;
    private final Lazy challengeZoneTextView$delegate;
    private final Lazy challengeZoneView$delegate;
    private final Lazy challengeZoneWebView$delegate;
    /* access modifiers changed from: private */
    public ChallengeResponseData cresData;
    /* access modifiers changed from: private */
    public final ErrorReporter errorReporter;
    private final ErrorRequestExecutor errorRequestExecutor;
    private final UiType initialUiType;
    private final IntentData intentData;
    /* access modifiers changed from: private */
    public final TransactionTimer transactionTimer;
    /* access modifiers changed from: private */
    public final StripeUiCustomization uiCustomization;
    private final Lazy uiTypeCode$delegate = LazyKt.lazy(new ChallengeFragment$uiTypeCode$2(this));
    private final Lazy viewModel$delegate;
    /* access modifiers changed from: private */
    public final CoroutineContext workContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UiType.values().length];
            iArr[UiType.Text.ordinal()] = 1;
            iArr[UiType.SingleSelect.ordinal()] = 2;
            iArr[UiType.MultiSelect.ordinal()] = 3;
            iArr[UiType.Html.ordinal()] = 4;
            iArr[UiType.OutOfBand.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChallengeFragment(StripeUiCustomization stripeUiCustomization, TransactionTimer transactionTimer2, ErrorRequestExecutor errorRequestExecutor2, ErrorReporter errorReporter2, ChallengeActionHandler challengeActionHandler2, UiType uiType, IntentData intentData2, CoroutineContext coroutineContext) {
        super(R.layout.stripe_challenge_fragment);
        Intrinsics.checkNotNullParameter(stripeUiCustomization, "uiCustomization");
        Intrinsics.checkNotNullParameter(transactionTimer2, "transactionTimer");
        Intrinsics.checkNotNullParameter(errorRequestExecutor2, "errorRequestExecutor");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(challengeActionHandler2, "challengeActionHandler");
        Intrinsics.checkNotNullParameter(intentData2, "intentData");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.uiCustomization = stripeUiCustomization;
        this.transactionTimer = transactionTimer2;
        this.errorRequestExecutor = errorRequestExecutor2;
        this.errorReporter = errorReporter2;
        this.challengeActionHandler = challengeActionHandler2;
        this.initialUiType = uiType;
        this.intentData = intentData2;
        this.workContext = coroutineContext;
        Fragment fragment = this;
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ChallengeActivityViewModel.class), new ChallengeFragment$special$$inlined$activityViewModels$1(fragment), new ChallengeFragment$viewModel$2(this));
        this.challengeEntryViewFactory$delegate = LazyKt.lazy(new ChallengeFragment$challengeEntryViewFactory$2(this));
        this.challengeZoneView$delegate = LazyKt.lazy(new ChallengeFragment$challengeZoneView$2(this));
        this.brandZoneView$delegate = LazyKt.lazy(new ChallengeFragment$brandZoneView$2(this));
        this.challengeZoneTextView$delegate = LazyKt.lazy(new ChallengeFragment$challengeZoneTextView$2(this));
        this.challengeZoneSelectView$delegate = LazyKt.lazy(new ChallengeFragment$challengeZoneSelectView$2(this));
        this.challengeZoneWebView$delegate = LazyKt.lazy(new ChallengeFragment$challengeZoneWebView$2(this));
    }

    private final String getUiTypeCode() {
        return (String) this.uiTypeCode$delegate.getValue();
    }

    public final ChallengeActivityViewModel getViewModel$3ds2sdk_release() {
        return (ChallengeActivityViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChallengeEntryViewFactory getChallengeEntryViewFactory() {
        return (ChallengeEntryViewFactory) this.challengeEntryViewFactory$delegate.getValue();
    }

    public final StripeChallengeFragmentBinding getViewBinding$3ds2sdk_release() {
        StripeChallengeFragmentBinding stripeChallengeFragmentBinding = this._viewBinding;
        if (stripeChallengeFragmentBinding != null) {
            return stripeChallengeFragmentBinding;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final ChallengeZoneView getChallengeZoneView() {
        return (ChallengeZoneView) this.challengeZoneView$delegate.getValue();
    }

    private final BrandZoneView getBrandZoneView() {
        return (BrandZoneView) this.brandZoneView$delegate.getValue();
    }

    public final ChallengeZoneTextView getChallengeZoneTextView$3ds2sdk_release() {
        return (ChallengeZoneTextView) this.challengeZoneTextView$delegate.getValue();
    }

    public final ChallengeZoneSelectView getChallengeZoneSelectView$3ds2sdk_release() {
        return (ChallengeZoneSelectView) this.challengeZoneSelectView$delegate.getValue();
    }

    public final ChallengeZoneWebView getChallengeZoneWebView$3ds2sdk_release() {
        return (ChallengeZoneWebView) this.challengeZoneWebView$delegate.getValue();
    }

    public final String getUserEntry$3ds2sdk_release() {
        ChallengeResponseData challengeResponseData = this.cresData;
        String str = null;
        if (challengeResponseData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData = null;
        }
        UiType uiType = challengeResponseData.getUiType();
        int i = uiType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[uiType.ordinal()];
        if (i == 1) {
            ChallengeZoneTextView challengeZoneTextView$3ds2sdk_release = getChallengeZoneTextView$3ds2sdk_release();
            if (challengeZoneTextView$3ds2sdk_release != null) {
                str = challengeZoneTextView$3ds2sdk_release.getUserEntry();
            }
        } else if (i == 2 || i == 3) {
            ChallengeZoneSelectView challengeZoneSelectView$3ds2sdk_release = getChallengeZoneSelectView$3ds2sdk_release();
            if (challengeZoneSelectView$3ds2sdk_release != null) {
                str = challengeZoneSelectView$3ds2sdk_release.getUserEntry();
            }
        } else if (i != 4) {
            str = "";
        } else {
            ChallengeZoneWebView challengeZoneWebView$3ds2sdk_release = getChallengeZoneWebView$3ds2sdk_release();
            if (challengeZoneWebView$3ds2sdk_release != null) {
                str = challengeZoneWebView$3ds2sdk_release.getUserEntry();
            }
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final ChallengeAction getChallengeAction() {
        ChallengeResponseData challengeResponseData = this.cresData;
        if (challengeResponseData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData = null;
        }
        UiType uiType = challengeResponseData.getUiType();
        int i = uiType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[uiType.ordinal()];
        if (i == 4) {
            return new ChallengeAction.HtmlForm(getUserEntry$3ds2sdk_release());
        }
        if (i != 5) {
            return new ChallengeAction.NativeForm(getUserEntry$3ds2sdk_release());
        }
        return ChallengeAction.Oob.INSTANCE;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        ChallengeResponseData challengeResponseData = arguments == null ? null : (ChallengeResponseData) arguments.getParcelable(ARG_CRES);
        if (challengeResponseData == null) {
            onError((Throwable) new IllegalArgumentException("Could not start challenge screen. Challenge response data was null."));
            return;
        }
        this.cresData = challengeResponseData;
        this._viewBinding = StripeChallengeFragmentBinding.bind(view);
        getViewModel$3ds2sdk_release().getChallengeText().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                ChallengeFragment.m4457onViewCreated$lambda0(ChallengeFragment.this, (String) obj);
            }
        });
        getViewModel$3ds2sdk_release().getRefreshUi().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                ChallengeFragment.m4458onViewCreated$lambda1(ChallengeFragment.this, (Unit) obj);
            }
        });
        getViewModel$3ds2sdk_release().getChallengeRequestResult().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                ChallengeFragment.m4459onViewCreated$lambda2(ChallengeFragment.this, (ChallengeRequestResult) obj);
            }
        });
        updateBrandZoneImages();
        configure(getChallengeZoneTextView$3ds2sdk_release(), getChallengeZoneSelectView$3ds2sdk_release(), getChallengeZoneWebView$3ds2sdk_release());
        configureInformationZoneView();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m4457onViewCreated$lambda0(ChallengeFragment challengeFragment, String str) {
        Intrinsics.checkNotNullParameter(challengeFragment, "this$0");
        ChallengeZoneTextView challengeZoneTextView$3ds2sdk_release = challengeFragment.getChallengeZoneTextView$3ds2sdk_release();
        if (challengeZoneTextView$3ds2sdk_release != null) {
            Intrinsics.checkNotNullExpressionValue(str, "challengeText");
            challengeZoneTextView$3ds2sdk_release.setText(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m4458onViewCreated$lambda1(ChallengeFragment challengeFragment, Unit unit) {
        Intrinsics.checkNotNullParameter(challengeFragment, "this$0");
        challengeFragment.refreshUi();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m4459onViewCreated$lambda2(ChallengeFragment challengeFragment, ChallengeRequestResult challengeRequestResult) {
        Intrinsics.checkNotNullParameter(challengeFragment, "this$0");
        if (challengeRequestResult != null) {
            challengeFragment.onChallengeRequestResult(challengeRequestResult);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._viewBinding = null;
    }

    private final void configure(ChallengeZoneTextView challengeZoneTextView, ChallengeZoneSelectView challengeZoneSelectView, ChallengeZoneWebView challengeZoneWebView) {
        ChallengeResponseData challengeResponseData = null;
        if (challengeZoneTextView != null) {
            getChallengeZoneView().setChallengeEntryView(challengeZoneTextView);
            ChallengeZoneView challengeZoneView = getChallengeZoneView();
            ChallengeResponseData challengeResponseData2 = this.cresData;
            if (challengeResponseData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cresData");
                challengeResponseData2 = null;
            }
            challengeZoneView.setSubmitButton(challengeResponseData2.getSubmitAuthenticationLabel(), this.uiCustomization.getButtonCustomization(UiCustomization.ButtonType.SUBMIT));
            ChallengeZoneView challengeZoneView2 = getChallengeZoneView();
            ChallengeResponseData challengeResponseData3 = this.cresData;
            if (challengeResponseData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cresData");
            } else {
                challengeResponseData = challengeResponseData3;
            }
            challengeZoneView2.setResendButtonLabel(challengeResponseData.getResendInformationLabel(), this.uiCustomization.getButtonCustomization(UiCustomization.ButtonType.RESEND));
        } else if (challengeZoneSelectView != null) {
            getChallengeZoneView().setChallengeEntryView(challengeZoneSelectView);
            ChallengeZoneView challengeZoneView3 = getChallengeZoneView();
            ChallengeResponseData challengeResponseData4 = this.cresData;
            if (challengeResponseData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cresData");
                challengeResponseData4 = null;
            }
            challengeZoneView3.setSubmitButton(challengeResponseData4.getSubmitAuthenticationLabel(), this.uiCustomization.getButtonCustomization(UiCustomization.ButtonType.NEXT));
            ChallengeZoneView challengeZoneView4 = getChallengeZoneView();
            ChallengeResponseData challengeResponseData5 = this.cresData;
            if (challengeResponseData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cresData");
            } else {
                challengeResponseData = challengeResponseData5;
            }
            challengeZoneView4.setResendButtonLabel(challengeResponseData.getResendInformationLabel(), this.uiCustomization.getButtonCustomization(UiCustomization.ButtonType.RESEND));
        } else if (challengeZoneWebView != null) {
            getChallengeZoneView().setChallengeEntryView(challengeZoneWebView);
            getChallengeZoneView().setInfoHeaderText((String) null, (LabelCustomization) null);
            getChallengeZoneView().setInfoText((String) null, (LabelCustomization) null);
            getChallengeZoneView().setSubmitButton((String) null, (ButtonCustomization) null);
            challengeZoneWebView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    ChallengeFragment.m4452configure$lambda3(ChallengeFragment.this, view);
                }
            });
            getBrandZoneView().setVisibility(8);
        } else {
            ChallengeResponseData challengeResponseData6 = this.cresData;
            if (challengeResponseData6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cresData");
                challengeResponseData6 = null;
            }
            if (challengeResponseData6.getUiType() == UiType.OutOfBand) {
                ChallengeZoneView challengeZoneView5 = getChallengeZoneView();
                ChallengeResponseData challengeResponseData7 = this.cresData;
                if (challengeResponseData7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cresData");
                } else {
                    challengeResponseData = challengeResponseData7;
                }
                challengeZoneView5.setSubmitButton(challengeResponseData.getOobContinueLabel(), this.uiCustomization.getButtonCustomization(UiCustomization.ButtonType.CONTINUE));
            }
        }
        configureChallengeZoneView();
    }

    /* access modifiers changed from: private */
    /* renamed from: configure$lambda-3  reason: not valid java name */
    public static final void m4452configure$lambda3(ChallengeFragment challengeFragment, View view) {
        Intrinsics.checkNotNullParameter(challengeFragment, "this$0");
        challengeFragment.getViewModel$3ds2sdk_release().onSubmitClicked(challengeFragment.getChallengeAction());
    }

    private final void updateBrandZoneImages() {
        BrandZoneView brandZoneView = getViewBinding$3ds2sdk_release().caBrandZone;
        Intrinsics.checkNotNullExpressionValue(brandZoneView, "viewBinding.caBrandZone");
        Pair[] pairArr = new Pair[2];
        ImageView issuerImageView$3ds2sdk_release = brandZoneView.getIssuerImageView$3ds2sdk_release();
        ChallengeResponseData challengeResponseData = this.cresData;
        ChallengeResponseData challengeResponseData2 = null;
        if (challengeResponseData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData = null;
        }
        pairArr[0] = TuplesKt.to(issuerImageView$3ds2sdk_release, challengeResponseData.getIssuerImage());
        ImageView paymentSystemImageView$3ds2sdk_release = brandZoneView.getPaymentSystemImageView$3ds2sdk_release();
        ChallengeResponseData challengeResponseData3 = this.cresData;
        if (challengeResponseData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
        } else {
            challengeResponseData2 = challengeResponseData3;
        }
        pairArr[1] = TuplesKt.to(paymentSystemImageView$3ds2sdk_release, challengeResponseData2.getPaymentSystemImage());
        for (Map.Entry entry : MapsKt.mapOf(pairArr).entrySet()) {
            getViewModel$3ds2sdk_release().getImage((ChallengeResponseData.Image) entry.getValue(), getResources().getDisplayMetrics().densityDpi).observe(getViewLifecycleOwner(), new Observer((ImageView) entry.getKey()) {
                public final /* synthetic */ ImageView f$0;

                {
                    this.f$0 = r1;
                }

                public final void onChanged(Object obj) {
                    ChallengeFragment.m4460updateBrandZoneImages$lambda5$lambda4(this.f$0, (Bitmap) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateBrandZoneImages$lambda-5$lambda-4  reason: not valid java name */
    public static final void m4460updateBrandZoneImages$lambda5$lambda4(ImageView imageView, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        if (bitmap != null) {
            imageView.setVisibility(0);
            imageView.setImageBitmap(bitmap);
            return;
        }
        imageView.setVisibility(8);
    }

    private final void configureInformationZoneView() {
        InformationZoneView informationZoneView = getViewBinding$3ds2sdk_release().caInformationZone;
        Intrinsics.checkNotNullExpressionValue(informationZoneView, "viewBinding.caInformationZone");
        ChallengeResponseData challengeResponseData = this.cresData;
        ChallengeResponseData challengeResponseData2 = null;
        if (challengeResponseData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData = null;
        }
        String whyInfoLabel = challengeResponseData.getWhyInfoLabel();
        ChallengeResponseData challengeResponseData3 = this.cresData;
        if (challengeResponseData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData3 = null;
        }
        informationZoneView.setWhyInfo(whyInfoLabel, challengeResponseData3.getWhyInfoText(), this.uiCustomization.getLabelCustomization());
        ChallengeResponseData challengeResponseData4 = this.cresData;
        if (challengeResponseData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData4 = null;
        }
        String expandInfoLabel = challengeResponseData4.getExpandInfoLabel();
        ChallengeResponseData challengeResponseData5 = this.cresData;
        if (challengeResponseData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
        } else {
            challengeResponseData2 = challengeResponseData5;
        }
        informationZoneView.setExpandInfo(expandInfoLabel, challengeResponseData2.getExpandInfoText(), this.uiCustomization.getLabelCustomization());
        String accentColor = this.uiCustomization.getAccentColor();
        if (accentColor != null) {
            informationZoneView.setToggleColor$3ds2sdk_release(Color.parseColor(accentColor));
        }
    }

    private final void configureChallengeZoneView() {
        ChallengeZoneView challengeZoneView = getChallengeZoneView();
        ChallengeResponseData challengeResponseData = this.cresData;
        ChallengeResponseData challengeResponseData2 = null;
        if (challengeResponseData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData = null;
        }
        challengeZoneView.setInfoHeaderText(challengeResponseData.getChallengeInfoHeader(), this.uiCustomization.getLabelCustomization());
        ChallengeZoneView challengeZoneView2 = getChallengeZoneView();
        ChallengeResponseData challengeResponseData3 = this.cresData;
        if (challengeResponseData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData3 = null;
        }
        challengeZoneView2.setInfoText(challengeResponseData3.getChallengeInfoText(), this.uiCustomization.getLabelCustomization());
        ChallengeZoneView challengeZoneView3 = getChallengeZoneView();
        ChallengeResponseData challengeResponseData4 = this.cresData;
        if (challengeResponseData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData4 = null;
        }
        challengeZoneView3.setInfoTextIndicator(challengeResponseData4.getShouldShowChallengeInfoTextIndicator() ? R.drawable.stripe_3ds2_ic_indicator : 0);
        ChallengeZoneView challengeZoneView4 = getChallengeZoneView();
        ChallengeResponseData challengeResponseData5 = this.cresData;
        if (challengeResponseData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
        } else {
            challengeResponseData2 = challengeResponseData5;
        }
        challengeZoneView4.setWhitelistingLabel(challengeResponseData2.getWhitelistingInfoText(), this.uiCustomization.getLabelCustomization(), this.uiCustomization.getButtonCustomization(UiCustomization.ButtonType.SELECT));
        getChallengeZoneView().setSubmitButtonClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChallengeFragment.m4453configureChallengeZoneView$lambda7(ChallengeFragment.this, view);
            }
        });
        getChallengeZoneView().setResendButtonClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChallengeFragment.m4454configureChallengeZoneView$lambda8(ChallengeFragment.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: configureChallengeZoneView$lambda-7  reason: not valid java name */
    public static final void m4453configureChallengeZoneView$lambda7(ChallengeFragment challengeFragment, View view) {
        Intrinsics.checkNotNullParameter(challengeFragment, "this$0");
        challengeFragment.getViewModel$3ds2sdk_release().onSubmitClicked(challengeFragment.getChallengeAction());
    }

    /* access modifiers changed from: private */
    /* renamed from: configureChallengeZoneView$lambda-8  reason: not valid java name */
    public static final void m4454configureChallengeZoneView$lambda8(ChallengeFragment challengeFragment, View view) {
        Intrinsics.checkNotNullParameter(challengeFragment, "this$0");
        challengeFragment.getViewModel$3ds2sdk_release().submit(ChallengeAction.Resend.INSTANCE);
    }

    public final void refreshUi() {
        ChallengeResponseData challengeResponseData = this.cresData;
        ChallengeResponseData challengeResponseData2 = null;
        if (challengeResponseData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData = null;
        }
        boolean z = true;
        if (challengeResponseData.getUiType() == UiType.Html) {
            ChallengeResponseData challengeResponseData3 = this.cresData;
            if (challengeResponseData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cresData");
                challengeResponseData3 = null;
            }
            CharSequence acsHtmlRefresh = challengeResponseData3.getAcsHtmlRefresh();
            if (!(acsHtmlRefresh == null || StringsKt.isBlank(acsHtmlRefresh))) {
                ChallengeZoneWebView challengeZoneWebView$3ds2sdk_release = getChallengeZoneWebView$3ds2sdk_release();
                if (challengeZoneWebView$3ds2sdk_release != null) {
                    ChallengeResponseData challengeResponseData4 = this.cresData;
                    if (challengeResponseData4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cresData");
                    } else {
                        challengeResponseData2 = challengeResponseData4;
                    }
                    challengeZoneWebView$3ds2sdk_release.loadHtml(challengeResponseData2.getAcsHtmlRefresh());
                    return;
                }
                return;
            }
        }
        ChallengeResponseData challengeResponseData5 = this.cresData;
        if (challengeResponseData5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            challengeResponseData5 = null;
        }
        if (challengeResponseData5.getUiType() == UiType.OutOfBand) {
            ChallengeResponseData challengeResponseData6 = this.cresData;
            if (challengeResponseData6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cresData");
                challengeResponseData6 = null;
            }
            CharSequence challengeAdditionalInfoText = challengeResponseData6.getChallengeAdditionalInfoText();
            if (challengeAdditionalInfoText != null && !StringsKt.isBlank(challengeAdditionalInfoText)) {
                z = false;
            }
            if (!z) {
                ChallengeZoneView challengeZoneView = getChallengeZoneView();
                ChallengeResponseData challengeResponseData7 = this.cresData;
                if (challengeResponseData7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cresData");
                } else {
                    challengeResponseData2 = challengeResponseData7;
                }
                challengeZoneView.setInfoText(challengeResponseData2.getChallengeAdditionalInfoText(), this.uiCustomization.getLabelCustomization());
                getChallengeZoneView().setInfoTextIndicator(0);
            }
        }
    }

    private final void onChallengeRequestResult(ChallengeRequestResult challengeRequestResult) {
        if (challengeRequestResult instanceof ChallengeRequestResult.Success) {
            ChallengeRequestResult.Success success = (ChallengeRequestResult.Success) challengeRequestResult;
            onSuccess(success.getCreqData(), success.getCresData());
        } else if (challengeRequestResult instanceof ChallengeRequestResult.ProtocolError) {
            onError(((ChallengeRequestResult.ProtocolError) challengeRequestResult).getData());
        } else if (challengeRequestResult instanceof ChallengeRequestResult.RuntimeError) {
            onError(((ChallengeRequestResult.RuntimeError) challengeRequestResult).getThrowable());
        } else if (challengeRequestResult instanceof ChallengeRequestResult.Timeout) {
            onTimeout(((ChallengeRequestResult.Timeout) challengeRequestResult).getData());
        }
    }

    private final void onSuccess(ChallengeRequestData challengeRequestData, ChallengeResponseData challengeResponseData) {
        ChallengeResult challengeResult;
        if (challengeResponseData.isChallengeCompleted()) {
            getViewModel$3ds2sdk_release().stopTimer();
            if (challengeRequestData.getCancelReason() != null) {
                challengeResult = new ChallengeResult.Canceled(getUiTypeCode(), this.initialUiType, this.intentData);
            } else {
                String transStatus = challengeResponseData.getTransStatus();
                if (transStatus == null) {
                    transStatus = "";
                }
                if (Intrinsics.areEqual((Object) "Y", (Object) transStatus)) {
                    challengeResult = new ChallengeResult.Succeeded(getUiTypeCode(), this.initialUiType, this.intentData);
                } else {
                    challengeResult = new ChallengeResult.Failed(getUiTypeCode(), this.initialUiType, this.intentData);
                }
            }
            getViewModel$3ds2sdk_release().onFinish(challengeResult);
            return;
        }
        getViewModel$3ds2sdk_release().onNextScreen(challengeResponseData);
    }

    private final void onError(ErrorData errorData) {
        getViewModel$3ds2sdk_release().onFinish(new ChallengeResult.ProtocolError(errorData, this.initialUiType, this.intentData));
        getViewModel$3ds2sdk_release().stopTimer();
        this.errorRequestExecutor.executeAsync(errorData);
    }

    private final void onTimeout(ErrorData errorData) {
        getViewModel$3ds2sdk_release().stopTimer();
        this.errorRequestExecutor.executeAsync(errorData);
        getViewModel$3ds2sdk_release().onFinish(new ChallengeResult.Timeout(getUiTypeCode(), this.initialUiType, this.intentData));
    }

    private final void onError(Throwable th) {
        getViewModel$3ds2sdk_release().onFinish(new ChallengeResult.RuntimeError(th, this.initialUiType, this.intentData));
    }

    public final void clickSubmitButton() {
        getViewModel$3ds2sdk_release().submit(getChallengeAction());
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeFragment$Companion;", "", "()V", "ARG_CRES", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
