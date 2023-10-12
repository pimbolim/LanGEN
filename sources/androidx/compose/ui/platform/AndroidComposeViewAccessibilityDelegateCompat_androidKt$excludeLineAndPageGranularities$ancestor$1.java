package androidx.compose.ui.platform;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsWrapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;", "invoke", "(Landroidx/compose/ui/node/LayoutNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
final class AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1 extends Lambda implements Function1<LayoutNode, Boolean> {
    public static final AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1 INSTANCE = new AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1();

    AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1() {
        super(1);
    }

    public final Boolean invoke(LayoutNode layoutNode) {
        boolean z;
        Intrinsics.checkNotNullParameter(layoutNode, "it");
        SemanticsWrapper outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
        SemanticsConfiguration collapsedSemanticsConfiguration = outerSemantics == null ? null : outerSemantics.collapsedSemanticsConfiguration();
        boolean z2 = false;
        if (collapsedSemanticsConfiguration != null && collapsedSemanticsConfiguration.isMergingSemanticsOfDescendants()) {
            z = true;
        } else {
            z = false;
        }
        if (z && collapsedSemanticsConfiguration.contains(SemanticsActions.INSTANCE.getSetText())) {
            z2 = true;
        }
        return Boolean.valueOf(z2);
    }
}
