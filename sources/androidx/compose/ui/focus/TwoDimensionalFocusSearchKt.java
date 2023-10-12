package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.ModifiedFocusNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\u001a5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\f\u001a\f\u0010\u0012\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a1\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u00020\u00140\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\f\u0010\u0019\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a#\u0010\u001a\u001a\u0004\u0018\u00010\u0014*\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"InvalidFocusDirection", "", "NoActiveChild", "beamBeats", "", "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "bottomRight", "findBestCandidate", "Landroidx/compose/ui/node/ModifiedFocusNode;", "", "focusRect", "findBestCandidate-4WY_MpI", "(Ljava/util/List;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/node/ModifiedFocusNode;", "topLeft", "twoDimensionalFocusSearch", "twoDimensionalFocusSearch-Mxy_nc0", "(Landroidx/compose/ui/node/ModifiedFocusNode;I)Landroidx/compose/ui/node/ModifiedFocusNode;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TwoDimensionalFocusSearch.kt */
public final class TwoDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TwoDimensionalFocusSearch.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Inactive.ordinal()] = 1;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 2;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.Active.ordinal()] = 5;
            iArr[FocusStateImpl.Captured.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: twoDimensionalFocusSearch-Mxy_nc0  reason: not valid java name */
    public static final ModifiedFocusNode m1318twoDimensionalFocusSearchMxy_nc0(ModifiedFocusNode modifiedFocusNode, int i) {
        ModifiedFocusNode r0;
        Rect rect;
        Intrinsics.checkNotNullParameter(modifiedFocusNode, "$this$twoDimensionalFocusSearch");
        Rect rect2 = null;
        boolean z = true;
        switch (WhenMappings.$EnumSwitchMapping$0[modifiedFocusNode.getFocusState().ordinal()]) {
            case 1:
                return modifiedFocusNode;
            case 2:
                return null;
            case 3:
            case 4:
                ModifiedFocusNode focusedChild = modifiedFocusNode.getFocusedChild();
                if (focusedChild == null) {
                    throw new IllegalStateException(NoActiveChild.toString());
                } else if (focusedChild.getFocusState() == FocusStateImpl.ActiveParent && (r0 = m1318twoDimensionalFocusSearchMxy_nc0(focusedChild, i)) != null) {
                    return r0;
                } else {
                    ModifiedFocusNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(modifiedFocusNode);
                    if (findActiveFocusNode != null) {
                        rect2 = findActiveFocusNode.focusRect();
                    }
                    if (rect2 != null) {
                        return m1316findBestCandidate4WY_MpI(modifiedFocusNode.focusableChildren(true), rect2, i);
                    }
                    throw new IllegalStateException(NoActiveChild.toString());
                }
            case 5:
            case 6:
                List<ModifiedFocusNode> focusableChildren = modifiedFocusNode.focusableChildren(true);
                if (focusableChildren.size() <= 1) {
                    return (ModifiedFocusNode) CollectionsKt.firstOrNull(focusableChildren);
                }
                if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1307getRightdhqQ8s()) ? true : FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1301getDowndhqQ8s())) {
                    rect = topLeft(modifiedFocusNode.focusRect());
                } else {
                    if (!FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1303getLeftdhqQ8s())) {
                        z = FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1308getUpdhqQ8s());
                    }
                    if (z) {
                        rect = bottomRight(modifiedFocusNode.focusRect());
                    } else {
                        throw new IllegalStateException(InvalidFocusDirection.toString());
                    }
                }
                return m1316findBestCandidate4WY_MpI(focusableChildren, rect, i);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: findBestCandidate-4WY_MpI  reason: not valid java name */
    private static final ModifiedFocusNode m1316findBestCandidate4WY_MpI(List<ModifiedFocusNode> list, Rect rect, int i) {
        Rect rect2;
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1303getLeftdhqQ8s())) {
            rect2 = rect.translate(rect.getWidth() + ((float) 1), 0.0f);
        } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1307getRightdhqQ8s())) {
            rect2 = rect.translate(-(rect.getWidth() + ((float) 1)), 0.0f);
        } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1308getUpdhqQ8s())) {
            rect2 = rect.translate(0.0f, rect.getHeight() + ((float) 1));
        } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1301getDowndhqQ8s())) {
            rect2 = rect.translate(0.0f, -(rect.getHeight() + ((float) 1)));
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        ModifiedFocusNode modifiedFocusNode = null;
        int i2 = 0;
        int size = list.size();
        while (i2 < size) {
            int i3 = i2 + 1;
            ModifiedFocusNode modifiedFocusNode2 = list.get(i2);
            Rect focusRect = modifiedFocusNode2.focusRect();
            if (m1317isBetterCandidateI7lrPNg(focusRect, rect2, rect, i)) {
                modifiedFocusNode = modifiedFocusNode2;
                rect2 = focusRect;
            }
            i2 = i3;
        }
        return modifiedFocusNode;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect rect, int i, Rect rect2) {
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1303getLeftdhqQ8s())) {
            if ((rect2.getRight() > rect.getRight() || rect2.getLeft() >= rect.getRight()) && rect2.getLeft() > rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1307getRightdhqQ8s())) {
            if ((rect2.getLeft() < rect.getLeft() || rect2.getRight() <= rect.getLeft()) && rect2.getRight() < rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1308getUpdhqQ8s())) {
            if ((rect2.getBottom() > rect.getBottom() || rect2.getTop() >= rect.getBottom()) && rect2.getTop() > rect.getTop()) {
                return true;
            }
        } else if (!FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1301getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if ((rect2.getTop() < rect.getTop() || rect2.getBottom() <= rect.getTop()) && rect2.getBottom() < rect.getBottom()) {
            return true;
        }
        return false;
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect rect, int i, Rect rect2) {
        float f;
        float top;
        float bottom;
        float top2;
        float bottom2;
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1303getLeftdhqQ8s())) {
            top2 = rect2.getLeft();
            bottom2 = rect.getRight();
        } else {
            if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1307getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1308getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1301getDowndhqQ8s())) {
                top = rect.getTop();
                bottom = rect2.getBottom();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f = top - bottom;
            return Math.max(0.0f, f);
        }
        f = top2 - bottom2;
        return Math.max(0.0f, f);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect rect, int i, Rect rect2) {
        float f;
        float left;
        float left2;
        float width;
        boolean z = true;
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1303getLeftdhqQ8s()) ? true : FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1307getRightdhqQ8s())) {
            f = (float) 2;
            left = rect2.getTop() + (rect2.getHeight() / f);
            left2 = rect.getTop();
            width = rect.getHeight();
        } else {
            if (!FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1308getUpdhqQ8s())) {
                z = FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1301getDowndhqQ8s());
            }
            if (z) {
                f = (float) 2;
                left = rect2.getLeft() + (rect2.getWidth() / f);
                left2 = rect.getLeft();
                width = rect.getWidth();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
        }
        return left - (left2 + (width / f));
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int i, Rect rect, Rect rect2) {
        long abs = (long) Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(rect2, i, rect));
        long abs2 = (long) Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(rect2, i, rect));
        return (((long) 13) * abs * abs) + (abs2 * abs2);
    }

    /* renamed from: isBetterCandidate-I7lrPNg  reason: not valid java name */
    private static final boolean m1317isBetterCandidateI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (isBetterCandidate_I7lrPNg$isCandidate(rect, i, rect3)) {
            if (!isBetterCandidate_I7lrPNg$isCandidate(rect2, i, rect3) || m1314beamBeatsI7lrPNg(rect3, rect, rect2, i)) {
                return true;
            }
            if (!m1314beamBeatsI7lrPNg(rect3, rect2, rect, i) && isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect) < isBetterCandidate_I7lrPNg$weightedDistance(i, rect3, rect2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean beamBeats_I7lrPNg$inSourceBeam(androidx.compose.ui.geometry.Rect r3, int r4, androidx.compose.ui.geometry.Rect r5) {
        /*
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m1303getLeftdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m1295equalsimpl0(r4, r0)
            r1 = 1
            if (r0 == 0) goto L_0x000f
            r0 = 1
            goto L_0x0019
        L_0x000f:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m1307getRightdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m1295equalsimpl0(r4, r0)
        L_0x0019:
            r2 = 0
            if (r0 == 0) goto L_0x0037
            float r4 = r3.getBottom()
            float r0 = r5.getTop()
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0035
            float r3 = r3.getTop()
            float r4 = r5.getBottom()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0035
            goto L_0x0069
        L_0x0035:
            r1 = 0
            goto L_0x0069
        L_0x0037:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m1308getUpdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m1295equalsimpl0(r4, r0)
            if (r0 == 0) goto L_0x0045
            r4 = 1
            goto L_0x004f
        L_0x0045:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m1301getDowndhqQ8s()
            boolean r4 = androidx.compose.ui.focus.FocusDirection.m1295equalsimpl0(r4, r0)
        L_0x004f:
            if (r4 == 0) goto L_0x006a
            float r4 = r3.getRight()
            float r0 = r5.getLeft()
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0035
            float r3 = r3.getLeft()
            float r4 = r5.getRight()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0035
        L_0x0069:
            return r1
        L_0x006a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "This function should only be used for 2-D focus search"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.beamBeats_I7lrPNg$inSourceBeam(androidx.compose.ui.geometry.Rect, int, androidx.compose.ui.geometry.Rect):boolean");
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect rect, int i, Rect rect2) {
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1303getLeftdhqQ8s())) {
            if (rect2.getLeft() >= rect.getRight()) {
                return true;
            }
        } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1307getRightdhqQ8s())) {
            if (rect2.getRight() <= rect.getLeft()) {
                return true;
            }
        } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1308getUpdhqQ8s())) {
            if (rect2.getTop() >= rect.getBottom()) {
                return true;
            }
        } else if (!FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1301getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if (rect2.getBottom() <= rect.getTop()) {
            return true;
        }
        return false;
    }

    /* renamed from: beamBeats_I7lrPNg$majorAxisDistance-2  reason: not valid java name */
    private static final float m1315beamBeats_I7lrPNg$majorAxisDistance2(Rect rect, int i, Rect rect2) {
        float f;
        float top;
        float bottom;
        float top2;
        float bottom2;
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1303getLeftdhqQ8s())) {
            top2 = rect2.getLeft();
            bottom2 = rect.getRight();
        } else {
            if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1307getRightdhqQ8s())) {
                top = rect.getLeft();
                bottom = rect2.getRight();
            } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1308getUpdhqQ8s())) {
                top2 = rect2.getTop();
                bottom2 = rect.getBottom();
            } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1301getDowndhqQ8s())) {
                top = rect.getTop();
                bottom = rect2.getBottom();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f = top - bottom;
            return Math.max(0.0f, f);
        }
        f = top2 - bottom2;
        return Math.max(0.0f, f);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect rect, int i, Rect rect2) {
        float f;
        float bottom;
        float bottom2;
        float top;
        float top2;
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1303getLeftdhqQ8s())) {
            top = rect2.getLeft();
            top2 = rect.getLeft();
        } else {
            if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1307getRightdhqQ8s())) {
                bottom = rect.getRight();
                bottom2 = rect2.getRight();
            } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1308getUpdhqQ8s())) {
                top = rect2.getTop();
                top2 = rect.getTop();
            } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1301getDowndhqQ8s())) {
                bottom = rect.getBottom();
                bottom2 = rect2.getBottom();
            } else {
                throw new IllegalStateException(InvalidFocusDirection.toString());
            }
            f = bottom - bottom2;
            return Math.max(1.0f, f);
        }
        f = top - top2;
        return Math.max(1.0f, f);
    }

    /* renamed from: beamBeats-I7lrPNg  reason: not valid java name */
    private static final boolean m1314beamBeatsI7lrPNg(Rect rect, Rect rect2, Rect rect3, int i) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect3, i, rect) || !beamBeats_I7lrPNg$inSourceBeam(rect2, i, rect)) {
            return false;
        }
        if (beamBeats_I7lrPNg$isInDirectionOfSearch(rect3, i, rect) && !FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1303getLeftdhqQ8s()) && !FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1307getRightdhqQ8s()) && m1315beamBeats_I7lrPNg$majorAxisDistance2(rect2, i, rect) >= beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect3, i, rect)) {
            return false;
        }
        return true;
    }

    private static final Rect topLeft(Rect rect) {
        return new Rect(rect.getLeft(), rect.getTop(), rect.getLeft(), rect.getTop());
    }

    private static final Rect bottomRight(Rect rect) {
        return new Rect(rect.getRight(), rect.getBottom(), rect.getRight(), rect.getBottom());
    }
}
