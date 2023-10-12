package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B6\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000¢\u0006\u0002\u0010\nJA\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0000H\u0007J\u0011\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/ParagraphStyle;", "", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "Landroidx/compose/ui/unit/TextUnit;", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLineHeight-XSAIIZE", "()J", "J", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "copy", "copy-Elsmlbk", "(Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/ParagraphStyle;", "equals", "", "other", "hashCode", "", "merge", "plus", "toString", "", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParagraphStyle.kt */
public final class ParagraphStyle {
    private final long lineHeight;
    private final TextAlign textAlign;
    private final TextDirection textDirection;
    private final TextIndent textIndent;

    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, DefaultConstructorMarker defaultConstructorMarker) {
        this(textAlign2, textDirection2, j, textIndent2);
    }

    private ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2) {
        this.textAlign = textAlign2;
        this.textDirection = textDirection2;
        this.lineHeight = j;
        this.textIndent = textIndent2;
        if (!TextUnit.m4037equalsimpl0(m3506getLineHeightXSAIIZE(), TextUnit.Companion.m4051getUnspecifiedXSAIIZE())) {
            if (!(TextUnit.m4040getValueimpl(m3506getLineHeightXSAIIZE()) >= 0.0f)) {
                throw new IllegalStateException(("lineHeight can't be negative (" + TextUnit.m4040getValueimpl(m3506getLineHeightXSAIIZE()) + ')').toString());
            }
        }
    }

    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m3507getTextAlignbuA522U() {
        return this.textAlign;
    }

    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m3508getTextDirectionmmuk1to() {
        return this.textDirection;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParagraphStyle(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : textAlign2, (i & 2) != 0 ? null : textDirection2, (i & 4) != 0 ? TextUnit.Companion.m4051getUnspecifiedXSAIIZE() : j, (i & 8) != 0 ? null : textIndent2, (DefaultConstructorMarker) null);
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m3506getLineHeightXSAIIZE() {
        return this.lineHeight;
    }

    public final TextIndent getTextIndent() {
        return this.textIndent;
    }

    public static /* synthetic */ ParagraphStyle merge$default(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, int i, Object obj) {
        if ((i & 1) != 0) {
            paragraphStyle2 = null;
        }
        return paragraphStyle.merge(paragraphStyle2);
    }

    public final ParagraphStyle merge(ParagraphStyle paragraphStyle) {
        long j;
        if (paragraphStyle == null) {
            return this;
        }
        if (TextUnitKt.m4058isUnspecifiedR2X_6o(paragraphStyle.m3506getLineHeightXSAIIZE())) {
            j = m3506getLineHeightXSAIIZE();
        } else {
            j = paragraphStyle.m3506getLineHeightXSAIIZE();
        }
        long j2 = j;
        TextIndent textIndent2 = paragraphStyle.textIndent;
        if (textIndent2 == null) {
            textIndent2 = this.textIndent;
        }
        TextIndent textIndent3 = textIndent2;
        TextAlign r0 = paragraphStyle.m3507getTextAlignbuA522U();
        if (r0 == null) {
            r0 = m3507getTextAlignbuA522U();
        }
        TextAlign textAlign2 = r0;
        TextDirection r10 = paragraphStyle.m3508getTextDirectionmmuk1to();
        if (r10 == null) {
            r10 = m3508getTextDirectionmmuk1to();
        }
        return new ParagraphStyle(textAlign2, r10, j2, textIndent3, (DefaultConstructorMarker) null);
    }

    public final ParagraphStyle plus(ParagraphStyle paragraphStyle) {
        Intrinsics.checkNotNullParameter(paragraphStyle, "other");
        return merge(paragraphStyle);
    }

    /* renamed from: copy-Elsmlbk$default  reason: not valid java name */
    public static /* synthetic */ ParagraphStyle m3504copyElsmlbk$default(ParagraphStyle paragraphStyle, TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2, int i, Object obj) {
        if ((i & 1) != 0) {
            textAlign2 = paragraphStyle.m3507getTextAlignbuA522U();
        }
        if ((i & 2) != 0) {
            textDirection2 = paragraphStyle.m3508getTextDirectionmmuk1to();
        }
        TextDirection textDirection3 = textDirection2;
        if ((i & 4) != 0) {
            j = paragraphStyle.m3506getLineHeightXSAIIZE();
        }
        long j2 = j;
        if ((i & 8) != 0) {
            textIndent2 = paragraphStyle.textIndent;
        }
        return paragraphStyle.m3505copyElsmlbk(textAlign2, textDirection3, j2, textIndent2);
    }

    /* renamed from: copy-Elsmlbk  reason: not valid java name */
    public final ParagraphStyle m3505copyElsmlbk(TextAlign textAlign2, TextDirection textDirection2, long j, TextIndent textIndent2) {
        return new ParagraphStyle(textAlign2, textDirection2, j, textIndent2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphStyle)) {
            return false;
        }
        ParagraphStyle paragraphStyle = (ParagraphStyle) obj;
        return Intrinsics.areEqual((Object) m3507getTextAlignbuA522U(), (Object) paragraphStyle.m3507getTextAlignbuA522U()) && Intrinsics.areEqual((Object) m3508getTextDirectionmmuk1to(), (Object) paragraphStyle.m3508getTextDirectionmmuk1to()) && TextUnit.m4037equalsimpl0(m3506getLineHeightXSAIIZE(), paragraphStyle.m3506getLineHeightXSAIIZE()) && Intrinsics.areEqual((Object) this.textIndent, (Object) paragraphStyle.textIndent);
    }

    public int hashCode() {
        TextAlign r0 = m3507getTextAlignbuA522U();
        int i = 0;
        int r02 = (r0 == null ? 0 : TextAlign.m3753hashCodeimpl(r0.m3755unboximpl())) * 31;
        TextDirection r2 = m3508getTextDirectionmmuk1to();
        int r03 = (((r02 + (r2 == null ? 0 : TextDirection.m3766hashCodeimpl(r2.m3768unboximpl()))) * 31) + TextUnit.m4041hashCodeimpl(m3506getLineHeightXSAIIZE())) * 31;
        TextIndent textIndent2 = this.textIndent;
        if (textIndent2 != null) {
            i = textIndent2.hashCode();
        }
        return r03 + i;
    }

    public String toString() {
        return "ParagraphStyle(textAlign=" + m3507getTextAlignbuA522U() + ", textDirection=" + m3508getTextDirectionmmuk1to() + ", lineHeight=" + TextUnit.m4047toStringimpl(m3506getLineHeightXSAIIZE()) + ", textIndent=" + this.textIndent + ')';
    }
}
