package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010!\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u0017J&\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R)\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/foundation/text/TextFieldSize;", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "style", "Landroidx/compose/ui/text/TextStyle;", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;Landroidx/compose/ui/text/TextStyle;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "minSize", "getMinSize-YbymL2g", "()J", "J", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "setResourceLoader", "(Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "setStyle", "(Landroidx/compose/ui/text/TextStyle;)V", "computeMinSize", "computeMinSize-YbymL2g", "update", "", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldSize.kt */
final class TextFieldSize {
    private Density density;
    private LayoutDirection layoutDirection;
    private long minSize = m722computeMinSizeYbymL2g();
    private Font.ResourceLoader resourceLoader;
    private TextStyle style;

    public TextFieldSize(LayoutDirection layoutDirection2, Density density2, Font.ResourceLoader resourceLoader2, TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Intrinsics.checkNotNullParameter(density2, "density");
        Intrinsics.checkNotNullParameter(resourceLoader2, "resourceLoader");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        this.layoutDirection = layoutDirection2;
        this.density = density2;
        this.resourceLoader = resourceLoader2;
        this.style = textStyle;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final void setLayoutDirection(LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
        this.layoutDirection = layoutDirection2;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "<set-?>");
        this.density = density2;
    }

    public final Font.ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }

    public final void setResourceLoader(Font.ResourceLoader resourceLoader2) {
        Intrinsics.checkNotNullParameter(resourceLoader2, "<set-?>");
        this.resourceLoader = resourceLoader2;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final void setStyle(TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "<set-?>");
        this.style = textStyle;
    }

    /* renamed from: getMinSize-YbymL2g  reason: not valid java name */
    public final long m723getMinSizeYbymL2g() {
        return this.minSize;
    }

    public final void update(LayoutDirection layoutDirection2, Density density2, Font.ResourceLoader resourceLoader2, TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Intrinsics.checkNotNullParameter(density2, "density");
        Intrinsics.checkNotNullParameter(resourceLoader2, "resourceLoader");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        if (layoutDirection2 != this.layoutDirection || !Intrinsics.areEqual((Object) density2, (Object) this.density) || !Intrinsics.areEqual((Object) resourceLoader2, (Object) this.resourceLoader) || !Intrinsics.areEqual((Object) textStyle, (Object) this.style)) {
            this.layoutDirection = layoutDirection2;
            this.density = density2;
            this.resourceLoader = resourceLoader2;
            this.style = textStyle;
            this.minSize = m722computeMinSizeYbymL2g();
        }
    }

    /* renamed from: computeMinSize-YbymL2g  reason: not valid java name */
    private final long m722computeMinSizeYbymL2g() {
        return TextFieldDelegateKt.computeSizeForDefaultText$default(TextStyleKt.resolveDefaults(this.style, this.layoutDirection), this.density, this.resourceLoader, (String) null, 0, 24, (Object) null);
    }
}
