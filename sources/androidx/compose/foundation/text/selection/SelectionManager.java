package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010P\u001a\u0004\u0018\u00010\u00132\u0006\u0010Q\u001a\u00020\f2\u0006\u0010R\u001a\u00020\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bS\u0010TJ\r\u0010U\u001a\u000208H\u0000¢\u0006\u0002\bVJ\u0018\u0010W\u001a\u0004\u0018\u00010\u0013H\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0002\bXJ\b\u0010Y\u001a\u00020ZH\u0002J\u000f\u0010[\u001a\u0004\u0018\u00010\\H\u0000¢\u0006\u0002\b]J\u000e\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020*J\r\u0010a\u001a\u000208H\u0000¢\u0006\u0002\bbJ\u0006\u0010c\u001a\u000208J\r\u0010d\u001a\u00020\fH\u0000¢\u0006\u0002\beJ9\u0010f\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020i\u0012\u0004\u0012\u0002070h0g2\u0006\u0010j\u001a\u00020i2\b\u0010k\u001a\u0004\u0018\u000107H\u0000¢\u0006\u0002\blJ\r\u0010m\u001a\u000208H\u0000¢\u0006\u0002\bnJ-\u0010o\u001a\u0002082\u0006\u0010p\u001a\u00020\u00132\u0006\u0010`\u001a\u00020*2\u0006\u0010q\u001a\u00020rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bs\u0010tJ\b\u0010u\u001a\u000208H\u0002J?\u0010v\u001a\u00020*2\u0006\u0010C\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010w\u001a\u0004\u0018\u00010\u00132\u0006\u0010`\u001a\u00020*2\u0006\u0010q\u001a\u00020rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bx\u0010yJ7\u0010v\u001a\u00020*2\b\u0010z\u001a\u0004\u0018\u00010\u00132\b\u0010=\u001a\u0004\u0018\u00010\u00132\u0006\u0010`\u001a\u00020*2\u0006\u0010q\u001a\u00020rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b{J\b\u0010|\u001a\u000208H\u0002J-\u0010}\u001a\u000208*\u00020~2\u0012\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020806H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\u000202*\u0002022\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u0002080\u0001H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u0013X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R\u0019\u0010\u0015\u001a\u00020\u0013X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0014R8\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00138F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R+\u0010+\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020*8F@FX\u0002¢\u0006\u0012\n\u0004\b0\u0010\u001d\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u00101\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b3\u00104R(\u00105\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0004\u0012\u00020806X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0019\u0010=\u001a\u0004\u0018\u00010\u0013X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R(\u0010>\u001a\u0004\u0018\u0001072\b\u0010\u000b\u001a\u0004\u0018\u000107@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R8\u0010C\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00138F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bF\u0010\u001d\u001a\u0004\bD\u0010\u0019\"\u0004\bE\u0010\u001bR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010-\"\u0004\bO\u0010/\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "value", "Landroidx/compose/ui/layout/LayoutCoordinates;", "containerLayoutCoordinates", "getContainerLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragTotalDistance", "<set-?>", "endHandlePosition", "getEndHandlePosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setEndHandlePosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "endHandlePosition$delegate", "Landroidx/compose/runtime/MutableState;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "onSelectionChange", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/selection/Selection;", "", "getOnSelectionChange", "()Lkotlin/jvm/functions/Function1;", "setOnSelectionChange", "(Lkotlin/jvm/functions/Function1;)V", "previousPosition", "selection", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "startHandlePosition", "getStartHandlePosition-_m7T9-E", "setStartHandlePosition-_kEHs6E", "startHandlePosition$delegate", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "touchMode", "getTouchMode", "setTouchMode", "convertToContainerCoordinates", "layoutCoordinates", "offset", "convertToContainerCoordinates-Q7Q5hAU", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)Landroidx/compose/ui/geometry/Offset;", "copy", "copy$foundation_release", "currentSelectionStartPosition", "currentSelectionStartPosition-_m7T9-E", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "getSelectedText$foundation_release", "handleDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "isStartHandle", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "onRelease", "requireContainerCoordinates", "requireContainerCoordinates$foundation_release", "selectAll", "Lkotlin/Pair;", "", "", "selectableId", "previousSelection", "selectAll$foundation_release", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "startSelection", "position", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "updateHandleOffsets", "updateSelection", "previousHandlePosition", "updateSelection-3R_-tFg$foundation_release", "(JJLandroidx/compose/ui/geometry/Offset;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "newPosition", "updateSelection-RHHTvR4$foundation_release", "updateSelectionToolbarPosition", "detectNonConsumingTap", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClearSelectionRequested", "block", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
public final class SelectionManager {
    private ClipboardManager clipboardManager;
    private LayoutCoordinates containerLayoutCoordinates;
    /* access modifiers changed from: private */
    public long dragBeginPosition = Offset.Companion.m1369getZeroF1C5BW0();
    /* access modifiers changed from: private */
    public long dragTotalDistance = Offset.Companion.m1369getZeroF1C5BW0();
    private final MutableState endHandlePosition$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.structuralEqualityPolicy());
    private FocusRequester focusRequester = new FocusRequester();
    private HapticFeedback hapticFeedBack;
    private final MutableState hasFocus$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private Function1<? super Selection, Unit> onSelectionChange = SelectionManager$onSelectionChange$1.INSTANCE;
    private Offset previousPosition;
    private Selection selection;
    /* access modifiers changed from: private */
    public final SelectionRegistrarImpl selectionRegistrar;
    private final MutableState startHandlePosition$delegate = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.structuralEqualityPolicy());
    private TextToolbar textToolbar;
    private boolean touchMode = true;

    public SelectionManager(SelectionRegistrarImpl selectionRegistrarImpl) {
        Intrinsics.checkNotNullParameter(selectionRegistrarImpl, "selectionRegistrar");
        this.selectionRegistrar = selectionRegistrarImpl;
        selectionRegistrarImpl.setOnPositionChangeCallback$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
                r0 = r0.getStart();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(long r6) {
                /*
                    r5 = this;
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    r1 = 1
                    r2 = 0
                    if (r0 != 0) goto L_0x000c
                L_0x000a:
                    r0 = 0
                    goto L_0x001c
                L_0x000c:
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getStart()
                    if (r0 != 0) goto L_0x0013
                    goto L_0x000a
                L_0x0013:
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x000a
                    r0 = 1
                L_0x001c:
                    if (r0 != 0) goto L_0x0039
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    if (r0 != 0) goto L_0x0028
                L_0x0026:
                    r1 = 0
                    goto L_0x0037
                L_0x0028:
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getEnd()
                    if (r0 != 0) goto L_0x002f
                    goto L_0x0026
                L_0x002f:
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x0026
                L_0x0037:
                    if (r1 == 0) goto L_0x0043
                L_0x0039:
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.this$0
                    r6.updateHandleOffsets()
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.this$0
                    r6.updateSelectionToolbarPosition()
                L_0x0043:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass1.invoke(long):void");
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateStartCallback$foundation_release(new Function3<LayoutCoordinates, Offset, SelectionAdjustment, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m787invoked4ec7I((LayoutCoordinates) obj, ((Offset) obj2).m1363unboximpl(), (SelectionAdjustment) obj3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-d-4ec7I  reason: not valid java name */
            public final void m787invoked4ec7I(LayoutCoordinates layoutCoordinates, long j, SelectionAdjustment selectionAdjustment) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionAdjustment, "selectionMode");
                Offset r3 = this.this$0.m778convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j);
                if (r3 != null) {
                    this.this$0.m782startSelection9KIMszo(r3.m1363unboximpl(), false, selectionAdjustment);
                    this.this$0.getFocusRequester().requestFocus();
                    this.this$0.hideSelectionToolbar$foundation_release();
                }
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateSelectAll$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                SelectionManager selectionManager = this.this$0;
                Pair<Selection, Map<Long, Selection>> selectAll$foundation_release = selectionManager.selectAll$foundation_release(j, selectionManager.getSelection());
                Selection component1 = selectAll$foundation_release.component1();
                Map component2 = selectAll$foundation_release.component2();
                if (!Intrinsics.areEqual((Object) component1, (Object) this.this$0.getSelection())) {
                    this.this$0.selectionRegistrar.setSubselections(component2);
                    this.this$0.getOnSelectionChange().invoke(component1);
                }
                this.this$0.getFocusRequester().requestFocus();
                this.this$0.hideSelectionToolbar$foundation_release();
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateCallback$foundation_release(new Function5<LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return m788invoke5iVPX68((LayoutCoordinates) obj, ((Offset) obj2).m1363unboximpl(), ((Offset) obj3).m1363unboximpl(), ((Boolean) obj4).booleanValue(), (SelectionAdjustment) obj5);
            }

            /* renamed from: invoke-5iVPX68  reason: not valid java name */
            public final Boolean m788invoke5iVPX68(LayoutCoordinates layoutCoordinates, long j, long j2, boolean z, SelectionAdjustment selectionAdjustment) {
                Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                Intrinsics.checkNotNullParameter(selectionAdjustment, "selectionMode");
                return Boolean.valueOf(this.this$0.m786updateSelectionRHHTvR4$foundation_release(this.this$0.m778convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j), this.this$0.m778convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, j2), z, selectionAdjustment));
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateEndCallback$foundation_release(new Function0<Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.showSelectionToolbar$foundation_release();
            }
        });
        selectionRegistrarImpl.setOnSelectableChangeCallback$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                if (this.this$0.selectionRegistrar.getSubselections().containsKey(Long.valueOf(j))) {
                    this.this$0.onRelease();
                    this.this$0.setSelection((Selection) null);
                }
            }
        });
        selectionRegistrarImpl.setAfterSelectableUnsubscribe$foundation_release(new Function1<Long, Unit>(this) {
            final /* synthetic */ SelectionManager this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
                r0 = r0.getStart();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(long r6) {
                /*
                    r5 = this;
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    r1 = 1
                    r2 = 0
                    if (r0 != 0) goto L_0x000c
                L_0x000a:
                    r0 = 0
                    goto L_0x001c
                L_0x000c:
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getStart()
                    if (r0 != 0) goto L_0x0013
                    goto L_0x000a
                L_0x0013:
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x000a
                    r0 = 1
                L_0x001c:
                    if (r0 != 0) goto L_0x0039
                    androidx.compose.foundation.text.selection.SelectionManager r0 = r5.this$0
                    androidx.compose.foundation.text.selection.Selection r0 = r0.getSelection()
                    if (r0 != 0) goto L_0x0028
                L_0x0026:
                    r1 = 0
                    goto L_0x0037
                L_0x0028:
                    androidx.compose.foundation.text.selection.Selection$AnchorInfo r0 = r0.getEnd()
                    if (r0 != 0) goto L_0x002f
                    goto L_0x0026
                L_0x002f:
                    long r3 = r0.getSelectableId()
                    int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                    if (r0 != 0) goto L_0x0026
                L_0x0037:
                    if (r1 == 0) goto L_0x0044
                L_0x0039:
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.this$0
                    r7 = 0
                    r6.m781setStartHandlePosition_kEHs6E(r7)
                    androidx.compose.foundation.text.selection.SelectionManager r6 = r5.this$0
                    r6.m780setEndHandlePosition_kEHs6E(r7)
                L_0x0044:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.AnonymousClass7.invoke(long):void");
            }
        });
    }

    public final Selection getSelection() {
        return this.selection;
    }

    public final void setSelection(Selection selection2) {
        this.selection = selection2;
        if (selection2 != null) {
            updateHandleOffsets();
        }
    }

    public final boolean getTouchMode() {
        return this.touchMode;
    }

    public final void setTouchMode(boolean z) {
        this.touchMode = z;
    }

    public final Function1<Selection, Unit> getOnSelectionChange() {
        return this.onSelectionChange;
    }

    public final void setOnSelectionChange(Function1<? super Selection, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onSelectionChange = function1;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public final void setClipboardManager(ClipboardManager clipboardManager2) {
        this.clipboardManager = clipboardManager2;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar2) {
        this.textToolbar = textToolbar2;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester2) {
        Intrinsics.checkNotNullParameter(focusRequester2, "<set-?>");
        this.focusRequester = focusRequester2;
    }

    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    public final void setHasFocus(boolean z) {
        this.hasFocus$delegate.setValue(Boolean.valueOf(z));
    }

    public final Modifier getModifier() {
        return KeyInputModifierKt.onKeyEvent(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(Modifier.Companion, new SelectionManager$modifier$1(this)), new SelectionManager$modifier$2(this)), this.focusRequester), new SelectionManager$modifier$3(this)), false, (MutableInteractionSource) null, 3, (Object) null), new SelectionManager$modifier$4(this));
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        Offset offset;
        this.containerLayoutCoordinates = layoutCoordinates;
        if (getHasFocus() && this.selection != null) {
            if (layoutCoordinates == null) {
                offset = null;
            } else {
                offset = Offset.m1342boximpl(LayoutCoordinatesKt.positionInWindow(layoutCoordinates));
            }
            if (!Intrinsics.areEqual((Object) this.previousPosition, (Object) offset)) {
                this.previousPosition = offset;
                updateHandleOffsets();
                updateSelectionToolbarPosition();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setStartHandlePosition-_kEHs6E  reason: not valid java name */
    public final void m781setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition$delegate.setValue(offset);
    }

    /* renamed from: getStartHandlePosition-_m7T9-E  reason: not valid java name */
    public final Offset m784getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: setEndHandlePosition-_kEHs6E  reason: not valid java name */
    public final void m780setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition$delegate.setValue(offset);
    }

    /* renamed from: getEndHandlePosition-_m7T9-E  reason: not valid java name */
    public final Offset m783getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition$delegate.getValue();
    }

    /* renamed from: currentSelectionStartPosition-_m7T9-E  reason: not valid java name */
    private final Offset m779currentSelectionStartPosition_m7T9E() {
        Selection selection2 = this.selection;
        LayoutCoordinates layoutCoordinates = null;
        if (selection2 == null) {
            return null;
        }
        Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection2.getStart().getSelectableId()));
        LayoutCoordinates requireContainerCoordinates$foundation_release = requireContainerCoordinates$foundation_release();
        if (selectable != null) {
            layoutCoordinates = selectable.getLayoutCoordinates();
        }
        Intrinsics.checkNotNull(layoutCoordinates);
        return Offset.m1342boximpl(requireContainerCoordinates$foundation_release.m3141localPositionOfR5De75A(layoutCoordinates, SelectionHandlesKt.m773getAdjustedCoordinatesk4lQ0M(selectable.m756getHandlePositiondBAh8RU(selection2, true))));
    }

    /* access modifiers changed from: private */
    public final void updateHandleOffsets() {
        Selectable selectable;
        Selectable selectable2;
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        Selection.AnchorInfo end;
        Selection.AnchorInfo start;
        Selection selection2 = this.selection;
        LayoutCoordinates layoutCoordinates3 = this.containerLayoutCoordinates;
        Offset offset = null;
        if (selection2 == null || (start = selection2.getStart()) == null) {
            selectable = null;
        } else {
            selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(start.getSelectableId()));
        }
        if (selection2 == null || (end = selection2.getEnd()) == null) {
            selectable2 = null;
        } else {
            selectable2 = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(end.getSelectableId()));
        }
        if (selectable == null) {
            layoutCoordinates = null;
        } else {
            layoutCoordinates = selectable.getLayoutCoordinates();
        }
        if (selectable2 == null) {
            layoutCoordinates2 = null;
        } else {
            layoutCoordinates2 = selectable2.getLayoutCoordinates();
        }
        if (selection2 == null || layoutCoordinates3 == null || !layoutCoordinates3.isAttached() || layoutCoordinates == null || layoutCoordinates2 == null) {
            m781setStartHandlePosition_kEHs6E((Offset) null);
            m780setEndHandlePosition_kEHs6E((Offset) null);
            return;
        }
        long r7 = layoutCoordinates3.m3141localPositionOfR5De75A(layoutCoordinates, selectable.m756getHandlePositiondBAh8RU(selection2, true));
        long r3 = layoutCoordinates3.m3141localPositionOfR5De75A(layoutCoordinates2, selectable2.m756getHandlePositiondBAh8RU(selection2, false));
        Rect visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates3);
        m781setStartHandlePosition_kEHs6E(SelectionManagerKt.m793containsInclusiveUv8p0NA(visibleBounds, r7) ? Offset.m1342boximpl(r7) : null);
        if (SelectionManagerKt.m793containsInclusiveUv8p0NA(visibleBounds, r3)) {
            offset = Offset.m1342boximpl(r3);
        }
        m780setEndHandlePosition_kEHs6E(offset);
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (!(layoutCoordinates != null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (layoutCoordinates.isAttached()) {
            return layoutCoordinates;
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final Pair<Selection, Map<Long, Selection>> selectAll$foundation_release(long j, Selection selection2) {
        HapticFeedback hapticFeedback;
        Map linkedHashMap = new LinkedHashMap();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        int i = 0;
        Selection selection3 = null;
        while (i < size) {
            int i2 = i + 1;
            Selectable selectable = sort.get(i);
            Selection selectAllSelection = selectable.getSelectableId() == j ? selectable.getSelectAllSelection() : null;
            if (selectAllSelection != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), selectAllSelection);
            }
            selection3 = SelectionManagerKt.merge(selection3, selectAllSelection);
            i = i2;
        }
        if (!Intrinsics.areEqual((Object) selection3, (Object) selection2) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.m2230performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2239getTextHandleMove5zf0vsI());
        }
        return new Pair<>(selection3, linkedHashMap);
    }

    public final AnnotatedString getSelectedText$foundation_release() {
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        Selection selection2 = this.selection;
        AnnotatedString annotatedString = null;
        if (selection2 != null) {
            int i = 0;
            int size = sort.size();
            while (i < size) {
                int i2 = i + 1;
                Selectable selectable = sort.get(i);
                if (selectable.getSelectableId() == selection2.getStart().getSelectableId() || selectable.getSelectableId() == selection2.getEnd().getSelectableId() || annotatedString != null) {
                    AnnotatedString currentSelectedText = SelectionManagerKt.getCurrentSelectedText(selectable, selection2);
                    if (annotatedString == null || (annotatedString = annotatedString.plus(currentSelectedText)) == null) {
                        annotatedString = currentSelectedText;
                    }
                    if (selectable.getSelectableId() == selection2.getEnd().getSelectableId()) {
                        if (!selection2.getHandlesCrossed()) {
                            break;
                        }
                    }
                    if (selectable.getSelectableId() == selection2.getStart().getSelectableId() && selection2.getHandlesCrossed()) {
                        break;
                    }
                }
                i = i2;
            }
        }
        return annotatedString;
    }

    public final void copy$foundation_release() {
        ClipboardManager clipboardManager2;
        AnnotatedString selectedText$foundation_release = getSelectedText$foundation_release();
        if (selectedText$foundation_release != null && (clipboardManager2 = getClipboardManager()) != null) {
            clipboardManager2.setText(selectedText$foundation_release);
        }
    }

    public final void showSelectionToolbar$foundation_release() {
        TextToolbar textToolbar2;
        if (getHasFocus() && this.selection != null && (textToolbar2 = getTextToolbar()) != null) {
            TextToolbar.DefaultImpls.showMenu$default(textToolbar2, getContentRect(), new SelectionManager$showSelectionToolbar$1$1(this), (Function0) null, (Function0) null, (Function0) null, 28, (Object) null);
        }
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar2;
        if (getHasFocus()) {
            TextToolbar textToolbar3 = this.textToolbar;
            if ((textToolbar3 == null ? null : textToolbar3.getStatus()) == TextToolbarStatus.Shown && (textToolbar2 = this.textToolbar) != null) {
                textToolbar2.hide();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateSelectionToolbarPosition() {
        if (getHasFocus()) {
            TextToolbar textToolbar2 = this.textToolbar;
            if ((textToolbar2 == null ? null : textToolbar2.getStatus()) == TextToolbarStatus.Shown) {
                showSelectionToolbar$foundation_release();
            }
        }
    }

    private final Rect getContentRect() {
        LayoutCoordinates layoutCoordinates;
        Selection selection2 = this.selection;
        if (selection2 == null) {
            return Rect.Companion.getZero();
        }
        Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection2.getStart().getSelectableId()));
        Selectable selectable2 = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection2.getStart().getSelectableId()));
        LayoutCoordinates layoutCoordinates2 = null;
        if (selectable == null) {
            layoutCoordinates = null;
        } else {
            layoutCoordinates = selectable.getLayoutCoordinates();
        }
        if (layoutCoordinates == null) {
            return Rect.Companion.getZero();
        }
        if (selectable2 != null) {
            layoutCoordinates2 = selectable2.getLayoutCoordinates();
        }
        if (layoutCoordinates2 == null) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates layoutCoordinates3 = this.containerLayoutCoordinates;
        if (layoutCoordinates3 == null || !layoutCoordinates3.isAttached()) {
            return Rect.Companion.getZero();
        }
        long r6 = layoutCoordinates3.m3141localPositionOfR5De75A(layoutCoordinates, selectable.m756getHandlePositiondBAh8RU(selection2, true));
        long r8 = layoutCoordinates3.m3141localPositionOfR5De75A(layoutCoordinates2, selectable2.m756getHandlePositiondBAh8RU(selection2, false));
        long r62 = layoutCoordinates3.m3142localToRootMKHz9U(r6);
        long r82 = layoutCoordinates3.m3142localToRootMKHz9U(r8);
        return new Rect(Math.min(Offset.m1353getXimpl(r62), Offset.m1353getXimpl(r82)), Math.min(Offset.m1354getYimpl(layoutCoordinates3.m3142localToRootMKHz9U(layoutCoordinates3.m3141localPositionOfR5De75A(layoutCoordinates, OffsetKt.Offset(0.0f, selectable.getBoundingBox(selection2.getStart().getOffset()).getTop())))), Offset.m1354getYimpl(layoutCoordinates3.m3142localToRootMKHz9U(layoutCoordinates3.m3141localPositionOfR5De75A(layoutCoordinates2, OffsetKt.Offset(0.0f, selectable2.getBoundingBox(selection2.getEnd().getOffset()).getTop()))))), Math.max(Offset.m1353getXimpl(r62), Offset.m1353getXimpl(r82)), Math.max(Offset.m1354getYimpl(r62), Offset.m1354getYimpl(r82)) + ((float) (((double) SelectionHandlesKt.getHandleHeight()) * 4.0d)));
    }

    public final void onRelease() {
        this.selectionRegistrar.setSubselections(MapsKt.emptyMap());
        hideSelectionToolbar$foundation_release();
        if (this.selection != null) {
            this.onSelectionChange.invoke(null);
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.m2230performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2239getTextHandleMove5zf0vsI());
            }
        }
    }

    public final TextDragObserver handleDragObserver(boolean z) {
        return new SelectionManager$handleDragObserver$1(this, z);
    }

    /* access modifiers changed from: private */
    public final Object detectNonConsumingTap(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new SelectionManager$detectNonConsumingTap$2(function1, (Continuation<? super SelectionManager$detectNonConsumingTap$2>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    private final Modifier onClearSelectionRequested(Modifier modifier, Function0<Unit> function0) {
        return getHasFocus() ? SuspendingPointerInputFilterKt.pointerInput(modifier, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionManager$onClearSelectionRequested$1(this, function0, (Continuation<? super SelectionManager$onClearSelectionRequested$1>) null)) : modifier;
    }

    /* access modifiers changed from: private */
    /* renamed from: convertToContainerCoordinates-Q7Q5hAU  reason: not valid java name */
    public final Offset m778convertToContainerCoordinatesQ7Q5hAU(LayoutCoordinates layoutCoordinates, long j) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return null;
        }
        return Offset.m1342boximpl(requireContainerCoordinates$foundation_release().m3141localPositionOfR5De75A(layoutCoordinates, j));
    }

    /* access modifiers changed from: private */
    /* renamed from: startSelection-9KIMszo  reason: not valid java name */
    public final void m782startSelection9KIMszo(long j, boolean z, SelectionAdjustment selectionAdjustment) {
        m785updateSelection3R_tFg$foundation_release(j, j, (Offset) null, z, selectionAdjustment);
    }

    /* renamed from: updateSelection-RHHTvR4$foundation_release  reason: not valid java name */
    public final boolean m786updateSelectionRHHTvR4$foundation_release(Offset offset, Offset offset2, boolean z, SelectionAdjustment selectionAdjustment) {
        long j;
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        if (offset == null) {
            return false;
        }
        Selection selection2 = this.selection;
        Offset offset3 = null;
        if (selection2 != null) {
            if (z) {
                j = selection2.getEnd().getSelectableId();
            } else {
                j = selection2.getStart().getSelectableId();
            }
            Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(j));
            if (selectable != null) {
                LayoutCoordinates layoutCoordinates = selectable.getLayoutCoordinates();
                Intrinsics.checkNotNull(layoutCoordinates);
                offset3 = m778convertToContainerCoordinatesQ7Q5hAU(layoutCoordinates, SelectionHandlesKt.m773getAdjustedCoordinatesk4lQ0M(selectable.m756getHandlePositiondBAh8RU(selection2, !z)));
            }
        }
        if (offset3 == null) {
            return false;
        }
        long r0 = offset3.m1363unboximpl();
        long r2 = z ? offset.m1363unboximpl() : r0;
        if (!z) {
            r0 = offset.m1363unboximpl();
        }
        return m785updateSelection3R_tFg$foundation_release(r2, r0, offset2, z, selectionAdjustment);
    }

    /* renamed from: updateSelection-3R_-tFg$foundation_release  reason: not valid java name */
    public final boolean m785updateSelection3R_tFg$foundation_release(long j, long j2, Offset offset, boolean z, SelectionAdjustment selectionAdjustment) {
        Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
        Map linkedHashMap = new LinkedHashMap();
        List<Selectable> sort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = sort.size();
        Selection selection2 = null;
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = i + 1;
            Selectable selectable = sort.get(i);
            Selection selection3 = selection2;
            Pair<Selection, Boolean> r2 = selectable.m757updateSelectionqCDeeow(j, j2, offset, z, requireContainerCoordinates$foundation_release(), selectionAdjustment, this.selectionRegistrar.getSubselections().get(Long.valueOf(selectable.getSelectableId())));
            Selection component1 = r2.component1();
            z2 = z2 || r2.component2().booleanValue();
            if (component1 != null) {
                linkedHashMap.put(Long.valueOf(selectable.getSelectableId()), component1);
            }
            selection2 = SelectionManagerKt.merge(selection3, component1);
            i = i2;
        }
        Selection selection4 = selection2;
        if (!Intrinsics.areEqual((Object) selection4, (Object) this.selection)) {
            HapticFeedback hapticFeedback = this.hapticFeedBack;
            if (hapticFeedback != null) {
                hapticFeedback.m2230performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m2239getTextHandleMove5zf0vsI());
            }
            this.selectionRegistrar.setSubselections(linkedHashMap);
            this.onSelectionChange.invoke(selection4);
        }
        return z2;
    }
}
