package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.Measurable;
import androidx.constraintlayout.compose.DerivedConstraintSet;
import androidx.constraintlayout.core.state.Transition;
import com.braintreepayments.api.models.PostalAddressParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0000\u0018\u00002\u00020\u0001B*\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\"\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Landroidx/constraintlayout/compose/DslConstraintSet;", "Landroidx/constraintlayout/compose/DerivedConstraintSet;", "description", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstraintSetScope;", "", "Lkotlin/ExtensionFunctionType;", "extendFrom", "Landroidx/constraintlayout/compose/ConstraintSet;", "(Lkotlin/jvm/functions/Function1;Landroidx/constraintlayout/compose/ConstraintSet;)V", "getDescription", "()Lkotlin/jvm/functions/Function1;", "getExtendFrom", "()Landroidx/constraintlayout/compose/ConstraintSet;", "applyToState", "state", "Landroidx/constraintlayout/compose/State;", "override", "name", "", "value", "", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DslConstraintSet.kt */
public final class DslConstraintSet implements DerivedConstraintSet {
    private final Function1<ConstraintSetScope, Unit> description;
    private final ConstraintSet extendFrom;

    public DslConstraintSet(Function1<? super ConstraintSetScope, Unit> function1, ConstraintSet constraintSet) {
        Intrinsics.checkNotNullParameter(function1, "description");
        this.description = function1;
        this.extendFrom = constraintSet;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DslConstraintSet(Function1 function1, ConstraintSet constraintSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, (i & 2) != 0 ? null : constraintSet);
    }

    public void applyTo(State state, List<? extends Measurable> list) {
        DerivedConstraintSet.DefaultImpls.applyTo((DerivedConstraintSet) this, state, list);
    }

    public void applyTo(Transition transition, int i) {
        DerivedConstraintSet.DefaultImpls.applyTo((DerivedConstraintSet) this, transition, i);
    }

    public boolean isDirty(List<? extends Measurable> list) {
        return DerivedConstraintSet.DefaultImpls.isDirty(this, list);
    }

    public final Function1<ConstraintSetScope, Unit> getDescription() {
        return this.description;
    }

    public ConstraintSet getExtendFrom() {
        return this.extendFrom;
    }

    public void applyToState(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        ConstraintSetScope constraintSetScope = new ConstraintSetScope();
        this.description.invoke(constraintSetScope);
        constraintSetScope.applyTo(state);
    }

    public ConstraintSet override(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "name");
        return this;
    }
}
