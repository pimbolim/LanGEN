package net.time4j.calendar;

import com.drew.metadata.exif.makernotes.SanyoMakernoteDirectory;
import java.util.Locale;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarEra;
import net.time4j.format.CalendarText;
import net.time4j.format.TextWidth;

public enum ThaiSolarEra implements CalendarEra {
    RATTANAKOSIN,
    BUDDHIST;

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getInstance("buddhist", locale).getEras(textWidth).print(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (r0.getMonth() < 4) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        if (r0.getMonth() < 4) goto L_0x001b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getYear(net.time4j.engine.CalendarDate r5) {
        /*
            r4 = this;
            long r0 = r5.getDaysSinceEpochUTC()
            net.time4j.engine.EpochDays r2 = net.time4j.engine.EpochDays.UTC
            net.time4j.PlainDate r0 = net.time4j.PlainDate.of((long) r0, (net.time4j.engine.EpochDays) r2)
            net.time4j.calendar.ThaiSolarEra r1 = RATTANAKOSIN
            r2 = 4
            if (r4 != r1) goto L_0x001e
            int r1 = r0.getYear()
            int r1 = r1 + -1781
            int r0 = r0.getMonth()
            if (r0 >= r2) goto L_0x002f
        L_0x001b:
            int r1 = r1 + -1
            goto L_0x002f
        L_0x001e:
            int r1 = r0.getYear()
            int r1 = r1 + 543
            r3 = 2484(0x9b4, float:3.481E-42)
            if (r1 >= r3) goto L_0x002f
            int r0 = r0.getMonth()
            if (r0 >= r2) goto L_0x002f
            goto L_0x001b
        L_0x002f:
            r0 = 1
            if (r1 < r0) goto L_0x0033
            return r1
        L_0x0033:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Out of range: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.ThaiSolarEra.getYear(net.time4j.engine.CalendarDate):int");
    }

    /* access modifiers changed from: package-private */
    public int toIsoYear(int i, int i2) {
        if (i < 1) {
            throw new IllegalArgumentException("Out of bounds: " + i);
        } else if (this == RATTANAKOSIN) {
            int safeAdd = MathUtils.safeAdd(i, 1781);
            if (i2 < 4) {
                return MathUtils.safeAdd(safeAdd, 1);
            }
            return safeAdd;
        } else {
            int safeSubtract = MathUtils.safeSubtract(i, (int) SanyoMakernoteDirectory.TAG_SCENE_SELECT);
            if (i2 >= 4) {
                return safeSubtract;
            }
            if (safeSubtract == 1940) {
                throw new IllegalArgumentException("Buddhist year 2483 does not know month: " + i2);
            } else if (safeSubtract < 1940) {
                return MathUtils.safeAdd(safeSubtract, 1);
            } else {
                return safeSubtract;
            }
        }
    }
}
