package net.time4j.scale;

interface ExtendedLSE extends LeapSecondEvent {
    long raw();

    long utc();
}
