package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$TabRow$2$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$TabRow$2$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$tabs = function2;
        this.$divider = function22;
        this.$indicator = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m1162invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m3809unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1162invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        Object obj;
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope2, "$this$SubcomposeLayout");
        int r13 = Constraints.m3803getMaxWidthimpl(j);
        List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(TabSlots.Tabs, this.$tabs);
        int size = subcompose.size();
        int i = r13 / size;
        ArrayList arrayList = new ArrayList(subcompose.size());
        int size2 = subcompose.size();
        int i2 = 0;
        while (i2 < size2) {
            arrayList.add(subcompose.get(i2).m3151measureBRTryo0(Constraints.m3794copyZbe2FdA$default(j, i, i, 0, 0, 12, (Object) null)));
            i2++;
            subcompose = subcompose;
        }
        List list = arrayList;
        if (list.isEmpty()) {
            obj = null;
        } else {
            obj = list.get(0);
            int height = ((Placeable) obj).getHeight();
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i3 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int i4 = i3 + 1;
                    Object obj2 = list.get(i3);
                    int height2 = ((Placeable) obj2).getHeight();
                    if (height < height2) {
                        obj = obj2;
                        height = height2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3 = i4;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        int height3 = placeable == null ? 0 : placeable.getHeight();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList2.add(new TabPosition(Dp.m3859constructorimpl(subcomposeMeasureScope2.m3825toDpu2uoSUM(i) * ((float) i5)), subcomposeMeasureScope2.m3825toDpu2uoSUM(i), (DefaultConstructorMarker) null));
        }
        final List list2 = arrayList2;
        Function2<Composer, Integer, Unit> function2 = this.$divider;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
        final int i6 = this.$$dirty;
        final List list3 = list;
        final SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
        final Function2<Composer, Integer, Unit> function22 = function2;
        final int i7 = i;
        final long j2 = j;
        final int i8 = height3;
        final int i9 = r13;
        return MeasureScope.DefaultImpls.layout$default(subcomposeMeasureScope2, r13, height3, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                List<Placeable> list = list3;
                int i = i7;
                int size = list.size();
                int i2 = 0;
                while (i2 < size) {
                    int i3 = i2 + 1;
                    int i4 = i2 * i;
                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i2), i4, 0, 0.0f, 4, (Object) null);
                    i2 = i3;
                }
                List<Measurable> subcompose = subcomposeMeasureScope3.subcompose(TabSlots.Divider, function22);
                long j = j2;
                int i5 = i8;
                int size2 = subcompose.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    Placeable r3 = subcompose.get(i6).m3151measureBRTryo0(Constraints.m3794copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null));
                    Placeable.PlacementScope.placeRelative$default(placementScope, r3, 0, i5 - r3.getHeight(), 0.0f, 4, (Object) null);
                    i5 = i5;
                    size2 = size2;
                }
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope3;
                TabSlots tabSlots = TabSlots.Indicator;
                final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function3;
                final List<TabPosition> list2 = list2;
                final int i7 = i6;
                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(-985542172, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C176@8381L23:TabRow.kt#jmzs0o");
                        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                            function3.invoke(list2, composer, Integer.valueOf(((i7 >> 9) & 112) | 8));
                        } else {
                            composer.skipToGroupEnd();
                        }
                    }
                }));
                int i8 = i9;
                int i9 = i8;
                int size3 = subcompose2.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose2.get(i10).m3151measureBRTryo0(Constraints.Companion.m3811fixedJhjzzOo(i8, i9)), 0, 0, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
