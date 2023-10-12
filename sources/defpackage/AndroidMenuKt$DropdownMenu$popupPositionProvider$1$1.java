package defpackage;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.IntRect;
import com.stripe.android.ui.core.elements.menu.MenuKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: AndroidMenuKt$DropdownMenu$popupPositionProvider$1$1  reason: default package */
/* compiled from: AndroidMenu.kt */
final class AndroidMenuKt$DropdownMenu$popupPositionProvider$1$1 extends Lambda implements Function2<IntRect, IntRect, Unit> {
    final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidMenuKt$DropdownMenu$popupPositionProvider$1$1(MutableState<TransformOrigin> mutableState) {
        super(2);
        this.$transformOriginState = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IntRect) obj, (IntRect) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(IntRect intRect, IntRect intRect2) {
        Intrinsics.checkNotNullParameter(intRect, "parentBounds");
        Intrinsics.checkNotNullParameter(intRect2, "menuBounds");
        this.$transformOriginState.setValue(TransformOrigin.m1942boximpl(MenuKt.calculateTransformOrigin(intRect, intRect2)));
    }
}
