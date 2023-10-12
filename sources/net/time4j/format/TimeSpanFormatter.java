package net.time4j.format;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.TimeSpan;
import org.apache.commons.lang3.ClassUtils;

public abstract class TimeSpanFormatter<U, S extends TimeSpan<U>> {
    /* access modifiers changed from: private */
    public static final Object SIGN_KEY = new Object();
    private final List<FormatItem<U>> items;
    private final String pattern;
    private final Class<U> type;

    private static boolean isSymbol(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    /* access modifiers changed from: protected */
    public abstract S convert(Map<U, Long> map, boolean z);

    /* access modifiers changed from: protected */
    public abstract U getUnit(char c);

    protected TimeSpanFormatter(Class<U> cls, String str) {
        int i;
        Objects.requireNonNull(cls, "Missing unit type.");
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ArrayList());
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '#') {
                i3++;
            } else if (isSymbol(charAt)) {
                int i4 = i2 + 1;
                while (i4 < length && str.charAt(i4) == charAt) {
                    i4++;
                }
                addSymbol(charAt, i4 - i2, i3, arrayList);
                i2 = i4 - 1;
                i3 = 0;
            } else if (i3 <= 0) {
                if (charAt == '\'') {
                    int i5 = i2 + 1;
                    i = i5;
                    while (i < length) {
                        if (str.charAt(i) == '\'') {
                            int i6 = i + 1;
                            if (i6 >= length || str.charAt(i6) != '\'') {
                                break;
                            }
                            i = i6;
                        }
                        i++;
                    }
                    if (i >= length) {
                        throw new IllegalArgumentException("String literal in pattern not closed: " + str);
                    } else if (i5 == i) {
                        addLiteral('\'', arrayList);
                    } else {
                        addLiteral(str.substring(i5, i).replace("''", "'"), arrayList);
                    }
                } else if (charAt == '[') {
                    startOptionalSection(arrayList);
                } else if (charAt == ']') {
                    endOptionalSection(arrayList);
                } else if (charAt == '.') {
                    lastOn(arrayList).add(new SeparatorItem((char) ClassUtils.PACKAGE_SEPARATOR_CHAR, (char) AbstractJsonLexerKt.COMMA));
                } else if (charAt == ',') {
                    lastOn(arrayList).add(new SeparatorItem((char) AbstractJsonLexerKt.COMMA, (char) ClassUtils.PACKAGE_SEPARATOR_CHAR));
                } else if (charAt == '-') {
                    lastOn(arrayList).add(new SignItem(false));
                } else if (charAt == '+') {
                    lastOn(arrayList).add(new SignItem(true));
                } else if (charAt == '{') {
                    int i7 = i2 + 1;
                    int i8 = i7;
                    while (i < length && str.charAt(i) != '}') {
                        i8 = i + 1;
                    }
                    addPluralItem(str.substring(i7, i), arrayList);
                } else if (charAt == '|') {
                    lastOn(arrayList).add(OrItem.getInstance());
                } else {
                    addLiteral(charAt, arrayList);
                }
                i2 = i;
            } else {
                throw new IllegalArgumentException("Char # must be followed by unit symbol.");
            }
            i2++;
        }
        if (arrayList.size() > 1) {
            throw new IllegalArgumentException("Open square bracket without closing one.");
        } else if (!arrayList.isEmpty()) {
            List list = (List) arrayList.get(0);
            if (list.isEmpty()) {
                throw new IllegalArgumentException("Missing format pattern.");
            } else if (list.get(0) == OrItem.INSTANCE || list.get(list.size() - 1) == OrItem.INSTANCE) {
                throw new IllegalArgumentException("Pattern must not start or end with an or-operator.");
            } else {
                int size = list.size();
                int minWidth = ((FormatItem) list.get(size - 1)).getMinWidth();
                for (int i9 = size - 2; i9 >= 0; i9--) {
                    FormatItem formatItem = (FormatItem) list.get(i9);
                    if (formatItem == OrItem.INSTANCE) {
                        minWidth = 0;
                    } else {
                        list.set(i9, formatItem.update(minWidth));
                        minWidth += formatItem.getMinWidth();
                    }
                }
                this.type = cls;
                this.items = Collections.unmodifiableList(list);
                this.pattern = str;
            }
        } else {
            throw new IllegalArgumentException("Empty or invalid pattern.");
        }
    }

    public String getPattern() {
        return this.pattern;
    }

    public Class<U> getType() {
        return this.type;
    }

    public String format(TimeSpan<? super U> timeSpan) {
        StringBuilder sb = new StringBuilder();
        try {
            print(timeSpan, sb);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public void print(TimeSpan<? super U> timeSpan, Appendable appendable) throws IOException {
        FormatItem next;
        Iterator<FormatItem<U>> it = this.items.iterator();
        while (it.hasNext() && (next = it.next()) != OrItem.INSTANCE) {
            next.print(timeSpan, appendable);
        }
    }

    public S parse(CharSequence charSequence) throws ParseException {
        return parse(charSequence, 0);
    }

    public S parse(CharSequence charSequence, int i) throws ParseException {
        FormatItem formatItem;
        HashMap hashMap = new HashMap();
        int size = this.items.size();
        boolean z = false;
        int i2 = 0;
        while (i2 < size && (formatItem = this.items.get(i2)) != OrItem.INSTANCE) {
            int parse = formatItem.parse(hashMap, charSequence, i);
            if (parse < 0) {
                while (true) {
                    i2++;
                    if (i2 < size) {
                        if (this.items.get(i2) == OrItem.INSTANCE) {
                            break;
                        }
                    } else {
                        i2 = -1;
                        break;
                    }
                }
                if (i2 != -1) {
                    hashMap.clear();
                } else {
                    throw new ParseException("Cannot parse: " + charSequence, ~parse);
                }
            } else {
                i = parse;
            }
            i2++;
        }
        int length = charSequence.length();
        if (i >= length) {
            Long l = (Long) hashMap.remove(SIGN_KEY);
            if (l != null && l.longValue() < 0) {
                z = true;
            }
            HashMap hashMap2 = new HashMap();
            for (Object next : hashMap.keySet()) {
                if (this.type.isInstance(next)) {
                    hashMap2.put(this.type.cast(next), hashMap.get(next));
                } else {
                    throw new ParseException("Duration type mismatched: " + hashMap, i);
                }
            }
            return convert(hashMap2, z);
        }
        throw new ParseException("Unparsed trailing characters found: \"" + charSequence.subSequence(i, length) + "\" in \"" + charSequence, i);
    }

    private void addSymbol(char c, int i, int i2, List<List<FormatItem<U>>> list) {
        Object unit = getUnit(c);
        List list2 = list.get(list.size() - 1);
        if (c != 'f') {
            list2.add(new NumberItem(0, i, i + i2, unit));
        } else if (i2 <= 0) {
            list2.add(new FractionItem(0, i, getUnit(c)));
        } else {
            throw new IllegalArgumentException("Combination of # and f-symbol not allowed.");
        }
    }

    private void addLiteral(char c, List<List<FormatItem<U>>> list) {
        addLiteral(String.valueOf(c), list);
    }

    private void addLiteral(String str, List<List<FormatItem<U>>> list) {
        lastOn(list).add(new LiteralItem(str));
    }

    private void addPluralItem(String str, List<List<FormatItem<U>>> list) {
        Locale locale;
        String[] split = str.split(":");
        if (split.length > 9 || split.length < 4) {
            throw new IllegalArgumentException("Plural information has wrong format: " + str);
        } else if (split[0].length() == 1) {
            Object unit = getUnit(split[0].charAt(0));
            String[] split2 = split[2].split("-|_");
            String str2 = split2[0];
            int i = 3;
            if (split2.length > 1) {
                String str3 = split2[1];
                if (split2.length > 2) {
                    String str4 = split2[2];
                    if (split2.length <= 3) {
                        locale = new Locale(str2, str3, str4);
                    } else {
                        throw new IllegalArgumentException("Plural information has wrong locale: " + str);
                    }
                } else {
                    locale = new Locale(str2, str3);
                }
            } else {
                locale = new Locale(str2);
            }
            EnumMap enumMap = new EnumMap(PluralCategory.class);
            PluralRules of = PluralRules.of(locale, NumberType.CARDINALS);
            while (i < split.length) {
                String[] split3 = split[i].split("=");
                if (split3.length == 2) {
                    enumMap.put(PluralCategory.valueOf(split3[0]), split3[1]);
                    i++;
                } else {
                    throw new IllegalArgumentException("Plural information has wrong format: " + str);
                }
            }
            if (enumMap.isEmpty()) {
                throw new IllegalArgumentException("Missing plural forms: " + str);
            } else if (enumMap.containsKey(PluralCategory.OTHER)) {
                lastOn(list).add(new PluralItem(unit, split[1], of, enumMap));
            } else {
                throw new IllegalArgumentException("Missing plural category OTHER: " + str);
            }
        } else {
            throw new IllegalArgumentException("Plural information has wrong symbol: " + str);
        }
    }

    private static <U> void startOptionalSection(List<List<FormatItem<U>>> list) {
        list.add(new ArrayList());
    }

    private static <U> void endOptionalSection(List<List<FormatItem<U>>> list) {
        int size = list.size() - 1;
        if (size >= 1) {
            list.get(size - 1).add(new OptionalSectionItem(list.remove(size)));
            return;
        }
        throw new IllegalArgumentException("Closing square bracket without open one.");
    }

    private static <U> List<FormatItem<U>> lastOn(List<List<FormatItem<U>>> list) {
        return list.get(list.size() - 1);
    }

    private static abstract class FormatItem<U> {
        private final int reserved;

        /* access modifiers changed from: package-private */
        public abstract int getMinWidth();

        /* access modifiers changed from: package-private */
        public boolean isZero(TimeSpan<? super U> timeSpan) {
            return true;
        }

        /* access modifiers changed from: package-private */
        public abstract int parse(Map<Object, Long> map, CharSequence charSequence, int i);

        /* access modifiers changed from: package-private */
        public abstract void print(TimeSpan<? super U> timeSpan, Appendable appendable) throws IOException;

        /* access modifiers changed from: package-private */
        public abstract FormatItem<U> update(int i);

        FormatItem(int i) {
            this.reserved = i;
        }

        /* access modifiers changed from: package-private */
        public int getReserved() {
            return this.reserved;
        }
    }

    private static class NumberItem<U> extends FormatItem<U> {
        private final int maxWidth;
        private final int minWidth;
        private final U unit;

        private NumberItem(int i, int i2, int i3, U u) {
            super(i);
            if (i2 < 1 || i2 > 18) {
                throw new IllegalArgumentException("Min width out of bounds: " + i2);
            } else if (i3 < i2) {
                throw new IllegalArgumentException("Max width smaller than min width.");
            } else if (i3 <= 18) {
                Objects.requireNonNull(u, "Missing unit.");
                this.minWidth = i2;
                this.maxWidth = i3;
                this.unit = u;
            } else {
                throw new IllegalArgumentException("Max width out of bounds: " + i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void print(TimeSpan<? super U> timeSpan, Appendable appendable) throws IOException {
            String valueOf = String.valueOf(getAmount(timeSpan));
            if (valueOf.length() <= this.maxWidth) {
                for (int length = this.minWidth - valueOf.length(); length > 0; length--) {
                    appendable.append('0');
                }
                appendable.append(valueOf);
                return;
            }
            throw new IllegalArgumentException("Too many digits for: " + this.unit + " [" + timeSpan + "]");
        }

        /* access modifiers changed from: package-private */
        public int parse(Map<Object, Long> map, CharSequence charSequence, int i) {
            int length = charSequence.length() - getReserved();
            long j = 0;
            int i2 = i;
            int i3 = i2;
            while (i2 < length) {
                char charAt = charSequence.charAt(i2);
                if (charAt < '0' || charAt > '9' || i2 - i >= this.maxWidth) {
                    break;
                }
                j = (j * 10) + ((long) (charAt - '0'));
                i3++;
                i2++;
            }
            if (i3 == i) {
                return ~i;
            }
            Long valueOf = Long.valueOf(j);
            Long put = map.put(this.unit, valueOf);
            return (put == null || put.equals(valueOf)) ? i3 : ~i;
        }

        /* access modifiers changed from: package-private */
        public int getMinWidth() {
            return this.minWidth;
        }

        /* access modifiers changed from: package-private */
        public FormatItem<U> update(int i) {
            return new NumberItem(i, this.minWidth, this.maxWidth, this.unit);
        }

        /* access modifiers changed from: package-private */
        public boolean isZero(TimeSpan<? super U> timeSpan) {
            return getAmount(timeSpan) == 0;
        }

        /* access modifiers changed from: package-private */
        public long getAmount(TimeSpan<? super U> timeSpan) {
            return timeSpan.getPartialAmount(this.unit);
        }

        /* access modifiers changed from: package-private */
        public U getUnit() {
            return this.unit;
        }
    }

    private static class FractionItem<U> extends FormatItem<U> {
        private final U nanosecond;
        private final int width;

        private FractionItem(int i, int i2, U u) {
            super(i);
            if (i2 < 1 || i2 > 9) {
                throw new IllegalArgumentException("Fraction width out of bounds: " + i2);
            }
            this.width = i2;
            this.nanosecond = u;
        }

        /* access modifiers changed from: package-private */
        public void print(TimeSpan<? super U> timeSpan, Appendable appendable) throws IOException {
            String valueOf = String.valueOf(timeSpan.getPartialAmount(this.nanosecond));
            int length = valueOf.length();
            if (length <= 9) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 9 - length; i++) {
                    sb.append('0');
                }
                sb.append(valueOf);
                appendable.append(sb.toString().substring(0, this.width));
                return;
            }
            throw new IllegalArgumentException("Too many nanoseconds, consider normalization: " + timeSpan);
        }

        /* access modifiers changed from: package-private */
        public int parse(Map<Object, Long> map, CharSequence charSequence, int i) {
            char charAt;
            StringBuilder sb = new StringBuilder();
            int min = Math.min(charSequence.length() - getReserved(), this.width + i);
            int i2 = i;
            int i3 = i2;
            while (i2 < min && (charAt = charSequence.charAt(i2)) >= '0' && charAt <= '9') {
                sb.append(charAt);
                i3++;
                i2++;
            }
            if (i3 == i) {
                return ~i;
            }
            int i4 = i3 - i;
            for (int i5 = 0; i5 < 9 - i4; i5++) {
                sb.append('0');
            }
            Long valueOf = Long.valueOf(Long.parseLong(sb.toString()));
            Long put = map.put(this.nanosecond, valueOf);
            return (put == null || put.equals(valueOf)) ? i3 : ~i;
        }

        /* access modifiers changed from: package-private */
        public int getMinWidth() {
            return this.width;
        }

        /* access modifiers changed from: package-private */
        public FormatItem<U> update(int i) {
            return new FractionItem(i, this.width, this.nanosecond);
        }

        /* access modifiers changed from: package-private */
        public boolean isZero(TimeSpan<? super U> timeSpan) {
            return timeSpan.getPartialAmount(this.nanosecond) == 0;
        }
    }

    private static class PluralItem<U> extends FormatItem<U> {
        private final int minWidth;
        private final NumberItem<U> numItem;
        private final Map<PluralCategory, String> pluralForms;
        private final PluralRules rules;
        private final FormatItem<U> sepItem;

        private PluralItem(U u, String str, PluralRules pluralRules, Map<PluralCategory, String> map) {
            super(0);
            this.numItem = new NumberItem(0, 1, 18, u);
            this.sepItem = new LiteralItem(str, true);
            this.rules = pluralRules;
            this.pluralForms = map;
            int i = Integer.MAX_VALUE;
            for (String next : map.values()) {
                if (next.length() < i) {
                    i = next.length();
                }
            }
            this.minWidth = i;
        }

        private PluralItem(int i, NumberItem<U> numberItem, FormatItem<U> formatItem, PluralRules pluralRules, Map<PluralCategory, String> map, int i2) {
            super(i);
            this.numItem = numberItem;
            this.sepItem = formatItem;
            this.rules = pluralRules;
            this.pluralForms = map;
            this.minWidth = i2;
        }

        /* access modifiers changed from: package-private */
        public void print(TimeSpan<? super U> timeSpan, Appendable appendable) throws IOException {
            this.numItem.print(timeSpan, appendable);
            this.sepItem.print(timeSpan, appendable);
            appendable.append(this.pluralForms.get(this.rules.getCategory(this.numItem.getAmount(timeSpan))));
        }

        /* access modifiers changed from: package-private */
        public int parse(Map<Object, Long> map, CharSequence charSequence, int i) {
            int parse = this.numItem.parse(map, charSequence, i);
            if (parse < 0) {
                return parse;
            }
            int parse2 = this.sepItem.parse(map, charSequence, parse);
            if (parse2 < 0) {
                return parse2;
            }
            String str = this.pluralForms.get(this.rules.getCategory(map.get(this.numItem.getUnit()).longValue()));
            int length = str.length();
            int i2 = parse2 + length;
            if (i2 > charSequence.length() - getReserved()) {
                return ~i;
            }
            for (int i3 = 0; i3 < length; i3++) {
                if (str.charAt(i3) != charSequence.charAt(parse2 + i3)) {
                    return ~i;
                }
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int getMinWidth() {
            return this.minWidth;
        }

        /* access modifiers changed from: package-private */
        public FormatItem<U> update(int i) {
            return new PluralItem(i, this.numItem, this.sepItem, this.rules, this.pluralForms, this.minWidth);
        }

        /* access modifiers changed from: package-private */
        public boolean isZero(TimeSpan<? super U> timeSpan) {
            return this.numItem.isZero(timeSpan);
        }
    }

    private static class SeparatorItem<U> extends FormatItem<U> {
        private final char alt;
        private final char separator;

        /* access modifiers changed from: package-private */
        public int getMinWidth() {
            return 1;
        }

        private SeparatorItem(char c, char c2) {
            this(0, c, c2);
        }

        private SeparatorItem(int i, char c, char c2) {
            super(i);
            this.separator = c;
            this.alt = c2;
        }

        /* access modifiers changed from: package-private */
        public void print(TimeSpan<? super U> timeSpan, Appendable appendable) throws IOException {
            appendable.append(this.separator);
        }

        /* access modifiers changed from: package-private */
        public int parse(Map<Object, Long> map, CharSequence charSequence, int i) {
            if (i >= charSequence.length() - getReserved()) {
                return ~i;
            }
            char charAt = charSequence.charAt(i);
            return (charAt == this.separator || charAt == this.alt) ? i + 1 : ~i;
        }

        /* access modifiers changed from: package-private */
        public FormatItem<U> update(int i) {
            return new SeparatorItem(i, this.separator, this.alt);
        }
    }

    private static class OrItem<U> extends FormatItem<U> {
        static final OrItem INSTANCE = new OrItem();

        /* access modifiers changed from: package-private */
        public int getMinWidth() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public int parse(Map<Object, Long> map, CharSequence charSequence, int i) {
            return i;
        }

        /* access modifiers changed from: package-private */
        public void print(TimeSpan<? super U> timeSpan, Appendable appendable) throws IOException {
        }

        /* access modifiers changed from: package-private */
        public FormatItem<U> update(int i) {
            return this;
        }

        private OrItem() {
            super(0);
        }

        static <U> FormatItem<U> getInstance() {
            return INSTANCE;
        }
    }

    private static class LiteralItem<U> extends FormatItem<U> {
        private final String literal;

        private LiteralItem(String str) {
            this(str, false);
        }

        private LiteralItem(String str, boolean z) {
            super(0);
            if (z || !str.isEmpty()) {
                this.literal = str;
                return;
            }
            throw new IllegalArgumentException("Literal is empty.");
        }

        private LiteralItem(int i, String str) {
            super(i);
            this.literal = str;
        }

        /* access modifiers changed from: package-private */
        public void print(TimeSpan<? super U> timeSpan, Appendable appendable) throws IOException {
            appendable.append(this.literal);
        }

        /* access modifiers changed from: package-private */
        public int parse(Map<Object, Long> map, CharSequence charSequence, int i) {
            int length = this.literal.length() + i;
            if (length > charSequence.length() - getReserved()) {
                return ~i;
            }
            for (int i2 = i; i2 < length; i2++) {
                if (charSequence.charAt(i2) != this.literal.charAt(i2 - i)) {
                    return ~i;
                }
            }
            return length;
        }

        /* access modifiers changed from: package-private */
        public int getMinWidth() {
            return this.literal.length();
        }

        /* access modifiers changed from: package-private */
        public FormatItem<U> update(int i) {
            return new LiteralItem(i, this.literal);
        }
    }

    private static class SignItem<U> extends FormatItem<U> {
        private final boolean always;

        private SignItem(boolean z) {
            super(0);
            this.always = z;
        }

        private SignItem(int i, boolean z) {
            super(i);
            this.always = z;
        }

        /* access modifiers changed from: package-private */
        public void print(TimeSpan<? super U> timeSpan, Appendable appendable) throws IOException {
            boolean z = this.always;
            char c = SignatureVisitor.SUPER;
            if (z) {
                if (!timeSpan.isNegative()) {
                    c = SignatureVisitor.EXTENDS;
                }
                appendable.append(c);
            } else if (timeSpan.isNegative()) {
                appendable.append(SignatureVisitor.SUPER);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0070 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int parse(java.util.Map<java.lang.Object, java.lang.Long> r7, java.lang.CharSequence r8, int r9) {
            /*
                r6 = this;
                int r0 = r8.length()
                int r1 = r6.getReserved()
                int r0 = r0 - r1
                r1 = 1
                java.lang.Long r3 = java.lang.Long.valueOf(r1)
                if (r9 < r0) goto L_0x002e
                boolean r8 = r6.always
                if (r8 == 0) goto L_0x0017
                int r7 = ~r9
                return r7
            L_0x0017:
                java.lang.Object r8 = net.time4j.format.TimeSpanFormatter.SIGN_KEY
                java.lang.Object r7 = r7.put(r8, r3)
                java.lang.Long r7 = (java.lang.Long) r7
                if (r7 == 0) goto L_0x002d
                long r7 = r7.longValue()
                int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                if (r0 == 0) goto L_0x002d
                int r7 = ~r9
                return r7
            L_0x002d:
                return r9
            L_0x002e:
                char r8 = r8.charAt(r9)
                boolean r0 = r6.always
                r1 = -1
                r4 = 45
                r5 = 43
                if (r0 == 0) goto L_0x004a
                if (r8 != r5) goto L_0x0041
            L_0x003e:
                int r8 = r9 + 1
                goto L_0x0056
            L_0x0041:
                if (r8 != r4) goto L_0x0048
                java.lang.Long r3 = java.lang.Long.valueOf(r1)
                goto L_0x003e
            L_0x0048:
                int r7 = ~r9
                return r7
            L_0x004a:
                if (r8 != r5) goto L_0x004e
                int r7 = ~r9
                return r7
            L_0x004e:
                if (r8 != r4) goto L_0x0055
                java.lang.Long r3 = java.lang.Long.valueOf(r1)
                goto L_0x003e
            L_0x0055:
                r8 = r9
            L_0x0056:
                java.lang.Object r0 = net.time4j.format.TimeSpanFormatter.SIGN_KEY
                java.lang.Object r7 = r7.put(r0, r3)
                java.lang.Long r7 = (java.lang.Long) r7
                if (r7 == 0) goto L_0x0070
                long r0 = r7.longValue()
                long r2 = r3.longValue()
                int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r7 == 0) goto L_0x0070
                int r7 = ~r9
                return r7
            L_0x0070:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.TimeSpanFormatter.SignItem.parse(java.util.Map, java.lang.CharSequence, int):int");
        }

        /* access modifiers changed from: package-private */
        public int getMinWidth() {
            return this.always ? 1 : 0;
        }

        /* access modifiers changed from: package-private */
        public FormatItem<U> update(int i) {
            return new SignItem(i, this.always);
        }
    }

    private static class OptionalSectionItem<U> extends FormatItem<U> {
        private final List<FormatItem<U>> items;

        /* access modifiers changed from: package-private */
        public int getMinWidth() {
            return 0;
        }

        private OptionalSectionItem(List<FormatItem<U>> list) {
            super(0);
            if (list.isEmpty()) {
                throw new IllegalArgumentException("Optional section is empty.");
            } else if (list.get(0) == OrItem.INSTANCE || list.get(list.size() - 1) == OrItem.INSTANCE) {
                throw new IllegalArgumentException("Optional section must not start or end with an or-operator.");
            } else {
                this.items = Collections.unmodifiableList(list);
            }
        }

        /* access modifiers changed from: package-private */
        public void print(TimeSpan<? super U> timeSpan, Appendable appendable) throws IOException {
            FormatItem next;
            if (!isZero(timeSpan)) {
                Iterator<FormatItem<U>> it = this.items.iterator();
                while (it.hasNext() && (next = it.next()) != OrItem.INSTANCE) {
                    next.print(timeSpan, appendable);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int parse(Map<Object, Long> map, CharSequence charSequence, int i) {
            HashMap hashMap = new HashMap();
            int size = this.items.size();
            int i2 = 0;
            int i3 = i;
            while (i2 < size) {
                FormatItem formatItem = this.items.get(i2);
                if (formatItem == OrItem.INSTANCE) {
                    break;
                }
                int parse = formatItem.parse(hashMap, charSequence, i3);
                if (parse < 0) {
                    while (true) {
                        i2++;
                        if (i2 < size) {
                            if (this.items.get(i2) == OrItem.INSTANCE) {
                                break;
                            }
                        } else {
                            i2 = -1;
                            break;
                        }
                    }
                    if (i2 == -1) {
                        return i;
                    }
                    hashMap.clear();
                } else {
                    i3 = parse;
                }
                i2++;
            }
            map.putAll(hashMap);
            return i3;
        }

        /* access modifiers changed from: package-private */
        public FormatItem<U> update(int i) {
            ArrayList arrayList = new ArrayList(this.items);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                FormatItem formatItem = (FormatItem) arrayList.get(size);
                arrayList.set(size, formatItem.update(i));
                i += formatItem.getMinWidth();
            }
            return new OptionalSectionItem(arrayList);
        }

        /* access modifiers changed from: package-private */
        public boolean isZero(TimeSpan<? super U> timeSpan) {
            for (FormatItem<U> isZero : this.items) {
                if (!isZero.isZero(timeSpan)) {
                    return false;
                }
            }
            return true;
        }
    }
}
