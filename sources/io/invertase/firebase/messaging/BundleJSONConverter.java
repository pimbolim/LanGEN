package io.invertase.firebase.messaging;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleJSONConverter {
    private static final Map<Class<?>, Setter> SETTERS;

    public interface Setter {
        void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException;

        void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException;
    }

    static {
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(Boolean.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        hashMap.put(Integer.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putInt(str, ((Integer) obj).intValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        hashMap.put(Long.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putLong(str, ((Long) obj).longValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        hashMap.put(Double.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        hashMap.put(String.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                bundle.putString(str, (String) obj);
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                jSONObject.put(str, obj);
            }
        });
        hashMap.put(String[].class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("Unexpected type from JSON");
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                JSONArray jSONArray = new JSONArray();
                for (String put : (String[]) obj) {
                    jSONArray.put(put);
                }
                jSONObject.put(str, jSONArray);
            }
        });
        hashMap.put(JSONArray.class, new Setter() {
            public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
                JSONArray jSONArray = (JSONArray) obj;
                int i = 0;
                if (jSONArray.length() == 0 || (jSONArray.get(0) instanceof String)) {
                    ArrayList arrayList = new ArrayList();
                    while (i < jSONArray.length()) {
                        arrayList.add((String) jSONArray.get(i));
                        i++;
                    }
                    bundle.putStringArrayList(str, arrayList);
                } else if (jSONArray.get(0) instanceof Integer) {
                    ArrayList arrayList2 = new ArrayList();
                    while (i < jSONArray.length()) {
                        arrayList2.add((Integer) jSONArray.get(i));
                        i++;
                    }
                    bundle.putIntegerArrayList(str, arrayList2);
                } else if (jSONArray.get(0) instanceof Boolean) {
                    boolean[] zArr = new boolean[jSONArray.length()];
                    while (i < jSONArray.length()) {
                        zArr[i] = ((Boolean) jSONArray.get(i)).booleanValue();
                        i++;
                    }
                    bundle.putBooleanArray(str, zArr);
                } else if (jSONArray.get(0) instanceof Double) {
                    double[] dArr = new double[jSONArray.length()];
                    while (i < jSONArray.length()) {
                        dArr[i] = ((Double) jSONArray.get(i)).doubleValue();
                        i++;
                    }
                    bundle.putDoubleArray(str, dArr);
                } else if (jSONArray.get(0) instanceof Long) {
                    long[] jArr = new long[jSONArray.length()];
                    while (i < jSONArray.length()) {
                        jArr[i] = ((Long) jSONArray.get(i)).longValue();
                        i++;
                    }
                    bundle.putLongArray(str, jArr);
                } else if (jSONArray.get(0) instanceof JSONObject) {
                    ArrayList arrayList3 = new ArrayList();
                    while (i < jSONArray.length()) {
                        arrayList3.add(BundleJSONConverter.convertToBundle((JSONObject) jSONArray.get(i)));
                        i++;
                    }
                    bundle.putSerializable(str, arrayList3);
                } else {
                    throw new IllegalArgumentException("Unexpected type in an array: " + jSONArray.get(0).getClass());
                }
            }

            public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
                throw new IllegalArgumentException("JSONArray's are not supported in bundles.");
            }
        });
    }

    public static JSONObject convertToJSON(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof List) {
                    JSONArray jSONArray = new JSONArray();
                    for (Object next : (List) obj) {
                        if ((next instanceof String) || (next instanceof Integer) || (next instanceof Double) || (next instanceof Long) || (next instanceof Boolean)) {
                            jSONArray.put(next);
                        } else if (next instanceof Bundle) {
                            jSONArray.put(convertToJSON((Bundle) next));
                        } else {
                            throw new IllegalArgumentException("Unsupported type: " + next.getClass());
                        }
                    }
                    jSONObject.put(str, jSONArray);
                } else if (obj instanceof Bundle) {
                    jSONObject.put(str, convertToJSON((Bundle) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        setter.setOnJSON(jSONObject, str, obj);
                    } else {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static Bundle convertToBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!(obj == null || obj == JSONObject.NULL)) {
                if (obj instanceof JSONObject) {
                    bundle.putBundle(next, convertToBundle((JSONObject) obj));
                } else {
                    Setter setter = SETTERS.get(obj.getClass());
                    if (setter != null) {
                        setter.setOnBundle(bundle, next, obj);
                    } else {
                        throw new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    }
                }
            }
        }
        return bundle;
    }
}
