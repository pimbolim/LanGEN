package androidx.compose.ui.platform.accessibility;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.CollectionItemInfo;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\u0014\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\u0002H\u0002\u001a\u001c\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0016"}, d2 = {"isLazyCollection", "", "Landroidx/compose/ui/semantics/CollectionInfo;", "(Landroidx/compose/ui/semantics/CollectionInfo;)Z", "calculateIfHorizontallyStacked", "items", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "setCollectionInfo", "", "node", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "setCollectionItemInfo", "hasCollectionInfo", "toAccessibilityCollectionInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionInfoCompat;", "kotlin.jvm.PlatformType", "toAccessibilityCollectionItemInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionItemInfoCompat;", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "itemNode", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionInfo.kt */
public final class CollectionInfoKt {
    public static final void setCollectionInfo(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i;
        Intrinsics.checkNotNullParameter(semanticsNode, "node");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo());
        if (collectionInfo != null) {
            accessibilityNodeInfoCompat.setCollectionInfo(toAccessibilityCollectionInfo(collectionInfo));
            return;
        }
        List arrayList = new ArrayList();
        if (SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) != null) {
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 + 1;
                SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i2);
                if (semanticsNode2.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    arrayList.add(semanticsNode2);
                }
                i2 = i3;
            }
        }
        Collection collection = arrayList;
        int i4 = 1;
        if (!collection.isEmpty()) {
            boolean calculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
            if (calculateIfHorizontallyStacked) {
                i = 1;
            } else {
                i = collection.size();
            }
            if (calculateIfHorizontallyStacked) {
                i4 = collection.size();
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, i4, false, 0));
        }
    }

    public static final void setCollectionItemInfo(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsNode semanticsNode2 = semanticsNode;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
        Intrinsics.checkNotNullParameter(semanticsNode2, "node");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat2, "info");
        CollectionItemInfo collectionItemInfo = (CollectionItemInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getCollectionItemInfo());
        if (collectionItemInfo != null) {
            accessibilityNodeInfoCompat2.setCollectionItemInfo(toAccessibilityCollectionItemInfo(collectionItemInfo, semanticsNode2));
        }
        SemanticsNode parent = semanticsNode.getParent();
        if (parent != null && SemanticsConfigurationKt.getOrNull(parent.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) != null) {
            CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(parent.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo());
            if ((collectionInfo == null || !isLazyCollection(collectionInfo)) && semanticsNode.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                List arrayList = new ArrayList();
                List<SemanticsNode> replacedChildren$ui_release = parent.getReplacedChildren$ui_release();
                int size = replacedChildren$ui_release.size();
                int i = 0;
                while (i < size) {
                    int i2 = i + 1;
                    SemanticsNode semanticsNode3 = replacedChildren$ui_release.get(i);
                    if (semanticsNode3.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                        arrayList.add(semanticsNode3);
                    }
                    i = i2;
                }
                if (!arrayList.isEmpty()) {
                    boolean calculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
                    int size2 = arrayList.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        int i4 = i3 + 1;
                        SemanticsNode semanticsNode4 = (SemanticsNode) arrayList.get(i3);
                        if (semanticsNode4.getId() == semanticsNode.getId()) {
                            AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain = AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(calculateIfHorizontallyStacked ? 0 : i3, 1, calculateIfHorizontallyStacked ? i3 : 0, 1, false, ((Boolean) semanticsNode4.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), CollectionInfoKt$setCollectionItemInfo$2$itemInfo$1.INSTANCE)).booleanValue());
                            if (obtain != null) {
                                accessibilityNodeInfoCompat2.setCollectionItemInfo(obtain);
                            }
                        }
                        i3 = i4;
                    }
                }
            }
        }
    }

    public static final boolean hasCollectionInfo(SemanticsNode semanticsNode) {
        Intrinsics.checkNotNullParameter(semanticsNode, "<this>");
        return (SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getCollectionInfo()) == null && SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), SemanticsProperties.INSTANCE.getSelectableGroup()) == null) ? false : true;
    }

    private static final boolean calculateIfHorizontallyStacked(List<SemanticsNode> list) {
        List list2;
        long j;
        if (list.size() < 2) {
            return true;
        }
        if (list.size() == 0 || list.size() == 1) {
            list2 = CollectionsKt.emptyList();
        } else {
            list2 = new ArrayList();
            SemanticsNode semanticsNode = list.get(0);
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i = 0;
            while (i < lastIndex) {
                i++;
                SemanticsNode semanticsNode2 = list.get(i);
                SemanticsNode semanticsNode3 = semanticsNode2;
                SemanticsNode semanticsNode4 = semanticsNode;
                list2.add(Offset.m1342boximpl(OffsetKt.Offset(Math.abs(Offset.m1353getXimpl(semanticsNode4.getBoundsInRoot().m1383getCenterF1C5BW0()) - Offset.m1353getXimpl(semanticsNode3.getBoundsInRoot().m1383getCenterF1C5BW0())), Math.abs(Offset.m1354getYimpl(semanticsNode4.getBoundsInRoot().m1383getCenterF1C5BW0()) - Offset.m1354getYimpl(semanticsNode3.getBoundsInRoot().m1383getCenterF1C5BW0())))));
                semanticsNode = semanticsNode2;
            }
        }
        if (list2.size() == 1) {
            j = ((Offset) CollectionsKt.first(list2)).m1363unboximpl();
        } else if (!list2.isEmpty()) {
            Object first = CollectionsKt.first(list2);
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                int i2 = 1;
                while (true) {
                    int i3 = i2 + 1;
                    first = Offset.m1342boximpl(Offset.m1358plusMKHz9U(((Offset) first).m1363unboximpl(), ((Offset) list2.get(i2)).m1363unboximpl()));
                    if (i2 == lastIndex2) {
                        break;
                    }
                    i2 = i3;
                }
            }
            j = ((Offset) first).m1363unboximpl();
        } else {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        if (Offset.m1344component2impl(j) < Offset.m1343component1impl(j)) {
            return true;
        }
        return false;
    }

    private static final boolean isLazyCollection(CollectionInfo collectionInfo) {
        return collectionInfo.getRowCount() < 0 || collectionInfo.getColumnCount() < 0;
    }

    private static final AccessibilityNodeInfoCompat.CollectionInfoCompat toAccessibilityCollectionInfo(CollectionInfo collectionInfo) {
        return AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(collectionInfo.getRowCount(), collectionInfo.getColumnCount(), false, 0);
    }

    private static final AccessibilityNodeInfoCompat.CollectionItemInfoCompat toAccessibilityCollectionItemInfo(CollectionItemInfo collectionItemInfo, SemanticsNode semanticsNode) {
        return AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(collectionItemInfo.getRowIndex(), collectionItemInfo.getRowSpan(), collectionItemInfo.getColumnIndex(), collectionItemInfo.getColumnSpan(), false, ((Boolean) semanticsNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), CollectionInfoKt$toAccessibilityCollectionItemInfo$1.INSTANCE)).booleanValue());
    }
}
