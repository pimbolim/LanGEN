package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidAlertDialog.android.kt */
final class AndroidAlertDialog_androidKt$AlertDialog$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $confirmButton;
    final /* synthetic */ Function2<Composer, Integer, Unit> $dismissButton;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidAlertDialog_androidKt$AlertDialog$1$1$1(Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$dismissButton = function2;
        this.$$dirty = i;
        this.$confirmButton = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C85@4130L15:AndroidAlertDialog.android.kt#jmzs0o");
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Function2<Composer, Integer, Unit> function2 = this.$dismissButton;
            composer.startReplaceableGroup(-1046483318);
            ComposerKt.sourceInformation(composer, "84@4101L8");
            if (function2 != null) {
                function2.invoke(composer, Integer.valueOf((this.$$dirty >> 9) & 14));
            }
            composer.endReplaceableGroup();
            this.$confirmButton.invoke(composer, Integer.valueOf((this.$$dirty >> 3) & 14));
            return;
        }
        composer.skipToGroupEnd();
    }
}
