package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "node", "Landroidx/compose/ui/node/ModifierLocalConsumerNode;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifierLocalConsumerNode.kt */
final class ModifierLocalConsumerNode$Companion$onReadValuesChanged$1 extends Lambda implements Function1<ModifierLocalConsumerNode, Unit> {
    public static final ModifierLocalConsumerNode$Companion$onReadValuesChanged$1 INSTANCE = new ModifierLocalConsumerNode$Companion$onReadValuesChanged$1();

    ModifierLocalConsumerNode$Companion$onReadValuesChanged$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ModifierLocalConsumerNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ModifierLocalConsumerNode modifierLocalConsumerNode) {
        Intrinsics.checkNotNullParameter(modifierLocalConsumerNode, "node");
        modifierLocalConsumerNode.notifyConsumerOfChanges();
    }
}
