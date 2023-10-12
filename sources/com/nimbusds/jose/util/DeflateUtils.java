package com.nimbusds.jose.util;

public class DeflateUtils {
    private static final boolean NOWRAP = true;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] compress(byte[] r5) throws java.io.IOException {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.util.zip.Deflater r2 = new java.util.zip.Deflater     // Catch:{ all -> 0x0026 }
            r3 = 8
            r4 = 1
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0026 }
            java.util.zip.DeflaterOutputStream r3 = new java.util.zip.DeflaterOutputStream     // Catch:{ all -> 0x0024 }
            r3.<init>(r0, r2)     // Catch:{ all -> 0x0024 }
            r3.write(r5)     // Catch:{ all -> 0x0021 }
            r3.close()
            r2.end()
            byte[] r5 = r0.toByteArray()
            return r5
        L_0x0021:
            r5 = move-exception
            r1 = r3
            goto L_0x0028
        L_0x0024:
            r5 = move-exception
            goto L_0x0028
        L_0x0026:
            r5 = move-exception
            r2 = r1
        L_0x0028:
            if (r1 == 0) goto L_0x002d
            r1.close()
        L_0x002d:
            if (r2 == 0) goto L_0x0032
            r2.end()
        L_0x0032:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.util.DeflateUtils.compress(byte[]):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decompress(byte[] r5) throws java.io.IOException {
        /*
            r0 = 0
            java.util.zip.Inflater r1 = new java.util.zip.Inflater     // Catch:{ all -> 0x0035 }
            r2 = 1
            r1.<init>(r2)     // Catch:{ all -> 0x0035 }
            java.util.zip.InflaterInputStream r2 = new java.util.zip.InflaterInputStream     // Catch:{ all -> 0x0033 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0033 }
            r3.<init>(r5)     // Catch:{ all -> 0x0033 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0033 }
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0030 }
            r5.<init>()     // Catch:{ all -> 0x0030 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0030 }
        L_0x001a:
            int r3 = r2.read(r0)     // Catch:{ all -> 0x0030 }
            if (r3 <= 0) goto L_0x0025
            r4 = 0
            r5.write(r0, r4, r3)     // Catch:{ all -> 0x0030 }
            goto L_0x001a
        L_0x0025:
            byte[] r5 = r5.toByteArray()     // Catch:{ all -> 0x0030 }
            r2.close()
            r1.end()
            return r5
        L_0x0030:
            r5 = move-exception
            r0 = r2
            goto L_0x0037
        L_0x0033:
            r5 = move-exception
            goto L_0x0037
        L_0x0035:
            r5 = move-exception
            r1 = r0
        L_0x0037:
            if (r0 == 0) goto L_0x003c
            r0.close()
        L_0x003c:
            if (r1 == 0) goto L_0x0041
            r1.end()
        L_0x0041:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nimbusds.jose.util.DeflateUtils.decompress(byte[]):byte[]");
    }

    private DeflateUtils() {
    }
}
