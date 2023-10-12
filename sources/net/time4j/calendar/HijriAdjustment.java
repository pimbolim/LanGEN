package net.time4j.calendar;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.ChronoException;
import net.time4j.engine.VariantSource;

public final class HijriAdjustment implements VariantSource {
    private final int adjustment;
    private final String baseVariant;

    private HijriAdjustment(String str, int i) {
        if (i < -3 || i > 3) {
            throw new ChronoException("Day adjustment out of range -3 <= x <= 3: " + i);
        } else if (!str.isEmpty()) {
            this.adjustment = i;
            this.baseVariant = str;
        } else {
            throw new IllegalArgumentException("Empty variant.");
        }
    }

    public static HijriAdjustment ofUmalqura(int i) {
        return new HijriAdjustment(HijriCalendar.VARIANT_UMALQURA, i);
    }

    public static HijriAdjustment of(String str, int i) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            return new HijriAdjustment(str, i);
        }
        return new HijriAdjustment(str.substring(0, indexOf), i);
    }

    public static HijriAdjustment of(VariantSource variantSource, int i) {
        return of(variantSource.getVariant(), i);
    }

    public String getVariant() {
        if (this.adjustment == 0) {
            return this.baseVariant;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.baseVariant);
        sb.append(AbstractJsonLexerKt.COLON);
        if (this.adjustment > 0) {
            sb.append(SignatureVisitor.EXTENDS);
        }
        sb.append(this.adjustment);
        return sb.toString();
    }

    public int getValue() {
        return this.adjustment;
    }

    /* access modifiers changed from: package-private */
    public String getBaseVariant() {
        return this.baseVariant;
    }

    static HijriAdjustment from(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            return new HijriAdjustment(str, 0);
        }
        try {
            return new HijriAdjustment(str.substring(0, indexOf), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (NumberFormatException unused) {
            throw new ChronoException("Invalid day adjustment: " + str);
        }
    }
}
