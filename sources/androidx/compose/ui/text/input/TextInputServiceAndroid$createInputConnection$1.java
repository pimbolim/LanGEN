package androidx.compose.ui.text.input;

import android.view.KeyEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u001d\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000f"}, d2 = {"androidx/compose/ui/text/input/TextInputServiceAndroid$createInputConnection$1", "Landroidx/compose/ui/text/input/InputEventCallback2;", "onEditCommands", "", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeAction", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeAction-KlQnJC8", "(I)V", "onKeyEvent", "event", "Landroid/view/KeyEvent;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextInputServiceAndroid.android.kt */
public final class TextInputServiceAndroid$createInputConnection$1 implements InputEventCallback2 {
    final /* synthetic */ TextInputServiceAndroid this$0;

    TextInputServiceAndroid$createInputConnection$1(TextInputServiceAndroid textInputServiceAndroid) {
        this.this$0 = textInputServiceAndroid;
    }

    public void onEditCommands(List<? extends EditCommand> list) {
        Intrinsics.checkNotNullParameter(list, "editCommands");
        this.this$0.onEditCommand.invoke(list);
    }

    /* renamed from: onImeAction-KlQnJC8  reason: not valid java name */
    public void m3692onImeActionKlQnJC8(int i) {
        this.this$0.onImeActionPerformed.invoke(ImeAction.m3635boximpl(i));
    }

    public void onKeyEvent(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        this.this$0.getBaseInputConnection().sendKeyEvent(keyEvent);
    }
}
