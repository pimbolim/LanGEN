package androidx.compose.foundation;

import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"_isSystemInDarkTheme", "", "(Landroidx/compose/runtime/Composer;I)Z", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DarkTheme.android.kt */
public final class DarkTheme_androidKt {
    public static final boolean _isSystemInDarkTheme(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 66764099, "C(_isSystemInDarkTheme)47@2141L7:DarkTheme.android.kt#71ulvw");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean z = (((Configuration) consume).uiMode & 48) == 32;
        ComposerKt.sourceInformationMarkerEnd(composer);
        return z;
    }
}
