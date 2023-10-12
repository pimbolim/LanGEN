package io.card.payment.i18n;

import android.util.Log;
import java.lang.Enum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class I18nManager<E extends Enum<?>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Set<String> RIGHT_TO_LEFT_LOCALE_SET;
    private static final Map<String, String> SPECIAL_LOCALE_MAP;
    private static final String TAG = "I18nManager";
    private SupportedLocale<E> currentLocale;
    private Class<E> enumClazz;
    private Map<String, SupportedLocale<E>> supportedLocales = new LinkedHashMap();

    static {
        HashMap hashMap = new HashMap();
        SPECIAL_LOCALE_MAP = hashMap;
        HashSet hashSet = new HashSet();
        RIGHT_TO_LEFT_LOCALE_SET = hashSet;
        hashMap.put("zh_CN", "zh-Hans");
        hashMap.put("zh_TW", "zh-Hant_TW");
        hashMap.put("zh_HK", "zh-Hant");
        hashMap.put("en_UK", "en_GB");
        hashMap.put("en_IE", "en_GB");
        hashMap.put("iw_IL", "he");
        hashMap.put("no", "nb");
        hashSet.add("he");
        hashSet.add("ar");
    }

    public I18nManager(Class<E> cls, List<SupportedLocale<E>> list) {
        this.enumClazz = cls;
        for (SupportedLocale<E> addLocale : list) {
            addLocale(addLocale);
        }
        setLanguage((String) null);
    }

    private void logMissingLocalizations(String str) {
        for (String i : getMissingLocaleMessages(str)) {
            Log.i(TAG, i);
        }
    }

    private List<String> getMissingLocaleMessages(String str) {
        SupportedLocale supportedLocale = this.supportedLocales.get(str);
        ArrayList arrayList = new ArrayList();
        for (Enum enumR : (Enum[]) this.enumClazz.getEnumConstants()) {
            String str2 = "[" + str + "," + enumR + "]";
            if (supportedLocale.getAdaptedDisplay(enumR, (String) null) == null) {
                arrayList.add("Missing " + str2);
            }
        }
        return arrayList;
    }

    public void setLanguage(String str) {
        this.currentLocale = null;
        this.currentLocale = getLocaleFromSpecifier(str);
        String str2 = TAG;
        Log.d(str2, "setting locale to:" + this.currentLocale.getName());
    }

    public SupportedLocale<E> getLocaleFromSpecifier(String str) {
        SupportedLocale<E> lookupSupportedLocale = str != null ? lookupSupportedLocale(str) : null;
        if (lookupSupportedLocale == null) {
            String locale = Locale.getDefault().toString();
            String str2 = TAG;
            Log.d(str2, str + " not found.  Attempting to look for " + locale);
            lookupSupportedLocale = lookupSupportedLocale(locale);
        }
        if (lookupSupportedLocale != null) {
            return lookupSupportedLocale;
        }
        Log.d(TAG, "defaulting to english");
        return this.supportedLocales.get("en");
    }

    private SupportedLocale<E> lookupSupportedLocale(String str) {
        String str2;
        SupportedLocale<E> supportedLocale = null;
        if (str == null || str.length() < 2) {
            return null;
        }
        Map<String, String> map = SPECIAL_LOCALE_MAP;
        if (map.containsKey(str)) {
            String str3 = map.get(str);
            Log.d(TAG, "Overriding locale specifier " + str + " with " + str3);
            supportedLocale = this.supportedLocales.get(str3);
        }
        if (supportedLocale == null) {
            if (str.contains("_")) {
                str2 = str;
            } else {
                str2 = str + "_" + Locale.getDefault().getCountry();
            }
            supportedLocale = this.supportedLocales.get(str2);
        }
        if (supportedLocale == null) {
            supportedLocale = this.supportedLocales.get(str);
        }
        if (supportedLocale != null) {
            return supportedLocale;
        }
        return this.supportedLocales.get(str.substring(0, 2));
    }

    public String getString(E e) {
        return getString(e, this.currentLocale);
    }

    public String getString(E e, SupportedLocale<E> supportedLocale) {
        String upperCase = Locale.getDefault().getCountry().toUpperCase(Locale.US);
        String adaptedDisplay = supportedLocale.getAdaptedDisplay(e, upperCase);
        if (adaptedDisplay == null) {
            Log.i(TAG, "Missing localized string for [" + this.currentLocale.getName() + ",Key." + e.toString() + "]");
            adaptedDisplay = this.supportedLocales.get("en").getAdaptedDisplay(e, upperCase);
        }
        if (adaptedDisplay != null) {
            return adaptedDisplay;
        }
        String str = TAG;
        Log.i(str, "Missing localized string for [en,Key." + e.toString() + "], so defaulting to keyname");
        return e.toString();
    }

    private void addLocale(SupportedLocale<E> supportedLocale) {
        String name = supportedLocale.getName();
        if (name == null) {
            throw new RuntimeException("Null localeName");
        } else if (!this.supportedLocales.containsKey(name)) {
            this.supportedLocales.put(name, supportedLocale);
            logMissingLocalizations(name);
        } else {
            throw new RuntimeException("Locale " + name + " already added");
        }
    }
}
