package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import com.google.android.gms.common.util.Clock;

public final class zzeb extends zzg {
    private final zzea zzjv = new zzea(this, getContext(), "google_app_measurement_local.db");
    private boolean zzjw;

    zzeb(zzfj zzfj) {
        super(zzfj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    public final void resetAnalyticsData() {
        zzm();
        zzo();
        try {
            int delete = getWritableDatabase().delete("messages", (String) null, (String[]) null) + 0;
            if (delete > 0) {
                zzab().zzgs().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error resetting local analytics data. error", e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ca, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00de, code lost:
        if (r8.inTransaction() != false) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e0, code lost:
        r8.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f3, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f8, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00fc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00fd, code lost:
        r10 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x010a, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x010f, code lost:
        r10.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x012e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x012e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:9:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00da A[SYNTHETIC, Splitter:B:55:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r18, byte[] r19) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r2 = "Error writing entry to local database"
            r17.zzm()
            r17.zzo()
            boolean r0 = r1.zzjw
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.String r5 = "type"
            r4.put(r5, r0)
            java.lang.String r0 = "entry"
            r5 = r19
            r4.put(r0, r5)
            r5 = 5
            r6 = 0
            r7 = 5
        L_0x0028:
            if (r6 >= r5) goto L_0x0140
            r8 = 0
            r9 = 1
            android.database.sqlite.SQLiteDatabase r10 = r17.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x0113, SQLiteDatabaseLockedException -> 0x0100, SQLiteException -> 0x00d5, all -> 0x00d0 }
            if (r10 != 0) goto L_0x0041
            r1.zzjw = r9     // Catch:{ SQLiteFullException -> 0x003e, SQLiteDatabaseLockedException -> 0x00ca, SQLiteException -> 0x003a }
            if (r10 == 0) goto L_0x0039
            r10.close()
        L_0x0039:
            return r3
        L_0x003a:
            r0 = move-exception
            r13 = r8
            goto L_0x00c8
        L_0x003e:
            r0 = move-exception
            goto L_0x0116
        L_0x0041:
            r10.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00cd, SQLiteDatabaseLockedException -> 0x00ca, SQLiteException -> 0x00c5, all -> 0x00c1 }
            r11 = 0
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r13 = r10.rawQuery(r0, r8)     // Catch:{ SQLiteFullException -> 0x00cd, SQLiteDatabaseLockedException -> 0x00ca, SQLiteException -> 0x00c5, all -> 0x00c1 }
            if (r13 == 0) goto L_0x0062
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            if (r0 == 0) goto L_0x0062
            long r11 = r13.getLong(r3)     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            goto L_0x0062
        L_0x0059:
            r0 = move-exception
            goto L_0x00fe
        L_0x005c:
            r0 = move-exception
            goto L_0x00c8
        L_0x005e:
            r0 = move-exception
            r8 = r13
            goto L_0x0116
        L_0x0062:
            java.lang.String r0 = "messages"
            r14 = 100000(0x186a0, double:4.94066E-319)
            int r16 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00a9
            com.google.android.gms.measurement.internal.zzef r16 = r17.zzab()     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzeh r5 = r16.zzgk()     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            java.lang.String r8 = "Data loss, local db full"
            r5.zzao(r8)     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            long r14 = r14 - r11
            r11 = 1
            long r14 = r14 + r11
            java.lang.String r5 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String[] r8 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            java.lang.String r11 = java.lang.Long.toString(r14)     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            r8[r3] = r11     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            int r5 = r10.delete(r0, r5, r8)     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            long r11 = (long) r5     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            int r5 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x00a9
            com.google.android.gms.measurement.internal.zzef r5 = r17.zzab()     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            java.lang.String r8 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            java.lang.Long r9 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            long r14 = r14 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            r5.zza(r8, r3, r9, r11)     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
        L_0x00a9:
            r3 = 0
            r10.insertOrThrow(r0, r3, r4)     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            r10.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            r10.endTransaction()     // Catch:{ SQLiteFullException -> 0x005e, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x005c, all -> 0x0059 }
            if (r13 == 0) goto L_0x00b8
            r13.close()
        L_0x00b8:
            if (r10 == 0) goto L_0x00bd
            r10.close()
        L_0x00bd:
            r2 = 1
            return r2
        L_0x00bf:
            r8 = r13
            goto L_0x0102
        L_0x00c1:
            r0 = move-exception
            r3 = r8
            goto L_0x0135
        L_0x00c5:
            r0 = move-exception
            r3 = r8
            r13 = r3
        L_0x00c8:
            r8 = r10
            goto L_0x00d8
        L_0x00ca:
            r3 = r8
            r8 = r3
            goto L_0x0102
        L_0x00cd:
            r0 = move-exception
            r3 = r8
            goto L_0x0116
        L_0x00d0:
            r0 = move-exception
            r3 = r8
            r10 = r8
            goto L_0x0135
        L_0x00d5:
            r0 = move-exception
            r3 = r8
            r13 = r8
        L_0x00d8:
            if (r8 == 0) goto L_0x00e3
            boolean r3 = r8.inTransaction()     // Catch:{ all -> 0x00fc }
            if (r3 == 0) goto L_0x00e3
            r8.endTransaction()     // Catch:{ all -> 0x00fc }
        L_0x00e3:
            com.google.android.gms.measurement.internal.zzef r3 = r17.zzab()     // Catch:{ all -> 0x00fc }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x00fc }
            r3.zza(r2, r0)     // Catch:{ all -> 0x00fc }
            r3 = 1
            r1.zzjw = r3     // Catch:{ all -> 0x00fc }
            if (r13 == 0) goto L_0x00f6
            r13.close()
        L_0x00f6:
            if (r8 == 0) goto L_0x012e
            r8.close()
            goto L_0x012e
        L_0x00fc:
            r0 = move-exception
            r10 = r8
        L_0x00fe:
            r8 = r13
            goto L_0x0135
        L_0x0100:
            r3 = r8
            r10 = r8
        L_0x0102:
            long r11 = (long) r7
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x0134 }
            int r7 = r7 + 20
            if (r8 == 0) goto L_0x010d
            r8.close()
        L_0x010d:
            if (r10 == 0) goto L_0x012e
            r10.close()
            goto L_0x012e
        L_0x0113:
            r0 = move-exception
            r3 = r8
            r10 = r8
        L_0x0116:
            com.google.android.gms.measurement.internal.zzef r3 = r17.zzab()     // Catch:{ all -> 0x0134 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x0134 }
            r3.zza(r2, r0)     // Catch:{ all -> 0x0134 }
            r3 = 1
            r1.zzjw = r3     // Catch:{ all -> 0x0134 }
            if (r8 == 0) goto L_0x0129
            r8.close()
        L_0x0129:
            if (r10 == 0) goto L_0x012e
            r10.close()
        L_0x012e:
            int r6 = r6 + 1
            r3 = 0
            r5 = 5
            goto L_0x0028
        L_0x0134:
            r0 = move-exception
        L_0x0135:
            if (r8 == 0) goto L_0x013a
            r8.close()
        L_0x013a:
            if (r10 == 0) goto L_0x013f
            r10.close()
        L_0x013f:
            throw r0
        L_0x0140:
            com.google.android.gms.measurement.internal.zzef r0 = r17.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zzao(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeb.zza(int, byte[]):boolean");
    }

    public final boolean zza(zzai zzai) {
        Parcel obtain = Parcel.obtain();
        zzai.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzab().zzgn().zzao("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzjn zzjn) {
        Parcel obtain = Parcel.obtain();
        zzjn.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzab().zzgn().zzao("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzc(zzq zzq) {
        zzz();
        byte[] zza = zzjs.zza((Parcelable) zzq);
        if (zza.length <= 131072) {
            return zza(2, zza);
        }
        zzab().zzgn().zzao("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:80|81|82|83) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:95|96|97|98) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:65|66|67|68|214) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x016b, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x016e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0190, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0191, code lost:
        r15 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0195, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0196, code lost:
        r15 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01d6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01d7, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01e0, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x01e7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01e8, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x01f2, code lost:
        r13 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x01fc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0203, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0204, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0209, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0217, code lost:
        if (r15.inTransaction() != false) goto L_0x0219;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0219, code lost:
        r15.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x022b, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0230, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x023e, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0243, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0259, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x025e, code lost:
        r15.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0265, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0266, code lost:
        r3 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0267, code lost:
        r13 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x026a, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x026f, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0088, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0089, code lost:
        r15 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008e, code lost:
        r15 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0092, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0093, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0097, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0098, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009d, code lost:
        r24 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ed, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        zzab().zzgk().zzao("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0100, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0103, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x011f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        zzab().zzgk().zzao("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0136, code lost:
        r11.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0139, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0153, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        zzab().zzgk().zzao("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        r11.recycle();
        r0 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x00ef */
    /* JADX WARNING: Missing exception handler attribute for start block: B:80:0x0121 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x0155 */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x01d6 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:51:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:134:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:51:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01e7 A[ExcHandler: all (th java.lang.Throwable), PHI: r24 
      PHI: (r24v3 android.database.sqlite.SQLiteDatabase) = (r24v5 android.database.sqlite.SQLiteDatabase), (r24v9 android.database.sqlite.SQLiteDatabase) binds: [B:48:0x00a5, B:35:0x0083] A[DONT_GENERATE, DONT_INLINE], Splitter:B:35:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), PHI: r24 
      PHI: (r24v1 android.database.sqlite.SQLiteDatabase) = (r24v5 android.database.sqlite.SQLiteDatabase), (r24v9 android.database.sqlite.SQLiteDatabase) binds: [B:48:0x00a5, B:35:0x0083] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:35:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01fc A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:152:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:12:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0213 A[SYNTHETIC, Splitter:B:164:0x0213] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0261 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0261 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0261 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzc(int r24) {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r2 = "Error reading entries from local database"
            r23.zzo()
            r23.zzm()
            boolean r0 = r1.zzjw
            r3 = 0
            if (r0 == 0) goto L_0x0010
            return r3
        L_0x0010:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r23.zzcg()
            if (r0 != 0) goto L_0x001c
            return r4
        L_0x001c:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x0020:
            if (r7 >= r5) goto L_0x0273
            r9 = 1
            android.database.sqlite.SQLiteDatabase r15 = r23.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x0247, SQLiteDatabaseLockedException -> 0x0234, SQLiteException -> 0x020e, all -> 0x020b }
            if (r15 != 0) goto L_0x0037
            r1.zzjw = r9     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x0031, all -> 0x01fc }
            if (r15 == 0) goto L_0x0030
            r15.close()
        L_0x0030:
            return r3
        L_0x0031:
            r0 = move-exception
            goto L_0x0201
        L_0x0034:
            r0 = move-exception
            goto L_0x0209
        L_0x0037:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0207, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x01ff, all -> 0x01fc }
            com.google.android.gms.measurement.internal.zzs r0 = r23.zzad()     // Catch:{ SQLiteFullException -> 0x0207, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x01ff, all -> 0x01fc }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzak.zzjd     // Catch:{ SQLiteFullException -> 0x0207, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x01ff, all -> 0x01fc }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean>) r10)     // Catch:{ SQLiteFullException -> 0x0207, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x01ff, all -> 0x01fc }
            r10 = 100
            java.lang.String r11 = "entry"
            java.lang.String r12 = "type"
            java.lang.String r13 = "rowid"
            r19 = -1
            if (r0 == 0) goto L_0x00a1
            long r16 = zza((android.database.sqlite.SQLiteDatabase) r15)     // Catch:{ SQLiteFullException -> 0x009c, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x0097, all -> 0x0092 }
            int r0 = (r16 > r19 ? 1 : (r16 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0063
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r14 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x0031, all -> 0x01fc }
            java.lang.String r16 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x0031, all -> 0x01fc }
            r14[r6] = r16     // Catch:{ SQLiteFullException -> 0x0034, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x0031, all -> 0x01fc }
            goto L_0x0065
        L_0x0063:
            r0 = r3
            r14 = r0
        L_0x0065:
            java.lang.String r16 = "messages"
            java.lang.String[] r12 = new java.lang.String[]{r13, r12, r11}     // Catch:{ SQLiteFullException -> 0x009c, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x0097, all -> 0x0092 }
            r17 = 0
            r18 = 0
            java.lang.String r21 = "rowid asc"
            java.lang.String r22 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x009c, SQLiteDatabaseLockedException -> 0x0203, SQLiteException -> 0x0097, all -> 0x0092 }
            r10 = r15
            r11 = r16
            r13 = r0
            r24 = r15
            r15 = r17
            r16 = r18
            r17 = r21
            r18 = r22
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x008d, SQLiteDatabaseLockedException -> 0x01f2, SQLiteException -> 0x0088, all -> 0x01e7 }
            goto L_0x00bb
        L_0x0088:
            r0 = move-exception
            r15 = r24
            goto L_0x0201
        L_0x008d:
            r0 = move-exception
            r15 = r24
            goto L_0x0209
        L_0x0092:
            r0 = move-exception
            r24 = r15
            goto L_0x01e8
        L_0x0097:
            r0 = move-exception
            r24 = r15
            goto L_0x0201
        L_0x009c:
            r0 = move-exception
            r24 = r15
            goto L_0x0209
        L_0x00a1:
            r24 = r15
            java.lang.String r0 = "messages"
            java.lang.String[] r12 = new java.lang.String[]{r13, r12, r11}     // Catch:{ SQLiteFullException -> 0x01f5, SQLiteDatabaseLockedException -> 0x01f2, SQLiteException -> 0x01ec, all -> 0x01e7 }
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r17 = "rowid asc"
            java.lang.String r18 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x01f5, SQLiteDatabaseLockedException -> 0x01f2, SQLiteException -> 0x01ec, all -> 0x01e7 }
            r10 = r24
            r11 = r0
            android.database.Cursor r0 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x01f5, SQLiteDatabaseLockedException -> 0x01f2, SQLiteException -> 0x01ec, all -> 0x01e7 }
        L_0x00bb:
            r10 = r0
        L_0x00bc:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteFullException -> 0x01e3, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x01dc, all -> 0x01d6 }
            if (r0 == 0) goto L_0x019a
            long r19 = r10.getLong(r6)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            int r0 = r10.getInt(r9)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            r11 = 2
            byte[] r12 = r10.getBlob(r11)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            if (r0 != 0) goto L_0x0104
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x00ef }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x00ef }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x00ef }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r0 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ ParseException -> 0x00ef }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x00ef }
            com.google.android.gms.measurement.internal.zzai r0 = (com.google.android.gms.measurement.internal.zzai) r0     // Catch:{ ParseException -> 0x00ef }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            if (r0 == 0) goto L_0x00bc
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            goto L_0x00bc
        L_0x00ed:
            r0 = move-exception
            goto L_0x0100
        L_0x00ef:
            com.google.android.gms.measurement.internal.zzef r0 = r23.zzab()     // Catch:{ all -> 0x00ed }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x00ed }
            java.lang.String r12 = "Failed to load event from local database"
            r0.zzao(r12)     // Catch:{ all -> 0x00ed }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            goto L_0x00bc
        L_0x0100:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
        L_0x0104:
            java.lang.String r13 = "Failed to load user property from local database"
            if (r0 != r9) goto L_0x013a
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x0121 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x0121 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x0121 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzjn> r0 = com.google.android.gms.measurement.internal.zzjn.CREATOR     // Catch:{ ParseException -> 0x0121 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x0121 }
            com.google.android.gms.measurement.internal.zzjn r0 = (com.google.android.gms.measurement.internal.zzjn) r0     // Catch:{ ParseException -> 0x0121 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            goto L_0x0130
        L_0x011f:
            r0 = move-exception
            goto L_0x0136
        L_0x0121:
            com.google.android.gms.measurement.internal.zzef r0 = r23.zzab()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x011f }
            r0.zzao(r13)     // Catch:{ all -> 0x011f }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            r0 = r3
        L_0x0130:
            if (r0 == 0) goto L_0x00bc
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            goto L_0x00bc
        L_0x0136:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
        L_0x013a:
            if (r0 != r11) goto L_0x016f
            android.os.Parcel r11 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            int r0 = r12.length     // Catch:{ ParseException -> 0x0155 }
            r11.unmarshall(r12, r6, r0)     // Catch:{ ParseException -> 0x0155 }
            r11.setDataPosition(r6)     // Catch:{ ParseException -> 0x0155 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzq> r0 = com.google.android.gms.measurement.internal.zzq.CREATOR     // Catch:{ ParseException -> 0x0155 }
            java.lang.Object r0 = r0.createFromParcel(r11)     // Catch:{ ParseException -> 0x0155 }
            com.google.android.gms.measurement.internal.zzq r0 = (com.google.android.gms.measurement.internal.zzq) r0     // Catch:{ ParseException -> 0x0155 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            goto L_0x0164
        L_0x0153:
            r0 = move-exception
            goto L_0x016b
        L_0x0155:
            com.google.android.gms.measurement.internal.zzef r0 = r23.zzab()     // Catch:{ all -> 0x0153 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x0153 }
            r0.zzao(r13)     // Catch:{ all -> 0x0153 }
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            r0 = r3
        L_0x0164:
            if (r0 == 0) goto L_0x00bc
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            goto L_0x00bc
        L_0x016b:
            r11.recycle()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            throw r0     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
        L_0x016f:
            r11 = 3
            if (r0 != r11) goto L_0x0181
            com.google.android.gms.measurement.internal.zzef r0 = r23.zzab()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            java.lang.String r11 = "Skipping app launch break"
            r0.zzao(r11)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            goto L_0x00bc
        L_0x0181:
            com.google.android.gms.measurement.internal.zzef r0 = r23.zzab()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            java.lang.String r11 = "Unknown record type in local database"
            r0.zzao(r11)     // Catch:{ SQLiteFullException -> 0x0195, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x0190, all -> 0x01d6 }
            goto L_0x00bc
        L_0x0190:
            r0 = move-exception
            r15 = r24
            goto L_0x0211
        L_0x0195:
            r0 = move-exception
            r15 = r24
            goto L_0x024a
        L_0x019a:
            java.lang.String r0 = "messages"
            java.lang.String r11 = "rowid <= ?"
            java.lang.String[] r12 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x01e3, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x01dc, all -> 0x01d6 }
            java.lang.String r13 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x01e3, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x01dc, all -> 0x01d6 }
            r12[r6] = r13     // Catch:{ SQLiteFullException -> 0x01e3, SQLiteDatabaseLockedException -> 0x01e0, SQLiteException -> 0x01dc, all -> 0x01d6 }
            r13 = r24
            int r0 = r13.delete(r0, r11, r12)     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x01d2, all -> 0x01d0 }
            int r11 = r4.size()     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x01d2, all -> 0x01d0 }
            if (r0 >= r11) goto L_0x01bf
            com.google.android.gms.measurement.internal.zzef r0 = r23.zzab()     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x01d2, all -> 0x01d0 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x01d2, all -> 0x01d0 }
            java.lang.String r11 = "Fewer entries removed from local database than expected"
            r0.zzao(r11)     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x01d2, all -> 0x01d0 }
        L_0x01bf:
            r13.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x01d2, all -> 0x01d0 }
            r13.endTransaction()     // Catch:{ SQLiteFullException -> 0x01d4, SQLiteDatabaseLockedException -> 0x0205, SQLiteException -> 0x01d2, all -> 0x01d0 }
            if (r10 == 0) goto L_0x01ca
            r10.close()
        L_0x01ca:
            if (r13 == 0) goto L_0x01cf
            r13.close()
        L_0x01cf:
            return r4
        L_0x01d0:
            r0 = move-exception
            goto L_0x01d9
        L_0x01d2:
            r0 = move-exception
            goto L_0x01f0
        L_0x01d4:
            r0 = move-exception
            goto L_0x01f9
        L_0x01d6:
            r0 = move-exception
            r13 = r24
        L_0x01d9:
            r3 = r10
            goto L_0x0268
        L_0x01dc:
            r0 = move-exception
            r13 = r24
            goto L_0x01f0
        L_0x01e0:
            r13 = r24
            goto L_0x0205
        L_0x01e3:
            r0 = move-exception
            r13 = r24
            goto L_0x01f9
        L_0x01e7:
            r0 = move-exception
        L_0x01e8:
            r13 = r24
            goto L_0x0268
        L_0x01ec:
            r0 = move-exception
            r13 = r24
            r10 = r3
        L_0x01f0:
            r15 = r13
            goto L_0x0211
        L_0x01f2:
            r13 = r24
            goto L_0x0204
        L_0x01f5:
            r0 = move-exception
            r13 = r24
            r10 = r3
        L_0x01f9:
            r15 = r13
            goto L_0x024a
        L_0x01fc:
            r0 = move-exception
            goto L_0x0267
        L_0x01ff:
            r0 = move-exception
            r13 = r15
        L_0x0201:
            r10 = r3
            goto L_0x0211
        L_0x0203:
            r13 = r15
        L_0x0204:
            r10 = r3
        L_0x0205:
            r15 = r13
            goto L_0x0236
        L_0x0207:
            r0 = move-exception
            r13 = r15
        L_0x0209:
            r10 = r3
            goto L_0x024a
        L_0x020b:
            r0 = move-exception
            r13 = r3
            goto L_0x0268
        L_0x020e:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x0211:
            if (r15 == 0) goto L_0x021c
            boolean r11 = r15.inTransaction()     // Catch:{ all -> 0x0265 }
            if (r11 == 0) goto L_0x021c
            r15.endTransaction()     // Catch:{ all -> 0x0265 }
        L_0x021c:
            com.google.android.gms.measurement.internal.zzef r11 = r23.zzab()     // Catch:{ all -> 0x0265 }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzgk()     // Catch:{ all -> 0x0265 }
            r11.zza(r2, r0)     // Catch:{ all -> 0x0265 }
            r1.zzjw = r9     // Catch:{ all -> 0x0265 }
            if (r10 == 0) goto L_0x022e
            r10.close()
        L_0x022e:
            if (r15 == 0) goto L_0x0261
            r15.close()
            goto L_0x0261
        L_0x0234:
            r10 = r3
            r15 = r10
        L_0x0236:
            long r11 = (long) r8
            android.os.SystemClock.sleep(r11)     // Catch:{ all -> 0x0265 }
            int r8 = r8 + 20
            if (r10 == 0) goto L_0x0241
            r10.close()
        L_0x0241:
            if (r15 == 0) goto L_0x0261
            r15.close()
            goto L_0x0261
        L_0x0247:
            r0 = move-exception
            r10 = r3
            r15 = r10
        L_0x024a:
            com.google.android.gms.measurement.internal.zzef r11 = r23.zzab()     // Catch:{ all -> 0x0265 }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzgk()     // Catch:{ all -> 0x0265 }
            r11.zza(r2, r0)     // Catch:{ all -> 0x0265 }
            r1.zzjw = r9     // Catch:{ all -> 0x0265 }
            if (r10 == 0) goto L_0x025c
            r10.close()
        L_0x025c:
            if (r15 == 0) goto L_0x0261
            r15.close()
        L_0x0261:
            int r7 = r7 + 1
            goto L_0x0020
        L_0x0265:
            r0 = move-exception
            r3 = r10
        L_0x0267:
            r13 = r15
        L_0x0268:
            if (r3 == 0) goto L_0x026d
            r3.close()
        L_0x026d:
            if (r13 == 0) goto L_0x0272
            r13.close()
        L_0x0272:
            throw r0
        L_0x0273:
            com.google.android.gms.measurement.internal.zzef r0 = r23.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zzao(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeb.zzc(int):java.util.List");
    }

    public final boolean zzgh() {
        return zza(3, new byte[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0089, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzgi() {
        /*
            r11 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r11.zzo()
            r11.zzm()
            boolean r1 = r11.zzjw
            r2 = 0
            if (r1 == 0) goto L_0x000e
            return r2
        L_0x000e:
            boolean r1 = r11.zzcg()
            if (r1 != 0) goto L_0x0015
            return r2
        L_0x0015:
            r1 = 5
            r3 = 0
            r4 = 5
        L_0x0018:
            if (r3 >= r1) goto L_0x0092
            r5 = 0
            r6 = 1
            android.database.sqlite.SQLiteDatabase r5 = r11.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 != 0) goto L_0x002a
            r11.zzjw = r6     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 == 0) goto L_0x0029
            r5.close()
        L_0x0029:
            return r2
        L_0x002a:
            r5.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            java.lang.String[] r9 = new java.lang.String[r6]     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r10 = 3
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r9[r2] = r10     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.delete(r7, r8, r9)     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            r5.endTransaction()     // Catch:{ SQLiteFullException -> 0x0076, SQLiteDatabaseLockedException -> 0x006a, SQLiteException -> 0x004b }
            if (r5 == 0) goto L_0x0048
            r5.close()
        L_0x0048:
            return r6
        L_0x0049:
            r0 = move-exception
            goto L_0x008c
        L_0x004b:
            r7 = move-exception
            if (r5 == 0) goto L_0x0057
            boolean r8 = r5.inTransaction()     // Catch:{ all -> 0x0049 }
            if (r8 == 0) goto L_0x0057
            r5.endTransaction()     // Catch:{ all -> 0x0049 }
        L_0x0057:
            com.google.android.gms.measurement.internal.zzef r8 = r11.zzab()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgk()     // Catch:{ all -> 0x0049 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0049 }
            r11.zzjw = r6     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0089
            r5.close()
            goto L_0x0089
        L_0x006a:
            long r6 = (long) r4
            android.os.SystemClock.sleep(r6)     // Catch:{ all -> 0x0049 }
            int r4 = r4 + 20
            if (r5 == 0) goto L_0x0089
            r5.close()
            goto L_0x0089
        L_0x0076:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzef r8 = r11.zzab()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgk()     // Catch:{ all -> 0x0049 }
            r8.zza(r0, r7)     // Catch:{ all -> 0x0049 }
            r11.zzjw = r6     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0089
            r5.close()
        L_0x0089:
            int r3 = r3 + 1
            goto L_0x0018
        L_0x008c:
            if (r5 == 0) goto L_0x0091
            r5.close()
        L_0x0091:
            throw r0
        L_0x0092:
            com.google.android.gms.measurement.internal.zzef r0 = r11.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.zzao(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeb.zzgi():boolean");
    }

    private static long zza(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, (String) null, (String) null, "rowid desc", ThreeDSecureRequest.VERSION_1);
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (this.zzjw) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzjv.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzjw = true;
        return null;
    }

    private final boolean zzcg() {
        return getContext().getDatabasePath("google_app_measurement_local.db").exists();
    }

    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    public final /* bridge */ /* synthetic */ zza zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgp zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzdy zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzhv zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzhq zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzeb zzu() {
        return super.zzu();
    }

    public final /* bridge */ /* synthetic */ zziw zzv() {
        return super.zzv();
    }

    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    public final /* bridge */ /* synthetic */ zzeo zzac() {
        return super.zzac();
    }

    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
