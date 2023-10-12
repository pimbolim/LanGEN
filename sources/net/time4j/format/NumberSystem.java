package net.time4j.format;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.facebook.common.statfs.StatFsHelper;
import com.stripe.android.model.Stripe3ds2AuthResult;
import java.io.IOException;
import java.util.Locale;
import net.time4j.base.MathUtils;

public enum NumberSystem {
    ARABIC("latn") {
        public boolean contains(char c) {
            return c >= '0' && c <= '9';
        }

        public String getDigits() {
            return "0123456789";
        }

        public boolean isDecimal() {
            return true;
        }

        public String toNumeral(int i) {
            if (i >= 0) {
                return Integer.toString(i);
            }
            throw new IllegalArgumentException("Cannot convert: " + i);
        }

        public int toInteger(String str, Leniency leniency) {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= 0) {
                return parseInt;
            }
            throw new NumberFormatException("Cannot convert negative number: " + str);
        }
    },
    ARABIC_INDIC("arab") {
        public String getDigits() {
            return "٠١٢٣٤٥٦٧٨٩";
        }

        public boolean isDecimal() {
            return true;
        }
    },
    ARABIC_INDIC_EXT("arabext") {
        public String getDigits() {
            return "۰۱۲۳۴۵۶۷۸۹";
        }

        public boolean isDecimal() {
            return true;
        }
    },
    BENGALI("beng") {
        public String getDigits() {
            return "০১২৩৪৫৬৭৮৯";
        }

        public boolean isDecimal() {
            return true;
        }
    },
    DEVANAGARI("deva") {
        public String getDigits() {
            return "०१२३४५६७८९";
        }

        public boolean isDecimal() {
            return true;
        }
    },
    DOZENAL("dozenal") {
        public boolean contains(char c) {
            return (c >= '0' && c <= '9') || c == 8586 || c == 8587;
        }

        public String getDigits() {
            return "0123456789↊↋";
        }

        public boolean isDecimal() {
            return false;
        }

        public String toNumeral(int i) {
            if (i >= 0) {
                return Integer.toString(i, 12).replace('a', 8586).replace('b', 8587);
            }
            throw new IllegalArgumentException("Cannot convert: " + i);
        }

        public int toNumeral(int i, Appendable appendable) throws IOException {
            if (i >= 0) {
                int i2 = 0;
                int i3 = 1;
                while (true) {
                    if (i3 > 4) {
                        break;
                    } else if (i < NumberSystem.D_FACTORS[i3]) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 > 0) {
                    int i4 = i2 - 1;
                    do {
                        int i5 = i / NumberSystem.D_FACTORS[i4];
                        appendable.append(i5 == 11 ? 8587 : i5 == 10 ? 8586 : (char) (i5 + 48));
                        i -= i5 * NumberSystem.D_FACTORS[i4];
                        i4--;
                    } while (i4 >= 0);
                    return i2;
                }
            }
            return NumberSystem.super.toNumeral(i, appendable);
        }

        public int toInteger(String str, Leniency leniency) {
            int parseInt = Integer.parseInt(str.replace(8586, 'a').replace(8587, 'b'), 12);
            if (parseInt >= 0) {
                return parseInt;
            }
            throw new NumberFormatException("Cannot convert negative number: " + str);
        }
    },
    ETHIOPIC("ethiopic") {
        public boolean contains(char c) {
            return c >= 4969 && c <= 4988;
        }

        public String getDigits() {
            return "፩፪፫፬፭፮፯፰፱፲፳፴፵፶፷፸፹፺፻፼";
        }

        public boolean isDecimal() {
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toNumeral(int r11) {
            /*
                r10 = this;
                r0 = 1
                if (r11 < r0) goto L_0x0086
                java.lang.String r11 = java.lang.String.valueOf(r11)
                int r1 = r11.length()
                int r1 = r1 - r0
                int r2 = r1 % 2
                if (r2 != 0) goto L_0x0023
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "0"
                r2.append(r3)
                r2.append(r11)
                java.lang.String r11 = r2.toString()
                int r1 = r1 + 1
            L_0x0023:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r3 = r1
            L_0x0029:
                if (r3 < 0) goto L_0x0081
                int r4 = r1 - r3
                char r4 = r11.charAt(r4)
                int r3 = r3 + -1
                int r5 = r1 - r3
                char r5 = r11.charAt(r5)
                r6 = 48
                r7 = 0
                if (r5 == r6) goto L_0x0042
                int r5 = r5 + 4920
                char r5 = (char) r5
                goto L_0x0043
            L_0x0042:
                r5 = 0
            L_0x0043:
                if (r4 == r6) goto L_0x0049
                int r4 = r4 + 4929
                char r4 = (char) r4
                goto L_0x004a
            L_0x0049:
                r4 = 0
            L_0x004a:
                int r6 = r3 % 4
                int r6 = r6 / 2
                r8 = 4987(0x137b, float:6.988E-42)
                if (r3 == 0) goto L_0x005e
                if (r6 == 0) goto L_0x005b
                if (r5 != 0) goto L_0x0058
                if (r4 == 0) goto L_0x005e
            L_0x0058:
                r6 = 4987(0x137b, float:6.988E-42)
                goto L_0x005f
            L_0x005b:
                r6 = 4988(0x137c, float:6.99E-42)
                goto L_0x005f
            L_0x005e:
                r6 = 0
            L_0x005f:
                r9 = 4969(0x1369, float:6.963E-42)
                if (r5 != r9) goto L_0x006e
                if (r4 != 0) goto L_0x006e
                if (r1 <= r0) goto L_0x006e
                if (r6 == r8) goto L_0x006f
                int r8 = r3 + 1
                if (r8 != r1) goto L_0x006e
                goto L_0x006f
            L_0x006e:
                r7 = r5
            L_0x006f:
                if (r4 == 0) goto L_0x0074
                r2.append(r4)
            L_0x0074:
                if (r7 == 0) goto L_0x0079
                r2.append(r7)
            L_0x0079:
                if (r6 == 0) goto L_0x007e
                r2.append(r6)
            L_0x007e:
                int r3 = r3 + -1
                goto L_0x0029
            L_0x0081:
                java.lang.String r11 = r2.toString()
                return r11
            L_0x0086:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Can only convert positive numbers: "
                r1.append(r2)
                r1.append(r11)
                java.lang.String r11 = r1.toString()
                r0.<init>(r11)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.NumberSystem.AnonymousClass7.toNumeral(int):java.lang.String");
        }

        public int toInteger(String str, Leniency leniency) {
            int i;
            int i2 = 1;
            boolean z = false;
            boolean z2 = false;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                if (charAt >= 4969 && charAt < 4978) {
                    i = (charAt + 1) - 4969;
                } else if (charAt < 4978 || charAt >= 4987) {
                    if (charAt == 4988) {
                        if (z && i4 == 0) {
                            i4 = 1;
                        }
                        i3 = NumberSystem.addEthiopic(i3, i4, i5);
                        i5 = z ? i5 * 100 : i5 * PhotoshopDirectory.TAG_PRINT_FLAGS_INFO;
                        z = false;
                        z2 = true;
                    } else if (charAt == 4987) {
                        i3 = NumberSystem.addEthiopic(i3, i4, i5);
                        i5 *= 100;
                        z = true;
                        z2 = false;
                    }
                    i4 = 0;
                } else {
                    i = ((charAt + 1) - 4978) * 10;
                }
                i4 += i;
            }
            if ((!z && !z2) || i4 != 0) {
                i2 = i4;
            }
            return NumberSystem.addEthiopic(i3, i2, i5);
        }
    },
    GUJARATI("gujr") {
        public String getDigits() {
            return "૦૧૨૩૪૫૬૭૮૯";
        }

        public boolean isDecimal() {
            return true;
        }
    },
    JAPANESE("jpan") {
        public String getDigits() {
            return "一二三四五六七八九十百千";
        }

        public boolean isDecimal() {
            return false;
        }

        public String toNumeral(int i) {
            if (i < 1 || i > 9999) {
                throw new IllegalArgumentException("Cannot convert: " + i);
            }
            String digits = getDigits();
            int i2 = i / 1000;
            int i3 = i % 1000;
            int i4 = i3 / 100;
            int i5 = i3 % 100;
            int i6 = i5 / 10;
            int i7 = i5 % 10;
            StringBuilder sb = new StringBuilder();
            if (i2 >= 1) {
                if (i2 > 1) {
                    sb.append(digits.charAt(i2 - 1));
                }
                sb.append(21315);
            }
            if (i4 >= 1) {
                if (i4 > 1) {
                    sb.append(digits.charAt(i4 - 1));
                }
                sb.append(30334);
            }
            if (i6 >= 1) {
                if (i6 > 1) {
                    sb.append(digits.charAt(i6 - 1));
                }
                sb.append(21313);
            }
            if (i7 > 0) {
                sb.append(digits.charAt(i7 - 1));
            }
            return sb.toString();
        }

        public int toInteger(String str, Leniency leniency) {
            boolean z;
            String digits = getDigits();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                if (charAt != 21313) {
                    if (charAt != 21315) {
                        if (charAt != 30334) {
                            int i5 = 0;
                            while (true) {
                                if (i5 >= 9) {
                                    z = false;
                                    break;
                                } else if (digits.charAt(i5) == charAt) {
                                    int i6 = i5 + 1;
                                    if (i4 == 1) {
                                        i2 += i6 * 1000;
                                        i4 = -1;
                                    } else if (i3 == 1) {
                                        i2 += i6 * 100;
                                        i3 = -1;
                                    } else if (i == 1) {
                                        i2 += i6 * 10;
                                        i = -1;
                                    } else {
                                        i2 += i6;
                                    }
                                    z = true;
                                } else {
                                    i5++;
                                }
                            }
                            if (!z) {
                                throw new IllegalArgumentException("Invalid Japanese numeral: " + str);
                            }
                        } else if (i3 == 0 && i4 == 0) {
                            i3++;
                        } else {
                            throw new IllegalArgumentException("Invalid Japanese numeral: " + str);
                        }
                    } else if (i4 == 0) {
                        i4++;
                    } else {
                        throw new IllegalArgumentException("Invalid Japanese numeral: " + str);
                    }
                } else if (i == 0 && i3 == 0 && i4 == 0) {
                    i++;
                } else {
                    throw new IllegalArgumentException("Invalid Japanese numeral: " + str);
                }
            }
            if (i == 1) {
                i2 += 10;
            }
            if (i3 == 1) {
                i2 += 100;
            }
            return i4 == 1 ? i2 + 1000 : i2;
        }
    },
    KHMER("khmr") {
        public String getDigits() {
            return "០១២៣៤៥៦៧៨៩";
        }

        public boolean isDecimal() {
            return true;
        }
    },
    MYANMAR("mymr") {
        public String getDigits() {
            return "၀၁၂၃၄၅၆၇၈၉";
        }

        public boolean isDecimal() {
            return true;
        }
    },
    ORYA("orya") {
        public String getDigits() {
            return "୦୧୨୩୪୫୬୭୮୯";
        }

        public boolean isDecimal() {
            return true;
        }
    },
    ROMAN("roman") {
        public String getDigits() {
            return "IVXLCDM";
        }

        public boolean isDecimal() {
            return false;
        }

        public String toNumeral(int i) {
            if (i < 1 || i > 3999) {
                throw new IllegalArgumentException("Out of range (1-3999): " + i);
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < NumberSystem.NUMBERS.length; i2++) {
                while (i >= NumberSystem.NUMBERS[i2]) {
                    sb.append(NumberSystem.LETTERS[i2]);
                    i -= NumberSystem.NUMBERS[i2];
                }
            }
            return sb.toString();
        }

        public int toInteger(String str, Leniency leniency) {
            if (!str.isEmpty()) {
                String upperCase = str.toUpperCase(Locale.US);
                boolean isStrict = leniency.isStrict();
                int length = str.length();
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    char charAt = upperCase.charAt(i);
                    int access$500 = NumberSystem.getValue(charAt);
                    i++;
                    if (i != length) {
                        int i3 = 1;
                        while (true) {
                            if (i >= length) {
                                continue;
                                break;
                            }
                            char charAt2 = upperCase.charAt(i);
                            i++;
                            if (charAt2 == charAt) {
                                i3++;
                                if (i3 >= 4 && isStrict) {
                                    throw new NumberFormatException("Roman numeral contains more than 3 equal letters in sequence: " + str);
                                } else if (i == length) {
                                    i2 += access$500 * i3;
                                }
                            } else {
                                int access$5002 = NumberSystem.getValue(charAt2);
                                if (access$5002 < access$500) {
                                    i2 += access$500 * i3;
                                    i--;
                                } else if (!isStrict || (i3 <= 1 && NumberSystem.isValidRomanCombination(charAt, charAt2))) {
                                    i2 = (i2 + access$5002) - (access$500 * i3);
                                } else {
                                    throw new NumberFormatException("Not conform with modern usage: " + str);
                                }
                            }
                        }
                    } else {
                        i2 += access$500;
                    }
                }
                if (i2 <= 3999) {
                    if (isStrict) {
                        if (i2 >= 900 && upperCase.contains("DCD")) {
                            throw new NumberFormatException("Roman number contains invalid sequence DCD.");
                        } else if (i2 >= 90 && upperCase.contains("LXL")) {
                            throw new NumberFormatException("Roman number contains invalid sequence LXL.");
                        } else if (i2 >= 9 && upperCase.contains("VIV")) {
                            throw new NumberFormatException("Roman number contains invalid sequence VIV.");
                        }
                    }
                    return i2;
                }
                throw new NumberFormatException("Roman numbers bigger than 3999 not supported.");
            }
            throw new NumberFormatException("Empty Roman numeral.");
        }

        public boolean contains(char c) {
            char upperCase = Character.toUpperCase(c);
            return upperCase == 'I' || upperCase == 'V' || upperCase == 'X' || upperCase == 'L' || upperCase == 'C' || upperCase == 'D' || upperCase == 'M';
        }
    },
    TELUGU("telu") {
        public String getDigits() {
            return "౦౧౨౩౪౫౬౭౮౯";
        }

        public boolean isDecimal() {
            return true;
        }
    },
    THAI("thai") {
        public String getDigits() {
            return "๐๑๒๓๔๕๖๗๘๙";
        }

        public boolean isDecimal() {
            return true;
        }
    };
    
    /* access modifiers changed from: private */
    public static final int[] D_FACTORS = null;
    private static final char ETHIOPIC_HUNDRED = '፻';
    private static final char ETHIOPIC_ONE = '፩';
    private static final char ETHIOPIC_TEN = '፲';
    private static final char ETHIOPIC_TEN_THOUSAND = '፼';
    /* access modifiers changed from: private */
    public static final String[] LETTERS = null;
    /* access modifiers changed from: private */
    public static final int[] NUMBERS = null;
    private final String code;

    /* access modifiers changed from: private */
    public static boolean isValidRomanCombination(char c, char c2) {
        if (c == 'C') {
            return c2 == 'M' || c2 == 'D';
        }
        if (c == 'I') {
            return c2 == 'X' || c2 == 'V';
        }
        if (c != 'X') {
            return false;
        }
        return c2 == 'C' || c2 == 'L';
    }

    static {
        NUMBERS = new int[]{1000, TypedValues.Custom.TYPE_INT, 500, StatFsHelper.DEFAULT_DISK_YELLOW_LEVEL_IN_MB, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        LETTERS = new String[]{"M", "CM", "D", "CD", Stripe3ds2AuthResult.Ares.VALUE_CHALLENGE, "XC", "L", "XL", "X", "IX", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "IV", "I"};
        D_FACTORS = new int[]{1, 12, 144, 1728, 20736};
    }

    private NumberSystem(String str) {
        this.code = str;
    }

    public String toNumeral(int i) {
        if (!isDecimal() || i < 0) {
            throw new IllegalArgumentException("Cannot convert: " + i);
        }
        int charAt = getDigits().charAt(0) - '0';
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder();
        int length = num.length();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append((char) (num.charAt(i2) + charAt));
        }
        return sb.toString();
    }

    public int toNumeral(int i, Appendable appendable) throws IOException {
        String numeral = toNumeral(i);
        appendable.append(numeral);
        return numeral.length();
    }

    public final int toInteger(String str) {
        return toInteger(str, Leniency.SMART);
    }

    public int toInteger(String str, Leniency leniency) {
        if (isDecimal()) {
            int charAt = getDigits().charAt(0) - '0';
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                sb.append((char) (str.charAt(i) - charAt));
            }
            int parseInt = Integer.parseInt(sb.toString());
            if (parseInt >= 0) {
                return parseInt;
            }
            throw new NumberFormatException("Cannot convert negative number: " + str);
        }
        throw new NumberFormatException("Cannot convert: " + str);
    }

    public boolean contains(char c) {
        String digits = getDigits();
        int length = digits.length();
        for (int i = 0; i < length; i++) {
            if (digits.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    public String getDigits() {
        throw new AbstractMethodError();
    }

    public boolean isDecimal() {
        throw new AbstractMethodError();
    }

    public String getCode() {
        return this.code;
    }

    /* access modifiers changed from: private */
    public static int addEthiopic(int i, int i2, int i3) {
        return MathUtils.safeAdd(i, MathUtils.safeMultiply(i2, i3));
    }

    /* access modifiers changed from: private */
    public static int getValue(char c) {
        if (c == 'C') {
            return 100;
        }
        if (c == 'D') {
            return 500;
        }
        if (c == 'I') {
            return 1;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'X') {
            return 10;
        }
        if (c == 'L') {
            return 50;
        }
        if (c == 'M') {
            return 1000;
        }
        throw new NumberFormatException("Invalid Roman digit: " + c);
    }
}
