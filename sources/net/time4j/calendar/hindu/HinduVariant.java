package net.time4j.calendar.hindu;

import com.stripe.android.view.PaymentMethodsActivityStarter;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.calendar.IndianMonth;
import net.time4j.calendar.astro.GeoLocation;
import net.time4j.calendar.astro.JulianDay;
import net.time4j.calendar.astro.MoonPhase;
import net.time4j.calendar.astro.StdSolarCalculator;
import net.time4j.engine.EpochDays;
import net.time4j.engine.VariantSource;
import net.time4j.scale.TimeScale;

public final class HinduVariant implements VariantSource, Serializable {
    private static final HinduRule[] RULES = HinduRule.values();
    private static final int TYPE_OLD_LUNAR = -2;
    private static final int TYPE_OLD_SOLAR = -1;
    static final GeoLocation UJJAIN = new HinduLocation(23.15d, 75.76833333333333d, 0);
    private static final double U_OFFSET = 18184.4d;
    static final HinduVariant VAR_OLD_LUNAR = new HinduVariant(AryaSiddhanta.LUNAR);
    static final HinduVariant VAR_OLD_SOLAR = new HinduVariant(AryaSiddhanta.SOLAR);
    private final transient HinduEra defaultEra;
    /* access modifiers changed from: private */
    public final transient double depressionAngle;
    private final transient boolean elapsedMode;
    private final transient GeoLocation location;
    private final transient int type;

    private interface LongFunction {
        double apply(long j);
    }

    @Deprecated
    public HinduVariant withAlternativeHinduSunrise() {
        return this;
    }

    HinduVariant(HinduRule hinduRule, HinduEra hinduEra) {
        this(hinduRule.ordinal(), hinduEra, useStandardElapsedMode(hinduEra, hinduRule), Double.NaN, UJJAIN);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private HinduVariant(AryaSiddhanta aryaSiddhanta) {
        this(aryaSiddhanta == AryaSiddhanta.SOLAR ? -1 : -2, HinduEra.KALI_YUGA, true, Double.NaN, UJJAIN);
    }

    private HinduVariant(int i, HinduEra hinduEra, boolean z, double d, GeoLocation geoLocation) {
        if (i < -2 || i >= HinduRule.values().length) {
            throw new IllegalArgumentException("Undefined Hindu rule.");
        }
        Objects.requireNonNull(hinduEra, "Missing default Hindu era.");
        Objects.requireNonNull(geoLocation, "Missing geographical location.");
        if (Double.isInfinite(d)) {
            throw new IllegalArgumentException("Infinite depression angle.");
        } else if (Double.isNaN(d) || Math.abs(d) <= 10.0d) {
            this.type = i;
            this.defaultEra = hinduEra;
            this.elapsedMode = z;
            this.depressionAngle = d;
            this.location = geoLocation;
        } else {
            throw new IllegalArgumentException("Depression angle is too big: " + d);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008c, code lost:
        if (r8 == 0) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008e, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (r6 == UJJAIN.getLongitude()) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b7, code lost:
        if (r4 == UJJAIN.getLatitude()) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.time4j.calendar.hindu.HinduVariant from(java.lang.String r21) {
        /*
            r1 = r21
            java.lang.String r0 = "AryaSiddhanta@"
            boolean r0 = r1.startsWith(r0)
            java.lang.String r2 = "Invalid variant: "
            if (r0 == 0) goto L_0x0036
            r0 = 14
            java.lang.String r0 = r1.substring(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0020 }
            net.time4j.calendar.hindu.AryaSiddhanta r0 = net.time4j.calendar.hindu.AryaSiddhanta.valueOf(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0020 }
            net.time4j.calendar.hindu.AryaSiddhanta r3 = net.time4j.calendar.hindu.AryaSiddhanta.SOLAR     // Catch:{ IndexOutOfBoundsException -> 0x0020 }
            if (r0 != r3) goto L_0x001d
            net.time4j.calendar.hindu.HinduVariant r0 = VAR_OLD_SOLAR     // Catch:{ IndexOutOfBoundsException -> 0x0020 }
            goto L_0x001f
        L_0x001d:
            net.time4j.calendar.hindu.HinduVariant r0 = VAR_OLD_LUNAR     // Catch:{ IndexOutOfBoundsException -> 0x0020 }
        L_0x001f:
            return r0
        L_0x0020:
            r0 = move-exception
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1, r0)
            throw r3
        L_0x0036:
            java.util.StringTokenizer r0 = new java.util.StringTokenizer
            java.lang.String r3 = "|"
            r0.<init>(r1, r3)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 0
            r5 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            net.time4j.calendar.astro.GeoLocation r7 = UJJAIN
            double r8 = r7.getLatitude()
            double r10 = r7.getLongitude()
            int r7 = r7.getAltitude()
            r12 = 0
            r13 = 1
            r16 = r4
            r18 = r5
            r4 = r8
            r3 = 0
            r9 = 1
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            r17 = 1
            r8 = r7
            r6 = r10
        L_0x005f:
            boolean r10 = r0.hasMoreTokens()
            if (r10 == 0) goto L_0x00f8
            int r3 = r3 + r13
            java.lang.String r10 = r0.nextToken()
            switch(r3) {
                case 1: goto L_0x00ed;
                case 2: goto L_0x00e5;
                case 3: goto L_0x00dd;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00a7;
                case 6: goto L_0x0092;
                case 7: goto L_0x0082;
                default: goto L_0x006d;
            }
        L_0x006d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x0082:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            int r8 = r8.intValue()
            if (r9 == 0) goto L_0x0090
            if (r8 != 0) goto L_0x0090
        L_0x008e:
            r9 = 1
            goto L_0x005f
        L_0x0090:
            r9 = 0
            goto L_0x005f
        L_0x0092:
            java.lang.Double r6 = java.lang.Double.valueOf(r10)
            double r6 = r6.doubleValue()
            if (r9 == 0) goto L_0x0090
            net.time4j.calendar.astro.GeoLocation r9 = UJJAIN
            double r9 = r9.getLongitude()
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0090
            goto L_0x008e
        L_0x00a7:
            java.lang.Double r4 = java.lang.Double.valueOf(r10)
            double r4 = r4.doubleValue()
            net.time4j.calendar.astro.GeoLocation r9 = UJJAIN
            double r9 = r9.getLatitude()
            int r11 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x0090
            goto L_0x008e
        L_0x00ba:
            java.lang.String r11 = "oldstyle"
            boolean r11 = r10.equals(r11)
            if (r11 != 0) goto L_0x005f
            java.lang.String r11 = "alt"
            boolean r11 = r10.equals(r11)
            if (r11 != 0) goto L_0x005f
            java.lang.String r11 = "std"
            boolean r11 = r10.equals(r11)
            if (r11 != 0) goto L_0x005f
            java.lang.Double r10 = java.lang.Double.valueOf(r10)
            double r10 = r10.doubleValue()
            r18 = r10
            goto L_0x005f
        L_0x00dd:
            java.lang.String r11 = "elapsed"
            boolean r17 = r10.equals(r11)
            goto L_0x005f
        L_0x00e5:
            net.time4j.calendar.hindu.HinduEra r10 = net.time4j.calendar.hindu.HinduEra.valueOf(r10)
            r16 = r10
            goto L_0x005f
        L_0x00ed:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            int r10 = r10.intValue()
            r15 = r10
            goto L_0x005f
        L_0x00f8:
            if (r15 < 0) goto L_0x0125
            net.time4j.calendar.hindu.HinduVariant r0 = new net.time4j.calendar.hindu.HinduVariant     // Catch:{ Exception -> 0x0110 }
            if (r9 == 0) goto L_0x0103
            net.time4j.calendar.astro.GeoLocation r3 = UJJAIN     // Catch:{ Exception -> 0x0110 }
            r20 = r3
            goto L_0x010b
        L_0x0103:
            net.time4j.calendar.hindu.HinduVariant$HinduLocation r9 = new net.time4j.calendar.hindu.HinduVariant$HinduLocation     // Catch:{ Exception -> 0x0110 }
            r3 = r9
            r3.<init>(r4, r6, r8)     // Catch:{ Exception -> 0x0110 }
            r20 = r9
        L_0x010b:
            r14 = r0
            r14.<init>(r15, r16, r17, r18, r20)     // Catch:{ Exception -> 0x0110 }
            return r0
        L_0x0110:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x0125:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.hindu.HinduVariant.from(java.lang.String):net.time4j.calendar.hindu.HinduVariant");
    }

    public HinduEra getDefaultEra() {
        return this.defaultEra;
    }

    public GeoLocation getLocation() {
        return this.location;
    }

    public boolean isSolar() {
        return !isLunisolar();
    }

    public boolean isLunisolar() {
        return isAmanta() || isPurnimanta();
    }

    public boolean isAmanta() {
        int i = this.type;
        if (i == -2) {
            return true;
        }
        if (i < HinduRule.AMANTA.ordinal() || this.type >= HinduRule.PURNIMANTA.ordinal()) {
            return false;
        }
        return true;
    }

    public boolean isPurnimanta() {
        return this.type == HinduRule.PURNIMANTA.ordinal();
    }

    public boolean isOld() {
        return this.type < 0;
    }

    public boolean isUsingElapsedYears() {
        return this.elapsedMode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HinduVariant)) {
            return false;
        }
        HinduVariant hinduVariant = (HinduVariant) obj;
        if (this.type == hinduVariant.type && this.defaultEra == hinduVariant.defaultEra && this.elapsedMode == hinduVariant.elapsedMode && equals(this.depressionAngle, hinduVariant.depressionAngle) && this.location.getLatitude() == hinduVariant.location.getLatitude() && this.location.getLongitude() == hinduVariant.location.getLongitude() && this.location.getAltitude() == hinduVariant.location.getAltitude()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.type + (this.defaultEra.hashCode() * 17) + (this.elapsedMode ? 1 : 0);
        int i = 100;
        if (!Double.isNaN(this.depressionAngle)) {
            i = ((int) this.depressionAngle) * 100;
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hindu-variant=[");
        int i = this.type;
        if (i == -2) {
            sb.append("OLD-LUNAR");
        } else if (i != -1) {
            sb.append(getRule().name());
        } else {
            sb.append("OLD-SOLAR");
        }
        if (!isOld()) {
            sb.append("|default-era=");
            sb.append(this.defaultEra.name());
            sb.append('|');
            sb.append(this.elapsedMode ? "elapsed-year-mode" : "current-year-mode");
            if (!Double.isNaN(this.depressionAngle)) {
                sb.append("|depression-angle=");
                sb.append(this.depressionAngle);
            }
            if (this.location != UJJAIN) {
                sb.append("|lat=");
                sb.append(this.location.getLatitude());
                sb.append(",lng=");
                sb.append(this.location.getLongitude());
                int altitude = this.location.getAltitude();
                if (altitude != 0) {
                    sb.append(",alt=");
                    sb.append(altitude);
                }
            }
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public String getVariant() {
        if (isOld()) {
            AryaSiddhanta aryaSiddhanta = this.type == -1 ? AryaSiddhanta.SOLAR : AryaSiddhanta.LUNAR;
            return "AryaSiddhanta@" + aryaSiddhanta.name();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append('|');
        sb.append(this.defaultEra.name());
        sb.append('|');
        sb.append(this.elapsedMode ? "elapsed" : "current");
        sb.append('|');
        sb.append(Double.isNaN(this.depressionAngle) ? "oldstyle" : Double.valueOf(this.depressionAngle));
        if (this.location != UJJAIN) {
            sb.append('|');
            sb.append(this.location.getLatitude());
            sb.append('|');
            sb.append(this.location.getLongitude());
            int altitude = this.location.getAltitude();
            if (altitude != 0) {
                sb.append('|');
                sb.append(altitude);
            }
        }
        return sb.toString();
    }

    public HinduVariant with(HinduEra hinduEra) {
        if (isOld() || this.defaultEra.equals(hinduEra)) {
            return this;
        }
        return new HinduVariant(this.type, hinduEra, this.elapsedMode, this.depressionAngle, this.location);
    }

    public HinduVariant withElapsedYears() {
        return (isOld() || this.elapsedMode) ? this : new HinduVariant(this.type, this.defaultEra, true, this.depressionAngle, this.location);
    }

    public HinduVariant withCurrentYears() {
        return (isOld() || !this.elapsedMode) ? this : new HinduVariant(this.type, this.defaultEra, false, this.depressionAngle, this.location);
    }

    public HinduVariant withModernAstronomy(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Depression angle must be a finite number.");
        } else if (isOld()) {
            return this;
        } else {
            return new HinduVariant(this.type, this.defaultEra, this.elapsedMode, d, this.location);
        }
    }

    public HinduVariant withAlternativeLocation(GeoLocation geoLocation) {
        if (Math.abs(geoLocation.getLatitude()) > 60.0d) {
            throw new IllegalArgumentException("Latitudes beyond +/-60° degrees not supported.");
        } else if (isOld()) {
            return this;
        } else {
            if (geoLocation.getLatitude() == this.location.getLatitude() && geoLocation.getLongitude() == this.location.getLongitude() && geoLocation.getAltitude() == this.location.getAltitude()) {
                return this;
            }
            return new HinduVariant(this.type, this.defaultEra, this.elapsedMode, this.depressionAngle, geoLocation);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean prefersRasiNames() {
        return this.type == HinduRule.MADRAS.ordinal() || this.type == HinduRule.MALAYALI.ordinal();
    }

    /* access modifiers changed from: package-private */
    public HinduCS getCalendarSystem() {
        int i = this.type;
        if (i == -2) {
            return AryaSiddhanta.LUNAR.getCalendarSystem();
        }
        if (i != -1) {
            return new ModernHinduCS(this);
        }
        return AryaSiddhanta.SOLAR.getCalendarSystem();
    }

    /* access modifiers changed from: package-private */
    public int getFirstMonthOfYear() {
        IndianMonth indianMonth;
        if (isOld()) {
            return 1;
        }
        int i = AnonymousClass1.$SwitchMap$net$time4j$calendar$hindu$HinduRule[getRule().ordinal()];
        if (i == 1) {
            indianMonth = IndianMonth.ASHADHA;
        } else if (i != 2) {
            indianMonth = IndianMonth.CHAITRA;
        } else {
            indianMonth = IndianMonth.KARTIKA;
        }
        return indianMonth.getValue();
    }

    /* access modifiers changed from: package-private */
    public HinduCS toAmanta() {
        return new HinduVariant(HinduRule.AMANTA.ordinal(), this.defaultEra, this.elapsedMode, this.depressionAngle, this.location).getCalendarSystem();
    }

    /* access modifiers changed from: private */
    public boolean useModernAstronomy() {
        return !Double.isNaN(this.depressionAngle);
    }

    /* renamed from: net.time4j.calendar.hindu.HinduVariant$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$hindu$HinduEra;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$hindu$HinduRule;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006f */
        static {
            /*
                net.time4j.calendar.hindu.HinduEra[] r0 = net.time4j.calendar.hindu.HinduEra.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$hindu$HinduEra = r0
                r1 = 1
                net.time4j.calendar.hindu.HinduEra r2 = net.time4j.calendar.hindu.HinduEra.SAKA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$net$time4j$calendar$hindu$HinduEra     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.hindu.HinduEra r3 = net.time4j.calendar.hindu.HinduEra.KOLLAM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                net.time4j.calendar.hindu.HinduRule[] r2 = net.time4j.calendar.hindu.HinduRule.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$net$time4j$calendar$hindu$HinduRule = r2
                net.time4j.calendar.hindu.HinduRule r3 = net.time4j.calendar.hindu.HinduRule.AMANTA_ASHADHA     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$net$time4j$calendar$hindu$HinduRule     // Catch:{ NoSuchFieldError -> 0x0038 }
                net.time4j.calendar.hindu.HinduRule r2 = net.time4j.calendar.hindu.HinduRule.AMANTA_KARTIKA     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$net$time4j$calendar$hindu$HinduRule     // Catch:{ NoSuchFieldError -> 0x0043 }
                net.time4j.calendar.hindu.HinduRule r1 = net.time4j.calendar.hindu.HinduRule.MADRAS     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$net$time4j$calendar$hindu$HinduRule     // Catch:{ NoSuchFieldError -> 0x004e }
                net.time4j.calendar.hindu.HinduRule r1 = net.time4j.calendar.hindu.HinduRule.MALAYALI     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$net$time4j$calendar$hindu$HinduRule     // Catch:{ NoSuchFieldError -> 0x0059 }
                net.time4j.calendar.hindu.HinduRule r1 = net.time4j.calendar.hindu.HinduRule.TAMIL     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = $SwitchMap$net$time4j$calendar$hindu$HinduRule     // Catch:{ NoSuchFieldError -> 0x0064 }
                net.time4j.calendar.hindu.HinduRule r1 = net.time4j.calendar.hindu.HinduRule.ORISSA     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = $SwitchMap$net$time4j$calendar$hindu$HinduRule     // Catch:{ NoSuchFieldError -> 0x006f }
                net.time4j.calendar.hindu.HinduRule r1 = net.time4j.calendar.hindu.HinduRule.AMANTA     // Catch:{ NoSuchFieldError -> 0x006f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = $SwitchMap$net$time4j$calendar$hindu$HinduRule     // Catch:{ NoSuchFieldError -> 0x007b }
                net.time4j.calendar.hindu.HinduRule r1 = net.time4j.calendar.hindu.HinduRule.PURNIMANTA     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.hindu.HinduVariant.AnonymousClass1.<clinit>():void");
        }
    }

    private static boolean useStandardElapsedMode(HinduEra hinduEra, HinduRule hinduRule) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$calendar$hindu$HinduEra[hinduEra.ordinal()];
        if (i != 1) {
            return i != 2;
        }
        int i2 = AnonymousClass1.$SwitchMap$net$time4j$calendar$hindu$HinduRule[hinduRule.ordinal()];
        return (i2 == 3 || i2 == 4 || i2 == 5) ? false : true;
    }

    private static boolean equals(double d, double d2) {
        if (Double.isNaN(d)) {
            return Double.isNaN(d2);
        }
        return !Double.isNaN(d2) && d == d2;
    }

    /* access modifiers changed from: private */
    public HinduRule getRule() {
        return RULES[this.type];
    }

    private Object writeReplace() {
        return new SPX(this, 21);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    static class ModernHinduCS extends HinduCS {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final double ANOMALISTIC_MONTH = 27.554597974680476d;
        private static final double ANOMALISTIC_YEAR = 365.25878920258134d;
        private static final boolean CC = false;
        private static final double CREATION = -7.14403429586E11d;
        private static final double EPSILON = Math.pow(2.0d, -1000.0d);
        private static final int MAX_YEAR = 5999;
        private static final double MEAN_SIDEREAL_YEAR = 365.25636d;
        private static final double MEAN_SYNODIC_MONTH = 29.530588861d;
        private static final int MIN_YEAR = 1200;
        private static final double[] RISING_SIGN_FACTORS = {0.9277777777777778d, 0.9972222222222222d, 1.075d, 1.075d, 0.9972222222222222d, 0.9277777777777778d};
        private static final double SIDEREAL_MONTH = 27.321674162683866d;
        static final double SIDEREAL_START = 336.1360765905204d;
        static final double SIDEREAL_YEAR = 365.2587564814815d;
        private static final double SYNODIC_MONTH = 29.53058794607172d;
        private volatile long max = Long.MAX_VALUE;
        private volatile long min = Long.MIN_VALUE;

        static {
            Class<HinduVariant> cls = HinduVariant.class;
        }

        ModernHinduCS(HinduVariant hinduVariant) {
            super(hinduVariant);
        }

        /* access modifiers changed from: package-private */
        public HinduCalendar create(long j) {
            int i;
            HinduVariant hinduVariant = this.variant;
            switch (AnonymousClass1.$SwitchMap$net$time4j$calendar$hindu$HinduRule[getRule().ordinal()]) {
                case 1:
                case 2:
                    HinduCalendar create = hinduVariant.toAmanta().create(j);
                    int expiredYearOfKaliYuga = create.getExpiredYearOfKaliYuga();
                    if (create.getMonth().getValue().getValue() < hinduVariant.getFirstMonthOfYear()) {
                        expiredYearOfKaliYuga--;
                    }
                    return new HinduCalendar(hinduVariant, expiredYearOfKaliYuga, create.getMonth(), create.getDayOfMonth(), j);
                case 3:
                case 4:
                case 5:
                case 6:
                    return hSolarFromFixed(j, hinduVariant);
                case 7:
                    return hLunarFromFixed(j, hinduVariant);
                case 8:
                    HinduCS amanta = hinduVariant.toAmanta();
                    HinduCalendar create2 = amanta.create(j);
                    if (create2.getDayOfMonth().getValue() >= 16) {
                        i = amanta.create(20 + j).getMonth().getValue().getValue();
                    } else {
                        i = create2.getMonth().getValue().getValue();
                    }
                    HinduMonth ofLunisolar = HinduMonth.ofLunisolar(i);
                    if (create2.getMonth().isLeap()) {
                        ofLunisolar = ofLunisolar.withLeap();
                    }
                    return new HinduCalendar(hinduVariant, create2.getExpiredYearOfKaliYuga(), ofLunisolar, create2.getDayOfMonth(), j);
                default:
                    throw new UnsupportedOperationException(getRule().name());
            }
        }

        /* access modifiers changed from: package-private */
        public HinduCalendar create(int i, HinduMonth hinduMonth, HinduDay hinduDay) {
            long j;
            HinduMonth hinduMonth2;
            HinduVariant hinduVariant = this.variant;
            switch (AnonymousClass1.$SwitchMap$net$time4j$calendar$hindu$HinduRule[getRule().ordinal()]) {
                case 1:
                case 2:
                    return new HinduCalendar(hinduVariant, i, hinduMonth, hinduDay, hinduVariant.toAmanta().create(hinduMonth.getValue().getValue() < hinduVariant.getFirstMonthOfYear() ? i + 1 : i, hinduMonth, hinduDay).getDaysSinceEpochUTC());
                case 3:
                case 4:
                case 5:
                case 6:
                    j = hFixedFromSolar(i, hinduMonth, hinduDay, hinduVariant);
                    break;
                case 7:
                    j = hFixedFromLunar(i, hinduMonth, hinduDay, hinduVariant);
                    break;
                case 8:
                    if (hinduMonth.isLeap() || hinduDay.getValue() <= 15) {
                        hinduMonth2 = hinduMonth;
                    } else {
                        hinduMonth2 = this.variant.toAmanta().isExpunged(i, prevMonth(hinduMonth, 1)) ? prevMonth(hinduMonth, 2) : prevMonth(hinduMonth, 1);
                    }
                    j = hFixedFromLunar(i, hinduMonth2, hinduDay, hinduVariant);
                    break;
                default:
                    throw new UnsupportedOperationException(getRule().name());
            }
            return new HinduCalendar(hinduVariant, i, hinduMonth, hinduDay, j);
        }

        /* access modifiers changed from: package-private */
        public boolean isValid(int i, HinduMonth hinduMonth, HinduDay hinduDay) {
            HinduCS hinduCS;
            if (i < MIN_YEAR || i > MAX_YEAR || hinduMonth == null || hinduDay == null) {
                return false;
            }
            if (this.variant.isSolar() && (hinduMonth.isLeap() || hinduDay.isLeap())) {
                return false;
            }
            if (this.variant.isLunisolar() && hinduDay.getValue() > 30) {
                return false;
            }
            HinduRule rule = getRule();
            if (rule == HinduRule.AMANTA_ASHADHA || rule == HinduRule.AMANTA_KARTIKA) {
                if (hinduMonth.getValue().getValue() < this.variant.getFirstMonthOfYear()) {
                    i++;
                }
                hinduCS = this.variant.toAmanta();
            } else {
                hinduCS = this;
            }
            return !hinduCS.isExpunged(i, hinduMonth, hinduDay);
        }

        public long getMinimumSinceUTC() {
            HinduCalendar hinduCalendar;
            if (this.min == Long.MIN_VALUE) {
                if (this.variant.isPurnimanta()) {
                    hinduCalendar = createNewYear(1201).withFirstDayOfMonth();
                } else {
                    hinduCalendar = createNewYear(MIN_YEAR);
                }
                this.min = hinduCalendar.getDaysSinceEpochUTC();
            }
            return this.min;
        }

        public long getMaximumSinceUTC() {
            if (this.max == Long.MAX_VALUE) {
                HinduCalendar createNewYear = createNewYear(PaymentMethodsActivityStarter.REQUEST_CODE);
                if (this.variant.isPurnimanta()) {
                    createNewYear = createNewYear.withFirstDayOfMonth();
                }
                this.max = createNewYear.getDaysSinceEpochUTC() - 1;
            }
            return this.max;
        }

        private HinduCalendar createNewYear(int i) {
            return create(i, HinduMonth.of(IndianMonth.AGRAHAYANA), HinduDay.valueOf(1)).withNewYear();
        }

        private HinduRule getRule() {
            return this.variant.getRule();
        }

        private static HinduMonth prevMonth(HinduMonth hinduMonth, int i) {
            int value = hinduMonth.getValue().getValue() - i;
            if (value <= 0) {
                value += 12;
            }
            return HinduMonth.ofLunisolar(value);
        }

        private static double hSineTable(double d) {
            double sin = Math.sin(Math.toRadians(d * 3.75d)) * 3438.0d;
            return Math.floor((sin + ((Math.signum(sin) * 0.215d) * Math.signum(Math.abs(sin) - 1716.0d))) + 0.5d) / 3438.0d;
        }

        private static double hSine(double d) {
            double d2 = d / 3.75d;
            double modulo = modulo(d2, 1.0d);
            return (hSineTable(Math.ceil(d2)) * modulo) + ((1.0d - modulo) * hSineTable(Math.floor(d2)));
        }

        private static double hArcSin(double d) {
            if (d < EPSILON) {
                return -hArcSin(-d);
            }
            int i = 0;
            while (true) {
                double d2 = (double) i;
                if (d > hSineTable(d2)) {
                    i++;
                } else {
                    double d3 = (double) (i - 1);
                    double hSineTable = hSineTable(d3);
                    return (d3 + ((d - hSineTable) / (hSineTable(d2) - hSineTable))) * 3.75d;
                }
            }
        }

        private static double hMeanPosition(double d, double d2) {
            return modulo((d - CREATION) / d2, 1.0d) * 360.0d;
        }

        private static double hTruePosition(double d, double d2, double d3, double d4, double d5) {
            double hMeanPosition = hMeanPosition(d, d2);
            double hSine = hSine(hMeanPosition(d, d4));
            return modulo(hMeanPosition - hArcSin(hSine * (d3 - ((Math.abs(hSine) * d5) * d3))), 360.0d);
        }

        private static double hSiderealSolarLongitude(double d) {
            return modulo((StdSolarCalculator.CC.getFeature(toJDE(d).getValue(), "solar-longitude") - hPrecession(d)) + SIDEREAL_START, 360.0d);
        }

        static double hSolarLongitude(double d) {
            return hTruePosition(d, SIDEREAL_YEAR, 0.03888888888888889d, ANOMALISTIC_YEAR, 0.023809523809523808d);
        }

        static double hPrecession(double d) {
            double centuryJ2000 = toJDE(d).getCenturyJ2000();
            double modulo = modulo(((((1.6666666666666667E-8d * centuryJ2000) - 471276.84419128887d) * centuryJ2000) + 0.01305636111111111d) * centuryJ2000, 360.0d);
            double modulo2 = modulo((((9.822222222222223E-6d * centuryJ2000) - 17.073461333333334d) * centuryJ2000) + 174.876384d, 360.0d);
            return modulo((modulo(((((((((double) -1) * 6.0E-6d) / 3600.0d) * centuryJ2000) + 3.0864722222222223E-4d) * centuryJ2000) + 1.3969712777777776d) * centuryJ2000, 360.0d) + modulo2) - Math.toDegrees(Math.atan2(Math.cos(Math.toRadians(modulo)) * Math.sin(Math.toRadians(modulo2)), Math.cos(Math.toRadians(modulo2)))), 360.0d);
        }

        private static JulianDay toJDE(double d) {
            return JulianDay.ofEphemerisTime(Moment.of(Math.round(((d + 1721424.0d) - 2440587.0d) * 86400.0d), TimeScale.POSIX));
        }

        private static double toRataDie(Moment moment) {
            return ((((double) moment.getPosixTime()) / 86400.0d) + 2440587.0d) - 1721424.0d;
        }

        private static int hZodiac(double d) {
            return (int) (Math.floor(hSolarLongitude(d) / 30.0d) + 1.0d);
        }

        private static int hSiderealZodiac(double d) {
            return (int) (Math.floor(hSiderealSolarLongitude(d) / 30.0d) + 1.0d);
        }

        private static double hLunarLongitude(double d) {
            return hTruePosition(d, SIDEREAL_MONTH, 0.08888888888888889d, ANOMALISTIC_MONTH, 0.010416666666666666d);
        }

        private static double hLunarPhase(double d) {
            return modulo(hLunarLongitude(d) - hSolarLongitude(d), 360.0d);
        }

        private static int hLunarDayFromMoment(double d, HinduVariant hinduVariant) {
            double d2;
            if (hinduVariant.useModernAstronomy()) {
                double value = toJDE(d).getValue();
                d2 = modulo(StdSolarCalculator.CC.getFeature(value, "lunar-longitude") - StdSolarCalculator.CC.getFeature(value, "solar-longitude"), 360.0d);
                double modulo = modulo((d - nthNewMoon((int) Math.round((d - nthNewMoon(0)) / MEAN_SYNODIC_MONTH))) / MEAN_SYNODIC_MONTH, 1.0d) * 360.0d;
                if (Math.abs(d2 - modulo) > 180.0d) {
                    d2 = modulo;
                }
            } else {
                d2 = hLunarPhase(d);
            }
            return (int) (Math.floor(d2 / 12.0d) + 1.0d);
        }

        private static double nthNewMoon(int i) {
            return toRataDie(MoonPhase.NEW_MOON.atLunation(i - 24724));
        }

        private static double hNewMoonBefore(double d) {
            double hLunarPhase = d - ((hLunarPhase(d) * SYNODIC_MONTH) / 360.0d);
            return binarySearchLunarPhase(hLunarPhase - 1.0d, Math.min(d, hLunarPhase + 1.0d));
        }

        private static double binarySearchLunarPhase(double d, double d2) {
            double d3 = (d + d2) / 2.0d;
            if (hZodiac(d) == hZodiac(d2) || d2 - d < EPSILON) {
                return d3;
            }
            if (hLunarPhase(d3) < 180.0d) {
                return binarySearchLunarPhase(d, d3);
            }
            return binarySearchLunarPhase(d3, d2);
        }

        private static int hCalendarYear(double d, HinduVariant hinduVariant) {
            double floor;
            if (hinduVariant.useModernAstronomy()) {
                floor = Math.floor((((d - -1132959.0d) / MEAN_SIDEREAL_YEAR) + 0.5d) - (hSiderealSolarLongitude(d) / 360.0d));
            } else {
                floor = Math.floor((((d - -1132959.0d) / SIDEREAL_YEAR) + 0.5d) - (hSolarLongitude(d) / 360.0d));
            }
            return (int) floor;
        }

        private static HinduCalendar hSolarFromFixed(long j, HinduVariant hinduVariant) {
            long j2;
            int i;
            LongFunction hCritical = hCritical(hinduVariant);
            long transform = EpochDays.RATA_DIE.transform(j, EpochDays.UTC);
            double apply = hCritical.apply(transform);
            int hCalendarYear = hCalendarYear(apply, hinduVariant);
            if (hinduVariant.useModernAstronomy()) {
                i = hSiderealZodiac(apply);
                j2 = (transform - 3) - ((long) ((int) modulo(Math.floor(hSiderealSolarLongitude(apply)), 30.0d)));
                while (hSiderealZodiac(hCritical.apply(j2)) != i) {
                    j2++;
                }
            } else {
                i = hZodiac(apply);
                long modulo = (transform - 3) - ((long) ((int) modulo(Math.floor(hSolarLongitude(apply)), 30.0d)));
                while (hZodiac(hCritical.apply(j2)) != i) {
                    modulo = j2 + 1;
                }
            }
            return new HinduCalendar(hinduVariant, hCalendarYear, HinduMonth.ofSolar(i), HinduDay.valueOf((int) ((transform - j2) + 1)), j);
        }

        private static long hFixedFromSolar(int i, HinduMonth hinduMonth, HinduDay hinduDay, HinduVariant hinduVariant) {
            int rasi = hinduMonth.getRasi();
            LongFunction hCritical = hCritical(hinduVariant);
            long floor = ((long) Math.floor((hinduVariant.useModernAstronomy() ? MEAN_SIDEREAL_YEAR : SIDEREAL_YEAR) * (((double) i) + (((double) (rasi - 1)) / 12.0d)))) - 1132962;
            if (hinduVariant.useModernAstronomy()) {
                while (hSiderealZodiac(hCritical.apply(floor)) != rasi) {
                    floor++;
                }
            } else {
                while (hZodiac(hCritical.apply(floor)) != rasi) {
                    floor++;
                }
            }
            return EpochDays.UTC.transform(((long) (hinduDay.getValue() - 1)) + floor, EpochDays.RATA_DIE);
        }

        private static LongFunction hCritical(final HinduVariant hinduVariant) {
            int i = AnonymousClass1.$SwitchMap$net$time4j$calendar$hindu$HinduRule[hinduVariant.getRule().ordinal()];
            if (i == 3) {
                return new LongFunction() {
                    public double apply(long j) {
                        return ModernHinduCS.hStandardFromSundial((double) (j + 1), hinduVariant);
                    }
                };
            }
            if (i == 4) {
                return new LongFunction() {
                    public double apply(long j) {
                        return ModernHinduCS.hStandardFromSundial(((double) j) + 0.55d, hinduVariant);
                    }
                };
            }
            if (i == 5) {
                return new LongFunction() {
                    public double apply(long j) {
                        return ModernHinduCS.hSunset((double) j, hinduVariant);
                    }
                };
            }
            if (i == 6) {
                return new LongFunction() {
                    public double apply(long j) {
                        return ModernHinduCS.hSunrise((double) (j + 1), hinduVariant);
                    }
                };
            }
            throw new UnsupportedOperationException("Not yet implemented.");
        }

        private static HinduCalendar hLunarFromFixed(long j, HinduVariant hinduVariant) {
            int i;
            int i2;
            long transform = EpochDays.RATA_DIE.transform(j, EpochDays.UTC);
            double d = (double) transform;
            double hSunrise = hSunrise(d, hinduVariant);
            int hLunarDayFromMoment = hLunarDayFromMoment(hSunrise, hinduVariant);
            HinduDay valueOf = HinduDay.valueOf(hLunarDayFromMoment);
            if (hLunarDayFromMoment(hSunrise((double) (transform - 1), hinduVariant), hinduVariant) == hLunarDayFromMoment) {
                valueOf = valueOf.withLeap();
            }
            if (hinduVariant.useModernAstronomy()) {
                Moment moment = toJDE(hSunrise).toMoment();
                double rataDie = toRataDie(MoonPhase.NEW_MOON.before(moment));
                double rataDie2 = toRataDie(MoonPhase.NEW_MOON.atOrAfter(moment));
                i2 = hSiderealZodiac(rataDie);
                i = hSiderealZodiac(rataDie2);
            } else {
                double hNewMoonBefore = hNewMoonBefore(hSunrise);
                double hNewMoonBefore2 = hNewMoonBefore(Math.floor(hNewMoonBefore) + 35.0d);
                i2 = hZodiac(hNewMoonBefore);
                i = hZodiac(hNewMoonBefore2);
            }
            int i3 = i2 == 12 ? 1 : i2 + 1;
            HinduMonth ofLunisolar = HinduMonth.ofLunisolar(i3);
            if (i == i2) {
                ofLunisolar = ofLunisolar.withLeap();
            }
            if (i3 <= 2) {
                d += 180.0d;
            }
            return new HinduCalendar(hinduVariant, hCalendarYear(d, hinduVariant), ofLunisolar, valueOf, j);
        }

        private static long hFixedFromLunar(int i, HinduMonth hinduMonth, HinduDay hinduDay, HinduVariant hinduVariant) {
            double d;
            double d2;
            int i2 = i;
            HinduVariant hinduVariant2 = hinduVariant;
            int value = hinduMonth.getValue().getValue();
            if (hinduVariant.useModernAstronomy()) {
                d = ((((double) i2) + (((double) (value - 1)) / 12.0d)) * MEAN_SIDEREAL_YEAR) - 3.66120548278559E-6d;
                d2 = hSiderealSolarLongitude(d);
            } else {
                d = ((((double) i2) + (((double) (value - 1)) / 12.0d)) * SIDEREAL_YEAR) - 3.66120548278559E-6d;
                d2 = hSolarLongitude(d);
            }
            long floor = (long) Math.floor(d - ((modulo(((d2 / 360.0d) - (((double) (value - 1)) / 12.0d)) + 0.5d, 1.0d) - 8.0d) * SIDEREAL_YEAR));
            int hLunarDayFromMoment = hLunarDayFromMoment(((double) floor) + 0.25d, hinduVariant2);
            int value2 = hinduDay.getValue();
            if (hLunarDayFromMoment <= 3 || hLunarDayFromMoment >= 27) {
                HinduCalendar hLunarFromFixed = hLunarFromFixed(EpochDays.UTC.transform(floor - 15, EpochDays.RATA_DIE), hinduVariant2);
                if (hLunarFromFixed.getMonth().getValue() != hinduMonth.getValue() || (hLunarFromFixed.getMonth().isLeap() && !hinduMonth.isLeap())) {
                    hLunarDayFromMoment = ((int) modulo((double) (hLunarDayFromMoment + 15), 30.0d)) - 15;
                } else {
                    hLunarDayFromMoment = ((int) modulo((double) (hLunarDayFromMoment - 15), 30.0d)) + 15;
                }
            }
            long j = (floor + ((long) value2)) - ((long) hLunarDayFromMoment);
            long modulo = (14 + j) - ((long) ((int) modulo((double) ((hLunarDayFromMoment(((double) j) + 0.25d, hinduVariant2) - value2) + 15), 30.0d)));
            while (true) {
                int hLunarDayFromMoment2 = hLunarDayFromMoment(hSunrise((double) modulo, hinduVariant2), hinduVariant2);
                int modulo2 = (int) modulo((double) (value2 + 1), 30.0d);
                if (modulo2 == 0) {
                    modulo2 = 30;
                }
                if (hLunarDayFromMoment2 != value2 && hLunarDayFromMoment2 != modulo2) {
                    modulo++;
                }
            }
            if (hinduDay.isLeap()) {
                modulo++;
            }
            return EpochDays.UTC.transform(modulo, EpochDays.RATA_DIE);
        }

        private static double hAscensionalDifference(double d, GeoLocation geoLocation) {
            double hSine = hSine(hTropicalLongitude(d)) * 0.4063408958696917d;
            double latitude = geoLocation.getLatitude();
            return hArcSin(((hSine * (hSine(latitude) / hSine(latitude + 90.0d))) * -1.0d) / hSine(hArcSin(hSine) + 90.0d));
        }

        private static double hSolarSiderealDifference(double d) {
            return hDailyMotion(d) * hRisingSign(d);
        }

        private static double hEquationOfTime(double d) {
            double hSine = hSine(hMeanPosition(d, ANOMALISTIC_YEAR));
            return (hDailyMotion(d) / 360.0d) * (((57.3d * hSine) * (0.03888888888888889d - (Math.abs(hSine) / 1080.0d))) / 360.0d) * SIDEREAL_YEAR;
        }

        private static double hTropicalLongitude(double d) {
            return modulo(hSolarLongitude(d) - (27.0d - Math.abs((modulo((((d - -1132959.0d) * 3.80247937727211E-7d) - 0.25d) + 0.5d, 1.0d) - 8.0d) * 108.0d)), 360.0d);
        }

        private static double hDailyMotion(double d) {
            double hMeanPosition = hMeanPosition(d, ANOMALISTIC_YEAR);
            double floor = Math.floor(hMeanPosition / 3.75d);
            return (1.0d - (((hSineTable(floor + 1.0d) - hSineTable(floor)) * 15.28d) * (0.03888888888888889d - (Math.abs(hSine(hMeanPosition)) * 9.25925925925926E-4d)))) * 0.9856026545889308d;
        }

        private static double hRisingSign(double d) {
            return RISING_SIGN_FACTORS[(int) modulo((double) ((int) Math.floor(hTropicalLongitude(d) / 30.0d)), 6.0d)];
        }

        /* access modifiers changed from: private */
        public static double hSunrise(double d, HinduVariant hinduVariant) {
            if (hinduVariant.useModernAstronomy()) {
                GeoLocation location = hinduVariant.getLocation();
                double posixTime = (((double) StdSolarCalculator.CC.sunrise(PlainDate.of((long) Math.floor(d), EpochDays.RATA_DIE), location.getLatitude(), location.getLongitude(), hinduVariant.depressionAngle + 90.0d).getPosixTime()) + HinduVariant.U_OFFSET) / 86400.0d;
                return (((double) EpochDays.RATA_DIE.transform((long) Math.floor(posixTime), EpochDays.UNIX)) + posixTime) - Math.floor(posixTime);
            }
            return (((d + 0.25d) + ((HinduVariant.UJJAIN.getLongitude() - hinduVariant.getLocation().getLongitude()) / 360.0d)) - hEquationOfTime(d)) + (((hSolarSiderealDifference(d) * 0.25d) + hAscensionalDifference(d, hinduVariant.getLocation())) * 0.002770193582919304d);
        }

        /* access modifiers changed from: private */
        public static double hSunset(double d, HinduVariant hinduVariant) {
            if (hinduVariant.useModernAstronomy()) {
                GeoLocation location = hinduVariant.getLocation();
                double posixTime = (((double) StdSolarCalculator.CC.sunset(PlainDate.of((long) Math.floor(d), EpochDays.RATA_DIE), location.getLatitude(), location.getLongitude(), hinduVariant.depressionAngle + 90.0d).getPosixTime()) + HinduVariant.U_OFFSET) / 86400.0d;
                return (((double) EpochDays.RATA_DIE.transform((long) Math.floor(posixTime), EpochDays.UNIX)) + posixTime) - Math.floor(posixTime);
            }
            return (((d + 0.75d) + ((HinduVariant.UJJAIN.getLongitude() - hinduVariant.getLocation().getLongitude()) / 360.0d)) - hEquationOfTime(d)) + (((hSolarSiderealDifference(d) * 0.75d) - hAscensionalDifference(d, hinduVariant.getLocation())) * 0.002770193582919304d);
        }

        /* access modifiers changed from: private */
        public static double hStandardFromSundial(double d, HinduVariant hinduVariant) {
            double d2;
            double d3;
            double d4;
            double floor = Math.floor(d);
            double d5 = d - floor;
            int floor2 = (int) Math.floor(4.0d * d5);
            if (floor2 == 0) {
                d3 = hSunset(floor - 1.0d, hinduVariant);
                d4 = hSunrise(floor, hinduVariant);
                d2 = -0.25d;
            } else if (floor2 == 3) {
                double hSunset = hSunset(floor, hinduVariant);
                d4 = hSunrise(floor + 1.0d, hinduVariant);
                d3 = hSunset;
                d2 = 0.75d;
            } else {
                d3 = hSunrise(floor, hinduVariant);
                d4 = hSunset(floor, hinduVariant);
                d2 = 0.25d;
            }
            return d3 + ((d4 - d3) * 2.0d * (d5 - d2));
        }
    }

    private static class HinduLocation implements GeoLocation {
        private final int altitude;
        private final double latitude;
        private final double longitude;

        public double getLatitude() {
            return this.latitude;
        }

        public double getLongitude() {
            return this.longitude;
        }

        public int getAltitude() {
            return this.altitude;
        }

        HinduLocation(double d, double d2, int i) {
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new IllegalArgumentException("Latitude must be a finite value: " + d);
            } else if (Double.isNaN(d2) || Double.isInfinite(d2)) {
                throw new IllegalArgumentException("Longitude must be a finite value: " + d2);
            } else if (Double.compare(d, 90.0d) > 0 || Double.compare(d, -90.0d) < 0) {
                throw new IllegalArgumentException("Degrees out of range -90.0 <= latitude <= +90.0: " + d);
            } else if (Double.compare(d2, 180.0d) >= 0 || Double.compare(d2, -180.0d) < 0) {
                throw new IllegalArgumentException("Degrees out of range -180.0 <= longitude < +180.0: " + d2);
            } else if (i < 0 || i >= 11000) {
                throw new IllegalArgumentException("Meters out of range 0 <= altitude < +11,000: " + i);
            } else {
                this.latitude = d;
                this.longitude = d2;
                this.altitude = i;
            }
        }
    }
}
