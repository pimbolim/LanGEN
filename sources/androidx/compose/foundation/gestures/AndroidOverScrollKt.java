package androidx.compose.foundation.gestures;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0001\u001a\r\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0000\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\t"}, d2 = {"NoOpOverscrollController", "androidx/compose/foundation/gestures/AndroidOverScrollKt$NoOpOverscrollController$1", "Landroidx/compose/foundation/gestures/AndroidOverScrollKt$NoOpOverscrollController$1;", "rememberOverScrollController", "Landroidx/compose/foundation/gestures/OverScrollController;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/OverScrollController;", "overScroll", "Landroidx/compose/ui/Modifier;", "overScrollController", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidOverScroll.kt */
public final class AndroidOverScrollKt {
    private static final AndroidOverScrollKt$NoOpOverscrollController$1 NoOpOverscrollController = new AndroidOverScrollKt$NoOpOverscrollController$1();

    public static final OverScrollController rememberOverScrollController(Composer composer, int i) {
        composer.startReplaceableGroup(-1658914945);
        ComposerKt.sourceInformation(composer, "C(rememberOverScrollController)48@2093L7,49@2147L7,50@2166L194:AndroidOverScroll.kt#8bwon0");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(OverScrollConfigurationKt.getLocalOverScrollConfiguration());
        ComposerKt.sourceInformationMarkerEnd(composer);
        OverScrollConfiguration overScrollConfiguration = (OverScrollConfiguration) consume2;
        composer.startReplaceableGroup(-3686552);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) context) | composer.changed((Object) overScrollConfiguration);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            if (overScrollConfiguration != null) {
                rememberedValue = new AndroidEdgeEffectOverScrollController(context, overScrollConfiguration);
            } else {
                rememberedValue = NoOpOverscrollController;
            }
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        OverScrollController overScrollController = (OverScrollController) rememberedValue;
        composer.endReplaceableGroup();
        return overScrollController;
    }

    public static final Modifier overScroll(Modifier modifier, OverScrollController overScrollController) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(overScrollController, "overScrollController");
        return DrawModifierKt.drawWithContent(modifier, new AndroidOverScrollKt$overScroll$1(overScrollController));
    }
}
