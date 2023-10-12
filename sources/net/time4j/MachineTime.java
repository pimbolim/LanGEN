package net.time4j;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.MathUtils;
import net.time4j.base.UnixTime;
import net.time4j.engine.TimeMetric;
import net.time4j.engine.TimePoint;
import net.time4j.engine.TimeSpan;
import net.time4j.format.TimeSpanFormatter;
import net.time4j.scale.TimeScale;
import net.time4j.scale.UniversalTime;
import org.apache.commons.lang3.ClassUtils;

public final class MachineTime<U> implements TimeSpan<U>, Comparable<MachineTime<U>>, Serializable {
    private static final int MRD = 1000000000;
    public static final TimeMetric<TimeUnit, MachineTime<TimeUnit>> ON_POSIX_SCALE = new Metric(TimeScale.POSIX, (AnonymousClass1) null);
    public static final TimeMetric<TimeUnit, MachineTime<SI>> ON_UTC_SCALE = new Metric(TimeScale.UTC, (AnonymousClass1) null);
    private static final MachineTime<TimeUnit> POSIX_ZERO = new MachineTime<>(0, 0, TimeScale.POSIX);
    private static final MachineTime<SI> UTC_ZERO = new MachineTime<>(0, 0, TimeScale.UTC);
    private static final long serialVersionUID = -4150291820807606229L;
    private final transient int nanos;
    private final transient TimeScale scale;
    private final transient long seconds;

    private static <T> T cast(Object obj) {
        return obj;
    }

    /* synthetic */ MachineTime(long j, int i, TimeScale timeScale, AnonymousClass1 r5) {
        this(j, i, timeScale);
    }

    private MachineTime(long j, int i, TimeScale timeScale) {
        while (i < 0) {
            i += MRD;
            j = MathUtils.safeSubtract(j, 1);
        }
        while (i >= MRD) {
            i -= MRD;
            j = MathUtils.safeAdd(j, 1);
        }
        if (j < 0 && i > 0) {
            j++;
            i -= MRD;
        }
        this.seconds = j;
        this.nanos = i;
        this.scale = timeScale;
    }

    public static MachineTime<TimeUnit> of(long j, TimeUnit timeUnit) {
        if (timeUnit.compareTo(TimeUnit.SECONDS) >= 0) {
            return ofPosixUnits(MathUtils.safeMultiply(j, TimeUnit.SECONDS.convert(1, timeUnit)), 0);
        }
        long safeMultiply = MathUtils.safeMultiply(j, TimeUnit.NANOSECONDS.convert(1, timeUnit));
        return ofPosixUnits(MathUtils.floorDivide(safeMultiply, (int) MRD), MathUtils.floorModulo(safeMultiply, (int) MRD));
    }

    public static MachineTime<SI> of(long j, SI si) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$SI[si.ordinal()];
        if (i == 1) {
            return ofSIUnits(j, 0);
        }
        if (i == 2) {
            return ofSIUnits(MathUtils.floorDivide(j, (int) MRD), MathUtils.floorModulo(j, (int) MRD));
        }
        throw new UnsupportedOperationException(si.name());
    }

    public static MachineTime<TimeUnit> ofPosixUnits(long j, int i) {
        if (j == 0 && i == 0) {
            return POSIX_ZERO;
        }
        return new MachineTime<>(j, i, TimeScale.POSIX);
    }

    public static MachineTime<SI> ofSIUnits(long j, int i) {
        if (j == 0 && i == 0) {
            return UTC_ZERO;
        }
        return new MachineTime<>(j, i, TimeScale.UTC);
    }

    public static MachineTime<TimeUnit> ofPosixSeconds(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Invalid value: " + d);
        }
        long floor = (long) Math.floor(d);
        return ofPosixUnits(floor, (int) ((d - ((double) floor)) * 1.0E9d));
    }

    public static MachineTime<TimeUnit> ofPosixSeconds(BigDecimal bigDecimal) {
        BigDecimal scale2 = bigDecimal.setScale(0, RoundingMode.FLOOR);
        return ofPosixUnits(scale2.longValueExact(), bigDecimal.subtract(scale2).multiply(BigDecimal.valueOf(1000000000)).setScale(0, RoundingMode.DOWN).intValueExact());
    }

    public static MachineTime<SI> ofSISeconds(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Invalid value: " + d);
        }
        long floor = (long) Math.floor(d);
        return ofSIUnits(floor, (int) ((d - ((double) floor)) * 1.0E9d));
    }

    public static MachineTime<SI> ofSISeconds(BigDecimal bigDecimal) {
        BigDecimal scale2 = bigDecimal.setScale(0, RoundingMode.FLOOR);
        return ofSIUnits(scale2.longValueExact(), bigDecimal.subtract(scale2).multiply(BigDecimal.valueOf(1000000000)).setScale(0, RoundingMode.DOWN).intValueExact());
    }

    public long getSeconds() {
        long j = this.seconds;
        return this.nanos < 0 ? j - 1 : j;
    }

    public int getFraction() {
        int i = this.nanos;
        return i < 0 ? i + MRD : i;
    }

    public TimeScale getScale() {
        return this.scale;
    }

    public List<TimeSpan.Item<U>> getTotalLength() {
        ArrayList arrayList = new ArrayList(2);
        if (this.seconds != 0) {
            arrayList.add(TimeSpan.Item.of(Math.abs(this.seconds), cast(this.scale == TimeScale.UTC ? SI.SECONDS : TimeUnit.SECONDS)));
        }
        if (this.nanos != 0) {
            arrayList.add(TimeSpan.Item.of((long) Math.abs(this.nanos), cast(this.scale == TimeScale.UTC ? SI.NANOSECONDS : TimeUnit.NANOSECONDS)));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean contains(Object obj) {
        if ((this.scale != TimeScale.POSIX || !TimeUnit.SECONDS.equals(obj)) && (this.scale != TimeScale.UTC || !SI.SECONDS.equals(obj))) {
            if (((this.scale != TimeScale.POSIX || !TimeUnit.NANOSECONDS.equals(obj)) && (this.scale != TimeScale.UTC || !SI.NANOSECONDS.equals(obj))) || this.nanos == 0) {
                return false;
            }
            return true;
        } else if (this.seconds != 0) {
            return true;
        } else {
            return false;
        }
    }

    public long getPartialAmount(Object obj) {
        if ((this.scale == TimeScale.POSIX && TimeUnit.SECONDS.equals(obj)) || (this.scale == TimeScale.UTC && SI.SECONDS.equals(obj))) {
            return Math.abs(this.seconds);
        }
        if ((this.scale != TimeScale.POSIX || !TimeUnit.NANOSECONDS.equals(obj)) && (this.scale != TimeScale.UTC || !SI.NANOSECONDS.equals(obj))) {
            return 0;
        }
        return (long) Math.abs(this.nanos);
    }

    public boolean isNegative() {
        return this.seconds < 0 || this.nanos < 0;
    }

    public boolean isPositive() {
        return this.seconds > 0 || this.nanos > 0;
    }

    public boolean isEmpty() {
        return this.seconds == 0 && this.nanos == 0;
    }

    public MachineTime<U> plus(long j, U u) {
        long j2;
        long j3;
        long j4 = this.seconds;
        int i = this.nanos;
        if (this.scale == TimeScale.POSIX) {
            TimeUnit cast = TimeUnit.class.cast(u);
            if (cast.compareTo(TimeUnit.SECONDS) >= 0) {
                j2 = MathUtils.safeAdd(j4, MathUtils.safeMultiply(j, TimeUnit.SECONDS.convert(1, cast)));
                return new MachineTime<>(j2, i, this.scale);
            }
            long safeAdd = MathUtils.safeAdd((long) i, MathUtils.safeMultiply(j, TimeUnit.NANOSECONDS.convert(1, cast)));
            j3 = MathUtils.safeAdd(j4, MathUtils.floorDivide(safeAdd, (int) MRD));
            i = MathUtils.floorModulo(safeAdd, (int) MRD);
        } else {
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$SI[SI.class.cast(u).ordinal()];
            if (i2 == 1) {
                j2 = MathUtils.safeAdd(j4, j);
                return new MachineTime<>(j2, i, this.scale);
            } else if (i2 == 2) {
                long safeAdd2 = MathUtils.safeAdd((long) i, j);
                j3 = MathUtils.safeAdd(j4, MathUtils.floorDivide(safeAdd2, (int) MRD));
                i = MathUtils.floorModulo(safeAdd2, (int) MRD);
            } else {
                throw new UnsupportedOperationException(u.toString());
            }
        }
        j2 = j3;
        return new MachineTime<>(j2, i, this.scale);
    }

    public MachineTime<U> plus(MachineTime<U> machineTime) {
        if (machineTime.isEmpty()) {
            return this;
        }
        if (isEmpty()) {
            return machineTime;
        }
        return new MachineTime<>(MathUtils.safeAdd(this.seconds, machineTime.seconds), this.nanos + machineTime.nanos, this.scale);
    }

    public MachineTime<U> minus(long j, U u) {
        return plus(negateExact(j), u);
    }

    public MachineTime<U> minus(MachineTime<U> machineTime) {
        if (machineTime.isEmpty()) {
            return this;
        }
        if (isEmpty()) {
            return machineTime.inverse();
        }
        return new MachineTime<>(MathUtils.safeSubtract(this.seconds, machineTime.seconds), this.nanos - machineTime.nanos, this.scale);
    }

    public MachineTime<U> abs() {
        return isNegative() ? new MachineTime<>(negateExact(this.seconds), -this.nanos, this.scale) : this;
    }

    public MachineTime<U> inverse() {
        if (isEmpty()) {
            return this;
        }
        return new MachineTime<>(negateExact(this.seconds), -this.nanos, this.scale);
    }

    public MachineTime<U> multipliedBy(long j) {
        Object obj;
        if (j == 1) {
            return this;
        }
        if (j != 0) {
            BigDecimal multiply = toBigDecimal().multiply(BigDecimal.valueOf(j));
            if (this.scale == TimeScale.POSIX) {
                obj = ofPosixSeconds(multiply);
            } else {
                obj = ofSISeconds(multiply);
            }
            return (MachineTime) cast(obj);
        } else if (this.scale == TimeScale.POSIX) {
            return (MachineTime) cast(POSIX_ZERO);
        } else {
            return (MachineTime) cast(UTC_ZERO);
        }
    }

    public MachineTime<U> multipliedBy(double d) {
        Object obj;
        if (d == 1.0d) {
            return this;
        }
        if (d == 0.0d) {
            if (this.scale == TimeScale.POSIX) {
                return (MachineTime) cast(POSIX_ZERO);
            }
            return (MachineTime) cast(UTC_ZERO);
        } else if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Not finite: " + d);
        } else {
            double doubleValue = toBigDecimal().doubleValue() * d;
            if (this.scale == TimeScale.POSIX) {
                obj = ofPosixSeconds(doubleValue);
            } else {
                obj = ofSISeconds(doubleValue);
            }
            return (MachineTime) cast(obj);
        }
    }

    public MachineTime<U> dividedBy(long j, RoundingMode roundingMode) {
        Object obj;
        if (j == 1) {
            return this;
        }
        BigDecimal divide = toBigDecimal().setScale(9, RoundingMode.FLOOR).divide(new BigDecimal(j), roundingMode);
        if (this.scale == TimeScale.POSIX) {
            obj = ofPosixSeconds(divide);
        } else {
            obj = ofSISeconds(divide);
        }
        return (MachineTime) cast(obj);
    }

    public <T extends TimePoint<? super U, T>> T addTo(T t) {
        Object obj;
        Object obj2;
        if (this.scale == TimeScale.POSIX) {
            obj2 = TimeUnit.SECONDS;
            obj = TimeUnit.NANOSECONDS;
        } else {
            obj2 = SI.SECONDS;
            obj = SI.NANOSECONDS;
        }
        return t.plus(this.seconds, obj2).plus((long) this.nanos, obj);
    }

    public <T extends TimePoint<? super U, T>> T subtractFrom(T t) {
        Object obj;
        Object obj2;
        if (this.scale == TimeScale.POSIX) {
            obj2 = TimeUnit.SECONDS;
            obj = TimeUnit.NANOSECONDS;
        } else {
            obj2 = SI.SECONDS;
            obj = SI.NANOSECONDS;
        }
        return t.minus(this.seconds, obj2).minus((long) this.nanos, obj);
    }

    public boolean isShorterThan(MachineTime<U> machineTime) {
        return abs().compareTo(machineTime.abs()) < 0;
    }

    public boolean isLongerThan(MachineTime<U> machineTime) {
        return abs().compareTo(machineTime.abs()) > 0;
    }

    public int compareTo(MachineTime<U> machineTime) {
        if (this.scale == machineTime.scale) {
            long j = this.seconds;
            long j2 = machineTime.seconds;
            if (j < j2) {
                return -1;
            }
            if (j > j2) {
                return 1;
            }
            return this.nanos - machineTime.nanos;
        }
        throw new ClassCastException("Different time scales.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MachineTime)) {
            return false;
        }
        MachineTime machineTime = (MachineTime) obj;
        if (this.seconds == machineTime.seconds && this.nanos == machineTime.nanos && this.scale == machineTime.scale) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.seconds;
        return ((((161 + ((int) (j ^ (j >>> 32)))) * 23) + this.nanos) * 23) + this.scale.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        createNumber(sb);
        sb.append("s [");
        sb.append(this.scale.name());
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public BigDecimal toBigDecimal() {
        StringBuilder sb = new StringBuilder();
        createNumber(sb);
        return new BigDecimal(sb.toString());
    }

    private void createNumber(StringBuilder sb) {
        if (isNegative()) {
            sb.append(SignatureVisitor.SUPER);
            sb.append(Math.abs(this.seconds));
        } else {
            sb.append(this.seconds);
        }
        if (this.nanos != 0) {
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            String valueOf = String.valueOf(Math.abs(this.nanos));
            for (int length = 9 - valueOf.length(); length > 0; length--) {
                sb.append('0');
            }
            sb.append(valueOf);
        }
    }

    private static long negateExact(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new ArithmeticException("Long overflow.");
    }

    private Object writeReplace() {
        return new SPX(this, 5);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public static final class Formatter extends TimeSpanFormatter<TimeUnit, MachineTime<TimeUnit>> {
        private Formatter(String str) {
            super(TimeUnit.class, str);
        }

        public static Formatter ofPattern(String str) {
            return new Formatter(str);
        }

        public void print(TimeSpan<? super TimeUnit> timeSpan, Appendable appendable) throws IOException {
            String pattern = getPattern();
            int length = pattern.length();
            StringBuilder sb = new StringBuilder(length);
            int i = 0;
            while (i < length) {
                char charAt = pattern.charAt(i);
                if (charAt == '\'') {
                    while (true) {
                        i++;
                        if (i < length) {
                            if (pattern.charAt(i) == '\'') {
                                int i2 = i + 1;
                                if (i2 >= length || pattern.charAt(i2) != '\'') {
                                    break;
                                }
                                i = i2;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    sb.append(charAt);
                }
                i++;
            }
            String sb2 = sb.toString();
            EnumSet<E> noneOf = EnumSet.noneOf(TimeUnit.class);
            if (sb2.contains("D")) {
                noneOf.add(TimeUnit.DAYS);
            }
            if (sb2.contains("h")) {
                noneOf.add(TimeUnit.HOURS);
            }
            if (sb2.contains("m")) {
                noneOf.add(TimeUnit.MINUTES);
            }
            if (sb2.contains("s")) {
                noneOf.add(TimeUnit.SECONDS);
            }
            if (sb2.contains("f")) {
                noneOf.add(TimeUnit.NANOSECONDS);
            }
            super.print(new Normalized(timeSpan, noneOf), appendable);
        }

        /* access modifiers changed from: protected */
        public MachineTime<TimeUnit> convert(Map<TimeUnit, Long> map, boolean z) {
            int safeCast = map.containsKey(TimeUnit.NANOSECONDS) ? MathUtils.safeCast(map.get(TimeUnit.NANOSECONDS).longValue()) : 0;
            long j = 0;
            for (Map.Entry next : map.entrySet()) {
                int i = AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[((TimeUnit) next.getKey()).ordinal()];
                int i2 = 1;
                if (i == 1) {
                    i2 = 86400;
                } else if (i == 2) {
                    i2 = NikonType2MakernoteDirectory.TAG_NIKON_SCAN;
                } else if (i == 3) {
                    i2 = 60;
                } else if (i != 4) {
                }
                j += MathUtils.safeMultiply(((Long) next.getValue()).longValue(), (long) i2);
            }
            if (z) {
                j = MathUtils.safeNegate(j);
                safeCast = -safeCast;
            }
            return MachineTime.ofPosixUnits(j, safeCast);
        }

        /* access modifiers changed from: protected */
        public TimeUnit getUnit(char c) {
            if (c == 'D') {
                return TimeUnit.DAYS;
            }
            if (c == 'f') {
                return TimeUnit.NANOSECONDS;
            }
            if (c == 'h') {
                return TimeUnit.HOURS;
            }
            if (c == 'm') {
                return TimeUnit.MINUTES;
            }
            if (c == 's') {
                return TimeUnit.SECONDS;
            }
            throw new IllegalArgumentException("Unsupported pattern symbol: " + c);
        }
    }

    /* renamed from: net.time4j.MachineTime$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$SI;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|8|(2:9|10)|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                java.util.concurrent.TimeUnit[] r0 = java.util.concurrent.TimeUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$util$concurrent$TimeUnit = r0
                r1 = 1
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$java$util$concurrent$TimeUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = $SwitchMap$java$util$concurrent$TimeUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = $SwitchMap$java$util$concurrent$TimeUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                net.time4j.SI[] r2 = net.time4j.SI.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$net$time4j$SI = r2
                net.time4j.SI r3 = net.time4j.SI.SECONDS     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$net$time4j$SI     // Catch:{ NoSuchFieldError -> 0x004e }
                net.time4j.SI r2 = net.time4j.SI.NANOSECONDS     // Catch:{ NoSuchFieldError -> 0x004e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.MachineTime.AnonymousClass1.<clinit>():void");
        }
    }

    private static class Normalized implements TimeSpan<TimeUnit> {
        private final TimeSpan<? super TimeUnit> duration;
        private final Set<TimeUnit> patternUnits;

        public boolean contains(TimeUnit timeUnit) {
            return true;
        }

        Normalized(TimeSpan<? super TimeUnit> timeSpan, Set<TimeUnit> set) {
            Objects.requireNonNull(timeSpan);
            this.duration = timeSpan;
            this.patternUnits = set;
        }

        public List<TimeSpan.Item<TimeUnit>> getTotalLength() {
            throw new AssertionError("Never called.");
        }

        public long getPartialAmount(TimeUnit timeUnit) {
            long j;
            long j2;
            if (timeUnit == TimeUnit.NANOSECONDS) {
                return this.duration.getPartialAmount(TimeUnit.NANOSECONDS);
            }
            long partialAmount = this.duration.getPartialAmount(TimeUnit.SECONDS);
            long j3 = 0;
            if (this.patternUnits.contains(TimeUnit.DAYS)) {
                j = partialAmount / 86400;
                partialAmount -= 86400 * j;
            } else {
                j = 0;
            }
            if (this.patternUnits.contains(TimeUnit.HOURS)) {
                j2 = partialAmount / 3600;
                partialAmount -= 3600 * j2;
            } else {
                j2 = 0;
            }
            if (this.patternUnits.contains(TimeUnit.MINUTES)) {
                long j4 = partialAmount / 60;
                partialAmount -= 60 * j4;
                j3 = j4;
            }
            int i = AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[timeUnit.ordinal()];
            if (i == 1) {
                return j;
            }
            if (i == 2) {
                return j2;
            }
            if (i == 3) {
                return j3;
            }
            if (i == 4) {
                return partialAmount;
            }
            throw new AssertionError("Never called.");
        }

        public boolean isNegative() {
            return this.duration.isNegative();
        }

        public boolean isPositive() {
            return this.duration.isPositive();
        }

        public boolean isEmpty() {
            return this.duration.isEmpty();
        }

        public <T extends TimePoint<? super TimeUnit, T>> T addTo(T t) {
            throw new AssertionError("Never called.");
        }

        public <T extends TimePoint<? super TimeUnit, T>> T subtractFrom(T t) {
            throw new AssertionError("Never called.");
        }
    }

    private static class Metric<U> implements TimeMetric<TimeUnit, MachineTime<U>> {
        private final TimeScale scale;

        public TimeMetric<TimeUnit, MachineTime<U>> reversible() {
            return this;
        }

        /* synthetic */ Metric(TimeScale timeScale, AnonymousClass1 r2) {
            this(timeScale);
        }

        private Metric(TimeScale timeScale) {
            this.scale = timeScale;
        }

        public <T extends TimePoint<? super TimeUnit, T>> MachineTime<U> between(T t, T t2) {
            int i;
            int i2;
            long j;
            if (this.scale == TimeScale.UTC && (t instanceof UniversalTime)) {
                UniversalTime universalTime = (UniversalTime) t;
                UniversalTime universalTime2 = (UniversalTime) t2;
                long elapsedTime = universalTime2.getElapsedTime(TimeScale.UTC);
                long elapsedTime2 = universalTime.getElapsedTime(TimeScale.UTC);
                if (elapsedTime < 0 || elapsedTime2 < 0) {
                    throw new UnsupportedOperationException("Cannot calculate SI-duration before 1972-01-01.");
                }
                j = elapsedTime - elapsedTime2;
                i = universalTime2.getNanosecond(TimeScale.UTC);
                i2 = universalTime.getNanosecond(TimeScale.UTC);
            } else if (t instanceof UnixTime) {
                UnixTime unixTime = (UnixTime) t;
                UnixTime unixTime2 = (UnixTime) t2;
                j = unixTime2.getPosixTime() - unixTime.getPosixTime();
                i = unixTime2.getNanosecond();
                i2 = unixTime.getNanosecond();
            } else {
                throw new UnsupportedOperationException("Machine time requires objects of type 'UnixTime'.");
            }
            return new MachineTime(j, i - i2, this.scale, (AnonymousClass1) null);
        }
    }
}
