package net.time4j.format;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public interface NumberSymbolProvider {
    public static final NumberSymbolProvider DEFAULT = new NumberSymbolProvider() {
        public Locale[] getAvailableLocales() {
            return DecimalFormatSymbols.getAvailableLocales();
        }

        public char getZeroDigit(Locale locale) {
            return getSymbols(locale).getZeroDigit();
        }

        public char getDecimalSeparator(Locale locale) {
            return getSymbols(locale).getDecimalSeparator();
        }

        public String getPlusSign(Locale locale) {
            if (locale.getLanguage().equals("ar")) {
                return "‏+";
            }
            return String.valueOf(SignatureVisitor.EXTENDS);
        }

        public String getMinusSign(Locale locale) {
            if (locale.getLanguage().equals("ar")) {
                return "‏-";
            }
            return String.valueOf(getSymbols(locale).getMinusSign());
        }

        public NumberSystem getDefaultNumberSystem(Locale locale) {
            return NumberSystem.ARABIC;
        }

        private DecimalFormatSymbols getSymbols(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    };

    Locale[] getAvailableLocales();

    char getDecimalSeparator(Locale locale);

    NumberSystem getDefaultNumberSystem(Locale locale);

    String getMinusSign(Locale locale);

    String getPlusSign(Locale locale);

    char getZeroDigit(Locale locale);
}
