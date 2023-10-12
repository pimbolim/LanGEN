package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001cB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J&\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00110\u0005¢\u0006\u0002\b\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001¢\u0006\u0002\u0010\u0016J#\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u00020\tX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u00060\u000fR\u00020\u00000\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "", "saveableStateHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "itemsProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemsProvider;", "(Landroidx/compose/runtime/saveable/SaveableStateHolder;Lkotlin/jvm/functions/Function0;)V", "constraintsOfCachedLambdas", "Landroidx/compose/ui/unit/Constraints;", "J", "densityOfCachedLambdas", "Landroidx/compose/ui/unit/Density;", "lambdasCache", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory$CachedItemContent;", "getContent", "", "Landroidx/compose/runtime/Composable;", "index", "", "key", "(ILjava/lang/Object;)Lkotlin/jvm/functions/Function2;", "onBeforeMeasure", "density", "constraints", "onBeforeMeasure-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)V", "CachedItemContent", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayoutItemContentFactory.kt */
public final class LazyLayoutItemContentFactory {
    private long constraintsOfCachedLambdas = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null);
    private Density densityOfCachedLambdas = DensityKt.Density(0.0f, 0.0f);
    /* access modifiers changed from: private */
    public final Function0<LazyLayoutItemsProvider> itemsProvider;
    /* access modifiers changed from: private */
    public final Map<Object, CachedItemContent> lambdasCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final SaveableStateHolder saveableStateHolder;

    public LazyLayoutItemContentFactory(SaveableStateHolder saveableStateHolder2, Function0<? extends LazyLayoutItemsProvider> function0) {
        Intrinsics.checkNotNullParameter(saveableStateHolder2, "saveableStateHolder");
        Intrinsics.checkNotNullParameter(function0, "itemsProvider");
        this.saveableStateHolder = saveableStateHolder2;
        this.itemsProvider = function0;
    }

    /* renamed from: onBeforeMeasure-0kLqBqw  reason: not valid java name */
    public final void m527onBeforeMeasure0kLqBqw(Density density, long j) {
        Intrinsics.checkNotNullParameter(density, "density");
        if (!Intrinsics.areEqual((Object) density, (Object) this.densityOfCachedLambdas) || !Constraints.m3796equalsimpl0(j, this.constraintsOfCachedLambdas)) {
            this.densityOfCachedLambdas = density;
            this.constraintsOfCachedLambdas = j;
            this.lambdasCache.clear();
        }
    }

    public final Function2<Composer, Integer, Unit> getContent(int i, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "key");
        CachedItemContent cachedItemContent = this.lambdasCache.get(obj);
        if (cachedItemContent != null && cachedItemContent.getLastKnownIndex() == i) {
            return cachedItemContent.getContent();
        }
        CachedItemContent cachedItemContent2 = new CachedItemContent(this, i, obj);
        this.lambdasCache.put(obj, cachedItemContent2);
        return cachedItemContent2.getContent();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005R\u001e\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR+\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory$CachedItemContent;", "", "initialIndex", "", "key", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;ILjava/lang/Object;)V", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getContent", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getKey", "()Ljava/lang/Object;", "<set-?>", "lastKnownIndex", "getLastKnownIndex", "()I", "setLastKnownIndex", "(I)V", "lastKnownIndex$delegate", "Landroidx/compose/runtime/MutableState;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LazyLayoutItemContentFactory.kt */
    private final class CachedItemContent {
        private final Function2<Composer, Integer, Unit> content;
        private final Object key;
        private final MutableState lastKnownIndex$delegate;
        final /* synthetic */ LazyLayoutItemContentFactory this$0;

        public CachedItemContent(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, int i, Object obj) {
            Intrinsics.checkNotNullParameter(lazyLayoutItemContentFactory, "this$0");
            Intrinsics.checkNotNullParameter(obj, "key");
            this.this$0 = lazyLayoutItemContentFactory;
            this.key = obj;
            this.lastKnownIndex$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.content = ComposableLambdaKt.composableLambdaInstance(-985530431, true, new LazyLayoutItemContentFactory$CachedItemContent$content$1(lazyLayoutItemContentFactory, this));
        }

        public final Object getKey() {
            return this.key;
        }

        /* access modifiers changed from: private */
        public final void setLastKnownIndex(int i) {
            this.lastKnownIndex$delegate.setValue(Integer.valueOf(i));
        }

        public final int getLastKnownIndex() {
            return ((Number) this.lastKnownIndex$delegate.getValue()).intValue();
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }
    }
}
