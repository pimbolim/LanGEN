package com.stripe.android.ui.core;

import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bd\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0019\u0010#\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b$\u0010\u001bJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u0019\u0010)\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b*\u0010\u001bJ\u0019\u0010+\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b,\u0010\u001bJ\u0019\u0010-\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b.\u0010\u001bJ\u0019\u0010/\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b0\u0010\u001bJ\u0019\u00101\u001a\u00020\tHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b2\u0010\u001bJ\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020;HÖ\u0001R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\f\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u001c\u0010\u000b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u001c\u0010\u000e\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001bR\u001c\u0010\n\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b!\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006<"}, d2 = {"Lcom/stripe/android/ui/core/PaymentsTypography;", "", "fontWeightNormal", "", "fontWeightMedium", "fontWeightBold", "fontSizeMultiplier", "", "xxSmallFontSize", "Landroidx/compose/ui/unit/TextUnit;", "xSmallFontSize", "smallFontSize", "mediumFontSize", "largeFontSize", "xLargeFontSize", "fontFamily", "(IIIFJJJJJJLjava/lang/Integer;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFontFamily", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFontSizeMultiplier", "()F", "getFontWeightBold", "()I", "getFontWeightMedium", "getFontWeightNormal", "getLargeFontSize-XSAIIZE", "()J", "J", "getMediumFontSize-XSAIIZE", "getSmallFontSize-XSAIIZE", "getXLargeFontSize-XSAIIZE", "getXSmallFontSize-XSAIIZE", "getXxSmallFontSize-XSAIIZE", "component1", "component10", "component10-XSAIIZE", "component11", "component2", "component3", "component4", "component5", "component5-XSAIIZE", "component6", "component6-XSAIIZE", "component7", "component7-XSAIIZE", "component8", "component8-XSAIIZE", "component9", "component9-XSAIIZE", "copy", "copy-D6c4kWA", "(IIIFJJJJJJLjava/lang/Integer;)Lcom/stripe/android/ui/core/PaymentsTypography;", "equals", "", "other", "hashCode", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentsTheme.kt */
public final class PaymentsTypography {
    public static final int $stable = 0;
    private final Integer fontFamily;
    private final float fontSizeMultiplier;
    private final int fontWeightBold;
    private final int fontWeightMedium;
    private final int fontWeightNormal;
    private final long largeFontSize;
    private final long mediumFontSize;
    private final long smallFontSize;
    private final long xLargeFontSize;
    private final long xSmallFontSize;
    private final long xxSmallFontSize;

    public /* synthetic */ PaymentsTypography(int i, int i2, int i3, float f, long j, long j2, long j3, long j4, long j5, long j6, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, f, j, j2, j3, j4, j5, j6, num);
    }

    /* renamed from: copy-D6c4kWA$default  reason: not valid java name */
    public static /* synthetic */ PaymentsTypography m4517copyD6c4kWA$default(PaymentsTypography paymentsTypography, int i, int i2, int i3, float f, long j, long j2, long j3, long j4, long j5, long j6, Integer num, int i4, Object obj) {
        PaymentsTypography paymentsTypography2 = paymentsTypography;
        int i5 = i4;
        return paymentsTypography.m4524copyD6c4kWA((i5 & 1) != 0 ? paymentsTypography2.fontWeightNormal : i, (i5 & 2) != 0 ? paymentsTypography2.fontWeightMedium : i2, (i5 & 4) != 0 ? paymentsTypography2.fontWeightBold : i3, (i5 & 8) != 0 ? paymentsTypography2.fontSizeMultiplier : f, (i5 & 16) != 0 ? paymentsTypography2.xxSmallFontSize : j, (i5 & 32) != 0 ? paymentsTypography2.xSmallFontSize : j2, (i5 & 64) != 0 ? paymentsTypography2.smallFontSize : j3, (i5 & 128) != 0 ? paymentsTypography2.mediumFontSize : j4, (i5 & 256) != 0 ? paymentsTypography2.largeFontSize : j5, (i5 & 512) != 0 ? paymentsTypography2.xLargeFontSize : j6, (i5 & 1024) != 0 ? paymentsTypography2.fontFamily : num);
    }

    public final int component1() {
        return this.fontWeightNormal;
    }

    /* renamed from: component10-XSAIIZE  reason: not valid java name */
    public final long m4518component10XSAIIZE() {
        return this.xLargeFontSize;
    }

    public final Integer component11() {
        return this.fontFamily;
    }

    public final int component2() {
        return this.fontWeightMedium;
    }

    public final int component3() {
        return this.fontWeightBold;
    }

    public final float component4() {
        return this.fontSizeMultiplier;
    }

    /* renamed from: component5-XSAIIZE  reason: not valid java name */
    public final long m4519component5XSAIIZE() {
        return this.xxSmallFontSize;
    }

    /* renamed from: component6-XSAIIZE  reason: not valid java name */
    public final long m4520component6XSAIIZE() {
        return this.xSmallFontSize;
    }

    /* renamed from: component7-XSAIIZE  reason: not valid java name */
    public final long m4521component7XSAIIZE() {
        return this.smallFontSize;
    }

    /* renamed from: component8-XSAIIZE  reason: not valid java name */
    public final long m4522component8XSAIIZE() {
        return this.mediumFontSize;
    }

    /* renamed from: component9-XSAIIZE  reason: not valid java name */
    public final long m4523component9XSAIIZE() {
        return this.largeFontSize;
    }

    /* renamed from: copy-D6c4kWA  reason: not valid java name */
    public final PaymentsTypography m4524copyD6c4kWA(int i, int i2, int i3, float f, long j, long j2, long j3, long j4, long j5, long j6, Integer num) {
        return new PaymentsTypography(i, i2, i3, f, j, j2, j3, j4, j5, j6, num, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentsTypography)) {
            return false;
        }
        PaymentsTypography paymentsTypography = (PaymentsTypography) obj;
        return this.fontWeightNormal == paymentsTypography.fontWeightNormal && this.fontWeightMedium == paymentsTypography.fontWeightMedium && this.fontWeightBold == paymentsTypography.fontWeightBold && Intrinsics.areEqual((Object) Float.valueOf(this.fontSizeMultiplier), (Object) Float.valueOf(paymentsTypography.fontSizeMultiplier)) && TextUnit.m4037equalsimpl0(this.xxSmallFontSize, paymentsTypography.xxSmallFontSize) && TextUnit.m4037equalsimpl0(this.xSmallFontSize, paymentsTypography.xSmallFontSize) && TextUnit.m4037equalsimpl0(this.smallFontSize, paymentsTypography.smallFontSize) && TextUnit.m4037equalsimpl0(this.mediumFontSize, paymentsTypography.mediumFontSize) && TextUnit.m4037equalsimpl0(this.largeFontSize, paymentsTypography.largeFontSize) && TextUnit.m4037equalsimpl0(this.xLargeFontSize, paymentsTypography.xLargeFontSize) && Intrinsics.areEqual((Object) this.fontFamily, (Object) paymentsTypography.fontFamily);
    }

    public int hashCode() {
        int floatToIntBits = ((((((((((((((((((this.fontWeightNormal * 31) + this.fontWeightMedium) * 31) + this.fontWeightBold) * 31) + Float.floatToIntBits(this.fontSizeMultiplier)) * 31) + TextUnit.m4041hashCodeimpl(this.xxSmallFontSize)) * 31) + TextUnit.m4041hashCodeimpl(this.xSmallFontSize)) * 31) + TextUnit.m4041hashCodeimpl(this.smallFontSize)) * 31) + TextUnit.m4041hashCodeimpl(this.mediumFontSize)) * 31) + TextUnit.m4041hashCodeimpl(this.largeFontSize)) * 31) + TextUnit.m4041hashCodeimpl(this.xLargeFontSize)) * 31;
        Integer num = this.fontFamily;
        return floatToIntBits + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "PaymentsTypography(fontWeightNormal=" + this.fontWeightNormal + ", fontWeightMedium=" + this.fontWeightMedium + ", fontWeightBold=" + this.fontWeightBold + ", fontSizeMultiplier=" + this.fontSizeMultiplier + ", xxSmallFontSize=" + TextUnit.m4047toStringimpl(this.xxSmallFontSize) + ", xSmallFontSize=" + TextUnit.m4047toStringimpl(this.xSmallFontSize) + ", smallFontSize=" + TextUnit.m4047toStringimpl(this.smallFontSize) + ", mediumFontSize=" + TextUnit.m4047toStringimpl(this.mediumFontSize) + ", largeFontSize=" + TextUnit.m4047toStringimpl(this.largeFontSize) + ", xLargeFontSize=" + TextUnit.m4047toStringimpl(this.xLargeFontSize) + ", fontFamily=" + this.fontFamily + ')';
    }

    private PaymentsTypography(int i, int i2, int i3, float f, long j, long j2, long j3, long j4, long j5, long j6, Integer num) {
        this.fontWeightNormal = i;
        this.fontWeightMedium = i2;
        this.fontWeightBold = i3;
        this.fontSizeMultiplier = f;
        this.xxSmallFontSize = j;
        this.xSmallFontSize = j2;
        this.smallFontSize = j3;
        this.mediumFontSize = j4;
        this.largeFontSize = j5;
        this.xLargeFontSize = j6;
        this.fontFamily = num;
    }

    public final int getFontWeightNormal() {
        return this.fontWeightNormal;
    }

    public final int getFontWeightMedium() {
        return this.fontWeightMedium;
    }

    public final int getFontWeightBold() {
        return this.fontWeightBold;
    }

    public final float getFontSizeMultiplier() {
        return this.fontSizeMultiplier;
    }

    /* renamed from: getXxSmallFontSize-XSAIIZE  reason: not valid java name */
    public final long m4530getXxSmallFontSizeXSAIIZE() {
        return this.xxSmallFontSize;
    }

    /* renamed from: getXSmallFontSize-XSAIIZE  reason: not valid java name */
    public final long m4529getXSmallFontSizeXSAIIZE() {
        return this.xSmallFontSize;
    }

    /* renamed from: getSmallFontSize-XSAIIZE  reason: not valid java name */
    public final long m4527getSmallFontSizeXSAIIZE() {
        return this.smallFontSize;
    }

    /* renamed from: getMediumFontSize-XSAIIZE  reason: not valid java name */
    public final long m4526getMediumFontSizeXSAIIZE() {
        return this.mediumFontSize;
    }

    /* renamed from: getLargeFontSize-XSAIIZE  reason: not valid java name */
    public final long m4525getLargeFontSizeXSAIIZE() {
        return this.largeFontSize;
    }

    /* renamed from: getXLargeFontSize-XSAIIZE  reason: not valid java name */
    public final long m4528getXLargeFontSizeXSAIIZE() {
        return this.xLargeFontSize;
    }

    public final Integer getFontFamily() {
        return this.fontFamily;
    }
}
