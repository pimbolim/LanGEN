package androidx.compose.ui.text.platform;

import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.platform.extensions.PlaceholderExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aX\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\n0\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¨\u0006\u0012"}, d2 = {"createCharSequence", "", "text", "", "contextFontSize", "", "contextTextStyle", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "typefaceAdapter", "Landroidx/compose/ui/text/platform/TypefaceAdapter;", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidParagraphHelper.android.kt */
public final class AndroidParagraphHelper_androidKt {
    public static final CharSequence createCharSequence(String str, float f, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, Density density, TypefaceAdapter typefaceAdapter) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "contextTextStyle");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(typefaceAdapter, "typefaceAdapter");
        if (list.isEmpty() && list2.isEmpty() && Intrinsics.areEqual((Object) textStyle.getTextIndent(), (Object) TextIndent.Companion.getNone()) && TextUnitKt.m4058isUnspecifiedR2X_6o(textStyle.m3588getLineHeightXSAIIZE())) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        Spannable spannable = spannableString;
        SpannableExtensions_androidKt.m3734setLineHeightr9BaKPg(spannable, textStyle.m3588getLineHeightXSAIIZE(), f, density);
        SpannableExtensions_androidKt.setTextIndent(spannable, textStyle.getTextIndent(), f, density);
        SpannableExtensions_androidKt.setSpanStyles(spannable, textStyle, list, density, typefaceAdapter);
        PlaceholderExtensions_androidKt.setPlaceholders(spannable, list2, density);
        return spannableString;
    }
}
