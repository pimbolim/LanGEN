package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a¢\u0001\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\t2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0019\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f¢\u0006\u0002\b\t2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0002\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010 \u001a\u00020!2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u000202H\u0007¢\u0006\u0002\u00103\u001a\u0002\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u0002042\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00060\f2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010 \u001a\u00020!2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0015\b\u0002\u0010#\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u000202H\u0007¢\u0006\u0002\u00105\u001a\u0002\u00106\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020.2\u0019\u00107\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f¢\u0006\u0002\b\t2\u0013\u00108\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0002\b\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020\u00132\u0006\u0010/\u001a\u000200H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?\u001aU\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020\u00112\u0006\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010K\u001aE\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020,2\u0006\u0010N\u001a\u00020,2\u0006\u0010O\u001a\u00020,2\u0006\u0010P\u001a\u00020,2\u0006\u0010Q\u001a\u00020,2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010S\u001a)\u0010T\u001a\u00020\r*\u00020\r2\u0006\u0010U\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u0013H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bW\u0010X\u001at\u0010Y\u001a\u00020\u0006*\u00020Z2\u0006\u0010[\u001a\u00020,2\u0006\u0010\\\u001a\u00020,2\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010^2\b\u0010`\u001a\u0004\u0018\u00010^2\b\u0010a\u001a\u0004\u0018\u00010^2\b\u0010b\u001a\u0004\u0018\u00010^2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010c\u001a\u00020,2\u0006\u0010d\u001a\u00020,2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010I\u001a\u00020\u0016H\u0002\u001aR\u0010e\u001a\u00020\u0006*\u00020Z2\u0006\u0010[\u001a\u00020,2\u0006\u0010\\\u001a\u00020,2\u0006\u0010f\u001a\u00020^2\b\u0010`\u001a\u0004\u0018\u00010^2\b\u0010a\u001a\u0004\u0018\u00010^2\b\u0010b\u001a\u0004\u0018\u00010^2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u0016H\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006g"}, d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "F", "LastBaselineOffset", "TextFieldTopPadding", "IconsWithTextFieldLayout", "", "textField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "label", "placeholder", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "leading", "trailing", "singleLine", "", "leadingColor", "Landroidx/compose/ui/graphics/Color;", "trailingColor", "animationProgress", "", "IconsWithTextFieldLayout-SxpAMN0", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZJJFLandroidx/compose/runtime/Composer;I)V", "TextField", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "modifier", "enabled", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "decoratedPlaceholder", "decoratedLabel", "labelProgress", "indicatorWidth", "indicatorColor", "backgroundColor", "cursorColor", "TextFieldLayout-uBqXD2s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/ui/text/TextStyle;ZILandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFFJJJLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;IIII)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-YbqEFUw", "(IZIIIIJF)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "lineWidth", "color", "drawIndicatorLine-H2RKhps", "(Landroidx/compose/ui/Modifier;FJ)Landroidx/compose/ui/Modifier;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextField.kt */
public final class TextFieldKt {
    /* access modifiers changed from: private */
    public static final float FirstBaselineOffset = Dp.m3859constructorimpl((float) 20);
    /* access modifiers changed from: private */
    public static final float LastBaselineOffset = Dp.m3859constructorimpl((float) 10);
    /* access modifiers changed from: private */
    public static final float TextFieldTopPadding = Dp.m3859constructorimpl((float) 4);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01b2, code lost:
        if (r0.changed((java.lang.Object) r86) != false) goto L_0x01b9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x05ac  */
    /* JADX WARNING: Removed duplicated region for block: B:296:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextField(java.lang.String r73, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r74, androidx.compose.ui.Modifier r75, boolean r76, boolean r77, androidx.compose.ui.text.TextStyle r78, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r81, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r82, boolean r83, androidx.compose.ui.text.input.VisualTransformation r84, androidx.compose.foundation.text.KeyboardOptions r85, androidx.compose.foundation.text.KeyboardActions r86, boolean r87, int r88, androidx.compose.foundation.interaction.MutableInteractionSource r89, androidx.compose.ui.graphics.Shape r90, androidx.compose.material.TextFieldColors r91, androidx.compose.runtime.Composer r92, int r93, int r94, int r95) {
        /*
            r1 = r73
            r2 = r74
            r15 = r93
            r14 = r94
            r13 = r95
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r0 = -833028745(0xffffffffce58fd77, float:-9.1012243E8)
            r3 = r92
            androidx.compose.runtime.Composer r0 = r3.startRestartGroup(r0)
            java.lang.String r3 = "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)160@8206L7,171@8760L39,173@8842L6,174@8967L17,176@9020L57,183@9270L137,179@9147L779:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            r3 = r13 & 1
            if (r3 == 0) goto L_0x002a
            r3 = r15 | 6
            goto L_0x003a
        L_0x002a:
            r3 = r15 & 14
            if (r3 != 0) goto L_0x0039
            boolean r3 = r0.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0036
            r3 = 4
            goto L_0x0037
        L_0x0036:
            r3 = 2
        L_0x0037:
            r3 = r3 | r15
            goto L_0x003a
        L_0x0039:
            r3 = r15
        L_0x003a:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x0041
            r3 = r3 | 48
            goto L_0x0051
        L_0x0041:
            r6 = r15 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0051
            boolean r6 = r0.changed((java.lang.Object) r2)
            if (r6 == 0) goto L_0x004e
            r6 = 32
            goto L_0x0050
        L_0x004e:
            r6 = 16
        L_0x0050:
            r3 = r3 | r6
        L_0x0051:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0058
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0058:
            r11 = r15 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x006b
            r11 = r75
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0067
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r12 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r3 = r3 | r12
            goto L_0x006d
        L_0x006b:
            r11 = r75
        L_0x006d:
            r12 = r13 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0078
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x0078:
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x008c
            r4 = r76
            boolean r18 = r0.changed((boolean) r4)
            if (r18 == 0) goto L_0x0087
            r18 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r3 = r3 | r18
            goto L_0x008e
        L_0x008c:
            r4 = r76
        L_0x008e:
            r18 = r13 & 16
            r64 = 57344(0xe000, float:8.0356E-41)
            r19 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x009c
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r7 = r77
            goto L_0x00af
        L_0x009c:
            r20 = r15 & r64
            r7 = r77
            if (r20 != 0) goto L_0x00af
            boolean r21 = r0.changed((boolean) r7)
            if (r21 == 0) goto L_0x00ab
            r21 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00ab:
            r21 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r3 = r3 | r21
        L_0x00af:
            r65 = 458752(0x70000, float:6.42848E-40)
            r21 = r15 & r65
            r22 = 131072(0x20000, float:1.83671E-40)
            if (r21 != 0) goto L_0x00cb
            r21 = r13 & 32
            r8 = r78
            if (r21 != 0) goto L_0x00c6
            boolean r23 = r0.changed((java.lang.Object) r8)
            if (r23 == 0) goto L_0x00c6
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c6:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r3 = r3 | r23
            goto L_0x00cd
        L_0x00cb:
            r8 = r78
        L_0x00cd:
            r23 = r13 & 64
            r66 = 3670016(0x380000, float:5.142788E-39)
            if (r23 == 0) goto L_0x00da
            r24 = 1572864(0x180000, float:2.204052E-39)
            r3 = r3 | r24
            r9 = r79
            goto L_0x00ed
        L_0x00da:
            r24 = r15 & r66
            r9 = r79
            if (r24 != 0) goto L_0x00ed
            boolean r25 = r0.changed((java.lang.Object) r9)
            if (r25 == 0) goto L_0x00e9
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00eb
        L_0x00e9:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00eb:
            r3 = r3 | r25
        L_0x00ed:
            r10 = r13 & 128(0x80, float:1.794E-43)
            r67 = 29360128(0x1c00000, float:7.052966E-38)
            if (r10 == 0) goto L_0x00fa
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            r3 = r3 | r26
            r5 = r80
            goto L_0x010d
        L_0x00fa:
            r26 = r15 & r67
            r5 = r80
            if (r26 != 0) goto L_0x010d
            boolean r26 = r0.changed((java.lang.Object) r5)
            if (r26 == 0) goto L_0x0109
            r26 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010b
        L_0x0109:
            r26 = 4194304(0x400000, float:5.877472E-39)
        L_0x010b:
            r3 = r3 | r26
        L_0x010d:
            r4 = r13 & 256(0x100, float:3.59E-43)
            r68 = 234881024(0xe000000, float:1.5777218E-30)
            if (r4 == 0) goto L_0x011a
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r3 = r3 | r26
            r5 = r81
            goto L_0x012d
        L_0x011a:
            r26 = r15 & r68
            r5 = r81
            if (r26 != 0) goto L_0x012d
            boolean r26 = r0.changed((java.lang.Object) r5)
            if (r26 == 0) goto L_0x0129
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012b
        L_0x0129:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012b:
            r3 = r3 | r26
        L_0x012d:
            r5 = r13 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0138
            r26 = 805306368(0x30000000, float:4.656613E-10)
            r3 = r3 | r26
            r7 = r82
            goto L_0x014d
        L_0x0138:
            r26 = 1879048192(0x70000000, float:1.58456325E29)
            r26 = r15 & r26
            r7 = r82
            if (r26 != 0) goto L_0x014d
            boolean r26 = r0.changed((java.lang.Object) r7)
            if (r26 == 0) goto L_0x0149
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014b
        L_0x0149:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014b:
            r3 = r3 | r26
        L_0x014d:
            r7 = r13 & 1024(0x400, float:1.435E-42)
            if (r7 == 0) goto L_0x0156
            r26 = r14 | 6
            r8 = r83
            goto L_0x016c
        L_0x0156:
            r26 = r14 & 14
            r8 = r83
            if (r26 != 0) goto L_0x016a
            boolean r26 = r0.changed((boolean) r8)
            if (r26 == 0) goto L_0x0165
            r26 = 4
            goto L_0x0167
        L_0x0165:
            r26 = 2
        L_0x0167:
            r26 = r14 | r26
            goto L_0x016c
        L_0x016a:
            r26 = r14
        L_0x016c:
            r8 = r13 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0175
            r26 = r26 | 48
            r9 = r84
            goto L_0x0188
        L_0x0175:
            r27 = r14 & 112(0x70, float:1.57E-43)
            r9 = r84
            if (r27 != 0) goto L_0x0188
            boolean r27 = r0.changed((java.lang.Object) r9)
            if (r27 == 0) goto L_0x0184
            r20 = 32
            goto L_0x0186
        L_0x0184:
            r20 = 16
        L_0x0186:
            r26 = r26 | r20
        L_0x0188:
            r9 = r14 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x01a2
            r9 = r13 & 4096(0x1000, float:5.74E-42)
            if (r9 != 0) goto L_0x019b
            r9 = r85
            boolean r20 = r0.changed((java.lang.Object) r9)
            if (r20 == 0) goto L_0x019d
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x019f
        L_0x019b:
            r9 = r85
        L_0x019d:
            r25 = 128(0x80, float:1.794E-43)
        L_0x019f:
            r26 = r26 | r25
            goto L_0x01a4
        L_0x01a2:
            r9 = r85
        L_0x01a4:
            r9 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01bc
            r9 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r9 != 0) goto L_0x01b5
            r9 = r86
            boolean r20 = r0.changed((java.lang.Object) r9)
            if (r20 == 0) goto L_0x01b7
            goto L_0x01b9
        L_0x01b5:
            r9 = r86
        L_0x01b7:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x01b9:
            r26 = r26 | r16
            goto L_0x01be
        L_0x01bc:
            r9 = r86
        L_0x01be:
            r9 = r26
            r11 = r13 & 16384(0x4000, float:2.2959E-41)
            if (r11 == 0) goto L_0x01c9
            r9 = r9 | 24576(0x6000, float:3.4438E-41)
            r2 = r87
            goto L_0x01d9
        L_0x01c9:
            r16 = r14 & r64
            r2 = r87
            if (r16 != 0) goto L_0x01d9
            boolean r16 = r0.changed((boolean) r2)
            if (r16 == 0) goto L_0x01d7
            r19 = 16384(0x4000, float:2.2959E-41)
        L_0x01d7:
            r9 = r9 | r19
        L_0x01d9:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r13 & r16
            if (r16 == 0) goto L_0x01e7
            r17 = 196608(0x30000, float:2.75506E-40)
            r9 = r9 | r17
            r2 = r88
            goto L_0x01fa
        L_0x01e7:
            r17 = r14 & r65
            r2 = r88
            if (r17 != 0) goto L_0x01fa
            boolean r17 = r0.changed((int) r2)
            if (r17 == 0) goto L_0x01f6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f8
        L_0x01f6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x01f8:
            r9 = r9 | r17
        L_0x01fa:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r13 & r17
            if (r17 == 0) goto L_0x0207
            r19 = 1572864(0x180000, float:2.204052E-39)
            r9 = r9 | r19
            r2 = r89
            goto L_0x021a
        L_0x0207:
            r19 = r14 & r66
            r2 = r89
            if (r19 != 0) goto L_0x021a
            boolean r19 = r0.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x0216
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0218
        L_0x0216:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x0218:
            r9 = r9 | r19
        L_0x021a:
            r19 = r14 & r67
            if (r19 != 0) goto L_0x0232
            r19 = r13 & r22
            r2 = r90
            if (r19 != 0) goto L_0x022d
            boolean r19 = r0.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x022d
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x022f
        L_0x022d:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x022f:
            r9 = r9 | r19
            goto L_0x0234
        L_0x0232:
            r2 = r90
        L_0x0234:
            r19 = r14 & r68
            if (r19 != 0) goto L_0x024e
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r13 & r19
            r2 = r91
            if (r19 != 0) goto L_0x0249
            boolean r19 = r0.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x0249
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x024b
        L_0x0249:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x024b:
            r9 = r9 | r19
            goto L_0x0250
        L_0x024e:
            r2 = r91
        L_0x0250:
            r19 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r19 = r3 & r19
            r20 = 306783378(0x12492492, float:6.3469493E-28)
            r19 = r19 ^ r20
            if (r19 != 0) goto L_0x0298
            r19 = 191739611(0xb6db6db, float:4.5782105E-32)
            r19 = r9 & r19
            r20 = 38347922(0x2492492, float:1.4777643E-37)
            r19 = r19 ^ r20
            if (r19 != 0) goto L_0x0298
            boolean r19 = r0.getSkipping()
            if (r19 != 0) goto L_0x026f
            goto L_0x0298
        L_0x026f:
            r0.skipToGroupEnd()
            r12 = r74
            r3 = r75
            r4 = r76
            r5 = r77
            r6 = r78
            r7 = r79
            r8 = r80
            r9 = r81
            r10 = r82
            r11 = r83
            r13 = r84
            r14 = r85
            r15 = r86
            r39 = r87
            r16 = r88
            r17 = r89
            r18 = r90
            r19 = r2
            goto L_0x05a5
        L_0x0298:
            r0.startDefaults()
            r19 = r15 & 1
            if (r19 == 0) goto L_0x02f4
            boolean r19 = r0.getDefaultsInvalid()
            if (r19 == 0) goto L_0x02a6
            goto L_0x02f4
        L_0x02a6:
            r0.skipToGroupEnd()
            r4 = r13 & 32
            if (r4 == 0) goto L_0x02b1
            r4 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r4
        L_0x02b1:
            r4 = r13 & 4096(0x1000, float:5.74E-42)
            if (r4 == 0) goto L_0x02b7
            r9 = r9 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x02b7:
            r4 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x02bd
            r9 = r9 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x02bd:
            r4 = r13 & r22
            if (r4 == 0) goto L_0x02c5
            r4 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r9 = r9 & r4
        L_0x02c5:
            r4 = 262144(0x40000, float:3.67342E-40)
            r4 = r4 & r13
            if (r4 == 0) goto L_0x02ce
            r4 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r9 = r9 & r4
        L_0x02ce:
            r2 = r75
            r69 = r77
            r4 = r78
            r6 = r79
            r10 = r80
            r5 = r81
            r7 = r82
            r8 = r83
            r12 = r85
            r11 = r86
            r39 = r87
            r70 = r88
            r40 = r89
            r41 = r90
            r42 = r91
            r13 = r3
            r14 = r9
            r3 = r76
            r9 = r84
            goto L_0x048b
        L_0x02f4:
            if (r6 == 0) goto L_0x02fb
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            goto L_0x02fd
        L_0x02fb:
            r6 = r75
        L_0x02fd:
            if (r12 == 0) goto L_0x0301
            r12 = 1
            goto L_0x0303
        L_0x0301:
            r12 = r76
        L_0x0303:
            if (r18 == 0) goto L_0x030a
            r18 = 0
            r69 = 0
            goto L_0x030c
        L_0x030a:
            r69 = r77
        L_0x030c:
            r18 = r13 & 32
            if (r18 == 0) goto L_0x0332
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.material.TextKt.getLocalTextStyle()
            r2 = r18
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r75 = r6
            r6 = 103361330(0x6292b32, float:3.1817102E-35)
            r76 = r12
            java.lang.String r12 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r12)
            java.lang.Object r2 = r0.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            androidx.compose.ui.text.TextStyle r2 = (androidx.compose.ui.text.TextStyle) r2
            r6 = -458753(0xfffffffffff8ffff, float:NaN)
            r3 = r3 & r6
            goto L_0x0338
        L_0x0332:
            r75 = r6
            r76 = r12
            r2 = r78
        L_0x0338:
            if (r23 == 0) goto L_0x033c
            r6 = 0
            goto L_0x033e
        L_0x033c:
            r6 = r79
        L_0x033e:
            if (r10 == 0) goto L_0x0342
            r10 = 0
            goto L_0x0344
        L_0x0342:
            r10 = r80
        L_0x0344:
            if (r4 == 0) goto L_0x0348
            r4 = 0
            goto L_0x034a
        L_0x0348:
            r4 = r81
        L_0x034a:
            if (r5 == 0) goto L_0x034e
            r5 = 0
            goto L_0x0350
        L_0x034e:
            r5 = r82
        L_0x0350:
            if (r7 == 0) goto L_0x0354
            r7 = 0
            goto L_0x0356
        L_0x0354:
            r7 = r83
        L_0x0356:
            if (r8 == 0) goto L_0x035f
            androidx.compose.ui.text.input.VisualTransformation$Companion r8 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r8 = r8.getNone()
            goto L_0x0361
        L_0x035f:
            r8 = r84
        L_0x0361:
            r12 = r13 & 4096(0x1000, float:5.74E-42)
            if (r12 == 0) goto L_0x036e
            androidx.compose.foundation.text.KeyboardOptions$Companion r12 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r12 = r12.getDefault()
            r9 = r9 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x0370
        L_0x036e:
            r12 = r85
        L_0x0370:
            r77 = r2
            r2 = r13 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x03a0
            androidx.compose.foundation.text.KeyboardActions r2 = new androidx.compose.foundation.text.KeyboardActions
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 63
            r26 = 0
            r78 = r2
            r79 = r18
            r80 = r19
            r81 = r20
            r82 = r21
            r83 = r23
            r84 = r24
            r85 = r25
            r86 = r26
            r78.<init>(r79, r80, r81, r82, r83, r84, r85, r86)
            r9 = r9 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x03a2
        L_0x03a0:
            r2 = r86
        L_0x03a2:
            if (r11 == 0) goto L_0x03a6
            r11 = 0
            goto L_0x03a8
        L_0x03a6:
            r11 = r87
        L_0x03a8:
            if (r16 == 0) goto L_0x03b1
            r16 = 2147483647(0x7fffffff, float:NaN)
            r70 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x03b3
        L_0x03b1:
            r70 = r88
        L_0x03b3:
            r78 = r2
            if (r17 == 0) goto L_0x03dd
            r2 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r2)
            java.lang.Object r2 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r71 = r3
            java.lang.Object r3 = r16.getEmpty()
            if (r2 != r3) goto L_0x03d7
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r0.updateRememberedValue(r2)
        L_0x03d7:
            r0.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            goto L_0x03e1
        L_0x03dd:
            r71 = r3
            r2 = r89
        L_0x03e1:
            r3 = r13 & r22
            if (r3 == 0) goto L_0x041b
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r79 = r2
            r2 = 6
            androidx.compose.material.Shapes r2 = r3.getShapes(r0, r2)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getSmall()
            r3 = 0
            r16 = 0
            androidx.compose.foundation.shape.CornerSize r17 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            androidx.compose.foundation.shape.CornerSize r18 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            r19 = 3
            r20 = 0
            r80 = r2
            r81 = r3
            r82 = r16
            r83 = r17
            r84 = r18
            r85 = r19
            r86 = r20
            androidx.compose.foundation.shape.CornerBasedShape r2 = androidx.compose.foundation.shape.CornerBasedShape.copy$default(r80, r81, r82, r83, r84, r85, r86)
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r3 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r3 = r3 & r9
            r9 = r3
            goto L_0x041f
        L_0x041b:
            r79 = r2
            r2 = r90
        L_0x041f:
            r3 = 262144(0x40000, float:3.67342E-40)
            r3 = r3 & r13
            if (r3 == 0) goto L_0x0474
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            r62 = 48
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r59 = r0
            androidx.compose.material.TextFieldColors r3 = r16.m1166textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r9 = r9 & r16
            r40 = r79
            r41 = r2
            r42 = r3
            r14 = r9
            r39 = r11
            r13 = r71
            r2 = r75
            r3 = r76
            goto L_0x0483
        L_0x0474:
            r3 = r76
            r40 = r79
            r42 = r91
            r41 = r2
            r14 = r9
            r39 = r11
            r13 = r71
            r2 = r75
        L_0x0483:
            r11 = r78
            r9 = r8
            r8 = r7
            r7 = r5
            r5 = r4
            r4 = r77
        L_0x048b:
            r0.endDefaults()
            r15 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r15)
            java.lang.String r15 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r15)
            java.lang.Object r15 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r82 = r11
            java.lang.Object r11 = r16.getEmpty()
            if (r15 != r11) goto L_0x04cc
            androidx.compose.ui.text.input.TextFieldValue r11 = new androidx.compose.ui.text.input.TextFieldValue
            r15 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            r75 = r11
            r76 = r73
            r77 = r15
            r79 = r17
            r80 = r18
            r81 = r19
            r75.<init>((java.lang.String) r76, (long) r77, (androidx.compose.ui.text.TextRange) r79, (int) r80, (kotlin.jvm.internal.DefaultConstructorMarker) r81)
            r83 = r12
            r12 = 0
            r15 = 2
            androidx.compose.runtime.MutableState r15 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r11, r12, r15, r12)
            r0.updateRememberedValue(r15)
            goto L_0x04ce
        L_0x04cc:
            r83 = r12
        L_0x04ce:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            androidx.compose.ui.text.input.TextFieldValue r11 = m1171TextField$lambda2(r15)
            r16 = 0
            r12 = 0
            r18 = 6
            r19 = 0
            r75 = r11
            r76 = r73
            r77 = r16
            r79 = r12
            r80 = r18
            r81 = r19
            androidx.compose.ui.text.input.TextFieldValue r16 = androidx.compose.ui.text.input.TextFieldValue.m3684copy3r_uNRQ$default((androidx.compose.ui.text.input.TextFieldValue) r75, (java.lang.String) r76, (long) r77, (androidx.compose.ui.text.TextRange) r79, (int) r80, (java.lang.Object) r81)
            r11 = -3686095(0xffffffffffc7c131, float:NaN)
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            boolean r11 = r0.changed((java.lang.Object) r15)
            boolean r12 = r0.changed((java.lang.Object) r1)
            r11 = r11 | r12
            r12 = r74
            boolean r17 = r0.changed((java.lang.Object) r12)
            r11 = r11 | r17
            r75 = r9
            java.lang.Object r9 = r0.rememberedValue()
            if (r11 != 0) goto L_0x051a
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r9 != r11) goto L_0x0524
        L_0x051a:
            androidx.compose.material.TextFieldKt$TextField$2$1 r9 = new androidx.compose.material.TextFieldKt$TextField$2$1
            r9.<init>(r1, r12, r15)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r0.updateRememberedValue(r9)
        L_0x0524:
            r0.endReplaceableGroup()
            r17 = r9
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r9 = r13 & 896(0x380, float:1.256E-42)
            r11 = r13 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r11
            r11 = r13 & r64
            r9 = r9 | r11
            r11 = r13 & r65
            r9 = r9 | r11
            r11 = r13 & r66
            r9 = r9 | r11
            r11 = r13 & r67
            r9 = r9 | r11
            r11 = r13 & r68
            r9 = r9 | r11
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r11 = r11 & r13
            r36 = r9 | r11
            r9 = r14 & 14
            r11 = r14 & 112(0x70, float:1.57E-43)
            r9 = r9 | r11
            r11 = r14 & 896(0x380, float:1.256E-42)
            r9 = r9 | r11
            int r11 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r11 = r11 << 9
            r9 = r9 | r11
            r11 = r14 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | r11
            r11 = r14 & r64
            r9 = r9 | r11
            r11 = r14 & r65
            r9 = r9 | r11
            r11 = r14 & r66
            r9 = r9 | r11
            r11 = r14 & r67
            r9 = r9 | r11
            r11 = r14 & r68
            r37 = r9 | r11
            r38 = 0
            r18 = r2
            r19 = r3
            r20 = r69
            r21 = r4
            r22 = r6
            r23 = r10
            r24 = r5
            r25 = r7
            r26 = r8
            r27 = r75
            r28 = r83
            r29 = r82
            r30 = r39
            r31 = r70
            r32 = r40
            r33 = r41
            r34 = r42
            r35 = r0
            TextField((androidx.compose.ui.text.input.TextFieldValue) r16, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r17, (androidx.compose.ui.Modifier) r18, (boolean) r19, (boolean) r20, (androidx.compose.ui.text.TextStyle) r21, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r22, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r23, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r24, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r25, (boolean) r26, (androidx.compose.ui.text.input.VisualTransformation) r27, (androidx.compose.foundation.text.KeyboardOptions) r28, (androidx.compose.foundation.text.KeyboardActions) r29, (boolean) r30, (int) r31, (androidx.compose.foundation.interaction.MutableInteractionSource) r32, (androidx.compose.ui.graphics.Shape) r33, (androidx.compose.material.TextFieldColors) r34, (androidx.compose.runtime.Composer) r35, (int) r36, (int) r37, (int) r38)
            r13 = r75
            r15 = r82
            r14 = r83
            r9 = r5
            r11 = r8
            r8 = r10
            r17 = r40
            r18 = r41
            r19 = r42
            r5 = r69
            r16 = r70
            r10 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r2
        L_0x05a5:
            androidx.compose.runtime.ScopeUpdateScope r2 = r0.endRestartGroup()
            if (r2 != 0) goto L_0x05ac
            goto L_0x05cd
        L_0x05ac:
            androidx.compose.material.TextFieldKt$TextField$3 r23 = new androidx.compose.material.TextFieldKt$TextField$3
            r0 = r23
            r1 = r73
            r72 = r2
            r2 = r74
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r39
            r20 = r93
            r21 = r94
            r22 = r95
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r72
            r1.updateScope(r0)
        L_0x05cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: TextField$lambda-2  reason: not valid java name */
    private static final TextFieldValue m1171TextField$lambda2(MutableState<TextFieldValue> mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01b2, code lost:
        if (r10.changed((java.lang.Object) r85) != false) goto L_0x01b9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0540  */
    /* JADX WARNING: Removed duplicated region for block: B:286:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextField(androidx.compose.ui.text.input.TextFieldValue r72, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r73, androidx.compose.ui.Modifier r74, boolean r75, boolean r76, androidx.compose.ui.text.TextStyle r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r81, boolean r82, androidx.compose.ui.text.input.VisualTransformation r83, androidx.compose.foundation.text.KeyboardOptions r84, androidx.compose.foundation.text.KeyboardActions r85, boolean r86, int r87, androidx.compose.foundation.interaction.MutableInteractionSource r88, androidx.compose.ui.graphics.Shape r89, androidx.compose.material.TextFieldColors r90, androidx.compose.runtime.Composer r91, int r92, int r93, int r94) {
        /*
            r15 = r72
            r14 = r73
            r13 = r92
            r12 = r93
            r11 = r94
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -833022333(0xffffffffce591683, float:-9.105328E8)
            r1 = r91
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(TextField)P(17,10,9,1,12,15,6,11,7,16,3,18,5,4,14,8,2,13)278@14634L7,289@15188L39,291@15270L6,292@15395L17,294@15421L679:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x002a
            r0 = r13 | 6
            goto L_0x003a
        L_0x002a:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0039
            boolean r0 = r10.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0036
            r0 = 4
            goto L_0x0037
        L_0x0036:
            r0 = 2
        L_0x0037:
            r0 = r0 | r13
            goto L_0x003a
        L_0x0039:
            r0 = r13
        L_0x003a:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0041
            r0 = r0 | 48
            goto L_0x0051
        L_0x0041:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0051
            boolean r3 = r10.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x004e
            r3 = 32
            goto L_0x0050
        L_0x004e:
            r3 = 16
        L_0x0050:
            r0 = r0 | r3
        L_0x0051:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x0058
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0058:
            r8 = r13 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x006b
            r8 = r74
            boolean r9 = r10.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0067
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r0 = r0 | r9
            goto L_0x006d
        L_0x006b:
            r8 = r74
        L_0x006d:
            r9 = r11 & 8
            r16 = 2048(0x800, float:2.87E-42)
            r17 = 1024(0x400, float:1.435E-42)
            if (r9 == 0) goto L_0x0078
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x0078:
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x008c
            r1 = r75
            boolean r18 = r10.changed((boolean) r1)
            if (r18 == 0) goto L_0x0087
            r18 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r0 = r0 | r18
            goto L_0x008e
        L_0x008c:
            r1 = r75
        L_0x008e:
            r18 = r11 & 16
            r64 = 57344(0xe000, float:8.0356E-41)
            r19 = 8192(0x2000, float:1.14794E-41)
            if (r18 == 0) goto L_0x009c
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r76
            goto L_0x00af
        L_0x009c:
            r20 = r13 & r64
            r2 = r76
            if (r20 != 0) goto L_0x00af
            boolean r21 = r10.changed((boolean) r2)
            if (r21 == 0) goto L_0x00ab
            r21 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00ab:
            r21 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r0 = r0 | r21
        L_0x00af:
            r65 = 458752(0x70000, float:6.42848E-40)
            r21 = r13 & r65
            r22 = 131072(0x20000, float:1.83671E-40)
            if (r21 != 0) goto L_0x00cb
            r21 = r11 & 32
            r4 = r77
            if (r21 != 0) goto L_0x00c6
            boolean r23 = r10.changed((java.lang.Object) r4)
            if (r23 == 0) goto L_0x00c6
            r23 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c6:
            r23 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r0 = r0 | r23
            goto L_0x00cd
        L_0x00cb:
            r4 = r77
        L_0x00cd:
            r23 = r11 & 64
            r66 = 3670016(0x380000, float:5.142788E-39)
            if (r23 == 0) goto L_0x00da
            r24 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r24
            r5 = r78
            goto L_0x00ed
        L_0x00da:
            r24 = r13 & r66
            r5 = r78
            if (r24 != 0) goto L_0x00ed
            boolean r25 = r10.changed((java.lang.Object) r5)
            if (r25 == 0) goto L_0x00e9
            r25 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00eb
        L_0x00e9:
            r25 = 524288(0x80000, float:7.34684E-40)
        L_0x00eb:
            r0 = r0 | r25
        L_0x00ed:
            r6 = r11 & 128(0x80, float:1.794E-43)
            r67 = 29360128(0x1c00000, float:7.052966E-38)
            if (r6 == 0) goto L_0x00fa
            r26 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r26
            r7 = r79
            goto L_0x010d
        L_0x00fa:
            r26 = r13 & r67
            r7 = r79
            if (r26 != 0) goto L_0x010d
            boolean r27 = r10.changed((java.lang.Object) r7)
            if (r27 == 0) goto L_0x0109
            r27 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010b
        L_0x0109:
            r27 = 4194304(0x400000, float:5.877472E-39)
        L_0x010b:
            r0 = r0 | r27
        L_0x010d:
            r1 = r11 & 256(0x100, float:3.59E-43)
            r68 = 234881024(0xe000000, float:1.5777218E-30)
            if (r1 == 0) goto L_0x011a
            r27 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r27
            r2 = r80
            goto L_0x012d
        L_0x011a:
            r27 = r13 & r68
            r2 = r80
            if (r27 != 0) goto L_0x012d
            boolean r27 = r10.changed((java.lang.Object) r2)
            if (r27 == 0) goto L_0x0129
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012b
        L_0x0129:
            r27 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012b:
            r0 = r0 | r27
        L_0x012d:
            r2 = r11 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x0138
            r27 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r27
            r4 = r81
            goto L_0x014d
        L_0x0138:
            r27 = 1879048192(0x70000000, float:1.58456325E29)
            r27 = r13 & r27
            r4 = r81
            if (r27 != 0) goto L_0x014d
            boolean r27 = r10.changed((java.lang.Object) r4)
            if (r27 == 0) goto L_0x0149
            r27 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x014b
        L_0x0149:
            r27 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x014b:
            r0 = r0 | r27
        L_0x014d:
            r4 = r11 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0156
            r20 = r12 | 6
            r5 = r82
            goto L_0x016c
        L_0x0156:
            r27 = r12 & 14
            r5 = r82
            if (r27 != 0) goto L_0x016a
            boolean r27 = r10.changed((boolean) r5)
            if (r27 == 0) goto L_0x0165
            r20 = 4
            goto L_0x0167
        L_0x0165:
            r20 = 2
        L_0x0167:
            r20 = r12 | r20
            goto L_0x016c
        L_0x016a:
            r20 = r12
        L_0x016c:
            r5 = r11 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0175
            r20 = r20 | 48
            r7 = r83
            goto L_0x0188
        L_0x0175:
            r27 = r12 & 112(0x70, float:1.57E-43)
            r7 = r83
            if (r27 != 0) goto L_0x0188
            boolean r27 = r10.changed((java.lang.Object) r7)
            if (r27 == 0) goto L_0x0184
            r21 = 32
            goto L_0x0186
        L_0x0184:
            r21 = 16
        L_0x0186:
            r20 = r20 | r21
        L_0x0188:
            r7 = r12 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x01a2
            r7 = r11 & 4096(0x1000, float:5.74E-42)
            if (r7 != 0) goto L_0x019b
            r7 = r84
            boolean r21 = r10.changed((java.lang.Object) r7)
            if (r21 == 0) goto L_0x019d
            r25 = 256(0x100, float:3.59E-43)
            goto L_0x019f
        L_0x019b:
            r7 = r84
        L_0x019d:
            r25 = 128(0x80, float:1.794E-43)
        L_0x019f:
            r20 = r20 | r25
            goto L_0x01a4
        L_0x01a2:
            r7 = r84
        L_0x01a4:
            r7 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x01bc
            r7 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r7 != 0) goto L_0x01b5
            r7 = r85
            boolean r21 = r10.changed((java.lang.Object) r7)
            if (r21 == 0) goto L_0x01b7
            goto L_0x01b9
        L_0x01b5:
            r7 = r85
        L_0x01b7:
            r16 = 1024(0x400, float:1.435E-42)
        L_0x01b9:
            r20 = r20 | r16
            goto L_0x01be
        L_0x01bc:
            r7 = r85
        L_0x01be:
            r7 = r20
            r8 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x01c9
            r7 = r7 | 24576(0x6000, float:3.4438E-41)
            r14 = r86
            goto L_0x01d9
        L_0x01c9:
            r16 = r12 & r64
            r14 = r86
            if (r16 != 0) goto L_0x01d9
            boolean r16 = r10.changed((boolean) r14)
            if (r16 == 0) goto L_0x01d7
            r19 = 16384(0x4000, float:2.2959E-41)
        L_0x01d7:
            r7 = r7 | r19
        L_0x01d9:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r11 & r16
            if (r16 == 0) goto L_0x01e7
            r17 = 196608(0x30000, float:2.75506E-40)
            r7 = r7 | r17
            r14 = r87
            goto L_0x01fa
        L_0x01e7:
            r17 = r12 & r65
            r14 = r87
            if (r17 != 0) goto L_0x01fa
            boolean r17 = r10.changed((int) r14)
            if (r17 == 0) goto L_0x01f6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x01f8
        L_0x01f6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x01f8:
            r7 = r7 | r17
        L_0x01fa:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x0207
            r19 = 1572864(0x180000, float:2.204052E-39)
            r7 = r7 | r19
            r14 = r88
            goto L_0x021a
        L_0x0207:
            r19 = r12 & r66
            r14 = r88
            if (r19 != 0) goto L_0x021a
            boolean r19 = r10.changed((java.lang.Object) r14)
            if (r19 == 0) goto L_0x0216
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0218
        L_0x0216:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x0218:
            r7 = r7 | r19
        L_0x021a:
            r19 = r12 & r67
            if (r19 != 0) goto L_0x0232
            r19 = r11 & r22
            r14 = r89
            if (r19 != 0) goto L_0x022d
            boolean r19 = r10.changed((java.lang.Object) r14)
            if (r19 == 0) goto L_0x022d
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x022f
        L_0x022d:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x022f:
            r7 = r7 | r19
            goto L_0x0234
        L_0x0232:
            r14 = r89
        L_0x0234:
            r19 = r12 & r68
            if (r19 != 0) goto L_0x024e
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r11 & r19
            r12 = r90
            if (r19 != 0) goto L_0x0249
            boolean r19 = r10.changed((java.lang.Object) r12)
            if (r19 == 0) goto L_0x0249
            r19 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x024b
        L_0x0249:
            r19 = 33554432(0x2000000, float:9.403955E-38)
        L_0x024b:
            r7 = r7 | r19
            goto L_0x0250
        L_0x024e:
            r12 = r90
        L_0x0250:
            r19 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r19 = r0 & r19
            r20 = 306783378(0x12492492, float:6.3469493E-28)
            r19 = r19 ^ r20
            if (r19 != 0) goto L_0x0298
            r19 = 191739611(0xb6db6db, float:4.5782105E-32)
            r19 = r7 & r19
            r20 = 38347922(0x2492492, float:1.4777643E-37)
            r19 = r19 ^ r20
            if (r19 != 0) goto L_0x0298
            boolean r19 = r10.getSkipping()
            if (r19 != 0) goto L_0x026f
            goto L_0x0298
        L_0x026f:
            r10.skipToGroupEnd()
            r3 = r74
            r4 = r75
            r5 = r76
            r6 = r77
            r7 = r78
            r8 = r79
            r9 = r80
            r11 = r82
            r13 = r84
            r15 = r86
            r16 = r87
            r17 = r88
            r39 = r10
            r19 = r12
            r18 = r14
            r10 = r81
            r12 = r83
            r14 = r85
            goto L_0x0539
        L_0x0298:
            r10.startDefaults()
            r19 = r13 & 1
            if (r19 == 0) goto L_0x02f3
            boolean r19 = r10.getDefaultsInvalid()
            if (r19 == 0) goto L_0x02a6
            goto L_0x02f3
        L_0x02a6:
            r10.skipToGroupEnd()
            r1 = r11 & 32
            if (r1 == 0) goto L_0x02b1
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
        L_0x02b1:
            r1 = r11 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x02b7
            r7 = r7 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x02b7:
            r1 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x02bd
            r7 = r7 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x02bd:
            r1 = r11 & r22
            if (r1 == 0) goto L_0x02c5
            r1 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r7 = r7 & r1
        L_0x02c5:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r11
            if (r1 == 0) goto L_0x02ce
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r7 = r7 & r1
        L_0x02ce:
            r24 = r74
            r25 = r75
            r69 = r76
            r26 = r77
            r27 = r78
            r28 = r79
            r29 = r80
            r30 = r81
            r31 = r82
            r32 = r83
            r33 = r84
            r34 = r85
            r35 = r86
            r70 = r87
            r36 = r88
            r38 = r90
            r1 = r0
        L_0x02ef:
            r37 = r14
            goto L_0x049d
        L_0x02f3:
            if (r3 == 0) goto L_0x02fa
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02fc
        L_0x02fa:
            r3 = r74
        L_0x02fc:
            if (r9 == 0) goto L_0x0300
            r9 = 1
            goto L_0x0302
        L_0x0300:
            r9 = r75
        L_0x0302:
            if (r18 == 0) goto L_0x0309
            r18 = 0
            r69 = 0
            goto L_0x030b
        L_0x0309:
            r69 = r76
        L_0x030b:
            r18 = r11 & 32
            if (r18 == 0) goto L_0x0331
            androidx.compose.runtime.ProvidableCompositionLocal r18 = androidx.compose.material.TextKt.getLocalTextStyle()
            r12 = r18
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r74 = r3
            r3 = 103361330(0x6292b32, float:3.1817102E-35)
            r75 = r9
            java.lang.String r9 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r3, r9)
            java.lang.Object r3 = r10.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.text.TextStyle r3 = (androidx.compose.ui.text.TextStyle) r3
            r9 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r9
            goto L_0x0337
        L_0x0331:
            r74 = r3
            r75 = r9
            r3 = r77
        L_0x0337:
            r9 = 0
            if (r23 == 0) goto L_0x033c
            r12 = r9
            goto L_0x033e
        L_0x033c:
            r12 = r78
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            r6 = r9
            goto L_0x0344
        L_0x0342:
            r6 = r79
        L_0x0344:
            if (r1 == 0) goto L_0x0348
            r1 = r9
            goto L_0x034a
        L_0x0348:
            r1 = r80
        L_0x034a:
            if (r2 == 0) goto L_0x034d
            goto L_0x034f
        L_0x034d:
            r9 = r81
        L_0x034f:
            if (r4 == 0) goto L_0x0353
            r2 = 0
            goto L_0x0355
        L_0x0353:
            r2 = r82
        L_0x0355:
            if (r5 == 0) goto L_0x035e
            androidx.compose.ui.text.input.VisualTransformation$Companion r4 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r4 = r4.getNone()
            goto L_0x0360
        L_0x035e:
            r4 = r83
        L_0x0360:
            r5 = r11 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x036d
            androidx.compose.foundation.text.KeyboardOptions$Companion r5 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r5 = r5.getDefault()
            r7 = r7 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x036f
        L_0x036d:
            r5 = r84
        L_0x036f:
            r76 = r0
            r0 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x039f
            androidx.compose.foundation.text.KeyboardActions r0 = new androidx.compose.foundation.text.KeyboardActions
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = 63
            r26 = 0
            r77 = r0
            r78 = r18
            r79 = r19
            r80 = r20
            r81 = r21
            r82 = r23
            r83 = r24
            r84 = r25
            r85 = r26
            r77.<init>(r78, r79, r80, r81, r82, r83, r84, r85)
            r7 = r7 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x03a1
        L_0x039f:
            r0 = r85
        L_0x03a1:
            if (r8 == 0) goto L_0x03a5
            r8 = 0
            goto L_0x03a7
        L_0x03a5:
            r8 = r86
        L_0x03a7:
            if (r16 == 0) goto L_0x03b0
            r16 = 2147483647(0x7fffffff, float:NaN)
            r70 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x03b2
        L_0x03b0:
            r70 = r87
        L_0x03b2:
            r77 = r0
            if (r17 == 0) goto L_0x03dc
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r78 = r1
            java.lang.Object r1 = r16.getEmpty()
            if (r0 != r1) goto L_0x03d6
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r0)
        L_0x03d6:
            r10.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x03e0
        L_0x03dc:
            r78 = r1
            r0 = r88
        L_0x03e0:
            r1 = r11 & r22
            if (r1 == 0) goto L_0x0417
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r14 = 6
            androidx.compose.material.Shapes r1 = r1.getShapes(r10, r14)
            androidx.compose.foundation.shape.CornerBasedShape r1 = r1.getSmall()
            r14 = 0
            r16 = 0
            androidx.compose.foundation.shape.CornerSize r17 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            androidx.compose.foundation.shape.CornerSize r18 = androidx.compose.foundation.shape.CornerSizeKt.getZeroCornerSize()
            r19 = 3
            r20 = 0
            r79 = r1
            r80 = r14
            r81 = r16
            r82 = r17
            r83 = r18
            r84 = r19
            r85 = r20
            androidx.compose.foundation.shape.CornerBasedShape r1 = androidx.compose.foundation.shape.CornerBasedShape.copy$default(r79, r80, r81, r82, r83, r84, r85)
            androidx.compose.ui.graphics.Shape r1 = (androidx.compose.ui.graphics.Shape) r1
            r14 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r7 = r7 & r14
            r14 = r1
        L_0x0417:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r11
            if (r1 == 0) goto L_0x047d
            androidx.compose.material.TextFieldDefaults r16 = androidx.compose.material.TextFieldDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            r62 = 48
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r59 = r10
            androidx.compose.material.TextFieldColors r1 = r16.m1166textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r16 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r7 = r7 & r16
            r24 = r74
            r25 = r75
            r34 = r77
            r29 = r78
            r36 = r0
            r38 = r1
            r31 = r2
            r26 = r3
            r32 = r4
            r33 = r5
            r28 = r6
            r35 = r8
            r30 = r9
            r27 = r12
            r37 = r14
            r1 = r76
            goto L_0x049d
        L_0x047d:
            r24 = r74
            r25 = r75
            r1 = r76
            r34 = r77
            r29 = r78
            r38 = r90
            r36 = r0
            r31 = r2
            r26 = r3
            r32 = r4
            r33 = r5
            r28 = r6
            r35 = r8
            r30 = r9
            r27 = r12
            goto L_0x02ef
        L_0x049d:
            r10.endDefaults()
            androidx.compose.material.TextFieldType r0 = androidx.compose.material.TextFieldType.Filled
            int r2 = r1 >> 6
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 6
            r3 = r3 | r4
            r2 = r2 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            int r3 = r1 << 9
            r4 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r4
            r4 = r3 & r64
            r2 = r2 | r4
            r3 = r3 & r65
            r2 = r2 | r3
            int r3 = r7 << 6
            r4 = r3 & r66
            r2 = r2 | r4
            int r4 = r1 << 6
            r5 = r4 & r67
            r2 = r2 | r5
            r5 = r4 & r68
            r2 = r2 | r5
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r5
            r21 = r2 | r4
            int r1 = r1 >> 24
            r2 = r1 & 14
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r3 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r3 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r3 & r64
            r1 = r1 | r2
            int r2 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r2 = r2 << 15
            r1 = r1 | r2
            r2 = r3 & r65
            r1 = r1 | r2
            int r2 = r7 << 3
            r3 = r2 & r66
            r1 = r1 | r3
            r3 = r2 & r67
            r1 = r1 | r3
            r3 = r2 & r68
            r1 = r1 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r3
            r22 = r1 | r2
            r23 = 0
            r1 = r25
            r2 = r69
            r3 = r72
            r4 = r73
            r5 = r24
            r6 = r35
            r7 = r26
            r8 = r27
            r9 = r28
            r39 = r10
            r10 = r29
            r11 = r30
            r12 = r31
            r13 = r32
            r14 = r33
            r15 = r34
            r16 = r70
            r17 = r36
            r18 = r37
            r19 = r38
            r20 = r39
            androidx.compose.material.TextFieldImplKt.TextFieldImpl(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r3 = r24
            r4 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r10 = r30
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r5 = r69
        L_0x0539:
            androidx.compose.runtime.ScopeUpdateScope r2 = r39.endRestartGroup()
            if (r2 != 0) goto L_0x0540
            goto L_0x055c
        L_0x0540:
            androidx.compose.material.TextFieldKt$TextField$5 r23 = new androidx.compose.material.TextFieldKt$TextField$5
            r0 = r23
            r1 = r72
            r71 = r2
            r2 = r73
            r20 = r92
            r21 = r93
            r22 = r94
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r71
            r1.updateScope(r0)
        L_0x055c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x02b0  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x033c  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:261:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x016e  */
    /* renamed from: TextFieldLayout-uBqXD2s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1173TextFieldLayoutuBqXD2s(androidx.compose.ui.Modifier r44, androidx.compose.ui.text.input.TextFieldValue r45, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r46, boolean r47, boolean r48, androidx.compose.foundation.text.KeyboardOptions r49, androidx.compose.foundation.text.KeyboardActions r50, androidx.compose.ui.text.TextStyle r51, boolean r52, int r53, androidx.compose.ui.text.input.VisualTransformation r54, androidx.compose.foundation.interaction.MutableInteractionSource r55, kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, long r60, long r62, float r64, float r65, long r66, long r68, long r70, androidx.compose.ui.graphics.Shape r72, androidx.compose.runtime.Composer r73, int r74, int r75, int r76, int r77) {
        /*
            r1 = r44
            r0 = r45
            r14 = r46
            r12 = r49
            r11 = r50
            r10 = r51
            r9 = r54
            r8 = r55
            r7 = r65
            r5 = r66
            r2 = r68
            r15 = r72
            r13 = r74
            r4 = r75
            r2 = r76
            r3 = r77
            java.lang.String r5 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r5)
            java.lang.String r5 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r5)
            java.lang.String r5 = "keyboardOptions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r5)
            java.lang.String r5 = "keyboardActions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r5)
            java.lang.String r5 = "textStyle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r5)
            java.lang.String r5 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r5)
            java.lang.String r5 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)
            java.lang.String r5 = "shape"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r5)
            r5 = 2075840620(0x7bbad06c, float:1.939989E36)
            r6 = r73
            androidx.compose.runtime.Composer r6 = r6.startRestartGroup(r5)
            java.lang.String r5 = "C(TextFieldLayout)P(14,22,15,4,16,9,8,19,18,13,23,7,3,2,11,20,12:c#ui.graphics.Color,21:c#ui.graphics.Color,10,6:c#ui.unit.Dp,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)346@16941L1355:TextField.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r5)
            r5 = r3 & 1
            r16 = 4
            r17 = 2
            if (r5 == 0) goto L_0x006a
            r5 = r13 | 6
            goto L_0x007a
        L_0x006a:
            r5 = r13 & 14
            if (r5 != 0) goto L_0x0079
            boolean r5 = r6.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0076
            r5 = 4
            goto L_0x0077
        L_0x0076:
            r5 = 2
        L_0x0077:
            r5 = r5 | r13
            goto L_0x007a
        L_0x0079:
            r5 = r13
        L_0x007a:
            r18 = r3 & 2
            r19 = 32
            r20 = 16
            if (r18 == 0) goto L_0x0085
            r5 = r5 | 48
            goto L_0x0096
        L_0x0085:
            r18 = r13 & 112(0x70, float:1.57E-43)
            if (r18 != 0) goto L_0x0096
            boolean r18 = r6.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x0092
            r18 = 32
            goto L_0x0094
        L_0x0092:
            r18 = 16
        L_0x0094:
            r5 = r5 | r18
        L_0x0096:
            r18 = r3 & 4
            r21 = 256(0x100, float:3.59E-43)
            r22 = 128(0x80, float:1.794E-43)
            if (r18 == 0) goto L_0x00a1
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x00b1
        L_0x00a1:
            r0 = r13 & 896(0x380, float:1.256E-42)
            if (r0 != 0) goto L_0x00b1
            boolean r0 = r6.changed((java.lang.Object) r14)
            if (r0 == 0) goto L_0x00ae
            r0 = 256(0x100, float:3.59E-43)
            goto L_0x00b0
        L_0x00ae:
            r0 = 128(0x80, float:1.794E-43)
        L_0x00b0:
            r5 = r5 | r0
        L_0x00b1:
            r0 = r3 & 8
            r18 = 2048(0x800, float:2.87E-42)
            r23 = 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x00bc
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x00d0
        L_0x00bc:
            r0 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r0 != 0) goto L_0x00d0
            r0 = r47
            boolean r24 = r6.changed((boolean) r0)
            if (r24 == 0) goto L_0x00cb
            r24 = 2048(0x800, float:2.87E-42)
            goto L_0x00cd
        L_0x00cb:
            r24 = 1024(0x400, float:1.435E-42)
        L_0x00cd:
            r5 = r5 | r24
            goto L_0x00d2
        L_0x00d0:
            r0 = r47
        L_0x00d2:
            r24 = r3 & 16
            r25 = 16384(0x4000, float:2.2959E-41)
            r26 = 8192(0x2000, float:1.14794E-41)
            r27 = 57344(0xe000, float:8.0356E-41)
            if (r24 == 0) goto L_0x00e2
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r0 = r48
            goto L_0x00f5
        L_0x00e2:
            r24 = r13 & r27
            r0 = r48
            if (r24 != 0) goto L_0x00f5
            boolean r24 = r6.changed((boolean) r0)
            if (r24 == 0) goto L_0x00f1
            r24 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00f3
        L_0x00f1:
            r24 = 8192(0x2000, float:1.14794E-41)
        L_0x00f3:
            r5 = r5 | r24
        L_0x00f5:
            r24 = r3 & 32
            r28 = 458752(0x70000, float:6.42848E-40)
            if (r24 == 0) goto L_0x0100
            r24 = 196608(0x30000, float:2.75506E-40)
        L_0x00fd:
            r5 = r5 | r24
            goto L_0x0110
        L_0x0100:
            r24 = r13 & r28
            if (r24 != 0) goto L_0x0110
            boolean r24 = r6.changed((java.lang.Object) r12)
            if (r24 == 0) goto L_0x010d
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00fd
        L_0x010d:
            r24 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00fd
        L_0x0110:
            r24 = r3 & 64
            r29 = 3670016(0x380000, float:5.142788E-39)
            if (r24 == 0) goto L_0x011b
            r24 = 1572864(0x180000, float:2.204052E-39)
        L_0x0118:
            r5 = r5 | r24
            goto L_0x012b
        L_0x011b:
            r24 = r13 & r29
            if (r24 != 0) goto L_0x012b
            boolean r24 = r6.changed((java.lang.Object) r11)
            if (r24 == 0) goto L_0x0128
            r24 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0118
        L_0x0128:
            r24 = 524288(0x80000, float:7.34684E-40)
            goto L_0x0118
        L_0x012b:
            r0 = r3 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0133
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x0131:
            r5 = r5 | r0
            goto L_0x0144
        L_0x0133:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r13
            if (r0 != 0) goto L_0x0144
            boolean r0 = r6.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x0141
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0131
        L_0x0141:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0131
        L_0x0144:
            r0 = r3 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x014c
            r0 = 100663296(0x6000000, float:2.4074124E-35)
            r5 = r5 | r0
            goto L_0x0161
        L_0x014c:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r13
            if (r0 != 0) goto L_0x0161
            r0 = r52
            boolean r24 = r6.changed((boolean) r0)
            if (r24 == 0) goto L_0x015c
            r24 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x015e
        L_0x015c:
            r24 = 33554432(0x2000000, float:9.403955E-38)
        L_0x015e:
            r5 = r5 | r24
            goto L_0x0163
        L_0x0161:
            r0 = r52
        L_0x0163:
            r0 = r3 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x016e
            r24 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r5 | r24
            r10 = r53
            goto L_0x0183
        L_0x016e:
            r24 = 1879048192(0x70000000, float:1.58456325E29)
            r24 = r13 & r24
            r10 = r53
            if (r24 != 0) goto L_0x0183
            boolean r24 = r6.changed((int) r10)
            if (r24 == 0) goto L_0x017f
            r24 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0181
        L_0x017f:
            r24 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0181:
            r5 = r5 | r24
        L_0x0183:
            r10 = r3 & 1024(0x400, float:1.435E-42)
            if (r10 == 0) goto L_0x018a
            r10 = r4 | 6
            goto L_0x019a
        L_0x018a:
            r10 = r4 & 14
            if (r10 != 0) goto L_0x0199
            boolean r10 = r6.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0196
            r10 = 4
            goto L_0x0197
        L_0x0196:
            r10 = 2
        L_0x0197:
            r10 = r10 | r4
            goto L_0x019a
        L_0x0199:
            r10 = r4
        L_0x019a:
            r9 = r3 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x01a1
            r10 = r10 | 48
            goto L_0x01b1
        L_0x01a1:
            r9 = r4 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x01b1
            boolean r9 = r6.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x01ae
            r9 = 32
            goto L_0x01b0
        L_0x01ae:
            r9 = 16
        L_0x01b0:
            r10 = r10 | r9
        L_0x01b1:
            r9 = r3 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x01b8
            r10 = r10 | 384(0x180, float:5.38E-43)
            goto L_0x01cc
        L_0x01b8:
            r9 = r4 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x01cc
            r9 = r56
            boolean r24 = r6.changed((java.lang.Object) r9)
            if (r24 == 0) goto L_0x01c7
            r24 = 256(0x100, float:3.59E-43)
            goto L_0x01c9
        L_0x01c7:
            r24 = 128(0x80, float:1.794E-43)
        L_0x01c9:
            r10 = r10 | r24
            goto L_0x01ce
        L_0x01cc:
            r9 = r56
        L_0x01ce:
            r8 = r3 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x01d5
            r10 = r10 | 3072(0xc00, float:4.305E-42)
            goto L_0x01e9
        L_0x01d5:
            r8 = r4 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x01e9
            r8 = r57
            boolean r24 = r6.changed((java.lang.Object) r8)
            if (r24 == 0) goto L_0x01e4
            r24 = 2048(0x800, float:2.87E-42)
            goto L_0x01e6
        L_0x01e4:
            r24 = 1024(0x400, float:1.435E-42)
        L_0x01e6:
            r10 = r10 | r24
            goto L_0x01eb
        L_0x01e9:
            r8 = r57
        L_0x01eb:
            r8 = r3 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x01f2
            r10 = r10 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0204
        L_0x01f2:
            r8 = r4 & r27
            if (r8 != 0) goto L_0x0204
            r8 = r58
            boolean r24 = r6.changed((java.lang.Object) r8)
            if (r24 == 0) goto L_0x01ff
            goto L_0x0201
        L_0x01ff:
            r25 = 8192(0x2000, float:1.14794E-41)
        L_0x0201:
            r10 = r10 | r25
            goto L_0x0206
        L_0x0204:
            r8 = r58
        L_0x0206:
            r24 = 32768(0x8000, float:4.5918E-41)
            r24 = r3 & r24
            if (r24 == 0) goto L_0x0214
            r24 = 196608(0x30000, float:2.75506E-40)
            r10 = r10 | r24
            r13 = r59
            goto L_0x0227
        L_0x0214:
            r24 = r4 & r28
            r13 = r59
            if (r24 != 0) goto L_0x0227
            boolean r24 = r6.changed((java.lang.Object) r13)
            if (r24 == 0) goto L_0x0223
            r24 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0225
        L_0x0223:
            r24 = 65536(0x10000, float:9.18355E-41)
        L_0x0225:
            r10 = r10 | r24
        L_0x0227:
            r24 = 65536(0x10000, float:9.18355E-41)
            r24 = r3 & r24
            if (r24 == 0) goto L_0x0234
            r24 = 1572864(0x180000, float:2.204052E-39)
            r10 = r10 | r24
            r13 = r60
            goto L_0x0247
        L_0x0234:
            r24 = r4 & r29
            r13 = r60
            if (r24 != 0) goto L_0x0247
            boolean r24 = r6.changed((long) r13)
            if (r24 == 0) goto L_0x0243
            r24 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0245
        L_0x0243:
            r24 = 524288(0x80000, float:7.34684E-40)
        L_0x0245:
            r10 = r10 | r24
        L_0x0247:
            r24 = 131072(0x20000, float:1.83671E-40)
            r24 = r3 & r24
            if (r24 == 0) goto L_0x0254
            r24 = 12582912(0xc00000, float:1.7632415E-38)
            r10 = r10 | r24
            r13 = r62
            goto L_0x0269
        L_0x0254:
            r24 = 29360128(0x1c00000, float:7.052966E-38)
            r24 = r4 & r24
            r13 = r62
            if (r24 != 0) goto L_0x0269
            boolean r24 = r6.changed((long) r13)
            if (r24 == 0) goto L_0x0265
            r24 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0267
        L_0x0265:
            r24 = 4194304(0x400000, float:5.877472E-39)
        L_0x0267:
            r10 = r10 | r24
        L_0x0269:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r3 & r24
            if (r24 == 0) goto L_0x0276
            r24 = 100663296(0x6000000, float:2.4074124E-35)
            r10 = r10 | r24
            r13 = r64
            goto L_0x028a
        L_0x0276:
            r24 = 234881024(0xe000000, float:1.5777218E-30)
            r24 = r4 & r24
            r13 = r64
            if (r24 != 0) goto L_0x028a
            boolean r14 = r6.changed((float) r13)
            if (r14 == 0) goto L_0x0287
            r14 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0289
        L_0x0287:
            r14 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0289:
            r10 = r10 | r14
        L_0x028a:
            r14 = 524288(0x80000, float:7.34684E-40)
            r14 = r14 & r3
            if (r14 == 0) goto L_0x0293
            r14 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0291:
            r10 = r10 | r14
            goto L_0x02a4
        L_0x0293:
            r14 = 1879048192(0x70000000, float:1.58456325E29)
            r14 = r14 & r4
            if (r14 != 0) goto L_0x02a4
            boolean r14 = r6.changed((float) r7)
            if (r14 == 0) goto L_0x02a1
            r14 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0291
        L_0x02a1:
            r14 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0291
        L_0x02a4:
            r14 = 1048576(0x100000, float:1.469368E-39)
            r14 = r14 & r3
            if (r14 == 0) goto L_0x02b0
            r14 = r2 | 6
            r16 = r14
            r13 = r66
            goto L_0x02c6
        L_0x02b0:
            r14 = r2 & 14
            if (r14 != 0) goto L_0x02c2
            r13 = r66
            boolean r24 = r6.changed((long) r13)
            if (r24 == 0) goto L_0x02bd
            goto L_0x02bf
        L_0x02bd:
            r16 = 2
        L_0x02bf:
            r16 = r2 | r16
            goto L_0x02c6
        L_0x02c2:
            r13 = r66
            r16 = r2
        L_0x02c6:
            r17 = 2097152(0x200000, float:2.938736E-39)
            r17 = r3 & r17
            if (r17 == 0) goto L_0x02d1
            r16 = r16 | 48
            r8 = r68
            goto L_0x02e2
        L_0x02d1:
            r17 = r2 & 112(0x70, float:1.57E-43)
            r8 = r68
            if (r17 != 0) goto L_0x02e2
            boolean r17 = r6.changed((long) r8)
            if (r17 == 0) goto L_0x02de
            goto L_0x02e0
        L_0x02de:
            r19 = 16
        L_0x02e0:
            r16 = r16 | r19
        L_0x02e2:
            r4 = r16
            r16 = 4194304(0x400000, float:5.877472E-39)
            r16 = r3 & r16
            if (r16 == 0) goto L_0x02ed
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x02ff
        L_0x02ed:
            r11 = r2 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x02ff
            r11 = r70
            boolean r16 = r6.changed((long) r11)
            if (r16 == 0) goto L_0x02fa
            goto L_0x02fc
        L_0x02fa:
            r21 = 128(0x80, float:1.794E-43)
        L_0x02fc:
            r4 = r4 | r21
            goto L_0x0301
        L_0x02ff:
            r11 = r70
        L_0x0301:
            r16 = 8388608(0x800000, float:1.17549435E-38)
            r16 = r3 & r16
            if (r16 == 0) goto L_0x030a
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0319
        L_0x030a:
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0319
            boolean r3 = r6.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0315
            goto L_0x0317
        L_0x0315:
            r18 = 1024(0x400, float:1.435E-42)
        L_0x0317:
            r4 = r4 | r18
        L_0x0319:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r5
            r16 = 306783378(0x12492492, float:6.3469493E-28)
            r3 = r3 ^ r16
            if (r3 != 0) goto L_0x0344
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r10
            r16 = 306783378(0x12492492, float:6.3469493E-28)
            r3 = r3 ^ r16
            if (r3 != 0) goto L_0x0344
            r3 = r4 & 5851(0x16db, float:8.199E-42)
            r3 = r3 ^ 1170(0x492, float:1.64E-42)
            if (r3 != 0) goto L_0x0344
            boolean r3 = r6.getSkipping()
            if (r3 != 0) goto L_0x033c
            goto L_0x0344
        L_0x033c:
            r6.skipToGroupEnd()
            r10 = r53
            r1 = r6
            goto L_0x03e7
        L_0x0344:
            if (r0 == 0) goto L_0x034a
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x034c
        L_0x034a:
            r0 = r53
        L_0x034c:
            androidx.compose.material.TextFieldDefaults r3 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r3 = r3.m1164getMinWidthD9Ej5fM()
            androidx.compose.material.TextFieldDefaults r4 = androidx.compose.material.TextFieldDefaults.INSTANCE
            float r4 = r4.m1163getMinHeightD9Ej5fM()
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m476defaultMinSizeVpY3zN4(r1, r3, r4)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.BackgroundKt.m161backgroundbw27NRU(r3, r8, r15)
            androidx.compose.ui.Modifier r4 = m1180drawIndicatorLineH2RKhps(r3, r7, r13)
            androidx.compose.ui.graphics.SolidColor r3 = new androidx.compose.ui.graphics.SolidColor
            r1 = 0
            r3.<init>(r11, r1)
            r13 = r1
            r1 = r3
            androidx.compose.ui.graphics.Brush r1 = (androidx.compose.ui.graphics.Brush) r1
            r15 = r1
            r1 = -819911731(0xffffffffcf2123cd, float:-2.70347802E9)
            r3 = 1
            androidx.compose.material.TextFieldKt$TextFieldLayout$1 r14 = new androidx.compose.material.TextFieldKt$TextFieldLayout$1
            r30 = r14
            r31 = r57
            r32 = r56
            r33 = r58
            r34 = r59
            r35 = r52
            r36 = r60
            r38 = r62
            r40 = r64
            r41 = r10
            r42 = r5
            r30.<init>(r31, r32, r33, r34, r35, r36, r38, r40, r41, r42)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r6, r1, r3, r14)
            r16 = r1
            kotlin.jvm.functions.Function3 r16 = (kotlin.jvm.functions.Function3) r16
            int r1 = r5 >> 3
            r3 = r1 & 14
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            r3 = r5 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            r3 = r5 & r27
            r1 = r1 | r3
            int r3 = r5 >> 6
            r3 = r3 & r28
            r1 = r1 | r3
            int r3 = r5 << 3
            r14 = r3 & r29
            r1 = r1 | r14
            int r14 = androidx.compose.foundation.text.KeyboardActions.$stable
            int r14 = r14 << 21
            r1 = r1 | r14
            r14 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r14
            r1 = r1 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r5
            r1 = r1 | r3
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r5
            r18 = r1 | r3
            r1 = r10 & 14
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            int r3 = r10 << 3
            r3 = r3 & 896(0x380, float:1.256E-42)
            r19 = r1 | r3
            r20 = 2048(0x800, float:2.87E-42)
            r2 = r45
            r3 = r46
            r5 = r47
            r1 = r6
            r6 = r48
            r7 = r51
            r8 = r49
            r9 = r50
            r10 = r52
            r11 = r0
            r12 = r54
            r14 = r55
            r17 = r1
            androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField((androidx.compose.ui.text.input.TextFieldValue) r2, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit>) r3, (androidx.compose.ui.Modifier) r4, (boolean) r5, (boolean) r6, (androidx.compose.ui.text.TextStyle) r7, (androidx.compose.foundation.text.KeyboardOptions) r8, (androidx.compose.foundation.text.KeyboardActions) r9, (boolean) r10, (int) r11, (androidx.compose.ui.text.input.VisualTransformation) r12, (kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit>) r13, (androidx.compose.foundation.interaction.MutableInteractionSource) r14, (androidx.compose.ui.graphics.Brush) r15, (kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r16, (androidx.compose.runtime.Composer) r17, (int) r18, (int) r19, (int) r20)
            r10 = r0
        L_0x03e7:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 != 0) goto L_0x03ee
            goto L_0x0436
        L_0x03ee:
            androidx.compose.material.TextFieldKt$TextFieldLayout$2 r34 = new androidx.compose.material.TextFieldKt$TextFieldLayout$2
            r0 = r34
            r1 = r44
            r2 = r45
            r3 = r46
            r4 = r47
            r5 = r48
            r6 = r49
            r7 = r50
            r8 = r51
            r9 = r52
            r11 = r54
            r12 = r55
            r13 = r56
            r14 = r57
            r43 = r15
            r15 = r58
            r16 = r59
            r17 = r60
            r19 = r62
            r21 = r64
            r22 = r65
            r23 = r66
            r25 = r68
            r27 = r70
            r29 = r72
            r30 = r74
            r31 = r75
            r32 = r76
            r33 = r77
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r21, r22, r23, r25, r27, r29, r30, r31, r32, r33)
            r0 = r34
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r43
            r1.updateScope(r0)
        L_0x0436:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.m1173TextFieldLayoutuBqXD2s(androidx.compose.ui.Modifier, androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, boolean, boolean, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.ui.text.TextStyle, boolean, int, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, long, long, float, float, long, long, long, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: IconsWithTextFieldLayout-SxpAMN0  reason: not valid java name */
    public static final void m1170IconsWithTextFieldLayoutSxpAMN0(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z, long j, long j2, float f, Composer composer, int i) {
        int i2;
        Composer composer2;
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        int i4;
        String str5;
        String str6;
        String str7;
        String str8;
        float f2;
        String str9;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function32 = function3;
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        boolean z2 = z;
        float f3 = f;
        int i5 = i;
        Composer startRestartGroup = composer.startRestartGroup(178502533);
        ComposerKt.sourceInformation(startRestartGroup, "C(IconsWithTextFieldLayout)P(6,1,4,2,7,5,3:c#ui.graphics.Color,8:c#ui.graphics.Color)399@18807L109,402@18921L1634:TextField.kt#jmzs0o");
        if ((i5 & 14) == 0) {
            i2 = (startRestartGroup.changed((Object) function25) ? 4 : 2) | i5;
        } else {
            i2 = i5;
        }
        if ((i5 & 112) == 0) {
            i2 |= startRestartGroup.changed((Object) function26) ? 32 : 16;
        }
        if ((i5 & 896) == 0) {
            i2 |= startRestartGroup.changed((Object) function32) ? 256 : 128;
        }
        if ((i5 & 7168) == 0) {
            i2 |= startRestartGroup.changed((Object) function27) ? 2048 : 1024;
        }
        if ((57344 & i5) == 0) {
            i2 |= startRestartGroup.changed((Object) function28) ? 16384 : 8192;
        }
        if ((458752 & i5) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 131072 : 65536;
        }
        long j3 = j;
        if ((3670016 & i5) == 0) {
            i2 |= startRestartGroup.changed(j3) ? 1048576 : 524288;
        }
        long j4 = j2;
        if ((29360128 & i5) == 0) {
            i2 |= startRestartGroup.changed(j4) ? 8388608 : 4194304;
        }
        if ((234881024 & i5) == 0) {
            i2 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
        }
        int i6 = i2;
        if (((191739611 & i6) ^ 38347922) != 0 || !startRestartGroup.getSkipping()) {
            Boolean valueOf = Boolean.valueOf(z);
            Float valueOf2 = Float.valueOf(f);
            int i7 = i6 >> 21;
            startRestartGroup.startReplaceableGroup(-3686552);
            ComposerKt.sourceInformation(startRestartGroup, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean changed = startRestartGroup.changed((Object) valueOf) | startRestartGroup.changed((Object) valueOf2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TextFieldMeasurePolicy(z2, f3);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) rememberedValue;
            startRestartGroup.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(Modifier.Companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r7 = Updater.m1234constructorimpl(startRestartGroup);
            Updater.m1241setimpl(r7, textFieldMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r7, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r7, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r7, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-804089035);
            ComposerKt.sourceInformation(startRestartGroup, "C438@20317L183:TextField.kt#jmzs0o");
            startRestartGroup.startReplaceableGroup(-804089035);
            ComposerKt.sourceInformation(startRestartGroup, "405@19000L338");
            if (function27 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.Companion.getCenter();
                startRestartGroup.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(startRestartGroup, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(1376089394);
                ComposerKt.sourceInformation(startRestartGroup, "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density2 = (Density) consume4;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                LayoutDirection layoutDirection2 = (LayoutDirection) consume5;
                String str10 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(then);
                String str11 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo";
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r72 = Updater.m1234constructorimpl(startRestartGroup);
                Updater.m1241setimpl(r72, rememberBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1241setimpl(r72, density2, ComposeUiNode.Companion.getSetDensity());
                Updater.m1241setimpl(r72, layoutDirection2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1241setimpl(r72, viewConfiguration2, ComposeUiNode.Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-1253629305);
                ComposerKt.sourceInformation(startRestartGroup, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-447676355);
                ComposerKt.sourceInformation(startRestartGroup, "C409@19192L128:TextField.kt#jmzs0o");
                str4 = str10;
                i4 = -1990474327;
                i3 = i6;
                str3 = str11;
                str2 = "C:CompositionLocal.kt#9igjgp";
                str = "C72@3384L9:Box.kt#2w3rfo";
                composer2 = startRestartGroup;
                TextFieldImplKt.m1167DecorationeuL9pac(j, (TextStyle) null, (Float) null, function23, startRestartGroup, ((i6 >> 18) & 14) | (i6 & 7168), 6);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            } else {
                str4 = "C(Layout)P(!1,2)72@2847L7,73@2902L7,74@2961L7,75@2973L460:Layout.kt#80mrfh";
                i3 = i6;
                str3 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo";
                str2 = "C:CompositionLocal.kt#9igjgp";
                str = "C72@3384L9:Box.kt#2w3rfo";
                composer2 = startRestartGroup;
                i4 = -1990474327;
            }
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(-804088631);
            ComposerKt.sourceInformation(composer2, "416@19405L341");
            if (function28 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.Companion.getCenter();
                composer2.startReplaceableGroup(i4);
                str6 = str3;
                ComposerKt.sourceInformation(composer2, str6);
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composer2, 6);
                composer2.startReplaceableGroup(1376089394);
                String str12 = str4;
                ComposerKt.sourceInformation(composer2, str12);
                String str13 = str2;
                ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str13);
                Object consume7 = composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Density density3 = (Density) consume7;
                ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str13);
                Object consume8 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LayoutDirection layoutDirection3 = (LayoutDirection) consume8;
                ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str13);
                Object consume9 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(then2);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor3);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer r0 = Updater.m1234constructorimpl(composer2);
                Updater.m1241setimpl(r0, rememberBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1241setimpl(r0, density3, ComposeUiNode.Companion.getSetDensity());
                Updater.m1241setimpl(r0, layoutDirection3, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1241setimpl(r0, viewConfiguration3, ComposeUiNode.Companion.getSetViewConfiguration());
                composer2.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-1253629305);
                String str14 = str;
                ComposerKt.sourceInformation(composer2, str14);
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(-447675949);
                ComposerKt.sourceInformation(composer2, "C420@19598L130:TextField.kt#jmzs0o");
                str5 = str14;
                str8 = str13;
                str7 = str12;
                TextFieldImplKt.m1167DecorationeuL9pac(j2, (TextStyle) null, (Float) null, function24, composer2, (i7 & 14) | ((i3 >> 3) & 7168), 6);
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            } else {
                str7 = str4;
                str6 = str3;
                str8 = str2;
                str5 = str;
            }
            composer2.endReplaceableGroup();
            float r4 = Dp.m3859constructorimpl(TextFieldImplKt.getTextFieldPadding() - TextFieldImplKt.getHorizontalIconPadding());
            Modifier modifier = Modifier.Companion;
            if (function27 != null) {
                f2 = r4;
            } else {
                f2 = TextFieldImplKt.getTextFieldPadding();
            }
            if (function28 == null) {
                r4 = TextFieldImplKt.getTextFieldPadding();
            }
            Modifier r42 = PaddingKt.m435paddingqDBjuR0$default(modifier, f2, 0.0f, r4, 0.0f, 10, (Object) null);
            composer2.startReplaceableGroup(-804087929);
            ComposerKt.sourceInformation(composer2, "433@20110L59");
            if (function32 != null) {
                function32.invoke(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.PlaceholderId).then(r42), composer2, Integer.valueOf((i3 >> 3) & 112));
            }
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(-804087800);
            ComposerKt.sourceInformation(composer2, "436@20233L57");
            if (function26 != null) {
                Modifier then3 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LabelId).then(r42);
                composer2.startReplaceableGroup(-1990474327);
                ComposerKt.sourceInformation(composer2, str6);
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                composer2.startReplaceableGroup(1376089394);
                ComposerKt.sourceInformation(composer2, str7);
                ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str8);
                Object consume10 = composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Density density4 = (Density) consume10;
                ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str8);
                Object consume11 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                LayoutDirection layoutDirection4 = (LayoutDirection) consume11;
                ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str8);
                Object consume12 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) consume12;
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(then3);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer r10 = Updater.m1234constructorimpl(composer2);
                Updater.m1241setimpl(r10, rememberBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m1241setimpl(r10, density4, ComposeUiNode.Companion.getSetDensity());
                Updater.m1241setimpl(r10, layoutDirection4, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m1241setimpl(r10, viewConfiguration4, ComposeUiNode.Companion.getSetViewConfiguration());
                composer2.enableReusing();
                materializerOf4.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-1253629305);
                str9 = str5;
                ComposerKt.sourceInformation(composer2, str9);
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(-447675266);
                ComposerKt.sourceInformation(composer2, "C436@20281L7:TextField.kt#jmzs0o");
                function26.invoke(composer2, Integer.valueOf((i3 >> 3) & 14));
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
            } else {
                str9 = str5;
            }
            composer2.endReplaceableGroup();
            Modifier then4 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TextFieldId).then(r42);
            composer2.startReplaceableGroup(-1990474327);
            ComposerKt.sourceInformation(composer2, str6);
            MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composer2, 48);
            composer2.startReplaceableGroup(1376089394);
            ComposerKt.sourceInformation(composer2, str7);
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str8);
            Object consume13 = composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Density density5 = (Density) consume13;
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str8);
            Object consume14 = composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            LayoutDirection layoutDirection5 = (LayoutDirection) consume14;
            ComposerKt.sourceInformationMarkerStart(composer2, 103361330, str8);
            Object consume15 = composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ViewConfiguration viewConfiguration5 = (ViewConfiguration) consume15;
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf5 = LayoutKt.materializerOf(then4);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor5);
            } else {
                composer2.useNode();
            }
            composer2.disableReusing();
            Composer r73 = Updater.m1234constructorimpl(composer2);
            Updater.m1241setimpl(r73, rememberBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m1241setimpl(r73, density5, ComposeUiNode.Companion.getSetDensity());
            Updater.m1241setimpl(r73, layoutDirection5, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m1241setimpl(r73, viewConfiguration5, ComposeUiNode.Companion.getSetViewConfiguration());
            composer2.enableReusing();
            materializerOf5.invoke(SkippableUpdater.m1225boximpl(SkippableUpdater.m1226constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            composer2.startReplaceableGroup(-1253629305);
            ComposerKt.sourceInformation(composer2, str9);
            BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
            composer2.startReplaceableGroup(-447675072);
            ComposerKt.sourceInformation(composer2, "C442@20475L11:TextField.kt#jmzs0o");
            function2.invoke(composer2, Integer.valueOf(i3 & 14));
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldKt$IconsWithTextFieldLayout$2(function2, function22, function3, function23, function24, z, j, j2, f, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek  reason: not valid java name */
    public static final int m1179calculateWidthVsPV1Ek(int i, int i2, int i3, int i4, int i5, long j) {
        return Math.max(i + Math.max(i3, Math.max(i4, i5)) + i2, Constraints.m3805getMinWidthimpl(j));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-YbqEFUw  reason: not valid java name */
    public static final int m1178calculateHeightYbqEFUw(int i, boolean z, int i2, int i3, int i4, int i5, long j, float f) {
        float f2 = LastBaselineOffset * f;
        float f3 = TextFieldTopPadding * f;
        float textFieldPadding = TextFieldImplKt.getTextFieldPadding() * f;
        int max = Math.max(i, i5);
        return Math.max(MathKt.roundToInt(z ? ((float) i2) + f3 + ((float) max) + f2 : (textFieldPadding * ((float) 2)) + ((float) max)), Math.max(Math.max(i3, i4), Constraints.m3804getMinHeightimpl(j)));
    }

    /* access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z, int i3, int i4, float f, float f2) {
        int i5 = i2;
        int roundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2);
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i5), 0.0f, 4, (Object) null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), i5), 0.0f, 4, (Object) null);
        }
        if (placeable2 != null) {
            if (z) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i5);
            }
            Placeable.PlacementScope placementScope2 = placementScope;
            Placeable placeable6 = placeable2;
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable6, TextFieldImplKt.widthOrZero(placeable4), roundToInt - MathKt.roundToInt(((float) (roundToInt - i3)) * f), 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, (Object) null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, boolean z, float f) {
        int i3 = i2;
        int roundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), i3), 0.0f, 4, (Object) null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i3), 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable3), z ? Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i3) : roundToInt, 0.0f, 4, (Object) null);
        if (placeable2 != null) {
            if (z) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i3);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable3), roundToInt, 0.0f, 4, (Object) null);
        }
    }

    /* renamed from: drawIndicatorLine-H2RKhps  reason: not valid java name */
    public static final Modifier m1180drawIndicatorLineH2RKhps(Modifier modifier, float f, long j) {
        Intrinsics.checkNotNullParameter(modifier, "$this$drawIndicatorLine");
        return DrawModifierKt.drawBehind(modifier, new TextFieldKt$drawIndicatorLine$1(f, j));
    }

    /* access modifiers changed from: private */
    /* renamed from: TextField$lambda-3  reason: not valid java name */
    public static final void m1172TextField$lambda3(MutableState<TextFieldValue> mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }
}
