package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayout.kt */
final class ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$1$onHelpersChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConstraintSetForInlineDsl $constraintSet;
    final /* synthetic */ MutableState<Boolean> $remeasureRequesterState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$1$onHelpersChanged$1(MutableState<Boolean> mutableState, ConstraintSetForInlineDsl constraintSetForInlineDsl) {
        super(0);
        this.$remeasureRequesterState = mutableState;
        this.$constraintSet = constraintSetForInlineDsl;
    }

    public final void invoke() {
        MutableState<Boolean> mutableState = this.$remeasureRequesterState;
        mutableState.setValue(Boolean.valueOf(!mutableState.getValue().booleanValue()));
        this.$constraintSet.setKnownDirty(true);
    }
}
