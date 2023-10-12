package net.time4j.calendar;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoException;
import net.time4j.engine.EpochDays;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;

public final class Nengo implements CalendarEra, Serializable {
    /* access modifiers changed from: private */
    public static final Map<String, Nengo> CHINESE_TO_NENGO;
    private static final byte COURT_NORTHERN = 1;
    private static final byte COURT_SOUTHERN = -1;
    private static final byte COURT_STANDARD = 0;
    public static final Nengo HEISEI;
    /* access modifiers changed from: private */
    public static final Map<String, Nengo> KANJI_TO_NENGO;
    /* access modifiers changed from: private */
    public static final TST KOREAN_TO_NENGO;
    public static final Nengo MEIJI;
    /* access modifiers changed from: private */
    public static final String[] MODERN_KEYS = {"reiwa", "heisei", "showa", "taisho", "meiji"};
    /* access modifiers changed from: private */
    public static final Nengo[] MODERN_NENGOS;
    private static final Nengo NENGO_KENMU;
    private static final Nengo NENGO_OEI;
    public static final Nengo NEWEST;
    private static final String NEW_ERA_PROPERTY = "net.time4j.calendar.japanese.supplemental.era";
    private static final Nengo[] NORTHERN_NENGOS;
    /* access modifiers changed from: private */
    public static final Nengo[] OFFICIAL_NENGOS;
    public static final Nengo REIWA;
    /* access modifiers changed from: private */
    public static final TST ROMAJI_TO_NENGO;
    /* access modifiers changed from: private */
    public static final TST RUSSIAN_TO_NENGO;
    public static final AttributeKey<Selector> SELECTOR = Attributes.createKey("NENGO_SELECTOR", Selector.class);
    public static final Nengo SHOWA;
    public static final Nengo TAISHO;
    private static final long serialVersionUID = 5696395761628504723L;
    private final transient String chinese;
    /* access modifiers changed from: private */
    public final byte court;
    /* access modifiers changed from: private */
    public final int index;
    private final transient String kanji;
    private final transient String korean;
    /* access modifiers changed from: private */
    public final transient int relgregyear;
    private final transient String romaji;
    private final transient String russian;
    /* access modifiers changed from: private */
    public final transient long start;

    public enum Selector implements ChronoCondition<Nengo> {
        OFFICIAL {
            public boolean test(Nengo nengo) {
                return nengo.court != 1;
            }
        },
        MODERN {
            public boolean test(Nengo nengo) {
                return nengo.index >= Nengo.MEIJI.index;
            }
        },
        EDO_PERIOD {
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1603 && nengo.relgregyear < 1868;
            }
        },
        AZUCHI_MOMOYAMA_PERIOD {
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1573 && nengo.relgregyear < 1603;
            }
        },
        MUROMACHI_PERIOD {
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1336 && nengo.relgregyear < 1573 && nengo.court != 1;
            }
        },
        NORTHERN_COURT {
            public boolean test(Nengo nengo) {
                return nengo.court == 1;
            }
        },
        SOUTHERN_COURT {
            public boolean test(Nengo nengo) {
                return nengo.court == -1;
            }
        },
        KAMAKURA_PERIOD {
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 1185 && nengo.relgregyear < 1332;
            }
        },
        HEIAN_PERIOD {
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 794 && nengo.relgregyear < 1185;
            }
        },
        NARA_PERIOD {
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 710 && nengo.relgregyear < 794;
            }
        },
        ASUKA_PERIOD {
            public boolean test(Nengo nengo) {
                return nengo.relgregyear >= 538 && nengo.relgregyear < 710;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01c8, code lost:
        if (r8.length != 2) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d3, code lost:
        if (r8[0].equals("name") != false) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01d5, code lost:
        r14 = hepburn(r8[1], 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e9, code lost:
        if (r8[0].equals("kanji") != false) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01eb, code lost:
        r8 = r8[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f3, code lost:
        if (r8.length() == 2) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01f5, code lost:
        r15 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01fe, code lost:
        throw new java.lang.IllegalArgumentException("Japanese kanji must be of length 2.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0208, code lost:
        if (r8[0].equals("chinese") != false) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x020a, code lost:
        r8 = r8[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0212, code lost:
        if (r8.length() == 2) goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0214, code lost:
        r24 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x021e, code lost:
        throw new java.lang.IllegalArgumentException("Chinese kanji must be of length 2.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0228, code lost:
        if (r8[0].equals("korean") != false) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x022a, code lost:
        r13 = r8[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0238, code lost:
        if (r8[0].equals("russian") != false) goto L_0x023a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x023a, code lost:
        r16 = capitalize(r8[1], 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x024e, code lost:
        if (r8[0].equals("since") != false) goto L_0x0250;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0257, code lost:
        r12 = net.time4j.format.expert.Iso8601Format.parseDate(r8[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0258, code lost:
        r2 = r2 + 1;
        r10 = r17;
        r8 = r18;
        r11 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0262, code lost:
        r25 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0264, code lost:
        if (r14 == null) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x026a, code lost:
        r0 = (net.time4j.calendar.Nengo) r1.get(r1.size() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x027e, code lost:
        if (r12.isAfter((net.time4j.engine.CalendarDate) r0.getStart()) != false) goto L_0x0280;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0280, code lost:
        if (r24 == null) goto L_0x0282;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0282, code lost:
        r0 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0284, code lost:
        r0 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0286, code lost:
        if (r13 == null) goto L_0x0288;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0288, code lost:
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x028a, code lost:
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x028b, code lost:
        if (r16 == null) goto L_0x028d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x028d, code lost:
        r8 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x028f, code lost:
        r8 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0291, code lost:
        r11 = r14;
        r24 = r15;
        r12 = new net.time4j.calendar.Nengo(r12.getYear(), r12.getDaysSinceEpochUTC(), r24, r0, r2, r8, r11, (byte) 0, r1.size());
        r1.add(r12);
        r3.put(r24, r12);
        r4.put(r0, r12);
        r5.insert(r2, r12);
        r7.insert(r8, r12);
        r6.insert(r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02e1, code lost:
        throw new java.lang.IllegalStateException("New Japanese era must be after last defined nengo: " + r0.romaji);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02f8, code lost:
        throw new java.lang.IllegalStateException("Invalid syntax: " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02f9, code lost:
        r25 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0096, code lost:
        r31 = r2;
        r9 = r25;
        r11 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009c, code lost:
        r6 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0111, code lost:
        if (r14.relgregyear != r9) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0117, code lost:
        r9 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0170, code lost:
        r6 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0178, code lost:
        r31 = r2;
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0180, code lost:
        r31 = r2;
        r6 = r8;
        r26 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0185, code lost:
        r9 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0188, code lost:
        r31 = r2;
        r6 = r8;
        r25 = r9;
        r26 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0190, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0198, code lost:
        throw new java.lang.IllegalStateException("Invalid nengo data.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0199, code lost:
        r31 = r2;
        r6 = r8;
        r9 = null;
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a6, code lost:
        r8 = r0.split(",");
        r10 = r8.length;
        r2 = 0;
        r12 = null;
        r13 = null;
        r14 = null;
        r15 = null;
        r16 = null;
        r24 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01b6, code lost:
        if (r2 < r10) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01b8, code lost:
        r17 = r10;
        r18 = r8;
        r8 = r8[r2].split("=");
        r25 = r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0190 A[ExcHandler: IOException (r0v26 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:6:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01a6  */
    static {
        /*
            java.lang.Class<net.time4j.calendar.Nengo> r0 = net.time4j.calendar.Nengo.class
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 256(0x100, float:3.59E-43)
            r1.<init>(r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 16
            r2.<init>(r3)
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            net.time4j.calendar.Nengo$TST r5 = new net.time4j.calendar.Nengo$TST
            r6 = 0
            r5.<init>()
            net.time4j.calendar.Nengo$TST r7 = new net.time4j.calendar.Nengo$TST
            r7.<init>()
            net.time4j.calendar.Nengo$TST r8 = new net.time4j.calendar.Nengo$TST
            r8.<init>()
            net.time4j.base.ResourceLoader r9 = net.time4j.base.ResourceLoader.getInstance()
            java.lang.String r10 = "calendar"
            java.lang.String r11 = "data/nengo.data"
            java.net.URI r9 = r9.locate(r10, r0, r11)
            net.time4j.base.ResourceLoader r10 = net.time4j.base.ResourceLoader.getInstance()
            r12 = 1
            java.io.InputStream r9 = r10.load(r9, r12)
            if (r9 != 0) goto L_0x0051
            net.time4j.base.ResourceLoader r9 = net.time4j.base.ResourceLoader.getInstance()     // Catch:{ EOFException -> 0x004a, IOException -> 0x0190 }
            java.io.InputStream r9 = r9.load(r0, r11, r12)     // Catch:{ EOFException -> 0x004a, IOException -> 0x0190 }
            goto L_0x0051
        L_0x004a:
            r31 = r2
            r9 = r6
            r11 = r9
            r6 = r8
            goto L_0x019e
        L_0x0051:
            java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch:{ EOFException -> 0x0199, IOException -> 0x0190 }
            r0.<init>(r9)     // Catch:{ EOFException -> 0x0199, IOException -> 0x0190 }
            r9 = r6
            r11 = r9
        L_0x0058:
            short r15 = r0.readShort()     // Catch:{ EOFException -> 0x0188, IOException -> 0x0190 }
            int r13 = r0.readInt()     // Catch:{ EOFException -> 0x0188, IOException -> 0x0190 }
            java.lang.String r14 = r0.readUTF()     // Catch:{ EOFException -> 0x0188, IOException -> 0x0190 }
            java.lang.String r6 = r0.readUTF()     // Catch:{ EOFException -> 0x0188, IOException -> 0x0190 }
            java.lang.String r12 = r0.readUTF()     // Catch:{ EOFException -> 0x0188, IOException -> 0x0190 }
            java.lang.String r10 = r0.readUTF()     // Catch:{ EOFException -> 0x0188, IOException -> 0x0190 }
            r25 = r9
            byte r9 = r0.readByte()     // Catch:{ EOFException -> 0x0180, IOException -> 0x0190 }
            r26 = r11
            byte r11 = r0.readByte()     // Catch:{ EOFException -> 0x0178, IOException -> 0x0190 }
            r27 = r8
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ EOFException -> 0x0173, IOException -> 0x0190 }
            r8.<init>(r11)     // Catch:{ EOFException -> 0x0173, IOException -> 0x0190 }
            r16 = r14
            r14 = 0
        L_0x0086:
            if (r14 >= r11) goto L_0x00a0
            r17 = r11
            java.lang.String r11 = r0.readUTF()     // Catch:{ EOFException -> 0x0096, IOException -> 0x0190 }
            r8.add(r11)     // Catch:{ EOFException -> 0x0096, IOException -> 0x0190 }
            int r14 = r14 + 1
            r11 = r17
            goto L_0x0086
        L_0x0096:
            r31 = r2
            r9 = r25
            r11 = r26
        L_0x009c:
            r6 = r27
            goto L_0x019e
        L_0x00a0:
            r11 = 0
            java.lang.Object r14 = r8.get(r11)     // Catch:{ EOFException -> 0x0173, IOException -> 0x0190 }
            r21 = r14
            java.lang.String r21 = (java.lang.String) r21     // Catch:{ EOFException -> 0x0173, IOException -> 0x0190 }
            r14 = 1
            if (r9 != r14) goto L_0x00d5
            net.time4j.calendar.Nengo r14 = new net.time4j.calendar.Nengo     // Catch:{ EOFException -> 0x0096, IOException -> 0x0190 }
            r28 = r12
            long r11 = (long) r13     // Catch:{ EOFException -> 0x0096, IOException -> 0x0190 }
            int r23 = r2.size()     // Catch:{ EOFException -> 0x0096, IOException -> 0x0190 }
            r13 = r14
            r29 = r0
            r0 = r14
            r30 = r16
            r14 = r15
            r15 = r11
            r17 = r30
            r18 = r6
            r19 = r28
            r20 = r10
            r22 = r9
            r13.<init>(r14, r15, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ EOFException -> 0x0096, IOException -> 0x0190 }
            r2.add(r0)     // Catch:{ EOFException -> 0x0096, IOException -> 0x0190 }
            r14 = r0
            r31 = r2
            r11 = r26
            r9 = 1334(0x536, float:1.87E-42)
            goto L_0x010a
        L_0x00d5:
            r29 = r0
            r28 = r12
            r30 = r16
            net.time4j.calendar.Nengo r0 = new net.time4j.calendar.Nengo     // Catch:{ EOFException -> 0x0173, IOException -> 0x0190 }
            long r11 = (long) r13     // Catch:{ EOFException -> 0x0173, IOException -> 0x0190 }
            int r23 = r1.size()     // Catch:{ EOFException -> 0x0173, IOException -> 0x0190 }
            r13 = r0
            r14 = r15
            r31 = r2
            r2 = r15
            r15 = r11
            r17 = r30
            r18 = r6
            r19 = r28
            r20 = r10
            r22 = r9
            r13.<init>(r14, r15, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ EOFException -> 0x0175, IOException -> 0x0190 }
            r1.add(r0)     // Catch:{ EOFException -> 0x0175, IOException -> 0x0190 }
            r9 = 1334(0x536, float:1.87E-42)
            if (r2 != r9) goto L_0x0100
            r14 = r0
            r25 = r14
            goto L_0x0108
        L_0x0100:
            r11 = 1394(0x572, float:1.953E-42)
            if (r2 != r11) goto L_0x0107
            r11 = r0
            r14 = r11
            goto L_0x010a
        L_0x0107:
            r14 = r0
        L_0x0108:
            r11 = r26
        L_0x010a:
            byte r0 = r14.court     // Catch:{ EOFException -> 0x0170, IOException -> 0x0190 }
            r2 = 1
            if (r0 != r2) goto L_0x011a
            int r0 = r14.relgregyear     // Catch:{ EOFException -> 0x0117, IOException -> 0x0190 }
            if (r0 == r9) goto L_0x0114
            goto L_0x011a
        L_0x0114:
            r6 = r27
            goto L_0x0145
        L_0x0117:
            r9 = r25
            goto L_0x009c
        L_0x011a:
            r0 = r30
            r3.put(r0, r14)     // Catch:{ EOFException -> 0x0170, IOException -> 0x0190 }
            java.lang.Object r0 = r4.put(r6, r14)     // Catch:{ EOFException -> 0x0170, IOException -> 0x0190 }
            if (r0 != 0) goto L_0x0150
            r0 = r28
            r5.insert(r0, r14)     // Catch:{ EOFException -> 0x0170, IOException -> 0x0190 }
            r7.insert(r10, r14)     // Catch:{ EOFException -> 0x0170, IOException -> 0x0190 }
            java.util.Iterator r0 = r8.iterator()     // Catch:{ EOFException -> 0x0170, IOException -> 0x0190 }
        L_0x0131:
            boolean r2 = r0.hasNext()     // Catch:{ EOFException -> 0x0170, IOException -> 0x0190 }
            if (r2 == 0) goto L_0x0114
            java.lang.Object r2 = r0.next()     // Catch:{ EOFException -> 0x0170, IOException -> 0x0190 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ EOFException -> 0x0170, IOException -> 0x0190 }
            r6 = r27
            r6.insert(r2, r14)     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            r27 = r6
            goto L_0x0131
        L_0x0145:
            r8 = r6
            r9 = r25
            r0 = r29
            r2 = r31
            r6 = 0
            r12 = 1
            goto L_0x0058
        L_0x0150:
            r6 = r27
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            r2.<init>()     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            int r8 = r14.relgregyear     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            r2.append(r8)     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            java.lang.String r8 = " "
            r2.append(r8)     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            java.lang.String r8 = r14.chinese     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            r2.append(r8)     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            java.lang.String r2 = r2.toString()     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            r0.<init>(r2)     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
            throw r0     // Catch:{ EOFException -> 0x0185, IOException -> 0x0190 }
        L_0x0170:
            r6 = r27
            goto L_0x0185
        L_0x0173:
            r31 = r2
        L_0x0175:
            r6 = r27
            goto L_0x017b
        L_0x0178:
            r31 = r2
            r6 = r8
        L_0x017b:
            r9 = r25
            r11 = r26
            goto L_0x019e
        L_0x0180:
            r31 = r2
            r6 = r8
            r26 = r11
        L_0x0185:
            r9 = r25
            goto L_0x019e
        L_0x0188:
            r31 = r2
            r6 = r8
            r25 = r9
            r26 = r11
            goto L_0x019e
        L_0x0190:
            r0 = move-exception
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Invalid nengo data."
            r1.<init>(r2, r0)
            throw r1
        L_0x0199:
            r31 = r2
            r6 = r8
            r9 = 0
            r11 = 0
        L_0x019e:
            java.lang.String r0 = "net.time4j.calendar.japanese.supplemental.era"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L_0x02f9
            java.lang.String r8 = ","
            java.lang.String[] r8 = r0.split(r8)
            int r10 = r8.length
            r2 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r24 = 0
        L_0x01b6:
            if (r2 >= r10) goto L_0x0262
            r17 = r10
            r10 = r8[r2]
            r18 = r8
            java.lang.String r8 = "="
            java.lang.String[] r8 = r10.split(r8)
            int r10 = r8.length
            r25 = r11
            r11 = 2
            if (r10 != r11) goto L_0x0258
            r10 = 0
            r11 = r8[r10]
            java.lang.String r10 = "name"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x01e0
            r10 = 1
            r8 = r8[r10]
            r11 = 0
            java.lang.String r8 = hepburn(r8, r11)
            r14 = r8
            goto L_0x0258
        L_0x01e0:
            r11 = 0
            r10 = r8[r11]
            java.lang.String r11 = "kanji"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x01ff
            r10 = 1
            r8 = r8[r10]
            int r10 = r8.length()
            r11 = 2
            if (r10 != r11) goto L_0x01f7
            r15 = r8
            goto L_0x0258
        L_0x01f7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Japanese kanji must be of length 2."
            r0.<init>(r1)
            throw r0
        L_0x01ff:
            r10 = 0
            r11 = r8[r10]
            java.lang.String r10 = "chinese"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x021f
            r10 = 1
            r8 = r8[r10]
            int r10 = r8.length()
            r11 = 2
            if (r10 != r11) goto L_0x0217
            r24 = r8
            goto L_0x0258
        L_0x0217:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Chinese kanji must be of length 2."
            r0.<init>(r1)
            throw r0
        L_0x021f:
            r10 = 0
            r11 = r8[r10]
            java.lang.String r10 = "korean"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x022f
            r10 = 1
            r8 = r8[r10]
            r13 = r8
            goto L_0x0258
        L_0x022f:
            r11 = 0
            r10 = r8[r11]
            java.lang.String r11 = "russian"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x0245
            r10 = 1
            r8 = r8[r10]
            r11 = 0
            java.lang.String r8 = capitalize(r8, r11)
            r16 = r8
            goto L_0x0258
        L_0x0245:
            r11 = 0
            r10 = r8[r11]
            java.lang.String r11 = "since"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x0258
            r10 = 1
            r8 = r8[r10]     // Catch:{ ParseException -> 0x0258 }
            net.time4j.PlainDate r8 = net.time4j.format.expert.Iso8601Format.parseDate(r8)     // Catch:{ ParseException -> 0x0258 }
            r12 = r8
        L_0x0258:
            int r2 = r2 + 1
            r10 = r17
            r8 = r18
            r11 = r25
            goto L_0x01b6
        L_0x0262:
            r25 = r11
            if (r14 == 0) goto L_0x02e2
            if (r15 == 0) goto L_0x02e2
            if (r12 == 0) goto L_0x02e2
            int r0 = r1.size()
            r2 = 1
            int r0 = r0 - r2
            java.lang.Object r0 = r1.get(r0)
            net.time4j.calendar.Nengo r0 = (net.time4j.calendar.Nengo) r0
            net.time4j.PlainDate r2 = r0.getStart()
            boolean r2 = r12.isAfter((net.time4j.engine.CalendarDate) r2)
            if (r2 == 0) goto L_0x02c9
            if (r24 != 0) goto L_0x0284
            r0 = r15
            goto L_0x0286
        L_0x0284:
            r0 = r24
        L_0x0286:
            if (r13 != 0) goto L_0x028a
            r2 = r14
            goto L_0x028b
        L_0x028a:
            r2 = r13
        L_0x028b:
            if (r16 != 0) goto L_0x028f
            r8 = r14
            goto L_0x0291
        L_0x028f:
            r8 = r16
        L_0x0291:
            net.time4j.calendar.Nengo r10 = new net.time4j.calendar.Nengo
            int r13 = r12.getYear()
            long r16 = r12.getDaysSinceEpochUTC()
            r21 = 0
            int r22 = r1.size()
            r12 = r10
            r11 = r14
            r24 = r15
            r14 = r16
            r16 = r24
            r17 = r0
            r18 = r2
            r19 = r8
            r20 = r11
            r12.<init>(r13, r14, r16, r17, r18, r19, r20, r21, r22)
            r1.add(r10)
            r15 = r24
            r3.put(r15, r10)
            r4.put(r0, r10)
            r5.insert(r2, r10)
            r7.insert(r8, r10)
            r6.insert(r11, r10)
            goto L_0x02fb
        L_0x02c9:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "New Japanese era must be after last defined nengo: "
            r2.append(r3)
            java.lang.String r0 = r0.romaji
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x02e2:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid syntax: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x02f9:
            r25 = r11
        L_0x02fb:
            int r0 = r1.size()
            net.time4j.calendar.Nengo[] r0 = new net.time4j.calendar.Nengo[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            net.time4j.calendar.Nengo[] r0 = (net.time4j.calendar.Nengo[]) r0
            OFFICIAL_NENGOS = r0
            int r1 = r31.size()
            net.time4j.calendar.Nengo[] r1 = new net.time4j.calendar.Nengo[r1]
            r2 = r31
            java.lang.Object[] r1 = r2.toArray(r1)
            net.time4j.calendar.Nengo[] r1 = (net.time4j.calendar.Nengo[]) r1
            NORTHERN_NENGOS = r1
            NENGO_KENMU = r9
            NENGO_OEI = r25
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r3)
            KANJI_TO_NENGO = r1
            java.util.Map r1 = java.util.Collections.unmodifiableMap(r4)
            CHINESE_TO_NENGO = r1
            KOREAN_TO_NENGO = r5
            RUSSIAN_TO_NENGO = r7
            ROMAJI_TO_NENGO = r6
            r1 = 223(0xdf, float:3.12E-43)
            r1 = r0[r1]
            MEIJI = r1
            r2 = 224(0xe0, float:3.14E-43)
            r2 = r0[r2]
            TAISHO = r2
            r3 = 225(0xe1, float:3.15E-43)
            r3 = r0[r3]
            SHOWA = r3
            r4 = 226(0xe2, float:3.17E-43)
            r4 = r0[r4]
            HEISEI = r4
            r5 = 227(0xe3, float:3.18E-43)
            r5 = r0[r5]
            REIWA = r5
            int r6 = r0.length
            r7 = 1
            int r6 = r6 - r7
            r0 = r0[r6]
            NEWEST = r0
            java.lang.Class<net.time4j.calendar.Nengo$Selector> r0 = net.time4j.calendar.Nengo.Selector.class
            java.lang.String r6 = "NENGO_SELECTOR"
            net.time4j.engine.AttributeKey r0 = net.time4j.format.Attributes.createKey(r6, r0)
            SELECTOR = r0
            java.lang.String r0 = "reiwa"
            java.lang.String r6 = "heisei"
            java.lang.String r7 = "showa"
            java.lang.String r8 = "taisho"
            java.lang.String r9 = "meiji"
            java.lang.String[] r0 = new java.lang.String[]{r0, r6, r7, r8, r9}
            MODERN_KEYS = r0
            r0 = 5
            net.time4j.calendar.Nengo[] r0 = new net.time4j.calendar.Nengo[r0]
            r6 = 0
            r0[r6] = r5
            r5 = 1
            r0[r5] = r4
            r4 = 2
            r0[r4] = r3
            r3 = 3
            r0[r3] = r2
            r2 = 4
            r0[r2] = r1
            MODERN_NENGOS = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.Nengo.<clinit>():void");
    }

    private Nengo(int i, long j, String str, String str2, String str3, String str4, String str5, byte b, int i2) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Missing kanji.");
        } else if (str5.isEmpty()) {
            throw new IllegalArgumentException("Missing latin transcription.");
        } else if (b > 1 || b < -1) {
            throw new IllegalArgumentException("Undefined court byte: " + b);
        } else {
            this.relgregyear = i;
            this.start = j;
            this.kanji = str;
            this.chinese = str2;
            this.korean = str3;
            this.russian = str4;
            this.romaji = str5;
            this.court = b;
            this.index = i2;
        }
    }

    public static Nengo ofRelatedGregorianYear(int i) {
        return ofRelatedGregorianYear(i, Selector.OFFICIAL);
    }

    public static Nengo ofRelatedGregorianYear(int i, Selector selector) {
        Nengo nengo;
        Nengo nengo2;
        Nengo nengo3 = null;
        if (i >= 701) {
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$calendar$Nengo$Selector[selector.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    int length = OFFICIAL_NENGOS.length - 1;
                    int lowerBound = getLowerBound(selector);
                    while (true) {
                        if (length < lowerBound) {
                            break;
                        }
                        nengo = OFFICIAL_NENGOS[length];
                        if (nengo.relgregyear <= i) {
                            break;
                        }
                        length--;
                    }
                } else {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            int lowerBound2 = getLowerBound(selector);
                            int upperBound = getUpperBound(selector);
                            Nengo[] nengoArr = OFFICIAL_NENGOS;
                            if (i >= nengoArr[lowerBound2].relgregyear && i <= nengoArr[upperBound + 1].relgregyear) {
                                while (true) {
                                    if (upperBound < lowerBound2) {
                                        break;
                                    }
                                    nengo = OFFICIAL_NENGOS[upperBound];
                                    if (nengo.relgregyear <= i) {
                                        break;
                                    }
                                    upperBound--;
                                }
                            }
                        } else if (i >= 1334 && i <= 1393) {
                            int i3 = NENGO_OEI.index - 1;
                            while (true) {
                                Nengo[] nengoArr2 = OFFICIAL_NENGOS;
                                if (nengoArr2[i3].court != -1) {
                                    break;
                                }
                                nengo2 = nengoArr2[i3];
                                if (nengo2.relgregyear <= i) {
                                    break;
                                }
                                i3--;
                            }
                        }
                    } else if (i >= 1332 && i <= 1394) {
                        int length2 = NORTHERN_NENGOS.length - 1;
                        while (true) {
                            if (length2 < 0) {
                                break;
                            }
                            nengo2 = NORTHERN_NENGOS[length2];
                            if (nengo2.relgregyear <= i) {
                                break;
                            }
                            length2--;
                        }
                    }
                    nengo3 = nengo2;
                }
                nengo3 = nengo;
            } else if (i >= 1873) {
                return ofRelatedGregorianYear(i, Selector.MODERN);
            } else {
                int i4 = 0;
                int length3 = OFFICIAL_NENGOS.length - 1;
                while (i4 <= length3) {
                    int i5 = (i4 + length3) >> 1;
                    if (OFFICIAL_NENGOS[i5].getFirstRelatedGregorianYear() <= i) {
                        i4 = i5 + 1;
                    } else {
                        length3 = i5 - 1;
                    }
                }
                if (i4 != 0) {
                    return OFFICIAL_NENGOS[i4 - 1];
                }
            }
        }
        if (nengo3 != null) {
            return nengo3;
        }
        throw new IllegalArgumentException("Could not find nengo for year=" + i + ", selector=" + selector + ".");
    }

    public static Nengo ofKanji(String str) {
        Nengo nengo = KANJI_TO_NENGO.get(str);
        if (nengo != null) {
            return nengo;
        }
        throw new IllegalArgumentException("Could not find any nengo for Japanese kanji: " + str);
    }

    public static List<Nengo> parseRomaji(String str) {
        String hepburn = hepburn(str, 0);
        TST tst = ROMAJI_TO_NENGO;
        return tst.find(tst.longestPrefixOf(hepburn, 0));
    }

    public static List<Nengo> list() {
        return list(Selector.OFFICIAL);
    }

    public static List<Nengo> list(Selector selector) {
        List list;
        int i = AnonymousClass1.$SwitchMap$net$time4j$calendar$Nengo$Selector[selector.ordinal()];
        if (i == 1) {
            list = Arrays.asList(OFFICIAL_NENGOS);
        } else if (i != 3) {
            int lowerBound = getLowerBound(selector);
            int upperBound = getUpperBound(selector);
            list = new ArrayList((upperBound - lowerBound) + 1);
            while (lowerBound <= upperBound) {
                list.add(OFFICIAL_NENGOS[lowerBound]);
                lowerBound++;
            }
        } else {
            list = Arrays.asList(NORTHERN_NENGOS);
        }
        return Collections.unmodifiableList(list);
    }

    public boolean matches(Selector selector) {
        return selector.test(this);
    }

    public int getFirstRelatedGregorianYear() {
        return this.relgregyear;
    }

    public PlainDate getStart() {
        return PlainDate.of(this.start, EpochDays.UTC);
    }

    public boolean isModern() {
        return this.index >= MEIJI.index;
    }

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        if (locale.getLanguage().isEmpty()) {
            return this.romaji;
        }
        int i = this.index;
        if (i >= MEIJI.index && i <= NEWEST.index && !locale.getLanguage().equals("ru")) {
            String str = null;
            int i2 = 0;
            while (true) {
                Nengo[] nengoArr = MODERN_NENGOS;
                if (i2 >= nengoArr.length) {
                    break;
                } else if (equals(nengoArr[i2])) {
                    str = MODERN_KEYS[i2];
                    break;
                } else {
                    i2++;
                }
            }
            if (str != null) {
                if (textWidth == TextWidth.NARROW) {
                    str = str + "_n";
                }
                return CalendarText.getInstance("japanese", locale).getTextForms().get(str);
            }
            throw new IllegalStateException("Modern nengos need an update.");
        } else if (locale.getLanguage().equals("ja")) {
            return this.kanji;
        } else {
            if (locale.getLanguage().equals("zh")) {
                return this.chinese;
            }
            if (locale.getLanguage().equals("ko")) {
                return this.korean;
            }
            if (!locale.getLanguage().equals("ru")) {
                return this.romaji;
            }
            return "Период " + this.russian;
        }
    }

    public Nengo findNext() {
        if (this.court == 1) {
            int i = this.index;
            Nengo[] nengoArr = NORTHERN_NENGOS;
            if (i == nengoArr.length - 1) {
                return NENGO_OEI;
            }
            return nengoArr[i + 1];
        }
        int i2 = this.index;
        Nengo[] nengoArr2 = OFFICIAL_NENGOS;
        if (i2 == nengoArr2.length - 1) {
            return null;
        }
        return nengoArr2[i2 + 1];
    }

    public Nengo findPrevious() {
        if (this.court == 1) {
            int i = this.index;
            if (i == 0) {
                return OFFICIAL_NENGOS[NENGO_KENMU.index - 1];
            }
            return NORTHERN_NENGOS[i - 1];
        }
        int i2 = this.index;
        if (i2 == 0) {
            return null;
        }
        return OFFICIAL_NENGOS[i2 - 1];
    }

    public String name() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.romaji);
        sb.append(" (");
        Nengo findNext = findNext();
        if (findNext != null) {
            sb.append(this.relgregyear);
            sb.append(SignatureVisitor.SUPER);
            sb.append(findNext.relgregyear);
        } else {
            sb.append("since ");
            sb.append(this.relgregyear);
        }
        sb.append(')');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public int getValue() {
        int i;
        int i2;
        if (matches(Selector.NORTHERN_COURT)) {
            i = (this.index - NORTHERN_NENGOS.length) + NENGO_OEI.index;
            i2 = SHOWA.index;
        } else {
            i = this.index;
            i2 = SHOWA.index;
        }
        return (i - i2) + 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Nengo)) {
            return false;
        }
        Nengo nengo = (Nengo) obj;
        if (this.relgregyear == nengo.relgregyear && this.start == nengo.start && this.kanji.equals(nengo.kanji) && this.romaji.equals(nengo.romaji) && this.court == nengo.court) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.start;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.romaji);
        sb.append(' ');
        sb.append(this.kanji);
        sb.append(' ');
        Nengo findNext = findNext();
        if (findNext != null) {
            sb.append(this.relgregyear);
            sb.append(SignatureVisitor.SUPER);
            sb.append(findNext.relgregyear);
        } else {
            sb.append("since ");
            sb.append(this.relgregyear);
        }
        if (this.court != 0) {
            sb.append(" (");
            sb.append(this.court == 1 ? 'N' : 'S');
            sb.append(')');
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public long getStartAsDaysSinceEpochUTC() {
        return this.start;
    }

    /* access modifiers changed from: package-private */
    public int getIndexOfficial() {
        return this.index;
    }

    static Nengo ofIndexOfficial(int i) {
        return OFFICIAL_NENGOS[i];
    }

    static String hepburn(CharSequence charSequence, int i) {
        int min = Math.min(charSequence.length(), i + 32);
        StringBuilder sb = null;
        for (int i2 = i; i2 < min; i2++) {
            char charAt = charSequence.charAt(i2);
            char c = 362;
            char c2 = 363;
            char c3 = 332;
            char c4 = 333;
            if (i2 == i) {
                if (!(charAt == 212 || charAt == 244 || charAt == 333)) {
                    c3 = Character.toUpperCase(charAt);
                }
                if (!(charAt == 219 || charAt == 251 || charAt == 363)) {
                    c = c3;
                }
            } else {
                if (!(charAt == 212 || charAt == 244 || charAt == 332)) {
                    c4 = Character.toLowerCase(charAt);
                }
                if (!(charAt == 219 || charAt == 251 || charAt == 362)) {
                    c2 = c4;
                }
                c = c2;
            }
            if (charAt == '\'') {
                c = Typography.rightSingleQuote;
            }
            if (charAt == ' ') {
                c = SignatureVisitor.SUPER;
            }
            if (sb != null || c != charAt) {
                if (sb == null) {
                    sb = new StringBuilder(32);
                    sb.append(charSequence.subSequence(i, i2));
                }
                sb.append(c);
            }
        }
        return sb == null ? charSequence.subSequence(i, min).toString() : sb.toString();
    }

    /* access modifiers changed from: private */
    public static String capitalize(CharSequence charSequence, int i) {
        int min = Math.min(charSequence.length(), i + 32);
        StringBuilder sb = null;
        int i2 = i;
        boolean z = true;
        while (i2 < min) {
            char charAt = charSequence.charAt(i2);
            char upperCase = z ? Character.toUpperCase(charAt) : Character.toLowerCase(charAt);
            boolean z2 = charAt == ' ';
            if (sb != null || upperCase != charAt) {
                if (sb == null) {
                    sb = new StringBuilder(32);
                    sb.append(charSequence.subSequence(i, i2));
                }
                sb.append(upperCase);
            }
            i2++;
            z = z2;
        }
        return sb == null ? charSequence.subSequence(i, min).toString() : sb.toString();
    }

    private static int getUpperBound(Selector selector) {
        switch (selector) {
            case NORTHERN_COURT:
                return NORTHERN_NENGOS.length - 1;
            case SOUTHERN_COURT:
                return NENGO_KENMU.index + 8;
            case EDO_PERIOD:
                return MEIJI.index - 1;
            case AZUCHI_MOMOYAMA_PERIOD:
                return 187;
            case MUROMACHI_PERIOD:
                return 184;
            case KAMAKURA_PERIOD:
                return NENGO_KENMU.index - 1;
            case HEIAN_PERIOD:
                return 102;
            case NARA_PERIOD:
                return 14;
            case ASUKA_PERIOD:
                return 2;
            default:
                return OFFICIAL_NENGOS.length - 1;
        }
    }

    private static int getLowerBound(Selector selector) {
        switch (selector) {
            case MODERN:
                return MEIJI.index;
            case SOUTHERN_COURT:
                return NENGO_KENMU.index;
            case EDO_PERIOD:
                return 188;
            case AZUCHI_MOMOYAMA_PERIOD:
                return 185;
            case MUROMACHI_PERIOD:
                return NENGO_KENMU.index + 1;
            case KAMAKURA_PERIOD:
                return 103;
            case HEIAN_PERIOD:
                return 15;
            case NARA_PERIOD:
                return 3;
            default:
                return 0;
        }
    }

    private static Nengo of(int i, boolean z) {
        return z ? NORTHERN_NENGOS[i] : OFFICIAL_NENGOS[i];
    }

    private Object readResolve() throws ObjectStreamException {
        try {
            int i = this.index;
            boolean z = true;
            if (this.court != 1) {
                z = false;
            }
            return of(i, z);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new StreamCorruptedException();
        }
    }

    static class Element implements TextElement<Nengo>, Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Element SINGLETON = new Element();
        private static final long serialVersionUID = -1099321098836107792L;

        public char getSymbol() {
            return 'G';
        }

        public boolean isDateElement() {
            return true;
        }

        public boolean isLenient() {
            return false;
        }

        public boolean isTimeElement() {
            return false;
        }

        public String name() {
            return "ERA";
        }

        static {
            Class<Nengo> cls = Nengo.class;
        }

        private Element() {
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            appendable.append(((Nengo) chronoDisplay.get(this)).getDisplayName((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE)));
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: net.time4j.calendar.Nengo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: net.time4j.calendar.Nengo} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0228 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x0229  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x018e A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.Nengo parse(java.lang.CharSequence r18, java.text.ParsePosition r19, net.time4j.engine.AttributeQuery r20) {
            /*
                r17 = this;
                r0 = r18
                r1 = r19
                r2 = r20
                net.time4j.engine.AttributeKey<java.util.Locale> r3 = net.time4j.format.Attributes.LANGUAGE
                java.util.Locale r4 = java.util.Locale.ROOT
                java.lang.Object r3 = r2.get(r3, r4)
                java.util.Locale r3 = (java.util.Locale) r3
                net.time4j.engine.AttributeKey<net.time4j.format.TextWidth> r4 = net.time4j.format.Attributes.TEXT_WIDTH
                net.time4j.format.TextWidth r5 = net.time4j.format.TextWidth.WIDE
                java.lang.Object r4 = r2.get(r4, r5)
                net.time4j.format.TextWidth r4 = (net.time4j.format.TextWidth) r4
                java.lang.String r5 = "japanese"
                net.time4j.format.CalendarText r5 = net.time4j.format.CalendarText.getInstance((java.lang.String) r5, (java.util.Locale) r3)
                java.util.Map r5 = r5.getTextForms()
                int r6 = r19.getIndex()
                int r7 = r18.length()
                r8 = 0
                if (r6 < r7) goto L_0x0033
                r1.setErrorIndex(r6)
                return r8
            L_0x0033:
                java.lang.String r7 = r3.getLanguage()
                java.lang.String r9 = "ru"
                boolean r7 = r7.equals(r9)
                if (r7 == 0) goto L_0x0044
                java.lang.String r0 = net.time4j.calendar.Nengo.capitalize(r0, r6)
                goto L_0x0048
            L_0x0044:
                java.lang.String r0 = net.time4j.calendar.Nengo.hepburn(r0, r6)
            L_0x0048:
                r7 = 0
                r10 = 0
            L_0x004a:
                java.lang.String[] r11 = net.time4j.calendar.Nengo.MODERN_KEYS
                int r11 = r11.length
                if (r10 >= r11) goto L_0x0092
                java.lang.String[] r11 = net.time4j.calendar.Nengo.MODERN_KEYS
                r11 = r11[r10]
                net.time4j.format.TextWidth r12 = net.time4j.format.TextWidth.NARROW
                if (r4 != r12) goto L_0x006c
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                r12.append(r11)
                java.lang.String r11 = "_n"
                r12.append(r11)
                java.lang.String r11 = r12.toString()
            L_0x006c:
                java.lang.Object r11 = r5.get(r11)
                java.lang.String r11 = (java.lang.String) r11
                boolean r12 = r0.startsWith(r11)
                if (r12 == 0) goto L_0x008f
                net.time4j.calendar.Nengo[] r5 = net.time4j.calendar.Nengo.MODERN_NENGOS
                r5 = r5[r10]
                int r10 = r11.length()
                net.time4j.format.TextWidth r11 = net.time4j.format.TextWidth.NARROW
                if (r4 == r11) goto L_0x0094
                net.time4j.calendar.Nengo r4 = net.time4j.calendar.Nengo.SHOWA
                if (r5 == r4) goto L_0x0094
                int r6 = r6 + r10
                r1.setIndex(r6)
                return r5
            L_0x008f:
                int r10 = r10 + 1
                goto L_0x004a
            L_0x0092:
                r5 = r8
                r10 = 0
            L_0x0094:
                int r4 = r0.length()
                r11 = 1
                r12 = 2
                if (r4 >= r12) goto L_0x00a3
                if (r5 == 0) goto L_0x00a2
                int r6 = r6 + r11
                r1.setIndex(r6)
            L_0x00a2:
                return r5
            L_0x00a3:
                java.util.List r4 = java.util.Collections.emptyList()
                java.lang.String r13 = r3.getLanguage()
                java.lang.String r14 = "ja"
                boolean r13 = r13.equals(r14)
                r14 = 4
                if (r13 == 0) goto L_0x00ea
                int r3 = r0.length()
                if (r3 < r14) goto L_0x00bc
                r3 = 4
                goto L_0x00bd
            L_0x00bc:
                r3 = 2
            L_0x00bd:
                java.lang.String r9 = r0.substring(r7, r3)
                java.util.Map r13 = net.time4j.calendar.Nengo.KANJI_TO_NENGO
                java.lang.Object r13 = r13.get(r9)
                net.time4j.calendar.Nengo r13 = (net.time4j.calendar.Nengo) r13
                if (r13 != 0) goto L_0x00de
                if (r3 != r14) goto L_0x00de
                java.lang.String r9 = r0.substring(r7, r12)
                java.util.Map r0 = net.time4j.calendar.Nengo.KANJI_TO_NENGO
                java.lang.Object r0 = r0.get(r9)
                r13 = r0
                net.time4j.calendar.Nengo r13 = (net.time4j.calendar.Nengo) r13
            L_0x00de:
                if (r13 == 0) goto L_0x00e8
                if (r13 != r5) goto L_0x00e3
                r5 = r8
            L_0x00e3:
                java.util.List r4 = java.util.Collections.singletonList(r13)
                goto L_0x0146
            L_0x00e8:
                r9 = r8
                goto L_0x0146
            L_0x00ea:
                java.lang.String r13 = r3.getLanguage()
                java.lang.String r15 = "zh"
                boolean r13 = r13.equals(r15)
                if (r13 == 0) goto L_0x012a
                int r3 = r0.length()
                if (r3 < r14) goto L_0x00fe
                r3 = 4
                goto L_0x00ff
            L_0x00fe:
                r3 = 2
            L_0x00ff:
                java.lang.String r9 = r0.substring(r7, r3)
                java.util.Map r13 = net.time4j.calendar.Nengo.CHINESE_TO_NENGO
                java.lang.Object r13 = r13.get(r9)
                net.time4j.calendar.Nengo r13 = (net.time4j.calendar.Nengo) r13
                if (r13 != 0) goto L_0x0120
                if (r3 != r14) goto L_0x0120
                java.lang.String r9 = r0.substring(r7, r12)
                java.util.Map r0 = net.time4j.calendar.Nengo.CHINESE_TO_NENGO
                java.lang.Object r0 = r0.get(r9)
                r13 = r0
                net.time4j.calendar.Nengo r13 = (net.time4j.calendar.Nengo) r13
            L_0x0120:
                if (r13 == 0) goto L_0x00e8
                if (r13 != r5) goto L_0x0125
                r5 = r8
            L_0x0125:
                java.util.List r4 = java.util.Collections.singletonList(r13)
                goto L_0x0146
            L_0x012a:
                java.lang.String r4 = r3.getLanguage()
                java.lang.String r12 = "ko"
                boolean r4 = r4.equals(r12)
                if (r4 == 0) goto L_0x0148
                net.time4j.calendar.Nengo$TST r3 = net.time4j.calendar.Nengo.KOREAN_TO_NENGO
                java.lang.String r9 = r3.longestPrefixOf(r0, r6)
                net.time4j.calendar.Nengo$TST r0 = net.time4j.calendar.Nengo.KOREAN_TO_NENGO
                java.util.List r4 = r0.find(r9)
            L_0x0146:
                r0 = 0
                goto L_0x0188
            L_0x0148:
                java.lang.String r3 = r3.getLanguage()
                boolean r3 = r3.equals(r9)
                if (r3 == 0) goto L_0x0177
                java.lang.String r3 = "Период "
                boolean r3 = r0.startsWith(r3)
                r4 = 7
                if (r3 == 0) goto L_0x0160
                java.lang.String r0 = r0.substring(r4)
                goto L_0x0161
            L_0x0160:
                r4 = 0
            L_0x0161:
                net.time4j.calendar.Nengo$TST r3 = net.time4j.calendar.Nengo.RUSSIAN_TO_NENGO
                java.lang.String r9 = r3.longestPrefixOf(r0, r6)
                net.time4j.calendar.Nengo$TST r0 = net.time4j.calendar.Nengo.RUSSIAN_TO_NENGO
                java.util.List r0 = r0.find(r9)
                r16 = r4
                r4 = r0
                r0 = r16
                goto L_0x0188
            L_0x0177:
                net.time4j.calendar.Nengo$TST r3 = net.time4j.calendar.Nengo.ROMAJI_TO_NENGO
                java.lang.String r9 = r3.longestPrefixOf(r0, r6)
                net.time4j.calendar.Nengo$TST r0 = net.time4j.calendar.Nengo.ROMAJI_TO_NENGO
                java.util.List r4 = r0.find(r9)
                goto L_0x0146
            L_0x0188:
                int r3 = r4.size()
                if (r3 == 0) goto L_0x0224
                if (r9 != 0) goto L_0x0192
                goto L_0x0224
            L_0x0192:
                int r9 = r9.length()
                int r9 = r9 + r0
                if (r10 >= r9) goto L_0x019b
                r5 = r8
                goto L_0x01a2
            L_0x019b:
                if (r10 <= r9) goto L_0x01a2
                int r6 = r6 + r10
                r1.setIndex(r6)
                return r5
            L_0x01a2:
                if (r3 != r11) goto L_0x01b3
                java.lang.Object r0 = r4.get(r7)
                net.time4j.calendar.Nengo r0 = (net.time4j.calendar.Nengo) r0
                if (r5 == 0) goto L_0x01ae
                if (r0 != r5) goto L_0x01b3
            L_0x01ae:
                int r6 = r6 + r9
                r1.setIndex(r6)
                return r0
            L_0x01b3:
                net.time4j.engine.AttributeKey<net.time4j.calendar.Nengo$Selector> r0 = net.time4j.calendar.Nengo.SELECTOR
                net.time4j.calendar.Nengo$Selector r3 = net.time4j.calendar.Nengo.Selector.OFFICIAL
                java.lang.Object r0 = r2.get(r0, r3)
                net.time4j.calendar.Nengo$Selector r0 = (net.time4j.calendar.Nengo.Selector) r0
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>(r4)
                if (r5 == 0) goto L_0x01cd
                boolean r4 = r3.contains(r5)
                if (r4 != 0) goto L_0x01cd
                r3.add(r5)
            L_0x01cd:
                net.time4j.calendar.Nengo$Element$1 r4 = new net.time4j.calendar.Nengo$Element$1
                r12 = r17
                r4.<init>()
                java.util.Collections.sort(r3, r4)
                java.util.Iterator r4 = r3.iterator()
            L_0x01db:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto L_0x01f1
                java.lang.Object r5 = r4.next()
                net.time4j.calendar.Nengo r5 = (net.time4j.calendar.Nengo) r5
                boolean r5 = r5.matches(r0)
                if (r5 != 0) goto L_0x01db
                r4.remove()
                goto L_0x01db
            L_0x01f1:
                int r0 = r3.size()
                if (r0 != r11) goto L_0x0202
                int r6 = r6 + r9
                r1.setIndex(r6)
                java.lang.Object r0 = r3.get(r7)
                net.time4j.calendar.Nengo r0 = (net.time4j.calendar.Nengo) r0
                return r0
            L_0x0202:
                int r0 = r3.size()
                if (r0 <= r11) goto L_0x0223
                net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r0 = net.time4j.format.Attributes.LENIENCY
                net.time4j.format.Leniency r4 = net.time4j.format.Leniency.SMART
                java.lang.Object r0 = r2.get(r0, r4)
                net.time4j.format.Leniency r0 = (net.time4j.format.Leniency) r0
                boolean r0 = r0.isStrict()
                if (r0 != 0) goto L_0x0223
                int r6 = r6 + r9
                r1.setIndex(r6)
                java.lang.Object r0 = r3.get(r7)
                net.time4j.calendar.Nengo r0 = (net.time4j.calendar.Nengo) r0
                return r0
            L_0x0223:
                return r8
            L_0x0224:
                r12 = r17
                if (r5 != 0) goto L_0x0229
                return r8
            L_0x0229:
                int r6 = r6 + r10
                r1.setIndex(r6)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.Nengo.Element.parse(java.lang.CharSequence, java.text.ParsePosition, net.time4j.engine.AttributeQuery):net.time4j.calendar.Nengo");
        }

        public Class<Nengo> getType() {
            return Nengo.class;
        }

        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            Nengo nengo = (Nengo) chronoDisplay.get(this);
            Nengo nengo2 = (Nengo) chronoDisplay2.get(this);
            if (nengo.start < nengo2.start) {
                return -1;
            }
            if (nengo.start > nengo2.start) {
                return 1;
            }
            if (nengo.court == 1) {
                if (nengo2.court == 1) {
                    return 0;
                }
                return 1;
            } else if (nengo2.court == 1) {
                return -1;
            } else {
                return 0;
            }
        }

        public Nengo getDefaultMinimum() {
            return Nengo.OFFICIAL_NENGOS[0];
        }

        public Nengo getDefaultMaximum() {
            return Nengo.OFFICIAL_NENGOS[Nengo.OFFICIAL_NENGOS.length - 1];
        }

        public String getDisplayName(Locale locale) {
            String str = CalendarText.getIsoInstance(locale).getTextForms().get("L_era");
            return str == null ? name() : str;
        }

        private Object readResolve() throws ObjectStreamException {
            return SINGLETON;
        }
    }

    private static class TST {
        private Node root;

        private TST() {
            this.root = null;
        }

        /* access modifiers changed from: package-private */
        public List<Nengo> find(String str) {
            if (str == null || str.length() == 0) {
                return Collections.emptyList();
            }
            Node find = find(this.root, str, 0);
            if (find == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(find.nengos);
        }

        private static Node find(Node node, String str, int i) {
            if (node == null) {
                return null;
            }
            char charAt = str.charAt(i);
            if (charAt < node.c) {
                return find(node.left, str, i);
            }
            if (charAt > node.c) {
                return find(node.right, str, i);
            }
            return i < str.length() + -1 ? find(node.mid, str, i + 1) : node;
        }

        /* access modifiers changed from: package-private */
        public void insert(String str, Nengo nengo) {
            if (!str.isEmpty()) {
                this.root = insert(this.root, str, nengo, 0);
                return;
            }
            throw new IllegalArgumentException("Empty key cannot be inserted.");
        }

        private static Node insert(Node node, String str, Nengo nengo, int i) {
            char charAt = str.charAt(i);
            if (node == null) {
                node = new Node();
                char unused = node.c = charAt;
            }
            if (charAt < node.c) {
                Node unused2 = node.left = insert(node.left, str, nengo, i);
            } else if (charAt > node.c) {
                Node unused3 = node.right = insert(node.right, str, nengo, i);
            } else if (i < str.length() - 1) {
                Node unused4 = node.mid = insert(node.mid, str, nengo, i + 1);
            } else {
                if (node.nengos == null) {
                    List unused5 = node.nengos = new ArrayList();
                }
                node.nengos.add(nengo);
            }
            return node;
        }

        /* access modifiers changed from: package-private */
        public String longestPrefixOf(CharSequence charSequence, int i) {
            Node node = this.root;
            int length = charSequence.length();
            int i2 = i;
            int i3 = i2;
            while (node != null && i2 < length) {
                char charAt = charSequence.charAt(i2);
                if (charAt < node.c) {
                    node = node.left;
                } else if (charAt > node.c) {
                    node = node.right;
                } else {
                    i2++;
                    if (node.nengos != null) {
                        i3 = i2;
                    }
                    node = node.mid;
                }
            }
            if (i >= i3) {
                return null;
            }
            return charSequence.subSequence(i, i3).toString();
        }
    }

    private static class Node {
        /* access modifiers changed from: private */
        public char c;
        /* access modifiers changed from: private */
        public Node left;
        /* access modifiers changed from: private */
        public Node mid;
        /* access modifiers changed from: private */
        public List<Nengo> nengos;
        /* access modifiers changed from: private */
        public Node right;

        private Node() {
            this.c = 0;
            this.left = null;
            this.mid = null;
            this.right = null;
            this.nengos = null;
        }
    }
}
