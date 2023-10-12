package io.invertase.firebase;

public class ErrorUtils {
    public static String getMessageWithService(String str, String str2, String str3) {
        return str2 + ": " + str + " (" + str3.toLowerCase() + ").";
    }

    public static String getCodeWithService(String str, String str2) {
        return str.toLowerCase() + "/" + str2.toLowerCase();
    }
}
