package net.time4j.format;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.time4j.base.ResourceLoader;

public abstract class PluralRules {
    private static final Map<String, PluralRules> CARDINAL_MAP = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public static final PluralRules FALLBACK_CARDINAL_ENGLISH = new FallbackRules(NumberType.CARDINALS, true, (AnonymousClass1) null);
    /* access modifiers changed from: private */
    public static final PluralRules FALLBACK_CARDINAL_OTHER = new FallbackRules(NumberType.CARDINALS, false, (AnonymousClass1) null);
    /* access modifiers changed from: private */
    public static final PluralRules FALLBACK_ORDINAL_ENGLISH = new FallbackRules(NumberType.ORDINALS, true, (AnonymousClass1) null);
    /* access modifiers changed from: private */
    public static final PluralRules FALLBACK_ORDINAL_OTHER = new FallbackRules(NumberType.ORDINALS, false, (AnonymousClass1) null);
    private static final Map<String, PluralRules> ORDINAL_MAP = new ConcurrentHashMap();

    public abstract PluralCategory getCategory(long j);

    public abstract NumberType getNumberType();

    public static PluralRules of(Locale locale, NumberType numberType) {
        Map<String, PluralRules> ruleMap = getRuleMap(numberType);
        PluralRules pluralRules = null;
        if (!ruleMap.isEmpty()) {
            if (!locale.getCountry().equals("")) {
                pluralRules = ruleMap.get(toKey(locale));
            }
            if (pluralRules == null) {
                pluralRules = ruleMap.get(locale.getLanguage());
            }
        }
        return pluralRules == null ? Holder.PROVIDER.load(locale, numberType) : pluralRules;
    }

    public static void register(Locale locale, PluralRules pluralRules) {
        Map<String, PluralRules> ruleMap = getRuleMap(pluralRules.getNumberType());
        String language = locale.getLanguage();
        if (!locale.getCountry().equals("")) {
            language = toKey(locale);
        }
        ruleMap.put(language, pluralRules);
    }

    /* renamed from: net.time4j.format.PluralRules$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$NumberType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                net.time4j.format.NumberType[] r0 = net.time4j.format.NumberType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$NumberType = r0
                net.time4j.format.NumberType r1 = net.time4j.format.NumberType.CARDINALS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$format$NumberType     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.NumberType r1 = net.time4j.format.NumberType.ORDINALS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.PluralRules.AnonymousClass1.<clinit>():void");
        }
    }

    private static Map<String, PluralRules> getRuleMap(NumberType numberType) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$NumberType[numberType.ordinal()];
        if (i == 1) {
            return CARDINAL_MAP;
        }
        if (i == 2) {
            return ORDINAL_MAP;
        }
        throw new UnsupportedOperationException(numberType.name());
    }

    private static String toKey(Locale locale) {
        return locale.getLanguage() + '_' + locale.getCountry();
    }

    private static class FallbackRules extends PluralRules {
        private final boolean english;
        private final NumberType numType;

        /* synthetic */ FallbackRules(NumberType numberType, boolean z, AnonymousClass1 r3) {
            this(numberType, z);
        }

        private FallbackRules(NumberType numberType, boolean z) {
            this.numType = numberType;
            this.english = z;
        }

        public PluralCategory getCategory(long j) {
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$NumberType[this.numType.ordinal()];
            if (i == 1) {
                return j == 1 ? PluralCategory.ONE : PluralCategory.OTHER;
            }
            if (i == 2) {
                if (this.english) {
                    long j2 = j % 10;
                    long j3 = j % 100;
                    if (j2 == 1 && j3 != 11) {
                        return PluralCategory.ONE;
                    }
                    if (j2 == 2 && j3 != 12) {
                        return PluralCategory.TWO;
                    }
                    if (j2 == 3 && j3 != 13) {
                        return PluralCategory.FEW;
                    }
                }
                return PluralCategory.OTHER;
            }
            throw new UnsupportedOperationException(this.numType.name());
        }

        public NumberType getNumberType() {
            return this.numType;
        }
    }

    private static class FallbackProvider implements PluralProvider {
        private FallbackProvider() {
        }

        /* synthetic */ FallbackProvider(AnonymousClass1 r1) {
            this();
        }

        public PluralRules load(Locale locale, NumberType numberType) {
            boolean equals = locale.getLanguage().equals("en");
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$NumberType[numberType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new UnsupportedOperationException(numberType.name());
                } else if (equals) {
                    return PluralRules.FALLBACK_ORDINAL_ENGLISH;
                } else {
                    return PluralRules.FALLBACK_ORDINAL_OTHER;
                }
            } else if (equals) {
                return PluralRules.FALLBACK_CARDINAL_ENGLISH;
            } else {
                return PluralRules.FALLBACK_CARDINAL_OTHER;
            }
        }
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final PluralProvider PROVIDER;

        private Holder() {
        }

        static {
            Iterator<S> it = ResourceLoader.getInstance().services(PluralProvider.class).iterator();
            PluralProvider pluralProvider = it.hasNext() ? (PluralProvider) it.next() : null;
            if (pluralProvider == null) {
                pluralProvider = new FallbackProvider((AnonymousClass1) null);
            }
            PROVIDER = pluralProvider;
        }
    }
}
