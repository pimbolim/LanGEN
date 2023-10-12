package com.stripe.android.connections;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import com.stripe.android.connections.ConnectionsSheetContract;
import com.stripe.android.connections.ConnectionsSheetResult;
import com.stripe.android.connections.ConnectionsSheetViewEffect;
import com.stripe.android.connections.ConnectionsSheetViewModel;
import com.stripe.android.connections.databinding.ActivityConnectionsSheetBinding;
import java.security.InvalidParameterException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020 H\u0016J\u0012\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010)\u001a\u00020 H\u0014J\b\u0010*\u001a\u00020 H\u0002J\f\u0010+\u001a\u00020 *\u00020,H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR!\u0010\r\u001a\u00020\u000e8@X\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0002\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "startForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "starterArgs", "Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "getStarterArgs", "()Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "starterArgs$delegate", "Lkotlin/Lazy;", "viewBinding", "Lcom/stripe/android/connections/databinding/ActivityConnectionsSheetBinding;", "getViewBinding$connections_release$annotations", "getViewBinding$connections_release", "()Lcom/stripe/android/connections/databinding/ActivityConnectionsSheetBinding;", "viewBinding$delegate", "viewModel", "Lcom/stripe/android/connections/ConnectionsSheetViewModel;", "getViewModel", "()Lcom/stripe/android/connections/ConnectionsSheetViewModel;", "viewModel$delegate", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory$connections_release$annotations", "getViewModelFactory$connections_release", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory$connections_release", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "finishWithResult", "", "result", "Lcom/stripe/android/connections/ConnectionsSheetResult;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onResume", "setupObservers", "launch", "Lcom/stripe/android/connections/ConnectionsSheetViewEffect$OpenAuthFlowWithUrl;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsSheetActivity.kt */
public final class ConnectionsSheetActivity extends AppCompatActivity {
    private final ActivityResultLauncher<Intent> startForResult;
    private final Lazy starterArgs$delegate;
    private final Lazy viewBinding$delegate = LazyKt.lazy(new ConnectionsSheetActivity$viewBinding$2(this));
    private final Lazy viewModel$delegate;
    private ViewModelProvider.Factory viewModelFactory;

    public static /* synthetic */ void getViewBinding$connections_release$annotations() {
    }

    public static /* synthetic */ void getViewModelFactory$connections_release$annotations() {
    }

    public ConnectionsSheetActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                ConnectionsSheetActivity.m4285startForResult$lambda0(ConnectionsSheetActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul….onActivityResult()\n    }");
        this.startForResult = registerForActivityResult;
        Function0 connectionsSheetActivity$viewModelFactory$1 = new ConnectionsSheetActivity$viewModelFactory$1(this);
        Function0 connectionsSheetActivity$viewModelFactory$2 = new ConnectionsSheetActivity$viewModelFactory$2(this);
        SavedStateRegistryOwner savedStateRegistryOwner = this;
        Intent intent = getIntent();
        this.viewModelFactory = new ConnectionsSheetViewModel.Factory(connectionsSheetActivity$viewModelFactory$1, connectionsSheetActivity$viewModelFactory$2, savedStateRegistryOwner, intent == null ? null : intent.getExtras());
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ConnectionsSheetViewModel.class), new ConnectionsSheetActivity$special$$inlined$viewModels$2(this), new ConnectionsSheetActivity$viewModel$2(this));
        this.starterArgs$delegate = LazyKt.lazy(new ConnectionsSheetActivity$starterArgs$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startForResult$lambda-0  reason: not valid java name */
    public static final void m4285startForResult$lambda0(ConnectionsSheetActivity connectionsSheetActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(connectionsSheetActivity, "this$0");
        connectionsSheetActivity.getViewModel().onActivityResult$connections_release();
    }

    public final ActivityConnectionsSheetBinding getViewBinding$connections_release() {
        return (ActivityConnectionsSheetBinding) this.viewBinding$delegate.getValue();
    }

    public final ViewModelProvider.Factory getViewModelFactory$connections_release() {
        return this.viewModelFactory;
    }

    public final void setViewModelFactory$connections_release(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    /* access modifiers changed from: private */
    public final ConnectionsSheetViewModel getViewModel() {
        return (ConnectionsSheetViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ConnectionsSheetContract.Args getStarterArgs() {
        return (ConnectionsSheetContract.Args) this.starterArgs$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) getViewBinding$connections_release().getRoot());
        ConnectionsSheetContract.Args starterArgs = getStarterArgs();
        if (starterArgs == null) {
            finishWithResult(new ConnectionsSheetResult.Failed(new IllegalArgumentException("ConnectionsSheet started without arguments.")));
            return;
        }
        try {
            starterArgs.validate();
            setupObservers();
            if (bundle != null) {
                getViewModel().onActivityRecreated$connections_release();
            }
        } catch (InvalidParameterException e) {
            finishWithResult(new ConnectionsSheetResult.Failed(e));
        }
    }

    private final void setupObservers() {
        LifecycleOwner lifecycleOwner = this;
        LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenStarted(new ConnectionsSheetActivity$setupObservers$1(this, (Continuation<? super ConnectionsSheetActivity$setupObservers$1>) null));
        LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenStarted(new ConnectionsSheetActivity$setupObservers$2(this, (Continuation<? super ConnectionsSheetActivity$setupObservers$2>) null));
    }

    /* access modifiers changed from: private */
    public final void launch(ConnectionsSheetViewEffect.OpenAuthFlowWithUrl openAuthFlowWithUrl) {
        ActivityResultLauncher<Intent> activityResultLauncher = this.startForResult;
        CustomTabsIntent build = new CustomTabsIntent.Builder().setShareState(2).build();
        build.intent.setData(Uri.parse(openAuthFlowWithUrl.getUrl()));
        activityResultLauncher.launch(build.intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getViewModel().onResume$connections_release();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getViewModel().handleOnNewIntent$connections_release(intent);
    }

    public void onBackPressed() {
        finishWithResult(ConnectionsSheetResult.Canceled.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void finishWithResult(ConnectionsSheetResult connectionsSheetResult) {
        setResult(-1, new Intent().putExtras(new ConnectionsSheetContract.Result(connectionsSheetResult).toBundle()));
        finish();
    }
}
