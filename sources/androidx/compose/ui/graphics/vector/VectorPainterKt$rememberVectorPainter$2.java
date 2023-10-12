package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
final class VectorPainterKt$rememberVectorPainter$2 extends Lambda implements Function4<Float, Float, Composer, Integer, Unit> {
    final /* synthetic */ ImageVector $image;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorPainterKt$rememberVectorPainter$2(ImageVector imageVector) {
        super(4);
        this.$image = imageVector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue(), (Composer) obj3, ((Number) obj4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f, float f2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C113@4703L37:VectorPainter.kt#huu6hf");
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            VectorPainterKt.RenderVectorGroup(this.$image.getRoot(), (Map<String, ? extends VectorConfig>) null, composer, 0, 2);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
