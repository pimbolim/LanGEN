package net.time4j;

import net.time4j.engine.CalendarDate;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.TimePoint;
import net.time4j.engine.UnitRule;

public enum CalendarUnit implements IsoDateUnit {
    MILLENNIA {
        public double getLength() {
            return 3.1556952E10d;
        }

        public char getSymbol() {
            return 'I';
        }
    },
    CENTURIES {
        public double getLength() {
            return 3.1556952E9d;
        }

        public char getSymbol() {
            return 'C';
        }
    },
    DECADES {
        public double getLength() {
            return 3.1556952E8d;
        }

        public char getSymbol() {
            return 'E';
        }
    },
    YEARS {
        public double getLength() {
            return 3.1556952E7d;
        }

        public char getSymbol() {
            return 'Y';
        }
    },
    QUARTERS {
        public double getLength() {
            return 7889238.0d;
        }

        public char getSymbol() {
            return 'Q';
        }
    },
    MONTHS {
        public double getLength() {
            return 2629746.0d;
        }

        public char getSymbol() {
            return 'M';
        }
    },
    WEEKS {
        public double getLength() {
            return 604800.0d;
        }

        public char getSymbol() {
            return 'W';
        }
    },
    DAYS {
        public double getLength() {
            return 86400.0d;
        }

        public char getSymbol() {
            return 'D';
        }
    };
    
    private final IsoDateUnit co;
    private final IsoDateUnit eof;
    private final IsoDateUnit joda;
    private final IsoDateUnit kld;
    private final IsoDateUnit nvd;
    private final IsoDateUnit ui;

    public boolean isCalendrical() {
        return true;
    }

    public <T extends TimePoint<? super CalendarUnit, T>> long between(T t, T t2) {
        return t.until(t2, this);
    }

    /* renamed from: net.time4j.CalendarUnit$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$CalendarUnit = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                net.time4j.CalendarUnit[] r0 = net.time4j.CalendarUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$CalendarUnit = r0
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0054 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.QUARTERS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0060 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.CalendarUnit.AnonymousClass9.<clinit>():void");
        }
    }

    public IsoDateUnit nextValidDate() {
        int i = AnonymousClass9.$SwitchMap$net$time4j$CalendarUnit[ordinal()];
        return (i == 1 || i == 2) ? this : this.nvd;
    }

    public IsoDateUnit withCarryOver() {
        int i = AnonymousClass9.$SwitchMap$net$time4j$CalendarUnit[ordinal()];
        return (i == 1 || i == 2) ? this : this.co;
    }

    public IsoDateUnit unlessInvalid() {
        int i = AnonymousClass9.$SwitchMap$net$time4j$CalendarUnit[ordinal()];
        return (i == 1 || i == 2) ? this : this.ui;
    }

    public IsoDateUnit atEndOfMonth() {
        int i = AnonymousClass9.$SwitchMap$net$time4j$CalendarUnit[ordinal()];
        if (i != 1 && i != 2) {
            return this.eof;
        }
        throw new UnsupportedOperationException("Original unit is not month-based: " + name());
    }

    public IsoDateUnit keepingEndOfMonth() {
        int i = AnonymousClass9.$SwitchMap$net$time4j$CalendarUnit[ordinal()];
        if (i != 1 && i != 2) {
            return this.kld;
        }
        throw new UnsupportedOperationException("Original unit is not month-based: " + name());
    }

    public IsoDateUnit withJodaMetric() {
        int i = AnonymousClass9.$SwitchMap$net$time4j$CalendarUnit[ordinal()];
        return (i == 1 || i == 2) ? this : this.joda;
    }

    public static IsoDateUnit weekBasedYears() {
        return Weekcycle.YEARS;
    }

    static class Rule<T extends ChronoEntity<T>> implements UnitRule<T> {
        private final int policy;
        private final CalendarUnit unit;

        Rule(CalendarUnit calendarUnit) {
            this(calendarUnit, 0);
        }

        Rule(CalendarUnit calendarUnit, int i) {
            this.unit = calendarUnit;
            this.policy = i;
        }

        public T addTo(T t, long j) {
            return t.with(PlainDate.CALENDAR_DATE, PlainDate.doAdd(this.unit, (PlainDate) t.get(PlainDate.CALENDAR_DATE), j, this.policy));
        }

        public long between(T t, T t2) {
            long j;
            PlainDate plainDate = (PlainDate) t.get(PlainDate.CALENDAR_DATE);
            PlainDate plainDate2 = (PlainDate) t2.get(PlainDate.CALENDAR_DATE);
            switch (AnonymousClass9.$SwitchMap$net$time4j$CalendarUnit[this.unit.ordinal()]) {
                case 1:
                    j = dayDelta(plainDate, plainDate2) / 7;
                    break;
                case 2:
                    j = dayDelta(plainDate, plainDate2);
                    break;
                case 3:
                    j = monthDelta(plainDate, plainDate2) / 12000;
                    break;
                case 4:
                    j = monthDelta(plainDate, plainDate2) / 1200;
                    break;
                case 5:
                    j = monthDelta(plainDate, plainDate2) / 120;
                    break;
                case 6:
                    j = monthDelta(plainDate, plainDate2) / 12;
                    break;
                case 7:
                    j = monthDelta(plainDate, plainDate2) / 3;
                    break;
                case 8:
                    j = monthDelta(plainDate, plainDate2);
                    break;
                default:
                    throw new UnsupportedOperationException(this.unit.name());
            }
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i == 0 || !t.contains(PlainTime.WALL_TIME) || !t2.contains(PlainTime.WALL_TIME)) {
                return j;
            }
            boolean z = true;
            if (!(this.unit == CalendarUnit.DAYS || ((PlainDate) plainDate.plus(j, this.unit)).compareByTime(plainDate2) == 0)) {
                z = false;
            }
            if (!z) {
                return j;
            }
            PlainTime plainTime = (PlainTime) t.get(PlainTime.WALL_TIME);
            PlainTime plainTime2 = (PlainTime) t2.get(PlainTime.WALL_TIME);
            if (i <= 0 || !plainTime.isAfter(plainTime2)) {
                return (i >= 0 || !plainTime.isBefore(plainTime2)) ? j : j + 1;
            }
            return j - 1;
        }

        private long monthDelta(PlainDate plainDate, PlainDate plainDate2) {
            long epochMonths = plainDate2.getEpochMonths() - plainDate.getEpochMonths();
            int i = this.policy;
            if (i == 5 || i == 2 || i == 6) {
                CalendarUnit calendarUnit = CalendarUnit.MONTHS;
                int i2 = (epochMonths > 0 ? 1 : (epochMonths == 0 ? 0 : -1));
                if (i2 <= 0 || !PlainDate.doAdd(calendarUnit, plainDate, epochMonths, this.policy).isAfter((CalendarDate) plainDate2)) {
                    if (i2 >= 0 || !PlainDate.doAdd(calendarUnit, plainDate, epochMonths, this.policy).isBefore((CalendarDate) plainDate2)) {
                        return epochMonths;
                    }
                    return epochMonths + 1;
                }
            } else {
                int i3 = (epochMonths > 0 ? 1 : (epochMonths == 0 ? 0 : -1));
                if (i3 <= 0 || plainDate2.getDayOfMonth() >= plainDate.getDayOfMonth()) {
                    if (i3 >= 0 || plainDate2.getDayOfMonth() <= plainDate.getDayOfMonth()) {
                        return epochMonths;
                    }
                    return epochMonths + 1;
                }
            }
            return epochMonths - 1;
        }

        private static long dayDelta(PlainDate plainDate, PlainDate plainDate2) {
            if (plainDate.getYear() == plainDate2.getYear()) {
                return (long) (plainDate2.getDayOfYear() - plainDate.getDayOfYear());
            }
            return plainDate2.getDaysSinceUTC() - plainDate.getDaysSinceUTC();
        }
    }
}
