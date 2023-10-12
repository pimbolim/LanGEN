package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.ConstraintReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/core/state/ConstraintReference;", "kotlin.jvm.PlatformType", "other", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintScopeCommon.kt */
final class AnchorFunctions$verticalAnchorFunctions$4 extends Lambda implements Function3<ConstraintReference, Object, LayoutDirection, ConstraintReference> {
    public static final AnchorFunctions$verticalAnchorFunctions$4 INSTANCE = new AnchorFunctions$verticalAnchorFunctions$4();

    AnchorFunctions$verticalAnchorFunctions$4() {
        super(3);
    }

    public final ConstraintReference invoke(ConstraintReference constraintReference, Object obj, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(constraintReference, "$this$arrayOf");
        Intrinsics.checkNotNullParameter(obj, "other");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        AnchorFunctions.INSTANCE.clearRight(constraintReference, layoutDirection);
        ConstraintReference rightToRight = constraintReference.rightToRight(obj);
        Intrinsics.checkNotNullExpressionValue(rightToRight, "rightToRight(other)");
        return rightToRight;
    }
}
