package net.time4j.i18n;

import androidx.compose.animation.core.AnimationKt;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.time4j.format.NumberType;
import net.time4j.format.PluralCategory;
import net.time4j.format.PluralProvider;
import net.time4j.format.PluralRules;
import org.apache.commons.lang3.StringUtils;

public final class DefaultPluralProviderSPI implements PluralProvider {
    private static final Map<String, PluralRules> CARDINAL_MAP;
    private static final Map<String, PluralRules> ORDINAL_MAP;
    private static final PluralRules STD_CARDINALS = new StdCardinalRules(0, (AnonymousClass1) null);
    private static final PluralRules STD_ORDINALS = new StdOrdinalRules(0, (AnonymousClass1) null);

    static {
        HashMap hashMap = new HashMap(140);
        CARDINAL_MAP = hashMap;
        HashMap hashMap2 = new HashMap();
        fillC(hashMap2, "bm bo dz id ig ii in ja jbo jv jw kde kea km ko lkt", -1);
        fillC(hashMap2, "lo ms my nqo root sah ses sg th to vi wo yo zh", -1);
        fillC(hashMap2, "pt_PT", 0);
        fillC(hashMap2, "am as bn fa gu hi kn zu", 1);
        fillC(hashMap2, "ff fr hy kab pt", 1);
        fillC(hashMap2, "si", 1);
        fillC(hashMap2, "ak bh guw ln mg nso pa ti wa", 1);
        fillC(hashMap2, "tzm", 2);
        fillC(hashMap2, "is", 3);
        fillC(hashMap2, "mk", 4);
        fillC(hashMap2, "ceb fil tl", 5);
        fillC(hashMap2, "lv prg", 6);
        fillC(hashMap2, "lag ksh", 7);
        fillC(hashMap2, "iu naq se sma smi smj smn sms", 8);
        fillC(hashMap2, "shi", 9);
        fillC(hashMap2, "mo ro", 10);
        fillC(hashMap2, "bs hr sh sr", 11);
        fillC(hashMap2, "gd", 12);
        fillC(hashMap2, "sl", 13);
        fillC(hashMap2, "he iw", 14);
        fillC(hashMap2, "cs sk", 15);
        fillC(hashMap2, "pl", 16);
        fillC(hashMap2, "be", 17);
        fillC(hashMap2, "lt", 18);
        fillC(hashMap2, "mt", 19);
        fillC(hashMap2, "ru uk", 17);
        fillC(hashMap2, "br", 20);
        fillC(hashMap2, "ga", 21);
        fillC(hashMap2, "gv", 22);
        fillC(hashMap2, "ar", 23);
        fillC(hashMap2, "cy", 24);
        fillC(hashMap2, "dsb hsb", 25);
        fillC(hashMap2, "kw", 26);
        hashMap.putAll(hashMap2);
        HashMap hashMap3 = new HashMap(140);
        ORDINAL_MAP = hashMap3;
        HashMap hashMap4 = new HashMap();
        fillO(hashMap4, "sv", 1);
        fillO(hashMap4, "fil fr ga hy lo mo ms ro tl vi", 2);
        fillO(hashMap4, "hu", 3);
        fillO(hashMap4, "ne", 4);
        fillO(hashMap4, "kk", 5);
        fillO(hashMap4, "it sc scn", 6);
        fillO(hashMap4, "ka", 7);
        fillO(hashMap4, "sq", 8);
        fillO(hashMap4, "en", 9);
        fillO(hashMap4, "mr", 10);
        fillO(hashMap4, "ca", 11);
        fillO(hashMap4, "mk", 12);
        fillO(hashMap4, "az", 13);
        fillO(hashMap4, "gu hi", 14);
        fillO(hashMap4, "as bn", 15);
        fillO(hashMap4, "cy", 16);
        fillO(hashMap4, "be", 17);
        fillO(hashMap4, "uk", 18);
        fillO(hashMap4, "tk", 19);
        fillO(hashMap4, "or", 20);
        fillO(hashMap4, "gd", 21);
        fillO(hashMap4, "kw", 22);
        hashMap3.putAll(hashMap4);
    }

    /* renamed from: net.time4j.i18n.DefaultPluralProviderSPI$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.i18n.DefaultPluralProviderSPI.AnonymousClass1.<clinit>():void");
        }
    }

    public PluralRules load(Locale locale, NumberType numberType) {
        Map<String, PluralRules> map;
        PluralRules pluralRules;
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$NumberType[numberType.ordinal()];
        if (i == 1) {
            map = CARDINAL_MAP;
            pluralRules = STD_CARDINALS;
        } else if (i == 2) {
            map = ORDINAL_MAP;
            pluralRules = STD_ORDINALS;
        } else {
            throw new UnsupportedOperationException(numberType.name());
        }
        PluralRules pluralRules2 = null;
        String country = locale.getCountry();
        if (!country.isEmpty()) {
            pluralRules2 = map.get(locale.getLanguage() + '_' + country);
        }
        if (pluralRules2 == null) {
            pluralRules2 = map.get(locale.getLanguage());
        }
        return pluralRules2 == null ? pluralRules : pluralRules2;
    }

    private static void fillC(Map<String, PluralRules> map, String str, int i) {
        for (String put : str.split(StringUtils.SPACE)) {
            map.put(put, new StdCardinalRules(i, (AnonymousClass1) null));
        }
    }

    private static void fillO(Map<String, PluralRules> map, String str, int i) {
        for (String put : str.split(StringUtils.SPACE)) {
            map.put(put, new StdOrdinalRules(i, (AnonymousClass1) null));
        }
    }

    private static class StdCardinalRules extends PluralRules {
        private final int id;

        /* synthetic */ StdCardinalRules(int i, AnonymousClass1 r2) {
            this(i);
        }

        private StdCardinalRules(int i) {
            this.id = i;
        }

        public PluralCategory getCategory(long j) {
            switch (this.id) {
                case 0:
                    return j == 1 ? PluralCategory.ONE : PluralCategory.OTHER;
                case 1:
                    return (j == 0 || j == 1) ? PluralCategory.ONE : PluralCategory.OTHER;
                case 2:
                    if (j == 0 || j == 1 || (j >= 11 && j <= 99)) {
                        return PluralCategory.ONE;
                    }
                    return PluralCategory.OTHER;
                case 3:
                    if (j % 10 != 1 || j % 100 == 11) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.ONE;
                case 4:
                    return (j % 10 != 1 || j % 100 == 11) ? PluralCategory.OTHER : PluralCategory.ONE;
                case 5:
                    if (j >= 1 && j <= 3) {
                        return PluralCategory.ONE;
                    }
                    long j2 = j % 10;
                    if (j2 == 4 || j2 == 6 || j2 == 9) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.ONE;
                case 6:
                    long j3 = j % 10;
                    if (j3 == 0) {
                        return PluralCategory.ZERO;
                    }
                    long j4 = j % 100;
                    if (j4 >= 11 && j4 <= 19) {
                        return PluralCategory.ZERO;
                    }
                    if (j3 == 1) {
                        return PluralCategory.ONE;
                    }
                    return PluralCategory.OTHER;
                case 7:
                    if (j == 0) {
                        return PluralCategory.ZERO;
                    }
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    return PluralCategory.OTHER;
                case 8:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2) {
                        return PluralCategory.TWO;
                    }
                    return PluralCategory.OTHER;
                case 9:
                    if (j == 0 || j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j < 2 || j > 10) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.FEW;
                case 10:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j == 0) {
                        return PluralCategory.FEW;
                    }
                    long j5 = j % 100;
                    if (j5 < 2 || j5 > 19) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.FEW;
                case 11:
                    long j6 = j % 100;
                    long j7 = j % 10;
                    if (j7 == 1 && j6 != 11) {
                        return PluralCategory.ONE;
                    }
                    if (j7 < 2 || j7 > 4 || j6 == 12 || j6 == 13 || j6 == 14) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.FEW;
                case 12:
                    if (j == 1 || j == 11) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2 || j == 12) {
                        return PluralCategory.TWO;
                    }
                    if ((j < 3 || j > 10) && (j < 13 || j > 19)) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.FEW;
                case 13:
                    long j8 = j % 100;
                    if (j8 == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j8 == 2) {
                        return PluralCategory.TWO;
                    }
                    if (j8 == 3 || j8 == 4) {
                        return PluralCategory.FEW;
                    }
                    return PluralCategory.OTHER;
                case 14:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2) {
                        return PluralCategory.TWO;
                    }
                    if (j < 11 || j % 10 != 0) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.MANY;
                case 15:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j < 2 || j > 4) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.FEW;
                case 16:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    long j9 = j % 10;
                    long j10 = j % 100;
                    if (j9 >= 2 && j9 <= 4 && j10 != 12 && j10 != 13 && j10 != 14) {
                        return PluralCategory.FEW;
                    }
                    if ((j9 < 0 || j9 > 1) && ((j9 < 5 || j9 > 9) && (j10 < 12 || j10 > 14))) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.MANY;
                case 17:
                    long j11 = j % 10;
                    long j12 = j % 100;
                    if (j11 == 1 && j12 != 11) {
                        return PluralCategory.ONE;
                    }
                    if (j11 >= 2 && j11 <= 4 && j12 != 12 && j12 != 13 && j12 != 14) {
                        return PluralCategory.FEW;
                    }
                    if (j11 == 0 || ((j11 >= 5 && j11 <= 9) || (j12 >= 11 && j12 <= 14))) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                case 18:
                    long j13 = j % 10;
                    long j14 = j % 100;
                    if (j13 == 1 && (j14 < 11 || j14 > 19)) {
                        return PluralCategory.ONE;
                    }
                    if (j13 < 2 || j13 > 9 || (j14 >= 11 && j14 <= 19)) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.FEW;
                case 19:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    long j15 = j % 100;
                    if (j == 0 || (j15 >= 2 && j15 <= 10)) {
                        return PluralCategory.FEW;
                    }
                    if (j15 < 11 || j15 > 19) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.MANY;
                case 20:
                    long j16 = j % 10;
                    long j17 = j % 100;
                    if (j16 == 1 && j17 != 11 && j17 != 71 && j17 != 91) {
                        return PluralCategory.ONE;
                    }
                    if (j16 == 2 && j17 != 12 && j17 != 72 && j17 != 92) {
                        return PluralCategory.TWO;
                    }
                    if ((j16 == 3 || j16 == 4 || j16 == 9) && ((j17 < 10 || j17 > 19) && ((j17 < 70 || j17 > 79) && (j17 < 90 || j17 > 99)))) {
                        return PluralCategory.FEW;
                    }
                    if (j == 0 || j % AnimationKt.MillisToNanos != 0) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.MANY;
                case 21:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2) {
                        return PluralCategory.TWO;
                    }
                    if (j >= 3 && j <= 6) {
                        return PluralCategory.FEW;
                    }
                    if (j < 7 || j > 10) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.MANY;
                case 22:
                    long j18 = j % 10;
                    long j19 = j % 100;
                    if (j18 == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j18 == 2) {
                        return PluralCategory.TWO;
                    }
                    if (j19 == 0 || j19 == 20 || j19 == 40 || j19 == 60 || j19 == 80) {
                        return PluralCategory.FEW;
                    }
                    return PluralCategory.OTHER;
                case 23:
                    if (j == 0) {
                        return PluralCategory.ZERO;
                    }
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2) {
                        return PluralCategory.TWO;
                    }
                    long j20 = j % 100;
                    if (j20 >= 3 && j20 <= 10) {
                        return PluralCategory.FEW;
                    }
                    if (j20 < 11 || j20 > 99) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.MANY;
                case 24:
                    if (j == 0) {
                        return PluralCategory.ZERO;
                    }
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2) {
                        return PluralCategory.TWO;
                    }
                    if (j == 3) {
                        return PluralCategory.FEW;
                    }
                    if (j == 6) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                case 25:
                    long j21 = j % 100;
                    if (j21 == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j21 == 2) {
                        return PluralCategory.TWO;
                    }
                    if (j21 == 3 || j21 == 4) {
                        return PluralCategory.FEW;
                    }
                    return PluralCategory.OTHER;
                case 26:
                    if (j == 0) {
                        return PluralCategory.ZERO;
                    }
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    long j22 = j % 100;
                    if (j22 == 2 || j22 == 22 || j22 == 42 || j22 == 62 || j22 == 82) {
                        return PluralCategory.TWO;
                    }
                    if (j22 == 3 || j22 == 23 || j22 == 43 || j22 == 63 || j22 == 83) {
                        return PluralCategory.FEW;
                    }
                    if (j22 == 1 || j22 == 21 || j22 == 41 || j22 == 61 || j22 == 81) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                default:
                    return PluralCategory.OTHER;
            }
        }

        public NumberType getNumberType() {
            return NumberType.CARDINALS;
        }
    }

    private static class StdOrdinalRules extends PluralRules {
        private final int id;

        /* synthetic */ StdOrdinalRules(int i, AnonymousClass1 r2) {
            this(i);
        }

        private StdOrdinalRules(int i) {
            this.id = i;
        }

        public PluralCategory getCategory(long j) {
            switch (this.id) {
                case 0:
                    return PluralCategory.OTHER;
                case 1:
                    long j2 = j % 10;
                    long j3 = j % 100;
                    if ((j2 != 1 && j2 != 2) || j3 == 11 || j3 == 12) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.ONE;
                case 2:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    return PluralCategory.OTHER;
                case 3:
                    if (j == 1 || j == 5) {
                        return PluralCategory.ONE;
                    }
                    return PluralCategory.OTHER;
                case 4:
                    if (j < 1 || j > 4) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.ONE;
                case 5:
                    long j4 = j % 10;
                    if (j4 == 6 || j4 == 9 || (j4 == 0 && j != 0)) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                case 6:
                    if (j == 8 || j == 11 || j == 80 || j == 800) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                case 7:
                    long j5 = j % 100;
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j == 0 || ((j5 >= 2 && j5 <= 20) || j5 == 40 || j5 == 60 || j5 == 80)) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                case 8:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j % 10 != 4 || j % 100 == 14) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.MANY;
                case 9:
                    long j6 = j % 10;
                    long j7 = j % 100;
                    if (j6 == 1 && j7 != 11) {
                        return PluralCategory.ONE;
                    }
                    if (j6 == 2 && j7 != 12) {
                        return PluralCategory.TWO;
                    }
                    if (j6 != 3 || j7 == 13) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.FEW;
                case 10:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2 || j == 3) {
                        return PluralCategory.TWO;
                    }
                    if (j == 4) {
                        return PluralCategory.FEW;
                    }
                    return PluralCategory.OTHER;
                case 11:
                    if (j == 1 || j == 3) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2) {
                        return PluralCategory.TWO;
                    }
                    if (j == 4) {
                        return PluralCategory.FEW;
                    }
                    return PluralCategory.OTHER;
                case 12:
                    long j8 = j % 10;
                    long j9 = j % 100;
                    if (j8 == 1 && j9 != 11) {
                        return PluralCategory.ONE;
                    }
                    if (j8 == 2 && j9 != 12) {
                        return PluralCategory.TWO;
                    }
                    if ((j8 != 7 && j8 != 8) || j9 == 17 || j9 == 18) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.MANY;
                case 13:
                    long j10 = j % 10;
                    long j11 = j % 100;
                    long j12 = j % 1000;
                    if (j10 == 1 || j10 == 2 || j10 == 5 || j10 == 7 || j10 == 8 || j11 == 20 || j11 == 50 || j11 == 70 || j11 == 80) {
                        return PluralCategory.ONE;
                    }
                    if (j10 == 3 || j10 == 4 || j12 == 100 || j12 == 200 || j12 == 300 || j12 == 400 || j12 == 500 || j12 == 600 || j12 == 700 || j12 == 800 || j12 == 900) {
                        return PluralCategory.FEW;
                    }
                    if (j == 0 || j10 == 6 || j11 == 40 || j11 == 60 || j11 == 90) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                case 14:
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2 || j == 3) {
                        return PluralCategory.TWO;
                    }
                    if (j == 4) {
                        return PluralCategory.FEW;
                    }
                    if (j == 6) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                case 15:
                    if (j == 1 || j == 5 || (j >= 7 && j <= 10)) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2 || j == 3) {
                        return PluralCategory.TWO;
                    }
                    if (j == 4) {
                        return PluralCategory.FEW;
                    }
                    if (j == 6) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                case 16:
                    if (j == 0 || (j >= 7 && j <= 9)) {
                        return PluralCategory.ZERO;
                    }
                    if (j == 1) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2) {
                        return PluralCategory.TWO;
                    }
                    if (j == 3 || j == 4) {
                        return PluralCategory.FEW;
                    }
                    if (j == 5 || j == 6) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                case 17:
                    long j13 = j % 10;
                    long j14 = j % 100;
                    if ((j13 != 2 && j13 != 3) || j14 == 12 || j14 == 13) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.FEW;
                case 18:
                    long j15 = j % 100;
                    if (j % 10 != 3 || j15 == 13) {
                        return PluralCategory.OTHER;
                    }
                    return PluralCategory.FEW;
                case 19:
                    long j16 = j % 10;
                    if (j16 == 6 || j16 == 9 || j == 10) {
                        return PluralCategory.FEW;
                    }
                    return PluralCategory.OTHER;
                case 20:
                    if (j == 1 || j == 5 || j == 7 || j == 8 || j == 9) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2 || j == 3) {
                        return PluralCategory.TWO;
                    }
                    if (j == 4) {
                        return PluralCategory.FEW;
                    }
                    if (j == 6) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                case 21:
                    if (j == 1 || j == 11) {
                        return PluralCategory.ONE;
                    }
                    if (j == 2 || j == 12) {
                        return PluralCategory.TWO;
                    }
                    if (j == 3 || j == 13) {
                        return PluralCategory.FEW;
                    }
                    return PluralCategory.OTHER;
                case 22:
                    long j17 = j % 100;
                    if ((j17 >= 1 && j17 <= 4) || ((j17 >= 21 && j17 <= 24) || ((j17 >= 41 && j17 <= 44) || ((j17 >= 61 && j17 <= 64) || (j17 >= 81 && j17 <= 84))))) {
                        return PluralCategory.ONE;
                    }
                    if (j17 == 5) {
                        return PluralCategory.MANY;
                    }
                    return PluralCategory.OTHER;
                default:
                    return PluralCategory.OTHER;
            }
        }

        public NumberType getNumberType() {
            return NumberType.ORDINALS;
        }
    }
}
