package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/constraintlayout/compose/BaselineAnchorable;", "", "linkTo", "", "anchor", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "margin", "Landroidx/compose/ui/unit/Dp;", "goneMargin", "linkTo-VpY3zN4", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;FF)V", "compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConstraintScopeCommon.kt */
public interface BaselineAnchorable {
    /* renamed from: linkTo-VpY3zN4  reason: not valid java name */
    void m4117linkToVpY3zN4(ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor, float f, float f2);

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ConstraintScopeCommon.kt */
    public static final class DefaultImpls {
        /* renamed from: linkTo-VpY3zN4$default  reason: not valid java name */
        public static /* synthetic */ void m4118linkToVpY3zN4$default(BaselineAnchorable baselineAnchorable, ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor, float f, float f2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = Dp.m3859constructorimpl((float) 0);
                }
                if ((i & 4) != 0) {
                    f2 = Dp.m3859constructorimpl((float) 0);
                }
                baselineAnchorable.m4117linkToVpY3zN4(baselineAnchor, f, f2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkTo-VpY3zN4");
        }
    }
}
