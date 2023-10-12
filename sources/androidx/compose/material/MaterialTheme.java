package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/MaterialTheme;", "", "()V", "colors", "Landroidx/compose/material/Colors;", "getColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/Colors;", "shapes", "Landroidx/compose/material/Shapes;", "getShapes", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/Shapes;", "typography", "Landroidx/compose/material/Typography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/Typography;", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaterialTheme.kt */
public final class MaterialTheme {
    public static final int $stable = 0;
    public static final MaterialTheme INSTANCE = new MaterialTheme();

    private MaterialTheme() {
    }

    public final Colors getColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1431171437, "C102@4462L7:MaterialTheme.kt#jmzs0o");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(ColorsKt.getLocalColors());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Colors colors = (Colors) consume;
        ComposerKt.sourceInformationMarkerEnd(composer);
        return colors;
    }

    public final Typography getTypography(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -137609707, "C112@4763L7:MaterialTheme.kt#jmzs0o");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(TypographyKt.getLocalTypography());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Typography typography = (Typography) consume;
        ComposerKt.sourceInformationMarkerEnd(composer);
        return typography;
    }

    public final Shapes getShapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1314390636, "C120@4971L7:MaterialTheme.kt#jmzs0o");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(ShapesKt.getLocalShapes());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Shapes shapes = (Shapes) consume;
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shapes;
    }
}
