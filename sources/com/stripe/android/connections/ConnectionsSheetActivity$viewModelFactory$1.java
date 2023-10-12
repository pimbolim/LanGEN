package com.stripe.android.connections;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/Application;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsSheetActivity.kt */
final class ConnectionsSheetActivity$viewModelFactory$1 extends Lambda implements Function0<Application> {
    final /* synthetic */ ConnectionsSheetActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionsSheetActivity$viewModelFactory$1(ConnectionsSheetActivity connectionsSheetActivity) {
        super(0);
        this.this$0 = connectionsSheetActivity;
    }

    public final Application invoke() {
        Application application = this.this$0.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "application");
        return application;
    }
}
