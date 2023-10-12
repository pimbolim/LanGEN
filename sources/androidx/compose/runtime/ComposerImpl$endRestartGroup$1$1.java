package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "<anonymous parameter 1>", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Composer.kt */
final class ComposerImpl$endRestartGroup$1$1 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {
    final /* synthetic */ Function1<Composition, Unit> $it;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposerImpl$endRestartGroup$1$1(Function1<? super Composition, Unit> function1, ComposerImpl composerImpl) {
        super(3);
        this.$it = function1;
        this.this$0 = composerImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) (Applier) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "$noName_0");
        Intrinsics.checkNotNullParameter(slotWriter, "$noName_1");
        Intrinsics.checkNotNullParameter(rememberManager, "$noName_2");
        this.$it.invoke(this.this$0.getComposition());
    }
}
