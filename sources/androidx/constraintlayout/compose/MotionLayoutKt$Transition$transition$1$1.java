package androidx.constraintlayout.compose;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: MotionLayout.kt */
public final class MotionLayoutKt$Transition$transition$1$1 implements Transition {
    final /* synthetic */ CLObject $parsed;

    MotionLayoutKt$Transition$transition$1$1(CLObject cLObject) {
        this.$parsed = cLObject;
    }

    public void applyTo(Transition transition, int i) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        try {
            ConstraintSetParserKt.parseTransition(this.$parsed, transition);
        } catch (CLParsingException e) {
            System.err.println(Intrinsics.stringPlus("Error parsing JSON ", e));
        }
    }

    public String getStartConstraintSetId() {
        String stringOrNull = this.$parsed.getStringOrNull(TypedValues.TransitionType.S_FROM);
        return stringOrNull == null ? ViewProps.START : stringOrNull;
    }

    public String getEndConstraintSetId() {
        String stringOrNull = this.$parsed.getStringOrNull(TypedValues.TransitionType.S_TO);
        return stringOrNull == null ? ViewProps.END : stringOrNull;
    }
}
