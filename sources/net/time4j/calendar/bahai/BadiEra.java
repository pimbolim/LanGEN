package net.time4j.calendar.bahai;

import androidx.exifinterface.media.ExifInterface;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.util.Locale;
import net.time4j.engine.CalendarEra;
import net.time4j.format.CalendarText;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextWidth;

public enum BadiEra implements CalendarEra {
    BAHAI;

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return accessor(locale, textWidth).print(this);
    }

    /* renamed from: net.time4j.calendar.bahai.BadiEra$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$TextWidth = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.time4j.format.TextWidth[] r0 = net.time4j.format.TextWidth.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$TextWidth = r0
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.WIDE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.ABBREVIATED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.SHORT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.NARROW     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.bahai.BadiEra.AnonymousClass1.<clinit>():void");
        }
    }

    static TextAccessor accessor(Locale locale, TextWidth textWidth) {
        String str;
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
        if (i == 1) {
            str = "w";
        } else if (i == 2 || i == 3) {
            str = "a";
        } else if (i == 4) {
            str = JWKParameterNames.RSA_MODULUS;
        } else {
            throw new UnsupportedOperationException(textWidth.name());
        }
        return CalendarText.getInstance("bahai", locale).getTextForms(ExifInterface.LONGITUDE_EAST, BadiEra.class, str);
    }
}
