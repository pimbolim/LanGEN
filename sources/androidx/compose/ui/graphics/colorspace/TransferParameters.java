package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "gamma", "", "a", "b", "c", "d", "e", "f", "(DDDDDDD)V", "getA", "()D", "getB", "getC", "getD", "getE", "getF", "getGamma", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransferParameters.kt */
public final class TransferParameters {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double gamma;

    public static /* synthetic */ TransferParameters copy$default(TransferParameters transferParameters, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, Object obj) {
        TransferParameters transferParameters2 = transferParameters;
        return transferParameters.copy((i & 1) != 0 ? transferParameters2.gamma : d2, (i & 2) != 0 ? transferParameters2.a : d3, (i & 4) != 0 ? transferParameters2.b : d4, (i & 8) != 0 ? transferParameters2.c : d5, (i & 16) != 0 ? transferParameters2.d : d6, (i & 32) != 0 ? transferParameters2.e : d7, (i & 64) != 0 ? transferParameters2.f : d8);
    }

    public final double component1() {
        return this.gamma;
    }

    public final double component2() {
        return this.a;
    }

    public final double component3() {
        return this.b;
    }

    public final double component4() {
        return this.c;
    }

    public final double component5() {
        return this.d;
    }

    public final double component6() {
        return this.e;
    }

    public final double component7() {
        return this.f;
    }

    public final TransferParameters copy(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return new TransferParameters(d2, d3, d4, d5, d6, d7, d8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferParameters)) {
            return false;
        }
        TransferParameters transferParameters = (TransferParameters) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.gamma), (Object) Double.valueOf(transferParameters.gamma)) && Intrinsics.areEqual((Object) Double.valueOf(this.a), (Object) Double.valueOf(transferParameters.a)) && Intrinsics.areEqual((Object) Double.valueOf(this.b), (Object) Double.valueOf(transferParameters.b)) && Intrinsics.areEqual((Object) Double.valueOf(this.c), (Object) Double.valueOf(transferParameters.c)) && Intrinsics.areEqual((Object) Double.valueOf(this.d), (Object) Double.valueOf(transferParameters.d)) && Intrinsics.areEqual((Object) Double.valueOf(this.e), (Object) Double.valueOf(transferParameters.e)) && Intrinsics.areEqual((Object) Double.valueOf(this.f), (Object) Double.valueOf(transferParameters.f));
    }

    public int hashCode() {
        return (((((((((((Double.doubleToLongBits(this.gamma) * 31) + Double.doubleToLongBits(this.a)) * 31) + Double.doubleToLongBits(this.b)) * 31) + Double.doubleToLongBits(this.c)) * 31) + Double.doubleToLongBits(this.d)) * 31) + Double.doubleToLongBits(this.e)) * 31) + Double.doubleToLongBits(this.f);
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ')';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
        if ((r2 == 0.0d) == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0093, code lost:
        if ((r2 == 0.0d) != false) goto L_0x0095;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TransferParameters(double r2, double r4, double r6, double r8, double r10, double r12, double r14) {
        /*
            r1 = this;
            r1.<init>()
            r1.gamma = r2
            r1.a = r4
            r1.b = r6
            r1.c = r8
            r1.d = r10
            r1.e = r12
            r1.f = r14
            boolean r0 = java.lang.Double.isNaN(r4)
            if (r0 != 0) goto L_0x00d2
            boolean r6 = java.lang.Double.isNaN(r6)
            if (r6 != 0) goto L_0x00d2
            boolean r6 = java.lang.Double.isNaN(r8)
            if (r6 != 0) goto L_0x00d2
            boolean r6 = java.lang.Double.isNaN(r10)
            if (r6 != 0) goto L_0x00d2
            boolean r6 = java.lang.Double.isNaN(r12)
            if (r6 != 0) goto L_0x00d2
            boolean r6 = java.lang.Double.isNaN(r14)
            if (r6 != 0) goto L_0x00d2
            boolean r6 = java.lang.Double.isNaN(r2)
            if (r6 != 0) goto L_0x00d2
            r6 = 0
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 < 0) goto L_0x00c2
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 > 0) goto L_0x00c2
            r14 = 1
            r15 = 0
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x004f
            r0 = 1
            goto L_0x0050
        L_0x004f:
            r0 = 0
        L_0x0050:
            if (r0 == 0) goto L_0x006d
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0058
            r0 = 1
            goto L_0x0059
        L_0x0058:
            r0 = 0
        L_0x0059:
            if (r0 != 0) goto L_0x0065
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0061
            r0 = 1
            goto L_0x0062
        L_0x0061:
            r0 = 0
        L_0x0062:
            if (r0 != 0) goto L_0x0065
            goto L_0x006d
        L_0x0065:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Parameter a or g is zero, the transfer function is constant"
            r2.<init>(r3)
            throw r2
        L_0x006d:
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r0 < 0) goto L_0x0083
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x0077
            r10 = 1
            goto L_0x0078
        L_0x0077:
            r10 = 0
        L_0x0078:
            if (r10 != 0) goto L_0x007b
            goto L_0x0083
        L_0x007b:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Parameter c is zero, the transfer function is constant"
            r2.<init>(r3)
            throw r2
        L_0x0083:
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x0089
            r10 = 1
            goto L_0x008a
        L_0x0089:
            r10 = 0
        L_0x008a:
            if (r10 != 0) goto L_0x0095
            int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x0092
            r10 = 1
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x009d
        L_0x0095:
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r14 = 0
        L_0x009b:
            if (r14 != 0) goto L_0x00ba
        L_0x009d:
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 < 0) goto L_0x00b2
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x00aa
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x00aa
            return
        L_0x00aa:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "The transfer function must be positive or increasing"
            r2.<init>(r3)
            throw r2
        L_0x00b2:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "The transfer function must be increasing"
            r2.<init>(r3)
            throw r2
        L_0x00ba:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Parameter a or g is zero, and c is zero, the transfer function is constant"
            r2.<init>(r3)
            throw r2
        L_0x00c2:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.Double r3 = java.lang.Double.valueOf(r10)
            java.lang.String r4 = "Parameter d must be in the range [0..1], was "
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r3)
            r2.<init>(r3)
            throw r2
        L_0x00d2:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Parameters cannot be NaN"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.TransferParameters.<init>(double, double, double, double, double, double, double):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransferParameters(double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d2, d3, d4, d5, d6, (i & 32) != 0 ? 0.0d : d7, (i & 64) != 0 ? 0.0d : d8);
    }

    public final double getGamma() {
        return this.gamma;
    }

    public final double getA() {
        return this.a;
    }

    public final double getB() {
        return this.b;
    }

    public final double getC() {
        return this.c;
    }

    public final double getD() {
        return this.d;
    }

    public final double getE() {
        return this.e;
    }

    public final double getF() {
        return this.f;
    }
}
