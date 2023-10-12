package androidx.lifecycle.viewmodel.compose;

import android.os.Bundle;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.core.os.BundleKt;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a>\u0010\u0000\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001\"\u0004\b\u0000\u0010\u00032\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0001H\u0002\u001aI\u0010\u0006\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00030\fH\u0007¢\u0006\u0002\u0010\r\u001aJ\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0002\"\u0004\b\u0000\u0010\u0003*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u00012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\fH\u0007¨\u0006\u000f"}, d2 = {"mutableStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/MutableState;", "T", "", "inner", "saveable", "Landroidx/lifecycle/SavedStateHandle;", "key", "", "saver", "init", "Lkotlin/Function0;", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Landroidx/compose/runtime/saveable/Saver;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "stateSaver", "lifecycle-viewmodel-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SavedStateHandleSaver.kt */
public final class SavedStateHandleSaverKt {
    public static /* synthetic */ Object saveable$default(SavedStateHandle savedStateHandle, String str, Saver saver, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            saver = SaverKt.autoSaver();
        }
        return saveable(savedStateHandle, str, saver, function0);
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [kotlin.jvm.functions.Function0<? extends T>, java.lang.Object, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
    /* renamed from: saveable  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T m4225saveable(androidx.lifecycle.SavedStateHandle r3, java.lang.String r4, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r5, kotlin.jvm.functions.Function0<? extends T> r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "saver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "init"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Object r0 = r3.get(r4)
            android.os.Bundle r0 = (android.os.Bundle) r0
            r1 = 0
            if (r0 != 0) goto L_0x001e
            goto L_0x002c
        L_0x001e:
            java.lang.String r2 = "value"
            java.lang.Object r0 = r0.get(r2)
            if (r0 != 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            java.lang.Object r1 = r5.restore(r0)
        L_0x002c:
            if (r1 != 0) goto L_0x0032
            java.lang.Object r1 = r6.invoke()
        L_0x0032:
            androidx.lifecycle.viewmodel.compose.-$$Lambda$SavedStateHandleSaverKt$kE_bNqaIDS7rEPs4NPMjpxulMyk r6 = new androidx.lifecycle.viewmodel.compose.-$$Lambda$SavedStateHandleSaverKt$kE_bNqaIDS7rEPs4NPMjpxulMyk
            r6.<init>(r1)
            r3.setSavedStateProvider(r4, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.m4225saveable(androidx.lifecycle.SavedStateHandle, java.lang.String, androidx.compose.runtime.saveable.Saver, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: saveable$lambda-1  reason: not valid java name */
    public static final Bundle m4224saveable$lambda1(Saver saver, Object obj) {
        Intrinsics.checkNotNullParameter(saver, "$saver");
        Intrinsics.checkNotNullParameter(obj, "$value");
        return BundleKt.bundleOf(TuplesKt.to("value", saver.save(new SavedStateHandleSaverKt$saveable$1$1$1(obj), obj)));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [androidx.compose.runtime.saveable.Saver, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object>, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r4v0, types: [kotlin.jvm.functions.Function0<? extends androidx.compose.runtime.MutableState<T>>, java.lang.Object, kotlin.jvm.functions.Function0] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> androidx.compose.runtime.MutableState<T> saveable(androidx.lifecycle.SavedStateHandle r1, java.lang.String r2, androidx.compose.runtime.saveable.Saver<T, ? extends java.lang.Object> r3, kotlin.jvm.functions.Function0<? extends androidx.compose.runtime.MutableState<T>> r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "stateSaver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "init"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.compose.runtime.saveable.Saver r3 = mutableStateSaver(r3)
            java.lang.Object r1 = saveable((androidx.lifecycle.SavedStateHandle) r1, (java.lang.String) r2, r3, r4)
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.viewmodel.compose.SavedStateHandleSaverKt.saveable(androidx.lifecycle.SavedStateHandle, java.lang.String, androidx.compose.runtime.saveable.Saver, kotlin.jvm.functions.Function0):androidx.compose.runtime.MutableState");
    }

    private static final <T> Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(Saver<T, ? extends Object> saver) {
        return SaverKt.Saver(new SavedStateHandleSaverKt$mutableStateSaver$1$1(saver), new SavedStateHandleSaverKt$mutableStateSaver$1$2(saver));
    }
}
