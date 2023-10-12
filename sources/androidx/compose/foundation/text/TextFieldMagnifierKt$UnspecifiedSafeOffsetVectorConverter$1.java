package androidx.compose.foundation.text;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationVector2D;", "it", "Landroidx/compose/ui/geometry/Offset;", "invoke-k-4lQ0M", "(J)Landroidx/compose/animation/core/AnimationVector2D;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldMagnifier.kt */
final class TextFieldMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1 extends Lambda implements Function1<Offset, AnimationVector2D> {
    public static final TextFieldMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1 INSTANCE = new TextFieldMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1();

    TextFieldMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m710invokek4lQ0M(((Offset) obj).m1363unboximpl());
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final AnimationVector2D m710invokek4lQ0M(long j) {
        if (OffsetKt.m1372isSpecifiedk4lQ0M(j)) {
            return new AnimationVector2D(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j));
        }
        return TextFieldMagnifierKt.UnspecifiedAnimationVector2D;
    }
}
