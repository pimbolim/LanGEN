package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0005"}, d2 = {"scale", "Landroidx/compose/ui/Modifier;", "", "scaleX", "scaleY", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scale.kt */
public final class ScaleKt {
    public static final Modifier scale(Modifier modifier, float f, float f2) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "<this>");
        boolean z = true;
        if (f == 1.0f) {
            if (f2 != 1.0f) {
                z = false;
            }
            if (z) {
                return modifier2;
            }
        }
        return GraphicsLayerModifierKt.m1731graphicsLayer2Xn7asI$default(modifier, f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 16380, (Object) null);
    }

    public static final Modifier scale(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return scale(modifier, f, f);
    }
}
