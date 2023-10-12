package androidx.compose.foundation.text;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aa\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0000\u0010\r\"\b\b\u0001\u0010\u000e*\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u0001H\r2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\r0\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\r0\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001a\u0001\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00152\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0\u001e2#\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0006\u0012\u0004\u0018\u00010$0\u001e2'\u0010%\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00180\u001e2\u0006\u0010'\u001a\u00020(H\u0000ø\u0001\u0000\u001aJ\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\u0006\u0010)\u001a\u00020*2'\u0010%\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00180\u001e2\b\b\u0002\u0010'\u001a\u00020(H\u0000ø\u0001\u0000\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\nX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"OffsetDisplacementThreshold", "Landroidx/compose/ui/geometry/Offset;", "J", "TextFieldMagnifierOffsetProperty", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "getTextFieldMagnifierOffsetProperty", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "UnspecifiedAnimationVector2D", "Landroidx/compose/animation/core/AnimationVector2D;", "UnspecifiedSafeOffsetVectorConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "rememberAnimatedDerivedStateOf", "Landroidx/compose/runtime/State;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "visibilityThreshold", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "targetCalculation", "Lkotlin/Function0;", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "textFieldMagnifierAndroidImpl", "Landroidx/compose/ui/Modifier;", "draggingHandle", "Landroidx/compose/foundation/text/Handle;", "fieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "transformTextOffset", "Lkotlin/Function1;", "", "getCursorRect", "Lkotlin/ParameterName;", "name", "offset", "Landroidx/compose/ui/geometry/Rect;", "androidMagnifier", "center", "isTextMagnifierSemanticsEnabled", "", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldMagnifier.kt */
public final class TextFieldMagnifierKt {
    /* access modifiers changed from: private */
    public static final long OffsetDisplacementThreshold = OffsetKt.Offset(0.01f, 0.01f);
    private static final SemanticsPropertyKey<Offset> TextFieldMagnifierOffsetProperty = new SemanticsPropertyKey<>("TextFieldMagnifier", (Function2) null, 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AnimationVector2D UnspecifiedAnimationVector2D = new AnimationVector2D(Float.NaN, Float.NaN);
    /* access modifiers changed from: private */
    public static final TwoWayConverter<Offset, AnimationVector2D> UnspecifiedSafeOffsetVectorConverter = VectorConvertersKt.TwoWayConverter(TextFieldMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1.INSTANCE, TextFieldMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2.INSTANCE);

    public static final SemanticsPropertyKey<Offset> getTextFieldMagnifierOffsetProperty() {
        return TextFieldMagnifierOffsetProperty;
    }

    public static /* synthetic */ Modifier textFieldMagnifierAndroidImpl$default(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return textFieldMagnifierAndroidImpl(modifier, textFieldSelectionManager, function1, z);
    }

    public static final Modifier textFieldMagnifierAndroidImpl(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function1<? super Function0<Offset>, ? extends Modifier> function1, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        Intrinsics.checkNotNullParameter(function1, "androidMagnifier");
        TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release == null) {
            return Modifier.Companion;
        }
        return textFieldMagnifierAndroidImpl(modifier, new TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$1(state$foundation_release), new TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$2(textFieldSelectionManager), new TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$3(textFieldSelectionManager), new TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$4(state$foundation_release), function1, z);
    }

    public static final Modifier textFieldMagnifierAndroidImpl(Modifier modifier, Function0<? extends Handle> function0, Function0<TextFieldValue> function02, Function1<? super Integer, Integer> function1, Function1<? super Integer, Rect> function12, Function1<? super Function0<Offset>, ? extends Modifier> function13, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function0, "draggingHandle");
        Intrinsics.checkNotNullParameter(function02, "fieldValue");
        Intrinsics.checkNotNullParameter(function1, "transformTextOffset");
        Intrinsics.checkNotNullParameter(function12, "getCursorRect");
        Intrinsics.checkNotNullParameter(function13, "androidMagnifier");
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new TextFieldMagnifierKt$textFieldMagnifierAndroidImpl$5(function13, z, function0, function02, function1, function12), 1, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [kotlin.jvm.functions.Function0<? extends T>, kotlin.jvm.functions.Function0] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> androidx.compose.runtime.State<T> rememberAnimatedDerivedStateOf(androidx.compose.animation.core.TwoWayConverter<T, V> r7, T r8, androidx.compose.animation.core.AnimationSpec<T> r9, kotlin.jvm.functions.Function0<? extends T> r10, androidx.compose.runtime.Composer r11, int r12, int r13) {
        /*
            r12 = 1513221697(0x5a31ee41, float:1.25207585E16)
            r11.startReplaceableGroup(r12)
            java.lang.String r12 = "C(rememberAnimatedDerivedStateOf)P(2,3)170@7344L46,171@7412L84,174@7501L164:TextFieldMagnifier.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r12)
            r12 = r13 & 2
            r0 = 0
            if (r12 == 0) goto L_0x0011
            r8 = r0
        L_0x0011:
            r12 = r13 & 4
            if (r12 == 0) goto L_0x0022
            androidx.compose.animation.core.SpringSpec r9 = new androidx.compose.animation.core.SpringSpec
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r1 = r9
            r4 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            androidx.compose.animation.core.AnimationSpec r9 = (androidx.compose.animation.core.AnimationSpec) r9
        L_0x0022:
            r12 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r12)
            java.lang.String r13 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r13)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x0040
            androidx.compose.runtime.State r1 = androidx.compose.runtime.SnapshotStateKt.derivedStateOf(r10)
            r11.updateRememberedValue(r1)
        L_0x0040:
            r11.endReplaceableGroup()
            androidx.compose.runtime.State r1 = (androidx.compose.runtime.State) r1
            r11.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r13)
            java.lang.Object r10 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r10 != r12) goto L_0x0063
            androidx.compose.animation.core.Animatable r10 = new androidx.compose.animation.core.Animatable
            java.lang.Object r12 = m709rememberAnimatedDerivedStateOf$lambda1(r1)
            r10.<init>(r12, r7, r8)
            r11.updateRememberedValue(r10)
        L_0x0063:
            r11.endReplaceableGroup()
            androidx.compose.animation.core.Animatable r10 = (androidx.compose.animation.core.Animatable) r10
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            androidx.compose.foundation.text.TextFieldMagnifierKt$rememberAnimatedDerivedStateOf$1 r8 = new androidx.compose.foundation.text.TextFieldMagnifierKt$rememberAnimatedDerivedStateOf$1
            r8.<init>(r1, r10, r9, r0)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 0
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r7, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r8, (androidx.compose.runtime.Composer) r11, (int) r9)
            androidx.compose.runtime.State r7 = r10.asState()
            r11.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldMagnifierKt.rememberAnimatedDerivedStateOf(androidx.compose.animation.core.TwoWayConverter, java.lang.Object, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.runtime.State");
    }

    /* access modifiers changed from: private */
    /* renamed from: rememberAnimatedDerivedStateOf$lambda-1  reason: not valid java name */
    public static final <T> T m709rememberAnimatedDerivedStateOf$lambda1(State<? extends T> state) {
        return state.getValue();
    }
}
