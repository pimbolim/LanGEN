package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

public enum zzet {
    DOUBLE(0, zzev.SCALAR, zzfk.DOUBLE),
    FLOAT(1, zzev.SCALAR, zzfk.FLOAT),
    INT64(2, zzev.SCALAR, zzfk.LONG),
    UINT64(3, zzev.SCALAR, zzfk.LONG),
    INT32(4, zzev.SCALAR, zzfk.INT),
    FIXED64(5, zzev.SCALAR, zzfk.LONG),
    FIXED32(6, zzev.SCALAR, zzfk.INT),
    BOOL(7, zzev.SCALAR, zzfk.BOOLEAN),
    STRING(8, zzev.SCALAR, zzfk.STRING),
    MESSAGE(9, zzev.SCALAR, zzfk.MESSAGE),
    BYTES(10, zzev.SCALAR, zzfk.BYTE_STRING),
    UINT32(11, zzev.SCALAR, zzfk.INT),
    ENUM(12, zzev.SCALAR, zzfk.ENUM),
    SFIXED32(13, zzev.SCALAR, zzfk.INT),
    SFIXED64(14, zzev.SCALAR, zzfk.LONG),
    SINT32(15, zzev.SCALAR, zzfk.INT),
    SINT64(16, zzev.SCALAR, zzfk.LONG),
    GROUP(17, zzev.SCALAR, zzfk.MESSAGE),
    DOUBLE_LIST(18, zzev.VECTOR, zzfk.DOUBLE),
    FLOAT_LIST(19, zzev.VECTOR, zzfk.FLOAT),
    INT64_LIST(20, zzev.VECTOR, zzfk.LONG),
    UINT64_LIST(21, zzev.VECTOR, zzfk.LONG),
    INT32_LIST(22, zzev.VECTOR, zzfk.INT),
    FIXED64_LIST(23, zzev.VECTOR, zzfk.LONG),
    FIXED32_LIST(24, zzev.VECTOR, zzfk.INT),
    BOOL_LIST(25, zzev.VECTOR, zzfk.BOOLEAN),
    STRING_LIST(26, zzev.VECTOR, zzfk.STRING),
    MESSAGE_LIST(27, zzev.VECTOR, zzfk.MESSAGE),
    BYTES_LIST(28, zzev.VECTOR, zzfk.BYTE_STRING),
    UINT32_LIST(29, zzev.VECTOR, zzfk.INT),
    ENUM_LIST(30, zzev.VECTOR, zzfk.ENUM),
    SFIXED32_LIST(31, zzev.VECTOR, zzfk.INT),
    SFIXED64_LIST(32, zzev.VECTOR, zzfk.LONG),
    SINT32_LIST(33, zzev.VECTOR, zzfk.INT),
    SINT64_LIST(34, zzev.VECTOR, zzfk.LONG),
    DOUBLE_LIST_PACKED(35, zzev.PACKED_VECTOR, zzfk.DOUBLE),
    FLOAT_LIST_PACKED(36, zzev.PACKED_VECTOR, zzfk.FLOAT),
    INT64_LIST_PACKED(37, zzev.PACKED_VECTOR, zzfk.LONG),
    UINT64_LIST_PACKED(38, zzev.PACKED_VECTOR, zzfk.LONG),
    INT32_LIST_PACKED(39, zzev.PACKED_VECTOR, zzfk.INT),
    FIXED64_LIST_PACKED(40, zzev.PACKED_VECTOR, zzfk.LONG),
    FIXED32_LIST_PACKED(41, zzev.PACKED_VECTOR, zzfk.INT),
    BOOL_LIST_PACKED(42, zzev.PACKED_VECTOR, zzfk.BOOLEAN),
    UINT32_LIST_PACKED(43, zzev.PACKED_VECTOR, zzfk.INT),
    ENUM_LIST_PACKED(44, zzev.PACKED_VECTOR, zzfk.ENUM),
    SFIXED32_LIST_PACKED(45, zzev.PACKED_VECTOR, zzfk.INT),
    SFIXED64_LIST_PACKED(46, zzev.PACKED_VECTOR, zzfk.LONG),
    SINT32_LIST_PACKED(47, zzev.PACKED_VECTOR, zzfk.INT),
    SINT64_LIST_PACKED(48, zzev.PACKED_VECTOR, zzfk.LONG),
    GROUP_LIST(49, zzev.VECTOR, zzfk.MESSAGE),
    MAP(50, zzev.MAP, zzfk.VOID);
    
    private static final zzet[] zzahj = null;
    private static final Type[] zzahk = null;
    private final int id;
    private final zzfk zzahf;
    private final zzev zzahg;
    private final Class<?> zzahh;
    private final boolean zzahi;

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r5 = com.google.android.gms.internal.measurement.zzes.zzaff[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzet(int r4, com.google.android.gms.internal.measurement.zzev r5, com.google.android.gms.internal.measurement.zzfk r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r1.id = r4
            r1.zzahg = r5
            r1.zzahf = r6
            int[] r2 = com.google.android.gms.internal.measurement.zzes.zzafe
            int r3 = r5.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0022
            if (r2 == r3) goto L_0x001b
            r2 = 0
            r1.zzahh = r2
            goto L_0x0028
        L_0x001b:
            java.lang.Class r2 = r6.zzvd()
            r1.zzahh = r2
            goto L_0x0028
        L_0x0022:
            java.lang.Class r2 = r6.zzvd()
            r1.zzahh = r2
        L_0x0028:
            r2 = 0
            com.google.android.gms.internal.measurement.zzev r0 = com.google.android.gms.internal.measurement.zzev.SCALAR
            if (r5 != r0) goto L_0x003d
            int[] r5 = com.google.android.gms.internal.measurement.zzes.zzaff
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x003d
            if (r5 == r3) goto L_0x003d
            r3 = 3
            if (r5 == r3) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            r1.zzahi = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzet.<init>(java.lang.String, int, int, com.google.android.gms.internal.measurement.zzev, com.google.android.gms.internal.measurement.zzfk):void");
    }

    public final int id() {
        return this.id;
    }

    static {
        int i;
        zzahk = new Type[0];
        zzet[] values = values();
        zzahj = new zzet[values.length];
        for (zzet zzet : values) {
            zzahj[zzet.id] = zzet;
        }
    }
}
