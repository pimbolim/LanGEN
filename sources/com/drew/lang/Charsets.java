package com.drew.lang;

import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

public final class Charsets {
    public static final Charset ASCII = Charset.forName(CharEncoding.US_ASCII);
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_16 = Charset.forName(CharEncoding.UTF_16);
    public static final Charset UTF_16BE = Charset.forName(CharEncoding.UTF_16BE);
    public static final Charset UTF_16LE = Charset.forName(CharEncoding.UTF_16LE);
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Charset WINDOWS_1252 = Charset.forName("Cp1252");
}
