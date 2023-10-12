package androidx.constraintlayout.compose;

import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Landroidx/constraintlayout/compose/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstrainScope.kt */
final class ConstrainScope$clearHorizontal$1 extends Lambda implements Function1<State, Unit> {
    final /* synthetic */ ConstrainScope this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstrainScope$clearHorizontal$1(ConstrainScope constrainScope) {
        super(1);
        this.this$0 = constrainScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(State state) {
        Intrinsics.checkNotNullParameter(state, PostalAddressParser.REGION_KEY);
        state.constraints(this.this$0.getId$compose_release()).clearHorizontal();
    }
}
