package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\".\u0010\u0000\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u0001j\u0002`\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"EmptyCompositionLocalMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CompositionContext.kt */
public final class CompositionContextKt {
    /* access modifiers changed from: private */
    public static final PersistentMap<CompositionLocal<Object>, State<Object>> EmptyCompositionLocalMap = ExtensionsKt.persistentHashMapOf();
}
