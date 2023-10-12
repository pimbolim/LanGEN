package net.time4j.i18n;

import com.facebook.react.uimanager.ViewProps;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.util.Locale;
import java.util.MissingResourceException;
import net.time4j.Weekday;
import net.time4j.format.PluralCategory;
import net.time4j.format.RelativeTimeProvider;
import net.time4j.format.TextWidth;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public final class UnitPatternProviderSPI implements RelativeTimeProvider {
    public String getYearPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
        return getUnitPattern(locale, 'Y', textWidth, pluralCategory);
    }

    public String getMonthPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
        return getUnitPattern(locale, 'M', textWidth, pluralCategory);
    }

    public String getWeekPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
        return getUnitPattern(locale, 'W', textWidth, pluralCategory);
    }

    public String getDayPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
        return getUnitPattern(locale, 'D', textWidth, pluralCategory);
    }

    public String getHourPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
        return getUnitPattern(locale, 'H', textWidth, pluralCategory);
    }

    public String getMinutePattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
        return getUnitPattern(locale, 'N', textWidth, pluralCategory);
    }

    public String getSecondPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
        return getUnitPattern(locale, 'S', textWidth, pluralCategory);
    }

    public String getMilliPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
        return getUnitPattern(locale, '3', textWidth, pluralCategory);
    }

    public String getMicroPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
        return getUnitPattern(locale, '6', textWidth, pluralCategory);
    }

    public String getNanoPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
        return getUnitPattern(locale, '9', textWidth, pluralCategory);
    }

    public String getYearPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'Y', z, pluralCategory);
    }

    public String getMonthPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'M', z, pluralCategory);
    }

    public String getWeekPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'W', z, pluralCategory);
    }

    public String getDayPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'D', z, pluralCategory);
    }

    public String getHourPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'H', z, pluralCategory);
    }

    public String getMinutePattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'N', z, pluralCategory);
    }

    public String getSecondPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'S', z, pluralCategory);
    }

    public String getNowWord(Locale locale) {
        return getPattern(locale, "reltime/relpattern", "now", (String) null, PluralCategory.OTHER);
    }

    public String getShortYearPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'y', z, pluralCategory);
    }

    public String getShortMonthPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'm', z, pluralCategory);
    }

    public String getShortWeekPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'w', z, pluralCategory);
    }

    public String getShortDayPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'd', z, pluralCategory);
    }

    public String getShortHourPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'h', z, pluralCategory);
    }

    public String getShortMinutePattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 'n', z, pluralCategory);
    }

    public String getShortSecondPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
        return getRelativePattern(locale, 's', z, pluralCategory);
    }

    public String getYesterdayWord(Locale locale) {
        return getPattern(locale, "reltime/relpattern", "yesterday", (String) null, PluralCategory.OTHER);
    }

    public String getTodayWord(Locale locale) {
        return getPattern(locale, "reltime/relpattern", "today", (String) null, PluralCategory.OTHER);
    }

    public String getTomorrowWord(Locale locale) {
        return getPattern(locale, "reltime/relpattern", "tomorrow", (String) null, PluralCategory.OTHER);
    }

    public String labelForLast(Weekday weekday, Locale locale) {
        return getLabel(locale, weekday.name().substring(0, 3).toLowerCase() + "-");
    }

    public String labelForNext(Weekday weekday, Locale locale) {
        return getLabel(locale, weekday.name().substring(0, 3).toLowerCase() + "+");
    }

    public String getListPattern(Locale locale, TextWidth textWidth, int i) {
        int i2;
        if (i >= 2) {
            PropertyBundle load = PropertyBundle.load("i18n/units/upattern", locale);
            String buildListKey = buildListKey(textWidth, String.valueOf(i));
            if (load.containsKey(buildListKey)) {
                return load.getString(buildListKey);
            }
            String string = load.getString(buildListKey(textWidth, ViewProps.END));
            if (i == 2) {
                return string;
            }
            String string2 = load.getString(buildListKey(textWidth, ViewProps.START));
            String string3 = load.getString(buildListKey(textWidth, "middle"));
            String replace = replace(replace(string, '1', i - 1), '0', i - 2);
            int i3 = i - 3;
            String str = replace;
            while (i3 >= 0) {
                String str2 = i3 == 0 ? string2 : string3;
                int length = str2.length();
                int i4 = length - 1;
                while (true) {
                    if (i4 < 0) {
                        i2 = -1;
                        break;
                    }
                    if (i4 >= 2 && str2.charAt(i4) == '}' && str2.charAt(i4 - 1) == '1') {
                        i2 = i4 - 2;
                        if (str2.charAt(i2) == '{') {
                            break;
                        }
                    }
                    i4--;
                }
                if (i2 > -1) {
                    replace = str2.substring(0, i2) + str;
                    if (i2 < length - 3) {
                        replace = replace + str2.substring(i2 + 3);
                    }
                }
                if (i3 > 0) {
                    str = replace(replace, '0', i3);
                }
                i3--;
            }
            return replace;
        }
        throw new IllegalArgumentException("Size must be greater than 1.");
    }

    private String getUnitPattern(Locale locale, char c, TextWidth textWidth, PluralCategory pluralCategory) {
        return getPattern(locale, "units/upattern", buildKey(c, textWidth, pluralCategory), buildKey(c, textWidth, PluralCategory.OTHER), pluralCategory);
    }

    private String getRelativePattern(Locale locale, char c, boolean z, PluralCategory pluralCategory) {
        return getPattern(locale, "reltime/relpattern", buildKey(c, z, pluralCategory), buildKey(c, z, PluralCategory.OTHER), pluralCategory);
    }

    private String getPattern(Locale locale, String str, String str2, String str3, PluralCategory pluralCategory) {
        PropertyBundle propertyBundle;
        boolean z = true;
        PropertyBundle propertyBundle2 = null;
        for (Locale next : PropertyBundle.getCandidateLocales(locale)) {
            if (!z || propertyBundle2 == null) {
                propertyBundle = PropertyBundle.load("i18n/" + str, next);
            } else {
                propertyBundle = propertyBundle2;
            }
            if (z) {
                if (next.equals(propertyBundle.getLocale())) {
                    z = false;
                } else {
                    propertyBundle2 = propertyBundle;
                }
            }
            if (propertyBundle.getInternalKeys().contains(str2)) {
                return propertyBundle.getString(str2);
            }
            if (pluralCategory != PluralCategory.OTHER && propertyBundle.getInternalKeys().contains(str3)) {
                return propertyBundle.getString(str3);
            }
        }
        throw new MissingResourceException("Can't find resource for bundle " + str + ".properties, key " + str2, str + ".properties", str2);
    }

    private String getLabel(Locale locale, String str) {
        PropertyBundle propertyBundle;
        boolean z = true;
        PropertyBundle propertyBundle2 = null;
        for (Locale next : PropertyBundle.getCandidateLocales(locale)) {
            if (!z || propertyBundle2 == null) {
                propertyBundle = PropertyBundle.load("i18n/reltime/relpattern", next);
            } else {
                propertyBundle = propertyBundle2;
            }
            if (z) {
                if (next.equals(propertyBundle.getLocale())) {
                    z = false;
                } else {
                    propertyBundle2 = propertyBundle;
                }
            }
            if (propertyBundle.getInternalKeys().contains(str)) {
                return propertyBundle.getString(str);
            }
        }
        return "";
    }

    private static String buildKey(char c, TextWidth textWidth, PluralCategory pluralCategory) {
        StringBuilder sb = new StringBuilder(3);
        sb.append(c);
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
        if (i == 1) {
            sb.append('w');
        } else if (i == 2 || i == 3) {
            sb.append('s');
        } else if (i == 4) {
            sb.append('n');
        } else {
            throw new UnsupportedOperationException(textWidth.name());
        }
        sb.append(pluralCategory.ordinal());
        return sb.toString();
    }

    /* renamed from: net.time4j.i18n.UnitPatternProviderSPI$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$TextWidth;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.time4j.format.TextWidth[] r0 = net.time4j.format.TextWidth.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$TextWidth = r0
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.WIDE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.ABBREVIATED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.SHORT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.NARROW     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.i18n.UnitPatternProviderSPI.AnonymousClass1.<clinit>():void");
        }
    }

    private static String buildKey(char c, boolean z, PluralCategory pluralCategory) {
        StringBuilder sb = new StringBuilder(3);
        sb.append(c);
        sb.append(z ? SignatureVisitor.EXTENDS : SignatureVisitor.SUPER);
        sb.append(pluralCategory.ordinal());
        return sb.toString();
    }

    private static String buildListKey(TextWidth textWidth, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Matrix.MATRIX_TYPE_RANDOM_LT);
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
        if (i == 1) {
            sb.append('w');
        } else if (i == 2 || i == 3) {
            sb.append('s');
        } else if (i == 4) {
            sb.append('n');
        } else {
            throw new UnsupportedOperationException(textWidth.name());
        }
        sb.append(SignatureVisitor.SUPER);
        sb.append(str);
        return sb.toString();
    }

    private static String replace(String str, char c, int i) {
        int length = str.length() - 2;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == '{') {
                int i3 = i2 + 1;
                if (str.charAt(i3) == c) {
                    int i4 = i2 + 2;
                    if (str.charAt(i4) == '}') {
                        StringBuilder sb = new StringBuilder(length + 10);
                        sb.append(str);
                        sb.replace(i3, i4, String.valueOf(i));
                        return sb.toString();
                    }
                } else {
                    continue;
                }
            }
        }
        return str;
    }
}
