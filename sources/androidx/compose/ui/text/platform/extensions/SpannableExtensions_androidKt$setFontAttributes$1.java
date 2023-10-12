package androidx.compose.ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.platform.TypefaceAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "start", "", "end", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpannableExtensions.android.kt */
final class SpannableExtensions_androidKt$setFontAttributes$1 extends Lambda implements Function3<SpanStyle, Integer, Integer, Unit> {
    final /* synthetic */ Spannable $this_setFontAttributes;
    final /* synthetic */ TypefaceAdapter $typefaceAdapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpannableExtensions_androidKt$setFontAttributes$1(Spannable spannable, TypefaceAdapter typefaceAdapter) {
        super(3);
        this.$this_setFontAttributes = spannable;
        this.$typefaceAdapter = typefaceAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((SpanStyle) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(SpanStyle spanStyle, int i, int i2) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        Spannable spannable = this.$this_setFontAttributes;
        TypefaceAdapter typefaceAdapter = this.$typefaceAdapter;
        FontFamily fontFamily = spanStyle.getFontFamily();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        FontStyle r5 = spanStyle.m3544getFontStyle4Lr2A7w();
        int r52 = r5 == null ? FontStyle.Companion.m3617getNormal_LCdwA() : r5.m3615unboximpl();
        FontSynthesis r7 = spanStyle.m3545getFontSynthesisZQGJjVo();
        spannable.setSpan(new TypefaceSpan(typefaceAdapter.m3716createDPcqOEQ(fontFamily, fontWeight, r52, r7 == null ? FontSynthesis.Companion.m3627getAllGVVA2EU() : r7.m3626unboximpl())), i, i2, 33);
    }
}
