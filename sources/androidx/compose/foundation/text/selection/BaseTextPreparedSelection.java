package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b(\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B2\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0002J$\u0010(\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,¢\u0006\u0002\u0010-J$\u0010.\u001a\u00028\u00002\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,¢\u0006\u0002\u0010-J\u000b\u0010/\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u00101\u001a\u00028\u0000¢\u0006\u0002\u00100J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0002J\b\u00104\u001a\u000205H\u0002J\u000b\u00106\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u00107\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u00108\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u00109\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010;\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010<\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010=\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010>\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010?\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010@\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010A\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010B\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010C\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010E\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010G\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010H\u001a\u00028\u0000¢\u0006\u0002\u00100J\u000b\u0010I\u001a\u00028\u0000¢\u0006\u0002\u00100J\u0010\u0010J\u001a\u00020+2\u0006\u0010'\u001a\u00020&H\u0004J\u0018\u0010K\u001a\u00020+2\u0006\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020&H\u0004J\b\u0010N\u001a\u00020&H\u0002J\b\u0010O\u001a\u00020&H\u0002J\b\u0010P\u001a\u00020&H\u0002J>\u0010Q\u001a\u00028\u0000\"\u0004\b\u0001\u0010R*\u0002HR2\b\b\u0002\u0010S\u001a\u0002052\u0017\u0010T\u001a\u0013\u0012\u0004\u0012\u0002HR\u0012\u0004\u0012\u00020+0*¢\u0006\u0002\b,H\bø\u0001\u0003¢\u0006\u0002\u0010UJ\u0016\u0010V\u001a\u00020&*\u00020\b2\b\b\u0002\u0010W\u001a\u00020&H\u0002J\u0016\u0010X\u001a\u00020&*\u00020\b2\b\b\u0002\u0010W\u001a\u00020&H\u0002J\u0016\u0010Y\u001a\u00020&*\u00020\b2\b\b\u0002\u0010W\u001a\u00020&H\u0002J\u0016\u0010Z\u001a\u00020&*\u00020\b2\b\b\u0002\u0010W\u001a\u00020&H\u0002J\u0014\u0010[\u001a\u00020&*\u00020\b2\u0006\u0010\\\u001a\u00020&H\u0002R\u001a\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R%\u0010\u001b\u001a\u00020\u0006X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8@X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b20\u0001¨\u0006]"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "T", "", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "annotatedString", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getOriginalSelection-d9O1mEE", "()J", "J", "getOriginalText", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "text", "", "getText$foundation_release", "()Ljava/lang/String;", "charOffset", "", "offset", "collapseLeftOr", "or", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "deleteSelected", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "deselect", "getParagraphEnd", "getParagraphStart", "isLtr", "", "moveCursorDownByLine", "moveCursorLeft", "moveCursorLeftByWord", "moveCursorNext", "moveCursorNextByParagraph", "moveCursorNextByWord", "moveCursorPrev", "moveCursorPrevByParagraph", "moveCursorPrevByWord", "moveCursorRight", "moveCursorRightByWord", "moveCursorToEnd", "moveCursorToHome", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "moveCursorToLineStart", "moveCursorUpByLine", "selectAll", "selectMovement", "setCursor", "setSelection", "start", "end", "transformedEndOffset", "transformedMaxOffset", "transformedMinOffset", "apply", "U", "resetCachedX", "block", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "getLineEndByOffset", "currentOffset", "getLineStartByOffset", "getNextWordOffset", "getPrevWordOffset", "jumpByLinesOffset", "linesAmount", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextPreparedSelection.kt */
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    private AnnotatedString annotatedString;
    private final TextLayoutResult layoutResult;
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    private final AnnotatedString originalText;
    private long selection;
    private final TextPreparedSelectionState state;

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString annotatedString2, long j, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping2, TextPreparedSelectionState textPreparedSelectionState, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString2, j, textLayoutResult, offsetMapping2, textPreparedSelectionState);
    }

    private BaseTextPreparedSelection(AnnotatedString annotatedString2, long j, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping2, TextPreparedSelectionState textPreparedSelectionState) {
        this.originalText = annotatedString2;
        this.originalSelection = j;
        this.layoutResult = textLayoutResult;
        this.offsetMapping = offsetMapping2;
        this.state = textPreparedSelectionState;
        this.selection = m741getOriginalSelectiond9O1mEE();
        this.annotatedString = annotatedString2;
    }

    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    /* renamed from: getOriginalSelection-d9O1mEE  reason: not valid java name */
    public final long m741getOriginalSelectiond9O1mEE() {
        return this.originalSelection;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    /* renamed from: getSelection-d9O1mEE  reason: not valid java name */
    public final long m742getSelectiond9O1mEE() {
        return this.selection;
    }

    /* renamed from: setSelection-5zc-tL8  reason: not valid java name */
    public final void m743setSelection5zctL8(long j) {
        this.selection = j;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final void setAnnotatedString(AnnotatedString annotatedString2) {
        Intrinsics.checkNotNullParameter(annotatedString2, "<set-?>");
        this.annotatedString = annotatedString2;
    }

    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    public static /* synthetic */ BaseTextPreparedSelection apply$default(BaseTextPreparedSelection baseTextPreparedSelection, Object obj, boolean z, Function1 function1, int i, Object obj2) {
        if (obj2 == null) {
            boolean z2 = true;
            if ((i & 1) != 0) {
                z = true;
            }
            Intrinsics.checkNotNullParameter(function1, "block");
            if (z) {
                baseTextPreparedSelection.getState().resetCachedX();
            }
            if (baseTextPreparedSelection.getText$foundation_release().length() <= 0) {
                z2 = false;
            }
            if (z2) {
                function1.invoke(obj);
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
            return (BaseTextPreparedSelection) obj;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
    }

    /* access modifiers changed from: protected */
    public final <U> T apply(U u, boolean z, Function1<? super U, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (z) {
            getState().resetCachedX();
        }
        if (getText$foundation_release().length() > 0) {
            function1.invoke(u);
        }
        Objects.requireNonNull(u, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection) u;
    }

    /* access modifiers changed from: protected */
    public final void setCursor(int i) {
        setSelection(i, i);
    }

    /* access modifiers changed from: protected */
    public final void setSelection(int i, int i2) {
        m743setSelection5zctL8(TextRangeKt.TextRange(i, i2));
    }

    private final boolean isLtr() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        return (textLayoutResult == null ? null : textLayoutResult.getParagraphDirection(TextRange.m3566getEndimpl(m742getSelectiond9O1mEE()))) != ResolvedTextDirection.Rtl;
    }

    static /* synthetic */ int getNextWordOffset$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedEndOffset();
            }
            return baseTextPreparedSelection.getNextWordOffset(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffset");
    }

    private final int getNextWordOffset(TextLayoutResult textLayoutResult, int i) {
        if (i >= this.originalText.length()) {
            return this.originalText.length();
        }
        long r0 = textLayoutResult.m3556getWordBoundaryjx7JFs(charOffset(i));
        if (TextRange.m3566getEndimpl(r0) <= i) {
            return getNextWordOffset(textLayoutResult, i + 1);
        }
        return this.offsetMapping.transformedToOriginal(TextRange.m3566getEndimpl(r0));
    }

    static /* synthetic */ int getPrevWordOffset$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedEndOffset();
            }
            return baseTextPreparedSelection.getPrevWordOffset(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
    }

    private final int getPrevWordOffset(TextLayoutResult textLayoutResult, int i) {
        if (i < 0) {
            return 0;
        }
        long r0 = textLayoutResult.m3556getWordBoundaryjx7JFs(charOffset(i));
        if (TextRange.m3571getStartimpl(r0) >= i) {
            return getPrevWordOffset(textLayoutResult, i - 1);
        }
        return this.offsetMapping.transformedToOriginal(TextRange.m3571getStartimpl(r0));
    }

    static /* synthetic */ int getLineStartByOffset$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedMinOffset();
            }
            return baseTextPreparedSelection.getLineStartByOffset(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffset");
    }

    private final int getLineStartByOffset(TextLayoutResult textLayoutResult, int i) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(i)));
    }

    static /* synthetic */ int getLineEndByOffset$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = baseTextPreparedSelection.transformedMaxOffset();
            }
            return baseTextPreparedSelection.getLineEndByOffset(textLayoutResult, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffset");
    }

    private final int getLineEndByOffset(TextLayoutResult textLayoutResult, int i) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(i), true));
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i) {
        int transformedEndOffset = transformedEndOffset();
        if (this.state.getCachedX() == null) {
            this.state.setCachedX(Float.valueOf(textLayoutResult.getCursorRect(transformedEndOffset).getLeft()));
        }
        int lineForOffset = textLayoutResult.getLineForOffset(transformedEndOffset) + i;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return getText$foundation_release().length();
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - ((float) 1);
        Float cachedX = this.state.getCachedX();
        Intrinsics.checkNotNull(cachedX);
        Number number = cachedX;
        float floatValue = number.floatValue();
        if ((isLtr() && floatValue >= textLayoutResult.getLineRight(lineForOffset)) || (!isLtr() && floatValue <= textLayoutResult.getLineLeft(lineForOffset))) {
            return textLayoutResult.getLineEnd(lineForOffset, true);
        }
        return getOffsetMapping().transformedToOriginal(textLayoutResult.m3554getOffsetForPositionk4lQ0M(OffsetKt.Offset(number.floatValue(), lineBottom)));
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m3566getEndimpl(m742getSelectiond9O1mEE()));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m3569getMinimpl(m742getSelectiond9O1mEE()));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m3568getMaximpl(m742getSelectiond9O1mEE()));
    }

    private final int charOffset(int i) {
        return RangesKt.coerceAtMost(i, getText$foundation_release().length() - 1);
    }

    private final int getParagraphStart() {
        return StringHelpersKt.findParagraphStart(getText$foundation_release(), TextRange.m3569getMinimpl(m742getSelectiond9O1mEE()));
    }

    private final int getParagraphEnd() {
        return StringHelpersKt.findParagraphEnd(getText$foundation_release(), TextRange.m3568getMaximpl(m742getSelectiond9O1mEE()));
    }

    public final T selectAll() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            baseTextPreparedSelection.setSelection(0, baseTextPreparedSelection.getText$foundation_release().length());
        }
        return this;
    }

    public final T deselect() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            baseTextPreparedSelection.setCursor(TextRange.m3566getEndimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()));
        }
        return this;
    }

    public final T moveCursorLeft() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (baseTextPreparedSelection.isLtr()) {
                baseTextPreparedSelection.moveCursorPrev();
            } else {
                baseTextPreparedSelection.moveCursorNext();
            }
        }
        return this;
    }

    public final T moveCursorRight() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (baseTextPreparedSelection.isLtr()) {
                baseTextPreparedSelection.moveCursorNext();
            } else {
                baseTextPreparedSelection.moveCursorPrev();
            }
        }
        return this;
    }

    public final T collapseLeftOr(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "or");
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (TextRange.m3565getCollapsedimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE())) {
                function1.invoke(baseTextPreparedSelection);
            } else if (baseTextPreparedSelection.isLtr()) {
                baseTextPreparedSelection.setCursor(TextRange.m3569getMinimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()));
            } else {
                baseTextPreparedSelection.setCursor(TextRange.m3568getMaximpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()));
            }
        }
        return this;
    }

    public final T collapseRightOr(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "or");
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (TextRange.m3565getCollapsedimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE())) {
                function1.invoke(baseTextPreparedSelection);
            } else if (baseTextPreparedSelection.isLtr()) {
                baseTextPreparedSelection.setCursor(TextRange.m3568getMaximpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()));
            } else {
                baseTextPreparedSelection.setCursor(TextRange.m3569getMinimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()));
            }
        }
        return this;
    }

    public final T moveCursorPrev() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            int findPrecedingBreak = StringHelpers_androidKt.findPrecedingBreak(baseTextPreparedSelection.getAnnotatedString().getText(), TextRange.m3566getEndimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()));
            if (findPrecedingBreak != -1) {
                baseTextPreparedSelection.setCursor(findPrecedingBreak);
            }
        }
        return this;
    }

    public final T moveCursorNext() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            int findFollowingBreak = StringHelpers_androidKt.findFollowingBreak(baseTextPreparedSelection.getAnnotatedString().getText(), TextRange.m3566getEndimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()));
            if (findFollowingBreak != -1) {
                baseTextPreparedSelection.setCursor(findFollowingBreak);
            }
        }
        return this;
    }

    public final T moveCursorToHome() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            setCursor(0);
        }
        return this;
    }

    public final T moveCursorToEnd() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            baseTextPreparedSelection.setCursor(baseTextPreparedSelection.getText$foundation_release().length());
        }
        return this;
    }

    public final T moveCursorLeftByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (baseTextPreparedSelection.isLtr()) {
                baseTextPreparedSelection.moveCursorPrevByWord();
            } else {
                baseTextPreparedSelection.moveCursorNextByWord();
            }
        }
        return this;
    }

    public final T moveCursorRightByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (baseTextPreparedSelection.isLtr()) {
                baseTextPreparedSelection.moveCursorNextByWord();
            } else {
                baseTextPreparedSelection.moveCursorPrevByWord();
            }
        }
        return this;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001b: MOVE  (r0v8 androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r5v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final T moveCursorNextByWord() {
        /*
            r5 = this;
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r0 = r5.getState()
            r0.resetCachedX()
            java.lang.String r0 = r5.getText$foundation_release()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x002c
            r0 = r5
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            androidx.compose.ui.text.TextLayoutResult r3 = r0.getLayoutResult()
            if (r3 != 0) goto L_0x0024
            goto L_0x002c
        L_0x0024:
            r4 = 0
            int r1 = getNextWordOffset$default(r0, r3, r2, r1, r4)
            r0.setCursor(r1)
        L_0x002c:
            r0 = r5
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorNextByWord():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001b: MOVE  (r0v8 androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r5v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final T moveCursorPrevByWord() {
        /*
            r5 = this;
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r0 = r5.getState()
            r0.resetCachedX()
            java.lang.String r0 = r5.getText$foundation_release()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x002c
            r0 = r5
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            androidx.compose.ui.text.TextLayoutResult r3 = r0.getLayoutResult()
            if (r3 != 0) goto L_0x0024
            goto L_0x002c
        L_0x0024:
            r4 = 0
            int r1 = getPrevWordOffset$default(r0, r3, r2, r1, r4)
            r0.setCursor(r1)
        L_0x002c:
            r0 = r5
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorPrevByWord():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    public final T moveCursorPrevByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            baseTextPreparedSelection.setCursor(baseTextPreparedSelection.getParagraphStart());
        }
        return this;
    }

    public final T moveCursorNextByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            baseTextPreparedSelection.setCursor(baseTextPreparedSelection.getParagraphEnd());
        }
        return this;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0012: MOVE  (r0v7 androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r3v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final T moveCursorUpByLine() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getText$foundation_release()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            if (r0 == 0) goto L_0x0023
            r0 = r3
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            androidx.compose.ui.text.TextLayoutResult r1 = r0.getLayoutResult()
            if (r1 != 0) goto L_0x001b
            goto L_0x0023
        L_0x001b:
            r2 = -1
            int r1 = r0.jumpByLinesOffset(r1, r2)
            r0.setCursor(r1)
        L_0x0023:
            r0 = r3
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorUpByLine():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0013: MOVE  (r0v7 androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r3v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final T moveCursorDownByLine() {
        /*
            r3 = this;
            java.lang.String r0 = r3.getText$foundation_release()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            if (r0 <= 0) goto L_0x000f
            r0 = 1
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 == 0) goto L_0x0023
            r0 = r3
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            androidx.compose.ui.text.TextLayoutResult r2 = r0.getLayoutResult()
            if (r2 != 0) goto L_0x001c
            goto L_0x0023
        L_0x001c:
            int r1 = r0.jumpByLinesOffset(r2, r1)
            r0.setCursor(r1)
        L_0x0023:
            r0 = r3
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorDownByLine():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001b: MOVE  (r0v8 androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r5v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final T moveCursorToLineStart() {
        /*
            r5 = this;
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r0 = r5.getState()
            r0.resetCachedX()
            java.lang.String r0 = r5.getText$foundation_release()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x002c
            r0 = r5
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            androidx.compose.ui.text.TextLayoutResult r3 = r0.getLayoutResult()
            if (r3 != 0) goto L_0x0024
            goto L_0x002c
        L_0x0024:
            r4 = 0
            int r1 = getLineStartByOffset$default(r0, r3, r2, r1, r4)
            r0.setCursor(r1)
        L_0x002c:
            r0 = r5
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorToLineStart():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001b: MOVE  (r0v8 androidx.compose.foundation.text.selection.BaseTextPreparedSelection) = 
          (r5v0 'this' androidx.compose.foundation.text.selection.BaseTextPreparedSelection A[THIS])
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final T moveCursorToLineEnd() {
        /*
            r5 = this;
            androidx.compose.foundation.text.selection.TextPreparedSelectionState r0 = r5.getState()
            r0.resetCachedX()
            java.lang.String r0 = r5.getText$foundation_release()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x002c
            r0 = r5
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            androidx.compose.ui.text.TextLayoutResult r3 = r0.getLayoutResult()
            if (r3 != 0) goto L_0x0024
            goto L_0x002c
        L_0x0024:
            r4 = 0
            int r1 = getLineEndByOffset$default(r0, r3, r2, r1, r4)
            r0.setCursor(r1)
        L_0x002c:
            r0 = r5
            androidx.compose.foundation.text.selection.BaseTextPreparedSelection r0 = (androidx.compose.foundation.text.selection.BaseTextPreparedSelection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.BaseTextPreparedSelection.moveCursorToLineEnd():androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
    }

    public final T moveCursorToLineLeftSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (baseTextPreparedSelection.isLtr()) {
                baseTextPreparedSelection.moveCursorToLineStart();
            } else {
                baseTextPreparedSelection.moveCursorToLineEnd();
            }
        }
        return this;
    }

    public final T moveCursorToLineRightSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            if (baseTextPreparedSelection.isLtr()) {
                baseTextPreparedSelection.moveCursorToLineEnd();
            } else {
                baseTextPreparedSelection.moveCursorToLineStart();
            }
        }
        return this;
    }

    public final T selectMovement() {
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            baseTextPreparedSelection.m743setSelection5zctL8(TextRangeKt.TextRange(TextRange.m3571getStartimpl(baseTextPreparedSelection.m741getOriginalSelectiond9O1mEE()), TextRange.m3566getEndimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE())));
        }
        return this;
    }

    public final T deleteSelected() {
        getState().resetCachedX();
        if (getText$foundation_release().length() > 0) {
            BaseTextPreparedSelection baseTextPreparedSelection = this;
            int length = baseTextPreparedSelection.getText$foundation_release().length();
            baseTextPreparedSelection.setAnnotatedString(baseTextPreparedSelection.getAnnotatedString().subSequence(Math.max(0, TextRange.m3569getMinimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()) - length), TextRange.m3569getMinimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE())).plus(baseTextPreparedSelection.getAnnotatedString().subSequence(TextRange.m3568getMaximpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()), Math.min(TextRange.m3568getMaximpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()) + length, baseTextPreparedSelection.getText$foundation_release().length()))));
            baseTextPreparedSelection.setCursor(TextRange.m3569getMinimpl(baseTextPreparedSelection.m742getSelectiond9O1mEE()));
        }
        return this;
    }
}
