package net.time4j.format.expert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.UnixTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.expert.ZoneLabels;
import net.time4j.tz.NameStyle;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

final class TimezoneNameProcessor implements FormatProcessor<TZID> {
    private static final ConcurrentMap<Locale, TZNames> CACHE_ABBREVIATIONS = new ConcurrentHashMap();
    private static final ConcurrentMap<Locale, TZNames> CACHE_ZONENAMES = new ConcurrentHashMap();
    private static final String DEFAULT_PROVIDER = "DEFAULT";
    private static final int MAX = 25;
    private final boolean abbreviated;
    private final FormatProcessor<TZID> fallback;
    private final Leniency lenientMode;
    private final Locale locale;
    private final Set<TZID> preferredZones;
    private final int protectedLength;

    public boolean isNumerical() {
        return false;
    }

    public FormatProcessor<TZID> withElement(ChronoElement<TZID> chronoElement) {
        return this;
    }

    TimezoneNameProcessor(boolean z) {
        this.abbreviated = z;
        this.fallback = new LocalizedGMTProcessor(z);
        this.preferredZones = null;
        this.lenientMode = Leniency.SMART;
        this.locale = Locale.ROOT;
        this.protectedLength = 0;
    }

    TimezoneNameProcessor(boolean z, Set<TZID> set) {
        this.abbreviated = z;
        this.fallback = new LocalizedGMTProcessor(z);
        this.preferredZones = Collections.unmodifiableSet(new LinkedHashSet(set));
        this.lenientMode = Leniency.SMART;
        this.locale = Locale.ROOT;
        this.protectedLength = 0;
    }

    private TimezoneNameProcessor(boolean z, FormatProcessor<TZID> formatProcessor, Set<TZID> set, Leniency leniency, Locale locale2, int i) {
        this.abbreviated = z;
        this.fallback = formatProcessor;
        this.preferredZones = set;
        this.lenientMode = leniency;
        this.locale = locale2;
        this.protectedLength = i;
    }

    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        Locale locale2;
        if (chronoDisplay.hasTimezone()) {
            TZID timezone = chronoDisplay.getTimezone();
            if (timezone instanceof ZonalOffset) {
                return this.fallback.print(chronoDisplay, appendable, attributeQuery, set, z);
            }
            if (chronoDisplay instanceof UnixTime) {
                Timezone of = Timezone.of(timezone);
                NameStyle style = getStyle(of.isDaylightSaving(UnixTime.class.cast(chronoDisplay)));
                if (z) {
                    locale2 = this.locale;
                } else {
                    locale2 = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
                }
                String displayName = of.getDisplayName(style, locale2);
                int length = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
                appendable.append(displayName);
                int length2 = displayName.length();
                if (!(length == -1 || length2 <= 0 || set == null)) {
                    set.add(new ElementPosition(TimezoneElement.TIMEZONE_ID, length, length + length2));
                }
                return length2;
            }
            throw new IllegalArgumentException("Cannot extract timezone name from: " + chronoDisplay);
        }
        throw new IllegalArgumentException("Cannot extract timezone name from: " + chronoDisplay);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r11v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.CharSequence r19, net.time4j.format.expert.ParseLog r20, net.time4j.engine.AttributeQuery r21, net.time4j.format.expert.ParsedEntity<?> r22, boolean r23) {
        /*
            r18 = this;
            r0 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            int r1 = r20.getPosition()
            int r6 = r19.length()
            r12 = 0
            if (r23 == 0) goto L_0x0018
            int r7 = r0.protectedLength
            goto L_0x0028
        L_0x0018:
            net.time4j.engine.AttributeKey<java.lang.Integer> r7 = net.time4j.format.Attributes.PROTECTED_CHARACTERS
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            java.lang.Object r7 = r4.get(r7, r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
        L_0x0028:
            if (r7 <= 0) goto L_0x002b
            int r6 = r6 - r7
        L_0x002b:
            if (r1 < r6) goto L_0x0033
            java.lang.String r2 = "Missing timezone name."
            r3.setError(r1, r2)
            return
        L_0x0033:
            if (r23 == 0) goto L_0x0038
            java.util.Locale r7 = r0.locale
            goto L_0x0042
        L_0x0038:
            net.time4j.engine.AttributeKey<java.util.Locale> r7 = net.time4j.format.Attributes.LANGUAGE
            java.util.Locale r8 = java.util.Locale.ROOT
            java.lang.Object r7 = r4.get(r7, r8)
            java.util.Locale r7 = (java.util.Locale) r7
        L_0x0042:
            r13 = r7
            if (r23 == 0) goto L_0x0048
            net.time4j.format.Leniency r7 = r0.lenientMode
            goto L_0x0052
        L_0x0048:
            net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r7 = net.time4j.format.Attributes.LENIENCY
            net.time4j.format.Leniency r8 = net.time4j.format.Leniency.SMART
            java.lang.Object r7 = r4.get(r7, r8)
            net.time4j.format.Leniency r7 = (net.time4j.format.Leniency) r7
        L_0x0052:
            r14 = r7
            java.lang.String r15 = r0.extractRelevantKey(r2, r1, r6)
            java.lang.String r7 = "GMT"
            boolean r7 = r15.startsWith(r7)
            if (r7 != 0) goto L_0x0273
            java.lang.String r7 = "UT"
            boolean r7 = r15.startsWith(r7)
            if (r7 == 0) goto L_0x0069
            goto L_0x0273
        L_0x0069:
            boolean r7 = r0.abbreviated
            if (r7 == 0) goto L_0x0070
            java.util.concurrent.ConcurrentMap<java.util.Locale, net.time4j.format.expert.TimezoneNameProcessor$TZNames> r7 = CACHE_ABBREVIATIONS
            goto L_0x0072
        L_0x0070:
            java.util.concurrent.ConcurrentMap<java.util.Locale, net.time4j.format.expert.TimezoneNameProcessor$TZNames> r7 = CACHE_ZONENAMES
        L_0x0072:
            java.lang.Object r8 = r7.get(r13)
            net.time4j.format.expert.TimezoneNameProcessor$TZNames r8 = (net.time4j.format.expert.TimezoneNameProcessor.TZNames) r8
            r11 = 1
            if (r8 != 0) goto L_0x009a
            net.time4j.format.expert.ZoneLabels r8 = r0.createZoneNames(r13, r12)
            net.time4j.format.expert.ZoneLabels r9 = r0.createZoneNames(r13, r11)
            net.time4j.format.expert.TimezoneNameProcessor$TZNames r10 = new net.time4j.format.expert.TimezoneNameProcessor$TZNames
            r10.<init>(r8, r9)
            int r8 = r7.size()
            r9 = 25
            if (r8 >= r9) goto L_0x009b
            java.lang.Object r7 = r7.putIfAbsent(r13, r10)
            net.time4j.format.expert.TimezoneNameProcessor$TZNames r7 = (net.time4j.format.expert.TimezoneNameProcessor.TZNames) r7
            if (r7 == 0) goto L_0x009b
            r10 = r7
            goto L_0x009b
        L_0x009a:
            r10 = r8
        L_0x009b:
            java.util.ArrayList r16 = new java.util.ArrayList
            r16.<init>()
            java.util.ArrayList r17 = new java.util.ArrayList
            r17.<init>()
            r9 = 2
            int[] r8 = new int[r9]
            java.lang.CharSequence r7 = r2.subSequence(r12, r6)
            r6 = r10
            r2 = r8
            r8 = r1
            r10 = 2
            r9 = r16
            r12 = 2
            r10 = r17
            r12 = 1
            r11 = r2
            r6.search(r7, r8, r9, r10, r11)
            int r6 = r16.size()
            int r7 = r17.size()
            int r6 = r6 + r7
            if (r6 != 0) goto L_0x00df
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "\""
            r2.append(r4)
            r2.append(r15)
            java.lang.String r4 = "\" does not match any known timezone name."
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r3.setError(r1, r2)
            return
        L_0x00df:
            if (r6 <= r12) goto L_0x00f8
            boolean r7 = r14.isStrict()
            if (r7 != 0) goto L_0x00f8
            java.util.List r16 = excludeWinZones(r16)
            java.util.List r17 = excludeWinZones(r17)
            int r6 = r16.size()
            int r7 = r17.size()
            int r6 = r6 + r7
        L_0x00f8:
            if (r6 <= r12) goto L_0x0183
            boolean r6 = r14.isLax()
            if (r6 != 0) goto L_0x0183
            net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r6 = net.time4j.format.Attributes.TIMEZONE_ID
            net.time4j.tz.ZonalOffset r7 = net.time4j.tz.ZonalOffset.UTC
            java.lang.Object r4 = r4.get(r6, r7)
            net.time4j.tz.TZID r4 = (net.time4j.tz.TZID) r4
            boolean r6 = r4 instanceof net.time4j.tz.ZonalOffset
            if (r6 != 0) goto L_0x0167
            java.util.Iterator r6 = r16.iterator()
        L_0x0112:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0136
            java.lang.Object r7 = r6.next()
            net.time4j.tz.TZID r7 = (net.time4j.tz.TZID) r7
            java.lang.String r8 = r7.canonical()
            java.lang.String r9 = r4.canonical()
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0112
            java.util.List r6 = java.util.Collections.singletonList(r7)
            java.util.List r7 = java.util.Collections.emptyList()
            r11 = 1
            goto L_0x013b
        L_0x0136:
            r6 = r16
            r7 = r17
            r11 = 0
        L_0x013b:
            if (r11 != 0) goto L_0x016c
            java.util.Iterator r8 = r7.iterator()
        L_0x0141:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x016c
            java.lang.Object r9 = r8.next()
            net.time4j.tz.TZID r9 = (net.time4j.tz.TZID) r9
            java.lang.String r10 = r9.canonical()
            java.lang.String r12 = r4.canonical()
            boolean r10 = r10.equals(r12)
            if (r10 == 0) goto L_0x0165
            java.util.List r6 = java.util.Collections.emptyList()
            java.util.List r7 = java.util.Collections.singletonList(r9)
            r11 = 1
            goto L_0x016c
        L_0x0165:
            r12 = 1
            goto L_0x0141
        L_0x0167:
            r6 = r16
            r7 = r17
            r11 = 0
        L_0x016c:
            if (r11 != 0) goto L_0x0187
            int r4 = r6.size()
            if (r4 <= 0) goto L_0x0178
            java.util.List r6 = r0.resolveUsingPreferred(r6, r13, r14)
        L_0x0178:
            int r4 = r7.size()
            if (r4 <= 0) goto L_0x0187
            java.util.List r7 = r0.resolveUsingPreferred(r7, r13, r14)
            goto L_0x0187
        L_0x0183:
            r6 = r16
            r7 = r17
        L_0x0187:
            int r4 = r6.size()
            int r8 = r7.size()
            int r4 = r4 + r8
            if (r4 != 0) goto L_0x01ec
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r4 = r16.iterator()
        L_0x019b:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01af
            java.lang.Object r5 = r4.next()
            net.time4j.tz.TZID r5 = (net.time4j.tz.TZID) r5
            java.lang.String r5 = r5.canonical()
            r2.add(r5)
            goto L_0x019b
        L_0x01af:
            java.util.Iterator r4 = r17.iterator()
        L_0x01b3:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01c7
            java.lang.Object r5 = r4.next()
            net.time4j.tz.TZID r5 = (net.time4j.tz.TZID) r5
            java.lang.String r5 = r5.canonical()
            r2.add(r5)
            goto L_0x01b3
        L_0x01c7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Time zone name \""
            r4.append(r5)
            r4.append(r15)
            java.lang.String r5 = "\" not found among preferred timezones in locale "
            r4.append(r5)
            r4.append(r13)
            java.lang.String r5 = ", candidates="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.setError(r1, r2)
            return
        L_0x01ec:
            int r8 = r6.size()
            if (r8 <= 0) goto L_0x0229
            r8 = 2
            if (r4 != r8) goto L_0x0218
            int r4 = r7.size()
            r8 = 1
            if (r4 != r8) goto L_0x0218
            r4 = 0
            java.lang.Object r8 = r6.get(r4)
            net.time4j.tz.TZID r8 = (net.time4j.tz.TZID) r8
            java.lang.String r8 = r8.canonical()
            java.lang.Object r9 = r7.get(r4)
            net.time4j.tz.TZID r9 = (net.time4j.tz.TZID) r9
            java.lang.String r4 = r9.canonical()
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0218
            goto L_0x0227
        L_0x0218:
            boolean r4 = r7.isEmpty()
            if (r4 != 0) goto L_0x0227
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r6)
            r4.addAll(r7)
            r6 = r4
        L_0x0227:
            r11 = 0
            goto L_0x022b
        L_0x0229:
            r6 = r7
            r11 = 1
        L_0x022b:
            int r4 = r6.size()
            r7 = 1
            if (r4 == r7) goto L_0x025a
            boolean r4 = r14.isLax()
            if (r4 == 0) goto L_0x0239
            goto L_0x025a
        L_0x0239:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "Time zone name is not unique: \""
            r2.append(r4)
            r2.append(r15)
            java.lang.String r4 = "\" in "
            r2.append(r4)
            java.lang.String r4 = toString(r6)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r3.setError(r1, r2)
            goto L_0x0272
        L_0x025a:
            net.time4j.format.expert.TimezoneElement r1 = net.time4j.format.expert.TimezoneElement.TIMEZONE_ID
            r4 = 0
            java.lang.Object r4 = r6.get(r4)
            r5.put((net.time4j.engine.ChronoElement<?>) r1, (java.lang.Object) r4)
            net.time4j.engine.FlagElement r1 = net.time4j.engine.FlagElement.DAYLIGHT_SAVING
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r11)
            r5.put((net.time4j.engine.ChronoElement<?>) r1, (java.lang.Object) r4)
            r1 = r2[r11]
            r3.setPosition(r1)
        L_0x0272:
            return
        L_0x0273:
            net.time4j.format.expert.FormatProcessor<net.time4j.tz.TZID> r1 = r0.fallback
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r1.parse(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.TimezoneNameProcessor.parse(java.lang.CharSequence, net.time4j.format.expert.ParseLog, net.time4j.engine.AttributeQuery, net.time4j.format.expert.ParsedEntity, boolean):void");
    }

    public ChronoElement<TZID> getElement() {
        return TimezoneElement.TIMEZONE_ID;
    }

    public FormatProcessor<TZID> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new TimezoneNameProcessor(this.abbreviated, this.fallback, this.preferredZones, (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART), (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimezoneNameProcessor)) {
            return false;
        }
        TimezoneNameProcessor timezoneNameProcessor = (TimezoneNameProcessor) obj;
        if (this.abbreviated == timezoneNameProcessor.abbreviated) {
            Set<TZID> set = this.preferredZones;
            Set<TZID> set2 = timezoneNameProcessor.preferredZones;
            if (set == null) {
                if (set2 == null) {
                    return true;
                }
            } else if (set.equals(set2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Set<TZID> set = this.preferredZones;
        return (set == null ? 0 : set.hashCode()) + (this.abbreviated ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[abbreviated=");
        sb.append(this.abbreviated);
        sb.append(", preferredZones=");
        sb.append(this.preferredZones);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    private String extractRelevantKey(CharSequence charSequence, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = charSequence.charAt(i3);
            if (!Character.isLetter(charAt) && (this.abbreviated || i3 <= i || Character.isDigit(charAt))) {
                break;
            }
            sb.append(charAt);
        }
        return sb.toString().trim();
    }

    private ZoneLabels createZoneNames(Locale locale2, boolean z) {
        NameStyle style = getStyle(z);
        ZoneLabels.Node node = null;
        for (TZID next : Timezone.getAvailableIDs()) {
            String displayName = Timezone.getDisplayName(next, style, locale2);
            if (!displayName.equals(next.canonical())) {
                node = ZoneLabels.insert(node, displayName, next);
            }
        }
        return new ZoneLabels(node);
    }

    private static List<TZID> excludeWinZones(List<TZID> list) {
        if (list.size() > 1) {
            ArrayList arrayList = new ArrayList(list);
            int size = list.size();
            for (int i = 1; i < size; i++) {
                TZID tzid = list.get(i);
                if (tzid.canonical().startsWith("WINDOWS~")) {
                    arrayList.remove(tzid);
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return list;
    }

    private List<TZID> resolveUsingPreferred(List<TZID> list, Locale locale2, Leniency leniency) {
        boolean z;
        HashMap hashMap = new HashMap();
        hashMap.put(DEFAULT_PROVIDER, new ArrayList());
        Iterator<TZID> it = list.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            String canonical = it.next().canonical();
            Set<TZID> set = this.preferredZones;
            int indexOf = canonical.indexOf(126);
            String substring = indexOf >= 0 ? canonical.substring(0, indexOf) : DEFAULT_PROVIDER;
            if (set == null) {
                set = Timezone.getPreferredIDs(locale2, leniency.isSmart(), substring);
            }
            Iterator<TZID> it2 = set.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                TZID next = it2.next();
                if (next.canonical().equals(canonical)) {
                    List list2 = (List) hashMap.get(substring);
                    if (list2 == null) {
                        list2 = new ArrayList();
                        hashMap.put(substring, list2);
                    }
                    list2.add(next);
                }
            }
        }
        List<TZID> list3 = (List) hashMap.get(DEFAULT_PROVIDER);
        if (!list3.isEmpty()) {
            return list3;
        }
        hashMap.remove(DEFAULT_PROVIDER);
        Iterator it3 = hashMap.keySet().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            List<TZID> list4 = (List) hashMap.get((String) it3.next());
            if (!list4.isEmpty()) {
                z = true;
                list = list4;
                break;
            }
        }
        if (!z) {
            list = Collections.emptyList();
        }
        return list;
    }

    private NameStyle getStyle(boolean z) {
        return z ? this.abbreviated ? NameStyle.SHORT_DAYLIGHT_TIME : NameStyle.LONG_DAYLIGHT_TIME : this.abbreviated ? NameStyle.SHORT_STANDARD_TIME : NameStyle.LONG_STANDARD_TIME;
    }

    private static String toString(List<TZID> list) {
        StringBuilder sb = new StringBuilder(list.size() * 16);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (TZID next : list) {
            if (z) {
                z = false;
            } else {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(next.canonical());
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    private static class TZNames {
        private final ZoneLabels dstNames;
        private final ZoneLabels stdNames;

        TZNames(ZoneLabels zoneLabels, ZoneLabels zoneLabels2) {
            this.stdNames = zoneLabels;
            this.dstNames = zoneLabels2;
        }

        /* access modifiers changed from: package-private */
        public void search(CharSequence charSequence, int i, List<TZID> list, List<TZID> list2, int[] iArr) {
            String longestPrefixOf = this.stdNames.longestPrefixOf(charSequence, i);
            int length = longestPrefixOf.length();
            iArr[0] = i + length;
            String longestPrefixOf2 = this.dstNames.longestPrefixOf(charSequence, i);
            int length2 = longestPrefixOf2.length();
            iArr[1] = i + length2;
            if (length2 > length) {
                list2.addAll(this.dstNames.find(longestPrefixOf2));
            } else if (length2 < length) {
                list.addAll(this.stdNames.find(longestPrefixOf));
            } else if (length > 0) {
                list.addAll(this.stdNames.find(longestPrefixOf));
                list2.addAll(this.dstNames.find(longestPrefixOf2));
            }
        }
    }
}
