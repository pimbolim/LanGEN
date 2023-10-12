package androidx.compose.foundation.gestures;

import androidx.compose.ui.Modifier;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000¨\u0006\b"}, d2 = {"mouseScrollable", "Landroidx/compose/ui/Modifier;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "onScroll", "Lkotlin/Function1;", "", "", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidScrollable.android.kt */
public final class AndroidScrollable_androidKt {
    public static final Modifier mouseScrollable(Modifier modifier, Orientation orientation, Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(orientation, ReactVideoView.EVENT_PROP_ORIENTATION);
        Intrinsics.checkNotNullParameter(function1, "onScroll");
        return modifier;
    }
}
