package com.stripe.android.ui.core;

import androidx.compose.material.Shapes;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\u000e\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\tJ\u0019\u0010\u0010\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\tJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J4\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/ui/core/PaymentsComposeShapes;", "", "borderStrokeWidth", "Landroidx/compose/ui/unit/Dp;", "borderStrokeWidthSelected", "material", "Landroidx/compose/material/Shapes;", "(FFLandroidx/compose/material/Shapes;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBorderStrokeWidth-D9Ej5fM", "()F", "F", "getBorderStrokeWidthSelected-D9Ej5fM", "getMaterial", "()Landroidx/compose/material/Shapes;", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "component3", "copy", "copy-Md-fbLM", "(FFLandroidx/compose/material/Shapes;)Lcom/stripe/android/ui/core/PaymentsComposeShapes;", "equals", "", "other", "hashCode", "", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentsTheme.kt */
public final class PaymentsComposeShapes {
    public static final int $stable = 0;
    private final float borderStrokeWidth;
    private final float borderStrokeWidthSelected;
    private final Shapes material;

    public /* synthetic */ PaymentsComposeShapes(float f, float f2, Shapes shapes, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, shapes);
    }

    /* renamed from: copy-Md-fbLM$default  reason: not valid java name */
    public static /* synthetic */ PaymentsComposeShapes m4508copyMdfbLM$default(PaymentsComposeShapes paymentsComposeShapes, float f, float f2, Shapes shapes, int i, Object obj) {
        if ((i & 1) != 0) {
            f = paymentsComposeShapes.borderStrokeWidth;
        }
        if ((i & 2) != 0) {
            f2 = paymentsComposeShapes.borderStrokeWidthSelected;
        }
        if ((i & 4) != 0) {
            shapes = paymentsComposeShapes.material;
        }
        return paymentsComposeShapes.m4511copyMdfbLM(f, f2, shapes);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m4509component1D9Ej5fM() {
        return this.borderStrokeWidth;
    }

    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public final float m4510component2D9Ej5fM() {
        return this.borderStrokeWidthSelected;
    }

    public final Shapes component3() {
        return this.material;
    }

    /* renamed from: copy-Md-fbLM  reason: not valid java name */
    public final PaymentsComposeShapes m4511copyMdfbLM(float f, float f2, Shapes shapes) {
        Intrinsics.checkNotNullParameter(shapes, "material");
        return new PaymentsComposeShapes(f, f2, shapes, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentsComposeShapes)) {
            return false;
        }
        PaymentsComposeShapes paymentsComposeShapes = (PaymentsComposeShapes) obj;
        return Dp.m3864equalsimpl0(this.borderStrokeWidth, paymentsComposeShapes.borderStrokeWidth) && Dp.m3864equalsimpl0(this.borderStrokeWidthSelected, paymentsComposeShapes.borderStrokeWidthSelected) && Intrinsics.areEqual((Object) this.material, (Object) paymentsComposeShapes.material);
    }

    public int hashCode() {
        return (((Dp.m3865hashCodeimpl(this.borderStrokeWidth) * 31) + Dp.m3865hashCodeimpl(this.borderStrokeWidthSelected)) * 31) + this.material.hashCode();
    }

    public String toString() {
        return "PaymentsComposeShapes(borderStrokeWidth=" + Dp.m3870toStringimpl(this.borderStrokeWidth) + ", borderStrokeWidthSelected=" + Dp.m3870toStringimpl(this.borderStrokeWidthSelected) + ", material=" + this.material + ')';
    }

    private PaymentsComposeShapes(float f, float f2, Shapes shapes) {
        this.borderStrokeWidth = f;
        this.borderStrokeWidthSelected = f2;
        this.material = shapes;
    }

    /* renamed from: getBorderStrokeWidth-D9Ej5fM  reason: not valid java name */
    public final float m4512getBorderStrokeWidthD9Ej5fM() {
        return this.borderStrokeWidth;
    }

    /* renamed from: getBorderStrokeWidthSelected-D9Ej5fM  reason: not valid java name */
    public final float m4513getBorderStrokeWidthSelectedD9Ej5fM() {
        return this.borderStrokeWidthSelected;
    }

    public final Shapes getMaterial() {
        return this.material;
    }
}
