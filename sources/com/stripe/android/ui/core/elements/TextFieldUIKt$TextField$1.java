package com.stripe.android.ui.core.elements;

import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldUI.kt */
final class TextFieldUIKt$TextField$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ State<String> $value$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldUIKt$TextField$1(FocusManager focusManager, State<String> state) {
        super(1);
        this.$focusManager = focusManager;
        this.$value$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m4625invokeZmokQxo(((KeyEvent) obj).m2844unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m4625invokeZmokQxo(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        boolean z = true;
        if (KeyEventType.m2848equalsimpl0(KeyEvent_androidKt.m2856getTypeZmokQxo(keyEvent), KeyEventType.Companion.m2852getKeyDownCS__XNY()) && keyEvent.getKeyCode() == 67) {
            if (TextFieldUIKt.m4608TextField_6fMdlN4$lambda0(this.$value$delegate).length() == 0) {
                this.$focusManager.m1309moveFocus3ESFkO8(FocusDirection.Companion.m1306getPreviousdhqQ8s());
                return Boolean.valueOf(z);
            }
        }
        z = false;
        return Boolean.valueOf(z);
    }
}
