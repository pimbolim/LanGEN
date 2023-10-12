package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"PlatformMaterialTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MaterialTheme.android.kt */
public final class MaterialTheme_androidKt {
    public static final void PlatformMaterialTheme(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(-1558451989);
        ComposerKt.sourceInformation(startRestartGroup, "C(PlatformMaterialTheme)22@789L9:MaterialTheme.android.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((2 ^ (i2 & 11)) != 0 || !startRestartGroup.getSkipping()) {
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new MaterialTheme_androidKt$PlatformMaterialTheme$1(function2, i));
        }
    }
}
