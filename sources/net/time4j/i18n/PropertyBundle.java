package net.time4j.i18n;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.ClassUtils;

public final class PropertyBundle {
    private static final ConcurrentMap<CacheKey, BundleReference> CACHE = new ConcurrentHashMap(32);
    /* access modifiers changed from: private */
    public static final ReferenceQueue<Object> REFERENCE_QUEUE = new ReferenceQueue<>();
    private final String baseName;
    private final Locale bundleLocale;
    private final Map<String, String> key2values;
    private final PropertyBundle parent;

    private PropertyBundle(UTF8ResourceReader uTF8ResourceReader, String str, Locale locale) throws IOException {
        int i;
        this.parent = null;
        this.baseName = str;
        this.bundleLocale = locale;
        HashMap hashMap = new HashMap();
        while (true) {
            String readLine = uTF8ResourceReader.readLine();
            if (readLine != null) {
                String trim = readLine.trim();
                if (!trim.isEmpty() && trim.charAt(0) != '#') {
                    int length = trim.length();
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (trim.charAt(i2) == '=' && (i = i2 + 1) < length) {
                                hashMap.put(trim.substring(0, i2), trim.substring(i));
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                this.key2values = Collections.unmodifiableMap(hashMap);
                return;
            }
        }
    }

    private PropertyBundle(PropertyBundle propertyBundle, PropertyBundle propertyBundle2) {
        this.parent = propertyBundle2;
        this.baseName = propertyBundle.baseName;
        this.bundleLocale = propertyBundle.bundleLocale;
        this.key2values = propertyBundle.key2values;
    }

    public static PropertyBundle load(String str, Locale locale) {
        PropertyBundle propertyBundle;
        if (!str.isEmpty()) {
            Objects.requireNonNull(locale, "Missing locale.");
            CacheKey cacheKey = new CacheKey(str, locale);
            BundleReference bundleReference = (BundleReference) CACHE.get(cacheKey);
            if (bundleReference != null && (propertyBundle = (PropertyBundle) bundleReference.get()) != null) {
                return propertyBundle;
            }
            while (true) {
                Reference<? extends Object> poll = REFERENCE_QUEUE.poll();
                if (poll == null) {
                    break;
                }
                CACHE.remove(((BundleReference) poll).cacheKey);
            }
            ArrayList arrayList = new ArrayList();
            for (Locale newBundle : getCandidateLocales(locale)) {
                try {
                    PropertyBundle newBundle2 = newBundle(str, newBundle);
                    if (newBundle2 != null) {
                        arrayList.add(newBundle2);
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
            if (!arrayList.isEmpty()) {
                for (int size = arrayList.size() - 1; size >= 1; size--) {
                    int i = size - 1;
                    arrayList.set(i, ((PropertyBundle) arrayList.get(i)).withParent((PropertyBundle) arrayList.get(size)));
                }
                PropertyBundle propertyBundle2 = (PropertyBundle) arrayList.get(0);
                CACHE.putIfAbsent(cacheKey, new BundleReference(propertyBundle2, cacheKey));
                return propertyBundle2;
            }
            throw new MissingResourceException("Cannot find resource bundle for: " + toResourceName(str, locale), PropertyBundle.class.getName(), "");
        }
        throw new IllegalArgumentException("Base name must not be empty.");
    }

    public String getString(String str) {
        Objects.requireNonNull(str, "Missing resource key.");
        PropertyBundle propertyBundle = this;
        do {
            String str2 = propertyBundle.key2values.get(str);
            if (str2 != null) {
                return str2;
            }
            propertyBundle = propertyBundle.parent;
        } while (propertyBundle != null);
        throw new MissingResourceException("Cannot find property resource for: " + toResourceName(this.baseName, this.bundleLocale) + "=>" + str, PropertyBundle.class.getName(), str);
    }

    public boolean containsKey(String str) {
        Objects.requireNonNull(str, "Missing resource key.");
        PropertyBundle propertyBundle = this;
        while (propertyBundle.key2values.get(str) == null) {
            propertyBundle = propertyBundle.parent;
            if (propertyBundle == null) {
                return false;
            }
        }
        return true;
    }

    public Set<String> keySet() {
        HashSet hashSet = new HashSet(this.key2values.keySet());
        PropertyBundle propertyBundle = this;
        while (true) {
            propertyBundle = propertyBundle.parent;
            if (propertyBundle == null) {
                return Collections.unmodifiableSet(hashSet);
            }
            hashSet.addAll(propertyBundle.key2values.keySet());
        }
    }

    public Locale getLocale() {
        return this.bundleLocale;
    }

    public static void clearCache() {
        do {
        } while (REFERENCE_QUEUE.poll() != null);
        CACHE.clear();
    }

    public Set<String> getInternalKeys() {
        return this.key2values.keySet();
    }

    public static List<Locale> getCandidateLocales(Locale locale) {
        String alias = LanguageMatch.getAlias(locale);
        String country = locale.getCountry();
        String variant = locale.getVariant();
        LinkedList linkedList = new LinkedList();
        if (!variant.isEmpty()) {
            linkedList.add(new Locale(alias, country, variant));
        }
        if (!country.isEmpty()) {
            linkedList.add(new Locale(alias, country, ""));
        }
        if (!alias.isEmpty()) {
            linkedList.add(new Locale(alias, "", ""));
            if (alias.equals("nn")) {
                linkedList.add(new Locale("nb", "", ""));
            }
        }
        linkedList.add(Locale.ROOT);
        return linkedList;
    }

    private PropertyBundle withParent(PropertyBundle propertyBundle) {
        return propertyBundle == null ? this : new PropertyBundle(this, propertyBundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: net.time4j.i18n.PropertyBundle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: net.time4j.i18n.UTF8ResourceReader} */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.time4j.i18n.PropertyBundle newBundle(java.lang.String r5, java.util.Locale r6) throws java.io.IOException {
        /*
            java.lang.Class<net.time4j.i18n.PropertyBundle> r0 = net.time4j.i18n.PropertyBundle.class
            r1 = 47
            int r1 = r5.indexOf(r1)
            r2 = 0
            java.lang.String r2 = r5.substring(r2, r1)
            r3 = 1
            int r1 = r1 + r3
            java.lang.String r1 = r5.substring(r1)
            java.lang.String r1 = toResourceName(r1, r6)
            net.time4j.base.ResourceLoader r4 = net.time4j.base.ResourceLoader.getInstance()
            java.net.URI r2 = r4.locate(r2, r0, r1)
            net.time4j.base.ResourceLoader r4 = net.time4j.base.ResourceLoader.getInstance()
            java.io.InputStream r2 = r4.load(r2, r3)
            r4 = 0
            if (r2 != 0) goto L_0x0034
            net.time4j.base.ResourceLoader r2 = net.time4j.base.ResourceLoader.getInstance()     // Catch:{ IOException -> 0x0033 }
            java.io.InputStream r2 = r2.load(r0, r1, r3)     // Catch:{ IOException -> 0x0033 }
            goto L_0x0034
        L_0x0033:
            return r4
        L_0x0034:
            if (r2 == 0) goto L_0x004e
            net.time4j.i18n.UTF8ResourceReader r0 = new net.time4j.i18n.UTF8ResourceReader     // Catch:{ all -> 0x0047 }
            r0.<init>(r2)     // Catch:{ all -> 0x0047 }
            net.time4j.i18n.PropertyBundle r4 = new net.time4j.i18n.PropertyBundle     // Catch:{ all -> 0x0044 }
            r4.<init>(r0, r5, r6)     // Catch:{ all -> 0x0044 }
            r0.close()
            goto L_0x004e
        L_0x0044:
            r5 = move-exception
            r4 = r0
            goto L_0x0048
        L_0x0047:
            r5 = move-exception
        L_0x0048:
            if (r4 == 0) goto L_0x004d
            r4.close()
        L_0x004d:
            throw r5
        L_0x004e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.i18n.PropertyBundle.newBundle(java.lang.String, java.util.Locale):net.time4j.i18n.PropertyBundle");
    }

    private static String toResourceName(String str, Locale locale) {
        String alias = LanguageMatch.getAlias(locale);
        String country = locale.getCountry();
        String variant = locale.getVariant();
        StringBuilder sb = new StringBuilder(str.length() + 20);
        sb.append(str.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/'));
        if (!alias.isEmpty()) {
            sb.append('_');
            sb.append(alias);
            if (!variant.isEmpty()) {
                sb.append('_');
                sb.append(country);
                sb.append('_');
                sb.append(variant);
            } else if (!country.isEmpty()) {
                sb.append('_');
                sb.append(country);
            }
        }
        sb.append(".properties");
        return sb.toString();
    }

    private static class CacheKey {
        private final String baseName;
        private final Locale locale;

        CacheKey(String str, Locale locale2) {
            this.baseName = str;
            this.locale = locale2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheKey)) {
                return false;
            }
            CacheKey cacheKey = (CacheKey) obj;
            if (!this.baseName.equals(cacheKey.baseName) || !this.locale.equals(cacheKey.locale)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.baseName.hashCode() << 3) ^ this.locale.hashCode();
        }

        public String toString() {
            return this.baseName + "/" + this.locale;
        }
    }

    private static class BundleReference extends SoftReference<PropertyBundle> {
        /* access modifiers changed from: private */
        public CacheKey cacheKey;

        BundleReference(PropertyBundle propertyBundle, CacheKey cacheKey2) {
            super(propertyBundle, PropertyBundle.REFERENCE_QUEUE);
            this.cacheKey = cacheKey2;
        }
    }
}
