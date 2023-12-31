package com.nimbusds.jose.shaded.json.parser;

import com.nimbusds.jose.shaded.json.JSONValue;
import com.nimbusds.jose.shaded.json.writer.JsonReaderI;

class JSONParserString extends JSONParserMemory {
    private String in;

    public JSONParserString(int i) {
        super(i);
    }

    public Object parse(String str) throws ParseException {
        return parse(str, JSONValue.defaultReader.DEFAULT);
    }

    public <T> T parse(String str, JsonReaderI<T> jsonReaderI) throws ParseException {
        this.base = jsonReaderI.base;
        this.in = str;
        this.len = str.length();
        return parse(jsonReaderI);
    }

    /* access modifiers changed from: protected */
    public void extractString(int i, int i2) {
        this.xs = this.in.substring(i, i2);
    }

    /* access modifiers changed from: protected */
    public void extractStringTrim(int i, int i2) {
        while (i < i2 - 1 && Character.isWhitespace(this.in.charAt(i))) {
            i++;
        }
        while (true) {
            int i3 = i2 - 1;
            if (i3 <= i || !Character.isWhitespace(this.in.charAt(i3))) {
                extractString(i, i2);
            } else {
                i2--;
            }
        }
        extractString(i, i2);
    }

    /* access modifiers changed from: protected */
    public int indexOf(char c, int i) {
        return this.in.indexOf(c, i);
    }

    /* access modifiers changed from: protected */
    public void read() {
        int i = this.pos + 1;
        this.pos = i;
        if (i >= this.len) {
            this.c = 26;
        } else {
            this.c = this.in.charAt(this.pos);
        }
    }

    /* access modifiers changed from: protected */
    public void readS() {
        int i = this.pos + 1;
        this.pos = i;
        if (i >= this.len) {
            this.c = 26;
        } else {
            this.c = this.in.charAt(this.pos);
        }
    }

    /* access modifiers changed from: protected */
    public void readNoEnd() throws ParseException {
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.len) {
            this.c = this.in.charAt(this.pos);
        } else {
            this.c = 26;
            throw new ParseException(this.pos - 1, 3, "EOF");
        }
    }
}
