package net.time4j.engine;

import androidx.compose.animation.core.AnimationKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.time4j.base.MathUtils;
import net.time4j.engine.AbstractDuration;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.TimeSpan;

public abstract class AbstractMetric<U extends ChronoUnit, P extends AbstractDuration<U>> implements TimeMetric<U, P>, Comparator<U> {
    private static final double LENGTH_OF_FORTNIGHT = 1209600.0d;
    private static final int MIO = 1000000;
    private final boolean normalizing;
    /* access modifiers changed from: private */
    public final List<U> sortedUnits;

    /* access modifiers changed from: protected */
    public abstract P createEmptyTimeSpan();

    /* access modifiers changed from: protected */
    public abstract P createTimeSpan(List<TimeSpan.Item<U>> list, boolean z);

    /* access modifiers changed from: protected */
    public TimeSpan.Item<U> resolve(TimeSpan.Item<U> item) {
        return item;
    }

    protected AbstractMetric(boolean z, U... uArr) {
        this(Arrays.asList(uArr), z);
    }

    protected AbstractMetric(boolean z, Collection<? extends U> collection) {
        this(new ArrayList(collection), z);
    }

    private AbstractMetric(List<U> list, boolean z) {
        if (!list.isEmpty()) {
            Collections.sort(list, this);
            int i = 0;
            int size = list.size();
            while (i < size) {
                ChronoUnit chronoUnit = (ChronoUnit) list.get(i);
                i++;
                int i2 = i;
                while (true) {
                    if (i2 < size) {
                        if (!chronoUnit.equals(list.get(i2))) {
                            i2++;
                        } else {
                            throw new IllegalArgumentException("Duplicate unit: " + chronoUnit);
                        }
                    }
                }
            }
            this.sortedUnits = Collections.unmodifiableList(list);
            this.normalizing = z;
            return;
        }
        throw new IllegalArgumentException("Missing units.");
    }

    public int compare(U u, U u2) {
        return Double.compare(u2.getLength(), u.getLength());
    }

    public <T extends TimePoint<? super U, T>> P between(T t, T t2) {
        return between(t, t2, -1);
    }

    /* access modifiers changed from: private */
    public <T extends TimePoint<? super U, T>> P between(T t, T t2, int i) {
        boolean z;
        T t3;
        T t4 = t;
        T t5 = t2;
        if (t5.equals(t4)) {
            return createEmptyTimeSpan();
        }
        int i2 = 0;
        if (t.compareTo(t2) > 0) {
            t3 = t4;
            z = true;
        } else {
            t3 = t5;
            z = false;
            t5 = t4;
        }
        ArrayList arrayList = new ArrayList(10);
        TimeAxis chronology = t.getChronology();
        int size = this.sortedUnits.size();
        while (i2 < size) {
            ChronoUnit chronoUnit = (ChronoUnit) this.sortedUnits.get(i2);
            if (getLength(chronology, chronoUnit) >= 1.0d || i2 >= size - 1) {
                int i3 = i2 + 1;
                long j = 1;
                while (i3 < size) {
                    ChronoUnit chronoUnit2 = (ChronoUnit) this.sortedUnits.get(i3);
                    j *= getFactor(chronology, chronoUnit, chronoUnit2);
                    if (j >= AnimationKt.MillisToNanos || !chronology.isConvertible(chronoUnit, chronoUnit2)) {
                        break;
                    }
                    i3++;
                    chronoUnit = chronoUnit2;
                }
                i2 = i3 - 1;
                long until = t5.until(t3, chronoUnit);
                long j2 = 0;
                if (until >= 0) {
                    while (true) {
                        if (until <= j2) {
                            break;
                        }
                        T plus = t5.plus(until, chronoUnit);
                        if (i2 > i || i2 == size - 1 || plus.minus(until, chronoUnit).equals(t5)) {
                            arrayList.add(resolve(TimeSpan.Item.of(until, chronoUnit)));
                            t5 = plus;
                        } else {
                            until--;
                            j2 = 0;
                        }
                    }
                } else {
                    throw new IllegalStateException("Implementation error: Cannot compute timespan due to illegal negative timespan amounts.");
                }
            }
            int i4 = i;
            i2++;
        }
        if (this.normalizing) {
            normalize(chronology, this.sortedUnits, arrayList);
        }
        return createTimeSpan(arrayList, z);
    }

    public TimeMetric<U, P> reversible() {
        return new ReversalMetric();
    }

    private <T extends TimePoint<? super U, T>> void normalize(TimeAxis<? super U, T> timeAxis, List<U> list, List<TimeSpan.Item<U>> list2) {
        TimeSpan.Item<U> item;
        TimeAxis<? super U, T> timeAxis2 = timeAxis;
        List<U> list3 = list;
        List<TimeSpan.Item<U>> list4 = list2;
        Comparator<? super Object> unitComparator = timeAxis.unitComparator();
        for (int size = list.size() - 1; size >= 0; size--) {
            if (size > 0) {
                ChronoUnit chronoUnit = (ChronoUnit) list3.get(size);
                ChronoUnit chronoUnit2 = (ChronoUnit) list3.get(size - 1);
                long factor = getFactor(timeAxis2, chronoUnit2, chronoUnit);
                if (factor < AnimationKt.MillisToNanos && timeAxis2.isConvertible(chronoUnit2, chronoUnit) && (item = getItem(list4, chronoUnit)) != null) {
                    long amount = item.getAmount();
                    long j = amount / factor;
                    if (j > 0) {
                        long j2 = amount % factor;
                        if (j2 == 0) {
                            removeItem(list4, chronoUnit);
                        } else {
                            putItem(list4, unitComparator, j2, chronoUnit);
                        }
                        TimeSpan.Item<U> item2 = getItem(list4, chronoUnit2);
                        if (item2 == null) {
                            putItem(list4, unitComparator, j, chronoUnit2);
                        } else {
                            putItem(list4, unitComparator, MathUtils.safeAdd(item2.getAmount(), j), chronoUnit2);
                        }
                    }
                }
            }
        }
    }

    private static <U> TimeSpan.Item<U> getItem(List<TimeSpan.Item<U>> list, U u) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            TimeSpan.Item<U> item = list.get(i);
            if (item.getUnit().equals(u)) {
                return item;
            }
        }
        return null;
    }

    private static <U> void putItem(List<TimeSpan.Item<U>> list, Comparator<? super U> comparator, long j, U u) {
        TimeSpan.Item of = TimeSpan.Item.of(j, u);
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object unit = list.get(i2).getUnit();
            if (unit.equals(u)) {
                list.set(i2, of);
                return;
            }
            if (i == i2 && comparator.compare(unit, u) < 0) {
                i++;
            }
        }
        list.add(i, of);
    }

    private static <U> void removeItem(List<TimeSpan.Item<U>> list, U u) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getUnit().equals(u)) {
                list.remove(i);
                return;
            }
        }
    }

    private <T extends TimePoint<? super U, T>> long getFactor(TimeAxis<? super U, T> timeAxis, U u, U u2) {
        return Math.round(getLength(timeAxis, u) / getLength(timeAxis, u2));
    }

    private <T extends TimePoint<? super U, T>> double getLength(TimeAxis<? super U, T> timeAxis, U u) {
        return timeAxis.getLength(u);
    }

    private static class ReversalMetric<U extends ChronoUnit, P extends AbstractDuration<U>> implements TimeMetric<U, P> {
        private final AbstractMetric<U, P> delegate;
        private final int monthIndex;

        public TimeMetric<U, P> reversible() {
            return this;
        }

        private ReversalMetric(AbstractMetric<U, P> abstractMetric) {
            this.delegate = abstractMetric;
            int size = abstractMetric.sortedUnits.size() - 1;
            while (true) {
                if (size < 0) {
                    size = -1;
                    break;
                } else if (Double.compare(((ChronoUnit) this.delegate.sortedUnits.get(size)).getLength(), AbstractMetric.LENGTH_OF_FORTNIGHT) > 0) {
                    break;
                } else {
                    size--;
                }
            }
            this.monthIndex = size;
        }

        public <T extends TimePoint<? super U, T>> P between(T t, T t2) {
            return this.delegate.between(t, t2, this.monthIndex);
        }
    }
}
