package net.time4j.engine;

public class RuleNotFoundException extends ChronoException {
    private static final long serialVersionUID = -5638437652574160520L;

    RuleNotFoundException(Chronology<?> chronology, ChronoElement<?> chronoElement) {
        super(createMessage(chronology, chronoElement));
    }

    RuleNotFoundException(String str) {
        super(str);
    }

    RuleNotFoundException(Chronology<?> chronology, Object obj) {
        super(createMessage(chronology, obj));
    }

    private static String createMessage(Chronology<?> chronology, ChronoElement<?> chronoElement) {
        return "Cannot find any rule for chronological element \"" + chronoElement.name() + "\" in: " + chronology.getChronoType().getName();
    }

    private static String createMessage(Chronology<?> chronology, Object obj) {
        return "Cannot find any rule for chronological unit \"" + getName(obj) + "\" in: " + chronology.getChronoType().getName();
    }

    private static String getName(Object obj) {
        if (obj instanceof Enum) {
            return Enum.class.cast(obj).name();
        }
        return obj.toString();
    }
}
