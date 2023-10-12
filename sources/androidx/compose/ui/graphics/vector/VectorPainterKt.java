package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192;\u0010\u001a\u001a7\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001dH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "rememberVectorPainter", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "image", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "name", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    /* renamed from: rememberVectorPainter-mlNsNFs  reason: not valid java name */
    public static final VectorPainter m2222rememberVectorPaintermlNsNFs(float f, float f2, float f3, float f4, String str, long j, int i, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(function4, "content");
        composer2.startReplaceableGroup(-1998940692);
        ComposerKt.sourceInformation(composer2, "C(rememberVectorPainter)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp,7,6,3,5:c#ui.graphics.Color,4:c#ui.graphics.BlendMode)71@3064L7,84@3614L411:VectorPainter.kt#huu6hf");
        float f5 = Float.NaN;
        float f6 = (i3 & 4) != 0 ? Float.NaN : f3;
        if ((i3 & 8) == 0) {
            f5 = f4;
        }
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long r5 = (i3 & 32) != 0 ? Color.Companion.m1632getUnspecified0d7_KjU() : j;
        int r7 = (i3 & 64) != 0 ? BlendMode.Companion.m1532getSrcIn0nO6VwU() : i;
        ComposerKt.sourceInformationMarkerStart(composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer2.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) consume;
        float f7 = f;
        float r9 = density.m3828toPx0680j_4(f);
        float f8 = f2;
        float r8 = density.m3828toPx0680j_4(f2);
        if (Float.isNaN(f6)) {
            f6 = r9;
        }
        if (Float.isNaN(f5)) {
            f5 = r8;
        }
        composer2.startReplaceableGroup(-1998939971);
        ComposerKt.sourceInformation(composer2, "*78@3354L28,82@3557L46");
        composer2.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer2, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new VectorPainter();
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        VectorPainter vectorPainter = (VectorPainter) rememberedValue;
        vectorPainter.m2221setSizeuvyYCjk$ui_release(SizeKt.Size(r9, r8));
        int i4 = i2 >> 12;
        vectorPainter.RenderVector$ui_release(str2, f6, f5, function4, composer, 32768 | (i4 & 14) | (i4 & 7168));
        composer.endReplaceableGroup();
        EffectsKt.SideEffect(new VectorPainterKt$rememberVectorPainter$1(vectorPainter, r5, r7), composer2, 0);
        composer.endReplaceableGroup();
        return vectorPainter;
    }

    public static final VectorPainter rememberVectorPainter(ImageVector imageVector, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(imageVector, "image");
        composer.startReplaceableGroup(-1998939043);
        ComposerKt.sourceInformation(composer, "C(rememberVectorPainter)105@4363L385:VectorPainter.kt#huu6hf");
        VectorPainter r12 = m2222rememberVectorPaintermlNsNFs(imageVector.m2187getDefaultWidthD9Ej5fM(), imageVector.m2186getDefaultHeightD9Ej5fM(), imageVector.getViewportWidth(), imageVector.getViewportHeight(), imageVector.getName(), imageVector.m2189getTintColor0d7_KjU(), imageVector.m2188getTintBlendMode0nO6VwU(), ComposableLambdaKt.composableLambda(composer, -819890981, true, new VectorPainterKt$rememberVectorPainter$2(imageVector)), composer, 12582912, 0);
        composer.endReplaceableGroup();
        return r12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RenderVectorGroup(androidx.compose.ui.graphics.vector.VectorGroup r23, java.util.Map<java.lang.String, ? extends androidx.compose.ui.graphics.vector.VectorConfig> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r0 = r23
            r1 = r26
            r2 = r27
            java.lang.String r3 = "group"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = -326288533(0xffffffffec8d3b6b, float:-1.365913E27)
            r4 = r25
            androidx.compose.runtime.Composer r3 = r4.startRestartGroup(r3)
            java.lang.String r4 = "C(RenderVectorGroup)P(1):VectorPainter.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r2 & 1
            r5 = 2
            if (r4 == 0) goto L_0x0021
            r4 = r1 | 6
            goto L_0x0031
        L_0x0021:
            r4 = r1 & 14
            if (r4 != 0) goto L_0x0030
            boolean r4 = r3.changed((java.lang.Object) r0)
            if (r4 == 0) goto L_0x002d
            r4 = 4
            goto L_0x002e
        L_0x002d:
            r4 = 2
        L_0x002e:
            r4 = r4 | r1
            goto L_0x0031
        L_0x0030:
            r4 = r1
        L_0x0031:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x0037
            r4 = r4 | 16
        L_0x0037:
            int r7 = ~r2
            r5 = r5 & r7
            if (r5 != 0) goto L_0x004f
            r4 = r4 & 91
            r4 = r4 ^ 18
            if (r4 != 0) goto L_0x004f
            boolean r4 = r3.getSkipping()
            if (r4 != 0) goto L_0x0048
            goto L_0x004f
        L_0x0048:
            r3.skipToGroupEnd()
            r2 = r24
            goto L_0x0295
        L_0x004f:
            r3.startDefaults()
            r4 = r1 & 1
            if (r4 == 0) goto L_0x0061
            boolean r4 = r3.getDefaultsInvalid()
            if (r4 == 0) goto L_0x005d
            goto L_0x0061
        L_0x005d:
            r3.skipToGroupEnd()
            goto L_0x0069
        L_0x0061:
            if (r6 == 0) goto L_0x0069
            java.util.Map r4 = kotlin.collections.MapsKt.emptyMap()
            r15 = r4
            goto L_0x006b
        L_0x0069:
            r15 = r24
        L_0x006b:
            r3.endDefaults()
            java.util.Iterator r22 = r23.iterator()
        L_0x0072:
            boolean r4 = r22.hasNext()
            if (r4 == 0) goto L_0x0294
            java.lang.Object r4 = r22.next()
            androidx.compose.ui.graphics.vector.VectorNode r4 = (androidx.compose.ui.graphics.vector.VectorNode) r4
            boolean r5 = r4 instanceof androidx.compose.ui.graphics.vector.VectorPath
            if (r5 == 0) goto L_0x018a
            r5 = -326288360(0xffffffffec8d3c18, float:-1.3659386E27)
            r3.startReplaceableGroup(r5)
            java.lang.String r5 = "266@9529L1719"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r5)
            r17 = r4
            androidx.compose.ui.graphics.vector.VectorPath r17 = (androidx.compose.ui.graphics.vector.VectorPath) r17
            java.lang.String r4 = r17.getName()
            java.lang.Object r4 = r15.get(r4)
            androidx.compose.ui.graphics.vector.VectorConfig r4 = (androidx.compose.ui.graphics.vector.VectorConfig) r4
            if (r4 != 0) goto L_0x00a4
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1 r4 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
            r4.<init>()
            androidx.compose.ui.graphics.vector.VectorConfig r4 = (androidx.compose.ui.graphics.vector.VectorConfig) r4
        L_0x00a4:
            r14 = r4
            androidx.compose.ui.graphics.vector.VectorProperty$PathData r4 = androidx.compose.ui.graphics.vector.VectorProperty.PathData.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r4 = (androidx.compose.ui.graphics.vector.VectorProperty) r4
            java.util.List r5 = r17.getPathData()
            java.lang.Object r4 = r14.getOrDefault(r4, r5)
            java.util.List r4 = (java.util.List) r4
            int r5 = r17.m2223getPathFillTypeRgk1Os()
            java.lang.String r6 = r17.getName()
            androidx.compose.ui.graphics.vector.VectorProperty$Fill r7 = androidx.compose.ui.graphics.vector.VectorProperty.Fill.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            androidx.compose.ui.graphics.Brush r8 = r17.getFill()
            java.lang.Object r7 = r14.getOrDefault(r7, r8)
            androidx.compose.ui.graphics.Brush r7 = (androidx.compose.ui.graphics.Brush) r7
            androidx.compose.ui.graphics.vector.VectorProperty$FillAlpha r8 = androidx.compose.ui.graphics.vector.VectorProperty.FillAlpha.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r8 = (androidx.compose.ui.graphics.vector.VectorProperty) r8
            float r9 = r17.getFillAlpha()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.Object r8 = r14.getOrDefault(r8, r9)
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$Stroke r9 = androidx.compose.ui.graphics.vector.VectorProperty.Stroke.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r9 = (androidx.compose.ui.graphics.vector.VectorProperty) r9
            androidx.compose.ui.graphics.Brush r10 = r17.getStroke()
            java.lang.Object r9 = r14.getOrDefault(r9, r10)
            androidx.compose.ui.graphics.Brush r9 = (androidx.compose.ui.graphics.Brush) r9
            androidx.compose.ui.graphics.vector.VectorProperty$StrokeAlpha r10 = androidx.compose.ui.graphics.vector.VectorProperty.StrokeAlpha.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r10 = (androidx.compose.ui.graphics.vector.VectorProperty) r10
            float r11 = r17.getStrokeAlpha()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            java.lang.Object r10 = r14.getOrDefault(r10, r11)
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$StrokeLineWidth r11 = androidx.compose.ui.graphics.vector.VectorProperty.StrokeLineWidth.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r11 = (androidx.compose.ui.graphics.vector.VectorProperty) r11
            float r12 = r17.getStrokeLineWidth()
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Object r11 = r14.getOrDefault(r11, r12)
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            int r12 = r17.m2224getStrokeLineCapKaPHkGw()
            int r13 = r17.m2225getStrokeLineJoinLxFBmk8()
            float r16 = r17.getStrokeLineMiter()
            r0 = r14
            r14 = r16
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathStart r16 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathStart.INSTANCE
            r18 = r15
            r15 = r16
            androidx.compose.ui.graphics.vector.VectorProperty r15 = (androidx.compose.ui.graphics.vector.VectorProperty) r15
            float r16 = r17.getTrimPathStart()
            java.lang.Float r1 = java.lang.Float.valueOf(r16)
            java.lang.Object r1 = r0.getOrDefault(r15, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            float r15 = r1.floatValue()
            r1 = r18
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathEnd r16 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathEnd.INSTANCE
            r2 = r16
            androidx.compose.ui.graphics.vector.VectorProperty r2 = (androidx.compose.ui.graphics.vector.VectorProperty) r2
            float r16 = r17.getTrimPathEnd()
            r24 = r1
            java.lang.Float r1 = java.lang.Float.valueOf(r16)
            java.lang.Object r1 = r0.getOrDefault(r2, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            float r16 = r1.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathOffset r1 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathOffset.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r1 = (androidx.compose.ui.graphics.vector.VectorProperty) r1
            float r2 = r17.getTrimPathOffset()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r0 = r0.getOrDefault(r1, r2)
            java.lang.Number r0 = (java.lang.Number) r0
            float r17 = r0.floatValue()
            r19 = 8
            r20 = 0
            r21 = 0
            r18 = r3
            androidx.compose.ui.graphics.vector.VectorComposeKt.m2215Path9cdaXJ4(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r3.endReplaceableGroup()
            r0 = r23
            r15 = r24
            r1 = r26
            goto L_0x0290
        L_0x018a:
            r24 = r15
            boolean r0 = r4 instanceof androidx.compose.ui.graphics.vector.VectorGroup
            if (r0 == 0) goto L_0x0280
            r0 = -326286502(0xffffffffec8d435a, float:-1.3662128E27)
            r3.startReplaceableGroup(r0)
            java.lang.String r0 = "311@11387L1368"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            r0 = r4
            androidx.compose.ui.graphics.vector.VectorGroup r0 = (androidx.compose.ui.graphics.vector.VectorGroup) r0
            java.lang.String r1 = r0.getName()
            r2 = r24
            java.lang.Object r1 = r2.get(r1)
            androidx.compose.ui.graphics.vector.VectorConfig r1 = (androidx.compose.ui.graphics.vector.VectorConfig) r1
            if (r1 != 0) goto L_0x01b3
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2 r1 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
            r1.<init>()
            androidx.compose.ui.graphics.vector.VectorConfig r1 = (androidx.compose.ui.graphics.vector.VectorConfig) r1
        L_0x01b3:
            java.lang.String r5 = r0.getName()
            androidx.compose.ui.graphics.vector.VectorProperty$Rotation r6 = androidx.compose.ui.graphics.vector.VectorProperty.Rotation.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r6 = (androidx.compose.ui.graphics.vector.VectorProperty) r6
            float r7 = r0.getRotation()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.Object r6 = r1.getOrDefault(r6, r7)
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$ScaleX r7 = androidx.compose.ui.graphics.vector.VectorProperty.ScaleX.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            float r8 = r0.getScaleX()
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            java.lang.Object r7 = r1.getOrDefault(r7, r8)
            java.lang.Number r7 = (java.lang.Number) r7
            float r8 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$ScaleY r7 = androidx.compose.ui.graphics.vector.VectorProperty.ScaleY.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            float r9 = r0.getScaleY()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.Object r7 = r1.getOrDefault(r7, r9)
            java.lang.Number r7 = (java.lang.Number) r7
            float r9 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TranslateX r7 = androidx.compose.ui.graphics.vector.VectorProperty.TranslateX.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            float r10 = r0.getTranslationX()
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            java.lang.Object r7 = r1.getOrDefault(r7, r10)
            java.lang.Number r7 = (java.lang.Number) r7
            float r10 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TranslateY r7 = androidx.compose.ui.graphics.vector.VectorProperty.TranslateY.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            float r11 = r0.getTranslationY()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            java.lang.Object r7 = r1.getOrDefault(r7, r11)
            java.lang.Number r7 = (java.lang.Number) r7
            float r11 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PivotX r7 = androidx.compose.ui.graphics.vector.VectorProperty.PivotX.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r7 = (androidx.compose.ui.graphics.vector.VectorProperty) r7
            float r12 = r0.getPivotX()
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Object r7 = r1.getOrDefault(r7, r12)
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PivotY r12 = androidx.compose.ui.graphics.vector.VectorProperty.PivotY.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r12 = (androidx.compose.ui.graphics.vector.VectorProperty) r12
            float r13 = r0.getPivotY()
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.Object r12 = r1.getOrDefault(r12, r13)
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PathData r13 = androidx.compose.ui.graphics.vector.VectorProperty.PathData.INSTANCE
            androidx.compose.ui.graphics.vector.VectorProperty r13 = (androidx.compose.ui.graphics.vector.VectorProperty) r13
            java.util.List r0 = r0.getClipPathData()
            java.lang.Object r0 = r1.getOrDefault(r13, r0)
            java.util.List r0 = (java.util.List) r0
            r1 = -819898379(0xffffffffcf2157f5, float:-2.70689613E9)
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1 r13 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1
            r13.<init>(r4, r2)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r3, r1, r4, r13)
            r13 = r1
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r15 = 939524096(0x38000000, float:3.0517578E-5)
            r16 = 0
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            r12 = r0
            r14 = r3
            androidx.compose.ui.graphics.vector.VectorComposeKt.Group(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r3.endReplaceableGroup()
            goto L_0x028b
        L_0x0280:
            r2 = r24
            r0 = -326285032(0xffffffffec8d4918, float:-1.3664297E27)
            r3.startReplaceableGroup(r0)
            r3.endReplaceableGroup()
        L_0x028b:
            r0 = r23
            r1 = r26
            r15 = r2
        L_0x0290:
            r2 = r27
            goto L_0x0072
        L_0x0294:
            r2 = r15
        L_0x0295:
            androidx.compose.runtime.ScopeUpdateScope r0 = r3.endRestartGroup()
            if (r0 != 0) goto L_0x029c
            goto L_0x02ac
        L_0x029c:
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2 r1 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2
            r3 = r23
            r4 = r26
            r5 = r27
            r1.<init>(r3, r2, r4, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r0.updateScope(r1)
        L_0x02ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup(androidx.compose.ui.graphics.vector.VectorGroup, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }
}
