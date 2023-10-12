package net.time4j.history;

interface Calculus {
    HistoricDate fromMJD(long j);

    int getMaximumDayOfMonth(HistoricDate historicDate);

    boolean isValid(HistoricDate historicDate);

    long toMJD(HistoricDate historicDate);
}
