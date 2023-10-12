package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Composer.kt */
final class ComposerImpl$doCompose$2$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposerImpl$doCompose$2$5(Function2<? super Composer, ? super Integer, Unit> function2, ComposerImpl composerImpl) {
        super(0);
        this.$content = function2;
        this.this$0 = composerImpl;
    }

    public final void invoke() {
        if (this.$content != null) {
            this.this$0.startGroup(200, ComposerKt.getInvocation());
            ComposerKt.invokeComposable(this.this$0, this.$content);
            this.this$0.endGroup();
            return;
        }
        this.this$0.skipCurrentGroup();
    }
}
