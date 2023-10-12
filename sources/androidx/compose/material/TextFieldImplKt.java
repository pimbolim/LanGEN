package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\"0*¢\u0006\u0002\b+H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001añ\u0001\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\"072\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020&2\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010*¢\u0006\u0002\b+2\u0013\u0010<\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010*¢\u0006\u0002\b+2\u0013\u0010=\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010*¢\u0006\u0002\b+2\u0013\u0010>\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010*¢\u0006\u0002\b+2\u0006\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020\u00012\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0001¢\u0006\u0002\u0010M\u001a\u0012\u0010N\u001a\u00020\u00012\b\u0010O\u001a\u0004\u0018\u00010PH\u0000\u001a\u0012\u0010Q\u001a\u00020\u00012\b\u0010O\u001a\u0004\u0018\u00010PH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u0013\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0014\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0015\u0010\u0005\"\u000e\u0010\u0016\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0017\u001a\u00020\u0018X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a\"\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u001e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006R"}, d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "IndicatorFocusedWidth", "IndicatorUnfocusedWidth", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "Decoration", "", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextFieldImpl", "type", "Landroidx/compose/material/TextFieldType;", "enabled", "", "readOnly", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "singleLine", "textStyle", "label", "placeholder", "leading", "trailing", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "maxLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/material/TextFieldType;ZZLandroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    private static final float HorizontalIconPadding = Dp.m3859constructorimpl((float) 12);
    private static final Modifier IconDefaultSizeModifier;
    /* access modifiers changed from: private */
    public static final float IndicatorFocusedWidth = Dp.m3859constructorimpl((float) 2);
    /* access modifiers changed from: private */
    public static final float IndicatorUnfocusedWidth = Dp.m3859constructorimpl((float) 1);
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding = Dp.m3859constructorimpl((float) 16);
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x03c9  */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x03cd  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x044b  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x046e  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x04a3  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x04c8  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0533  */
    /* JADX WARNING: Removed duplicated region for block: B:281:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x016b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextFieldImpl(androidx.compose.material.TextFieldType r59, boolean r60, boolean r61, androidx.compose.ui.text.input.TextFieldValue r62, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r63, androidx.compose.ui.Modifier r64, boolean r65, androidx.compose.ui.text.TextStyle r66, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r67, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, boolean r71, androidx.compose.ui.text.input.VisualTransformation r72, androidx.compose.foundation.text.KeyboardOptions r73, androidx.compose.foundation.text.KeyboardActions r74, int r75, androidx.compose.foundation.interaction.MutableInteractionSource r76, androidx.compose.ui.graphics.Shape r77, androidx.compose.material.TextFieldColors r78, androidx.compose.runtime.Composer r79, int r80, int r81, int r82) {
        /*
            r15 = r59
            r14 = r60
            r13 = r62
            r12 = r63
            r11 = r64
            r10 = r66
            r9 = r67
            r8 = r72
            r7 = r74
            r6 = r76
            r5 = r77
            r4 = r78
            r3 = r80
            r2 = r81
            r1 = r82
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "textStyle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "keyboardActions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "shape"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 571807088(0x22151570, float:2.0204614E-18)
            r4 = r79
            androidx.compose.runtime.Composer r4 = r4.startRestartGroup(r0)
            java.lang.String r0 = "C(TextFieldImpl)P(17,1,12,18,10,9,14,15,6,11,7,16,3,19,5,4,8,2,13)91@3545L25,92@3603L120,111@4307L10,*123@4929L10,124@5023L22,118@4642L5425:TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            r0 = r1 & 1
            r16 = 4
            r17 = 2
            if (r0 == 0) goto L_0x006e
            r0 = r3 | 6
            goto L_0x007e
        L_0x006e:
            r0 = r3 & 14
            if (r0 != 0) goto L_0x007d
            boolean r0 = r4.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x007a
            r0 = 4
            goto L_0x007b
        L_0x007a:
            r0 = 2
        L_0x007b:
            r0 = r0 | r3
            goto L_0x007e
        L_0x007d:
            r0 = r3
        L_0x007e:
            r18 = r1 & 2
            r19 = 32
            r20 = 16
            if (r18 == 0) goto L_0x0089
            r0 = r0 | 48
            goto L_0x009a
        L_0x0089:
            r18 = r3 & 112(0x70, float:1.57E-43)
            if (r18 != 0) goto L_0x009a
            boolean r18 = r4.changed((boolean) r14)
            if (r18 == 0) goto L_0x0096
            r18 = 32
            goto L_0x0098
        L_0x0096:
            r18 = 16
        L_0x0098:
            r0 = r0 | r18
        L_0x009a:
            r18 = r1 & 4
            r21 = 256(0x100, float:3.59E-43)
            r22 = 128(0x80, float:1.794E-43)
            if (r18 == 0) goto L_0x00a5
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x00b9
        L_0x00a5:
            r15 = r3 & 896(0x380, float:1.256E-42)
            if (r15 != 0) goto L_0x00b9
            r15 = r61
            boolean r18 = r4.changed((boolean) r15)
            if (r18 == 0) goto L_0x00b4
            r18 = 256(0x100, float:3.59E-43)
            goto L_0x00b6
        L_0x00b4:
            r18 = 128(0x80, float:1.794E-43)
        L_0x00b6:
            r0 = r0 | r18
            goto L_0x00bb
        L_0x00b9:
            r15 = r61
        L_0x00bb:
            r18 = r1 & 8
            r23 = 2048(0x800, float:2.87E-42)
            r24 = 1024(0x400, float:1.435E-42)
            if (r18 == 0) goto L_0x00c6
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x00d6
        L_0x00c6:
            r15 = r3 & 7168(0x1c00, float:1.0045E-41)
            if (r15 != 0) goto L_0x00d6
            boolean r15 = r4.changed((java.lang.Object) r13)
            if (r15 == 0) goto L_0x00d3
            r15 = 2048(0x800, float:2.87E-42)
            goto L_0x00d5
        L_0x00d3:
            r15 = 1024(0x400, float:1.435E-42)
        L_0x00d5:
            r0 = r0 | r15
        L_0x00d6:
            r15 = r1 & 16
            r18 = 8192(0x2000, float:1.14794E-41)
            r25 = 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x00e1
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00f3
        L_0x00e1:
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r3
            if (r15 != 0) goto L_0x00f3
            boolean r15 = r4.changed((java.lang.Object) r12)
            if (r15 == 0) goto L_0x00f0
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00f2
        L_0x00f0:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00f2:
            r0 = r0 | r15
        L_0x00f3:
            r15 = r1 & 32
            r26 = 131072(0x20000, float:1.83671E-40)
            r27 = 65536(0x10000, float:9.18355E-41)
            if (r15 == 0) goto L_0x00ff
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00fd:
            r0 = r0 | r15
            goto L_0x0110
        L_0x00ff:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r3
            if (r15 != 0) goto L_0x0110
            boolean r15 = r4.changed((java.lang.Object) r11)
            if (r15 == 0) goto L_0x010d
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00fd
        L_0x010d:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00fd
        L_0x0110:
            r15 = r1 & 64
            r28 = 524288(0x80000, float:7.34684E-40)
            if (r15 == 0) goto L_0x011a
            r15 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r15
            goto L_0x012f
        L_0x011a:
            r15 = 3670016(0x380000, float:5.142788E-39)
            r15 = r15 & r3
            if (r15 != 0) goto L_0x012f
            r15 = r65
            boolean r29 = r4.changed((boolean) r15)
            if (r29 == 0) goto L_0x012a
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x012c
        L_0x012a:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x012c:
            r0 = r0 | r29
            goto L_0x0131
        L_0x012f:
            r15 = r65
        L_0x0131:
            r11 = r1 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0139
            r11 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x0137:
            r0 = r0 | r11
            goto L_0x014a
        L_0x0139:
            r11 = 29360128(0x1c00000, float:7.052966E-38)
            r11 = r11 & r3
            if (r11 != 0) goto L_0x014a
            boolean r11 = r4.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x0147
            r11 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0137
        L_0x0147:
            r11 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0137
        L_0x014a:
            r11 = r1 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0152
            r11 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0150:
            r0 = r0 | r11
            goto L_0x0163
        L_0x0152:
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r3
            if (r11 != 0) goto L_0x0163
            boolean r11 = r4.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x0160
            r11 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0150
        L_0x0160:
            r11 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0150
        L_0x0163:
            r11 = r1 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x016b
            r11 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r11
            goto L_0x0180
        L_0x016b:
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r11 = r11 & r3
            if (r11 != 0) goto L_0x0180
            r11 = r68
            boolean r29 = r4.changed((java.lang.Object) r11)
            if (r29 == 0) goto L_0x017b
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x017d
        L_0x017b:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x017d:
            r0 = r0 | r29
            goto L_0x0182
        L_0x0180:
            r11 = r68
        L_0x0182:
            r29 = r0
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x018f
            r0 = r2 | 6
            r16 = r0
            r0 = r69
            goto L_0x01a5
        L_0x018f:
            r0 = r2 & 14
            if (r0 != 0) goto L_0x01a1
            r0 = r69
            boolean r30 = r4.changed((java.lang.Object) r0)
            if (r30 == 0) goto L_0x019c
            goto L_0x019e
        L_0x019c:
            r16 = 2
        L_0x019e:
            r16 = r2 | r16
            goto L_0x01a5
        L_0x01a1:
            r0 = r69
            r16 = r2
        L_0x01a5:
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01ac
            r16 = r16 | 48
            goto L_0x01c0
        L_0x01ac:
            r0 = r2 & 112(0x70, float:1.57E-43)
            if (r0 != 0) goto L_0x01be
            r0 = r70
            boolean r17 = r4.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x01b9
            goto L_0x01bb
        L_0x01b9:
            r19 = 16
        L_0x01bb:
            r16 = r16 | r19
            goto L_0x01c0
        L_0x01be:
            r0 = r70
        L_0x01c0:
            r0 = r16
            r11 = r1 & 4096(0x1000, float:5.74E-42)
            if (r11 == 0) goto L_0x01c9
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x01db
        L_0x01c9:
            r11 = r2 & 896(0x380, float:1.256E-42)
            if (r11 != 0) goto L_0x01db
            r11 = r71
            boolean r16 = r4.changed((boolean) r11)
            if (r16 == 0) goto L_0x01d6
            goto L_0x01d8
        L_0x01d6:
            r21 = 128(0x80, float:1.794E-43)
        L_0x01d8:
            r0 = r0 | r21
            goto L_0x01dd
        L_0x01db:
            r11 = r71
        L_0x01dd:
            r11 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x01e4
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x01f3
        L_0x01e4:
            r11 = r2 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x01f3
            boolean r11 = r4.changed((java.lang.Object) r8)
            if (r11 == 0) goto L_0x01ef
            goto L_0x01f1
        L_0x01ef:
            r23 = 1024(0x400, float:1.435E-42)
        L_0x01f1:
            r0 = r0 | r23
        L_0x01f3:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r2
            if (r11 != 0) goto L_0x020d
            r11 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r11 != 0) goto L_0x0208
            r11 = r73
            boolean r16 = r4.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x020a
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x020a
        L_0x0208:
            r11 = r73
        L_0x020a:
            r0 = r0 | r18
            goto L_0x020f
        L_0x020d:
            r11 = r73
        L_0x020f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r1 & r16
            if (r16 == 0) goto L_0x021b
            r16 = 196608(0x30000, float:2.75506E-40)
        L_0x0218:
            r0 = r0 | r16
            goto L_0x022d
        L_0x021b:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r2 & r16
            if (r16 != 0) goto L_0x022d
            boolean r16 = r4.changed((java.lang.Object) r7)
            if (r16 == 0) goto L_0x022a
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0218
        L_0x022a:
            r16 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0218
        L_0x022d:
            r16 = r1 & r27
            if (r16 == 0) goto L_0x0238
            r17 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r17
            r7 = r75
            goto L_0x024d
        L_0x0238:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r2 & r17
            r7 = r75
            if (r17 != 0) goto L_0x024d
            boolean r17 = r4.changed((int) r7)
            if (r17 == 0) goto L_0x0249
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x024b
        L_0x0249:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x024b:
            r0 = r0 | r17
        L_0x024d:
            r17 = r1 & r26
            if (r17 == 0) goto L_0x0256
            r17 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x0253:
            r0 = r0 | r17
            goto L_0x0268
        L_0x0256:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r2 & r17
            if (r17 != 0) goto L_0x0268
            boolean r17 = r4.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x0265
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0253
        L_0x0265:
            r17 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0253
        L_0x0268:
            r17 = 262144(0x40000, float:3.67342E-40)
            r17 = r1 & r17
            if (r17 == 0) goto L_0x0273
            r17 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0270:
            r0 = r0 | r17
            goto L_0x0285
        L_0x0273:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r2 & r17
            if (r17 != 0) goto L_0x0285
            boolean r17 = r4.changed((java.lang.Object) r5)
            if (r17 == 0) goto L_0x0282
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0270
        L_0x0282:
            r17 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0270
        L_0x0285:
            r17 = r1 & r28
            if (r17 == 0) goto L_0x0290
            r17 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r17
            r5 = r78
            goto L_0x02a5
        L_0x0290:
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r2 & r17
            r5 = r78
            if (r17 != 0) goto L_0x02a5
            boolean r17 = r4.changed((java.lang.Object) r5)
            if (r17 == 0) goto L_0x02a1
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x02a3
        L_0x02a1:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x02a3:
            r0 = r0 | r17
        L_0x02a5:
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r17 = r29 & r17
            r18 = 306783378(0x12492492, float:6.3469493E-28)
            r17 = r17 ^ r18
            if (r17 != 0) goto L_0x02cd
            r17 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r17 = r0 & r17
            r18 = 306783378(0x12492492, float:6.3469493E-28)
            r17 = r17 ^ r18
            if (r17 != 0) goto L_0x02cd
            boolean r17 = r4.getSkipping()
            if (r17 != 0) goto L_0x02c4
            goto L_0x02cd
        L_0x02c4:
            r4.skipToGroupEnd()
            r0 = r4
            r17 = r7
            r15 = r11
            goto L_0x052c
        L_0x02cd:
            r4.startDefaults()
            r17 = r3 & 1
            if (r17 == 0) goto L_0x02e7
            boolean r17 = r4.getDefaultsInvalid()
            if (r17 == 0) goto L_0x02db
            goto L_0x02e7
        L_0x02db:
            r4.skipToGroupEnd()
            r2 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0302
            r2 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = r0 & r2
            goto L_0x0302
        L_0x02e7:
            r2 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x02f6
            androidx.compose.foundation.text.KeyboardOptions$Companion r2 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r2 = r2.getDefault()
            r11 = -57345(0xffffffffffff1fff, float:NaN)
            r0 = r0 & r11
            r11 = r2
        L_0x02f6:
            if (r16 == 0) goto L_0x0302
            r2 = 2147483647(0x7fffffff, float:NaN)
            r7 = r0
            r25 = r11
            r26 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0307
        L_0x0302:
            r26 = r7
            r25 = r11
            r7 = r0
        L_0x0307:
            r4.endDefaults()
            r0 = 571807912(0x221518a8, float:2.0206318E-18)
            r4.startReplaceableGroup(r0)
            java.lang.String r0 = "*87@3403L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            long r16 = r66.m3583getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.ui.graphics.Color.Companion
            long r18 = r0.m1632getUnspecified0d7_KjU()
            int r0 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0325
            r0 = 1
            goto L_0x0326
        L_0x0325:
            r0 = 0
        L_0x0326:
            if (r0 == 0) goto L_0x0329
            goto L_0x0341
        L_0x0329:
            int r0 = r29 >> 3
            r0 = r0 & 14
            int r16 = r7 >> 24
            r16 = r16 & 112(0x70, float:1.57E-43)
            r0 = r0 | r16
            androidx.compose.runtime.State r0 = r5.textColor(r14, r4, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r16 = r0.m1606unboximpl()
        L_0x0341:
            r31 = r16
            r4.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r0 = new androidx.compose.ui.text.TextStyle
            r30 = r0
            r33 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r53 = 0
            r54 = 262142(0x3fffe, float:3.67339E-40)
            r55 = 0
            r30.<init>(r31, r33, r35, r36, r37, r38, r39, r40, r42, r43, r44, r45, r47, r48, r49, r50, r51, r53, r54, r55)
            androidx.compose.ui.text.TextStyle r17 = r10.merge((androidx.compose.ui.text.TextStyle) r0)
            r0 = r6
            androidx.compose.foundation.interaction.InteractionSource r0 = (androidx.compose.foundation.interaction.InteractionSource) r0
            int r16 = r7 >> 21
            r2 = r16 & 14
            androidx.compose.runtime.State r0 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r0, r4, r2)
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            androidx.compose.ui.text.AnnotatedString r2 = r62.getAnnotatedString()
            r11 = -3686552(0xffffffffffc7bf68, float:NaN)
            r4.startReplaceableGroup(r11)
            java.lang.String r11 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r11)
            boolean r2 = r4.changed((java.lang.Object) r2)
            boolean r11 = r4.changed((java.lang.Object) r8)
            r2 = r2 | r11
            java.lang.Object r11 = r4.rememberedValue()
            if (r2 != 0) goto L_0x03b3
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r11 != r2) goto L_0x03be
        L_0x03b3:
            androidx.compose.ui.text.AnnotatedString r2 = r62.getAnnotatedString()
            androidx.compose.ui.text.input.TransformedText r11 = r8.filter(r2)
            r4.updateRememberedValue(r11)
        L_0x03be:
            r4.endReplaceableGroup()
            androidx.compose.ui.text.input.TransformedText r11 = (androidx.compose.ui.text.input.TransformedText) r11
            androidx.compose.ui.text.AnnotatedString r11 = r11.getText()
            if (r0 == 0) goto L_0x03cd
            androidx.compose.material.InputPhase r0 = androidx.compose.material.InputPhase.Focused
        L_0x03cb:
            r2 = r0
            goto L_0x03e1
        L_0x03cd:
            r0 = r11
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x03d8
            r0 = 1
            goto L_0x03d9
        L_0x03d8:
            r0 = 0
        L_0x03d9:
            if (r0 == 0) goto L_0x03de
            androidx.compose.material.InputPhase r0 = androidx.compose.material.InputPhase.UnfocusedEmpty
            goto L_0x03cb
        L_0x03de:
            androidx.compose.material.InputPhase r0 = androidx.compose.material.InputPhase.UnfocusedNotEmpty
            goto L_0x03cb
        L_0x03e1:
            androidx.compose.material.TextFieldImplKt$TextFieldImpl$labelColor$1 r16 = new androidx.compose.material.TextFieldImplKt$TextFieldImpl$labelColor$1
            r0 = r16
            r1 = r78
            r15 = r2
            r2 = r60
            r3 = r71
            r5 = r4
            r4 = r76
            r14 = r5
            r5 = r29
            r6 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r6 = r16
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material.Typography r0 = r0.getTypography(r14, r1)
            androidx.compose.ui.text.TextStyle r2 = r0.getSubtitle1()
            androidx.compose.ui.text.TextStyle r0 = r0.getCaption()
            long r3 = r2.m3583getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.Companion
            r79 = r2
            long r1 = r5.m1632getUnspecified0d7_KjU()
            boolean r1 = androidx.compose.ui.graphics.Color.m1597equalsimpl0(r3, r1)
            if (r1 == 0) goto L_0x042b
            long r1 = r0.m3583getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r3 = r3.m1632getUnspecified0d7_KjU()
            boolean r1 = androidx.compose.ui.graphics.Color.m1597equalsimpl0(r1, r3)
            if (r1 == 0) goto L_0x044b
        L_0x042b:
            long r1 = r79.m3583getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r3 = r3.m1632getUnspecified0d7_KjU()
            boolean r1 = androidx.compose.ui.graphics.Color.m1597equalsimpl0(r1, r3)
            if (r1 != 0) goto L_0x044e
            long r0 = r0.m3583getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r2 = r2.m1632getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m1597equalsimpl0(r0, r2)
            if (r0 == 0) goto L_0x044e
        L_0x044b:
            r24 = 1
            goto L_0x0450
        L_0x044e:
            r24 = 0
        L_0x0450:
            androidx.compose.material.TextFieldTransitionScope r27 = androidx.compose.material.TextFieldTransitionScope.INSTANCE
            r0 = 571809256(0x22151de8, float:2.0209098E-18)
            r14.startReplaceableGroup(r0)
            java.lang.String r0 = "*120@4738L10,121@4830L22"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material.Typography r0 = r0.getTypography(r14, r1)
            androidx.compose.ui.text.TextStyle r0 = r0.getCaption()
            long r0 = r0.m3583getColor0d7_KjU()
            if (r24 == 0) goto L_0x048d
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r2 = r2.m1632getUnspecified0d7_KjU()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x047a
            r2 = 1
            goto L_0x047b
        L_0x047a:
            r2 = 0
        L_0x047b:
            if (r2 == 0) goto L_0x047e
            goto L_0x048d
        L_0x047e:
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Object r0 = r6.invoke(r15, r14, r1)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r0 = r0.m1606unboximpl()
        L_0x048d:
            r30 = r0
            r14.endReplaceableGroup()
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material.Typography r0 = r0.getTypography(r14, r1)
            androidx.compose.ui.text.TextStyle r0 = r0.getSubtitle1()
            long r0 = r0.m3583getColor0d7_KjU()
            if (r24 == 0) goto L_0x04c3
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r2 = r2.m1632getUnspecified0d7_KjU()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x04af
            r2 = 1
            goto L_0x04b0
        L_0x04af:
            r2 = 0
        L_0x04b0:
            if (r2 == 0) goto L_0x04b3
            goto L_0x04c3
        L_0x04b3:
            r2 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r6.invoke(r15, r14, r0)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r0 = r0.m1606unboximpl()
            goto L_0x04c4
        L_0x04c3:
            r2 = 0
        L_0x04c4:
            r32 = r0
            if (r9 == 0) goto L_0x04cb
            r28 = 1
            goto L_0x04cd
        L_0x04cb:
            r28 = 0
        L_0x04cd:
            r5 = -819891562(0xffffffffcf217296, float:-2.70864128E9)
            androidx.compose.material.TextFieldImplKt$TextFieldImpl$3 r4 = new androidx.compose.material.TextFieldImplKt$TextFieldImpl$3
            r0 = r4
            r1 = r67
            r2 = r68
            r3 = r11
            r11 = r4
            r4 = r64
            r5 = r71
            r34 = r6
            r6 = r7
            r7 = r78
            r8 = r60
            r9 = r76
            r10 = r29
            r56 = r11
            r11 = r59
            r12 = r62
            r13 = r63
            r57 = r14
            r14 = r61
            r29 = r15
            r15 = r25
            r16 = r74
            r18 = r65
            r19 = r26
            r20 = r72
            r21 = r69
            r22 = r70
            r23 = r77
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r2 = r56
            r0 = r57
            r1 = -819891562(0xffffffffcf217296, float:-2.70864128E9)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r1, r3, r2)
            r9 = r1
            kotlin.jvm.functions.Function7 r9 = (kotlin.jvm.functions.Function7) r9
            r11 = 1769472(0x1b0000, float:2.479558E-39)
            r1 = r27
            r2 = r29
            r3 = r30
            r5 = r32
            r7 = r34
            r8 = r28
            r10 = r0
            r1.m1187TransitionDTcfvLk(r2, r3, r5, r7, r8, r9, r10, r11)
            r17 = r26
        L_0x052c:
            androidx.compose.runtime.ScopeUpdateScope r14 = r0.endRestartGroup()
            if (r14 != 0) goto L_0x0533
            goto L_0x056f
        L_0x0533:
            androidx.compose.material.TextFieldImplKt$TextFieldImpl$4 r24 = new androidx.compose.material.TextFieldImplKt$TextFieldImpl$4
            r0 = r24
            r1 = r59
            r2 = r60
            r3 = r61
            r4 = r62
            r5 = r63
            r6 = r64
            r7 = r65
            r8 = r66
            r9 = r67
            r10 = r68
            r11 = r69
            r12 = r70
            r13 = r71
            r58 = r14
            r14 = r72
            r16 = r74
            r18 = r76
            r19 = r77
            r20 = r78
            r21 = r80
            r22 = r81
            r23 = r82
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r24
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r58
            r1.updateScope(r0)
        L_0x056f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.TextFieldImpl(androidx.compose.material.TextFieldType, boolean, boolean, androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* renamed from: Decoration-euL9pac  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1167DecorationeuL9pac(long r16, androidx.compose.ui.text.TextStyle r18, java.lang.Float r19, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r6 = r20
            r7 = r22
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r0 = -2009952923(0xffffffff88328d65, float:-5.3731135E-34)
            r1 = r21
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r0 = "C(Decoration)P(2:c#ui.graphics.Color,3,1):TextFieldImpl.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r23 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r7 | 6
            r9 = r16
            goto L_0x0032
        L_0x0020:
            r0 = r7 & 14
            r9 = r16
            if (r0 != 0) goto L_0x0031
            boolean r0 = r8.changed((long) r9)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r7
            goto L_0x0032
        L_0x0031:
            r0 = r7
        L_0x0032:
            r1 = r23 & 2
            if (r1 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x004c
        L_0x0039:
            r2 = r7 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004c
            r2 = r18
            boolean r3 = r8.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r0 = r0 | r3
            goto L_0x004e
        L_0x004c:
            r2 = r18
        L_0x004e:
            r3 = r23 & 4
            if (r3 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r4 = r7 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0068
            r4 = r19
            boolean r5 = r8.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0064
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r5
            goto L_0x006a
        L_0x0068:
            r4 = r19
        L_0x006a:
            r5 = r23 & 8
            if (r5 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x0071:
            r5 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0081
            boolean r5 = r8.changed((java.lang.Object) r6)
            if (r5 == 0) goto L_0x007e
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r0 = r0 | r5
        L_0x0081:
            r11 = r0
            r0 = r11 & 5851(0x16db, float:8.199E-42)
            r0 = r0 ^ 1170(0x492, float:1.64E-42)
            if (r0 != 0) goto L_0x0094
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x008f
            goto L_0x0094
        L_0x008f:
            r8.skipToGroupEnd()
            r3 = r2
            goto L_0x00e4
        L_0x0094:
            r0 = 0
            if (r1 == 0) goto L_0x0099
            r12 = r0
            goto L_0x009a
        L_0x0099:
            r12 = r2
        L_0x009a:
            if (r3 == 0) goto L_0x009e
            r13 = r0
            goto L_0x009f
        L_0x009e:
            r13 = r4
        L_0x009f:
            r14 = -819900927(0xffffffffcf214e01, float:-2.70624384E9)
            androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1 r15 = new androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
            r0 = r15
            r1 = r16
            r3 = r13
            r4 = r20
            r5 = r11
            r0.<init>(r1, r3, r4, r5)
            r0 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r14, r0, r15)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            if (r12 == 0) goto L_0x00cc
            r1 = -2009952190(0xffffffff88329042, float:-5.37345E-34)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "263@10904L46"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            int r1 = r11 >> 3
            r1 = r1 & 14
            r1 = r1 | 48
            androidx.compose.material.TextKt.ProvideTextStyle(r12, r0, r8, r1)
            goto L_0x00df
        L_0x00cc:
            r1 = -2009952138(0xffffffff88329076, float:-5.373474E-34)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "263@10956L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.invoke(r8, r1)
        L_0x00df:
            r8.endReplaceableGroup()
            r3 = r12
            r4 = r13
        L_0x00e4:
            androidx.compose.runtime.ScopeUpdateScope r8 = r8.endRestartGroup()
            if (r8 != 0) goto L_0x00eb
            goto L_0x00fe
        L_0x00eb:
            androidx.compose.material.TextFieldImplKt$Decoration$1 r11 = new androidx.compose.material.TextFieldImplKt$Decoration$1
            r0 = r11
            r1 = r16
            r5 = r20
            r6 = r22
            r7 = r23
            r0.<init>(r1, r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r8.updateScope(r11)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.m1167DecorationeuL9pac(long, androidx.compose.ui.text.TextStyle, java.lang.Float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable == null) {
            return 0;
        }
        return placeable.getWidth();
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable == null) {
            return 0;
        }
        return placeable.getHeight();
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData == null) {
            return null;
        }
        return layoutIdParentData.getLayoutId();
    }

    static {
        float f = (float) 48;
        IconDefaultSizeModifier = SizeKt.m476defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m3859constructorimpl(f), Dp.m3859constructorimpl(f));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
