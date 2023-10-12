package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.state.ConstraintReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/core/state/ConstraintReference;", "kotlin.jvm.PlatformType", "other", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintScopeCommon.kt */
final class AnchorFunctions$horizontalAnchorFunctions$3 extends Lambda implements Function2<ConstraintReference, Object, ConstraintReference> {
    public static final AnchorFunctions$horizontalAnchorFunctions$3 INSTANCE = new AnchorFunctions$horizontalAnchorFunctions$3();

    AnchorFunctions$horizontalAnchorFunctions$3() {
        super(2);
    }

    public final ConstraintReference invoke(ConstraintReference constraintReference, Object obj) {
        Intrinsics.checkNotNullParameter(constraintReference, "$this$arrayOf");
        Intrinsics.checkNotNullParameter(obj, "other");
        constraintReference.bottomToBottom((Object) null);
        constraintReference.baselineToBaseline((Object) null);
        ConstraintReference bottomToTop = constraintReference.bottomToTop(obj);
        Intrinsics.checkNotNullExpressionValue(bottomToTop, "bottomToTop(other)");
        return bottomToTop;
    }
}
