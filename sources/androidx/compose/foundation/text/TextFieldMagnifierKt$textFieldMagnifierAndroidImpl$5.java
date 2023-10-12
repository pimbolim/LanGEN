package androidx.compose.foundation.text;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldMagnifier.kt */
final class TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$5 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function1<Function0<Offset>, Modifier> $androidMagnifier;
    final /* synthetic */ Function0<Handle> $draggingHandle;
    final /* synthetic */ Function0<TextFieldValue> $fieldValue;
    final /* synthetic */ Function1<Integer, Rect> $getCursorRect;
    final /* synthetic */ boolean $isTextMagnifierSemanticsEnabled;
    final /* synthetic */ Function1<Integer, Integer> $transformTextOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$5(Function1<? super Function0<Offset>, ? extends Modifier> function1, boolean z, Function0<? extends Handle> function0, Function0<TextFieldValue> function02, Function1<? super Integer, Integer> function12, Function1<? super Integer, Rect> function13) {
        super(3);
        this.$androidMagnifier = function1;
        this.$isTextMagnifierSemanticsEnabled = z;
        this.$draggingHandle = function0;
        this.$fieldValue = function02;
        this.$transformTextOffset = function12;
        this.$getCursorRect = function13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(728603669);
        ComposerKt.sourceInformation(composer, "C126@5496L800:TextFieldMagnifier.kt#423gt5");
        final State access$rememberAnimatedDerivedStateOf = TextFieldMagnifierKt.rememberAnimatedDerivedStateOf(TextFieldMagnifierKt.UnspecifiedSafeOffsetVectorConverter, Offset.m1342boximpl(TextFieldMagnifierKt.OffsetDisplacementThreshold), (AnimationSpec) null, new TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$5$animatedMagnifierOffset$2(this.$draggingHandle, this.$fieldValue, this.$transformTextOffset, this.$getCursorRect), composer, 56, 4);
        Modifier then = modifier.then(this.$androidMagnifier.invoke(new Function0<Offset>() {
            public /* bridge */ /* synthetic */ Object invoke() {
                return Offset.m1342boximpl(m714invokeF1C5BW0());
            }

            /* renamed from: invoke-F1C5BW0  reason: not valid java name */
            public final long m714invokeF1C5BW0() {
                return TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$5.m713invoke$lambda0(access$rememberAnimatedDerivedStateOf);
            }
        }));
        if (this.$isTextMagnifierSemanticsEnabled) {
            modifier2 = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new Function1<SemanticsPropertyReceiver, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
                    semanticsPropertyReceiver.set(TextFieldMagnifierKt.getTextFieldMagnifierOffsetProperty(), Offset.m1342boximpl(TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$5.m713invoke$lambda0(access$rememberAnimatedDerivedStateOf)));
                }
            }, 1, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        Modifier then2 = then.then(modifier2);
        composer.endReplaceableGroup();
        return then2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final long m713invoke$lambda0(State<Offset> state) {
        return state.getValue().m1363unboximpl();
    }
}
