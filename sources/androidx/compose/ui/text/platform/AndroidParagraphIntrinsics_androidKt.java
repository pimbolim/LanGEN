package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.intl.AndroidLocale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import androidx.core.text.TextUtilsCompat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aP\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a+\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"ActualParagraphIntrinsics", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "resolveTextDirectionHeuristics", "", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "resolveTextDirectionHeuristics-9GRLPo0", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidParagraphIntrinsics.android.kt */
public final class AndroidParagraphIntrinsics_androidKt {
    /* renamed from: resolveTextDirectionHeuristics-9GRLPo0$default  reason: not valid java name */
    public static /* synthetic */ int m3705resolveTextDirectionHeuristics9GRLPo0$default(TextDirection textDirection, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            textDirection = null;
        }
        if ((i & 2) != 0) {
            localeList = null;
        }
        return m3704resolveTextDirectionHeuristics9GRLPo0(textDirection, localeList);
    }

    /* renamed from: resolveTextDirectionHeuristics-9GRLPo0  reason: not valid java name */
    public static final int m3704resolveTextDirectionHeuristics9GRLPo0(TextDirection textDirection, LocaleList localeList) {
        Locale locale;
        int r5 = textDirection == null ? TextDirection.Companion.m3769getContents_7Xco() : textDirection.m3768unboximpl();
        if (!TextDirection.m3765equalsimpl0(r5, TextDirection.Companion.m3770getContentOrLtrs_7Xco())) {
            if (!TextDirection.m3765equalsimpl0(r5, TextDirection.Companion.m3771getContentOrRtls_7Xco())) {
                if (TextDirection.m3765equalsimpl0(r5, TextDirection.Companion.m3772getLtrs_7Xco())) {
                    return 0;
                }
                if (TextDirection.m3765equalsimpl0(r5, TextDirection.Companion.m3773getRtls_7Xco())) {
                    return 1;
                }
                if (TextDirection.m3765equalsimpl0(r5, TextDirection.Companion.m3769getContents_7Xco())) {
                    if (localeList == null) {
                        locale = null;
                    } else {
                        locale = ((AndroidLocale) localeList.get(0).getPlatformLocale$ui_text_release()).getJavaLocale();
                    }
                    if (locale == null) {
                        locale = Locale.getDefault();
                    }
                    int layoutDirectionFromLocale = TextUtilsCompat.getLayoutDirectionFromLocale(locale);
                    if (layoutDirectionFromLocale == 0 || layoutDirectionFromLocale != 1) {
                        return 2;
                    }
                } else {
                    throw new IllegalStateException("Invalid TextDirection.".toString());
                }
            }
            return 3;
        }
        return 2;
    }

    public static final ParagraphIntrinsics ActualParagraphIntrinsics(String str, TextStyle textStyle, List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<Placeholder>> list2, Density density, Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(resourceLoader, "resourceLoader");
        return new AndroidParagraphIntrinsics(str, textStyle, list, list2, new TypefaceAdapter((FontMatcher) null, resourceLoader, 1, (DefaultConstructorMarker) null), density);
    }
}
