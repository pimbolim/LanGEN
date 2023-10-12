package net.time4j.engine;

public class ChronoException extends RuntimeException {
    private static final long serialVersionUID = -6646794951280971956L;

    public ChronoException(String str) {
        super(str);
    }

    public ChronoException(String str, Exception exc) {
        super(str, exc);
    }
}
