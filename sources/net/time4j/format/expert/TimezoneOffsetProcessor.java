package net.time4j.format.expert;

import androidx.core.app.NotificationManagerCompat;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.UnixTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.DisplayMode;
import net.time4j.format.Leniency;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;
import org.apache.commons.lang3.ClassUtils;

final class TimezoneOffsetProcessor implements FormatProcessor<TZID> {
    static final TimezoneOffsetProcessor EXTENDED_LONG_PARSER = new TimezoneOffsetProcessor();
    private final boolean caseInsensitive;
    private final boolean extended;
    private final Leniency lenientMode;
    private final DisplayMode precision;
    private final List<String> zeroOffsets;

    public boolean isNumerical() {
        return false;
    }

    public FormatProcessor<TZID> withElement(ChronoElement<TZID> chronoElement) {
        return this;
    }

    TimezoneOffsetProcessor(DisplayMode displayMode, boolean z, List<String> list) {
        Objects.requireNonNull(displayMode, "Missing display mode.");
        if (!list.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(list);
            for (String trim : arrayList) {
                if (trim.trim().isEmpty()) {
                    throw new IllegalArgumentException("Zero offset must not be white-space-only.");
                }
            }
            this.precision = displayMode;
            this.extended = z;
            this.zeroOffsets = Collections.unmodifiableList(arrayList);
            this.caseInsensitive = true;
            this.lenientMode = Leniency.SMART;
            return;
        }
        throw new IllegalArgumentException("Missing zero offsets.");
    }

    private TimezoneOffsetProcessor() {
        this.precision = DisplayMode.LONG;
        this.extended = true;
        this.zeroOffsets = Collections.emptyList();
        this.caseInsensitive = true;
        this.lenientMode = Leniency.SMART;
    }

    private TimezoneOffsetProcessor(DisplayMode displayMode, boolean z, List<String> list, boolean z2, Leniency leniency) {
        this.precision = displayMode;
        this.extended = z;
        this.zeroOffsets = list;
        this.caseInsensitive = z2;
        this.lenientMode = leniency;
    }

    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        ZonalOffset zonalOffset;
        int i;
        int length = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
        TZID tzid = null;
        if (chronoDisplay.hasTimezone()) {
            tzid = chronoDisplay.getTimezone();
        }
        if (tzid == null) {
            zonalOffset = getOffset(chronoDisplay, attributeQuery);
        } else if (tzid instanceof ZonalOffset) {
            zonalOffset = (ZonalOffset) tzid;
        } else if (chronoDisplay instanceof UnixTime) {
            zonalOffset = Timezone.of(tzid).getOffset((UnixTime) chronoDisplay);
        } else {
            throw new IllegalArgumentException("Cannot extract timezone offset from: " + chronoDisplay);
        }
        int integralAmount = zonalOffset.getIntegralAmount();
        int fractionalAmount = zonalOffset.getFractionalAmount();
        if ((integralAmount | fractionalAmount) == 0) {
            String str = this.zeroOffsets.get(0);
            appendable.append(str);
            i = str.length();
        } else {
            int i2 = 1;
            appendable.append(integralAmount < 0 || fractionalAmount < 0 ? SignatureVisitor.SUPER : SignatureVisitor.EXTENDS);
            int abs = Math.abs(integralAmount);
            int i3 = abs / NikonType2MakernoteDirectory.TAG_NIKON_SCAN;
            int i4 = (abs / 60) % 60;
            int i5 = abs % 60;
            if (i3 < 10) {
                appendable.append('0');
                i2 = 2;
            }
            String valueOf = String.valueOf(i3);
            appendable.append(valueOf);
            int length2 = i2 + valueOf.length();
            if (!(this.precision == DisplayMode.SHORT && i4 == 0)) {
                if (this.extended) {
                    appendable.append(AbstractJsonLexerKt.COLON);
                    length2++;
                }
                if (i4 < 10) {
                    appendable.append('0');
                    length2++;
                }
                String valueOf2 = String.valueOf(i4);
                appendable.append(valueOf2);
                length2 += valueOf2.length();
                if (!(this.precision == DisplayMode.SHORT || this.precision == DisplayMode.MEDIUM || (this.precision != DisplayMode.FULL && (i5 | fractionalAmount) == 0))) {
                    if (this.extended) {
                        appendable.append(AbstractJsonLexerKt.COLON);
                        length2++;
                    }
                    if (i5 < 10) {
                        appendable.append('0');
                        length2++;
                    }
                    String valueOf3 = String.valueOf(i5);
                    appendable.append(valueOf3);
                    int length3 = valueOf3.length() + length2;
                    if (fractionalAmount != 0) {
                        appendable.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                        int i6 = length3 + 1;
                        String valueOf4 = String.valueOf(Math.abs(fractionalAmount));
                        int length4 = 9 - valueOf4.length();
                        for (int i7 = 0; i7 < length4; i7++) {
                            appendable.append('0');
                            i6++;
                        }
                        appendable.append(valueOf4);
                        i = valueOf4.length() + i6;
                    } else {
                        i = length3;
                    }
                }
            }
            i = length2;
        }
        if (!(length == -1 || i <= 0 || set == null)) {
            set.add(new ElementPosition(TimezoneElement.TIMEZONE_ID, length, length + i));
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0153  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.CharSequence r11, net.time4j.format.expert.ParseLog r12, net.time4j.engine.AttributeQuery r13, net.time4j.format.expert.ParsedEntity<?> r14, boolean r15) {
        /*
            r10 = this;
            int r0 = r11.length()
            int r1 = r12.getPosition()
            if (r1 < r0) goto L_0x0010
            java.lang.String r11 = "Missing timezone offset."
            r12.setError(r1, r11)
            return
        L_0x0010:
            java.util.List<java.lang.String> r2 = r10.zeroOffsets
            java.util.Iterator r2 = r2.iterator()
        L_0x0016:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0061
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r3.length()
            int r5 = r0 - r1
            if (r5 < r4) goto L_0x0016
            int r4 = r4 + r1
            java.lang.CharSequence r5 = r11.subSequence(r1, r4)
            java.lang.String r5 = r5.toString()
            if (r15 == 0) goto L_0x0038
            boolean r6 = r10.caseInsensitive
            goto L_0x0046
        L_0x0038:
            net.time4j.engine.AttributeKey<java.lang.Boolean> r6 = net.time4j.format.Attributes.PARSE_CASE_INSENSITIVE
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Object r6 = r13.get(r6, r7)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
        L_0x0046:
            if (r6 == 0) goto L_0x004e
            boolean r7 = r5.equalsIgnoreCase(r3)
            if (r7 != 0) goto L_0x0056
        L_0x004e:
            if (r6 != 0) goto L_0x0016
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0016
        L_0x0056:
            net.time4j.format.expert.TimezoneElement r11 = net.time4j.format.expert.TimezoneElement.TIMEZONE_OFFSET
            net.time4j.tz.ZonalOffset r13 = net.time4j.tz.ZonalOffset.UTC
            r14.put((net.time4j.engine.ChronoElement<?>) r11, (java.lang.Object) r13)
            r12.setPosition(r4)
            return
        L_0x0061:
            if (r15 == 0) goto L_0x0066
            net.time4j.format.Leniency r13 = r10.lenientMode
            goto L_0x0070
        L_0x0066:
            net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r15 = net.time4j.format.Attributes.LENIENCY
            net.time4j.format.Leniency r2 = net.time4j.format.Leniency.SMART
            java.lang.Object r13 = r13.get(r15, r2)
            net.time4j.format.Leniency r13 = (net.time4j.format.Leniency) r13
        L_0x0070:
            char r15 = r11.charAt(r1)
            r2 = 43
            if (r15 != r2) goto L_0x007d
            net.time4j.tz.OffsetSign r15 = net.time4j.tz.OffsetSign.AHEAD_OF_UTC
        L_0x007a:
            int r1 = r1 + 1
            goto L_0x0092
        L_0x007d:
            r2 = 45
            if (r15 != r2) goto L_0x0084
            net.time4j.tz.OffsetSign r15 = net.time4j.tz.OffsetSign.BEHIND_UTC
            goto L_0x007a
        L_0x0084:
            boolean r15 = java.lang.Character.isDigit(r15)
            if (r15 == 0) goto L_0x01ad
            boolean r15 = r13.isLax()
            if (r15 == 0) goto L_0x01ad
            net.time4j.tz.OffsetSign r15 = net.time4j.tz.OffsetSign.AHEAD_OF_UTC
        L_0x0092:
            int r13 = parseNum(r11, r1, r13)
            r2 = -1000(0xfffffffffffffc18, float:NaN)
            if (r13 != r2) goto L_0x00a0
            java.lang.String r11 = "Hour part in timezone offset does not match expected pattern HH."
            r12.setError(r1, r11)
            return
        L_0x00a0:
            r3 = 1
            if (r13 >= 0) goto L_0x00a6
            int r13 = ~r13
            int r1 = r1 + r3
            goto L_0x00a8
        L_0x00a6:
            int r1 = r1 + 2
        L_0x00a8:
            if (r1 < r0) goto L_0x00c3
            net.time4j.format.DisplayMode r11 = r10.precision
            net.time4j.format.DisplayMode r0 = net.time4j.format.DisplayMode.SHORT
            if (r11 != r0) goto L_0x00bd
            net.time4j.format.expert.TimezoneElement r11 = net.time4j.format.expert.TimezoneElement.TIMEZONE_OFFSET
            net.time4j.tz.ZonalOffset r13 = net.time4j.tz.ZonalOffset.ofHours(r15, r13)
            r14.put((net.time4j.engine.ChronoElement<?>) r11, (java.lang.Object) r13)
            r12.setPosition(r1)
            goto L_0x00c2
        L_0x00bd:
            java.lang.String r11 = "Missing minute part in timezone offset."
            r12.setError(r1, r11)
        L_0x00c2:
            return
        L_0x00c3:
            boolean r4 = r10.extended
            java.lang.String r5 = "Colon expected in timezone offset."
            r6 = 58
            r7 = 0
            if (r4 == 0) goto L_0x00eb
            char r4 = r11.charAt(r1)
            if (r4 != r6) goto L_0x00d4
            r4 = 1
            goto L_0x00ec
        L_0x00d4:
            net.time4j.format.DisplayMode r11 = r10.precision
            net.time4j.format.DisplayMode r0 = net.time4j.format.DisplayMode.SHORT
            if (r11 != r0) goto L_0x00e7
            net.time4j.format.expert.TimezoneElement r11 = net.time4j.format.expert.TimezoneElement.TIMEZONE_OFFSET
            net.time4j.tz.ZonalOffset r13 = net.time4j.tz.ZonalOffset.ofHours(r15, r13)
            r14.put((net.time4j.engine.ChronoElement<?>) r11, (java.lang.Object) r13)
            r12.setPosition(r1)
            return
        L_0x00e7:
            r12.setError(r1, r5)
            return
        L_0x00eb:
            r4 = 0
        L_0x00ec:
            int r4 = r4 + r1
            net.time4j.format.Leniency r8 = net.time4j.format.Leniency.STRICT
            int r8 = parseNum(r11, r4, r8)
            if (r8 != r2) goto L_0x010e
            net.time4j.format.DisplayMode r11 = r10.precision
            net.time4j.format.DisplayMode r0 = net.time4j.format.DisplayMode.SHORT
            if (r11 != r0) goto L_0x0108
            net.time4j.format.expert.TimezoneElement r11 = net.time4j.format.expert.TimezoneElement.TIMEZONE_OFFSET
            net.time4j.tz.ZonalOffset r13 = net.time4j.tz.ZonalOffset.ofHours(r15, r13)
            r14.put((net.time4j.engine.ChronoElement<?>) r11, (java.lang.Object) r13)
            r12.setPosition(r1)
            goto L_0x010d
        L_0x0108:
            java.lang.String r11 = "Minute part in timezone offset does not match expected pattern mm."
            r12.setError(r4, r11)
        L_0x010d:
            return
        L_0x010e:
            int r4 = r4 + 2
            if (r4 >= r0) goto L_0x018a
            net.time4j.format.DisplayMode r1 = r10.precision
            net.time4j.format.DisplayMode r9 = net.time4j.format.DisplayMode.LONG
            if (r1 == r9) goto L_0x011e
            net.time4j.format.DisplayMode r1 = r10.precision
            net.time4j.format.DisplayMode r9 = net.time4j.format.DisplayMode.FULL
            if (r1 != r9) goto L_0x018a
        L_0x011e:
            boolean r1 = r10.extended
            if (r1 == 0) goto L_0x013e
            char r1 = r11.charAt(r4)
            if (r1 != r6) goto L_0x0131
            int r1 = r4 + 1
            net.time4j.format.Leniency r5 = net.time4j.format.Leniency.STRICT
            int r1 = parseNum(r11, r1, r5)
            goto L_0x0145
        L_0x0131:
            net.time4j.format.DisplayMode r1 = r10.precision
            net.time4j.format.DisplayMode r3 = net.time4j.format.DisplayMode.FULL
            if (r1 != r3) goto L_0x013b
            r12.setError(r4, r5)
            return
        L_0x013b:
            r1 = -1000(0xfffffffffffffc18, float:NaN)
            goto L_0x0144
        L_0x013e:
            net.time4j.format.Leniency r1 = net.time4j.format.Leniency.STRICT
            int r1 = parseNum(r11, r4, r1)
        L_0x0144:
            r3 = 0
        L_0x0145:
            if (r1 != r2) goto L_0x0153
            net.time4j.format.DisplayMode r11 = r10.precision
            net.time4j.format.DisplayMode r0 = net.time4j.format.DisplayMode.FULL
            if (r11 != r0) goto L_0x018a
            java.lang.String r11 = "Second part in timezone offset does not match expected pattern ss."
            r12.setError(r4, r11)
            return
        L_0x0153:
            int r4 = r4 + r3
            int r4 = r4 + 2
            int r2 = r4 + 10
            if (r2 > r0) goto L_0x0189
            char r0 = r11.charAt(r4)
            r2 = 46
            if (r0 != r2) goto L_0x0189
            int r4 = r4 + 1
            int r0 = r4 + 9
            r2 = r4
        L_0x0167:
            if (r4 >= r0) goto L_0x0185
            char r3 = r11.charAt(r4)
            r5 = 48
            if (r3 < r5) goto L_0x017f
            r5 = 57
            if (r3 > r5) goto L_0x017f
            int r7 = r7 * 10
            int r3 = r3 + -48
            int r7 = r7 + r3
            int r2 = r2 + 1
            int r4 = r4 + 1
            goto L_0x0167
        L_0x017f:
            java.lang.String r11 = "9 digits in fractional part of timezone offset expected."
            r12.setError(r2, r11)
            return
        L_0x0185:
            r4 = r2
            r11 = r7
            r7 = r1
            goto L_0x018b
        L_0x0189:
            r7 = r1
        L_0x018a:
            r11 = 0
        L_0x018b:
            if (r7 != 0) goto L_0x0194
            if (r11 != 0) goto L_0x0194
            net.time4j.tz.ZonalOffset r11 = net.time4j.tz.ZonalOffset.ofHoursMinutes(r15, r13, r8)
            goto L_0x01a4
        L_0x0194:
            int r13 = r13 * 3600
            int r8 = r8 * 60
            int r13 = r13 + r8
            int r13 = r13 + r7
            net.time4j.tz.OffsetSign r0 = net.time4j.tz.OffsetSign.BEHIND_UTC
            if (r15 != r0) goto L_0x01a0
            int r13 = -r13
            int r11 = -r11
        L_0x01a0:
            net.time4j.tz.ZonalOffset r11 = net.time4j.tz.ZonalOffset.ofTotalSeconds(r13, r11)
        L_0x01a4:
            net.time4j.format.expert.TimezoneElement r13 = net.time4j.format.expert.TimezoneElement.TIMEZONE_OFFSET
            r14.put((net.time4j.engine.ChronoElement<?>) r13, (java.lang.Object) r11)
            r12.setPosition(r4)
            return
        L_0x01ad:
            java.lang.String r11 = "Missing sign of timezone offset."
            r12.setError(r1, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.TimezoneOffsetProcessor.parse(java.lang.CharSequence, net.time4j.format.expert.ParseLog, net.time4j.engine.AttributeQuery, net.time4j.format.expert.ParsedEntity, boolean):void");
    }

    public ChronoElement<TZID> getElement() {
        return TimezoneElement.TIMEZONE_OFFSET;
    }

    public FormatProcessor<TZID> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new TimezoneOffsetProcessor(this.precision, this.extended, this.zeroOffsets, ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimezoneOffsetProcessor)) {
            return false;
        }
        TimezoneOffsetProcessor timezoneOffsetProcessor = (TimezoneOffsetProcessor) obj;
        if (this.precision == timezoneOffsetProcessor.precision && this.extended == timezoneOffsetProcessor.extended && this.zeroOffsets.equals(timezoneOffsetProcessor.zeroOffsets)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.precision.hashCode() * 7) + (this.zeroOffsets.hashCode() * 31) + (this.extended ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[precision=");
        sb.append(this.precision);
        sb.append(", extended=");
        sb.append(this.extended);
        sb.append(", zero-offsets=");
        sb.append(this.zeroOffsets);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    private static ZonalOffset getOffset(ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
        if (attributeQuery.contains(Attributes.TIMEZONE_ID)) {
            TZID tzid = (TZID) attributeQuery.get(Attributes.TIMEZONE_ID);
            if (tzid instanceof ZonalOffset) {
                return (ZonalOffset) tzid;
            }
            if (tzid != null) {
                throw new IllegalArgumentException("Use a timezone offset instead of [" + tzid.canonical() + "] when formatting [" + chronoDisplay + "].");
            }
        }
        throw new IllegalArgumentException("Cannot extract timezone offset from format attributes for: " + chronoDisplay);
    }

    private static int parseNum(CharSequence charSequence, int i, Leniency leniency) {
        char c;
        int i2 = 0;
        int i3 = 0;
        while (i2 < 2) {
            int i4 = i + i2;
            if (i4 >= charSequence.length()) {
                c = 0;
            } else {
                c = charSequence.charAt(i4);
            }
            if (c < '0' || c > '9') {
                return (i2 == 0 || leniency.isStrict()) ? NotificationManagerCompat.IMPORTANCE_UNSPECIFIED : ~i3;
            }
            i3 = (i3 * 10) + (c - '0');
            i2++;
        }
        return i3;
    }
}
