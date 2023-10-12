package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActionRunner;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "()V", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "setFocusManager", "(Landroidx/compose/ui/focus/FocusManager;)V", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "defaultKeyboardAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "defaultKeyboardAction-KlQnJC8", "(I)V", "runAction", "runAction-KlQnJC8", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardActionRunner.kt */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public FocusManager focusManager;
    public KeyboardActions keyboardActions;

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions2 = this.keyboardActions;
        if (keyboardActions2 != null) {
            return keyboardActions2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public final void setKeyboardActions(KeyboardActions keyboardActions2) {
        Intrinsics.checkNotNullParameter(keyboardActions2, "<set-?>");
        this.keyboardActions = keyboardActions2;
    }

    public final FocusManager getFocusManager() {
        FocusManager focusManager2 = this.focusManager;
        if (focusManager2 != null) {
            return focusManager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    public final void setFocusManager(FocusManager focusManager2) {
        Intrinsics.checkNotNullParameter(focusManager2, "<set-?>");
        this.focusManager = focusManager2;
    }

    /* renamed from: runAction-KlQnJC8  reason: not valid java name */
    public final void m650runActionKlQnJC8(int i) {
        Function1<KeyboardActionScope, Unit> function1;
        Unit unit = null;
        if (ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3643getDoneeUduSuo())) {
            function1 = getKeyboardActions().getOnDone();
        } else if (ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3644getGoeUduSuo())) {
            function1 = getKeyboardActions().getOnGo();
        } else if (ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3645getNexteUduSuo())) {
            function1 = getKeyboardActions().getOnNext();
        } else if (ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3647getPreviouseUduSuo())) {
            function1 = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3648getSearcheUduSuo())) {
            function1 = getKeyboardActions().getOnSearch();
        } else if (ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3649getSendeUduSuo())) {
            function1 = getKeyboardActions().getOnSend();
        } else {
            if (ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3642getDefaulteUduSuo()) ? true : ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3646getNoneeUduSuo())) {
                function1 = null;
            } else {
                throw new IllegalStateException("invalid ImeAction".toString());
            }
        }
        if (function1 != null) {
            function1.invoke(this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            m649defaultKeyboardActionKlQnJC8(i);
        }
    }

    /* renamed from: defaultKeyboardAction-KlQnJC8  reason: not valid java name */
    public void m649defaultKeyboardActionKlQnJC8(int i) {
        if (ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3645getNexteUduSuo())) {
            getFocusManager().m1309moveFocus3ESFkO8(FocusDirection.Companion.m1304getNextdhqQ8s());
        } else if (ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3647getPreviouseUduSuo())) {
            getFocusManager().m1309moveFocus3ESFkO8(FocusDirection.Companion.m1306getPreviousdhqQ8s());
        } else {
            boolean z = true;
            if (!(ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3643getDoneeUduSuo()) ? true : ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3644getGoeUduSuo()) ? true : ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3648getSearcheUduSuo()) ? true : ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3649getSendeUduSuo()))) {
                z = ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3642getDefaulteUduSuo());
            }
            if (!z) {
                ImeAction.m3638equalsimpl0(i, ImeAction.Companion.m3646getNoneeUduSuo());
            }
        }
    }
}
