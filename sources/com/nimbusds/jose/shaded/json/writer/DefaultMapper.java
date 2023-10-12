package com.nimbusds.jose.shaded.json.writer;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONAwareEx;
import com.nimbusds.jose.shaded.json.JSONObject;

public class DefaultMapper<T> extends JsonReaderI<T> {
    protected DefaultMapper(JsonReader jsonReader) {
        super(jsonReader);
    }

    public JsonReaderI<JSONAwareEx> startObject(String str) {
        return this.base.DEFAULT;
    }

    public JsonReaderI<JSONAwareEx> startArray(String str) {
        return this.base.DEFAULT;
    }

    public Object createObject() {
        return new JSONObject();
    }

    public Object createArray() {
        return new JSONArray();
    }

    public void setValue(Object obj, String str, Object obj2) {
        ((JSONObject) obj).put(str, obj2);
    }

    public void addValue(Object obj, Object obj2) {
        ((JSONArray) obj).add(obj2);
    }
}
