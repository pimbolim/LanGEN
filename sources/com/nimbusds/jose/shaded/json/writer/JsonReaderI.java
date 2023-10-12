package com.nimbusds.jose.shaded.json.writer;

import com.nimbusds.jose.shaded.json.parser.ParseException;
import java.io.IOException;
import java.lang.reflect.Type;

public abstract class JsonReaderI<T> {
    private static String ERR_MSG = "Invalid or non Implemented status";
    public final JsonReader base;

    public T convert(Object obj) {
        return obj;
    }

    public JsonReaderI(JsonReader jsonReader) {
        this.base = jsonReader;
    }

    public JsonReaderI<?> startObject(String str) throws ParseException, IOException {
        throw new RuntimeException(ERR_MSG + " startObject(String key) in " + getClass() + " key=" + str);
    }

    public JsonReaderI<?> startArray(String str) throws ParseException, IOException {
        throw new RuntimeException(ERR_MSG + " startArray in " + getClass() + " key=" + str);
    }

    public void setValue(Object obj, String str, Object obj2) throws ParseException, IOException {
        throw new RuntimeException(ERR_MSG + " setValue in " + getClass() + " key=" + str);
    }

    public Object getValue(Object obj, String str) {
        throw new RuntimeException(ERR_MSG + " getValue(Object current, String key) in " + getClass() + " key=" + str);
    }

    public Type getType(String str) {
        throw new RuntimeException(ERR_MSG + " getType(String key) in " + getClass() + " key=" + str);
    }

    public void addValue(Object obj, Object obj2) throws ParseException, IOException {
        throw new RuntimeException(ERR_MSG + " addValue(Object current, Object value) in " + getClass());
    }

    public Object createObject() {
        throw new RuntimeException(ERR_MSG + " createObject() in " + getClass());
    }

    public Object createArray() {
        throw new RuntimeException(ERR_MSG + " createArray() in " + getClass());
    }
}
