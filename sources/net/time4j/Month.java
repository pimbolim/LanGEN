package net.time4j;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoOperator;
import net.time4j.format.CalendarText;
import net.time4j.format.OutputContext;
import net.time4j.format.TextWidth;

public enum Month implements ChronoCondition<GregorianDate>, ChronoOperator<PlainDate> {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    
    private static final Month[] ENUMS = null;

    static {
        ENUMS = values();
    }

    public static Month valueOf(int i) {
        if (i >= 1 && i <= 12) {
            return ENUMS[i - 1];
        }
        throw new IllegalArgumentException("Out of range: " + i);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public Quarter getQuarterOfYear() {
        switch (AnonymousClass1.$SwitchMap$net$time4j$Month[ordinal()]) {
            case 1:
            case 2:
            case 3:
                return Quarter.Q1;
            case 4:
            case 5:
            case 6:
                return Quarter.Q2;
            case 7:
            case 8:
            case 9:
                return Quarter.Q3;
            default:
                return Quarter.Q4;
        }
    }

    /* renamed from: net.time4j.Month$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$Month = null;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$Quarter = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0085 */
        static {
            /*
                net.time4j.Quarter[] r0 = net.time4j.Quarter.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$Quarter = r0
                r1 = 1
                net.time4j.Quarter r2 = net.time4j.Quarter.Q1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$net$time4j$Quarter     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.Quarter r3 = net.time4j.Quarter.Q2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$net$time4j$Quarter     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.Quarter r4 = net.time4j.Quarter.Q3     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                net.time4j.Month[] r3 = net.time4j.Month.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$net$time4j$Month = r3
                net.time4j.Month r4 = net.time4j.Month.JANUARY     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$net$time4j$Month     // Catch:{ NoSuchFieldError -> 0x0043 }
                net.time4j.Month r3 = net.time4j.Month.FEBRUARY     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$net$time4j$Month     // Catch:{ NoSuchFieldError -> 0x004d }
                net.time4j.Month r1 = net.time4j.Month.MARCH     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = $SwitchMap$net$time4j$Month     // Catch:{ NoSuchFieldError -> 0x0058 }
                net.time4j.Month r1 = net.time4j.Month.APRIL     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$net$time4j$Month     // Catch:{ NoSuchFieldError -> 0x0063 }
                net.time4j.Month r1 = net.time4j.Month.MAY     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r0 = $SwitchMap$net$time4j$Month     // Catch:{ NoSuchFieldError -> 0x006e }
                net.time4j.Month r1 = net.time4j.Month.JUNE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$net$time4j$Month     // Catch:{ NoSuchFieldError -> 0x0079 }
                net.time4j.Month r1 = net.time4j.Month.JULY     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = $SwitchMap$net$time4j$Month     // Catch:{ NoSuchFieldError -> 0x0085 }
                net.time4j.Month r1 = net.time4j.Month.AUGUST     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = $SwitchMap$net$time4j$Month     // Catch:{ NoSuchFieldError -> 0x0091 }
                net.time4j.Month r1 = net.time4j.Month.SEPTEMBER     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.Month.AnonymousClass1.<clinit>():void");
        }
    }

    public static Month atStartOfQuarterYear(Quarter quarter) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$Quarter[quarter.ordinal()];
        if (i == 1) {
            return JANUARY;
        }
        if (i == 2) {
            return APRIL;
        }
        if (i != 3) {
            return OCTOBER;
        }
        return JULY;
    }

    public static Month atEndOfQuarterYear(Quarter quarter) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$Quarter[quarter.ordinal()];
        if (i == 1) {
            return MARCH;
        }
        if (i == 2) {
            return JUNE;
        }
        if (i != 3) {
            return DECEMBER;
        }
        return SEPTEMBER;
    }

    public int getLength(int i) {
        return GregorianMath.getLengthOfMonth(i, getValue());
    }

    public Month next() {
        return roll(1);
    }

    public Month previous() {
        return roll(-1);
    }

    public Month roll(int i) {
        return valueOf(((ordinal() + ((i % 12) + 12)) % 12) + 1);
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE, OutputContext.FORMAT);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return CalendarText.getIsoInstance(locale).getStdMonths(textWidth, outputContext).print(this);
    }

    public static Month parse(CharSequence charSequence, Locale locale, TextWidth textWidth, OutputContext outputContext) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Month month = (Month) CalendarText.getIsoInstance(locale).getStdMonths(textWidth, outputContext).parse(charSequence, parsePosition, Month.class);
        if (month != null) {
            return month;
        }
        throw new ParseException("Cannot parse: " + charSequence, parsePosition.getErrorIndex());
    }

    public boolean test(GregorianDate gregorianDate) {
        return gregorianDate.getMonth() == getValue();
    }

    public PlainDate apply(PlainDate plainDate) {
        return (PlainDate) plainDate.with(PlainDate.MONTH_OF_YEAR, this);
    }
}
