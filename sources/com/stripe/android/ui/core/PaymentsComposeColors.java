package com.stripe.android.ui.core;

import androidx.compose.material.Colors;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\u0018\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u000eJ\u0019\u0010\u001a\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u000eJ\u0019\u0010\u001c\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u000eJ\u0019\u0010\u001e\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u000eJ\u0019\u0010 \u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b!\u0010\u000eJ\u0019\u0010\"\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b#\u0010\u000eJ\u0019\u0010$\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b%\u0010\u000eJ\t\u0010&\u001a\u00020\u000bHÆ\u0003Jf\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u001c\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, d2 = {"Lcom/stripe/android/ui/core/PaymentsComposeColors;", "", "component", "Landroidx/compose/ui/graphics/Color;", "colorComponentBorder", "colorComponentDivider", "subtitle", "colorTextCursor", "placeholderText", "onComponent", "material", "Landroidx/compose/material/Colors;", "(JJJJJJJLandroidx/compose/material/Colors;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColorComponentBorder-0d7_KjU", "()J", "J", "getColorComponentDivider-0d7_KjU", "getColorTextCursor-0d7_KjU", "getComponent-0d7_KjU", "getMaterial", "()Landroidx/compose/material/Colors;", "getOnComponent-0d7_KjU", "getPlaceholderText-0d7_KjU", "getSubtitle-0d7_KjU", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", "component7", "component7-0d7_KjU", "component8", "copy", "copy-MZa7t-8", "(JJJJJJJLandroidx/compose/material/Colors;)Lcom/stripe/android/ui/core/PaymentsComposeColors;", "equals", "", "other", "hashCode", "", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentsTheme.kt */
public final class PaymentsComposeColors {
    public static final int $stable = 0;
    private final long colorComponentBorder;
    private final long colorComponentDivider;
    private final long colorTextCursor;
    private final long component;
    private final Colors material;
    private final long onComponent;
    private final long placeholderText;
    private final long subtitle;

    public /* synthetic */ PaymentsComposeColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, Colors colors, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, colors);
    }

    /* renamed from: copy-MZa7t-8$default  reason: not valid java name */
    public static /* synthetic */ PaymentsComposeColors m4492copyMZa7t8$default(PaymentsComposeColors paymentsComposeColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, Colors colors, int i, Object obj) {
        PaymentsComposeColors paymentsComposeColors2 = paymentsComposeColors;
        int i2 = i;
        return paymentsComposeColors.m4500copyMZa7t8((i2 & 1) != 0 ? paymentsComposeColors2.component : j, (i2 & 2) != 0 ? paymentsComposeColors2.colorComponentBorder : j2, (i2 & 4) != 0 ? paymentsComposeColors2.colorComponentDivider : j3, (i2 & 8) != 0 ? paymentsComposeColors2.subtitle : j4, (i2 & 16) != 0 ? paymentsComposeColors2.colorTextCursor : j5, (i2 & 32) != 0 ? paymentsComposeColors2.placeholderText : j6, (i2 & 64) != 0 ? paymentsComposeColors2.onComponent : j7, (i2 & 128) != 0 ? paymentsComposeColors2.material : colors);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m4493component10d7_KjU() {
        return this.component;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m4494component20d7_KjU() {
        return this.colorComponentBorder;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m4495component30d7_KjU() {
        return this.colorComponentDivider;
    }

    /* renamed from: component4-0d7_KjU  reason: not valid java name */
    public final long m4496component40d7_KjU() {
        return this.subtitle;
    }

    /* renamed from: component5-0d7_KjU  reason: not valid java name */
    public final long m4497component50d7_KjU() {
        return this.colorTextCursor;
    }

    /* renamed from: component6-0d7_KjU  reason: not valid java name */
    public final long m4498component60d7_KjU() {
        return this.placeholderText;
    }

    /* renamed from: component7-0d7_KjU  reason: not valid java name */
    public final long m4499component70d7_KjU() {
        return this.onComponent;
    }

    public final Colors component8() {
        return this.material;
    }

    /* renamed from: copy-MZa7t-8  reason: not valid java name */
    public final PaymentsComposeColors m4500copyMZa7t8(long j, long j2, long j3, long j4, long j5, long j6, long j7, Colors colors) {
        long j8 = j;
        Intrinsics.checkNotNullParameter(colors, "material");
        return new PaymentsComposeColors(j, j2, j3, j4, j5, j6, j7, colors, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentsComposeColors)) {
            return false;
        }
        PaymentsComposeColors paymentsComposeColors = (PaymentsComposeColors) obj;
        return Color.m1597equalsimpl0(this.component, paymentsComposeColors.component) && Color.m1597equalsimpl0(this.colorComponentBorder, paymentsComposeColors.colorComponentBorder) && Color.m1597equalsimpl0(this.colorComponentDivider, paymentsComposeColors.colorComponentDivider) && Color.m1597equalsimpl0(this.subtitle, paymentsComposeColors.subtitle) && Color.m1597equalsimpl0(this.colorTextCursor, paymentsComposeColors.colorTextCursor) && Color.m1597equalsimpl0(this.placeholderText, paymentsComposeColors.placeholderText) && Color.m1597equalsimpl0(this.onComponent, paymentsComposeColors.onComponent) && Intrinsics.areEqual((Object) this.material, (Object) paymentsComposeColors.material);
    }

    public int hashCode() {
        return (((((((((((((Color.m1603hashCodeimpl(this.component) * 31) + Color.m1603hashCodeimpl(this.colorComponentBorder)) * 31) + Color.m1603hashCodeimpl(this.colorComponentDivider)) * 31) + Color.m1603hashCodeimpl(this.subtitle)) * 31) + Color.m1603hashCodeimpl(this.colorTextCursor)) * 31) + Color.m1603hashCodeimpl(this.placeholderText)) * 31) + Color.m1603hashCodeimpl(this.onComponent)) * 31) + this.material.hashCode();
    }

    public String toString() {
        return "PaymentsComposeColors(component=" + Color.m1604toStringimpl(this.component) + ", colorComponentBorder=" + Color.m1604toStringimpl(this.colorComponentBorder) + ", colorComponentDivider=" + Color.m1604toStringimpl(this.colorComponentDivider) + ", subtitle=" + Color.m1604toStringimpl(this.subtitle) + ", colorTextCursor=" + Color.m1604toStringimpl(this.colorTextCursor) + ", placeholderText=" + Color.m1604toStringimpl(this.placeholderText) + ", onComponent=" + Color.m1604toStringimpl(this.onComponent) + ", material=" + this.material + ')';
    }

    private PaymentsComposeColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, Colors colors) {
        this.component = j;
        this.colorComponentBorder = j2;
        this.colorComponentDivider = j3;
        this.subtitle = j4;
        this.colorTextCursor = j5;
        this.placeholderText = j6;
        this.onComponent = j7;
        this.material = colors;
    }

    /* renamed from: getComponent-0d7_KjU  reason: not valid java name */
    public final long m4504getComponent0d7_KjU() {
        return this.component;
    }

    /* renamed from: getColorComponentBorder-0d7_KjU  reason: not valid java name */
    public final long m4501getColorComponentBorder0d7_KjU() {
        return this.colorComponentBorder;
    }

    /* renamed from: getColorComponentDivider-0d7_KjU  reason: not valid java name */
    public final long m4502getColorComponentDivider0d7_KjU() {
        return this.colorComponentDivider;
    }

    /* renamed from: getSubtitle-0d7_KjU  reason: not valid java name */
    public final long m4507getSubtitle0d7_KjU() {
        return this.subtitle;
    }

    /* renamed from: getColorTextCursor-0d7_KjU  reason: not valid java name */
    public final long m4503getColorTextCursor0d7_KjU() {
        return this.colorTextCursor;
    }

    /* renamed from: getPlaceholderText-0d7_KjU  reason: not valid java name */
    public final long m4506getPlaceholderText0d7_KjU() {
        return this.placeholderText;
    }

    /* renamed from: getOnComponent-0d7_KjU  reason: not valid java name */
    public final long m4505getOnComponent0d7_KjU() {
        return this.onComponent;
    }

    public final Colors getMaterial() {
        return this.material;
    }
}
