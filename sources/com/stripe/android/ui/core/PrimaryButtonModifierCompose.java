package com.stripe.android.ui.core;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\rJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0014\u001a\u00020\u0007HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\nJ4\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Lcom/stripe/android/ui/core/PrimaryButtonModifierCompose;", "", "onPrimary", "Landroidx/compose/ui/graphics/Color;", "style", "Landroidx/compose/ui/text/TextStyle;", "height", "Landroidx/compose/ui/unit/Dp;", "(JLandroidx/compose/ui/text/TextStyle;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHeight-D9Ej5fM", "()F", "F", "getOnPrimary-0d7_KjU", "()J", "J", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "component1", "component1-0d7_KjU", "component2", "component3", "component3-D9Ej5fM", "copy", "copy-gMqxd7g", "(JLandroidx/compose/ui/text/TextStyle;F)Lcom/stripe/android/ui/core/PrimaryButtonModifierCompose;", "equals", "", "other", "hashCode", "", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentsTheme.kt */
public final class PrimaryButtonModifierCompose {
    public static final int $stable = 0;
    private final float height;
    private final long onPrimary;
    private final TextStyle style;

    public /* synthetic */ PrimaryButtonModifierCompose(long j, TextStyle textStyle, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, textStyle, f);
    }

    /* renamed from: copy-gMqxd7g$default  reason: not valid java name */
    public static /* synthetic */ PrimaryButtonModifierCompose m4543copygMqxd7g$default(PrimaryButtonModifierCompose primaryButtonModifierCompose, long j, TextStyle textStyle, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = primaryButtonModifierCompose.onPrimary;
        }
        if ((i & 2) != 0) {
            textStyle = primaryButtonModifierCompose.style;
        }
        if ((i & 4) != 0) {
            f = primaryButtonModifierCompose.height;
        }
        return primaryButtonModifierCompose.m4546copygMqxd7g(j, textStyle, f);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m4544component10d7_KjU() {
        return this.onPrimary;
    }

    public final TextStyle component2() {
        return this.style;
    }

    /* renamed from: component3-D9Ej5fM  reason: not valid java name */
    public final float m4545component3D9Ej5fM() {
        return this.height;
    }

    /* renamed from: copy-gMqxd7g  reason: not valid java name */
    public final PrimaryButtonModifierCompose m4546copygMqxd7g(long j, TextStyle textStyle, float f) {
        Intrinsics.checkNotNullParameter(textStyle, "style");
        return new PrimaryButtonModifierCompose(j, textStyle, f, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrimaryButtonModifierCompose)) {
            return false;
        }
        PrimaryButtonModifierCompose primaryButtonModifierCompose = (PrimaryButtonModifierCompose) obj;
        return Color.m1597equalsimpl0(this.onPrimary, primaryButtonModifierCompose.onPrimary) && Intrinsics.areEqual((Object) this.style, (Object) primaryButtonModifierCompose.style) && Dp.m3864equalsimpl0(this.height, primaryButtonModifierCompose.height);
    }

    public int hashCode() {
        return (((Color.m1603hashCodeimpl(this.onPrimary) * 31) + this.style.hashCode()) * 31) + Dp.m3865hashCodeimpl(this.height);
    }

    public String toString() {
        return "PrimaryButtonModifierCompose(onPrimary=" + Color.m1604toStringimpl(this.onPrimary) + ", style=" + this.style + ", height=" + Dp.m3870toStringimpl(this.height) + ')';
    }

    private PrimaryButtonModifierCompose(long j, TextStyle textStyle, float f) {
        this.onPrimary = j;
        this.style = textStyle;
        this.height = f;
    }

    /* renamed from: getOnPrimary-0d7_KjU  reason: not valid java name */
    public final long m4548getOnPrimary0d7_KjU() {
        return this.onPrimary;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m4547getHeightD9Ej5fM() {
        return this.height;
    }
}
