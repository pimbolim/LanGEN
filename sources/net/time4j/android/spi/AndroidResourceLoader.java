package net.time4j.android.spi;

import android.content.Context;
import android.text.format.DateFormat;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import net.time4j.android.AssetLocation;
import net.time4j.base.ResourceLoader;
import net.time4j.calendar.service.GenericTextProviderSPI;
import net.time4j.calendar.service.KoreanExtension;
import net.time4j.engine.ChronoExtension;
import net.time4j.format.DisplayMode;
import net.time4j.format.FormatPatternProvider;
import net.time4j.format.NumberSymbolProvider;
import net.time4j.format.PluralProvider;
import net.time4j.format.TextProvider;
import net.time4j.format.UnitPatternProvider;
import net.time4j.format.WeekdataProvider;
import net.time4j.format.internal.ExtendedPatterns;
import net.time4j.i18n.DefaultPluralProviderSPI;
import net.time4j.i18n.HistoricExtension;
import net.time4j.i18n.IsoTextProviderSPI;
import net.time4j.i18n.SymbolProviderSPI;
import net.time4j.i18n.UnitPatternProviderSPI;
import net.time4j.i18n.WeekdataProviderSPI;
import net.time4j.scale.LeapSecondProvider;
import net.time4j.scale.TickProvider;
import net.time4j.tz.ZoneModelProvider;
import net.time4j.tz.ZoneNameProvider;
import net.time4j.tz.spi.TimezoneRepositoryProviderSPI;
import net.time4j.tz.spi.ZoneNameProviderSPI;
import org.apache.commons.lang3.StringUtils;

public class AndroidResourceLoader extends ResourceLoader {
    private static final Set<String> MODULES;
    private static final Map<Class<?>, Iterable<?>> PROVIDERS;
    private AssetLocation assetLocation = null;
    /* access modifiers changed from: private */
    public Context context = null;
    private List<FormatPatternProvider> patterns = Collections.emptyList();

    private static <T> T cast(Object obj) {
        return obj;
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(TextProvider.class, new LazyTextdata((AnonymousClass1) null));
        hashMap.put(ZoneModelProvider.class, new LazyZoneRules((AnonymousClass1) null));
        hashMap.put(ZoneNameProvider.class, new LazyZoneNames((AnonymousClass1) null));
        hashMap.put(LeapSecondProvider.class, new LazyLeapseconds((AnonymousClass1) null));
        hashMap.put(ChronoExtension.class, new LazyExtensions((AnonymousClass1) null));
        hashMap.put(NumberSymbolProvider.class, new LazyNumberSymbols((AnonymousClass1) null));
        hashMap.put(PluralProvider.class, new LazyPluraldata((AnonymousClass1) null));
        hashMap.put(UnitPatternProvider.class, Collections.singleton(new UnitPatternProviderSPI()));
        hashMap.put(WeekdataProvider.class, new LazyWeekdata((AnonymousClass1) null));
        hashMap.put(TickProvider.class, Collections.singleton(new AndroidTickerSPI()));
        PROVIDERS = Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add("i18n");
        hashSet.add("calendar");
        hashSet.add("olson");
        hashSet.add("tzdata");
        MODULES = Collections.unmodifiableSet(hashSet);
    }

    public void init(Context context2, AssetLocation assetLocation2) {
        Objects.requireNonNull(context2, "Missing Android-context.");
        this.context = context2;
        this.assetLocation = assetLocation2;
        this.patterns = Collections.singletonList(new AndroidFormatPatterns(this, (AnonymousClass1) null));
    }

    public URI locate(String str, Class<?> cls, String str2) {
        try {
            if (MODULES.contains(str)) {
                return new URI("net/time4j/" + str + '/' + str2);
            }
            URL resource = cls.getClassLoader().getResource(str2);
            if (resource != null) {
                return resource.toURI();
            }
            return null;
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public InputStream load(URI uri, boolean z) {
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isAbsolute()) {
                URLConnection openConnection = uri.toURL().openConnection();
                openConnection.setUseCaches(false);
                return openConnection.getInputStream();
            }
            AssetLocation assetLocation2 = this.assetLocation;
            if (assetLocation2 != null) {
                return assetLocation2.open(uri.toString());
            }
            Context context2 = this.context;
            if (context2 != null) {
                return context2.getAssets().open(uri.toString());
            }
            throw new IllegalStateException("'ApplicationStarter.initialize(context)' must be called first at app start.");
        } catch (IOException | RuntimeException unused) {
            return null;
        }
    }

    public <S> Iterable<S> services(Class<S> cls) {
        Object obj = PROVIDERS.get(cls);
        if (obj == null) {
            if (cls != FormatPatternProvider.class) {
                return ServiceLoader.load(cls, cls.getClassLoader());
            }
            obj = this.patterns;
        }
        return (Iterable) cast(obj);
    }

    private class AndroidFormatPatterns implements ExtendedPatterns {
        private AndroidFormatPatterns() {
        }

        /* synthetic */ AndroidFormatPatterns(AndroidResourceLoader androidResourceLoader, AnonymousClass1 r2) {
            this();
        }

        public String getDatePattern(DisplayMode displayMode, Locale locale) {
            return getDelegate().getDatePattern(displayMode, locale);
        }

        public String getTimePattern(DisplayMode displayMode, Locale locale) {
            return getTimePattern(displayMode, locale, false);
        }

        public String getTimePattern(DisplayMode displayMode, Locale locale, boolean z) {
            String timePattern = getDelegate().getTimePattern(displayMode, locale, z);
            if (Locale.getDefault().equals(locale)) {
                boolean z2 = (displayMode != DisplayMode.SHORT ? getDelegate().getTimePattern(DisplayMode.SHORT, locale) : timePattern).indexOf(97) == -1;
                boolean is24HourFormat = DateFormat.is24HourFormat(AndroidResourceLoader.this.context);
                if (is24HourFormat != z2) {
                    if (is24HourFormat) {
                        return to24HourFormat(timePattern).replace("  ", StringUtils.SPACE).trim();
                    }
                    String str = locale.getLanguage().equals("en") ? "b" : "B";
                    int i = AnonymousClass1.$SwitchMap$net$time4j$format$DisplayMode[displayMode.ordinal()];
                    if (i == 1) {
                        return "h:mm:ss " + str + " zzzz";
                    } else if (i == 2) {
                        return "h:mm:ss " + str + " z";
                    } else if (i != 3) {
                        return "h:mm " + str;
                    } else {
                        return "h:mm:ss " + str;
                    }
                }
            }
            return timePattern;
        }

        public String getDateTimePattern(DisplayMode displayMode, DisplayMode displayMode2, Locale locale) {
            return getDelegate().getDateTimePattern(displayMode, displayMode2, locale);
        }

        public String getIntervalPattern(Locale locale) {
            return getDelegate().getIntervalPattern(locale);
        }

        private String to24HourFormat(String str) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt == '\'') {
                    sb.append(charAt);
                    while (true) {
                        i++;
                        if (i >= length) {
                            break;
                        }
                        char charAt2 = str.charAt(i);
                        if (charAt2 == '\'') {
                            sb.append(charAt2);
                            int i2 = i + 1;
                            if (i2 >= length || str.charAt(i2) != '\'') {
                                break;
                            }
                            i = i2;
                        }
                        sb.append(charAt2);
                    }
                } else if (charAt == 'h') {
                    sb.append('H');
                } else if (charAt != 'a') {
                    sb.append(charAt);
                }
                i++;
            }
            return sb.toString();
        }

        private ExtendedPatterns getDelegate() {
            return I18nDataHolder.ISODATA;
        }
    }

    /* renamed from: net.time4j.android.spi.AndroidResourceLoader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$DisplayMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                net.time4j.format.DisplayMode[] r0 = net.time4j.format.DisplayMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$DisplayMode = r0
                net.time4j.format.DisplayMode r1 = net.time4j.format.DisplayMode.FULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$format$DisplayMode     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.DisplayMode r1 = net.time4j.format.DisplayMode.LONG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$format$DisplayMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.format.DisplayMode r1 = net.time4j.format.DisplayMode.MEDIUM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.android.spi.AndroidResourceLoader.AnonymousClass1.<clinit>():void");
        }
    }

    private static final class LazyNumberSymbols implements Iterable<NumberSymbolProvider> {
        private LazyNumberSymbols() {
        }

        /* synthetic */ LazyNumberSymbols(AnonymousClass1 r1) {
            this();
        }

        public Iterator<NumberSymbolProvider> iterator() {
            return I18nDataHolder.SYMBOLS.iterator();
        }
    }

    private static final class LazyWeekdata implements Iterable<WeekdataProvider> {
        private LazyWeekdata() {
        }

        /* synthetic */ LazyWeekdata(AnonymousClass1 r1) {
            this();
        }

        public Iterator<WeekdataProvider> iterator() {
            return I18nDataHolder.WEEKDATA.iterator();
        }
    }

    private static final class LazyTextdata implements Iterable<TextProvider> {
        private LazyTextdata() {
        }

        /* synthetic */ LazyTextdata(AnonymousClass1 r1) {
            this();
        }

        public Iterator<TextProvider> iterator() {
            return I18nDataHolder.TEXTDATA.iterator();
        }
    }

    private static final class LazyZoneRules implements Iterable<ZoneModelProvider> {
        private LazyZoneRules() {
        }

        /* synthetic */ LazyZoneRules(AnonymousClass1 r1) {
            this();
        }

        public Iterator<ZoneModelProvider> iterator() {
            return ZoneDataHolder.RULES.iterator();
        }
    }

    private static final class LazyZoneNames implements Iterable<ZoneNameProvider> {
        private LazyZoneNames() {
        }

        /* synthetic */ LazyZoneNames(AnonymousClass1 r1) {
            this();
        }

        public Iterator<ZoneNameProvider> iterator() {
            return ZoneDataHolder.NAMES.iterator();
        }
    }

    private static final class LazyLeapseconds implements Iterable<LeapSecondProvider> {
        private LazyLeapseconds() {
        }

        /* synthetic */ LazyLeapseconds(AnonymousClass1 r1) {
            this();
        }

        public Iterator<LeapSecondProvider> iterator() {
            return ZoneDataHolder.LEAPSECONDS.iterator();
        }
    }

    private static final class LazyPluraldata implements Iterable<PluralProvider> {
        private LazyPluraldata() {
        }

        /* synthetic */ LazyPluraldata(AnonymousClass1 r1) {
            this();
        }

        public Iterator<PluralProvider> iterator() {
            return StatelessIterables.PLURALS.iterator();
        }
    }

    private static final class LazyExtensions implements Iterable<ChronoExtension> {
        private LazyExtensions() {
        }

        /* synthetic */ LazyExtensions(AnonymousClass1 r1) {
            this();
        }

        public Iterator<ChronoExtension> iterator() {
            return StatelessIterables.EXTENSIONS.iterator();
        }
    }

    private static final class I18nDataHolder {
        /* access modifiers changed from: private */
        public static final IsoTextProviderSPI ISODATA;
        /* access modifiers changed from: private */
        public static final Iterable<NumberSymbolProvider> SYMBOLS = Collections.singleton(SymbolProviderSPI.INSTANCE);
        /* access modifiers changed from: private */
        public static final Iterable<TextProvider> TEXTDATA;
        /* access modifiers changed from: private */
        public static final Iterable<WeekdataProvider> WEEKDATA = Collections.singletonList(new WeekdataProviderSPI());

        private I18nDataHolder() {
        }

        static {
            IsoTextProviderSPI isoTextProviderSPI = new IsoTextProviderSPI();
            ISODATA = isoTextProviderSPI;
            TEXTDATA = Collections.unmodifiableList(Arrays.asList(new TextProvider[]{isoTextProviderSPI, new GenericTextProviderSPI()}));
        }
    }

    private static final class ZoneDataHolder {
        /* access modifiers changed from: private */
        public static final Iterable<LeapSecondProvider> LEAPSECONDS;
        /* access modifiers changed from: private */
        public static final Iterable<ZoneNameProvider> NAMES = Collections.singleton(new ZoneNameProviderSPI());
        /* access modifiers changed from: private */
        public static final Iterable<ZoneModelProvider> RULES;

        private ZoneDataHolder() {
        }

        static {
            LeapSecondProvider leapSecondProvider;
            Set singleton = Collections.singleton(new TimezoneRepositoryProviderSPI());
            RULES = singleton;
            Iterator it = singleton.iterator();
            while (true) {
                if (!it.hasNext()) {
                    leapSecondProvider = null;
                    break;
                }
                ZoneModelProvider zoneModelProvider = (ZoneModelProvider) it.next();
                if (zoneModelProvider instanceof LeapSecondProvider) {
                    leapSecondProvider = LeapSecondProvider.class.cast(zoneModelProvider);
                    break;
                }
            }
            if (leapSecondProvider == null) {
                LEAPSECONDS = Collections.emptyList();
            } else {
                LEAPSECONDS = Collections.singleton(leapSecondProvider);
            }
        }
    }

    private static final class StatelessIterables {
        /* access modifiers changed from: private */
        public static final Iterable<ChronoExtension> EXTENSIONS = Arrays.asList(new ChronoExtension[]{new HistoricExtension(), new KoreanExtension()});
        /* access modifiers changed from: private */
        public static final Iterable<PluralProvider> PLURALS = Collections.singleton(new DefaultPluralProviderSPI());

        private StatelessIterables() {
        }
    }
}
