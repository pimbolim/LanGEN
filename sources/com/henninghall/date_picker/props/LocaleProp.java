package com.henninghall.date_picker.props;

import android.os.Build;
import com.facebook.react.bridge.Dynamic;
import com.henninghall.date_picker.LocaleUtils;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.util.Locale;

public class LocaleProp extends Prop<Locale> {
    public static final String name = "locale";
    private String languageTag = getDefaultLanguageTag();

    public LocaleProp() {
        super(getDefaultLocale());
    }

    private static Locale getDefaultLocale() {
        return LocaleUtils.getLocale(getDefaultLanguageTag());
    }

    private static String getDefaultLanguageTag() {
        return Build.VERSION.SDK_INT >= 21 ? Locale.getDefault().toLanguageTag().replace(SignatureVisitor.SUPER, '_') : "en";
    }

    public String getLanguageTag() {
        return this.languageTag;
    }

    public Locale toValue(Dynamic dynamic) {
        String replace = dynamic.asString().replace(SignatureVisitor.SUPER, '_');
        this.languageTag = replace;
        return LocaleUtils.getLocale(replace);
    }
}
