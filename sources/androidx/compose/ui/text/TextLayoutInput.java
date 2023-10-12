package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001Bd\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J\u0013\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00103\u001a\u00020\u000bH\u0016J\b\u00104\u001a\u000205H\u0016R\u001c\u0010\u0016\u001a\u00020\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\"\u0010!R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/ui/text/TextLayoutInput;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getMaxLines", "()I", "getOverflow-gIe3tQ8", "I", "getPlaceholders", "()Ljava/util/List;", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "copy", "copy-hu-1Yfo", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/Font$ResourceLoader;J)Landroidx/compose/ui/text/TextLayoutInput;", "equals", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextLayoutResult.kt */
public final class TextLayoutInput {
    private final long constraints;
    private final Density density;
    private final LayoutDirection layoutDirection;
    private final int maxLines;
    private final int overflow;
    private final List<AnnotatedString.Range<Placeholder>> placeholders;
    private final Font.ResourceLoader resourceLoader;
    private final boolean softWrap;
    private final TextStyle style;
    private final AnnotatedString text;

    public /* synthetic */ TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, list, i, z, i2, density2, layoutDirection2, resourceLoader2, j);
    }

    private TextLayoutInput(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader2, long j) {
        this.text = annotatedString;
        this.style = textStyle;
        this.placeholders = list;
        this.maxLines = i;
        this.softWrap = z;
        this.overflow = i2;
        this.density = density2;
        this.layoutDirection = layoutDirection2;
        this.resourceLoader = resourceLoader2;
        this.constraints = j;
    }

    public final AnnotatedString getText() {
        return this.text;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final List<AnnotatedString.Range<Placeholder>> getPlaceholders() {
        return this.placeholders;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final boolean getSoftWrap() {
        return this.softWrap;
    }

    /* renamed from: getOverflow-gIe3tQ8  reason: not valid java name */
    public final int m3551getOverflowgIe3tQ8() {
        return this.overflow;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final Font.ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m3550getConstraintsmsEJaDk() {
        return this.constraints;
    }

    /* renamed from: copy-hu-1Yfo$default  reason: not valid java name */
    public static /* synthetic */ TextLayoutInput m3548copyhu1Yfo$default(TextLayoutInput textLayoutInput, AnnotatedString annotatedString, TextStyle textStyle, List list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader2, long j, int i3, Object obj) {
        int i4;
        long j2;
        TextLayoutInput textLayoutInput2 = textLayoutInput;
        int i5 = i3;
        AnnotatedString annotatedString2 = (i5 & 1) != 0 ? textLayoutInput2.text : annotatedString;
        TextStyle textStyle2 = (i5 & 2) != 0 ? textLayoutInput2.style : textStyle;
        List list2 = (i5 & 4) != 0 ? textLayoutInput2.placeholders : list;
        int i6 = (i5 & 8) != 0 ? textLayoutInput2.maxLines : i;
        boolean z2 = (i5 & 16) != 0 ? textLayoutInput2.softWrap : z;
        if ((i5 & 32) != 0) {
            i4 = textLayoutInput.m3551getOverflowgIe3tQ8();
        } else {
            i4 = i2;
        }
        Density density3 = (i5 & 64) != 0 ? textLayoutInput2.density : density2;
        LayoutDirection layoutDirection3 = (i5 & 128) != 0 ? textLayoutInput2.layoutDirection : layoutDirection2;
        Font.ResourceLoader resourceLoader3 = (i5 & 256) != 0 ? textLayoutInput2.resourceLoader : resourceLoader2;
        if ((i5 & 512) != 0) {
            j2 = textLayoutInput.m3550getConstraintsmsEJaDk();
        } else {
            j2 = j;
        }
        return textLayoutInput.m3549copyhu1Yfo(annotatedString2, textStyle2, list2, i6, z2, i4, density3, layoutDirection3, resourceLoader3, j2);
    }

    /* renamed from: copy-hu-1Yfo  reason: not valid java name */
    public final TextLayoutInput m3549copyhu1Yfo(AnnotatedString annotatedString, TextStyle textStyle, List<AnnotatedString.Range<Placeholder>> list, int i, boolean z, int i2, Density density2, LayoutDirection layoutDirection2, Font.ResourceLoader resourceLoader2, long j) {
        Intrinsics.checkNotNullParameter(annotatedString, "text");
        TextStyle textStyle2 = textStyle;
        Intrinsics.checkNotNullParameter(textStyle2, "style");
        List<AnnotatedString.Range<Placeholder>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        Density density3 = density2;
        Intrinsics.checkNotNullParameter(density3, "density");
        LayoutDirection layoutDirection3 = layoutDirection2;
        Intrinsics.checkNotNullParameter(layoutDirection3, "layoutDirection");
        Font.ResourceLoader resourceLoader3 = resourceLoader2;
        Intrinsics.checkNotNullParameter(resourceLoader3, "resourceLoader");
        return new TextLayoutInput(annotatedString, textStyle2, list2, i, z, i2, density3, layoutDirection3, resourceLoader3, j, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = (TextLayoutInput) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) textLayoutInput.text) && Intrinsics.areEqual((Object) this.style, (Object) textLayoutInput.style) && Intrinsics.areEqual((Object) this.placeholders, (Object) textLayoutInput.placeholders) && this.maxLines == textLayoutInput.maxLines && this.softWrap == textLayoutInput.softWrap && TextOverflow.m3781equalsimpl0(m3551getOverflowgIe3tQ8(), textLayoutInput.m3551getOverflowgIe3tQ8()) && Intrinsics.areEqual((Object) this.density, (Object) textLayoutInput.density) && this.layoutDirection == textLayoutInput.layoutDirection && Intrinsics.areEqual((Object) this.resourceLoader, (Object) textLayoutInput.resourceLoader) && Constraints.m3796equalsimpl0(m3550getConstraintsmsEJaDk(), textLayoutInput.m3550getConstraintsmsEJaDk());
    }

    public int hashCode() {
        return (((((((((((((((((this.text.hashCode() * 31) + this.style.hashCode()) * 31) + this.placeholders.hashCode()) * 31) + this.maxLines) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.softWrap)) * 31) + TextOverflow.m3782hashCodeimpl(m3551getOverflowgIe3tQ8())) * 31) + this.density.hashCode()) * 31) + this.layoutDirection.hashCode()) * 31) + this.resourceLoader.hashCode()) * 31) + Constraints.m3806hashCodeimpl(m3550getConstraintsmsEJaDk());
    }

    public String toString() {
        return "TextLayoutInput(text=" + this.text + ", style=" + this.style + ", placeholders=" + this.placeholders + ", maxLines=" + this.maxLines + ", softWrap=" + this.softWrap + ", overflow=" + TextOverflow.m3783toStringimpl(m3551getOverflowgIe3tQ8()) + ", density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", resourceLoader=" + this.resourceLoader + ", constraints=" + Constraints.m3808toStringimpl(m3550getConstraintsmsEJaDk()) + ')';
    }
}
