package com.nimbusds.jose.util;

import com.drew.metadata.exif.makernotes.OlympusMakernoteDirectory;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONObjectUtils {
    public static Map<String, Object> parse(String str) throws ParseException {
        return parse(str, -1);
    }

    public static Map<String, Object> parse(String str, int i) throws ParseException {
        if (i < 0 || str.length() <= i) {
            try {
                Object parse = new JSONParser(OlympusMakernoteDirectory.TAG_PREVIEW_IMAGE).parse(str);
                if (parse instanceof JSONObject) {
                    return (JSONObject) parse;
                }
                throw new ParseException("JSON entity is not an object", 0);
            } catch (com.nimbusds.jose.shaded.json.parser.ParseException e) {
                throw new ParseException("Invalid JSON: " + e.getMessage(), 0);
            } catch (Exception e2) {
                throw new ParseException("Unexpected exception: " + e2.getMessage(), 0);
            } catch (StackOverflowError unused) {
                throw new ParseException("Excessive JSON object and / or array nesting", 0);
            }
        } else {
            throw new ParseException("The parsed string is longer than the max accepted size of " + i + " characters", 0);
        }
    }

    @Deprecated
    public static Map<String, Object> parseJSONObject(String str) throws ParseException {
        return parse(str);
    }

    private static <T> T getGeneric(Map<String, Object> map, String str, Class<T> cls) throws ParseException {
        if (map.get(str) == null) {
            return null;
        }
        T t = map.get(str);
        if (cls.isAssignableFrom(t.getClass())) {
            return t;
        }
        throw new ParseException("Unexpected type of JSON object member with key " + str + "", 0);
    }

    public static boolean getBoolean(Map<String, Object> map, String str) throws ParseException {
        Boolean bool = (Boolean) getGeneric(map, str, Boolean.class);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new ParseException("JSON object member with key " + str + " is missing or null", 0);
    }

    public static int getInt(Map<String, Object> map, String str) throws ParseException {
        Number number = (Number) getGeneric(map, str, Number.class);
        if (number != null) {
            return number.intValue();
        }
        throw new ParseException("JSON object member with key " + str + " is missing or null", 0);
    }

    public static long getLong(Map<String, Object> map, String str) throws ParseException {
        Number number = (Number) getGeneric(map, str, Number.class);
        if (number != null) {
            return number.longValue();
        }
        throw new ParseException("JSON object member with key " + str + " is missing or null", 0);
    }

    public static float getFloat(Map<String, Object> map, String str) throws ParseException {
        Number number = (Number) getGeneric(map, str, Number.class);
        if (number != null) {
            return number.floatValue();
        }
        throw new ParseException("JSON object member with key " + str + " is missing or null", 0);
    }

    public static double getDouble(Map<String, Object> map, String str) throws ParseException {
        Number number = (Number) getGeneric(map, str, Number.class);
        if (number != null) {
            return number.doubleValue();
        }
        throw new ParseException("JSON object member with key " + str + " is missing or null", 0);
    }

    public static String getString(Map<String, Object> map, String str) throws ParseException {
        return (String) getGeneric(map, str, String.class);
    }

    public static URI getURI(Map<String, Object> map, String str) throws ParseException {
        String string = getString(map, str);
        if (string == null) {
            return null;
        }
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            throw new ParseException(e.getMessage(), 0);
        }
    }

    public static List<Object> getJSONArray(Map<String, Object> map, String str) throws ParseException {
        return (List) getGeneric(map, str, List.class);
    }

    public static String[] getStringArray(Map<String, Object> map, String str) throws ParseException {
        List<Object> jSONArray = getJSONArray(map, str);
        if (jSONArray == null) {
            return null;
        }
        try {
            return (String[]) jSONArray.toArray(new String[0]);
        } catch (ArrayStoreException unused) {
            throw new ParseException("JSON object member with key \"" + str + "\" is not an array of strings", 0);
        }
    }

    public static Map<String, Object>[] getJSONObjectArray(Map<String, Object> map, String str) throws ParseException {
        List<Object> jSONArray = getJSONArray(map, str);
        if (jSONArray == null) {
            return null;
        }
        try {
            return (Map[]) jSONArray.toArray(new HashMap[0]);
        } catch (ArrayStoreException unused) {
            throw new ParseException("JSON object member with key \"" + str + "\" is not an array of JSON objects", 0);
        }
    }

    public static List<String> getStringList(Map<String, Object> map, String str) throws ParseException {
        String[] stringArray = getStringArray(map, str);
        if (stringArray == null) {
            return null;
        }
        return Arrays.asList(stringArray);
    }

    public static Map<String, Object> getJSONObject(Map<String, Object> map, String str) throws ParseException {
        Map<String, Object> map2 = (Map) getGeneric(map, str, Map.class);
        if (map2 == null) {
            return null;
        }
        for (String str2 : map2.keySet()) {
            if (!(str2 instanceof String)) {
                throw new ParseException("JSON object member with key " + str + " not a JSON object", 0);
            }
        }
        return map2;
    }

    public static Base64URL getBase64URL(Map<String, Object> map, String str) throws ParseException {
        String string = getString(map, str);
        if (string == null) {
            return null;
        }
        return new Base64URL(string);
    }

    public static String toJSONString(Map<String, ?> map) {
        return JSONObject.toJSONString((Map<String, ? extends Object>) map);
    }

    public static Map<String, Object> newJSONObject() {
        return new HashMap();
    }

    private JSONObjectUtils() {
    }
}
