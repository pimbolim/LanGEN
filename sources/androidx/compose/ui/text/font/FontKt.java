package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0001H\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"Font", "Landroidx/compose/ui/text/font/Font;", "resId", "", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "Font-RetOiIg", "(ILandroidx/compose/ui/text/font/FontWeight;I)Landroidx/compose/ui/text/font/Font;", "toFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Font.kt */
public final class FontKt {
    /* renamed from: Font-RetOiIg$default  reason: not valid java name */
    public static /* synthetic */ Font m3605FontRetOiIg$default(int i, FontWeight fontWeight, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            fontWeight = FontWeight.Companion.getNormal();
        }
        if ((i3 & 4) != 0) {
            i2 = FontStyle.Companion.m3617getNormal_LCdwA();
        }
        return m3604FontRetOiIg(i, fontWeight, i2);
    }

    /* renamed from: Font-RetOiIg  reason: not valid java name */
    public static final Font m3604FontRetOiIg(int i, FontWeight fontWeight, int i2) {
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        return new ResourceFont(i, fontWeight, i2, (DefaultConstructorMarker) null);
    }

    public static final FontFamily toFontFamily(Font font) {
        Intrinsics.checkNotNullParameter(font, "<this>");
        return FontFamilyKt.FontFamily(font);
    }
}
