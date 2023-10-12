package net.time4j;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ChronoOperator;

final class IntegerDateElement extends AbstractDateElement<Integer> implements ProportionalElement<Integer, PlainDate> {
    static final int DAY_OF_MONTH = 16;
    static final int DAY_OF_QUARTER = 18;
    static final int DAY_OF_YEAR = 17;
    static final int MONTH = 15;
    static final int YEAR = 14;
    private static final long serialVersionUID = -1337148214680014674L;
    private final transient Integer defaultMax;
    private final transient Integer defaultMin;
    private final transient int index;
    private final transient ChronoFunction<ChronoEntity<?>, BigDecimal> rf = new ProportionalFunction(this, false);
    private final transient char symbol;

    public boolean isDateElement() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isSingleton() {
        return true;
    }

    public boolean isTimeElement() {
        return false;
    }

    public /* bridge */ /* synthetic */ ElementOperator setLenient(Number number) {
        return super.setLenient((Integer) number);
    }

    private IntegerDateElement(String str, int i, Integer num, Integer num2, char c) {
        super(str);
        this.index = i;
        this.defaultMin = num;
        this.defaultMax = num2;
        this.symbol = c;
    }

    public Class<Integer> getType() {
        return Integer.class;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public Integer getDefaultMinimum() {
        return this.defaultMin;
    }

    public Integer getDefaultMaximum() {
        return this.defaultMax;
    }

    public ChronoFunction<ChronoEntity<?>, BigDecimal> ratio() {
        return this.rf;
    }

    public ChronoOperator<PlainDate> roundedUp(int i) {
        return new RoundingOperator(this, Boolean.TRUE, i);
    }

    public ChronoOperator<PlainDate> roundedHalf(int i) {
        return new RoundingOperator(this, (Boolean) null, i);
    }

    public ChronoOperator<PlainDate> roundedDown(int i) {
        return new RoundingOperator(this, Boolean.FALSE, i);
    }

    /* access modifiers changed from: package-private */
    public int getIndex() {
        return this.index;
    }

    static IntegerDateElement create(String str, int i, int i2, int i3, char c) {
        return new IntegerDateElement(str, i, Integer.valueOf(i2), Integer.valueOf(i3), c);
    }

    private Object readResolve() throws ObjectStreamException {
        Object lookupElement = PlainDate.lookupElement(name());
        if (lookupElement != null) {
            return lookupElement;
        }
        throw new InvalidObjectException(name());
    }
}
