package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

class ProfileTranscoder {
    private static final int HOT = 1;
    private static final int INLINE_CACHE_MEGAMORPHIC_ENCODING = 7;
    private static final int INLINE_CACHE_MISSING_TYPES_ENCODING = 6;
    static final byte[] MAGIC_PROF = {112, 114, 111, 0};
    static final byte[] MAGIC_PROFM = {112, 114, 109, 0};
    private static final int POST_STARTUP = 4;
    private static final int STARTUP = 2;

    private static int roundUpToByte(int i) {
        return ((i + 8) - 1) & -8;
    }

    private ProfileTranscoder() {
    }

    static byte[] readHeader(InputStream inputStream, byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, Encoding.read(inputStream, bArr.length))) {
            return Encoding.read(inputStream, ProfileVersion.V010_P.length);
        }
        throw Encoding.error("Invalid magic");
    }

    static void writeHeader(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(MAGIC_PROF);
        outputStream.write(bArr);
    }

    static boolean transcodeAndWriteBody(OutputStream outputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.V010_P)) {
            writeProfileForP(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.V005_O)) {
            writeProfileForO(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.V009_O_MR1)) {
            writeProfileForO_MR1(outputStream, dexProfileDataArr);
            return true;
        } else if (!Arrays.equals(bArr, ProfileVersion.V001_N)) {
            return false;
        } else {
            writeProfileForN(outputStream, dexProfileDataArr);
            return true;
        }
    }

    private static void writeProfileForN(OutputStream outputStream, DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.writeUInt16(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String generateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, ProfileVersion.V001_N);
            Encoding.writeUInt16(outputStream, Encoding.utf8Length(generateDexKey));
            Encoding.writeUInt16(outputStream, dexProfileData.methods.size());
            Encoding.writeUInt16(outputStream, dexProfileData.classes.length);
            Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
            Encoding.writeString(outputStream, generateDexKey);
            for (Integer intValue : dexProfileData.methods.keySet()) {
                Encoding.writeUInt16(outputStream, intValue.intValue());
            }
            for (int writeUInt16 : dexProfileData.classes) {
                Encoding.writeUInt16(outputStream, writeUInt16);
            }
        }
    }

    private static void writeProfileForP(OutputStream outputStream, DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] createCompressibleBody = createCompressibleBody(dexProfileDataArr, ProfileVersion.V010_P);
        Encoding.writeUInt8(outputStream, dexProfileDataArr.length);
        Encoding.writeCompressed(outputStream, createCompressibleBody);
    }

    private static void writeProfileForO_MR1(OutputStream outputStream, DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] createCompressibleBody = createCompressibleBody(dexProfileDataArr, ProfileVersion.V009_O_MR1);
        Encoding.writeUInt8(outputStream, dexProfileDataArr.length);
        Encoding.writeCompressed(outputStream, createCompressibleBody);
    }

    private static void writeProfileForO(OutputStream outputStream, DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.writeUInt8(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String generateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, ProfileVersion.V005_O);
            Encoding.writeUInt16(outputStream, Encoding.utf8Length(generateDexKey));
            Encoding.writeUInt16(outputStream, dexProfileData.classes.length);
            Encoding.writeUInt32(outputStream, (long) (dexProfileData.methods.size() * 4));
            Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
            Encoding.writeString(outputStream, generateDexKey);
            for (Integer intValue : dexProfileData.methods.keySet()) {
                Encoding.writeUInt16(outputStream, intValue.intValue());
                Encoding.writeUInt16(outputStream, 0);
            }
            for (int writeUInt16 : dexProfileData.classes) {
                Encoding.writeUInt16(outputStream, writeUInt16);
            }
        }
    }

    private static byte[] createCompressibleBody(DexProfileData[] dexProfileDataArr, byte[] bArr) throws IOException {
        int i = 0;
        int i2 = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            i2 += Encoding.utf8Length(generateDexKey(dexProfileData.apkName, dexProfileData.dexName, bArr)) + 16 + (dexProfileData.classSetSize * 2) + dexProfileData.hotMethodRegionSize + getMethodBitmapStorageSize(dexProfileData.numMethodIds);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        if (Arrays.equals(bArr, ProfileVersion.V009_O_MR1)) {
            int length = dexProfileDataArr.length;
            while (i < length) {
                DexProfileData dexProfileData2 = dexProfileDataArr[i];
                writeLineHeader(byteArrayOutputStream, dexProfileData2, generateDexKey(dexProfileData2.apkName, dexProfileData2.dexName, bArr));
                writeLineData(byteArrayOutputStream, dexProfileData2);
                i++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData3, generateDexKey(dexProfileData3.apkName, dexProfileData3.dexName, bArr));
            }
            int length2 = dexProfileDataArr.length;
            while (i < length2) {
                writeLineData(byteArrayOutputStream, dexProfileDataArr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == i2) {
            return byteArrayOutputStream.toByteArray();
        }
        throw Encoding.error("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i2);
    }

    private static int getMethodBitmapStorageSize(int i) {
        return roundUpToByte(i * 2) / 8;
    }

    private static void setMethodBitmapBit(byte[] bArr, int i, int i2, DexProfileData dexProfileData) {
        int methodFlagBitmapIndex = methodFlagBitmapIndex(i, i2, dexProfileData.numMethodIds);
        int i3 = methodFlagBitmapIndex / 8;
        bArr[i3] = (byte) ((1 << (methodFlagBitmapIndex % 8)) | bArr[i3]);
    }

    private static void writeLineHeader(OutputStream outputStream, DexProfileData dexProfileData, String str) throws IOException {
        Encoding.writeUInt16(outputStream, Encoding.utf8Length(str));
        Encoding.writeUInt16(outputStream, dexProfileData.classSetSize);
        Encoding.writeUInt32(outputStream, (long) dexProfileData.hotMethodRegionSize);
        Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
        Encoding.writeUInt32(outputStream, (long) dexProfileData.numMethodIds);
        Encoding.writeString(outputStream, str);
    }

    private static void writeLineData(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        writeMethodsWithInlineCaches(outputStream, dexProfileData);
        writeClasses(outputStream, dexProfileData);
        writeMethodBitmap(outputStream, dexProfileData);
    }

    private static void writeMethodsWithInlineCaches(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        int i = 0;
        for (Map.Entry next : dexProfileData.methods.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            if ((((Integer) next.getValue()).intValue() & 1) != 0) {
                Encoding.writeUInt16(outputStream, intValue - i);
                Encoding.writeUInt16(outputStream, 0);
                i = intValue;
            }
        }
    }

    private static void writeClasses(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        int i = 0;
        for (int valueOf : dexProfileData.classes) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            Encoding.writeUInt16(outputStream, valueOf2.intValue() - i);
            i = valueOf2.intValue();
        }
    }

    private static void writeMethodBitmap(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[getMethodBitmapStorageSize(dexProfileData.numMethodIds)];
        for (Map.Entry next : dexProfileData.methods.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                setMethodBitmapBit(bArr, 2, intValue, dexProfileData);
            }
            if ((intValue2 & 4) != 0) {
                setMethodBitmapBit(bArr, 4, intValue, dexProfileData);
            }
        }
        outputStream.write(bArr);
    }

    static DexProfileData[] readProfile(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.V010_P)) {
            int readUInt8 = Encoding.readUInt8(inputStream);
            byte[] readCompressed = Encoding.readCompressed(inputStream, (int) Encoding.readUInt32(inputStream), (int) Encoding.readUInt32(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readCompressed);
                try {
                    DexProfileData[] readUncompressedBody = readUncompressedBody(byteArrayInputStream, str, readUInt8);
                    byteArrayInputStream.close();
                    return readUncompressedBody;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw Encoding.error("Content found after the end of file");
            }
        } else {
            throw Encoding.error("Unsupported version");
        }
        throw th;
    }

    static DexProfileData[] readMeta(InputStream inputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.METADATA_V001_N)) {
            int readUInt8 = Encoding.readUInt8(inputStream);
            byte[] readCompressed = Encoding.readCompressed(inputStream, (int) Encoding.readUInt32(inputStream), (int) Encoding.readUInt32(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readCompressed);
                try {
                    DexProfileData[] readMetadataForNBody = readMetadataForNBody(byteArrayInputStream, readUInt8, dexProfileDataArr);
                    byteArrayInputStream.close();
                    return readMetadataForNBody;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw Encoding.error("Content found after the end of file");
            }
        } else {
            throw Encoding.error("Unsupported meta version");
        }
        throw th;
    }

    private static DexProfileData[] readMetadataForNBody(InputStream inputStream, int i, DexProfileData[] dexProfileDataArr) throws IOException {
        int i2 = 0;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i == dexProfileDataArr.length) {
            String[] strArr = new String[i];
            int[] iArr = new int[i];
            for (int i3 = 0; i3 < i; i3++) {
                int readUInt16 = Encoding.readUInt16(inputStream);
                iArr[i3] = Encoding.readUInt16(inputStream);
                strArr[i3] = Encoding.readString(inputStream, readUInt16);
            }
            while (i2 < i) {
                DexProfileData dexProfileData = dexProfileDataArr[i2];
                if (dexProfileData.dexName.equals(strArr[i2])) {
                    dexProfileData.classSetSize = iArr[i2];
                    dexProfileData.classes = new int[dexProfileData.classSetSize];
                    readClasses(inputStream, dexProfileData);
                    i2++;
                } else {
                    throw Encoding.error("Order of dexfiles in metadata did not match baseline");
                }
            }
            return dexProfileDataArr;
        }
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    private static String generateDexKey(String str, String str2, byte[] bArr) {
        if (str2.equals("classes.dex")) {
            return str;
        }
        return str + ProfileVersion.dexKeySeparator(bArr) + str2;
    }

    private static DexProfileData[] readUncompressedBody(InputStream inputStream, String str, int i) throws IOException {
        InputStream inputStream2 = inputStream;
        int i2 = i;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int readUInt16 = Encoding.readUInt16(inputStream);
            int readUInt162 = Encoding.readUInt16(inputStream);
            long readUInt32 = Encoding.readUInt32(inputStream);
            long readUInt322 = Encoding.readUInt32(inputStream);
            long readUInt323 = Encoding.readUInt32(inputStream);
            String str2 = str;
            dexProfileDataArr[i3] = new DexProfileData(str2, Encoding.readString(inputStream2, readUInt16), readUInt322, readUInt162, (int) readUInt32, (int) readUInt323, new int[readUInt162], new TreeMap());
        }
        for (int i4 = 0; i4 < i2; i4++) {
            DexProfileData dexProfileData = dexProfileDataArr[i4];
            readHotMethodRegion(inputStream2, dexProfileData);
            readClasses(inputStream2, dexProfileData);
            readMethodBitmap(inputStream2, dexProfileData);
        }
        return dexProfileDataArr;
    }

    private static void readHotMethodRegion(InputStream inputStream, DexProfileData dexProfileData) throws IOException {
        int available = inputStream.available() - dexProfileData.hotMethodRegionSize;
        int i = 0;
        while (inputStream.available() > available) {
            i += Encoding.readUInt16(inputStream);
            dexProfileData.methods.put(Integer.valueOf(i), 1);
            for (int readUInt16 = Encoding.readUInt16(inputStream); readUInt16 > 0; readUInt16--) {
                skipInlineCache(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw Encoding.error("Read too much data during profile line parse");
        }
    }

    private static void skipInlineCache(InputStream inputStream) throws IOException {
        Encoding.readUInt16(inputStream);
        int readUInt8 = Encoding.readUInt8(inputStream);
        if (readUInt8 != 6 && readUInt8 != 7) {
            while (readUInt8 > 0) {
                Encoding.readUInt8(inputStream);
                for (int readUInt82 = Encoding.readUInt8(inputStream); readUInt82 > 0; readUInt82--) {
                    Encoding.readUInt16(inputStream);
                }
                readUInt8--;
            }
        }
    }

    private static void readClasses(InputStream inputStream, DexProfileData dexProfileData) throws IOException {
        int i = 0;
        for (int i2 = 0; i2 < dexProfileData.classSetSize; i2++) {
            i += Encoding.readUInt16(inputStream);
            dexProfileData.classes[i2] = i;
        }
    }

    private static void readMethodBitmap(InputStream inputStream, DexProfileData dexProfileData) throws IOException {
        BitSet valueOf = BitSet.valueOf(Encoding.read(inputStream, Encoding.bitsToBytes(dexProfileData.numMethodIds * 2)));
        for (int i = 0; i < dexProfileData.numMethodIds; i++) {
            int readFlagsFromBitmap = readFlagsFromBitmap(valueOf, i, dexProfileData.numMethodIds);
            if (readFlagsFromBitmap != 0) {
                Integer num = dexProfileData.methods.get(Integer.valueOf(i));
                if (num == null) {
                    num = 0;
                }
                dexProfileData.methods.put(Integer.valueOf(i), Integer.valueOf(readFlagsFromBitmap | num.intValue()));
            }
        }
    }

    private static int readFlagsFromBitmap(BitSet bitSet, int i, int i2) {
        int i3 = 2;
        if (!bitSet.get(methodFlagBitmapIndex(2, i, i2))) {
            i3 = 0;
        }
        return bitSet.get(methodFlagBitmapIndex(4, i, i2)) ? i3 | 4 : i3;
    }

    private static int methodFlagBitmapIndex(int i, int i2, int i3) {
        if (i == 1) {
            throw Encoding.error("HOT methods are not stored in the bitmap");
        } else if (i == 2) {
            return i2;
        } else {
            if (i == 4) {
                return i2 + i3;
            }
            throw Encoding.error("Unexpected flag: " + i);
        }
    }
}
