package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "t", "invoke", "(D)Ljava/lang/Double;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpringEstimation.kt */
final class SpringEstimationKt$estimateCriticallyDamped$fnPrime$1 extends Lambda implements Function1<Double, Double> {
    final /* synthetic */ double $c1;
    final /* synthetic */ double $c2;
    final /* synthetic */ double $r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SpringEstimationKt$estimateCriticallyDamped$fnPrime$1(double d, double d2, double d3) {
        super(1);
        this.$c2 = d;
        this.$r = d2;
        this.$c1 = d3;
    }

    public final Double invoke(double d) {
        double d2 = this.$c2;
        double d3 = this.$r;
        return Double.valueOf(((d2 * ((d3 * d) + ((double) 1))) + (this.$c1 * d3)) * Math.exp(d3 * d));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).doubleValue());
    }
}
