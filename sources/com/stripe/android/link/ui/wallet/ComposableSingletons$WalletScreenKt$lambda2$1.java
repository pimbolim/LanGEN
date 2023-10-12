package com.stripe.android.link.ui.wallet;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.stripe.android.link.ui.wallet.ComposableSingletons$WalletScreenKt$lambda-2$1  reason: invalid class name */
/* compiled from: WalletScreen.kt */
final class ComposableSingletons$WalletScreenKt$lambda2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$WalletScreenKt$lambda2$1 INSTANCE = new ComposableSingletons$WalletScreenKt$lambda2$1();

    ComposableSingletons$WalletScreenKt$lambda2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            SurfaceKt.m1125SurfaceFjzlyU((Modifier) null, (Shape) null, 0, 0, (BorderStroke) null, 0.0f, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$WalletScreenKt.INSTANCE.m4352getLambda1$link_release(), composer, 1572864, 63);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
