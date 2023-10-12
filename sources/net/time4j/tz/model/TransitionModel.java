package net.time4j.tz.model;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.time4j.Moment;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.WallTime;
import net.time4j.engine.EpochDays;
import net.time4j.scale.TimeScale;
import net.time4j.tz.TransitionHistory;
import net.time4j.tz.ZonalOffset;
import net.time4j.tz.ZonalTransition;

public abstract class TransitionModel implements TransitionHistory, Serializable {
    static final String NEW_LINE = System.getProperty("line.separator");

    public boolean hasNegativeDST() {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    TransitionModel() {
    }

    public static TransitionHistory of(List<ZonalTransition> list) {
        return new ArrayTransitionModel(list);
    }

    public static TransitionHistory of(ZonalOffset zonalOffset, List<DaylightSavingRule> list) {
        if (list.isEmpty()) {
            return new EmptyTransitionModel(zonalOffset);
        }
        return new RuleBasedTransitionModel(zonalOffset, list);
    }

    public static TransitionHistory of(ZonalOffset zonalOffset, List<ZonalTransition> list, List<DaylightSavingRule> list2) {
        return of(zonalOffset, list, list2, true, true);
    }

    static TransitionHistory of(ZonalOffset zonalOffset, List<ZonalTransition> list, List<DaylightSavingRule> list2, boolean z, boolean z2) {
        List<DaylightSavingRule> list3;
        ArrayList arrayList;
        if (z) {
            ArrayList arrayList2 = new ArrayList(list);
            list3 = new ArrayList<>(list2);
            Collections.sort(arrayList2);
            Collections.sort(list3, RuleComparator.INSTANCE);
            arrayList = arrayList2;
        } else {
            arrayList = list;
            list3 = list2;
        }
        int size = arrayList.size();
        if (size != 0) {
            ZonalOffset ofTotalSeconds = ZonalOffset.ofTotalSeconds(arrayList.get(0).getPreviousOffset());
            if (z2 && !zonalOffset.equals(ofTotalSeconds)) {
                throw new IllegalArgumentException("Initial offset " + zonalOffset + " not equal " + "to previous offset of first transition: " + ofTotalSeconds);
            } else if (list3.isEmpty()) {
                return new ArrayTransitionModel(arrayList, false, z2);
            } else {
                ZonalTransition zonalTransition = arrayList.get(size - 1);
                long posixTime = zonalTransition.getPosixTime() + 1;
                long futureMoment = getFutureMoment(1);
                if (posixTime < futureMoment) {
                    arrayList.addAll(RuleBasedTransitionModel.getTransitions(zonalTransition, list3, posixTime, futureMoment));
                }
                return new CompositeTransitionModel(size, arrayList, list3, false, z2);
            }
        } else if (list3.isEmpty()) {
            return new EmptyTransitionModel(zonalOffset);
        } else {
            return new RuleBasedTransitionModel(zonalOffset, list3, false);
        }
    }

    static List<ZonalOffset> toList(int i) {
        return Collections.singletonList(ZonalOffset.ofTotalSeconds(i));
    }

    static List<ZonalOffset> toList(int i, int i2) {
        ZonalOffset ofTotalSeconds = ZonalOffset.ofTotalSeconds(i);
        ZonalOffset ofTotalSeconds2 = ZonalOffset.ofTotalSeconds(i2);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(ofTotalSeconds);
        arrayList.add(ofTotalSeconds2);
        return Collections.unmodifiableList(arrayList);
    }

    static long toLocalSecs(GregorianDate gregorianDate, WallTime wallTime) {
        return MathUtils.safeMultiply(EpochDays.UNIX.transform(GregorianMath.toMJD(gregorianDate.getYear(), gregorianDate.getMonth(), gregorianDate.getDayOfMonth()), EpochDays.MODIFIED_JULIAN_DATE), 86400) + ((long) (wallTime.getHour() * NikonType2MakernoteDirectory.TAG_NIKON_SCAN)) + ((long) (wallTime.getMinute() * 60)) + ((long) wallTime.getSecond());
    }

    static void dump(ZonalTransition zonalTransition, Appendable appendable) throws IOException {
        appendable.append(">>> Transition at: ").append(Moment.of(zonalTransition.getPosixTime(), TimeScale.POSIX).toString());
        appendable.append(" from ").append(format(zonalTransition.getPreviousOffset()));
        appendable.append(" to ").append(format(zonalTransition.getTotalOffset()));
        appendable.append(", DST=");
        appendable.append(format(zonalTransition.getDaylightSavingOffset()));
        appendable.append(NEW_LINE);
    }

    static long getFutureMoment(int i) {
        return (System.currentTimeMillis() / 1000) + ((long) (((double) i) * 3.1556952E7d));
    }

    private static String format(int i) {
        return ZonalOffset.ofTotalSeconds(i).toString();
    }
}
