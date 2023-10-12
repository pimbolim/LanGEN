package net.time4j.scale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.base.UnixTime;

public final class LeapSeconds implements Iterable<LeapSecondEvent>, Comparator<LeapSecondEvent> {
    private static final ExtendedLSE[] EMPTY_ARRAY = new ExtendedLSE[0];
    public static final boolean FINAL_UTC_LEAPSECONDS = Boolean.getBoolean("net.time4j.scale.leapseconds.final");
    private static final LeapSeconds INSTANCE = new LeapSeconds();
    private static final long MJD_OFFSET = 40587;
    public static final String PATH_TO_LEAPSECONDS = System.getProperty("net.time4j.scale.leapseconds.path", "data/leapseconds.data");
    public static final boolean SUPPRESS_UTC_LEAPSECONDS = Boolean.getBoolean("net.time4j.scale.leapseconds.suppressed");
    private static final long UNIX_OFFSET = 63072000;
    private final List<ExtendedLSE> list;
    private final LeapSecondProvider provider;
    private final ExtendedLSE[] reverseFinal;
    private volatile ExtendedLSE[] reverseVolatile;
    private final boolean supportsNegativeLS;

    private LeapSeconds() {
        int i;
        LeapSecondProvider leapSecondProvider;
        boolean z = false;
        if (!SUPPRESS_UTC_LEAPSECONDS) {
            leapSecondProvider = null;
            i = 0;
            for (S s : ResourceLoader.getInstance().services(LeapSecondProvider.class)) {
                int size = s.getLeapSecondTable().size();
                if (size > i) {
                    leapSecondProvider = s;
                    i = size;
                }
            }
        } else {
            leapSecondProvider = null;
            i = 0;
        }
        if (leapSecondProvider == null || i == 0) {
            this.provider = null;
            this.list = Collections.emptyList();
            ExtendedLSE[] extendedLSEArr = EMPTY_ARRAY;
            this.reverseFinal = extendedLSEArr;
            this.reverseVolatile = extendedLSEArr;
            this.supportsNegativeLS = false;
            return;
        }
        TreeSet treeSet = new TreeSet(this);
        for (Map.Entry next : leapSecondProvider.getLeapSecondTable().entrySet()) {
            GregorianDate gregorianDate = (GregorianDate) next.getKey();
            treeSet.add(new SimpleLeapSecondEvent(gregorianDate, Long.MIN_VALUE, (toPosix(gregorianDate) - 62985600) - 1, ((Integer) next.getValue()).intValue()));
        }
        extend(treeSet);
        boolean z2 = FINAL_UTC_LEAPSECONDS;
        if (z2) {
            this.list = Collections.unmodifiableList(new ArrayList(treeSet));
        } else {
            this.list = new CopyOnWriteArrayList(treeSet);
        }
        ExtendedLSE[] initReverse = initReverse();
        this.reverseFinal = initReverse;
        this.reverseVolatile = initReverse;
        this.provider = leapSecondProvider;
        if (z2) {
            boolean supportsNegativeLS2 = leapSecondProvider.supportsNegativeLS();
            if (supportsNegativeLS2) {
                Iterator<ExtendedLSE> it = this.list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getShift() < 0) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                supportsNegativeLS2 = z;
            }
            this.supportsNegativeLS = supportsNegativeLS2;
            return;
        }
        this.supportsNegativeLS = true;
    }

    public static LeapSeconds getInstance() {
        return INSTANCE;
    }

    public boolean isEnabled() {
        return !this.list.isEmpty();
    }

    public boolean isExtensible() {
        return !FINAL_UTC_LEAPSECONDS && isEnabled();
    }

    public int getCount() {
        return getEventsInDescendingOrder().length;
    }

    public int getCount(UnixTime unixTime) {
        long posixTime = unixTime.getPosixTime();
        return MathUtils.safeCast((enhance(posixTime) + UNIX_OFFSET) - posixTime);
    }

    public void registerPositiveLS(int i, int i2, int i3) {
        register(i, i2, i3, false);
    }

    public void registerNegativeLS(int i, int i2, int i3) {
        register(i, i2, i3, true);
    }

    public boolean supportsNegativeLS() {
        return this.supportsNegativeLS;
    }

    public Iterator<LeapSecondEvent> iterator() {
        return Collections.unmodifiableList(Arrays.asList(getEventsInDescendingOrder())).iterator();
    }

    public int getShift(GregorianDate gregorianDate) {
        int year = gregorianDate.getYear();
        if (year >= 1972) {
            ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
            for (ExtendedLSE extendedLSE : eventsInDescendingOrder) {
                GregorianDate date = extendedLSE.getDate();
                if (year == date.getYear() && gregorianDate.getMonth() == date.getMonth() && gregorianDate.getDayOfMonth() == date.getDayOfMonth()) {
                    return extendedLSE.getShift();
                }
            }
        }
        return 0;
    }

    public int getShift(long j) {
        if (j <= 0) {
            return 0;
        }
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        for (ExtendedLSE extendedLSE : eventsInDescendingOrder) {
            if (j > extendedLSE.utc()) {
                return 0;
            }
            long utc = extendedLSE.utc() - ((long) extendedLSE.getShift());
            if (j > utc) {
                return (int) (j - utc);
            }
        }
        return 0;
    }

    public LeapSecondEvent getNextEvent(long j) {
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        ExtendedLSE extendedLSE = null;
        int i = 0;
        while (i < eventsInDescendingOrder.length) {
            ExtendedLSE extendedLSE2 = eventsInDescendingOrder[i];
            if (j >= extendedLSE2.utc()) {
                break;
            }
            i++;
            extendedLSE = extendedLSE2;
        }
        return extendedLSE;
    }

    public long enhance(long j) {
        long j2 = j - UNIX_OFFSET;
        if (j <= 0) {
            return j2;
        }
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        for (ExtendedLSE extendedLSE : eventsInDescendingOrder) {
            if (extendedLSE.raw() < j2) {
                return MathUtils.safeAdd(j2, extendedLSE.utc() - extendedLSE.raw());
            }
        }
        return j2;
    }

    public long strip(long j) {
        ExtendedLSE extendedLSE;
        if (j <= 0) {
            return j + UNIX_OFFSET;
        }
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        boolean z = this.supportsNegativeLS;
        int i = 0;
        while (true) {
            if (i >= eventsInDescendingOrder.length) {
                break;
            }
            extendedLSE = eventsInDescendingOrder[i];
            if (extendedLSE.utc() - ((long) extendedLSE.getShift()) < j || (z && extendedLSE.getShift() < 0 && extendedLSE.utc() < j)) {
                j = MathUtils.safeAdd(j, extendedLSE.raw() - extendedLSE.utc());
            } else {
                i++;
            }
        }
        j = MathUtils.safeAdd(j, extendedLSE.raw() - extendedLSE.utc());
        return j + UNIX_OFFSET;
    }

    public boolean isPositiveLS(long j) {
        if (j <= 0) {
            return false;
        }
        ExtendedLSE[] eventsInDescendingOrder = getEventsInDescendingOrder();
        int i = 0;
        while (i < eventsInDescendingOrder.length) {
            int i2 = (eventsInDescendingOrder[i].utc() > j ? 1 : (eventsInDescendingOrder[i].utc() == j ? 0 : -1));
            if (i2 == 0) {
                if (eventsInDescendingOrder[i].getShift() == 1) {
                    return true;
                }
                return false;
            } else if (i2 < 0) {
                break;
            } else {
                i++;
            }
        }
        return false;
    }

    public GregorianDate getDateOfExpiration() {
        if (isEnabled()) {
            return this.provider.getDateOfExpiration();
        }
        throw new IllegalStateException("Leap seconds not activated.");
    }

    public int compare(LeapSecondEvent leapSecondEvent, LeapSecondEvent leapSecondEvent2) {
        GregorianDate date = leapSecondEvent.getDate();
        GregorianDate date2 = leapSecondEvent2.getDate();
        int year = date.getYear();
        int year2 = date2.getYear();
        if (year < year2) {
            return -1;
        }
        if (year > year2) {
            return 1;
        }
        int month = date.getMonth();
        int month2 = date2.getMonth();
        if (month < month2) {
            return -1;
        }
        if (month > month2) {
            return 1;
        }
        int dayOfMonth = date.getDayOfMonth();
        int dayOfMonth2 = date2.getDayOfMonth();
        if (dayOfMonth < dayOfMonth2) {
            return -1;
        }
        return dayOfMonth == dayOfMonth2 ? 0 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(2048);
        sb.append("[PROVIDER=");
        sb.append(this.provider);
        if (this.provider != null) {
            sb.append(",EXPIRES=");
            sb.append(format(getDateOfExpiration()));
        }
        sb.append(",EVENTS=[");
        if (isEnabled()) {
            boolean z = true;
            for (ExtendedLSE next : this.list) {
                if (z) {
                    z = false;
                } else {
                    sb.append('|');
                }
                sb.append(next);
            }
        } else {
            sb.append("NOT SUPPORTED");
        }
        sb.append("]]");
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void register(int r6, int r7, int r8, boolean r9) {
        /*
            r5 = this;
            boolean r0 = FINAL_UTC_LEAPSECONDS
            if (r0 != 0) goto L_0x0075
            boolean r0 = SUPPRESS_UTC_LEAPSECONDS
            if (r0 != 0) goto L_0x006d
            monitor-enter(r5)
            net.time4j.base.GregorianMath.checkDate(r6, r7, r8)     // Catch:{ all -> 0x006a }
            boolean r0 = r5.isEnabled()     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0062
            net.time4j.scale.ExtendedLSE[] r0 = r5.reverseVolatile     // Catch:{ all -> 0x006a }
            r1 = 0
            r0 = r0[r1]     // Catch:{ all -> 0x006a }
            net.time4j.base.GregorianDate r2 = r0.getDate()     // Catch:{ all -> 0x006a }
            int r3 = r2.getYear()     // Catch:{ all -> 0x006a }
            r4 = 1
            if (r6 <= r3) goto L_0x0024
        L_0x0022:
            r1 = 1
            goto L_0x003e
        L_0x0024:
            int r3 = r2.getYear()     // Catch:{ all -> 0x006a }
            if (r6 != r3) goto L_0x003e
            int r3 = r2.getMonth()     // Catch:{ all -> 0x006a }
            if (r7 <= r3) goto L_0x0031
            goto L_0x0022
        L_0x0031:
            int r3 = r2.getMonth()     // Catch:{ all -> 0x006a }
            if (r7 != r3) goto L_0x003e
            int r2 = r2.getDayOfMonth()     // Catch:{ all -> 0x006a }
            if (r8 <= r2) goto L_0x003e
            goto L_0x0022
        L_0x003e:
            if (r1 == 0) goto L_0x005a
            if (r9 == 0) goto L_0x0043
            r4 = -1
        L_0x0043:
            net.time4j.scale.LeapSecondProvider r9 = r5.provider     // Catch:{ all -> 0x006a }
            net.time4j.base.GregorianDate r6 = r9.getDateOfEvent(r6, r7, r8)     // Catch:{ all -> 0x006a }
            java.util.List<net.time4j.scale.ExtendedLSE> r7 = r5.list     // Catch:{ all -> 0x006a }
            net.time4j.scale.ExtendedLSE r6 = createLSE(r6, r4, r0)     // Catch:{ all -> 0x006a }
            r7.add(r6)     // Catch:{ all -> 0x006a }
            net.time4j.scale.ExtendedLSE[] r6 = r5.initReverse()     // Catch:{ all -> 0x006a }
            r5.reverseVolatile = r6     // Catch:{ all -> 0x006a }
            monitor-exit(r5)     // Catch:{ all -> 0x006a }
            return
        L_0x005a:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x006a }
            java.lang.String r7 = "New leap second must be after last leap second."
            r6.<init>(r7)     // Catch:{ all -> 0x006a }
            throw r6     // Catch:{ all -> 0x006a }
        L_0x0062:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006a }
            java.lang.String r7 = "Leap seconds not activated."
            r6.<init>(r7)     // Catch:{ all -> 0x006a }
            throw r6     // Catch:{ all -> 0x006a }
        L_0x006a:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x006a }
            throw r6
        L_0x006d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Leap seconds are not supported, change requires edit of system property \"time4j.utc.leapseconds.suppressed\" and reboot of JVM."
            r6.<init>(r7)
            throw r6
        L_0x0075:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Leap seconds are final, change requires edit of system property \"time4j.utc.leapseconds.final\" and reboot of JVM."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.scale.LeapSeconds.register(int, int, int, boolean):void");
    }

    private ExtendedLSE[] getEventsInDescendingOrder() {
        if (SUPPRESS_UTC_LEAPSECONDS || FINAL_UTC_LEAPSECONDS) {
            return this.reverseFinal;
        }
        return this.reverseVolatile;
    }

    private static void extend(SortedSet<ExtendedLSE> sortedSet) {
        ArrayList arrayList = new ArrayList(sortedSet.size());
        int i = 0;
        for (ExtendedLSE extendedLSE : sortedSet) {
            if (extendedLSE.utc() == Long.MIN_VALUE) {
                i += extendedLSE.getShift();
                arrayList.add(new SimpleLeapSecondEvent(extendedLSE, i));
            } else {
                arrayList.add(extendedLSE);
            }
        }
        sortedSet.clear();
        sortedSet.addAll(arrayList);
    }

    private static ExtendedLSE createLSE(GregorianDate gregorianDate, int i, ExtendedLSE extendedLSE) {
        long posix = (toPosix(gregorianDate) - 62985600) - 1;
        return new SimpleLeapSecondEvent(gregorianDate, posix + ((long) ((int) ((extendedLSE.utc() - extendedLSE.raw()) + ((long) i)))), posix, i);
    }

    private static long toPosix(GregorianDate gregorianDate) {
        return MathUtils.safeMultiply(MathUtils.safeSubtract(GregorianMath.toMJD(gregorianDate), (long) MJD_OFFSET), 86400);
    }

    private ExtendedLSE[] initReverse() {
        ArrayList arrayList = new ArrayList(this.list.size());
        arrayList.addAll(this.list);
        Collections.reverse(arrayList);
        return (ExtendedLSE[]) arrayList.toArray(new ExtendedLSE[arrayList.size()]);
    }

    /* access modifiers changed from: private */
    public static String format(GregorianDate gregorianDate) {
        return String.format("%1$04d-%2$02d-%3$02d", new Object[]{Integer.valueOf(gregorianDate.getYear()), Integer.valueOf(gregorianDate.getMonth()), Integer.valueOf(gregorianDate.getDayOfMonth())});
    }

    private static class SimpleLeapSecondEvent implements ExtendedLSE, Serializable {
        private static final long serialVersionUID = 5986185471610524587L;
        private final long _raw;
        private final long _utc;
        private final GregorianDate date;
        private final int shift;

        SimpleLeapSecondEvent(GregorianDate gregorianDate, long j, long j2, int i) {
            this.date = gregorianDate;
            this.shift = i;
            this._utc = j;
            this._raw = j2;
        }

        SimpleLeapSecondEvent(ExtendedLSE extendedLSE, int i) {
            this.date = extendedLSE.getDate();
            this.shift = extendedLSE.getShift();
            this._utc = extendedLSE.raw() + ((long) i);
            this._raw = extendedLSE.raw();
        }

        public GregorianDate getDate() {
            return this.date;
        }

        public int getShift() {
            return this.shift;
        }

        public long utc() {
            return this._utc;
        }

        public long raw() {
            return this._raw;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append(LeapSecondEvent.class.getName());
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            sb.append(LeapSeconds.format(this.date));
            sb.append(": utc=");
            sb.append(this._utc);
            sb.append(", raw=");
            sb.append(this._raw);
            sb.append(" (shift=");
            sb.append(this.shift);
            sb.append(")]");
            return sb.toString();
        }
    }
}
