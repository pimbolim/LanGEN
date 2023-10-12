package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+J\b\u0010,\u001a\u00020\u001cH\u0016J\u0006\u0010-\u001a\u00020\u000fJ\u0011\u0010.\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u001cH\u0002J\b\u00104\u001a\u00020\u001cH\u0016JI\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00152\u0018\u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u001c0\u00192\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0\u0019H\u0016ø\u0001\u0000J\b\u00107\u001a\u00020\u001cH\u0016J\u001a\u00108\u001a\u00020\u001c2\b\u00109\u001a\u0004\u0018\u00010\"2\u0006\u0010:\u001a\u00020\"H\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u001c0\u0019X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0\u0019X\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "(Landroid/view/View;Landroidx/compose/ui/text/input/InputMethodManager;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "getBaseInputConnection", "()Landroid/view/inputmethod/BaseInputConnection;", "baseInputConnection$delegate", "Lkotlin/Lazy;", "editorHasFocus", "", "focusedRect", "Landroid/graphics/Rect;", "ic", "Landroidx/compose/ui/text/input/RecordingInputConnection;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "showKeyboardChannel", "Lkotlinx/coroutines/channels/Channel;", "<set-?>", "Landroidx/compose/ui/text/input/TextFieldValue;", "state", "getState$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "getView", "()Landroid/view/View;", "createInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "hideSoftwareKeyboard", "isEditorFocused", "keyboardVisibilityEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyFocusedRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "restartInput", "showSoftwareKeyboard", "startInput", "value", "stopInput", "updateState", "oldValue", "newValue", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextInputServiceAndroid.android.kt */
public final class TextInputServiceAndroid implements PlatformTextInputService {
    private final Lazy baseInputConnection$delegate;
    private boolean editorHasFocus;
    private Rect focusedRect;
    private RecordingInputConnection ic;
    private ImeOptions imeOptions;
    private final InputMethodManager inputMethodManager;
    /* access modifiers changed from: private */
    public final ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    /* access modifiers changed from: private */
    public Function1<? super List<? extends EditCommand>, Unit> onEditCommand;
    /* access modifiers changed from: private */
    public Function1<? super ImeAction, Unit> onImeActionPerformed;
    private final Channel<Boolean> showKeyboardChannel;
    private TextFieldValue state;
    private final View view;

    public TextInputServiceAndroid(View view2, InputMethodManager inputMethodManager2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(inputMethodManager2, "inputMethodManager");
        this.view = view2;
        this.inputMethodManager = inputMethodManager2;
        this.onEditCommand = TextInputServiceAndroid$onEditCommand$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$onImeActionPerformed$1.INSTANCE;
        this.state = new TextFieldValue("", TextRange.Companion.m3576getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TextInputServiceAndroid$baseInputConnection$2(this));
        this.showKeyboardChannel = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                TextInputServiceAndroid.m3690layoutListener$lambda1(TextInputServiceAndroid.this);
            }
        };
        view2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            final /* synthetic */ TextInputServiceAndroid this$0;

            {
                this.this$0 = r1;
            }

            public void onViewDetachedFromWindow(View view) {
                View rootView;
                ViewTreeObserver viewTreeObserver;
                if (view != null && (rootView = view.getRootView()) != null && (viewTreeObserver = rootView.getViewTreeObserver()) != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this.this$0.layoutListener);
                }
            }

            public void onViewAttachedToWindow(View view) {
                View rootView;
                ViewTreeObserver viewTreeObserver;
                if (view != null && (rootView = view.getRootView()) != null && (viewTreeObserver = rootView.getViewTreeObserver()) != null) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.this$0.layoutListener);
                }
            }
        });
    }

    public final View getView() {
        return this.view;
    }

    public final TextFieldValue getState$ui_release() {
        return this.state;
    }

    /* access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: layoutListener$lambda-1  reason: not valid java name */
    public static final void m3690layoutListener$lambda1(TextInputServiceAndroid textInputServiceAndroid) {
        Intrinsics.checkNotNullParameter(textInputServiceAndroid, "this$0");
        Rect rect = textInputServiceAndroid.focusedRect;
        if (rect != null) {
            textInputServiceAndroid.getView().requestRectangleOnScreen(new Rect(rect));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputServiceAndroid(android.view.View r4) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.compose.ui.text.input.InputMethodManagerImpl r0 = new androidx.compose.ui.text.input.InputMethodManagerImpl
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "view.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.<init>(r1)
            androidx.compose.ui.text.input.InputMethodManager r0 = (androidx.compose.ui.text.input.InputMethodManager) r0
            r3.<init>(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextInputServiceAndroid.<init>(android.view.View):void");
    }

    public final InputConnection createInputConnection(EditorInfo editorInfo) {
        Intrinsics.checkNotNullParameter(editorInfo, "outAttrs");
        if (!this.editorHasFocus) {
            return null;
        }
        TextInputServiceAndroid_androidKt.update(editorInfo, this.imeOptions, this.state);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, new TextInputServiceAndroid$createInputConnection$1(this), this.imeOptions.getAutoCorrect());
        this.ic = recordingInputConnection;
        return recordingInputConnection;
    }

    public final boolean isEditorFocused() {
        return this.editorHasFocus;
    }

    public void startInput(TextFieldValue textFieldValue, ImeOptions imeOptions2, Function1<? super List<? extends EditCommand>, Unit> function1, Function1<? super ImeAction, Unit> function12) {
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        Intrinsics.checkNotNullParameter(imeOptions2, "imeOptions");
        Intrinsics.checkNotNullParameter(function1, "onEditCommand");
        Intrinsics.checkNotNullParameter(function12, "onImeActionPerformed");
        this.editorHasFocus = true;
        this.state = textFieldValue;
        this.imeOptions = imeOptions2;
        this.onEditCommand = function1;
        this.onImeActionPerformed = function12;
        this.view.post(new Runnable() {
            public final void run() {
                TextInputServiceAndroid.m3691startInput$lambda3(TextInputServiceAndroid.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: startInput$lambda-3  reason: not valid java name */
    public static final void m3691startInput$lambda3(TextInputServiceAndroid textInputServiceAndroid) {
        Intrinsics.checkNotNullParameter(textInputServiceAndroid, "this$0");
        textInputServiceAndroid.restartInput();
        textInputServiceAndroid.showSoftwareKeyboard();
    }

    public void stopInput() {
        this.editorHasFocus = false;
        this.onEditCommand = TextInputServiceAndroid$stopInput$1.INSTANCE;
        this.onImeActionPerformed = TextInputServiceAndroid$stopInput$2.INSTANCE;
        this.focusedRect = null;
        restartInput();
        this.editorHasFocus = false;
    }

    private final void restartInput() {
        this.inputMethodManager.restartInput(this.view);
    }

    public void showSoftwareKeyboard() {
        this.showKeyboardChannel.m6176trySendJP2dKIU(true);
    }

    public void hideSoftwareKeyboard() {
        this.showKeyboardChannel.m6176trySendJP2dKIU(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object keyboardVisibilityEventLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.text.input.TextInputServiceAndroid$keyboardVisibilityEventLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            androidx.compose.ui.text.input.TextInputServiceAndroid$keyboardVisibilityEventLoop$1 r0 = (androidx.compose.ui.text.input.TextInputServiceAndroid$keyboardVisibilityEventLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            androidx.compose.ui.text.input.TextInputServiceAndroid$keyboardVisibilityEventLoop$1 r0 = new androidx.compose.ui.text.input.TextInputServiceAndroid$keyboardVisibilityEventLoop$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r0.L$0
            androidx.compose.ui.text.input.TextInputServiceAndroid r4 = (androidx.compose.ui.text.input.TextInputServiceAndroid) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0052
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.channels.Channel<java.lang.Boolean> r7 = r6.showKeyboardChannel
            kotlinx.coroutines.channels.ChannelIterator r7 = r7.iterator()
            r4 = r6
            r2 = r7
        L_0x0045:
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r2.hasNext(r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0091
            java.lang.Object r7 = r2.next()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            kotlinx.coroutines.channels.Channel<java.lang.Boolean> r5 = r4.showKeyboardChannel
            java.lang.Object r5 = r5.m6174tryReceivePtdJZtk()
            java.lang.Object r5 = kotlinx.coroutines.channels.ChannelResult.m6159getOrNullimpl(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 != 0) goto L_0x0073
            goto L_0x0077
        L_0x0073:
            boolean r7 = r5.booleanValue()
        L_0x0077:
            if (r7 == 0) goto L_0x0083
            androidx.compose.ui.text.input.InputMethodManager r7 = r4.inputMethodManager
            android.view.View r5 = r4.getView()
            r7.showSoftInput(r5)
            goto L_0x0045
        L_0x0083:
            androidx.compose.ui.text.input.InputMethodManager r7 = r4.inputMethodManager
            android.view.View r5 = r4.getView()
            android.os.IBinder r5 = r5.getWindowToken()
            r7.hideSoftInputFromWindow(r5)
            goto L_0x0045
        L_0x0091:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextInputServiceAndroid.keyboardVisibilityEventLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void updateState(TextFieldValue textFieldValue, TextFieldValue textFieldValue2) {
        Intrinsics.checkNotNullParameter(textFieldValue2, "newValue");
        boolean z = true;
        boolean z2 = !TextRange.m3564equalsimpl0(this.state.m3688getSelectiond9O1mEE(), textFieldValue2.m3688getSelectiond9O1mEE());
        this.state = textFieldValue2;
        RecordingInputConnection recordingInputConnection = this.ic;
        if (recordingInputConnection != null) {
            recordingInputConnection.setMTextFieldValue$ui_release(textFieldValue2);
        }
        if (!Intrinsics.areEqual((Object) textFieldValue, (Object) textFieldValue2)) {
            boolean z3 = false;
            if (textFieldValue != null) {
                if (Intrinsics.areEqual((Object) textFieldValue.getText(), (Object) textFieldValue2.getText()) && (!TextRange.m3564equalsimpl0(textFieldValue.m3688getSelectiond9O1mEE(), textFieldValue2.m3688getSelectiond9O1mEE()) || Intrinsics.areEqual((Object) textFieldValue.m3687getCompositionMzsxiRA(), (Object) textFieldValue2.m3687getCompositionMzsxiRA()))) {
                    z = false;
                }
                z3 = z;
            }
            if (z3) {
                restartInput();
                return;
            }
            RecordingInputConnection recordingInputConnection2 = this.ic;
            if (recordingInputConnection2 != null) {
                recordingInputConnection2.updateInputState(this.state, this.inputMethodManager, this.view);
            }
        } else if (z2) {
            InputMethodManager inputMethodManager2 = this.inputMethodManager;
            View view2 = this.view;
            int r5 = TextRange.m3569getMinimpl(textFieldValue2.m3688getSelectiond9O1mEE());
            int r6 = TextRange.m3568getMaximpl(textFieldValue2.m3688getSelectiond9O1mEE());
            TextRange r10 = this.state.m3687getCompositionMzsxiRA();
            int r7 = r10 == null ? -1 : TextRange.m3569getMinimpl(r10.m3575unboximpl());
            TextRange r102 = this.state.m3687getCompositionMzsxiRA();
            inputMethodManager2.updateSelection(view2, r5, r6, r7, r102 == null ? -1 : TextRange.m3568getMaximpl(r102.m3575unboximpl()));
        }
    }

    public void notifyFocusedRect(androidx.compose.ui.geometry.Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Rect rect2 = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        this.focusedRect = rect2;
        if (this.ic == null && rect2 != null) {
            getView().requestRectangleOnScreen(new Rect(rect2));
        }
    }
}
