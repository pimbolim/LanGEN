package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.state.ConstraintReference;
import com.braintreepayments.api.models.PostalAddressParser;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintVerticalAnchorable;", "Landroidx/constraintlayout/compose/BaseVerticalAnchorable;", "id", "", "index", "", "tasks", "", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/State;", "", "(Ljava/lang/Object;ILjava/util/List;)V", "getId", "()Ljava/lang/Object;", "getConstraintReference", "Landroidx/constraintlayout/core/state/ConstraintReference;", "state", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstrainScope.kt */
final class ConstraintVerticalAnchorable extends BaseVerticalAnchorable {
    private final Object id;

    public final Object getId() {
        return this.id;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintVerticalAnchorable(Object obj, int i, List<Function1<State, Unit>> list) {
        super(list, i);
        Intrinsics.checkNotNullParameter(obj, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(list, "tasks");
        this.id = obj;
    }

    public ConstraintReference getConstraintReference(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        ConstraintReference constraints = state.constraints(this.id);
        Intrinsics.checkNotNullExpressionValue(constraints, "state.constraints(id)");
        return constraints;
    }
}
