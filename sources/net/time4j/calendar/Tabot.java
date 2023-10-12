package net.time4j.calendar;

import java.io.IOException;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.time4j.calendar.service.GenericTextProviderSPI;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.format.Attributes;
import net.time4j.format.TextElement;
import net.time4j.i18n.PropertyBundle;

public final class Tabot implements Comparable<Tabot> {
    private static final String[] AMHARIC;
    private static final Tabot[] INSTANCES;
    private static final String[] TRANSSCRIPTION;
    private final int index;

    static {
        new GenericTextProviderSPI();
        PropertyBundle bundle = getBundle(Locale.ROOT);
        PropertyBundle bundle2 = getBundle(new Locale("am"));
        String[] strArr = new String[30];
        String[] strArr2 = new String[30];
        Tabot[] tabotArr = new Tabot[30];
        int i = 0;
        while (i < 30) {
            StringBuilder sb = new StringBuilder();
            sb.append("T_");
            int i2 = i + 1;
            sb.append(String.valueOf(i2));
            String sb2 = sb.toString();
            strArr[i] = bundle.getString(sb2);
            strArr2[i] = bundle2.getString(sb2);
            tabotArr[i] = new Tabot(i2);
            i = i2;
        }
        TRANSSCRIPTION = strArr;
        AMHARIC = strArr2;
        INSTANCES = tabotArr;
    }

    private Tabot(int i) {
        this.index = i;
    }

    public static List<Tabot> asList() {
        return Collections.unmodifiableList(Arrays.asList(INSTANCES));
    }

    public static Tabot of(int i) {
        if (i >= 1 && i <= 30) {
            return INSTANCES[i - 1];
        }
        throw new IllegalArgumentException("Out of range 1-30: " + i);
    }

    public int getDayOfMonth() {
        return this.index;
    }

    public String getDisplayName(Locale locale) {
        if (locale.getLanguage().equals("am")) {
            return AMHARIC[this.index - 1];
        }
        return TRANSSCRIPTION[this.index - 1];
    }

    public int compareTo(Tabot tabot) {
        return this.index - tabot.index;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tabot) || this.index != ((Tabot) obj).index) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Integer.valueOf(this.index).hashCode();
    }

    public String toString() {
        return "Tabot of day-of-month " + this.index;
    }

    private static PropertyBundle getBundle(Locale locale) {
        return PropertyBundle.load("calendar/names/ethiopic/ethiopic", locale);
    }

    enum Element implements TextElement<Tabot> {
        TABOT;

        public char getSymbol() {
            return 0;
        }

        public boolean isDateElement() {
            return true;
        }

        public boolean isLenient() {
            return false;
        }

        public boolean isTimeElement() {
            return false;
        }

        public Class<Tabot> getType() {
            return Tabot.class;
        }

        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            Element element = TABOT;
            return ((Tabot) chronoDisplay.get(element)).getDayOfMonth() - ((Tabot) chronoDisplay2.get(element)).getDayOfMonth();
        }

        public Tabot getDefaultMinimum() {
            return Tabot.of(1);
        }

        public Tabot getDefaultMaximum() {
            return Tabot.of(30);
        }

        public String getDisplayName(Locale locale) {
            return name();
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
            appendable.append(((Tabot) chronoDisplay.get(TABOT)).getDisplayName((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)));
        }

        public Tabot parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
            int index = parsePosition.getIndex();
            int i = 1;
            while (i <= 30) {
                String displayName = Tabot.of(i).getDisplayName(locale);
                int length = displayName.length() + index;
                if (length > charSequence.length() || !displayName.equals(charSequence.subSequence(index, length).toString())) {
                    i++;
                } else {
                    parsePosition.setIndex(length);
                    return Tabot.of(i);
                }
            }
            return null;
        }
    }
}
