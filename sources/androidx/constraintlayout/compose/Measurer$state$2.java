package androidx.constraintlayout.compose;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/compose/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class Measurer$state$2 extends Lambda implements Function0<State> {
    final /* synthetic */ Measurer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Measurer$state$2(Measurer measurer) {
        super(0);
        this.this$0 = measurer;
    }

    public final State invoke() {
        return new State(this.this$0.getDensity());
    }
}
