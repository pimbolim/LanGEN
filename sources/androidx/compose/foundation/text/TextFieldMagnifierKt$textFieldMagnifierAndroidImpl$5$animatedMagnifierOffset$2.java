package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldMagnifier.kt */
final class TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$5$animatedMagnifierOffset$2 extends Lambda implements Function0<Offset> {
    final /* synthetic */ Function0<Handle> $draggingHandle;
    final /* synthetic */ Function0<TextFieldValue> $fieldValue;
    final /* synthetic */ Function1<Integer, Rect> $getCursorRect;
    final /* synthetic */ Function1<Integer, Integer> $transformTextOffset;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextFieldMagnifier.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            iArr[Handle.Cursor.ordinal()] = 1;
            iArr[Handle.SelectionStart.ordinal()] = 2;
            iArr[Handle.SelectionEnd.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$5$animatedMagnifierOffset$2(Function0<? extends Handle> function0, Function0<TextFieldValue> function02, Function1<? super Integer, Integer> function1, Function1<? super Integer, Rect> function12) {
        super(0);
        this.$draggingHandle = function0;
        this.$fieldValue = function02;
        this.$transformTextOffset = function1;
        this.$getCursorRect = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Offset.m1342boximpl(m715invokeF1C5BW0());
    }

    /* renamed from: invoke-F1C5BW0  reason: not valid java name */
    public final long m715invokeF1C5BW0() {
        int i;
        Handle invoke = this.$draggingHandle.invoke();
        int i2 = invoke == null ? -1 : WhenMappings.$EnumSwitchMapping$0[invoke.ordinal()];
        if (i2 == -1) {
            return Offset.Companion.m1368getUnspecifiedF1C5BW0();
        }
        if (i2 == 1 || i2 == 2) {
            i = TextRange.m3571getStartimpl(this.$fieldValue.invoke().m3688getSelectiond9O1mEE());
        } else if (i2 == 3) {
            i = TextRange.m3566getEndimpl(this.$fieldValue.invoke().m3688getSelectiond9O1mEE());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Rect invoke2 = this.$getCursorRect.invoke(Integer.valueOf(this.$transformTextOffset.invoke(Integer.valueOf(i)).intValue()));
        Offset r0 = invoke2 == null ? null : Offset.m1342boximpl(invoke2.m1383getCenterF1C5BW0());
        return r0 == null ? Offset.Companion.m1368getUnspecifiedF1C5BW0() : r0.m1363unboximpl();
    }
}
