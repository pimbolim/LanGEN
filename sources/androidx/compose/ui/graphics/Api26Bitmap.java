package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.util.DisplayMetrics;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/graphics/Api26Bitmap;", "", "()V", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidImageBitmap.android.kt */
final class Api26Bitmap {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0004H\u0000¢\u0006\u0002\b\u0011J\u0011\u0010\u0010\u001a\u00020\r*\u00020\u0012H\u0000¢\u0006\u0002\b\u0011J\u0011\u0010\u0013\u001a\u00020\u0012*\u00020\rH\u0000¢\u0006\u0002\b\u0014\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/graphics/Api26Bitmap$Companion;", "", "()V", "createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "createBitmap-x__-hDU$ui_graphics_release", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroid/graphics/Bitmap;", "composeColorSpace", "composeColorSpace$ui_graphics_release", "Landroid/graphics/ColorSpace;", "toFrameworkColorSpace", "toFrameworkColorSpace$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AndroidImageBitmap.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: createBitmap-x__-hDU$ui_graphics_release  reason: not valid java name */
        public final Bitmap m1499createBitmapx__hDU$ui_graphics_release(int i, int i2, int i3, boolean z, ColorSpace colorSpace) {
            Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
            Bitmap createBitmap = Bitmap.createBitmap((DisplayMetrics) null, i, i2, AndroidImageBitmap_androidKt.m1464toBitmapConfig1JJdX4A(i3), z, toFrameworkColorSpace$ui_graphics_release(colorSpace));
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(\n          …olorSpace()\n            )");
            return createBitmap;
        }

        public final ColorSpace composeColorSpace$ui_graphics_release(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "<this>");
            android.graphics.ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace composeColorSpace$ui_graphics_release = colorSpace == null ? null : composeColorSpace$ui_graphics_release(colorSpace);
            return composeColorSpace$ui_graphics_release == null ? ColorSpaces.INSTANCE.getSrgb() : composeColorSpace$ui_graphics_release;
        }

        public final android.graphics.ColorSpace toFrameworkColorSpace$ui_graphics_release(ColorSpace colorSpace) {
            ColorSpace.Named named;
            Intrinsics.checkNotNullParameter(colorSpace, "<this>");
            if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getSrgb())) {
                named = ColorSpace.Named.SRGB;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getAces())) {
                named = ColorSpace.Named.ACES;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getAcescg())) {
                named = ColorSpace.Named.ACESCG;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getAdobeRgb())) {
                named = ColorSpace.Named.ADOBE_RGB;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getBt2020())) {
                named = ColorSpace.Named.BT2020;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getBt709())) {
                named = ColorSpace.Named.BT709;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getCieLab())) {
                named = ColorSpace.Named.CIE_LAB;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getCieXyz())) {
                named = ColorSpace.Named.CIE_XYZ;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getDciP3())) {
                named = ColorSpace.Named.DCI_P3;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getDisplayP3())) {
                named = ColorSpace.Named.DISPLAY_P3;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getExtendedSrgb())) {
                named = ColorSpace.Named.EXTENDED_SRGB;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getLinearExtendedSrgb())) {
                named = ColorSpace.Named.LINEAR_EXTENDED_SRGB;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getLinearSrgb())) {
                named = ColorSpace.Named.LINEAR_SRGB;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getNtsc1953())) {
                named = ColorSpace.Named.NTSC_1953;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getProPhotoRgb())) {
                named = ColorSpace.Named.PRO_PHOTO_RGB;
            } else if (Intrinsics.areEqual((Object) colorSpace, (Object) ColorSpaces.INSTANCE.getSmpteC())) {
                named = ColorSpace.Named.SMPTE_C;
            } else {
                named = ColorSpace.Named.SRGB;
            }
            android.graphics.ColorSpace colorSpace2 = android.graphics.ColorSpace.get(named);
            Intrinsics.checkNotNullExpressionValue(colorSpace2, "get(frameworkNamedSpace)");
            return colorSpace2;
        }

        public final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace$ui_graphics_release(android.graphics.ColorSpace colorSpace) {
            Intrinsics.checkNotNullParameter(colorSpace, "<this>");
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.SRGB))) {
                return ColorSpaces.INSTANCE.getSrgb();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.ACES))) {
                return ColorSpaces.INSTANCE.getAces();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.ACESCG))) {
                return ColorSpaces.INSTANCE.getAcescg();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.ADOBE_RGB))) {
                return ColorSpaces.INSTANCE.getAdobeRgb();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.BT2020))) {
                return ColorSpaces.INSTANCE.getBt2020();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.BT709))) {
                return ColorSpaces.INSTANCE.getBt709();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.CIE_LAB))) {
                return ColorSpaces.INSTANCE.getCieLab();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.CIE_XYZ))) {
                return ColorSpaces.INSTANCE.getCieXyz();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.DCI_P3))) {
                return ColorSpaces.INSTANCE.getDciP3();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.DISPLAY_P3))) {
                return ColorSpaces.INSTANCE.getDisplayP3();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.EXTENDED_SRGB))) {
                return ColorSpaces.INSTANCE.getExtendedSrgb();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB))) {
                return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.LINEAR_SRGB))) {
                return ColorSpaces.INSTANCE.getLinearSrgb();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.NTSC_1953))) {
                return ColorSpaces.INSTANCE.getNtsc1953();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.PRO_PHOTO_RGB))) {
                return ColorSpaces.INSTANCE.getProPhotoRgb();
            }
            if (Intrinsics.areEqual((Object) colorSpace, (Object) android.graphics.ColorSpace.get(ColorSpace.Named.SMPTE_C))) {
                return ColorSpaces.INSTANCE.getSmpteC();
            }
            return ColorSpaces.INSTANCE.getSrgb();
        }
    }
}
