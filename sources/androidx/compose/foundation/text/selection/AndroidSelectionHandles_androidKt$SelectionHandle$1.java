package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$SelectionHandle$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$SelectionHandle$1(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2, int i) {
        super(2);
        this.$content = function2;
        this.$modifier = modifier;
        this.$isStartHandle = z;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:AndroidSelectionHandles.android.kt#eksfi3");
        if (((i & 11) ^ 2) == 0 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else if (this.$content == null) {
            composer.startReplaceableGroup(386443455);
            ComposerKt.sourceInformation(composer, "65@2583L208");
            Modifier modifier = this.$modifier;
            boolean z = this.$isStartHandle;
            ResolvedTextDirection resolvedTextDirection = this.$direction;
            boolean z2 = this.$handlesCrossed;
            int i2 = this.$$dirty;
            AndroidSelectionHandles_androidKt.DefaultSelectionHandle(modifier, z, resolvedTextDirection, z2, composer, ((i2 >> 12) & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168));
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(386443693);
            ComposerKt.sourceInformation(composer, "72@2821L9");
            this.$content.invoke(composer, Integer.valueOf((this.$$dirty >> 15) & 14));
            composer.endReplaceableGroup();
        }
    }
}
