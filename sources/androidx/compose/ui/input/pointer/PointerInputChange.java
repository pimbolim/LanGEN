package androidx.compose.ui.input.pointer;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bh\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015BR\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u00100\u001a\u000201H\u0007Jm\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u00072\b\b\u0002\u00105\u001a\u00020\t2\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J}\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u00072\b\b\u0002\u00105\u001a\u00020\t2\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00052\b\b\u0002\u00104\u001a\u00020\u00072\b\b\u0002\u00105\u001a\u00020\t2\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\b\u0010=\u001a\u00020>H\u0016R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\u00020\u0007X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128GX\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\t8GX\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001d\u001a\u0004\b\"\u0010$R\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b%\u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u001c\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b'\u0010!R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R#\u0010\u0014\u001a\u00020\u00078GX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010!R\u001c\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "previousUptimeMillis", "previousPosition", "previousPressed", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "scrollDelta", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILjava/util/List;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "_historical", "_scrollDelta", "J", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "getHistorical$annotations", "()V", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "isConsumed", "isConsumed$annotations", "()Z", "getPosition-F1C5BW0", "getPressed", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "getPreviousUptimeMillis", "getScrollDelta-F1C5BW0$annotations", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptimeMillis", "consume", "", "copy", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-96DQgws", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILjava/util/List;)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-cunQLAA$ui_release", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "toString", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PointerEvent.kt */
public final class PointerInputChange {
    private List<HistoricalChange> _historical;
    private long _scrollDelta;
    private final ConsumedData consumed;
    private final long id;
    private final long position;
    private final boolean pressed;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, List list, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, i, (List<HistoricalChange>) list, j6);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, i);
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getHistorical$annotations() {
    }

    @ExperimentalComposeUiApi
    /* renamed from: getScrollDelta-F1C5BW0$annotations  reason: not valid java name */
    public static /* synthetic */ void m2973getScrollDeltaF1C5BW0$annotations() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void isConsumed$annotations() {
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i) {
        this.id = j;
        this.uptimeMillis = j2;
        this.position = j3;
        this.pressed = z;
        this.previousUptimeMillis = j4;
        this.previousPosition = j5;
        this.previousPressed = z2;
        this.consumed = consumedData;
        this.type = i;
        this._scrollDelta = Offset.Companion.m1369getZeroF1C5BW0();
    }

    /* renamed from: getId-J3iCeTQ  reason: not valid java name */
    public final long m2977getIdJ3iCeTQ() {
        return this.id;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m2978getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    /* renamed from: getPreviousPosition-F1C5BW0  reason: not valid java name */
    public final long m2979getPreviousPositionF1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public final ConsumedData getConsumed() {
        return this.consumed;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, (i2 & 256) != 0 ? PointerType.Companion.m3044getTouchT8wyACA() : i, (DefaultConstructorMarker) null);
    }

    /* renamed from: getType-T8wyACA  reason: not valid java name */
    public final int m2981getTypeT8wyACA() {
        return this.type;
    }

    @ExperimentalComposeUiApi
    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> list = this._historical;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @ExperimentalComposeUiApi
    /* renamed from: getScrollDelta-F1C5BW0  reason: not valid java name */
    public final long m2980getScrollDeltaF1C5BW0() {
        return this._scrollDelta;
    }

    @ExperimentalComposeUiApi
    public final boolean isConsumed() {
        return this.consumed.getDownChange() || this.consumed.getPositionChange();
    }

    @ExperimentalComposeUiApi
    public final void consume() {
        this.consumed.setDownChange(true);
        this.consumed.setPositionChange(true);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, List<HistoricalChange> list, long j6) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, i, (DefaultConstructorMarker) null);
        this._historical = list;
        this._scrollDelta = j6;
    }

    /* renamed from: copy-Ezr-O64$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m2971copyEzrO64$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, int i2, Object obj) {
        long j6;
        int i3;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i4 = i2;
        long r2 = (i4 & 1) != 0 ? pointerInputChange.m2977getIdJ3iCeTQ() : j;
        long j7 = (i4 & 2) != 0 ? pointerInputChange2.uptimeMillis : j2;
        long r6 = (i4 & 4) != 0 ? pointerInputChange.m2978getPositionF1C5BW0() : j3;
        boolean z3 = (i4 & 8) != 0 ? pointerInputChange2.pressed : z;
        long j8 = (i4 & 16) != 0 ? pointerInputChange2.previousUptimeMillis : j4;
        if ((i4 & 32) != 0) {
            j6 = pointerInputChange.m2979getPreviousPositionF1C5BW0();
        } else {
            j6 = j5;
        }
        boolean z4 = (i4 & 64) != 0 ? pointerInputChange2.previousPressed : z2;
        ConsumedData consumedData2 = (i4 & 128) != 0 ? pointerInputChange2.consumed : consumedData;
        if ((i4 & 256) != 0) {
            i3 = pointerInputChange.m2981getTypeT8wyACA();
        } else {
            i3 = i;
        }
        return pointerInputChange.m2975copyEzrO64(r2, j7, r6, z3, j8, j6, z4, consumedData2, i3);
    }

    /* renamed from: copy-Ezr-O64  reason: not valid java name */
    public final PointerInputChange m2975copyEzrO64(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i) {
        Intrinsics.checkNotNullParameter(consumedData, "consumed");
        return new PointerInputChange(j, j2, j3, z, j4, j5, z2, consumedData, i, getHistorical(), m2980getScrollDeltaF1C5BW0(), (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-96DQgws$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m2970copy96DQgws$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, List list, int i2, Object obj) {
        long j6;
        int i3;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i4 = i2;
        long r2 = (i4 & 1) != 0 ? pointerInputChange.m2977getIdJ3iCeTQ() : j;
        long j7 = (i4 & 2) != 0 ? pointerInputChange2.uptimeMillis : j2;
        long r6 = (i4 & 4) != 0 ? pointerInputChange.m2978getPositionF1C5BW0() : j3;
        boolean z3 = (i4 & 8) != 0 ? pointerInputChange2.pressed : z;
        long j8 = (i4 & 16) != 0 ? pointerInputChange2.previousUptimeMillis : j4;
        if ((i4 & 32) != 0) {
            j6 = pointerInputChange.m2979getPreviousPositionF1C5BW0();
        } else {
            j6 = j5;
        }
        boolean z4 = (i4 & 64) != 0 ? pointerInputChange2.previousPressed : z2;
        ConsumedData consumedData2 = (i4 & 128) != 0 ? pointerInputChange2.consumed : consumedData;
        if ((i4 & 256) != 0) {
            i3 = pointerInputChange.m2981getTypeT8wyACA();
        } else {
            i3 = i;
        }
        return pointerInputChange.m2974copy96DQgws(r2, j7, r6, z3, j8, j6, z4, consumedData2, i3, list);
    }

    @ExperimentalComposeUiApi
    /* renamed from: copy-96DQgws  reason: not valid java name */
    public final PointerInputChange m2974copy96DQgws(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, List<HistoricalChange> list) {
        long j6 = j;
        Intrinsics.checkNotNullParameter(consumedData, "consumed");
        Intrinsics.checkNotNullParameter(list, "historical");
        return new PointerInputChange(j, j2, j3, z, j4, j5, z2, consumedData, i, list, m2980getScrollDeltaF1C5BW0(), (DefaultConstructorMarker) null);
    }

    /* renamed from: copy-cunQLAA$ui_release$default  reason: not valid java name */
    public static /* synthetic */ PointerInputChange m2972copycunQLAA$ui_release$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, List list, long j6, int i2, Object obj) {
        long j7;
        List<HistoricalChange> list2;
        PointerInputChange pointerInputChange2 = pointerInputChange;
        int i3 = i2;
        long r2 = (i3 & 1) != 0 ? pointerInputChange.m2977getIdJ3iCeTQ() : j;
        long j8 = (i3 & 2) != 0 ? pointerInputChange2.uptimeMillis : j2;
        long r6 = (i3 & 4) != 0 ? pointerInputChange.m2978getPositionF1C5BW0() : j3;
        boolean z3 = (i3 & 8) != 0 ? pointerInputChange2.pressed : z;
        long j9 = (i3 & 16) != 0 ? pointerInputChange2.previousUptimeMillis : j4;
        if ((i3 & 32) != 0) {
            j7 = pointerInputChange.m2979getPreviousPositionF1C5BW0();
        } else {
            j7 = j5;
        }
        boolean z4 = (i3 & 64) != 0 ? pointerInputChange2.previousPressed : z2;
        ConsumedData consumedData2 = (i3 & 128) != 0 ? pointerInputChange2.consumed : consumedData;
        int r15 = (i3 & 256) != 0 ? pointerInputChange.m2981getTypeT8wyACA() : i;
        if ((i3 & 512) != 0) {
            list2 = pointerInputChange.getHistorical();
        } else {
            list2 = list;
        }
        return pointerInputChange.m2976copycunQLAA$ui_release(r2, j8, r6, z3, j9, j7, z4, consumedData2, r15, list2, j6);
    }

    /* renamed from: copy-cunQLAA$ui_release  reason: not valid java name */
    public final PointerInputChange m2976copycunQLAA$ui_release(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, List<HistoricalChange> list, long j6) {
        long j7 = j;
        Intrinsics.checkNotNullParameter(consumedData, "consumed");
        Intrinsics.checkNotNullParameter(list, "historical");
        return new PointerInputChange(j, j2, j3, z, j4, j5, z2, consumedData, i, list, j6, (DefaultConstructorMarker) null);
    }

    public String toString() {
        return "PointerInputChange(id=" + PointerId.m2968toStringimpl(m2977getIdJ3iCeTQ()) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + Offset.m1361toStringimpl(m2978getPositionF1C5BW0()) + ", pressed=" + this.pressed + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + Offset.m1361toStringimpl(m2979getPreviousPositionF1C5BW0()) + ", previousPressed=" + this.previousPressed + ", consumed=" + this.consumed + ", type=" + PointerType.m3039toStringimpl(m2981getTypeT8wyACA()) + ", historical=" + getHistorical() + ",scrollDelta=" + Offset.m1361toStringimpl(m2980getScrollDeltaF1C5BW0()) + ')';
    }
}
