package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005EFGHIB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020$H\u0007J-\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b.J%\u0010/\u001a\u00020&2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b0J-\u00101\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b2J-\u00103\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b4J-\u00105\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b6J-\u00107\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\b8J\u001d\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020;H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010=J%\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?J%\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020$H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010@J/\u0010A\u001a\u00020&*\u00020*2\u0006\u0010B\u001a\u00020-2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020&0DH\bR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\fR\u001c\u0010\u0015\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0018\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\fR\u001c\u0010\u001b\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0011R\u001c\u0010\u001e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement;", "", "()V", "Bottom", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getBottom$annotations", "getBottom", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "End", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getEnd$annotations", "getEnd", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "Start", "getStart$annotations", "getStart", "Top", "getTop$annotations", "getTop", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "placeCenter", "", "totalSize", "", "size", "", "outPosition", "reverseInput", "", "placeCenter$foundation_layout_release", "placeLeftOrTop", "placeLeftOrTop$foundation_layout_release", "placeRightOrBottom", "placeRightOrBottom$foundation_layout_release", "placeSpaceAround", "placeSpaceAround$foundation_layout_release", "placeSpaceBetween", "placeSpaceBetween$foundation_layout_release", "placeSpaceEvenly", "placeSpaceEvenly$foundation_layout_release", "spacedBy", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "forEachIndexed", "reversed", "action", "Lkotlin/Function2;", "Absolute", "Horizontal", "HorizontalOrVertical", "SpacedAligned", "Vertical", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Arrangement.kt */
public final class Arrangement {
    private static final Vertical Bottom = new Arrangement$Bottom$1();
    private static final HorizontalOrVertical Center = new Arrangement$Center$1();
    private static final Horizontal End = new Arrangement$End$1();
    public static final Arrangement INSTANCE = new Arrangement();
    private static final HorizontalOrVertical SpaceAround = new Arrangement$SpaceAround$1();
    private static final HorizontalOrVertical SpaceBetween = new Arrangement$SpaceBetween$1();
    private static final HorizontalOrVertical SpaceEvenly = new Arrangement$SpaceEvenly$1();
    private static final Horizontal Start = new Arrangement$Start$1();
    private static final Vertical Top = new Arrangement$Top$1();

    public static /* synthetic */ void getBottom$annotations() {
    }

    public static /* synthetic */ void getCenter$annotations() {
    }

    public static /* synthetic */ void getEnd$annotations() {
    }

    public static /* synthetic */ void getSpaceAround$annotations() {
    }

    public static /* synthetic */ void getSpaceBetween$annotations() {
    }

    public static /* synthetic */ void getSpaceEvenly$annotations() {
    }

    public static /* synthetic */ void getStart$annotations() {
    }

    public static /* synthetic */ void getTop$annotations() {
    }

    private Arrangement() {
    }

    public final Horizontal getStart() {
        return Start;
    }

    public final Horizontal getEnd() {
        return End;
    }

    public final Vertical getTop() {
        return Top;
    }

    public final Vertical getBottom() {
        return Bottom;
    }

    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    public final HorizontalOrVertical getSpaceEvenly() {
        return SpaceEvenly;
    }

    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    public final HorizontalOrVertical getSpaceAround() {
        return SpaceAround;
    }

    /* renamed from: spacedBy-0680j_4  reason: not valid java name */
    public final HorizontalOrVertical m346spacedBy0680j_4(float f) {
        return new SpacedAligned(f, true, Arrangement$spacedBy$1.INSTANCE, (DefaultConstructorMarker) null);
    }

    /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
    public final Horizontal m347spacedByD5KLDUw(float f, Alignment.Horizontal horizontal) {
        Intrinsics.checkNotNullParameter(horizontal, "alignment");
        return new SpacedAligned(f, true, new Arrangement$spacedBy$2(horizontal), (DefaultConstructorMarker) null);
    }

    /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
    public final Vertical m348spacedByD5KLDUw(float f, Alignment.Vertical vertical) {
        Intrinsics.checkNotNullParameter(vertical, "alignment");
        return new SpacedAligned(f, false, new Arrangement$spacedBy$3(vertical), (DefaultConstructorMarker) null);
    }

    public final Horizontal aligned(Alignment.Horizontal horizontal) {
        Intrinsics.checkNotNullParameter(horizontal, "alignment");
        return new SpacedAligned(Dp.m3859constructorimpl((float) 0), true, new Arrangement$aligned$1(horizontal), (DefaultConstructorMarker) null);
    }

    public final Vertical aligned(Alignment.Vertical vertical) {
        Intrinsics.checkNotNullParameter(vertical, "alignment");
        return new SpacedAligned(Dp.m3859constructorimpl((float) 0), false, new Arrangement$aligned$2(vertical), (DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u001d\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J%\u0010\u001a\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010$R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Absolute;", "", "()V", "Center", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Left", "getLeft$annotations", "getLeft", "Right", "getRight$annotations", "getRight", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public static final class Absolute {
        private static final Horizontal Center = new Arrangement$Absolute$Center$1();
        public static final Absolute INSTANCE = new Absolute();
        private static final Horizontal Left = new Arrangement$Absolute$Left$1();
        private static final Horizontal Right = new Arrangement$Absolute$Right$1();
        private static final Horizontal SpaceAround = new Arrangement$Absolute$SpaceAround$1();
        private static final Horizontal SpaceBetween = new Arrangement$Absolute$SpaceBetween$1();
        private static final Horizontal SpaceEvenly = new Arrangement$Absolute$SpaceEvenly$1();

        public static /* synthetic */ void getCenter$annotations() {
        }

        public static /* synthetic */ void getLeft$annotations() {
        }

        public static /* synthetic */ void getRight$annotations() {
        }

        public static /* synthetic */ void getSpaceAround$annotations() {
        }

        public static /* synthetic */ void getSpaceBetween$annotations() {
        }

        public static /* synthetic */ void getSpaceEvenly$annotations() {
        }

        private Absolute() {
        }

        public final Horizontal getLeft() {
            return Left;
        }

        public final Horizontal getCenter() {
            return Center;
        }

        public final Horizontal getRight() {
            return Right;
        }

        public final Horizontal getSpaceBetween() {
            return SpaceBetween;
        }

        public final Horizontal getSpaceEvenly() {
            return SpaceEvenly;
        }

        public final Horizontal getSpaceAround() {
            return SpaceAround;
        }

        /* renamed from: spacedBy-0680j_4  reason: not valid java name */
        public final HorizontalOrVertical m349spacedBy0680j_4(float f) {
            return new SpacedAligned(f, false, (Function2) null, (DefaultConstructorMarker) null);
        }

        /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
        public final Horizontal m350spacedByD5KLDUw(float f, Alignment.Horizontal horizontal) {
            Intrinsics.checkNotNullParameter(horizontal, "alignment");
            return new SpacedAligned(f, false, new Arrangement$Absolute$spacedBy$1(horizontal), (DefaultConstructorMarker) null);
        }

        /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
        public final Vertical m351spacedByD5KLDUw(float f, Alignment.Vertical vertical) {
            Intrinsics.checkNotNullParameter(vertical, "alignment");
            return new SpacedAligned(f, false, new Arrangement$Absolute$spacedBy$2(vertical), (DefaultConstructorMarker) null);
        }

        public final Horizontal aligned(Alignment.Horizontal horizontal) {
            Intrinsics.checkNotNullParameter(horizontal, "alignment");
            return new SpacedAligned(Dp.m3859constructorimpl((float) 0), false, new Arrangement$Absolute$aligned$1(horizontal), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u0014\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0010J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JH\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J,\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020&H\u0016J$\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "rtlMirror", "", "alignment", "Lkotlin/Function2;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "getRtlMirror", "()Z", "getSpace-D9Ej5fM", "()F", "F", "spacing", "getSpacing-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FZLkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "equals", "other", "", "hashCode", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "sizes", "", "layoutDirection", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public static final class SpacedAligned implements HorizontalOrVertical {
        private final Function2<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        public /* synthetic */ SpacedAligned(float f, boolean z, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, z, function2);
        }

        /* renamed from: copy-8Feqmps$default  reason: not valid java name */
        public static /* synthetic */ SpacedAligned m368copy8Feqmps$default(SpacedAligned spacedAligned, float f, boolean z, Function2<Integer, LayoutDirection, Integer> function2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = spacedAligned.space;
            }
            if ((i & 2) != 0) {
                z = spacedAligned.rtlMirror;
            }
            if ((i & 4) != 0) {
                function2 = spacedAligned.alignment;
            }
            return spacedAligned.m370copy8Feqmps(f, z, function2);
        }

        /* renamed from: component1-D9Ej5fM  reason: not valid java name */
        public final float m369component1D9Ej5fM() {
            return this.space;
        }

        public final boolean component2() {
            return this.rtlMirror;
        }

        public final Function2<Integer, LayoutDirection, Integer> component3() {
            return this.alignment;
        }

        /* renamed from: copy-8Feqmps  reason: not valid java name */
        public final SpacedAligned m370copy8Feqmps(float f, boolean z, Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            return new SpacedAligned(f, z, function2, (DefaultConstructorMarker) null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) obj;
            return Dp.m3864equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && Intrinsics.areEqual((Object) this.alignment, (Object) spacedAligned.alignment);
        }

        public int hashCode() {
            int r0 = Dp.m3865hashCodeimpl(this.space) * 31;
            boolean z = this.rtlMirror;
            if (z) {
                z = true;
            }
            int i = (r0 + (z ? 1 : 0)) * 31;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            return i + (function2 == null ? 0 : function2.hashCode());
        }

        private SpacedAligned(float f, boolean z, Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            this.space = f;
            this.rtlMirror = z;
            this.alignment = function2;
            this.spacing = m371getSpaceD9Ej5fM();
        }

        /* renamed from: getSpace-D9Ej5fM  reason: not valid java name */
        public final float m371getSpaceD9Ej5fM() {
            return this.space;
        }

        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        public final Function2<Integer, LayoutDirection, Integer> getAlignment() {
            return this.alignment;
        }

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        public float m372getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            int i2;
            int i3;
            int min;
            int i4;
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            if (!(iArr.length == 0)) {
                int r10 = density.m3822roundToPx0680j_4(m371getSpaceD9Ej5fM());
                boolean z = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
                Arrangement arrangement = Arrangement.INSTANCE;
                if (!z) {
                    int length = iArr.length;
                    int i5 = 0;
                    i3 = 0;
                    i2 = 0;
                    int i6 = 0;
                    while (i5 < length) {
                        int i7 = iArr[i5];
                        i5++;
                        iArr2[i6] = Math.min(i3, i - i7);
                        int min2 = Math.min(r10, (i - iArr2[i6]) - i7);
                        int i8 = iArr2[i6] + i7 + min2;
                        i6++;
                        int i9 = i8;
                        i2 = min2;
                        i3 = i9;
                    }
                } else {
                    int length2 = iArr.length - 1;
                    if (length2 >= 0) {
                        int i10 = 0;
                        while (true) {
                            int i11 = length2 - 1;
                            int i12 = iArr[length2];
                            iArr2[length2] = Math.min(i10, i - i12);
                            min = Math.min(r10, (i - iArr2[length2]) - i12);
                            i4 = iArr2[length2] + i12 + min;
                            if (i11 < 0) {
                                break;
                            }
                            i10 = i4;
                            length2 = i11;
                        }
                        i3 = i4;
                        i2 = min;
                    } else {
                        i3 = 0;
                        i2 = 0;
                    }
                }
                int i13 = i3 - i2;
                Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
                if (function2 != null && i13 < i) {
                    int intValue = function2.invoke(Integer.valueOf(i - i13), layoutDirection).intValue();
                    int length3 = iArr2.length;
                    for (int i14 = 0; i14 < length3; i14++) {
                        iArr2[i14] = iArr2[i14] + intValue;
                    }
                }
            }
        }

        public void arrange(Density density, int i, int[] iArr, int[] iArr2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            arrange(density, i, iArr, LayoutDirection.Ltr, iArr2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.rtlMirror ? "" : "Absolute");
            sb.append("Arrangement#spacedAligned(");
            sb.append(Dp.m3870toStringimpl(m371getSpaceD9Ej5fM()));
            sb.append(", ");
            sb.append(this.alignment);
            sb.append(')');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&R\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public interface Horizontal {
        void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        float m361getSpacingD9Ej5fM();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Arrangement.kt */
        public static final class DefaultImpls {
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m362getSpacingD9Ej5fM(Horizontal horizontal) {
                Intrinsics.checkNotNullParameter(horizontal, "this");
                return Dp.m3859constructorimpl((float) 0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002R\u001d\u0010\u0003\u001a\u00020\u00048VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public interface HorizontalOrVertical extends Horizontal, Vertical {
        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        float m363getSpacingD9Ej5fM();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Arrangement.kt */
        public static final class DefaultImpls {
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m364getSpacingD9Ej5fM(HorizontalOrVertical horizontalOrVertical) {
                Intrinsics.checkNotNullParameter(horizontalOrVertical, "this");
                return Dp.m3859constructorimpl((float) 0);
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&R\u001d\u0010\u0002\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public interface Vertical {
        void arrange(Density density, int i, int[] iArr, int[] iArr2);

        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        float m375getSpacingD9Ej5fM();

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Arrangement.kt */
        public static final class DefaultImpls {
            /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
            public static float m376getSpacingD9Ej5fM(Vertical vertical) {
                Intrinsics.checkNotNullParameter(vertical, "this");
                return Dp.m3859constructorimpl((float) 0);
            }
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            i3++;
            i4 += i5;
        }
        int i6 = i - i4;
        if (!z) {
            int length2 = iArr.length;
            int i7 = 0;
            while (i2 < length2) {
                int i8 = iArr[i2];
                i2++;
                iArr2[i7] = i6;
                i6 += i8;
                i7++;
            }
            return;
        }
        int length3 = iArr.length - 1;
        if (length3 >= 0) {
            while (true) {
                int i9 = length3 - 1;
                int i10 = iArr[length3];
                iArr2[length3] = i6;
                i6 += i10;
                if (i9 >= 0) {
                    length3 = i9;
                } else {
                    return;
                }
            }
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(int[] iArr, int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i = 0;
        if (!z) {
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                int i4 = iArr[i];
                i++;
                iArr2[i2] = i3;
                i3 += i4;
                i2++;
            }
            return;
        }
        int length2 = iArr.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i5 = length2 - 1;
                int i6 = iArr[length2];
                iArr2[length2] = i;
                i += i6;
                if (i5 >= 0) {
                    length2 = i5;
                } else {
                    return;
                }
            }
        }
    }

    public final void placeCenter$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            i3++;
            i4 += i5;
        }
        float f = ((float) (i - i4)) / ((float) 2);
        if (!z) {
            int length2 = iArr.length;
            int i6 = 0;
            while (i2 < length2) {
                int i7 = iArr[i2];
                i2++;
                iArr2[i6] = MathKt.roundToInt(f);
                f += (float) i7;
                i6++;
            }
            return;
        }
        int length3 = iArr.length - 1;
        if (length3 >= 0) {
            while (true) {
                int i8 = length3 - 1;
                int i9 = iArr[length3];
                iArr2[length3] = MathKt.roundToInt(f);
                f += (float) i9;
                if (i8 >= 0) {
                    length3 = i8;
                } else {
                    return;
                }
            }
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            i3++;
            i4 += i5;
        }
        float length2 = ((float) (i - i4)) / ((float) (iArr.length + 1));
        if (!z) {
            int length3 = iArr.length;
            float f = length2;
            int i6 = 0;
            while (i2 < length3) {
                int i7 = iArr[i2];
                i2++;
                iArr2[i6] = MathKt.roundToInt(f);
                f += ((float) i7) + length2;
                i6++;
            }
            return;
        }
        int length4 = iArr.length - 1;
        if (length4 >= 0) {
            float f2 = length2;
            while (true) {
                int i8 = length4 - 1;
                int i9 = iArr[length4];
                iArr2[length4] = MathKt.roundToInt(f2);
                f2 += ((float) i9) + length2;
                if (i8 >= 0) {
                    length4 = i8;
                } else {
                    return;
                }
            }
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            i3++;
            i4 += i5;
        }
        float f = 0.0f;
        float length2 = iArr.length > 1 ? ((float) (i - i4)) / ((float) (iArr.length - 1)) : 0.0f;
        if (!z) {
            int length3 = iArr.length;
            int i6 = 0;
            while (i2 < length3) {
                int i7 = iArr[i2];
                i2++;
                iArr2[i6] = MathKt.roundToInt(f);
                f += ((float) i7) + length2;
                i6++;
            }
            return;
        }
        int length4 = iArr.length - 1;
        if (length4 >= 0) {
            while (true) {
                int i8 = length4 - 1;
                int i9 = iArr[length4];
                iArr2[length4] = MathKt.roundToInt(f);
                f += ((float) i9) + length2;
                if (i8 >= 0) {
                    length4 = i8;
                } else {
                    return;
                }
            }
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int i, int[] iArr, int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            i3++;
            i4 += i5;
        }
        float length2 = (iArr.length == 0) ^ true ? ((float) (i - i4)) / ((float) iArr.length) : 0.0f;
        float f = length2 / ((float) 2);
        if (!z) {
            int length3 = iArr.length;
            int i6 = 0;
            while (i2 < length3) {
                int i7 = iArr[i2];
                i2++;
                iArr2[i6] = MathKt.roundToInt(f);
                f += ((float) i7) + length2;
                i6++;
            }
            return;
        }
        int length4 = iArr.length - 1;
        if (length4 >= 0) {
            while (true) {
                int i8 = length4 - 1;
                int i9 = iArr[length4];
                iArr2[length4] = MathKt.roundToInt(f);
                f += ((float) i9) + length2;
                if (i8 >= 0) {
                    length4 = i8;
                } else {
                    return;
                }
            }
        }
    }

    private final void forEachIndexed(int[] iArr, boolean z, Function2<? super Integer, ? super Integer, Unit> function2) {
        if (!z) {
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = iArr[i];
                i++;
                function2.invoke(Integer.valueOf(i2), Integer.valueOf(i3));
                i2++;
            }
            return;
        }
        int length2 = iArr.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i4 = length2 - 1;
                function2.invoke(Integer.valueOf(length2), Integer.valueOf(iArr[length2]));
                if (i4 >= 0) {
                    length2 = i4;
                } else {
                    return;
                }
            }
        }
    }
}
