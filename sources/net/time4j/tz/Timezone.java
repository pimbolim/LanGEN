package net.time4j.tz;

import android.util.TimeUtils;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.base.GregorianDate;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import org.apache.commons.lang3.time.TimeZones;

public abstract class Timezone implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final boolean ALLOW_SYSTEM_TZ_OVERRIDE;
    private static final boolean ANDROID;
    /* access modifiers changed from: private */
    public static final ConcurrentMap<String, NamedReference> CACHE = new ConcurrentHashMap();
    public static final TransitionStrategy DEFAULT_CONFLICT_STRATEGY = GapResolver.PUSH_FORWARD.and(OverlapResolver.LATER_OFFSET);
    /* access modifiers changed from: private */
    public static final ZoneModelProvider DEFAULT_PROVIDER;
    private static final Map<String, TZID> ETCETERA;
    /* access modifiers changed from: private */
    public static final Comparator<TZID> ID_COMPARATOR = new Comparator<TZID>() {
        public int compare(TZID tzid, TZID tzid2) {
            return tzid.canonical().compareTo(tzid2.canonical());
        }
    };
    /* access modifiers changed from: private */
    public static final LinkedList<Timezone> LAST_USED = new LinkedList<>();
    private static final String NAME_DEFAULT = "DEFAULT";
    private static final String NAME_JUT = "java.util.TimeZone";
    static final ZoneNameProvider NAME_PROVIDER;
    private static final String NAME_TZDB = "TZDB";
    private static final String NEW_LINE = System.getProperty("line.separator");
    /* access modifiers changed from: private */
    public static final ZoneModelProvider PLATFORM_PROVIDER;
    private static final Map<String, TZID> PREDEFINED;
    /* access modifiers changed from: private */
    public static final ConcurrentMap<String, ZoneModelProvider> PROVIDERS = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public static final ReferenceQueue<Timezone> QUEUE = new ReferenceQueue<>();
    private static final String REPOSITORY_VERSION = System.getProperty("net.time4j.tz.repository.version");
    public static final TransitionStrategy STRICT_MODE = GapResolver.ABORT.and(OverlapResolver.LATER_OFFSET);
    private static final Timezone SYSTEM_TZ_ORIGINAL;
    /* access modifiers changed from: private */
    public static volatile boolean cacheActive = true;
    /* access modifiers changed from: private */
    public static volatile Timezone currentSystemTZ;
    /* access modifiers changed from: private */
    public static int softLimit = 11;
    /* access modifiers changed from: private */
    public static volatile ZonalKeys zonalKeys;

    public abstract ZonalOffset getDaylightSavingOffset(UnixTime unixTime);

    public abstract TransitionHistory getHistory();

    public abstract TZID getID();

    public abstract ZonalOffset getOffset(GregorianDate gregorianDate, WallTime wallTime);

    public abstract ZonalOffset getOffset(UnixTime unixTime);

    public abstract ZonalOffset getStandardOffset(UnixTime unixTime);

    public abstract TransitionStrategy getStrategy();

    public abstract boolean isDaylightSaving(UnixTime unixTime);

    public abstract boolean isFixed();

    public abstract boolean isInvalid(GregorianDate gregorianDate, WallTime wallTime);

    public abstract Timezone with(TransitionStrategy transitionStrategy);

    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01b9  */
    static {
        /*
            java.lang.String r0 = "line.separator"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            NEW_LINE = r0
            java.lang.String r0 = "net.time4j.tz.repository.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            REPOSITORY_VERSION = r0
            net.time4j.tz.Timezone$1 r0 = new net.time4j.tz.Timezone$1
            r0.<init>()
            ID_COMPARATOR = r0
            net.time4j.tz.GapResolver r0 = net.time4j.tz.GapResolver.PUSH_FORWARD
            net.time4j.tz.OverlapResolver r1 = net.time4j.tz.OverlapResolver.LATER_OFFSET
            net.time4j.tz.TransitionStrategy r0 = r0.and(r1)
            DEFAULT_CONFLICT_STRATEGY = r0
            net.time4j.tz.GapResolver r0 = net.time4j.tz.GapResolver.ABORT
            net.time4j.tz.OverlapResolver r1 = net.time4j.tz.OverlapResolver.LATER_OFFSET
            net.time4j.tz.TransitionStrategy r0 = r0.and(r1)
            STRICT_MODE = r0
            java.lang.String r0 = "java.vm.name"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            java.lang.String r1 = "Dalvik"
            boolean r0 = r1.equalsIgnoreCase(r0)
            ANDROID = r0
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0048
            java.lang.String r0 = "net.time4j.allow.system.tz.override"
            boolean r0 = java.lang.Boolean.getBoolean(r0)
            if (r0 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r0 = 0
            goto L_0x0049
        L_0x0048:
            r0 = 1
        L_0x0049:
            ALLOW_SYSTEM_TZ_OVERRIDE = r0
            r0 = 0
            zonalKeys = r0
            currentSystemTZ = r0
            cacheActive = r2
            r2 = 11
            softLimit = r2
            java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap
            r2.<init>()
            CACHE = r2
            java.util.concurrent.ConcurrentHashMap r2 = new java.util.concurrent.ConcurrentHashMap
            r2.<init>()
            PROVIDERS = r2
            java.lang.ref.ReferenceQueue r2 = new java.lang.ref.ReferenceQueue
            r2.<init>()
            QUEUE = r2
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            LAST_USED = r2
            java.lang.Class<net.time4j.tz.Timezone> r2 = net.time4j.tz.Timezone.class
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x009b }
            java.lang.String r3 = "AFRICA"
            java.lang.String r4 = "AMERICA"
            java.lang.String r5 = "AMERICA$ARGENTINA"
            java.lang.String r6 = "AMERICA$INDIANA"
            java.lang.String r7 = "AMERICA$KENTUCKY"
            java.lang.String r8 = "AMERICA$NORTH_DAKOTA"
            java.lang.String r9 = "ANTARCTICA"
            java.lang.String r10 = "ASIA"
            java.lang.String r11 = "ATLANTIC"
            java.lang.String r12 = "AUSTRALIA"
            java.lang.String r13 = "EUROPE"
            java.lang.String r14 = "INDIAN"
            java.lang.String r15 = "PACIFIC"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15}     // Catch:{ ClassNotFoundException -> 0x009b }
            java.util.List r2 = loadPredefined(r2, r3)     // Catch:{ ClassNotFoundException -> 0x009b }
            goto L_0x009f
        L_0x009b:
            java.util.List r2 = java.util.Collections.emptyList()
        L_0x009f:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            net.time4j.tz.ZonalOffset r4 = net.time4j.tz.ZonalOffset.UTC
            java.lang.String r5 = "Z"
            r3.put(r5, r4)
            net.time4j.tz.ZonalOffset r4 = net.time4j.tz.ZonalOffset.UTC
            java.lang.String r6 = "UT"
            r3.put(r6, r4)
            net.time4j.tz.ZonalOffset r4 = net.time4j.tz.ZonalOffset.UTC
            java.lang.String r6 = "UTC"
            r3.put(r6, r4)
            net.time4j.tz.ZonalOffset r4 = net.time4j.tz.ZonalOffset.UTC
            java.lang.String r7 = "GMT"
            r3.put(r7, r4)
            net.time4j.tz.ZonalOffset r4 = net.time4j.tz.ZonalOffset.UTC
            java.lang.String r7 = "UTC0"
            r3.put(r7, r4)
            net.time4j.tz.ZonalOffset r4 = net.time4j.tz.ZonalOffset.UTC
            java.lang.String r7 = "GMT0"
            r3.put(r7, r4)
            java.util.Iterator r2 = r2.iterator()
        L_0x00d2:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00f4
            java.lang.Object r4 = r2.next()
            java.lang.Class r4 = (java.lang.Class) r4
            java.lang.Object[] r4 = r4.getEnumConstants()
            net.time4j.tz.TZID[] r4 = (net.time4j.tz.TZID[]) r4
            int r7 = r4.length
            r8 = 0
        L_0x00e6:
            if (r8 >= r7) goto L_0x00d2
            r9 = r4[r8]
            java.lang.String r10 = r9.canonical()
            r3.put(r10, r9)
            int r8 = r8 + 1
            goto L_0x00e6
        L_0x00f4:
            java.util.Map r2 = java.util.Collections.unmodifiableMap(r3)
            PREDEFINED = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            fillEtcetera(r2)
            java.util.Map r2 = java.util.Collections.unmodifiableMap(r2)
            ETCETERA = r2
            net.time4j.base.ResourceLoader r2 = net.time4j.base.ResourceLoader.getInstance()
            java.lang.Class<net.time4j.tz.ZoneModelProvider> r3 = net.time4j.tz.ZoneModelProvider.class
            java.lang.Iterable r2 = r2.services(r3)
            java.util.Iterator r2 = r2.iterator()
            r3 = r0
        L_0x0117:
            boolean r4 = r2.hasNext()
            java.lang.String r7 = "TZDB"
            if (r4 == 0) goto L_0x0148
            java.lang.Object r4 = r2.next()
            net.time4j.tz.ZoneModelProvider r4 = (net.time4j.tz.ZoneModelProvider) r4
            java.lang.String r8 = r4.getName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0134
            net.time4j.tz.ZoneModelProvider r3 = compareTZDB(r4, r3)
            goto L_0x0117
        L_0x0134:
            boolean r7 = r8.isEmpty()
            if (r7 != 0) goto L_0x0117
            java.lang.String r7 = "DEFAULT"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L_0x0117
            java.util.concurrent.ConcurrentMap<java.lang.String, net.time4j.tz.ZoneModelProvider> r7 = PROVIDERS
            r7.put(r8, r4)
            goto L_0x0117
        L_0x0148:
            net.time4j.base.ResourceLoader r2 = net.time4j.base.ResourceLoader.getInstance()
            java.lang.Class<net.time4j.tz.ZoneNameProvider> r4 = net.time4j.tz.ZoneNameProvider.class
            java.lang.Iterable r2 = r2.services(r4)
            java.util.Iterator r2 = r2.iterator()
            r4 = r0
        L_0x0157:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0164
            java.lang.Object r4 = r2.next()
            net.time4j.tz.ZoneNameProvider r4 = (net.time4j.tz.ZoneNameProvider) r4
            goto L_0x0157
        L_0x0164:
            net.time4j.tz.Timezone$PlatformZoneProvider r2 = new net.time4j.tz.Timezone$PlatformZoneProvider
            r2.<init>()
            PLATFORM_PROVIDER = r2
            if (r4 != 0) goto L_0x0171
            net.time4j.tz.ZoneNameProvider r4 = r2.getSpecificZoneNameRepository()
        L_0x0171:
            NAME_PROVIDER = r4
            java.util.concurrent.ConcurrentMap<java.lang.String, net.time4j.tz.ZoneModelProvider> r4 = PROVIDERS
            java.lang.String r8 = "java.util.TimeZone"
            r4.put(r8, r2)
            if (r3 != 0) goto L_0x017f
            DEFAULT_PROVIDER = r2
            goto L_0x0184
        L_0x017f:
            r4.put(r7, r3)
            DEFAULT_PROVIDER = r3
        L_0x0184:
            java.lang.String r2 = "user.timezone"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{ SecurityException -> 0x01a9 }
            boolean r3 = r5.equals(r2)     // Catch:{ SecurityException -> 0x01a9 }
            if (r3 != 0) goto L_0x01a2
            boolean r3 = r6.equals(r2)     // Catch:{ SecurityException -> 0x01a9 }
            if (r3 == 0) goto L_0x0197
            goto L_0x01a2
        L_0x0197:
            if (r2 == 0) goto L_0x01aa
            net.time4j.tz.TZID r3 = resolve(r2)     // Catch:{ SecurityException -> 0x01a9 }
            net.time4j.tz.Timezone r0 = getTZ(r3, r2, r1)     // Catch:{ SecurityException -> 0x01a9 }
            goto L_0x01aa
        L_0x01a2:
            net.time4j.tz.ZonalOffset r1 = net.time4j.tz.ZonalOffset.UTC     // Catch:{ SecurityException -> 0x01a9 }
            net.time4j.tz.SingleOffsetTimezone r0 = r1.getModel()     // Catch:{ SecurityException -> 0x01a9 }
            goto L_0x01aa
        L_0x01a9:
        L_0x01aa:
            if (r0 != 0) goto L_0x01b3
            net.time4j.tz.Timezone r0 = getDefaultTZ()
            SYSTEM_TZ_ORIGINAL = r0
            goto L_0x01b5
        L_0x01b3:
            SYSTEM_TZ_ORIGINAL = r0
        L_0x01b5:
            boolean r0 = ALLOW_SYSTEM_TZ_OVERRIDE
            if (r0 == 0) goto L_0x01bd
            net.time4j.tz.Timezone r0 = SYSTEM_TZ_ORIGINAL
            currentSystemTZ = r0
        L_0x01bd:
            net.time4j.tz.Timezone$ZonalKeys r0 = new net.time4j.tz.Timezone$ZonalKeys
            r0.<init>()
            zonalKeys = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.Timezone.<clinit>():void");
    }

    Timezone() {
    }

    public static List<TZID> getAvailableIDs() {
        return zonalKeys.availables;
    }

    public static List<TZID> getAvailableIDs(String str) {
        if (str.equals("INCLUDE_ALIAS")) {
            return zonalKeys.availablesAndAliases;
        }
        ZoneModelProvider provider = getProvider(str);
        if (provider == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String resolve : provider.getAvailableIDs()) {
            arrayList.add(resolve(resolve));
        }
        Collections.sort(arrayList, ID_COMPARATOR);
        return Collections.unmodifiableList(arrayList);
    }

    public static Set<TZID> getPreferredIDs(Locale locale, boolean z, String str) {
        ZoneModelProvider provider = getProvider(str);
        if (provider == null) {
            return Collections.emptySet();
        }
        ZoneNameProvider specificZoneNameRepository = provider.getSpecificZoneNameRepository();
        if (specificZoneNameRepository == null) {
            specificZoneNameRepository = NAME_PROVIDER;
        }
        HashSet hashSet = new HashSet();
        for (String resolve : specificZoneNameRepository.getPreferredIDs(locale, z)) {
            hashSet.add(resolve(resolve));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static Timezone ofSystem() {
        if (!ALLOW_SYSTEM_TZ_OVERRIDE || currentSystemTZ == null) {
            return SYSTEM_TZ_ORIGINAL;
        }
        return currentSystemTZ;
    }

    public static Timezone ofPlatform() {
        return new PlatformTimezone();
    }

    public static Timezone of(TZID tzid) {
        return getTZ(tzid, true);
    }

    public static Timezone of(String str) {
        return getTZ((TZID) null, str, true);
    }

    public static Timezone of(String str, TZID tzid) {
        Timezone tz = getTZ((TZID) null, str, false);
        if (tz != null) {
            return tz;
        }
        Timezone tz2 = getTZ(tzid, false);
        return tz2 == null ? ofSystem() : tz2;
    }

    public static Timezone of(String str, TransitionHistory transitionHistory) {
        return new HistorizedTimezone(resolve(str), transitionHistory);
    }

    public static TZID normalize(TZID tzid) {
        return normalize(tzid.canonical());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: net.time4j.tz.ZoneModelProvider} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.time4j.tz.TZID normalize(java.lang.String r6) {
        /*
            int r0 = r6.length()
            r1 = 0
            r2 = 0
        L_0x0006:
            r3 = 1
            if (r2 >= r0) goto L_0x001e
            char r4 = r6.charAt(r2)
            r5 = 126(0x7e, float:1.77E-43)
            if (r4 != r5) goto L_0x001b
            java.lang.String r0 = r6.substring(r1, r2)
            int r2 = r2 + r3
            java.lang.String r2 = r6.substring(r2)
            goto L_0x0021
        L_0x001b:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x001e:
            java.lang.String r0 = ""
            r2 = r6
        L_0x0021:
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L_0x0099
            net.time4j.tz.ZoneModelProvider r4 = DEFAULT_PROVIDER
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x0037
            java.lang.String r5 = "DEFAULT"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x0038
        L_0x0037:
            r1 = 1
        L_0x0038:
            if (r1 != 0) goto L_0x0077
            java.lang.String r1 = "WINDOWS"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0077
            java.lang.String r1 = "MILITARY"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0077
            java.util.concurrent.ConcurrentMap<java.lang.String, net.time4j.tz.ZoneModelProvider> r1 = PROVIDERS
            java.lang.Object r1 = r1.get(r0)
            r4 = r1
            net.time4j.tz.ZoneModelProvider r4 = (net.time4j.tz.ZoneModelProvider) r4
            if (r4 != 0) goto L_0x0077
            java.lang.String r1 = "TZDB"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0060
            java.lang.String r0 = "TZDB provider not available: "
            goto L_0x0062
        L_0x0060:
            java.lang.String r0 = "Timezone model provider not registered: "
        L_0x0062:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r1.<init>(r6)
            throw r1
        L_0x0077:
            java.util.Map r6 = r4.getAliases()
        L_0x007b:
            java.lang.Object r0 = r6.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0085
            r2 = r0
            goto L_0x007b
        L_0x0085:
            java.util.Map<java.lang.String, net.time4j.tz.TZID> r6 = ETCETERA
            boolean r0 = r6.containsKey(r2)
            if (r0 == 0) goto L_0x0094
            java.lang.Object r6 = r6.get(r2)
            net.time4j.tz.TZID r6 = (net.time4j.tz.TZID) r6
            return r6
        L_0x0094:
            net.time4j.tz.TZID r6 = resolve(r2)
            return r6
        L_0x0099:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Empty zone identifier: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.Timezone.normalize(java.lang.String):net.time4j.tz.TZID");
    }

    public static String getProviderInfo() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(Timezone.class.getName());
        sb.append(":[default-provider=");
        sb.append(DEFAULT_PROVIDER.getName());
        sb.append(", registered={");
        for (String str : PROVIDERS.keySet()) {
            ZoneModelProvider zoneModelProvider = (ZoneModelProvider) PROVIDERS.get(str);
            if (zoneModelProvider != null) {
                sb.append("(name=");
                sb.append(zoneModelProvider.getName());
                String location = zoneModelProvider.getLocation();
                if (!location.isEmpty()) {
                    sb.append(",location=");
                    sb.append(location);
                }
                String version = zoneModelProvider.getVersion();
                if (!version.isEmpty()) {
                    sb.append(",version=");
                    sb.append(version);
                }
                sb.append(')');
            }
        }
        sb.append("}]");
        return sb.toString();
    }

    public static String getVersion(String str) {
        ZoneModelProvider provider = getProvider(str);
        if (provider == null) {
            return "";
        }
        return provider.getVersion();
    }

    public static Set<String> getRegisteredProviders() {
        return Collections.unmodifiableSet(PROVIDERS.keySet());
    }

    public String getDisplayName(NameStyle nameStyle, Locale locale) {
        return getDisplayName(getID(), nameStyle, locale);
    }

    public static String getDisplayName(TZID tzid, NameStyle nameStyle, Locale locale) {
        String str;
        String canonical = tzid.canonical();
        int indexOf = canonical.indexOf(126);
        ZoneModelProvider zoneModelProvider = DEFAULT_PROVIDER;
        if (indexOf >= 0) {
            String substring = canonical.substring(0, indexOf);
            if (!substring.equals(NAME_DEFAULT) && (zoneModelProvider = (ZoneModelProvider) PROVIDERS.get(substring)) == null) {
                return canonical;
            }
            str = canonical.substring(indexOf + 1);
        } else {
            str = canonical;
        }
        ZoneNameProvider specificZoneNameRepository = zoneModelProvider.getSpecificZoneNameRepository();
        if (specificZoneNameRepository == null) {
            specificZoneNameRepository = NAME_PROVIDER;
        }
        String displayName = specificZoneNameRepository.getDisplayName(str, nameStyle, locale);
        if (!displayName.isEmpty()) {
            return displayName;
        }
        ZoneNameProvider zoneNameProvider = NAME_PROVIDER;
        if (specificZoneNameRepository != zoneNameProvider) {
            displayName = zoneNameProvider.getDisplayName(str, nameStyle, locale);
        }
        if (!displayName.isEmpty()) {
            canonical = displayName;
        }
        return canonical;
    }

    public static boolean registerProvider(ZoneModelProvider zoneModelProvider) {
        String name = zoneModelProvider.getName();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Missing name of zone model provider.");
        } else if (name.equals(NAME_TZDB)) {
            throw new IllegalArgumentException("TZDB provider cannot be registered after startup.");
        } else if (name.equals(NAME_JUT)) {
            throw new IllegalArgumentException("Platform provider cannot be replaced.");
        } else if (!name.equals(NAME_DEFAULT)) {
            boolean z = PROVIDERS.putIfAbsent(name, zoneModelProvider) == null;
            if (z) {
                zonalKeys = new ZonalKeys();
            }
            return z;
        } else {
            throw new IllegalArgumentException("Default zone model provider cannot be overridden.");
        }
    }

    public void dump(Appendable appendable) throws IOException {
        StringBuilder sb = new StringBuilder(4096);
        sb.append("Start Of Dump =>");
        String str = NEW_LINE;
        sb.append(str);
        sb.append("*** Timezone-ID:");
        sb.append(str);
        sb.append(">>> ");
        sb.append(getID().canonical());
        sb.append(str);
        if (isFixed()) {
            sb.append("*** Fixed offset:");
            sb.append(str);
            sb.append(">>> ");
            sb.append(getHistory().getInitialOffset());
            sb.append(str);
        } else {
            sb.append("*** Strategy:");
            sb.append(str);
            sb.append(">>> ");
            sb.append(getStrategy());
            sb.append(str);
            TransitionHistory history = getHistory();
            sb.append("*** History:");
            sb.append(str);
            if (history == null) {
                sb.append(">>> Not public!");
                sb.append(str);
            } else {
                history.dump(sb);
            }
        }
        sb.append("<= End Of Dump");
        sb.append(str);
        appendable.append(sb.toString());
    }

    /* access modifiers changed from: private */
    public static Timezone getDefaultTZ() {
        String id = TimeZone.getDefault().getID();
        Timezone tz = getTZ((TZID) null, id, false);
        return tz == null ? new PlatformTimezone(new NamedID(id)) : tz;
    }

    private static Timezone getTZ(TZID tzid, boolean z) {
        if (tzid instanceof ZonalOffset) {
            return ((ZonalOffset) tzid).getModel();
        }
        return getTZ(tzid, tzid.canonical(), z);
    }

    private static Timezone getTZ(TZID tzid, String str, boolean z) {
        Timezone timezone;
        String str2;
        ConcurrentMap<String, NamedReference> concurrentMap = CACHE;
        NamedReference namedReference = (NamedReference) concurrentMap.get(str);
        if (namedReference != null) {
            timezone = (Timezone) namedReference.get();
            if (timezone == null) {
                concurrentMap.remove(namedReference.tzid);
            }
        } else {
            timezone = null;
        }
        if (timezone != null) {
            return timezone;
        }
        String str3 = "";
        int length = str.length();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                str2 = str;
                break;
            } else if (str.charAt(i) == '~') {
                str3 = str.substring(0, i);
                str2 = str.substring(i + 1);
                break;
            } else {
                i++;
            }
        }
        if (!str2.isEmpty()) {
            ZoneModelProvider zoneModelProvider = DEFAULT_PROVIDER;
            if (str3.isEmpty() || str3.equals(NAME_DEFAULT)) {
                z2 = true;
            }
            if (z2 || (zoneModelProvider = (ZoneModelProvider) PROVIDERS.get(str3)) != null) {
                if (tzid == null) {
                    if (z2) {
                        tzid = resolve(str2);
                        if (tzid instanceof ZonalOffset) {
                            return ((ZonalOffset) tzid).getModel();
                        }
                    } else {
                        tzid = new NamedID(str);
                    }
                }
                if (zoneModelProvider == PLATFORM_PROVIDER) {
                    PlatformTimezone platformTimezone = new PlatformTimezone(tzid, str2);
                    if (!platformTimezone.isGMT() || str2.equals(TimeZones.GMT_ID) || str2.startsWith("UT") || str2.equals("Z")) {
                        timezone = platformTimezone;
                    }
                } else {
                    TransitionHistory load = zoneModelProvider.load(str2);
                    if (load == null) {
                        timezone = getZoneByAlias(zoneModelProvider, tzid, str2);
                    } else {
                        timezone = new HistorizedTimezone(tzid, load);
                    }
                }
                if (timezone == null) {
                    if (!z) {
                        return null;
                    }
                    if (TimeZone.getDefault().getID().equals(str)) {
                        return new PlatformTimezone(new NamedID(str));
                    }
                    throw new IllegalArgumentException("Unknown timezone: " + str);
                } else if (!cacheActive) {
                    return timezone;
                } else {
                    NamedReference putIfAbsent = CACHE.putIfAbsent(str, new NamedReference(timezone, QUEUE));
                    if (putIfAbsent == null) {
                        synchronized (Timezone.class) {
                            LAST_USED.addFirst(timezone);
                            while (true) {
                                LinkedList<Timezone> linkedList = LAST_USED;
                                if (linkedList.size() >= softLimit) {
                                    linkedList.removeLast();
                                }
                            }
                        }
                        return timezone;
                    }
                    Timezone timezone2 = (Timezone) putIfAbsent.get();
                    return timezone2 != null ? timezone2 : timezone;
                }
            } else if (!z) {
                return null;
            } else {
                throw new IllegalArgumentException((str3.equals(NAME_TZDB) ? "TZDB provider not available: " : "Timezone model provider not registered: ") + str);
            }
        } else if (!z) {
            return null;
        } else {
            throw new IllegalArgumentException("Timezone key is empty.");
        }
    }

    private static Timezone getZoneByAlias(ZoneModelProvider zoneModelProvider, TZID tzid, String str) {
        Map<String, String> aliases = zoneModelProvider.getAliases();
        String str2 = str;
        TransitionHistory transitionHistory = null;
        while (transitionHistory == null) {
            str2 = aliases.get(str2);
            if (str2 == null) {
                break;
            }
            transitionHistory = zoneModelProvider.load(str2);
        }
        if (transitionHistory != null) {
            return new HistorizedTimezone(tzid, transitionHistory);
        }
        String fallback = zoneModelProvider.getFallback();
        if (fallback.isEmpty()) {
            return null;
        }
        if (!fallback.equals(zoneModelProvider.getName())) {
            return new FallbackTimezone(tzid, of(fallback + "~" + str));
        }
        throw new IllegalArgumentException("Circular zone model provider fallback: " + zoneModelProvider.getName());
    }

    /* access modifiers changed from: private */
    public static TZID resolve(String str) {
        TZID tzid = PREDEFINED.get(str);
        if (tzid != null) {
            return tzid;
        }
        if (str.startsWith(TimeZones.GMT_ID)) {
            str = "UTC" + str.substring(3);
        }
        ZonalOffset parse = ZonalOffset.parse(str, false);
        return parse == null ? new NamedID(str) : parse;
    }

    private static void fillEtcetera(Map<String, TZID> map) {
        map.put("Etc/GMT", ZonalOffset.UTC);
        map.put("Etc/Greenwich", ZonalOffset.UTC);
        map.put("Etc/Universal", ZonalOffset.UTC);
        map.put("Etc/Zulu", ZonalOffset.UTC);
        map.put("Etc/GMT+0", ZonalOffset.UTC);
        map.put("Etc/GMT-0", ZonalOffset.UTC);
        map.put("Etc/GMT0", ZonalOffset.UTC);
        map.put("Etc/UTC", ZonalOffset.UTC);
        map.put("Etc/UCT", ZonalOffset.UTC);
        map.put("Etc/GMT-14", ZonalOffset.ofTotalSeconds(50400));
        map.put("Etc/GMT-13", ZonalOffset.ofTotalSeconds(46800));
        map.put("Etc/GMT-12", ZonalOffset.ofTotalSeconds(43200));
        map.put("Etc/GMT-11", ZonalOffset.ofTotalSeconds(39600));
        map.put("Etc/GMT-10", ZonalOffset.ofTotalSeconds(36000));
        map.put("Etc/GMT-9", ZonalOffset.ofTotalSeconds(32400));
        map.put("Etc/GMT-8", ZonalOffset.ofTotalSeconds(28800));
        map.put("Etc/GMT-7", ZonalOffset.ofTotalSeconds(25200));
        map.put("Etc/GMT-6", ZonalOffset.ofTotalSeconds(21600));
        map.put("Etc/GMT-5", ZonalOffset.ofTotalSeconds(18000));
        map.put("Etc/GMT-4", ZonalOffset.ofTotalSeconds(14400));
        map.put("Etc/GMT-3", ZonalOffset.ofTotalSeconds(10800));
        map.put("Etc/GMT-2", ZonalOffset.ofTotalSeconds(7200));
        map.put("Etc/GMT-1", ZonalOffset.ofTotalSeconds(NikonType2MakernoteDirectory.TAG_NIKON_SCAN));
        map.put("Etc/GMT+1", ZonalOffset.ofTotalSeconds(-3600));
        map.put("Etc/GMT+2", ZonalOffset.ofTotalSeconds(-7200));
        map.put("Etc/GMT+3", ZonalOffset.ofTotalSeconds(-10800));
        map.put("Etc/GMT+4", ZonalOffset.ofTotalSeconds(-14400));
        map.put("Etc/GMT+5", ZonalOffset.ofTotalSeconds(-18000));
        map.put("Etc/GMT+6", ZonalOffset.ofTotalSeconds(-21600));
        map.put("Etc/GMT+7", ZonalOffset.ofTotalSeconds(-25200));
        map.put("Etc/GMT+8", ZonalOffset.ofTotalSeconds(-28800));
        map.put("Etc/GMT+9", ZonalOffset.ofTotalSeconds(-32400));
        map.put("Etc/GMT+10", ZonalOffset.ofTotalSeconds(-36000));
        map.put("Etc/GMT+11", ZonalOffset.ofTotalSeconds(-39600));
        map.put("Etc/GMT+12", ZonalOffset.ofTotalSeconds(-43200));
    }

    private static List<Class<? extends TZID>> loadPredefined(ClassLoader classLoader, String... strArr) throws ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Class<?> cls = Class.forName("net.time4j.tz.olson." + str, true, classLoader);
            if (TZID.class.isAssignableFrom(cls)) {
                arrayList.add(cls);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static ZoneModelProvider getProvider(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Missing zone model provider.");
        } else if (str.equals(NAME_DEFAULT)) {
            return DEFAULT_PROVIDER;
        } else {
            return (ZoneModelProvider) PROVIDERS.get(str);
        }
    }

    private static ZoneModelProvider compareTZDB(ZoneModelProvider zoneModelProvider, ZoneModelProvider zoneModelProvider2) {
        String version = zoneModelProvider.getVersion();
        if (!version.isEmpty()) {
            String str = REPOSITORY_VERSION;
            if (version.equals(str)) {
                return zoneModelProvider;
            }
            if (str == null) {
                if (zoneModelProvider2 == null || version.compareTo(zoneModelProvider2.getVersion()) > 0) {
                    return zoneModelProvider;
                }
                if (version.compareTo(zoneModelProvider2.getVersion()) == 0 && !zoneModelProvider.getLocation().contains("{java.home}")) {
                    return zoneModelProvider;
                }
            }
        }
        return zoneModelProvider2;
    }

    public static class Cache {
        private Cache() {
        }

        public static void refresh() {
            synchronized (Timezone.class) {
                while (Timezone.QUEUE.poll() != null) {
                }
                Timezone.LAST_USED.clear();
            }
            ZonalKeys unused = Timezone.zonalKeys = new ZonalKeys();
            Timezone.CACHE.clear();
            if (Timezone.ALLOW_SYSTEM_TZ_OVERRIDE) {
                Timezone unused2 = Timezone.currentSystemTZ = Timezone.getDefaultTZ();
            }
        }

        public static void setCacheActive(boolean z) {
            boolean unused = Timezone.cacheActive = z;
            if (!z) {
                Timezone.CACHE.clear();
            }
        }

        public static void setMinimumCacheSize(int i) {
            if (i >= 0) {
                while (true) {
                    NamedReference namedReference = (NamedReference) Timezone.QUEUE.poll();
                    if (namedReference == null) {
                        break;
                    }
                    Timezone.CACHE.remove(namedReference.tzid);
                }
                synchronized (Timezone.class) {
                    int unused = Timezone.softLimit = i + 1;
                    int size = Timezone.LAST_USED.size() - i;
                    for (int i2 = 0; i2 < size; i2++) {
                        Timezone.LAST_USED.removeLast();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Negative timezone cache size: " + i);
        }
    }

    private static class NamedReference extends SoftReference<Timezone> {
        /* access modifiers changed from: private */
        public final String tzid;

        NamedReference(Timezone timezone, ReferenceQueue<Timezone> referenceQueue) {
            super(timezone, referenceQueue);
            this.tzid = timezone.getID().canonical();
        }
    }

    private static class ZonalKeys {
        /* access modifiers changed from: private */
        public final List<TZID> availables;
        /* access modifiers changed from: private */
        public final List<TZID> availablesAndAliases;

        ZonalKeys() {
            ArrayList arrayList = new ArrayList(1024);
            ArrayList arrayList2 = new ArrayList(1024);
            arrayList.add(ZonalOffset.UTC);
            for (Map.Entry value : Timezone.PROVIDERS.entrySet()) {
                ZoneModelProvider zoneModelProvider = (ZoneModelProvider) value.getValue();
                if (zoneModelProvider != Timezone.PLATFORM_PROVIDER || Timezone.DEFAULT_PROVIDER == Timezone.PLATFORM_PROVIDER) {
                    for (String access$1600 : zoneModelProvider.getAvailableIDs()) {
                        TZID access$16002 = Timezone.resolve(access$1600);
                        if (!arrayList.contains(access$16002)) {
                            arrayList.add(access$16002);
                        }
                    }
                    arrayList2.addAll(arrayList);
                    for (String access$16003 : zoneModelProvider.getAliases().keySet()) {
                        TZID access$16004 = Timezone.resolve(access$16003);
                        if (!arrayList2.contains(access$16004)) {
                            arrayList2.add(access$16004);
                        }
                    }
                }
            }
            Collections.sort(arrayList, Timezone.ID_COMPARATOR);
            Collections.sort(arrayList2, Timezone.ID_COMPARATOR);
            this.availables = Collections.unmodifiableList(arrayList);
            this.availablesAndAliases = Collections.unmodifiableList(arrayList2);
        }
    }

    private static class PlatformZoneProvider implements ZoneModelProvider, ZoneNameProvider {
        public String getFallback() {
            return "";
        }

        public String getLocation() {
            return "";
        }

        public String getName() {
            return Timezone.NAME_JUT;
        }

        public ZoneNameProvider getSpecificZoneNameRepository() {
            return this;
        }

        public String getStdFormatPattern(boolean z, Locale locale) {
            return z ? TimeZones.GMT_ID : "GMT±hh:mm";
        }

        public TransitionHistory load(String str) {
            return null;
        }

        private PlatformZoneProvider() {
        }

        public Set<String> getAvailableIDs() {
            HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(TimeZone.getAvailableIDs()));
            return hashSet;
        }

        public Map<String, String> getAliases() {
            return Collections.emptyMap();
        }

        public String getVersion() {
            return TimeUtils.getTimeZoneDatabaseVersion();
        }

        public Set<String> getPreferredIDs(Locale locale, boolean z) {
            return Collections.emptySet();
        }

        public String getDisplayName(String str, NameStyle nameStyle, Locale locale) {
            Objects.requireNonNull(locale, "Missing locale.");
            if (str.isEmpty()) {
                return "";
            }
            TimeZone findZone = PlatformTimezone.findZone(str);
            if (findZone.getID().equals(str)) {
                return findZone.getDisplayName(nameStyle.isDaylightSaving(), nameStyle.isAbbreviation() ^ true ? 1 : 0, locale);
            }
            return "";
        }
    }
}
