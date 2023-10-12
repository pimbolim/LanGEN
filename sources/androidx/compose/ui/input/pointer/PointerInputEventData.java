package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\\\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\"\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0018J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u0019\u0010%\u001a\u00020\u0007HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0018J\u0019\u0010'\u001a\u00020\u0007HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0018J\t\u0010)\u001a\u00020\nHÆ\u0003J\u0019\u0010*\u001a\u00020\fHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b+\u0010\u001fJ\t\u0010,\u001a\u00020\nHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u0019\u0010.\u001a\u00020\u0007HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0018Jv\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0007HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J\u0013\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u000208HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u001c\u0010\b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u001c\u0010\u0011\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018R\u001c\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00069"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEventData;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptime", "", "positionOnScreen", "Landroidx/compose/ui/geometry/Offset;", "position", "down", "", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "issuesEnterExit", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "scrollDelta", "(JJJJZIZLjava/util/List;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDown", "()Z", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "J", "getIssuesEnterExit", "getPosition-F1C5BW0", "getPositionOnScreen-F1C5BW0", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptime", "component1", "component1-J3iCeTQ", "component2", "component3", "component3-F1C5BW0", "component4", "component4-F1C5BW0", "component5", "component6", "component6-T8wyACA", "component7", "component8", "component9", "component9-F1C5BW0", "copy", "copy-JzxSYW4", "(JJJJZIZLjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputEventData;", "equals", "other", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InternalPointerInput.kt */
public final class PointerInputEventData {
    private final boolean down;
    private final List<HistoricalChange> historical;
    private final long id;
    private final boolean issuesEnterExit;
    private final long position;
    private final long positionOnScreen;
    private final long scrollDelta;
    private final int type;
    private final long uptime;

    public /* synthetic */ PointerInputEventData(long j, long j2, long j3, long j4, boolean z, int i, boolean z2, List list, long j5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, z, i, z2, list, j5);
    }

    /* renamed from: copy-JzxSYW4$default  reason: not valid java name */
    public static /* synthetic */ PointerInputEventData m2984copyJzxSYW4$default(PointerInputEventData pointerInputEventData, long j, long j2, long j3, long j4, boolean z, int i, boolean z2, List list, long j5, int i2, Object obj) {
        PointerInputEventData pointerInputEventData2 = pointerInputEventData;
        int i3 = i2;
        return pointerInputEventData.m2990copyJzxSYW4((i3 & 1) != 0 ? pointerInputEventData2.id : j, (i3 & 2) != 0 ? pointerInputEventData2.uptime : j2, (i3 & 4) != 0 ? pointerInputEventData2.positionOnScreen : j3, (i3 & 8) != 0 ? pointerInputEventData2.position : j4, (i3 & 16) != 0 ? pointerInputEventData2.down : z, (i3 & 32) != 0 ? pointerInputEventData2.type : i, (i3 & 64) != 0 ? pointerInputEventData2.issuesEnterExit : z2, (i3 & 128) != 0 ? pointerInputEventData2.historical : list, (i3 & 256) != 0 ? pointerInputEventData2.scrollDelta : j5);
    }

    /* renamed from: component1-J3iCeTQ  reason: not valid java name */
    public final long m2985component1J3iCeTQ() {
        return this.id;
    }

    public final long component2() {
        return this.uptime;
    }

    /* renamed from: component3-F1C5BW0  reason: not valid java name */
    public final long m2986component3F1C5BW0() {
        return this.positionOnScreen;
    }

    /* renamed from: component4-F1C5BW0  reason: not valid java name */
    public final long m2987component4F1C5BW0() {
        return this.position;
    }

    public final boolean component5() {
        return this.down;
    }

    /* renamed from: component6-T8wyACA  reason: not valid java name */
    public final int m2988component6T8wyACA() {
        return this.type;
    }

    public final boolean component7() {
        return this.issuesEnterExit;
    }

    public final List<HistoricalChange> component8() {
        return this.historical;
    }

    /* renamed from: component9-F1C5BW0  reason: not valid java name */
    public final long m2989component9F1C5BW0() {
        return this.scrollDelta;
    }

    /* renamed from: copy-JzxSYW4  reason: not valid java name */
    public final PointerInputEventData m2990copyJzxSYW4(long j, long j2, long j3, long j4, boolean z, int i, boolean z2, List<HistoricalChange> list, long j5) {
        List<HistoricalChange> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "historical");
        return new PointerInputEventData(j, j2, j3, j4, z, i, z2, list2, j5, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointerInputEventData)) {
            return false;
        }
        PointerInputEventData pointerInputEventData = (PointerInputEventData) obj;
        return PointerId.m2966equalsimpl0(this.id, pointerInputEventData.id) && this.uptime == pointerInputEventData.uptime && Offset.m1350equalsimpl0(this.positionOnScreen, pointerInputEventData.positionOnScreen) && Offset.m1350equalsimpl0(this.position, pointerInputEventData.position) && this.down == pointerInputEventData.down && PointerType.m3037equalsimpl0(this.type, pointerInputEventData.type) && this.issuesEnterExit == pointerInputEventData.issuesEnterExit && Intrinsics.areEqual((Object) this.historical, (Object) pointerInputEventData.historical) && Offset.m1350equalsimpl0(this.scrollDelta, pointerInputEventData.scrollDelta);
    }

    public int hashCode() {
        int r0 = ((((((PointerId.m2967hashCodeimpl(this.id) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.uptime)) * 31) + Offset.m1355hashCodeimpl(this.positionOnScreen)) * 31) + Offset.m1355hashCodeimpl(this.position)) * 31;
        boolean z = this.down;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int r02 = (((r0 + (z ? 1 : 0)) * 31) + PointerType.m3038hashCodeimpl(this.type)) * 31;
        boolean z3 = this.issuesEnterExit;
        if (!z3) {
            z2 = z3;
        }
        return ((((r02 + (z2 ? 1 : 0)) * 31) + this.historical.hashCode()) * 31) + Offset.m1355hashCodeimpl(this.scrollDelta);
    }

    public String toString() {
        return "PointerInputEventData(id=" + PointerId.m2968toStringimpl(this.id) + ", uptime=" + this.uptime + ", positionOnScreen=" + Offset.m1361toStringimpl(this.positionOnScreen) + ", position=" + Offset.m1361toStringimpl(this.position) + ", down=" + this.down + ", type=" + PointerType.m3039toStringimpl(this.type) + ", issuesEnterExit=" + this.issuesEnterExit + ", historical=" + this.historical + ", scrollDelta=" + Offset.m1361toStringimpl(this.scrollDelta) + ')';
    }

    private PointerInputEventData(long j, long j2, long j3, long j4, boolean z, int i, boolean z2, List<HistoricalChange> list, long j5) {
        this.id = j;
        this.uptime = j2;
        this.positionOnScreen = j3;
        this.position = j4;
        this.down = z;
        this.type = i;
        this.issuesEnterExit = z2;
        this.historical = list;
        this.scrollDelta = j5;
    }

    /* renamed from: getId-J3iCeTQ  reason: not valid java name */
    public final long m2991getIdJ3iCeTQ() {
        return this.id;
    }

    public final long getUptime() {
        return this.uptime;
    }

    /* renamed from: getPositionOnScreen-F1C5BW0  reason: not valid java name */
    public final long m2993getPositionOnScreenF1C5BW0() {
        return this.positionOnScreen;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m2992getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getDown() {
        return this.down;
    }

    /* renamed from: getType-T8wyACA  reason: not valid java name */
    public final int m2995getTypeT8wyACA() {
        return this.type;
    }

    public final boolean getIssuesEnterExit() {
        return this.issuesEnterExit;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PointerInputEventData(long r19, long r21, long r23, long r25, boolean r27, int r28, boolean r29, java.util.List r30, long r31, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r18 = this;
            r0 = r33
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r13 = 0
            goto L_0x000b
        L_0x0009:
            r13 = r29
        L_0x000b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0018
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            r14 = r1
            goto L_0x001a
        L_0x0018:
            r14 = r30
        L_0x001a:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0026
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m1369getZeroF1C5BW0()
            r15 = r0
            goto L_0x0028
        L_0x0026:
            r15 = r31
        L_0x0028:
            r17 = 0
            r2 = r18
            r3 = r19
            r5 = r21
            r7 = r23
            r9 = r25
            r11 = r27
            r12 = r28
            r2.<init>(r3, r5, r7, r9, r11, r12, r13, r14, r15, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputEventData.<init>(long, long, long, long, boolean, int, boolean, java.util.List, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<HistoricalChange> getHistorical() {
        return this.historical;
    }

    /* renamed from: getScrollDelta-F1C5BW0  reason: not valid java name */
    public final long m2994getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }
}
