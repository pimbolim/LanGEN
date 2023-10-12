package androidx.compose.ui.res;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a)\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bR\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"errorMessage", "", "loadImageBitmapResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "res", "Landroid/content/res/Resources;", "id", "", "loadVectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "(Landroid/content/res/Resources$Theme;Landroid/content/res/Resources;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "painterResource", "Landroidx/compose/ui/graphics/painter/Painter;", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PainterResources.android.kt */
public final class PainterResources_androidKt {
    private static final String errorMessage = "Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: androidx.compose.ui.graphics.ImageBitmap} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.graphics.painter.Painter painterResource(int r9, androidx.compose.runtime.Composer r10, int r11) {
        /*
            r0 = -738265664(0xffffffffd3fef5c0, float:-2.19008939E12)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C(painterResource)57@2406L7,59@2462L25:PainterResources.android.kt#ccshc7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 103361330(0x6292b32, float:3.1817102E-35)
            java.lang.String r2 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r1, r2)
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            android.content.Context r0 = (android.content.Context) r0
            android.content.res.Resources r1 = r0.getResources()
            r2 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r2 != r3) goto L_0x0045
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            r10.updateRememberedValue(r2)
        L_0x0045:
            r10.endReplaceableGroup()
            android.util.TypedValue r2 = (android.util.TypedValue) r2
            r3 = 1
            r1.getValue(r9, r2, r3)
            java.lang.CharSequence r2 = r2.string
            r4 = 0
            if (r2 != 0) goto L_0x0055
        L_0x0053:
            r3 = 0
            goto L_0x0061
        L_0x0055:
            java.lang.String r5 = ".xml"
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 2
            r7 = 0
            boolean r5 = kotlin.text.StringsKt.endsWith$default((java.lang.CharSequence) r2, (java.lang.CharSequence) r5, (boolean) r4, (int) r6, (java.lang.Object) r7)
            if (r5 != r3) goto L_0x0053
        L_0x0061:
            java.lang.String r5 = "res"
            if (r3 == 0) goto L_0x0090
            r2 = -738265321(0xffffffffd3fef717, float:-2.19013435E12)
            r10.startReplaceableGroup(r2)
            java.lang.String r2 = "64@2693L42,65@2744L34"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r2)
            android.content.res.Resources$Theme r0 = r0.getTheme()
            java.lang.String r2 = "context.theme"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            int r11 = r11 << 6
            r11 = r11 & 896(0x380, float:1.256E-42)
            r11 = r11 | 72
            androidx.compose.ui.graphics.vector.ImageVector r9 = loadVectorResource(r0, r1, r9, r10, r11)
            androidx.compose.ui.graphics.vector.VectorPainter r9 = androidx.compose.ui.graphics.vector.VectorPainterKt.rememberVectorPainter(r9, r10, r4)
            r10.endReplaceableGroup()
            androidx.compose.ui.graphics.painter.Painter r9 = (androidx.compose.ui.graphics.painter.Painter) r9
            goto L_0x00e2
        L_0x0090:
            r11 = -738265196(0xffffffffd3fef794, float:-2.19015073E12)
            r10.startReplaceableGroup(r11)
            java.lang.String r11 = "68@2864L75"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)
            r0 = -3686552(0xffffffffffc7bf68, float:NaN)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            boolean r0 = r10.changed((java.lang.Object) r2)
            boolean r11 = r10.changed((java.lang.Object) r11)
            r11 = r11 | r0
            java.lang.Object r0 = r10.rememberedValue()
            if (r11 != 0) goto L_0x00c1
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r0 != r11) goto L_0x00cb
        L_0x00c1:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            androidx.compose.ui.graphics.ImageBitmap r0 = loadImageBitmapResource(r1, r9)
            r10.updateRememberedValue(r0)
        L_0x00cb:
            r10.endReplaceableGroup()
            r2 = r0
            androidx.compose.ui.graphics.ImageBitmap r2 = (androidx.compose.ui.graphics.ImageBitmap) r2
            androidx.compose.ui.graphics.painter.BitmapPainter r9 = new androidx.compose.ui.graphics.painter.BitmapPainter
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r1 = r9
            r1.<init>(r2, r3, r5, r7, r8)
            r10.endReplaceableGroup()
            androidx.compose.ui.graphics.painter.Painter r9 = (androidx.compose.ui.graphics.painter.Painter) r9
        L_0x00e2:
            r10.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.res.PainterResources_androidKt.painterResource(int, androidx.compose.runtime.Composer, int):androidx.compose.ui.graphics.painter.Painter");
    }

    private static final ImageVector loadVectorResource(Resources.Theme theme, Resources resources, int i, Composer composer, int i2) {
        composer.startReplaceableGroup(-995791636);
        ComposerKt.sourceInformation(composer, "C(loadVectorResource)P(2,1)86@3392L7:PainterResources.android.kt#ccshc7");
        ComposerKt.sourceInformationMarkerStart(composer, 103361330, "C:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalImageVectorCache());
        ComposerKt.sourceInformationMarkerEnd(composer);
        ImageVectorCache imageVectorCache = (ImageVectorCache) consume;
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, i);
        ImageVectorCache.ImageVectorEntry imageVectorEntry = imageVectorCache.get(key);
        if (imageVectorEntry == null) {
            XmlResourceParser xml = resources.getXml(i);
            Intrinsics.checkNotNullExpressionValue(xml, "res.getXml(id)");
            if (Intrinsics.areEqual((Object) XmlVectorParser_androidKt.seekToStartTag(xml).getName(), (Object) "vector")) {
                imageVectorEntry = VectorResources_androidKt.loadVectorResourceInner(theme, resources, xml);
                imageVectorCache.set(key, imageVectorEntry);
            } else {
                throw new IllegalArgumentException(errorMessage);
            }
        }
        ImageVector imageVector = imageVectorEntry.getImageVector();
        composer.endReplaceableGroup();
        return imageVector;
    }

    private static final ImageBitmap loadImageBitmapResource(Resources resources, int i) {
        try {
            return ImageResources_androidKt.imageResource(ImageBitmap.Companion, resources, i);
        } catch (Throwable unused) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
