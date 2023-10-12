package net.time4j.engine;

import androidx.compose.animation.core.AnimationKt;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.MathUtils;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.TimeSpan;

public abstract class AbstractDuration<U extends ChronoUnit> implements TimeSpan<U> {
    private static final int MIO = 1000000;

    public abstract AbstractDuration<U> inverse();

    public boolean contains(U u) {
        for (TimeSpan.Item item : getTotalLength()) {
            if (item.getUnit().equals(u)) {
                if (item.getAmount() > 0) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public long getPartialAmount(U u) {
        for (TimeSpan.Item item : getTotalLength()) {
            if (item.getUnit().equals(u)) {
                return item.getAmount();
            }
        }
        return 0;
    }

    public boolean isPositive() {
        return !isNegative() && !isEmpty();
    }

    public boolean isEmpty() {
        List totalLength = getTotalLength();
        int size = totalLength.size();
        for (int i = 0; i < size; i++) {
            if (((TimeSpan.Item) totalLength.get(i)).getAmount() > 0) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (isEmpty()) {
            return "PT0S";
        }
        StringBuilder sb = new StringBuilder();
        if (isNegative()) {
            sb.append(SignatureVisitor.SUPER);
        }
        sb.append('P');
        int size = getTotalLength().size();
        for (int i = 0; i < size; i++) {
            TimeSpan.Item item = (TimeSpan.Item) getTotalLength().get(i);
            if (i > 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(item.getAmount());
            sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
            sb.append(item.getUnit());
            sb.append(AbstractJsonLexerKt.END_OBJ);
        }
        return sb.toString();
    }

    public final <T extends TimePoint<? super U, T>> T addTo(T t) {
        return add(t, this, false);
    }

    public final <T extends TimePoint<? super U, T>> T subtractFrom(T t) {
        return add(t, this, true);
    }

    private <T extends TimePoint<? super U, T>> T add(T t, TimeSpan<U> timeSpan, boolean z) {
        T t2;
        TimeAxis chronology = t.getChronology();
        List<TimeSpan.Item<U>> totalLength = timeSpan.getTotalLength();
        boolean isNegative = timeSpan.isNegative();
        if (z) {
            isNegative = !timeSpan.isNegative();
        }
        if (isNegative) {
            int size = totalLength.size() - 1;
            t2 = t;
            while (size >= 0) {
                TimeSpan.Item item = totalLength.get(size);
                ChronoUnit chronoUnit = (ChronoUnit) item.getUnit();
                long amount = item.getAmount();
                size--;
                while (size >= 0) {
                    TimeSpan.Item item2 = totalLength.get(size);
                    ChronoUnit chronoUnit2 = (ChronoUnit) item2.getUnit();
                    long amount2 = item2.getAmount();
                    long factor = getFactor(chronology, chronoUnit2, chronoUnit);
                    if (Double.isNaN((double) factor) || amount2 >= 2147483647L || factor <= 1 || factor >= AnimationKt.MillisToNanos || !chronology.isConvertible(chronoUnit2, chronoUnit)) {
                        break;
                    }
                    amount = MathUtils.safeAdd(amount, MathUtils.safeMultiply(amount2, factor));
                    size--;
                }
                t2 = t2.plus(MathUtils.safeNegate(amount), chronoUnit);
            }
        } else {
            int size2 = totalLength.size();
            T t3 = t;
            int i = 0;
            while (i < size2) {
                TimeSpan.Item item3 = totalLength.get(i);
                ChronoUnit chronoUnit3 = (ChronoUnit) item3.getUnit();
                long amount3 = item3.getAmount();
                i++;
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    TimeSpan.Item item4 = totalLength.get(i);
                    ChronoUnit chronoUnit4 = (ChronoUnit) item4.getUnit();
                    long factor2 = getFactor(chronology, chronoUnit3, chronoUnit4);
                    if (!Double.isNaN((double) factor2)) {
                        if (amount3 < 2147483647L) {
                            if (factor2 > 1) {
                                if (factor2 >= AnimationKt.MillisToNanos || !chronology.isConvertible(chronoUnit3, chronoUnit4)) {
                                    break;
                                }
                                amount3 = MathUtils.safeAdd(item4.getAmount(), MathUtils.safeMultiply(amount3, factor2));
                                i++;
                                chronoUnit3 = chronoUnit4;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                t3 = t2.plus(amount3, chronoUnit3);
            }
        }
        return t2;
    }

    private static <U> long getFactor(TimeAxis<U, ?> timeAxis, U u, U u2) {
        return Math.round(timeAxis.getLength(u) / timeAxis.getLength(u2));
    }
}
