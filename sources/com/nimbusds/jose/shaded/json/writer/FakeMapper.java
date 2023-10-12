package com.nimbusds.jose.shaded.json.writer;

public class FakeMapper extends JsonReaderI<Object> {
    public static JsonReaderI<Object> DEFAULT = new FakeMapper();

    public void addValue(Object obj, Object obj2) {
    }

    public Object createArray() {
        return null;
    }

    public Object createObject() {
        return null;
    }

    public void setValue(Object obj, String str, Object obj2) {
    }

    public JsonReaderI<?> startArray(String str) {
        return this;
    }

    public JsonReaderI<?> startObject(String str) {
        return this;
    }

    private FakeMapper() {
        super((JsonReader) null);
    }
}
