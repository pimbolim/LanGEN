package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u001f\b\u0002\u0018\u00002\u00020\u0001B¥\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0018\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\"¨\u0006;"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutParams;", "", "text", "", "start", "", "end", "paint", "Landroid/text/TextPaint;", "width", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "hyphenationFrequency", "leftIndents", "", "rightIndents", "(Ljava/lang/CharSequence;IILandroid/text/TextPaint;ILandroid/text/TextDirectionHeuristic;Landroid/text/Layout$Alignment;ILandroid/text/TextUtils$TruncateAt;IFFIZZII[I[I)V", "getAlignment", "()Landroid/text/Layout$Alignment;", "getBreakStrategy", "()I", "getEllipsize", "()Landroid/text/TextUtils$TruncateAt;", "getEllipsizedWidth", "getEnd", "getHyphenationFrequency", "getIncludePadding", "()Z", "getJustificationMode", "getLeftIndents", "()[I", "getLineSpacingExtra", "()F", "getLineSpacingMultiplier", "getMaxLines", "getPaint", "()Landroid/text/TextPaint;", "getRightIndents", "getStart", "getText", "()Ljava/lang/CharSequence;", "getTextDir", "()Landroid/text/TextDirectionHeuristic;", "getUseFallbackLineSpacing", "getWidth", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StaticLayoutFactory.kt */
final class StaticLayoutParams {
    private final Layout.Alignment alignment;
    private final int breakStrategy;
    private final TextUtils.TruncateAt ellipsize;
    private final int ellipsizedWidth;
    private final int end;
    private final int hyphenationFrequency;
    private final boolean includePadding;
    private final int justificationMode;
    private final int[] leftIndents;
    private final float lineSpacingExtra;
    private final float lineSpacingMultiplier;
    private final int maxLines;
    private final TextPaint paint;
    private final int[] rightIndents;
    private final int start;
    private final CharSequence text;
    private final TextDirectionHeuristic textDir;
    private final boolean useFallbackLineSpacing;
    private final int width;

    public StaticLayoutParams(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment2, int i4, TextUtils.TruncateAt truncateAt, int i5, float f, float f2, int i6, boolean z, boolean z2, int i7, int i8, int[] iArr, int[] iArr2) {
        int i9 = i;
        int i10 = i2;
        TextPaint textPaint2 = textPaint;
        int i11 = i3;
        TextDirectionHeuristic textDirectionHeuristic2 = textDirectionHeuristic;
        Layout.Alignment alignment3 = alignment2;
        int i12 = i4;
        int i13 = i5;
        float f3 = f;
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(textPaint2, "paint");
        Intrinsics.checkNotNullParameter(textDirectionHeuristic2, "textDir");
        Intrinsics.checkNotNullParameter(alignment3, "alignment");
        this.text = charSequence;
        this.start = i9;
        this.end = i10;
        this.paint = textPaint2;
        this.width = i11;
        this.textDir = textDirectionHeuristic2;
        this.alignment = alignment3;
        this.maxLines = i12;
        this.ellipsize = truncateAt;
        this.ellipsizedWidth = i13;
        this.lineSpacingMultiplier = f3;
        this.lineSpacingExtra = f2;
        this.justificationMode = i6;
        this.includePadding = z;
        this.useFallbackLineSpacing = z2;
        this.breakStrategy = i7;
        this.hyphenationFrequency = i8;
        this.leftIndents = iArr;
        this.rightIndents = iArr2;
        boolean z3 = true;
        if (i9 >= 0 && i9 <= i10) {
            if (i10 >= 0 && i10 <= charSequence.length()) {
                if (i12 >= 0) {
                    if (i11 >= 0) {
                        if (i13 >= 0) {
                            if (!(f3 < 0.0f ? false : z3)) {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StaticLayoutParams(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment2, int i4, TextUtils.TruncateAt truncateAt, int i5, float f, float f2, int i6, boolean z, boolean z2, int i7, int i8, int[] iArr, int[] iArr2, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, (i9 & 2) != 0 ? 0 : i, i2, textPaint, i3, textDirectionHeuristic, alignment2, i4, truncateAt, i5, f, f2, i6, z, z2, i7, i8, iArr, iArr2);
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final int getStart() {
        return this.start;
    }

    public final int getEnd() {
        return this.end;
    }

    public final TextPaint getPaint() {
        return this.paint;
    }

    public final int getWidth() {
        return this.width;
    }

    public final TextDirectionHeuristic getTextDir() {
        return this.textDir;
    }

    public final Layout.Alignment getAlignment() {
        return this.alignment;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.ellipsize;
    }

    public final int getEllipsizedWidth() {
        return this.ellipsizedWidth;
    }

    public final float getLineSpacingMultiplier() {
        return this.lineSpacingMultiplier;
    }

    public final float getLineSpacingExtra() {
        return this.lineSpacingExtra;
    }

    public final int getJustificationMode() {
        return this.justificationMode;
    }

    public final boolean getIncludePadding() {
        return this.includePadding;
    }

    public final boolean getUseFallbackLineSpacing() {
        return this.useFallbackLineSpacing;
    }

    public final int getBreakStrategy() {
        return this.breakStrategy;
    }

    public final int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public final int[] getLeftIndents() {
        return this.leftIndents;
    }

    public final int[] getRightIndents() {
        return this.rightIndents;
    }
}
