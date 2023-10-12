package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR@\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R<\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00170\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001b\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/viewinterop/ViewFactoryHolder;", "T", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "context", "Landroid/content/Context;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "(Landroid/content/Context;Landroidx/compose/runtime/CompositionContext;)V", "value", "Lkotlin/Function1;", "factory", "getFactory", "()Lkotlin/jvm/functions/Function1;", "setFactory", "(Lkotlin/jvm/functions/Function1;)V", "typedView", "getTypedView$ui_release", "()Landroid/view/View;", "setTypedView$ui_release", "(Landroid/view/View;)V", "Landroid/view/View;", "", "updateBlock", "getUpdateBlock", "setUpdateBlock", "viewRoot", "getViewRoot", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder implements ViewRootForInspector {
    private Function1<? super Context, ? extends T> factory;
    private T typedView;
    private Function1<? super T, Unit> updateBlock;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewFactoryHolder(Context context, CompositionContext compositionContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : compositionContext);
    }

    public AbstractComposeView getSubCompositionView() {
        return ViewRootForInspector.DefaultImpls.getSubCompositionView(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewFactoryHolder(Context context, CompositionContext compositionContext) {
        super(context, compositionContext);
        Intrinsics.checkNotNullParameter(context, "context");
        this.updateBlock = AndroidView_androidKt.getNoOpUpdate();
    }

    public final T getTypedView$ui_release() {
        return this.typedView;
    }

    public final void setTypedView$ui_release(T t) {
        this.typedView = t;
    }

    public View getViewRoot() {
        return this;
    }

    public final Function1<Context, T> getFactory() {
        return this.factory;
    }

    public final void setFactory(Function1<? super Context, ? extends T> function1) {
        this.factory = function1;
        if (function1 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            T t = (View) function1.invoke(context);
            this.typedView = t;
            setView$ui_release(t);
        }
    }

    public final Function1<T, Unit> getUpdateBlock() {
        return this.updateBlock;
    }

    public final void setUpdateBlock(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "value");
        this.updateBlock = function1;
        setUpdate(new ViewFactoryHolder$updateBlock$1(this));
    }
}
