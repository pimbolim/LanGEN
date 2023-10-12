package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toLocalRect", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Companion", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalFoundationApi
/* compiled from: BringIntoViewResponder.kt */
public interface BringIntoViewResponder {
    public static final Companion Companion = Companion.$$INSTANCE;

    Object bringIntoView(Rect rect, Continuation<? super Unit> continuation);

    Rect toLocalRect(Rect rect, LayoutCoordinates layoutCoordinates);

    @ExperimentalFoundationApi
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewResponder$Companion;", "", "()V", "ModifierLocalBringIntoViewResponder", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "getModifierLocalBringIntoViewResponder", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "RootBringIntoViewResponder", "getRootBringIntoViewResponder", "()Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BringIntoViewResponder.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ProvidableModifierLocal<BringIntoViewResponder> ModifierLocalBringIntoViewResponder = ModifierLocalKt.modifierLocalOf(BringIntoViewResponder$Companion$ModifierLocalBringIntoViewResponder$1.INSTANCE);
        private static final BringIntoViewResponder RootBringIntoViewResponder = new BringIntoViewResponder$Companion$RootBringIntoViewResponder$1();

        private Companion() {
        }

        public final ProvidableModifierLocal<BringIntoViewResponder> getModifierLocalBringIntoViewResponder() {
            return ModifierLocalBringIntoViewResponder;
        }

        public final BringIntoViewResponder getRootBringIntoViewResponder() {
            return RootBringIntoViewResponder;
        }
    }
}
