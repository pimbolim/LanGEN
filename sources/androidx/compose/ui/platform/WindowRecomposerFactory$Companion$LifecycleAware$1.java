package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/Recomposer;", "rootView", "Landroid/view/View;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
final class WindowRecomposerFactory$Companion$LifecycleAware$1 implements WindowRecomposerFactory {
    public static final WindowRecomposerFactory$Companion$LifecycleAware$1 INSTANCE = new WindowRecomposerFactory$Companion$LifecycleAware$1();

    WindowRecomposerFactory$Companion$LifecycleAware$1() {
    }

    public final Recomposer createRecomposer(View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        return WindowRecomposer_androidKt.createLifecycleAwareViewTreeRecomposer(view);
    }
}
