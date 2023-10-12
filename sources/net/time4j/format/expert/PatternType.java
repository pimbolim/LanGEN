package net.time4j.format.expert;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.AdjustableElement;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.Weekmodel;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.BridgeChronology;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.Chronology;
import net.time4j.engine.EpochDays;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayMode;
import net.time4j.format.NumberSystem;
import net.time4j.format.OutputContext;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.format.expert.ChronoFormatter;
import net.time4j.format.internal.DualFormatElement;
import net.time4j.history.ChronoHistory;

public enum PatternType {
    CLDR,
    SIMPLE_DATE_FORMAT,
    CLDR_24,
    CLDR_DATE,
    DYNAMIC;

    private static int capitalized(int i) {
        return (i < 65 || i > 90) ? (i + 65) - 97 : i;
    }

    private static <T> T cast(Object obj) {
        return obj;
    }

    private static boolean isGeneralSymbol(char c) {
        if (c == 'L' || c == 'M' || c == 'U' || c == 'W' || c == 'g' || c == 'r' || c == 'w' || c == 'y') {
            return true;
        }
        switch (c) {
            case 'D':
            case 'E':
            case 'F':
            case 'G':
                return true;
            default:
                switch (c) {
                    case 'c':
                    case 'd':
                    case 'e':
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* access modifiers changed from: package-private */
    public Map<ChronoElement<?>, ChronoElement<?>> registerSymbol(ChronoFormatter.Builder<?> builder, Locale locale, char c, int i) {
        Chronology<?> effectiveChronology = getEffectiveChronology(builder);
        int i2 = AnonymousClass1.$SwitchMap$net$time4j$format$expert$PatternType[ordinal()];
        if (i2 == 1) {
            return cldr(builder, locale, c, i);
        }
        if (i2 == 2) {
            return sdf(builder, effectiveChronology, locale, c, i);
        }
        if (i2 == 3) {
            return cldr24(builder, locale, c, i);
        }
        if (i2 == 4) {
            Class<?> chronoType = effectiveChronology.getChronoType();
            if (Calendrical.class.isAssignableFrom(chronoType) || CalendarVariant.class.isAssignableFrom(chronoType)) {
                return general(builder, effectiveChronology, c, i, locale);
            }
            throw new IllegalArgumentException("No calendar chronology.");
        } else if (i2 == 5) {
            return dynamic(builder, c, i, locale);
        } else {
            throw new UnsupportedOperationException(name());
        }
    }

    /* renamed from: net.time4j.format.expert.PatternType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$expert$PatternType = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                net.time4j.format.expert.PatternType[] r0 = net.time4j.format.expert.PatternType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$expert$PatternType = r0
                net.time4j.format.expert.PatternType r1 = net.time4j.format.expert.PatternType.CLDR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$format$expert$PatternType     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.expert.PatternType r1 = net.time4j.format.expert.PatternType.SIMPLE_DATE_FORMAT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$format$expert$PatternType     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.format.expert.PatternType r1 = net.time4j.format.expert.PatternType.CLDR_24     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$format$expert$PatternType     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.format.expert.PatternType r1 = net.time4j.format.expert.PatternType.CLDR_DATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$net$time4j$format$expert$PatternType     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.format.expert.PatternType r1 = net.time4j.format.expert.PatternType.DYNAMIC     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.PatternType.AnonymousClass1.<clinit>():void");
        }
    }

    private static boolean isISO(Chronology<?> chronology) {
        return getCalendarType(chronology).equals(CalendarText.ISO_CALENDAR_TYPE);
    }

    private static String getCalendarType(Chronology<?> chronology) {
        CalendarType calendarType = (CalendarType) chronology.getChronoType().getAnnotation(CalendarType.class);
        if (calendarType == null) {
            return CalendarText.ISO_CALENDAR_TYPE;
        }
        return calendarType.value();
    }

    private static ChronoElement<Integer> findEthiopianHour(Chronology<?> chronology) {
        for (ChronoExtension elements : chronology.getExtensions()) {
            Iterator<ChronoElement<?>> it = elements.getElements(Locale.ROOT, Attributes.empty()).iterator();
            while (true) {
                if (it.hasNext()) {
                    ChronoElement next = it.next();
                    if (next.name().equals("ETHIOPIAN_HOUR")) {
                        return (ChronoElement) cast(next);
                    }
                }
            }
        }
        return null;
    }

    private static Chronology<?> getEffectiveChronology(ChronoFormatter.Builder<?> builder) {
        Chronology<?> chronology = builder.getChronology();
        while (chronology instanceof BridgeChronology) {
            chronology = chronology.preparser();
        }
        return chronology;
    }

    private Map<ChronoElement<?>, ChronoElement<?>> cldr(ChronoFormatter.Builder<?> builder, Locale locale, char c, int i) {
        Chronology<?> effectiveChronology = getEffectiveChronology(builder);
        if (isGeneralSymbol(c) && !isISO(effectiveChronology)) {
            return general(builder, effectiveChronology, c, i, locale);
        }
        if (c != 'h' || !getCalendarType(effectiveChronology).equals("ethiopic")) {
            return cldrISO(builder, effectiveChronology, locale, c, i, false);
        }
        ChronoElement<Integer> findEthiopianHour = findEthiopianHour(effectiveChronology);
        if (findEthiopianHour != null) {
            addNumber(findEthiopianHour, c, builder, i, false);
            return Collections.emptyMap();
        }
        throw new IllegalArgumentException("Ethiopian time not available.");
    }

    private Map<ChronoElement<?>, ChronoElement<?>> cldrISO(ChronoFormatter.Builder<?> builder, Chronology<?> chronology, Locale locale, char c, int i, boolean z) {
        TextWidth textWidth;
        TextWidth textWidth2;
        ChronoFormatter.Builder<?> builder2 = builder;
        char c2 = c;
        int i2 = i;
        boolean z2 = z;
        int i3 = 4;
        switch (c2) {
            case 'A':
                builder.addInteger(PlainTime.MILLI_OF_DAY, i, 8);
                break;
            case 'B':
                builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, getPeriodWidth(i));
                builder.addDayPeriodApproximate();
                builder.endSection();
                break;
            case 'D':
                if (i2 < 3) {
                    builder.addInteger(PlainDate.DAY_OF_YEAR, i, 3);
                    break;
                } else if (i2 == 3 || z2) {
                    builder.addFixedInteger(PlainDate.DAY_OF_YEAR, i);
                    break;
                } else {
                    throw new IllegalArgumentException("Too many pattern letters (D): " + i);
                }
            case 'E':
                if (i2 <= 3) {
                    textWidth = TextWidth.ABBREVIATED;
                } else if (i2 == 4 || z2) {
                    textWidth = TextWidth.WIDE;
                } else if (i2 == 5) {
                    textWidth = TextWidth.NARROW;
                } else if (i2 == 6) {
                    textWidth = TextWidth.SHORT;
                } else {
                    throw new IllegalArgumentException("Too many pattern letters (E): " + i);
                }
                builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, textWidth);
                builder.addText((ChronoElement<V>) PlainDate.DAY_OF_WEEK);
                builder.endSection();
                break;
            case 'F':
                if (i2 == 1 || z2) {
                    builder.addFixedInteger(PlainDate.WEEKDAY_IN_MONTH, i);
                    break;
                } else {
                    throw new IllegalArgumentException("Too many pattern letters (F): " + i);
                }
            case 'G':
                if (i2 <= 3) {
                    textWidth2 = TextWidth.ABBREVIATED;
                } else if (i2 == 4 || z2) {
                    textWidth2 = TextWidth.WIDE;
                } else if (i2 == 5) {
                    textWidth2 = TextWidth.NARROW;
                } else {
                    throw new IllegalArgumentException("Too many pattern letters (G): " + i);
                }
                builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, textWidth2);
                ChronoHistory of = ChronoHistory.of(locale);
                builder.addText((TextElement<?>) TextElement.class.cast(of.era()));
                builder.endSection();
                HashMap hashMap = new HashMap();
                hashMap.put(PlainDate.YEAR, of.yearOfEra());
                hashMap.put(PlainDate.MONTH_OF_YEAR, of.month());
                hashMap.put(PlainDate.MONTH_AS_NUMBER, of.month());
                hashMap.put(PlainDate.DAY_OF_MONTH, of.dayOfMonth());
                hashMap.put(PlainDate.DAY_OF_YEAR, of.dayOfYear());
                return hashMap;
            case 'H':
                addNumber(PlainTime.DIGITAL_HOUR_OF_DAY, c, builder, i, z2);
                break;
            case 'K':
                addNumber(PlainTime.DIGITAL_HOUR_OF_AMPM, c, builder, i, z2);
                break;
            case 'L':
                builder.startSection((AttributeKey<A>) Attributes.OUTPUT_CONTEXT, OutputContext.STANDALONE);
                if (!z2) {
                    i3 = i2;
                }
                addMonth(builder, Math.min(i, i3));
                builder.endSection();
                break;
            case 'M':
                if (!z2) {
                    i3 = i2;
                }
                addMonth(builder, Math.min(i, i3));
                break;
            case 'O':
                if (i2 == 1) {
                    builder.addShortLocalizedOffset();
                    break;
                } else if (i2 == 4) {
                    builder.addLongLocalizedOffset();
                    break;
                } else {
                    throw new IllegalArgumentException("Count of pattern letters is not 1 or 4: " + i);
                }
            case 'Q':
                addQuarterOfYear(builder, i);
                break;
            case 'S':
                builder.addFraction(PlainTime.NANO_OF_SECOND, i, i, false);
                break;
            case 'V':
                if (i2 == 2) {
                    try {
                        builder.addTimezoneID();
                        break;
                    } catch (IllegalStateException e) {
                        throw new IllegalArgumentException(e.getMessage());
                    }
                } else {
                    throw new IllegalArgumentException("Count of pattern letters is not 2: " + i);
                }
            case 'W':
                if (i2 == 1) {
                    builder.addFixedInteger(Weekmodel.of(locale).weekOfMonth(), 1);
                    break;
                } else {
                    throw new IllegalArgumentException("Too many pattern letters (W): " + i);
                }
            case 'X':
                addOffset(builder, c, i, true);
                break;
            case 'Y':
                if (i2 != 2) {
                    builder.addYear(PlainDate.YEAR_OF_WEEKDATE, i, false);
                    break;
                } else {
                    builder.addTwoDigitYear(PlainDate.YEAR_OF_WEEKDATE);
                    break;
                }
            case 'Z':
                if (i2 < 4) {
                    builder.addTimezoneOffset(DisplayMode.LONG, false, Collections.singletonList("+0000"));
                    break;
                } else if (i2 == 4) {
                    builder.addLongLocalizedOffset();
                    break;
                } else if (i2 == 5) {
                    builder.addTimezoneOffset(DisplayMode.LONG, true, Collections.singletonList("Z"));
                    break;
                } else {
                    throw new IllegalArgumentException("Too many pattern letters (Z): " + i);
                }
            case 'a':
                builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, z2 ? TextWidth.ABBREVIATED : getPeriodWidth(i));
                builder.addText((ChronoElement<V>) PlainTime.AM_PM_OF_DAY);
                builder.endSection();
                if (getCalendarType(chronology).equals("ethiopic")) {
                    ChronoElement<Integer> findEthiopianHour = findEthiopianHour(chronology);
                    if (findEthiopianHour != null) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put(findEthiopianHour, PlainTime.CLOCK_HOUR_OF_AMPM);
                        return hashMap2;
                    }
                    throw new IllegalArgumentException("Ethiopian time not available.");
                }
                break;
            case 'b':
                builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, getPeriodWidth(i));
                builder.addDayPeriodFixed();
                builder.endSection();
                break;
            case 'c':
                if (i2 != 2) {
                    builder.startSection((AttributeKey<A>) Attributes.OUTPUT_CONTEXT, OutputContext.STANDALONE);
                    if (i2 == 1) {
                        builder.addFixedNumerical(Weekmodel.of(locale).localDayOfWeek(), 1);
                    } else {
                        cldrISO(builder, chronology, locale, 'E', i, z);
                    }
                    builder.endSection();
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid pattern count of 2 for symbol 'c'.");
                }
            case 'd':
                addNumber(PlainDate.DAY_OF_MONTH, c, builder, i, z2);
                break;
            case 'e':
                if (i2 > 2) {
                    cldrISO(builder, chronology, locale, 'E', i, z);
                    break;
                } else {
                    builder.addFixedNumerical(Weekmodel.of(locale).localDayOfWeek(), i);
                    break;
                }
            case 'g':
                builder.addLongNumber(EpochDays.MODIFIED_JULIAN_DATE, i, 18, SignPolicy.SHOW_WHEN_NEGATIVE);
                break;
            case 'h':
                addNumber(PlainTime.CLOCK_HOUR_OF_AMPM, c, builder, i, z2);
                break;
            case 'k':
                addNumber(PlainTime.CLOCK_HOUR_OF_DAY, c, builder, i, z2);
                break;
            case 'm':
                addNumber(PlainTime.MINUTE_OF_HOUR, c, builder, i, z2);
                break;
            case 'q':
                builder.startSection((AttributeKey<A>) Attributes.OUTPUT_CONTEXT, OutputContext.STANDALONE);
                addQuarterOfYear(builder, i);
                builder.endSection();
                break;
            case 'r':
                builder.startSection((AttributeKey<A>) Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
                builder.startSection(Attributes.ZERO_DIGIT, '0');
                builder.addYear(PlainDate.YEAR, i, true);
                builder.endSection();
                builder.endSection();
                break;
            case 's':
                addNumber(PlainTime.SECOND_OF_MINUTE, c, builder, i, z2);
                break;
            case 'u':
                builder.addYear(PlainDate.YEAR, i, true);
                break;
            case 'w':
                if (i2 <= 2) {
                    AdjustableElement<Integer, PlainDate> weekOfYear = Weekmodel.of(locale).weekOfYear();
                    Iterator<ChronoElement<?>> it = chronology.getRegisteredElements().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            ChronoElement next = it.next();
                            if (next.getSymbol() == c2 && next.equals(Weekmodel.ISO.weekOfYear())) {
                                weekOfYear = Weekmodel.ISO.weekOfYear();
                            }
                        }
                    }
                    addNumber(weekOfYear, c, builder, i, z2);
                    break;
                } else {
                    throw new IllegalArgumentException("Too many pattern letters (w): " + i);
                }
            case 'x':
                addOffset(builder, c, i, false);
                break;
            case 'y':
                if (i2 != 2) {
                    builder.addYear(PlainDate.YEAR, i, false);
                    break;
                } else {
                    builder.addTwoDigitYear(PlainDate.YEAR);
                    break;
                }
            case 'z':
                if (i2 >= 4) {
                    if (i2 != 4) {
                        if (!z2) {
                            throw new IllegalArgumentException("Too many pattern letters (z): " + i);
                        }
                    }
                    builder.addLongTimezoneName();
                    break;
                } else {
                    try {
                        builder.addShortTimezoneName();
                        break;
                    } catch (IllegalStateException e2) {
                        throw new IllegalArgumentException(e2.getMessage());
                    }
                }
            default:
                throw new IllegalArgumentException("Unsupported pattern symbol: " + c);
        }
        return Collections.emptyMap();
    }

    private static TextWidth getPeriodWidth(int i) {
        if (i <= 3) {
            return TextWidth.ABBREVIATED;
        }
        if (i == 4) {
            return TextWidth.WIDE;
        }
        if (i == 5) {
            return TextWidth.NARROW;
        }
        throw new IllegalArgumentException("Too many pattern letters: " + i);
    }

    private Map<ChronoElement<?>, ChronoElement<?>> sdf(ChronoFormatter.Builder<?> builder, Chronology<?> chronology, Locale locale, char c, int i) {
        if (!(c == 'B' || c == 'O' || c == 'Q')) {
            if (c == 'S') {
                builder.addFixedInteger(PlainTime.MILLI_OF_SECOND, i);
            } else if (c == 'Z') {
                addOffset(builder, c, 2, false);
            } else if (!(c == 'e' || c == 'g')) {
                if (c == 'u') {
                    builder.addFixedNumerical(PlainDate.DAY_OF_WEEK, i);
                } else if (!(c == 'x' || c == 'b' || c == 'c' || c == 'q' || c == 'r')) {
                    switch (c) {
                        case 'U':
                        case 'V':
                            break;
                        case 'W':
                            builder.addFixedInteger(Weekmodel.of(locale).boundedWeekOfMonth(), i);
                            break;
                        case 'X':
                            if (i < 4) {
                                return cldrISO(builder, chronology, locale, 'X', i, true);
                            }
                            throw new IllegalArgumentException("Too many pattern letters (X): " + i);
                        default:
                            return cldrISO(builder, chronology, locale, c, i, true);
                    }
                }
            }
            return Collections.emptyMap();
        }
        throw new IllegalArgumentException("CLDR pattern symbol not supported in SimpleDateFormat-style: " + c);
    }

    private Map<ChronoElement<?>, ChronoElement<?>> cldr24(ChronoFormatter.Builder<?> builder, Locale locale, char c, int i) {
        if (c != 'H') {
            return cldr(builder, locale, c, i);
        }
        addNumber(PlainTime.HOUR_FROM_0_TO_24, c, builder, i, false);
        return Collections.emptyMap();
    }

    private static void addOffset(ChronoFormatter.Builder<?> builder, char c, int i, boolean z) {
        String str = "Z";
        if (i == 1) {
            DisplayMode displayMode = DisplayMode.SHORT;
            if (!z) {
                str = "+00";
            }
            builder.addTimezoneOffset(displayMode, false, Collections.singletonList(str));
        } else if (i == 2) {
            DisplayMode displayMode2 = DisplayMode.MEDIUM;
            if (!z) {
                str = "+0000";
            }
            builder.addTimezoneOffset(displayMode2, false, Collections.singletonList(str));
        } else if (i == 3) {
            DisplayMode displayMode3 = DisplayMode.MEDIUM;
            if (!z) {
                str = "+00:00";
            }
            builder.addTimezoneOffset(displayMode3, true, Collections.singletonList(str));
        } else if (i == 4) {
            DisplayMode displayMode4 = DisplayMode.LONG;
            if (!z) {
                str = "+0000";
            }
            builder.addTimezoneOffset(displayMode4, false, Collections.singletonList(str));
        } else if (i == 5) {
            DisplayMode displayMode5 = DisplayMode.LONG;
            if (!z) {
                str = "+00:00";
            }
            builder.addTimezoneOffset(displayMode5, true, Collections.singletonList(str));
        } else {
            throw new IllegalArgumentException("Too many pattern letters (" + c + "): " + i);
        }
    }

    private static void addNumber(ChronoElement<Integer> chronoElement, char c, ChronoFormatter.Builder<?> builder, int i, boolean z) {
        if (i == 1) {
            builder.addInteger(chronoElement, 1, 2);
        } else if (i == 2 || z) {
            builder.addFixedInteger(chronoElement, i);
        } else {
            throw new IllegalArgumentException("Too many pattern letters (" + c + "): " + i);
        }
    }

    private static void addMonth(ChronoFormatter.Builder<?> builder, int i) {
        if (i == 1) {
            builder.addInteger(PlainDate.MONTH_AS_NUMBER, 1, 2);
        } else if (i == 2) {
            builder.addFixedInteger(PlainDate.MONTH_AS_NUMBER, 2);
        } else if (i == 3) {
            builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.ABBREVIATED);
            builder.addText((ChronoElement<V>) PlainDate.MONTH_OF_YEAR);
            builder.endSection();
        } else if (i == 4) {
            builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.WIDE);
            builder.addText((ChronoElement<V>) PlainDate.MONTH_OF_YEAR);
            builder.endSection();
        } else if (i == 5) {
            builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.NARROW);
            builder.addText((ChronoElement<V>) PlainDate.MONTH_OF_YEAR);
            builder.endSection();
        } else {
            throw new IllegalArgumentException("Too many pattern letters for month: " + i);
        }
    }

    private static void addQuarterOfYear(ChronoFormatter.Builder<?> builder, int i) {
        if (i == 1 || i == 2) {
            builder.addFixedNumerical(PlainDate.QUARTER_OF_YEAR, i);
        } else if (i == 3) {
            builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.ABBREVIATED);
            builder.addText((ChronoElement<V>) PlainDate.QUARTER_OF_YEAR);
            builder.endSection();
        } else if (i == 4) {
            builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.WIDE);
            builder.addText((ChronoElement<V>) PlainDate.QUARTER_OF_YEAR);
            builder.endSection();
        } else if (i == 5) {
            builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.NARROW);
            builder.addText((ChronoElement<V>) PlainDate.QUARTER_OF_YEAR);
            builder.endSection();
        } else {
            throw new IllegalArgumentException("Too many pattern letters for quarter-of-year: " + i);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: net.time4j.format.TextElement} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<net.time4j.engine.ChronoElement<?>, net.time4j.engine.ChronoElement<?>> general(net.time4j.format.expert.ChronoFormatter.Builder<?> r18, net.time4j.engine.Chronology<?> r19, char r20, int r21, java.util.Locale r22) {
        /*
            r17 = this;
            r6 = r18
            r2 = r19
            r4 = r20
            r5 = r21
            r0 = 103(0x67, float:1.44E-43)
            if (r4 != r0) goto L_0x001a
            net.time4j.engine.EpochDays r0 = net.time4j.engine.EpochDays.MODIFIED_JULIAN_DATE
            r1 = 18
            net.time4j.format.expert.SignPolicy r2 = net.time4j.format.expert.SignPolicy.SHOW_WHEN_NEGATIVE
            r6.addLongNumber(r0, r5, r1, r2)
            java.util.Map r0 = java.util.Collections.emptyMap()
            return r0
        L_0x001a:
            r0 = 71
            if (r4 != r0) goto L_0x0037
            net.time4j.engine.TimeAxis r0 = net.time4j.PlainDate.axis()
            if (r2 != r0) goto L_0x0037
            r7 = 0
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r22
            r4 = r20
            r5 = r21
            r6 = r7
            java.util.Map r0 = r0.cldrISO(r1, r2, r3, r4, r5, r6)
            return r0
        L_0x0037:
            r7 = r22
            java.util.Set r0 = getElements(r2, r4, r7)
            net.time4j.engine.Chronology r1 = r18.getChronology()
            java.lang.Class r1 = r1.getChronoType()
            java.lang.String r1 = r1.getName()
            net.time4j.engine.ChronoElement r0 = find(r0, r4, r1)
            java.lang.Class<java.lang.Integer> r3 = java.lang.Integer.class
            java.lang.Class r8 = r0.getType()
            boolean r3 = r3.isAssignableFrom(r8)
            java.lang.String r8 = "\""
            java.lang.String r9 = " in \""
            java.lang.String r10 = "Implementation error: "
            r11 = 0
            if (r3 == 0) goto L_0x0072
            boolean r3 = r0 instanceof net.time4j.format.internal.DualFormatElement
            if (r3 == 0) goto L_0x006b
            java.lang.Object r3 = cast(r0)
            r11 = r3
            net.time4j.format.TextElement r11 = (net.time4j.format.TextElement) r11
        L_0x006b:
            java.lang.Object r3 = cast(r0)
            net.time4j.engine.ChronoElement r3 = (net.time4j.engine.ChronoElement) r3
            goto L_0x0081
        L_0x0072:
            boolean r3 = r0 instanceof net.time4j.format.TextElement
            if (r3 == 0) goto L_0x02bd
            java.lang.Object r3 = cast(r0)
            net.time4j.format.TextElement r3 = (net.time4j.format.TextElement) r3
            r16 = r11
            r11 = r3
            r3 = r16
        L_0x0081:
            r12 = 76
            if (r4 == r12) goto L_0x02ab
            r12 = 77
            if (r4 == r12) goto L_0x02a7
            r12 = 85
            r13 = 5
            r14 = 4
            r15 = 3
            if (r4 == r12) goto L_0x0256
            r1 = 87
            r8 = 1
            if (r4 == r1) goto L_0x0238
            r1 = 114(0x72, float:1.6E-43)
            if (r4 == r1) goto L_0x021f
            r1 = 119(0x77, float:1.67E-43)
            r9 = 0
            if (r4 == r1) goto L_0x021a
            r1 = 121(0x79, float:1.7E-43)
            r10 = 2
            if (r4 == r1) goto L_0x01e9
            switch(r4) {
                case 68: goto L_0x01c4;
                case 69: goto L_0x018c;
                case 70: goto L_0x016e;
                case 71: goto L_0x013c;
                default: goto L_0x00a6;
            }
        L_0x00a6:
            switch(r4) {
                case 99: goto L_0x010b;
                case 100: goto L_0x00de;
                case 101: goto L_0x00c0;
                default: goto L_0x00a9;
            }
        L_0x00a9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported pattern symbol: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00c0:
            if (r5 > r10) goto L_0x00cd
            java.lang.Object r0 = cast(r0)
            net.time4j.engine.ChronoElement r0 = (net.time4j.engine.ChronoElement) r0
            r6.addFixedNumerical(r0, r5)
            goto L_0x02b8
        L_0x00cd:
            r3 = 69
            r0 = r17
            r1 = r18
            r2 = r19
            r4 = r21
            r5 = r22
            r0.general(r1, r2, r3, r4, r5)
            goto L_0x02b8
        L_0x00de:
            if (r3 != 0) goto L_0x0106
            if (r5 > r10) goto L_0x00ef
            net.time4j.engine.AttributeKey<java.lang.Integer> r0 = net.time4j.format.internal.DualFormatElement.COUNT_OF_PATTERN_SYMBOLS
            r6.startSection((net.time4j.engine.AttributeKey<java.lang.Integer>) r0, (int) r5)
            r6.addText((net.time4j.format.TextElement<?>) r11)
            r18.endSection()
            goto L_0x02b8
        L_0x00ef:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Too many pattern letters for day-of-month: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0106:
            addNumber(r3, r4, r6, r5, r9)
            goto L_0x02b8
        L_0x010b:
            if (r5 == r10) goto L_0x0134
            net.time4j.engine.AttributeKey<net.time4j.format.OutputContext> r1 = net.time4j.format.Attributes.OUTPUT_CONTEXT
            net.time4j.format.OutputContext r3 = net.time4j.format.OutputContext.STANDALONE
            r6.startSection(r1, r3)
            if (r5 != r8) goto L_0x0120
            java.lang.Object r0 = cast(r0)
            net.time4j.engine.ChronoElement r0 = (net.time4j.engine.ChronoElement) r0
            r6.addFixedNumerical(r0, r8)
            goto L_0x012f
        L_0x0120:
            r3 = 69
            r0 = r17
            r1 = r18
            r2 = r19
            r4 = r21
            r5 = r22
            r0.general(r1, r2, r3, r4, r5)
        L_0x012f:
            r18.endSection()
            goto L_0x02b8
        L_0x0134:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Invalid pattern count of 2 for symbol 'c'."
            r0.<init>(r1)
            throw r0
        L_0x013c:
            if (r5 > r15) goto L_0x0141
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.ABBREVIATED
            goto L_0x014a
        L_0x0141:
            if (r5 != r14) goto L_0x0146
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.WIDE
            goto L_0x014a
        L_0x0146:
            if (r5 != r13) goto L_0x0157
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.NARROW
        L_0x014a:
            net.time4j.engine.AttributeKey<net.time4j.format.TextWidth> r1 = net.time4j.format.Attributes.TEXT_WIDTH
            r6.startSection(r1, r0)
            r6.addText((net.time4j.format.TextElement<?>) r11)
            r18.endSection()
            goto L_0x02b8
        L_0x0157:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Too many pattern letters (G): "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x016e:
            if (r5 != r8) goto L_0x0175
            r6.addFixedInteger(r3, r5)
            goto L_0x02b8
        L_0x0175:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Too many pattern letters (F): "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x018c:
            if (r5 > r15) goto L_0x0191
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.ABBREVIATED
            goto L_0x01a0
        L_0x0191:
            if (r5 != r14) goto L_0x0196
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.WIDE
            goto L_0x01a0
        L_0x0196:
            if (r5 != r13) goto L_0x019b
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.NARROW
            goto L_0x01a0
        L_0x019b:
            r0 = 6
            if (r5 != r0) goto L_0x01ad
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.SHORT
        L_0x01a0:
            net.time4j.engine.AttributeKey<net.time4j.format.TextWidth> r1 = net.time4j.format.Attributes.TEXT_WIDTH
            r6.startSection(r1, r0)
            r6.addText((net.time4j.format.TextElement<?>) r11)
            r18.endSection()
            goto L_0x02b8
        L_0x01ad:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Too many pattern letters (E): "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01c4:
            if (r5 >= r15) goto L_0x01cb
            r6.addInteger(r3, r5, r15)
            goto L_0x02b8
        L_0x01cb:
            if (r5 != r15) goto L_0x01d2
            r6.addFixedInteger(r3, r5)
            goto L_0x02b8
        L_0x01d2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Too many pattern letters (D): "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01e9:
            java.lang.String r0 = r22.getLanguage()
            java.lang.String r1 = "am"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0209
            java.lang.String r0 = getCalendarType(r19)
            java.lang.String r1 = "ethiopic"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0209
            net.time4j.engine.AttributeKey<net.time4j.format.NumberSystem> r0 = net.time4j.format.Attributes.NUMBER_SYSTEM
            net.time4j.format.NumberSystem r1 = net.time4j.format.NumberSystem.ETHIOPIC
            r6.startSection(r0, r1)
            goto L_0x020a
        L_0x0209:
            r8 = 0
        L_0x020a:
            if (r5 != r10) goto L_0x0210
            r6.addTwoDigitYear(r3)
            goto L_0x0213
        L_0x0210:
            r6.addYear(r3, r5, r9)
        L_0x0213:
            if (r8 == 0) goto L_0x02b8
            r18.endSection()
            goto L_0x02b8
        L_0x021a:
            addNumber(r3, r4, r6, r5, r9)
            goto L_0x02b8
        L_0x021f:
            net.time4j.engine.AttributeKey<net.time4j.format.NumberSystem> r0 = net.time4j.format.Attributes.NUMBER_SYSTEM
            net.time4j.format.NumberSystem r1 = net.time4j.format.NumberSystem.ARABIC
            r6.startSection(r0, r1)
            net.time4j.engine.AttributeKey<java.lang.Character> r0 = net.time4j.format.Attributes.ZERO_DIGIT
            r1 = 48
            r6.startSection((net.time4j.engine.AttributeKey<java.lang.Character>) r0, (char) r1)
            r6.addYear(r3, r5, r8)
            r18.endSection()
            r18.endSection()
            goto L_0x02b8
        L_0x0238:
            if (r5 != r8) goto L_0x023f
            r6.addFixedInteger(r3, r8)
            goto L_0x02b8
        L_0x023f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Too many pattern letters (W): "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0256:
            if (r11 == 0) goto L_0x0289
            if (r5 > r15) goto L_0x025d
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.ABBREVIATED
            goto L_0x0266
        L_0x025d:
            if (r5 != r14) goto L_0x0262
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.WIDE
            goto L_0x0266
        L_0x0262:
            if (r5 != r13) goto L_0x0272
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.NARROW
        L_0x0266:
            net.time4j.engine.AttributeKey<net.time4j.format.TextWidth> r1 = net.time4j.format.Attributes.TEXT_WIDTH
            r6.startSection(r1, r0)
            r6.addText((net.time4j.format.TextElement<?>) r11)
            r18.endSection()
            goto L_0x02b8
        L_0x0272:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Too many pattern letters (U): "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0289:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            r3.append(r0)
            r3.append(r9)
            r3.append(r1)
            r3.append(r8)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x02a7:
            addMonth(r6, r5, r11)
            goto L_0x02b8
        L_0x02ab:
            net.time4j.engine.AttributeKey<net.time4j.format.OutputContext> r0 = net.time4j.format.Attributes.OUTPUT_CONTEXT
            net.time4j.format.OutputContext r1 = net.time4j.format.OutputContext.STANDALONE
            r6.startSection(r0, r1)
            addMonth(r6, r5, r11)
            r18.endSection()
        L_0x02b8:
            java.util.Map r0 = java.util.Collections.emptyMap()
            return r0
        L_0x02bd:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            r3.append(r0)
            r3.append(r9)
            r3.append(r1)
            r3.append(r8)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.PatternType.general(net.time4j.format.expert.ChronoFormatter$Builder, net.time4j.engine.Chronology, char, int, java.util.Locale):java.util.Map");
    }

    private static void addEnumElementAsText(ChronoFormatter.Builder<?> builder, ChronoElement<? extends Enum> chronoElement) {
        builder.addText((ChronoElement<V>) chronoElement);
    }

    private static void addEnumElementAsInteger(ChronoFormatter.Builder<?> builder, ChronoElement<? extends Enum> chronoElement, int i) {
        builder.addNumerical(chronoElement, i, 9);
    }

    private static ChronoElement<?> findDynamicElement(Chronology<?> chronology, Locale locale, int i) {
        ChronoElement<?> findDynamicElement = findDynamicElement(chronology, locale, i, false);
        return findDynamicElement == null ? findDynamicElement(chronology, locale, i, true) : findDynamicElement;
    }

    private static ChronoElement<?> findDynamicElement(Chronology<?> chronology, Locale locale, int i, boolean z) {
        if (z) {
            i = capitalized(i);
        }
        for (ChronoElement<?> next : chronology.getRegisteredElements()) {
            int symbol = next.getSymbol();
            if (z) {
                symbol = capitalized(symbol);
                continue;
            }
            if (symbol == i) {
                return next;
            }
        }
        for (ChronoExtension elements : chronology.getExtensions()) {
            Iterator<ChronoElement<?>> it = elements.getElements(locale, Attributes.empty()).iterator();
            while (true) {
                if (it.hasNext()) {
                    ChronoElement<?> next2 = it.next();
                    int symbol2 = next2.getSymbol();
                    if (z) {
                        symbol2 = capitalized(symbol2);
                        continue;
                    }
                    if (symbol2 == i) {
                        return next2;
                    }
                }
            }
        }
        return null;
    }

    private Map<ChronoElement<?>, ChronoElement<?>> dynamic(ChronoFormatter.Builder<?> builder, char c, int i, Locale locale) {
        boolean z;
        boolean z2 = c >= 'A' && c <= 'Z';
        ChronoElement<?> findDynamicElement = findDynamicElement(getEffectiveChronology(builder), locale, c);
        if (findDynamicElement != null) {
            if (z2 && (((z = findDynamicElement instanceof TextElement)) || Enum.class.isAssignableFrom(findDynamicElement.getType()))) {
                if (i == 1) {
                    builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.NARROW);
                } else if (i == 2) {
                    builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.SHORT);
                } else if (i == 3) {
                    builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.ABBREVIATED);
                } else if (i == 4) {
                    builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.WIDE);
                } else {
                    throw new IllegalArgumentException("Illegal count of symbols: " + c);
                }
                if (z) {
                    builder.addText((TextElement<?>) (TextElement) cast(findDynamicElement));
                } else {
                    addEnumElementAsText(builder, (ChronoElement) cast(findDynamicElement));
                }
                builder.endSection();
            } else if (findDynamicElement.getType() == Integer.class) {
                builder.addInteger((ChronoElement) cast(findDynamicElement), i, 9);
            } else if (Enum.class.isAssignableFrom(findDynamicElement.getType())) {
                addEnumElementAsInteger(builder, (ChronoElement) cast(findDynamicElement), i);
            } else {
                throw new IllegalArgumentException("Can only handle enum or integer elements in a numerical way: " + findDynamicElement);
            }
            return Collections.emptyMap();
        }
        throw new IllegalArgumentException("Cannot resolve symbol: " + c);
    }

    private static Set<ChronoElement<?>> getElements(Chronology<?> chronology, char c, Locale locale) {
        ChronoElement next;
        if (c != 'w' && c != 'W' && c != 'e' && c != 'c') {
            return chronology.getRegisteredElements();
        }
        loop0:
        for (ChronoExtension elements : chronology.getExtensions()) {
            Iterator<ChronoElement<?>> it = elements.getElements(locale, Attributes.empty()).iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (((c == 'e' || c == 'c') && next.name().equals("LOCAL_DAY_OF_WEEK")) || ((c == 'w' && next.name().equals("WEEK_OF_YEAR")) || (c == 'W' && next.name().equals("WEEK_OF_MONTH")))) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(next);
                    }
                }
            }
            HashSet hashSet2 = new HashSet();
            hashSet2.add(next);
            return hashSet2;
        }
        return Collections.emptySet();
    }

    private static ChronoElement<?> find(Set<ChronoElement<?>> set, char c, String str) {
        char c2 = c == 'L' ? 'M' : c == 'c' ? 'e' : c;
        for (ChronoElement<?> next : set) {
            if (next.isDateElement() && next.getSymbol() == c2) {
                if (c2 != 'M' || !next.name().equals("MONTH_AS_NUMBER")) {
                    return next;
                }
            }
        }
        if (c == 'y' && str.equals("net.time4j.PlainDate")) {
            return PlainDate.YEAR;
        }
        throw new IllegalArgumentException("Cannot find any chronological date element for symbol " + c + " in \"" + str + "\".");
    }

    private static <V extends Enum<V>> void addMonth(ChronoFormatter.Builder<?> builder, int i, TextElement<?> textElement) {
        if (i == 1 || i == 2) {
            if (Enum.class.isAssignableFrom(textElement.getType())) {
                ChronoElement chronoElement = (ChronoElement) cast(textElement);
                if (i == 1) {
                    builder.addNumerical(chronoElement, 1, 2);
                } else if (i == 2) {
                    builder.addFixedNumerical(chronoElement, 2);
                }
            } else {
                builder.startSection(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS, i);
                builder.addText(textElement);
                builder.endSection();
            }
        } else if (i == 3) {
            builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.ABBREVIATED);
            builder.addText(textElement);
            builder.endSection();
        } else if (i == 4) {
            builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.WIDE);
            builder.addText(textElement);
            builder.endSection();
        } else if (i == 5) {
            builder.startSection((AttributeKey<A>) Attributes.TEXT_WIDTH, TextWidth.NARROW);
            builder.addText(textElement);
            builder.endSection();
        } else {
            throw new IllegalArgumentException("Too many pattern letters for month: " + i);
        }
    }
}
