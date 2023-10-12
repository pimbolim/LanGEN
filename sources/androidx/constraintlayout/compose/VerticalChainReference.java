package androidx.constraintlayout.compose;

import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t¨\u0006\u000f"}, d2 = {"Landroidx/constraintlayout/compose/VerticalChainReference;", "", "id", "(Ljava/lang/Object;)V", "bottom", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "getBottom$annotations", "()V", "getBottom", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "getId$compose_release", "()Ljava/lang/Object;", "top", "getTop$annotations", "getTop", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayoutBaseScope.kt */
public final class VerticalChainReference {
    private final ConstraintLayoutBaseScope.HorizontalAnchor bottom;
    private final Object id;
    private final ConstraintLayoutBaseScope.HorizontalAnchor top;

    public static /* synthetic */ void getBottom$annotations() {
    }

    public static /* synthetic */ void getTop$annotations() {
    }

    public VerticalChainReference(Object obj) {
        Intrinsics.checkNotNullParameter(obj, MessageExtension.FIELD_ID);
        this.id = obj;
        this.top = new ConstraintLayoutBaseScope.HorizontalAnchor(obj, 0);
        this.bottom = new ConstraintLayoutBaseScope.HorizontalAnchor(obj, 1);
    }

    public final Object getId$compose_release() {
        return this.id;
    }

    public final ConstraintLayoutBaseScope.HorizontalAnchor getTop() {
        return this.top;
    }

    public final ConstraintLayoutBaseScope.HorizontalAnchor getBottom() {
        return this.bottom;
    }
}
