package com.adobe.xmp.impl;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

public class FixASCIIControlsReader extends PushbackReader {
    private static final int BUFFER_SIZE = 8;
    private static final int STATE_AMP = 1;
    private static final int STATE_DIG1 = 4;
    private static final int STATE_ERROR = 5;
    private static final int STATE_HASH = 2;
    private static final int STATE_HEX = 3;
    private static final int STATE_START = 0;
    private int control = 0;
    private int digits = 0;
    private int state = 0;

    public FixASCIIControlsReader(Reader reader) {
        super(reader, 8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (com.adobe.xmp.impl.Utils.isControlChar((char) r10.control) != false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0084, code lost:
        if (com.adobe.xmp.impl.Utils.isControlChar((char) r10.control) != false) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private char processChar(char r11) {
        /*
            r10 = this;
            int r0 = r10.state
            r1 = 1
            if (r0 == 0) goto L_0x00af
            r2 = 2
            r3 = 5
            if (r0 == r1) goto L_0x00a5
            r4 = 10
            r5 = 57
            r6 = 48
            r7 = 3
            r8 = 4
            r9 = 0
            if (r0 == r2) goto L_0x0088
            r2 = 59
            if (r0 == r7) goto L_0x004d
            if (r0 == r8) goto L_0x0020
            if (r0 == r3) goto L_0x001d
            return r11
        L_0x001d:
            r10.state = r9
            return r11
        L_0x0020:
            if (r6 > r11) goto L_0x0039
            if (r11 > r5) goto L_0x0039
            int r0 = r10.control
            int r0 = r0 * 10
            int r2 = java.lang.Character.digit(r11, r4)
            int r0 = r0 + r2
            r10.control = r0
            int r0 = r10.digits
            int r0 = r0 + r1
            r10.digits = r0
            if (r0 > r3) goto L_0x004a
            r10.state = r8
            goto L_0x004c
        L_0x0039:
            if (r11 != r2) goto L_0x004a
            int r0 = r10.control
            char r0 = (char) r0
            boolean r0 = com.adobe.xmp.impl.Utils.isControlChar(r0)
            if (r0 == 0) goto L_0x004a
        L_0x0044:
            r10.state = r9
            int r11 = r10.control
            char r11 = (char) r11
            return r11
        L_0x004a:
            r10.state = r3
        L_0x004c:
            return r11
        L_0x004d:
            if (r6 > r11) goto L_0x0051
            if (r11 <= r5) goto L_0x0061
        L_0x0051:
            r0 = 97
            if (r0 > r11) goto L_0x0059
            r0 = 102(0x66, float:1.43E-43)
            if (r11 <= r0) goto L_0x0061
        L_0x0059:
            r0 = 65
            if (r0 > r11) goto L_0x007b
            r0 = 70
            if (r11 > r0) goto L_0x007b
        L_0x0061:
            int r0 = r10.control
            r2 = 16
            int r0 = r0 * 16
            int r2 = java.lang.Character.digit(r11, r2)
            int r0 = r0 + r2
            r10.control = r0
            int r0 = r10.digits
            int r0 = r0 + r1
            r10.digits = r0
            if (r0 > r8) goto L_0x0078
            r10.state = r7
            goto L_0x0087
        L_0x0078:
            r10.state = r3
            goto L_0x0087
        L_0x007b:
            if (r11 != r2) goto L_0x0078
            int r0 = r10.control
            char r0 = (char) r0
            boolean r0 = com.adobe.xmp.impl.Utils.isControlChar(r0)
            if (r0 == 0) goto L_0x0078
            goto L_0x0044
        L_0x0087:
            return r11
        L_0x0088:
            r0 = 120(0x78, float:1.68E-43)
            if (r11 != r0) goto L_0x0093
            r10.control = r9
            r10.digits = r9
            r10.state = r7
            goto L_0x00a4
        L_0x0093:
            if (r6 > r11) goto L_0x00a2
            if (r11 > r5) goto L_0x00a2
            int r0 = java.lang.Character.digit(r11, r4)
            r10.control = r0
            r10.digits = r1
            r10.state = r8
            goto L_0x00a4
        L_0x00a2:
            r10.state = r3
        L_0x00a4:
            return r11
        L_0x00a5:
            r0 = 35
            if (r11 != r0) goto L_0x00ac
            r10.state = r2
            goto L_0x00ae
        L_0x00ac:
            r10.state = r3
        L_0x00ae:
            return r11
        L_0x00af:
            r0 = 38
            if (r11 != r0) goto L_0x00b5
            r10.state = r1
        L_0x00b5:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adobe.xmp.impl.FixASCIIControlsReader.processChar(char):char");
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        char[] cArr2 = new char[8];
        boolean z = true;
        int i3 = 0;
        loop0:
        while (true) {
            int i4 = 0;
            while (z && i3 < i2) {
                z = super.read(cArr2, i4, 1) == 1;
                if (z) {
                    char processChar = processChar(cArr2[i4]);
                    int i5 = this.state;
                    if (i5 == 0) {
                        if (Utils.isControlChar(processChar)) {
                            processChar = ' ';
                        }
                        cArr[i] = processChar;
                        i3++;
                        i++;
                    } else {
                        i4++;
                        if (i5 == 5) {
                            unread(cArr2, 0, i4);
                        }
                    }
                } else if (i4 > 0) {
                    unread(cArr2, 0, i4);
                    this.state = 5;
                    z = true;
                }
            }
        }
        if (i3 > 0 || z) {
            return i3;
        }
        return -1;
    }
}
