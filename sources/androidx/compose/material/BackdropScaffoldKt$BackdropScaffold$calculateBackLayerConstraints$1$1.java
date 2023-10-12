package androidx.compose.material;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 extends Lambda implements Function1<Constraints, Constraints> {
    final /* synthetic */ float $headerHeightPx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(float f) {
        super(1);
        this.$headerHeightPx = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Constraints.m3791boximpl(m848invokeZezNO4M(((Constraints) obj).m3809unboximpl()));
    }

    /* renamed from: invoke-ZezNO4M  reason: not valid java name */
    public final long m848invokeZezNO4M(long j) {
        return ConstraintsKt.m3820offsetNN6EwU$default(Constraints.m3794copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null), 0, -MathKt.roundToInt(this.$headerHeightPx), 1, (Object) null);
    }
}
