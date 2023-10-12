package net.time4j.tz;

public enum GapResolver {
    PUSH_FORWARD,
    NEXT_VALID_TIME,
    ABORT;

    public TransitionStrategy and(OverlapResolver overlapResolver) {
        return TransitionResolver.of(this, overlapResolver);
    }
}
