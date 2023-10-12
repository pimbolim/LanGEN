package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.core.state.ConstraintReference;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Landroidx/constraintlayout/compose/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintScopeCommon.kt */
final class BaseVerticalAnchorable$linkTo$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ ConstraintLayoutBaseScope.VerticalAnchor $anchor;
    final /* synthetic */ float $goneMargin;
    final /* synthetic */ float $margin;
    final /* synthetic */ BaseVerticalAnchorable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseVerticalAnchorable$linkTo$1(BaseVerticalAnchorable baseVerticalAnchorable, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, float f, float f2) {
        super(1);
        this.this$0 = baseVerticalAnchorable;
        this.$anchor = verticalAnchor;
        this.$margin = f;
        this.$goneMargin = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        LayoutDirection layoutDirection = state.getLayoutDirection();
        int verticalAnchorIndexToFunctionIndex = AnchorFunctions.INSTANCE.verticalAnchorIndexToFunctionIndex(this.this$0.index, layoutDirection);
        int verticalAnchorIndexToFunctionIndex2 = AnchorFunctions.INSTANCE.verticalAnchorIndexToFunctionIndex(this.$anchor.getIndex$compose_release(), layoutDirection);
        ((ConstraintReference) AnchorFunctions.INSTANCE.getVerticalAnchorFunctions()[verticalAnchorIndexToFunctionIndex][verticalAnchorIndexToFunctionIndex2].invoke(this.this$0.getConstraintReference(state), this.$anchor.getId$compose_release(), state.getLayoutDirection())).margin((Object) Dp.m3857boximpl(this.$margin)).marginGone((Object) Dp.m3857boximpl(this.$goneMargin));
    }
}
