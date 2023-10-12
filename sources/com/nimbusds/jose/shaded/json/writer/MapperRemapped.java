package com.nimbusds.jose.shaded.json.writer;

import com.nimbusds.jose.shaded.json.parser.ParseException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MapperRemapped<T> extends JsonReaderI<T> {
    private JsonReaderI<T> parent;
    private Map<String, String> rename = new HashMap();

    public MapperRemapped(JsonReaderI<T> jsonReaderI) {
        super(jsonReaderI.base);
        this.parent = jsonReaderI;
    }

    public void renameField(String str, String str2) {
        this.rename.put(str, str2);
    }

    private String rename(String str) {
        String str2 = this.rename.get(str);
        return str2 != null ? str2 : str;
    }

    public void setValue(Object obj, String str, Object obj2) throws ParseException, IOException {
        this.parent.setValue(obj, rename(str), obj2);
    }

    public Object getValue(Object obj, String str) {
        return this.parent.getValue(obj, rename(str));
    }

    public Type getType(String str) {
        return this.parent.getType(rename(str));
    }

    public JsonReaderI<?> startArray(String str) throws ParseException, IOException {
        return this.parent.startArray(rename(str));
    }

    public JsonReaderI<?> startObject(String str) throws ParseException, IOException {
        return this.parent.startObject(rename(str));
    }

    public Object createObject() {
        return this.parent.createObject();
    }
}
