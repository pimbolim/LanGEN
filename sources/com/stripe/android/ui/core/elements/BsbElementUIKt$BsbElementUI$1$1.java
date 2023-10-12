package com.stripe.android.ui.core.elements;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.stripe.android.ui.core.PaymentsTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BsbElementUI.kt */
final class BsbElementUIKt$BsbElementUI$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ State<String> $bankName$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BsbElementUIKt$BsbElementUI$1$1(State<String> state) {
        super(2);
        this.$bankName$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            String r2 = BsbElementUIKt.m4556BsbElementUI$lambda1(this.$bankName$delegate);
            if (r2 != null) {
                TextKt.m1189TextfLXpl1I(r2, (Modifier) null, PaymentsTheme.INSTANCE.getColors(composer, 8).m4507getSubtitle0d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 65530);
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
