package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.vector.VectorConfig;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
public final class VectorPainterKt$RenderVectorGroup$config$2 implements VectorConfig {
    VectorPainterKt$RenderVectorGroup$config$2() {
    }

    public <T> T getOrDefault(VectorProperty<T> vectorProperty, T t) {
        return VectorConfig.DefaultImpls.getOrDefault(this, vectorProperty, t);
    }
}
