package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityScopeMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "applied", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SnapshotStateObserver.kt */
final class SnapshotStateObserver$applyObserver$1 extends Lambda implements Function2<Set<? extends Object>, Snapshot, Unit> {
    final /* synthetic */ SnapshotStateObserver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateObserver$applyObserver$1(SnapshotStateObserver snapshotStateObserver) {
        super(2);
        this.this$0 = snapshotStateObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Set<? extends Object>) (Set) obj, (Snapshot) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Set<? extends Object> set, Snapshot snapshot) {
        int i;
        Intrinsics.checkNotNullParameter(set, "applied");
        Intrinsics.checkNotNullParameter(snapshot, "$noName_1");
        MutableVector access$getApplyMaps$p = this.this$0.applyMaps;
        SnapshotStateObserver snapshotStateObserver = this.this$0;
        synchronized (access$getApplyMaps$p) {
            MutableVector access$getApplyMaps$p2 = snapshotStateObserver.applyMaps;
            int size = access$getApplyMaps$p2.getSize();
            i = 0;
            if (size > 0) {
                Object[] content = access$getApplyMaps$p2.getContent();
                int i2 = 0;
                do {
                    SnapshotStateObserver.ApplyMap applyMap = (SnapshotStateObserver.ApplyMap) content[i];
                    HashSet<Object> invalidated = applyMap.getInvalidated();
                    IdentityScopeMap map = applyMap.getMap();
                    for (Object access$find : set) {
                        int access$find2 = map.find(access$find);
                        if (access$find2 >= 0) {
                            for (Object add : map.scopeSetAt(access$find2)) {
                                invalidated.add(add);
                                i2 = 1;
                            }
                        }
                    }
                    i++;
                } while (i < size);
                i = i2;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (i != 0) {
            Function1 access$getOnChangedExecutor$p = this.this$0.onChangedExecutor;
            final SnapshotStateObserver snapshotStateObserver2 = this.this$0;
            access$getOnChangedExecutor$p.invoke(new Function0<Unit>() {
                public final void invoke() {
                    snapshotStateObserver2.callOnChanged();
                }
            });
        }
    }
}
