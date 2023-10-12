package net.time4j.i18n;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.Weekday;
import net.time4j.base.ResourceLoader;
import net.time4j.format.WeekdataProvider;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;

public class WeekdataProviderSPI implements WeekdataProvider {
    private final Set<String> countriesWithMinDays4;
    private final Map<String, Weekday> endOfWeekend;
    private final Map<String, Weekday> firstDayOfWeek;
    private final String source;
    private final Map<String, Weekday> startOfWeekend;

    public WeekdataProviderSPI() {
        HashMap hashMap;
        Weekday weekday;
        String str;
        Class<WeekdataProviderSPI> cls = WeekdataProviderSPI.class;
        URI locate = ResourceLoader.getInstance().locate("i18n", cls, "data/week.data");
        InputStream load = ResourceLoader.getInstance().load(locate, true);
        if (load == null) {
            try {
                load = ResourceLoader.getInstance().load(cls, "data/week.data", true);
            } catch (IOException unused) {
            }
        }
        if (load != null) {
            this.source = "@" + locate;
            HashSet hashSet = new HashSet();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(load, CharEncoding.US_ASCII));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        this.countriesWithMinDays4 = Collections.unmodifiableSet(hashSet);
                        this.firstDayOfWeek = Collections.unmodifiableMap(hashMap2);
                        this.startOfWeekend = Collections.unmodifiableMap(hashMap3);
                        this.endOfWeekend = Collections.unmodifiableMap(hashMap4);
                        try {
                            load.close();
                            return;
                        } catch (IOException e) {
                            e.printStackTrace(System.err);
                            return;
                        }
                    } else if (!readLine.startsWith("#")) {
                        int indexOf = readLine.indexOf(61);
                        int i = 0;
                        String trim = readLine.substring(0, indexOf).trim();
                        String[] split = readLine.substring(indexOf + 1).split(StringUtils.SPACE);
                        if (trim.equals("minDays-4")) {
                            int length = split.length;
                            while (i < length) {
                                String upperCase = split[i].trim().toUpperCase(Locale.US);
                                if (!upperCase.isEmpty()) {
                                    hashSet.add(upperCase);
                                }
                                i++;
                            }
                        } else {
                            if (trim.startsWith("start-")) {
                                str = trim.substring(6);
                                weekday = Weekday.SATURDAY;
                                hashMap = hashMap3;
                            } else if (trim.startsWith("end-")) {
                                str = trim.substring(4);
                                weekday = Weekday.SUNDAY;
                                hashMap = hashMap4;
                            } else if (trim.startsWith("first-")) {
                                str = trim.substring(6);
                                weekday = Weekday.MONDAY;
                                hashMap = hashMap2;
                            } else {
                                throw new IllegalStateException("Unexpected format: " + this.source);
                            }
                            if (str.equals("sun")) {
                                weekday = Weekday.SUNDAY;
                            } else if (str.equals("sat")) {
                                weekday = Weekday.SATURDAY;
                            } else if (str.equals("fri")) {
                                weekday = Weekday.FRIDAY;
                            } else if (str.equals("thu")) {
                                weekday = Weekday.THURSDAY;
                            } else if (str.equals("wed")) {
                                weekday = Weekday.WEDNESDAY;
                            } else if (str.equals("tue")) {
                                weekday = Weekday.TUESDAY;
                            } else if (str.equals("mon")) {
                                weekday = Weekday.MONDAY;
                            }
                            int length2 = split.length;
                            while (i < length2) {
                                String upperCase2 = split[i].trim().toUpperCase(Locale.US);
                                if (!upperCase2.isEmpty()) {
                                    hashMap.put(upperCase2, weekday);
                                }
                                i++;
                            }
                        }
                    }
                }
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            } catch (Exception e3) {
                throw new IllegalStateException("Unexpected format: " + this.source, e3);
            } catch (Throwable th) {
                try {
                    load.close();
                } catch (IOException e4) {
                    e4.printStackTrace(System.err);
                }
                throw th;
            }
        } else {
            this.source = "@STATIC";
            this.countriesWithMinDays4 = Collections.emptySet();
            this.firstDayOfWeek = Collections.emptyMap();
            this.startOfWeekend = Collections.emptyMap();
            this.endOfWeekend = Collections.emptyMap();
            PrintStream printStream = System.err;
            printStream.println("Warning: File \"" + "data/week.data" + "\" not found.");
        }
    }

    public int getFirstDayOfWeek(Locale locale) {
        if (this.firstDayOfWeek.isEmpty()) {
            int firstDayOfWeek2 = new GregorianCalendar(locale).getFirstDayOfWeek();
            if (firstDayOfWeek2 == 1) {
                return 7;
            }
            return firstDayOfWeek2 - 1;
        }
        String country = locale.getCountry();
        Weekday weekday = Weekday.MONDAY;
        if (this.firstDayOfWeek.containsKey(country)) {
            weekday = this.firstDayOfWeek.get(country);
        }
        return weekday.getValue();
    }

    public int getMinimalDaysInFirstWeek(Locale locale) {
        if (this.countriesWithMinDays4.isEmpty()) {
            return new GregorianCalendar(locale).getMinimalDaysInFirstWeek();
        }
        String country = locale.getCountry();
        if ((!country.isEmpty() || !locale.getLanguage().isEmpty()) && !this.countriesWithMinDays4.contains(country)) {
            return 1;
        }
        return 4;
    }

    public int getStartOfWeekend(Locale locale) {
        String country = locale.getCountry();
        Weekday weekday = Weekday.SATURDAY;
        if (this.startOfWeekend.containsKey(country)) {
            weekday = this.startOfWeekend.get(country);
        }
        return weekday.getValue();
    }

    public int getEndOfWeekend(Locale locale) {
        String country = locale.getCountry();
        Weekday weekday = Weekday.SUNDAY;
        if (this.endOfWeekend.containsKey(country)) {
            weekday = this.endOfWeekend.get(country);
        }
        return weekday.getValue();
    }

    public String toString() {
        return getClass().getName() + this.source;
    }
}
