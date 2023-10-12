package androidx.compose.foundation.relocation;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BringRectangleOnScreen.android.kt */
final class BringRectangleOnScreen_androidKt$bringRectangleOnScreenRequester$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ BringRectangleOnScreenRequester $bringRectangleOnScreenRequester;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BringRectangleOnScreen_androidKt$bringRectangleOnScreenRequester$2(BringRectangleOnScreenRequester bringRectangleOnScreenRequester) {
        super(3);
        this.$bringRectangleOnScreenRequester = bringRectangleOnScreenRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-711358161);
        ComposerKt.sourceInformation(composer, "C48@1713L7,49@1725L168:BringRectangleOnScreen.android.kt#exjx5q");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd(composer);
        final View view = (View) consume;
        final BringRectangleOnScreenRequester bringRectangleOnScreenRequester = this.$bringRectangleOnScreenRequester;
        EffectsKt.DisposableEffect((Object) view, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                bringRectangleOnScreenRequester.setView$foundation_release(view);
                return new BringRectangleOnScreen_androidKt$bringRectangleOnScreenRequester$2$1$invoke$$inlined$onDispose$1(bringRectangleOnScreenRequester);
            }
        }, composer, 8);
        Modifier.Companion companion = Modifier.Companion;
        composer.endReplaceableGroup();
        return companion;
    }
}
