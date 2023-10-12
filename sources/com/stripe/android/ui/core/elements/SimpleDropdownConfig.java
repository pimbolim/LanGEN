package com.stripe.android.ui.core.elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/ui/core/elements/SimpleDropdownConfig;", "Lcom/stripe/android/ui/core/elements/DropdownConfig;", "label", "", "items", "", "Lcom/stripe/android/ui/core/elements/DropdownItemSpec;", "(ILjava/util/List;)V", "debugLabel", "", "getDebugLabel", "()Ljava/lang/String;", "getLabel", "()I", "convertFromRaw", "rawValue", "convertToRaw", "displayName", "getDisplayItems", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleDropdownConfig.kt */
public final class SimpleDropdownConfig implements DropdownConfig {
    public static final int $stable = 8;
    private final String debugLabel = "simple_dropdown";
    private final List<DropdownItemSpec> items;
    private final int label;

    public SimpleDropdownConfig(int i, List<DropdownItemSpec> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.label = i;
        this.items = list;
    }

    public int getLabel() {
        return this.label;
    }

    public String getDebugLabel() {
        return this.debugLabel;
    }

    public List<String> getDisplayItems() {
        Iterable<DropdownItemSpec> iterable = this.items;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (DropdownItemSpec text : iterable) {
            arrayList.add(text.getText());
        }
        return (List) arrayList;
    }

    public String convertFromRaw(String str) {
        String str2;
        Object obj;
        Intrinsics.checkNotNullParameter(str, "rawValue");
        Iterator it = this.items.iterator();
        while (true) {
            str2 = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((DropdownItemSpec) obj).getValue(), (Object) str)) {
                break;
            }
        }
        DropdownItemSpec dropdownItemSpec = (DropdownItemSpec) obj;
        if (dropdownItemSpec != null) {
            str2 = dropdownItemSpec.getText();
        }
        return str2 == null ? this.items.get(0).getText() : str2;
    }

    public String convertToRaw(String str) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        Collection arrayList = new ArrayList();
        for (Object next : this.items) {
            if (Intrinsics.areEqual((Object) ((DropdownItemSpec) next).getText(), (Object) str)) {
                arrayList.add(next);
            }
        }
        Iterable<DropdownItemSpec> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (DropdownItemSpec value : iterable) {
            arrayList2.add(value.getValue());
        }
        return (String) CollectionsKt.firstOrNull((List) arrayList2);
    }
}
