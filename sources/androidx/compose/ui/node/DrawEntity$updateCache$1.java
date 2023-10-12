package androidx.compose.ui.node;

import androidx.compose.ui.draw.DrawCacheModifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawEntity.kt */
final class DrawEntity$updateCache$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DrawEntity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawEntity$updateCache$1(DrawEntity drawEntity) {
        super(0);
        this.this$0 = drawEntity;
    }

    public final void invoke() {
        DrawCacheModifier access$getCacheDrawModifier$p = this.this$0.cacheDrawModifier;
        if (access$getCacheDrawModifier$p != null) {
            access$getCacheDrawModifier$p.onBuildCache(this.this$0.buildCacheParams);
        }
        this.this$0.invalidateCache = false;
    }
}
