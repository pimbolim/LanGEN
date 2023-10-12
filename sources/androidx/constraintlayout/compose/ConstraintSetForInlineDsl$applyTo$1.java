package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.Measurable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class ConstraintSetForInlineDsl$applyTo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<Measurable> $measurables;
    final /* synthetic */ State $state;
    final /* synthetic */ ConstraintSetForInlineDsl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintSetForInlineDsl$applyTo$1(List<? extends Measurable> list, State state, ConstraintSetForInlineDsl constraintSetForInlineDsl) {
        super(0);
        this.$measurables = list;
        this.$state = state;
        this.this$0 = constraintSetForInlineDsl;
    }

    public final void invoke() {
        List<Measurable> list = this.$measurables;
        State state = this.$state;
        ConstraintSetForInlineDsl constraintSetForInlineDsl = this.this$0;
        int size = list.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Object parentData = list.get(i).getParentData();
                ConstraintLayoutParentData constraintLayoutParentData = parentData instanceof ConstraintLayoutParentData ? (ConstraintLayoutParentData) parentData : null;
                if (constraintLayoutParentData != null) {
                    ConstrainScope constrainScope = new ConstrainScope(constraintLayoutParentData.getRef().getId());
                    constraintLayoutParentData.getConstrain().invoke(constrainScope);
                    constrainScope.applyTo$compose_release(state);
                }
                constraintSetForInlineDsl.previousDatas.add(constraintLayoutParentData);
                if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }
}
