package net.time4j.tz.other;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import net.time4j.tz.NameStyle;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.spi.WinZoneProviderSPI;

public final class WindowsZone implements Comparable<WindowsZone>, Serializable {
    private static final WinZoneProviderSPI PROVIDER = new WinZoneProviderSPI();
    private static final Locale WORLDWIDE = new Locale("", "001");
    private static final long serialVersionUID = -6071278077083785308L;
    private final String name;

    private WindowsZone(String str) {
        this.name = str;
    }

    public static Set<String> getAvailableNames() {
        return WinZoneProviderSPI.NAME_BASED_MAP.keySet();
    }

    public static WindowsZone of(String str) {
        check(str);
        return new WindowsZone(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowsZone) {
            return this.name.equals(((WindowsZone) obj).name);
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return this.name;
    }

    public static String toString(TZID tzid, Locale locale) {
        return toString(tzid.canonical(), locale);
    }

    public static String toString(String str, Locale locale) {
        String canonical = Timezone.normalize(str).canonical();
        WinZoneProviderSPI winZoneProviderSPI = PROVIDER;
        String displayName = winZoneProviderSPI.getDisplayName(canonical, NameStyle.LONG_STANDARD_TIME, locale);
        return displayName.isEmpty() ? winZoneProviderSPI.getDisplayName(canonical, NameStyle.LONG_STANDARD_TIME, WORLDWIDE) : displayName;
    }

    public int compareTo(WindowsZone windowsZone) {
        return this.name.compareTo(windowsZone.name);
    }

    public Set<TZID> resolve(Locale locale) {
        Set set = (Set) WinZoneProviderSPI.NAME_BASED_MAP.get(this.name).get(locale.getCountry());
        if (set == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(set);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.util.Set<net.time4j.tz.TZID>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.tz.TZID resolveSmart(java.util.Locale r4) {
        /*
            r3 = this;
            java.util.Set r0 = r3.resolve(r4)
            int r1 = r0.size()
            r2 = 1
            if (r1 == r2) goto L_0x002e
            java.lang.String r4 = r4.getCountry()
            boolean r1 = r4.isEmpty()
            if (r1 != 0) goto L_0x002e
            java.lang.String r1 = "001"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x002e
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.util.Set<net.time4j.tz.TZID>>> r4 = net.time4j.tz.spi.WinZoneProviderSPI.NAME_BASED_MAP
            java.lang.String r0 = r3.name
            java.lang.Object r4 = r4.get(r0)
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r4 = r4.get(r1)
            r0 = r4
            java.util.Set r0 = (java.util.Set) r0
        L_0x002e:
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x0036
            r4 = 0
            return r4
        L_0x0036:
            java.util.Iterator r4 = r0.iterator()
            java.lang.Object r4 = r4.next()
            net.time4j.tz.TZID r4 = (net.time4j.tz.TZID) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.other.WindowsZone.resolveSmart(java.util.Locale):net.time4j.tz.TZID");
    }

    public static void registerAsTimezone() {
        Timezone.registerProvider(PROVIDER);
    }

    static String getVersion() {
        return WinZoneProviderSPI.WIN_NAME_VERSION;
    }

    private static void check(String str) {
        if (str.isEmpty() || !WinZoneProviderSPI.NAME_BASED_MAP.keySet().contains(str)) {
            throw new IllegalArgumentException("Unknown windows zone: " + str);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        check(this.name);
    }
}
