package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/ui/platform/WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
public final class WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ View $this_createLifecycleAwareViewTreeRecomposer;

    public void onViewAttachedToWindow(View view) {
    }

    WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$1(View view, Recomposer recomposer) {
        this.$this_createLifecycleAwareViewTreeRecomposer = view;
        this.$recomposer = recomposer;
    }

    public void onViewDetachedFromWindow(View view) {
        this.$this_createLifecycleAwareViewTreeRecomposer.removeOnAttachStateChangeListener(this);
        this.$recomposer.cancel();
    }
}
