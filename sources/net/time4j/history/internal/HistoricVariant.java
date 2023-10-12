package net.time4j.history.internal;

public enum HistoricVariant {
    PROLEPTIC_JULIAN,
    PROLEPTIC_GREGORIAN,
    SWEDEN,
    INTRODUCTION_ON_1582_10_15,
    SINGLE_CUTOVER_DATE,
    PROLEPTIC_BYZANTINE;

    /* renamed from: net.time4j.history.internal.HistoricVariant$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$history$internal$HistoricVariant = null;

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
                net.time4j.history.internal.HistoricVariant[] r0 = net.time4j.history.internal.HistoricVariant.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$history$internal$HistoricVariant = r0
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.PROLEPTIC_JULIAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.PROLEPTIC_GREGORIAN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.SWEDEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.INTRODUCTION_ON_1582_10_15     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.PROLEPTIC_BYZANTINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.history.internal.HistoricVariant.AnonymousClass1.<clinit>():void");
        }
    }

    public int getSerialValue() {
        int i = AnonymousClass1.$SwitchMap$net$time4j$history$internal$HistoricVariant[ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 4;
        }
        if (i != 4) {
            return i != 5 ? 0 : 3;
        }
        return 7;
    }
}
