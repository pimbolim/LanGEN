package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.state.ConstraintReference;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Landroidx/constraintlayout/compose/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstrainScope.kt */
final class ConstrainScope$addFloatTransformFromDp$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ Function2<ConstraintReference, Float, Unit> $change;
    final /* synthetic */ float $dpValue;
    final /* synthetic */ ConstrainScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstrainScope$addFloatTransformFromDp$1(Function2<? super ConstraintReference, ? super Float, Unit> function2, ConstrainScope constrainScope, float f) {
        super(1);
        this.$change = function2;
        this.this$0 = constrainScope;
        this.$dpValue = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        if (state != null) {
            Function2<ConstraintReference, Float, Unit> function2 = this.$change;
            ConstrainScope constrainScope = this.this$0;
            float f = this.$dpValue;
            ConstraintReference constraints = state.constraints(constrainScope.getId$compose_release());
            Intrinsics.checkNotNullExpressionValue(constraints, "state.constraints(id)");
            function2.invoke(constraints, Float.valueOf((float) state.convertDimension(Dp.m3857boximpl(f))));
        }
    }
}
