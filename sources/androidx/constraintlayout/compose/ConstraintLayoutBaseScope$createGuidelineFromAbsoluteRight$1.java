package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Landroidx/constraintlayout/compose/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayoutBaseScope.kt */
final class ConstraintLayoutBaseScope$createGuidelineFromAbsoluteRight$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ int $id;
    final /* synthetic */ float $offset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintLayoutBaseScope$createGuidelineFromAbsoluteRight$1(int i, float f) {
        super(1);
        this.$id = i;
        this.$offset = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        state.verticalGuideline(Integer.valueOf(this.$id)).end(Dp.m3857boximpl(this.$offset));
    }
}
