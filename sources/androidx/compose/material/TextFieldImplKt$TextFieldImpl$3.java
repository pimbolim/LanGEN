package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$TextFieldImpl$3 extends Lambda implements Function7<Float, Color, Color, Dp, Float, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ KeyboardActions $keyboardActions;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leading;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ TextStyle $mergedTextStyle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $shouldOverrideTextStyleColor;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailing;
    final /* synthetic */ AnnotatedString $transformedText;
    final /* synthetic */ TextFieldType $type;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFieldType.values().length];
            iArr[TextFieldType.Filled.ordinal()] = 1;
            iArr[TextFieldType.Outlined.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$TextFieldImpl$3(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, AnnotatedString annotatedString, Modifier modifier, boolean z, int i, TextFieldColors textFieldColors, boolean z2, MutableInteractionSource mutableInteractionSource, int i2, TextFieldType textFieldType, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, boolean z3, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, TextStyle textStyle, boolean z4, int i3, VisualTransformation visualTransformation, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, boolean z5) {
        super(7);
        this.$label = function2;
        this.$placeholder = function22;
        this.$transformedText = annotatedString;
        this.$modifier = modifier;
        this.$isError = z;
        this.$$dirty1 = i;
        this.$colors = textFieldColors;
        this.$enabled = z2;
        this.$interactionSource = mutableInteractionSource;
        this.$$dirty = i2;
        this.$type = textFieldType;
        this.$value = textFieldValue;
        this.$onValueChange = function1;
        this.$readOnly = z3;
        this.$keyboardOptions = keyboardOptions;
        this.$keyboardActions = keyboardActions;
        this.$mergedTextStyle = textStyle;
        this.$singleLine = z4;
        this.$maxLines = i3;
        this.$visualTransformation = visualTransformation;
        this.$leading = function23;
        this.$trailing = function24;
        this.$shape = shape;
        this.$shouldOverrideTextStyleColor = z5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        m1168invokeh1eTWw(((Number) obj).floatValue(), ((Color) obj2).m1606unboximpl(), ((Color) obj3).m1606unboximpl(), ((Dp) obj4).m3873unboximpl(), ((Number) obj5).floatValue(), (Composer) obj6, ((Number) obj7).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x036a  */
    /* renamed from: invoke-h1eT-Ww  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1168invokeh1eTWw(float r49, long r50, long r52, float r54, float r55, androidx.compose.runtime.Composer r56, int r57) {
        /*
            r48 = this;
            r0 = r48
            r14 = r56
            r1 = r57
            java.lang.String r2 = "CP(2,3:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.unit.Dp)160@6600L30,161@6682L43:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
            r2 = r1 & 14
            r7 = 2
            r13 = r49
            if (r2 != 0) goto L_0x001d
            boolean r2 = r14.changed((float) r13)
            if (r2 == 0) goto L_0x001a
            r2 = 4
            goto L_0x001b
        L_0x001a:
            r2 = 2
        L_0x001b:
            r2 = r2 | r1
            goto L_0x001e
        L_0x001d:
            r2 = r1
        L_0x001e:
            r3 = r1 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0031
            r3 = r50
            boolean r5 = r14.changed((long) r3)
            if (r5 == 0) goto L_0x002d
            r5 = 32
            goto L_0x002f
        L_0x002d:
            r5 = 16
        L_0x002f:
            r2 = r2 | r5
            goto L_0x0033
        L_0x0031:
            r3 = r50
        L_0x0033:
            r5 = r1 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0046
            r5 = r52
            boolean r8 = r14.changed((long) r5)
            if (r8 == 0) goto L_0x0042
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0044
        L_0x0042:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0044:
            r2 = r2 | r8
            goto L_0x0048
        L_0x0046:
            r5 = r52
        L_0x0048:
            r8 = r1 & 7168(0x1c00, float:1.0045E-41)
            r12 = r54
            if (r8 != 0) goto L_0x005a
            boolean r8 = r14.changed((float) r12)
            if (r8 == 0) goto L_0x0057
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0059
        L_0x0057:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0059:
            r2 = r2 | r8
        L_0x005a:
            r36 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r36
            if (r1 != 0) goto L_0x0070
            r1 = r55
            boolean r8 = r14.changed((float) r1)
            if (r8 == 0) goto L_0x006c
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006e
        L_0x006c:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x006e:
            r2 = r2 | r8
            goto L_0x0072
        L_0x0070:
            r1 = r55
        L_0x0072:
            r38 = r2
            r2 = 374491(0x5b6db, float:5.24774E-40)
            r2 = r38 & r2
            r8 = 74898(0x12492, float:1.04954E-40)
            r2 = r2 ^ r8
            if (r2 != 0) goto L_0x008b
            boolean r2 = r56.getSkipping()
            if (r2 != 0) goto L_0x0086
            goto L_0x008b
        L_0x0086:
            r56.skipToGroupEnd()
            goto L_0x0487
        L_0x008b:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.$label
            r8 = 0
            r9 = 1
            if (r2 != 0) goto L_0x0094
            r41 = r8
            goto L_0x00b6
        L_0x0094:
            boolean r10 = r0.$shouldOverrideTextStyleColor
            r11 = -985537120(0xffffffffc541e5a0, float:-3102.3516)
            androidx.compose.material.TextFieldImplKt$TextFieldImpl$3$decoratedLabel$1$1 r15 = new androidx.compose.material.TextFieldImplKt$TextFieldImpl$3$decoratedLabel$1$1
            r57 = r15
            r16 = r49
            r17 = r52
            r19 = r2
            r20 = r38
            r21 = r10
            r22 = r50
            r15.<init>(r16, r17, r19, r20, r21, r22)
            r2 = r57
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r11, r9, r2)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r41 = r2
        L_0x00b6:
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r2 = r0.$placeholder
            r3 = 0
            if (r2 == 0) goto L_0x00f2
            androidx.compose.ui.text.AnnotatedString r2 = r0.$transformedText
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x00c7
            r2 = 1
            goto L_0x00c8
        L_0x00c7:
            r2 = 0
        L_0x00c8:
            if (r2 == 0) goto L_0x00f2
            r2 = -819891782(0xffffffffcf2171ba, float:-2.70858496E9)
            androidx.compose.material.TextFieldImplKt$TextFieldImpl$3$decoratedPlaceholder$1 r4 = new androidx.compose.material.TextFieldImplKt$TextFieldImpl$3$decoratedPlaceholder$1
            androidx.compose.material.TextFieldColors r5 = r0.$colors
            boolean r6 = r0.$enabled
            int r10 = r0.$$dirty
            int r11 = r0.$$dirty1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r15 = r0.$placeholder
            r21 = r15
            r15 = r4
            r16 = r55
            r17 = r5
            r18 = r6
            r19 = r10
            r20 = r11
            r15.<init>(r16, r17, r18, r19, r20, r21)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r2, r9, r4)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r19 = r1
            goto L_0x00f4
        L_0x00f2:
            r19 = r8
        L_0x00f4:
            androidx.compose.material.Strings$Companion r1 = androidx.compose.material.Strings.Companion
            int r1 = r1.m1119getDefaultErrorMessageUdPEhr4()
            r15 = 6
            java.lang.String r1 = androidx.compose.material.Strings_androidKt.m1122getString4foXLRw(r1, r14, r15)
            androidx.compose.ui.Modifier r2 = r0.$modifier
            boolean r4 = r0.$isError
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r5 = r0.$isError
            r6 = -3686552(0xffffffffffc7bf68, float:NaN)
            r14.startReplaceableGroup(r6)
            java.lang.String r6 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r6)
            boolean r4 = r14.changed((java.lang.Object) r4)
            boolean r6 = r14.changed((java.lang.Object) r1)
            r4 = r4 | r6
            java.lang.Object r6 = r56.rememberedValue()
            if (r4 != 0) goto L_0x012b
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r6 != r4) goto L_0x0136
        L_0x012b:
            androidx.compose.material.TextFieldImplKt$TextFieldImpl$3$textFieldModifier$1$1 r4 = new androidx.compose.material.TextFieldImplKt$TextFieldImpl$3$textFieldModifier$1$1
            r4.<init>(r5, r1)
            r6 = r4
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r14.updateRememberedValue(r6)
        L_0x0136:
            r56.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            androidx.compose.ui.Modifier r20 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r3, r6, r9, r8)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r1 = r1 instanceof androidx.compose.material.TextFieldColorsWithIcons
            if (r1 == 0) goto L_0x0182
            r1 = -1061045592(0xffffffffc0c1baa8, float:-6.054035)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "164@6819L53"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            androidx.compose.material.TextFieldColorsWithIcons r1 = (androidx.compose.material.TextFieldColorsWithIcons) r1
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.$interactionSource
            androidx.compose.foundation.interaction.InteractionSource r4 = (androidx.compose.foundation.interaction.InteractionSource) r4
            int r5 = r0.$$dirty
            int r5 = r5 >> 3
            r5 = r5 & 14
            int r6 = r0.$$dirty1
            int r8 = r6 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            r5 = r5 | r8
            int r6 = r6 >> 15
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r5
            r5 = r56
            androidx.compose.runtime.State r1 = r1.leadingIconColor(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m1606unboximpl()
            r56.endReplaceableGroup()
            goto L_0x01b6
        L_0x0182:
            r1 = -1061045496(0xffffffffc0c1bb08, float:-6.054081)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "166@6915L34"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            int r4 = r0.$$dirty
            int r4 = r4 >> 3
            r4 = r4 & 14
            int r5 = r0.$$dirty1
            int r6 = r5 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            int r5 = r5 >> 21
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            androidx.compose.runtime.State r1 = r1.leadingIconColor(r2, r3, r14, r4)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m1606unboximpl()
            r56.endReplaceableGroup()
        L_0x01b6:
            r42 = r1
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r1 = r1 instanceof androidx.compose.material.TextFieldColorsWithIcons
            if (r1 == 0) goto L_0x01fb
            r1 = -1061045351(0xffffffffc0c1bb99, float:-6.05415)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "170@7060L54"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            androidx.compose.material.TextFieldColorsWithIcons r1 = (androidx.compose.material.TextFieldColorsWithIcons) r1
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.$interactionSource
            androidx.compose.foundation.interaction.InteractionSource r4 = (androidx.compose.foundation.interaction.InteractionSource) r4
            int r5 = r0.$$dirty
            int r5 = r5 >> 3
            r5 = r5 & 14
            int r6 = r0.$$dirty1
            int r8 = r6 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            r5 = r5 | r8
            int r6 = r6 >> 15
            r6 = r6 & 896(0x380, float:1.256E-42)
            r6 = r6 | r5
            r5 = r56
            androidx.compose.runtime.State r1 = r1.trailingIconColor(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m1606unboximpl()
            r56.endReplaceableGroup()
            goto L_0x022f
        L_0x01fb:
            r1 = -1061045254(0xffffffffc0c1bbfa, float:-6.0541964)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "172@7157L35"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            int r4 = r0.$$dirty
            int r4 = r4 >> 3
            r4 = r4 & 14
            int r5 = r0.$$dirty1
            int r6 = r5 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r4 = r4 | r6
            int r5 = r5 >> 21
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            androidx.compose.runtime.State r1 = r1.trailingIconColor(r2, r3, r14, r4)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r1 = r1.m1606unboximpl()
            r56.endReplaceableGroup()
        L_0x022f:
            r44 = r1
            androidx.compose.material.TextFieldType r1 = r0.$type
            int[] r2 = androidx.compose.material.TextFieldImplKt$TextFieldImpl$3.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r37 = 3670016(0x380000, float:5.142788E-39)
            r39 = 1879048192(0x70000000, float:1.58456325E29)
            r40 = 234881024(0xe000000, float:1.5777218E-30)
            r46 = 458752(0x70000, float:6.42848E-40)
            if (r1 == r9) goto L_0x036a
            if (r1 == r7) goto L_0x0254
            r1 = -1061042329(0xffffffffc0c1c767, float:-6.055591)
            r14.startReplaceableGroup(r1)
            r56.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0487
        L_0x0254:
            r1 = -1061043715(0xffffffffc0c1c1fd, float:-6.05493)
            r14.startReplaceableGroup(r1)
            java.lang.String r1 = "228@9781L51,230@9920L24,231@9993L20,206@8693L1344"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            boolean r3 = r0.$isError
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r0.$interactionSource
            androidx.compose.foundation.interaction.InteractionSource r4 = (androidx.compose.foundation.interaction.InteractionSource) r4
            int r5 = r0.$$dirty
            int r5 = r5 >> 3
            r5 = r5 & 14
            int r6 = r0.$$dirty1
            int r7 = r6 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            r5 = r5 | r7
            int r7 = r6 >> 15
            r7 = r7 & 896(0x380, float:1.256E-42)
            r5 = r5 | r7
            int r6 = r6 >> 18
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r5
            r5 = r56
            androidx.compose.runtime.State r1 = r1.indicatorColor(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r23 = r1.m1606unboximpl()
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            int r3 = r0.$$dirty
            int r3 = r3 >> 3
            r3 = r3 & 14
            int r4 = r0.$$dirty1
            int r4 = r4 >> 24
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            androidx.compose.runtime.State r1 = r1.backgroundColor(r2, r14, r3)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r27 = r1.m1606unboximpl()
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$isError
            int r3 = r0.$$dirty1
            int r4 = r3 >> 6
            r4 = r4 & 14
            int r3 = r3 >> 24
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            androidx.compose.runtime.State r1 = r1.cursorColor(r2, r14, r3)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r25 = r1.m1606unboximpl()
            androidx.compose.ui.text.input.TextFieldValue r2 = r0.$value
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r3 = r0.$onValueChange
            boolean r4 = r0.$enabled
            boolean r5 = r0.$readOnly
            androidx.compose.foundation.text.KeyboardOptions r6 = r0.$keyboardOptions
            androidx.compose.foundation.text.KeyboardActions r7 = r0.$keyboardActions
            androidx.compose.ui.text.TextStyle r8 = r0.$mergedTextStyle
            boolean r9 = r0.$singleLine
            int r10 = r0.$maxLines
            androidx.compose.ui.text.input.VisualTransformation r11 = r0.$visualTransformation
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = r0.$interactionSource
            r12 = r1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$leading
            r47 = 6
            r15 = r1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r1 = r0.$trailing
            r16 = r1
            androidx.compose.ui.graphics.Shape r1 = r0.$shape
            r29 = r1
            int r1 = r0.$$dirty
            int r17 = r1 >> 6
            r17 = r17 & 112(0x70, float:1.57E-43)
            int r13 = r1 >> 6
            r13 = r13 & 896(0x380, float:1.256E-42)
            r13 = r17 | r13
            int r14 = r1 << 6
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | r14
            int r1 = r1 << 6
            r1 = r1 & r36
            r1 = r1 | r13
            int r13 = r0.$$dirty1
            int r13 = r13 << 3
            r13 = r13 & r46
            r1 = r1 | r13
            int r13 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r13 = r13 << 18
            r1 = r1 | r13
            int r13 = r0.$$dirty1
            int r14 = r13 << 3
            r14 = r14 & r37
            r1 = r1 | r14
            int r14 = r0.$$dirty
            int r14 = r14 << 6
            r14 = r14 & r40
            r1 = r1 | r14
            int r14 = r13 << 9
            r14 = r14 & r39
            r31 = r1 | r14
            int r1 = r13 >> 9
            r1 = r1 & 14
            int r14 = r13 >> 18
            r14 = r14 & 112(0x70, float:1.57E-43)
            r1 = r1 | r14
            int r14 = r13 << 12
            r14 = r14 & r36
            r1 = r1 | r14
            int r14 = r13 << 12
            r14 = r14 & r46
            r1 = r1 | r14
            int r14 = r38 << 24
            r14 = r14 & r40
            r1 = r1 | r14
            int r14 = r38 << 18
            r14 = r14 & r39
            r32 = r1 | r14
            int r1 = r13 >> 15
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r33 = r1
            r34 = 0
            r1 = r20
            r13 = r19
            r0 = r56
            r14 = r41
            r17 = r42
            r19 = r44
            r21 = r49
            r22 = r54
            r30 = r56
            androidx.compose.material.OutlinedTextFieldKt.m1054OutlinedTextFieldLayoutuBqXD2s(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r21, r22, r23, r25, r27, r29, r30, r31, r32, r33, r34)
            r56.endReplaceableGroup()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = r48
            goto L_0x0487
        L_0x036a:
            r0 = r14
            r47 = 6
            r1 = -1061045122(0xffffffffc0c1bc7e, float:-6.0542593)
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "199@8366L51,200@8470L24,201@8543L20,177@7286L1336"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r7 = r0
            r0 = r48
            androidx.compose.ui.text.input.TextFieldValue r8 = r0.$value
            kotlin.jvm.functions.Function1<androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r9 = r0.$onValueChange
            boolean r2 = r0.$enabled
            r10 = r2
            boolean r11 = r0.$readOnly
            androidx.compose.foundation.text.KeyboardOptions r12 = r0.$keyboardOptions
            androidx.compose.foundation.text.KeyboardActions r13 = r0.$keyboardActions
            androidx.compose.ui.text.TextStyle r14 = r0.$mergedTextStyle
            boolean r15 = r0.$singleLine
            int r1 = r0.$maxLines
            r16 = r1
            androidx.compose.ui.text.input.VisualTransformation r1 = r0.$visualTransformation
            r17 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = r0.$interactionSource
            r18 = r1
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$leading
            r21 = r3
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r3 = r0.$trailing
            r22 = r3
            androidx.compose.material.TextFieldColors r3 = r0.$colors
            boolean r4 = r0.$isError
            r5 = r1
            androidx.compose.foundation.interaction.InteractionSource r5 = (androidx.compose.foundation.interaction.InteractionSource) r5
            int r1 = r0.$$dirty
            int r1 = r1 >> 3
            r1 = r1 & 14
            int r6 = r0.$$dirty1
            int r23 = r6 >> 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            r1 = r1 | r23
            r50 = r8
            int r8 = r6 >> 15
            r8 = r8 & 896(0x380, float:1.256E-42)
            r1 = r1 | r8
            int r6 = r6 >> 18
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r1
            r1 = r3
            r3 = r4
            r4 = r5
            r5 = r56
            androidx.compose.runtime.State r1 = r1.indicatorColor(r2, r3, r4, r5, r6)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r29 = r1.m1606unboximpl()
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$enabled
            int r3 = r0.$$dirty
            int r3 = r3 >> 3
            r3 = r3 & 14
            int r4 = r0.$$dirty1
            int r4 = r4 >> 24
            r4 = r4 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            androidx.compose.runtime.State r1 = r1.backgroundColor(r2, r7, r3)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r31 = r1.m1606unboximpl()
            androidx.compose.material.TextFieldColors r1 = r0.$colors
            boolean r2 = r0.$isError
            int r3 = r0.$$dirty1
            int r4 = r3 >> 6
            r4 = r4 & 14
            int r3 = r3 >> 24
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | r4
            androidx.compose.runtime.State r1 = r1.cursorColor(r2, r7, r3)
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.graphics.Color r1 = (androidx.compose.ui.graphics.Color) r1
            long r33 = r1.m1606unboximpl()
            androidx.compose.ui.graphics.Shape r1 = r0.$shape
            r35 = r1
            int r1 = r0.$$dirty
            int r2 = r1 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            int r3 = r1 >> 6
            r3 = r3 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            int r3 = r1 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r1 = r1 << 6
            r1 = r1 & r36
            r1 = r1 | r2
            int r2 = r0.$$dirty1
            int r2 = r2 << 3
            r2 = r2 & r46
            r1 = r1 | r2
            int r2 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r2 = r2 << 18
            r1 = r1 | r2
            int r2 = r0.$$dirty1
            int r3 = r2 << 3
            r3 = r3 & r37
            r1 = r1 | r3
            int r3 = r0.$$dirty
            int r3 = r3 << 6
            r3 = r3 & r40
            r1 = r1 | r3
            int r3 = r2 << 9
            r3 = r3 & r39
            r37 = r1 | r3
            int r1 = r2 >> 9
            r1 = r1 & 14
            int r3 = r2 >> 18
            r3 = r3 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            int r3 = r2 << 12
            r3 = r3 & r36
            r1 = r1 | r3
            int r3 = r2 << 12
            r3 = r3 & r46
            r1 = r1 | r3
            int r3 = r38 << 24
            r3 = r3 & r40
            r1 = r1 | r3
            int r3 = r38 << 18
            r3 = r3 & r39
            r38 = r1 | r3
            int r1 = r2 >> 15
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r39 = r1
            r40 = 0
            r7 = r20
            r20 = r41
            r23 = r42
            r25 = r44
            r27 = r49
            r28 = r54
            r36 = r56
            r8 = r50
            androidx.compose.material.TextFieldKt.m1173TextFieldLayoutuBqXD2s(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r27, r28, r29, r31, r33, r35, r36, r37, r38, r39, r40)
            r56.endReplaceableGroup()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0487:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt$TextFieldImpl$3.m1168invokeh1eTWw(float, long, long, float, float, androidx.compose.runtime.Composer, int):void");
    }
}
