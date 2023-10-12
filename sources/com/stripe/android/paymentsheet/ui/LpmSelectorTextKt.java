package com.stripe.android.paymentsheet.ui;

import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnitKt;
import com.stripe.android.ui.core.PaymentsTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"LpmSelectorText", "", "text", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "isEnabled", "", "LpmSelectorText-3IgeMak", "(Ljava/lang/String;JLandroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;I)V", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LpmSelectorText.kt */
public final class LpmSelectorTextKt {
    /* renamed from: LpmSelectorText-3IgeMak  reason: not valid java name */
    public static final void m4444LpmSelectorText3IgeMak(String str, long j, Modifier modifier, boolean z, Composer composer, int i) {
        int i2;
        Composer composer2;
        long j2;
        String str2 = str;
        Modifier modifier2 = modifier;
        boolean z2 = z;
        int i3 = i;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Composer startRestartGroup = composer.startRestartGroup(-50977814);
        if ((i3 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) str2) ? 4 : 2) | i3;
        } else {
            i2 = i3;
        }
        long j3 = j;
        if ((i3 & 112) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 32 : 16;
        }
        if ((i3 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) modifier2) ? 256 : 128;
        }
        if ((i3 & 7168) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 2048 : 1024;
        }
        int i4 = i2;
        if (((i4 & 5851) ^ 1170) != 0 || !startRestartGroup.getSkipping()) {
            TextStyle caption = PaymentsTheme.INSTANCE.getTypography(startRestartGroup, 8).getCaption();
            if (z2) {
                j2 = j3;
            } else {
                j2 = Color.m1595copywmQWz5c$default(j, 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            }
            int i5 = i4;
            composer2 = startRestartGroup;
            TextKt.m1189TextfLXpl1I(str, modifier, j2, 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(1), TextOverflow.Companion.m3789getEllipsisgIe3tQ8(), false, 1, (Function1<? super TextLayoutResult, Unit>) null, caption, composer2, (i5 & 14) | ((i5 >> 3) & 112), 3126, 21496);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LpmSelectorTextKt$LpmSelectorText$1(str, j, modifier, z, i));
        }
    }
}
