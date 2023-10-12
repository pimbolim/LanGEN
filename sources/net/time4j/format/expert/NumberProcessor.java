package net.time4j.format.expert;

import java.io.IOException;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.NumberSystem;

class NumberProcessor<V> implements FormatProcessor<V> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int[] THRESHOLDS = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    private final ChronoElement<V> element;
    private final boolean fixedInt;
    private final boolean fixedWidth;
    private final Leniency lenientMode;
    private final int maxDigits;
    private final int minDigits;
    private final NumberSystem numberSystem;
    private final int protectedLength;
    private final boolean protectedMode;
    private final int reserved;
    private final int scaleOfNumsys;
    private final SignPolicy signPolicy;
    private final boolean yearOfEra;
    private final char zeroDigit;

    public boolean isNumerical() {
        return true;
    }

    NumberProcessor(ChronoElement<V> chronoElement, boolean z, int i, int i2, SignPolicy signPolicy2, boolean z2) {
        this(chronoElement, z, i, i2, signPolicy2, z2, 0, '0', NumberSystem.ARABIC, Leniency.SMART, 0, false);
    }

    private NumberProcessor(ChronoElement<V> chronoElement, boolean z, int i, int i2, SignPolicy signPolicy2, boolean z2, int i3, char c, NumberSystem numberSystem2, Leniency leniency, int i4, boolean z3) {
        this.element = chronoElement;
        this.fixedWidth = z;
        this.minDigits = i;
        this.maxDigits = i2;
        this.signPolicy = signPolicy2;
        this.protectedMode = z2;
        this.fixedInt = z3;
        Objects.requireNonNull(chronoElement, "Missing element.");
        Objects.requireNonNull(signPolicy2, "Missing sign policy.");
        if (i < 1) {
            throw new IllegalArgumentException("Not positive: " + i);
        } else if (i > i2) {
            throw new IllegalArgumentException("Max smaller than min: " + i2 + " < " + i);
        } else if (z && i != i2) {
            throw new IllegalArgumentException("Variable width in fixed-width-mode: " + i2 + " != " + i);
        } else if (!z || signPolicy2 == SignPolicy.SHOW_NEVER) {
            int scale = getScale(numberSystem2);
            if (numberSystem2.isDecimal()) {
                if (i > scale) {
                    throw new IllegalArgumentException("Min digits out of range: " + i);
                } else if (i2 > scale) {
                    throw new IllegalArgumentException("Max digits out of range: " + i2);
                }
            }
            this.yearOfEra = chronoElement.name().equals("YEAR_OF_ERA");
            this.reserved = i3;
            this.zeroDigit = c;
            this.numberSystem = numberSystem2;
            this.lenientMode = leniency;
            this.protectedLength = i4;
            this.scaleOfNumsys = scale;
        } else {
            throw new IllegalArgumentException("Sign policy must be SHOW_NEVER in fixed-width-mode.");
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x02e2: MOVE  (r1v2 java.util.Set<net.time4j.format.expert.ElementPosition>) = 
          (r27v0 java.util.Set<net.time4j.format.expert.ElementPosition>)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02d1  */
    public int print(net.time4j.engine.ChronoDisplay r24, java.lang.Appendable r25, net.time4j.engine.AttributeQuery r26, java.util.Set<net.time4j.format.expert.ElementPosition> r27, boolean r28) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r2 = r24
            r9 = r25
            r4 = r26
            r10 = r27
            boolean r1 = r9 instanceof java.lang.CharSequence
            r11 = -1
            if (r1 == 0) goto L_0x0018
            r1 = r9
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r12 = r1
            goto L_0x0019
        L_0x0018:
            r12 = -1
        L_0x0019:
            r3 = 0
            if (r28 == 0) goto L_0x0021
            net.time4j.format.NumberSystem r5 = r0.numberSystem
            char r6 = r0.zeroDigit
            goto L_0x0051
        L_0x0021:
            net.time4j.engine.AttributeKey<net.time4j.format.NumberSystem> r5 = net.time4j.format.Attributes.NUMBER_SYSTEM
            net.time4j.format.NumberSystem r6 = net.time4j.format.NumberSystem.ARABIC
            java.lang.Object r5 = r4.get(r5, r6)
            net.time4j.format.NumberSystem r5 = (net.time4j.format.NumberSystem) r5
            net.time4j.engine.AttributeKey<java.lang.Character> r6 = net.time4j.format.Attributes.ZERO_DIGIT
            boolean r6 = r4.contains(r6)
            if (r6 == 0) goto L_0x0040
            net.time4j.engine.AttributeKey<java.lang.Character> r6 = net.time4j.format.Attributes.ZERO_DIGIT
            java.lang.Object r6 = r4.get(r6)
            java.lang.Character r6 = (java.lang.Character) r6
            char r6 = r6.charValue()
            goto L_0x0051
        L_0x0040:
            boolean r6 = r5.isDecimal()
            if (r6 == 0) goto L_0x004f
            java.lang.String r6 = r5.getDigits()
            char r6 = r6.charAt(r3)
            goto L_0x0051
        L_0x004f:
            r6 = 48
        L_0x0051:
            java.lang.String r8 = "Negative value not allowed according to sign policy."
            java.lang.String r13 = "."
            java.lang.String r14 = " exceeds the maximum width of "
            java.lang.String r15 = " cannot be printed as the formatted value "
            java.lang.String r3 = "Element "
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r28 == 0) goto L_0x0100
            boolean r1 = r0.fixedInt
            if (r1 == 0) goto L_0x0100
            net.time4j.engine.ChronoElement<V> r1 = r0.element
            int r1 = r2.getInt(r1)
            if (r1 >= 0) goto L_0x0074
            if (r1 != r7) goto L_0x006e
            return r11
        L_0x006e:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r8)
            throw r1
        L_0x0074:
            int r2 = length(r1)
            int r4 = r0.maxDigits
            if (r2 > r4) goto L_0x00d4
            int r3 = r0.minDigits
            int r3 = r3 - r2
            r4 = 0
            r16 = 0
        L_0x0082:
            if (r4 >= r3) goto L_0x008e
            r5 = 48
            r9.append(r5)
            int r16 = r16 + 1
            int r4 = r4 + 1
            goto L_0x0082
        L_0x008e:
            r4 = 2
            r5 = 48
            if (r2 != r4) goto L_0x0097
            appendTwoDigits(r1, r9, r5)
            goto L_0x00d1
        L_0x0097:
            r3 = 1
            if (r2 != r3) goto L_0x00a0
            int r1 = r1 + r5
            char r1 = (char) r1
            r9.append(r1)
            goto L_0x00d1
        L_0x00a0:
            r3 = 2000(0x7d0, float:2.803E-42)
            if (r1 < r3) goto L_0x00b5
            r4 = 2100(0x834, float:2.943E-42)
            if (r1 >= r4) goto L_0x00b5
            r4 = 50
            r9.append(r4)
            r9.append(r5)
            int r1 = r1 - r3
            appendTwoDigits(r1, r9, r5)
            goto L_0x00d1
        L_0x00b5:
            r4 = 1900(0x76c, float:2.662E-42)
            if (r1 < r4) goto L_0x00ca
            if (r1 >= r3) goto L_0x00ca
            r3 = 49
            r9.append(r3)
            r3 = 57
            r9.append(r3)
            int r1 = r1 - r4
            appendTwoDigits(r1, r9, r5)
            goto L_0x00d1
        L_0x00ca:
            java.lang.String r1 = java.lang.Integer.toString(r1)
            r9.append(r1)
        L_0x00d1:
            int r16 = r16 + r2
            goto L_0x012e
        L_0x00d4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            net.time4j.engine.ChronoElement<V> r3 = r0.element
            java.lang.String r3 = r3.name()
            r4.append(r3)
            r4.append(r15)
            r4.append(r1)
            r4.append(r14)
            int r1 = r0.maxDigits
            r4.append(r1)
            r4.append(r13)
            java.lang.String r1 = r4.toString()
            r2.<init>(r1)
            throw r2
        L_0x0100:
            boolean r1 = r0.yearOfEra
            if (r1 == 0) goto L_0x0132
            net.time4j.engine.ChronoElement<V> r1 = r0.element
            boolean r11 = r1 instanceof net.time4j.format.internal.DualFormatElement
            if (r11 == 0) goto L_0x0132
            java.lang.Class<net.time4j.format.internal.DualFormatElement> r3 = net.time4j.format.internal.DualFormatElement.class
            java.lang.Object r1 = r3.cast(r1)
            net.time4j.format.internal.DualFormatElement r1 = (net.time4j.format.internal.DualFormatElement) r1
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            int r7 = r0.minDigits
            int r8 = r0.maxDigits
            r2 = r24
            r3 = r11
            r4 = r26
            r1.print(r2, r3, r4, r5, r6, r7, r8)
            java.lang.String r1 = r11.toString()
            r9.append(r1)
            int r16 = r11.length()
        L_0x012e:
            r11 = r12
        L_0x012f:
            r1 = -1
            goto L_0x02de
        L_0x0132:
            java.lang.String r1 = r5.getDigits()
            r11 = 0
            char r1 = r1.charAt(r11)
            net.time4j.engine.ChronoElement<V> r11 = r0.element
            java.lang.Class r11 = r11.getType()
            boolean r18 = r5.isDecimal()
            r19 = 0
            java.lang.Class<java.lang.Integer> r7 = java.lang.Integer.class
            if (r11 != r7) goto L_0x0166
            net.time4j.engine.ChronoElement<V> r4 = r0.element
            int r2 = r2.getInt(r4)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 != r4) goto L_0x0157
            r4 = -1
            return r4
        L_0x0157:
            if (r2 >= 0) goto L_0x015b
            r4 = 1
            goto L_0x015c
        L_0x015b:
            r4 = 0
        L_0x015c:
            int r7 = java.lang.Math.abs(r2)
            int r2 = length(r7)
            goto L_0x01d5
        L_0x0166:
            java.lang.Class<java.lang.Long> r7 = java.lang.Long.class
            if (r11 != r7) goto L_0x01a1
            net.time4j.engine.ChronoElement<V> r1 = r0.element
            java.lang.Object r1 = r2.get(r1)
            java.lang.Class<java.lang.Long> r2 = java.lang.Long.class
            java.lang.Object r1 = r2.cast(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r20 = 0
            int r4 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r4 >= 0) goto L_0x0184
            r4 = 1
            goto L_0x0185
        L_0x0184:
            r4 = 0
        L_0x0185:
            r20 = -9223372036854775808
            int r7 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r7 != 0) goto L_0x018e
            java.lang.String r1 = "9223372036854775808"
            goto L_0x0196
        L_0x018e:
            long r1 = java.lang.Math.abs(r1)
            java.lang.String r1 = java.lang.Long.toString(r1)
        L_0x0196:
            r19 = r1
            int r2 = r19.length()
            r1 = 48
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x01d5
        L_0x01a1:
            java.lang.Class<java.lang.Enum> r7 = java.lang.Enum.class
            boolean r7 = r7.isAssignableFrom(r11)
            if (r7 == 0) goto L_0x030c
            net.time4j.engine.ChronoElement<V> r7 = r0.element
            boolean r11 = r7 instanceof net.time4j.format.NumericalElement
            if (r11 == 0) goto L_0x01c1
            java.lang.Object r7 = r2.get(r7)
            net.time4j.engine.ChronoElement<V> r11 = r0.element
            net.time4j.format.NumericalElement r11 = (net.time4j.format.NumericalElement) r11
            int r4 = r11.printToInt(r7, r2, r4)
            if (r4 >= 0) goto L_0x01bf
            r2 = 1
            goto L_0x01c4
        L_0x01bf:
            r2 = 0
            goto L_0x01c4
        L_0x01c1:
            r2 = 0
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x01c4:
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 == r7) goto L_0x02f3
            int r7 = java.lang.Math.abs(r4)
            int r4 = length(r7)
            r22 = r4
            r4 = r2
            r2 = r22
        L_0x01d5:
            if (r18 == 0) goto L_0x0236
            if (r6 == r1) goto L_0x01fc
            int r1 = r6 - r1
            if (r19 != 0) goto L_0x01e1
            java.lang.String r19 = r5.toNumeral(r7)
        L_0x01e1:
            char[] r11 = r19.toCharArray()
            r17 = r12
            r10 = 0
        L_0x01e8:
            int r12 = r11.length
            if (r10 >= r12) goto L_0x01f4
            char r12 = r11[r10]
            int r12 = r12 + r1
            char r12 = (char) r12
            r11[r10] = r12
            int r10 = r10 + 1
            goto L_0x01e8
        L_0x01f4:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r11)
            r19 = r1
            goto L_0x01fe
        L_0x01fc:
            r17 = r12
        L_0x01fe:
            int r1 = r0.maxDigits
            if (r2 <= r1) goto L_0x0238
            if (r19 != 0) goto L_0x0208
            java.lang.String r19 = r5.toNumeral(r7)
        L_0x0208:
            r1 = r19
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            net.time4j.engine.ChronoElement<V> r3 = r0.element
            java.lang.String r3 = r3.name()
            r4.append(r3)
            r4.append(r15)
            r4.append(r1)
            r4.append(r14)
            int r1 = r0.maxDigits
            r4.append(r1)
            r4.append(r13)
            java.lang.String r1 = r4.toString()
            r2.<init>(r1)
            throw r2
        L_0x0236:
            r17 = r12
        L_0x0238:
            r1 = r19
            if (r4 == 0) goto L_0x024e
            net.time4j.format.expert.SignPolicy r3 = r0.signPolicy
            net.time4j.format.expert.SignPolicy r4 = net.time4j.format.expert.SignPolicy.SHOW_NEVER
            if (r3 == r4) goto L_0x0248
            r3 = 45
            r9.append(r3)
            goto L_0x0270
        L_0x0248:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r8)
            throw r1
        L_0x024e:
            int[] r3 = net.time4j.format.expert.NumberProcessor.AnonymousClass1.$SwitchMap$net$time4j$format$expert$SignPolicy
            net.time4j.format.expert.SignPolicy r4 = r0.signPolicy
            int r4 = r4.ordinal()
            r3 = r3[r4]
            r4 = 43
            r8 = 1
            if (r3 == r8) goto L_0x026d
            r8 = 2
            if (r3 == r8) goto L_0x0261
            goto L_0x026b
        L_0x0261:
            if (r18 == 0) goto L_0x026b
            int r3 = r0.minDigits
            if (r2 <= r3) goto L_0x026b
            r9.append(r4)
            goto L_0x0270
        L_0x026b:
            r3 = 0
            goto L_0x0271
        L_0x026d:
            r9.append(r4)
        L_0x0270:
            r3 = 1
        L_0x0271:
            if (r18 == 0) goto L_0x0283
            int r4 = r0.minDigits
            int r4 = r4 - r2
            r8 = r3
            r3 = 0
        L_0x0278:
            if (r3 >= r4) goto L_0x0282
            r9.append(r6)
            int r8 = r8 + 1
            int r3 = r3 + 1
            goto L_0x0278
        L_0x0282:
            r3 = r8
        L_0x0283:
            if (r1 != 0) goto L_0x02d1
            if (r18 == 0) goto L_0x02cc
            r1 = 2
            if (r2 != r1) goto L_0x028e
            appendTwoDigits(r7, r9, r6)
            goto L_0x02d8
        L_0x028e:
            r1 = 1
            if (r2 != r1) goto L_0x0297
            int r7 = r7 + r6
            char r1 = (char) r7
            r9.append(r1)
            goto L_0x02d8
        L_0x0297:
            r1 = 2000(0x7d0, float:2.803E-42)
            if (r7 < r1) goto L_0x02ad
            r4 = 2100(0x834, float:2.943E-42)
            if (r7 >= r4) goto L_0x02ad
            int r4 = r6 + 2
            char r4 = (char) r4
            r9.append(r4)
            r9.append(r6)
            int r7 = r7 - r1
            appendTwoDigits(r7, r9, r6)
            goto L_0x02d8
        L_0x02ad:
            r4 = 1900(0x76c, float:2.662E-42)
            if (r7 < r4) goto L_0x02c4
            if (r7 >= r1) goto L_0x02c4
            int r1 = r6 + 1
            char r1 = (char) r1
            r9.append(r1)
            int r1 = r6 + 9
            char r1 = (char) r1
            r9.append(r1)
            int r7 = r7 - r4
            appendTwoDigits(r7, r9, r6)
            goto L_0x02d8
        L_0x02c4:
            java.lang.String r1 = r5.toNumeral(r7)
            r9.append(r1)
            goto L_0x02d8
        L_0x02cc:
            int r2 = r5.toNumeral(r7, r9)
            goto L_0x02d8
        L_0x02d1:
            r9.append(r1)
            int r2 = r1.length()
        L_0x02d8:
            int r16 = r3 + r2
            r11 = r17
            goto L_0x012f
        L_0x02de:
            if (r11 == r1) goto L_0x02f2
            if (r16 <= 0) goto L_0x02f2
            r1 = r27
            if (r1 == 0) goto L_0x02f2
            net.time4j.format.expert.ElementPosition r2 = new net.time4j.format.expert.ElementPosition
            net.time4j.engine.ChronoElement<V> r3 = r0.element
            int r12 = r11 + r16
            r2.<init>(r3, r11, r12)
            r1.add(r2)
        L_0x02f2:
            return r16
        L_0x02f3:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot print: "
            r2.append(r3)
            net.time4j.engine.ChronoElement<V> r3 = r0.element
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x030c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Not formattable: "
            r2.append(r3)
            net.time4j.engine.ChronoElement<V> r3 = r0.element
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.NumberProcessor.print(net.time4j.engine.ChronoDisplay, java.lang.Appendable, net.time4j.engine.AttributeQuery, java.util.Set, boolean):int");
    }

    /* renamed from: net.time4j.format.expert.NumberProcessor$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$expert$SignPolicy;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                net.time4j.format.expert.SignPolicy[] r0 = net.time4j.format.expert.SignPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$expert$SignPolicy = r0
                net.time4j.format.expert.SignPolicy r1 = net.time4j.format.expert.SignPolicy.SHOW_ALWAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$format$expert$SignPolicy     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.expert.SignPolicy r1 = net.time4j.format.expert.SignPolicy.SHOW_WHEN_BIG_NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.NumberProcessor.AnonymousClass1.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:187:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0374  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.CharSequence r26, net.time4j.format.expert.ParseLog r27, net.time4j.engine.AttributeQuery r28, net.time4j.format.expert.ParsedEntity<?> r29, boolean r30) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            r2 = r27
            r3 = r28
            r4 = r29
            int r5 = r26.length()
            int r6 = r27.getPosition()
            java.lang.String r7 = "Digit expected."
            java.lang.String r8 = "Not enough digits found for: "
            java.lang.String r11 = "Parsed number does not fit into an integer: "
            r12 = 48
            java.lang.String r15 = "Sign not allowed due to sign policy."
            r16 = 0
            java.lang.String r14 = "Missing digits for: "
            r9 = 45
            r10 = 43
            if (r30 == 0) goto L_0x00ba
            boolean r13 = r1.fixedInt
            if (r13 == 0) goto L_0x00ba
            if (r6 < r5) goto L_0x0048
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r14)
            net.time4j.engine.ChronoElement<V> r3 = r1.element
            java.lang.String r3 = r3.name()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.setError(r6, r0)
            r27.setWarning()
            return
        L_0x0048:
            char r3 = r0.charAt(r6)
            if (r3 == r9) goto L_0x00b6
            if (r3 != r10) goto L_0x0051
            goto L_0x00b6
        L_0x0051:
            int r3 = r1.minDigits
            int r3 = r3 + r6
            int r5 = java.lang.Math.min(r5, r3)
            r13 = r6
            r9 = r16
        L_0x005b:
            if (r13 >= r5) goto L_0x0071
            char r14 = r0.charAt(r13)
            int r14 = r14 - r12
            if (r14 < 0) goto L_0x0071
            r15 = 9
            if (r14 > r15) goto L_0x0071
            r16 = 10
            long r9 = r9 * r16
            long r14 = (long) r14
            long r9 = r9 + r14
            int r13 = r13 + 1
            goto L_0x005b
        L_0x0071:
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r0 <= 0) goto L_0x008b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r2.setError(r6, r0)
            return
        L_0x008b:
            if (r13 >= r3) goto L_0x00ac
            if (r13 != r6) goto L_0x0093
            r2.setError(r6, r7)
            goto L_0x00ab
        L_0x0093:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            net.time4j.engine.ChronoElement<V> r3 = r1.element
            java.lang.String r3 = r3.name()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.setError(r6, r0)
        L_0x00ab:
            return
        L_0x00ac:
            net.time4j.engine.ChronoElement<V> r0 = r1.element
            int r3 = (int) r9
            r4.put((net.time4j.engine.ChronoElement<?>) r0, (int) r3)
            r2.setPosition(r13)
            return
        L_0x00b6:
            r2.setError(r6, r15)
            return
        L_0x00ba:
            r13 = 0
            if (r30 == 0) goto L_0x00c0
            int r12 = r1.protectedLength
            goto L_0x00d0
        L_0x00c0:
            net.time4j.engine.AttributeKey<java.lang.Integer> r12 = net.time4j.format.Attributes.PROTECTED_CHARACTERS
            java.lang.Integer r10 = java.lang.Integer.valueOf(r13)
            java.lang.Object r10 = r3.get(r12, r10)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r12 = r10.intValue()
        L_0x00d0:
            if (r12 <= 0) goto L_0x00d3
            int r5 = r5 - r12
        L_0x00d3:
            if (r6 < r5) goto L_0x00f1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r14)
            net.time4j.engine.ChronoElement<V> r3 = r1.element
            java.lang.String r3 = r3.name()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.setError(r6, r0)
            r27.setWarning()
            return
        L_0x00f1:
            boolean r10 = r1.yearOfEra
            if (r10 == 0) goto L_0x013e
            net.time4j.engine.ChronoElement<V> r10 = r1.element
            boolean r9 = r10 instanceof net.time4j.format.internal.DualFormatElement
            if (r9 == 0) goto L_0x013e
            java.lang.Class<net.time4j.format.internal.DualFormatElement> r5 = net.time4j.format.internal.DualFormatElement.class
            java.lang.Object r5 = r5.cast(r10)
            net.time4j.format.internal.DualFormatElement r5 = (net.time4j.format.internal.DualFormatElement) r5
            java.text.ParsePosition r7 = r27.getPP()
            java.lang.Integer r0 = r5.parse(r0, r7, r3, r4)
            boolean r3 = r27.isError()
            if (r3 == 0) goto L_0x0130
            int r0 = r27.getErrorIndex()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unparseable element: "
            r3.append(r4)
            net.time4j.engine.ChronoElement<V> r4 = r1.element
            java.lang.String r4 = r4.name()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.setError(r0, r3)
            goto L_0x013d
        L_0x0130:
            if (r0 != 0) goto L_0x0138
            java.lang.String r0 = "No interpretable value."
            r2.setError(r6, r0)
            goto L_0x013d
        L_0x0138:
            net.time4j.engine.ChronoElement<V> r2 = r1.element
            r4.put((net.time4j.engine.ChronoElement<?>) r2, (java.lang.Object) r0)
        L_0x013d:
            return
        L_0x013e:
            if (r30 == 0) goto L_0x0157
            net.time4j.format.NumberSystem r9 = r1.numberSystem
            boolean r10 = r9.isDecimal()
            int r13 = r1.scaleOfNumsys
            r20 = r9
            char r9 = r1.zeroDigit
            r21 = r13
            r13 = r9
            r9 = 0
            r24 = r20
            r20 = r10
            r10 = r24
            goto L_0x019a
        L_0x0157:
            net.time4j.engine.AttributeKey<net.time4j.format.NumberSystem> r9 = net.time4j.format.Attributes.NUMBER_SYSTEM
            net.time4j.format.NumberSystem r10 = net.time4j.format.NumberSystem.ARABIC
            java.lang.Object r9 = r3.get(r9, r10)
            net.time4j.format.NumberSystem r9 = (net.time4j.format.NumberSystem) r9
            boolean r10 = r9.isDecimal()
            int r13 = r1.getScale(r9)
            r21 = r13
            net.time4j.engine.AttributeKey<java.lang.Character> r13 = net.time4j.format.Attributes.ZERO_DIGIT
            boolean r13 = r3.contains(r13)
            if (r13 == 0) goto L_0x0183
            net.time4j.engine.AttributeKey<java.lang.Character> r13 = net.time4j.format.Attributes.ZERO_DIGIT
            java.lang.Object r13 = r3.get(r13)
            java.lang.Character r13 = (java.lang.Character) r13
            char r13 = r13.charValue()
            r22 = r9
            r9 = 0
            goto L_0x0196
        L_0x0183:
            if (r10 == 0) goto L_0x0191
            java.lang.String r13 = r9.getDigits()
            r22 = r9
            r9 = 0
            char r13 = r13.charAt(r9)
            goto L_0x0196
        L_0x0191:
            r22 = r9
            r9 = 0
            r13 = 48
        L_0x0196:
            r20 = r10
            r10 = r22
        L_0x019a:
            if (r30 == 0) goto L_0x019f
            net.time4j.format.Leniency r3 = r1.lenientMode
            goto L_0x01a9
        L_0x019f:
            net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r9 = net.time4j.format.Attributes.LENIENCY
            net.time4j.format.Leniency r4 = net.time4j.format.Leniency.SMART
            java.lang.Object r3 = r3.get(r9, r4)
            net.time4j.format.Leniency r3 = (net.time4j.format.Leniency) r3
        L_0x01a9:
            if (r20 == 0) goto L_0x01ba
            boolean r9 = r1.fixedWidth
            if (r9 != 0) goto L_0x01b5
            boolean r9 = r3.isLax()
            if (r9 != 0) goto L_0x01ba
        L_0x01b5:
            int r9 = r1.minDigits
            int r4 = r1.maxDigits
            goto L_0x01bd
        L_0x01ba:
            r4 = r21
            r9 = 1
        L_0x01bd:
            r21 = r8
            char r8 = r0.charAt(r6)
            r22 = r7
            r7 = 45
            if (r8 == r7) goto L_0x01e5
            r7 = 43
            if (r8 != r7) goto L_0x01ce
            goto L_0x01e5
        L_0x01ce:
            net.time4j.format.expert.SignPolicy r7 = r1.signPolicy
            net.time4j.format.expert.SignPolicy r15 = net.time4j.format.expert.SignPolicy.SHOW_ALWAYS
            if (r7 != r15) goto L_0x01e0
            boolean r7 = r3.isStrict()
            if (r7 == 0) goto L_0x01e0
            java.lang.String r0 = "Missing sign of number."
            r2.setError(r6, r0)
            return
        L_0x01e0:
            r7 = r6
            r23 = r11
            r11 = 0
            goto L_0x021c
        L_0x01e5:
            net.time4j.format.expert.SignPolicy r7 = r1.signPolicy
            r23 = r11
            net.time4j.format.expert.SignPolicy r11 = net.time4j.format.expert.SignPolicy.SHOW_NEVER
            if (r7 != r11) goto L_0x01fb
            boolean r7 = r1.fixedWidth
            if (r7 != 0) goto L_0x01f7
            boolean r7 = r3.isStrict()
            if (r7 == 0) goto L_0x01fb
        L_0x01f7:
            r2.setError(r6, r15)
            return
        L_0x01fb:
            net.time4j.format.expert.SignPolicy r7 = r1.signPolicy
            net.time4j.format.expert.SignPolicy r11 = net.time4j.format.expert.SignPolicy.SHOW_WHEN_NEGATIVE
            if (r7 != r11) goto L_0x0211
            r7 = 43
            if (r8 != r7) goto L_0x0211
            boolean r7 = r3.isStrict()
            if (r7 == 0) goto L_0x0211
            java.lang.String r0 = "Positive sign not allowed due to sign policy."
            r2.setError(r6, r0)
            return
        L_0x0211:
            r7 = 45
            if (r8 != r7) goto L_0x0217
            r7 = 1
            goto L_0x0218
        L_0x0217:
            r7 = 0
        L_0x0218:
            int r6 = r6 + 1
            r11 = r7
            r7 = r6
        L_0x021c:
            if (r6 < r5) goto L_0x0237
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r14)
            net.time4j.engine.ChronoElement<V> r3 = r1.element
            java.lang.String r3 = r3.name()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.setError(r7, r0)
            return
        L_0x0237:
            boolean r14 = r1.fixedWidth
            if (r14 != 0) goto L_0x027b
            int r14 = r1.reserved
            if (r14 <= 0) goto L_0x027b
            if (r12 > 0) goto L_0x027b
            if (r20 == 0) goto L_0x025e
            r12 = r6
            r14 = 0
        L_0x0245:
            if (r12 >= r5) goto L_0x025b
            char r15 = r0.charAt(r12)
            int r15 = r15 - r13
            if (r15 < 0) goto L_0x025b
            r30 = r8
            r8 = 9
            if (r15 > r8) goto L_0x0273
            int r14 = r14 + 1
            int r12 = r12 + 1
            r8 = r30
            goto L_0x0245
        L_0x025b:
            r30 = r8
            goto L_0x0273
        L_0x025e:
            r30 = r8
            r8 = r6
            r14 = 0
        L_0x0262:
            if (r8 >= r5) goto L_0x0273
            char r12 = r0.charAt(r8)
            boolean r12 = r10.contains(r12)
            if (r12 == 0) goto L_0x0273
            int r14 = r14 + 1
            int r8 = r8 + 1
            goto L_0x0262
        L_0x0273:
            int r8 = r1.reserved
            int r14 = r14 - r8
            int r4 = java.lang.Math.min(r4, r14)
            goto L_0x027d
        L_0x027b:
            r30 = r8
        L_0x027d:
            int r9 = r9 + r6
            int r4 = r4 + r6
            int r4 = java.lang.Math.min(r5, r4)
            if (r20 == 0) goto L_0x02a1
            r14 = r16
        L_0x0287:
            if (r6 >= r4) goto L_0x029f
            char r5 = r0.charAt(r6)
            int r5 = r5 - r13
            if (r5 < 0) goto L_0x029f
            r8 = 9
            if (r5 > r8) goto L_0x029f
            r18 = 10
            long r14 = r14 * r18
            r12 = r9
            long r8 = (long) r5
            long r14 = r14 + r8
            int r6 = r6 + 1
            r9 = r12
            goto L_0x0287
        L_0x029f:
            r12 = r9
            goto L_0x02d2
        L_0x02a1:
            r12 = r9
            r5 = 0
        L_0x02a3:
            if (r6 >= r4) goto L_0x02b4
            char r8 = r0.charAt(r6)
            boolean r8 = r10.contains(r8)
            if (r8 == 0) goto L_0x02b4
            int r5 = r5 + 1
            int r6 = r6 + 1
            goto L_0x02a3
        L_0x02b4:
            if (r5 <= 0) goto L_0x02d0
            int r4 = r6 - r5
            java.lang.CharSequence r0 = r0.subSequence(r4, r6)     // Catch:{ NumberFormatException -> 0x02c7 }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x02c7 }
            int r0 = r10.toInteger(r0, r3)     // Catch:{ NumberFormatException -> 0x02c7 }
            long r4 = (long) r0
            r14 = r4
            goto L_0x02d2
        L_0x02c7:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            r2.setError(r7, r0)
            return
        L_0x02d0:
            r14 = r16
        L_0x02d2:
            net.time4j.engine.ChronoElement<V> r0 = r1.element
            java.lang.Class r0 = r0.getType()
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x02f8
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            if (r0 != r4) goto L_0x02f8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r3 = r23
            r0.append(r3)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            r2.setError(r7, r0)
            return
        L_0x02f8:
            r4 = r12
            if (r6 >= r4) goto L_0x0328
            if (r6 != r7) goto L_0x0303
            r5 = r22
            r2.setError(r7, r5)
            return
        L_0x0303:
            boolean r5 = r1.fixedWidth
            if (r5 != 0) goto L_0x030d
            boolean r5 = r3.isLax()
            if (r5 != 0) goto L_0x0328
        L_0x030d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r3 = r21
            r0.append(r3)
            net.time4j.engine.ChronoElement<V> r3 = r1.element
            java.lang.String r3 = r3.name()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.setError(r7, r0)
            return
        L_0x0328:
            if (r11 == 0) goto L_0x0340
            int r4 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r4 != 0) goto L_0x033c
            boolean r3 = r3.isStrict()
            if (r3 == 0) goto L_0x033c
            r3 = 1
            int r7 = r7 - r3
            java.lang.String r0 = "Negative zero is not allowed."
            r2.setError(r7, r0)
            return
        L_0x033c:
            long r14 = -r14
        L_0x033d:
            r3 = r30
            goto L_0x0367
        L_0x0340:
            net.time4j.format.expert.SignPolicy r5 = r1.signPolicy
            net.time4j.format.expert.SignPolicy r8 = net.time4j.format.expert.SignPolicy.SHOW_WHEN_BIG_NUMBER
            if (r5 != r8) goto L_0x033d
            boolean r3 = r3.isStrict()
            if (r3 == 0) goto L_0x033d
            if (r20 == 0) goto L_0x033d
            r3 = r30
            r5 = 43
            if (r3 != r5) goto L_0x035e
            if (r6 > r4) goto L_0x035e
            int r4 = r7 + -1
            java.lang.String r8 = "Positive sign only allowed for big number."
            r2.setError(r4, r8)
            goto L_0x0367
        L_0x035e:
            if (r3 == r5) goto L_0x0367
            if (r6 <= r4) goto L_0x0367
            java.lang.String r4 = "Positive sign must be present for big number."
            r2.setError(r7, r4)
        L_0x0367:
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            if (r0 != r4) goto L_0x0374
            net.time4j.engine.ChronoElement<V> r0 = r1.element
            int r3 = (int) r14
            r4 = r29
            r4.put((net.time4j.engine.ChronoElement<?>) r0, (int) r3)
            goto L_0x03d7
        L_0x0374:
            r4 = r29
            java.lang.Class<java.lang.Long> r5 = java.lang.Long.class
            if (r0 != r5) goto L_0x0384
            java.lang.Long r0 = java.lang.Long.valueOf(r14)
            net.time4j.engine.ChronoElement<V> r3 = r1.element
            r4.put((net.time4j.engine.ChronoElement<?>) r3, (java.lang.Object) r0)
            goto L_0x03d7
        L_0x0384:
            net.time4j.engine.ChronoElement<V> r5 = r1.element
            net.time4j.NavigableElement<net.time4j.Month> r8 = net.time4j.PlainDate.MONTH_OF_YEAR
            if (r5 != r8) goto L_0x0391
            net.time4j.ProportionalElement<java.lang.Integer, net.time4j.PlainDate> r0 = net.time4j.PlainDate.MONTH_AS_NUMBER
            int r3 = (int) r14
            r4.put((net.time4j.engine.ChronoElement<?>) r0, (int) r3)
            goto L_0x03d7
        L_0x0391:
            java.lang.Class<java.lang.Enum> r5 = java.lang.Enum.class
            boolean r0 = r5.isAssignableFrom(r0)
            if (r0 == 0) goto L_0x03db
            net.time4j.engine.ChronoElement<V> r0 = r1.element
            boolean r5 = r0 instanceof net.time4j.format.NumericalElement
            if (r5 == 0) goto L_0x03a7
            net.time4j.format.NumericalElement r0 = (net.time4j.format.NumericalElement) r0
            int r5 = (int) r14
            boolean r13 = r0.parseFromInt(r4, r5)
            goto L_0x03a8
        L_0x03a7:
            r13 = 0
        L_0x03a8:
            if (r13 != 0) goto L_0x03d7
            r0 = 45
            if (r3 == r0) goto L_0x03b2
            r0 = 43
            if (r3 != r0) goto L_0x03b4
        L_0x03b2:
            int r7 = r7 + -1
        L_0x03b4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "["
            r0.append(r3)
            net.time4j.engine.ChronoElement<V> r3 = r1.element
            java.lang.String r3 = r3.name()
            r0.append(r3)
            java.lang.String r3 = "] No enum found for value: "
            r0.append(r3)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            r2.setError(r7, r0)
            return
        L_0x03d7:
            r2.setPosition(r6)
            return
        L_0x03db:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Not parseable: "
            r2.append(r3)
            net.time4j.engine.ChronoElement<V> r3 = r1.element
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.NumberProcessor.parse(java.lang.CharSequence, net.time4j.format.expert.ParseLog, net.time4j.engine.AttributeQuery, net.time4j.format.expert.ParsedEntity, boolean):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NumberProcessor)) {
            return false;
        }
        NumberProcessor numberProcessor = (NumberProcessor) obj;
        if (this.element.equals(numberProcessor.element) && this.fixedWidth == numberProcessor.fixedWidth && this.minDigits == numberProcessor.minDigits && this.maxDigits == numberProcessor.maxDigits && this.signPolicy == numberProcessor.signPolicy && this.protectedMode == numberProcessor.protectedMode) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + ((this.minDigits + (this.maxDigits * 10)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", fixed-width-mode=");
        sb.append(this.fixedWidth);
        sb.append(", min-digits=");
        sb.append(this.minDigits);
        sb.append(", max-digits=");
        sb.append(this.maxDigits);
        sb.append(", sign-policy=");
        sb.append(this.signPolicy);
        sb.append(", protected-mode=");
        sb.append(this.protectedMode);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public ChronoElement<V> getElement() {
        return this.element;
    }

    public FormatProcessor<V> withElement(ChronoElement<V> chronoElement) {
        if (this.protectedMode || this.element == chronoElement) {
            return this;
        }
        return new NumberProcessor(chronoElement, this.fixedWidth, this.minDigits, this.maxDigits, this.signPolicy, false);
    }

    public FormatProcessor<V> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        char c;
        char charAt;
        AttributeQuery attributeQuery2 = attributeQuery;
        NumberSystem numberSystem2 = (NumberSystem) attributeQuery2.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
        if (attributeQuery2.contains(Attributes.ZERO_DIGIT)) {
            charAt = ((Character) attributeQuery2.get(Attributes.ZERO_DIGIT)).charValue();
        } else if (numberSystem2.isDecimal()) {
            charAt = numberSystem2.getDigits().charAt(0);
        } else {
            c = '0';
            int intValue = ((Integer) attributeQuery2.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
            return new NumberProcessor(this.element, this.fixedWidth, this.minDigits, this.maxDigits, this.signPolicy, this.protectedMode, i, c, numberSystem2, (Leniency) attributeQuery2.get(Attributes.LENIENCY, Leniency.SMART), intValue, numberSystem2 != NumberSystem.ARABIC && c == '0' && this.fixedWidth && intValue == 0 && this.element.getType() == Integer.class && !this.yearOfEra);
        }
        c = charAt;
        int intValue2 = ((Integer) attributeQuery2.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
        return new NumberProcessor(this.element, this.fixedWidth, this.minDigits, this.maxDigits, this.signPolicy, this.protectedMode, i, c, numberSystem2, (Leniency) attributeQuery2.get(Attributes.LENIENCY, Leniency.SMART), intValue2, numberSystem2 != NumberSystem.ARABIC && c == '0' && this.fixedWidth && intValue2 == 0 && this.element.getType() == Integer.class && !this.yearOfEra);
    }

    private int getScale(NumberSystem numberSystem2) {
        if (!numberSystem2.isDecimal()) {
            return 100;
        }
        Class<V> type = this.element.getType();
        if (type == Integer.class) {
            return 10;
        }
        return type == Long.class ? 18 : 9;
    }

    private static int length(int i) {
        int i2 = 0;
        while (i > THRESHOLDS[i2]) {
            i2++;
        }
        return i2 + 1;
    }

    private static void appendTwoDigits(int i, Appendable appendable, char c) throws IOException {
        int i2 = (i * 103) >>> 10;
        appendable.append((char) (i2 + c));
        appendable.append((char) ((i - ((i2 << 3) + (i2 << 1))) + c));
    }
}
