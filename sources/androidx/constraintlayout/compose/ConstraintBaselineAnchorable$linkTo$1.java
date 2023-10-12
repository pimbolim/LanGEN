package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
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
final class ConstraintBaselineAnchorable$linkTo$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ ConstraintLayoutBaseScope.BaselineAnchor $anchor;
    final /* synthetic */ float $goneMargin;
    final /* synthetic */ float $margin;
    final /* synthetic */ ConstraintBaselineAnchorable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintBaselineAnchorable$linkTo$1(ConstraintBaselineAnchorable constraintBaselineAnchorable, ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor, float f, float f2) {
        super(1);
        this.this$0 = constraintBaselineAnchorable;
        this.$anchor = baselineAnchor;
        this.$margin = f;
        this.$goneMargin = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        if (state != null) {
            ConstraintBaselineAnchorable constraintBaselineAnchorable = this.this$0;
            ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor = this.$anchor;
            state.baselineNeededFor$compose_release(constraintBaselineAnchorable.getId());
            state.baselineNeededFor$compose_release(baselineAnchor.getId$compose_release());
        }
        ConstraintReference constraints = state.constraints(this.this$0.getId());
        ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor2 = this.$anchor;
        float f = this.$margin;
        float f2 = this.$goneMargin;
        Function2<ConstraintReference, Object, ConstraintReference> baselineAnchorFunction = AnchorFunctions.INSTANCE.getBaselineAnchorFunction();
        Intrinsics.checkNotNullExpressionValue(constraints, "this");
        baselineAnchorFunction.invoke(constraints, baselineAnchor2.getId$compose_release()).margin((Object) Dp.m3857boximpl(f)).marginGone((Object) Dp.m3857boximpl(f2));
    }
}
