package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifiedFocusNode;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\t\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\n\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u0014\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002\u001a\f\u0010\u000f\u001a\u00020\u0004*\u00020\u0002H\u0002¨\u0006\u0010"}, d2 = {"activateNode", "", "Landroidx/compose/ui/node/ModifiedFocusNode;", "captureFocus", "", "clearChildFocus", "clearFocus", "forcedClear", "deactivateNode", "freeFocus", "grantFocus", "grantFocusToChild", "childNode", "requestFocus", "requestFocusForChild", "requestFocusForOwner", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusTransactions.kt */
public final class FocusTransactionsKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FocusTransactions.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void requestFocus(ModifiedFocusNode modifiedFocusNode) {
        Intrinsics.checkNotNullParameter(modifiedFocusNode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[modifiedFocusNode.getFocusState().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                modifiedFocusNode.sendOnFocusEvent(modifiedFocusNode.getFocusState());
                return;
            case 5:
                if (clearChildFocus(modifiedFocusNode)) {
                    grantFocus(modifiedFocusNode);
                    return;
                }
                return;
            case 6:
                ModifiedFocusNode findParentFocusNode$ui_release = modifiedFocusNode.findParentFocusNode$ui_release();
                if (findParentFocusNode$ui_release != null) {
                    requestFocusForChild(findParentFocusNode$ui_release, modifiedFocusNode);
                    return;
                } else if (requestFocusForOwner(modifiedFocusNode)) {
                    grantFocus(modifiedFocusNode);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public static final void activateNode(ModifiedFocusNode modifiedFocusNode) {
        Intrinsics.checkNotNullParameter(modifiedFocusNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[modifiedFocusNode.getFocusState().ordinal()];
        if (i == 3) {
            modifiedFocusNode.setFocusState(FocusStateImpl.Inactive);
        } else if (i == 4) {
            modifiedFocusNode.setFocusState(FocusStateImpl.ActiveParent);
        }
    }

    public static final void deactivateNode(ModifiedFocusNode modifiedFocusNode) {
        FocusManager focusManager;
        Intrinsics.checkNotNullParameter(modifiedFocusNode, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[modifiedFocusNode.getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            Owner owner$ui_release = modifiedFocusNode.getLayoutNode$ui_release().getOwner$ui_release();
            if (!(owner$ui_release == null || (focusManager = owner$ui_release.getFocusManager()) == null)) {
                focusManager.clearFocus(true);
            }
            modifiedFocusNode.setFocusState(FocusStateImpl.Deactivated);
        } else if (i == 5) {
            modifiedFocusNode.setFocusState(FocusStateImpl.DeactivatedParent);
        } else if (i == 6) {
            modifiedFocusNode.setFocusState(FocusStateImpl.Deactivated);
        }
    }

    public static final boolean captureFocus(ModifiedFocusNode modifiedFocusNode) {
        Intrinsics.checkNotNullParameter(modifiedFocusNode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[modifiedFocusNode.getFocusState().ordinal()]) {
            case 1:
                modifiedFocusNode.setFocusState(FocusStateImpl.Captured);
                return true;
            case 2:
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean freeFocus(ModifiedFocusNode modifiedFocusNode) {
        Intrinsics.checkNotNullParameter(modifiedFocusNode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[modifiedFocusNode.getFocusState().ordinal()]) {
            case 1:
                return true;
            case 2:
                modifiedFocusNode.setFocusState(FocusStateImpl.Active);
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean clearFocus$default(ModifiedFocusNode modifiedFocusNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(modifiedFocusNode, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean clearFocus(androidx.compose.ui.node.ModifiedFocusNode r3, boolean r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.compose.ui.focus.FocusStateImpl r0 = r3.getFocusState()
            int[] r1 = androidx.compose.ui.focus.FocusTransactionsKt.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            r2 = 1
            switch(r0) {
                case 1: goto L_0x003e;
                case 2: goto L_0x0036;
                case 3: goto L_0x0043;
                case 4: goto L_0x0028;
                case 5: goto L_0x001c;
                case 6: goto L_0x0043;
                default: goto L_0x0016;
            }
        L_0x0016:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        L_0x001c:
            boolean r4 = clearChildFocus(r3)
            if (r4 == 0) goto L_0x0034
            androidx.compose.ui.focus.FocusStateImpl r4 = androidx.compose.ui.focus.FocusStateImpl.Inactive
            r3.setFocusState(r4)
            goto L_0x0043
        L_0x0028:
            boolean r4 = clearChildFocus(r3)
            if (r4 == 0) goto L_0x0034
            androidx.compose.ui.focus.FocusStateImpl r4 = androidx.compose.ui.focus.FocusStateImpl.Deactivated
            r3.setFocusState(r4)
            goto L_0x0043
        L_0x0034:
            r4 = 0
            goto L_0x0044
        L_0x0036:
            if (r4 == 0) goto L_0x0044
            androidx.compose.ui.focus.FocusStateImpl r0 = androidx.compose.ui.focus.FocusStateImpl.Inactive
            r3.setFocusState(r0)
            goto L_0x0044
        L_0x003e:
            androidx.compose.ui.focus.FocusStateImpl r4 = androidx.compose.ui.focus.FocusStateImpl.Inactive
            r3.setFocusState(r4)
        L_0x0043:
            r4 = 1
        L_0x0044:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionsKt.clearFocus(androidx.compose.ui.node.ModifiedFocusNode, boolean):boolean");
    }

    private static final void grantFocus(ModifiedFocusNode modifiedFocusNode) {
        FocusStateImpl focusStateImpl;
        switch (WhenMappings.$EnumSwitchMapping$0[modifiedFocusNode.getFocusState().ordinal()]) {
            case 1:
            case 5:
            case 6:
                focusStateImpl = FocusStateImpl.Active;
                break;
            case 2:
                focusStateImpl = FocusStateImpl.Captured;
                break;
            case 3:
            case 4:
                throw new IllegalStateException("Granting focus to a deactivated node.".toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
        modifiedFocusNode.setFocusState(focusStateImpl);
    }

    private static final boolean grantFocusToChild(ModifiedFocusNode modifiedFocusNode, ModifiedFocusNode modifiedFocusNode2) {
        grantFocus(modifiedFocusNode2);
        modifiedFocusNode.setFocusedChild(modifiedFocusNode2);
        return true;
    }

    private static final boolean clearChildFocus(ModifiedFocusNode modifiedFocusNode) {
        ModifiedFocusNode focusedChild = modifiedFocusNode.getFocusedChild();
        if (focusedChild == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        } else if (!clearFocus$default(focusedChild, false, 1, (Object) null)) {
            return false;
        } else {
            modifiedFocusNode.setFocusedChild((ModifiedFocusNode) null);
            return true;
        }
    }

    private static final boolean requestFocusForChild(ModifiedFocusNode modifiedFocusNode, ModifiedFocusNode modifiedFocusNode2) {
        if (modifiedFocusNode.focusableChildren(false).contains(modifiedFocusNode2)) {
            switch (WhenMappings.$EnumSwitchMapping$0[modifiedFocusNode.getFocusState().ordinal()]) {
                case 1:
                    modifiedFocusNode.setFocusState(FocusStateImpl.ActiveParent);
                    return grantFocusToChild(modifiedFocusNode, modifiedFocusNode2);
                case 2:
                    return false;
                case 3:
                    activateNode(modifiedFocusNode);
                    boolean requestFocusForChild = requestFocusForChild(modifiedFocusNode, modifiedFocusNode2);
                    deactivateNode(modifiedFocusNode);
                    return requestFocusForChild;
                case 4:
                    if (modifiedFocusNode.getFocusedChild() == null) {
                        return grantFocusToChild(modifiedFocusNode, modifiedFocusNode2);
                    }
                    if (clearChildFocus(modifiedFocusNode)) {
                        return grantFocusToChild(modifiedFocusNode, modifiedFocusNode2);
                    }
                    return false;
                case 5:
                    if (clearChildFocus(modifiedFocusNode)) {
                        return grantFocusToChild(modifiedFocusNode, modifiedFocusNode2);
                    }
                    return false;
                case 6:
                    ModifiedFocusNode findParentFocusNode$ui_release = modifiedFocusNode.findParentFocusNode$ui_release();
                    if (findParentFocusNode$ui_release == null && requestFocusForOwner(modifiedFocusNode)) {
                        modifiedFocusNode.setFocusState(FocusStateImpl.Active);
                        return requestFocusForChild(modifiedFocusNode, modifiedFocusNode2);
                    } else if (findParentFocusNode$ui_release == null || !requestFocusForChild(findParentFocusNode$ui_release, modifiedFocusNode)) {
                        return false;
                    } else {
                        return requestFocusForChild(modifiedFocusNode, modifiedFocusNode2);
                    }
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
    }

    private static final boolean requestFocusForOwner(ModifiedFocusNode modifiedFocusNode) {
        Owner owner$ui_release = modifiedFocusNode.getLayoutNode$ui_release().getOwner$ui_release();
        Boolean valueOf = owner$ui_release == null ? null : Boolean.valueOf(owner$ui_release.requestFocus());
        if (valueOf != null) {
            return valueOf.booleanValue();
        }
        throw new IllegalStateException("Owner not initialized.".toString());
    }
}
