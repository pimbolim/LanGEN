package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u0002H\u0003H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorConfig;", "", "getOrDefault", "T", "property", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "defaultValue", "(Landroidx/compose/ui/graphics/vector/VectorProperty;Ljava/lang/Object;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
public interface VectorConfig {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VectorPainter.kt */
    public static final class DefaultImpls {
        public static <T> T getOrDefault(VectorConfig vectorConfig, VectorProperty<T> vectorProperty, T t) {
            Intrinsics.checkNotNullParameter(vectorConfig, "this");
            Intrinsics.checkNotNullParameter(vectorProperty, "property");
            return t;
        }
    }

    <T> T getOrDefault(VectorProperty<T> vectorProperty, T t);
}
