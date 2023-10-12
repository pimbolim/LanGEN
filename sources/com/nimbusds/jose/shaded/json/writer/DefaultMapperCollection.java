package com.nimbusds.jose.shaded.json.writer;

import java.util.List;
import java.util.Map;

public class DefaultMapperCollection<T> extends JsonReaderI<T> {
    Class<T> clz;

    public JsonReaderI<T> startArray(String str) {
        return this;
    }

    public JsonReaderI<T> startObject(String str) {
        return this;
    }

    public DefaultMapperCollection(JsonReader jsonReader, Class<T> cls) {
        super(jsonReader);
        this.clz = cls;
    }

    public Object createObject() {
        try {
            return this.clz.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public Object createArray() {
        try {
            return this.clz.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public void setValue(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    public void addValue(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }
}
