package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
final class VectorPainterKt$RenderVectorGroup$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Map<String, VectorConfig> $configs;
    final /* synthetic */ VectorNode $vectorNode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorPainterKt$RenderVectorGroup$1(VectorNode vectorNode, Map<String, ? extends VectorConfig> map) {
        super(2);
        this.$vectorNode = vectorNode;
        this.$configs = map;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C346@12685L56:VectorPainter.kt#huu6hf");
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            VectorPainterKt.RenderVectorGroup((VectorGroup) this.$vectorNode, this.$configs, composer, 64, 0);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
