package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchPolicy;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import com.braintreepayments.api.models.PostalAddressParser;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u00014B-\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020#H\u0016J\u0018\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020#H\u0016J\u0018\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0018H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u00100\u001a\u00020\u0018H\u0016J\b\u00102\u001a\u00020#H\u0016J\u0010\u00103\u001a\u00020#2\u0006\u00100\u001a\u00020\u0018H\u0016R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher;", "Landroidx/compose/runtime/RememberObserver;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutOnPostMeasureListener;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchPolicy$Subscriber;", "Ljava/lang/Runnable;", "Landroid/view/Choreographer$FrameCallback;", "prefetchPolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchPolicy;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutState;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "view", "Landroid/view/View;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchPolicy;Landroidx/compose/foundation/lazy/layout/LazyLayoutState;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroid/view/View;)V", "averagePrecomposeTimeNs", "", "averagePremeasureTimeNs", "choreographer", "Landroid/view/Choreographer;", "kotlin.jvm.PlatformType", "indexToPrefetch", "", "isActive", "", "precomposedSlotHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "prefetchScheduled", "premeasuringIsNeeded", "calculateAverageTime", "new", "current", "doFrame", "", "frameTimeNanos", "onAbandoned", "onForgotten", "onPostMeasure", "result", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureResult;", "placeablesProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPlaceablesProvider;", "onRemembered", "precompose", "itemsProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemsProvider;", "index", "removeFromPrefetch", "run", "scheduleForPrefetch", "Companion", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayoutPrefetcher.android.kt */
public final class LazyLayoutPrefetcher implements RememberObserver, LazyLayoutOnPostMeasureListener, LazyLayoutPrefetchPolicy.Subscriber, Runnable, Choreographer.FrameCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static long frameIntervalNs;
    private long averagePrecomposeTimeNs;
    private long averagePremeasureTimeNs;
    private final Choreographer choreographer = Choreographer.getInstance();
    private int indexToPrefetch = -1;
    private boolean isActive;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle;
    private final LazyLayoutPrefetchPolicy prefetchPolicy;
    private boolean prefetchScheduled;
    private boolean premeasuringIsNeeded;
    private final LazyLayoutState state;
    private final SubcomposeLayoutState subcomposeLayoutState;
    private final View view;

    public void onAbandoned() {
    }

    public LazyLayoutPrefetcher(LazyLayoutPrefetchPolicy lazyLayoutPrefetchPolicy, LazyLayoutState lazyLayoutState, SubcomposeLayoutState subcomposeLayoutState2, LazyLayoutItemContentFactory lazyLayoutItemContentFactory, View view2) {
        Intrinsics.checkNotNullParameter(lazyLayoutPrefetchPolicy, "prefetchPolicy");
        Intrinsics.checkNotNullParameter(lazyLayoutState, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(subcomposeLayoutState2, "subcomposeLayoutState");
        Intrinsics.checkNotNullParameter(lazyLayoutItemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(view2, "view");
        this.prefetchPolicy = lazyLayoutPrefetchPolicy;
        this.state = lazyLayoutState;
        this.subcomposeLayoutState = subcomposeLayoutState2;
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.view = view2;
        Companion.calculateFrameIntervalIfNeeded(view2);
    }

    public void run() {
        if (this.indexToPrefetch != -1 && this.prefetchScheduled && this.isActive) {
            boolean z = true;
            if (this.precomposedSlotHandle == null) {
                Trace.beginSection("compose:lazylist:prefetch:compose");
                try {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(this.view.getDrawingTime()) + frameIntervalNs;
                    long nanoTime = System.nanoTime();
                    if (nanoTime <= nanos) {
                        if (this.averagePrecomposeTimeNs + nanoTime >= nanos) {
                            this.choreographer.postFrameCallback(this);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    int i = this.indexToPrefetch;
                    LazyLayoutItemsProvider invoke = this.state.getItemsProvider$foundation_release().invoke();
                    if (this.view.getWindowVisibility() == 0) {
                        if (i < 0 || i >= invoke.getItemsCount()) {
                            z = false;
                        }
                        if (z) {
                            this.precomposedSlotHandle = precompose(invoke, i);
                            this.averagePrecomposeTimeNs = calculateAverageTime(System.nanoTime() - nanoTime, this.averagePrecomposeTimeNs);
                            this.choreographer.postFrameCallback(this);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                    this.prefetchScheduled = false;
                    Unit unit22 = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            } else {
                Trace.beginSection("compose:lazylist:prefetch:measure");
                try {
                    long nanos2 = TimeUnit.MILLISECONDS.toNanos(this.view.getDrawingTime()) + frameIntervalNs;
                    long nanoTime2 = System.nanoTime();
                    if (nanoTime2 <= nanos2) {
                        if (this.averagePremeasureTimeNs + nanoTime2 >= nanos2) {
                            this.choreographer.postFrameCallback(this);
                            Unit unit3 = Unit.INSTANCE;
                        }
                    }
                    if (this.view.getWindowVisibility() == 0) {
                        this.premeasuringIsNeeded = true;
                        this.state.remeasure();
                        this.averagePremeasureTimeNs = calculateAverageTime(System.nanoTime() - nanoTime2, this.averagePremeasureTimeNs);
                    }
                    this.prefetchScheduled = false;
                    Unit unit32 = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            }
        }
    }

    public void doFrame(long j) {
        if (this.isActive) {
            this.view.post(this);
        }
    }

    private final SubcomposeLayoutState.PrecomposedSlotHandle precompose(LazyLayoutItemsProvider lazyLayoutItemsProvider, int i) {
        Object key = lazyLayoutItemsProvider.getKey(i);
        return this.subcomposeLayoutState.precompose(key, this.itemContentFactory.getContent(i, key));
    }

    private final long calculateAverageTime(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        long j3 = (long) 4;
        return (j / j3) + ((j2 / j3) * ((long) 3));
    }

    public void scheduleForPrefetch(int i) {
        this.indexToPrefetch = i;
        this.precomposedSlotHandle = null;
        this.premeasuringIsNeeded = false;
        if (!this.prefetchScheduled) {
            this.prefetchScheduled = true;
            this.view.post(this);
        }
    }

    public void removeFromPrefetch(int i) {
        if (i == this.indexToPrefetch) {
            SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle2 = this.precomposedSlotHandle;
            if (precomposedSlotHandle2 != null) {
                precomposedSlotHandle2.dispose();
            }
            this.indexToPrefetch = -1;
        }
    }

    public void onPostMeasure(LazyLayoutMeasureResult lazyLayoutMeasureResult, LazyLayoutPlaceablesProvider lazyLayoutPlaceablesProvider) {
        boolean z;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureResult, "result");
        Intrinsics.checkNotNullParameter(lazyLayoutPlaceablesProvider, "placeablesProvider");
        int i = this.indexToPrefetch;
        if (this.premeasuringIsNeeded && i != -1) {
            if (!this.isActive) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (i < this.state.getItemsProvider$foundation_release().invoke().getItemsCount()) {
                List<LazyLayoutItemInfo> visibleItemsInfo = lazyLayoutMeasureResult.getVisibleItemsInfo();
                int size = visibleItemsInfo.size();
                int i2 = 0;
                while (true) {
                    z = true;
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    int i3 = i2 + 1;
                    if (visibleItemsInfo.get(i2).getIndex() == i) {
                        break;
                    }
                    i2 = i3;
                }
                if (z) {
                    this.premeasuringIsNeeded = false;
                } else {
                    lazyLayoutPlaceablesProvider.m529getAndMeasure0kLqBqw(i, this.prefetchPolicy.m530getConstraintsmsEJaDk());
                }
            }
        }
    }

    public void onRemembered() {
        this.prefetchPolicy.setPrefetcher$foundation_release(this);
        this.state.setOnPostMeasureListener$foundation_release(this);
        this.isActive = true;
    }

    public void onForgotten() {
        this.isActive = false;
        this.prefetchPolicy.setPrefetcher$foundation_release((LazyLayoutPrefetchPolicy.Subscriber) null);
        this.state.setOnPostMeasureListener$foundation_release((LazyLayoutOnPostMeasureListener) null);
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetcher$Companion;", "", "()V", "frameIntervalNs", "", "calculateFrameIntervalIfNeeded", "", "view", "Landroid/view/View;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LazyLayoutPrefetcher.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void calculateFrameIntervalIfNeeded(View view) {
            if (LazyLayoutPrefetcher.frameIntervalNs == 0) {
                Display display = view.getDisplay();
                float f = 60.0f;
                if (!view.isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                LazyLayoutPrefetcher.frameIntervalNs = (long) (((float) 1000000000) / f);
            }
        }
    }
}
