package net.time4j.calendar;

import androidx.webkit.ProxyConfig;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Locale;
import java.util.Map;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.NumberSystem;
import net.time4j.format.internal.DualFormatHelper;

public final class EastAsianMonth implements Comparable<EastAsianMonth>, Serializable {
    private static final EastAsianMonth[] CACHE;
    public static final AttributeKey<Character> LEAP_MONTH_INDICATOR = Attributes.createKey("LEAP_MONTH_INDICATOR", Character.class);
    public static final AttributeKey<Boolean> LEAP_MONTH_IS_TRAILING = Attributes.createKey("LEAP_MONTH_IS_TRAILING", Boolean.class);
    private static final long serialVersionUID = 7544059597266533279L;
    private final int index;
    private final boolean leap;

    static {
        EastAsianMonth[] eastAsianMonthArr = new EastAsianMonth[24];
        for (int i = 0; i < 12; i++) {
            eastAsianMonthArr[i] = new EastAsianMonth(i, false);
            eastAsianMonthArr[i + 12] = new EastAsianMonth(i, true);
        }
        CACHE = eastAsianMonthArr;
    }

    private EastAsianMonth(int i, boolean z) {
        this.index = i;
        this.leap = z;
    }

    public static EastAsianMonth valueOf(int i) {
        if (i >= 1 && i <= 12) {
            return CACHE[i - 1];
        }
        throw new IllegalArgumentException("Out of range: " + i);
    }

    public int getNumber() {
        return this.index + 1;
    }

    public boolean isLeap() {
        return this.leap;
    }

    public EastAsianMonth withLeap() {
        return CACHE[this.index + 12];
    }

    public String getOldJapaneseName(Locale locale) {
        Map<String, String> textForms = CalendarText.getInstance("japanese", locale).getTextForms();
        return textForms.get(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT + getNumber());
    }

    public String getDisplayName(Locale locale, NumberSystem numberSystem) {
        String displayName = getDisplayName(locale, numberSystem, Attributes.empty());
        String language = locale.getLanguage();
        if (language.equals("zh")) {
            return displayName + "月";
        } else if (language.equals("ko")) {
            return displayName + "월";
        } else if (!language.equals("ja")) {
            return displayName;
        } else {
            return displayName + "月";
        }
    }

    public int compareTo(EastAsianMonth eastAsianMonth) {
        int i = this.index;
        int i2 = eastAsianMonth.index;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        if (this.leap) {
            return eastAsianMonth.leap ^ true ? 1 : 0;
        }
        if (eastAsianMonth.leap) {
            return -1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EastAsianMonth)) {
            return false;
        }
        EastAsianMonth eastAsianMonth = (EastAsianMonth) obj;
        if (this.index == eastAsianMonth.index && this.leap == eastAsianMonth.leap) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.index + (this.leap ? 12 : 0);
    }

    public String toString() {
        String valueOf = String.valueOf(this.index + 1);
        if (!this.leap) {
            return valueOf;
        }
        return ProxyConfig.MATCH_ALL_SCHEMES + valueOf;
    }

    /* access modifiers changed from: package-private */
    public String getDisplayName(Locale locale, NumberSystem numberSystem, AttributeQuery attributeQuery) {
        StringBuilder sb;
        Map<String, String> textForms = CalendarText.getInstance("generic", locale).getTextForms();
        String numeral = DualFormatHelper.toNumeral(numberSystem, ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, Character.valueOf(numberSystem.getDigits().charAt(0)))).charValue(), getNumber());
        if (!this.leap) {
            return numeral;
        }
        boolean booleanValue = ((Boolean) attributeQuery.get(LEAP_MONTH_IS_TRAILING, Boolean.valueOf("R".equals(textForms.get("leap-alignment"))))).booleanValue();
        char charValue = ((Character) attributeQuery.get(LEAP_MONTH_INDICATOR, Character.valueOf(textForms.get("leap-indicator").charAt(0)))).charValue();
        if (booleanValue) {
            sb.append(numeral);
            sb.append(charValue);
        } else {
            sb = new StringBuilder();
            sb.append(charValue);
            sb.append(numeral);
        }
        return sb.toString();
    }

    private Object readResolve() throws ObjectStreamException {
        try {
            return CACHE[this.index + (this.leap ? 12 : 0)];
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new StreamCorruptedException();
        }
    }
}
