package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import com.braintreepayments.api.models.PostalAddressParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Landroidx/constraintlayout/compose/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayoutBaseScope.kt */
final class ConstraintLayoutBaseScope$createAbsoluteRightBarrier$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ ConstrainedLayoutReference[] $elements;
    final /* synthetic */ int $id;
    final /* synthetic */ float $margin;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintLayoutBaseScope$createAbsoluteRightBarrier$1(int i, float f, ConstrainedLayoutReference[] constrainedLayoutReferenceArr) {
        super(1);
        this.$id = i;
        this.$margin = f;
        this.$elements = constrainedLayoutReferenceArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        BarrierReference barrier = state.barrier(Integer.valueOf(this.$id), State.Direction.RIGHT);
        ConstrainedLayoutReference[] constrainedLayoutReferenceArr = this.$elements;
        Collection arrayList = new ArrayList(constrainedLayoutReferenceArr.length);
        for (ConstrainedLayoutReference id : constrainedLayoutReferenceArr) {
            arrayList.add(id.getId());
        }
        Object[] array = ((List) arrayList).toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        barrier.add(Arrays.copyOf(array, array.length));
        barrier.margin(state.convertDimension(Dp.m3857boximpl(this.$margin)));
    }
}
