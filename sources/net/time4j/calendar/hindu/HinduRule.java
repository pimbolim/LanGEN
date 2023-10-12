package net.time4j.calendar.hindu;

public enum HinduRule {
    ORISSA {
        /* access modifiers changed from: package-private */
        public HinduEra getDefaultEra() {
            return HinduEra.SAKA;
        }
    },
    TAMIL {
        /* access modifiers changed from: package-private */
        public HinduEra getDefaultEra() {
            return HinduEra.SAKA;
        }
    },
    MALAYALI {
        /* access modifiers changed from: package-private */
        public HinduEra getDefaultEra() {
            return HinduEra.KOLLAM;
        }
    },
    MADRAS {
        /* access modifiers changed from: package-private */
        public HinduEra getDefaultEra() {
            return HinduEra.SAKA;
        }
    },
    AMANTA {
        /* access modifiers changed from: package-private */
        public HinduEra getDefaultEra() {
            return HinduEra.VIKRAMA;
        }
    },
    AMANTA_ASHADHA {
        /* access modifiers changed from: package-private */
        public HinduEra getDefaultEra() {
            return HinduEra.VIKRAMA;
        }
    },
    AMANTA_KARTIKA {
        /* access modifiers changed from: package-private */
        public HinduEra getDefaultEra() {
            return HinduEra.VIKRAMA;
        }
    },
    PURNIMANTA {
        /* access modifiers changed from: package-private */
        public HinduEra getDefaultEra() {
            return HinduEra.VIKRAMA;
        }
    };

    /* access modifiers changed from: package-private */
    public abstract HinduEra getDefaultEra();

    public HinduVariant variant() {
        return new HinduVariant(this, getDefaultEra());
    }
}
