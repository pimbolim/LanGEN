package com.nimbusds.jose.shaded.json.parser;

import com.nimbusds.jose.shaded.json.writer.JsonReader;
import com.nimbusds.jose.shaded.json.writer.JsonReaderI;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.CharUtils;

abstract class JSONParserBase {
    public static final byte EOI = 26;
    protected static final char MAX_STOP = '~';
    protected static boolean[] stopAll;
    protected static boolean[] stopArray;
    protected static boolean[] stopKey;
    protected static boolean[] stopValue;
    protected static boolean[] stopX;
    protected final boolean acceptLeadinZero;
    protected final boolean acceptNaN;
    protected final boolean acceptNonQuote;
    protected final boolean acceptSimpleQuote;
    protected final boolean acceptUselessComma;
    JsonReader base;
    protected char c;
    protected final boolean checkTaillingData;
    protected final boolean checkTaillingSpace;
    protected final boolean ignoreControlChar;
    private String lastKey;
    protected int pos;
    protected final boolean reject127;
    protected final MSB sb = new MSB(15);
    protected final boolean unrestictBigDigit;
    protected final boolean useHiPrecisionFloat;
    protected final boolean useIntegerStorage;
    protected Object xo;
    protected String xs;

    /* access modifiers changed from: protected */
    public abstract void read() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void readNQString(boolean[] zArr) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void readNoEnd() throws ParseException, IOException;

    /* access modifiers changed from: protected */
    public abstract Object readNumber(boolean[] zArr) throws ParseException, IOException;

    /* access modifiers changed from: package-private */
    public abstract void readS() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void readString() throws ParseException, IOException;

    static {
        boolean[] zArr = new boolean[126];
        stopAll = zArr;
        boolean[] zArr2 = new boolean[126];
        stopArray = zArr2;
        boolean[] zArr3 = new boolean[126];
        stopKey = zArr3;
        boolean[] zArr4 = new boolean[126];
        stopValue = zArr4;
        boolean[] zArr5 = new boolean[126];
        stopX = zArr5;
        zArr3[26] = true;
        zArr3[58] = true;
        zArr4[26] = true;
        zArr4[125] = true;
        zArr4[44] = true;
        zArr2[26] = true;
        zArr2[93] = true;
        zArr2[44] = true;
        zArr5[26] = true;
        zArr[58] = true;
        zArr[44] = true;
        zArr[26] = true;
        zArr[125] = true;
        zArr[93] = true;
    }

    public JSONParserBase(int i) {
        boolean z = false;
        this.acceptNaN = (i & 4) > 0;
        this.acceptNonQuote = (i & 2) > 0;
        this.acceptSimpleQuote = (i & 1) > 0;
        this.ignoreControlChar = (i & 8) > 0;
        this.useIntegerStorage = (i & 16) > 0;
        this.acceptLeadinZero = (i & 32) > 0;
        this.acceptUselessComma = (i & 64) > 0;
        this.useHiPrecisionFloat = (i & 128) > 0;
        this.checkTaillingData = (i & 768) != 768;
        this.checkTaillingSpace = (i & 512) == 0;
        this.reject127 = (i & 1024) > 0;
        this.unrestictBigDigit = (i & 2048) > 0 ? true : z;
    }

    public void checkControleChar() throws ParseException {
        if (!this.ignoreControlChar) {
            int length = this.xs.length();
            for (int i = 0; i < length; i++) {
                char charAt = this.xs.charAt(i);
                if (charAt >= 0) {
                    if (charAt <= 31) {
                        throw new ParseException(this.pos + i, 0, Character.valueOf(charAt));
                    } else if (charAt == 127 && this.reject127) {
                        throw new ParseException(this.pos + i, 0, Character.valueOf(charAt));
                    }
                }
            }
        }
    }

    public void checkLeadinZero() throws ParseException {
        int length = this.xs.length();
        if (length != 1) {
            if (length != 2) {
                char charAt = this.xs.charAt(0);
                char charAt2 = this.xs.charAt(1);
                if (charAt == '-') {
                    char charAt3 = this.xs.charAt(2);
                    if (charAt2 == '0' && charAt3 >= '0' && charAt3 <= '9') {
                        throw new ParseException(this.pos, 6, this.xs);
                    }
                } else if (charAt == '0' && charAt2 >= '0' && charAt2 <= '9') {
                    throw new ParseException(this.pos, 6, this.xs);
                }
            } else if (this.xs.equals("00")) {
                throw new ParseException(this.pos, 6, this.xs);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Number extractFloat() throws ParseException {
        if (!this.acceptLeadinZero) {
            checkLeadinZero();
        }
        try {
            if (!this.useHiPrecisionFloat) {
                return Float.valueOf(Float.parseFloat(this.xs));
            }
            if (this.xs.length() <= 18) {
                return Double.valueOf(Double.parseDouble(this.xs));
            }
            BigDecimal bigDecimal = new BigDecimal(this.xs);
            if (this.unrestictBigDigit) {
                return bigDecimal;
            }
            double parseDouble = Double.parseDouble(this.xs);
            return String.valueOf(parseDouble).equals(this.xs) ? Double.valueOf(parseDouble) : bigDecimal;
        } catch (NumberFormatException unused) {
            throw new ParseException(this.pos, 1, this.xs);
        }
    }

    /* access modifiers changed from: protected */
    public <T> T parse(JsonReaderI<T> jsonReaderI) throws ParseException {
        this.pos = -1;
        try {
            read();
            T readFirst = readFirst(jsonReaderI);
            if (this.checkTaillingData) {
                if (!this.checkTaillingSpace) {
                    skipSpace();
                }
                if (this.c != 26) {
                    throw new ParseException(this.pos - 1, 1, Character.valueOf(this.c));
                }
            }
            this.xs = null;
            this.xo = null;
            return readFirst;
        } catch (IOException e) {
            throw new ParseException(this.pos, e);
        }
    }

    /* access modifiers changed from: protected */
    public Number parseNumber(String str) throws ParseException {
        boolean z;
        int i;
        int i2;
        boolean z2;
        int length = str.length();
        boolean z3 = false;
        if (str.charAt(0) == '-') {
            i2 = 20;
            if (this.acceptLeadinZero || length < 3 || str.charAt(1) != '0') {
                i = 1;
                z = true;
            } else {
                throw new ParseException(this.pos, 6, str);
            }
        } else if (this.acceptLeadinZero || length < 2 || str.charAt(0) != '0') {
            i2 = 19;
            i = 0;
            z = false;
        } else {
            throw new ParseException(this.pos, 6, str);
        }
        if (length < i2) {
            z2 = false;
        } else if (length > i2) {
            return new BigInteger(str, 10);
        } else {
            length--;
            z2 = true;
        }
        long j = 0;
        while (i < length) {
            j = (j * 10) + ((long) ('0' - str.charAt(i)));
            i++;
        }
        if (z2) {
            int i3 = (j > -922337203685477580L ? 1 : (j == -922337203685477580L ? 0 : -1));
            if (i3 <= 0 && (i3 < 0 || (!z ? str.charAt(i) > '7' : str.charAt(i) > '8'))) {
                z3 = true;
            }
            if (z3) {
                return new BigInteger(str, 10);
            }
            j = (j * 10) + ((long) ('0' - str.charAt(i)));
        }
        if (!z) {
            long j2 = -j;
            if (!this.useIntegerStorage || j2 > 2147483647L) {
                return Long.valueOf(j2);
            }
            return Integer.valueOf((int) j2);
        } else if (!this.useIntegerStorage || j < -2147483648L) {
            return Long.valueOf(j);
        } else {
            return Integer.valueOf((int) j);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        if (r5 == ':') goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        if (r5 == ']') goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        if (r5 == '}') goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (r4 == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005b, code lost:
        if (r7.acceptUselessComma == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        throw new com.nimbusds.jose.shaded.json.parser.ParseException(r7.pos, 0, java.lang.Character.valueOf(r7.c));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006c, code lost:
        read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0073, code lost:
        return r8.convert(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T readArray(com.nimbusds.jose.shaded.json.writer.JsonReaderI<T> r8) throws com.nimbusds.jose.shaded.json.parser.ParseException, java.io.IOException {
        /*
            r7 = this;
            java.lang.Object r0 = r8.createArray()
            char r1 = r7.c
            r2 = 91
            if (r1 != r2) goto L_0x00ad
            r7.read()
            char r1 = r7.c
            r2 = 44
            r3 = 0
            if (r1 != r2) goto L_0x0027
            boolean r1 = r7.acceptUselessComma
            if (r1 == 0) goto L_0x0019
            goto L_0x0027
        L_0x0019:
            com.nimbusds.jose.shaded.json.parser.ParseException r8 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r7.pos
            char r1 = r7.c
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0027:
            r1 = 1
        L_0x0028:
            r4 = 0
        L_0x0029:
            char r5 = r7.c
            r6 = 9
            if (r5 == r6) goto L_0x00a8
            r6 = 10
            if (r5 == r6) goto L_0x00a8
            r6 = 13
            if (r5 == r6) goto L_0x00a8
            r6 = 26
            if (r5 == r6) goto L_0x009c
            r6 = 32
            if (r5 == r6) goto L_0x00a8
            if (r5 == r2) goto L_0x0082
            r6 = 58
            if (r5 == r6) goto L_0x0074
            r6 = 93
            if (r5 == r6) goto L_0x0057
            r4 = 125(0x7d, float:1.75E-43)
            if (r5 == r4) goto L_0x0074
            boolean[] r4 = stopArray
            java.lang.Object r4 = r7.readMain(r8, r4)
            r8.addValue(r0, r4)
            goto L_0x0028
        L_0x0057:
            if (r4 == 0) goto L_0x006c
            boolean r1 = r7.acceptUselessComma
            if (r1 == 0) goto L_0x005e
            goto L_0x006c
        L_0x005e:
            com.nimbusds.jose.shaded.json.parser.ParseException r8 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r7.pos
            char r1 = r7.c
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x006c:
            r7.read()
            java.lang.Object r8 = r8.convert(r0)
            return r8
        L_0x0074:
            com.nimbusds.jose.shaded.json.parser.ParseException r8 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r7.pos
            char r1 = r7.c
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0082:
            if (r4 == 0) goto L_0x0097
            boolean r4 = r7.acceptUselessComma
            if (r4 == 0) goto L_0x0089
            goto L_0x0097
        L_0x0089:
            com.nimbusds.jose.shaded.json.parser.ParseException r8 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r7.pos
            char r1 = r7.c
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r8.<init>(r0, r3, r1)
            throw r8
        L_0x0097:
            r7.read()
            r4 = 1
            goto L_0x0029
        L_0x009c:
            com.nimbusds.jose.shaded.json.parser.ParseException r8 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r7.pos
            int r0 = r0 - r1
            r1 = 3
            java.lang.String r2 = "EOF"
            r8.<init>(r0, r1, r2)
            throw r8
        L_0x00a8:
            r7.read()
            goto L_0x0029
        L_0x00ad:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "Internal Error"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.shaded.json.parser.JSONParserBase.readArray(com.nimbusds.jose.shaded.json.writer.JsonReaderI):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ba, code lost:
        throw new com.nimbusds.jose.shaded.json.parser.ParseException(r3.pos, 0, java.lang.Character.valueOf(r3.c));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T readFirst(com.nimbusds.jose.shaded.json.writer.JsonReaderI<T> r4) throws com.nimbusds.jose.shaded.json.parser.ParseException, java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            char r0 = r3.c
            r1 = 9
            if (r0 == r1) goto L_0x0114
            r1 = 10
            if (r0 == r1) goto L_0x0114
            r1 = 1
            switch(r0) {
                case 13: goto L_0x0114;
                case 32: goto L_0x0114;
                case 34: goto L_0x010a;
                case 39: goto L_0x010a;
                case 45: goto L_0x00fd;
                case 78: goto L_0x00c0;
                case 91: goto L_0x00bb;
                case 93: goto L_0x00ac;
                case 102: goto L_0x0081;
                case 110: goto L_0x005b;
                case 116: goto L_0x0030;
                case 123: goto L_0x002b;
                case 125: goto L_0x00ac;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r0) {
                case 48: goto L_0x00fd;
                case 49: goto L_0x00fd;
                case 50: goto L_0x00fd;
                case 51: goto L_0x00fd;
                case 52: goto L_0x00fd;
                case 53: goto L_0x00fd;
                case 54: goto L_0x00fd;
                case 55: goto L_0x00fd;
                case 56: goto L_0x00fd;
                case 57: goto L_0x00fd;
                case 58: goto L_0x00ac;
                default: goto L_0x0011;
            }
        L_0x0011:
            boolean[] r0 = stopX
            r3.readNQString(r0)
            boolean r0 = r3.acceptNonQuote
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0021:
            com.nimbusds.jose.shaded.json.parser.ParseException r4 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x002b:
            java.lang.Object r4 = r3.readObject(r4)
            return r4
        L_0x0030:
            boolean[] r0 = stopX
            r3.readNQString(r0)
            java.lang.String r0 = r3.xs
            java.lang.String r2 = "true"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0046
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0046:
            boolean r0 = r3.acceptNonQuote
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0051:
            com.nimbusds.jose.shaded.json.parser.ParseException r4 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x005b:
            boolean[] r0 = stopX
            r3.readNQString(r0)
            java.lang.String r0 = r3.xs
            java.lang.String r2 = "null"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x006c
            r4 = 0
            return r4
        L_0x006c:
            boolean r0 = r3.acceptNonQuote
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0077:
            com.nimbusds.jose.shaded.json.parser.ParseException r4 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x0081:
            boolean[] r0 = stopX
            r3.readNQString(r0)
            java.lang.String r0 = r3.xs
            java.lang.String r2 = "false"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0097
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0097:
            boolean r0 = r3.acceptNonQuote
            if (r0 == 0) goto L_0x00a2
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x00a2:
            com.nimbusds.jose.shaded.json.parser.ParseException r4 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00ac:
            com.nimbusds.jose.shaded.json.parser.ParseException r4 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r3.pos
            r1 = 0
            char r2 = r3.c
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00bb:
            java.lang.Object r4 = r3.readArray(r4)
            return r4
        L_0x00c0:
            boolean[] r0 = stopX
            r3.readNQString(r0)
            boolean r0 = r3.acceptNaN
            if (r0 == 0) goto L_0x00f3
            java.lang.String r0 = r3.xs
            java.lang.String r2 = "NaN"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00de
            r0 = 2143289344(0x7fc00000, float:NaN)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x00de:
            boolean r0 = r3.acceptNonQuote
            if (r0 == 0) goto L_0x00e9
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x00e9:
            com.nimbusds.jose.shaded.json.parser.ParseException r4 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00f3:
            com.nimbusds.jose.shaded.json.parser.ParseException r4 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r0 = r3.pos
            java.lang.String r2 = r3.xs
            r4.<init>(r0, r1, r2)
            throw r4
        L_0x00fd:
            boolean[] r0 = stopX
            java.lang.Object r0 = r3.readNumber(r0)
            r3.xo = r0
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x010a:
            r3.readString()
            java.lang.String r0 = r3.xs
            java.lang.Object r4 = r4.convert(r0)
            return r4
        L_0x0114:
            r3.read()
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.shaded.json.parser.JSONParserBase.readFirst(com.nimbusds.jose.shaded.json.writer.JsonReaderI):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a0, code lost:
        throw new com.nimbusds.jose.shaded.json.parser.ParseException(r2.pos, 0, java.lang.Character.valueOf(r2.c));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object readMain(com.nimbusds.jose.shaded.json.writer.JsonReaderI<?> r3, boolean[] r4) throws com.nimbusds.jose.shaded.json.parser.ParseException, java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            char r0 = r2.c
            r1 = 9
            if (r0 == r1) goto L_0x00ea
            r1 = 10
            if (r0 == r1) goto L_0x00ea
            r1 = 1
            switch(r0) {
                case 13: goto L_0x00ea;
                case 32: goto L_0x00ea;
                case 34: goto L_0x00e4;
                case 39: goto L_0x00e4;
                case 45: goto L_0x00df;
                case 78: goto L_0x00ac;
                case 91: goto L_0x00a1;
                case 93: goto L_0x0092;
                case 102: goto L_0x0071;
                case 110: goto L_0x0051;
                case 116: goto L_0x0030;
                case 123: goto L_0x0025;
                case 125: goto L_0x0092;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r0) {
                case 48: goto L_0x00df;
                case 49: goto L_0x00df;
                case 50: goto L_0x00df;
                case 51: goto L_0x00df;
                case 52: goto L_0x00df;
                case 53: goto L_0x00df;
                case 54: goto L_0x00df;
                case 55: goto L_0x00df;
                case 56: goto L_0x00df;
                case 57: goto L_0x00df;
                case 58: goto L_0x0092;
                default: goto L_0x0011;
            }
        L_0x0011:
            r2.readNQString(r4)
            boolean r3 = r2.acceptNonQuote
            if (r3 == 0) goto L_0x001b
            java.lang.String r3 = r2.xs
            return r3
        L_0x001b:
            com.nimbusds.jose.shaded.json.parser.ParseException r3 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x0025:
            java.lang.String r4 = r2.lastKey
            com.nimbusds.jose.shaded.json.writer.JsonReaderI r3 = r3.startObject(r4)
            java.lang.Object r3 = r2.readObject(r3)
            return r3
        L_0x0030:
            r2.readNQString(r4)
            java.lang.String r3 = r2.xs
            java.lang.String r4 = "true"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0040
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            return r3
        L_0x0040:
            boolean r3 = r2.acceptNonQuote
            if (r3 == 0) goto L_0x0047
            java.lang.String r3 = r2.xs
            return r3
        L_0x0047:
            com.nimbusds.jose.shaded.json.parser.ParseException r3 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x0051:
            r2.readNQString(r4)
            java.lang.String r3 = r2.xs
            java.lang.String r4 = "null"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0060
            r3 = 0
            return r3
        L_0x0060:
            boolean r3 = r2.acceptNonQuote
            if (r3 == 0) goto L_0x0067
            java.lang.String r3 = r2.xs
            return r3
        L_0x0067:
            com.nimbusds.jose.shaded.json.parser.ParseException r3 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x0071:
            r2.readNQString(r4)
            java.lang.String r3 = r2.xs
            java.lang.String r4 = "false"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0081
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            return r3
        L_0x0081:
            boolean r3 = r2.acceptNonQuote
            if (r3 == 0) goto L_0x0088
            java.lang.String r3 = r2.xs
            return r3
        L_0x0088:
            com.nimbusds.jose.shaded.json.parser.ParseException r3 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x0092:
            com.nimbusds.jose.shaded.json.parser.ParseException r3 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r4 = r2.pos
            r0 = 0
            char r1 = r2.c
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r3.<init>(r4, r0, r1)
            throw r3
        L_0x00a1:
            java.lang.String r4 = r2.lastKey
            com.nimbusds.jose.shaded.json.writer.JsonReaderI r3 = r3.startArray(r4)
            java.lang.Object r3 = r2.readArray(r3)
            return r3
        L_0x00ac:
            r2.readNQString(r4)
            boolean r3 = r2.acceptNaN
            if (r3 == 0) goto L_0x00d5
            java.lang.String r3 = r2.xs
            java.lang.String r4 = "NaN"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x00c4
            r3 = 2143289344(0x7fc00000, float:NaN)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            return r3
        L_0x00c4:
            boolean r3 = r2.acceptNonQuote
            if (r3 == 0) goto L_0x00cb
            java.lang.String r3 = r2.xs
            return r3
        L_0x00cb:
            com.nimbusds.jose.shaded.json.parser.ParseException r3 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x00d5:
            com.nimbusds.jose.shaded.json.parser.ParseException r3 = new com.nimbusds.jose.shaded.json.parser.ParseException
            int r4 = r2.pos
            java.lang.String r0 = r2.xs
            r3.<init>(r4, r1, r0)
            throw r3
        L_0x00df:
            java.lang.Object r3 = r2.readNumber(r4)
            return r3
        L_0x00e4:
            r2.readString()
            java.lang.String r3 = r2.xs
            return r3
        L_0x00ea:
            r2.read()
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.shaded.json.parser.JSONParserBase.readMain(com.nimbusds.jose.shaded.json.writer.JsonReaderI, boolean[]):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public <T> T readObject(JsonReaderI<T> jsonReaderI) throws ParseException, IOException {
        if (this.c == '{') {
            Object createObject = jsonReaderI.createObject();
            boolean z = false;
            while (true) {
                read();
                char c2 = this.c;
                if (!(c2 == 9 || c2 == 10 || c2 == 13 || c2 == ' ')) {
                    if (c2 != ',') {
                        if (c2 != ':' && c2 != '[' && c2 != ']' && c2 != '{') {
                            if (c2 != '}') {
                                if (c2 == '\"' || c2 == '\'') {
                                    readString();
                                } else {
                                    readNQString(stopKey);
                                    if (!this.acceptNonQuote) {
                                        throw new ParseException(this.pos, 1, this.xs);
                                    }
                                }
                                String str = this.xs;
                                skipSpace();
                                char c3 = this.c;
                                if (c3 == ':') {
                                    readNoEnd();
                                    this.lastKey = str;
                                    jsonReaderI.setValue(createObject, str, readMain(jsonReaderI, stopValue));
                                    this.lastKey = null;
                                    skipSpace();
                                    char c4 = this.c;
                                    if (c4 == '}') {
                                        read();
                                        return jsonReaderI.convert(createObject);
                                    } else if (c4 == 26) {
                                        throw new ParseException(this.pos - 1, 3, (Object) null);
                                    } else if (c4 != ',') {
                                        throw new ParseException(this.pos - 1, 1, Character.valueOf(this.c));
                                    }
                                } else if (c3 == 26) {
                                    throw new ParseException(this.pos - 1, 3, (Object) null);
                                } else {
                                    throw new ParseException(this.pos - 1, 0, Character.valueOf(this.c));
                                }
                            } else if (!z || this.acceptUselessComma) {
                                read();
                                return jsonReaderI.convert(createObject);
                            } else {
                                throw new ParseException(this.pos, 0, Character.valueOf(this.c));
                            }
                        }
                    } else if (z && !this.acceptUselessComma) {
                        throw new ParseException(this.pos, 0, Character.valueOf(this.c));
                    }
                    z = true;
                }
            }
            throw new ParseException(this.pos, 0, Character.valueOf(this.c));
        }
        throw new RuntimeException("Internal Error");
    }

    /* access modifiers changed from: protected */
    public void readString2() throws ParseException, IOException {
        char c2 = this.c;
        while (true) {
            read();
            char c3 = this.c;
            if (c3 == '\"' || c3 == '\'') {
                if (c2 == c3) {
                    read();
                    this.xs = this.sb.toString();
                    return;
                }
                this.sb.append(c3);
            } else if (c3 != '\\') {
                if (c3 != 127) {
                    switch (c3) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                            if (this.ignoreControlChar) {
                                continue;
                            } else {
                                throw new ParseException(this.pos, 0, Character.valueOf(this.c));
                            }
                        case 26:
                            throw new ParseException(this.pos - 1, 3, (Object) null);
                    }
                } else if (this.ignoreControlChar) {
                    continue;
                } else if (this.reject127) {
                    throw new ParseException(this.pos, 0, Character.valueOf(this.c));
                }
                this.sb.append(c3);
            } else {
                read();
                char c4 = this.c;
                if (c4 == '\"') {
                    this.sb.append('\"');
                } else if (c4 == '\'') {
                    this.sb.append('\'');
                } else if (c4 == '/') {
                    this.sb.append('/');
                } else if (c4 == '\\') {
                    this.sb.append((char) AbstractJsonLexerKt.STRING_ESC);
                } else if (c4 == 'b') {
                    this.sb.append(8);
                } else if (c4 == 'f') {
                    this.sb.append(12);
                } else if (c4 == 'n') {
                    this.sb.append(10);
                } else if (c4 == 'r') {
                    this.sb.append((char) CharUtils.CR);
                } else if (c4 == 'x') {
                    this.sb.append(readUnicode(2));
                } else if (c4 == 't') {
                    this.sb.append(9);
                } else if (c4 == 'u') {
                    this.sb.append(readUnicode(4));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public char readUnicode(int i) throws ParseException, IOException {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 * 16;
            read();
            char c2 = this.c;
            if (c2 > '9' || c2 < '0') {
                if (c2 <= 'F' && c2 >= 'A') {
                    i2 = c2 - 'A';
                } else if (c2 >= 'a' && c2 <= 'f') {
                    i2 = c2 - 'a';
                } else if (c2 == 26) {
                    throw new ParseException(this.pos, 3, "EOF");
                } else {
                    throw new ParseException(this.pos, 4, Character.valueOf(this.c));
                }
                i3 = i2 + 10;
            } else {
                i3 = c2 - '0';
            }
            i4 = i6 + i3;
        }
        return (char) i4;
    }

    /* access modifiers changed from: protected */
    public void skipDigits() throws IOException {
        while (true) {
            char c2 = this.c;
            if (c2 >= '0' && c2 <= '9') {
                readS();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void skipNQString(boolean[] zArr) throws IOException {
        while (true) {
            char c2 = this.c;
            if (c2 == 26) {
                return;
            }
            if (c2 < 0 || c2 >= '~' || !zArr[c2]) {
                readS();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void skipSpace() throws IOException {
        while (true) {
            char c2 = this.c;
            if (c2 <= ' ' && c2 != 26) {
                readS();
            } else {
                return;
            }
        }
    }

    public static class MSB {
        char[] b;
        int p = -1;

        public MSB(int i) {
            this.b = new char[i];
        }

        public void append(char c) {
            int i = this.p + 1;
            this.p = i;
            char[] cArr = this.b;
            if (cArr.length <= i) {
                char[] cArr2 = new char[((cArr.length * 2) + 1)];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.b = cArr2;
            }
            this.b[this.p] = c;
        }

        public void append(int i) {
            int i2 = this.p + 1;
            this.p = i2;
            char[] cArr = this.b;
            if (cArr.length <= i2) {
                char[] cArr2 = new char[((cArr.length * 2) + 1)];
                System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                this.b = cArr2;
            }
            this.b[this.p] = (char) i;
        }

        public String toString() {
            return new String(this.b, 0, this.p + 1);
        }

        public void clear() {
            this.p = -1;
        }
    }
}
