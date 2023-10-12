package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.unit.Dp;
import com.google.android.gms.common.ConnectionResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\b\u001a%\u0010\u000b\u001a\u00020\u0007*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"BoundDistance", "Landroidx/compose/ui/unit/Dp;", "F", "DEBUG", "", "TargetDistance", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "doSmoothScrollToItem", "Landroidx/compose/foundation/lazy/LazyListState;", "index", "", "scrollOffset", "(Landroidx/compose/foundation/lazy/LazyListState;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListScrolling.kt */
public final class LazyListScrollingKt {
    /* access modifiers changed from: private */
    public static final float BoundDistance = Dp.m3859constructorimpl((float) ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
    private static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public static final float TargetDistance = Dp.m3859constructorimpl((float) 2500);

    private static final void debugLog(Function0<String> function0) {
    }

    /* access modifiers changed from: private */
    public static final LazyListItemInfo doSmoothScrollToItem$getTargetItem(LazyListState lazyListState, int i) {
        LazyListItemInfo lazyListItemInfo;
        List<LazyListItemInfo> visibleItemsInfo = lazyListState.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                lazyListItemInfo = null;
                break;
            }
            int i3 = i2 + 1;
            lazyListItemInfo = visibleItemsInfo.get(i2);
            if (lazyListItemInfo.getIndex() == i) {
                break;
            }
            i2 = i3;
        }
        return lazyListItemInfo;
    }

    public static final Object doSmoothScrollToItem(LazyListState lazyListState, int i, int i2, Continuation<? super Unit> continuation) {
        if (((float) i) >= 0.0f) {
            Object scroll$default = ScrollableState.DefaultImpls.scroll$default(lazyListState, (MutatePriority) null, new LazyListScrollingKt$doSmoothScrollToItem$3(lazyListState, i, i2, (Continuation<? super LazyListScrollingKt$doSmoothScrollToItem$3>) null), continuation, 1, (Object) null);
            return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
        }
        throw new IllegalArgumentException(("Index should be non-negative (" + i + ')').toString());
    }
}
