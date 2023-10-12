package com.stripe.android.ui.core.elements;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.stripe.android.ui.core.PaymentsTheme;
import com.stripe.android.ui.core.PaymentsThemeKt;
import com.stripe.android.ui.core.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AfterpayClearpayElementUI.kt */
final class AfterpayClearpayElementUIKt$AfterpayClearpayElementUI$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Context $context;
    final /* synthetic */ AfterpayClearpayHeaderElement $element;
    final /* synthetic */ boolean $enabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AfterpayClearpayElementUIKt$AfterpayClearpayElementUI$1(AfterpayClearpayHeaderElement afterpayClearpayHeaderElement, Context context, boolean z, int i) {
        super(2);
        this.$element = afterpayClearpayHeaderElement;
        this.$context = context;
        this.$enabled = z;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ColorFilter colorFilter;
        Composer composer2 = composer;
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            AfterpayClearpayHeaderElement afterpayClearpayHeaderElement = this.$element;
            Resources resources = this.$context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            float f = (float) 4;
            float f2 = f;
            TextKt.m1189TextfLXpl1I(afterpayClearpayHeaderElement.getLabel(resources), PaddingKt.m435paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.m3859constructorimpl(f), 0.0f, 11, (Object) null), PaymentsTheme.INSTANCE.getColors(composer2, 8).m4507getSubtitle0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 48, 0, 65528);
            Composer composer3 = composer;
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.stripe_ic_afterpay_clearpay_logo, composer3, 0);
            String stringResource = StringResources_androidKt.stringResource(R.string.afterpay_clearpay_message, composer3, 0);
            if (PaymentsThemeKt.m4516shouldUseDarkDynamicColor8_81llA(PaymentsTheme.INSTANCE.getColors(composer3, 8).getMaterial().m918getSurface0d7_KjU())) {
                colorFilter = null;
            } else {
                colorFilter = ColorFilter.Companion.m1637tintxETnrds$default(ColorFilter.Companion, Color.Companion.m1633getWhite0d7_KjU(), 0, 2, (Object) null);
            }
            ImageKt.Image(painterResource, stringResource, (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, colorFilter, composer, 8, 60);
            final Context context = this.$context;
            final AfterpayClearpayHeaderElement afterpayClearpayHeaderElement2 = this.$element;
            ButtonKt.TextButton(new Function0<Unit>() {
                public final void invoke() {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(afterpayClearpayHeaderElement2.getInfoUrl())));
                }
            }, SizeKt.m492size3ABfNKs(Modifier.Companion, Dp.m3859constructorimpl((float) 32)), this.$enabled, (MutableInteractionSource) null, (ButtonElevation) null, (Shape) null, (BorderStroke) null, (ButtonColors) null, PaddingKt.m424PaddingValues0680j_4(Dp.m3859constructorimpl(f2)), ComposableSingletons$AfterpayClearpayElementUIKt.INSTANCE.m4564getLambda1$payments_ui_core_release(), composer, 905969712 | ((this.$$dirty << 6) & 896), 248);
            return;
        }
        composer.skipToGroupEnd();
    }
}
