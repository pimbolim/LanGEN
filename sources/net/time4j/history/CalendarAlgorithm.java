package net.time4j.history;

import net.time4j.base.GregorianMath;

enum CalendarAlgorithm implements Calculus {
    GREGORIAN {
        public long toMJD(HistoricDate historicDate) {
            return GregorianMath.toMJD(CalendarAlgorithm.getProlepticYear(historicDate), historicDate.getMonth(), historicDate.getDayOfMonth());
        }

        public HistoricDate fromMJD(long j) {
            long packedDate = GregorianMath.toPackedDate(j);
            int readYear = GregorianMath.readYear(packedDate);
            int readMonth = GregorianMath.readMonth(packedDate);
            int readDayOfMonth = GregorianMath.readDayOfMonth(packedDate);
            HistoricEra historicEra = readYear <= 0 ? HistoricEra.BC : HistoricEra.AD;
            if (readYear <= 0) {
                readYear = 1 - readYear;
            }
            return new HistoricDate(historicEra, readYear, readMonth, readDayOfMonth);
        }

        public boolean isValid(HistoricDate historicDate) {
            return GregorianMath.isValid(CalendarAlgorithm.getProlepticYear(historicDate), historicDate.getMonth(), historicDate.getDayOfMonth());
        }

        public int getMaximumDayOfMonth(HistoricDate historicDate) {
            return GregorianMath.getLengthOfMonth(CalendarAlgorithm.getProlepticYear(historicDate), historicDate.getMonth());
        }
    },
    JULIAN {
        public long toMJD(HistoricDate historicDate) {
            return JulianMath.toMJD(CalendarAlgorithm.getProlepticYear(historicDate), historicDate.getMonth(), historicDate.getDayOfMonth());
        }

        public HistoricDate fromMJD(long j) {
            long packedDate = JulianMath.toPackedDate(j);
            int readYear = JulianMath.readYear(packedDate);
            int readMonth = JulianMath.readMonth(packedDate);
            int readDayOfMonth = JulianMath.readDayOfMonth(packedDate);
            HistoricEra historicEra = readYear <= 0 ? HistoricEra.BC : HistoricEra.AD;
            if (readYear <= 0) {
                readYear = 1 - readYear;
            }
            return new HistoricDate(historicEra, readYear, readMonth, readDayOfMonth);
        }

        public boolean isValid(HistoricDate historicDate) {
            return JulianMath.isValid(CalendarAlgorithm.getProlepticYear(historicDate), historicDate.getMonth(), historicDate.getDayOfMonth());
        }

        public int getMaximumDayOfMonth(HistoricDate historicDate) {
            return JulianMath.getLengthOfMonth(CalendarAlgorithm.getProlepticYear(historicDate), historicDate.getMonth());
        }
    },
    SWEDISH {
        public long toMJD(HistoricDate historicDate) {
            int access$100 = CalendarAlgorithm.getProlepticYear(historicDate);
            if (historicDate.getDayOfMonth() == 30 && historicDate.getMonth() == 2 && access$100 == 1712) {
                return -53576;
            }
            return JulianMath.toMJD(access$100, historicDate.getMonth(), historicDate.getDayOfMonth()) - 1;
        }

        public HistoricDate fromMJD(long j) {
            if (j == -53576) {
                return new HistoricDate(HistoricEra.AD, 1712, 2, 30);
            }
            return JULIAN.fromMJD(j + 1);
        }

        public boolean isValid(HistoricDate historicDate) {
            int access$100 = CalendarAlgorithm.getProlepticYear(historicDate);
            if (historicDate.getDayOfMonth() == 30 && historicDate.getMonth() == 2 && access$100 == 1712) {
                return true;
            }
            return JulianMath.isValid(access$100, historicDate.getMonth(), historicDate.getDayOfMonth());
        }

        public int getMaximumDayOfMonth(HistoricDate historicDate) {
            int access$100 = CalendarAlgorithm.getProlepticYear(historicDate);
            if (historicDate.getMonth() == 2 && access$100 == 1712) {
                return 30;
            }
            return JulianMath.getLengthOfMonth(access$100, historicDate.getMonth());
        }
    };

    /* access modifiers changed from: private */
    public static int getProlepticYear(HistoricDate historicDate) {
        return historicDate.getEra().annoDomini(historicDate.getYearOfEra());
    }
}
