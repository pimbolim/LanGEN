package io.card.payment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Pair;
import com.braintreepayments.api.models.BinData;
import io.card.payment.i18n.LocalizedStrings;
import io.card.payment.i18n.StringKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public enum CardType {
    AMEX("AmEx"),
    DINERSCLUB("DinersClub"),
    DISCOVER("Discover"),
    JCB("JCB"),
    MASTERCARD("MasterCard"),
    VISA("Visa"),
    MAESTRO("Maestro"),
    UNKNOWN(BinData.UNKNOWN),
    INSUFFICIENT_DIGITS("More digits required");
    
    private static HashMap<Pair<String, String>, CardType> intervalLookup;
    private static int minDigits;
    public final String name;

    static {
        CardType cardType;
        CardType cardType2;
        CardType cardType3;
        CardType cardType4;
        CardType cardType5;
        CardType cardType6;
        CardType cardType7;
        minDigits = 1;
        HashMap<Pair<String, String>, CardType> hashMap = new HashMap<>();
        intervalLookup = hashMap;
        hashMap.put(getNewPair("2221", "2720"), cardType5);
        intervalLookup.put(getNewPair("300", "305"), cardType2);
        intervalLookup.put(getNewPair("309", (String) null), cardType2);
        intervalLookup.put(getNewPair("34", (String) null), cardType);
        intervalLookup.put(getNewPair("3528", "3589"), cardType4);
        intervalLookup.put(getNewPair("36", (String) null), cardType2);
        intervalLookup.put(getNewPair("37", (String) null), cardType);
        intervalLookup.put(getNewPair("38", "39"), cardType2);
        intervalLookup.put(getNewPair("4", (String) null), cardType6);
        intervalLookup.put(getNewPair("50", (String) null), cardType7);
        intervalLookup.put(getNewPair("51", "55"), cardType5);
        intervalLookup.put(getNewPair("56", "59"), cardType7);
        intervalLookup.put(getNewPair("6011", (String) null), cardType3);
        intervalLookup.put(getNewPair("61", (String) null), cardType7);
        intervalLookup.put(getNewPair("62", (String) null), cardType3);
        intervalLookup.put(getNewPair("63", (String) null), cardType7);
        intervalLookup.put(getNewPair("644", "649"), cardType3);
        intervalLookup.put(getNewPair("65", (String) null), cardType3);
        intervalLookup.put(getNewPair("66", "69"), cardType7);
        intervalLookup.put(getNewPair("88", (String) null), cardType3);
        for (Map.Entry next : getIntervalLookup().entrySet()) {
            minDigits = Math.max(minDigits, ((String) ((Pair) next.getKey()).first).length());
            if (((Pair) next.getKey()).second != null) {
                minDigits = Math.max(minDigits, ((String) ((Pair) next.getKey()).second).length());
            }
        }
    }

    private CardType(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }

    /* renamed from: io.card.payment.CardType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$card$payment$CardType = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                io.card.payment.CardType[] r0 = io.card.payment.CardType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$card$payment$CardType = r0
                io.card.payment.CardType r1 = io.card.payment.CardType.AMEX     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$card$payment$CardType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.card.payment.CardType r1 = io.card.payment.CardType.DINERSCLUB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$card$payment$CardType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.card.payment.CardType r1 = io.card.payment.CardType.DISCOVER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$card$payment$CardType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.card.payment.CardType r1 = io.card.payment.CardType.JCB     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$io$card$payment$CardType     // Catch:{ NoSuchFieldError -> 0x003e }
                io.card.payment.CardType r1 = io.card.payment.CardType.MASTERCARD     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$io$card$payment$CardType     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.card.payment.CardType r1 = io.card.payment.CardType.MAESTRO     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$io$card$payment$CardType     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.card.payment.CardType r1 = io.card.payment.CardType.VISA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$io$card$payment$CardType     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.card.payment.CardType r1 = io.card.payment.CardType.INSUFFICIENT_DIGITS     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$io$card$payment$CardType     // Catch:{ NoSuchFieldError -> 0x006c }
                io.card.payment.CardType r1 = io.card.payment.CardType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.card.payment.CardType.AnonymousClass1.<clinit>():void");
        }
    }

    public String getDisplayName(String str) {
        switch (AnonymousClass1.$SwitchMap$io$card$payment$CardType[ordinal()]) {
            case 1:
                return LocalizedStrings.getString(StringKey.CARDTYPE_AMERICANEXPRESS, str);
            case 2:
            case 3:
                return LocalizedStrings.getString(StringKey.CARDTYPE_DISCOVER, str);
            case 4:
                return LocalizedStrings.getString(StringKey.CARDTYPE_JCB, str);
            case 5:
                return LocalizedStrings.getString(StringKey.CARDTYPE_MASTERCARD, str);
            case 6:
                return LocalizedStrings.getString(StringKey.CARDTYPE_MAESTRO, str);
            case 7:
                return LocalizedStrings.getString(StringKey.CARDTYPE_VISA, str);
            default:
                return null;
        }
    }

    public int numberLength() {
        switch (AnonymousClass1.$SwitchMap$io$card$payment$CardType[ordinal()]) {
            case 1:
                return 15;
            case 2:
                return 14;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return 16;
            case 8:
                return minDigits;
            default:
                return -1;
        }
    }

    public int cvvLength() {
        switch (AnonymousClass1.$SwitchMap$io$card$payment$CardType[ordinal()]) {
            case 1:
                return 4;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return 3;
            default:
                return -1;
        }
    }

    public Bitmap imageBitmap(Context context) {
        int i;
        int i2 = AnonymousClass1.$SwitchMap$io$card$payment$CardType[ordinal()];
        if (i2 == 1) {
            i = R.drawable.cio_ic_amex;
        } else if (i2 == 2 || i2 == 3) {
            i = R.drawable.cio_ic_discover;
        } else if (i2 == 4) {
            i = R.drawable.cio_ic_jcb;
        } else if (i2 == 5) {
            i = R.drawable.cio_ic_mastercard;
        } else if (i2 != 7) {
            i = -1;
        } else {
            i = R.drawable.cio_ic_visa;
        }
        if (i != -1) {
            return BitmapFactory.decodeResource(context.getResources(), i);
        }
        return null;
    }

    private static boolean isNumberInInterval(String str, String str2, String str3) {
        int min = Math.min(str.length(), str2.length());
        int min2 = Math.min(str.length(), str3.length());
        if (Integer.parseInt(str.substring(0, min)) >= Integer.parseInt(str2.substring(0, min)) && Integer.parseInt(str.substring(0, min2)) <= Integer.parseInt(str3.substring(0, min2))) {
            return true;
        }
        return false;
    }

    private static HashMap<Pair<String, String>, CardType> getIntervalLookup() {
        return intervalLookup;
    }

    private static Pair<String, String> getNewPair(String str, String str2) {
        if (str2 == null) {
            str2 = str;
        }
        return new Pair<>(str, str2);
    }

    public static CardType fromString(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        for (CardType cardType : values()) {
            if (cardType != UNKNOWN && cardType != INSUFFICIENT_DIGITS && str.equalsIgnoreCase(cardType.toString())) {
                return cardType;
            }
        }
        return UNKNOWN;
    }

    public static CardType fromCardNumber(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry next : getIntervalLookup().entrySet()) {
            if (isNumberInInterval(str, (String) ((Pair) next.getKey()).first, (String) ((Pair) next.getKey()).second)) {
                hashSet.add(next.getValue());
            }
        }
        if (hashSet.size() > 1) {
            return INSUFFICIENT_DIGITS;
        }
        if (hashSet.size() == 1) {
            return (CardType) hashSet.iterator().next();
        }
        return UNKNOWN;
    }
}
