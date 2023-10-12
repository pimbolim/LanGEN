package androidx.compose.ui.text;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000e\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/Placeholder;", "", "width", "Landroidx/compose/ui/unit/TextUnit;", "height", "placeholderVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "(JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHeight-XSAIIZE", "()J", "J", "getPlaceholderVerticalAlign-J6kI3mc", "()I", "I", "getWidth-XSAIIZE", "copy", "copy-K8Q-__8", "(JJI)Landroidx/compose/ui/text/Placeholder;", "equals", "", "other", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Placeholder.kt */
public final class Placeholder {
    private final long height;
    private final int placeholderVerticalAlign;
    private final long width;

    public /* synthetic */ Placeholder(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, i);
    }

    private Placeholder(long j, long j2, int i) {
        this.width = j;
        this.height = j2;
        this.placeholderVerticalAlign = i;
        if (!(!TextUnitKt.m4058isUnspecifiedR2X_6o(m3513getWidthXSAIIZE()))) {
            throw new IllegalArgumentException("width cannot be TextUnit.Unspecified".toString());
        } else if (!(!TextUnitKt.m4058isUnspecifiedR2X_6o(m3511getHeightXSAIIZE()))) {
            throw new IllegalArgumentException("height cannot be TextUnit.Unspecified".toString());
        }
    }

    /* renamed from: getWidth-XSAIIZE  reason: not valid java name */
    public final long m3513getWidthXSAIIZE() {
        return this.width;
    }

    /* renamed from: getHeight-XSAIIZE  reason: not valid java name */
    public final long m3511getHeightXSAIIZE() {
        return this.height;
    }

    /* renamed from: getPlaceholderVerticalAlign-J6kI3mc  reason: not valid java name */
    public final int m3512getPlaceholderVerticalAlignJ6kI3mc() {
        return this.placeholderVerticalAlign;
    }

    /* renamed from: copy-K8Q-__8$default  reason: not valid java name */
    public static /* synthetic */ Placeholder m3509copyK8Q__8$default(Placeholder placeholder, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = placeholder.m3513getWidthXSAIIZE();
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            j2 = placeholder.m3511getHeightXSAIIZE();
        }
        long j4 = j2;
        if ((i2 & 4) != 0) {
            i = placeholder.m3512getPlaceholderVerticalAlignJ6kI3mc();
        }
        return placeholder.m3510copyK8Q__8(j3, j4, i);
    }

    /* renamed from: copy-K8Q-__8  reason: not valid java name */
    public final Placeholder m3510copyK8Q__8(long j, long j2, int i) {
        return new Placeholder(j, j2, i, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placeholder)) {
            return false;
        }
        Placeholder placeholder = (Placeholder) obj;
        return TextUnit.m4037equalsimpl0(m3513getWidthXSAIIZE(), placeholder.m3513getWidthXSAIIZE()) && TextUnit.m4037equalsimpl0(m3511getHeightXSAIIZE(), placeholder.m3511getHeightXSAIIZE()) && PlaceholderVerticalAlign.m3517equalsimpl0(m3512getPlaceholderVerticalAlignJ6kI3mc(), placeholder.m3512getPlaceholderVerticalAlignJ6kI3mc());
    }

    public int hashCode() {
        return (((TextUnit.m4041hashCodeimpl(m3513getWidthXSAIIZE()) * 31) + TextUnit.m4041hashCodeimpl(m3511getHeightXSAIIZE())) * 31) + PlaceholderVerticalAlign.m3518hashCodeimpl(m3512getPlaceholderVerticalAlignJ6kI3mc());
    }

    public String toString() {
        return "Placeholder(width=" + TextUnit.m4047toStringimpl(m3513getWidthXSAIIZE()) + ", height=" + TextUnit.m4047toStringimpl(m3511getHeightXSAIIZE()) + ", placeholderVerticalAlign=" + PlaceholderVerticalAlign.m3519toStringimpl(m3512getPlaceholderVerticalAlignJ6kI3mc()) + ')';
    }
}
