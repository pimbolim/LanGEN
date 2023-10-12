package net.time4j.history;

import java.util.Locale;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.ChronoElement;
import net.time4j.format.CalendarText;
import net.time4j.format.TextWidth;

public enum HistoricEra implements CalendarEra {
    BC,
    AD,
    HISPANIC,
    BYZANTINE,
    AB_URBE_CONDITA;

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getIsoInstance(locale).getEras(textWidth).print(this);
    }

    public String getAlternativeName(Locale locale, TextWidth textWidth) {
        CalendarText isoInstance = CalendarText.getIsoInstance(locale);
        ChronoElement<HistoricEra> era = ChronoHistory.ofFirstGregorianReform().era();
        String[] strArr = new String[2];
        strArr[0] = textWidth == TextWidth.WIDE ? "w" : "a";
        strArr[1] = "alt";
        return isoInstance.getTextForms(era, strArr).print(this);
    }

    /* renamed from: net.time4j.history.HistoricEra$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$history$HistoricEra = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                net.time4j.history.HistoricEra[] r0 = net.time4j.history.HistoricEra.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$history$HistoricEra = r0
                net.time4j.history.HistoricEra r1 = net.time4j.history.HistoricEra.BC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$history$HistoricEra     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.history.HistoricEra r1 = net.time4j.history.HistoricEra.AD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$history$HistoricEra     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.history.HistoricEra r1 = net.time4j.history.HistoricEra.HISPANIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$history$HistoricEra     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.history.HistoricEra r1 = net.time4j.history.HistoricEra.BYZANTINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$net$time4j$history$HistoricEra     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.history.HistoricEra r1 = net.time4j.history.HistoricEra.AB_URBE_CONDITA     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.history.HistoricEra.AnonymousClass1.<clinit>():void");
        }
    }

    public int annoDomini(int i) {
        try {
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$history$HistoricEra[ordinal()];
            if (i2 == 1) {
                return MathUtils.safeSubtract(1, i);
            }
            if (i2 == 2) {
                return i;
            }
            if (i2 == 3) {
                return MathUtils.safeSubtract(i, 38);
            }
            if (i2 == 4) {
                return MathUtils.safeSubtract(i, 5508);
            }
            if (i2 == 5) {
                return MathUtils.safeSubtract(i, 753);
            }
            throw new UnsupportedOperationException(name());
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Out of range: " + i);
        }
    }

    /* access modifiers changed from: package-private */
    public int yearOfEra(HistoricEra historicEra, int i) {
        int annoDomini = historicEra.annoDomini(i);
        try {
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$history$HistoricEra[ordinal()];
            if (i2 == 1) {
                return MathUtils.safeSubtract(1, annoDomini);
            }
            if (i2 == 2) {
                return annoDomini;
            }
            if (i2 == 3) {
                return MathUtils.safeAdd(annoDomini, 38);
            }
            if (i2 == 4) {
                return MathUtils.safeAdd(annoDomini, 5508);
            }
            if (i2 == 5) {
                return MathUtils.safeAdd(annoDomini, 753);
            }
            throw new UnsupportedOperationException(name());
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Out of range: " + i);
        }
    }
}
