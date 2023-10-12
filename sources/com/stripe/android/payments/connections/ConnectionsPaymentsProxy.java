package com.stripe.android.payments.connections;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.stripe.android.connections.ConnectionsSheetResult;
import com.stripe.android.payments.connections.reflection.DefaultIsConnectionsAvailable;
import com.stripe.android.payments.connections.reflection.IsConnectionsAvailable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/stripe/android/payments/connections/ConnectionsPaymentsProxy;", "", "present", "", "linkAccountSessionClientSecret", "", "publishableKey", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsPaymentsProxy.kt */
public interface ConnectionsPaymentsProxy {
    public static final Companion Companion = Companion.$$INSTANCE;

    void present(String str, String str2);

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\b\b\u0002\u0010\r\u001a\u00020\u000e¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/connections/ConnectionsPaymentsProxy$Companion;", "", "()V", "create", "Lcom/stripe/android/payments/connections/ConnectionsPaymentsProxy;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "onComplete", "Lkotlin/Function1;", "Lcom/stripe/android/connections/ConnectionsSheetResult;", "", "provider", "Lkotlin/Function0;", "isConnectionsAvailable", "Lcom/stripe/android/payments/connections/reflection/IsConnectionsAvailable;", "fragment", "Landroidx/fragment/app/Fragment;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsPaymentsProxy.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ ConnectionsPaymentsProxy create$default(Companion companion, Fragment fragment, Function1 function1, Function0 function0, IsConnectionsAvailable isConnectionsAvailable, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = new ConnectionsPaymentsProxy$Companion$create$1(fragment, function1);
            }
            if ((i & 8) != 0) {
                isConnectionsAvailable = new DefaultIsConnectionsAvailable();
            }
            return companion.create(fragment, (Function1<? super ConnectionsSheetResult, Unit>) function1, (Function0<? extends ConnectionsPaymentsProxy>) function0, isConnectionsAvailable);
        }

        public final ConnectionsPaymentsProxy create(Fragment fragment, Function1<? super ConnectionsSheetResult, Unit> function1, Function0<? extends ConnectionsPaymentsProxy> function0, IsConnectionsAvailable isConnectionsAvailable) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(function1, "onComplete");
            Intrinsics.checkNotNullParameter(function0, "provider");
            Intrinsics.checkNotNullParameter(isConnectionsAvailable, "isConnectionsAvailable");
            if (isConnectionsAvailable.invoke()) {
                return (ConnectionsPaymentsProxy) function0.invoke();
            }
            return new UnsupportedConnectionsPaymentsProxy();
        }

        public static /* synthetic */ ConnectionsPaymentsProxy create$default(Companion companion, AppCompatActivity appCompatActivity, Function1 function1, Function0 function0, IsConnectionsAvailable isConnectionsAvailable, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = new ConnectionsPaymentsProxy$Companion$create$2(appCompatActivity, function1);
            }
            if ((i & 8) != 0) {
                isConnectionsAvailable = new DefaultIsConnectionsAvailable();
            }
            return companion.create(appCompatActivity, (Function1<? super ConnectionsSheetResult, Unit>) function1, (Function0<? extends ConnectionsPaymentsProxy>) function0, isConnectionsAvailable);
        }

        public final ConnectionsPaymentsProxy create(AppCompatActivity appCompatActivity, Function1<? super ConnectionsSheetResult, Unit> function1, Function0<? extends ConnectionsPaymentsProxy> function0, IsConnectionsAvailable isConnectionsAvailable) {
            Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
            Intrinsics.checkNotNullParameter(function1, "onComplete");
            Intrinsics.checkNotNullParameter(function0, "provider");
            Intrinsics.checkNotNullParameter(isConnectionsAvailable, "isConnectionsAvailable");
            if (isConnectionsAvailable.invoke()) {
                return (ConnectionsPaymentsProxy) function0.invoke();
            }
            return new UnsupportedConnectionsPaymentsProxy();
        }
    }
}
