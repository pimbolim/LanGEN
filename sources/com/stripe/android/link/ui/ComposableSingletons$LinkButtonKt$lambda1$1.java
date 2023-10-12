package com.stripe.android.link.ui;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.stripe.android.link.R;
import com.stripe.android.link.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/layout/RowScope;", "invoke", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.stripe.android.link.ui.ComposableSingletons$LinkButtonKt$lambda-1$1  reason: invalid class name */
/* compiled from: LinkButton.kt */
final class ComposableSingletons$LinkButtonKt$lambda1$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$LinkButtonKt$lambda1$1 INSTANCE = new ComposableSingletons$LinkButtonKt$lambda1$1();

    ComposableSingletons$LinkButtonKt$lambda1$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$Button");
        if (((i & 81) ^ 16) != 0 || !composer.getSkipping()) {
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.ic_link_logo, composer, 0);
            String stringResource = StringResources_androidKt.stringResource(R.string.link, composer, 0);
            float f = (float) 4;
            Modifier r2 = PaddingKt.m435paddingqDBjuR0$default(SizeKt.m478height3ABfNKs(Modifier.Companion, Dp.m3859constructorimpl((float) 22)), Dp.m3859constructorimpl((float) 5), Dp.m3859constructorimpl(f), 0.0f, Dp.m3859constructorimpl(f), 4, (Object) null);
            long r3 = ThemeKt.getLinkColors(MaterialTheme.INSTANCE, composer, 8).m4331getButtonLabel0d7_KjU();
            ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconKt.m1013Iconww6aTOc(painterResource, stringResource, r2, Color.m1595copywmQWz5c$default(r3, ((Number) consume).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null), composer, 392, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
