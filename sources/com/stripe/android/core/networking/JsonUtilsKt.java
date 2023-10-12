package com.stripe.android.core.networking;

import com.stripe.android.core.exception.InvalidSerializationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0016\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0001*\u00020\u0003H\u0007\u001a\u0016\u0010\u0000\u001a\f\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u00030\u0001*\u00020\u0004H\u0007\u001a\u0010\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\u00020\u0007H\u0007\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¨\u0006\t"}, d2 = {"toMap", "", "", "Lkotlinx/serialization/json/JsonElement;", "Lkotlinx/serialization/json/JsonObject;", "toPrimitives", "", "Lkotlinx/serialization/json/JsonArray;", "", "stripe-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: JsonUtils.kt */
public final class JsonUtilsKt {
    public static final Map<String, ?> toMap(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (jsonElement instanceof JsonObject) {
            return toMap((JsonObject) jsonElement);
        }
        String simpleName = jsonElement.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName");
        throw new InvalidSerializationException(simpleName);
    }

    public static final Object toPrimitives(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        if (Intrinsics.areEqual((Object) jsonElement, (Object) JsonNull.INSTANCE)) {
            return null;
        }
        if (jsonElement instanceof JsonArray) {
            return toPrimitives((JsonArray) jsonElement);
        }
        if (jsonElement instanceof JsonObject) {
            return toMap((JsonObject) jsonElement);
        }
        if (jsonElement instanceof JsonPrimitive) {
            return new Regex("^\"|\"$").replace((CharSequence) ((JsonPrimitive) jsonElement).getContent(), "");
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final List<?> toPrimitives(JsonArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "<this>");
        Iterable<JsonElement> iterable = jsonArray;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (JsonElement primitives : iterable) {
            arrayList.add(toPrimitives(primitives));
        }
        return (List) arrayList;
    }

    public static final Map<String, ?> toMap(JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "<this>");
        Map map = jsonObject;
        Collection arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(TuplesKt.to(entry.getKey(), toPrimitives((JsonElement) entry.getValue())));
        }
        return MapsKt.toMap((List) arrayList);
    }
}
