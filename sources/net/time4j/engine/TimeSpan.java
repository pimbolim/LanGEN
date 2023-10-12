package net.time4j.engine;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public interface TimeSpan<U> {
    <T extends TimePoint<? super U, T>> T addTo(T t);

    boolean contains(U u);

    long getPartialAmount(U u);

    List<Item<U>> getTotalLength();

    boolean isEmpty();

    boolean isNegative();

    boolean isPositive();

    <T extends TimePoint<? super U, T>> T subtractFrom(T t);

    public static final class Item<U> implements Serializable {
        private static final long serialVersionUID = 1564804888291509484L;
        private final long amount;
        private final U unit;

        private Item(long j, U u) {
            Objects.requireNonNull(u, "Missing chronological unit.");
            if (j >= 0) {
                this.amount = j;
                this.unit = u;
                return;
            }
            throw new IllegalArgumentException("Temporal amount must be positive or zero: " + j);
        }

        public static <U> Item<U> of(long j, U u) {
            return new Item<>(j, u);
        }

        public long getAmount() {
            return this.amount;
        }

        public U getUnit() {
            return this.unit;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item cast = Item.class.cast(obj);
            if (this.amount != cast.amount || !this.unit.equals(cast.unit)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.amount;
            return (this.unit.hashCode() * 29) + ((int) (j ^ (j >>> 32)));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('P');
            sb.append(this.amount);
            sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
            sb.append(this.unit);
            sb.append(AbstractJsonLexerKt.END_OBJ);
            return sb.toString();
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            if (this.unit == null || this.amount < 0) {
                throw new InvalidObjectException("Inconsistent state.");
            }
        }
    }
}
