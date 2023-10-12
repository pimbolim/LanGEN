package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"$\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LocalOverScrollConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/gestures/OverScrollConfiguration;", "getLocalOverScrollConfiguration$annotations", "()V", "getLocalOverScrollConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: OverScrollConfiguration.kt */
public final class OverScrollConfigurationKt {
    private static final ProvidableCompositionLocal<OverScrollConfiguration> LocalOverScrollConfiguration = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, OverScrollConfigurationKt$LocalOverScrollConfiguration$1.INSTANCE, 1, (Object) null);

    @ExperimentalFoundationApi
    public static /* synthetic */ void getLocalOverScrollConfiguration$annotations() {
    }

    @ExperimentalFoundationApi
    public static final ProvidableCompositionLocal<OverScrollConfiguration> getLocalOverScrollConfiguration() {
        return LocalOverScrollConfiguration;
    }
}
