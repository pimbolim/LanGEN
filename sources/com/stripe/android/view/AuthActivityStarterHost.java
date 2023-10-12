package com.stripe.android.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000f2\u00020\u0001:\u0003\u000e\u000f\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H&R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X \u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/view/AuthActivityStarterHost;", "", "()V", "statusBarColor", "", "getStatusBarColor$payments_core_release", "()Ljava/lang/Integer;", "startActivityForResult", "", "target", "Ljava/lang/Class;", "extras", "Landroid/os/Bundle;", "requestCode", "ActivityHost", "Companion", "FragmentHost", "Lcom/stripe/android/view/AuthActivityStarterHost$ActivityHost;", "Lcom/stripe/android/view/AuthActivityStarterHost$FragmentHost;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthActivityStarterHost.kt */
public abstract class AuthActivityStarterHost {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ AuthActivityStarterHost(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Integer getStatusBarColor$payments_core_release();

    public abstract void startActivityForResult(Class<?> cls, Bundle bundle, int i);

    private AuthActivityStarterHost() {
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/view/AuthActivityStarterHost$ActivityHost;", "Lcom/stripe/android/view/AuthActivityStarterHost;", "activity", "Landroidx/activity/ComponentActivity;", "statusBarColor", "", "(Landroidx/activity/ComponentActivity;Ljava/lang/Integer;)V", "getActivity", "()Landroidx/activity/ComponentActivity;", "getStatusBarColor$payments_core_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "startActivityForResult", "", "target", "Ljava/lang/Class;", "extras", "Landroid/os/Bundle;", "requestCode", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AuthActivityStarterHost.kt */
    public static final class ActivityHost extends AuthActivityStarterHost {
        private final ComponentActivity activity;
        private final Integer statusBarColor;

        public final ComponentActivity getActivity() {
            return this.activity;
        }

        public Integer getStatusBarColor$payments_core_release() {
            return this.statusBarColor;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ActivityHost(ComponentActivity componentActivity, Integer num) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(componentActivity, "activity");
            this.activity = componentActivity;
            this.statusBarColor = num;
        }

        public void startActivityForResult(Class<?> cls, Bundle bundle, int i) {
            Intrinsics.checkNotNullParameter(cls, "target");
            Intrinsics.checkNotNullParameter(bundle, "extras");
            Intent putExtras = new Intent(this.activity, cls).putExtras(bundle);
            Intrinsics.checkNotNullExpressionValue(putExtras, "Intent(activity, target).putExtras(extras)");
            this.activity.startActivityForResult(putExtras, i);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/view/AuthActivityStarterHost$FragmentHost;", "Lcom/stripe/android/view/AuthActivityStarterHost;", "fragment", "Landroidx/fragment/app/Fragment;", "statusBarColor", "", "(Landroidx/fragment/app/Fragment;Ljava/lang/Integer;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getStatusBarColor$payments_core_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "startActivityForResult", "", "target", "Ljava/lang/Class;", "extras", "Landroid/os/Bundle;", "requestCode", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AuthActivityStarterHost.kt */
    public static final class FragmentHost extends AuthActivityStarterHost {
        private final Fragment fragment;
        private final Integer statusBarColor;

        public final Fragment getFragment() {
            return this.fragment;
        }

        public Integer getStatusBarColor$payments_core_release() {
            return this.statusBarColor;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FragmentHost(Fragment fragment2, Integer num) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(fragment2, "fragment");
            this.fragment = fragment2;
            this.statusBarColor = num;
        }

        public void startActivityForResult(Class<?> cls, Bundle bundle, int i) {
            Intrinsics.checkNotNullParameter(cls, "target");
            Intrinsics.checkNotNullParameter(bundle, "extras");
            Intent putExtras = new Intent(this.fragment.getActivity(), cls).putExtras(bundle);
            Intrinsics.checkNotNullExpressionValue(putExtras, "Intent(fragment.activity…target).putExtras(extras)");
            if (this.fragment.isAdded()) {
                this.fragment.startActivityForResult(putExtras, i);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/stripe/android/view/AuthActivityStarterHost$Companion;", "", "()V", "create", "Lcom/stripe/android/view/AuthActivityStarterHost;", "activity", "Landroidx/activity/ComponentActivity;", "create$payments_core_release", "fragment", "Landroidx/fragment/app/Fragment;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AuthActivityStarterHost.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ AuthActivityStarterHost create$payments_core_release(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            FragmentActivity requireActivity = fragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
            Window window = requireActivity.getWindow();
            return new FragmentHost(fragment, window == null ? null : Integer.valueOf(window.getStatusBarColor()));
        }

        public final /* synthetic */ AuthActivityStarterHost create$payments_core_release(ComponentActivity componentActivity) {
            Intrinsics.checkNotNullParameter(componentActivity, "activity");
            Window window = componentActivity.getWindow();
            return new ActivityHost(componentActivity, window == null ? null : Integer.valueOf(window.getStatusBarColor()));
        }
    }
}
