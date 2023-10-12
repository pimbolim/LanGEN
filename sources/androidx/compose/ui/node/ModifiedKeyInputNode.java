package androidx.compose.ui.node;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0000H\u0016J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u001b\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0010\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/ModifiedKeyInputNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/input/key/KeyInputModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/input/key/KeyInputModifier;)V", "findNextKeyInputWrapper", "findPreviousKeyInputWrapper", "onInitialize", "", "propagateKeyEvent", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "propagateKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "propagatePreviewKeyEvent", "propagatePreviewKeyEvent-ZmokQxo", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifiedKeyInputNode.kt */
public final class ModifiedKeyInputNode extends DelegatingLayoutNodeWrapper<KeyInputModifier> {
    public ModifiedKeyInputNode findNextKeyInputWrapper() {
        return this;
    }

    public ModifiedKeyInputNode findPreviousKeyInputWrapper() {
        return this;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModifiedKeyInputNode(LayoutNodeWrapper layoutNodeWrapper, KeyInputModifier keyInputModifier) {
        super(layoutNodeWrapper, keyInputModifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(keyInputModifier, "modifier");
    }

    public void onInitialize() {
        super.onInitialize();
        ((KeyInputModifier) getModifier()).setKeyInputNode(this);
    }

    /* renamed from: propagatePreviewKeyEvent-ZmokQxo  reason: not valid java name */
    public final boolean m3359propagatePreviewKeyEventZmokQxo(KeyEvent keyEvent) {
        Boolean invoke;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        ModifiedKeyInputNode findParentKeyInputNode$ui_release = findParentKeyInputNode$ui_release();
        Boolean valueOf = findParentKeyInputNode$ui_release == null ? null : Boolean.valueOf(findParentKeyInputNode$ui_release.m3359propagatePreviewKeyEventZmokQxo(keyEvent));
        if (Intrinsics.areEqual((Object) valueOf, (Object) true)) {
            return valueOf.booleanValue();
        }
        Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> onPreviewKeyEvent = ((KeyInputModifier) getModifier()).getOnPreviewKeyEvent();
        if (onPreviewKeyEvent == null || (invoke = onPreviewKeyEvent.invoke(androidx.compose.ui.input.key.KeyEvent.m2838boximpl(keyEvent))) == null) {
            return false;
        }
        return invoke.booleanValue();
    }

    /* renamed from: propagateKeyEvent-ZmokQxo  reason: not valid java name */
    public final boolean m3358propagateKeyEventZmokQxo(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> onKeyEvent = ((KeyInputModifier) getModifier()).getOnKeyEvent();
        Boolean invoke = onKeyEvent == null ? null : onKeyEvent.invoke(androidx.compose.ui.input.key.KeyEvent.m2838boximpl(keyEvent));
        if (Intrinsics.areEqual((Object) invoke, (Object) true)) {
            return invoke.booleanValue();
        }
        ModifiedKeyInputNode findParentKeyInputNode$ui_release = findParentKeyInputNode$ui_release();
        if (findParentKeyInputNode$ui_release == null) {
            return false;
        }
        return findParentKeyInputNode$ui_release.m3358propagateKeyEventZmokQxo(keyEvent);
    }
}
