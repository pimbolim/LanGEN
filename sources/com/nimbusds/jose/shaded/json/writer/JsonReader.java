package com.nimbusds.jose.shaded.json.writer;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONAware;
import com.nimbusds.jose.shaded.json.JSONAwareEx;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.writer.ArraysMapper;
import com.nimbusds.jose.shaded.json.writer.BeansMapper;
import com.nimbusds.jose.shaded.json.writer.CollectionMapper;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JsonReader {
    public JsonReaderI<JSONAwareEx> DEFAULT = new DefaultMapper(this);
    public JsonReaderI<JSONAwareEx> DEFAULT_ORDERED = new DefaultMapperOrdered(this);
    private final ConcurrentHashMap<Type, JsonReaderI<?>> cache;

    public JsonReader() {
        ConcurrentHashMap<Type, JsonReaderI<?>> concurrentHashMap = new ConcurrentHashMap<>(100);
        this.cache = concurrentHashMap;
        concurrentHashMap.put(Date.class, BeansMapper.MAPPER_DATE);
        concurrentHashMap.put(int[].class, ArraysMapper.MAPPER_PRIM_INT);
        concurrentHashMap.put(Integer[].class, ArraysMapper.MAPPER_INT);
        concurrentHashMap.put(short[].class, ArraysMapper.MAPPER_PRIM_INT);
        concurrentHashMap.put(Short[].class, ArraysMapper.MAPPER_INT);
        concurrentHashMap.put(long[].class, ArraysMapper.MAPPER_PRIM_LONG);
        concurrentHashMap.put(Long[].class, ArraysMapper.MAPPER_LONG);
        concurrentHashMap.put(byte[].class, ArraysMapper.MAPPER_PRIM_BYTE);
        concurrentHashMap.put(Byte[].class, ArraysMapper.MAPPER_BYTE);
        concurrentHashMap.put(char[].class, ArraysMapper.MAPPER_PRIM_CHAR);
        concurrentHashMap.put(Character[].class, ArraysMapper.MAPPER_CHAR);
        concurrentHashMap.put(float[].class, ArraysMapper.MAPPER_PRIM_FLOAT);
        concurrentHashMap.put(Float[].class, ArraysMapper.MAPPER_FLOAT);
        concurrentHashMap.put(double[].class, ArraysMapper.MAPPER_PRIM_DOUBLE);
        concurrentHashMap.put(Double[].class, ArraysMapper.MAPPER_DOUBLE);
        concurrentHashMap.put(boolean[].class, ArraysMapper.MAPPER_PRIM_BOOL);
        concurrentHashMap.put(Boolean[].class, ArraysMapper.MAPPER_BOOL);
        concurrentHashMap.put(JSONAwareEx.class, this.DEFAULT);
        concurrentHashMap.put(JSONAware.class, this.DEFAULT);
        concurrentHashMap.put(JSONArray.class, this.DEFAULT);
        concurrentHashMap.put(JSONObject.class, this.DEFAULT);
    }

    public <T> void remapField(Class<T> cls, String str, String str2) {
        JsonReaderI<T> mapper = getMapper(cls);
        if (!(mapper instanceof MapperRemapped)) {
            MapperRemapped mapperRemapped = new MapperRemapped(mapper);
            registerReader(cls, mapperRemapped);
            mapper = mapperRemapped;
        }
        ((MapperRemapped) mapper).renameField(str, str2);
    }

    public <T> void registerReader(Class<T> cls, JsonReaderI<T> jsonReaderI) {
        this.cache.put(cls, jsonReaderI);
    }

    public <T> JsonReaderI<T> getMapper(Type type) {
        if (type instanceof ParameterizedType) {
            return getMapper((ParameterizedType) type);
        }
        return getMapper((Class) type);
    }

    public <T> JsonReaderI<T> getMapper(Class<T> cls) {
        JsonReaderI<T> jsonReaderI;
        JsonReaderI<T> jsonReaderI2 = this.cache.get(cls);
        if (jsonReaderI2 != null) {
            return jsonReaderI2;
        }
        if (cls instanceof Class) {
            if (Map.class.isAssignableFrom(cls)) {
                jsonReaderI2 = new DefaultMapperCollection<>(this, cls);
            } else if (List.class.isAssignableFrom(cls)) {
                jsonReaderI2 = new DefaultMapperCollection<>(this, cls);
            }
            if (jsonReaderI2 != null) {
                this.cache.put(cls, jsonReaderI2);
                return jsonReaderI2;
            }
        }
        if (cls.isArray()) {
            jsonReaderI = new ArraysMapper.GenericMapper<>(this, cls);
        } else if (List.class.isAssignableFrom(cls)) {
            jsonReaderI = new CollectionMapper.ListClass<>(this, cls);
        } else if (Map.class.isAssignableFrom(cls)) {
            jsonReaderI = new CollectionMapper.MapClass<>(this, cls);
        } else {
            jsonReaderI = new BeansMapper.Bean<>(this, cls);
        }
        this.cache.putIfAbsent(cls, jsonReaderI);
        return jsonReaderI;
    }

    public <T> JsonReaderI<T> getMapper(ParameterizedType parameterizedType) {
        JsonReaderI<T> jsonReaderI = this.cache.get(parameterizedType);
        if (jsonReaderI != null) {
            return jsonReaderI;
        }
        Class cls = (Class) parameterizedType.getRawType();
        if (List.class.isAssignableFrom(cls)) {
            jsonReaderI = new CollectionMapper.ListType<>(this, parameterizedType);
        } else if (Map.class.isAssignableFrom(cls)) {
            jsonReaderI = new CollectionMapper.MapType<>(this, parameterizedType);
        }
        this.cache.putIfAbsent(parameterizedType, jsonReaderI);
        return jsonReaderI;
    }
}
