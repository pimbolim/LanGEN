package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/ViewLayerVerificationHelper;", "", "()V", "setRenderEffect", "", "view", "Landroid/view/View;", "target", "Landroidx/compose/ui/graphics/RenderEffect;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewLayer.android.kt */
final class ViewLayerVerificationHelper {
    public static final ViewLayerVerificationHelper INSTANCE = new ViewLayerVerificationHelper();

    private ViewLayerVerificationHelper() {
    }

    public final void setRenderEffect(View view, RenderEffect renderEffect) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRenderEffect(renderEffect == null ? null : renderEffect.asAndroidRenderEffect());
    }
}
