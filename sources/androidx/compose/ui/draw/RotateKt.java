package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"rotate", "Landroidx/compose/ui/Modifier;", "degrees", "", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Rotate.kt */
public final class RotateKt {
    public static final Modifier rotate(Modifier modifier, float f) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "<this>");
        return !((f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) == 0) ? GraphicsLayerModifierKt.m1731graphicsLayer2Xn7asI$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 16127, (Object) null) : modifier2;
    }
}
