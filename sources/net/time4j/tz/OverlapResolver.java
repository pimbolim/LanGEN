package net.time4j.tz;

public enum OverlapResolver {
    EARLIER_OFFSET,
    LATER_OFFSET;

    public TransitionStrategy and(GapResolver gapResolver) {
        return gapResolver.and(this);
    }
}
