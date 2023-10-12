package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class BasicTextKt$BasicText$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> $inlineComposables;
    final /* synthetic */ AnnotatedString $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextKt$BasicText$6(AnnotatedString annotatedString, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> list, int i) {
        super(2);
        this.$text = annotatedString;
        this.$inlineComposables = list;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C229@10436L39:BasicText.kt#423gt5");
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            CoreTextKt.InlineChildren(this.$text, this.$inlineComposables, composer, (this.$$dirty & 14) | 64);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
