package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J@\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!2\u0019\u0010\"\u001a\u0015\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001e\u0018\u00010#¢\u0006\u0002\b%H$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J\b\u0010(\u001a\u00020\u001eH\u0002R\u001d\u0010\u0003\u001a\u00020\u00048DX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@DX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bR/\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u0017@DX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\u0013R\u001e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "()V", "apparentToRealOffset", "Landroidx/compose/ui/unit/IntOffset;", "getApparentToRealOffset-nOcc-ac", "()J", "<set-?>", "", "height", "getHeight", "()I", "measuredHeight", "getMeasuredHeight", "value", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "getMeasuredSize-YbymL2g", "setMeasuredSize-ozmzZPI", "(J)V", "J", "measuredWidth", "getMeasuredWidth", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "width", "getWidth", "placeAt", "", "position", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "recalculateWidthAndHeight", "PlacementScope", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Placeable.kt */
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    private int height;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private int width;

    /* access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public abstract void m3175placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1);

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public int getMeasuredWidth() {
        return IntSize.m4019getWidthimpl(m3173getMeasuredSizeYbymL2g());
    }

    public int getMeasuredHeight() {
        return IntSize.m4018getHeightimpl(m3173getMeasuredSizeYbymL2g());
    }

    /* access modifiers changed from: protected */
    /* renamed from: getMeasuredSize-YbymL2g  reason: not valid java name */
    public final long m3173getMeasuredSizeYbymL2g() {
        return this.measuredSize;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setMeasuredSize-ozmzZPI  reason: not valid java name */
    public final void m3176setMeasuredSizeozmzZPI(long j) {
        if (!IntSize.m4017equalsimpl0(this.measuredSize, j)) {
            this.measuredSize = j;
            recalculateWidthAndHeight();
        }
    }

    private final void recalculateWidthAndHeight() {
        this.width = RangesKt.coerceIn(IntSize.m4019getWidthimpl(m3173getMeasuredSizeYbymL2g()), Constraints.m3805getMinWidthimpl(m3174getMeasurementConstraintsmsEJaDk()), Constraints.m3803getMaxWidthimpl(m3174getMeasurementConstraintsmsEJaDk()));
        this.height = RangesKt.coerceIn(IntSize.m4018getHeightimpl(m3173getMeasuredSizeYbymL2g()), Constraints.m3804getMinHeightimpl(m3174getMeasurementConstraintsmsEJaDk()), Constraints.m3802getMaxHeightimpl(m3174getMeasurementConstraintsmsEJaDk()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: getMeasurementConstraints-msEJaDk  reason: not valid java name */
    public final long m3174getMeasurementConstraintsmsEJaDk() {
        return this.measurementConstraints;
    }

    /* access modifiers changed from: protected */
    /* renamed from: setMeasurementConstraints-BRTryo0  reason: not valid java name */
    public final void m3177setMeasurementConstraintsBRTryo0(long j) {
        if (!Constraints.m3796equalsimpl0(this.measurementConstraints, j)) {
            this.measurementConstraints = j;
            recalculateWidthAndHeight();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: getApparentToRealOffset-nOcc-ac  reason: not valid java name */
    public final long m3172getApparentToRealOffsetnOccac() {
        return IntOffsetKt.IntOffset((this.width - IntSize.m4019getWidthimpl(m3173getMeasuredSizeYbymL2g())) / 2, (this.height - IntSize.m4018getHeightimpl(m3173getMeasuredSizeYbymL2g())) / 2);
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011JJ\u0010\u0016\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u001b\b\b\u0010\u0017\u001a\u0015\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018¢\u0006\u0002\b\u001aH\bø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJJ\u0010\u001d\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u001b\b\b\u0010\u0017\u001a\u0015\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018¢\u0006\u0002\b\u001aH\bø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001cJ)\u0010\u001f\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0013J$\u0010\u001f\u001a\u00020\f*\u00020\r2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011JD\u0010!\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u001cJ?\u0010!\u001a\u00020\f*\u00020\r2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001aJD\u0010#\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001aø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u001cJ?\u0010#\u001a\u00020\f*\u00020\r2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001aR\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006&"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "()V", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentWidth", "", "getParentWidth", "()I", "place", "", "Landroidx/compose/ui/layout/Placeable;", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "place-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "x", "y", "placeApparentToRealOffset", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeApparentToRealOffset-aW-9-wM$ui_release", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "placeAutoMirrored", "placeAutoMirrored-aW-9-wM$ui_release", "placeRelative", "placeRelative-70tqf50", "placeRelativeWithLayer", "placeRelativeWithLayer-aW-9-wM", "placeWithLayer", "placeWithLayer-aW-9-wM", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Placeable.kt */
    public static abstract class PlacementScope {
        public static final int $stable = 0;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static LayoutDirection parentLayoutDirection = LayoutDirection.Ltr;
        /* access modifiers changed from: private */
        public static int parentWidth;

        /* access modifiers changed from: protected */
        public abstract LayoutDirection getParentLayoutDirection();

        /* access modifiers changed from: protected */
        public abstract int getParentWidth();

        /* renamed from: placeRelative-70tqf50$default  reason: not valid java name */
        public static /* synthetic */ void m3179placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                placementScope.m3185placeRelative70tqf50(placeable, j, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                placementScope.placeRelative(placeable, i, i2, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
        }

        public final void placeRelative(Placeable placeable, int i, int i2, float f) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long r0 = placeable.m3172getApparentToRealOffsetnOccac();
                placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(IntOffset) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(IntOffset) + IntOffset.m3978getYimpl(r0)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - IntSize.m4019getWidthimpl(placeable.m3173getMeasuredSizeYbymL2g())) - IntOffset.m3977getXimpl(IntOffset), IntOffset.m3978getYimpl(IntOffset));
            long r02 = placeable.m3172getApparentToRealOffsetnOccac();
            placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(IntOffset2) + IntOffset.m3977getXimpl(r02), IntOffset.m3978getYimpl(IntOffset2) + IntOffset.m3978getYimpl(r02)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    f = 0.0f;
                }
                placementScope.place(placeable, i, i2, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
        }

        public final void place(Placeable placeable, int i, int i2, float f) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            long r0 = placeable.m3172getApparentToRealOffsetnOccac();
            placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(IntOffset) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(IntOffset) + IntOffset.m3978getYimpl(r0)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: place-70tqf50$default  reason: not valid java name */
        public static /* synthetic */ void m3178place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j, float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    f = 0.0f;
                }
                placementScope.m3182place70tqf50(placeable, j, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m3180placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj == null) {
                float f2 = (i & 2) != 0 ? 0.0f : f;
                if ((i & 4) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.m3186placeRelativeWithLayeraW9wM(placeable, j, f2, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                float f2 = (i3 & 4) != 0 ? 0.0f : f;
                if ((i3 & 8) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.placeRelativeWithLayer(placeable, i, i2, f2, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i2, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long r0 = placeable.m3172getApparentToRealOffsetnOccac();
                placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(IntOffset) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(IntOffset) + IntOffset.m3978getYimpl(r0)), f, function1);
                return;
            }
            long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - IntSize.m4019getWidthimpl(placeable.m3173getMeasuredSizeYbymL2g())) - IntOffset.m3977getXimpl(IntOffset), IntOffset.m3978getYimpl(IntOffset));
            long r02 = placeable.m3172getApparentToRealOffsetnOccac();
            placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(IntOffset2) + IntOffset.m3977getXimpl(r02), IntOffset.m3978getYimpl(IntOffset2) + IntOffset.m3978getYimpl(r02)), f, function1);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i2, float f, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                float f2 = (i3 & 4) != 0 ? 0.0f : f;
                if ((i3 & 8) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.placeWithLayer(placeable, i, i2, f2, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }

        public final void placeWithLayer(Placeable placeable, int i, int i2, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long IntOffset = IntOffsetKt.IntOffset(i, i2);
            long r0 = placeable.m3172getApparentToRealOffsetnOccac();
            placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(IntOffset) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(IntOffset) + IntOffset.m3978getYimpl(r0)), f, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default  reason: not valid java name */
        public static /* synthetic */ void m3181placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j, float f, Function1 function1, int i, Object obj) {
            if (obj == null) {
                float f2 = (i & 2) != 0 ? 0.0f : f;
                if ((i & 4) != 0) {
                    function1 = PlaceableKt.DefaultLayerBlock;
                }
                placementScope.m3187placeWithLayeraW9wM(placeable, j, f2, function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }

        /* renamed from: placeAutoMirrored-aW-9-wM$ui_release  reason: not valid java name */
        public final void m3184placeAutoMirroredaW9wM$ui_release(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$receiver");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long r0 = placeable.m3172getApparentToRealOffsetnOccac();
                placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(j) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(j) + IntOffset.m3978getYimpl(r0)), f, function1);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - IntSize.m4019getWidthimpl(placeable.m3173getMeasuredSizeYbymL2g())) - IntOffset.m3977getXimpl(j), IntOffset.m3978getYimpl(j));
            long r02 = placeable.m3172getApparentToRealOffsetnOccac();
            placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(IntOffset) + IntOffset.m3977getXimpl(r02), IntOffset.m3978getYimpl(IntOffset) + IntOffset.m3978getYimpl(r02)), f, function1);
        }

        /* renamed from: placeApparentToRealOffset-aW-9-wM$ui_release  reason: not valid java name */
        public final void m3183placeApparentToRealOffsetaW9wM$ui_release(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$receiver");
            long r0 = placeable.m3172getApparentToRealOffsetnOccac();
            placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(j) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(j) + IntOffset.m3978getYimpl(r0)), f, function1);
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0019\b\u0004\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0010H\bø\u0001\u0000R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope$Companion;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "()V", "<set-?>", "Landroidx/compose/ui/unit/LayoutDirection;", "parentLayoutDirection", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "", "parentWidth", "getParentWidth", "()I", "executeWithRtlMirroringValues", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Placeable.kt */
        public static final class Companion extends PlacementScope {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* access modifiers changed from: protected */
            public LayoutDirection getParentLayoutDirection() {
                return PlacementScope.parentLayoutDirection;
            }

            /* access modifiers changed from: protected */
            public int getParentWidth() {
                return PlacementScope.parentWidth;
            }

            public final void executeWithRtlMirroringValues(int i, LayoutDirection layoutDirection, Function1<? super PlacementScope, Unit> function1) {
                Intrinsics.checkNotNullParameter(layoutDirection, "parentLayoutDirection");
                Intrinsics.checkNotNullParameter(function1, "block");
                int access$getParentWidth = PlacementScope.Companion.getParentWidth();
                LayoutDirection access$getParentLayoutDirection = PlacementScope.Companion.getParentLayoutDirection();
                Companion companion = PlacementScope.Companion;
                PlacementScope.parentWidth = i;
                Companion companion2 = PlacementScope.Companion;
                PlacementScope.parentLayoutDirection = layoutDirection;
                function1.invoke(this);
                Companion companion3 = PlacementScope.Companion;
                PlacementScope.parentWidth = access$getParentWidth;
                Companion companion4 = PlacementScope.Companion;
                PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
            }
        }

        /* renamed from: placeRelative-70tqf50  reason: not valid java name */
        public final void m3185placeRelative70tqf50(Placeable placeable, long j, float f) {
            Intrinsics.checkNotNullParameter(placeable, "$receiver");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long r0 = placeable.m3172getApparentToRealOffsetnOccac();
                placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(j) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(j) + IntOffset.m3978getYimpl(r0)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - IntSize.m4019getWidthimpl(placeable.m3173getMeasuredSizeYbymL2g())) - IntOffset.m3977getXimpl(j), IntOffset.m3978getYimpl(j));
            long r02 = placeable.m3172getApparentToRealOffsetnOccac();
            placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(IntOffset) + IntOffset.m3977getXimpl(r02), IntOffset.m3978getYimpl(IntOffset) + IntOffset.m3978getYimpl(r02)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: place-70tqf50  reason: not valid java name */
        public final void m3182place70tqf50(Placeable placeable, long j, float f) {
            Intrinsics.checkNotNullParameter(placeable, "$receiver");
            long r0 = placeable.m3172getApparentToRealOffsetnOccac();
            placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(j) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(j) + IntOffset.m3978getYimpl(r0)), f, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m3186placeRelativeWithLayeraW9wM(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$receiver");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                long r0 = placeable.m3172getApparentToRealOffsetnOccac();
                placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(j) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(j) + IntOffset.m3978getYimpl(r0)), f, function1);
                return;
            }
            long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - IntSize.m4019getWidthimpl(placeable.m3173getMeasuredSizeYbymL2g())) - IntOffset.m3977getXimpl(j), IntOffset.m3978getYimpl(j));
            long r02 = placeable.m3172getApparentToRealOffsetnOccac();
            placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(IntOffset) + IntOffset.m3977getXimpl(r02), IntOffset.m3978getYimpl(IntOffset) + IntOffset.m3978getYimpl(r02)), f, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM  reason: not valid java name */
        public final void m3187placeWithLayeraW9wM(Placeable placeable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(placeable, "$receiver");
            Intrinsics.checkNotNullParameter(function1, "layerBlock");
            long r0 = placeable.m3172getApparentToRealOffsetnOccac();
            placeable.m3175placeAtf8xVGno(IntOffsetKt.IntOffset(IntOffset.m3977getXimpl(j) + IntOffset.m3977getXimpl(r0), IntOffset.m3978getYimpl(j) + IntOffset.m3978getYimpl(r0)), f, function1);
        }
    }
}
