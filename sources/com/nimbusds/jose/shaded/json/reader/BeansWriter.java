package com.nimbusds.jose.shaded.json.reader;

import com.nimbusds.jose.shaded.json.JSONStyle;
import com.nimbusds.jose.shaded.json.JSONUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BeansWriter implements JsonWriterI<Object> {
    public <E> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        Object obj;
        try {
            jSONStyle.objectStart(appendable);
            boolean z = false;
            for (Class cls = e.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    if ((modifiers & 152) <= 0) {
                        if ((modifiers & 1) > 0) {
                            obj = field.get(e);
                        } else {
                            Method method = null;
                            try {
                                method = cls.getDeclaredMethod(JSONUtil.getGetterName(field.getName()), new Class[0]);
                            } catch (Exception unused) {
                            }
                            if (method == null) {
                                Class<?> type = field.getType();
                                if (type == Boolean.TYPE || type == Boolean.class) {
                                    method = cls.getDeclaredMethod(JSONUtil.getIsName(field.getName()), new Class[0]);
                                }
                            }
                            if (method != null) {
                                obj = method.invoke(e, new Object[0]);
                            }
                        }
                        if (obj != null || !jSONStyle.ignoreNull()) {
                            if (z) {
                                jSONStyle.objectNext(appendable);
                            } else {
                                z = true;
                            }
                            JsonWriter.writeJSONKV(field.getName(), obj, appendable, jSONStyle);
                        }
                    }
                }
            }
            jSONStyle.objectStop(appendable);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
