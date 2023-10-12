package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.Reference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0000¢\u0006\u0002\b\"J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\bH\u0016J\u0017\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010'\u001a\u00020(H\u0000¢\u0006\u0002\b)J\u0015\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\rH\u0000¢\u0006\u0002\b,J\b\u0010-\u001a\u00020 H\u0016R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R%\u0010\u0018\u001a\u00020\u0019X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/constraintlayout/compose/State;", "Landroidx/constraintlayout/core/state/State;", "Landroidx/constraintlayout/compose/SolverState;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "baselineNeeded", "", "", "getBaselineNeeded$compose_release", "()Ljava/util/List;", "baselineNeededWidgets", "", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "dirtyBaselineNeededWidgets", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "rootIncomingConstraints", "Landroidx/compose/ui/unit/Constraints;", "getRootIncomingConstraints-msEJaDk", "()J", "setRootIncomingConstraints-BRTryo0", "(J)V", "J", "baselineNeededFor", "", "id", "baselineNeededFor$compose_release", "convertDimension", "", "value", "getKeyId", "helperWidget", "Landroidx/constraintlayout/core/widgets/HelperWidget;", "getKeyId$compose_release", "isBaselineNeeded", "constraintWidget", "isBaselineNeeded$compose_release", "reset", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
public final class State extends androidx.constraintlayout.core.state.State {
    public static final int $stable = 8;
    private final List<Object> baselineNeeded = new ArrayList();
    private final Set<ConstraintWidget> baselineNeededWidgets = new LinkedHashSet();
    private final Density density;
    private boolean dirtyBaselineNeededWidgets = true;
    public LayoutDirection layoutDirection;
    private long rootIncomingConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);

    public State(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "density");
        this.density = density2;
    }

    public final Density getDensity() {
        return this.density;
    }

    /* renamed from: getRootIncomingConstraints-msEJaDk  reason: not valid java name */
    public final long m4211getRootIncomingConstraintsmsEJaDk() {
        return this.rootIncomingConstraints;
    }

    /* renamed from: setRootIncomingConstraints-BRTryo0  reason: not valid java name */
    public final void m4212setRootIncomingConstraintsBRTryo0(long j) {
        this.rootIncomingConstraints = j;
    }

    public final LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection2 = this.layoutDirection;
        if (layoutDirection2 != null) {
            return layoutDirection2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        throw null;
    }

    public final void setLayoutDirection(LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
        this.layoutDirection = layoutDirection2;
    }

    public final List<Object> getBaselineNeeded$compose_release() {
        return this.baselineNeeded;
    }

    public int convertDimension(Object obj) {
        if (obj instanceof Dp) {
            return this.density.m3822roundToPx0680j_4(((Dp) obj).m3873unboximpl());
        }
        return super.convertDimension(obj);
    }

    public void reset() {
        ConstraintWidget constraintWidget;
        HashMap hashMap = this.mReferences;
        Intrinsics.checkNotNullExpressionValue(hashMap, "mReferences");
        for (Map.Entry value : hashMap.entrySet()) {
            Reference reference = (Reference) value.getValue();
            if (!(reference == null || (constraintWidget = reference.getConstraintWidget()) == null)) {
                constraintWidget.reset();
            }
        }
        this.mReferences.clear();
        HashMap hashMap2 = this.mReferences;
        Intrinsics.checkNotNullExpressionValue(hashMap2, "mReferences");
        hashMap2.put(androidx.constraintlayout.core.state.State.PARENT, this.mParent);
        this.baselineNeeded.clear();
        this.dirtyBaselineNeededWidgets = true;
        super.reset();
    }

    public final void baselineNeededFor$compose_release(Object obj) {
        Intrinsics.checkNotNullParameter(obj, MessageExtension.FIELD_ID);
        this.baselineNeeded.add(obj);
        this.dirtyBaselineNeededWidgets = true;
    }

    public final boolean isBaselineNeeded$compose_release(ConstraintWidget constraintWidget) {
        Intrinsics.checkNotNullParameter(constraintWidget, "constraintWidget");
        if (this.dirtyBaselineNeededWidgets) {
            this.baselineNeededWidgets.clear();
            for (Object obj : this.baselineNeeded) {
                Reference reference = (Reference) this.mReferences.get(obj);
                ConstraintWidget constraintWidget2 = reference == null ? null : reference.getConstraintWidget();
                if (constraintWidget2 != null) {
                    this.baselineNeededWidgets.add(constraintWidget2);
                }
            }
            this.dirtyBaselineNeededWidgets = false;
        }
        return this.baselineNeededWidgets.contains(constraintWidget);
    }

    public final Object getKeyId$compose_release(HelperWidget helperWidget) {
        Object obj;
        Intrinsics.checkNotNullParameter(helperWidget, "helperWidget");
        Set entrySet = this.mHelperReferences.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "mHelperReferences.entries");
        Iterator it = entrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((HelperReference) ((Map.Entry) obj).getValue()).getHelperWidget(), (Object) helperWidget)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }
}
