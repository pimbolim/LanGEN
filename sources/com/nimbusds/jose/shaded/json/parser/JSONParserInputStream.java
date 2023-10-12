package com.nimbusds.jose.shaded.json.parser;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.nimbusds.jose.shaded.json.writer.JsonReaderI;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

class JSONParserInputStream extends JSONParserReader {
    public JSONParserInputStream(int i) {
        super(i);
    }

    public Object parse(InputStream inputStream) throws ParseException, UnsupportedEncodingException {
        return super.parse(new InputStreamReader(inputStream, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8));
    }

    public <T> T parse(InputStream inputStream, JsonReaderI<T> jsonReaderI) throws ParseException, UnsupportedEncodingException {
        return super.parse(new InputStreamReader(inputStream, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8), jsonReaderI);
    }
}
