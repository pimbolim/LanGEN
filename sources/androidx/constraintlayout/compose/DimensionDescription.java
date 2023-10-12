package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.Dimension;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001f\b\u0000\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bj\u0002`\t0\u0006¢\u0006\u0002\u0010\nJ\u0019\u0010\u001d\u001a\u00060\bj\u0002`\t2\u0006\u0010\u001e\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bj\u0002`\t0\u0006X\u0004¢\u0006\u0002\n\u0000R%\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R%\u0010\u0017\u001a\u0004\u0018\u00010\fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/constraintlayout/compose/DimensionDescription;", "Landroidx/constraintlayout/compose/Dimension$Coercible;", "Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "Landroidx/constraintlayout/compose/Dimension;", "baseDimension", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/State;", "Landroidx/constraintlayout/core/state/Dimension;", "Landroidx/constraintlayout/compose/SolverDimension;", "(Lkotlin/jvm/functions/Function1;)V", "max", "Landroidx/compose/ui/unit/Dp;", "getMax-lTKBWiU", "()Landroidx/compose/ui/unit/Dp;", "setMax-YLDhkOg", "(Landroidx/compose/ui/unit/Dp;)V", "maxSymbol", "", "getMaxSymbol", "()Ljava/lang/Object;", "setMaxSymbol", "(Ljava/lang/Object;)V", "min", "getMin-lTKBWiU", "setMin-YLDhkOg", "minSymbol", "getMinSymbol", "setMinSymbol", "toSolverDimension", "state", "toSolverDimension$compose_release", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
public final class DimensionDescription implements Dimension.Coercible, Dimension.MinCoercible, Dimension.MaxCoercible, Dimension {
    private final Function1<State, androidx.constraintlayout.core.state.Dimension> baseDimension;
    private Dp max;
    private Object maxSymbol;
    private Dp min;
    private Object minSymbol;

    public DimensionDescription(Function1<? super State, ? extends androidx.constraintlayout.core.state.Dimension> function1) {
        Intrinsics.checkNotNullParameter(function1, "baseDimension");
        this.baseDimension = function1;
    }

    /* renamed from: getMin-lTKBWiU  reason: not valid java name */
    public final Dp m4171getMinlTKBWiU() {
        return this.min;
    }

    /* renamed from: setMin-YLDhkOg  reason: not valid java name */
    public final void m4173setMinYLDhkOg(Dp dp) {
        this.min = dp;
    }

    public final Object getMinSymbol() {
        return this.minSymbol;
    }

    public final void setMinSymbol(Object obj) {
        this.minSymbol = obj;
    }

    /* renamed from: getMax-lTKBWiU  reason: not valid java name */
    public final Dp m4170getMaxlTKBWiU() {
        return this.max;
    }

    /* renamed from: setMax-YLDhkOg  reason: not valid java name */
    public final void m4172setMaxYLDhkOg(Dp dp) {
        this.max = dp;
    }

    public final Object getMaxSymbol() {
        return this.maxSymbol;
    }

    public final void setMaxSymbol(Object obj) {
        this.maxSymbol = obj;
    }

    public final androidx.constraintlayout.core.state.Dimension toSolverDimension$compose_release(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        androidx.constraintlayout.core.state.Dimension invoke = this.baseDimension.invoke(state);
        if (getMinSymbol() != null) {
            invoke.min(getMinSymbol());
        } else if (m4171getMinlTKBWiU() != null) {
            Dp r1 = m4171getMinlTKBWiU();
            Intrinsics.checkNotNull(r1);
            invoke.min(state.convertDimension(r1));
        }
        if (getMaxSymbol() != null) {
            invoke.max(getMaxSymbol());
        } else if (m4170getMaxlTKBWiU() != null) {
            Dp r12 = m4170getMaxlTKBWiU();
            Intrinsics.checkNotNull(r12);
            invoke.max(state.convertDimension(r12));
        }
        return invoke;
    }
}
