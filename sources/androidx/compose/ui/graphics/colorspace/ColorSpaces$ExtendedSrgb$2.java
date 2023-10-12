package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "x", "invoke", "(D)Ljava/lang/Double;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColorSpaces.kt */
final class ColorSpaces$ExtendedSrgb$2 extends Lambda implements Function1<Double, Double> {
    public static final ColorSpaces$ExtendedSrgb$2 INSTANCE = new ColorSpaces$ExtendedSrgb$2();

    ColorSpaces$ExtendedSrgb$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).doubleValue());
    }

    public final Double invoke(double d) {
        return Double.valueOf(ColorSpaceKt.absResponse(d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d));
    }
}
