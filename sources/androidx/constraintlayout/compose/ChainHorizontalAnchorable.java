package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import com.braintreepayments.api.models.PostalAddressParser;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/constraintlayout/compose/ChainHorizontalAnchorable;", "Landroidx/constraintlayout/compose/BaseHorizontalAnchorable;", "tasks", "", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/State;", "", "id", "", "index", "", "(Ljava/util/List;Ljava/lang/Object;I)V", "getConstraintReference", "Landroidx/constraintlayout/core/state/ConstraintReference;", "state", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ChainConstrainScope.kt */
final class ChainHorizontalAnchorable extends BaseHorizontalAnchorable {
    private final Object id;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChainHorizontalAnchorable(List<Function1<State, Unit>> list, Object obj, int i) {
        super(list, i);
        Intrinsics.checkNotNullParameter(list, "tasks");
        Intrinsics.checkNotNullParameter(obj, MessageExtension.FIELD_ID);
        this.id = obj;
    }

    public ConstraintReference getConstraintReference(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        HelperReference helper = state.helper(this.id, State.Helper.VERTICAL_CHAIN);
        Intrinsics.checkNotNullExpressionValue(helper, "state.helper(id, androidx.constraintlayout.core.state.State.Helper.VERTICAL_CHAIN)");
        return helper;
    }
}
