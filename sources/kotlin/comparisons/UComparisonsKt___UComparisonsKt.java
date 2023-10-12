package kotlin.comparisons;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\"\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a&\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\"\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a&\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005\u001a+\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b'\u0010\b\u001a&\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010\f\u001a\"\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u000f\u001a+\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0011\u001a&\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u0014\u001a\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010\u0017\u001a+\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0019\u001a&\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010\u001c\u001a\"\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001f\u001a+\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\bø\u0001\u0000¢\u0006\u0004\b0\u0010!\u001a&\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u0010$\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", "other", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
/* compiled from: _UComparisons.kt */
class UComparisonsKt___UComparisonsKt {
    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static final int m5873maxOfJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) >= 0 ? i : i2;
    }

    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static final long m5881maxOfeb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) >= 0 ? j : j2;
    }

    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m5874maxOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare((int) b & UByte.MAX_VALUE, (int) b2 & UByte.MAX_VALUE) >= 0 ? b : b2;
    }

    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m5872maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare((int) s & UShort.MAX_VALUE, (int) 65535 & s2) >= 0 ? s : s2;
    }

    /* renamed from: maxOf-WZ9TVnA  reason: not valid java name */
    private static final int m5878maxOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m5873maxOfJ1ME1BU(i, UComparisonsKt.m5873maxOfJ1ME1BU(i2, i3));
    }

    /* renamed from: maxOf-sambcqE  reason: not valid java name */
    private static final long m5882maxOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m5881maxOfeb3DHEI(j, UComparisonsKt.m5881maxOfeb3DHEI(j2, j3));
    }

    /* renamed from: maxOf-b33U2AM  reason: not valid java name */
    private static final byte m5880maxOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m5874maxOfKr8caGY(b, UComparisonsKt.m5874maxOfKr8caGY(b2, b3));
    }

    /* renamed from: maxOf-VKSA0NQ  reason: not valid java name */
    private static final short m5877maxOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m5872maxOf5PvTz6A(s, UComparisonsKt.m5872maxOf5PvTz6A(s2, s3));
    }

    /* renamed from: maxOf-Md2H83M  reason: not valid java name */
    public static final int m5875maxOfMd2H83M(int i, int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        Iterator<UInt> r2 = UIntArray.m4866iteratorimpl(iArr);
        while (r2.hasNext()) {
            i = UComparisonsKt.m5873maxOfJ1ME1BU(i, r2.next().m4854unboximpl());
        }
        return i;
    }

    /* renamed from: maxOf-R03FKyM  reason: not valid java name */
    public static final long m5876maxOfR03FKyM(long j, long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        Iterator<ULong> r4 = ULongArray.m4944iteratorimpl(jArr);
        while (r4.hasNext()) {
            j = UComparisonsKt.m5881maxOfeb3DHEI(j, r4.next().m4932unboximpl());
        }
        return j;
    }

    /* renamed from: maxOf-Wr6uiD8  reason: not valid java name */
    public static final byte m5879maxOfWr6uiD8(byte b, byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        Iterator<UByte> r2 = UByteArray.m4788iteratorimpl(bArr);
        while (r2.hasNext()) {
            b = UComparisonsKt.m5874maxOfKr8caGY(b, r2.next().m4776unboximpl());
        }
        return b;
    }

    /* renamed from: maxOf-t1qELG4  reason: not valid java name */
    public static final short m5883maxOft1qELG4(short s, short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        Iterator<UShort> r2 = UShortArray.m5048iteratorimpl(sArr);
        while (r2.hasNext()) {
            s = UComparisonsKt.m5872maxOf5PvTz6A(s, r2.next().m5036unboximpl());
        }
        return s;
    }

    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static final int m5885minOfJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) <= 0 ? i : i2;
    }

    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static final long m5893minOfeb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) <= 0 ? j : j2;
    }

    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m5886minOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare((int) b & UByte.MAX_VALUE, (int) b2 & UByte.MAX_VALUE) <= 0 ? b : b2;
    }

    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m5884minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare((int) s & UShort.MAX_VALUE, (int) 65535 & s2) <= 0 ? s : s2;
    }

    /* renamed from: minOf-WZ9TVnA  reason: not valid java name */
    private static final int m5890minOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m5885minOfJ1ME1BU(i, UComparisonsKt.m5885minOfJ1ME1BU(i2, i3));
    }

    /* renamed from: minOf-sambcqE  reason: not valid java name */
    private static final long m5894minOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m5893minOfeb3DHEI(j, UComparisonsKt.m5893minOfeb3DHEI(j2, j3));
    }

    /* renamed from: minOf-b33U2AM  reason: not valid java name */
    private static final byte m5892minOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m5886minOfKr8caGY(b, UComparisonsKt.m5886minOfKr8caGY(b2, b3));
    }

    /* renamed from: minOf-VKSA0NQ  reason: not valid java name */
    private static final short m5889minOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m5884minOf5PvTz6A(s, UComparisonsKt.m5884minOf5PvTz6A(s2, s3));
    }

    /* renamed from: minOf-Md2H83M  reason: not valid java name */
    public static final int m5887minOfMd2H83M(int i, int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        Iterator<UInt> r2 = UIntArray.m4866iteratorimpl(iArr);
        while (r2.hasNext()) {
            i = UComparisonsKt.m5885minOfJ1ME1BU(i, r2.next().m4854unboximpl());
        }
        return i;
    }

    /* renamed from: minOf-R03FKyM  reason: not valid java name */
    public static final long m5888minOfR03FKyM(long j, long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        Iterator<ULong> r4 = ULongArray.m4944iteratorimpl(jArr);
        while (r4.hasNext()) {
            j = UComparisonsKt.m5893minOfeb3DHEI(j, r4.next().m4932unboximpl());
        }
        return j;
    }

    /* renamed from: minOf-Wr6uiD8  reason: not valid java name */
    public static final byte m5891minOfWr6uiD8(byte b, byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        Iterator<UByte> r2 = UByteArray.m4788iteratorimpl(bArr);
        while (r2.hasNext()) {
            b = UComparisonsKt.m5886minOfKr8caGY(b, r2.next().m4776unboximpl());
        }
        return b;
    }

    /* renamed from: minOf-t1qELG4  reason: not valid java name */
    public static final short m5895minOft1qELG4(short s, short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        Iterator<UShort> r2 = UShortArray.m5048iteratorimpl(sArr);
        while (r2.hasNext()) {
            s = UComparisonsKt.m5884minOf5PvTz6A(s, r2.next().m5036unboximpl());
        }
        return s;
    }
}
