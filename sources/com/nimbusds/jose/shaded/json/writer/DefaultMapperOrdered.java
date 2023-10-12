package com.nimbusds.jose.shaded.json.writer;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONAwareEx;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultMapperOrdered extends JsonReaderI<JSONAwareEx> {
    protected DefaultMapperOrdered(JsonReader jsonReader) {
        super(jsonReader);
    }

    public JsonReaderI<JSONAwareEx> startObject(String str) {
        return this.base.DEFAULT_ORDERED;
    }

    public JsonReaderI<JSONAwareEx> startArray(String str) {
        return this.base.DEFAULT_ORDERED;
    }

    public void setValue(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    public Object createObject() {
        return new LinkedHashMap();
    }

    public void addValue(Object obj, Object obj2) {
        ((JSONArray) obj).add(obj2);
    }

    public Object createArray() {
        return new JSONArray();
    }
}
