package net.time4j.tz.model;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.Moment;
import net.time4j.base.GregorianDate;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.scale.TimeScale;
import net.time4j.tz.ZonalOffset;
import net.time4j.tz.ZonalTransition;

final class ArrayTransitionModel extends TransitionModel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -5264909488983076587L;
    private transient int hash;
    private final transient boolean negativeDST;
    private final transient List<ZonalTransition> stdTransitions;
    private final transient ZonalTransition[] transitions;

    ArrayTransitionModel(List<ZonalTransition> list) {
        this(list, true, true);
    }

    ArrayTransitionModel(List<ZonalTransition> list, boolean z, boolean z2) {
        this.hash = 0;
        if (!list.isEmpty()) {
            ZonalTransition[] zonalTransitionArr = (ZonalTransition[]) list.toArray(new ZonalTransition[list.size()]);
            boolean z3 = false;
            for (ZonalTransition daylightSavingOffset : zonalTransitionArr) {
                z3 = z3 || daylightSavingOffset.getDaylightSavingOffset() < 0;
            }
            this.negativeDST = z3;
            if (z) {
                Arrays.sort(zonalTransitionArr);
            }
            if (z2) {
                checkSanity(zonalTransitionArr, list);
            }
            this.transitions = zonalTransitionArr;
            this.stdTransitions = getTransitions(zonalTransitionArr, 0, TransitionModel.getFutureMoment(1));
            return;
        }
        throw new IllegalArgumentException("Missing timezone transitions.");
    }

    public ZonalOffset getInitialOffset() {
        return ZonalOffset.ofTotalSeconds(this.transitions[0].getPreviousOffset());
    }

    public ZonalTransition getStartTransition(UnixTime unixTime) {
        int search = search(unixTime.getPosixTime(), this.transitions);
        if (search == 0) {
            return null;
        }
        return this.transitions[search - 1];
    }

    public ZonalTransition getConflictTransition(GregorianDate gregorianDate, WallTime wallTime) {
        return getConflictTransition(gregorianDate, wallTime, (RuleBasedTransitionModel) null);
    }

    public ZonalTransition getNextTransition(UnixTime unixTime) {
        int search = search(unixTime.getPosixTime(), this.transitions);
        ZonalTransition[] zonalTransitionArr = this.transitions;
        if (search == zonalTransitionArr.length) {
            return null;
        }
        return zonalTransitionArr[search];
    }

    public List<ZonalOffset> getValidOffsets(GregorianDate gregorianDate, WallTime wallTime) {
        return getValidOffsets(gregorianDate, wallTime, (RuleBasedTransitionModel) null);
    }

    public List<ZonalTransition> getStdTransitions() {
        return this.stdTransitions;
    }

    public List<ZonalTransition> getTransitions(UnixTime unixTime, UnixTime unixTime2) {
        return getTransitions(this.transitions, unixTime.getPosixTime(), unixTime2.getPosixTime());
    }

    public void dump(Appendable appendable) throws IOException {
        dump(this.transitions.length, appendable);
    }

    public boolean hasNegativeDST() {
        return this.negativeDST;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArrayTransitionModel) {
            return Arrays.equals(this.transitions, ((ArrayTransitionModel) obj).transitions);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hash;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.transitions);
        this.hash = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(getClass().getName());
        sb.append("[transition-count=");
        sb.append(this.transitions.length);
        sb.append(",hash=");
        sb.append(hashCode());
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public ZonalTransition getConflictTransition(GregorianDate gregorianDate, WallTime wallTime, RuleBasedTransitionModel ruleBasedTransitionModel) {
        long localSecs = TransitionModel.toLocalSecs(gregorianDate, wallTime);
        int searchLocal = searchLocal(localSecs, this.transitions);
        ZonalTransition[] zonalTransitionArr = this.transitions;
        if (searchLocal != zonalTransitionArr.length) {
            ZonalTransition zonalTransition = zonalTransitionArr[searchLocal];
            if (zonalTransition.isGap()) {
                if (zonalTransition.getPosixTime() + ((long) zonalTransition.getPreviousOffset()) <= localSecs) {
                    return zonalTransition;
                }
            } else if (!zonalTransition.isOverlap() || zonalTransition.getPosixTime() + ((long) zonalTransition.getTotalOffset()) > localSecs) {
                return null;
            } else {
                return zonalTransition;
            }
            return null;
        } else if (ruleBasedTransitionModel == null) {
            return null;
        } else {
            return ruleBasedTransitionModel.getConflictTransition(gregorianDate, localSecs);
        }
    }

    /* access modifiers changed from: package-private */
    public List<ZonalOffset> getValidOffsets(GregorianDate gregorianDate, WallTime wallTime, RuleBasedTransitionModel ruleBasedTransitionModel) {
        long localSecs = TransitionModel.toLocalSecs(gregorianDate, wallTime);
        int searchLocal = searchLocal(localSecs, this.transitions);
        ZonalTransition[] zonalTransitionArr = this.transitions;
        if (searchLocal != zonalTransitionArr.length) {
            ZonalTransition zonalTransition = zonalTransitionArr[searchLocal];
            if (zonalTransition.isGap()) {
                if (zonalTransition.getPosixTime() + ((long) zonalTransition.getPreviousOffset()) <= localSecs) {
                    return Collections.emptyList();
                }
            } else if (zonalTransition.isOverlap() && zonalTransition.getPosixTime() + ((long) zonalTransition.getTotalOffset()) <= localSecs) {
                return TransitionModel.toList(zonalTransition.getTotalOffset(), zonalTransition.getPreviousOffset());
            }
            return TransitionModel.toList(zonalTransition.getPreviousOffset());
        } else if (ruleBasedTransitionModel == null) {
            return TransitionModel.toList(zonalTransitionArr[zonalTransitionArr.length - 1].getTotalOffset());
        } else {
            return ruleBasedTransitionModel.getValidOffsets(gregorianDate, localSecs);
        }
    }

    /* access modifiers changed from: package-private */
    public void dump(int i, Appendable appendable) throws IOException {
        for (int i2 = 0; i2 < i; i2++) {
            TransitionModel.dump(this.transitions[i2], appendable);
        }
    }

    /* access modifiers changed from: package-private */
    public ZonalTransition getLastTransition() {
        ZonalTransition[] zonalTransitionArr = this.transitions;
        return zonalTransitionArr[zonalTransitionArr.length - 1];
    }

    /* access modifiers changed from: package-private */
    public boolean equals(ArrayTransitionModel arrayTransitionModel, int i, int i2) {
        int min = Math.min(i, this.transitions.length);
        if (min != Math.min(i2, arrayTransitionModel.transitions.length)) {
            return false;
        }
        for (int i3 = 0; i3 < min; i3++) {
            if (!this.transitions[i3].equals(arrayTransitionModel.transitions[i3])) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int hashCode(int i) {
        int min = Math.min(i, this.transitions.length);
        ZonalTransition[] zonalTransitionArr = new ZonalTransition[min];
        System.arraycopy(this.transitions, 0, zonalTransitionArr, 0, min);
        return Arrays.hashCode(zonalTransitionArr);
    }

    /* access modifiers changed from: package-private */
    public void writeTransitions(ObjectOutput objectOutput) throws IOException {
        writeTransitions(this.transitions.length, objectOutput);
    }

    /* access modifiers changed from: package-private */
    public void writeTransitions(int i, ObjectOutput objectOutput) throws IOException {
        SPX.writeTransitions(this.transitions, i, objectOutput);
    }

    private static void checkSanity(ZonalTransition[] zonalTransitionArr, List<ZonalTransition> list) {
        int totalOffset = zonalTransitionArr[0].getTotalOffset();
        int i = 1;
        while (i < zonalTransitionArr.length) {
            if (totalOffset == zonalTransitionArr[i].getPreviousOffset()) {
                totalOffset = zonalTransitionArr[i].getTotalOffset();
                i++;
            } else {
                Moment of = Moment.of(zonalTransitionArr[i].getPosixTime(), TimeScale.POSIX);
                throw new IllegalArgumentException("Model inconsistency detected at: " + of + " (" + zonalTransitionArr[i].getPosixTime() + ") " + " in transitions: " + list);
            }
        }
    }

    private static List<ZonalTransition> getTransitions(ZonalTransition[] zonalTransitionArr, long j, long j2) {
        if (j <= j2) {
            int search = search(j, zonalTransitionArr);
            int search2 = search(j2, zonalTransitionArr);
            if (search2 == 0) {
                return Collections.emptyList();
            }
            if (search > 0 && zonalTransitionArr[search - 1].getPosixTime() == j) {
                search--;
            }
            int i = search2 - 1;
            if (zonalTransitionArr[i].getPosixTime() == j2) {
                i--;
            }
            if (search > i) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList((i - search) + 1);
            while (search <= i) {
                arrayList.add(zonalTransitionArr[search]);
                search++;
            }
            return Collections.unmodifiableList(arrayList);
        }
        throw new IllegalArgumentException("Start after end.");
    }

    private static int search(long j, ZonalTransition[] zonalTransitionArr) {
        int length = zonalTransitionArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) / 2;
            if (zonalTransitionArr[i2].getPosixTime() <= j) {
                i = i2 + 1;
            } else {
                length = i2 - 1;
            }
        }
        return i;
    }

    private static int searchLocal(long j, ZonalTransition[] zonalTransitionArr) {
        int length = zonalTransitionArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) / 2;
            ZonalTransition zonalTransition = zonalTransitionArr[i2];
            if (zonalTransition.getPosixTime() + ((long) Math.max(zonalTransition.getTotalOffset(), zonalTransition.getPreviousOffset())) <= j) {
                i = i2 + 1;
            } else {
                length = i2 - 1;
            }
        }
        return i;
    }

    private Object writeReplace() {
        return new SPX(this, 126);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
