package net.time4j.calendar;

import com.braintreepayments.api.models.ThreeDSecureRequest;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.EpochDays;
import net.time4j.format.expert.Iso8601Format;
import org.apache.commons.lang3.StringUtils;

final class AstronomicalHijriData implements EraYearMonthDaySystem<HijriCalendar> {
    static final AstronomicalHijriData UMALQURA;
    private final int adjustment;
    private final long[] firstOfMonth;
    private final int[] lengthOfMonth;
    private final long maxUTC;
    private final int maxYear;
    private final long minUTC;
    private final int minYear;
    private final String variant;
    private final String version;

    static {
        try {
            UMALQURA = new AstronomicalHijriData(HijriCalendar.VARIANT_UMALQURA);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    AstronomicalHijriData(HijriData hijriData) {
        this.variant = "islamic-" + hijriData.name();
        int i = 0;
        this.adjustment = 0;
        this.version = hijriData.version();
        int minimumYear = hijriData.minimumYear();
        this.minYear = minimumYear;
        int maximumYear = hijriData.maximumYear();
        this.maxYear = maximumYear;
        if (maximumYear < minimumYear) {
            throw new IllegalArgumentException("Maximum year before minimum year.");
        } else if (!hijriData.name().startsWith("islamic")) {
            this.minUTC = hijriData.firstGregorianDate().getDaysSinceEpochUTC();
            int i2 = ((maximumYear - minimumYear) + 1) * 12;
            this.lengthOfMonth = new int[i2];
            this.firstOfMonth = new long[i2];
            long j = 0;
            while (minimumYear <= this.maxYear) {
                for (int i3 = 1; i3 <= 12; i3++) {
                    int lengthOfMonth2 = hijriData.lengthOfMonth(minimumYear, i3);
                    this.lengthOfMonth[i] = lengthOfMonth2;
                    this.firstOfMonth[i] = this.minUTC + j;
                    j += (long) lengthOfMonth2;
                    i++;
                }
                minimumYear++;
            }
            this.maxUTC = (this.minUTC + j) - 1;
        } else {
            throw new IllegalArgumentException("Name must not start with \"islamic\".");
        }
    }

    AstronomicalHijriData(String str) throws IOException {
        InputStream inputStream;
        Class<AstronomicalHijriData> cls = AstronomicalHijriData.class;
        HijriAdjustment from = HijriAdjustment.from(str);
        this.variant = str;
        String baseVariant = from.getBaseVariant();
        this.adjustment = from.getValue();
        String str2 = "data/" + baseVariant.replace(SignatureVisitor.SUPER, '_') + ".data";
        InputStream load = ResourceLoader.getInstance().load(ResourceLoader.getInstance().locate("calendar", cls, str2), true);
        load = load == null ? ResourceLoader.getInstance().load(cls, str2, true) : load;
        try {
            Properties properties = new Properties();
            properties.load(load);
            String property = properties.getProperty("type");
            if (baseVariant.equals(property)) {
                this.version = properties.getProperty("version", "1.0");
                long longValue = ((Long) Iso8601Format.EXTENDED_CALENDAR_DATE.parse(properties.getProperty("iso-start", "")).get(EpochDays.UTC)).longValue();
                this.minUTC = longValue;
                int parseInt = Integer.parseInt(properties.getProperty("min", ThreeDSecureRequest.VERSION_1));
                this.minYear = parseInt;
                int parseInt2 = Integer.parseInt(properties.getProperty("max", "0"));
                this.maxYear = parseInt2;
                int i = ((parseInt2 - parseInt) + 1) * 12;
                int[] iArr = new int[i];
                long[] jArr = new long[i];
                int i2 = 0;
                while (true) {
                    if (parseInt > parseInt2) {
                        inputStream = load;
                        break;
                    }
                    String property2 = properties.getProperty(String.valueOf(parseInt));
                    if (property2 != null) {
                        String[] split = property2.split(StringUtils.SPACE);
                        int i3 = 0;
                        while (i3 < Math.min(split.length, 12)) {
                            iArr[i2] = Integer.parseInt(split[i3]);
                            jArr[i2] = longValue;
                            longValue += (long) iArr[i2];
                            i2++;
                            i3++;
                            load = load;
                            parseInt2 = parseInt2;
                        }
                        inputStream = load;
                        int i4 = parseInt2;
                        try {
                            if (split.length < 12) {
                                int[] iArr2 = new int[i2];
                                long[] jArr2 = new long[i2];
                                System.arraycopy(iArr, 0, iArr2, 0, i2);
                                System.arraycopy(jArr, 0, jArr2, 0, i2);
                                iArr = iArr2;
                                jArr = jArr2;
                                break;
                            }
                            parseInt++;
                            load = inputStream;
                            parseInt2 = i4;
                        } catch (ParseException e) {
                            e = e;
                            throw new IOException("Wrong file format: " + str2, e);
                        } catch (NumberFormatException e2) {
                            e = e2;
                            throw new IOException("Wrong file format: " + str2, e);
                        }
                    } else {
                        InputStream inputStream2 = load;
                        throw new IOException("Wrong file format: " + str2 + " (missing year=" + parseInt + ")");
                    }
                }
                this.maxUTC = longValue - 1;
                this.lengthOfMonth = iArr;
                this.firstOfMonth = jArr;
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace(System.err);
                }
            } else {
                inputStream = load;
                throw new IOException("Wrong hijri variant: expected=" + baseVariant + ", found=" + property);
            }
        } catch (ParseException e4) {
            e = e4;
            InputStream inputStream3 = load;
            throw new IOException("Wrong file format: " + str2, e);
        } catch (NumberFormatException e5) {
            e = e5;
            inputStream = load;
            throw new IOException("Wrong file format: " + str2, e);
        } catch (Throwable th) {
            th = th;
            Throwable th2 = th;
            inputStream.close();
            throw th2;
        }
    }

    public HijriCalendar transform(long j) {
        long safeAdd = MathUtils.safeAdd(j, (long) this.adjustment);
        int search = search(safeAdd, this.firstOfMonth);
        if (search >= 0) {
            long[] jArr = this.firstOfMonth;
            if (search < jArr.length - 1 || jArr[search] + ((long) this.lengthOfMonth[search]) > safeAdd) {
                int i = (int) ((safeAdd - jArr[search]) + 1);
                return HijriCalendar.of(this.variant, (search / 12) + this.minYear, (search % 12) + 1, i);
            }
        }
        throw new IllegalArgumentException("Out of range: " + j);
    }

    public long transform(HijriCalendar hijriCalendar) {
        if (hijriCalendar.getVariant().equals(this.variant)) {
            return MathUtils.safeSubtract((this.firstOfMonth[(((hijriCalendar.getYear() - this.minYear) * 12) + hijriCalendar.getMonth().getValue()) - 1] + ((long) hijriCalendar.getDayOfMonth())) - 1, (long) this.adjustment);
        }
        throw new IllegalArgumentException("Given date does not belong to this calendar system: " + hijriCalendar + " (calendar variants are different).");
    }

    public long getMinimumSinceUTC() {
        return MathUtils.safeSubtract(this.minUTC, (long) this.adjustment);
    }

    public long getMaximumSinceUTC() {
        return MathUtils.safeSubtract(this.maxUTC, (long) this.adjustment);
    }

    public List<CalendarEra> getEras() {
        return Collections.singletonList(HijriEra.ANNO_HEGIRAE);
    }

    public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
        int i4;
        if (calendarEra != HijriEra.ANNO_HEGIRAE || i < (i4 = this.minYear) || i > this.maxYear || i2 < 1 || i2 > 12 || i3 < 1 || (((i - i4) * 12) + i2) - 1 >= this.lengthOfMonth.length || i3 > getLengthOfMonth(calendarEra, i, i2)) {
            return false;
        }
        return true;
    }

    public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
        if (calendarEra == HijriEra.ANNO_HEGIRAE) {
            int i3 = (((i - this.minYear) * 12) + i2) - 1;
            if (i3 >= 0) {
                int[] iArr = this.lengthOfMonth;
                if (i3 < iArr.length) {
                    return iArr[i3];
                }
            }
            throw new IllegalArgumentException("Out of bounds: year=" + i + ", month=" + i2);
        }
        throw new IllegalArgumentException("Wrong era: " + calendarEra);
    }

    public int getLengthOfYear(CalendarEra calendarEra, int i) {
        if (calendarEra != HijriEra.ANNO_HEGIRAE) {
            throw new IllegalArgumentException("Wrong era: " + calendarEra);
        } else if (i < this.minYear || i > this.maxYear) {
            throw new IllegalArgumentException("Out of bounds: yearOfEra=" + i);
        } else {
            int i2 = 0;
            int i3 = 1;
            while (i3 <= 12) {
                int i4 = (((i - this.minYear) * 12) + i3) - 1;
                int[] iArr = this.lengthOfMonth;
                if (i4 < iArr.length) {
                    i2 += iArr[i4];
                    i3++;
                } else {
                    throw new IllegalArgumentException("Year range is not fully covered by underlying data: " + i);
                }
            }
            return i2;
        }
    }

    /* access modifiers changed from: package-private */
    public String getVersion() {
        return this.version;
    }

    private static int search(long j, long[] jArr) {
        int length = jArr.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) / 2;
            if (jArr[i2] <= j) {
                i = i2 + 1;
            } else {
                length = i2 - 1;
            }
        }
        return i - 1;
    }
}
