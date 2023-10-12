package net.time4j;

import net.time4j.base.MathUtils;
import net.time4j.engine.ChronoUnit;
import net.time4j.scale.TimeScale;

public enum SI implements ChronoUnit {
    SECONDS(1.0d),
    NANOSECONDS(1.0E-9d);
    
    private final double length;

    public boolean isCalendrical() {
        return false;
    }

    private SI(double d) {
        this.length = d;
    }

    public long between(Moment moment, Moment moment2) {
        Moment.check1972(moment);
        Moment.check1972(moment2);
        int i = AnonymousClass1.$SwitchMap$net$time4j$SI[ordinal()];
        if (i == 1) {
            long elapsedTime = moment2.getElapsedTime(TimeScale.UTC) - moment.getElapsedTime(TimeScale.UTC);
            int i2 = (elapsedTime > 0 ? 1 : (elapsedTime == 0 ? 0 : -1));
            if (i2 >= 0) {
                return (i2 <= 0 || moment2.getNanosecond() >= moment.getNanosecond()) ? elapsedTime : elapsedTime - 1;
            }
            if (moment2.getNanosecond() > moment.getNanosecond()) {
                return elapsedTime + 1;
            }
            return elapsedTime;
        } else if (i == 2) {
            return MathUtils.safeAdd(MathUtils.safeMultiply(MathUtils.safeSubtract(moment2.getElapsedTime(TimeScale.UTC), moment.getElapsedTime(TimeScale.UTC)), 1000000000), (long) (moment2.getNanosecond() - moment.getNanosecond()));
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: net.time4j.SI$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$SI = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                net.time4j.SI[] r0 = net.time4j.SI.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$SI = r0
                net.time4j.SI r1 = net.time4j.SI.SECONDS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$SI     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.SI r1 = net.time4j.SI.NANOSECONDS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.SI.AnonymousClass1.<clinit>():void");
        }
    }

    public double getLength() {
        return this.length;
    }
}
