package com.nimbusds.jose.shaded.json;

import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

class JStylerObj {
    public static final Escape4Web ESCAPE4Web = new Escape4Web();
    public static final EscapeLT ESCAPE_LT = new EscapeLT();
    public static final MPAgressive MP_AGGRESIVE = new MPAgressive();
    public static final MPSimple MP_SIMPLE = new MPSimple();
    public static final MPTrue MP_TRUE = new MPTrue();

    public interface MustProtect {
        boolean mustBeProtect(String str);
    }

    public interface StringProtector {
        void escape(String str, Appendable appendable);
    }

    public static boolean isSpace(char c) {
        return c == 13 || c == 10 || c == 9 || c == ' ';
    }

    public static boolean isSpecial(char c) {
        return c == '{' || c == '[' || c == ',' || c == '}' || c == ']' || c == ':' || c == '\'' || c == '\"';
    }

    public static boolean isSpecialChar(char c) {
        return c == 8 || c == 12 || c == 10;
    }

    public static boolean isSpecialClose(char c) {
        return c == '}' || c == ']' || c == ',' || c == ':';
    }

    public static boolean isSpecialOpen(char c) {
        return c == '{' || c == '[' || c == ',' || c == ':';
    }

    public static boolean isUnicode(char c) {
        return (c >= 0 && c <= 31) || (c >= 127 && c <= 159) || (c >= 8192 && c <= 8447);
    }

    JStylerObj() {
    }

    private static class MPTrue implements MustProtect {
        public boolean mustBeProtect(String str) {
            return true;
        }

        private MPTrue() {
        }
    }

    private static class MPSimple implements MustProtect {
        private MPSimple() {
        }

        public boolean mustBeProtect(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char charAt = str.charAt(0);
            if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
                return true;
            }
            for (int i = 0; i < length; i++) {
                char charAt2 = str.charAt(i);
                if (JStylerObj.isSpace(charAt2) || JStylerObj.isSpecial(charAt2) || JStylerObj.isSpecialChar(charAt2) || JStylerObj.isUnicode(charAt2)) {
                    return true;
                }
            }
            return JStylerObj.isKeyword(str);
        }
    }

    private static class MPAgressive implements MustProtect {
        private MPAgressive() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0068, code lost:
            if (r3 == '.') goto L_0x006a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x006a, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x006c, code lost:
            if (r7 >= r1) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x006e, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0072, code lost:
            if (r3 < '0') goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0074, code lost:
            if (r3 <= '9') goto L_0x006a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0076, code lost:
            if (r7 != r1) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0078, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x007b, code lost:
            if (r3 == 'E') goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x007f, code lost:
            if (r3 != 'e') goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0081, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0083, code lost:
            if (r7 != r1) goto L_0x0086;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0085, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0086, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x008c, code lost:
            if (r3 == '+') goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x008e, code lost:
            if (r3 != '-') goto L_0x0095;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0090, code lost:
            r7 = r7 + 1;
            r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0095, code lost:
            if (r7 != r1) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0097, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0098, code lost:
            if (r7 >= r1) goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x009a, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x009e, code lost:
            if (r3 < '0') goto L_0x00a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a0, code lost:
            if (r3 <= '9') goto L_0x00a3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00a3, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00a6, code lost:
            if (r7 != r1) goto L_0x00a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00a8, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mustBeProtect(java.lang.String r10) {
            /*
                r9 = this;
                r0 = 0
                if (r10 != 0) goto L_0x0004
                return r0
            L_0x0004:
                int r1 = r10.length()
                r2 = 1
                if (r1 != 0) goto L_0x000c
                return r2
            L_0x000c:
                java.lang.String r3 = r10.trim()
                if (r3 == r10) goto L_0x0013
                return r2
            L_0x0013:
                char r3 = r10.charAt(r0)
                boolean r4 = com.nimbusds.jose.shaded.json.JStylerObj.isSpecial(r3)
                if (r4 != 0) goto L_0x00aa
                boolean r3 = com.nimbusds.jose.shaded.json.JStylerObj.isUnicode(r3)
                if (r3 == 0) goto L_0x0025
                goto L_0x00aa
            L_0x0025:
                r3 = 1
            L_0x0026:
                if (r3 >= r1) goto L_0x003d
                char r4 = r10.charAt(r3)
                boolean r5 = com.nimbusds.jose.shaded.json.JStylerObj.isSpecialClose(r4)
                if (r5 != 0) goto L_0x003c
                boolean r4 = com.nimbusds.jose.shaded.json.JStylerObj.isUnicode(r4)
                if (r4 == 0) goto L_0x0039
                goto L_0x003c
            L_0x0039:
                int r3 = r3 + 1
                goto L_0x0026
            L_0x003c:
                return r2
            L_0x003d:
                boolean r3 = com.nimbusds.jose.shaded.json.JStylerObj.isKeyword(r10)
                if (r3 == 0) goto L_0x0044
                return r2
            L_0x0044:
                char r3 = r10.charAt(r0)
                r4 = 45
                r5 = 57
                r6 = 48
                if (r3 < r6) goto L_0x0052
                if (r3 <= r5) goto L_0x0054
            L_0x0052:
                if (r3 != r4) goto L_0x00a9
            L_0x0054:
                r7 = 1
            L_0x0055:
                if (r7 >= r1) goto L_0x0063
                char r3 = r10.charAt(r7)
                if (r3 < r6) goto L_0x0063
                if (r3 <= r5) goto L_0x0060
                goto L_0x0063
            L_0x0060:
                int r7 = r7 + 1
                goto L_0x0055
            L_0x0063:
                if (r7 != r1) goto L_0x0066
                return r2
            L_0x0066:
                r8 = 46
                if (r3 != r8) goto L_0x006c
            L_0x006a:
                int r7 = r7 + 1
            L_0x006c:
                if (r7 >= r1) goto L_0x0076
                char r3 = r10.charAt(r7)
                if (r3 < r6) goto L_0x0076
                if (r3 <= r5) goto L_0x006a
            L_0x0076:
                if (r7 != r1) goto L_0x0079
                return r2
            L_0x0079:
                r8 = 69
                if (r3 == r8) goto L_0x0081
                r8 = 101(0x65, float:1.42E-43)
                if (r3 != r8) goto L_0x0095
            L_0x0081:
                int r7 = r7 + 1
                if (r7 != r1) goto L_0x0086
                return r0
            L_0x0086:
                char r3 = r10.charAt(r7)
                r8 = 43
                if (r3 == r8) goto L_0x0090
                if (r3 != r4) goto L_0x0095
            L_0x0090:
                int r7 = r7 + 1
                r10.charAt(r7)
            L_0x0095:
                if (r7 != r1) goto L_0x0098
                return r0
            L_0x0098:
                if (r7 >= r1) goto L_0x00a6
                char r3 = r10.charAt(r7)
                if (r3 < r6) goto L_0x00a6
                if (r3 <= r5) goto L_0x00a3
                goto L_0x00a6
            L_0x00a3:
                int r7 = r7 + 1
                goto L_0x0098
            L_0x00a6:
                if (r7 != r1) goto L_0x00a9
                return r2
            L_0x00a9:
                return r0
            L_0x00aa:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.shaded.json.JStylerObj.MPAgressive.mustBeProtect(java.lang.String):boolean");
        }
    }

    public static boolean isKeyword(String str) {
        if (str.length() < 3) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt == 'n') {
            return str.equals(AbstractJsonLexerKt.NULL);
        }
        if (charAt == 't') {
            return str.equals("true");
        }
        if (charAt == 'f') {
            return str.equals("false");
        }
        if (charAt == 'N') {
            return str.equals("NaN");
        }
        return false;
    }

    private static class EscapeLT implements StringProtector {
        private EscapeLT() {
        }

        public void escape(String str, Appendable appendable) {
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == 12) {
                        appendable.append("\\f");
                    } else if (charAt == 13) {
                        appendable.append("\\r");
                    } else if (charAt == '\"') {
                        appendable.append("\\\"");
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case 8:
                                appendable.append("\\b");
                                break;
                            case 9:
                                appendable.append("\\t");
                                break;
                            case 10:
                                appendable.append("\\n");
                                break;
                            default:
                                if ((charAt >= 0 && charAt <= 31) || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 12) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 8) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 4) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 0) & 15));
                                    break;
                                } else {
                                    appendable.append(charAt);
                                    break;
                                }
                        }
                    } else {
                        appendable.append("\\\\");
                    }
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Exception");
            }
        }
    }

    private static class Escape4Web implements StringProtector {
        private Escape4Web() {
        }

        public void escape(String str, Appendable appendable) {
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == 12) {
                        appendable.append("\\f");
                    } else if (charAt == 13) {
                        appendable.append("\\r");
                    } else if (charAt == '\"') {
                        appendable.append("\\\"");
                    } else if (charAt == '/') {
                        appendable.append("\\/");
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case 8:
                                appendable.append("\\b");
                                break;
                            case 9:
                                appendable.append("\\t");
                                break;
                            case 10:
                                appendable.append("\\n");
                                break;
                            default:
                                if ((charAt >= 0 && charAt <= 31) || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 12) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 8) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 4) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 0) & 15));
                                    break;
                                } else {
                                    appendable.append(charAt);
                                    break;
                                }
                                break;
                        }
                    } else {
                        appendable.append("\\\\");
                    }
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Error");
            }
        }
    }
}
