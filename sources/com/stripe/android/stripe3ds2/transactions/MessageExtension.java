package com.stripe.android.stripe3ds2.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0011\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0012J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bHÂ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\r\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006&"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/MessageExtension;", "Landroid/os/Parcelable;", "name", "", "id", "criticalityIndicator", "", "data", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V", "getCriticalityIndicator", "()Z", "getId$3ds2sdk_release", "()Ljava/lang/String;", "isProcessable", "getName", "component1", "component2", "component2$3ds2sdk_release", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toJson$3ds2sdk_release", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageExtension.kt */
public final class MessageExtension implements Parcelable {
    public static final Parcelable.Creator<MessageExtension> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DATA_VALUE_MAX_LENGTH = 8059;
    public static final String FIELD_CRITICALITY_INDICATOR = "criticalityIndicator";
    public static final String FIELD_DATA = "data";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    private static final int ID_MAX_LENGTH = 64;
    private static final int MESSAGE_EXTENSIONS_MAX_COUNT = 10;
    private static final int NAME_MAX_LENGTH = 64;
    private static final List<String> SUPPORTED_MESSAGE_EXTENSIONS = CollectionsKt.emptyList();
    private final boolean criticalityIndicator;
    private final Map<String, String> data;
    private final String id;
    private final String name;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageExtension.kt */
    public static final class Creator implements Parcelable.Creator<MessageExtension> {
        public final MessageExtension createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new MessageExtension(readString, readString2, z, linkedHashMap);
        }

        public final MessageExtension[] newArray(int i) {
            return new MessageExtension[i];
        }
    }

    private final Map<String, String> component4() {
        return this.data;
    }

    public static /* synthetic */ MessageExtension copy$default(MessageExtension messageExtension, String str, String str2, boolean z, Map<String, String> map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageExtension.name;
        }
        if ((i & 2) != 0) {
            str2 = messageExtension.id;
        }
        if ((i & 4) != 0) {
            z = messageExtension.criticalityIndicator;
        }
        if ((i & 8) != 0) {
            map = messageExtension.data;
        }
        return messageExtension.copy(str, str2, z, map);
    }

    @JvmStatic
    public static final List<MessageExtension> fromJson(JSONArray jSONArray) throws ChallengeResponseParseException {
        return Companion.fromJson(jSONArray);
    }

    @JvmStatic
    public static final JSONArray toJsonArray(List<MessageExtension> list) throws JSONException {
        return Companion.toJsonArray(list);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2$3ds2sdk_release() {
        return this.id;
    }

    public final boolean component3() {
        return this.criticalityIndicator;
    }

    public final MessageExtension copy(String str, String str2, boolean z, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, FIELD_ID);
        Intrinsics.checkNotNullParameter(map, "data");
        return new MessageExtension(str, str2, z, map);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageExtension)) {
            return false;
        }
        MessageExtension messageExtension = (MessageExtension) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) messageExtension.name) && Intrinsics.areEqual((Object) this.id, (Object) messageExtension.id) && this.criticalityIndicator == messageExtension.criticalityIndicator && Intrinsics.areEqual((Object) this.data, (Object) messageExtension.data);
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.id.hashCode()) * 31;
        boolean z = this.criticalityIndicator;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "MessageExtension(name=" + this.name + ", id=" + this.id + ", criticalityIndicator=" + this.criticalityIndicator + ", data=" + this.data + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.id);
        parcel.writeInt(this.criticalityIndicator ? 1 : 0);
        Map<String, String> map = this.data;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public MessageExtension(String str, String str2, boolean z, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, FIELD_ID);
        Intrinsics.checkNotNullParameter(map, "data");
        this.name = str;
        this.id = str2;
        this.criticalityIndicator = z;
        this.data = map;
    }

    public final String getName() {
        return this.name;
    }

    public final String getId$3ds2sdk_release() {
        return this.id;
    }

    public final boolean getCriticalityIndicator() {
        return this.criticalityIndicator;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageExtension(String str, String str2, boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, z, (i & 8) != 0 ? MapsKt.emptyMap() : map);
    }

    public final boolean isProcessable() {
        return SUPPORTED_MESSAGE_EXTENSIONS.contains(this.name);
    }

    public final JSONObject toJson$3ds2sdk_release() throws JSONException {
        JSONObject put = new JSONObject().put("name", this.name).put(FIELD_ID, this.id).put(FIELD_CRITICALITY_INDICATOR, this.criticalityIndicator).put("data", new JSONObject(this.data));
        Intrinsics.checkNotNullExpressionValue(put, "JSONObject()\n           …D_DATA, JSONObject(data))");
        return put;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/MessageExtension$Companion;", "", "()V", "DATA_VALUE_MAX_LENGTH", "", "FIELD_CRITICALITY_INDICATOR", "", "FIELD_DATA", "FIELD_ID", "FIELD_NAME", "ID_MAX_LENGTH", "MESSAGE_EXTENSIONS_MAX_COUNT", "NAME_MAX_LENGTH", "SUPPORTED_MESSAGE_EXTENSIONS", "", "fromJson", "Lcom/stripe/android/stripe3ds2/transactions/MessageExtension;", "messageExtensionsJson", "Lorg/json/JSONArray;", "messageExtensionJson", "Lorg/json/JSONObject;", "toJsonArray", "messageExtensions", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageExtension.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final JSONArray toJsonArray(List<MessageExtension> list) throws JSONException {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (MessageExtension json$3ds2sdk_release : list) {
                jSONArray.put(json$3ds2sdk_release.toJson$3ds2sdk_release());
            }
            return jSONArray;
        }

        @JvmStatic
        public final List<MessageExtension> fromJson(JSONArray jSONArray) throws ChallengeResponseParseException {
            if (jSONArray == null) {
                return null;
            }
            Collection arrayList = new ArrayList();
            Iterator it = RangesKt.until(0, jSONArray.length()).iterator();
            while (it.hasNext()) {
                JSONObject optJSONObject = jSONArray.optJSONObject(((IntIterator) it).nextInt());
                if (optJSONObject != null) {
                    arrayList.add(optJSONObject);
                }
            }
            Iterable<JSONObject> iterable = (List) arrayList;
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (JSONObject fromJson : iterable) {
                arrayList2.add(MessageExtension.Companion.fromJson(fromJson));
            }
            List<MessageExtension> list = (List) arrayList2;
            if (list.size() <= 10) {
                return list;
            }
            throw ChallengeResponseParseException.Companion.createInvalidDataElementFormat(ChallengeRequestData.FIELD_MESSAGE_EXTENSION);
        }

        private final MessageExtension fromJson(JSONObject jSONObject) throws ChallengeResponseParseException {
            String optString = jSONObject.optString("name");
            if (optString.length() <= 64) {
                String optString2 = jSONObject.optString(MessageExtension.FIELD_ID);
                if (optString2.length() <= 64) {
                    HashMap hashMap = new HashMap();
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            String optString3 = optJSONObject.optString(next);
                            if (optString3.length() <= MessageExtension.DATA_VALUE_MAX_LENGTH) {
                                Intrinsics.checkNotNullExpressionValue(next, "key");
                                Intrinsics.checkNotNullExpressionValue(optString3, "value");
                                hashMap.put(next, optString3);
                            } else {
                                throw ChallengeResponseParseException.Companion.createInvalidDataElementFormat("messageExtension.data.value");
                            }
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(optString, "name");
                    Intrinsics.checkNotNullExpressionValue(optString2, MessageExtension.FIELD_ID);
                    return new MessageExtension(optString, optString2, jSONObject.optBoolean(MessageExtension.FIELD_CRITICALITY_INDICATOR), hashMap);
                }
                throw ChallengeResponseParseException.Companion.createInvalidDataElementFormat("messageExtension.id");
            }
            throw ChallengeResponseParseException.Companion.createInvalidDataElementFormat("messageExtension.name");
        }
    }
}
