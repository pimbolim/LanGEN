package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidCursorHandle.android.kt */
final class AndroidCursorHandle_androidKt$drawCursorHandle$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public static final AndroidCursorHandle_androidKt$drawCursorHandle$1 INSTANCE = new AndroidCursorHandle_androidKt$drawCursorHandle$1();

    AndroidCursorHandle_androidKt$drawCursorHandle$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-216257554);
        ComposerKt.sourceInformation(composer, "C63@2247L7:AndroidCursorHandle.android.kt#423gt5");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
        ComposerKt.sourceInformationMarkerEnd(composer);
        final long r0 = ((TextSelectionColors) consume).m822getHandleColor0d7_KjU();
        Modifier then = modifier.then(DrawModifierKt.drawWithCache(Modifier.Companion, new Function1<CacheDrawScope, DrawResult>() {
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
                final float r0 = Size.m1422getWidthimpl(cacheDrawScope.m1271getSizeNHjbRc()) / 2.0f;
                final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, r0);
                final ColorFilter r2 = ColorFilter.Companion.m1637tintxETnrds$default(ColorFilter.Companion, r0, 0, 2, (Object) null);
                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ContentDrawScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ContentDrawScope contentDrawScope) {
                        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                        contentDrawScope.drawContent();
                        DrawScope drawScope = contentDrawScope;
                        float f = r0;
                        ImageBitmap imageBitmap = createHandleImage;
                        ColorFilter colorFilter = r2;
                        DrawContext drawContext = drawScope.getDrawContext();
                        long r11 = drawContext.m2070getSizeNHjbRc();
                        drawContext.getCanvas().save();
                        DrawTransform transform = drawContext.getTransform();
                        DrawTransform.DefaultImpls.translate$default(transform, f, 0.0f, 2, (Object) null);
                        transform.m2146rotateUv8p0NA(45.0f, Offset.Companion.m1369getZeroF1C5BW0());
                        DrawScope.DefaultImpls.m2102drawImagegbVJVH8$default(drawScope, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
                        drawContext.getCanvas().restore();
                        drawContext.m2071setSizeuvyYCjk(r11);
                    }
                });
            }
        }));
        composer.endReplaceableGroup();
        return then;
    }
}
