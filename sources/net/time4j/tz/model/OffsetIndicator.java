package net.time4j.tz.model;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public enum OffsetIndicator {
    UTC_TIME {
        public char getSymbol() {
            return AbstractJsonLexerKt.UNICODE_ESC;
        }
    },
    STANDARD_TIME {
        public char getSymbol() {
            return 's';
        }
    },
    WALL_TIME {
        public char getSymbol() {
            return 'w';
        }
    };
    
    static final OffsetIndicator[] VALUES = null;

    static {
        VALUES = values();
    }

    public static OffsetIndicator parseSymbol(char c) {
        if (c != 'g') {
            if (c == 's') {
                return STANDARD_TIME;
            }
            if (c != 'u') {
                if (c == 'w') {
                    return WALL_TIME;
                }
                if (c != 'z') {
                    throw new IllegalArgumentException("Unknown offset indicator: " + c);
                }
            }
        }
        return UTC_TIME;
    }

    public char getSymbol() {
        throw new AbstractMethodError();
    }
}
