package com.drew.imaging.tiff;

import com.drew.lang.RandomAccessReader;
import com.drew.lang.Rational;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;

public class TiffReader {
    private static int calculateTagOffset(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    public void processTiff(RandomAccessReader randomAccessReader, TiffHandler tiffHandler, int i) throws TiffProcessingException, IOException {
        short int16 = randomAccessReader.getInt16(i);
        if (int16 == 19789) {
            randomAccessReader.setMotorolaByteOrder(true);
        } else if (int16 == 18761) {
            randomAccessReader.setMotorolaByteOrder(false);
        } else {
            throw new TiffProcessingException("Unclear distinction between Motorola/Intel byte ordering: " + int16);
        }
        int i2 = i + 2;
        tiffHandler.setTiffMarker(randomAccessReader.getUInt16(i2));
        int int32 = randomAccessReader.getInt32(i + 4) + i;
        if (((long) int32) >= randomAccessReader.getLength() - 1) {
            tiffHandler.warn("First IFD offset is beyond the end of the TIFF data segment -- trying default offset");
            int32 = i2 + 2 + 4;
        }
        processIfd(tiffHandler, randomAccessReader, new HashSet(), int32, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x011f A[SYNTHETIC, Splitter:B:70:0x011f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void processIfd(com.drew.imaging.tiff.TiffHandler r28, com.drew.lang.RandomAccessReader r29, java.util.Set<java.lang.Integer> r30, int r31, int r32) throws java.io.IOException {
        /*
            r8 = r28
            r9 = r29
            r0 = r30
            r10 = r31
            r11 = r32
            r1 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r31)     // Catch:{ all -> 0x020e }
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x020e }
            if (r2 == 0) goto L_0x0019
            r28.endingIFD()
            return
        L_0x0019:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r31)     // Catch:{ all -> 0x020e }
            r0.add(r2)     // Catch:{ all -> 0x020e }
            long r2 = (long) r10     // Catch:{ all -> 0x020e }
            long r4 = r29.getLength()     // Catch:{ all -> 0x020e }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0205
            if (r10 >= 0) goto L_0x002d
            goto L_0x0205
        L_0x002d:
            int r2 = r9.getUInt16(r10)     // Catch:{ all -> 0x020e }
            r3 = 255(0xff, float:3.57E-43)
            if (r2 <= r3) goto L_0x004f
            r3 = r2 & 255(0xff, float:3.57E-43)
            if (r3 != 0) goto L_0x004f
            boolean r3 = r29.isMotorolaByteOrder()     // Catch:{ all -> 0x020e }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x020e }
            int r2 = r2 >> 8
            boolean r3 = r29.isMotorolaByteOrder()     // Catch:{ all -> 0x020e }
            if (r3 != 0) goto L_0x004b
            r3 = 1
            goto L_0x004c
        L_0x004b:
            r3 = 0
        L_0x004c:
            r9.setMotorolaByteOrder(r3)     // Catch:{ all -> 0x020e }
        L_0x004f:
            r14 = r1
            r15 = r2
            int r1 = r15 * 12
            r7 = 2
            int r1 = r1 + r7
            int r1 = r1 + 4
            int r1 = r1 + r10
            long r1 = (long) r1
            long r3 = r29.getLength()     // Catch:{ all -> 0x01ff }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0077
            java.lang.String r0 = "Illegally sized IFD"
            r8.error(r0)     // Catch:{ all -> 0x0073 }
            r28.endingIFD()
            if (r14 == 0) goto L_0x0072
            boolean r0 = r14.booleanValue()
            r9.setMotorolaByteOrder(r0)
        L_0x0072:
            return
        L_0x0073:
            r0 = move-exception
            r1 = r14
            goto L_0x020f
        L_0x0077:
            r6 = 0
            r16 = 0
        L_0x007a:
            if (r6 >= r15) goto L_0x01b4
            int r1 = calculateTagOffset(r10, r6)     // Catch:{ all -> 0x01ff }
            int r5 = r9.getUInt16(r1)     // Catch:{ all -> 0x01ff }
            int r2 = r1 + 2
            int r4 = r9.getUInt16(r2)     // Catch:{ all -> 0x01ff }
            com.drew.imaging.tiff.TiffDataFormat r2 = com.drew.imaging.tiff.TiffDataFormat.fromTiffFormatCode(r4)     // Catch:{ all -> 0x01ff }
            int r3 = r1 + 4
            long r12 = r9.getUInt32(r3)     // Catch:{ all -> 0x01ff }
            if (r2 != 0) goto L_0x00e3
            java.lang.Long r2 = r8.tryCustomProcessFormat(r5, r4, r12)     // Catch:{ all -> 0x0073 }
            if (r2 != 0) goto L_0x00da
            java.lang.String r1 = "Invalid TIFF tag format code %d for tag 0x%04X"
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch:{ all -> 0x0073 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0073 }
            r18 = 0
            r2[r18] = r3     // Catch:{ all -> 0x0073 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0073 }
            r17 = 1
            r2[r17] = r3     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch:{ all -> 0x0073 }
            r8.error(r1)     // Catch:{ all -> 0x0073 }
            int r1 = r16 + 1
            r2 = 5
            if (r1 <= r2) goto L_0x00ce
            java.lang.String r0 = "Stopping processing as too many errors seen in TIFF IFD"
            r8.error(r0)     // Catch:{ all -> 0x0073 }
            r28.endingIFD()
            if (r14 == 0) goto L_0x00cd
            boolean r0 = r14.booleanValue()
            r9.setMotorolaByteOrder(r0)
        L_0x00cd:
            return
        L_0x00ce:
            r16 = r1
        L_0x00d0:
            r20 = r6
            r25 = r14
            r24 = r15
        L_0x00d6:
            r19 = 2
            goto L_0x01ab
        L_0x00da:
            r17 = 1
            r18 = 0
            long r2 = r2.longValue()     // Catch:{ all -> 0x0073 }
            goto L_0x00ee
        L_0x00e3:
            r17 = 1
            r18 = 0
            int r2 = r2.getComponentSizeBytes()     // Catch:{ all -> 0x01ff }
            long r2 = (long) r2
            long r2 = r2 * r12
        L_0x00ee:
            java.lang.String r7 = "Illegal TIFF tag pointer offset"
            r20 = 4
            int r22 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r22 <= 0) goto L_0x0112
            int r1 = r1 + 8
            long r22 = r9.getUInt32(r1)     // Catch:{ all -> 0x01ff }
            long r24 = r22 + r2
            long r26 = r29.getLength()     // Catch:{ all -> 0x01ff }
            int r1 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1))
            if (r1 <= 0) goto L_0x010a
            r8.error(r7)     // Catch:{ all -> 0x0073 }
            goto L_0x00d0
        L_0x010a:
            r25 = r14
            r24 = r15
            long r14 = (long) r11
            long r14 = r14 + r22
            goto L_0x0119
        L_0x0112:
            r25 = r14
            r24 = r15
            int r1 = r1 + 8
            long r14 = (long) r1
        L_0x0119:
            r22 = 0
            int r1 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r1 < 0) goto L_0x01a4
            long r26 = r29.getLength()     // Catch:{ all -> 0x01fd }
            int r1 = (r14 > r26 ? 1 : (r14 == r26 ? 0 : -1))
            if (r1 <= 0) goto L_0x0129
            goto L_0x01a4
        L_0x0129:
            int r1 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r1 < 0) goto L_0x018b
            long r22 = r14 + r2
            long r26 = r29.getLength()     // Catch:{ all -> 0x01fd }
            int r1 = (r22 > r26 ? 1 : (r22 == r26 ? 0 : -1))
            if (r1 <= 0) goto L_0x0138
            goto L_0x018b
        L_0x0138:
            long r20 = r20 * r12
            int r1 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            r20 = r6
            if (r1 != 0) goto L_0x0163
            r1 = 0
            r21 = 0
        L_0x0143:
            long r6 = (long) r1     // Catch:{ all -> 0x01fd }
            int r22 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r22 >= 0) goto L_0x0160
            boolean r6 = r8.tryEnterSubIfd(r5)     // Catch:{ all -> 0x01fd }
            if (r6 == 0) goto L_0x015d
            int r6 = r1 * 4
            long r6 = (long) r6     // Catch:{ all -> 0x01fd }
            long r6 = r6 + r14
            int r7 = (int) r6     // Catch:{ all -> 0x01fd }
            int r6 = r9.getInt32(r7)     // Catch:{ all -> 0x01fd }
            int r6 = r6 + r11
            processIfd(r8, r9, r0, r6, r11)     // Catch:{ all -> 0x01fd }
            r21 = 1
        L_0x015d:
            int r1 = r1 + 1
            goto L_0x0143
        L_0x0160:
            r7 = r21
            goto L_0x0164
        L_0x0163:
            r7 = 0
        L_0x0164:
            if (r7 != 0) goto L_0x00d6
            int r15 = (int) r14     // Catch:{ all -> 0x01fd }
            int r7 = (int) r2     // Catch:{ all -> 0x01fd }
            r1 = r28
            r2 = r15
            r3 = r30
            r14 = r4
            r4 = r32
            r21 = r5
            r5 = r29
            r6 = r21
            r19 = 2
            boolean r1 = r1.customProcessTag(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x01fd }
            if (r1 != 0) goto L_0x01ab
            int r4 = (int) r12     // Catch:{ all -> 0x01fd }
            r1 = r28
            r2 = r21
            r3 = r15
            r5 = r14
            r6 = r29
            processTag(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x01fd }
            goto L_0x01ab
        L_0x018b:
            r20 = r6
            r19 = 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fd }
            r1.<init>()     // Catch:{ all -> 0x01fd }
            java.lang.String r4 = "Illegal number of bytes for TIFF tag data: "
            r1.append(r4)     // Catch:{ all -> 0x01fd }
            r1.append(r2)     // Catch:{ all -> 0x01fd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01fd }
            r8.error(r1)     // Catch:{ all -> 0x01fd }
            goto L_0x01ab
        L_0x01a4:
            r20 = r6
            r19 = 2
            r8.error(r7)     // Catch:{ all -> 0x01fd }
        L_0x01ab:
            int r6 = r20 + 1
            r15 = r24
            r14 = r25
            r7 = 2
            goto L_0x007a
        L_0x01b4:
            r25 = r14
            r2 = r15
            int r1 = calculateTagOffset(r10, r2)     // Catch:{ all -> 0x01fd }
            int r1 = r9.getInt32(r1)     // Catch:{ all -> 0x01fd }
            if (r1 == 0) goto L_0x01f0
            int r1 = r1 + r11
            long r2 = (long) r1     // Catch:{ all -> 0x01fd }
            long r4 = r29.getLength()     // Catch:{ all -> 0x01fd }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x01d8
            r28.endingIFD()
            if (r25 == 0) goto L_0x01d7
            boolean r0 = r25.booleanValue()
            r9.setMotorolaByteOrder(r0)
        L_0x01d7:
            return
        L_0x01d8:
            if (r1 >= r10) goto L_0x01e7
            r28.endingIFD()
            if (r25 == 0) goto L_0x01e6
            boolean r0 = r25.booleanValue()
            r9.setMotorolaByteOrder(r0)
        L_0x01e6:
            return
        L_0x01e7:
            boolean r2 = r28.hasFollowerIfd()     // Catch:{ all -> 0x01fd }
            if (r2 == 0) goto L_0x01f0
            processIfd(r8, r9, r0, r1, r11)     // Catch:{ all -> 0x01fd }
        L_0x01f0:
            r28.endingIFD()
            if (r25 == 0) goto L_0x01fc
            boolean r0 = r25.booleanValue()
            r9.setMotorolaByteOrder(r0)
        L_0x01fc:
            return
        L_0x01fd:
            r0 = move-exception
            goto L_0x0202
        L_0x01ff:
            r0 = move-exception
            r25 = r14
        L_0x0202:
            r1 = r25
            goto L_0x020f
        L_0x0205:
            java.lang.String r0 = "Ignored IFD marked to start outside data segment"
            r8.error(r0)     // Catch:{ all -> 0x020e }
            r28.endingIFD()
            return
        L_0x020e:
            r0 = move-exception
        L_0x020f:
            r28.endingIFD()
            if (r1 == 0) goto L_0x021b
            boolean r1 = r1.booleanValue()
            r9.setMotorolaByteOrder(r1)
        L_0x021b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.imaging.tiff.TiffReader.processIfd(com.drew.imaging.tiff.TiffHandler, com.drew.lang.RandomAccessReader, java.util.Set, int, int):void");
    }

    private static void processTag(TiffHandler tiffHandler, int i, int i2, int i3, int i4, RandomAccessReader randomAccessReader) throws IOException {
        int i5 = 0;
        switch (i4) {
            case 1:
                if (i3 == 1) {
                    tiffHandler.setInt8u(i, randomAccessReader.getUInt8(i2));
                    return;
                }
                short[] sArr = new short[i3];
                while (i5 < i3) {
                    sArr[i5] = randomAccessReader.getUInt8(i2 + i5);
                    i5++;
                }
                tiffHandler.setInt8uArray(i, sArr);
                return;
            case 2:
                tiffHandler.setString(i, randomAccessReader.getNullTerminatedStringValue(i2, i3, (Charset) null));
                return;
            case 3:
                if (i3 == 1) {
                    tiffHandler.setInt16u(i, randomAccessReader.getUInt16(i2));
                    return;
                }
                int[] iArr = new int[i3];
                while (i5 < i3) {
                    iArr[i5] = randomAccessReader.getUInt16((i5 * 2) + i2);
                    i5++;
                }
                tiffHandler.setInt16uArray(i, iArr);
                return;
            case 4:
                if (i3 == 1) {
                    tiffHandler.setInt32u(i, randomAccessReader.getUInt32(i2));
                    return;
                }
                long[] jArr = new long[i3];
                while (i5 < i3) {
                    jArr[i5] = randomAccessReader.getUInt32((i5 * 4) + i2);
                    i5++;
                }
                tiffHandler.setInt32uArray(i, jArr);
                return;
            case 5:
                if (i3 == 1) {
                    tiffHandler.setRational(i, new Rational(randomAccessReader.getUInt32(i2), randomAccessReader.getUInt32(i2 + 4)));
                    return;
                } else if (i3 > 1) {
                    Rational[] rationalArr = new Rational[i3];
                    while (i5 < i3) {
                        int i6 = i5 * 8;
                        rationalArr[i5] = new Rational(randomAccessReader.getUInt32(i2 + i6), randomAccessReader.getUInt32(i2 + 4 + i6));
                        i5++;
                    }
                    tiffHandler.setRationalArray(i, rationalArr);
                    return;
                } else {
                    return;
                }
            case 6:
                if (i3 == 1) {
                    tiffHandler.setInt8s(i, randomAccessReader.getInt8(i2));
                    return;
                }
                byte[] bArr = new byte[i3];
                while (i5 < i3) {
                    bArr[i5] = randomAccessReader.getInt8(i2 + i5);
                    i5++;
                }
                tiffHandler.setInt8sArray(i, bArr);
                return;
            case 7:
                tiffHandler.setByteArray(i, randomAccessReader.getBytes(i2, i3));
                return;
            case 8:
                if (i3 == 1) {
                    tiffHandler.setInt16s(i, randomAccessReader.getInt16(i2));
                    return;
                }
                short[] sArr2 = new short[i3];
                while (i5 < i3) {
                    sArr2[i5] = randomAccessReader.getInt16((i5 * 2) + i2);
                    i5++;
                }
                tiffHandler.setInt16sArray(i, sArr2);
                return;
            case 9:
                if (i3 == 1) {
                    tiffHandler.setInt32s(i, randomAccessReader.getInt32(i2));
                    return;
                }
                int[] iArr2 = new int[i3];
                while (i5 < i3) {
                    iArr2[i5] = randomAccessReader.getInt32((i5 * 4) + i2);
                    i5++;
                }
                tiffHandler.setInt32sArray(i, iArr2);
                return;
            case 10:
                if (i3 == 1) {
                    tiffHandler.setRational(i, new Rational((long) randomAccessReader.getInt32(i2), (long) randomAccessReader.getInt32(i2 + 4)));
                    return;
                } else if (i3 > 1) {
                    Rational[] rationalArr2 = new Rational[i3];
                    while (i5 < i3) {
                        int i7 = i5 * 8;
                        rationalArr2[i5] = new Rational((long) randomAccessReader.getInt32(i2 + i7), (long) randomAccessReader.getInt32(i2 + 4 + i7));
                        i5++;
                    }
                    tiffHandler.setRationalArray(i, rationalArr2);
                    return;
                } else {
                    return;
                }
            case 11:
                if (i3 == 1) {
                    tiffHandler.setFloat(i, randomAccessReader.getFloat32(i2));
                    return;
                }
                float[] fArr = new float[i3];
                while (i5 < i3) {
                    fArr[i5] = randomAccessReader.getFloat32((i5 * 4) + i2);
                    i5++;
                }
                tiffHandler.setFloatArray(i, fArr);
                return;
            case 12:
                if (i3 == 1) {
                    tiffHandler.setDouble(i, randomAccessReader.getDouble64(i2));
                    return;
                }
                double[] dArr = new double[i3];
                while (i5 < i3) {
                    dArr[i5] = randomAccessReader.getDouble64((i5 * 4) + i2);
                    i5++;
                }
                tiffHandler.setDoubleArray(i, dArr);
                return;
            default:
                tiffHandler.error(String.format("Invalid TIFF tag format code %d for tag 0x%04X", new Object[]{Integer.valueOf(i4), Integer.valueOf(i)}));
                return;
        }
    }
}
