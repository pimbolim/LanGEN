package com.nimbusds.jose.shaded.asm;

import com.nimbusds.jose.jwk.JWKParameterNames;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;

public class ConvertDate {
    static TreeMap<String, Integer> daysTable = new TreeMap<>(new StringCmpNS());
    public static TimeZone defaultTimeZone;
    static TreeMap<String, Integer> monthsTable = new TreeMap<>(new StringCmpNS());
    static TreeMap<String, TimeZone> timeZoneMapping = new TreeMap<>();
    private static HashSet<String> voidData = new HashSet<>();

    static {
        voidData.add("à");
        voidData.add("at");
        voidData.add("MEZ");
        voidData.add("Uhr");
        voidData.add("h");
        voidData.add("pm");
        voidData.add("PM");
        voidData.add("am");
        voidData.add("AM");
        voidData.add("min");
        voidData.add("um");
        voidData.add("o'clock");
        for (String str : TimeZone.getAvailableIDs()) {
            timeZoneMapping.put(str, TimeZone.getTimeZone(str));
        }
        for (Locale locale : DateFormatSymbols.getAvailableLocales()) {
            if (!"ja".equals(locale.getLanguage()) && !"ko".equals(locale.getLanguage()) && !"zh".equals(locale.getLanguage())) {
                DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
                String[] months = instance.getMonths();
                for (int i = 0; i < months.length; i++) {
                    if (months[i].length() != 0) {
                        fillMap(monthsTable, months[i], Integer.valueOf(i));
                    }
                }
                String[] shortMonths = instance.getShortMonths();
                for (int i2 = 0; i2 < shortMonths.length; i2++) {
                    String str2 = shortMonths[i2];
                    if (str2.length() != 0 && !Character.isDigit(str2.charAt(str2.length() - 1))) {
                        fillMap(monthsTable, shortMonths[i2], Integer.valueOf(i2));
                        fillMap(monthsTable, shortMonths[i2].replace(".", ""), Integer.valueOf(i2));
                    }
                }
                String[] weekdays = instance.getWeekdays();
                for (int i3 = 0; i3 < weekdays.length; i3++) {
                    String str3 = weekdays[i3];
                    if (str3.length() != 0) {
                        fillMap(daysTable, str3, Integer.valueOf(i3));
                        fillMap(daysTable, str3.replace(".", ""), Integer.valueOf(i3));
                    }
                }
                String[] shortWeekdays = instance.getShortWeekdays();
                for (int i4 = 0; i4 < shortWeekdays.length; i4++) {
                    String str4 = shortWeekdays[i4];
                    if (str4.length() != 0) {
                        fillMap(daysTable, str4, Integer.valueOf(i4));
                        fillMap(daysTable, str4.replace(".", ""), Integer.valueOf(i4));
                    }
                }
            }
        }
    }

    public static class StringCmpNS implements Comparator<String> {
        public int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    public static Integer getMonth(String str) {
        return monthsTable.get(str);
    }

    private static Integer parseMonth(String str) {
        if (Character.isDigit(str.charAt(0))) {
            return Integer.valueOf(Integer.parseInt(str) - 1);
        }
        Integer num = monthsTable.get(str);
        if (num != null) {
            return Integer.valueOf(num.intValue());
        }
        throw new NullPointerException("can not parse " + str + " as month");
    }

    private static GregorianCalendar newCalandar() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
        TimeZone timeZone = defaultTimeZone;
        if (timeZone != null) {
            gregorianCalendar.setTimeZone(timeZone);
        }
        TimeZone timeZone2 = gregorianCalendar.getTimeZone();
        if (timeZone2 == null) {
            timeZone2 = TimeZone.getDefault();
        }
        gregorianCalendar.setTimeInMillis((long) (-timeZone2.getRawOffset()));
        return gregorianCalendar;
    }

    private static void fillMap(TreeMap<String, Integer> treeMap, String str, Integer num) {
        treeMap.put(str, num);
        treeMap.put(str.replace("é", JWKParameterNames.RSA_EXPONENT).replace("û", "u"), num);
    }

    public static Date convertToDate(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            StringTokenizer stringTokenizer = new StringTokenizer(((String) obj).replace("p.m.", "pm").replace("a.m.", "am"), " -/:,.+年月日曜時分秒");
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() == 4 && Character.isDigit(nextToken.charAt(0))) {
                return getYYYYMMDD(stringTokenizer, nextToken);
            }
            if (daysTable.containsKey(nextToken)) {
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                nextToken = stringTokenizer.nextToken();
            }
            if (monthsTable.containsKey(nextToken)) {
                return getMMDDYYYY(stringTokenizer, nextToken);
            }
            if (Character.isDigit(nextToken.charAt(0))) {
                return getDDMMYYYY(stringTokenizer, nextToken);
            }
            return null;
        }
        throw new RuntimeException("Primitive: Can not convert " + obj.getClass().getName() + " to int");
    }

    private static Date getYYYYMMDD(StringTokenizer stringTokenizer, String str) {
        GregorianCalendar newCalandar = newCalandar();
        newCalandar.set(1, Integer.parseInt(str));
        if (!stringTokenizer.hasMoreTokens()) {
            return newCalandar.getTime();
        }
        newCalandar.set(2, parseMonth(stringTokenizer.nextToken()).intValue());
        if (!stringTokenizer.hasMoreTokens()) {
            return newCalandar.getTime();
        }
        String nextToken = stringTokenizer.nextToken();
        if (!Character.isDigit(nextToken.charAt(0))) {
            return newCalandar.getTime();
        }
        if (nextToken.length() == 5 && nextToken.charAt(2) == 'T') {
            newCalandar.set(5, Integer.parseInt(nextToken.substring(0, 2)));
            return addHour(stringTokenizer, newCalandar, nextToken.substring(3));
        }
        newCalandar.set(5, Integer.parseInt(nextToken));
        return addHour(stringTokenizer, newCalandar, (String) null);
    }

    private static int getYear(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt < 100) {
            return parseInt > 30 ? parseInt + 2000 : parseInt + 1900;
        }
        return parseInt;
    }

    private static Date getMMDDYYYY(StringTokenizer stringTokenizer, String str) {
        GregorianCalendar newCalandar = newCalandar();
        Integer num = monthsTable.get(str);
        if (num != null) {
            newCalandar.set(2, num.intValue());
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            newCalandar.set(5, Integer.parseInt(stringTokenizer.nextToken()));
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            String nextToken = stringTokenizer.nextToken();
            if (Character.isLetter(nextToken.charAt(0))) {
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                nextToken = stringTokenizer.nextToken();
            }
            if (nextToken.length() == 4) {
                newCalandar.set(1, getYear(nextToken));
            } else if (nextToken.length() == 2) {
                return addHour2(stringTokenizer, newCalandar, nextToken);
            }
            return addHour(stringTokenizer, newCalandar, (String) null);
        }
        throw new NullPointerException("can not parse " + str + " as month");
    }

    private static Date getDDMMYYYY(StringTokenizer stringTokenizer, String str) {
        GregorianCalendar newCalandar = newCalandar();
        newCalandar.set(5, Integer.parseInt(str));
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        newCalandar.set(2, parseMonth(stringTokenizer.nextToken()).intValue());
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        newCalandar.set(1, getYear(stringTokenizer.nextToken()));
        return addHour(stringTokenizer, newCalandar, (String) null);
    }

    private static Date addHour(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        if (str == null) {
            if (!stringTokenizer.hasMoreTokens()) {
                return calendar.getTime();
            }
            str = stringTokenizer.nextToken();
        }
        return addHour2(stringTokenizer, calendar, str);
    }

    private static Date addHour2(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        calendar.set(11, Integer.parseInt(trySkip(stringTokenizer, str, calendar)));
        if (!stringTokenizer.hasMoreTokens()) {
            return calendar.getTime();
        }
        String trySkip = trySkip(stringTokenizer, stringTokenizer.nextToken(), calendar);
        if (trySkip == null) {
            return calendar.getTime();
        }
        calendar.set(12, Integer.parseInt(trySkip));
        if (!stringTokenizer.hasMoreTokens()) {
            return calendar.getTime();
        }
        String trySkip2 = trySkip(stringTokenizer, stringTokenizer.nextToken(), calendar);
        if (trySkip2 == null) {
            return calendar.getTime();
        }
        calendar.set(13, Integer.parseInt(trySkip2));
        if (!stringTokenizer.hasMoreTokens()) {
            return calendar.getTime();
        }
        String trySkip3 = trySkip(stringTokenizer, stringTokenizer.nextToken(), calendar);
        if (trySkip3 == null) {
            return calendar.getTime();
        }
        String trySkip4 = trySkip(stringTokenizer, trySkip3, calendar);
        if (trySkip4.length() == 4 && Character.isDigit(trySkip4.charAt(0))) {
            calendar.set(1, getYear(trySkip4));
        }
        return calendar.getTime();
    }

    private static String trySkip(StringTokenizer stringTokenizer, String str, Calendar calendar) {
        while (true) {
            TimeZone timeZone = timeZoneMapping.get(str);
            if (timeZone != null) {
                calendar.setTimeZone(timeZone);
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                str = stringTokenizer.nextToken();
            } else if (!voidData.contains(str)) {
                return str;
            } else {
                if (str.equalsIgnoreCase("pm")) {
                    calendar.add(9, 1);
                }
                if (str.equalsIgnoreCase("am")) {
                    calendar.add(9, 0);
                }
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
                str = stringTokenizer.nextToken();
            }
        }
    }
}
