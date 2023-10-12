package net.time4j.base;

public interface WallTime {
    int getHour();

    int getMinute();

    int getNanosecond();

    int getSecond();

    String toString();
}
