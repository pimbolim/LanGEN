package net.time4j.calendar.bahai;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import net.time4j.GeneralTimestamp;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.calendar.StdCalendarElement;
import net.time4j.calendar.astro.SolarTime;
import net.time4j.calendar.astro.StdSolarCalculator;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.IntElementRule;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayElement;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;

@CalendarType("bahai")
public final class BadiCalendar extends Calendrical<Unit, BadiCalendar> {
    @FormattableElement(dynamic = true, format = "A")
    public static final ChronoElement<BadiIntercalaryDays> AYYAM_I_HA;
    /* access modifiers changed from: private */
    public static final CalendarSystem<BadiCalendar> CALSYS;
    @FormattableElement(alt = "d", dynamic = true, format = "D")
    public static final StdCalendarElement<Integer, BadiCalendar> DAY_OF_DIVISION;
    private static final int DAY_OF_DIVISION_INDEX = 3;
    @FormattableElement(dynamic = true, format = "E")
    public static final StdCalendarElement<Weekday, BadiCalendar> DAY_OF_WEEK;
    public static final StdCalendarElement<Integer, BadiCalendar> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 4;
    /* access modifiers changed from: private */
    public static final TimeAxis<Unit, BadiCalendar> ENGINE;
    @FormattableElement(dynamic = true, format = "G")
    public static final ChronoElement<BadiEra> ERA;
    @FormattableElement(alt = "k", dynamic = true, format = "K")
    public static final ChronoElement<Integer> KULL_I_SHAI;
    private static final int KULL_I_SHAI_INDEX = 0;
    @FormattableElement(alt = "m", dynamic = true, format = "M")
    public static final StdCalendarElement<BadiMonth, BadiCalendar> MONTH_OF_YEAR;
    /* access modifiers changed from: private */
    public static final int[] NEWROZ = {15785, 16150, 16515, 16881, 17246, 17611, 17976, 18342, 18707, 19072, 19437, 19803, 20168, 20533, 20898, 21263, 21629, 21994, 22359, 22724, 23090, 23455, 23820, 24185, 24551, 24916, 25281, 25646, 26012, 26377, 26742, 27107, 27473, 27838, 28203, 28568, 28934, 29299, 29664, 30029, 30395, 30760, 31125, 31490, 31855, 32221, 32586, 32951, 33316, 33682, 34047, 34412, 34777, 35143, 35508, 35873, 36238, 36604, 36969, 37334, 37699, 38065, 38430, 38795, 39160, 39526, 39891, 40256, 40621, 40987, 41352, 41717, 42082, 42448, 42813, 43178, 43543, 43908, 44274, 44639, 45004, 45369, 45735, 46100, 46465, 46830, 47196, 47561, 47926, 48291, 48657, 49022, 49387, 49752, 50118, 50483, 50848, 51213, 51579, 51944, 52309, 52674, 53040, 53405, CanonMakernoteDirectory.AFInfo.TAG_AF_POINTS_IN_FOCUS, 54135, 54501, 54866, 55231, 55596, 55961, 56327, 56692, 57057, 57422, 57788, 58153, 58518, 58883, 59249, 59614, 59979, 60344, 60710, 61075, 61440, 61805, 62171, 62536, 62901, 63266, 63632, 63997, 64362, 64727, 65093, 65458, 65823, 66188, 66554, 66919, 67284, 67649, 68014, 68380, 68745, 69110, 69475, 69841, 70206, 70571, 70936, 71302, 71667, 72032, 72397, 72763, 73128, 73493, 73858, 74224, 74589, 74954, 75319, 75685, 76050, 76415, 76780, 77146, 77511, 77876, 78241, 78607, 78972, 79337, 79702, 80067, 80433, 80798, 81163, 81528, 81894, 82259, 82624, 82989, 83355, 83720, 84085, 84450, 84816, 85181, 85546, 85911, 86277, 86642, 87007, 87372, 87738, 88103, 88468, 88833, 89199, 89564, 89929, 90294, 90660, 91025, 91390, 91755, 92120, 92486, 92851, 93216, 93581, 93947, 94312, 94677, 95042, 95408, 95773, 96138, 96503, 96869, 97234, 97599, 97964, 98330, 98695, 99060, 99425, 99791, 100156, 100521, 100886, 101252, 101617, 101982, 102347, 102713, 103078, 103443, 103808, 104173, 104539, 104904, 105269, 105634, 106000, 106365, 106730, 107095, 107461, 107826, 108191, 108556, 108922, 109287, 109652, 110017, 110383, 110748, 111113, 111478, 111844, 112209, 112574, 112939, 113305, 113670, 114035, 114400, 114766, 115131, 115496, 115861, 116226, 116592, 116957, 117322, 117687, 118053, 118418, 118783, 119148, 119514, 119879, 120244, 120609, 120975, 121340, 121705, 122070, 122436, 122801, 123166, 123531, 123897, 124262, 124627, 124992, 125358, 125723, 126088, 126453, 126819, 127184, 127549, 127914, 128279, 128645, 129010, 129375, 129740, 130106, 130471, 130836, 131201, 131567, 131932, 132297, 132662, 133028, 133393, 133758, 134123, 134489, 134854, 135219, 135584, 135950, 136315, 136680, 137045, 137411, 137776, 138141, 138506, 138872, 139237, 139602, 139967, 140332, 140698, 141063, 141428, 141793, 142159, 142524, 142889, 143254, 143620, 143985, 144350, 144715, 145081, 145446, 145811, 146176, 146542, 146907, 147272, 147637, 148003, 148368, 148733, 149098, 149464, 149829, 150194, 150559, 150924, 151290, 151655, 152020, 152385, 152751, 153116, 153481, 153846, 154212, 154577, 154942, 155307, 155673, 156038, 156403, 156768, 157134, 157499, 157864, 158229, 158595, 158960, 159325, 159690, 160056, 160421, 160786, 161151, 161517, 161882, 162247, 162612, 162978, 163343, 163708, 164073, 164438, 164804, 165169, 165534, 165899, 166265, 166630, 166995, 167360, 167726, 168091, 168456, 168821, 169187, 169552, 169917, 170282, 170648, 171013, 171378, 171743, 172109, 172474, 172839, 173204, 173570, 173935, 174300, 174665, 175031, 175396, 175761, 176126, 176491, 176857, 177222, 177587, 177952, 178318, 178683, 179048, 179413, 179779, 180144, 180509, 180874, 181240, 181605, 181970, 182335, 182701, 183066, 183431, 183796, 184162, 184527, 184892, 185257, 185623, 185988, 186353, 186718, 187084, 187449, 187814, 188179, 188544, 188910, 189275, 189640, 190005, 190371, 190736, 191101, 191466, 191832, 192197, 192562, 192927, 193293, 193658, 194023, 194388, 194754, 195119, 195484, 195849, 196215, 196580, 196945, 197310, 197676, 198041, 198406, 198771, 199136, 199502, 199867, 200232, 200597, 200963, 201328, 201693, 202058, 202424, 202789, 203154, 203519, 203885, 204250, 204615, 204980, 205346, 205711, 206076, 206441, 206807, 207172, 207537, 207902, 208268, 208633, 208998, 209363, 209729, 210094, 210459, 210824, 211189, 211555, 211920, 212285, 212650, 213016, 213381, 213746, 214111, 214477, 214842, 215207, 215572, 215938, 216303, 216668, 217033, 217399, 217764, 218129, 218494, 218860, 219225, 219590, 219955, 220321, 220686, 221051, 221416, 221782, 222147, 222512, 222877, 223242, 223608, 223973, 224338, 224703, 225069, 225434, 225799, 226164, 226530, 226895, 227260, 227625, 227991, 228356, 228721, 229086, 229452, 229817, 230182, 230547, 230913, 231278, 231643, 232008, 232374, 232739, 233104, 233469, 233835, 234200, 234565, 234930, 235295, 235661, 236026, 236391, 236756, 237122, 237487, 237852, 238217, 238583, 238948, 239313, 239678, 240044, 240409, 240774, 241139, 241505, 241870, 242235, 242600, 242966, 243331, 243696, 244061, 244427, 244792, 245157, 245522, 245888, 246253, 246618, 246983, 247348, 247714, 248079, 248444, 248809, 249175, 249540, 249905, 250270, 250636, 251001, 251366, 251731, 252097, 252462, 252827, 253192, 253558, 253923, 254288, 254653, 255019, 255384, 255749, 256114, 256480, 256845, 257210, 257575, 257941, 258306, 258671, 259036, 259401, 259767, 260132, 260497, 260862, 261228, 261593, 261958, 262323, 262689, 263054, 263419, 263784, 264150, 264515, 264880, 265245, 265611, 265976, 266341, 266706, 267072, 267437, 267802, 268167, 268533, 268898, 269263, 269628, 269994, 270359, 270724, 271089, 271454, 271820, 272185, 272550, 272915, 273281, 273646, 274011, 274376, 274742, 275107, 275472, 275837, 276203, 276568, 276933, 277298, 277664, 278029, 278394, 278759, 279125, 279490, 279855, 280220, 280586, 280951, 281316, 281681, 282047, 282412, 282777, 283142, 283507, 283873, 284238, 284603, 284968, 285334, 285699, 286064, 286429, 286795, 287160, 287525, 287890, 288256, 288621, 288986, 289351, 289717, 290082, 290447, 290812, 291178, 291543, 291908, 292273, 292639, 293004, 293369, 293734, 294100, 294465, 294830, 295195, 295560, 295926, 296291, 296656, 297021, 297387, 297752, 298117, 298482, 298848, 299213, 299578, 299943, 300309, 300674, 301039, 301404, 301770, 302135, 302500, 302865, 303231, 303596, 303961, 304326, 304692, 305057, 305422, 305787, 306153, 306518, 306883, 307248, 307613, 307979, 308344, 308709, 309074, 309440, 309805, 310170, 310535, 310901, 311266, 311631, 311996, 312362, 312727, 313092, 313457, 313823, 314188, 314553, 314918, 315284, 315649, 316014, 316379, 316745, 317110, 317475, 317840, 318206, 318571, 318936, 319301, 319666, 320032, 320397, 320762, 321127, 321493, 321858, 322223, 322588, 322954, 323319, 323684, 324049, 324415, 324780, 325145, 325510, 325876, 326241, 326606, 326971, 327337, 327702, 328067, 328432, 328798, 329163, 329528, 329893, 330259, 330624, 330989, 331354, 331719, 332085, 332450, 332815, 333180, 333546, 333911, 334276, 334641, 335007, 335372, 335737, 336102, 336468, 336833, 337198, 337563, 337929, 338294, 338659, 339024, 339390, 339755, 340120, 340485, 340851, 341216, 341581, 341946, 342312, 342677, 343042, 343407, 343772, 344138, 344503, 344868, 345233, 345599, 345964, 346329, 346694, 347060, 347425, 347790, 348155, 348521, 348886};
    /* access modifiers changed from: private */
    public static final SolarTime TEHERAN = SolarTime.ofLocation().easternLongitude(51, 25, 0.0d).northernLatitude(35, 42, 0.0d).usingCalculator((SolarTime.Calculator) StdSolarCalculator.TIME4J).build();
    public static final AttributeKey<FormattedContent> TEXT_CONTENT_ATTRIBUTE = Attributes.createKey("FORMATTED_CONTENT", FormattedContent.class);
    @FormattableElement(alt = "v", dynamic = true, format = "V")
    public static final StdCalendarElement<Integer, BadiCalendar> VAHID;
    private static final int VAHID_INDEX = 1;
    private static final int YEAR_INDEX = 2;
    @FormattableElement(alt = "y", dynamic = true, format = "Y")
    public static final StdCalendarElement<Integer, BadiCalendar> YEAR_OF_ERA;
    @FormattableElement(alt = "x", dynamic = true, format = "X")
    public static final TextElement<Integer> YEAR_OF_VAHID;
    private static final int YOE_INDEX = 5;
    private static final long serialVersionUID = 7091925253640345123L;
    /* access modifiers changed from: private */
    public final transient int cycle;
    /* access modifiers changed from: private */
    public final transient int day;
    /* access modifiers changed from: private */
    public final transient int division;
    /* access modifiers changed from: private */
    public final transient int major;
    /* access modifiers changed from: private */
    public final transient int year;

    private static int getRelatedGregorianYear(int i, int i2, int i3) {
        return ((i - 1) * 361) + ((i2 - 1) * 19) + i3 + 1843;
    }

    /* access modifiers changed from: protected */
    public BadiCalendar getContext() {
        return this;
    }

    static {
        Class<BadiCalendar> cls = BadiCalendar.class;
        AnonymousClass1 r1 = new StdEnumDateElement<BadiEra, BadiCalendar>("ERA", cls, BadiEra.class, 'G') {
            /* access modifiers changed from: protected */
            public TextAccessor accessor(AttributeQuery attributeQuery, OutputContext outputContext, boolean z) {
                return BadiEra.accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE));
            }
        };
        ERA = r1;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("YEAR_OF_ERA", BadiCalendar.class, 1, PhotoshopDirectory.TAG_PRINT_STYLE, 'Y');
        YEAR_OF_ERA = stdIntegerDateElement;
        AnonymousClass2 r11 = new StdIntegerDateElement<BadiCalendar>("KULL_I_SHAI", BadiCalendar.class, 1, 3, 'K') {
            public String getDisplayName(Locale locale) {
                return CalendarText.getInstance("bahai", locale).getTextForms().get("K");
            }
        };
        KULL_I_SHAI = r11;
        AnonymousClass3 r4 = new StdIntegerDateElement<BadiCalendar>("VAHID", BadiCalendar.class, 1, 19, 'V') {
            public String getDisplayName(Locale locale) {
                return CalendarText.getInstance("bahai", locale).getTextForms().get(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            }
        };
        VAHID = r4;
        YOV yov = YOV.SINGLETON;
        YEAR_OF_VAHID = yov;
        MonthElement monthElement = MonthElement.SINGLETON;
        MONTH_OF_YEAR = monthElement;
        IntercalaryAccess intercalaryAccess = IntercalaryAccess.SINGLETON;
        AYYAM_I_HA = intercalaryAccess;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DAY_OF_DIVISION", BadiCalendar.class, 1, 19, 'D');
        DAY_OF_DIVISION = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_YEAR", BadiCalendar.class, 1, 365, 0);
        DAY_OF_YEAR = stdIntegerDateElement3;
        DowElement dowElement = DowElement.SINGLETON;
        DAY_OF_WEEK = dowElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        ENGINE = TimeAxis.Builder.setUp(Unit.class, cls, new Merger(), transformer).appendElement((ChronoElement) r1, (ElementRule) new EraRule()).appendElement(stdIntegerDateElement, new IntegerRule(5), Unit.YEARS).appendElement((ChronoElement) r11, (ElementRule) new IntegerRule(0)).appendElement(r4, new IntegerRule(1), Unit.VAHID_CYCLES).appendElement(yov, new IntegerRule(2), Unit.YEARS).appendElement(monthElement, new MonthRule(), Unit.MONTHS).appendElement((ChronoElement) intercalaryAccess, (ElementRule) IntercalaryAccess.SINGLETON).appendElement(stdIntegerDateElement2, new IntegerRule(3), Unit.DAYS).appendElement(stdIntegerDateElement3, new IntegerRule(4), Unit.DAYS).appendElement(dowElement, new WeekdayRule(), Unit.DAYS).appendUnit(Unit.VAHID_CYCLES, new FUnitRule(Unit.VAHID_CYCLES), Unit.VAHID_CYCLES.getLength(), Collections.singleton(Unit.YEARS)).appendUnit(Unit.YEARS, new FUnitRule(Unit.YEARS), Unit.YEARS.getLength(), Collections.singleton(Unit.VAHID_CYCLES)).appendUnit(Unit.MONTHS, new FUnitRule(Unit.MONTHS), Unit.MONTHS.getLength()).appendUnit(Unit.WEEKS, new FUnitRule(Unit.WEEKS), Unit.WEEKS.getLength(), Collections.singleton(Unit.DAYS)).appendUnit(Unit.DAYS, new FUnitRule(Unit.DAYS), Unit.DAYS.getLength(), Collections.singleton(Unit.WEEKS)).build();
    }

    private BadiCalendar(int i, int i2, int i3, int i4, int i5) {
        this.major = i;
        this.cycle = i2;
        this.year = i3;
        this.division = i4;
        this.day = i5;
    }

    public static BadiCalendar ofComplete(int i, int i2, int i3, BadiDivision badiDivision, int i4) {
        if (i < 1 || i > 3) {
            throw new IllegalArgumentException("Major cycle (kull-i-shai) out of range 1-3: " + i);
        } else if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("Vahid cycle out of range 1-19: " + i2);
        } else if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("Year of vahid out of range 1-19: " + i3);
        } else if (badiDivision instanceof BadiMonth) {
            if (i4 < 1 || i4 > 19) {
                throw new IllegalArgumentException("Day out of range 1-19: " + i4);
            }
            return new BadiCalendar(i, i2, i3, BadiMonth.class.cast(badiDivision).getValue(), i4);
        } else if (badiDivision == BadiIntercalaryDays.AYYAM_I_HA) {
            int i5 = isLeapYear(i, i2, i3) ? 5 : 4;
            if (i4 >= 1 && i4 <= i5) {
                return new BadiCalendar(i, i2, i3, 0, i4);
            }
            throw new IllegalArgumentException("Day out of range 1-" + i5 + ": " + i4);
        } else {
            Objects.requireNonNull(badiDivision, "Missing Badi month or Ayyam-i-Ha.");
            throw new IllegalArgumentException("Invalid implementation of Badi division: " + badiDivision);
        }
    }

    public static BadiCalendar ofComplete(BadiEra badiEra, int i, BadiDivision badiDivision, int i2) {
        Objects.requireNonNull(badiEra, "Missing Bahai era.");
        if (i < 1 || i > 1083) {
            throw new IllegalArgumentException("Year of era out of range 1-1083: " + i);
        }
        BadiCalendar badiCalendar = (BadiCalendar) axis().getMinimum().with((ChronoElement<Integer>) YEAR_OF_ERA, i);
        int kullishai = badiCalendar.getKullishai();
        int vahid = badiCalendar.getVahid();
        int yearOfVahid = badiCalendar.getYearOfVahid();
        if (badiDivision instanceof BadiMonth) {
            if (i2 >= 1 && i2 <= 19) {
                return new BadiCalendar(kullishai, vahid, yearOfVahid, BadiMonth.class.cast(badiDivision).getValue(), i2);
            }
            throw new IllegalArgumentException("Day out of range 1-19: " + i2);
        } else if (badiDivision == BadiIntercalaryDays.AYYAM_I_HA) {
            int i3 = isLeapYear(kullishai, vahid, yearOfVahid) ? 5 : 4;
            if (i2 >= 1 && i2 <= i3) {
                return new BadiCalendar(kullishai, vahid, yearOfVahid, 0, i2);
            }
            throw new IllegalArgumentException("Day out of range 1-" + i3 + ": " + i2);
        } else {
            Objects.requireNonNull(badiDivision, "Missing Badi month or Ayyam-i-Ha.");
            throw new IllegalArgumentException("Invalid implementation of Badi division: " + badiDivision);
        }
    }

    public static BadiCalendar of(int i, int i2, BadiMonth badiMonth, int i3) {
        return ofComplete(1, i, i2, badiMonth, i3);
    }

    public static BadiCalendar of(int i, int i2, int i3, int i4) {
        return ofComplete(1, i, i2, BadiMonth.valueOf(i3), i4);
    }

    public static BadiCalendar ofIntercalary(int i, int i2, int i3) {
        return ofComplete(1, i, i2, BadiIntercalaryDays.AYYAM_I_HA, i3);
    }

    public static BadiCalendar nowInSystemTime() {
        return (BadiCalendar) SystemClock.inLocalView().now(axis());
    }

    public int getKullishai() {
        return this.major;
    }

    public int getVahid() {
        return this.cycle;
    }

    public int getYearOfVahid() {
        return this.year;
    }

    public int getYearOfEra() {
        return getRelatedGregorianYear() - 1843;
    }

    public BadiMonth getMonth() {
        int i = this.division;
        if (i != 0) {
            return BadiMonth.valueOf(i);
        }
        throw new ChronoException("Intercalary days (Ayyam-i-Ha) do not represent any month: " + toString());
    }

    public BadiDivision getDivision() {
        return isIntercalaryDay() ? BadiIntercalaryDays.AYYAM_I_HA : getMonth();
    }

    public int getDayOfDivision() {
        return this.day;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(CALSYS.transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        int i = this.division;
        if (i == 0) {
            return this.day + ExifDirectoryBase.TAG_TRANSFER_RANGE;
        }
        if (i != 19) {
            return ((i - 1) * 19) + this.day;
        }
        return (isLeapYear() ? 5 : 4) + ExifDirectoryBase.TAG_TRANSFER_RANGE + this.day;
    }

    public boolean isIntercalaryDay() {
        return this.division == 0;
    }

    public boolean hasMonth() {
        return this.division > 0;
    }

    public boolean isLeapYear() {
        return isLeapYear(this.major, this.cycle, this.year);
    }

    public static boolean isLeapYear(int i, int i2, int i3) {
        if (i < 1 || i > 3) {
            throw new IllegalArgumentException("Major cycle (kull-i-shai) out of range 1-3: " + i);
        } else if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("Vahid cycle out of range 1-19: " + i2);
        } else if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("Year out of range 1-19: " + i3);
        } else {
            int relatedGregorianYear = getRelatedGregorianYear(i, i2, i3);
            if (relatedGregorianYear < 2015) {
                return GregorianMath.isLeapYear(relatedGregorianYear + 1);
            }
            int i4 = relatedGregorianYear - 2015;
            int[] iArr = NEWROZ;
            if (iArr[i4 + 1] - iArr[i4] == 366) {
                return true;
            }
            return false;
        }
    }

    public static boolean isValid(int i, int i2, int i3, BadiDivision badiDivision, int i4) {
        if (i < 1 || i > 3 || i2 < 1 || i2 > 19 || i3 < 1 || i3 > 19) {
            return false;
        }
        if (badiDivision instanceof BadiMonth) {
            return i4 >= 1 && i4 <= 19;
        }
        if (badiDivision != BadiIntercalaryDays.AYYAM_I_HA || i4 < 1) {
            return false;
        }
        if (i4 <= (isLeapYear(i, i2, i3) ? 5 : 4)) {
            return true;
        }
        return false;
    }

    public GeneralTimestamp<BadiCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<BadiCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BadiCalendar)) {
            return false;
        }
        BadiCalendar badiCalendar = (BadiCalendar) obj;
        if (this.major == badiCalendar.major && this.cycle == badiCalendar.cycle && this.year == badiCalendar.year && this.division == badiCalendar.division && this.day == badiCalendar.day) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.major * 361) + (this.cycle * 19) + this.year) * 512) + (this.division * 19) + this.day;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Bahai-");
        sb.append(this.major);
        sb.append(SignatureVisitor.SUPER);
        sb.append(this.cycle);
        sb.append(SignatureVisitor.SUPER);
        sb.append(this.year);
        sb.append(SignatureVisitor.SUPER);
        int i = this.division;
        if (i == 0) {
            sb.append("Ayyam-i-Ha-");
        } else {
            sb.append(i);
            sb.append(SignatureVisitor.SUPER);
        }
        sb.append(this.day);
        return sb.toString();
    }

    public boolean contains(ChronoElement<?> chronoElement) {
        if (chronoElement == MONTH_OF_YEAR) {
            return hasMonth();
        }
        if (chronoElement == AYYAM_I_HA) {
            return isIntercalaryDay();
        }
        if (getRegisteredElements().contains(chronoElement)) {
            return true;
        }
        return isAccessible(this, chronoElement);
    }

    public <V> boolean isValid(ChronoElement<V> chronoElement, V v) {
        if (chronoElement == MONTH_OF_YEAR || chronoElement == AYYAM_I_HA || chronoElement == ERA) {
            return v != null;
        }
        return super.isValid(chronoElement, v);
    }

    public static TimeAxis<Unit, BadiCalendar> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<Unit, BadiCalendar> getChronology() {
        return ENGINE;
    }

    /* access modifiers changed from: private */
    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Weekday.SATURDAY, 1, Weekday.SATURDAY, Weekday.SUNDAY);
    }

    /* access modifiers changed from: private */
    public int getRelatedGregorianYear() {
        return getRelatedGregorianYear(this.major, this.cycle, this.year);
    }

    /* access modifiers changed from: private */
    public BadiCalendar withDayOfYear(int i) {
        int i2;
        int i3;
        if (i <= 342) {
            int i4 = i - 1;
            i2 = (i4 % 19) + 1;
            i3 = (i4 / 19) + 1;
        } else {
            int i5 = 5;
            if (i <= (isLeapYear() ? 5 : 4) + ExifDirectoryBase.TAG_TRANSFER_RANGE) {
                i2 = i - ExifDirectoryBase.TAG_TRANSFER_RANGE;
                i3 = 0;
            } else {
                if (!isLeapYear()) {
                    i5 = 4;
                }
                i2 = (i - i5) - ExifDirectoryBase.TAG_TRANSFER_RANGE;
                i3 = 19;
            }
        }
        return new BadiCalendar(this.major, this.cycle, this.year, i3, i2);
    }

    private static <V> boolean isAccessible(BadiCalendar badiCalendar, ChronoElement<V> chronoElement) {
        try {
            return badiCalendar.isValid(chronoElement, badiCalendar.get(chronoElement));
        } catch (ChronoException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static Locale getLocale(AttributeQuery attributeQuery) {
        return (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
    }

    /* access modifiers changed from: private */
    public static FormattedContent getFormattedContent(AttributeQuery attributeQuery) {
        return (FormattedContent) attributeQuery.get(TEXT_CONTENT_ATTRIBUTE, FormattedContent.TRANSCRIPTION);
    }

    private Object writeReplace() {
        return new SPX(this, 19);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        VAHID_CYCLES(5.9958192384E8d),
        YEARS(3.155694336E7d),
        MONTHS(1641600.0d),
        WEEKS(604800.0d),
        DAYS(86400.0d);
        
        private final transient double length;

        public boolean isCalendrical() {
            return true;
        }

        private Unit(double d) {
            this.length = d;
        }

        public double getLength() {
            return this.length;
        }

        public long between(BadiCalendar badiCalendar, BadiCalendar badiCalendar2) {
            return badiCalendar.until(badiCalendar2, this);
        }
    }

    private static class Transformer implements CalendarSystem<BadiCalendar> {
        private static final long EPOCH = PlainDate.of(1844, 3, 21).getDaysSinceEpochUTC();

        private Transformer() {
        }

        public BadiCalendar transform(long j) {
            long j2 = j;
            if (j2 >= EPOCH) {
                int i = 0;
                if (j2 < ((long) BadiCalendar.NEWROZ[0])) {
                    PlainDate of = PlainDate.of(j2, EpochDays.UTC);
                    int year = of.getYear() - 1843;
                    int month = of.getMonth();
                    if (month <= 2 || (month == 3 && of.getDayOfMonth() < 21)) {
                        year--;
                    }
                    int i2 = year - 1;
                    BadiCalendar badiCalendar = new BadiCalendar(1, MathUtils.floorDivide(i2, 19) + 1, MathUtils.floorModulo(i2, 19) + 1, 1, 1);
                    return badiCalendar.withDayOfYear(MathUtils.safeCast((j2 - transform(badiCalendar)) + 1));
                }
                int length = BadiCalendar.NEWROZ.length - 2;
                while (i <= length) {
                    int i3 = i + 1;
                    if (j2 < ((long) BadiCalendar.NEWROZ[i3])) {
                        int safeCast = MathUtils.safeCast((j2 - ((long) BadiCalendar.NEWROZ[i])) + 1);
                        int i4 = (i + 2015) - 1843;
                        int i5 = i4 - 1;
                        int floorDivide = MathUtils.floorDivide(i5, 361) + 1;
                        return new BadiCalendar(floorDivide, MathUtils.floorDivide((i4 - ((floorDivide - 1) * 361)) - 1, 19) + 1, MathUtils.floorModulo(i5, 19) + 1, 1, 1).withDayOfYear(safeCast);
                    }
                    i = i3;
                }
                throw new IllegalArgumentException("Out of range: " + j2);
            }
            throw new IllegalArgumentException("Not defined before Bahai era: " + j2);
        }

        public long transform(BadiCalendar badiCalendar) {
            int access$800 = badiCalendar.getRelatedGregorianYear();
            int dayOfYear = badiCalendar.getDayOfYear();
            if (access$800 < 2015) {
                return (PlainDate.of(access$800, 3, 21).getDaysSinceEpochUTC() + ((long) dayOfYear)) - 1;
            }
            return (long) ((BadiCalendar.NEWROZ[access$800 - 2015] + dayOfYear) - 1);
        }

        public long getMinimumSinceUTC() {
            return EPOCH;
        }

        public long getMaximumSinceUTC() {
            return (long) (BadiCalendar.NEWROZ[BadiCalendar.NEWROZ.length - 1] - 1);
        }

        public List<CalendarEra> getEras() {
            return Collections.singletonList(BadiEra.BAHAI);
        }
    }

    private static class EraRule implements ElementRule<BadiCalendar, BadiEra> {
        public boolean isValid(BadiCalendar badiCalendar, BadiEra badiEra) {
            return badiEra != null;
        }

        private EraRule() {
        }

        public BadiEra getValue(BadiCalendar badiCalendar) {
            return BadiEra.BAHAI;
        }

        public BadiEra getMinimum(BadiCalendar badiCalendar) {
            return BadiEra.BAHAI;
        }

        public BadiEra getMaximum(BadiCalendar badiCalendar) {
            return BadiEra.BAHAI;
        }

        public BadiCalendar withValue(BadiCalendar badiCalendar, BadiEra badiEra, boolean z) {
            if (badiEra != null) {
                return badiCalendar;
            }
            throw new IllegalArgumentException("Missing era value.");
        }

        public ChronoElement<?> getChildAtFloor(BadiCalendar badiCalendar) {
            return BadiCalendar.YEAR_OF_ERA;
        }

        public ChronoElement<?> getChildAtCeiling(BadiCalendar badiCalendar) {
            return BadiCalendar.YEAR_OF_ERA;
        }
    }

    private static class IntegerRule implements IntElementRule<BadiCalendar> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public int getInt(BadiCalendar badiCalendar) {
            int i = this.index;
            if (i == 0) {
                return badiCalendar.major;
            }
            if (i == 1) {
                return badiCalendar.cycle;
            }
            if (i == 2) {
                return badiCalendar.year;
            }
            if (i == 3) {
                return badiCalendar.day;
            }
            if (i == 4) {
                return badiCalendar.getDayOfYear();
            }
            if (i == 5) {
                return badiCalendar.getYearOfEra();
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(BadiCalendar badiCalendar, int i) {
            return 1 <= i && getMax(badiCalendar) >= i;
        }

        public BadiCalendar withValue(BadiCalendar badiCalendar, int i, boolean z) {
            if (isValid(badiCalendar, i)) {
                int access$1200 = badiCalendar.day;
                int i2 = this.index;
                if (i2 == 0) {
                    return new BadiCalendar(i, badiCalendar.cycle, badiCalendar.year, badiCalendar.division, (access$1200 != 5 || !badiCalendar.isIntercalaryDay() || BadiCalendar.isLeapYear(i, badiCalendar.cycle, badiCalendar.year)) ? access$1200 : 4);
                } else if (i2 == 1) {
                    return new BadiCalendar(badiCalendar.major, i, badiCalendar.year, badiCalendar.division, (access$1200 != 5 || !badiCalendar.isIntercalaryDay() || BadiCalendar.isLeapYear(badiCalendar.major, i, badiCalendar.year)) ? access$1200 : 4);
                } else if (i2 == 2) {
                    return new BadiCalendar(badiCalendar.major, badiCalendar.cycle, i, badiCalendar.division, (access$1200 != 5 || !badiCalendar.isIntercalaryDay() || BadiCalendar.isLeapYear(badiCalendar.major, badiCalendar.cycle, i)) ? access$1200 : 4);
                } else if (i2 == 3) {
                    return new BadiCalendar(badiCalendar.major, badiCalendar.cycle, badiCalendar.year, badiCalendar.division, i);
                } else {
                    if (i2 == 4) {
                        return badiCalendar.withDayOfYear(i);
                    }
                    if (i2 == 5) {
                        int i3 = i - 1;
                        int floorDivide = MathUtils.floorDivide(i3, 361) + 1;
                        int floorDivide2 = MathUtils.floorDivide((i - ((floorDivide - 1) * 361)) - 1, 19) + 1;
                        int floorModulo = MathUtils.floorModulo(i3, 19) + 1;
                        if (access$1200 == 5 && badiCalendar.isIntercalaryDay() && !BadiCalendar.isLeapYear(floorDivide, floorDivide2, floorModulo)) {
                            access$1200 = 4;
                        }
                        return BadiCalendar.ofComplete(floorDivide, floorDivide2, floorModulo, badiCalendar.getDivision(), access$1200);
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            } else {
                throw new IllegalArgumentException("Out of range: " + i);
            }
        }

        public Integer getValue(BadiCalendar badiCalendar) {
            return Integer.valueOf(getInt(badiCalendar));
        }

        public Integer getMinimum(BadiCalendar badiCalendar) {
            return 1;
        }

        public Integer getMaximum(BadiCalendar badiCalendar) {
            return Integer.valueOf(getMax(badiCalendar));
        }

        public boolean isValid(BadiCalendar badiCalendar, Integer num) {
            return num != null && isValid(badiCalendar, num.intValue());
        }

        public BadiCalendar withValue(BadiCalendar badiCalendar, Integer num, boolean z) {
            if (num != null) {
                return withValue(badiCalendar, num.intValue(), z);
            }
            throw new IllegalArgumentException("Missing new value.");
        }

        public ChronoElement<?> getChildAtFloor(BadiCalendar badiCalendar) {
            int i = this.index;
            if (i == 0) {
                return BadiCalendar.VAHID;
            }
            if (i == 1) {
                return BadiCalendar.YEAR_OF_VAHID;
            }
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return null;
                }
                if (i != 5) {
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            }
            return BadiCalendar.MONTH_OF_YEAR;
        }

        public ChronoElement<?> getChildAtCeiling(BadiCalendar badiCalendar) {
            int i = this.index;
            if (i == 0) {
                return BadiCalendar.VAHID;
            }
            if (i == 1) {
                return BadiCalendar.YEAR_OF_VAHID;
            }
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return null;
                }
                if (i != 5) {
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            }
            return BadiCalendar.MONTH_OF_YEAR;
        }

        private int getMax(BadiCalendar badiCalendar) {
            int i = this.index;
            if (i == 0) {
                return 3;
            }
            if (!(i == 1 || i == 2)) {
                if (i != 3) {
                    if (i == 4) {
                        return badiCalendar.isLeapYear() ? 366 : 365;
                    }
                    if (i == 5) {
                        return PhotoshopDirectory.TAG_PRINT_STYLE;
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                } else if (badiCalendar.isIntercalaryDay()) {
                    if (badiCalendar.isLeapYear()) {
                        return 5;
                    }
                    return 4;
                }
            }
            return 19;
        }
    }

    private static class MonthRule implements ElementRule<BadiCalendar, BadiMonth> {
        public boolean isValid(BadiCalendar badiCalendar, BadiMonth badiMonth) {
            return badiMonth != null;
        }

        private MonthRule() {
        }

        public BadiMonth getValue(BadiCalendar badiCalendar) {
            return badiCalendar.getMonth();
        }

        public BadiMonth getMinimum(BadiCalendar badiCalendar) {
            return BadiMonth.BAHA;
        }

        public BadiMonth getMaximum(BadiCalendar badiCalendar) {
            return BadiMonth.ALA;
        }

        public BadiCalendar withValue(BadiCalendar badiCalendar, BadiMonth badiMonth, boolean z) {
            if (badiMonth != null) {
                return new BadiCalendar(badiCalendar.major, badiCalendar.cycle, badiCalendar.year, badiMonth.getValue(), badiCalendar.isIntercalaryDay() ? 19 : badiCalendar.day);
            }
            throw new IllegalArgumentException("Missing Badi month.");
        }

        public ChronoElement<?> getChildAtFloor(BadiCalendar badiCalendar) {
            return BadiCalendar.DAY_OF_DIVISION;
        }

        public ChronoElement<?> getChildAtCeiling(BadiCalendar badiCalendar) {
            return BadiCalendar.DAY_OF_DIVISION;
        }
    }

    private static class MonthElement extends StdEnumDateElement<BadiMonth, BadiCalendar> {
        static final MonthElement SINGLETON = new MonthElement();
        private static final long serialVersionUID = -5483090643555757806L;

        /* access modifiers changed from: protected */
        public boolean isSingleton() {
            return true;
        }

        private MonthElement() {
            super("MONTH_OF_YEAR", BadiCalendar.class, BadiMonth.class, 'M');
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
            appendable.append(accessor(attributeQuery).print((BadiMonth) chronoDisplay.get(this)));
        }

        public BadiMonth parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            return (BadiMonth) accessor(attributeQuery).parse(charSequence, parsePosition, BadiMonth.class, attributeQuery);
        }

        private TextAccessor accessor(AttributeQuery attributeQuery) {
            Locale access$1400 = BadiCalendar.getLocale(attributeQuery);
            return CalendarText.getInstance("bahai", access$1400).getTextForms("M", BadiMonth.class, BadiCalendar.getFormattedContent(attributeQuery).variant());
        }
    }

    private static class DowElement extends StdWeekdayElement<BadiCalendar> {
        static final DowElement SINGLETON = new DowElement();
        private static final long serialVersionUID = -1733732651700208755L;

        /* access modifiers changed from: protected */
        public boolean isSingleton() {
            return true;
        }

        private DowElement() {
            super(BadiCalendar.class, BadiCalendar.getDefaultWeekmodel());
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
            appendable.append(accessor(attributeQuery).print(((Weekday) chronoDisplay.get(this)).roll(2)));
        }

        public Weekday parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            return ((Weekday) accessor(attributeQuery).parse(charSequence, parsePosition, Weekday.class, attributeQuery)).roll(-2);
        }

        private TextAccessor accessor(AttributeQuery attributeQuery) {
            Locale access$1400 = BadiCalendar.getLocale(attributeQuery);
            return CalendarText.getInstance("bahai", access$1400).getTextForms("D", Weekday.class, BadiCalendar.getFormattedContent(attributeQuery).variant());
        }
    }

    private static class YOV extends DisplayElement<Integer> implements TextElement<Integer> {
        static final YOV SINGLETON = new YOV();
        private static final long serialVersionUID = -8280579801733395557L;

        public char getSymbol() {
            return 'X';
        }

        public boolean isDateElement() {
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean isSingleton() {
            return true;
        }

        public boolean isTimeElement() {
            return false;
        }

        private YOV() {
            super("YEAR_OF_VAHID");
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            appendable.append(accessor(attributeQuery).print(((BadiMonth[]) enumAccess().getEnumConstants())[chronoDisplay.getInt(this) - 1]));
        }

        public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            Enum parse = accessor(attributeQuery).parse(charSequence, parsePosition, enumAccess(), attributeQuery);
            if (parse == null) {
                return null;
            }
            return Integer.valueOf(parse.ordinal() + 1);
        }

        public Class<Integer> getType() {
            return Integer.class;
        }

        public Integer getDefaultMinimum() {
            return 1;
        }

        public Integer getDefaultMaximum() {
            return 19;
        }

        private TextAccessor accessor(AttributeQuery attributeQuery) {
            Locale access$1400 = BadiCalendar.getLocale(attributeQuery);
            FormattedContent access$1500 = BadiCalendar.getFormattedContent(attributeQuery);
            return CalendarText.getInstance("bahai", access$1400).getTextForms("YOV", enumAccess(), access$1500.variant());
        }

        private static Class<BadiMonth> enumAccess() {
            return BadiMonth.class;
        }
    }

    private static class IntercalaryAccess extends BasicElement<BadiIntercalaryDays> implements TextElement<BadiIntercalaryDays>, ElementRule<BadiCalendar, BadiIntercalaryDays> {
        static final IntercalaryAccess SINGLETON = new IntercalaryAccess();
        private static final long serialVersionUID = -772152174221291354L;

        public char getSymbol() {
            return 'A';
        }

        public boolean isDateElement() {
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean isSingleton() {
            return true;
        }

        public boolean isTimeElement() {
            return false;
        }

        private IntercalaryAccess() {
            super("AYYAM_I_HA");
        }

        public BadiIntercalaryDays getValue(BadiCalendar badiCalendar) {
            if (badiCalendar.isIntercalaryDay()) {
                return BadiIntercalaryDays.AYYAM_I_HA;
            }
            throw new ChronoException("The actual calendar date is not an intercalary day: " + badiCalendar);
        }

        public BadiIntercalaryDays getMinimum(BadiCalendar badiCalendar) {
            return BadiIntercalaryDays.AYYAM_I_HA;
        }

        public BadiIntercalaryDays getMaximum(BadiCalendar badiCalendar) {
            return BadiIntercalaryDays.AYYAM_I_HA;
        }

        public boolean isValid(BadiCalendar badiCalendar, BadiIntercalaryDays badiIntercalaryDays) {
            return badiIntercalaryDays == BadiIntercalaryDays.AYYAM_I_HA;
        }

        public BadiCalendar withValue(BadiCalendar badiCalendar, BadiIntercalaryDays badiIntercalaryDays, boolean z) {
            if (badiIntercalaryDays == BadiIntercalaryDays.AYYAM_I_HA) {
                return new BadiCalendar(badiCalendar.major, badiCalendar.cycle, badiCalendar.year, 0, Math.min(badiCalendar.day, badiCalendar.isLeapYear() ? 5 : 4));
            }
            throw new IllegalArgumentException("Expected Ayyam-i-Ha: " + badiIntercalaryDays);
        }

        public ChronoElement<?> getChildAtFloor(BadiCalendar badiCalendar) {
            return BadiCalendar.DAY_OF_DIVISION;
        }

        public ChronoElement<?> getChildAtCeiling(BadiCalendar badiCalendar) {
            return BadiCalendar.DAY_OF_DIVISION;
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            appendable.append(accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), attributeQuery).print((BadiIntercalaryDays) chronoDisplay.get(this)));
        }

        public BadiIntercalaryDays parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            return (BadiIntercalaryDays) accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), attributeQuery).parse(charSequence, parsePosition, getType(), attributeQuery);
        }

        public Class<BadiIntercalaryDays> getType() {
            return BadiIntercalaryDays.class;
        }

        public BadiIntercalaryDays getDefaultMinimum() {
            return BadiIntercalaryDays.AYYAM_I_HA;
        }

        public BadiIntercalaryDays getDefaultMaximum() {
            return BadiIntercalaryDays.AYYAM_I_HA;
        }

        public String getDisplayName(Locale locale) {
            return BadiIntercalaryDays.AYYAM_I_HA.getDisplayName(locale);
        }

        private TextAccessor accessor(Locale locale, AttributeQuery attributeQuery) {
            FormattedContent formattedContent = (FormattedContent) attributeQuery.get(BadiCalendar.TEXT_CONTENT_ATTRIBUTE, FormattedContent.TRANSCRIPTION);
            CalendarText instance = CalendarText.getInstance("bahai", locale);
            String str = "a";
            if (formattedContent != FormattedContent.MEANING || !instance.getTextForms().containsKey(str)) {
                str = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
            }
            return instance.getTextForms(str, getType(), new String[0]);
        }
    }

    private static class WeekdayRule implements ElementRule<BadiCalendar, Weekday> {
        public ChronoElement<?> getChildAtCeiling(BadiCalendar badiCalendar) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(BadiCalendar badiCalendar) {
            return null;
        }

        private WeekdayRule() {
        }

        public Weekday getValue(BadiCalendar badiCalendar) {
            return badiCalendar.getDayOfWeek();
        }

        public Weekday getMinimum(BadiCalendar badiCalendar) {
            if (badiCalendar.major == 1 && badiCalendar.cycle == 1 && badiCalendar.year == 1 && badiCalendar.division == 1 && badiCalendar.day <= 2) {
                return Weekday.THURSDAY;
            }
            return Weekday.SATURDAY;
        }

        public Weekday getMaximum(BadiCalendar badiCalendar) {
            if (badiCalendar.major == 3 && badiCalendar.cycle == 19 && badiCalendar.year == 19 && badiCalendar.division == 19 && badiCalendar.day >= 14) {
                return Weekday.THURSDAY;
            }
            return Weekday.FRIDAY;
        }

        public boolean isValid(BadiCalendar badiCalendar, Weekday weekday) {
            if (weekday == null) {
                return false;
            }
            Weekmodel access$1600 = BadiCalendar.getDefaultWeekmodel();
            int value = weekday.getValue(access$1600);
            int value2 = getMinimum(badiCalendar).getValue(access$1600);
            int value3 = getMaximum(badiCalendar).getValue(access$1600);
            if (value2 > value || value > value3) {
                return false;
            }
            return true;
        }

        public BadiCalendar withValue(BadiCalendar badiCalendar, Weekday weekday, boolean z) {
            if (weekday != null) {
                Weekmodel access$1600 = BadiCalendar.getDefaultWeekmodel();
                return (BadiCalendar) badiCalendar.plus(CalendarDays.of((long) (weekday.getValue(access$1600) - badiCalendar.getDayOfWeek().getValue(access$1600))));
            }
            throw new IllegalArgumentException("Missing weekday.");
        }
    }

    private static class Merger implements ChronoMerger<BadiCalendar> {
        public ChronoDisplay preformat(BadiCalendar badiCalendar, AttributeQuery attributeQuery) {
            return badiCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.bahai.BadiCalendar createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
            /*
                r3 = this;
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r0 = r5.contains(r0)
                if (r0 == 0) goto L_0x0011
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r0 = r5.get(r0)
                net.time4j.tz.TZID r0 = (net.time4j.tz.TZID) r0
                goto L_0x0029
            L_0x0011:
                net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r0 = net.time4j.format.Attributes.LENIENCY
                net.time4j.format.Leniency r1 = net.time4j.format.Leniency.SMART
                java.lang.Object r0 = r5.get(r0, r1)
                net.time4j.format.Leniency r0 = (net.time4j.format.Leniency) r0
                boolean r0 = r0.isLax()
                if (r0 == 0) goto L_0x004c
                net.time4j.tz.Timezone r0 = net.time4j.tz.Timezone.ofSystem()
                net.time4j.tz.TZID r0 = r0.getID()
            L_0x0029:
                net.time4j.engine.AttributeKey<net.time4j.engine.StartOfDay> r1 = net.time4j.format.Attributes.START_OF_DAY
                net.time4j.engine.StartOfDay r2 = r3.getDefaultStartOfDay()
                java.lang.Object r5 = r5.get(r1, r2)
                net.time4j.engine.StartOfDay r5 = (net.time4j.engine.StartOfDay) r5
                net.time4j.base.UnixTime r4 = r4.currentTime()
                net.time4j.Moment r4 = net.time4j.Moment.from(r4)
                net.time4j.engine.TimeAxis r1 = net.time4j.calendar.bahai.BadiCalendar.ENGINE
                net.time4j.GeneralTimestamp r4 = r4.toGeneralTimestamp(r1, r0, r5)
                java.lang.Object r4 = r4.toDate()
                net.time4j.calendar.bahai.BadiCalendar r4 = (net.time4j.calendar.bahai.BadiCalendar) r4
                return r4
            L_0x004c:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.bahai.BadiCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.bahai.BadiCalendar");
        }

        public BadiCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            boolean z3;
            int i;
            int i2;
            int i3;
            int i4;
            int i5 = chronoEntity.getInt(BadiCalendar.KULL_I_SHAI);
            if (i5 == Integer.MIN_VALUE) {
                i5 = 1;
            } else if (i5 < 1 || i5 > 3) {
                ValidationElement validationElement = ValidationElement.ERROR_MESSAGE;
                chronoEntity.with((ChronoElement<V>) validationElement, "Major cycle out of range: " + i5);
                return null;
            }
            int i6 = chronoEntity.getInt(BadiCalendar.VAHID);
            if (i6 == Integer.MIN_VALUE) {
                z3 = false;
            } else if (i6 < 1 || i6 > 19) {
                ValidationElement validationElement2 = ValidationElement.ERROR_MESSAGE;
                chronoEntity.with((ChronoElement<V>) validationElement2, "Vahid cycle out of range: " + i6);
                return null;
            } else {
                z3 = true;
            }
            int i7 = chronoEntity.getInt(BadiCalendar.YEAR_OF_VAHID);
            if (i7 == Integer.MIN_VALUE) {
                if (chronoEntity.contains(BadiCalendar.YEAR_OF_ERA)) {
                    BadiCalendar badiCalendar = (BadiCalendar) BadiCalendar.axis().getMinimum().with((ChronoElement<Integer>) BadiCalendar.YEAR_OF_ERA, chronoEntity.getInt(BadiCalendar.YEAR_OF_ERA));
                    i2 = badiCalendar.getKullishai();
                    i = badiCalendar.getVahid();
                    i7 = badiCalendar.getYearOfVahid();
                } else {
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing year-of-vahid.");
                    return null;
                }
            } else if (!z3) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing vahid cycle.");
                return null;
            } else if (i7 < 1 || i7 > 19) {
                ValidationElement validationElement3 = ValidationElement.ERROR_MESSAGE;
                chronoEntity.with((ChronoElement<V>) validationElement3, "Badi year-of-vahid out of range: " + i7);
                return null;
            } else {
                i = i6;
                i2 = i5;
            }
            if (chronoEntity.contains(BadiCalendar.MONTH_OF_YEAR)) {
                int value = ((BadiMonth) chronoEntity.get((ChronoElement<V>) BadiCalendar.MONTH_OF_YEAR)).getValue();
                int i8 = chronoEntity.getInt(BadiCalendar.DAY_OF_DIVISION);
                if (i8 >= 1 && i8 <= 19) {
                    return new BadiCalendar(i2, i, i7, value, i8);
                }
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Badi date.");
                return null;
            }
            int i9 = 5;
            if (chronoEntity.contains(BadiCalendar.AYYAM_I_HA)) {
                int i10 = chronoEntity.getInt(BadiCalendar.DAY_OF_DIVISION);
                if (i10 >= 1) {
                    if (!BadiCalendar.isLeapYear(i2, i, i7)) {
                        i9 = 4;
                    }
                    if (i10 <= i9) {
                        return new BadiCalendar(i2, i, i7, 0, i10);
                    }
                }
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Badi date.");
                return null;
            }
            int i11 = chronoEntity.getInt(BadiCalendar.DAY_OF_YEAR);
            boolean isLeapYear = BadiCalendar.isLeapYear(i2, i, i7);
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            if (i11 >= 1) {
                if (i11 <= (isLeapYear ? 366 : 365)) {
                    if (i11 <= 342) {
                        int i12 = i11 - 1;
                        i3 = (i12 % 19) + 1;
                        i4 = (i12 / 19) + 1;
                    } else {
                        if (i11 <= (isLeapYear ? 5 : 4) + ExifDirectoryBase.TAG_TRANSFER_RANGE) {
                            i3 = i11 - ExifDirectoryBase.TAG_TRANSFER_RANGE;
                            i4 = 0;
                        } else {
                            if (!isLeapYear) {
                                i9 = 4;
                            }
                            i3 = (i11 - i9) - ExifDirectoryBase.TAG_TRANSFER_RANGE;
                            i4 = 19;
                        }
                    }
                    return new BadiCalendar(i2, i, i7, i4, i3);
                }
            }
            chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Badi date.");
            return null;
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            throw new UnsupportedOperationException("Localized format patterns are not available.");
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear() - 1844;
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.definedBy(BadiCalendar.TEHERAN.sunset());
        }
    }

    private static class FUnitRule implements UnitRule<BadiCalendar> {
        private final Unit unit;

        FUnitRule(Unit unit2) {
            this.unit = unit2;
        }

        public BadiCalendar addTo(BadiCalendar badiCalendar, long j) {
            int i = AnonymousClass4.$SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit[this.unit.ordinal()];
            int i2 = 4;
            int i3 = 19;
            if (i == 1) {
                j = MathUtils.safeMultiply(j, 19);
            } else if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        j = MathUtils.safeMultiply(j, 7);
                    } else if (i != 5) {
                        throw new UnsupportedOperationException(this.unit.name());
                    }
                    return (BadiCalendar) BadiCalendar.CALSYS.transform(MathUtils.safeAdd(BadiCalendar.CALSYS.transform(badiCalendar), j));
                }
                long safeAdd = MathUtils.safeAdd((long) elapsedMonths(badiCalendar), j);
                int safeCast = MathUtils.safeCast(MathUtils.floorDivide(safeAdd, 6859)) + 1;
                int floorModulo = MathUtils.floorModulo(safeAdd, 6859);
                int floorDivide = MathUtils.floorDivide(floorModulo, 361) + 1;
                int floorModulo2 = MathUtils.floorModulo(floorModulo, 361);
                int floorDivide2 = MathUtils.floorDivide(floorModulo2, 19) + 1;
                int floorModulo3 = MathUtils.floorModulo(floorModulo2, 19) + 1;
                if (!badiCalendar.isIntercalaryDay()) {
                    i3 = badiCalendar.day;
                }
                return BadiCalendar.ofComplete(safeCast, floorDivide, floorDivide2, BadiMonth.valueOf(floorModulo3), i3);
            }
            long safeAdd2 = MathUtils.safeAdd((long) elapsedYears(badiCalendar), j);
            int safeCast2 = MathUtils.safeCast(MathUtils.floorDivide(safeAdd2, 361)) + 1;
            int floorModulo4 = MathUtils.floorModulo(safeAdd2, 361);
            int floorDivide3 = MathUtils.floorDivide(floorModulo4, 19) + 1;
            int floorModulo5 = MathUtils.floorModulo(floorModulo4, 19) + 1;
            int access$1200 = badiCalendar.day;
            if (badiCalendar.day != 5 || BadiCalendar.isLeapYear(safeCast2, floorDivide3, floorModulo5)) {
                i2 = access$1200;
            }
            return BadiCalendar.ofComplete(safeCast2, floorDivide3, floorModulo5, badiCalendar.getDivision(), i2);
        }

        public long between(BadiCalendar badiCalendar, BadiCalendar badiCalendar2) {
            int i = AnonymousClass4.$SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                return Unit.YEARS.between(badiCalendar, badiCalendar2) / 19;
            }
            if (i == 2) {
                int elapsedYears = elapsedYears(badiCalendar2) - elapsedYears(badiCalendar);
                if (elapsedYears > 0 && badiCalendar2.getDayOfYear() < badiCalendar.getDayOfYear()) {
                    elapsedYears--;
                } else if (elapsedYears < 0 && badiCalendar2.getDayOfYear() > badiCalendar.getDayOfYear()) {
                    elapsedYears++;
                }
                return (long) elapsedYears;
            } else if (i == 3) {
                long elapsedMonths = (long) (elapsedMonths(badiCalendar2) - elapsedMonths(badiCalendar));
                boolean isIntercalaryDay = badiCalendar.isIntercalaryDay();
                int access$1200 = badiCalendar.day;
                if (isIntercalaryDay) {
                    access$1200 += 19;
                }
                boolean isIntercalaryDay2 = badiCalendar2.isIntercalaryDay();
                int access$12002 = badiCalendar2.day;
                if (isIntercalaryDay2) {
                    access$12002 += 19;
                }
                int i2 = (elapsedMonths > 0 ? 1 : (elapsedMonths == 0 ? 0 : -1));
                if (i2 <= 0 || access$12002 >= access$1200) {
                    return (i2 >= 0 || access$12002 <= access$1200) ? elapsedMonths : elapsedMonths + 1;
                }
                return elapsedMonths - 1;
            } else if (i == 4) {
                return Unit.DAYS.between(badiCalendar, badiCalendar2) / 7;
            } else {
                if (i == 5) {
                    return BadiCalendar.CALSYS.transform(badiCalendar2) - BadiCalendar.CALSYS.transform(badiCalendar);
                }
                throw new UnsupportedOperationException(this.unit.name());
            }
        }

        private static int elapsedYears(BadiCalendar badiCalendar) {
            return (((((badiCalendar.major - 1) * 19) + (badiCalendar.cycle - 1)) * 19) + badiCalendar.year) - 1;
        }

        private static int elapsedMonths(BadiCalendar badiCalendar) {
            return ((elapsedYears(badiCalendar) * 19) + (badiCalendar.isIntercalaryDay() ? 18 : badiCalendar.getMonth().getValue())) - 1;
        }
    }

    /* renamed from: net.time4j.calendar.bahai.BadiCalendar$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                net.time4j.calendar.bahai.BadiCalendar$Unit[] r0 = net.time4j.calendar.bahai.BadiCalendar.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit = r0
                net.time4j.calendar.bahai.BadiCalendar$Unit r1 = net.time4j.calendar.bahai.BadiCalendar.Unit.VAHID_CYCLES     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.bahai.BadiCalendar$Unit r1 = net.time4j.calendar.bahai.BadiCalendar.Unit.YEARS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.bahai.BadiCalendar$Unit r1 = net.time4j.calendar.bahai.BadiCalendar.Unit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.bahai.BadiCalendar$Unit r1 = net.time4j.calendar.bahai.BadiCalendar.Unit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$net$time4j$calendar$bahai$BadiCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.calendar.bahai.BadiCalendar$Unit r1 = net.time4j.calendar.bahai.BadiCalendar.Unit.DAYS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.bahai.BadiCalendar.AnonymousClass4.<clinit>():void");
        }
    }
}
