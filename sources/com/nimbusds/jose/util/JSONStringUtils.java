package com.nimbusds.jose.util;

import com.nimbusds.jose.shaded.json.JSONObject;

public class JSONStringUtils {
    public static String toJSONString(String str) {
        return "\"" + JSONObject.escape(str) + "\"";
    }

    private JSONStringUtils() {
    }
}
