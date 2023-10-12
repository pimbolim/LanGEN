package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintSetScope;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope;", "()V", "constrain", "Landroidx/constraintlayout/compose/ConstrainScope;", "ref", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "constrainBlock", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "createRefFor", "id", "", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@LayoutScopeMarker
/* compiled from: ConstraintLayout.kt */
public final class ConstraintSetScope extends ConstraintLayoutBaseScope {
    public static final int $stable = 0;

    public final ConstrainedLayoutReference createRefFor(Object obj) {
        Intrinsics.checkNotNullParameter(obj, MessageExtension.FIELD_ID);
        return new ConstrainedLayoutReference(obj);
    }

    public final ConstrainScope constrain(ConstrainedLayoutReference constrainedLayoutReference, Function1<? super ConstrainScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(constrainedLayoutReference, "ref");
        Intrinsics.checkNotNullParameter(function1, "constrainBlock");
        ConstrainScope constrainScope = new ConstrainScope(constrainedLayoutReference.getId());
        function1.invoke(constrainScope);
        getTasks().addAll(constrainScope.getTasks$compose_release());
        return constrainScope;
    }
}
