package com.nimbusds.jose.shaded.json.parser;

import com.nimbusds.jose.shaded.json.JSONValue;
import com.nimbusds.jose.shaded.json.writer.JsonReaderI;
import java.nio.charset.StandardCharsets;

class JSONParserByteArray extends JSONParserMemory {
    private byte[] in;

    public JSONParserByteArray(int i) {
        super(i);
    }

    public Object parse(byte[] bArr) throws ParseException {
        return parse(bArr, JSONValue.defaultReader.DEFAULT);
    }

    public <T> T parse(byte[] bArr, JsonReaderI<T> jsonReaderI) throws ParseException {
        this.base = jsonReaderI.base;
        this.in = bArr;
        this.len = bArr.length;
        return parse(jsonReaderI);
    }

    /* access modifiers changed from: protected */
    public void extractString(int i, int i2) {
        this.xs = new String(this.in, i, i2 - i, StandardCharsets.UTF_8);
    }

    /* access modifiers changed from: protected */
    public void extractStringTrim(int i, int i2) {
        byte[] bArr = this.in;
        while (i < i2 && bArr[i] <= 32) {
            i++;
        }
        while (i < i2 && bArr[i2 - 1] <= 32) {
            i2--;
        }
        this.xs = new String(this.in, i, i2 - i, StandardCharsets.UTF_8);
    }

    /* access modifiers changed from: protected */
    public int indexOf(char c, int i) {
        while (i < this.len) {
            if (this.in[i] == ((byte) c)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void read() {
        int i = this.pos + 1;
        this.pos = i;
        if (i >= this.len) {
            this.c = 26;
        } else {
            this.c = (char) this.in[this.pos];
        }
    }

    /* access modifiers changed from: protected */
    public void readS() {
        int i = this.pos + 1;
        this.pos = i;
        if (i >= this.len) {
            this.c = 26;
        } else {
            this.c = (char) this.in[this.pos];
        }
    }

    /* access modifiers changed from: protected */
    public void readNoEnd() throws ParseException {
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.len) {
            this.c = (char) this.in[this.pos];
        } else {
            this.c = 26;
            throw new ParseException(this.pos - 1, 3, "EOF");
        }
    }
}
