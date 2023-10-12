package com.stripe.android.paymentsheet.flowcontroller;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH&\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/ActivityLauncherFactory;", "", "()V", "create", "Landroidx/activity/result/ActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "callback", "Landroidx/activity/result/ActivityResultCallback;", "ActivityHost", "FragmentHost", "Lcom/stripe/android/paymentsheet/flowcontroller/ActivityLauncherFactory$ActivityHost;", "Lcom/stripe/android/paymentsheet/flowcontroller/ActivityLauncherFactory$FragmentHost;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityLauncherFactory.kt */
public abstract class ActivityLauncherFactory {
    public /* synthetic */ ActivityLauncherFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract <I, O> ActivityResultLauncher<I> create(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback);

    private ActivityLauncherFactory() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/ActivityLauncherFactory$ActivityHost;", "Lcom/stripe/android/paymentsheet/flowcontroller/ActivityLauncherFactory;", "activity", "Landroidx/activity/ComponentActivity;", "(Landroidx/activity/ComponentActivity;)V", "create", "Landroidx/activity/result/ActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "callback", "Landroidx/activity/result/ActivityResultCallback;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActivityLauncherFactory.kt */
    public static final class ActivityHost extends ActivityLauncherFactory {
        private final ComponentActivity activity;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ActivityHost(ComponentActivity componentActivity) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(componentActivity, "activity");
            this.activity = componentActivity;
        }

        public <I, O> ActivityResultLauncher<I> create(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
            Intrinsics.checkNotNullParameter(activityResultContract, "contract");
            Intrinsics.checkNotNullParameter(activityResultCallback, "callback");
            ActivityResultLauncher<I> registerForActivityResult = this.activity.registerForActivityResult(activityResultContract, activityResultCallback);
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "activity.registerForActi…   callback\n            )");
            return registerForActivityResult;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J<\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/ActivityLauncherFactory$FragmentHost;", "Lcom/stripe/android/paymentsheet/flowcontroller/ActivityLauncherFactory;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "create", "Landroidx/activity/result/ActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "callback", "Landroidx/activity/result/ActivityResultCallback;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActivityLauncherFactory.kt */
    public static final class FragmentHost extends ActivityLauncherFactory {
        private final Fragment fragment;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FragmentHost(Fragment fragment2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(fragment2, "fragment");
            this.fragment = fragment2;
        }

        public <I, O> ActivityResultLauncher<I> create(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
            Intrinsics.checkNotNullParameter(activityResultContract, "contract");
            Intrinsics.checkNotNullParameter(activityResultCallback, "callback");
            ActivityResultLauncher<I> registerForActivityResult = this.fragment.registerForActivityResult(activityResultContract, activityResultCallback);
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "fragment.registerForActi…   callback\n            )");
            return registerForActivityResult;
        }
    }
}
