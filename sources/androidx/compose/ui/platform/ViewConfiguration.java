package androidx.compose.ui.platform;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u001d\u0010\n\u001a\u00020\u000b8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/ViewConfiguration;", "", "doubleTapMinTimeMillis", "", "getDoubleTapMinTimeMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "longPressTimeoutMillis", "getLongPressTimeoutMillis", "minimumTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "getMinimumTouchTargetSize-MYxV2XQ", "touchSlop", "", "getTouchSlop", "()F", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewConfiguration.kt */
public interface ViewConfiguration {
    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    long getLongPressTimeoutMillis();

    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ  reason: not valid java name */
    long m3453getMinimumTouchTargetSizeMYxV2XQ();

    float getTouchSlop();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ViewConfiguration.kt */
    public static final class DefaultImpls {
        /* renamed from: getMinimumTouchTargetSize-MYxV2XQ  reason: not valid java name */
        public static long m3454getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration viewConfiguration) {
            Intrinsics.checkNotNullParameter(viewConfiguration, "this");
            float f = (float) 48;
            return DpKt.m3881DpSizeYgX7TsA(Dp.m3859constructorimpl(f), Dp.m3859constructorimpl(f));
        }
    }
}
