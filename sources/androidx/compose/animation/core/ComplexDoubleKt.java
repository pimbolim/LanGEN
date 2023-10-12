package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0000\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\n\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\n¨\u0006\r"}, d2 = {"complexQuadraticFormula", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "a", "", "b", "c", "complexSqrt", "num", "minus", "other", "plus", "times", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComplexDouble.kt */
public final class ComplexDoubleKt {
    public static final Pair<ComplexDouble, ComplexDouble> complexQuadraticFormula(double d, double d2, double d3) {
        double d4 = -d2;
        double d5 = (d2 * d2) - ((4.0d * d) * d3);
        ComplexDouble complexSqrt = complexSqrt(d5);
        complexSqrt._real = complexSqrt._real + d4;
        double d6 = d * 2.0d;
        complexSqrt._real = complexSqrt._real / d6;
        complexSqrt._imaginary = complexSqrt._imaginary / d6;
        ComplexDouble complexSqrt2 = complexSqrt(d5);
        double d7 = (double) -1;
        complexSqrt2._real = complexSqrt2._real * d7;
        complexSqrt2._imaginary = complexSqrt2._imaginary * d7;
        complexSqrt2._real = complexSqrt2._real + d4;
        complexSqrt2._real = complexSqrt2._real / d6;
        complexSqrt2._imaginary = complexSqrt2._imaginary / d6;
        return TuplesKt.to(complexSqrt, complexSqrt2);
    }

    public static final ComplexDouble complexSqrt(double d) {
        if (d < 0.0d) {
            return new ComplexDouble(0.0d, Math.sqrt(Math.abs(d)));
        }
        return new ComplexDouble(Math.sqrt(d), 0.0d);
    }

    public static final ComplexDouble plus(double d, ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        complexDouble._real = complexDouble._real + d;
        return complexDouble;
    }

    public static final ComplexDouble minus(double d, ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        double d2 = (double) -1;
        complexDouble._real = complexDouble._real * d2;
        complexDouble._imaginary = complexDouble._imaginary * d2;
        complexDouble._real = complexDouble._real + d;
        return complexDouble;
    }

    public static final ComplexDouble times(double d, ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        complexDouble._real = complexDouble._real * d;
        complexDouble._imaginary = complexDouble._imaginary * d;
        return complexDouble;
    }
}
