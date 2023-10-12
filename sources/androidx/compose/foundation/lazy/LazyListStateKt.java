package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"rememberLazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/LazyListState;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListState.kt */
public final class LazyListStateKt {
    public static final LazyListState rememberLazyListState(int i, int i2, Composer composer, int i3, int i4) {
        composer.startReplaceableGroup(690738462);
        ComposerKt.sourceInformation(composer, "C(rememberLazyListState)57@2533L176:LazyListState.kt#428nma");
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        LazyListState lazyListState = (LazyListState) RememberSaveableKt.rememberSaveable(new Object[0], LazyListState.Companion.getSaver(), (String) null, new LazyListStateKt$rememberLazyListState$1(i, i2), composer, 72, 4);
        composer.endReplaceableGroup();
        return lazyListState;
    }
}
