package net.time4j.calendar.astro;

public enum Twilight {
    BLUE_HOUR(4.0d),
    CIVIL(6.0d),
    NAUTICAL(12.0d),
    ASTRONOMICAL(18.0d);
    
    private final transient double angle;

    private Twilight(double d) {
        this.angle = d;
    }

    /* access modifiers changed from: package-private */
    public double getAngle() {
        return this.angle;
    }
}
