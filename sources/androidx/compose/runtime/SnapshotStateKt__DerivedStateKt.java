package androidx.compose.runtime;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e\u001a0\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000eH\b¢\u0006\u0004\b\u0013\u0010\u0014\u001aj\u0010\u0015\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00102%\u0010\u0016\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u00042%\u0010\u0019\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000eH\u0000\"J\u0010\u0000\u001a>\u0012:\u00128\u00124\u00122\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003j\u0002`\u00070\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000*d\b\u0002\u0010\u001a\".\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00032.\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003¨\u0006\u001b"}, d2 = {"derivedStateObservers", "Landroidx/compose/runtime/SnapshotThreadLocal;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Lkotlin/Pair;", "Lkotlin/Function1;", "Landroidx/compose/runtime/DerivedState;", "", "Landroidx/compose/runtime/DerivedStateObservers;", "isCalculationBlockRunning", "", "derivedStateOf", "Landroidx/compose/runtime/State;", "T", "calculation", "Lkotlin/Function0;", "notifyObservers", "R", "derivedState", "block", "notifyObservers$SnapshotStateKt__DerivedStateKt", "(Landroidx/compose/runtime/DerivedState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeDerivedStateRecalculations", "start", "Lkotlin/ParameterName;", "name", "done", "DerivedStateObservers", "runtime_release"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* compiled from: DerivedState.kt */
final /* synthetic */ class SnapshotStateKt__DerivedStateKt {
    /* access modifiers changed from: private */
    public static final SnapshotThreadLocal<PersistentList<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>>> derivedStateObservers = new SnapshotThreadLocal<>();
    /* access modifiers changed from: private */
    public static final SnapshotThreadLocal<Boolean> isCalculationBlockRunning = new SnapshotThreadLocal<>();

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private static final <R> R notifyObservers$SnapshotStateKt__DerivedStateKt(androidx.compose.runtime.DerivedState<?> r5, kotlin.jvm.functions.Function0<? extends R> r6) {
        /*
            androidx.compose.runtime.SnapshotThreadLocal r0 = derivedStateObservers
            java.lang.Object r0 = r0.get()
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r0
            if (r0 != 0) goto L_0x0010
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.persistentListOf()
        L_0x0010:
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            r2 = 0
            r3 = 0
        L_0x0018:
            if (r3 >= r1) goto L_0x002d
            int r4 = r3 + 1
            java.lang.Object r3 = r0.get(r3)
            kotlin.Pair r3 = (kotlin.Pair) r3
            java.lang.Object r3 = r3.component1()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r3.invoke(r5)
            r3 = r4
            goto L_0x0018
        L_0x002d:
            r1 = 1
            java.lang.Object r6 = r6.invoke()     // Catch:{ all -> 0x0052 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            int r3 = r0.size()
        L_0x0039:
            if (r2 >= r3) goto L_0x004e
            int r4 = r2 + 1
            java.lang.Object r2 = r0.get(r2)
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r2 = r2.component2()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r2.invoke(r5)
            r2 = r4
            goto L_0x0039
        L_0x004e:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            return r6
        L_0x0052:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            int r3 = r0.size()
        L_0x005a:
            if (r2 >= r3) goto L_0x006f
            int r4 = r2 + 1
            java.lang.Object r2 = r0.get(r2)
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r2 = r2.component2()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r2.invoke(r5)
            r2 = r4
            goto L_0x005a
        L_0x006f:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__DerivedStateKt.notifyObservers$SnapshotStateKt__DerivedStateKt(androidx.compose.runtime.DerivedState, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    public static final <T> State<T> derivedStateOf(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        return new DerivedSnapshotState<>(function0);
    }

    public static final <R> void observeDerivedStateRecalculations(Function1<? super State<?>, Unit> function1, Function1<? super State<?>, Unit> function12, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function1, ViewProps.START);
        Intrinsics.checkNotNullParameter(function12, "done");
        Intrinsics.checkNotNullParameter(function0, "block");
        SnapshotThreadLocal<PersistentList<Pair<Function1<DerivedState<?>, Unit>, Function1<DerivedState<?>, Unit>>>> snapshotThreadLocal = derivedStateObservers;
        PersistentList persistentList = snapshotThreadLocal.get();
        try {
            PersistentList persistentList2 = snapshotThreadLocal.get();
            if (persistentList2 == null) {
                persistentList2 = ExtensionsKt.persistentListOf();
            }
            snapshotThreadLocal.set(persistentList2.add(TuplesKt.to(function1, function12)));
            function0.invoke();
            snapshotThreadLocal.set(persistentList);
        } catch (Throwable th) {
            derivedStateObservers.set(persistentList);
            throw th;
        }
    }
}
