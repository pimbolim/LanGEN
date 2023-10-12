package com.nimbusds.jose.shaded.json.reader;

import com.nimbusds.jose.shaded.json.JSONAware;
import com.nimbusds.jose.shaded.json.JSONAwareEx;
import com.nimbusds.jose.shaded.json.JSONStreamAware;
import com.nimbusds.jose.shaded.json.JSONStreamAwareEx;
import com.nimbusds.jose.shaded.json.JSONStyle;
import com.nimbusds.jose.shaded.json.JSONValue;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class JsonWriter {
    public static final JsonWriterI<Enum<?>> EnumWriter = new JsonWriterI<Enum<?>>() {
        public <E extends Enum<?>> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            jSONStyle.writeString(appendable, e.name());
        }
    };
    public static final JsonWriterI<Iterable<? extends Object>> JSONIterableWriter = new JsonWriterI<Iterable<? extends Object>>() {
        public <E extends Iterable<? extends Object>> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            jSONStyle.arrayStart(appendable);
            boolean z = true;
            for (Object next : e) {
                if (z) {
                    z = false;
                    jSONStyle.arrayfirstObject(appendable);
                } else {
                    jSONStyle.arrayNextElm(appendable);
                }
                if (next == null) {
                    appendable.append(AbstractJsonLexerKt.NULL);
                } else {
                    JSONValue.writeJSONString(next, appendable, jSONStyle);
                }
                jSONStyle.arrayObjectEnd(appendable);
            }
            jSONStyle.arrayStop(appendable);
        }
    };
    public static final JsonWriterI<JSONAwareEx> JSONJSONAwareExWriter = new JsonWriterI<JSONAwareEx>() {
        public <E extends JSONAwareEx> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            appendable.append(e.toJSONString(jSONStyle));
        }
    };
    public static final JsonWriterI<JSONAware> JSONJSONAwareWriter = new JsonWriterI<JSONAware>() {
        public <E extends JSONAware> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            appendable.append(e.toJSONString());
        }
    };
    public static final JsonWriterI<Map<String, ? extends Object>> JSONMapWriter = new JsonWriterI<Map<String, ? extends Object>>() {
        public <E extends Map<String, ? extends Object>> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            jSONStyle.objectStart(appendable);
            boolean z = true;
            for (Map.Entry entry : e.entrySet()) {
                Object value = entry.getValue();
                if (value != null || !jSONStyle.ignoreNull()) {
                    if (z) {
                        jSONStyle.objectFirstStart(appendable);
                        z = false;
                    } else {
                        jSONStyle.objectNext(appendable);
                    }
                    JsonWriter.writeJSONKV(entry.getKey().toString(), value, appendable, jSONStyle);
                }
            }
            jSONStyle.objectStop(appendable);
        }
    };
    public static final JsonWriterI<JSONStreamAwareEx> JSONStreamAwareExWriter = new JsonWriterI<JSONStreamAwareEx>() {
        public <E extends JSONStreamAwareEx> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            e.writeJSONString(appendable, jSONStyle);
        }
    };
    public static final JsonWriterI<JSONStreamAwareEx> JSONStreamAwareWriter = new JsonWriterI<JSONStreamAwareEx>() {
        public <E extends JSONStreamAwareEx> void writeJSONString(E e, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            e.writeJSONString(appendable);
        }
    };
    public static final JsonWriterI<Object> arrayWriter = new ArrayWriter();
    public static final JsonWriterI<Object> beansWriter = new BeansWriter();
    public static final JsonWriterI<Object> beansWriterASM = new BeansWriterASM();
    public static final JsonWriterI<Object> toStringWriter = new JsonWriterI<Object>() {
        public void writeJSONString(Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
            appendable.append(obj.toString());
        }
    };
    private ConcurrentHashMap<Class<?>, JsonWriterI<?>> data = new ConcurrentHashMap<>();
    private LinkedList<WriterByInterface> writerInterfaces = new LinkedList<>();

    public JsonWriter() {
        init();
    }

    public <T> void remapField(Class<T> cls, String str, String str2) {
        JsonWriterI write = getWrite(cls);
        if (!(write instanceof BeansWriterASMRemap)) {
            write = new BeansWriterASMRemap();
            registerWriter(write, cls);
        }
        ((BeansWriterASMRemap) write).renameField(str, str2);
    }

    static class WriterByInterface {
        public Class<?> _interface;
        public JsonWriterI<?> _writer;

        public WriterByInterface(Class<?> cls, JsonWriterI<?> jsonWriterI) {
            this._interface = cls;
            this._writer = jsonWriterI;
        }
    }

    public JsonWriterI getWriterByInterface(Class<?> cls) {
        Iterator it = this.writerInterfaces.iterator();
        while (it.hasNext()) {
            WriterByInterface writerByInterface = (WriterByInterface) it.next();
            if (writerByInterface._interface.isAssignableFrom(cls)) {
                return writerByInterface._writer;
            }
        }
        return null;
    }

    public JsonWriterI getWrite(Class cls) {
        return this.data.get(cls);
    }

    public void init() {
        registerWriter(new JsonWriterI<String>() {
            public void writeJSONString(String str, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                jSONStyle.writeString(appendable, str);
            }
        }, String.class);
        registerWriter(new JsonWriterI<Double>() {
            public void writeJSONString(Double d, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                if (d.isInfinite()) {
                    appendable.append(AbstractJsonLexerKt.NULL);
                } else {
                    appendable.append(d.toString());
                }
            }
        }, Double.class);
        registerWriter(new JsonWriterI<Date>() {
            public void writeJSONString(Date date, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                appendable.append('\"');
                JSONValue.escape(date.toString(), appendable, jSONStyle);
                appendable.append('\"');
            }
        }, Date.class);
        registerWriter(new JsonWriterI<Float>() {
            public void writeJSONString(Float f, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                if (f.isInfinite()) {
                    appendable.append(AbstractJsonLexerKt.NULL);
                } else {
                    appendable.append(f.toString());
                }
            }
        }, Float.class);
        JsonWriterI<Object> jsonWriterI = toStringWriter;
        registerWriter(jsonWriterI, Integer.class, Long.class, Byte.class, Short.class, BigInteger.class, BigDecimal.class);
        registerWriter(jsonWriterI, Boolean.class);
        registerWriter(new JsonWriterI<int[]>() {
            public void writeJSONString(int[] iArr, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                jSONStyle.arrayStart(appendable);
                boolean z = false;
                for (int i : iArr) {
                    if (z) {
                        jSONStyle.objectNext(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Integer.toString(i));
                }
                jSONStyle.arrayStop(appendable);
            }
        }, int[].class);
        registerWriter(new JsonWriterI<short[]>() {
            public void writeJSONString(short[] sArr, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                jSONStyle.arrayStart(appendable);
                boolean z = false;
                for (short s : sArr) {
                    if (z) {
                        jSONStyle.objectNext(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Short.toString(s));
                }
                jSONStyle.arrayStop(appendable);
            }
        }, short[].class);
        registerWriter(new JsonWriterI<long[]>() {
            public void writeJSONString(long[] jArr, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                jSONStyle.arrayStart(appendable);
                boolean z = false;
                for (long j : jArr) {
                    if (z) {
                        jSONStyle.objectNext(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Long.toString(j));
                }
                jSONStyle.arrayStop(appendable);
            }
        }, long[].class);
        registerWriter(new JsonWriterI<float[]>() {
            public void writeJSONString(float[] fArr, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                jSONStyle.arrayStart(appendable);
                boolean z = false;
                for (float f : fArr) {
                    if (z) {
                        jSONStyle.objectNext(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Float.toString(f));
                }
                jSONStyle.arrayStop(appendable);
            }
        }, float[].class);
        registerWriter(new JsonWriterI<double[]>() {
            public void writeJSONString(double[] dArr, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                jSONStyle.arrayStart(appendable);
                boolean z = false;
                for (double d : dArr) {
                    if (z) {
                        jSONStyle.objectNext(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Double.toString(d));
                }
                jSONStyle.arrayStop(appendable);
            }
        }, double[].class);
        registerWriter(new JsonWriterI<boolean[]>() {
            public void writeJSONString(boolean[] zArr, Appendable appendable, JSONStyle jSONStyle) throws IOException {
                jSONStyle.arrayStart(appendable);
                boolean z = false;
                for (boolean z2 : zArr) {
                    if (z) {
                        jSONStyle.objectNext(appendable);
                    } else {
                        z = true;
                    }
                    appendable.append(Boolean.toString(z2));
                }
                jSONStyle.arrayStop(appendable);
            }
        }, boolean[].class);
        registerWriterInterface(JSONStreamAwareEx.class, JSONStreamAwareExWriter);
        registerWriterInterface(JSONStreamAware.class, JSONStreamAwareWriter);
        registerWriterInterface(JSONAwareEx.class, JSONJSONAwareExWriter);
        registerWriterInterface(JSONAware.class, JSONJSONAwareWriter);
        registerWriterInterface(Map.class, JSONMapWriter);
        registerWriterInterface(Iterable.class, JSONIterableWriter);
        registerWriterInterface(Enum.class, EnumWriter);
        registerWriterInterface(Number.class, jsonWriterI);
    }

    public void addInterfaceWriterFirst(Class<?> cls, JsonWriterI<?> jsonWriterI) {
        registerWriterInterfaceFirst(cls, jsonWriterI);
    }

    public void addInterfaceWriterLast(Class<?> cls, JsonWriterI<?> jsonWriterI) {
        registerWriterInterfaceLast(cls, jsonWriterI);
    }

    public void registerWriterInterfaceLast(Class<?> cls, JsonWriterI<?> jsonWriterI) {
        this.writerInterfaces.addLast(new WriterByInterface(cls, jsonWriterI));
    }

    public void registerWriterInterfaceFirst(Class<?> cls, JsonWriterI<?> jsonWriterI) {
        this.writerInterfaces.addFirst(new WriterByInterface(cls, jsonWriterI));
    }

    public void registerWriterInterface(Class<?> cls, JsonWriterI<?> jsonWriterI) {
        registerWriterInterfaceLast(cls, jsonWriterI);
    }

    public <T> void registerWriter(JsonWriterI<T> jsonWriterI, Class<?>... clsArr) {
        for (Class<?> put : clsArr) {
            this.data.put(put, jsonWriterI);
        }
    }

    public static void writeJSONKV(String str, Object obj, Appendable appendable, JSONStyle jSONStyle) throws IOException {
        if (str == null) {
            appendable.append(AbstractJsonLexerKt.NULL);
        } else if (!jSONStyle.mustProtectKey(str)) {
            appendable.append(str);
        } else {
            appendable.append('\"');
            JSONValue.escape(str, appendable, jSONStyle);
            appendable.append('\"');
        }
        jSONStyle.objectEndOfKey(appendable);
        if (obj instanceof String) {
            jSONStyle.writeString(appendable, (String) obj);
        } else {
            JSONValue.writeJSONString(obj, appendable, jSONStyle);
        }
        jSONStyle.objectElmStop(appendable);
    }
}
