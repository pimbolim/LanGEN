package net.time4j.scale;

public interface TickProvider {
    long getNanos();

    String getPlatform();
}
