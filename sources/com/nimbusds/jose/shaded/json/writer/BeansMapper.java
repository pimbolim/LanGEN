package com.nimbusds.jose.shaded.json.writer;

import com.nimbusds.jose.shaded.asm.Accessor;
import com.nimbusds.jose.shaded.asm.BeansAccess;
import com.nimbusds.jose.shaded.asm.ConvertDate;
import com.nimbusds.jose.shaded.asm.FieldFilter;
import com.nimbusds.jose.shaded.json.JSONUtil;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;

public abstract class BeansMapper<T> extends JsonReaderI<T> {
    public static JsonReaderI<Date> MAPPER_DATE = new ArraysMapper<Date>((JsonReader) null) {
        public Date convert(Object obj) {
            return ConvertDate.convertToDate(obj);
        }
    };

    public abstract Object getValue(Object obj, String str);

    public BeansMapper(JsonReader jsonReader) {
        super(jsonReader);
    }

    public static class Bean<T> extends JsonReaderI<T> {
        final BeansAccess<T> ba;
        final Class<T> clz;
        final HashMap<String, Accessor> index;

        public Bean(JsonReader jsonReader, Class<T> cls) {
            super(jsonReader);
            this.clz = cls;
            BeansAccess<T> beansAccess = BeansAccess.get(cls, (FieldFilter) JSONUtil.JSON_SMART_FIELD_FILTER);
            this.ba = beansAccess;
            this.index = beansAccess.getMap();
        }

        public void setValue(Object obj, String str, Object obj2) {
            this.ba.set(obj, str, obj2);
        }

        public Object getValue(Object obj, String str) {
            return this.ba.get(obj, str);
        }

        public Type getType(String str) {
            return this.index.get(str).getGenericType();
        }

        public JsonReaderI<?> startArray(String str) {
            Accessor accessor = this.index.get(str);
            if (accessor != null) {
                return this.base.getMapper(accessor.getGenericType());
            }
            throw new RuntimeException("Can not find Array '" + str + "' field in " + this.clz);
        }

        public JsonReaderI<?> startObject(String str) {
            Accessor accessor = this.index.get(str);
            if (accessor != null) {
                return this.base.getMapper(accessor.getGenericType());
            }
            throw new RuntimeException("Can not find Object '" + str + "' field in " + this.clz);
        }

        public Object createObject() {
            return this.ba.newInstance();
        }
    }

    public static class BeanNoConv<T> extends JsonReaderI<T> {
        final BeansAccess<T> ba;
        final Class<T> clz;
        final HashMap<String, Accessor> index;

        public BeanNoConv(JsonReader jsonReader, Class<T> cls) {
            super(jsonReader);
            this.clz = cls;
            BeansAccess<T> beansAccess = BeansAccess.get(cls, (FieldFilter) JSONUtil.JSON_SMART_FIELD_FILTER);
            this.ba = beansAccess;
            this.index = beansAccess.getMap();
        }

        public void setValue(Object obj, String str, Object obj2) {
            this.ba.set(obj, str, obj2);
        }

        public Object getValue(Object obj, String str) {
            return this.ba.get(obj, str);
        }

        public Type getType(String str) {
            return this.index.get(str).getGenericType();
        }

        public JsonReaderI<?> startArray(String str) {
            Accessor accessor = this.index.get(str);
            if (accessor != null) {
                return this.base.getMapper(accessor.getGenericType());
            }
            throw new RuntimeException("Can not set " + str + " field in " + this.clz);
        }

        public JsonReaderI<?> startObject(String str) {
            Accessor accessor = this.index.get(str);
            if (accessor != null) {
                return this.base.getMapper(accessor.getGenericType());
            }
            throw new RuntimeException("Can not set " + str + " field in " + this.clz);
        }

        public Object createObject() {
            return this.ba.newInstance();
        }
    }
}
