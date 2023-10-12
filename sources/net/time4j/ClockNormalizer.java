package net.time4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Normalizer;
import net.time4j.engine.TimeSpan;

final class ClockNormalizer implements Normalizer<ClockUnit> {
    private static final Map<ClockUnit, ClockNormalizer> MAP_ONLY = fill(0);
    private static final Map<ClockUnit, ClockNormalizer> MAP_ROUND = fill(2);
    private static final Map<ClockUnit, ClockNormalizer> MAP_TRUNC = fill(1);
    private static final int ONLY_MODE = 0;
    private static final int ROUNDING_MODE = 2;
    private static final int TRUNCATE_MODE = 1;
    private final int mode;
    private final ClockUnit unit;

    private ClockNormalizer(ClockUnit clockUnit, int i) {
        this.unit = clockUnit;
        this.mode = i;
    }

    static ClockNormalizer ofOnlyMode(ClockUnit clockUnit) {
        ClockNormalizer clockNormalizer = MAP_ONLY.get(clockUnit);
        if (clockNormalizer != null) {
            return clockNormalizer;
        }
        throw new IllegalArgumentException(clockUnit.name());
    }

    static ClockNormalizer ofTruncateMode(ClockUnit clockUnit) {
        ClockNormalizer clockNormalizer = MAP_TRUNC.get(clockUnit);
        if (clockNormalizer != null) {
            return clockNormalizer;
        }
        throw new IllegalArgumentException(clockUnit.name());
    }

    static ClockNormalizer ofRoundingMode(ClockUnit clockUnit) {
        ClockNormalizer clockNormalizer = MAP_ROUND.get(clockUnit);
        if (clockNormalizer != null) {
            return clockNormalizer;
        }
        throw new IllegalArgumentException(clockUnit.name());
    }

    public Duration<ClockUnit> normalize(TimeSpan<? extends ClockUnit> timeSpan) {
        long j;
        int i = this.mode;
        if (i == 0) {
            return Duration.of(this.unit.convert(timeSpan), this.unit);
        }
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (TimeSpan.Item next : timeSpan.getTotalLength()) {
                ClockUnit clockUnit = (ClockUnit) next.getUnit();
                if (clockUnit.compareTo(this.unit) <= 0) {
                    arrayList.add(TimeSpan.Item.of(next.getAmount(), clockUnit));
                }
            }
            if (arrayList.isEmpty()) {
                return Duration.ofZero();
            }
            return new Duration<>(arrayList, timeSpan.isNegative());
        } else if (i == 2) {
            boolean isNegative = timeSpan.isNegative();
            Duration<? extends ClockUnit> plus = Duration.ofZero().plus(timeSpan);
            if (isNegative) {
                plus = plus.abs();
            }
            Duration<? extends ClockUnit> with = plus.with(Duration.STD_CLOCK_PERIOD);
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[this.unit.ordinal()];
            if (i2 == 1 || i2 == 2) {
                j = 30;
            } else if (i2 != 3 && i2 != 4 && i2 != 5) {
                return with;
            } else {
                j = 500;
            }
            if (with.getPartialAmount((ChronoUnit) ClockUnit.values()[this.unit.ordinal() + 1]) >= j) {
                with = with.plus(1, this.unit).with(Duration.STD_CLOCK_PERIOD);
            }
            Duration<? extends ClockUnit> with2 = with.with(this.unit.truncated());
            return isNegative ? with2.inverse() : with2;
        } else {
            throw new UnsupportedOperationException("Unknown mode: " + this.mode);
        }
    }

    /* renamed from: net.time4j.ClockNormalizer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$ClockUnit;

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
                net.time4j.ClockUnit[] r0 = net.time4j.ClockUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$ClockUnit = r0
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.ClockNormalizer.AnonymousClass1.<clinit>():void");
        }
    }

    private static Map<ClockUnit, ClockNormalizer> fill(int i) {
        EnumMap enumMap = new EnumMap(ClockUnit.class);
        for (ClockUnit clockUnit : ClockUnit.values()) {
            enumMap.put(clockUnit, new ClockNormalizer(clockUnit, i));
        }
        return Collections.unmodifiableMap(enumMap);
    }
}
