package com.nimbusds.jose.shaded.json.parser;

import com.nimbusds.jose.shaded.json.JSONValue;
import com.nimbusds.jose.shaded.json.writer.JsonReaderI;
import java.io.IOException;
import java.io.Reader;

class JSONParserReader extends JSONParserStream {
    private Reader in;

    public JSONParserReader(int i) {
        super(i);
    }

    public Object parse(Reader reader) throws ParseException {
        return parse(reader, JSONValue.defaultReader.DEFAULT);
    }

    public <T> T parse(Reader reader, JsonReaderI<T> jsonReaderI) throws ParseException {
        this.base = jsonReaderI.base;
        this.in = reader;
        return super.parse(jsonReaderI);
    }

    /* access modifiers changed from: protected */
    public void read() throws IOException {
        int read = this.in.read();
        this.c = read == -1 ? 26 : (char) read;
        this.pos++;
    }

    /* access modifiers changed from: protected */
    public void readS() throws IOException {
        this.sb.append(this.c);
        int read = this.in.read();
        if (read == -1) {
            this.c = 26;
            return;
        }
        this.c = (char) read;
        this.pos++;
    }

    /* access modifiers changed from: protected */
    public void readNoEnd() throws ParseException, IOException {
        int read = this.in.read();
        if (read != -1) {
            this.c = (char) read;
            return;
        }
        throw new ParseException(this.pos - 1, 3, "EOF");
    }
}
