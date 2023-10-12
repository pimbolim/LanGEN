package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.node.ModifiedFocusNode;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\t\u001a\u00020\n*\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000f\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0001\u001a+\u0010\t\u001a\u00020\n*\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "Landroidx/compose/ui/node/ModifiedFocusNode;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/node/ModifiedFocusNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "focusOrder", "Landroidx/compose/ui/Modifier;", "focusOrderReceiver", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusOrder;", "", "Lkotlin/ExtensionFunctionType;", "focusRequester", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusOrderModifier.kt */
public final class FocusOrderModifierKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FocusOrderModifier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Modifier focusOrder(Modifier modifier, Function1<? super FocusOrder, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "focusOrderReceiver");
        return modifier.then(new FocusOrderModifierImpl(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusOrderModifierKt$focusOrder$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final Modifier focusOrder(Modifier modifier, FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        return FocusRequesterModifierKt.focusRequester(modifier, focusRequester);
    }

    public static final Modifier focusOrder(Modifier modifier, FocusRequester focusRequester, Function1<? super FocusOrder, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Intrinsics.checkNotNullParameter(function1, "focusOrderReceiver");
        return focusOrder(FocusRequesterModifierKt.focusRequester(modifier, focusRequester), function1);
    }

    /* renamed from: customFocusSearch--OM-vw8  reason: not valid java name */
    public static final FocusRequester m1311customFocusSearchOMvw8(ModifiedFocusNode modifiedFocusNode, int i, LayoutDirection layoutDirection) {
        FocusRequester focusRequester;
        FocusRequester focusRequester2;
        Intrinsics.checkNotNullParameter(modifiedFocusNode, "$this$customFocusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        FocusOrder focusOrder = new FocusOrder();
        LayoutNodeWrapper wrappedBy$ui_release = modifiedFocusNode.getWrappedBy$ui_release();
        if (wrappedBy$ui_release != null) {
            wrappedBy$ui_release.populateFocusOrder(focusOrder);
        }
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1304getNextdhqQ8s())) {
            return focusOrder.getNext();
        }
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1306getPreviousdhqQ8s())) {
            return focusOrder.getPrevious();
        }
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1308getUpdhqQ8s())) {
            return focusOrder.getUp();
        }
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1301getDowndhqQ8s())) {
            return focusOrder.getDown();
        }
        if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1303getLeftdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                focusRequester2 = focusOrder.getStart();
            } else if (i2 == 2) {
                focusRequester2 = focusOrder.getEnd();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (Intrinsics.areEqual((Object) focusRequester2, (Object) FocusRequester.Companion.getDefault())) {
                focusRequester2 = null;
            }
            if (focusRequester2 == null) {
                return focusOrder.getLeft();
            }
            return focusRequester2;
        } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1307getRightdhqQ8s())) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i3 == 1) {
                focusRequester = focusOrder.getEnd();
            } else if (i3 == 2) {
                focusRequester = focusOrder.getStart();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (Intrinsics.areEqual((Object) focusRequester, (Object) FocusRequester.Companion.getDefault())) {
                focusRequester = null;
            }
            if (focusRequester == null) {
                return focusOrder.getRight();
            }
            return focusRequester;
        } else if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1302getIndhqQ8s())) {
            return FocusRequester.Companion.getDefault();
        } else {
            if (FocusDirection.m1295equalsimpl0(i, FocusDirection.Companion.m1305getOutdhqQ8s())) {
                return FocusRequester.Companion.getDefault();
            }
            throw new IllegalStateException("invalid FocusDirection".toString());
        }
    }
}
