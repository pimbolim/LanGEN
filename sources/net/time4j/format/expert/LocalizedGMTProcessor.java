package net.time4j.format.expert;

import androidx.core.app.NotificationManagerCompat;
import java.io.IOException;
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
import net.time4j.tz.OffsetSign;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;
import org.apache.commons.lang3.time.TimeZones;

final class LocalizedGMTProcessor implements FormatProcessor<TZID> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ZonalOffset PROTOTYPE = ZonalOffset.ofTotalSeconds(64800);
    private static final ConcurrentMap<Locale, Info> STD_PATTERN_INFOS = new ConcurrentHashMap();
    private static final ConcurrentMap<Locale, String> UTC_LITERALS = new ConcurrentHashMap();
    private final boolean abbreviated;
    private final boolean caseInsensitive;
    private final Leniency lenientMode;
    private final Locale locale;
    private final String minusSign;
    private final boolean noPrefix;
    private final String plusSign;
    private final char zeroDigit;

    public boolean isNumerical() {
        return false;
    }

    public FormatProcessor<TZID> withElement(ChronoElement<TZID> chronoElement) {
        return this;
    }

    LocalizedGMTProcessor(boolean z) {
        this(z, true, false, Locale.ROOT, "+", "-", '0', Leniency.SMART);
    }

    private LocalizedGMTProcessor(boolean z, boolean z2, boolean z3, Locale locale2, String str, String str2, char c, Leniency leniency) {
        this.abbreviated = z;
        this.caseInsensitive = z2;
        this.noPrefix = z3;
        this.locale = locale2;
        this.plusSign = str;
        this.minusSign = str2;
        this.zeroDigit = c;
        this.lenientMode = leniency;
    }

    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        ZonalOffset zonalOffset;
        char c;
        boolean z2;
        int i;
        ZonalOffset zonalOffset2;
        int i2;
        ChronoDisplay chronoDisplay2 = chronoDisplay;
        Appendable appendable2 = appendable;
        AttributeQuery attributeQuery2 = attributeQuery;
        Set<ElementPosition> set2 = set;
        int length = appendable2 instanceof CharSequence ? ((CharSequence) appendable2).length() : -1;
        TZID tzid = null;
        if (chronoDisplay.hasTimezone()) {
            tzid = chronoDisplay.getTimezone();
        }
        if (tzid == null) {
            zonalOffset = getOffset(chronoDisplay2, attributeQuery2);
        } else if (tzid instanceof ZonalOffset) {
            zonalOffset = (ZonalOffset) tzid;
        } else if (chronoDisplay2 instanceof UnixTime) {
            zonalOffset = Timezone.of(tzid).getOffset((UnixTime) chronoDisplay2);
        } else {
            throw new IllegalArgumentException("Cannot extract timezone offset from: " + chronoDisplay2);
        }
        Locale locale2 = z ? this.locale : (Locale) attributeQuery2.get(Attributes.LANGUAGE, Locale.ROOT);
        if (z) {
            c = this.zeroDigit;
        } else {
            c = ((Character) attributeQuery2.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        String str = z ? this.plusSign : (String) attributeQuery2.get(AttributeSet.PLUS_SIGN, "+");
        String str2 = z ? this.minusSign : (String) attributeQuery2.get(AttributeSet.MINUS_SIGN, "-");
        if (z) {
            z2 = this.noPrefix;
        } else {
            z2 = ((Boolean) attributeQuery2.get(Attributes.NO_GMT_PREFIX, Boolean.FALSE)).booleanValue();
        }
        int integralAmount = zonalOffset.getIntegralAmount();
        int fractionalAmount = zonalOffset.getFractionalAmount();
        if (!z2 && integralAmount == 0 && fractionalAmount == 0) {
            String literalUTC = getLiteralUTC(locale2);
            appendable2.append(literalUTC);
            i = literalUTC.length();
        } else {
            Info patternInfo = getPatternInfo(locale2);
            int length2 = patternInfo.pattern.length();
            int i3 = 0;
            int i4 = 0;
            while (i4 < length2) {
                char charAt = patternInfo.pattern.charAt(i4);
                if (patternInfo.start > i4 || patternInfo.end <= i4) {
                    zonalOffset2 = zonalOffset;
                    if (!z2) {
                        appendable2.append(charAt);
                        i3++;
                    }
                } else {
                    if (zonalOffset.getSign() == OffsetSign.BEHIND_UTC) {
                        appendable2.append(str2);
                        i2 = str2.length();
                    } else {
                        appendable2.append(str);
                        i2 = str.length();
                    }
                    int i5 = i3 + i2;
                    int absoluteHours = zonalOffset.getAbsoluteHours();
                    int absoluteMinutes = zonalOffset.getAbsoluteMinutes();
                    int absoluteSeconds = zonalOffset.getAbsoluteSeconds();
                    if (absoluteHours < 10 && !this.abbreviated) {
                        appendable2.append(c);
                        i5++;
                    }
                    String valueOf = String.valueOf(absoluteHours);
                    zonalOffset2 = zonalOffset;
                    for (int i6 = 0; i6 < valueOf.length(); i6++) {
                        appendable2.append((char) ((valueOf.charAt(i6) - '0') + c));
                        i5 = i3 + 1;
                    }
                    if (!(absoluteMinutes == 0 && absoluteSeconds == 0 && this.abbreviated)) {
                        appendable2.append(patternInfo.separator);
                        int length3 = i3 + patternInfo.separator.length();
                        if (absoluteMinutes < 10) {
                            appendable2.append(c);
                            length3++;
                        }
                        String valueOf2 = String.valueOf(absoluteMinutes);
                        for (int i7 = 0; i7 < valueOf2.length(); i7++) {
                            appendable2.append((char) ((valueOf2.charAt(i7) - '0') + c));
                            length3 = i3 + 1;
                        }
                        if (absoluteSeconds != 0) {
                            appendable2.append(patternInfo.separator);
                            i3 += patternInfo.separator.length();
                            if (absoluteSeconds < 10) {
                                appendable2.append(c);
                                i3++;
                            }
                            String valueOf3 = String.valueOf(absoluteSeconds);
                            for (int i8 = 0; i8 < valueOf3.length(); i8++) {
                                appendable2.append((char) ((valueOf3.charAt(i8) - '0') + c));
                                i3++;
                            }
                        }
                    }
                    i4 = patternInfo.end - 1;
                }
                i4++;
                zonalOffset = zonalOffset2;
            }
            i = i3;
        }
        if (!(length == -1 || i <= 0 || set2 == null)) {
            set2.add(new ElementPosition(TimezoneElement.TIMEZONE_ID, length, length + i));
        }
        return i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: net.time4j.format.Leniency} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.CharSequence r26, net.time4j.format.expert.ParseLog r27, net.time4j.engine.AttributeQuery r28, net.time4j.format.expert.ParsedEntity<?> r29, boolean r30) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = r28
            r4 = r29
            int r5 = r26.length()
            int r6 = r27.getPosition()
            if (r6 < r5) goto L_0x001a
            java.lang.String r1 = "Missing localized time zone offset."
            r2.setError(r6, r1)
            return
        L_0x001a:
            if (r30 == 0) goto L_0x001f
            java.util.Locale r7 = r0.locale
            goto L_0x0029
        L_0x001f:
            net.time4j.engine.AttributeKey<java.util.Locale> r7 = net.time4j.format.Attributes.LANGUAGE
            java.util.Locale r8 = java.util.Locale.ROOT
            java.lang.Object r7 = r3.get(r7, r8)
            java.util.Locale r7 = (java.util.Locale) r7
        L_0x0029:
            boolean r8 = net.time4j.format.CalendarText.isRTL(r7)
            if (r30 == 0) goto L_0x0032
            boolean r9 = r0.noPrefix
            goto L_0x0040
        L_0x0032:
            net.time4j.engine.AttributeKey<java.lang.Boolean> r9 = net.time4j.format.Attributes.NO_GMT_PREFIX
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            java.lang.Object r9 = r3.get(r9, r10)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
        L_0x0040:
            if (r30 == 0) goto L_0x0045
            boolean r10 = r0.caseInsensitive
            goto L_0x0053
        L_0x0045:
            net.time4j.engine.AttributeKey<java.lang.Boolean> r10 = net.time4j.format.Attributes.PARSE_CASE_INSENSITIVE
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            java.lang.Object r10 = r3.get(r10, r11)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
        L_0x0053:
            if (r30 == 0) goto L_0x0058
            char r11 = r0.zeroDigit
            goto L_0x006a
        L_0x0058:
            net.time4j.engine.AttributeKey<java.lang.Character> r11 = net.time4j.format.Attributes.ZERO_DIGIT
            r12 = 48
            java.lang.Character r12 = java.lang.Character.valueOf(r12)
            java.lang.Object r11 = r3.get(r11, r12)
            java.lang.Character r11 = (java.lang.Character) r11
            char r11 = r11.charValue()
        L_0x006a:
            if (r30 == 0) goto L_0x006f
            java.lang.String r12 = r0.plusSign
            goto L_0x0079
        L_0x006f:
            net.time4j.engine.AttributeKey<java.lang.String> r12 = net.time4j.format.expert.AttributeSet.PLUS_SIGN
            java.lang.String r13 = "+"
            java.lang.Object r12 = r3.get(r12, r13)
            java.lang.String r12 = (java.lang.String) r12
        L_0x0079:
            if (r30 == 0) goto L_0x007e
            java.lang.String r13 = r0.minusSign
            goto L_0x0088
        L_0x007e:
            net.time4j.engine.AttributeKey<java.lang.String> r13 = net.time4j.format.expert.AttributeSet.MINUS_SIGN
            java.lang.String r14 = "-"
            java.lang.Object r13 = r3.get(r13, r14)
            java.lang.String r13 = (java.lang.String) r13
        L_0x0088:
            net.time4j.format.expert.LocalizedGMTProcessor$Info r14 = getPatternInfo(r7)
            java.lang.String r15 = r14.pattern
            int r15 = r15.length()
            r16 = 0
            r17 = 0
            r0 = r6
            r18 = r16
            r3 = 0
        L_0x009c:
            if (r3 >= r15) goto L_0x020e
            r16 = r15
            java.lang.String r15 = r14.pattern
            char r15 = r15.charAt(r3)
            r19 = r15
            int r15 = r14.start
            if (r15 > r3) goto L_0x01bb
            int r15 = r14.end
            if (r15 > r3) goto L_0x00b8
            goto L_0x01bb
        L_0x00b8:
            int r3 = net.time4j.format.expert.LiteralProcessor.subSequenceEquals(r1, r0, r12, r10, r8)
            r15 = -1
            if (r3 != r15) goto L_0x00e4
            int r3 = net.time4j.format.expert.LiteralProcessor.subSequenceEquals(r1, r0, r13, r10, r8)
            if (r3 != r15) goto L_0x00e1
            if (r9 == 0) goto L_0x00c8
            goto L_0x00cc
        L_0x00c8:
            int r17 = parseUTC(r1, r5, r6, r7, r10)
        L_0x00cc:
            if (r17 <= 0) goto L_0x00db
            net.time4j.format.expert.TimezoneElement r0 = net.time4j.format.expert.TimezoneElement.TIMEZONE_OFFSET
            net.time4j.tz.ZonalOffset r1 = net.time4j.tz.ZonalOffset.UTC
            r4.put((net.time4j.engine.ChronoElement<?>) r0, (java.lang.Object) r1)
            int r6 = r6 + r17
            r2.setPosition(r6)
            return
        L_0x00db:
            java.lang.String r0 = "Missing sign in localized time zone offset."
            r2.setError(r6, r0)
            return
        L_0x00e1:
            net.time4j.tz.OffsetSign r18 = net.time4j.tz.OffsetSign.BEHIND_UTC
            goto L_0x00e6
        L_0x00e4:
            net.time4j.tz.OffsetSign r18 = net.time4j.tz.OffsetSign.AHEAD_OF_UTC
        L_0x00e6:
            r15 = r18
            int r0 = r0 + r3
            int r3 = parseHours(r1, r0, r11)
            r20 = r12
            r12 = -1000(0xfffffffffffffc18, float:NaN)
            if (r3 != r12) goto L_0x00f9
            java.lang.String r1 = "Missing hour part in localized time zone offset."
            r2.setError(r0, r1)
            return
        L_0x00f9:
            if (r3 >= 0) goto L_0x00ff
            int r3 = ~r3
            int r0 = r0 + 1
            goto L_0x0101
        L_0x00ff:
            int r0 = r0 + 2
        L_0x0101:
            if (r0 < r5) goto L_0x011c
            r12 = r25
            boolean r1 = r12.abbreviated
            if (r1 == 0) goto L_0x0116
            net.time4j.format.expert.TimezoneElement r1 = net.time4j.format.expert.TimezoneElement.TIMEZONE_OFFSET
            net.time4j.tz.ZonalOffset r3 = net.time4j.tz.ZonalOffset.ofHours(r15, r3)
            r4.put((net.time4j.engine.ChronoElement<?>) r1, (java.lang.Object) r3)
            r2.setPosition(r0)
            goto L_0x011b
        L_0x0116:
            java.lang.String r1 = "Missing minute part in localized time zone offset."
            r2.setError(r0, r1)
        L_0x011b:
            return
        L_0x011c:
            r12 = r25
            r21 = r13
            if (r30 == 0) goto L_0x012b
            net.time4j.format.Leniency r13 = r12.lenientMode
            r22 = r6
            r23 = r7
            r7 = r28
            goto L_0x013c
        L_0x012b:
            net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r13 = net.time4j.format.Attributes.LENIENCY
            r22 = r6
            net.time4j.format.Leniency r6 = net.time4j.format.Leniency.SMART
            r23 = r7
            r7 = r28
            java.lang.Object r6 = r7.get(r13, r6)
            r13 = r6
            net.time4j.format.Leniency r13 = (net.time4j.format.Leniency) r13
        L_0x013c:
            java.lang.String r6 = r14.separator
            int r6 = net.time4j.format.expert.LiteralProcessor.subSequenceEquals(r1, r0, r6, r10, r8)
            r7 = -1
            if (r6 == r7) goto L_0x0149
            int r0 = r0 + r6
            goto L_0x0166
        L_0x0149:
            boolean r6 = r12.abbreviated
            if (r6 == 0) goto L_0x015a
            net.time4j.format.expert.TimezoneElement r1 = net.time4j.format.expert.TimezoneElement.TIMEZONE_OFFSET
            net.time4j.tz.ZonalOffset r3 = net.time4j.tz.ZonalOffset.ofHours(r15, r3)
            r4.put((net.time4j.engine.ChronoElement<?>) r1, (java.lang.Object) r3)
            r2.setPosition(r0)
            return
        L_0x015a:
            boolean r6 = r13.isStrict()
            if (r6 == 0) goto L_0x0166
            java.lang.String r1 = "Mismatch of localized time zone offset separator."
            r2.setError(r0, r1)
            return
        L_0x0166:
            int r6 = parseTwoDigits(r1, r0, r11)
            r7 = -1000(0xfffffffffffffc18, float:NaN)
            if (r6 != r7) goto L_0x0174
            java.lang.String r1 = "Minute part in localized time zone offset does not match expected pattern mm."
            r2.setError(r0, r1)
            return
        L_0x0174:
            int r0 = r0 + 2
            if (r0 >= r5) goto L_0x0193
            java.lang.String r7 = r14.separator
            int r7 = net.time4j.format.expert.LiteralProcessor.subSequenceEquals(r1, r0, r7, r10, r8)
            r13 = -1
            if (r7 == r13) goto L_0x0193
            int r0 = r0 + r7
            int r13 = parseTwoDigits(r1, r0, r11)
            r24 = r8
            r8 = -1000(0xfffffffffffffc18, float:NaN)
            if (r13 != r8) goto L_0x0190
            int r0 = r0 - r7
            goto L_0x0198
        L_0x0190:
            int r0 = r0 + 2
            goto L_0x0198
        L_0x0193:
            r24 = r8
            r8 = -1000(0xfffffffffffffc18, float:NaN)
            r13 = 0
        L_0x0198:
            if (r13 == 0) goto L_0x01ad
            if (r13 != r8) goto L_0x019d
            goto L_0x01ad
        L_0x019d:
            int r3 = r3 * 3600
            int r6 = r6 * 60
            int r3 = r3 + r6
            int r3 = r3 + r13
            net.time4j.tz.OffsetSign r6 = net.time4j.tz.OffsetSign.BEHIND_UTC
            if (r15 != r6) goto L_0x01a8
            int r3 = -r3
        L_0x01a8:
            net.time4j.tz.ZonalOffset r3 = net.time4j.tz.ZonalOffset.ofTotalSeconds(r3)
            goto L_0x01b1
        L_0x01ad:
            net.time4j.tz.ZonalOffset r3 = net.time4j.tz.ZonalOffset.ofHoursMinutes(r15, r3, r6)
        L_0x01b1:
            int r6 = r14.end
            int r6 = r6 + -1
            r18 = r3
            r3 = r6
            goto L_0x01fe
        L_0x01bb:
            r22 = r6
            r23 = r7
            r24 = r8
            r20 = r12
            r21 = r13
            r12 = r25
            if (r9 != 0) goto L_0x01fe
            if (r0 >= r5) goto L_0x01d0
            char r6 = r1.charAt(r0)
            goto L_0x01d1
        L_0x01d0:
            r6 = 0
        L_0x01d1:
            r7 = r19
            if (r10 != 0) goto L_0x01d7
            if (r7 == r6) goto L_0x01df
        L_0x01d7:
            if (r10 == 0) goto L_0x01e2
            boolean r6 = charEqualsIgnoreCase(r7, r6)
            if (r6 == 0) goto L_0x01e2
        L_0x01df:
            int r0 = r0 + 1
            goto L_0x01fe
        L_0x01e2:
            r6 = r22
            r7 = r23
            int r0 = parseUTC(r1, r5, r6, r7, r10)
            if (r0 <= 0) goto L_0x01f8
            net.time4j.format.expert.TimezoneElement r1 = net.time4j.format.expert.TimezoneElement.TIMEZONE_OFFSET
            net.time4j.tz.ZonalOffset r3 = net.time4j.tz.ZonalOffset.UTC
            r4.put((net.time4j.engine.ChronoElement<?>) r1, (java.lang.Object) r3)
            int r6 = r6 + r0
            r2.setPosition(r6)
            goto L_0x01fd
        L_0x01f8:
            java.lang.String r0 = "Literal mismatched in localized time zone offset."
            r2.setError(r6, r0)
        L_0x01fd:
            return
        L_0x01fe:
            r6 = r22
            r7 = r23
            int r3 = r3 + 1
            r15 = r16
            r12 = r20
            r13 = r21
            r8 = r24
            goto L_0x009c
        L_0x020e:
            r12 = r25
            r3 = r18
            if (r3 != 0) goto L_0x021a
            java.lang.String r1 = "Unable to determine localized time zone offset."
            r2.setError(r0, r1)
            goto L_0x0222
        L_0x021a:
            net.time4j.format.expert.TimezoneElement r1 = net.time4j.format.expert.TimezoneElement.TIMEZONE_OFFSET
            r4.put((net.time4j.engine.ChronoElement<?>) r1, (java.lang.Object) r3)
            r2.setPosition(r0)
        L_0x0222:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.LocalizedGMTProcessor.parse(java.lang.CharSequence, net.time4j.format.expert.ParseLog, net.time4j.engine.AttributeQuery, net.time4j.format.expert.ParsedEntity, boolean):void");
    }

    public ChronoElement<TZID> getElement() {
        return TimezoneElement.TIMEZONE_OFFSET;
    }

    public FormatProcessor<TZID> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new LocalizedGMTProcessor(this.abbreviated, ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue(), ((Boolean) attributeQuery.get(Attributes.NO_GMT_PREFIX, Boolean.FALSE)).booleanValue(), (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (String) attributeQuery.get(AttributeSet.PLUS_SIGN, "+"), (String) attributeQuery.get(AttributeSet.MINUS_SIGN, "-"), ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalizedGMTProcessor) || this.abbreviated != ((LocalizedGMTProcessor) obj).abbreviated) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.abbreviated ? 1 : 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[abbreviated=");
        sb.append(this.abbreviated);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    private static ZonalOffset getOffset(ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
        if (attributeQuery.contains(Attributes.TIMEZONE_ID)) {
            TZID tzid = (TZID) attributeQuery.get(Attributes.TIMEZONE_ID);
            if (tzid instanceof ZonalOffset) {
                return (ZonalOffset) tzid;
            }
        }
        throw new IllegalArgumentException("Cannot extract timezone offset from format attributes for: " + chronoDisplay);
    }

    private static int parseUTC(CharSequence charSequence, int i, int i2, Locale locale2, boolean z) {
        String[] strArr = {TimeZones.GMT_ID, getLiteralUTC(locale2), "UTC", "UT"};
        for (int i3 = 0; i3 < 4; i3++) {
            String str = strArr[i3];
            int length = str.length();
            if (i - i2 >= length) {
                String charSequence2 = charSequence.subSequence(i2, i2 + length).toString();
                if ((z && charSequence2.equalsIgnoreCase(str)) || (!z && charSequence2.equals(str))) {
                    return length;
                }
            }
        }
        return 0;
    }

    private static int parseTwoDigits(CharSequence charSequence, int i, char c) {
        int charAt;
        int i2 = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            int i4 = i + i3;
            if (i4 >= charSequence.length() || (charAt = charSequence.charAt(i4) - c) < 0 || charAt > 9) {
                return NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            }
            i2 = (i2 * 10) + charAt;
        }
        return i2;
    }

    private static int parseHours(CharSequence charSequence, int i, char c) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 2) {
            int i4 = i + i2;
            if (i4 >= charSequence.length()) {
                return i2 == 0 ? NotificationManagerCompat.IMPORTANCE_UNSPECIFIED : ~i3;
            }
            int charAt = charSequence.charAt(i4) - c;
            if (charAt >= 0 && charAt <= 9) {
                i3 = (i3 * 10) + charAt;
                i2++;
            } else if (i2 == 0) {
                return NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            } else {
                return ~i3;
            }
        }
        return i3;
    }

    private static boolean charEqualsIgnoreCase(char c, char c2) {
        return c == c2 || Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    private static String getLiteralUTC(Locale locale2) {
        ConcurrentMap<Locale, String> concurrentMap = UTC_LITERALS;
        String str = (String) concurrentMap.get(locale2);
        if (str != null) {
            return str;
        }
        String stdFormatPattern = ZonalOffset.UTC.getStdFormatPattern(locale2);
        String putIfAbsent = concurrentMap.putIfAbsent(locale2, stdFormatPattern);
        return putIfAbsent != null ? putIfAbsent : stdFormatPattern;
    }

    private static Info getPatternInfo(Locale locale2) {
        Info info = (Info) STD_PATTERN_INFOS.get(locale2);
        if (info != null) {
            return info;
        }
        String stdFormatPattern = PROTOTYPE.getStdFormatPattern(locale2);
        int length = stdFormatPattern.length();
        for (int i = 0; i < length; i++) {
            if (stdFormatPattern.charAt(i) == 177) {
                int indexOf = stdFormatPattern.indexOf("hh", i) + 2;
                int indexOf2 = stdFormatPattern.indexOf("mm", indexOf);
                Info info2 = new Info(stdFormatPattern, stdFormatPattern.substring(indexOf, indexOf2), i, indexOf2 + 2);
                Info putIfAbsent = STD_PATTERN_INFOS.putIfAbsent(locale2, info2);
                return putIfAbsent != null ? putIfAbsent : info2;
            }
        }
        return info;
    }

    private static class Info {
        /* access modifiers changed from: private */
        public final int end;
        /* access modifiers changed from: private */
        public final String pattern;
        /* access modifiers changed from: private */
        public final String separator;
        /* access modifiers changed from: private */
        public final int start;

        Info(String str, String str2, int i, int i2) {
            this.pattern = str;
            this.separator = str2;
            this.start = i;
            this.end = i2;
        }
    }
}
