package androidx.compose.ui.res;

import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"colorResource", "Landroidx/compose/ui/graphics/Color;", "id", "", "(ILandroidx/compose/runtime/Composer;I)J", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColorResources.android.kt */
public final class ColorResources_androidKt {
    public static final long colorResource(int i, Composer composer, int i2) {
        long j;
        ComposerKt.sourceInformationMarkerStart(composer, 1085808671, "C(colorResource)37@1238L7:ColorResources.android.kt#ccshc7");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        if (Build.VERSION.SDK_INT >= 23) {
            j = ColorResourceHelper.INSTANCE.m3460getColorWaAFU9c(context, i);
        } else {
            j = ColorKt.Color(context.getResources().getColor(i));
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return j;
    }
}
