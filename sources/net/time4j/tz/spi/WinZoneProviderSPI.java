package net.time4j.tz.spi;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.tz.NameStyle;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.TransitionHistory;
import net.time4j.tz.ZoneModelProvider;
import net.time4j.tz.ZoneNameProvider;
import org.apache.commons.lang3.time.TimeZones;

public class WinZoneProviderSPI implements ZoneModelProvider, ZoneNameProvider {
    public static final Map<String, Map<String, Set<TZID>>> NAME_BASED_MAP = prepareResolvers();
    private static final Map<String, Set<String>> PREFERRED_KEYS = prepareSmartMode();
    private static final Map<String, Map<String, String>> REPOSITORY;
    private static final String VKEY = "VERSION";
    public static final String WIN_NAME_VERSION;

    private static <T> T cast(Object obj) {
        return obj;
    }

    public String getFallback() {
        return "DEFAULT";
    }

    public String getLocation() {
        return "";
    }

    public String getName() {
        return "WINDOWS";
    }

    public ZoneNameProvider getSpecificZoneNameRepository() {
        return this;
    }

    public String getStdFormatPattern(boolean z, Locale locale) {
        return z ? TimeZones.GMT_ID : "GMT±hh:mm";
    }

    public String getVersion() {
        return "";
    }

    public TransitionHistory load(String str) {
        return null;
    }

    static {
        Map<String, Map<String, String>> loadData = loadData();
        WIN_NAME_VERSION = (String) loadData.get(VKEY).keySet().iterator().next();
        loadData.remove(VKEY);
        REPOSITORY = Collections.unmodifiableMap(loadData);
    }

    public Set<String> getAvailableIDs() {
        HashSet hashSet = new HashSet();
        for (TZID canonical : Timezone.getAvailableIDs("DEFAULT")) {
            hashSet.add("WINDOWS~" + canonical.canonical());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public Map<String, String> getAliases() {
        return Collections.emptyMap();
    }

    public Set<String> getPreferredIDs(Locale locale, boolean z) {
        return getPreferredIDs(locale.getCountry(), z);
    }

    public String getDisplayName(String str, NameStyle nameStyle, Locale locale) {
        if (str.isEmpty()) {
            return "";
        }
        Map<String, String> idsToNames = idsToNames(locale.getCountry());
        String str2 = idsToNames.get("WINDOWS~" + str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    private static Map<String, String> idsToNames(String str) {
        Map map = REPOSITORY.get(str);
        if (map == null) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(map);
    }

    private static Set<String> getPreferredIDs(String str, boolean z) {
        if (z) {
            return getPreferences(str);
        }
        return idsToNames(str).keySet();
    }

    private static Set<String> getPreferences(String str) {
        Set set = PREFERRED_KEYS.get(str);
        if (set == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(set);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068 A[SYNTHETIC, Splitter:B:27:0x0068] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> loadData() {
        /*
            java.lang.Class<net.time4j.tz.spi.WinZoneProviderSPI> r0 = net.time4j.tz.spi.WinZoneProviderSPI.class
            r1 = 0
            java.lang.String r2 = "data/winzone.ser"
            net.time4j.base.ResourceLoader r3 = net.time4j.base.ResourceLoader.getInstance()     // Catch:{ ClassNotFoundException -> 0x005f, IOException -> 0x0058 }
            java.lang.String r4 = "olson"
            java.net.URI r3 = r3.locate(r4, r0, r2)     // Catch:{ ClassNotFoundException -> 0x005f, IOException -> 0x0058 }
            net.time4j.base.ResourceLoader r4 = net.time4j.base.ResourceLoader.getInstance()     // Catch:{ ClassNotFoundException -> 0x005f, IOException -> 0x0058 }
            r5 = 1
            java.io.InputStream r3 = r4.load(r3, r5)     // Catch:{ ClassNotFoundException -> 0x005f, IOException -> 0x0058 }
            if (r3 != 0) goto L_0x0022
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x005f, IOException -> 0x0058 }
            java.io.InputStream r3 = r0.getResourceAsStream(r2)     // Catch:{ ClassNotFoundException -> 0x005f, IOException -> 0x0058 }
        L_0x0022:
            java.io.ObjectInputStream r0 = new java.io.ObjectInputStream     // Catch:{ ClassNotFoundException -> 0x005f, IOException -> 0x0058 }
            r0.<init>(r3)     // Catch:{ ClassNotFoundException -> 0x005f, IOException -> 0x0058 }
            java.lang.String r1 = r0.readUTF()     // Catch:{ ClassNotFoundException -> 0x0051, IOException -> 0x004c, all -> 0x0047 }
            java.lang.Object r2 = r0.readObject()     // Catch:{ ClassNotFoundException -> 0x0051, IOException -> 0x004c, all -> 0x0047 }
            java.lang.Object r2 = cast(r2)     // Catch:{ ClassNotFoundException -> 0x0051, IOException -> 0x004c, all -> 0x0047 }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ ClassNotFoundException -> 0x0051, IOException -> 0x004c, all -> 0x0047 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ ClassNotFoundException -> 0x0051, IOException -> 0x004c, all -> 0x0047 }
            r3.<init>(r2)     // Catch:{ ClassNotFoundException -> 0x0051, IOException -> 0x004c, all -> 0x0047 }
            java.lang.String r2 = "VERSION"
            java.util.Map r1 = java.util.Collections.singletonMap(r1, r1)     // Catch:{ ClassNotFoundException -> 0x0051, IOException -> 0x004c, all -> 0x0047 }
            r3.put(r2, r1)     // Catch:{ ClassNotFoundException -> 0x0051, IOException -> 0x004c, all -> 0x0047 }
            r0.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0046:
            return r3
        L_0x0047:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0066
        L_0x004c:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0059
        L_0x0051:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0060
        L_0x0056:
            r0 = move-exception
            goto L_0x0066
        L_0x0058:
            r0 = move-exception
        L_0x0059:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0056 }
            r2.<init>(r0)     // Catch:{ all -> 0x0056 }
            throw r2     // Catch:{ all -> 0x0056 }
        L_0x005f:
            r0 = move-exception
        L_0x0060:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0056 }
            r2.<init>(r0)     // Catch:{ all -> 0x0056 }
            throw r2     // Catch:{ all -> 0x0056 }
        L_0x0066:
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ IOException -> 0x006b }
        L_0x006b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.spi.WinZoneProviderSPI.loadData():java.util.Map");
    }

    private static Map<String, Set<String>> prepareSmartMode() {
        HashMap hashMap = new HashMap();
        for (String next : REPOSITORY.keySet()) {
            Map<String, String> idsToNames = idsToNames(next);
            Set<String> keySet = idsToNames.keySet();
            if (keySet.size() >= 2) {
                keySet = new HashSet<>();
                for (String str : new HashSet(idsToNames.values())) {
                    for (Map.Entry next2 : getFallbackSet()) {
                        if (((String) next2.getValue()).equals(str)) {
                            keySet.add(next2.getKey());
                        }
                    }
                }
            }
            hashMap.put(next, keySet);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static Set<Map.Entry<String, String>> getFallbackSet() {
        return idsToNames("001").entrySet();
    }

    private static Map<String, Map<String, Set<TZID>>> prepareResolvers() {
        HashMap hashMap = new HashMap();
        for (String next : REPOSITORY.keySet()) {
            for (Map.Entry entry : REPOSITORY.get(next).entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                Map map = (Map) hashMap.get(str2);
                if (map == null) {
                    map = new HashMap();
                    hashMap.put(str2, map);
                }
                Set set = (Set) map.get(next);
                if (set == null) {
                    set = new HashSet();
                    map.put(next, set);
                }
                set.add(new WinZoneID(str));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
