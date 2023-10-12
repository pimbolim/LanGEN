package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B/\b\u0000\u0012&\u0010\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u0003j\u0002`\u0006¢\u0006\u0002\u0010\u0007R4\u0010\u0002\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u0003j\u0002`\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/runtime/CompositionLocalContext;", "", "compositionLocals", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getCompositionLocals$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CompositionLocal.kt */
public final class CompositionLocalContext {
    private final PersistentMap<CompositionLocal<Object>, State<Object>> compositionLocals;

    public CompositionLocalContext(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap) {
        Intrinsics.checkNotNullParameter(persistentMap, "compositionLocals");
        this.compositionLocals = persistentMap;
    }

    public final PersistentMap<CompositionLocal<Object>, State<Object>> getCompositionLocals$runtime_release() {
        return this.compositionLocals;
    }
}
