package androidx.compose.foundation.text;

import androidx.compose.foundation.text.TextFieldDelegate;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$4$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Modifier $cursorModifier;
    final /* synthetic */ Modifier $drawModifier;
    final /* synthetic */ Modifier $magnifierModifier;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ Modifier $onPositionedModifier;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
    final /* synthetic */ boolean $showHandleAndMagnifier;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$4$1(int i, TextStyle textStyle, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, Function1<? super TextLayoutResult, Unit> function1) {
        super(2);
        this.$maxLines = i;
        this.$textStyle = textStyle;
        this.$scrollerPosition = textFieldScrollerPosition;
        this.$value = textFieldValue;
        this.$visualTransformation = visualTransformation;
        this.$cursorModifier = modifier;
        this.$drawModifier = modifier2;
        this.$onPositionedModifier = modifier3;
        this.$magnifierModifier = modifier4;
        this.$state = textFieldState;
        this.$manager = textFieldSelectionManager;
        this.$showHandleAndMagnifier = z;
        this.$readOnly = z2;
        this.$onTextLayout = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C526@22588L2444:CoreTextField.kt#423gt5");
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier then = TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(MaxLinesHeightModifierKt.maxLinesHeight(Modifier.Companion, this.$maxLines, this.$textStyle), this.$scrollerPosition, this.$value, this.$visualTransformation, new CoreTextFieldKt$CoreTextField$4$1$coreTextFieldModifier$1(this.$state)).then(this.$cursorModifier).then(this.$drawModifier), this.$textStyle).then(this.$onPositionedModifier).then(this.$magnifierModifier);
            final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
            final TextFieldState textFieldState = this.$state;
            final boolean z = this.$showHandleAndMagnifier;
            final boolean z2 = this.$readOnly;
            final Function1<TextLayoutResult, Unit> function1 = this.$onTextLayout;
            SimpleLayoutKt.SimpleLayout(then, ComposableLambdaKt.composableLambda(composer, -819904786, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    ComposerKt.sourceInformation(composer, "C527@22642L1772,564@24432L327,576@24960L40:CoreTextField.kt#423gt5");
                    if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        final TextFieldState textFieldState = textFieldState;
                        final Function1<TextLayoutResult, Unit> function1 = function1;
                        MeasurePolicy r8 = new MeasurePolicy() {
                            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
                                return MeasurePolicy.DefaultImpls.maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                            }

                            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
                                return MeasurePolicy.DefaultImpls.minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                            }

                            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
                                return MeasurePolicy.DefaultImpls.minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                            }

                            /* renamed from: measure-3p2s80s  reason: not valid java name */
                            public MeasureResult m635measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                Intrinsics.checkNotNullParameter(measureScope, "$receiver");
                                Intrinsics.checkNotNullParameter(list, "measurables");
                                TextFieldDelegate.Companion companion = TextFieldDelegate.Companion;
                                TextDelegate textDelegate = textFieldState.getTextDelegate();
                                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                                TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                                TextLayoutResult textLayoutResult = null;
                                Triple<Integer, Integer, TextLayoutResult> r9 = companion.m702layout_EkL_Y$foundation_release(textDelegate, j, layoutDirection, layoutResult == null ? null : layoutResult.getValue());
                                int intValue = r9.component1().intValue();
                                int intValue2 = r9.component2().intValue();
                                TextLayoutResult component3 = r9.component3();
                                TextLayoutResultProxy layoutResult2 = textFieldState.getLayoutResult();
                                if (layoutResult2 != null) {
                                    textLayoutResult = layoutResult2.getValue();
                                }
                                if (!Intrinsics.areEqual((Object) textLayoutResult, (Object) component3)) {
                                    textFieldState.setLayoutResult(new TextLayoutResultProxy(component3));
                                    function1.invoke(component3);
                                }
                                return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(component3.getLastBaseline())))), CoreTextFieldKt$CoreTextField$4$1$1$2$measure$1.INSTANCE);
                            }

                            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
                                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                                Intrinsics.checkNotNullParameter(list, "measurables");
                                textFieldState.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                return textFieldState.getTextDelegate().getMaxIntrinsicWidth();
                            }
                        };
                        composer.startReplaceableGroup(1376089394);
                        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
                        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        Density density = (Density) consume;
                        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        LayoutDirection layoutDirection = (LayoutDirection) consume2;
                        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
                        Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer.createNode(constructor);
                        } else {
                            composer.useNode();
                        }
                        composer.disableReusing();
                        Composer r3 = Updater.m1234constructorimpl(composer);
                        Updater.m1241setimpl(r3, r8, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m1241setimpl(r3, density, ComposeUiNode.Companion.getSetDensity());
                        Updater.m1241setimpl(r3, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
                        Updater.m1241setimpl(r3, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
                        composer.enableReusing();
                        boolean z = false;
                        materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer)), composer, 0);
                        composer.startReplaceableGroup(2058660585);
                        composer.startReplaceableGroup(1017239479);
                        ComposerKt.sourceInformation(composer, "C:CoreTextField.kt#423gt5");
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        TextFieldSelectionManager textFieldSelectionManager = textFieldSelectionManager;
                        if (textFieldState.getHandleState() == HandleState.Selection && textFieldState.getLayoutCoordinates() != null) {
                            LayoutCoordinates layoutCoordinates = textFieldState.getLayoutCoordinates();
                            Intrinsics.checkNotNull(layoutCoordinates);
                            if (layoutCoordinates.isAttached() && z) {
                                z = true;
                            }
                        }
                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager, z, composer, 8);
                        if (textFieldState.getHandleState() == HandleState.Cursor && !z2 && z) {
                            CoreTextFieldKt.TextFieldCursorHandle(textFieldSelectionManager, composer, 8);
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 48, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
