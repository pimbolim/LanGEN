package androidx.compose.runtime.snapshots;

import com.braintreepayments.api.models.PostalAddressParser;
import java.util.HashSet;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\b\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u0015\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0001H\u0010¢\u0006\u0002\b$J\u0015\u0010%\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0001H\u0010¢\u0006\u0002\b&J\r\u0010'\u001a\u00020\tH\u0010¢\u0006\u0002\b(J\u0015\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\rH\u0010¢\u0006\u0002\b+J\u001e\u0010,\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016RL\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8P@VX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078PX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015¨\u0006-"}, d2 = {"Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/HashSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "Lkotlin/collections/HashSet;", "modified", "getModified$runtime_release", "()Ljava/util/HashSet;", "setModified", "(Ljava/util/HashSet;)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "", "getReadOnly", "()Z", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeObserver", "getWriteObserver$runtime_release", "dispose", "hasPendingChanges", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public final class ReadonlySnapshot extends Snapshot {
    private final Function1<Object, Unit> readObserver;
    private int snapshots = 1;

    public HashSet<StateObject> getModified$runtime_release() {
        return null;
    }

    public boolean getReadOnly() {
        return true;
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return null;
    }

    public boolean hasPendingChanges() {
        return false;
    }

    public void notifyObjectsInitialized$runtime_release() {
    }

    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReadonlySnapshot(int i, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1) {
        super(i, snapshotIdSet, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalid");
        this.readObserver = function1;
    }

    public Snapshot getRoot() {
        return this;
    }

    public void setModified(HashSet<StateObject> hashSet) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Snapshot takeNestedSnapshot(Function1<Object, Unit> function1) {
        Snapshot snapshot = this;
        SnapshotKt.validateOpen(snapshot);
        return new NestedReadonlySnapshot(getId(), getInvalid$runtime_release(), function1, snapshot);
    }

    public void dispose() {
        if (!getDisposed$runtime_release()) {
            nestedDeactivated$runtime_release(this);
            super.dispose();
        }
    }

    public void nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshots++;
    }

    public void nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        int i = this.snapshots - 1;
        this.snapshots = i;
        if (i == 0) {
            close$runtime_release();
        }
    }

    public void recordModified$runtime_release(StateObject stateObject) {
        Intrinsics.checkNotNullParameter(stateObject, PostalAddressParser.REGION_KEY);
        Void unused = SnapshotKt.reportReadonlySnapshotWrite();
        throw new KotlinNothingValueException();
    }
}
