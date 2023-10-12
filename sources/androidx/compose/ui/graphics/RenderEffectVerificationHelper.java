package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/graphics/RenderEffectVerificationHelper;", "", "()V", "createBlurEffect", "Landroid/graphics/RenderEffect;", "inputRenderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "createBlurEffect-8A-3gB4", "(Landroidx/compose/ui/graphics/RenderEffect;FFI)Landroid/graphics/RenderEffect;", "createOffsetEffect", "offset", "Landroidx/compose/ui/geometry/Offset;", "createOffsetEffect-Uv8p0NA", "(Landroidx/compose/ui/graphics/RenderEffect;J)Landroid/graphics/RenderEffect;", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidRenderEffect.android.kt */
final class RenderEffectVerificationHelper {
    public static final RenderEffectVerificationHelper INSTANCE = new RenderEffectVerificationHelper();

    private RenderEffectVerificationHelper() {
    }

    /* renamed from: createBlurEffect-8A-3gB4  reason: not valid java name */
    public final RenderEffect m1863createBlurEffect8A3gB4(RenderEffect renderEffect, float f, float f2, int i) {
        if (renderEffect == null) {
            RenderEffect createBlurEffect = RenderEffect.createBlurEffect(f, f2, AndroidTileMode_androidKt.m1497toAndroidTileMode0vamqd0(i));
            Intrinsics.checkNotNullExpressionValue(createBlurEffect, "{\n            android.gr…)\n            )\n        }");
            return createBlurEffect;
        }
        RenderEffect createBlurEffect2 = RenderEffect.createBlurEffect(f, f2, renderEffect.asAndroidRenderEffect(), AndroidTileMode_androidKt.m1497toAndroidTileMode0vamqd0(i));
        Intrinsics.checkNotNullExpressionValue(createBlurEffect2, "{\n            android.gr…)\n            )\n        }");
        return createBlurEffect2;
    }

    /* renamed from: createOffsetEffect-Uv8p0NA  reason: not valid java name */
    public final RenderEffect m1864createOffsetEffectUv8p0NA(RenderEffect renderEffect, long j) {
        if (renderEffect == null) {
            RenderEffect createOffsetEffect = RenderEffect.createOffsetEffect(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j));
            Intrinsics.checkNotNullExpressionValue(createOffsetEffect, "{\n            android.gr…et.x, offset.y)\n        }");
            return createOffsetEffect;
        }
        RenderEffect createOffsetEffect2 = RenderEffect.createOffsetEffect(Offset.m1353getXimpl(j), Offset.m1354getYimpl(j), renderEffect.asAndroidRenderEffect());
        Intrinsics.checkNotNullExpressionValue(createOffsetEffect2, "{\n            android.gr…)\n            )\n        }");
        return createOffsetEffect2;
    }
}
