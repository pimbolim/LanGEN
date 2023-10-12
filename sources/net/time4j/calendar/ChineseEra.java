package net.time4j.calendar;

import java.util.Locale;
import net.time4j.engine.CalendarEra;
import net.time4j.format.TextWidth;

public enum ChineseEra implements CalendarEra {
    QING_SHUNZHI_1644_1662,
    QING_KANGXI_1662_1723,
    QING_YONGZHENG_1723_1736,
    QING_QIANLONG_1736_1796,
    QING_JIAQING_1796_1821,
    QING_DAOGUANG_1821_1851,
    QING_XIANFENG_1851_1862,
    QING_TONGZHI_1862_1875,
    QING_GUANGXU_1875_1909,
    QING_XUANTONG_1909_1912,
    YELLOW_EMPEROR;

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        String language = locale.getLanguage();
        switch (AnonymousClass1.$SwitchMap$net$time4j$calendar$ChineseEra[ordinal()]) {
            case 1:
                if (language.equals("zh")) {
                    return "順治";
                }
                return language.isEmpty() ? "Shunzhi" : "Shùnzhì";
            case 2:
                if (language.equals("zh")) {
                    return "康熙";
                }
                return language.isEmpty() ? "Kangxi" : "Kāngxī";
            case 3:
                if (language.equals("zh")) {
                    return "雍正";
                }
                return language.isEmpty() ? "Yongzheng" : "Yōngzhèng";
            case 4:
                if (language.equals("zh")) {
                    return "乾隆";
                }
                return language.isEmpty() ? "Qianlong" : "Qiánlóng";
            case 5:
                if (language.equals("zh")) {
                    return "嘉慶";
                }
                return language.isEmpty() ? "Jiaqing" : "Jiāqìng";
            case 6:
                if (language.equals("zh")) {
                    return "道光";
                }
                return language.isEmpty() ? "Daoguang" : "Dàoguāng";
            case 7:
                if (language.equals("zh")) {
                    return "咸豐";
                }
                return language.isEmpty() ? "Xianfeng" : "Xiánfēng";
            case 8:
                if (language.equals("zh")) {
                    return "同治";
                }
                return language.isEmpty() ? "Tongzhi" : "Tóngzhì";
            case 9:
                if (language.equals("zh")) {
                    return "光緒";
                }
                return language.isEmpty() ? "Guangxu" : "Guāngxù";
            case 10:
                if (language.equals("zh")) {
                    return "宣統";
                }
                return language.isEmpty() ? "Xuantong" : "Xuāntǒng";
            case 11:
                if (language.equals("zh")) {
                    return "黄帝紀年";
                }
                if (textWidth == TextWidth.WIDE) {
                    return language.isEmpty() ? "Anno Huangdi" : "Anno Huángdì";
                }
                if (textWidth == TextWidth.NARROW) {
                    return "H";
                }
                return language.isEmpty() ? "Huangdi" : "Huángdì";
            default:
                throw new UnsupportedOperationException("Not yet implemented: " + name());
        }
    }

    /* renamed from: net.time4j.calendar.ChineseEra$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$ChineseEra = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                net.time4j.calendar.ChineseEra[] r0 = net.time4j.calendar.ChineseEra.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$ChineseEra = r0
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.QING_SHUNZHI_1644_1662     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$ChineseEra     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.QING_KANGXI_1662_1723     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$calendar$ChineseEra     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.QING_YONGZHENG_1723_1736     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$calendar$ChineseEra     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.QING_QIANLONG_1736_1796     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$net$time4j$calendar$ChineseEra     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.QING_JIAQING_1796_1821     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$net$time4j$calendar$ChineseEra     // Catch:{ NoSuchFieldError -> 0x0049 }
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.QING_DAOGUANG_1821_1851     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$net$time4j$calendar$ChineseEra     // Catch:{ NoSuchFieldError -> 0x0054 }
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.QING_XIANFENG_1851_1862     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$net$time4j$calendar$ChineseEra     // Catch:{ NoSuchFieldError -> 0x0060 }
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.QING_TONGZHI_1862_1875     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$net$time4j$calendar$ChineseEra     // Catch:{ NoSuchFieldError -> 0x006c }
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.QING_GUANGXU_1875_1909     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$net$time4j$calendar$ChineseEra     // Catch:{ NoSuchFieldError -> 0x0078 }
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.QING_XUANTONG_1909_1912     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$net$time4j$calendar$ChineseEra     // Catch:{ NoSuchFieldError -> 0x0084 }
                net.time4j.calendar.ChineseEra r1 = net.time4j.calendar.ChineseEra.YELLOW_EMPEROR     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.ChineseEra.AnonymousClass1.<clinit>():void");
        }
    }

    public boolean isQingDynasty() {
        return ordinal() <= QING_XUANTONG_1909_1912.ordinal();
    }

    /* access modifiers changed from: package-private */
    public int getMinYearOfEra() {
        return this == YELLOW_EMPEROR ? 4343 : 1;
    }

    /* access modifiers changed from: package-private */
    public int getMaxYearOfEra() {
        switch (AnonymousClass1.$SwitchMap$net$time4j$calendar$ChineseEra[ordinal()]) {
            case 1:
                return 18;
            case 2:
                return 61;
            case 3:
                return 13;
            case 4:
                return 60;
            case 5:
                return 25;
            case 6:
                return 30;
            case 7:
                return 11;
            case 8:
                return 13;
            case 9:
                return 34;
            case 10:
                return 3;
            case 11:
                return 5697;
            default:
                throw new UnsupportedOperationException("Not yet implemented: " + name());
        }
    }

    /* access modifiers changed from: package-private */
    public int getStartAsGregorianYear() {
        switch (AnonymousClass1.$SwitchMap$net$time4j$calendar$ChineseEra[ordinal()]) {
            case 1:
                return 1644;
            case 2:
                return 1662;
            case 3:
                return 1723;
            case 4:
                return 1736;
            case 5:
                return 1796;
            case 6:
                return 1821;
            case 7:
                return 1851;
            case 8:
                return 1862;
            case 9:
                return 1875;
            case 10:
                return 1909;
            case 11:
                return -2697;
            default:
                throw new UnsupportedOperationException("Not yet implemented: " + name());
        }
    }
}
