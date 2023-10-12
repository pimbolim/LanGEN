package com.nimbusds.jose.shaded.json.reader;

import com.nimbusds.jose.shaded.asm.Accessor;
import com.nimbusds.jose.shaded.asm.BeansAccess;
import com.nimbusds.jose.shaded.asm.FieldFilter;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.JSONStyle;
import com.nimbusds.jose.shaded.json.JSONUtil;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class BeansWriterASM implements JsonWriterI<Object> {
    public <E> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        try {
            BeansAccess<P> beansAccess = BeansAccess.get(e.getClass(), (FieldFilter) JSONUtil.JSON_SMART_FIELD_FILTER);
            appendable.append(AbstractJsonLexerKt.BEGIN_OBJ);
            boolean z = false;
            for (Accessor accessor : beansAccess.getAccessors()) {
                Object obj = beansAccess.get(e, accessor.getIndex());
                if (obj != null || !jSONStyle.ignoreNull()) {
                    if (z) {
                        appendable.append(AbstractJsonLexerKt.COMMA);
                    } else {
                        z = true;
                    }
                    JSONObject.writeJSONKV(accessor.getName(), obj, appendable, jSONStyle);
                }
            }
            appendable.append(AbstractJsonLexerKt.END_OBJ);
        } catch (IOException e2) {
            throw e2;
        }
    }
}
