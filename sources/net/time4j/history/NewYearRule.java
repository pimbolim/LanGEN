package net.time4j.history;

public enum NewYearRule {
    BEGIN_OF_JANUARY {
        /* access modifiers changed from: package-private */
        public HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i, 1, 1);
        }

        /* access modifiers changed from: package-private */
        public int displayedYear(NewYearStrategy newYearStrategy, HistoricDate historicDate) {
            return historicDate.getYearOfEra();
        }
    },
    BEGIN_OF_MARCH {
        /* access modifiers changed from: package-private */
        public HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i, 3, 1);
        }
    },
    BEGIN_OF_SEPTEMBER {
        /* access modifiers changed from: package-private */
        public HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i - 1, 9, 1);
        }

        /* access modifiers changed from: package-private */
        public int displayedYear(NewYearStrategy newYearStrategy, HistoricDate historicDate) {
            HistoricEra era = historicDate.getEra();
            int yearOfEra = historicDate.getYearOfEra();
            int i = yearOfEra + 1;
            return historicDate.compareTo(newYearStrategy.newYear(era, i)) >= 0 ? i : yearOfEra;
        }
    },
    CHRISTMAS_STYLE {
        /* access modifiers changed from: package-private */
        public HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i - 1, 12, 25);
        }

        /* access modifiers changed from: package-private */
        public int displayedYear(NewYearStrategy newYearStrategy, HistoricDate historicDate) {
            int yearOfEra = historicDate.getYearOfEra();
            int i = yearOfEra + 1;
            return historicDate.compareTo(newYearStrategy.newYear(historicDate.getEra(), i)) >= 0 ? i : yearOfEra;
        }
    },
    EASTER_STYLE {
        /* access modifiers changed from: package-private */
        public HistoricDate newYear(HistoricEra historicEra, int i) {
            int i2;
            int marchDay = Computus.EASTERN.marchDay(historicEra.annoDomini(i)) - 1;
            if (marchDay > 31) {
                i2 = 4;
                marchDay -= 31;
            } else {
                i2 = 3;
            }
            return HistoricDate.of(historicEra, i, i2, marchDay);
        }
    },
    GOOD_FRIDAY {
        /* access modifiers changed from: package-private */
        public HistoricDate newYear(HistoricEra historicEra, int i) {
            int i2;
            int marchDay = Computus.EASTERN.marchDay(historicEra.annoDomini(i)) - 2;
            if (marchDay > 31) {
                i2 = 4;
                marchDay -= 31;
            } else {
                i2 = 3;
            }
            return HistoricDate.of(historicEra, i, i2, marchDay);
        }
    },
    MARIA_ANUNCIATA {
        /* access modifiers changed from: package-private */
        public HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i, 3, 25);
        }
    },
    CALCULUS_PISANUS {
        /* access modifiers changed from: package-private */
        public HistoricDate newYear(HistoricEra historicEra, int i) {
            return MARIA_ANUNCIATA.newYear(historicEra, i + 1);
        }

        /* access modifiers changed from: package-private */
        public int displayedYear(NewYearStrategy newYearStrategy, HistoricDate historicDate) {
            int yearOfEra = historicDate.getYearOfEra() - 1;
            return historicDate.compareTo(newYear(historicDate.getEra(), yearOfEra)) < 0 ? yearOfEra - 1 : yearOfEra;
        }

        /* access modifiers changed from: package-private */
        public int standardYear(boolean z, NewYearStrategy newYearStrategy, HistoricEra historicEra, int i, int i2, int i3) {
            return MARIA_ANUNCIATA.standardYear(z, newYearStrategy, historicEra, i + 1, i2, i3);
        }
    },
    EPIPHANY {
        /* access modifiers changed from: package-private */
        public HistoricDate newYear(HistoricEra historicEra, int i) {
            return HistoricDate.of(historicEra, i, 1, 6);
        }
    };
    
    private static final int COUNCIL_OF_TOURS = 567;

    /* access modifiers changed from: package-private */
    public abstract HistoricDate newYear(HistoricEra historicEra, int i);

    public NewYearStrategy until(int i) {
        if (i > 567) {
            NewYearStrategy newYearStrategy = new NewYearStrategy(this, i);
            NewYearRule newYearRule = BEGIN_OF_JANUARY;
            if (this != newYearRule) {
                return new NewYearStrategy(newYearRule, 567).and(newYearStrategy);
            }
            return newYearStrategy;
        }
        throw new IllegalArgumentException("Defining New-Year-strategy is not supported before Council of Tours in AD 567.");
    }

    /* access modifiers changed from: package-private */
    public int displayedYear(NewYearStrategy newYearStrategy, HistoricDate historicDate) {
        int yearOfEra = historicDate.getYearOfEra();
        return historicDate.compareTo(newYear(historicDate.getEra(), yearOfEra)) < 0 ? yearOfEra - 1 : yearOfEra;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r7.compareTo(r6) >= 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r2.compareTo(r6) >= 0) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int standardYear(boolean r5, net.time4j.history.NewYearStrategy r6, net.time4j.history.HistoricEra r7, int r8, int r9, int r10) {
        /*
            r4 = this;
            r0 = 5
            if (r9 < r0) goto L_0x0008
            r0 = 8
            if (r9 > r0) goto L_0x0008
            return r8
        L_0x0008:
            net.time4j.history.HistoricDate r0 = r4.newYear(r7, r8)
            int r1 = r8 + 1
            net.time4j.history.HistoricDate r6 = r6.newYear(r7, r1)
            net.time4j.history.HistoricDate r2 = net.time4j.history.HistoricDate.of(r7, r8, r9, r10)
            r3 = 4
            if (r9 > r3) goto L_0x002f
            net.time4j.history.HistoricDate r7 = net.time4j.history.HistoricDate.of(r7, r1, r9, r10)
            int r9 = r2.compareTo((net.time4j.history.HistoricDate) r0)
            if (r9 < 0) goto L_0x0025
            r9 = r8
            goto L_0x0026
        L_0x0025:
            r9 = r1
        L_0x0026:
            int r6 = r7.compareTo((net.time4j.history.HistoricDate) r6)
            if (r6 < 0) goto L_0x002d
            goto L_0x0045
        L_0x002d:
            r8 = r1
            goto L_0x0045
        L_0x002f:
            int r1 = r8 + -1
            net.time4j.history.HistoricDate r7 = net.time4j.history.HistoricDate.of(r7, r1, r9, r10)
            int r7 = r7.compareTo((net.time4j.history.HistoricDate) r0)
            if (r7 < 0) goto L_0x003d
            r9 = r1
            goto L_0x003e
        L_0x003d:
            r9 = r8
        L_0x003e:
            int r6 = r2.compareTo((net.time4j.history.HistoricDate) r6)
            if (r6 < 0) goto L_0x0045
            goto L_0x002d
        L_0x0045:
            if (r9 > r8) goto L_0x004b
            if (r5 == 0) goto L_0x004a
            r8 = r9
        L_0x004a:
            return r8
        L_0x004b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Invalid date due to changing new year rule (year too short to cover month and day-of-month): "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.history.NewYearRule.standardYear(boolean, net.time4j.history.NewYearStrategy, net.time4j.history.HistoricEra, int, int, int):int");
    }
}
