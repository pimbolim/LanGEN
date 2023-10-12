package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
final class AndroidView_androidKt$AndroidView$1 extends Lambda implements Function0<LayoutNode> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Context, T> $factory;
    final /* synthetic */ CompositionContext $parentReference;
    final /* synthetic */ String $stateKey;
    final /* synthetic */ SaveableStateRegistry $stateRegistry;
    final /* synthetic */ Ref<ViewFactoryHolder<T>> $viewFactoryHolderRef;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidView_androidKt$AndroidView$1(Context context, CompositionContext compositionContext, Function1<? super Context, ? extends T> function1, SaveableStateRegistry saveableStateRegistry, String str, Ref<ViewFactoryHolder<T>> ref) {
        super(0);
        this.$context = context;
        this.$parentReference = compositionContext;
        this.$factory = function1;
        this.$stateRegistry = saveableStateRegistry;
        this.$stateKey = str;
        this.$viewFactoryHolderRef = ref;
    }

    public final LayoutNode invoke() {
        View typedView$ui_release;
        ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(this.$context, this.$parentReference);
        viewFactoryHolder.setFactory(this.$factory);
        SaveableStateRegistry saveableStateRegistry = this.$stateRegistry;
        SparseArray sparseArray = null;
        Object consumeRestored = saveableStateRegistry == null ? null : saveableStateRegistry.consumeRestored(this.$stateKey);
        if (consumeRestored instanceof SparseArray) {
            sparseArray = (SparseArray) consumeRestored;
        }
        if (!(sparseArray == null || (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) == null)) {
            typedView$ui_release.restoreHierarchyState(sparseArray);
        }
        this.$viewFactoryHolderRef.setValue(viewFactoryHolder);
        return viewFactoryHolder.getLayoutNode();
    }
}
