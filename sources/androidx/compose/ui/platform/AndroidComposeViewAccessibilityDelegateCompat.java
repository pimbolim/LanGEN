package androidx.compose.ui.platform;

import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.collection.ArraySet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.R;
import androidx.compose.ui.TempListUtilsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.accessibility.CollectionInfoKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsWrapper;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 µ\u00012\u00020\u0001:\f³\u0001´\u0001µ\u0001¶\u0001·\u0001¸\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u0011\u0010J\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010KJ-\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020PH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bQ\u0010RJ;\u0010L\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180S2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020PH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001a\u00020\u0014H\u0002J\u0010\u0010W\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0006H\u0002J\u001d\u0010X\u001a\u00020Y2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0006H\u0001¢\u0006\u0002\b[J\u0012\u0010\\\u001a\u0004\u0018\u00010E2\u0006\u0010C\u001a\u00020\u0006H\u0002J=\u0010]\u001a\u00020Y2\u0006\u0010C\u001a\u00020\u00062\b\u0010^\u001a\u0004\u0018\u00010\u00062\b\u0010_\u001a\u0004\u0018\u00010\u00062\b\u0010`\u001a\u0004\u0018\u00010\u00062\b\u0010a\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0002\u0010bJ\u000e\u0010c\u001a\u00020\b2\u0006\u0010d\u001a\u00020eJ\u0010\u0010f\u001a\u00020'2\u0006\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020\u00062\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010l\u001a\u00020\u00062\u0006\u0010j\u001a\u00020kH\u0002J\u0014\u0010m\u001a\u0004\u0018\u00010G2\b\u0010j\u001a\u0004\u0018\u00010kH\u0002J\u001c\u0010n\u001a\u0004\u0018\u00010o2\b\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010p\u001a\u00020\u0006H\u0002J\u001d\u0010q\u001a\u00020\u00062\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020sH\u0001¢\u0006\u0002\buJ\u0010\u0010v\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0006H\u0002J\u0010\u0010w\u001a\u00020\b2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010x\u001a\u00020\u00142\u0006\u0010y\u001a\u00020?H\u0002J\u0015\u0010z\u001a\u00020\u00142\u0006\u0010y\u001a\u00020?H\u0000¢\u0006\u0002\b{J\r\u0010|\u001a\u00020\u0014H\u0000¢\u0006\u0002\b}J\"\u0010~\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J#\u0010\u0001\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u00062\u0007\u0010D\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020kH\u0007J\"\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\u00062\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u0002090\u0001H\u0002J\u0011\u0010\u0001\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0006H\u0002J\u0012\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\u0011\u0010\u0001\u001a\u00020\b2\u0006\u0010d\u001a\u00020YH\u0002J@\u0010\u0001\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u00062\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020G\u0018\u00010\u0001H\u0002¢\u0006\u0003\u0010\u0001J&\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010GH\u0002J\u0012\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u000209H\u0002J$\u0010\u0001\u001a\u00020\u00142\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0017H\u0001¢\u0006\u0003\b\u0001J\u001b\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020k2\u0007\u0010\u0001\u001a\u00020.H\u0002J \u0010\u0001\u001a\u00020\u00142\u0006\u0010y\u001a\u00020?2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060)H\u0002J,\u0010\u0001\u001a\u00020\b2\u0006\u0010j\u001a\u00020k2\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\bH\u0002J\u001a\u0010 \u0001\u001a\u00020\u00142\u0006\u0010j\u001a\u00020k2\u0007\u0010D\u001a\u00030\u0001H\u0002J\u001a\u0010¡\u0001\u001a\u00020\u00142\u0006\u0010j\u001a\u00020k2\u0007\u0010D\u001a\u00030\u0001H\u0002J!\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\t\u0010¤\u0001\u001a\u0004\u0018\u00010k2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0002J+\u0010§\u0001\u001a\u00020\b2\u0006\u0010j\u001a\u00020k2\u0006\u0010p\u001a\u00020\u00062\u0007\u0010¨\u0001\u001a\u00020\b2\u0007\u0010©\u0001\u001a\u00020\bH\u0002J3\u0010ª\u0001\u001a\u0005\u0018\u0001H«\u0001\"\t\b\u0000\u0010«\u0001*\u00020\u00112\t\u0010a\u001a\u0005\u0018\u0001H«\u00012\t\b\u0001\u0010¬\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0003\u0010­\u0001J\u0011\u0010®\u0001\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0006H\u0002J\t\u0010¯\u0001\u001a\u00020\u0014H\u0002J\u0011\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001*\u00030²\u0001H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u00178BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR \u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00170\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R0\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020.0-8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u00100\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u00106R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020908X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00140=X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0)X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006¹\u0001"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "accessibilityCursorPosition", "", "accessibilityForceEnabledForTesting", "", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "checkingForSemanticsChanges", "currentSemanticsNodes", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Ljava/util/Map;", "currentSemanticsNodesInvalidated", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "isAccessibilityEnabled", "labelToActionId", "nodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "paneDisplayed", "Landroidx/collection/ArraySet;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "previousSemanticsNodes", "", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "getPreviousSemanticsNodes$ui_release$annotations", "()V", "getPreviousSemanticsNodes$ui_release", "setPreviousSemanticsNodes$ui_release", "(Ljava/util/Map;)V", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scrollObservationScopes", "", "Landroidx/compose/ui/platform/ScrollObservationScope;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendScrollEventIfNeededLambda", "Lkotlin/Function1;", "subtreeChangedLayoutNodes", "Landroidx/compose/ui/node/LayoutNode;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "", "canScroll-moWRBKg$ui_release", "(Ljava/util/Collection;ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "Landroid/view/accessibility/AccessibilityEvent;", "eventType", "createEvent$ui_release", "createNodeInfo", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "getAccessibilityNodeProvider", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "getAccessibilitySelectionStart", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "", "requestAccessibilityFocus", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendScrollEventIfNeeded", "scrollObservationScope", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSemanticsPropertyChangeEvents$ui_release", "sendSemanticsStructureChangeEvents", "newNode", "oldNode", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setText", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getTextForTextField", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Api24Impl", "Api28Impl", "Companion", "MyNodeProvider", "PendingTextTraversedEvent", "SemanticsNodeCopy", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    private static final int[] AccessibilityActionsResourceIds = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final long SendRecurringAccessibilityEventsIntervalMillis = 100;
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    private final AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private int focusedVirtualViewId;
    /* access modifiers changed from: private */
    public final Handler handler;
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private SparseArrayCompat<Map<CharSequence, Integer>> labelToActionId;
    private AccessibilityNodeProviderCompat nodeProvider;
    private ArraySet<Integer> paneDisplayed;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private Map<Integer, SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final List<ScrollObservationScope> scrollObservationScopes;
    /* access modifiers changed from: private */
    public final Runnable semanticsChangeChecker;
    private final Function1<ScrollObservationScope, Unit> sendScrollEventIfNeededLambda;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AndroidComposeView view;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getPreviousSemanticsNodes$ui_release$annotations() {
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Companion;", "", "()V", "AccessibilityActionsResourceIds", "", "AccessibilityCursorPositionUndefined", "", "AccessibilitySliderStepsCount", "ClassName", "", "ExtraDataTestTagKey", "InvalidId", "LogTag", "ParcelSafeTextLength", "SendRecurringAccessibilityEventsIntervalMillis", "", "TextTraversedEventTimeoutMillis", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "view");
        this.view = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (AccessibilityManager) systemService;
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new MyNodeProvider(this));
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.actionIdToLabel = new SparseArrayCompat<>();
        this.labelToActionId = new SparseArrayCompat<>();
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>();
        this.boundsUpdateChannel = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = MapsKt.emptyMap();
        this.paneDisplayed = new ArraySet<>();
        this.previousSemanticsNodes = new LinkedHashMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), MapsKt.emptyMap());
        androidComposeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

            public void onViewAttachedToWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            {
                this.this$0 = r1;
            }

            public void onViewDetachedFromWindow(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.this$0.handler.removeCallbacks(this.this$0.semanticsChangeChecker);
            }
        });
        this.semanticsChangeChecker = new Runnable() {
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.m3400semanticsChangeChecker$lambda26(AndroidComposeViewAccessibilityDelegateCompat.this);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.sendScrollEventIfNeededLambda = new AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1(this);
    }

    public final int getHoveredVirtualViewId$ui_release() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final boolean getAccessibilityForceEnabledForTesting$ui_release() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z) {
        this.accessibilityForceEnabledForTesting = z;
    }

    private final boolean isAccessibilityEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i, int i2, int i3, int i4, long j) {
            Intrinsics.checkNotNullParameter(semanticsNode, "node");
            this.node = semanticsNode;
            this.action = i;
            this.granularity = i2;
            this.fromIndex = i3;
            this.toIndex = i4;
            this.traverseTime = j;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    private final Map<Integer, SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodes = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getAllUncoveredSemanticsNodesToMap(this.view.getSemanticsOwner());
            this.currentSemanticsNodesInvalidated = false;
        }
        return this.currentSemanticsNodes;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "currentSemanticsNodes", "", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/Map;)V", "children", "", "getChildren", "()Ljava/util/Set;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "hasPaneTitle", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public static final class SemanticsNodeCopy {
        private final Set<Integer> children = new LinkedHashSet();
        private final SemanticsConfiguration unmergedConfig;

        public SemanticsNodeCopy(SemanticsNode semanticsNode, Map<Integer, SemanticsNodeWithAdjustedBounds> map) {
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            Intrinsics.checkNotNullParameter(map, "currentSemanticsNodes");
            this.unmergedConfig = semanticsNode.getUnmergedConfig$ui_release();
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i);
                if (map.containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                    getChildren().add(Integer.valueOf(semanticsNode2.getId()));
                }
                i = i2;
            }
        }

        public final SemanticsConfiguration getUnmergedConfig() {
            return this.unmergedConfig;
        }

        public final Set<Integer> getChildren() {
            return this.children;
        }

        public final boolean hasPaneTitle() {
            return this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getPaneTitle());
        }
    }

    public final Map<Integer, SemanticsNodeCopy> getPreviousSemanticsNodes$ui_release() {
        return this.previousSemanticsNodes;
    }

    public final void setPreviousSemanticsNodes$ui_release(Map<Integer, SemanticsNodeCopy> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.previousSemanticsNodes = map;
    }

    /* renamed from: canScroll-0AR0LA0$ui_release  reason: not valid java name */
    public final boolean m3401canScroll0AR0LA0$ui_release(boolean z, int i, long j) {
        return m3402canScrollmoWRBKg$ui_release(getCurrentSemanticsNodes().values(), z, i, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b5 A[SYNTHETIC] */
    /* renamed from: canScroll-moWRBKg$ui_release  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m3402canScrollmoWRBKg$ui_release(java.util.Collection<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r6, boolean r7, int r8, long r9) {
        /*
            r5 = this;
            java.lang.String r0 = "currentSemanticsNodes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m1368getUnspecifiedF1C5BW0()
            boolean r0 = androidx.compose.ui.geometry.Offset.m1350equalsimpl0(r9, r0)
            r1 = 0
            if (r0 != 0) goto L_0x00bd
            boolean r0 = androidx.compose.ui.geometry.Offset.m1356isValidimpl(r9)
            if (r0 != 0) goto L_0x001a
            goto L_0x00bd
        L_0x001a:
            r0 = 1
            if (r7 != r0) goto L_0x0024
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getVerticalScrollAxisRange()
            goto L_0x002c
        L_0x0024:
            if (r7 != 0) goto L_0x00b7
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getHorizontalScrollAxisRange()
        L_0x002c:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r2 = r6
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0039
            goto L_0x00b6
        L_0x0039:
            java.util.Iterator r6 = r6.iterator()
        L_0x003d:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x00b6
            java.lang.Object r2 = r6.next()
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            android.graphics.Rect r3 = r2.getAdjustedBounds()
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.ui.graphics.RectHelper_androidKt.toComposeRect(r3)
            boolean r3 = r3.m1379containsk4lQ0M(r9)
            if (r3 != 0) goto L_0x0059
        L_0x0057:
            r2 = 0
            goto L_0x00b3
        L_0x0059:
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.getSemanticsNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r2.getConfig()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r7)
            androidx.compose.ui.semantics.ScrollAxisRange r2 = (androidx.compose.ui.semantics.ScrollAxisRange) r2
            if (r2 != 0) goto L_0x006a
            goto L_0x0057
        L_0x006a:
            boolean r3 = r2.getReverseScrolling()
            if (r3 == 0) goto L_0x0072
            int r3 = -r8
            goto L_0x0073
        L_0x0072:
            r3 = r8
        L_0x0073:
            if (r8 != 0) goto L_0x007c
            boolean r4 = r2.getReverseScrolling()
            if (r4 == 0) goto L_0x007c
            r3 = -1
        L_0x007c:
            if (r3 >= 0) goto L_0x0092
            kotlin.jvm.functions.Function0 r2 = r2.getValue()
            java.lang.Object r2 = r2.invoke()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0057
            goto L_0x00b2
        L_0x0092:
            kotlin.jvm.functions.Function0 r3 = r2.getValue()
            java.lang.Object r3 = r3.invoke()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.jvm.functions.Function0 r2 = r2.getMaxValue()
            java.lang.Object r2 = r2.invoke()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0057
        L_0x00b2:
            r2 = 1
        L_0x00b3:
            if (r2 == 0) goto L_0x003d
            r1 = 1
        L_0x00b6:
            return r1
        L_0x00b7:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x00bd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.m3402canScrollmoWRBKg$ui_release(java.util.Collection, boolean, int, long):boolean");
    }

    /* JADX WARNING: type inference failed for: r4v14, types: [android.view.ViewParent] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.accessibility.AccessibilityNodeInfo createNodeInfo(int r11) {
        /*
            r10 = this;
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r0 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.obtain()
            java.lang.String r1 = "obtain()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Map r1 = r10.getCurrentSemanticsNodes()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            java.lang.Object r1 = r1.get(r2)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r1 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r1
            r2 = 0
            if (r1 != 0) goto L_0x001e
            r0.recycle()
            return r2
        L_0x001e:
            androidx.compose.ui.semantics.SemanticsNode r3 = r1.getSemanticsNode()
            r4 = -1
            if (r11 != r4) goto L_0x0038
            androidx.compose.ui.platform.AndroidComposeView r4 = r10.view
            android.view.View r4 = (android.view.View) r4
            android.view.ViewParent r4 = androidx.core.view.ViewCompat.getParentForAccessibility(r4)
            boolean r5 = r4 instanceof android.view.View
            if (r5 == 0) goto L_0x0034
            r2 = r4
            android.view.View r2 = (android.view.View) r2
        L_0x0034:
            r0.setParent(r2)
            goto L_0x0062
        L_0x0038:
            androidx.compose.ui.semantics.SemanticsNode r2 = r3.getParent()
            if (r2 == 0) goto L_0x00c9
            androidx.compose.ui.semantics.SemanticsNode r2 = r3.getParent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r2 = r2.getId()
            androidx.compose.ui.platform.AndroidComposeView r5 = r10.view
            androidx.compose.ui.semantics.SemanticsOwner r5 = r5.getSemanticsOwner()
            androidx.compose.ui.semantics.SemanticsNode r5 = r5.getUnmergedRootSemanticsNode()
            int r5 = r5.getId()
            if (r2 != r5) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r4 = r2
        L_0x005b:
            androidx.compose.ui.platform.AndroidComposeView r2 = r10.view
            android.view.View r2 = (android.view.View) r2
            r0.setParent(r2, r4)
        L_0x0062:
            androidx.compose.ui.platform.AndroidComposeView r2 = r10.view
            android.view.View r2 = (android.view.View) r2
            r0.setSource(r2, r11)
            android.graphics.Rect r1 = r1.getAdjustedBounds()
            androidx.compose.ui.platform.AndroidComposeView r2 = r10.view
            int r4 = r1.left
            float r4 = (float) r4
            int r5 = r1.top
            float r5 = (float) r5
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r4, r5)
            long r4 = r2.m3394localToScreenMKHz9U(r4)
            androidx.compose.ui.platform.AndroidComposeView r2 = r10.view
            int r6 = r1.right
            float r6 = (float) r6
            int r1 = r1.bottom
            float r1 = (float) r1
            long r6 = androidx.compose.ui.geometry.OffsetKt.Offset(r6, r1)
            long r1 = r2.m3394localToScreenMKHz9U(r6)
            android.graphics.Rect r6 = new android.graphics.Rect
            float r7 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r4)
            double r7 = (double) r7
            double r7 = java.lang.Math.floor(r7)
            float r7 = (float) r7
            int r7 = (int) r7
            float r4 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r4)
            double r4 = (double) r4
            double r4 = java.lang.Math.floor(r4)
            float r4 = (float) r4
            int r4 = (int) r4
            float r5 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r1)
            double r8 = (double) r5
            double r8 = java.lang.Math.ceil(r8)
            float r5 = (float) r8
            int r5 = (int) r5
            float r1 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r1)
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            float r1 = (float) r1
            int r1 = (int) r1
            r6.<init>(r7, r4, r5, r1)
            r0.setBoundsInScreen(r6)
            r10.populateAccessibilityNodeInfoProperties(r11, r0, r3)
            android.view.accessibility.AccessibilityNodeInfo r11 = r0.unwrap()
            return r11
        L_0x00c9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "semanticsNode "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = " has null parent"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.createNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    public final void populateAccessibilityNodeInfoProperties(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
        SemanticsWrapper semanticsWrapper;
        boolean z;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        float f;
        String str;
        CharSequence charSequence;
        String str2;
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
        accessibilityNodeInfoCompat.setClassName(ClassName);
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
        String str3 = null;
        int i2 = 0;
        if (role != null) {
            int r3 = role.m3476unboximpl();
            if (semanticsNode.isFake$ui_release() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                if (role == null ? false : Role.m3473equalsimpl0(role.m3476unboximpl(), Role.Companion.m3482getTabo7Vup1c())) {
                    accessibilityNodeInfoCompat.setRoleDescription(getView().getContext().getResources().getString(R.string.tab));
                } else {
                    if (Role.m3473equalsimpl0(r3, Role.Companion.m3477getButtono7Vup1c())) {
                        str2 = "android.widget.Button";
                    } else if (Role.m3473equalsimpl0(r3, Role.Companion.m3478getCheckboxo7Vup1c())) {
                        str2 = "android.widget.CheckBox";
                    } else if (Role.m3473equalsimpl0(r3, Role.Companion.m3481getSwitcho7Vup1c())) {
                        str2 = "android.widget.Switch";
                    } else if (Role.m3473equalsimpl0(r3, Role.Companion.m3480getRadioButtono7Vup1c())) {
                        str2 = "android.widget.RadioButton";
                    } else {
                        str2 = Role.m3473equalsimpl0(r3, Role.Companion.m3479getImageo7Vup1c()) ? "android.widget.ImageView" : null;
                    }
                    if (!(role == null ? false : Role.m3473equalsimpl0(role.m3476unboximpl(), Role.Companion.m3479getImageo7Vup1c()))) {
                        accessibilityNodeInfoCompat.setClassName(str2);
                    } else if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(semanticsNode.getLayoutNode$ui_release(), AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$1$ancestor$1.INSTANCE) == null || semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
                        accessibilityNodeInfoCompat.setClassName(str2);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode)) {
            accessibilityNodeInfoCompat.setClassName("android.widget.EditText");
        }
        accessibilityNodeInfoCompat.setPackageName(this.view.getContext().getPackageName());
        List<SemanticsNode> replacedChildrenSortedByBounds$ui_release = semanticsNode.getReplacedChildrenSortedByBounds$ui_release();
        int size = replacedChildrenSortedByBounds$ui_release.size();
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            SemanticsNode semanticsNode2 = replacedChildrenSortedByBounds$ui_release.get(i3);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                AndroidViewHolder androidViewHolder = getView().getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(semanticsNode2.getLayoutNode$ui_release());
                if (androidViewHolder != null) {
                    accessibilityNodeInfoCompat.addChild(androidViewHolder);
                } else {
                    accessibilityNodeInfoCompat.addChild(getView(), semanticsNode2.getId());
                }
            }
            i3 = i4;
        }
        if (this.focusedVirtualViewId == i) {
            accessibilityNodeInfoCompat.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            accessibilityNodeInfoCompat.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode, accessibilityNodeInfoCompat);
        setContentInvalid(semanticsNode, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setStateDescription((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getStateDescription()));
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getToggleableState());
        int i5 = 2;
        if (toggleableState != null) {
            accessibilityNodeInfoCompat.setCheckable(true);
            int i6 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i6 == 1) {
                accessibilityNodeInfoCompat.setChecked(true);
                if ((role == null ? false : Role.m3473equalsimpl0(role.m3476unboximpl(), Role.Companion.m3481getSwitcho7Vup1c())) && accessibilityNodeInfoCompat.getStateDescription() == null) {
                    accessibilityNodeInfoCompat.setStateDescription(getView().getContext().getResources().getString(R.string.on));
                }
            } else if (i6 == 2) {
                accessibilityNodeInfoCompat.setChecked(false);
                if ((role == null ? false : Role.m3473equalsimpl0(role.m3476unboximpl(), Role.Companion.m3481getSwitcho7Vup1c())) && accessibilityNodeInfoCompat.getStateDescription() == null) {
                    accessibilityNodeInfoCompat.setStateDescription(getView().getContext().getResources().getString(R.string.off));
                }
            } else if (i6 == 3 && accessibilityNodeInfoCompat.getStateDescription() == null) {
                accessibilityNodeInfoCompat.setStateDescription(getView().getContext().getResources().getString(R.string.indeterminate));
            }
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (role == null ? false : Role.m3473equalsimpl0(role.m3476unboximpl(), Role.Companion.m3482getTabo7Vup1c())) {
                accessibilityNodeInfoCompat.setSelected(booleanValue);
            } else {
                accessibilityNodeInfoCompat.setCheckable(true);
                accessibilityNodeInfoCompat.setChecked(booleanValue);
                if (accessibilityNodeInfoCompat.getStateDescription() == null) {
                    if (booleanValue) {
                        charSequence = getView().getContext().getResources().getString(R.string.selected);
                    } else {
                        charSequence = getView().getContext().getResources().getString(R.string.not_selected);
                    }
                    accessibilityNodeInfoCompat.setStateDescription(charSequence);
                }
            }
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        if (!semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
            if (list == null) {
                str = null;
            } else {
                str = (String) CollectionsKt.firstOrNull(list);
            }
            accessibilityNodeInfoCompat.setContentDescription(str);
        }
        if (semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
            accessibilityNodeInfoCompat.setScreenReaderFocusable(true);
        }
        if (((Unit) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHeading())) != null) {
            accessibilityNodeInfoCompat.setHeading(true);
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setPassword(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNode));
        accessibilityNodeInfoCompat.setEditable(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode));
        accessibilityNodeInfoCompat.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode));
        accessibilityNodeInfoCompat.setFocusable(semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getFocused()));
        if (accessibilityNodeInfoCompat.isFocusable()) {
            accessibilityNodeInfoCompat.setFocused(((Boolean) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getFocused())).booleanValue());
            if (accessibilityNodeInfoCompat.isFocused()) {
                accessibilityNodeInfoCompat.addAction(2);
            } else {
                accessibilityNodeInfoCompat.addAction(1);
            }
        }
        if (semanticsNode.isFake$ui_release()) {
            SemanticsNode parent = semanticsNode.getParent();
            semanticsWrapper = parent == null ? null : parent.findWrapperToGetBounds$ui_release();
        } else {
            semanticsWrapper = semanticsNode.findWrapperToGetBounds$ui_release();
        }
        if (semanticsWrapper == null) {
            z = false;
        } else {
            z = semanticsWrapper.isTransparent();
        }
        accessibilityNodeInfoCompat.setVisibleToUser(!z && SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getInvisibleToUser()) == null);
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getLiveRegion());
        if (liveRegionMode != null) {
            int r0 = liveRegionMode.m3467unboximpl();
            if (LiveRegionMode.m3464equalsimpl0(r0, LiveRegionMode.Companion.m3469getPolite0phEisY()) || !LiveRegionMode.m3464equalsimpl0(r0, LiveRegionMode.Companion.m3468getAssertive0phEisY())) {
                i5 = 1;
            }
            accessibilityNodeInfoCompat.setLiveRegion(i5);
            Unit unit9 = Unit.INSTANCE;
            Unit unit10 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setClickable(false);
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnClick());
        if (accessibilityAction != null) {
            boolean areEqual = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getSelected()), (Object) true);
            accessibilityNodeInfoCompat.setClickable(!areEqual);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && !areEqual) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
            }
            Unit unit11 = Unit.INSTANCE;
            Unit unit12 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat.setLongClickable(false);
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getOnLongClick());
        if (accessibilityAction2 != null) {
            accessibilityNodeInfoCompat.setLongClickable(true);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, accessibilityAction2.getLabel()));
            }
            Unit unit13 = Unit.INSTANCE;
            Unit unit14 = Unit.INSTANCE;
        }
        AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCopyText());
        if (accessibilityAction3 != null) {
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, accessibilityAction3.getLabel()));
            Unit unit15 = Unit.INSTANCE;
            Unit unit16 = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetText());
            if (accessibilityAction4 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, accessibilityAction4.getLabel()));
                Unit unit17 = Unit.INSTANCE;
                Unit unit18 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCutText());
            if (accessibilityAction5 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, accessibilityAction5.getLabel()));
                Unit unit19 = Unit.INSTANCE;
                Unit unit20 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getPasteText());
            if (accessibilityAction6 != null) {
                if (accessibilityNodeInfoCompat.isFocused() && getView().getClipboardManager().hasText()) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, accessibilityAction6.getLabel()));
                }
                Unit unit21 = Unit.INSTANCE;
                Unit unit22 = Unit.INSTANCE;
            }
        }
        CharSequence iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (!(iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0)) {
            accessibilityNodeInfoCompat.setTextSelection(getAccessibilitySelectionStart(semanticsNode), getAccessibilitySelectionEnd(semanticsNode));
            AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetSelection());
            if (accessibilityAction7 != null) {
                str3 = accessibilityAction7.getLabel();
            }
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, str3));
            accessibilityNodeInfoCompat.addAction(256);
            accessibilityNodeInfoCompat.addAction(512);
            accessibilityNodeInfoCompat.setMovementGranularities(11);
            Collection collection = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getContentDescription());
            if ((collection == null || collection.isEmpty()) && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode)) {
                accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat.getMovementGranularities() | 4 | 16);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            List arrayList = new ArrayList();
            CharSequence text = accessibilityNodeInfoCompat.getText();
            if (!(text == null || text.length() == 0) && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag())) {
                arrayList.add(ExtraDataTestTagKey);
            }
            if (!arrayList.isEmpty()) {
                AccessibilityNodeInfoVerificationHelperMethods accessibilityNodeInfoVerificationHelperMethods = AccessibilityNodeInfoVerificationHelperMethods.INSTANCE;
                AccessibilityNodeInfo unwrap = accessibilityNodeInfoCompat.unwrap();
                Intrinsics.checkNotNullExpressionValue(unwrap, "info.unwrap()");
                accessibilityNodeInfoVerificationHelperMethods.setAvailableExtraData(unwrap, arrayList);
            }
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress())) {
                accessibilityNodeInfoCompat.setClassName("android.widget.SeekBar");
            } else {
                accessibilityNodeInfoCompat.setClassName("android.widget.ProgressBar");
            }
            if (progressBarRangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getCurrent()));
                if (accessibilityNodeInfoCompat.getStateDescription() == null) {
                    ClosedFloatingPointRange<Float> range = progressBarRangeInfo.getRange();
                    if (range.getEndInclusive().floatValue() - range.getStart().floatValue() == 0.0f) {
                        f = 0.0f;
                    } else {
                        f = (progressBarRangeInfo.getCurrent() - range.getStart().floatValue()) / (range.getEndInclusive().floatValue() - range.getStart().floatValue());
                    }
                    float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
                    int i7 = 100;
                    if (coerceIn == 0.0f) {
                        i7 = 0;
                    } else {
                        if (!(coerceIn == 1.0f)) {
                            i7 = RangesKt.coerceIn(MathKt.roundToInt(coerceIn * ((float) 100)), 1, 99);
                        }
                    }
                    accessibilityNodeInfoCompat.setStateDescription(this.view.getContext().getResources().getString(R.string.template_percent, new Object[]{Integer.valueOf(i7)}));
                }
            } else if (accessibilityNodeInfoCompat.getStateDescription() == null) {
                accessibilityNodeInfoCompat.setStateDescription(this.view.getContext().getResources().getString(R.string.in_progress));
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetProgress()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (progressBarRangeInfo.getCurrent() < RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                }
                if (progressBarRangeInfo.getCurrent() > RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue())) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.Companion.addSetProgressAction(accessibilityNodeInfoCompat, semanticsNode);
        }
        CollectionInfoKt.setCollectionInfo(semanticsNode, accessibilityNodeInfoCompat);
        CollectionInfoKt.setCollectionItemInfo(semanticsNode, accessibilityNodeInfoCompat);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
        AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getScrollBy());
        if (!(scrollAxisRange == null || accessibilityAction8 == null)) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.HorizontalScrollView");
            }
            if (scrollAxisRange.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    } else {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    }
                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    } else {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    }
                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                }
            }
        }
        ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        if (!(scrollAxisRange2 == null || accessibilityAction8 == null)) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
            }
            if (scrollAxisRange2.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        accessibilityNodeInfoCompat.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getPaneTitle()));
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getExpand());
            if (accessibilityAction9 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, accessibilityAction9.getLabel()));
                Unit unit23 = Unit.INSTANCE;
                Unit unit24 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getCollapse());
            if (accessibilityAction10 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, accessibilityAction10.getLabel()));
                Unit unit25 = Unit.INSTANCE;
                Unit unit26 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getDismiss());
            if (accessibilityAction11 != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, accessibilityAction11.getLabel()));
                Unit unit27 = Unit.INSTANCE;
                Unit unit28 = Unit.INSTANCE;
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getCustomActions())) {
                List list2 = (List) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getCustomActions());
                int size2 = list2.size();
                int[] iArr = AccessibilityActionsResourceIds;
                if (size2 < iArr.length) {
                    SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
                    Map linkedHashMap = new LinkedHashMap();
                    if (this.labelToActionId.containsKey(i)) {
                        Map map = this.labelToActionId.get(i);
                        List<Integer> mutableList = ArraysKt.toMutableList(iArr);
                        List arrayList2 = new ArrayList();
                        int size3 = list2.size();
                        int i8 = 0;
                        while (i8 < size3) {
                            int i9 = i8 + 1;
                            CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list2.get(i8);
                            Intrinsics.checkNotNull(map);
                            if (map.containsKey(customAccessibilityAction.getLabel())) {
                                Integer num = (Integer) map.get(customAccessibilityAction.getLabel());
                                Intrinsics.checkNotNull(num);
                                sparseArrayCompat.put(num.intValue(), customAccessibilityAction.getLabel());
                                linkedHashMap.put(customAccessibilityAction.getLabel(), num);
                                mutableList.remove(num);
                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(num.intValue(), customAccessibilityAction.getLabel()));
                            } else {
                                arrayList2.add(customAccessibilityAction);
                            }
                            i8 = i9;
                        }
                        int size4 = arrayList2.size();
                        while (i2 < size4) {
                            int i10 = i2 + 1;
                            CustomAccessibilityAction customAccessibilityAction2 = (CustomAccessibilityAction) arrayList2.get(i2);
                            int intValue = mutableList.get(i2).intValue();
                            sparseArrayCompat.put(intValue, customAccessibilityAction2.getLabel());
                            linkedHashMap.put(customAccessibilityAction2.getLabel(), Integer.valueOf(intValue));
                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(intValue, customAccessibilityAction2.getLabel()));
                            i2 = i10;
                        }
                    } else {
                        int size5 = list2.size();
                        while (i2 < size5) {
                            int i11 = i2 + 1;
                            CustomAccessibilityAction customAccessibilityAction3 = (CustomAccessibilityAction) list2.get(i2);
                            int i12 = AccessibilityActionsResourceIds[i2];
                            sparseArrayCompat.put(i12, customAccessibilityAction3.getLabel());
                            linkedHashMap.put(customAccessibilityAction3.getLabel(), Integer.valueOf(i12));
                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i12, customAccessibilityAction3.getLabel()));
                            i2 = i11;
                        }
                    }
                    this.actionIdToLabel.put(i, sparseArrayCompat);
                    this.labelToActionId.put(i, linkedHashMap);
                    return;
                }
                throw new IllegalStateException("Can't have more than " + iArr.length + " custom actions for one widget");
            }
        }
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && scrollAxisRange.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && scrollAxisRange.getReverseScrolling());
    }

    private final void setContentInvalid(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getError())) {
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final void setText(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SpannableString spannableString;
        AnnotatedString annotatedString;
        AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
        SpannableString spannableString2 = null;
        if (textForTextField == null) {
            spannableString = null;
        } else {
            spannableString = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(textForTextField, this.view.getDensity(), this.view.getFontLoader());
        }
        SpannableString spannableString3 = (SpannableString) trimToSize(spannableString, ParcelSafeTextLength);
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (!(list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null)) {
            spannableString2 = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), this.view.getFontLoader());
        }
        accessibilityNodeInfoCompat.setText(spannableString3 == null ? (SpannableString) trimToSize(spannableString2, ParcelSafeTextLength) : spannableString3);
    }

    private final boolean isAccessibilityFocused(int i) {
        return this.focusedVirtualViewId == i;
    }

    private final boolean requestAccessibilityFocus(int i) {
        if (!isAccessibilityEnabled() || isAccessibilityFocused(i)) {
            return false;
        }
        int i2 = this.focusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i2, 65536, (Integer) null, (List) null, 12, (Object) null);
        }
        this.focusedVirtualViewId = i;
        this.view.invalidate();
        sendEventForVirtualView$default(this, i, 32768, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int i, int i2, Integer num, List<String> list) {
        if (i == Integer.MIN_VALUE || !isAccessibilityEnabled()) {
            return false;
        }
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(i, i2);
        if (num != null) {
            createEvent$ui_release.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            createEvent$ui_release.setContentDescription(TempListUtilsKt.fastJoinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        return sendEvent(createEvent$ui_release);
    }

    /* access modifiers changed from: private */
    public final boolean sendEvent(AccessibilityEvent accessibilityEvent) {
        if (!isAccessibilityEnabled()) {
            return false;
        }
        return this.view.getParent().requestSendAccessibilityEvent(this.view, accessibilityEvent);
    }

    public final AccessibilityEvent createEvent$ui_release(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain(eventType)");
        obtain.setEnabled(true);
        obtain.setClassName(ClassName);
        obtain.setPackageName(this.view.getContext().getPackageName());
        obtain.setSource(this.view, i);
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i));
        if (semanticsNodeWithAdjustedBounds != null) {
            obtain.setPassword(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode()));
        }
        return obtain;
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int i, Integer num, Integer num2, Integer num3, String str) {
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(i, 8192);
        if (num != null) {
            createEvent$ui_release.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            createEvent$ui_release.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            createEvent$ui_release.setItemCount(num3.intValue());
        }
        if (str != null) {
            createEvent$ui_release.getText().add(str);
        }
        return createEvent$ui_release;
    }

    private final boolean clearAccessibilityFocus(int i) {
        if (!isAccessibilityFocused(i)) {
            return false;
        }
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.view.invalidate();
        sendEventForVirtualView$default(this, i, 65536, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: androidx.compose.ui.geometry.Offset} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: type inference failed for: r1v32, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* JADX WARNING: type inference failed for: r1v36 */
    /* JADX WARNING: type inference failed for: r1v39 */
    /* JADX WARNING: type inference failed for: r1v40 */
    /* JADX WARNING: type inference failed for: r1v41 */
    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0111 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f3 A[ADDED_TO_REGION] */
    public final boolean performActionHelper(int r12, int r13, android.os.Bundle r14) {
        /*
            r11 = this;
            java.util.Map r0 = r11.getCurrentSemanticsNodes()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            java.lang.Object r0 = r0.get(r1)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r0 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r0
            r1 = 0
            if (r0 != 0) goto L_0x0013
            r0 = r1
            goto L_0x0017
        L_0x0013:
            androidx.compose.ui.semantics.SemanticsNode r0 = r0.getSemanticsNode()
        L_0x0017:
            r2 = 0
            if (r0 != 0) goto L_0x001b
            return r2
        L_0x001b:
            r3 = 64
            if (r13 == r3) goto L_0x05c7
            r3 = 128(0x80, float:1.794E-43)
            if (r13 == r3) goto L_0x05c2
            r3 = 256(0x100, float:3.59E-43)
            r4 = 1
            if (r13 == r3) goto L_0x05ab
            r5 = 512(0x200, float:7.175E-43)
            if (r13 == r5) goto L_0x05ab
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r13 == r3) goto L_0x0581
            r3 = 131072(0x20000, float:1.83671E-40)
            if (r13 == r3) goto L_0x0554
            boolean r3 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(r0)
            if (r3 != 0) goto L_0x003b
            return r2
        L_0x003b:
            if (r13 == r4) goto L_0x0523
            r3 = 2
            if (r13 == r3) goto L_0x0500
            switch(r13) {
                case 16: goto L_0x04ca;
                case 32: goto L_0x04a0;
                case 4096: goto L_0x02fc;
                case 8192: goto L_0x02fc;
                case 32768: goto L_0x02d2;
                case 65536: goto L_0x02a8;
                case 262144: goto L_0x027e;
                case 524288: goto L_0x0254;
                case 1048576: goto L_0x022a;
                case 2097152: goto L_0x01e8;
                case 16908342: goto L_0x00d6;
                case 16908349: goto L_0x0099;
                default: goto L_0x0043;
            }
        L_0x0043:
            switch(r13) {
                case 16908344: goto L_0x02fc;
                case 16908345: goto L_0x02fc;
                case 16908346: goto L_0x02fc;
                case 16908347: goto L_0x02fc;
                default: goto L_0x0046;
            }
        L_0x0046:
            androidx.collection.SparseArrayCompat<androidx.collection.SparseArrayCompat<java.lang.CharSequence>> r14 = r11.actionIdToLabel
            java.lang.Object r12 = r14.get(r12)
            androidx.collection.SparseArrayCompat r12 = (androidx.collection.SparseArrayCompat) r12
            if (r12 != 0) goto L_0x0051
            goto L_0x0058
        L_0x0051:
            java.lang.Object r12 = r12.get(r13)
            r1 = r12
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
        L_0x0058:
            if (r1 != 0) goto L_0x005b
            return r2
        L_0x005b:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r13 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getCustomActions()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            java.util.List r12 = (java.util.List) r12
            if (r12 != 0) goto L_0x006e
            return r2
        L_0x006e:
            int r13 = r12.size()
            r14 = 0
        L_0x0073:
            if (r14 >= r13) goto L_0x0098
            int r0 = r14 + 1
            java.lang.Object r14 = r12.get(r14)
            androidx.compose.ui.semantics.CustomAccessibilityAction r14 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r14
            java.lang.String r3 = r14.getLabel()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x0096
            kotlin.jvm.functions.Function0 r12 = r14.getAction()
            java.lang.Object r12 = r12.invoke()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            return r12
        L_0x0096:
            r14 = r0
            goto L_0x0073
        L_0x0098:
            return r2
        L_0x0099:
            if (r14 == 0) goto L_0x00d5
            java.lang.String r12 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"
            boolean r13 = r14.containsKey(r12)
            if (r13 != 0) goto L_0x00a4
            goto L_0x00d5
        L_0x00a4:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r0 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r0 = r0.getSetProgress()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r0)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 != 0) goto L_0x00b7
            goto L_0x00d5
        L_0x00b7:
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            if (r13 != 0) goto L_0x00c0
            goto L_0x00d5
        L_0x00c0:
            float r12 = r14.getFloat(r12)
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Object r12 = r13.invoke(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x00d1
            goto L_0x00d5
        L_0x00d1:
            boolean r2 = r12.booleanValue()
        L_0x00d5:
            return r2
        L_0x00d6:
            androidx.compose.ui.semantics.SemanticsNode r12 = r0.getParent()
            if (r12 != 0) goto L_0x00de
        L_0x00dc:
            r13 = r1
            goto L_0x00f1
        L_0x00de:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r12.getConfig()
            if (r13 != 0) goto L_0x00e5
            goto L_0x00dc
        L_0x00e5:
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getScrollBy()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
        L_0x00f1:
            if (r12 == 0) goto L_0x0111
            if (r13 == 0) goto L_0x00f6
            goto L_0x0111
        L_0x00f6:
            androidx.compose.ui.semantics.SemanticsNode r12 = r12.getParent()
            if (r12 != 0) goto L_0x00fd
            goto L_0x00dc
        L_0x00fd:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r12.getConfig()
            if (r13 != 0) goto L_0x0104
            goto L_0x00dc
        L_0x0104:
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getScrollBy()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            goto L_0x00f1
        L_0x0111:
            if (r12 != 0) goto L_0x0114
            return r2
        L_0x0114:
            androidx.compose.ui.layout.LayoutInfo r14 = r12.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r14 = r14.getCoordinates()
            androidx.compose.ui.geometry.Rect r14 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r14)
            androidx.compose.ui.layout.LayoutInfo r3 = r12.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r3 = r3.getCoordinates()
            androidx.compose.ui.layout.LayoutCoordinates r3 = r3.getParentLayoutCoordinates()
            if (r3 != 0) goto L_0x012f
            goto L_0x0137
        L_0x012f:
            long r5 = androidx.compose.ui.layout.LayoutCoordinatesKt.positionInRoot(r3)
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m1342boximpl(r5)
        L_0x0137:
            if (r1 != 0) goto L_0x0140
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r5 = r1.m1369getZeroF1C5BW0()
            goto L_0x0144
        L_0x0140:
            long r5 = r1.m1363unboximpl()
        L_0x0144:
            androidx.compose.ui.geometry.Rect r14 = r14.m1390translatek4lQ0M(r5)
            long r5 = r0.m3484getPositionInRootF1C5BW0()
            long r7 = r0.m3486getSizeYbymL2g()
            long r7 = androidx.compose.ui.unit.IntSizeKt.m4029toSizeozmzZPI(r7)
            androidx.compose.ui.geometry.Rect r1 = androidx.compose.ui.geometry.RectKt.m1393Recttz77jQw(r5, r7)
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r12.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r5 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getHorizontalScrollAxisRange()
            java.lang.Object r3 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r3, r5)
            androidx.compose.ui.semantics.ScrollAxisRange r3 = (androidx.compose.ui.semantics.ScrollAxisRange) r3
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r12.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r5 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getVerticalScrollAxisRange()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r5)
            androidx.compose.ui.semantics.ScrollAxisRange r12 = (androidx.compose.ui.semantics.ScrollAxisRange) r12
            float r5 = r1.getLeft()
            float r6 = r14.getLeft()
            float r5 = r5 - r6
            float r6 = r1.getRight()
            float r7 = r14.getRight()
            float r6 = r6 - r7
            float r5 = performActionHelper$scrollDelta(r5, r6)
            if (r3 != 0) goto L_0x0192
        L_0x0190:
            r3 = 0
            goto L_0x0199
        L_0x0192:
            boolean r3 = r3.getReverseScrolling()
            if (r3 != r4) goto L_0x0190
            r3 = 1
        L_0x0199:
            if (r3 == 0) goto L_0x019c
            float r5 = -r5
        L_0x019c:
            boolean r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(r0)
            if (r0 == 0) goto L_0x01a3
            float r5 = -r5
        L_0x01a3:
            float r0 = r1.getTop()
            float r3 = r14.getTop()
            float r0 = r0 - r3
            float r1 = r1.getBottom()
            float r14 = r14.getBottom()
            float r1 = r1 - r14
            float r14 = performActionHelper$scrollDelta(r0, r1)
            if (r12 != 0) goto L_0x01bd
        L_0x01bb:
            r4 = 0
            goto L_0x01c3
        L_0x01bd:
            boolean r12 = r12.getReverseScrolling()
            if (r12 != r4) goto L_0x01bb
        L_0x01c3:
            if (r4 == 0) goto L_0x01c6
            float r14 = -r14
        L_0x01c6:
            if (r13 != 0) goto L_0x01c9
            goto L_0x01e7
        L_0x01c9:
            kotlin.Function r12 = r13.getAction()
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            if (r12 != 0) goto L_0x01d2
            goto L_0x01e7
        L_0x01d2:
            java.lang.Float r13 = java.lang.Float.valueOf(r5)
            java.lang.Float r14 = java.lang.Float.valueOf(r14)
            java.lang.Object r12 = r12.invoke(r13, r14)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x01e3
            goto L_0x01e7
        L_0x01e3:
            boolean r2 = r12.booleanValue()
        L_0x01e7:
            return r2
        L_0x01e8:
            if (r14 != 0) goto L_0x01eb
            goto L_0x01f1
        L_0x01eb:
            java.lang.String r12 = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE"
            java.lang.String r1 = r14.getString(r12)
        L_0x01f1:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r13 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getSetText()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            androidx.compose.ui.semantics.AccessibilityAction r12 = (androidx.compose.ui.semantics.AccessibilityAction) r12
            if (r12 != 0) goto L_0x0204
            goto L_0x0229
        L_0x0204:
            kotlin.Function r12 = r12.getAction()
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            if (r12 != 0) goto L_0x020d
            goto L_0x0229
        L_0x020d:
            androidx.compose.ui.text.AnnotatedString r13 = new androidx.compose.ui.text.AnnotatedString
            if (r1 != 0) goto L_0x0213
            java.lang.String r1 = ""
        L_0x0213:
            r4 = r1
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r12 = r12.invoke(r13)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x0225
            goto L_0x0229
        L_0x0225:
            boolean r2 = r12.booleanValue()
        L_0x0229:
            return r2
        L_0x022a:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r13 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getDismiss()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            androidx.compose.ui.semantics.AccessibilityAction r12 = (androidx.compose.ui.semantics.AccessibilityAction) r12
            if (r12 != 0) goto L_0x023d
            goto L_0x0253
        L_0x023d:
            kotlin.Function r12 = r12.getAction()
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            if (r12 != 0) goto L_0x0246
            goto L_0x0253
        L_0x0246:
            java.lang.Object r12 = r12.invoke()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x024f
            goto L_0x0253
        L_0x024f:
            boolean r2 = r12.booleanValue()
        L_0x0253:
            return r2
        L_0x0254:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r13 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getCollapse()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            androidx.compose.ui.semantics.AccessibilityAction r12 = (androidx.compose.ui.semantics.AccessibilityAction) r12
            if (r12 != 0) goto L_0x0267
            goto L_0x027d
        L_0x0267:
            kotlin.Function r12 = r12.getAction()
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            if (r12 != 0) goto L_0x0270
            goto L_0x027d
        L_0x0270:
            java.lang.Object r12 = r12.invoke()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x0279
            goto L_0x027d
        L_0x0279:
            boolean r2 = r12.booleanValue()
        L_0x027d:
            return r2
        L_0x027e:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r13 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getExpand()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            androidx.compose.ui.semantics.AccessibilityAction r12 = (androidx.compose.ui.semantics.AccessibilityAction) r12
            if (r12 != 0) goto L_0x0291
            goto L_0x02a7
        L_0x0291:
            kotlin.Function r12 = r12.getAction()
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            if (r12 != 0) goto L_0x029a
            goto L_0x02a7
        L_0x029a:
            java.lang.Object r12 = r12.invoke()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x02a3
            goto L_0x02a7
        L_0x02a3:
            boolean r2 = r12.booleanValue()
        L_0x02a7:
            return r2
        L_0x02a8:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r13 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getCutText()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            androidx.compose.ui.semantics.AccessibilityAction r12 = (androidx.compose.ui.semantics.AccessibilityAction) r12
            if (r12 != 0) goto L_0x02bb
            goto L_0x02d1
        L_0x02bb:
            kotlin.Function r12 = r12.getAction()
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            if (r12 != 0) goto L_0x02c4
            goto L_0x02d1
        L_0x02c4:
            java.lang.Object r12 = r12.invoke()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x02cd
            goto L_0x02d1
        L_0x02cd:
            boolean r2 = r12.booleanValue()
        L_0x02d1:
            return r2
        L_0x02d2:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r13 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getPasteText()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            androidx.compose.ui.semantics.AccessibilityAction r12 = (androidx.compose.ui.semantics.AccessibilityAction) r12
            if (r12 != 0) goto L_0x02e5
            goto L_0x02fb
        L_0x02e5:
            kotlin.Function r12 = r12.getAction()
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            if (r12 != 0) goto L_0x02ee
            goto L_0x02fb
        L_0x02ee:
            java.lang.Object r12 = r12.invoke()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x02f7
            goto L_0x02fb
        L_0x02f7:
            boolean r2 = r12.booleanValue()
        L_0x02fb:
            return r2
        L_0x02fc:
            r12 = 4096(0x1000, float:5.74E-42)
            if (r13 != r12) goto L_0x0302
            r12 = 1
            goto L_0x0303
        L_0x0302:
            r12 = 0
        L_0x0303:
            r14 = 8192(0x2000, float:1.14794E-41)
            if (r13 != r14) goto L_0x0309
            r14 = 1
            goto L_0x030a
        L_0x0309:
            r14 = 0
        L_0x030a:
            r1 = 16908345(0x1020039, float:2.387739E-38)
            if (r13 != r1) goto L_0x0311
            r1 = 1
            goto L_0x0312
        L_0x0311:
            r1 = 0
        L_0x0312:
            r3 = 16908347(0x102003b, float:2.3877394E-38)
            if (r13 != r3) goto L_0x0319
            r3 = 1
            goto L_0x031a
        L_0x0319:
            r3 = 0
        L_0x031a:
            r5 = 16908344(0x1020038, float:2.3877386E-38)
            if (r13 != r5) goto L_0x0321
            r5 = 1
            goto L_0x0322
        L_0x0321:
            r5 = 0
        L_0x0322:
            r6 = 16908346(0x102003a, float:2.3877392E-38)
            if (r13 != r6) goto L_0x0329
            r13 = 1
            goto L_0x032a
        L_0x0329:
            r13 = 0
        L_0x032a:
            if (r1 != 0) goto L_0x0335
            if (r3 != 0) goto L_0x0335
            if (r12 != 0) goto L_0x0335
            if (r14 == 0) goto L_0x0333
            goto L_0x0335
        L_0x0333:
            r6 = 0
            goto L_0x0336
        L_0x0335:
            r6 = 1
        L_0x0336:
            if (r5 != 0) goto L_0x0341
            if (r13 != 0) goto L_0x0341
            if (r12 != 0) goto L_0x0341
            if (r14 == 0) goto L_0x033f
            goto L_0x0341
        L_0x033f:
            r13 = 0
            goto L_0x0342
        L_0x0341:
            r13 = 1
        L_0x0342:
            if (r12 != 0) goto L_0x0346
            if (r14 == 0) goto L_0x03df
        L_0x0346:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getProgressBarRangeInfo()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r7)
            androidx.compose.ui.semantics.ProgressBarRangeInfo r12 = (androidx.compose.ui.semantics.ProgressBarRangeInfo) r12
            androidx.compose.ui.semantics.SemanticsConfiguration r7 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r8 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r8 = r8.getSetProgress()
            java.lang.Object r7 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r7, r8)
            androidx.compose.ui.semantics.AccessibilityAction r7 = (androidx.compose.ui.semantics.AccessibilityAction) r7
            if (r12 == 0) goto L_0x03df
            if (r7 == 0) goto L_0x03df
            kotlin.ranges.ClosedFloatingPointRange r13 = r12.getRange()
            java.lang.Comparable r13 = r13.getEndInclusive()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r0 = r12.getRange()
            java.lang.Comparable r0 = r0.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r13 = kotlin.ranges.RangesKt.coerceAtLeast((float) r13, (float) r0)
            kotlin.ranges.ClosedFloatingPointRange r0 = r12.getRange()
            java.lang.Comparable r0 = r0.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r1 = r12.getRange()
            java.lang.Comparable r1 = r1.getEndInclusive()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            float r0 = kotlin.ranges.RangesKt.coerceAtMost((float) r0, (float) r1)
            int r1 = r12.getSteps()
            if (r1 <= 0) goto L_0x03b7
            float r13 = r13 - r0
            int r0 = r12.getSteps()
            int r0 = r0 + r4
            goto L_0x03ba
        L_0x03b7:
            float r13 = r13 - r0
            r0 = 20
        L_0x03ba:
            float r0 = (float) r0
            float r13 = r13 / r0
            if (r14 == 0) goto L_0x03bf
            float r13 = -r13
        L_0x03bf:
            kotlin.Function r14 = r7.getAction()
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            if (r14 != 0) goto L_0x03c8
            goto L_0x03de
        L_0x03c8:
            float r12 = r12.getCurrent()
            float r12 = r12 + r13
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Object r12 = r14.invoke(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x03da
            goto L_0x03de
        L_0x03da:
            boolean r2 = r12.booleanValue()
        L_0x03de:
            return r2
        L_0x03df:
            androidx.compose.ui.layout.LayoutInfo r12 = r0.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r12 = r12.getCoordinates()
            androidx.compose.ui.geometry.Rect r12 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r12)
            long r7 = r12.m1386getSizeNHjbRc()
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r4 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getScrollBy()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r4)
            androidx.compose.ui.semantics.AccessibilityAction r12 = (androidx.compose.ui.semantics.AccessibilityAction) r12
            if (r12 != 0) goto L_0x0402
            return r2
        L_0x0402:
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r9 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r9 = r9.getHorizontalScrollAxisRange()
            java.lang.Object r4 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r4, r9)
            androidx.compose.ui.semantics.ScrollAxisRange r4 = (androidx.compose.ui.semantics.ScrollAxisRange) r4
            r9 = 0
            if (r4 == 0) goto L_0x0457
            if (r6 == 0) goto L_0x0457
            float r6 = androidx.compose.ui.geometry.Size.m1422getWidthimpl(r7)
            if (r1 != 0) goto L_0x041f
            if (r14 == 0) goto L_0x0420
        L_0x041f:
            float r6 = -r6
        L_0x0420:
            boolean r10 = r4.getReverseScrolling()
            if (r10 == 0) goto L_0x0427
            float r6 = -r6
        L_0x0427:
            boolean r10 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(r0)
            if (r10 == 0) goto L_0x0432
            if (r1 != 0) goto L_0x0431
            if (r3 == 0) goto L_0x0432
        L_0x0431:
            float r6 = -r6
        L_0x0432:
            boolean r1 = performActionHelper$canScroll(r4, r6)
            if (r1 == 0) goto L_0x0457
            kotlin.Function r12 = r12.getAction()
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            if (r12 != 0) goto L_0x0441
            goto L_0x0456
        L_0x0441:
            java.lang.Float r13 = java.lang.Float.valueOf(r6)
            java.lang.Float r14 = java.lang.Float.valueOf(r9)
            java.lang.Object r12 = r12.invoke(r13, r14)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x0452
            goto L_0x0456
        L_0x0452:
            boolean r2 = r12.booleanValue()
        L_0x0456:
            return r2
        L_0x0457:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getVerticalScrollAxisRange()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.ScrollAxisRange r0 = (androidx.compose.ui.semantics.ScrollAxisRange) r0
            if (r0 == 0) goto L_0x049f
            if (r13 == 0) goto L_0x049f
            float r13 = androidx.compose.ui.geometry.Size.m1419getHeightimpl(r7)
            if (r5 != 0) goto L_0x0473
            if (r14 == 0) goto L_0x0474
        L_0x0473:
            float r13 = -r13
        L_0x0474:
            boolean r14 = r0.getReverseScrolling()
            if (r14 == 0) goto L_0x047b
            float r13 = -r13
        L_0x047b:
            boolean r14 = performActionHelper$canScroll(r0, r13)
            if (r14 == 0) goto L_0x049f
            kotlin.Function r12 = r12.getAction()
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            if (r12 != 0) goto L_0x048a
            goto L_0x049f
        L_0x048a:
            java.lang.Float r14 = java.lang.Float.valueOf(r9)
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.Object r12 = r12.invoke(r14, r13)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x049b
            goto L_0x049f
        L_0x049b:
            boolean r2 = r12.booleanValue()
        L_0x049f:
            return r2
        L_0x04a0:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r13 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getOnLongClick()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            androidx.compose.ui.semantics.AccessibilityAction r12 = (androidx.compose.ui.semantics.AccessibilityAction) r12
            if (r12 != 0) goto L_0x04b3
            goto L_0x04c9
        L_0x04b3:
            kotlin.Function r12 = r12.getAction()
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            if (r12 != 0) goto L_0x04bc
            goto L_0x04c9
        L_0x04bc:
            java.lang.Object r12 = r12.invoke()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x04c5
            goto L_0x04c9
        L_0x04c5:
            boolean r2 = r12.booleanValue()
        L_0x04c9:
            return r2
        L_0x04ca:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getOnClick()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 != 0) goto L_0x04dd
            goto L_0x04ed
        L_0x04dd:
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 != 0) goto L_0x04e6
            goto L_0x04ed
        L_0x04e6:
            java.lang.Object r13 = r13.invoke()
            r1 = r13
            java.lang.Boolean r1 = (java.lang.Boolean) r1
        L_0x04ed:
            r5 = 1
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            r3 = r11
            r4 = r12
            sendEventForVirtualView$default(r3, r4, r5, r6, r7, r8, r9)
            if (r1 != 0) goto L_0x04fb
            goto L_0x04ff
        L_0x04fb:
            boolean r2 = r1.booleanValue()
        L_0x04ff:
            return r2
        L_0x0500:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r13 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getFocused()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r4)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x0522
            androidx.compose.ui.platform.AndroidComposeView r12 = r11.view
            androidx.compose.ui.focus.FocusManager r12 = r12.getFocusManager()
            androidx.compose.ui.focus.FocusManager.DefaultImpls.clearFocus$default(r12, r2, r4, r1)
            r2 = 1
        L_0x0522:
            return r2
        L_0x0523:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r13 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getFocused()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r2)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x0553
            androidx.compose.ui.node.LayoutNode r12 = r0.getLayoutNode$ui_release()
            androidx.compose.ui.node.LayoutNodeWrapper r12 = r12.getOuterLayoutNodeWrapper$ui_release()
            androidx.compose.ui.node.ModifiedFocusNode r12 = r12.findLastFocusWrapper()
            if (r12 != 0) goto L_0x054a
            goto L_0x054f
        L_0x054a:
            androidx.compose.ui.focus.FocusTransactionsKt.requestFocus(r12)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x054f:
            if (r1 != 0) goto L_0x0552
            return r2
        L_0x0552:
            return r4
        L_0x0553:
            return r2
        L_0x0554:
            r12 = -1
            if (r14 != 0) goto L_0x0559
            r13 = -1
            goto L_0x055f
        L_0x0559:
            java.lang.String r13 = "ACTION_ARGUMENT_SELECTION_START_INT"
            int r13 = r14.getInt(r13, r12)
        L_0x055f:
            if (r14 != 0) goto L_0x0562
            goto L_0x0568
        L_0x0562:
            java.lang.String r1 = "ACTION_ARGUMENT_SELECTION_END_INT"
            int r12 = r14.getInt(r1, r12)
        L_0x0568:
            boolean r12 = r11.setAccessibilitySelection(r0, r13, r12, r2)
            if (r12 == 0) goto L_0x0580
            int r13 = r0.getId()
            int r1 = r11.semanticsNodeIdToAccessibilityVirtualNodeId(r13)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            r0 = r11
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x0580:
            return r12
        L_0x0581:
            androidx.compose.ui.semantics.SemanticsConfiguration r12 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r13 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r13 = r13.getCopyText()
            java.lang.Object r12 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r12, r13)
            androidx.compose.ui.semantics.AccessibilityAction r12 = (androidx.compose.ui.semantics.AccessibilityAction) r12
            if (r12 != 0) goto L_0x0594
            goto L_0x05aa
        L_0x0594:
            kotlin.Function r12 = r12.getAction()
            kotlin.jvm.functions.Function0 r12 = (kotlin.jvm.functions.Function0) r12
            if (r12 != 0) goto L_0x059d
            goto L_0x05aa
        L_0x059d:
            java.lang.Object r12 = r12.invoke()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            if (r12 != 0) goto L_0x05a6
            goto L_0x05aa
        L_0x05a6:
            boolean r2 = r12.booleanValue()
        L_0x05aa:
            return r2
        L_0x05ab:
            if (r14 == 0) goto L_0x05c1
            java.lang.String r12 = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"
            int r12 = r14.getInt(r12)
            java.lang.String r1 = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN"
            boolean r14 = r14.getBoolean(r1)
            if (r13 != r3) goto L_0x05bc
            r2 = 1
        L_0x05bc:
            boolean r12 = r11.traverseAtGranularity(r0, r12, r2, r14)
            return r12
        L_0x05c1:
            return r2
        L_0x05c2:
            boolean r12 = r11.clearAccessibilityFocus(r12)
            return r12
        L_0x05c7:
            boolean r12 = r11.requestAccessibilityFocus(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f) {
        return (f < 0.0f && scrollAxisRange.getValue().invoke().floatValue() > 0.0f) || (f > 0.0f && scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float f, float f2) {
        if (Math.signum(f) == Math.signum(f2)) {
            return Math.abs(f) < Math.abs(f2) ? f : f2;
        }
        return 0.0f;
    }

    /* access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        String str2;
        int i2;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i));
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds == null ? null : semanticsNodeWithAdjustedBounds.getSemanticsNode();
        if (semanticsNode != null) {
            String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
            if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
                int i3 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
                int i4 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
                if (i4 > 0 && i3 >= 0) {
                    if (iterableTextForAccessibility == null) {
                        i2 = Integer.MAX_VALUE;
                    } else {
                        i2 = iterableTextForAccessibility.length();
                    }
                    if (i3 < i2) {
                        List arrayList = new ArrayList();
                        Function1 function1 = (Function1) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
                        if (Intrinsics.areEqual((Object) function1 == null ? null : (Boolean) function1.invoke(arrayList), (Object) true)) {
                            TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
                            List arrayList2 = new ArrayList();
                            int i5 = 0;
                            while (i5 < i4) {
                                int i6 = i5 + 1;
                                int i7 = i5 + i3;
                                if (i7 >= textLayoutResult.getLayoutInput().getText().length()) {
                                    arrayList2.add((Object) null);
                                } else {
                                    arrayList2.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i7)));
                                }
                                i5 = i6;
                            }
                            Bundle extras = accessibilityNodeInfo.getExtras();
                            Object[] array = arrayList2.toArray(new RectF[0]);
                            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            extras.putParcelableArray(str, (Parcelable[]) array);
                            return;
                        }
                        return;
                    }
                }
                Log.e(LogTag, "Invalid arguments for accessibility character locations");
            } else if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTestTag()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) ExtraDataTestTagKey) && (str2 = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getTestTag())) != null) {
                accessibilityNodeInfo.getExtras().putCharSequence(str, str2);
            }
        }
    }

    private final RectF toScreenCoords(SemanticsNode semanticsNode, Rect rect) {
        Rect rect2;
        if (semanticsNode == null) {
            return null;
        }
        Rect r6 = rect.m1390translatek4lQ0M(semanticsNode.m3484getPositionInRootF1C5BW0());
        Rect boundsInRoot = semanticsNode.getBoundsInRoot();
        if (r6.overlaps(boundsInRoot)) {
            rect2 = r6.intersect(boundsInRoot);
        } else {
            rect2 = null;
        }
        if (rect2 == null) {
            return null;
        }
        long r0 = this.view.m3394localToScreenMKHz9U(OffsetKt.Offset(rect2.getLeft(), rect2.getTop()));
        long r5 = this.view.m3394localToScreenMKHz9U(OffsetKt.Offset(rect2.getRight(), rect2.getBottom()));
        return new RectF(Offset.m1353getXimpl(r0), Offset.m1354getYimpl(r0), Offset.m1353getXimpl(r5), Offset.m1354getYimpl(r5));
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (!isAccessibilityEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int hitTestSemanticsAt$ui_release = hitTestSemanticsAt$ui_release(motionEvent.getX(), motionEvent.getY());
            boolean dispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            updateHoveredVirtualView(hitTestSemanticsAt$ui_release);
            if (hitTestSemanticsAt$ui_release == Integer.MIN_VALUE) {
                return dispatchGenericMotionEvent;
            }
            return true;
        } else if (action != 10) {
            return false;
        } else {
            if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
                return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            }
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
    }

    public final int hitTestSemanticsAt$ui_release(float f, float f2) {
        LayoutNode layoutNode$ui_release;
        SemanticsWrapper semanticsWrapper = null;
        Owner.DefaultImpls.measureAndLayout$default(this.view, false, 1, (Object) null);
        HitTestResult hitTestResult = new HitTestResult();
        LayoutNode.m3279hitTestSemanticsM_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(f, f2), hitTestResult, false, false, 12, (Object) null);
        SemanticsWrapper semanticsWrapper2 = (SemanticsWrapper) CollectionsKt.lastOrNull(hitTestResult);
        if (!(semanticsWrapper2 == null || (layoutNode$ui_release = semanticsWrapper2.getLayoutNode$ui_release()) == null)) {
            semanticsWrapper = SemanticsNodeKt.getOuterSemantics(layoutNode$ui_release);
        }
        if (semanticsWrapper == null) {
            return Integer.MIN_VALUE;
        }
        SemanticsNode semanticsNode = new SemanticsNode(semanticsWrapper, false);
        SemanticsWrapper findWrapperToGetBounds$ui_release = semanticsNode.findWrapperToGetBounds$ui_release();
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser()) || findWrapperToGetBounds$ui_release.isTransparent() || this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(semanticsWrapper.getLayoutNode$ui_release()) != null) {
            return Integer.MIN_VALUE;
        }
        return semanticsNodeIdToAccessibilityVirtualNodeId(((SemanticsModifier) semanticsWrapper.getModifier()).getId());
    }

    private final void updateHoveredVirtualView(int i) {
        int i2 = this.hoveredVirtualViewId;
        if (i2 != i) {
            this.hoveredVirtualViewId = i;
            sendEventForVirtualView$default(this, i, 128, (Integer) null, (List) null, 12, (Object) null);
            sendEventForVirtualView$default(this, i2, 256, (Integer) null, (List) null, 12, (Object) null);
        }
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view2) {
        Intrinsics.checkNotNullParameter(view2, "host");
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T t, int i) {
        boolean z = true;
        if (i > 0) {
            if (!(t == null || t.length() == 0)) {
                z = false;
            }
            if (z || t.length() <= i) {
                return t;
            }
            int i2 = i - 1;
            if (Character.isHighSurrogate(t.charAt(i2)) && Character.isLowSurrogate(t.charAt(i))) {
                i = i2;
            }
            return t.subSequence(0, i);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: semanticsChangeChecker$lambda-26  reason: not valid java name */
    public static final void m3400semanticsChangeChecker$lambda26(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Intrinsics.checkNotNullParameter(androidComposeViewAccessibilityDelegateCompat, "this$0");
        androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
        androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isAccessibilityEnabled() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072 A[Catch:{ all -> 0x0052 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073 A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007e A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object boundsUpdatesEventLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.L$1
            androidx.collection.ArraySet r5 = (androidx.collection.ArraySet) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r6 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r6
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0052 }
        L_0x0038:
            r12 = r5
            goto L_0x0064
        L_0x003a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0042:
            java.lang.Object r2 = r0.L$2
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.L$1
            androidx.collection.ArraySet r5 = (androidx.collection.ArraySet) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r6 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r6
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0052 }
            goto L_0x0076
        L_0x0052:
            r12 = move-exception
            goto L_0x00d8
        L_0x0055:
            kotlin.ResultKt.throwOnFailure(r12)
            androidx.collection.ArraySet r12 = new androidx.collection.ArraySet     // Catch:{ all -> 0x00d6 }
            r12.<init>()     // Catch:{ all -> 0x00d6 }
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r2 = r11.boundsUpdateChannel     // Catch:{ all -> 0x00d6 }
            kotlinx.coroutines.channels.ChannelIterator r2 = r2.iterator()     // Catch:{ all -> 0x00d6 }
            r6 = r11
        L_0x0064:
            r0.L$0 = r6     // Catch:{ all -> 0x0052 }
            r0.L$1 = r12     // Catch:{ all -> 0x0052 }
            r0.L$2 = r2     // Catch:{ all -> 0x0052 }
            r0.label = r4     // Catch:{ all -> 0x0052 }
            java.lang.Object r5 = r2.hasNext(r0)     // Catch:{ all -> 0x0052 }
            if (r5 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r10 = r5
            r5 = r12
            r12 = r10
        L_0x0076:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x0052 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0052 }
            if (r12 == 0) goto L_0x00ce
            r2.next()     // Catch:{ all -> 0x0052 }
            boolean r12 = r6.isAccessibilityEnabled()     // Catch:{ all -> 0x0052 }
            if (r12 == 0) goto L_0x00b8
            r12 = 0
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r7 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0052 }
            int r7 = r7.size()     // Catch:{ all -> 0x0052 }
        L_0x008e:
            if (r12 >= r7) goto L_0x00a8
            int r8 = r12 + 1
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r9 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0052 }
            java.lang.Object r12 = r9.valueAt(r12)     // Catch:{ all -> 0x0052 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)     // Catch:{ all -> 0x0052 }
            java.lang.String r9 = "subtreeChangedLayoutNodes.valueAt(i)!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r9)     // Catch:{ all -> 0x0052 }
            androidx.compose.ui.node.LayoutNode r12 = (androidx.compose.ui.node.LayoutNode) r12     // Catch:{ all -> 0x0052 }
            r6.sendSubtreeChangeAccessibilityEvents(r12, r5)     // Catch:{ all -> 0x0052 }
            r12 = r8
            goto L_0x008e
        L_0x00a8:
            r5.clear()     // Catch:{ all -> 0x0052 }
            boolean r12 = r6.checkingForSemanticsChanges     // Catch:{ all -> 0x0052 }
            if (r12 != 0) goto L_0x00b8
            r6.checkingForSemanticsChanges = r4     // Catch:{ all -> 0x0052 }
            android.os.Handler r12 = r6.handler     // Catch:{ all -> 0x0052 }
            java.lang.Runnable r7 = r6.semanticsChangeChecker     // Catch:{ all -> 0x0052 }
            r12.post(r7)     // Catch:{ all -> 0x0052 }
        L_0x00b8:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r12 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0052 }
            r12.clear()     // Catch:{ all -> 0x0052 }
            r7 = 100
            r0.L$0 = r6     // Catch:{ all -> 0x0052 }
            r0.L$1 = r5     // Catch:{ all -> 0x0052 }
            r0.L$2 = r2     // Catch:{ all -> 0x0052 }
            r0.label = r3     // Catch:{ all -> 0x0052 }
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r7, r0)     // Catch:{ all -> 0x0052 }
            if (r12 != r1) goto L_0x0038
            return r1
        L_0x00ce:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r12 = r6.subtreeChangedLayoutNodes
            r12.clear()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00d6:
            r12 = move-exception
            r6 = r11
        L_0x00d8:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r0 = r6.subtreeChangedLayoutNodes
            r0.clear()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.currentSemanticsNodesInvalidated = true;
        if (isAccessibilityEnabled()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    private final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.m6176trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, ArraySet<Integer> arraySet) {
        LayoutNode access$findClosestParentNode;
        SemanticsWrapper outerSemantics;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            SemanticsWrapper outerSemantics2 = SemanticsNodeKt.getOuterSemantics(layoutNode);
            if (outerSemantics2 == null) {
                LayoutNode access$findClosestParentNode2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsWrapper$1.INSTANCE);
                if (access$findClosestParentNode2 == null) {
                    outerSemantics2 = null;
                } else {
                    outerSemantics2 = SemanticsNodeKt.getOuterSemantics(access$findClosestParentNode2);
                }
                if (outerSemantics2 == null) {
                    return;
                }
            }
            if (!(outerSemantics2.collapsedSemanticsConfiguration().isMergingSemanticsOfDescendants() || (access$findClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE)) == null || (outerSemantics = SemanticsNodeKt.getOuterSemantics(access$findClosestParentNode)) == null)) {
                outerSemantics2 = outerSemantics;
            }
            int id = ((SemanticsModifier) outerSemantics2.getModifier()).getId();
            if (arraySet.add(Integer.valueOf(id))) {
                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 1, (List) null, 8, (Object) null);
            }
        }
    }

    private final void checkForSemanticsChanges() {
        sendSemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        sendSemanticsPropertyChangeEvents$ui_release(getCurrentSemanticsNodes());
        updateSemanticsNodesCopyAndPanes();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateSemanticsNodesCopyAndPanes() {
        /*
            r6 = this;
            androidx.collection.ArraySet<java.lang.Integer> r0 = r6.paneDisplayed
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0060
            java.lang.Object r1 = r0.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.util.Map r2 = r6.getCurrentSemanticsNodes()
            java.lang.Object r2 = r2.get(r1)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            r3 = 0
            if (r2 != 0) goto L_0x0021
            r2 = r3
            goto L_0x0025
        L_0x0021:
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.getSemanticsNode()
        L_0x0025:
            if (r2 == 0) goto L_0x002d
            boolean r2 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(r2)
            if (r2 != 0) goto L_0x0006
        L_0x002d:
            androidx.collection.ArraySet<java.lang.Integer> r2 = r6.paneDisplayed
            r2.remove(r1)
            java.lang.String r2 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            int r2 = r1.intValue()
            r4 = 32
            java.util.Map<java.lang.Integer, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy> r5 = r6.previousSemanticsNodes
            java.lang.Object r1 = r5.get(r1)
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy r1 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy) r1
            if (r1 != 0) goto L_0x0048
            goto L_0x005c
        L_0x0048:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r1.getUnmergedConfig()
            if (r1 != 0) goto L_0x004f
            goto L_0x005c
        L_0x004f:
            androidx.compose.ui.semantics.SemanticsProperties r3 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getPaneTitle()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r3)
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
        L_0x005c:
            r6.sendPaneChangeEvents(r2, r4, r3)
            goto L_0x0006
        L_0x0060:
            java.util.Map<java.lang.Integer, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy> r0 = r6.previousSemanticsNodes
            r0.clear()
            java.util.Map r0 = r6.getCurrentSemanticsNodes()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0071:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00df
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.getSemanticsNode()
            boolean r2 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(r2)
            if (r2 == 0) goto L_0x00c2
            androidx.collection.ArraySet<java.lang.Integer> r2 = r6.paneDisplayed
            java.lang.Object r3 = r1.getKey()
            boolean r2 = r2.add(r3)
            if (r2 == 0) goto L_0x00c2
            java.lang.Object r2 = r1.getKey()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r3 = 16
            java.lang.Object r4 = r1.getValue()
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r4 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r4
            androidx.compose.ui.semantics.SemanticsNode r4 = r4.getSemanticsNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r4.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r5 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getPaneTitle()
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            r6.sendPaneChangeEvents(r2, r3, r4)
        L_0x00c2:
            java.util.Map<java.lang.Integer, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy> r2 = r6.previousSemanticsNodes
            java.lang.Object r3 = r1.getKey()
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy r4 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r1 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r1
            androidx.compose.ui.semantics.SemanticsNode r1 = r1.getSemanticsNode()
            java.util.Map r5 = r6.getCurrentSemanticsNodes()
            r4.<init>(r1, r5)
            r2.put(r3, r4)
            goto L_0x0071
        L_0x00df:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy
            androidx.compose.ui.platform.AndroidComposeView r1 = r6.view
            androidx.compose.ui.semantics.SemanticsOwner r1 = r1.getSemanticsOwner()
            androidx.compose.ui.semantics.SemanticsNode r1 = r1.getUnmergedRootSemanticsNode()
            java.util.Map r2 = r6.getCurrentSemanticsNodes()
            r0.<init>(r1, r2)
            r6.previousSemanticsRoot = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.updateSemanticsNodesCopyAndPanes():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:126:0x04cd, code lost:
        if ((!r0.isEmpty()) != false) goto L_0x04fb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendSemanticsPropertyChangeEvents$ui_release(java.util.Map<java.lang.Integer, androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r28) {
        /*
            r27 = this;
            r7 = r27
            r8 = r28
            java.lang.String r0 = "newSemanticsNodes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r0 = r7.scrollObservationScopes
            java.util.Collection r0 = (java.util.Collection) r0
            r9.<init>(r0)
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r0 = r7.scrollObservationScopes
            r0.clear()
            java.util.Set r0 = r28.keySet()
            java.util.Iterator r10 = r0.iterator()
        L_0x001f:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x051d
            java.lang.Object r0 = r10.next()
            java.lang.Number r0 = (java.lang.Number) r0
            int r11 = r0.intValue()
            java.util.Map<java.lang.Integer, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy> r0 = r7.previousSemanticsNodes
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            java.lang.Object r0 = r0.get(r1)
            r12 = r0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy r12 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy) r12
            if (r12 != 0) goto L_0x003f
            goto L_0x001f
        L_0x003f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            java.lang.Object r0 = r8.get(r0)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r0 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r0
            if (r0 != 0) goto L_0x004d
            r14 = 0
            goto L_0x0052
        L_0x004d:
            androidx.compose.ui.semantics.SemanticsNode r0 = r0.getSemanticsNode()
            r14 = r0
        L_0x0052:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            java.util.Iterator r15 = r0.iterator()
            r16 = 0
            r6 = 1
            r17 = 0
        L_0x0062:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x0500
            java.lang.Object r0 = r15.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getHorizontalScrollAxisRange()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x0091
            java.lang.Object r1 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getVerticalScrollAxisRange()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r1 = 0
            goto L_0x0098
        L_0x0091:
            r1 = r9
            java.util.List r1 = (java.util.List) r1
            boolean r1 = r7.registerScrollingId(r11, r1)
        L_0x0098:
            if (r1 != 0) goto L_0x00b6
            java.lang.Object r1 = r0.getValue()
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r12.getUnmergedConfig()
            java.lang.Object r3 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r3
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x00b6
        L_0x00b2:
            r19 = 1
            goto L_0x04d0
        L_0x00b6:
            java.lang.Object r1 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r1
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getPaneTitle()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r3 = 8
            if (r2 == 0) goto L_0x00df
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            java.util.Objects.requireNonNull(r0, r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = r12.hasPaneTitle()
            if (r1 == 0) goto L_0x00b2
            r7.sendPaneChangeEvents(r11, r3, r0)
            goto L_0x00b2
        L_0x00df:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getStateDescription()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x00ed
            r2 = 1
            goto L_0x00f7
        L_0x00ed:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getToggleableState()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
        L_0x00f7:
            r4 = 64
            if (r2 == 0) goto L_0x0121
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r4 = 0
            r5 = 8
            r18 = 0
            r0 = r27
            r19 = 1
            r6 = r18
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r6 = 0
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x04d0
        L_0x0121:
            r19 = 1
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getProgressBarRangeInfo()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x014f
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x04d0
        L_0x014f:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getSelected()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            r5 = 4
            if (r2 == 0) goto L_0x025e
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getRole()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.Role r0 = (androidx.compose.ui.semantics.Role) r0
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m3482getTabo7Vup1c()
            if (r0 != 0) goto L_0x0176
            r0 = 0
            goto L_0x017e
        L_0x0176:
            int r0 = r0.m3476unboximpl()
            boolean r0 = androidx.compose.ui.semantics.Role.m3473equalsimpl0(r0, r1)
        L_0x017e:
            if (r0 == 0) goto L_0x023e
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getSelected()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r19)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0223
            int r0 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            android.view.accessibility.AccessibilityEvent r0 = r7.createEvent$ui_release(r0, r5)
            androidx.compose.ui.semantics.SemanticsNode r1 = new androidx.compose.ui.semantics.SemanticsNode
            androidx.compose.ui.semantics.SemanticsWrapper r2 = r14.getOuterSemanticsNodeWrapper$ui_release()
            r6 = 1
            r1.<init>(r2, r6)
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r1.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r3 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getContentDescription()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r3)
            r18 = r2
            java.util.List r18 = (java.util.List) r18
            java.lang.String r2 = ","
            if (r18 != 0) goto L_0x01c2
            r3 = 0
            goto L_0x01d8
        L_0x01c2:
            r19 = r2
            java.lang.CharSequence r19 = (java.lang.CharSequence) r19
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 62
            r26 = 0
            java.lang.String r3 = androidx.compose.ui.TempListUtilsKt.fastJoinToString$default(r18, r19, r20, r21, r22, r23, r24, r25, r26)
        L_0x01d8:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r1.getConfig()
            androidx.compose.ui.semantics.SemanticsProperties r4 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r4)
            r18 = r1
            java.util.List r18 = (java.util.List) r18
            if (r18 != 0) goto L_0x01ee
            r1 = 0
            goto L_0x0204
        L_0x01ee:
            r19 = r2
            java.lang.CharSequence r19 = (java.lang.CharSequence) r19
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 62
            r26 = 0
            java.lang.String r1 = androidx.compose.ui.TempListUtilsKt.fastJoinToString$default(r18, r19, r20, r21, r22, r23, r24, r25, r26)
        L_0x0204:
            if (r3 != 0) goto L_0x0207
            goto L_0x0210
        L_0x0207:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setContentDescription(r3)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0210:
            if (r1 != 0) goto L_0x0213
            goto L_0x021e
        L_0x0213:
            java.util.List r2 = r0.getText()
            boolean r1 = r2.add(r1)
            java.lang.Boolean.valueOf(r1)
        L_0x021e:
            r7.sendEvent(r0)
            goto L_0x00b2
        L_0x0223:
            r6 = 1
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r4 = 0
            r5 = 8
            r18 = 0
            r0 = r27
            r19 = 1
            r6 = r18
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x04d0
        L_0x023e:
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x04d0
        L_0x025e:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getContentDescription()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0284
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>"
            java.util.Objects.requireNonNull(r0, r4)
            java.util.List r0 = (java.util.List) r0
            r7.sendEventForVirtualView(r1, r2, r3, r0)
            goto L_0x04d0
        L_0x0284:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getEditableText()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            java.lang.String r5 = ""
            if (r2 == 0) goto L_0x0336
            boolean r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(r14)
            if (r0 == 0) goto L_0x0320
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r12.getUnmergedConfig()
            androidx.compose.ui.text.AnnotatedString r0 = r7.getTextForTextField(r0)
            if (r0 != 0) goto L_0x02a6
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x02a8
        L_0x02a6:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x02a8:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.text.AnnotatedString r1 = r7.getTextForTextField(r1)
            if (r1 != 0) goto L_0x02b5
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            goto L_0x02b8
        L_0x02b5:
            r5 = r1
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
        L_0x02b8:
            int r1 = r0.length()
            int r2 = r5.length()
            int r3 = kotlin.ranges.RangesKt.coerceAtMost((int) r1, (int) r2)
            r6 = 0
        L_0x02c5:
            if (r6 >= r3) goto L_0x02d5
            char r13 = r0.charAt(r6)
            char r4 = r5.charAt(r6)
            if (r13 == r4) goto L_0x02d2
            goto L_0x02d5
        L_0x02d2:
            int r6 = r6 + 1
            goto L_0x02c5
        L_0x02d5:
            r4 = 0
        L_0x02d6:
            int r13 = r3 - r6
            if (r4 >= r13) goto L_0x02f3
            int r13 = r1 + -1
            int r13 = r13 - r4
            char r13 = r0.charAt(r13)
            int r21 = r2 + -1
            r22 = r3
            int r3 = r21 - r4
            char r3 = r5.charAt(r3)
            if (r13 == r3) goto L_0x02ee
            goto L_0x02f3
        L_0x02ee:
            int r4 = r4 + 1
            r3 = r22
            goto L_0x02d6
        L_0x02f3:
            int r1 = r1 - r4
            int r1 = r1 - r6
            int r2 = r2 - r4
            int r2 = r2 - r6
            int r3 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r4 = 16
            android.view.accessibility.AccessibilityEvent r3 = r7.createEvent$ui_release(r3, r4)
            r3.setFromIndex(r6)
            r3.setRemovedCount(r1)
            r3.setAddedCount(r2)
            r3.setBeforeText(r0)
            java.util.List r0 = r3.getText()
            r1 = 100000(0x186a0, float:1.4013E-40)
            java.lang.CharSequence r1 = r7.trimToSize(r5, r1)
            r0.add(r1)
            r7.sendEvent(r3)
            goto L_0x04d0
        L_0x0320:
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            r0 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x04d0
        L_0x0336:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getTextSelectionRange()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x03a7
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.text.AnnotatedString r0 = r7.getTextForTextField(r0)
            if (r0 != 0) goto L_0x034d
            goto L_0x0355
        L_0x034d:
            java.lang.String r0 = r0.getText()
            if (r0 != 0) goto L_0x0354
            goto L_0x0355
        L_0x0354:
            r5 = r0
        L_0x0355:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r1 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getTextSelectionRange()
            java.lang.Object r0 = r0.get(r1)
            androidx.compose.ui.text.TextRange r0 = (androidx.compose.ui.text.TextRange) r0
            long r0 = r0.m3575unboximpl()
            int r2 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            int r3 = androidx.compose.ui.text.TextRange.m3571getStartimpl(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r0 = androidx.compose.ui.text.TextRange.m3566getEndimpl(r0)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            int r0 = r5.length()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0 = 100000(0x186a0, float:1.4013E-40)
            java.lang.CharSequence r0 = r7.trimToSize(r5, r0)
            r5 = r0
            java.lang.String r5 = (java.lang.String) r5
            r0 = r27
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r6
            android.view.accessibility.AccessibilityEvent r0 = r0.createTextSelectionChangedEvent(r1, r2, r3, r4, r5)
            r7.sendEvent(r0)
            int r0 = r14.getId()
            r7.sendPendingTextTraversedAtGranularityEvent(r0)
            goto L_0x04d0
        L_0x03a7:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getHorizontalScrollAxisRange()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x03b5
            r6 = 1
            goto L_0x03bf
        L_0x03b5:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getVerticalScrollAxisRange()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
        L_0x03bf:
            if (r6 == 0) goto L_0x03fc
            androidx.compose.ui.node.LayoutNode r0 = r14.getLayoutNode$ui_release()
            r7.notifySubtreeAccessibilityStateChangedIfNeeded(r0)
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r0 = r7.scrollObservationScopes
            androidx.compose.ui.platform.ScrollObservationScope r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(r0, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getHorizontalScrollAxisRange()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.ScrollAxisRange r1 = (androidx.compose.ui.semantics.ScrollAxisRange) r1
            r0.setHorizontalScrollAxisRange(r1)
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getVerticalScrollAxisRange()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.ScrollAxisRange r1 = (androidx.compose.ui.semantics.ScrollAxisRange) r1
            r0.setVerticalScrollAxisRange(r1)
            r7.sendScrollEventIfNeeded(r0)
            goto L_0x04d0
        L_0x03fc:
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getFocused()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0441
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            java.util.Objects.requireNonNull(r0, r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0428
            int r0 = r14.getId()
            int r0 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r0)
            android.view.accessibility.AccessibilityEvent r0 = r7.createEvent$ui_release(r0, r3)
            r7.sendEvent(r0)
        L_0x0428:
            int r0 = r14.getId()
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r0)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x04d0
        L_0x0441:
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getCustomActions()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x04d3
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r1 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r1.getCustomActions()
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r12.getUnmergedConfig()
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getCustomActions()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x04c5
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet
            r2.<init>()
            java.util.Set r2 = (java.util.Set) r2
            int r3 = r0.size()
            r4 = 0
        L_0x047b:
            if (r4 >= r3) goto L_0x048e
            int r5 = r4 + 1
            java.lang.Object r4 = r0.get(r4)
            androidx.compose.ui.semantics.CustomAccessibilityAction r4 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r4
            java.lang.String r4 = r4.getLabel()
            r2.add(r4)
            r4 = r5
            goto L_0x047b
        L_0x048e:
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.util.Set r0 = (java.util.Set) r0
            int r3 = r1.size()
            r4 = 0
        L_0x049a:
            if (r4 >= r3) goto L_0x04ad
            int r5 = r4 + 1
            java.lang.Object r4 = r1.get(r4)
            androidx.compose.ui.semantics.CustomAccessibilityAction r4 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r4
            java.lang.String r4 = r4.getLabel()
            r0.add(r4)
            r4 = r5
            goto L_0x049a
        L_0x04ad:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r2.containsAll(r1)
            if (r1 == 0) goto L_0x04c2
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r0 = r0.containsAll(r2)
            if (r0 != 0) goto L_0x04bf
            goto L_0x04c2
        L_0x04bf:
            r17 = 0
            goto L_0x04d0
        L_0x04c2:
            r17 = 1
            goto L_0x04d0
        L_0x04c5:
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x04d0
            goto L_0x04fb
        L_0x04d0:
            r6 = 1
            goto L_0x0062
        L_0x04d3:
            java.lang.Object r1 = r0.getValue()
            boolean r1 = r1 instanceof androidx.compose.ui.semantics.AccessibilityAction
            if (r1 == 0) goto L_0x04fb
            java.lang.Object r1 = r0.getValue()
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>"
            java.util.Objects.requireNonNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r12.getUnmergedConfig()
            java.lang.Object r0 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r0 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r0
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r0)
            boolean r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals(r1, r0)
            r17 = r0 ^ 1
            goto L_0x04d0
        L_0x04fb:
            r6 = 1
            r17 = 1
            goto L_0x0062
        L_0x0500:
            if (r17 != 0) goto L_0x0506
            boolean r17 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(r14, r12)
        L_0x0506:
            if (r17 == 0) goto L_0x001f
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            sendEventForVirtualView$default(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x001f
        L_0x051d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSemanticsPropertyChangeEvents$ui_release(java.util.Map):void");
    }

    private final boolean registerScrollingId(int i, List<ScrollObservationScope> list) {
        boolean z;
        ScrollObservationScope findById = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(list, i);
        if (findById != null) {
            z = false;
        } else {
            findById = new ScrollObservationScope(i, this.scrollObservationScopes, (Float) null, (Float) null, (ScrollAxisRange) null, (ScrollAxisRange) null);
            z = true;
        }
        this.scrollObservationScopes.add(findById);
        return z;
    }

    /* access modifiers changed from: private */
    public final void sendScrollEventIfNeeded(ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValid()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.sendScrollEventIfNeededLambda, new AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1(scrollObservationScope, this));
        }
    }

    private final void sendPaneChangeEvents(int i, int i2, String str) {
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(i), 32);
        createEvent$ui_release.setContentChangeTypes(i2);
        if (str != null) {
            createEvent$ui_release.getText().add(str);
        }
        sendEvent(createEvent$ui_release);
    }

    private final void sendSemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        Set linkedHashSet = new LinkedHashSet();
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i2);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                if (!semanticsNodeCopy.getChildren().contains(Integer.valueOf(semanticsNode2.getId()))) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                    return;
                }
                linkedHashSet.add(Integer.valueOf(semanticsNode2.getId()));
            }
            i2 = i3;
        }
        for (Integer intValue : semanticsNodeCopy.getChildren()) {
            if (!linkedHashSet.contains(Integer.valueOf(intValue.intValue()))) {
                notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                return;
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        while (i < size2) {
            int i4 = i + 1;
            SemanticsNode semanticsNode3 = replacedChildren$ui_release2.get(i);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode3.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy2 = getPreviousSemanticsNodes$ui_release().get(Integer.valueOf(semanticsNode3.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy2);
                sendSemanticsStructureChangeEvents(semanticsNode3, semanticsNodeCopy2);
            }
            i = i4;
        }
    }

    /* access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int i) {
        if (i == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return i;
    }

    private final boolean traverseAtGranularity(SemanticsNode semanticsNode, int i, boolean z, boolean z2) {
        AccessibilityIterators.TextSegmentIterator iteratorForGranularity;
        int i2;
        int i3;
        int id = semanticsNode.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(semanticsNode.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        CharSequence charSequence = iterableTextForAccessibility;
        if ((charSequence == null || charSequence.length() == 0) || (iteratorForGranularity = getIteratorForGranularity(semanticsNode, i)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd(semanticsNode);
        if (accessibilitySelectionEnd == -1) {
            accessibilitySelectionEnd = z ? 0 : iterableTextForAccessibility.length();
        }
        int[] following = z ? iteratorForGranularity.following(accessibilitySelectionEnd) : iteratorForGranularity.preceding(accessibilitySelectionEnd);
        if (following == null) {
            return false;
        }
        int i4 = following[0];
        int i5 = following[1];
        if (!z2 || !isAccessibilitySelectionExtendable(semanticsNode)) {
            i3 = z ? i5 : i4;
            i2 = i3;
        } else {
            i3 = getAccessibilitySelectionStart(semanticsNode);
            if (i3 == -1) {
                i3 = z ? i4 : i5;
            }
            i2 = z ? i5 : i4;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(semanticsNode, z ? 256 : 512, i, i4, i5, SystemClock.uptimeMillis());
        SemanticsNode semanticsNode2 = semanticsNode;
        setAccessibilitySelection(semanticsNode, i3, i2, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int i) {
        PendingTextTraversedEvent pendingTextTraversedEvent2 = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent2 != null) {
            if (i == pendingTextTraversedEvent2.getNode().getId()) {
                if (SystemClock.uptimeMillis() - pendingTextTraversedEvent2.getTraverseTime() <= 1000) {
                    AccessibilityEvent createEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent2.getNode().getId()), 131072);
                    createEvent$ui_release.setFromIndex(pendingTextTraversedEvent2.getFromIndex());
                    createEvent$ui_release.setToIndex(pendingTextTraversedEvent2.getToIndex());
                    createEvent$ui_release.setAction(pendingTextTraversedEvent2.getAction());
                    createEvent$ui_release.setMovementGranularity(pendingTextTraversedEvent2.getGranularity());
                    createEvent$ui_release.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent2.getNode()));
                    sendEvent(createEvent$ui_release);
                }
            } else {
                return;
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode semanticsNode, int i, int i2, boolean z) {
        String iterableTextForAccessibility;
        Boolean bool;
        boolean z2 = false;
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            Function3 function3 = (Function3) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
            if (function3 == null || (bool = (Boolean) function3.invoke(Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z))) == null) {
                return false;
            }
            return bool.booleanValue();
        } else if ((i == i2 && i2 == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode)) == null) {
            return false;
        } else {
            if (i < 0 || i != i2 || i2 > iterableTextForAccessibility.length()) {
                i = -1;
            }
            this.accessibilityCursorPosition = i;
            if (iterableTextForAccessibility.length() > 0) {
                z2 = true;
            }
            int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId());
            Integer num = null;
            Integer valueOf = z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null;
            Integer valueOf2 = z2 ? Integer.valueOf(this.accessibilityCursorPosition) : null;
            if (z2) {
                num = Integer.valueOf(iterableTextForAccessibility.length());
            }
            sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId, valueOf, valueOf2, num, iterableTextForAccessibility));
            sendPendingTextTraversedAtGranularityEvent(semanticsNode.getId());
            return true;
        }
    }

    private final int getAccessibilitySelectionStart(SemanticsNode semanticsNode) {
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m3571getStartimpl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m3575unboximpl());
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode semanticsNode) {
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m3566getEndimpl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).m3575unboximpl());
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode semanticsNode) {
        return !semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription()) && semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode semanticsNode, int i) {
        AccessibilityIterators.AbstractTextSegmentIterator abstractTextSegmentIterator;
        if (semanticsNode == null) {
            return null;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        CharSequence charSequence = iterableTextForAccessibility;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        if (i == 1) {
            AccessibilityIterators.CharacterTextSegmentIterator.Companion companion = AccessibilityIterators.CharacterTextSegmentIterator.Companion;
            Locale locale = this.view.getContext().getResources().getConfiguration().locale;
            Intrinsics.checkNotNullExpressionValue(locale, "view.context.resources.configuration.locale");
            abstractTextSegmentIterator = companion.getInstance(locale);
            abstractTextSegmentIterator.initialize(iterableTextForAccessibility);
        } else if (i != 2) {
            if (i != 4) {
                if (i == 8) {
                    abstractTextSegmentIterator = AccessibilityIterators.ParagraphTextSegmentIterator.Companion.getInstance();
                    abstractTextSegmentIterator.initialize(iterableTextForAccessibility);
                } else if (i != 16) {
                    return null;
                }
            }
            if (!semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult())) {
                return null;
            }
            List arrayList = new ArrayList();
            Function1 function1 = (Function1) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsActions.INSTANCE.getGetTextLayoutResult())).getAction();
            if (!Intrinsics.areEqual((Object) function1 == null ? null : (Boolean) function1.invoke(arrayList), (Object) true)) {
                return null;
            }
            TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
            if (i == 4) {
                abstractTextSegmentIterator = AccessibilityIterators.LineTextSegmentIterator.Companion.getInstance();
                ((AccessibilityIterators.LineTextSegmentIterator) abstractTextSegmentIterator).initialize(iterableTextForAccessibility, textLayoutResult);
            } else {
                AccessibilityIterators.AbstractTextSegmentIterator instance = AccessibilityIterators.PageTextSegmentIterator.Companion.getInstance();
                ((AccessibilityIterators.PageTextSegmentIterator) instance).initialize(iterableTextForAccessibility, textLayoutResult, semanticsNode);
                abstractTextSegmentIterator = instance;
            }
        } else {
            AccessibilityIterators.WordTextSegmentIterator.Companion companion2 = AccessibilityIterators.WordTextSegmentIterator.Companion;
            Locale locale2 = this.view.getContext().getResources().getConfiguration().locale;
            Intrinsics.checkNotNullExpressionValue(locale2, "view.context.resources.configuration.locale");
            abstractTextSegmentIterator = companion2.getInstance(locale2);
            abstractTextSegmentIterator.initialize(iterableTextForAccessibility);
        }
        return abstractTextSegmentIterator;
    }

    private final String getIterableTextForAccessibility(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        if (semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return TempListUtilsKt.fastJoinToString$default((List) semanticsNode.getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode)) {
            AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
            if (textForTextField == null) {
                return null;
            }
            return textForTextField.getText();
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$MyNodeProvider;", "Landroid/view/accessibility/AccessibilityNodeProvider;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public final class MyNodeProvider extends AccessibilityNodeProvider {
        final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

        public MyNodeProvider(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
            Intrinsics.checkNotNullParameter(androidComposeViewAccessibilityDelegateCompat, "this$0");
            this.this$0 = androidComposeViewAccessibilityDelegateCompat;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return this.this$0.createNodeInfo(i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.this$0.performActionHelper(i, i2, bundle);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "info");
            Intrinsics.checkNotNullParameter(str, "extraDataKey");
            this.this$0.addExtraDataToAccessibilityNodeInfoHelper(i, accessibilityNodeInfo, str, bundle);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api24Impl {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl$Companion;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final void addSetProgressAction(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
                AccessibilityAction accessibilityAction;
                Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
                Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
                if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress())) != null) {
                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908349, accessibilityAction.getLabel()));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api28Impl;", "", "()V", "Companion", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class Api28Impl {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api28Impl$Companion;", "", "()V", "setScrollEventDelta", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "deltaX", "", "deltaY", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final void setScrollEventDelta(AccessibilityEvent accessibilityEvent, int i, int i2) {
                Intrinsics.checkNotNullParameter(accessibilityEvent, "event");
                accessibilityEvent.setScrollDeltaX(i);
                accessibilityEvent.setScrollDeltaY(i2);
            }
        }
    }
}
