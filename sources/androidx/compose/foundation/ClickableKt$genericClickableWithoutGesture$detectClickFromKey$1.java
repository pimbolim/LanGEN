package androidx.compose.foundation;

import androidx.compose.ui.input.key.KeyEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$genericClickableWithoutGesture$detectClickFromKey$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$genericClickableWithoutGesture$detectClickFromKey$1(boolean z, Function0<Unit> function0) {
        super(1);
        this.$enabled = z;
        this.$onClick = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m194invokeZmokQxo(((KeyEvent) obj).m2844unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m194invokeZmokQxo(android.view.KeyEvent keyEvent) {
        boolean z;
        Intrinsics.checkNotNullParameter(keyEvent, "it");
        if (!this.$enabled || !Clickable_androidKt.m195isClickZmokQxo(keyEvent)) {
            z = false;
        } else {
            this.$onClick.invoke();
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
