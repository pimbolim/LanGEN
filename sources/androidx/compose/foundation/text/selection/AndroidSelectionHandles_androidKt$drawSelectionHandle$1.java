package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$drawSelectionHandle$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$drawSelectionHandle$1(boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        super(3);
        this.$isStartHandle = z;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1183154520);
        ComposerKt.sourceInformation(composer, "C97@3423L7:AndroidSelectionHandles.android.kt#eksfi3");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
        ComposerKt.sourceInformationMarkerEnd(composer);
        final long r1 = ((TextSelectionColors) consume).m822getHandleColor0d7_KjU();
        final boolean z = this.$isStartHandle;
        final ResolvedTextDirection resolvedTextDirection = this.$direction;
        final boolean z2 = this.$handlesCrossed;
        Modifier then = modifier.then(DrawModifierKt.drawWithCache(Modifier.Companion, new Function1<CacheDrawScope, DrawResult>() {
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
                final ImageBitmap createHandleImage = AndroidSelectionHandles_androidKt.createHandleImage(cacheDrawScope, Size.m1422getWidthimpl(cacheDrawScope.m1271getSizeNHjbRc()) / 2.0f);
                final ColorFilter r6 = ColorFilter.Companion.m1637tintxETnrds$default(ColorFilter.Companion, r1, 0, 2, (Object) null);
                final boolean z = z;
                final ResolvedTextDirection resolvedTextDirection = resolvedTextDirection;
                final boolean z2 = z2;
                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ContentDrawScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ContentDrawScope contentDrawScope) {
                        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                        contentDrawScope.drawContent();
                        if (AndroidSelectionHandles_androidKt.isLeft(z, resolvedTextDirection, z2)) {
                            ImageBitmap imageBitmap = createHandleImage;
                            ColorFilter colorFilter = r6;
                            DrawScope drawScope = contentDrawScope;
                            long r4 = drawScope.m2091getCenterF1C5BW0();
                            DrawContext drawContext = drawScope.getDrawContext();
                            long r12 = drawContext.m2070getSizeNHjbRc();
                            drawContext.getCanvas().save();
                            drawContext.getTransform().m2147scale0AR0LA0(-1.0f, 1.0f, r4);
                            DrawScope.DefaultImpls.m2102drawImagegbVJVH8$default(drawScope, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
                            drawContext.getCanvas().restore();
                            drawContext.m2071setSizeuvyYCjk(r12);
                            return;
                        }
                        DrawScope.DefaultImpls.m2102drawImagegbVJVH8$default(contentDrawScope, createHandleImage, 0, 0.0f, (DrawStyle) null, r6, 0, 46, (Object) null);
                    }
                });
            }
        }));
        composer.endReplaceableGroup();
        return then;
    }
}
