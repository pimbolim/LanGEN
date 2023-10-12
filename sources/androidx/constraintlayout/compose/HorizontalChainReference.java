package androidx.constraintlayout.compose;

import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/constraintlayout/compose/HorizontalChainReference;", "", "id", "(Ljava/lang/Object;)V", "absoluteLeft", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "getAbsoluteLeft$annotations", "()V", "getAbsoluteLeft", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "absoluteRight", "getAbsoluteRight$annotations", "getAbsoluteRight", "end", "getEnd$annotations", "getEnd", "getId$compose_release", "()Ljava/lang/Object;", "start", "getStart$annotations", "getStart", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintLayoutBaseScope.kt */
public final class HorizontalChainReference {
    private final ConstraintLayoutBaseScope.VerticalAnchor absoluteLeft;
    private final ConstraintLayoutBaseScope.VerticalAnchor absoluteRight;
    private final ConstraintLayoutBaseScope.VerticalAnchor end;
    private final Object id;
    private final ConstraintLayoutBaseScope.VerticalAnchor start;

    public static /* synthetic */ void getAbsoluteLeft$annotations() {
    }

    public static /* synthetic */ void getAbsoluteRight$annotations() {
    }

    public static /* synthetic */ void getEnd$annotations() {
    }

    public static /* synthetic */ void getStart$annotations() {
    }

    public HorizontalChainReference(Object obj) {
        Intrinsics.checkNotNullParameter(obj, MessageExtension.FIELD_ID);
        this.id = obj;
        this.start = new ConstraintLayoutBaseScope.VerticalAnchor(obj, -2);
        this.absoluteLeft = new ConstraintLayoutBaseScope.VerticalAnchor(obj, 0);
        this.end = new ConstraintLayoutBaseScope.VerticalAnchor(obj, -1);
        this.absoluteRight = new ConstraintLayoutBaseScope.VerticalAnchor(obj, 1);
    }

    public final Object getId$compose_release() {
        return this.id;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getStart() {
        return this.start;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getAbsoluteLeft() {
        return this.absoluteLeft;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getEnd() {
        return this.end;
    }

    public final ConstraintLayoutBaseScope.VerticalAnchor getAbsoluteRight() {
        return this.absoluteRight;
    }
}
