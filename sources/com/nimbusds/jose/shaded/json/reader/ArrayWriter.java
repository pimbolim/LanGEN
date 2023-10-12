package com.nimbusds.jose.shaded.json.reader;

import com.nimbusds.jose.shaded.json.JSONStyle;
import com.nimbusds.jose.shaded.json.JSONValue;
import java.io.IOException;

public class ArrayWriter implements JsonWriterI<Object> {
    public <E> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        jSONStyle.arrayStart(appendable);
        boolean z = false;
        for (Object obj : (Object[]) e) {
            if (z) {
                jSONStyle.objectNext(appendable);
            } else {
                z = true;
            }
            JSONValue.writeJSONString(obj, appendable, jSONStyle);
        }
        jSONStyle.arrayStop(appendable);
    }
}
