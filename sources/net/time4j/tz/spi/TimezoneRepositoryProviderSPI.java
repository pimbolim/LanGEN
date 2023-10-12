package net.time4j.tz.spi;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import net.time4j.PlainDate;
import net.time4j.base.GregorianDate;
import net.time4j.scale.LeapSecondProvider;
import net.time4j.tz.TransitionHistory;
import net.time4j.tz.ZoneModelProvider;
import net.time4j.tz.ZoneNameProvider;

public class TimezoneRepositoryProviderSPI implements ZoneModelProvider, LeapSecondProvider {
    private final Map<String, String> aliases;
    private final Map<String, byte[]> data;
    private final PlainDate expires;
    private final Map<GregorianDate, Integer> leapsecs;
    private final String location;
    private final String version;

    public String getFallback() {
        return "";
    }

    public String getName() {
        return "TZDB";
    }

    public ZoneNameProvider getSpecificZoneNameRepository() {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d7, code lost:
        r8 = r2;
        r16 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01d3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01d5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d6, code lost:
        r11 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01df, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01e0, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01e2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01e3, code lost:
        r16 = r2;
        r17 = r3;
        r8 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01d5 A[ExcHandler: all (th java.lang.Throwable), PHI: r6 
      PHI: (r6v5 java.io.InputStream) = (r6v7 java.io.InputStream), (r6v6 java.io.InputStream), (r6v10 java.io.InputStream) binds: [B:47:0x0141, B:36:0x00e0, B:30:0x00d1] A[DONT_GENERATE, DONT_INLINE], Splitter:B:30:0x00d1] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01df A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0206 A[SYNTHETIC, Splitter:B:83:0x0206] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0227 A[SYNTHETIC, Splitter:B:93:0x0227] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TimezoneRepositoryProviderSPI() {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r2 = ""
            r18.<init>()
            net.time4j.engine.TimeAxis r0 = net.time4j.PlainDate.axis()
            net.time4j.engine.TimePoint r0 = r0.getMinimum()
            r3 = r0
            net.time4j.PlainDate r3 = (net.time4j.PlainDate) r3
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r0 = "net.time4j.scale.leapseconds.path"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            r6 = 1
            r7 = 0
            if (r0 == 0) goto L_0x0028
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x0032
            java.util.Map r8 = java.util.Collections.emptyMap()
            r1.leapsecs = r8
            goto L_0x003b
        L_0x0032:
            java.util.LinkedHashMap r8 = new java.util.LinkedHashMap
            r9 = 50
            r8.<init>(r9)
            r1.leapsecs = r8
        L_0x003b:
            java.lang.String r8 = "net.time4j.tz.repository.path"
            java.lang.String r8 = java.lang.System.getProperty(r8)
            java.lang.String r9 = "net.time4j.tz.repository.version"
            java.lang.String r9 = java.lang.System.getProperty(r9)
            java.lang.String r10 = "tzdata"
            if (r9 != 0) goto L_0x004e
            java.lang.String r9 = "tzdata.repository"
            goto L_0x0062
        L_0x004e:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r10)
            r11.append(r9)
            java.lang.String r9 = ".repository"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
        L_0x0062:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01e2, all -> 0x01df }
            r12.<init>()     // Catch:{ IOException -> 0x01e2, all -> 0x01df }
            java.lang.String r13 = "tzrepo/"
            r12.append(r13)     // Catch:{ IOException -> 0x01e2, all -> 0x01df }
            r12.append(r9)     // Catch:{ IOException -> 0x01e2, all -> 0x01df }
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x01e2, all -> 0x01df }
            if (r8 == 0) goto L_0x00bb
            java.io.File r13 = new java.io.File     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            r13.<init>(r8, r9)     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            boolean r8 = r13.isAbsolute()     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            if (r8 == 0) goto L_0x00a2
            boolean r8 = r13.exists()     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            if (r8 == 0) goto L_0x008b
            java.net.URI r8 = r13.toURI()     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            goto L_0x00c7
        L_0x008b:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            r6.<init>()     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            java.lang.String r7 = "Path to tz-repository not found: "
            r6.append(r7)     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            r6.append(r13)     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            r0.<init>(r6)     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            throw r0     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
        L_0x00a2:
            net.time4j.base.ResourceLoader r8 = net.time4j.base.ResourceLoader.getInstance()     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            java.lang.Class r9 = getReference()     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            java.net.URI r8 = r8.locate(r10, r9, r13)     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            goto L_0x00c7
        L_0x00b3:
            r0 = move-exception
            r8 = r2
            r16 = r8
            r17 = r3
            goto L_0x01e9
        L_0x00bb:
            net.time4j.base.ResourceLoader r8 = net.time4j.base.ResourceLoader.getInstance()     // Catch:{ IOException -> 0x01e2, all -> 0x01df }
            java.lang.Class r9 = getReference()     // Catch:{ IOException -> 0x01e2, all -> 0x01df }
            java.net.URI r8 = r8.locate(r10, r9, r12)     // Catch:{ IOException -> 0x01e2, all -> 0x01df }
        L_0x00c7:
            if (r8 == 0) goto L_0x00dc
            net.time4j.base.ResourceLoader r9 = net.time4j.base.ResourceLoader.getInstance()     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            java.io.InputStream r6 = r9.load(r8, r6)     // Catch:{ IOException -> 0x00b3, all -> 0x01df }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x00d6, all -> 0x01d5 }
            goto L_0x00de
        L_0x00d6:
            r0 = move-exception
            r8 = r2
            r16 = r8
            goto L_0x01db
        L_0x00dc:
            r8 = r2
            r6 = 0
        L_0x00de:
            if (r6 != 0) goto L_0x0118
            java.lang.Class r9 = getReference()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            java.net.URL r9 = r9.getResource(r12)     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            if (r9 == 0) goto L_0x0101
            java.net.URLConnection r10 = r9.openConnection()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            r10.setUseCaches(r7)     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            r10.connect()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            java.io.InputStream r6 = r10.getInputStream()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            java.lang.String r8 = r9.toString()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            goto L_0x0118
        L_0x0101:
            java.io.FileNotFoundException r0 = new java.io.FileNotFoundException     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            r7.<init>()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            java.lang.String r9 = "Classloader cannot access tz-repository: "
            r7.append(r9)     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            r7.append(r12)     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            r0.<init>(r7)     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            throw r0     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
        L_0x0118:
            java.io.DataInputStream r9 = new java.io.DataInputStream     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            r9.<init>(r6)     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            checkMagicLabel(r9, r8)     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            java.lang.String r10 = r9.readUTF()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            int r12 = r9.readInt()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            r13.<init>(r12)     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            r14 = 0
        L_0x012e:
            if (r14 >= r12) goto L_0x0170
            java.lang.String r15 = r9.readUTF()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            int r7 = r9.readInt()     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            byte[] r11 = new byte[r7]     // Catch:{ IOException -> 0x01d8, all -> 0x01d5 }
            r16 = r2
            r17 = r3
            r2 = 0
        L_0x013f:
            int r3 = r7 - r2
            int r3 = r9.read(r11, r2, r3)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            int r2 = r2 + r3
            r3 = -1
            if (r2 == r3) goto L_0x0159
            if (r7 > r2) goto L_0x013f
            r13.add(r15)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            r4.put(r15, r11)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            int r14 = r14 + 1
            r2 = r16
            r3 = r17
            r7 = 0
            goto L_0x012e
        L_0x0159:
            java.io.EOFException r0 = new java.io.EOFException     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            r2.<init>()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            java.lang.String r3 = "Incomplete data: "
            r2.append(r3)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            r2.append(r15)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            throw r0     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
        L_0x0170:
            r16 = r2
            r17 = r3
            short r2 = r9.readShort()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            r3 = 0
        L_0x0179:
            if (r3 >= r2) goto L_0x018f
            java.lang.String r7 = r9.readUTF()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            short r11 = r9.readShort()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            java.lang.Object r11 = r13.get(r11)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            r5.put(r7, r11)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            int r3 = r3 + 1
            goto L_0x0179
        L_0x018f:
            if (r0 != 0) goto L_0x01c9
            short r0 = r9.readShort()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            r7 = 0
        L_0x0196:
            if (r7 >= r0) goto L_0x01b8
            short r2 = r9.readShort()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            byte r3 = r9.readByte()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            byte r11 = r9.readByte()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            byte r12 = r9.readByte()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            java.util.Map<net.time4j.base.GregorianDate, java.lang.Integer> r13 = r1.leapsecs     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            net.time4j.PlainDate r2 = net.time4j.PlainDate.of((int) r2, (int) r3, (int) r11)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            r13.put(r2, r3)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            int r7 = r7 + 1
            goto L_0x0196
        L_0x01b8:
            short r0 = r9.readShort()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            byte r2 = r9.readByte()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            byte r3 = r9.readByte()     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            net.time4j.PlainDate r3 = net.time4j.PlainDate.of((int) r0, (int) r2, (int) r3)     // Catch:{ IOException -> 0x01d3, all -> 0x01d5 }
            goto L_0x01cb
        L_0x01c9:
            r3 = r17
        L_0x01cb:
            if (r6 == 0) goto L_0x01d0
            r6.close()     // Catch:{ IOException -> 0x01d0 }
        L_0x01d0:
            r2 = r10
            r11 = 0
            goto L_0x020e
        L_0x01d3:
            r0 = move-exception
            goto L_0x01dd
        L_0x01d5:
            r0 = move-exception
            r11 = r6
            goto L_0x0225
        L_0x01d8:
            r0 = move-exception
            r16 = r2
        L_0x01db:
            r17 = r3
        L_0x01dd:
            r11 = r6
            goto L_0x01ea
        L_0x01df:
            r0 = move-exception
            r11 = 0
            goto L_0x0225
        L_0x01e2:
            r0 = move-exception
            r16 = r2
            r17 = r3
            r8 = r16
        L_0x01e9:
            r11 = 0
        L_0x01ea:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0224 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0224 }
            r3.<init>()     // Catch:{ all -> 0x0224 }
            java.lang.String r6 = "[ERROR] TZ-repository not available. => "
            r3.append(r6)     // Catch:{ all -> 0x0224 }
            java.lang.String r6 = r0.getMessage()     // Catch:{ all -> 0x0224 }
            r3.append(r6)     // Catch:{ all -> 0x0224 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0224 }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0224 }
            if (r11 == 0) goto L_0x0209
            r11.close()     // Catch:{ IOException -> 0x0209 }
        L_0x0209:
            r11 = r2
            r2 = r16
            r3 = r17
        L_0x020e:
            if (r11 != 0) goto L_0x0223
            r1.version = r2
            r1.location = r8
            java.util.Map r0 = java.util.Collections.unmodifiableMap(r4)
            r1.data = r0
            java.util.Map r0 = java.util.Collections.unmodifiableMap(r5)
            r1.aliases = r0
            r1.expires = r3
            return
        L_0x0223:
            throw r11
        L_0x0224:
            r0 = move-exception
        L_0x0225:
            if (r11 == 0) goto L_0x022a
            r11.close()     // Catch:{ IOException -> 0x022a }
        L_0x022a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.spi.TimezoneRepositoryProviderSPI.<init>():void");
    }

    public Set<String> getAvailableIDs() {
        return this.data.keySet();
    }

    public Map<String, String> getAliases() {
        return this.aliases;
    }

    public TransitionHistory load(String str) {
        try {
            byte[] bArr = this.data.get(str);
            if (bArr != null) {
                return (TransitionHistory) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getLocation() {
        return this.location;
    }

    public String getVersion() {
        return this.version;
    }

    public Map<GregorianDate, Integer> getLeapSecondTable() {
        return Collections.unmodifiableMap(this.leapsecs);
    }

    public boolean supportsNegativeLS() {
        return !this.leapsecs.isEmpty();
    }

    public PlainDate getDateOfEvent(int i, int i2, int i3) {
        return PlainDate.of(i, i2, i3);
    }

    public PlainDate getDateOfExpiration() {
        return this.expires;
    }

    public String toString() {
        return "TZ-REPOSITORY(" + this.version + ")";
    }

    private static void checkMagicLabel(DataInputStream dataInputStream, String str) throws IOException {
        byte readByte = dataInputStream.readByte();
        byte readByte2 = dataInputStream.readByte();
        byte readByte3 = dataInputStream.readByte();
        byte readByte4 = dataInputStream.readByte();
        byte readByte5 = dataInputStream.readByte();
        byte readByte6 = dataInputStream.readByte();
        if (readByte != 116 || readByte2 != 122 || readByte3 != 114 || readByte4 != 101 || readByte5 != 112 || readByte6 != 111) {
            throw new IOException("Invalid tz-repository: " + str);
        }
    }

    private static Class<?> getReference() {
        if (!Boolean.getBoolean("test.environment")) {
            return TimezoneRepositoryProviderSPI.class;
        }
        try {
            return Class.forName("net.time4j.tz.spi.RepositoryTest");
        } catch (ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }
}
