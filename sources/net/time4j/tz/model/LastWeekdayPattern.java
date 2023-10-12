package net.time4j.tz.model;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.Month;
import net.time4j.PlainDate;
import net.time4j.Weekday;
import net.time4j.base.GregorianMath;

final class LastWeekdayPattern extends GregorianTimezoneRule {
    private static final long serialVersionUID = -946839310332554772L;
    private final transient byte dayOfWeek;

    /* access modifiers changed from: package-private */
    public int getType() {
        return 122;
    }

    LastWeekdayPattern(Month month, Weekday weekday, int i, OffsetIndicator offsetIndicator, int i2) {
        super(month, i, offsetIndicator, i2);
        this.dayOfWeek = (byte) weekday.getValue();
    }

    /* access modifiers changed from: protected */
    public PlainDate getDate0(int i) {
        byte monthValue = getMonthValue();
        int lengthOfMonth = GregorianMath.getLengthOfMonth(i, monthValue);
        int dayOfWeek2 = GregorianMath.getDayOfWeek(i, monthValue, lengthOfMonth) - this.dayOfWeek;
        if (dayOfWeek2 < 0) {
            dayOfWeek2 += 7;
        }
        return PlainDate.of(i, (int) monthValue, lengthOfMonth - dayOfWeek2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LastWeekdayPattern)) {
            return false;
        }
        LastWeekdayPattern lastWeekdayPattern = (LastWeekdayPattern) obj;
        if (this.dayOfWeek != lastWeekdayPattern.dayOfWeek || !super.isEqual(lastWeekdayPattern)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.dayOfWeek * 17) + (getMonthValue() * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("LastDayOfWeekPattern:[month=");
        sb.append(getMonthValue());
        sb.append(",day-of-week=");
        sb.append(Weekday.valueOf((int) this.dayOfWeek));
        sb.append(",day-overflow=");
        sb.append(getDayOverflow());
        sb.append(",time-of-day=");
        sb.append(getTimeOfDay());
        sb.append(",offset-indicator=");
        sb.append(getIndicator());
        sb.append(",dst-offset=");
        sb.append(getSavings());
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public byte getDayOfWeek() {
        return this.dayOfWeek;
    }

    private Object writeReplace() {
        return new SPX(this, getType());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
