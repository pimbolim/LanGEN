package net.time4j.history;

import com.adobe.xmp.XMPConst;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.CalendarUnit;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.VariantSource;
import net.time4j.format.Attributes;
import net.time4j.format.TextElement;
import net.time4j.format.expert.Iso8601Format;
import net.time4j.history.internal.HistoricVariant;

public final class ChronoHistory implements VariantSource, Serializable {
    static final int BYZANTINE_YMAX = 999984973;
    private static final long EARLIEST_CUTOVER;
    private static final ChronoHistory INTRODUCTION_BY_POPE_GREGOR;
    static final int JULIAN_YMAX = 999979465;
    private static final Map<String, ChronoHistory> LOOKUP;
    public static final ChronoHistory PROLEPTIC_BYZANTINE = new ChronoHistory(HistoricVariant.PROLEPTIC_BYZANTINE, Collections.singletonList(new CutOverEvent(Long.MIN_VALUE, CalendarAlgorithm.JULIAN, CalendarAlgorithm.JULIAN)), (AncientJulianLeapYears) null, new NewYearStrategy(NewYearRule.BEGIN_OF_SEPTEMBER, Integer.MAX_VALUE), EraPreference.byzantineUntil(PlainDate.axis().getMaximum()));
    public static final ChronoHistory PROLEPTIC_GREGORIAN = new ChronoHistory(HistoricVariant.PROLEPTIC_GREGORIAN, Collections.singletonList(new CutOverEvent(Long.MIN_VALUE, CalendarAlgorithm.GREGORIAN, CalendarAlgorithm.GREGORIAN)));
    public static final ChronoHistory PROLEPTIC_JULIAN;
    private static final ChronoHistory SWEDEN;
    public static final AttributeKey<YearDefinition> YEAR_DEFINITION = Attributes.createKey("YEAR_DEFINITION", YearDefinition.class);
    private static final long serialVersionUID = 4100690610730913643L;
    private final transient AncientJulianLeapYears ajly;
    private final transient ChronoElement<Integer> centuryElement;
    private final transient ChronoElement<HistoricDate> dateElement;
    private final transient TextElement<Integer> dayOfMonthElement;
    private final transient TextElement<Integer> dayOfYearElement;
    private final transient Set<ChronoElement<?>> elements;
    private final transient ChronoElement<HistoricEra> eraElement;
    private final transient EraPreference eraPreference;
    private final transient List<CutOverEvent> events;
    private final transient TextElement<Integer> monthElement;
    private final transient NewYearStrategy nys;
    private final transient HistoricVariant variant;
    private final transient ChronoElement<Integer> yearAfterElement;
    private final transient ChronoElement<Integer> yearBeforeElement;
    private final transient TextElement<Integer> yearOfEraElement;

    static {
        ChronoHistory chronoHistory = new ChronoHistory(HistoricVariant.PROLEPTIC_JULIAN, Collections.singletonList(new CutOverEvent(Long.MIN_VALUE, CalendarAlgorithm.JULIAN, CalendarAlgorithm.JULIAN)));
        PROLEPTIC_JULIAN = chronoHistory;
        long longValue = ((Long) PlainDate.of(1582, 10, 15).get(EpochDays.MODIFIED_JULIAN_DATE)).longValue();
        EARLIEST_CUTOVER = longValue;
        INTRODUCTION_BY_POPE_GREGOR = ofGregorianReform(longValue);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CutOverEvent(-57959, CalendarAlgorithm.JULIAN, CalendarAlgorithm.SWEDISH));
        arrayList.add(new CutOverEvent(-53575, CalendarAlgorithm.SWEDISH, CalendarAlgorithm.JULIAN));
        arrayList.add(new CutOverEvent(-38611, CalendarAlgorithm.JULIAN, CalendarAlgorithm.GREGORIAN));
        ChronoHistory chronoHistory2 = new ChronoHistory(HistoricVariant.SWEDEN, Collections.unmodifiableList(arrayList));
        SWEDEN = chronoHistory2;
        HashMap hashMap = new HashMap();
        PlainDate convert = chronoHistory.convert(HistoricDate.of(HistoricEra.AD, 988, 3, 1));
        PlainDate convert2 = chronoHistory.convert(HistoricDate.of(HistoricEra.AD, 1382, 12, 24));
        PlainDate convert3 = chronoHistory.convert(HistoricDate.of(HistoricEra.AD, 1421, 12, 24));
        PlainDate convert4 = chronoHistory.convert(HistoricDate.of(HistoricEra.AD, 1699, 12, 31));
        hashMap.put("ES", ofFirstGregorianReform().with(NewYearRule.BEGIN_OF_JANUARY.until(1383).and(NewYearRule.CHRISTMAS_STYLE.until(1556))).with(EraPreference.hispanicUntil(convert2)));
        hashMap.put("PT", ofFirstGregorianReform().with(NewYearRule.BEGIN_OF_JANUARY.until(1422).and(NewYearRule.CHRISTMAS_STYLE.until(1556))).with(EraPreference.hispanicUntil(convert3)));
        hashMap.put("FR", ofGregorianReform(PlainDate.of(1582, 12, 20)).with(NewYearRule.EASTER_STYLE.until(1567)));
        hashMap.put("DE", ofFirstGregorianReform().with(NewYearRule.CHRISTMAS_STYLE.until(1544)));
        hashMap.put("DE-BAYERN", ofGregorianReform(PlainDate.of(1583, 10, 16)).with(NewYearRule.CHRISTMAS_STYLE.until(1544)));
        hashMap.put("DE-PREUSSEN", ofGregorianReform(PlainDate.of(1610, 9, 2)).with(NewYearRule.CHRISTMAS_STYLE.until(1559)));
        hashMap.put("DE-PROTESTANT", ofGregorianReform(PlainDate.of(1700, 3, 1)).with(NewYearRule.CHRISTMAS_STYLE.until(1559)));
        hashMap.put("NL", ofGregorianReform(PlainDate.of(1583, 1, 1)));
        hashMap.put("AT", ofGregorianReform(PlainDate.of(1584, 1, 17)));
        hashMap.put("CH", ofGregorianReform(PlainDate.of(1584, 1, 22)));
        hashMap.put("HU", ofGregorianReform(PlainDate.of(1587, 11, 1)));
        hashMap.put("DK", ofGregorianReform(PlainDate.of(1700, 3, 1)).with(NewYearRule.MARIA_ANUNCIATA.until(1623)));
        hashMap.put("NO", ofGregorianReform(PlainDate.of(1700, 3, 1)).with(NewYearRule.MARIA_ANUNCIATA.until(1623)));
        hashMap.put("IT", ofFirstGregorianReform().with(NewYearRule.CHRISTMAS_STYLE.until(1583)));
        hashMap.put("IT-FLORENCE", ofFirstGregorianReform().with(NewYearRule.MARIA_ANUNCIATA.until(1749)));
        hashMap.put("IT-PISA", ofFirstGregorianReform().with(NewYearRule.CALCULUS_PISANUS.until(1749)));
        hashMap.put("IT-VENICE", ofFirstGregorianReform().with(NewYearRule.BEGIN_OF_MARCH.until(1798)));
        hashMap.put("GB", ofGregorianReform(PlainDate.of(1752, 9, 14)).with(NewYearRule.CHRISTMAS_STYLE.until(PhotoshopDirectory.TAG_AUTO_SAVE_FORMAT).and(NewYearRule.BEGIN_OF_JANUARY.until(1155)).and(NewYearRule.MARIA_ANUNCIATA.until(1752))));
        hashMap.put("GB-SCT", ofGregorianReform(PlainDate.of(1752, 9, 14)).with(NewYearRule.CHRISTMAS_STYLE.until(PhotoshopDirectory.TAG_AUTO_SAVE_FORMAT).and(NewYearRule.BEGIN_OF_JANUARY.until(1155)).and(NewYearRule.MARIA_ANUNCIATA.until(1600))));
        hashMap.put("RU", ofGregorianReform(PlainDate.of(1918, 2, 14)).with(NewYearRule.BEGIN_OF_JANUARY.until(988).and(NewYearRule.BEGIN_OF_MARCH.until(1493)).and(NewYearRule.BEGIN_OF_SEPTEMBER.until(1700))).with(EraPreference.byzantineBetween(convert, convert4)));
        hashMap.put("SE", chronoHistory2);
        LOOKUP = Collections.unmodifiableMap(hashMap);
    }

    private ChronoHistory(HistoricVariant historicVariant, List<CutOverEvent> list) {
        this(historicVariant, list, (AncientJulianLeapYears) null, (NewYearStrategy) null, EraPreference.DEFAULT);
    }

    private ChronoHistory(HistoricVariant historicVariant, List<CutOverEvent> list, AncientJulianLeapYears ancientJulianLeapYears, NewYearStrategy newYearStrategy, EraPreference eraPreference2) {
        HistoricVariant historicVariant2 = historicVariant;
        EraPreference eraPreference3 = eraPreference2;
        if (!list.isEmpty()) {
            Objects.requireNonNull(historicVariant2, "Missing historic variant.");
            Objects.requireNonNull(eraPreference3, "Missing era preference.");
            this.variant = historicVariant2;
            this.events = list;
            this.ajly = ancientJulianLeapYears;
            this.nys = newYearStrategy;
            this.eraPreference = eraPreference3;
            HistoricDateElement historicDateElement = new HistoricDateElement(this);
            this.dateElement = historicDateElement;
            HistoricEraElement historicEraElement = new HistoricEraElement(this);
            this.eraElement = historicEraElement;
            HistoricIntegerElement historicIntegerElement = new HistoricIntegerElement('y', 1, 999999999, this, 2);
            this.yearOfEraElement = historicIntegerElement;
            HistoricIntegerElement historicIntegerElement2 = new HistoricIntegerElement(0, 1, 999999999, this, 6);
            this.yearAfterElement = historicIntegerElement2;
            HistoricIntegerElement historicIntegerElement3 = new HistoricIntegerElement(0, 1, 999999999, this, 7);
            this.yearBeforeElement = historicIntegerElement3;
            HistoricIntegerElement historicIntegerElement4 = new HistoricIntegerElement('M', 1, 12, this, 3);
            this.monthElement = historicIntegerElement4;
            HistoricIntegerElement historicIntegerElement5 = new HistoricIntegerElement('d', 1, 31, this, 4);
            this.dayOfMonthElement = historicIntegerElement5;
            HistoricIntegerElement historicIntegerElement6 = new HistoricIntegerElement('D', 1, 365, this, 5);
            this.dayOfYearElement = historicIntegerElement6;
            HistoricIntegerElement historicIntegerElement7 = new HistoricIntegerElement(0, 1, 10000000, this, 8);
            this.centuryElement = historicIntegerElement7;
            HashSet hashSet = new HashSet();
            hashSet.add(historicDateElement);
            hashSet.add(historicEraElement);
            hashSet.add(historicIntegerElement);
            hashSet.add(historicIntegerElement2);
            hashSet.add(historicIntegerElement3);
            hashSet.add(historicIntegerElement4);
            hashSet.add(historicIntegerElement5);
            hashSet.add(historicIntegerElement6);
            hashSet.add(historicIntegerElement7);
            this.elements = Collections.unmodifiableSet(hashSet);
            return;
        }
        throw new IllegalArgumentException("At least one cutover event must be present in chronological history.");
    }

    public static ChronoHistory ofFirstGregorianReform() {
        return INTRODUCTION_BY_POPE_GREGOR;
    }

    public static ChronoHistory ofGregorianReform(PlainDate plainDate) {
        if (plainDate.equals(PlainDate.axis().getMaximum())) {
            return PROLEPTIC_JULIAN;
        }
        if (plainDate.equals(PlainDate.axis().getMinimum())) {
            return PROLEPTIC_GREGORIAN;
        }
        long longValue = ((Long) plainDate.get(EpochDays.MODIFIED_JULIAN_DATE)).longValue();
        check(longValue);
        if (longValue == EARLIEST_CUTOVER) {
            return INTRODUCTION_BY_POPE_GREGOR;
        }
        return ofGregorianReform(longValue);
    }

    public static ChronoHistory of(Locale locale) {
        ChronoHistory chronoHistory;
        String country = locale.getCountry();
        if (!locale.getVariant().isEmpty()) {
            country = country + "-" + locale.getVariant();
            chronoHistory = LOOKUP.get(country);
        } else {
            chronoHistory = null;
        }
        if (chronoHistory == null) {
            chronoHistory = LOOKUP.get(country);
        }
        return chronoHistory == null ? ofFirstGregorianReform() : chronoHistory;
    }

    public static ChronoHistory ofSweden() {
        return SWEDEN;
    }

    public boolean isValid(HistoricDate historicDate) {
        Calculus algorithm;
        if (historicDate == null || isOutOfRange(historicDate) || (algorithm = getAlgorithm(historicDate)) == null || !algorithm.isValid(historicDate)) {
            return false;
        }
        return true;
    }

    public PlainDate convert(HistoricDate historicDate) {
        if (!isOutOfRange(historicDate)) {
            Calculus algorithm = getAlgorithm(historicDate);
            if (algorithm != null) {
                return PlainDate.of(algorithm.toMJD(historicDate), EpochDays.MODIFIED_JULIAN_DATE);
            }
            throw new IllegalArgumentException("Invalid historic date: " + historicDate);
        }
        throw new IllegalArgumentException("Out of supported range: " + historicDate);
    }

    public HistoricDate convert(PlainDate plainDate) {
        HistoricDate historicDate;
        long longValue = ((Long) plainDate.get(EpochDays.MODIFIED_JULIAN_DATE)).longValue();
        int size = this.events.size() - 1;
        while (true) {
            if (size < 0) {
                historicDate = null;
                break;
            }
            CutOverEvent cutOverEvent = this.events.get(size);
            if (longValue >= cutOverEvent.start) {
                historicDate = cutOverEvent.algorithm.fromMJD(longValue);
                break;
            }
            size--;
        }
        if (historicDate == null) {
            historicDate = getJulianAlgorithm().fromMJD(longValue);
        }
        HistoricEra preferredEra = this.eraPreference.getPreferredEra(historicDate, plainDate);
        if (preferredEra != historicDate.getEra()) {
            historicDate = HistoricDate.of(preferredEra, preferredEra.yearOfEra(historicDate.getEra(), historicDate.getYearOfEra()), historicDate.getMonth(), historicDate.getDayOfMonth());
        }
        if (!isOutOfRange(historicDate)) {
            return historicDate;
        }
        throw new IllegalArgumentException("Out of supported range: " + historicDate);
    }

    public static ChronoHistory from(String str) {
        int i;
        ChronoHistory chronoHistory;
        ChronoHistory chronoHistory2;
        if (str.startsWith("historic-")) {
            String[] split = str.substring(9).split(":");
            if (split.length != 0) {
                HistoricVariant valueOf = HistoricVariant.valueOf(split[0]);
                switch (AnonymousClass1.$SwitchMap$net$time4j$history$internal$HistoricVariant[valueOf.ordinal()]) {
                    case 1:
                        return PROLEPTIC_GREGORIAN;
                    case 2:
                        return PROLEPTIC_JULIAN;
                    case 3:
                        return PROLEPTIC_BYZANTINE;
                    case 4:
                        chronoHistory = ofSweden();
                        i = 1;
                        break;
                    case 5:
                        if (getGregorianCutOverDate(split, str).equals(PlainDate.of(1582, 10, 15))) {
                            chronoHistory = ofFirstGregorianReform();
                            break;
                        } else {
                            throw new IllegalArgumentException("Inconsistent cutover date: " + str);
                        }
                    case 6:
                        chronoHistory = ofGregorianReform(getGregorianCutOverDate(split, str));
                        break;
                    default:
                        throw new UnsupportedOperationException(valueOf.name());
                }
                i = 2;
                String[] split2 = split[i].split("=");
                if (split2[0].equals("ancient-julian-leap-years")) {
                    String substring = split2[1].substring(1, split2[1].length() - 1);
                    if (!substring.isEmpty()) {
                        String[] split3 = substring.split(",");
                        int[] iArr = new int[split3.length];
                        for (int i2 = 0; i2 < split3.length; i2++) {
                            iArr[i2] = 1 - Integer.parseInt(split3[i2]);
                        }
                        chronoHistory = chronoHistory.with(AncientJulianLeapYears.of(iArr));
                    }
                }
                String[] split4 = split[i + 1].split("=");
                if (split4[0].equals("new-year-strategy")) {
                    String[] split5 = split4[1].substring(1, split4[1].length() - 1).split(",");
                    NewYearStrategy newYearStrategy = null;
                    for (String split6 : split5) {
                        String[] split7 = split6.split("->");
                        NewYearRule valueOf2 = NewYearRule.valueOf(split7[0]);
                        int parseInt = split7.length == 2 ? Integer.parseInt(split7[1]) : Integer.MAX_VALUE;
                        if (newYearStrategy != null) {
                            newYearStrategy = newYearStrategy.and(valueOf2.until(parseInt));
                        } else if (valueOf2 != NewYearRule.BEGIN_OF_JANUARY || parseInt != 567) {
                            newYearStrategy = valueOf2.until(parseInt);
                        }
                    }
                    chronoHistory = chronoHistory.with(newYearStrategy);
                }
                String[] split8 = split[i + 2].split("=");
                if (!split8[0].equals("era-preference")) {
                    return chronoHistory;
                }
                String substring2 = split8[1].substring(1, split8[1].length() - 1);
                if (substring2.equals("default")) {
                    return chronoHistory;
                }
                String[] split9 = substring2.split(",");
                try {
                    HistoricEra valueOf3 = HistoricEra.valueOf(split9[0].substring(5));
                    PlainDate parseDate = Iso8601Format.parseDate(split9[1].substring(7));
                    PlainDate parseDate2 = Iso8601Format.parseDate(split9[2].substring(5));
                    int i3 = AnonymousClass1.$SwitchMap$net$time4j$history$HistoricEra[valueOf3.ordinal()];
                    if (i3 == 1) {
                        chronoHistory2 = chronoHistory.with(EraPreference.hispanicBetween(parseDate, parseDate2));
                    } else if (i3 == 2) {
                        chronoHistory2 = chronoHistory.with(EraPreference.byzantineBetween(parseDate, parseDate2));
                    } else if (i3 == 3) {
                        chronoHistory2 = chronoHistory.with(EraPreference.abUrbeConditaBetween(parseDate, parseDate2));
                    } else {
                        throw new IllegalArgumentException("BC/AD not allowed as era preference: " + str);
                    }
                    return chronoHistory2;
                } catch (ParseException unused) {
                    throw new IllegalArgumentException("Invalid date syntax: " + str);
                }
            } else {
                throw new IllegalArgumentException("Invalid variant description.");
            }
        } else {
            throw new IllegalArgumentException("Variant does not start with \"historic-\": " + str);
        }
    }

    private static PlainDate getGregorianCutOverDate(String[] strArr, String str) {
        String[] split = strArr[1].split("=");
        if (split.length == 2) {
            if (split[0].equals("cutover")) {
                try {
                    return Iso8601Format.EXTENDED_DATE.parse(split[1]);
                } catch (ParseException unused) {
                }
            }
            throw new IllegalArgumentException("Invalid cutover definition: " + str);
        }
        throw new IllegalArgumentException("Invalid syntax in variant description: " + str);
    }

    public String getVariant() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("historic-");
        sb.append(this.variant.name());
        int i = AnonymousClass1.$SwitchMap$net$time4j$history$internal$HistoricVariant[this.variant.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            sb.append(":no-cutover");
        } else {
            if (i == 5 || i == 6) {
                sb.append(":cutover=");
                sb.append(getGregorianCutOverDate());
            }
            sb.append(":ancient-julian-leap-years=");
            AncientJulianLeapYears ancientJulianLeapYears = this.ajly;
            if (ancientJulianLeapYears != null) {
                int[] pattern = ancientJulianLeapYears.getPattern();
                sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                sb.append(pattern[0]);
                for (int i2 = 1; i2 < pattern.length; i2++) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                    sb.append(pattern[i2]);
                }
                sb.append(AbstractJsonLexerKt.END_LIST);
            } else {
                sb.append(XMPConst.ARRAY_ITEM_NAME);
            }
            sb.append(":new-year-strategy=");
            sb.append(getNewYearStrategy());
            sb.append(":era-preference=");
            sb.append(getEraPreference());
        }
        return sb.toString();
    }

    public PlainDate getGregorianCutOverDate() {
        List<CutOverEvent> list = this.events;
        long j = list.get(list.size() - 1).start;
        if (j != Long.MIN_VALUE) {
            return PlainDate.of(j, EpochDays.MODIFIED_JULIAN_DATE);
        }
        throw new UnsupportedOperationException("Proleptic history without any gregorian reform date.");
    }

    public boolean hasGregorianCutOverDate() {
        List<CutOverEvent> list = this.events;
        return list.get(list.size() - 1).start > Long.MIN_VALUE;
    }

    public HistoricDate getBeginOfYear(HistoricEra historicEra, int i) {
        HistoricDate newYear = getNewYearStrategy().newYear(historicEra, i);
        if (isValid(newYear)) {
            HistoricEra preferredEra = this.eraPreference.getPreferredEra(newYear, convert(newYear));
            return preferredEra != historicEra ? HistoricDate.of(preferredEra, preferredEra.yearOfEra(newYear.getEra(), newYear.getYearOfEra()), newYear.getMonth(), newYear.getDayOfMonth()) : newYear;
        }
        throw new IllegalArgumentException("Cannot determine valid New Year: " + historicEra + "-" + i);
    }

    public int getLengthOfYear(HistoricEra historicEra, int i) {
        HistoricDate historicDate;
        HistoricDate historicDate2;
        try {
            NewYearStrategy newYearStrategy = this.nys;
            int i2 = 1;
            if (newYearStrategy == null) {
                historicDate2 = HistoricDate.of(historicEra, i, 1, 1);
                historicDate = HistoricDate.of(historicEra, i, 12, 31);
            } else {
                historicDate2 = newYearStrategy.newYear(historicEra, i);
                if (historicEra != HistoricEra.BC) {
                    HistoricDate newYear = this.nys.newYear(historicEra, i + 1);
                    if (historicEra == HistoricEra.BYZANTINE) {
                        historicDate = this.nys.newYear(HistoricEra.AD, historicEra.annoDomini(i));
                        if (historicDate.compareTo(historicDate2) > 0) {
                        }
                    }
                    historicDate = newYear;
                } else if (i == 1) {
                    historicDate = this.nys.newYear(HistoricEra.AD, 1);
                } else {
                    historicDate = this.nys.newYear(historicEra, i - 1);
                }
                i2 = 0;
            }
            return (int) (CalendarUnit.DAYS.between(convert(historicDate2), convert(historicDate)) + ((long) i2));
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    public AncientJulianLeapYears getAncientJulianLeapYears() {
        AncientJulianLeapYears ancientJulianLeapYears = this.ajly;
        if (ancientJulianLeapYears != null) {
            return ancientJulianLeapYears;
        }
        throw new UnsupportedOperationException("No historic julian leap years were defined.");
    }

    public boolean hasAncientJulianLeapYears() {
        return this.ajly != null;
    }

    public ChronoHistory with(AncientJulianLeapYears ancientJulianLeapYears) {
        Objects.requireNonNull(ancientJulianLeapYears, "Missing ancient julian leap years.");
        if (!hasGregorianCutOverDate()) {
            return this;
        }
        return new ChronoHistory(this.variant, this.events, ancientJulianLeapYears, this.nys, this.eraPreference);
    }

    public NewYearStrategy getNewYearStrategy() {
        NewYearStrategy newYearStrategy = this.nys;
        return newYearStrategy == null ? NewYearStrategy.DEFAULT : newYearStrategy;
    }

    public ChronoHistory with(NewYearStrategy newYearStrategy) {
        if (newYearStrategy.equals(NewYearStrategy.DEFAULT)) {
            if (this.nys == null) {
                return this;
            }
            return new ChronoHistory(this.variant, this.events, this.ajly, (NewYearStrategy) null, this.eraPreference);
        } else if (!hasGregorianCutOverDate()) {
            return this;
        } else {
            return new ChronoHistory(this.variant, this.events, this.ajly, newYearStrategy, this.eraPreference);
        }
    }

    public ChronoHistory with(EraPreference eraPreference2) {
        return (eraPreference2.equals(this.eraPreference) || !hasGregorianCutOverDate()) ? this : new ChronoHistory(this.variant, this.events, this.ajly, this.nys, eraPreference2);
    }

    public ChronoElement<HistoricDate> date() {
        return this.dateElement;
    }

    @FormattableElement(format = "G")
    public ChronoElement<HistoricEra> era() {
        return this.eraElement;
    }

    @FormattableElement(format = "y")
    public TextElement<Integer> yearOfEra() {
        return this.yearOfEraElement;
    }

    /* renamed from: net.time4j.history.ChronoHistory$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$history$HistoricEra;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$history$YearDefinition;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$history$internal$HistoricVariant;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0068 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0072 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0088 */
        static {
            /*
                net.time4j.history.YearDefinition[] r0 = net.time4j.history.YearDefinition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$history$YearDefinition = r0
                r1 = 1
                net.time4j.history.YearDefinition r2 = net.time4j.history.YearDefinition.DUAL_DATING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$net$time4j$history$YearDefinition     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.history.YearDefinition r3 = net.time4j.history.YearDefinition.AFTER_NEW_YEAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$net$time4j$history$YearDefinition     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.history.YearDefinition r4 = net.time4j.history.YearDefinition.BEFORE_NEW_YEAR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                net.time4j.history.HistoricEra[] r3 = net.time4j.history.HistoricEra.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$net$time4j$history$HistoricEra = r3
                net.time4j.history.HistoricEra r4 = net.time4j.history.HistoricEra.HISPANIC     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r3 = $SwitchMap$net$time4j$history$HistoricEra     // Catch:{ NoSuchFieldError -> 0x0043 }
                net.time4j.history.HistoricEra r4 = net.time4j.history.HistoricEra.BYZANTINE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = $SwitchMap$net$time4j$history$HistoricEra     // Catch:{ NoSuchFieldError -> 0x004d }
                net.time4j.history.HistoricEra r4 = net.time4j.history.HistoricEra.AB_URBE_CONDITA     // Catch:{ NoSuchFieldError -> 0x004d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                net.time4j.history.internal.HistoricVariant[] r3 = net.time4j.history.internal.HistoricVariant.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$net$time4j$history$internal$HistoricVariant = r3
                net.time4j.history.internal.HistoricVariant r4 = net.time4j.history.internal.HistoricVariant.PROLEPTIC_GREGORIAN     // Catch:{ NoSuchFieldError -> 0x005e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r1 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x0068 }
                net.time4j.history.internal.HistoricVariant r3 = net.time4j.history.internal.HistoricVariant.PROLEPTIC_JULIAN     // Catch:{ NoSuchFieldError -> 0x0068 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0068 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0068 }
            L_0x0068:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x0072 }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.PROLEPTIC_BYZANTINE     // Catch:{ NoSuchFieldError -> 0x0072 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0072 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0072 }
            L_0x0072:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x007d }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.SWEDEN     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x0088 }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.INTRODUCTION_ON_1582_10_15     // Catch:{ NoSuchFieldError -> 0x0088 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0088 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0088 }
            L_0x0088:
                int[] r0 = $SwitchMap$net$time4j$history$internal$HistoricVariant     // Catch:{ NoSuchFieldError -> 0x0093 }
                net.time4j.history.internal.HistoricVariant r1 = net.time4j.history.internal.HistoricVariant.SINGLE_CUTOVER_DATE     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.history.ChronoHistory.AnonymousClass1.<clinit>():void");
        }
    }

    public ChronoElement<Integer> yearOfEra(YearDefinition yearDefinition) {
        int i = AnonymousClass1.$SwitchMap$net$time4j$history$YearDefinition[yearDefinition.ordinal()];
        if (i == 1) {
            return this.yearOfEraElement;
        }
        if (i == 2) {
            return this.yearAfterElement;
        }
        if (i == 3) {
            return this.yearBeforeElement;
        }
        throw new UnsupportedOperationException(yearDefinition.name());
    }

    public ChronoElement<Integer> centuryOfEra() {
        return this.centuryElement;
    }

    @FormattableElement(alt = "L", format = "M")
    public TextElement<Integer> month() {
        return this.monthElement;
    }

    @FormattableElement(format = "d")
    public ChronoElement<Integer> dayOfMonth() {
        return this.dayOfMonthElement;
    }

    @FormattableElement(format = "D")
    public ChronoElement<Integer> dayOfYear() {
        return this.dayOfYearElement;
    }

    public Set<ChronoElement<?>> getElements() {
        return this.elements;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronoHistory) {
            ChronoHistory chronoHistory = (ChronoHistory) obj;
            if (this.variant == chronoHistory.variant && isEqual(this.ajly, chronoHistory.ajly) && isEqual(this.nys, chronoHistory.nys) && this.eraPreference.equals(chronoHistory.eraPreference)) {
                if (this.variant != HistoricVariant.SINGLE_CUTOVER_DATE || this.events.get(0).start == chronoHistory.events.get(0).start) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.variant != HistoricVariant.SINGLE_CUTOVER_DATE) {
            return this.variant.hashCode();
        }
        long j = this.events.get(0).start;
        return (int) (j ^ (j << 32));
    }

    public String toString() {
        return "ChronoHistory[" + getVariant() + "]";
    }

    /* access modifiers changed from: package-private */
    public Calculus getAlgorithm(HistoricDate historicDate) {
        for (int size = this.events.size() - 1; size >= 0; size--) {
            CutOverEvent cutOverEvent = this.events.get(size);
            if (historicDate.compareTo(cutOverEvent.dateAtCutOver) >= 0) {
                return cutOverEvent.algorithm;
            }
            if (historicDate.compareTo(cutOverEvent.dateBeforeCutOver) > 0) {
                return null;
            }
        }
        return getJulianAlgorithm();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r0.getMaximumDayOfMonth(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.history.HistoricDate adjustDayOfMonth(net.time4j.history.HistoricDate r4) {
        /*
            r3 = this;
            net.time4j.history.Calculus r0 = r3.getAlgorithm(r4)
            if (r0 != 0) goto L_0x0007
            return r4
        L_0x0007:
            int r0 = r0.getMaximumDayOfMonth(r4)
            int r1 = r4.getDayOfMonth()
            if (r0 >= r1) goto L_0x0021
            net.time4j.history.HistoricEra r1 = r4.getEra()
            int r2 = r4.getYearOfEra()
            int r4 = r4.getMonth()
            net.time4j.history.HistoricDate r4 = net.time4j.history.HistoricDate.of(r1, r2, r4, r0)
        L_0x0021:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.history.ChronoHistory.adjustDayOfMonth(net.time4j.history.HistoricDate):net.time4j.history.HistoricDate");
    }

    /* access modifiers changed from: package-private */
    public List<CutOverEvent> getEvents() {
        return this.events;
    }

    /* access modifiers changed from: package-private */
    public HistoricVariant getHistoricVariant() {
        return this.variant;
    }

    /* access modifiers changed from: package-private */
    public EraPreference getEraPreference() {
        return this.eraPreference;
    }

    private boolean isOutOfRange(HistoricDate historicDate) {
        int annoDomini = historicDate.getEra().annoDomini(historicDate.getYearOfEra());
        if (this == PROLEPTIC_BYZANTINE) {
            if (annoDomini < -5508 || ((annoDomini == -5508 && historicDate.getMonth() < 9) || annoDomini > JULIAN_YMAX)) {
                return true;
            }
            return false;
        } else if (this == PROLEPTIC_JULIAN) {
            if (Math.abs(annoDomini) > JULIAN_YMAX) {
                return true;
            }
            return false;
        } else if (this == PROLEPTIC_GREGORIAN) {
            if (Math.abs(annoDomini) > 999999999) {
                return true;
            }
            return false;
        } else if (annoDomini < -44 || annoDomini > 9999) {
            return true;
        } else {
            return false;
        }
    }

    private Calculus getJulianAlgorithm() {
        AncientJulianLeapYears ancientJulianLeapYears = this.ajly;
        if (ancientJulianLeapYears != null) {
            return ancientJulianLeapYears.getCalculus();
        }
        return CalendarAlgorithm.JULIAN;
    }

    private static boolean isEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static void check(long j) {
        if (j < EARLIEST_CUTOVER) {
            throw new IllegalArgumentException("Gregorian calendar did not exist before 1582-10-15");
        }
    }

    private static ChronoHistory ofGregorianReform(long j) {
        return new ChronoHistory(j == EARLIEST_CUTOVER ? HistoricVariant.INTRODUCTION_ON_1582_10_15 : HistoricVariant.SINGLE_CUTOVER_DATE, Collections.singletonList(new CutOverEvent(j, CalendarAlgorithm.JULIAN, CalendarAlgorithm.GREGORIAN)));
    }

    private Object writeReplace() {
        return new SPX(this, 3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
