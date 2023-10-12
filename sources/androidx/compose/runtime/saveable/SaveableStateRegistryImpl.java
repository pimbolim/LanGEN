package androidx.compose.runtime.saveable;

import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u001c\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0003H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u000bX\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000e0\r0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateRegistryImpl;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "restored", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "", "valueProviders", "", "Lkotlin/Function0;", "value", "consumeRestored", "key", "performSave", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "runtime-saveable_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SaveableStateRegistry.kt */
final class SaveableStateRegistryImpl implements SaveableStateRegistry {
    private final Function1<Object, Boolean> canBeSaved;
    private final Map<String, List<Object>> restored;
    /* access modifiers changed from: private */
    public final Map<String, List<Function0<Object>>> valueProviders;

    public SaveableStateRegistryImpl(Map<String, ? extends List<? extends Object>> map, Function1<Object, Boolean> function1) {
        Map<String, List<Object>> map2;
        Intrinsics.checkNotNullParameter(function1, "canBeSaved");
        this.canBeSaved = function1;
        if (map == null) {
            map2 = null;
        } else {
            map2 = MapsKt.toMutableMap(map);
        }
        this.restored = map2 == null ? new LinkedHashMap<>() : map2;
        this.valueProviders = new LinkedHashMap();
    }

    public boolean canBeSaved(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        return this.canBeSaved.invoke(obj).booleanValue();
    }

    public Object consumeRestored(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        List remove = this.restored.remove(str);
        if (remove == null || !(!remove.isEmpty())) {
            return null;
        }
        if (remove.size() > 1) {
            this.restored.put(str, remove.subList(1, remove.size()));
        }
        return remove.get(0);
    }

    public SaveableStateRegistry.Entry registerProvider(String str, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(function0, "valueProvider");
        if (!StringsKt.isBlank(str)) {
            Map<String, List<Function0<Object>>> map = this.valueProviders;
            List<Function0<Object>> list = map.get(str);
            if (list == null) {
                list = new ArrayList<>();
                map.put(str, list);
            }
            list.add(function0);
            return new SaveableStateRegistryImpl$registerProvider$3(this, str, function0);
        }
        throw new IllegalArgumentException("Registered key is empty or blank".toString());
    }

    public Map<String, List<Object>> performSave() {
        Map<String, List<Object>> mutableMap = MapsKt.toMutableMap(this.restored);
        for (Map.Entry next : this.valueProviders.entrySet()) {
            String str = (String) next.getKey();
            List list = (List) next.getValue();
            int i = 0;
            if (list.size() == 1) {
                Object invoke = ((Function0) list.get(0)).invoke();
                if (invoke == null) {
                    continue;
                } else if (canBeSaved(invoke)) {
                    mutableMap.put(str, CollectionsKt.arrayListOf(invoke));
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                while (i < size) {
                    int i2 = i + 1;
                    Object invoke2 = ((Function0) list.get(i)).invoke();
                    if (invoke2 == null || canBeSaved(invoke2)) {
                        arrayList.add(invoke2);
                        i = i2;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
                mutableMap.put(str, arrayList);
            }
        }
        return mutableMap;
    }
}
