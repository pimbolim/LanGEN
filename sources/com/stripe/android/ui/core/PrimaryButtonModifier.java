package com.stripe.android.ui.core;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BT\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\b\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u001d\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0010J\u0019\u0010\u001f\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b \u0010\u0010J\u0019\u0010!\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u0010J\u0019\u0010#\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0010J\t\u0010%\u001a\u00020\bHÆ\u0003J\u0019\u0010&\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b'\u0010\u0010J\t\u0010(\u001a\u00020\bHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\bHÆ\u0003Jr\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\fHÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u001c\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001b\u0010\u0010R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001c\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Lcom/stripe/android/ui/core/PrimaryButtonModifier;", "", "primaryLight", "Landroidx/compose/ui/graphics/Color;", "onPrimaryLight", "primaryDark", "onPrimaryDark", "cornerRadius", "", "border", "borderStrokeWidth", "fontFamily", "", "height", "(JJJJFJFLjava/lang/Integer;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBorder-0d7_KjU", "()J", "J", "getBorderStrokeWidth", "()F", "getCornerRadius", "getFontFamily", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getOnPrimaryDark-0d7_KjU", "getOnPrimaryLight-0d7_KjU", "getPrimaryDark-0d7_KjU", "getPrimaryLight-0d7_KjU", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component6", "component6-0d7_KjU", "component7", "component8", "component9", "copy", "copy-Fg9rjvU", "(JJJJFJFLjava/lang/Integer;F)Lcom/stripe/android/ui/core/PrimaryButtonModifier;", "equals", "", "other", "hashCode", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentsTheme.kt */
public final class PrimaryButtonModifier {
    public static final int $stable = 0;
    private final long border;
    private final float borderStrokeWidth;
    private final float cornerRadius;
    private final Integer fontFamily;
    private final float height;
    private final long onPrimaryDark;
    private final long onPrimaryLight;
    private final long primaryDark;
    private final long primaryLight;

    public /* synthetic */ PrimaryButtonModifier(long j, long j2, long j3, long j4, float f, long j5, float f2, Integer num, float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, f, j5, f2, num, f3);
    }

    /* renamed from: copy-Fg9rjvU$default  reason: not valid java name */
    public static /* synthetic */ PrimaryButtonModifier m4531copyFg9rjvU$default(PrimaryButtonModifier primaryButtonModifier, long j, long j2, long j3, long j4, float f, long j5, float f2, Integer num, float f3, int i, Object obj) {
        PrimaryButtonModifier primaryButtonModifier2 = primaryButtonModifier;
        int i2 = i;
        return primaryButtonModifier.m4537copyFg9rjvU((i2 & 1) != 0 ? primaryButtonModifier2.primaryLight : j, (i2 & 2) != 0 ? primaryButtonModifier2.onPrimaryLight : j2, (i2 & 4) != 0 ? primaryButtonModifier2.primaryDark : j3, (i2 & 8) != 0 ? primaryButtonModifier2.onPrimaryDark : j4, (i2 & 16) != 0 ? primaryButtonModifier2.cornerRadius : f, (i2 & 32) != 0 ? primaryButtonModifier2.border : j5, (i2 & 64) != 0 ? primaryButtonModifier2.borderStrokeWidth : f2, (i2 & 128) != 0 ? primaryButtonModifier2.fontFamily : num, (i2 & 256) != 0 ? primaryButtonModifier2.height : f3);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m4532component10d7_KjU() {
        return this.primaryLight;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m4533component20d7_KjU() {
        return this.onPrimaryLight;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m4534component30d7_KjU() {
        return this.primaryDark;
    }

    /* renamed from: component4-0d7_KjU  reason: not valid java name */
    public final long m4535component40d7_KjU() {
        return this.onPrimaryDark;
    }

    public final float component5() {
        return this.cornerRadius;
    }

    /* renamed from: component6-0d7_KjU  reason: not valid java name */
    public final long m4536component60d7_KjU() {
        return this.border;
    }

    public final float component7() {
        return this.borderStrokeWidth;
    }

    public final Integer component8() {
        return this.fontFamily;
    }

    public final float component9() {
        return this.height;
    }

    /* renamed from: copy-Fg9rjvU  reason: not valid java name */
    public final PrimaryButtonModifier m4537copyFg9rjvU(long j, long j2, long j3, long j4, float f, long j5, float f2, Integer num, float f3) {
        return new PrimaryButtonModifier(j, j2, j3, j4, f, j5, f2, num, f3, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrimaryButtonModifier)) {
            return false;
        }
        PrimaryButtonModifier primaryButtonModifier = (PrimaryButtonModifier) obj;
        return Color.m1597equalsimpl0(this.primaryLight, primaryButtonModifier.primaryLight) && Color.m1597equalsimpl0(this.onPrimaryLight, primaryButtonModifier.onPrimaryLight) && Color.m1597equalsimpl0(this.primaryDark, primaryButtonModifier.primaryDark) && Color.m1597equalsimpl0(this.onPrimaryDark, primaryButtonModifier.onPrimaryDark) && Intrinsics.areEqual((Object) Float.valueOf(this.cornerRadius), (Object) Float.valueOf(primaryButtonModifier.cornerRadius)) && Color.m1597equalsimpl0(this.border, primaryButtonModifier.border) && Intrinsics.areEqual((Object) Float.valueOf(this.borderStrokeWidth), (Object) Float.valueOf(primaryButtonModifier.borderStrokeWidth)) && Intrinsics.areEqual((Object) this.fontFamily, (Object) primaryButtonModifier.fontFamily) && Intrinsics.areEqual((Object) Float.valueOf(this.height), (Object) Float.valueOf(primaryButtonModifier.height));
    }

    public int hashCode() {
        int r0 = ((((((((((((Color.m1603hashCodeimpl(this.primaryLight) * 31) + Color.m1603hashCodeimpl(this.onPrimaryLight)) * 31) + Color.m1603hashCodeimpl(this.primaryDark)) * 31) + Color.m1603hashCodeimpl(this.onPrimaryDark)) * 31) + Float.floatToIntBits(this.cornerRadius)) * 31) + Color.m1603hashCodeimpl(this.border)) * 31) + Float.floatToIntBits(this.borderStrokeWidth)) * 31;
        Integer num = this.fontFamily;
        return ((r0 + (num == null ? 0 : num.hashCode())) * 31) + Float.floatToIntBits(this.height);
    }

    public String toString() {
        return "PrimaryButtonModifier(primaryLight=" + Color.m1604toStringimpl(this.primaryLight) + ", onPrimaryLight=" + Color.m1604toStringimpl(this.onPrimaryLight) + ", primaryDark=" + Color.m1604toStringimpl(this.primaryDark) + ", onPrimaryDark=" + Color.m1604toStringimpl(this.onPrimaryDark) + ", cornerRadius=" + this.cornerRadius + ", border=" + Color.m1604toStringimpl(this.border) + ", borderStrokeWidth=" + this.borderStrokeWidth + ", fontFamily=" + this.fontFamily + ", height=" + this.height + ')';
    }

    private PrimaryButtonModifier(long j, long j2, long j3, long j4, float f, long j5, float f2, Integer num, float f3) {
        this.primaryLight = j;
        this.onPrimaryLight = j2;
        this.primaryDark = j3;
        this.onPrimaryDark = j4;
        this.cornerRadius = f;
        this.border = j5;
        this.borderStrokeWidth = f2;
        this.fontFamily = num;
        this.height = f3;
    }

    /* renamed from: getPrimaryLight-0d7_KjU  reason: not valid java name */
    public final long m4542getPrimaryLight0d7_KjU() {
        return this.primaryLight;
    }

    /* renamed from: getOnPrimaryLight-0d7_KjU  reason: not valid java name */
    public final long m4540getOnPrimaryLight0d7_KjU() {
        return this.onPrimaryLight;
    }

    /* renamed from: getPrimaryDark-0d7_KjU  reason: not valid java name */
    public final long m4541getPrimaryDark0d7_KjU() {
        return this.primaryDark;
    }

    /* renamed from: getOnPrimaryDark-0d7_KjU  reason: not valid java name */
    public final long m4539getOnPrimaryDark0d7_KjU() {
        return this.onPrimaryDark;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    /* renamed from: getBorder-0d7_KjU  reason: not valid java name */
    public final long m4538getBorder0d7_KjU() {
        return this.border;
    }

    public final float getBorderStrokeWidth() {
        return this.borderStrokeWidth;
    }

    public final Integer getFontFamily() {
        return this.fontFamily;
    }

    public final float getHeight() {
        return this.height;
    }
}
