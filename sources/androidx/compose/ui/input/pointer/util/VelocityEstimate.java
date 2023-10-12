package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\u0011\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\rJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u0019\u0010\u0015\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\rJ>\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u000e\u0010\rR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "", "pixelsPerSecond", "Landroidx/compose/ui/geometry/Offset;", "confidence", "", "durationMillis", "", "offset", "(JFJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConfidence", "()F", "getDurationMillis", "()J", "getOffset-F1C5BW0", "J", "getPixelsPerSecond-F1C5BW0", "component1", "component1-F1C5BW0", "component2", "component3", "component4", "component4-F1C5BW0", "copy", "copy-PZAlG8E", "(JFJJ)Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VelocityTracker.kt */
final class VelocityEstimate {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final VelocityEstimate None = new VelocityEstimate(Offset.Companion.m1369getZeroF1C5BW0(), 1.0f, 0, Offset.Companion.m1369getZeroF1C5BW0(), (DefaultConstructorMarker) null);
    private final float confidence;
    private final long durationMillis;
    private final long offset;
    private final long pixelsPerSecond;

    public /* synthetic */ VelocityEstimate(long j, float f, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, f, j2, j3);
    }

    /* renamed from: copy-PZAlG8E$default  reason: not valid java name */
    public static /* synthetic */ VelocityEstimate m3089copyPZAlG8E$default(VelocityEstimate velocityEstimate, long j, float f, long j2, long j3, int i, Object obj) {
        VelocityEstimate velocityEstimate2 = velocityEstimate;
        return velocityEstimate.m3092copyPZAlG8E((i & 1) != 0 ? velocityEstimate2.pixelsPerSecond : j, (i & 2) != 0 ? velocityEstimate2.confidence : f, (i & 4) != 0 ? velocityEstimate2.durationMillis : j2, (i & 8) != 0 ? velocityEstimate2.offset : j3);
    }

    /* renamed from: component1-F1C5BW0  reason: not valid java name */
    public final long m3090component1F1C5BW0() {
        return this.pixelsPerSecond;
    }

    public final float component2() {
        return this.confidence;
    }

    public final long component3() {
        return this.durationMillis;
    }

    /* renamed from: component4-F1C5BW0  reason: not valid java name */
    public final long m3091component4F1C5BW0() {
        return this.offset;
    }

    /* renamed from: copy-PZAlG8E  reason: not valid java name */
    public final VelocityEstimate m3092copyPZAlG8E(long j, float f, long j2, long j3) {
        return new VelocityEstimate(j, f, j2, j3, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VelocityEstimate)) {
            return false;
        }
        VelocityEstimate velocityEstimate = (VelocityEstimate) obj;
        return Offset.m1350equalsimpl0(this.pixelsPerSecond, velocityEstimate.pixelsPerSecond) && Intrinsics.areEqual((Object) Float.valueOf(this.confidence), (Object) Float.valueOf(velocityEstimate.confidence)) && this.durationMillis == velocityEstimate.durationMillis && Offset.m1350equalsimpl0(this.offset, velocityEstimate.offset);
    }

    public int hashCode() {
        return (((((Offset.m1355hashCodeimpl(this.pixelsPerSecond) * 31) + Float.floatToIntBits(this.confidence)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.durationMillis)) * 31) + Offset.m1355hashCodeimpl(this.offset);
    }

    public String toString() {
        return "VelocityEstimate(pixelsPerSecond=" + Offset.m1361toStringimpl(this.pixelsPerSecond) + ", confidence=" + this.confidence + ", durationMillis=" + this.durationMillis + ", offset=" + Offset.m1361toStringimpl(this.offset) + ')';
    }

    private VelocityEstimate(long j, float f, long j2, long j3) {
        this.pixelsPerSecond = j;
        this.confidence = f;
        this.durationMillis = j2;
        this.offset = j3;
    }

    /* renamed from: getPixelsPerSecond-F1C5BW0  reason: not valid java name */
    public final long m3094getPixelsPerSecondF1C5BW0() {
        return this.pixelsPerSecond;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final long getDurationMillis() {
        return this.durationMillis;
    }

    /* renamed from: getOffset-F1C5BW0  reason: not valid java name */
    public final long m3093getOffsetF1C5BW0() {
        return this.offset;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/input/pointer/util/VelocityEstimate$Companion;", "", "()V", "None", "Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "getNone", "()Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VelocityTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VelocityEstimate getNone() {
            return VelocityEstimate.None;
        }
    }
}
