package androidx.compose.ui.node;

import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0011B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0016R$\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/node/ModifierLocalConsumerNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/modifier/ModifierLocalConsumer;)V", "current", "T", "Landroidx/compose/ui/modifier/ModifierLocal;", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "attach", "", "notifyConsumerOfChanges", "onModifierChanged", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifierLocalConsumerNode.kt */
public final class ModifierLocalConsumerNode extends DelegatingLayoutNodeWrapper<ModifierLocalConsumer> implements ModifierLocalReadScope {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Function1<ModifierLocalConsumerNode, Unit> onReadValuesChanged = ModifierLocalConsumerNode$Companion$onReadValuesChanged$1.INSTANCE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModifierLocalConsumerNode(LayoutNodeWrapper layoutNodeWrapper, ModifierLocalConsumer modifierLocalConsumer) {
        super(layoutNodeWrapper, modifierLocalConsumer);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(modifierLocalConsumer, "modifier");
    }

    public void onModifierChanged() {
        super.onModifierChanged();
        notifyConsumerOfChanges();
    }

    public void attach() {
        super.attach();
        notifyConsumerOfChanges();
    }

    public <T> T getCurrent(ModifierLocal<T> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
        return onModifierLocalRead(modifierLocal);
    }

    /* access modifiers changed from: private */
    public final void notifyConsumerOfChanges() {
        if (isAttached()) {
            LayoutNodeKt.requireOwner(getLayoutNode$ui_release()).getSnapshotObserver().observeReads$ui_release(this, onReadValuesChanged, new ModifierLocalConsumerNode$notifyConsumerOfChanges$1(this));
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/node/ModifierLocalConsumerNode$Companion;", "", "()V", "onReadValuesChanged", "Lkotlin/Function1;", "Landroidx/compose/ui/node/ModifierLocalConsumerNode;", "", "getOnReadValuesChanged", "()Lkotlin/jvm/functions/Function1;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ModifierLocalConsumerNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<ModifierLocalConsumerNode, Unit> getOnReadValuesChanged() {
            return ModifierLocalConsumerNode.onReadValuesChanged;
        }
    }
}
