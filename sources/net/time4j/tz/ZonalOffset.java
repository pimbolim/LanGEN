package net.time4j.tz;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.time.TimeZones;

public final class ZonalOffset implements Comparable<ZonalOffset>, TZID, Serializable {
    private static final BigDecimal DECIMAL_240 = new BigDecimal(240);
    private static final BigDecimal DECIMAL_3600 = new BigDecimal(NikonType2MakernoteDirectory.TAG_NIKON_SCAN);
    private static final BigDecimal DECIMAL_60 = new BigDecimal(60);
    private static final BigDecimal DECIMAL_NEG_180 = new BigDecimal(-180);
    private static final BigDecimal DECIMAL_POS_180 = new BigDecimal(180);
    private static final BigDecimal MRD = new BigDecimal(1000000000);
    private static final ConcurrentMap<Integer, ZonalOffset> OFFSET_CACHE;
    public static final ZonalOffset UTC;
    private static final long serialVersionUID = -1410512619471503090L;
    private final transient int fraction;
    private final transient String name;
    private final transient int total;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        OFFSET_CACHE = concurrentHashMap;
        ZonalOffset zonalOffset = new ZonalOffset(0, 0);
        UTC = zonalOffset;
        concurrentHashMap.put(0, zonalOffset);
    }

    private ZonalOffset(int i, int i2) {
        if (i2 == 0) {
            if (i < -64800 || i > 64800) {
                throw new IllegalArgumentException("Total seconds out of range: " + i);
            }
        } else if (Math.abs(i2) > 999999999) {
            throw new IllegalArgumentException("Fraction out of range: " + i2);
        } else if (i < -39600 || i > 39600) {
            throw new IllegalArgumentException("Total seconds out of range while fraction is non-zero: " + i);
        } else if ((i < 0 && i2 > 0) || (i > 0 && i2 < 0)) {
            throw new IllegalArgumentException("Different signs: offset=" + i + ", fraction=" + i2);
        }
        boolean z = i < 0 || i2 < 0;
        StringBuilder sb = new StringBuilder();
        sb.append(z ? SignatureVisitor.SUPER : SignatureVisitor.EXTENDS);
        int abs = Math.abs(i);
        int i3 = abs / NikonType2MakernoteDirectory.TAG_NIKON_SCAN;
        int i4 = (abs / 60) % 60;
        int i5 = abs % 60;
        if (i3 < 10) {
            sb.append('0');
        }
        sb.append(i3);
        sb.append(AbstractJsonLexerKt.COLON);
        if (i4 < 10) {
            sb.append('0');
        }
        sb.append(i4);
        if (!(i5 == 0 && i2 == 0)) {
            sb.append(AbstractJsonLexerKt.COLON);
            if (i5 < 10) {
                sb.append('0');
            }
            sb.append(i5);
            if (i2 != 0) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String valueOf = String.valueOf(Math.abs(i2));
                int length = 9 - valueOf.length();
                for (int i6 = 0; i6 < length; i6++) {
                    sb.append('0');
                }
                sb.append(valueOf);
            }
        }
        this.name = sb.toString();
        this.total = i;
        this.fraction = i2;
    }

    public static ZonalOffset atLongitude(BigDecimal bigDecimal) {
        if (bigDecimal.compareTo(DECIMAL_POS_180) > 0 || bigDecimal.compareTo(DECIMAL_NEG_180) < 0) {
            throw new IllegalArgumentException("Out of range: " + bigDecimal);
        }
        BigDecimal multiply = bigDecimal.multiply(DECIMAL_240);
        BigDecimal scale = multiply.setScale(0, RoundingMode.DOWN);
        BigDecimal multiply2 = multiply.subtract(scale).setScale(9, RoundingMode.HALF_UP).multiply(MRD);
        int intValueExact = scale.intValueExact();
        int intValueExact2 = multiply2.intValueExact();
        if (intValueExact2 == 0) {
            return ofTotalSeconds(intValueExact);
        }
        if (intValueExact2 == 1000000000) {
            return ofTotalSeconds(intValueExact + 1);
        }
        if (intValueExact2 == -1000000000) {
            return ofTotalSeconds(intValueExact - 1);
        }
        return new ZonalOffset(intValueExact, intValueExact2);
    }

    public static ZonalOffset atLongitude(OffsetSign offsetSign, int i, int i2, double d) {
        Objects.requireNonNull(offsetSign, "Missing sign.");
        if (i < 0 || i > 180) {
            throw new IllegalArgumentException("Degrees of longitude out of range (0 <= degrees <= 180).");
        } else if (i2 < 0 || i2 > 59) {
            throw new IllegalArgumentException("Arc minute out of range (0 <= arcMinutes <= 59).");
        } else if (Double.compare(d, 0.0d) < 0 || Double.compare(d, 60.0d) >= 0) {
            throw new IllegalArgumentException("Arc second out of range (0.0 <= arcSeconds < 60.0).");
        } else {
            BigDecimal valueOf = BigDecimal.valueOf((long) i);
            if (i2 != 0) {
                valueOf = valueOf.add(BigDecimal.valueOf((long) i2).setScale(15, RoundingMode.UNNECESSARY).divide(DECIMAL_60, RoundingMode.HALF_UP));
            }
            if (d != 0.0d) {
                valueOf = valueOf.add(BigDecimal.valueOf(d).setScale(15, RoundingMode.FLOOR).divide(DECIMAL_3600, RoundingMode.HALF_UP));
            }
            if (offsetSign == OffsetSign.BEHIND_UTC) {
                valueOf = valueOf.negate();
            }
            return atLongitude(valueOf);
        }
    }

    public static ZonalOffset ofHours(OffsetSign offsetSign, int i) {
        return ofHoursMinutes(offsetSign, i, 0);
    }

    public static ZonalOffset ofHoursMinutes(OffsetSign offsetSign, int i, int i2) {
        Objects.requireNonNull(offsetSign, "Missing sign.");
        if (i < 0 || i > 18) {
            throw new IllegalArgumentException("Hour part out of range (0 <= hours <= 18) in: " + format(i, i2));
        } else if (i2 < 0 || i2 > 59) {
            throw new IllegalArgumentException("Minute part out of range (0 <= minutes <= 59) in: " + format(i, i2));
        } else if (i != 18 || i2 == 0) {
            int i3 = (i * NikonType2MakernoteDirectory.TAG_NIKON_SCAN) + (i2 * 60);
            if (offsetSign == OffsetSign.BEHIND_UTC) {
                i3 = -i3;
            }
            return ofTotalSeconds(i3);
        } else {
            throw new IllegalArgumentException("Time zone offset out of range (-18:00:00 <= offset <= 18:00:00) in: " + format(i, i2));
        }
    }

    public static ZonalOffset ofTotalSeconds(int i) {
        return ofTotalSeconds(i, 0);
    }

    public static ZonalOffset ofTotalSeconds(int i, int i2) {
        if (i2 != 0) {
            return new ZonalOffset(i, i2);
        }
        if (i == 0) {
            return UTC;
        }
        if (i % TypedValues.Custom.TYPE_INT != 0) {
            return new ZonalOffset(i, 0);
        }
        Integer valueOf = Integer.valueOf(i);
        ConcurrentMap<Integer, ZonalOffset> concurrentMap = OFFSET_CACHE;
        ZonalOffset zonalOffset = (ZonalOffset) concurrentMap.get(valueOf);
        if (zonalOffset != null) {
            return zonalOffset;
        }
        concurrentMap.putIfAbsent(valueOf, new ZonalOffset(i, 0));
        return (ZonalOffset) concurrentMap.get(valueOf);
    }

    public OffsetSign getSign() {
        return (this.total < 0 || this.fraction < 0) ? OffsetSign.BEHIND_UTC : OffsetSign.AHEAD_OF_UTC;
    }

    public int getAbsoluteHours() {
        return Math.abs(this.total) / NikonType2MakernoteDirectory.TAG_NIKON_SCAN;
    }

    public int getAbsoluteMinutes() {
        return (Math.abs(this.total) / 60) % 60;
    }

    public int getAbsoluteSeconds() {
        return Math.abs(this.total) % 60;
    }

    public int getIntegralAmount() {
        return this.total;
    }

    public int getFractionalAmount() {
        return this.fraction;
    }

    public int compareTo(ZonalOffset zonalOffset) {
        int i = this.total;
        int i2 = zonalOffset.total;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = this.fraction - zonalOffset.fraction;
        if (i3 < 0) {
            return -1;
        }
        return i3 == 0 ? 0 : 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonalOffset)) {
            return false;
        }
        ZonalOffset zonalOffset = (ZonalOffset) obj;
        if (this.total == zonalOffset.total && this.fraction == zonalOffset.fraction) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (~this.total) + (this.fraction % 64000);
    }

    public String toString() {
        return this.name;
    }

    public String canonical() {
        if (this.total == 0 && this.fraction == 0) {
            return "Z";
        }
        return "UTC" + this.name;
    }

    public static ZonalOffset parse(String str) {
        return parse(str, true);
    }

    public String getStdFormatPattern(Locale locale) {
        boolean z = this.total == 0 && this.fraction == 0;
        try {
            return Timezone.NAME_PROVIDER.getStdFormatPattern(z, locale);
        } catch (Throwable unused) {
            return z ? TimeZones.GMT_ID : "GMT±hh:mm";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static net.time4j.tz.ZonalOffset parse(java.lang.String r11, boolean r12) {
        /*
            java.lang.String r0 = "Z"
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x000b
            net.time4j.tz.ZonalOffset r11 = UTC
            return r11
        L_0x000b:
            int r0 = r11.length()
            r1 = 0
            r2 = 3
            if (r0 < r2) goto L_0x0044
            java.lang.String r3 = "UTC"
            boolean r3 = r11.startsWith(r3)
            if (r3 == 0) goto L_0x0022
            java.lang.String r3 = r11.substring(r2)
            int r0 = r0 + -3
            goto L_0x0045
        L_0x0022:
            java.lang.String r3 = "GMT"
            boolean r3 = r11.startsWith(r3)
            if (r3 == 0) goto L_0x0044
            if (r12 != 0) goto L_0x002d
            return r1
        L_0x002d:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Use UTC-prefix for canonical offset instead: "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r12.<init>(r11)
            throw r12
        L_0x0044:
            r3 = r11
        L_0x0045:
            r4 = 2
            if (r0 < r4) goto L_0x00d4
            r5 = 0
            char r6 = r3.charAt(r5)
            r7 = 45
            if (r6 != r7) goto L_0x0054
            net.time4j.tz.OffsetSign r5 = net.time4j.tz.OffsetSign.BEHIND_UTC
            goto L_0x0060
        L_0x0054:
            char r5 = r3.charAt(r5)
            r6 = 43
            if (r5 != r6) goto L_0x005f
            net.time4j.tz.OffsetSign r5 = net.time4j.tz.OffsetSign.AHEAD_OF_UTC
            goto L_0x0060
        L_0x005f:
            r5 = r1
        L_0x0060:
            r6 = 1
            int r6 = parse(r3, r6, r4)
            if (r6 < 0) goto L_0x00d4
            if (r0 > r2) goto L_0x006e
            net.time4j.tz.ZonalOffset r11 = ofHours(r5, r6)
            return r11
        L_0x006e:
            r7 = 4
            char r8 = r3.charAt(r4)
            r9 = 58
            if (r8 != r9) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r2 = 4
        L_0x0079:
            int r7 = parse(r3, r2, r4)
            int r8 = r2 + -1
            char r8 = r3.charAt(r8)
            if (r8 != r9) goto L_0x00d4
            if (r7 < 0) goto L_0x00d4
            int r8 = r2 + 2
            if (r0 != r8) goto L_0x0090
            net.time4j.tz.ZonalOffset r11 = ofHoursMinutes(r5, r6, r7)
            return r11
        L_0x0090:
            int r10 = r2 + 5
            if (r0 < r10) goto L_0x00d4
            char r8 = r3.charAt(r8)
            if (r8 != r9) goto L_0x00d4
            int r8 = r2 + 3
            int r4 = parse(r3, r8, r4)
            if (r4 < 0) goto L_0x00d4
            int r6 = r6 * 3600
            int r7 = r7 * 60
            int r6 = r6 + r7
            int r6 = r6 + r4
            net.time4j.tz.OffsetSign r4 = net.time4j.tz.OffsetSign.BEHIND_UTC
            if (r5 != r4) goto L_0x00ad
            int r6 = -r6
        L_0x00ad:
            if (r0 != r10) goto L_0x00b4
            net.time4j.tz.ZonalOffset r11 = ofTotalSeconds(r6)
            return r11
        L_0x00b4:
            int r4 = r2 + 15
            if (r0 != r4) goto L_0x00d4
            char r0 = r3.charAt(r10)
            r4 = 46
            if (r0 != r4) goto L_0x00d4
            int r2 = r2 + 6
            r0 = 9
            int r0 = parse(r3, r2, r0)
            if (r0 < 0) goto L_0x00d4
            net.time4j.tz.OffsetSign r11 = net.time4j.tz.OffsetSign.BEHIND_UTC
            if (r5 != r11) goto L_0x00cf
            int r0 = -r0
        L_0x00cf:
            net.time4j.tz.ZonalOffset r11 = ofTotalSeconds(r6, r0)
            return r11
        L_0x00d4:
            if (r12 != 0) goto L_0x00d7
            return r1
        L_0x00d7:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "No canonical zonal offset: "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.ZonalOffset.parse(java.lang.String, boolean):net.time4j.tz.ZonalOffset");
    }

    /* access modifiers changed from: package-private */
    public SingleOffsetTimezone getModel() {
        return SingleOffsetTimezone.of(this);
    }

    private static int parse(String str, int i, int i2) {
        int min = Math.min(str.length() - i, i2);
        int i3 = -1;
        for (int i4 = 0; i4 < min; i4++) {
            char charAt = str.charAt(i + i4);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i3 = i3 == -1 ? charAt - '0' : (i3 * 10) + (charAt - '0');
        }
        return i3;
    }

    private static String format(int i, int i2) {
        return "[hours=" + i + ",minutes=" + i2 + AbstractJsonLexerKt.END_LIST;
    }

    private Object writeReplace() {
        return new SPX(this, 15);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
