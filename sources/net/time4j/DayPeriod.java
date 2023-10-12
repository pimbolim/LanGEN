package net.time4j;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;

public final class DayPeriod {
    /* access modifiers changed from: private */
    public static final AttributeKey<DayPeriod> CUSTOM = Attributes.createKey("CUSTOM_DAY_PERIOD", DayPeriod.class);
    private static DayPeriod FALLBACK;
    private static final SortedMap<PlainTime, String> STD_RULES;
    /* access modifiers changed from: private */
    public final transient String calendarType;
    /* access modifiers changed from: private */
    public final transient SortedMap<PlainTime, String> codeMap;
    /* access modifiers changed from: private */
    public final transient Locale locale;

    static {
        TreeMap treeMap = new TreeMap();
        treeMap.put(PlainTime.midnightAtStartOfDay(), "am");
        treeMap.put(PlainTime.of(12), "pm");
        SortedMap<PlainTime, String> unmodifiableSortedMap = Collections.unmodifiableSortedMap(treeMap);
        STD_RULES = unmodifiableSortedMap;
        FALLBACK = new DayPeriod(Locale.ROOT, CalendarText.ISO_CALENDAR_TYPE, unmodifiableSortedMap);
    }

    private DayPeriod(Locale locale2, String str, SortedMap<PlainTime, String> sortedMap) {
        this.locale = locale2;
        this.calendarType = str;
        this.codeMap = Collections.unmodifiableSortedMap(sortedMap);
    }

    public static DayPeriod of(Locale locale2) {
        return of(locale2, CalendarText.ISO_CALENDAR_TYPE);
    }

    public static DayPeriod of(Map<PlainTime, String> map) {
        if (!map.isEmpty()) {
            TreeMap treeMap = new TreeMap(map);
            for (PlainTime next : map.keySet()) {
                if (next.getHour() == 24) {
                    treeMap.put(PlainTime.midnightAtStartOfDay(), map.get(next));
                    treeMap.remove(next);
                } else if (map.get(next).isEmpty()) {
                    throw new IllegalArgumentException("Map has empty label: " + map);
                }
            }
            return new DayPeriod((Locale) null, "", treeMap);
        }
        throw new IllegalArgumentException("Label map is empty.");
    }

    public ChronoFunction<ChronoDisplay, String> fixed() {
        return fixed(TextWidth.WIDE, OutputContext.FORMAT);
    }

    public ChronoFunction<ChronoDisplay, String> fixed(TextWidth textWidth, OutputContext outputContext) {
        return new PeriodName(true, textWidth, outputContext);
    }

    public ChronoFunction<ChronoDisplay, String> approximate() {
        return approximate(TextWidth.WIDE, OutputContext.FORMAT);
    }

    public ChronoFunction<ChronoDisplay, String> approximate(TextWidth textWidth, OutputContext outputContext) {
        return new PeriodName(false, textWidth, outputContext);
    }

    public PlainTime getStart(PlainTime plainTime) {
        if (plainTime.getHour() == 24) {
            plainTime = PlainTime.midnightAtStartOfDay();
        }
        PlainTime lastKey = this.codeMap.lastKey();
        for (PlainTime next : this.codeMap.keySet()) {
            if (plainTime.isSimultaneous(next)) {
                return next;
            }
            if (plainTime.isBefore(next)) {
                break;
            }
            lastKey = next;
        }
        return lastKey;
    }

    public PlainTime getEnd(PlainTime plainTime) {
        if (plainTime.getHour() == 24) {
            plainTime = PlainTime.midnightAtStartOfDay();
        }
        for (PlainTime next : this.codeMap.keySet()) {
            if (plainTime.isBefore(next)) {
                return next;
            }
        }
        return this.codeMap.firstKey();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DayPeriod)) {
            return false;
        }
        DayPeriod dayPeriod = (DayPeriod) obj;
        Locale locale2 = this.locale;
        if (locale2 == null) {
            if (dayPeriod.locale != null) {
                return false;
            }
        } else if (!locale2.equals(dayPeriod.locale)) {
            return false;
        }
        if (!this.codeMap.equals(dayPeriod.codeMap) || !this.calendarType.equals(dayPeriod.calendarType)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.codeMap.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("DayPeriod[");
        if (isPredefined()) {
            sb.append("locale=");
            sb.append(this.locale);
            sb.append(AbstractJsonLexerKt.COMMA);
            if (!this.calendarType.equals(CalendarText.ISO_CALENDAR_TYPE)) {
                sb.append(",calendar-type=");
                sb.append(this.calendarType);
                sb.append(AbstractJsonLexerKt.COMMA);
            }
        }
        sb.append(this.codeMap);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    /* JADX WARNING: type inference failed for: r5v7, types: [net.time4j.engine.TimePoint] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static net.time4j.DayPeriod of(java.util.Locale r10, java.lang.String r11) {
        /*
            java.lang.String r0 = r10.getLanguage()
            java.lang.String r1 = "nn"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0013
            java.util.Locale r10 = new java.util.Locale
            java.lang.String r1 = "nb"
            r10.<init>(r1)
        L_0x0013:
            java.util.Map r1 = loadTextForms(r10, r11)
            java.util.TreeMap r2 = new java.util.TreeMap
            r2.<init>()
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0024:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x009f
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = accept(r4)
            if (r5 == 0) goto L_0x0024
            r5 = 1
            r6 = 3
            java.lang.String r5 = r4.substring(r5, r6)
            int r5 = java.lang.Integer.parseInt(r5)
            r7 = 5
            java.lang.String r6 = r4.substring(r6, r7)
            int r6 = java.lang.Integer.parseInt(r6)
            net.time4j.PlainTime r7 = net.time4j.PlainTime.midnightAtStartOfDay()
            java.lang.String r8 = "Invalid time key: "
            r9 = 24
            if (r5 != r9) goto L_0x006b
            if (r6 != 0) goto L_0x0056
            goto L_0x0082
        L_0x0056:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r8)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x006b:
            if (r5 < 0) goto L_0x008a
            if (r5 >= r9) goto L_0x008a
            if (r6 < 0) goto L_0x008a
            r9 = 60
            if (r6 >= r9) goto L_0x008a
            int r5 = r5 * 60
            int r5 = r5 + r6
            long r5 = (long) r5
            net.time4j.ClockUnit r8 = net.time4j.ClockUnit.MINUTES
            net.time4j.engine.TimePoint r5 = r7.plus(r5, r8)
            r7 = r5
            net.time4j.PlainTime r7 = (net.time4j.PlainTime) r7
        L_0x0082:
            java.lang.Object r4 = r1.get(r4)
            r2.put(r7, r4)
            goto L_0x0024
        L_0x008a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r8)
            r11.append(r4)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x009f:
            boolean r1 = r2.isEmpty()
            if (r1 != 0) goto L_0x00da
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x00ac
            goto L_0x00da
        L_0x00ac:
            java.util.Set r0 = r2.keySet()
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = ""
        L_0x00b6:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00d4
            java.lang.Object r3 = r0.next()
            net.time4j.PlainTime r3 = (net.time4j.PlainTime) r3
            java.lang.Object r3 = r2.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = r3.equals(r1)
            if (r4 == 0) goto L_0x00d2
            r0.remove()
            goto L_0x00b6
        L_0x00d2:
            r1 = r3
            goto L_0x00b6
        L_0x00d4:
            net.time4j.DayPeriod r0 = new net.time4j.DayPeriod
            r0.<init>(r10, r11, r2)
            return r0
        L_0x00da:
            net.time4j.DayPeriod r10 = FALLBACK
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.DayPeriod.of(java.util.Locale, java.lang.String):net.time4j.DayPeriod");
    }

    /* access modifiers changed from: private */
    public boolean isPredefined() {
        return this.locale != null;
    }

    /* access modifiers changed from: private */
    public static String getFixedCode(PlainTime plainTime) {
        int intValue = ((Integer) plainTime.get(PlainTime.MINUTE_OF_DAY)).intValue();
        if (intValue == 0 || intValue == 1440) {
            return "midnight";
        }
        if (intValue < 720) {
            return "am";
        }
        return intValue == 720 ? "noon" : "pm";
    }

    /* access modifiers changed from: private */
    public static String createKey(Map<String, String> map, TextWidth textWidth, OutputContext outputContext, String str) {
        if (textWidth == TextWidth.SHORT) {
            textWidth = TextWidth.ABBREVIATED;
        }
        String str2 = toPrefix(textWidth, outputContext) + str;
        if (map.containsKey(str2)) {
            return str2;
        }
        if (outputContext != OutputContext.STANDALONE) {
            return textWidth != TextWidth.ABBREVIATED ? createKey(map, TextWidth.ABBREVIATED, outputContext, str) : str2;
        }
        if (textWidth == TextWidth.ABBREVIATED) {
            return createKey(map, textWidth, OutputContext.FORMAT, str);
        }
        return createKey(map, TextWidth.ABBREVIATED, outputContext, str);
    }

    /* renamed from: net.time4j.DayPeriod$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$TextWidth;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
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
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.NARROW     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.DayPeriod.AnonymousClass1.<clinit>():void");
        }
    }

    private static String toPrefix(TextWidth textWidth, OutputContext outputContext) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
        char c = i != 1 ? i != 2 ? 'a' : 'n' : 'w';
        if (outputContext == OutputContext.STANDALONE) {
            c = Character.toUpperCase(c);
        }
        return "P(" + c + ")_";
    }

    /* access modifiers changed from: private */
    public static Map<String, String> loadTextForms(Locale locale2, String str) {
        Map<String, String> textForms = CalendarText.getInstance(str, locale2).getTextForms();
        return (str.equals(CalendarText.ISO_CALENDAR_TYPE) || "true".equals(textForms.get("hasDayPeriods"))) ? textForms : CalendarText.getIsoInstance(locale2).getTextForms();
    }

    private static boolean accept(String str) {
        return str.charAt(0) == 'T' && str.length() == 5 && Character.isDigit(str.charAt(1));
    }

    static class Extension implements ChronoExtension {
        Extension() {
        }

        public boolean accept(Class<?> cls) {
            return PlainTime.class.isAssignableFrom(cls);
        }

        public Set<ChronoElement<?>> getElements(Locale locale, AttributeQuery attributeQuery) {
            DayPeriod from = from(locale, attributeQuery);
            HashSet hashSet = new HashSet();
            hashSet.add(new Element(false, from));
            if (!attributeQuery.contains(DayPeriod.CUSTOM)) {
                hashSet.add(new Element(true, from));
            }
            return Collections.unmodifiableSet(hashSet);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: net.time4j.engine.ChronoEntity<?>} */
        /* JADX WARNING: type inference failed for: r0v1, types: [net.time4j.engine.ChronoEntity] */
        /* JADX WARNING: type inference failed for: r0v5, types: [net.time4j.engine.ChronoEntity<?>, net.time4j.engine.ChronoEntity] */
        /* JADX WARNING: type inference failed for: r0v7 */
        /* JADX WARNING: type inference failed for: r0v8 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00ec A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x012b A[LOOP:0: B:11:0x003f->B:73:0x012b, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x011a A[EDGE_INSN: B:83:0x011a->B:69:0x011a ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0115 A[SYNTHETIC] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.engine.ChronoEntity<?> resolve(net.time4j.engine.ChronoEntity<?> r17, java.util.Locale r18, net.time4j.engine.AttributeQuery r19) {
            /*
                r16 = this;
                r0 = r17
                net.time4j.WallTimeElement r1 = net.time4j.PlainTime.COMPONENT
                boolean r1 = r0.contains(r1)
                if (r1 != 0) goto L_0x0166
                net.time4j.ProportionalElement<java.lang.Integer, net.time4j.PlainTime> r1 = net.time4j.PlainTime.HOUR_FROM_0_TO_24
                boolean r1 = r0.contains(r1)
                if (r1 != 0) goto L_0x0166
                net.time4j.ProportionalElement<java.lang.Integer, net.time4j.PlainTime> r1 = net.time4j.PlainTime.DIGITAL_HOUR_OF_DAY
                boolean r1 = r0.contains(r1)
                if (r1 != 0) goto L_0x0166
                net.time4j.AdjustableElement<java.lang.Integer, net.time4j.PlainTime> r1 = net.time4j.PlainTime.CLOCK_HOUR_OF_DAY
                boolean r1 = r0.contains(r1)
                if (r1 == 0) goto L_0x0024
                goto L_0x0166
            L_0x0024:
                net.time4j.DayPeriod r1 = from(r18, r19)
                net.time4j.DayPeriod$Element r2 = new net.time4j.DayPeriod$Element
                r3 = 0
                r2.<init>(r3, r1)
                boolean r4 = r0.contains(r2)
                java.lang.String r5 = "midnight"
                r6 = 1
                if (r4 == 0) goto L_0x012f
                java.lang.Object r4 = r0.get(r2)
                java.lang.String r4 = (java.lang.String) r4
                r8 = 0
                r9 = 0
            L_0x003f:
                r10 = 124(0x7c, float:1.74E-43)
                int r10 = r4.indexOf(r10, r3)
                r11 = -1
                if (r10 != r11) goto L_0x004d
                java.lang.String r3 = r4.substring(r3)
                goto L_0x0051
            L_0x004d:
                java.lang.String r3 = r4.substring(r3, r10)
            L_0x0051:
                int r10 = r10 + 1
                int r8 = r8 + r6
                boolean r12 = r1.isPredefined()
                if (r12 == 0) goto L_0x0072
                if (r9 != 0) goto L_0x0072
                boolean r12 = r3.equals(r5)
                if (r12 == 0) goto L_0x0067
                net.time4j.Meridiem r3 = net.time4j.Meridiem.AM
            L_0x0064:
                r9 = r3
                goto L_0x0118
            L_0x0067:
                java.lang.String r12 = "noon"
                boolean r12 = r3.equals(r12)
                if (r12 == 0) goto L_0x0072
                net.time4j.Meridiem r3 = net.time4j.Meridiem.PM
                goto L_0x0064
            L_0x0072:
                java.util.SortedMap r12 = r1.codeMap
                java.util.Set r12 = r12.keySet()
                java.util.Iterator r12 = r12.iterator()
            L_0x007e:
                boolean r13 = r12.hasNext()
                if (r13 == 0) goto L_0x0118
                java.lang.Object r13 = r12.next()
                net.time4j.PlainTime r13 = (net.time4j.PlainTime) r13
                java.util.SortedMap r14 = r1.codeMap
                java.lang.Object r14 = r14.get(r13)
                java.lang.String r14 = (java.lang.String) r14
                boolean r14 = r14.equals(r3)
                if (r14 == 0) goto L_0x0115
                int r14 = getHour12(r17)
                net.time4j.PlainTime r15 = r1.getEnd(r13)
                int r7 = r13.getHour()
                r6 = 12
                if (r7 < r6) goto L_0x00ce
                boolean r6 = r15.isAfter((net.time4j.PlainTime) r13)
                if (r6 != 0) goto L_0x00cb
                net.time4j.PlainTime r6 = net.time4j.PlainTime.midnightAtStartOfDay()
                boolean r6 = r15.isSimultaneous((net.time4j.PlainTime) r6)
                if (r6 == 0) goto L_0x00bb
                goto L_0x00cb
            L_0x00bb:
                if (r14 == r11) goto L_0x00e9
                int r6 = r14 + 12
                int r7 = r13.getHour()
                if (r6 < r7) goto L_0x00c8
                net.time4j.Meridiem r6 = net.time4j.Meridiem.PM
                goto L_0x00ea
            L_0x00c8:
                net.time4j.Meridiem r6 = net.time4j.Meridiem.AM
                goto L_0x00ea
            L_0x00cb:
                net.time4j.Meridiem r6 = net.time4j.Meridiem.PM
                goto L_0x00ea
            L_0x00ce:
                net.time4j.PlainTime r6 = net.time4j.PlainTime.of((int) r6)
                boolean r6 = r15.isAfter((net.time4j.PlainTime) r6)
                if (r6 != 0) goto L_0x00db
                net.time4j.Meridiem r6 = net.time4j.Meridiem.AM
                goto L_0x00ea
            L_0x00db:
                if (r14 == r11) goto L_0x00e9
                int r6 = r13.getHour()
                if (r14 < r6) goto L_0x00e6
                net.time4j.Meridiem r6 = net.time4j.Meridiem.AM
                goto L_0x00ea
            L_0x00e6:
                net.time4j.Meridiem r6 = net.time4j.Meridiem.PM
                goto L_0x00ea
            L_0x00e9:
                r6 = 0
            L_0x00ea:
                if (r6 == 0) goto L_0x0115
                if (r9 == 0) goto L_0x0114
                if (r9 == r6) goto L_0x0114
                if (r14 != r11) goto L_0x00f4
            L_0x00f2:
                r9 = 0
                goto L_0x0115
            L_0x00f4:
                java.lang.String r6 = "night"
                boolean r6 = r3.startsWith(r6)
                r7 = 6
                if (r6 == 0) goto L_0x0105
                if (r14 >= r7) goto L_0x0102
                net.time4j.Meridiem r6 = net.time4j.Meridiem.AM
                goto L_0x0114
            L_0x0102:
                net.time4j.Meridiem r6 = net.time4j.Meridiem.PM
                goto L_0x0114
            L_0x0105:
                java.lang.String r6 = "afternoon"
                boolean r6 = r3.startsWith(r6)
                if (r6 == 0) goto L_0x00f2
                if (r14 >= r7) goto L_0x0112
                net.time4j.Meridiem r6 = net.time4j.Meridiem.PM
                goto L_0x0114
            L_0x0112:
                net.time4j.Meridiem r6 = net.time4j.Meridiem.AM
            L_0x0114:
                r9 = r6
            L_0x0115:
                r6 = 1
                goto L_0x007e
            L_0x0118:
                if (r10 > 0) goto L_0x012b
                if (r9 == 0) goto L_0x0166
                net.time4j.ZonalElement<net.time4j.Meridiem> r1 = net.time4j.PlainTime.AM_PM_OF_DAY
                net.time4j.engine.ChronoEntity r0 = r0.with(r1, r9)
                r3 = 1
                if (r8 <= r3) goto L_0x0166
                r1 = 0
                net.time4j.engine.ChronoEntity r0 = r0.with(r2, r1)
                goto L_0x0166
            L_0x012b:
                r3 = r10
                r6 = 1
                goto L_0x003f
            L_0x012f:
                r3 = 1
                net.time4j.DayPeriod$Element r2 = new net.time4j.DayPeriod$Element
                r2.<init>(r3, r1)
                boolean r1 = r0.contains(r2)
                if (r1 == 0) goto L_0x0166
                java.lang.Object r1 = r0.get(r2)
                java.lang.String r1 = (java.lang.String) r1
                java.lang.String r3 = "am"
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x0159
                boolean r1 = r1.equals(r5)
                if (r1 == 0) goto L_0x0150
                goto L_0x0159
            L_0x0150:
                net.time4j.ZonalElement<net.time4j.Meridiem> r1 = net.time4j.PlainTime.AM_PM_OF_DAY
                net.time4j.Meridiem r3 = net.time4j.Meridiem.PM
                net.time4j.engine.ChronoEntity r0 = r0.with(r1, r3)
                goto L_0x0161
            L_0x0159:
                net.time4j.ZonalElement<net.time4j.Meridiem> r1 = net.time4j.PlainTime.AM_PM_OF_DAY
                net.time4j.Meridiem r3 = net.time4j.Meridiem.AM
                net.time4j.engine.ChronoEntity r0 = r0.with(r1, r3)
            L_0x0161:
                r1 = 0
                net.time4j.engine.ChronoEntity r0 = r0.with(r2, r1)
            L_0x0166:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.DayPeriod.Extension.resolve(net.time4j.engine.ChronoEntity, java.util.Locale, net.time4j.engine.AttributeQuery):net.time4j.engine.ChronoEntity");
        }

        public boolean canResolve(ChronoElement<?> chronoElement) {
            return chronoElement instanceof Element;
        }

        private static int getHour12(ChronoEntity<?> chronoEntity) {
            if (chronoEntity.contains(PlainTime.CLOCK_HOUR_OF_AMPM)) {
                int intValue = ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.CLOCK_HOUR_OF_AMPM)).intValue();
                if (intValue == 12) {
                    return 0;
                }
                return intValue;
            } else if (chronoEntity.contains(PlainTime.DIGITAL_HOUR_OF_AMPM)) {
                return ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.DIGITAL_HOUR_OF_AMPM)).intValue();
            } else {
                return -1;
            }
        }

        private static DayPeriod from(Locale locale, AttributeQuery attributeQuery) {
            if (attributeQuery.contains(DayPeriod.CUSTOM)) {
                return (DayPeriod) attributeQuery.get(DayPeriod.CUSTOM);
            }
            return DayPeriod.of(locale, (String) attributeQuery.get(Attributes.CALENDAR_TYPE, CalendarText.ISO_CALENDAR_TYPE));
        }
    }

    static class Element extends BasicElement<String> implements TextElement<String>, ElementRule<ChronoEntity<?>, String> {
        private static final long serialVersionUID = 5589976208326940032L;
        private final transient DayPeriod dayPeriod;
        private final transient boolean fixed;

        public ChronoElement<?> getChildAtCeiling(ChronoEntity<?> chronoEntity) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(ChronoEntity<?> chronoEntity) {
            return null;
        }

        public boolean isDateElement() {
            return false;
        }

        public boolean isTimeElement() {
            return true;
        }

        public boolean isValid(ChronoEntity<?> chronoEntity, String str) {
            return false;
        }

        Element(boolean z, Locale locale, String str) {
            this(z, DayPeriod.of(locale, str));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Element(boolean z, DayPeriod dayPeriod2) {
            super(z ? "FIXED_DAY_PERIOD" : "APPROXIMATE_DAY_PERIOD");
            this.fixed = z;
            this.dayPeriod = dayPeriod2;
        }

        public Class<String> getType() {
            return String.class;
        }

        public char getSymbol() {
            return this.fixed ? 'b' : 'B';
        }

        public String getDefaultMinimum() {
            if (this.fixed) {
                return "am";
            }
            return (String) this.dayPeriod.codeMap.get((PlainTime) this.dayPeriod.codeMap.firstKey());
        }

        public String getDefaultMaximum() {
            if (this.fixed) {
                return "pm";
            }
            return (String) this.dayPeriod.codeMap.get((PlainTime) this.dayPeriod.codeMap.lastKey());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(32);
            sb.append(name());
            sb.append('@');
            sb.append(this.dayPeriod);
            return sb.toString();
        }

        /* access modifiers changed from: protected */
        public <T extends ChronoEntity<T>> ElementRule<T, String> derive(Chronology<T> chronology) {
            if (chronology.isRegistered(PlainTime.COMPONENT)) {
                return this;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean doEquals(BasicElement<?> basicElement) {
            return this.dayPeriod.equals(((Element) basicElement).dayPeriod);
        }

        public String getValue(ChronoEntity<?> chronoEntity) {
            PlainTime plainTime = (PlainTime) chronoEntity.get((ChronoElement<V>) PlainTime.COMPONENT);
            if (this.fixed) {
                return DayPeriod.getFixedCode(plainTime);
            }
            if (this.dayPeriod.isPredefined()) {
                Map access$400 = DayPeriod.loadTextForms(getLocale(), getCalendarType());
                String str = null;
                if (plainTime.isMidnight()) {
                    str = "midnight";
                } else if (plainTime.isSimultaneous(PlainTime.of(12))) {
                    str = "noon";
                }
                if (str != null && access$400.containsKey(DayPeriod.createKey(access$400, TextWidth.ABBREVIATED, OutputContext.FORMAT, str))) {
                    return str;
                }
            }
            return (String) this.dayPeriod.codeMap.get(this.dayPeriod.getStart(plainTime));
        }

        public String getMinimum(ChronoEntity<?> chronoEntity) {
            return getDefaultMinimum();
        }

        public String getMaximum(ChronoEntity<?> chronoEntity) {
            return getDefaultMaximum();
        }

        public ChronoEntity<?> withValue(ChronoEntity<?> chronoEntity, String str, boolean z) {
            throw new IllegalArgumentException("Day period element cannot be set.");
        }

        /* access modifiers changed from: package-private */
        public boolean isFixed() {
            return this.fixed;
        }

        /* access modifiers changed from: package-private */
        public Locale getLocale() {
            return this.dayPeriod.locale;
        }

        /* access modifiers changed from: package-private */
        public String getCalendarType() {
            return this.dayPeriod.calendarType;
        }

        /* access modifiers changed from: package-private */
        public Object getCodeMap() {
            return this.dayPeriod.codeMap;
        }

        private Object writeReplace() {
            return new SPX(this, 7);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("Serialization proxy required.");
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            String str;
            TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
            OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
            if (this.fixed) {
                str = this.dayPeriod.fixed(textWidth, outputContext).apply(chronoDisplay);
            } else {
                str = this.dayPeriod.approximate(textWidth, outputContext).apply(chronoDisplay);
            }
            appendable.append(str);
        }

        public String parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            int index = parsePosition.getIndex();
            OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
            String parse = parse(charSequence, parsePosition, attributeQuery, outputContext);
            if (parse != null || !((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue()) {
                return parse;
            }
            parsePosition.setErrorIndex(-1);
            parsePosition.setIndex(index);
            return parse(charSequence, parsePosition, attributeQuery, outputContext == OutputContext.FORMAT ? OutputContext.STANDALONE : OutputContext.FORMAT);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String parse(java.lang.CharSequence r23, java.text.ParsePosition r24, net.time4j.engine.AttributeQuery r25, net.time4j.format.OutputContext r26) {
            /*
                r22 = this;
                r0 = r22
                r1 = r24
                r2 = r25
                r3 = r26
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                boolean r5 = r0.fixed
                java.lang.String r6 = "pm"
                java.lang.String r7 = "am"
                java.lang.String r8 = "noon"
                java.lang.String r9 = "midnight"
                if (r5 == 0) goto L_0x0026
                r4.add(r7)
                r4.add(r6)
                r4.add(r9)
                r4.add(r8)
                goto L_0x0046
            L_0x0026:
                java.util.LinkedHashSet r5 = new java.util.LinkedHashSet
                net.time4j.DayPeriod r10 = r0.dayPeriod
                java.util.SortedMap r10 = r10.codeMap
                java.util.Collection r10 = r10.values()
                r5.<init>(r10)
                r4.addAll(r5)
                net.time4j.DayPeriod r5 = r0.dayPeriod
                boolean r5 = r5.isPredefined()
                if (r5 == 0) goto L_0x0046
                r4.add(r9)
                r4.add(r8)
            L_0x0046:
                net.time4j.DayPeriod r5 = r0.dayPeriod
                boolean r5 = r5.isPredefined()
                if (r5 == 0) goto L_0x005b
                java.util.Locale r5 = r22.getLocale()
                java.lang.String r11 = r22.getCalendarType()
                java.util.Map r5 = net.time4j.DayPeriod.loadTextForms(r5, r11)
                goto L_0x005c
            L_0x005b:
                r5 = 0
            L_0x005c:
                net.time4j.engine.AttributeKey<net.time4j.format.TextWidth> r11 = net.time4j.format.Attributes.TEXT_WIDTH
                net.time4j.format.TextWidth r12 = net.time4j.format.TextWidth.WIDE
                java.lang.Object r11 = r2.get(r11, r12)
                net.time4j.format.TextWidth r11 = (net.time4j.format.TextWidth) r11
                net.time4j.engine.AttributeKey<java.lang.Boolean> r12 = net.time4j.format.Attributes.PARSE_CASE_INSENSITIVE
                java.lang.Boolean r13 = java.lang.Boolean.TRUE
                java.lang.Object r12 = r2.get(r12, r13)
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                net.time4j.engine.AttributeKey<java.lang.Boolean> r13 = net.time4j.format.Attributes.PARSE_PARTIAL_COMPARE
                java.lang.Boolean r14 = java.lang.Boolean.FALSE
                java.lang.Object r2 = r2.get(r13, r14)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                int r13 = r24.getIndex()
                int r14 = r23.length()
                java.util.Iterator r4 = r4.iterator()
                r10 = 0
                r15 = 0
            L_0x0090:
                boolean r16 = r4.hasNext()
                if (r16 == 0) goto L_0x0184
                java.lang.Object r16 = r4.next()
                r17 = r4
                r4 = r16
                java.lang.String r4 = (java.lang.String) r4
                net.time4j.DayPeriod r1 = r0.dayPeriod
                boolean r1 = r1.isPredefined()
                if (r1 == 0) goto L_0x00df
                boolean r1 = r0.fixed
                if (r1 == 0) goto L_0x00cc
                java.lang.String r1 = net.time4j.DayPeriod.createKey(r5, r11, r3, r4)
                boolean r16 = r5.containsKey(r1)
                if (r16 != 0) goto L_0x00d0
                boolean r16 = r4.equals(r9)
                if (r16 == 0) goto L_0x00c1
                java.lang.String r1 = net.time4j.DayPeriod.createKey(r5, r11, r3, r7)
                goto L_0x00d0
            L_0x00c1:
                boolean r16 = r4.equals(r8)
                if (r16 == 0) goto L_0x00d0
                java.lang.String r1 = net.time4j.DayPeriod.createKey(r5, r11, r3, r6)
                goto L_0x00d0
            L_0x00cc:
                java.lang.String r1 = net.time4j.DayPeriod.createKey(r5, r11, r3, r4)
            L_0x00d0:
                boolean r16 = r5.containsKey(r1)
                if (r16 == 0) goto L_0x00dd
                java.lang.Object r1 = r5.get(r1)
                java.lang.String r1 = (java.lang.String) r1
                goto L_0x00e0
            L_0x00dd:
                r1 = 0
                goto L_0x00e0
            L_0x00df:
                r1 = r4
            L_0x00e0:
                if (r1 == 0) goto L_0x0170
                int r3 = r1.length()
                r16 = r5
                r19 = r13
                r5 = 0
                r18 = 1
            L_0x00ed:
                if (r18 == 0) goto L_0x0121
                if (r5 >= r3) goto L_0x0121
                r20 = r6
                int r6 = r13 + r5
                if (r6 < r14) goto L_0x00fc
                r21 = r7
                r18 = 0
                goto L_0x011a
            L_0x00fc:
                r21 = r7
                r7 = r23
                char r6 = r7.charAt(r6)
                char r7 = r1.charAt(r5)
                if (r12 == 0) goto L_0x010f
                boolean r6 = r0.compareIgnoreCase(r6, r7)
                goto L_0x0114
            L_0x010f:
                if (r6 != r7) goto L_0x0113
                r6 = 1
                goto L_0x0114
            L_0x0113:
                r6 = 0
            L_0x0114:
                if (r6 == 0) goto L_0x0118
                int r19 = r19 + 1
            L_0x0118:
                r18 = r6
            L_0x011a:
                int r5 = r5 + 1
                r6 = r20
                r7 = r21
                goto L_0x00ed
            L_0x0121:
                r20 = r6
                r21 = r7
                java.lang.String r1 = "|"
                if (r2 != 0) goto L_0x014c
                r5 = 1
                if (r3 != r5) goto L_0x012d
                goto L_0x014c
            L_0x012d:
                if (r18 == 0) goto L_0x0176
                if (r10 != 0) goto L_0x0132
                goto L_0x0150
            L_0x0132:
                boolean r5 = r0.fixed
                if (r5 == 0) goto L_0x0138
                r15 = r3
                goto L_0x015b
            L_0x0138:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r10)
                r5.append(r1)
                r5.append(r4)
                java.lang.String r10 = r5.toString()
                r15 = r3
                goto L_0x0176
            L_0x014c:
                int r3 = r19 - r13
                if (r15 >= r3) goto L_0x0153
            L_0x0150:
                r15 = r3
                r10 = r4
                goto L_0x0176
            L_0x0153:
                if (r10 == 0) goto L_0x0176
                if (r15 != r3) goto L_0x0176
                boolean r3 = r0.fixed
                if (r3 == 0) goto L_0x015d
            L_0x015b:
                r10 = 0
                goto L_0x0176
            L_0x015d:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r10)
                r3.append(r1)
                r3.append(r4)
                java.lang.String r10 = r3.toString()
                goto L_0x0176
            L_0x0170:
                r16 = r5
                r20 = r6
                r21 = r7
            L_0x0176:
                r1 = r24
                r3 = r26
                r5 = r16
                r4 = r17
                r6 = r20
                r7 = r21
                goto L_0x0090
            L_0x0184:
                if (r10 != 0) goto L_0x018c
                r1 = r24
                r1.setErrorIndex(r13)
                goto L_0x0192
            L_0x018c:
                r1 = r24
                int r13 = r13 + r15
                r1.setIndex(r13)
            L_0x0192:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.DayPeriod.Element.parse(java.lang.CharSequence, java.text.ParsePosition, net.time4j.engine.AttributeQuery, net.time4j.format.OutputContext):java.lang.String");
        }

        private boolean compareIgnoreCase(char c, char c2) {
            if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a') + 65);
            }
            if (c2 >= 'a' && c2 <= 'z') {
                c2 = (char) ((c2 - 'a') + 65);
            }
            if (c >= 'A' && c <= 'Z') {
                return c == c2;
            }
            Locale locale = getLocale();
            return String.valueOf(c).toUpperCase(locale).equals(String.valueOf(c2).toUpperCase(locale));
        }
    }

    private class PeriodName implements ChronoFunction<ChronoDisplay, String> {
        private final boolean fixed;
        private final OutputContext outputContext;
        private final TextWidth width;

        PeriodName(boolean z, TextWidth textWidth, OutputContext outputContext2) {
            Objects.requireNonNull(textWidth, "Missing text width.");
            Objects.requireNonNull(outputContext2, "Missing output context.");
            this.fixed = z;
            this.width = textWidth;
            this.outputContext = outputContext2;
        }

        public String apply(ChronoDisplay chronoDisplay) {
            PlainTime plainTime = (PlainTime) chronoDisplay.get(PlainTime.COMPONENT);
            DayPeriod dayPeriod = DayPeriod.this;
            Locale access$600 = dayPeriod.locale;
            if (this.fixed) {
                String access$300 = DayPeriod.getFixedCode(plainTime);
                if (!dayPeriod.isPredefined()) {
                    return access$300;
                }
                Map access$400 = DayPeriod.loadTextForms(access$600, dayPeriod.calendarType);
                String access$500 = DayPeriod.createKey(access$400, this.width, this.outputContext, access$300);
                if (!access$400.containsKey(access$500)) {
                    if (access$300.equals("midnight")) {
                        access$500 = DayPeriod.createKey(access$400, this.width, this.outputContext, "am");
                    } else if (access$300.equals("noon")) {
                        access$500 = DayPeriod.createKey(access$400, this.width, this.outputContext, "pm");
                    }
                }
                if (access$400.containsKey(access$500)) {
                    return (String) access$400.get(access$500);
                }
            } else if (!dayPeriod.isPredefined()) {
                return (String) dayPeriod.codeMap.get(dayPeriod.getStart(plainTime));
            } else {
                Map access$4002 = DayPeriod.loadTextForms(access$600, dayPeriod.calendarType);
                if (plainTime.isMidnight()) {
                    String access$5002 = DayPeriod.createKey(access$4002, this.width, this.outputContext, "midnight");
                    if (access$4002.containsKey(access$5002)) {
                        return (String) access$4002.get(access$5002);
                    }
                } else if (plainTime.isSimultaneous(PlainTime.of(12))) {
                    String access$5003 = DayPeriod.createKey(access$4002, this.width, this.outputContext, "noon");
                    if (access$4002.containsKey(access$5003)) {
                        return (String) access$4002.get(access$5003);
                    }
                }
                String access$5004 = DayPeriod.createKey(access$4002, this.width, this.outputContext, (String) dayPeriod.codeMap.get(dayPeriod.getStart(plainTime)));
                if (access$4002.containsKey(access$5004)) {
                    return (String) access$4002.get(access$5004);
                }
            }
            Meridiem meridiem = (Meridiem) plainTime.get(PlainTime.AM_PM_OF_DAY);
            if (access$600 == null) {
                access$600 = Locale.ROOT;
            }
            return meridiem.getDisplayName(access$600);
        }
    }
}
