package net.time4j;

import androidx.compose.animation.core.AnimationKt;
import java.util.Iterator;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.base.TimeSource;
import net.time4j.scale.LeapSeconds;
import net.time4j.scale.TickProvider;
import net.time4j.scale.TimeScale;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;

public final class SystemClock implements TimeSource<Moment> {
    public static final SystemClock INSTANCE = new SystemClock(false, calibrate());
    private static final int MIO = 1000000;
    public static final SystemClock MONOTONIC = new SystemClock(true, calibrate());
    private static final boolean MONOTON_MODE = Boolean.getBoolean("net.time4j.systemclock.nanoTime");
    private static final int MRD = 1000000000;
    private static final TickProvider PROVIDER;
    private final boolean monotonic;
    private final long offset;

    static {
        TickProvider tickProvider;
        String property = System.getProperty("java.vm.name");
        Iterator<S> it = ResourceLoader.getInstance().services(TickProvider.class).iterator();
        while (true) {
            if (!it.hasNext()) {
                tickProvider = null;
                break;
            }
            tickProvider = (TickProvider) it.next();
            if (property.equals(tickProvider.getPlatform())) {
                break;
            }
        }
        if (tickProvider == null) {
            tickProvider = new StdTickProvider();
        }
        PROVIDER = tickProvider;
    }

    private SystemClock(boolean z, long j) {
        this.monotonic = z;
        this.offset = j;
    }

    public Moment currentTime() {
        if ((this.monotonic || MONOTON_MODE) && LeapSeconds.getInstance().isEnabled()) {
            long utcNanos = utcNanos();
            return Moment.of(MathUtils.floorDivide(utcNanos, (int) MRD), MathUtils.floorModulo(utcNanos, (int) MRD), TimeScale.UTC);
        }
        long currentTimeMillis = System.currentTimeMillis();
        return Moment.of(MathUtils.floorDivide(currentTimeMillis, 1000), MathUtils.floorModulo(currentTimeMillis, 1000) * 1000000, TimeScale.POSIX);
    }

    public long currentTimeInMillis() {
        if (!this.monotonic && !MONOTON_MODE) {
            return System.currentTimeMillis();
        }
        long utcNanos = utcNanos();
        return MathUtils.safeMultiply(LeapSeconds.getInstance().strip(MathUtils.floorDivide(utcNanos, (int) MRD)), 1000) + ((long) MathUtils.floorModulo(utcNanos, 1000000));
    }

    public long currentTimeInMicros() {
        if (!this.monotonic && !MONOTON_MODE) {
            return MathUtils.safeMultiply(System.currentTimeMillis(), 1000);
        }
        long utcNanos = utcNanos();
        return MathUtils.safeMultiply(LeapSeconds.getInstance().strip(MathUtils.floorDivide(utcNanos, (int) MRD)), (long) AnimationKt.MillisToNanos) + ((long) MathUtils.floorModulo(utcNanos, 1000));
    }

    public long realTimeInMicros() {
        if (this.monotonic || MONOTON_MODE) {
            return MathUtils.floorDivide(utcNanos(), 1000);
        }
        long currentTimeMillis = System.currentTimeMillis();
        return MathUtils.safeMultiply(LeapSeconds.getInstance().enhance(MathUtils.floorDivide(currentTimeMillis, 1000)), (long) AnimationKt.MillisToNanos) + ((long) (MathUtils.floorModulo(currentTimeMillis, 1000) * 1000));
    }

    public static ZonalClock inPlatformView() {
        return new ZonalClock((TimeSource<?>) INSTANCE, Timezone.ofPlatform());
    }

    public static ZonalClock inLocalView() {
        return ZonalClock.ofSystem();
    }

    public static ZonalClock inZonalView(TZID tzid) {
        return new ZonalClock((TimeSource<?>) INSTANCE, tzid);
    }

    public static ZonalClock inZonalView(String str) {
        return new ZonalClock((TimeSource<?>) INSTANCE, str);
    }

    public static Moment currentMoment() {
        return INSTANCE.currentTime();
    }

    public SystemClock recalibrated() {
        return new SystemClock(this.monotonic, calibrate());
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.SystemClock synchronizedWith(net.time4j.base.TimeSource<?> r7) {
        /*
            r6 = this;
            net.time4j.base.UnixTime r7 = r7.currentTime()
            net.time4j.Moment r7 = net.time4j.Moment.from(r7)
            boolean r0 = MONOTON_MODE
            if (r0 == 0) goto L_0x0011
            long r0 = java.lang.System.nanoTime()
            goto L_0x0017
        L_0x0011:
            net.time4j.scale.TickProvider r0 = PROVIDER
            long r0 = r0.getNanos()
        L_0x0017:
            net.time4j.scale.TimeScale r2 = net.time4j.scale.TimeScale.UTC
            long r2 = r7.getElapsedTime(r2)
            r4 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r2 = net.time4j.base.MathUtils.safeMultiply((long) r2, (long) r4)
            net.time4j.scale.TimeScale r4 = net.time4j.scale.TimeScale.UTC
            int r7 = r7.getNanosecond(r4)
            long r4 = (long) r7
            long r2 = r2 + r4
            long r0 = net.time4j.base.MathUtils.safeSubtract((long) r2, (long) r0)
            net.time4j.SystemClock r7 = new net.time4j.SystemClock
            boolean r2 = r6.monotonic
            r7.<init>(r2, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.SystemClock.synchronizedWith(net.time4j.base.TimeSource):net.time4j.SystemClock");
    }

    private static long calibrate() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        int i = 0;
        while (i < 10) {
            j = MONOTON_MODE ? System.nanoTime() : PROVIDER.getNanos();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (currentTimeMillis == currentTimeMillis2) {
                break;
            }
            i++;
            currentTimeMillis = currentTimeMillis2;
        }
        return MathUtils.safeSubtract(MathUtils.safeMultiply(LeapSeconds.getInstance().enhance(MathUtils.floorDivide(currentTimeMillis, 1000)), 1000000000) + ((long) (MathUtils.floorModulo(currentTimeMillis, 1000) * 1000000)), j);
    }

    private long utcNanos() {
        return MathUtils.safeAdd(MONOTON_MODE ? System.nanoTime() : PROVIDER.getNanos(), this.offset);
    }

    private static class StdTickProvider implements TickProvider {
        public String getPlatform() {
            return "";
        }

        private StdTickProvider() {
        }

        public long getNanos() {
            return System.nanoTime();
        }
    }
}
