package net.time4j.tz.model;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.CalendarUnit;
import net.time4j.Month;
import net.time4j.PlainDate;
import net.time4j.Weekday;
import net.time4j.base.GregorianMath;

final class DayOfWeekInMonthPattern extends GregorianTimezoneRule {
    private static final long serialVersionUID = -7354650946442523175L;
    private final transient boolean after;
    private final transient byte dayOfMonth;
    private final transient byte dayOfWeek;

    /* access modifiers changed from: package-private */
    public int getType() {
        return 121;
    }

    DayOfWeekInMonthPattern(Month month, int i, Weekday weekday, int i2, OffsetIndicator offsetIndicator, int i3, boolean z) {
        super(month, i2, offsetIndicator, i3);
        GregorianMath.checkDate(2000, month.getValue(), i);
        this.dayOfMonth = (byte) i;
        this.dayOfWeek = (byte) weekday.getValue();
        this.after = z;
    }

    /* access modifiers changed from: protected */
    public PlainDate getDate0(int i) {
        byte monthValue = getMonthValue();
        int dayOfWeek2 = GregorianMath.getDayOfWeek(i, monthValue, this.dayOfMonth);
        PlainDate of = PlainDate.of(i, (int) monthValue, (int) this.dayOfMonth);
        byte b = this.dayOfWeek;
        if (dayOfWeek2 == b) {
            return of;
        }
        int i2 = dayOfWeek2 - b;
        int i3 = -1;
        if (this.after) {
            i2 = -i2;
            i3 = 1;
        }
        if (i2 < 0) {
            i2 += 7;
        }
        return (PlainDate) of.plus((long) (i2 * i3), CalendarUnit.DAYS);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DayOfWeekInMonthPattern)) {
            return false;
        }
        DayOfWeekInMonthPattern dayOfWeekInMonthPattern = (DayOfWeekInMonthPattern) obj;
        if (this.dayOfMonth == dayOfWeekInMonthPattern.dayOfMonth && this.dayOfWeek == dayOfWeekInMonthPattern.dayOfWeek && this.after == dayOfWeekInMonthPattern.after && super.isEqual(dayOfWeekInMonthPattern)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.dayOfMonth + ((this.dayOfWeek + (getMonthValue() * 37)) * 17) + (this.after ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("DayOfWeekInMonthPattern:[month=");
        sb.append(getMonthValue());
        sb.append(",dayOfMonth=");
        sb.append(this.dayOfMonth);
        sb.append(",dayOfWeek=");
        sb.append(Weekday.valueOf((int) this.dayOfWeek));
        sb.append(",day-overflow=");
        sb.append(getDayOverflow());
        sb.append(",time-of-day=");
        sb.append(getTimeOfDay());
        sb.append(",offset-indicator=");
        sb.append(getIndicator());
        sb.append(",dst-offset=");
        sb.append(getSavings());
        sb.append(",after=");
        sb.append(this.after);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    /* access modifiers changed from: package-private */
    public byte getDayOfWeek() {
        return this.dayOfWeek;
    }

    /* access modifiers changed from: package-private */
    public boolean isAfter() {
        return this.after;
    }

    private Object writeReplace() {
        return new SPX(this, getType());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
