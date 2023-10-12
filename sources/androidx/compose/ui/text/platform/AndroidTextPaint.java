package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001b\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setColor", "", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setShadow", "setTextDecoration", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidTextPaint.android.kt */
public final class AndroidTextPaint extends TextPaint {
    private Shadow shadow = Shadow.Companion.getNone();
    private TextDecoration textDecoration = TextDecoration.Companion.getNone();

    public AndroidTextPaint(int i, float f) {
        super(i);
        this.density = f;
    }

    public final void setTextDecoration(TextDecoration textDecoration2) {
        if (textDecoration2 == null) {
            textDecoration2 = TextDecoration.Companion.getNone();
        }
        if (!Intrinsics.areEqual((Object) this.textDecoration, (Object) textDecoration2)) {
            this.textDecoration = textDecoration2;
            setUnderlineText(textDecoration2.contains(TextDecoration.Companion.getUnderline()));
            setStrikeThruText(this.textDecoration.contains(TextDecoration.Companion.getLineThrough()));
        }
    }

    public final void setShadow(Shadow shadow2) {
        if (shadow2 == null) {
            shadow2 = Shadow.Companion.getNone();
        }
        if (!Intrinsics.areEqual((Object) this.shadow, (Object) shadow2)) {
            this.shadow = shadow2;
            if (Intrinsics.areEqual((Object) shadow2, (Object) Shadow.Companion.getNone())) {
                clearShadowLayer();
            } else {
                setShadowLayer(this.shadow.getBlurRadius(), Offset.m1353getXimpl(this.shadow.m1894getOffsetF1C5BW0()), Offset.m1354getYimpl(this.shadow.m1894getOffsetF1C5BW0()), ColorKt.m1651toArgb8_81llA(this.shadow.m1893getColor0d7_KjU()));
            }
        }
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public final void m3708setColor8_81llA(long j) {
        int r4;
        if ((j != Color.Companion.m1632getUnspecified0d7_KjU()) && getColor() != (r4 = ColorKt.m1651toArgb8_81llA(j))) {
            setColor(r4);
        }
    }
}
