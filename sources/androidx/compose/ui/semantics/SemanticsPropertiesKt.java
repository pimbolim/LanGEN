package androidx.compose.ui.semantics;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002Hu0t0s\"\u000e\b\u0000\u0010u*\b\u0012\u0004\u0012\u00020'0v2\u0006\u0010w\u001a\u00020\u0012H\u0000\u001a\u0013\u0010x\u001a\u0002Hu\"\u0004\b\u0000\u0010uH\u0002¢\u0006\u0002\u0010y\u001a&\u0010z\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010~\u001a&\u0010\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010~\u001a'\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010~\u001a\u000b\u0010\u0001\u001a\u00020{*\u00020\u0003\u001a\u000b\u0010\u0001\u001a\u00020{*\u00020\u0003\u001a'\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010~\u001a\u0014\u0010\u0001\u001a\u00020{*\u00020\u00032\u0007\u0010\u0001\u001a\u00020\u0012\u001a'\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010~\u001a6\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u001d\u0010}\u001a\u0019\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a\u000b\u0010\u0001\u001a\u00020{*\u00020\u0003\u001a#\u0010\u0001\u001a\u00020{*\u00020\u00032\u0016\u0010\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0001\u0012\u0005\u0012\u00030\u00010\u0001\u001a\r\u0010\u0001\u001a\u00020{*\u00020\u0003H\u0007\u001a'\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010~\u001a'\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010~\u001a\u000b\u0010\u0001\u001a\u00020{*\u00020\u0003\u001a'\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u000e\u0010}\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010~\u001a\u000b\u0010\u0001\u001a\u00020{*\u00020\u0003\u001aX\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122?\u0010}\u001a;\u0012\u0016\u0012\u00140\u0001¢\u0006\u000e\b\u0001\u0012\t\bw\u0012\u0005\b\b(\u0001\u0012\u0016\u0012\u00140\u0001¢\u0006\u000e\b\u0001\u0012\t\bw\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001a-\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u0014\u0010}\u001a\u0010\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020'0\u0001\u001a\u000b\u0010\u0001\u001a\u00020{*\u00020\u0003\u001a/\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u0016\u0010}\u001a\u0012\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020'\u0018\u00010\u0001\u001ao\u0010\u0001\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122V\u0010}\u001aR\u0012\u0016\u0012\u00140\u0001¢\u0006\u000e\b\u0001\u0012\t\bw\u0012\u0005\b\b(¡\u0001\u0012\u0016\u0012\u00140\u0001¢\u0006\u000e\b\u0001\u0012\t\bw\u0012\u0005\b\b(¢\u0001\u0012\u0015\u0012\u00130'¢\u0006\u000e\b\u0001\u0012\t\bw\u0012\u0005\b\b(£\u0001\u0012\u0004\u0012\u00020'\u0018\u00010 \u0001\u001a-\u0010_\u001a\u00020{*\u00020\u00032\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00122\u0015\u0010}\u001a\u0011\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020'\u0018\u00010\u0001\"/\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"/\u0010\u000b\u001a\u00020\n*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\n8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\"(\u0010\u0013\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\";\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188F@FX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\t\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\"/\u0010!\u001a\u00020 *\u00020\u00032\u0006\u0010\u0000\u001a\u00020 8F@FX\u0002¢\u0006\u0012\n\u0004\b&\u0010\t\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\"/\u0010(\u001a\u00020'*\u00020\u00032\u0006\u0010\u0000\u001a\u00020'8F@FX\u0002¢\u0006\u0012\n\u0004\b-\u0010\t\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\"/\u0010/\u001a\u00020.*\u00020\u00032\u0006\u0010\u0000\u001a\u00020.8F@FX\u0002¢\u0006\u0012\n\u0004\b4\u0010\t\u001a\u0004\b0\u00101\"\u0004\b2\u00103\"2\u00106\u001a\u000205*\u00020\u00032\u0006\u0010\u0000\u001a\u0002058F@FX\u0002ø\u0001\u0000¢\u0006\u0012\n\u0004\b;\u0010\t\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\"2\u0010=\u001a\u00020<*\u00020\u00032\u0006\u0010\u0000\u001a\u00020<8F@FX\u0002ø\u0001\u0000¢\u0006\u0012\n\u0004\b@\u0010\t\u001a\u0004\b>\u00108\"\u0004\b?\u0010:\"/\u0010A\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\bD\u0010\t\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010\u0017\"/\u0010F\u001a\u00020E*\u00020\u00032\u0006\u0010\u0000\u001a\u00020E8F@FX\u0002¢\u0006\u0012\n\u0004\bK\u0010\t\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J\"2\u0010M\u001a\u00020L*\u00020\u00032\u0006\u0010\u0000\u001a\u00020L8F@FX\u0002ø\u0001\u0000¢\u0006\u0012\n\u0004\bP\u0010\t\u001a\u0004\bN\u00108\"\u0004\bO\u0010:\"/\u0010Q\u001a\u00020'*\u00020\u00032\u0006\u0010\u0000\u001a\u00020'8F@FX\u0002¢\u0006\u0012\n\u0004\bT\u0010\t\u001a\u0004\bR\u0010*\"\u0004\bS\u0010,\"/\u0010U\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\bX\u0010\t\u001a\u0004\bV\u0010\u0015\"\u0004\bW\u0010\u0017\"/\u0010Y\u001a\u00020\u0012*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00128F@FX\u0002¢\u0006\u0012\n\u0004\b\\\u0010\t\u001a\u0004\bZ\u0010\u0015\"\u0004\b[\u0010\u0017\"(\u0010]\u001a\u00020 *\u00020\u00032\u0006\u0010\u0011\u001a\u00020 8F@FX\u000e¢\u0006\f\u001a\u0004\b^\u0010#\"\u0004\b_\u0010%\"2\u0010a\u001a\u00020`*\u00020\u00032\u0006\u0010\u0000\u001a\u00020`8F@FX\u0002ø\u0001\u0000¢\u0006\u0012\n\u0004\bf\u0010\t\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e\"/\u0010h\u001a\u00020g*\u00020\u00032\u0006\u0010\u0000\u001a\u00020g8F@FX\u0002¢\u0006\u0012\n\u0004\bm\u0010\t\u001a\u0004\bi\u0010j\"\u0004\bk\u0010l\"/\u0010n\u001a\u00020.*\u00020\u00032\u0006\u0010\u0000\u001a\u00020.8F@FX\u0002¢\u0006\u0012\n\u0004\bq\u0010\t\u001a\u0004\bo\u00101\"\u0004\bp\u00103\u0002\u0004\n\u0002\b\u0019¨\u0006¤\u0001"}, d2 = {"<set-?>", "Landroidx/compose/ui/semantics/CollectionInfo;", "collectionInfo", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", "setCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionInfo;)V", "collectionInfo$delegate", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "collectionItemInfo", "getCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", "setCollectionItemInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/CollectionItemInfo;)V", "collectionItemInfo$delegate", "value", "", "contentDescription", "getContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", "setContentDescription", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/lang/String;)V", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "customActions", "getCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", "setCustomActions", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Ljava/util/List;)V", "customActions$delegate", "Landroidx/compose/ui/text/AnnotatedString;", "editableText", "getEditableText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", "setEditableText", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/text/AnnotatedString;)V", "editableText$delegate", "", "focused", "getFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setFocused", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "focused$delegate", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "horizontalScrollAxisRange", "getHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "horizontalScrollAxisRange$delegate", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "getImeAction", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", "setImeAction-4L7nppU", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;I)V", "imeAction$delegate", "Landroidx/compose/ui/semantics/LiveRegionMode;", "liveRegion", "getLiveRegion", "setLiveRegion-hR3wRGc", "liveRegion$delegate", "paneTitle", "getPaneTitle", "setPaneTitle", "paneTitle$delegate", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "progressBarRangeInfo", "getProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "setProgressBarRangeInfo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/semantics/ProgressBarRangeInfo;)V", "progressBarRangeInfo$delegate", "Landroidx/compose/ui/semantics/Role;", "role", "getRole", "setRole-kuIjeqM", "role$delegate", "selected", "getSelected", "setSelected", "selected$delegate", "stateDescription", "getStateDescription", "setStateDescription", "stateDescription$delegate", "testTag", "getTestTag", "setTestTag", "testTag$delegate", "text", "getText", "setText", "Landroidx/compose/ui/text/TextRange;", "textSelectionRange", "getTextSelectionRange", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", "setTextSelectionRange-FDrldGo", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;J)V", "textSelectionRange$delegate", "Landroidx/compose/ui/state/ToggleableState;", "toggleableState", "getToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", "setToggleableState", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Landroidx/compose/ui/state/ToggleableState;)V", "toggleableState$delegate", "verticalScrollAxisRange", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "verticalScrollAxisRange$delegate", "ActionPropertyKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/AccessibilityAction;", "T", "Lkotlin/Function;", "name", "throwSemanticsGetNotSupported", "()Ljava/lang/Object;", "collapse", "", "label", "action", "Lkotlin/Function0;", "copyText", "cutText", "dialog", "disabled", "dismiss", "error", "description", "expand", "getTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "heading", "indexForKey", "mapping", "", "", "invisibleToUser", "onClick", "onLongClick", "password", "pasteText", "popup", "scrollBy", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "x", "y", "scrollToIndex", "selectableGroup", "setProgress", "setSelection", "Lkotlin/Function3;", "startIndex", "endIndex", "traversalMode", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SemanticsProperties.kt */
public final class SemanticsPropertiesKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private static final SemanticsPropertyKey collectionInfo$delegate = SemanticsProperties.INSTANCE.getCollectionInfo();
    private static final SemanticsPropertyKey collectionItemInfo$delegate = SemanticsProperties.INSTANCE.getCollectionItemInfo();
    private static final SemanticsPropertyKey customActions$delegate = SemanticsActions.INSTANCE.getCustomActions();
    private static final SemanticsPropertyKey editableText$delegate = SemanticsProperties.INSTANCE.getEditableText();
    private static final SemanticsPropertyKey focused$delegate = SemanticsProperties.INSTANCE.getFocused();
    private static final SemanticsPropertyKey horizontalScrollAxisRange$delegate = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
    private static final SemanticsPropertyKey imeAction$delegate = SemanticsProperties.INSTANCE.getImeAction();
    private static final SemanticsPropertyKey liveRegion$delegate = SemanticsProperties.INSTANCE.getLiveRegion();
    private static final SemanticsPropertyKey paneTitle$delegate = SemanticsProperties.INSTANCE.getPaneTitle();
    private static final SemanticsPropertyKey progressBarRangeInfo$delegate = SemanticsProperties.INSTANCE.getProgressBarRangeInfo();
    private static final SemanticsPropertyKey role$delegate = SemanticsProperties.INSTANCE.getRole();
    private static final SemanticsPropertyKey selected$delegate = SemanticsProperties.INSTANCE.getSelected();
    private static final SemanticsPropertyKey stateDescription$delegate = SemanticsProperties.INSTANCE.getStateDescription();
    private static final SemanticsPropertyKey testTag$delegate = SemanticsProperties.INSTANCE.getTestTag();
    private static final SemanticsPropertyKey textSelectionRange$delegate = SemanticsProperties.INSTANCE.getTextSelectionRange();
    private static final SemanticsPropertyKey toggleableState$delegate = SemanticsProperties.INSTANCE.getToggleableState();
    private static final SemanticsPropertyKey verticalScrollAxisRange$delegate = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();

    /* access modifiers changed from: private */
    public static final <T> T throwSemanticsGetNotSupported() {
        throw new UnsupportedOperationException("You cannot retrieve a semantics property directly - use one of the SemanticsConfiguration.getOr* methods instead");
    }

    public static final <T extends Function<? extends Boolean>> SemanticsPropertyKey<AccessibilityAction<T>> ActionPropertyKey(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new SemanticsPropertyKey<>(str, SemanticsPropertiesKt$ActionPropertyKey$1.INSTANCE);
    }

    public static final String getContentDescription(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (String) throwSemanticsGetNotSupported();
    }

    public static final void setContentDescription(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getContentDescription(), CollectionsKt.listOf(str));
    }

    static {
        Class<SemanticsPropertiesKt> cls = SemanticsPropertiesKt.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1))};
    }

    public static final String getStateDescription(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (String) stateDescription$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[0]);
    }

    public static final void setStateDescription(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        stateDescription$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[0], str);
    }

    public static final ProgressBarRangeInfo getProgressBarRangeInfo(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (ProgressBarRangeInfo) progressBarRangeInfo$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[1]);
    }

    public static final void setProgressBarRangeInfo(SemanticsPropertyReceiver semanticsPropertyReceiver, ProgressBarRangeInfo progressBarRangeInfo) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(progressBarRangeInfo, "<set-?>");
        progressBarRangeInfo$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[1], progressBarRangeInfo);
    }

    public static final void heading(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getHeading(), Unit.INSTANCE);
    }

    public static final String getPaneTitle(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (String) paneTitle$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[2]);
    }

    public static final void setPaneTitle(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        paneTitle$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[2], str);
    }

    public static final void disabled(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getDisabled(), Unit.INSTANCE);
    }

    public static final int getLiveRegion(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return ((LiveRegionMode) liveRegion$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[3])).m3467unboximpl();
    }

    /* renamed from: setLiveRegion-hR3wRGc  reason: not valid java name */
    public static final void m3489setLiveRegionhR3wRGc(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$liveRegion");
        liveRegion$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[3], LiveRegionMode.m3461boximpl(i));
    }

    public static final boolean getFocused(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return ((Boolean) focused$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[4])).booleanValue();
    }

    public static final void setFocused(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        focused$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    @ExperimentalComposeUiApi
    public static final void invisibleToUser(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getInvisibleToUser(), Unit.INSTANCE);
    }

    public static final ScrollAxisRange getHorizontalScrollAxisRange(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (ScrollAxisRange) horizontalScrollAxisRange$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[5]);
    }

    public static final void setHorizontalScrollAxisRange(SemanticsPropertyReceiver semanticsPropertyReceiver, ScrollAxisRange scrollAxisRange) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(scrollAxisRange, "<set-?>");
        horizontalScrollAxisRange$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[5], scrollAxisRange);
    }

    public static final ScrollAxisRange getVerticalScrollAxisRange(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (ScrollAxisRange) verticalScrollAxisRange$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[6]);
    }

    public static final void setVerticalScrollAxisRange(SemanticsPropertyReceiver semanticsPropertyReceiver, ScrollAxisRange scrollAxisRange) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(scrollAxisRange, "<set-?>");
        verticalScrollAxisRange$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[6], scrollAxisRange);
    }

    public static final void popup(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIsPopup(), Unit.INSTANCE);
    }

    public static final void dialog(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIsDialog(), Unit.INSTANCE);
    }

    public static final int getRole(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return ((Role) role$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[7])).m3476unboximpl();
    }

    /* renamed from: setRole-kuIjeqM  reason: not valid java name */
    public static final void m3490setRolekuIjeqM(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$role");
        role$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[7], Role.m3470boximpl(i));
    }

    public static final String getTestTag(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (String) testTag$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[8]);
    }

    public static final void setTestTag(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        testTag$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[8], str);
    }

    public static final AnnotatedString getText(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (AnnotatedString) throwSemanticsGetNotSupported();
    }

    public static final void setText(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(annotatedString, "value");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getText(), CollectionsKt.listOf(annotatedString));
    }

    public static final AnnotatedString getEditableText(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (AnnotatedString) editableText$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[9]);
    }

    public static final void setEditableText(SemanticsPropertyReceiver semanticsPropertyReceiver, AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(annotatedString, "<set-?>");
        editableText$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[9], annotatedString);
    }

    public static final long getTextSelectionRange(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return ((TextRange) textSelectionRange$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[10])).m3575unboximpl();
    }

    /* renamed from: setTextSelectionRange-FDrldGo  reason: not valid java name */
    public static final void m3491setTextSelectionRangeFDrldGo(SemanticsPropertyReceiver semanticsPropertyReceiver, long j) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$textSelectionRange");
        textSelectionRange$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[10], TextRange.m3559boximpl(j));
    }

    public static final int getImeAction(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return ((ImeAction) imeAction$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[11])).m3641unboximpl();
    }

    /* renamed from: setImeAction-4L7nppU  reason: not valid java name */
    public static final void m3488setImeAction4L7nppU(SemanticsPropertyReceiver semanticsPropertyReceiver, int i) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$imeAction");
        imeAction$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[11], ImeAction.m3635boximpl(i));
    }

    public static final boolean getSelected(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return ((Boolean) selected$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[12])).booleanValue();
    }

    public static final void setSelected(SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        selected$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[12], Boolean.valueOf(z));
    }

    public static final CollectionInfo getCollectionInfo(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (CollectionInfo) collectionInfo$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[13]);
    }

    public static final void setCollectionInfo(SemanticsPropertyReceiver semanticsPropertyReceiver, CollectionInfo collectionInfo) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(collectionInfo, "<set-?>");
        collectionInfo$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[13], collectionInfo);
    }

    public static final CollectionItemInfo getCollectionItemInfo(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (CollectionItemInfo) collectionItemInfo$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[14]);
    }

    public static final void setCollectionItemInfo(SemanticsPropertyReceiver semanticsPropertyReceiver, CollectionItemInfo collectionItemInfo) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(collectionItemInfo, "<set-?>");
        collectionItemInfo$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[14], collectionItemInfo);
    }

    public static final ToggleableState getToggleableState(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (ToggleableState) toggleableState$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[15]);
    }

    public static final void setToggleableState(SemanticsPropertyReceiver semanticsPropertyReceiver, ToggleableState toggleableState) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(toggleableState, "<set-?>");
        toggleableState$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[15], toggleableState);
    }

    public static final void password(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getPassword(), Unit.INSTANCE);
    }

    public static final void error(SemanticsPropertyReceiver semanticsPropertyReceiver, String str) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(str, "description");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getError(), str);
    }

    public static final void indexForKey(SemanticsPropertyReceiver semanticsPropertyReceiver, Function1<Object, Integer> function1) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(function1, "mapping");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIndexForKey(), function1);
    }

    public static final void selectableGroup(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getSelectableGroup(), Unit.INSTANCE);
    }

    public static final List<CustomAccessibilityAction> getCustomActions(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return (List) customActions$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[16]);
    }

    public static final void setCustomActions(SemanticsPropertyReceiver semanticsPropertyReceiver, List<CustomAccessibilityAction> list) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        customActions$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[16], list);
    }

    public static /* synthetic */ void getTextLayoutResult$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        getTextLayoutResult(semanticsPropertyReceiver, str, function1);
    }

    public static final void getTextLayoutResult(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1<? super List<TextLayoutResult>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getGetTextLayoutResult(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void onClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onClick(semanticsPropertyReceiver, str, function0);
    }

    public static final void onClick(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnClick(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void onLongClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        onLongClick(semanticsPropertyReceiver, str, function0);
    }

    public static final void onLongClick(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnLongClick(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void scrollBy$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        scrollBy(semanticsPropertyReceiver, str, function2);
    }

    public static final void scrollBy(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function2<? super Float, ? super Float, Boolean> function2) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollBy(), new AccessibilityAction(str, function2));
    }

    public static /* synthetic */ void scrollToIndex$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        scrollToIndex(semanticsPropertyReceiver, str, function1);
    }

    public static final void scrollToIndex(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollToIndex(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void setProgress$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setProgress(semanticsPropertyReceiver, str, function1);
    }

    public static final void setProgress(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetProgress(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void setText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setText(semanticsPropertyReceiver, str, function1);
    }

    public static final void setText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function1<? super AnnotatedString, Boolean> function1) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetText(), new AccessibilityAction(str, function1));
    }

    public static /* synthetic */ void setSelection$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setSelection(semanticsPropertyReceiver, str, function3);
    }

    public static final void setSelection(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function3<? super Integer, ? super Integer, ? super Boolean, Boolean> function3) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetSelection(), new AccessibilityAction(str, function3));
    }

    public static /* synthetic */ void copyText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        copyText(semanticsPropertyReceiver, str, function0);
    }

    public static final void copyText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCopyText(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void cutText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        cutText(semanticsPropertyReceiver, str, function0);
    }

    public static final void cutText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCutText(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void pasteText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pasteText(semanticsPropertyReceiver, str, function0);
    }

    public static final void pasteText(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPasteText(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void expand$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        expand(semanticsPropertyReceiver, str, function0);
    }

    public static final void expand(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getExpand(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void collapse$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        collapse(semanticsPropertyReceiver, str, function0);
    }

    public static final void collapse(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCollapse(), new AccessibilityAction(str, function0));
    }

    public static /* synthetic */ void dismiss$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        dismiss(semanticsPropertyReceiver, str, function0);
    }

    public static final void dismiss(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getDismiss(), new AccessibilityAction(str, function0));
    }
}
