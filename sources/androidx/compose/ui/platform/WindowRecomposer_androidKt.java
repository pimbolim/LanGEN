package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.R;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\f\u0010\u0011\u001a\u00020\f*\u00020\u0003H\u0002\u001a\f\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u0003\",\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"\u0018\u0010\b\u001a\u00020\u0003*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u001e\u0010\u000b\u001a\u00020\f*\u00020\u00038@X\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"value", "Landroidx/compose/runtime/CompositionContext;", "compositionContext", "Landroid/view/View;", "getCompositionContext", "(Landroid/view/View;)Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroid/view/View;Landroidx/compose/runtime/CompositionContext;)V", "contentChild", "getContentChild", "(Landroid/view/View;)Landroid/view/View;", "windowRecomposer", "Landroidx/compose/runtime/Recomposer;", "getWindowRecomposer$annotations", "(Landroid/view/View;)V", "getWindowRecomposer", "(Landroid/view/View;)Landroidx/compose/runtime/Recomposer;", "createLifecycleAwareViewTreeRecomposer", "findViewTreeCompositionContext", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WindowRecomposer.android.kt */
public final class WindowRecomposer_androidKt {
    public static /* synthetic */ void getWindowRecomposer$annotations(View view) {
    }

    public static final CompositionContext getCompositionContext(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R.id.androidx_compose_ui_view_composition_context);
        if (tag instanceof CompositionContext) {
            return (CompositionContext) tag;
        }
        return null;
    }

    public static final void setCompositionContext(View view, CompositionContext compositionContext) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R.id.androidx_compose_ui_view_composition_context, compositionContext);
    }

    public static final CompositionContext findViewTreeCompositionContext(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        CompositionContext compositionContext = getCompositionContext(view);
        if (compositionContext != null) {
            return compositionContext;
        }
        ViewParent parent = view.getParent();
        while (compositionContext == null && (parent instanceof View)) {
            compositionContext = getCompositionContext((View) parent);
            parent = parent.getParent();
        }
        return compositionContext;
    }

    private static final View getContentChild(View view) {
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getId() == 16908290) {
                return view;
            }
            View view3 = view2;
            parent = view2.getParent();
            view = view3;
        }
        return view;
    }

    public static final Recomposer getWindowRecomposer(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.isAttachedToWindow()) {
            View contentChild = getContentChild(view);
            CompositionContext compositionContext = getCompositionContext(contentChild);
            if (compositionContext == null) {
                return WindowRecomposerPolicy.INSTANCE.createAndInstallWindowRecomposer$ui_release(contentChild);
            }
            if (compositionContext instanceof Recomposer) {
                return (Recomposer) compositionContext;
            }
            throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
        }
        throw new IllegalStateException(("Cannot locate windowRecomposer; View " + view + " is not attached to a window").toString());
    }

    /* access modifiers changed from: private */
    public static final Recomposer createLifecycleAwareViewTreeRecomposer(View view) {
        PausableMonotonicFrameClock pausableMonotonicFrameClock;
        CoroutineContext currentThread = AndroidUiDispatcher.Companion.getCurrentThread();
        MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) currentThread.get(MonotonicFrameClock.Key);
        if (monotonicFrameClock == null) {
            pausableMonotonicFrameClock = null;
        } else {
            PausableMonotonicFrameClock pausableMonotonicFrameClock2 = new PausableMonotonicFrameClock(monotonicFrameClock);
            pausableMonotonicFrameClock2.pause();
            pausableMonotonicFrameClock = pausableMonotonicFrameClock2;
        }
        CoroutineContext plus = currentThread.plus(pausableMonotonicFrameClock == null ? EmptyCoroutineContext.INSTANCE : pausableMonotonicFrameClock);
        Recomposer recomposer = new Recomposer(plus);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(plus);
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(view);
        if (lifecycleOwner != null) {
            view.addOnAttachStateChangeListener(new WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$1(view, recomposer));
            lifecycleOwner.getLifecycle().addObserver(new WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2(CoroutineScope, pausableMonotonicFrameClock, recomposer));
            return recomposer;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("ViewTreeLifecycleOwner not found from ", view).toString());
    }
}
